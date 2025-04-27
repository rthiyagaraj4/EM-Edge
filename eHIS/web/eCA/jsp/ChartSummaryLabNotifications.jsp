<!DOCTYPE html>
<!-- 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
15/02/2016	IN057107			Karthi L										Created[ML-MMOH-CRF-0329]
19/04/2016	IN059255			Karthi L							 			ML-MMOH-CRF-0329.1
05/05/2016	IN060133 			Karthi L										ML-MMOH-CRF-0329.1
07/02/2018	IN065970			Vijayakumar K	07/02/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970]
07/03/2018	IN065970			Vijayakumar K	07/03/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970] reopen
28/06/2018	IN065341			Prakash C		29/06/2018		Ramesh G 		MMS-DM-CRF-0115
12/11/2018	IN068797			Prakash C		15/12/2018		Ramesh G		MMS-DM-SCF-0568
08/08/2020	IN073398			Ramesh Goli		08/08/2020		Ramesh G		ML-MMOH-SCF-1574
---------------------------------------------------------------------------------------------------------
-->
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");
String content_ID = request.getParameter("content_ID");
//String facility_id= (String) session.getValue("facility_id");commented for  IN065341
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}
	String title= request.getParameter("title")==null?"":request.getParameter("title");
%>
<title><%=title%></title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />

<style>
A 
{ 
	text-decoration : none ;
}
.gridData1
{
	background-color: #FFFFFF;
	height:18px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;
	padding-left:10px;
	padding-right:10px;
	vertical-align:middle;
	border-bottom:0px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-style:solid;
}
.innerGrid
{
	background-color: #FFFFFF;
	height:18px;
	font-family: Verdana, Arial, Helvetica, sans-serif;
	font-size: 8pt;
	color: #000000;
	font-weight:normal;
	text-align:left;
	vertical-align:middle;
	border-bottom:1px;
	border-top:0px;
	border-left:0px;
	border-right:0px;
	border-style:solid;
	border-color:#EEEEEE;
}
</style>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src="../../eCA/js/CAOpenExternalApplication.js" language="javascript"></script>
<script src="../../eCA/js/CAChartSummaryLabNotify.js" language="javascript"></script> <!-- ML-MMOH-CRF-0329.1 -->
<script src='../../eXH/js/ExternalApplication.js' language='javascript'></script> 
<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
<script>
//IN065341 starts
	//function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID)//INO30714//Parameters facility and content_ID addd for IN038454
async function callResults(patient_id,title,reln_id,enc_id, facility_id, content_ID,called_from,RepDb,clob_data)
//IN065341 ends
{
	var dialogHeight	= "85vh" ;
	var dialogWidth		= "85vw" ;
	var status			= "no";
	var scroll			= "yes";
	var dialogTop		= "";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummaryLabNotificationsMain.jsp?patient_id='+patient_id+'&facility_id='+facility_id+'&content_id='+content_ID+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&relationship_id='+reln_id+'&encounter_id='+enc_id,arguments,features);//IN038454
	retVal 			= await top.window.showModalDialog('../../eCA/jsp/ChartSummaryLabNotificationsMain.jsp?patient_id='+patient_id+'&facility_id1='+facility_id+'&content_id='+content_ID+'&modal_yn=Y'+'&title='+encodeURIComponent(title,"UTF-8")+'&relationship_id='+reln_id+'&encounter_id='+enc_id+'&called_from='+called_from+'&RepDb='+RepDb+'&clob_data='+clob_data,arguments,features);//IN065341
}
function changeColor(obj)
{
	obj.cells[0].style.backgroundColor="#FFFFC0";
	obj.cells[1].style.backgroundColor="#FFFFC0";
	obj.cells[2].style.backgroundColor="#FFFFC0";
	obj.cells[3].style.backgroundColor="#FFFFC0";
	obj.cells[4].style.backgroundColor="#FFFFC0";
	obj.cells[5].style.backgroundColor="#FFFFC0";
}
function changeColor1(obj,index)
{
	if(document.getElementById("tab"+index).rows[1].style.display == 'none')
	{
		obj.cells[0].style.backgroundColor="#FFFFFF";
		obj.cells[1].style.backgroundColor="#FFFFFF";
		obj.cells[2].style.backgroundColor="#FFFFFF";
		obj.cells[3].style.backgroundColor="#FFFFFF";
		obj.cells[4].style.backgroundColor="#FFFFFF";
		obj.cells[5].style.backgroundColor="#FFFFFF";
	}
}
function showDetailResult(index)
{
	/*if(eval("document.getElementById("tab")"+index).rows[1].style.display == 'none')
	{
		if(eval("document.getElementById("tab")"+index).rows[1].cells[0].innerHTML != '')
		{
			eval("document.getElementById("tab")"+index+".rows[1].style.display = 'inline'");
			eval("document.getElementById("tab")"+index+".rows[1].cells[0].style.backgroundColor='#FFFFC0'");
		}
	}
	else
		eval("document.getElementById("tab")"+index+".rows[1].style.display = 'none'");*/
	if(document.getElementById("tab"+index).rows[1].style.display == 'none')
	{
		if(document.getElementById("tab"+index).rows[1].cells[0].innerHTML != '')
		{
			document.getElementById("tab"+index+".rows[1].style.display = 'inline'");
			document.getElementById("tab"+index+".rows[1].cells[0].style.backgroundColor='#FFFFC0'");
		}
	}
	else
		document.getElementById("tab"+index+".rows[1].style.display = 'none'");
		
}

async function openGrpah(index,patient_id,event_code,event_group,histRecType,event_dateTime)
{
	var dialogHeight	= "80vh" ;
	var dialogWidth		= "80vw" ;
	var status			= "no";
	var dialogTop		= "";
	var arguments		= "" ;
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:" + dialogTop +" ; scroll=no; status:" + status;
	var action_url		=	'../../eCA/jsp/ChartSummaryResultsGraphMain.jsp?patient_id='+patient_id+'&event_code='+event_code+'&event_group='+event_group+'&histRecType='+histRecType+'&event_dateTime='+event_dateTime;
	var retVal=await window.showModalDialog(action_url,arguments,features);
}

function submitPrevNext(from, to)
{
	document.ChartSummResult_Form.from.value = from;
	document.ChartSummResult_Form.to.value = to; 
	document.ChartSummResult_Form.submit();
}

