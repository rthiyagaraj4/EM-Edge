<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eST.Common.*, eST.* " contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%@ include file="../../eCommon/jsp/CommonBean.jsp"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		
		
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' 
type='text/css' ></link>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eST/js/StCommon.js"></script>
	<script language="javascript" src="../../eST/js/RepackingGroup.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<body>
<%
	
	String repacking_group_code = request.getParameter("repacking_group_code");
	String long_desc = request.getParameter("long_desc");
	String eff_status = request.getParameter("eff_status");
//	String orderBy[] = request.getParameterValues("orderbycolumns");
	boolean searched = (request.getParameter("searched") == null) ?false:true;
	String classvalue = "";
	//String bean_id = "serviceLocationBean" ;
	//String bean_name = "eSS.ServiceLocationBean";
	HashMap sqlMap				=		new HashMap();
	HashMap funcMap				=		new HashMap();
	ArrayList displayFields		=		new ArrayList();
	ArrayList chkFields			=		new ArrayList();
	ArrayList result			=		new ArrayList();
	ArrayList records			=		new ArrayList();

	try{
		//ServiceLocationBean bean = (ServiceLocationBean) mh.getBeanObject(bean_id, request, bean_name);
		repacking_group_code = CommonBean.checkForNull(repacking_group_code)+"%";
		long_desc = CommonBean.checkForNull(long_desc)+"%";
		eff_status = CommonBean.checkForNull(eff_status);
		sqlMap.put("sqlData", eST.Common.StRepository.getStKeyValue("SQL_ST_REPACKING_GROUP_QUERY_RESULT"));
		
		displayFields.add("repacking_group_code");
		displayFields.add("long_desc");
		displayFields.add("short_desc");
		displayFields.add("auto_gen_batch_yn");
		displayFields.add("batch_id_series");
		displayFields.add("next_batch_id");
		displayFields.add("eff_status");
 
		chkFields.add( repacking_group_code);
		chkFields.add( long_desc);
		chkFields.add( eff_status);
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
			<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" >
				<th align="center" ><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
			<th align="center" ><fmt:message key="eST.GenerateBatch.label" bundle="${st_labels}"/></th>
			<th align="center" ><fmt:message key="eST.BatchSeries.label" bundle="${st_labels}"/></th>
			<th align="center" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></th>
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
						<td class="<%=classvalue%>" onmouseover="this.style.cursor='pointer'" ><font class='HYPERLINK'>  
				<%=(String)records.get(colCount)%>   
			</font></td>
		<%
					}else{
		%>
						<td class="<%=classvalue%>" onclick="disableClick(event);"
						<%
						 //if gif has to be provided
							
							if(colCount == 6) {
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

							}
							else if(colCount == 3 ){
								out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("Y"))
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");

							}
							else {
								out.println(">"+(String)((records.get( colCount ))==null?"&nbsp;" :records.get( colCount )));
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
				history.go(-1);
			</script>
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eST/jsp/RepackingGroupQueryResult.jsp", searched) );
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

