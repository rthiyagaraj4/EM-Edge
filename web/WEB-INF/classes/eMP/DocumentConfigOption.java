/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
10/06/2015        	100        D.Sethuraman       created

-----------------------------------------------------------------------------------------------
*/
package eMP;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import webbeans.eCommon.ConnectionManager;

import eXH.XHUtil;

public class DocumentConfigOption implements java.io.Serializable{
	
	private static final long serialVersionUID = 1L;
	boolean isDebugYN =false;

	/*
	 * Gets the list of Document Param Configured. 
	 */	
	public List<DocumentConfigBean> getDocumentConfigDetails(DocumentConfigBean sDocConfigBean) throws Exception {
		List<DocumentConfigBean> sDocConfigList = new ArrayList<DocumentConfigBean>() ;

		String sFacilityID = "";
		sFacilityID = sDocConfigBean.getsFacilityId();
		
		if(sFacilityID != null)
		{
			 Connection connection 		= null;
			 PreparedStatement pStmt		= null;
			 ResultSet resultSet 		= null;
			 StringBuffer smSqlQuery=new StringBuffer("");

		  /*  smSqlQuery.append(" select facility_id, doc_scan_enabled, doc_save_as, doc_folder_option,doc_check_status");
		    smSqlQuery.append(" from sm_patient_doc_param ");
		    smSqlQuery.append(" where facility_id = ? ");  */


			smSqlQuery.append(" select facility_id ,doc_folder_option");
		    smSqlQuery.append(" from sm_patient_doc_param ");
		    smSqlQuery.append(" where facility_id = ? ");
				
			try {
					isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
				    connection	= ConnectionManager.getConnection() ;
					if(connection != null)
					{
						pStmt = connection.prepareStatement(smSqlQuery.toString());
					}				
					pStmt.setString(1,sFacilityID);
					
                    if(isDebugYN) System.out.println("facility id value in configOption.java........"+sFacilityID);

					resultSet=pStmt.executeQuery();
					DocumentConfigBean sDocConfig = new DocumentConfigBean();
					if(resultSet != null && resultSet.next())
					{
						 if(isDebugYN) System.out.println("Result set is not null in getDocumentConfigDetails()....");
						sDocConfig.setsFacilityId(((resultSet.getString("facility_id") != null) ? resultSet.getString("facility_id") : "")) ;
						//sDocConfig.setiDocScanEnabled(resultSet.getInt("doc_scan_enabled")) ;
						//sDocConfig.setiDocSaveAs(resultSet.getInt("doc_save_as")) ;
						sDocConfig.setiDocFolderOption(resultSet.getInt("doc_folder_option")) ;
						sDocConfig.setiInvFolderOption(resultSet.getInt("inv_doc_option")) ;//Added by Kamatchi S for MO-CRF-20171.1   
						//sDocConfig.setiDocCheckStatus(resultSet.getInt("doc_check_status")) ;
						}
					else{ // condition for first time entering in this facility

						 if(isDebugYN) System.out.println("Result set is null....");

						sDocConfig.setsFacilityId(sFacilityID) ;  // All are default values. zero is the default value.
						//sDocConfig.setiDocScanEnabled(0) ;
						//sDocConfig.setiDocSaveAs(0) ;
						sDocConfig.setiDocFolderOption(0) ;
						sDocConfig.setiInvFolderOption(0) ;//Added by Kamatchi S for MO-CRF-20171.1
						//sDocConfig.setiDocCheckStatus(0) ;
					}
					sDocConfig.setiDocTypeList(getDocumentTypeDetails(sFacilityID));
					sDocConfigList.add(sDocConfig);
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( pStmt != null ) pStmt.close() ;
					 ConnectionManager.returnConnection(connection);
			}
		}
		return sDocConfigList;
	}

