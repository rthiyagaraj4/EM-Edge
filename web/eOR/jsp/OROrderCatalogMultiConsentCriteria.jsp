<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page contentType="text/html; charset=UTF-8"%>
<%@page import="eOR.* ,java.util.ArrayList,eOR.Common.* " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
 <%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
  <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	 String imgUrl="";
	 if(sStyle.equals("IeStyle.css"))
	 {
		 imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/OROrderCatalogMultiConsent.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function popframe(obj) 
	{
		if(obj.value=="P")
		{
			document.Order_Catalog_MultiConsent.definitionSelected.value=obj.value;
			var xyz = document.Order_Catalog_MultiConsent.definitionSelected.value;
		}
		else if(obj.value=="A")
		{
			document.Order_Catalog_MultiConsent.definitionSelected.value=obj.value;
			var xyz = document.Order_Catalog_MultiConsent.definitionSelected.value;
		}
		
	}
	</script>
</head>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%

	/* Mandatory checks start */
	//String mode	   = request.getParameter( "mode" ) ;
//	String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_OrderCatalogMultiConsent" ;
	String bean_name = "eOR.OrderCatalogMultiConsent";

/* Mandatory checks end */
	
	/* Initialize Function specific start */
	OrderCatalogMultiConsent bean = (OrderCatalogMultiConsent)getBeanObject( bean_id,bean_name,request ) ;  
	bean.setLanguageId(localeName);
	bean.clear() ;
	//bean.setMode( mode ) ;

	ArrayList orderCategory = new ArrayList();

%>
<form name='Order_Catalog_MultiConsent' id='Order_Catalog_MultiConsent'>
<INPUT TYPE="hidden" name="definitionSelected" id="definitionSelected" value="">
<INPUT TYPE="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
<INPUT TYPE="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
 	<tr>
		<td width="20%"  class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
		<td width="20%" class="fields">
				<SELECT name="order_category" id="order_category" onChange='populateOrderTypes(this)'>
					<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
				<%
					orderCategory=bean.getAllOrderCategory();
					String[] record=null;
					for(int i=0;i<orderCategory.size(); i++){
						record = (String [])orderCategory.get(i);
						

					%>	
						<option value="<%=record[0]%>" ><%=record[1]%> </option>  
					<%
					}
					orderCategory=null;
				%> 
				</SELECT><img src="../../eCommon/images/mandatory.gif">
		</td>
		<td width="20%"  class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td width="30%" class="fields">
				<SELECT name="order_type" id="order_type">
					<option value="">  --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---  </option>
				</SELECT><img src="../../eCommon/images/mandatory.gif">
		</td>
		</tr>
		<tr>
		<td width="20%" class="label"><fmt:message key="Common.ordercatalog.label" bundle="${common_labels}"/></td>
		<td width="20%" class="fields">
			<input type="text" name="order_catalog" id="order_catalog" value="">	
		</td>
		<td  width="20%" class="label"><fmt:message key="eOR.Limitto.label" bundle="${or_labels}"/></td>
		<td  width="20%" class="fields">
			<input type="radio" name="definitionLimit" id="definitionLimit" class="label" value="P" checked onclick='popframe(this)'><fmt:message key="eOR.PendingDefine.label" bundle="${or_labels}"/>
			<input type="radio" name="definitionLimit" id="definitionLimit" class="label" value = "A" onclick='popframe(this)'><fmt:message key="Common.all.label" bundle="${common_labels}"/>
		</td>
	</tr>
	<TR>
		<td colspan="3"></td>
		<TD class="fields">
			<input type='button' name='field_search' id='field_search' value = <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%> class='button' onClick='search();'>
			<input type='button' name='field_clear' id='field_clear' value = <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>  class='button' onClick='clearScreen();'>
		</TD>
		
	</TR>
	
</table>
<%if(!imgUrl.equals("")){ %>
					 <img src='<%=imgUrl%>' width='100%' height='15'/> 
				<%}%>
<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

