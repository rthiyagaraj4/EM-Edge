<%@ page import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%
Connection con = null;
ResultSet rs=null;
try
{
	Properties p;
	p = (java.util.Properties) session.getValue( "jdbc" ) ;
	con = ConnectionManager.getConnection(request);
	Statement stmt = con.createStatement();

	Map hash = (Map)obj.parseXMLString( request ) ;
	hash = (Map)hash.get("SEARCH") ;

	//String steps					=(String) hash.get("steps");
	String steps					=request.getParameter("steps");
	if(steps ==null) steps="";

	if(steps.equals("1"))
	{
		//String patient_id		= (String) hash.get("patient_id");
		String patient_id		= request.getParameter("patient_id");
		if(patient_id==null)patient_id="";	

		String pat_cat_val      = "";
		
		String sql="SELECT a.PAT_CAT_CODE  FROM MP_PATIENT a ,MP_PAT_CATEGORY b WHERE b.GOVT_OR_PVT_IND = 'V' AND  a.PAT_CAT_CODE = b.PAT_CAT_CODE AND a.patient_id = '"+patient_id+"'";
		rs = stmt.executeQuery(sql) ;
		if(rs != null && rs.next())
			pat_cat_val = rs.getString("PAT_CAT_CODE");
			out.write(pat_cat_val);
	}

	if (rs !=null) rs.close();
	if (stmt !=null) stmt.close();
	if (hash !=null) hash.clear();
}
catch(Exception e)
{
	out.println(e.toString());
	e.printStackTrace();
}
finally{
	if(con !=null) ConnectionManager.returnConnection(con,request);
}
%>
