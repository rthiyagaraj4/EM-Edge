<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<%
	request.setCharacterEncoding("UTF-8");
%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<%
	Statement stmt=null;
	ResultSet rs=null;
	String facilityid="", range_id="", long_desc="";
	String query_ref_source="";
	Connection con = null;
	facilityid	= 	request.getParameter("facility");
	if(facilityid==null) facilityid="";
	facilityid=facilityid.trim();

	out.println("<html><head>");
	out.println("<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>");
	out.println("<script language='javascript'>");
	
	out.println("var opt = parent.frames[1].document.createElement('OPTION'); ");
	out.println("opt.text	=	' ------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ------- ';");
	out.println("opt.value	=	''; " );
	out.println("parent.frames[1].document.forms[0].p_age_range_code.add(opt); ");
	out.println("parent.frames[1].document.forms[0].p_age_range_code.selectedIndex = 0;");
	
	try
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		query_ref_source = "select range_id, long_desc from am_summ_range_lang_vw where range_type='A' and language_id='"+localeName+"' and eff_status ='E' order by 2" ;

		rs = stmt.executeQuery(query_ref_source);

		int i = 1;
			while(rs.next())
			{
				i++;
				range_id	=	rs.getString("range_id");
				long_desc	=	rs.getString("long_desc");

				out.println("var range_id	= '"+range_id+"';");
				out.println("var long_desc	= '"+long_desc+"';");
				out.println("var opt = parent.frames[1].document.createElement('OPTION'); ");
				out.println("opt.text	=	long_desc; ");
				out.println("opt.value	=	range_id; ");			
				out.println("parent.frames[1].document.forms[0].p_age_range_code.add(opt); ");
			} // end of while
		 out.println("</script><Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'> </body></html>");
	} // end of try
	catch(Exception e)
	{
		out.println("</script></head><body CLASS='MESSAGE' onKeyDown='lockKey()'>");
		out.println("Exception@1 : "+e);
		out.println("</body></html>");
	}
	finally
	{
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	
%>

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

