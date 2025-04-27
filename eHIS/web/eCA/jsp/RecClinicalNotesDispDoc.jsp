<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------
14/11/2016    IN061736     Raja S                                           BSP-SCF-0008
07/07/2018   IN066677       Ramesh Goli        10/07/2018        Ramesh G           ML-MMOH-CRF-1099
19/05/2020	IN070345		Ramesh Goli		19/05/2020		Ramesh G		MO-CRF-20147.1
13/12/2022	37958			Ramesh Goli		13/12/2022		Ramesh G			ML-MMOH-CRF-1977
04/07/2023	34798			Twinkle 		04/07/2023		Ramesh G			MO-GN-5573

-------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%> 
<%@ page import="java.sql.*,java.io.*,webbeans.eCommon.*,javax.servlet.*,eCA.*, eCA.RecClinicalNotesMultiFileUploadBean.NoteDoc" contentType="text/html;charset=UTF-8"%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<%
    request.setCharacterEncoding("UTF-8");
	String fileName = request.getParameter("fileName")==null?"":request.getParameter("fileName");
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String file_seq_no = request.getParameter("file_seq_no")==null?"":request.getParameter("file_seq_no");
	RecClinicalNotesMultiFileUploadBean fbean = (RecClinicalNotesMultiFileUploadBean) getObjectFromBean("MULTIFILEUPLOADBEAN", "eCA.RecClinicalNotesMultiFileUploadBean", session);
	java.sql.Blob hist_blob = null;
	BufferedOutputStream Buffout = null;
	InputStream in = fbean.getFileInputStream(fileName);
	long len = fbean.getFileSize(fileName);
	String contentType = fbean.getFileType(fileName);
	if((accession_num.equals("") && note_type.equals("")))
	{
		if(in != null && len != -1 && contentType != null)
			{
			response.setContentType(contentType);
			String[] objArray =contentType.split("\\/");
			//IN061736 starts
			if("image".equals(objArray[0])){
				byte[] by = new byte[(int)len]; 
				int index = in.read(by, 0, (int)len);  
	   		    response.reset();  
				response.setContentType(contentType);  
				response.getOutputStream().write(by, 0, (int)len);  
				response.getOutputStream().flush(); 
			}
			else{
			//IN061736 issue ends
			Buffout = new BufferedOutputStream( response.getOutputStream() );
			byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
			int index = in.read(by , 0 , (int)len);

			while(index != -1)
			{
				Buffout.write(by , 0, index);
				index = in.read ( by , 0 , (int)len );
			}
			Buffout.flush();
			}//Added for IN061736 
		}
		else
		{%>
			<script>
				//alert("Unkown Error len = <%=len%> , contentType = <%=contentType%> , in = <%=(in != null)%>  --------------> add to msg");
				parent.window.close();
			</script>
		<%}	
	}
	else
	{
		Connection con = null;
		PreparedStatement pst = null;
		PreparedStatement psDataMigration = null; //IN066677
		ResultSet rs = null;
		ResultSet rsDataMigration = null; //IN066677
		String qryPathForMigrationNote = "";  //IN066677
		String migrationDataPathName = "";   //IN066677

		try
		{
			con = ConnectionManager.getConnection(request);
			// IN066677 Start.
			//String qryHistData = "select OBJTYPE, HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? and FILE_SEQ_NO = ?";
			//IN070345 Start.
			//String qryHistData = "select OBJTYPE, HIST_DATA,NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN,FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? and FILE_SEQ_NO = ?";//IN066677
			//37958 Start
			//String qryHistData = "select OBJTYPE, HIST_DATA, NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN, FILE_NAME, SHARED_FILE_PATH, SHARED_FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ? and FILE_SEQ_NO = ?";//IN066677
			String qryHistData = "select OBJTYPE, HIST_DATA, NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN, FILE_NAME, SHARED_FILE_PATH, SHARED_FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? /*and CONTR_SYS_EVENT_CODE = ?*/ and FILE_SEQ_NO = ?";//IN066677
			
			//37958End.
			//IN070345 End.
			//IN066677 End.
			pst = con.prepareStatement(qryHistData);
			pst.setString(1, accession_num);
			////37958 Start.
			//pst.setString(2, note_type);
			//pst.setString(3, file_seq_no);
			pst.setString(2, file_seq_no);
			//37958 End.
			rs = pst.executeQuery();
 
			while(rs.next())
			{
			//IN061736 changes Starts
				String[] objArray =((String)rs.getString("OBJTYPE")).split("\\/");
				String dataMigrationYN = (String)rs.getString("DATA_MIGRATION_YN"); //IN066677
				String sharedFilePath = rs.getString("SHARED_FILE_PATH")==null?"":(String)rs.getString("SHARED_FILE_PATH"); //IN070345
				String sharedFileName = rs.getString("SHARED_FILE_NAME")==null?"":(String)rs.getString("SHARED_FILE_NAME"); //IN070345
			if("image".equals(objArray[0])){
				//IN070345 Start.
				InputStream readImg =null;
				long len1=0;
				if(!"".equals(sharedFilePath) && !"".equals(sharedFileName)){				
					File file =new File(sharedFilePath+"/"+sharedFileName);
					if(file.exists()){
						readImg = new FileInputStream(file);
						len1 = file.length();
					}else{
						String errorMsg="Unable to Retrieve. File Server is not Responding or File is Unavailable. Please contact administrator.";
						readImg = new ByteArrayInputStream(errorMsg.getBytes("UTF-8"));
						len1 = errorMsg.length();
					}
				}else{
				//IN070345 End.
					hist_blob  =  (java.sql.Blob)rs.getBlob("HIST_DATA");        	 
					len1 = hist_blob.length(); 					  
					readImg = hist_blob.getBinaryStream();  
				} //IN070345
				byte[] by = new byte[(int)len1]; 
				int index = readImg.read(by, 0, (int)len1);					
				response.reset();  
				response.setContentType(rs.getString("OBJTYPE"));  
				response.getOutputStream().write(by, 0, (int)len1);  
				response.getOutputStream().flush();  
			}
			else if("Y".equals(dataMigrationYN) && "application".equals(objArray[0]) && "msword".equals(objArray[1])){
				try{
					qryPathForMigrationNote = "SELECT PATH_FOR_MIGRATION_NOTES FROM CA_NOTE_PARAM";
					psDataMigration = con.prepareStatement(qryPathForMigrationNote);
					rsDataMigration = psDataMigration.executeQuery();
					if(rsDataMigration.next()) {	
						migrationDataPathName = (String)rsDataMigration.getString("PATH_FOR_MIGRATION_NOTES");
					}
					System.out.println("migrationDataPathName=>"+migrationDataPathName);
					fileName = (String)rs.getString("FILE_NAME");						
					String fileFullPath			=	migrationDataPathName+fileName;
					
					File file = null;			
					InputStream inpStrem = null;		
					
					file = new File(fileFullPath);								
					if(file.exists()){
						
						int  fileSize=(int)file.length();					
						inpStrem=new FileInputStream(file);
						byte[] byArray = new byte[(int)fileSize];
						response.reset();								
						response.setContentType((String)rs.getString("OBJTYPE"));
						while((fileSize=inpStrem.read(byArray))!= -1 )
						{
						response.getOutputStream().write(byArray,0,fileSize);
						}
						response.flushBuffer();
						inpStrem.close();					
					}
				}catch(Exception e){

					e.printStackTrace();
				}finally{
					if(rsDataMigration!=null)
						rsDataMigration.close();
					if(psDataMigration!=null)
						psDataMigration.close();
				}
				//IN066677 End
				
			}
			else{
			//IN061736 Changes Ends	
				//IN070345 Start.
				if(!"".equals(sharedFilePath) && !"".equals(sharedFileName)){				
					File file =new File(sharedFilePath+"/"+sharedFileName);
					if(file.exists()){
						in = new FileInputStream(file);
						len = file.length();
						Buffout = new BufferedOutputStream( response.getOutputStream() );
						byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
						int index = in.read(by , 0 , (int)len);
						response.setContentType((String)rs.getString("OBJTYPE")); //34798
						while( index != -1) 
						{
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
				//IN070345 End.
					response.setContentType(rs.getString("OBJTYPE"));
					hist_blob  =  (java.sql.Blob)rs.getBlob("HIST_DATA");
					in = hist_blob.getBinaryStream();
					len = hist_blob.length();
					
					Buffout = new BufferedOutputStream( response.getOutputStream() );
					byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
					int index = in.read(by , 0 , (int)len);

					while( index != -1) 
					{
						Buffout.write(by , 0, index);
						index = in.read ( by , 0 , (int)len );
					}
					Buffout.flush();
				}//IN070345
				
			} //Added closing braces for IN061736 	
			}	
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if(rs!=null)
				rs.close();
			if(pst!=null)
				pst.close();
			ConnectionManager.returnConnection(con,request);
		}
	}
%>
