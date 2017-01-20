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
import bean.bus;
import bean.checkData;
import bean.Dtree;
import dbConnector.dbCon;

public class contentMonth1servlet extends HttpServlet {

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

		String[] option = date.split("-");
		String year = option[0];
		String month = option[1];
		System.out.println("year = " + year);
		System.out.println("month = " + month);
		//String starttime = request.getParameter("starttime");
		//String endtime = request.getParameter("endtime");
		
		String Bid="";
		Building b = new Building();
		checkData c = new checkData();
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
		System.out.println("year = " + year);
		System.out.println("month = " + month);
		
		ArrayList<checkData> Month1list = new ArrayList<checkData>();
		try{
			dbCon con = new dbCon();
			String sql = "select * from checkData where Bid ='"+Bid+"' and way ='"+Way+"' and YEAR(data) ='"+year+"' and MONTH(data) ='"+month+"';";
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
				Month1list.add(d);
			}
			rs.close();
			stmt.close();
			con.getCon().close();
		}catch(Exception e){
			e.printStackTrace();
		}
		

		//����������ҵ��������������Դ�л����� �� �������
		ArrayList<checkData> Cid1Mlist = new ArrayList<checkData>();
		for(int i = 0; i < Month1list.size(); i ++){
			c = (checkData) Month1list.get(i);
			String cid = c.getCid();
			String remark = c.getremark();
			if(cid.equals("��������ҵ��������������Դ�л�����")){

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
		//����������ҵ��������������Դ�л����� ��  ����в��ϸ�ģ������ϸ�ķ���������
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
		
		//�����̻��������������л����� �� �������
				ArrayList<checkData> Cid2Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("�ͷ���������������л�����")){

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
				//�����̻��������������л����� �� ����в��ϸ�ģ������ϸ�ķ���������
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
		
				//�����̻��������������л����� �� �������
				ArrayList<checkData> Cid3Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("���̻��������������л�����")){

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
				//�����̻��������������л����� ��  ����в��ϸ�ģ������ϸ�ķ���������
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
				
				
				//����ѹ����������������л����� �� �������
				ArrayList<checkData> Cid4Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("��ѹ����������������л�����")){

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
				//����ѹ����������������л����� ��  ����в��ϸ�ģ������ϸ�ķ���������
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
				
				//������ˮ���������������л����ܡ� �������
				ArrayList<checkData> Cid5Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("����ˮ���������������л�����")){

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
				//������ˮ���������������л����� ��  ����в��ϸ�ģ������ϸ�ķ���������
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
				
				//����������������������л����� �� �������
				ArrayList<checkData> Cid6Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("��������������������л�����")){

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
				//����������������������л����� ��  ����в��ϸ�ģ������ϸ�ķ���������
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
				
				//�����������������������л����ܡ� �������
				ArrayList<checkData> Cid7Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("���������������������л�����")){

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
				//�����������������������л����ܡ�  ����в��ϸ�ģ������ϸ�ķ���������
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
				
				
				//�����ֱ������������������л����ܡ� �������
				ArrayList<checkData> Cid8Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("���ֱ������������������л�����")){

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
				//�����ֱ������������������л����� ��  ����в��ϸ�ģ������ϸ�ķ���������
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
				
				//��������Զ����ֶ��������ܣ�������ŵ繦�� �� �������
				ArrayList<checkData> Cid9Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("������Զ����ֶ��������ܣ�������ŵ繦��")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid9Mlist.add(c);
					}
				}
				//��������Զ����ֶ��������ܣ�������ŵ繦�ܡ�  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid9list = new ArrayList<checkData>();
				for(int i = 0; i < Cid9Mlist.size(); i ++){
					c = (checkData) Cid9Mlist.get(i);
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
						Cid9list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid9list.add(c);
					}
				}
				request.setAttribute("Cid9list", Cid9list);
				System.out.println(" Cid9list.size =  " + Cid9list.size() );
				
				
				//���������繦�ܣ��鿴��������ѹ�� �� �������
				ArrayList<checkData> Cid10Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("�������繦�ܣ��鿴��������ѹ��")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid10Mlist.add(c);
					}
				}
				//���������繦�ܣ��鿴��������ѹ�� ��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid10list = new ArrayList<checkData>();
				for(int i = 0; i < Cid10Mlist.size(); i ++){
					c = (checkData) Cid10Mlist.get(i);
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
						Cid10list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid10list.add(c);
					}
				}
				request.setAttribute("Cid10list", Cid10list);
				System.out.println(" Cid10list.size =  " + Cid10list.size() );
				
				//���˶Դ�����ʩ�Ĵ����� �� �������
				ArrayList<checkData> Cid11Mlist = new ArrayList<checkData>();
				for(int i = 0; i < Month1list.size(); i ++){
					c = (checkData) Month1list.get(i);
					String cid = c.getCid();
					String remark = c.getremark();
					if(cid.equals("�˶Դ�����ʩ�Ĵ�����")){

						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid11Mlist.add(c);
					}
				}
				//���˶Դ�����ʩ�Ĵ����� ��  ����в��ϸ�ģ������ϸ�ķ���������
				ArrayList<checkData> Cid11list = new ArrayList<checkData>();
				for(int i = 0; i < Cid11Mlist.size(); i ++){
					c = (checkData) Cid11Mlist.get(i);
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
						Cid11list.add(c);
					}
					else{
						c.setCid(c.getCid());
						c.setphotoID(c.getphotoID());
						c.setvideoID(c.getvideoID());
						c.setrecordID(c.getrecordID());
						c.setqualified(c.getqualified());
						c.setremark(c.getremark());
						c.setoperatorID(c.getoperatorID());
						Cid11list.add(c);
					}
				}
				request.setAttribute("Cid11list", Cid11list);
				System.out.println(" Cid11list.size =  " + Cid11list.size() );
				
				
				
		
		request.getRequestDispatcher("/contentMonth1.jsp?").forward(request,
				response);
		}
  }
