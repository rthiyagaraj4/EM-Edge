<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.CLEventTabSingle"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.CLTabSub"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.CLTab"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.request.ClinicalEventsFilterRequest"%>
<%@page import="eCA.GetDynamicComponents"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.healthobject.ClinicalEventDataFieldsItem"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.response.ClinicalEventHistDataResponse"%>
<%@page import="eIPAD.chartsummary.CLEventHistory.bc.ClinicalEventsBC"%>
<%@ page language="java" contentType="text/html;charset=UTF-8"%>
<%@page import="eIPAD.chartsummary.common.response.*"%>
<%@ page import="eIPAD.chartsummary.common.healthobject.PatContext"%>
<%@page import="java.util.Locale"%>
<%@page import="java.util.Arrays"%>
<%@ page import="java.util.Date" %>
<%@ page import=" java.util.ArrayList"%>
<%@ page import="java.util.Arrays"%>
<%@ page import=" java.util.LinkedHashSet"%>
<%@ page import=" java.util.List"%>
<%@ page import ="java.util.ResourceBundle" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="java.lang.*,java.util.*,java.sql.*,java.io.*,java.net.*,java.text.*,webbeans.eCommon.*,webbeans.eCommon.ConnectionManager,com.ehis.util.*,eIPAD.pendingresults.*" contentType="text/html;charset=UTF-8" %>
<c:set var="path" value="${pageContext.request.contextPath}" />

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta name="apple-mobile-web-app-capable" content="yes" />
<meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" /> 


</head>
<body>
<%

String lastEventAcces="";
String lastEventType="";
PatContext patContext= (PatContext)session.getAttribute("PatientContext");

ClinicalEventsBC bc= new ClinicalEventsBC();
String dates = request.getParameter("date");
String pos = request.getParameter("pos");
String[] dateformat = dates.split("\\-");

if(dateformat[1].length()==2){
	dates = dateformat[2]+"/"+dateformat[1]+"/"+dateformat[0];
}else{
	dates = dateformat[2]+"/0"+dateformat[1]+"/"+dateformat[0];
}

String originalDate = request.getParameter("date");

String selectedEncId = request.getParameter("selected_encd");

String startFilterDate = request.getParameter("startFilterDate");
String endFilterDate = request.getParameter("endFilterDate");
String PCFilter = request.getParameter("PCFilter");
String HTFilter = request.getParameter("HTFilter");

ClinicalEventsFilterRequest eventsReq = new ClinicalEventsFilterRequest();
eventsReq.setPatientContext(patContext);
eventsReq.setSelectedDate(dates);

if(!selectedEncId.equalsIgnoreCase("")){
String[] encounterArray = selectedEncId.split(",");

ArrayList encList = new ArrayList(Arrays.asList(encounterArray));	
eventsReq.setEncounterIdList(encList);
}else{
	ArrayList encList = new ArrayList();
	eventsReq.setEncounterIdList(encList);
}

if(!startFilterDate.equalsIgnoreCase("")){

eventsReq.setFromDate(startFilterDate);
}else{
	eventsReq.setFromDate(startFilterDate);
	
}

if(!endFilterDate.equalsIgnoreCase("")){

eventsReq.setToDate(endFilterDate);
}else{
	
	eventsReq.setToDate(endFilterDate);
}

if(!PCFilter.equalsIgnoreCase("")){

eventsReq.setPatientClass(PCFilter);
}else{
	
	eventsReq.setPatientClass(PCFilter);
}

if(!HTFilter.equalsIgnoreCase("")){

eventsReq.setHistoryType(HTFilter);
}else{
	
	eventsReq.setHistoryType(HTFilter);
}
String lastEventAccestab="";
String lastEventTypetab="";
ArrayList<String> allTab=null;
ArrayList<String> allTabUniqueIds=null;
ArrayList<String> uniqueListIds=null;
ArrayList<String> allUniqueIds=null;
allTab =new ArrayList<String>();
allTabUniqueIds =new ArrayList<String>();
uniqueListIds = new ArrayList<String>();
allUniqueIds =new ArrayList<String>();

ArrayList<CLEventTabSingle> CLEventsHistoryTabArrayList =new ArrayList<CLEventTabSingle>();

ArrayList<String> allIds= new ArrayList<String>();

ArrayList<String> allIdsIndu= new ArrayList<String>();

ClinicalEventHistDataResponse getHits=bc.getDatewiseSelectedEventsHistory(eventsReq);
ArrayList<ClinicalEventDataFieldsItem> eventsList = getHits.getEventDataList();

ArrayList<CLTab> allEvents= new ArrayList<CLTab>();

String lastEventAccestabs="";
String lastEventTypetabs="";

for(int m=0;m< eventsList.size();m++){
	ClinicalEventDataFieldsItem items=eventsList.get(m);
	String eventTypeHeader = items.getHistRecTypeDesc();
	String eventCategory = items.getEventClassDesc();
	String eventTypeHeaderCode = items.getHistRecType();
	String eventCategoryCode = items.getEventClass();
	
 CLTab tab =new CLTab();
 tab.setDate(originalDate);
 tab.setMainItem(eventTypeHeader);
 tab.setSubItem(eventCategory);
 tab.setSubItemPos(m);
 tab.setHeadCode(eventCategoryCode);
 
 if(!lastEventAccestabs.equalsIgnoreCase(eventTypeHeader)){
	 
	 tab.setStart("start");
 }else{
	 
	 tab.setStart("middle");
 }
 
 lastEventAccestabs=eventTypeHeader;
 allEvents.add(tab);
	
}

