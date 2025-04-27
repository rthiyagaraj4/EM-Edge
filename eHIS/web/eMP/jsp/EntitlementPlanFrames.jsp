<!DOCTYPE html>
<!-- 
	Query Criteria for Entitlement Plan
	Created		: 2/10/2006 11:08 AM
	Modified		: 2/10/2006 11:08 AM
	Created By	: Vinod Babu MV
	This function is allowed to be invoked, provided the Parameter 'Apply Eligibility Rules by Patient Category' are checked, otherwise give an appropriate error message 'Entitlement is not applicable - cannot use this function'.
 -->
<%@ page import="java.sql.*,java.util.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");
%>

<html>
<head>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<script src='../../eMP/js/EntitlementPlan.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	String url = "../../eCommon/jsp/MstCodeToolbar.jsp?";
	String params = request.getQueryString();
	String toolBar = url + params;
	String entitlement_by_pat_cat_yn = "";

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
<iframe name='commontoolbarFrame' id='commontoolbarFrame' src = <%=toolBar%> frameborder=0 scrolling='no'  style='height:8vh;width:100vw'></iframe>
<iframe name='f_query_add_mod' id='f_query_add_mod' src ='../../eCommon/html/blank.html' frameborder=0 style='height:83vh;width:100vw'></iframe>
<iframe name='messageFrame' id='messageFrame' src='../../eCommon/jsp/MstCodeError.jsp' frameborder=0 noresize scrolling='auto' style='height:9vh;width:100vw'></iframe>
</head>

<%
 }
	}
	catch(Exception e)
	 {
		out.println("Exception in Entitlement Plan is:"+e.toString());
		
	 }
	 finally
	 {
		ConnectionManager.returnConnection(conn,request);	
		stmt.close();
		rs.close();
     }

	%>

</html>

