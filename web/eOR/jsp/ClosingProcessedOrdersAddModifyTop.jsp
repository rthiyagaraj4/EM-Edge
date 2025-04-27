<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
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
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="JavaScript" src="../js/ClosingProcessedOrders.js"></script>
<script language='javascript'>
function CheckPositiveNumber1(obj) {
	if ( trimCheck(obj.value) && isNaN(obj.value) == false && obj.value >= 0) {
	}
	else {
		if ( obj.value.length > 0 ) {
			alert(getMessage("ONLY_POSITIVE_NUM","OR"));
			obj.select();
			obj.focus();
		}
		else if ( obj.value.length == 0 )
			obj.value = 0;
	}
}

</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	

</head>
<body onload='FocusFirstElement()' OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">

  <%
	/* Mandatory checks start */
	request.setCharacterEncoding("UTF-8");
	String mode				= request.getParameter( "mode" ) ;
	String function_id		=  request.getParameter( "function_id" ) ;
	String bean_id			= "Or_Cl_Process_Order" ;
	String bean_name		= "eOR.ClosingProcessOrderBean";
	String facility_id = (String)session.getValue("facility_id") ;

	ArrayList orderType=new ArrayList();
	ArrayList Category_Data=new ArrayList();
	
	
	if ( mode == null || mode.equals("") )
		return ;


	ClosingProcessOrderBean bean = (ClosingProcessOrderBean)getBeanObject( bean_id,bean_name,request ) ;
	bean.clear() ;
	bean.setLanguageId(localeName);
	bean.setMode(mode);
  %>

   <form name="frm_closed_processed_order" id="frm_closed_processed_order" method="post" target="messageFrame">
   <table cellpadding="3" cellspacing="0" width="100%" align="center">
	<tr>
	<td colspan="5"></td>
	</tr>
	<tr>
	<td class="label" ></td>
	<td class="label"><fmt:message key="Common.OrderCategory.label" bundle="${common_labels}"/></td>
	<td colspan='2' class='fields'><select name="order_category" id="order_category"  onChange="populateOrderTypes(this);populatePatientClass();" readOnly>  
	<option>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
      <%
				Category_Data = bean.getAllOrderCategory();

				String[] record1=null;
			
				for(int i=0; i<Category_Data.size() ; i++)
				{
						 record1 = (String []) Category_Data.get(i);
				%>	
						<option value="<%=record1[0]%>" ><%=record1[1]%> </option>   
				<%
					}
					Category_Data=null;
				%> 
		</select>
		<img src="../../eCommon/images/mandatory.gif" align=center></img>
		</td>
		<td class="label" ></td>
		<td class="label"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
		<td colspan='2' class='fields'><select name="order_type" id="order_type"  onChange="populatePatientClass();" readOnly>  
		<option>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
         <%
					String ord_cat="";
					orderType = bean.getClosedOrderType(ord_cat);

					String[] record=null;
				
					for(int i=0; i<orderType.size() ; i++)
					{
							 record = (String []) orderType.get(i);
					%>	
							<option value="<%=record[0]%>" ><%=record[1]%> </option>   
					<%
					}
					orderType=null;
					%> 
		</select><img src="../../eCommon/images/mandatory.gif" align=center></img>
	     </td>
	
	     <td class="label" ></td>
		 </tr>
		 <tr>
		<td colspan="5"></td>
		</tr>
		</table>
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">  
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
		<input type="hidden" name="function_id" id="function_id" value="<%= function_id	%>">
		<input type="hidden" name="localeName" id="localeName" value="<%=localeName%>">
		<input type="hidden" name="facility_id" id="facility_id" value=<%=facility_id%>>
		</form>
	 </body>
</html>
<%
putObjectInBean( bean_id,bean,request ) ;
%>

