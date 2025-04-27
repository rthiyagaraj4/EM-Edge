<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" %>

<%@ page contentType="text/html;charset=UTF-8" %>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../js/PatCatOrgMbsp.js'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String url="../../eCommon/jsp/MstCodeToolbar.jsp?";

	//module_id=MP&function_id=PatCatOrgMbsp&function_name=Patient Category by Orgn. Membership&function_type=F&access=YNYNN
	String params = request.getQueryString() ;
	String source = url + params ;
	String entitlement_by_pat_cat_yn ="";

	Connection conn  = null;
	Statement stmt   = null;
	ResultSet rs     = null;

	try
	{
		conn = ConnectionManager.getConnection(request);
		stmt = conn.createStatement();
		rs = stmt.executeQuery("select ENTITLEMENT_BY_PAT_CAT_YN from mp_param");

		while(rs!=null && rs.next())
		{
			entitlement_by_pat_cat_yn=rs.getString("ENTITLEMENT_BY_PAT_CAT_YN");		
		}
		if(entitlement_by_pat_cat_yn == null || entitlement_by_pat_cat_yn.equals("null")) entitlement_by_pat_cat_yn="N";


		if(entitlement_by_pat_cat_yn.equals("N"))
		 {
			%>	
		<script>
			alert(getMessage("PAT_CTGRY_NOT_APPL","MP"));
			document.location.href='../../eCommon/jsp/dmenu.jsp';
		</script>
	<%
		 }
		else if(entitlement_by_pat_cat_yn.equals(""))
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
<iframe name='commontoolbarFrame' id='commontoolbarFrame' frameborder=0 noresize	scrolling='no' src=<%=source%>    style='height:8vh;width:100vw'></iframe>
<iframe name='main_frame' id='main_frame'	  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:5vh;width:100vw'></iframe>
<iframe name='result_frame' id='result_frame'	  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='auto' style='height:48vh;width:100vw'></iframe>
<iframe name='sub_frame' id='sub_frame'	  src='../../eCommon/html/blank.html' frameborder=0 noresize scrolling='no'  style='height:30vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
<%
 }
	}
	catch(Exception e)
	 {
		//out.println("Exception in Pat Cat By Organization is:"+e.toString());
		e.printStackTrace();
		
	 }
	 finally
	 {
		ConnectionManager.returnConnection(conn,request);	
		stmt.close();
		rs.close();
     }

	%>

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

