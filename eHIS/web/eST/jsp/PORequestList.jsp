<!DOCTYPE html>
<%@ page import="eST.PORequestBean, eST.PORequestDetailBean,java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=   (String)session.getAttribute("LOCALE");
		String sStyle			=  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/PORequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
	<%
		String bean_id					=		"porequestBean";
		String bean_name				=		"eST.PORequestBean";
		String checked					=		"";
		String disabled					=		"";
		String className				=		"";

		java.util.ArrayList alItemKeys  =		new java.util.ArrayList();
		java.util.HashMap hmItemStore   =		null;
		String mode						=		request.getParameter("mode");
		String function_id				=		request.getParameter("function_id");
		//String kit12					=		(String)request.getParameter("kit12")==null?"":(String)request.getParameter("kit12");
		String itemStoreKey				=		"";

		PORequestBean bean				=		(PORequestBean) getBeanObject(bean_id,bean_name, request  );  
		bean.setLanguageId(locale);
		for(int i=0;i<bean.getItemKeys().size();i++) {
			alItemKeys.add(bean.getItemKeys().get(i));	
		} 
		java.util.ArrayList newKeys = bean.getItemKeysAdded();

		if (newKeys != null && newKeys.size() >0) {
			alItemKeys.addAll(newKeys);
		}

		hmItemStore						=		bean.getHmItemDetail();
		int i							=		0;
	
						
	%>
	<body >
		<form name='formPORequestList' id='formPORequestList'>
			<table name ="tblItemList" border='1' width='100%' cellpadding='0' cellspacing='0' >
 			<tr>
				<th width='2%'><fmt:message key="eST.S.label" bundle="${st_labels}"/></th>
				<th width='3%'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></th>
				<th style="WORD-BREAK:BREAK-ALL;"><fmt:message key="Common.ItemDescription.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="Common.StockUOM.label" bundle="${common_labels}"/></th>
				<th nowrap><fmt:message key="eST.QuantityOnHand.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
				<th nowrap><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
			</tr>
			<%
				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize			=		alItemKeys.size();
					for (i=0;	i<totalSize;	i++){
						itemStoreKey		=		(String) alItemKeys.get(i);
						
						PORequestDetailBean detailBean = (PORequestDetailBean) hmItemStore.get(itemStoreKey);
						if (detailBean != null){

                          if( (detailBean.getCheck_box_status()).equals("Y") )
							  checked		=		"checked" ;
						  else
						      checked		=		"" ;

                         
							  className		=		((i%2)==0)?"OAQRYODD":"OAQRYEVEN";
						//int qty_diff		=		0;

					/*if (!detailBean.getMax_stk_qty().equals(""))
						{
						 qty_diff			=		(Integer.parseInt(detailBean.getQty_on_hand() )+Integer.parseInt(detailBean.getRequired_qty())) - (Integer.parseInt(detailBean.getMax_stk_qty() )) ;
									
						}*/
					if((detailBean.getCheck_box_status()).equals("")){
						String avail_stock	=	bean.checkForNull((String)detailBean.getAvailable_stock(),"0");
						String required_qty =	bean.checkForNull((String)detailBean.getRequired_qty(),"0");
					
				%>
				<tr id="tr_<%=i%>">
					<td class="<%=(Integer.parseInt(avail_stock)-Integer.parseInt(required_qty)<0)?"":className%>"  title="<%=(Integer.parseInt(avail_stock)-Integer.parseInt(required_qty)<0)?"Insufficient Stock":""%>">&nbsp;</td>
					<td class="<%=className%>" nowrap align='center'><input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=itemStoreKey%>" disabled <%=checked%> onClick="updateCheckStatus(this);"></td>
					<td id="a_<%=i%>" class="<%=className%>" nowrap  align='left'> <%=detailBean.getItem_code()%></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='left'><%=detailBean.getItem_desc()%></td>
					<td class="<%=className%>" nowrap align='left'><%=bean.checkForNull(detailBean.getUomDesc(),"&nbsp;")%></td>
					<td class="<%=className%>" nowrap align='right'><%=detailBean.getQty_on_hand().equals(" ")?"&nbsp;": detailBean.getQty_on_hand()%></td>
					<td class="<%=className%>" nowrap align='right' ><%=bean.checkForNull(detailBean.getRequired_qty(),"&nbsp;")%>&nbsp; </td>
					<td class="<%=className%>" nowrap align='right'><%=bean.getGenItemUOMDesc(detailBean.getItem_code()).equals(" ")?"&nbsp;": bean.getGenItemUOMDesc(detailBean.getItem_code())%></td>
				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
				<%
					}else{
				%>
				<tr id="tr_<%=i%>">
					<td class="<%=(Double.parseDouble(bean.checkForNull((String)detailBean.getAvailable_stock(),"0"))-Double.parseDouble((String)detailBean.getRequired_qty())<0)?"":className%>"  title="<%=(Double.parseDouble(bean.checkForNull((String)detailBean.getAvailable_stock(),"0"))-Double.parseDouble((String)detailBean.getRequired_qty())<0)?"Insufficient Stock":""%>">&nbsp;</td>
					<td class="<%=className%>" nowrap align='center'><input type='checkbox' name="add_itm_<%=i%>" id="add_itm_<%=i%>" value="<%=itemStoreKey%>" <%=disabled%> <%=checked%> onClick="updateCheckStatus(this);"></td>
					<td id="a_<%=i%>" class="<%=className%>" nowrap align='left' onClick="displayItemDetail(<%=i%>);" onMouseOver="changeCursor(this);"><font class="HYPERLINK"><%=detailBean.getItem_code()%></font></td>
					<td class="<%=className%>" style="WORD-BREAK:BREAK-ALL;" align='left'><%=detailBean.getItem_desc()%></td>
					<td class="<%=className%>" nowrap align='left'><%=bean.checkForNull(detailBean.getUomDesc(),"&nbsp;")%></td>
					<td class="<%=className%>" nowrap align='right'><%=detailBean.getQty_on_hand().equals(" ")?"&nbsp;": detailBean.getQty_on_hand()%></td>
					<td class="<%=className%>" nowrap align='right' ><%=bean.checkForNull(detailBean.getRequired_qty(),"&nbsp;")%>&nbsp; </td>
					<td class="<%=className%>" nowrap align='right'><%=bean.getGenItemUOMDesc(detailBean.getItem_code()).equals(" ")?"&nbsp;": bean.getGenItemUOMDesc(detailBean.getItem_code())%></td>
				</tr>
					<input type="hidden" name="item_code_<%=i%>" id="item_code_<%=i%>" value="<%=detailBean.getItem_code()%>">
				<%
					}}
				}
			}
				
			%>
			</table>
			<input type="hidden" name="total_checkboxes" id="total_checkboxes"			value="<%=i%>">
			<input type="hidden" name="records_for_submission" id="records_for_submission"		value="">
			<input type="hidden" name="mode" id="mode"						value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id"						value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"					value="<%=bean_name %>">
			<input type="hidden" name="function_id" id="function_id"					value="<%=function_id%>">
			<input type="hidden" name="doc_type_code" id="doc_type_code"				value="">
			<input type="hidden" name="doc_no" id="doc_no"						value="">
			<input type="hidden" name="doc_date" id="doc_date"					value="">
			<input type="hidden" name="doc_ref" id="doc_ref"						value="">
			<input type="hidden" name="request_by_store" id="request_by_store"			value="">
			<input type="hidden" name="request_on_store" id="request_on_store"			value="">
			<input type="hidden" name="item_class_code" id="item_class_code"				value="">
			<input type="hidden" name="finalize_yn" id="finalize_yn"					value="">
			<input type="hidden" name="autono_yn" id="autono_yn"					value="">
			<input type="hidden" name="request_type" id="request_type"				value="">
		</form>
		<%
putObjectInBean(bean_id,bean,request);
%>
	</body>

</html>



