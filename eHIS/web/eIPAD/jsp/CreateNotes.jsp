<%@page import="java.util.*,java.sql.*,java.io.*,eIPAD.*,eIPAD.HealthObjects.*, eCA.ChartRecording.*,javax.servlet.http.*,eCA.RecClinicalNotes.*,javax.rmi.*,webbeans.eCommon.MessageManager,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<% 
request.setCharacterEncoding("UTF-8");
webbeans.eCA.RecClinicalNotesSectionBean sectionBean = (webbeans.eCA.RecClinicalNotesSectionBean)getObjectFromBean("sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
String locale = "en";
String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String strPracType = "";
String strPostBack = "false";
String strInterval = "";
String strPatientId = "";
String strEncounterId = "";
String strChartType = "";

List<String> oTransResultList = null;
CreateNotesRequest oCreateNotesReq = new CreateNotesRequest();
oCreateNotesReq.setRequest(request);

String normalInd = "";
String strPatientClass = "";
String strFilterBy = "P";
String strNoteType = "";
String accessNum = "";
String service_name	=	"";
String service_code	=	"";
String discharge_date_time		=	"";
String attending_practitioner	=	"";
String visit_adm_date	=	"";
String strCurrentDatetime = DateUtils.getCurrentDate("DMYHM", locale);
String notes_section_content = "";
String strErrorMsg = "";

int nTanlstCnt =0;
if(session.getValue("facility_id") != null )
{
	oCreateNotesReq.setFacilityId((String)session.getValue("facility_id"));
	facility_id = oCreateNotesReq.getFacilityId();
}
if(session.getValue("ca_practitioner_id") != null)
{
	oCreateNotesReq.setClinicianId((String)session.getValue("ca_practitioner_id"));
}
if(session.getValue("practitioner_type") != null )
{
	oCreateNotesReq.setPracType((String)session.getValue("practitioner_type"));
}
if(session.getValue("PatientID") != null)
{
	oCreateNotesReq.setPatientId((String)session.getValue("PatientID"));
	strPatientId = oCreateNotesReq.getPatientId();
}
if(session.getValue("EpisodeId") != null )
{
	oCreateNotesReq.setEncounterId((String)session.getValue("EpisodeId"));
	strEncounterId = oCreateNotesReq.getEncounterId();
}

if(session.getValue("responsibility_id") != null)
{
	oCreateNotesReq.setRespId((String)session.getValue("responsibility_id"));
}
oCreateNotesReq.setApplTaskID("CLINICAL_NOTES");
if(request.getParameter("patclass") != null )
{
	strPatientClass = request.getParameter("patclass");
	
}
if(request.getParameter("fromfunc") != null)
{
	if(request.getParameter("accessionNum") != null)
	{
		accessNum = request.getParameter("accessionNum");
	}
	
	if(request.getParameter("note_type") != null)
	{
		strNoteType = request.getParameter("note_type");
	}

}
if(request.getParameter("hdnPostBack") != null)
{
	strPostBack = request.getParameter("hdnPostBack");
}
if(request.getParameter("hdnFilterBy") != null)
{
strFilterBy = request.getParameter("hdnFilterBy");
}
if(strPostBack != null && strPostBack.equals("true"))
{
	strPatientClass = request.getParameter("patient_class");
	
	strNoteType = request.getParameter("note_type");
	if(request.getParameter("hdnRecord") != null && request.getParameter("hdnRecord").equals("true") )
	{
		String strNotescontent = request.getParameter("note_content");
		String SecHdgCode = request.getParameter("SecHdgCode");
		String childSecHdgCode = request.getParameter("childSecHdgCode");
		String strKey = "";
		strKey = strPatientId + "~" + strEncounterId;
		sectionBean.removePatientSection(strKey);	
		sectionBean.startPatientSection(strKey);	
		//putObjectInBean("sectionBean",sectionBean,session);
		//sectionBean.setSectionValues(SecHdgCode,childSecHdgCode,"F",doc_linked_yn,result_link_yn,image_linked_yn,chief_complaint_sec_yn,result_link_type, image_edited_yn,edited_yn, section_content, image_content,output_form_exists_yn);
		sectionBean.setSectionValues(SecHdgCode,childSecHdgCode,"F","","N","N","Y","","N","N", "", "","");
		if(strNotescontent != null && !strNotescontent.equals("") && SecHdgCode != null && !SecHdgCode.equals("") && childSecHdgCode != null && !childSecHdgCode.equals(""))
		{
			boolean bSeccontent = false;
			bSeccontent = sectionBean.setSectionContent ( SecHdgCode,childSecHdgCode,strNotescontent);
			putObjectInBean("sectionBean",sectionBean,session);
			//webbeans.eCA.RecClinicalNotesSectionBean clinicalNotesSectionBean = null;
			//clinicalNotesSectionBean=(webbeans.eCA.RecClinicalNotesSectionBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( "sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);
			/*
			if(clinicalNotesSectionBean != null)
			{
				notes_section_content	=	(java.lang.String) clinicalNotesSectionBean.getSectionContent ( SecHdgCode,childSecHdgCode );
				String test = "";
			}
		   */
		}
		//PrintWriter out1;
		//out1 = response.getWriter();
		//oTransResultList = recordRecClinicalNotes(request,out1);
		oTransResultList = recordRecClinicalNotes(request);
		if(oTransResultList != null)
		{
			nTanlstCnt = oTransResultList.size();
			int nCnt = 0;
			for(nCnt =0 ; nCnt < nTanlstCnt ; nCnt ++)
			{
				if(nCnt == 0)
				{
					accessNum =  oTransResultList.get(nCnt);
					//break;
				}
				if(nCnt == 1)
				{
					strErrorMsg = oTransResultList.get(nCnt);
				}
			}
		}
		
		
	}
}
oCreateNotesReq.setFilterBy(strFilterBy);
oCreateNotesReq.setPatientClass(strPatientClass);
oCreateNotesReq.setNoteType(strNoteType);

Connection con = null;
PreparedStatement		ptPatLine			= null;
ResultSet				stPatLine			= null;

String strDetailsQry	= "select  to_char( VISIT_ADM_DATE_TIME,'dd/mm/yyyy hh24:mi') visit_adm_date,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(A.FACILITY_ID,?,'1') facility_name, AM_GET_DESC.AM_SERVICE(A.SERVICE_CODE,?,'2') service_name,AM_GET_DESC.AM_PRACTITIONER(A.ATTEND_PRACTITIONER_ID,?,1)  attending_practitioner,service_code from    pr_encounter a where   facility_id = ? and     encounter_id = ?";
try
{
	con				=	ConnectionManager.getConnection(request);
	if(con != null)
	{
		ptPatLine	=	con.prepareStatement(strDetailsQry);
	   if( ptPatLine != null)
	   {
			ptPatLine.setString	(	1,	locale	);
			ptPatLine.setString	(	2,	locale	);
			ptPatLine.setString	(	3,	locale	);
			ptPatLine.setString	(	4,	facility_id	);
			ptPatLine.setString	(	5,	strEncounterId);
		
			stPatLine		=	ptPatLine.executeQuery();
		
			if(stPatLine != null && stPatLine.next())
			{
				service_name				=	stPatLine.getString("service_name");
				service_code				=	stPatLine.getString("service_code");
				discharge_date_time				=	stPatLine.getString("DISCHARGE_DATE_TIME");
				attending_practitioner		=	stPatLine.getString("attending_practitioner");
				//speciality_name		=	stPatLine.getString("speciality_name");
				visit_adm_date		=	stPatLine.getString("visit_adm_date");
			}
	   }
	   if (stPatLine !=null) stPatLine.close();
		if (ptPatLine!=null) ptPatLine.close();
	    if (con !=null) ConnectionManager.returnConnection(con,request);
	}
}
catch(Exception e){
	e.printStackTrace();
	
}
finally{
    if (stPatLine !=null) stPatLine.close();
	if (ptPatLine!=null) ptPatLine.close();
    if (con !=null) ConnectionManager.returnConnection(con,request);
}
%>
<%!
private String checkForNull(String inputString)
{
	return (inputString==null)	?	""	:	inputString;
}

private String checkForNull(String inputString, String defaultValue)
{
	return (inputString==null)	?	defaultValue	:	inputString;
}
private List<String> recordRecClinicalNotes(HttpServletRequest request) 
{
	HttpSession				session	=	null;
	java.util.Properties	p		=	null;

	Connection				con			=	null;

	webbeans.eCA.RecClinicalNotesSectionBean clinicalNotesSectionBean = null;

	eCA.PatientBannerGroupLine manageEmailBean = null;
	
	List<String> oTransResultList = new ArrayList<String>();

	HashMap htRecClinicalNotes					=	new java.util.HashMap();
	String		clinician_id					=	"",		clinician_name				=	"";
	String		facility_id						=	"",		accession_num				=	"";
	String		patient_id						=	"",		episode_type				=	"";
	String		encounter_id					=	"",		patient_class				=	"";
	String		event_type_caption				=	"",		note_type					=	"";
	String		service_code					=	"",		event_class					=	"";
	String		note_type_security_level		=	"",		event_date_caption			=	"";
	String		event_date_time					=	"",		event_perf_by_caption		=	"";
	String		performed_by_id					=	"",		event_title_caption			=	"";
	String		event_title_desc				=	"",		note_content				=	"";
	String		event_auth_by_caption			=	"",		authorized_by_id			=	"";
	String		authorized_date_time			=	"",		event_status_caption		=	"";
	String		event_status					=	"",		login_user_id				=	"";
	String		encntr_date						=	"",		amendment_type				=	"";
	String		forwarded_clinician_id			=	"",		resp_name					=	"";
	String		serv_facl_spec_yn				=	"",		privilege_type				=	"";
	String		note_type_desc					=	"",		operation_mode				=	"";
	String		login_at_ws_no					=	"",		action_comment				=	"";
	String		function_id						=	"",		resp_id						=	"";
	String		window_close					=	"";
	String		contr_mod_accession_num			=	"";
	String		doc_linked_note_yn				=	"";
	String		strInsertFlag					=	"N";
	String		locale							=	"";
	//shaiju
	String		forward_mode				= "";
	String		module_id					= "";
	String		appl_task_id				= "";
	String		selection_type				= "";
	HashMap     multiHash					= null;
	String     called_from					= "";
	String 		record_mode					= "";	//[IN033677]
	String		srl_no						= "";   //[IN033677]

	String print_notes_yn = "";
	String error_msg = "";

	int count = 0;
	try
    {
		session							=	request.getSession(false);
		

		clinicalNotesSectionBean=(webbeans.eCA.RecClinicalNotesSectionBean)com.ehis.persist.PersistenceHelper.getObjectFromBean( "sectionBean","webbeans.eCA.RecClinicalNotesSectionBean",session);

		p							=	(Properties)	session.getValue("jdbc") ;
		locale						=	(String)		p.getProperty("LOCALE");

		login_user_id				=	(String)		session.getValue("login_user");
		facility_id					=	(String)		session.getValue("facility_id");
		resp_name					=	(String)		session.getValue("resp_name");
		clinician_id				=	(String)		session.getValue("ca_practitioner_id");
		clinician_name				=	(String)		session.getValue("practitioner_name");
		resp_id						=	(String)		session.getValue("responsibility_id");

		login_at_ws_no				=	checkForNull( p.getProperty("client_ip_address"));
		operation_mode				=	checkForNull( request.getParameter("operation_mode")		);
		accession_num				=	checkForNull( request.getParameter("accession_num")			);
		amendment_type				=	checkForNull( request.getParameter("amendment_type")		);

		forwarded_clinician_id		=	checkForNull( request.getParameter("forwarded_clinician_id"));
		action_comment				=	checkForNull( request.getParameter("action_comment")		);
		action_comment				=   java.net.URLDecoder.decode(action_comment);
		//performed_by_id				=	checkForNull( request.getParameter("performed_by_id")		);
		performed_by_id =  clinician_id;

		privilege_type				=	checkForNull( request.getParameter("privilege_type")		);

		function_id					=	checkForNull( request.getParameter("function_id")			);

		String field_ref			=	checkForNull( request.getParameter("Field_Ref")	);
		window_close				=	checkForNull( request.getParameter("window_close")			);
		contr_mod_accession_num		=	checkForNull( request.getParameter("contr_mod_accession_num")	);
		doc_linked_note_yn			=	checkForNull( request.getParameter("doc_linked_note_yn"),"N");

		//Shaiju
		forward_mode			=	checkForNull( request.getParameter("forward_mode"));
		//Shaiju

		module_id				=	checkForNull( request.getParameter("module_id"));

		appl_task_id			=	checkForNull( request.getParameter("appl_task_id"));

		called_from			=	checkForNull( request.getParameter("called_from"));

		record_mode					=	checkForNull( request.getParameter("record_mode")		);   //[IN033677]
		srl_no						=	checkForNull( request.getParameter("srl_no")			);   //[IN033677]
				
		if( operation_mode.equals("Record") || operation_mode.equals("Sign") || operation_mode.equals("ModifySection") || operation_mode.equals("UpdateRecord") ||  operation_mode.equals("ModifyAddendum") || operation_mode.equals("SignOnModify") )
		{
			serv_facl_spec_yn			=	checkForNull( request.getParameter("serv_facl_spec_yn")			);
			note_type_desc				=	checkForNull( request.getParameter("note_type_desc")			);
			patient_id					=	checkForNull( request.getParameter("patient_id")				);
			episode_type				=	checkForNull( request.getParameter("episode_type"),"I"				);
			encounter_id				=	checkForNull( request.getParameter("encounter_id")				);
			patient_class				=	checkForNull( request.getParameter("patient_class")				);
			event_type_caption			=	checkForNull( request.getParameter("event_type_caption"),"Note Type"		);
			note_type					=	checkForNull( request.getParameter("note_type")					);
			service_code				=	checkForNull( request.getParameter("service_code")				);
			event_class					=	checkForNull( request.getParameter("event_class"),"CLI$"				);
			note_type_security_level	=	checkForNull( request.getParameter("note_type_security_level")	);
			event_date_caption			=	checkForNull( request.getParameter("event_date_caption"	),"Date/Time"		);
			event_date_time				=	checkForNull( request.getParameter("event_date_time")			);
			event_perf_by_caption		=	checkForNull( request.getParameter("event_perf_by_caption")		);
			event_title_caption			=	checkForNull( request.getParameter("event_title_caption")		);
			event_title_desc			=	checkForNull( request.getParameter("event_title_desc")			);
			note_content				=	checkForNull( request.getParameter("note_content")				);
			event_auth_by_caption		=	checkForNull( request.getParameter("event_auth_by_caption")		);
			authorized_by_id			=	checkForNull( request.getParameter("authorized_by_id")			);

			authorized_date_time		=	checkForNull( request.getParameter("authorized_date_time")		);
			event_status_caption		=	checkForNull( request.getParameter("event_status_caption")		);
			event_status				=	checkForNull( request.getParameter("event_status"),"1"			);

			if (event_status.equals(""))
				event_status="j";

			event_date_time				=	com.ehis.util.DateUtils.convertDate(event_date_time,"DMYHM",locale,"en");
			encntr_date					=	checkForNull( request.getParameter("visit_adm_date")			);

			appl_task_id			=	checkForNull( request.getParameter("appl_task_id"),"CLINICAL_NOTES");
			selection_type			=	checkForNull( request.getParameter("selection_type"));

			//shaiju st
			manageEmailBean = (eCA.PatientBannerGroupLine)com.ehis.persist.PersistenceHelper.getObjectFromBean("manageEmailBean"+patient_id+encounter_id,"eCA.PatientBannerGroupLine",session);
             
			//list = manageEmailBean.returnSortList();
			multiHash = manageEmailBean.returnHashMap();
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
			htRecClinicalNotes.put ( "multiHash",				multiHash						);
			htRecClinicalNotes.put ( "function_id",				function_id						);
			htRecClinicalNotes.put ( "record_mode",				record_mode					);  
			htRecClinicalNotes.put ( "srl_no",					srl_no					);  
					
			java.util.HashMap results = null;
			boolean inserted = false;
		//	String error_msg = "";
			boolean local_ejbs = false;

			if ((getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS") !=null) && (getServletConfig().getServletContext().getInitParameter("LOCAL_EJBS").equalsIgnoreCase("TRUE")))
				local_ejbs = true;

			Object home = com.ehis.eslp.ServiceLocator.getInstance().getHome("java:comp/env/RecClinicalNotes", RecClinicalNotesHome.class, local_ejbs);

			Object busObj = (home.getClass().getMethod("create",null)).invoke(home,null);

			String contextUrl = HttpUtils.getRequestURL(request).toString();
			//contextUrl = contextUrl.substring(0,contextUrl.indexOf("servlet/"));
			webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
			converter.setXSLFileContextReference(contextUrl);
			
			if(operation_mode.equals("Sign") || operation_mode.equals("SignOnModify") )
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

				results = (java.util.HashMap)(busObj.getClass().getMethod("signRecClinicalNotes",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);

				if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
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
				results = (java.util.HashMap)(busObj.getClass().getMethod("recordRecClinicalNotes",paramArray)).invoke(busObj,argArray);
				(busObj.getClass().getMethod("remove",null)).invoke(busObj,null);
				if(htRecClinicalNotes != null) htRecClinicalNotes.clear();
			}
					
			error_msg		= "";
			inserted		=	( ((Boolean) results.get( "status" )).booleanValue() );
			accession_num	=	(String)	results.get("accession_num");
		//	accessNum = accession_num;
			error_msg		=	(String)	results.get("error") ;
			print_notes_yn		=	(String)	results.get("print_notes_yn") ;

			results.clear();		
		
			oTransResultList.add(accession_num);
			//oTransResultList.add(error_msg);

    }
	catch(Exception e)
	{
	
		e.printStackTrace(System.err);
		//out.println("Exception in recClinical Notes" +e.toString());
		error_msg = e.toString();
		
	}
	finally
	{
		oTransResultList.add(error_msg);
	}
	return oTransResultList;
}
%>
<!DOCTYPE html> 
<html> 
<head> 
<title>jQuery Mobile Application</title> 
<meta name="apple-mobile-web-app-capable" content="yes" />
<link rel="stylesheet" href="../jquery.mobile-1.0a4.1.min.css" />  
<script src="../jquery-1.5.2.min.js"></script>  
<script src="../jquery.mobile-1.0a4.1.min.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


  
<link rel="stylesheet" href="../css/iPadCreateNotes.css" />
<script>
function Loading()
{
	window.parent.hideLoading();
	 var dvheight = $("#dvNotesMenu").height() + "px";
	 $("#notesContentFrame").css('height', dvheight);
	 /*
	 var RTEditor0 = document.getElementById("notesContentFrame");
	 
	 var html = "";
	 html +="<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>";
	 html +="<body onKeyDown='' style=\"font:10pt arial\">";
	    html +="</body>";
	    RTEditor0.document.open();
	    RTEditor0.document.write(html);
	    RTEditor0.document.close();
	    RTEditor0.document.designMode = "ON";
	    RTEditor0.document.body.contentEditable = "True";
	    */
	 var errorMsg = document.getElementById("errorMsg").value;
	 if(errorMsg != null && errorMsg != "" && errorMsg != "null")
		 {
		   alert(errorMsg);
		 }
	if(document.getElementById("hdnPostBack").value == "true")
		{
		  document.getElementById("cmbFilterBy").value = document.getElementById("hdnFilterBy").value;
		//  document.getElementById("cmbNoteType").value = document.getElementById("note_type").value;
		}
	    var notetype = document.getElementById("note_type").value;
	    var filterBy = document.getElementById("hdnFilterBy").value;
	    if(filterBy != null && filterBy != "")
	    {
	    	document.getElementById("cmbFilterBy").value = filterBy;
	    }
	    if(notetype != null && notetype != "")
	    {
	    	
	    	
	    document.getElementById("cmbNoteType").value = notetype
        }
	    
}
function setNotesContent(txtnotesContent,dvNotesContent,oppMode)
{
	var txtContent = "";
	var dvContent = "";
	var notesContent = "";
	//alert(oppMode);
	//alert(txtnotesContent);
	//alert(dvNotesContent);
	document.getElementById("operation_mode").value = oppMode;
	//var operationmode = document.getElementById("operation_mode").value;
	
	if(txtnotesContent != null && txtnotesContent != "")
	{
		txtContent = "<ADDRESS>" +txtnotesContent + "</ADDRESS>";
	}
	if(dvNotesContent != null )
	{
		dvContent = dvNotesContent;
	}
	if(oppMode == "Record")
	{
		notesContent = txtContent;
		//notesContent = dvContent + txtContent;
	}
	else
	{
		notesContent = dvContent + txtContent;
	}
	//notesContent = "<ADDRESS>GOOD</ADDRESS>";
	document.getElementById("note_content").value = notesContent;
		
    
}
function changeOrientation(orient)
{
	//	alert(orient);
	if(orient == "landscape")
	   {
	     //document.getElementById("dvmain").style.height = "auto";
	    // $("#dvmain").css('min-height','381px');
		 $("#dvNotesMenu").css('min-height','381px');
		    
		    var dvheight = $("#dvNotesMenu").height() + "px";
			//document.getElementById("notesContentFrame").style.height = $("#dvNotesMenu").height() ;
			//alert(document.getElementById("notesContentFrame").style.height);
			//alert($("#dvNotesMenu").height());
		    $("#notesContentFrame").css('height', dvheight);
		    document.getElementById("notesContentFrame").contentWindow.changeOrientation(orient,dvheight);
	    
	   }
     else
	   {
	   //  document.getElementById("dvmain").style.height = "auto";
	    // $("#dvmain").css('min-height','765px');
    	 $("#dvNotesMenu").css('min-height','677px');
    	 var dvheight = $("#dvNotesMenu").height() + "px";
    	 $("#notesContentFrame").css('height', dvheight);
    	 document.getElementById("notesContentFrame").contentWindow.changeOrientation(orient,dvheight);
	   }
 
}
function LoadSection()
{
	document.getElementById("hdnFilterBy").value = document.getElementById("cmbFilterBy").value;
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("note_type").value = document.getElementById("cmbNoteType").value;
	document.getElementById("frmCreateNotes").submit();
}
function LoadNoteType1(objCombo)
{
	//alert(objCombo.value);
	var xmlHttp = getHttpObject();
	xmlHttp.onreadystatechange=function(){
		//alert(xmlHttp.readyState+' '+xmlHttp.status);
		if(xmlHttp.readyState==4 && xmlHttp.status==200){
			//alert(xmlHttp.responseText);
			var resText = xmlHttp.responseText;
			
			document.getElementById("cmbNoteType").innerHTML= '<option value = "">Select</option>' + resText;
		}
	}

	xmlHttp.open("POST", "NoteType.jsp", true);
	xmlHttp.setRequestHeader("Content-type","application/x-www-form-urlencoded");
	//var sendString = "selectedperiod="+selectedPeriod+"&patientclass="+selectedPatientClass+"&encounter_id="+selectedEncounterId+"&patientid="+patientId+"&facility_id="+facilityId;
	//sendString += "&episode_type=B"+"&hist_type=&event_class=&event_group=&event_item=&event_date=&abnormal=&normalcy=&viewconfres=E&performed_by=&errorEvent=&episode_wise=N&view_by=E&graphorder=desc&show_mode=C&relationship_id=";
	var sendString = "FilterBy=" + objCombo.value;
	xmlHttp.send(sendString);
	
}
function LoadNoteType(objCombo)
{
	document.getElementById("hdnFilterBy").value = objCombo.value;
	document.getElementById("hdnPostBack").value = "true";
	document.getElementById("note_type").value = "";
	document.getElementById("frmCreateNotes").submit();
}
function getHttpObject(){
	var xmlHttp;
	if (window.XMLHttpRequest) {
		xmlHttp = new XMLHttpRequest();
	} else if (window.ActiveXObject) {
		xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
	}
	return xmlHttp;
}
function showRecentNotes(obj)
{
	obj.style.border = "3px solid #48d1d8";
	 window.parent.showRecNotes();
}
function showNotes(noteHeading,SecHdgCode,childSecHdgCode,accessnum)
{
	//alert(SecHdgCode);
	//alert(childSecHdgCode);
	document.getElementById("SecHdgCode").value = SecHdgCode;
	document.getElementById("childSecHdgCode").value = childSecHdgCode;
	var height = $("#dvNotesMenu").height() + "px";
	var url = "?notesHeading=" +noteHeading +"&height=" +height +"&secCode=" + SecHdgCode+"&secChildCode=" +childSecHdgCode+"&accessnum=" +accessnum ;
	document.getElementById("notesContentFrame").src = "NotesContent.jsp" + url;
}
function loadWidgets()
{
	window.parent.showLoadingMsg();
}
function RecordNotes()
{
	/*
	var accessnum = document.getElementById("accession_num").value;
	if(accessnum != null && accessnum != "")
	{
		document.getElementById("operation_mode").value = "UpdateRecord";	
	}
	else
	{
		document.getElementById("operation_mode").value = "Record";	
	}
	*/
	if(document.getElementById("notesContentFrame") != null && document.getElementById("notesContentFrame").contentWindow != null)
	{
		
		document.getElementById("notesContentFrame").contentWindow.getNotescontent(); //to get and set the notes content
		document.getElementById("hdnRecord").value = "true";
		document.getElementById("hdnPostBack").value = "true";
		document.getElementById("frmCreateNotes").submit();
	}
}
</script>
</head>

<body onload = "Loading()">
	<section data-role = "page" style = "padding:0px">
		 <form name = "frmCreateNotes" id = "frmCreateNotes" method = "post">
			 <div data-role = "none" class ='divmain' id = 'dvmain'  style="padding:0px" >
				  <div data-role = "none" class = "dvViewNotes">
				     <table style="width:100%;height:100%" border = "0" cellpadding = "0" cellspacing = "0">
				       <tr style="width:100%;height:100%">
				         <td style = "width : 95%" align = "left" valign = "center">
				            <span class = "spanCreateNotes">Create Notes</span>
				         </td> 
				          <td style="width:5%" onclick = "loadWidgets()" align = "center" valign = "middle">
				           <img src = "../images/Close.png"></img>
				         </td>
				       </tr>
				     </table>
				  </div>
				  <div id = "dvCriteria" class = "dvCriteria">
				      <table style="height:68px;width:100%" border = "0" cellpadding = "0" cellspacing = "0">
							     <tr style="height:30px;width:100%">
								      <td align = "left" style="width:34%"><span class = "spanFilterBy">Filter By</span></td>
								      <td align = "left" style="width:33%">
								             <span class = "spanFilterBy">Note Type</span>
								      </td>
								       <td align = "left" style="width:33%">
								       </td>
							     </tr>
							     <tr style="height:35px;width:100%">
								      <td align = "left" style="width:34%">
									        <select  class="cmbFilterBy" data-role="none" id="cmbFilterBy" name = "cmbFilterBy" onchange = "LoadNoteType(this)"> 
									          <option value = "P">Practitioner</option> 
									          <option value = "S">Speciality</option> 
									          <option value = "R">Responsibility</option> 
								            </select> 
								      </td>
							      <td align = "left" style="width:33%" valign = "middle">
							              <select  class="cmbFilterBy" data-role="none" id="cmbNoteType" name = "cmbNoteType" onchange = "LoadSection()" > 
							              <option value = "">Select</option>
							              <% 
							              NoteTypeResponse oNoteTypeResponse = null;
							              List<NoteTypeHO> oNoteTypeList = null;
							              NoteTypeHO oNoteTypeHO = null;
							              NotesDetail bean = new NotesDetail();
							              int nLoopCount = 0;
							              int nListSize = 0;
							              try {
								            	  oNoteTypeResponse = bean.getNoteType(oCreateNotesReq);
									              if(oNoteTypeResponse != null && oNoteTypeResponse.getLstNoteType() != null)
									              {
									            	  oNoteTypeList = oNoteTypeResponse.getLstNoteType();
									            	  if(oNoteTypeList != null)
									            	  {
									            		  nListSize = oNoteTypeList.size();
									            	  }
									            	  if(nListSize > 0)
									            	  {
									            		  for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
									            		  {
									            			  oNoteTypeHO = oNoteTypeList.get(nLoopCount);
									            			  if(oNoteTypeHO != null)
									            			  {
									            				  %>
									            				   <option value = "<%=oNoteTypeHO.getNoteType()%>"><%=oNoteTypeHO.getNoteTypeDesc()%></option>
									            				  <% 
									            			  }
									            		  }
									            	  }
									              }
							               }
							              catch ( Exception e ){
												out.println("Exception " + e);
												//out.println(sqlStr.toString());
												e.printStackTrace();
											}
							              %>
								           </select> 
							      </td>
							        <td align = "center" style="width:33%">
							         <input type ="button" name='search_btn' id='search_btn' value='Recent Clinical Notes' class="btnType1"  data-role = "none"  onclick = "showRecentNotes(this)"/>
							       </td>
							     </tr>
							     <tr style="height:3px;width:100%">
							       <td>&nbsp;</td>
							     </tr>
						   </table>
				  </div>
				  <div id = "dvNotesMenu" class = "dvNotesMenu">
				      <table style = "width:100%;height:auto" border = "0" cellspacing  = "0" cellpadding = "0">
				        <tr class = "trNotesViewMenu">
				          <td class = "tdNotesViewMenu">
				               <span class = "spanCreateNotesView">Notes View</span>
				          </td>
				        </tr>
				         <%
				         if((strPostBack != null && strPostBack.equals("true") && strNoteType != null && !strNoteType.equals("")) || (strNoteType != null && !strNoteType.equals("") && accessNum != null && !accessNum.equals("")))
				         {
				        	 NoteSectionResponse oNoteSectionResponse = null;
				             List<NoteSectionHO> oNoteSecList = null;
				             NoteSectionHO oNoteSecHO = null;
				             NotesDetail oNoteDetail = new NotesDetail();
				            
				             int nLoopCount1 = 0;
				             int nListSize1 = 0;
				             try {
				            	 oNoteSectionResponse = oNoteDetail.getNoteSection(oCreateNotesReq);
				            	 if(oNoteSectionResponse != null && oNoteSectionResponse.getLstNoteSection() != null)
				            	 {
				            		 oNoteSecList = oNoteSectionResponse.getLstNoteSection();
				            	 }
				            	 if( oNoteSecList != null)
				            	 {
				            		 nListSize1 = oNoteSecList.size();
				            	 }
				            	 if(nListSize1 > 0)
				            	 {
				            		 for(nLoopCount1 = 0 ; nLoopCount1 < nListSize1;nLoopCount1++)
				           		 	 {
				            			 oNoteSecHO =  oNoteSecList.get(nLoopCount1);
				            			 if(oNoteSecHO != null)
				            			 {
				            				 String secDesc = oNoteSecHO.getSecHdgDesc();
				            				 if(!oNoteSecHO.getChildSecHdgDesc().equals(""))
				            				 {
				            					 secDesc = oNoteSecHO.getChildSecHdgDesc();
				            				 }
				            			    if(oNoteSecHO.getSecContentType() != null && oNoteSecHO.getSecContentType().equals("F"))	
				            			    {
				            				 %>
				            				 <tr class = "trNotesMenu">
										          <td class = "tdNotesMenu" onclick = "showNotes('<%=secDesc %>','<%=oNoteSecHO.getSecHdgCode()%>','<%=oNoteSecHO.getChildSecHdgCode()%>','<%=accessNum%>')">
										               <span class = "spCreateMenu"><%=secDesc %></span>
										          </td>
										        </tr>
				            				 <% 
				            			    }
				            			    else
				            			    {
				            			    	%>
				            			    	<tr class = "trNotesMenu">
										          <td class = "tdNotesMenu" >
										               <span class = "spDisabledMenu"><%=secDesc %></span>
										          </td>
										        </tr>
				            			    	<% 
				            			    }
				            			 }
				           		  	 }
				           		  }
				             }
				             catch ( Exception e ){
									out.println("Exception " + e);
									e.printStackTrace();
								}
				         }
				         %>
				      </table>
				  </div> 
				  <div id = "dvNotesContent" class = "dvNotesContent"  >
				        <iframe frameborder="0" id="notesContentFrame"  
							            width="100%"    scrolling ="yes" style = "display:block"></iframe>          
				  </div>
				  <div id = "dvSave" class = "dvSave">
					     <table style = "width:100%;height:100%" border = "0" cellspacing = "0" cellpadding = "0" class = "tbSave">
						     <tr style = "width:100%;height:100%" >
						       <td>    
						       </td>
						       <td style = "width : 80%" align = "right" valign = "center">
						        	<input type ="button" name='save_btn' id='save_btn' value='Save' class="btnType1"  data-role = "none" onclick = "RecordNotes()"/>
						       </td>
						     </tr>
					     </table>
				   </div>
			</div>
			<input type = "hidden" name = "hdnPostBack" id = "hdnPostBack" value = "<%=strPostBack %>"/>
			<input type = "hidden" name = "hdnPatientClass" id = "hdnPatientClass" value = "<%=strPatientClass%>" />
			<input type = "hidden" name = "hdnFilterBy" id = "hdnFilterBy" value = "<%=strFilterBy%>" />
			<input type = "hidden" name = "hdnRecord" id = "hdnRecord" />
			<input type = "hidden" name = "operation_mode" id = "operation_mode" value = ""/>
			<input type = "hidden" name = "patient_class" id = "patient_class" value = "<%=strPatientClass%>"/>
			<input type = "hidden" name = "note_type" id = "note_type" value = "<%=strNoteType%>"/>
			<input type = "hidden" name = "service_name" id = "service_name" value = "<%=service_name%>"/>
			<input type = "hidden" name = "service_code" id = "service_code" value = "<%=service_code%>"/>
			<input type = "hidden" name = "visit_adm_date" id = "visit_adm_date" value = "<%=visit_adm_date%>"/>
			<input type = "hidden" name = "encounter_id" id = "encounter_id" value = "<%=strEncounterId%>"/>
			<input type = "hidden" name = "note_content" id = "note_content"/>
			<input type = "hidden" name = "accession_num" id = "accession_num" value = "<%=accessNum%>" />
			<input type = "hidden" name = "SecHdgCode" id = "SecHdgCode"/>
			<input type = "hidden" name = "childSecHdgCode" id = "childSecHdgCode"/>
			<input type = "hidden" name = "patient_id" id = "patient_id" value = "<%=strPatientId%>"/>
			<input type = "hidden" name = "event_date_time" id = "event_date_time" value = "<%=strCurrentDatetime%>"/>
			<input type = "hidden" name = "errorMsg" id = "errorMsg" value = "<%=strErrorMsg%>"/>
			
		
		</form> 
	</section>  
</body>

</html>

