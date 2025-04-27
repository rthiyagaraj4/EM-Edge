<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<html>
<head>
<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
var arrSubfuncins = new Array();
var arrSubfuncupd = new Array();
var arrSubfuncdel = new Array();
var arrSubfuncprn = new Array();
var arrSubfuncqry = new Array();
var cnt = 0;

function setValues(Obj)
	{
		var objname = Obj.name.substring(6,7);
		if(Obj.checked)
		{
			Obj.value = "Y";
			if(arrSubfuncins[objname-1] == "Y") 
				eval("document.forms[0].subins"+objname+".disabled = false");
			if(arrSubfuncupd[objname-1] == "Y") 
				eval("document.forms[0].subupd"+objname+".disabled = false");
			if(arrSubfuncdel[objname-1] == "Y") 
				eval("document.forms[0].subdel"+objname+".disabled = false");
			if(arrSubfuncqry[objname-1] == "Y") 
				eval("document.forms[0].subqry"+objname+".disabled = false");
			if(arrSubfuncprn[objname-1] == "Y") 
				eval("document.forms[0].subprn"+objname+".disabled = false");
		}
		else
		{
			Obj.value = "N";
			eval("document.forms[0].subins"+objname+".disabled = true");
			eval("document.forms[0].subupd"+objname+".disabled = true");
			eval("document.forms[0].subdel"+objname+".disabled = true");
			eval("document.forms[0].subqry"+objname+".disabled = true");
			eval("document.forms[0].subprn"+objname+".disabled = true");
		} 
	}
	
	function setInsVals(Obj)
	{
		if(Obj.checked)
			Obj.value = "Y";
		else
			Obj.value = "N";
	}

	function setUpdVals(Obj)
	{
		if(Obj.checked)
			Obj.value = "Y";
		else
			Obj.value = "N";
	}

	function setDelVals(Obj)
	{
		if(Obj.checked)
			Obj.value = "Y";
		else
			Obj.value = "N";
	}

	function setQryVals(Obj)
	{
		if(Obj.checked)
			Obj.value = "Y";
		else
			Obj.value = "N";
	}

	function setPrnVals(Obj)
	{
		if(Obj.checked)
			Obj.value = "Y";
		else
			Obj.value = "N";
	}

	function disabledValues()
	{

	}
