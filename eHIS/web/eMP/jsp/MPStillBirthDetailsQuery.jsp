<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,com.ehis.util.* " contentType="text/html;charset=UTF-8" %>

<title><fmt:message key="eMP.StillBirthDtls.label" bundle="${mp_labels}"/></title>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script src='../../eCommon/js/FieldFormatMethods.js' language='javascript'></script>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
	<script src='../../eMP/js/MPStillBirthDetails.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>

<%
	Connection conn=null;
	PreparedStatement pstmt   =null;		
	ResultSet rs            = null;

   try{

	conn=ConnectionManager.getConnection (request);
	String locale=(String)session.getAttribute("LOCALE"); 
	//String facilityId       = (String) session.getValue("facility_id");
	String patient_id		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
	String pract_id_still_birth="";
	String attendant_at_birth = "";
	String autopsy_reqd_yn = "";
	String mate_cond_main_cod= ""; 
	String mate_cond_main_cod_dur= ""; 
	String mate_cond_oth_cod= ""; 
	String mate_cond_oth_cod_dur= ""; 
	String mate_cond_preexist_cod= ""; 
	String mate_cond_preexist_cod_dur= ""; 
	String oth_rel_mate_cond_rel_cod= ""; 
	String oth_rel_mate_cond_rel_cod_dur= ""; 
	String cond_cau_dea_main_cod= ""; 
	String cond_cau_dea_main_cod_dur= ""; 
	String cond_cau_dea_oth_cod= ""; 
	String cond_cau_dea_oth_cod_dur= ""; 
	String cond_cau_dea_preexist_cod= ""; 
	String cond_cau_dea_preexist_cod_dur= ""; 
	String rel_cond_cau_dea_rel_cod= ""; 
	String rel_cond_cau_dea_rel_cod_dur= ""; 
	String	practid_desc= ""; 
	String	surname_pract= ""; 
	String	age= ""; 
	String	licenseNo= ""; 
	int age_val=0;

    StringBuffer sql               =	new StringBuffer();
	sql.append("select  auth_practitioner_id, attendant_at_birth, autopsy_reqd_yn, mate_cond_main_cod, mate_cond_main_cod_dur, mate_cond_oth_cod, mate_cond_oth_cod_dur, mate_cond_preexist_cod, mate_cond_preexist_cod_dur, oth_rel_mate_cond_rel_cod, oth_rel_mate_cond_rel_cod_dur, cond_cau_dea_main_cod, cond_cau_dea_main_cod_dur, cond_cau_dea_oth_cod, cond_cau_dea_oth_cod_dur, cond_cau_dea_preexist_cod, cond_cau_dea_preexist_cod_dur, rel_cond_cau_dea_rel_cod, rel_cond_cau_dea_rel_cod_dur from mp_still_birth_details where patient_id = ? ");

	pstmt   = conn.prepareStatement(sql.toString());
	pstmt.setString(1, patient_id);

	rs = pstmt.executeQuery();
	if(rs!=null && rs.next())
	{	
		pract_id_still_birth =  checkForNull(rs.getString("auth_practitioner_id"));
		attendant_at_birth =  checkForNull(rs.getString("attendant_at_birth"));
		autopsy_reqd_yn=  checkForNull(rs.getString("autopsy_reqd_yn"));
		mate_cond_main_cod=  checkForNull(rs.getString("mate_cond_main_cod"));
		mate_cond_main_cod_dur=  checkForNull(rs.getString("mate_cond_main_cod_dur"));
		mate_cond_oth_cod=  checkForNull(rs.getString("mate_cond_oth_cod"));
		mate_cond_oth_cod_dur=  checkForNull(rs.getString("mate_cond_oth_cod_dur"));
		mate_cond_preexist_cod=  checkForNull(rs.getString("mate_cond_preexist_cod")); 
		mate_cond_preexist_cod_dur=  checkForNull(rs.getString("mate_cond_preexist_cod_dur"));
		oth_rel_mate_cond_rel_cod=  checkForNull(rs.getString("oth_rel_mate_cond_rel_cod"));
		oth_rel_mate_cond_rel_cod_dur=  checkForNull(rs.getString("oth_rel_mate_cond_rel_cod_dur"));
		cond_cau_dea_main_cod=  checkForNull(rs.getString("cond_cau_dea_main_cod"));
		cond_cau_dea_main_cod_dur=  checkForNull(rs.getString("cond_cau_dea_main_cod_dur"));
		cond_cau_dea_oth_cod=  checkForNull(rs.getString("cond_cau_dea_oth_cod"));
		cond_cau_dea_oth_cod_dur=  checkForNull(rs.getString("cond_cau_dea_oth_cod_dur"));
		cond_cau_dea_preexist_cod=  checkForNull(rs.getString("cond_cau_dea_preexist_cod"));
		cond_cau_dea_preexist_cod_dur=  checkForNull(rs.getString("cond_cau_dea_preexist_cod_dur"));
		rel_cond_cau_dea_rel_cod=  checkForNull(rs.getString("rel_cond_cau_dea_rel_cod"));
		rel_cond_cau_dea_rel_cod_dur=  checkForNull(rs.getString("rel_cond_cau_dea_rel_cod_dur"));
	}
    if(rs != null) rs.close();
	if(pstmt !=null) pstmt.close();
	if((sql != null) && (sql.length() > 0))
	    {
			sql.delete(0,sql.length());
	    }

	if (!mate_cond_main_cod_dur.equals("")){
		mate_cond_main_cod_dur=mate_cond_main_cod_dur.replaceFirst("Y","Y  ");
		mate_cond_main_cod_dur=mate_cond_main_cod_dur.replaceFirst("D","D  ");
		mate_cond_main_cod_dur=mate_cond_main_cod_dur.replaceFirst("M","M  ");
	}

	if (!mate_cond_oth_cod_dur.equals("")){
		mate_cond_oth_cod_dur=mate_cond_oth_cod_dur.replaceFirst("Y","Y  ");
		mate_cond_oth_cod_dur=mate_cond_oth_cod_dur.replaceFirst("D","D  ");
		mate_cond_oth_cod_dur=mate_cond_oth_cod_dur.replaceFirst("M","M  ");
	}
	if (!mate_cond_preexist_cod_dur.equals("")){
		mate_cond_preexist_cod_dur=mate_cond_preexist_cod_dur.replaceFirst("Y","Y  ");
		mate_cond_preexist_cod_dur=mate_cond_preexist_cod_dur.replaceFirst("D","D  ");
		mate_cond_preexist_cod_dur=mate_cond_preexist_cod_dur.replaceFirst("M","M  ");
	}
	if (!oth_rel_mate_cond_rel_cod_dur.equals("")){
		oth_rel_mate_cond_rel_cod_dur=oth_rel_mate_cond_rel_cod_dur.replaceFirst("Y","Y  ");
		oth_rel_mate_cond_rel_cod_dur=oth_rel_mate_cond_rel_cod_dur.replaceFirst("D","D  ");
		oth_rel_mate_cond_rel_cod_dur=oth_rel_mate_cond_rel_cod_dur.replaceFirst("M","M  ");
	}
	if (!cond_cau_dea_main_cod_dur.equals("")){
		cond_cau_dea_main_cod_dur =cond_cau_dea_main_cod_dur.replaceFirst("D","D  ");
		cond_cau_dea_main_cod_dur =cond_cau_dea_main_cod_dur.replaceFirst("M","M  ");
	}
	if (!cond_cau_dea_oth_cod_dur.equals("")){
		cond_cau_dea_oth_cod_dur =cond_cau_dea_oth_cod_dur.replaceFirst("D","D  ");
		cond_cau_dea_oth_cod_dur =cond_cau_dea_oth_cod_dur.replaceFirst("M","M  ");
	}
	if (!cond_cau_dea_preexist_cod_dur.equals("")){
		cond_cau_dea_preexist_cod_dur =cond_cau_dea_preexist_cod_dur.replaceFirst("D","D  ");
		cond_cau_dea_preexist_cod_dur =cond_cau_dea_preexist_cod_dur.replaceFirst("M","M  ");
	}
	if (!rel_cond_cau_dea_rel_cod_dur.equals("")){
		rel_cond_cau_dea_rel_cod_dur =rel_cond_cau_dea_rel_cod_dur.replaceFirst("D","D  ");
		rel_cond_cau_dea_rel_cod_dur =rel_cond_cau_dea_rel_cod_dur.replaceFirst("M","M  ");
	}


	if(!pract_id_still_birth.equals(""))	{
		pstmt   = conn.prepareStatement("select practitioner_name,short_name, get_age(date_of_birth) age,apc_no from am_practitioner_lang_vw where practitioner_id = ? and language_id = '"+locale+"' ");
		pstmt.setString(1, pract_id_still_birth);

		rs = pstmt.executeQuery();
		if(rs!=null && rs.next()) {		
			practid_desc= checkForNull(rs.getString("practitioner_name"));
			surname_pract= checkForNull(rs.getString("short_name"));
			age	= checkForNull(rs.getString("age"));
			licenseNo= checkForNull(rs.getString("apc_no")); 
		}

		if(!age.equals("")) {
			age_val = age.indexOf("Y");
			age = age.substring(0,age_val);
	   }
	}

	try
	{
		
	%>
	<TITLE><fmt:message key="eMP.StillBirthDtls.label" bundle="${mp_labels}"/></TITLE>
	</head>
	<body onKeyDown ='lockKey()' >
	<form name="StillBirth_form_query" id="StillBirth_form_query"  method='post' target="Dummy_frame">
	<table border='0' align=center cellpadding='3' cellspacing='0' width='98%'  >
					
	<tr><td colspan=4>&nbsp;</td></tr>
	<tr>
		<td class="label" width='5%'><fmt:message key="eMP.NameoftheCertperson.label" bundle="${mp_labels}"/></td>
        <td class='querydata'  width='25%'><b><%=practid_desc%></b></td>
	</tr>
	<tr>
		<td class="label" width='5%'><fmt:message key="Common.age.label" bundle="${common_labels}"/></td>
		<td class='querydata'  width='5%'><b><%=age%></b></td> 
		<td class="label" width='25%'><fmt:message key="eMP.LicenseNo.label" bundle="${mp_labels}"/></td>
		<td class='querydata'  width='5%'><b><%=licenseNo%></b></td>	
	</tr>
	<tr>
		<td class="label" width='5%'><fmt:message key="eMP.AttendantAtBirth.label" bundle="${mp_labels}"/></td>
		<% if(attendant_at_birth.equals("AC")){%>
		<td class='querydata'  width='5%'><b><fmt:message key="eMP.Accoucheuse.label" bundle="${mp_labels}"/></b></td>
		<%}else if (attendant_at_birth.equals("TM")){%>
		<td class='querydata'  width='5%'><b><fmt:message key="eMP.TraditionalMedicine.label" bundle="${mp_labels}"/></b></td>
		<%}else if (attendant_at_birth.equals("MA")){%>
		<td class='querydata'  width='5%'><b><fmt:message key="eMP.MidwifeAssistance.label" bundle="${mp_labels}"/></b></td>
		<%}else if (attendant_at_birth.equals("PH")){%>
		<td class='querydata'  width='5%'><b><fmt:message key="eMP.Physician.label" bundle="${mp_labels}"/></b></td>
		<%}else if (attendant_at_birth.equals("MW")){%>
		<td class='querydata'  width='5%'><b><fmt:message key="Common.midwife.label" bundle="${common_labels}"/></b></td>
		<%}else if (attendant_at_birth.equals("NU")){%>
		<td class='querydata'  width='5%'><b><fmt:message key="Common.nurse.label" bundle="${common_labels}"/></b></td>
		<%}%>
	</tr>
	<tr>
			<td  colspan=4 class='columnheader'><fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
	</tr>
	<tr>
			<td  colspan=4 class='label'></td>
	</tr>
	<tr>
			<td  colspan=2 class='columnheader'>1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.MaternalcondAffectFetus.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>a.&nbsp;<fmt:message key="Common.main.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="mate_cond_main_cod" size=100 rows="2" cols="50" readonly><%=mate_cond_main_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=mate_cond_main_cod_dur%></b></td>	
	</tr>
		<tr>
		<td class="label" width='25%'>b.&nbsp;<fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="mate_cond_oth_cod" size=100 rows="2" cols="50" readonly><%=mate_cond_oth_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=mate_cond_oth_cod_dur%></b></td>	
	</tr>

	<tr>
		<td class="label" width='25%'>c.&nbsp;<fmt:message key="eMP.Preexistent.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="mate_cond_preexist_cod" size=100 rows="2" cols="50" readonly><%=mate_cond_preexist_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=mate_cond_preexist_cod_dur%></b></td>	
	</tr>
	<tr>
			<td  colspan=2 class='columnheader'>2.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.OthRelatMaternalCondiAffectFetus.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>d.&nbsp;<fmt:message key="eMP.RelatedcauseofDeath.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%' ><TextArea name="oth_rel_mate_cond_rel_cod" size=100 rows="2" cols="50" readonly><%=oth_rel_mate_cond_rel_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=oth_rel_mate_cond_rel_cod_dur%></b></td>	
	</tr>


   <tr>
			<td  colspan=2 class='columnheader'>1.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.RelCondCausingDeathInFetus.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>a.&nbsp;<fmt:message key="Common.main.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%'><TextArea name="cond_cau_dea_main_cod" size=100 rows="2" cols="50" readonly><%=cond_cau_dea_main_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=cond_cau_dea_main_cod_dur%></b></td>	
	</tr>
		<tr>
		<td class="label" width='25%'>b.&nbsp;<fmt:message key="Common.other.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%'><TextArea name="cond_cau_dea_oth_cod" size=100 rows="2" cols="50" readonly><%=cond_cau_dea_oth_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=cond_cau_dea_oth_cod_dur%></b></td>	
	</tr>

	<tr>
		<td class="label" width='25%'>c.&nbsp;<fmt:message key="eMP.Preexistent.label" bundle="${mp_labels}"/>&nbsp;<fmt:message key="Common.CauseofDeath.label" bundle="${common_labels}"/></td>
		<td class ='fields'  width='25%'><TextArea name="cond_cau_dea_preexist_cod" size=100 rows="2" cols="50" readonly><%=cond_cau_dea_preexist_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=cond_cau_dea_preexist_cod_dur%></b></td>	
	</tr>

	<tr>
			<td  colspan=2 class='columnheader'>2.&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="eMP.RelCondiCausDeathinFetus.label" bundle="${mp_labels}"/></td><td  colspan=2 class='columnheader'><fmt:message key="eMP.DurationofDisease.label" bundle="${mp_labels}"/></td>
	</tr>
	<tr>
		<td class="label" width='25%'>d.&nbsp;<fmt:message key="eMP.RelatedcauseofDeath.label" bundle="${mp_labels}"/></td>
		<td class ='fields'  width='25%'><TextArea name="rel_cond_cau_dea_rel_cod" size=100 rows="2" cols="50" readonly><%=rel_cond_cau_dea_rel_cod%></TextArea></td>	
		<td class='querydata'  width='5%'><b><%=rel_cond_cau_dea_rel_cod_dur%></b></td>	
	</tr>
	<tr>
			<td  colspan=4 class='columnheader'>&nbsp;</td>
	</tr>
	<tr>
		<td class="label" width='25%'><fmt:message key="eMP.AutopsyRequried.label" bundle="${mp_labels}"/></td>
		 <%if(autopsy_reqd_yn.equals("Y")) {   %> 
			<td class='querydata' ><b><fmt:message key="Common.yes.label" bundle="${common_labels}"/></b></td>
		<% }else if (autopsy_reqd_yn.equals("N")){%>
			<td class='querydata' ><b><fmt:message key="Common.no.label" bundle="${common_labels}"/></b></td>
        <%}%>
		<td class='fields' width='25%' align='left'><input type='button' class='button' name='close' id='close' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>'  onclick="onCloseQuery();" >
	</td>
	</tr>
	</table> 

</form>
<%!
	// To Handle java.lang.NullPointerException.
	public static String checkForNull(String inputString)
	{
		return ( ((inputString == null) || (inputString.equals(""))) ? "" : inputString );
	}

%>
</body>
</html>
<%

}catch ( Exception e ){ 
	out.println(e);
	e.printStackTrace();
	
}finally{
	try
	{
		if(pstmt !=null) pstmt.close();
		if(rs != null) rs.close();
	}catch(Exception ce){out.println(ce);}

	ConnectionManager.returnConnection(conn,request);
}
}catch(Exception e)
{
	e.printStackTrace();
}
%>

