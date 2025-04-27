/**
 * Edited by prithivi on 9/10/2015. Changed the logic as converted into single try-catch block for authentication problem.
 */

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

import eCommon.SingleTabHandler.*;

import eCommon.DocumentFileStorage;
import eMP.DocumentConfigOption;
import org.apache.commons.io.*;

import eCommon.XSSRequestWrapper;//Added by Kamatchi S for security issue against COMMON-ICN-0187

public class DocUploadServlet extends javax.servlet.http.HttpServlet implements SingleThreadModel
{
	PrintWriter out;
	java.util.Properties p;
	Connection conn=null;
	String facilityId ;
	HttpSession session;
	boolean isMultipart				= false;
	FileItem Item					= null;
	FileItem fileItem1				= null;
	FileItem fileItem2				= null;
	FileItem fileItem3				= null;
	FileItem fileItem4				= null;
	DiskFileUpload upload			= null;
	long	docSize1					= 0;
	long	docSize2					= 0;
	long	docSize3					= 0;
	long	docSize4					= 0;
	String	docName1					= "";
	String	docName2					= "";
	String	docName3					= "";
	String	docName4					= "";
	String	docType1					= "";
	String	docType2					= "";
	String	docType3					= "";
	String	docType4				= "";
	String	output				= "";
	String 	funCall	 = "";
	String	bl_success_msg				= "";
	List items						= null;
	Iterator iter					= null;
	java.io.InputStream instream	= null;
	String patient_id=null;

	PreparedStatement pstmt=null;

	public void init(ServletConfig config) throws ServletException
	{
		super.init(config);
	} 

