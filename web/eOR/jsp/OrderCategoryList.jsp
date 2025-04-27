 <!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!--
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
20/07/2012    IN033471      NijithaS    System does not filter the Order Categories in One Day and Continue Order.      
28/02/2022    IN27707      Suji Keerthi G    SKR-CRF-0052     
28/06/2022	  32825			Ramesh G 			SKR-SCF-1681 		  
-----------------------------------------------------------------------
--> 
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@page import="java.sql.*,webbeans.eCommon.*"%>

<%-- Mandatory declarations end --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="bean" scope="page" class="eOR.ExistingOrder"/>
 

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../../eCommon/js/dchk.js"></script><!-- used for date validation-->
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../../eOR/js/ExistingSingleOrder.js"></script>
 	<script language="JavaScript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function colorchange(obj,category_size)
{

	document.getElementById('ALL').style.backgroundColor  = "#5D8691";
	document.getElementById('cust_cat').style.backgroundColor  = "#5D8691";
	for(var i=1;i<=category_size.value;i++)
	{
		var temp_cat = "cat"+i;
		document.getElementById(temp_cat).style.backgroundColor  = "#5D8691";
	}
	obj.style.backgroundColor  = "#B8CFD5";
}
function populateCategoryValues(orderCat,catType)
{
	params = "<%=request.getQueryString()%>";
	//params=params+"&order_category="+orderCat+"&called_from=CategoryList&category_type="+catType;
	params=params+"&ordercate_for_filter="+orderCat+"&called_from=CategoryList&category_type="+catType;//IN033471
	
	parent.ExistingOrderResult.location.href = "../../eOR/jsp/ExistingSingleOrderResults.jsp?"+params;
}
async function callCusCategory()
{
	var retVal 			= 	new String();
	var dialogHeight 	= "43vh" ;
	var dialogWidth  	= "34vw" ;
	var dialogTop    	= "100";
	var dialogLeft    	= "90";
	var status 			= "no";
	var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth +" ; dialogTop:"+dialogTop+"; scroll=auto; status:no";
	retVal = await top.window.showModalDialog("../../eOR/jsp/CustomCategory.jsp?module_id=OR&function_id=ORMS_CUSTOM_CATEGORY&function_name=Custom%20Category&function_type=F&access=NYNNN",arguments,features);
	//window.location.reload();
	//window.OrderCategoryList.document.location = "../../eOR/jsp/OrderCategoryList.jsp?mode=CUST_CAT"
}
</script>
</head>
<Body>
<%
request.setCharacterEncoding("UTF-8"); //IN27707
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	String locale = (String) p.getProperty("LOCALE");
	String login_user	= (String)session.getValue("login_user");
    //IN27707 Starts
	String bean_id 		= "@existingorderbean";
 	String bean_name = "eOR.ExistingOrder";
	String facility_id = (String)session.getValue("facility_id");
	String practitioner_type  	= (String) session.getValue("practitioner_type");
	ExistingOrder beanObj = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	String practBasedOrderCat =beanObj.getPractBasedOrderCategory(facility_id,practitioner_type);
		String call_from = request.getParameter("call_from") == null ? "" : request.getParameter("call_from");
	if(call_from.equals("undefined")) call_from = "";
	//IN27707 Ends
	String slClassValue = "";
	slClassValue="gridData";
	Connection connection 		= null;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 			= null;
	
	ArrayList OrderCat = new ArrayList() ;
	String[] record = new String[2];
	
	int i=0;
	int size =0; 
	String mode = "";
	mode = request.getParameter("mode");	
	if(mode==null) mode= "";
	String sql = "";

	//IN27707 Starts
	boolean isDfltOrderSts = false;
	try {	
		connection				= ConnectionManager.getConnection(request);
		isDfltOrderSts = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","DEFAULT_ORDER_STATUS");
				
	}
	catch (Exception e) {
		e.printStackTrace();
	}
	finally{ 	
		if(connection != null)
			ConnectionManager.returnConnection(connection,request);	
	}
	//IN27707 Ends
	
%>
<form name='OrderCategoryList' id='OrderCategoryList'>
<table style='width:100%'>
<tr>
<td colspan='2' id = 'ALL' name='ALL' <%if((!isDfltOrderSts) || (practBasedOrderCat.equals("ALL")) || (call_from.equals("SEARCH"))) {%>bgcolor="#B8CFD5" <%}else{%> bgcolor="#5D8691" <%}%> style='height:20; color:#FFFFFF' onclick='populateCategoryValues("","I");colorchange(this,category_size)' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='none';" selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></td><!--IN27707-->
</tr>
<tr>
<td id = 'cust_cat' name='cust_cat' bgcolor="#5D8691" style='height:20; color:#FFFFFF;width=200' onclick='populateCategoryValues("","C"); colorchange(this,category_size)' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='none';"><fmt:message key="eOR.CustCat.label" bundle="${or_labels}"/> <a href="#" name='RightStripQL'></td><td bgcolor="#5D8691" style='height:20; color:#FFFFFF;'>&nbsp;&nbsp;<img src="../../eCA/images/customize.gif" alt='<fmt:message key="eOR.CustCat.label" bundle="${or_labels}"/>' name="RightStrip1"  border="0" id="RightStrip1" onclick='callCusCategory();'/></a></td>
</tr>
<%
	
	try 
	{
		connection = ConnectionManager.getConnection() ;
		//IN27707 Starts
		if(isDfltOrderSts){
			pstmt = connection.prepareStatement("select order_category,short_desc from or_order_category order by order_category") ;
			resultSet = pstmt.executeQuery() ;
		}else{
			pstmt = connection.prepareStatement("SELECT  short_desc,order_category FROM or_order_category_lang_vw  WHERE language_id=? AND order_category NOT IN('CS','CN') ORDER BY short_desc") ;
			pstmt.setString( 1, locale);
		resultSet = pstmt.executeQuery() ;
		}
		//IN27707 Ends
		while ( resultSet != null && resultSet.next() ) 
		{
			i++;
			record[0] = resultSet.getString( "order_category" )  ;
			record[1] = resultSet.getString( "short_desc" )  ;
			
			size = resultSet.getRow();
			
				%>
				
			    <tr><td colspan ='2' id ='cat<%=i%>' name='<%=record[0]%>' <%if((isDfltOrderSts) && (record[0].equals(practBasedOrderCat)) && (!call_from.equals("SEARCH"))) {%> bgcolor="#B8CFD5" <%}else{%> bgcolor="#5D8691" <%}%>style='height:22; color:#FFFFFF;width=200' onclick='populateCategoryValues("<%=record[0]%>","I");colorchange(this,category_size)' onMouseOver="this.style.fontWeight = 'bold';this.style.cursor='pointer';" onMouseOut="this.style.fontWeight = 'normal';this.style.cursor='none';"><%=record[1]%></td></tr><!--IN27707-->			
				<%
			 
		}%>
		<input name ='category_size' id ='category_size' type='hidden' value='<%=size%>'>
		<%
		
	} 
	catch ( Exception e )	
	{
		e.printStackTrace() ;
		throw e ; 
	} 
	finally 
	{
		if(resultSet!=null)	resultSet.close();
		if(pstmt!=null)	pstmt.close();
		if(connection!=null)	connection.close();
	}			
%>

</table>
<input type='hidden' name='queryString' id='queryString' value='<%=request.getQueryString()%>'>
<input type='hidden' name='order_category' id='order_category' value='<%=record[0]%>'>
		<input type='hidden' name='call_from' id='call_from' value='<%=call_from%>'> <!-- 32825 -->

</form>
</Body>
</html>

