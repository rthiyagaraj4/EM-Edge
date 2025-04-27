<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,webbeans.eCommon.*" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>


	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>

<%
request.setCharacterEncoding("UTF-8");
Connection con=null;
//Statement stmt = null;
PreparedStatement stmt=null;
ResultSet rs = null;
ResultSet termcodeRs = null;
Statement termcodeStmt = null;
try
{
String p_p_diag_code 		= 	checkForNull(request.getParameter("p_diag_code"));
String p_scheme				=	checkForNull(request.getParameter("p_scheme"));
String cause_indicator		=	checkForNull(request.getParameter("p_cause_indicator"));
String sensitive_yn			=	checkForNull(request.getParameter("p_sensitive_yn"));
String p_diag_code        	=   p_p_diag_code.trim();
String call_func        	=   checkForNull(request.getParameter("call_func"));
String cross_ref_type       =   checkForNull(request.getParameter("cross_ref_type"));
/*Tuesday, February 16, 2010 18717 , to filter terminology set a/c to cross ref type*/
if(call_func.equals("cross_ref_rule"))
{
	try
		{
			String termsetid = "";
			String termsetdesc = "";
			StringBuffer termcodeSql = new StringBuffer();
			
			con = ConnectionManager.getConnection(request);
			termcodeSql.append("select term_set_id,term_set_desc from MR_TERM_SET where eff_status='E'"); 
			if(!cross_ref_type.equals("EQ"))
				termcodeSql.append("and diag_spec_yn = 'Y'");
			termcodeSql.append("order by  term_set_desc");
			
			termcodeStmt = con.createStatement();
			termcodeRs = termcodeStmt.executeQuery( termcodeSql.toString() ) ;
			
			out.println("<script>");
			out.println("var obj =parent.frames[1].document.forms[0].terminology_set;");
			out.println("var length  = obj.length;");
			out.println("for(var i=0;i<length;i++) {obj.remove(1);}");
			if(termcodeRs!=null)
			{
				while(termcodeRs.next())
				{
					termsetid = termcodeRs.getString("term_set_id");
					termsetdesc = termcodeRs.getString("term_set_desc");
					out.println ("var opt= parent.frames[1].document.createElement('Option');\nopt.text=\""+termsetdesc+"\"; opt.value=\""+termsetid+"\";\nobj.add(opt)") ;
					out.println ("parent.frames[1].document.createElement('Option')") ;
				}
				if(termcodeRs!=null) termcodeRs.close();
				if(termcodeStmt!=null) termcodeStmt.close();
			}
			out.println("parent.frames[4].location.href='../../eCommon/jsp/MstCodeError.jsp'");
			out.println("</script>");

		}
		catch (Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();
		}
		finally
		{
			if(termcodeRs!=null) termcodeRs.close();
			if(termcodeStmt!=null) termcodeStmt.close();
			ConnectionManager.returnConnection(con,request);
		}
}/**/
else{
if (!(p_diag_code == null || p_diag_code.equals("null")||p_diag_code.length()==0))	
{
	//Connection con = (Connection) session.getValue("connection");

	con=ConnectionManager.getConnection(request);
	//stmt = con.createStatement();
	
	String p_diag_desc ="";
	String p_record_type ="";
	String p_sensitive_yn ="";
	
	StringBuffer sql = new StringBuffer("select short_desc, cause_indicator,sensitive_yn, record_type from mr_icd_code where diag_code=? and diag_code_scheme=?  ");
	if(p_scheme.equals("2"))
	sql.append(" and record_type='D'  and nvl(cause_indicator,'|')=nvl(?,'|') "); 

	stmt = con.prepareStatement(sql.toString());
	stmt.setString(1,p_diag_code);
	stmt.setString(2,p_scheme);
	if(p_scheme.equals("2"))
	stmt.setString(3,cause_indicator);
	rs = stmt.executeQuery();
	
	if (rs!=null && rs.next())
	{
		p_diag_desc 	= rs.getString("short_desc")==null?"":rs.getString("short_desc");
		p_sensitive_yn 	= rs.getString("sensitive_yn")==null?"":rs.getString("sensitive_yn");
		p_record_type 	= rs.getString("record_type")==null?"":rs.getString("record_type");
		
		StringBuffer a1= new StringBuffer("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"
		+"parent.frames[1].frames[0].document.forms[0].diag_desc.value=\""+p_diag_desc
		+"\";parent.frames[1].frames[0].document.forms[0].sensitive_yn.value='"+p_sensitive_yn
		+"';parent.frames[1].frames[0].document.forms[0].record_type.value='"+p_record_type
		+"';");

		a1.append("</script></head><body onKeyDown='lockKey()' CLASS='MESSAGE'></body></html>");
		
		if(!sensitive_yn.equals("Y"))
		{
			if(p_sensitive_yn.equals("Y"))
			{
				if ( a1.length() > 0) a1.delete(0,a1.length());
				a1.append("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body onKeyDown='lockKey()' CLASS='MESSAGE'>");
				a1.append("<script>alert(getMessage('INVALID_CA_USER','CA'));");
				a1.append("parent.frames[1].frames[0].document.forms[0].diag_code.value='';");
				a1.append("parent.frames[1].frames[0].document.forms[0].diag_desc.value='';");
				a1.append("parent.frames[1].frames[0].document.forms[0].diag_code.focus();");
				a1.append("parent.frames[1].frames[0].document.forms[0].diag_code.select(); </script></body>");
			}
		}
			out.println(a1.toString());			
	}
	else
	{
		out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE' onKeyDown='lockKey()'><script>alert(getMessage('INVALID_DIAG_CODE','MR'));parent.frames[1].frames[0].document.forms[0].diag_code.value='';parent.frames[1].frames[0].document.forms[0].diag_desc.value='';parent.frames[1].frames[0].document.forms[0].cause_indicator.value='';parent.frames[1].frames[0].document.forms[0].diag_code.focus();parent.frames[1].frames[0].document.forms[0].diag_code.select();</script></body>");
	}
}
else
out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body CLASS='MESSAGE' onKeyDown='lockKey()'><script>parent.frames[1].frames[0].document.forms[0].diag_desc.value='';</script></body>");
}//
}catch(Exception e)
{	
{out.println("<html><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><body onKeyDown='lockKey()' CLASS='MESSAGE'>"+e+"</body>"); }
}
finally
{
	try
	{
		if(rs != null)rs.close();
		if(stmt != null)stmt.close();
	}
	catch(Exception e)
	{
	}
	ConnectionManager.returnConnection(con,request);
}
%>
<%! public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

