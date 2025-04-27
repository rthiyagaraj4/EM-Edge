<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<% 	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
/** added by kishore kumar n on 08/12/2009  */
String imgUrl="";

if(sStyle.equals("IeStyle.css"))
{
imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
}
/** ends here*/

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js"	language="javascript"></script>
<script src="../../eCommon/js/common.js"			language="javascript"></script>
<script src='../../eCommon/js/CommonLookup.js'		language=javascript   ></script>
<script src="../../eCA/js/AssignChartSumm.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<%
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
String sql="";
String insql="";
String csql="";
String dsql="";
String nextsql="";
String shortdesc="";
String pat_class="";
String summary="";
String mode="";
String m_pat_class="";
String m_special="";
String m_pctr="";
String m_summary="";
String m_pctrdesc=
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String m_spldesc=
com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
String m_shortdesc="";
String disableTextButton = "";

mode=request.getParameter("mode");
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
<body  class='CONTENT' OnMouseDown="CodeArrest()"  onKeyDown="lockKey()" 
Onload ="disableSummary(document.Assign.summary);getValueSpecialty();">
<form name="Assign" id="Assign" action="../../servlet/eCA.AssignChartSummServlet" method="post" target="messageFrame">
<table border=0 cellspacing=0 cellpadding= "1" width= "65%" align=center>

<tr>
<td class='label' ><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
<td class='fields'><select name='patclass' id='patclass' onChange="change()" <%if(mode.equals("modify")){%> disabled <%}%>>
<option value="*A"><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
try
{
con =ConnectionManager.getConnection(request);
if(mode.equals("modify"))
	{
	disableTextButton = " disabled ";
	   insql="select SHORT_DESC from AM_PATIENT_CLASS where PATIENT_CLASS= ? ";

stmt=con.prepareStatement(insql);
stmt.setString(1,m_pat_class);
rs = stmt.executeQuery();
if(rs.next())
{
	 m_shortdesc=rs.getString(1);
}//while
csql="SELECT short_desc from am_speciality WHERE speciality_code= ? ";
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();
stmt=con.prepareStatement(csql);
stmt.setString(1,m_special);
rs = stmt.executeQuery();
if(rs.next())
{
	 m_spldesc="";
	 m_spldesc=rs.getString(1);
	
}//if
dsql="SELECT short_name FROM am_practitioner where practitioner_id=? and eff_status='E' ";
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();
stmt=con.prepareStatement(dsql);
stmt.setString(1,m_pctr);
rs = stmt.executeQuery();
if(rs.next())
{
	  m_pctrdesc="";
	 m_pctrdesc=rs.getString(1);
}//while
//out.println("Desc="+m_pctrdesc);
}//if modify mode
sql="select SHORT_DESC,PATIENT_CLASS from AM_PATIENT_CLASS order by SHORT_DESC";
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();
stmt=con.prepareStatement(sql);
rs = stmt.executeQuery();
while(rs.next())
{
	 shortdesc=rs.getString(1);
	pat_class=rs.getString(2);
if(pat_class.equals(m_pat_class))
out.println("<option value='"+m_pat_class+"' selected>"+m_shortdesc+"</option>");
	else 
	out.println("<option value='"+pat_class+"'>"+shortdesc+"</option>");
}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
/* modified }//try
catch(Exception e)
	{
		out.println("Exception in AssignChartSumm.jsp: "+e.toString());
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	} */
%>
</select>
</td>
</tr>
<tr>
<td class=label ><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
<td class='fields'><input type="text" name="speciality" id="speciality"  value="<%=m_spldesc%>"   size = '15' maxlength='20' <%=disableTextButton%> OnChange = 'resetValues();setValueSpecialty()' onBlur='checkSpl(this);' onKeyPress='return enableSearch(event);'   ><input type="button" value="?" <%=disableTextButton%> class="button" onClick='resetValues();checkSpl(this);' name='searchspl'>&nbsp;
<input type='hidden' name='spl' id='spl' value="<%=m_special%>" 
size="4" maxlength="4">
</td>
</tr>
<tr>
<td class='label' ><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
<td class='fields'>
<input type="text" name="pctr" id="pctr" value="<%=m_pctrdesc%>"  maxlength='20' size = '15' onBlur='showPctr(this);'   onKeyPress='return enableSearch1(event);' OnChange = 'resetValues();' <%=disableTextButton%>  ><input type="button" value="?" <%=disableTextButton%> class="button" onClick='resetValues();showPctr(this);' name='searchsp2'>&nbsp;
<input type='hidden' name='practitioner' id='practitioner' value="<%=m_pctr%>" size="15" maxlength="15" >
</td>
</tr>
<%
if(mode.equals("modify"))
{%>
<script>
document.forms[0].pctr.value="<%=m_pctrdesc%>";
document.forms[0].speciality.value="<%=m_spldesc%>";
</script>
<%
}
%>
<script>
	// parent.document.getElementById("assignChart").rows = "25,90,235,20";
	//document.getElementById('assignChart').setAttribute('rows', '25,90,235,20');
		parent.document.getElementById("commontoolbarFrame").style.height="8vh";
		parent.document.getElementById("f_query_add_mod").style.height="20vh";
		parent.document.getElementById("f_query_add_mod_display").style.height="62vh";
		parent.document.getElementById("messageFrame").style.height="8vh";
</script>

<tr>
<td class='label' ><fmt:message key="Common.Summary.label" bundle="${common_labels}"/></td>
<td class='fields'><select name='summary' id='summary' onChange="disableSummary(this)">
<option value="">------------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------------</option>
<%
/* modified try
{
con =	ConnectionManager.getConnection(request); */

nextsql="select DISTINCT  SUMMARY_DESC, SUMMARY_ID from CA_CHART_SUMM_HEADER WHERE EFF_STATUS='E' order by SUMMARY_DESC ";
 stmt=null;
 rs=null;
stmt=con.prepareStatement(nextsql);
rs = stmt.executeQuery();
while(rs.next())
{
	summary="";
	summary=rs.getString(2);
	if(summary.equals(m_summary))
	out.println("<option value='"+m_summary+"' selected>"+rs.getString(1)+"</option>");
	else
	out.println("<option value='"+summary+"'>"+rs.getString(1)+"</option>");
}//while
%>
<%
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
}//try
catch(Exception e)
	{
		//out.println("Exception in AssignChartSumm.jsp: "+e.toString());//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		if(con != null)ConnectionManager.returnConnection(con,request);
	} 
%>
</select>
<img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>
</table>
<!-- added by kishore kumar n on 08/12/2009  -->
<%if(!imgUrl.equals("")){ %>
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>
<!--ends here -->
<input type=hidden name=mode value="<%=mode%>">
<input type=hidden name='old_pat_class' id='old_pat_class' value="<%=m_pat_class%>">
<input type=hidden name='old_specialty' id='old_specialty' value="<%=m_special%>">
<input type=hidden name='old_practitioner' id='old_practitioner' value="<%=m_pctr%>">
<input type=hidden name='flag' id='flag' value="false">
<input type=hidden name='flagSpecialty' id='flagSpecialty' value="false">
</form>
</body>
</html>

