<!DOCTYPE html>
<!--
Developed by    : Narasimhulu
CRF             : ML-MMOH-CRF-1126 US001
start date		: 02-05-2018
-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
    <!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<% 
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale = (String)session.getAttribute("LOCALE");
	
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TPNConsGroup.js"></SCRIPT>
    <script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <SCRIPT>
//    function lockKey() {
//        if(event.keyCode == 93)
//            alert("Welcome to eHIS");
//    } dt:18/9/09---For online help
    </SCRIPT>
</HEAD>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"><!-- onMouseDown="CodeArrest()" onKeyDown="lockKey()" -->
<form name="FrmTPNConsGroupCreate" id="FrmTPNConsGroupCreate">
<%
    /* Mandatory checks start */
    String mode = request.getParameter( "mode" ) ;

	String gCode = request.getParameter( "gcode" ) ;
    String bean_id = "TPNConsGroupBean" ;
    String bean_name = "ePH.TPNConsGroupBean";
	String log_bean_id		= "SetupAuditLogBean";
	String log_bean_name	= "ePH.SetupAuditLogBean";

//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_TPN_CONSTITUENT_GROUP";
	String pkey_value			="";

	if ( mode == null || mode.equals("") )
        return ;
    if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
        return ;

    TPNConsGroupBean bean = (TPNConsGroupBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	String srl_no=bean.getSrlNo();
	
	ArrayList Pk_values    =new ArrayList();
	Pk_values.add(gCode);      

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

<span style="position:absolute;top:130;left:100">
<TABLE align="center" cellspacing="0" cellpadding="0">
<tr>
<td class="label" colspan=2>&nbsp;</td>
<td align='right'><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">
<td>
</tr>
<tr>
<td class="label" width="40%">
	
	<fmt:message key="ePH.ConstituentGroupCode.label" bundle="${ph_labels}"/>

</td>
<td colspan='2'>&nbsp;&nbsp;<input type="text" name="gCode" id="gCode" maxLength=2 size=5  value="" onblur="startWithAlphabets(this);" onkeypress=" return allowAlphaNumeric(event);" > <!-- startWithAlphabets(this) and allowAlphaNumeric(event) Added for ML-MMOH-CRF-1266 [IN:068728] -->
<img src="../../eCommon/images/mandatory.gif">
</td>
<td>

</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
</tr>
<tr>
<td  class="label">	<fmt:message key="ePH.ConstituentGroupName.label" bundle="${ph_labels}"/></td>
<td colspan='2'>&nbsp;&nbsp;<input type="text" name="gName" id="gName" maxLength=30 size=35  value="">
<img src="../../eCommon/images/mandatory.gif">
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td class="label">	<fmt:message key="ePH.DisplaySerialNo.label" bundle="${ph_labels}"/></td>
<td colspan='2' >&nbsp;&nbsp;<input type="text" name="srlno" id="srlno" maxLength=2 size=5  readonly value="<%=srl_no%>" onBlur="CheckNum(this);">
<img src="../../eCommon/images/mandatory.gif">
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td >&nbsp;&nbsp;
				<input type="checkbox" name="eff_status" id="eff_status" value="E" checked >
			</td>
</tr>
</TABLE>
</span>
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
<script>document.getElementById("gCode").focus();</script>
</html>

