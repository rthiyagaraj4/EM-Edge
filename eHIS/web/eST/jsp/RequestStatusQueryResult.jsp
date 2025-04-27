<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------------
Date		            Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
06/11/2019              IN0071699          B Haribabu                                  					Alpha incident
--------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
		<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	
		String locale			=	(String)session.getAttribute("LOCALE");
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<!--<script language="javascript" src="../../eCommon/js/messages.js"></script> -->
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
	<!--<script language='javascript' src='../../eST/js/StMessages.js'></script> -->
		<script language='javascript' src='../../eST/js/RequestStatus.js'></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body>
	<form name="formRequestStatusQueryResult" id="formRequestStatusQueryResult">
	<%
		String bean_id					=		"RequestStatusBean";
		String bean_name				=		"eST.RequestStatusBean";

		RequestStatusBean bean				=		(RequestStatusBean) getBeanObject(bean_id,bean_name,request);  

		String mode						=		"";
		String doc_type_code			=		request.getParameter("doc_type_code")==null?"":request.getParameter( "doc_type_code" ) ;
		String doc_no					=		request.getParameter("doc_no")==null?"":request.getParameter( "doc_no" ) ;
		String from_doc_date			=		request.getParameter("from_doc_date")==null?"":request.getParameter( "from_doc_date" ) ;
		String to_doc_date				=		request.getParameter("to_doc_date")==null?"":request.getParameter( "to_doc_date" ) ;
		String request_by_store			=		request.getParameter("request_by_store")==null?"":request.getParameter( "request_by_store" ) ;
		String request_on_store			=		request.getParameter("request_on_store")==null?"":request.getParameter( "request_on_store" ) ;
		String item_class_code			=		request.getParameter("item_class_code")==null?"":request.getParameter( "item_class_code" ) ;
		String request_type				=		request.getParameter("request_type")==null?"":request.getParameter( "request_type" ) ;
		String request_status			=		request.getParameter("request_status")==null?"":request.getParameter( "request_status" ) ;
		String external_yn				=		request.getParameter("external_yn")==null?"":request.getParameter( "external_yn" ) ;
		String item_code				=		request.getParameter("item_code")==null?"":request.getParameter( "item_code" ) ;
		String acknowledge_status				=		request.getParameter("acknowledge_status")==null?"":request.getParameter( "acknowledge_status" ) ;
		
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		String AckForReqyn				=		"";
		AckForReqyn						=		bean.getAckForReqyn(); //Added By Sakti against Inc# - 29421
		HashMap sqlMap					=		new HashMap();
		String	sql						=		"";
		HashMap funcMap					=		new HashMap();
		ArrayList displayFields			=		new ArrayList();
		ArrayList chkFields				=		new ArrayList();
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));

			doc_type_code				=		CommonBean.checkForNull(doc_type_code);
			doc_no						=		CommonBean.checkForNull(doc_no);
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
			//Added for IN:0071699 start
			if(!locale.equals("en"))
			{
				from_doc_date=com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
				to_doc_date=com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
			}
			//Added for IN:0071699 start
			request_by_store			=		CommonBean.checkForNull(request_by_store);
			request_on_store			=		CommonBean.checkForNull(request_on_store);
			item_class_code				=		CommonBean.checkForNull(item_class_code,"%");
			request_type				=		CommonBean.checkForNull(request_type,"");//% removed
			if(request_type.equals("%")){
				request_type="";
			}
			request_status				=		CommonBean.checkForNull(request_status,"%").trim();
			item_code					=		CommonBean.checkForNull(item_code,"").trim( );//% removed
			external_yn					=		CommonBean.checkForNull(external_yn,"N");
			acknowledge_status			=		CommonBean.checkForNull(acknowledge_status,"%");
            
			if(!(request_status.equals("P"))) {
			
				sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_STATUS_HDR_QUERY_RESULT_FOR_ALL");
			
			}else if (request_status.equals("P")) {
				
				sql = eST.Common.StRepository.getStKeyValue("SQL_ST_REQUEST_STATUS_HDR_QUERY_RESULT_FOR_PARTIAL_ISSUE");
			}
		
		
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("REQ_BY_STORE_DESC");
			displayFields.add("REQ_ON_STORE_DESC");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("REQ_BY_STORE_CODE");
			displayFields.add("REQ_ON_STORE_CODE");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("REQUEST_STATUS");
			displayFields.add("CANCELLED_REMARKS");
			displayFields.add("CANCELLED_BY_ID");
			displayFields.add("ADDED_BY_ID");          
			displayFields.add("REQ_AUTHORIZED_BY_ID"); 
			displayFields.add("MODIFIED_BY_ID");       
			displayFields.add("ACK_STATUS");       
			displayFields.add("MODIFIED_DATE");        
			displayFields.add("cancelled_by_name");        
			displayFields.add("added_by_name");        
			displayFields.add("authorized_by_name");        
			displayFields.add("modified_by_name");        
			displayFields.add("SCH_CODE");        
