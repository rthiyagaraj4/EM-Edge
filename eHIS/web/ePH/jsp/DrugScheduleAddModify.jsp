<!DOCTYPE html>
 <!--
Fine Tuning
-->
<%-- JSP Page specific attributes start --%>

<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
        request.setCharacterEncoding("UTF-8");
	//Added  for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";%>
 <link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'  type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	
	<script language="JavaScript" src="../js/DrugSchedule.js"></script>
	<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">


<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "DrugScheduleBean" ;
	String bean_name = "ePH.DrugScheduleBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	String IDReadOnly="";
	String readonly  = "";

String schedule_id			="";
String schedule_desc        ="";
String order_auth_reqd_yn   ="";
String order_auth_level     ="";
String order_cosign_reqd_yn ="";
String order_cosign_level   ="";
String spl_appr_reqd_yn     ="";
String spl_appr_level       ="";
String repeat_single_cont_order_yn ="";
String disp_auth_reqd_yn    ="";
String eff_status          ="";

String disabled1="disabled";
String disabled2="disabled";
String disabled3="disabled";
String disabled="";

String checked1  = "";
String checked2  = "";
String checked3  = "";
String checked5  = "checked";
String checked4="";
String checked6="";
String disable_status	=	"";

//added for audit log
String audit_log_visible="visibility:hidden";
String table_id			="PH_DRUG_SCHEDULE";
String pkey_value="";
	
if ( mode == null || mode.equals("") )
	return ;
if ( !(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) || mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") )) )
	return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
DrugScheduleBean bean = (DrugScheduleBean)getBeanObject(bean_id, bean_name, request ) ;

SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
log_bean.setLanguageId(locale);

bean.clear() ;
bean.setMode( mode ) ;
 bean.setLanguageId(locale);

String refill_yn	=	bean.getRefillStatus();

if(refill_yn.equals("N"))
  disable_status	=	"disabled";

String licenceRights = PhLicenceRights.getKey();
	

if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) 
{
	schedule_id	=	request.getParameter( "schedule_id" ) ;
	//out.println("schedule_id="+schedule_id.trim());
	if (schedule_id==null)
		schedule_id="";
	///////////////////////////////////////////////////////////////////////////
	IDReadOnly="readonly";
	//caling the bean method to get data wrt ID
	ArrayList record= bean.getDataForHyperLink(schedule_id.trim());
	/////////////////////////////////////////////////////////////////////////
if (record.size()>1){
		schedule_desc= (String)record.get(1);
		order_auth_reqd_yn=(String)record.get(2);
		order_auth_level=(String)record.get(3);
		order_cosign_reqd_yn=(String)record.get(4);
		order_cosign_level=(String)record.get(5);
		spl_appr_reqd_yn=(String)record.get(6);
		spl_appr_level=(String)record.get(7);
		repeat_single_cont_order_yn=(String)record.get(8);
		disp_auth_reqd_yn=(String)record.get(9);
		eff_status=(String)record.get(10);
	}
if (schedule_desc==null)
schedule_desc="";
	
///////////////////////////////////////////////		
if(order_auth_reqd_yn.equals("Y"))
{
checked1="checked"; 
disabled1 = "" ;
//disabled1="";
}
if (order_auth_level==null)
order_auth_level="";
//////////////////////////////////////////////
if(order_cosign_reqd_yn.equals("Y"))
{
checked2="checked"; 
disabled2="";
}
if (order_cosign_level==null)
	order_cosign_level="";
////////////////////////////////////////////////
if(spl_appr_reqd_yn.equals("Y"))
{
checked3="checked"; 
disabled3="";
}
if (spl_appr_level==null)
	spl_appr_level="";
///////////////////////////////////////////////
if(repeat_single_cont_order_yn.equals("Y"))
{
checked4="checked"; 

}
////////////////////////////////////////////////
if(disp_auth_reqd_yn.equals("Y"))
{
checked6="checked"; 
}
////////////////////////////////////////////////
if (eff_status.equals("D"))
	{
		checked5="";

		readonly = "readonly" ;
		disabled = "disabled" ;
	}
	
		/*-------------------------code added for showing audit log---------------------------*/
		//code for adding pk_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add( schedule_id);      

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



}//if mode=modify ends

%>

<form name="formDrugSchedule" id="formDrugSchedule" >
<br><br><br><br><br>


