<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//Properties p = (Properties)session.getValue("jdbc");
//String locale	= (String) p.getProperty("LOCALE");
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script> 
<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCA/js/FlowSheetApplicability.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;

//String sql="";
//String insql="";
//String csql="";
String dsql="";
//String nextsql="";
//String shortdesc="";
String pat_class="";
//String summary="";
String mode="";
String m_pat_class="";
String m_special="";
String m_pctr="";
String m_summary="";
String m_pctrdesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String m_spldesc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
//String m_shortdesc="";
String disableTextButton = "";

mode=request.getParameter("mode");
mode=mode.trim();
pat_class=request.getParameter("pat_class");
String pat_class_mode=request.getParameter("patientClassId");
String speciality1=request.getParameter("spl");
String practioner1=request.getParameter("practr");
String lookup2=request.getParameter("lookup");
String patientClassidnew=request.getParameter("patientClassidnew");

String flow_sheet_id_mode=request.getParameter("flow_sheet_id_mode");
String practitioner_id_mode=request.getParameter("practitioner_id_mode");
String speciality_code_mode=request.getParameter("speciality_code_mode");


if(mode.equals("null")|| mode=="")
mode="insert";
if(mode.equals("insert"))
{
	if(m_special=="")
	m_special ="*ALL";
	if(m_pctr=="null");
	m_pctr ="*ALL";
}
m_pat_class=request.getParameter("pat_class");
m_summary=request.getParameter("summary");
if(mode.equals("modify")){
	
m_special=request.getParameter("spl");
m_pctr=request.getParameter("practr");
}
%>
<body  class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown="lockKey()" 
>
<form name="Assign" id="Assign" action="../../servlet/eCA.FlowSheetApplicabilityServlet" method="post" target="messageFrame"><BR>
<br><br><br><br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=3 width='60%' align=center>

<tr>
<td class=label ><fmt:message key="Common.practitionertype.label" bundle="${common_labels}"/> </td>
<% if(mode.equals("modify")){%>
<td class='fields'><input type=text name=patclass_del size=15 readonly value="<%=pat_class_mode%>"></td> 
<input type=hidden name=patclass_del2  value="<%=patientClassidnew%>">
<%}else {%>
<td class='fields'><select name='patclass' id='patclass' onChange="change()" 
<option value="*A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%

 //dsql="select PRACT_TYPE, nvl(DESC_USERDEF,DESC_SYSDEF) PRACT_TYPE_DESC FROM am_pract_type WHERE EFF_STATUS='E' ORDER BY SEQ_NO";
 dsql="select PRACT_TYPE, nvl(DESC_USERDEF,DESC_SYSDEF) PRACT_TYPE_DESC FROM am_pract_type WHERE EFF_STATUS='E' ORDER BY SEQ_NO";
 try
	{
 con =ConnectionManager.getConnection(request);
 stmt=con.prepareStatement(dsql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
 rs = stmt.executeQuery();
	
  while(rs.next()){
%>
<!-- <input type='hidden' name='patclass1' id='patclass1' value="<%=rs.getString(1)%>"> -->
 <option value=<%=rs.getString(1)%>><%=rs.getString(2)%></option>
	<%}%>
	</select></td>
	 <%
}
	catch (Exception e) {
	//	out.println("Exception in FlowSheetApplicabilityIntermediate.jsp:"+e.toString());//COMMON-ICN-0181
	    e.printStackTrace();//COMMON-ICN-0181
	}finally{
		if(rs !=null)rs.close();
		if(stmt!=null)stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}	 
 
 }
 
 %>
<tr><td colspan=2 ></td></tr>
<tr>
<td class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
	 <td class='fields'>
<% if(mode.equals("modify")){%>

	 <input type=text name=speciality_del readonly  size=30 value="<%=speciality1%>">
		  <input type=hidden name=speciality_code_mode  value="<%=speciality_code_mode%>">
	 
<%}else {%>
<input type="text" name="speciality" id="speciality"  value="<%=m_spldesc%>"   size = '15' maxlength='20' <%=disableTextButton%> OnChange = 'setValueSpecialty();resetValues();' onBlur='showSpecialtyWindow(this);'  onKeyPress='return enableSearch(event);'><input type="button" value="?" <%=disableTextButton%> class="button" onClick='resetValues();showSpecialtyWindow(this);' name='searchspl'>
<%}%>
<input type='hidden' name='spl' id='spl' value="<%=m_special%>" 
size="4" maxlength="4">
</td>
</tr>
<tr><td colspan=2 ></td></tr>
<tr>
<td class=label ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
<td class='fields'>
<% if(mode.equals("modify")){%>
<input type=text name=pctr_del size=30 readonly value="<%=practioner1%>">
<input type=hidden name=practitioner_id_mode  value="<%=practitioner_id_mode%>">
<%}else {%>
<input type="text" name="pctr" id="pctr" value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")%>';  maxlength='20' size = '15' <%=disableTextButton%>  OnChange='setValue();resetValues();' onBlur='showPract(this);' onKeyPress='return enableSearch1(event);'   ><input type="button" value="?" <%=disableTextButton%> class="button" onClick='resetValues();showPract(this);' name='searchsp2'>
<%}%>
<input type='hidden' name='practitioner' id='practitioner' value="<%=m_pctr%>" size="15" maxlength="15" >
</td>
</tr>
<%
if(mode.equals("modify"))
{%>
<script>
//document.forms[0].pctr_del.value="<%=m_pctrdesc%>";
//document.forms[0].speciality_del.value="<%=m_spldesc%>";
//parent.document.getElementById("assignChart").rows = "42,*,235,50";
    parent.document.getElementById("commontoolbarFrame").style.height="8vh";
	parent.document.getElementById("f_query_add_mod").style.height="39vh";
	parent.document.getElementById("f_query_add_mod_display").style.height="45vh";
	parent.document.getElementById("messageFrame").style.height="9vh";
</script>
<%
}
%>
<tr><td colspan=2 ></td></tr>
<tr>
<td class=label ><fmt:message key="eCA.FlowSheet.label" bundle="${ca_labels}"/></td>
<td class='fields'>
<% if(mode.equals("modify")){%>
<input type=text name=lookup_del size=20 readonly value="<%=lookup2%>">
<input type=hidden name=flow_sheet_id_mode  value="<%=flow_sheet_id_mode%>">
<%}else {%>

<input type="text" name="lookup" id="lookup"   maxlength='20' size = '15' <%=disableTextButton%>  OnChange='setValue();resetValues();' OnKeyPress='return CheckForSpecCharsWithSpaceBlur(this)'   onBlur='checkFlow(this);'><input type="button" value="?" <%=disableTextButton%> class="button" onClick='resetValues();checkFlow(this);' name='searchsp2'>
<img src='../../eCommon/images/mandatory.gif'>
<%}%>

<input type='hidden' name='flowsheet1' id='flowsheet1'">
</td>
</tr>
</table>
<input type=hidden name=mode value="<%=mode%>">
<input type=hidden name='old_pat_class' id='old_pat_class' value="<%=m_pat_class%>">
<input type=hidden name='old_specialty' id='old_specialty' value="<%=m_special%>">
<input type=hidden name='old_practitioner' id='old_practitioner' value="<%=m_pctr%>">
<input type=hidden name='flag' id='flag' value="false">
<input type=hidden name='flagSpecialty' id='flagSpecialty' value="false">
</form>
</body>
</html>

