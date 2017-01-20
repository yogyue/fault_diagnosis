package servlet;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;





import bean.alarm;
import dbConnector.dbCon;



public class DBtoExcelservlet extends HttpServlet {

	
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
	@SuppressWarnings("deprecation")
	protected void doGet(HttpServletRequest request,  
            HttpServletResponse response) throws ServletException, IOException {  
		response.setContentType("text/html;charset=utf-8");
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		
		String flag = request.getParameter("choose");
		System.out.println(flag);
		String sql=null;
		String filename=null;
		String value=null;
		 String xlsName = "test.xls";  
	        String sheetName = "sheetName";  
	        if(flag.equalsIgnoreCase("xuesheng"))
	        {
	        sql="select * from Student";
	        filename="/学生基本信息.xls";
	        xlsName="xuesheng.xls";
	        }
	        if(flag.equalsIgnoreCase("jiaofei"))
	        {
	        sql="select * from Fee";
	        filename="/缴费信息.xls";
	        xlsName="jiaofei.xls";
	        }
	        if(flag.equalsIgnoreCase("jiashiyuan"))
	        {
	        sql="select * from busDriver";
	        filename="/驾驶员基本信息.xls";
	        xlsName="jiashiyuan.xls";
	        }
	        if(flag.equalsIgnoreCase("suixing"))
	        {
	        sql="select * from busEntourage";
	        filename="D:/随行人员信息.xls";
	        xlsName="suixing.xls";
	        }
	        if(flag.equalsIgnoreCase("xianlu"))
	        {
	        sql="select * from BusRoute";
	        filename="/线路信息.xls";
	        xlsName="xianlu.xls";
	        }
	        if(flag.equalsIgnoreCase("zhandian"))
	        {
	        sql="select * from BusStation";
	        filename="/站点信息.xls";
	        xlsName="zhandian.xls";
	        }
	        if(flag.equalsIgnoreCase("cheliang"))
	        {
	        sql="select * from Bus";
	        filename="/车辆基本信息.xls";
	        xlsName="cheliang.xls";
	        }
	        if(flag.equalsIgnoreCase("baojing"))
	        {
	        sql="select * from Alarm";
	        filename="/学生报警信息.xls";
	        xlsName="baojing.xls";
	        }
	    //   StudentResultSet stuResultSet = new StudentResultSet(); 
		try {
			
			dbCon con = new dbCon();
		
			Statement stmt = con.getCon().createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			  HSSFWorkbook workbook = new HSSFWorkbook();  
		        HSSFSheet sheet = workbook.createSheet();  
		        workbook.setSheetName(0, sheetName);  
		        HSSFRow row = sheet.createRow((short) 0);  
		        HSSFCell cell;  
		        try {  
		            ResultSetMetaData md = rs.getMetaData();  
		            int nColumn = md.getColumnCount();  
		            System.out.println(nColumn);
		            for (int i = 1; i <= nColumn; i++) {  
		                cell = row.createCell((short) (i - 1));  
		                
		            //    cell.setCellType(HSSFCell.CELL_TYPE_STRING); 
		                if(md.getColumnLabel(i)==null)
		              
	                    {cell.setCellValue("");}
		                else
		                {
		                	cell.setEncoding(HSSFCell.ENCODING_UTF_16);	
		                	cell.setCellValue(md.getColumnLabel(i));
		              //  cell.setCellValue(new HSSFRichTextString(md.getColumnLabel(i)));  
		                }
		            }  
		            int iRow = 1;  
		            while (rs.next()) {  
		                row = sheet.createRow((short) iRow);  
		                System.out.println(iRow);
		                for (int j = 1; j <= nColumn; j++) {  
		                	  
		                    cell = row.createCell((short) (j - 1));  
		             //      cell.setCellType(HSSFCell.CELL_TYPE_STRING);
		                   
		                    if(rs.getObject(j)==null||rs.getObject(j).toString()==null)
		                    {cell.setCellValue("");}
		                    else
		                    {
		                    	cell.setEncoding(HSSFCell.ENCODING_UTF_16);	
		                    	cell.setCellValue(rs.getObject(j).toString());
		                //    cell.setCellValue(new HSSFRichTextString(rs.getObject(j).toString()));  
		                    }
		                }  
		                iRow++;  
		            }  
		           // String filename = request.getRealPath("/") + xlsName; 
		            
		            request.setAttribute("filename", filename);  
		            System.out.println(filename);
		            FileOutputStream fOut = new FileOutputStream(filename);  
		            workbook.write(fOut);  
		           fOut.flush();  
		           fOut.close();  
		            //response.setContentType("application/msexcel;charset=utf-8");
		            response.setHeader("Content-disposition", "attachment;filename="+xlsName);
		            request.getRequestDispatcher("OpenExcelServlet").forward(request,  
		                   response);  
		        } catch (Exception e) {  
		            e.printStackTrace();  
		        }
			rs.close();
			stmt.close();
			con.getCon().close();
		} catch (SQLException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	//	response.sendRedirect("BuikUpload.jsp");
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
	@SuppressWarnings("deprecation")
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 this.doGet(request, response); 
	  
	      
	}

	

}
