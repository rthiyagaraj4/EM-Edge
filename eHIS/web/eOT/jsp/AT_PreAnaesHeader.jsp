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
//test
// added by selvin for crf-0021
String ASA_SCORE_CODE="";
String PATIENT_PHYSICAL_STATUS="";
String descvalue=""; String selectasccode=""; String asccodeupdate="";String descvalueupdate="";
// End for crf-0021
 String slate_user_id_disp = checkForNull(request.getParameter("slate_user_id")).toUpperCase();
  if(slate_user_id_disp.equals("")){
	slate_user_id_disp=	(String)session.getValue("login_user");
 }


  java.util.Properties prop = null;
  prop	= (java.util.Properties) session.getValue( "jdbc" ) ;
  String login_user	  = prop.getProperty( "login_user" );
  String locale = (String)session.getAttribute("LOCALE");
  String strAnesthesiaSrlNo="",facility_id="",strPatientId="",strHeight="",strWeight="",strBSA="",strBMI="",strSourceOrderId="",strPatientClass="",strEncounterId="",strEpisodeId="",strSourceType="",strSourceCode="",strSurgeonCode="",strSurgeryDate="",strSourceDesc="",strReferralSource="",strName="",strAge="",strSex="",strSurgeonName="",strBMIDesc="",strStatus="",strPreOpDoneYN="N",strPreOpDone_check="",disable_flag="",strAccessionNum="",strRemarks="";
  	String strUser = "";

  Connection conn=null;
  PreparedStatement pstmt=null;
  ResultSet rs=null;
  //Added by AnithaJ for IN024805 on 11/3/2010
  double bsaDisp = 0.0;
  String sql= "SELECT  PATIENT_ID PATIENT_ID1,REQUEST_SOURCE_TYPE REQUEST_SOURCE_TYPE1,ORDER_ID ORDER_ID1,HEIGHT HEIGHT1,WEIGHT WEIGHT1,BSA BSA1,BMI BMI1,SOURCE_ORDER_ID SOURCE_ORDER_ID1,STATUS STATUS1,PREOP_ASSE_DONE_YN PREOP_ASSE_DONE_YN1,ACCESSION_NUM ACCESSION_NUM1, REMARKS,ASA_SCORE_CODE ASA_SCORE_CODE1 FROM  AT_ANAESTHESIA_RECORD_HDR where OPERATING_FACILITY_ID =?  AND ANAESTHESIA_SERIAL_NUM=?"; //ASA_SCORE_CODE addded for crf-0021
try{
	conn = ConnectionManager.getConnection(request);
	facility_id=checkForNull(request.getParameter("facility_id"));
//	String pat_id=checkForNull(request.getParameter("patient_id"));
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
		ASA_SCORE_CODE=checkForNull(rs.getString("ASA_SCORE_CODE1")); // Added for crf-0021
		if(!strBSA.equals(""))
		{
			bsaDisp=Double.parseDouble(strBSA);
		}
		strBMI=checkForNull(rs.getString("BMI1"));
		strSourceOrderId=checkForNull(rs.getString("SOURCE_ORDER_ID1"));
		strStatus=checkForNull(rs.getString("STATUS1"));
		strPreOpDoneYN=checkForNull(rs.getString("PREOP_ASSE_DONE_YN1"));
		strAccessionNum=checkForNull(rs.getString("ACCESSION_NUM1"));
		strRemarks=rs.getString("REMARKS");
		System.err.println(" Remarks in line 61 : "+strRemarks);

	}
  if(rs!=null) rs.close();
  if(pstmt!=null) pstmt.close();
//Added below qry to fetch func_role_id associated to slate user id on 1/19/2011 by Anitha for 25928
	pstmt=conn.prepareStatement("select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ? ");		
		pstmt.setString(1,slate_user_id_disp);
		pstmt.setString(2,locale);
		rs=pstmt.executeQuery();
		if(rs.next()){
			strUser=checkForNull(rs.getString("func_role_id"));
		}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		  
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
	// Modified by Selvam for displaying patient names in local language

	sql="SELECT decode (?,'en',PATIENT_NAME, NVL(PATIENT_NAME_LOC_LANG,PATIENT_NAME)) SHORT_NAME1, to_char(DATE_OF_BIRTH,'dd/mm/yyyy')  DATE_OF_BIRTH1, SEX SEX1 FROM MP_PATIENT  WHERE PATIENT_ID =? ";
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
	//Commented by rajesh for PE purpose and not used this query 14/05/10
	/*sql="SELECT SHORT_DESC SHORT_DESC1 from AM_PATIENT_CLASS_LANG_VW where LANGUAGE_ID='"+locale+"' AND PATIENT_CLASS=?";
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);


	rs=pstmt.executeQuery();
	if(rs.next())
	{
	}*/
	if(rs!=null) rs.close();
		pstmt.close();