//			displayFields.add("TRN_TYPE");        

			/*
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(request_by_store);
			chkFields.add(request_on_store);
			chkFields.add(item_class_code);
			chkFields.add(external_yn);
			if(request_status.equalsIgnoreCase("P"))
				request_status="%";
			chkFields.add(request_status);
			chkFields.add(request_type);
			chkFields.add(acknowledge_status);
			chkFields.add(item_code);
			chkFields.add(locale);
			chkFields.add(locale);
			//chkFields.add(bean.getLoginFacilityId());
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			//chkFields.add(bean.getLoginFacilityId());*/

			//Modified by Sakti to pass the parameters dynamically for performance issue starts
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(locale);
			chkFields.add(bean.getLoginFacilityId());
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(external_yn);
			chkFields.add(locale);
			chkFields.add(locale);
			
						
			if(!doc_type_code.equals("")) {
				sql = sql + "AND hdr.doc_type_code = ?";
				chkFields.add(doc_type_code);
			}
			if(!doc_no.equals("")) {
				sql = sql + "AND TO_CHAR (hdr.doc_no)  = ? ";
				chkFields.add(doc_no);
			}
			if(!request_by_store.equals("")) {
				sql = sql + "AND hdr.req_by_store_code = ? ";
				chkFields.add(request_by_store);
			}
			if(!request_on_store.equals("")) {
				sql = sql + "AND hdr.req_on_store_code = ? ";
				chkFields.add(request_on_store);
			}
			if(!item_class_code.equals("%")) {
				sql = sql + "AND hdr.item_class_code = ? ";
				chkFields.add(item_class_code);
			}
			if(request_status.equalsIgnoreCase("P"))
				request_status="%";
			if(!request_status.equals("%")) {
				sql = sql + "AND (st_req_status_chk (hdr.facility_id, hdr.doc_type_code, hdr.doc_no)) =  ? ";
				chkFields.add(request_status);
			}
			if(!request_type.equals("")) {
				sql = sql + "AND hdr.request_type =  ? ";
				chkFields.add(request_type);
			}
			if(!item_code.equals("")) {
				sql = sql + "AND (hdr.facility_id, hdr.doc_type_code, hdr.doc_no) in (select facility_id, doc_type_code, doc_no from st_request_dtl where facility_id=hdr.facility_id and doc_type_code=hdr.doc_type_code and  doc_no=hdr.doc_no and item_code = ? ) ";
				chkFields.add(item_code);
			}
			
			if(!acknowledge_status.equals("%")){
				sql = sql + " AND (St_Req_Ack_Status (hdr.facility_id, hdr.doc_type_code, hdr.doc_no)) = ? ";
				chkFields.add(acknowledge_status);
			}
			//Modified by Sakti to pass the parameters dynamically for performance issue ends
			
			sqlMap.put("sqlData", sql);
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
					<th><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="Common.RequestStatus.label" bundle="${common_labels}"/></th>
					<% if(AckForReqyn.equals("Y")){%> <!--Added By Sakti against Inc# - 29421  -->
					<th nowrap>Acknowledgement Status</th>
					<%}%>
				<!--<th width='3'>Cancel</th><th >Reason</th>	-->
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
	//pmd 29/01/05
		//				String link_columns = "1";
				records=(ArrayList) result.get(recCount);
				System.out.println(records.get(16));
		%>
					<td class="<%=classvalue%>" onClick="displayPending(tr_<%=i%>);" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);" align="right"><%=records.get(1)%></td>
			        <td class="<%=classvalue%>" onclick="disableClick(event);" align="center"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>
					
					<!--
					<td class="<%=classvalue%>" onclick="disableClick(event);" align="center"><input type="checkbox" name="doc_<%=i%>" id="doc_<%=i%>" onClick="changeMyRowColor(<%=i%>,8,this)" value="<%=records.get(6)%>-<%=records.get(1)%>"></td>
					<td class="<%=classvalue%>" onClick="showReason(tr_<%=i%>,<%=i%>);" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>Reason</font></td>
					<td class='NODISPLAY'><%=records.get(6)%></td>
					<input type="hidden" name="checked_yn_<%=i%>" id="checked_yn_<%=i%>" value="" %>
					-->
				<%
				//String stTitle	=	"Cancelled By :"+ CommonBean.checkForNull((String)records.get(12))+" Remarks: "+CommonBean.checkForNull((String)records.get(11))	;
				//Added by Padmapriya for INC # 34746 on 30/08/2012
					String rmks_code = CommonBean.checkForNull((String)records.get(11));
					//String trn_type = CommonBean.checkForNull((String)records.get(23));
					String trn_type = "REQ";
					String module_id = "ST";
					String desc = "%";
					String rmks_desc =		bean.checkForNull((String)bean.fetchRecord(eST.Common.StRepository.getStKeyValue("SQL_ST_TRN_REMARKS_LOOKUP_SELECT"),new String[]{locale,module_id,trn_type,rmks_code,desc}).get("DESCRIPTION"));
					String stTitle	=	"Cancelled By :"+ CommonBean.checkForNull((String)records.get(18))+" Remarks: "+rmks_desc	;
				//End by Padmapriya for INC # 34746 on 30/08/2012	
				   
				   String store_code = (String)records.get(7);
				   String req_stat =(String)records.get(10);		
				%>	  
					<td class="<%=classvalue%>" nowrap onClick="displayAuditInfo(tr_<%=i%>);" onmouseover="changeCursor(this);" align="left" title="<%=CommonBean.checkForNull((String)records.get(11)).equals("")?"":stTitle%>"><font class='HYPERLINK'><%=records.get(10)%></font></td>
			<!--Added By Sakti against Inc# - 29421 Starts  -->
			<!-- Added by Rabbani #Bru-HIMS-CRF-112 on 21-AUG-2013 -->
					<% if(AckForReqyn.equals("Y")) {
					if(bean.getIssAckReqd(store_code) && (!(req_stat.equals("Rejected At Issue Store ")))) {%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(16),"&nbsp;")%></td>
					<%}else{%>
					<td class="<%=classvalue%>" >&nbsp;</td>
					<%}%>
					<%}else {%>
							<td class="NODISPLAY"><input type="hidden">&nbsp;</td>
						<%}%>
						<!--Added By Sakti against Inc# - 29421 Ends  -->
						
					<td class='NODISPLAY'><input type="hidden" name="doc_<%=i%>" id="doc_<%=i%>" value="<%=records.get(6)%>-<%=records.get(1)%>"></td>
					
					
					<td class='NODISPLAY'><%=records.get(6)%></td>
					<td class='NODISPLAY'><%=records.get(13)%></td>
					<td class='NODISPLAY'><%=records.get(14)%></td>
					<td class='NODISPLAY'><%=records.get(15)%></td>
					<td class='NODISPLAY'><%=records.get(17)%></td>
					<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(18))%></td>
					<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(19))%></td>
					<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(20))%></td>
					<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(21))%></td>
					<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(22))%></td>
					<!--//Added by rabbani #inc no:45231 on 28-NOV-2013 -->
					<td class='NODISPLAY'><%=CommonBean.checkForNull((String)records.get(7))%></td>
					
			</tr>
		<%
			}
		%>
		</table>
		<input type="hidden" name="checkedIndices" id="checkedIndices"			value="" %>
		<input type="hidden" name="total_check_boxes" id="total_check_boxes"		value="<%=i%>">
		<input type="hidden" name="bean_id" id="bean_id"					value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name"				value="<%= bean_name%>">
		<!--<input type="hidden" name="mode" id="mode"					value="<%= mode%>"> -->
	</form>
		<%
			out.flush();
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/RequestStatusQueryResult.jsp", searched));
	
	}
	catch(Exception e) {
		System.err.println("chkFields"+chkFields);
		System.err.println("sqlMap"+sqlMap);
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