	public List<DocumentConfigBean> getDocumentConfigDetails(String facilityID) throws Exception {
		List<DocumentConfigBean> sDocConfigList = new ArrayList<DocumentConfigBean>() ;
		
		String sFacilityID = "";

	

		sFacilityID = facilityID;
		if(sFacilityID != null)
		{
			Connection connection 		= null;
			PreparedStatement pStmt		= null;
			ResultSet resultSet 		= null;
			String smSqlQuery=null;
			smSqlQuery="select * from sm_patient_doc_param where facility_id= ? ";
			
			
			try {
					isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

				    connection	= ConnectionManager.getConnection() ;
					if(connection != null)
					{
						pStmt = connection.prepareStatement(smSqlQuery);
					}				
					pStmt.setString(1,sFacilityID);
					
                     if(isDebugYN) System.out.println("facility id value in configOption.java........"+sFacilityID);

					resultSet=pStmt.executeQuery();
					DocumentConfigBean sDocConfig = new DocumentConfigBean();
					if(resultSet != null && resultSet.next())
					{
						sDocConfig.setsFacilityId(((resultSet.getString("facility_id") != null) ? resultSet.getString("facility_id") : "")) ;
						sDocConfig.setiDocScanEnabled(resultSet.getInt("doc_scan_enabled")) ;
						 if(isDebugYN) System.out.println("doc sca ui11...."+resultSet.getInt("doc_scan_enabled"));
						 if(isDebugYN) System.out.println("scan ui...."+resultSet.getInt("SCAN_UI_ENABLED"));
						sDocConfig.setiDocScanUIEnabled(resultSet.getInt("SCAN_UI_ENABLED")) ;
						sDocConfig.setiDocSaveAs(resultSet.getInt("doc_save_as")) ;
						sDocConfig.setiDocFolderOption(resultSet.getInt("doc_folder_option")) ;
						sDocConfig.setsPhotoDocOption(resultSet.getInt("PHOTO_FOLDER_OPTION"));
						sDocConfig.setiInvFolderOption(resultSet.getInt("INV_DOC_OPTION"));//Added by Kamatchi S for MO-CRF-20171.1
						
						}
					else{ // condition for first time entering in this facility

						sDocConfig.setsFacilityId(sFacilityID) ;  // All are default values. 8/27/2015 zero is the default value.
						sDocConfig.setiDocScanEnabled(0) ;
						sDocConfig.setiDocScanUIEnabled(0) ;
						sDocConfig.setiDocSaveAs(1) ;    // defalut is image (docSaveAs=1) as customer asked.
						sDocConfig.setiDocFolderOption(0) ;
						sDocConfig.setiInvFolderOption(0) ;//Added by Kamatchi S for MO-CRF-20171.1

					}
					sDocConfig.setiDocTypeList(getDocumentTypeDetails(sFacilityID));
					sDocConfigList.add(sDocConfig);
					 
					
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( pStmt != null ) pStmt.close() ;
					 ConnectionManager.returnConnection(connection);
			}
		}
		return sDocConfigList;
	}
	

