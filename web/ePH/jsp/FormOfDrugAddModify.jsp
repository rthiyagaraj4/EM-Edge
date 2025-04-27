<!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import="ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,eCommon.XSSRequestWrapper" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%-- Mandatory declarations end --%>

<HTML>
<HEAD>
<%
    request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>

	<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/FormOfDrug.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>

<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "FormOfDrug" ;
	String bean_name = "ePH.FormOfDrugBean";


	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
   log_bean.setLanguageId(locale);
	 String pkey_value      ="";

	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		
	/* Mandatory checks end */

	/* Initialize Function specific start */
	FormOfDrugBean bean = (FormOfDrugBean)getBeanObject( bean_id, bean_name, request ) ;


	 bean.clear() ;
	 bean.setLanguageId(locale);
	bean.setMode( mode ) ;
	ArrayList check = bean.displayCheck();
	int	    totalRecords	=	0;	
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE") );	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	int localLangCheck = Integer.parseInt((String)check.get(0));

	String tableWidth="";
	String fieldCheck="";
	/* 
   	   if PAT_INSTR_LOC_LANG_YN is N  then 0  
	   if PAT_INSTR_LOC_LANG_YN is Y  then 1   
       if PH_PARAM_FACILITY is Not Setup  then 2
	 */
	if (localLangCheck==0 ){
		fieldCheck = "Both";
		tableWidth="45%";
	}else if (localLangCheck == 1){
		fieldCheck="None";
		tableWidth="80%";
	}
%>
<form name="frmFormOfDrug" id="frmFormOfDrug" id="Form Of Drug" >
<%
		if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) ) {
%>
	<BR><BR><BR><BR>
	<table cellpadding="0" cellspacing="0" width="<%=tableWidth%>" align="center" border=1>
	<TR>
		<TH><fmt:message key="Common.code.label" bundle="${common_labels}"/></TH>
		<TH><fmt:message key="Common.description.label" bundle="${common_labels}"/></TH>
		<% if(localLangCheck == 1){			
		%>
		<TH><fmt:message key="ePH.CodeinLocalLanguage.label" bundle="${ph_labels}"/></TH>
		<TH><fmt:message key="ePH.DescriptioninLocalLanguage.label" bundle="${ph_labels}"/></TH>
		<%
			}
		%>
		<TH ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></TH>
	</TR>
<%
	String classValue="";
	for ( int cnt=1; cnt<=totalRecords; cnt++ ) {
		if(cnt%2 ==0)
			classValue="QRYEVEN";
		else
			classValue="QRYODD";
%>
		 <TR>
			<TD CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="form_code<%=cnt %>" id="form_code<%=cnt %>"  SIZE="4" MAXLENGTH="4" onKeyPress="return CheckForSpecChars(event)" onBlur="toUpper(this);CodeCheck(this)" class="UPPER">
			</TD>
			<TD CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="form_desc<%=cnt %>" id="form_desc<%=cnt %>"  SIZE="22" MAXLENGTH="20" onBlur="resetColorCode(this);makeValidString(this)">
			</TD>
		<% if(localLangCheck == 1){			
		%>
			<TD CLASS="<%=classValue %>" >
				<INPUT TYPE="text" name="form_code_loc_lang<%=cnt %>" id="form_code_loc_lang<%=cnt %>" SIZE="4" MAXLENGTH="4" onKeyPress="return CheckForSpecChars(event)" onBlur="toUpper(this);CodeCheck(this)">
			</TD>
			<TD  CLASS="<%=classValue %>">
				<INPUT TYPE="text" name="form_desc_loc_lang<%=cnt %>" id="form_desc_loc_lang<%=cnt %>" SIZE="22" MAXLENGTH="20" >
			</TD>
		<%
			}
		%>
			<td  CLASS="<%=classValue %>" >&nbsp;&nbsp;
				<input type="checkbox" name="eff_status<%=cnt%>" id="eff_status<%=cnt%>" value="E" checked>
			</td>
		</TR>
<%
	}
%>
	</table>
	<script language="javascript">
		document.frmFormOfDrug.form_code1.focus();
	</script>
<%
} 
if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {	
	
	
	
	String form_code=request.getParameter("form_code");
	if (form_code==null)
		form_code="";
	String form_desc="",form_loc_code="",form_loc_desc="",eff_status="";
	ArrayList record= bean.getValuesForModify(form_code.trim());
	if (record.size()>1){
		form_desc= (String)record.get(1);
		form_loc_code=(String)record.get(2);
		form_loc_desc=(String)record.get(3);
		eff_status=(String)record.get(4);
	}
	String disableAll="";
	if (form_desc==null)
		form_desc="";
	if (form_loc_code==null)
		form_loc_code="";
	if (form_loc_desc==null)
		form_loc_desc="";
	if (eff_status==null)
		eff_status="";
	String enabledDisabled="checked";
	if (eff_status.equals("D"))	{
		enabledDisabled="unchecked";	
		disableAll = "readOnly";
	}
	String strReadOnly="";
	if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) 
		strReadOnly="readOnly";

    String audit_log_visible="visibility:hidden";
	String table_id			="PH_FORM";	
	/*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>FACILITY_ID
				//primary_key_2  ------>DISP_LOCN_CODE 			
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(form_code);     

				pkey_value   ="";
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}else{
					audit_log_visible= "visibility:hidden";
				}

	 /*--------------------------------------ends here---------------------------------------*/

