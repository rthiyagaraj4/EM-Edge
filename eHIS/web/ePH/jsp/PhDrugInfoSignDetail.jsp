<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*, java.io.*,ePH.*,ePH.Common.*,oracle.jdbc.driver.*,eCommon.Common.*,java.text.*,java.net.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
    <script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
    <script language="JavaScript" src="../js/PhDrugInfo.js"></script>
	<script language="javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<%
	String sysdate = "";
	String bean_id			= "PhDrugInfoEnqBean" ;
	String bean_name		= "ePH.PhDrugInfoEnqBean";

	PhDrugInfoEnqBean bean = (PhDrugInfoEnqBean)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);
	sysdate = bean.getSysdate();
	String login_by_name= (String)session.getValue( "login_user" );

%>
<TITLE><fmt:message key="ePH.DrugInfoEnqSign.label" bundle="${ph_labels}"/></TITLE>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0" >
<form name=DrugInfoSignedBy>
<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="buttontable">
<tr height="8"><td colspan="6" ></td></tr>
<tr>
<td class="label" colspan="5"><fmt:message key="ePH.VerifyRemarks.label" bundle="${ph_labels}"/></td>
</tr>
<tr>
<td  colspan='5'  class="label"> <textarea name="verify_remarks" value="fg" size="1000" maxlength="1000" rows='6' cols='60' onblur="validmaxlength(this);"></textarea></td>
</tr>
<tr>
<td class="label" colspan="3"><fmt:message key="ePH.SignedBy.label" bundle="${ph_labels}"/></td>
<td class="label" colspan="3">
<input type=text name="SignedBy" id="SignedBy" value="<%=login_by_name%>" readonly    size='15'> <!-- <input valign="top" type=button name="user_search" id="user_search" class="button" value="?" onBlur="checkUser1(this.value)" onClick="searchUserNames1(SignedBy)"></input> --><INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>">
</td>
</tr>
<tr height="8"><td colspan="6" ></td></tr>
<tr>
<td class="label" colspan="3"><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/></td>
<td class="label" colspan="3">
<input type=text name="DateTime" id="DateTime" value="<%=sysdate%>" size=15 align="left" readonly>

</td>
</tr>
<tr height="8"><td colspan="6" ></td></tr>
<tr>
<td class="label" colspan="6">
<input type="button" value="OK" name='btnOK' id='btnOK' class="button" onclick="setSignedBy(SignedBy,DateTime,verify_remarks,'<%=bean_id%>','<%=bean_name%>');parent.document.getElementById('dialog-body').contentWindow.returnValue='OK';parent.document.getElementById('dialog_tag').close(); "></input>
<input type="button" name="btnCancel" id="btnCancel" value="Cancel" class="button" onclick="parent.document.getElementById('dialog_tag').close();"></input>
</td>
</tr>
<tr height="8"><td colspan="6" ></td></tr>

</table>
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">
</form>
</body>

<% putObjectInBean(bean_id,bean,request); %>
</html>




