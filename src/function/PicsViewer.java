package function;

import java.awt.AWTEvent;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.AWTEventListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;
import java.awt.geom.AffineTransform;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * 该代码意在实现照片查看器的功能
 * 当按下“右箭头”时浏览下一张图片
 * 当按下“左箭头"时浏览上一张图片
 * 实现循环浏览
 * 当按下"Ecs"时推出全屏浏览模式
 * 当按下CTRL+“上箭头”时，全屏显示
 * 只能浏览指定文件夹下面的所支持格式的图片（gif,jpg,png）
 *链表的大小与他的最大角标相隔1
 */

public class PicsViewer {
	static JFrame frame0;// 原始的全屏显示的窗口
	// static int SWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
	// static int SHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
	static int SWidth = 1000;
	static int SHeight = 720;
	private Dimension arcSize = new Dimension(SWidth, SHeight);
	static Image icon = (new ImageIcon("PicsViewer/img.png")).getImage();// 框架图标
	JFileChooser chooser; // 声明一个文件选择器对象
	static JPanel imgjp;
	static JPanel buttonPanel;
	static JButton prior;
	static JButton next;
	static Image img0 = (new ImageIcon("image/cat.png")).getImage();// 默认的一张图片
	File files;
	static int j = 0;
	static int k = 0;
	static File root;
	static int i = 0;
	Timer T00;
	String[] Str;// 获取文件名字符串
	static Image img;
	static int xCoor, yCoor;// 打印图片的左上角坐标
	static int PWidth, PHeight;// 图片的宽高(小于屏幕宽高的时候的)
	static int PWidth0, PHeight0;// 图片宽高大于屏幕宽高的时候的图片宽高
	String CPath;// 直接获得的路径
	String newPath;// 经过转换后的路径
	static List<Image> list = new LinkedList<Image>();
	int index = 0;
	static int index0 = 0;
	static double xCoor0 = 1, yCoor0 = 1;// 图片在X轴缩放的倍数，图片在Y轴的缩放倍数；
	static boolean isFull = true;// 是否全屏显示
	static int now;// 当前正在使用的图片

