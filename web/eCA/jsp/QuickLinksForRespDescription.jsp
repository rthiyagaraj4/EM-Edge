<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%

	request.setCharacterEncoding("UTF-8");
	PreparedStatement stmt = null;
	ResultSet rs = null;
	Connection con = null;
	
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
	try
	{
		con	= ConnectionManager.getConnection(request);
	
		String function_id	= "";
		String ql_type		= "";
		String short_desc	= "";
		String desc_id	= "";
		StringBuffer sqlQuery	= new StringBuffer();
		
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<script language='javascript'>");
		
		ql_type = request.getParameter("ql_type") == null ? "" : request.getParameter("ql_type");
		function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");

		sqlQuery.append("select QUICK_LINK_REF, QUICK_LINK_DESCRIPTION from SM_QUICK_LINK_LIST where QUICK_LINK_TYPE = ? and eff_STATUS = 'E'");
		
		if(!function_id.equals(""))
		{
			sqlQuery.append(" and OPTION_ID = ? ");
		}
		
		stmt = con.prepareStatement(sqlQuery.toString());
		stmt.setString(1,ql_type);
		if(ql_type.equals("QF"))
			stmt.setString(2,function_id);
		rs = stmt.executeQuery();

		out.println("var desc_id	= '';");
		out.println("var short_desc	= '---------" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----------'; ");
		out.println("var opt=parent.f_query_add_mod.document.createElement('OPTION'); ");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	desc_id; ");
		out.println("parent.f_query_add_mod.document.forms[0].desc.add(opt); ");
		out.println("parent.f_query_add_mod.document.forms[0].desc.selectedIndex = 0;");
			
		while(rs.next())
		{
			
			desc_id	=	rs.getString("QUICK_LINK_REF");
			short_desc	=	rs.getString("QUICK_LINK_DESCRIPTION");

			out.println("var desc_id	=\""+desc_id+"\";");
			out.println("var short_desc	=\""+short_desc+"\";");
			out.println("var opt = parent.f_query_add_mod.document.createElement('OPTION'); ");
			out.println("opt.text	=	short_desc; ");
			out.println("opt.value	=	desc_id; ");
			out.println("parent.f_query_add_mod.document.forms[0].desc.add(opt); ");
		} // end of while
		
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body onKeyDown='lockKey()' CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
	
		if(rs!=null) rs.close();
		if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body onKeyDown='lockKey()' CLASS='MESSAGE'>");
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
		e.printStackTrace();//COMMON-ICN-0181
		out.println("</body></html>");
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	
%>

