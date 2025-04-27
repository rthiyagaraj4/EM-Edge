<!DOCTYPE html>
<%@ page import ="java.sql.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
//	Statement stmt=null;
	PreparedStatement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	
	try
	{

		con	=	ConnectionManager.getConnection(request);
		
		String event_class="",short_desc="";
		String query_event_class="";
		String hist_type	= 	request.getParameter("hist_type");

		if(hist_type==null) hist_type="";
		hist_type=hist_type.trim();

		out.println("<html><head>");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>");
		out.println("<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>");
		out.println("<script language='javascript'>");

		//query_event_class = "select EVENT_CLASS, long_desc SHORT_DESC from cr_event_class where 	hist_rec_type=? order by long_desc ";
		query_event_class = "select EVENT_CLASS, long_desc SHORT_DESC from CR_EVENT_CLASS_LANG_VW where hist_rec_type=? and language_id = ? order by long_desc";
		stmt = con.prepareStatement(query_event_class);
		stmt.setString(1,hist_type);
		stmt.setString(2,locale);
		rs = stmt.executeQuery();

		out.println("var event_class	= '';");
		out.println("var short_desc	= ' ------------------"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -----------------';");
		out.println("var opt = parent.frames[1].document.createElement('OPTION'); ");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	event_class; ");
		out.println("parent.frames[1].frames[2].document.forms[0].event_class_id.add(opt);");	
		while(rs.next())
		{
			
			event_class	=	rs.getString("event_class");
			short_desc	=	rs.getString("short_desc");
			
			out.println("var event_class	= \""+event_class+"\";");
			out.println("var short_desc	= \""+short_desc+"\";");
			out.println("var opt = parent.frames[1].document.createElement('OPTION'); ");
			out.println("opt.text	=	short_desc; ");
			out.println("opt.value	=	event_class; ");
			out.println("parent.frames[1].frames[2].document.forms[0].event_class_id.add(opt);");	

		}
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
		if(rs!=null) rs.close();
		if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body onKeyDown = 'lockKey()' CLASS='MESSAGE'>");
		out.println("Exception@1 : "+e.toString());
		out.println("</body></html>");
	}
	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	
%>


