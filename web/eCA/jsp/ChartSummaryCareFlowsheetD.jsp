<!DOCTYPE html>
<!-- 
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
27/01/2012	  INO30714		Menaka V	 THAI screen>View Clinical Event History>View>In the Recorded Clinical
										 Note the name is not displayed in THAI 
20/06/2012	  IN033489		Menaka V	 Report header blank in clinical event history.		
03/06/2013	  EMG   		Chowminya G	 PACS LIVE issue								 
02/01/2014	  IN042552		Ramesh G	Bru-HIMS-CRF-391 --- Notes Confidentiality			
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
08/09/2014  	IN050936		Chowminya								None of the order retrieving any image from RIS/PACS but already having order image in PACS							 
17/10/2014	IN050649		Karthi L								Record chart same time, system separate data of chart in view chart summary.
28/06/2018	IN065341		Prakash C		29/06/2018		Ramesh G 		MMS-DM-CRF-0115
12/11/2018	IN068797		Prakash C 		15/12/2018		Ramesh G		MMS-DM-SCF-0568
03/04/2019	IN069978   		Prakash C		03/04/2019		Ramesh G		MMS-ICN-00116
20/04/2021	6484		Ramesh Goli		20/04/2021		RAMESH G		MO-CRF-20147.7
--------------------------------------------------------------------------------------------------------------------
--> 
<%@page import="java.sql.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//[IN035950] Starts
	/*String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";*/
	//String title= request.getParameter("title")==null?"":request.getParameter("title");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<%
String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
//String content_ID = request.getParameter("content_ID");checkstyle
String title= request.getParameter("title")==null?"":request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/

%>
<!--<title><fmt:message key="eCA.ChartSummaryCareFlowsheet.label" bundle="${ca_labels}"/></title>IN035950-->
<title><%=title%></title>
<!--<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />IN035950-->
<link rel='StyleSheet' href='../../eCommon/html/<%=sessionStyle%>' type='text/css' />
<!--[IN035950] Ends-->

<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCA/js/ResearchPatient.js" language="javascript"></script>
<script src='../../eCA/js/CAOpenExternalApplication.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
//function flowsheetSummary(patient_id,title,reln_id)
//function flowsheetSummary(patient_id,title,reln_id,enc_id)//INO30714
async function flowsheetSummary(patient_id,title,reln_id,enc_id,RepDb,clob_data)//INO65341
{
	var dialogHeight	= "60vh" ;
	var dialogWidth	= "60vw" ;
	var status = "no";
	var scroll = "yes";
	var dialogTop = "140";
	var features	= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; dialogTop:"+ dialogTop + "; status:"+ status + "; scroll:"+ scroll;
	
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummaryCareFlowsheetDtlsMain.jsp?patient_id='+patient_id+'&modal_yn=Y'+'&title='+encodeURIComponent(title)+'&relationship_id='+reln_id,arguments,features);//INO30714
	//retVal 			= window.showModalDialog('../../eCA/jsp/ChartSummaryCareFlowsheetDtlsMain.jsp?patient_id='+patient_id+'&modal_yn=Y'+'&title='+encodeURIComponent(title)+'&relationship_id='+reln_id+'&encounter_id='+enc_id,arguments,features);//INO30714
	await top.window.showModalDialog('../../eCA/jsp/ChartSummaryCareFlowsheetDtlsMain.jsp?patient_id='+patient_id+'&modal_yn=Y'+'&title='+encodeURIComponent(title)+'&relationship_id='+reln_id+'&encounter_id='+enc_id+'&RepDb='+RepDb+'&clob_data='+clob_data,arguments,features);//IN065341
}
</script>
<head>
	<title><fmt:message key="eCA.CH_SUM_CFLOW.label" bundle="${ca_labels}"/></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<center>
	<form name='CAViewPatientAllergyForm' id='CAViewPatientAllergyForm' method='post'>
	<table class='grid' width='100%'>
