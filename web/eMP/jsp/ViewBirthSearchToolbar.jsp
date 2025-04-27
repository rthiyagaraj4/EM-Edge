<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
        <link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
       <Script src="../../eCommon/js/ValidateControl.js" language="JavaScript"></Script>
       <Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

   </head>

    <body class='content' topmargin='0' onKeyDown = 'lockKey()'>
    <form name="search_toolbar" id="search_toolbar">
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="right">
	<tr>
	<td>
	<table border="0" cellpadding="0" cellspacing="0" width="100%" align="right">
	    <tr>
			<td align='right'>
		    <input type='button' class='BUTTON' name='Search' id='Search' title= 'Search'  value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="parent.document.criteria.Posting();">
			</td>
		</tr>
    </table>
	</td></tr></table>
    </form>
    </body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

