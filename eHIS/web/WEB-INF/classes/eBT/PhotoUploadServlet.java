/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eBT;
import java.sql.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.util.*;
import javax.naming.*;
import javax.rmi.*;
import java.text.*;
import javax.servlet.http.HttpUtils.*;
import webbeans.eCommon.*;
import org.apache.commons.fileupload.*;
import java.net.*;

import eCommon.DocumentFileStorage;
import eMP.DocumentConfigOption;
import eMP.DocumentConfigBean;
import org.apache.commons.io.*;
//import eCommon.SingleTabHandler.*;

public class PhotoUploadServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	Connection conn=null;
	String facilityId ;
	HttpSession session;
	boolean isMultipart				= false;
	FileItem Item					= null;
	FileItem fileItem				= null;
	DiskFileUpload upload			= null;
	long	docSize					= 0;
	String	docName					= "";
	String	docType					= "";
	List items						= null;
	Iterator iter					= null;
	java.io.InputStream instream	= null;
	String patient_id=null;
	String photoCount=null;
	String facility_id=null;
	String user_id=null;
	String ws_no=null;
	PreparedStatement pstmt=null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	} 

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		session = req.getSession(false);
		docSize					= 0;
		docName					= "";
		docType					= "";
		fileItem				=null;
		int rsval				= 0;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.out = res.getWriter();
		String modifiedbyid = p.getProperty("login_user");
		String modifiedAtWorkstation = p.getProperty("client_ip_address");
		isMultipart				= FileUpload.isMultipartContent(req);
		String locale		    =   p.getProperty("LOCALE");

		//Added by Bhuvaneshwari for MO-CRF-20154.2 on 11/06/2019
		
		/* int iDocFolderOption = 0; 
		String sDocSharedPath = ""; */ //Common-ICN-0045
		int iphotoFolderOption = 0;
		
		String iPhotoSharedpath = "";
		String sWebServiceUrl = ""; 
		String sDocType="";
		int nDocConfigListsize = 0;
		DocumentConfigOption docConfigOption = new DocumentConfigOption(); 
		List<DocumentConfigBean> oDocConfigList = null;
		DocumentConfigBean oDocumentConfigBean = null;	
		oDocConfigList = new ArrayList<DocumentConfigBean>();

		
		String sfileDir = "", aFileName = "", sFileExt = "", sFilePath = "",sFileName="" ;
		DocumentFileStorage dFileStorage = null;
		String sFileSeparator = "";
		boolean bFileFlag = false;
		String newFileFolder = "";

		//Code ends here Added by Bhuvaneshwari for MO-CRF-20154.2 on 11/06/2019


		try{
			if(isMultipart){
				upload			= new DiskFileUpload();
				items			= upload.parseRequest(req);
				iter			= items.iterator();
				String name		= "";
				String value	= "";
				while(iter.hasNext()){
					Item = (FileItem)iter.next();
					if(Item.isFormField()){
						name		= Item.getFieldName();
						value		= Item.getString();
						if(name.equals("patient_id")) patient_id=value;
						if(name.equals("photoCount")) photoCount=value;
					}else{
						fileItem	= Item;
						docName		= Item.getName();
						docType		= Item.getContentType();
						docSize		= Item.getSize();
						if(docType == null)
							docType = "999";
					}
				}
			}


		}catch(Exception e){
			e.printStackTrace();
		}

		try{

				//Added by Bhuvaneshwari for MO-CRF-20154.2 on 11/06/2019
				sFileSeparator = System.getProperty("file.separator");
				oDocConfigList = docConfigOption.getDocumentConfigDetails(facilityId,"BD","P");  

				nDocConfigListsize = oDocConfigList.size();
				System.out.println("nDocConfigListsize::"+nDocConfigListsize);
				System.out.println("iphotoFolderOption::"+iphotoFolderOption);
				System.out.println("iPhotoSharedpath:::"+iPhotoSharedpath);
				if (nDocConfigListsize>0)
				{	
					System.out.println("list is not null");
					oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
					
					facilityId 	= oDocumentConfigBean.getsFacilityId();
					iphotoFolderOption = oDocumentConfigBean.getsPhotoDocOption();  
					iPhotoSharedpath = oDocumentConfigBean.getsDocSharedPath();  
					sWebServiceUrl = oDocumentConfigBean.getsDocWebserviceUrl();  
					sDocType=oDocumentConfigBean.getsDocType();
					System.out.println("iphotoFolderOption::::::::"+iphotoFolderOption);
					System.out.println("iPhotoSharedpath::::::::"+iPhotoSharedpath);
					System.out.println("sDocType::::::::"+sDocType);

				}    
				else{
					System.out.println("List size is null...document section was not configured..documents will be stored in db"); 						
				}

				//Code ends here Added by Bhuvaneshwari for MO-CRF-20154.2 on 11/06/2019

				conn = ConnectionManager.getConnection(req);
				conn.setAutoCommit(false);
				if(photoCount!=null && photoCount.equals("0")){

					String insertSQL	="insert into mp_ext_person_photo (PERSON_ID,ADDED_BY_ID,ADDED_AT_WS_NO,ADDED_FACILITY_ID) values(?,?,?,?)";
					pstmt=conn.prepareStatement(insertSQL);
					pstmt.setString(1,patient_id);
					pstmt.setString(2,modifiedbyid);
					pstmt.setString(3,modifiedAtWorkstation);
					pstmt.setString(4,facilityId);
					rsval=pstmt.executeUpdate();
					if (pstmt != null) pstmt.close();			

				}
				
				String deleteSQL	="update mp_ext_person_photo set PERSON_PHOTO_BLOB = empty_blob() where PERSON_ID=?";

				if (iphotoFolderOption == 0 && fileItem!=null ) { //Condition Added by Bhuvaneshwari for MO-CRF-20154.2 on 11/06/2019
				
					pstmt=conn.prepareStatement(deleteSQL);
					pstmt.setString(1,patient_id);
					int updt_blob_result = pstmt.executeUpdate();
					if (pstmt != null) pstmt.close();
					if(updt_blob_result > 0){
						java.sql.Blob img_blob = null;	
						java.io.OutputStream blobOutputStream = null;
						String updateSQL = "select PERSON_PHOTO_BLOB from mp_ext_person_photo WHERE PERSON_ID = ? for update";
						pstmt=conn.prepareStatement(updateSQL);
						pstmt.setString(1,patient_id);
						ResultSet rsupdt= pstmt.executeQuery();
						while(rsupdt!=null && rsupdt.next()){
							img_blob			=	(java.sql.Blob)rsupdt.getBlob(1);
							blobOutputStream	= img_blob.setBinaryStream(0);
							int docs			=	 (int)docSize;
							blobOutputStream.write(fileItem.get(),0,docs);
							blobOutputStream.close();
						}
						if(rsupdt!=null) rsupdt.close();
						if(pstmt!=null)	pstmt.close();
					}
				}					

				if (iphotoFolderOption == 1 && fileItem!=null ) {

					newFileFolder = iPhotoSharedpath;

					sFileSeparator = sFileSeparator + sFileSeparator;
					dFileStorage = new DocumentFileStorage();
					if (fileItem!=null){
						aFileName = fileItem.getName();
						sFileExt = FilenameUtils.getExtension(aFileName);
						
						sfileDir = dFileStorage.getFilePath(newFileFolder,sDocType,"P");  
						System.out.println("sfileDir==>"+sfileDir);
						sFileName = dFileStorage.getFileName(patient_id, sDocType,"P");
						System.out.println("sFileName==>"+sFileName);
						bFileFlag = dFileStorage.saveFileToDir(fileItem, sFileName, sFileExt, sfileDir);
						sFilePath = sfileDir + sFileSeparator + sFileName + "." +sFileExt;
						System.out.println("sFileName==>"+sFilePath);

					}
				}

				String updateSql1 = "update mp_ext_person_photo set modified_by_id = ?, modified_date = sysdate, modified_at_ws_no = ?, modified_facility_id = ? , PHOTO_DB_FLAG=? , PHOTO_IMAGE_PATH = ? , DOC1_UPLOAD_FLAG = ? where person_id = ?";
				//pstmt=conn.prepareStatement(updateSql1);
				
				pstmt=conn.prepareStatement(updateSql1);
				pstmt.setString(1,modifiedbyid);
				pstmt.setString(2,modifiedAtWorkstation);
				pstmt.setString(3,facilityId);
				pstmt.setInt(4,iphotoFolderOption);
				pstmt.setString(5,sFilePath);
				pstmt.setInt(6,iphotoFolderOption); //Added by Bhuvaneshwari for MO-CRF-20154.2 on 12/06/2019 
				pstmt.setString(7,patient_id);
				
				pstmt.executeUpdate();
				
				 						
				conn.commit();
				MessageManager mm=new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				String msg = ((String) mesg.get("message"));
				out.println("<script>alert('"+msg+"')</script>");
				mesg.clear();
				
			//if(pstmt !=null)pstmt.close(); //Common-ICN-0045
				
			}catch(Exception ex){
			System.out.println (" Photoupload Servlet "+ex);
			out.println("<script>alert('failed to insert')</script>");
			try{
				conn.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
			ex.printStackTrace();
		}finally{
			out.println("<script>parent.window.close();</script>");
			try{
				if(pstmt !=null)pstmt.close(); //Common-ICN-0045
				if(conn !=null)conn.close();
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}//end of finally
	}//end of post
}//end of class
