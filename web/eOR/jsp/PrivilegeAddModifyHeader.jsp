<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>



<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <body  style="overflow-y:hidden" onMouseDown="CodeArrest()" onKeyDown="lockKey()">
 
<%
	/* Mandatory checks start */
	
	String mode				 = request.getParameter("mode") ;
	String bean_id			 = "privilege" ;
	String bean_name		 = "eOR.PrivilegeBean";
	String facility_id		 = "";
	String facility_name	 = "";
	String privilege_ctx	 = "";
	String appl_user_id		 = "";
	String reln_id			 = "";
	String resp_id			 = "";
	String privilege_value 	 = "";
	String privilege_ctx_id	 = "";

	String appl_user_name	 ="";
	String pract_reln_name	 ="";
	String resp_name		 ="";

	String level_for_label    = "";
	String level_id		      = "";
	String level_desc	      = "";
	String level_desc_hidden  = "";

	/*************Decoding*********************/
	//String valSourcePrivilege[]  ={"O","C","A","H","D","U","S","P","V"} ;
	//String descsourcePrivilege[]={"Order","Cancel","Amend","Hold/Resume","Discontinue","Order Authorizaiton","Cosign","Special Approval","View"} ;

	String valSourceLevel[]  ={"U","R","P"} ;
	String descsourceLevel[]={com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ApplicationUser.label","or_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels")} ;
	//String valSourceVal[]  ={"S","M","A","N"} ;
	privilege_ctx_id  = request.getParameter( "privilege_ctx_id" ) ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" )) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT" )) ) )
	return ;


	/*	Initialize Function specific start */

	PrivilegeBean privilege = (PrivilegeBean)getBeanObject( bean_id,bean_name,request ) ;
	privilege.clear() ;
	privilege.setMode( mode ) ;
	privilege.setFunctionId(privilege.checkForNull(request.getParameter("function_id")));
	String sql_or_privilege_appl_user = OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_APPL_USER");
  

if(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )) {
	privilege_ctx_id  = request.getParameter( "privilege_ctx_id" ) ;
	privilege.loadHeader(privilege_ctx_id.trim());

	 facility_id		 = privilege.getFacility_id()	;
	 facility_name		 = privilege.getFacility_name()	;
	 appl_user_id		 = privilege.getAppl_user_id()	;
	 
	 reln_id			 = privilege.getReln_id()		;
	 resp_id			 = privilege.getResp_id()		;
	 appl_user_name		 = privilege.getAppl_user_name();
	 //System.out.println("&&&&&&appl_user_id="+appl_user_id);
	 //System.out.println("&&&&&&appl_user_name="+appl_user_name);
	 pract_reln_name	 = privilege.getPract_reln_name();
	 resp_name			 = privilege.getResp_name()		;

	 if(!appl_user_id.trim().equals("")){
	 level_for_label	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ApplicationUser.label","or_labels");
	 level_id			= "appl_user_id"    ;
	 level_desc			=  appl_user_name   ;
     level_desc_hidden	=  appl_user_id     ;
	 privilege_ctx = "U";
	 }else if(!reln_id.trim().equals("")){
	 level_for_label	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.relationship.label","common_labels");
	 level_id			= "reln_id"         ;
	 level_desc			=  pract_reln_name  ;
     level_desc_hidden	=  reln_id     ;
	 privilege_ctx = "R";
	 }else if(!resp_id.trim().equals("")){
	 level_for_label	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.responsibility.label","common_labels");
	 level_id			= "resp_id"    ;
	 level_desc			=  resp_name   ;
     level_desc_hidden	=  resp_id     ;
	 privilege_ctx = "P";
	 }
 }



%>


<Script>
function checkValue() {
}
</Script>
<form name="privilegeHeader" id="privilegeHeader" method="post" >

<table border="0" id="headerTab" cellpadding=3 cellspacing=0 width="100%" height='100%' align="center">
<%try {%>
<tr> 
		
	<td class="label" width='30%'><fmt:message key="Common.Level.label" bundle="${common_labels}"/></td>
	<td width='70%' colspan='3'><% if ( mode.equals(  CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){
	%><input type=text name='privilege_ctx_show' id='privilege_ctx_show' value="<%=eHISFormatter.chkReturn(valSourceLevel,privilege_ctx.trim(),descsourceLevel,"")%>" readonly><INPUT TYPE="hidden" name='privilege_ctx' id='privilege_ctx' value="<%=privilege_ctx.trim()%>">
	<%}else{%><select name="privilege_ctx" id="privilege_ctx" 
	onChange="parent.parent.fillComboOptions(this);return parent.parent.checkFlag()">
	<option value="">--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
	<option value="U" <%=eHISFormatter.select(privilege_ctx,"U")%>><fmt:message key="eOR.ApplicationUser.label" bundle="${or_labels}"/></option>
		
	<option value="R" <%=eHISFormatter.select(privilege_ctx,"R")%>><fmt:message key="Common.relationship.label" bundle="${common_labels}"/></option>
	<option value="P" <%=eHISFormatter.select(privilege_ctx,"P")%>><fmt:message key="Common.responsibility.label" bundle="${common_labels}"/></option>
	</select><%}%>
	<img src="../../eCommon/images/mandatory.gif" align=center></img>
 </td>
</tr>

<tr>
	<td class="label" id="level_for_label">
	<%if(mode.equals(  CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){%><%=level_for_label%>
	<%}else{;}%>
	</td>

	<td id="level_for_value" colspan='3' class='fields'>
	<%if(mode.equals(  CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) )){%><input type=text name='label' id='label' value="<%=level_desc%>" readonly><INPUT TYPE="hidden" name='<%=level_id%>' id='<%=level_id%>' value="<%=level_desc_hidden%>">
	<%}else{;}%>
	</td>
</tr>



<tr>

	<td class="label" width='30%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
	<td width='70%' colspan='3'><% if(mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY"))){%>
	<input type=text name='facility_name' id='facility_name' value="<%=facility_name%>" readonly>
	<INPUT TYPE="hidden" name='facility_id' id='facility_id' value="<%=facility_id.trim()%>">
	<%}else{%><select name="facility_id" id="facility_id" >
	<%=privilege.getComboOptions("facility")%>		
	<%String str = (String)session.getValue("facility_id");%></select>	
	<script>document.getElementById("facility_id").value = "<%=str%>"</script>
	<%}%><img src="../../eCommon/images/mandatory.gif"></img>
	</td>
	
</tr>


</table>
	
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="appl_user_sql" id="appl_user_sql" value="<%=sql_or_privilege_appl_user%>" >
<input type="hidden" name="reln_sql" id="reln_sql" value="<%=OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_RELATION")%>" >
<input type="hidden" name="resp_sql" id="resp_sql" value="<%=OrRepository.getOrKeyValue("SQL_OR_PRIVILEGE_RESPONSIBILTY")%>" >

<input type="hidden" name="function_id" id="function_id" value="<%=privilege.getFunctionId()%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
<input type="hidden" name="privilege_value" id="privilege_value" value='<%= privilege_value %>'>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

<%putObjectInBean(bean_id,privilege,request);}catch(Exception e){
	System.out.println("here" + e.getMessage());
	
}%>
</form>
</body>
</html>

