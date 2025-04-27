<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
31/08/2015	IN056823		Ramesh G										The Owner Store users access the newly introduced  'Return Vendor Loan' functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.util.HashMap,java.util.ArrayList, java.util.Properties, eSS.*,java.sql.* " contentType="text/html;charset=UTF-8"%> 
<%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
			request.setCharacterEncoding("UTF-8");
			String locale		=	(String)session.getAttribute("LOCALE");
			String sStyle		=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/VendorLoanReturn.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	String doc_type_code			=		request.getParameter("doc_type_code");
	String doc_no					=		request.getParameter("doc_no");
	String from_date				=		request.getParameter("from_date");
	String to_date					=		request.getParameter("to_date");
	String return_from_store_code		=		request.getParameter("return_from_store_code");
	String return_to_vendor_code		=		request.getParameter("return_to_vendor_code");
	String entry_completed_yn		=		request.getParameter("entry_completed_yn");
	String request_type				=		request.getParameter("request_type");
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	String classvalue				=		"";
	try{

		doc_type_code				=		CommonBean.checkForNull(doc_type_code,"%");
		doc_no						=		CommonBean.checkForNull(doc_no,"%");
		if(!(locale.equals("en")))
		{
					 from_date		=		com.ehis.util.DateUtils.convertDate(from_date,"DMY",locale,"en");
					 to_date		=		com.ehis.util.DateUtils.convertDate(to_date,"DMY",locale,"en");
								 
		}
		from_date					=		CommonBean.checkForNull(from_date);
		to_date						=		CommonBean.checkForNull(to_date);
		return_from_store_code			=		CommonBean.checkForNull(return_from_store_code,"%"	);
		return_to_vendor_code			=		CommonBean.checkForNull(return_to_vendor_code,"%"	);
		request_type			=		CommonBean.checkForNull(request_type,"%"	);
		
		HashMap sqlMap				=		new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_EXT_RETURN_HDR_QUERY_RESULT") );
		String sqlQuery = (String) sqlMap.get("sqlData");
		System.out.println("Generated SQL Query: " + sqlQuery);
		HashMap funcMap				=		new HashMap();
		ArrayList displayFields		=		new ArrayList();

		
	
		displayFields.add("DOC_NO");
		displayFields.add("DOC_TYPE_DESC");
		displayFields.add("DOC_DATE");
		displayFields.add("ADDED_BY_ID");		
		displayFields.add("FROM_STORE_DESC");
		displayFields.add("VENDOR_DESC");
		displayFields.add("REQUEST_TYPE");
		displayFields.add("ENTRY_COMPLETED_YN");
		displayFields.add("DOC_TYPE_CODE");

		ArrayList chkFields = new ArrayList();

		chkFields.add(locale);
		chkFields.add(locale);
		chkFields.add(locale);
		chkFields.add(CommonBean.getLoginById());
		chkFields.add((String)session.getAttribute("facility_id"));
		chkFields.add(doc_type_code);
		chkFields.add(doc_no);
		chkFields.add(from_date);
		chkFields.add(to_date);
		chkFields.add(return_from_store_code);
		chkFields.add(return_to_vendor_code);
		chkFields.add(request_type);
		chkFields.add(entry_completed_yn);
		

		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		System.out.println("results "+result);
		
		if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))){
		%>
			<table cellpadding=0 cellspacing=0 width="100%" align="center">
			<tr>
				<td width="80%" class="white">&nbsp;</td>
				<td width="20%" class="white">&nbsp;
				<%
					out.println(result.get(1));
				%>
				</td>
			</tr>
			</table>
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
				<th><fmt:message key="eSS.DocNo.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="Common.DocType.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eSS.DocDate.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.Requestedby.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.RequestedbyStore.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.RequestedonVendor.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.RequestType.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.EntryCompleted.label" bundle="${ss_labels}"/></th>
				
		<%
			ArrayList records=new ArrayList();
			
			for(int recCount=2; recCount<result.size(); recCount++) {				
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr onClick="Modify(this);" >
		<%
				String link_columns = "1";		
				records					=	(ArrayList) result.get( recCount );				
				String doc_date_disp	=	(String)records.get(2);				
				if(doc_date_disp==null)doc_date_disp="";

				if(!(locale.equals("en")))
				{
					 doc_date_disp		=	com.ehis.util.DateUtils.convertDate(doc_date_disp,"DMY","en",locale);
					 if(doc_date_disp==null)doc_date_disp="";
					 
				}
				 
				for(int colCount=0; colCount<records.size(); colCount++){
					if(colCount==8){
						%>
						<td class='NODISPLAY'><%=(String)records.get( colCount )%></td>	
						<%
						continue;
					}else if(colCount==2){
						%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"><%=doc_date_disp%></td>	
						<%
						continue;
					}
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);" align="<%=(colCount==1)?"right":(((colCount==2)||(colCount==3)||(colCount==7)||(colCount==8))?"center":"")%>"
						<%
							if(colCount == 7) {
								if( ((String)records.get( colCount )).equals("Y"))
									out.println("><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+(String)records.get( colCount ));
							}
						%>   
							
						</td>
		<%
						}
					}
		%>
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
				self.location.href="../../eCommon/html/blank.html";
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/VendorLoanRequestQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		// out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

