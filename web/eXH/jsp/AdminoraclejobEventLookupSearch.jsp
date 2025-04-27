<!DOCTYPE html>
<!-- OrderableSearch.jsp -->
 
<%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.sql.*,java.util.*,eXH.*,webbeans.eCommon.ConnectionManager" %>
<%-- JSP Page specific attributes end --%>


<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%-- Mandatory declarations end --%> 
   <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>						 
<html> 
<head>
<% 																				 
	String sStyle	="IeStyle.css";												     //((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl = "";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<!--	<script language="JavaScript" src="../js/OrCommonFunction.js"></script>-->
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eXH/js/AdministerReviewCommunicationProcess1.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
</head>
 <script>
        var chkBothCriteria = false ; 														    
        var fromCalledPage = false ;
 </script>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" onLoad="searchResult();">
<%
	/* Mandatory checks start */ 
	request.setCharacterEncoding("UTF-8");

	 
 String commode= request.getParameter("commmode");
	String searchText = request.getParameter("searchText");
	if(searchText==null) searchText = "";
	String called_from = (request.getParameter("called_from")==null)?"":request.getParameter("called_from");
    String protocol_link_id=request.getParameter("protocol_link_id");

%>
<form name="OrderableSearch" id="OrderableSearch" target='' action=''>

<table align="center"  border="0" width="100%"  cellspacing="0" cellpadding="3">
 
<tr>
<td class="label" nowrap><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td><td class="fields">
       <input type="radio" name="search_by" id="search_by" class="label" value="D"    onclick="storeVal(this)"><fmt:message key="Common.description.label" bundle="${common_labels}"/>
        <input type="radio" name="search_by" id="search_by" class="label" value="C" checked onclick="storeVal(this)"><fmt:message key="Common.code.label" bundle="${common_labels}"/>
		</td>
		<td class="label">
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></td><td class='fields'>
        <select name="search_criteria" id="search_criteria">
        <option value="S"><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
				<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
        </select>
        </td>
		</tr><tr>
        <td class="label"><fmt:message key="Common.searchtext.label" bundle="${common_labels}"/></td><td class='fields'>
        <input type="text"   name="search_text" id="search_text" 
		value='<%=searchText%>' width="30%" align="left" size="40" maxlength="70" >
        </td>
		<td colspan=2></td> 
        </tr>
         <tr>   
		<td colspan=3></td>
        <td class="button" align="right" nowrap ><input type="button" align="left" name="Search" id="Search" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="searchResult()" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' onClick="resetFormSearch(this.form)" class="button" >
        </td> 
    </tr>

</table>
<%if(!imgUrl.equals("")){ %> 
<img src='<%=imgUrl%>' width='100%' height='15'/> 
<%}%>

<input type="hidden" name="called_from" id="called_from" value="<%= called_from%>">
<input type="hidden" name="qry_str" id="qry_str" value="<%=request.getQueryString()%>">
 <input type="hidden" name="protocol_link_id" id="protocol_link_id" value="<%=protocol_link_id%>">

 <input type="hidden" name="comm_mode" id="comm_mode" value="<%=commode%>">  

</form>
</body>
</html>

