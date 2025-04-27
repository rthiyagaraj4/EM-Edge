<!DOCTYPE html>
 
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
    <script language="JavaScript" src="../js/PhCommon.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language='javascript' src='../../ePH/js/PINAuthorizedRights.js'></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/SetupAuditLog.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
	String readOnly			= "" ;
	String  classValue		= "";
	/* Mandatory checks start */
	String mode				= request.getParameter("mode") ;	
	String function_id		= request.getParameter("function_id") ;
	String user_id			= request.getParameter("user_id") ;
	String user_name		= request.getParameter("user_name") ;
	if(user_name==null) user_name="";
	if(user_id==null) user_id="";
	if(function_id==null) function_id="";
	if(mode==null) mode="";
	String bean_id			= "PIN_Authorized_Rights" ;	
	String bean_name		= "ePH.PINAuthorizedRightsBean";	
	int		totalRecords	=	0;
    /* Mandatory checks end */
	
	/* Initialize Function specific start */
	PINAuthorizedRightsBean bean = null ;
	try{
		 bean = 	(PINAuthorizedRightsBean)getBeanObject( bean_id,bean_name,request);  
		 bean.setLanguageId(locale);
	}catch(Exception e){
		out.println("Caught=" + e.getMessage());	
	}
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clear() ;
	bean.setMode(mode) ;

	totalRecords	=10;	
	/* Initialize Function specific end */

	//added for audit log
	String log_bean_id		= "SetupAuditLogBean" ;
	String log_bean_name	= "ePH.SetupAuditLogBean";
	SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
	log_bean.setLanguageId(locale);

	String audit_log_visible="visibility:hidden";
	String table_id			="PH_PIN_AUTHORIZATION";
	String pkey_value		="";

%>
<form name='pin_auth_rights_insert' id='pin_auth_rights_insert' target='messageFrame' >
<%
if((mode.trim().equals("1"))){
	readOnly="";
	
%>
<table cellpadding=0 cellspacing=0 border=1 width='95%'  align='center'>
<br><br><br><br><br><br>
<tr>
		<th width='40%'>&nbsp;<fmt:message key="Common.userid.label" bundle="${common_labels}"/></th>
		<th width='45%'>&nbsp;<fmt:message key="Common.username.label" bundle="${common_labels}"/></th>
		<th width='10%'>&nbsp;<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
</tr>

<%
int i = 0;
while(i < totalRecords){
	
	
	if ( i % 2 == 0 )
		  	classValue = "QRYEVEN" ;
	else
		  	classValue = "QRYODD" ;
	%>
<tr >  
	<td class='<%=classValue%>' >&nbsp;<input type="text" name='user_id<%=i%>' id='user_id<%=i%>' onkeypress="return CheckForSpecChars(event)" value='<%=user_id%>' onBlur="ChangeUpperCase(this)" size=30 maxlength=30 value='' <%=readOnly%> > <input type='button' name='user_id_button<%=i%>' id='user_id_button<%=i%>' class='button'   value='?' 
	onClick='show_uesr_id_window(user_id<%=i%>, <%=i%>,User_name<%=i%>,eff_status<%=i%>)'  > </td>

	<td class='<%=classValue%>'>&nbsp;<input type="text" name='User_name<%=i%>' id='User_name<%=i%>' value="<%=user_name%>" size=40 maxlength=40 <%=readOnly%> ></td>	

	<td class='<%=classValue%>'>&nbsp;<input type="checkbox" name='eff_status<%=i%>' id='eff_status<%=i%>' value="D"  <%=readOnly%> onclick= 'clearvalues(user_id<%=i%>,User_name<%=i%>,eff_status<%=i%>);' ></td>
</tr >
<%i++;}%>

</table>
		
<%
}else if((mode.trim().equals("2"))) {
	readOnly	="READONLY";
	classValue	="QRYODD";

	    /*-------------------------code added for showing audit log---------------------------*/				
  
			//code for adding pk_values
				ArrayList Pk_values    =new ArrayList();
				Pk_values.add(user_id.trim());      
				
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

<table cellpadding=0 cellspacing=0 border=0 width='80%'  align='center'>
	<br><br><br><br><br><br>
	<tr >
		<td  class='Label' name='user_id1' width='25%'><fmt:message key="Common.userid.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td><input type=text width='55%' name='user_id' id='user_id' value='<%=user_id%>' size=30 maxlength=30 value='' <%=readOnly%> ></td>
        <TD> <INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE='<fmt:message key="Common.AuditLog.label" bundle="${common_labels}"/>'   onClick="viewauditlogdetails('<%=table_id%>','<%=pkey_value%>')" style="<%=audit_log_visible%>"></TD>

	</tr>
	<tr>
		<td  class='Label' name='user_id2' width='25%'><fmt:message key="Common.username.label" bundle="${common_labels}"/>&nbsp;&nbsp;</td>
		<td colspan="2"><input type="text" name='User_name' id='User_name' value="<%=user_name%>" width='55%' size=30 maxlength=<%=user_name%> <%=readOnly%> ></td>	
		
	</tr >
</table>
	<% } %>
	<INPUT TYPE="hidden" name="mode" id="mode" value="<%=mode%>">
	<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
	<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
	<INPUT TYPE="hidden" name="totalRecords" id="totalRecords" value="<%=totalRecords%>">
	 <input type="hidden" name="user_id_sql" id="user_id_sql" value="<%=PhRepository.getPhKeyValue("SQL_PH_PIN_AUTH_RIGHTS_SELECT1")%>"> 
	 <input type="hidden" name="locale" id="locale" value="<%=locale%>">  

  <% putObjectInBean(bean_id,bean,request); %>
</form>
</body>
</html>

