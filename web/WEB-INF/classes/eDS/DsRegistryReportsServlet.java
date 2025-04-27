package eDS;
import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.*;
import eDS.DsRegistryReportsBean;
public class DsRegistryReportsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
	   request.setCharacterEncoding("UTF-8");
	   response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	   response.addHeader("Content-Disposition", "inline");
     
	   DsRegistryReportsBean pr = new DsRegistryReportsBean();
	   HttpSession session=request.getSession(false);
	   String facility_id = (String)session.getAttribute( "facility_id" );
	   String qryStr=request.getParameter("qryStr");
	   String qryHeader=request.getParameter("qryHeader");
	   String noOfCols=request.getParameter("noOfCols");
	   int noOfColumns=Integer.parseInt(noOfCols);
	   String report_id=request.getParameter("p_report_id");
	   String header_Details=request.getParameter("header_Details");
	   String sql_site_name=request.getParameter("sql_site_name");
	   String sql_facility_name=request.getParameter("sql_facility_name");
	   String sql_report_desc=request.getParameter("sql_report_desc");
	   
	   HashMap passData=pr.getData(facility_id,qryStr,noOfColumns,report_id,header_Details,sql_site_name,sql_facility_name,sql_report_desc,qryHeader);
	   HSSFWorkbook wb = pr.createWorkBook(passData);
		if(wb!=null){
			   wb.write(response.getOutputStream());
		}else{
		   response.getOutputStream().flush();
		}
	}  
}
