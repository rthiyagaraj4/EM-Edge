<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,ePO.DeliveryOrderCancelBean" contentType="text/html;charset=UTF-8"%>
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
 	    <script language="JavaScript" src="../../ePO/js/DeliveryOrderCancel.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<form name="formDeliveryCancelOrderQueryResult" id="formDeliveryCancelOrderQueryResult">
	<%
		request.setCharacterEncoding("UTF-8");
		String bean_id					=		"DeliveryOrderCancelBean";
		String bean_name				=		"ePO.DeliveryOrderCancelBean";
		String mode						=		request.getParameter("mode");
		mode							=		mode.trim();
		String locale					=		(String)session.getAttribute("LOCALE");

		//if ((mode == null) || (mode.equals(""))) 
			//return;
		//if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			//return;

		DeliveryOrderCancelBean bean		=		(DeliveryOrderCancelBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		
		ArrayList Arrchkitem			=		new ArrayList();
		Arrchkitem						=		bean.getCheckItems();
		System.out.println("Arrchkitem = "+Arrchkitem);
	//	String po_order_mode		    =		request.getParameter("po_order_mode");
		String do_no					=		request.getParameter("do_no");
		String from_doc_date			=		request.getParameter("from_doc_date");
		String to_doc_date				=		request.getParameter("to_doc_date");
		String delivery_type			=		request.getParameter("delivery_type");
		String to_supplier			    =		request.getParameter("to_supplier");
		String request_type				=		request.getParameter("request_type");
		
		
		
		String checked					=		"checked";  
		int checked_ind;
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		try{
		
			String do_cancel_yn =	bean.checkForNull((String)bean.fetchRecord("select  DO_CANCEL_ALLOWED_YN  from  PO_USER_FOR_DELVORD where USER_ID=?",new String[]{(String) session.getValue( "login_user" )}).get("DO_CANCEL_ALLOWED_YN"),"N");
			
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
		//	po_order_mode			    =		CommonBean.checkForNull(po_order_mode,"%");
			do_no						=		CommonBean.checkForNull(do_no,"%");
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
            to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			delivery_type			    =		CommonBean.checkForNull(delivery_type,"%");
			to_supplier			        =		CommonBean.checkForNull(to_supplier,"%");
			request_type				=		CommonBean.checkForNull(request_type,"%");
			
			

			HashMap sqlMap				=		new HashMap();
			
			sqlMap.put("sqlData", ePO.Common.PoRepository.getPoKeyValue("SQL_DO_CANCEL_ORDER_QUERY_RESULT"));
			
			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();

			 displayFields.add("DO_NO");  
			 displayFields.add("DO_DATE");  
			 displayFields.add("SUPP_CODE");  
			 displayFields.add("SUPP_DESC");
			 displayFields.add("MASTER_CODE");   
			 displayFields.add("MASTER_CODE_DESC");  
			 displayFields.add("REQUEST_STATUS"); 
			 
			 
			ArrayList chkFields			=		new ArrayList();
			
			chkFields.add("DLVORD");
			chkFields.add(do_no);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(delivery_type);
			chkFields.add(to_supplier);
			chkFields.add(locale);
			
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			
			System.out.println("chkFields = "+chkFields);
			System.out.println("sqlMap = "+sqlMap);
			
			ArrayList result			=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.out.println("result in do qry result = "+result); 
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
					<th width='125'><fmt:message key="ePO.DONo.label" bundle="${po_labels}"/></th>
					<th width='125'><fmt:message key="ePO.DODate.label" bundle="${po_labels}"/></th>
					<th width='200'><fmt:message key="ePO.Supplier.label" bundle="${po_labels}"/> </th> 
					<th width='200'><fmt:message key="ePO.DOType.label" bundle="${po_labels}"/></th> 
					<th width='200'><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
						<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(formDeliveryCancelOrderQueryResult);">
					</th>
					<th width='200'><fmt:message key="Common.reason.label" bundle="${common_labels}"/></th>
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
			System.out.println("records in do cancel qry result = " + records);
			checked_ind			=		 Arrchkitem.indexOf(records.get(1)+"-"+records.get(0));
			checked				=		(checked_ind != -1 ? "checked":"");
			classvalue			=		(checked == ""?classvalue:"DATACHANGE");
		%>      
		       <td id="do_td_<%=i%>" class="<%=classvalue%>" onclick="displayPending(tr_<%=i%>);" onmouseover="changeCursor(this);" nowrap>
			      <font class='HYPERLINK'>
					<%=records.get(0)%>
					</font>
								
				</td>
							
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=com.ehis.util.DateUtils.convertDate((String)records.get(1),"DMY","en",locale)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(3)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(5)%>
				</td>
				
				
					<td class="<%=classvalue%>"  align='center' onclick="disableClick(event);"  title="<%=records.get(6)%>">

					<input type="checkbox" name="doc_<%=i%>" id="doc_<%=i%>" onClick="changeMyRowColor (<%=i%>,6,this); "  value="<%=records.get(1)%>-<%=records.get(0)%>" title="<%=records.get(6)%>"  <%=checked%>>											
				</td>	
					
				<td id="remarks_td_<%=i%>" class="<%=classvalue%>" onClick="showReason(tr_<%=i%>,<%=i%>);" onmouseover="changeCursor(this);" disabled>
					<font class='HYPERLINK'>
						<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
					</font>
					<span id="manditHidden_<%=i%>" style=visibility:hidden> <%=bean.getImage("M")%> </span>	
				</td>
				
				<td class='NODISPLAY'>
				
				</td>
				 
				<input type="hidden" name="checked_yn_<%=i%>" id="checked_yn_<%=i%>"		value="" %>
				<input type="hidden" name="details_<%=i%>" id="details_<%=i%>"			value="" %>	
				<input type="hidden" name="rem_<%=i%>" id="rem_<%=i%>"               value="">
			</tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="checkedIndices" id="checkedIndices"					value="" %>
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"				value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"							value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"						value="<%= bean_name%>">
		<input type="hidden" name="mode" id="mode"							value="<%= mode%>">
		<input type="hidden" name="do_cancel_yn" id="do_cancel_yn"					value="<%= do_cancel_yn%>">
		

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
		out.println(CommonBean.setForm (request ,"../../ePO/jsp/DeliveryOrderCancelQueryResult.jsp", searched));
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

