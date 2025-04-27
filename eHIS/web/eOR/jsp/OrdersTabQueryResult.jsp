<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@page import="java.util.*, eOR.Common.*, eOR.*,eCommon.XSSRequestWrapper " contentType="text/html; charset=UTF-8" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
 <%@include file="../../eCommon/jsp/CommonBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<html>
	<head>
	<title></title>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eOR/js/OrCommon.js"></script>
	<script language="Javascript" src="../../eOR/js/TextBlock.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<!--<script language='Javascript' src='../../eCommon/js/messages.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
-->
	<script>

	function Modify(obj){

		var patient_class = obj.cells[0].innerText;
		var patient_class_desc = obj.cells[1].innerText;
		var practitioner_id =obj.cells[2].innerText;
		var practitioner_name = obj.cells[3].innerText;
		var func_id = obj.cells[4].children[0].value;
		var func_name = obj.cells[5].innerText;
	var mode = "2";
	document.location.href="OrdersTabAddModify.jsp?patient_class="+patient_class+"&"+"practitioner_id="+practitioner_id+"&"+"mode="+mode+"&"+"patient_class_desc="+patient_class_desc+"&"+"practitioner_name="+practitioner_name+"&func_id="+func_id+"&func_name="+func_name;
	}

	</script>
	<body  onMouseDown="CodeArrest()" onKeyDown="lockKey()">
 <%
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
    String patient_class				= request.getParameter("patient_class");
	String patient_class_desc			= request.getParameter("patient_class_desc");
    String practitioner_id  			= request.getParameter("practitioner_id");
	String practitioner_name			= request.getParameter("practitioner_name");
	

if(patient_class == null|| patient_class.equals("")){
		patient_class = "";}
	else{
		patient_class = patient_class.toUpperCase();}
if(patient_class_desc==null || patient_class_desc.equals("")) 	
	patient_class_desc="";

if(practitioner_id==null || practitioner_id.equals("")) 	
	practitioner_id="";

if(practitioner_name==null || practitioner_name.equals("")) 	
	practitioner_name="";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	String sql=OrRepositoryExt.getOrKeyValue("SQL_OR_ORDERS_TAB_RESULT");
	sqlMap.put( "sqlData",sql);
	HashMap funcMap = new HashMap();

	//The fields are going to be display

	ArrayList displayFields = new ArrayList();
				displayFields.add( "patient_class");
				displayFields.add( "patient_class_desc" );
				displayFields.add( "practitioner_id" );
				displayFields.add( "practitioner_name");
				displayFields.add( "function_id");
				displayFields.add( "function_name");
				

	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();

				chkFields.add( patient_class + "%");
				chkFields.add( practitioner_id + "%");
				chkFields.add( patient_class_desc + "%");
				chkFields.add( practitioner_name + "%");
	
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
		<th class=' columnheader'> <fmt:message key="Common.patientclass.label" bundle="${common_labels}"/></th>
		<th class=' columnheader'><fmt:message key="Common.PatientClassDescription.label" bundle="${common_labels}"/></th>  
		<th class=' columnheader'><fmt:message key="Common.practitionerid.label" bundle="${common_labels}"/></th>   
		<th class=' columnheader'><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></th> 
		<th class=' columnheader'><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></th>

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
%>
	
	<%
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


				<%if(colCount!=4){%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);">
				<%
				out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				%></td>
				<%}else if(colCount==4){%>
					 <td class="<%=classvalue%>" onclick="disableClick(event);" style="display:none">
					<INPUT TYPE="hidden" value=<%=(String)records.get( colCount)%>></td>
				<%
					continue ;
				}


			}
		}
		%>
		</tr>
		<%}%>
		</table>


		<%out.flush();}else{%>
			 <script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"OrdersTabQueryResult.jsp", searched));


	}
	catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
	%>
	</body>
	</html>

