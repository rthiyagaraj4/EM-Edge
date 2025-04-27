<!DOCTYPE html>
<!-- 

This  file was developed by Shaik Mujafar on Feb/2019 against AAKH-CRF-0079.4

 -->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,java.io.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ page import="java.io.File" %>           
<%@ page import="org.apache.commons.io.FileUtils" %>
<% 
request.setCharacterEncoding("UTF-8");

Connection con = null;
try { 
	 con = ConnectionManager.getConnection(request);
	PreparedStatement ps1 = null;
	ResultSet res = null;
	byte [] byteArr = null;
	byte [] byteArrStamp = null;
	String practitionerid = request.getParameter("practitionerid");
	String function_id = request.getParameter("function_id");
	String sign_stamp = request.getParameter("sign_stamp");
	
	
	
	Blob pat_photo_blob =null;
	Blob pract_stamp_blob =null;
	//BufferedOutputStream Buffout = null; //Commented for checkstyle
	String table = "";	
	if(function_id.equals("PRACTITIONER")) table = "am_practitioner";
		else
		if(function_id.equals("EXT_PRACT")) table = "am_ext_practitioner";	 
	 String query = "select PRACTITIONER_SIGN,PRACTITIONER_STAMP from "+table+" WHERE PRACTITIONER_ID = ?";	
				ps1=con.prepareStatement(query);
				ps1.setString(1,practitionerid);
				res= ps1.executeQuery();						
							
							
						if(res!=null && res.next())
						{
							pat_photo_blob=(java.sql.Blob)res.getBlob("PRACTITIONER_SIGN");
							pract_stamp_blob=(java.sql.Blob)res.getBlob("PRACTITIONER_STAMP");							
							if(pat_photo_blob!=null && sign_stamp.equals("Sign"))
							{
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());
				
			                response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArr);      
							outputStream.flush();
							outputStream.close();			
							}
							if(pract_stamp_blob!=null && sign_stamp.equals("Stamp"))
							{
							byteArrStamp = pract_stamp_blob.getBytes(1,(int)pract_stamp_blob.length());				
			                response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArrStamp);      
							outputStream.flush();
							outputStream.close();			
							}						
							
						}		
	 		
		if(res != null) res.close();
		if(ps1 != null) ps1.close();
	
	
} catch ( java.io.FileNotFoundException fe )	
	{    
		out.println("<script>alert('File is not found !!!!!')</script>");
	}
catch ( java.io.IOException ioe )
	{
       out.println("<script>alert('Access is denied !!!!!')</script>");
	}
catch (Exception e) {
	 out.println("<script>alert('Error in read the file !!!!!')</script>");
	e.printStackTrace(); 
	
} finally {
	//Below Commented for checkstyle
	//if(con!=null)
	//con.close();
	//Added for checkstyle for COMMON-ICN-0056
	if(con!=null) ConnectionManager.returnConnection(con,request);
	
}
%>
