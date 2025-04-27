<!DOCTYPE html>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ page import="java.sql.*, java.util.*, java.text.*" %>
<html>
<head>
   <%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String imgUrl="";
if(sStyle.equals("IeStyle.css"))
 {
		imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
 }
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
    <script src="../js/ValidateControl.js" language="javascript"></script>
    <script src="../js/common.js" language="javascript"></script>
    <script src="../js/CommonLookup.js" language="javascript"></script>
     <script language="Javascript" src="../../eOT/js/Booking.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
  
    <script>
        var chkBothCriteria = false ;
        var fromCalledPage = false ;
    </script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>

<form name="CriteriaForm" id="CriteriaForm"  >
<table align="right"  border="0" width="100%" cellspacing="0" cellpadding=3 >
    <tr width="100">
        <td  class='Label' width="25%">
		</td>
        <td class='Label' width="25%"  >
		<fmt:message key="Common.searchby.label" bundle="${common_labels}"/>
		<input type="radio" name="search_by" id="search_by" class="label" value="C"  onclick="storeValorderid(this)" checked>
		<fmt:message key="Common.name.label" bundle="${common_labels}"/>
		
        <input type="radio" name="search_by" id="search_by" class="label" value="D" onclick="storeValorderid(this)" >
		<fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/>
		<select name="search_criteria" id="search_criteria">
        <option value="S">
		<fmt:message key="Common.startsWith.label" bundle="${common_labels}"/>
		
        <option value="E">
		<fmt:message key="Common.endsWith.label" bundle="${common_labels}"/>
		
        <option value="C">
		<fmt:message key="Common.contains.label" bundle="${common_labels}"/>
		
        </select>
        </td>
        </tr>
    <tr>
        <td></td>
        <td class="label" colspan=2  >
		<fmt:message key="Common.searchtext.label" bundle="${common_labels}"/>
		
        <input type="text"   name="search_text" id="search_text" value="" width="30%" align="left" size="40" maxlength="70" >
        </td>
        <td align="right">
		<input type="button" align="left" name="Search" id="Search" 
		value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="valtextorderid(search_text); this.disabled=true;" class="button" >
        <input type="button" align="left" name="Reset" id="Reset" value='<fmt:message key=	"Common.reset.label" bundle="${common_labels}"/>'
	
		onClick="resetFormorderid(this.form)" class="button" >
        </td>
</tr>
<tr>
	<td colspan='4'>
	<img src='<%=imgUrl%>' width='100%' height='15'/> 
	</td>
</tr>
</table>
<BR>
<BR>
</form>
</body>
<script>
    initializeTextorderid();
</script>
</html>