<%
	String patient_id = "",viewconf_appl="X";
	//IN065341 starts
	String bean_id = "ca_CentralizedBean" ;
		String bean_name = "eCA.CentralizedBean";
		CentralizedBean bean = (CentralizedBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
		bean.clear() ;
		bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String enc_id="";
	if(called_from.equals("CDR")){
		enc_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
	}else{//IN065341 ends
	   enc_id = request.getParameter("encounter_id");//INO30714
	}//IN065341
	StringBuffer query_current_medications =new StringBuffer();
	String event_date = "",  care_flow_detail = "";
	String ext_image_appl_id = "", ext_image_obj_id = "";
	String contr_sys_id = "",accession_num = "", contr_sys_event_code = "";
	String preveventclass="";
	String eventclass="";
	String preveventdate="";
	String event_desc="";
	String event_group_desc="",prevevent_group_desc="";
	String textExist="";
	String resp_id = (String)session.getValue("responsibility_id");
	String clinician_id			= (String)session.getValue("ca_practitioner_id") == null ? "" : (String) session.getValue("ca_practitioner_id");//IN042552
	String reln_id		=	request.getParameter("relationship_id")==null?"":request.getParameter("relationship_id");
	String modal_yn=request.getParameter("modal_yn");
	String enctr_id = "";//IN031989
	String fac_id="";//IN033489
	Properties p = (Properties)session.getValue("jdbc");
	String locale	= (String) p.getProperty("LOCALE");
	String color_cell_indicator = "";
	String descCellInd = "";
	String styleValue = "";
	String legend_type = "";
	String normalLow = "", normalHigh = "";
	String resultNum = "";
	String normalcyInd = "";
	String hist_data_type = "";
	String normalcy_str = "";

	if (modal_yn==null) modal_yn="N";
	int i=0;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet	rs = null;

	try
	{
		patient_id = request.getParameter("patient_id");
		if(patient_id==null) patient_id = "";
		con = ConnectionManager.getConnection();
	//IN065341 starts	
		if(called_from.equals("CDR")){
			bean.executeCDR(con,patient_id,enc_id,RepDb,"CR_ENCOUNTER_DETAIL_TXT");
		}
	//IN065341 ends		
		try
		{
		//IN065341 starts			
			//pstmt= con.prepareStatement(" select GET_TASK_APPLICABILITY(?,NULL,?,?) from dual ");
			String sql="select GET_TASK_APPLICABILITY ##REPDB##(?,NULL,?,?) from dual##REPDB##";
			sql=sql.replaceAll("##REPDB##",RepDb);
			pstmt= con.prepareStatement(sql);
		//IN065341 ends	
			pstmt.setString(1,"VIEW_CONF_RESULT");
			pstmt.setString(2,resp_id);
			pstmt.setString(3,reln_id);
			rs=pstmt.executeQuery();
			if (rs.next())
			{
				viewconf_appl=rs.getString(1);
			}
			if (viewconf_appl==null) viewconf_appl="X";
		}
		catch (Exception e2)
		{
			//out.println("Exception@2 : "+e2.getMessage());//COMMON-ICN-0181				
			//out.println();//COMMON-ICN-0181
			e2.printStackTrace();//COMMON-ICN-0181
		}
		if (rs!=null) rs.close();
		if (pstmt!=null) pstmt.close();
	//IN065341 starts
		//pstmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM ");
		String sql1="select LEGEND_TYPE from CR_CLIN_EVENT_PARAM##REPDB## ";
		sql1=sql1.replaceAll("##REPDB##",RepDb);
		pstmt= con.prepareStatement(sql1);
	//IN065341 ends
		rs = pstmt.executeQuery();
		if (rs.next())
		{
			legend_type = rs.getString(1) == null ? "S" : rs.getString(1);
		}
		if (rs != null) rs.close();
		if (pstmt != null) pstmt.close();
				
		//query_current_medications.append(" select EVENT_DATE dummydate,c.SHORT_DESC event_class,b.short_desc event_desc,e.short_desc event_group_desc, to_char(EVENT_DATE, 'dd/mm/yyyy hh24:mi') event_date, RESULT_NUM,  nvl(RESULT_NUM_PREFIX,'')||nvl(RESULT_NUM,'')||nvl(RESULT_STR,'')||' '||nvl(RESULT_NUM_UOM,'') care_flow_detail, NORMAL_LOW, NORMAL_HIGH, a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.CONTR_SYS_ID,a.ACCESSION_NUM,a.CONTR_SYS_EVENT_CODE,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE  = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, a.normalcy_ind, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc) DESC_CELL_IND FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.hist_data_type, a.NORMALCY_STR  from cr_encounter_detail a, CR_CLN_EVT_MST_LANG_VW b,  CR_EVENT_CLASS_LANG_VW   C,  CR_CLN_EVT_GRP_LANG_VW e where a.hist_rec_type = 'PTCR' and b.hist_rec_type  = a.hist_rec_type and b.event_code = a.event_code AND   b.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and b.language_id = ? and e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and e.language_id(+) = ? and c.hist_rec_type  = a.hist_rec_type and c.event_class = a.event_class and c.language_id = ? and patient_id = ? and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO	< 5	) AND A.HIST_REC_TYPE='PTCR'" );//IN033489
		//query_current_medications.append(" select EVENT_DATE dummydate,c.SHORT_DESC event_class,b.short_desc event_desc,e.short_desc event_group_desc, to_char(EVENT_DATE, 'dd/mm/yyyy hh24:mi') event_date, RESULT_NUM,  nvl(RESULT_NUM_PREFIX,'')||nvl(RESULT_NUM,'')||nvl(RESULT_STR,'')||' '||nvl(RESULT_NUM_UOM,'') care_flow_detail, NORMAL_LOW, NORMAL_HIGH, a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.CONTR_SYS_ID,a.ACCESSION_NUM,a.CONTR_SYS_EVENT_CODE,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT WHERE HIST_REC_TYPE  = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, a.normalcy_ind, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc) DESC_CELL_IND FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM)  normal_range_symbol, a.hist_data_type, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  from cr_encounter_detail a, CR_CLN_EVT_MST_LANG_VW b,  CR_EVENT_CLASS_LANG_VW   C,  CR_CLN_EVT_GRP_LANG_VW e where a.hist_rec_type = 'PTCR' and b.hist_rec_type  = a.hist_rec_type and b.event_code = a.event_code AND   b.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and b.language_id = ? and e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and e.language_id(+) = ? and c.hist_rec_type  = a.hist_rec_type and c.event_class = a.event_class and c.language_id = ? and patient_id = ? and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER where patient_id= ? ) where RANK_NO	< 5	) AND A.HIST_REC_TYPE='PTCR'" );//IN033489
	//IN069978 starts	
		//query_current_medications.append(" select EVENT_DATE dummydate,c.SHORT_DESC event_class,b.short_desc event_desc,e.short_desc event_group_desc, to_char(EVENT_DATE, 'dd/mm/yyyy hh24:mi') event_date, RESULT_NUM,  nvl(RESULT_NUM_PREFIX,'')||nvl(RESULT_NUM,'')||nvl(RESULT_STR,'')||' '||nvl(RESULT_NUM_UOM,'') care_flow_detail, NORMAL_LOW, NORMAL_HIGH, a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.CONTR_SYS_ID,a.ACCESSION_NUM,a.CONTR_SYS_EVENT_CODE,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE  = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, a.normalcy_ind, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM ##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc) DESC_CELL_IND FROM CR_CLIN_EVENT_PARAM ##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM ##REPDB##)  normal_range_symbol, a.hist_data_type, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  from cr_encounter_detail ##REPDB## a, CR_CLN_EVT_MST_LANG_VW ##REPDB## b,  CR_EVENT_CLASS_LANG_VW  ##REPDB## C,  CR_CLN_EVT_GRP_LANG_VW ##REPDB## e where a.hist_rec_type = 'PTCR' and b.hist_rec_type  = a.hist_rec_type and b.event_code = a.event_code AND   b.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and b.language_id = ? and e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and e.language_id(+) = ? and c.hist_rec_type  = a.hist_rec_type and c.event_class = a.event_class and c.language_id = ? and patient_id = ? and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER ##REPDB## where patient_id= ? ) where RANK_NO	< 5	) AND A.HIST_REC_TYPE='PTCR'" );//IN065341	
		//6484 Start.
		//query_current_medications.append(" select EVENT_DATE dummydate,c.SHORT_DESC event_class,b.short_desc event_desc,e.short_desc event_group_desc, to_char(EVENT_DATE, 'dd/mm/yyyy hh24:mi') event_date, RESULT_NUM,  nvl(RESULT_NUM_PREFIX,'')||nvl(RESULT_NUM,'')||nvl(RESULT_STR,'')||' '||nvl(RESULT_NUM_UOM,'') care_flow_detail, NORMAL_LOW, NORMAL_HIGH, a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.CONTR_SYS_ID,a.ACCESSION_NUM,a.CONTR_SYS_EVENT_CODE,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE  = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) ,'N') text_exisits, a.normalcy_ind, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM ##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc) DESC_CELL_IND FROM CR_CLIN_EVENT_PARAM ##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM ##REPDB##)  normal_range_symbol, a.hist_data_type, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  from cr_encounter_detail ##REPDB## a, CR_CLN_EVT_MST_LANG_VW ##REPDB## b,  CR_EVENT_CLASS_LANG_VW  ##REPDB## C,  CR_CLN_EVT_GRP_LANG_VW ##REPDB## e where a.hist_rec_type = 'PTCR' and b.hist_rec_type  = a.hist_rec_type and b.event_code = a.event_code AND   b.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and b.language_id = ? and e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and e.language_id(+) = ? and c.hist_rec_type  = a.hist_rec_type and c.event_class = a.event_class and c.language_id = ? and patient_id = ? ");
		query_current_medications.append(" select EVENT_DATE dummydate,c.SHORT_DESC event_class,b.short_desc event_desc,e.short_desc event_group_desc, to_char(EVENT_DATE, 'dd/mm/yyyy hh24:mi') event_date, RESULT_NUM,  nvl(RESULT_NUM_PREFIX,'')||nvl(RESULT_NUM,'')||nvl(RESULT_STR,'')||' '||nvl(RESULT_NUM_UOM,'') care_flow_detail, NORMAL_LOW, NORMAL_HIGH, a.EXT_IMAGE_APPL_ID,a.EXT_IMAGE_OBJ_ID,a.CONTR_SYS_ID,a.ACCESSION_NUM,a.CONTR_SYS_EVENT_CODE,NVL((SELECT 'Y' FROM CR_ENCOUNTER_DETAIL_TXT##CLOB## WHERE HIST_REC_TYPE  = A.hist_rec_type AND CONTR_SYS_ID=A.contr_sys_id AND ACCESSION_NUM = a.accession_num	AND CONTR_SYS_EVENT_CODE = A.contr_sys_event_code and (dbms_lob.getlength(hist_data)>0  or nvl(dbms_lob.getlength(compress_hist_data),0)>0)) ,'N') text_exisits, a.normalcy_ind, (SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM ##REPDB##) COLOR_CELL_IND,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc) DESC_CELL_IND FROM CR_CLIN_EVENT_PARAM ##REPDB##) DESC_CELL_IND, (select DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE') FROM CR_CLIN_EVENT_PARAM ##REPDB##)  normal_range_symbol, a.hist_data_type, a.NORMALCY_STR, a.encounter_ID, a.FACILITY_ID  from cr_encounter_detail ##REPDB## a, CR_CLN_EVT_MST_LANG_VW ##REPDB## b,  CR_EVENT_CLASS_LANG_VW  ##REPDB## C,  CR_CLN_EVT_GRP_LANG_VW ##REPDB## e where a.hist_rec_type = 'PTCR' and b.hist_rec_type  = a.hist_rec_type and b.event_code = a.event_code AND   b.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and b.language_id = ? and e.hist_rec_type(+)=A.hist_rec_type AND  e.event_group(+)=A.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE and e.language_id(+) = ? and c.hist_rec_type  = a.hist_rec_type and c.event_class = a.event_class and c.language_id = ? and patient_id = ? ");
		//6484 end.
		if("".equals(RepDb)){
		query_current_medications.append(" and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from (select FACILITY_ID,ENCOUNTER_ID, ROW_NUMBER() OVER (ORDER BY VISIT_ADM_DATE_TIME DESC) RANK_NO  from  PR_ENCOUNTER ##REPDB## where patient_id= ? ) where RANK_NO	< 5	) AND A.HIST_REC_TYPE='PTCR'" );//IN065341
		}else{
		query_current_medications.append(" and (FACILITY_ID,ENCOUNTER_ID) in (select FACILITY_ID,ENCOUNTER_ID from  PR_ENCOUNTER ##REPDB## where patient_id= ? and encounter_id=?)");
		}
	//IN069978 ends
		//query_current_medications.append(" and nvl(ca_view_confidnt_event (a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); //IN042552
		query_current_medications.append(" and nvl(ca_view_confidnt_event  ##REPDB##(a.facility_id,a.ENCOUNTER_ID,a.PATIENT_ID,a.accession_num,A.CONTR_SYS_ID,a.event_code,a.hist_rec_type,'"+clinician_id+"','"+resp_id+"',a.performed_by_id,a.AUTHORIZED_BY_ID,DECODE(a.hist_rec_type,'CLNT',null,a.event_group)),'N')='Y' "); //IN042552
		
		if (viewconf_appl.equals("X"))
			query_current_medications.append(" and (nvl(A.PROTECTION_IND,'N')!='Z' )  ");
	//IN069978 starts	
		if("".equals(RepDb)){
			if (modal_yn.equals("N")) {
			//query_current_medications.append(" AND exists (select 1 from (SELECT HIST_REC_TYPE, CONTR_SYS_ID,ACCESSION_NUM,CONTR_SYS_EVENT_CODE, dense_rank() over (order by event_date desc) drank FROM CR_ENCOUNTER_DETAIL WHERE  PATIENT_ID=? and HIST_REC_TYPE='PTCR' ) WHERE drank<3 AND HIST_REC_TYPE=A.HIST_REC_TYPE 	AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) ");
			query_current_medications.append(" AND exists (select 1 from (SELECT HIST_REC_TYPE, CONTR_SYS_ID,ACCESSION_NUM,CONTR_SYS_EVENT_CODE, dense_rank() over (order by event_date desc) drank FROM CR_ENCOUNTER_DETAIL ##REPDB## WHERE  PATIENT_ID=? and HIST_REC_TYPE='PTCR' ) WHERE drank<3 AND HIST_REC_TYPE=A.HIST_REC_TYPE 	AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) ");//IN065341
			//query_current_medications.append("  and nvl(a.STATUS,'`') not in('S','E')  order by dummydate desc, c.SHORT_DESC, request_num_seq, e.short_desc, a.event_group, b.short_desc, a.event_code "); - commented for IN050649
			}
		}else{
	
			query_current_medications.append(" AND exists (select 1 from (SELECT HIST_REC_TYPE, CONTR_SYS_ID,ACCESSION_NUM,CONTR_SYS_EVENT_CODE, dense_rank() over (order by event_date desc) drank FROM CR_ENCOUNTER_DETAIL ##REPDB## WHERE  PATIENT_ID=? and encounter_id=?  and HIST_REC_TYPE='PTCR' ) WHERE ");
			if (modal_yn.equals("N"))
				query_current_medications.append(" drank<3");
			else
				query_current_medications.append(" drank<10000");
			query_current_medications.append(" AND HIST_REC_TYPE=A.HIST_REC_TYPE 	AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE) ");//IN065341
		}
	//IN069978 ends	
		
	
		query_current_medications.append("  and nvl(a.STATUS,'`') not in('S','E')  order by dummydate desc, c.SHORT_DESC, e.short_desc, a.event_group, request_num_seq, b.short_desc, a.event_code "); // modified for IN050649

		//IN065341 starts
		//pstmt	=	con.prepareStatement(query_current_medications.toString());
		String result=query_current_medications.toString();
		result=result.replaceAll("##REPDB##", RepDb);
		result=result.replaceAll("##CLOB##", clob_data);
		pstmt	=	con.prepareStatement(result);//IN065341 ends
		pstmt.setString(1,locale);
		pstmt.setString(2,locale);
		pstmt.setString(3,locale);
		pstmt.setString(4,patient_id);		
		if("".equals(RepDb)){//IN069978 
			pstmt.setString(5,patient_id);
			if (modal_yn.equals("N")) 
				pstmt.setString(6,patient_id);
		}else{//IN069978 starts
			pstmt.setString(5,patient_id);
			pstmt.setString(6,enc_id);
			pstmt.setString(7,patient_id);
			pstmt.setString(8,enc_id);
		}//IN069978 ends
		rs = pstmt.executeQuery();

		while(rs.next())
		{
			i++;

			event_date			=	rs.getString("event_date");
			eventclass			=	rs.getString("event_class");
			event_group_desc	=	rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
			event_desc			=	rs.getString("event_desc");
			textExist			=	rs.getString("text_exisits");
			care_flow_detail	=	rs.getString("care_flow_detail");
			contr_sys_id	=	rs.getString("contr_sys_id") == null ? "" : rs.getString("contr_sys_id");
			accession_num	=	rs.getString("accession_num") == null ? "" : rs.getString("accession_num");
			contr_sys_event_code	=	rs.getString("contr_sys_event_code") == null ? "" : rs.getString("contr_sys_event_code");
			ext_image_appl_id =	rs.getString("ext_image_appl_id") == null ? "" : rs.getString("ext_image_appl_id"); 
			ext_image_obj_id	=	rs.getString("ext_image_obj_id") == null ? "" : rs.getString("ext_image_obj_id");
			if(legend_type.equals("C"))
				color_cell_indicator = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
			else if(legend_type.equals("S"))
				color_cell_indicator = rs.getString("normal_range_symbol") == null ? "" : rs.getString("normal_range_symbol");
			descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
			normalcyInd = rs.getString("normalcy_ind") == null ? "" : rs.getString("normalcy_ind");
			normalLow = rs.getString("NORMAL_LOW") == null ? "" : rs.getString("NORMAL_LOW");
			normalHigh = rs.getString("NORMAL_HIGH") == null ? "" : rs.getString("NORMAL_HIGH");
			resultNum = rs.getString("RESULT_NUM") == null ? "0" : rs.getString("RESULT_NUM");
			hist_data_type = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");
			normalcy_str = rs.getString("NORMALCY_STR") == null ? "" : rs.getString("NORMALCY_STR");
			enctr_id = rs.getString("encounter_ID") == null ? "" : rs.getString("encounter_ID");//IN033489
			fac_id = rs.getString("FACILITY_ID") == null ? "" : rs.getString("FACILITY_ID");//IN033489
			if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
				styleValue = "STYLE= 'FONT-SIZE: 7PT;background-color:"+color_cell_indicator+"' ";
			else
				styleValue = " class = 'gridData' ";

			if(event_date==null)		event_date			=	"&nbsp;";
			if(care_flow_detail==null)	care_flow_detail	=	"&nbsp;";
			care_flow_detail = care_flow_detail.trim();
			if(care_flow_detail.equals("")) care_flow_detail = "&nbsp;";

			if(!event_date.equals("&nbsp;") )
				event_date = com.ehis.util.DateUtils.convertDate(event_date,"DMYHM","en",locale);

			if(!event_date.equals(preveventdate))
			{
				
				//out.println("<tr><td class='gridData' colspan=3 ><b>"+eventclass+"&nbsp-&nbsp"+event_group_desc+"</b></td>");
				out.println("<tr><td class='gridData' colspan=3 ><b>"+eventclass);
				if(!"".equals(event_group_desc))
					out.println("&nbsp-&nbsp"+event_group_desc+"</b></td>");
				else
					out.println("</b></td>");
				
				out.println("<td class='gridData' colspan=3 nowrap><b>"+event_date+"</b></td></tr>");
				/*if (!event_group_desc.equals(""))
				{
					out.println("  <tr><td class='gridData' colspan=3><b>"+event_group_desc+"</b></td></tr>");
				}*/
			}
			else if(!eventclass.equals(preveventclass))
			{
				
				//out.println("<tr><td class='gridData' colspan=3 ><b>"+eventclass+"&nbsp-&nbsp"+event_group_desc+"</b></td>");
				out.println("<tr><td class='gridData' colspan=3 ><b>"+eventclass);
				if(!"".equals(event_group_desc))
					out.println("&nbsp-&nbsp"+event_group_desc+"</b></td>");
				else
					out.println("</b></td>");
				
				out.println("<td class='gridData' colspan=3 nowrap><b>"+event_date+"</b></td></tr>");
				/*if (!event_group_desc.equals(""))
				{
					out.println("  <tr><td class='gridData' colspan=3><b>"+event_group_desc+"</b></td></tr>");
				}*/
			}
			else if(!event_group_desc.equals(prevevent_group_desc))
			{					 
				 if (!event_group_desc.equals(""))
				 {
					out.println("  <tr><td class='gridData' colspan=3>&nbsp;&nbsp;&nbsp;<b>"+event_group_desc+"</b></td></tr>");
				 }
			}
					
			if(!ext_image_appl_id.equals(""))
			{
				out.println("<tr><td class='gridData'>&nbsp;&nbsp;&nbsp&nbsp;</td><td class='gridData'>"+event_desc+"</td> <td class='gridData'>");
				if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
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
						if(Float.parseFloat(resultNum)>0)
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
					else if(!normalLow.equals("") && normalHigh.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum)>0)
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
						if(Float.parseFloat(resultNum)>0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}//END
				}
				out.println("<b>"+care_flow_detail+"</b>");
				if(!descCellInd.equals(""))
				{
					out.println("<FONT size =1 COLOR='BLACK' ><b>&nbsp;"+descCellInd+"</b></FONT>");						
				}
				if(hist_data_type.equals("STR") && !normalcy_str.equals(""))
				{
					out.println("("+normalcy_str+")");
				}
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"')\">");	//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\">");	//IN033489
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\">");	//IN065341
				}
			//	out.println("<img src = '../../eCA/images/"+ext_image_appl_id+".gif' onClick=\"return getFile('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"')\">");
				//Commentted for EMG
		
				//Added docul condition for EMG
				if ( (ext_image_appl_id != null && (!ext_image_appl_id.equals("")))) 
				{
					if(!("DOCUL").equals(ext_image_appl_id)) 
					{
						//IN050936 included patient_id
					//IN068797 starts	
						//out.println("<img src = '../../eCA/images/"+ext_image_appl_id+".gif' alt='Result' onClick=\"return getFile('PTCR','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\">");
						out.println("<img src = '../../eCA/images/"+ext_image_appl_id+".gif' alt='Result' onClick=\"return getFile('PTCR','"+contr_sys_id+"','"+ext_image_obj_id+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+fac_id+"')\">");
					//IN068797 ends	
					}
					else
					{
						//IN050936 included patient_id
					//IN068797 starts	
						//out.println("<img src = '../../eCA/images/"+ext_image_appl_id+".gif' alt='Result' onClick=\"return getFile('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"')\">");
						out.println("<img src = '../../eCA/images/"+ext_image_appl_id+".gif' alt='Result' onClick=\"return getFile('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+ext_image_appl_id+"','"+patient_id+"','','','','"+RepDb+"','"+clob_data+"','"+fac_id+"')\">");
					//IN068797 ends	
					}
										
				}

				
				out.println("</td></tr>");
			}
			else
			{
				out.println("<tr><td class='gridData'>&nbsp;&nbsp;&nbsp;&nbsp;</td><td class='gridData'>"+event_desc+"</td>");
				out.println("<td class='gridData'>");
				if(!color_cell_indicator.equals("") && color_cell_indicator != null && !color_cell_indicator.equals("NONE"))
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
						if(Float.parseFloat(resultNum)>0)
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
					else if(!normalLow.equals("") && normalHigh.equals(""))//Added by Jyothi.G on 09/12/2010 to fix IN025310
					{
						if(Float.parseFloat(resultNum)>0)
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
						if(Float.parseFloat(resultNum)>0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
							{
								if(legend_type.equals("S"))
									out.println("<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
								else
									out.println("<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;");
							}
						}
					}//END
				}
				out.println("<b>"+care_flow_detail+"</b>");

				if(!descCellInd.equals(""))
				{
					out.println("<FONT size =1 COLOR='BLACK' ><b>&nbsp;"+descCellInd+"</b></FONT>");						
				}
				if(hist_data_type.equals("STR") && !normalcy_str.equals(""))
				{
					out.println(" <font color=blue>( Normal Value : "+normalcy_str+" )</font>");
				}
				if(textExist.equals("Y"))
				{
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"')\">");//IN033489
					//out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"')\">");//IN033489	
					out.println("<img src='../../eCA/images/flow_text.gif' onClick=\"return getText('PTCR','"+contr_sys_id+"','"+accession_num+"','"+contr_sys_event_code+"','"+enctr_id+"','"+fac_id+"','"+RepDb+"','"+clob_data+"')\">");//IN065341					
				}
				out.println("</td></tr>");
			}
			preveventclass=eventclass;
			preveventdate=event_date;
            prevevent_group_desc=event_group_desc;
		}
		if(rs != null) rs.close();
		if(pstmt != null) pstmt.close();

		if (i==0)
			out.println("<tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NoPatientcaredata.label","ca_labels")+" </td></tr>");
		else if (modal_yn.equals("N"))
		{
%>			<!--IN065341 starts-->
			<!-- <tr><td colspan='3' class='gridData'  >
				<a  class='gridLink' href="javascript:flowsheetSummary('<%=patient_id%>','<%=title%>','<%=reln_id%>','<%=enc_id%>')"> <fmt:message key="eCA.MoreDtlRef.label" bundle="${ca_labels}"/></a></td></tr> <!-- INO30714 -->
				<tr><td colspan='3' class='gridData'  >
				<a  class='gridLink' href="javascript:flowsheetSummary('<%=patient_id%>','<%=title%>','<%=reln_id%>','<%=enc_id%>','<%=RepDb%>','<%=clob_data%>')"> <fmt:message key="eCA.MoreDtlRef.label" bundle="${ca_labels}"/></a></td></tr>
			<!--IN065341 ends-->	
<%
		}
	}
	catch(Exception e)
	{
		//out.println("Exception@1 : "+e.getMessage());//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}
		%>
	</table>
	<!--INO30714 Starts -->
	<input type="hidden" name="patient_id" id="patient_id" value='<%=patient_id%>'> 
	<input type="hidden" name="enc_id" id="enc_id" value='<%=enc_id%>'> 
	<!-- INO30714 Ends-->
	</form>
	</center>
</body>
</html>

