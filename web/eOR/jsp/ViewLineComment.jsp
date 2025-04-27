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
Date       Edit History      Name        		Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           		created
23/07/2012    IN033472      Nijitha S      		System does not display Appointment Reschedule Reason in 
												Existing orders. 
06/11/2012	  IN036049		Vijayakumar K		System doesn?t display cancelled/Discontinued reason		
---------------------------------------------------------------------------------------------------------------
Date       		Edit History    Name        		Rev.Date		Rev.Name 		Description
---------------------------------------------------------------------------------------------------------------
04/08/2014		IN049419		Karthi L			24/08/2014		Ramesh			An Audit Trail for Additional Information Amendment of Order
15/09/2014		IN051122		Karthi L			15/09/2014		Ramesh			Audit History is not displayed at Task list after Register Order
16/09/2014		IN051127		Karthi L			16/09/2014		Ramesh			View Audit trail->All the text of entered reason is displayed in same line										
18/09/2014		IN051106		Karthi L			18/09/2014		Ramesh			Selected Amend reason is not displaying for recent Amend Audit.
10/07/2017		IN061903		Krishna Gowtham J 	10/07/2017		Ramesh G		ML-MMOH-CRF-0555								
23/07/2018		IN64543			Dinesh T		23/07/2018	Ramesh G		ML-MMOH-CRF-0776
20/11/2018		ML-MMOH-SCF-1108		Kamalakannan 		Ramesh G			20/11/2018			ML-MMOH-SCF-1108

--------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>


<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097		
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String line_narration = request.getParameter("line_narration");
	String order_id = request.getParameter("orderId");
	String ord_line_num = request.getParameter("order_line_num");
	//line_narration = java.net.URLEncoder.encode(line_narration,"UTF-8");
	String view_by =request.getParameter("view_by");
	if(view_by == null) view_by="";
	//if(test.equals("null")) test="";
	String line_narration="";
	ArrayList comment_values = new ArrayList();
	String bean_id1 	 = "Or_ExistingOrder" ;
	String bean_name1 = "eOR.ExistingOrder";
	String item_narration="";
	String can_line_reason="";
	String appt_reshedule_reason= "";//IN033472
	String[] record;
	ExistingOrder bean1 = (ExistingOrder)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	//IN049419 - Start
	String bean_id 	  = "Or_ViewOrder" ;
	String bean_name  = "eOR.ViewOrder";
	ViewOrder bean = (ViewOrder)getBeanObject( bean_id,bean_name,request) ; 
	bean.setLanguageId(localeName); 
	String audit_reqd_yn = bean1.getOrderFormatAuditTrailYN();
	String call_from = request.getParameter("from")==null?"":request.getParameter("from");
	String max_seq = request.getParameter("max_seq")==null?"":request.getParameter("max_seq") ;	
	String field_mnemonic = request.getParameter("field_mnemonic")==null?"":request.getParameter("field_mnemonic");
	String curr_sequ_num = request.getParameter("curr_sequ_num")==null?"":request.getParameter("curr_sequ_num");
	String instrn_type = request.getParameter("instrn_type")==null?"T":request.getParameter("instrn_type");//IN64543
	String base_max_sequ_num = "0";
	String modified_max_sequ = "";
	int modified_max_sequ_num = 0;
	//int curr_mod_sequ_num = 0; //Commented for checkstyle
	String max_num = "0";
	String max_action_seq_num = "";
	String amend_date = "";
	String amend_by = "";
	String amend_rson = "";
	//String instruction = ""; //Commented for checkstyle
	HashMap orderLineMap = null;
	if(max_seq==null) max_seq="";
		max_action_seq_num = max_seq;
	String	audit_comments_reqd = request.getParameter("audit_comments_reqd")==null?"":request.getParameter("audit_comments_reqd"); // added for IN051122
	int amendRsonLength = 0; //IN051127
	//IN049419 - End
	
	
	if(view_by.trim().equals("H"))
	{

	comment_values=bean1.getHeaderCommentData(order_id,ord_line_num);
	}
	else
	{
	comment_values=bean1.getCommentData(order_id,ord_line_num);
	}
	

	//comment_values=bean1.getCommentData(order_id,ord_line_num);
	
	for(int i=0; i<comment_values.size(); i++)
	{
		record = (String [])comment_values.get(i);
		if(record[0] == null) record[0] = "";
		if(record[1] == null) record[1] = "";
		if(record[2] == null) record[2] = "";//IN033472
		item_narration=record[0];
		can_line_reason=record[1];
		appt_reshedule_reason=record[2];//IN033472
	}
	String can_reason = request.getParameter("can_reason");
//IN049419 - Start
	if(call_from.equalsIgnoreCase("line")){
		can_reason= "Comments";
	}
