<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>

<%@page import="java.util.*, eMM.*, eMM.Common.*,eCommon.Common.*,java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>

<html>
	<head> 
		<title></title>
<%
		
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String sStyle			=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eMM/js/MmCommon.js"></script>
		<script language="Javascript" src="../../eMM/js/ItemAnalysis.js"> </script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	//Search Criteria's from Query Criteria page
	String item_anal_code		=		request.getParameter( "item_anal_code" ) ;
	String short_desc			=		request.getParameter( "short_desc" ) ;
	String eff_status			=		request.getParameter( "nature" ) ;
	 
	//String ord[]				=		request.getParameterValues("orderbycolumns");
	boolean searched			=		(request.getParameter("searched") == null) ?false:true;
	
try{
	String classvalue			=		"";
//	String bean_id				=		"itemAnalysisBean" ;
//	String bean_name			=		"eMM.ItemAnalysisBean";
	
//	ItemAnalysisBean bean		=		(ItemAnalysisBean)mh.getBeanObject( bean_id, request, bean_name ) ;

	item_anal_code				=		CommonBean.checkForNull( item_anal_code )+'%';
	short_desc					=		CommonBean.checkForNull( short_desc )+'%';
	eff_status					=		CommonBean.checkForNull( eff_status );
		
	//Common parameters.
	HashMap sqlMap				=		new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData", MmRepository.getMmKeyValue("SQL_MM_ITEM_ANAL_QUERYCRIT"));


	//Function Parameters
	HashMap funcMap				=		new HashMap();

	//The fields are going to be display

	ArrayList displayFields		=		new ArrayList();

	displayFields.add( "item_anal_code" );
	displayFields.add( "long_desc"	);
	displayFields.add( "short_desc" );
	displayFields.add( "eff_status" );
	
	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields			=		new ArrayList();

	chkFields.add(item_anal_code);
	chkFields.add(short_desc);
	chkFields.add(eff_status);
	chkFields.add(locale);
	
	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	//out.println((String) result.get(0));
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align=center>
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
		<th><fmt:message key="eMM.ItemAnalysisCode.label" bundle="${mm_labels}"/></th><th ><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
	<%
		//Retriving the records from result arraylist
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
				}else{
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"
					<%
							if(colCount == 3) {
								//out.println(" align=\'center\'>");
								if( ((String)records.get( colCount )).equals("E"))
									out.println("align='center' ><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("align='center' ><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+(String)records.get(colCount ));
							}
				//	out.println((String)records.get( colCount ));
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
	} else{
	%>
		<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eMM/jsp/ItemAnalysisQueryResult.jsp", searched) );
} catch(Exception e) {
	// out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0184
}
%>
</body>
</html>

