<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
/*
---------------------------------------------------------------------------------------------------------------------------------	
Date		Edit History	Name		Rev.Date   	 Rev.By 	Description
--------------------------------------------------------------------------------------------------------------------------------
25/09/2018	  IN068719		sivabagyam	 25/09/2018	Ramesh G   GHL-CRF-0517.1
--------------------------------------------------------------------------------------------------------------------------------
*/
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/PendingOrderStatusForDischarge.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	
</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String mode	     = request.getParameter( "mode" ) ;	
	String login_user	= (String)session.getValue("login_user");
	String bean_id   = "@PendingOrderStatusBean" ;
	String bean_name = "eOR.PendingOrderStatusBean";
	String order_category = request.getParameter("order_category");
	String facility_id = (String)session.getValue("facility_id");
	PendingOrderStatusBean bean = (PendingOrderStatusBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	ArrayList Pending_Order_Status = new ArrayList();
	String from	 = bean.checkForNull(request.getParameter( "from" ),"0") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"13") ;	
 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);
	int j=0;
	//int ilRow=0;//commented for checkstyle IN068719
	//String total_query_records		= "0";//commented for checkstyle IN068719
	String slClassValue = "";
	String checked1 = "";
	String checked2 = "";
	String checked3 = "";//IN068719
	//String chkValue = "";//commented for checkstyle IN068719
	String chkStr = request.getParameter("str")==null?"":request.getParameter("str");
	String clickedTab = request.getParameter("clickedTab")==null?"":request.getParameter("clickedTab");
   if(chkStr.equals("") && clickedTab.equals("SEARCH")){
		bean.clear();
		Pending_Order_Status = bean.getNewOrderStatus(order_category);
	}else{
 	    Pending_Order_Status = bean.getOrderSatList();
	}
	//String[] record=null;//commented for checkstyle IN068719
	//String result_disabled="";
	int maxRecord = (Pending_Order_Status.size() / 5);
	if(maxRecord <= end)
		end = maxRecord-1;
	int index=(start*5);
	int l=start;
	%>
	<form name="pend_order_status" id="pend_order_status">
	
		<table  width='90%' border=0 >
				<tr>
					<td class='NONURGENT' align="right">
						<input type=hidden name='from' id='from' value='<%=start%>'>
						<input type=hidden name='to' id='to' value='<%=end%>'>
<%
						if( start > 0 ) {
%>
							<a href='javascript:submitPrevNext(<%=(start-14)%>,<%=(start-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type=hidden name='prevPage' id='prevPage' value='prev'>
<%
						}
						if(!((start+14) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(start+14)%>,<%=(start+27)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type=hidden name='nextPage' id='nextPage' value='next'>
<%
						}
%>
					</td>
				</tr>
			</table>
		<table  class='grid' width="100%">
			<tr>
				<td class="COLUMNHEADER" width='' style="text-align:left;">
					<fmt:message key="Common.OrderStatus.label" bundle="${common_labels}"/>
				</td>
				<td class='columnheader' width='' nowrap>
					<fmt:message key="eIP.PrepareDischargeAdvice.label" bundle="${ip_labels}"/>
				</td>
				<td class='columnheader' width='' nowrap>
					<fmt:message key="Common.Discharge.label" bundle="${common_labels}"/>
				</td>
				<!-- IN068719 starts-->
				 <td class='columnheader' width='' nowrap>
					<fmt:message key="Common.AE.label" bundle="${common_labels}"/>&nbsp;<fmt:message key="Common.CheckOut.label" bundle="${common_labels}"/>
				</td>

				<!-- IN068719ends -->
			</tr>
			
<%
				while(l <= end){
					if( (l+1)%2 == 0)  
						slClassValue="gridData";
					else
						slClassValue="gridData";
%>
					<tr>
					<td class='gridData'>
						<%=Pending_Order_Status.get(index+1)%>
						<input type=hidden name=long_desc<%=l%> value=<%=Pending_Order_Status.get(index+1)%>>	
						<input type=hidden name=order_status_code<%=l%> value=<%=Pending_Order_Status.get(index)%>>	
					</td>
<%
                        index = index+2;
						if(((String)Pending_Order_Status.get(index)).equals("Y")||((String)Pending_Order_Status.get(index)).equals("A")){
							checked1="checked";
						}
						else{
							checked1="";
						}
%>                       
						<td class='<%=slClassValue%>' width='20%'><input type='checkbox' name='chk1_<%=l%>' id='chk1_<%=l%>' id='chk1_<%=l%>'  value='A'  onclick='checkChk1Value(this, order_status_code<%=l%>);' <%=checked1%>></td>
						<%
						index = index+1;
						if(((String)Pending_Order_Status.get(index)).equals("Y")||((String)Pending_Order_Status.get(index)).equals("D")){
							checked2="checked";
						}
						else{
							checked2="";
						}
%> 
							<td class='<%=slClassValue%>' width='20%'><input type='checkbox' name='chk2_<%=l%>' id='chk2_<%=l%>' id='chk2_<%=l%>'  value='D' onclick='checkChk2Value(this, order_status_code<%=l%>);' <%=checked2%>></td>
	<!-- IN068719 starts -->						
 <%
					index = index+1;
						if(((String)Pending_Order_Status.get(index)).equals("Y")||((String)Pending_Order_Status.get(index)).equals("C")){
							checked3="checked";
						}
						else{
							checked3="";
						}
%> 
							 <td class='<%=slClassValue%>' width='20%'><input type='checkbox' name='chk3_<%=l%>' id='chk3_<%=l%>' id='chk3_<%=l%>'  value='C' onclick='checkChk3Value(this, order_status_code<%=l%>);' <%=checked3%>></td>
		<!-- IN068719 ends -->
					</tr>
<%
					index+=1;
					l++;
				}
%>
		</table>	
		<input type="hidden" id='recordsSize' name="totalRecords" id="totalRecords" value="<%=Pending_Order_Status.size()%>">
		<input type="hidden" name="mode" id="mode" value="<%=mode%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
		<input type="hidden" name="function_id" id="function_id" value="Pend_Order_Status">
		<input type=hidden name='total_recs' id='total_recs' value='<%=j%>'>
		<input type='hidden' name='order_category' id='order_category' value='<%=order_category%>'>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='login_user' id='login_user' value='<%=login_user%>'>
		<%
		Pending_Order_Status=null;
		%>
	</form>
</body>
</html>
<%
putObjectInBean(bean_id,bean,request);
%>

