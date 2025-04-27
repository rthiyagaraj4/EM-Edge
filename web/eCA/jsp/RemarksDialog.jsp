<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import="eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />

<script language='javascript' src='../../eCA/js/DisDataCharting.js'></SCRIPT>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String resComments	= request.getParameter("resultStr")==null?"":request.getParameter("resultStr");
	String locale	= request.getParameter("locale")==null?"":request.getParameter("locale");
	String disabled	= request.getParameter("disabled")==null?"":request.getParameter("disabled");
	String allDia=request.getParameter("allDia")==null?"N":request.getParameter("allDia");
	String disVar=request.getParameter("disVar")==null?"":request.getParameter("disVar");

	if(disabled.equals("y"))
		disabled="disabled";
	else
		disabled="";

	String modal_title	= request.getParameter("modal_title")==null?"":request.getParameter("modal_title");

	if( resComments == null) resComments="";

	//resComments = resComments.replaceAll("<br>","\n");	

   

	
	if( modal_title == null) modal_title="Result";
%>

<% if (disVar.equals("�")){ %>
		<title><fmt:message key="eCA.ReplaceRemarks.label" bundle="${ca_labels}"/></title>
<%}else{%>
	<title><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></title>
<%}%>

</head>
<style>
textarea {
  resize: none;
}
</style>
<BODY  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form>
<center>	
	<tr><td>
	<table width='100%' border='0' cellspacing='0' cellpadding='3' align=center>
	<tr><td class='label'>
	<% if (disVar.equals("�")){ %>
		<fmt:message key="eCA.ReplaceRemarks.label" bundle="${ca_labels}"/>	
<%}else{%>
			<fmt:message key="Common.ErrorRemarks.label" bundle="${common_labels}"/>
			
<%}%>
</td></tr>
	<tr>
		<td class='fields'><textarea cols='45' rows='11' name="comments" size=60 maxlength=60  value='' <%=disabled%> onkeyPress = 'checkMaxLimit(this,60)' ><%=resComments%></textarea>
		<% //if(!allDia.equals("Y")){ %>
		<img src='../../eCommon/images/mandatory.gif' ></td>
		<% //} %>
	</tr>
	<tr></tr>
	<tr style= "text-align: right;"><td  class='button'>
	<% if(!allDia.equals("Y")){ %>
		<input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>'onclick='doClose()'>
		</td>
		</tr>
	<% }else{ %>
		<input type='Button' class='Button' name='Ok' id='Ok' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")%>' onclick='doCloseAllergyDianosis();'>
		<input type=button class=button value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>' onclick='doCloseAllergyDianosisRemark();' >
		</td>
		</tr>
	<% } %>

	
</table></td></tr></table>
<input type=hidden name=locale value='<%=locale%>'>
<input type=hidden name=resComments value='<%=resComments%>'>
</center>
 <!-- <input type='text' name="cancelval" id="cancelval" size=60 maxlength=60 value='<%=resComments%>' class='fields'>
<input type='text' name="dummyvalue" id="dummyvalue" size=60 maxlength=60 value='a1234567890' class='fields'>  -->
</form>
</body>
</html>

