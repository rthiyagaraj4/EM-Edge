<!DOCTYPE html>
<%@page  import ="eOR.OrderEntryBillingQueryBean"  %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>

<%  
	//bean_id name shouldn't be changed.
	String bean_id 							= "Or_billingQueryBean";
	String bean_name 						= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean bean			= (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request );


	String del_key = request.getParameter("del_key");
	String flag = (bean.removeOrderBillDtls(del_key))?"S":"F";
	out.println( flag );
%>
