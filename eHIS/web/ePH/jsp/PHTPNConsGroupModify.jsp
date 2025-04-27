<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.sql.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" %><!-- java.sql.*, webbeans.eCommon.* added for  ML-MMOH-CRF-1126 -->
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
		//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
		  request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		  response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		  response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		  //ends
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%> 

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<!--     <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhMessages.js"></SCRIPT>-->
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TPNConsGroup.js"></SCRIPT>
<!--     <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>-->	
	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <SCRIPT>
//    function lockKey() {
//        if(event.keyCode == 93)
//            alert("Welcome to eHIS");
//    } dt:18/9/09---For online help
    </SCRIPT>
</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="FrmTPNConsGroup" id="FrmTPNConsGroup">
<%
    /* Mandatory checks start */
    String mode = request.getParameter( "mode" ) ;

	String gCode = request.getParameter( "gcode" ) ;
    String bean_id = "TPNConsGroupBean" ;
    String bean_name = "ePH.TPNConsGroupBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";

//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_TPN_CONSTITUENT_GROUP";
	String pkey_value			="";

	if ( mode == null || mode.equals("") )
        return ;
    if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
        return ;
  //added for ML-MMOH-CRF-1126 start
    Connection con			= null;
    con				= ConnectionManager.getConnection(request);
    
	boolean assesment_req_yn =CommonBean.isSiteSpecific(con,"PH","ASSESMENT_REQ_YN");
 //added for ML-MMOH-CRF-1126 end
    TPNConsGroupBean bean = (TPNConsGroupBean)getBeanObject( bean_id,bean_name,request) ;
	bean.setLanguageId(locale);
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	HashMap groupDetails=bean.getConsGroupDetails(gCode);
	String gName=(String)groupDetails.get("GNAME");
	String srlNo="";
	//added for ML-MMOH-CRF-1126 start
	String eff_status ="";
	String enable_checked = "";
	//added for ML-MMOH-CRF-1126 end
	if (groupDetails.containsKey("SRLNO"))
		srlNo=(String)groupDetails.get("SRLNO");
	else
		out.println("Error Occured"+gName);
	//Added for ML-MMOH-CRF-1126 - Start
	if(assesment_req_yn && groupDetails.containsKey("EFF_STATUS") ){
		eff_status = (String)groupDetails.get("EFF_STATUS");
		if(eff_status.equals("E"))
			enable_checked="checked";
	   else
		    enable_checked="";  
	} //Added for ML-MMOH-CRF-1126 - End

	/*-------------------------code added for showing audit log---------------------------*/
	//code for adding pk_values
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

<span style="position:absolute;top:130px;left:100px">
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
<td colspan='2'>&nbsp;&nbsp;<input type="text" name="gCode" id="gCode" maxLength=2 size=5 readonly value="<%=gCode%>" >
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
<td colspan='2'>&nbsp;&nbsp;<input type="text" name="gName" id="gName" maxLength=30 size=35  value="<%=gName%>" tabIndex=1>
	<img src="../../eCommon/images/mandatory.gif">
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td class="label">	<fmt:message key="ePH.DisplaySerialNo.label" bundle="${ph_labels}"/></td>
<td colspan='2' >&nbsp;&nbsp;<input type="text" name="srlno" id="srlno" maxLength=3 size=5 readonly value="<%=srlNo%>"></td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>

<%if(assesment_req_yn){ // Added for ML-MMOH-CRF-1126 - Start %>
	<tr>
<td align='right' class="label" >
       <fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
    </td>
	<td align='left' colspan='2' >&nbsp;&nbsp;<input type="checkbox" name="eff_status" id="eff_status" onclick="enableDisable(this)" value="<%=eff_status%>" <%=enable_checked%>></td>
	</tr>
	<%} // Added for ML-MMOH-CRF-1126 - End %>
<!-- added for ML-MMOH-CRF-1126 end -->
</TABLE>
</span>
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
</form>
<% putObjectInBean(bean_id,bean,request); %>
</body>
<script>document.getElementById("gName").focus();</script>
</html>

