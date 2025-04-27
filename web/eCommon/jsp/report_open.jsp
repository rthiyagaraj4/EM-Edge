<!DOCTYPE html>
<html lang="en">  
<head>  
<meta name="viewport" content="width=device-width, initial-scale=1.0" />   
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page  contentType="text/html;charset=UTF-8" import= "java.sql.*,java.io.*, java.util.*, java.text.*,webbeans.eCommon.*,java.io.File,java.io.*,java.io.FileInputStream,java.io.FileOutputStream,webbeans.eCommon.*,com.ehis.util.*,java.util.HashMap, java.util.ArrayList" %>
<head>
  <%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
 <Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language="JavaScript">
		var outputWindow;
 
function onFormLoad() {	 
	window.document.title = 'eHIS' ;
}
	    
function callclose(report_option)
	{
		if(report_option!='V')
		{
		self.close();
		outputWindow.close() ;
		window.close() ;
		}
	} 

    </script>
</head>
<body onLoad="onFormLoad();" OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<%
	request.setCharacterEncoding("UTF-8");	
   // String params       = request.getQueryString() ;
	response.setContentType("text/html;charset=UTF-8");
    String closeWindow  = request.getParameter( "closeWindow" ) ;      
    String report_url  = request.getParameter( "report_url" ) ;
	String file_dir  = request.getParameter( "file_dir" ) ;	
	String file_name  = request.getParameter( "file_name" ) ;	
	String report_option  = request.getParameter( "report_option" ) ;	
	//Maheshwaran K added 
	Connection con=null;
	String reportServerEnableFlag="";	
		String error_status="";
		String error_text="";
	try 
		{
		con	= ConnectionManager.getConnection(request);
		HashMap hashdata  = eCommon.Common.CommonBean.getSiteSpecificDetails(con,"SM","REPORT_SERVER_POST");
		reportServerEnableFlag = (String)hashdata.get("value1");
		CallableStatement cs = con.prepareCall( "{ call report_submit( ?, ?, ?) }" ) ;
		cs.setString( 1,	report_url ) ;	 
		cs.registerOutParameter( 2,  Types.VARCHAR ) ;
		cs.registerOutParameter( 3,  Types.VARCHAR ) ;
		cs.execute() ;
		error_status	= cs.getString( 2 ) ;
		error_text 	= cs.getString( 3 ) ;

		//System.err.println("report_submit in error_status : "+error_status);
		//System.err.println("report_submit in  error_text : "+error_text);

		if(error_status.equals("S"))
			{
			closeWindow = "true" ;	
			if(report_option.equals("V")) 
				{
				response.reset();
				int index = file_dir.lastIndexOf("/");
				String FinalfileName = file_dir.substring(index + 3);
				response.setContentType("application/octet-stream");
				response.setHeader("Content-Disposition","attachment;filename="+file_name);
				byte [] byteArr =convertFileToBytes(file_dir);
	
				OutputStream o = response.getOutputStream();
				o.write(byteArr); 
				o.flush();
				o.close(); 

			}
			else {
				if(report_option.equals("F")) {
				deleteFile(file_dir);	
				}		
			out.println( "<script language='JavaScript'>alert(getMessage('REPORT_SUBMIT_SERVER','Common') ) ; location.href='../../eCommon/jsp/error.jsp';</script>" ) ;
			}				
				
				
			}
		if(error_status.equals("E"))
			{
			closeWindow = "false" ;	
			response.sendRedirect("../../eCommon/jsp/error.jsp?err_num="+java.net.URLEncoder.encode( error_text, "UTF-8" )+"&err_value=" + error_status);
			}
		if(cs !=null)cs.close() ;
		}
	catch(Exception e)
		{
		System.err.println("Exception : "+e);
		e.printStackTrace();	
		}
	finally 
		{
			ConnectionManager.returnConnection(con,request);
		}
	//End

    if ( closeWindow == null ) closeWindow = "false" ;
 	out.println( "<script language='JavaScript'>'"+closeWindow+"'</script>" ) ;
    if ( closeWindow.equalsIgnoreCase( "true" ) ) {
    //    out.println( "<script language='JavaScript'>alert(getMessage('REPORT_SUBMIT_SERVER','Common') ) ;</script>" ) ;
    } else {
        out.println( "<table align='center'>" ) ;
        out.println( "<tr height=500>" ) ;
        out.println( "<td align='center'>" ) ;

        out.println( "Processing Report.  Please Wait...<br><br>" ) ;
		out.println( "<input type='button' align='center' name='Cancel' id='Cancel' onClick='window.close()' class='button' value='Cancel'>" ) ;

        //out.println( "<img src='../images/BBcancel.gif' alt='Cancel' onClick='window.close()'>" ) ;

        out.println( "</td>" ) ;
        out.println( "</tr>" ) ;
        out.println( "</table>" ) ;
    }
%>
<form name="report_process_form" id="report_process_form">
<input type="hidden" name="closeWindow" id="closeWindow" value="<%= closeWindow %>">
<input type="hidden" name="reportServerEnableFlag" id="reportServerEnableFlag" value="<%= reportServerEnableFlag %>">
</form>
</body>
<%!
 public byte [] convertFileToBytes(String fileName) 
	{
	File file = new File(fileName);
	/*****************************************************/
	byte [] returnBase64=null;
	/*********************************/
	byte[] bytes =new byte[(int)file.length()];
	try { 
		 FileInputStream fileInputStreamReader = new FileInputStream(file);
		 bytes = new byte[(int)file.length()];
		 fileInputStreamReader.read(bytes);
		 fileInputStreamReader.close();
		returnBase64=bytes;
	//	returnBase64=new String(Base64.encodeBase64(bytes), "UTF-8");
		//returnBase64=new String(bytes, "UTF-8");			
		if(returnBase64!=null){
			if(file.exists())
				{
				try {
					deleteFile(fileName);
					} 
				catch (Exception e) {				
					System.err.println("Exception occurred while converting deleting the file folder from server folder : "+ e);
					e.printStackTrace();
					}
				}
			else {
				returnBase64=bytes;
				}
			}
			}

   catch (Exception e) 
		{
			returnBase64=bytes;
		//returnBase64="NOT_EXISTS";
		System.err.println("Exception occurred while reading the file folder from server folder : "+ e);
		e.printStackTrace();
		}

	return returnBase64;
    }
public boolean deleteFile(String fileName1) 
	{
	boolean returnVal=false;
	try {
		File file1 = new File(fileName1);
		if(file1.exists())
			{
			try {
				file1.delete();
				returnVal=true;
				} 
			catch (Exception e) {		
				returnVal=false;				
				System.err.println("Exception occurred while converting deleting the file folder from server folder : "+ e);
				e.printStackTrace();
				}
			}
		else {
			returnVal=false;	
			}
		}
   catch (Exception e) 
		{
		returnVal=false;	
		System.err.println("Exception occurred while reading the file folder from server folder : "+ e);
		e.printStackTrace();
		}
	return returnVal;
    }	
%>
</html>

