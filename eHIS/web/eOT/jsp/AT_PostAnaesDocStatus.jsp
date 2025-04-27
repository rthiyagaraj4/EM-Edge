<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper,eCommon.Common.CommonBean"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>                         
<%@ page contentType="text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends
%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
 	<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_PostAnaesthesia.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
  String locale = (String)session.getAttribute("LOCALE");
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strPatientClassDesc="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",chartId="",stranaesthesiaCode="",stranaesthetistCode1="",stranaesthetistCode2="",strStartTime="",strEndTime="",strAccessionNum="",strRecoveryStartTime="",strRecoveryEndTime="",flag="",postop_done_yn="",strBMIDesc="",strEpisodeType="";
 flag=CommonBean.checkForNull(request.getParameter("anesthesia_flag"));

 System.err.println("eOT POstAnaesDocstatus "+request.getQueryString());
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
  String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,ANAESTHESIA_CODE ANAESTHESIA_CODE1,ANAESTHETIST1_CODE ANAESTHETIST1_CODE1,ANAESTHETIST2_CODE ANAESTHETIST2_CODE1,to_char(START_TIME,'dd/mm/yyyy hh24:mi') START_TIME1,to_char(END_TIME,'dd/mm/yyyy hh24:mi') END_TIME1,ACCESSION_NUM ACC_NUM,TO_CHAR(RECOVERY_START_TIME,'DD/MM/YYYY HH24:MI') REC_ST_TIME, TO_CHAR(RECOVERY_END_TIME,'DD/MM/YYYY HH24:MI') REC_END_TIME  FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";

  try{
	conn = ConnectionManager.getConnection(request);

strAnesthesiaSrlNo=CommonBean.checkForNull(request.getParameter("anesthesia_srl_no"));
 System.err.println("eOT strAnesthesiaSrlNo "+strAnesthesiaSrlNo);
facility_id=CommonBean.checkForNull(request.getParameter("facility_id"));
postop_done_yn=CommonBean.checkForNull(request.getParameter("postop_done_yn"));



  pstmt=conn.prepareCall(sql);
  pstmt.setString(1,facility_id);
  pstmt.setString(2,strAnesthesiaSrlNo);
  rs=pstmt.executeQuery();
  
  if(rs.next())
  {
strPatientId=CommonBean.checkForNull(rs.getString("PATIENT_ID1"));
strHeight=CommonBean.checkForNull(rs.getString("HEIGHT1"));
strWeight=CommonBean.checkForNull(rs.getString("WEIGHT1"));
strBSA=CommonBean.checkForNull(rs.getString("BSA1"));
strBMI=CommonBean.checkForNull(rs.getString("BMI1"));
strSourceOrderId=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID1"));
stranaesthesiaCode=CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1"));
stranaesthetistCode1=CommonBean.checkForNull(rs.getString("ANAESTHETIST1_CODE1"));
stranaesthetistCode2=CommonBean.checkForNull(rs.getString("ANAESTHETIST2_CODE1"));
strStartTime=CommonBean.checkForNull(rs.getString("START_TIME1"));
strEndTime=CommonBean.checkForNull(rs.getString("END_TIME1"));
strAccessionNum=CommonBean.checkForNull(rs.getString("ACC_NUM"));
strRecoveryStartTime=CommonBean.checkForNull(rs.getString("REC_ST_TIME"));
strRecoveryEndTime=CommonBean.checkForNull(rs.getString("REC_END_TIME"));

  }
  if(rs!=null) rs.close();
  pstmt.close();

sql="SELECT PATIENT_CLASS PATIENT_CLASS1,ENCOUNTER_ID ENCOUNTER_ID1,EPISODE_ID EPISODE_ID1,SOURCE_TYPE SOURCE_TYPE1,SOURCE_CODE SOURCE_CODE1,ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";

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
pstmt.close();


sql="SELECT PATIENT_NAME SHORT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  DATE_OF_BIRTH1, SEX SEX1 FROM MP_PATIENT WHERE PATIENT_ID =?";
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

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strPatientClass);
rs=pstmt.executeQuery();

if(rs.next())
{
strPatientClassDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
}
if(rs!=null) rs.close();
pstmt.close();


if(strSourceType.equals("W")||strSourceType.equals("N"))
{
  sql=  "SELECT LONG_DESC SHORT_DESC1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND  FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E' AND  NURSING_UNIT_CODE =?";
  strReferralSource="Wards";
}	else
  if(strSourceType.equals("C"))
  {

   sql="SELECT LONG_DESC SHORT_DESC1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"'  AND FACILITY_ID = ? AND NVL(EFF_STATUS,'D') = 'E'    AND CLINIC_CODE=?";
	strReferralSource="Clinics";
  }
   else
  if(strSourceType.equals("R"))
  {
   sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND  NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE=?";
strReferralSource="Referral";
  }
  

