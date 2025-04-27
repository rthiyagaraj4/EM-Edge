<!DOCTYPE html>
<%@page import="eCommon.Common.*,java.sql.Connection,java.sql.ResultSet,java.sql.PreparedStatement,eCommon.XSSRequestWrapper,eCommon.Common.*,java.sql.Statement,webbeans.eCommon.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
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
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
  String locale = (String)session.getAttribute("LOCALE");
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strPatientClassDesc="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",strDiscMsrId="",strBMIDesc="",strEpisodeType="",strStatus="",strPreOpDoneYN="N",strPreOpDone_check="",disable_flag="",strAccessionNum="",strRemarks="";
  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,STATUS STATUS1,PREOP_ASSE_DONE_YN PREOP_ASSE_DONE_YN1,ACCESSION_NUM ACCESSION_NUM1, REMARKS FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
try{
	conn = ConnectionManager.getConnection(request);
	facility_id=checkForNull(request.getParameter("facility_id"));
	String tab_name=request.getParameter("tab_name");
	if(tab_name.equalsIgnoreCase("AnesthesiaDetails"))
	{
		strAnesthesiaSrlNo=checkForNull(request.getParameter("anesthesia_srl_no"));
	}else if(tab_name.equalsIgnoreCase("PendingOrders")){
	    strAnesthesiaSrlNo=checkForNull(request.getParameter("generated_anesthesia_srl_no"));
	}
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,facility_id);
	pstmt.setString(2,strAnesthesiaSrlNo);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strPatientId=checkForNull(rs.getString("PATIENT_ID1"));
		strHeight=checkForNull(rs.getString("HEIGHT1"));
		strWeight=checkForNull(rs.getString("WEIGHT1"));
		strBSA=checkForNull(rs.getString("BSA1"));
		strBMI=checkForNull(rs.getString("BMI1"));
		strSourceOrderId=checkForNull(rs.getString("SOURCE_ORDER_ID1"));
		strStatus=checkForNull(rs.getString("STATUS1"));
		strPreOpDoneYN=checkForNull(rs.getString("PREOP_ASSE_DONE_YN1"));
		strAccessionNum=checkForNull(rs.getString("ACCESSION_NUM1"));
		strRemarks=checkForNull(rs.getString("REMARKS"));

		

	}
  if(rs!=null) rs.close();
	pstmt.close();
		  
	  if(strPreOpDoneYN.equalsIgnoreCase(""))
			strPreOpDoneYN="N";

	  if(strPreOpDoneYN.equalsIgnoreCase("Y"))
		{
			strPreOpDone_check="checked";
			disable_flag="disabled";
		}
	  else
			strPreOpDone_check="";
	
	sql="SELECT PATIENT_CLASS PATIENT_CLASS1,ENCOUNTER_ID ENCOUNTER_ID1,EPISODE_ID EPISODE_ID1,SOURCE_TYPE SOURCE_TYPE1,SOURCE_CODE SOURCE_CODE1,ORD_PRACT_ID ORD_PRACT_ID1,to_char(ORD_DATE_TIME,'dd/mm/yyyy') ORD_DATE_TIME1 FROM  OR_ORDER WHERE ORDER_ID=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strSourceOrderId);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strPatientClass=checkForNull(rs.getString("PATIENT_CLASS1"));
		strEncounterId=checkForNull(rs.getString("ENCOUNTER_ID1"));
		strEpisodeId=checkForNull(rs.getString("EPISODE_ID1"));
		strSourceType=checkForNull(rs.getString("SOURCE_TYPE1"));
		strSourceCode=checkForNull(rs.getString("SOURCE_CODE1"));
		strSurgeonCode=checkForNull(rs.getString("ORD_PRACT_ID1"));
		strSurgeryDate=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("ORD_DATE_TIME1"),"DMY","en",locale));
	}

	if(rs!=null) rs.close();
	pstmt.close();
	sql="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  DATE_OF_BIRTH1, SEX SEX1 FROM MP_PATIENT WHERE PATIENT_ID =? ";
	pstmt = conn.prepareStatement(sql);
	pstmt.setString(1,locale);
	pstmt.setString(2,strPatientId);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		 strName=checkForNull(rs.getString("SHORT_NAME1"));
		 strAge=checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("DATE_OF_BIRTH1"),"DMY","en",locale));
		 strSex=checkForNull(rs.getString("SEX1"));
	}
	sql="SELECT SHORT_DESC SHORT_DESC1 from AM_PATIENT_CLASS_LANG_VW where LANGUAGE_ID='"+locale+"' AND PATIENT_CLASS=?";
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strPatientClassDesc=checkForNull(rs.getString("SHORT_DESC1"));
	}
	if(rs!=null) rs.close();
		pstmt.close();
