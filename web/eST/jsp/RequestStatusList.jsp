<!DOCTYPE html>
<%
/*
 ------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
08/05/2018		IN067386			Shazana 										  	ML-MMOH-SCF-0979 - Conversion factor live issue 
22/05/2018		67677				Shazana												ML-MMOH-SCF-1003 
10/07/2018		IN067830			Shazana												ML-MMOH-SCF-1013
19/06/2019              70724                           B Haribabu                                                               NMC-JD-SCF-0016
-------------------------------------------------------------------------------------------------------------------------------
*/
%>


<%@ page import="eST.RequestStatusBean, eST.AuthorizeAtIssueStoreBean, webbeans.eCommon.*,java.sql.*,java.lang.*"%><!--added for ML-MMOH-SCF-1013  -->
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@page import="java.util.HashMap,java.util.ArrayList,java.text.NumberFormat" contentType="text/html;charset=UTF-8"%>
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
		<script language="javascript" src="../../eST/js/RequestStatus.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eST.ItemDetails.label" bundle="${st_labels}"/></title>
	</head>
	<%
	try{
		String doc_type_code				=		request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		String doc_no						=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		boolean searched					=		(request.getParameter("searched") == null) ?false:true;
		String classvalue					=		"";
		RequestStatusBean bean				=		(RequestStatusBean) getBeanObject("RequestStatusBean","eST.RequestStatusBean", request);  
		AuthorizeAtIssueStoreBean bean_id				=		(AuthorizeAtIssueStoreBean) getBeanObject("AuthorizeAtIssueStoreBean","eST.AuthorizeAtIssueStoreBean", request);  
		bean.setLanguageId(locale);
		bean_id.setLanguageId(locale);
		
		//Added for ML-MMOH-SCF-1013 starts 
 		/*Connection con				= null;
 		con						= ConnectionManager.getConnection(request);
 		boolean site_main = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_CREATE_REQUEST_DEF_UOM");
		bean.setSite_spec_yn(site_main);
 		System.out.println("site_main for WCH: "+site_main); 
		//Added for ML-MMOH-SCF-1013 ends
		
	   	/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function
		*/
		int no_of_decimals=bean.getNoOfDecimals();
		//Added by rabbani #inc no:45231 on 28-NOV-2013
		String AckForReqyn				=		"";
		AckForReqyn						=		bean.getAckForReqyn(); 
		String req_store_code		    =		request.getParameter("store_code")==null?"":request.getParameter( "store_code" ) ;
		boolean blnIssAckReqd = bean.getIssAckReqd(req_store_code);		 
		
	%>
	<body >
	<form name='formRequestStatusList' id='formRequestStatusList'>
	<%
	try{
			HashMap sqlMap					=		new HashMap();
			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_STATUS_DTL_SELECT"));
			//commented by Rabbani #Bru-HIMS-CRF-118 on 26-JULY-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,NVL (dtl.pending_item_qty, 0) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE (request_status, 'L', (SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?)) remarks FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.seq_no,dtl.doc_srl_no");
			
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,NVL (dtl.pending_item_qty, 0) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(request_status, 'L', DECODE(DTL.CANCEL_REMARKS_DESC,'',(SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),DTL.CANCEL_REMARKS_DESC),DECODE(DTL.CANCEL_REMARKS_DESC,'',(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?),DTL.CANCEL_REMARKS_DESC)) remarks FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.seq_no,dtl.doc_srl_no");
			
			//Addded by Rabbani #Inc no :44011 (ML-BRU-SCF-1071) on 22-OCT-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,NVL (dtl.pending_item_qty, 0) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(request_status, 'L', DECODE(DTL.CANCEL_REMARKS_DESC,'',(SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),DTL.CANCEL_REMARKS_DESC),DECODE(DTL.CANCEL_REMARKS_DESC,'',(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?),DTL.CANCEL_REMARKS_DESC)) remarks,st.seq_no FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.seq_no,dtl.doc_srl_no");
			
			//added by Rabbani #inc no:41756(JD-CRF-0186) on 18-NOV-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(request_status, 'L', DECODE(DTL.CANCEL_REMARKS_DESC,'',(SELECT remarks_desc FROM mm_trn_remarks_lang_vw WHERE trn_remarks_code = hdr.cancelled_remarks  AND language_id = ?),DTL.CANCEL_REMARKS_DESC),DECODE(DTL.CANCEL_REMARKS_DESC,'',(select remarks_desc from mm_trn_remarks_lang_vw where dtl.auth_trn_remarks_code = trn_remarks_code and language_id = ?),DTL.CANCEL_REMARKS_DESC)) remarks,st.seq_no FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");
			
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(dtl.cancel_remarks_desc,'',(SELECT remarks_desc   FROM mm_trn_remarks_lang_vw WHERE   st.REMARKS = trn_remarks_code  AND language_id = ?), dtl.cancel_remarks_desc) remarks,st.seq_no FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");
			//Added by rabbani #inc no:45231 on 28-NOV-2013
			//sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(st.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code, st.ISSUE_UOM ,am.short_desc gen_short_desc, nvl(st.authorized_item_qty,0) authorized_item_qty,DECODE(dtl.cancel_remarks_desc,'',(SELECT remarks_desc   FROM mm_trn_remarks_lang_vw WHERE   st.REMARKS = trn_remarks_code  AND language_id = ?), dtl.cancel_remarks_desc) remarks,st.seq_no,(SELECT SUM (NVL(ack.RECEIVED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) RECEIVED_QTY,(SELECT SUM (NVL(ack.REJECTED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) REJECTED_QTY, DTL.REQUEST_UOM_CONV , DTL.REQUEST_UOM_QTY , dtl.REQUEST_UOM, DTL.REJECT_REMARKS_DESC FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");//ADDED FOR ML-MMOH-SCF-1003,MO-CRF-20174 
			sqlMap.put("sqlData", "SELECT   hdr.req_on_store_code,hdr.req_by_store_code store_code,dtl.doc_no, dtl.doc_srl_no, dtl.item_code, itm.short_desc item_desc,dtl.req_item_qty, nvl(dtl.iss_item_qty,0) iss_item_qty,(decode ((select max(seq_no) from st_issue_dtl a where dtl.doc_type_code = st.doc_type_code AND a.doc_no = st.doc_no AND a.doc_srl_no = st.doc_srl_no AND a.item_code = st.item_code ),st.seq_no,(NVL (dtl.PENDING_ITEM_QTY, 0)),'')) pending_item_qty, gen_uom_code, st.ISSUE_UOM ,am.short_desc gen_short_desc, nvl(dtl.committed_item_qty,0) authorized_item_qty,DECODE(dtl.cancel_remarks_desc,'',(SELECT remarks_desc   FROM mm_trn_remarks_lang_vw WHERE   st.REMARKS = trn_remarks_code  AND language_id = ?), dtl.cancel_remarks_desc) remarks,st.seq_no,(SELECT SUM (NVL(ack.RECEIVED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) RECEIVED_QTY,(SELECT SUM (NVL(ack.REJECTED_QTY,0)) FROM st_acknowledge_trn_dtl ack WHERE st.doc_type_code = ack.doc_type_code(+)  AND st.doc_no = ack.doc_no(+) AND st.doc_srl_no = ack.doc_srl_no(+) AND st.item_code = ack.item_code(+) and ST.FACILITY_ID = ACK.FACILITY_ID(+) and ST.SEQ_NO = ack.seq_no(+)) REJECTED_QTY, DTL.REQUEST_UOM_CONV , DTL.REQUEST_UOM_QTY , dtl.REQUEST_UOM, DTL.REJECT_REMARKS_DESC FROM st_request_hdr hdr,st_request_dtl dtl,mm_item_lang_vw itm,am_uom_lang_vw am,st_issue_dtl st WHERE hdr.doc_type_code = ? AND hdr.doc_no = ? and hdr.doc_type_code = dtl.doc_type_code and hdr.doc_no= dtl.doc_no AND dtl.item_code = itm.item_code AND itm.language_id = ? AND itm.language_id =  am.language_id AND itm.gen_uom_code = am.uom_code  AND dtl.doc_type_code = st.doc_type_code(+) AND dtl.doc_no = st.doc_no(+) AND dtl.doc_srl_no = st.doc_srl_no(+) AND dtl.item_code = st.item_code(+) ORDER BY st.item_code, st.seq_no,dtl.doc_srl_no");//Modified for ML-BRU-SCF-2230
			
			
		
			HashMap funcMap					=		new HashMap();
			ArrayList displayFields			=		new ArrayList();
            
			//displayFields.add("store_code");
			displayFields.add("doc_no");
			displayFields.add("doc_srl_no");
			displayFields.add("item_desc");
			displayFields.add("req_item_qty");
			displayFields.add("iss_item_qty");
			displayFields.add("pending_item_qty");
			displayFields.add("item_code");
			displayFields.add("gen_short_desc");
			displayFields.add("authorized_item_qty");
			displayFields.add("remarks");
			displayFields.add("store_code");
			displayFields.add("req_on_store_code");
			displayFields.add("seq_no"); //Addded by Rabbani #Inc no :44011 (ML-BRU-SCF-1071) on 22-OCT-2013
			displayFields.add("RECEIVED_QTY"); //Added by rabbani #inc no:45231 on 28-NOV-2013
			displayFields.add("REJECTED_QTY"); //Added by rabbani #inc no:45231 on 28-NOV-2013
			displayFields.add("ISSUE_UOM");//added for ML-MMOH-SCF-0979
			displayFields.add("gen_uom_code");//added for ML-MMOH-SCF-0979
			
			/*ADDED FOR ML-MMOH-SCF-1003 START*/
			displayFields.add("REQUEST_UOM_CONV"); 
			displayFields.add("REQUEST_UOM_QTY"); 
			displayFields.add("REQUEST_UOM");
			displayFields.add("REJECT_REMARKS_DESC");//MO-CRF-20174  
			/*ADDED FOR ML-MMOH-SCF-1003 END*/

			ArrayList chkFields				=		new ArrayList();
			//chkFields.add(locale); //17/08/12
			chkFields.add(locale);
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(locale);

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);

			ArrayList result				=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			int recCount=0;//,i = 0;
			double recQty = 0.0;//added for ml-mmoh-0979
			double requested_uom= 0.0;//added for ml-mmoh-scf-1003
			double requested_uom_qty = 0.0; //added for ml-mmoh-scf-1003
			String strReqQty = "0"; //added for ml-mmoh-0979
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
				    <th width='135'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/>/<fmt:message key="eST.SeqNo.label" bundle="${st_labels}"/></th> 
					<th width='10%'><fmt:message key="Common.item.label" bundle="${common_labels}"/></th>
					<th width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
					<th width='10%'><fmt:message key="Common.uom.label" bundle="${common_labels}"/></th>
					<th width='5%'><fmt:message key="eST.ReqQty.label" bundle="${st_labels}"/></th>
					<th width='125'><fmt:message key="Common.Authorized.label" bundle="${common_labels}"/> Qty</th>
					<th width='125'><fmt:message key="Common.Issue.label" bundle="${common_labels}"/> Qty</th>
					<!--<th width='125'><fmt:message key="Common.IssueQuantity.label" bundle="${common_labels}"/></th> -->
					<th width='125'><fmt:message key="Common.PendingQty.label" bundle="${common_labels}"/></th>
					<!-- //Added by rabbani #inc no:45231 on 28-NOV-2013 -->
					<%if(blnIssAckReqd && AckForReqyn.equals("Y") ){%>
					<th><fmt:message key="eST.ReceivedQty.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.RejectedQty.label" bundle="${st_labels}"/></th>
					<%}%>
					<th width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></th>
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
	//pmd 29/01/05
		//				String link_columns =	 "1";
						records				=	(ArrayList) result.get(recCount);
						 String pending_chk =  bean.checkForNull((String)records.get(5),"");//added by Rabbani #inc no:41756(JD-CRF-0186) on 18-NOV-2013
						 /*ADDED FOR ML-MMOH-SCF-1003 START*/
						 String issue_uom= bean.checkForNull((String)records.get(15),"");
						 String generic_uom= bean.checkForNull((String)records.get(16),"");
						 double requested_uom_pending =  Double.parseDouble(bean.checkForNull((String)records.get(17),"1"));
						 String req_uom= CommonBean.checkForNull((String)records.get(19),"");
						 /*ADDED FOR ML-MMOH-SCF-1003 END*/
						 
						 
						double pending_qty = Double.parseDouble(bean.checkForNull((String)records.get(5),"0"));
						double conv_factor = bean_id.getConvFactTemp((String)records.get(6),(String)records.get(10));
						
						
						//MODIFIED FOR ML-MMOH-SCF-1003 START
						double on_store_conv_factor = bean_id.getConvFactTemp((String)records.get(6),(String)records.get(11)); //Modified for 70724 
						 
		                  /*if(!(req_uom.equals(generic_uom))){
		                	  pending_qty = pending_qty * Double.parseDouble(bean.checkForNull((String)records.get(17)));  //added for ml-mmoh-scf-1013
		                  }else{
		                	  pending_qty = pending_qty;
		                  }*/ //commented for ML-MMOH-CRF-1200
		                  
		                //MODIFIED FOR ML-MMOH-SCF-1003 END 
		                 
						  String iss_seq_no = CommonBean.checkForNull((String)records.get(12),"");
						 
						  
						  double recv_qty = Double.parseDouble(bean.checkForNull((String)records.get(13),"0"));
						  double rej_qty = Double.parseDouble(bean.checkForNull((String)records.get(14),"0"));
						   
 						%>
					  <% if(iss_seq_no.equals("")) { %>
					  <td class="<%=classvalue%>" align="left" ><font size=1><%=CommonBean.checkForNull((String)records.get(0),"&nbsp;")%></font></td>
 						 
 						<% }else{ %>
						  <td class="<%=classvalue%>" align="left" ><font size=1><%=CommonBean.checkForNull((String)records.get(0),"&nbsp;")%>/<%=iss_seq_no%></font></td>
						<%} %>
						 <td class="<%=classvalue%>" align="left" ><font size=1><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%></font></td>
						 
						<td class="<%=classvalue%>" align="left" style='WORD-BREAK:BREAK-ALL;'><font size=1><%=records.get(2)%></font></td>
						 <td class="<%=classvalue%>" align="left" ><font size=1><%=CommonBean.checkForNull((String)records.get(7),"&nbsp;")%></font></td>
						 <%  
						 					 				
						 String issue_uom1= bean.checkForNull((String)records.get(15),"");
						 String generic_uom2= bean.checkForNull((String)records.get(16),"");
						 requested_uom_qty =  Double.parseDouble(bean.checkForNull((String)records.get(18),"0"));
						 requested_uom =  Double.parseDouble(bean.checkForNull((String)records.get(17),"0"));
						 System.err.println("issue_uom@@@=="+issue_uom1+" generic_uom@@@=="+generic_uom2+" req_uom: "+req_uom);
						 
						 /*added for ML-MMOH-SCF-1013 start */	
						 strReqQty =  bean.checkForNull((String)records.get(3),"0");
				System.err.println("strReqQty@@@==="+strReqQty);
					/*
							 if(!req_uom.equalsIgnoreCase(generic_uom)){
								 double req_Qty =  Double.parseDouble(bean.checkForNull((String)records.get(3),"0")) * Double.parseDouble(bean.checkForNull((String)records.get(17),"0")); 
								 int reqQty= (int)req_Qty;
								 strReqQty = String.valueOf(reqQty); 
							 }*/ //commented for ML-MMOH-CRF-1200
						  /*added for ML-MMOH-SCF-1013 end */	
						 
						 
						 %>
<%-- 						<td class="<%=classvalue%>" align="right"><font size=1><%=bean.setNumber(bean.checkForNull((String)records.get(3),"0"),no_of_decimals)%></font></td> --%> <!-- commented for ml-mmoh-scf-0979 -->
							<td class="<%=classvalue%>" align="right"><font size=1><%=strReqQty%></font></td><!-- added for ml-mmoh-scf-0979 -->
						<%
							
							//double au_qty = Double.parseDouble(bean.checkForNull((String)records.get(8),"0"))*(conv_factor);//Added for ML-MMOH-SCF-1003
							double au_qty = Double.parseDouble(bean.checkForNull((String)records.get(8),"0"))*(on_store_conv_factor);//Added for ML-MMOH-SCF-1003
									
							
							double iss_qty = Double.parseDouble(bean.checkForNull((String)records.get(4),"0"))*(on_store_conv_factor);
						%>
						<td class="<%=classvalue%>" align="right"><font size=1><%=bean.setNumber(Double.toString(au_qty),no_of_decimals)%></font></td>
						<td class="<%=classvalue%>" align="right"><font size=1><%=bean.setNumber(Double.toString(iss_qty),no_of_decimals)%></font></td>
						<%if(pending_chk.equals("")){ %>
						<td class="<%=classvalue%>" ><%=bean.checkForNull(pending_chk,"&nbsp;")%></td>
						<%}else{ %>
						<td class="<%=classvalue%>" align="right"><font size=1><%=bean.setNumber(Double.toString(pending_qty),no_of_decimals)%></font></td>
						<%} %>
						<!-- //Added by rabbani #inc no:45231 on 28-NOV-2013 -->
						<%if(blnIssAckReqd && AckForReqyn.equals("Y")){%>
						<td class="<%=classvalue%>" align="right"><font size=1><%=bean.setNumber(Double.toString(recv_qty),no_of_decimals)%></font></td>
						<td class="<%=classvalue%>" align="right"><font size=1><%=bean.setNumber(Double.toString(rej_qty),no_of_decimals)%></font></td>
						<%}else {%>
							<td class="NODISPLAY"><input type="hidden">&nbsp;</td>
							<td class="NODISPLAY"><input type="hidden">&nbsp;</td>
						<%}
						String cancelled_remarks = (String)records.get(9);//MO-CRF-20174
						String rejection_remarks = (String)records.get(20);
						System.out.println("cancelled_remarks "+cancelled_remarks+"---rejection_remarks: "+rejection_remarks); 
						%>
				<% if(cancelled_remarks!=null){ %>
							<td class="<%=classvalue%>" ><font size=1><%=bean.checkForNull((String)records.get(9),"&nbsp;")%></font></td>
							<%} %>
							<% if(rejection_remarks!=null){ %>
							<td class="<%=classvalue%>" ><font size=1><%=bean.checkForNull((String)records.get(20),"&nbsp;")%></font></td>
							<%} %><!-- MO-CRF-20174 END  -->
							
						
						
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
				//document.location.href="../../eCommon/html/blank.html";
				//history.go(-1);
				window.close();
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/RequestStatusList.jsp", searched));
	
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
	</form>
	<%
				out.println(CommonBean.setForm (request ,"../../eST/jsp/RequestStatusList.jsp", searched));
}catch (Exception e){
	e.printStackTrace();
}
%>
</body>
</html>
	

