<!-- 
---------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
---------------------------------------------------------------------------------------------------------------------------------------------------------------
?             100            ?           created
05/04/2012	  IN031989		Menaka V	 When a patient is selected by using patient without encounter search function and when clinical
										 event history is accessed the note header is incomplete for all the existing notes for that patient.
20/06/2012	  IN033489		Menaka V		Report header blank in clinical event history.
07/01/2013	  IN035950		Nijitha		CHL Hospital suggested that the presentation of the Clinician desktop be changed and 
										more appealing. Keeping the display of information more clear and visible.
12/03/2013    IN037900      Chowminya G  System is displaying wrong data for the decimal numeric component - max data			
30/05/2013	  IN037793		Karthi L	To be able to view the Specimen image attachment in 'Existing Orders' function and 'Clinical Event History' function in OR and CA.[IN040416]
17/06/2013	IN040866		Karthi L	System is not displaying the Image in CA 
22/06/2013  IN040416		Nijitha S   CRF-OR-Bru-HIMS-CRF-052.1/02-System is not displaying 'View' hyperlink for the Laboratory Panel Order  
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
28/03/2014	IN047204		Karthi L		07/03/2014		Ramesh 			Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to. 
12/03/2014	IN047566		Akbar											Linked issue of Bru-HIMS-CRF-195.2-47204/01
19/03/2014	IN47847			Nijitha S										Order result screen for Radiology to provide a link to the DMS URL where the scanned radiology result document is uploaded to
01/04/2014	IN048253		Karthi L		01/04/2014		Akbar			Getting Script error when click on External Application link icon.
15/05/2014	IN047205		Karthi L		16/05/2014		Ramesh			Changes to clinical event history and chart summary view - to provide link to the scanned document in clinical views
09/06/2014	IN049533		Karthi L										DMS Document Uploaded is not displayed in chart summary
08/09/2014  IN050936		Chowminya										None of the order retrieving any image from RIS/PACS but already having order image in PACS		
19/03/2015	IN052800		Karthi L										If link image for Histology orderable, from CA, user not able to view the image. No link appear under View.
09/10/2015	IN055910		Karthi L										From Clinician Access, modified result shall be identified by include ?!? in Blue color
10/10/2016	IN047572		Karthi L										[MMS-QH-CRF-0177]To provide attending doctor and specialty  filter in the ?View Clinical Notes? and ?Clinical Event History?
07/07/2017	IN064688		Raja S			08/07/2017		RameshG			ML-MMOH-SCF-0753
07/11/2017	IN064132		Raja S			07/11/2017		Ramesh G		ML-MMOH-CRF-0831
07/02/2018	IN065970		Vijayakumar K	07/02/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970]
07/03/2018	IN065970		Vijayakumar K	07/03/2018		RameshGo		ML-BRU-SCF-1611.1 [IN:065970] reopen
19/03/2018	IN067037		Raja S			19/03/2018		Ramesh G		ML-BRU-SCF-1787
16/01/2019	IN068560		Raja S			16/01/2019		Ramesh G		ML-MMOH-SCF-1078
18/12/2018      IN069665      	        Sivabagyam M	        18/12/2018	    Ramesh G	   CA-ML-MMOH-CRF-1148-US003-01
04/02/2019  IN066453        Ramya Maddena   06/02/2019      Ramesh G        ML-BRU-CRF-0491
08/02/2019  IN068560		Prakash C    	08/02/2019		Ramesh G		ML-MMOH-SCF-1078
26/02/2019	IN069290		Raja S			26/02/2019		Ramehs G		ML-MMOH-CRF-1317
04/03/2019	IN069028		Ramesh G		04/03/2019		Ramesh G		ML-MMOH-CRF-1293
30/07/2019	IN070610		Dinesh T		30/07/2019		Ramesh G		TBMC-CRF-0011.1
06/08/2019	IN071106		Dinesh T		06/08/2019		Ramesh G		ML-MMOH-SCF-1341
06/09/2019	IN071127		Sivabagyam M	06/09/2019		Ramesh G		Alpha-RL-Unable to attach images for Interval test...
21/10/2019	IN069242		Sivabagyam			22/10/2019	Ramesh Goli			GHL-CRF-0567
03/02/2020			IN071561	SIVABAGYAM M		03/02/2020		RAMESH G		GHL-CRF-0558.1
06/04/2020	IN071865		Sivabagyam M		06/04/2020		Ramesh G		ML-MMOH-CRF-1484 
15/12/2020	7902		Sivabagyam M		15/12/2020		Ramesh G	MMS-DM-CRF-0180.1
05/01/2021	6030		Sivabagyam M		05/01/2021		Ramesh G	ML-MMOH-CRF-1491
15/01/2021	7632		Sivabagyam M		15/01/2021		Ramesh G	ML-MMOH-CRF-1261.1
20/04/2021	6484			Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
16/08/2022	29803			Ramesh G 										ML-BRU-CRF-0635
03/02/2020	39052			Ramesh											ML-BRU-CRF-0634
20/07/2023	  24094	   Ranjith P R		21/07/2023		RAMESH G		ML-MMOH-CRF-1804
07/09/2023	  31792	   Ranjith P R		08/09/2023		RAMESH G		ML-MMOH-CRF-1913
---------------------------------------------------------------------------------------------------------------------------------------------------------------
--> 
<%@page import="java.sql.*,java.io.*,webbeans.eCommon.*,java.util.*,java.util.zip.*,java.math.*,eCommon.XSSRequestWrapper" %><!--IN064688 Added  math.*-->
<%@page contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
<head>
<style>
TD.CAGREEN
{
	FONT-SIZE: 9PT ;
	BACKGROUND-COLOR: #99CC00;
	BORDER-STYLE: SOLID;
	BORDER-LEFT-COLOR: #B2B6D7;
	BORDER-RIGHT-COLOR: #B2B6D7;
	BORDER-TOP-COLOR: #E2E3F0;
	BORDER-BOTTOM-COLOR: #E2E3F0;
}

TD.TD_BROWN
{
    BACKGROUND-COLOR: BROWN;  
	COLOR = WHITE;
	FONT-SIZE: 9pt ;
	BORDER-STYLE: SOLID;
	border-left-color: #B2B6D7;
	border-right-color: #B2B6D7;
	border-top-color: #E2E3F0;
	border-bottom-color: #E2E3F0;
	height:18;	

}
</style>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String patientid = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String enc_id = request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String EHR_YN = request.getParameter("EHR_YN")==null?"N":request.getParameter("EHR_YN");
	String sortOrder		= request.getParameter("graphorder")==null?"desc":request.getParameter("graphorder");
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	    
	String encounterIDBeanKey = "";
	if(enc_id.equals("")) enc_id = "0";
	String fac_id="";//IN033489
	encounterIDBeanKey = enc_id;
	String login_at_ws_no		= p.getProperty("client_ip_address")== null ?"":p.getProperty("client_ip_address");	// IN047204
	String ext_facility_id= (String) session.getValue("facility_id"); // IN047204

	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+patientid+encounterIDBeanKey,"eCA.PatientBannerGroupLine",session);
%>
<%!
//IN071106, starts
private String extractSpecimenNumber(String str, String firstSplitter, String secondSplitter)
{
	if(str!=null && str.length()>0)
		return str.substring(str.indexOf(firstSplitter)+1, str.indexOf(secondSplitter));
	return "";
}
//IN071106, ends
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script src='../../eCA/js/Encounters.js' language='javascript'></script>
	<script src='../../eCA/js/CAOpenExternalApplication.js' language='javascript'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eXH/js/ExternalApplication.js' language='javascript'></script> <!-- added for IN047024 -->
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> <!-- added for IN048253 -->
<script>

function changeColor(encounter_id,sortEventDateTime,classValue,obj,eventDate,Histrectype,Contrsysid,Accessionnum,Contrsyseventcode,rowNum)
{
	var patient_id = document.forms[0].patient_id.value;
	var enc_id = document.forms[0].enc_id.value;
	
	if(enc_id == "" || enc_id == null) enc_id = "0";
	if(encounter_id == "" || encounter_id == null) encounter_id = "0";

	rowNum = parseInt(rowNum,10);

	var addRemove = "Add";
    var comImg = document.getElementById('commImage'+rowNum);

	if(obj.className == 'gridDataSelect')
	{
		addRemove = "Remove";
		obj.className = 'gridDataChart';
	}
	else
	{
		addRemove = "Add";
		obj.className = 'gridDataSelect';
	}

	var valsToRemove = encounter_id+"`"+Histrectype+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;
	var valsToSort = encounter_id+"`"+Histrectype+"`"+sortEventDateTime+"`"+Contrsysid+"`"+Accessionnum+"`"+Contrsyseventcode;

	parent.parent.parent.manageEmailFrame.location.href = '../../eCA/jsp/EncountersManageEmail.jsp?addRemove='+addRemove+'&valsToRemove='+escape(valsToRemove)+'&sortEventDateTime='+sortEventDateTime+'&valsToSort='+escape(valsToSort)+'&patient_id='+patient_id+'&encounter_id='+enc_id;
}
</script>

