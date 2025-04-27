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
	
		String desc_id		= "";
		String short_desc	= "";
		StringBuffer sqlQuery	= new StringBuffer();
		StringBuffer sb			= new StringBuffer();
		
		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
		out.println("<script src='ValidateControl.js' language='javascript'></script>");
		out.println("<script language='javascript'>");
		
		sqlQuery.append("select quick_link_ref, QUICK_LINK_TYPE, quick_link_description, A.OPTION_ID, NVL(A.EXTERNAL_URL_APPL, B.EXECUTABLE_NAME) EXECUTABLE_NAME from sm_quick_link_list A, CA_OPTION B where A.eff_STATUS='E' AND A.GLOBAL_YN='Y' AND B.OPTION_ID(+)=A.OPTION_ID AND NVL(A.EXTERNAL_URL_APPL, B.EXECUTABLE_NAME)  IS NOT NULL order by 2 ");
		
		stmt = con.prepareStatement(sqlQuery.toString());
		rs = stmt.executeQuery();

		sb.append("<table id=tooltiptable1 cellpadding=0 cellspacing=0 border=0 class=BOX width=100% height=100% align=center>");
		
			
		while(rs.next())
		{
			short_desc	=	rs.getString("QUICK_LINK_DESCRIPTION");
			desc_id = rs.getString("OPTION_ID") + "|" + rs.getString("QUICK_LINK_TYPE") + "|"+ rs.getString("quick_link_description") + "|" + rs.getString("EXECUTABLE_NAME");

			sb.append("<tr>");
			sb.append("<td><a href=javascript:loadFunction(\""+desc_id+"\")>"+short_desc+"</a></td>");
			sb.append("</tr>");
		}
		sb.append("</table>");
		out.println("alert('"+sb.toString()+"');");
		out.println("parent.CommonToolbar.t.innerHTML = '"+sb.toString()+"'");
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body onKeyDown='lockKey()' CLASS='MESSAGE'> </body></html>");
	
		if(rs!=null) rs.close();
		if(stmt!=null)	stmt.close();
	}
	catch(Exception e)
	{
		out.println("</script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'>");
		//out.println("Exception@1 : "+e);//COMMON-ICN-0181
                 e.printStackTrace();//COMMON-ICN-0181
		out.println("</body></html>");
	}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	
%>

