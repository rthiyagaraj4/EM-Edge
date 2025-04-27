<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>

<script language='javascript' src='../../eDR/js/PossibleDuplicates.js'></script>
<script language='javascript' src='../../eDR/js/DuplicateRecord.js'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<%
	Connection con				= null;
	java.sql.Statement	stmt	= null;
	ResultSet	rs				= null;
try
{
	con = ConnectionManager.getConnection(request);
	stmt					=con.createStatement();

	String p_string_newval  = request.getParameter("p_string_newval");
	String p_mode  = request.getParameter("p_mode");
	if(p_mode==null) p_mode="";

	String p_string_val	    = request.getParameter("p_string_value");
	
	String p_old_val		= request.getParameter("p_old_value");

	String p_dup_group_id	= request.getParameter("p_dup_group_id");
	
	String have_for_delete = "";
	String p_function_name = request.getParameter("function_name");
	
	if (p_string_val == null) p_string_val = "";
		if (p_string_newval == null) p_string_newval = "";
			if (p_old_val == null) p_old_val = "";
				if (p_dup_group_id == null) p_dup_group_id  = "";

	String p_string_modval  = "";
	String p_concat_string  = "";

	

%>
<form name='addmoddelstring' id='addmoddelstring'>
<%
	// for modification during insert

		StringTokenizer token=new StringTokenizer(p_string_val,"~");

		while(token.hasMoreTokens())
		{
				p_concat_string     = token.nextToken() + '~';

				if (p_old_val.equals(p_concat_string))
				{
					p_string_modval = p_string_modval + p_string_newval ;
				}
				else
				{
					p_string_modval = p_string_modval + p_concat_string ;
			}
	
		}


%>
<script>
var stringval = "<%=p_string_modval%>";
var groupid  = "<%=p_dup_group_id%>" ;
if ( stringval.length != 0 )
	{
		parent.parent.frames[1].frames[0].document.forms[0].p_string_value.value = 
		"<%=p_string_modval%>";
		parent.parent.frames[1].frames[2].location.href = "../../eDR/jsp/EnterDuplicatesAddModifyPatId.jsp?p_string_val="+encodeURIComponent(stringval)+"&p_mode=modify+&function_name=<%=p_function_name%>&p_dupgroupid=<%=p_dup_group_id%>";
	}

</script>
<table>
	<input type=hidden name='mod_val_string' id='mod_val_string' value=''>
	<input type=hidden name='for_mod_val' id='for_mod_val' value=''>
	<input type=hidden name='delete_patient' id='delete_patient' value='<%=have_for_delete%>'>

</table>

</form>
<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

  

