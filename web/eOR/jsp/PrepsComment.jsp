<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- 
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
11/08/2014		IN049419		Karthi L			24/08/2014		Ramesh			An Audit Trail for Additional Information Amendment of Order
15/09/2014		IN051122		Karthi L			15/09/2014		Ramesh			Audit History is not displayed at Task list after Register Order			
16/09/2014		IN051127		Karthi L			16/09/2014		Ramesh			View Audit trail->All the text of entered reason is displayed in same line		
18/09/2014		IN051106		Karthi L			18/09/2014		Ramesh			Selected Amend reason is not displaying for recent Amend Audit.		
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
20/11/2018		ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108
--------------------------------------------------------------------------------------------------------------
-->

<%-- JSP Page specific attributes start --%>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>  
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
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
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
 	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

			<style>
textarea {
  resize: none;
}
</style>
	<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>
	<title><fmt:message key="eOR.Preps.label" bundle="${or_labels}"/></title>
</head>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%

	String bean_id = "Or_ExistingOrder" ;
	String bean_name = "eOR.ExistingOrder";
	String orderId   = CommonBean.checkForNull(request.getParameter("orderId"));
 	String order_line_num   = CommonBean.checkForNull(request.getParameter("order_line_num"));
 	
	//ExistingOrder bean = (ExistingOrder)mh.getBeanObject( bean_id, request,  bean_name ) ; 
	ExistingOrder bean = (ExistingOrder)getBeanObject( bean_id, bean_name, request ) ;
	//IN049419 - Start
	String bean_id1			= "Or_ViewOrder";
	String bean_name1 		= "eOR.ViewOrder";
	ViewOrder bean1 		= (ViewOrder)getBeanObject( bean_id1, bean_name1, request ) ;
	String audit_reqd_yn 	= bean.getOrderFormatAuditTrailYN();
	String max_seq = request.getParameter("max_seq")==null?"":request.getParameter("max_seq") ;	
	String field_mnemonic = request.getParameter("field_mnemonic")==null?"":request.getParameter("field_mnemonic");
	String curr_sequ_num = request.getParameter("curr_sequ_num")==null?"":request.getParameter("curr_sequ_num");
	String instrn_type = request.getParameter("instrn_type")==null?"":request.getParameter("instrn_type");//IN64543
	String base_max_sequ_num = "0";
	String modified_max_sequ = "";
	int modified_max_sequ_num = 0;
	//int curr_mod_sequ_num = 0;//commented for checkstyle
	String max_num = "0";
	String max_action_seq_num = "";
	String amend_date = "";
	String amend_by = "";
	String amend_rson = "";
	String prepsdata = "";
	if(max_seq==null) max_seq="";
		max_action_seq_num = max_seq;

	String	audit_comments_reqd = request.getParameter("audit_comments_reqd")==null?"":request.getParameter("audit_comments_reqd"); // added for IN051122
	int amendRsonLength = 0; //IN051127
	HashMap orderLineMap = null;
	//IN049419 - End
	/*String prepsdata = bean.getPrepsdata(orderId.trim(),order_line_num.trim()) ;
	
	if(prepsdata.equals(null) || prepsdata==null || prepsdata.equals("null") || prepsdata.equals("") )
		prepsdata = "";*/
	//String prepsdata		= CommonBean.checkForNull(bean.getPrepsdata(orderId.trim(),order_line_num.trim())); - commented for IN049419
	//IN049419 - Start
	try{
		if(audit_reqd_yn.equalsIgnoreCase("Y")) {
			base_max_sequ_num = bean1.getOrderLineInstMaxCount(orderId, order_line_num, field_mnemonic);
			
			modified_max_sequ_num = Integer.parseInt(base_max_sequ_num);
			modified_max_sequ_num = modified_max_sequ_num + 1;
			modified_max_sequ = Integer.toString(modified_max_sequ_num);
			
			if(curr_sequ_num == null || curr_sequ_num.equals(modified_max_sequ)){
				if(max_action_seq_num.equals(""))
					max_action_seq_num		=  base_max_sequ_num;
				if(max_action_seq_num == null)
					max_action_seq_num = "";
				else 
					max_action_seq_num = max_action_seq_num.trim();
				
				max_num = max_action_seq_num;
	
			}else{
				max_num = curr_sequ_num;
			}
			
			if(curr_sequ_num.equals("") || modified_max_sequ.equals(curr_sequ_num) ) {
				prepsdata = CommonBean.checkForNull(bean.getPrepsdata(orderId.trim(),order_line_num.trim())); 
				//orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, field_mnemonic, localeName); - IN051106
				//IN051106 - Start
				if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
	 				orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, max_seq, field_mnemonic, localeName);
				}
				else {
					orderLineMap = bean1.getCurrentOrderLineInstructions(orderId, order_line_num, curr_sequ_num, field_mnemonic, localeName);
				}
				//IN051106 - End
				if(orderLineMap != null){
						amend_by = (String)orderLineMap.get("ADDED_NAME")==null?"":(String)orderLineMap.get("ADDED_NAME");
						amend_date = (String)orderLineMap.get("ADDED_DATE")==null?"":(String)orderLineMap.get("ADDED_DATE");
						amend_date = com.ehis.util.DateUtils.convertDate(amend_date,"DMYHM","en",localeName);
						amend_rson = (String)orderLineMap.get("AMEND_REASON")==null?"":(String)orderLineMap.get("AMEND_REASON"); //IN051106
				}
			}
			else {
				if(max_num != null && max_num != "") { 
					orderLineMap = bean1.getOrderLineInstructions(orderId, order_line_num, max_num, field_mnemonic, localeName);
					if(orderLineMap != null) {
						prepsdata = (String)orderLineMap.get("ORDER_LINE_FIELD_VALUE")==null?"":(String)orderLineMap.get("ORDER_LINE_FIELD_VALUE");
						amend_by = (String)orderLineMap.get("ADDED_NAME")==null?"":(String)orderLineMap.get("ADDED_NAME");
						amend_date = (String)orderLineMap.get("ADDED_DATE")==null?"":(String)orderLineMap.get("ADDED_DATE");
						amend_rson = (String)orderLineMap.get("AMEND_REASON")==null?"":(String)orderLineMap.get("AMEND_REASON");
						amend_date = com.ehis.util.DateUtils.convertDate(amend_date,"DMYHM","en",localeName);
					}	
				}
			}
			// IN051127 - Start	
			if(!amend_rson.equals("") && !amend_rson.equals(null)){
				amendRsonLength = amend_rson.length();
			}
			// IN051127 - End
		}
		else {
			prepsdata = CommonBean.checkForNull(bean.getPrepsdata(orderId.trim(),order_line_num.trim())); 
			prepsdata = java.net.URLDecoder.decode(prepsdata,"UTF-8");
	
		}
	}
	catch(Exception ex){
		System.err.println(" PrepsComment.jsp " + ex.getMessage());
		ex.printStackTrace();
	}
	//IN049419 - End