</script>
</head>
<%
	Properties p			= (Properties)session.getValue("jdbc");
	String locale			= (String) p.getProperty("LOCALE");
	Connection con			= null;
	PreparedStatement stmt	= null;
	ResultSet rs			= null;
	String viewconf_appl	= "X";
	StringBuffer sql		= new StringBuffer() ;	
	
	PreparedStatement pstmtImgView = null; 
	ResultSet resImgView = null; 
	int recCount = 0; 
	PreparedStatement pstmtImgCount = null; 
	ResultSet rsetImgCount = null; 
	
	PreparedStatement pstmtPerFacId = null; 
	ResultSet rsetPerFacId = null;  
	
	PreparedStatement pstmtOrderId = null; 
	ResultSet rsetOrderId = null;  
	PreparedStatement pStmtAudit = null;//ML-MMOH-CRF-0329.1
	ResultSet rSetAudit = null;//ML-MMOH-CRF-0329.1
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");
	String login_user = (String)session.getValue("login_user"); 
	String accessionNum	= "", histRecType = "", contrSysEventCode = "", contrSysId = "", eventTime = "";
	String histRecTypeDesc = "", eventClassDesc = "", eventGroupDesc = "", eventDesc = "";
	String textExist = "", histDataType = "", resultStr = "";
	String resultNumUom = "", normalLow = "",	normalHigh = "";			
	String histRecTypeDescPrev = "", eventGroupDescPrev = "", eventDatePrev = "", tempStrValue = "";
	String normalcyInd = "";
	String eventClassDescPrev = "";
	String ext_image_appl_id = "", ext_image_obj_id = "";
	String color_cell_indicator = "";
	String descCellInd = "";
	String event_date = "";
	String eventTimePrev = "";
	String legend_type = ""; 
	String patient_class = "";
	String reported_by = "";
	String details1 = "";
	String event_code = "", event_group = "";
	String pend_review_yn = "";
	String result_num_prefix = "";
	String result_status = "";
	String normalcy_str = "";
	StringBuffer details = new StringBuffer();
	String resp_id		= (String)session.getValue("responsibility_id");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String patient_id	= request.getParameter("patient_id");
	//IN065341 starts
	//IN065341 starts
	String bean_id1 = "ca_CentralizedBean" ;
	String bean_name1 = "eCA.CentralizedBean";
	CentralizedBean bean1 = (CentralizedBean)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	bean1.clear() ;
	bean1.setFunctionId(bean1.checkForNull(request.getParameter("function_id")));
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String enc_id="";
	String facility_id="";
	if(called_from.equals("CDR")){
		 enc_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		 facility_id=request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	}else{//IN065341 ends
		 enc_id = request.getParameter("encounter_id");
		 facility_id= (String) session.getValue("facility_id");
	}//IN065341
	String enctr_id = "";
	String fac_id="";

	String ext_image_upld_id = ""; 
	String ext_img_file_locn = ""; 
	String notify_alert = "";
	
	String dmsExternalLinkYN = ""; 
	String event_code_type = "";
	String access_no_rd 	= ""; 
	String order_id 		= ""; 
	String order_typ_code	= ""; 
	String locn_code	= "";		
	String locn_type	= "";
	String loc_desc		= "";
	String visit_id		= "";
	String physician_id	= "";
	String admit_date	= "";
	String encntr_type	= "";
	String test_code 	= "";
	String test_code_desc = "";
	String cancelled_reason = "";
	String cancel_code 	= "";
	String cancel_date		= "";
	String cancel_time = "";
	StringBuffer  criticalIndicatorsList = new StringBuffer(); //IN073398
	String critical = "";  //IN073398
	String criticalLow=""; //IN073398
	String criticalHigh =""; //IN073398
	HashMap extLinkHashMap = null;
	eCA.CAExternalLinkDataDTO externalDataDTO = null;
	String ext_image_appli_id = "";
	String ext_image_obj_id_dms = "";
	String ext_image_source = "";
	String ext_srce_doc_ref_no = "";
	String ext_srce_doc_ref_line_no = "";
	ArrayList externalList = null;

	if(facility_id == null) { 
		facility_id =  request.getParameter("facility_id") == null? "":request.getParameter("facility_id") ;
	}
	if(content_ID == null){
		content_ID = request.getParameter("content_id") == null? "":request.getParameter("content_id");
	} 

	eCA.PatientBannerGroupLine manageEmailBean = null;
	//eCA.ChartSummLabNotifications beanObj = null;
	
	String modal_yn		= request.getParameter("modal_yn");
	if (modal_yn == null) modal_yn = "N";
	String review_result = "" ; // ML-MMOH-CRF-0329.1
	String audit_link = "A"; // ML-MMOH-CRF-0329.1
	String audit_accession_num = ""; // ML-MMOH-CRF-0329.1
	String audit_order_id = ""; // ML-MMOH-CRF-0329.1
	String bean_id = "Or_ViewOrder" ; // ML-MMOH-CRF-0329.1
	String bean_name = "eOR.ViewOrder";	// ML-MMOH-CRF-0329.1
	String orderIdQry = ""; // ML-MMOH-CRF-0329.1
	String ca_normalcy_ind = ""; // ML-MMOH-CRF-0329.1
	String cr_patient_class = ""; // ML-MMOH-CRF-0329.1
	String notify_alert_yn = ""; // ML-MMOH-CRF-0329.1
	String pend_done_status = ""; //IN060133
	
	int i = 0, j = 0;
	if(resp_id == null)resp_id = "";

	int maxCount = 0;
	int start = 0 ;
    int end = 0 ;

	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
    if ( from == null )
        start = 1 ;
    else
        start = Integer.parseInt( from ) ;

    if ( to == null )
        end = 10 ;
    else
        end = Integer.parseInt( to ) ;
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="ChartSummResult_Form" id="ChartSummResult_Form" action="ChartSummaryLabNotifications.jsp?<%=request.getQueryString()%>" method="post">

