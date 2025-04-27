<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<html><HEAD>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
<% String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</link>
</HEAD>
<body CLASS='MESSAGE' onKeyDown = 'lockKey()'><form name='testform' id='testform'>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");

Connection con=null;
try
{
	con = webbeans.eCommon.ConnectionManager.getConnection(request);
	String scoreValue	= request.getParameter("scoreValue");
	String gcs_score	= request.getParameter("gcs_score")==null?"":request.getParameter("gcs_score");
	if(gcs_score.equals(""))gcs_score="0";
	
		%>
			<script>
			var score_val='<%=scoreValue%>'
			var gcs_score='<%=gcs_score%>'
			gcs_score=parseInt(gcs_score)+parseInt(score_val);
			parent.frames[3].document.forms[0].gcs_score.value=gcs_score;
			</script>
		<%
}
catch( Exception e ){e.printStackTrace();}
finally
{
		webbeans.eCommon.ConnectionManager.returnConnection(con,request);

}
%>

</form>
</body>
</html>