// IN049419 - End
	if(can_reason.equalsIgnoreCase("Comments"))
	{
		//IN049419 - Start
		if(audit_reqd_yn.equalsIgnoreCase("Y")) {
			base_max_sequ_num = bean.getOrderLineInstMaxCount(order_id, ord_line_num, field_mnemonic);
			
			modified_max_sequ_num = Integer.parseInt(base_max_sequ_num);
			modified_max_sequ_num = modified_max_sequ_num + 1;
			modified_max_sequ = Integer.toString(modified_max_sequ_num);
			if(curr_sequ_num == null || curr_sequ_num.equals("")){
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
				line_narration=item_narration;
				//orderLineMap = bean.getCurrentOrderLineInstructions(order_id, ord_line_num, field_mnemonic, localeName);
				//IN051106 - Start
				if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
	 				orderLineMap = bean.getCurrentOrderLineInstructions(order_id, ord_line_num, max_num, field_mnemonic, localeName);
				}
				else {
					orderLineMap = bean.getCurrentOrderLineInstructions(order_id, ord_line_num, curr_sequ_num, field_mnemonic, localeName);
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
					orderLineMap = bean.getOrderLineInstructions(order_id, ord_line_num, max_num, field_mnemonic, localeName);
					if(orderLineMap != null){
						line_narration = (String)orderLineMap.get("ORDER_LINE_FIELD_VALUE");
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
		else { //IN049419 - End
			line_narration=item_narration;
		}	
	}
	/*IN036049 starts here*/
	//else if(can_reason.equalsIgnoreCase("Cancel Reason") || can_reason.equalsIgnoreCase("Discontinue") || can_reason.equalsIgnoreCase("Hold") || can_reason.equalsIgnoreCase("Replaced") || can_reason.equalsIgnoreCase("Registered"))
	//IN061903 start
	//else if(can_reason.equalsIgnoreCase("Rejected")||can_reason.equalsIgnoreCase("Cancel Reason") || can_reason.equalsIgnoreCase("Discontinue")||can_reason.equalsIgnoreCase("Cancelled") || can_reason.equalsIgnoreCase("Discontinued") || can_reason.equalsIgnoreCase("Hold") || can_reason.equalsIgnoreCase("Replaced") || can_reason.equalsIgnoreCase("Registered")|| can_reason.equalsIgnoreCase("") ||can_reason.equalsIgnoreCase("On Hold/Prov") ||can_reason.equalsIgnoreCase("On Hold/Dept") )
	/*IN036049 ends here*/
	else if(can_reason.equalsIgnoreCase("Rejected")||can_reason.equalsIgnoreCase("Cancel Reason") || can_reason.equalsIgnoreCase("Discontinue")||can_reason.equalsIgnoreCase("Cancelled") || can_reason.equalsIgnoreCase("Discontinued") || can_reason.equalsIgnoreCase("Hold") || can_reason.equalsIgnoreCase("Replaced") || can_reason.equalsIgnoreCase("Registered")|| can_reason.equalsIgnoreCase("") ||can_reason.equalsIgnoreCase("On Hold/Prov") ||can_reason.equalsIgnoreCase("On Hold/Dept") || can_reason.equalsIgnoreCase("Not Done") )
	//IN061903 ends
	{
		line_narration=can_line_reason;
	}
	// IN033472 Starts
	else if(can_reason.equalsIgnoreCase("Appointment Re-schedule Reason")){
		line_narration=appt_reshedule_reason;
	}
	// IN033472 Ends
	
	//	can_reason = java.net.URLDecoder.decode(can_reason,"UTF-8");
//IN049419 - Start
	if(line_narration == null ){
		line_narration = "";
	}
//IN049419 - End

	if(can_reason == null || can_reason.equals("null"))
		can_reason = "Comments";
	String cancel_date_time = request.getParameter("cancel_date_time");
	if(cancel_date_time == null || cancel_date_time.equals("null"))
		cancel_date_time = "";
	String cancel_pract_id = request.getParameter("cancel_pract_id");
	if(cancel_pract_id == null || cancel_pract_id.equals("null"))
		cancel_pract_id = "";	
		
	String practitioner_name	= "";	
	 //String order_id=request.getParameter("order_id");
	
  
 //	String bean_id 	 = "Or_ViewOrder" ; moved top for IN049419
//	String bean_name = "eOR.ViewOrder"; moved top for IN049419
	
	
 
	/* Mandatory checks end */
 	/* Initialize Function specific start */
	if(!cancel_pract_id.equals("")) 
	{
		//ViewOrder bean = (ViewOrder)mh.getBeanObject( bean_id, request,  bean_name ) ;
		//ViewOrder bean = (ViewOrder)getBeanObject( bean_id,bean_name,request) ; moved top for IN049419 
		//bean.setLanguageId(localeName); moved top for IN049419 

  		practitioner_name = bean.getPractitionerName(cancel_pract_id);
		if(practitioner_name==null) practitioner_name = "";

		putObjectInBean(bean_id,bean,request);
	}		
	
%>
<html>
<head>
<%
if(can_reason.equalsIgnoreCase("Cancel Reason"))
{
%>
	<title><fmt:message key="eOR.CancelReason.label" bundle="${or_labels}"/></title>
<% 
}else if(can_reason.equalsIgnoreCase("Discontinue"))
{
%>
	<title><fmt:message key="Common.DiscontinueReason.label" bundle="${common_labels}"/></title>
<% 
}else if(can_reason.equalsIgnoreCase("Hold"))
{
%>
	<title><fmt:message key="Common.HoldReason.label" bundle="${common_labels}"/></title>
<% 
}else if(can_reason.equalsIgnoreCase("Replaced"))
{
%>
	<title><fmt:message key="eOR.ReasonForReplace.label" bundle="${or_labels}"/></title>
<%
}else if(can_reason.equalsIgnoreCase("Registered"))
{
%>
	<title><fmt:message key="Common.Registered.label" bundle="${common_labels}"/></title>
<% 
}
else if(can_reason.equalsIgnoreCase("Not Done"))
{
%>
	<title><fmt:message key="eOR.NotDoneReason.label" bundle="${or_labels}"/></title><!--IN061903-->
<% 
}
else if(!can_reason.equals(""))
{
%>
	<title><%=can_reason%></title>
<%
}
else
{
%>
	<title><fmt:message key="Common.Comments.label" bundle="${common_labels}"/></title>
<%
}
String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/ViewOrder.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- IN051127 -->
	<style type='text/css'>ADDRESS{FONT-FAMILY: Arial ;FONT-SIZE: 10pt ;font-style: NORMAL;COLOR: BLACK;}</style>

</head>
<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
<FORM METHOD=POST ACTION="">
<!--<table cellpadding=3 cellspacing=0 border=0 align=center width="100%" height="100%">--><!--IN64543-->
<table cellpadding=3 cellspacing=0 border=0 align=center width="100%">
<%
if("T".equals(instrn_type))//IN64543
{
%> 
<tr><td class='fields' colspan ='2'><TEXTAREA NAME="" ROWS="6" COLS="61" readonly><%=line_narration%></TEXTAREA></td></tr>
<%
}
%>
</table>
<%
//IN64543, starts
if("E".equals(instrn_type))
{
%>
 <div class="outer-container" style='width:640px;height:435px'>
    <div class="top-section" style='width:640px;height:435px;overflow:auto'>
		<table cellpadding='3' cellspacing='0' border='0' align='center' width="100%">			
			<tr>
			  <td>
			  	<%=line_narration%>
			  </td>
			</tr>  
		</table>          
    </div>   
  </div>
<%
}
//IN64543, ends
%>
<table cellpadding=3 cellspacing=0 border=0 align=center width="100%"><!--IN64543-->
<!-- IN049419 - Start -->
<% if(audit_reqd_yn.equalsIgnoreCase("Y") && can_reason.equalsIgnoreCase("Comments")) { 
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
	<%
	//ML-MMOH-SCF-1108 end
		// IN051127 - Start
		if(amendRsonLength > 30) { 
			//IN051106 - Start
			if(curr_sequ_num.equals("") || curr_sequ_num.equals(null)){
				
				max_num = max_num;
			}
			else {
				max_num = curr_sequ_num;
			}
			modified_max_sequ_num = Integer.parseInt(max_num);
			modified_max_sequ_num = modified_max_sequ_num - 1;
			max_num = Integer.toString(modified_max_sequ_num);
			//IN051106 - End
		%>
			<a class="gridLink" href="javascript:ShowComments('<%=order_id%>','<%=max_num%>')"><%=amend_rson.substring(0,29)%>...</a>
		<% }else {%> <%=amend_rson %> <% } // IN051127 - End %>	
		</td></tr>
<%  } }  // IN051122%>	
<!-- IN049419 - End -->
<% if(!cancel_date_time.equals("") || !practitioner_name.equals("") ){ %>
<tr> 
	<td class="label"><fmt:message key="eOR.DateandTime.label" bundle="${or_labels}"/></td>
	<td class="data"><b><%=com.ehis.util.DateUtils.convertDate(cancel_date_time,"DMYHM","en",localeName)%></b></td>
</tr>
<tr> 
	<td class="label"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></td>
	<td class="data"><b><%=practitioner_name%></b></td>
</tr>
<% } %>
<tr>
<td class="button" colspan='2' align='right'><INPUT TYPE="button"  class="button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")%>" onClick='window.close()'></td>
</tr>
</table>
</FORM>
			<style>
textarea {
  resize: none;
}
</style>
</BODY>
</HTML>

