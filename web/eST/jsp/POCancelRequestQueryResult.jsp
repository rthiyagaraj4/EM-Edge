<!DOCTYPE html>
 <%@page import="java.util.HashMap,java.util.ArrayList,eST.POCancelRequestBean" contentType="text/html;charset=UTF-8"%>
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
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/POCancelRequest.js'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<form name="formPOCancelRequestQueryResult" id="formPOCancelRequestQueryResult">
	<%
		request.setCharacterEncoding("UTF-8");
		String bean_id					=		"poCancelRequestBean";
		String bean_name				=		"eST.POCancelRequestBean";
		String mode						=		request.getParameter("mode");
		mode							=		mode.trim();
		String locale					=		(String)session.getAttribute("LOCALE");

		if ((mode == null) || (mode.equals(""))) 
			return;
		if (!(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY")) || mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))))
			return;

		POCancelRequestBean bean		=		(POCancelRequestBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		
		
		ArrayList Arrchkitem			=		new ArrayList();
		Arrchkitem						=		bean.getCheckItems();
		String doc_type_code			=		request.getParameter("doc_type_code");
		String doc_no					=		request.getParameter("doc_no");
		String from_doc_date			=		request.getParameter("from_doc_date");
		String to_doc_date				=		request.getParameter("to_doc_date");
		String request_by_store			=		request.getParameter("request_by_store");
		String request_on_store			=		request.getParameter("request_on_store");
		String item_class_code			=		request.getParameter("item_class_code");
		String request_type				=		request.getParameter("request_type");
		String request_status			=		request.getParameter("request_status");
		String checked					=		"checked"; // Added on Monday, July 26, 2004
		int checked_ind;
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code				=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no						=		CommonBean.checkForNull(doc_no,"%");
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
            to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			request_by_store			=		CommonBean.checkForNull(request_by_store,"%");
			request_on_store			=		CommonBean.checkForNull(request_on_store,"%");
			item_class_code				=		CommonBean.checkForNull(item_class_code,"%");
			request_type				=		CommonBean.checkForNull(request_type,"%");
			request_status				=		CommonBean.checkForNull(request_status.trim(),"%");

			HashMap sqlMap				=		new HashMap();
			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_CANCEL_REQUEST_HDR_QUERY_RESULT"));
			sqlMap.put("sqlData", "SELECT HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC, HDR.DOC_NO,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, HDR.REQ_STORE_CODE,RBYS.SHORT_DESC REQ_BY_STORE_DESC, HDR.PUR_DEPT_CODE,AM.SHORT_DESC REQ_ON_DEPT_DESC, HDR.ITEM_CLASS_CODE,ITM.SHORT_DESC ITEM_CLASS_DESC, 'P' REQUEST_STATUS FROM PO_REQUEST_HDR HDR,MM_STORE_LANG_VW RBYS,MM_ITEM_CLASS_LANG_VW ITM,SY_DOC_TYPE_MASTER_LANG_VW SY,ST_USER_ACCESS_FOR_STORE UACB,AM_DEPT_LANG_VW AM WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND HDR.REQ_STORE_CODE = RBYS.STORE_CODE AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+) AND HDR.CURR_STATUS = 'P' AND HDR.DOC_TYPE_CODE LIKE ? AND TO_CHAR (HDR.DOC_NO) LIKE ? AND (DOC_DATE BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, '31/12/3012'), 'DD/MM/YYYY')) AND HDR.REQ_STORE_CODE LIKE ? AND HDR.PUR_DEPT_CODE LIKE ? AND NVL (HDR.ITEM_CLASS_CODE, 'X') LIKE ? AND UACB.USER_ID = ? AND UACB.STORE_CODE = HDR.REQ_STORE_CODE AND UACB.PRQ_ALLOWED_YN = 'Y' AND RBYS.FACILITY_ID = ? AND SY.LANGUAGE_ID = ? AND ITM.LANGUAGE_ID(+) = ? AND AM.DEPT_CODE = HDR.PUR_DEPT_CODE AND SY.LANGUAGE_ID = AM.LANGUAGE_ID AND SY.LANGUAGE_ID = RBYS.LANGUAGE_ID");
			
			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();

			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("REQ_BY_STORE_DESC");
			displayFields.add("REQ_ON_DEPT_DESC");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("REQ_STORE_CODE");
			displayFields.add("PUR_DEPT_CODE");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("REQUEST_STATUS");

			ArrayList chkFields			=		new ArrayList();
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(request_by_store);
			chkFields.add(request_on_store);
			chkFields.add(item_class_code);
			chkFields.add(bean.getLoginById());
			chkFields.add((String)session.getValue("facility_id"));
			chkFields.add(locale);
			chkFields.add(locale);

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
					<th width='260'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
					<th width='260'>Req On Department</th>
					<th width='260'><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
					
					<th><fmt:message key="Common.cancel.label" bundle="${common_labels}"/>
						<input type="checkbox" value="Y" name="cancelAll" id="cancelAll"   onClick="return toggleCheck(formPOCancelRequestQueryResult);">
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
			checked_ind			=		 Arrchkitem.indexOf(records.get(6)+"-"+records.get(1));
			checked				=		(checked_ind != -1 ? "checked":"");
			classvalue			=		(checked == ""?classvalue:"DATACHANGE");
		%>
				<td class="<%=classvalue%>" onClick="displayPending(tr_<%=i%>);" onmouseover="changeCursor(this);" nowrap>
					<font class='HYPERLINK'>
						<%=(String)records.get(0)%>
					</font>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(1)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(3)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
					<%=records.get(4)%>
				</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);">
					<%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%>
				</td>
					<td class="<%=classvalue%>" onclick="disableClick(event);"  title="<%=records.get(10)%>">

					<input type="checkbox" name="doc_<%=i%>" id="doc_<%=i%>" onClick="changeMyRowColor (<%=i%>,8,this)"  value="<%=records.get(6)%>-<%=records.get(1)%>" title="<%=records.get(10)%>"  <%=checked%>>											
				</td>		
					
				<td id="remarks_td_<%=i%>" class="<%=classvalue%>" onClick="showReason(tr_<%=i%>,<%=i%>);" onmouseover="changeCursor(this);" disabled>
					<font class='HYPERLINK'>
						<fmt:message key="Common.remarks.label" bundle="${common_labels}"/>
					</font>
				</td>
				<td class='NODISPLAY'>
					<%=records.get(6)%>
					
				</td>
				<input type="hidden" name="checked_yn_<%=i%>" id="checked_yn_<%=i%>"		value="" %>
				<input type="hidden" name="details_<%=i%>" id="details_<%=i%>"			value="" %>	
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/POCancelRequestQueryResult.jsp", searched));
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