pstmt=conn.prepareCall(sql);
pstmt.setString(1,facility_id);
pstmt.setString(2,strSourceCode);
rs=pstmt.executeQuery();
if(rs.next())
{
strSourceDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
}
if(rs!=null) rs.close();
pstmt.close();

sql="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW WHERE PRACTITIONER_ID=?";

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strSurgeonCode);
rs=pstmt.executeQuery();
if(rs.next())
{
strSurgeonName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
}
if(rs!=null) rs.close();
pstmt.close();


sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW WHERE PATIENT_CLASS=?";

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strPatientClass);
rs=pstmt.executeQuery();
if(rs.next())
{
strEpisodeType=CommonBean.checkForNull(rs.getString("EPISODE_TYPE1"));
}
if(rs!=null) rs.close();
pstmt.close();
sql="SELECT POST_ANAESTHESIA_CHART_ID CHART_ID FROM AT_PARAM";

pstmt=conn.prepareCall(sql);
rs=pstmt.executeQuery();
if(rs.next())
{
chartId=CommonBean.checkForNull(rs.getString("CHART_ID"));
}
if(rs!=null) rs.close();
pstmt.close();
if(strBMI.length()>0)
{
sql="SELECT STATUS_DESC  STATUS_DESC1 FROM AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";

pstmt=conn.prepareCall(sql);
pstmt.setString(1,strBMI);
rs=pstmt.executeQuery();
if(rs.next())
{
strBMIDesc=CommonBean.checkForNull(rs.getString("STATUS_DESC1"));
}
if(rs!=null) rs.close();
pstmt.close();
}


}catch(Exception ee)
{
	System.err.println("exception in AT common Anaes header:"+ee);
}
finally{
	if(rs!=null) rs.close();
if(pstmt!=null) pstmt.close();

ConnectionManager.returnConnection(conn,request);
}

%>


<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="PostAnaesDocStatusForm" id="PostAnaesDocStatusForm" >
<table cellpadding="3" cellspacing="0" width="100%" align="center" border="0">
		<input type="hidden" name="patient_id" id="patient_id" size='10'  value="<%=strPatientId%>" readonly>
		<input type="hidden" name="patient_name" id="patient_name" size='30'  value="<%=strName%>" readonly> 
		<input type="hidden"  name="sex" id="sex" size='2' value="<%=strSex%>" readonly>
		<input type="hidden"  name="dob" id="dob" size='10' value="<%=strAge%>" readonly>
		<input type="hidden" name="surgery_date" id="surgery_date" size='8'  value="<%=strSurgeryDate%>" readonly>
<tr>
<td  align="left" class="columnHeader" width="100%">
<fmt:message key="Common.status.label" bundle="${common_labels}"/>  
</td>
</tr>
<tr>
<td class='label' width="25%">
<%
   if(postop_done_yn.equals("N") || postop_done_yn.equals("")){
%>
    <input type='checkbox' name='checkAnaes' id='checkAnaes' >	   	
<% }else if(postop_done_yn.equals("Y")){ %>
    <input type='checkbox' name='checkAnaes' id='checkAnaes' checked disabled>	
<%} %> 
 <fmt:message key="eOT.PostAnaesthesiaCompleted.Label" bundle="${ot_labels}"/>   
 </td>
</tr>
</table>
	<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value="<%=strAnesthesiaSrlNo%>">
	<input type='hidden' name='facility_id' id='facility_id' value="<%=facility_id%>">
	<input type='hidden' name='episode_id' id='episode_id' value="<%=strEpisodeId%>">
	<input type='hidden' name='episode_type' id='episode_type' value="<%=strEpisodeType%>">
	<input type='hidden' name='patient_class' id='patient_class' value="<%=strPatientClass%>">
	<input type='hidden' name='chart_id' id='chart_id' value="<%=chartId%>">
	<input type='hidden' name='anaesthesia_code' id='anaesthesia_code' value="<%=stranaesthesiaCode%>">
	<input type='hidden' name='anaesthetist_code1' id='anaesthetist_code1' value="<%=stranaesthetistCode1%>">
	<input type='hidden' name='anaesthetist_code2' id='anaesthetist_code2' value="<%=stranaesthetistCode2%>">
	<input type='hidden' name='start_time' id='start_time' value="<%=strStartTime%>">
	<input type='hidden' name='end_time' id='end_time' value="<%=strEndTime%>">
	<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>">
	<input type='hidden' name='flag' id='flag' value="<%=flag%>">
	<input type='hidden' name='rec_start_date_time' id='rec_start_date_time' value="<%=strRecoveryStartTime%>">
	<input type='hidden' name='rec_finish_date_time' id='rec_finish_date_time' value="<%=strRecoveryEndTime%>">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

