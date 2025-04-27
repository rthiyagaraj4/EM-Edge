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
<%
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<html>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/AlternateGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%
	String group_code				= request.getParameter("group_code");
	String group_desc				= request.getParameter("group_desc");
	String alternate_group_code		= request.getParameter("alternate_group_code");
	String alternate_group_desc		= request.getParameter("alternate_group_desc");

	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";

	try{

		alternate_group_code = CommonBean.checkForNull(alternate_group_code		)+"%";
		alternate_group_desc = CommonBean.checkForNull(alternate_group_desc		)+"%";
		group_code			 = CommonBean.checkForNull(group_code		)+"%";
		group_desc			 = CommonBean.checkForNull(group_desc		)+"%";

		HashMap sqlMap = new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_ALTERNATE_GROUP_QUERY_RESULT") );
		HashMap funcMap = new HashMap();

		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("group_code");
		displayFields.add("group_desc");
		displayFields.add("alternate_group_code");
		displayFields.add("alternate_group_desc");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add(group_code);
		chkFields.add(group_desc);
		chkFields.add(alternate_group_code);
		chkFields.add(alternate_group_desc);
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
				<th><fmt:message key="eSS.GroupCode.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.GroupDescription.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.AlternateGroupCode.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.AlternateGroupDescription.label" bundle="${ss_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr  >
		<%

				String link_columns = "1000";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>"  ><%=(String)records.get( colCount )%></font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
							{
								out.println(">"+(String)records.get( colCount ));
							}
						%></td>
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/AlternateGroupQueryResult.jsp", searched) );
	}
	catch(Exception e) {
// 		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

