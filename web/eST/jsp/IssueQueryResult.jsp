<!DOCTYPE html>
<% 
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
21/01/2019		IN067798			B Haribabu						AMRI-CRF-0382 - New filter Authorized date

---------------------------------------------------------------------------------------------------------
*/ 
%>  
 <%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,webbeans.eCommon.*,java.sql.*,java.lang.*,eST.IssueBean,eCommon.XSSRequestWrapper " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<html>
	<head>
	<%
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String locale					=		(String)session.getAttribute("LOCALE");
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/Issue.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body>
	<%
	    String flag ="false"; //Added for AMRI-CRF-0382
	    String doc_type_code		=		request.getParameter("doc_type_code");
	//Added for AMRI-CRF-0382 starts 
			
		String auth_date_filt_yn = request.getParameter("siteid");
		//String bean_id			=		 "issueBean";
		//String bean_name		=		"eST.IssueBean";
		//IssueBean bean			=		(IssueBean) getBeanObject(bean_id,  bean_name,request);
		IssueBean bean = (IssueBean) getBeanObject("issueBean",  "eST.IssueBean", request ) ;  
		ArrayList urg_doctype_codes=null;
		urg_doctype_codes=bean.getAllUrgDocType();
	     if(urg_doctype_codes.contains(doc_type_code))
	     {
	    	 flag = "true";
	     }
	      
		
			//Added for  AMRI-CRF-0382 ends
	
		//String doc_type_code		=		request.getParameter("doc_type_code");
		//System.out.println("doc_type_code IN RESULT.JSP: "+doc_type_code);
		String doc_no				=		request.getParameter("doc_no");
		//String doc_date				=		CommonBean.checkForNull(request.getParameter("doc_date"),"");
		String fm_store				=		request.getParameter("fm_store");
		String to_store				=		request.getParameter("to_store");
		String item_class_code		=		request.getParameter("item_class_code");
		String language_id			=		request.getParameter("language_id");
		String facility_check		=		"";

		String from_doc_date		=		CommonBean.checkForNull(request.getParameter("from_doc_date"));
		String to_doc_date			=		CommonBean.checkForNull(request.getParameter("to_doc_date"));
		String from_auth_date		= "";   //Added for AMRI-CRF-0382 
		String to_auth_date		 = "";      //Added for AMRI-CRF-0382 
		String doc_type  ="";               //Added for AMRI-CRF-0382 

		if(!from_doc_date.equals(""))
			from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		
		if(!to_doc_date.equals(""))
			to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en"); 
		//Added for AMRI-CRF-0382 start
		if(auth_date_filt_yn.equals("true") && flag.equals("false") )
		{
		 from_auth_date		=		CommonBean.checkForNull(request.getParameter("from_authorize_date"));
		 to_auth_date			=		CommonBean.checkForNull(request.getParameter("to_authorize_date"));

		if(!from_auth_date.equals(""))
			from_auth_date				=		com.ehis.util.DateUtils.convertDate(from_auth_date,"DMY",locale,"en");
		
		if(!to_auth_date.equals(""))
			to_auth_date					=		com.ehis.util.DateUtils.convertDate(to_auth_date,"DMY",locale,"en"); 
		}
		//Added for AMRI-CRF-0382 end
		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		
		
		boolean searched					=		(request.getParameter("searched") == null) ?false:true;
		String classvalue					=		"";
		try{
			
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code					=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no							=		CommonBean.checkForNull(doc_no,"%");
		 /*if(doc_date!= "")
		 doc_date = com.ehis.util.DateUtils.convertDate((String)doc_date,"DMY",locale,"en");
         else
	      doc_date	= CommonBean.checkForNull(doc_date,"%");*/
		  
			fm_store						=		CommonBean.checkForNull(fm_store,"%");
			to_store						=		CommonBean.checkForNull(to_store,"%");
			item_class_code					=		CommonBean.checkForNull(item_class_code,"%");

			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_REQ_URG_HDR_QUERY_RESULT"));
              //Commented by Rabbani #inc no:28266 on 22/09/11
			//sqlMap.put("sqlData", "SELECT hdr.trn_type,HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC, HDR.DOC_NO, HDR.SEQ_NO,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, HDR.FM_STORE_CODE,FMS.SHORT_DESC FM_STORE_DESC, HDR.TO_STORE_CODE,TOS.SHORT_DESC TO_STORE_DESC, HDR.ITEM_CLASS_CODE,ITM.SHORT_DESC ITEM_CLASS_DESC, HDR.CLOSE_REQ_AFTER_ISSUE_YN,NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) REQ_STR_FACILITY_ID,SM.FACILITY_NAME REQ_STR_FACILITY_NAME FROM ST_ISSUE_HDR HDR,MM_STORE_LANG_VW FMS,MM_STORE_LANG_VW TOS,MM_ITEM_CLASS_LANG_VW ITM,SY_DOC_TYPE_MASTER_LANG_VW SY, /*ST_USER_ACCESS_FOR_STORE UACA,*/ST_USER_ACCESS_FOR_STORE UACB,ST_ACC_ENTITY_PARAM STP,SM_FACILITY_PARAM_LANG_VW SM, /*, ST_ACC_ENTITY_PARAM PA */ST_FACILITY_PARAM ST,ST_REQUEST_HDR REQ WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND HDR.FM_STORE_CODE = FMS.STORE_CODE AND HDR.TO_STORE_CODE = TOS.STORE_CODE AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+)  AND /*UACA.STORE_CODE = HDR.TO_STORE_CODE AND*/ HDR.FINALIZED_YN = 'N' AND DECODE (ST.ISS_ACK_REQ_YN, 'Y', HDR.PROCESS_FOR_ACKNOWLEDGE,'XX') = DECODE (ST.ISS_ACK_REQ_YN, 'Y', 'N', 'XX') AND /*UACB.USER_ID = UACA.USER_ID AND*/ UACB.STORE_CODE = HDR.FM_STORE_CODE AND HDR.DOC_TYPE_CODE LIKE ? AND TO_CHAR (HDR.DOC_NO) LIKE ? AND TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') LIKE ? AND HDR.FM_STORE_CODE LIKE ? AND HDR.TO_STORE_CODE LIKE ? AND NVL (HDR.ITEM_CLASS_CODE, 'X') LIKE ? AND UACB.USER_ID = ? AND (    FMS.FACILITY_ID = ? AND HDR.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN, 'Y', '%', ? )) /*AND REQ.FACILITY_ID(+) = HDR.FACILITY_ID*/ AND FMS.LANGUAGE_ID = TOS.LANGUAGE_ID AND FMS.LANGUAGE_ID = SY.LANGUAGE_ID AND FMS.LANGUAGE_ID = SM.LANGUAGE_ID AND FMS.LANGUAGE_ID = ? AND ITM.LANGUAGE_ID(+) = ? AND ST.FACILITY_ID = HDR.FACILITY_ID AND HDR.DOC_TYPE_CODE = REQ.DOC_TYPE_CODE(+) AND HDR.DOC_NO = REQ.DOC_NO(+) AND SM.FACILITY_ID = NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) AND (HDR.TRN_TYPE = DECODE(UACB.URG_ALLOWED_YN,'Y','URG','XXX' ) OR HDR.TRN_TYPE = DECODE(UACB.ISS_ALLOWED_YN,'Y','ISS','XXX' ))");
			//Added BY Rabbani inc no:28266 on 22/09/11
			//Added for AMRI-CRF-0382 start
			if(auth_date_filt_yn.equals("true") && flag.equals("false")){
			sqlMap.put("sqlData", "SELECT hdr.trn_type, hdr.doc_type_code, sy.short_desc doc_type_desc,hdr.doc_no, hdr.seq_no,TO_CHAR (hdr.doc_date, 'DD/MM/YYYY') doc_date,hdr.fm_store_code,fms.short_desc fm_store_desc, hdr.to_store_code,tos.short_desc to_store_desc, hdr.item_class_code,itm.short_desc item_class_desc, hdr.close_req_after_issue_yn,NVL (req.facility_id, hdr.facility_id) req_str_facility_id,sm.facility_name req_str_facility_name, apn.appl_user_name,TO_CHAR (hdr.added_date, 'DD/MM/YYYY HH24:MI:SS') added_date FROM st_issue_hdr hdr,sm_appl_user_vw apn,mm_store_lang_vw fms,mm_store_lang_vw tos,mm_item_class_lang_vw itm,sy_doc_type_master_lang_vw sy,st_user_access_for_store uacb,st_acc_entity_param stp,sm_facility_param_lang_vw sm,st_facility_param st,st_request_hdr req  WHERE hdr.doc_type_code = sy.doc_type_code AND hdr.fm_store_code = fms.store_code AND hdr.to_store_code = tos.store_code AND hdr.item_class_code = itm.item_class_code(+) AND apn.appl_user_id = DECODE (hdr.trn_type,'URG', hdr.added_by_id,req.added_by_id) AND hdr.finalized_yn = 'N'    AND DECODE (st.iss_ack_req_yn, 'Y', hdr.process_for_acknowledge, 'XX') = DECODE (st.iss_ack_req_yn,'Y', 'N','XX') AND uacb.store_code = hdr.fm_store_code AND hdr.doc_type_code LIKE ? AND TO_CHAR (hdr.doc_no) LIKE ? AND TO_DATE (TO_CHAR(hdr.doc_date,'dd/mm/yyyy'),'dd/mm/yyyy')BETWEEN TO_DATE (NVL(?, '01/01/1472'),'dd/mm/yyyy') AND TO_DATE(NVL(?,'31/12/5000'),'dd/mm/yyyy')AND TO_DATE(TO_CHAR(hdr.doc_date,'dd/mm/yyyy' ),'dd/mm/yyyy')BETWEEN TO_DATE (NVL(?,'01/01/1472'),'dd/mm/yyyy') AND TO_DATE(NVL(?,'31/12/5000'),'dd/mm/yyyy') AND hdr.fm_store_code LIKE ?  AND hdr.to_store_code LIKE ? AND NVL (hdr.item_class_code, 'X') LIKE ?    AND uacb.user_id = ? AND ( fms.facility_id = ? AND hdr.facility_id LIKE DECODE (trn_across_facility_yn, 'Y', '%', ?)) AND fms.language_id = tos.language_id AND fms.language_id = sy.language_id AND fms.language_id = sm.language_id AND fms.language_id = ? AND itm.language_id(+) = ? AND st.facility_id = hdr.facility_id AND hdr.doc_type_code = req.doc_type_code(+) AND hdr.doc_no = req.doc_no(+) AND sm.facility_id = NVL (req.facility_id, hdr.facility_id) AND (hdr.trn_type = DECODE (uacb.urg_allowed_yn, 'Y', 'URG', 'XXX') OR hdr.trn_type = DECODE (uacb.iss_allowed_yn, 'Y', 'ISS', 'XXX'))  AND ( req.request_status  IS NULL OR  req.request_status NOT IN ('W', 'C'))");	//added for  AND ( req.request_status  IS NULL OR  req.request_status NOT IN ('W', 'C')) MO-GN-5575
			}//Added for AMRI-CRF-0382 end
			else{
			sqlMap.put("sqlData", "SELECT hdr.trn_type,HDR.DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC, HDR.DOC_NO, HDR.SEQ_NO,TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') DOC_DATE, HDR.FM_STORE_CODE,FMS.SHORT_DESC FM_STORE_DESC, HDR.TO_STORE_CODE,TOS.SHORT_DESC TO_STORE_DESC, HDR.ITEM_CLASS_CODE,ITM.SHORT_DESC ITEM_CLASS_DESC, HDR.CLOSE_REQ_AFTER_ISSUE_YN,NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) REQ_STR_FACILITY_ID,SM.FACILITY_NAME REQ_STR_FACILITY_NAME,APN.APPL_USER_NAME,TO_CHAR (HDR.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM ST_ISSUE_HDR HDR,SM_APPL_USER_VW APN,  MM_STORE_LANG_VW FMS,MM_STORE_LANG_VW TOS,MM_ITEM_CLASS_LANG_VW ITM,SY_DOC_TYPE_MASTER_LANG_VW SY, /*ST_USER_ACCESS_FOR_STORE UACA,*/ST_USER_ACCESS_FOR_STORE UACB,ST_ACC_ENTITY_PARAM STP,SM_FACILITY_PARAM_LANG_VW SM, /*, ST_ACC_ENTITY_PARAM PA */ST_FACILITY_PARAM ST,ST_REQUEST_HDR REQ WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE AND HDR.FM_STORE_CODE = FMS.STORE_CODE AND HDR.TO_STORE_CODE = TOS.STORE_CODE AND HDR.ITEM_CLASS_CODE = ITM.ITEM_CLASS_CODE(+)AND APN.APPL_USER_ID = DECODE(HDR.trn_type, 'URG', HDR.ADDED_BY_ID,REQ.ADDED_BY_ID)  AND		/*UACA.STORE_CODE = HDR.TO_STORE_CODE AND*/ HDR.FINALIZED_YN = 'N' AND DECODE (ST.ISS_ACK_REQ_YN, 'Y', HDR.PROCESS_FOR_ACKNOWLEDGE,'XX') = DECODE (ST.ISS_ACK_REQ_YN, 'Y', 'N', 'XX') AND /*UACB.USER_ID = UACA.USER_ID AND*/ UACB.STORE_CODE = HDR.FM_STORE_CODE AND HDR.DOC_TYPE_CODE LIKE ? AND TO_CHAR (HDR.DOC_NO) LIKE ? AND /*TO_CHAR (HDR.DOC_DATE, 'DD/MM/YYYY') LIKE ?*/ TO_DATE (TO_CHAR (hdr.doc_date, 'dd/mm/yyyy'), 'dd/mm/yyyy')  BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'dd/mm/yyyy')AND TO_DATE (NVL (?, '31/12/5000'), 'dd/mm/yyyy') AND HDR.FM_STORE_CODE LIKE ? AND HDR.TO_STORE_CODE LIKE ? AND NVL (HDR.ITEM_CLASS_CODE, 'X') LIKE ? AND UACB.USER_ID = ? AND (    FMS.FACILITY_ID = ? AND HDR.FACILITY_ID LIKE DECODE (TRN_ACROSS_FACILITY_YN, 'Y', '%', ? )) /*AND REQ.FACILITY_ID(+) = HDR.FACILITY_ID*/ AND FMS.LANGUAGE_ID = TOS.LANGUAGE_ID AND FMS.LANGUAGE_ID = SY.LANGUAGE_ID AND FMS.LANGUAGE_ID = SM.LANGUAGE_ID AND FMS.LANGUAGE_ID = ? AND ITM.LANGUAGE_ID(+) = ? AND ST.FACILITY_ID = HDR.FACILITY_ID AND HDR.DOC_TYPE_CODE = REQ.DOC_TYPE_CODE(+) AND HDR.DOC_NO = REQ.DOC_NO(+) AND SM.FACILITY_ID = NVL(REQ.FACILITY_ID,HDR.FACILITY_ID) AND (HDR.TRN_TYPE = DECODE(UACB.URG_ALLOWED_YN,'Y','URG','XXX' ) OR HDR.TRN_TYPE = DECODE(UACB.ISS_ALLOWED_YN,'Y','ISS','XXX' ))  AND ( req.request_status  IS NULL OR  req.request_status NOT IN ('W', 'C')) ");//modified FOR MO-GN-5575
			}
			
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("SEQ_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("FM_STORE_DESC");
			displayFields.add("TO_STORE_DESC");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("FM_STORE_CODE");
			displayFields.add("TO_STORE_CODE");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("CLOSE_REQ_AFTER_ISSUE_YN");
			displayFields.add("REQ_STR_FACILITY_ID");
			displayFields.add("REQ_STR_FACILITY_NAME");
			displayFields.add("APPL_USER_NAME");
			displayFields.add("ADDED_DATE");
			displayFields.add("trn_type");
			
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			//chkFields.add(doc_date);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			//Added for AMRI-CRF-0382 start
			if(auth_date_filt_yn.equals("true") && flag.equals("false"))
			{
				chkFields.add(from_auth_date);
				chkFields.add(to_auth_date);
			}
			//Added for AMRI-CRF-0382 end
			chkFields.add(fm_store);
			chkFields.add(to_store);
			chkFields.add(item_class_code);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(language_id);
			chkFields.add(language_id);

			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			//System.out.println("sqlMap"+sqlMap);
			//System.out.println("chkFields"+chkFields);
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
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
					<th width='260'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<%if(auth_date_filt_yn.equals("true") && flag.equals("false")){ %>
 					<th width='400'><fmt:message key="eST.AuthorizeDate.label" bundle="${st_labels}"/></th> 
 					 <%} %> 
					<th width='260'><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ItemClass.label" bundle="${common_labels}"/></th>
					<th width='125'><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
					<th width='500'><fmt:message key="Common.createddate.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;

				records=(ArrayList) result.get(recCount);	
				
				if ( ! (facility_check.equals(records.get(12))) )
				 {
					facility_check= (String)records.get(12); 
					out.println("<tr><td class='ITEMSELECT' align='left' colspan='10'><b> Facility Name : "+(String)records.get(13)+"</b></td></tr>");
				
				 } %>
				<tr onClick="Modify(this,'<%=(String)((ArrayList)(result.get(recCount))).get(11)%>','<%=facility_check%>','<%=auth_date_filt_yn %>','<%=flag %>');" >
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" nowrap><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<%doc_type=(String)records.get(16);  //Added for AMRI-CRF-0382
				%>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(2)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(3),"DMY","en",locale)%></td>
				<%if(auth_date_filt_yn.equals("true") && flag.equals("false")){//Added for AMRI-CRF-0382 start %>
 				<% if(!doc_type.equals("URG")){ 
					%> 
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(15),"DMYHMS","en",locale)%></td> 
 				<%}else{ %> 
 				<td class="<%=classvalue%>" onclick="disableClick(event);"><%="&nbsp;"%></td> 
				<%} %> 
				<%}//Added for AMRI-CRF-0382 end%>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(5),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(6),"&nbsp;")%></td>										 
				<td class='NODISPLAY'><%=records.get(7)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get(14)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(15),"DMYHMS","en",locale)%></td>
			</tr>
		<%
			}
		%>
		</table>
		<div  id='readOnlyDiv'  style="visibility:hidden;z-index:3;position:absolute;top:0px;width:1007px;height:500px;background-color:#CCCFFF;filter:alpha(opacity=80);" >
		<table border="0" align="center" width="100%" height="100%">
		<tr><td align="center">
			
			</td></tr>
		</table>
		</div>
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/IssueQueryResult.jsp", searched));
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

