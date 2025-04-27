<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@page  import="java.util.*, eOR.*, eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<title><fmt:message key="eOR.PrivilegeExceptionDetail.label" bundle="${or_labels}"/></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="JavaScript" src="../js/OrCommon.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/PrivilegeExceptionGrp.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<STYLE TYPE="text/css">

	A:active { 
		COLOR: white; 
	}

	A:visited { 
		COLOR: white; 
	}
	A:link { 
		COLOR: white; 
	}
 
	</STYLE>

</head>

<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "privilegeExceptiongrpbean" ;
	String bean_name = "eOR.PrivilegeExceptionGrpBean";
	String mode	= request.getParameter("mode");
	if(mode == null)mode="1";
	String exception_type = "", grp_exception_id="", grp_exception_name="";
	//String readOnly ="";
	String disabled="", bean_mode="I";

	
	/* Mandatory checks starts */
	if ( mode == null || mode.equals("") ) 
		return ;
	if ( !(mode.equals(CommonRepository.getCommonKeyValue( "MODE_MODIFY") ) || mode.equals(CommonRepository.getCommonKeyValue( "MODE_INSERT") )) )
		return ;
	/* Mandatory checks end */

	/* Initialize Function specific start */
	
	PrivilegeExceptionGrpBean bean = (PrivilegeExceptionGrpBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.clear() ;
	bean.setMode( mode ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.clearDBRec();
	
	//eOR.Common.MultiRecordBean MultiRecordSet		= new eOR.Common.MultiRecordBean();
	//MultiRecordSet		= (eOR.Common.MultiRecordBean)bean.getBean();	 
	
	//boolean clearDBbean		=  bean.clearDBRec();
	
	/* Initialize Function specific end */
	if ( mode.equals(  CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){
		exception_type		= request.getParameter("exception_type");
		grp_exception_id	= request.getParameter("grp_exception_id"); 
		grp_exception_name	= request.getParameter("grp_exception_name"); 

		bean.setException_type(exception_type.trim()) ;
		bean.setGrp_exception_id(grp_exception_id.trim()) ;
		bean.setGrp_exception_name(grp_exception_name.trim()) ;

		//readOnly			= "readOnly";
		disabled			= "disabled";
		
	}else{
		exception_type = request.getParameter("exception_type");
		if(exception_type == null || exception_type.equals("null"))exception_type="";
	}
	if(mode.equals("2")){
		bean_mode="M";
	%><body onLoad="dispModRecords('<%=exception_type%>');" onMouseDown="CodeArrest()" onKeyDown="lockKey()"><%
	}else if(mode.equals("1")){
	%><body onMouseDown="CodeArrest()" onKeyDown="lockKey()"><%
	}
%>
<form name="formPrivilegeExpGrpDtl" id="formPrivilegeExpGrpDtl">
<table border="0" cellspacing="0" cellpadding="3" width="100%" height='100%' align="center">
<%if(exception_type.equals("OC") || exception_type.equals("OT")){%>
<tr>
	<td class="label" width='27%' colspan='2'><fmt:message key="eOR.GroupID.label" bundle="${or_labels}"/></td>
	<td class="fields" colspan='3'><input type='text' name="grp_exception_id" id="grp_exception_id" value="<%=grp_exception_id%>" size="10" maxlength="10" <%=disabled%> onKeyPress="return CheckForSpecChars(event);"><img src="../../eCommon/images/mandatory.gif"  align=center></img></td>
</tr>
<tr>
	<td class="label" width='27%' colspan='2'><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
	<td class="fields" colspan='3'><input type='text' name="grp_exception_name" id="grp_exception_name" value="<%=grp_exception_name%>" size="30" maxlength="30" <%=disabled%>><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<%}else if(exception_type.equals("OR")){%>
<tr>
	<td class="label" ><fmt:message key="eOR.GroupID.label" bundle="${or_labels}"/></td>
	<td class='fields'><input type='text' name="grp_exception_id" id="grp_exception_id" value="<%=grp_exception_id%>" size="10" maxlength="10" <%=disabled%> onKeyPress="return CheckForSpecChars(event);"><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
	<td class="label" nowrap><fmt:message key="Common.GroupName.label" bundle="${common_labels}"/></td>
	<td class='fields'><input type='text' name="grp_exception_name" id="grp_exception_name" value="<%=grp_exception_name%>" size="25" maxlength="30" <%=disabled%>><img src="../../eCommon/images/mandatory.gif" align=center></img></td>
</tr>
<td class='columnheader' colspan="5" ><fmt:message key="eOR.ExceptionIdentifier.label" bundle="${or_labels}"/></td>
<tr>
	<td class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td class="fields"><select name="order_category" id="order_category" onChange='fillComboOptions(this);'><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option> <%=bean.getComboOptionsOrCat()%></select></td>
	<td class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
	<td class='fields' id="order_type_id"><select name="order_type_code" id="order_type_code"><option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option><%=bean.getComboOptionsOrType()%></select></td>
</tr>
<%}%>
<%if(!exception_type.equals("OC")){%>
<tr>
	<td colspan='5'>
	<tr>
		<td colspan='5' >
			<table align='left' cellspacing='0' cellpadding='3' width="30%" border='1'>
				<tr>
					<td align="center" id="SelectTab" class="clicked" width="15%" height="20" onClick='dispLink("S")'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
					<td align="center" id="AssociateTab" class="normal" width="15%" height="20" onClick='dispLink("A")'><fmt:message key="Common.Associate.label" bundle="${common_labels}"/></td>
				</tr>
			</table>
		</td>
	</tr> 
	</td>
</tr>
<tr>
	<td colspan='5' align='left' id='linkId'>
	<jsp:include page="OrCommonAlphaLink.jsp" flush="true"/>
	</td>
</tr>
<%}else{%>
<tr><td colspan="5"></td></tr>
<tr><td colspan="5"></td></tr>
<%}%>
</table>
<input type='hidden' name="exception_type" id="exception_type" value="<%=exception_type%>">
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="tabVal" id="tabVal" value="S">
<input type="hidden" name="bean_mode" id="bean_mode" value="<%=bean_mode%>">			
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
</form>
</body>
</html>
<%
		putObjectInBean(bean_id,bean,request);
 
%>

