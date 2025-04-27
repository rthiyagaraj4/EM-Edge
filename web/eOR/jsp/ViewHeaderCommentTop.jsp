<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<% 
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
--------------------------------------------------------------------------------------------------------------
07/05/2014		IN048464		Karthi L			07/05/2014		Ramesh			History added for clinical comments																		
--------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%-- Mandatory declarations end --%>

<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";

	String orderId = request.getParameter("orderId");
	String max_seq = request.getParameter("max_seq");
	if(max_seq==null) max_seq="";
	String max_action_seq_num = max_seq;
/* Mandatory checks end */
	
	/* Initialize Function specific start */
	//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;
	bean.setMode( mode ) ;
	if(max_action_seq_num.equals(""))
	max_action_seq_num		= bean.getMaxCount(orderId);
	if(max_action_seq_num == null)
		max_action_seq_num = "";
	else 
		max_action_seq_num = max_action_seq_num.trim();
	
	//int max_num = Integer.parseInt(max_action_seq_num);
	int max_num = Integer.parseInt(max_action_seq_num); 	//IN048464

//	out.println("bean values : >"+bean.chk+"<<br>");
//	out.println("<BR>"+orderId + "==="+ max_action_seq_num);
//out.println("<script>alert('max_action_seq_num="+max_action_seq_num+"');</script>");
//out.println("<script>alert('max_num="+max_num+"');</script>");
	/*for(int i=1; i<=max_num; i++){
		out.println("<a href=ViewHeaderCommentDetail.jsp?orderId="+orderId+"&num="+i+" target=\"ViewHeaderCommentDetail\">"+i+"</a>");
	}*/
	//IN048464 - Start 
	if(max_num >1){
		for(int i=1; i<=max_num; i++){
			
			if(i==max_num){
				out.println("<a id='a"+i+"' href=ViewHeaderCommentDetail.jsp?orderId="+orderId+"&num="+i+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");
			}
			else {
				out.println("<a id='a"+i+"' href =ViewHeaderCommentDetail.jsp?orderId="+orderId+"&num="+i+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");
			}	
		
		}
	}
	//IN048464 - End
%>

</body>
</html>

<%
	putObjectInBean(bean_id,bean,request);

%>

