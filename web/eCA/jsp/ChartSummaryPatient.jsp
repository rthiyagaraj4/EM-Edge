<!DOCTYPE html>
<% 
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        	Description
-------------------------------------------------------------------------------------------------------------------------------------
?             	100            	?           	created
21/11/2012		IN035950		Nijitha			CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
												more appealing. Keeping the display of information more clear and visible.   
25/02/2013		IN035924	  	Karthi L	 	CA View chart summary "RESULT WIDGET" should come blank if patient visit hospital after 6 month or time interval defined by customer(CHL-CRF-018)												
19/06/2013		IN040958		Ramesh G		Widget icon - Pharmacy order, After "Release Rx", System does not refresh "View Chart Summary" screen.
24/10/2013		IN044492		Nijitha			SKR-SCF-0865
16/06/2014  	IN049663	 Nijitha		HSA_ADHOC_0010
-------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
03/11/2016		IN062250		Krishna Gowtham		03/11/2016		Ramesh G			GDOH-SCF-0216
10/01/2017		IN062564		Raja S			12/01/2017		Ramesh G			MO-GN-5511
01/11/2018  		IN063285                prathyusha                                      ML-MMOH-CRF-0757
29/06/2018		IN065341		Prakash C		29/06/2018		Ramesh G			MMS-DM--CRF-0115
18/12/2018   		IN067236      		 Sivabagyam M		18/12/2018		Ramesh G	   	ML-MMOH-CRF-1148
21/01/2019		IN068789		Prakash C		21/09/2019		Ramesh G			MMS-DM--CRF-0115.4
03/04/2019		IN069978        	Prakash C		03/04/2019		Ramesh G		MMS-ICN-00116
07/03/2022		27788			Ramesh Goli		07/03/2022		RAMESH G    	MMS-ME-SCF-0067
25/05/2022		31686			Pranay			25/05/2022		Ramesh G		NMC-JD-SCF-0287 
06/06/2022		31716			Pranay			06/06/2022		Ramesh G  		ML-BRU-SCF-2160
---------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,java.util.*,eCA.*,eCA.Common.*,org.apache.commons.codec.binary.Base64,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<!--GetPersistenceBean.jsp eCA.*,eCA.Common.* added for IN063285  -->
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<!-- //[IN035950]
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
-->
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>

async function showResults(queryString)
{
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "70vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "100";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
	retVal =await window.showModalDialog('../../eCA/jsp/ViewResults.jsp?'+queryString+'&modal_YN=Y',arguments,features);
}
//[IN035950] Start.
async function showFilteredData(retVal,widgetName){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "70vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
	if("High Risk"==widgetName || "Active Problems"==widgetName){
		window.open(retVal,"","height=700px,width=1000px,scrollbars=yes"); // IN035924
	}else{
	var retData = await top.window.showModalDialog(retVal,arguments,features);
	}
}
//IN065341 starts
async function showFilteredDataCDR(retVal,widgetName){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "70vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
	if("High Risk"==widgetName || "Active Problems"==widgetName){
		top.window.showModalDialog(retVal,arguments,features); // IN035924
	}else{
	var retData = await top.window.showModalDialog(retVal,arguments,features);
	}
}
//IN065341 ends
async function recordTransaction(fileName,queryString,widgetName){
	var dialogHeight	= "90vh" ;
	var dialogWidth		= "90vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
		
	if("Clinical Notes"==widgetName || "Social History"==widgetName || "Referral Summary"==widgetName){
		
	 var action_url ="../../eCA/jsp/RecClinicalNotesModal.jsp?"+queryString;
	 
	var title1="";

	var dialogHeight= "100vh";
	var dialogWidth	= "100vw";
	var status = "no";
	var arguments	= "";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; scroll=no; status:" + status;
	
	secondwindow  = await top.window.showModalDialog(action_url, title1, features);
	top.content.workAreaFrame.location.reload();
	
	
	//-------------------
	
	}else if("High Risk"==widgetName){//Removed Pending Schedule Condition for IN044492
		var retval = window.open(fileName+queryString,"",arguments,features);//IN038321	
	}
	//[IN038754] Start
	else if("Current Medications"==widgetName  ){//added Pending Schedule Condition for IN044492
		//[IN040958] Start.
		//window.open(fileName+queryString,'','left=100,top=100,width=1200,height=550,toolbar=0,resizable=0');
		var dialogHeight	= "90vh" ;
		var dialogWidth		= "90vw" ;
		var status			= "no";
		var scroll			= "yes";
		var dialogTop		= "";
		var arguments	= "";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
		
		var retData = await top.window.showModalDialog(fileName+queryString,arguments,features);		
		top.content.workAreaFrame.location.reload();		
		//[IN040958] End.
	}else if("Pending Schedules"==widgetName){
		var retVal = 	new String();
		var dialogHeight= "90vh" ;
		var dialogWidth = "90vw" ;
		var dialogTop 	= "";
		var center = "1" ;
		var status="no";
		var features	= "dialogHeight:" + dialogHeight + "; scroll=no; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop;
			
		retVal = await top.window.showModalDialog(fileName+queryString,arguments,features);
		
		if (retVal != null && retVal != "")
		{
			var returnVal = retVal.split("^");
			var mode = returnVal[0];
			h = returnVal[1];
			if (mode=="1")
			{
				 h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');					
				 retVal =await  top.window.showModalDialog("../../eOA/jsp/SinglePractVwNew.jsp?"+h,arguments,features);		
				 if (retVal=="OP")
					 recordTransaction(false);
			}
			else if (mode=="2")
			{
				 h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
				 retVal = await top.window.showModalDialog("../../eOA/jsp/MultiPract2VwMain.jsp?"+h,arguments,features);
				 if (retVal=="OP")
					recordTransaction(false);
			}
			else if (mode=="3")
			{
				h=h+ "&title="+getLabel("Common.bookappointment.label",'Common');
				retVal =await  top.window.showModalDialog("../../eOA/jsp/MultiPract3VwMain.jsp?"+h,arguments,features);
				if (retVal=="OP")
					recordTransaction(false);
			}

			if(retVal != null && retVal != "")
			{		
				if(retVal !="")
				{						
					recordTransaction(fileName,queryString,widgetName);
				}
			}
		}
		top.content.workAreaFrame.location.reload();
	
	}
	//[IN038754] End.
	else if("Allergies"==widgetName){
		var dialogHeight	= "90vh" ;
		var dialogWidth		= "90vw" ;
		var status			= "no";
		var scroll			= "yes";
		var dialogTop		= "";
		var arguments	= "";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
		
		var retData = await top.window.showModalDialog(fileName+queryString,arguments,features);	
		top.content.workAreaFrame.location.reload();
	}else{
	var retData =await  top.window.showModalDialog(fileName+queryString,arguments,features);
	//window.open(fileName+queryString,"",arguments,features);
	top.content.workAreaFrame.location.reload();
	}
	
	
}
function borderHighLite(obj){
	obj.className = 'borderhighlight';
}