strSourceType="C";
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

	//commented for PE
/*	sql="SELECT EPISODE_TYPE EPISODE_TYPE1 FROM MP_EPISODE_TYPE_VW where PATIENT_CLASS=?";
	pstmt=conn.prepareCall(sql);
	pstmt.setString(1,strPatientClass);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strEpisodeType=checkForNull(rs.getString("EPISODE_TYPE1"));
	}
	if(rs!=null) rs.close();
		pstmt.close();

	sql="SELECT DISCR_MSR_ID DISCR_MSR_ID1 FROM AT_PARAM";
	pstmt=conn.prepareCall(sql);
	rs=pstmt.executeQuery();
	if(rs.next())
	{
		strDiscMsrId=checkForNull(rs.getString("DISCR_MSR_ID1"));
	}*/
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
	//System.err.println("Exception in PreAnaesHeader="+ee);
	ee.printStackTrace();
}
finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	}catch(Exception es){
		 es.printStackTrace();
		 //System.err.println("Exception="+es);
	}
}
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="RecordAnesthesiaHdrForm" id="RecordAnesthesiaHdrForm" >

<table cellpadding=3  cellspacing="0" width="100%" align="center" border="0">
<tr>
	<td class='Label' width="25%">
		<fmt:message key="eOT.AnaesSerialNo.Label" bundle="${ot_labels}"/>	
	</td>	
	<td class='fields' width="20%" >
		<input type="text" name="anaes_srl_no" id="anaes_srl_no" size='10'  value="<%=strAnesthesiaSrlNo%>" disabled>
	</td>	
	<input type="hidden"  name="source_id" id="source_id" size='17' value="<%=strSourceOrderId%>" disabled>	
	<input type="hidden" name="patient_id" id="patient_id" size='10'  value="<%=strPatientId%>" disabled>
	<input type="hidden" name="patient_name" id="patient_name" size='35'  value="<%=strName%>" disabled> 
	<!--</td> -->
	<input type='hidden' name='encounter_id' id='encounter_id' size='13' value= "<%=strEncounterId%>" disabled>
	<input type="hidden"  name="sex" id="sex" size='2' value="<%=strSex%>" disabled>
	<input type="hidden" name="dob" id="dob" size='10' value="<%=strAge%>" disabled>
	<td class='Label' width="20%">
	</td>
	<td class='fields' width="35%" >
	</td>	
	<input type="hidden" name="surgeon_name" id="surgeon_name" size='27' value="<%=strSurgeonName%>" disabled>
</tr>
<tr> 
	<td  class='Label' width="25%" >
		<fmt:message key="Common.weight.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width="20%" >		
		<input type="text" name="weight" id="weight" size='4'  maxlength='6'  onKeyPress="return allowValidNumber(this,event,'3','2');" onBlur="if(this.value!=''){SPCheckPositiveNumber(this);CheckBmiPositiveNumber(this); checkBMICalculation();}" value="<%=strWeight%>" <%=disable_flag%>>
		(<fmt:message key="Common.Kgs.label" bundle="${common_labels}"/>)		
	</td>	
	<td class='Label' width="20%">
		<fmt:message key="Common.height.label" bundle="${common_labels}"/>			
	</td>
	<td class='fields' width="35%" >
		<input type="text" name="height" id="height" size='4' maxlength='6'   //onKeyPress="return allowValidNumber(this,event,'3','2');"  onBlur="if(this.value!=''){SPCheckPositiveNumber(this);CheckBmiPositiveNumberHt(this);checkBMICalculation();}"  value="<%=strHeight%>" <%=disable_flag%> >
		(<fmt:message key="Common.Cms.label" bundle="${common_labels}"/>)
	</td>
</tr>
<tr>
	
	<td class='Label' width="25%"  >
		<fmt:message key="Common.BSA.label" bundle="${common_labels}"/> 
	</td>
	<td class='fields' width="20%"  >
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
	<td  class='Label' width="20%"  >
		<fmt:message key="eOT.BMIDetails.Label" bundle="${ot_labels}"/> 
	</td>
	<td class='fields' width="35%" colspan="4">
		<input type="text"  name="bmi" id="bmi"  size='5' value="<%=strBMI%>" disabled>
		<input type="text"  name="status_desc" id="status_desc" size='20' value="<%=strBMIDesc%>" disabled>
	</td>	
</tr>
<!-- <tr> -->
<table cellpadding=3  cellspacing="0" width="100%" align="left" border="0">
<tr>
<!-- Added by selvin CRF-0021 -->
<td class='Label' width="25%"  >
	<fmt:message key="eOT.AsaScore.Label" bundle="${ot_labels}"/> 
