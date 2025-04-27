<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eST.Common.*, eST.ScheduleAutoRequestBean " contentType="text/html;charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<body>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");

		
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/ScheduleAutoRequest.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String schdule_code			=	CommonBean.checkForNull(request.getParameter("schdule_code"),"%");
	String schdule_desc			=	CommonBean.checkForNull(request.getParameter("schdule_desc"),"%");
	String requisition_by_store =	CommonBean.checkForNull(request.getParameter("requisition_by_store"),"%");
	String requisition_on_store =	CommonBean.checkForNull(request.getParameter("requisition_on_store"),"%");
	String status				=	request.getParameter("status");
	if(status.equals(" "))
	status="%";
	boolean searched			=   (request.getParameter("searched") == null) ?false:true;
	String classvalue			=	"";
	HashMap sqlMap				=	new HashMap();
	HashMap funcMap				=	new HashMap();
	ArrayList displayFields		=	new ArrayList();
	ArrayList chkFields			=	new ArrayList();
	ArrayList result			=	new ArrayList();
	ArrayList records			=	new ArrayList();
	
try{
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_SCHDULE_AUTO_REQUEST_HDR_QUERY"));
	
		displayFields.add("schdule_code");
		displayFields.add("schdule_desc");
		displayFields.add("req_by_store_desc");
		displayFields.add("req_on_store_desc");
		displayFields.add("eff_status");

		chkFields.add((String) session.getValue( "facility_id" ));
		chkFields.add( schdule_code+"%");
		chkFields.add( schdule_desc+"%");
		chkFields.add( requisition_by_store);
		chkFields.add( requisition_on_store);
		chkFields.add( status);
		chkFields.add( locale);
		chkFields.add( locale);

		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );

		result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
		
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
			<th align="center" ><fmt:message key="eST.ScheduleCode.label" bundle="${st_labels}"/></th>
			<th align="center" ><fmt:message key="eST.SchduleDescription.label" bundle="${st_labels}"/></th>
			<th align="center" ><fmt:message key="Common.ReqByStore.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.ReqOnStore.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%
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
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" >
						<font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
							if(colCount == 4) {
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							
							else {
								out.println(">"+(String)((records.get( colCount ))==null?"&nbsp;" :records.get( colCount )));
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
	out.println(CommonBean.setForm ( request ,"../../eST/jsp/ScheduleAutoRequestQueryResult.jsp", searched) );
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

