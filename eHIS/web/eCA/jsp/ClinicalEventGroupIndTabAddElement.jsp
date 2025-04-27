<!DOCTYPE html>
<%@ page import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="EventBean" class="webbeans.eCommon.RecordSet" scope="session"/>
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
		
		<script language='javascript' src='../../eCA/js/ClinicalEventGroup.js'></script>

<body OnMouseDown='CodeArrest()' onLoad='' onKeyDown = 'lockKey()'>
<%
	String mode="";
	String contr="";
	String groupcode="";
	String shortdesc="";
	String clearvalue="";
//	String mand_status="";
	String disp_status="";
	
	String value="Add";
	String title=" Add New Event Group";
	String serailno="";
	String flag="";
	String from="";

	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");
	serailno=(request.getParameter("srno")==null)?"":request.getParameter("srno");
	mode=(request.getParameter("mode")==null)?"":request.getParameter("mode");
	//out.println("<script>alert('modechk"+mode+"')</script>");
	//out.println("<script>alert('flag"+flag+"')</script>");
	//out.println("<script>alert('flag"+flag+"')</script>");
	contr=(request.getParameter("contr")==null)?"":request.getParameter("contr");
	groupcode=(request.getParameter("groupcode")==null)?"":request.getParameter("groupcode");
	shortdesc=(request.getParameter("shortdesc")==null)?"":request.getParameter("shortdesc");
	clearvalue=(request.getParameter("clearvalue")==null)?"":request.getParameter("clearvalue");
	flag=(request.getParameter("flag")==null)?"":request.getParameter("flag");
	from=(request.getParameter("from")==null)?"":request.getParameter("from");
    if(from.equals("criteria"))
	EventBean.clearAll();
		

		if(flag.equals("frompanel"))
		{
			
			 disp_status ="readonly";
			 value="Modify";
			 title="Modify Exisiting Event Group";
			 
		}
		else
		{
			value="Add";
			title="Add New Event Group";
		}
		

%>
<form name='ClinicalEventGroupAddElementForm' id='ClinicalEventGroupAddElementForm'  >

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
<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr>
<%
if(!flag.equals("frompanel"))
{
%>
<tr>
   
		<td class=label align='right' width='25%' nowrap>Contr System</td>
		<td align=left>&nbsp;&nbsp;<select name='contr' id='contr'  onchange=''>
		<option value="">------------Select-------------</option>
        </select>
        </td>
</tr>
<%}else{%>
<tr>
   
		<td class=label align='right' width='25%' nowrap>Contr System</td>
		<td align=left>&nbsp;&nbsp;<input type='text' name="contr" id="contr" value="<%=contr%>" size='10' maxlength='10' onKeyPress="return CheckForSpecChars(event)" onBlur="" <%=disp_status%>>
        
		</td>
</tr> 
<%}%>
<tr>
	<td   align='right' class='label' >Event Group</td>
	<td  align='left'>&nbsp;&nbsp;<input type='text' name="groupcode" id="groupcode" value="<%=groupcode%>" size='15' maxlength='20' onKeyPress="return CheckForSpecChars(event)" onBlur="" <%=disp_status%>><input type="button" value="?" class="button" onClick="callGroup()" name='search' id='search'>
	</td>
	</tr>
<!-- 	
	<tr>
	<td >&nbsp;</td>
	<td >&nbsp;</td>
	
</tr> -->
<tr>
	<td  align='right' class='label'>Short Desc</td>
	<td  align='left'>&nbsp;&nbsp;<input type='text'  name='shortdesc' id='shortdesc' size="15" maxlength="20" value="<%=shortdesc%>" <%=disp_status%>>
	</td>
</tr>


	<tr >
	<td>&nbsp;</td>
	<td >&nbsp;&nbsp;
	<%if(!flag.equals("frompanel")){%>
	<input type='button' name='add' id='add' value='<%=value%>' class='button' onClick='addEventGroup()'>
	<%}%>
	<input type='button' name='clear' id='clear' value='Clear' class='button' onClick=' clearFields()' >
	<input type='button' name='clear' id='clear' value='Delete' class='button' onClick=' deleteRecord()' >
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
<input type='hidden' name='delval' id='delval' value='<%=serailno%>' >


</form>
</body>
<%if(!flag.equals("frompanel")){%>
<script>populateCntrSys(parent.criteria.document.EventIndTabCriteriaForm.histype)</script>
<%}%>
</html>