	public List<FacilityDetailsBean> getFacilityDetails(FacilityDetailsBean sFacDetailsBean) throws Exception {
		List<FacilityDetailsBean> sFacDetailsList = new ArrayList<FacilityDetailsBean>() ;

		String sFacilityID = "";
		sFacilityID = sFacDetailsBean.getsFacilityId();

		Connection connection 		= null;
		PreparedStatement pStmt		= null;
		ResultSet resultSet 		= null;

		StringBuffer sqlStr = new StringBuffer("");
			
		//HttpServletRequest request = sFacDetailsBean.request;
		
		sqlStr.append(" select facility_id, facility_name, status ");
		sqlStr.append(" from sm_facility_param ");
		sqlStr.append(" where status = 'E' ");

		 if(isDebugYN) System.out.println(" * * * sFacilityID * * * "+sFacilityID+" * "+sFacilityID.length());
		
		if((sFacilityID != null) && (sFacilityID.length()>0))
		{			
			sqlStr.append(" and facility_id =  ? ");
		}
				
		try {
				isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
				connection	= ConnectionManager.getConnection() ;
				if(connection != null)
				{
					pStmt = connection.prepareStatement(sqlStr.toString());
				}				

				if((sFacilityID != null) && (sFacilityID.length()>0))
				{
					pStmt.setString(1,sFacilityID);	
				}
				resultSet=pStmt.executeQuery();

				while ( resultSet != null && resultSet.next() ) {

					FacilityDetailsBean sFacDetails = new FacilityDetailsBean();

					sFacDetails.setsFacilityId(((resultSet.getString("facility_id") != null) ? resultSet.getString("facility_id") : "")) ;
					sFacDetails.setsFacilityName(((resultSet.getString("facility_name") != null) ? resultSet.getString("facility_name") : "")) ;
					sFacDetails.setsFacilityStatus(((resultSet.getString("status") != null) ? resultSet.getString("status") : "")) ;
					sFacDetailsList.add(sFacDetails);

			}
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				 if ( resultSet != null ) resultSet.close() ;	
				 if ( pStmt != null ) pStmt.close() ;
				 ConnectionManager.returnConnection(connection);

		}
		return sFacDetailsList;
	}	

