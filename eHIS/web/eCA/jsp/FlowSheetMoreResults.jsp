<%
/*
--------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------
?             100            ?           created
23/08/2011    IN:028353     Menaka V     									Incident No: 028353 - <System adds '0' before result of Auto
																			report orders in Clinical Event History ( Flow sheet view ).> 
18/05/2012	  IN032794		Menaka V	 									Clinical Event History>View Mode- Flow Sheet>when we click on More values to view
																			other recording of the Note for the same time we get Java Exception Error.			   
04/09/2014    PER0409				     									Performance changes suggested by sunil											 
26/11/2014 	IN052645		Vijayakumar K	26/11/2014	 	Ramesh Goli		ML-BRU-SCF-1468 [IN:052645] Clinical History ? When user select any flow sheet option, 				 
26/1/2020	IN072027		Ramesh G		26/1/2020		Ramesh Goli		ML-MMOH-SCF-1442
18/9/2020	IN074077		Ramesh G		18/9/2020		Ramesh Goli		ML-MMOH-SCF-1614
05/03/2021	TFS14631		Ramesh G		05/03/2021		Ramesh Goli		ML-MMOH-SCF-1737
20/07/2023	  24094	   Ranjith P R		21/07/2023		RAMESH G		ML-MMOH-CRF-1804
--------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@page import="java.sql.*,java.util.*,java.util.zip.*,java.text.*,webbeans.eCommon.*,java.math.*,java.sql.Types,java.io.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.0 Transitional//EN">
<HTML>
<HEAD>
<TITLE> <fmt:message key="Common.NewDocument.label" bundle="${common_labels}"/> </TITLE>
<META NAME="Generator" CONTENT="EditPlus">
<META NAME="Author" CONTENT="">
<META NAME="Keywords" CONTENT="">
<META NAME="Description" CONTENT="">

<%
	String strEncId ="";
	String strPatientId = "";
	String strEncounterId ="";
	String beanKeyEncId = "";
	
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");		
	strEncounterId	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	strEncId	= request.getParameter("enc_id")==null?"0":request.getParameter("enc_id");
	String enctr_id	= request.getParameter("enctr_id")==null?"0":request.getParameter("enctr_id");//IN032794
	String fac_id ="";
	String login_user = (String)session.getValue("login_user"); //TFS14631
	beanKeyEncId = strEncId;
	strPatientId		= request.getParameter("patientid")==null?"":request.getParameter("patientid");
	eCA.PatientBannerGroupLine manageEmailBean = null;
	manageEmailBean = (eCA.PatientBannerGroupLine)getObjectFromBean("manageEmailBean"+strPatientId+beanKeyEncId,"eCA.PatientBannerGroupLine",session);
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<Script src="../../eCommon/js/showModalDialog.js" language="JavaScript"></Script><script src='../../eCA/js/FlowSheet.js'></script>
<script src='../../eCA/js/CAOpenExternalApplication.js' language='javascript'></script><!-- Added for IN072027 -->
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>

<style>
A:link
{
    COLOR: #FFFFFF;
	FONT-SIZE: 7PT;
	font-family: Verdana;
	font-weight:Bold;
	text-align:left;
}
A:visited
{
    COLOR: #FFFFFF;
	FONT-SIZE: 7PT;
	font-family: Verdana;
	font-weight:Bold;
	text-align:left;
} 

TD.CAGREEN {
	FONT-SIZE: 9PT ;
	BACKGROUND-COLOR: #99CC00;
	BORDER-STYLE: SOLID;
	BORDER-LEFT-COLOR: #B2B6D7;
	BORDER-RIGHT-COLOR: #B2B6D7;
	BORDER-TOP-COLOR: #E2E3F0;
	BORDER-BOTTOM-COLOR: #E2E3F0;
}

TD.TD_BROWN{
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()" onResize='alignDivs()'>

<%!
private String extractSpecimenNumber(String str, String firstSplitter, String secondSplitter)
{
	if(str!=null && str.length()>0)
		return str.substring(str.indexOf(firstSplitter)+1, str.indexOf(secondSplitter));
	return "";
}
%>
<% 
Connection con = null;
try
{
	con = ConnectionManager.getConnection(request);
	String strFromDate  = "";
	String strToDate = "";

	String strHistRecType = "";
	String strEventClass ="";
	String strEventGroup = "";
	String strEventCode  = "";
	String strFacilityId ="";

	String strEpisodeType ="";
	String strNormalcyInd ="";
	String strAbnormal ="";
	String strFlowSheetId ="";
	String strViewConfRes ="";
	String strGraphOrder ="";
	String called_from ="";
	String strErrorEvent ="";
	String prevHistRecType = "";
	String prevEventClass = "";
	String prevEventGroup = "";
	String prevEventCode = "";
	String legend_type = "";
	String temp_Event_Date = "";
	String normalcy_str = "";
		  
	ArrayList keyList = manageEmailBean.returnList2();

	int prevK = 0;	
	int nIndex = 1;

	strNormalcyInd = request.getParameter("normalcy")==null?"N":request.getParameter("normalcy");				
	strGraphOrder		= request.getParameter("graph_order")==null?"":request.getParameter("graph_order");
	strViewConfRes	= request.getParameter("view_conf_res")==null?"":request.getParameter("view_conf_res");
	strFromDate		= request.getParameter("c_from_date")==null?"":request.getParameter("c_from_date");
	strToDate			= request.getParameter("c_to_date")==null?"":request.getParameter("c_to_date");
	strFlowSheetId	= request.getParameter("flowsheet_Id")==null?"":request.getParameter("flowsheet_Id");
	strEventCode		= request.getParameter("event_code")==null?"":request.getParameter("event_code");
	strErrorEvent		= request.getParameter("error_event")==null?"":request.getParameter("error_event");
	strAbnormal		= request.getParameter("abnormal")==null?"N":request.getParameter("abnormal");
	strEventGroup		= request.getParameter("event_group")==null?"":request.getParameter("event_group");
	strEventClass		= request.getParameter("event_class")==null?"":request.getParameter("event_class");
	strHistRecType	= request.getParameter("hist_rec_type")==null?"":request.getParameter("hist_rec_type");
	strFacilityId		= request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	strEpisodeType	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
	called_from		= request.getParameter("p_called_from")==null?"":request.getParameter("p_called_from");
	temp_Event_Date		= request.getParameter("tempEventDate1")==null?"":request.getParameter("tempEventDate1");
      	
	StringBuffer strBuffDates = new StringBuffer();
	StringBuffer sqlData	  = new StringBuffer();
	StringBuffer sbQryCriteria = new StringBuffer();
  
	ArrayList dateList = new ArrayList();
	StringBuffer allDatesForGraph = new StringBuffer();
	String lastDateTime = "";
	String firstDateTime = "";

	HashMap tempSessionMap = null;
	HashMap tempTDMap = null;
	HashMap tempTRMap = null;

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmtImgView = null;  //TFS14631
	ResultSet resImgView = null; //TFS14631
	CallableStatement cs=null; //TFS14631
	PreparedStatement pstmtPerFacId = null;  //TFS14631
	ResultSet rsetPerFacId = null;  //TFS14631

	sbQryCriteria.append(" a.patient_id = ? ");

	if(!strHistRecType.equals(""))
		sbQryCriteria.append(" and a.hist_rec_type = ? ");

	if(!strEventClass.equals(""))
		sbQryCriteria.append(" and a.event_class = ? ");

	if(!strEventGroup.equals(""))
	{
		sbQryCriteria.append(" and (a.event_group is null or a.event_group = ? ) ");
	}

	if(!strEventCode.equals(""))
		sbQryCriteria.append(" and a.event_code = ? ");

	if(!temp_Event_Date.equals(""))
		sbQryCriteria.append(" and a.event_date  BETWEEN to_date(?,'dd/mm/yyyy HH24:MI') AND to_date(?,'dd/mm/yyyy HH24:MI') +(59/86400) " ); 

	if(!strFacilityId.equals(""))
		sbQryCriteria.append(" and a.facility_id = ? ");

	if(!strEncounterId.equals(""))
		sbQryCriteria.append(" and a.encounter_id = ? ");

	if (!strEpisodeType.equals("") )
		sbQryCriteria.append(" and a.PATIENT_CLASS = ? ");

	if(strAbnormal.equals("Y"))
	{
		sbQryCriteria.append(" and nvl(a.normalcy_ind,'.')!='.' ");
	}

	if(strViewConfRes.equals("X"))
		sbQryCriteria.append("and nvl(PROTECTION_IND,'N')!='Z'  ");

	if(strErrorEvent.equals("Y"))//dont'include error events
		sbQryCriteria.append(" and nvl(a.STATUS,'`')!= 'S'  ");
	else 
		sbQryCriteria.append(" and nvl(a.STATUS,'`') not in('S','E')"); 

	try
	{
		strBuffDates.append("Select to_char(a.event_date,'dd/mm/yyyy hh24:mi') event_date 	From 	cr_encounter_detail a ");
		strBuffDates.append("where  "+sbQryCriteria.toString());

		if(!strFlowSheetId.equals(""))
			strBuffDates.append(" and exists (select 1 from ca_flow_sheet_item f where f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE) ") ;
			
		strBuffDates.append(" Order by to_date(event_date,'dd/mm/yyyy hh24:mi')  "+strGraphOrder);
		
		tempSessionMap = new HashMap();
		tempTDMap = new HashMap();
        
		pstmt = con.prepareStatement(strBuffDates.toString());
		pstmt.setString(nIndex++,strPatientId);
		if(!strHistRecType.equals(""))
		{
			pstmt.setString(nIndex++,strHistRecType);
		}

		if(!strEventClass.equals(""))
		{
			pstmt.setString(nIndex++,strEventClass);
		}

		if(!strEventGroup.equals(""))
		{
			pstmt.setString(nIndex++,strEventGroup);
		}

		if(!strEventCode.equals(""))
		{
			pstmt.setString(nIndex++,strEventCode);
		}

		if(!(temp_Event_Date.equals("") || temp_Event_Date.equals(null) || temp_Event_Date.equals("null")))
		{  
			pstmt.setString(nIndex++,temp_Event_Date);
			pstmt.setString(nIndex++,temp_Event_Date);
		}
		
		if(!strFacilityId.equals(""))
		{
			pstmt.setString(nIndex++,strFacilityId);
		}

		if(!strEncounterId.equals(""))
		{
			pstmt.setString(nIndex++,strEncounterId);
		}
	
		if(!strEpisodeType.equals("") )
		{
			if(strEpisodeType.equals("I"))
				pstmt.setString(nIndex++,"IP");
			else if(strEpisodeType.equals("O"))
				pstmt.setString(nIndex++,"OP");
			else if(strEpisodeType.equals("D"))
				pstmt.setString(nIndex++,"DC");
			else if(strEpisodeType.equals("E"))
				pstmt.setString(nIndex++,"EM");
			else if(strEpisodeType.equals("X"))
				pstmt.setString(nIndex++,"XT");
		}

		if(!strFlowSheetId.equals(""))
		{
			pstmt.setString(nIndex++,strFlowSheetId);
		}
		
		rs = pstmt.executeQuery();

		String strTempDt = "";

        while(rs.next())
		{
			if(dateList.size() == 0)
			{
				firstDateTime = rs.getString(1);
			}
			if(dateList.size() < 10)
			{
				if(!dateList.contains(rs.getString(1)))
				{
				   strTempDt = rs.getString(1);
				   dateList.add(strTempDt);
				   allDatesForGraph.append(com.ehis.util.DateUtils.convertDate(strTempDt,"DMYHM","en",locale)+"$$");
				}
			}
			else
			{
				lastDateTime = rs.getString(1);
			}
        }

		if(rs!= null) rs.close();
        if(pstmt!=null) pstmt.close();

		if(called_from.equals("OR"))
		{
			pstmt = con.prepareStatement("select LEGEND_TYPE from CR_CLIN_EVENT_PARAM");
			rs = pstmt.executeQuery();
			if(rs.next())
				legend_type = rs.getString("LEGEND_TYPE") == null ? "S" : rs.getString("LEGEND_TYPE");
			if(rs!= null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
	}//end of try-1
	catch(Exception e)
	{
		//out.println("Exception in try-1 of FlowSheetMoreResults.jsp -"+e.toString());//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
	}
    finally
	{}
%>
	<form name='dataForm' id='dataForm'>
		<div id='divDataTitle' style='postion:relative'>
			<table  width='100%' id='dataTitleTable' class='grid' align='center' >
				<TR>
<%
				String strConvDt = "";
				int dateListSize = dateList.size();
				for(int i=0;i<dateListSize;i++)
				{
					strConvDt = com.ehis.util.DateUtils.convertDate((String)dateList.get(i),"DMYHM","en",locale);
%>
					<TH nowrap><%=strConvDt%>&nbsp;</TH>
<%
				}
%>
				</TR>
			</table>
		</div>
		<table width='100%' id='dataTable' class='grid' align='center' height='parent.offsetHeight'>
<%

	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, b.short_desc hist_rec_type_desc, a.event_class eve_class, c.long_desc event_class_desc, nvl(a.event_group,'*ALL') event_group ,nvl(e.long_desc,d.long_desc) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,'"+locale+"','1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id,  CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,'"+locale+"')  GetTooltip, a.STATUS stat,replace(d.short_desc,'''','') sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,'"+locale+"','1') performed_by,a.encounter_ID, a.normalcy_str From cr_encounter_detail a ,cr_hist_rec_type b, cr_event_class   c ,cr_clin_event_mast d ,cr_clin_event_group e ");//Menaka
	
	//PER0409 - removed '"+locale+"' from below query (3 places) and tuned the query for performance issue
	//TFS14631 Start.
	//sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, (select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class )  event_class_desc, nvl(a.event_group,'*ALL') event_group ,(select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE)  sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.facility_id From cr_encounter_detail a");//Menaka
    //sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, (select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class )  event_class_desc, nvl(a.event_group,'*ALL') event_group ,(select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID,  CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE)  sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.facility_id,a.category_number,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.REQUEST_NUM Specimen_num,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no From cr_encounter_detail a");//Menaka
      sqlData.append("Select a.event_date dummydate, to_char(event_date,'dd/mm/yyyy hh24:mi') event_date_time , to_char(event_date,'YYYYMMDDHH24MISS') sort_event_date_time, a.hist_rec_type hist_rec_type, (select short_desc from cr_hist_rec_type where hist_rec_type=a.hist_rec_type)  hist_rec_type_desc, a.event_class eve_class, (select long_desc from cr_event_class where hist_rec_type=a.hist_rec_type and  event_class= a.event_class )  event_class_desc, nvl(a.event_group,'*ALL') event_group ,(select long_desc FROM cr_clin_event_group WHERE hist_rec_type(+)=a.hist_rec_type and  event_group(+)=a.event_group and EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE) event_group_desc ,a.event_code eve_code,CR_GET_DESC.CR_CLIN_EVENT_MAST(A.HIST_REC_TYPE,A.EVENT_CODE,A.EVENT_CODE_TYPE,?,'1') event_desc, a.accession_num acc_num,a.contr_sys_id sys_id,a.contr_sys_event_code sys_eve_code,a.hist_data_type hist_data_type,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(RESULT_NUM),TO_CHAR(RESULT_NUM,DECODE(RESULT_NUM_DEC	,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) RESULT_NUM ,a.result_num_uom uom,a.result_str res_str,A.normalcy_ind norm_ind,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_low),TO_CHAR(a.normal_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_low ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.normal_high),TO_CHAR(a.normal_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) normal_high ,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_low),TO_CHAR(a.critical_low,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_low,DECODE(nvl(RESULT_NUM_DEC,0),0, TO_CHAR(a.critical_high),TO_CHAR(a.critical_high,DECODE(RESULT_NUM_DEC,1,'999999990.0',2,'999999990.90',3,'999999990.900',4,'999999990.9000',5,'999999990.90000',6,'999999990.900000',7,'999999990.9000000',8,'999999990.90000000',9,'999999990.90000000',0,'999999999','999999999'))) critical_high, a.ext_image_obj_id ext_img_id, a.ext_image_appl_id ext_appl_id, A.EXT_IMAGE_UPLD_ID,  CA_GET_VISIT_HDR_NEW(a.facility_id,a.PATIENT_CLASS,a.ENCOUNTER_ID,a.PATIENT_ID, a.performed_by_id,?)  GetTooltip, a.STATUS stat,(SELECT replace(short_desc,'''','') FROM cr_clin_event_mast WHERE hist_rec_type=a.hist_rec_type and event_code=a.event_code and  EVENT_CODE_TYPE =a.EVENT_CODE_TYPE)  sp_event_desc, (select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code) text_count, RESULT_NUM_PREFIX,NVL((SELECT COUNT(1) FROM CA_PRACTITIONER_QUICK_TEXT WHERE HIST_REC_TYPE= A.HIST_REC_TYPE AND CONTR_SYS_ID=A.CONTR_SYS_ID AND ACCESSION_NUM=A.ACCESSION_NUM AND CONTR_SYS_EVENT_CODE=A.CONTR_SYS_EVENT_CODE AND ROWNUM=1),0) QUICK_TEXT_COUNT,A.DELTA_FAIL_IND delta_fail_ind,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_color_code,LOW_STR,low_color_code,CRIT_STR,crit_color_code,ABN_STR,abn_color_code,CRIT_HIGH_STR,crit_high_color_code,CRIT_LOW_STR  ,crit_low_color_code,'NONE')FROM CR_CLIN_EVENT_PARAM) COLOR_CELL_IND ,(SELECT DECODE(a.normalcy_ind,HIGH_STR,high_str_desc,LOW_STR,low_str_desc,CRIT_STR,crit_str_desc,ABN_STR,abn_str_desc,CRIT_HIGH_STR,crit_high_str_desc,CRIT_LOW_STR  ,crit_low_str_desc,'NONE')FROM CR_CLIN_EVENT_PARAM) DESC_CELL_IND, (SELECT DECODE(a.normalcy_ind,HIGH_STR,HIGH_SYMBOL_ICON,LOW_STR,LOW_SYMBOL_ICON,CRIT_STR,CRIT_SYMBOL_ICON,ABN_STR,ABN_SYMBOL_ICON,CRIT_HIGH_STR,CRIT_HIGH_SYMBOL_ICON,CRIT_LOW_STR,CRIT_LOW_SYMBOL_ICON,'NONE')FROM CR_CLIN_EVENT_PARAM) SYMBOL_LEGEND_IND,  AM_GET_DESC.AM_PRACTITIONER(a.performed_by_id,?,'1') performed_by,a.encounter_ID, a.normalcy_str,a.facility_id,a.category_number,RL_GET_SPECIMEN_TYPE_DESC (a.accession_num,a.patient_id,a.facility_id) specimen_type,a.REQUEST_NUM Specimen_num,RL_NEW_REQUEST_NUM_SEQ(A.CONTR_SYS_ID,a.event_code,a.REQUEST_NUM_SEQ) sequence_no, NOTE_DATA_MODFIED_YN(a.hist_rec_type,a.accession_num) modifiedyn From cr_encounter_detail a");//Menaka //24094

      //TFS14631 End.
	if (!strFlowSheetId.equals(""))
		sqlData.append(" ,ca_flow_sheet_item f ");
   //PER090914 Starts
   //sqlData.append(" where b.hist_rec_type=a.hist_rec_type and c.hist_rec_type=a.hist_rec_type and  c.event_class= a.event_class and   d.hist_rec_type=a.hist_rec_type and  d.event_code=a.event_code and  D.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE and e.hist_rec_type(+)=a.hist_rec_type and  e.event_group(+)=a.event_group and e.EVENT_GROUP_TYPE(+)=a.EVENT_GROUP_TYPE ");
   sqlData.append(" WHERE");

    if(!strFlowSheetId.equals("")) 
	{
		//sqlData.append(" and  f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE  ") ;
		sqlData.append(" f.flow_sheet_id=? and f.hist_rec_type=a.hist_rec_type and f.event_code=a.event_code  and  f.EVENT_CODE_TYPE =a.EVENT_CODE_TYPE AND") ;
	}
	

	 //sqlData.append( " AND " + sbQryCriteria.toString());
	   sqlData.append(sbQryCriteria.toString());
	if (!strFlowSheetId.equals(""))
		//sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,c.long_desc,nvl(a.event_group,'*ALL'),e.long_desc  ,nvl(a.request_num_seq,'0'),d.long_desc,a.event_code, dummydate "+strGraphOrder+" " );
		//sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc,nvl(a.event_group,'*ALL'),event_group_desc  ,nvl(a.request_num_seq,'0'),sp_event_desc,a.event_code, dummydate ? ");//IN052645
		sqlData.append( " ORDER BY f.order_seq_no, a.hist_rec_type  ,a.event_class,event_class_desc,nvl(a.event_group,'*ALL'),event_group_desc  ,NVL (sequence_no,0),sp_event_desc,a.event_code, dummydate "+strGraphOrder+" ");//IN052645
	else 
		//sqlData.append( " ORDER BY  a.hist_rec_type  ,a.event_class,c.long_desc, nvl(a.event_group,'*ALL'),e.long_desc  ,nvl(a.request_num_seq,'0'),d.long_desc,a.event_code , dummydate "+strGraphOrder+" " );
		//sqlData.append( " ORDER BY  a.hist_rec_type  ,a.event_class,event_class_desc, nvl(a.event_group,'*ALL'),event_group_desc  ,nvl(a.request_num_seq,'0'),sp_event_desc,a.event_code , dummydate ? " );//IN052645
		sqlData.append( " ORDER BY  a.hist_rec_type  ,a.event_class,event_class_desc, nvl(a.event_group,'*ALL'),event_group_desc  ,NVL (sequence_no,0),sp_event_desc,a.event_code , dummydate "+strGraphOrder+" " );//IN052645
		
	//PER090914 Ends

	int i = 0;
	int tempCnt = 0;

	String classValue = "CACHARTQRYEVEN";
	String histRecType = "";
	String histRecTypeDesc = "";
	String eventClass = "";
	String eventClassDesc = "";
	String eventGroup = "";
	String eventGroupDesc = "";
	String eventCode = "";
	String eventDesc = "";
	String histDataType = "";
	String resultNumUOM = "";
	String dummyDate = "";
	String eventDateTime = "";
	String sortEventDateTime = "";
	String accessionNum = "";
	String sysID = "";
	String sysEventCode = "";
	String resultNum = "";
	String resultStr = "";
	String normIndicator = "";
	String normalLow = "";
	String normalHigh = "";	
	String criticalLow = "";
	String criticalHigh = "";
	String extImgID = "";
	String extApplID = "";
	String toolTip = "";
	String toolTip_ind = "";
	String splEventDesc = "";
	String quickTextCount = "0";
	String deltaFailInd = "";
	String colorCellInd = "";
	String descCellInd = "";
	String tempValue = "";

	String tempAdditional = "";
	String textCount = "";
	String performed_by = "";
	String strStatus = "";
	String normal_Yn = "N";
	StringBuffer tempNormCritStr = new StringBuffer();
	//String enctr_id = "";
	String normalrange = "";
	String criticalrange = "";
	String Specimen_num = "";  //6030
	String categoryNum = "";//6030
	String Specimen_num1 =""; //6030
	String Specimen_num2 ="";//6030
	String specimen_type="";	
	String ext_image_upld_id=""; //TFS14631
	String ext_img_file_locn = "";	//TFS14631		
	int image_count	=0; //TFS14631
	String out_event_code=""; //TFS14631
	String modified_date_YN = "";//24094
	String Normal_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NormalRange.label","ca_labels");
	String Critical_Range = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels");

	try
	{
		nIndex =1;

		pstmt = con.prepareStatement(sqlData.toString());
		
		//PER0409 - start
		pstmt.setString(nIndex++,locale);
		pstmt.setString(nIndex++,locale);
		pstmt.setString(nIndex++,locale);
		//pstmt.setString(nIndex++,strGraphOrder);//IN052645
		//PER0409 - end		
		if (!strFlowSheetId.equals(""))
		{
			pstmt.setString(nIndex++,strFlowSheetId);
		}
		pstmt.setString(nIndex++,strPatientId);
		if(!strHistRecType.equals(""))
		{
			pstmt.setString(nIndex++,strHistRecType);
		}
		if(!strEventClass.equals(""))
		{
			pstmt.setString(nIndex++,strEventClass);
		}
		if(!strEventGroup.equals(""))
		{
			pstmt.setString(nIndex++,strEventGroup);
		}
		if(!strEventCode.equals(""))
		{
			pstmt.setString(nIndex++,strEventCode);
		}

		if(!temp_Event_Date.equals(""))
		{
			pstmt.setString(nIndex++,temp_Event_Date);
			pstmt.setString(nIndex++,temp_Event_Date);
		}

		if(!strFacilityId.equals(""))
		{
			pstmt.setString(nIndex++,strFacilityId);
		}

		if(!strEncounterId.equals(""))
		{
			pstmt.setString(nIndex++,strEncounterId);
		}

		if(!strEpisodeType.equals("") )
		{
			if(strEpisodeType.equals("I"))
				pstmt.setString(nIndex++,"IP");
			else if(strEpisodeType.equals("O"))
				pstmt.setString(nIndex++,"OP");
			else if(strEpisodeType.equals("D"))
				pstmt.setString(nIndex++,"DC");
			else if(strEpisodeType.equals("E"))
				pstmt.setString(nIndex++,"EM");
			else if(strEpisodeType.equals("X"))
				pstmt.setString(nIndex++,"XT");
		}

		rs = pstmt.executeQuery();

		while(rs.next())
		{
			tempNormCritStr.setLength(0);
			dummyDate = rs.getString("dummydate") == null ? "" : rs.getString("dummydate");
			eventDateTime = rs.getString("event_date_time") == null ? "" : rs.getString("event_date_time");
			sortEventDateTime = rs.getString("sort_event_date_time") == null ? "" : rs.getString("sort_event_date_time");
			histRecType = rs.getString("hist_rec_type") == null ? "" : rs.getString("hist_rec_type");
			histRecTypeDesc = rs.getString("hist_rec_type_desc") == null ? "" : rs.getString("hist_rec_type_desc");
			eventClass = rs.getString("eve_class") == null ? "" : rs.getString("eve_class");
			eventClassDesc = rs.getString("event_class_desc") == null ? "" : rs.getString("event_class_desc");
			eventGroup = rs.getString("event_group") == null ? "" : rs.getString("event_group");
			eventGroupDesc = rs.getString("event_group_desc") == null ? "" : rs.getString("event_group_desc");
			eventCode = rs.getString("eve_code") == null ? "" : rs.getString("eve_code");
			eventDesc = rs.getString("event_desc") == null ? "" : rs.getString("event_desc");
			accessionNum = rs.getString("acc_num") == null ? "" : rs.getString("acc_num");
			sysID = rs.getString("sys_id") == null ? "" : rs.getString("sys_id");
			sysEventCode = rs.getString("sys_eve_code") == null ? "" : rs.getString("sys_eve_code");
			histDataType = rs.getString("hist_data_type") == null ? "" : rs.getString("hist_data_type");
			/*resultNum = rs.getString("RESULT_NUM") == null ? "" : rs.getString("RESULT_NUM");//Menaka for IN:028353
			resultNum = resultNum.trim();*/
			String results=rs.getString("RESULT_NUM")==null?"":rs.getString("RESULT_NUM");
			if(!results.equals("")){
				BigDecimal rn =rs.getBigDecimal("RESULT_NUM");
				if(rn!=null)
					resultNum=rn.toString();
				else
					resultNum=""; 
			}
			else
				resultNum="";
			resultNumUOM = rs.getString("uom") == null ? "" : rs.getString("uom");
			resultStr = rs.getString("res_str") == null ? "" : rs.getString("res_str");
			normIndicator = rs.getString("norm_ind") == null ? "" : rs.getString("norm_ind");
			normalLow = rs.getString("normal_low") == null ? "" : rs.getString("normal_low");
			normalLow = normalLow.trim();
			normalHigh = rs.getString("normal_high") == null ? "" : rs.getString("normal_high");
			normalHigh = normalHigh.trim();
			criticalLow = rs.getString("critical_low") == null ?  "" : rs.getString("critical_low");
			criticalLow = criticalLow.trim();
			criticalHigh = rs.getString("critical_high") == null ? "" : rs.getString("critical_high");
			criticalHigh = criticalHigh.trim();
			extImgID = rs.getString("ext_img_id") == null ? "" : rs.getString("ext_img_id");
			extApplID = rs.getString("ext_appl_id") == null ? "" : rs.getString("ext_appl_id");
			toolTip = rs.getString("GetTooltip") == null ? "" : rs.getString("GetTooltip");
			performed_by = rs.getString("performed_by") == null ? "" : rs.getString("performed_by");
			enctr_id = rs.getString("encounter_ID") == null ? "0" : rs.getString("encounter_ID");
			normalcy_str = rs.getString("normalcy_str") == null ? "" : rs.getString("normalcy_str");
			fac_id = rs.getString("facility_id") == null ? "0" : rs.getString("facility_id");//Menaka
			Specimen_num = rs.getString("Specimen_num") == null ? "" : rs.getString("Specimen_num");//6030
			categoryNum = rs.getString("CATEGORY_NUMBER") == null ? "" : rs.getString("CATEGORY_NUMBER");//6030
			specimen_type=rs.getString("specimen_type") == null ? "" : rs.getString("specimen_type");//6030
			//TFS14631 Start.
			ext_image_upld_id = rs.getString("EXT_IMAGE_UPLD_ID") == null ? "" : rs.getString("EXT_IMAGE_UPLD_ID");	
			modified_date_YN = rs.getString("modifiedyn") == null ? "" : rs.getString("modifiedyn");//24094
	
			if(!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
				pstmtImgView = con.prepareStatement("select EXT_IMAGE_FILE_LOCN_PARAM from CR_EXT_IMAGE_UPLD where EXT_IMAGE_UPLD_ID = ?"); 
				pstmtImgView.setString(1,ext_image_upld_id);
				resImgView = pstmtImgView.executeQuery();
				while(resImgView.next())
				{
					ext_img_file_locn = resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM") == null ? "" : resImgView.getString("EXT_IMAGE_FILE_LOCN_PARAM");
				}				
				String perfFacilityId = "";
				pstmtPerFacId = con.prepareStatement("select  distinct b.performing_facility_id from or_order_line a,or_order b where a.order_id = b.order_id and a.accession_num = ?"); 
				pstmtPerFacId.setString(1,extImgID);
				rsetPerFacId = pstmtPerFacId.executeQuery();
				if(rsetPerFacId.next()){
					perfFacilityId = rsetPerFacId.getString("PERFORMING_FACILITY_ID") == null ? "":  rsetPerFacId.getString("PERFORMING_FACILITY_ID");
				}				
				if(perfFacilityId.equals("") || perfFacilityId == null){
					perfFacilityId = manageEmailBean.getOrderIdFromSpecimen(extImgID);
				}				
				cs = con.prepareCall( "{ call rl_image_count(?,?,?,?,?,?)}" );
				cs.setString(1,sysEventCode);
				cs.setString(2,accessionNum);
				cs.setString(3,eventCode);
				cs.setString(4,strPatientId);
				cs.registerOutParameter( 5,  java.sql.Types.VARCHAR ) ;
				cs.registerOutParameter( 6,  java.sql.Types.INTEGER ) ;
				cs.execute() ;
				out_event_code	= cs.getString( 5 ) ;
				image_count	= cs.getInt( 6 ) ;
				
				ext_img_file_locn = ext_img_file_locn.replace("~specNum#",extImgID).replace("~test#",out_event_code).replace("~secCode#","A").replace("~called_from#","RL_REVIEW").replace("~facility_id#",fac_id).replace("~user_id#",login_user).replace("~language_id#",locale); 
				if(resImgView  != null) resImgView.close();
				if(pstmtImgView != null) pstmtImgView.close();	
				if(rsetPerFacId  != null) rsetPerFacId.close();
				if(pstmtPerFacId  != null) pstmtPerFacId.close();				 
			}	
			//TFS14631 End.			
			
			if(!normalLow.equals("") && !normalHigh.equals(""))
				normalrange = Normal_Range + " : " + normalLow + " - " + normalHigh + " " + resultNumUOM;
			else if(!normalLow.equals("") && normalHigh.equals(""))
				normalrange = Normal_Range + " : (>=" + normalLow + " " + resultNumUOM + ")";
			else if(normalLow.equals("") && !normalHigh.equals(""))
				normalrange = Normal_Range + " : (<=" + normalHigh + " " + resultNumUOM + ")";
			else
				normalrange = "";
		
			if(!criticalLow.equals("") && !criticalHigh.equals(""))
			{
				criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+") & "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
			}
			else if(!criticalLow.equals("") && criticalHigh.equals(""))
			{
				criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Low.label","common_labels")+"(<"+ criticalLow + " " + resultNumUOM+")" ;
			}
			else if(criticalLow.equals("") && !criticalHigh.equals(""))
			{
				criticalrange = Critical_Range + " : " +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.High.label","common_labels")+"(>" + criticalHigh + " " + resultNumUOM+")" ;
			}
			else
				criticalrange = "";
						
			if(!normalrange.equals("") && !criticalrange.equals(""))
				tempNormCritStr.append(normalrange+"<br> "+criticalrange);
			else if(!normalrange.equals(""))
				tempNormCritStr.append(normalrange);
			else if(!criticalrange.equals(""))
				tempNormCritStr.append(criticalrange);
			else
				tempNormCritStr.append("");

			if(!performed_by.equals(""))
			{
				if(!(tempNormCritStr.toString()).equals(""))
					tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Performed.label","common_labels")+" "+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels")+" : " + performed_by );
			}
			if("LBIN".equals(histRecType) && sysID.equals("LB"))
			{
		    	Specimen_num2 = extractSpecimenNumber(accessionNum,"#","@");//IN071106
		    	tempNormCritStr.append("<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenNo.label","or_labels")+" : " + Specimen_num2+"<br>"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.CategoryNo.label","or_labels")+" : " + categoryNum+"<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SpecimenType.label","or_labels")+" : " + specimen_type);
				
		    }
		toolTip_ind = tempNormCritStr.toString();

		splEventDesc = rs.getString("sp_event_desc") == null ? "" : rs.getString("sp_event_desc");
		quickTextCount = rs.getString("QUICK_TEXT_COUNT") == null ? "" : rs.getString("QUICK_TEXT_COUNT");
		deltaFailInd = rs.getString("delta_fail_ind") == null ? "" : rs.getString("delta_fail_ind");
		colorCellInd = rs.getString("COLOR_CELL_IND") == null ? "" : rs.getString("COLOR_CELL_IND");
		descCellInd = rs.getString("DESC_CELL_IND") == null ? "" : rs.getString("DESC_CELL_IND");
		strStatus = rs.getString("stat") == null ? "" : rs.getString("stat");
		if(strNormalcyInd.equals("I") || legend_type.equals("S"))
			colorCellInd = rs.getString("SYMBOL_LEGEND_IND") == null ? "" : rs.getString("SYMBOL_LEGEND_IND");
		textCount = rs.getString("text_count") == null ? "" : rs.getString("text_count");

		if(histDataType.equals("NUM"))
		{
			if(!resultNum.equals(""))
			{
				if(colorCellInd.equals("NONE"))
				{
					if(normIndicator.equals("."))
						normal_Yn = "Y";
					else if(!normalLow.equals("") && !normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if ((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)) )
							{
								normal_Yn = "Y";
							}
							else
								normal_Yn = "N";
						}
						else
							normal_Yn = "N";
					}
					else if(!normalLow.equals("") && normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if (Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
							{
								normal_Yn = "Y";
							}
							else
								normal_Yn = "N";
						}
						else
							normal_Yn = "N";
					}
					else if(normalLow.equals("") && !normalHigh.equals(""))
					{
						if(Float.parseFloat(resultNum) > 0)
						{
							if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
							{
								normal_Yn = "Y";
							}
							else
								normal_Yn = "N";
						}
						else
							normal_Yn = "N";
					}
					else
						normal_Yn = "N";
				}
				else
					normal_Yn = "N";
			}
		}
		else if(normIndicator.equals("."))
			normal_Yn = "Y";
		else
			normal_Yn = "N";
		
		if(rs.getString("RESULT_NUM_PREFIX") != null && !(rs.getString("RESULT_NUM_PREFIX")).equals(""))
				resultNum = rs.getString("RESULT_NUM_PREFIX") + resultNum;
			
		if(dateList.contains(eventDateTime))
		{
			tempSessionMap.put("eventDateTime"+tempCnt,eventDateTime);
			tempSessionMap.put("sortEventDateTime"+tempCnt,sortEventDateTime);
			tempSessionMap.put("dummyDate"+tempCnt,dummyDate);
			tempSessionMap.put("histRecType"+tempCnt,histRecType);
			tempSessionMap.put("histRecTypeDesc"+tempCnt,histRecTypeDesc);
			tempSessionMap.put("eventClass"+tempCnt,eventClass);
			tempSessionMap.put("eventClassDesc"+tempCnt,eventClassDesc);
			tempSessionMap.put("eventGroup"+tempCnt,eventGroup);
			tempSessionMap.put("eventGroupDesc"+tempCnt,eventGroupDesc);
			tempSessionMap.put("eventCode"+tempCnt,eventCode);
			tempSessionMap.put("eventDesc"+tempCnt,eventDesc);
			tempSessionMap.put("accessionNum"+tempCnt,accessionNum);
			tempSessionMap.put("sysID"+tempCnt,sysID);
			tempSessionMap.put("sysEventCode"+tempCnt,sysEventCode);
			tempSessionMap.put("histDataType"+tempCnt,histDataType);
			tempSessionMap.put("resultNum"+tempCnt,resultNum);
			tempSessionMap.put("resultNumUOM"+tempCnt,resultNumUOM);
			tempSessionMap.put("resultStr"+tempCnt,resultStr);
			tempSessionMap.put("normIndicator"+tempCnt,normIndicator);
			tempSessionMap.put("normalLow"+tempCnt,normalLow);
			tempSessionMap.put("normalHigh"+tempCnt,normalHigh);
			tempSessionMap.put("criticalLow"+tempCnt,criticalLow);
			tempSessionMap.put("criticalHigh"+tempCnt,criticalHigh);
			tempSessionMap.put("extImgID"+tempCnt,extImgID);
			tempSessionMap.put("extApplID"+tempCnt,extApplID);
			tempSessionMap.put("toolTip"+tempCnt,toolTip);
			tempSessionMap.put("toolTip_ind"+tempCnt,toolTip_ind);
			tempSessionMap.put("splEventDesc"+tempCnt,splEventDesc);
			tempSessionMap.put("quickTextCount"+tempCnt,quickTextCount);
			tempSessionMap.put("deltaFailInd"+tempCnt,deltaFailInd);
			tempSessionMap.put("colorCellInd"+tempCnt,colorCellInd);
			tempSessionMap.put("descCellInd"+tempCnt,descCellInd);
			tempSessionMap.put("strStatus"+tempCnt,strStatus);	
			tempSessionMap.put("textCount"+tempCnt,textCount);	
			tempSessionMap.put("normal_Yn"+tempCnt,normal_Yn);	
			tempSessionMap.put("enctr_id"+tempCnt,enctr_id);	
			tempSessionMap.put("normalcy_str"+tempCnt,normalcy_str);
			tempSessionMap.put("fac_id"+tempCnt,fac_id);//Menaka			
			tempSessionMap.put("ext_image_upld_id"+tempCnt,ext_image_upld_id);  //TFS14631
			tempSessionMap.put("ext_img_file_locn"+tempCnt,ext_img_file_locn);  //TFS14631
			tempSessionMap.put("image_count"+tempCnt,image_count);  //TFS14631
			tempSessionMap.put("modified_date_YN"+tempCnt,modified_date_YN);//24094
			tempCnt++;
		}
	}//end of while

	int k=0;
	int numOfCols = 0;
	int tempK = 0;	
	String tempEventDate = "";
	String tempReturnString = "";
	String tempHistRecType = "";
	String tempEventClass = "";
	String tempEventGroup = "";
	String tempEventCode = "";
	String tempDisplayEventCode = "";
	String tempDisplayEventClass = "";
	String tempDisplayEventGroup = "";
	String tempDisplayHistRecType = "";
	String tempResultNum = "";
	String tempEventDateTimeForGraf = "";
	StringBuffer dataBuffer = new StringBuffer();
	
	for(k=0;k<tempCnt;k++)
	{
		tempEventDate = (String) tempSessionMap.get("eventDateTime"+k);
		histRecTypeDesc = (String)tempSessionMap.get("histRecTypeDesc"+k);
		eventClassDesc = (String)tempSessionMap.get("eventClassDesc"+k);
		eventGroupDesc = (String)tempSessionMap.get("eventGroupDesc"+k);
		eventCode = (String)tempSessionMap.get("eventCode"+k);
		eventDesc = (String)tempSessionMap.get("eventDesc"+k);
		histRecType = (String)tempSessionMap.get("histRecType"+k);
		eventClass = (String)tempSessionMap.get("eventClass"+k);
		eventGroup = (String)tempSessionMap.get("eventGroup"+k);
		histDataType = (String)tempSessionMap.get("histDataType"+k);
		resultNumUOM = (String)tempSessionMap.get("resultNumUOM"+k);
		dummyDate = (String)tempSessionMap.get("dummyDate"+k);
		eventDateTime = (String)tempSessionMap.get("eventDateTime"+k);		
		sortEventDateTime = (String)tempSessionMap.get("sortEventDateTime"+k);
		accessionNum = (String)tempSessionMap.get("accessionNum"+k);
		sysID = (String)tempSessionMap.get("sysID"+k);
		sysEventCode = (String)tempSessionMap.get("sysEventCode"+k);
		resultNum = (String)tempSessionMap.get("resultNum"+k);
		resultStr = (String)tempSessionMap.get("resultStr"+k);
		normIndicator = (String)tempSessionMap.get("normIndicator"+k);
		extImgID = (String)tempSessionMap.get("extImgID"+k);
		extApplID = (String)tempSessionMap.get("extApplID"+k);
		toolTip = (String)tempSessionMap.get("toolTip"+k);
		toolTip_ind = (String)tempSessionMap.get("toolTip_ind"+k);
		quickTextCount = (String)tempSessionMap.get("quickTextCount"+k);
		deltaFailInd = (String)tempSessionMap.get("deltaFailInd"+k);
		colorCellInd = (String)tempSessionMap.get("colorCellInd"+k);
		descCellInd = (String)tempSessionMap.get("descCellInd"+k);
		textCount = (String)tempSessionMap.get("textCount"+k);
		normal_Yn = (String)tempSessionMap.get("normal_Yn"+k);
		enctr_id = (String)tempSessionMap.get("enctr_id"+k);
		strStatus = (String)tempSessionMap.get("strStatus"+k);
		normalcy_str = (String)tempSessionMap.get("normalcy_str"+k);
		fac_id = (String)tempSessionMap.get("fac_id"+k);//Menaka
		ext_image_upld_id = (String)tempSessionMap.get("ext_image_upld_id"+k);  //TFS14631
		ext_img_file_locn = (String)tempSessionMap.get("ext_img_file_locn"+k);  //TFS14631
		image_count		=(Integer)tempSessionMap.get("image_count"+k); //TFS14631
		modified_date_YN = (String)tempSessionMap.get("modified_date_YN"+k);//24094
		int tempNumOfCols = 0;	
		String tempDispString = "";

		if(tempEventDate.equals((String)dateList.get(numOfCols)))
		{
			tempNumOfCols = numOfCols;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+1)))
		{
			tempNumOfCols = numOfCols+1;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+2)))
		{
			tempNumOfCols = numOfCols+2;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+3)))
		{
			tempNumOfCols = numOfCols+3;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+4)))
		{
			tempNumOfCols = numOfCols+4;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+5)))
		{
			tempNumOfCols = numOfCols+5;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+6)))
		{
			tempNumOfCols = numOfCols+6;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+7)))
		{
			tempNumOfCols = numOfCols+7;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+8)))
		{
			tempNumOfCols = numOfCols+8;
		}
		else if(tempEventDate.equals((String)dateList.get(numOfCols+9)))
		{
			tempNumOfCols = numOfCols+9;
		}

		tempAdditional = resultStr;

		if(histDataType.equals("NUM")) tempValue = resultNum;
		else if(histDataType.equals("STR")) tempValue = resultStr;
		else if(histDataType.equals("TXT") || histDataType.equals("IMG") || histDataType.equals("HTM")) 
		tempValue = "";

		if(k == 0)
		{
			prevK = k;
		}
		else if(tempDisplayEventCode.equals(eventCode) && tempDisplayEventGroup.equals(eventGroup) && tempDisplayEventClass.equals(eventClass) && tempDisplayHistRecType.equals(histRecType) )
		{
			 prevK = prevK+1;
		}		
	
		//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str);//Menaka
		//IN074077 Start.
		//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id);
		//TFS14631 Start.
		//tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id,strPatientId);
		tempTRMap = drawTD(histDataType, resultNum,resultStr, extApplID, tempNumOfCols, k, histRecType, sysID, accessionNum, sysEventCode, extImgID, toolTip, toolTip_ind, deltaFailInd, tempAdditional, tempValue, eventDateTime, quickTextCount, strStatus, textCount, called_from, strNormalcyInd, colorCellInd, descCellInd, normIndicator, eventGroup, eventClass, eventCode, tempDisplayEventCode, tempDisplayEventClass, tempDisplayEventGroup, tempDisplayHistRecType, prevK, keyList, eventDesc, sortEventDateTime, normal_Yn, legend_type,enctr_id,normalcy_str,fac_id,strPatientId,ext_image_upld_id, ext_img_file_locn ,image_count, modified_date_YN);//24094
		//TFS14631 End.
		//IN074077 end.
		tempDisplayEventCode = eventCode;
		tempDisplayEventClass = eventClass;
		tempDisplayEventGroup = eventGroup;
		tempDisplayHistRecType = histRecType;

		tempK = prevK;

		tempReturnString = (String) tempTRMap.get("tempString"+tempK+"Map"+tempNumOfCols);
		tempHistRecType = (String) tempTRMap.get("histRecType"+tempK);
		tempEventClass = (String) tempTRMap.get("eventClass"+tempK);
		tempEventGroup = (String) tempTRMap.get("eventGroup"+tempK);
		tempEventCode = (String) tempTRMap.get("eventCode"+tempK);
		tempResultNum = (String) tempTRMap.get("resultNum"+tempK+"Map"+tempNumOfCols);
		tempEventDateTimeForGraf = (String) tempTRMap.get("eventDateTime"+tempK+"Map"+tempNumOfCols);
		tempDispString = "map"+tempK+"Key"+tempNumOfCols;

		tempTDMap.put(tempDispString,tempReturnString);
		tempTDMap.put("histRecType"+tempK,tempHistRecType);
		tempTDMap.put("eventClass"+tempK,tempEventClass);
		tempTDMap.put("eventGroup"+tempK,tempEventGroup);
		tempTDMap.put("eventCode"+tempK,tempEventCode);
		tempTDMap.put("tempResultNum"+tempDispString,tempResultNum);
		tempTDMap.put("tempEventDateTimeForGraf"+tempDispString,tempEventDateTimeForGraf);
	}//end of for

	int m=0;
	int n=0;

	String tempRetString = "";
	String tempResNumberForGraf = "";
	String tempDateTimeForGraf = "";
	
	String displayStr = "";
	dataBuffer = new StringBuffer();
	StringBuffer tempRowString = new StringBuffer();

	for(m=0;m<=prevK;m++)
	{
		if(m % 2 ==0)
			classValue = "CACHARTQRYEVEN";
		else
			classValue = "CACHARTQRYEVEN";

		tempRowString.setLength(0);

		tempHistRecType = (String) tempTDMap.get("histRecType"+m) == null ? "&nbsp;" : (String) tempTDMap.get("histRecType"+m);
		tempEventClass = (String) tempTDMap.get("eventClass"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventClass"+m);
		tempEventGroup = (String) tempTDMap.get("eventGroup"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventGroup"+m);
		tempEventCode = (String) tempTDMap.get("eventCode"+m) == null ? "&nbsp;" : (String) tempTDMap.get("eventCode"+m);

		if(!prevHistRecType.equals(tempHistRecType))
		{	
			tempRowString.append("<TR>");
			tempRowString.append("<TD  id='sepID"+m+"' class='CAFLOWSHEETLEVEL1'>&nbsp;</TD>");
			tempRowString.append("</TR>");
		    tempRowString.append("<TR>");
			tempRowString.append("<TD id='sepID"+m+"' class='CAFLOWSHEETLEVEL2'>&nbsp;</TD>");
			tempRowString.append("</TR>");
			if(!tempEventGroup.equals("*ALL"))
			{
				tempRowString.append("<TR>");
				tempRowString.append("<TD id='sepID"+m+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
				tempRowString.append("</TR>");
			}
			prevHistRecType = tempHistRecType;
			prevEventClass = tempEventClass;
			prevEventGroup = tempEventGroup;
			prevEventCode = tempEventCode;
			dataBuffer.append(tempRowString.toString());
		}
		if(!prevEventClass.equals(tempEventClass))
		{
			tempRowString.append("<TR>");
			tempRowString.append("<TD id='sepID"+m+"' colspan='"+dateList.size()+"' class='CAFLOWSHEETLEVEL2'>&nbsp;</TD>");
			tempRowString.append("</TR>");

			if(!tempEventGroup.equals("*ALL"))//event group is empty
			{
				tempRowString.append("<TR>");
				tempRowString.append("<TD  id='sepID"+m+"' colspan='"+dateList.size()+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
				tempRowString.append("</TR>");
			}
			prevEventClass = tempEventClass;
			prevEventGroup = tempEventGroup;
			prevEventCode = tempEventCode;
			dataBuffer.append(tempRowString.toString());
		}

		if(!prevEventGroup.equals(tempEventGroup))
		{
			if(!tempEventGroup.equals("*ALL"))
			{
				tempRowString.append("<TR>");
				tempRowString.append("<TD id='sepID"+m+"' colspan='"+dateList.size()+"' class='CAFLOWSHEETLEVEL3'>&nbsp;</TD>");
				tempRowString.append("</TR>");
			}
			prevEventGroup = tempEventGroup;
			prevEventCode = tempEventCode;
			dataBuffer.append(tempRowString.toString());
		}
		dataBuffer.append("<tr id='trIDGraph"+m+"'>");

		for(n=0;n<dateList.size();n++)
		{
			displayStr = "map"+m+"Key"+n;
			tempRetString = (String) tempTDMap.get(displayStr);
			tempResNumberForGraf = (String) tempTDMap.get("tempResultNum"+displayStr);
			tempDateTimeForGraf = (String) tempTDMap.get("tempEventDateTimeForGraf"+displayStr);

			if(tempResNumberForGraf == null && tempDateTimeForGraf == null)
			{
				tempResNumberForGraf = " ";
				tempDateTimeForGraf = " ";
			}

			if(tempRetString == null)
			{
				dataBuffer.append("<td id='visibility"+m+"ID"+n+"' class = 'gridDataChart'>&nbsp;</td>");
			}
			else
			{
				dataBuffer.append(tempRetString);
			}
			if(!tempDateTimeForGraf.equals(" ") && !tempResNumberForGraf.equals(" "))
				dataBuffer.append("<td id='duplicate"+m+"ID"+n+"' style='display:none' width='10%'>&nbsp;</td><input type='hidden' name='hidden"+m+"Values"+n+"' id='hidden"+m+"Values"+n+"' value='"+tempDateTimeForGraf+"^%"+tempResNumberForGraf+"'>");
		}
			dataBuffer.append("</tr>");
	}//end of for-display
	out.println(dataBuffer.toString());
	}//end of try - 2
	catch(Exception ee)
	{
		//out.println("Exception in try - 2 of FlowSheetMoreResults.jsp -"+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
%>		
	<TR>
<%
	for(i=0;i<dateListSize;i++)
	{
%>
		<TH nowrap style='visibility:hidden' id='visIDup<%=i%>'><%=dateList.get(i)%>&nbsp;</TH> 
<%
	}
%>
	</TR>
	</table>
		<input type='hidden' name='txtFlagComments' id='txtFlagComments' value="N">
		<input type='hidden' name='txtFlagQuickText' id='txtFlagQuickText' value="N">
		<input type='hidden' name='totRows' id='totRows' value="<%=prevK+1%>">
		<input type='hidden' name='totCols' id='totCols' value="<%=dateList.size()%>">
		<input type='hidden' name='finalTotCols' id='finalTotCols' value="<%=dateList.size()%>">
		<input type='hidden' name='hiddenColumns' id='hiddenColumns' value="">
		<input type='hidden' name='lastDateTime' id='lastDateTime' value=''>
		<input type='hidden' name='firstDateTime' id='firstDateTime' value=''>
		<input type='hidden' name='queryStringForComments' id='queryStringForComments' value="">
		<input type='hidden' name='graphorder' id='graphorder' value="">
		<input type='hidden' name='flowsheetCompId' id='flowsheetCompId' value="">
		<input type='hidden' name='errorEvent' id='errorEvent' value="">
		<input type='hidden' name='graphValuesOnChk' id='graphValuesOnChk' value=''>
		<input type='hidden' name='viewConfRes' id='viewConfRes' value=''>
		<input type='hidden' name='allDatesForGraph' id='allDatesForGraph' value='<%=allDatesForGraph.toString()%>'>
		<input type='hidden' name='noOfGroups' id='noOfGroups' value=''>
		<input type='hidden' name='patient_id' id='patient_id' value='<%=strPatientId%>'>
		<input type='hidden' name='encounter_id' id='encounter_id' value='<%=strEncounterId%>'>
		<input type='hidden' name='enc_id' id='enc_id' value='<%=strEncId%>'>
<%	
}
catch(Exception ee1)
{
	ee1.printStackTrace();
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>
	</form>
	</body>
	<div name='tooltiplayer' id='tooltiplayer'  style='position:absolute; width:30%; visibility:hidden;' bgcolor='yellow'>
	<table id='tooltiptable' cellpadding=0 cellspacing=0 border='0'  width='100%' height='100%' align='center'>
		<tr>
			<td width='100%' class='gridTooltipData' id='t' nowrap></td>
			</td>
		</tr>
	</table>
	</div>
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

	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type, String enctr_id, String normalcy_str)//Menaka
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type, String enctr_id, String normalcy_str, String fac_id)//IN074077
	//TFS14631 Start.
	//HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type, String enctr_id, String normalcy_str, String fac_id, String strPatientId) //IN074077
	HashMap drawTD(String histDataType, String resultNum, String resultStr, String extApplID, int columnNumber, int rowNumber, String histRecType, String sysID, String accessionNum, String sysEventCode, String extImgID, String toolTip, String toolTip_ind, String deltaFailInd, String tempAdditional, String tempValue, String eventDateTime, String quickTextCount, String strStatus, String textCount, String called_from, String strNormalcyInd, String colorCellInd, String descCellInd, String normIndicator, String eventGroup, String eventClass, String eventCode, String tempDisplayEventCode, String tempDisplayEventClass, String tempDisplayEventGroup, String tempDisplayHistRecType, int prevK,ArrayList keyList, String eventDesc, String sortEventDateTime,  String normal_Yn, String legend_type, String enctr_id, String normalcy_str, String fac_id, String strPatientId,String ext_image_upld_id, String ext_img_file_locn ,int image_count, String modified_date_YN)//rpr
	//TFS14631 End.
	{
		int i = prevK;
		int j = columnNumber;

		String tempToolTip = toolTip.replace('\'',' ');

		String tempString = "";
		String classValue = "";
		String tempStrValue = "";
		String tempOnMouseOver = "";
		String displayStyle = "gridDataChart";
		HashMap returnMap = new HashMap();

		classValue = "CACHARTQRYEVEN";

		if(keyList.contains(enctr_id+"`"+histRecType+"`"+sysID+"`"+accessionNum+"`"+sysEventCode))
			displayStyle = "gridDataChart";
		else
			displayStyle = "gridDataChart";

		if(histDataType.equals("NUM"))
		{
			tempValue =tempValue+"<input type='hidden' name='resultNum' id='resultNum' value='"+tempValue+"'>";
			if(!tempAdditional.equals("")) //if there is any STR
			{
				tempAdditional=replaceSpecialChar(tempAdditional);
				if(tempAdditional.length() > 10)
					tempValue =tempValue+ "&nbsp;" + "<a  href='javascript:ShowComments(\""+tempAdditional+"\")'><font size='1' color='black'><i>"+tempAdditional.substring(0,9)+"...</i></a>";
				else
					tempValue =tempValue+"&nbsp;<i>" +tempAdditional+"</i>";
			}
			if(!textCount.equals("0"))//if there is any TXT
			{
				//tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' style='display:inline' onClick=\"return getText1('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";//IN032794
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' src='../../eCA/images/flow_text.gif' style='display:inline' onClick=\"return getText1('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";//IN032794//Menaka
			}
		}
		else if(histDataType.equals("TXT") || histDataType.equals("HTM"))
		{
			if(!textCount.equals("0"))
			{
				//tempValue = "<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText1('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";//IN032794
				tempValue = "<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText1('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";//IN032794
				//24094 starts
				 if(modified_date_YN.equals("Y")){
				 tempValue = tempValue+ "<img src='../../eCA/images/modifiedresult.png'/>";
			   
				}else{
					 tempValue = tempValue+ "";
					  
				}
				//24094 ends
			}
		}
		else if(histDataType.equals("STR"))
		{
			if(tempValue.length() > 15)
			{
				tempStrValue = tempValue.substring(0,14);
				tempValue = replaceSpecialChar(tempValue);
				tempValue = "<a  href=\"javaScript:ShowComments('"+tempValue+"')\"><font size='1' color='black'>"+tempStrValue+"...</a><br>";
			}
			if(!normalcy_str.equals(""))
			{
				tempValue = tempValue + " <font color=blue>( Normal Value : " + normalcy_str + " )</font>";
			}
			if(!textCount.equals("0"))//in case of STR if any TXT is there
			{
				//tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText1('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"')\">";//IN032794
				tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis"+i+"ID"+j+"' style='display:inline' src='../../eCA/images/flow_text.gif' onClick=\"return getText1('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";//IN032794
			}
		}

		if(!tempValue.equals(""))
		{
			if(!called_from.equals("OR"))
			{
				if(quickTextCount.equals("0"))
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' style='display:none' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
				else
				{
					tempValue =tempValue+ "&nbsp;"+"<img title='Click to view the comments' name='imagevisibility"+i+"ID"+j+"' src='../../eCA/images/II_comment.gif' onClick=\" return enterQuickText('"+eventDateTime+"','"+histRecType+"','"+sysID+"',escape('"+accessionNum+"'),'"+sysEventCode+"','S')\">";
				}
			}
			if(!called_from.equals("OR"))
			{
				if(strStatus.equals("E"))
				{
					 tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"'" ;
				}
				else if(strNormalcyInd.equals("I") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;

					tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center'";	
				}
				else if(strNormalcyInd.equals("C") && !strNormalcyInd.equals(""))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					tempString = tempString + "<TD class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' style='cursor:pointer' align='center'";
				}
				else
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
			}
			else
			{
				if(strStatus.equals("E"))
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
				else if(legend_type.equals("S"))
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
					
					if(!colorCellInd.equals("NONE"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					else if(normal_Yn.equals("Y"))
						tempValue = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
				}
				else if(legend_type.equals("C"))
				{
					if(!colorCellInd.equals("NONE"))
					{
						tempValue = "<font  style='background-color:"+colorCellInd+";size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					else if(normal_Yn.equals("Y"))
					{
						tempValue = "<font  style='background-color:#32CD32;size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" + tempValue;
					}
					
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
				else
				{
					tempString = tempString + "<TD class='"+displayStyle+"' style='cursor:pointer' align='center' id='visibility"+i+"ID"+j+"' ";
				}
			}
		}
		else
		{
			if(strStatus.equals("E"))
			{
				tempString = tempString + "<TD align='center' class='TD_BROWN' id='visibility"+i+"ID"+j+"' ";
			}
			else
			{
				tempString = tempString + "<TD align='center' class='"+displayStyle+"' id='visibility"+i+"ID"+j+"' ";				
			}

		}

		if(!tempToolTip.equals("") || !toolTip_ind.equals(""))
		{
			tempOnMouseOver="onMouseOver=\"displayToolTip('"+tempToolTip+"','"+toolTip_ind+"','"+i+"','"+j+"')\" onMouseOut =hideToolTip('"+i+"','"+j+"')";
			 tempString = tempString + tempOnMouseOver;
		}
		
		if(tempValue.equals("")) 
		{
			tempValue = "&nbsp;";
		}	
		//IN074077 Start.		
		if(!extApplID.equals(""))
		{
			if(!("DMS").equals(extApplID)) { 
				//TFS14631 Start.
				/*
				if(!("DOCUL").equals(extApplID))				
				{					
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+extImgID+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}
				else
				{
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}
				*/
				if(!("DOCUL").equals(extApplID) && (ext_image_upld_id.equals(null) || ext_image_upld_id.equals(""))){
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+extImgID+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}else if (ext_image_upld_id.equals(null) || ext_image_upld_id.equals("")){
					tempValue =tempValue+"&nbsp;"+"<img src='../../eCA/images/"+extApplID+".gif'  onClick=\"return getFile('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+extApplID+"','"+strPatientId+"')\">";
				}else if (!ext_image_upld_id.equals(null) && !ext_image_upld_id.equals("")) {
					if(image_count > 0){
						tempValue =tempValue+"&nbsp;"+"<a style='cursor:pointer;color:blue' onClick=\"viewUploadedImg('"+ext_img_file_locn+"')\"> View Image </a>";
					}
				}
				//TFS14631 End.
			} 
		} 
		//IN074077 End.
		if(strStatus.equals("P"))
			tempValue = tempValue+" <font color='red'>(Preliminary)</font>";

		if(!deltaFailInd.equals(""))
		{
			tempValue = tempValue+"<font color='red'>["+deltaFailInd+"]</font>";
		}
		if((strNormalcyInd.equals("I") || strNormalcyInd.equals("B") )&& !strNormalcyInd.equals("") && !colorCellInd.equals("NONE"))
		{
			//tempValue = tempValue+ "<font color='black'><b>["+descCellInd+"]</b></font>";
		}

		tempString = tempString + ">"+tempValue+"</TD>";

		try
		{
			returnMap.put("tempString"+i+"Map"+j,tempString);
			returnMap.put("histRecType"+i,histRecType);
			returnMap.put("eventClass"+i,eventClass);
			returnMap.put("eventGroup"+i,eventGroup);
			returnMap.put("eventCode"+i,eventCode);
			returnMap.put("eventDateTime"+i+"Map"+j,eventDateTime);
			returnMap.put("resultNum"+i+"Map"+j,resultNum);
		}
		catch(Exception ee)
		{
			ee.printStackTrace();
		}
		return returnMap;
	}// end of drawTD
%>


