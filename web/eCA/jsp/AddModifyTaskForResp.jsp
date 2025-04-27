<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con=null;


String sql="";

String resp_id="";
String pract_reln_id="";
String facility_id="";
String privilege_status="";

String dis="";
String mode="";
String enable_checked="";

String srl_no=request.getParameter("srl_no");
if(srl_no==null) srl_no="";

String appl_task_id=request.getParameter("appl_task_id");
if(appl_task_id==null) 
{
	appl_task_id="";
	mode="insert";
	enable_checked="checked";
}
else
	mode="modify";

try
{
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	con=ConnectionManager.getConnection(request);
 if(!mode.equals("insert"))
	{
		dis="disabled";
		sql=" Select  appl_task_id, resp_id, pract_reln_id, facility_id, privilege_status from ca_appl_task_for_resp_reln where appl_task_id=? and srl_no=? ";
		pstmt=con.prepareStatement(sql);
		pstmt.setString(1,appl_task_id);
		pstmt.setString(2,srl_no);

		rs=pstmt.executeQuery();
		if(rs!=null)
		{
			while(rs.next())
			{
				appl_task_id=rs.getString("appl_task_id");
				resp_id=rs.getString("resp_id");
				pract_reln_id=rs.getString("pract_reln_id");
				if(pract_reln_id==null) pract_reln_id="";
				facility_id=rs.getString("facility_id");
				if(facility_id==null) facility_id="";
				
				privilege_status=rs.getString("privilege_status");
				if(privilege_status.equals("A"))
					enable_checked="checked";
				else 
				{
					enable_checked="";
				}
			}
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}
%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>

<script language='javascript' src='../js/TaskForResp.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function PopulateValues()
{
	delete_values(parent.frames[1].document.forms[0].pract_reln_id,parent.frames[1].document.forms[0].facility_id);
	var resp_id=document.forms[0].resp_id.value;
	var HTMLVal = "<HTML><HEAD><link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' /></HEAD><BODY onKeyDown='lockKey()' CLASS='MESSAGE'><form name='form1' id='form1' method='post' action='PopulateTaskForResp.jsp?resp_id="+resp_id+"'></form></BODY></HTML>";
	parent.messageFrame.document.write(HTMLVal);
	parent.messageFrame.document.forms[0].submit();
}
   function delete_values(field,facil)
	{
			var selected = field;
			var facility =facil;
			while ( selected.options.length > 0 )
			{
				selected.remove(selected.options[0]);
			}
			while(facility.options.length > 0)
			{
				facility.remove(facility.options[0]);
			}
			var opt=parent.frames[1].document.createElement("Option");
			opt.text="------------Select------------"
			opt.value="";
			field.add(opt);
			var opt1=parent.frames[1].document.createElement("Option");
			opt1.text="------------Select------------"
			opt1.value="";
			facil.add(opt1);
	}
</script>
</head>
<body  class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown ='lockKey()' onload='FocusFirstElement()'>
<form name="TaskForResp_form" id="TaskForResp_form" action="../../servlet/eCA.TaskForRespServlet" method="post" target="messageFrame">
<br><br><br><br><br><br><br><br>
<table border=0 cellspacing=0 cellpadding=0 width='85%' align=center>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
<tr>
	<td class=label align=right>Task</td>
	<td align=left>&nbsp;<select name=appl_task_id <%=dis%>>
	<option value=''>------------------------------------Select------------------------------------</option>
		<%
		PreparedStatement stmt1=null;
		ResultSet rs1=null;
		String id="";
		String dat="";
		String sel="";
		try
		{
			String  sql1=" Select appl_task_desc, appl_task_id from ca_appl_task where SPLTY_SPEC_YN = 'N'  order by 1 ";
			stmt1=con.prepareStatement(sql1);
			rs1=stmt1.executeQuery();
			if(rs1!=null)
			{
				while(rs1.next())
				{
					dat=rs1.getString(1);
					id=rs1.getString(2);
					if(id.equals(appl_task_id))
						sel="selected";
					out.println("<option value='"+id+"' "+sel+">"+dat+"</option>");
					sel="";
				}
			}
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
		}
		catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		
	%>

	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr><td>&nbsp</td><td></td></tr>
	<tr>
	<td class=label align=right>Responsibility</td>
	<td align=left>&nbsp;<select name=resp_id onchange='PopulateValues()'%=dis%>>
	<option value=''>------------------Select------------------</option>
	<%
		ResultSet rs2=null;
		String id2="";
		String dat2="";
		String sel2="";
		try
		{
			String  sql2=" Select resp_name,resp_id from sm_resp where eff_status='E' and nvl(eff_date_from,trunc(sysdate))<=trunc(sysdate) and nvl(eff_date_to,trunc(sysdate))>=trunc(sysdate) order by resp_name ";
			stmt1=con.prepareStatement(sql2);
			rs2=stmt1.executeQuery();
			if(rs2!=null)
			{
				while(rs2.next())
				{
					dat2=rs2.getString(1);
					id2=rs2.getString(2);
					if(id2.equals(resp_id))
						sel2="selected";
					out.println("<option value='"+id2+"' "+sel2+">"+dat2+"</option>");
					sel2="";
				}
			}
		
		if(rs2!=null) rs2.close();
		if(stmt1!=null) stmt1.close();
		}
		catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		
	%>
	</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr><td>&nbsp</td><td></td></tr>
	<tr>
	<td class=label align=right>Relationship</td>
	<td align=left class=label>&nbsp;<select name=pract_reln_id>
	<option value=''>------Select------</option>	
	<%if (mode.equals("modify")){
	try{
					sql=" Select pract_reln_id, pract_reln_name from ca_pract_reln_for_resp_vw where resp_id=?  order by 2 ";
					
			stmt1=con.prepareStatement(sql);
			stmt1.setString(1,resp_id);
			rs2=stmt1.executeQuery();
			if(rs2!=null)
			{
				while(rs2.next())
				{
					dat2=rs2.getString(2);
					id2=rs2.getString(1);
					if(id2.equals(pract_reln_id))
						sel2="selected";
					out.println("<option value='"+id2+"' "+sel2+">"+dat2+"</option>");
					sel2="";
				}
			}
		if(rs2!=null) rs2.close();
		if(stmt1!=null) stmt1.close();
		}
		catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
		
	}%>
	</select></td>
</tr>
<tr><td>&nbsp</td><td></td></tr>
<tr>
	<td class=label align=right>Facility</td>
	<td align=left class=label>&nbsp;<select name=facility_id>
	<option value=''>------Select------</option>	
<%
	if (mode.equals("modify")){out.println("here");
		try{
			String	sql1=" Select a.facility_id, b.facility_name from sm_facility_for_resp a, sm_facility_param b where a.facility_id=b.facility_id and a.resp_id= ? order by 2 ";

			stmt1=con.prepareStatement(sql1);
			stmt1.setString(1,resp_id);
			rs2=stmt1.executeQuery();
			if(rs2!=null){
				while(rs2.next()){
					id2=rs2.getString(1);
					dat2=rs2.getString(2);
					if(id2.equals(facility_id))
						sel2="selected";
					out.println("<option value='"+id2+"' "+sel2+">"+dat2+"</option>");
					sel2="";
				}
			}
		
		if(rs2!=null) rs2.close();
		if(stmt1!=null) stmt1.close();
		}catch(Exception e){
			//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();//COMMON-ICN-0181
		}
	}%>
	</select></td>
</tr>
<tr><td>&nbsp</td><td></td></tr>
<tr>
	<td class=label align=right>Applicable</td>
	<td align=left class=label><input type="checkbox" name="enabled" id="enabled" value='A' <%=enable_checked%> ></td>
</tr>
<tr>
	<td width='35%'>&nbsp;</td>
	<td width='65%'>&nbsp;</td>
</tr>
</table>
<input type=hidden name=mode value="<%=mode%>">
<input type=hidden name=appl_task_id1 value="<%=appl_task_id%>">
<input type=hidden name=srl_no value="<%=srl_no%>">
</form>
</body>
</html>
<%
	
	
}
catch(Exception e){
	//out.println("Exception in AddModifyTaskForResp.jsp"+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}
%>

