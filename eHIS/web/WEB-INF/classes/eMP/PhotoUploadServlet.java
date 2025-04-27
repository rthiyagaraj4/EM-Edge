/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eMP;
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
/*Added By Dharma against MO-CRF-20154 [IN:070025] Start*/
import eCommon.DocumentFileStorage;
import eMP.DocumentConfigOption;
import org.apache.commons.io.*;
/*Added By Dharma against MO-CRF-20154 [IN:070025] End*/

import eCommon.SingleTabHandler.*;

public class PhotoUploadServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel {
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
	
		/*Added By Dharma against MO-CRF-20154 [IN:070025] Start*/ 
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
		/*Added By Dharma against MO-CRF-20154 [IN:070025] End*/

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
			conn = ConnectionManager.getConnection();
			conn.setAutoCommit(false);
			if(photoCount!=null && photoCount.equals("0")){

				String insertSQL	="insert into mp_patient_photo (PATIENT_ID) values(?)";
				pstmt=conn.prepareStatement(insertSQL);
				pstmt.setString(1,patient_id);
				rsval=pstmt.executeUpdate();
				if (pstmt != null) pstmt.close();
			}
			
			/*Added By Dharma against MO-CRF-20154 [IN:070025] Start*/
			sFileSeparator = System.getProperty("file.separator");
			oDocConfigList = docConfigOption.getDocumentConfigDetails(facilityId,"PP","P");  

			nDocConfigListsize = oDocConfigList.size();
			if (nDocConfigListsize>0) {	
				oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
				
				facilityId 	= oDocumentConfigBean.getsFacilityId();
				iphotoFolderOption = oDocumentConfigBean.getsPhotoDocOption();  
				iPhotoSharedpath = oDocumentConfigBean.getsDocSharedPath();  
				sWebServiceUrl = oDocumentConfigBean.getsDocWebserviceUrl();  
				sDocType=oDocumentConfigBean.getsDocType();
			}    
			else{
				System.out.println("List size is null...document section was not configured..documents will be stored in db"); 						
			}

			/*Added By Dharma against MO-CRF-20154 [IN:070025] End*/


