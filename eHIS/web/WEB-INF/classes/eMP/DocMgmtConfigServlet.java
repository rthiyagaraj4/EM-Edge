/*
-----------------------------------------------------------------------------------------------
Date       		Edit History   Name        		Description
-----------------------------------------------------------------------------------------------
15/06/2015        	100        D.Sethuraman       created 

-----------------------------------------------------------------------------------------------
 */
package eMP;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import eXH.XHUtil;
import java.util.ArrayList;

public class DocMgmtConfigServlet extends javax.servlet.http.HttpServlet {
	//private static final long serialVersionUID = 1L; //Commented for checkstyle
	//private static String l_debug_YN = ""; //Commented for checkstyle 
	String mode = "";
	String facilityId = "";
	String client_ip_address = "";
	String addedById = "";
	String modifiedById = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";
	
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
	}

	private String getMessage(String locale, String messageId, String moduleId) {
		java.util.Hashtable message = MessageManager.getMessage(locale,
				messageId, moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return (mesg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws javax.servlet.ServletException, IOException {
		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html;charset=UTF-8");

			mode = request.getParameter("mode");

			if (mode.trim().equalsIgnoreCase("insert"))
				insert(request, response );
			/*if (mode.trim().equalsIgnoreCase("update"))
				modify(request, response);*/
		} catch (Exception e) {
			System.out.println(e.toString());
			e.printStackTrace();
		}

	}

	/**************************/

	public void insert(HttpServletRequest request, HttpServletResponse response ) {
		java.util.Properties p;

		String errorMessage = "";

		HttpSession session = request.getSession(false);

		p = (java.util.Properties) session.getValue("jdbc");
		String locale = (String) p.getProperty("LOCALE");
		facilityId = (String) session.getValue("facility_id");
		client_ip_address = (String) p.getProperty("client_ip_address");

		Connection con = null;
		PreparedStatement pstmt_insert = null, pstmt_update = null, pstmt_select = null, pstmt_select_dtl = null;
		ResultSet resultSet = null, resultSetDtl = null;

		String insert_sql = "", update_sql = "", update_sql_dtl = "",  insert_sql_dtl = "";
		PreparedStatement pstmt_insert_dtl = null, pstmt_update_dtl = null;

		String sFacilityId = "";
		int iDocScanEnabled = 0; 
		int iDocScanUIEnabled = 0; // Added by prithvi on 24/02/2016
		int iDocSaveAs = 0;
		//int iDocCheckStatus = 0; //Commented for Checkstyle
		int iDocFolderOption = 0;
		//Added by Kamatchi S for MO-CRF-20171.1
		int iInvFolderOption = 0;
		String iInventoryOption = null;
		String[] sInvSharedPathArray = null;
		String[] sInvTypes = null; 

		//Added by bhuvana  for MO-CRF-20153 on 23/05/2019.
		
		String iDocumentOption = null;
		String iScanningOption = null; 
		String iPhotoOption = null; 
		int iPhotoDocOption =0; 
		int iPhotoSharedPath =0; 
		String[] sPhotoSharedPathArray = null;
		String[] sPhotoTypes = null;
		//String l_debug_yn = "" , query =""; //Commented for Checkstyle
		boolean isDebugYN =false;

		//Ended by bhuvana for MO-CRF-20153 on 23/05/2019.

		String[] sDocSharedPathArray = null;
		String[] sDocTypes = null; 
		//String sWebServiceUrl = ""; //Commented for Checkstyle
	
		int recordCount = 0;

		String status_msg = "";

		boolean updateFlag = true;
		String getFacility = "";
		

		StringBuffer select_sql = null, select_sql_dtl = null;		

		try {

			//Added by bhuvana for MO-CRF-20153 on 23/05/2019.

			isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

			addedById = p.getProperty("login_user");

			sFacilityId = request.getParameter("facilityId");
			String ddFacilityId = request.getParameter("facilityId_df");

			System.out.println("sFacilityId... "+sFacilityId +" ddFacilityId... "+ddFacilityId);

			if ((request.getParameter("ScanningEnabled")==null || request.getParameter("ScanningEnabled").length() == 0))
			{
				iDocScanEnabled = 0;
			}
			else
			{
				iDocScanEnabled = Integer.parseInt(request.getParameter("ScanningEnabled"));
			}

			if ((request.getParameter("ScanningUIEnabled")==null || request.getParameter("ScanningUIEnabled").length() == 0))
			{
				iDocScanUIEnabled = 0;
			}
			else
			{
				iDocScanUIEnabled = Integer.parseInt(request.getParameter("ScanningUIEnabled"));
			}

			if ((request.getParameter("DocSaveAs")==null || request.getParameter("DocSaveAs").length() == 0))
			{
				iDocSaveAs = 0;
			}
			else
			{
				iDocSaveAs = Integer.parseInt(request.getParameter("DocSaveAs"));
			}

			if ((request.getParameter("DocFolderOption")==null || request.getParameter("DocFolderOption").length() == 0))
			{
				iDocFolderOption = 0;
			}
			else
			{
				iDocFolderOption = Integer.parseInt(request.getParameter("DocFolderOption"));
			}
			
			if(isDebugYN) System.out.println("iDocFolderOption........"+iDocFolderOption);

			//Added by Kamatchi S for MO-CRF-20171.1
			if ((request.getParameter("InvFolderOption")==null || request.getParameter("InvFolderOption").length() == 0))
			{
				iInvFolderOption = 0;System.err.println("hi in servlet 184"+iInvFolderOption);
			}
			else
			{
				iInvFolderOption = Integer.parseInt(request.getParameter("InvFolderOption"));
			}
			if(isDebugYN) System.out.println("iInvFolderOption........"+iInvFolderOption);
			//END MO-CRF-20171.1

			//Added by bhuvana for MO-CRF-20153 on 23/05/2019.
			if ((request.getParameter("isDocumentOption")==null || request.getParameter("isDocumentOption").length() == 0))
			{
				iDocumentOption = "false";
			}
			else
			{
				iDocumentOption = request.getParameter("isDocumentOption");
			}
			
			//Added by kamatchi s for MO-CRF-20171.1
			if ((request.getParameter("isInventoryOption")==null || request.getParameter("isInventoryOption").length() == 0))
			{
				iInventoryOption = "false";
			}
			else
			{
				iInventoryOption = request.getParameter("isInventoryOption");
			}
			//END of MO-CRF-20171.1
			if ((request.getParameter("isScanningOption")==null || request.getParameter("isScanningOption").length() == 0))
			{
				iScanningOption = "false";
			}
			else
			{
				iScanningOption = request.getParameter("isScanningOption");
			}

			if ((request.getParameter("isPhotoOption")==null || request.getParameter("isPhotoOption").length() == 0))
			{
				iPhotoOption = "false";
			}
			else
			{
				iPhotoOption = request.getParameter("isPhotoOption");
			}


			if ((request.getParameter("PhotoDocOption")==null || request.getParameter("PhotoDocOption").length() == 0))
			{
				iPhotoDocOption = 0;
				
				if(isDebugYN) System.out.println("iPhotoDocOption null value is"+iPhotoDocOption);

			}
			else
			{
				iPhotoDocOption = Integer.parseInt(request.getParameter("PhotoDocOption"));
				
				if(isDebugYN) System.out.println("iPhotoDocOption"+iPhotoDocOption);
			}

			if ((request.getParameter("PhotoSharedpath")==null || request.getParameter("PhotoSharedpath").length() == 0))
			{
				iPhotoSharedPath = 0;
			}
			else
			{
				iPhotoSharedPath = Integer.parseInt(request.getParameter("PhotoSharedpath"));
				
				if(isDebugYN) System.out.println("iPhotoSharedPath"+iPhotoSharedPath);
			}
			//Ended  for MO-CRF-20153  on 23/05/2019.
			
			ArrayList<String> facilityNameListInsert  = new ArrayList<String>();
			
			facilityNameListInsert = getFacilityName ( request,  response , sFacilityId, con);	//Added for checkstyle

			if(isDebugYN) System.out.println("facilityNameListInsert......."+facilityNameListInsert.size());

			con = ConnectionManager.getConnection(request);		

			//------------------------------------------------------------

			select_sql = new StringBuffer("");

			select_sql.append(" select facility_id, doc_scan_enabled, doc_save_as, doc_folder_option, doc_check_status,PHOTO_FOLDER_OPTION,INV_DOC_OPTION");
			select_sql.append(" from sm_patient_doc_param ");
			select_sql.append(" where facility_id = ? ");

			pstmt_select = con.prepareStatement(select_sql.toString());

			//------------------------------------------------------------

			update_sql = " update sm_patient_doc_param "
							+ " set doc_scan_enabled = ?, doc_save_as = ?, doc_folder_option = ?, SCAN_UI_ENABLED = ?,"
							+ " modified_by_id = ?, "
							+ " modified_date = sysdate, "
							+ " modified_at_ws_no = ?, "
							+ " modified_facility_id = ?, "
							+ " PHOTO_FOLDER_OPTION = ?, "
							+ " INV_DOC_OPTION = ? "
							+ " where facility_id = ? ";

			pstmt_update = con.prepareStatement(update_sql);
			
			//------------------------------------------------------------

			insert_sql = "insert into sm_patient_doc_param (facility_id, doc_scan_enabled, doc_save_as, doc_folder_option, SCAN_UI_ENABLED,"
								+ " added_by_id, added_date, added_at_ws_no, added_facility_id, modified_by_id, modified_date, modified_at_ws_no, modified_facility_id,PHOTO_FOLDER_OPTION,INV_DOC_OPTION) "
								+ " values (?, ?, ?, ?, ?, ?, sysdate, ?, ?, ?, sysdate, ?, ?, ?,?) ";

			pstmt_insert = con.prepareStatement(insert_sql);

			//------------------------------------------------------------

			select_sql_dtl = new StringBuffer("");

			select_sql_dtl.append(" select FACILITY_ID, DOC_TYPE,DOC_SHARED_PATH");
			select_sql_dtl.append(" from SM_PATIENT_DOC_DTL ");
			select_sql_dtl.append(" where DOC_TYPE = ? AND FACILITY_ID = ?  and FILE_CATEGORY = ? ");
			
			pstmt_select_dtl = con.prepareStatement(select_sql_dtl.toString());

			update_sql_dtl = " update SM_PATIENT_DOC_DTL "
								+ " set DOC_FOLDER_OPTION = ?, DOC_SHARED_PATH = ? "
								+ " where DOC_TYPE = ? AND FACILITY_ID = ? and FILE_CATEGORY = ? ";

			pstmt_update_dtl = con.prepareStatement(update_sql_dtl);

			insert_sql_dtl = "insert into SM_PATIENT_DOC_DTL (FACILITY_ID, DOC_TYPE, DOC_FOLDER_OPTION, DOC_SHARED_PATH, DOC_WEBSERVICE_URL,FILE_CATEGORY) "
						+ " values (?, ?, ?, ?, ?, ?) ";

			pstmt_insert_dtl = con.prepareStatement(insert_sql_dtl);			

			for (int k = 0; k < facilityNameListInsert.size(); k++)
			{					
				getFacility = facilityNameListInsert.get(k);
				sFacilityId = getFacility;
				
				if (getFacility.length() > 0 ) 
				{
					if(isDebugYN) System.out.println("Entering into getFacility length "+getFacility);					
					if(isDebugYN) System.out.println("------------------------------------pstmt_select------------------------------------");
					
					pstmt_select.setString(1, sFacilityId);
					resultSet = pstmt_select.executeQuery();
					
					if (resultSet != null && resultSet.next()) 
					{
						if(isDebugYN) System.out.println(" Inside sm_patient_doc_param update ************* ");						
						
						pstmt_update.setInt(1, iDocScanEnabled);
						pstmt_update.setInt(2, iDocSaveAs);
						pstmt_update.setInt(3, iDocFolderOption);
						pstmt_update.setInt(4, iDocScanUIEnabled);
						pstmt_update.setString(5, addedById);
						pstmt_update.setString(6, client_ip_address);
						pstmt_update.setString(7, getFacility);
						pstmt_update.setInt(8, iPhotoDocOption);
						pstmt_update.setString(10, sFacilityId);//Changed by kamatchi S for MO-CRF-20171.1
						pstmt_update.setInt(9, iInvFolderOption);//Added by kamatchi S for MO-CRF-20171.1
						recordCount = pstmt_update.executeUpdate();

						if (recordCount == 0)
						{
							updateFlag = false;
						}
					} 
					else 
					{
						if(isDebugYN) System.out.println(" Inside sm_patient_doc_param insert +++++++++++ ");
						
						pstmt_insert.setString(1, sFacilityId);
						pstmt_insert.setInt(2, iDocScanEnabled);
						pstmt_insert.setInt(3, iDocSaveAs);
						pstmt_insert.setInt(4, iDocFolderOption);
						pstmt_insert.setInt(5, iDocScanUIEnabled);
						pstmt_insert.setString(6, addedById);
						pstmt_insert.setString(7, client_ip_address);
						pstmt_insert.setString(8, sFacilityId);
						pstmt_insert.setString(9, addedById);
						pstmt_insert.setString(10, client_ip_address);
						pstmt_insert.setString(11, sFacilityId);
						pstmt_insert.setInt(12, iPhotoDocOption);
						pstmt_insert.setInt(13, iInvFolderOption);//Added by kamatchi S for MO-CRF-20171.1
						recordCount = pstmt_insert.executeUpdate();
						if (recordCount == 0)
						{
							updateFlag = false;
						}
					}

                    if(resultSet!= null); resultSet.close(); //Added for checkstyle
					if(isDebugYN) System.out.println(" getFacility "+getFacility+ " ............updateFlag...  "+updateFlag);

					if (updateFlag)// if no of rows inserted are equals to the
										// number of Entries then Values are
										// Committed to the Database
					{
						//con.commit();

						// To check whether document option is available for this site.

						if (iDocumentOption.equals("true"))   //Code Added by Bhuvaneshwari for SM-MO-CRF-20154.2 on 19/0612019
						{
							if(isDebugYN) System.out.println("Before Get Shared Path... ");
							if(isDebugYN) System.out.println("sDocSharedPathArray... "+request.getParameter("doc_shared_path"));

							sDocSharedPathArray = request.getParameterValues("doc_shared_path");

							if(isDebugYN) System.out.println("sDocSharedPathArray... "+sDocSharedPathArray.length);	


							if (iDocFolderOption == 1) //Shared Path
							{
							
								if(isDebugYN)  System.out.println("Entering into iDocFolderOption "+iDocFolderOption);
								//status_msg = "";
								sDocTypes = request.getParameterValues("doc_types");
								
								if(isDebugYN)  System.out.println("sDocTypes.."+sDocTypes);

								if (sDocTypes != null) 
								{
									if(isDebugYN)  System.out.println("sDocTypes not null.."+sDocTypes);
									for (int i = 0; i < sDocTypes.length; i++) 
									{
										pstmt_select_dtl.setString(1, sDocTypes[i]);
										pstmt_select_dtl.setString(2, sFacilityId);
										pstmt_select_dtl.setString(3,  "D");									

										resultSetDtl = pstmt_select_dtl.executeQuery();

										if (resultSetDtl != null && resultSetDtl.next()) {

											pstmt_update_dtl.setInt(1, iDocFolderOption);
											pstmt_update_dtl.setString(2, sDocSharedPathArray[i]);
											pstmt_update_dtl.setString(3, sDocTypes[i]);
											pstmt_update_dtl.setString(4, sFacilityId); 
											pstmt_update_dtl.setString(5,  "D");
											
											recordCount = pstmt_update_dtl.executeUpdate();

										} else {

											pstmt_insert_dtl.setString(1, sFacilityId);
											pstmt_insert_dtl.setString(2, sDocTypes[i]);
											pstmt_insert_dtl.setInt(3, iDocFolderOption);
											pstmt_insert_dtl.setString(4, sDocSharedPathArray[i]);
											pstmt_insert_dtl.setString(5, "");
											pstmt_insert_dtl.setString(6,  "D" );

											recordCount = pstmt_insert_dtl.executeUpdate();

										}

										if (recordCount == 0)
										{
											updateFlag = false;
										}

										//status_msg = updateDocumentDetails(request,sFacilityId,sDocTypes[i], iDocFolderOption, "D" );
										//if(isDebugYN)  System.out.println("status_msg insert  ...bhuvi:2..."+status_msg);
									}								
								}
							}
							else if(iDocFolderOption == 0) //Database 
							{
								if(isDebugYN)System.out.println("Entering into iDocFolderOption ZERO "+iDocFolderOption);
								status_msg = "";
								sDocTypes = request.getParameterValues("doc_types");
								if(isDebugYN)  System.out.println("sDocTypes.."+sDocTypes);

								if (sDocTypes != null) 
								{
									if(isDebugYN)  System.out.println("sDocTypes Length.."+sDocTypes.length);
									if(isDebugYN)  System.out.println("sDocSharedPathArray Length.."+sDocSharedPathArray.length);
									for (int i = 0; i < sDocTypes.length; i++) 
									{
										pstmt_select_dtl.setString(1, sDocTypes[i]);
										pstmt_select_dtl.setString(2, sFacilityId);
										pstmt_select_dtl.setString(3,  "D");									

										resultSetDtl = pstmt_select_dtl.executeQuery();


										if (resultSetDtl != null && resultSetDtl.next()) {

											pstmt_update_dtl.setInt(1, iDocFolderOption);
											pstmt_update_dtl.setString(2, sDocSharedPathArray[i]);
											pstmt_update_dtl.setString(3, sDocTypes[i]);
											pstmt_update_dtl.setString(4, sFacilityId); 
											pstmt_update_dtl.setString(5,  "D");
											
											recordCount = pstmt_update_dtl.executeUpdate();

										} else {

											pstmt_insert_dtl.setString(1, sFacilityId);
											pstmt_insert_dtl.setString(2, sDocTypes[i]);
											pstmt_insert_dtl.setInt(3, iDocFolderOption);
											pstmt_insert_dtl.setString(4, sDocSharedPathArray[i]);
											pstmt_insert_dtl.setString(5, "");
											pstmt_insert_dtl.setString(6,  "D" );

											recordCount = pstmt_insert_dtl.executeUpdate();

										}

										if (recordCount == 0)
										{
											updateFlag = false;
										}

										//status_msg = updateDocumentDetails(request,sFacilityId,sDocTypes[i], iDocFolderOption, "D" );
										if(isDebugYN)  System.out.println("status_msg insert  ..."+status_msg);
									}								
								}
							}
						}
						
						// To check whether Photo option is available for this site.

						if (iPhotoOption.equals("true"))   //Code Added by Bhuvaneshwari for SM-MO-CRF-20154.2 on 19/0612019
						{
							sPhotoSharedPathArray = request.getParameterValues("photo_shared_path");

							if(isDebugYN) System.out.println("sPhotoSharedPathArray.... "+sPhotoSharedPathArray.length);	
							
							//Added by bhuvana for MO-CRF-20153
							if(iPhotoDocOption == 1) 
							{
								if(isDebugYN) System.out.println("Entering into iPhotoDocOption "+iPhotoDocOption);
								sPhotoTypes = request.getParameterValues("photo_types");
								if(isDebugYN)  System.out.println("::: sPhotoTypes :::"+sPhotoTypes);
								//status_msg = "";
								
								if(isDebugYN)  System.out.println(" ::: sPhotoSharedPathArray :::"+sPhotoSharedPathArray);

								if (sPhotoTypes != null) 
								{		
									if(isDebugYN)  System.out.println("sPhotoTypes length "+sPhotoTypes.length);

									for (int i = 0; i < sPhotoTypes.length; i++) 
									{

										pstmt_select_dtl.setString(1, sPhotoTypes[i]);
										pstmt_select_dtl.setString(2, sFacilityId);
										pstmt_select_dtl.setString(3,  "P");								

										resultSetDtl = pstmt_select_dtl.executeQuery();

										if (resultSetDtl != null && resultSetDtl.next()) {

											pstmt_update_dtl.setInt(1, iPhotoDocOption);
											pstmt_update_dtl.setString(2, sPhotoSharedPathArray[i]);
											pstmt_update_dtl.setString(3, sPhotoTypes[i]);
											pstmt_update_dtl.setString(4, sFacilityId); 
											pstmt_update_dtl.setString(5,  "P");
											
											recordCount = pstmt_update_dtl.executeUpdate();

										} else {

											pstmt_insert_dtl.setString(1, sFacilityId);
											pstmt_insert_dtl.setString(2, sPhotoTypes[i]);
											pstmt_insert_dtl.setInt(3, iPhotoDocOption);
											pstmt_insert_dtl.setString(4, sPhotoSharedPathArray[i]);
											pstmt_insert_dtl.setString(5, "");
											pstmt_insert_dtl.setString(6,  "P" );

											recordCount = pstmt_insert_dtl.executeUpdate();

										}

										if (recordCount == 0)
										{
											updateFlag = false;
										}

										
										//status_msg = updateDocumentDetails(request,sFacilityId, sPhotoSharedPathArray[i],sPhotoTypes[i], iPhotoDocOption,sWebServiceUrl ,"P");
										//if(isDebugYN) System.out.println("status_msg insert ...bhuvi:3..."+status_msg);

									}								
								} 							
							}
							else if(iPhotoDocOption == 0) 
							{
								if(isDebugYN)System.out.println("Entering into iPhotoDocOption ZERO "+iPhotoDocOption);
								//status_msg = "";
								sPhotoTypes = request.getParameterValues("photo_types");
								if(isDebugYN) System.out.println("sDocTypes.."+sPhotoTypes);

								if (sPhotoTypes != null) 
								{
									if(isDebugYN) System.out.println("sDocTypes not null.."+sPhotoTypes);
									for (int i = 0; i < sPhotoTypes.length; i++) 
									{

										pstmt_select_dtl.setString(1, sPhotoTypes[i]);
										pstmt_select_dtl.setString(2, sFacilityId);
										pstmt_select_dtl.setString(3,  "P");

										resultSetDtl = pstmt_select_dtl.executeQuery();

										if (resultSetDtl != null && resultSetDtl.next()) {

											pstmt_update_dtl.setInt(1, iPhotoDocOption);
											pstmt_update_dtl.setString(2, sPhotoSharedPathArray[i]);
											pstmt_update_dtl.setString(3, sPhotoTypes[i]);
											pstmt_update_dtl.setString(4, sFacilityId); 
											pstmt_update_dtl.setString(5,  "P");
											
											recordCount = pstmt_update_dtl.executeUpdate();

										} else {

											pstmt_insert_dtl.setString(1, sFacilityId);
											pstmt_insert_dtl.setString(2, sPhotoTypes[i]);
											pstmt_insert_dtl.setInt(3, iPhotoDocOption);
											pstmt_insert_dtl.setString(4, sPhotoSharedPathArray[i]);
											pstmt_insert_dtl.setString(5, "");
											pstmt_insert_dtl.setString(6,  "P" );

											recordCount = pstmt_insert_dtl.executeUpdate();

										}

										if (recordCount == 0)
										{
											updateFlag = false;
										}
										//status_msg = updateDocumentDetails(request,sFacilityId,sPhotoTypes[i], iPhotoDocOption , "P" );
										//if(isDebugYN) System.out.println("status_msg insert ...bhuvi:4..."+status_msg);
									}							
								}

							} //Ended for MO-CRF-20153	
						}
						
						//Added by kamatchi S for MO-CRF-20171.1
						if (iInventoryOption.equals("true")) 
						{
							if(isDebugYN) System.out.println("Before Get Shared Path... ");
							if(isDebugYN) System.out.println("sInvSharedPathArray... "+request.getParameter("inventory_shared_path"));

							sInvSharedPathArray = request.getParameterValues("inventory_shared_path");
							if(isDebugYN) System.out.println("sInvSharedPathArray... "+sInvSharedPathArray.length);	

							if (iInvFolderOption == 1) 
							{
							
								if(isDebugYN)  System.out.println("Entering into iDocFolderOption "+iInvFolderOption);
								sInvTypes = request.getParameterValues("inv_types");
								if(isDebugYN)  System.out.println("sInvTypes.."+sInvTypes);

								if (sInvTypes != null) 
								{
									if(isDebugYN)  System.out.println("sInvTypes not null.."+sInvTypes);
									for (int i = 0; i < sInvTypes.length; i++) 
									{
										pstmt_select_dtl.setString(1, sInvTypes[i]);
										pstmt_select_dtl.setString(2, sFacilityId);
										pstmt_select_dtl.setString(3,  "D");									

										resultSetDtl = pstmt_select_dtl.executeQuery();

										if (resultSetDtl != null && resultSetDtl.next()) {

											pstmt_update_dtl.setInt(1, iInvFolderOption);
											pstmt_update_dtl.setString(2, sInvSharedPathArray[i]);
											pstmt_update_dtl.setString(3, sInvTypes[i]);
											pstmt_update_dtl.setString(4, sFacilityId); 
											pstmt_update_dtl.setString(5,  "D");
											
											recordCount = pstmt_update_dtl.executeUpdate();

										} else {

											pstmt_insert_dtl.setString(1, sFacilityId);
											pstmt_insert_dtl.setString(2, sInvTypes[i]);
											pstmt_insert_dtl.setInt(3, iInvFolderOption);
											pstmt_insert_dtl.setString(4, sInvSharedPathArray[i]);
											pstmt_insert_dtl.setString(5, "");
											pstmt_insert_dtl.setString(6,  "D" );

											recordCount = pstmt_insert_dtl.executeUpdate();

										}

										if (recordCount == 0)
										{
											updateFlag = false;
										}

									}								
								}
							}
							else if(iInvFolderOption == 0) //Database 
							{
								if(isDebugYN)System.out.println("Entering into iInvFolderOption ZERO "+iInvFolderOption);
								status_msg = "";
								sInvTypes = request.getParameterValues("inv_types");
								if(isDebugYN)  System.out.println("sInvTypes.."+sInvTypes);

								if (sInvTypes != null) 
								{
									if(isDebugYN)  System.out.println("sInvTypes Length.."+sInvTypes.length);
									if(isDebugYN)  System.out.println("sInvSharedPathArray Length.."+sInvSharedPathArray.length);
									for (int i = 0; i < sInvTypes.length; i++) 
									{
										pstmt_select_dtl.setString(1, sInvTypes[i]);
										pstmt_select_dtl.setString(2, sFacilityId);
										pstmt_select_dtl.setString(3,  "D");									

										resultSetDtl = pstmt_select_dtl.executeQuery();


										if (resultSetDtl != null && resultSetDtl.next()) {

											pstmt_update_dtl.setInt(1, iInvFolderOption);
											pstmt_update_dtl.setString(2, sInvSharedPathArray[i]);
											pstmt_update_dtl.setString(3, sInvTypes[i]);
											pstmt_update_dtl.setString(4, sFacilityId); 
											pstmt_update_dtl.setString(5,  "D");    
											
											recordCount = pstmt_update_dtl.executeUpdate();

										} else {

											pstmt_insert_dtl.setString(1, sFacilityId);
											pstmt_insert_dtl.setString(2, sInvTypes[i]);
											pstmt_insert_dtl.setInt(3, iInvFolderOption);
											pstmt_insert_dtl.setString(4, sInvSharedPathArray[i]);
											pstmt_insert_dtl.setString(5, "");
											pstmt_insert_dtl.setString(6,  "D" );

											recordCount = pstmt_insert_dtl.executeUpdate();

										}

										if (recordCount == 0)
										{
											updateFlag = false;
										}
										if(isDebugYN)  System.out.println("status_msg insert  ..."+status_msg);
									}								
								}
							}
						}
						//if(isDebugYN) System.out.println("status_msg-bhuvi5: "+status_msg);					
					} 
					
					System.out.println(" ---------------------------- updateFlag Facility "+getFacility+ "-------------------------- : "+updateFlag);	

					if (!updateFlag)
					{
						break;
					}					
				}
			}
			
			if (!updateFlag)
			{
				try {
						con.rollback();
						response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="
									+ java.net.URLEncoder
											.encode("Records are not successfully inserted!!!",
													"UTF-8"));
					} 
					catch (Exception ee) 
					{
						System.out.println("Exception in Roll Back Block  : "
								+ ee.toString());
						ee.printStackTrace();
					}
			}
			else
			{
				try {
						con.commit();
						errorMessage = getMessage(locale,
									"RECORD_INSERTED", "CA");
							response.sendRedirect("../eCommon/jsp/MstCodeError.jsp?err_num="
									+ java.net.URLEncoder.encode(errorMessage,
											"UTF-8"));
					} 
					catch (Exception ee) 
					{
						System.out.println("Exception in Commit Block  : "
								+ ee.toString());
						ee.printStackTrace();
					}
			}						
					
		} catch (Exception e) {
			System.out.println("Exception in insert Main Block  : " + e.toString());
			e.printStackTrace();
		} finally {
			try {

				if(resultSet!= null);
					resultSet.close();

				if (pstmt_insert != null)
					pstmt_insert.close();
				//Below added for Checkstyle issue
				if (pstmt_select != null)
					pstmt_select.close();

				if (pstmt_update != null)
					pstmt_update.close();

				if (pstmt_select_dtl != null)
					pstmt_select_dtl.close();

                if (pstmt_update_dtl != null)
					pstmt_update_dtl.close();

				if (pstmt_insert_dtl != null)
					pstmt_insert_dtl.close();
			
				//Ended for Checkstyle issue
				if (con != null)
					ConnectionManager.returnConnection(con, request);
			} catch (Exception ee) {
				System.out.println("Exception in finally Block : "
						+ ee.toString());
				ee.printStackTrace();
			}
		}
	}

	
	public ArrayList<String>  getFacilityName(HttpServletRequest request, HttpServletResponse response , String facilityid, Connection con)
	{
		//Connection con = null; //Commented for checkstyle
		PreparedStatement  pstmt= null;
		ResultSet resultSet = null;
		String pfacility_name = "";
		int count = 0;
		ArrayList<String> facilitynameList = new ArrayList<String>();

		if (facilityid.equals("A*"))
		{
			try{
				//con = ConnectionManager.getConnection(request); //Commented for checkstyle
				String facility_Name_List = "SELECT FACILITY_ID from SM_FACILITY_PARAM where STATUS = 'E'";
				pstmt = con.prepareStatement(facility_Name_List.toString());
				resultSet = pstmt.executeQuery();
				while(resultSet.next()){
					pfacility_name = resultSet.getString("FACILITY_ID");
				    System.out.println(" ::: pfacility_name ::: "+pfacility_name);
					facilitynameList.add(pfacility_name);
					count++;
					
					}
				}
				
			catch(Exception e){
				e.getMessage();
				e.printStackTrace();
			}
			finally{
				try {
				if (pstmt != null)
					pstmt.close();

				if (resultSet != null) resultSet.close(); //Added for checkstyle
				//if (con != null)
					//ConnectionManager.returnConnection(con, request); //Commented for checkstyle
			} catch (Exception ee) {
				System.out.println("Exception in finally Block : "
						+ ee.toString());
				ee.printStackTrace();}
			}	
		 }
		 else
		 {
		    pfacility_name = facilityid ;
			facilitynameList.add(pfacility_name);
			
		 }
		return facilitynameList;
	}
}
