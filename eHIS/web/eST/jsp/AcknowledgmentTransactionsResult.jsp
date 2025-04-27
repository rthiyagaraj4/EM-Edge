<!DOCTYPE html>
<%
/*
------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------
?           	100					?	         		?				?				created

17/02/2014	 	IN046954			Abdul Rabbani 	 17/02/2014		Abdul Rabbani		Query Caused no records to be                                                                                        retrieved if user selects Thai                                                                                        language	
10/8/2021		TFS22446			Shazana												ST-MOHE-CRF-0084.1-US014/09 -  Acknowledge Transactions																						
------------------------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page import="java.util.HashMap,java.util.ArrayList,java.text.NumberFormat,webbeans.eCommon.*,java.lang.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<html>
	<head>
	<%   
         request.setCharacterEncoding("UTF-8");
         String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");

		
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="JavaScript" src="../../eST/js/AcknowledgmentTransactions.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body>
	<%
		eST.AcknowledgmentBean bean = (eST.AcknowledgmentBean)getBeanObject( "acknowledgmentBean","eST.AcknowledgmentBean",request );
		bean.setLanguageId(locale);
		String ack_from_date		=		CommonBean.checkForNull(request.getParameter("ack_from_date"));
		String ack_to_date			=		CommonBean.checkForNull(request.getParameter("ack_to_date"));
		String drug_non_drug		=		request.getParameter("drug_non_drug");
		String item_code_from		=		CommonBean.checkForNull(request.getParameter("item_code_from"));
		String item_code_to			=		CommonBean.checkForNull(request.getParameter("item_code_to"));
		String rej_qty				=		request.getParameter("rej_qty");
		String issue_store_code		=		request.getParameter("issue_store_code");
		String receiving_store_code	=		request.getParameter("receiving_store_code");
		String item_desc			=		"";
		String bgc					=		"";
		int count					=		0;
		String sql					=		"";

		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		ArrayList alParam			=		new ArrayList();
		
		
		boolean searched					=		(request.getParameter("searched") == null) ?false:true;
		String classvalue					=		"";
		String user_name  =  (String) session.getValue( "login_user" ) ;//MOHE-CRF-0084.1 
		String facilityId = (String) session.getValue("facility_id"); //MOHE-CRF-0084.1
		boolean restrict_stores_user_access_yn =false;
	    	String strFacilityParam = "";
		String restrictInReportYN = "";
		Connection con				= null; 
		 try{
				con						= ConnectionManager.getConnection(request);
			    restrict_stores_user_access_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_RESTRICT_USER_ACCESS_STORES");
		    }
		 catch (Exception exp){
			 exp.printStackTrace();
			 System.out.println("Exception in AcknowledgeTransactionsResult.jsp");  
		 }
		    finally{ 
		    	if(con != null)
		    		ConnectionManager.returnConnection(con,request); 
		    }
		 strFacilityParam = bean.getRestrictUserAccessStore();
			System.out.println("strFacilityParam: "+strFacilityParam);   
			if(strFacilityParam== null || strFacilityParam.equals(""))
				strFacilityParam = "N"; 
			if(restrict_stores_user_access_yn){
				if(strFacilityParam.equals("Y")){
					restrictInReportYN = "Y";
				}else{
					restrictInReportYN = "N"; 
				}
			}//END 
		try{
			/**
			* @Name - Priya
			* @Date - 11/01/2010
			* @Inc# - 15496 (SRR20056-CRF-0537.2)
			* @Desc - To display the no of digits after decimal point as given in entity parameter function 
		*/
		int no_of_decimals=bean.getNoOfDecimals();
			
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			//item_code_from					=		CommonBean.checkForNull(item_code_from,"%");
			//item_code_to					=		CommonBean.checkForNull(item_code_to,"%");
			issue_store_code				=		CommonBean.checkForNull(issue_store_code,"%");
			receiving_store_code			=		CommonBean.checkForNull(receiving_store_code,"%");
			
			//Added by Rabbani #46954 (TTM-SCF-0075) on 13-02-2014
			ack_from_date					=		com.ehis.util.DateUtils.convertDate(ack_from_date,"DMY",locale,"en");
			ack_to_date					    =		com.ehis.util.DateUtils.convertDate(ack_to_date,"DMY",locale,"en"); 

			//sqlMap.put("sqlData", "SELECT MM.SHORT_DESC ITEM_DESC, AM.SHORT_DESC UOM_DESC, STOCK_ITEM_YN,TO_CHAR (ACKNOWLEDGE_DATE, 'DD/MM/YYYY HH24:MI:SS') ACK_DATE, ACK.DOC_TYPE_CODE,DOC_NO, ACK.ITEM_CODE, SUM(ACK.PENDING_QTY) PENDING_QTY, (SELECT SUM (ISSUE_QTY) FROM ST_ACKNOWLEDGE_TRN_DTL WHERE DOC_NO=ACK.DOC_NO AND DOC_TYPE_CODE=ACK.DOC_TYPE_CODE AND DOC_SRL_NO = ACK.DOC_SRL_NO AND SEQ_NO = ACK.SEQ_NO) ISSUE_QTY, SUM(RECEIVED_QTY) RECEIVED_QTY,SUM(REJECTED_QTY) REJECTED_QTY, ISSUING_STORE, RECEIVING_STORE, ACK.ADDED_BY_ID,CONFIRM_YN, ST1.SHORT_DESC ISS_STORE_DESC,ST2.SHORT_DESC REC_STORE_DESC, SY.SHORT_DESC DOC_TYPE_DESC,US.APPL_USER_NAME USER_NAME FROM ST_ACKNOWLEDGE_TRN_DTL_LOG ACK,ST_ITEM_STORE SIS,MM_ITEM_LANG_VW MM,AM_UOM_LANG_VW AM,MM_STORE_LANG_VW ST1,MM_STORE_LANG_VW ST2,SY_DOC_TYPE_MASTER_LANG_VW SY,SM_APPL_USER US,ST_ITEM STI WHERE SIS.STORE_CODE = ACK.ISSUING_STORE AND SIS.ITEM_CODE = ACK.ITEM_CODE AND MM.ITEM_CODE = ACK.ITEM_CODE AND MM.GEN_UOM_CODE = AM.UOM_CODE AND ST1.STORE_CODE = ACK.ISSUING_STORE AND ST2.STORE_CODE = ACK.RECEIVING_STORE AND SY.DOC_TYPE_CODE = ACK.DOC_TYPE_CODE AND ACK.ADDED_BY_ID = US.APPL_USER_ID AND STI.ITEM_CODE = ACK.ITEM_CODE AND TO_DATE (TO_CHAR (ACK.ACKNOWLEDGE_DATE, 'DD/MM/YYYY'), 'DD/MM/YYYY') BETWEEN TO_DATE (NVL (?, '01/01/1901'), 'DD/MM/YYYY') AND TO_DATE (NVL (?, TO_CHAR (SYSDATE,'DD/MM/YYYY')),'DD/MM/YYYY') AND ACK.ITEM_CODE BETWEEN NVL (UPPER(?), '!') AND NVL (UPPER(?), '~') AND STI.DRUG_ITEM_YN LIKE DECODE (?, 'D', 'Y', 'N','N','B','%') AND ACK.ISSUING_STORE LIKE UPPER(?) AND ACK.RECEIVING_STORE LIKE UPPER(?) AND SY.LANGUAGE_ID = ? AND ST2.LANGUAGE_ID = ? AND ST1.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = ? AND MM.LANGUAGE_ID = AM.LANGUAGE_ID AND (   (? = 'N' AND REJECTED_QTY <> 0) OR (? = 'Z' AND REJECTED_QTY = 0) OR (? = 'B' AND 1 = 1)) GROUP BY MM.SHORT_DESC, AM.SHORT_DESC, STOCK_ITEM_YN,ACKNOWLEDGE_DATE, ACK.DOC_TYPE_CODE,DOC_NO, ACK.ITEM_CODE, ISSUING_STORE, RECEIVING_STORE, ACK.ADDED_BY_ID,CONFIRM_YN, ST1.SHORT_DESC,ST2.SHORT_DESC, SY.SHORT_DESC,US.APPL_USER_NAME,ACK.DOC_SRL_NO,ACK.SEQ_NO ORDER BY MM.SHORT_DESC, ACKNOWLEDGE_DATE, ISSUING_STORE, RECEIVING_STORE");
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1
					sql =  eST.Common.StRepository.getStKeyValue("SQL_ST_ACKNOWLEDGMENT_TRANSACTION_QUERY_RESULT_RESTRICT_USER_ACCESS");			
			}
			else{
				sql =  eST.Common.StRepository.getStKeyValue("SQL_ST_ACKNOWLEDGMENT_TRANSACTION_QUERY_RESULT");	
			}
			
			
			displayFields.add("ITEM_CODE");
			displayFields.add("ITEM_DESC");
			displayFields.add("UOM_DESC");
			displayFields.add("ACK_DATE");
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("ISSUE_QTY");
			displayFields.add("PENDING_QTY");
			displayFields.add("RECEIVED_QTY");
			displayFields.add("REJECTED_QTY");
			displayFields.add("CONFIRM_YN");
			displayFields.add("ISS_STORE_DESC");
			displayFields.add("REC_STORE_DESC");
			displayFields.add("USER_NAME");
			displayFields.add("DOC_TYPE_CODE");
			//displayFields.add("REMARKS");

			
			/*chkFields.add(ack_from_date);
			chkFields.add(ack_to_date);
			chkFields.add(item_code_from);
			chkFields.add(item_code_to);
			chkFields.add(drug_non_drug);
			//chkFields.add(drug_non_drug);
			chkFields.add(issue_store_code);
			chkFields.add(receiving_store_code);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(rej_qty);
			chkFields.add(rej_qty);
			chkFields.add(rej_qty);*/

			//Modified by Sakti to pass the parameters dynamically for performance issue starts Inc# 51157
			chkFields.add(ack_from_date);
			chkFields.add(ack_to_date);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(rej_qty);
			chkFields.add(rej_qty);
			chkFields.add(rej_qty);

			if(!item_code_from.equals("")) {
				sql = sql+" AND ACK.ITEM_CODE BETWEEN ? AND '~' ";
				chkFields.add(item_code_from);
			}
			if(!item_code_to.equals("") ) {
				sql = sql+" AND ACK.ITEM_CODE BETWEEN '!' AND ? ";
				chkFields.add(item_code_to);
			}
			if(!drug_non_drug.equals("B")) {
				sql = sql+" AND STI.DRUG_ITEM_YN = DECODE (?, 'D', 'Y', 'N','N')";
				chkFields.add(drug_non_drug);
			}
			if(!issue_store_code.equals("%")) {
				sql = sql+" AND ACK.ISSUING_STORE = ?";
				chkFields.add(issue_store_code);
			}
			if(!receiving_store_code.equals("%")) {
				sql = sql+" AND ACK.RECEIVING_STORE = ?";
				chkFields.add(receiving_store_code);
			}
			if(restrict_stores_user_access_yn){//MOHE-CRF-0084.1
				if(strFacilityParam.equals("Y")){//MOHE-CRF-0084.1
					sql = sql+" AND ack.issuing_store IN (SELECT STORE_CODE FROM ST_USER_ACCESS_FOR_STORE WHERE USER_ID   = '"+user_name+"' ) AND ACK.RECEIVING_STORE in (SELECT STORE_CODE FROM ST_USER_ACCESS_FOR_STORE WHERE USER_ID=  '"+user_name+"' ) AND st2.facility_id LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',st2.facility_id, ? )";//modified for MOHE-CRF-0084.1 
					chkFields.add(facilityId);
				}//END 
				else if (strFacilityParam.equals("N")){
					sql = sql+" AND st2.facility_id LIKE decode(TRN_ACROSS_FACILITY_YN, 'Y',st2.facility_id, ? )";//modified for MOHE-CRF-0084.1 
					chkFields.add(facilityId);
				}
			}
			 
			sql = sql+ " GROUP BY MM.SHORT_DESC, AM.SHORT_DESC, STOCK_ITEM_YN,ACKNOWLEDGE_DATE, ACK.DOC_TYPE_CODE,DOC_NO, ACK.ITEM_CODE, ISSUING_STORE, RECEIVING_STORE, ACK.ADDED_BY_ID,CONFIRM_YN, ST1.SHORT_DESC,ST2.SHORT_DESC, SY.SHORT_DESC,US.APPL_USER_NAME,ACK.DOC_SRL_NO,ACK.SEQ_NO ORDER BY MM.SHORT_DESC, ACKNOWLEDGE_DATE, ISSUING_STORE, RECEIVING_STORE";
			//Modified by Sakti to pass the parameters dynamically for performance issue ENDS

			sqlMap.put("sqlData",sql);
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//out.println(result);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" >
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
				<tr>
					<th><fmt:message key="eST.AckDate.label" bundle="${st_labels}"/>&nbsp;Time</th>
					<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.IssuedQty.label" bundle="${st_labels}"/>.</th>
					<th><fmt:message key="eST.PendingAckQty.label" bundle="${st_labels}"/></th>
					<th><fmt:message key="eST.ReceivedQty.label" bundle="${st_labels}"/>.</th>
					<th><fmt:message key="eST.RejectedQty.label" bundle="${st_labels}"/>.</th>
					<th><fmt:message key="eST.PendingConf.label" bundle="${st_labels}"/>.</th>
					<th nowrap><fmt:message key="eST.IssuingStore.label" bundle="${st_labels}"/></th>
					<th nowrap><fmt:message key="Common.ReceivingStore.label" bundle="${common_labels}"/></th>
					<th nowrap><fmt:message key="Common.ReceivedBy.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eST.Remarks/BatchDetails.label" bundle="${st_labels}"/></th>
				</tr>		
		<%
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
				
				records=(ArrayList) result.get(recCount);
				alParam = new ArrayList();
				count = 0;
				alParam.add((String)records.get(5));
				alParam.add((String)records.get(14));
				//alParam.add((String)records.get(7));
				alParam.add((String)records.get(0));
				alParam.add((String)records.get(3));
				
				count = Integer.parseInt((String)((HashMap)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_ACKNOWLEDGE_TRN_DTL_LOG_COUNT"),alParam)).get("COUNT"));

				if(count>1){
					bgc = "YELLOW";
				}else{
					bgc = "";
				}
				if ( ! (item_desc.equals(records.get(0))) )
				 {
					item_desc = (String)records.get(0); %>
						<tr>
							<td class='ITEMSELECT' align='left' colspan="5"><%=records.get(0)%>&nbsp;-<%=records.get(1)%></td>
							<td class='ITEMSELECT' align='left' colspan="10"><fmt:message key="Common.uom.label" bundle="${common_labels}"/>: <%=records.get(2)%>&nbsp;</td>
						</tr>
		
				 <%} %>
				<tr>
				<td class="<%=classvalue%>" onclick="disableClick(event);" nowrap><%=com.ehis.util.DateUtils.convertDate((String)records.get(3),"DMYHMS","en",locale)%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" width="10%"><%=records.get(4)%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(5)%>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right" onclick="disableClick(event);"><%=bean.setNumber(bean.checkForNull((String)records.get(6),"0"),no_of_decimals)%>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right" onclick="disableClick(event);"><%=bean.setNumber(bean.checkForNull((String)records.get(7),"0"),no_of_decimals)%>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right" onclick="disableClick(event);"><%=bean.setNumber(bean.checkForNull((String)records.get(8),"0"),no_of_decimals)%>&nbsp;</td>
				<td class="<%=classvalue%>" style="TEXT-ALIGN:right" onclick="disableClick(event);"><%=bean.setNumber(bean.checkForNull((String)records.get(9),"0"),no_of_decimals)%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);">&nbsp;
					<%
						double reject_qty = Double.parseDouble((String)records.get(9));
						if(reject_qty > 0 && (CommonBean.checkForNull((String)records.get(10))).equals("N"))
							out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
						else if(reject_qty > 0 && (CommonBean.checkForNull((String)records.get(10))).equals("Y"))
							out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
					%>
				&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" width="10%"><%=records.get(11)%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);" width="10%"><%=records.get(12)%>&nbsp;</td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(13)%>&nbsp;</td>
				<td  onmouseover="changeCursor(this);" bgcolor="<%=bgc%>" onclick="showRemarks('<%=CommonBean.checkForNull((String)records.get(5))%>','<%=CommonBean.checkForNull((String)records.get(14))%>','<%=CommonBean.checkForNull((String)records.get(7))%>','<%=CommonBean.checkForNull((String)records.get(0))%>','<%=CommonBean.checkForNull((String)records.get(3))%>');">
					<font class="HYPERLINK"><fmt:message key="Common.view.label" bundle="${common_labels}"/></font> 
				</td>
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
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/AcknowledgmentTransactionsResult.jsp", searched));
	}
	catch(Exception ex) {		
		ex.printStackTrace();
	}finally{
			sqlMap.clear();	
			funcMap.clear();
			displayFields.clear();
			chkFields.clear();		
			result.clear();		
			records.clear();		
	}
%>
</body>
</html>

