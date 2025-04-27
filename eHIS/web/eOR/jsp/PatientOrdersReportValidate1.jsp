<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, webbeans.eCommon.ConnectionManager,eOR.* ,eOR.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>


	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eOR/js/PatientOrders.js"></script>
	<script language="javascript" src="../../eOR/js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
String p_order_type = "";
ArrayList print_order		= new ArrayList();
String bean_id		= "patient_report" ;
String bean_name	= "eOR.PatientOrdersReportBean";
//PatientOrdersReportBean bean = 	(PatientOrdersReportBean)mh.getBeanObject( bean_id, request,bean_name );  
PatientOrdersReportBean bean = (PatientOrdersReportBean)getBeanObject( bean_id, bean_name, request ) ;
	//java.sql.Connection  conlCon		= null;
	
		
p_order_type = request.getParameter("order_cat");
try
{
	//conlCon = ConnectionManager.getConnection(request);
	if(p_order_type==null || p_order_type.equals(""))
	{
		p_order_type = "";
	}
print_order=bean.getOrderTypeData(p_order_type);
%>
<script>		
	var n= parent.frames[1].document.forms[0].p_order_type_from.options.length;
var n1= parent.frames[1].document.forms[0].p_order_type_to.options.length;
	for(var i=0;i<n;i++){
		parent.frames[1].document.forms[0].p_order_type_from.remove("p_order_type_from");			
	}
	for(i=0;i<n1;i++){
		parent.frames[1].document.forms[0].p_order_type_to.remove("p_order_type_to");			
	}
	var element = parent.frames[1].document.createElement('OPTION');
	    element.text = 'All';
		element.value = '';
parent.frames[1].document.forms[0].p_order_type_from.add(element);

var element1 = parent.frames[1].document.createElement('OPTION');
	    element1.text = 'All';
		element1.value = '';
parent.frames[1].document.forms[0].p_order_type_to.add(element1);
</script>		

<%

	for(int i=0 ; i<print_order.size() ; i++){
		String[] record = (String []) print_order.get(i);%>
			<script>		
		var element = parent.frames[1].document.createElement('OPTION');
	    element.value = '<%=record[0]%>';
		element.text = '<%=record[1]%>';
			//alert('<%=record[0]%>') 
			//alert('<%=record[1]%>') 
		if('<%=record[0]%>' != '')
		 parent.frames[1].document.forms[0].p_order_type_from.add(element);
	
	var element1 = parent.frames[1].document.createElement('OPTION');
	    element1.value = '<%=record[0]%>';
		element1.text = '<%=record[1]%>';
			//alert('<%=record[0]%>') 
			//alert('<%=record[1]%>') 
		if('<%=record[0]%>' != '')
		 parent.frames[1].document.forms[0].p_order_type_to.add(element1);
	</script>
		<%} %>
	

<form name ="PatientOrdersReportValidateForm">
</form>
<%
}
catch(Exception e)
{
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}
	%>
</body>
</html>
<script>
//this.location.href='../../eCommon/jsp/error.jsp'
</script> 

<%
	putObjectInBean(bean_id,bean,request);
%>

