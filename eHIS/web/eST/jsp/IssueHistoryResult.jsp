<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/15/2021              IN0071699          ChandraShekar Raju                                  				 MO-CRF-20166
--------------------------------------------------------------------------------------------------------------------------------------------
*/  
%>
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.* " contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	    
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
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
		<script language='javascript' src='../../eST/js/Request.js'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


 <title>
</title>
	</head>
	<body style='overflow-x:hidden;overflow-y:scroll'>
	<form name="formIssueHistoryResult" id="formIssueHistoryResult">
	<%
		String request_by_store			=		request.getParameter("request_by_store")==null?"":request.getParameter( "request_by_store" ) ;
		String request_on_store			=		request.getParameter("request_on_store")==null?"":request.getParameter( "request_on_store" ) ; 
		String item_code				=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		String called_from              =       request.getParameter("called_from")==null?"":request.getParameter( "called_from" ) ;
        String bean_id					=		"RequestStatusBean";
		String bean_name				=		"eST.RequestStatusBean";

		RequestStatusBean bean		    =		(RequestStatusBean) getBeanObject(bean_id,bean_name,request); 
		bean.setLanguageId(locale);
		String store_desc               =       "";
		boolean searched				=	(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		HashMap sqlMap					=		new HashMap();
		String	sql						=		"";
		HashMap funcMap					=		new HashMap();
		ArrayList displayFields			=		new ArrayList();
		ArrayList chkFields				=		new ArrayList();

		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
            
			
			
				sql = "SELECT hdr.doc_type_code,(SELECT sy.short_desc FROM sy_doc_type_master_lang_vw sy WHERE sy.doc_type_code = hdr.doc_type_code AND sy.language_id = rons.language_id) doc_type_desc, TO_char (hdr.doc_date, 'dd/mm/yyyy') doc_date, dtl.doc_no, dtl.doc_srl_no, hdr.to_store_code, rons.short_desc ISSUE_STORE_DESC, dtl.item_code, itm.short_desc item_desc, nvl(req_item_qty,0)req_qty, dtl.issue_uom_qty, NVL (dtl.iss_item_qty, 0) iss_item_qty,nvl(pending_item_qty,0) pending_item_qty, gen_uom_code, dtl.issue_uom, am.short_desc gen_short_desc, NVL (dtl.authorized_item_qty, 0) authorized_item_qty, dtl.seq_no,(SELECT SUM (NVL (ack.received_qty, 0)) FROM st_acknowledge_trn_dtl ack WHERE dtl.doc_type_code = ack.doc_type_code(+) AND dtl.doc_no = ack.doc_no(+) AND dtl.doc_srl_no = ack.doc_srl_no(+) AND dtl.item_code = ack.item_code(+) AND dtl.facility_id = ack.facility_id(+) AND dtl.seq_no = ack.seq_no(+)) received_qty, (SELECT SUM (NVL (ack.rejected_qty, 0)) FROM st_acknowledge_trn_dtl ack WHERE dtl.doc_type_code = ack.doc_type_code(+) AND dtl.doc_no = ack.doc_no(+) AND dtl.doc_srl_no = ack.doc_srl_no(+) AND dtl.item_code = ack.item_code AND dtl.facility_id = ack.facility_id(+) AND dtl.seq_no = ack.seq_no(+)) rejected_qty, DECODE ((st_req_status_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no)), 'PAI', 'Partially Authorised/Issued At Issue Store', 'PA', 'Partially Authorised at Issue Store', 'FAPI', 'Fully Authorised/Partially Issued At Issue Store', 'FA', 'Fully Authorized at Issue Store', 'L', 'Cancelled', 'C', 'Issue Closed', 'E', 'Request Entered At Request Store', 'W', 'Authorised At Request By Store', 'FAFI', 'Fully Authorized/Issued at Issue Store', 'I', 'Force Closed' ) request_status, dtl.issue_uom_conv,dtl.REMARKS remarks,hdr.added_by_id, hdr.modified_by_id,TO_CHAR (hdr.modified_date, 'dd/mm/yyyy') modified_date FROM st_issue_hdr hdr, st_issue_dtl dtl, mm_item_lang_vw itm, am_uom_lang_vw am, mm_store_lang_vw rons, st_facility_param f,st_request_dtl req  WHERE  ";//Added st_request_dtl and related and conditions for MO-GN-5561

                if(called_from.equals("REQ")){
				    sql = sql+ " hdr.to_store_code = ? AND hdr.fm_store_code = rons.store_code and ";
				}else{
					sql = sql+ " hdr.fm_store_code = ? AND hdr.to_store_code = rons.store_code and ";
				}

				sql=sql+"(doc_date BETWEEN to_char(TRUNC (SYSDATE - durn_for_iss_history))AND to_char(TRUNC (SYSDATE + 1))) and HDR.FINALIZED_YN ='Y' AND hdr.doc_type_code = dtl.doc_type_code AND hdr.doc_no = dtl.doc_no AND dtl.item_code = itm.item_code and dtl.item_code = ? and hdr.facility_id =f.facility_id and dtl.doc_no  =req.doc_no(+) and dtl.doc_srl_no =req.doc_srl_no(+) and dtl.item_code =req.item_code(+) AND itm.language_id = ? AND rons.language_id = ? AND itm.language_id = am.language_id AND itm.gen_uom_code = am.uom_code order by doc_date desc,doc_no desc";
			
			
		
		
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_DATE");
			displayFields.add("DOC_NO");	
			displayFields.add("DOC_SRL_NO");
			displayFields.add("ISSUE_STORE_DESC");
			displayFields.add("ISSUE_UOM");
			displayFields.add("REQ_QTY");
			displayFields.add("AUTHORIZED_ITEM_QTY");
			displayFields.add("ISS_ITEM_QTY");
			displayFields.add("PENDING_ITEM_QTY");
			displayFields.add("RECEIVED_QTY");
			displayFields.add("REJECTED_QTY");
			displayFields.add("REQUEST_STATUS");
			displayFields.add("REMARKS");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("ADDED_BY_ID");
			displayFields.add("MODIFIED_BY_ID");
			displayFields.add("MODIFIED_DATE");
			
			
		    chkFields.add(request_by_store);
			chkFields.add(item_code);
			chkFields.add(locale);
			chkFields.add(locale);
			
						
			
			sqlMap.put("sqlData", sql);
			System.err.println("sqlMap=>"+sqlMap);
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			
			ArrayList result		=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			System.err.println("result = "+result);
			int recCount=0,i = 0;
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
				
	%>
	        <table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
			

				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;<%=result.get(1)%></td>
				
				
			</tr>
			</table>
			
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" id='tb1'>
				<tr>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.Item.label" bundle="${st_labels}"/>  <fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
<%
					if(called_from.equals("REQ")){
%>
					<th> Request On(Issuing) Store</th>
<%
			}else{
%>
                    <th> Requesting (Receiving) Store</th>
<%
			}
	%>
					<th><fmt:message key="Common.Issue.label" bundle="${st_labels}"/> <fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/> Qty</th>
					<th><fmt:message key="Common.Issue.label" bundle="${common_labels}"/> Qty</th>
					<th><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.ReceivedQty.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.RejectedQty.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
					<th width ='15%'>Item Level <fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
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
				String rmks_code = CommonBean.checkForNull((String)records.get(13));
					String req_status = CommonBean.checkForNull((String)records.get(12));
					String trn_type = "ISS";
					String module_id = "ST";
					String desc = "%";
					String rmks_desc ="";
					if(!rmks_code.equals("")){
					 rmks_desc =		bean.checkForNull((String)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT"),new String[]{locale,module_id,trn_type,rmks_code,desc}).get("DESCRIPTION"));
		           	}
					String status =CommonBean.checkForNull((String)records.get(12));
					if(status == null || status.equals(""))
						status ="Issued";
				
		%>
					<td class="<%=classvalue%>"><%=CommonBean.checkForNull((String)records.get(0),"&nbsp;")%></font></td>
				    <td class="<%=classvalue%>" align="right"><%=com.ehis.util.DateUtils.convertDate((String)records.get(1),"DMY","en",locale)%></td>
			        <td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(2),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(3),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(4),"&nbsp;")%></td>
					<!-- <td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>-->
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull(bean.getUOMDesc((String)records.get(5)),"&nbsp;")%></td><!-- Modified for ML-BRU-SCF-2210-TF -->
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(7),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(8),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(9),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(10),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull((String)records.get(11),"&nbsp;")%></td>
					<td class="<%=classvalue%>" align="center" onClick="displayAuditInfo(tr_<%=i%>);"><font class='HYPERLINK'><%=status%></td>
					<td class="<%=classvalue%>" align="center"><%=CommonBean.checkForNull(rmks_desc,"&nbsp;")%></td>  
					
					<td class='NODISPLAY'><%=records.get(14)%></td>
					<td class='NODISPLAY'><%=records.get(15)%></td>
					<td class='NODISPLAY'><%=records.get(16)%></td>
					<td class='NODISPLAY'><%=records.get(17)%></td>
					
			</tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="checkedIndices" id="checkedIndices"			value="" >
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"		value="">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name%>">
		
	</form>
		<%
			//out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
			</script>
		<%
		}
			out.println(" </table>	</form>");
		out.flush();
		
			//System.err.println("form@@==="+CommonBean.setForm (request ,"../../eST/jsp/IssueHistoryResult.jsp", searched));
			out.println(CommonBean.setForm (request ,"../../eST/jsp/IssueHistoryResult.jsp", searched));
		
	
	}
	catch(Exception e) {
		System.err.println("chkFields"+chkFields+"displayFields=="+displayFields);
		System.err.println("sqlMap"+sqlMap);
		out.print("Exception @ Result JSP :"+e.toString());
	}

putObjectInBean(bean_id,bean,request);
%>
</body>
</html>

