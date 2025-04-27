<!DOCTYPE html>
<%
/*
Sr No     Version        Incident			SCF/CRF					Developer Name
-----------------------------------------------------------------------------------
1          V220525							GHL-CRF-0632     		Mohanapriya
-----------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.*,eBL.* , eOR.* ,eOR.Common.*,eCommon.Common.*"  contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/indirectServCancel.js"></script>
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>

<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
	<%
	request.setCharacterEncoding("UTF-8");
	String mode	     = request.getParameter( "mode" ) ;	
	String login_user	= (String)session.getValue("login_user");
	String bean_id   = "@IndirectServBean" ;
	String bean_name = "eBL.IndirectServBean";
	String order_category = request.getParameter("order_category");
	String facility_id = (String)session.getValue("facility_id");
	IndirectServBean bean = (IndirectServBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	bean.setLanguageId(localeName);
	ArrayList Pending_Order_Status = new ArrayList();
	String from	 = bean.checkForNull(request.getParameter( "from" ),"0") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"13") ;	
 	int start	 = Integer.parseInt(from);
	int end		= Integer.parseInt(to);
	int j=0;
	String slClassValue = "";
	String checked1 = "";
	String checked2 = "";
	String chkStr = request.getParameter("str")==null?"":request.getParameter("str");
	String clickedTab = request.getParameter("clickedTab")==null?"":request.getParameter("clickedTab");
   if(chkStr.equals("") && clickedTab.equals("SEARCH")){
		bean.clear();
		Pending_Order_Status = bean.getNewOrderStatus(order_category,facility_id);
	}else{
 	    Pending_Order_Status = bean.getOrderSatList();
	}
	int maxRecord = (Pending_Order_Status.size() / 4);
	System.err.println("maxRecord-"+maxRecord);
	if(maxRecord <= end)
		end = maxRecord-1;
	
	int index=(start*4);
	int l=start;
	
	%>
	<form name="indirect_order_status" id="indirect_order_status">
	
		<table  width='90%' border=0 >
				<tr>
					<td class='NONURGENT' align="right">
						<input type='hidden' name='from' id='from' value='<%=start%>'>
						<input type='hidden' name='to' id='to' value='<%=end%>'>
<%
						if( start > 0 ) {
%>
							<a href='javascript:submitPrevNext(<%=(start-14)%>,<%=(start-1)%>)' text-decoration='none'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
							<input type='hidden' name='prevPage' id='prevPage' value='prev'>
<%
						}
						
						if(!((start+14) >= maxRecord )){
%>
							<a href='javascript:submitPrevNext(<%=(start+14)%>,<%=(start+27)%>)' text-decoration='none'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
							<input type='hidden' name='nextPage' id='nextPage' value='next'>
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
					<fmt:message key="eBL.RestrctOPserv.label" bundle="${bl_labels}"/>
				</td>
				<td class='columnheader' width='' nowrap>
					<fmt:message key="eBL.RestrctIPserv.label" bundle="${bl_labels}"/>
				</td>
				
			</tr>
			
<%
				while(l <= end){
					System.err.println(index);
					if( (l+1)%2 == 0)  
						slClassValue="gridData";
					else
						slClassValue="gridData";
%>
					<tr>
					<td class='gridData'>
						<%=Pending_Order_Status.get(index+1)%>
						<input type='hidden' name='long_desc<%=l%>' id='long_desc<%=l%>' value=<%=Pending_Order_Status.get(index+1)%>>	
						<input type='hidden' name='order_status_code<%=l%>' id='order_status_code<%=l%>' value=<%=Pending_Order_Status.get(index)%>>	
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
						<td class='<%=slClassValue%>' width='20%'><input type='checkbox' name='chk1_<%=l%>' id='chk1_<%=l%>' id='chk1_<%=l%>'  value=''  onclick='checkChk1Value(this, order_status_code<%=l%>,"chk1");' <%=checked1%>></td>
						<%
						index = index+1;
						if(((String)Pending_Order_Status.get(index)).equals("Y")||((String)Pending_Order_Status.get(index)).equals("D")){
							checked2="checked";
						}
						else{
							checked2="";
						}
%> 
							<td class='<%=slClassValue%>' width='20%'><input type='checkbox' name='chk2_<%=l%>' id='chk2_<%=l%>' id='chk2_<%=l%>'  value='' onclick='checkChk1Value(this, order_status_code<%=l%>,"chk2");' <%=checked2%>></td>					
 
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
		<input type="hidden" name="function_id" id="function_id" value="EBL_REST_CANC_SERVICE">
		<input type="hidden" name='total_recs' id='total_recs' value='<%=j%>'>
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

