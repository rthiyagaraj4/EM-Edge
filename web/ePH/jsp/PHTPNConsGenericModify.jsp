<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page import="webbeans.eCommon.ConnectionManager,java.sql.Connection"%> <!--Added for ML-MMOH-CRF-1126 -->
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
   <!--  <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
   <%
   request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

    <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
    <!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
    <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
   <!--  <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhMessages.js"></SCRIPT> -->
    <SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/TPNConsGeneric.js"></SCRIPT>
<!--     <SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/messages.js"></SCRIPT>
 -->	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


    <SCRIPT>
//    function lockKey() {
//        if(event.keyCode == 93)
//            alert("Welcome to eHIS");
//    } dt:18/9/09---For online help
    </SCRIPT>
</HEAD>

<!-- <body onMouseDown="CodeArrest()" onKeyDown="lockKey()"> -->
<body onMouseDown="" onKeyDown="lockKey()">

<form name="FrmTPNConsGeneric" id="FrmTPNConsGeneric">
<%
    /* Mandatory checks start */
    String mode = request.getParameter( "mode" ) ;

	String gCode = request.getParameter( "gcode" ) ;
    String bean_id = "TPNConsGenericBean" ;
    String bean_name = "ePH.TPNConsGenericBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";

//added for audit log
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_TPN_CONST_GENERIC_NAME";
	String pkey_value			="";

	if ( mode == null || mode.equals("") )
        return ;
    if ( !mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
        return ;

    TPNConsGenericBean bean = (TPNConsGenericBean)getBeanObject( bean_id,bean_name,request) ;
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	HashMap GenericDetails=bean.getConsGenericDetails(gCode,locale);
	bean.setLanguageId(locale);

	String gName=(String)GenericDetails.get("GNAME");
	String srlNo="";
	String cGroupCode="";
	String cGroupName="";
	String uomFlag="";
	String item_fluid_yn="";
	String checked="";
	String chk_val="";
	String disable_flag="";
	String enabled_yn =""; // Added for ML-MMOH-CRF-1126 - Start
	String enable_checked = "";
        Connection con = null;
        boolean display_enable_yn = false;
	try{
			con = ConnectionManager.getConnection(request);	// Added for ML-MMOH-CRF-1126 - Start
			display_enable_yn = CommonBean.isSiteSpecific(con, "PH", "ASSESMENT_REQ_YN");
	}
	catch(Exception e){
		e.printStackTrace();		
	}
	finally{
		ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-CRF-1126 - End
	String item_fluid_flag=bean.getItemFluid();
	if(item_fluid_flag.equals("Y"))
	disable_flag="";
	else
	disable_flag="disabled";

	if (GenericDetails.containsKey("SRLNO")){
		srlNo=(String)GenericDetails.get("SRLNO");
		cGroupCode=(String)GenericDetails.get("CGROUPCODE");
		cGroupName=(String)GenericDetails.get("CGROUPNAME");
		uomFlag=(String)GenericDetails.get("UOMFLAG");
		item_fluid_yn=(String)GenericDetails.get("ITEM_FLUID_REQ_YN");
		if(display_enable_yn && GenericDetails.containsKey("EFF_STATUS") ){ // Added for ML-MMOH-CRF-1126 - Start
			enabled_yn = (String)GenericDetails.get("EFF_STATUS");
			if(enabled_yn.equals("E"))
				enable_checked="checked";
		   else
			    enable_checked="";  
		} // Added for ML-MMOH-CRF-1126 - End
	}
	else{
	}
	if(uomFlag.equals("I"))
		uomFlag="Individual";
	else if(uomFlag.equals("G"))
		uomFlag="General";

	if(item_fluid_yn.equals("Y"))
	{
		checked="checked";
		chk_val="Y";
	}
	else if(item_fluid_yn.equals("N"))
	{
		checked="";
		chk_val="N";
	}
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
<span style="position:absolute;top:100;left:80">
<TABLE align="center" cellspacing="0" cellpadding="0" border="0">
<tr>
<td class="label" colspan=2>&nbsp;</td>
<td >
<INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">
</td>
</tr>
<tr>
<td  class="label">
		<fmt:message key="ePH.ConstituentGenericCode.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="gCode" id="gCode" maxLength=2 size=5 readonly value="<%=gCode%>" >
</td>

</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td  class="label" width="45%">
	<fmt:message key="ePH.ConstituentGenericName.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="gName" id="gName" maxLength=30 size=35  value="<%=gName%>" tabIndex=1>
	<img src="../../eCommon/images/mandatory.gif">
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td  class="label">
	<fmt:message key="ePH.DisplaySerialNo.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="srlno" id="srlno" maxLength=3 size=5 readonly value="<%=srlNo%>">
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td  class="label">
<fmt:message key="ePH.ConstituentGroup.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="cGroupName" id="cGroupName" maxLength=3 size=30 readonly value="<%=cGroupName%>">
<input type='hidden' name='cGroupCode' id='cGroupCode' value='<%=cGroupCode%>'>
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td  class="label">
<fmt:message key="ePH.UOMLevel.label" bundle="${ph_labels}"/>
</td>
<td align=left colspan='2'>&nbsp;&nbsp;<input type="text" name="uomflag" id="uomflag" maxLength=3 size=7 readonly value="<%=uomFlag%>">
</td>
</tr>
<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
<tr>
<td  class="label" >
       <fmt:message key="ePH.SelectionofPreferredItemFluidApplicable.label" bundle="${ph_labels}"/>
    </td>
	<td align='left' colspan='2' >&nbsp;&nbsp;<input type="checkbox" name="itmfld_req_yn" id="itmfld_req_yn"  value="<%=chk_val%>" onclick='assignVal(this)' <%=checked%> <%=disable_flag%>></td>
	</tr>
 <%if(display_enable_yn){ // Added for ML-MMOH-CRF-1126 - Start %>
	<tr>
<td  class="label" >
       <fmt:message key="Common.enabled.label" bundle="${common_labels}"/>
    </td>
	<td align='left' colspan='2' >&nbsp;&nbsp;<input type="checkbox" name="enabled_yn" id="enabled_yn" onclick="enableDisable(this)" value="<%=enabled_yn%>" <%=enable_checked%>></td>
	</tr>
	<%} // Added for ML-MMOH-CRF-1126 - End %>
	<tr>
<td class="label" colspan=3>&nbsp;</td>
</tr>
</TABLE>
</span>
<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
<script>document.getElementById("gName").focus();</script>
<SCRIPT>
    assignVal(document.FrmTPNConsGeneric.itmfld_req_yn);
</SCRIPT>
</html>

