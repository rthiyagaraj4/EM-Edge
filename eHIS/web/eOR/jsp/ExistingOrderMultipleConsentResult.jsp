<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<!-- ExistingOrderMultipleConsentResult.jsp -->

<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@page  import="java.util.*, eOR.* ,eOR.Common.*,eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- JSP Page specific attributes end --%>
 

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>

<%@ include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%> 

<html>
<head>
	<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
 	<script language="JavaScript" src="../js/ConsentOrder.js"></script> 
	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../js/OrCommon.js"></script>
	<script language="JavaScript" src="../../eCommon/js/CommonResult.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
 <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
		function callModify(){
			
			if(document.getElementById("res_size").value == "3"){
				var argArray = window.dialogArguments ;
				var code1=document.getElementById("resTable").rows(1).cells[0].innerText;
				var code2=document.getElementById("resTable").rows(1).cells[1].innerText;
			
				var retVal = code1 + "&" + code2 ;
				window.returnValue = retVal ;
				window.close()
			}
		}
    </script>

	
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="refOrderableresult" id="refOrderableresult">
<%			
         request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String called_from = request.getParameter("called_from");
		if(called_from==null) called_from = "";
 		String search_by=request.getParameter("search_by");
 		String consent_by=request.getParameter("consent_by");
 		String order_id=(request.getParameter("order_id")==null)?"":request.getParameter("order_id");
 		String order_line_num=(request.getParameter("order_line_num")==null)?"":request.getParameter("order_line_num");
		String consent_code="";
		String consent_desc="";
		if(search_by==null || search_by=="null") search_by = "C";
		if(consent_by==null || consent_by=="null") consent_by = "L";
 			String long_desc=request.getParameter("Search_Text");
		if(long_desc==null || long_desc=="null") long_desc = "";
		String searchcriteria=(request.getParameter("Search_Criteria")==null)?"":request.getParameter("Search_Criteria");
 				
 		//String facility_id = (String)session.getValue("facility_id");
				
		if(search_by.equalsIgnoreCase("D"))
		{
			consent_desc=long_desc;
			consent_code="";
		}
		else
		{
			consent_code=long_desc;
			consent_desc="";
		}
 		
		boolean searched = request.getParameter( "searched" ) == null ? false : true  ;
		

	try{
	String classvalue			= "";
		
  	HashMap sqlMap = new HashMap();
	if(consent_by.equalsIgnoreCase("N"))
	{
 		sqlMap.put( "sqlData",
		OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI_NON_IND"));
	}
	else
	{
		sqlMap.put( "sqlData",OrRepositoryExt.getOrKeyValue("SQL_OR_CATALOG_CONSENT_FORMAT_MULTI_SPECIFIC"));
	}
		
	
	//Function Parameters
	HashMap funcMap = new HashMap();

	//The fields are going to be display
	ArrayList displayFields = new ArrayList();
	displayFields.add( "CODE");
	displayFields.add("DESCRIPTION" );
	
	ArrayList chkFields = new ArrayList();

	if(consent_by.equalsIgnoreCase("N"))
	{
		chkFields.add(localeName);
		if(searchcriteria.equals("S"))  
			chkFields.add(consent_code+"%");
		else if(searchcriteria.equals("E"))
			chkFields.add("%"+consent_code);
		else if(searchcriteria.equals("C"))
			chkFields.add("%"+consent_code+"%");
		if(searchcriteria.equals("S"))  
			chkFields.add(consent_desc+"%");
		else if(searchcriteria.equals("E"))
			chkFields.add("%"+consent_desc);
		else if(searchcriteria.equals("C"))
			chkFields.add("%"+consent_desc+"%");
		
	}
	else
	{
		chkFields.add(localeName);
		chkFields.add(order_id);
		chkFields.add(order_line_num);
		if(searchcriteria.equals("S"))  
			chkFields.add(consent_code+"%");
		else if(searchcriteria.equals("E"))
			chkFields.add("%"+consent_code);
		else if(searchcriteria.equals("C"))
			chkFields.add("%"+consent_code+"%");
		chkFields.add(localeName);
		if(searchcriteria.equals("S"))  
			chkFields.add(consent_desc+"%");
		else if(searchcriteria.equals("E"))
			chkFields.add("%"+consent_desc);
		else if(searchcriteria.equals("C"))
			chkFields.add("%"+consent_desc+"%");
		
	}

 	//Adding function related array list into the HashMap
	funcMap.put( "displayFields", displayFields );
	funcMap.put( "chkFields", chkFields );
	//Calling the Result from Common Adaptor as a arraylist.(sqlMap, funcMap, request,false)
	ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,false);
	

	if( (result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){
	%>
		<table cellpadding=0 cellspacing=0 width="100%" align="center">
		<tr>
		<td width="80%" class="white">&nbsp;</td>
		<td width="20%" class="white">&nbsp;
	<%
		//For display the previous/next link
	     out.println(result.get(1));
	%>
		</td></tr>
		</table>

		<table border="" cellpadding="0" cellspacing="0" width="100%" align="center" id="resTable" class="grid">
		<td class='COLUMNHEADER'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
		<td class='COLUMNHEADER'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
		<input type="hidden" name="res_size" id="res_size" value="<%=result.size()%>">
		<%
		//Retriving the records from result arraylist
		
		ArrayList records=new ArrayList();
		for(int recCount=2; recCount<result.size(); recCount++) {
			/*if ( recCount % 2 == 0 )
				classvalue = "QRYEVEN" ;
			else
				classvalue = "QRYODD" ;*/
				classvalue="gridData";
		%>
			<tr onClick="Modify(this);">
		<%
		String link_columns = "2", disp ="";
		records=(ArrayList) result.get( recCount );

		for(int colCount=0; colCount<records.size(); colCount++){
			if( link_columns.indexOf(String.valueOf(colCount+1)) != -1 ){%>
			<td class="<%=classvalue%>" onclick="disableClick(event);"><%=(String)records.get(colCount)%> 
			</td>
			<%}else{
				if(colCount != 3){
					%>
					<td class="<%=classvalue%>"  onclick="disableClick(event);"><a class='gridLink'  href='#' onclick='getDescrip("<%=(String)records.get(colCount+0)%>")' ><%
					out.println((String)records.get(colCount)==null ? "&nbsp;" :(String)records.get(colCount));
				%></a><input type="hidden" name="catalog_desc<%=(String)records.get(colCount+0)%>" id="catalog_desc<%=(String)records.get(colCount+0)%>" value = "<%=(String)records.get(colCount+1)%>"></td> 
				<%
				}else{
					disp = (String)records.get(colCount);
					%>
					<td class="<%=classvalue%>" align="center"><input type='hidden' value=<%=disp%>></img><%
					if(disp.equals("E")){%><img src="../../eCommon/images/enabled.gif"></img><%}else if(disp.equals("D")){%><img src="../../eCommon/images/disabled.gif"></img> <%}%></td>

					<%
				}
			}
		}
		%>
		</tr>
		<%}
		%>
		</table>
		<script>//callModify();</script>
		<%out.flush();}else{%>
			<script>alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));history.go(-1);</script>
			<%}
	}
	catch(Exception e) {
	//out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
	}
	%>
	</form>
	<%
	out.println(CommonBean.setForm(request ,"../../eOR/jsp/ExistingOrderMultipleConsentResult.jsp", searched));
%>
	</body>
	</html>

											



