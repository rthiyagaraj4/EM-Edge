<!DOCTYPE html>

<%-- JSP Page specific attributes start --%>
<%@page import="java.util.ArrayList,java.util.HashMap,eMM.StoreGroupBean" contentType="text/html;charset=UTF-8"%>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%-- Mandatory declarations end --%>
 
<html>
<head>
<%	 
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' ></link>		
<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonResult.js"></script>
<script language="Javascript" src="../../eMM/js/MmCommon.js"></script>
<script language="Javascript" src="../../eMM/js/StoreGroup.js"> </script>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body>
<%
	
	String store_group_code	= CommonBean.checkForNull((String)request.getParameter( "store_group_code" ))+'%' ;
	String store_group_desc	= CommonBean.checkForNull((String)request.getParameter( "store_group_desc" ))+'%' ;
	String store_group_nature	= CommonBean.checkForNull((String)request.getParameter( "store_group_nature" ))+'%' ;
	boolean searched	=(request.getParameter("searched") == null) ?false:true;
	
try{
	
	String classvalue = "";
	
	HashMap sqlMap = new HashMap();		
	sqlMap.put( "sqlData" , "SELECT STORE_GROUP_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS FROM MM_STORE_GROUP_LANG_VW WHERE UPPER(STORE_GROUP_CODE) LIKE UPPER(?) AND (UPPER(LONG_DESC) LIKE UPPER(?) OR UPPER(SHORT_DESC) LIKE UPPER(?)) AND UPPER(EFF_STATUS) LIKE UPPER(?) AND LANGUAGE_ID = ?");
	HashMap funcMap = new HashMap();
	ArrayList displayFields = new ArrayList();

	displayFields.add( "STORE_GROUP_CODE" );
	displayFields.add( "LONG_DESC"	);
	displayFields.add( "SHORT_DESC" );
	displayFields.add( "EFF_STATUS" );

	ArrayList chkFields = new ArrayList();

	chkFields.add(store_group_code);
	chkFields.add(store_group_desc);
	chkFields.add(store_group_desc);
	chkFields.add(store_group_nature);
	chkFields.add(locale);				 
	

	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align=center >
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align=center>
		<th><fmt:message key="eMM.StoreGroupCode.label" bundle="${mm_labels}"/></th>
		<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/> </th>
		<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/> </th>
		<th> <fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>   		
	
   				
			
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
				}else{
	%>
					<td class="<%=classvalue%>" onclick="disableClick(event);"
					<%
							if(colCount == 3) {
								if( ((String)records.get( colCount )).equals("E"))
									out.println("align='center' ><img src=\'../../eCommon/images/enabled.gif\'></img>");
								else
									out.println("align='center' ><img src=\'../../eCommon/images/disabled.gif\'></img>");
							}
							else {
								out.println(">"+CommonBean.checkForNull((String)records.get( colCount ),"&nbsp"));
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
	} else{
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);
		</script> 
	<%
	}
	out.println(CommonBean.setForm ( request ,"../../eMM/jsp/StoreGroupQueryResult.jsp", searched));
} catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());
	e.printStackTrace(); // COMMON-ICN-0184
}
%>
</body>
</html>

