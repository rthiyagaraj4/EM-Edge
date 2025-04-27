<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- JSP Page specific attributes start --%>

<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>

	<script language="JavaScript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<script language="JavaScript" src="../../eOR/js/ChartVertical.js"></script>

	<script>
	function Modify(obj,temp,dest){
		
		var chart_result_type = obj.cells[0].innerText;
		
		var chart_vertical_code = obj.cells[1].innerText;
		
		var long_description = obj.cells[2].innerText;
		
		var short_description =obj.cells[3].innerText;
		
		var seq_no = obj.cells[4].innerText;
		
		var discr_msr_id = obj.cells[5].innerText;
		
		//var copy_prev = obj.cells[6].innerText;
		var copy_prev = dest;
		
		var eff_status = '';
		
	var mode = "2";

	document.location.href="ChartVerticalAddModify.jsp?chart_result_type="+chart_result_type+"&chart_vertical_code="+chart_vertical_code+"&"+"long_description="+encodeURIComponent(long_description)+"&"+"short_description="+encodeURIComponent(short_description)+"&"+"seq_no="+seq_no+"&"+"eff_status="+eff_status+"&"+"mode="+mode+"&"+"temp="+temp+"&"+"discr_msr_id="+discr_msr_id+"&"+"prev="+copy_prev;
	}
	
	</script>
</head>
 <body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
 <%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String chart_result_type = ((request.getParameter("chart_result_type").trim().equals("")) ? "":request.getParameter("chart_result_type").trim());
	
	String chart_vertical_code			= request.getParameter("chart_vertical_code");
	String long_description			= request.getParameter("long_desc");
    //String short_description  		= request.getParameter("short_desc").trim();
	String short_description = "";
	String seq_no	= ((request.getParameter("seq_no") == null) ? "":request.getParameter("seq_no"));
	String eff_status = request.getParameter("nature");
	String chart_res_type = "";
	String cpy_prev = "";
	
if(chart_vertical_code == null|| chart_vertical_code.equals("")){
		chart_vertical_code = "";}
	else{
		chart_vertical_code = chart_vertical_code.toUpperCase();}
if(long_description==null || long_description.equals("")) 	
	long_description="";

//if(short_description==null || short_description.equals("")) 	
//	short_description="";

//if(seq_no==null || seq_no.equals("")) 	
//	seq_no="";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	//sqlMap.put( "sqlData", "select TEXT_BLOCK_ID,TEXT_BLOCK,DISCR_MSR_PANEL_ID,SHORT_DESC from or_text_block a,am_discR_msr b ");
	String sql=OrRepositoryExt.getOrKeyValue("SQL_OR_CHART_VERTICAL_RESULT_SELECT");
	
		sqlMap.put( "sqlData",sql);

	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();
				
				displayFields.add("chart_result_type");
				displayFields.add("chart_result_type_desc");
				displayFields.add("chart_verti_code");
				displayFields.add( "long_desc");
				displayFields.add( "short_desc" );
				displayFields.add( "seq_no" );
				displayFields.add( "discrete_short_desc");
				displayFields.add( "copy_prev_vert_yn");
				displayFields.add( "eff_status");
				
				

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

				chkFields.add( chart_result_type + "%");
				chkFields.add( chart_vertical_code + "%");
				chkFields.add( long_description + "%");
				chkFields.add( short_description + "%");
				chkFields.add( seq_no + "%");
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
		<th class='columnheader'><fmt:message key="eOR.resultmatrix.label" bundle="${or_labels}"/></th>
		<th class='columnheader'><fmt:message key="eOR.MatrixRowCode.label" bundle="${or_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.SequenceNo.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.DiscreteMeasure.label" bundle="${common_labels}"/></th>
		<th class='columnheader'><fmt:message key="eOR.CopyPrevious.label" bundle="${or_labels}"/></th>
		<th class='columnheader'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
		<%
		//Retriving the records from result arraylist
		ArrayList records=new ArrayList();
		String link_columns1 = "";
		String link_columns2 = "";
		for(int recCount=2; recCount<result.size(); recCount++) {
			if ( recCount % 2 == 0 )
				classvalue = "gridData" ;
			else
				classvalue = "gridData" ;

				records=(ArrayList) result.get( recCount );
				chart_res_type = (String)records.get(0);
				cpy_prev = (String)records.get(7);
		%>
			<tr onClick="Modify(this,'<%=chart_res_type %>','<%= cpy_prev %>');" >
			<%


		link_columns1 = "2";
		link_columns2 = "3";
		records=(ArrayList) result.get( recCount );
%>
	
	<%
		for(int colCount=1; colCount<records.size(); colCount++){
				
				if( link_columns1.indexOf(String.valueOf(colCount+1)) != -1 || link_columns2.indexOf(String.valueOf(colCount+1)) != -1)
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
			       if(colCount ==8)
						{//start of if 3
								if( ((String)records.get(colCount)).equals("E"))
							{out.println("<input type='hidden' value='E'><div align=center><img src='../../eCommon/images/enabled.gif'></img></div>");}
								else
							{out.println("<input type='hidden' value='D'><div align=center><img src='../../eCommon/images/disabled.gif'></img></div>");}
							}//end of if 3
					if(colCount == 7)
					{
						if( ((String)records.get(colCount)).equals("Y"))
							{out.println("<input type='hidden' value='Y'><div align=center><img src='../../eCommon/images/enabled.gif'></img></div>");}
								else
							{out.println("<input type='hidden' value='N'><div align=center><img src='../../eCommon/images/disabled.gif'></img></div>");}
					
					}
				
		%>


				<%if(colCount!=8 && colCount != 7)
				out.println((String)records.get(colCount)==null ? "" :(String)records.get(colCount));
				
				%></td>
				<%


			}
			%><input type="hidden" name="chart_res_type" id="chart_res_type" value="<%= (String)records.get(0) %>"><%
		}
		%>
			
		</tr>
		<%}%>
		</table>


		<%out.flush();}else{%>
			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"ChartVerticalQueryResult.jsp", searched));


	}
	catch(Exception e) {
	System.out.print("Exception @ Result JSP :"+e.toString());
	//e.printStackTrace();
	}
	%>

</body>

