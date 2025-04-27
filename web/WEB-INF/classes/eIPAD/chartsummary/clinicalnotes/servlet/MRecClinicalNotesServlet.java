package eIPAD.chartsummary.clinicalnotes.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Properties;
import java.util.StringTokenizer;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpUtils;

import webbeans.eCommon.ConnectionManager;
import webbeans.eCommon.MessageManager;

import com.ehis.persist.PersistenceHelper;
import com.google.gson.Gson;

import eCA.RecClinicalNotes.RecClinicalNotesHome;
import eIPAD.chartsummary.clinicalnotes.bc.ClinicalNotesBC;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesMapResponse;
import eIPAD.chartsummary.clinicalnotes.response.ClinicalNotesTransactionResponse;
import eIPAD.chartsummary.common.healthobject.PatContext;
import eIPAD.chartsummary.common.response.TransactionResponse;
import eIPAD.chartsummary.encounterlist.bc.EncounterListBC;
import eIPAD.chartsummary.encounterlist.request.EncounterListRequest;
import eIPAD.chartsummary.encounterlist.response.EncounterListResponse;

/**
 * Servlet implementation class MRecClinicalNotesServlet
 */
public class MRecClinicalNotesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public MRecClinicalNotesServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		webbeans.eCA.RecClinicalNotesSectionBean clinicalNotesSectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)PersistenceHelper.getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
		PatContext patientContext = (PatContext)session.getAttribute("PatientContext");
		HashMap htRecClinicalNotes					=	new java.util.HashMap();
		Gson gson = new Gson();
		String jsonFieldResponse = "";
		if(patientContext != null){
			Properties p = (Properties)session.getAttribute("jdbc") ;
			String locale = (String)p.getProperty("LOCALE");
			ClinicalNotesBC bc = new ClinicalNotesBC();
			ClinicalNotesTransactionResponse transactionResponse = new ClinicalNotesTransactionResponse();

			String clinician_id	= (String)session.getAttribute("ca_practitioner_id");
			String clinician_name = (String)session.getAttribute("practitioner_name");
			String resp_name = (String)session.getAttribute("responsibility_name");
			String resp_id = (String)session.getAttribute("responsibility_id");
			String facility_id = (String)session.getAttribute("facility_id");
			String login_user_id = (String)session.getAttribute("login_user");
			String login_at_ws_no =	checkForNull(p.getProperty("client_ip_address"));
			String accession_num = checkForNull(request.getParameter("accession_num")); //empty for new note
			String performed_by_id = clinician_id; //Logged in practitioner is the one always in mobile. Other practitioners cannot create on behalf

			String forwarded_clinician_ids_csv = checkForNull(request.getParameter("forwarded_clinician_ids")); //csv of clinician ids to forward
			ArrayList<String> forwarded_clinician_ids_List = new ArrayList<String>();
			StringTokenizer stFwdClinicians = new StringTokenizer(forwarded_clinician_ids_csv,",");
			while(stFwdClinicians!=null && stFwdClinicians.hasMoreTokens())
			{
				forwarded_clinician_ids_List.add(stFwdClinicians.nextToken());
			}

			String forwarded_clinician_id = checkForNull(request.getParameter("forwarded_clinician_id")); //not applicable for record/sign
			String action_comment =	checkForNull(request.getParameter("action_comment")); //empty for new note
			String record_mode = checkForNull(request.getParameter("record_mode")); //currently applicable for addendum alone
			//action_comment = java.net.URLDecoder.decode(action_comment);

			String operation_mode = checkForNull(request.getParameter("operation_mode"));
			String note_type_desc = checkForNull(request.getParameter("note_type_desc")); //TODO
			String note_type = checkForNull(request.getParameter("note_type"));//TODO
			String service_code = checkForNull(request.getParameter("service_code"));//Medical Anc Service TODO
			SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");
			String event_date_time	= checkForNull( request.getParameter("event_date_time"), sdf.format(new Date()));//TODO
			event_date_time	= com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM",locale,"en");

			String patient_id = patientContext.getPatientId();
			String patient_class = patientContext.getPatientClass();
			String episode_type = "I";
			if(patient_class.equals("OP") || patient_class.equals("EM"))
				episode_type = "O";

			String encounter_id = patientContext.getEncounterId();
			String note_content = "";//TODO FIND

			String authorized_by_id = "";//empty for now
			String authorized_date_time = ""; //empty for now

			String event_status = checkForNull(request.getParameter("event_status"),"1");
			if(event_status.equals(""))
				event_status="j"; //More on this variable is done in the RecClinicalNotesServlet TODO
			//for getting visit_adm_date
			String encntr_date = "";
			EncounterListBC encBc = new EncounterListBC();
			EncounterListRequest encReq = new EncounterListRequest();
			encReq.setPatientContext(patientContext);
			encReq.setFilterEncounterId(patientContext.getEncounterId());
			EncounterListResponse encRes = encBc.getEncounterList(encReq);
			if(encRes.isSuccessResponse() && !encRes.isEmptyDataResponse()){
				encntr_date = encRes.getEncounterList().get(0).getFromDate();
			}

			String contr_mod_accession_num = ""; //empty for new note

			String forward_mode = checkForNull(request.getParameter("forward_mode"));
			String appl_task_id = "CLINICAL_NOTES";
			String selection_type = checkForNull(request.getParameter("selection_type"));
			eCA.PatientBannerGroupLine manageEmailBean = null;
			manageEmailBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
			HashMap multiHash = null;
			multiHash = manageEmailBean.returnHashMap();
			String function_id = "";
			String srl_no = ""; //applicable for addendum only
			String forwardToFac = "";
			String contr_oth_accession_num = "";
			String amendment_type = checkForNull(request.getParameter("amendment_type"));

			String privilege_type = "";
			String serv_facl_spec_yn = "";
			String event_class = "";
			String note_type_security_level = "";
			String event_date_caption = "";
			String event_perf_by_caption = "";
			String event_title_caption = "";
			String event_title_desc = "";
			String event_auth_by_caption = "";
			String doc_linked_note_yn = "";
			String event_status_caption = "";
			String event_type_caption = "";

			ClinicalNotesMapResponse sectDetailsResponse = bc.getNoteTypeSectionDetails(resp_id, note_type, locale);
			if(sectDetailsResponse.isSuccessResponse()){
				HashMap sectDetailsMap = sectDetailsResponse.getMap();
				privilege_type = (String)sectDetailsMap.get("privilege_type");
				serv_facl_spec_yn = (String)sectDetailsMap.get("serv_facl_spec_yn");
				event_class = (String)sectDetailsMap.get("event_class");
				note_type_security_level = (String)sectDetailsMap.get("security_level");
				event_date_caption = (String)sectDetailsMap.get("event_date_caption");
				event_perf_by_caption = (String)sectDetailsMap.get("event_perf_by_caption");
				event_title_caption = (String)sectDetailsMap.get("event_title_caption");
				event_title_desc = (String)sectDetailsMap.get("event_title_desc");
				event_auth_by_caption = (String)sectDetailsMap.get("event_auth_by_caption");
				doc_linked_note_yn = (String)sectDetailsMap.get("doc_linked_note_yn");
				event_status_caption = (String)sectDetailsMap.get("event_status_caption");
				event_type_caption = (String)sectDetailsMap.get("event_type_caption");
			}

			htRecClinicalNotes.put ( "operation_mode",			operation_mode				);
			htRecClinicalNotes.put ( "clinician_id",			clinician_id				);
			htRecClinicalNotes.put ( "clinician_name",			clinician_name				);
			htRecClinicalNotes.put ( "resp_name",				resp_name					);
			htRecClinicalNotes.put ( "responsibility_id",		resp_id						);
			htRecClinicalNotes.put ( "facility_id",				facility_id					);
			htRecClinicalNotes.put ( "login_user_id",			login_user_id				);
			htRecClinicalNotes.put ( "login_at_ws_no",			login_at_ws_no				);
			htRecClinicalNotes.put ( "accession_num",			accession_num				);
			htRecClinicalNotes.put ( "amendment_type",			amendment_type				);
			htRecClinicalNotes.put ( "performed_by_id",			performed_by_id				);
			htRecClinicalNotes.put ( "forwarded_clinician_id",	forwarded_clinician_id		);
			htRecClinicalNotes.put ( "action_comment",			action_comment				);
			htRecClinicalNotes.put ( "privilege_type",			privilege_type				);
			htRecClinicalNotes.put ( "serv_facl_spec_yn",		serv_facl_spec_yn			);
			htRecClinicalNotes.put ( "note_type_desc",			note_type_desc				);
			htRecClinicalNotes.put ( "patient_id",				patient_id					);
			htRecClinicalNotes.put ( "episode_type",			episode_type				);
			htRecClinicalNotes.put ( "encounter_id",			encounter_id				);
			htRecClinicalNotes.put ( "patient_class",			patient_class				);
			htRecClinicalNotes.put ( "event_type_caption",		event_type_caption			);
			htRecClinicalNotes.put ( "note_type",				note_type					);
			htRecClinicalNotes.put ( "service_code",			service_code				);
			htRecClinicalNotes.put ( "event_class",				event_class					);
			htRecClinicalNotes.put ( "security_level",			note_type_security_level	);
			htRecClinicalNotes.put ( "event_date_caption",		event_date_caption			);
			htRecClinicalNotes.put ( "event_date_time",			event_date_time				);
			htRecClinicalNotes.put ( "event_perf_by_caption",	event_perf_by_caption		);
			htRecClinicalNotes.put ( "event_title_caption",		event_title_caption			);
			htRecClinicalNotes.put ( "event_title_desc",		event_title_desc			);
			htRecClinicalNotes.put ( "note_content",			note_content				);
			htRecClinicalNotes.put ( "event_auth_by_caption",	event_auth_by_caption		);
			htRecClinicalNotes.put ( "authorized_by_id",		authorized_by_id			);
			htRecClinicalNotes.put ( "authorized_date_time",	authorized_date_time		);
			htRecClinicalNotes.put ( "event_status_caption",	event_status_caption		);
			htRecClinicalNotes.put ( "event_status",			event_status				);
			htRecClinicalNotes.put ( "encntr_date",				encntr_date					);
			htRecClinicalNotes.put ( "contr_mod_accession_num",	contr_mod_accession_num		);
			htRecClinicalNotes.put ( "doc_linked_note_yn",		doc_linked_note_yn			);
			htRecClinicalNotes.put ( "LOCALE",					locale						);
			htRecClinicalNotes.put ( "forward_mode",			forward_mode				);
			htRecClinicalNotes.put ( "appl_task_id",			appl_task_id				);
			htRecClinicalNotes.put ( "selection_type",			selection_type				);
			htRecClinicalNotes.put ( "multiHash",				multiHash					);
			htRecClinicalNotes.put ( "function_id",				function_id					);
			htRecClinicalNotes.put ( "record_mode",				record_mode					);  //[IN033677]
			htRecClinicalNotes.put ( "srl_no",					srl_no						);  //[IN033677]
			htRecClinicalNotes.put ( "forwardToFac",			forwardToFac				);//IN037675
			htRecClinicalNotes.put ( "contr_oth_accession_num",	contr_oth_accession_num		);  //IN053733
			htRecClinicalNotes.put ( "noteCopiedYN",	"N"		); 

			System.out.println(htRecClinicalNotes);


			String		strInsertFlag					=	"N";
			Connection				con			=	null;
			int count = 0;
			String print_notes_yn = "";
			String module_id = "";
			String field_ref = "";

			try
			{
				java.util.HashMap results = null;
				boolean inserted = false;
				String error_msg = "";
				boolean local_ejbs = false;

				if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
					local_ejbs = true;

				Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecClinicalNotes", RecClinicalNotesHome.class, local_ejbs);

				Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

				//contextUrl = contextUrl.substring(0,contextUrl.indexOf("servlet/"));
				String url = request.getRequestURL().toString();
				String uri = request.getRequestURI();
				String contextUrl = url.substring( 0, url.indexOf(uri) ) + request.getContextPath() + "/";
				webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
				converter.setXSLFileContextReference(contextUrl);
				try
				{
					boolean continueFlow = false;
					String conForSign = "N";//--[IN033487]
					//[IN033487] on 10/17/2012

					if(operation_mode.equals("Record") || operation_mode.equals("Sign"))
					{
						Connection l_con = ConnectionManager.getConnection(request);
						PreparedStatement l_pstmt = null;
						ResultSet l_rs=null;
						String note_count = "0";

						try
						{
								l_pstmt = l_con.prepareStatement("select count(*)total from ca_encntr_note where patient_id=? and encounter_id =? and NOTE_TYPE = ? and event_status !='9' "); //--[IN036165]
								l_pstmt.setString(1,patient_id);
								l_pstmt.setString(2,encounter_id);
								l_pstmt.setString(3,note_type);

								l_rs = l_pstmt.executeQuery();

								while(l_rs.next())
								{
									note_count = l_rs.getString("total");
									note_count = note_count==null?"0":note_count ; //new line on 10/17/2012
								}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						finally
						{
							if(l_pstmt!=null)
								l_pstmt.close();
							if(l_rs!=null)
								l_rs.close();
							if(l_con!=null)
								ConnectionManager.returnConnection(l_con,request);
						}

						String l_pat_key1 = patient_id+encounter_id+note_type+"SETUP";
						Connection l_con1 = ConnectionManager.getConnection(request);
						PreparedStatement l_pstmt1 = null;
						ResultSet l_rs1 = null;
						String note_count_setup = "0";

						try
						{
								l_pstmt1 = l_con1.prepareStatement("select NO_OF_REC_PER_ENC from ca_note_group where note_group =( select NOTE_GROUP_ID from ca_note_type where note_type = ?)");
								note_count_setup = "0";
								l_pstmt1.setString(1,note_type);
								l_rs1 = l_pstmt1.executeQuery();
								while(l_rs1.next())
								{
									note_count_setup = l_rs1.getString("NO_OF_REC_PER_ENC");
									note_count_setup = note_count_setup==null?"0":note_count_setup ;
								}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
						finally
						{
							if(l_pstmt1!=null)
								l_pstmt1.close();
							if(l_rs1!=null)
								l_rs1.close();
							if(l_con1!=null)
								ConnectionManager.returnConnection(l_con1,request);
						}
						//--[IN033487] - reopen Start
						if(operation_mode.equals("Sign") && (!accession_num.equals("")))
						{
							Connection l_con2 = ConnectionManager.getConnection(request);
							PreparedStatement l_pstmt2 = null;
							ResultSet l_rs2 = null;
							String l_stus = "0";
							try
							{
									l_pstmt2 = l_con2.prepareStatement("select EVENT_STATUS from ca_encntr_note where accession_num=?");
									l_pstmt2.setString(1,accession_num);
									l_rs2 = l_pstmt2.executeQuery();

									while(l_rs2.next())
									{
										l_stus = l_rs2.getString("EVENT_STATUS");
										l_stus = l_stus==null?"0":l_stus ; //new line on 10/17/2012
									}
									if(l_stus.equals("1"))
									{
										conForSign = "Y";
									}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							finally
							{
								if(l_pstmt2!=null)
									l_pstmt2.close();
								if(l_rs2!=null)
									l_rs2.close();
								if(l_con2!=null)
									ConnectionManager.returnConnection(l_con2,request);
							}
						}
						//--[IN033487] - reopen End
						//[IN037173] - Start
						if(operation_mode.equals("Record") && (!accession_num.equals("")))
						{
							Connection l_con3 = ConnectionManager.getConnection(request);
							PreparedStatement l_pstmt3 = null;
							ResultSet l_rs3 = null;
							String l_stus1 = "Y";
							conForSign = "Y";
							try
							{
									l_pstmt3 = l_con3.prepareStatement("select EXT_IMAGE_APPL_ID from ca_encntr_note where accession_num=?");
									l_pstmt3.setString(1,accession_num);
									l_rs3 = l_pstmt3.executeQuery();

									while(l_rs3.next())
									{
										//l_stus1 = l_rs3.getString("EXT_IMAGE_APPL_ID");//to handle null IN043263
										l_stus1 = l_rs3.getString("EXT_IMAGE_APPL_ID")==null?"":l_rs3.getString("EXT_IMAGE_APPL_ID");//IN043263
									}

									if(l_stus1.equals(""))
									{
										conForSign = "N";
									}
							}
							catch(Exception e)
							{
								e.printStackTrace();
							}
							finally
							{
								if(l_pstmt3!=null)
									l_pstmt3.close();
								if(l_rs3!=null)
									l_rs3.close();
								if(l_con3!=null)
									ConnectionManager.returnConnection(l_con3,request);
							}
						}
						//[IN037173] - End
						if(appl_task_id.equals("CLINICAL_NOTES"))
						{
							if(Integer.valueOf(note_count_setup) == 0)
							{
								continueFlow=true;
							}
							else
							{
								if((Integer.valueOf(note_count) < Integer.valueOf(note_count_setup)) || conForSign.equals("Y") )
								{
									continueFlow=true;
								}
							}
						}
						else
						{
							continueFlow=true;
						}


					}
					//--[IN033487], ends

					if((operation_mode.equals("Sign") || operation_mode.equals("SignOnModify")) && forwarded_clinician_ids_List.isEmpty() && forwarded_clinician_id.equals(""))
					{

						Object argArray[] = new Object[4];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						argArray[2] = clinicalNotesSectionBean;
						argArray[3] = converter;

						Class [] paramArray = new Class[4];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						paramArray[2] = clinicalNotesSectionBean.getClass();
						paramArray[3] = converter.getClass();

						if(operation_mode.equals("Sign"))
						{
							if(continueFlow)
							{
								results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
								if(htRecClinicalNotes != null) htRecClinicalNotes.clear();


							}
							else
							{
								results = new HashMap();
								results.put( "status" ,new Boolean("false"));
								results.put("error",(String)MessageManager.getMessage(locale,"MAX_NOTES_LIMIT","CA").get("message")) ;
								results.put("print_notes_yn","N") ;
								transactionResponse.setTransactionMessage("Maximum number of notes allowed for this note type is reached");
								transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
							}
						}
						else
						{
							results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
						}

						inserted = (((Boolean)results.get("status")).booleanValue());
						if(inserted){
							transactionResponse.setTransactionMessage("Note signed successfully");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
						}else{
							transactionResponse.setTransactionMessage("Error in recording/signing the note");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
						}

					}
					//forward note when user tries to sign and does not have access to sign
					else if((operation_mode.equals("Sign") || operation_mode.equals("SignOnModify")) && (!forwarded_clinician_ids_List.isEmpty() || !forwarded_clinician_id.equals("")))
					{
						if(forwarded_clinician_ids_List.size() > 0 && forward_mode.equals("P")){
							for(int x = 0;x<forwarded_clinician_ids_List.size();x++){
								forwarded_clinician_id = forwarded_clinician_ids_List.get(x);
								htRecClinicalNotes.put ( "forwarded_clinician_id",	forwarded_clinician_id		);
								Object argArray[] = new Object[4];
								argArray[0] = p;
								argArray[1] = htRecClinicalNotes;
								argArray[2] = clinicalNotesSectionBean;
								argArray[3] = converter;
		
								Class [] paramArray = new Class[4];
								paramArray[0] = p.getClass();
								paramArray[1] = htRecClinicalNotes.getClass();
								paramArray[2] = clinicalNotesSectionBean.getClass();
								paramArray[3] = converter.getClass();
		
								if(operation_mode.equals("Sign"))
								{
									if(continueFlow)
									{
										results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
										(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
										//if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
		
		
									}
									else
									{
										results = new HashMap();
										results.put( "status" ,new Boolean("false"));
										results.put("error",(String)MessageManager.getMessage(locale,"MAX_NOTES_LIMIT","CA").get("message")) ;
										results.put("print_notes_yn","N") ;
										transactionResponse.setTransactionMessage("Maximum number of notes allowed for this note type is reached");
										transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
									}
								}
								else
								{
									results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
									(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
									//if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
								}
		
								inserted = (((Boolean)results.get("status")).booleanValue());
								
								if(inserted){
									transactionResponse.setTransactionMessage("Note forwarded successfully");
									transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
									if(operation_mode.equals("Sign")){
										accession_num =  (String)results.get("accession_num"); //accession_num of the newly created note
										htRecClinicalNotes.put ("accession_num",accession_num); 
									}
									operation_mode = "SignOnModify";
									htRecClinicalNotes.put ( "operation_mode",operation_mode);
									//next forward will be SignOnModify since the new note was already created
								}else{
									transactionResponse.setTransactionMessage("Error in recording/signing the note");
									transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
								}
							}
						}
						else{

							Object argArray[] = new Object[4];
							argArray[0] = p;
							argArray[1] = htRecClinicalNotes;
							argArray[2] = clinicalNotesSectionBean;
							argArray[3] = converter;
		
							Class [] paramArray = new Class[4];
							paramArray[0] = p.getClass();
							paramArray[1] = htRecClinicalNotes.getClass();
							paramArray[2] = clinicalNotesSectionBean.getClass();
							paramArray[3] = converter.getClass();
		
							if(operation_mode.equals("Sign"))
							{
								if(continueFlow)
								{
									results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
									(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
									if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
		
		
								}
								else
								{
									results = new HashMap();
									results.put( "status" ,new Boolean("false"));
									results.put("error",(String)MessageManager.getMessage(locale,"MAX_NOTES_LIMIT","CA").get("message")) ;
									results.put("print_notes_yn","N") ;
									transactionResponse.setTransactionMessage("Maximum number of notes allowed for this note type is reached");
									transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
								}
							}
							else
							{
								results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
								if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
							}

							inserted = (((Boolean)results.get("status")).booleanValue());
							if(inserted){
								transactionResponse.setTransactionMessage("Note forwarded successfully");
								transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
							}else{
								transactionResponse.setTransactionMessage("Error in recording/signing the note");
								transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
							}
							
						}

					}
					else if( operation_mode.equals("Record") || operation_mode.equals("UpdateRecord") )
					{
						Object argArray[] = new Object[5];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						argArray[2] = clinicalNotesSectionBean;
						argArray[3] = converter;
						argArray[4] = strInsertFlag;

						Class [] paramArray = new Class[5];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						paramArray[2] = clinicalNotesSectionBean.getClass();
						paramArray[3] = converter.getClass();
						paramArray[4] = strInsertFlag.getClass();



						if(operation_mode.equals("Record"))
						{
							if(continueFlow)
							{
								results = (java.util.HashMap)(busObj.getClass().getMethod("recordRecClinicalNotes",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
								if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
							}
							else
							{
								results = new HashMap();
								results.put( "status" ,new Boolean("false"));
								results.put("error",(String)MessageManager.getMessage(locale,"MAX_NOTES_LIMIT","CA").get("message")) ;
								results.put("print_notes_yn","N") ;
							}
							inserted = (((Boolean)results.get("status")).booleanValue());
							accession_num =  (String)results.get("accession_num"); //accession_num of the newly created note
							if(inserted){
								transactionResponse.setTransactionMessage("Note recorded successfully");
								transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
								transactionResponse.setAccession_num(accession_num);
							}else{
								transactionResponse.setTransactionMessage("Error in recording the note");
								transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
							}
						}
						else
						{
							results = (java.util.HashMap)(busObj.getClass().getMethod("recordRecClinicalNotes",paramArray)).invoke(busObj,argArray);
							(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
							if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
							inserted = (((Boolean)results.get("status")).booleanValue());
							accession_num =  (String)results.get("accession_num");
							if(inserted){
								transactionResponse.setTransactionMessage("Note updated successfully");
								transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
								transactionResponse.setAccession_num(accession_num);
							}else{
								transactionResponse.setTransactionMessage("Error in updating the note");
								transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
							}
						}


					}
					else if(operation_mode.equals("Forward"))
					{

						if(forwarded_clinician_ids_List.size() > 0 && forward_mode.equals("P")){
							for(int x = 0;x<forwarded_clinician_ids_List.size();x++){
								forwarded_clinician_id = forwarded_clinician_ids_List.get(x);
								htRecClinicalNotes.put ( "forwarded_clinician_id",	forwarded_clinician_id		);
								StringBuffer sql = new StringBuffer();
								StringBuffer replaceString = new StringBuffer();

								PreparedStatement pstmt = null;
								ResultSet rs = null;

								sql.append("SELECT Count(*) FROM ca_encntr_note_audit_log Where action_status = 'RQ' And action_type in ('RV','RS','FS') "); //AND  ACTION_BY_ID = ?
								if(forward_mode.equals("S"))
								{
									sql.append(" AND  ACTION_BY_GROUP_CODE = ?");
								}
								else
									sql.append(" AND  ACTION_BY_ID = ?");

								sql.append(" AND facility_id	= ? AND accession_num = ? ");

								try
								{
									con = ConnectionManager.getConnection(request);

									pstmt = con.prepareStatement(sql.toString());

									pstmt.setString(1,forwarded_clinician_id);
									pstmt.setString(2,facility_id);
									pstmt.setString(3,accession_num);
									rs = pstmt.executeQuery();

									while(rs!=null && rs.next())
									{
										count = rs.getInt(1);
									}

									if(count > 0)
									{
										java.util.Hashtable err_data = MessageManager.getMessage(locale,"REVIEW_REC_ALREDY_EXISTS","CA");

										/*int index=0;
										error_msg= (String) err_data.get("message");
										replaceString = new StringBuffer(error_msg);

										if((index=replaceString.toString().indexOf("<br>"))!=-1)
										{
											replaceString=replaceString.replace(index,index+"<br>".length()," ");
										}

										out.println("<script language=\"javascript\">");
										out.println("alert('" + replaceString.toString() + "');");
										out.println("if(top.content!=undefined){");
										out.println("if(top.content.messageFrame){");
										out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");// Added by Ambiga.M for 18712 on 2/24/2010
										out.println("}}");
										out.println("</script>");
										//out.println("parent.window.close();");
		*/
									}
								}
								catch(Exception e)
								{
									System.out.println("Exceptionin getting connection : "+e);
									e.printStackTrace();
								}
								finally
								{
									if(pstmt!=null) pstmt.close();
									if(rs != null) rs.close();
									if(con!=null)  ConnectionManager.returnConnection(con,request);
								}

								if(count==0)
								{

									Object argArray[] = new Object[2];
									argArray[0] = p;
									argArray[1] = htRecClinicalNotes;
									Class [] paramArray = new Class[2];
									paramArray[0] = p.getClass();
									paramArray[1] = htRecClinicalNotes.getClass();
									results = (java.util.HashMap)(busObj.getClass().getMethod("forwardRecClinicalNotes",paramArray)).invoke(busObj,argArray);
									(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
									inserted = (((Boolean)results.get("status")).booleanValue());
									if(inserted){
										transactionResponse.setTransactionMessage("Note forwarded successfully");
										transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
									}else{
										transactionResponse.setTransactionMessage("Error in forwarding the note");
										transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
									}
									//if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
								}
								else
								{
										/*out.println("<script language=\"javascript\">");
										//out.println("alert('"+replaceString.toString()+"')");
										// Added by Ambiga.M for 18712 on 2/24/2010
										out.println("if(top.content!=undefined){");
										out.println("if(top.content.messageFrame){");
										out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");// Added by Ambiga.M for 18712 on 2/24/2010
										out.println("}}");
										// Added by Ambiga.M ends
										out.println("</script>");
										return;*/

									transactionResponse.setTransactionMessage("This note has already been forwarded to one or more selected recipients");
									transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_WARNING);
								}
							}

						}else{
							StringBuffer sql = new StringBuffer();
							StringBuffer replaceString = new StringBuffer();

							PreparedStatement pstmt = null;
							ResultSet rs = null;

							sql.append("SELECT Count(*) FROM ca_encntr_note_audit_log Where action_status = 'RQ' And action_type in ('RV','RS','FS') "); //AND  ACTION_BY_ID = ?
							if(forward_mode.equals("S"))
							{
								sql.append(" AND  ACTION_BY_GROUP_CODE = ?");
							}
							else
								sql.append(" AND  ACTION_BY_ID = ?");

							sql.append(" AND facility_id	= ? AND accession_num = ? ");

							try
							{
								con = ConnectionManager.getConnection(request);

								pstmt = con.prepareStatement(sql.toString());

								pstmt.setString(1,forwarded_clinician_id);
								pstmt.setString(2,facility_id);
								pstmt.setString(3,accession_num);
								rs = pstmt.executeQuery();

								while(rs!=null && rs.next())
								{
									count = rs.getInt(1);
								}

								if(count > 0)
								{
									java.util.Hashtable err_data = MessageManager.getMessage(locale,"REVIEW_REC_ALREDY_EXISTS","CA");
									transactionResponse.setTransactionMessage("This note has already been forwarded to the specialty");
									transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);

									/*int index=0;
									error_msg= (String) err_data.get("message");
									replaceString = new StringBuffer(error_msg);

									if((index=replaceString.toString().indexOf("<br>"))!=-1)
									{
										replaceString=replaceString.replace(index,index+"<br>".length()," ");
									}

									out.println("<script language=\"javascript\">");
									out.println("alert('" + replaceString.toString() + "');");
									out.println("if(top.content!=undefined){");
									out.println("if(top.content.messageFrame){");
									out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");// Added by Ambiga.M for 18712 on 2/24/2010
									out.println("}}");
									out.println("</script>");
									//out.println("parent.window.close();");
	*/
								}
							}
							catch(Exception e)
							{
								System.out.println("Exceptionin getting connection : "+e);
								e.printStackTrace();
							}
							finally
							{
								if(pstmt!=null) pstmt.close();
								if(rs != null) rs.close();
								if(con!=null)  ConnectionManager.returnConnection(con,request);
							}

							if(count==0)
							{

								Object argArray[] = new Object[2];
								argArray[0] = p;
								argArray[1] = htRecClinicalNotes;
								Class [] paramArray = new Class[2];
								paramArray[0] = p.getClass();
								paramArray[1] = htRecClinicalNotes.getClass();
								results = (java.util.HashMap)(busObj.getClass().getMethod("forwardRecClinicalNotes",paramArray)).invoke(busObj,argArray);
								(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
								if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
								inserted = (((Boolean)results.get("status")).booleanValue());
								if(inserted){
									transactionResponse.setTransactionMessage("Note forwarded successfully");
									transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
								}else{
									transactionResponse.setTransactionMessage("Error in forwarding the note");
									transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
								}
							}
							else
							{
									/*out.println("<script language=\"javascript\">");
									//out.println("alert('"+replaceString.toString()+"')");
									// Added by Ambiga.M for 18712 on 2/24/2010
									out.println("if(top.content!=undefined){");
									out.println("if(top.content.messageFrame){");
									out.println("top.content.messageFrame.location.href='../eCommon/jsp/error.jsp'");// Added by Ambiga.M for 18712 on 2/24/2010
									out.println("}}");
									// Added by Ambiga.M ends
									out.println("</script>");
									return;*/
							}
						}

					}

					else if(operation_mode.equals("Review"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("reviewRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					else if( operation_mode.equals("ModifySection") || operation_mode.equals("ModifyAddendum") )
					{
						Object argArray[] = new Object[4];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						argArray[2] = clinicalNotesSectionBean;
						argArray[3] = converter;
						Class [] paramArray = new Class[4];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						paramArray[2] = clinicalNotesSectionBean.getClass();
						paramArray[3] = converter.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("modifyRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
						inserted = (((Boolean)results.get("status")).booleanValue());
						if(inserted){
							transactionResponse.setTransactionMessage("Note modified successfully");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
						}else{
							transactionResponse.setTransactionMessage("Invalid section template. Contact administrator for support");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
						}
					}
					else if(operation_mode.equals("Delete"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("deleteRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
						inserted = (((Boolean)results.get("status")).booleanValue());
						if(inserted){
							transactionResponse.setTransactionMessage("Note deleted successfully");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
						}else{
							transactionResponse.setTransactionMessage("Error in deleting the note");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
						}
					}
					else if(operation_mode.equals("MakeAsError"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;

						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("errorRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
						inserted = (((Boolean)results.get("status")).booleanValue());
						if(inserted){
							transactionResponse.setTransactionMessage("Note marked In Error successfully");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_SUCCESS);
						}else{
							transactionResponse.setTransactionMessage("Mark In Error could not be done");
							transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
						}
					}
					/*
					else if(operation_mode.equals("SignOnModify"))
					{
						Object argArray[] = new Object[2];
						argArray[0] = p;
						argArray[1] = htRecClinicalNotes;
						Class [] paramArray = new Class[2];
						paramArray[0] = p.getClass();
						paramArray[1] = htRecClinicalNotes.getClass();
						results = (java.util.HashMap)(busObj.getClass().getMethod("signOnModifyRecClinicalNotes",paramArray)).invoke(busObj,argArray);
						(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
						if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
					}
					*/
					/*error_msg		= "";
					inserted		=	( ((Boolean) results.get( "status" )).booleanValue() );
					accession_num	=	(String)	results.get("accession_num");
					error_msg		=	(String)	results.get("error") ;
					print_notes_yn		=	(String)	results.get("print_notes_yn") ;

					results.clear();*/
					//AAKH-SCF-0125.1 [IN:054894]  Start.
					/*if(inserted)
					{*/
						/*out.println("<script language=\"javascript\">");
						out.println("var xmlDoc		= new ActiveXObject( \"Microsoft.XMLDom\" ) ;");
						out.println("var xmlHttp		= new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;");
						out.println("xmlStr	=\"<root><SEARCH \" ;");
						out.println("xmlStr += \" accession_num='"+accession_num+"'\";");
						out.println("xmlStr +=\" /></root>\" ;");
						out.println("xmlDoc.loadXML( xmlStr ) ;");
						out.println("xmlHttp.open( \"POST\",\"../eCA/jsp/RecClinicalNotesReBuildIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"\", false ) ;");
						out.println("xmlHttp.send(xmlDoc);");
						out.println("</script>");*/
					//}
					//AAKH-SCF-0125.1 [IN:054894]  End.


				}
				catch(Exception e)
				{
					//out.println("Exception@recordingEJB : "+e);
					System.err.println("Exception@recordingEJB : "+e);
					//out.println("Trancation Could not be Completed,Plese Try again.");
					e.printStackTrace();
					transactionResponse.setTransactionMessage("Problem occured while connecting to the server");
					transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
					//AAKH-SCF-0125.1 [IN:054894]  Start.
					/*if(!"".equals(accession_num))
					{
						out.println("<script language=\"javascript\">");
						out.println("var xmlDoc		= new ActiveXObject( \"Microsoft.XMLDom\" ) ;");
						out.println("var xmlHttp		= new ActiveXObject( \"Microsoft.XMLHTTP\" ) ;");
						out.println("xmlStr	=\"<root><SEARCH \" ;");
						out.println("xmlStr += \" accession_num='"+accession_num+"'\";");
						out.println("xmlStr +=\" /></root>\" ;");
						out.println("xmlDoc.loadXML( xmlStr ) ;");
						out.println("xmlHttp.open( \"POST\",\"../eCA/jsp/RecClinicalNotesReBuildIntermediate.jsp?patient_id="+patient_id+"&encounter_id="+encounter_id+"\", false ) ;");
						out.println("xmlHttp.send(xmlDoc);");
						out.println("</script>");
					}*/
					//AAKH-SCF-0125.1 [IN:054894]  End.
				}

			}
			catch(Exception e)
			{
				e.printStackTrace();
				System.out.println("Exception while accessing RecClinicalNotes EJB for Inseting Records!"+e);
				transactionResponse.setTransactionMessage("Problem occured while connecting to the server");
				transactionResponse.setTransactionResult(transactionResponse.TRANSACTION_RESULT_FAILURE);
			}

			jsonFieldResponse = gson.toJson(transactionResponse);

			response.setContentType("application/json");
			response.getWriter().write(jsonFieldResponse);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
	}
}
