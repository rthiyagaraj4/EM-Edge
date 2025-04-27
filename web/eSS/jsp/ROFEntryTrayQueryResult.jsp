<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eSS.Common.*, eSS.* "  contentType="text/html;charset=UTF-8"%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html>
<head>
<%
		request.setCharacterEncoding("UTF-8");
		String sStyle		=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/ROFEntry.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown="CodeArrest()">
<%
	String group_code			=		request.getParameter("group_code");
	String tray_no				=		request.getParameter("tray_no");
	String bin_location_code	=		request.getParameter("bin_location_code");
	String wash_yn				=		request.getParameter("wash_yn");
	String pack_yn				=		request.getParameter("pack_yn");
	String sterilize_yn			=		request.getParameter("sterilize_yn");

	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	String classvalue			=		"";
	try{
		group_code				=		CommonBean.checkForNull(group_code,"%");
		tray_no					=		CommonBean.checkForNull(tray_no, "%");
		bin_location_code		=		CommonBean.checkForNull(bin_location_code, "%");

		HashMap sqlMap			=		new HashMap();
		sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_RETURN_DTL_QUERY_RESULT_FOR_ROF_ENTRY") );

		HashMap funcMap			=		new HashMap();

		ArrayList displayFields =		new ArrayList();

		displayFields.add("tray_no");
		displayFields.add("group_desc");
		displayFields.add("bin_desc");

		ArrayList chkFields		=		new ArrayList();

		chkFields.add(group_code);
		chkFields.add(tray_no);
		chkFields.add(bin_location_code);
		chkFields.add(sterilize_yn);
		chkFields.add(wash_yn);
		chkFields.add(pack_yn);

		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		ArrayList result		=		(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

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
					<th><fmt:message key="eSS.TrayNo.label" bundle="${ss_labels}"/></th>
					<th><fmt:message key="Common.Group.label" bundle="${common_labels}"/></th>
					<th><fmt:message key="eSS.BinLocation.label" bundle="${ss_labels}"/></th>
		<%
			ArrayList records=new ArrayList();
			for(int recCount=2; recCount<result.size(); recCount++) {
				if ( recCount % 2 == 0 )
					classvalue = "QRYODD" ;
				else
					classvalue = "QRYEVEN" ;
		%>
				<tr onClick="returnTrayNo(this);" >
		<%

				String link_columns = "1";
				records=(ArrayList) result.get( recCount );
				for(int colCount=0; colCount<records.size(); colCount++){
					if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
		%>
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);"  ><font class='HYPERLINK'><%=(String)records.get( colCount )%></font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);" align="<%=(colCount==4)?"center":"left"%>"
						<%
								out.print(">"+(String)records.get( colCount ));
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/ROFEntryTrayQueryResult.jsp", searched) );
	}
	catch(Exception e) {
// 		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
%>
</body>
</html>

