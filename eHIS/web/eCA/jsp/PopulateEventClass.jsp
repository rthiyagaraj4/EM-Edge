<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%

	request.setCharacterEncoding("UTF-8");
			Properties p = (Properties)session.getValue("jdbc");
		String locale	= (String) p.getProperty("LOCALE");

	PreparedStatement stmt=null;
	ResultSet rs=null;
	Connection con = null;
	
	String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	
	try
	{

		con	=	ConnectionManager.getConnection(request);
	
		String event_class="",short_desc="";
		String query_event_class="";
		String hist_type	= 	request.getParameter("hist_type");
		String event_called=request.getParameter("event_called")==null?"":request.getParameter("event_called");	
		String event_class_defaulted=request.getParameter("event_class_defaulted")==null?"":request.getParameter("event_class_defaulted");
		

		if(hist_type==null) hist_type="";
		hist_type=hist_type.trim();

		out.println("<html><head>");
		out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
		out.println("<script src='../../eCommon/js/common.js' language='javascript'></script>");
		out.println("<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>");
		out.println("<script language='javascript'>");
				
//		stmt = con.createStatement();
		/*if(hist_type.equals("CLNT"))
		{
			query_event_class = "select EVENT_CLASS, SHORT_DESC from ca_event_class where event_class in ('PHY$', 'NUR$', 'CLI$', 'REF$')";
		}
		else if(hist_type.equals("SUNT"))
		{
			query_event_class = "select EVENT_CLASS, SHORT_DESC from ca_event_class where event_class in ('PROC')";
		}

		else
		{
			query_event_class = "select  service_code event_class, short_desc from AM_SERVICE order by short_desc";
		}*/
		
//		query_event_class = "select EVENT_CLASS, long_desc SHORT_DESC from cr_event_class where hist_rec_type='"+hist_type+"' order by long_desc ";
//		rs = stmt.executeQuery(query_event_class);

		query_event_class = "select EVENT_CLASS, long_desc, SHORT_DESC from CR_EVENT_CLASS_LANG_VW where hist_rec_type=? and language_id = ? order by long_desc ";
		stmt = con.prepareStatement(query_event_class);
		stmt.setString(1,hist_type);
		stmt.setString(2,locale);
		rs = stmt.executeQuery();

		out.println("var event_class	= '';");
		out.println("var short_desc	= '---------" +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ----------'; ");
		out.println("if(top.content!=null&& top.document.getElementById('dialog-body') == null){");
		out.println("var opt=top.content.workAreaFrame.criteria_f1.document.createElement('OPTION'); ");
		out.println("}else{");
		if(!event_called.equals(""))
		{
			out.println("var opt=parent.criteria_f0.criteria_f1.document.createElement('OPTION'); ");
		}
		else
		{
			out.println("var opt=top.parent.frames[1].criteria_f1.document.createElement('OPTION'); ");
		}
		out.println("}");
		out.println("opt.text	=	short_desc; ");
		out.println("opt.value	=	event_class; ");
		out.println("if(top.content!=null&& top.document.getElementById('dialog-body') == null){");
		out.println("top.content.workAreaFrame.criteria_f1.document.forms[0].event_class.add(opt); ");
		out.println("top.content.workAreaFrame.criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		out.println("}else{");		
		//out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		//out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		if(!event_called.equals("")){
		out.println("parent.criteria_f0.criteria_f1.document.forms[0].event_class.add(opt); ");
		out.println("parent.criteria_f0.criteria_f1.document.forms[0].event_class.selectedIndex = 0;");
		}
		else{

			out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.add(opt); ");
			out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.selectedIndex = 0;");

		}
		
		out.println("}");
		
		
		while(rs.next())
		{
			
			event_class	=	rs.getString("event_class");
			short_desc	=	rs.getString("short_desc");

			out.println("var event_class	=\""+event_class+"\";");
			out.println("var short_desc	=\""+short_desc+"\";");
			out.println("if(top.content!=null && top.document.getElementById('dialog-body') == null){");
			out.println("var opt = top.content.workAreaFrame.criteria_f1.document.createElement('OPTION'); ");
			out.println("}else{");
			if(!event_called.equals(""))
				out.println("var opt = parent.criteria_f0.criteria_f1.document.createElement('OPTION'); ");
			else
				out.println("var opt = top.parent.frames[1].criteria_f1.document.createElement('OPTION'); ");
			out.println("}");
			out.println("opt.text	=	short_desc; ");
			out.println("opt.value	=	event_class; ");
			if(event_class_defaulted.equals(event_class))
				out.println("opt.selected='selected'");

			out.println("if(top.content!=null && top.document.getElementById('dialog-body') == null){");
			out.println("top.content.workAreaFrame.criteria_f1.document.forms[0].event_class.add(opt); ");
			out.println("}else{");
			if(!event_called.equals(""))
			out.println("parent.criteria_f0.criteria_f1.document.forms[0].event_class.add(opt); ");
			else
			out.println("top.parent.frames[1].criteria_f1.document.forms[0].event_class.add(opt); ");
			out.println("}");
		} // end of while
		
		out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
	
	
	if(rs!=null) rs.close();
	if(stmt!=null)	stmt.close();
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body onKeyDown='lockKey()' CLASS='MESSAGE'>");
	//	out.println("Exception@1 : "+e);
               	e.printStackTrace();//COMMON-ICN-0181
		out.println("</body></html>");
	}
	finally
	{
		
		if(con!=null)ConnectionManager.returnConnection(con, request);
	}
	
%>

