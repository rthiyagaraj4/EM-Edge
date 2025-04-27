<!DOCTYPE html>

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eMP/js/PatientNumberingForRelation.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	 String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
	 String params = request.getQueryString() ;
	 String source = url + params ;
	 String gen_pid_using_aid1_rule_yn = "";
	// String prefix_or_suffix_length = "";

	 Connection conn  = null;
	 Statement stmt   = null;
	 ResultSet rs     = null;
	 try
	 {
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select GEN_PID_USING_AID1_RULE_YN from mp_param"); 

		while(rs!=null && rs.next())
		 {
			gen_pid_using_aid1_rule_yn = rs.getString("GEN_PID_USING_AID1_RULE_YN");
			//prefix_or_suffix_length	   = rs.getString("RELATIONSHIP_LEVEL_LENGTH");				
		 }
		if(gen_pid_using_aid1_rule_yn.equals("N"))
		 {
			%>	
		<script>
			alert(getMessage("FUNCTION_NOT_APPL","MP"));	
			document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
	<%
		 }
		else if(gen_pid_using_aid1_rule_yn.equals(""))
		 {
	%>	
		<script>
			alert(getMessage("MP_PARAM_NOT_FOUND","MP"));	
	        document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
	<%
		 }
	else
		 {
	%>
	
	 <iframe name='commontoolbarFrame' id='commontoolbarFrame' src=<%=source%> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe> 
		<iframe name='f_query_add_mod' id='f_query_add_mod' src="../../eMP/jsp/addPatNumberingForRel.jsp?" frameborder=0 scrolling='no' style='height:83vh;width:100vw'></iframe>
		<iframe name='result' id='result_det' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:0vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='no' style='height:9vh;width:100vw'></iframe>
<%
		 }
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
	 }
		
	 catch(Exception e)
	 {
		out.println("Exception in PatientRelationNumber is:"+e.toString());
		
	 }
	 finally
	 {
		ConnectionManager.returnConnection(conn,request);		
     		}

	%>

	 
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

