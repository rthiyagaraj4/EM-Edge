<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>

<% 
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
		request= new XSSRequestWrapper(request); 
		response.addHeader("X-XSS-Protection", "1; mode=block"); 
		response.addHeader("X-Content-Type-Options", "nosniff"); 
		//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; %>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>

	<script language="JavaScript" src="../js/PhCommon.js"></script>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/DrugInformationSource.js"></script>
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>

</head>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
     /* Mandatory checks start */
    String mode			= request.getParameter("mode");
    String bean_id		= "DrugInformationSourceBean" ;
    String bean_name	= "ePH.DrugInformationSourceBean";
    
	String drug_code  ="";
	String drug_description= "";
	String drug_display_sequence_no= "";

	//added for audit log
	String log_bean_id		    = "SetupAuditLogBean" ;
	String log_bean_name	    = "ePH.SetupAuditLogBean";
	SetupAuditLogBean log_bean  = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	String audit_log_visible	= "visibility:hidden";
	String table_id				= "PH_DRUG_INFO_ENQ_HDR";
	String pkey_value			= "";


if ( mode == null || mode.equals("") )
        return ;
    if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )) )
        return ;
    /* Mandatory checks end */

    /* Initialize Function specific start */
   
%>
<form name="frmdruginformationsourceAddModify" id="frmdruginformationsourceAddModify"  id="druginformation" >
 
	   <%
		   if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
 		%>

	<table cellpadding=0 cellspacing=0 width="100%"  align="center" border="0" id="patient_table">
	<tr>
	<td class="label"  nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td>&nbsp;
	<input type="text" name="code" id="code" size="6"  align=center maxlength="4" value="<%=drug_code%>" onKeyPress="return CheckForSpecChars( event )" onBlur="this.value=this.value.toUpperCase();">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
	<td class="label"  nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td>&nbsp;
	<input type="text" name="description" id="description" size="30"  align=center maxlength="20" value="<%=drug_description%>" >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td> <td></td>
	</tr>	
	<tr>
	<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td colspan="1" >&nbsp;
	<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
	</td>
	<td class="label"  nowrap><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
	<td>&nbsp;
	<input type="text" name="display_sequence_no" id="display_sequence_no"  align=center  value="<%=drug_display_sequence_no%>" onBlur="chkzero1(this)" onKeyPress="return allowValidNumber(this,event,2,0);" size="5" maxlength="2">&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>
	<td>
	<input type="button"  align=left  class="BUTTON" name="details" id="details" value='<fmt:message key="Common.details.label" bundle="${common_labels}"/>'onClick="displayrows()">
	</td>
    </tr>						
	</table>
	<%
	  }
	
if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals("2")){
		
		
		String code = request.getParameter("code")==null?"":request.getParameter("code");	
		String description			= request.getParameter("description")==null?"":request.getParameter("description") ;
		
		String seq_no			= request.getParameter("display_sequence_no")==null?"":request.getParameter("display_sequence_no") ;
		String eff_status			= request.getParameter("eff_status")==null?"":request.getParameter("eff_status") ;
	
		String  disableAll = "";
		/*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>INFO_CAT_CODE
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(code.trim());      
				
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				pkey_value        ="";
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value        = (String)log_bean.getpk_value();
				}else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();
				}

	   /*--------------------------------------ends here---------------------------------------*/
		if (eff_status.equals("D")){
			disableAll = "disabled";


	}%>

<table  cellpadding=0 cellspacing=0 width="100%"  align="center" border="0">			
<tr>
	<td class="label"  nowrap><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
	<td colspan="1">&nbsp;
	<input type="text" name="code" id="code" size="6"  align=center maxlength="4" value="<%=code%>" onKeyPress="return CheckForSpecChars( event )" onBlur="this.value=this.value.toUpperCase();validateCode(this)" disabled>&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center></img>
	</td>	
   <td class="label"  nowrap><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td colspan="1">&nbsp;
	<input type="text" name="description" id="description" size="30"  align=center maxlength="20" value="<%=description%>" <%=disableAll%>  >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center ></img>
	</td>
    <TD> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>
</tr>	
<tr>
	<td class="label"  nowrap><fmt:message key="ePH.DisplaySequenceNo.label" bundle="${ph_labels}"/></td>
	<td colspan="1">&nbsp;
	<input type="text" name="display_sequence_no" id="display_sequence_no" align=center maxlength="2" value="<%=seq_no%>" onBlur="chkzero1(this)" onKeyPress="return allowValidNumber(this,event,2,0);" size="5" <%=disableAll%> >&nbsp;<img src="../../eCommon/images/mandatory.gif" align=center ></img>
	</td>
    <td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td colspan="3" >&nbsp;
			<%
					if (eff_status.equals("E")){
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
</table>

 <input type="hidden" name="temp_seq_no" id="temp_seq_no" value="<%=seq_no%>">


<input type="hidden" name="dup_chk" id="dup_chk" value="Y">

<%
   }
putObjectInBean(log_bean_id,log_bean,request);
%>

  <%
    if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) )){
	%>
   <script>document.frmdruginformationsourceAddModify.code.focus();</script>
   <%}
	%>

 <% if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && request.getParameter("eff_status").equals("E")) { %>
<script>
	document.frmdruginformationsourceAddModify.description.focus() ;
</script>
   <%}
	%>

<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">

</form>
</body>
</html>