if(!strSourceType.equals(""))
{
	if(strSourceType.equals("W")||strSourceType.equals("N"))
	{
		sql="SELECT LONG_DESC SHORT_DESC1 FROM IP_NURSING_UNIT_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND FACILITY_ID ='"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E' AND  NURSING_UNIT_CODE ='"+strSourceCode+"' ";
		strReferralSource="Wards";
	}
	else
	if(strSourceType.equals("C"))
	{
	   sql="SELECT LONG_DESC SHORT_DESC1 FROM   OP_CLINIC_LANG_VW WHERE LANGUAGE_ID = '"+locale+"' AND FACILITY_ID = '"+facility_id+"' AND NVL(EFF_STATUS,'D') = 'E'    AND CLINIC_CODE='"+strSourceCode+"' ";
		strReferralSource="Clinics";
	}
	else
	if(strSourceType.equals("R"))
	{
	   sql="SELECT LONG_DESC  SHORT_DESC1 FROM AM_REFERRAL_LANG_VW  WHERE LANGUAGE_ID='"+locale+"' AND NVL(EFF_STATUS,'D') = 'E' AND REFERRAL_CODE='"+strSourceCode+"' ";
		strReferralSource="Referral";
	}
	pstmt=conn.prepareCall(sql);

	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strSourceDesc=checkForNull(rs.getString("SHORT_DESC1"));
	}

	if(rs!=null) rs.close();
	pstmt.close();
}
	sql="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW where LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID=?";
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strSurgeonCode);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strSurgeonName=checkForNull(rs.getString("SHORT_NAME1"));
	}
	if(rs!=null) rs.close();
		pstmt.close();
	
/*	sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW where PATIENT_CLASS=?";
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strEpisodeType=checkForNull(rs.getString("EPISODE_TYPE1"));
	}*/
	if(rs!=null) rs.close();
		pstmt.close();

	sql="SELECT DISCR_MSR_ID DISCR_MSR_ID1 FROM AT_PARAM";
	pstmt=conn.prepareCall(sql);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strDiscMsrId=checkForNull(rs.getString("DISCR_MSR_ID1"));
	}
	if(rs!=null) rs.close();
		pstmt.close();

	if(strBMI.length()>0)
	{
		sql="SELECT STATUS_DESC  STATUS_DESC1 from AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";

		pstmt=conn.prepareCall(sql);
		pstmt.setString(1,strBMI);
		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strBMIDesc=checkForNull(rs.getString("STATUS_DESC1"));
		}
		if(rs!=null) rs.close();
		pstmt.close();
	}


}catch(Exception ee)
{
	ee.printStackTrace();
	//System.err.println("Exception in PreAnaesHeader="+ee);
}
finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	 }catch(Exception es){es.printStackTrace();}
}
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="RecordAnesthesiaStatusForm" id="RecordAnesthesiaStatusForm" >

<table cellspacing="0" width="100%" border="0">
<tr>
<td  align="left" class="columnHeader" width="100%">
<fmt:message key="Common.status.label" bundle="${common_labels}"/>  
</td>
</tr>

<tr>
	<td class='Label'>
		<input type='checkbox' name="preop_asse_done" id="preop_asse_done" <%=strPreOpDone_check%> onclick="preAnaesCheckedYN()" <%=disable_flag%> >
		<input type='hidden' name="preop_asse_done_yn" id="preop_asse_done_yn" value="<%=strPreOpDoneYN%>">
		<fmt:message key="eOT.PreAnaesthesiaCompleted.Label" bundle="${ot_labels}"/>  
	</td>
	<td class='fields'>

	</td>
	<input type="hidden" name="surgery_date" id="surgery_date" size='10'  value="<%=strSurgeryDate%>" disabled>
	<td>
	</td>
		<td  align="left" class="label" >
		</td>
</tr>
</table>
	<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value='<%=strAnesthesiaSrlNo%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='episode_id' id='episode_id' value='<%=strEpisodeId%>'>
	<input type='hidden' name='patient_class' id='patient_class' value='<%=strPatientClass%>'>
	<input type='hidden' name='discr_msr_id' id='discr_msr_id' value='<%=strDiscMsrId%>'>
	<input type='hidden' name='status' id='status' value='<%=strStatus%>'>
	<input type='hidden' name='disable_flag' id='disable_flag' value='<%=disable_flag%>'>
	<input type='hidden' name='accession_num' id='accession_num' value='<%=strAccessionNum%>'>
</form>
</body>
</html>

