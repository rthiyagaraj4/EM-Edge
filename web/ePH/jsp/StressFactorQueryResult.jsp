<!DOCTYPE html>
 <%-- saved on 26/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*, eCommon.Common.*,eCommon.XSSRequestWrapper " %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>


<html>
	<head>
	<title></title>
	<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
	request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
	response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
	response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	//ends
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
	function Modify(obj){
		var srl_no = obj.cells[0].innerText;

		document.location.href="StressFactorAddModify.jsp?mode=2&srl_no="+srl_no+"&function_id="+parent.function_id;
	}
	</script>
	<!-- <body OnMouseDown="CodeArrest()"; > -->
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%

    String stress_related_option		= request.getParameter("stress_related_option").trim();
    String weightage		= request.getParameter("weightage").trim();
    String default_yn			= request.getParameter("default_yn").trim();

	if(stress_related_option == null){stress_related_option = "";}else{stress_related_option = stress_related_option.toUpperCase();}
	if(weightage == null){weightage = "";}else{weightage = weightage.toUpperCase();}
	if(default_yn==null ) default_yn="";

	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;

	try{
	String classvalue			= "";

	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_STRESS_FACTOR_SELECT"));

	//Function Parameters
	HashMap funcMap = new HashMap();


	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "srl_no" );
	displayFields.add( "stress_related_option" );
	displayFields.add( "weightage" );	
	displayFields.add( "system_defined_yn" );	
	displayFields.add( "default_yn" );	
	
	//The fields are going to be in where condition * should match with the query
	ArrayList chkFields = new ArrayList();
	chkFields.add(locale);
	chkFields.add( stress_related_option + "%");
	chkFields.add( weightage + "%");
	chkFields.add( default_yn + "%");
	

	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );

	//Calling the Result from Common Adaptor as a arraylist.
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" border=0 align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center">
		<th><fmt:message key="Common.SerialNo.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="ePH.StressRelatedOption.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.Weightage.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.SystemDefined.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.Default.label" bundle="${common_labels}"/></th>
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
		String link_columns = "1", disp ="";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=(String)records.get(colCount)%> </font></td>
			<%}else{
				if((colCount == 4) || (colCount == 3)){
					disp = (String)records.get(colCount);
			%>
				<td class="<%=classvalue%>">
				<%if(disp.equals("Y")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(disp.equals("N")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>

			<%
				}else{
			%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);"> 
				 <%
					out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				}%></td>
			<%}
		}
		%>
		</tr>
		<%}%>
		</table>
		<%out.flush();}else{%>
			<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</script>
			<%}out.println(CommonBean.setForm(request ,"StressFactorQueryResult.jsp", searched));
	}
	catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
	}	
	%>
	</body>
	</html>