	public synchronized void doPost(HttpServletRequest req, HttpServletResponse res) throws javax.servlet.ServletException,IOException{
		req.setCharacterEncoding("UTF-8");
		res.setContentType("text/html;charset=UTF-8");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187
		req = new XSSRequestWrapper(req);
		res.addHeader("X-XSS-Protection", "1; mode=block");
		res.addHeader("X-Content-Type-Options", "nosniff");
		//Added by Kamatchi S for security issue against COMMON-ICN-0187 END
		session = req.getSession(false);
		//docSize					= 0;
		//docName					= "";
		//docType					= "";
		fileItem1				= null;
		fileItem2				= null;
		fileItem3				= null;
		fileItem4				= null;
		this.p = (java.util.Properties) session.getValue( "jdbc" ) ;
		this.facilityId = (String) session.getValue( "facility_id" ) ;
		this.out = res.getWriter();

		// Added by Sethu for AAKH-CRF-0075
		DocumentConfigOption docConfigOption = new DocumentConfigOption(); 	
		List<DocumentConfigBean> oDocConfigList = null;
		DocumentConfigBean oDocumentConfigBean = null;	
		oDocConfigList = new ArrayList<DocumentConfigBean>();

		String sFacilityId = "";
		//int iDocScanEnabled = 0;	
		//int iDocSaveAs = 0; 
		int iDocFolderOption = 0; 
		String sDocSharedPath = "";
		String sWebServiceUrl = ""; 
		String sDocType="";
		//int iDocCheckStatus = 0; 
		int nDocConfigListsize = 0;

		String newFileFolder = "";

		sFacilityId = this.facilityId;

		DocumentFileStorage dFileStorage = null;

		String sfileDir = "", sFileName1 = "", sFileName2 = "", sFileName3 = "", sFileName4 = "";
		String aFileName1 = "", aFileName2 = "", aFileName3 = "", aFileName4 = "";
		String sFileExt1 = "", sFileExt2 = "", sFileExt3 = "", sFileExt4 = "";
		String sFilePath1 = "", sFilePath2 = "", sFilePath3 = "", sFilePath4 = "";
		boolean bFileFlag = false;
		String exceptionMessage="Failed to insert patient Document";

		String ext = "";
		String sFileSeparator = "";
		// Added by Sethu for AAKH-CRF-0075
	
		
		isMultipart				= FileUpload.isMultipartContent(req);
		
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
						
						if(name.equals("funCall")) funCall=value;
						if(name.equals("upload_patient_id")) patient_id=value;				
						if(name.equals("output")) output=value;						
						if(name.equals("bl_success_msg")) bl_success_msg=value;
					
						
					}else{
						name		= Item.getFieldName();
						if(fileItem1 == null && name.equals("doc1image")){							
							docName1		= Item.getName();							
							if(!docName1.equals(""))fileItem1	= Item;
							docType1		= Item.getContentType();
							docSize1		= Item.getSize();						
							if(docType1 == null)docType1 = "999";
						}else if(fileItem2 == null && name.equals("doc2image")){							
							docName2		= Item.getName();
							if(!docName2.equals(""))fileItem2	= Item;
							docType2		= Item.getContentType();
							docSize2		= Item.getSize();						
							if(docType2 == null)docType2 = "999";
						}else if(fileItem3 == null && name.equals("doc3image")){							
							docName3		= Item.getName();
							if(!docName3.equals(""))fileItem3	= Item;
							docType3		= Item.getContentType();
							docSize3		= Item.getSize();					
							if(docType3 == null)docType3 = "999";
						}else if(fileItem4 == null && name.equals("doc4image")){							
							docName4		= Item.getName();
							if(!docName4.equals(""))fileItem4	= Item;
							docType4	= Item.getContentType();
							docSize4		= Item.getSize();						
							if(docType4 == null)docType4 = "999";
						}						
					}
				}
			}


		}catch(Exception e){
			e.printStackTrace();
		}

		// Added by Sethu for AAKH-CRF-0075
		
		try{
			sFileSeparator = System.getProperty("file.separator");
			
			if ((fileItem1!=null) || (fileItem2!=null) || (fileItem3!=null) || (fileItem4!=null)){

				oDocConfigList = docConfigOption.getDocumentConfigDetails(sFacilityId,"MP");  // Added by prithvi on 27/08/2015

				nDocConfigListsize = oDocConfigList.size();
				if (nDocConfigListsize>0)
				{	
					System.out.println("list is not null");
					oDocumentConfigBean = oDocConfigList.get(nDocConfigListsize-1);		
					
					sFacilityId 	= oDocumentConfigBean.getsFacilityId();
					//iDocScanEnabled = oDocumentConfigBean.getiDocScanEnabled();
					//iDocSaveAs = oDocumentConfigBean.getiDocSaveAs();  
					iDocFolderOption = oDocumentConfigBean.getiDocFolderOption();  
					sDocSharedPath = oDocumentConfigBean.getsDocSharedPath();  
					sWebServiceUrl = oDocumentConfigBean.getsDocWebserviceUrl();  
					//iDocCheckStatus = oDocumentConfigBean.getiDocCheckStatus();
					sDocType=oDocumentConfigBean.getsDocType();
					 
					System.out.println("iDocFolderOption::::::::"+iDocFolderOption);
					System.out.println("sDocSharedPath::::::::"+sDocSharedPath);

				}     //changed by prithivi for AAKH-058574 on 08/12/2015
				else{
					System.out.println("List size is null...document section was not configured..documents will be stored in db"); 						
				}

				// If condition added by Sethu for AAKH-CRF-0075	
				/*Added by Rameswar on  05-04-2016 
					Note: To handle multiple storage location for single patient,
							DOC1_UPLOAD_FLAG,DOC2_UPLOAD_FLAG,DOC3_UPLOAD_FLAG,DOC4_UPLOAD_FLAG
							has been used. This will denote which file is uploaded in which location,
							such as if 1 then shared path else Database */
				
				if (iDocFolderOption == 0)	
				{				
					conn = ConnectionManager.getConnection();
					conn.setAutoCommit(false);
					StringBuffer deleteSQL = new StringBuffer();
					deleteSQL.append("update mp_pat_documents set ");
					
					if ((fileItem1!=null) || (fileItem2!=null) || (fileItem3!=null) || (fileItem4!=null))
						deleteSQL.append("DOC_DB_FLAG = '0'") ;
						
					if (fileItem1!=null){			
						deleteSQL.append(", DOC1_IMAGE = empty_blob(),DOC1_UPLOAD_FLAG='0'");			
					}
					if (fileItem2!=null){					
						deleteSQL.append(", DOC2_IMAGE = empty_blob(),DOC2_UPLOAD_FLAG='0'");					
					}
					if (fileItem3!=null){					
						deleteSQL.append(", DOC3_IMAGE = empty_blob(),DOC3_UPLOAD_FLAG='0'") ;					
					}
					
					if (fileItem4!=null){					
						 deleteSQL.append(", DOC4_IMAGE = empty_blob(),DOC4_UPLOAD_FLAG='0'");					
					}			

					deleteSQL.append(" where PATIENT_ID=? ");
			
					pstmt=conn.prepareStatement(deleteSQL.toString());
					pstmt.setString(1,patient_id);
					int updt_blob_result = pstmt.executeUpdate();
					if (pstmt != null) pstmt.close();
					if(updt_blob_result > 0){
						java.sql.Blob img_blob1 = null;	
						java.sql.Blob img_blob2 = null;	
						java.sql.Blob img_blob3 = null;	
						java.sql.Blob img_blob4 = null;	
						java.io.OutputStream blobOutputStream1 = null;
						java.io.OutputStream blobOutputStream2 = null;
						java.io.OutputStream blobOutputStream3 = null;
						java.io.OutputStream blobOutputStream4 = null;
						String updateSQL = "select DOC1_IMAGE,DOC2_IMAGE,DOC3_IMAGE,DOC4_IMAGE,DOC1_UPLOAD_FLAG,DOC2_UPLOAD_FLAG,DOC3_UPLOAD_FLAG,DOC4_UPLOAD_FLAG from mp_pat_documents WHERE PATIENT_ID = ? for update";
						pstmt=conn.prepareStatement(updateSQL);
						pstmt.setString(1,patient_id);
						ResultSet rsupdt= pstmt.executeQuery();
						while(rsupdt!=null && rsupdt.next())
						{
							if(fileItem1 != null){	
								img_blob1			=	(java.sql.Blob)rsupdt.getBlob(1);
								blobOutputStream1	= img_blob1.setBinaryStream(0);
								int docs1			=	 (int)docSize1;
								blobOutputStream1.write(fileItem1.get(),0,docs1);
								blobOutputStream1.close();
							}
							
							if(fileItem2!=null){	
								img_blob2			=	(java.sql.Blob)rsupdt.getBlob(2);
								blobOutputStream2	= img_blob2.setBinaryStream(0);
								int docs2			=	 (int)docSize2;
								blobOutputStream2.write(fileItem2.get(),0,docs2);
								blobOutputStream2.close();
							}
							if(fileItem3!=null){	
								img_blob3			=	(java.sql.Blob)rsupdt.getBlob(3);
								blobOutputStream3	= img_blob3.setBinaryStream(0);
								int docs3			=	 (int)docSize3;
								blobOutputStream3.write(fileItem3.get(),0,docs3);
								blobOutputStream3.close();
							}
							if(fileItem4!=null){	
								img_blob4			=	(java.sql.Blob)rsupdt.getBlob(4);
								blobOutputStream4	= img_blob4.setBinaryStream(0);
								int docs4			=	 (int)docSize4;
								blobOutputStream4.write(fileItem4.get(),0,docs4);
								blobOutputStream4.close();
							}
						}

						if(rsupdt!=null) rsupdt.close();
						if(pstmt!=null)	pstmt.close();					 						
						conn.commit();
						
					
						if(!output.equals("") && funCall.equals("Visitreg") || funCall.equals("REF_SEARCH")){
							out.println("<script language='javascript'> parent.parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
						}
						else if(!output.equals("") && !funCall.equals("") || funCall.equals("DuplicateRegistration"))
						{
							 out.println("<script language='javascript'>parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
						}
						else if(output.equals(""))
						{
							if(funCall.equals("CHG_PAT_DTLS")){
								out.println("<script>top.returnValue=true;top.window.close();</script>");
							}
							else
							{
								out.println("<script>window.location.href='../eCommon/jsp/error.jsp?err_num= ';parent.f_query_add_mod.window.location.href = '../eMP/jsp/blank.jsp?step_1=5';</script></body></html>");
							}
						}
						else
						{
							if(bl_success_msg.equals("")){
								out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode(output, "UTF-8") + "&err_value=1';</script>");	
							}else if(!bl_success_msg.equals("")) {
								out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode("<B><U>"+bl_success_msg+"</U></B><BR>"+output, "UTF-8") + "&err_value=1';</script>");
							}
						}		
					}					
				}
				else if (iDocFolderOption == 1)
				{
					newFileFolder = sDocSharedPath;
						
					sFileSeparator = sFileSeparator + sFileSeparator;
					dFileStorage = new DocumentFileStorage();
					if (fileItem1!=null){
						aFileName1 = fileItem1.getName();
						sFileExt1 = FilenameUtils.getExtension(aFileName1);

						//sfileDir = dFileStorage.getFilePath(newFileFolder, "MP");
						sfileDir = dFileStorage.getFilePath(newFileFolder,sDocType);  // Edited by prithvi on 27/08/2015
						sFileName1 = dFileStorage.getFileName(patient_id, sDocType);
						sFileName1 = sFileName1 +"_1";
						bFileFlag = dFileStorage.saveFileToDir(fileItem1, sFileName1, sFileExt1, sfileDir);
						sFilePath1 = sfileDir + sFileSeparator + sFileName1 + "." +sFileExt1;
					}
					if (fileItem2!=null){
						aFileName2 = fileItem2.getName();
						sFileExt2 = FilenameUtils.getExtension(aFileName2);

						sfileDir = dFileStorage.getFilePath(newFileFolder, sDocType);
						sFileName2 = dFileStorage.getFileName(patient_id,sDocType);
						sFileName2 = sFileName2 +"_2";
						bFileFlag = dFileStorage.saveFileToDir(fileItem2, sFileName2, sFileExt2, sfileDir);
						sFilePath2 = sfileDir + sFileSeparator + sFileName2 + "." +sFileExt2;
					}
					if (fileItem3!=null){
						aFileName3 = fileItem3.getName();
						sFileExt3 = FilenameUtils.getExtension(aFileName3);

						sfileDir = dFileStorage.getFilePath(newFileFolder, sDocType);
						sFileName3 = dFileStorage.getFileName(patient_id, sDocType);
						sFileName3 = sFileName3 +"_3";
						bFileFlag = dFileStorage.saveFileToDir(fileItem3, sFileName3, sFileExt3, sfileDir);
						sFilePath3 = sfileDir + sFileSeparator + sFileName3 + "." +sFileExt3;
					}
					if (fileItem4!=null){
						aFileName4 = fileItem4.getName();
						sFileExt4 = FilenameUtils.getExtension(aFileName4);

						sfileDir = dFileStorage.getFilePath(newFileFolder,sDocType);
						sFileName4 = dFileStorage.getFileName(patient_id, sDocType);
						sFileName4 = sFileName4 +"_4";
						bFileFlag = dFileStorage.saveFileToDir(fileItem4, sFileName4, sFileExt4, sfileDir);
						sFilePath4 = sfileDir + sFileSeparator + sFileName4 + "." +sFileExt4;
					}

					/*Added by Rameswar on  05-04-2016 
					Note: To handle multiple storage location for single patient,
							DOC1_UPLOAD_FLAG,DOC2_UPLOAD_FLAG,DOC3_UPLOAD_FLAG,DOC4_UPLOAD_FLAG
							has been used. This will denote which file is uploaded in which location,
							such as if 1 then shared path else Database */
					System.out.println("Before connection!!!!");
					conn = ConnectionManager.getConnection();
					conn.setAutoCommit(false);
					StringBuffer updateSQL = new StringBuffer();				
					updateSQL.append("update mp_pat_documents set ");		
					if ((fileItem1!=null) || (fileItem2!=null) || (fileItem3!=null) || (fileItem4!=null))
						updateSQL.append("DOC_DB_FLAG = '1'") ;

					if (fileItem1!=null){								
						updateSQL.append(", DOC1_IMAGE_PATH = '"+sFilePath1+"'") ;
						updateSQL.append(", DOC1_IMAGE_TYPE = '"+sFileExt1+"'") ;		
						updateSQL.append(", DOC1_UPLOAD_FLAG='1'") ;		
					}
					if (fileItem2!=null){				
						updateSQL.append(", DOC2_IMAGE_PATH = '"+sFilePath2+"'") ;
						updateSQL.append(", DOC2_IMAGE_TYPE = '"+sFileExt2+"'") ;
						updateSQL.append(", DOC2_UPLOAD_FLAG='1'") ;						
					}
					if (fileItem3!=null){					
						updateSQL.append(", DOC3_IMAGE_PATH = '"+sFilePath3+"'") ;
						updateSQL.append(", DOC3_IMAGE_TYPE = '"+sFileExt3+"'") ;
						updateSQL.append(", DOC3_UPLOAD_FLAG='1'") ;					
					}				
					if (fileItem4!=null){					
						updateSQL.append(", DOC4_IMAGE_PATH = '"+sFilePath4+"'") ;
						updateSQL.append(", DOC4_IMAGE_TYPE = '"+sFileExt4+"'") ;
						updateSQL.append(", DOC4_UPLOAD_FLAG='1'") ;					
					}			

					updateSQL.append(" where PATIENT_ID=? ");

					//System.out.println(" * * * Update Statement: "+updateSQL.toString());
			
					pstmt=conn.prepareStatement(updateSQL.toString());

					pstmt.setString(1,patient_id);
					int updt_blob_result = pstmt.executeUpdate();
					if (pstmt != null) pstmt.close();
					
					if(pstmt!=null)	pstmt.close();					 						
					conn.commit();
					
				
					if(!output.equals("") && funCall.equals("Visitreg") || funCall.equals("REF_SEARCH"))
					{
						out.println("<script language='javascript'> parent.parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
					}
					else if(!output.equals("") && !funCall.equals("") || funCall.equals("DuplicateRegistration"))
					{
						 out.println("<script language='javascript'>parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
					}
					else if(output.equals(""))
					{
						if(funCall.equals("CHG_PAT_DTLS"))
						{
							out.println("<script>top.returnValue=true;top.window.close();</script>");
						}
						else
						{
							out.println("<script>window.location.href='../eCommon/jsp/error.jsp?err_num= ';parent.f_query_add_mod.window.location.href = '../eMP/jsp/blank.jsp?step_1=5';</script></body></html>");
						}
					}
					else
					{
						if(bl_success_msg.equals("")){
							out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode(output, "UTF-8") + "&err_value=1';</script>");	
						}
						else if(!bl_success_msg.equals("")) 
						{
							out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode("<B><U>"+bl_success_msg+"</U></B><BR>"+output, "UTF-8") + "&err_value=1';</script>");
						}
					 }				   
				}
			}				

		}		
		catch ( java.io.IOException ioe )	
		{
			System.out.println("IOException message::::"+ioe.getMessage());
			if(ioe.getMessage()!=null || ioe.getMessage()!="")
			{
				exceptionMessage=ioe.getMessage()+sDocSharedPath;
			}	
			try{

				if(conn!=null)
				conn.rollback();

			}catch(Exception e2){
				e2.printStackTrace();
			}
			ioe.printStackTrace();
			out.println("<script>alert('"+exceptionMessage+"')</script>");
			if(!output.equals("") && funCall.equals("Visitreg") || funCall.equals("REF_SEARCH"))
			{
				out.println("<script language='javascript'> parent.parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
			}
			else if(!output.equals("") && !funCall.equals("") || funCall.equals("DuplicateRegistration"))
			{
				 out.println("<script language='javascript'>parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
			}
			else if(output.equals(""))
			{
				if(funCall.equals("CHG_PAT_DTLS"))
				{
					out.println("<script>top.returnValue=true;top.window.close();</script>");
				}
				else
				{
					out.println("<script>window.location.href='../eCommon/jsp/error.jsp?err_num= ';parent.f_query_add_mod.window.location.href = '../eMP/jsp/blank.jsp?step_1=5';</script></body></html>");
				}
			}
			else
			{
				if(bl_success_msg.equals(""))
				{
					out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode(output, "UTF-8") + "&err_value=1';</script>");	
				}
				else if(!bl_success_msg.equals("")) 
				{
					out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode("<B><U>"+bl_success_msg+"</U></B><BR>"+output, "UTF-8") + "&err_value=1';</script>");
				}
			 }		
		}
		catch(Exception ex)
		{
			System.out.println("Exception message::::"+ex.getMessage());
			if(ex.getMessage()!=null || ex.getMessage()!="")
			{
				exceptionMessage=ex.getMessage();
			}	
			try{

				if(conn!=null)
				conn.rollback();

			}catch(Exception e2){
				e2.printStackTrace();
			}
			ex.printStackTrace();
			out.println("<script>alert('"+exceptionMessage+"')</script>");
			if(!output.equals("") && funCall.equals("Visitreg") || funCall.equals("REF_SEARCH"))
			{
				out.println("<script language='javascript'> parent.parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
			}
			else if(!output.equals("") && !funCall.equals("") || funCall.equals("DuplicateRegistration"))
			{
				out.println("<script language='javascript'>parent.parent.frames(2).location.href='../eCommon/jsp/error.jsp?&err_value=1';parent.parent.returnValue='" + output + "';parent.parent.close();</script>");
			}
			else if(output.equals(""))
			{
				if(funCall.equals("CHG_PAT_DTLS"))
				{
					out.println("<script>top.returnValue=true;top.window.close();</script>");
				}
				else
				{
					out.println("<script>window.location.href='../eCommon/jsp/error.jsp?err_num= ';parent.f_query_add_mod.window.location.href = '../eMP/jsp/blank.jsp?step_1=5';</script></body></html>");
				}
			}
			else
			{
				if(bl_success_msg.equals("")){
					out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode(output, "UTF-8") + "&err_value=1';</script>");	
				}else if(!bl_success_msg.equals("")) {
					out.println("<script>window.location.href='../eCommon/jsp/error.jsp?&err_num=" + java.net.URLDecoder.decode("<B><U>"+bl_success_msg+"</U></B><BR>"+output, "UTF-8") + "&err_value=1';</script>");
				}
			}		
		}
		finally
		{			
			try{
				if(conn !=null)ConnectionManager.returnConnection(conn,req);
			}catch(Exception e3){
				e3.printStackTrace();
			}
		}//ed of finally
	}//end of post

}