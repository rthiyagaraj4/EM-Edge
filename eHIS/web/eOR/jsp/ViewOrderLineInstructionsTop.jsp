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
28/07/2014		IN049419		Karthi L			24/08/2014		Ramesh			An Audit Trail for Additional Information Amendment of Order										
15/09/2014		IN051122		Karthi L			15/09/2014		Ramesh			Audit History is not displayed at Task list after Register Order
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
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

	<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
</head>
<body  OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = "Or_ViewOrder" ;
	String bean_name = "eOR.ViewOrder";
	String call_from = request.getParameter("from")==null?"":request.getParameter("from");
	String line = request.getParameter("line")==null?"":request.getParameter("line");
	String orderId = "";
	orderId = request.getParameter("orderId")==null?"":request.getParameter("orderId");
	String order_line_num = request.getParameter("order_line_num");
	String field_mnemonic = request.getParameter("field_mnemonic");
	String max_seq = request.getParameter("max_seq");
	if(max_seq==null) max_seq="";
	String max_action_seq_num = max_seq;
	String can_reason = "Comments";
	int max_num = 0;
	String	audit_comments_reqd = request.getParameter("audit_comments_reqd")==null?"":request.getParameter("audit_comments_reqd"); // added for IN051122
	String	instrn_type = request.getParameter("instrn_type")==null?"":request.getParameter("instrn_type");//IN64543
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
 
	bean.clear() ;

	if(max_action_seq_num.equals(""))
		max_action_seq_num		= bean.getOrderLineInstMaxCount(orderId, order_line_num, field_mnemonic);
	if(max_action_seq_num == null)
		max_action_seq_num = "";
	else 
		max_action_seq_num = max_action_seq_num.trim();
	
	max_num = Integer.parseInt(max_action_seq_num); 	
	if(max_num >1){
		for(int i=1; i<=max_num; i++){
			
			if(i==max_num){
				if(call_from.equalsIgnoreCase("line")) {	
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href=PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Instructions")) {
						//out.println("<a id='a"+i+"' href=ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {					
						//out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
				else {
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href=ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("DEPT_INSTRNS")) {
						//out.println("<a id='a"+i+"' href=ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("PATIENT_INSTRNS")) {					
						//out.println("<a id='a"+i+"' href=viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {	
						//out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href=ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\" onclick=\"highLightLink ('"+i+"','"+max_num+"');\"><U>"+i+"</U></a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
			}
			else {
				if(call_from.equalsIgnoreCase("line")) {	
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href =PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =PrepsComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Instructions")) {
						//out.println("<a id='a"+i+"' href =ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewInstructions.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {					
						//out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&from="+call_from+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
				else {
					if(field_mnemonic.equalsIgnoreCase("PAT_PREPS_TEXT")) { 
						//out.println("<a id='a"+i+"' href =ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewPrepsData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("DEPT_INSTRNS")) {
						//out.println("<a id='a"+i+"' href =ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewDeptData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("PATIENT_INSTRNS")) {					
						//out.println("<a id='a"+i+"' href =viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =viewPatientData.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					} else if(field_mnemonic.equalsIgnoreCase("Comments")) {					
						//out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
						out.println("<a id='a"+i+"' href =ViewLineComment.jsp?orderId="+orderId+"&curr_sequ_num="+i+"&order_line_num="+order_line_num+"&field_mnemonic="+field_mnemonic+"&max_action_seq_num="+max_action_seq_num+"&can_reason="+can_reason+"&line="+line+"&audit_comments_reqd="+audit_comments_reqd+"&instrn_type="+instrn_type+" target=\"ViewHeaderCommentDetail\"onclick=\"highLightLink ('"+i+"','"+max_num+"');\">"+i+"</a>");  // added 'audit_comments_reqd' for IN051122//IN64543
					}
				}
			}		
		}
	}	
%>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

