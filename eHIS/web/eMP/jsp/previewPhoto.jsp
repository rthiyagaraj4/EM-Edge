<!DOCTYPE html>
<!-- Latest Modified Date : 10/1/2005 4:36 PM -->
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page contentType="text/html;charset=UTF-8" import="java.sql.*,java.util.*,java.io.*,javax.naming.*,javax.rmi.*,javax.servlet.http.HttpUtils.*,org.apache.commons.fileupload.*,java.net.*,webbeans.eCommon.ConnectionManager" %>
<html>
<head>
<body>

<%

	boolean isMultipart				= false;
	FileItem Item					= null;
	FileItem fileItem				= null;
	DiskFileUpload upload			= null;
	long	docSize					= 0;
	String	docName					= "";
	String	docType					= "";
	List items						= null;
	Iterator iter					= null;


	String patient_id= "";
	String preview ="";
	
	isMultipart				= FileUpload.isMultipartContent(request);

			try{
			if(isMultipart){
				upload			= new DiskFileUpload();
				items			= upload.parseRequest(request);
				
				iter			= items.iterator();
				String name		= "";
				String value	= "";
				while(iter.hasNext()){
					Item = (FileItem)iter.next();
					
					if(Item.isFormField()){
						name		= Item.getFieldName();
						value		= Item.getString();
						if(name.equals("patient_id")) patient_id=value;
						if(name.equals("preview")) preview=value;
					}else{
						fileItem	= Item;
						docName		= Item.getName();
						docType		= Item.getContentType();
						docSize		= Item.getSize();

						

						if(docType == null){
							docType = "999";
						}
					}
				}
			}
		

       	byte [] byteArr = null;
		byteArr=fileItem.get();       
		response.reset();
		response.setContentType("image/gif");
		OutputStream outputStream = response.getOutputStream();
		outputStream.write(byteArr);      
		outputStream.flush();
		outputStream.close(); 
		
		}catch(Exception e){
			e.printStackTrace();
		}
	
		
%>
</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>
