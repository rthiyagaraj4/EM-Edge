/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.*;
import eOT.OtRegistryReportsBean;
public class OtRegistryReportsServlet extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {
		
	   request.setCharacterEncoding("UTF-8");
	   response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	   response.addHeader("Content-Disposition", "inline");
        
		 

	   OtRegistryReportsBean pr = new OtRegistryReportsBean();
	   HttpSession session=request.getSession(false);
	   String facility_id = (String)session.getAttribute( "facility_id" );
	   String qryStr=request.getParameter("qryStr");
	   String noOfCols=request.getParameter("noOfCols");
	   int noOfColumns=Integer.parseInt(noOfCols);
	   String report_id=request.getParameter("p_report_id");
	   String header_Details=request.getParameter("header_Details");
	   String sql_site_name=request.getParameter("sql_site_name");
	   String sql_facility_name=request.getParameter("sql_facility_name");
	   String sql_report_desc=request.getParameter("sql_report_desc");
	   
	   HashMap passData=pr.getData(facility_id,qryStr,noOfColumns,report_id,header_Details,sql_site_name,sql_facility_name,sql_report_desc);
	   HSSFWorkbook wb = pr.createWorkBook(passData);
		if(wb!=null){
			   wb.write(response.getOutputStream());
		}else{
		   response.getOutputStream().flush();
		}
	}  
}