	public List<FacilityDetailsBean> getFacilityDetails(String facilityID) throws Exception {
		List<FacilityDetailsBean> sFacDetailsList = new ArrayList<FacilityDetailsBean>() ;

		String sFacilityID = "";
		sFacilityID = facilityID;
		Connection connection 		= null;
		PreparedStatement pStmt		= null;
		ResultSet resultSet 		= null;

		StringBuffer sqlStr = new StringBuffer("");
			
		//HttpServletRequest request = sFacDetailsBean.request;
		sqlStr.append(" select facility_id, facility_name, status ");
		sqlStr.append(" from sm_facility_param ");
		sqlStr.append(" where status = 'E' ");

		 if(isDebugYN) System.out.println(" * * * sFacilityID * * * "+sFacilityID+" * "+sFacilityID.length());
		if((sFacilityID != null) && (sFacilityID.length()>0))
		{			
			sqlStr.append(" and facility_id =  ? ");
		}	
		try {
				isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
				connection	= ConnectionManager.getConnection() ;
				if(connection != null)
				{
					pStmt = connection.prepareStatement(sqlStr.toString());
				}				
				
				if((sFacilityID != null) && (sFacilityID.length()>0))
				{
					pStmt.setString(1,sFacilityID);	
				}
				resultSet=pStmt.executeQuery();

				while ( resultSet != null && resultSet.next() ) {

					FacilityDetailsBean sFacDetails = new FacilityDetailsBean();

					sFacDetails.setsFacilityId(((resultSet.getString("facility_id") != null) ? resultSet.getString("facility_id") : "")) ;
					sFacDetails.setsFacilityName(((resultSet.getString("facility_name") != null) ? resultSet.getString("facility_name") : "")) ;
					sFacDetails.setsFacilityStatus(((resultSet.getString("status") != null) ? resultSet.getString("status") : "")) ;
					sFacDetailsList.add(sFacDetails);

			}
			
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				 if ( resultSet != null ) resultSet.close() ;	
				 if ( pStmt != null ) pStmt.close() ;
				 ConnectionManager.returnConnection(connection);

		}	
		return sFacDetailsList;	
}


/*
	 * Added by prithvi on 26/08/2015
	 * 
	 * This method is used to get the document_type,document_name details from the table sm_patient_doc_dtl
	 */
	public List<DocumentTypeBean> getDocumentTypeDetails(String facilityID) throws Exception {
		List<DocumentTypeBean> sDocTypeDetails = new ArrayList<DocumentTypeBean>() ;
		
		Connection connection 		= null;
		PreparedStatement pStmt		= null;
		ResultSet resultSet 		= null;
		
		//String sqlQuery="select * from SM_FILE_DOCUMENT_TYPE f,SM_PATIENT_DOC_DTL d where d.DOC_TYPE(+)=f.DOCUMENT_TYPE AND d.FACILITY_ID(+)='' ";
		
		StringBuffer sqlStr = new StringBuffer("");
		sqlStr.append(" select * from SM_FILE_DOCUMENT_TYPE f,SM_PATIENT_DOC_DTL d ");
		sqlStr.append(" where d.DOC_TYPE(+)=f.DOCUMENT_TYPE AND d.FACILITY_ID(+)= ? ");
		
	
		if(facilityID==null)
		{
			facilityID="";
		}
		try {
			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
			connection	= ConnectionManager.getConnection() ;
			if(connection != null)
			{
				pStmt = connection.prepareStatement(sqlStr.toString());
			}				
			
			 if(isDebugYN) System.out.println(" * * * sql query for document type details * * *  "+sqlStr.toString());

			pStmt.setString(1,facilityID);	
			
			resultSet=pStmt.executeQuery();
			
			DocumentTypeBean docTypeBean=null;
			while ( resultSet != null && resultSet.next() ) {

				docTypeBean = new DocumentTypeBean();
				
				docTypeBean.setsDocumentType(((resultSet.getString("DOCUMENT_TYPE") != null) ? resultSet.getString("DOCUMENT_TYPE") : ""));
				docTypeBean.setsDocumentName(((resultSet.getString("DOCUMENT_NAME") != null) ? resultSet.getString("DOCUMENT_NAME") : ""));
				docTypeBean.setsDocFolderOption(resultSet.getInt("DOC_FOLDER_OPTION"));
				docTypeBean.setsInvFolderOption(resultSet.getInt("DOC_FOLDER_OPTION"));//Added by Kamatchi S for MO-CRF-20171.1
				docTypeBean.setsDocumentSharedPath(((resultSet.getString("DOC_SHARED_PATH") != null) ? resultSet.getString("DOC_SHARED_PATH") : ""));
				docTypeBean.setsInventorySharedPath(((resultSet.getString("DOC_SHARED_PATH") != null) ? resultSet.getString("DOC_SHARED_PATH") : ""));//Added by Kamatchi S for MO-CRF-20171.1
				docTypeBean.setsDocWebserviceURL(((resultSet.getString("DOC_WEBSERVICE_URL") != null) ? resultSet.getString("DOC_WEBSERVICE_URL") : ""));
				docTypeBean.setsFileCategory(((resultSet.getString("FILE_CATEGORY") != null) ? resultSet.getString("FILE_CATEGORY") : ""));
				
				
				 if(isDebugYN) System.out.println("DocType list size in getDocumentTypeDetails()....."+docTypeBean);
				
				sDocTypeDetails.add(docTypeBean);
				 if(isDebugYN) System.out.println("sDocTypeDetails.."+sDocTypeDetails);

		}
			//System.out.println("DocType list size in getDocumentTypeDetails()....."+sDocTypeDetails.size());
		} catch ( Exception e )	{
			e.printStackTrace() ;
			throw e ;
		} finally {
				 if ( resultSet != null ) resultSet.close() ;	
				 if ( pStmt != null ) pStmt.close() ;
				 ConnectionManager.returnConnection(connection);
		}	
		return sDocTypeDetails;
	}



