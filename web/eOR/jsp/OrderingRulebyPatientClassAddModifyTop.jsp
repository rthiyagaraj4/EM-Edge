<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--OrderingRulebyPatientClass.jsp -->
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %> 
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../js/OrderingRulebyPatientClass.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head><body onload='FocusFirstElement()'  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderingRulebyPatientClass" ;
	String bean_name = "eOR.OrderingRulebyPatientClass";
	//String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	//ArrayList responsibility_Data = new ArrayList();
	//ArrayList OrderType_Data = new ArrayList();

	String responsibility_id = (String)session.getValue("responsibility_id") ;

	//if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
	//	return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	OrderingRulebyPatientClass bean = (OrderingRulebyPatientClass)getBeanObject( bean_id,bean_name,request) ;  
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;




/* Initialize Function specific end */
//	if ( mode.equals( CommonInterface.MODE_MODIFY )  || mode.equals( CommonInterface.MODE_DELETE ) ) {
		

//	}
%>
<form name='OrderingRuleby_PatientClass' id='OrderingRuleby_PatientClass' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" height='100%' align=center>
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td class='fields'><SELECT name="order_category" id="order_category" onChange='populatePatientClass(this)'>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
			try{
				Category_Data = bean.getAllOrderCategory();
				String[] record=null;

				for(int i=0; i<Category_Data.size(); i++){
					record = (String [])Category_Data.get(i);
			
		%>
				<option value=<%=record[0]%>><%=record[1]%>
		<%	
				}Category_Data=null;
			}catch(Exception e){
				System.out.println(e);
			}
		%>
			</SELECT>
		<img src="../../eCommon/images/mandatory.gif" align=center></td>

		</td>
	</tr>
	
	
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="responsibility_id" id="responsibility_id" value="<%=responsibility_id%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

</form>

</body>
</html>
<%
putObjectInBean( bean_id, bean, request) ;
%>

