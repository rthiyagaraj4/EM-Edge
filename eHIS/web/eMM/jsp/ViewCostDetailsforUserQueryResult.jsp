<!DOCTYPE html>
<%@page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>

<%@	include file="../../eCommon/jsp/CommonBean.jsp" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head> 
		<title></title>
		<%
		
		request.setCharacterEncoding("UTF-8");
		//String locale			= (String)session.getAttribute("LOCALE");
	
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eMM/js/MmCommon.js"></script>
		<script language="Javascript" src="../../eMM/js/ViewCostDetailsforUser.js"> </script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body>
<%
	
	String  user_id					=		request.getParameter( "user_id" ) ;
	String  user_name				=		request.getParameter( "user_name" ) ;
	String  view_cost_details		=		request.getParameter( "view_cost_details" ) ;

//	String  ord[]					=		 request.getParameterValues("orderbycolumns");
	boolean searched				=		(request.getParameter("searched") == null) ?false:true;
	
try{
	String classvalue				=		"";
//	String bean_id					=		"viewCostDetailsforUser" ;
//	String bean_name				=		"eMM.ViewCostDetailsforUser";
	
	//ViewCostDetailsforUser bean			=	(ViewCostDetailsforUser)getBeanObject( bean_id,bean_name,request ) ;

	user_id							=		CommonBean.checkForNull( user_id )+'%';
	user_name						=		CommonBean.checkForNull( user_name )+'%';
	view_cost_details				=		CommonBean.checkForNull( view_cost_details );
		

	HashMap sqlMap					=		new HashMap();
	HashMap funcMap					=		new HashMap();
	ArrayList displayFields			=		new ArrayList();
	ArrayList chkFields				=		new ArrayList();

	sqlMap.put( "sqlData", MmRepository.getMmKeyValue("SQL_MM_VIEW_COST_QUERYCRITERIA"));

	displayFields.add( "APPL_USER_ID" );
	displayFields.add( "APPL_USER_NAME"	);
	displayFields.add( "VIEW_COST_YN" );
	

	
	chkFields.add(user_id);
	chkFields.add(user_name);
	chkFields.add(view_cost_details);
	//chkFields.add(locale);

	
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );


	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//out.println((String) result.get(0));
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align=center>
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
		<th><fmt:message key="Common.userid.label" bundle="${common_labels}"/></th> 
		<th><fmt:message key="Common.username.label" bundle="${common_labels}"/></th> 
		<th ><fmt:message key="eST.ViewCostDetails.label" bundle="${st_labels}"/> </th>
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

			String link_columns			=		"1";

			records=(ArrayList) result.get( recCount );
			
			for(int colCount=0; colCount<records.size(); colCount++){
				
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){
	%>
					<td class="<%=classvalue%>" onmouseover="changeCursor(this);" ><font class='HYPERLINK'>  <%=(String)records.get( colCount )%>    </font></td>
				<%
				}else{
						%>
				
					<%
							if(colCount == 2) {
						%>
								<td class="<%=classvalue%>" onclick="disableClick(event);" align='center' >
								<font style='display:none'><%=records.get(colCount)%></font>
								
							<%	if( ((String)records.get( colCount )).equals("Y")){
									
									out.println("<img src=\'../../eCommon/images/enabled.gif\'></img>");}
								else{
								
									out.println("<img src=\'../../eCommon/images/disabled.gif\'></img>");}
							}
						else 
							{%>
								<td class='<%=classvalue%>' onclick='disableClick(event);'>

							<%	out.println((String)records.get( colCount ));
							}

					%> </td>
					<%
					}
				}
				%>
			</tr>
		<%}	%>
		</table>
		<%
			out.flush();
		} else{
		%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script> 
		<%
		}
		out.println(CommonBean.setForm ( request ,"../../eMM/jsp/ViewCostDetailsforUserQueryResult.jsp", searched) );
	} catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0184
}
%>
</body>
</html>