</td>
<td class='fields' width='30%' colspan="2" nowrap>
	<select name='stages1' id='stages1' id='stages1' onChange='check_asa(this);' <%=disable_flag%>  > <option value=><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></option> 	
		 <%
		try{
		
		conn = ConnectionManager.getConnection(request);
		 sql = "SELECT ASA_SCORE_CODE,PATIENT_PHYSICAL_STATUS FROM MR_ASA_SCORE WHERE eff_status = 'E' ORDER BY 1"; 
		
		
		pstmt=conn.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs!=null){		
		while (rs.next()){				
			if (ASA_SCORE_CODE.equals(rs.getString("ASA_SCORE_CODE")))
			     {
				 selectasccode=rs.getString("ASA_SCORE_CODE");
				 out.print("<option value='"+selectasccode+"' selected>"+rs.getString("ASA_SCORE_CODE")+"</option>");	
				descvalue=checkForNull(rs.getString("PATIENT_PHYSICAL_STATUS"));
				 }
				 else{
		out.print("<option value='"+rs.getString("ASA_SCORE_CODE")+"' >"+rs.getString("ASA_SCORE_CODE")+"</option>");
		}
		//ASA_SCORE_CODE=rs.getString("ASA_SCORE_CODE");
		//PATIENT_PHYSICAL_STATUS=rs.getString("PATIENT_PHYSICAL_STATUS");
			
			}
				}
if(selectasccode.equals("")){
String sql1="SELECT a.PATIENT_PHYSICAL_STATUS pstatus, b.ASA_SCORE_CODE asccode FROM MR_ASA_SCORE a, AT_ANAESTHESIA_RECORD_HDR b where a.ASA_SCORE_CODE=b.ASA_SCORE_CODE and OPERATING_FACILITY_ID ='"+facility_id+"'  AND ANAESTHESIA_SERIAL_NUM='"+strAnesthesiaSrlNo+"'"; 
 if(rs!=null) rs.close();if(pstmt!=null)pstmt.close();
 pstmt=conn.prepareStatement(sql1);
 rs=pstmt.executeQuery();
if(rs.next()){
  asccodeupdate=rs.getString("asccode");
  descvalueupdate=rs.getString("pstatus");
if (ASA_SCORE_CODE.equals(asccodeupdate))
			     {
				out.print("<option value='"+asccodeupdate+"' selected>"+asccodeupdate+"</option>");	
   } 
  }
}				
			}
  // End for crf-0021 
catch(Exception e1)
{
	System.err.println("Exception in PreAnaesHeader111="+e1);
	e1.printStackTrace();
}
finally{
	try{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(conn,request);
	 }catch(Exception e2){System.err.println("Exception111="+e2);
	 }
	   }
	
	
	%>   
</select>
<!--</td>-->	 
<!--<td width='25%'></td>
<td width='25%'></td>
<td width='25%'></td>  -->
<!--<td width='25%' class='Label' style="background-color:#ADADAD;"  >  -->
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
    <font style="FONT-SIZE:10pt;font-weight:bold; background-color:#ADADAD;"><span id="asa_score_code"></font>
<!-- </td> -->
	<td width='20%'>
			<input type='hidden' name='remarks' id='remarks' value="<%=strRemarks%>">
		  	<a class='gridLink' href="javascript:openNewDialogWindow('Remarks',100)"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a> &nbsp;&nbsp;&nbsp;
			<a class='gridLink' href="javascript:callPreAnaesNotes1('<%=login_user%>');"><fmt:message key="eOT.PreAnaesthesiaDetails.Label" bundle="${ot_labels}"/></a>
			<input type='hidden' name="preop_asse_done_yn" id="preop_asse_done_yn" value="<%=strPreOpDoneYN%>">
			<input type="hidden" name="surgery_date" id="surgery_date" size='10'  value="<%=strSurgeryDate%>" disabled>
	</td>
	<td></td>
</tr>
</table>
</table>
	<input type='hidden' name='anesthesia_srl_no' id='anesthesia_srl_no' value='<%=strAnesthesiaSrlNo%>'>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='episode_id' id='episode_id' value='<%=strEpisodeId%>'>
	<input type='hidden' name='patient_class' id='patient_class' value='<%=strPatientClass%>'>
	<input type='hidden' name='status' id='status' value='<%=strStatus%>'>
	<input type='hidden' name='disable_flag' id='disable_flag' value='<%=disable_flag%>'>
	<input type='hidden' name='accession_num' id='accession_num' value='<%=strAccessionNum%>'>
	<input type='hidden' name='strUser' id='strUser' value='<%=strUser%>'>
	<!-- <input type='hidden' name='strPatientId' id='strPatientId' value='<%=strPatientId%>'>-->
</form>
 <!-- Added for crf-0021-->		
<script>
if('<%=selectasccode%>'!=""){ 
document.getElementById('asa_score_code').innerHTML ="<%=descvalue%>";
}else{ 
   document.getElementById('asa_score_code').innerHTML ="<%=descvalueupdate%>";
}
</script>
 <!-- End  for crf-0021-->		
</body>
</html>

