<!DOCTYPE html>
<%@ page import="java.util.HashMap,java.util.ArrayList,eST.PORequestStatusBean " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language='javascript' src='../../eST/js/PORequestStatus.js'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body>
	<form name="formPORequestStatusQueryResult" id="formPORequestStatusQueryResult">
	<%
		String bean_id					=		"PORequestStatusBean";
		String bean_name				=		"eST.PORequestStatusBean";

		PORequestStatusBean bean				=		(PORequestStatusBean) getBeanObject(bean_id,bean_name,request);  

		String doc_type_code			=		request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		String doc_no					=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		String from_doc_date			=		request.getParameter("from_doc_date")==null?"":request.getParameter( "from_doc_date" ) ;
		String to_doc_date				=		request.getParameter("to_doc_date")==null?"":request.getParameter( "to_doc_date" ) ;
		String request_by_store			=		request.getParameter("request_by_store")==null?"":request.getParameter( "request_by_store" ) ;
		String request_on_department			=		request.getParameter("request_on_department")==null?"":request.getParameter( "request_on_department" ) ;
		String item_class_code			=		request.getParameter("item_class_code")==null?"":request.getParameter( "item_class_code" ) ;
		String request_status			=		request.getParameter("request_status")==null?"":request.getParameter( "request_status" ) ;
		String item_code				=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));

			doc_type_code				=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no						=		CommonBean.checkForNull(doc_no,"%");
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
			request_by_store			=		CommonBean.checkForNull(request_by_store,"%");
			request_on_department		=		CommonBean.checkForNull(request_on_department,"%");
			item_class_code				=		CommonBean.checkForNull(item_class_code,"%");
			request_status				=		CommonBean.checkForNull(request_status,"").trim( )+"%";
			item_code					=		CommonBean.checkForNull(item_code,"").trim( )+"%";

			HashMap sqlMap				=		new HashMap();
			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_HDR_SELECT3"));
			//sqlMap.put("sqlData", "SELECT hdr.doc_type_code, sy.short_desc doc_type_desc, hdr.doc_no,TO_CHAR (hdr.doc_date, 'dd/mm/yyyy') doc_date, hdr.req_store_code,rbys.short_desc req_by_store_desc, hdr.pur_dept_code,am.short_desc req_on_dept_desc, hdr.item_class_code,itm.short_desc item_class_desc, DECODE (hdr.curr_status, 'U', 'Unfinalized', 'P', 'Pending (Upon finalization)', 'R', 'Request Rejected by PO Dept', 'L', 'Request Received Partially','C', 'Request Received Completely', 'X', 'Request Cancelled') request_status,hdr.modified_by_id, TO_CHAR (hdr.modified_date, 'dd/mm/yyyy') modified_date, so.appl_user_name added_by_name,sp.appl_user_name modified_by_name,hdr.added_by_id,hdr.curr_status_remarks FROM po_request_hdr hdr, mm_store_lang_vw rbys, mm_item_class_lang_vw itm,sy_doc_type_master_lang_vw sy,am_dept_lang_vw am,sm_appl_user_lang_vw so, sm_appl_user_lang_vw sp WHERE hdr.doc_type_code = sy.doc_type_code  AND hdr.req_store_code = rbys.store_code  AND hdr.item_class_code = itm.item_class_code(+) AND hdr.curr_status like (?) AND hdr.doc_type_code LIKE (?)  AND TO_CHAR (hdr.doc_no) LIKE (?)  AND (doc_date BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'dd/mm/yyyy') AND TO_DATE (NVL (?, '31/12/3012'), 'dd/mm/yyyy') ) AND (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) IN (SELECT facility_id, doc_type_code, doc_no  FROM po_request_dtl WHERE facility_id = hdr.facility_id AND doc_type_code = hdr.doc_type_code AND doc_no = hdr.doc_no AND item_code LIKE UPPER (?)) AND hdr.req_store_code LIKE (?) AND hdr.pur_dept_code LIKE (?) AND NVL (hdr.item_class_code, 'X') LIKE (?) AND rbys.store_code = hdr.req_store_code AND rbys.facility_id = ? AND sy.language_id = ? AND itm.language_id(+) = ? AND am.dept_code = hdr.pur_dept_code AND sy.language_id = am.language_id AND sy.language_id = rbys.language_id AND so.appl_user_id(+) = hdr.added_by_id AND sp.appl_user_id(+) = hdr.modified_by_id AND so.language_id(+) = ? AND sp.language_id(+) = ? ");

			HashMap funcMap				=		new HashMap();
			ArrayList displayFields		=		new ArrayList();
			ArrayList chkFields			=		new ArrayList();

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
			displayFields.add("ADDED_BY_ID");          
			displayFields.add("MODIFIED_BY_ID");       
			displayFields.add("MODIFIED_DATE");        
			displayFields.add("added_by_name");        
			displayFields.add("modified_by_name");
			displayFields.add("CURR_STATUS_REMARKS");
			

			
		
			chkFields.add(request_status);
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(item_code);
			chkFields.add(request_by_store);
			chkFields.add(request_on_department);
			chkFields.add(item_class_code);
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);


			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result		=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%=result.get(1)%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
				<tr>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.RequestbyStore.label" bundle="${st_labels}"/></th>
					<th>Request On Department</th>
					<th><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></th>
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
				records=(ArrayList) result.get(recCount);
				
		%>
					<td class="<%=classvalue%>" onClick="displayPending(tr_<%=i%>);" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" align="right"><%=records.get(1)%></td>
			        <td class="<%=classvalue%>" onclick="disableClick(event);" align="center"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>
					
				
				
				<%
				String stTitle	=" Remarks: "+CommonBean.checkForNull((String)records.get(16))	;
				%>
					
				<td class="<%=classvalue%>" onClick="displayAuditInfo(tr_<%=i%>);" onmouseover="changeCursor(this);" align="left" title="<%=stTitle%>"><font class='HYPERLINK'><%=records.get(10)%></font></td>
				
				<td class='NODISPLAY'><input type="hidden" name="doc_<%=i%>" id="doc_<%=i%>" value="<%=records.get(6)%>-<%=records.get(1)%>"></td>
				<td class='NODISPLAY'><%=records.get(6)%></td>
				<td class='NODISPLAY'><%=records.get(11)%></td>
				<td class='NODISPLAY'><%=records.get(12)%></td>
				<td class='NODISPLAY'><%=records.get(13)%></td>
				<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(14))%></td>
				<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(15))%></td>
					
				
							
				
			</tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="checkedIndices" id="checkedIndices"			value="" %>
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"		value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name%>">
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/PORequestStatusQueryResult.jsp", searched));
	
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

