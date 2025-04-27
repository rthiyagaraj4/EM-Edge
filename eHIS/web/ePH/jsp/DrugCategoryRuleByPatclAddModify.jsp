 <!DOCTYPE html>
 <%-- saved on 27/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


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
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/DrugCategoryRuleByPatcl.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<SCRIPT>
		function_id = "<%= request.getParameter( "function_id" ) %>"
	</SCRIPT>
</HEAD>

<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String mode	= request.getParameter( "mode" ) ;
	String bean_id = "DrugCategoryRuleByPatclBean" ;
	String bean_name = "ePH.DrugCategoryRuleByPatclBean";
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	String audit_log_visible="visibility:hidden";
	String table_id			="PH_DRUG_CATG_RULE_BY_PATCL";
	String pkey_value		="";
	if ( mode == null || mode.equals("") )
		return ;
	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	DrugCategoryRuleByPatclBean bean = (DrugCategoryRuleByPatclBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.clear() ;
	bean.setMode( mode ) ;
	 bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	/* Initialize Function specific end */
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
log_bean.setLanguageId(locale);
	ArrayList all=	bean.getAllList(locale);

	ArrayList drugCategory= (ArrayList)all.get(0);
	ArrayList patientClass= (ArrayList)all.get(1);
	ArrayList durationType=	(ArrayList)all.get(2);
	ArrayList phParamValues= (ArrayList)all.get(3);

	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
	{
%>

<form name="frmDrugCategoryRulesByPatcl" id="frmDrugCategoryRulesByPatcl" id="Drug Category Rules By Patcl">

	<br> <br> <br> 
	<table cellpadding=0 cellspacing=0 width="90%" align="center">

		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></td>
			<td  colspan="2" >&nbsp;&nbsp;
				<select name="drug_catg_code" id="drug_catg_code" >
					<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;-- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> --&nbsp;&nbsp;&nbsp;&nbsp;</option>
					<%
						if (drugCategory.size() != 0) {
							for (int datacnt = 0; datacnt < drugCategory.size(); datacnt++) {
					%>
					<option value="<%= drugCategory.get(datacnt++) %>">
					<%= drugCategory.get(datacnt) %></OPTION>
					<%
							}
						}
					%>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td  colspan="2">&nbsp;&nbsp;
				<select name="patient_class" id="patient_class" >
					<option value="*A" >*All</option>
					<%
						if (patientClass.size() != 0) {
							for (int datacnt = 0; datacnt < patientClass.size(); datacnt++) {
					%>
					<option value="<%= patientClass.get(datacnt++) %>">
					<%= patientClass.get(datacnt) %></OPTION>
					<%
							}
						}
					%>
				</select>
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="ePH.MaxPrescriptionDuration.label" bundle="${ph_labels}"/></td>
			<td class="label">&nbsp;&nbsp;
				<input type="text" name="max_durn_value" id="max_durn_value" maxlength=3 size=3 onBlur="CheckNum(this);CheckZero(this);checkPHParamValue(this)" onkeyPress='return allowValidNumber(this,event,3,0)' class="NUMBER">
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				<input type="hidden" name="max_durn_type" id="max_durn_type" value="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
				<%--<select name="max_durn_type" id="max_durn_type" disabled>
					<%
						String strSelect	=	"";
						if (durationType.size() != 0) {
							for (int datacnt = 0; datacnt < durationType.size(); datacnt++) {

								if ((durationType.get(datacnt)).equals("D")){
									strSelect	=	"selected";
									}
								else{
									strSelect="";
									}
					%>
					<option value="<%= durationType.get(datacnt++) %>" <%=strSelect%>>
					<%= durationType.get(datacnt) %></OPTION>
					<%
							}
						}
					%>
				</select>--%>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
			<td  colspan="2">&nbsp;&nbsp;
				<select name="action_abbr" id="action_abbr" >
					<option value="W"><fmt:message key="Common.Warning.label" bundle="${common_labels}"/></option>
					<option value="R"><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
					<option value="A"><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr style="display:none">
			<td  class="label" style="display:none"><fmt:message key="Common.AuthorizationLevel.label" bundle="${common_labels}"/></td>
			<td  colspan="2" style="display:none">&nbsp;&nbsp;
				<input type=text name="ord_auth_level" id="ord_auth_level" onBlur="CheckNum(this)"  onkeyPress='return allowValidNumber(this,event,1,0)' class="NUMBER" maxlength="1" size="1">
			</td>
		</tr> 
		<tr style="display:none">
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.MessageText.label" bundle="${common_labels}"/></td>
			<td colspan="2">&nbsp;&nbsp;
				<textarea cols="51"   rows="5" name="prompt_msg" id="Message Text" onKeyPress="return(checkMaxLimit(this,255));" onBlur="callCheckMaxLen(this,255,'Message Text')" onFocus="callCheckMaxLen(this,255,'Message Text')"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>

	</table>
	<%
	}
	else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
	{
		String drug_catg_code		= request.getParameter( "drug_catg_code" );
		String patient_class    	= request.getParameter( "patient_class" ) ;
		try{
		bean.setDrugCatgCode(drug_catg_code.trim());
		bean.setPatientClass(patient_class.trim());
		bean.loadData();
		String action_abbr= bean.getActionAbbr();

		String selectWarning ="",selectReject="",selectAuthorize="";
		if (action_abbr==null) action_abbr="";
		if (action_abbr.equals("W"))
			selectWarning    = "selected";
		if (action_abbr.equals("R"))
			selectReject	 = "selected";
		if (action_abbr.equals("A"))
			selectAuthorize  = "selected";

		String ordAuthLevel= bean.getOrdAuthLevel();
		if (ordAuthLevel==null)
			ordAuthLevel="";
		String promptMsg=bean.getPromptMsg();
		if (promptMsg==null)
			promptMsg ="";
		
		if (bean.getPatientClassDesc()==null)
			bean.setPatientClassDesc("*All");

/*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>DRUG_CATG_CODE
				//primary_key_2  ------>PATIENT_CLASS
				
  			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(bean.getDrugCatgCode());      
				Pk_values.add(bean.getPatientClass());      
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
	<form name="frmDrugCategoryRulesByPatcl" id="frmDrugCategoryRulesByPatcl" id="Drug Category Rules By Patcl" >
	<br> <br> <br>

	<table cellpadding=0 cellspacing=0 width="90%" align="center" >

		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="ePH.DrugCategory.label" bundle="${ph_labels}"/></td>
			<td >&nbsp;&nbsp;
				<input type="hidden" name="drug_catg_code" id="drug_catg_code" value="<%= bean.getDrugCatgCode() %>" >
				<input type="text" name="drug_catg_desc" id="drug_catg_desc" value="<%=bean.getDrugCatgDesc() %>" readOnly >
				<img align="center" src="../../eCommon/images/mandatory.gif" ></img></td>
			<td > <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>">	&nbsp;</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></td>
			<td colspan="2">&nbsp;&nbsp;
				<input type="hidden" name="patient_class" id="patient_class" value="<%= bean.getPatientClass() %>" >
				<input type="text" name="patient_class_desc" id="patient_class_desc" value="<%=bean.getPatientClassDesc()%>" readOnly>
				<img src="../../eCommon/images/mandatory.gif" align="center"></img></td>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="ePH.MaxPrescriptionDuration.label" bundle="${ph_labels}"/></td>
			<td class="label" colspan="2">&nbsp;&nbsp;
				<input type=text name="max_durn_value" id="max_durn_value" value="<%= bean.getMaxDurnValue() %>" maxlength=6 size=6 onB	lur="CheckNum(this);CheckZero(this);checkPHParamValue(this)" onkeyPress='return allowValidNumber(this,event,6,0)' class="NUMBER">
				<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				<input type="hidden" name="max_durn_type" id="max_durn_type" value="D"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
				<%--<select name="max_durn_type" id="max_durn_type" disabled>

					<%
						if (durationType.size() != 0) {
							for (int datacnt = 0; datacnt < durationType.size(); datacnt++) {
								String strSelect="";
								if (durationType.get(datacnt).equals(bean.getMaxDurnType()))
									strSelect="selected";
								else
									strSelect="";
					%>
					<option value="<%= durationType.get(datacnt++) %>"  <%= strSelect%>>
					<%= durationType.get(datacnt) %></OPTION>
					<%
							}
						}
					%>
				</select>--%>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td class="label"><fmt:message key="Common.action.label" bundle="${common_labels}"/></td>
			<td  colspan="2">&nbsp;&nbsp;
				<select name="action_abbr" id="action_abbr" >
					<option value="W" <%=selectWarning%>><fmt:message key="Common.Warning.label" bundle="${common_labels}"/></option>
					<option value="R" <%=selectReject%>><fmt:message key="Common.Rejected.label" bundle="${common_labels}"/></option>
					<option value="A" <%=selectAuthorize%>><fmt:message key="Common.Authorize.label" bundle="${common_labels}"/></option>
				</select>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr style="display:none">
			<td  class="label" style="display:none"><fmt:message key="Common.AuthorizationLevel.label" bundle="${common_labels}"/></td>
			<td  colspan="2" style="display:none">&nbsp;&nbsp;&nbsp;
				<input type=text name="ord_auth_level" id="ord_auth_level" value="<%= ordAuthLevel.trim() %>" onBlur="CheckNum(this)"  maxlength=1 size=1 onkeyPress='return allowValidNumber(this,event,1,0)' class="NUMBER">
			</td>
		</tr>
		<tr style="display:none">
			<td colspan="3">&nbsp;</td>
		</tr>
		<tr>
			<td  class="label"><fmt:message key="Common.MessageText.label" bundle="${common_labels}"/></td>
			<td  colspan="2">&nbsp;&nbsp;
				<textarea cols="51"   rows="5" name="prompt_msg"  onKeyPress="return(checkMaxLimit(this,255));"		onBlur="callCheckMaxLen(this,255,'Message Text')" ><%=promptMsg.trim()%></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="3">&nbsp;</td>
		</tr>
	</table>
	<%
		}catch(Exception ess){
				out.println(ess);
				}
	%>
	<script>
		//document.frmDrugCategoryRulesByPatcl.max_durn_value.focus() ;
	</script>
	<%
	}
	%>
	<input TYPE="hidden" name="mode" id="mode" value="<%= mode %>">
	<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
	<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%=bean.getFunctionId()%>">
	<INPUT TYPE="hidden" name="max_durn_for_op_pres" id="max_durn_for_op_pres" VALUE="<%=phParamValues.get(0)%>">
	<INPUT TYPE="hidden" name="max_durn_for_ip_pres" id="max_durn_for_ip_pres" VALUE="<%=phParamValues.get(1)%>">

</form>
<% if( mode.equals( CommonRepository.getCommonKeyValue("MODE_INSERT") ) )
{
%>
<script>
	document.frmDrugCategoryRulesByPatcl.drug_catg_code.focus() ;
</script>
<%}
%>
</BODY>
</HTML>


<%
putObjectInBean(bean_id,bean,request);
%>

