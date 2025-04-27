/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1			 V211026			 25176			GHL-SCF-1604				   Manivel Natarajan
*/
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
//package LISImage;
package eBT;

import java.sql.*;
import java.util.*;
import java.io.*;
import javax.servlet.*; 
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
//import oracle.sql.*;
import org.apache.commons.fileupload.*;
import org.apache.commons.fileupload.servlet.*;
import org.apache.commons.fileupload.disk.*;
import webbeans.eCommon.*;

public class ManageLISSpecimenImageServlet extends HttpServlet
{	
	java.io.PrintWriter out = null;
	boolean isMultipart = false;
	HttpSession session;//Sanjay
	java.util.Properties p;
	FileItem Item	 = null;
	java.net.URI URIForImg = null;
	DefaultFileItemFactory defaultfileitemfactory = null;
	DiskFileUpload upload = null;
	List items = null;
	Iterator iter = null;
	// STARTS
	DefaultFileItemFactory defaultfileitemfactory1 = null;
	DiskFileUpload upload1 = null;
	FileItem Item1	 = null;
	List items1 = null;
	Iterator iter1 = null;
	// ENDS
	FileItem  fileItem = null;
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmtSeq = null;
	PreparedStatement pstmtSeq1 = null;
	ResultSet rs = null;
	ResultSet rsSeq = null;
	ResultSet rsSeq1 = null;
	//added by Sanjay STARTS here
	PreparedStatement pstmt1 = null;
	ResultSet res1 = null;
	PreparedStatement pstmt2 = null;
	ResultSet res2 = null;
	// added by Sanjay ENDS here
	PreparedStatement pstmt3 = null; //Added by Manoj for ML-MMOH-SCF-1319

	String testCode = "";
	String specNum = "";
	String anatomyCode = "";
	String tissueDescCode = "";
	String interfaceFileId = "";
	String sampleID = "";
	String name = "";
	String value = "";

	String facilityId = "";
	String clientIpAddress = "";
	String addedById = "";
	String sessionId = "";
	String fileExt = "";
	String fileName = "";
	String specSeqNum = "";
	String specSeqNum1 = "";
	String applServerURL = "";
	int insert_result = 0;
	int insert_result1 = 0;
	int insert_result2 = 0;
	int insert_result3= 0;//Added by Manoj for  ML-MMOH-SCF-1319
	String update_query="";
	java.text.SimpleDateFormat dateFormat = new java.text.SimpleDateFormat( "ddMMyyHHmmss" ) ;