	public PicsViewer() {
		frame0 = new JFrame();
		imgjp = new ImgsPanel();
		imgjp.setBackground(new Color(51, 51, 51));
		JPanel jp = new JPanel();

		JLabel jl = new JLabel("呵呵");// 创建JLabel并默认文本为"呵呵"，默认垂直居中
		jp.add(jl);// JPanel添加JLabel组件

		prior = new JButton("上一张");
		// prior.addActionListener(this);

		next = new JButton("下一张");
		// .addActionListener(this);

		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		buttonPanel.add(prior);
		buttonPanel.add(next);
		frame0.add(imgjp);
		frame0.add(buttonPanel, BorderLayout.SOUTH);
		frame0.add(jp, BorderLayout.NORTH);// JFrame添加JPanel组件
		frame0.setTitle("PicsViewer1.0");

		// frame0.setUndecorated(true);
		frame0.setBackground(new Color(0, 0, 0, 0));
		frame0.setDefaultLookAndFeelDecorated(true);
		// frame0.setUndecorated(isFull);
		frame0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// 不设置窗口的位置，是因为窗口默认的位置就是在桌面的左上角
		frame0.setIconImage(icon);// 设置窗口图标
		frame0.setVisible(true);
		frame0.setSize(arcSize);
		// 设置JFrame是否可以改变大小。
		frame0.setResizable(false);
		// JFrame打开后居中。
		frame0.setLocationRelativeTo(null);

		/*
		 * 程序一启动就弹出文件选择对话框让用户选择所要浏览的图片
		 */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// 设置为当前操作系统的外观
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("请选择要查看的图片");
			chooser.addChoosableFileFilter(new FileNameExtensionFilter(
					"常见图片格式", "jpg", "gif", "png"));
			chooser.showOpenDialog(frame0);
			int returnVal = chooser.showOpenDialog(frame0);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				img = (new ImageIcon(chooser.getSelectedFile().toString()))
						.getImage();
				CPath = chooser.getCurrentDirectory().toString()
						+ System.getProperty("file.separator");
				newPath = CPath.replaceAll("\\\\", "/");// 路径转换
				newPath = "D:/研究生/横河/污水监控/污水监控";
				root = new File(newPath);
				img0 = img;
				imgjp.repaint();
				findImage(root);

			}

		} catch (Exception evt) {
		}
		Toolkit toolkit = Toolkit.getDefaultToolkit();
		toolkit.addAWTEventListener(new ShortcutKeyListener(),
				AWTEvent.KEY_EVENT_MASK | AWTEvent.MOUSE_EVENT_MASK
						| AWTEvent.WINDOW_EVENT_MASK);

		/*
		 * 添加键盘监听事件，当点击键盘上的方向键右键时浏览下一张图片，点击左箭头浏览上一张，当按下上箭头时对当前图片进行放大操作
		 * 当按下下箭头时，对当前浏览的图片进行缩小操作 同时添加鼠标滚轮监听事件，也对当前图片进行缩放操作
		 */
		imgjp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() < 0) {// 如果鼠标滚轮向上滚动，则放大图片

				} else {// 否则缩小图片

				}

			}

		});

	}

	public void findImage(File dir) {
		File[] files = dir.listFiles();// 得到当前路径下的所有文件和文件夹
		for (int i = 0; i < files.length; i++) {
			Str = new String[files.length];
			Str[i] = files[i].getAbsolutePath();// 将路径和文件名存入字符串数组
			// 使用链表替代数组
			if (Str[i].endsWith(".jpg") || Str[i].endsWith(".gif")
					|| Str[i].endsWith(".png") == true) {
				list.add(index, (new ImageIcon(Str[i])).getImage());
				index++;
			}
		}

	}

	// 画图的算法有点问题？？？？
	static class ImgsPanel extends JPanel {
		private static final long serialVersionUID = 1L;

		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			Graphics2D G2 = (Graphics2D) g;
			AffineTransform Trans = new AffineTransform();
			PWidth = img0.getWidth(null);
			PHeight = img0.getHeight(null);
			if (PWidth <= SWidth && PHeight <= SHeight) {
				xCoor = (SWidth - PWidth) / 2;
				yCoor = (SHeight - PHeight) / 2;
				PWidth0 = PWidth;
				PHeight0 = PHeight;
				Trans.scale(xCoor0, yCoor0);// 对图片的缩放操作
				// G2.setTransform(Trans);
			}
			if (PWidth > SWidth || PHeight > SHeight) {
				yCoor0 = SHeight / (PHeight * 1.0);
				PHeight0 = SHeight;
				PWidth0 = (int) (PWidth * yCoor0);
				xCoor0 = yCoor0;
				xCoor = (SWidth - PWidth0) / 2;
				yCoor = -(PHeight0 - SHeight) / 2;
				Trans.scale(xCoor0, yCoor0);// 对图片的缩放操作
				// G2.setTransform(Trans);
			}
			G2.drawImage(img0, xCoor, yCoor, PWidth0, PHeight0, this);

		}
	}

	static class Tim implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// 看来变量最好不要用相同的变量名
			img0 = (Image) (list.get(index0));
			index0++;
			if (index0 == list.size()) {
				index0 = 0;
				img0 = (Image) (list.get(index0));
				index0++;
				imgjp.repaint();
			}
			imgjp.repaint();
		}
	}

	static class ShortcutKeyListener implements AWTEventListener {
		public void eventDispatched(AWTEvent e) {
			if (e.getClass() == KeyEvent.class) {

				// 被处理的事件是键盘事件.

				KeyEvent keyEvent = (KeyEvent) e;
				if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {

					keyPressed(keyEvent);

				} else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {

					keyReleased(keyEvent);

				}

			}

		}

		/*
		 * 当只有一张图片是抛出异常，不能使用左右方向键，待解决
		 */
		private void keyPressed(KeyEvent e) {
			switch (e.getKeyCode()) {
			case KeyEvent.VK_RIGHT:
				if (list.size() != 1) {
					img0 = (Image) (list.get(index0));
					now = index0;
					index0++;
					if (index0 == list.size() - 1) {
						index0 = 0;
						img0 = (Image) (list.get(index0));
						now = index0;
						index0++;
						imgjp.repaint();
					}
					imgjp.repaint();
				} else {
					img0 = (Image) (list.get(index0));
					imgjp.repaint();
				}
				break;
			case KeyEvent.VK_LEFT:
				if (list.size() != 1) {
					if (index0 > 0) {
						img0 = (Image) (list.get(index0));
						now = index0;
						index0--;
						imgjp.repaint();
					}
					if (index0 < 0) {
						index0 = list.size() - 1;
						img0 = (Image) (list.get(index0));
						now = index0;
						index0--;
						imgjp.repaint();
					}
				} else {
					index0 = list.size() - 1;
					img0 = (Image) (list.get(index0));
					now = index0;
					index0--;
					imgjp.repaint();
				}
				break;
			case KeyEvent.VK_ESCAPE:
				isFull = false;
				frame0 = new JFrame();
				imgjp = new ImgsPanel();
				imgjp.setBackground(new Color(51, 51, 51));
				frame0.add(imgjp);
				frame0.setTitle("PicsViewer1.0");
				frame0.setSize(SWidth, SHeight);
				frame0.setUndecorated(isFull);
				frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame0.setIconImage(icon);// 设置窗口图标
				frame0.setVisible(true);
				break;

			}
			if ((e.isControlDown() == true)
					&& (e.getKeyCode() == KeyEvent.VK_UP)) {
				isFull = true;
				frame0 = new JFrame();
				imgjp = new ImgsPanel();
				imgjp.setBackground(new Color(51, 51, 51));
				frame0.add(imgjp);
				frame0.setTitle("PicsViewer1.0");
				frame0.setSize(SWidth, SHeight);
				frame0.setUndecorated(isFull);
				frame0.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame0.setIconImage(icon);
				frame0.setVisible(true);

			}

		}

		private void keyReleased(KeyEvent event) {
		}

	}

}
