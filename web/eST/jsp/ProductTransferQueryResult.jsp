<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
04/02/2016	IN057461		Badmavathi B									Query page for Product Transfer/Repackaging 
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.HashMap,java.util.ArrayList,java.util.Properties,eST.*,java.lang.* " contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=	(String)session.getAttribute("LOCALE");
		String user_name		=  (String) session.getValue( "login_user" ) ;
		String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language='javascript' src='../../eST/js/StCommon.js'></script>
		<script language="javascript" src="../../eST/js/ProductTransfer.js"></script>
	 
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body>
	<%
		String doc_type_code			=		request.getParameter("doc_type_code");
		String doc_no					=		request.getParameter("doc_no");
		String from_doc_date			=		request.getParameter("from_doc_date");
		from_doc_date					=		com.ehis.util.DateUtils.convertDate(from_doc_date,"DMY",locale,"en");
		String to_doc_date				=		request.getParameter("to_doc_date");
		to_doc_date						=		com.ehis.util.DateUtils.convertDate(to_doc_date,"DMY",locale,"en");
		String store_code				=		request.getParameter("request_on_store");
		String prep_loc					=		request.getParameter("prep_loc");
		String language_id				=		request.getParameter("language_id");
		boolean searched				=		(request.getParameter("searched") == null) ?false:true;
		String classvalue				=		"";
		String doc_date_disp			=		"";
		HashMap sqlMap					=		new HashMap();
		HashMap funcMap					=		new HashMap();
		ArrayList displayFields			=		new ArrayList();
		ArrayList chkFields				=		new ArrayList();
		ArrayList result				=		new ArrayList();
		ArrayList records				=		new ArrayList();
		

		try{
			CommonBean.setLoginFacilityId((String) session.getValue("facility_id"));
			doc_type_code				=		CommonBean.checkForNull(doc_type_code,"%");
			doc_no						=		CommonBean.checkForNull(doc_no,"%");
			store_code					=		CommonBean.checkForNull(store_code,"%");
			from_doc_date				=		CommonBean.checkForNull(from_doc_date,"");
			to_doc_date					=		CommonBean.checkForNull(to_doc_date,"");
			prep_loc					=		CommonBean.checkForNull(prep_loc,"%");

			sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_PROD_TRANS_HDR_QUERY_RESULT"));
			

			displayFields.add("DOC_TYPE_CODE");
			displayFields.add("DOC_TYPE_DESC");
			displayFields.add("DOC_NO");
			displayFields.add("DOC_DATE");
			displayFields.add("STORE_CODE");
			displayFields.add("STORE_DESC");
			displayFields.add("DOC_REF");
			displayFields.add("PREP_DESC");
			displayFields.add("ADDED_BY");
			displayFields.add("ADDED_DATE");

			chkFields.add(doc_type_code);
			chkFields.add(doc_no);
			chkFields.add(store_code);
			chkFields.add(prep_loc);
			chkFields.add(from_doc_date);
			chkFields.add(to_doc_date);
			chkFields.add(user_name);
			chkFields.add(language_id);
			chkFields.add((String) session.getValue("facility_id"));
			
			// Adding function related array list into the HashMap
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) {
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
					<th width='10%'><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
					<th width='10%'><fmt:message key="Common.DocNo.label" bundle="${common_labels}"/></th>
					<th width='10%'><fmt:message key="Common.DocDate.label" bundle="${common_labels}"/></th>
					<th width='15%'><fmt:message key="Common.Store.label" bundle="${common_labels}"/></th>
					<th width='15%'><fmt:message key="Common.PrepareLocation.label" bundle="${common_labels}"/></th>
					<th width='15%'><fmt:message key="Common.Createdby.label" bundle="${common_labels}"/></th>
					<th width='15%'><fmt:message key="Common.createddate.label" bundle="${common_labels}"/></th>
				</tr>		
		<%
			
			for(int recCount=2; recCount<result.size(); recCount++) {
				if (recCount % 2 == 0) {
					classvalue = "QRYEVEN" ;
				}
				else {
					classvalue = "QRYODD" ;
				}

				records=(ArrayList) result.get(recCount);
				doc_date_disp = (String)records.get(3);
				if(!locale.equals("en"))
				{
					doc_date_disp=com.ehis.util.DateUtils.convertDate(doc_date_disp,"DMY","en",locale);
				}

		%>
				<!--<tr onClick="Modify(this,'<%=records.get(0)%>','<%=records.get(4)%>','','<%=locale%>');" > Added doc_ref for printing in query mode-->
				<tr onClick="Modify(this,'<%=records.get(0)%>','<%=records.get(4)%>','<%=CommonBean.checkForNull((String)records.get(6),"")%>','<%=locale%>');" >
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get(1)%></font></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(2)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=doc_date_disp%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=records.get(5)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=CommonBean.checkForNull((String)records.get(7),"&nbsp;")%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get(8)%></td>
				<td class="<%=classvalue%>" onclick="disableClick(event);"><%=com.ehis.util.DateUtils.convertDate((String)records.get(9),"DMYHMS","en",locale)%></td>
			</tr>
		<%
			

			}
		%>
		</table>
		<!--
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
		else {
		%>
			<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				document.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm (request ,"../../eST/jsp/ProductTransferQueryResult.jsp", searched));
	}
	catch(Exception e) {
		e.printStackTrace();
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