	public void init(ServletConfig conf) throws ServletException
	{		
		super.init(conf);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, java.io.IOException
	{
				
		request.setCharacterEncoding("UTF-8");		
		session = request.getSession(false);

		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		//String locale		    =   p.getProperty("LOCALE");	 //Common-ICN-0045
		out = response.getWriter();
		String filePath = "";
		try
		{
			//response.setContentType("text/html");
			response.setContentType("text/html;charset=UTF-8");
			filePath = request.getParameter("filePath");
			if (filePath.length() > 0)
			{
				LISImageFileUpload(request,response);
			}
			else
			{
				LISImageFileDelete(request,response);
			}
			
		}
		catch(Exception e)
		{			
			//out.println("Exception in doPost of LISImageServlet.java --"+e.toString());
			e.printStackTrace(System.err);
		}
		

	}//end of doPost

	// Added by Sanjay to delete uploaded Image on 14-May-13 STARTS here
	public void LISImageFileDelete(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, java.io.IOException
	{	
		try
		{	
			String hdInterfaceFileId =  "";
			String hdInterfaceFileId1 =  "";
			//String secCode = "";	//Common-ICN-0045				
			con = ConnectionManager.getConnection(request);
			hdInterfaceFileId = request.getParameter("hdInterfaceFileId");
			hdInterfaceFileId1 = request.getParameter("hdInterfaceFileId1");
			String Path = request.getParameter("Path");

			// Code to delete the File STARTS here
			String fileName = "";
			File file;
			boolean wasDeleted = false;
			StringTokenizer st2 = new StringTokenizer(hdInterfaceFileId1, ",");			
			// Code to delete the File ENDS here

			//Ravi Shankar, 26/10/2018, IN-65488
			//Commented by Manoj for ML-MMOH-SCF-1319
		/*	session = request.getSession(false);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_user		    =   p.getProperty("login_user");	


			String sqlNextVal1 = "select rl_log_sequence_no.NEXTVAL spec_img_seq from dual";
			pstmtSeq1 = con.prepareStatement(sqlNextVal1);
			rsSeq1 = pstmtSeq1.executeQuery();

			while(rsSeq1.next())
			{
				specSeqNum1 = (String) rsSeq1.getString("spec_img_seq") == null ? "" : (String) rsSeq1.getString("spec_img_seq");
			}
			if(rsSeq1 != null) rsSeq1.close();
			if(pstmtSeq1 != null) pstmtSeq1.close();

			pstmt1 = con.prepareStatement("INSERT INTO RL_SPECIMEN_LOG(OPERATING_FACILITY_ID, SPECIMEN_NO, SEQUENCE_NO, LOG_TABLE_NAME, TIME_STAMP, USER_ID) SELECT OPERATING_FACILITY_ID, SPECIMEN_NO,  '"+specSeqNum1+"', 'RL_SPECIMEN_IMAGE_DTLS_LOG', SYSDATE, '"+login_user+"' FROM rl_specimen_image_dtls where INTERFACE_FILE_ID in ('"+hdInterfaceFileId+"')");
			insert_result1 = pstmt1.executeUpdate();

			pstmt2 = con.prepareStatement("INSERT INTO RL_SPECIMEN_IMAGE_DTLS_LOG(OPERATING_FACILITY_ID, SEQUENCE_NO, TIME_STAMP, ACTION, SPECIMEN_NO, TEST_CODE, SAMPLE_ID, ANATOMY_SITE_CODE, TISSUE_DESC_CODE, INTERFACE_FILE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, MODIFIED_BY_ID, MODIFIED_DATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO) SELECT OPERATING_FACILITY_ID, '"+specSeqNum1+"', SYSDATE, 'D', SPECIMEN_NO, TEST_CODE, SAMPLE_ID, ANATOMY_SITE_CODE, TISSUE_DESC_CODE, INTERFACE_FILE_ID, ADDED_BY_ID, ADDED_DATE, ADDED_FACILITY_ID, ADDED_AT_WS_NO, '"+login_user+"', SYSDATE, MODIFIED_FACILITY_ID, MODIFIED_AT_WS_NO FROM rl_specimen_image_dtls where INTERFACE_FILE_ID in ('"+hdInterfaceFileId+"')");
			insert_result2 = pstmt2.executeUpdate();*/ //ends here
			///////////////////////////
			
			/*Added by Manoj for ML-MMOH-SCF-1319*/
			session = request.getSession(false);
			this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String login_user		    =   p.getProperty("login_user");
			
			update_query="UPDATE RL_SPECIMEN_IMAGE_DTLS SET MODIFIED_BY_ID= '"+login_user+"' where INTERFACE_FILE_ID in ('"+hdInterfaceFileId+"')";
			pstmt3=con.prepareStatement(update_query);
			pstmt3.executeUpdate();
			con.commit();  
			//ends here 
			 
			pstmt = con.prepareStatement("delete from rl_specimen_image_dtls where INTERFACE_FILE_ID in ('"+hdInterfaceFileId+"')");
			
			/*
			if(uploadFile.length() > 0)
			{
			*/
					insert_result = pstmt.executeUpdate();
					con.commit();
					
					if(insert_result >=0)
					{	
						// Deleting the File from physical storage only when the record is deleted in the table
						while (st2.hasMoreElements()) {
							//System.out.println(st2.nextElement());
							fileName = Path + "/" + st2.nextElement();
							//System.out.println("fileName:" + fileName);
							file = new File(fileName);			
							wasDeleted = file.delete();
							/*
							if (!wasDeleted)
							{
								System.out.println(fileName + " File not deleted");
							}
							else
							{
								System.out.println(fileName + " File deleted");
							}
							*/
							
						}
						response.sendRedirect("../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp?calledFrom=ServletDelete");
					}
					
				/*
				}//end of if valid file
				else
				{					
					uploadFile.delete();					
					response.sendRedirect("../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp?calledFrom=Servlet&error=Y");
				}
				*/
			

		}//end of try
		catch(Exception eee) 
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{}
			//out.println("Exception in ManageLISSpecimenImageServlet.java --"+eee.toString());
			//System.out.println("Exception in ManageLISSpecimenImageServlet.java --"+eee.toString());
			eee.printStackTrace(System.err);

		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(rsSeq != null) rsSeq.close();
				if(pstmt != null) pstmt.close();
				if(pstmtSeq != null) pstmtSeq.close();
				if(res1 != null) res1.close();
				if(pstmt1 != null) pstmt1.close();
				if(res2 != null) res2.close();
				if(pstmt2 != null) pstmt2.close();
				if(pstmt3 != null) pstmt3.close(); //Common-ICN-0045
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			catch(Exception ee)
			{
			}
		}
	}
	// Added by Sanjay to delete uploaded Image on 14-May-13 ENDS here




	public void LISImageFileUpload(HttpServletRequest request, HttpServletResponse response) throws FileUploadException, java.io.IOException
	{	
		
		String sFileSeparator = "";
		int imagePathCheck = 0;
        
		try
		{			
			String filePath =  "";
			//String secCode = "";		//Common-ICN-0045			
			con = ConnectionManager.getConnection(request);
			filePath = request.getParameter("filePath");
			defaultfileitemfactory = new DefaultFileItemFactory(100,new File(filePath));		
			upload = new DiskFileUpload(defaultfileitemfactory);

			String sqlNextVal = "select RL_SPEC_IMAGE_SEQ.NEXTVAL spec_img_seq from dual";
//			upload = new DiskFileUpload(defaultfileitemfactory);
			
			// V211026 Added by Manivel N as part of GHL-SCF-1604 on 26/10/2021 
			System.out.println("ManageLISSpecimenImageServlet.java facilityId:" + facilityId);
			pstmt = con.prepareStatement("select NVL (count(*), 0) from SM_FUNCTION_CONTROL a ,sm_site_param b where a.site_id=b.customer_id and a.FUNCTIONALITY_ID='RL_SLASH_WITH_IMG_FILE_NAME'");
			
			rs = pstmt.executeQuery();			

			while(rs.next())
			{
					
				imagePathCheck = rs.getInt(1);
				//imagePathCheck = rs.getInt(1) == null ? 0 : rs.getInt(1);
			}
			System.out.println("ManageLISSpecimenImageServlet.java imagePathCheck:" + imagePathCheck);
			
			
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();
			// V211026 Changes by Manivel Ends here


			pstmt = con.prepareStatement("SELECT APP_SERVER_URL FROM CA_EXT_INT_PARAM ");
			rs = pstmt.executeQuery();			

			while(rs.next())
			{
				applServerURL = rs.getString("APP_SERVER_URL") == null ? "" : rs.getString("APP_SERVER_URL");
			}
			//System.out.println("ManageLISSpecimenImageServlet.java applServerURL:" + applServerURL);
			if(rs != null) rs.close();
			if(pstmt != null) pstmt.close();			

			pstmt = con.prepareStatement("insert into rl_specimen_image_dtls (OPERATING_FACILITY_ID,SPECIMEN_NO,TEST_CODE,SAMPLE_ID,ANATOMY_SITE_CODE,INTERFACE_FILE_ID,TISSUE_DESC_CODE,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,MODIFIED_DATE	,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO) values(?,?,?,?,?,?,?,?,sysdate,?,?,?,sysdate,?,?) ");
			
			isMultipart =  FileUpload.isMultipartContent(request);
			if(isMultipart)
			{
				upload.setSizeMax(1024*1024*1024*10);				
				items = upload.parseRequest(request);				
				iter = items.iterator();				

				while(iter.hasNext())
				{
					Item = (FileItem) iter.next();					
					if(Item.isFormField())
					{						
						name = (String) Item.getFieldName();						
						value = (String) Item.getString();

						if(name.equals("test")) testCode = value;
						else if(name.equals("specNum")) specNum = value;
						else if(name.equals("anatomy")) anatomyCode = value;
						else if(name.equals("sampleId")) sampleID = value;
						else if(name.equals("facilityId")) facilityId = value;
						else if(name.equals("clientIpAddress")) clientIpAddress = value;
						else if(name.equals("addedById")) addedById = value;
						else if(name.equals("sessionId")) sessionId = value;						
						else if(name.equals("tissueDescCode")) tissueDescCode = value;						
					}
					else
					{
						fileItem = Item;						
						fileName = fileItem.getName();						
					}				
				}
				
				StringTokenizer strTok = new StringTokenizer(fileName,".");
				while(strTok.hasMoreTokens())
				{
					//below line commented by Sanjay against IN050612 to include . in Folder Name while uploading image from user PC
					//strTok.nextToken();
					fileExt = strTok.nextToken();
				}
			
				pstmtSeq = con.prepareStatement(sqlNextVal);
				rsSeq = pstmtSeq.executeQuery();

				while(rsSeq.next())
				{
					specSeqNum = (String) rsSeq.getString("spec_img_seq") == null ? "" : (String) rsSeq.getString("spec_img_seq");
				}
				//System.out.println("ManageLISSpecimenImageServlet.java specSeqNum:" + specSeqNum);
				if(rsSeq != null) rsSeq.close();
				if(pstmtSeq != null) pstmtSeq.close();

				interfaceFileId = facilityId + "_" + specNum + "_" + specSeqNum + "." + fileExt;

				

				// testing STARTS here				
				//filePath = filePath + "\\" +interfaceFileId;//Sanjay comment after testing // Commented by Sethu for WCH issue ML-MMOH-SCF-1539 on 23/05/2020
				//System.out.println("ManageLISSpecimenImageServlet.java filePath 2:" + filePath);
				
				// V211026 If loop added by Manivel N as part of GHL-SCF-1604 on 26/10/2021 
				if(imagePathCheck > 0){
					filePath = filePath + "\\" +interfaceFileId;
				} else {
				//Added by Sethu for WCH issue ML-MMOH-SCF-1539 on 23/05/2020

					sFileSeparator=System.getProperty("file.separator");
					filePath = filePath + sFileSeparator +interfaceFileId;
				}
				
				System.out.println("ManageLISSpecimenImageServlet.java filePath 2:" + filePath);
				
				

				java.io.File uploadFile = new File(filePath);// Sanjay comment after testing
				// testing ENDS here

				//java.io.File uploadFile = new File(filePath+"/"+interfaceFileId);// Sanjay uncomment after testing			
				
				fileItem.write(uploadFile);

				if(uploadFile.length() > 0)
				{
					pstmt.setString(1,facilityId);
					pstmt.setString(2,specNum);
					pstmt.setString(3,testCode);
					pstmt.setString(4,sampleID);
					pstmt.setString(5,anatomyCode);
					pstmt.setString(6,interfaceFileId);
					pstmt.setString(7,tissueDescCode);
					pstmt.setString(8,addedById);
					pstmt.setString(9,facilityId);
					pstmt.setString(10,clientIpAddress);
					pstmt.setString(11,addedById);
					pstmt.setString(12,facilityId);
					pstmt.setString(13,clientIpAddress);
					insert_result = pstmt.executeUpdate();
					con.commit();
					if(insert_result >=0)
					{							
						response.sendRedirect("../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp?calledFrom=Servlet");
					}
				}//end of if valid file
				else
				{					
					uploadFile.delete();					
					response.sendRedirect("../eBT/jsp/ManageLISSpecimenImageIntermediate.jsp?calledFrom=Servlet&error=Y");
				}
			}//end of if multipart			

		}//end of try
		catch(Exception eee)
		{
			try
			{
				con.rollback();
			}
			catch(Exception ee)
			{}
			//out.println("Exception in ManageLISSpecimenImageServlet.java --"+eee.toString());
			//System.out.println("Exception in ManageLISSpecimenImageServlet.java --"+eee.toString());
			eee.printStackTrace(System.err);

		}
		finally
		{
			try
			{
				if(rs != null) rs.close();
				if(rsSeq != null) rsSeq.close();
				if(pstmt != null) pstmt.close();
				if(pstmtSeq != null) pstmtSeq.close();
				if(res1 != null) res1.close();
				if(pstmt1 != null) pstmt1.close();
				if(res2 != null) res2.close();
				if(pstmt2 != null) pstmt2.close();
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
			catch(Exception ee)
			{
			}
		}

	}//end of LISImageFileUpload

}//end of class
