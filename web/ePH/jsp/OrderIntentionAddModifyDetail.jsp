<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.* ,ePH.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
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
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()"  onKeyDown="lockKey()" >
<%
	String readOnly = "" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter("mode") ;
	String function_id = request.getParameter("function_id") ;
	String bean_id = "order_intention" ;
	String bean_name = "ePH.OrderIntention";
	int		totalRecords	=	0;
/* Mandatory checks end */
/* Initialize Function specific start */
	OrderIntention bean = null ;
	
	 bean = 	(OrderIntention)getBeanObject( bean_id,bean_name, request );  
	 bean.setLanguageId(locale);
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;
	totalRecords	=	Integer.parseInt(CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	/* Initialize Function specific end */
	 //added for audit log
	String audit_log_visible	= "visibility:hidden";
	String table_id				= "PH_ORDER_INTENTION";
	String log_bean_id			= "SetupAuditLogBean" ;
	String log_bean_name		= "ePH.SetupAuditLogBean";
	SetupAuditLogBean log_bean	= (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);
	String pkey_value			="";
%>
<form name='Order_intention_insert' id='Order_intention_insert' target='messageFrame' >
<%
if((mode.trim().equals("1"))){
%>
<table cellpadding=0 cellspacing=0 border=1 width='90%'  align='center'>
<tr>
		<th width='18%'>&nbsp;<fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th width='42%'>&nbsp;<fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th width='20%'>&nbsp;<fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
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
	<td class='<%=classValue%>' >&nbsp;<input type=text name='order_intention_id<%=i%>' id='order_intention_id<%=i%>' onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this);parent.parent.resetColorCode(this);" size=8 maxlength=8 value='' %=readOnly%></td>

	<td class='<%=classValue%>'>&nbsp;<input type=text name='order_intention_long_desc<%=i%>' id='order_intention_long_desc<%=i%>' onBlur="makeValidString(this);parent.parent.resetColorCode(this);" size=30 maxlength=30 value=""  <%=readOnly%>></td>
	<td class='<%=classValue%>'>&nbsp;<input type=text name='order_intention_short_desc<%=i%>' id='order_intention_short_desc<%=i%>' onBlur="makeValidString(this);parent.parent.resetColorCode(this);" size=15 maxlength=15 value=""  <%=readOnly%>></td>
	<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='eff_status<%=i%>' id='eff_status<%=i%>' value="E" checked  <%=readOnly%> ></td>
</tr >
<%i++;}%>
</table>
		<INPUT TYPE="hidden" name="indicator" id="indicator" value="">
<%
} else if((mode.trim().equals("2"))){
		String code =  request.getParameter( "code" ) ;

		String indicator_disp = "";
		String indicator = "";
		String long_desc = "";
		String short_desc = "";
		String eff_status = "";
		String checked= "";
		String readonly= "";
		bean.setFunctionId(function_id);
		bean.clear() ;
		bean.setMode(mode) ;

		bean.loadData(code);

		indicator_disp =bean.getIndicatorDisplay() ;
		indicator =bean.getIndicator() ;
		short_desc =bean.getOrderIndicatorShortDesc() ;
		long_desc = bean.getOrderIndicatorLongDesc() ;  
		eff_status =bean.getEffStatus() ; 
		if(indicator == null)		 indicator = "";	else indicator	= indicator.trim();
		if(long_desc == null)		 long_desc = "";	else long_desc	= long_desc.trim();
		if(short_desc == null)		 short_desc = "";	else short_desc = short_desc.trim();
		if((eff_status.trim()).equals("E")){
			checked = " checked ";
		}else{
			readonly = "  readonly ";
		}
    /*-------------------------code added for showing audit log---------------------------*/
				//primary_key_1  ------>INTENTION_CODE
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(code.trim());  
				pkey_value       ="";
				
				String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
				if(display_audit_log_button_yn.equals("Y")){
					audit_log_visible= "visibility:visible";
					pkey_value       = (String)log_bean.getpk_value();
				}else{
					audit_log_visible= "visibility:hidden";
					log_bean.clear();

				}

	/*--------------------------------------ends here---------------------------------------*/






%>
<BR><BR><BR><BR><BR><BR>
<table cellpadding=0 cellspacing=0 border=0 width="80%" align=center>
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.INDICATOR.label" bundle="${common_labels}"/>&nbsp;</td>
		<td >&nbsp;	<input type=text name="indicator_disp" id="indicator_disp" value="<%=indicator_disp%>" readonly >
		&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
		<td><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>
	</tr>	
	<tr>
		<td colspan="3">&nbsp;</td>
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.code.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan="2">&nbsp;	<input type=text name="order_intention_id_disp" id="order_intention_id_disp" value="<%=code%>" readonly ><input type=hidden name="order_intention_id" id="order_intention_id" value="<%=code%>">
		&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>	
	<tr>
		<td colspan="3">&nbsp;</td>	
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan="2">&nbsp;	<input type=text name="order_intention_long_desc" id="order_intention_long_desc" value="<%=long_desc%>"  <%=readonly%> size='30' maxlength='30' onBlur="makeValidString( this );">
		&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>	
	<tr>
		<td colspan="3">&nbsp;</td>	
	</tr>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan="2">&nbsp;	<input type=text name="order_intention_short_desc" id="order_intention_short_desc" value="<%=short_desc%>" <%=readonly%> size='15' maxlength='15' onBlur="makeValidString( this );">
		&nbsp;<img src="../../eCommon/images/mandatory.gif"></td>
	</tr>	
	<tr>
		<td colspan="3">&nbsp;</td>	
	</tr>	<tr>
		<td width="35%" class="label" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/>&nbsp;</td>
		<td colspan="2">&nbsp;<input type=checkbox name="eff_status" id="eff_status" value="<%=eff_status%>" <%=checked%> ></td>
	</tr>	
	<tr>
		<td colspan="3">&nbsp;</td>	
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
    </form>
 </body>
</html>

<%
putObjectInBean(bean_id,bean,request);
%>

