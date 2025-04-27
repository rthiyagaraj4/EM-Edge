/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBL;

import java.io.IOException;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import java.util.*;
import eBL.EClaimBean;

public class EClaimservlet extends HttpServlet {		
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {	
	   request.setCharacterEncoding("UTF-8");
	   response.setContentType("application/vnd.ms-excel;charset=UTF-8");
	   response.addHeader("Content-Disposition", "inline");
	   System.err.println("inside serv");
	   String file_name="";
	   EClaimBean pr = new EClaimBean();
	   HttpSession session=request.getSession(false);
	   String facility_id = (String)session.getAttribute( "facility_id" );
	   String payer_group=request.getParameter("payer_group");
	   //String servpath=request.getParameter("servpath");
	   String payer=request.getParameter("payer");
	   java.text.SimpleDateFormat dateTimeFormat = new java.text.SimpleDateFormat( "yyyyMMdd-HHmmss");
	   String currentDateTime = dateTimeFormat.format( new java.util.Date());
	   String tempPayerGrpName="";
	   String TempPayerName="";
	   if(payer_group.equals("**")){
		   tempPayerGrpName="All";
	   }else{
		   tempPayerGrpName=payer_group;
	   }
	   
	   if(payer.equals("**")  ||  payer.equals("") || payer.equals(null)){
		   TempPayerName="All";
	   }else {
		   TempPayerName=payer;
	   }
	   
	   file_name = "eClaim-"+tempPayerGrpName+"-"+TempPayerName+"-"+currentDateTime ;
		System.err.println("file_name  "+file_name);
		//System.err.println("servpath  "+servpath);
	   // file name format->eClaim-15-15-00163-20210201-104520
		
		//String serverpath1="C:\\eHIS\\REPORTS\\"; // Added for Path hotcoding
		//String path=serverpath1+file_name+".xls";
		
	   //String path=servpath+file_name+".xls";
		//System.err.println("path  "+path);
	   String noOfCols=request.getParameter("noOfCols");
	   int noOfColumns=Integer.parseInt(noOfCols);
	  
	   HashMap<String, ArrayList<ArrayList<String>>> passData=pr.getData(facility_id,noOfColumns);
	   HSSFWorkbook wb = pr.createWorkBook(passData);
	   System.err.println("48,passData===>"+passData);
	   try{
		   response.setContentType("application/vnd.ms-excel");
			response.setHeader("Content-Disposition","attachment; filename=\""+file_name+".xls" + "\"");
			ServletOutputStream sOut = response.getOutputStream();
			wb.write(sOut);
			System.err.println("Sout Written");
			sOut.flush();
			sOut.close();
			System.err.println("Sout Closed");
		/*if(wb!=null){
			System.err.println("wb is not null");
			FileOutputStream fileOut = new FileOutputStream(path);
			System.err.println("wb path loaded");
			wb.write(fileOut);
			System.err.println("File written");
			fileOut.close();
			System.err.println("File Clsoed");		
		}else{
		  // response.getOutputStream().flush();
			System.err.println("wb is null");
		}*/
	   }catch(Exception e){
		   e.printStackTrace();
		   System.err.println("Exception in Eclaimservlet  "+e);
	   }
		   
	}
}