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
<!-- Commented below line and added sStyle for IN023984 on 9/29/2010 by AnithaJ -->

<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></LINK>
 -->
 <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
 <link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script> 
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordIntraAnesthesia.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<%
  java.util.Properties prop = null;
  prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
  String locale = (String)session.getAttribute("LOCALE");
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strStatus="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strPatientClassDesc="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",chartId="",strAnaesthesiaCode="",strAnaesthesiaDesc="",strEndDateTime="",strStartDateTime="",strBMIDesc="",strEpisodeType="",strIntraopDoneYN="N",strIntraopDone_check="",intra_disable_flag="",accession_num="",strAccessionNum="",current_date = "" ,current_time	= "" ,current_date_time	= "" ;
  Statement stmt1 = null ;
  ResultSet resultSet1     = null ;
  String[] arrStartDate = null;
  String[] arrEndDate =  null;
  int tot_rec=0;
	Connection conn=null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	String sql_curr_date="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CUR_DATE,TO_CHAR(SYSDATE,'HH24:MI') CUR_TIME,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI')  CURRENT_DATE_TIME FROM DUAL";
	Statement stmt = null ;
	ResultSet resultSet			= null ;
	try{
		conn			= ConnectionManager.getConnection(request);
		stmt				= conn.createStatement() ;
		resultSet			= stmt.executeQuery(sql_curr_date);
		while(resultSet!=null && resultSet.next()){
			current_date = resultSet.getString("CUR_DATE");
			current_time = resultSet.getString("CUR_TIME");
			current_date_time = resultSet.getString("CURRENT_DATE_TIME");

	}
  String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,STATUS STATUS1,ANAESTHESIA_CODE ANAESTHESIA_CODE1,ANAESTHETIST1_CODE ANAESTHETIST1_CODE1,ANAESTHETIST2_CODE ANAESTHETIST2_CODE1,TO_CHAR(END_TIME,'DD/MM/YYYY HH24:MI') END_TIME1,TO_CHAR(START_TIME,'DD/MM/YYYY HH24:MI') START_TIME1,INTRAOP_DONE_YN INTRAOP_DONE_YN1,ACCESSION_NUM ACCESSION_NUM1 FROM AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?";
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
		strBMI=CommonBean.checkForNull(rs.getString("BMI1"));
		strSourceOrderId=CommonBean.checkForNull(rs.getString("SOURCE_ORDER_ID1"));
		strStatus=CommonBean.checkForNull(rs.getString("STATUS1"));
		strAnaesthesiaCode=CommonBean.checkForNull(rs.getString("ANAESTHESIA_CODE1"));
		strEndDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("END_TIME1"),"DMYHM","en",locale));
		strStartDateTime=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("START_TIME1"),"DMYHM","en",locale));
		strIntraopDoneYN=CommonBean.checkForNull(rs.getString("INTRAOP_DONE_YN1"));
		strAccessionNum=CommonBean.checkForNull(rs.getString("ACCESSION_NUM1"));
		Pattern Regex = Pattern.compile("\\s", Pattern.MULTILINE);
		arrStartDate =   Regex.split(strStartDateTime,strStartDateTime.length());
		arrEndDate   =   Regex.split(strEndDateTime,strStartDateTime.length());
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
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();
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
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

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
		pstmt=conn.prepareCall(sql);

		rs=pstmt.executeQuery();
		if(rs.next())
		{
			strSourceDesc=CommonBean.checkForNull(rs.getString("SHORT_DESC1"));
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
		strSurgeonName=CommonBean.checkForNull(rs.getString("SHORT_NAME1"));
	}
	if(rs!=null) rs.close();
	pstmt.close();

	sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW where PATIENT_CLASS=?";

	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strEpisodeType=CommonBean.checkForNull(rs.getString("EPISODE_TYPE1"));
	}
	if(rs!=null) rs.close();
	pstmt.close();
	sql="SELECT INTRA_ANAESTHESIA_CHART_ID CHART_ID FROM AT_PARAM";
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
		sql="SELECT STATUS_DESC  STATUS_DESC1 from AT_BMI_ANALYSIS WHERE ? BETWEEN MIN_VALUE AND MAX_VALUE";

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
			pstmt.close();
	}

		String sql_anaes="SELECT OPER_NUM OPER_NUM1 FROM OT_POST_OPER_HDR WHERE ORDER_ID =? ";

		pstmt=conn.prepareCall(sql_anaes);
		pstmt.setString(1,strSourceOrderId);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next())
		{	tot_rec++;
			accession_num=CommonBean.checkForNull(rs.getString("OPER_NUM1"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

	  }
}catch(Exception ee){
	ee.printStackTrace();
	//System.err.println("Exception in IntraAnaesHeader="+ee);
}
finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(resultSet!=null) resultSet.close();
		if(stmt!=null) stmt.close();
		if(resultSet1!=null) resultSet1.close();
		if(stmt1!=null) stmt1.close();
		ConnectionManager.returnConnection(conn,request);
	}catch(Exception es){es.printStackTrace();}
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
<td align='left' class='COLUMNHEADER' width='100%'>
<fmt:message key="Common.status.label" bundle="${common_labels}"/>  
</td>
</tr>  

<tr>
	<td class='Label'>
		<input type='checkbox' name="intraop_done" id="intraop_done" <%=strIntraopDone_check%>  onclick="intraAnaesCheckedYN()" <%=intra_disable_flag%> > 
		<input type='hidden' name="intraop_done_yn" id="intraop_done_yn" value="<%=strIntraopDoneYN%>" >
	<fmt:message key="eOT.IntraAnaesthesiaCompleted.Label" bundle="${ot_labels}"/> 
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
	<input type='hidden' name='intra_disable_flag' id='intra_disable_flag' value='<%=intra_disable_flag%>'>
	<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value='<%=strAnesthesiaSrlNo%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='episode_id' id='episode_id' value='<%=strEpisodeId%>'>
	<input type='hidden' name='episode_type' id='episode_type' value='<%=strEpisodeType%>'>
	<input type='hidden' name='patient_class' id='patient_class' value='<%=strPatientClass%>'>
	<input type='hidden' name='chart_id' id='chart_id' value='<%=chartId%>'>
	<input type='hidden' name='status' id='status' value='<%=strStatus%>'>
	<input type='hidden' name='current_date' id='current_date' value='<%=current_date%>'>
	<input type='hidden' name='current_time' id='current_time' value='<%=current_time%>'>
	<input type='hidden' name='current_date_time' id='current_date_time' value='<%=current_date_time%>'>
</form>
</body>
</html>

