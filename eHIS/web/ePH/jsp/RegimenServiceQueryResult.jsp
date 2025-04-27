<!DOCTYPE html>
 <%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.Common.*, ePH.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
	<head>
	<title></title>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
    <script language="Javascript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<!--<script language='javascript' src='../../eCommon/js/messages.js'></script>-->
	<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>
	function Modify(obj){
		var code = obj.cells[0].innerText;
		var desc = obj.cells[1].innerText;
		var url="RegimenServiceAddModify.jsp?mode=2&code="+code+"&desc="+escape(desc)+"&function_id="+parent.function_id;
		document.location.href=url;
	}
	</script>
	<!-- <body OnMouseDown="CodeArrest()"; > -->
	<body OnMouseDown="CodeArrest()"; onKeyDown="lockKey()">
 <%
    String indicator			= request.getParameter("indicator").trim();
    String service_code			= request.getParameter("service_code").trim();
    String service_desc			= request.getParameter("service_desc").trim();
    String regimen_yn			= request.getParameter("regimen_yn").trim();
    String tpn_yn				= request.getParameter("tpn_yn").trim();
	String eff_status			= request.getParameter("eff_status").trim();
	if(indicator == null){indicator = "";}else{indicator = indicator.toUpperCase();}
	if(service_code == null){service_code = "";}else{service_code = service_code.toUpperCase();}
	
	if(regimen_yn==null ) regimen_yn="";
	
	if(tpn_yn==null ) tpn_yn="";
	if(eff_status==null ) eff_status="";
	boolean searched = request.getParameter( "searched" ) == null ? false : true  ;
	try{
	String classvalue			= "";
	HashMap sqlMap = new HashMap();
	sqlMap.put( "sqlData", PhRepository.getPhKeyValue("SQL_PH_REGIMEN_SERVICE_SELECT")); 
	//Function Parameters
	HashMap funcMap = new HashMap();

	//	SELECT stage_code,problem_ind,long_desc,short_desc,eff_status     FROM PH_PROBLEM_STAGE WHERE UPPER(stage_code) LIKE UPPER('%')  AND UPPER(long_desc) LIKE UPPER('%') AND UPPER(short_desc) LIKE UPPER('%') AND eff_status LIKE ('%')

	//The fields are going to be display

	ArrayList displayFields		=	new ArrayList();

	displayFields.add( "service_code" );
	displayFields.add( "short_desc" );
	displayFields.add( "problem_ind" );	
	displayFields.add( "regimen_yn" );	
	displayFields.add( "tpn_yn" );	
	displayFields.add( "eff_status" );	

	//The fields are going to be in where condition * should match with the query

	ArrayList chkFields = new ArrayList();
	chkFields.add( indicator + "%");
	chkFields.add( service_code + "%");
	chkFields.add( regimen_yn + "%");
	chkFields.add( tpn_yn + "%");
	chkFields.add( eff_status + "%");
	chkFields.add( service_desc + "%");
	chkFields.add(locale);


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
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.service.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="ePH.ProblemInd.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.Regimen.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="ePH.TPN.label" bundle="${ph_labels}"/></th>
		<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>
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
			<td class="<%=classvalue%>" onmouseover="changeCursor(this);"><font class='HYPERLINK'><%=((String)records.get(colCount)).trim()%></font></td>
			<%}else{
				if((colCount == 4) || (colCount == 3) ){
					disp = (String)records.get(colCount);
			%>
				<td class="<%=classvalue%>">
				<%if(disp.equals("Y")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(disp.equals("N")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>
			<%
				} else if((colCount == 5)){
					disp = (String)records.get(colCount);
			%>
				<td class="<%=classvalue%>">
				<%if(disp.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(disp.equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>
			<%
				}
				else if (colCount==2){
					%>
				<td class="<%=classvalue%>" onclick="disableClick(event);" >
				<%				out.println(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH."+(String)records.get( colCount)+".label","ph_labels")); 

				out.println("</td>"); 
				}
			else	
			{
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
		<SCRIPT>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));history.go(-1);</SCRIPT>
			<%}out.println(CommonBean.setForm(request ,"RegimenServiceQueryResult.jsp", searched));
	}
	catch(Exception e) {
	out.print("Exception @ Result JSP :"+e.toString());
	}	
	%>
	</body>
	</html>

