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
 * �ô�������ʵ����Ƭ�鿴���Ĺ���
 * �����¡��Ҽ�ͷ��ʱ�����һ��ͼƬ
 * �����¡����ͷ"ʱ�����һ��ͼƬ
 * ʵ��ѭ�����
 * ������"Ecs"ʱ�Ƴ�ȫ�����ģʽ
 * ������CTRL+���ϼ�ͷ��ʱ��ȫ����ʾ
 * ֻ�����ָ���ļ����������֧�ָ�ʽ��ͼƬ��gif,jpg,png��
 *����Ĵ�С���������Ǳ����1
 */

public class PicsViewer {
	static JFrame frame0;// ԭʼ��ȫ����ʾ�Ĵ���
	// static int SWidth=Toolkit.getDefaultToolkit().getScreenSize().width;
	// static int SHeight=Toolkit.getDefaultToolkit().getScreenSize().height;
	static int SWidth = 1000;
	static int SHeight = 720;
	private Dimension arcSize = new Dimension(SWidth, SHeight);
	static Image icon = (new ImageIcon("PicsViewer/img.png")).getImage();// ���ͼ��
	JFileChooser chooser; // ����һ���ļ�ѡ��������
	static JPanel imgjp;
	static JPanel buttonPanel;
	static JButton prior;
	static JButton next;
	static Image img0 = (new ImageIcon("image/cat.png")).getImage();// Ĭ�ϵ�һ��ͼƬ
	File files;
	static int j = 0;
	static int k = 0;
	static File root;
	static int i = 0;
	Timer T00;
	String[] Str;// ��ȡ�ļ����ַ���
	static Image img;
	static int xCoor, yCoor;// ��ӡͼƬ�����Ͻ�����
	static int PWidth, PHeight;// ͼƬ�Ŀ��(С����Ļ��ߵ�ʱ���)
	static int PWidth0, PHeight0;// ͼƬ��ߴ�����Ļ��ߵ�ʱ���ͼƬ���
	String CPath;// ֱ�ӻ�õ�·��
	String newPath;// ����ת�����·��
	static List<Image> list = new LinkedList<Image>();
	int index = 0;
	static int index0 = 0;
	static double xCoor0 = 1, yCoor0 = 1;// ͼƬ��X�����ŵı�����ͼƬ��Y������ű�����
	static boolean isFull = true;// �Ƿ�ȫ����ʾ
	static int now;// ��ǰ����ʹ�õ�ͼƬ

