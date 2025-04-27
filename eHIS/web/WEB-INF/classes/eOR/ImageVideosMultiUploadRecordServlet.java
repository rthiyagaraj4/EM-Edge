/*
---------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------
23/05/2019	IN068778		Selvin M		23/05/2019		Ramesh G		TBMC-CRF-0011
---------------------------------------------------------------------------------------------------------------------
 */

package eOR;

import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.naming.*;
import javax.rmi.*;
import webbeans.eCommon.*;
import com.ehis.util.BundleMessage;
import org.apache.commons.fileupload.*;
import com.ehis.persist.PersistenceHelper;
import eOR.ImageVideosMultiFileUploadBean.FileDoc;

public class ImageVideosMultiUploadRecordServlet extends HttpServlet {
	HttpSession session = null;
	java.io.PrintWriter out = null;
	java.util.Properties p = null;

	Connection con = null;
	PreparedStatement pstAccNum = null;
	PreparedStatement pstInsEnctrNote = null;
	PreparedStatement pstUpdtEnctrNote = null;
	PreparedStatement pstEnctrDtlObj = null;
	PreparedStatement pstEnctrDtlBlobObj = null;
	PreparedStatement pstEnctrNoteAudLog = null;
	PreparedStatement pstUpdtEnctrDtlObj = null;

	ResultSet rsAccNum = null;
	ResultSet rsEnctrDtlObj = null;
	ResultSet rsInsEnctrNote = null;
	ResultSet rsUpdtEnctrNote = null;
	ResultSet rsEnctrDtlBlobObj = null;
	ResultSet rsEnctrNoteAudLog = null;
	ResultSet rsUpdtEnctrDtlObj = null;

	java.util.HashMap results = new java.util.HashMap();

	String facilityId = "";
	String client_ip_address = "";
	String addedById = "";
	String modifiedById = "";
	String addedFacilityId = "";
	String modifiedFacilityId = "";
	String addedAtWorkstation = "";
	String modifiedAtWorkstation = "";

	String login_user_id = "", clinician_id = "", clinician_name = "";
	String resp_name = "", resp_id = "";

	String operation_mode = "";	
	String accession_num = "";
	String performed_by_id = "";
	String privilege_type = "";
	String function_id = "";
	String field_ref = "";
	String window_close = "";
	String patient_id = "";
	String episode_type = "";
	String encounter_id = "";
	String patient_class = "";
	String event_type_caption = "";
	String note_type = "";
	String service_code = "";
	String event_class = "";
	String note_type_security_level = "";
	String event_date_caption = "";
	String event_date_time = "";
	String event_perf_by_caption = "";
	String event_title_caption = "";
	String event_title_desc = "";
	String note_content = "";
	String event_auth_by_caption = "";
	String authorized_by_id = "";
	String authorized_date_time = "";
	String event_status_caption = "";
	String event_status = "";
	String encntr_date = "";
	String contr_mod_accession_num = "";
	String serv_facl_spec_yn = "";
	String visit_adm_date = "";
	String amendment_type = "";
	String appl_task_id = "";
	String security_level = "";
	String login_at_ws_no = "";
	String remarks = "";
	String forwarded_clinician_id = "";
	String uploadremarks = "";
	String change_file_ref = "";
	String doc_type = "";
	String strOutput = "N";

	int record_count = 0;
	int colIndex = 0;
	int insert_result = 0;
	int insert_blob_result = 0;
	int update_blob_result = 0;
	int blob_doc_size = 0;
	int size = 0;
	int delete_result = 0;

	StringTokenizer str_doc_type = null;

	String error_msg = "";
	String name = "";
	String value = "";
	DiskFileUpload upload = null;
	List items = null;
	Iterator iter = null;
	java.io.InputStream instream = null;
	FileItem fileItem = null;
	String docName = "";
	String docType = "";
	String called_from = "";
	long docSize = 0;

	boolean isMultipart = false;
	FileItem Item = null;

