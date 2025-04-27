<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<% request.setCharacterEncoding("UTF-8");%>
 
<html>
<head>
<!--<link rel="stylesheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>-->
<script language='javascript' src='../js/OTExternalWidgetSelection.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%  
	String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString()+"&facility_id="+facility_id;
    String url = "../../eCommon/jsp/commonToolbar.jsp?";
    String source = url + params ;	
	
%>
 
<iframe name="commontoolbarFrame" id="commontoolbarFrame" scrolling="no" noresize src="<%= source %>" style="height:8vh;width:100vw" frameborder='0'></iframe>
<iframe name="f_query_add_mod" id="f_query_add_mod"  scrolling="yes"  src="../../eOT/jsp/OTExternalWidgetSelectionFrame.jsp? <%= source %> " style="height:83vh;width:100vw" frameborder='0'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' noresize scrolling='no' style='height:9vh;width:100vw' frameborder='0'></iframe>
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

