<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
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

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/SetupAuditLog.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/StressFactor.js"></SCRIPT>
	<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<!-- <body > -->
<body onMouseDown="" onKeyDown="lockKey()">
<%
	String readOnly = "" ;
	String system_defined_yn = "N";
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	String function_id = request.getParameter("function_id") ;
	String bean_id = "stress_factor" ;
	String bean_name = "ePH.StressFactor";

	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";

	int		totalRecords	=	0;


/* Mandatory checks end */
	
	/* Initialize Function specific start */
	StressFactor bean = null ;
	
	try{
		bean = 	(StressFactor)getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		
	}catch(Exception e){
		out.println("Caught=" + e.getMessage());	
	}
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	
	log_bean.setLanguageId(locale);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;

	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	/* Initialize Function specific end */


%>
<BR><BR><BR><BR><BR>
<form name='stree_factor_insert' id='stree_factor_insert' target='messageFrame' >

<%
	String default_yn_exists = "";
	String default_yn_disable = " disabled ";
	default_yn_exists  = bean.ChkDefaultYN();

		if((mode.trim().equals("1"))){


%>
<table cellpadding=0 cellspacing=0 border=1 width='50%'  align='center'>

<tr>
		<th width='18%'>&nbsp;<fmt:message key="ePH.StressRelatedOption.label" bundle="${ph_labels}"/></th>
		<th width='13%'>&nbsp;<fmt:message key="ePH.Weightage.label" bundle="${ph_labels}"/></th>
		<th width='13%'>&nbsp;<fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
</tr>

<%
int i = 0;
while(i < totalRecords){
	
	String  classValue = "";

	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	else
		  	classValue = "QRYODD" ;
	%>
<tr >
	<td class='<%=classValue%>' >&nbsp;<input type=text name='stress_related_option<%=i%>' id='stress_related_option<%=i%>'  size=60 maxlength=60 value='' <%=readOnly%>  onBlur="parent.enableCheckbox(this,<%=i%>)">  </td>

	<td class='<%=classValue%>'>&nbsp;<input type="text" name='weightage<%=i%>' id='weightage<%=i%>' size=6 maxlength=6 value="" <%=readOnly%>  onkeyPress='return allowValidNumber(this,event,4,2)' onBlur="parent.checkRange(this,<%=i%>)"></td>
		<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='default_yn<%=i%>' id='default_yn<%=i%>' value="Y"  <%=default_yn_disable%>  <%=readOnly%> onClick="parent.checkThis(<%=i%>)"></td>
</tr >
<%i++;}%>
	<INPUT TYPE="hidden" name="default_yn_exists" id="default_yn_exists" value="<%=default_yn_exists%>">

</table>
		

<%
}  else if((mode.trim().equals("2"))){
		String srl_no =  request.getParameter( "srl_no" ) ;

		String stress_related_option = "";
		String weightage = "";
		String default_yn = "";
		String checked= "";
		String disabled= "";
	
		bean.setFunctionId(function_id);
		bean.clear() ;
		bean.setMode(mode) ;

		bean.loadData(srl_no);

		bean.setSetSrlNo(srl_no) ;

		stress_related_option =bean.getStressRelatedOption() ;
		weightage =bean.getWeightage() ;
		default_yn =bean.getDefaultYN() ; 
		system_defined_yn =bean.getSystemDefinedYN() ; 
		if(stress_related_option == null)		 stress_related_option = "";	else stress_related_option	= stress_related_option.trim();
		
		if(weightage == null)		 weightage = "";	else weightage	= weightage.trim();

		if((default_yn.trim()).equals("Y")){
			checked = " checked ";
		}

		if((system_defined_yn.trim()).equals("Y")){
			readOnly = " readOnly " ;
			checked = " checked ";
		//	disabled = "  disabled ";
		}

		if(default_yn_exists.equals("0") || (default_yn.trim()).equals("Y")) {disabled = "  "; readOnly = " " ;}else{disabled = " disabled "; readOnly = " readonly " ;}

		String audit_log_visible="visibility:hidden";
		String table_id			="PH_TPN_WEIGHTAGE_FOR_STRESS";	
		String pkey_value		= "";
	/*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>srl_no
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(srl_no.trim());     

			//code for passing coloum_names
				ArrayList coloum_names =new ArrayList();
				coloum_names.add("");
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				pkey_value   = "";
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}else{
					audit_log_visible= "visibility:hidden";
				}

	 /*--------------------------------------ends here---------------------------------------*/

%>

<BR><BR><BR><BR><BR><BR>
<table cellpadding=0 cellspacing=0 border=0 width="90%" align=center>
	<tr>
		<td colspan="2">&nbsp;</td>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="ePH.StressRelatedOption.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td >&nbsp;	<input type=text name="stress_related_option" id="stress_related_option" value="<%=stress_related_option%>" size=60 maxlength=60 <%=readOnly%> <%=disabled%>></td>
		<TD>&nbsp; <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE=<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="ePH.Weightage.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td >&nbsp;	<input type=text name="weightage" id="weightage" value="<%=weightage%>" size=6 maxlength=6  <%=readOnly%> <%=disabled%> onkeyPress='return allowValidNumber(this,event,4,2)' onBlur="parent.checkRangeOnModify(this)"></td>
		<td colspan="2">&nbsp;</td>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>	
		<td colspan="2">&nbsp;</td>
	</tr>	
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.Default.label" bundle="${common_labels}"/>&nbsp;</td>
		<td >&nbsp;<input type=checkbox name="default_yn" id="default_yn" value="<%=default_yn%>" <%=checked%>  <%=disabled%> ></td>
		<td colspan="2">&nbsp;</td>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>	
		<td colspan="2">&nbsp;</td>
	</tr>
				   
</table>
	
	<INPUT TYPE="hidden" name="srl_no" id="srl_no" value="<%=srl_no%>">

<%
}
%>

	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	<INPUT TYPE="hidden" name="system_defined_yn" id="system_defined_yn" value="<%=system_defined_yn%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
  <% putObjectInBean(bean_id,bean,request); %>
  </form>
 </body>
</html>

