<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*, java.io.*,ePH.*,ePH.Common.*,eCommon.Common.*,java.text.*,java.net.*,webbeans.eCommon.*" %>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<% 
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>
		<Title><fmt:message key="ePH.ADRSign.label" bundle="${ph_labels}"/></Title>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" SRC="../../eCommon/js/CommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<script language="JavaScript" src="../js/ADRReporting.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	String  sysdate			= "";
	String	bean_id			=	"ADRReport" ;
	String	bean_name		=	"ePH.ADRReportBean";
	String  locale			= (String)session.getAttribute("LOCALE");
	
	ADRReportBean bean		= (ADRReportBean)getBeanObject(bean_id,bean_name ,request);
	sysdate					= bean.getSysdate();
	bean.setLanguageId(locale);
	String appl_user_id		=  "";
	String appl_user_name	=  "";
	String p_user_name		= (String) session.getValue( "login_user" ) ;	
	ArrayList result		= bean.checkToProceed(p_user_name.trim());


	if(result.size()>0) {
		appl_user_id	=(String) result.get(0);
		appl_user_name	=(String) result.get(1);
	}
	else{
		appl_user_id	="";
		appl_user_name	="";
	}
	//Added by Jyothi.G on 01/10/2010 to fix IN024115
	sysdate = com.ehis.util.DateUtils.convertDate(sysdate,"DMYHM","en",locale);
	//End
%>
	<TITLE><fmt:message key="ePH.ADRSign.label" bundle="${ph_labels}"/></TITLE>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" topmargin="0" >
		<form name=AdrReportingSignedBy>
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0" id="buttontable">
				<tr height="8"><td colspan="6" ></td></tr>
				<tr>
					<td align="right" class="label" colspan="3"><fmt:message key="ePH.SignedBy.label" bundle="${ph_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td align="left" class="label" colspan="3">

					<input type=text name="SignedBy_1" id="SignedBy_1" value="<%=appl_user_name%>"   size=15 onchange='checkSignedByEmpty(SignedBy_1)'>
					<input valign="top" type=button name="user_search" id="user_search" class="button" value="?" onClick="searchUserNames1(SignedBy)"></input>
					<img align='center' src ='../../eCommon/images/mandatory.gif'></img><!-- code added for HSA-CRF-0005[40601] -->
					<INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>">
					<INPUT TYPE="hidden" name="SignedBy" id="SignedBy" VALUE="<%=appl_user_id%>">
					</td>
				</tr>
				<tr height="4"><td colspan="6" ></td></tr>
				<tr>
					<td align="right" class="label" colspan="3"><fmt:message key="Common.Date/Time.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
					<td align="left" class="label" colspan="3">
					<input type=text name="DateTime" id="DateTime" value="<%=sysdate%>" size=15 align="left" readonly>
					</td>
				</tr>
				<tr height="8"><td colspan="6" ></td></tr>
				<tr>
					<td align="center" class="label" colspan="6">
					<input type="button" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>'
					 name='btnOK' class="button" onclick="setSignedBy(SignedBy,DateTime,'<%=bean_id%>','<%=bean_name%>');"></input>
					<input type="button" name="btnCancel" id="btnCancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>'class="button" onclick="parent.document.getElementById('dialog-body').contentWindow.returnValue = 'CANCEL'; parent.document.getElementById('dialog_tag').close();"></input>
					</td>
				</tr>
			</table>
		<input type="hidden" name="locale" id="locale" value="<%=locale%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"	value="<%=bean_name%>">

		</form>
	</body>
</html>
<% 
	putObjectInBean(bean_id,bean,request);
%>

