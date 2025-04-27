<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	
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


	<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<!-- <SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/MstCodeCommon.js"></SCRIPT> -->
	<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/PhCommon.js"></SCRIPT>
	<SCRIPT LANGUAGE="JavaScript" SRC="../js/AdminRouteCategory.js"></SCRIPT>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>

<body onMouseDown="" onKeyDown="lockKey()">

<%
	/* Mandatory checks start */
	String	mode			= request.getParameter( "mode" ) ;
	String	bean_id			=	"AdminRouteCategory" ;
	String	bean_name		=	"ePH.AdminRouteCategoryBean";

	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	
	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || 
	       mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
	/* Mandatory checks end */
	AdminRouteCategoryBean bean = (AdminRouteCategoryBean)getBeanObject(bean_id,bean_name ,request);
bean.setLanguageId(locale);
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
%>
<form name="frmARCAddModify" id="frmARCAddModify" id="ARC">
<% 
	if (mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT")))
	{
		
		%>
		<br> <br> <br> 	<br> <br> <br> 	<br> <br> <br> 	
		<table cellpadding=0 cellspacing=0 width="75%" align="center">
		<tr>
		<td colspan="2">&nbsp;</td> 
		</tr>

			<tr>
				<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align ="left">
				<input type ="text" name ="arc_code" value = "" size ="10" maxlength ="10"
					onBlur = "toUpper(this)" onKeyPress = "return CheckForSpecChars(event);">
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>
			</tr>
			<tr>
			<td colspan="2">&nbsp;</td> 
			</tr>

			<tr>
	<td align="right" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
					<td align="left" >
					<input type="text" name="arc_desc" id="arc_desc" value="" size="30" maxlength="30">
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>
			</tr>
			<tr>
		<td colspan="2">&nbsp;</td> 
		</tr>

				<tr>
				<td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align="left" >
					<input type="checkbox" name="eff_status" id="eff_status" value="E" checked >
				</td>
			</tr>
								<tr>
			<td colspan="2">&nbsp;</td>
		</tr>

		</table>
		<%
	}
	else if (mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
	{    
		//String strADRCode = request.getParameter("adr_code");
		String strARCCode = request.getParameter("arc_code");
		//bean.setADRTypeCode(strADRCode);
		bean.setAdminRouteCategoryCode(strARCCode);
		bean.loadData();

		String disableAll = "";

		if ((bean.getEffStatus()).equals("D"))
		{
			disableAll = "disabled";
		}
	
		String audit_log_visible="visibility:hidden";
		//String table_id			="PH_ADR_TYPE";	
		String table_id			="PH_ADMIN_ROUTE_CATG";	
		String pkey_value		= "";
	/*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>ADR_CODE
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(bean.getAdminRouteCategoryCode());     

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
				String short_desc=bean.getAdminRouteCategoryDesc();
				String short_desc1="";
				for(int k=0; k<short_desc.length(); k++){
							if (short_desc.charAt(k) == '\''){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else if (short_desc.charAt(k) == '\"'){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else if (short_desc.charAt(k) == '\\'){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else
									short_desc1		=		short_desc1 + short_desc.charAt(k);
						}


  String item_desc =HTMLencode(short_desc1);

		








	 /*--------------------------------------ends here---------------------------------------*/

		%>
		<br> <br> <br> 	<br> <br> <br> 	<br> <br> <br> 
		<table cellpadding=0 cellspacing=0 width="75%" align="center">
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align="left" >
					<input type="text" name="arc_code" id="arc_code" value="<%=bean.getAdminRouteCategoryCode()%>" size="10" maxlength="10" disabled>
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>
				<TD ALIGN="RIGHT"> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'  onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
	<td align="right" class="label"><fmt:message key="Common.description.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align="left" colspan="2">
					<input type="text" name="arc_desc" id="arc_desc" value="<%=item_desc%>" size="30" maxlength="30">
					<img src="../../eCommon/images/mandatory.gif" align="center"></img>
				</td>
			</tr>
			<tr><td colspan="3">&nbsp;</td></tr>
			<tr>
				<td align="right" class="label"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
				<td align="left" colspan="2" >
					<%
						if (bean.getEffStatus().equals("E"))
						{
							%>
							<input type="checkbox" name="eff_status" id="eff_status" value="E" checked>
							<%
						}
						else
						{
							%>
							<input type="checkbox" name="eff_status" id="eff_status" value="E" >
							<%
						}
					%>
				</td>
			</tr>
			<tr>
				<td colspan="3">&nbsp;</td>
			</tr>

	</table>
<%
	}
%>
	<input type="hidden" name="mode" id="mode"		value="<%= mode %>">	
	<input type="hidden" name="bean_id" id="bean_id"		value="<%= bean_id %>">
	<input type="hidden" name="bean_name" id="bean_name"	value="<%= bean_name %>">
</form>
<% 
if( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) && bean.getEffStatus().equals("E")  )
{ %>
<script>
	document.frmARCAddModify.arc_desc.focus() ;
</script>
<% } 
putObjectInBean(bean_id,bean,request);
putObjectInBean(log_bean_id,log_bean,request);
%>
<!-- /**
 * @Name - Sandhya A 
 * @Date - 18/12/2009
 * @Inc# - IN016185 (online help)
 * @Desc - set focus to the adminroutecode text.
 */ -->
<%if(mode.equals("1"))
{%>

<script>	
	
	document.forms[0].arc_code.focus();
	</script>
<%} 
	else{%>
<script>	
	
	document.forms[0].arc_desc.focus();
	</script>
<%	}
%>   <!-- ends -->
<%!
	
	public static String HTMLencode(String desc){
		StringBuffer item_desc = new StringBuffer(desc.trim()); 
		for (int i=0; i<item_desc.length(); ++i) {
            char c = item_desc.charAt(i);
            if (c == '<') {
                item_desc.replace(i,i+1,"&lt;");
                i += 3;
            } else if (c == '>') {
                item_desc.replace(i,i+1,"&gt;");
                i += 3;
            } else if (c == '\"') {
                item_desc.replace(i,i+1,"&quot;");
                i += 5;
            }else if(c=='\''){
		               item_desc.replace(i,i+1,"&#039");
                i += 6;
						  
		    }
        }
		return item_desc.toString();
		}
%>


</BODY>
</HTML>