	/*
	 * This method is used to get the patient document details and document type details for document upload.(DocUploadServlet.java)
	 * 
	 */
	public List<DocumentConfigBean> getDocumentConfigDetails(String facilityID,String docType) throws Exception {
		List<DocumentConfigBean> sDocConfigList = new ArrayList<DocumentConfigBean>() ;

		String sFacilityID = "";
		sFacilityID = facilityID;
		
		if(sFacilityID != null && docType!=null)
		{
			Connection connection 		= null;
			PreparedStatement pStmt		= null;
			ResultSet resultSet 		= null;
		
        	StringBuffer smSqlQuery = new StringBuffer("");
		    smSqlQuery.append(" select p.facility_id, p.doc_scan_enabled, p.scan_ui_enabled, p.doc_save_as, p.doc_folder_option, d.doc_type, d.doc_shared_path, d.doc_webservice_url ");
		    smSqlQuery.append(" from SM_PATIENT_DOC_PARAM p, SM_PATIENT_DOC_DTL d ");
			smSqlQuery.append(" where p.FACILITY_ID=? AND d.DOC_TYPE=? AND p.FACILITY_ID=d.FACILITY_ID ");
				
			try {
					isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;
				    connection	= ConnectionManager.getConnection() ;
					if(connection != null)
					{
						pStmt = connection.prepareStatement(smSqlQuery.toString());
					}	
					pStmt.setString(1,sFacilityID);
					pStmt.setString(2,docType);
					
                    if(isDebugYN) System.out.println(" Document Config Details facility id...."+sFacilityID+"....doctype....."+docType);

					resultSet=pStmt.executeQuery();
					DocumentConfigBean sDocConfig =null;
					if(resultSet != null && resultSet.next())
					{

						sDocConfig = new DocumentConfigBean();
						sDocConfig.setsFacilityId(((resultSet.getString("facility_id") != null) ? resultSet.getString("facility_id") : "")) ;
						sDocConfig.setiDocScanEnabled(resultSet.getInt("doc_scan_enabled")) ; // Scan function enabled/disabled.
						sDocConfig.setiDocScanUIEnabled(resultSet.getInt("scan_ui_enabled")) ; // Scanner UI enabled/disabled.
						sDocConfig.setiDocSaveAs(resultSet.getInt("doc_save_as")) ; //Document save as image/pdf.
						 if(isDebugYN) System.out.println("Document Config Details doc save as...."+resultSet.getInt("doc_save_as"));
						sDocConfig.setiDocFolderOption(resultSet.getInt("doc_folder_option")) ; // document to be saved in DB/Shared Path.
						sDocConfig.setsDocType(((resultSet.getString("doc_type") != null) ? resultSet.getString("doc_type") : "")); // document to be saved in DB/Shared Path.
						sDocConfig.setsDocSharedPath(((resultSet.getString("doc_shared_path") != null) ? resultSet.getString("doc_shared_path") : ""));  // Document shared Path		
						sDocConfig.setsInvSharedpath(((resultSet.getString("doc_shared_path") != null) ? resultSet.getString("doc_shared_path") : ""));//Doc shared Path for Iventory Added by Kamatchi S for MO-CRF-20171.1
						sDocConfig.setsDocWebserviceUrl(((resultSet.getString("doc_webservice_url") != null) ? resultSet.getString("doc_webservice_url") : ""));
						sDocConfig.setsPhotoSharedpath(((resultSet.getString("doc_webservice_url") != null) ? resultSet.getString("doc_webservice_url") : ""));
						sDocConfigList.add(sDocConfig);
						}
					
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( pStmt != null ) pStmt.close() ;
					 ConnectionManager.returnConnection(connection);
			}
		}
		return sDocConfigList;
	}

