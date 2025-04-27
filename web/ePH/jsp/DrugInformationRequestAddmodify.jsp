<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends

	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	
	<script language="JavaScript" src="../../ePH/js/DrugInformationRequest.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<!-- 	<title>Adverse Drug Reaction</title>

-->	
<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
     /* Mandatory checks start */
    String mode			= request.getParameter("mode");
    String bean_id		= "DrugInformationRequestBean" ;
    String bean_name	= "ePH.DrugInformationRequestBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_DRUG_REQ_ENQ";
	String pkey_value		="";
	String drug_code  ="";
	String drug_description= "";
	String drug_display_sequence_no= "";


if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
    DrugInformationRequestBean bean = (DrugInformationRequestBean)getBeanObject( bean_id,bean_name, request  ) ;
	bean.setLanguageId(locale);
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);

%>
<form name="frmdruginformationrequestAddModify" id="frmdruginformationrequestAddModify"  id="druginformation" >
 
	   <%
		   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
 		%>

	<br><br><br><br><br><br><br>

	
		<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" id="patient_table">
		<tr><td class="label" colspan="3">&nbsp;</td></tr>
						
	<tr>
	<td class="label"  nowrap>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td>&nbsp;
	<input type="text" name="code" id="code" size="6"  align=center maxlength="4" value="<%=drug_code%>" onKeyPress="return CheckForSpecChars( event )" onBlur="this.value=this.value.toUpperCase();">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
		<td> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
	</tr>	
	<tr>
	<td class="label"  nowrap>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td colspan="2">&nbsp;
	<input type="text"  name="description" id="description" size="30"  align=center maxlength="30" value="<%=drug_description%>" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
	</tr>	
	<tr>
	<td class="label"  nowrap>&nbsp;<fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
	<td colspan="2">&nbsp;
	<input type="text" name="display_sequence_no" id="display_sequence_no"  align=center  value="<%=drug_display_sequence_no%>" onBlur="CheckNum(this);chkzero(this)" onKeyPress="return allowValidNumber(this,event,2,0);" size="5" maxlength="2">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
	</tr>	
	<tr>
			<td class="label">&nbsp;<fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/></td>
			<td colspan="2" >&nbsp;
			<input type="checkbox" name="sys_def" id="sys_def" value="N" disabled>
			</td>
	</tr>				
	<tr>
			<td class="label">&nbsp;<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td colspan="2" >&nbsp;
			<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
			</td>
		</tr>				
	<tr><td class="label" colspan="3">&nbsp;</td></tr>
	</table>
	<%
	  }
	
if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
		String code = request.getParameter("code");		
		String  disableAll = "";
		String 	disableAll1 = "";
			bean.setCode(code);	
			bean.loadData();
			if ((bean.getSysDef()).equals("N")){
			disableAll1 = "disabled";
			}
			if ((bean.getEffStatus()).equals("D")){
			disableAll = "disabled";
		}

		  /*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>REQ_CAT_CODE
				
  			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(code.trim());      
				
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				pkey_value   ="";
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();
				}

	      /*--------------------------------------ends here---------------------------------------*/
					   
					   
	%>
	
		<br><br><br><br><br><br><br><br><br><br>
		<table cellpadding=0 cellspacing=0 width="90%"  align="center" border="0" id="patient_table">
		
		<tr><td class="label" colspan="3">&nbsp;</td></tr>
											
<tr>
	<td class="label"  nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td >&nbsp;
	<input type="text" name="code" id="code" size="6"  align=center maxlength="4" value="<%=bean.getCode()%>" onKeyPress="return CheckForSpecChars( event )" onBlur="this.value=this.value.toUpperCase();validateCode(this)" disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
	<td> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
</tr>	
<tr>
	<td class="label"  nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td colspan="2" >&nbsp;
	<input type="text" name="description" id="description" size="30"  align=center maxlength="30" value="<%=bean.getDescription()%>" <%=disableAll%>  >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center ></img>
	</td>
</tr>	
<tr>
	<td class="label"  nowrap><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
	<td colspan="2">&nbsp;
	<input type="text" name="display_sequence_no" id="display_sequence_no" align=center maxlength="2" value="<%=bean.getDisplaysequenceno()%>" onBlur="CheckNum(this);chkzero(this)" onKeyPress="return allowValidNumber(this,event,2,0);" size="5" <%=disableAll%> >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center ></img>
	</td>
</tr>						
<tr>
			<td class="label"> <fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/>	</td>
			<td colspan="2" >&nbsp;
				<%
				
					if (bean.getSysDef().equals("N")){

				%>
					<input type="checkbox" name="sys_def" id="sys_def" value="N" <%=disableAll1%> >
				<%
					}else{
				%>
					<input type="checkbox" name="sys_def" id="sys_def" value="Y" <%=disableAll1%> checked>
				<%
					}
				%>
			</td>
		</tr>
					   
<tr>
			<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td colspan="2" >&nbsp;
				<%
					if (bean.getEffStatus().equals("E")){
				%>
					<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
				<%
					}else{
				%>
					<input type="checkbox" name="eff_status" id="eff_status" value="D"  >
				<%
					}
				%>
			</td>
		</tr>
					   
					   
		<tr><td class="label" colspan="3">&nbsp;</td></tr>
   </table>
			
<input type="hidden" name="temp_seq_no" id="temp_seq_no" value="<%=bean.getDisplaysequenceno()%>">
<input type="hidden" name="dup_chk" id="dup_chk" value="Y">
<%
					     }
						%>

  <%
    if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
	%>
   <script>document.frmdruginformationrequestAddModify.code.focus();</script>
   <%}
	%>

  <% if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && bean.getEffStatus().equals("E")) { %>
<script>
	document.frmdruginformationrequestAddModify.description.focus() ;
</script>
   <%}

	%>

   <input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">

 </form>
</body>
<%
putObjectInBean(bean_id,bean,request);

	%>
</html> 

