<!DOCTYPE html>
<%@page import="java.util.HashMap,java.util.ArrayList,eST.IssueReturnBean" contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
	<%
			request.setCharacterEncoding("UTF-8");
			String locale				=		(String)session.getAttribute("LOCALE");
		
			String sStyle				=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/IssueReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	</head>
	<body>
	<%
		String doc_type_code		=		request.getParameter("doc_type_code");
		String doc_no				=		request.getParameter("doc_no");
		String doc_date				=		request.getParameter("doc_date");
		//doc_date					=		com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
		String fm_store				=		request.getParameter("fm_store");
		String to_store				=		request.getParameter("to_store");
		String language_id			=		request.getParameter("language_id");
		boolean searched			=		(request.getParameter("searched") == null) ?false:true;
		String classvalue			=		"";
		String from_doc_date		=		request.getParameter("from_doc_date");
		from_doc_date				=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		String to_doc_date			=		request.getParameter("to_doc_date");
		to_doc_date					=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");

		HashMap sqlMap				=		new HashMap();
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();
		ArrayList chkFields			=		new ArrayList();
		ArrayList result			=		new ArrayList();
		ArrayList records			=		new ArrayList();
		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code				   =		CommonBean.checkForNull(doc_type_code,"%");
			doc_no						   =		CommonBean.checkForNull(doc_no,"%");
			//doc_date					   =		CommonBean.checkForNull(doc_date,"%");
			 from_doc_date				   =		CommonBean.checkForNull(from_doc_date,"");
			 to_doc_date				   =		CommonBean.checkForNull(to_doc_date,"");
			fm_store					   =		CommonBean.checkForNull(fm_store,"%");
			to_store					   =		CommonBean.checkForNull(to_store,"%");

			//sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_ISSUE_RETURN_HDR_QUERY_RESULT"));
			//sqlMap.put("sqlData","SELECT HDR.DOC_TYPE_CODE DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO, TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.FM_STORE_CODE FM_STORE_CODE,  FMS.SHORT_DESC  FM_STORE_DESC,HDR.TO_STORE_CODE TO_STORE_CODE,TOS.SHORT_DESC	TO_STORE_DESC, HDR.ITEM_CLASS_CODE ITEM_CLASS_CODE, ITMCLS.SHORT_DESC ITEM_CLASS_DESC FROM ST_ISSUE_RET_HDR	HDR, MM_STORE_LANG_VW FMS,MM_STORE_LANG_VW	TOS,  SY_DOC_TYPE_MASTER_LANG_VW	SY,	ST_USER_ACCESS_FOR_STORE	UACB , MM_ITEM_CLASS ITMCLS,st_facility_param st WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE	AND	HDR.FM_STORE_CODE=	FMS.STORE_CODE	AND	 HDR.TO_STORE_CODE = TOS.STORE_CODE AND	HDR.FINALIZED_YN='N' AND DECODE(st.ACKNOWLEDGE_REQD_YN, 'Y', hdr.process_for_acknowledge,'XX') = DECODE(st.ACKNOWLEDGE_REQD_YN, 'Y','N','XX') AND UACB.RET_ALLOWED_YN	= 'Y' AND UACB.STORE_CODE =	HDR.FM_STORE_CODE AND UACB.RET_ALLOWED_YN =	'Y' AND HDR.DOC_TYPE_CODE LIKE ?	AND	TO_CHAR(HDR.DOC_NO)	LIKE  ?	AND	TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') LIKE ?  AND	HDR.FM_STORE_CODE LIKE ? AND HDR.TO_STORE_CODE LIKE	? AND UACB.USER_ID	= ? AND FMS.FACILITY_ID=? AND FMS.LANGUAGE_ID = TOS.LANGUAGE_ID AND FMS.LANGUAGE_ID = SY.LANGUAGE_ID AND TOS.LANGUAGE_ID = ? AND HDR.ITEM_CLASS_CODE = ITMCLS.ITEM_CLASS_CODE(+) AND st.facility_id = hdr.facility_id");
			 //Commented by Rabbani inc no: 28266 on 22/09/11
			//sqlMap.put("sqlData","SELECT HDR.DOC_TYPE_CODE DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO, TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.FM_STORE_CODE FM_STORE_CODE,  FMS.SHORT_DESC  FM_STORE_DESC,HDR.TO_STORE_CODE TO_STORE_CODE,TOS.SHORT_DESC	TO_STORE_DESC, HDR.ITEM_CLASS_CODE ITEM_CLASS_CODE, ITMCLS.SHORT_DESC ITEM_CLASS_DESC FROM ST_ISSUE_RET_HDR	HDR, MM_STORE_LANG_VW FMS,MM_STORE_LANG_VW	TOS,  SY_DOC_TYPE_MASTER_LANG_VW	SY,	ST_USER_ACCESS_FOR_STORE	UACB , MM_ITEM_CLASS ITMCLS,ST_FACILITY_PARAM ST WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE	AND	HDR.FM_STORE_CODE=	FMS.STORE_CODE	AND	 HDR.TO_STORE_CODE = TOS.STORE_CODE AND	HDR.FINALIZED_YN='N' AND DECODE(ST.RET_ACK_REQ_YN, 'Y', HDR.PROCESS_FOR_ACKNOWLEDGE,'XX') = DECODE(ST.RET_ACK_REQ_YN, 'Y','N','XX') AND UACB.RET_ALLOWED_YN	= 'Y' AND UACB.STORE_CODE =	HDR.FM_STORE_CODE AND UACB.RET_ALLOWED_YN =	'Y' AND HDR.DOC_TYPE_CODE LIKE ?	AND	TO_CHAR(HDR.DOC_NO)	LIKE  ?	AND	TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') LIKE ?  AND	HDR.FM_STORE_CODE LIKE ? AND HDR.TO_STORE_CODE LIKE	? AND UACB.USER_ID	= ?  AND HDR.FACILITY_ID= FMS.FACILITY_ID AND FMS.FACILITY_ID=? AND FMS.LANGUAGE_ID = TOS.LANGUAGE_ID AND FMS.LANGUAGE_ID = SY.LANGUAGE_ID AND TOS.LANGUAGE_ID = ? AND HDR.ITEM_CLASS_CODE = ITMCLS.ITEM_CLASS_CODE(+) AND ST.FACILITY_ID = HDR.FACILITY_ID");
			//Added BY Rabbani inc no:28266  on 22/09/11
			sqlMap.put("sqlData","SELECT HDR.DOC_TYPE_CODE DOC_TYPE_CODE, SY.SHORT_DESC DOC_TYPE_DESC,HDR.DOC_NO, TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') DOC_DATE, HDR.FM_STORE_CODE FM_STORE_CODE,  FMS.SHORT_DESC  FM_STORE_DESC,HDR.TO_STORE_CODE TO_STORE_CODE,TOS.SHORT_DESC	TO_STORE_DESC, HDR.ITEM_CLASS_CODE ITEM_CLASS_CODE, ITMCLS.SHORT_DESC ITEM_CLASS_DESC,APN.APPL_USER_NAME,TO_CHAR (HDR.ADDED_DATE, 'DD/MM/YYYY HH24:MI:SS') ADDED_DATE FROM ST_ISSUE_RET_HDR	HDR,  MM_STORE_LANG_VW FMS,MM_STORE_LANG_VW	TOS,  SY_DOC_TYPE_MASTER_LANG_VW	SY,	SM_APPL_USER_VW APN,ST_USER_ACCESS_FOR_STORE	UACB , MM_ITEM_CLASS ITMCLS,ST_FACILITY_PARAM ST WHERE HDR.DOC_TYPE_CODE = SY.DOC_TYPE_CODE	AND	HDR.FM_STORE_CODE=	FMS.STORE_CODE	AND	 HDR.TO_STORE_CODE = TOS.STORE_CODE AND	HDR.FINALIZED_YN='N' AND DECODE(ST.RET_ACK_REQ_YN, 'Y', HDR.PROCESS_FOR_ACKNOWLEDGE,'XX') = DECODE(ST.RET_ACK_REQ_YN, 'Y','N','XX') AND  UACB.RET_ALLOWED_YN	= 'Y' AND UACB.STORE_CODE =	HDR.FM_STORE_CODE AND APN.APPL_USER_ID = HDR.ADDED_BY_ID AND UACB.RET_ALLOWED_YN =	'Y' AND HDR.DOC_TYPE_CODE LIKE ?	AND	TO_CHAR(HDR.DOC_NO)	LIKE  ?	AND	/*TO_CHAR(HDR.DOC_DATE,'DD/MM/YYYY') LIKE ?*/ TO_DATE (TO_CHAR (hdr.doc_date, 'dd/mm/yyyy'), 'dd/mm/yyyy')  BETWEEN TO_DATE (NVL (?, '01/01/1472'), 'dd/mm/yyyy')AND TO_DATE (NVL (?, '31/12/5000'), 'dd/mm/yyyy')  AND	HDR.FM_STORE_CODE LIKE ? AND HDR.TO_STORE_CODE LIKE	? AND UACB.USER_ID	= ?  AND HDR.FACILITY_ID= FMS.FACILITY_ID AND FMS.FACILITY_ID=? AND FMS.LANGUAGE_ID = TOS.LANGUAGE_ID AND FMS.LANGUAGE_ID = SY.LANGUAGE_ID AND TOS.LANGUAGE_ID = ? AND HDR.ITEM_CLASS_CODE = ITMCLS.ITEM_CLASS_CODE(+) AND ST.FACILITY_ID = HDR.FACILITY_ID");
			
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("FM_STORE_DESC");
			displayFields.add("TO_STORE_DESC");
			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("FM_STORE_CODE");
			displayFields.add("TO_STORE_CODE");
			displayFields.add("ITEM_CLASS_CODE");
			displayFields.add("ITEM_CLASS_DESC");
			displayFields.add("APPL_USER_NAME");
			displayFields.add("ADDED_DATE");  
			
			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			//chkFields.add(doc_date);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(fm_store);
			chkFields.add(to_store);
			chkFields.add(CommonBean.getLoginById());
			chkFields.add(CommonBean.getLoginFacilityId());
			chkFields.add(language_id);
			

			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
		

			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
						if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
	%>
			<table cellpadding=0 cellspacing=0 width="100%" align=center>
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
					<th width='125'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.FromStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.ToStore.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
					<th width='260'><fmt:message key="Common.createddate.label" bundle="${common_labels}"/></th>
                </tr>		
   		<%
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0)
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%
				records=(ArrayList) result.get(recCount);
		
		%>
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(0)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(1)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(2),"DMY","en",locale)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(3)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(4)%></td>
				<td class='NODISPLAY'><%=records.get(5)%></td>
				<td class='NODISPLAY'><%=records.get(6)%></td>
				<td class='NODISPLAY'><%=records.get(8)%></td>
				<td class='NODISPLAY'><%=records.get(9)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=((String)records.get(10))%></td> 
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(11),"DMYHMS","en",locale)%></td>
			</tr>
		<%	}		%>
		</table>
		<!--
		* @Name - Priya
		* @Date - 21/12/2009
		* @Inc# - IN017084
		* @Desc - To avoid the duplication records display in Modify mode
		 -->
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
		out.println(CommonBean.setForm (request ,"../../eST/jsp/IssueReturnQueryResult.jsp", searched));
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
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