ArrayList<CLTabSub> allSubIds=null;
for(int z=0;z< eventsList.size();z++){
	
	ClinicalEventDataFieldsItem items=eventsList.get(z);	
	String eventTypeHeader = items.getHistRecTypeDesc();
	String eventCategory = items.getEventClassDesc();
	String eventTypeHeaderCode = items.getHistRecType();
	String eventCategoryCode = items.getEventClass();
	eventCategoryCode = eventCategoryCode.replaceAll("[-+.^:,$]","");
	
	ArrayList<ArrayList<String>> allEventsRealtedid= new ArrayList<ArrayList<String>>();	
	ArrayList<String> allCurrentEventIds= new ArrayList<String>();
	if(eventTypeHeader!=null){	
		allSubIds =new ArrayList<CLTabSub>();
		for(int f=0;f<allEvents.size();f++){
			String eventCategoryCode1 = items.getEventClass();
			eventCategoryCode1 = eventCategoryCode.replaceAll("[-+.^:,$]","");
			
			 CLTab tab =allEvents.get(f);
			 String mainTitle=tab.getMainItem();
			 String subTitle=tab.getSubItem();
			 String start=tab.getSubItem();
			 int subPos=tab.getSubItemPos();
			 String headCode=tab.getHeadCode();
			 headCode = headCode.replaceAll("[-+.^:,$]","");
			 String unique= originalDate+"_"+eventTypeHeaderCode+"_"+headCode+"_"+f;
			 if(mainTitle.equalsIgnoreCase(eventTypeHeader)){				 
				 CLTabSub sub= new CLTabSub();
				 sub.setHeadInfo(mainTitle);
				 sub.setSubInfo(subTitle);
				 sub.setPos(f);
				 sub.setStart(start);
				 sub.setUniqueId(unique);
				 allSubIds.add(sub);				 
			 }			
		}
	}	
	CLEventTabSingle singleTabItem =new CLEventTabSingle();	
	singleTabItem.setDate(originalDate);

    if(!lastEventAccestab.equalsIgnoreCase(eventTypeHeader)){		
	    singleTabItem.setIsStart("start");
	}else{	
		singleTabItem.setIsStart("middle");
	}
    lastEventAccestab=eventTypeHeader;	
	ArrayList<String> removeDup =new ArrayList<String>();
    
	for(int d=0;d<allSubIds.size();d++){
		CLTabSub subInfo=allSubIds.get(d);
		removeDup.add(subInfo.getSubInfo());
	}
	LinkedHashSet<String> listToSet = new LinkedHashSet<String>(removeDup);
	ArrayList<String> listWithoutDuplicates = new ArrayList<String>(listToSet);
		
	singleTabItem.setTabAllvalues(listWithoutDuplicates);
	for(int k=0;k<listWithoutDuplicates.size();k++){
		String allSeclectionId="";
		String allSeclectionUniqueId="";
		ArrayList<String> addUnique =new ArrayList<String>();
				    
		for(int e=0;e<allSubIds.size();e++){					
			CLTabSub subInfo=allSubIds.get(e);
				if(subInfo.getSubInfo().equalsIgnoreCase(listWithoutDuplicates.get(k))){
					allSeclectionUniqueId=allSeclectionUniqueId+subInfo.getUniqueId();
					addUnique.add(subInfo.getUniqueId());					 
					allCurrentEventIds.add(subInfo.getUniqueId());
				} 
			}
			allEventsRealtedid.add(addUnique);
		}		 
		singleTabItem.setTabSelectionValues(allEventsRealtedid);		 
		singleTabItem.setTabValues(allCurrentEventIds);
		CLEventsHistoryTabArrayList.add(singleTabItem);
}

