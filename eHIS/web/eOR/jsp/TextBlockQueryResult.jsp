<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper"%>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	<title></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>

	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eOR/js/TextBlock.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		
	<script>

	function Modify(obj){

		var text_block_id = obj.cells[0].innerText;
		var DISCR_MSR_PANEL_ID=obj.cells[2].innerText;
		var text_block=obj.cells[1].innerText;
//alert("text_block_id ::"+text_block_id+"DISCR_MSR_PANEL_ID //::"+DISCR_MSR_PANEL_ID+"text_block ::"+text_block);

	document.location.href="TextBlockAddModify.jsp?mode=2&text_block_id="+text_block_id;
	}

	</script>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()"  >
 <%
	
    String text_id									= request.getParameter("text_id");
    String discr_msr_panel_id			= request.getParameter("discr_msr_panel_id");
	String short_desc                         = request.getParameter("short_desc");
	String eff_status							= request.getParameter("eff_status").trim();
	//request.getParameter("short_desc").trim();
if(text_id == null||text_id.equals("")){
		text_id = "";}
	else{
		text_id = text_id.toUpperCase();}

if(discr_msr_panel_id==null || discr_msr_panel_id.equals("")) 				  discr_msr_panel_id="";

if(short_desc==null || short_desc.equals(""))   short_desc="";


if(eff_status==null||eff_status.equals("")||eff_status.equals("''"))
				eff_status="";
	else if(eff_status.equals("E"))
				eff_status="E";
	else
				eff_status="D";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	//sqlMap.put( "sqlData", "select TEXT_BLOCK_ID,TEXT_BLOCK,DISCR_MSR_PANEL_ID,SHORT_DESC from or_text_block a,am_discR_msr b ");
String sql=OrRepository.getOrKeyValue("SQL_OR_TEXT_BLOCK_QUERY_RESULT");
	//	   out.println(sql);
		sqlMap.put( "sqlData",sql);
//		out.println("sql:"+sql);
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();
				displayFields.add( "TEXT_BLOCK_ID" );
				displayFields.add( "TEXT_BLOCK" );
				displayFields.add( "DISCR_MSR_PANEL_ID" );
				displayFields.add( "SHORT_DESC" );
				displayFields.add( "EFF_STATUS" );

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

				chkFields.add( text_id + "%");
				chkFields.add( discr_msr_panel_id + "%");
				chkFields.add( short_desc + "%");
				chkFields.add( eff_status + "%");

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=new ArrayList();

	result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=3 cellspacing=0 width="100%" border=0 align="center">
		<tr>
		<td class=label></td>
		<td class=label>
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

 	<table class='grid' width="100%">
		<th class='columnheader'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.Text.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="eOR.DiscreteMeasureID.label" bundle="${or_labels}"/></th> 
		<th class='columnheader'><fmt:message key="eOR.DiscreteMeasureDesc.label" bundle="${or_labels}"/></th> </th>
	 	<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
		String link_columns = "1";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
				if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 )
						{  // if loop1
	%>
		<td class="<%=classvalue%>"     onmouseover="changeCursor(this);" >
				<a class='gridLink' href='#'>
				<%=(String)records.get(colCount)%>
				</a>
		</td>
		<%}else{

				%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);">
				<%
			       if(colCount ==4)
						{//start of if 3
								if( ((String)records.get(colCount)).equals("E"))
										out.println("<img src='../../eCommon/images/enabled.gif' align=center><input type='hidden' value='E'></img>");
					else
										out.println("<img src='../../eCommon/images/disabled.gif' align=center><input type='hidden' value='D'></img>");
							}//end of if 3

		%>


				<%if(colCount!=4)
				out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				%></td>
				<%


			}
		}
		%>
		</tr>
		<%}%>
		</table>


		<%out.flush();}else{%>
			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"TextBlockQueryResult.jsp", searched));


	}
	catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
	}
	%>
	</body>
	</html>

