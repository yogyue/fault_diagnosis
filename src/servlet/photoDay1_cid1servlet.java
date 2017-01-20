package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.swing.JOptionPane;



import bean.Building;
import bean.checkData;
import bean.user;
import bean.Dtree;
import dbConnector.dbCon;

public class photoDay1_cid1servlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {

		doPost(req, resp);
	}
	
	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");

		//20140925 12  ȡֵ ��������BName����ʽWay��username��data��time1��time2
		//ͨ��BName�ڱ�Building��ȡ��Bid
		//ͨ��Bid Way data time1 time2 Cid �ڱ�CheckData��ȡ��  qualified��remark��photoID��
		//����photoID������·�����ҵ���Ƭ����ȡ�õ���Ƭչ�ֳ������������һ����鿴��
		
		String BName = request.getParameter("BName");
		String Way = request.getParameter("Way");
		String date = request.getParameter("date");
		String starttime = request.getParameter("starttime");
		String endtime = request.getParameter("endtime");
		
		String Bid="";
		Building b = new Building();
		checkData c = new checkData();
		checkData p = new checkData();
		//ͨ��BName���ҵ�Bid
		try{
			dbCon con = new dbCon();
			String sql = "select * from Building where BName ='"+BName+"';";
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if(rs.next()){
				b.setBid(rs.getString("Bid"));
				b.setBname(rs.getString("BName"));
				
				Bid=rs.getString("Bid");
			}
			rs.close();
			stmt.close();
			con.getCon().close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println("Bid = " + Bid);
		System.out.println("Way = " + Way);
		System.out.println("data = " + date);
		System.out.println("starttime = " + starttime);
		System.out.println("endtime = " + endtime);
		
		ArrayList<checkData> Day1list = new ArrayList<checkData>();
		try{
			dbCon con = new dbCon();
			String sql = "select * from checkData where Bid ='"+Bid+"' and way ='"+Way+"' and data ='"+date+"' and time between '"+starttime+"' and '"+endtime+"';";
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next()){
				checkData d = new checkData();
				d.setBid(rs.getString("Bid"));
				d.setCid(rs.getString("Cid"));
				d.setphotoID(rs.getString("photoID"));
				d.setvideoID(rs.getString("videoID"));
				d.setrecordID(rs.getString("recordID"));
				d.setqualified(rs.getString("qualified"));
				d.setremark(rs.getString("remark"));
				d.setoperatorID(rs.getString("operatorID"));
				Day1list.add(d);
			}
			rs.close();
			stmt.close();
			con.getCon().close();
		}catch(Exception e){
			e.printStackTrace();
		}
		System.out.println(" Day1list.size =  " + Day1list.size() );
		
		//����������һ�������������Դ����״̬ �� �������
		ArrayList<checkData> Cid1Mlist = new ArrayList<checkData>();
		for(int i = 0; i < Day1list.size(); i ++){
			c = (checkData) Day1list.get(i);
			String cid = c.getCid();
			String remark = c.getremark();
			if(cid.equals("��������һ�������������Դ����״̬")){

				c.setCid(c.getCid());
				c.setphotoID(c.getphotoID());
				c.setvideoID(c.getvideoID());
				c.setrecordID(c.getrecordID());
				c.setqualified(c.getqualified());
				c.setremark(c.getremark());
				c.setoperatorID(c.getoperatorID());
				Cid1Mlist.add(c);
			}
		}
		System.out.println(" Cid1Mlist.size =  " + Cid1Mlist.size() );
		//20141010�õ���Cid����Ƭ�洢�����е�ַ�����ظ���
		ArrayList<checkData> Cid1PhotoMlist = new ArrayList<checkData>();
		for(int i = 0; i <  Cid1Mlist.size(); i++){
			System.out.println(" i =  " + i );
			p = (checkData) Cid1Mlist.get(i);
			p.setphotoID(p.getphotoID());
			Cid1PhotoMlist.add(p);
		}
		System.out.println("Cid1PhotoMlist = " + Cid1PhotoMlist);
		
		
		
		//20141010�õ���Cid����Ƭ��û���ظ�·��
		ArrayList<checkData> photolist1 = (ArrayList<checkData>)request.getAttribute("Cid1PhotoMlist");
		ArrayList<checkData> Cid1Photolist = new ArrayList<checkData>();
		p = (checkData) Cid1Mlist.get(1);
		p.setphotoID(p.getphotoID());
		if(photolist1.size()>1){
			for(int i = 2; i <  (photolist1.size()+1); i++){
				p = (checkData) photolist1.get(i);
				for(int j = 1; j < i; j++){
					c =(checkData) photolist1.get(j);
					if(c.equals(p)){
						
					}
					else{
						p.setphotoID(p.getphotoID());
					}
				}
				Cid1Photolist.add(p);
			}
		}
		else{}
		
		
		
		System.out.println("Cid1Photolist = " + Cid1Photolist);
		//20141011���ư�ť�Ŀ�����
		//pre2.Enabled = false;
		
		
		
	
		//����������һ�������������Դ����״̬ ��  ����в��ϸ�ģ������ϸ�ķ���������
		ArrayList<checkData> Cid1list = new ArrayList<checkData>();
		for(int i = 0; i < Cid1Mlist.size(); i ++){
			c = (checkData) Cid1Mlist.get(i);
			String qualified = c.getqualified();
			System.out.println(" qualified =  " + qualified );
			if(qualified.equals("���ϸ�")){
				c.setCid(c.getCid());
				c.setphotoID(c.getphotoID());
				c.setvideoID(c.getvideoID());
				c.setrecordID(c.getrecordID());
				c.setqualified(c.getqualified());
				c.setremark(c.getremark());
				c.setoperatorID(c.getoperatorID());
				Cid1list.add(c);
			}
			else{
				c.setCid(c.getCid());
				c.setphotoID(c.getphotoID());
				c.setvideoID(c.getvideoID());
				c.setrecordID(c.getrecordID());
				c.setqualified(c.getqualified());
				c.setremark(c.getremark());
				c.setoperatorID(c.getoperatorID());
				Cid1list.add(c);
			}
		}
		request.setAttribute("Cid1list", Cid1list);
		System.out.println(" Cid1list.size =  " + Cid1list.size() );
		
		
		//������������������������װ����ۼ�����״̬�������ȼ�ʹ��������ͼ价�� �� �������
				ArrayList<checkData> Cid2Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Day1list.size(); i ++){
					c = (checkData) Day1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("����������������������װ����ۼ�����״̬�������ȼ�ʹ��������ͼ价��")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid2Mlist.add(c);
					}
				}
				
				//������������������������װ����ۼ�����״̬�������ȼ�ʹ��������ͼ价����  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid2list = new ArrayList<checkData>();
				for(int i = 0; i < Cid2Mlist.size(); i ++){
					c = (checkData) Cid2Mlist.get(i);
					String qualified = c.getqualified();
					System.out.println(" qualified =  " + qualified );
					if(qualified.equals("���ϸ�")){
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid2list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid2list.add(c);
					}
				}
				request.setAttribute("Cid2list", Cid2list);
				System.out.println(" Cid2list.size =  " + Cid2list.size() );
				
				//���ͷ��������л�װ�ù���״̬ �� �������
				ArrayList<checkData> Cid3Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Day1list.size(); i ++){
					c = (checkData) Day1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("�ͷ��������л�װ�ù���״̬")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid3Mlist.add(c);
					}
				}
				
				//���ͷ��������л�װ�ù���״̬ ��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid3list = new ArrayList<checkData>();
				for(int i = 0; i < Cid3Mlist.size(); i ++){
					c = (checkData) Cid3Mlist.get(i);
					String qualified = c.getqualified();
					System.out.println(" qualified =  " + qualified );
					if(qualified.equals("���ϸ�")){
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid3list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid3list.add(c);
					}
				}
				request.setAttribute("Cid3list", Cid3list);
				System.out.println(" Cid3list.size =  " + Cid3list.size() );
				
				//�����̷��������л�װ�����״̬ �� �������
				ArrayList<checkData> Cid4Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Day1list.size(); i ++){
					c = (checkData) Day1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("���̷��������л�װ�����״̬")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid4Mlist.add(c);
					}
				}
				
				//�����̷��������л�װ�����״̬ ��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid4list = new ArrayList<checkData>();
				for(int i = 0; i < Cid4Mlist.size(); i ++){
					c = (checkData) Cid4Mlist.get(i);
					String qualified = c.getqualified();
					System.out.println(" qualified =  " + qualified );
					if(qualified.equals("���ϸ�")){
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid4list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid4list.add(c);
					}
				}
				request.setAttribute("Cid4list", Cid4list);
				System.out.println(" Cid4list.size =  " + Cid4list.size() );
				
				//����ѹ�����л�װ�����״̬ �� �������
				ArrayList<checkData> Cid5Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Day1list.size(); i ++){
					c = (checkData) Day1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("��ѹ�����л�װ�����״̬")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid5Mlist.add(c);
					}
				}
				
				//����������һ�������������Դ����״̬ ��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid5list = new ArrayList<checkData>();
				for(int i = 0; i < Cid5Mlist.size(); i ++){
					c = (checkData) Cid5Mlist.get(i);
					String qualified = c.getqualified();
					System.out.println(" qualified =  " + qualified );
					if(qualified.equals("���ϸ�")){
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid5list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid5list.add(c);
					}
				}
				request.setAttribute("Cid5list", Cid5list);
				System.out.println(" Cid5list.size =  " + Cid5list.size() );
				
				//����������л�װ�����״̬ �� �������
				ArrayList<checkData> Cid6Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Day1list.size(); i ++){
					c = (checkData) Day1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("��������л�װ�����״̬")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid6Mlist.add(c);
					}
				}
				
				//����������л�װ�����״̬ ��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid6list = new ArrayList<checkData>();
				for(int i = 0; i < Cid6Mlist.size(); i ++){
					c = (checkData) Cid6Mlist.get(i);
					String qualified = c.getqualified();
					System.out.println(" qualified =  " + qualified );
					if(qualified.equals("���ϸ�")){
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid6list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid6list.add(c);
					}
				}
				request.setAttribute("Cid6list", Cid6list);
				System.out.println(" Cid6list.size =  " + Cid6list.size() );
				
				//�����������л�װ�����״̬ �� �������
				ArrayList<checkData> Cid7Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Day1list.size(); i ++){
					c = (checkData) Day1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("���������л�װ�����״̬")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid7Mlist.add(c);
					}
				}
				
				//�����������л�װ�����״̬ ��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid7list = new ArrayList<checkData>();
				for(int i = 0; i < Cid7Mlist.size(); i ++){
					c = (checkData) Cid7Mlist.get(i);
					String qualified = c.getqualified();
					System.out.println(" qualified =  " + qualified );
					if(qualified.equals("���ϸ�")){
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid7list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid7list.add(c);
					}
				}
				request.setAttribute("Cid7list", Cid7list);
				System.out.println(" Cid7list.size =  " + Cid7list.size() );
				
				//�����ֱ����������л�װ�����״̬ �� �������
				ArrayList<checkData> Cid8Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Day1list.size(); i ++){
					c = (checkData) Day1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("���ֱ����������л�װ�����״̬")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid8Mlist.add(c);
					}
				}
				
				//�����ֱ����������л�װ�����״̬��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid8list = new ArrayList<checkData>();
				for(int i = 0; i < Cid8Mlist.size(); i ++){
					c = (checkData) Cid8Mlist.get(i);
					String qualified = c.getqualified();
					System.out.println(" qualified =  " + qualified );
					if(qualified.equals("���ϸ�")){
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid8list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid8list.add(c);
					}
				}
				request.setAttribute("Cid8list", Cid8list);
				System.out.println(" Cid8list.size =  " + Cid8list.size() );		
	
		request.getRequestDispatcher("/contentDay1.jsp?").forward(request,
				response);
		
		/*checkData cid1 =new checkData();
		if(null != Cid1Mlist && Cid1Mlist.size() > 0){
			cid1=(checkData)Cid1Mlist.get(Cid1Mlist.size()-1);
		}
		String path;
		if(null != Cid1Mlist && Cid1Mlist.size() > 0){
	      path = cid1.getphotoID();
	
		}*/
		}
  }
	
	

	