<%
	try
	{
		manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patient_id+enc_id,"eCA.PatientBannerGroupLine",session);
		CAChartSummaryLabNotifyBean beanObj = (CAChartSummaryLabNotifyBean)getObjectFromBean("CAChartSummaryLabNotifyBean", "eCA.CAChartSummaryLabNotifyBean", session); //IN060133
		CAEncounterList oEncounterList = new CAEncounterList();
		//code starts

		dmsExternalLinkYN = oEncounterList.getExternalDmsLinkYN(facility_id);  	
		
		
		con	 = ConnectionManager.getConnection(request);
		//IN065341 starts
			//stmt = con.prepareStatement(" select GET_TASK_APPLICABILITY(?,NULL,?,?) from dual ");
			String  sql1="select GET_TASK_APPLICABILITY ##REPDB##(?,NULL,?,?) from dual ##REPDB##";
			sql1=sql1.replaceAll("##REPDB##",RepDb);
			stmt = con.prepareStatement(sql1);
		//IN065341 ends
		stmt.setString(1,"VIEW_CONF_RESULT");
		stmt.setString(2,resp_id);
		stmt.setString(3,reln_id);
		rs = stmt.executeQuery();
		if (rs.next())
			viewconf_appl = rs.getString(1);
		if (viewconf_appl == null) viewconf_appl = "X";
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();

		//IN065341 starts
			//stmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
			//IN073398 Start.
			//	String  sql2="select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ##REPDB##"; 
			String  sql2="select LEGEND_TYPE,CRIT_STR,CRIT_LOW_STR,CRIT_HIGH_STR from CR_CLIN_EVENT_PARAM ##REPDB##";
			//IN073398 End.
			sql2=sql2.replaceAll("##REPDB##",RepDb);
			stmt = con.prepareStatement(sql2);
		//IN065341 ends
		rs = stmt.executeQuery();
		if (rs.next())
		{
			legend_type = rs.getString(1) == null ? "S" : rs.getString(1);
			critical = rs.getString(2) == null ? "" : rs.getString(2); //IN073398
			criticalLow = rs.getString(3) == null ? "" : rs.getString(3); //IN073398
			criticalHigh = rs.getString(4) == null ? "" : rs.getString(4); //IN073398
		}
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
		//IN073398 Start.
		int criticalIndCount =0;
		if(!"".equals(critical)){
			if(criticalIndCount!=0)
				criticalIndicatorsList.append(",");
			criticalIndicatorsList.append("'"+critical+"'");
			criticalIndCount++;
		}
		if(!"".equals(criticalLow)){
			if(criticalIndCount!=0)
				criticalIndicatorsList.append(",");
			criticalIndicatorsList.append("'"+criticalLow+"'");	
			criticalIndCount++;
		}
		if(!"".equals(criticalHigh)){
			if(criticalIndCount!=0)
				criticalIndicatorsList.append(",");
			criticalIndicatorsList.append("'"+criticalHigh+"'");
			criticalIndCount++;			
		}
		//IN073398 End.
	//IN065341 starts	
		//sql.append("SELECT * FROM (SELECT event_date, authorized_by_id, performed_by_id,a.patient_id, a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR(event_date, 'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW WHERE LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW WHERE language_id=? AND event_class = a.event_class AND hist_rec_type = a.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW WHERE language_id=? AND hist_rec_type = a.hist_rec_type AND event_group = a.event_group AND event_group_type=a.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW WHERE language_id =? AND hist_rec_type = a.hist_rec_type AND event_code=a.event_code AND event_code_type=a.event_code_type) event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits   ,A.hist_rec_type,A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') reported_by, a.event_code, A.event_group, NVL((SELECT 'Y' FROM CA_RESULT_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND  HIST_REC_TYPE=a.HIST_REC_TYPE AND  CONTR_SYS_ID = a.CONTR_SYS_ID AND ACCESSION_NUM = a.ACCESSION_NUM AND EVENT_CODE = a.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID,a.FACILITY_ID,a.event_code_type,a.normalcy_ind,'N' notify_alert FROM CR_ENCOUNTER_DETAIL A WHERE patient_id = ? AND a.hist_rec_type IN  (SELECT  NVL(HIST_REC_TYPE,'*') FROM  or_order_category WHERE PREFERRED_VIEW_RESULT_YN='Y')  AND (FACILITY_ID,ENCOUNTER_ID) IN (SELECT FACILITY_ID,ENCOUNTER_ID FROM (SELECT FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  FROM  PR_ENCOUNTER WHERE patient_id= ? ) " );
		sql.append("SELECT * FROM (SELECT event_date, authorized_by_id, performed_by_id,a.patient_id, a.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR(event_date, 'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW ##REPDB## WHERE LANGUAGE_ID = ? AND hist_rec_type = a.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW ##REPDB## WHERE language_id=? AND event_class = a.event_class AND hist_rec_type = a.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW ##REPDB## WHERE language_id=? AND hist_rec_type = a.hist_rec_type AND event_group = a.event_group AND event_group_type=a.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW ##REPDB## WHERE language_id =? AND hist_rec_type = a.hist_rec_type AND event_code=a.event_code AND event_code_type=a.event_code_type) event_desc, A.hist_data_type, a.RESULT_NUM_PREFIX, A.result_num, A.result_num_uom, A.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits   ,A.hist_rec_type,A.contr_sys_event_code, A.contr_sys_id, A.EXT_IMAGE_APPL_ID, A.EXT_IMAGE_OBJ_ID, A.EXT_IMAGE_UPLD_ID, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM ##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM ##REPDB##) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM ##REPDB##)  normal_range_symbol, a.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.performed_by_id,?,'1') reported_by, a.event_code, A.event_group, NVL((SELECT 'Y' FROM CA_RESULT_REVIEW_PEND_LOG ##REPDB## WHERE PRACT_ID = ? AND  HIST_REC_TYPE=a.HIST_REC_TYPE AND  CONTR_SYS_ID = a.CONTR_SYS_ID AND ACCESSION_NUM = a.ACCESSION_NUM AND EVENT_CODE = a.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, a.STATUS, a.NORMALCY_STR, a.encounter_ID,a.FACILITY_ID,a.event_code_type,a.normalcy_ind,'N' notify_alert FROM CR_ENCOUNTER_DETAIL ##REPDB## A  WHERE patient_id = ? AND a.hist_rec_type IN  (SELECT  NVL(HIST_REC_TYPE,'*') HIST_REC_TYPE FROM  or_order_category ##REPDB## WHERE PREFERRED_VIEW_RESULT_YN='Y')  AND (FACILITY_ID,ENCOUNTER_ID) IN (SELECT FACILITY_ID,ENCOUNTER_ID FROM (SELECT FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  FROM  PR_ENCOUNTER ##REPDB## WHERE patient_id= ? ) " );
	//IN065341 ends
		//IN073398 Start.
		//sql.append(" )AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' ) AND A.normalcy_ind = 'C' AND A.hist_rec_type = 'LBIN' AND A.contr_sys_id = 'LB' "); 		
		sql.append(" )AND a.event_class NOT IN ('CNS$' ,'RFS$', 'RFR$' ) AND A.normalcy_ind in ("+criticalIndicatorsList.toString()+") AND A.hist_rec_type = 'LBIN' AND A.contr_sys_id = 'LB' ");  
		//IN073398 End.
		//String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");

		//sql.append(" UNION ALL SELECT event_date, AUTHORIZED_BY_ID, performed_by_id,f.patient_id, f.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR (event_date,'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW WHERE LANGUAGE_ID = ? AND hist_rec_type = f.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW WHERE language_id=? AND event_class = f.event_class AND hist_rec_type = f.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW WHERE language_id=? AND hist_rec_type = f.hist_rec_type AND event_group = f.event_group AND event_group_type=f.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW WHERE language_id =? AND hist_rec_type = f.hist_rec_type AND event_code=f.event_code AND event_code_type=f.event_code_type) event_desc, f.hist_data_type, f.RESULT_NUM_PREFIX, f.result_num, f.result_num_uom, f.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = f.hist_rec_type AND CONTR_SYS_ID=f.contr_sys_id AND ACCESSION_NUM = f.accession_num AND CONTR_SYS_EVENT_CODE = f.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits,  f.hist_rec_type ,f.contr_sys_event_code, f.contr_sys_id, f.EXT_IMAGE_APPL_ID, f.EXT_IMAGE_OBJ_ID, f.EXT_IMAGE_UPLD_ID, (SELECT DECODE(f.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(f.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(f.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, f.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(f.performed_by_id,?,'1') reported_by, f.event_code, f.event_group, NVL((SELECT 'Y' FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND  HIST_REC_TYPE=f.HIST_REC_TYPE AND  CONTR_SYS_ID = f.CONTR_SYS_ID AND ACCESSION_NUM = f.ACCESSION_NUM AND EVENT_CODE = f.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, f.STATUS, f.NORMALCY_STR, f.encounter_ID,f.FACILITY_ID,f.event_code_type,f.normalcy_ind,'Y' notify_alert  FROM CA_NOTIFY_REVIEW_PEND_LOG b, CR_CLIN_EVENT_PARAM c, or_order i, cr_encounter_detail f WHERE b.pract_id = ?  AND  f.patient_id = ? AND i.order_id =(CASE WHEN (b.contr_sys_id = 'OR') THEN SUBSTR (b.accession_num, INSTR (b.accession_num, '!') + 1,15) ELSE(SELECT order_id FROM or_order_line WHERE order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) AND ROWNUM = 1) END) AND i.patient_id = f.patient_id AND f.HIST_REC_TYPE = b.HIST_REC_TYPE AND f.CONTR_SYS_ID = b.CONTR_SYS_ID AND f.ACCESSION_NUM = b.ACCESSION_NUM AND f.CONTR_SYS_EVENT_CODE = b.EVENT_CODE AND NVL (b.status, '#') NOT IN ('E', 'S') ");
	//IN065341 starts
		//sql.append(" UNION SELECT event_date, AUTHORIZED_BY_ID, performed_by_id,f.patient_id, f.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR (event_date,'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW WHERE LANGUAGE_ID = ? AND hist_rec_type = f.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW WHERE language_id=? AND event_class = f.event_class AND hist_rec_type = f.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW WHERE language_id=? AND hist_rec_type = f.hist_rec_type AND event_group = f.event_group AND event_group_type=f.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW WHERE language_id =? AND hist_rec_type = f.hist_rec_type AND event_code=f.event_code AND event_code_type=f.event_code_type) event_desc, f.hist_data_type, f.RESULT_NUM_PREFIX, f.result_num, f.result_num_uom, f.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = f.hist_rec_type AND CONTR_SYS_ID=f.contr_sys_id AND ACCESSION_NUM = f.accession_num AND CONTR_SYS_EVENT_CODE = f.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits,  f.hist_rec_type ,f.contr_sys_event_code, f.contr_sys_id, f.EXT_IMAGE_APPL_ID, f.EXT_IMAGE_OBJ_ID, f.EXT_IMAGE_UPLD_ID, (SELECT DECODE(f.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(f.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(f.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, f.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(f.performed_by_id,?,'1') reported_by, f.event_code, f.event_group, NVL((SELECT 'Y' FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND  HIST_REC_TYPE=f.HIST_REC_TYPE AND  CONTR_SYS_ID = f.CONTR_SYS_ID AND ACCESSION_NUM = f.ACCESSION_NUM AND EVENT_CODE = f.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, f.STATUS, f.NORMALCY_STR, f.encounter_ID,f.FACILITY_ID,f.event_code_type,f.normalcy_ind,'Y' notify_alert  FROM CA_NOTIFY_REVIEW_PEND_LOG b, CR_CLIN_EVENT_PARAM c, or_order i, cr_encounter_detail f WHERE f.patient_id = ? AND i.order_id =(CASE WHEN (b.contr_sys_id = 'OR') THEN SUBSTR (b.accession_num, INSTR (b.accession_num, '!') + 1,15) ELSE(SELECT order_id FROM or_order_line WHERE order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) AND ROWNUM = 1) END) AND i.patient_id = f.patient_id AND f.HIST_REC_TYPE = b.HIST_REC_TYPE AND f.CONTR_SYS_ID = b.CONTR_SYS_ID AND f.ACCESSION_NUM = b.ACCESSION_NUM AND f.CONTR_SYS_EVENT_CODE = b.EVENT_CODE AND NVL (b.status, '#') NOT IN ('E', 'S') ");
		sql.append(" UNION SELECT event_date, AUTHORIZED_BY_ID, performed_by_id,f.patient_id, f.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR (event_date,'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW ##REPDB## WHERE LANGUAGE_ID = ? AND hist_rec_type = f.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW ##REPDB## WHERE language_id=? AND event_class = f.event_class AND hist_rec_type = f.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW ##REPDB## WHERE language_id=? AND hist_rec_type = f.hist_rec_type AND event_group = f.event_group AND event_group_type=f.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW ##REPDB## WHERE language_id =? AND hist_rec_type = f.hist_rec_type AND event_code=f.event_code AND event_code_type=f.event_code_type) event_desc, f.hist_data_type, f.RESULT_NUM_PREFIX, f.result_num, f.result_num_uom, f.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = f.hist_rec_type AND CONTR_SYS_ID=f.contr_sys_id AND ACCESSION_NUM = f.accession_num AND CONTR_SYS_EVENT_CODE = f.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits,  f.hist_rec_type ,f.contr_sys_event_code, f.contr_sys_id, f.EXT_IMAGE_APPL_ID, f.EXT_IMAGE_OBJ_ID, f.EXT_IMAGE_UPLD_ID, (SELECT DECODE(f.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM ##REPDB##) COLOR_CELL_IND,(SELECT DECODE(f.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM ##REPDB##) DESC_CELL_IND, (SELECT DECODE(f.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM ##REPDB##)  normal_range_symbol, f.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER ##REPDB##(f.performed_by_id,?,'1') reported_by, f.event_code, f.event_group, NVL((SELECT 'Y' FROM CA_NOTIFY_REVIEW_PEND_LOG ##REPDB## WHERE PRACT_ID = ? AND  HIST_REC_TYPE=f.HIST_REC_TYPE AND  CONTR_SYS_ID = f.CONTR_SYS_ID AND ACCESSION_NUM = f.ACCESSION_NUM AND EVENT_CODE = f.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, f.STATUS, f.NORMALCY_STR, f.encounter_ID,f.FACILITY_ID,f.event_code_type,f.normalcy_ind,'Y' notify_alert  FROM CA_NOTIFY_REVIEW_PEND_LOG ##REPDB## b, CR_CLIN_EVENT_PARAM c, or_order i, cr_encounter_detail f WHERE f.patient_id = ? AND i.order_id =(CASE WHEN (b.contr_sys_id = 'OR') THEN SUBSTR (b.accession_num, INSTR (b.accession_num, '!') + 1,15) ELSE(SELECT order_id FROM or_order_line ##REPDB## WHERE order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) AND ROWNUM = 1) END) AND i.patient_id = f.patient_id AND f.HIST_REC_TYPE = b.HIST_REC_TYPE AND f.CONTR_SYS_ID = b.CONTR_SYS_ID AND f.ACCESSION_NUM = b.ACCESSION_NUM AND f.CONTR_SYS_EVENT_CODE = b.EVENT_CODE AND NVL (b.status, '#') NOT IN ('E', 'S') ");
	//IN065341 ends
		//sql.append(" UNION ALL SELECT event_date, AUTHORIZED_BY_ID, performed_by_id,f.patient_id, f.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR (event_date,'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW WHERE LANGUAGE_ID = ? AND hist_rec_type = f.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW WHERE language_id=? AND event_class = f.event_class AND hist_rec_type = f.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW WHERE language_id=? AND hist_rec_type = f.hist_rec_type AND event_group = f.event_group AND event_group_type=f.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW WHERE language_id =? AND hist_rec_type = f.hist_rec_type AND event_code=f.event_code AND event_code_type=f.event_code_type) event_desc, f.hist_data_type, f.RESULT_NUM_PREFIX, f.result_num, f.result_num_uom, f.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = f.hist_rec_type AND CONTR_SYS_ID=f.contr_sys_id AND ACCESSION_NUM = f.accession_num AND CONTR_SYS_EVENT_CODE = f.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits,  f.hist_rec_type ,f.contr_sys_event_code, f.contr_sys_id, f.EXT_IMAGE_APPL_ID, f.EXT_IMAGE_OBJ_ID, f.EXT_IMAGE_UPLD_ID, (SELECT DECODE(f.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(f.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(f.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, f.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(f.performed_by_id,?,'1') reported_by, f.event_code, f.event_group, NVL((SELECT 'Y' FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND  HIST_REC_TYPE=f.HIST_REC_TYPE AND  CONTR_SYS_ID = f.CONTR_SYS_ID AND ACCESSION_NUM = f.ACCESSION_NUM AND EVENT_CODE = f.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, f.STATUS, f.NORMALCY_STR, f.encounter_ID,f.FACILITY_ID,f.event_code_type,f.normalcy_ind,'Y' notify_alert  FROM CA_NOTIFY_REVIEW_DONE_LOG g, CR_CLIN_EVENT_PARAM c, or_order i, cr_encounter_detail f WHERE g.pract_id = ?  AND  f.patient_id = ? AND i.order_id =(CASE WHEN (g.contr_sys_id = 'OR') THEN SUBSTR (g.accession_num, INSTR (g.accession_num, '!') + 1,15) ELSE(SELECT order_id FROM or_order_line WHERE order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) AND ROWNUM = 1) END) AND i.patient_id = f.patient_id AND f.HIST_REC_TYPE = g.HIST_REC_TYPE AND f.CONTR_SYS_ID = g.CONTR_SYS_ID AND f.ACCESSION_NUM = g.ACCESSION_NUM AND f.CONTR_SYS_EVENT_CODE = g.EVENT_CODE "); // ML-MMOH-CRF-0329.1
	//IN065341 starts
		//sql.append(" UNION SELECT event_date, AUTHORIZED_BY_ID, performed_by_id,f.patient_id, f.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR (event_date,'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW WHERE LANGUAGE_ID = ? AND hist_rec_type = f.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW WHERE language_id=? AND event_class = f.event_class AND hist_rec_type = f.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW WHERE language_id=? AND hist_rec_type = f.hist_rec_type AND event_group = f.event_group AND event_group_type=f.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW WHERE language_id =? AND hist_rec_type = f.hist_rec_type AND event_code=f.event_code AND event_code_type=f.event_code_type) event_desc, f.hist_data_type, f.RESULT_NUM_PREFIX, f.result_num, f.result_num_uom, f.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE = f.hist_rec_type AND CONTR_SYS_ID=f.contr_sys_id AND ACCESSION_NUM = f.accession_num AND CONTR_SYS_EVENT_CODE = f.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits,  f.hist_rec_type ,f.contr_sys_event_code, f.contr_sys_id, f.EXT_IMAGE_APPL_ID, f.EXT_IMAGE_OBJ_ID, f.EXT_IMAGE_UPLD_ID, (SELECT DECODE(f.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(f.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(f.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, f.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER(f.performed_by_id,?,'1') reported_by, f.event_code, f.event_group, NVL((SELECT 'Y' FROM CA_NOTIFY_REVIEW_PEND_LOG WHERE PRACT_ID = ? AND  HIST_REC_TYPE=f.HIST_REC_TYPE AND  CONTR_SYS_ID = f.CONTR_SYS_ID AND ACCESSION_NUM = f.ACCESSION_NUM AND EVENT_CODE = f.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, f.STATUS, f.NORMALCY_STR, f.encounter_ID,f.FACILITY_ID,f.event_code_type,f.normalcy_ind,'Y' notify_alert  FROM CA_NOTIFY_REVIEW_DONE_LOG g, CR_CLIN_EVENT_PARAM c, or_order i, cr_encounter_detail f WHERE f.patient_id = ? AND i.order_id =(CASE WHEN (g.contr_sys_id = 'OR') THEN SUBSTR (g.accession_num, INSTR (g.accession_num, '!') + 1,15) ELSE(SELECT order_id FROM or_order_line WHERE order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) AND ROWNUM = 1) END) AND i.patient_id = f.patient_id AND f.HIST_REC_TYPE = g.HIST_REC_TYPE AND f.CONTR_SYS_ID = g.CONTR_SYS_ID AND f.ACCESSION_NUM = g.ACCESSION_NUM AND f.CONTR_SYS_EVENT_CODE = g.EVENT_CODE "); // ML-MMOH-CRF-0329.1
		sql.append(" UNION SELECT event_date, AUTHORIZED_BY_ID, performed_by_id,f.patient_id, f.accession_num, TO_CHAR(event_date,'dd/mm/yyyy') event_date_time,TO_CHAR (event_date,'hh24:mi') event_time, (SELECT short_desc FROM CR_HIS_RECTYP_LNG_VW ##REPDB## WHERE LANGUAGE_ID = ? AND hist_rec_type = f.hist_rec_type) hist_rec_type_desc, (SELECT short_desc FROM CR_EVENT_CLASS_LANG_VW ##REPDB## WHERE language_id=? AND event_class = f.event_class AND hist_rec_type = f.hist_rec_type) event_class_desc, (SELECT short_desc FROM CR_CLN_EVT_GRP_LANG_VW ##REPDB## WHERE language_id=? AND hist_rec_type = f.hist_rec_type AND event_group = f.event_group AND event_group_type=f.event_group_type) event_group_desc, (SELECT short_desc FROM CR_CLN_EVT_MST_LANG_VW ##REPDB## WHERE language_id =? AND hist_rec_type = f.hist_rec_type AND event_code=f.event_code AND event_code_type=f.event_code_type) event_desc, f.hist_data_type, f.RESULT_NUM_PREFIX, f.result_num, f.result_num_uom, f.result_str, NORMAL_LOW, NORMAL_HIGH, CRITICAL_LOW, CRITICAL_HIGH, NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE = f.hist_rec_type AND CONTR_SYS_ID=f.contr_sys_id AND ACCESSION_NUM = f.accession_num AND CONTR_SYS_EVENT_CODE = f.contr_sys_event_code AND DBMS_LOB.getlength(hist_data)>0), 'N') text_exisits,  f.hist_rec_type ,f.contr_sys_event_code, f.contr_sys_id, f.EXT_IMAGE_APPL_ID, f.EXT_IMAGE_OBJ_ID, f.EXT_IMAGE_UPLD_ID, (SELECT DECODE(f.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR,crit_low_color_code)FROM CR_CLIN_EVENT_PARAM ##REPDB##) COLOR_CELL_IND,(SELECT DECODE(f.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR , crit_low_str_desc)FROM CR_CLIN_EVENT_PARAM ##REPDB##) DESC_CELL_IND, (SELECT DECODE(f.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'') FROM CR_CLIN_EVENT_PARAM ##REPDB##)  normal_range_symbol, f.PATIENT_CLASS, AM_GET_DESC.AM_PRACTITIONER ##REPDB##(f.performed_by_id,?,'1') reported_by, f.event_code, f.event_group, NVL((SELECT 'Y' FROM CA_NOTIFY_REVIEW_PEND_LOG ##REPDB## WHERE PRACT_ID = ? AND  HIST_REC_TYPE=f.HIST_REC_TYPE AND  CONTR_SYS_ID = f.CONTR_SYS_ID AND ACCESSION_NUM = f.ACCESSION_NUM AND EVENT_CODE = f.EVENT_CODE AND ROWNUM=1),'N') pend_review_yn, f.STATUS, f.NORMALCY_STR, f.encounter_ID,f.FACILITY_ID,f.event_code_type,f.normalcy_ind,'Y' notify_alert  FROM CA_NOTIFY_REVIEW_DONE_LOG ##REPDB## g, CR_CLIN_EVENT_PARAM ##REPDB## c, or_order ##REPDB## i, cr_encounter_detail ##REPDB## f WHERE f.patient_id = ? AND i.order_id =(CASE WHEN (g.contr_sys_id = 'OR') THEN SUBSTR (g.accession_num, INSTR (g.accession_num, '!') + 1,15) ELSE(SELECT order_id FROM or_order_line ##REPDB## WHERE order_line_num = 1 AND accession_num = SUBSTR (f.request_num, 5) AND ROWNUM = 1) END) AND i.patient_id = f.patient_id AND f.HIST_REC_TYPE = g.HIST_REC_TYPE AND f.CONTR_SYS_ID = g.CONTR_SYS_ID AND f.ACCESSION_NUM = g.ACCESSION_NUM AND f.CONTR_SYS_EVENT_CODE = g.EVENT_CODE "); 
	//IN065341 ends
		sql.append(" ORDER BY  notify_alert asc,  event_date DESC, hist_rec_type, event_group_desc, event_group, event_desc, event_code ) dual WHERE ");
		if (modal_yn.equals("N")) 
		//IN065341 starts	
			//sql.append("event_date IN(SELECT   event_date FROM (SELECT event_date, DENSE_RANK () OVER (ORDER BY event_date DESC) drank, RANK () OVER (ORDER BY event_date DESC) RANK FROM cr_encounter_detail WHERE   patient_id = ?	AND hist_rec_type IN (SELECT   NVL (HIST_REC_TYPE, '*') FROM   or_order_category WHERE PREFERRED_VIEW_RESULT_YN = 'Y')) WHERE   RANK <= 10 OR drank < 2) AND ");
			sql.append("event_date IN(SELECT   event_date FROM (SELECT event_date, DENSE_RANK () OVER (ORDER BY event_date DESC) drank, RANK () OVER (ORDER BY event_date DESC) RANK FROM cr_encounter_detail ##REPDB## WHERE   patient_id = ?	AND hist_rec_type IN (SELECT   NVL (HIST_REC_TYPE, '*') HIST_REC_TYPE FROM   or_order_category ##REPDB## WHERE PREFERRED_VIEW_RESULT_YN = 'Y')) WHERE   RANK <= 10 OR drank < 2) AND ");
		//IN065341 ends
	
	//IN065341 starts
		//sql.append("NVL (ca_view_confidnt_event (facility_id, ENCOUNTER_ID, PATIENT_ID, accession_num, CONTR_SYS_ID, event_code, hist_rec_type, ? ,? , performed_by_id, AUTHORIZED_BY_ID, event_group), 'N') = 'Y'");
		sql.append("NVL (ca_view_confidnt_event ##REPDB##(facility_id, ENCOUNTER_ID, PATIENT_ID, accession_num, CONTR_SYS_ID, event_code, hist_rec_type, ? ,? , performed_by_id, AUTHORIZED_BY_ID, event_group), 'N') = 'Y'");
	//IN065341 ends
		int indx=1;
	//IN065341 starts	
		//stmt=con.prepareStatement(sql.toString());
		if (called_from.equals("CDR")) {
			bean1.executeCDR(con, patient_id, enc_id, RepDb,"CR_ENCOUNTER_DETAIL_TXT");
		}
		String result=sql.toString();
		result=result.replaceAll("##REPDB##",RepDb);
		result=result.replaceAll("##CLOB##",clob_data);
		stmt=con.prepareStatement(result);
	//IN065341 ends
	
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,practitioner_id);
		stmt.setString(indx++,patient_id);
		stmt.setString(indx++,patient_id);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,practitioner_id);
		//stmt.setString(indx++,practitioner_id);
		stmt.setString(indx++,patient_id);
		// ML-MMOH-CRF-0329.1 - Start
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		stmt.setString(indx++,locale);
		
		stmt.setString(indx++,practitioner_id);
		//stmt.setString(indx++,practitioner_id);
		stmt.setString(indx++,patient_id);
		// ML-MMOH-CRF-0329.1 - End
		//stmt.setString(indx++,clinician_id); // no need of this variable
		if (modal_yn.equals("N"))
			stmt.setString(indx++,patient_id);
	
		stmt.setString(indx++,practitioner_id);
		stmt.setString(indx++,resp_id);	
		
		rs = stmt.executeQuery();

		while(rs.next())
		{
			maxCount = maxCount+1;
		}
		if(rs!=null) rs.close();

		if(maxCount > 0)
		{
%>
			<table cellpadding='6' cellspacing='0' border='0' width='90%' align='center'>
			<tr>
			<td class='white' width='75%'></td> 
			<td  align='right' width='25%'>
<%
			if ( !(start <= 1) )
			{
%>
				<A class="gridLink" HREF='javascript:submitPrevNext(<%=(start-10)%>,<%=(end-10)%>)'  text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></A>
<%
			}
			if ( !( (start+10) > maxCount ) )
			{
%>
				<A class="gridLink" HREF='javascript:submitPrevNext(<%=(start+10)%>,<%=(end+10)%>)'  text-decoration='none'>&nbsp;<fmt:message key="Common.next.label" bundle="${common_labels}"/></A>
<%
			
			}
%>
			</td>
			</tr>
			</table>
			<center>
			<table class='grid' width='100%' id='tb1' cellspacing='0' cellpadding='0' ><tr>
<%
		rs = stmt.executeQuery();
		
		if(start > 0)
			for(int k=0;(k<start-1 && rs.next());k++);
		
		while(rs.next() && (start <= end))
		{
			String resultNum = "";		
			accessionNum = rs.getString("accession_num") == null ? "" : rs.getString("accession_num");
			histRecType = rs.getString("hist_rec_type") == null ? "" : rs.getString("hist_rec_type");
			contrSysEventCode = rs.getString("contr_sys_event_code") == null ? "" : rs.getString("contr_sys_event_code");
			contrSysId = rs.getString("contr_sys_id") == null ? "" : rs.getString("contr_sys_id");
			event_date = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
			eventTime = rs.getString("event_time") == null ? "" : rs.getString("event_time");
			histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
			eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
			eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
			eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
			textExist = rs.getString("text_exisits") == null ? "" : rs.getString("text_exisits");	
			histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");	
			ext_image_appl_id = rs.getString("ext_image_appl_id") == null ? "" : rs.getString("ext_image_appl_id");	
			ext_image_obj_id = rs.getString("ext_image_obj_id") == null ? "" : rs.getString("ext_image_obj_id");
			if(legend_type.equals("C"))
				color_cell_indicator = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
			else if(legend_type.equals("S"))
				color_cell_indicator = rs.getString("normal_range_symbol") == null ? "" : rs.getString("normal_range_symbol");
			descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
			resultStr = rs.getString("result_str") == null ? "" : rs.getString("result_str");
			patient_class = rs.getString("PATIENT_CLASS") == null ? "" : rs.getString("PATIENT_CLASS");
			reported_by = rs.getString("reported_by") == null ? "" : rs.getString("reported_by");
			event_code = rs.getString("event_code") == null ? "" : rs.getString("event_code");
			event_group = rs.getString("event_group") == null ? "" : rs.getString("event_group");
			pend_review_yn = rs.getString("pend_review_yn") == null ? "" : rs.getString("pend_review_yn");
			normalcyInd = rs.getString("normalcy_ind") == null ? "" : rs.getString("normalcy_ind");
			result_status = rs.getString("STATUS") == null ? "" : rs.getString("STATUS");
			normalcy_str = rs.getString("NORMALCY_STR") == null ? "" : rs.getString("NORMALCY_STR");
			enctr_id = rs.getString("encounter_ID") == null ? "" : rs.getString("encounter_ID");
			fac_id = rs.getString("FACILITY_ID") == null ? "" : rs.getString("FACILITY_ID");
			event_code_type  = rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE"); 
			notify_alert = rs.getString("notify_alert")==null?"":rs.getString("notify_alert"); 
			notify_alert_yn = notify_alert;
			
			if(notify_alert.equals("Y")) { // ML-MMOH-CRF-0329.1 - Start
				notify_alert = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.notifyalert.label","ca_labels");
				ca_normalcy_ind = "Y";
			} else {
				notify_alert = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");
				ca_normalcy_ind = "C";
			} 
			cr_patient_class = patient_class;
			if("N".equals(pend_review_yn)){ //IN060133 - Start
				pend_done_status = beanObj.getResultPendingDoneStatus(practitioner_id, accessionNum, histRecType, contrSysId, event_code, contrSysEventCode, ca_normalcy_ind);
			} //IN060133 - End
			// ML-MMOH-CRF-0329.1 -END
				
			ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");
			
			if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
			//IN065341 ends				
				//pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
				String sql3="select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"; 
				sql3=sql3.replaceAll("##REPDB##",RepDb);
				pstmtImgView = con.prepareStatement(sql3);
			//IN065341 ends	
				pstmtImgView.setString(1,ext_image_upld_id);
				resImgView = pstmtImgView.executeQuery();
				
				String recCountInt = "";
				String perfFacilityId = ""; 
				while(resImgView.next())
				{
					ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
				}
				//IN065341 starts				
					//pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?");
					String sql4="select  distinct b.performing_facility_id from or_order_line ##REPDB## a,or_order ##REPDB## b where a.order_id = b.order_id and a.accession_num = ?"; 
					sql4=sql4.replaceAll("##REPDB##",RepDb);
					pstmtPerFacId = con.prepareStatement(sql4);
				//IN065341 ends	
				pstmtPerFacId.setString(1,ext_image_obj_id);
				rsetPerFacId = pstmtPerFacId.executeQuery();
				if(rsetPerFacId.next()){
					perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
				}
			
				if(perfFacilityId.equals("") || perfFacilityId == null){
					perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(ext_image_obj_id);
				}
				//IN065970 starts
				//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?");
				//IN065341 starts				
					//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
					String sql5="select count(*) from rl_specimen_image_dtls ##REPDB## where SPECIMEN_NO = ? and TEST_CODE = ?"; 
					sql5=sql5.replaceAll("##REPDB##",RepDb);
					pstmtImgCount = con.prepareStatement(sql5);
				//IN065341 ends	
				/*pstmtImgCount.setString(1,perfFacilityId);
				pstmtImgCount.setString(2,ext_image_obj_id);
				pstmtImgCount.setString(3,event_group);*/
				
				pstmtImgCount.setString(1,ext_image_obj_id);
				pstmtImgCount.setString(2,event_group);
				//IN065970 ends
				rsetImgCount = pstmtImgCount.executeQuery();
				if(rsetImgCount.next()) 
				{
					recCount = rsetImgCount.getInt(1);
				}
				recCountInt = String.valueOf(recCount);
				//IN065970 reopen
				//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",login_user).replace("~language_id#",locale); 
				ext_img_file_locn = ext_img_file_locn.replace("~specNum#",ext_image_obj_id).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); 
				//IN065970 reopen

				if(resImgView  != null) resImgView.close();
				if(pstmtImgView != null) pstmtImgView.close();

				if(rsetImgCount  != null)  rsetImgCount.close();
				if(pstmtImgCount  != null) pstmtImgCount.close();

				if(rsetPerFacId  != null) rsetPerFacId.close();
				if(pstmtPerFacId  != null) pstmtPerFacId.close();
			}	
			
			if(patient_class.equals("OP"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels");
			else if(patient_class.equals("IP"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels");
			else if(patient_class.equals("EM"))
				patient_class =	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels");
			else if(patient_class.equals("DC"))
				patient_class = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");

			details.setLength(0);
			details1 = "";
			if(!reported_by.equals(""))
				details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ReportedBy.label","common_labels") + " : " + reported_by);
			if(!patient_class.equals(""))
			{
				if(!(details.toString()).equals(""))
					details.append("<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels") + " : " + patient_class);
				else
					details.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels") + " : " + patient_class);
			}

			// ML-MMOH-CRF-0329.1 - Start
			if(pend_review_yn.equals("Y")){
				eventDesc = "<b>" + eventDesc + "</b>";
				eventTime = "<b>" + eventTime + "</b>";
				notify_alert = "<b>" + notify_alert + "</b>";
				review_result =  "<b>" + "Confirm" + "</b>";
				audit_link = "<b>" +"A" + "</b>";
			} else {
				review_result = "Reviewed";
				audit_link = "A";
			}
			// ML-MMOH-CRF-0329.1 - End
			if(!"".equals(accessionNum)) {
				audit_accession_num = accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("@"));
			//IN065341 starts
				//orderIdQry = "SELECT ORDER_ID FROM OR_ORDER_LINE  WHERE ACCESSION_NUM = ?";
				orderIdQry = "SELECT ORDER_ID FROM OR_ORDER_LINE ##REPDB## WHERE ACCESSION_NUM = ?";
				orderIdQry=orderIdQry.replaceAll("##REPDB##",RepDb);
			//IN065341 ends
				pStmtAudit = con.prepareStatement(orderIdQry);
				pStmtAudit.setString(1, audit_accession_num);
				rSetAudit = pStmtAudit.executeQuery();
				while(rSetAudit.next()){
					audit_order_id = rSetAudit.getString("ORDER_ID");
				}
			}
			// ML-MMOH-CRF-0329.1 - End
			if(!event_date.equals("") && !locale.equals("en"))
				event_date = com.ehis.util.DateUtils.convertDate(event_date,"DMY","en",locale);
			
			if(!eventClassDesc.equals(eventClassDescPrev) && !eventClassDesc.equals("")) {
				if(sStyle.equals(prefStyleSheet) )
				{
					out.println("<tr><td VALIGN=top  class='gridData' style='background-color:#C0C0C0' colspan=6 nowrap><b>"+eventClassDesc+"</b></td></tr>");
				}else
				{
					out.println("<tr><td VALIGN=top  class='gridData' colspan=6 nowrap><b>"+eventClassDesc+"</b></td></tr>");
				}
			}
			
			if(!histRecTypeDesc.equals(histRecTypeDescPrev))
			{
				i++;
				if(sStyle.equals(prefStyleSheet) )
				{
					out.println("<tr><td VALIGN=top  class='gridData' style='background-color:#C0C0C0' colspan=6 nowrap>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}else
				{
					out.println("<tr><td VALIGN=top  class='gridData' colspan=6 nowrap>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}

				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='20%'></td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts	
					//out.println("<td VALIGN=top  class='gridData1' width='5%' ><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' /><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%' ><img src='../../eCA/images/Arrow.gif' name='sub' alt='Sub' /><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends	
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%' ><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%'>"+review_result+"</td>");
						}
					}
					out.println("<td VALIGN=top  class='gridData1' width='20%'>"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'></td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts	
					//out.println("<td VALIGN=top  class='gridData1' width='5%' ><div title='Audit Trail'><a style='cursor:pointer;color:blue'  onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%' ><div title='Audit Trail'><a style='cursor:pointer;color:blue'  onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends		
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' alt='Audit Trail' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'>"+review_result+"</td>");
						}	
					}
					out.println("<td VALIGN=top  class='gridData1' width='20%' align='left'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%' align='left'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'>"+eventTime+"</td><td class='gridData1' width='35%' align='left'>");
				}
				j++;
				histRecTypeDescPrev = histRecTypeDesc;
				eventDatePrev = event_date;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
				eventClassDescPrev = eventClassDesc;
			}
			else if(!event_date.equals(eventDatePrev))
			{
				if(sStyle.equals(prefStyleSheet))
				{
					out.println("<tr><td VALIGN=top  class='gridData' style='background-color:#C0C0C0' colspan=6 nowrap>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}else
				{
					out.println("<tr><td VALIGN=top  class='gridData' colspan=6 nowrap>&nbsp&nbsp&nbsp&nbsp"+event_date+"</td></tr>");
				}
				
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='20%'></td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts	
					//out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue'  onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue'  onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends		
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%'>"+review_result+"</td>");
						}	
					}
					out.println("<td VALIGN=top  class='gridData1' width='20%'>"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'></td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts	
					//out.println("<td VALIGN=top  class='gridData1' width='5%' ><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%' ><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends	
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'>"+review_result+"</td>");
						}	
					}
					
					out.println("<td VALIGN=top  class='gridData1' width='20%' align='left'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%' align='left'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'>"+eventTime+"</td><td class='gridData1' width='35%' align='left'>");
				}
				j++;
				eventDatePrev = event_date;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
				eventClassDescPrev = eventClassDesc;
			}
			else if(!eventGroupDesc.equals(eventGroupDescPrev) || !eventTime.equals(eventTimePrev))
			{	
				if (!eventGroupDesc.equals(""))
				{
					out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>"+eventGroupDesc+"</td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='20%'></td>");
					out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+eventTime+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>&nbsp;</td></tr>");
					out.println("<tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts	
					//out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends	
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%'>"+review_result+"</td>");
						}	
					}
					out.println("<td VALIGN=top  class='gridData1' width='20%'>"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'></td><td class='gridData1' width='35%'>");
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts	
					//out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'>"+review_result+"</td>");
						}	
					}
					out.println("<td VALIGN=top  class='gridData1' width='20%' align='left'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%' align='left'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'>"+eventTime+"</td><td class='gridData1' width='35%'>");
				}
				j++;
				eventGroupDescPrev = eventGroupDesc;
				eventTimePrev = eventTime;
				eventClassDescPrev = eventClassDesc;
			}
			else if(eventGroupDesc.equals(eventGroupDescPrev) && eventTime.equals(eventTimePrev))
			{
				if(!eventGroupDesc.equals(""))
				{	
					out.println("<tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts	
					//out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends	
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%'>"+review_result+"</td>");
						}	
					}
					out.println("<td VALIGN=top  class='gridData1' width='20%'>"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'></td><td class='gridData1' width='35%' >");
									
				}
				else
				{
					out.println("<tr>");
					out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
				//IN065341 starts
					//out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
					out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"','"+facility_id+"')\">"+audit_link+"</a></td>");
				//IN065341 ends	
					if(pend_review_yn.equals("Y")){ 
						out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
					}else{
						if("N".equals(pend_done_status)){ //IN060133 - Start
							out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
						}else { //IN060133 - End
							out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'>"+review_result+"</td>");
						}	
					}
					
					out.println("<td VALIGN=top  class='gridData1' width='20%' align='left'>");
					out.println(eventDesc+"</td><td VALIGN=top class='gridData1' width='15%' align='left'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'>"+eventTime+"</td><td class='gridData1' width='35%' align='left'>");
				}
				j++;
			}
			else
			{
				out.println("<tr>");
				out.println("<td colspan='6'><table id='tab"+j+"' width='100%' class='innerGrid' cellspacing='0' cellpadding='0'><tr onmouseover='changeColor(this)' onmouseout='changeColor1(this,"+j+")' onclick='showDetailResult("+j+")'>");
			//IN065341 starts	
				//out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"')\">"+audit_link+"</a></td>");
				out.println("<td VALIGN=top  class='gridData1' width='5%'><div title='Audit Trail'><a style='cursor:pointer;color:blue' onClick=\"callAuditWindow('"+bean_id+"', '"+bean_name+"', '"+patient_id+"', '"+audit_order_id+"', '"+audit_accession_num+"','"+called_from+"','"+RepDb+"','"+clob_data+"')\">"+audit_link+"</a></td>");
			//IN065341 ends	
				if(pend_review_yn.equals("Y")){ 
					out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'><div title='FORWARD/COMPLETE REVIEW'><a style='cursor:pointer;color:blue' onClick=\"reviewResults('"+histRecType+"', '"+contrSysId+"', '"+contrSysEventCode+"', '"+accessionNum+"', '"+notify_alert_yn+"', '"+event_code+"', '"+ca_normalcy_ind+"', '"+practitioner_id+"', '"+login_user+"')\">"+review_result+"</a></td>");
				}else{
					if("N".equals(pend_done_status)){ //IN060133 - Start
						out.println("<td VALIGN=top  class='gridData1' width='15%'></td>");
					}else { //IN060133 - End
						out.println("<td VALIGN=top  class='gridData1' width='15%' align='left'>"+review_result+"</td>");
					}	
				}
				out.println("<td VALIGN=top  class='gridData1' width='20%' align='left'>"+eventDesc+"</td><td VALIGN=top class='gridData1' width='15%' align='left'>"+notify_alert+"</td><td VALIGN=top class='gridData1' width='10%' align='left'>"+eventTime+"</td><td class='gridData1' width='35%' align='left'>");
				j++;
			}

			if("LBIN".equalsIgnoreCase(histRecType) && "C".equalsIgnoreCase(result_status)) {
				out.println("<img src='../../eCA/images/modifiedresult.png' name='mod_result' alt='Result Modified'/>&nbsp;");
			}

			if(histDataType.equals("NUM"))
			{
				result_num_prefix = rs.getString("result_num_prefix")==null?"":rs.getString("result_num_prefix");
				resultNum = rs.getString("result_num")==null?"":rs.getString("result_num");
				resultNumUom = rs.getString("result_num_uom")==null?"":rs.getString("result_num_uom");
				normalLow = rs.getString("NORMAL_LOW")==null?"":rs.getString("NORMAL_LOW");
				normalHigh = rs.getString("NORMAL_HIGH")==null?"":rs.getString("NORMAL_HIGH");
				
				
				if(!normalLow.equals("") && !normalHigh.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : " + normalLow + " " + resultNumUom +" to "+ normalHigh + " " + resultNumUom ;
				else if(!normalLow.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (>=" + normalLow + " " + resultNumUom + ")" ;
				else if(!normalHigh.equals(""))
					details1 = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels") + " : (<=" + normalHigh + " " + resultNumUom + ")" ;
				else
					details1 = "";

				if(!details1.equals(""))
					details1 = details1 + "<br>" + details.toString();
				else
					details1 = details.toString(); 

				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				else
				{
					if(normalcyInd.equals("."))
					{
						if(legend_type.equals("S"))
							out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
						else
							out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					}
					else if(!normalLow.equals("") && !normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= 	Float.parseFloat(normalHigh)))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(!normalLow.equals("") && normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
					else if(normalLow.equals("") && !normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) <= 	Float.parseFloat(normalHigh))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}
				}
				
				if(Float.parseFloat(resultNum) < 1)
				{
					out.println("<b>"+result_num_prefix+Double.parseDouble(resultNum)+"</b>&nbsp;"+resultNumUom);
				}
				else
				{
					out.println("<b>"+result_num_prefix+resultNum+"</b>&nbsp;"+resultNumUom);
				}
			
				if(!resultStr.equals(""))
				{
					if(resultStr.length() > 25){
						tempStrValue = resultStr.substring(0,24);
						resultStr = replaceSpecialChar(resultStr);
						out.println("<a class='' href='#' title='"+resultStr+"'>"+tempStrValue+"...</a>");
					}else{
						out.println(resultStr);
					}
				}
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");commented for IN065341	
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");//IN065341	
				}
				out.println("<img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patient_id+"','"+event_code+"','"+event_group+"','"+histRecType+"')\" />");
			}
			else if(histDataType.equals("STR"))
			{
				details1 = details.toString();
				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				if(resultStr.length() > 25)
				{
					tempStrValue = resultStr.substring(0,24);
					resultStr = replaceSpecialChar(resultStr);
					out.println("<a class='' href='#' title='"+resultStr+"'>"+tempStrValue+"...</a>");
				}
				else
					out.println(resultStr);

				if(!normalcy_str.equals(""))
				{
					out.println(" <font color=blue>( Normal Value : "+normalcy_str+" )</font>");
				}
				
				if(textExist.equals("Y"))
				{
					//IN065341 starts
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");	
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");	
					//IN065341 ends
				}
			}
			else if(histDataType.equals("TXT")||histDataType.equals("HTM"))
			{
				if(!color_cell_indicator.equals(""))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' ></font>&nbsp;");
					else
						out.println("<font  style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px'></font>&nbsp;");
				}
				else if(normalcyInd.equals("."))
				{
					if(legend_type.equals("S"))
						out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
					else
						out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
				}
				details1 = details.toString();
				if(!histRecType.equals("CLNT")&& histDataType.equals("TXT"))
				{
					//out.println("Result Text:");
				}
				out.println("<b>"+resultNum+"</b>&nbsp;");
				
				if(!resultStr.equals(""))
				{
					//out.println("<b>"+resultNum+"</b>&nbsp;");

				}
				
				if(textExist.equals("Y"))
				{
					//IN065341 starts
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"')\" />");	
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\" />");	
					//IN065341 ends
				}
			}

			if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
			{
				if(!("DMS").equals(ext_image_appl_id)) { 	
					if(!("DOCUL").equals(ext_image_appl_id) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))) 
					{	
					//IN068797 starts	
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");	
						out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+ext_image_obj_id+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+fac_id+"')\">");
					//IN068797 ends	
					}
					else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
					{
					//IN068797 starts		
						//out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"')\">");
						out.println("<img src='../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('"+histRecType+"','"+contrSysId+"','"+accessionNum+"','"+contrSysEventCode+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+fac_id+"')\">");
					//IN068797 ends		
					}
					else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) {
						out.println("<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"><br></br> View Image </a>");
					}
				}	
			} 


			if("Y".equals(dmsExternalLinkYN)) {
				extLinkHashMap = oEncounterList.getExternalLinkParameters(facility_id, patient_id, enctr_id, locale); 
				admit_date	= (String) extLinkHashMap.get("P_ENCNTR_DATE");
				locn_code	= (String) extLinkHashMap.get("P_LOCN_CODE");
				locn_type	= (String) extLinkHashMap.get("P_LOCN_TYPE");
				visit_id	= (String) extLinkHashMap.get("P_VISIT_ID");
				loc_desc	= (String) extLinkHashMap.get("P_LOC_DESC");
				physician_id	= (String) extLinkHashMap.get("P_PHYSICIAN_ID");
				encntr_type	= (String) extLinkHashMap.get("P_EPISODE_TYPE");
				externalList = oEncounterList.getExternalLinkdata(histRecType, contrSysId, accessionNum, contrSysEventCode); 

				Iterator iter = externalList.iterator(); 
				while(iter.hasNext()){
					externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
					ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
					ext_image_obj_id_dms = externalDataDTO.getExt_image_obj_id();
					ext_image_source = externalDataDTO.getExt_image_source();
					ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
					ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();	
				
					if("RD".equals(event_code_type)) { 		
						
						if ((ext_image_obj_id.equals(null) || ext_image_obj_id.equals(""))) 
							access_no_rd 	= accessionNum.substring(accessionNum.indexOf("#")+1, accessionNum.indexOf("$"));
						else
							access_no_rd 	= ext_image_obj_id;
										
						pstmtOrderId = con.prepareStatement("select  order_id, order_type_code from or_order_line where accession_num = ?"); 
						pstmtOrderId.setString(1,access_no_rd);
						rsetOrderId = pstmtOrderId.executeQuery();
						if(rsetOrderId.next()){
							order_id = rsetOrderId.getString("order_id") == null ? "":  rsetOrderId.getString("order_id");
							order_typ_code	= rsetOrderId.getString("order_type_code") == null ? "":  rsetOrderId.getString("order_type_code");	
						}
						
						if(rsetOrderId  != null) rsetOrderId.close();
						if(pstmtOrderId  != null) pstmtOrderId.close();
						
							
						out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">");  
					}	
					else {
						out.println("<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patient_id+"','"+enctr_id+"','"+accessionNum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+login_user+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id_dms+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">");
					}	
				}	
			}

			if(result_status.equals("P"))
				out.println("<font color='red'>(Preliminary)</font>");

			out.println("</td></tr>");
			out.println("<tr style='display:none'><td class='gridData1' colspan='6'>"+details1+"</td></tr>");
			out.println("</table></td></tr>");
			
			start++;
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		}
		/*
			To display rejected test
		*/
		if(maxCount == 0)
			out.println("<table class='grid' width='100%' id='tb1' cellspacing='0' cellpadding='0' >");
		
		//if(maxCount>0){
		//IN065341 starts
			//String rejectedSQL = "SELECT   SPECIMEN_NO, TEST_CODE, CANCEL_CODE, CANCELLED_REASON, CANCELLED_YN, CANCEL_REMARKS, TO_CHAR (CAN_DATE_TIME, 'dd/mm/yyyy') CAN_DATE,  TO_CHAR (CAN_DATE_TIME, 'hh24:mi') CANCEL_TIME,(SELECT   SHORT_DESC  FROM   RL_TEST_CODE_LANG_VW B WHERE   LANGUAGE_ID = 'en' AND B.TEST_CODE =A.TEST_CODE)TEST_CODE_DESC FROM RL_REQUEST_DETAIL A WHERE   PATIENT_ID = ? AND CANCELLED_YN = 'Y'";		
			String rejectedSQL = "SELECT   SPECIMEN_NO, TEST_CODE, CANCEL_CODE, CANCELLED_REASON, CANCELLED_YN, CANCEL_REMARKS, TO_CHAR (CAN_DATE_TIME, 'dd/mm/yyyy') CAN_DATE,  TO_CHAR (CAN_DATE_TIME, 'hh24:mi') CANCEL_TIME,(SELECT   SHORT_DESC  FROM   RL_TEST_CODE_LANG_VW ##REPDB## B WHERE   LANGUAGE_ID = 'en' AND B.TEST_CODE =A.TEST_CODE)TEST_CODE_DESC FROM RL_REQUEST_DETAIL ##REPDB## A WHERE   PATIENT_ID = ? AND CANCELLED_YN = 'Y'";	
			rejectedSQL=rejectedSQL.replaceAll("##REPDB##",RepDb);
		//IN065341 ends
		String cancelDatePrev = "";
		int rejectCount = 0;
		stmt = con.prepareStatement(rejectedSQL);
		stmt.setString(1, locale);
		stmt.setString(1, patient_id);
		rs = stmt.executeQuery();
		while(rs.next())
		{
			rejectCount = rejectCount+1;
		}
		if(rs!=null) rs.close();
		
		rs = stmt.executeQuery();
		if(maxCount <= end) {
			if(rejectCount !=0) {
				out.println("<tr></tr>");	
				out.println("<tr><th colspan='6'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.rejectedtl.label","ca_labels")+"</th></tr>");
				out.println("<tr><th width='35%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.testcode.label","ca_labels")+"</th><th width='50%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.rejectreason.label","ca_labels")+"</th><th width='15%'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.rejectedtime.label","ca_labels")+"</th></tr>");	
			}
			while(rs.next()){
				i++;
				test_code 			= rs.getString("TEST_CODE")==null?"":rs.getString("TEST_CODE");
				test_code_desc 		= rs.getString("TEST_CODE_DESC")==null?"":rs.getString("TEST_CODE_DESC");
				cancelled_reason 	= rs.getString("CANCELLED_REASON")==null?"":rs.getString("CANCELLED_REASON");
				cancel_code 		= rs.getString("CANCEL_CODE")==null?"":rs.getString("CANCEL_CODE");
				cancel_date			= rs.getString("CAN_DATE")==null?"":rs.getString("CAN_DATE");
				cancel_time			= rs.getString("CANCEL_TIME")==null?"":rs.getString("CANCEL_TIME");
				
				if( !cancel_date.equals(cancelDatePrev))
				{
					out.println("<tr><td VALIGN=top  class='gridData'  nowrap>&nbsp&nbsp&nbsp&nbsp<b>"+cancel_date+"</b></td></tr>");	
				}
				out.println("<tr><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>"+test_code_desc+"</td>");
				out.println("<td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='15%'>"+cancelled_reason+"</td><td VALIGN=top class='gridData' style='background-color:#EEEEEE' width='35%'>"+cancel_time+"</td></tr>");
				cancelDatePrev = cancel_date;
			}
		}
		//}		
		if (i==0)
		{
			out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoResultdata.label","ca_labels")+"</td></tr>");		
		}
		else if (modal_yn.equals("N"))
		{
%>

			 <!-- <tr><td colspan='6' class='gridData'><a class='gridLink' href="javascript:callResults('<%=patient_id%>','<%=title%>','<%=reln_id%>','<%=enc_id%>','<%=facility_id%>','<%=content_ID%>')"><fmt:message key="eCA.MoreDtlRef.label" bundle="${ca_labels}"/></a></td></tr> --><!--added arguments facility_id and content_ID for IN038454 --> <!--commented for IN065341-->
			 <tr><td colspan='6' class='gridData'><a class='gridLink' href="javascript:callResults('<%=patient_id%>','<%=title%>','<%=reln_id%>','<%=enc_id%>','<%=facility_id%>','<%=content_ID%>','<%=called_from%>','<%=RepDb%>','<%=clob_data%>')"><fmt:message key="eCA.MoreDtlRef.label" bundle="${ca_labels}"/></a></td></tr><!--IN065341-->
<%
		}
	}	
	catch(Exception e)
	{
	//	out.println(e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{	
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
%>
</table>
</center>
		<input type=hidden name='from' id='from' value='<%=start%>'>
		<input type=hidden name='to' id='to' value='<%=end%>'>
		<input type=hidden name='start' id='start' value='<%=start%>'>
		<input type=hidden name='end' id='end' value='<%=end%>'>
		<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'> 
		<input type="hidden" name="enc_id" id="enc_id" value='<%=enc_id%>'> 
</form>
</body>
</html>
<%!
	String replaceSpecialChar(String resultStr)
	{		
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","~");			
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		if(resultStr.indexOf("\"")!=-1)
			resultStr = resultStr.replaceAll("\"","|");
		return resultStr;
	}
%>

