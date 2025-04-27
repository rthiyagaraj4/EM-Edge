<!DOCTYPE html>
<%@ page import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*, eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	String entityid = request.getParameter("entityid");
	String opermodules = request.getParameter("opermodules");
	String groupid = request.getParameter("groupid");
	if(opermodules == null || opermodules.equals("null")) opermodules = "";
%>
<html>

<head>
		<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
		<%
	//	 request.setCharacterEncoding("UTF-8");
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

        <script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
        <script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
var arrModule = new Array();
var arrModVal = new Array();
var x = 0;

function setValue(Module,Obj)
{
	if(Obj.checked == true)
	{
		Obj.value = "Y";
		for(y = 0;y < x;y++)
		{
			if(arrModule[y] == Module)
			   arrModVal[y] = "Y";
		}
	}
	else
	{
		Obj.value = "N";
		for(y = 0;y < x;y++)
		{
			if(arrModule[y] == Module)
			   arrModVal[y] = "N";
		}
	}
	var modules = arrModule[0];
	var modvalues  = arrModVal[0];
	for(z = 1;z < x;z++)
	{
		modules += "|"+arrModule[z];	 	
		modvalues += "|"+arrModVal[z];	 	
	}

	document.forms[0].ModuleIDs.value = modules;
	document.forms[0].ModuleVals.value = modvalues;
}

function initialize()
{
	var modules = arrModule[0];
	var modvalues  = arrModVal[0];
	for(z = 1;z < x;z++)
	{
		modules += "|"+arrModule[z];	 	
		modvalues += "|"+arrModVal[z];	 	
	}

	document.forms[0].ModuleIDs.value = modules;
	document.forms[0].ModuleVals.value = modvalues;
}

</script>
<body onLoad="initialize();" onMouseDown="CodeArrest();" onKeyDown = 'lockKey()'>
<form name="facility_oper_module_result" id="facility_oper_module_result">
<table border='1' cellpadding='0' cellspacing='0' width='90%' align='center'> 

<%
		Connection con = ConnectionManager.getConnection(request);
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rs = null;
		ResultSet rs1 = null;
		String classValue = "QRYODD";
		String operFlag = "";
		String operYN = "";
		
		int i = 1;

	try
	{
		if(opermodules.equals(""))
		{
			pstmt1 = con.prepareStatement("Select module_id, operational_yn operational_flag, srl_no from SM_MODULES_ACCT_ENTITY_vw where ACCT_ENTITY_ID = ? Union Select module_id, 'N' operational_flag, srl_no from sm_module where install_yn = 'Y' and MODULE_GROUP_ID = 'FM' and module_id not in (Select module_id from SM_MODULES_ACCT_ENTITY where ACCT_ENTITY_ID = ?) order by srl_no  ");
			pstmt1.setString	(	1,	entityid		);
			pstmt1.setString	(	2,	entityid		);
			rs1 = pstmt1.executeQuery();
			if(rs1 != null)
			{
				while(rs1.next())
				{
					%>
					<script>
					arrModule[x] = "<%=rs1.getString(1)%>";
					arrModVal[x] = "<%=rs1.getString(2)%>";
					x++;
					</script>
					<%
				}
			}
		}
		else
		{
			String chkModules = "";
			String chkValues = "";
			StringTokenizer stoken = new StringTokenizer(opermodules,"$");
			String Modules = stoken.nextToken();
			String Flags = stoken.nextToken();

			StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
			StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
						
			while(smodtoken.hasMoreTokens())
			{
				chkModules = smodtoken.nextToken();
				chkValues  = sflagtoken.nextToken();
				%>
					<script>
					arrModule[x] = "<%=chkModules%>";
					arrModVal[x] = "<%=chkValues%>";
					x++;
					</script>
				<%
			}
		}

		pstmt = con.prepareStatement("Select module_id, module_name, operational_yn operational_flag, srl_no from SM_MODULES_ACCT_ENTITY_vw where ACCT_ENTITY_ID = ? and module_group_id = ? Union Select module_id, module_name, 'N' operational_flag, srl_no from sm_module where module_group_id = ? and install_yn = 'Y' and module_id not in (Select module_id from SM_MODULES_ACCT_ENTITY where ACCT_ENTITY_ID = ?) order by srl_no  ");
		pstmt.setString	(	1,	entityid		);
		pstmt.setString	(	2,	groupid		);
		pstmt.setString	(	3,	groupid		);
		pstmt.setString	(	4,	entityid		);
		rs = pstmt.executeQuery();
		int a=0;
		if(rs != null)
		{ { %>
           
		<%}	while(rs.next())
			{
			if(a==0){%>
					<th><fmt:message key="Common.Module.label" bundle="${common_labels}"/></th>
                    <th><fmt:message key="eSM.Operational.label" bundle="${sm_labels}"/></th>

			<% a=1;}
                 if(classValue.equals("QRYEVEN"))
                     classValue = "QRYODD";
                 else
                    classValue = "QRYEVEN";
				
				if(opermodules.equals(""))
				{
					operYN = rs.getString("operational_flag");
					if(operYN == null || operYN.equals("null")) operYN = "N";

					if(operYN.equals("N"))
						operFlag = "Unchecked";
					else
						operFlag = "Checked";
				}
				else
				{
					String chkModules = "";
					String chkValues = "";
					StringTokenizer stoken = new StringTokenizer(opermodules,"$");
					String Modules = stoken.nextToken();
					String Flags = stoken.nextToken();

					StringTokenizer smodtoken = new StringTokenizer(Modules,"|");
					StringTokenizer sflagtoken = new StringTokenizer(Flags,"|");
						
					while(smodtoken.hasMoreTokens())
					{
						chkModules = smodtoken.nextToken();
						chkValues  = sflagtoken.nextToken();
						if(chkModules.equals(rs.getString("module_id")))
						{
							if(chkValues.equals("N"))
								operFlag = "Unchecked";
							else
								operFlag = "Checked";

								operYN = chkValues;
						}
					}	
				}
			%>
				<tr><td class='<%=classValue%>'><%=rs.getString("module_name")%></td>
				<td class='<%=classValue%>' align='center'><input type='checkbox' name='chbox<%=i%>' id='chbox<%=i%>' value='<%=operYN%>' <%=operFlag%> onClick='setValue("<%=rs.getString("module_id")%>",this)'></td></tr>
			<%
				i++;
			}
		}
		if(a==0){%>
				<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))
				parent.f_query_details.location.href = "../../eCommon/html/blank.html"
				</script>
		<%}

		if(rs != null) rs.close();
		if(rs1 != null) rs1.close();
		if(pstmt != null) pstmt.close();
		if(pstmt1 != null) pstmt1.close();

	}
	catch(Exception e) { out.println(e.toString()); }
	finally 
	{
		
		ConnectionManager.returnConnection(con, request);
	}
	%>
</table>
	<input type="hidden" name="TotRecs" id="TotRecs" value="<%=(i-1)%>">
	<input type="hidden" name="ModuleIDs" id="ModuleIDs" value="">
	<input type="hidden" name="ModuleVals" id="ModuleVals" value="">
</form>
</body>
</html>

