<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %> 
 <%@include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
<head>
	 <%
	 request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/GroupForStore.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%
	String store_code		= request.getParameter("store_code");
	String store_desc		= request.getParameter("store_desc");
	String group_code		= request.getParameter("group_code");
	String group_desc		= request.getParameter("group_desc");


	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";

	try{

		store_code		 = CommonBean.checkForNull(store_code		)+"%";
		store_desc		 = CommonBean.checkForNull(store_desc		)+"%";
		group_code		 = CommonBean.checkForNull(group_code		)+"%";
		group_desc		 = CommonBean.checkForNull(group_desc		)+"%";

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_FOR_STORE_QUERY_RESULT") );
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("store_code");
		displayFields.add("store_desc");
		displayFields.add("group_code");
		displayFields.add("group_desc");
		displayFields.add("min_qty");
		displayFields.add("reorder_qty");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add((String)session.getAttribute("facility_id"));
		chkFields.add(store_code);
		chkFields.add(store_desc);
		chkFields.add(group_code);
		chkFields.add(group_desc);
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
				<th><fmt:message key="eSS.StoreCode.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.StoreDescription.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.GroupDescription.label" bundle="${ss_labels}"/></th>
			<!--	<th><fmt:message key="eSS.MinQty.label" bundle="${ss_labels}"/></th> -->
				<th><fmt:message key="eSS.ReorderLevel.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.ReorderQuantity.label" bundle="${ss_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYEVEN" ;
				else
					classvalue = "QRYODD" ;
		%>
				<tr>
		<%

				String link_columns = "1000";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" ><font class=''><%=(String)records.get( colCount )%></font></td>
		<%
					}else{
						if(colCount!=4 && colCount!=5){
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
							{
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
								
							}
						%></td>
		<%
						}else{
						%>
						<td class="<%=classvalue%>" style="TEXT-ALIGN:right" onclick="disableClick(event);"
						<%
							{
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
								
							}
						%></td>
						<%
						}
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/GroupForStoreQueryResult.jsp", searched) );
	}
	catch(Exception e) {
		out.print("Exception @ Result JSP :"+e.toString());
	}
%>
</body>
</html>

