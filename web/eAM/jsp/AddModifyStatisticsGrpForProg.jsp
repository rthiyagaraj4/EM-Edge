<!DOCTYPE html>
<%--
	FileName	: AddModifyStatisticsGrpForProg.jsp
	Version	    : 3	
	Modified On	: 23-2-2005 , 7-3-2008
--%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*,eCommon.XSSRequestWrapper" %>

<%request.setCharacterEncoding("UTF-8");
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");%>

<%@ page contentType="text/html;charset=UTF-8" import="webbeans.eCommon.*,java.sql.*, java.util.*, java.text.*" %>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
    <script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
  	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<script language="javascript" src="../../eAM/js/StatisticsGroupForProgram.js"></script>
</head>
<script>
function PopulateGroup(obj)
{
	var sel = obj.value;
	var mod = parent.frames[1].document.forms[0].module.value;
	if(mod == "")
	{
	   alert("APP-PH0001 Module Should be Selected Before Selecting Program Type");
	   parent.frames[1].document.forms[0].program_type.value = "";
	}
	if(sel == "")
	{
		var n=parent.frames[1].document.forms[0].program.options.length;
	
		for(var i=0;i<n;i++)
		{
		parent.frames[1].document.forms[0].program.remove("Program");
		}
		//var tp =" ----- Select ----- ";
		var tp = "-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
		var opt=parent.frames[1].document.createElement("OPTION");
		opt.text=tp;
		opt.value="";
		parent.frames[1].document.forms[0].program.add(opt);
	}
	if(sel != "" && mod != "")
	{
	var HTMLVal = "<html><body onKeyDown = 'lockKey()'><form name=DummyLocation method=post action='../../eAM/jsp/FetchValForStatisticsGrpForProgram.jsp?Prog_type="+sel+"&Mod_id="+mod+"'> </form></body></html>";

	parent.frames[2].document.body.insertAdjacentHTML('afterbegin',HTMLVal);
	parent.frames[2].document.forms[0].submit();
	}
}
function RefreshPrograms()
{
	parent.frames[1].document.forms[0].program_type.value = "";
	parent.frames[1].document.forms[0].statistics_group.value = "";
	var n=parent.frames[1].document.forms[0].program.options.length;
	
	for(var i=0;i<n;i++)
	{
		parent.frames[1].document.forms[0].program.remove("Program");
	}
	//var tp =" ----- Select ----- ";
	var tp = "-----"+getLabel("Common.defaultSelect.label","Common")+"-----";
	var opt=parent.frames[1].document.createElement("OPTION");
	opt.text=tp;
	opt.value="";
	parent.frames[1].document.forms[0].program.add(opt);
}
</script>
<body OnMouseDown="CodeArrest()" onLoad="FocusFirstElement();" onKeyDown = 'lockKey()'>
<%
   Connection conn = null;
   Statement stmt=null;
   PreparedStatement pstmt = null;
   ResultSet rset=null;

   Statement stmt1=null;
   ResultSet rset1=null;
   Statement stmt2=null;
   ResultSet rset2=null;
