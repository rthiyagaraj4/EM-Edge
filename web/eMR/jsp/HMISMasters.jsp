<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
 
<head>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eMR/js/HMISMaster.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    </head>
<%
	request.setCharacterEncoding("UTF-8");
    String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
    String params = request.getQueryString() ;
    String source = url + params ;
%>
<iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 scrolling='no' noresize
src=<%=source%>  style='height:10%;width:100vw'></iframe><iframe name='HMISFrame1' id='HMISFrame1' frameborder=0 scrolling='no' noresize
 src='../../eCommon/html/blank.html'  style='height:5%;width:100vw'></iframe><iframe name='HMISFrame2' id='HMISFrame2'  src='../../eCommon/html/blank.html' frameborder=0  scrolling='no' style='height:40%;width:100vw'></iframe><iframe name='HMISFrame3' id='HMISFrame3'  src='../../eCommon/html/blank.html' frameborder=0  scrolling='no' style='height:40%;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame'	 src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' style='height:15%;width:100vw'></iframe>
</html>
<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