function borderEnlight(obj){
	obj.className = '';
}

//[IN035950] End.
</script>
</head>
<TITLE></TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">
<%
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//IN062564 changes starts
	PreparedStatement pstmt5 = null;
	String clinicalIcon = "";
	//String fac_id = (String) session.getAttribute("facility_id");//IN065341
	String fac_id="";//IN065341
	String resp_id = (String)session.getValue("responsibility_id");
	ResultSet rs5 = null;
	//IN062564 changes ends
	String practitioner_id = null,patient_class = null;
	//String speciality_name=null; commented for checkstyle
	String speciality_code=null;//IN062250
	String patient_id=null;//Ramesh
	//IN062564 changes starts
	patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String relnId = request.getParameter("relationship_id") == null ? "" : request.getParameter("relationship_id"); 
	//IN062564 changes ends
	String encounter_id = "";//Ramesh
	String result_header = "";
	String result_header_icon =""; //[IN035950]
	ArrayList positionsList = new ArrayList();
	List<String> displayIconDtl = new ArrayList<String>(); //[IN035950]
	int temp =0,tempRowId=0,totalRows = 0, tempExists = 0,totalCols=0;
	float widthPerCell=0,heightPerCell=0, boxheight=0;
	//IN065341 starts
	String privilegeStatus="";
	String strSql="";
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	if(called_from.equals("CDR")){
		fac_id=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
		patient_class = request.getParameter("pat_class")==null?"EM":request.getParameter("pat_class");
	}else{//IN065341 ends
	   fac_id     =  (String)session.getValue("facility_id");
	   patient_class = request.getParameter("patient_class")==null?"EM":request.getParameter("patient_class"); 
		encounter_id= request.getParameter("encounter_id")==null?"":(String)request.getParameter("encounter_id");
	}
	//IN065341

		//added for IN063285 start
    String bean_id					= "CAChartSummaryPatientBean" ;
	String bean_name				= "eCA.CAChartSummaryPatientBean";
	CAChartSummaryPatientBean bean	= (CAChartSummaryPatientBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	String visit_id="";
	String episode_id="";
	boolean isClinician=false;//IN067236
	//added for IN063285  end
	//String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,CSCN.CONTENT_EXEC_NAME FROM CA_CHART_SUMM_DETAIL CSD,	CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_CONTENT CSCN WHERE CSD.SUMMARY_ID=CA_GET_SUMMARY_ID(?,?,?) AND CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID  ORDER BY CSD.ROW_POS,CSD.COL_POS";

//	String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,CSCN.CONTENT_EXEC_NAME FROM CA_CHART_SUMM_DETAIL CSD,	CA_CHART_SUMM_HEADER_LANG_VW CSH,CA_CHART_SUMM_CONTENT_LANG_VW CSCN, SM_MODULE M  WHERE CSD.SUMMARY_ID=CA_GET_SUMMARY_ID(?,?,?) AND CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID  AND CSH.LANGUAGE_ID = ? AND CSCN.LANGUAGE_ID = ? AND M.MODULE_ID = CSCN.MODULE_ID ORDER BY CSD.ROW_POS,CSD.COL_POS";
	//[IN035950] Start.
	
	//String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME, CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC FROM CA_CHART_SUMM_DETAIL CSD,	CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_CONTENT_LANG_VW CSCN, SM_MODULE M  WHERE CSH.SUMMARY_ID=CA_GET_SUMMARY_ID(?,?,?) AND CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID  AND  CSCN.LANGUAGE_ID = ? AND M.MODULE_ID = CSCN.MODULE_ID ORDER BY CSD.ROW_POS,CSD.COL_POS";
	//String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME, CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC,cscn.pref_chart_style,CSCN.CONTENT_ID FROM CA_CHART_SUMM_DETAIL CSD,	CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_CONTENT_LANG_VW CSCN, SM_MODULE M  WHERE CSH.SUMMARY_ID=CA_GET_SUMMARY_ID(?,?,?) AND CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID  AND  CSCN.LANGUAGE_ID = ? AND M.MODULE_ID = CSCN.MODULE_ID ORDER BY CSD.ROW_POS,CSD.COL_POS";
	//IN065341 starts
	//String strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME, CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC,ca_get_summary_style_id(?,?,?,CSD.SUMMARY_ID,CSD.CONTENT_ID) pref_chart_style,CSCN.CONTENT_ID FROM CA_CHART_SUMM_DETAIL CSD,	CA_CHART_SUMM_HEADER CSH,CA_CHART_SUMM_CONTENT_LANG_VW CSCN, SM_MODULE M  WHERE CSH.SUMMARY_ID=CA_GET_SUMMARY_ID(?,?,?) AND CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID  AND  CSCN.LANGUAGE_ID = ? AND M.MODULE_ID = CSCN.MODULE_ID ORDER BY CSD.ROW_POS,CSD.COL_POS";	  
	if(called_from.equals("CDR")){
		//strSql="SELECT distinct a.content_sysdef_desc title_content, a.content_exec_name,a.CONTENT_SYSDEF_DESC system_desc,ca_get_summary_style_id ##REPDB##(?,?,?,?,a.content_id) pref_chart_style, a.content_id FROM ca_chart_summ_content_lang_vw ##REPDB## a WHERE a.content_id IN (1, 2, 3, 6, 8, 9, 10, 13, 14, 16, 17, 18, 19, 20) AND language_id = ? order by title_content";//IN065341//COMMENTED FOR IN068789
		strSql="SELECT distinct a.content_sysdef_desc title_content, a.content_exec_name,a.CONTENT_SYSDEF_DESC system_desc,ca_get_summary_style_id ##REPDB##(?,?,?,?,a.content_id) pref_chart_style, a.content_id FROM ca_chart_summ_content_lang_vw ##REPDB## a WHERE a.content_id IN (1, 2, 3, 6,7, 8, 9, 10, 13, 14, 16, 17, 20) AND language_id = ? order by title_content";//IN068789//adding current medication widget removing social history, Health risk assessment widget//IN069978
	}else{	
		 strSql = "SELECT CSH.NO_OF_ROWS,CSH.NO_OF_COLS,CSD.ROW_POS,CSD.COL_POS,nvl(CSD.ROW_SPAN,'1') ROW_SPAN,nvl(CSD.COL_SPAN,'1') COL_SPAN,NVL(CSCN.CONTENT_USERDEF_DESC,CSCN.CONTENT_SYSDEF_DESC) TITLE_CONTENT,DECODE(M.INSTALL_YN,'Y',CSCN.CONTENT_EXEC_NAME,'N','../../eCA/jsp/blank.jsp') CONTENT_EXEC_NAME, CSCN.CONTENT_SYSDEF_DESC SYSTEM_DESC,ca_get_summary_style_id ##REPDB##(?,?,?,CSD.SUMMARY_ID,CSD.CONTENT_ID) pref_chart_style,CSCN.CONTENT_ID FROM CA_CHART_SUMM_DETAIL ##REPDB## CSD,	CA_CHART_SUMM_HEADER ##REPDB## CSH,CA_CHART_SUMM_CONTENT_LANG_VW ##REPDB## CSCN, SM_MODULE ##REPDB##M  WHERE CSH.SUMMARY_ID=CA_GET_SUMMARY_ID ##REPDB##(?,?,?) AND CSH.SUMMARY_ID=CSD.SUMMARY_ID AND CSD.CONTENT_ID=CSCN.CONTENT_ID  AND  CSCN.LANGUAGE_ID = ? AND M.MODULE_ID = CSCN.MODULE_ID ORDER BY CSD.ROW_POS,CSD.COL_POS";//IN065341
	}
	//String displayIconSql = "SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_CHARTSUM_CRITERIA_DTL  a,CA_CHARTSUM_CRITERIA_HDR b, ca_chart_summ_content c WHERE a.sum_criteria_id = b.sum_criteria_id and  b.content_id = c.content_id  AND c.content_id = ? order by to_number (a.sum_sl_no) desc";
	String displayIconSql = "SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_CHARTSUM_CRITERIA_DTL ##REPDB## a,CA_CHARTSUM_CRITERIA_HDR ##REPDB## b, ca_chart_summ_content ##REPDB## c WHERE a.sum_criteria_id = b.sum_criteria_id and  b.content_id = c.content_id  AND c.content_id = ? order by to_number (a.sum_sl_no) desc";//IN065341
//IN065341 ends	
	
	StringBuilder sblQry = new StringBuilder();
	//sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN FROM CA_WIDGET_PARAM where MODULE_ID=? ");
	sblQry.append("SELECT MODULE_ID,WIDGET_THEME_ICON_YN,WIDGET_THEME_YN,WIDGET_ICON_YN FROM CA_WIDGET_PARAM ##REPDB## where MODULE_ID=? ");
	//[IN035950] End.
	practitioner_id = (String)session.getValue("ca_practitioner_id");
	if(practitioner_id == null) practitioner_id="";
	
	//patient_class = request.getParameter("patient_class")==null?"EM":request.getParameter("patient_class");commented for IN065341
	//has to be changed after checking with rajan
	//IN062250 Start
	//speciality_name = request.getParameter("location_code")==null?"":request.getParameter("location_code");
	speciality_code = request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");
	//IN062250 End
	//out.println(strSql);
	//Ramesh Start.
	//encounter_id= request.getParameter("encounter_id")==null?"":(String)request.getParameter("encounter_id");commented for IN065341
	//IN063285 Start
	visit_id= request.getParameter("visit_id")==null ?"":(String)request.getParameter("visit_id");
	if(patient_class.equals("OP") || patient_class.equals("EM"))
	{
		if(visit_id.equals(""))
		visit_id = "1";
		
		episode_id= request.getParameter("episode_id_new")==null?"":(String)request.getParameter("episode_id_new");
	}else
		{
		episode_id= request.getParameter("episode_id")==null?"":(String)request.getParameter("episode_id");
		}
	//IN063285 ends
	//Ramesh Ends.
	HashMap<String, String> prefChartStyleMap = new HashMap<String, String>();//[IN035950]
	boolean finacial_dtl_req_yn=false;//IN063285
%>
</HEAD>
<BODY class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()'>
<!-- <table width='100%' height='100%' align='center'> IN035950 -->
 <table width='100%' height='100%' align='center'  border='0' cellspacing='1' cellpadding='3' >
<%
	try{
		con = ConnectionManager.getConnection(request);
		finacial_dtl_req_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","FINACIAL_DTL_REQ_YN");//added for IN063285
		isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
	//IN065341 starts	
		strSql=strSql.replaceAll("##REPDB##",RepDb);
		pstmt = con.prepareStatement(strSql);
		
		if(called_from.equals("CDR")){
			pstmt.setString(1,speciality_code);
			pstmt.setString(2,patient_class);
			pstmt.setString(3,practitioner_id);
			pstmt.setString(4,"");
			pstmt.setString(5,locale);
		}else{//IN065341 ends
				//IN062250 Start
				//pstmt.setString(1,speciality_name);
				pstmt.setString(1,speciality_code);
				//IN062250 End
				pstmt.setString(2,patient_class);
				pstmt.setString(3,practitioner_id);			
				//pstmt.setString(3,practitioner_id);.
				
			//	pstmt.setString(4,locale);		
				//IN062250 Start
				//pstmt.setString(4,speciality_name);
				pstmt.setString(4,speciality_code);
				//IN062250 End
				pstmt.setString(5,patient_class);
				pstmt.setString(6,practitioner_id);
				pstmt.setString(7,locale);
		}
		rs = pstmt.executeQuery();
	//IN065341 starts	
		int c=1;
		int d=1;
		int cols=0;
		String span="1";
	//IN065341 ends	
		while(rs.next()){
			
			//IN065341 starts
			if(called_from.equals("CDR")){
				if(d==5){
					c++;
					cols=d-1;		
					d=1;
				}
					positionsList.add(String.valueOf(c));//row pos
					positionsList.add(String.valueOf(d++));//col pos		
					positionsList.add(span); //ROW_SPAN
					positionsList.add(span); //COL_SPAN
					positionsList.add(rs.getString(1)); //TITLE_CONTENT
					positionsList.add(rs.getString(2)); //CONTENT_EXEC_NAME 	
					positionsList.add(rs.getString(3)); //SYSTEM_DESC 	
					positionsList.add(rs.getString(5));//CONTENT_ID 
					prefChartStyleMap.put(rs.getString(2), rs.getString(4));

		}else{//IN065341 ends
			
				totalRows = rs.getInt(1); //NO_OF_ROWS
				totalCols = rs.getInt(2); //NO_OF_COLS
				
				positionsList.add(rs.getString(3)); //ROW_POS
				positionsList.add(rs.getString(4)); //COL_POS
				positionsList.add(rs.getString(5)); //ROW_SPAN
				positionsList.add(rs.getString(6)); //COL_SPAN
				positionsList.add(rs.getString(7)); //TITLE_CONTENT
				positionsList.add(rs.getString(8)); //CONTENT_EXEC_NAME 	
				positionsList.add(rs.getString(9)); //SYSTEM_DESC 	
				//[IN035950] Start.
				positionsList.add(rs.getString(11));//CONTENT_ID 
				prefChartStyleMap.put(rs.getString(8), rs.getString(10));
				//[IN035950] End.
			}
		}
		
		if(rs!=null)rs.close();		//Checkstyle 4.0 Beta 6
		if(pstmt!=null)pstmt.close();	//Checkstyle 4.0 Beta 6
	//IN065341 starts	
		if(called_from.equals("CDR")){
			widthPerCell = 100/cols;
			heightPerCell = 100/c;
				totalRows=c;//NO_OF_ROWS
			totalCols=cols;//NO_OF_COLS
		}else{
	//IN065341 ends
			if(totalRows ==0){
				//out.println("<script>alert('Chart Summary Master Setup not available for this Login.');</script>");
				out.flush();
				return;
			}
			widthPerCell = 100/totalCols;
			//heightPerCell = 158/totalRows;
			heightPerCell = 100/totalRows;
		}//IN065341

//		out.println("per cell width="+widthPerCell+" heightPerCell="+heightPerCell);

		tempExists = 0;
		//[IN035950] Start.
		//String classNameHeader = ""; //Checkstyle 4.0 Beta 6
		String styleSheetName ="";
		String fileName ="";
		String contentID = "";
		//String icons="";	 //Checkstyle 4.0 Beta 6
		String iconsWidth="30%";
		String titleWidth="70%";
		int iconsCount=0;
		String widgetThemeIconIndicator="";
		String widgetThemeIndicator="";
		String widgetIconIndicator="";
		//IN065341 starts
		//pstmt = con.prepareStatement(sblQry.toString());
		String result=sblQry.toString();
		result=result.replaceAll("##REPDB##",RepDb);
		pstmt = con.prepareStatement(result);
		//IN065341 ends
		pstmt.setString(1,"CA");
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			widgetThemeIconIndicator = rs.getString("WIDGET_THEME_ICON_YN");
			widgetThemeIndicator = rs.getString("WIDGET_THEME_YN");
			widgetIconIndicator = rs.getString("WIDGET_ICON_YN");
		}
		if(rs!=null)rs.close();		//Checkstyle 4.0 Beta 6
		if(pstmt!=null)pstmt.close();	//Checkstyle 4.0 Beta 6
		//[IN035950] End.
		for(int k=1;k<=totalRows;k++){
			//[IN035950] Start.
			//for(int i=0;i<positionsList.size();i+=7){
			for(int i=0;i<positionsList.size();i+=8){				
				fileName = (String)positionsList.get(i+5);
				if(fileName!="" && prefChartStyleMap.containsKey(fileName)){
					styleSheetName = prefChartStyleMap.get(fileName);
					if(null!=styleSheetName && !"null".equals(styleSheetName) && styleSheetName!="" && "Y".equals(widgetThemeIconIndicator) && "Y".equals(widgetThemeIndicator)){
						out.println("<link rel='StyleSheet' href='../../eCommon/html/"+styleSheetName+"' type='text/css' />");
						contentID = (String)positionsList.get(i+7);
					}else{
						contentID="";
					 	out.println("<link rel='StyleSheet' href='../../eCommon/html/"+sStyle+"' type='text/css' />");
						styleSheetName=sStyle;
					}
				}
				//[IN035950] End.
				temp = Integer.parseInt((String)positionsList.get(i));
				if(k==temp){
					result_header = (String)positionsList.get(i+4);
					//[IN035950] Start.						
					try{
						//IN062564 changes starts
						if("16".equals(positionsList.get(i+7)))
						{
						 try{
						//IN065341 starts
							//String privilegeStatus="";
							//pstmt5 = con.prepareStatement("SELECT DFLT_PRIVILEGE_STATUS FROM CA_APPL_TASK  WHERE APPL_TASK_ID='FLOW_SHEET'");
							String sql1="SELECT DFLT_PRIVILEGE_STATUS FROM CA_APPL_TASK ##REPDB## WHERE APPL_TASK_ID='FLOW_SHEET'";
							sql1=sql1.replaceAll("##REPDB##",RepDb);
							pstmt5 = con.prepareStatement(sql1);
						//IN065341 ends
							rs5 = pstmt5.executeQuery();
							while(rs5.next()){
								privilegeStatus=rs5.getString("DFLT_PRIVILEGE_STATUS");
							}
							//clinicalIcon="SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_CHARTSUM_CRITERIA_DTL a,CA_CHARTSUM_CRITERIA_HDR b, ca_chart_summ_content c WHERE a.sum_criteria_id = b.sum_criteria_id and  b.content_id = c.content_id  AND c.content_id = ? and 'A'=Get_Task_Applicability('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+fac_id+"','"+encounter_id+"','"+patient_id+"') order by to_number (a.sum_sl_no) desc";
							clinicalIcon="SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_CHARTSUM_CRITERIA_DTL ##REPDB## a,CA_CHARTSUM_CRITERIA_HDR ##REPDB## b, ca_chart_summ_content ##REPDB## c WHERE a.sum_criteria_id = b.sum_criteria_id and a.image_icon_file!='Max1.png' and  b.content_id = c.content_id  AND c.content_id = ? and 'A'=Get_Task_Applicability ##REPDB##('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+fac_id+"','"+encounter_id+"','"+patient_id+"') order by to_number (a.sum_sl_no) desc";//IN065341
						    }
							catch(Exception e)
							{
								System.out.println("Error while getting the fetching defualt privilege Table: "+e);
							}
							finally
							{
								if(pstmt5!=null)pstmt5.close();
								if(rs5!=null)rs5.close();
							}
						}
						
						
					//IN065341 starts	
						if(called_from.equals("CDR")){
							if("16".equals(positionsList.get(i+7))){
								privilegeStatus="A";
							
								clinicalIcon="SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_CHARTSUM_CRITERIA_DTL ##REPDB## a,CA_CHARTSUM_CRITERIA_HDR ##REPDB## b, ca_chart_summ_content ##REPDB## c WHERE a.sum_criteria_id = b.sum_criteria_id AND a.image_icon_file='Max1.png' and  b.content_id = c.content_id  AND c.content_id = ? and 'A'=Get_Task_Applicability##REPDB##('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+fac_id+"','"+encounter_id+"','"+patient_id+"') order by to_number (a.sum_sl_no) desc";//IN065341
								clinicalIcon=clinicalIcon.replaceAll("##REPDB##",RepDb);//IN065341
								pstmt = con.prepareStatement(clinicalIcon);
							}
							//else if(("14".equals(positionsList.get(i+7)))||("19".equals(positionsList.get(i+7)))||("17".equals(positionsList.get(i+7)))) COMMENTED FOR IN068789
							else if(("14".equals(positionsList.get(i+7)))||("19".equals(positionsList.get(i+7)))||("17".equals(positionsList.get(i+7)))||("7".equals(positionsList.get(i+7))))//IN068789 adding new widget
							{
								privilegeStatus="A";
							
								//clinicalIcon="SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_CHARTSUM_CRITERIA_DTL ##REPDB## a,CA_CHARTSUM_CRITERIA_HDR ##REPDB## b, ca_chart_summ_content ##REPDB## c WHERE a.sum_criteria_id = b.sum_criteria_id AND a.image_icon_file='Max.png' and  b.content_id = c.content_id  AND c.content_id = ? and 'A'=Get_Task_Applicability##REPDB##('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+fac_id+"','"+encounter_id+"','"+patient_id+"') order by to_number (a.sum_sl_no) desc";//IN065341	
								clinicalIcon="SELECT a.IMAGE_ICON_ALIGN IMAGE_ICON_ALIGN , b.NO_OF_MENU NO_OF_MENU,b.content_id content_id , a.image_icon_file image_icon_file, a.comp_exe_name comp_exe_name, a.comp_exe_tooltip comp_exe_tooltip,a.ADDL_CRITERIA_PARAM ADDL_CRITERIA_PARAM FROM CA_CHARTSUM_CRITERIA_DTL ##REPDB## a,CA_CHARTSUM_CRITERIA_HDR ##REPDB## b, ca_chart_summ_content ##REPDB## c WHERE a.sum_criteria_id = b.sum_criteria_id AND a.image_icon_file IN('Max.png','DrugProfile.PNG') and  b.content_id = c.content_id  AND c.content_id = ? and 'A'=Get_Task_Applicability##REPDB##('FLOW_SHEET','"+privilegeStatus+"' ,'"+resp_id+"','"+relnId+"','"+fac_id+"','"+encounter_id+"','"+patient_id+"') order by to_number (a.sum_sl_no) desc";//IN068789
								clinicalIcon=clinicalIcon.replaceAll("##REPDB##",RepDb);//IN065341
								pstmt = con.prepareStatement(clinicalIcon);
							}else{
								displayIconSql=displayIconSql.replaceAll("##REPDB##",RepDb);
								pstmt = con.prepareStatement(displayIconSql);
							}
								
						}else{//IN065341 ends	
							if("16".equals(positionsList.get(i+7))){
								clinicalIcon=clinicalIcon.replaceAll("##REPDB##",RepDb);//IN065341
								pstmt = con.prepareStatement(clinicalIcon);
							}
							else
							{
								displayIconSql=displayIconSql.replaceAll("##REPDB##",RepDb);//IN065341
								pstmt = con.prepareStatement(displayIconSql);
							}
						}//IN065341	
						//IN062564 changes Ends
						
						//pstmt = con.prepareStatement(displayIconSql); //commented for IN062564
						pstmt.setString(1,(String)positionsList.get(i+7));
					
						rs = pstmt.executeQuery();
						//HashMap hashMap1 = new HashMap(); //Checkstyle 4.0 Beta 6
						while(rs.next()){
							displayIconDtl.add(rs.getString("content_id"));
							displayIconDtl.add(rs.getString("image_icon_file"));
							displayIconDtl.add(rs.getString("comp_exe_name"));
							displayIconDtl.add(rs.getString("comp_exe_tooltip"));
							displayIconDtl.add(rs.getString("NO_OF_MENU"));
							displayIconDtl.add(rs.getString("ADDL_CRITERIA_PARAM"));
							displayIconDtl.add(rs.getString("IMAGE_ICON_ALIGN"));
						}
						
						if(rs!=null)rs.close();		//Checkstyle 4.0 Beta 6
						if(pstmt!=null)pstmt.close();	//Checkstyle 4.0 Beta 6
					
						String queryString = "";
						if("Active Problems".equals((String)positionsList.get(i+6))){
							iconsWidth ="10%";
							titleWidth="90%";
						}
						//[IN035950] End.
					
						if(!called_from.equals("CDR")){//IN065341
							if(((String)positionsList.get(i+6)).equals("Results"))
							result_header = "<a href='javascript:showResults(\""+request.getQueryString()+"\")' title='Click here to view the result'>"+result_header+"</a>";
						}//IN065341
						//if(((String)positionsList.get(i+6)).equals("Referral Information"))
						//result_header = "<a style='color:ffffff' href='javascript:showRefinfo(\""+request.getQueryString()+"\",\""+Ref_loc+"\")' title='Click here to view the Referral Information'>"+result_header+"</a>";	
						//[IN035950] Start.					
						for(int cnt=0;cnt<displayIconDtl.size();cnt+=7)
						{
							if(isClinician && displayIconDtl.get(cnt+3).equals("Clinician Notes")){//IN067236
								//displayIconDtl.set(10, "Therapist Notes");//IN067236
								displayIconDtl.set(17, "Therapist Notes");
							}
							if(""!=displayIconDtl.get(cnt+1) && null!=displayIconDtl.get(cnt+1) && "L".equals(displayIconDtl.get(cnt+6)) && "Y".equals(widgetIconIndicator))
							{						
								queryString =request.getQueryString()+displayIconDtl.get(cnt+5);
							/*if(((String)positionsList.get(i+6)).equals("Encounters") || ((String)positionsList.get(i+6)).equals("Events Occured in last 24 hrs") || ((String)positionsList.get(i+6)).equals("Results") || ((String)positionsList.get(i+6)).equals("Referral Information"))
							{
							result_header =	"<img  src='../../eCA/images/"+displayIconDtl.get(cnt+1)+"' align='left'/>"+result_header;
							}
							else{*/
							//CHL-CRF Start.
							//result_header =	"<a href='javascript:recordTransaction(\""+displayIconDtl.get(cnt+2)+"?"+"\",\""+queryString+"&title="+displayIconDtl.get(cnt+3)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(cnt)+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(cnt+3)+"'><img src='../../eCA/images/"+displayIconDtl.get(cnt+1)+"' align='left'/></a>"+result_header;
							
							if(!"".equals(encounter_id)){
								result_header =	"<a style='color:ffffff' href='javascript:recordTransaction(\""+displayIconDtl.get(cnt+2)+"?"+"\",\""+queryString+"&title="+displayIconDtl.get(cnt+3)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(cnt)+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(cnt+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(cnt+1)+"' align='left'/></a>"+result_header;
							}
							//CHL-CRF End.
							
							//}
							
							}
						}
					
						if(!displayIconDtl.isEmpty() && displayIconDtl.size() > 0){
							for(int j=0;j<displayIconDtl.size();j+=7){
								//queryString =	request.getQueryString()+"&order_category="+"LB";
								//IN065341 starts
								String newTempString="&patient_class="+(String)request.getParameter("patient_class");
								if(displayIconDtl.get(j+5)!=null){
									queryString =request.getQueryString()+displayIconDtl.get(j+5);//existing code
									newTempString=newTempString+displayIconDtl.get(j+5);
								}else{
									queryString =request.getQueryString();
								}
								//IN065341 ends
								if(null!=displayIconDtl.get(j+1) && ""!=displayIconDtl.get(j+2) && "R".equals(displayIconDtl.get(j+6)) && "Y".equals(widgetIconIndicator)){
									iconsCount++;
									//result_header_icon ="<img src='../../eCA/images/"+displayIconDtl.get(j+1)+"' onClick='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+queryString+"&title="+positionsList.get(i+4)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"\")' title='"+displayIconDtl.get(j+3)+"'/>";						
									//CHL-CRF Start.[Ramesh]
										//result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+queryString+"&title="+displayIconDtl.get(j+3)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
									//IN065341 starts	
										if(called_from.equals("CDR") && ((positionsList.get(i+6).equals("High Risk"))||(positionsList.get(i+6).equals("Active Problems"))))
										{
											//27788 Start.
											if("../../eCA/jsp/ChartSummaryResultsMainD.jsp".equals(displayIconDtl.get(j+2)) || "../../eCA/jsp/ChartSummaryResultsMain.jsp".equals(displayIconDtl.get(j+2)) ){
												String parameterStringValues="option_id="+(String)request.getParameter("option_id")+"&locale="+(String)request.getParameter("locale")+"&patient_id="+(String)request.getParameter("patient_id")+"&encounter_id="+(String)request.getParameter("encounter_id")+"&enc_id1="+(String)request.getParameter("enc_id1")+"&facility_id1="+(String)request.getParameter("facility_id1")+"&limit_function_id="+(String)request.getParameter("limit_function_id")+"&relationship_id="+(String)request.getParameter("relationship_id")+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"&called_from="+called_from+"&RepDb="+RepDb+"&clob_data="+clob_data;
												byte[] parEncode = Base64.encodeBase64(parameterStringValues.getBytes());
												result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredDataCDR(\""+displayIconDtl.get(j+2)+"?"+"&parameterStringValues="+new String(parEncode)+"&title="+displayIconDtl.get(j+3)+newTempString+"&compressed=Y"+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
											}else if("../../ePH/jsp/ChartSummaryCurrentMedications.jsp".equals(positionsList.get(i+5))){
												byte[] patientIdEncode=Base64.encodeBase64(((String)request.getParameter("patient_id")).getBytes());
												byte[] encounterIdEncode=Base64.encodeBase64(((String)request.getParameter("encounter_id")).getBytes());
												String enc_id1=(String)request.getParameter("enc_id1");
												//31686 Start
												//result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredDataCDR(\""+displayIconDtl.get(j+2)+"?"+"&patient_id="+new String(patientIdEncode)+"&encounter_id="+new String(encounterIdEncode)+"&content_ID="+displayIconDtl.get(j)+"&called_from="+called_from+"&RepDb="+RepDb+"&title="+displayIconDtl.get(j+3)+"&p_called_from_widget=CURRENT_MEDICATION"+"&compressed=Y"+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
												  result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredDataCDR(\""+displayIconDtl.get(j+2)+"?"+"&patient_id="+new String(patientIdEncode)+"&encounter_id="+new String(encounterIdEncode)+"&content_ID="+displayIconDtl.get(j)+newTempString+"&compressed=Y&called_from="+called_from+"&called_frm="+called_from+"&enc_id1="+enc_id1+"&RepDb="+RepDb+"&clob_data="+clob_data+"&title="+displayIconDtl.get(j+3)+"&p_called_from_widget=CURRENT_MEDICATION"+"&compressed=Y"+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
												//31686 End.
											}else{
												//27788 End.
												result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredDataCDR(\""+displayIconDtl.get(j+2)+"?"+queryString+"&title="+displayIconDtl.get(j+3)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
											}//27788
										}
										else{
											//27788 Start.
											if("../../eCA/jsp/ChartSummaryResultsMainD.jsp".equals(displayIconDtl.get(j+2)) || "../../eCA/jsp/ChartSummaryResultsMain.jsp".equals(displayIconDtl.get(j+2)) ){
												String parameterStringValues="option_id="+(String)request.getParameter("option_id")+"&locale="+(String)request.getParameter("locale")+"&patient_id="+(String)request.getParameter("patient_id")+"&encounter_id="+(String)request.getParameter("encounter_id")+"&enc_id1="+(String)request.getParameter("enc_id1")+"&facility_id1="+(String)request.getParameter("facility_id1")+"&limit_function_id="+(String)request.getParameter("limit_function_id")+"&relationship_id="+(String)request.getParameter("relationship_id")+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"&called_from="+called_from+"&RepDb="+RepDb+"&clob_data="+clob_data;
												byte[] parEncode = Base64.encodeBase64(parameterStringValues.getBytes());
												result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+"&parameterStringValues="+new String(parEncode)+"&title="+displayIconDtl.get(j+3)+"&compressed=Y"+newTempString+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
											}else if("../../ePH/jsp/ChartSummaryCurrentMedications.jsp".equals(positionsList.get(i+5))){												System.out.println("-------645------->"+displayIconDtl.get(j+2));
											
												byte[] patientIdEncode=Base64.encodeBase64(((String)request.getParameter("patient_id")).getBytes());
												byte[] encounterIdEncode=Base64.encodeBase64(((String)request.getParameter("encounter_id")).getBytes());
												String enc_id1=(String)request.getParameter("enc_id1");
												//31686 Start
												//result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+"&patient_id="+new String(patientIdEncode)+"&encounter_id="+new String(encounterIdEncode)+"&content_ID="+displayIconDtl.get(j)+"&p_called_from_widget=CURRENT_MEDICATION"+"&called_from="+called_from+"&RepDb="+RepDb+"&title="+displayIconDtl.get(j+3)+"&compressed=Y"+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
												result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+"&patient_id="+new String(patientIdEncode)+"&encounter_id="+new String(encounterIdEncode)+"&content_ID="+displayIconDtl.get(j)+newTempString+"&compressed=Y&p_called_from_widget=CURRENT_MEDICATION"+"&called_from="+called_from+"&called_frm="+called_from+"&enc_id1="+enc_id1+"&RepDb="+RepDb+"&clob_data="+clob_data+"&title="+displayIconDtl.get(j+3)+"&compressed=Y"+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
												//31686 End.
											}else{
												//27788 End.
												result_header_icon = result_header_icon+"<a style='color:ffffff' href='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+queryString+"&title="+displayIconDtl.get(j+3)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"\",\""+(String)positionsList.get(i+6)+"\")' title='"+displayIconDtl.get(j+3)+"'><img style='color:ffffff' src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
											} //27788
										}
									//IN065341 ends
									//CHL-CRF End.[Ramesh]
								}
								//result_header =result_header+"<a href='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+queryString+"&title="+positionsList.get(i+4)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"\")' title='"+displayIconDtl.get(j+3)+"'><img src='../../eCA/images/"+displayIconDtl.get(j+1)+"' align='right'/></a>";
								//result_header =result_header+"<img src='../../eCA/images/"+displayIconDtl.get(j+1)+"' onClick='javascript:showFilteredData(\""+displayIconDtl.get(j+2)+"?"+queryString+"&title="+positionsList.get(i+4)+"&prefStyle="+styleSheetName+"&content_ID="+displayIconDtl.get(j)+"\")' title='"+displayIconDtl.get(j+3)+"'>";
							}
						/*
							if(iconsCount == 6 || iconsCount == 4)
							{
								iconsWidth ="40%";
								titleWidth="60%";
							}else if(iconsCount > 6)
							{
						*/		
								iconsWidth ="50%";
								titleWidth="50%";
						//	}
						}					
					
						displayIconDtl.clear();//[IN035950]
						iconsCount=0;//[IN035950]
					}
					catch(Exception e){
						e.printStackTrace();
					}
					//[IN035950] End.
					
					tempExists++;
					//out.println((heightPerCell*(Float.parseFloat((String)positionsList.get(i+2)))));
					boxheight=100-(300/(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2)))));
//					out.println(boxheight);
					//IN049663 Starts
					String queryStringval = request.getQueryString();
					if(((String)positionsList.get(i+6)).equals("Encounters")) 
					{
						 queryStringval = queryStringval+"&p_called_from_widget=CA_CLINICIAN_WIDGET";
					}
					//IN049663 Ends
					if(tempRowId == 0){
						out.println("<tr>");						
						//[IN035950] Start.
						//out.println("<td  colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%'><tr><td class='COLUMNHEADERCENTER'>"+result_header+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"?"+request.getQueryString()+"&title="+positionsList.get(i+4)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='"+boxheight+"%'  ></iframe></td>");
							out.println("<td class='borderhighlight"+contentID+"' colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' border='0' cellspacing='0' cellpadding='0'><tr><td width='70%' class='COLUMNHEADERCENTERNEW"+contentID+"'>"+result_header+"</td><td width='30%' class='COLUMNHEADERCENTERNEW"+contentID+"' align='right'>"+result_header_icon+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"?"+queryStringval+"&title="+positionsList.get(i+4)+"&prefStyle="+styleSheetName+"&content_ID="+positionsList.get(i+7)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='"+boxheight+"%'  ></iframe></td>");//IN049663
						
						//[IN035950] End.
						tempRowId = temp;
					}else{
						if(tempRowId == temp){						
							//27788 Start.
							if("../../eCA/jsp/ChartSummaryResultsD.jsp".equals(positionsList.get(i+5)) || "../../eCA/jsp/ChartSummaryResults.jsp".equals(positionsList.get(i+5)) ){
								
								out.println("<td  class='borderhighlight"+contentID+"' colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' border='0' cellspacing='0' cellpadding='0' ><tr><td width='"+titleWidth+"' class='COLUMNHEADERCENTERNEW"+contentID+"' nowrap>"+result_header+"</td><td width='"+iconsWidth+"' align='right' class='COLUMNHEADERCENTERNEW"+contentID+"'>"+result_header_icon+"</td></tr></table>");
									
								if("../../eCA/jsp/ChartSummaryResultsD.jsp".equals(positionsList.get(i+5)))
									out.println("<form id='resultForm' target='myFrame'  action='../../eCA/jsp/ChartSummaryResultsD.jsp' method='POST'>");
								else if("../../eCA/jsp/ChartSummaryResults.jsp".equals(positionsList.get(i+5)))
									out.println("<form id='resultForm' target='myFrame'  action='../../eCA/jsp/ChartSummaryResults.jsp' method='POST'>");
									
								
								out.println("<input type='hidden' name='option_id' id='option_id' value='"+(String)request.getParameter("option_id")+"' />");
								out.println("<input type='hidden' name='locale' id='locale' value='"+(String)request.getParameter("locale")+"' />");
								out.println("<input type='hidden' name='patient_id' id='patient_id' value='"+(String)request.getParameter("patient_id")+"' />");
								out.println("<input type='hidden' name='encounter_id' id='encounter_id' value='"+(String)request.getParameter("encounter_id")+"' />");
								out.println("<input type='hidden' name='limit_function_id' id='limit_function_id' value='"+(String)request.getParameter("limit_function_id")+"' />");
								out.println("<input type='hidden' name='relationship_id' id='relationship_id' value='"+(String)request.getParameter("relationship_id")+"' />");
								out.println("<input type='hidden' name='title' id='title' value='"+positionsList.get(i+4)+"' />");
								out.println("<input type='hidden' name='prefStyle' id='prefStyle' value='"+styleSheetName+"' />");
								out.println("<input type='hidden' name='content_ID' id='content_ID' value='"+positionsList.get(i+7)+"' />");
								out.println("<input type='hidden' name='called_from' id='called_from' value='"+called_from+"' />");								
								out.println("<input type='hidden' name='RepDb' id='RepDb' value='"+RepDb+"' />");
								out.println("<input type='hidden' name='clob_data' id='clob_data' value='"+clob_data+"' />");
								out.println("<input type='hidden' name='enc_id1' id='enc_id1' value='"+(String)request.getParameter("enc_id1")+"' />");
								out.println("<input type='hidden' name='facility_id1' id='facility_id1' value='"+(String)request.getParameter("facility_id1")+"' />");
								out.println("<input type='submit'>");
								out.println("</form>");

								out.println("<iframe name='myFrame' src='#' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='"+boxheight+"%' >");
								out.println("Your browser does not support inline frames.");
								out.println("</iframe>");
										
								out.println("<script>");
									out.println("var resultForm= document.getElementById('resultForm');");
									out.println("resultForm.style.display = 'none';");
									out.println("resultForm.submit();");
								out.println("</script>");
								out.println("&nbsp;</td>");
							}else if("../../ePH/jsp/ChartSummaryCurrentMedications.jsp".equals(positionsList.get(i+5))){
								out.println("<td  class='borderhighlight"+contentID+"' colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' border='0' cellspacing='0' cellpadding='0' ><tr><td width='"+titleWidth+"' class='COLUMNHEADERCENTERNEW"+contentID+"' nowrap>"+result_header+"</td><td width='"+iconsWidth+"' align='right' class='COLUMNHEADERCENTERNEW"+contentID+"'>"+result_header_icon+"</td></tr></table>");
								out.println("<form id='currentMedicationForm' target='currentMedicationFrame'  action='../../ePH/jsp/ChartSummaryCurrentMedications.jsp' method='POST'>");
								
								out.println("<input type='hidden' name='prefStyle' id='prefStyle' value='"+styleSheetName+"' />");
								out.println("<input type='hidden' name='content_ID' id='content_ID' value='"+positionsList.get(i+7)+"' />");
								out.println("<input type='hidden' name='patient_id' id='patient_id' value='"+(String)request.getParameter("patient_id")+"' />");
								out.println("<input type='hidden' name='encounter_id' id='encounter_id' value='"+(String)request.getParameter("encounter_id")+"' />");
								out.println("<input type='hidden' name='called_from' id='called_from' value='"+called_from+"' />");
								out.println("<input type='hidden' name='RepDb' id='RepDb' value='"+RepDb+"' />");
								out.println("<input type='hidden' name='clob_data' id='clob_data' value='"+clob_data+"' />");
								out.println("<input type='hidden' name='enc_id1' id='enc_id1' value='"+(String)request.getParameter("enc_id1")+"' />");
								//out.println("<input type='hidden' name='p_called_from_widget' id='p_called_from_widget' value='CURRENT_MEDICATION' />"); //Commented for 31716  
								
								out.println("</form>");

								out.println("<iframe name='currentMedicationFrame' src='#' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='"+boxheight+"%' >");
								out.println("Your browser does not support inline frames.");
								out.println("</iframe>");
										
								out.println("<script>");
									out.println("var currentMedicationForm= document.getElementById('currentMedicationForm');");
									out.println("currentMedicationForm.style.display = 'none';");
									out.println("currentMedicationForm.submit();");
								out.println("</script>");
								out.println("&nbsp;</td>");
							}else{
								//27788 End.
								out.println("<td  class='borderhighlight"+contentID+"' colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' border='0' cellspacing='0' cellpadding='0' ><tr><td width='"+titleWidth+"' class='COLUMNHEADERCENTERNEW"+contentID+"' nowrap>"+result_header+"</td><td width='"+iconsWidth+"' align='right' class='COLUMNHEADERCENTERNEW"+contentID+"'>"+result_header_icon+"</td></tr></table><iframe src='"+positionsList.get(i+5)+"?"+queryStringval+"&title="+positionsList.get(i+4)+"&prefStyle="+styleSheetName+"&content_ID="+positionsList.get(i+7)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='"+boxheight+"%'  ></iframe></td>");//IN049663
							} //27788
							tempRowId = temp;
						}else{
							out.println("</tr><tr>");
							out.println("<td class='borderhighlight"+contentID+"' colspan="+positionsList.get(i+3)+" rowspan="+positionsList.get(i+2)+" WIDTH='"+(widthPerCell*(Float.parseFloat((String)positionsList.get(i+3))))+"%' HEIGHT='"+(heightPerCell*(Float.parseFloat((String)positionsList.get(i+2))))+"%'><table width='100%' border='0'  cellspacing='0' cellpadding='0'><tr><td width='"+titleWidth+"' class='COLUMNHEADERCENTERNEW"+contentID+"' nowrap>"+result_header+"</td><td width='"+iconsWidth+"' align='right' class='COLUMNHEADERCENTERNEW"+contentID+"'>"+result_header_icon+"</td></tr></table><iframe   src='"+positionsList.get(i+5)+"?"+queryStringval+"&title="+positionsList.get(i+4)+"&prefStyle="+styleSheetName+"&content_ID="+positionsList.get(i+7)+"' frameborder='0' scrolling='auto'  MARGINWIDTH='0px' MARGINHEIGHT='0px' width='100%' height='"+boxheight+"%'  ></iframe></td>");//IN049663
							tempRowId = temp;									
						}
					}
					result_header_icon =""; //[IN035950]
					iconsWidth="30%";//[IN035950]
					titleWidth="70%";
				}//end of k==temp
			}//end of for loop rowpositions

			if(tempExists == 0){
				out.println("<tr></tr>");
			}
			tempExists =0;
		}
		positionsList.clear();
		displayIconDtl.clear(); //[IN035950]
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();
}
catch(Exception e)
{
	//out.println("Error while getting the display Table: "+e);//COMMON-ICN-0181
	e.printStackTrace();
}

finally
{
	if(con != null) ConnectionManager.returnConnection(con,request);
}
%>
<!-- added for IN063285 start -->
<script>
<%String resutStatus=bean.finacialDetailsRequiredForPatient(encounter_id,episode_id, patient_id, patient_class, visit_id);%>
	var resutStatus='<%=resutStatus%>';

	if(resutStatus == "Y" && <%=finacial_dtl_req_yn%>){
	 ViewBLDtl('<%=episode_id%>',"<%=visit_id%>",'<%=patient_id%>');
	}
</script>
<!-- added for IN063285 end -->
</tr>
</table>
</BODY>
</HTML>

