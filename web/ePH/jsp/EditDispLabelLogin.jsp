<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
	    request.setCharacterEncoding("UTF-8");
    	String locale			= (String)session.getAttribute("LOCALE");
	
        String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		 <script language="javascript" src="../../eCommon/js/common.js"></script>
		<script LANGUAGE="javascript" SRC="../../ePH/js/EditDispLabel.js"></SCRIPT>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
		<title><fmt:message key="ePH.EditDispenseLabelLogin.label" bundle="${ph_labels}"/></title>
	</HEAD>
<%
	
	String facility_id		= (String) session.getValue( "facility_id" );

	String bean_id = "EditDispLabelBean" ;
	String bean_name = "ePH.EditDispLabelBean";
	EditDispLabelBean bean = (EditDispLabelBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	ArrayList disp_locs = bean.getDispLocs(facility_id.trim());
	String homepage			= request.getParameter("homepage")==null?"":request.getParameter("homepage"); //Added for Bru-HIMS-CRF-073 [IN:029939] -start
	String store_code			= request.getParameter("store_code")==null?"": request.getParameter("store_code"); 
	String disableDispLocn="";
%>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onload="focusOnPasswordField('Y')">
		<form name="frmEditDispLabelLogin" id="frmEditDispLabelLogin">
			<table cellpadding="0" cellspacing="0" width="101%" align="center" border="0" >
				
				<tr><td colspan="2">&nbsp;</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.username.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
						<input type="user_name" name="user_name" id="user_name" size="55" maxlength="60" value="<%=bean.getUserName()%>" readOnly>
					</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="Common.password.label" bundle="${common_labels}"/></td>
					<td>&nbsp;&nbsp;
						<input type="password" name="password" id="password" size="55" maxlength="60" value=""  onKeyPress="uppercase()"  autocomplete="off"> <!--41741 autocomplete="off"-->
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>

				<tr>
					<td  class="label"><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td >&nbsp;&nbsp;
						<select name="disp_locn" id="disp_locn" <%=disableDispLocn%>>
						<option value="" >--<fmt:message key="Common.Select.label" bundle="${common_labels}"/>--</option>
<%
						for(int i=0; i<disp_locs.size();i=i+2){
							if(store_code.equals((String)disp_locs.get(i))){
%>
								<option value="<%=disp_locs.get(i)%>" selected><%=disp_locs.get(i+1)%></option>	
<%
							}
							else{
%>
								<option value="<%=disp_locs.get(i)%>" ><%=disp_locs.get(i+1)%></option>	
<%
							}
						}
%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>	
				</tr>

				<tr>
					<td  colspan="2" class="white" align="right">
						<input type="button" class="BUTTON" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onClick="showQueryCriteria()">	
						<input type="button" class="BUTTON" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="goHome()">&nbsp;&nbsp;&nbsp;
					</td>	
				</tr>
			</table>
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		</form>
	</body>

</html>

<%
putObjectInBean(bean_id,bean,request);
%>

