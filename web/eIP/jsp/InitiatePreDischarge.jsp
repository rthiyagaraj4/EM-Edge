<!DOCTYPE html>
<%@ page import = "webbeans.eCommon.*,java.util.*,java.sql.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
	<script src='../../eCommon/js/common.js' language='javascript'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
    
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<script>
function reset(){
	if(f_query_add_mod.Inpatientlookup_Form){
		f_query_add_mod.FnReset('all');
	}
}
function apply(){
	if(f_query_add_mod.InitiatePreDischargeResult){
		f_query_add_mod.FnApply();
	}else{
		window.commontoolbarFrame.document.location.reload();
	}
}


</script>
<%
	request.setCharacterEncoding("UTF-8");
	String url="../../eCommon/jsp/commonToolbar.jsp?";
	String params = request.getQueryString() ;
	String source = url + params ;
	String facilityId = (String)session.getValue("facility_id");	
	String loginUser = (String)session.getValue("login_user");
	String locncode = request.getParameter("location_code");
	String p_called_from_ca = request.getParameter("p_called_from_ca")==null?"N":request.getParameter("p_called_from_ca");
	int msgframgerow	= 10;
	if(locncode == null) locncode= "";
	String function_id=request.getParameter("function_id");
     if(function_id == null) function_id = "";
     
     if(p_called_from_ca.equals("Y")){
    	 msgframgerow	= 8;
     }
     
    String sql="";
    Connection con = null;
    con=ConnectionManager.getConnection(request);
    Statement stmt=null;
    ResultSet rset=null ;
    String flag=""; 
    try{		 
		stmt=con.createStatement();
		sql="select PRE_DISCH_APPL_YN from ip_param where  FACILITY_ID ='"+facilityId+"' " ;
		rset=stmt.executeQuery(sql);

		if(rset.next()) {
			flag=rset.getString("PRE_DISCH_APPL_YN");
			if(flag==null) flag="N";
		 }
	
	   if(flag.equals("N")) {
	 		out.println("<script>alert(getMessage('PREDISCHARGE_NOT_ALLOWED','IP'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	   }else{



%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%= source %> frameborder=0 scrolling='no' noresize style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' 		src='../../eIP/jsp/InitiatePreDischargeCriteria.jsp?p_called_from_ca=<%=p_called_from_ca%> ' frameborder=0 scrolling='no' noresize style='height:82vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'		src='../../eCommon/jsp/error.jsp' frameborder=0 noresize scrolling='auto' noresize style='height:<%=msgframgerow%>vh;width:100vw'></iframe>
	

</html>
<% 
	if(stmt!=null) stmt.close();
	   }	
}catch(Exception e)	
{
	

	e.printStackTrace();
}
finally
{
	if(con != null)
	ConnectionManager.returnConnection(con,request);
}
%>

<%!
	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

