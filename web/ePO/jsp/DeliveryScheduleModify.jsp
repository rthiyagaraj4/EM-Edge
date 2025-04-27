<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePO.*, ePO.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*" %>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="ePO.DeliveryScheduleDetails.label" bundle="${po_labels}"/></title>
<%
	    request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
		<script language="JavaScript" src="../../ePO/js/PurchaseOrder.js"></script>
		<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<script>
			function_id				=		 "<%= request.getParameter("function_id") %>"
		</script>
	
	</head>
<body>
<%
	String bean_id							=				request.getParameter("bean_id");
	String bean_name						=				request.getParameter("bean_name");
	String mode								=				request.getParameter("mode");
	String order_qty						=				request.getParameter("order_qty");
	String tot_qty							=				request.getParameter("order_qty");	
	String item_desc						=				request.getParameter("item_desc");
	String item_code						=				request.getParameter("item_code");
	String temp_uom							=				request.getParameter("temp_uom");
	String del_date							=				request.getParameter("del_date");
	String function_id						=				request.getParameter("function_id");
	PurchaseOrderBean bean					=				(PurchaseOrderBean) getBeanObject( bean_id,bean_name,request);
	bean.setLanguageId(locale);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	String sys_date							=				bean.getSystemDate();
	String req_no							=				bean.checkForNull(request.getParameter("req_no"));
	int max_rows = Integer.parseInt(eCommon.Common.CommonRepository.getCommonKeyValue("MULTIPLE_INSERT_PAGE_SIZE"));
	ArrayList hmExpRecords		= new ArrayList();

	if(bean.getExpRecords(item_code) != null && bean.getExpRecords(item_code).size()>0){
		hmExpRecords = (ArrayList)bean.getExpRecords(item_code);
		System.out.println("hmExpRecords = "+hmExpRecords);
		max_rows  = hmExpRecords.size();		
	}

	int y=0;
	
	ArrayList alDelvRecords		= new ArrayList();
	if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")))
		alDelvRecords = bean.getDeliveryData(bean.getDoc_no(),item_code);
	
%>
<form name="formDeliverySchedule" id="formDeliverySchedule">
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align=center scrolling=yes>
		<tr>
			<td class="label" colspan=2><fmt:message key="ePO.Item.label"	bundle="${po_labels}"/>&nbsp;
				<%=item_code%>  &nbsp;&nbsp;  <%=item_desc%>
			</td>
		</tr>
		<tr>
			<td class="label" colspan=2>Total Ordered Quantity : <%=order_qty%> &nbsp;&nbsp; <%=temp_uom%>
			</td>
		</tr>
		<tr><td>&nbsp;&nbsp;&nbsp;&nbsp;</td><tr>
		<tr>
			<th><fmt:message key="ePO.OrderQty.label" bundle="${po_labels}"/></th>
			<th><fmt:message key="ePO.DelDueDate.label" bundle="${po_labels}"/></th>
		</tr>
		<tr></tr>
		<%			
			int ct=0;
			for ( int cnt=0; cnt<max_rows; cnt++ ) {
				
				if(bean.getExpRecords(item_code) != null){
					HashMap hm = (HashMap)hmExpRecords.get(cnt);
					order_qty = bean.checkForNull((String)hm.get("DELV_QTY"));
					del_date  = bean.checkForNull((String)hm.get("DELV_DATE"));
				}
				
				
				if(alDelvRecords != null && alDelvRecords.size() > 0  ){
				if(ct < max_rows){
					for(int i=0;i<alDelvRecords.size();i++){
						HashMap hm = (HashMap)alDelvRecords.get(i);
						order_qty = bean.checkForNull((String)hm.get("DELV_QTY"));
						del_date  = bean.checkForNull((String)hm.get("DELV_DATE"));
									
					if(max_rows==10 && cnt!=0){
						order_qty="";
						del_date="";
					}
					
		%>				
		<tr>
			<td class="fields" align=center>
				<input type="text" name="order_qty_<%=ct%>" id="order_qty_<%=ct%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(order_qty)%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"> <%=temp_uom%>
			</td>
			<td class="fields" align=center>
				<input type="text" value="<%=bean.checkForNull(del_date)%>" name="del_due_dt_<%=ct%>"  maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('del_due_dt_<%=ct%>');"  ></img>
			</td>
		</tr>
				
		<%
			ct++;
					}
				}				
				} else {
					
					if(max_rows==10 && cnt!=0){
						order_qty="";
						del_date="";
					}
			
		%>				
		<tr>
			<td class="fields" align=center>
				<input type="text" name="order_qty_<%=cnt%>" id="order_qty_<%=cnt%>" class='NUMBER' size="10" maxlength="10"  value="<%=bean.checkForNull(order_qty)%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"> <%=temp_uom%>
			</td>
			<td class="fields" align=center>
				<input type="text" value="<%=bean.checkForNull(del_date)%>" name="del_due_dt_<%=cnt%>"  maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('del_due_dt_<%=cnt%>');"  ></img>
			</td>
		</tr>
				
		<%
								
				}
					
				y =  cnt;
				%>
			
		 <%		
			}
			
				y++;
				for ( int j=y ; j<10; j++ ) {

					if(j!=0){
					order_qty="";
					del_date="";
					}
					
					

		%>				
		<tr>
			<td class="fields" align=center>
				<input type="text" name="order_qty_<%=j%>" id="order_qty_<%=j%>" class='NUMBER' size="10" maxlength="10"  value="<%=order_qty%>" onKeyPress="return isValidInteger();" onBlur="checkIntegerFormat(this);"> <%=temp_uom%>
			</td>
			<td class="fields" align=center>
				<input type="text" value="<%=del_date%>" name="del_due_dt_<%=j%>"  maxLength="10" size="10"  onBlur="CheckDate(this);">&nbsp;
				<img src="../../eCommon/images/CommonCalendar.gif" onClick="return showCalendar('del_due_dt_<%=j%>');"  ></img>
			</td>
		</tr>
				
		<%
				}
		%>
		<tr>
			<td></td>
			<td class="fields" align=right>
				<input type="button" class="button" name="Ok" id="Ok" value="  Ok  "  onClick="exitDeliverySchedule();">
				
			</td>
					
		</tr>
	</table>
	<input type="hidden" 	name=sys_date				value="<%=sys_date%>">
	<input type="hidden" 	name="finalize_yn" id="finalize_yn"			value="No">
	<input type="hidden" 	name="mode" id="mode"					value="<%=mode%>">
	<input type="hidden" 	name="function_id" id="function_id"			value="<%=bean.getFunctionId()%>">
	<input type="hidden" 	name="bean_id" id="bean_id"				value="<%=bean_id%>">
	<input type="hidden" 	name="bean_name" id="bean_name"			value="<%=bean_name %>">
	<input type="hidden" 	name="totalRecords" id="totalRecords"        	value="10">
	<input type="hidden" 	name="item_code" id="item_code"			value="<%=item_code%>">
	<input type="hidden" 	name="req_no" id="req_no"				value="<%=req_no%>">
	<input type="hidden" 	name="tot_qty" id="tot_qty"				value="<%=tot_qty%>">
	<input type="hidden" 	name="order_qty" id="order_qty"			value="">
	<input type="hidden" 	name="del_due_dt" id="del_due_dt"			value="">


	
</form>
<%
	putObjectInBean(bean_id,bean,request);
		
%>
</body>
</html>

