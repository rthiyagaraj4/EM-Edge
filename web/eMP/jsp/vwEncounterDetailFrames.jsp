<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import=" webbeans.eCommon.* , java.text.*" %>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
request.setCharacterEncoding("UTF-8");


%>
 <%
	//String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
	//String parmeters = request.getQueryString() ;
	//String source = url + parmeters ;
	String function_id=request.getParameter("function_id");
    if(function_id == null) function_id = "";
	
 %>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eMP/js/VwEncounterDetails.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<Title><fmt:message key="Common.PreviousEncounters.label" bundle="${common_labels}"/></Title>
<iframe SRC="../../eMP/jsp/vwEncounterDetailMain.jsp?<%=request.getQueryString()%>" scrolling='no' NORESIZE style='height:14vh;width:100vw;border:0'></iframe>
<iframe SRC="../../eMP/jsp/vwEncounterDetailResult.jsp?function_id=<%=function_id%>&<%=request.getQueryString()%>" scrolling='Auto' name='resultFrame' id='resultFrame' NORESIZE style='height:70vh;width:100vw;border:0'></iframe>
<iframe SRC="../../eCommon/html/blank.html?" scrolling='Auto' name='dis_cummary' id='dis_cummary' NORESIZE style='height:2vh;width:100vw;border:0'></iframe>
<iframe SRC="../../eMP/jsp/vwEncounterDetailButton.jsp" scrolling='no' name="" id="" NORESIZE style='height:6vh;width:100vw;border:0'></iframe>

<form>
	<input type='hidden' name='function_id' id='function_id' value=<%=function_id%>>
	</form>
 </html>	

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue :

inputString);
	}
%>

