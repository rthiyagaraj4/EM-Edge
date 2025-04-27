<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>
<html>

<head>
  <%String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

  <link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
  <script language='javascript' src='../../eOA/js/WaitlistCategoryForSplty.js'></script>
  <script language='javascript' src='../../eCommon/js/common.js'></script>
  <script language='javascript' src='../../eCommon/js/ValidateControl.js'></script> 
  <script language='javascript' src='../../eCommon/js/CommonLookup.js' > </script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
 
</head>
  
 	 
	 <body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
	 <form name="IndicatorFacilityform" id="IndicatorFacilityform" action="../../servlet/eQA.WaitListCategoryForSpltyServlet" method="post" target="messageFrame">
		<BR>
		 <table border="0" cellpadding="0" cellspacing="0" align='center' width='83%'>
			<tr >
			   <td colspan='5' class=label>&nbsp;</td>
			</tr>

			<tr>

			<td width='5%'>&nbsp;</td>

			<td class='label'  nowrap><fmt:message key="eOA.WaitlistCategory.label" bundle="${oa_labels}"/></td>

			<td class='fields'><INPUT TYPE="text" name="waitlist_category_desc" id="waitlist_category_desc" size=40 onBlur='colectWaitlistCatblur(but1,this,waitlist_category_code);' onchange='clear_result();'><input type=button name=but1 onClick='colectWaitlistCat(this,waitlist_category_desc,waitlist_category_code)'  class=button value='?'><img src='../../eCommon/images/mandatory.gif' align='center'></img></td> 
			
			<td class='label' >
			<input type='button' name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class='button' onclick='submitPage()'>
			&nbsp;<input type='button' name='clear' id='clear' value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' class='button' onclick='clearData();'></td>
			
			</tr>

			<tr>
			   <td colspan='5' class=label>&nbsp;</td>
			</tr>

			<input type=hidden name='waitlist_category_code' id='waitlist_category_code' value=''>
		</table>
	</form>
</body>
	
</html>

