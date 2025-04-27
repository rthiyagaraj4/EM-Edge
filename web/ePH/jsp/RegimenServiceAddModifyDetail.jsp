<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
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
	<script language="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<%
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	String function_id = request.getParameter("function_id") ;
	String bean_id = "regimen_service" ;
	String bean_name = "ePH.RegimenService";

	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";

	int		totalRecords	=	0;


/* Mandatory checks end */
	
	/* Initialize Function specific start */
	RegimenService bean = null ;
	try{
	 bean = 	(RegimenService)getBeanObject( bean_id,bean_name,request);  
	 bean.setLanguageId(locale);
	}catch(Exception e){
	out.println("Caught=" + e.getMessage());	
	}
	
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
    log_bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setLanguageId(locale);
	bean.setMode(mode) ;

	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	/* Initialize Function specific end */


%>

<form name='Regimen_service_insert' id='Regimen_service_insert' target='messageFrame' >

<%
if((mode.trim().equals("1"))){
%>
<table cellpadding=0 cellspacing=0 border=1 width='63%'  align='center'>

<tr>
		<th width='18%'>&nbsp;<fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
		<th width='13%'>&nbsp;<fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/></th>
		<th width='13%'>&nbsp;<fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/></th>
		<th width='13%'>&nbsp;<fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
	<td class='<%=classValue%>' >&nbsp;<input type=text name='service_desc<%=i%>' id='service_desc<%=i%>' onkeypress="return CheckForSpecChars(event)"  onBlur="parent.parent.resetColorCode(this);parent.parent.activateRegimen(<%=i%>)" size=17 maxlength=15 value='' readonly ><input type='button' name='service_code_button<%=i%>' id='service_code_button<%=i%>' class='button'   value='?' onClick='parent.parent.show_service_code_window(service_desc<%=i%>, service_code<%=i%>, <%=i%>)' onfocus='parent.parent.show_service_code_window(service_desc<%=i%>, service_code<%=i%>, <%=i%>)'
	onBlur="parent.parent.activateRegimen(<%=i%>)" >
		<input type=hidden name='service_code<%=i%>' id='service_code<%=i%>' value=''>
	</td>

	<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='regimen_yn<%=i%>' id='regimen_yn<%=i%>' value="Y"  ></td>
	<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='tpn_yn<%=i%>' id='tpn_yn<%=i%>' value="Y"  ></td>

	<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='eff_status<%=i%>' id='eff_status<%=i%>' value="E" checked  ></td>
</tr >
<%i++;}%>

</table>
		<INPUT TYPE="hidden" name="indicator" id="indicator" value="">

<%
} else if((mode.trim().equals("2"))){
		String code =  request.getParameter("code") ;
		String desc =  request.getParameter("desc") ;
		
		//desc=desc.replaceAll(" ","%20");
		desc = java.net.URLDecoder.decode(desc);
		//desc=desc.replaceAll("%2520","%20");

		String indicator_disp = "";
		String indicator = "";
		String regimen_yn = "";
		String tpn_yn = "";
		String eff_status = "";
		String checked= "";
		String regimen_checked= "";
		String tpn_checked= "";
		String disabled= "";

		bean.setFunctionId(function_id);
		bean.clear() ;
		bean.setMode(mode) ;

		bean.loadData(code);

		indicator_disp =bean.getIndicatorDisplay() ;
		indicator =bean.getIndicator() ;
		eff_status =bean.getEffStatus() ; 
		regimen_yn =bean.getRegimenYN() ; 
		tpn_yn =bean.getTPNYN() ; 

		if(indicator == null)
			indicator = "";
		else
			indicator	= indicator.trim();

		if((eff_status.trim()).equals("E")){
			checked = " checked ";
		}else{
			disabled = "  disabled ";
		}

		if((regimen_yn.trim()).equals("Y")){
			regimen_checked = " checked ";
		}
		if((tpn_yn.trim()).equals("Y")){
			tpn_checked = " checked ";
		}

		String audit_log_visible= "visibility:hidden";
		String table_id			= "PH_REGIMEN_SERVICE";	
		String pkey_value		= "";
	/*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>SERVICE_CODE
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(code.trim());     

			//code for passing coloum_names
				ArrayList coloum_names =new ArrayList();
				coloum_names.add("CODE");
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
<table cellpadding=0 cellspacing=0 border=0 width="80%" align=center>
	<tr>
		<td >&nbsp;</td>
		<TD align='right'> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/>&nbsp;</td>
		<td >&nbsp;	<input type=text name="indicator_disp" id="indicator_disp" value="<%=indicator_disp%>" readonly>
		&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.service.label" bundle="${common_labels}"/>&nbsp;</td>
		<td >&nbsp;	<input type=text name="service_code_desc" id="service_code_desc" value="<%=desc%>" readonly  size=15>
			<input type=hidden name="service_code" id="service_code" value="<%=code%>">
		&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>	
	</tr>	<tr>
		<td width="35%" class="label"><fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td>&nbsp;<input type=checkbox name="regimen_yn" id="regimen_yn" value="<%=regimen_yn%>" <%=regimen_checked%>  <%=disabled%> ></td>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>	
	</tr>	<tr>
		<td width="35%" class="label"><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/>&nbsp;</td>
		<td>&nbsp;<input type=checkbox name="tpn_yn" id="tpn_yn" value="<%=tpn_yn%>" <%=tpn_checked%>  <%=disabled%> ></td>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>	
	</tr>	<tr>
		<td width="35%" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
		<td>&nbsp;<input type=checkbox name="eff_status" id="eff_status" value="<%=eff_status%>" <%=checked%> ></td>
	</tr>	
	<tr>
		<td colspan="2">&nbsp;</td>	
	</tr>
				   
</table>
	<INPUT TYPE="hidden" name="indicator" id="indicator" value="<%=indicator%>">

<%
}
%>
	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
	 <input type="hidden" name="service_code_sql" id="service_code_sql" value="<%=PhRepository.getPhKeyValue("SQL_PH_REGIMEN_SERVICE_SERVICE_CODE_LOOKUP")%>">
  
  </form>
  <% 
  putObjectInBean(bean_id,bean,request); 
  putObjectInBean(log_bean_id,log_bean,request);
  %>

 </body>
</html>

