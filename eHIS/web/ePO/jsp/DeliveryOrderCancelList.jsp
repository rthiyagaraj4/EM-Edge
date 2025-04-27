<!DOCTYPE html>
 <%@ page import="ePO.DeliveryOrderCancelBean, ePO.DeliveryOrderCancelDetailBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->	
<%
		String sStyle	=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
 	    <script language="JavaScript" src="../../ePO/js/DeliveryOrderCancel.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="ePO.DOItemDetails.label" bundle="${po_labels}"/></title>
	</head>
	<%
		String bean_id				=			"DeliveryOrderCancelBean";
		String bean_name			=			"ePO.DeliveryOrderCancelBean";
		String mode					=			request.getParameter("mode");
		String function_id			=			request.getParameter("function_id");
		String className			=			"";
		DeliveryOrderCancelBean bean	=			(DeliveryOrderCancelBean) getBeanObject(bean_id,bean_name,request);  
		String do_no				=			request.getParameter("do_no");
		int tot_size = 0;

		request.setCharacterEncoding("UTF-8");
		String locale				=		(String)session.getAttribute("LOCALE");
		String facilityid=(String)session.getValue("facility_id");
	
		bean.loadData( do_no,facilityid);
		
		bean.setLanguageId(locale);
		java.util.ArrayList alItems =		bean.getAlItems();
		int i=0;
		ArrayList Arrchkitem			=		new ArrayList();
		Arrchkitem						=		bean.getCheckItems();
		String checked					=		"checked";  
		int checked_ind;
		String classvalue				=		"";

	int no_of_decimals						=			bean.getNoOfDecimals();
	int no_of_decimals_temp					=			bean.getNoOfDecimals();
	%>
	<body >
		<form name='formDeliveryCancelOrderList' id='formDeliveryCancelOrderList'>
			<br>
			

			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' align=center>
 			<tr>
				<th width="300" style="WORD-BREAK:BREAK-ALL;"><fmt:message key="ePO.Item.label"	bundle="${po_labels}"/></th>
				<th width='200'><fmt:message key="ePO.DoQty.label" bundle="${po_labels}"/></th>
				<th width='200'><fmt:message key="ePO.DoUOM.label" bundle="${po_labels}"/></th>
				<th width='200'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
					<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(formDeliveryCancelOrderList);">
				</th>
				<th width='200'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
			</tr>
			<%
				if (alItems != null && (alItems.size()>0)) {
					int totalSize = alItems.size();
					tot_size = alItems.size();
					DeliveryOrderCancelDetailBean detailBean;
					for (i=0;	i<totalSize;	i++){
						detailBean = (DeliveryOrderCancelDetailBean) alItems.get(i);
						System.out.println("detailBean===list====>" +detailBean);
						if (detailBean != null) {
						className	=	((i%2)==0)?"QRYODD":"QRYEVEN";
					if(bean.getAllowDecimalsYN((String)detailBean.getItem_code()).equals("N")){
						no_of_decimals = 0;
					}else{
						no_of_decimals					=			no_of_decimals_temp;
					}
					
					String uom_code = bean.checkForNull(detailBean.getDo_Uom());
					String uom_desc = "";
					HashMap hmRecord = bean.getUomDesc(uom_code);
					if(hmRecord.size()>0){
						uom_desc = (String)hmRecord.get("SHORT_DESC");
					}
				%>
				<tr id="tr_<%=i%>">
				
					<%
		//	records				=		(ArrayList) result.get(recCount);
		//	System.out.println("records in do cancel qry result = " + records);
			checked_ind			=		 Arrchkitem.indexOf(do_no+"-"+detailBean.getItem_code());
			checked				=		(checked_ind != -1 ? "checked":"");
			classvalue			=		(checked == ""?classvalue:"DATACHANGE");
		%> 
					<input type="hidden" name="do_no_<%=i%>" id="do_no_<%=i%>"			value="<%=do_no%>" %>	
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>"		value="<%=detailBean.getItem_code()%>" %>
					<input type="hidden" name="do_srl_no_<%=i%>" id="do_srl_no_<%=i%>"		value="<%=detailBean.getSrl_no()%>" %>
					<td class="<%=classvalue%>" style="WORD-BREAK:BREAK-ALL;" onclick="disableClick(event);"><%=detailBean.getItem_desc()%> </td>
					<td class="<%=classvalue%>" nowrap style="TEXT-ALIGN:right" onclick="disableClick(event);"> <%=bean.setNumber(bean.checkForNull(detailBean.getDo_qty(),"0"),no_of_decimals)%>&nbsp;</td>
					<td class="<%=classvalue%>" nowrap style="TEXT-ALIGN:left"> <%=uom_desc%>&nbsp;</td>
					<td class="<%=classvalue%>" align='center'>
					<input type="checkbox"  name="doc_<%=i%>" id="doc_<%=i%>" onClick="changeMyRowColor1 (<%=i%>,5,this)"  value="" title=""  >	
					</td>
					<td class="<%=classvalue%>"  id="remarks_td_<%=i%>" class="" onClick="showReason1(tr_<%=i%>,<%=i%>);" onmouseover="changeCursor(this);" disabled>
					<font class='HYPERLINK'>
						<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
					</font>
					<span id="manditHidden_<%=i%>" style=visibility:hidden> <%=bean.getImage("M")%> </span>	
				</td>
		           				<input type="hidden" name="rem_<%=i%>" id="rem_<%=i%>"               value="">
								<input type="hidden" name="do_td_<%=i%>" id="do_td_<%=i%>"               value="">
				</tr>
				<%
					}
				}
				%>
				<input type="hidden" name="total_records" id="total_records" value="<%=totalSize%>">
				<%
			}
			%>
			
			<tr>
					<td colspan=4 class="label" >&nbsp;</td>
				<%	if(tot_size > 0){ 	%>
					<td class='fields'>&nbsp;<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>'  onClick="saveVals();">
				<% } else { %>	
					<td class='fields'>&nbsp;<input type="button" class="button" name="save" id="save" value='<fmt:message key="Common.Save.label" bundle="${common_labels}"/>'  onClick="saveVals();" disabled>
				<% } %>	
					
					</td>
				</tr>
			</table>
			<input type="hidden" name="mode" id="mode"			value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"			value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"		value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"		value="<%=function_id%>">
		</form>
<%
	putObjectInBean(bean_id,bean,request);
%>
	</body>
</html>

