<!DOCTYPE html>
<%@ page import="eST.PORequestStatusBean"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,java.text.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp"%>
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
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eST/js/StCommon.js"></script>
		<script language="javascript" src="../../eST/js/PORequestStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></title>
	</head>
	<%
	
		String doc_type_code				=		request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		String doc_no						=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		boolean searched					=		(request.getParameter("searched") == null) ?false:true;

		String classvalue					=		"";
		PORequestStatusBean bean				=		(PORequestStatusBean) getBeanObject("PORequestStatusBean","eST.PORequestStatusBean", request);  
		bean.setLanguageId(locale);
		/**
		* @Name - Krishna Kiran 
		* @Date - 19/01/2010
		* @Inc# - 15496 (SRR20056-CRF-0537.2)
		* @Desc - No of Decimal is brought here in order to pass a value to setNumber Function.
		*/
		int no_of_decimals = bean.getNoOfDecimals();
		//int no_of_decimals_tmp = no_of_decimals;
		//NumberFormat nf_qty = NumberFormat.getInstance(new Locale(locale));
	%>
	<body >
	<form name='formPORequestStatusList' id='formPORequestStatusList'>
	<%
	try{
			HashMap sqlMap					=		new HashMap();
			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_PO_REQUEST_DTL_SELECT2"));
		//	sqlMap.put("sqlData", "SELECT   dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_qty req_item_qty, gen_uom_code, am.short_desc gen_short_desc,hdr.curr_status_remarks remarks  FROM po_request_dtl dtl, mm_item_lang_vw itm, am_uom_lang_vw am,po_request_hdr hdr WHERE dtl.doc_type_code = ? AND dtl.doc_no = ? AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id = am.language_id AND itm.gen_uom_code = am.uom_code AND hdr.doc_no=dtl.doc_no AND hdr.doc_type_code=dtl.doc_type_code AND hdr.facility_id=dtl.facility_id ORDER BY doc_srl_no ");

			HashMap funcMap					=		new HashMap();
			ArrayList displayFields			=		new ArrayList();

			displayFields.add("doc_no");
			displayFields.add("doc_srl_no");
			displayFields.add("item_desc");
			displayFields.add("req_item_qty");
			displayFields.add("item_code");
			displayFields.add("gen_short_desc");
			displayFields.add("remarks");

			ArrayList chkFields				=		new ArrayList();
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(locale);

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result				=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			int recCount=0;
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
					<th width='135'><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
					<th width='310'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
					<th width='75'><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
					<th width='300'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>				
				</tr>		
		<%
			ArrayList records	=	new ArrayList();
			for(recCount=2;recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue  = "OAQRYEVEN" ;
				else
					classvalue  = "OAQRYODD" ;
		%>
				<tr >
				<%
						records				=	(ArrayList) result.get(recCount);
						/**
						* @Name - Krishna Kiran 
						* @Date - 19/01/2010
						* @Inc# - 15496 (SRR20056-CRF-0537.2)
						* @Desc - No of Decimal is shown here for every item code based on the value of allowDecimalsYN().
						*/
						//if((bean.getAllowDecimalsYN(records.get(4).toString())).equals("N"))
							//	no_of_decimals = 0;				
					//	else
								//no_of_decimals = no_of_decimals_tmp;
						
						//nf_qty.setMaximumFractionDigits(no_of_decimals);
						//nf_qty.setMinimumFractionDigits(no_of_decimals);
		%>
						<td class="<%=classvalue%>" align="left"><%=records.get(4)%></td>
						<td class="<%=classvalue%>" align="left"style="WORD-BREAK:BREAK-ALL;"><%=records.get(2)%></td>
						<td class="<%=classvalue%>" align="center"><%=records.get(5)%></td>
						
						<%/**
						* @Name - Krishna Kiran 
						* @Date - 19/01/2010
						* @Inc# - 15496 (SRR20056-CRF-0537.2)
						* @Desc - No of Decimals is shown here for reqQty values of the item code.
						*/%>
						<td class="<%=classvalue%>" align="right" nowrap>
						<%=bean.setNumber(records.get(3).toString(),no_of_decimals)%>	
						</td>
						<td class="<%=classvalue%>" align="left"><%=bean.checkForNull((String)records.get(6))%>&nbsp;</td>	
						
	</tr>
		<%
			}
		%>
			</table>


		
		<%
			out.flush();
		} 
		else{
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				window.close();
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/PORequestStatusList.jsp", searched));
	
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
	</form>
	<%
				out.println(CommonBean.setForm (request ,"../../eST/jsp/PORequestStatusList.jsp", searched));
				
%>
</body>
</html>
	

