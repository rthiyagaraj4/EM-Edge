<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script src='../../eIP/js/IPAdvBedMgmtTrns.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script>
	<title>Graphical Bed Chart</title>
	<script type="text/javascript">
		//fullScreen() ;
		function fullScreen() {
			window.resizeTo( screen.availWidth, screen.availHeight ) ;
			window.moveTo( 0,0 ) ;
		}
	</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head> 

<%
	request.setCharacterEncoding("UTF-8");
	//String url="../../eCommon/jsp/commonToolbar.jsp?";
	//String params = request.getQueryString() ;
	//String source = url + params ;
	//Below code was added by N Munisekhar on 08-JAN-2013 against [IN037130]
	String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//	String source = url;
%> 
<iframe name='commontoolbarFrame' id='commontoolbarFrame'    src='../../eCommon/jsp/commonToolbar.jsp' frameborder=0 scrolling='no' noresize style='height:0%;width:100vw'></iframe> 
	<iframe name='serachFrame' id='serachFrame' 		src='../../eIP/jsp/IPAdvBedMgmtCriteria.jsp?called_from=bed_mgmt_trns&function_id=<%=function_id%>' noresize framespacing=0 frameborder=no border=0 style='height:3.1%;width:100vw'></iframe><iframe name='status' id='status' src='../jsp/IPAdvBedMgmtColorSchema.jsp' noresize framespacing=0 frameborder=no border=0 scrolling='auto' style='height:6.5%;width:100vw'></iframe><iframe name='adv_bed_mgmt' id='adv_bed_mgmt' 		src='../../eCommon/html/blank.html' noresize framespacing=0 frameborder=no border=0 scrolling='no' style='height:80vh;width:100vw'></iframe><iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' noresize framespacing=0 frameborder=no border=0 scrolling='auto' style='height:0%;width:100vw'></iframe>
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

