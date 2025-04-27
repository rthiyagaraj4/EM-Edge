<!-- 

This  file was developed by Venkatesh.S on Feb/2013 against PMG2012-CRF-0006 [IN034693] 

 -->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" import = "java.sql.*,java.io.*, java.util.*, java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@ page import="java.io.File" %>          <!--   //Added by Sethu for AAKH-CRF-0075     -->    
<%@ page import="org.apache.commons.io.FileUtils" %>
<% 
request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
try { 
	con = ConnectionManager.getConnection(request);
	Statement st = null;
	ResultSet res = null;
	byte [] byteArr = null;
	String patient_id = checkForNull(request.getParameter("patient_id"));
	String column_name = checkForNull(request.getParameter("column_name"));
	String action = checkForNull(request.getParameter("action")); // Added By Dharma for RBU-COMMON-IND-CRF-0002
	String qryDownload	= "";
	String docNo		= "";
	String retValue		= "";
	String fType		= "";
	String fName		= "";
	if(action.equals("download")){
		docNo		= column_name.substring(0,4);
		qryDownload	= " ,mp_get_doc_type("+column_name+",'"+docNo+"','"+patient_id+"') file_name";
	}
	Blob pat_photo_blob =null;
	BufferedOutputStream Buffout = null;
	st = con.createStatement();	
	 
	 String query ="" ;
	 
	 //Changed by prithivi on 12/10/2015 for updation from 12x
	 /* if(column_name.equals("DOC1_IMAGE"))
	        query="Select DOC1_IMAGE from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;
	   if(column_name.equals("DOC2_IMAGE"))
			query="Select DOC2_IMAGE from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;
	   if(column_name.equals("DOC3_IMAGE"))
			query="Select DOC3_IMAGE from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;
	   if(column_name.equals("DOC4_IMAGE"))
			query="Select DOC4_IMAGE from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;
				
		 
		 res = st.executeQuery(query);
		 if(res!=null && res.next()) { 
		  pat_photo_blob=(java.sql.Blob)res.getBlob(column_name);
		    //pat_photo_blob = res.getBlob(column_name);	
     	   /*InputStream in = pat_photo_blob.getBinaryStream();
		     long len = pat_photo_blob.length();
			 Buffout = new BufferedOutputStream(response.getOutputStream());
			 byte[] by = new byte[(int)len];			 
			 int index = in.read(by , 0 , (int)len);
			 
			   while ( index != -1) { 
				Buffout.write(by , 0, index);
				index = in.read ( by , 0 , (int)len );
				} /*
				if(pat_photo_blob!=null){
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());
				
			                response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArr);      
							outputStream.flush();
							outputStream.close();
			
			}
		
		} 	
		 //Buffout.flush();
		
		
		if(res != null) res.close();
		if(st != null) st.close();
	
	
} catch (Exception e) {
	e.printStackTrace(); 
	
} finally {
	if(con!=null)
	con.close();
if(con!=null) ConnectionManager.returnConnection(con,request);
	
}

*/
 //Changed by prithivi on 12/10/2015 for updation from 12x


//Added by Sethu for AAKH-CRF-0075
	String sPatDocQuery = "";
	int patDocFlag = 0;
	String imageFilePath = "";
	
	PreparedStatement pstmt	= null;
	ResultSet resultSet = null;

/*Modified by Rameswar on  05-04-2016 to handle the multiple store location for single patient*/
	if(column_name.equals("DOC1_IMAGE"))
	sPatDocQuery = " Select nvl(doc1_upload_flag,0) doc_flag from mp_pat_documents where patient_id = ?";
	if(column_name.equals("DOC2_IMAGE"))
	sPatDocQuery = " Select nvl(doc2_upload_flag,0) doc_flag from mp_pat_documents where patient_id = ?";
	if(column_name.equals("DOC3_IMAGE"))
	sPatDocQuery = " Select nvl(doc3_upload_flag,0) doc_flag from mp_pat_documents where patient_id = ?";
	if(column_name.equals("DOC4_IMAGE"))
	sPatDocQuery = " Select nvl(doc4_upload_flag,0) doc_flag from mp_pat_documents where patient_id = ?";
/*Modified by Rameswar on  05-04-2016 to handle the multiple store location for single patient*/
	
	pstmt = con.prepareStatement(sPatDocQuery); 
	pstmt.setString(1, patient_id);
	resultSet = pstmt.executeQuery();
	
	if(resultSet!=null && resultSet.next()) { 
		patDocFlag = resultSet.getInt("doc_flag");
	}

	if (patDocFlag == 0){    //Changed by prithivi on 12/10/2015 for updation from 12x
	//Added by Sethu for AAKH-CRF-0075		
	 
		if(column_name.equals("DOC1_IMAGE"))
			query="Select DOC1_IMAGE "+qryDownload+" from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;
		if(column_name.equals("DOC2_IMAGE"))
			query="Select DOC2_IMAGE "+qryDownload+" from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;
		if(column_name.equals("DOC3_IMAGE"))
			query="Select DOC3_IMAGE "+qryDownload+" from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;
		if(column_name.equals("DOC4_IMAGE"))
			query="Select DOC4_IMAGE "+qryDownload+" from mp_pat_documents where PATIENT_ID ='"+patient_id+"'" ;			
		 
		res = st.executeQuery(query);
		if(res!=null && res.next()) { 
			pat_photo_blob=(java.sql.Blob)res.getBlob(column_name);
			/*
			pat_photo_blob = res.getBlob(column_name);	
			InputStream in = pat_photo_blob.getBinaryStream();
			long len = pat_photo_blob.length();
			Buffout = new BufferedOutputStream(response.getOutputStream());
			byte[] by = new byte[(int)len];			 
			int index = in.read(by , 0 , (int)len);

			while ( index != -1) { 
				Buffout.write(by , 0, index);
				index = in.read ( by , 0 , (int)len );
			} */
			if(pat_photo_blob!=null){
				byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());
				if(!action.equals("download")){
				
			                response.reset();
							response.setContentType("image/gif");
							OutputStream outputStream = response.getOutputStream();
							outputStream.write(byteArr);      
							outputStream.flush();
							outputStream.close();
			
			
				}else{
					retValue	= checkForNull(res.getString("file_name"));
					StringTokenizer strTok = null;
					if(!retValue.equals("")){
						strTok = new StringTokenizer(retValue,"#");
						fType	= strTok.nextToken();
						fName	= strTok.nextToken();
						
						if(fType.equals("pdf")){
							response.setContentType("application/pdf;");
						}else if(fType.equals("jpg")){
							response.setContentType("image/jpg");
						}else{
							response.setContentType("image/gif");
						}
						response.reset();
						response.setHeader("Content-Disposition","attachment;filename="+fName);
						OutputStream outputStream = response.getOutputStream();
						outputStream.write(byteArr);      
						outputStream.flush();
						outputStream.close();
					}
				}
			}
			// byteArr = pat_photo_blob.getBytes(1,(int)pat_photo_blob.length());	
		} 	
		Buffout.flush();

		if(res != null) res.close();
		if(st != null) st.close();
	}
	else  if (patDocFlag == 1)     //Changed by prithivi on 12/10/2015 for updation from 12x
	{
		if(column_name.equals("DOC1_IMAGE"))
			query="Select doc1_image_path from mp_pat_documents where patient_id = ? " ;
		if(column_name.equals("DOC2_IMAGE"))
			query="Select doc2_image_path from mp_pat_documents where patient_id = ? " ;
		if(column_name.equals("DOC3_IMAGE"))
			query="Select doc3_image_path from mp_pat_documents where patient_id = ? " ;
		if(column_name.equals("DOC4_IMAGE"))
			query="Select doc4_image_path from mp_pat_documents where patient_id = ? " ;	

		pstmt = con.prepareStatement(query); 
		pstmt.setString(1, patient_id);
		resultSet = pstmt.executeQuery();

		if(resultSet!=null && resultSet.next()) { 
			imageFilePath = resultSet.getString(1);
		}		

		if(imageFilePath!="" && imageFilePath!=null)
		{
		File pdfFile = new File(imageFilePath);
		byte[] pdfByteArray = FileUtils.readFileToByteArray(pdfFile);

		String fileExt = imageFilePath;
		int lastIndexOf = fileExt.lastIndexOf(".");
		if (lastIndexOf == -1) {
			fileExt =""; // empty extension
		} else {
			fileExt= fileExt.substring(lastIndexOf);
		}
		
		
		if(fileExt.equals(".pdf")){
			response.setContentType("application/pdf");
		}else if(fileExt.equals(".jpg")){
			response.setContentType("image/jpeg");
		}else{
			response.setContentType("image/gif");
		}
		response.getOutputStream().write(pdfByteArray);
		response.getOutputStream().flush();
		}else{
			  out.println("<script>alert('Stored path is not available in DataBase!!!!!')</script>");
		}
	}	 
	
}catch ( java.io.FileNotFoundException fe )	
	{    
		out.println("<script>alert('File is not found in the stored path!!!!!')</script>");
	}
catch ( java.io.IOException ioe )
	{
       out.println("<script>alert('Access is denied in the stored path!!!!!')</script>");
	}
catch (Exception e) {
	 out.println("<script>alert('Error in read the file in the stored path!!!!!')</script>");
	e.printStackTrace(); 
	
} finally {
	if(con!=null)
	con.close();
if(con!=null) ConnectionManager.returnConnection(con,request);
	
}
%>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>