</script>
<%
    Connection con=null;
	PreparedStatement pstmt = null;
	ResultSet rs= null;

	try
	{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		StringBuffer sql	= new StringBuffer();
		String classValue = "";
		String Step = request.getParameter("Step");
		String moduleId = request.getParameter("ModuleID");
		String menuId   = request.getParameter("MenuID");
		String OptionSequenceNo = request.getParameter("OptionSequenceNo");	
		String functionVal = request.getParameter("FunctionVal");	
			if(functionVal == null) functionVal = "";
		String funcId	= request.getParameter("FunctionID");
		String SubFunctionValues = request.getParameter("SubFunctionValues");	
		if(SubFunctionValues == null || SubFunctionValues.equals("null"))
			SubFunctionValues = "";

		String Resp_id = request.getParameter("Resp_id");	
		if(Resp_id == null || Resp_id.equals("null")) Resp_id = "";

		if(Step.equals("Add"))
		{
			String 	insertyn = "";
			String 	deleteyn = "";
			String 	queryyn  = "";
			String 	printyn  = "";
			String 	updateyn = "";		
			
			String 	insertyn1 = "";
			String 	deleteyn1 = "";
			String 	queryyn1  = "";
			String 	printyn1  = "";
			String 	updateyn1 = "";		
			String  includeyn = "";
			
			String insert_disabled="disabled";
			String include_disabled="disabled";
			String update_disabled="disabled";
			String delete_disabled="disabled";
			String query_disabled="disabled";
			String print_disabled="disabled";

			String include_checked="checked";
			String insert_checked="checked";
			String update_checked="checked";
			String delete_checked="checked";
			String query_checked="checked";
			String print_checked="checked";
			String disable_enable="";

			String 	menuid	 = "";
			String  optionsequenceno = "";
			String  functionid = "";
			String  subfunctionid = "";
			String  subfunctionVal = "";
			int p = 0;
%>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="MenuRstrnForSubFuncResult_Form" id="MenuRstrnForSubFuncResult_Form">
		<b><fmt:message key="Common.Function.label" bundle="${common_labels}"/> : <%=functionVal%></b>
		<table border='1' width='102%' cellpadding='0' cellspacing='0' align='center' >
			 <tr>
				<th align='center' width='10%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
				<th align='left' width='40%'><fmt:message key="eSM.SubFunctionName.label" bundle="${sm_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.Insert.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.Update.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.print.label" bundle="${common_labels}"/></th>	
				<th align='center' width='10%'><fmt:message key="Common.query.label" bundle="${common_labels}"/></th>
			 </tr> 
		<%
		try
		{
				 sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id,a.module_id,a.insert_access_yn,a.update_access_yn,a.delete_access_yn,a.print_access_yn,a.query_only_access_yn,a.subfunction_id, b.subfunction_name, a.incl_yn from sm_menu_sfunc_dtl a, sm_subfunction b where a.module_id	=	b.parent_module_id and a.function_id = b.parent_function_id and  a.subfunction_id = b.subfunction_id and a.module_id = '"+moduleId+"' and a.menu_id = '"+menuId+"' and a.option_sequence_no = '"+OptionSequenceNo+"' and a.function_id  = '"+funcId+"' ");
				 pstmt = con.prepareStatement(sql.toString());
				 rs = pstmt.executeQuery();
				int  i = 1;
				if(rs!=null)
				{
				   while(rs.next())
				   {
					p++;
					if ( i%2 == 0 )
						classValue="QRYEVEN";
					else
						classValue="QRYODD";
					
					menuid	 = rs.getString("menu_id");		
						if(menuid  == null) menuid = "";
					optionsequenceno = rs.getString("option_sequence_no");		
						if(optionsequenceno == null) optionsequenceno ="";	
					functionid = rs.getString("function_id");			
						if(functionid == null ) functionid ="";

					subfunctionid = rs.getString("subfunction_id");			
						if(subfunctionid  == null ) subfunctionid = "";
					subfunctionVal = rs.getString("subfunction_name");
						if(subfunctionVal  == null ) subfunctionVal = "";

					insertyn1    = rs.getString(5);
						  if(insertyn1  == null ) insertyn1 = "N";
						  else if(insertyn1.equals("Y")) insert_disabled="";
							  
					updateyn1    = rs.getString(6);
						  if(updateyn1  == null ) updateyn1 = "N";
						  else if(updateyn1.equals("Y")) update_disabled="";
							  
					deleteyn1    = rs.getString(7);
						  if(deleteyn1  == null ) deleteyn1 = "N";
						  else if(deleteyn1.equals("Y")) delete_disabled="";
							  
					printyn1     = rs.getString(8);
						  if(printyn1  == null ) printyn1 = "N";
						  else if(printyn1.equals("Y")) print_disabled="";
							  
					queryyn1     = rs.getString(9);
						  if(queryyn1  == null ) queryyn1 = "N"; 
						  else if(queryyn1.equals("Y")) query_disabled="";
			%> 
						<script>
						arrSubfuncins[cnt] = "<%=insertyn1%>";
						arrSubfuncupd[cnt] = "<%=updateyn1%>";
						arrSubfuncdel[cnt] = "<%=deleteyn1%>";
						arrSubfuncprn[cnt] = "<%=printyn1%>";
						arrSubfuncqry[cnt] = "<%=queryyn1%>";
						cnt++;
						</script>
			<% 
				if(SubFunctionValues.equals(""))
				{
					includeyn = rs.getString("incl_yn");
					  if(includeyn  == null ) includeyn = "N";
					  else if(includeyn.equals("Y")) { include_checked="checked";  disable_enable = "";   }
					  else if(includeyn.equals("N")) { include_checked="";  disable_enable = "Disabled";  }

					insertyn    = rs.getString(5);			
					  if(insertyn  == null ) insertyn = "N";
					  else if(insertyn.equals("Y")) insert_checked="checked";
					  else if(insertyn.equals("N")) insert_checked="";

					updateyn    = rs.getString(6);
					  if(updateyn  == null ) updateyn = "N";
					  else if(updateyn.equals("Y")) update_checked="checked";
					  else if(updateyn.equals("N")) update_checked="";
					  
					deleteyn    = rs.getString(7);
					  if(deleteyn  == null ) deleteyn = "N";
					  else if(deleteyn.equals("Y")) delete_checked="checked";
					  else if(deleteyn.equals("N")) delete_checked="";
					  
					printyn     = rs.getString(8);
					  if(printyn  == null ) printyn = "N";
					  else if(printyn.equals("Y")) print_checked="checked";
					  else if(printyn.equals("N")) print_checked="";
					  
					queryyn     = rs.getString(9);
					  if(queryyn  == null ) queryyn = "N"; 
					  else if(queryyn.equals("Y")) query_checked="checked";
					  else if(queryyn.equals("N")) query_checked="";
				}
				else
				{
						StringTokenizer stoken = new StringTokenizer(SubFunctionValues,"$");
						while(stoken.hasMoreTokens())
						{
							String subvalues = stoken.nextToken();
							StringTokenizer subtoken = new StringTokenizer(subvalues,"|");
							while(subtoken.hasMoreTokens())
							{
								 String subfunc = subtoken.nextToken();
								 if(subfunc.equals(subfunctionid))
								 {
									includeyn = subtoken.nextToken();
									 if(includeyn.equals("Y")) 
										  { include_checked="checked";  disable_enable = "";   }
									  else if(includeyn.equals("N")) 
										  { include_checked="";  disable_enable = "Disabled";  }

									insertyn = subtoken.nextToken();
									  if(insertyn.equals("Y")) insert_checked="checked";
									  else if(insertyn.equals("N")) insert_checked="";

									updateyn  = subtoken.nextToken();
									  if(updateyn.equals("Y")) update_checked="checked";
									  else if(updateyn.equals("N")) update_checked="";
									  
									deleteyn  = subtoken.nextToken();
									  if(deleteyn.equals("Y")) delete_checked="checked";
									  else if(deleteyn.equals("N")) delete_checked="";
									  
									queryyn   = subtoken.nextToken();
									  if(queryyn.equals("Y")) query_checked="checked";
									  else if(queryyn.equals("N")) query_checked="";

									printyn   = subtoken.nextToken();
									  if(printyn.equals("Y")) print_checked="checked";
									  else if(printyn.equals("N")) print_checked="";
								 }
							}
						}
				}

				includeyn = rs.getString("incl_yn");
				if(includeyn.equals("Y")) include_disabled = "";
				else if(printyn.equals("N")) include_disabled="Disabled";

			%>	   

			<tr>
				<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subinc<%=p%>' value = '<%=includeyn%>' <%=include_checked%> <%=include_disabled%> onClick="setValues(this);"></td>
				<td width = '40%' class='<%=classValue%>'><%=subfunctionVal%></td>	  
				<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subins<%=p%>' value = '<%=insertyn%>' <%=insert_checked%> <%=disable_enable%> <%=insert_disabled%> onClick="setInsVals(this);"></td>
				<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subupd<%=p%>' value = '<%=updateyn%>' <%=update_checked%> <%=disable_enable%> <%=update_disabled%> onClick="setUpdVals(this);"></td>
				<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subdel<%=p%>' value = '<%=deleteyn%>' <%=delete_checked%> <%=disable_enable%> <%=delete_disabled%> onClick="setDelVals(this);"></td>	   
				<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subprn<%=p%>' value = '<%=printyn%>' <%=print_checked%> <%=disable_enable%> <%=print_disabled%> onClick="setPrnVals(this);"></td>
				<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subqry<%=p%>' value = '<%=queryyn%>' <%=query_checked%> <%=disable_enable%> <%=query_disabled%> onClick="setQryVals(this);"></td>
				<input type = 'hidden' name = 'subfunctionid<%=p%>' value ='<%=subfunctionid%>'>
			</tr>	
			<%		
			i++;
			insert_disabled="disabled";
			update_disabled="disabled";
			delete_disabled="disabled";
			query_disabled="disabled";	
			print_disabled="disabled";
		}
		}  
		if(rs!=null)rs.close();
		if(pstmt!=null)pstmt.close();

		}catch(Exception e ){out.println("Error "+e   );}
		%>
		</table>			
		<input type = 'hidden' name = 'Pval' value = '<%=p%>'>
		</form>
		</body>
<%
	}
	else if(Step.equals("Remove"))
	{
%>		
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="Disply_Restricted_Records" id="Disply_Restricted_Records">
		<b><fmt:message key="Common.Function.label" bundle="${common_labels}"/> : <%=functionVal%></b>
		<table border='1' width='102%' cellpadding='0' cellspacing='0' align='center' >
			 <tr>
				<th align='center' width='10%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
				<th align='left' width='40%'><fmt:message key="eSM.SubFunctionName.label" bundle="${sm_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.Insert.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.Update.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
				<th align='center' width='10%'><fmt:message key="Common.print.label" bundle="${common_labels}"/></th>	
				<th align='center' width='10%'><fmt:message key="Common.query.label" bundle="${common_labels}"/></th>
			 </tr> 
		<%
			String include_checked="checked";
			String insert_checked="checked";
			String update_checked="checked";
			String delete_checked="checked";
			String print_checked="checked";
			String query_checked="checked";

			 sql.append(" SELECT SUBFUNCTION_NAME, INCL_YN, INSERT_ACCESS_YN, UPDATE_ACCESS_YN, ");
			 sql.append(" DELETE_ACCESS_YN, PRINT_ACCESS_YN, QUERY_ONLY_ACCESS_YN ");
			 sql.append(" from SM_SFUNC_RSTRN_RESP_VW Where ");
			 sql.append(" RESP_ID = '"+Resp_id+"' and ");
			 sql.append(" MENU_ID = '"+menuId+"' and ");
			 sql.append(" OPTION_SEQUENCE_NO = '"+OptionSequenceNo+"' and ");
			 sql.append(" MODULE_ID = '"+moduleId+"' and ");
			 sql.append(" FUNCTION_ID = '"+funcId+"' ");

				pstmt = con.prepareStatement(sql.toString());
				rs = pstmt.executeQuery();
				int  i = 1;
				if(rs!=null)
				{
				   while(rs.next())
				   {
					if ( i%2 == 0 )
						classValue="QRYEVEN";
					else
						classValue="QRYODD";

					  if(rs.getString(3).equals("Y")) insert_checked="checked";
					  else if(rs.getString(3).equals("N")) insert_checked="";

					  if(rs.getString(4).equals("Y")) update_checked="checked";
					  else if(rs.getString(4).equals("N")) update_checked="";
					  
					  if(rs.getString(5).equals("Y")) delete_checked="checked";
					  else if(rs.getString(5).equals("N")) delete_checked="";
					  
					  if(rs.getString(6).equals("Y")) print_checked="checked";
					  else if(rs.getString(6).equals("N")) print_checked="";
					  
					  if(rs.getString(7).equals("Y")) query_checked="checked";
					  else if(rs.getString(7).equals("N")) query_checked="";

					%>
					
					<tr>
					<td width = '10%' class='<%=classValue%>' align=center>
					<input type = 'checkbox' <%=include_checked%> disabled>
					</td>
					<td width = '40%' class='<%=classValue%>'><%=rs.getString(1)%></td>
					<td width = '10%' class='<%=classValue%>' align=center>
					<input type = 'checkbox' <%=insert_checked%> disabled></td>
					<td width = '10%' class='<%=classValue%>' align=center>
					<input type = 'checkbox' <%=update_checked%> disabled></td>
					<td width = '10%' class='<%=classValue%>' align=center>
						<input type = 'checkbox' <%=delete_checked%> disabled></td>
					<td width = '10%' class='<%=classValue%>' align=center>
						<input type = 'checkbox' <%=print_checked%> disabled></td>
					<td width = '10%' class='<%=classValue%>' align=center>
						<input type = 'checkbox' <%=query_checked%> disabled></td></tr>
					<%
						i++;
				   }
				}
				if(rs!=null)rs.close();
				if(pstmt!=null)pstmt.close();
		%>
		</table>			
		</form> 
		</body>
<%
	}
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();

}catch(Exception e){out.println(e);}
	finally 
	{ 
		if(con != null)
			ConnectionManager.returnConnection(con,request);
	}
%>
</html>

