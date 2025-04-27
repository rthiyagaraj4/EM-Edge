<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<jsp:useBean id="associateDiagBean" class="webbeans.eCommon.RecordSet" scope="session"/>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script language='javascript' src='../../eCA/js/ClinicalRepMast.js'></script>


<%
	String mode="";
	String id="";
	String desc="";
	String event_code="";
	String clearvalue="";
	String flag="";
	String value="Add";
	String title=" Add New Contributing Event";
	
	id=(request.getParameter("ID")==null)?"":request.getParameter("ID");
	desc=(request.getParameter("Desc")==null)?"":request.getParameter("Desc");
	event_code=(request.getParameter("event_code")==null)?"":request.getParameter("event_code");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");
	if(flag.equals("frompanel"))
    {
%>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' >
	<%}else{%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' onLoad="contrsystempop1()">
	<%}%>
<form name='ClinicalRepMastAssocLink_form' id='ClinicalRepMastAssocLink_form'  >

<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>

<tr><td class='CAGROUP 'align=center><b><font size='2' ><%=title%></b></td></tr> </table>

<table border='0' cellpadding='0' cellspacing='0' width='99%' align='center'>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>

<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
<%if(flag.equals("frompanel"))
{%>
<tr>
	<td  align='right' class='label' >Contr System </td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='contr_system' id='contr_system' value="<%=id%>"   size="30" maxlength="30" onBlur="makeValidString(this)"" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<%}else{%>
<tr>
<td  align='right' class='label'> Contr System</td>
<td align='left'>&nbsp;&nbsp;<select name='contr_system' id='contr_system' >
		<option value="">-----------Select------------</option>
		</select>

</tr>
<%}%>	
<!-- <tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr> -->
	<tr>
	    <td  class=label align=right>Event Code</td>
		<td>&nbsp;
		<input type="text" name="event_code" id="event_code" size="10" maxlength="20" value="<%=event_code%>" onblur='callforPrompt(this)'><input type="button" value="?" class="button" onClick="getEventId()" name='search' id='search'  >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' name='mand2'></img>
		</td>
</tr>
<tr>
	<td  align='right' class='label' >Description </td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='short_desc' id='short_desc' value="<%=desc%>"   size="30" maxlength="30" onBlur="makeValidString(this)"" >
	<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
</tr>
<!-- 	
	<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr> -->
	<tr >
	<td>&nbsp;</td>
	<td >&nbsp;&nbsp;
	<input type='button' name='add' id='add' value='<%=value%>' class='button' onClick='addEvents() '>
	<input type='button' name='clear' id='clear' value='Clear' class='button' onClick=' clearFields()' >
	<br>
	<br>
	<br>
	<br>
	<br>
	
	</td>
	</tr>
		

<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>

</tr>
</table>
<input type='hidden' name='mode' id='mode' value='<%=mode%>' >
<input type='hidden' name='code' id='code' value='frompanel' >
<input type='hidden' name='disp_flag' id='disp_flag' value='<%=flag%>' >
<input type='hidden' name='clearvalue' id='clearvalue' value='<%=clearvalue%>' >
<input type='hidden' name='event_code1' id='event_code1' value='getEventId()' >
<input type='hidden' name='contr_system1' id='contr_system1' value='' >

</form>
</body>
</html>

<%
/*if(mode.equals("insert")&& !flag.equals("frompanel"))
{
	associateDiagBean.clearAll();
}*/

%>

