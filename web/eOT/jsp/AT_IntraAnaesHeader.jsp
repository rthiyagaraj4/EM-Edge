<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,eCommon.XSSRequestWrapper,eCommon.Common.*,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.util.regex.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");	
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends 
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>                    
<html>
<head>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
	<script language="JavaScript" src="../../eOT/js/Booking.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
  java.util.Properties prop = null;
  prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
  String login_user	= prop.getProperty( "login_user" );
  String locale = (String)session.getAttribute("LOCALE");
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strStatus="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strPatientClassDesc="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",chartId="",strAnaesthesiaCode="",strAnaesthesiaDesc="",strEndDateTime="",strStartDateTime="",strBMIDesc="",strEpisodeType="",strIntraopDoneYN="N",strIntraopDone_check="",intra_disable_flag="",accession_num="",current_date = "",current_time="",current_date_time	= "",asa_score_code = "";  // Added asa_score_code for crf -0021
    //Added by AnithaJ for IN024805 on 11/3/2010
  double bsaDisp = 0.0;

 String slate_user_id_disp = CommonBean.checkForNull(request.getParameter("slate_user_id")).toUpperCase();
  if(slate_user_id_disp.equals("")){
	slate_user_id_disp=	(String)session.getValue("login_user");
 }
 String strUser="";
  Statement stmt1 = null ;
  ResultSet resultSet1     = null ;
  String strAccessionNum="";
  String[] arrStartDate = null;
  String[] arrEndDate =  null;
  int tot_rec=0;
  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CUR_DATE,TO_CHAR(SYSDATE,'HH24:MI') CUR_TIME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')  CURRENT_DATE_TIME FROM DUAL";
  Statement stmt = null ;
  ResultSet resultSet			= null ;
  conn			= ConnectionManager.getConnection(request);	//Added Against Common-ICN-0031
	try{
		//conn			= ConnectionManager.getConnection(request);	//Commented Against Common-ICN-0031
		stmt				= conn.createStatement() ;
		resultSet			= stmt.executeQuery(sql_curr_date);
		while(resultSet!=null && resultSet.next()){
			current_date = resultSet.getString("CUR_DATE");
			current_time = resultSet.getString("CUR_TIME");
			current_date_time = resultSet.getString("CURRENT_DATE_TIME");

	}
	
	String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,STATUS STATUS1,ANAESTHESIA_CODE ANAESTHESIA_CODE1,ANAESTHETIST1_CODE ANAESTHETIST1_CODE1,ANAESTHETIST2_CODE ANAESTHETIST2_CODE1,TO_CHAR(END_TIME,'DD/MM/YYYY HH24:MI') END_TIME1,TO_CHAR(START_TIME,'DD/MM/YYYY HH24:MI') START_TIME1,INTRAOP_DONE_YN INTRAOP_DONE_YN1,ACCESSION_NUM ACCESSION_NUM1,ASA_SCORE_CODE ASA_SCORE_CODE1 FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";  //Added asa_score_code for crf -0021
	strAnesthesiaSrlNo=CommonBean.checkForNull(request.getParameter("anesthesia_srl_no"));
	facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,strAnesthesiaSrlNo);
	rs=pstmt.executeQuery();
	if(rs.next()){
		strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
		strHeight=CommonBean.checkForNull(rs.getString("HEIGHT1"));
		strWeight=CommonBean.checkForNull(rs.getString("WEIGHT1"));
		strBSA=CommonBean.checkForNull(rs.getString("BSA1"));
		asa_score_code=CommonBean.checkForNull(rs.getString("ASA_SCORE_CODE1")); //crf-0021
	if(!strBSA.equals(""))
	{
		bsaDisp=Double.parseDouble(strBSA);
	}
		strBMI=CommonBean.checkForNull(rs.getString("BMI1"));
		strSourceOrderId=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID1"));
		strStatus=CommonBean.checkForNull(rs.getString("STATUS1"));
		strAnaesthesiaCode=CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1"));
		strEndDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("END_TIME1"),"DMYHM","en",locale));
		strStartDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("START_TIME1"),"DMYHM","en",locale));
		strIntraopDoneYN=CommonBean.checkForNull(rs.getString("INTRAOP_DONE_YN1"));
		strAccessionNum=CommonBean.checkForNull(rs.getString("ACCESSION_NUM1"));
		arrStartDate = strStartDateTime.split(" ");
		arrEndDate   =   strEndDateTime.split(" ");
	if(strIntraopDoneYN.equalsIgnoreCase(""))
		strIntraopDoneYN="N";

	if(strIntraopDoneYN.equalsIgnoreCase("Y"))
	{
		strIntraopDone_check="checked";
		intra_disable_flag="disabled";
	}
	else
		strIntraopDone_check="";
		sql="SELECT PATIENT_CLASS PATIENT_CLASS1,ENCOUNTER_ID ENCOUNTER_ID1,EPISODE_ID EPISODE_ID1,SOURCE_TYPE SOURCE_TYPE1,SOURCE_CODE SOURCE_CODE1,ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strSourceOrderId);
		rs=pstmt.executeQuery();

	if(rs.next())
	{
		strPatientClass=CommonBean.checkForNull(rs.getString("PATIENT_CLASS1"));
		strEncounterId=CommonBean.checkForNull(rs.getString("ENCOUNTER_ID1"));
		strEpisodeId=CommonBean.checkForNull(rs.getString("EPISODE_ID1"));
		strSourceType=CommonBean.checkForNull(rs.getString("SOURCE_TYPE1"));
		strSourceCode=CommonBean.checkForNull(rs.getString("SOURCE_CODE1"));
		strSurgeonCode=CommonBean.checkForNull(rs.getString("ORD_PRACT_ID1"));
		strSurgeryDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORD_DATE_TIME1"),"DMY","en",locale));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		sql="SELECT PATIENT_NAME SHORT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  DATE_OF_BIRTH1, SEX SEX1 FROM MP_PATIENT  WHERE PATIENT_ID =?";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1,strPatientId);
		rs=pstmt.executeQuery();
	if(rs.next())
	{
		strName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
		strAge=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
		strSex=CommonBean.checkForNull(rs.getString("SEX1"));
	}
		sql="SELECT SHORT_DESC SHORT_DESC1 from AM_PATIENT_CLASS_LANG_VW where LANGUAGE_ID='"+locale+"' AND PATIENT_CLASS=?";
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strPatientClass);
		rs=pstmt.executeQuery();

	if(rs.next())
	{
		strPatientClassDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	if(!strSourceType.equals(""))
	{
		if(strSourceType.equals("W")||strSourceType.equals("N"))
		{
			sql=  "SELECT LONG_DESC SHORT_DESC1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID ='"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND  NURSING_UNIT_CODE ='"+strSourceCode+"' ";
			strReferralSource="Wards";
		}
		else if(strSourceType.equals("C"))
		{
		   sql="SELECT LONG_DESC SHORT_DESC1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'    AND CLINIC_CODE='"+strSourceCode+"' ";
			strReferralSource="Clinics";
		}
		else if(strSourceType.equals("R"))
		{
		   sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE='"+strSourceCode+"' ";
			strReferralSource="Referral";
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		pstmt=conn.prepareCall(sql);

		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strSourceDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

	sql="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW where LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strSurgeonCode);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strSurgeonName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW where PATIENT_CLASS=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strEpisodeType=CommonBean.checkForNull(rs.getString("EPISODE_TYPE1"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	
	sql="SELECT INTRA_ANAESTHESIA_CHART_ID CHART_ID FROM AT_PARAM";
	pstmt=conn.prepareCall(sql);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		chartId=CommonBean.checkForNull(rs.getString("CHART_ID"));
	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	if(strBMI.length()>0)
	{
		sql="SELECT STATUS_DESC  STATUS_DESC1 from AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";

		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strBMI);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strBMIDesc=CommonBean.checkForNull(rs.getString("STATUS_DESC1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

	if(!(strAnaesthesiaCode.equals("null")) && !(strAnaesthesiaCode.equals("")))
	{
		String sql_anaes="SELECT SHORT_DESC SHORT_DESC1  FROM AM_ANAESTHESIA_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ANAESTHESIA_CODE=? ";

		pstmt=conn.prepareCall(sql_anaes);
		pstmt.setString(1,strAnaesthesiaCode);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strAnaesthesiaDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	}

		//String sql_anaes="SELECT OPER_NUM OPER_NUM1 FROM OT_POST_OPER_HDR WHERE ORDER_ID =? ";//Commented against 58903
		String sql_anaes="SELECT OPER_NUM OPER_NUM1 FROM ot_queue WHERE ORDER_ID =? ";//Added against 58903
		
		pstmt=conn.prepareCall(sql_anaes);
		pstmt.setString(1,strSourceOrderId);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next())
		{	tot_rec++;
			accession_num=CommonBean.checkForNull(rs.getString("OPER_NUM1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		//Added below qry to fetch func_role_id associated to slate user id on 1/19/2011 by Anitha for 25928
		pstmt=conn.prepareCall("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
		pstmt.setString(1,slate_user_id_disp);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		if(rs.next()){
			strUser=CommonBean.checkForNull(rs.getString("func_role_id"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	  }
}catch(Exception ee){
	ee.printStackTrace();
	//System.err.println("Exception in IntraAnaesHeader="+ee);
}finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(resultSet!=null) resultSet.close();
		if(stmt!=null) stmt.close();
		if(resultSet1!=null) resultSet1.close();
		if(stmt1!=null) stmt1.close();
		//if(conn!=null) ConnectionManager.returnConnection(conn,request);	//Commented Against Common-ICN-0031
	}catch(Exception es){
	es.printStackTrace();
	}
}
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
<form name="RecordAnesthesiaHdrForm" id="RecordAnesthesiaHdrForm" >
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<input type="hidden" name="patient_id" id="patient_id" size='10'  value="<%=strPatientId%>" disabled>
<input type="hidden" name="patient_name" id="patient_name" size='30'  value="<%=strName%>" disabled> 
<input type="hidden"  name="sex" id="sex" size='2' value="<%=strSex%>" disabled>
<input type="hidden"  name="dob" id="dob" size='10' value="<%=strAge%>" disabled>
<input type="hidden"  name="surgeon_name" id="surgeon_name" size='27' value="<%=strSurgeonName%>" disabled>
<input type="hidden" name="surgery_date" id="surgery_date" colspan="2" size='8'  value="<%=strSurgeryDate%>" disabled>
<input type='hidden' name='encounter_id' id='encounter_id' size='13' value= "<%=strEncounterId%>" disabled>
<input type='hidden' name='patient_class_desc' id='patient_class_desc' size='15' value= "<%=strPatientClassDesc%>" disabled>
<tr>
	<td  class='Label' width="25%">
	<fmt:message key="eOT.AnaesSerialNo.Label" bundle="${ot_labels}"/>
	</td>
	
	<td  class='fields' width="25%" >
		<input type="text" name="anaes_srl_no" id="anaes_srl_no" size='10'  value="<%=strAnesthesiaSrlNo%>" disabled>
	</td>
	<td  class='Label' width="25%" >
	<fmt:message key="eOT.SourceId.Label"  bundle="${ot_labels}"/>
	</td>
	<td  class='fields' width="25%">
		<input type="text"  name="source_id" id="source_id" size='17' value="<%=strSourceOrderId%>" disabled>	
	</td>
</tr>

<tr>
	<%
		if(strAccessionNum.equals("")){
		if(tot_rec>1){
	%>
	<td  class='Label' width="25%" >
		<fmt:message key="eOT.AccessionNum.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%">
		<input type="text"  name="accession_num" id="accession_num" size='18' value="" disabled><!-- AAKH-SCF-221 -->
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callAccessionNum('<%=strSourceOrderId%>');" <%=intra_disable_flag%>>
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%}else{ %>
	<td  class='Label' width="25%" >
			<fmt:message key="eOT.AccessionNum.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" >
		<input type="text"  name="accession_num" id="accession_num" size='18' value="<%=accession_num%>" disabled><!-- AAKH-SCF-221 -->
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	
<% } 
}else{%>
	<td  class='Label' width="25%" >
	<fmt:message key="eOT.AccessionNum.Label" bundle="${ot_labels}"/>
	</td>
		<td class='fields' width="25%" >
		<input type="text"  name="accession_num" id="accession_num" size='18' value="<%=strAccessionNum%>" <%=intra_disable_flag%> disabled><!-- AAKH-SCF-221 -->
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
<%}%>

<td  class='Label' width="25%"  >
</td>
	<td class='fields' width="25%" >
	</td> 
</tr>

<tr>
	<td  class='Label' width="25%" >
	<fmt:message key="Common.weight.label" bundle="${common_labels}"/>
	</td>
	
	<td class='fields' width="25%" >
		<input type="text" name="weight" id="weight" size='4'  maxlength='6'  onKeyPress="return allowValidNumber(this,event,'3','2');" onBlur="if(this.value!=''){SPCheckPositiveNumber(this);CheckBmiPositiveNumber(this);}" value="<%=strWeight%>" <%=intra_disable_flag%> >
		(<fmt:message key="Common.Kgs.label" bundle="${common_labels}"/>)
	</td>
	<td class='Label' width="25%">
		<fmt:message key="Common.height.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="25%">
		<input type="text" name="height" id="height" size='4' maxlength='6'   onKeyPress="return allowValidNumber(this,event,'3','2');"  onBlur="if(this.value!=''){SPCheckPositiveNumber(this);CheckBmiPositiveNumber(this);}"  value="<%=strHeight%>"  <%=intra_disable_flag%> >
		(<fmt:message key="Common.Cms.label" bundle="${common_labels}"/>)
	</td>
</tr>  

<tr>	
	<td class='Label' width="25%" >
		<fmt:message key="Common.BSA.label" bundle="${common_labels}"/> 
	</td>
	<td class='fields' width="25%" >
	<!--Condition Added for IN024805 -->
	<%if(!strBSA.equals("")){%>
		<input type="text"  name="bsaDisp" id="bsaDisp" size='5' value="<%=bsaDisp%>" disabled>
		<input type="hidden"  name="bsa" id="bsa"  value="<%=strBSA%>">
	<%}
	else{%>
		<input type="hidden"  name="bsa" id="bsa" size='5' value="<%=strBSA%>" >
		<input type="text"  name="bsaDisp" id="bsaDisp"  value="<%=strBSA%>" disabled>

	<%}%>
	</td>
	<td  class='Label' width="25%"  >
		<fmt:message key="eOT.BMIDetails.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width="25%" colspan='4'>
		<input type="text"  name="bmi" id="bmi"  size='5' value="<%=strBMI%>" disabled>
		<input type="text"  name="status_desc" id="status_desc" size='18' value="<%=strBMIDesc%>" disabled>
	</td>
</tr>  
<table >
 <tr> <!-- start crf-0021 -->
     <td class='Label' width="25%"  >
	<fmt:message key="eOT.AsaScore.Label" bundle="${ot_labels}"/> 
	</td>
	<td class='fields' width="25%" >
		<input type="text"  name="asa" id="asa"  size='5' value="<%=asa_score_code%>" disabled>  
	</td>	
		 <!-- End crf-0021 -->
	
	<td align='right' width="25%">
		<a class='gridLink' href="javascript:callIntraAnesthesiaNotes('<%=login_user%>');"><fmt:message key="eOT.IntraAnaesthesia.Label" bundle="${ot_labels}"/></a> &nbsp;&nbsp;&nbsp;
		<a class='gridLink' href="javascript:callPreAnaesNotes('<%=login_user%>');"><fmt:message key="eOT.PreAnaesthesiaDetails.Label" bundle="${ot_labels}"/></a>&nbsp;&nbsp;&nbsp;
		<a class='gridLink' href="javascript:callRecordChart();"><fmt:message key="eOT.RecordChart.Label" bundle="${ot_labels}"/></a>
	</td>
	 <td class='fields' width="25%" > 
		<input type='hidden' name="intraop_done_yn" id="intraop_done_yn" value="<%=strIntraopDoneYN%>" >
	</td>  
	
<!-- <td width='20%'></td> -->
</tr>
<!-- </table> -->
</table>
<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<tr> 
	<td align='left' class='COLUMNHEADER'>
	<fmt:message key="eOT.AnaesthesiaParticulars.Label" bundle="${ot_labels}"/>
	</td>
	
</tr> 
</table>

<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">

<tr>
	<td  class='Label' width="25%"  >
	<fmt:message key="Common.Anaesthesia.label" bundle="${common_labels}"/>
	</td>
	<td class='Label' width="25%"  colspan="3">
		<input type="hidden"  name="anaesthesia_code" id="anaesthesia_code"  size='14' value="<%=strAnaesthesiaCode%>" >
		<input type="text"  name="anaesthesia_desc" id="anaesthesia_desc" size='28' onblur='if(this.value!="")callAnaesthesia1(this);' value="<%=strAnaesthesiaDesc%>" <%=intra_disable_flag%>>
		<input type="button" class="button" name="generic_search" id="generic_search" value="?" onclick="callAnaesthesia1(anaesthesia_desc);" <%=intra_disable_flag%>>
<%
//PMG2017-SS-CRF-0001-US003
try{
	//conn = ConnectionManager.getConnection(request);	//Commented Against Common-ICN-0031
	boolean isRecordAnes = false;
	isRecordAnes = CommonBean.isSiteSpecific(conn,"OT","OT_RECORD_ANESTHESIA");
	if(!isRecordAnes){
%>
	<img src='../../eCommon/images/mandatory.gif'></img>
<%
	}
	//PMG2017-SS-CRF-0001-US003
%>
	</td>
</tr>
<tr>
<td  class='Label' width="25%"  >
	<fmt:message key="eOT.AnaesthesiaStartTime.Label" bundle="${ot_labels}"/>
</td>
<%
if(!strStartDateTime.equals("")){%>
<td class='fields' width="25%">
	<input type="text"  name="start_date" id="start_date"  size='9' maxlength='10' value='<%=arrStartDate[0]%>' Onblur="isValidDate(this);" <%=intra_disable_flag%> >
	<image src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('start_date');" <%=intra_disable_flag%> >
	<!-- onBlur='checkDateFormat(this);' Modified Onblur against SKR-SCF-1285 -->
	<img src='../../eCommon/images/mandatory.gif'></img>
	<input type="text"  name="start_time" id="start_time"  size='4' maxlength='5' value='<%=arrStartDate[1]%>' onBlur='chkTimeFormat(this)' <%=intra_disable_flag%>>
</td>
<%} else if(strStartDateTime.equals("")){%>
<td class='fields' width="25%">
	<input type="text"  name="start_date" id="start_date"  size='9' maxlength='10' value='<%=strStartDateTime%>' Onblur="isValidDate(this);"<%=intra_disable_flag%> >
	<image src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('start_date');" <%=intra_disable_flag%> >
	<!-- onBlur='checkDateFormat(this);' Modified Onblur against SKR-SCF-1285 -->
	<img src='../../eCommon/images/mandatory.gif'></img>
	<input type="text"  name="start_time" id="start_time"  size='4' maxlength='5' value='<%=strStartDateTime%>' onBlur='chkTimeFormat(this)' <%=intra_disable_flag%>>
</td>
<%}else if(!strIntraopDoneYN.equals("Y") && (!strStartDateTime.equals(""))){%>
<td class='fields' width="25%">
	<input type="text"  name="start_date" id="start_date"  size='9' maxlength='10' value='<%=arrStartDate[0]%>' Onblur="isValidDate(this);"<%=intra_disable_flag%> >
	<img src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('start_date');" <%=intra_disable_flag%> >
	<!-- onBlur='checkDateFormat(this);' Modified Onblur against SKR-SCF-1285 -->
	<img src='../../eCommon/images/mandatory.gif'></img>
	<input type="text"  name="start_time" id="start_time"  size='4' maxlength='5' value='<%=arrStartDate[1]%>' onBlur='chkTimeFormat(this)' <%=intra_disable_flag%>>
</td>
<%}%>

	<td  class='Label' width="25%"  >
		<fmt:message key="eOT.AnaesthesiaEndTime.Label" bundle="${ot_labels}"/>
	</td>
<%
	if(!strEndDateTime.equals("")){
%>
	<td class='fields' width="25%">		
		<input type="text"  name="finish_date" id="finish_date"  size='9' maxlength='10' value='<%=arrEndDate[0]%>' Onblur="isValidDate(this);" <%=intra_disable_flag%>>
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('finish_date');" <%=intra_disable_flag%>>
		<!-- onBlur='checkDateFormat(this);' Modified Onblur against SKR-SCF-1285 -->
		<input type="text"  name="finish_time" id="finish_time"  size='4' maxlength='5' value='<%=arrEndDate[1]%>'  onBlur='chkTimeFormat(this);' <%=intra_disable_flag%> >		
	</td>
<%} else if(strEndDateTime.equals("")) {%>
	<td class='fields' width="25%">		
		<input type="text"  name="finish_date" id="finish_date"  size='9' maxlength='10' value='<%=strEndDateTime%>' Onblur="isValidDate(this);" <%=intra_disable_flag%>>
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('finish_date');" <%=intra_disable_flag%>>
		<!-- onBlur='checkDateFormat(this);' Modified Onblur against SKR-SCF-1285 -->
		<input type="text"  name="finish_time" id="finish_time"  size='4' maxlength='5' value='<%=strEndDateTime%>'  onBlur='chkTimeFormat(this);' <%=intra_disable_flag%> >		
	</td>
<%} else if(!strIntraopDoneYN.equals("Y") && (!strEndDateTime.equals(""))) {%>
	<td class='fields' width="25%">		
		<input type="text"  name="finish_date" id="finish_date"  size='9' maxlength='10' value='<%=arrEndDate[0]%>' Onblur="isValidDate(this);" <%=intra_disable_flag%>>
		<image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('finish_date');" <%=intra_disable_flag%>>
		<!-- onBlur='checkDateFormat(this);' Modified Onblur against SKR-SCF-1285 -->
		<input type="text"  name="finish_time" id="finish_time"  size='4' maxlength='5' value='<%=arrEndDate[1]%>'  onBlur='chkTimeFormat(this);' <%=intra_disable_flag%> >		
</td>
<%}%>
</tr>
</table>
	<input type='hidden' name='intra_disable_flag' id='intra_disable_flag' value='<%=intra_disable_flag%>'>
	<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value='<%=strAnesthesiaSrlNo%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='locale' id='locale' value='<%=locale%>'>
	<input type='hidden' name='episode_id' id='episode_id' value='<%=strEpisodeId%>'>
	<input type='hidden' name='episode_type' id='episode_type' value='<%=strEpisodeType%>'>
	<input type='hidden' name='patient_class' id='patient_class' value='<%=strPatientClass%>'>
	<input type='hidden' name='chart_id' id='chart_id' value='<%=chartId%>'>
	<input type='hidden' name='status' id='status' value='<%=strStatus%>'>
	<input type='hidden' name='current_date' id='current_date' value='<%=current_date%>'>
	<input type='hidden' name='current_time' id='current_time' value='<%=current_time%>'>
	<input type='hidden' name='current_date_time' id='current_date_time' value='<%=current_date_time%>'>
	<input type='hidden' name='str_acc_oper_num' id='str_acc_oper_num' value='<%=strAccessionNum%>'>
	<input type='hidden' name='strUser' id='strUser' value='<%=strUser%>'>
	<input type='hidden' name='isRecordAnes' id='isRecordAnes' value='<%=isRecordAnes%>'><!-- PMG2017-SS-CRF-0001-US003 -->
<%}catch(Exception ee){
	ee.printStackTrace();
}finally{
if(conn!=null) ConnectionManager.returnConnection(conn,request);
}
%>	
</form>
</body>
</html>

