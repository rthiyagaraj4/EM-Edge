<!DOCTYPE html>
<!--Created by Ashwini on 16-Dec-2019 for AAKH-CRF-0079.11-->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,java.io.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<%@ page import="java.io.File" %>
<%@ page import="org.apache.commons.io.FileUtils" %>
<% 
request.setCharacterEncoding("UTF-8");

String facility_id = checkForNull((String)session.getValue("facility_id"));
Connection con = null;
try { 
	con = ConnectionManager.getConnection(request);
	Statement st = null;
	ResultSet res = null;
	byte [] byteArr = null;
	String patient_id = request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id");
	String serial_no = request.getParameter("serial_no");
	String query = "";
	Blob pat_photo_blob = null;
	BufferedOutputStream Buffout = null;
	st = con.createStatement();
	
		query = "SELECT document_file FROM mp_upload_document WHERE patient_id = '"+patient_id+"' AND encounter_id = '"+encounter_id+"' AND facility_id = '"+facility_id+"' AND serial_no = '"+serial_no+"'";		
		 
		res = st.executeQuery(query);

		if(res!=null && res.next()) {
			
			// document blob
			pat_photo_blob = (java.sql.Blob)res.getBlob("document_file");
			
			
			if(pat_photo_blob != null){
				// getting the file type from the blob content
				String fileType = "";
				InputStream inputStream = pat_photo_blob.getBinaryStream();
	            byte[] buffer = new byte[4];
	            int bytesRead = inputStream.read(buffer);
				if(bytesRead >= 4){
					String firstBlob4Chars = new String(buffer, 0, bytesRead, "UTF-8") ;
					if("%PDF".equals(firstBlob4Chars)){
						fileType = "application/pdf";
					}
				 	else {
						fileType = "image/gif";
					}
				}
				
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());
	
                response.reset();
				response.setContentType(fileType);
				OutputStream outputStream = response.getOutputStream();
				outputStream.write(byteArr);      
				outputStream.flush();
				outputStream.close();		
			}			
		}
		if(Buffout != null)
			Buffout.flush();	
		
		if(res != null) res.close();
		if(st != null) st.close();	 
	
}
catch ( java.io.FileNotFoundException fe )	
{    
	out.println("<script>alert('File is not found in the stored path!!!!!')</script>");
}
catch ( java.io.IOException ioe )
{
	out.println("<script>alert('Access is denied in the stored path!!!!!')</script>");
}
catch (Exception e) 
{
	out.println("<script>alert('Error in read the file in the stored path!!!!!')</script>");
	e.printStackTrace(); 
} 
finally 
{
	if(con!=null)
	con.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

%>

<%!
public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}
%>
