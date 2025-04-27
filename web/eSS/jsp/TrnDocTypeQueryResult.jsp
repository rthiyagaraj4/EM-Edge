<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
	<%@ page import="java.util.*, eSS.Common.*, eSS.* " contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %> 

<html>
<head>

<%
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link> 
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/TrnDocType.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()">
<%
	String doc_type_code	=	request.getParameter("doc_type_code");
	String doc_type_desc	=	request.getParameter("doc_type_desc");
	String trn_type			=	request.getParameter("trn_type");
	String trn_type_desc	=	request.getParameter("trn_type_desc");


	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";

	try{

		doc_type_code	=CommonBean.checkForNull(doc_type_code)+"%";;
		doc_type_desc	=CommonBean.checkForNull(doc_type_desc)+"%";;
		trn_type		=CommonBean.checkForNull(trn_type	)+"%";;
		trn_type_desc	=CommonBean.checkForNull(trn_type_desc)+"%";;

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_TRN_DOC_TYPE_QUERY_RESULT"));
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("doc_type_code");
		displayFields.add("doc_desc");
		displayFields.add("trn_type");
		displayFields.add("trn_desc");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( (String)session.getAttribute("facility_id"));
		chkFields.add( doc_type_code);
		chkFields.add( doc_type_desc);
		chkFields.add( trn_type		);
		chkFields.add( trn_type_desc);
		chkFields.add( locale);

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
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
				<th><fmt:message key="eSS.DocTypeCode.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.DocTypeDescription.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.TRNType.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.TRNTypeDescription.label" bundle="${ss_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr onClick="Modify(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
		<%
					}
					else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get( colCount )%></td>
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
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/TrnDocTypeQueryResult.jsp", searched) );
	}
	catch(Exception e) {
// 		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

