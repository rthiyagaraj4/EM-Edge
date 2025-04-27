<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------

23/04/2022	23925			Ramesh Goli		23/04/2022		RAMESH G    	MO-CRF-20171
------------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,java.io.*,webbeans.eCommon.*,javax.servlet.*" contentType="text/html;charset=UTF-8"%>
<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement ptsmt = null;
	ResultSet rs = null;	
	java.sql.Blob hist_blob = null;
	BufferedOutputStream Buffout = null;	

	String qryString = "";
	String imageRef = request.getParameter("imageRef")==null?"":request.getParameter("imageRef");
	
	try
	{
		con = ConnectionManager.getConnection(request);
		qryString = "SELECT IMAGE_REF,IMAGE_TYPE,IMAGE_NAME,IMAGE_CONTENT,IMAGE_IN_DB,IMAGE_SHAREPATH FROM ST_GRN_DTL_EXP_DOC WHERE IMAGE_REF=?";
		ptsmt = con.prepareStatement(qryString);
		ptsmt.setString(1,imageRef);
		
		rs = ptsmt.executeQuery();
		if(rs.next()) {
			String[] objArray =((String)rs.getString("IMAGE_TYPE")).split("\\/");
			String imageName = (String)rs.getString("IMAGE_NAME");
			String imageInDb = (String)rs.getString("IMAGE_IN_DB");
			String imageSharePath = rs.getString("IMAGE_SHAREPATH")==null?"":(String)rs.getString("IMAGE_SHAREPATH");
			if("image".equals(objArray[0])){
				InputStream readImg =null;
				long len1=0;
				if(!"".equals(imageSharePath) && "N".equals(imageInDb)){				
					File file =new File(imageSharePath+"/"+imageName);
					if(file.exists()){
						readImg = new FileInputStream(file);
						len1 = file.length();
					}else{
						String errorMsg="Unable to Retrieve. File Server is not Responding or File is Unavailable. Please contact administrator.";
						readImg = new ByteArrayInputStream(errorMsg.getBytes("UTF-8"));
						len1 = errorMsg.length();
					}
				}else{				
					hist_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");        	 
					len1 = hist_blob.length(); 					  
					readImg = hist_blob.getBinaryStream();  
				} 
				byte[] by = new byte[(int)len1]; 
				int index = readImg.read(by, 0, (int)len1);					
				response.reset();  
				response.setContentType(rs.getString("IMAGE_TYPE"));  
				response.getOutputStream().write(by, 0, (int)len1);  
				response.getOutputStream().flush(); 
			}else{	
				InputStream in =null;
				long len=0;
				System.out.println(imageInDb+"<--------------->"+imageSharePath);
				
				if(!"".equals(imageSharePath) && "N".equals(imageInDb)){
					response.setContentType((String)rs.getString("IMAGE_TYPE"));
					File file =new File(imageSharePath+"/"+imageName);
					if(file.exists()){
						in = new FileInputStream(file);
						len = file.length();
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);

						while ( index != -1) {
						Buffout.write(by , 0, index);
						index = in.read ( by , 0 , (int)len );
						}
						Buffout.flush();
					}else{
						String errorMsg="Unable to Retrieve. File Server is not Responding or File is Unavailable. Please contact administrator.";
						in = new ByteArrayInputStream(errorMsg.getBytes("UTF-8"));
						len = errorMsg.length();
						
						byte[] by = new byte[(int)len]; 
						int index = in.read(by, 0, (int)len);					
						response.reset();  
						response.setContentType("image/pjpeg");  
						response.getOutputStream().write(by, 0, (int)len);  
						response.getOutputStream().flush(); 
					}
				}else{	
					if("pdf".equals(objArray[1]) || "PDF".equals(objArray[1]) ){
						response.setContentType((String)rs.getString("IMAGE_TYPE"));						
						hist_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
						in = hist_blob.getBinaryStream();
						len = hist_blob.length();					
					
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);

						while(index != -1)
						{
							Buffout.write(by , 0, index);
							index = in.read ( by , 0 , (int)len );
						}			
						Buffout.flush();

					}else{
						response.setContentType("application/vnd.ms-word");
						response.setHeader("Content-Disposition","attachment;filename="+imageName);
						response.setHeader("cache-control", "must-revalidate");
						hist_blob  =  (java.sql.Blob)rs.getBlob("IMAGE_CONTENT");
						in = hist_blob.getBinaryStream();
						len = hist_blob.length();					
					
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);

						while(index != -1)
						{
							Buffout.write(by , 0, index);
							index = in.read ( by , 0 , (int)len );
						}			
						Buffout.flush();
					}					
				} 			
				
			}
		}
		
	}catch(Exception e){
		e.printStackTrace();		
	}finally{
		ConnectionManager.returnConnection(con,request);

		if(rs!=null)
			rs.close();
			
		if(ptsmt!=null)
			ptsmt.close();
			
		
	}
	
%>
