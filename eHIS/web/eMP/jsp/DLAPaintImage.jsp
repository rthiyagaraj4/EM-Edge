<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,java.io.* " %>
<% 
request.setCharacterEncoding("UTF-8");
// Added the new jsp page for SRR20056-SCF-5529 [IN:024247] by Suresh M on 09.12.2010
try {		
	Blob pat_photo_blob = (Blob)session.getAttribute("pat_photo_blob");	
	byte [] buff = null;	

		buff = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());
		if(buff != null){
			response.reset();
			response.setContentType("image/gif");
			OutputStream o = response.getOutputStream();
			o.write(buff);      
			o.flush();
			o.close(); 
		}
		session.removeAttribute("pat_photo_blob");
} catch (Exception e) {
	e.printStackTrace(); 
	System.out.println("Exception in DLA PaintImage.jsp...");
} finally {
}

%>
