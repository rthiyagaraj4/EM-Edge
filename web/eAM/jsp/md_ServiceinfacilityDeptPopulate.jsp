<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<%
	request.setCharacterEncoding("UTF-8");
	String opfacilityid = request.getParameter("operating_facility_id");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	try
	{
		con = ConnectionManager.getConnection(request);
		String sql1=" select dept_code,dept_short_desc from am_facility_dept_vw where operating_facility_id = ? and eff_status = 'E' order by dept_short_desc" ;
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script language='javascript'>");
out.println("var element =parent.f_query_add_mod_query.f_query_add_mod_query.document.createElement('OPTION');"+"element.text ='-----"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"-----';"+"element.value= '';"+"parent.f_query_add_mod_query.f_query_add_mod_query.document.serviceinfacilityQuery_form.dept_code.add(element);");
	
		pstmt 	= con.prepareStatement(sql1) ;
		pstmt.setString	(	1,	opfacilityid		);
		rs = pstmt.executeQuery() ;
		String str1 = "";
		String str2 = "";
		if( rs != null ) 
		{
			while( rs.next() ) 
			{
				str1 = rs.getString( "dept_short_desc" ) ;
				str2 = rs.getString( "dept_code" );
				out.println(	"var element = parent.f_query_add_mod_query.f_query_add_mod_query.document.createElement('OPTION');"+"element.text = \""+str1+"\";"+ "element.value= \""+str2+"\";"+"parent.f_query_add_mod_query.f_query_add_mod_query.document.serviceinfacilityQuery_form.dept_code.add(element);");
			}
		}

		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>");	
		}
		catch(Exception e)
		{}
		finally
		{
			try
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
			}
			catch(Exception e)
			{}

			ConnectionManager.returnConnection(con,request);
		}
%>
	

