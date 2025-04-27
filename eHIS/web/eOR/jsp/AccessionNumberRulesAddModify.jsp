
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.XSSRequestWrapper"%>
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
	<script language="javascript" src="../js/OrCommonFunction.js"></script>
	
 	<script language="JavaScript" src="../js/AccessionNumberRules.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
	//String readOnly = "" ;
	//String checked = "checked" ;
	/* Mandatory checks start */
	
	String mode	   = request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_AccessionNumberRules" ;
	String bean_name = "eOR.AccessionNumberRules";
	//String disabled = "" ;
	ArrayList Category_Data = new ArrayList();
	//ArrayList OrderType_Data = new ArrayList();


//	if ( !(mode.equals( CommonInterface.MODE_MODIFY ) || mode.equals( CommonInterface.MODE_INSERT )) )
//		return ;

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	AccessionNumberRules bean = (AccessionNumberRules)getBeanObject( bean_id, bean_name, request ) ; 
	
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode( mode ) ;

/* Initialize Function specific end */
	if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {

		String ord_cat			= request.getParameter("ord_cat");
		String ord_cat_desc		= request.getParameter("ord_cat_desc");
		String order_type		= request.getParameter("order_type");
		String ord_typ_code		= request.getParameter("ord_typ_code_val");


		bean.setOrderCategory(ord_cat);
		bean.setOrderCategoryDesc(ord_cat_desc);

		bean.setOrderType(ord_typ_code);
		bean.setOrderTypeDesc(order_type);

	}
%>
<form name='accession_numer_rule' id='accession_numer_rule' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td>
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
			<input type=text name="ord_cat_display" id="ord_cat_display" value="<%=bean.getOrderCategoryDesc()%>" readOnly>
			<input type=hidden name="order_category" id="order_category" value="<%=bean.getOrderCategory()%>" ><%}else{%><SELECT name="order_category" id="order_category" onChange='populateOrderTyoes(this)'>
			<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
		<%
			try{
				Category_Data = bean.getAllOrderCategory();

				for(int i=0; i<Category_Data.size(); i++){
					String[] record = (String [])Category_Data.get(i);
			
		%>
				<option value=<%=record[0]%>><%=record[1]%>
		<%	
				}
		 // Category_Data.clear();
			}catch(Exception e){
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
		%>
			</SELECT>
		<%}%><img src="../../eCommon/images/mandatory.gif" align=center></td>

		</td>
	</tr>
	
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td >
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
			<input type=text name="order_type_display" id="order_type_display" value="<%=bean.getOrderTypeDesc()%>" readOnly>
			<input type=hidden name="order_type" id="order_type" value="<%=bean.getOrderType()%>" ><%}else{%><SELECT name="order_type" id="order_type">
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
			</SELECT>
		<%}%><img src="../../eCommon/images/mandatory.gif" align=center></td>
	</tr>
	
	<tr>
		<td width="35%" class="label"><fmt:message key="eMP.prefix.label" bundle="${mp_labels}"/></td>
		<td >
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
		<%}else{%>			<input type=text name=prefix size=2 maxlength=2 onKeyPress='return allowPositiveNumber()' onblur='checkDecimal1(this)'>

		<%}%><img src="../../eCommon/images/mandatory.gif"></td>
	</tr>
	
	<tr>
		<td width="35%" class="label"><fmt:message key="Common.Format.label" bundle="${common_labels}"/></td>
		<td >
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
		<%}else{%>
			<SELECT name="frmat" id="frmat" onChange=changeSize()>
				<option value=''>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---
				<option value='YY'><fmt:message key="eOR.ByYear.label" bundle="${or_labels}"/>
				<option value='YJ'><fmt:message key="eOR.ByYearandJulianDate.label" bundle="${or_labels}"/>
			</SELECT>
		<%}%><img src="../../eCommon/images/mandatory.gif" align=center></td>
	</tr>

	
	<tr>
		<td width="35%" class="label"><fmt:message key="eOR.InitialSerialNumber.label" bundle="${or_labels}"/></td>
		<td >
		<%if ( mode.equals( CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {%>
		<%}else{%><input type=text name=srl_num size=11 maxlength=11 onKeyPress='return allowPositiveNumber()' onblur='checkDecimal1(this)' >

		<%}%><img src="../../eCommon/images/mandatory.gif" align=center></td>
	</tr>	
			   
</table>
<input type="hidden" name="mode" id="mode" value="<%=mode%>">
<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
<input type="hidden" name="function_id" id="function_id" value="<%=bean.getFunctionId()%>">
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">

</form>

</body>
</html>

<%
		putObjectInBean(bean_id,bean,request);
 
%>