%>		

	<br> <br> <br>	<br> <br> <br> <br> 
	<table cellpadding=0 cellspacing=0 width="90%" align="center">

		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td colspan="1" >&nbsp;&nbsp;
				<input type="text" name="form_code" id="form_code" size="4" maxlength="4" onKeyPress="return CheckForSpecChars(event)" class="UPPER" onBlur="toUpper(this);CodeCheck(this)" value="<%=form_code%>" <%=strReadOnly%> >
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
            <TD > <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
	<td  class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td  colspan="3">&nbsp;&nbsp;
				<input type="text" name="form_desc" id="form_desc" size="20" maxlength="20" value="<%=form_desc%>" <%=disableAll%> onBlur="makeValidString(this)">
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<% if(localLangCheck == 1){			
		%>
		<tr>
			<td  class="label"><fmt:message key="ePH.CodeinLocalLanguage.label" bundle="${ph_labels}"/></td>
			<td  colspan="3">&nbsp;&nbsp;
				<input type="text" name="form_code_loc_lang" id="form_code_loc_lang" size="4" maxlength="4" value="<%=form_loc_code%>" <%=disableAll%> onKeyPress="return CheckForSpecChars(event)" onBlur="toUpper(this);CodeCheck(this)">
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="ePH.DescriptioninLocalLanguage.label" bundle="${ph_labels}"/></td>
			<td   colspan="3">&nbsp;&nbsp;
				<input type="text" name="form_desc_loc_lang" id="form_desc_loc_lang" size="20" maxlength="20" value="<%=form_loc_desc%>" <%=disableAll%>>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<%
			}
		%>
		<tr>
			<td class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td  colspan="3">&nbsp;&nbsp;
				<input type="checkbox" name="eff_status" id="eff_status" <%=enabledDisabled%> value="E">
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
<%
	if (!eff_status.equals("D"))
%>
	<script language="javascript">
		document.frmFormOfDrug.form_desc.focus();
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
}
%>	
	<input type="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<input type="hidden" name="fieldCheck" id="fieldCheck" value="<%= fieldCheck %>" >
	<input type="hidden" name="totalRecords" id="totalRecords" value="<%= totalRecords %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
</FORM>

</BODY>
</HTML>

<%
putObjectInBean(bean_id,bean,request);
putObjectInBean(log_bean_id,log_bean,request);
%>