			String deleteSQL	="update mp_patient_photo set PAT_PHOTO_BLOB = empty_blob() where PATIENT_ID=?";
			pstmt=conn.prepareStatement(deleteSQL);
			pstmt.setString(1,patient_id);
			int updt_blob_result = pstmt.executeUpdate();
			if (pstmt != null) pstmt.close();
			if(updt_blob_result > 0){

			if (iphotoFolderOption ==0){
				java.sql.Blob img_blob = null;	
				java.io.OutputStream blobOutputStream = null;
				String updateSQL = "select PAT_PHOTO_BLOB from mp_patient_photo WHERE PATIENT_ID = ? for update";
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

				

				/*Added By Dharma against MO-CRF-20154 [IN:070025] Start*/
				if (iphotoFolderOption == 1 && fileItem!=null ) {

					newFileFolder = iPhotoSharedpath;

					sFileSeparator = sFileSeparator + sFileSeparator;
					dFileStorage = new DocumentFileStorage();
					if (fileItem!=null){
						aFileName = fileItem.getName();
						sFileExt = FilenameUtils.getExtension(aFileName);
						sfileDir = dFileStorage.getFilePath(newFileFolder,sDocType,"P");  
						sFileName = dFileStorage.getFileName(patient_id, sDocType,"P");
						bFileFlag = dFileStorage.saveFileToDir(fileItem, sFileName, sFileExt, sfileDir);
						sFilePath = sfileDir + sFileSeparator + sFileName + "." +sFileExt;

					}
				}

				/*Added By Dharma against MO-CRF-20154 [IN:070025] End*/


				String updateSql1 = "update mp_patient_photo set modified_by_id = ?,modified_date = sysdate,modified_at_ws_no = ?, modified_facility_id = ? ,PHOTO_DB_FLAG=? , PHOTO_IMAGE_PATH = ?  where patient_id = ?";
				pstmt=conn.prepareStatement(updateSql1);
				pstmt.setString(1,modifiedbyid);
				pstmt.setString(2,modifiedAtWorkstation);
				pstmt.setString(3,facilityId);
				pstmt.setInt(4,iphotoFolderOption);
				pstmt.setString(5,sFilePath);
				pstmt.setString(6,patient_id);
				pstmt.executeUpdate();
				 						
				conn.commit();
				 if(pstmt!=null)	pstmt.close();  //Added for checkstyle
				MessageManager mm=new MessageManager();
				final java.util.Hashtable mesg = mm.getMessage(locale, "RECORD_INSERTED", "SM") ;
				/* below block added for smart card *****/

				pstmt = conn.prepareStatement("select VALUE_1 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID");

				ResultSet rs_phot_path= pstmt.executeQuery();	
				String Smartcard_path="NO_PATH";
				String photo_path="";
				if(rs_phot_path!=null && rs_phot_path.next()){
					Smartcard_path=rs_phot_path.getString("VALUE_1");
				}	
				
				if(!Smartcard_path.equals("NO_PATH")){					
					StringTokenizer strtok=new StringTokenizer(Smartcard_path,"\\");
					int i=0;
					int tkn_count=0;
					tkn_count=strtok.countTokens();					
					while(strtok.hasMoreTokens()) {
						i=i+1;
						if(i<tkn_count){
							photo_path=photo_path+strtok.nextToken()+"\\\\";						
						}else{
							strtok.nextToken();
						}
						
					}
					if(rs_phot_path!=null) rs_phot_path.close();
                    if(pstmt!=null)	pstmt.close();    
					pstmt = conn.prepareStatement("select nvl(national_id_no,'XXX') national_id_no,nvl(OTH_ALT_ID_NO,'XXX') oth_alt_id_no from mp_patient where patient_id='"+patient_id+"'");
					rs_phot_path= pstmt.executeQuery();
					String nat_id_no="";
					String oth_alt_id_no="";
					if(rs_phot_path!=null && rs_phot_path.next()){
						nat_id_no=rs_phot_path.getString("national_id_no");
						oth_alt_id_no=rs_phot_path.getString("oth_alt_id_no");
						
						if(! nat_id_no.equals("XXX")){
							nat_id_no=nat_id_no.substring(0,2)+"-"+nat_id_no.substring(2);
						}else{
							nat_id_no=oth_alt_id_no.substring(0,2)+"-"+oth_alt_id_no.substring(2);
						}
						
						photo_path=photo_path+"photo_"+nat_id_no+".jpg";

					}							
					
				}
				
				if(rs_phot_path!=null) rs_phot_path.close();
				if(pstmt!=null)	pstmt.close();
				
				if(!Smartcard_path.equals("NO_PATH")){
					//out.println("<script>fso = new ActiveXObject('Scripting.FileSystemObject');");
					out.println("<script>fso = '';");
					out.println("if(fso.FileExists('"+photo_path+"')){");
					out.println("fso.deleteFile('"+photo_path+"');");
					out.println("}</script>");
				}
				/*  block added for smart card *****/
				String msg = ((String) mesg.get("message"));
				out.println("<script>alert('"+msg+"')</script>");
				mesg.clear();
			}
		}catch(Exception ex){
			
			out.println("<script>alert('failed to insert')</script>");
			try{
				conn.rollback();
			}catch(Exception e2){
				e2.printStackTrace();
			}
			ex.printStackTrace();
		}finally{
			//out.println("<script>parent.window.close();</script>");
			out.println("<script>var dialogTag = parent.parent.document.getElementById('dialog_tag').close();</script>");
			try{
				if(conn !=null)ConnectionManager.returnConnection(conn,req);
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}//ed of finally
	}//end of post
}//end of class