<script language="VBScript">
	Sub callAviDcm(extn)
		On Error Resume Next
		dim x
    	Set objNet = CreateObject("WScript.Shell")
		if lcase(extn) = "avi" then
			x = objNet.Run("Z:\Avi\invokeavi.bat",0) 
		ELSEIF lcase(extn) = "dcm" then
			x = objNet.Run("Z:\DCM\ShowDCM.bat",0) 
		end if
	end sub
</script>
</head>

<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="details2_form" id="details2_form">
<script language=javascript>
document.body.style.scrollbarBaseColor='#E2E3F0';
document.body.style.scrollbarArrowColor='#000080';
document.body.style.scrollbarDarkShadowColor='#E2E3F0';
document.body.style.scrollbarFaceColor='#E2E3F0';
document.body.style.scrollbarHighlightColor='white';
document.body.style.scrollbarShadowColor='#E2E3F0';
document.body.style.scrollbar3dlightColor='#E2E3F0';
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	PreparedStatement stmt2 = null;
	PreparedStatement stmt = null;
	PreparedStatement stHist=null;
	ResultSet rs = null;
	ResultSet rsHist=null;
	
	PreparedStatement pstmtImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793] [IN040416]
	ResultSet resImgView = null; // added for Bru-HIMS-CRF-052.1 [IN037793] [IN040416]
	PreparedStatement pstmtImgCount = null; // [IN037793] [IN040416]
	ResultSet rsetImgCount = null; // added for Bru-HIMS-CRF-052.1 [IN037793] [IN040416]
	PreparedStatement pstmtPerFacId = null; // IN040866
	ResultSet rsetPerFacId = null;  // IN040866	
	PreparedStatement pstmtOrderId = null; // IN047204
	ResultSet rsetOrderId = null;  // IN047204
	ArrayList keyList = manageEmailBean.returnList2();

	String loggedUser = (String)session.getValue("login_user");
	String include_normalcy_indicator = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");
	String viewby = request.getParameter("viewby")==null?"N":request.getParameter("viewby");
	
	String abnormal = request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
	String selectedhisrectype = request.getParameter("hist_type")==null?"":request.getParameter("hist_type");
	String selectedeventgroup = request.getParameter("event_group")==null?"":request.getParameter("event_group");
	if(selectedeventgroup.equals("null")) selectedeventgroup = "";
	String selectedeventclass = request.getParameter("event_class")==null?"":request.getParameter("event_class");
	String selectedeventcode = request.getParameter("event_item")==null?"":request.getParameter("event_item");
	String eventdate = request.getParameter("event_date")==null?"":request.getParameter("event_date");
	String order_type_3T	= request.getParameter("order_type_3T")==null?"": request.getParameter("order_type_3T");//39052
	String fromdate	= request.getParameter("from_date")==null?"": request.getParameter("from_date");
	String todate = request.getParameter("to_date")==null?"": request.getParameter("to_date");
	String eventClasswidget		= request.getParameter("p_event_class_widget")==null?"":request.getParameter("p_event_class_widget");//IN035950