try{
   conn = ConnectionManager.getConnection(request);
   //String codeTextAttribute="";
   //String sql="";

   String choose = "";
   String mod_id = "";
   //String mod_name = "";
   //String stat_id = "";
   //String stat_desc = "";
   String module_id = "";
   String module_name = "";
   String program_id = "";
   String program_type = "";
   String program_name = "";
   String stat_grp_id = "";
   String stat_grp_name = "";
   String sequence_number = "";
   String mysql = "";

   stmt = conn.createStatement();
   String operation  = request.getParameter("operation");
   if(operation == null || operation.equals("null")) operation = "";
   
   if(operation.equals("modify"))
   {
		module_id  = request.getParameter("module_id");
		if(module_id == null || module_id.equals("null")) module_id = "";
  
		module_name = request.getParameter("module_name");
		if(module_name == null || module_name.equals("null")) module_name = "";

		program_id = request.getParameter("program_id");
		if(program_id == null || program_id.equals("null")) program_id = "";

		program_type = request.getParameter("program_type");
	    if(program_type == null || program_type.equals("null")) program_type = "";

		program_name = request.getParameter("program_name");
		if(program_name == null || program_name.equals("null")) program_name = "";

        stat_grp_id = request.getParameter("stat_grp_id"); 
	    if(stat_grp_id == null || stat_grp_id.equals("null")) stat_grp_id = "";

		stat_grp_name = request.getParameter("stat_grp_desc"); 
		if(stat_grp_name == null || stat_grp_name.equals("null")) stat_grp_name = "";

		sequence_number = request.getParameter("sequence_number");
		if(sequence_number == null || sequence_number.equals("null")) sequence_number = "";

		mysql= "select a.module_id, a.program_id, c.report_desc, a.program_type, a.sequence_no,a.stat_grp_id, b.stat_grp_desc,d.module_name from am_stat_grp_for_program a, am_stat_group b, sm_report c, sm_module d where a.stat_grp_id = b.stat_grp_id and a.program_id = c.report_id and a.module_id = d.module_id and a.program_type = 'R' and a.module_id = ? and a.program_id = ? and a.stat_grp_id = ? and d.module_name = ? and b.stat_grp_desc = ? and c.report_desc = ? UNION ALL select a.module_id, a.program_id,c.function_name, a.program_type, a.sequence_no,a.stat_grp_id,b.stat_grp_desc,d.module_name from am_stat_grp_for_program a, am_stat_group b, sm_function c, sm_module d where a.stat_grp_id = b.stat_grp_id and a.program_id = c.function_id and a.module_id = d.module_id and a.program_type = 'F'and a.module_id = ? and a.stat_grp_id = ? and d.module_name = ? and b.stat_grp_desc = ? and c.function_name = ?";
		//rset = stmt.executeQuery(mysql);
		 
		pstmt   = conn.prepareStatement(mysql);
		pstmt.setString	(	1,	module_id		);
		pstmt.setString	(	2,	program_id		);
		pstmt.setString	(	3,	stat_grp_id		);
		pstmt.setString	(	4,	module_name		);
		pstmt.setString	(	5,	stat_grp_name		);
		pstmt.setString	(	6,	program_name		);
		pstmt.setString	(	7,	module_id		);
		pstmt.setString	(	8,	stat_grp_id		);
		pstmt.setString	(	9,	module_name		);
		pstmt.setString	(	10,	stat_grp_name		);
		pstmt.setString	(	11,	program_name		);

		rset		 = pstmt.executeQuery();
		while(rset != null && rset.next())
	    {
			module_id       = rset.getString("module_id");
			module_name     = rset.getString("module_name");
			program_id      = rset.getString("program_id");
			program_type    = rset.getString("program_type");
			stat_grp_name   = rset.getString("stat_grp_desc");
			sequence_number = rset.getString("sequence_no");
			stat_grp_id     = rset.getString("stat_grp_id");

			if(module_id == null || module_id.equals("null")) module_id = "";
			if(module_name == null || module_name.equals("null")) module_name = "";
			if(program_id == null || program_id.equals("null")) program_id = "";
			if(program_type == null || program_type.equals("null")) program_type = "";
			if(stat_grp_name == null || stat_grp_name.equals("null")) stat_grp_name = "";
			if(sequence_number == null || sequence_number.equals("null")) sequence_number = "";
			if(stat_grp_id == null || stat_grp_id.equals("null")) stat_grp_id = "";
		}
		if (rset != null)   rset.close();
		if (stmt != null) stmt.close();
   }
%>
    <form name="StatisticsGroupForProgram_form" id="StatisticsGroupForProgram_form" action="../../servlet/eAM.StatisticsGrpForProgServlet" method="post" target="messageFrame">
    <div align="left">
    <BR><BR><BR><BR><BR><BR><BR><BR>
    <table border="0" cellpadding="0" cellspacing="0" align='center' width='auto'>
    <!-- <tr>
    	<td width='10%'>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<td width='10%'>&nbsp;</td>
    </tr> -->
	<tr>
      	<!-- <td>&nbsp;</td> -->
	    <td  class="label"><fmt:message key="Common.Module.label" bundle="${common_labels}"/></td>
	    <td class='fields'>&nbsp;
		<% if(operation.equals("insert")) { %>
		<select name='module' id='module' onChange='RefreshPrograms();'>
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
			stmt1=conn.createStatement();
			rset1=stmt1.executeQuery("SELECT module_id,module_name FROM sm_module WHERE install_yn = 'Y' ORDER BY 2 ");

			if(rset1!=null)
			{
			   while(rset1.next())
			   {
				String modulename = rset1.getString("module_name");
				String moduleid = rset1.getString("module_id");
				if(moduleid.equals(mod_id))
				    choose="selected";
				else
				    choose="";
				out.println("<option value='"+moduleid+ "' "+choose+">"+modulename+"</option>");
			   }
			}
			if (rset1 != null)   rset1.close();
		    if (stmt1 != null) stmt1.close();
	   %>
	  </select>
		<%} else {%>
			<input type='hidden' name='module' id='module' value='<%=module_id%>' >
			<input type='text' name='module_name' id='module_name' size='30' value="<%=module_name%>" READONLY>
		<% } %>
	   <img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	 	<!-- <td>&nbsp;</td> -->
	</tr>
    <tr>
    	<!-- <td width='10%'>&nbsp;</td> -->
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<!-- <td width='10%'>&nbsp;</td> -->
    </tr>
	<tr>
      	<!-- <td>&nbsp;</td> -->
	    <td  class="label"><fmt:message key="eAM.ProgramType.label" bundle="${am_labels}"/></td>
	    <td class='fields'>&nbsp;
		<% if(operation.equals("insert")) { %>
		<select name='program_type' id='program_type' onChange='PopulateGroup(this);'>
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<option value='F'><fmt:message key="Common.Function.label" bundle="${common_labels}"/></option>
		<option value='R'><fmt:message key="Common.report.label" bundle="${common_labels}"/></option>
  	    </select>
		<%} else {%>
			<input type='hidden' name='program_type' id='program_type' value='<%=program_type%>' >
			<input type='text' size='10' name='program_desc' id='program_desc' value='<%if(program_type.equals("R")) out.println("Report"); else out.println("Function");%> ' READONLY>
		<%} %>
		<img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	    <!-- <td>&nbsp;</td> -->
	</tr>
    <tr>
    	<!-- <td width='10%'>&nbsp;</td> -->
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<!-- <td width='10%'>&nbsp;</td> -->
    </tr>
	<tr>
      	<!-- <td>&nbsp;</td> -->
	    <td  class="label"><fmt:message key="Common.Program.label" bundle="${common_labels}"/></td>
	    <td class='fields'>&nbsp;
		<% if(operation.equals("insert")) { %>
		<select name='program' id='program'>
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
  	    </select>
		<%} else { %>
			<input type='hidden' name='program' id='program' value='<%=program_id%>'>
			<input type='text' size='55' maxlength='60' name='program_name' id='program_name' value="<%=program_name%>" READONLY>
		<% } %>
		<img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	    <!-- <td>&nbsp;</td> -->
	</tr>
    <tr>
    	<!-- <td width='10%'>&nbsp;</td> -->
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<!-- <td width='10%'>&nbsp;</td> -->
    </tr>
	<tr>
      	<!-- <td>&nbsp;</td> -->
	    <td  class="label"><fmt:message key="Common.StatisticsGroup.label" bundle="${common_labels}"/></td>
	    <td class='fields'>&nbsp;
		<% if(operation.equals("insert")) { %>
		<select name='statistics_group' id='statistics_group'>
		<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
		<%
			stmt2=conn.createStatement();
			rset2=stmt2.executeQuery("SELECT stat_grp_id, stat_grp_desc FROM am_stat_group ORDER BY 2 ");

			if(rset2!=null) 			{ 
			   while(rset2.next()) 			   {
				String statgrpdesc = rset2.getString("stat_grp_desc");
				String statgrpid = rset2.getString("stat_grp_id");
				if(statgrpid.equals(stat_grp_id))
				    choose="selected";
				else
				    choose="";
				out.println("<option value='"+statgrpid+ "' "+choose+">"+statgrpdesc+"</option>");
			   }
			}
			if (rset2 != null)   rset2.close();
		    if (stmt2 != null) stmt2.close();
	   %>
	  </select>
		<%} else {%>
			<input type='hidden' name='statistics_group' id='statistics_group' value='<%=stat_grp_id%>' >
			<input type='text' onBlur='makeValidString(this)'  name='statistics_group_name' id='statistics_group_name' size='20' value="<%=stat_grp_name%>" READONLY>
		<% } %>
	   <img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	 	<!-- <td>&nbsp;</td> -->
	</tr>
    <tr>
    	<!-- <td width='10%'>&nbsp;</td> -->
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<!-- <td width='10%'>&nbsp;</td> -->
    </tr>
	<tr>
      	<!-- <td>&nbsp;</td> -->
	    <td  class="label"><fmt:message key="eAM.SequenceNumber.label" bundle="${am_labels}"/></td>
	    <td class='fields'>&nbsp;
		<% if(operation.equals("insert")) { %>
		<input type='text' name='seq_num' id='seq_num' size='3' maxlength='3' value='' onkeypress="return allowValidNumber(this, event, 3, 0)" onBlur='CheckPositiveNumber(this);'>
		<%} else {%>
		<input type='hidden' name='s_grp' id='s_grp' value=''>
		<input type='text' name='seq_num' id='seq_num' size='3' maxlength='3' value='<%=sequence_number%>' onBlur='CheckNum(this);' onkeypress="return allowValidNumber(this, event, 3, 0)" READONLY>
		<% } %>
		<img src="../../eCommon/images/mandatory.gif" align='center'></img></td>
	 	<!-- <td>&nbsp;</td> -->
	</tr>
	<tr>
    	<!-- <td width='10%'>&nbsp;</td> -->
    	<td>&nbsp;</td>
    	<td>&nbsp;</td>
    	<!-- <td width='10%'>&nbsp;</td> -->
    </tr>
	</table>
   	</div>
   	<input type='hidden' name='function' id='function' value='<%=operation%>'>
   	<input type='hidden' name='function_name' id='function_name' value='<%=operation%>'>

</form>
<% }catch(Exception e){
	//out.println("Exception :"+e);
	e.printStackTrace();
	}
finally{
	try{
	if(stmt1!=null) stmt1.close();
	if(stmt2!=null) stmt2.close();
	if(rset1!=null) rset1.close();
	if(rset2!=null) rset2.close();
	}
	catch(Exception e)
	{}
	ConnectionManager.returnConnection(conn,request);
}
%>
</body>
</html>

