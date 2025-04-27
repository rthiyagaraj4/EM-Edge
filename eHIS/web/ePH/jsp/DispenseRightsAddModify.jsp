<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DispenseRights.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<SCRIPT>
			var function_id = "<%= request.getParameter( "function_id" ).trim() %>"
		</SCRIPT>
	</HEAD>
<%
	/* Mandatory checks start*/
	String mode			= request.getParameter("mode") ;
	String bean_id		= "DispenseRightsBean" ;
	String bean_name	= "ePH.DispenseRightsBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_DISP_RIGHTS";
	String pkey_value			="";
	String user_profile_disable="";//added for GDOH-CRF-0086 [IN:058551]
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	DispenseRightsBean bean = (DispenseRightsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	/* Initialize Function specific end */
%>
	<BODY onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<FORM name="formDispenseRights" id="formDispenseRights">
			<TABLE CELLPADDING="1" CELLSPACING="0" WIDTH="95%" ALIGN="center" BORDER="0">
			<TR>
				<TD CLASS="label" WIDTH="20%"><fmt:message key="Common.user.label" bundle="${common_labels}"/>&nbsp;</TD>
<%
				if( mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")) ) {
%>
						<TD WIDTH="55%">
							<INPUT TYPE="text" name="USER_NAME" id="USER_NAME" MAXLENGTH="30" SIZE="40" VALUE="" onBlur="checkUser(this.value)"><INPUT TYPE="button" name="USER_SEARCH" id="USER_SEARCH" CLASS="button" VALUE="?" onClick="searchUserNames(USER_NAME)">
							<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG>
							<INPUT TYPE="hidden" name="SQL_PH_DISP_RIGHTS_SELECT1" id="SQL_PH_DISP_RIGHTS_SELECT1" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_DISP_RIGHTS_SELECT1") %>">
							<INPUT TYPE="hidden" name="USER_ID" id="USER_ID" VALUE="">
						</TD>
						<TD  WIDTH="25%">
							<INPUT TYPE="button" name="USER_PROFILE" id="USER_PROFILE" CLASS="button" VALUE='<fmt:message key="ePH.UserProfile.label" bundle="${ph_labels}"/>' DISABLED onClick="callUserDetails()">&nbsp;
						<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG>
						</TD>
					</TR>
					<TR>
						<TD CLASS="label" WIDTH="20%"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<TD COLSPAN="2">
							<SELECT name="DISP_LOCN" id="DISP_LOCN" onchange="loadDetails('1', this)">
								<OPTION VALUE="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</OPTION>
<%
								ArrayList dispLocns = bean.getDispLocns();
								for (int i=0; i<dispLocns.size(); i+=2) {
%>
									<OPTION VALUE="<%= dispLocns.get(i) %>"><%= dispLocns.get(i+1) %></OPTION>
<%
								}
%>
							</SELECT><IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG>
<%
					}
					else if( mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) ) {
						String userID	= request.getParameter("userid");
						String userName	= request.getParameter("username");
						String locnCode	= request.getParameter("locncode");
						String locnDesc	= request.getParameter("locndesc");
						String loginUserId = bean.getLoginById();//added for GDOH-CRF-0086 [IN:058551]
						/*-------------------------code added for showing audit log---------------------------*/
						//code for adding pk_values
						ArrayList Pk_values    =new ArrayList();

						if(!userID.equals(loginUserId))//added for GDOH-CRF-0086 [IN:058551]
							user_profile_disable = "disabled";
							
						Pk_values.add( (String)session.getValue("facility_id"));      
						Pk_values.add( locnCode.trim());      
						Pk_values.add( userID.trim());      

						String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
						if(display_audit_log_button_yn.equals("Y")){
							audit_log_visible= "visibility:visible";
							pkey_value       = (String)log_bean.getpk_value();
						}
						else{
							audit_log_visible= "visibility:hidden";
							pkey_value="";
							log_bean.clear();
						}
						/*--------------------------------------ends here---------------------------------------*/
%>
						<TD WIDTH="45%">
							<INPUT TYPE="text" name="USER_NAME" id="USER_NAME" MAXLENGTH="30" SIZE="40" VALUE="<%= userName %>" READONLY><INPUT TYPE="button" name="USER_SEARCH" id="USER_SEARCH" CLASS="button" VALUE="?" DISABLED>
							<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG>
							<INPUT TYPE="hidden" name="USER_ID" id="USER_ID" VALUE="<%= userID %>">
						</TD>
						<TD WIDTH="45%">
							<INPUT TYPE="button" name="USER_PROFILE" id="USER_PROFILE" CLASS="button" VALUE='<fmt:message key="ePH.UserProfile.label" bundle="${ph_labels}"/>' onClick="callUserDetails()" <%=user_profile_disable %>>			&nbsp;&nbsp;&nbsp;<INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"><%-- 							added user_profile_disable for GDOH-CRF-0086 [IN:058551] --%>
						</TD>
					</TR>
					<TR>
						<TD CLASS="label" WIDTH="20%"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/>&nbsp;</TD>
						<TD COLSPAN="2">
							<INPUT TYPE="hidden" name="DISP_LOCN" id="DISP_LOCN" VALUE="<%= locnCode %>">
							<INPUT TYPE="text" name="DISP_LOCN_DESC" id="DISP_LOCN_DESC" MAXLENGTH="30" SIZE="42" VALUE="<%= locnDesc %>" READONLY>
							<IMG SRC="../../eCommon/images/mandatory.gif" ALIGN=center></IMG>
							<SCRIPT>loadDetails('2', '')</SCRIPT>
<%
					}
%>
					</TD>
				</TR>
			</TABLE>
			<INPUT TYPE="hidden" name="mode" id="mode" VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="bean_id" id="bean_id" VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name" VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
			<INPUT TYPE="hidden" name="user_pass" id="user_pass" VALUE="">

		</FORM>
	</BODY>
</HTML>
<%
putObjectInBean(bean_id,bean,request);
%>