	/*
	 * This method is used to get the patient photo stored in the shared folder.(PatientPhotoServlet.java)
	 * 
	 */
	public List<DocumentConfigBean> getDocumentConfigDetails(String facilityID, String docType ,String filecategory) throws Exception {
		List<DocumentConfigBean> sDocConfigList = new ArrayList<DocumentConfigBean>() ;

		String sFacilityID = "";
		sFacilityID = facilityID;

		if(sFacilityID != null && docType!=null)
		{
			Connection connection 		= null;
			PreparedStatement pStmt		= null;
			ResultSet resultSet 		= null;
		
        	StringBuffer smSqlQuery = new StringBuffer("");
		    smSqlQuery.append(" select p.facility_id, p.doc_scan_enabled, p.scan_ui_enabled, p.doc_save_as, p.doc_folder_option, d.doc_type, d.doc_shared_path, d.doc_webservice_url, d.file_category, p.PHOTO_FOLDER_OPTION ");
		    smSqlQuery.append(" from SM_PATIENT_DOC_PARAM p, SM_PATIENT_DOC_DTL d ");
			smSqlQuery.append(" where p.FACILITY_ID=? AND d.DOC_TYPE=? AND p.FACILITY_ID=d.FACILITY_ID  ");
			smSqlQuery.append(" and  d.file_category  = ? ");
				
			try {
					isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

				    connection	= ConnectionManager.getConnection() ;
					if(connection != null)
					{
						pStmt = connection.prepareStatement(smSqlQuery.toString());
					}	
					pStmt.setString(1,sFacilityID);
					pStmt.setString(2,docType);
					pStmt.setString(3,filecategory);
					resultSet=pStmt.executeQuery();
					DocumentConfigBean sDocConfig =null;
					
					if(isDebugYN) System.out.println("Get Document Config Details...facility id...."+sFacilityID+" Doc Type ...."+docType+" filecategory....."+filecategory);
					
					if(resultSet != null && resultSet.next())
					{
						if(isDebugYN) System.out.println("prithivi...facility id...."+sFacilityID+" Doc Type ...."+docType+" filecategory....."+filecategory);
						if(isDebugYN) System.out.println("Resultset is not empty");
						sDocConfig = new DocumentConfigBean();
						sDocConfig.setsFacilityId(((resultSet.getString("facility_id") != null) ? resultSet.getString("facility_id") : "")) ;
						sDocConfig.setiDocScanEnabled(resultSet.getInt("doc_scan_enabled")) ; // Scan function enabled/disabled.
						sDocConfig.setiDocScanUIEnabled(resultSet.getInt("scan_ui_enabled")) ; // Scanner UI enabled/disabled.
						sDocConfig.setiDocSaveAs(resultSet.getInt("doc_save_as")) ; //Document save as image/pdf.
						 if(isDebugYN) System.out.println("prithivi...doc save as...."+resultSet.getInt("doc_save_as"));
						sDocConfig.setiDocFolderOption(resultSet.getInt("doc_folder_option")) ; // document to be saved in DB/Shared Path.
						sDocConfig.setsDocType(((resultSet.getString("doc_type") != null) ? resultSet.getString("doc_type") : "")); // document to be saved in DB/Shared Path.
						sDocConfig.setsDocSharedPath(((resultSet.getString("doc_shared_path") != null) ? resultSet.getString("doc_shared_path") : ""));  // Document shared Path.						
						sDocConfig.setsInvSharedpath(((resultSet.getString("doc_shared_path") != null) ? resultSet.getString("doc_shared_path") : ""));//Doc Inventory shared Path. Added by Kamatchi S for MO-CRF-20171.1						
						sDocConfig.setsDocWebserviceUrl(((resultSet.getString("doc_webservice_url") != null) ? resultSet.getString("doc_webservice_url") : ""));
						sDocConfig.setsPhotoDocOption(resultSet.getInt("PHOTO_FOLDER_OPTION")); //Added by bhuvana on 27/05/2019
						sDocConfig.setsFileCategory(resultSet.getString("FILE_CATEGORY")); //Added by bhuvana on 27/05/2019
						
						sDocConfigList.add(sDocConfig);
					}
					
			} catch ( Exception e )	{
				e.printStackTrace() ;
				throw e ;
			} finally {
					 if ( resultSet != null ) resultSet.close() ;	
					 if ( pStmt != null ) pStmt.close() ;
					 ConnectionManager.returnConnection(connection);
			}
		}
		return sDocConfigList;
	}
	
}