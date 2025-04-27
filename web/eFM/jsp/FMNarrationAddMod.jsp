<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<head>
<!-- <link rel='stylesheet' type='text/css' href="../../eCommon/html/IeStyle.css"> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script src="../../eCommon/js/common.js" language='javascript'></script>
<script src="../../eFM/js/FMNarration.js"  language='javascript'></script>
</head>

<body OnMouseDown='CodeArrest()' onLoad="document.Narration_form.narrcode.focus()" onKeyDown = 'lockKey();'>

<%
	Connection conn = ConnectionManager.getConnection(request);
	String mode = request.getParameter( "operation" );

	Statement stmt=null;
	ResultSet rs=null;
	String sql = "";

	String narrCode		 = "";
	String narrShortDesc = "";
	String narrLongDesc	 = "";
	String narrEffStatus = "E";
	String chkEffStatus  = "checked";
	String make_readonly = "";
	String code_readonly = "";

	try
	{
		if (mode.equals("modify"))
		{
			narrCode = request.getParameter("NarrationCode");
			stmt = conn.createStatement();

			sql = "Select * From FM_NARRATION where NARRATION_CODE = '"+narrCode+"' ";
			rs = stmt.executeQuery(sql);

			if(rs.next())
			{
				narrShortDesc	= rs.getString("SHORT_DESC");	
				narrLongDesc	= rs.getString("LONG_DESC");	
				narrEffStatus	= rs.getString("EFF_STATUS");
			}

			if (narrEffStatus.equals("E"))
				chkEffStatus = "checked";
			else if (narrEffStatus.equals("D"))
			{
				chkEffStatus = "unchecked";
				make_readonly = "readonly"; 
			}
			code_readonly = "readonly";
		}
		else
			mode = "insert";
%>
	<form name='Narration_form' id='Narration_form' action='../../servlet/eFM.FMNarrationServlet' method='post' target='messageFrame' 
	style="width: 100%; height:70vh; border: 0; display: flex; align-items: center; justify-content: center; margin: 0 auto; padding: 0;"
    scrolling='no'>
	<br><br>
	<table border='0' cellpadding='5' cellspacing='0' width='80%' align='center'>
	<center>
	
		<tr>
			<td class='label' width='30%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
			<td width='70%' class='fields'><input type='text' name='narrcode' id='narrcode' size='8' maxlength='8' value='<%=narrCode%>' <%=code_readonly%> onBlur="ChangeUpperCase(this);" onKeyPress='return CheckForSpecChars(event);' >
			<img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
        </tr>
		<tr>
			<td class='label' width='30%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
			<td width='70%' class='fields'><input type='text' name='narrlongdesc' id='narrlongdesc' size='30' maxlength='30' onBlur="makeValidString(this);" value="<%=narrLongDesc%>" <%=make_readonly%> ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
        </tr>
		<tr>
			<td class='label' width='30%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></td>
			<td width='70%' class='fields'><input type='text' name='narrshortdesc' id='narrshortdesc' size='15' maxlength='15' value="<%=narrShortDesc%>" <%=make_readonly%> onBlur="makeValidString(this);" ><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
		</tr>
		<tr>
			<td class='label' width='30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
			<td width='70%' class='fields'><input type='checkbox' name='effstatus' id='effstatus' value='<%=narrEffStatus%>' <%=chkEffStatus%> ></td>
       </tr>
    </center>
	</table>
<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println(e);
	}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
<input type='hidden' name='operation' id='operation' value='<%=mode%>'>
</form>
</body>
</html>

