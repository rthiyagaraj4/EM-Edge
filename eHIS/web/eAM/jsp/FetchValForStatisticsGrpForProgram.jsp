<!DOCTYPE html>
<%--
	FileName	: FetchValForStatisticsGrpForProgram.jsp
	Version	    : 3	
	Modified On	: 23-2-2005 , 7-3-2008
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<%
	String sStyle =
	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>
<%@ page contentType="text/html;charset=UTF-8" import="java.sql.*, java.util.*, java.text.*, java.net.*,webbeans.eCommon.*" %>

<%
//String facility_Id = (String) session.getValue("facility_id");
request.setCharacterEncoding("UTF-8");
String Program_type = request.getParameter("Prog_type");
String Module_id = request.getParameter("Mod_id");

Connection conn = null;
Statement stmt=null;
ResultSet rset=null;
String sql1="";
String sql2="";

try
{
	conn = ConnectionManager.getConnection(request);
	stmt = conn.createStatement();
	if(Program_type.equals("F"))
	{
		sql1 = "SELECT function_name,function_id from SM_FUNCTION where module_id='"+Module_id+"' order by function_name ";
		rset = stmt.executeQuery(sql1);
			
	}
	else if(Program_type.equals("R"))
	{
		sql2 = "SELECT report_desc,report_id from SM_REPORT where module_id='"+Module_id+"' order by report_desc ";
		rset = stmt.executeQuery(sql2);
		
	}

String a1="<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"+"</script><script language='javascript' src='../../eCommon/js/ValidateControl.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script></head><body CLASS='MESSAGE' onKeyDown = 'lockKey()'></body></html>";

out.println(a1);
/*out.println("<html><head>		<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link><script>"+"</script></head><body CLASS='MESSAGE'>");*/

%>

<script>
	//alert(parent.frames[1].document.forms[0].Location.options.length);
	var n=parent.frames[1].document.forms[0].program.options.length;
	
	for(var i=0;i<n;i++)
	{
		parent.frames[1].document.forms[0].program.remove("Program");
	}
	//var tp =" ----- "+getLabel("Common.defaultSelect.label","Common")+" ----- ";
	var tp ="----------"+ new Array(parent.frames[1].getLabel("Common.defaultSelect.label","Common"))+"----------";
	var opt=parent.frames[1].document.createElement("OPTION");
	opt.text=tp;
	opt.value="";
	parent.frames[1].document.forms[0].program.add(opt);

	</script>

<%	if(rset != null)
	{
	String desc="";
	String code="";
	
		while( rset.next() )
		{
			if(Program_type.equals("F"))
			{
			 desc= rset.getString("function_name") ;
			 code= rset.getString("function_id") ;
			}
			else  if(Program_type.equals("R"))
			{
			 desc= rset.getString("report_desc") ;
			 code= rset.getString("report_id") ;
			}
			code.replace('\n',' ');
			desc.replace('\n',' ');
%>
	<script>
		var element = parent.frames[1].document.createElement('OPTION');
		element.value=  "<%=code%>";
		element.text= "<%=desc%>";
		parent.frames[1].document.forms[0].program.add(element);
	</script>
<%
		}
	}
	//out.println("</form></body></html>");
	if(rset!=null) rset.close();
    if(stmt!=null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception :"+e);
}
finally
	{
	try
	{
if(rset!=null) rset.close();
if(stmt!=null) stmt.close();
	}
	catch(Exception e)
		{}
ConnectionManager.returnConnection(conn,request);
}

	
%>


