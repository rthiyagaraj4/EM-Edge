<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<script>
	function Modify(obj){
	var chart_result_type_desc	=obj.cells[0].innerText;
	var chart_result_type	=obj.cells[1].children[0].value;
	var org_code		=obj.cells[2].innerText;
document.location.href="../../eOR/jsp/ChartHorizontalAddModifyframe.jsp?mode=2&chart_result_type_desc="+escape(chart_result_type_desc)+"&chart_result_type="+escape(chart_result_type)+"&org_code="+escape(org_code)+"&function_id="+parent.function_id;

}
</script>

<html>
	<head>
		<title></title>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

		<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>

<!-- onMouseDown="CodeArrest()"  onKeyDown="lockKey()" -->
<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
<%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	//String bean_id				= "or_organism" ;
	//String bean_name			= "eOR.ChartHorizontalBean";

    /* Required while Selecting sql and Formatting display*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;



	//Search Criteria's from Query Criteria page
	String chart_result_type				=
	CommonBean.checkForNull(request.getParameter("chart_result_type"));
	String org_code				=
	CommonBean.checkForNull(request.getParameter("org_code"));
	String org_long_desc				=	CommonBean.checkForNull(request.getParameter("long_desc"));
	String eff_status						=
	CommonBean.checkForNull(request.getParameter("eff_status"));
	
//	String ord[]				=request.getParameterValues("orderbycolumns");
	boolean searched			=request.getParameter("searched") == null?false : true  ;

	String sql = OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_HORIZONTAL_RESULT_SELECT");


try{
	String classvalue			= "";

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData",sql);


	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();


	displayFields.add("CHART_RESULT_TYPE_DESC");
	displayFields.add("CHART_RESULT_TYPE");
	displayFields.add("CHART_HORIZ_CODE");
	displayFields.add("LONG_DESC");
	displayFields.add("SHORT_DESC");
	displayFields.add("SEQ_NO");
	displayFields.add("EFF_STATUS");

//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	if(chart_result_type.trim().equals(""))	chart_result_type = "";
	chkFields.add( chart_result_type.trim()+"%");
	chkFields.add( org_code +"%");
	chkFields.add( org_long_desc +"%");
	chkFields.add( eff_status+"%");


	// Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if((result.size()>=2) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		// For display the previous/next link
	     out.println(result.get(1));

	%>
		</td></tr>
		</table>

		<table  width="100%">
		<td class='COLUMNHEADER' align="left"><fmt:message key="eOR.resultmatrix.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' align="left"><fmt:message key="eOR.MatrixColumnCode.label" bundle="${or_labels}"/></td>
		<td class='COLUMNHEADER' align="left"><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' align="left"><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER' align="left"><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'  align="left"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>

		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
	%>
			<tr onClick="Modify(this);" >
	<%

		  String link_columns = "1,3";

		  records=(ArrayList) result.get( recCount );
		  String str="";

		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<a class='gridLink' href='#'><%=(String)records.get(colCount)%></a></td>
			<%}else{

				if(colCount==1){%>
					 <td class="<%=classvalue%>" onclick="disableClick(event);" style="display:none">
					<INPUT TYPE="hidden" value=<%=(String)records.get( colCount)%>></td>
				<%
					continue ;
				}
					str = (String)records.get(colCount);
					if(colCount == 6 )//to display Nurse Colllect
					str=eHISFormatter.chkReturn("E",str,enableGif,disableGif);
				%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
			  <%}//with out hyper link
		 }//loop for all tds%>

		</tr>
		<%}//loop for all records%>
	</table>
	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/ChartHorizontalQueryResult.jsp", searched));
} catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
}
%>
</body>
</html>

