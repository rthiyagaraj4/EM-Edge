<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
  
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- Mandatory declarations start --%>
<%@ page import ="java.util.ArrayList,eSS.*,java.util.*,java.util.HashMap,java.util.ArrayList,java.lang.*,webbeans.eCommon.*,java.sql.*, eCommon.Common.*" %>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
04/07/2021		TFS19249		 Shazana		ML-MMOH-CRF-1661-US001  
---------------------------------------------------------------------------------------------------------------
*/ %>
<%-- Mandatory declarations end --%>

<html>
<head>
<%
			String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			request.setCharacterEncoding("UTF-8");
            String locale			= (String)session.getAttribute("LOCALE");
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eSS/js/SsCommon.js"></script>
	<script language="javascript" src="../../eSS/js/Group.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body onMouseDown='CodeArrest();'>
<%
	String group_code			= request.getParameter("group_code");
	String long_desc			= request.getParameter("long_desc");
	String group_type			= request.getParameter("group_type");
	String surgery_type			= request.getParameter("surgery_type");
	String usage_type			= request.getParameter("usage_type");
	String non_returnable_yn	= request.getParameter("non_returnable_yn");
	String eff_status			= request.getParameter("eff_status");


	boolean searched			= (request.getParameter("searched") == null) ?false:true;
	String classvalue			= "";
	Connection con			= null;//MMOH-CRF-1661 START
	boolean linen_applicable_yn = false;  
	try{
		con				= ConnectionManager.getConnection(request);
		linen_applicable_yn = eCommon.Common.CommonBean.isSiteSpecific(con,"SS", "SS_GROUP_TYPE_LINEN"); //END  
		group_code				= CommonBean.checkForNull(group_code)+"%";
		long_desc				= CommonBean.checkForNull(long_desc)+"%";
		surgery_type			= CommonBean.checkForNull(surgery_type)+"%";
		usage_type				= CommonBean.checkForNull(usage_type)+"%";
		group_type				= CommonBean.checkForNull(group_type)+"%";
		non_returnable_yn		= CommonBean.checkForNull(non_returnable_yn);
		eff_status				= CommonBean.checkForNull(eff_status);

		HashMap sqlMap = new HashMap();
		if(linen_applicable_yn){//mmoh-crf-1661
			sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_QUERY_RESULT_1") ); 
		}else{
			sqlMap.put("sqlData", eSS.Common.SsRepository.getSsKeyValue("SQL_SS_GROUP_QUERY_RESULT") );
		}
		

		
		HashMap funcMap = new HashMap();
	
		//The fields are going to be display
		ArrayList displayFields = new ArrayList();

		displayFields.add("group_code");
		displayFields.add("short_desc");
		displayFields.add("group_type");
		displayFields.add("surgery_type");
		displayFields.add("usage_type");
		displayFields.add("non_returnable_yn");
		displayFields.add("eff_status");

		//The fields are going to be in where condition * should match with the query
		ArrayList chkFields = new ArrayList();
		chkFields.add( group_code);
		chkFields.add( long_desc);
		chkFields.add( eff_status);
		chkFields.add( non_returnable_yn);
		chkFields.add( group_type);
		chkFields.add( surgery_type);
		chkFields.add( usage_type);
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
				<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
				<th><fmt:message key="eSS.GroupType.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.Surgery.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.Usage.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="eSS.Non-returnable.label" bundle="${ss_labels}"/></th>
				<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
						<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'><%=CommonBean.checkForNull((String)records.get(colCount),"&nbsp;")%></font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
						 //if gif has to be provided
							if(colCount == 6  ) {
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else if(colCount == 5 )
							{
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
	
							else {
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp;"));
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
		out.println(CommonBean.setForm ( request ,"../../eSS/jsp/GroupQueryResult.jsp", searched) );
	}
	catch(Exception e) {
// 		out.print("Exception @ Result JSP :"+e.toString());
		e.printStackTrace(); // COMMON-ICN-0185
	}
	finally{
		if(con != null)
			ConnectionManager.returnConnection(con,request);//END
	}
%>
</body>
</html>

