<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 


<html>
<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>	  

<script>
function resetValues()
{
	document.forms[0].opermodules.value = '';
	document.forms[0].appl_group.value = '';
	parent.frames[3].location.href = "../../eCommon/html/blank.html";
}

function repopulate(Obj)

{
	if(parent.frames[3].document.forms[0] != null)
	{
		document.forms[0].opermodules.value = parent.frames[3].document.forms[0].ModuleIDs.value+"$"+parent.frames[3].document.forms[0].ModuleVals.value;
	}

	if(Obj.value == "")
		parent.frames[3].location.href = "../../eCommon/html/blank.html";
	else
		parent.frames[3].location.href = "../../eSM/jsp/OperationalStatusEntityModule.jsp?entityid="+document.forms[0].entity.value+"&opermodules="+document.forms[0].opermodules.value+"&groupid="+Obj.value;
}
</script>
<body onMouseDown="CodeArrest();" onLoad="FocusFirstElement()" onKeyDown = 'lockKey()'>
<form name="entity_oper_module" id="entity_oper_module" action="../../servlet/eSM.OperationalStatusEntityServlet" method="post" target="messageFrame">
		<br>
			<table border='0' cellpadding='0' cellspacing='0' width='90%' align='center'> 
					<tr><td colspan='2'>&nbsp;</td></tr>
					<tr>
						<td width="35%" class='label'><fmt:message key="Common.AccountingEntity.label" bundle="${common_labels}"/></td>
						<td width="65%" class="fields">
							<select name="entity" id="entity" onChange="resetValues()">
							<%
							request.setCharacterEncoding("UTF-8");
							Connection con = ConnectionManager.getConnection(request);
							PreparedStatement pstmt = null;
							ResultSet rs = null;
							int cnt = 0;

							pstmt = con.prepareStatement("Select count(*) from SM_ACC_ENTITY_PARAM");
							rs = pstmt.executeQuery();
							
							if(rs.next())
								cnt = rs.getInt(1);

							if(rs!=null)rs.close();
							if(pstmt!=null)pstmt.close();
							
							if(cnt > 1 || cnt == 0) 
							%>
								<option value=''>&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp;</option>
							<%

							try
							{
								pstmt = con.prepareStatement("Select ACC_ENTITY_ID,ACCOUNTING_NAME_SHORT from SM_ACC_ENTITY_PARAM Order by ACCOUNTING_NAME_SHORT");
								rs = pstmt.executeQuery();

								if(rs != null)
								{
									while(rs.next())
									{
									%>
									<option value='<%=rs.getString(1)%>'><%=rs.getString(2)%></option>
									<%
									}
								}
								if(rs!=null)rs.close();
								if(pstmt!=null)pstmt.close();
							}
							catch(Exception e)
							{ //out.println(e); 
								e.printStackTrace();
							}

							finally
							{
									if(con != null)
									ConnectionManager.returnConnection(con,request);
							}
							%>
							</select>
						</td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>
					<tr>
						<td width="35%" class='label'><fmt:message key="eSM.ApplicationGroup.label" bundle="${sm_labels}"/></td>
						<td width="65%" class="fields">
							<select name="appl_group" id="appl_group" onChange="repopulate(this)">
							<option value="">&nbsp;----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------&nbsp;</option>
							<option value="FM"><fmt:message key="eSM.FinancialManagement.label" bundle="${sm_labels}"/></option>
							</select>
						</td>
					</tr>
					<tr><td colspan='2'>&nbsp;</td></tr>
			</table>
			<br>
<input type="hidden" name="opermodules" id="opermodules" value="">
</form>
</body>
</html>

