<!DOCTYPE html>
<%
/*

-----------------------------------------------------------------------------------------------------------------------
Date		Edit History	NIN063885ame		Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------

07/07/2018   IN066677       Ramesh Goli        10/07/2018        Ramesh G
19/05/2020	IN070345		Ramesh Goli		19/05/2020		Ramesh G		MO-CRF-20147.1
05/07/2023	34798			Twinkle Shah		05/07/2023		Ramesh Goli			MO-GN-5573

-----------------------------------------------------------------------------------------------------------------------
*/ 
%>

<%@ page import="java.sql.*,java.io.*,webbeans.eCommon.*,javax.servlet.*" contentType="text/html;charset=UTF-8"%>

<%
    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement ptsmt = null;
	PreparedStatement psDataMigration = null; //IN066677
	ResultSet rs = null;
	ResultSet rsDataMigration = null; //IN066677

	java.sql.Blob hist_blob = null;
	BufferedOutputStream Buffout = null;
	//	byte bytearr[] = new byte[1024*1024];

	String qryHistData = "";
	String accession_num = request.getParameter("accession_num")==null?"":request.getParameter("accession_num");
	String note_type = request.getParameter("note_type")==null?"":request.getParameter("note_type");
	String previewMode = request.getParameter("previewMode")==null?"":request.getParameter("previewMode");
	String docType = request.getParameter("docType")==null?"":request.getParameter("docType");
	String image_name = request.getParameter("image_name")==null?"":request.getParameter("image_name");
	String qryPathForMigrationNote = "";  //IN066677
	String migrationDataPathName = "";   //IN066677
	

	try
	{
		
		if(!previewMode.equals("Y"))
		{
			con = ConnectionManager.getConnection(request);
			/*qryHistData = "select OBJTYPE, HIST_DATA from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ?";*/ //IN066677
			//	IN070345 Start.		
			//qryHistData = "select OBJTYPE, HIST_DATA,NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN,FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ?";//IN066677
			qryHistData = "select OBJTYPE, HIST_DATA,NVL(DATA_MIGRATION_YN,'N') DATA_MIGRATION_YN,FILE_NAME, SHARED_FILE_PATH, SHARED_FILE_NAME from CR_ENCOUNTER_DETAIL_OBJ where ACCESSION_NUM = ? and CONTR_SYS_EVENT_CODE = ?";
			// IN070345 End.
			ptsmt = con.prepareStatement(qryHistData);
			ptsmt.setString(1,accession_num);
			ptsmt.setString(2,note_type);
			rs = ptsmt.executeQuery();
			if(rs.next()) {					
					String[] objArray =((String)rs.getString("OBJTYPE")).split("\\/"); //IN049722
					String dataMigrationYN = (String)rs.getString("DATA_MIGRATION_YN"); //IN066677	
					String sharedFilePath = rs.getString("SHARED_FILE_PATH")==null?"":(String)rs.getString("SHARED_FILE_PATH"); //IN070345
					String sharedFileName = rs.getString("SHARED_FILE_NAME")==null?"":(String)rs.getString("SHARED_FILE_NAME"); //IN070345
					
					if("image".equals(objArray[0])){  //IN049722
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
					//IN049722 Start.
					//IN066677 Start
					}else if("Y".equals(dataMigrationYN) && "application".equals(objArray[0]) && "msword".equals(objArray[1])){
						try{
							qryPathForMigrationNote = "SELECT PATH_FOR_MIGRATION_NOTES FROM CA_NOTE_PARAM";
							psDataMigration = con.prepareStatement(qryPathForMigrationNote);
							rsDataMigration = psDataMigration.executeQuery();
							if(rsDataMigration.next()) {	
								migrationDataPathName = (String)rsDataMigration.getString("PATH_FOR_MIGRATION_NOTES");
							}
							String fileName = (String)rs.getString("FILE_NAME");						
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
						
					}else{
						//IN070345 Start.
						InputStream in =null;
						long len=0;
						if(!"".equals(sharedFilePath) && !"".equals(sharedFileName)){				
							File file =new File(sharedFilePath+"/"+sharedFileName);
							if(file.exists()){
								in = new FileInputStream(file);
								len = file.length();
								Buffout = new BufferedOutputStream( response.getOutputStream() );
								byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
								int index = in.read(by , 0 , (int)len);
								response.setContentType((String)rs.getString("OBJTYPE")); //34798
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
						//IN070345 End.
							response.setContentType(rs.getString("OBJTYPE"));
							hist_blob  =  (java.sql.Blob)rs.getBlob("HIST_DATA");
							in = hist_blob.getBinaryStream();
							len = hist_blob.length();
							Buffout = new BufferedOutputStream( response.getOutputStream() );
							byte[] by = new byte[(int)len]; // 4K buffer buf, 0, buf.length
							int index = in.read(by , 0 , (int)len);

							while ( index != -1) {
							Buffout.write(by , 0, index);
							index = in.read ( by , 0 , (int)len );
							}
							Buffout.flush();
						} //IN070345.
						
						
					}
					//IN049722 End.
			}				
	
		}else{
		/*******************************************************/

			StringBuffer note_image_rep_folder	= new StringBuffer();
			String path	="";
			String strFileSep="";
			java.util.Properties pFileSep	= null;
			path					= config.getServletContext().getRealPath("/");
			note_image_rep_folder.append(path);
			pFileSep	= System.getProperties();
			strFileSep	= (String) pFileSep.getProperty("file.separator");
		//	note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("eCA");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("MediPainter");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append("images");
			note_image_rep_folder.append(strFileSep);
			note_image_rep_folder.append(image_name);
			String filename			=	note_image_rep_folder.toString();
			File file = null;
			InputStream inpts=null;

			//ByteArrayOutputStream bytearrayoutputstream = null;
			boolean deleted=false;
			try{
			file = new File(filename);
			//if(mode.equals("insert") || (imgExists.equals(""))){
			docType = request.getParameter("docType")==null?"":request.getParameter("docType");
					
			
			response.setContentType(docType);
			
	
			if(file.exists()){// if the file exists in the folder,read from the folder else read from the database.
				int  size=(int)file.length();
				inpts = new FileInputStream(file);			
				BufferedOutputStream Buffout1 = new BufferedOutputStream( response.getOutputStream() );			
				byte[] by = new byte[(int)size]; // 4K buffer buf, 0, buf.length
				int index = inpts.read(by , 0 ,(int)size);
				while ( index != -1) {
					Buffout1.write(by , 0, index);
					index = inpts.read ( by , 0 ,(int)size );
				}
				Buffout1.flush();
				inpts.close();
				//if(mode.equals("insert") || (imgExists.equals(""))){
					if(file !=null){	
						
						deleted=file.delete();	

					}
				
				//}				
	
			}
						
			}catch(Exception e){

				e.printStackTrace();
			}			
		
		}
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);

		if(rs!=null)
			rs.close();
			
		if(ptsmt!=null)
			ptsmt.close();
			
		if(rsDataMigration!= null)
			rsDataMigration.close();
			
		if(psDataMigration!= null)
			psDataMigration.close();
			
			
	}
%>

