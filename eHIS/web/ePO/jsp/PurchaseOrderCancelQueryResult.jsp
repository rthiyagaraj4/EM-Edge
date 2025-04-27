<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,ePO.PurchaseOrderCancelBean" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>  
<%
		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePO/js/PoCommon.js"></script>
 	    <script language="JavaScript" src="../../ePO/js/PurchaseOrderCancel.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<form name="formSTPOCancelOrderQueryResult" id="formSTPOCancelOrderQueryResult">
	<%
		request.setCharacterEncoding("UTF-8");
		String bean_id					=		"PurchaseOrderCancelBean";
		String bean_name				=		"ePO.PurchaseOrderCancelBean";
		String mode						=		request.getParameter("mode");
		mode							=		mode.trim();
		String locale					=		(String)session.getAttribute("LOCALE");

		//if ((mode == null) || (mode.equals(""))) 
			//return;
		//if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			//return;

		PurchaseOrderCancelBean bean		=		(PurchaseOrderCancelBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		
		ArrayList Arrchkitem			=		new ArrayList();
		Arrchkitem						=		bean.getCheckItems();
		System.out.println("Arrchkitem = "+Arrchkitem);
		String po_order_mode		    =		request.getParameter("po_order_mode");
		String po_no					=		request.getParameter("po_no");
		String from_doc_date			=		request.getParameter("from_doc_date");
		String to_doc_date				=		request.getParameter("to_doc_date");
		String purchase_type			=		request.getParameter("purchase_type");
		String to_supplier			    =		request.getParameter("to_supplier");
		String request_type				=		request.getParameter("request_type");
		String pur_unit_code			=		request.getParameter("pur_unit_code");
		String poCancel					=		CommonBean.checkForNull(request.getParameter("poCancel"),"N");
		String poClose					=		CommonBean.checkForNull(request.getParameter("poClose"),"N");
		String poStatus					=		request.getParameter("po_order_status");
		
		String checked					=		"checked";  
		int checked_ind;
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		String rmksDisabled					=		"";  
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			po_order_mode			    =		CommonBean.checkForNull(po_order_mode,"%");
			po_no						=		CommonBean.checkForNull(po_no,"%");
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
            to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			purchase_type			    =		CommonBean.checkForNull(purchase_type,"%");
			to_supplier			        =		CommonBean.checkForNull(to_supplier,"%");
			request_type				=		CommonBean.checkForNull(request_type,"%");
			pur_unit_code				=		CommonBean.checkForNull(pur_unit_code,"%");
			poStatus					=		CommonBean.checkForNull(poStatus,"%");
			

			HashMap sqlMap				=		new HashMap();
			
		    //Commented by Rabbani on 05/07/12
			//sqlMap.put("sqlData", "SELECT   hdr.po_no,DECODE (po_order_mode, 'D', 'Direct Order ', 'R', 'Order Based on Request', po_order_mode ) po_mode, TO_CHAR (hdr.po_date, 'DD/MM/YYYY') po_date, hdr.pur_unit_code, spu.long_desc pur_unit,  hdr.supp_code, apsup.short_name supp_desc,hdr.PO_MASTER_TYPE master_type, pmc.long_desc master_type_desc, 'FA' REQUEST_STATUS,hdr.po_order_mode FROM po_order_hdr hdr,po_master_code_lang_vw pmc,po_purchase_unit_lang_vw spu, ap_supplier_lang_vw apsup  WHERE  HDR.PUR_UNIT_CODE = SPU.PUR_UNIT_CODE and  hdr.supp_code = apsup.supp_code  and hdr.PO_MASTER_TYPE = pmc.MASTER_TYPE and  hdr.po_master_code = pmc.master_code and  hdr.po_status IN ('FA','RA','PA')  AND po_order_mode LIKE ? AND TO_CHAR (hdr.po_no) LIKE ?  AND (po_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY')  AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY'))  AND HDR.PO_MASTER_CODE LIKE NVL (?, '%') AND hdr.pur_unit_code LIKE ?  AND hdr.supp_code LIKE NVL (?, '%')  AND spu.language_id = apsup.language_id  and pmc.language_id = spu.language_id    AND spu.language_id = ? ORDER BY hdr.PO_ORDER_MODE, hdr.po_no, hdr.po_date");
		
		if(poCancel.equals("Y")){
				//Added by Rabbani on 05/07/12
				sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_CANCEL_ORDER_QUERY_RESULT"));
			}else if(poClose.equals("Y"))	{
				sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_PO_CLOSE_ORDER_QUERY_RESULT"));
				
			}
			
			
			 
			
			
			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();

			 displayFields.add("PO_MODE"); 
			 displayFields.add("PO_NO");  
			 displayFields.add("PO_DATE");  
			 displayFields.add("PUR_UNIT"); 
             displayFields.add("PUR_UNIT_CODE"); 			
			 displayFields.add("SUPP_CODE");  
			 displayFields.add("SUPP_DESC");
			 displayFields.add("MASTER_TYPE");   
			 displayFields.add("MASTER_TYPE_DESC");  
			 displayFields.add("REQUEST_STATUS"); 
			 displayFields.add("PO_ORDER_MODE"); 
			 
			ArrayList chkFields			=		new ArrayList();
			
			
			chkFields.add(poStatus);
			chkFields.add(po_order_mode);
			chkFields.add(po_no);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(purchase_type);
			chkFields.add(pur_unit_code);
			chkFields.add(to_supplier);
			chkFields.add(bean.getLoginById());
			chkFields.add(locale);
			chkFields.add(CommonBean.getLoginFacilityId());
			
			
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			
			ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			 
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%=result.get(1)%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%"  id='tb1' align=center>
		   		<tr>
					<th width='260'><fmt:message key="ePO.PurchaseMode.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.PurchaseNo.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.OrderDate.label" bundle="${po_labels}"/></th>
					<th width='260'><fmt:message key="ePO.PurchaseUnit.label" bundle="${po_labels}"/> </th>
					 <th width='200'><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/> </th> 
					  <th width='200'><fmt:message key="ePO.PurchaseType.label" bundle="${po_labels}"/></th> 
					<th>
					<%if(poCancel.equals("Y")){%>
						<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
					<%} else {%>
						<fmt:message key="Common.close.label" bundle="${common_labels}"/>
					<%}%>
						<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(formSTPOCancelOrderQueryResult);">
					</th>
					<th ><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			ArrayList records=new ArrayList();
			for(recCount=2,i = 0; recCount<result.size(); recCount++,i++) {
				if (recCount % 2 == 0)
					classvalue = "OAQRYEVEN" ;
				else
					classvalue = "OAQRYODD" ;
		%>
				<tr id="tr_<%=i%>">
		
		<%
			records				=		(ArrayList) result.get(recCount);
			checked_ind			=		 Arrchkitem.indexOf(records.get(10)+"-"+records.get(1));
			checked				=		(checked_ind != -1 ? "checked":"");
			classvalue			=		(checked == ""?classvalue:"DATACHANGE");
			if(checked_ind != -1)
				rmksDisabled = "";
			else	
				rmksDisabled = "disabled";
		%>      
		       <td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(0)%>
				</td>
				<td class="<%=classvalue%>" onClick="displayPending(tr_<%=i%>);" onmouseover="changeCursor(this);" nowrap>
					<font class='HYPERLINK'>
						<%=(String)records.get(1)%>
					</font>
				</td>
				
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(3)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(6)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(8)%>
				</td>
				
					<td class="<%=classvalue%>" onclick="disableClick(event);"  title="<%=records.get(9)%>">

					<input type="checkbox" name="doc_<%=i%>" id="doc_<%=i%>" onClick="changeMyRowColor ('<%=i%>',8,this,'<%=(String)records.get(1)%>')"  value="<%=records.get(10)%>-<%=records.get(1)%>" title="<%=records.get(9)%>"  <%=checked%>>											
				</td>	
					
				<td id="remarks_td_<%=i%>" class="<%=classvalue%>" onClick="showReason(tr_<%=i%>,<%=i%>);" onmouseover="changeCursor(this);" <%=rmksDisabled%>>
					<font class='HYPERLINK'>
						<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
					</font>
					<% if(checked.equals("checked")){ %>
						<span id="manditHidden_<%=i%>" style=visibility:visible> <%=bean.getImage("M")%> </span>	
					<% }else{ %>
						<span id="manditHidden_<%=i%>" style=visibility:hidden> <%=bean.getImage("M")%> </span>	
					<%}%>	
					
				</td>
				
				<td class='NODISPLAY'>
				<%=records.get(10)%>
				</td>
				 
				<input type="hidden" name="checked_yn_<%=i%>" id="checked_yn_<%=i%>"		value="">
				<input type="hidden" name="details_<%=i%>" id="details_<%=i%>"			value="">	
				<input type="hidden" name="rem_<%=i%>" id="rem_<%=i%>"              value="">
			</tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="checkedIndices" id="checkedIndices"					value="" >
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"				value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"						value="<%= bean_name%>">
		<input type="hidden" name="mode" id="mode"							value="<%= mode%>">
		<input type="hidden" name="poCancel" id="poCancel"						value="<%=poCancel%>">
		<input type="hidden" name="poClose" id="poClose"							value="<%=poClose%>">		
	</form>
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/PurchaseOrderCancelQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
<%
	putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