	public PicsViewer() {
		frame0 = new JFrame();
		imgjp = new ImgsPanel();
		imgjp.setBackground(new Color(51, 51, 51));
		JPanel jp = new JPanel();

		JLabel jl = new JLabel("�Ǻ�");// ����JLabel��Ĭ���ı�Ϊ"�Ǻ�"��Ĭ�ϴ�ֱ����
		jp.add(jl);// JPanel���JLabel���

		prior = new JButton("��һ��");
		// prior.addActionListener(this);

		next = new JButton("��һ��");
		// .addActionListener(this);

		buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 5));
		buttonPanel.add(prior);
		buttonPanel.add(next);
		frame0.add(imgjp);
		frame0.add(buttonPanel, BorderLayout.SOUTH);
		frame0.add(jp, BorderLayout.NORTH);// JFrame���JPanel���
		frame0.setTitle("PicsViewer1.0");

		// frame0.setUndecorated(true);
		frame0.setBackground(new Color(0, 0, 0, 0));
		frame0.setDefaultLookAndFeelDecorated(true);
		// frame0.setUndecorated(isFull);
		frame0.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		// �����ô��ڵ�λ�ã�����Ϊ����Ĭ�ϵ�λ�þ�������������Ͻ�
		frame0.setIconImage(icon);// ���ô���ͼ��
		frame0.setVisible(true);
		frame0.setSize(arcSize);
		// ����JFrame�Ƿ���Ըı��С��
		frame0.setResizable(false);
		// JFrame�򿪺���С�
		frame0.setLocationRelativeTo(null);

		/*
		 * ����һ�����͵����ļ�ѡ��Ի������û�ѡ����Ҫ�����ͼƬ
		 */
		try {
			UIManager
					.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");// ����Ϊ��ǰ����ϵͳ�����
			JFileChooser chooser = new JFileChooser();
			chooser.setDialogTitle("��ѡ��Ҫ�鿴��ͼƬ");
			chooser.addChoosableFileFilter(new FileNameExtensionFilter(
					"����ͼƬ��ʽ", "jpg", "gif", "png"));
			chooser.showOpenDialog(frame0);
			int returnVal = chooser.showOpenDialog(frame0);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				img = (new ImageIcon(chooser.getSelectedFile().toString()))
						.getImage();
				CPath = chooser.getCurrentDirectory().toString()
						+ System.getProperty("file.separator");
				newPath = CPath.replaceAll("\\\\", "/");// ·��ת��
				newPath = "D:/�о���/���/��ˮ���/��ˮ���";
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
		 * ��Ӽ��̼����¼�������������ϵķ�����Ҽ�ʱ�����һ��ͼƬ��������ͷ�����һ�ţ��������ϼ�ͷʱ�Ե�ǰͼƬ���зŴ����
		 * �������¼�ͷʱ���Ե�ǰ�����ͼƬ������С���� ͬʱ��������ּ����¼���Ҳ�Ե�ǰͼƬ�������Ų���
		 */
		imgjp.addMouseWheelListener(new MouseWheelListener() {
			public void mouseWheelMoved(MouseWheelEvent e) {
				if (e.getWheelRotation() < 0) {// ������������Ϲ�������Ŵ�ͼƬ

				} else {// ������СͼƬ

				}

			}

		});

	}

	public void findImage(File dir) {
		File[] files = dir.listFiles();// �õ���ǰ·���µ������ļ����ļ���
		for (int i = 0; i < files.length; i++) {
			Str = new String[files.length];
			Str[i] = files[i].getAbsolutePath();// ��·�����ļ��������ַ�������
			// ʹ�������������
			if (Str[i].endsWith(".jpg") || Str[i].endsWith(".gif")
					|| Str[i].endsWith(".png") == true) {
				list.add(index, (new ImageIcon(Str[i])).getImage());
				index++;
			}
		}

	}

	// ��ͼ���㷨�е����⣿������
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
				Trans.scale(xCoor0, yCoor0);// ��ͼƬ�����Ų���
				// G2.setTransform(Trans);
			}
			if (PWidth > SWidth || PHeight > SHeight) {
				yCoor0 = SHeight / (PHeight * 1.0);
				PHeight0 = SHeight;
				PWidth0 = (int) (PWidth * yCoor0);
				xCoor0 = yCoor0;
				xCoor = (SWidth - PWidth0) / 2;
				yCoor = -(PHeight0 - SHeight) / 2;
				Trans.scale(xCoor0, yCoor0);// ��ͼƬ�����Ų���
				// G2.setTransform(Trans);
			}
			G2.drawImage(img0, xCoor, yCoor, PWidth0, PHeight0, this);

		}
	}

	static class Tim implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// ����������ò�Ҫ����ͬ�ı�����
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

				// ��������¼��Ǽ����¼�.

				KeyEvent keyEvent = (KeyEvent) e;
				if (keyEvent.getID() == KeyEvent.KEY_PRESSED) {

					keyPressed(keyEvent);

				} else if (keyEvent.getID() == KeyEvent.KEY_RELEASED) {

					keyReleased(keyEvent);

				}

			}

		}

		/*
		 * ��ֻ��һ��ͼƬ���׳��쳣������ʹ�����ҷ�����������
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
				frame0.setIconImage(icon);// ���ô���ͼ��
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
