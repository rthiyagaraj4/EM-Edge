<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>


<HTML>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
	<Script Language="JavaScript" src="../../eCommon/js/CommonResult.js"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<script>
	function Modify(obj,enable_temp,service_code){
		
		var chart_result_type		= obj.cells[0].innerText;
		var chart_result_type_desc	= obj.cells[1].innerText;
		var chart_horzi_desc		= obj.cells[2].innerText;
		var chart_no_columns		= obj.cells[3].innerText;
		var chart_vert_desc			= obj.cells[4].innerText;
		var eff_status				= enable_temp;
		var service_code				= service_code;
					
	document.location.href="../../eOR/jsp/ChartResultTypeAddModify.jsp?mode=2&function_id="+parent.function_id+"&chart_result_type="+chart_result_type+"&chart_result_type_desc="+escape(chart_result_type_desc)+"&chart_horzi_desc="+escape(chart_horzi_desc)+"&chart_no_columns="+escape(chart_no_columns)+"&chart_vert_desc="+escape(chart_vert_desc)+"&service_code="+escape(service_code)+"&eff_status="+eff_status;
}
</script>



<BODY class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
String classvalue = "";

	 /* Required while Selecting sql and Formatting display*/
	String enableGif ="<div align='center'><img align='center' src='../../eCommon/images/enabled.gif'></img></div>" ;
	String disableGif ="<div align='center'><img src='../../eCommon/images/RRnwd.gif'></img></div>" ;

	
	try{
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

	String code				= request.getParameter("chart_result_type");
	String Desc				= request.getParameter("chart_result_type_desc");
	String row_desc			= CommonBean.checkForNull(request.getParameter("chart_horzi_desc"));
	String col_desc			= CommonBean.checkForNull(request.getParameter("chart_vert_desc"));
	String enable			= request.getParameter("eff_status");
	boolean searched		= request.getParameter( "searched" ) == null? false : true  ;
	String	enable_temp="";
	String service_code="";
	
	if(code != null )				code = code;
	if(Desc != null )				Desc = Desc;
	if(row_desc != null )			row_desc = row_desc;
	if(col_desc != null )			col_desc = col_desc;
	if(enable != null )				enable = enable.trim();

	//Common parameters.
	HashMap sqlMap = new HashMap();

	//include all the common parameters.
	sqlMap.put( "sqlData",OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_RESULT_TYPE_SELECT"));
	
	
	//The fields are going to be display
	ArrayList displayFields = new ArrayList();

	displayFields.add("chart_result_type" );
	displayFields.add("chart_result_type_desc");
	displayFields.add("chart_horzi_desc");
	displayFields.add("chart_no_columns");
	displayFields.add("chart_vert_desc");
	displayFields.add("service_code");
	displayFields.add("eff_status");
	
	
	//The fields are going to be in where condition * should match with the query//
	ArrayList chkFields = new ArrayList();
	
	chkFields.add( code+"%" );
	chkFields.add( Desc+"%" );
	chkFields.add( row_desc+"%" );
	chkFields.add( col_desc+"%" );
	chkFields.add( enable);
	

	// Adding function related array list into the HashMap//
	HashMap funcMap = new HashMap();
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.//
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	//System.out.println("#####result="+result);
//    int rowCount = 1;

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


<table class='grid' width='100%'>
		<tr>
			<td class=' COLUMNHEADER' width="7%"><fmt:message key="Common.type.label" bundle="${common_labels}"/></td></td>
			<td class=' COLUMNHEADER' width="14%"><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
			<td class=' COLUMNHEADER' width="25%"><fmt:message key="eOR.MatrixRowDesc.label" bundle="${or_labels}"/></td>
			<td class=' COLUMNHEADER' width="10%"><fmt:message key="eOR.Columns.label" bundle="${or_labels}"/></td>
			<td class=' COLUMNHEADER' width="22%"><fmt:message key="eOR.MatrixColumnDesc.label" bundle="${or_labels}"/></td>
			<td class=' COLUMNHEADER' width="12%"><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
		</tr>
			
			<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;
		String link_columns = "1";
			//out.println(result);
		  records=(ArrayList) result.get( recCount );
		// out.println("#### records.size()="+records.size());
		// out.println("#### records="+records);
		// out.println("#### service_code="+(String)records.get(5));

				service_code=(String)records.get(5);
				enable_temp=(String)records.get(6);
				//out.println("#### service_code="+service_code);
			
	%>
			<tr onClick="Modify(this,'<%=enable_temp%>','<%=service_code%>');" >
	<%
		
		  for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			
				<td class="<%=classvalue%>" onmouseover="changeCursor(this);"> 	<a class='gridLink' href='#'><%=(String)records.get(colCount)%></a></td>
			<%}else{
					if(colCount==5)
						colCount++;
					String str = (String)records.get(colCount);

					if(colCount == 6){
					
					str=eHISFormatter.chkReturn("E",str,enableGif,disableGif);
				
					}
				%>

				<td class="<%=classvalue%>" onclick="disableClick(event);">
				<%=str%></td>
					
			  <%}//with out hyper link
		 }//loop for all tds%>
			
		</tr>
		<%}//L00p for all records%>
	</table>

	<%
	out.flush();
	} else{
	%>
	<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","COMMON"));history.go(-1);</script>
	<%
	}
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/ChartResultTypeQueryResult.jsp", searched));
}catch(Exception e ){
	//out.println("here in catch"+e);//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
%>
</body>
</html>