String called_from_widget		= request.getParameter("p_called_from_widget")==null?"":request.getParameter("p_called_from_widget");//IN035950
String p_review_rad_yn=request.getParameter("p_review_rad_yn")==null?"N":request.getParameter("p_review_rad_yn");//IN071561
	fromdate = com.ehis.util.DateUtils.convertDate(fromdate,"DMYHM",locale,"en");
	todate = com.ehis.util.DateUtils.convertDate(todate,"DMYHM",locale,"en");

	String facility_id	= request.getParameter("facility_id")==null ?"": request.getParameter("facility_id");
	String page_no	= request.getParameter("page_no")==null ?"1": request.getParameter("page_no");
    String key_ref = patientid+encounter_id+facility_id;
	StringBuffer str_rowid = new StringBuffer();
	String key_value = "";
	int image_count=0;//IN071127
	String ext_image_upld_id = ""; //Bru-HIMS-CRF-052.1  [IN037793] [IN040416]
	String ext_img_file_locn = ""; //Bru-HIMS-CRF-052.1  [IN037793] [IN040416]
	String html_image_upld_id = ""; //IN069028
	int recCount = 0; // added for Bru-HIMS-CRF-052.1 [IN037793] [IN040416]
	
	String speciality_code		=	request.getParameter("speciality_code")==null?"":request.getParameter("speciality_code");  // MMS-QH-CRF-0177 [IN047572]	
	String attend_pract_code	= 	request.getParameter("attend_pract_code")==null?"":request.getParameter("attend_pract_code"); // MMS-QH-CRF-0177 [IN047572]			

	eCA.ChartRecordingAddGroupBean encounterBean = (eCA.ChartRecordingAddGroupBean)getObjectFromBean("encounterBean"+key_ref,"eCA.ChartRecordingAddGroupBean",session);
	//IN070610, starts
	ArrayList<String> funcIds = new ArrayList<String>();
	funcIds.add("UPLOAD_TR_CATEGORY_ORDERS");
	encounterBean.adapter.setSiteSpecific(funcIds,"OR");
	Boolean uploadFuncTrOrders = encounterBean.adapter.isSiteSpecific("UPLOAD_TR_CATEGORY_ORDERS");
	//IN070610, ends

	int no_page = Integer.parseInt(page_no);
	no_page = (no_page*15) - 14;
	
	for(int i=no_page;i<=(no_page+14);i++)
	{
		Integer in = new Integer(i);
		key_value = encounterBean.getRecords(in.toString());
		if(key_value!= null)
		{
			if(i == no_page)
				str_rowid.append("\'"+key_value+"\'");
			else
				str_rowid.append(",\'"+key_value+"\'");
		}
	}
	
	StringBuffer sql =new StringBuffer();
	String outdata = "";
	String printdata = "";
	String hospitalname = "";
	String titleofdocument = "";
	String pline = "";
	String enctr_id = "";
	
	String delta_fail_id_ind = "",color_cell_indicator="";
	String descCellInd = "";
	String resp_id = (String)session.getValue("responsibility_id");
	String sqlstr="", conf_access_flag="";
	String performed_by = "";
	String Specimen_num = "";  //IN066453
	String categoryNum = "";//IN066453
	String Specimen_num1 =""; //IN066453
	String Specimen_num2 ="";//IN066453
	String resultNum = "0";
	String normalcy_str = "";
	int histcount = 0;
	//IN047204 - Start
	String access_no_rd 	= "";
	String order_id 	= ""; 
	String order_typ_code	= "";
	String locn_code	= "";		
	String locn_type	= "";
	String loc_desc		= "";
	String visit_id		= "";
	String physician_id	= "";
	String admit_date	= "";
	String encntr_type	= "";
	HashMap extLinkHashMap = null;
	boolean isClinician=false;//IN069665
	//IN047204 - End
	eCA.CAExternalLinkDataDTO externalDataDTO = null; //Bru-HIMS-CRF-195.3 - IN047205
	eCA.CAEncounterList oEncounterList = new eCA.CAEncounterList();  //Bru-HIMS-CRF-195.3 - IN047205
	//IN064132 changes starts
	String resulted_practitioner = "";
	boolean isPracSiteSpecific = false;
	//IN064132 changes ends
	boolean isVerifiedSiteSpec = false;//IN069290
	boolean restrict_rd=false;//IN071561
	if(resp_id == null)resp_id ="";
	   boolean isViewLabRes=false;//IN069290
	boolean isSiteSpecificNeonatalMotherSpecimen=false;//31792
	try
	{
        con = ConnectionManager.getConnection(request);	
		isViewLabRes=eCommon.Common.CommonBean.isSiteSpecific(con, "CA","ORDERBY_BASEDON_LAB_SEQ");//IN069290
        isPracSiteSpecific = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","RESULTED_PRACTITIONER"); //Added for IN064132
        isClinician = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","CLINICIAN_TO_THERAPIST");//IN067236
		isVerifiedSiteSpec = eCommon.Common.CommonBean.isSiteSpecific(con, "CA","VERIFIEDBY_PRACTITIONER"); //Added for IN069290
		restrict_rd =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","RD_PEER_REVIEW_RESTRICT");//IN071561
		isSiteSpecificNeonatalMotherSpecimen = eCommon.Common.CommonBean.isSiteSpecific(con,"OR","NEONATAL_MOTHER_SPECIMEN");//31792
		sqlstr=" select get_patient.get_line_detail(?,?) Pline, nvl(GET_TASK_APPLICABILITY(?,NULL,?,?),'X') conf_access_flag FROM dual ";
		stmt2 = con.prepareStatement(sqlstr);
		stmt2.setString(1, patientid);
		stmt2.setString(2,locale);
		stmt2.setString(3, "VIEW_CONF_RESULT");
		stmt2.setString(4, resp_id);
		stmt2.setString(5, reln_id);
		rs = stmt2.executeQuery();
		if(rs != null && rs.next())
		{
			pline = rs.getString("Pline").replace('|',',');
			conf_access_flag =rs.getString("conf_access_flag");
		}
 
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//IN033489
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//IN033489//IN037900 // commented for Bru-HIMS-CRF-052.1 [IN037793]  [IN040416]
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); // commented for Bru-HIMS-CRF-052.1 [IN037793]  [IN040416] - a.EVENT_CODE_TYPE added for IN047204 //commented for  IN064688
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind, normal_low , normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); // commented for Bru-HIMS-CRF-052.1 [IN037793]  [IN040416] - a.EVENT_CODE_TYPE added for IN047204 //Modified for IN064688//Commented for IN064132
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX, RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind, normal_low , normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); // modified for IN064132 //commented for IN067037
		//sql.append("  Select NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); // modified for IN067037//commented for IN066453
		//IN069028 Start.
		//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); // added for IN066453
		//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); 		//IN069028 End.
		
		//IN070610, starts
		//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); 		//IN069028 End.
		if(uploadFuncTrOrders){
			//IN069242 Start.
			//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); 		//IN069028 End.
			
				if(!isViewLabRes){
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus  From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn  From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
					sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn  From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
					
				}
					else{
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus   From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn   From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
					sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,(select count(*) from CR_ENCOUNTER_DETAIL_OBJ where accession_num = a.ACCESSION_NUM)uploaded_doc_cnt,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn   From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094//31792
					
					}			//IN069242 End.
		}else{
			//IN069242 Start.
			//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID "); 		//IN069028 End.		
			 
				if(!isViewLabRes){
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus   From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030 
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn   From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
					sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn   From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094//31792
					
				}
					else{
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"') encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) estricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no  From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ? AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//6030
					//sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094
					sql.append("  Select a.REQUEST_NUM Specimen_num,a.CATEGORY_NUMBER, NVL(TO_CHAR(F.VISIT_ADM_DATE_TIME,'YYYYMMDDHH24MI'),'EXTERNAL') GROUP2, a.hist_rec_type,CR_GET_DESC.CR_HIST_REC_TYPE(a.hist_rec_type,?,'1') hist_rec_type_desc,a.event_class,CR_GET_DESC.CR_EVENT_CLASS(A.HIST_REC_TYPE,A.EVENT_CLASS,?,'1')  event_class_desc,a.event_group,CR_GET_DESC.CR_CLIN_EVENT_GROUP(A.HIST_REC_TYPE,A.EVENT_GROUP,A.EVENT_GROUP_TYPE,?,'1') event_group_desc,a.event_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,rtrim(A.EVENT_CODE),A.EVENT_CODE_TYPE,?,'1')  event_desc ,a.accession_num,a.contr_sys_id,a.contr_sys_event_code,to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time,to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date,a.HIST_DATA_TYPE,a.hist_rec_type,RESULT_NUM_PREFIX,DECODE(nvl(RESULT_NUM_DEC,0),0,TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM, a.RESULT_NUM_UOM,a.result_str,a.normalcy_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high,a.performed_by_id ,AM_GET_DESC.AM_PRACTITIONER(DECODE(A.AUTHORIZED_BY_ID,'',a.performed_by_id,A.AUTHORIZED_BY_ID),'"+locale+"','1') resulted_practitioner,AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') clinician_short_name,CA_GET_VISIT_HDR_NEW(a.facility_id,a.patient_class, a.encounter_ID,a.PATIENT_ID,  a.performed_by_id,'"+locale+"',a.hist_rec_type,'"+isPracSiteSpecific+"',A.AUTHORIZED_BY_ID) encline ,a.NORMAL_LOW,a.NORMAL_HIGH ,a.CRITICAL_LOW ,a.CRITICAL_HIGH ,a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.STATUS,a.normalcy_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND, a.DELTA_FAIL_IND ,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,a.encounter_ID, a.NORMALCY_STR,F.FACILITY_ID,TO_CHAR(RESULT_NUM) RESULT_NUM1, RESULT_NUM_DEC, A.EXT_IMAGE_UPLD_ID, a.event_code_type, A.HTML_IMAGE_UPLD_ID,CA_GET_RESTRICTING_CEH(a.hist_rec_type,A.EVENT_CLASS) restricting_print,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.result_status resultStatus,to_char(a.modified_date,'dd/mm/yyyy hh24:mi') modified_date,NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn,or_get_neonate_spec_yn(NULL,NULL,NULL,a.hist_rec_type,a.accession_num)lv_neonate_spec_yn From cr_encounter_detail a ,PR_ENCOUNTER F where a.patient_id = ?  ##ORDERTYPERESULT## AND F.FACILITY_ID(+)= A.FACILITY_ID AND F.ENCOUNTER_ID(+) = A.ENCOUNTER_ID ");//24094//31792
					
					}
				
			//IN069242 End.
		}
		//IN070610, ends
		if (!conf_access_flag.equals("A")) 
			sql.append(" and nvl(a.PROTECTION_IND,'N')!='Z' ");

		sql.append(" and nvl(a.STATUS,'`') not in('S','E')");  

		if(abnormal.equals("Y")) //to limit to abnormal events only
		{
			sql.append(" and nvl(a.normalcy_ind,'.')!='.' ");
		}

		if(!eventdate.equals("") && viewby.equals("D"))
			sql.append(" and  trunc(a.event_date)= to_date(?,'dd/mm/yyyy')");
		
		if(!selectedhisrectype.equals(""))
			sql.append(" and a.hist_rec_type = ? ");
		if(!selectedeventclass.equals(""))
			sql.append(" and a.EVENT_CLASS = ? ");
		if(!selectedeventgroup.equals(""))
			sql.append(" and a.EVENT_GROUP = ? ");
		if(!selectedeventcode.equals(""))
			sql.append(" and rtrim(a.EVENT_CODE) = ? ");
		if(!fromdate.equals("")){
			sql.append(" and A.EVENT_DATE >= to_date(NVL(?,'01/01/1000'),'dd/mm/yyyy hh24:mi') ");
		}

		if(!todate.equals("")){
			sql.append(" and A.EVENT_DATE <= to_date(NVL(?,'01/01/9999'),'dd/mm/yyyy hh24:mi')+.00068287 "); //adding 59 seconds more to the todate
		}
		//IN071561 STARTS
		if(restrict_rd)
			   sql.append( " AND RD_PEER_RESULT_HIDE_YN (a.CONTR_SYS_ID,a.facility_id,A.REQUEST_NUM,a.request_num_seq,'"+loggedUser+"')='N' ");
			   //IN071561 ENDS
		if(!facility_id.equals(""))
			sql.append(" and a.facility_id = ?");
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && "".equals(eventClasswidget))
		{
			sql.append(" AND a.event_class IN ('PHY$','CLI$','NUR$') ");
		}
		else if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			sql.append(" AND a.event_class=? ");
		}
		//IN035950 End

		if(!encounter_id.equals(""))
			sql.append(" and a.ENCOUNTER_ID = ? ");

		sql.append(" and a.rowid in( "+str_rowid.toString()+" ) ");
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				sql.append(" and f.SPECIALTY_CODE = ? ");
			}
		} else {
			sql.append(" and f.ATTEND_PRACTITIONER_ID = ? ");
		} // MMS-QH-CRF-0177 [IN047572] - End
     	sql.append(" order by ");
		
		sql.append(" 1 ");//commented and added in else for IN071865  //Un commented 
		sql.append(sortOrder+" ,");//commented and added in else for IN071865  //Un commented 
		//IN071865 starts  
		if(viewby.equals("D")) 
		{
			sql.append(" TO_CHAR(event_date,'YYYYMMDD') , ");  //Un commented  
			//sql.append(" event_date ");		// commented
			//sql.append(sortOrder+" ,") ;		// commented
		}
		else{
			//sql.append(" 1 ");			// commented
			//sql.append(sortOrder+" ,");		// commented
		}

		
		if(!isViewLabRes)
			sql.append(" 3,2,5,4,nvl(a.REQUEST_NUM_SEQ,'0'),7,6,9,8 ");//6030
			else
				sql.append(" 3,2,5,4,NVL(sequence_no,0),7,6,9,8 ");//6030
		
		// commented
		/*
		if(!viewby.equals("D"))
		{
			sql.append(", event_date  ");  
			sql.append(sortOrder);
		}
		*/
		// commented
		//IN071865 ends

		outdata = outdata +"<table class='grid' cellspacing=0 cellpadding=0 width='100%'>";
		printdata = printdata +outdata;
		//39052 Start.
		String  sqlQuery = sql.toString();
		if("CA01".equals(order_type_3T)){
			sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##"," AND 'CA01'=SUBSTR(a.ACCESSION_NUM,0,4) ");
		}else{
			sqlQuery=sqlQuery.replaceAll("##ORDERTYPERESULT##","");
		}
		//39052 End.

		stmt=con.prepareStatement(sqlQuery);
			
		int count1 = 0;
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,locale);
		stmt.setString(++count1,patientid);
		
		
		if(!eventdate.equals("") && viewby.equals("D"))
		{
			stmt.setString(++count1,eventdate);
			
		}	
		if(!selectedhisrectype.equals(""))
		{
			stmt.setString(++count1,selectedhisrectype);
			
		}	
		if(!selectedeventclass.equals(""))
		{
			stmt.setString(++count1,selectedeventclass);

		}
		if(!selectedeventgroup.equals(""))
		{
			stmt.setString(++count1,selectedeventgroup);
			
		}	
		if(!selectedeventcode.equals(""))
		{
			stmt.setString(++count1,selectedeventcode);
			
		}	

		if(!fromdate.equals(""))
		{
			stmt.setString(++count1,fromdate);	
			
		}	
		if(!todate.equals(""))
		{
			stmt.setString(++count1,todate);
			
		}	
		if(!facility_id.equals(""))
		{
			stmt.setString(++count1,facility_id);
			
		}	
		//IN035950 Start
		if("CA_CLINICIAN_WIDGET".equals(called_from_widget) && !"".equals(eventClasswidget))
		{
			stmt.setString(++count1,eventClasswidget);
		}
		//IN035950 Ends
		if(!encounter_id.equals(""))
		{
			stmt.setString(++count1,encounter_id);
			
		}	
		if(attend_pract_code.equals("")){ // MMS-QH-CRF-0177 [IN047572] - Start
			if(!speciality_code.equals("")){
				stmt.setString(++count1, speciality_code);
			}
		} else {
			stmt.setString(++count1, attend_pract_code);
		} // MMS-QH-CRF-0177 [IN047572] - End
		rs = stmt.executeQuery();

		String preveventdatetime = "";
		String prevhisttype = "";
		String preveventclass = "";
		String preveventgroupevent = "";
		String colspanval ="3";
		if(viewby.equals("D")) colspanval ="3";
		String classValue = "",quick_text_image_visible = "";
		String displayStyle = "gridDataChart";
		String histdatatype="";
		String event_group="";//IN040416
		String histrectype="";
		String restricting_print =""; //IN069242
		String accessionnum="";
		String eventdatetime="";
		String modified_date="";//24094
		String modified_date_YN="";//24094
		String eventdate_hd ="";
		String pre_eventdate_hd ="";
		String sortEventDateTime="";
		String eventdatetime_th = "";

		String histtypedesc="";
		String eventclassdesc="";
		String eventgroupdesc="";
		String eventdesc="";
		String resultstr="";
		String encline="";
		String range="";
		String extimageapplid="";
		String extimageobjid="";//EMG
		String contr_sys_id = "";
		String contr_sys_event_code  = "";
		String normalrange1="";
		String normalrange2="";
		String normalrange = " - ";
		String normalcy_ind="";
		String criticalrange1="";
		String criticalrange2="";
		String criticalrange = " - ";
		String strStatus="";
		String resultStatus = "";//29803
		String data = "";
		String pacsimg = "";
		String sqlHist ="";
		String curreventgroupevent="";
		String result_uom = "";
