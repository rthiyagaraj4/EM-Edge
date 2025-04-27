<!DOCTYPE html>
<!-- 
Sr No        Version           Incident             SCF/CRF             Developer Name
--------------------------------------------------------------------------------------
1            V210504            16777	      PMG2021-COMN-CRF-0076      Ram kumar S
2	     V210730           16777	      PMG2021-COMN-CRF-0076      Mohana Priya
3			 V211118		   23078	        PMG2021-COMN-CRF-0076.1      Manivel Natarajan 
4			V230106				36652			TH-KW-CRF-0145.1			Mohanapriya
 -->



<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*,webbeans.op.CurrencyFormat, eBL.Common.*,  eCommon.Common.*," contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser" />

<%
	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale = 	(String)session.getAttribute("LOCALE");
%>
<html>
<head>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /> 
	<link rel='stylesheet' type='text/css' href='../../eBL/images/style.css'></link>
	<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
	<script language='javascript' src='../../eBL/js/json2.js'></script>
	
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eBL/js/MaintainTreamentPackage.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	
	</script>
	<%!private String checkForNull(String inputString) {
			return (inputString == null) ? "" : inputString;
		}%>
	<%
		//String patientId="004113"; //004113
		String params = request.getQueryString();
	System.err.println("params ::::::::::::::: "+params);
	String patient=checkForNull(request.getParameter("patid"));
	String mode=checkForNull(request.getParameter("mode"));
	String calledFrom=checkForNull(request.getParameter("calledFrom"));//V230106
	String disable="";
	String readnly="";
	if(calledFrom.equals("managePatientPopup")){
		disable="disabled";
		readnly="readonly";
	}//V230106
	//SA0000004178
	System.err.println("calledFrom "+calledFrom);
	String facility_id = (String) session.getValue("facility_id");
	java.util.Properties p = null;
	String ws_no = "", userid = "";
	
	System.out.println("patient ::::::::::::::: "+patient);
	String calenderPrivileageYN = "N", modifyPractPrivYN = "N", assDeassEncPrivYN = "N", pkgServLmtDtlsPrivYN = "N", adhocDiscPrivYN = "N", cancelPkgPrivYN = "N"; // V211118
	
	try { // V211118
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			con = ConnectionManager.getConnection(request);
			String function_id = "EBL_TRAN_PACKAGE_MAINTAIN";
			
			userid = (String) session.getValue("login_user");
			p = (java.util.Properties) session.getValue("jdbc");
			ws_no = p.getProperty("client_ip_address");

			String responseText = "";
			String sql = "select privlege_code, NVL(allowed_yn,'N') from bl_user_privileges where user_code = '" + userid
					+ "' and function_id = '" + function_id + "'";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				if("MODIFY_EFF_FROM_MTPKG".equals(rs.getString(1)))
					calenderPrivileageYN = checkForNull(rs.getString(2));
				else if("MODIFY_PRAC_NAME_MTPKG".equals(rs.getString(1)))
					modifyPractPrivYN = checkForNull(rs.getString(2));
				else if("MODIFY_ASSOC_DEASSOC_MTPKG".equals(rs.getString(1)))
					assDeassEncPrivYN = checkForNull(rs.getString(2));
				else if("MODIFY_PKG_SERV_LMT_DTLS_MTPKG".equals(rs.getString(1)))
					pkgServLmtDtlsPrivYN = checkForNull(rs.getString(2));	
				else if("ALLOW_ADHOC_DISC_ENTRY_MTPKG".equals(rs.getString(1)))
					adhocDiscPrivYN = checkForNull(rs.getString(2));	
				else if("ALLOW_CANCEL_PACKAGE_MTPKG".equals(rs.getString(1)))
					cancelPkgPrivYN = checkForNull(rs.getString(2));						
			}
		} catch (Exception e) {
			System.err.println(e);
		}
			
		System.err.println("PrivileageYN:"+calenderPrivileageYN+"/"+modifyPractPrivYN+"/"+assDeassEncPrivYN+"/"+pkgServLmtDtlsPrivYN+"/"+adhocDiscPrivYN+"/"+cancelPkgPrivYN);
			
	%>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<title>MTP</title>
</head>
<%
if(calledFrom.equals("managePatientPopup")){
	if(mode.equals("reloaded")){
	%>
	<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"  onscroll='moveFrame()' onload='primaryPatValidation('<%=patient%>','<%=params%>')'>
	<%}
	else{
		System.out.println("patient ::::mmm::::::::::: "+patient);
		%>
	<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"  onscroll='moveFrame()' onload="primaryPatValidation('<%=patient%>','<%=params%>')">
	<%}
}else{
if(mode.equals("reloaded")){
%>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"  onscroll='moveFrame()' onload=''>
<%}
else{%>
<body onKeyDown="lockKey();" onMouseDown="CodeArrest();"  onscroll='moveFrame()' onload='focusELement()'>
<%}
}
%>
<form name='frmMaintainTreatHeader' id='frmMaintainTreatHeader' method='' >
<center>
<table width="100%" border="0" cellspacing="0" cellpadding="0" class="BorderLight">
  <tr>
    <td class="pad4side">
		<table width="100%" border="0" cellspacing="0" cellpadding="5"> 
      <tr>
      	<td class="label" width="25%"><b><fmt:message key="Common.patientId.label"   bundle="${common_labels}"/></b>
	      	<input type="text" name="patient_id" id="patient_id" id="patient_id" 	value="<%=patient %>" <%=readnly%>	 maxlength="30"  onBlur="ChangeUpperCase( this ),primaryPatValidation(this.value,'<%=params%>');if(this.value == ''){ PatientIdLookup(); primaryPatValidation(this.value,'<%=params%>');}"    onKeyPress="return CheckForSpecChars(event);lockbackSpace();" >
			<input type='button' class='button' name="patientidbut" id="patientidbut" value='?' <%=disable%>  onClick="PatientIdLookup();primaryPatValidation(patient_id,'<%=params%>');"     tabindex='2' />
	      	<img src='../../eCommon/images/mandatory.gif'> <i><B>Recalculation will happen only when the transaction is saved.</B></i></td> 
       </tr>
    </table></td>
  </tr>
  <!-- 
    <tr>
      <td class="pad4side Bg-yellow"><table width="100%" border="0" cellspacing="0" cellpadding="0">
        <tbody>
          <tr>
            <td width="4%" rowspan="2"><img src="icon1.png" width="33" height="41" alt=""/></td>
            <td id='tdLin' nowrap class="BOLD">NARENDRA DAMODARDAS 67YRS 3M 14D 004113</td>
          </tr>
          <tr>
            <td>National ID: 33EE  Alt ID: </td>
          </tr>
        </tbody>
      </table></td>
    </tr>  
    <tr>
      <td class="pad4side"><table width="100%" border="0" cellspacing="0" cellpadding="4">
        <tr>
          <td class="CAGROUPHEADING">Package Details</td>
        </tr>
        </table>
        </td>
        </tr>  -->
        <input type='hidden' name='patientId' id='patientId' id='patientId' value=''> 
		 <input type='hidden' name='calledFrom' id='calledFrom' id='calledFrom' value='<%=calledFrom%>'> <!--V230106-->
		<input type='hidden' name='facility_id' id='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='userid' id='userid' id='userid' value='<%=userid%>'>
		<input type='hidden' name='ws_no' id='ws_no' id='ws_no' value='<%=ws_no%>'>
    </table>
    </center>
	</form>
	
    </body>
    </html>

