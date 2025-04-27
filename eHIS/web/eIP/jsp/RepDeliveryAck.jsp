<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import = "webbeans.eCommon.*,java.util.*,java.sql.*"%>
<% request.setCharacterEncoding("UTF-8");  %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>

<head>
	
	
	<Script src="../../eCommon/js/dchk.js" language="JavaScript"></Script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>

<script>
	function reset()
	{
		f_query_add_mod.document.location.reload();
		if(f_query_add_mod.document.forms[0].gender!=null)
		{
			
			f_query_add_mod.document.forms[0].gender.value		= 'F';
			f_query_add_mod.document.forms[0].gender.disabled	= true;
		}
		if(f_query_add_mod.document.getElementById("disc_man_gif1")!=null)
		{
			
			f_query_add_mod.document.getElementById("disc_man_gif1").style.visibility = "hidden";
			f_query_add_mod.document.getElementById("disc_man_gif2").style.visibility = "hidden";
		}

		parent.content.frames[2].location.href = "../../eCommon/html/blank.html";
	}
</script>

<%
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String call_function = "REG_NEWBORN_FOR_IP";
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame' src="<%=source%>" frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../jsp/InpatientLookupCriteria.jsp?call_function=<%=call_function%>' frameborder=0 scrolling='no' noresize style='height:155%;width:100vw'></iframe>
		<iframe name='f_query_add_mod1' id='f_query_add_mod1' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize style='height:80vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:12vh;width:100vw'></iframe>
	

</html>
<%!
	/// Added by Sridhar R , on 2/17/2006.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

