/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMR;

import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;

import webbeans.eCommon.*;

import eCommon.XSSRequestWrapper;

public class PatientFileServlet extends javax.servlet.http.HttpServlet	
{
	PrintWriter out;
	
	HttpSession session ;

	String pat_id = "";
	//Statement stmt ;
	PreparedStatement stmt=null;
	String sql ="" ;
	ResultSet rst;
	ResultSet rsChk;
	Connection con;
	PreparedStatement pstmt1 ;

	String facility_id      = "";
	String pat_ser_grp   = "";
	String GeneratedFileNo;
	String OldFilePrompt ="N";
	String sStyle="";

	//String addedDate = dateFormat.format( new java.util.Date() ) ;


	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException,IOException
	{
		out = response.getWriter();		
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=UTF-8");
				
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
		
		doPost(request,response);
	}
	//Following function calls the file creation component and resubmits to the same servlet
	private String showModalForOldFileNo(String OldFilePrompt,String GeneratedFile,String patient_id,String facility_id,String errors,PrintWriter out, String pat_ser_grp_code ){
		String retErrors = "";
		out.println("<html>"+
						"<head>"+
						    "<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>"+
							"<link rel='stylesheet' type ='text/css' href='../eCommon/html/"+sStyle+"'></link>"+
							"<script>"+
								"async function showModal(){"+
									"var retVal = new String(); "+
									"var dialogHeight   = '360px' ;"+
									"var dialogWidth    = '450px' ;"+
									"var features   = 'dialogHeight:' + dialogHeight + '; dialogWidth:' + dialogWidth +';status=no;' ;"+
									"var arguments  = '"+GeneratedFile+"' ; "+
									"retVal = await window.showModalDialog('../../eMP/jsp/CallCreateFileComponent.jsp?Called_From=MP&Location_Type=null&Location_Code=null&P_Patient_ID="+patient_id+"&P_Pat_Ser_Grp_Code="+pat_ser_grp_code+"',arguments,features); "+	
								    "if(retVal != null){var arr = retVal.split('`');if(arr[0]!=''){var arr1=arr[0].split('||');"+ 
									"document.all.old_file_no.value = arr1[1];   "+
									"document.all.fs_locn_code.value = arr1[0];}   "+
									"document.form1.submit();}else{document.all.fs_locn_code.value='';document.all.old_file_no.value='';document.form1.submit();}"+
								"}"+
							"</script>"+
						"</head>"+
						"<body>"+
							"<form name='form1' method='post' action='../servlet/eMR.PatientFileServlet'>"+
								"<input type='hidden' name='old_file_no'></input>"+
								"<input type='hidden' name='pat_ser_grp_code' value=''></input>"+
								"<input type='hidden' name='patient_id' value='"+patient_id+"'></input>"+
								"<input type='hidden' name='facility_id' value='"+facility_id+"'></input>"+
								"<input type='hidden' name='gen_file_no' value='"+GeneratedFile+"'></input>"+
								"<input type='hidden' name='prompt_for_old_file_no' value='"+OldFilePrompt+"'></input>"+
								"<input type='hidden' name='pat_ser_grp_code' value='"+pat_ser_grp_code+"'></input>"+
								"<input type='hidden' name='fs_locn_code'></input>"+
								"<input type='hidden' name='operation' value='update_file_no'></input>"+
								"<input type='hidden' name='Output' value='"+java.net.URLEncoder.encode(errors)+"'></input>"+
								"<input type='hidden' name='appt_ref_no' value=''></input>"+
								"<input type='hidden' name='func_act' value=''></input>"+
							"</form>"+
							"<script>"+
							" showModal(); "+
							"</script>"+
						"  </body>"+
					"</html>");

		retErrors = errors;
		return retErrors;
}

public synchronized void doPost(HttpServletRequest request, HttpServletResponse response)
        throws javax.servlet.ServletException,IOException
{
try {
		session = request.getSession(true);
		this.facility_id      = (String) session.getValue("facility_id");
		//this.p = (Properties) session.getValue( "jdbc" ) ;
		String operation = request.getParameter("operation");
		String errors = "";
		sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		con = ConnectionManager.getConnection(request);
		//stmt 	= con.createStatement();
		//PreparedStatement stmt=null;
		if(operation.equals("update_file_no"))//the control comes to this block once the file is created by the component
		{
			this.out = response.getWriter();
			String fs_locn_code = request.getParameter("fs_locn_code");
			String patient_id = request.getParameter("patient_id");
			try 
			{				
				String file_no = request.getParameter("old_file_no")==null?"":request.getParameter("old_file_no");
				String results = "";
				if(!file_no.equals(""))
				{
					results=results+ "APP - MP0078 File No <B><FONT SIZE=4>"+fs_locn_code+"</b></font> is assigned<br> ";			
					out.println("<script>parent.parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+results+"'</script>");
					out.println("<script>alert(parent.frames[0].getMessage('RECORD_INSERTED','SM'));</script>");
					out.println("<script src='../eCommon/js/showModalDialog.js' language='JavaScript'></script>");
					out.println("<script>var patient_id='"+patient_id+"'; var gen_file_no='"+file_no+"';var retVal = new String();var arguments	= '' ;var features = 'dialogHeight:350px; dialogWidth:500px; status=no';retVal = window.showModalDialog('../../eCommon/jsp/InternalReportsReprint.jsp?Gen_File_No='+gen_file_no+'&module_id=MP&step=0&patient_id='+patient_id+'&target=step2',arguments,features);</script>");
				}
				else
				{
					results = "";
					out.println("<script>parent.parent.frames[2].location.href='../eCommon/jsp/error.jsp?err_num="+results+"';parent.parent.frames[1].location.href='../eMR/jsp/mrblank.jsp?step_1=7';</script>");
				}

			if(pstmt1 != null)pstmt1.close();
		}catch(Exception e)
		{
			//out.println("Encountered error while updating Patient Old File information");
			e.printStackTrace();
		}
		} else if ( operation.equals("create_file_no") )
		{
			pat_id = request.getParameter("Patient_Id");
					
			/*
			rst = stmt.executeQuery("Select count(*)  from mr_pat_file_index Where Patient_Id = '"+pat_id+"' and	Facility_Id = '"+facility_id+"'");
			rst.next();
			count=rst.getString(1);//check whether file is already created

			if(!count.equals("0"))
			{	String existing_file_no = "";
				try{
				rst = stmt.executeQuery("select file_no from mr_pat_file_index where 	patient_id= '"+pat_id+"'");
				rst.next();
				existing_file_no = rst.getString(1);
				}catch(Exception e){}
				
				out.println("	<script>var msg = 'File Already Created With File Number:"+existing_file_no+"';alert(msg);parent.parent.frames(1).location.href='../eMR/jsp/mrblank.jsp?step_1=7';</script>");
			}
			*/
			// Query to get patient series group
			
			 			
			//rst = stmt.executeQuery("select pat_ser_grp_code from mp_patient where 	patient_id= '"+pat_id+"'");
			sql="select pat_ser_grp_code from mp_patient where 	patient_id= ? ";
				stmt=con.prepareStatement(sql);
				
				stmt.setString(1, pat_id);
							
				
				rst = stmt.executeQuery();
				rst.next();
				pat_ser_grp = rst.getString(1);
				errors = showModalForOldFileNo(OldFilePrompt,GeneratedFileNo,pat_id,facility_id,errors,out,pat_ser_grp);//call the file creation component
				rst.close();
				stmt.close();
		} 
		 if(rst != null)rst.close();
		 if(rsChk != null)rsChk.close();
	}catch(Exception e)
	{
		String a=e.getMessage();
		//out.println("<script language='javascript'>alert('"+a+"') ; parent.parent.frames(1).location.href='../eMR/jsp/mrblank.jsp?step_1=7';</script>");
		e.printStackTrace();
	}
	finally
	{
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
  }
}// end of method