for(int i=0;i< eventsList.size();i++){	
    ClinicalEventDataFieldsItem items=eventsList.get(i);	
    String eventTypeHeaderCode = items.getHistRecType();
    String eventCategoryCode = items.getEventClass();	

    eventCategoryCode = eventCategoryCode.replaceAll("[-+.^:,$]","");

    String eventTypeHeader = items.getHistRecTypeDesc() != null  ? items.getHistRecTypeDesc() : "";	
    String eventCategory = items.getEventClassDesc() != null  ? items.getEventClassDesc() : "";
    String clinicalNoteType = items.getEventDesc() != null  ? items.getEventDesc() : "";
    String histData=items.getHistDataType();
    String histDataCode=items.getHistRecType();
    String data = "";
    String dateHeader = dates;
    CLEventTabSingle tabs=CLEventsHistoryTabArrayList.get(i);

%>
<div id="clinicalEventPreviewPane" class="table clinicalEventPreviewPaneCss <%=histDataCode%>_<%=request.getParameter("date")%>">	
	<%
	if(!lastEventAcces.equalsIgnoreCase(eventTypeHeader)){
		lastEventType ="";		
	%>	 
	<div class="row">
        <div class="cell" style="width:100%;height:auto;">
            <div class="clinicalEventPreviewWrapper" data-role="none">
               <div style="float: left; width: calc(100% - 45px);">
                  <div style="display: table;"  data-role="none">
                     <div style="display: table-row;" data-role="none">
                        <div class="clinicalEventPreviewHeader" data-role="none">
                           <%=eventTypeHeader%>
                        </div>
                     </div>
                  </div>
                  <div style="display: table;"  data-role="none">
                     <div style="display: table-row;" data-role="none">
                        <div class="clinicalEventPreviewEID" data-role="none">
                           <span style="font-size: 11px;color: #7393a4;">Encounter Id :
                           </span>
                           <span style="font-size: 12px;color: #032b3f;"><%=items.getEncounterId()%>
                           </span>
                        </div>
                     </div>
                  </div>
               </div>
               <div style="float: left; width: 45px;">
                  <div class="clinicalEventPreviewPatientClass"><%=items.getPatient_class() %></div>
               </div>
               <div style="clear: both;"></div>
            </div>
        </div>
    </div>
<% 
}
   lastEventAcces=eventTypeHeader; 
   if("start".equalsIgnoreCase(tabs.getIsStart())){
%>  
<div id="<%=eventTypeHeaderCode%>_<%=eventCategoryCode%>_<%=i%>" 
data-iscrollId="<%=eventTypeHeaderCode%>_<%=eventCategoryCode%>_<%=i%>" class="row eventsHeaderCss">
   <div style="width: auto;position: absolute;">
   <ul style="white-space: nowrap;padding-left:0px;padding-bottom:0px;margin-bottom: 0px;">
   <%	
	ArrayList<String> allTabEvents= tabs.getTabAllvalues();
		CLEventTabSingle singleTabItem = tabs;		
		for(int h=0;h<allTabEvents.size();h++){
			String defalutLoad="";			
			if(h==0){				
				 defalutLoad="start";				 
			}else{				
				defalutLoad="middle";
			}			 
			ArrayList<ArrayList<String>> currentSelection =singleTabItem.getTabSelectionValues();
			ArrayList<String> allSection =singleTabItem.getTabValues();			 
			ArrayList<String>  currentSingleSelection =currentSelection.get(h);
			String categoryIds = currentSingleSelection.get(0);
			String listString1 = "";

			for (String s : currentSingleSelection)
			{
			    listString1 += s + ",";
			}			 
			String listString2 = "";
			for (String s : allSection){
			    listString2 += s + ",";
			}	
	%>
	   <li class="defaultHeader" id="<%=categoryIds%>_list" data-ids="<%=categoryIds%>_list" data-default="<%=defalutLoad %>" data-currentSection="<%=listString1 %>" data-allSection="<%=listString2 %>" onclick="onClickHeader(this)">
		  <div class="listContainer">
		     <div class="listHeading"><%=allTabEvents.get(h)%></div> 
		     <div class="listCount"><%=currentSingleSelection.size()%></div>
		  </div>
	   </li>
	<%
	}
   }	
  %>
  </ul>
  </div>	
</div>
</div>
<%
if(histData.equalsIgnoreCase("HTM") || histData.equalsIgnoreCase("HTML")){
	lastEventAcces=eventTypeHeader;	
	lastEventType =eventCategory ;			
	PreparedStatement  pstmt1=null;
	ResultSet  rs1=null;
	String locale=patContext.getLocale();		
	Connection  con = null;
	String footer_code = null;//IN030859
	String report_header_code = null;//IN030859		
	PreparedStatement  pstmt2 = null;
	ResultSet  rs2 =	null;
	String performed_by_id	=	"" ;
	String patient_class =	"";
	String default_pat_name ="";
	String encounter_id1 = "";
	String Sex = "";
	String facility_name =	"" ;
	String visit_adm_date	=	"" ;
	String attending_practitioner	=	"" ;
	String admitting_practitioner	=	"" ;
	String bed_number	=	"" ;
	String performing_phy_name	=	"" ;
	String age	=	"" ;
	String gender	=	"" ;
	String patient_name	=	"" ;
	String speciality_name	=	"" ;
	String printDateTime	=	"" ;
	String site_name	=	"" ;
	String doc_ref_id = "";
	String last_amended_by="";
	String authorized_by="";
	String pract_sign = "";
	String query_privilege_type	=	"" ;
	String url1					=	"";
	String url						=	"";
	String		episode_type	=	"" ;
	String		discharge_date		=	"", med_service 	=	"", location_code 	=	"";
	String accessionnum="";
	String extimageobjid="";
	String acc_for_notefooter="";
	String patientid="";
	String requrl = request.getRequestURL().toString();
	String requri = request.getRequestURI();
    url = requrl.substring( 0, requrl.indexOf(requri) ) + request.getContextPath();
    url1  	=		url + "/eCA/html/RecClinicalNotesTemplateDispayView.xsl";
	
	java.sql.Clob			clob_notes_content	= null;
	java.io.Reader			content_reader		= null;
	java.io.BufferedReader	bf_content_reader	= null;
	String	section_content			=	"";
	String	section_content_rpt		=	"";
	String	section_content_ftr		=	"";
	String eventdatetime="";
	String encounter_id = items.getEncounterId();
	String enc_id = items.getEncounterId();
	String enctr_id = items.getEncounterId();
	String fac_id=items.getFacilityId();
	String contr_mod_accession_num="";		
	Hashtable htParameter=new Hashtable();
	eCA.HeaderDomParser parser = new eCA.HeaderDomParser();
	webbeans.eCA.XMLtoHTML converter=new webbeans.eCA.XMLtoHTML();
	StringBuffer sectionContentUpdatedXML=new StringBuffer();
	HashMap<String,String> paramMap = null;
	extimageobjid="";
	eventdatetime=items.getEventDateTimeStr();		
	accessionnum=items.getAccessionNum();
	patientid=patContext.getPatientId();
	String cal_eventdate 		= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en","en");//IN040090
	String eventdatetime_th	= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en",locale);
	con =  ConnectionManager.getConnection(request);
	try
	{
		if(	episode_type.equals("O") )
		{
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ?"; //uncommentted - [IN033977 for IN040199] //IN045646 get_desc for specialty_name changed from 2 to 1
		}
		else
		{ 
			query_privilege_type	=	"Select A.patient_class, TO_CHAR(A.VISIT_ADM_DATE_TIME,'DD/MM/YYYY hh24:mi') visit_adm_date,CASE WHEN PATIENT_CLASS IN ('IP','DC') THEN IP_GET_DESC.IP_NURSING_UNIT(a.facility_id,a.assign_care_locn_code,?,'1')  ELSE OP_GET_DESC.OP_CLINIC(a.facility_id,a.assign_care_locn_code,?,'1')  END location_code,AM_GET_DESC.AM_SERVICE(a.service_code,?,'2')   service_name,AM_GET_DESC.AM_PRACTITIONER(a.attend_practitioner_id,?,1) attending_practitioner,AM_GET_DESC.AM_PRACTITIONER(?,?,'2') performed_by_name,nvl(to_char(DISCHARGE_DATE_TIME ,'dd/mm/yyyy hh24:mi') ,'') DISCHARGE_DATE_TIME,SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,?,'1') facility_name,get_age(B.DATE_OF_BIRTH) AGE,a.assign_care_locn_code  locn_code  ,DECODE (?,'en', b.patient_name,NVL (b.patient_name_loc_lang, b.patient_name)) patient_name ,AM_GET_DESC.AM_SPECIALITY(A.SPECIALTY_CODE,?,'1') specialty_name,SEX gender, to_Char(sysdate,'dd/mm/yyyy hh24:mi') print_date_time,(SELECT 	site_name FROM  SM_SITE_PARAM_LANG_VW where language_id = ?) site_name,(select SHORT_NAME from am_practitioner where practitioner_id=a.ADMIT_PRACTITIONER_ID) admitting_practitioner,ASSIGN_BED_NUM bed_number FROM	PR_ENCOUNTER A,MP_PATIENT B 	WHERE A.FACILITY_ID=? AND A.PATIENT_ID=B.PATIENT_ID AND A.ENCOUNTER_ID = ? "; //uncommentted - [IN033977 for IN040199] //IN045646 get_desc for specialty_name changed from 2 to 1
		}	
		pstmt1	=	con.prepareStatement(query_privilege_type);	
		pstmt1.setString	(	1,	locale	);
		pstmt1.setString	(	2,	locale	);
		pstmt1.setString	(	3,	locale	);
		pstmt1.setString	(	4,	locale	);
		pstmt1.setString	(	5,	performed_by_id	);
		pstmt1.setString	(	6,	locale	);
		pstmt1.setString	(	7,	locale	);			
		pstmt1.setString	(	8,	locale	);			
		pstmt1.setString	(	9,	locale	);			
		pstmt1.setString	(	10,	locale	);			
		pstmt1.setString	(	11,	items.getFacilityId()	);//IN033489
		pstmt1.setString	(	12,	items.getEncounterId());	
		rs1		=	pstmt1.executeQuery();	
		if(rs1.next())
		{
			patient_class	=	rs1.getString("patient_class") == null ? "" : rs1.getString("patient_class");
			facility_name			=	rs1.getString("facility_name") == null ? "" : rs1.getString("facility_name");
			visit_adm_date			=	rs1.getString("visit_adm_date")==null?"":rs1.getString("visit_adm_date");
			med_service			=	rs1.getString("service_name")==null?"":rs1.getString("service_name");
			discharge_date		=	rs1.getString("DISCHARGE_DATE_TIME")==null?"":rs1.getString("DISCHARGE_DATE_TIME");
			attending_practitioner	=	rs1.getString("attending_practitioner")==null?"":rs1.getString("attending_practitioner");
			admitting_practitioner	=	rs1.getString("admitting_practitioner")==null?"":rs1.getString("admitting_practitioner");
			bed_number	=	rs1.getString("bed_number")==null?"":rs1.getString("bed_number");	  //--[IN:029839]--
			performing_phy_name	=	rs1.getString("performed_by_name")==null?"":rs1.getString("performed_by_name");
			age				=	rs1.getString("AGE")==null?"":rs1.getString("AGE");
			gender					=	rs1.getString("gender")==null?"":rs1.getString("gender");
			location_code			=	rs1.getString("location_code")==null?"":rs1.getString("location_code");
			patient_name			=	rs1.getString("patient_name")==null?"":rs1.getString("patient_name");
			speciality_name			=	rs1.getString("specialty_name")==null?"":rs1.getString("specialty_name");
			printDateTime			=	rs1.getString("print_date_time")==null?"":rs1.getString("print_date_time");
			site_name			=	rs1.getString("site_name")==null?"":rs1.getString("site_name");
		}
		if(gender.equals("M"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
		else if (gender.equals("F"))
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		else 
				Sex =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

			if(discharge_date==null)
			{
				discharge_date="";
			}
			if(patient_class.equals("OP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			else if(patient_class.equals("IP"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			else if(patient_class.equals("EM"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			else if(patient_class.equals("DC"))
			patient_class =		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		if(rs1!=null)	rs1.close();
		if(pstmt1!=null)	pstmt1.close();
	}
					try
					{
						String head_foot_qry ="select a.FOOTER_CODE,a.REPORT_HEADER_CODE from ca_note_type a where  a.NOTE_TYPE=?";
						pstmt2	= con.prepareStatement(head_foot_qry);
						pstmt2.setString(1,items.getContr_sys_event_code());
						rs2 = pstmt2.executeQuery();
						
						while(rs2.next())
						{
							footer_code = rs2.getString("FOOTER_CODE")==null?"":rs2.getString("FOOTER_CODE");
							report_header_code = rs2.getString("REPORT_HEADER_CODE")==null?"":rs2.getString("REPORT_HEADER_CODE");
						}
					}
					catch(Exception ee)
					{
						out.println("Exceptionin RecClinicalNotesSection.jsp @ head_foot_qry : "+ee.toString());
						ee.printStackTrace();
					}
					finally
					{
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();
					}
					 String sect_template_query = "select TEMPLATE_FORMAT from CA_SECTION_HDG where  SEC_HDG_CODE =? " ;						
					try
					{
						pstmt2	= con.prepareStatement(sect_template_query);
						pstmt2.setString(1,report_header_code);
						rs2 = pstmt2.executeQuery();
						if(rs2.next())
						{
							clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");							
							if(clob_notes_content!=null)
							{
								try
								{
									content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
									bf_content_reader	= new java.io.BufferedReader(content_reader);
									char[] arr_notes_content = new char[(int)clob_notes_content.length()];
									bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
									section_content = new String(arr_notes_content);
									bf_content_reader.close();
									if(section_content == null)
										section_content = "";
								}
								catch(Exception e)
								{
									out.println("Exception@1-readCLOB : "+e);
									e.printStackTrace();
								}
							}
						}
					}
					catch(Exception eee)
					{
						out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
						eee.printStackTrace();
					}
					finally
					{
						if(rs2 != null) rs2.close();
						if(pstmt2 != null) pstmt2.close();						
					}
	
					if(!accessionnum.equals(""))
					{
						try
						{
							String athorise_by_qry ="select AM_GET_DESC.AM_PRACTITIONER(a.AUTHORIZED_BY_ID,?,'1') AUTHORIZED_BY_ID,AM_GET_DESC.AM_PRACTITIONER(a.LAST_AMENDED_BY_ID,?,'1') LAST_AMENDED_BY_ID,a.DOC_REF_ID,AM_GET_DESC.AM_PRACTITIONER(a.PERFORMED_BY_ID,?,'1') performed_by_name,AM_GET_DESC.AM_SERVICE(a.SERVICE_CODE,?,'2') service_name from CA_ENCNTR_NOTE a where a.ACCESSION_NUM = ? and a.PATIENT_ID = ? " ;

							pstmt2	= con.prepareStatement(athorise_by_qry);
							pstmt2.setString(1,locale);
							pstmt2.setString(2,locale);
							pstmt2.setString(3,locale);
							pstmt2.setString(4,locale);
							if(accessionnum.contains("!"))
								acc_for_notefooter = extimageobjid;
							else
								acc_for_notefooter = accessionnum;
							pstmt2.setString(5,acc_for_notefooter);
							pstmt2.setString(6,patientid);
							rs2 = pstmt2.executeQuery();
							while(rs2.next())
							{
								authorized_by		=	rs2.getString("AUTHORIZED_BY_ID")==null?"":rs2.getString("AUTHORIZED_BY_ID") ;//IN030996
								last_amended_by		=	rs2.getString("LAST_AMENDED_BY_ID")==null?"":rs2.getString("LAST_AMENDED_BY_ID");//IN030996
								doc_ref_id		=	 rs2.getString("DOC_REF_ID")==null?"":rs2.getString("DOC_REF_ID") ;//IN030996						
							}
						}
						catch (Exception roro )

						{
							out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+roro.toString());
							roro.printStackTrace();
						}
						finally 
						{
							if(rs2 != null) rs2.close();
							if(pstmt2 != null) pstmt2.close();							
						}
					}									
					encounter_id1 = enc_id ;
					if(enc_id.equals("0"))
					{
						encounter_id1 ="";
					}
		
					if(!visit_adm_date.equals(""))
					{
						visit_adm_date					=	com.ehis.util.DateUtils.convertDate(visit_adm_date,"DMYHM","en",locale);
					}
		
					if(!discharge_date.equals(""))
					{
						discharge_date					=	com.ehis.util.DateUtils.convertDate(discharge_date,"DMYHM","en",locale);
					}
					htParameter.put("V$ATT_PRACT", attending_practitioner);
					htParameter.put("V$ADM_PRACT", admitting_practitioner);
					htParameter.put("V$BED_NUM", bed_number);	//---[IN:029839]---
					htParameter.put("V$PT_SPLTY", speciality_name);
					if(patient_name.trim().equals(""))
						htParameter.put("V$PT_NAME", default_pat_name);
					else
						htParameter.put("V$PT_NAME", patient_name);
					htParameter.put("V$PT_ID", patientid);
					htParameter.put("V$SEX", Sex);
					htParameter.put("V$AGE", age);
					htParameter.put("V$ENC_ID", enctr_id);//IN031989
					htParameter.put("V$ADM_DT", visit_adm_date); //visit_adm_date
					htParameter.put("V$DIS_DT", discharge_date); //discharge_date
					htParameter.put("V$MED_SERV", med_service);
					htParameter.put("V$DOC_REF_H", doc_ref_id);
					htParameter.put("V$PT_LOCN", location_code); //patient_loc
					htParameter.put("V$PT_CLASS", patient_class);//patient_class
					StringBuffer section_content_new = new StringBuffer(section_content);
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",report_header_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}

	if(!section_content_new.toString().equals(""))
	{
		//***************************** [CRF-118] Start *****************************					
		eCA.GetDynamicComponents dynamicCompDetails = new GetDynamicComponents();
		HashMap paramHash=new HashMap();
		Hashtable tempParameter=new Hashtable();
		paramHash.put("#p_patient_id#",patientid);
		paramHash.put("#p_encounter_id#",enctr_id);		
		paramHash.put("#p_accNum#",accessionnum);
		paramHash.put("#p_locale#",locale);
		paramHash.put("#p_eventDate#",cal_eventdate);//IN039562//IN040090
		paramHash.put("#p_facility_id#",fac_id);	
		paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 		
		tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);
		if(tempParameter.size()>0){					
		htParameter.putAll(tempParameter);
		}
		//*****************************[CRF-118] Ends *****************************
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}

	if(!(sectionContentUpdatedXML.toString().equals("")))
	{								
		section_content_rpt=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);	
	}	
	section_content= "";	
	try
	{	
		pstmt2	= con.prepareStatement(sect_template_query);
		pstmt2.setString(1,footer_code);
		rs2 = pstmt2.executeQuery();
		if(rs2.next())
		{
			clob_notes_content			=	(java.sql.Clob) rs2.getObject("TEMPLATE_FORMAT");
			if(clob_notes_content!=null)
			{
				try
				{
					content_reader		= ((java.sql.Clob) clob_notes_content).getCharacterStream();
					bf_content_reader	= new java.io.BufferedReader(content_reader);
					char[] arr_notes_content = new char[(int)clob_notes_content.length()];
					bf_content_reader.read(arr_notes_content,0,(int)clob_notes_content.length());
					section_content = new String(arr_notes_content);
					bf_content_reader.close();
				
					if(section_content == null)
					section_content = "";
				}
				catch(Exception e)
				{
					out.println("Exception@1-readCLOB : "+e);
					e.printStackTrace();
				}
			}
		}
	}

	catch(Exception eee)
	{
		out.println("Exceptionin RecClinicalNotesSection.jsp getting section content : "+eee.toString());
		eee.printStackTrace();
	}
	finally
	{
		if(rs2 != null) rs2.close();
		if(pstmt2 != null) pstmt2.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}

	if(!printDateTime.equals(""))
	{
		printDateTime =	com.ehis.util.DateUtils.convertDate(printDateTime,"DMYHM","en",locale);
	}
	htParameter=new Hashtable();
	htParameter.put("V$CUR_USR", patContext.getLoggedInUser());
	htParameter.put("V$AT_PRACT", authorized_by);
	htParameter.put("V$LT_MODI_USR", last_amended_by);
	htParameter.put("V$PRN_DTTIME", printDateTime);//printDateTime
	htParameter.put("V$DOC_REF_F", doc_ref_id);
	htParameter.put("V$LT_PT_P_C_D", pract_sign);
	section_content_new = new StringBuffer(section_content);	
	if((!section_content_new.toString().equals("&nbsp;"))&& (!section_content_new.toString().equals("")))
	{													
		eCA.GetDynamicComponents dynamicCompDetails = new eCA.GetDynamicComponents();
		HashMap paramHash=new HashMap();
		Hashtable tempParameter=new Hashtable();
	
		paramHash.put("#p_contr_mod_accession_num#",contr_mod_accession_num); 
		paramHash.put("#p_accNum#",accessionnum);
		paramHash.put("#p_locale#",locale);
		paramHash.put("#p_pract_id#",patContext.getClinicianId());
		tempParameter = dynamicCompDetails.getDynamicCompDetails(section_content_new,paramHash);	
		if(tempParameter.size()>0)
		{					
			htParameter.putAll(tempParameter);
		}
	}
	sectionContentUpdatedXML = new StringBuffer();
	if (! locale.equals("en") )
	{
		if(!section_content_new.toString().equals(""))
		{
			paramMap = new HashMap<String,String>();
			paramMap.put("CURR_SEC_HDG_CODE",footer_code);
			paramMap.put("LOCALE",locale);						
			paramMap.put("RANGE_PASER_YN","N");
			eCA.TemplateLangRepParser tempLangParse = new eCA.TemplateLangRepParser(con,paramMap,section_content_new);
			section_content_new = tempLangParse.getLangReplacedXML();
			tempLangParse = null;
		}
	}
	if(!section_content_new.toString().equals(""))
	{
		sectionContentUpdatedXML = parser.updateXMLContentValues(section_content_new,htParameter,locale);
	}
	if(!(sectionContentUpdatedXML.toString().equals("")))
	{									
		section_content_ftr=converter.buildHTMLFromXML(sectionContentUpdatedXML.toString(),url1);
	}	
	String  resultstr= items.getResultStr(); 
    if(resultstr==null){	
	  resultstr="";
    }
	StringBuffer displaydata = null;
	
	if(!section_content_rpt.equals(""))
	{
		data= "<table  cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_rpt+"</td></tr></table><BR>";//IN030859
	}
	else{
		data= "";//IN030859		
	}
	String displaydataTemp=items.getHistData();
	if(!resultstr.equals("") ||!displaydataTemp.equals("") )
	{
		data=data+"<PRE style='word-wrap:break-word;'>"+resultstr+"</PRE>  <table  cellpadding='0' cellspacing='4' width='100%'><tr><td>"+displaydataTemp+"</td></tr></table><BR>";
	}
	else{
		data= data;//IN030859		
	}
	if(!section_content_ftr.equals(""))
	{
	data= data+"<table cellpadding='0' cellspacing='4' width='100%'><tr><td>"+section_content_ftr+"</td></tr></table><BR>";//IN030859
	}
	else{
		data= data;//IN030859		
	}
	Date dat= items.getEventDateTime();
	String hrs = "";
	if(dat.getHours() != 0){
		if(dat.getHours() < 10){
			hrs = "0"+dat.getHours(); 
		}
		else{
			hrs =""+dat.getHours(); 
		}
	}
	else{
		    hrs="00";
	}
	String mns = "";
	if(dat.getHours() != 0){
		if(dat.getMinutes() < 10){
			mns = "0"+dat.getMinutes(); 
		}
		else{
			mns =""+dat.getMinutes(); 
		}
	}
	else{
		    mns="00";
	}
	String eventTime = hrs+":"+mns;
%>	
<div style="background: #f5f7fb;height: auto;width: 99.7%;display:none;margin-top:5px;" id="<%=originalDate%>_<%=eventTypeHeaderCode%>_<%=eventCategoryCode%>_<%=i%>">
 <div class="clinicalNoteEventContent" style="display: table;width: 99%;margin-right: 5px;margin-left: 5px;margin-top: 2px;margin-bottom: 3px;" data-role="none">
                  <div style="display: table-row;width: 100%;height: 30px;" data-role="none">
                     <div class="clinicalEventContainerCell" data-role="none">
                        <div class="clinicalEventTimer" style="padding-top: 1px !important;"><%=eventTime%>
                        </div>                  
                     </div>                    
                     <div style="display: table-cell;vertical-align: middle;color: #696969; font-size: 13px;font-weight: bold;font-family: arial;">
                     <%=clinicalNoteType%>
                     </div>                     
                  </div>
             </div> 
   <div class="table" style="width:100%;height:100%;table-layout: fixed;">
   <div class="row" style="width:100%;height:100%;">
      <div id="pat<%=i%><%=request.getParameter("date")%>" data-htm=<%=i%><%=request.getParameter("date")%> class="cell" style="position: relative;width:100%;height:100%;">            
          <div  style="height: auto;width:auto;border :1px solid #0d7ba0;background: #ffffff;word-break: break-word;text-align: justify;margin-left: 8px;margin-bottom: 4px;margin-right: 4px;overflow: hidden;" class="clinicalEventHTMLContainer"  data-role="none">
            <%=data%>
            </div>   
     </div>
  </div>
</div>
</div>
<% } 
else if(histData.equalsIgnoreCase("NUM")){	

String encounterID =items.getEncounterId() != null  ? items.getEncounterId() : "";
String criticality = items.getNormalcyInd() != null  ? items.getNormalcyInd() : "";
String deciresult = items.getDeciresult() != null  ? items.getDeciresult() : "";

String encounterType = items.getPatient_class() != null  ? items.getPatient_class() : "";
Date dat= items.getEventDateTime();
String hrs = "";
if(dat.getHours() != 0){
	if(dat.getHours() < 10){
		hrs = "0"+dat.getHours(); 
	}
	else{
		hrs = ""+dat.getHours(); 
	}
}
else{
	hrs="00";
}
String mns = "";
if(dat.getHours() != 0){
	if(dat.getMinutes() < 10){
		mns = "0"+dat.getMinutes(); 
	}
	else{
		mns = ""+dat.getMinutes(); 
	}
}
else{
	    mns="00";
}
String eventTime = hrs+":"+mns;
String resultUnit = items.getResultNumUom() != null  ? items.getResultNumUom() : "";
String resultNormalRangeLow =items.getNormalLow() != null  ? items.getNormalLow() : "";
String resultNormalRangeHigh =items.getNormalHigh() != null  ? items.getNormalHigh() : "";
String resultNormalUnit = items.getResultNumUom() != null  ? items.getResultNumUom() : "";

 String numResult=items.getResult_Number_values()  != null  ? items.getResult_Number_values() : "";  
 String numberRes = numResult.replace("&nbsp;","");
   lastEventType=eventCategory; 
   String displaydata=items.getHistData();
	data="";
	String  resultstr= items.getResultStr(); 
	if(resultstr==null){		
		resultstr="";
	}
	Clob note;
	
	note=items.getNote();
	StringBuffer displaydatas= new StringBuffer();
	
				if(note!=null)
				{
					java.io.BufferedReader	r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;	
					while((line=r.readLine()) != null) displaydatas.append(line+"\n");
				}

	if(displaydata.length() >0)
	{
		String displaydataTemp = ((String)(displaydatas.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","")).trim();
		data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+displaydataTemp+"</PRE>";
		if(resultstr!=null && !resultstr.equals("")){
			data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+resultstr+"</PRE><BR>";
		} 
	}
	else{
		data=resultstr+" "+displaydatas.toString();
	}
 %>  
  <div style="background: #f5f7fb;display:none;width:99.7%;margin-top:5px;" id="<%=originalDate%>_<%=eventTypeHeaderCode%>_<%=eventCategoryCode%>_<%=i%>">
     <div class="cell" style="width:100%;height:auto;">
        <div class="clinicalEventContainerWrapper" data-num=<%=i%><%=request.getParameter("date")%> data-role="none">
           <div class="clinicalNoteEventContent" style="display: table;width: 99.7%;margin-left: 5px;margin-top: 2px;margin-bottom: 3px;" data-role="none">
              <div class="clinicalEventContainerRow60px" data-role="none">
                 <div class="clinicalEventContainerCell" style="background-color:#f5f7fb;" data-role="none">
                    <div class="clinicalEventTimer"><%=eventTime%>
                    </div>
                    <div style="text-align: -webkit-center;">
                       <hr id="num_<%=i%><%=request.getParameter("date")%>" class="CNVerticalLine"/>
                    </div>
                 </div>
                 <div class="clinicalEventContainerData" data-role="none">
                    <div style="display: table;width: 100%;">
                       <div class="clinicalEventContainerRow30px" data-role="none">
                          <div class="clinicalEventContainerDataInnerCell" data-role="none">
                             <%=clinicalNoteType%>
                          </div>
                       </div>
                       <div class="clinicalEventContainerRow30px" data-role="none">
                          <div style="display: table-cell;width: 100%;">
                             <div style="display: table;width: 100%;">
                                <div class="clinicalEventContainerRow30px" data-role="none">
                                   <div class="clinicalEventContainerCellDataLeft" data-role="none">
                                     <% if(!criticality.equals("")){ %>	
									  <div style="display:inline-block;width: 30px;vertical-align: middle;text-align: center;padding-bottom: 0px;"> 
                                   								  
                                      <% if(criticality.equals("G")){ %>
                                         <img src="${path}/eIPAD/images/IND_CriticallyHigh24x24.png"/>
                                       <% } else if(criticality.equals("S")){ %>
                                         <img src="${path}/eIPAD/images/IND_CriticallyLow24x24.png"/>
                                       <% } else if(criticality.equals("A")){ %>
                                         <img src="${path}/eIPAD/images/IND_Abnormal24x24.PNG"/>
                                       <% } else if(criticality.equals("C")){ %>
                                         <img src="${path}/eIPAD/images/IND_Critical24x24.PNG"/>
                                       <% } else if(criticality.equals("L")){ %>
                                         <img src="${path}/eIPAD/images/IND_Low24x24.png"/>
                                       <% } else if(criticality.equals("H")){ %>
                                         <img src="${path}/eIPAD/images/IND_High24x24.png"/>
                                       <% } else if(criticality.equals("N")){ %>
                                         <img src="${path}/eIPAD/images/IND_NORMAL24x24.png"/>                                        
                                       <% } %>                                         
                                      </div>
									  <% }
									  else{ %>	
									  <div style="display:none;width: 30px;vertical-align: middle;text-align: center;padding-bottom: 0px;"> 
                                      </div>
									  <% } %>   
									  
									  
                                      <div style="display:inline-block;font-size: 13px;font-family: arial;padding-top: 8px;padding-left: 5px;">
                                         <span style="color: #5f5f5f;font-weight: bold;"><%=numberRes%></span>
                                         <span style="color: #a6a6a6;font-weight: normal;"><%=resultUnit%></span>
                                      </div>
                                   </div>
                                   <div class="clinicalEventContainerCellDataRight" data-role="none">
                                   <% if(!resultNormalRangeLow.equals("")){%>
                                      <span><%=resultNormalRangeLow%> - <%=resultNormalRangeHigh%> </span> 
                                      <span><%=resultNormalUnit%></span>
                                     <% } %>
                                   </div>
                                </div>
                             </div>
                          </div>
                       </div>
                 <% 

                 String remStr = data;
                 remStr = remStr.replace("&nbsp;","");
                   if(!remStr.equalsIgnoreCase(" ")){%>
                       <div class="clinicalEventContainerRow30px"  data-role="none">
                          <div class="clinicalEventContainerDataInnerCell" style="font-weight: normal !important;" data-role="none">
                             <div id="clinicalEventContainerSizing" style="word-wrap:break-word;"><%=data%></div>
                          </div>
                       </div>
                      <% } %> 
                    </div>
                 </div>
              </div>
           </div>
        </div>
     </div>
  </div> 
 </div>     
<%

} else if(histData.equalsIgnoreCase("STR") ||  histData.equalsIgnoreCase("TXT") ){
	
	String criticality = items.getNormalcyInd() != null  ? items.getNormalcyInd() : ""; 
		
	String convertedHTML3 = items.getEventDesc();
	String convertedHTML4 = items.getEncounterId();	
	String convertedHTML5 = items.getResultStr();
	String encounterType = items.getPatient_class() != null  ? items.getPatient_class() : "";
	Date dat= items.getEventDateTime();
	String hrs = "";
	if(dat.getHours() != 0){
		if(dat.getHours() < 10){
			hrs = "0"+dat.getHours(); 
		}
		else{
			hrs =""+dat.getHours(); 
		}
	}
	else{
		    hrs="00";
	}
	String mns = "";
	if(dat.getHours() != 0){
		if(dat.getMinutes() < 10){
			mns = "0"+dat.getMinutes(); 
		}
		else{
			mns =""+dat.getMinutes(); 
		}
	}
	else{
		    mns="00";
	}
	String eventTime = hrs+":"+mns;

   lastEventType=eventCategory;  
   
   String displaydata=items.getHistData();
	data="";
	String  resultstr= items.getResultStr(); 
	if(resultstr==null){		
		resultstr="";
	}
	Clob note;
	
	note=items.getNote();
	StringBuffer displaydatas= new StringBuffer();
	
				if(note!=null)
				{
					java.io.BufferedReader	r = new java.io.BufferedReader(note.getCharacterStream());
					String line = null;	
					while((line=r.readLine()) != null) displaydatas.append(line+"\n");
				}

	if(displaydata.length() >0)
	{
		String displaydataTemp = ((String)(displaydatas.toString()).replaceAll("<DIV align=left> <ADDRESS><FONT size=3></FONT>&nbsp;</ADDRESS></DIV>","")).trim();
		if(resultstr!=null && !resultstr.equals("")){
			data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+resultstr+"</PRE><BR>";
		} 
		data=data+"<PRE style='white-space: pre-wrap;color: #5e6466;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;margin-top: 0px;margin-bottom: 0px;'>"+displaydataTemp+"</PRE>";
	}
	else{
		data=resultstr+" "+displaydatas.toString();
	}
 %>   
 <div style="background: #f5f7fb;display:none;width:99.7%;margin-top:5px;" id="<%=originalDate%>_<%=eventTypeHeaderCode%>_<%=eventCategoryCode%>_<%=i%>">
     <div class="cell" style="width:100%;height:auto;">
        <div  class="clinicalEventContainerWrapper" data-str=<%=i%><%=request.getParameter("date")%> data-role="none">
           <div class="clinicalNoteEventContent" style="display: table;width: 99.7%;margin-left: 5px;margin-top: 2px;margin-bottom: 3px;" data-role="none">
              <div class="clinicalEventContainerRow60px" data-role="none">
                 <div class="clinicalEventContainerCell" data-role="none">
                    <div class="clinicalEventTimer"><%=eventTime%>
                    </div>
                    <div style="text-align: -webkit-center;">
                       <hr id="str_<%=i%><%=request.getParameter("date")%>" class="CNVerticalLine"/>
                    </div>
                 </div>
                 <div class="clinicalEventContainerData" data-role="none">
                    <div style="display: table;width: 100%;">
                       <div class="clinicalEventContainerRow30px" data-role="none">
                          <div class="clinicalEventContainerDataInnerCell" data-role="none">
                             <%=convertedHTML3%>
                          </div>
                       </div>
                       <div class="clinicalEventContainerRow30px" data-role="none">
                          <div style="display: table-cell;width: 100%;">
                             <div style="display: table;width: 100%;">
                                <div class="clinicalEventContainerRow30px" data-role="none">
                                   <div class="clinicalEventContainerCellDataLeft" data-role="none">
                                       <% if(!criticality.equals("")){ 
										 if(criticality.equals("G")){ %>
									     <div class="numericStringFormat"> 
                                         <img src="${path}/eIPAD/images/IND_CriticallyHigh24x24.png"/>
										 </div>
                                       <% } else if(criticality.equals("S")){ %>
									     <div class="numericStringFormat">  
                                         <img src="${path}/eIPAD/images/IND_CriticallyLow24x24.png"/>
										 </div>
                                       <% } else if(criticality.equals("A")){ %>
									     <div class="numericStringFormat"> 
                                         <img src="${path}/eIPAD/images/IND_Abnormal24x24.PNG"/>
										 </div>
                                       <% } else if(criticality.equals("C")){ %>
									     <div class="numericStringFormat"> 
                                         <img src="${path}/eIPAD/images/IND_Critical24x24.PNG"/>
										 </div>
                                       <% } else if(criticality.equals("L")){ %>
									     <div class="numericStringFormat"> 
                                         <img src="${path}/eIPAD/images/IND_Low24x24.png"/>
										 </div>
                                       <% } else if(criticality.equals("H")){ %>
									     <div class="numericStringFormat"> 
                                         <img src="${path}/eIPAD/images/IND_High24x24.png"/>
										 </div>
                                       <% } else if(criticality.equals("N")){ %>
									   <div class="numericStringFormat"> 
                                         <img src="${path}/eIPAD/images/IND_NORMAL24x24.png"/>   
                                        </div>										 
                                       <% }
									   }
									   %>
                                      <div style="display:inline-block;padding:5px;font-size: 13px;font-weight: normal;text-align:justify;font-family: arial;color: #5e6466;">
                                         <span><%= data %></span>
                                      </div>
                                   </div>
                                </div>
                             </div>
                          </div>
                       </div>
                    </div>
                 </div>
              </div>
           </div>
        </div>
     </div>
  </div> 
  </div>   
	<%
}%>
</body>
<% 
}
%>

<style>
.activeHeader{
	
	padding-left: 15px;
	padding-right: 15px;
	padding-bottom: 11.5px;
	font-size: 14px;
	font-family: arial;
	color: #2c80a3;
	font-weight: bold;
	display: inline-block;
	list-style-type: none;
	border-bottom: 3px solid #2c80a3;
}
.defaultHeader{
	padding-left: 15px;
	padding-right: 15px;
	padding-bottom: 11.5px;
	font-family: arial;
	font-size: 14px;
	color: #032b3f;
	font-weight: bold;
	display: inline-block;
	list-style-type: none;
}
</style>

<script>
var headerTabScroll;
function assignheaderTabScroll() {
	$("div[data-iscrollId]").each(function() {
		var iscrollIds = $(this).attr('data-iscrollId');
		headerTabScroll = new IScroll('#'+iscrollIds, { 
		scrollX: true, 
		scrollY: false, 
		scrollbars: false,
		interactiveScrollbars: true,
		click: true,
		useTransition: false,
		bindToWrapper: true
	});
		if(headerTabScroll!=null){
			headerTabScroll.refresh();
		}
	});	 
	
	
	
}

function showRecords(){
	 $("li[data-default]").each(function() {
		   var initRecord = $(this).attr('data-default');     
           
		   if(initRecord=="start"){        	   
        	 var allOpenIds=   $(this).attr('data-currentSection');
        	 var list_ids = $(this).attr('data-ids');
        	 var currentSelection = allOpenIds.split(",");			
			 $("#"+list_ids).removeClass('defaultHeader');
	         $("#"+list_ids).addClass('activeHeader');
        	 
	         for(var p=0;p<currentSelection.length;p++){
        		var currentSingleId= currentSelection[p];        		
        		$('#'+currentSingleId).css('display','table');  
        	}     	
           }        
	});
	setHeightAndBase();		
}

function showClinicalTimeLine(){
	 $("div[data-str]").each(function() {
		 var titleValue = $(this).attr('data-str');		   
         var timerHRLine = $(this).height()-31;     
         $("#str_"+titleValue).height(timerHRLine); 
	});	 
	 $("div[data-num]").each(function() {
		 var titleValue = $(this).attr('data-num');
		 var timerHRLine = $(this).height()-31;
         $("#num_"+titleValue).height(timerHRLine); 
	});	
}

$(document).ready(function(){				
	$('.clinicalEventHTMLContainer').find('td').css({"vertical-align":"top"});
	showRecords();
	showClinicalTimeLine();
	assignheaderTabScroll();	
});

var previouslySelectedHeader="";

function onClickHeader(current){
    var all_ids = $(current).attr('data-allsection');
	var list_ids = $(current).attr('data-ids');
	var newValues = [];
	newValues = all_ids.split(',');
    	
	for(var i=0;i<newValues.length;i++){
		var currentIds = newValues[i];	
		$("#"+currentIds).css('display','none');			
		var string = currentIds,
          substring = "_list";        
		var checkString = string.indexOf(substring) > -1;
		
		if(!checkString){
		  $("#"+currentIds+"_list").removeClass('activeHeader');
		  $("#"+currentIds+"_list").addClass('defaultHeader');
		}
		
	}	
	var allOpenIds = $(current).attr('data-currentsection');
    var currentSelection = allOpenIds.split(",");
    
    for(var p=0;p<currentSelection.length;p++){
        var currentSingleId= currentSelection[p];		
		if(currentSingleId!=""){		
			$('#'+currentSingleId).css('display','table');  	
		}        
    }
    
    showClinicalTimeLine();
	CEMainScroll.refresh();	
	setHeightAndBase();

	if(previouslySelectedHeader != null && previouslySelectedHeader != ""){
		$("#"+previouslySelectedHeader).removeClass('activeHeader');
	    $("#"+previouslySelectedHeader).addClass('defaultHeader');
	}
		
	$("#"+list_ids).removeClass('defaultHeader');
	$("#"+list_ids).addClass('activeHeader');	
	previouslySelectedHeader = list_ids;
}

showRecords();

</script>
</html>