//		String deciresult="";//IN037900 //commented for IN064688
//		String decival ="";//IN037900 //commented for IN064688
		String dmsExternalLinkYN = ""; //IN047204
		String event_code_type = "";//IN047204
		StringBuffer toolTip = new StringBuffer();
		dmsExternalLinkYN = manageEmailBean.getExternalDmsLinkYN(ext_facility_id); //IN047204
		//Bru-HIMS-CRF-195.3 - IN047205 - Start
		String ext_image_appli_id = "";
		String ext_image_obj_id = "";
		String ext_image_source = "";
		String ext_srce_doc_ref_no = "";
		String ext_srce_doc_ref_line_no = "";
		String eventCode="",out_event_code="";//IN071127
		ArrayList externalList = null;
		PreparedStatement pstmtImgView1 = null; //7902
		ResultSet resImgView1 = null;//7902
		String study_id="",ext_img_disable="",param_def_str="",ext_img_display="";//7902
		//Bru-HIMS-CRF-195.3 - IN047205 - End
		String specimen_type="";//7632
		String lv_neonate_spec_yn="";//31792
		String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
		String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");

		int i = 0,txt_count=0;
		int quick_text_count = 0;
		boolean first = true; 
		//6484 Start.
		//sqlHist="select count(*) from CR_ENCOUNTER_DETAIL_TXT where hist_rec_type =? and contr_sys_id = ? and accession_num = ? and contr_sys_event_code=? and dbms_lob.getlength(hist_data)>0";
		sqlHist="select count(*) from CR_ENCOUNTER_DETAIL_TXT where hist_rec_type =? and contr_sys_id = ? and accession_num = ? and contr_sys_event_code=? and (dbms_lob.getlength(hist_data)>0 or nvl(dbms_lob.getlength(compress_hist_data),0)>0) ";
		//6484 End.
		stHist=con.prepareStatement(sqlHist);
		
		if(rs != null)
		{
			while(rs.next())
			{
				toolTip.setLength(0);
				txt_count = 0;
				quick_text_count = 0;
				data="";
				quick_text_count = rs.getInt("QUICK_TEXT_COUNT");
				if(quick_text_count == 1)
					quick_text_image_visible = "style='display'";
				else
					quick_text_image_visible = "style='display:none'";			

				histdatatype = rs.getString("HIST_DATA_TYPE") == null ? "" : rs.getString("HIST_DATA_TYPE");
				histrectype = rs.getString("HIST_REC_TYPE") == null ? "" : rs.getString("HIST_REC_TYPE");
				restricting_print = rs.getString("restricting_print") == null ? "" : rs.getString("restricting_print"); //IN069242
				accessionnum = rs.getString("ACCESSION_NUM") == null ? "" : rs.getString("ACCESSION_NUM");
				enctr_id = rs.getString("encounter_ID") == null ? "0" : rs.getString("encounter_ID");
				eventdatetime = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
				modified_date = rs.getString("modified_date") == null ? "" : rs.getString("modified_date");//24094
				modified_date_YN = rs.getString("modifiedyn") == null ? "" : rs.getString("modifiedyn");//24094
				sortEventDateTime = rs.getString("sort_event_date") == null ? "" : rs.getString("sort_event_date");
				eventdatetime_th	= com.ehis.util.DateUtils.convertDate(eventdatetime,"DMYHM","en",locale);
				eventdate_hd = eventdatetime_th.substring(0,eventdatetime_th.indexOf(" "));
				histtypedesc = rs.getString("hist_rec_type_desc")==null?"":rs.getString("hist_rec_type_desc");
				eventclassdesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
				eventgroupdesc = rs.getString("event_group_desc")==null?"":rs.getString("event_group_desc");
				eventdesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
				resultstr = rs.getString("RESULT_STR")==null?"":rs.getString("RESULT_STR");
				normalcy_str = rs.getString("NORMALCY_STR")==null?"":rs.getString("NORMALCY_STR");
				encline = rs.getString("encline") == null ? "" : rs.getString("encline");
				fac_id = rs.getString("FACILITY_ID") == null ? "" : rs.getString("FACILITY_ID");//IN033489
				encline = encline.replace('\'',' ');
				range = "";
				
				extimageapplid = rs.getString("EXT_IMAGE_APPL_ID")==null?"":rs.getString("EXT_IMAGE_APPL_ID");
				extimageobjid = rs.getString("EXT_IMAGE_OBJ_ID")==null?"":rs.getString("EXT_IMAGE_OBJ_ID");//EMG
				performed_by = rs.getString("clinician_short_name")==null?"":rs.getString("clinician_short_name");
				Specimen_num = rs.getString("Specimen_num") == null ? "" : rs.getString("Specimen_num");//IN066453
				categoryNum = rs.getString("CATEGORY_NUMBER") == null ? "" : rs.getString("CATEGORY_NUMBER");//IN066453
				resulted_practitioner = rs.getString("resulted_practitioner") == null ? "" : rs.getString("resulted_practitioner"); //Added for IN064132
				
				contr_sys_id = rs.getString("contr_sys_id") == null ? "" : rs.getString("contr_sys_id");
				contr_sys_event_code = rs.getString("contr_sys_event_code") == null ? "" : rs.getString("contr_sys_event_code");
				event_group = rs.getString("event_group") == null ? "" : rs.getString("event_group");//IN040416
				event_code_type  = rs.getString("EVENT_CODE_TYPE")==null?"":rs.getString("EVENT_CODE_TYPE"); // IN047204
				// added for Bru-HIMS-CRF-052.1 [IN037793] - Start
			
				ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");
				strStatus = rs.getString("STATUS") == null?"":rs.getString("STATUS"); //HSA-CRF-0257.1 - IN055910
				resultStatus = rs.getString("resultStatus") == null?"":rs.getString("resultStatus"); //29803
					//IN066453 -Start
				html_image_upld_id = rs.getString("HTML_IMAGE_UPLD_ID") == null ? "" : rs.getString("HTML_IMAGE_UPLD_ID"); //IN069028
				eventCode  = rs.getString("EVENT_CODE")==null?"":rs.getString("EVENT_CODE"); // IN071127
				specimen_type=rs.getString("specimen_type")==null?"":rs.getString("specimen_type");//7632
				lv_neonate_spec_yn=rs.getString("lv_neonate_spec_yn")==null?"":rs.getString("lv_neonate_spec_yn");//31792
				/*StringTokenizer st = new StringTokenizer(Specimen_num,"#");
			while(st.hasMoreTokens())
	    {
		   Specimen_num1 = java.net.URLEncoder.encode((String)st.nextToken());
		   Specimen_num2 = java.net.URLEncoder.encode((String)st.nextToken());
		if(st.hasMoreTokens())
		    Specimen_num2 = java.net.URLEncoder.encode((String)st.nextToken());
	
	     }*/
		//	IN066453 -end
		//IN071106, ends, commented
		//7902 STARTS
				if(!extimageapplid.equals("") && extimageapplid.equals("CPACS") )
				{
				
					ext_img_disable="disabled";
					
					pstmtImgView1 = con.prepareStatement("SELECT PARAM_DEF_STR  FROM CA_EXT_IMAGE_APPL_LANG_VW WHERE  EXT_IMAGE_APPL_ID=?"); 
					pstmtImgView1.setString(1,extimageapplid);
					resImgView1 = pstmtImgView1.executeQuery();
					
					while(resImgView1.next())
					{
						param_def_str = resImgView1.getString("PARAM_DEF_STR") == null ? "" : resImgView1.getString("PARAM_DEF_STR");
					}
					if(pstmtImgView1!=null) pstmtImgView1.close();
					if(resImgView1!=null) resImgView1.close();
					
					if(!param_def_str.equals("") && param_def_str.contains("~STUDY_ID`")){
						pstmtImgView = con.prepareStatement("SELECT A.study_id  FROM or_order_line a, cr_encounter_detail b WHERE B.EXT_IMAGE_APPL_ID =? AND to_char(a.ext_appl_accession_num) = b.ext_image_obj_id AND b.ext_image_obj_id=?"); 
						pstmtImgView.setString(1,extimageapplid);
						pstmtImgView.setString(2,extimageobjid);
						resImgView = pstmtImgView.executeQuery();
						
						while(resImgView.next())
						{
							study_id = resImgView.getString("STUDY_ID") == null ? "" : resImgView.getString("STUDY_ID");
						}
						
						if(pstmtImgView!=null) pstmtImgView.close();
						if(resImgView!=null) resImgView.close();
					}
					
				}
				if(study_id.equals("null"))
					study_id="";
				if(!study_id.equals("") && param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(!study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				} 
				else if(study_id.equals("") && param_def_str.contains("~STUDY_ID`")&& extimageapplid.equals("CPACS"))
				{
					ext_img_disable="disabled";
					ext_img_display="Study ID not available, we cannot Proceed";
				}
				else if(study_id.equals("") && !param_def_str.contains("~STUDY_ID`"))
				{
					ext_img_disable="";
					ext_img_display="";
				}	//7902 ENDS
				if(isClinician&&eventclassdesc.equals("Clinician Notes"))//IN069665
					eventclassdesc="Therapist Notes";//IN069665
				//HSA-CRF-0257.1 - IN055910- Start
				if("LBIN".equalsIgnoreCase(histrectype) && "C".equalsIgnoreCase(strStatus)) {
					data = data + "<img src='../../eCA/images/modifiedresult.png' name='mod_result' alt='Result Modified'/>&nbsp;";
				}
				//HSA-CRF-0257.1 - IN055910- End
				if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
				//contr_sys_event_code = event_group;//IN040416
					pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
					pstmtImgView.setString(1,ext_image_upld_id);
					resImgView = pstmtImgView.executeQuery();
					String recCountInt = "";
					while(resImgView.next())
					{
						ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
					}
					
					//IN040866 - Start
					String perfFacilityId = "";
					pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
					pstmtPerFacId.setString(1,extimageobjid);
					rsetPerFacId = pstmtPerFacId.executeQuery();
					if(rsetPerFacId.next()){
						perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
					}
					
					//IN040866 - End
					// IN052800 - Start
					if(perfFacilityId.equals("") || perfFacilityId == null){
						perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(extimageobjid);
					}
					//IN052800 - End
					//IN065970 starts
					//pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where OPERATING_FACILITY_ID = ? and SPECIMEN_NO = ? and TEST_CODE = ?");
					//pstmtImgCount.setString(1,fac_id); //commented for IN040866
					//pstmtImgCount.setString(1,perfFacilityId);// modified for IN040866
					// commented below code for IN071127 starts
					/*pstmtImgCount = con.prepareStatement("select count(*) from rl_specimen_image_dtls where SPECIMEN_NO = ? and TEST_CODE = ?");
					pstmtImgCount.setString(1,extimageobjid);
					//pstmtImgCount.setString(2,contr_sys_event_code); //IN040416//IN068560  [Uncommented this line and below line commented]
					pstmtImgCount.setString(2,eventCode); //IN071127
					//pstmtImgCount.setString(2,event_group); //IN040416//commented for IN068560
					//IN065970 ends
					rsetImgCount = pstmtImgCount.executeQuery();
					if(rsetImgCount.next()) 
					{
						recCount = rsetImgCount.getInt(1);
					}
					recCountInt = String.valueOf(recCount);  ends*/
					//IN071127 starts
					CallableStatement cs = con.prepareCall( "{ call rl_image_count(?,?,?,?,?,?)}" );
					cs.setString(1,contr_sys_event_code);
					cs.setString(2,accessionnum);
					cs.setString(3,eventCode);
					cs.setString(4,patientid);
					cs.registerOutParameter( 5,  Types.VARCHAR ) ;
					cs.registerOutParameter( 6,  Types.INTEGER ) ;
					cs.execute() ;
					out_event_code	= cs.getString( 5 ) ;
					 image_count	= cs.getInt( 6 ) ;
					 //IN071127 ends
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",loggedUser).replace("~language_id#",locale); //commented for IN040866
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",loggedUser).replace("~language_id#",locale); // modified for IN040866, IN040416
					//IN065970 reopen starts
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",perfFacilityId).replace("~user_id#",loggedUser).replace("~language_id#",locale); // modified for  IN040416
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",event_group).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",loggedUser).replace("~language_id#",locale); // IN065970 reopen ends//commented for IN068560
					//ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",contr_sys_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",loggedUser).replace("~language_id#",locale); //IN068560//IN071127
					ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extimageobjid).replace("~test#",out_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",loggedUser).replace("~language_id#",locale); //IN071127
					if(resImgView  != null) resImgView.close();
					if(pstmtImgView != null) pstmtImgView.close();

					if(rsetImgCount  != null)  rsetImgCount.close();
					if(pstmtImgCount  != null) pstmtImgCount.close();

					if(rsetPerFacId  != null) rsetPerFacId.close();
					if(pstmtPerFacId  != null) pstmtPerFacId.close();
 				 
				}	
				// End	
				//IN064688 Changes Starts
				/*normalrange1 = rs.getString("NORMAL_LOW");
				if (normalrange1 == null) normalrange1 = "";

				normalrange2 = rs.getString("NORMAL_HIGH");
				if (normalrange2 == null) normalrange2 = "";*/
				BigDecimal nl =rs.getBigDecimal("NORMAL_LOW");
				if(nl!=null)
					normalrange1=nl.toString();
				else
					normalrange1="";
				BigDecimal nh =rs.getBigDecimal("NORMAL_HIGH");
				if(nh!=null)
					normalrange2=nh.toString();
				else
					normalrange2="";
				//IN064688 Changes Ends
				
				color_cell_indicator = rs.getString("COLOR_CELL_IND");
				if(color_cell_indicator == null) color_cell_indicator= "";
				if(include_normalcy_indicator.equals("I"))
					color_cell_indicator = rs.getString("SYMBOL_LEGEND_IND") == null ? "" : rs.getString("SYMBOL_LEGEND_IND");
				descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
			
				normalcy_ind = rs.getString("normalcy_ind");
				if(normalcy_ind == null) normalcy_ind="";
				
				criticalrange1 = rs.getString("CRITICAL_LOW");
				if (criticalrange1 == null) criticalrange1 = "";

				criticalrange2 = rs.getString("CRITICAL_HIGH");
				if (criticalrange2 == null) criticalrange2 = "";
				
				//strStatus = rs.getString("STATUS"); //HSA-CRF-0257.1 - IN055910
				if(strStatus == null) 
					strStatus = "";
				//deciresult =rs.getString("RESULT_NUM1") == null ? "0" : rs.getString("RESULT_NUM1");//IN037900  //Commented for IN064688
				//decival = rs.getString("RESULT_NUM_DEC") == null ? "0" : rs.getString("RESULT_NUM_DEC");//IN037900 //Commented for IN064688
				
				delta_fail_id_ind = rs.getString("DELTA_FAIL_IND");
				if(delta_fail_id_ind==null) delta_fail_id_ind="";
				if(keyList.contains(enctr_id+"`"+histrectype+"`"+contr_sys_id+"`"+accessionnum+"`"+contr_sys_event_code))
					displayStyle = "gridDataSelect";
				else
					displayStyle = "gridDataChart";

				stHist.setString(1,rs.getString("HIST_REC_TYPE"));
				stHist.setString(2,rs.getString("CONTR_SYS_ID"));
				stHist.setString(3,rs.getString("ACCESSION_NUM"));
				stHist.setString(4,rs.getString("contr_sys_event_code"));
				rsHist=stHist.executeQuery();
				
				if(histdatatype.equals("NUM"))
				{
					//IN064688 Changes starts
					//resultNum = rs.getString("RESULT_NUM") == null ? "0" : rs.getString("RESULT_NUM");
					BigDecimal rm =rs.getBigDecimal("RESULT_NUM");
					if(rm!=null)
					resultNum=rm.toString();
					else
					resultNum="";
					//IN064688 Changes Ends
					if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
						data = data + rs.getString("RESULT_NUM_PREFIX");
					/*
					//IN037900 Start
					if(decival.length()>0 && deciresult.length()> 9)	
						data = data + (rs.getString("RESULT_NUM1") == null? "" :rs.getString("RESULT_NUM1"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					else
						data = data + (rs.getString("RESULT_NUM") == null? "" :rs.getString("RESULT_NUM"))+"  "+( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					//IN037900 end	*/ //commented for //IN064688
					data = data + resultNum+"  "+ ( rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM"));
					result_uom = rs.getString("RESULT_NUM_UOM")==null?"":rs.getString("RESULT_NUM_UOM");
		                             
					if(!resultstr.equals("") && resultstr !=null)
					{
						resultstr=replaceSpecialChar(resultstr);
						data=data +"<a class='gridLink' href=javaScript:ShowComments('"+java.net.URLEncoder.encode(resultstr)+"')>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Comments.label","common_labels")+" </a>";
					}
								
					if (rsHist.next()) 
					{ 
						if(rsHist.getInt(1) >0) {
						//data=data +"<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>";//IN031989
						data=data +"<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>";//IN031989
						txt_count = 1;
						}
					}

					//Added by Jyothi.G on 09/12/2010 to fix IN025310
					if(!normalrange1.equals("") && !normalrange2.equals(""))
						normalrange = Normal_Range + " : " + normalrange1 + " - " + normalrange2 + " " + result_uom;
					else if(!normalrange1.equals("") && normalrange2.equals(""))
						normalrange = Normal_Range + " : (>=" + normalrange1 + " " + result_uom + ")";
					else if(normalrange1.equals("") && !normalrange2.equals(""))
						normalrange = Normal_Range + " : (<=" + normalrange2 + " " + result_uom + ")";
					else
						normalrange = "";
					
					if(!criticalrange1.equals("") && !criticalrange2.equals(""))
					{
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
					}
					else if(!criticalrange1.equals("") && criticalrange2.equals(""))
					{
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalrange1 + " " + result_uom+")" ;
					}
					else if(criticalrange1.equals("") && !criticalrange2.equals(""))
					{
						criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalrange2 + " " + result_uom+")" ;
					}
					else
						criticalrange = "";
									
					if(!normalrange.equals("") && !criticalrange.equals(""))
						toolTip.append(normalrange+"<br> "+criticalrange);
					else if(!normalrange.equals(""))
						toolTip.append(normalrange);
					else if(!criticalrange.equals(""))
						toolTip.append(criticalrange);
					else
						toolTip.append("");//END
					//IN064132 changes starts
					/*
					if(!performed_by.equals(""))
					{
						if(!(toolTip.toString()).equals(""))
							toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + performed_by );
					}
					*/
					if(isPracSiteSpecific && "LBIN".equals(histrectype))
					{
						if(!resulted_practitioner.equals(""))
						{
							if(!(toolTip.toString()).equals(""))
							{
								//if(isVerifiedSiteSpec)//IN069290 added Verified By 7632
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + resulted_practitioner );
								/* 7632 starts else
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + resulted_practitioner );
								7632 ends*/
							}
						}
					}
					else
					{
						if(!performed_by.equals(""))
						{
							if(!(toolTip.toString()).equals(""))
							{
								//if(isVerifiedSiteSpec)//IN069290 added Verified By 7632
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.VerifiedBy.label","common_labels")+" : " + performed_by );
								/* 7632 else
									toolTip.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" " + com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + performed_by );
								*/
							}
						}
					}
					//IN064132 changes ends
					// IN066453 -Start
					
					range = toolTip.toString();
				}
				else if(histdatatype.equals("STR"))
				{
					data = data + resultstr+"";

					if(!normalcy_str.equals(""))
					{
						data = data + " <font color=blue>( Normal Value : " + normalcy_str + " )</font>";
					}
					
					while(rsHist.next()) 
					{ 
						if(rsHist.getInt(1) > 0) {
						//data=data +"<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>";//IN031989
						data=data +"<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\"><img id='textimg' src='../../eCA/images/flow_text.gif' ></a></font>";//IN031989
						txt_count = 1;
						
						}
					}
				}
				else if(histdatatype.equals("HTM")||histdatatype.equals("TXT"))
				{
					while(rsHist.next()) 
					{ 
						
						if(rsHist.getInt(1) > 0) {
							//data = "<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989
							//data = "<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989 - commented for HSA-CRF-0257.1 - IN055910
							data = data + "<a class='gridLink' href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>"; // HSA-CRF-0257.1 - IN055910
						  //24094 starts
							 if(modified_date_YN.equals("Y")){
							data = data + "&nbsp;<img src='../../eCA/images/modifiedresult.png'/>";
							
						  }else{
							  data = data + "";
						  }
							//24094 ends
						}
					}
				}
				else if(histdatatype.equals("DOC"))
				{
					
					while(rsHist.next()) 
					{ 
						if(rsHist.getInt(1) > 0) {
							//data = data + "<a class='gridLink'  href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989
							data = data + "<a class='gridLink'  href=\"javascript:getText('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\"><img border=no src='../../eCA/images/flow_text.gif'></img></a>";//IN031989
						}
					}
				}
				else if(histdatatype.equals("IMG")) 
				{
					//data +="<a href=javascript:showDocDetails(\""+histdatatype+"\",\""+histrectype+"\",\""+accessionnum+"\",\""+java.net.URLEncoder.encode(eventdesc)+"\",\""+extimageapplid+"\")><img border=no src='../../eCA/images/flow_image.gif'></img></a>";
				}
				
				/*if(!extimageapplid.equals(""))
				{
					data = data +"&nbsp;"+"<img src='../../eCA/images/"+extimageapplid+".gif' onClick=\" getFile('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+extimageapplid+"')\">";
				}*/
				if("LBIN".equals(histrectype) && contr_sys_id.equals("LB"))
				{
					Specimen_num2 = extractSpecimenNumber(accessionnum,"#","@");//IN071106	
						//range = range +"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>";
						range = range +"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenType.label","or_labels")+" : " + specimen_type+"<BR>";//7632
				}// IN066453 -end
				//IN066453 start
				if(!encline.equals("") && isVerifiedSiteSpec){
					encline = encline.replaceAll("Performed By :","Verified By :");
				}
				//IN066453 ends
				if(!extimageapplid.equals(""))
				{
					if(!("DMS").equals(extimageapplid)) { // IN049533
						if(!("DOCUL").equals(extimageapplid) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")))  // modified for IN037793 IN040416 
						 //if(!("DOCUL").equals(extimageapplid)) //Condition added for EMG
						{	
							//IN050936 included patient_id
							 data = data +"&nbsp;"+"<img src='../../eCA/images/"+extimageapplid+".gif' "+ext_img_disable+" onClick=\"return getFile('"+histrectype+"','"+contr_sys_id+"','"+extimageobjid+"','"+contr_sys_event_code+"','"+extimageapplid+"','"+patientid+"')\"  alt='"+ext_img_display+"' >";	
						}
						else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))
						{
							//IN050936 included patient_id
							data = data +"&nbsp;"+"<img src='../../eCA/images/"+extimageapplid+".gif'  "+ext_img_disable+" onClick=\"return getFile('"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+extimageapplid+"','"+patientid+"')\"  alt='"+ext_img_display+"' >";
						}
						//else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && recCount > 0) { //IN071127
						else if((!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) && image_count > 0) {//IN071127
							data = data + "&nbsp;"+"<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
						}
					}	// IN049533
				}
				// added for IN047204 - Start
				//IN069028 Start.
				if(!html_image_upld_id.equals(""))
				{
					data = data + "&nbsp;"+ "<img src='../../eCA/images/IniAss.png' onClick=\"return getFile_SH('"+java.net.URLEncoder.encode(accessionnum)+"')\">";
				}
				//IN069028 End.
				if("Y".equals(dmsExternalLinkYN)){// && "RD".equals(event_code_type)) { // commented for  Bru-HIMS-CRF-195.3 - IN047205 
					extLinkHashMap = manageEmailBean.getExternalLinkParameters(fac_id, patientid, encounter_id, locale); 
					admit_date	= (String) extLinkHashMap.get("P_ENCNTR_DATE");
					locn_code	= (String) extLinkHashMap.get("P_LOCN_CODE");
					locn_type	= (String) extLinkHashMap.get("P_LOCN_TYPE");
					visit_id	= (String) extLinkHashMap.get("P_VISIT_ID");
					loc_desc	= (String) extLinkHashMap.get("P_LOC_DESC");
					physician_id	= (String) extLinkHashMap.get("P_PHYSICIAN_ID");
					encntr_type	= (String) extLinkHashMap.get("P_EPISODE_TYPE");
					
					//Bru-HIMS-CRF-195.3 - IN047205 - Start
					externalList = oEncounterList.getExternalLinkdata(histrectype, contr_sys_id, accessionnum, contr_sys_event_code); 
					Iterator iter = externalList.iterator();
					while(iter.hasNext()){
						externalDataDTO = (eCA.CAExternalLinkDataDTO)iter.next();
						ext_image_appli_id = externalDataDTO.getExt_image_appl_id();
						ext_image_obj_id = externalDataDTO.getExt_image_obj_id();
						ext_image_source = externalDataDTO.getExt_image_source();
						ext_srce_doc_ref_no = externalDataDTO.getSrce_doc_ref_no();
						ext_srce_doc_ref_line_no = externalDataDTO.getSrce_doc_ref_line_no();
							
						if("RD".equals(event_code_type)) { 		//Bru-HIMS-CRF-195.3 - IN047205 - End
							//Fix for IN047566/Start
							//access_no_rd 	= accessionnum.substring(accessionnum.indexOf("#")+1, accessionnum.indexOf("$"));
							if (extimageobjid.equals(null) || extimageobjid.equals(""))
								access_no_rd 	= accessionnum.substring(accessionnum.indexOf("#")+1, accessionnum.indexOf("$"));
							else
								access_no_rd 	= extimageobjid;
							//Fix for IN047566/End
							
							pstmtOrderId = con.prepareStatement("select  order_id, order_type_code from or_order_line where accession_num = ?"); 
							pstmtOrderId.setString(1,access_no_rd);
							rsetOrderId = pstmtOrderId.executeQuery();
							if(rsetOrderId.next()){
								order_id = rsetOrderId.getString("order_id") == null ? "":  rsetOrderId.getString("order_id");
								order_typ_code	= rsetOrderId.getString("order_type_code") == null ? "":  rsetOrderId.getString("order_type_code");	
							}
							if(rsetOrderId  != null) rsetOrderId.close();
							if(pstmtOrderId  != null) pstmtOrderId.close();
							//data = data + "&nbsp;"+ "<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patientid+"','"+encounter_id+"','"+accessionnum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+loggedUser+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"')\">";//IN47847 Added title to img tag -- //Bru-HIMS-CRF-195.3 - IN047205 - commented
							data = data + "&nbsp;"+ "<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patientid+"','"+encounter_id+"','"+accessionnum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+loggedUser+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">"; //Bru-HIMS-CRF-195.3 - IN047205 - Modified
						}	//Bru-HIMS-CRF-195.3 - IN047205 - Start
						else {
							data = data + "&nbsp;"+ "<img src='../../eCommon/images/ExternalDocument.PNG' title='External Link' onClick=\"return getExtLink('"+patientid+"','"+encounter_id+"','"+accessionnum+"','"+order_id+"','"+fac_id+"','"+locale+"','"+loggedUser+"','"+resp_id+"','"+login_at_ws_no+"','"+order_typ_code+"','"+visit_id+"','"+physician_id+"','"+locn_type+"','"+locn_code+"','"+admit_date+"','"+encntr_type+"','"+loc_desc+"','"+ext_image_appli_id+"','"+ext_image_obj_id+"','"+ext_image_source+"','"+ext_srce_doc_ref_no+"','"+ext_srce_doc_ref_line_no+"')\">";
						}
					}	//Bru-HIMS-CRF-195.3 - IN047205 - End
				}
				// added for IN047204 - End
				//IN070610, starts
				String l_upload_view = "N";
				Integer l_rec_cnt = 0;
				
				if(uploadFuncTrOrders)
					l_rec_cnt = Integer.parseInt(rs.getString("uploaded_doc_cnt"));
								
				if(l_rec_cnt > 0 && "TRET".equals(histrectype) && uploadFuncTrOrders)
				{
					l_upload_view = "Y";
				}							
				
				if("Y".equals(l_upload_view))								
					data = data + "<a style='cursor:pointer;color:blue' onClick=\"uploadedDocuments('"+accessionnum+"','"+contr_sys_event_code+"')\"><img src='../../eOR/images/DOCUL.gif' width='16' height='16' border=0 alt='Uploaded Documents'/></a>";
				//IN070610, ends
					
				if(strStatus.equals("P") || resultStatus.equals("4"))
					data = data +" <font color='red'>(Preliminary)</font>";
				
				if(include_normalcy_indicator.equals("I") && !include_normalcy_indicator.equals(""))
				{
					if(!color_cell_indicator.equals("NONE"))
						data = "<font  style='background-image:url(\"../../eCA/images/"+color_cell_indicator+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					else if(normalcy_ind.equals("."))
					{
						data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					}
					else if(!normalrange1.equals("") && !normalrange2.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
							{
								data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) 
							{
								data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(normalrange1.equals("") && !normalrange2.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
							{
								data = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}//END
				}
				else if(include_normalcy_indicator.equals("C") && !include_normalcy_indicator.equals(""))
				{
					if(!color_cell_indicator.equals("NONE"))
						data = "<font style='background-color:"+color_cell_indicator+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					else if(normalcy_ind.equals("."))
					{
						data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
					}
					else if(!normalrange1.equals("") && !normalrange2.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if((Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2)))
							{
								data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(!normalrange1.equals("") && normalrange2.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) >= Float.parseFloat(normalrange1))
							{
								data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}
					else if(normalrange1.equals("") && !normalrange2.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalrange2))
							{
								data = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;<font size=1>"+data+"</font>";
							}
						}
					}//END
				}
				else
					data = "<font size=1>"+data+"</font>";

				if(!prevhisttype.equals(histtypedesc))
				{
					histcount++;

					if(!prevhisttype.equals(""))
						outdata = outdata + "</table></td></tr>";
					outdata =outdata + "<tr onMouseOver='javascript:showPopUp()' onMouseOut='hidePopUp()'><td colspan='"+colspanval+"' class=CAHIGHERLEVELCOLOR><input type=button name='collapse' id='collapse' value=' - ' onclick=\"collapseExpand(this,'"+histcount+"');\"> "+histtypedesc+"</td></tr>";
					printdata = printdata + "<tr><td colspan='"+colspanval+"' class=CAHIGHERLEVELCOLOR>"+histtypedesc+"</td></tr>";
					outdata = outdata + "<tr><td><table width='100%' id='tableId"+histcount+"'>";
					pre_eventdate_hd = "";
				}
				
				if(viewby.equals("D"))
				{
					if(!pre_eventdate_hd.equals(eventdate_hd))
					{
						outdata = outdata +"<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CATHIRDLEVELCOLOR><font size=1 color = black ><b>"+eventdate_hd+"</b></font></td></tr>";
						printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1><b>"+eventdate_hd+"</b></font></td></tr>";
					}
				}
				
				if(!preveventclass.equals(eventclassdesc))
				{
					outdata = outdata +"<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font>";
					
					printdata = printdata +"<tr><td colspan='"+colspanval+"' class=CAGROUP><font size=1>"+eventclassdesc+"</font></td></tr>";
				}

				if (!eventgroupdesc.equals(""))
					 curreventgroupevent = "("+eventgroupdesc+")-"+eventdesc;
				else
					 curreventgroupevent = eventdesc;
				
				if(viewby.equals("E"))
				{
					if(!curreventgroupevent.equals(preveventgroupevent))
					{
						if (!eventgroupdesc.equals("")){
							outdata = outdata +"<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1> ("+eventgroupdesc+")- "+eventdesc+"</font></td></tr>";
							printdata = printdata + "<tr><td colspan='"+colspanval+"' class=gridDataChart><font size=1>("+eventgroupdesc+")- "+eventdesc+"</font></td></tr>";
						}else{
							outdata = outdata + "<tr onMouseOver='javascript:hidePopUp()'><td colspan='"+colspanval+"' class=CAFOURTHLEVELCOLOR><font size=1> "+eventdesc+"</font></td></tr>";
							printdata = printdata + "<tr><td colspan='"+colspanval+"' class=gridDataChart><font size=1>"+eventdesc+"</font></td></tr>";
						}
					}
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";
					
					
					if(strStatus.equals("E"))
					{//to make the row in a differnt colour
						outdata = outdata +"<tr><td class='TD_BROWN'  width='50%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='hidePopUp()'><font size=1>"+eventdatetime_th+"</font></td><td class='TD_BROWN' onMouseOver='javascript:hidePopUp()' id='"+i+"'><font size=1>"+data+"</font>"+pacsimg+"</td></tr>";
						
						if((include_normalcy_indicator.equals("C") || include_normalcy_indicator.equals("B")) && !normalcy_ind.equals("") && !color_cell_indicator.equals("NONE"))
						{
							printdata =printdata + "<tr><td class='gridDataChart' ><font size=1>"+eventdatetime_th+"</font></td><td  class='"+displayStyle+"' id='"+i+"'>"+data+"</td></tr>";
						}
						else
						{
							printdata = printdata +"<tr><td class='gridDataChart'><font size=1>"+eventdatetime_th+"</font></td><td class='"+displayStyle+"' id='"+i+"'>"+data+"</td></tr>";
						}
					}
					else
					{
						outdata = outdata + "<tr><td class='gridDataChart' width='50%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='javascript:hidePopUp()'><font size=1>"+eventdatetime_th+"</font></td>";
						//IN069242 Start.
						if("Y".equals(restricting_print)){
						outdata = outdata +"<td class='"+displayStyle+"' onMouseOver=\"javascript:displayTooltip(this,'"+range+"')\" onMouseOut='javascript:hideTooltip(this)'  style='cursor:pointer' id='"+i+"'>"+data+"&nbsp;<input type='image' "+quick_text_image_visible+" name='image"+i+"' id='image"+i+"'  src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"+eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','S')\" ></td></tr>";
						}else{
						//IN069242 End.
						outdata = outdata +"<td class='"+displayStyle+"' onMouseOver=\"javascript:displayTooltip(this,'"+range+"')\" onMouseOut='javascript:hideTooltip(this)' onClick=\"changeColor('"+enctr_id+"','"+sortEventDateTime+"','"+classValue+"',this,'"+ eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+i+"')\" style='cursor:pointer' id='"+i+"'>"+data+"&nbsp;<input type='image' "+quick_text_image_visible+" name='image"+i+"' id='image"+i+"'  src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"+eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','S')\">";
							//31792 starts	
						if(isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){
						outdata = outdata +"<img style='cursor:pointer;'  src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails('"+order_id+"','"+accessionnum+"','"+histrectype+"','"+patientid+"')\"></td></tr>";
								}
							//31792 ends
						}//IN069242
						printdata = printdata +"<tr><td class='gridDataChart' width='50%'><font size=1>"+eventdatetime_th+"</font></td>";
						printdata = printdata +"<td class='"+displayStyle+"'>"+data+"</td></tr>";
					}
					i++;
				}
				else 
				{
					if(i%2==0) classValue = "QRYEVEN";
					else classValue = "QRYODD";

					outdata = outdata + "<tr><td  class='gridDataChart' width='10%' onMouseOver=\"javascript:showPopUp(this,'"+encline+"','')\" onMouseOut='hidePopUp()'><font size=1>"+eventdatetime.substring(eventdatetime.indexOf(" "))+"</font></td>";
					
					//IN069242 Start.
					if("Y".equals(restricting_print)){
					outdata = outdata + "<td  width='50%' class='gridDataChart'><font size=1>"+curreventgroupevent+"</font></td><td class='"+displayStyle+"' onMouseOver=\"javascript:displayTooltip(this,'"+range+"')\" onMouseOut='javascript:hideTooltip(this)'  style='cursor:pointer' ><font size=1>"+data+"</font>"+pacsimg+"<input type='image' "+quick_text_image_visible+" style='display:none' name='image"+i+"' id='image"+i+"'  src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"+eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','S')\" ></td></tr>";
					}else{
					//IN069242 End.
					outdata = outdata + "<td  width='50%' class='gridDataChart'><font size=1>"+curreventgroupevent+"</font></td><td class='"+displayStyle+"' onMouseOver=\"javascript:displayTooltip(this,'"+range+"')\" onMouseOut='javascript:hideTooltip(this)' onClick=\"changeColor('"+enctr_id+"','"+sortEventDateTime+"','"+classValue+"',this,'"+ eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','"+i+"')\" style='cursor:pointer' ><font size=1>"+data+"</font>"+pacsimg+"<input type='image' "+quick_text_image_visible+" style='display:none' name='image"+i+"' id='image"+i+"'  src='../../eCA/images/II_comment.gif' onClick=\"return enterQuickText('"+eventdatetime+"','"+histrectype+"','"+contr_sys_id+"','"+accessionnum+"','"+contr_sys_event_code+"','S')\" >";
					//31792 starts
					if(isSiteSpecificNeonatalMotherSpecimen && lv_neonate_spec_yn.equals("Y")){
						outdata = outdata +"<img style='cursor:pointer;'  src='../../eCA/images/MotherBlood.png' onClick=\"NeonatalMotherSpecimenDetails('"+order_id+"','"+accessionnum+"','"+histrectype+"','"+patientid+"')\"></td></tr>";
								}
					//31792 ends
					}//IN069242
					printdata = printdata + "<tr><td class='gridDataChart'><font size=1>"+eventdatetime.substring(eventdatetime.indexOf(" "))+"</font></td><td class='gridDataChart'><font size=1>"+curreventgroupevent+"</font></td>";
						
					printdata = printdata +"<td class='"+displayStyle+"' id='"+i+"'><font size=1>"+data+"I am here 1</font>"+pacsimg+"<input type='image' style='display:none' name='image"+i+"' id='image"+i+"'   src='../../eCA/images/II_comment.gif' ></td></tr>";
					
					i++;
				}
				preveventdatetime = eventdatetime;
				prevhisttype = histtypedesc;
				preveventclass = eventclassdesc;
				preveventgroupevent = curreventgroupevent;
				pre_eventdate_hd = eventdate_hd;

				if(first)
				{
					if(viewby.equals("D"))
					{
						if(!selectedhisrectype.equals(""))
							titleofdocument = histtypedesc;
					}
					else
					{
						titleofdocument = histtypedesc;
					}
				}
				first = false;
			}
			outdata = outdata + "</table></td></tr>";
			outdata = outdata +"</table>";
			out.println(outdata);
		}

		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(stmt2!=null) stmt2.close();
		if(stHist!=null) stHist.close();
		if(rsHist!=null) rsHist.close();
	}
	catch(Exception e)
	{
		//out.println("Errroor  :"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

	putObjectInBean("encounterBean"+key_ref,encounterBean,session);
%>
	<input type="hidden" name="pline" id="pline" value="<%=pline%>">
	<input type='hidden' name='hospital_name' id='hospital_name' value="<%=hospitalname%>">
	<input type='hidden' name='title_of_document' id='title_of_document' value="<%=titleofdocument%>">
	<input type='hidden' name='selected_note_type' id='selected_note_type' value='<%=selectedhisrectype%>'>
	<input type="hidden" name="loggedUser" id="loggedUser" value="<%=loggedUser%>">
	<input type='hidden' name='patient_line' id='patient_line' value='<%=request.getParameter("patient_line")%>'>
	<input type='hidden' name='txtFlagComments' id='txtFlagComments' value="N">
	<input type='hidden' name='txtFlagQuickText' id='txtFlagQuickText' value="N">
	<input type='hidden' name='patient_id' id='patient_id' value="<%=patientid%>">
	<input type='hidden' name='encounter_id' id='encounter_id' value="<%=encounter_id%>">
	<input type='hidden' name='enc_id' id='enc_id' value="<%=enc_id%>">
	<input type='hidden' name='eventSize' id='eventSize' value="<%=keyList.size()%>">
	<input type='hidden' name='EHR_YN' id='EHR_YN' value="<%=EHR_YN%>">
	<input type='hidden' name='fac_id' id='fac_id' value="<%=fac_id%>"><!--IN033489-->
	<input type="hidden" name="enctr_id" id="enctr_id" value='<%=enctr_id%>'><!--IN033489-->

</form>
<div id='encDetailsLayer' style='position:absolute; width:60%; visibility:hidden;'>
</div>
<div name='tooltiplayer' id='tooltiplayer'  style='position:absolute; width:30%; visibility:hidden;' bgcolor='yellow'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
			<td width='100%' class='gridTooltipData' id='t' nowrap></td>
			</td>
		</tr>
	</table>
</div>

<div id='data' style='display:none;' border='0' width='0'>
	<%=printdata%>
</div>

</body>
</html>
<%!
	String replaceSpecialChar(String resultStr)
	{
		if(resultStr.indexOf("\n")!=-1)
			resultStr = resultStr.replaceAll("\n","<BR>");		//IN068560 changed ~ to <BR>		
		if(resultStr.indexOf("\r")!=-1)
			resultStr = resultStr.replaceAll("\r","");
		if(resultStr.indexOf("'")!=-1)
			resultStr = resultStr.replaceAll("'","`");
		return resultStr;
	}
%>

