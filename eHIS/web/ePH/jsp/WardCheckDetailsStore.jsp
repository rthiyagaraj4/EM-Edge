<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"
	import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.* "%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<%-- Mandatory declarations end --%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
25/03/2019	  	IN067953	        Devindra  											MMS-KH-CRF-0014 [IN:067953] 
28/01/2021	  	12662	        	Manickavasagam J  										MMS-KH-CRF-0039
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<html>
<head>
<title>Dispense Details</title>
<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'
	type='text/css'></link>
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="Javascript" src="../../ePH/js/WardAcknowledge.js"></script>
<script language="Javascript" src="../../eCommon/js/CommonLookup.js"></SCRIPT>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language="javascript" src="../../eCommon/js/dchk.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body >
	<%
		 try{
			String bean_id		= "WardAcknowledgeBean";
			String bean_name	= "ePH.WardAcknowledgeBean";
			String facility_id					= (String) session.getValue("facility_id");

			WardAcknowledgeBean bean = (WardAcknowledgeBean)getBeanObject( bean_id,bean_name,request) ;
			//bean.clear() ;
			bean.setLanguageId(locale);
			String	dispNo 				= 	CommonBean.checkForNull(request.getParameter("dispNo"));
			String	srlNo			=	CommonBean.checkForNull(request.getParameter("srlNo"));
			String  Status          = CommonBean.checkForNull(request.getParameter("chk"));
			String  orderStatus     = CommonBean.checkForNull(request.getParameter("orderStatus")); // Added for MMS-KH-CRF-0014 [IN:067953]
		        String orderlineNo      = CommonBean.checkForNull(request.getParameter("orderlineNo")); // Added for MMS-KH-CRF-0014 [IN:067953]
		        String orderId      = CommonBean.checkForNull(request.getParameter("orderId")); // Added for MMS-KH-CRF-0014 [IN:067953]
			String order_type       = CommonBean.checkForNull(request.getParameter("order_type"));
			bean.setOrderType(order_type);
			if(orderStatus.trim().equals("DF")){
				orderStatus = "DE";
			}
			else if(orderStatus.trim().equals("DP")){
				orderStatus = "DD";
			}
			HashMap		bill_data   = new HashMap();
			bill_data=bean.getCommonStoreMap();
			if(order_type.equals("A")){
				
				if(Status.equals("chk")){
					 bill_data.put(orderId+"_"+dispNo,"Y"); 
				}
				else{
					bill_data.remove(orderId+"_"+dispNo); 
				}
			}else{
				if(Status.equals("chk")){
				 bill_data.put(dispNo+"_"+srlNo+"_"+orderId+"_"+orderlineNo+"_"+orderStatus,srlNo); // orderlineNo,orderlineNo and orderStatus Added for MMS-KH-CRF-0014 [IN:067953]
				}
				else{
					bill_data.remove(dispNo+"_"+srlNo+"_"+orderId+"_"+orderlineNo+"_"+orderStatus); // orderlineNo,orderlineNo and orderStatus Added for MMS-KH-CRF-0014 [IN:067953]
				}
			}
			
//			System.out.println(bill_data);
			bean.setCommonStoreMap(bill_data);
}catch(Exception e){
	e.printStackTrace();
}
			
%>

		
</body>
</html>