%>
<FORM METHOD=POST ACTION="">
<!--<table cellpadding=3 cellspacing=0 border=0 align=center width="100%" height="100%">--><!--IN64543-->
<table cellpadding=3 cellspacing=0 border=0 align=center width="100%"><!--IN64543-->
<%
if("T".equals(instrn_type))//IN64543
{
%>
<tr><td><TEXTAREA NAME="" ROWS="6" COLS="61" readonly><%=prepsdata%></TEXTAREA></td></tr>
<% 
}
%>
</table>
<%
//IN64543, starts
if("E".equals(instrn_type))
{
%>
 <div class="outer-container" style='width:630px;height:435px'>
    <div class="top-section" style='width:630px;height:435px;overflow:auto'>
      <%=prepsdata%>    
    </div>
  </div>
<%
}
//IN64543, ends
%>
<table cellpadding=3 cellspacing=0 border=0 align=center width="100%"><!--IN64543-->
<!-- IN049419 - Start -->
<% if(audit_reqd_yn.equalsIgnoreCase("Y")) { 
	if(audit_comments_reqd.equalsIgnoreCase("Y")) { // IN051122
		//ML-MMOH-SCF-1108 start
		String seqStr = "".equals(max_seq)?curr_sequ_num:max_seq;
		int max_seq_int = Integer.parseInt(seqStr);
%>
		<tr>
			<td  class='LABEL'>
				 <%if(max_seq_int>1){ %><fmt:message key="eOR.amenddate.label" bundle="${or_labels}"/><%}else{%><fmt:message key="Common.OrderDate.label" bundle="${common_labels}"/><%}%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=amend_date %>
			</td>
		</tr>
		<tr>
			<td class='LABEL'> 
				 <%if(max_seq_int>1){ %><fmt:message key="eOR.amendby.label" bundle="${or_labels}"/><%}else{%><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/><%}%> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;: <%=amend_by%>
			</td>
		</tr>
		<tr>
			<td class='LABEL'>  
				  <%if(max_seq_int>1){ %><fmt:message key="eOR.amendreason.label" bundle="${or_labels}"/><%}else{%> <fmt:message key="Common.Order.label" bundle="${common_labels}"/>  <fmt:message key="Common.reason.label" bundle="${common_labels}"/><%}%> &nbsp;: 
		<%//ML-MMOH-SCF-1108
		// IN051127 - Start
		if(amendRsonLength > 30) { 
			//IN051106 - Start
			if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
				
				max_num = max_seq;
			}
			else {
				max_num = curr_sequ_num;
			}
			modified_max_sequ_num = Integer.parseInt(max_num);
			modified_max_sequ_num = modified_max_sequ_num - 1;
			max_num = Integer.toString(modified_max_sequ_num);
			//IN051106 - End
		%>
			<a class="gridLink" href="javascript:ShowComments('<%=orderId%>','<%=max_num%>')"><%=amend_rson.substring(0,29)%>...</a>
		<% }else {%> <%=amend_rson %> <% } // IN051127 - End%>	
		</td></tr>
<% 	}  } //IN051122%>
<!--  IN049419 - End -->
<tr><td align='right' colspan= '2' align='right'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='toCloseTopShowModal();'></td></tr>
</table>
</FORM>
</BODY>
</HTML>
<%
	putObjectInBean(bean_id,bean,request);
%>

