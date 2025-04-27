<!DOCTYPE html>
<html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eSM/js/FreqAccessFunc.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%



	Connection conn=null;
	try{
		request.setCharacterEncoding("UTF-8");
	conn = ConnectionManager.getConnection(request);
	ResultSet rs=null;
	Statement stmt = conn.createStatement();
	int count=0;
	String Log_user= (String) session.getValue("login_user");
	String responsibility_id= (String) session.getValue("responsibility_id");
	String submenu_id=request.getParameter("submenu_id");
	String Function_name=request.getParameter("Function_name");
	String p_menu_id=request.getParameter("menu_id");

	int i=0;
	int c=0;
	StringBuffer	sql_count =new StringBuffer();
				sql_count.append(" Select count(*) from sm_freq_func_by_user  ");
				sql_count.append(" where appl_user_id='"+Log_user+"' ");
				sql_count.append(" and resp_id='"+responsibility_id+"'");				
	rs=stmt.executeQuery(sql_count.toString());
	if(rs!=null)
	{
		while(rs.next())
		{
			c=rs.getInt(1);
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	}

	if(c<10)
	{
	StringBuffer	sql = new StringBuffer();
		sql.append("Select Distinct FUNCTION_ID, MODULE_ID,menu_id, OPTION_SEQUENCE_NO, ");
				sql.append(" OPTION_DESCRIPTOR from SM_MENU_DTL  where  ");
				sql.append(" option_type in ('F','R')   "); //Changed by S.Sathish for IN020879 on Monday, April 26, 2010
				sql.append(" and function_id not in (select function_id from sm_freq_func_by_user ");
				sql.append(" where appl_user_id='"+Log_user+"' ");
				sql.append(" and resp_id='"+responsibility_id+"')");
		try{
			if ((submenu_id!=null) && (!submenu_id.equals("")))
			{
				sql.append("  and  MENU_ID='"+submenu_id+"'  ");
				sql.append(" and FUNCTION_ID not in ( ");
				sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql.append(" where RESP_ID='"+responsibility_id+"' and ");
				sql.append(" MENU_ID='"+submenu_id+"'   ");
				sql.append(" and EXCL_RESTRICT_IND='E' ");
				sql.append("  )");
			}
			else
			{
				sql.append("  and  MENU_ID='"+p_menu_id+"'  ");
				sql.append(" and FUNCTION_ID not in ( ");
				sql.append(" Select FUNCTION_ID from SM_MENU_RSTRN_RESP_VW ");
				sql.append(" where RESP_ID='"+responsibility_id+"'  ");
				sql.append(" and EXCL_RESTRICT_IND='E' ");
				sql.append("  )");
			}
			if ((Function_name!=null) && (!Function_name.equals(""))){
			sql.append("  and upper(OPTION_DESCRIPTOR) like upper('"+Function_name+"%"+"')  ");
		}
		sql.append(" order by option_descriptor ");	
	stmt = conn.createStatement();	
	rs = stmt.executeQuery(sql.toString());
	}catch (Exception ce) {out.println("Here "+ce);}

try
{
%>
<script>
function callFunction()
{
	parent.frames[1].location.href='../../eSM/jsp/FreqAccessFunctionList.jsp'
}
</script>
<body onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
<form name='include_func' id='include_func' method=post ACTION='../../servlet/eSM.FreqAccessFuncServlet' target='messageFrame'   >
<table border="1" align='center' width="100%" cellspacing='0' cellpadding='0'>
<th align=left width='30%'><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/>&nbsp;&nbsp;&nbsp;&nbsp;</th>
<th align=left width='20%'>&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
<%
String classValue = "" ; 	 
while ( rs.next()  )  
{
	 if ( i % 2 == 0 )
	 	  	classValue = "QRYODD" ;
	 	  else
	 	  	classValue = "QRYEVEN" ;

	String name = rs.getString("OPTION_DESCRIPTOR"); 
	String id = rs.getString("function_id"); 
	String menu_id = rs.getString("menu_id"); 
	String option_sequence_no = rs.getString("option_sequence_no"); 
	String module_id = rs.getString("module_id"); 

	out.println("<tr width='100%'><td width='30%' class='"+classValue+"'  >");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;"+name+"</td><td class='"+classValue+"'   width='20%'  >");
	out.println("&nbsp;&nbsp;&nbsp;&nbsp;<input type='checkbox'  name=Incchkbox_val2 id=Incchkbox_val2' value="+id+"|"+menu_id+"|"+option_sequence_no+"|"+module_id+" ");
	out.println("</td></tr>");
i++;
	count++;
}
//Added by S.Sathish for IN020879 on Monday, April 26, 2010 starts here
if(count == 0)
{%>	
	<script>
		alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','COMMON'));	
		parent.frames[2].location.href="../../eCommon/html/blank.html";
	</script>
<%}
	//Ends here
if(rs!=null)rs.close();
if(stmt!=null)stmt.close();
%>



	</table>
<input type='hidden' name='nochbox' id='nochbox' value='<%=count%>'>
<input type='hidden' name='checkval' id='checkval'  >
<input type='hidden' name='Log_user' id='Log_user' value='<%=Log_user%>'>
<input type='hidden' name='responsibility_id' id='responsibility_id' value='<%=responsibility_id%>'>
<input type='hidden' name='operation' id='operation' value="insert">
<%
}
catch ( Exception e ){ out.println("Exception "+e);}

finally{
	
	if ( stmt != null ) stmt.close() ;
	if ( rs != null ) rs.close() ;

	}
}
else
{
	out.println("<script>alert(getMessage('FREQ_FUNCTION_LIMIT_10','SM'));</script>");
}
%>

</center>
</BODY>
<%
}catch(Exception e){out.println(e);}
			finally { 
	ConnectionManager.returnConnection(conn,request);
}	
%>
</form>
</body>
</HTML>