<table cellpadding=3  border="0" cellspacing=0 width="98%" align="center">

<tr>
	<td >&nbsp;</td>
	<td align="right" ><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>' onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></td>
</tr>

<tr>
	<td class="label" width="45%" ><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
	<td><input type="text" name="schedule_id" id="schedule_id" value="<%=schedule_id%>" size="1" maxlength="2" onBlur="toUpper( this );DrugScheduleCheck(this);"  onKeyPress="return CheckForSpecChars( event );" <%=IDReadOnly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
</tr>

<tr>
	<td class="label" ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td><input type="text" name="schedule_desc" id="schedule_desc" value="<%=schedule_desc%>" size="20" maxlength="20" <%=readonly%>>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
</tr>

<tr>
	<td class="label"  nowrap><fmt:message key="ePH.AuthorizationRequiredForOrdering.label" bundle="${ph_labels}"/></td>
	<td ><input type="checkbox" name="order_auth_reqd_yn" id="order_auth_reqd_yn" <%=checked1%> value="Y" onclick="enableLevel(this);"  <%=disabled%>>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		if (!licenceRights.equals("PHBASIC")){
	%>
	<label class="label"><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	<input type="text" name="order_auth_level" id="order_auth_level" size="1"  maxlength="1" 
	value="<%=order_auth_level%>" onblur="CheckNum(this);"  <%=disabled1%>
	<%=readonly%> class="NUMBER">
	<%
		}
	%>
	</td>

</tr>
<tr>
	<td class="label"><fmt:message key="ePH.CosignRequiredForOrdering.label" bundle="${ph_labels}"/></td>
	<td ><input type="checkbox" name="order_cosign_reqd_yn" id="order_cosign_reqd_yn" <%=checked2%> value="Y" onclick="enableLevel(this);"  <%=disabled%>>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		if(!licenceRights.equals("PHBASIC")){
	%>
	<label class="label"><fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	<input type="text" name="order_cosign_level" id="order_cosign_level" size="1" maxlength="1" value="<%=order_cosign_level%>" onBlur="CheckNum(this)"  <%=disabled2%> <%=readonly%> class="NUMBER">
	<%
		}
	%>
	</td>

</tr>
<tr>
	<td  class="label"><fmt:message key="Common.SpecialApprovalRequired.label" bundle="${common_labels}"/></td>
	<td ><input type="checkbox" name="spl_appr_reqd_yn" id="spl_appr_reqd_yn"  value="Y"  onclick="enableLevel(this);" <%=checked3%>  <%=disabled%>>
	&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
	<%
		if(!licenceRights.equals("PHBASIC")){
	%>
	<label class="label"> <fmt:message key="Common.Level.label" bundle="${common_labels}"/>&nbsp;&nbsp;
	<input type="text" name="spl_appr_level" id="spl_appr_level" size="1" maxlength="1" onblur="CheckNum(this);" value="<%=spl_appr_level%>" <%=disabled3%> <%=readonly%> class="NUMBER">
	<%
		}
	%>
	</td>

</tr>
<tr >
	<td  class="label" ><fmt:message key="ePH.AllowRefill.label" bundle="${ph_labels}"/></td>
	<td ><input type="checkbox" name="repeat_single_cont_order_yn" id="repeat_single_cont_order_yn" value="Y" <%=checked4%>  <%=disabled%> <%=disable_status%>></td>
	
</tr>
	<%
		if(!licenceRights.equals("PHBASIC")){
	%>
<tr>
	<td  class="label" nowrap><fmt:message key="ePH.AuthorizationRequiredForDispensing.label" bundle="${ph_labels}"/></td>
	<td ><input type="checkbox" name="disp_auth_reqd_yn" id="disp_auth_reqd_yn" 
	value="Y"  <%=checked6%> <%=disabled%>>
	</td>
</tr>
	<%
		}
	%>
<tr>
	<td  class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td ><input type="checkbox" name="eff_status" id="eff_status" <%=checked5%> value="E"></td>	
</tr>
<tr>
	<td colspan="4">&nbsp;</td>
</tr>
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">

</form>

<%
if(mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ))
{
%>

<script>
	document.formDrugSchedule.schedule_id.focus() ;
</script>
<%
}
%>
<%
if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )){
if(checked5.equals("checked"))
{
%>

<script>
	document.formDrugSchedule.schedule_desc.focus() ;
</script>
<%
}
}
%>

</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>               

