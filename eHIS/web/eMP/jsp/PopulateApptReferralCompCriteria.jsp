<!DOCTYPE html>
<!-- Last Modified Date Time : 9/23/2005 11:30 AM -->
<%@ page import ="java.sql.*,webbeans.eCommon.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	 <Script language="JavaScript" src="../../eCommon/js/ValidateControl.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/common.js" ></Script>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<Script language='javascript' src='../../eMP/js/PopulateApptReferralComp.js'></Script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body onKeyDown='lockKey()'>

<%
	String refrlAappt	= "";
	String IPinstall_yn = "";
	String OPinstall_yn = "";
	String OAinstall_yn = "";
	String RDinstall_yn = "";
	String p_serv_date = "";
	Connection con =null;
	PreparedStatement pstmt=null;
	ResultSet rs=null;

	
	try
	{
	   request.setCharacterEncoding("UTF-8");
	   	con = ConnectionManager.getConnection(request);
	   refrlAappt	= request.getParameter("refrlAappt");
	   IPinstall_yn = request.getParameter("IPinstall_yn");
	   OPinstall_yn = request.getParameter("OPinstall_yn");
	   OAinstall_yn = request.getParameter("OAinstall_yn");
	   RDinstall_yn = request.getParameter("RDinstall_yn");

	   if(refrlAappt == null) refrlAappt = "";
	   if(IPinstall_yn == null) IPinstall_yn = "N";
	   if(OPinstall_yn == null) OPinstall_yn = "N";
	   if(OAinstall_yn == null) OAinstall_yn = "N";
	   if(RDinstall_yn == null) RDinstall_yn = "N";
 
       String sqlAuto="select to_char(sysdate,'dd/mm/yyyy') sys from dual ";
			pstmt = con.prepareStatement(sqlAuto);		
			rs = pstmt.executeQuery();
			while(rs.next()){
				p_serv_date=rs.getString("sys");
			}

			if(rs!=null) rs.close();		
			if(pstmt!=null)	pstmt.close(); 

		StringBuffer OptionBuffer = null;
		OptionBuffer = new StringBuffer();
		if(refrlAappt.equals("A"))
		{
			OptionBuffer.append("<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+"</option><option value='Y'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+"</option><option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+"</option>");
		}
		else if(refrlAappt.equals("R"))
		{
			OptionBuffer.append("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+"</option>");
		}
		else if(refrlAappt.equals("I"))
		{
			OptionBuffer.append("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</option>");
		}
		else if(refrlAappt.equals("L"))
		{
			OptionBuffer.append("<option value='C'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+"</option><option value='Y'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels")+"</option>");
			if(IPinstall_yn.equals("Y"))
			{
				OptionBuffer.append("<option value='N'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+"</option>");
			}

			OptionBuffer.append("<option value='E'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels")+"</option>");

			if(RDinstall_yn.equals("Y"))
			{
				OptionBuffer.append("<option value='W'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+"</option>");
			}
		}

	 %>
	 <form name='popAppRefCriteriaForm' id='popAppRefCriteriaForm'>
	 <table border='0' cellpadding='0' cellspacing='0' width='100%' >
		<tr><jsp:include page="../../eMP/jsp/natAltIDComponentCriteria.jsp" ><jsp:param name="flush" value="true" /></jsp:include></tr>
		</table>
		<table border='0' cellpadding='2' cellspacing='0' width='100%'>
		<TR>
			 <td class='label' ><fmt:message key="Common.PatientName.label" bundle="${common_labels}"/></TD>
			 <td class='fields' colspan='3'><input type='text' name='patName' id='patName'  size='60' maxlength='80' value=''></TD>
			
			 
		</TR>
		<TR> 
			<td class='label' width='24%' ><fmt:message key="Common.Period.label" bundle="${common_labels}"/></TD>
			 <td class='fields'  width='31%'><input type='text' name='periodFrom' id='periodFrom' id='fromPeriod' size ='10' maxlength='10' value='' onBlur="DateCompare_from('from',this);validate_date_from(this,periodTo);"><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='from'  onClick="document.forms[0].periodFrom.select();return showCalendar('fromPeriod');">&nbsp;<input type='text' name='periodTo' id='periodTo' id='toPeriod' size ='10' maxlength='10' value='' onBlur="DateCompare_from('To',this);validate_date_to(this,periodFrom);"><input type='image' src='../../eCommon/images/CommonCalendar.gif' id='to'  onClick="document.forms[0].periodTo.select();return showCalendar('toPeriod');"></TD> 
			<td class='label' width='26%' nowrap><fmt:message key="Common.referenceno.label" bundle="${common_labels}"/></TD>
			 <td class='fields' width='19%'><input type='text' name='refNo' id='refNo' size ='14' maxlength='14' value='' onKeyPress='return CheckForSpecChars(event);'></TD>
			 
		</TR>
		<TR>
			 <td class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></TD>
			  <td class='fields'><select name='location' id='location' onChange="popLocValues(this);"><option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option><%=OptionBuffer.toString()%> </select>&nbsp;/&nbsp;<select name='locationValue' id='locationValue'>
			  <option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option></select></TD>
				   <td class='label' ><fmt:message key="Common.gender.label" bundle="${common_labels}"/></TD>
				  <td class='fields' ><select name='genderValue' id='genderValue'><option value=''>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option><option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option><option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option><option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option></select></TD>
		</tr>
		<tr>
			 <td colspan='4' class='button'><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='callResultPage();'><input type='button' class='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' onClick='clearResPage();'><input type='button' class='button' name='cancel' id='cancel' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onClick='closeModWindow();'></TD>
		</TR>
		
		</table>
		<input type='hidden' name='refrlAappt' id='refrlAappt' value="<%=refrlAappt%>">
		<input type='hidden' name='RDinstall_yn' id='RDinstall_yn' value="<%=RDinstall_yn%>">
		<input type='hidden' name='sStyle' id='sStyle' value="<%=sStyle%>">
		<input type='hidden' name='sysdate' id='sysdate' value="<%=p_serv_date%>">
			<input type='hidden' name='cld_frm_pat_regn' id='cld_frm_pat_regn' value="Y"> <!--smart card-->
			<input type='hidden' name='patientid' id='patientid' value="">
	 </form>
	<% 
	if(OptionBuffer != null && OptionBuffer.length() > 0)
	{
		OptionBuffer.delete(0,OptionBuffer.length());
	}
}
catch(Exception e)
{
    //out.println("Exception in main try"+e.getMessage());
	e.printStackTrace();
}%>
</body>
</html>
<%!
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
	}
%>