	StringBuffer strbuf = new StringBuffer();
	boolean commit_flag = true;
	boolean res = false;

	MessageManager msgmngr = null;
	java.util.Hashtable message = null;
	String locale = "";

	public void init(ServletConfig cfg) throws ServletException {
		super.init(cfg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, java.io.IOException {
		out = response.getWriter();

		try {
			request.setCharacterEncoding("UTF-8");
			response.setContentType("text/html; charset=UTF-8");

			session = request.getSession(false);

			p = (Properties) session.getValue("jdbc");
			locale = (String) p.getProperty("LOCALE");
			facilityId = (String) session.getValue("facility_id");
			client_ip_address = this.p.getProperty("client_ip_address");
			addedById = p.getProperty("login_user");
			modifiedById = addedById;
			addedFacilityId = facilityId;
			modifiedFacilityId = addedFacilityId;
			addedAtWorkstation = client_ip_address;
			modifiedAtWorkstation = addedAtWorkstation;
			login_at_ws_no = request.getRemoteAddr();

			login_user_id = (String) session.getValue("login_user");
			resp_name = (String) session.getValue("resp_name");
			clinician_id = (String) session.getValue("ca_practitioner_id");
			clinician_name = (String) session.getValue("practitioner_name");
			resp_id = (String) session.getValue("responsibility_id");

			con = ConnectionManager.getConnection(request);
			
			try {
				
				System.out.println("177,request=>"+request.getQueryString());
				
				isMultipart = FileUpload.isMultipartContent(request);
				if (isMultipart) {

					upload = new DiskFileUpload();

					items = upload.parseRequest(request);
					iter = items.iterator();
					while (iter.hasNext()) {
						Item = (FileItem) iter.next();

						if (Item.isFormField()) {

							String name = Item.getFieldName();
							String value = Item.getString();

							if (name.equals("operation_mode"))
								operation_mode = checkForNull(value);							
							else if (name.equals("uploadremarks"))
								uploadremarks = checkForNull(value);
							else if (name.equals("change_file_ref"))
								change_file_ref = checkForNull(value);
							else if (name.equals("doc_type"))
								doc_type = checkForNull(value);
							else if (name.equals("called_from"))
								called_from = checkForNull(value);

						} else {
							fileItem = Item;
							docName = Item.getName();
							docType = Item.getContentType();
							docSize = Item.getSize();
						}
					}
				}// end of multipart req				
			} catch (Exception e) {
				e.printStackTrace();
			}
			fileUpload(request, response);

			upload = null;
			items = null;
			iter = null;
			instream = null;

			fileItem.delete();
			fileItem = null;
		} catch (Exception e) {
			e.printStackTrace();
			out.println("Exception @ Servlet - main:2" + e.toString());
		} finally {
			out = null;
			if (con != null)
				ConnectionManager.returnConnection(con, request);
			con = null;
		}
	}

	// --doPost---end--------------------------
	public void fileUpload(HttpServletRequest request,
			HttpServletResponse response) throws FileUploadException,
			java.io.IOException {
		String error_value = "";
		StringBuffer error = new StringBuffer();
		java.util.HashMap uploadresults = new java.util.HashMap();
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		//COMMON-ICN-0122  Start.
		//String note_linked_file_limit_unit = "";
		//int note_linked_file_limit = 0;
		//double paramsize = 0;
		////COMMON-ICN-0122 End.
		boolean record_status = false;
		ArrayList doc_arr = new ArrayList();
		
		ImageVideosMultiFileUploadBean fBean = (ImageVideosMultiFileUploadBean) PersistenceHelper
				.getObjectFromBean("MULTIPLEFILEUPLOADBEAN",
						"eOR.ImageVideosMultiFileUploadBean",
						session);

		try {

			if (!docName.equals("")) {
				try {
					String qry_doc_type = "select distinct OBJ_TYPE from ca_appl_linked_obj_type where APPLICABLE_YN = 'Y' and obj_type != 'text/plain' ";
					pstmt = con.prepareStatement(qry_doc_type);

					rs = pstmt.executeQuery();
					while (rs.next()) {
						doc_arr.add(rs.getString("OBJ_TYPE"));
						System.err.println("411,doc_arr=" + doc_arr);
					}
					doc_arr.add("application/octet-stream");

					for (int i = 0; i < doc_arr.size(); i++) {
						if (docType.equals(doc_arr.get(i))) {

							record_status = true;
							break;
						} else {

							record_status = false;
						}
					}
				} catch (Exception e) {
					e.printStackTrace();
					record_status = false;
					error.append("<br>Exception @ RecClinicalNotesSectionsFileUpload while checking for the doc type"
							+ e);
				} finally {
					if (rs != null)
						rs.close();
					if (pstmt != null)
						pstmt.close();
				}
				if (record_status == false) {
					record_status = false;
					error_value = "0";
					error.append(getMessage(locale, "FILE_NOT_SUPPORTED", "CA"));
				}
			}

			if ((docName.equals("") && record_status == false)
					|| (!docName.equals("") && record_status == true)) {

				System.err
						.println("482,======ImageVideosMultiUploadRecordServlet.java======");
				System.err.println("483,operation_mode==" + operation_mode
						+ "=accession_num=" + accession_num);			

				if (operation_mode.equals("Record")) {
					uploadresults = UpdateFileUpload(request,
							response);
				}

				record_status = ((Boolean) uploadresults.get("status"))
						.booleanValue();
				accession_num = (String) uploadresults.get("accession_num");

				if (record_status) {
					error_value = "1";
					error.append(getMessage(locale, "RECORD_INSERTED", "CA"));

				} else {
					error_value = "0";
					error.append(getMessage(locale, "FAILED_TRANSACTION", "CA"));
					error.append(uploadresults.get("error"));
				}
				if (uploadresults != null)
					uploadresults.clear();
			}
			System.err.println("491,called_from==" + called_from);

			response.sendRedirect("../eOR/jsp/ImageVideosFileUploadError.jsp?err_num="
					+ java.net.URLEncoder.encode(error.toString(), "UTF-8")
					+ "&err_value="
					+ error_value
					+ "&operation_mode="
					+ operation_mode
					+ "&accession_num="
					+ accession_num
					+ "&called_from="
					+ called_from
					+ "&order_id="
					+ fBean.getOrderId()
					+ "&order_line_num=" + fBean.getOrderLineNum());
		} catch (Exception e) {
			e.printStackTrace();
			out.println("Exception @ NotesFileUpload " + e.toString());
		}

	}

	public java.util.HashMap recordNoteSectionsFileUpload(
			HttpServletRequest request, HttpServletResponse response)
			throws FileUploadException, java.io.IOException {
		System.err.println("527,recordNoteSectionsFileUploa======");
		MessageManager msgmngr = null;
		java.util.Hashtable message = null;
		java.util.HashMap results = new java.util.HashMap();
		
		ImageVideosMultiFileUploadBean fBean = (ImageVideosMultiFileUploadBean) PersistenceHelper
				.getObjectFromBean("MULTIPLEFILEUPLOADBEAN",
						"eOR.ImageVideosMultiFileUploadBean",
						session);
		try {
			strbuf.delete(0, strbuf.length());
			msgmngr = new MessageManager();

			if (operation_mode.equals("Record")) {
				authorized_by_id = "";
				authorized_date_time = "";
				event_status = "1";
			}

			con.setAutoCommit(false);
			try {
				if (accession_num.equals("")) {
					try {
						//ImageVideosMultiFileUploadBean fBean = (ImageVideosMultiFileUploadBean) PersistenceHelper
								//.getObjectFromBean("MULTIPLEFILEUPLOADBEAN",
										//"eOR.ImageVideosMultiFileUploadBean",
										//session);

						commit_flag = fBean.insertDocToDB(con, fBean.getOrderId(),
								fBean.getOrderLineNum());
						System.err.println("716,commit_flag==========="
								+ commit_flag);
						if (commit_flag) {
							fBean.clear();
						}

					} catch (Exception e) {
						e.printStackTrace();
						commit_flag = false;
						strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - Inserting blob histdata "
								+ e);
					} finally {
						if (pstEnctrDtlObj != null)
							pstEnctrDtlObj.close();
					}

				}
			} catch (Exception e) {
				e.printStackTrace();
				commit_flag = false;
				strbuf.append("<br>Exception @ RecClinicalNotesFileUploadManager: main : "
						+ e);
			}
		} catch (Exception e) {
			e.printStackTrace();
			commit_flag = false;
			out.println("<br>Exception @ RecClinicalNotesFileUploadServlet - while accessing cabuildnotes(): "
					+ e);
		} finally {
			try {
				if (commit_flag) {
					res = true;
					message = msgmngr.getMessage(locale, "RECORD_INSERTED",
							"CA");
					strbuf.append((String) message.get("message"));
					con.commit();
				} else {
					con.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
				strbuf.append("<br>Exception@ record:" + e);
				try {
					con.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
					strbuf.append("<br>Exception@ record while rolling back:"
							+ e1);
				}
			}
		}

		results.put("status", new Boolean(res));
		results.put("error", strbuf.toString());
		results.put("accession_num", accession_num);
		if (message != null)
			message.clear();
		return results;
	}

	public java.util.HashMap UpdateFileUpload(
			HttpServletRequest request, HttpServletResponse response)
			throws FileUploadException, java.io.IOException {
		MessageManager msgmngr = null;
		java.util.Hashtable message = null;
		java.util.HashMap results = new java.util.HashMap();		
		
		ImageVideosMultiFileUploadBean fBean = (ImageVideosMultiFileUploadBean) PersistenceHelper
				.getObjectFromBean("MULTIPLEFILEUPLOADBEAN",
						"eOR.ImageVideosMultiFileUploadBean",
						session);
		try {
			strbuf.delete(0, strbuf.length());
			msgmngr = new MessageManager();			

			try {

				commit_flag = fBean.insertDocToDB(con, fBean.getOrderId(),
						fBean.getOrderLineNum());
				System.err.println("1058,commit_flag=" + commit_flag);
				if (commit_flag) {
					fBean.clear();
				}

			} catch (Exception e) {
				e.printStackTrace();
				commit_flag = false;
				strbuf.append("<br>Exception@ RecClinicalNotesFileUploadServlet - Inserting blob histdata "
						+ e);
			} finally {
				if (pstEnctrDtlObj != null)
					pstEnctrDtlObj.close();
			}

		} catch (Exception e) {
			e.printStackTrace();
			commit_flag = false;
			out.println("<br>Exception @ RecClinicalNotesFileUploadServlet - while accessing cabuildnotes(): "
					+ e);
		} finally {
			try {
				if (commit_flag) {
					res = true;
					message = msgmngr.getMessage(locale, "RECORD_INSERTED",
							"CA");
					strbuf.append((String) message.get("message"));
					con.commit();
				} else {
					con.rollback();
				}
			} catch (Exception e) {
				e.printStackTrace();
				strbuf.append("<br>Exception@ record:" + e);
				try {
					con.rollback();
				} catch (Exception e1) {
					e1.printStackTrace();
					strbuf.append("<br>Exception@ record while rolling back:"
							+ e1);
				}
			}
		}

		results.put("status", new Boolean(res));
		results.put("error", strbuf.toString());
		results.put("accession_num", accession_num);
		results.put("err_value", res);
		if (message != null)
			message.clear();
		return results;
	}

	private String checkForNull(String inputString) {
		return (inputString == null) ? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue) {
		return (inputString == null) ? defaultValue : inputString;
	}

	private String getMessage(String locale, String messageId, String moduleId) {
		java.util.Hashtable message = MessageManager.getMessage(locale,
				messageId, moduleId);
		String mesg = (String) message.get("message");
		message.clear();
		return (mesg);
	}
}