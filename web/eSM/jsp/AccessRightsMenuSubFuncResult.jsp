<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*, eCommon.XSSRequestWrapper"  contentType="text/html;charset=UTF-8" %>
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
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		con = ConnectionManager.getConnection(request);
		StringBuffer sql	=new StringBuffer();
		
		
		String moduleId = request.getParameter("ModuleID");		if(moduleId == null) moduleId = "";
		String menuId   = request.getParameter("MenuID"); 		if(menuId == null) menuId = "";
		String funcId	= request.getParameter("FunctionID");	if(funcId == null) funcId = "";
		String functionVal = request.getParameter("FunctionVal");	
			if(functionVal == null) functionVal = "";

		String SubFunctionValues = request.getParameter("SubFunctionValues");	
			if(SubFunctionValues == null) SubFunctionValues = "";

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
		String  classValue = "";
		int p = 0;
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="AccessRightsMenuSubFuncResult_Form" id="AccessRightsMenuSubFuncResult_Form" method=post  action='../../servlet/eSM.AccessRightsMenuFuncServlet' target='messageFrame' >
<b><fmt:message key="Common.Function.label" bundle="${common_labels}"/> : <%=functionVal%></b>
<table border='1' width='102%' cellpadding='0' cellspacing='0' align='center' >
	 <tr>
		<th align='left' width='40%'><fmt:message key="eSM.SubFunctionName.label" bundle="${sm_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.Insert.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.Update.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.query.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.print.label" bundle="${common_labels}"/></th>	
	 </tr> 
<%
try
{
		 sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
		 sql.append(" a.module_id,a.insert_access_yn,a.update_access_yn,");
		 sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
		 sql.append(" a.subfunction_id, b.subfunction_name, a.incl_yn, ");
		 sql.append(" b.insert_access_yn, b.update_access_yn, ");
		 sql.append(" b.delete_access_yn, b.print_access_yn, b.query_only_access_yn ");
		 sql.append(" from sm_menu_sfunc_dtl a, sm_subfunction b where ");
		 sql.append(" a.module_id	=	b.parent_module_id and ");
		 sql.append(" a.function_id = b.parent_function_id and ");
		 sql.append(" a.subfunction_id = b.subfunction_id ");

	if (!(funcId.equals("")))
	{
		if (!moduleId.equals(""))
		{
			 sql.append(" and a.module_id = '"+moduleId+"' ");
			 sql.append(" and a.menu_id = '"+menuId+"' 	");
			 sql.append(" and a.function_id  = '"+funcId+"' ");
		}
		else if (moduleId.equals(""))
		{
			 sql.append(" and a.menu_id = '"+menuId+"' 	");
			 sql.append(" and a.function_id  = '"+funcId+"' ");
		}
	}

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

			insertyn1    = rs.getString(13);
			  if(insertyn1  == null ) insertyn1 = "N";
			  else if(insertyn1.equals("Y")) insert_disabled="";
				  
			updateyn1    = rs.getString(14);
			  if(updateyn1  == null ) updateyn1 = "N";
			  else if(updateyn1.equals("Y")) update_disabled="";
				  
			deleteyn1    = rs.getString(15);
			  if(deleteyn1  == null ) deleteyn1 = "N";
			  else if(deleteyn1.equals("Y")) delete_disabled="";
				  
			printyn1     = rs.getString(16);
			  if(printyn1  == null ) printyn1 = "N";
			  else if(printyn1.equals("Y")) print_disabled="";
				  
			queryyn1     = rs.getString(17);
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
	%>	   

	<tr>
		<td width = '40%' class='<%=classValue%>'><%=subfunctionVal%></td>	  
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subinc<%=p%>' id = 'subinc<%=p%>' value = '<%=includeyn%>' <%=include_checked%> onClick="setValues(this);"></td>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subins<%=p%>' id = 'subins<%=p%>' value = '<%=insertyn%>' <%=insert_checked%> <%=disable_enable%> <%=insert_disabled%> onClick="setInsVals(this);"></td>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subupd<%=p%>' id = 'subupd<%=p%> value = '<%=updateyn%>' <%=update_checked%> <%=disable_enable%> <%=update_disabled%> onClick="setUpdVals(this);"></td>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subdel<%=p%>' id = 'subdel<%=p%>' value = '<%=deleteyn%>' <%=delete_checked%> <%=disable_enable%> <%=delete_disabled%> onClick="setDelVals(this);"></td>	   
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subqry<%=p%>' id = 'subqry<%=p%>' value = '<%=queryyn%>' <%=query_checked%> <%=disable_enable%> <%=query_disabled%> onClick="setQryVals(this);"></td>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'subprn<%=p%>' id = 'subprn<%=p%>' value = '<%=printyn%>' <%=print_checked%> <%=disable_enable%> <%=print_disabled%> onClick="setPrnVals(this);"></td>
		<input type = 'hidden' name = 'subfunctionid<%=p%>' id = 'subfunctionid<%=p%>' value ='<%=subfunctionid%>'>
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

}catch(Exception e ){out.println("Error "+e   );}
%>
</table>			
<input type = 'hidden' name = 'Pval' id = 'Pval' value = '<%=p%>'>
</form>
</body>
<%
}catch(Exception e){out.println(e);}
	finally 
	{ 
		if(rs != null)		rs.close();
		if(pstmt != null)	pstmt.close();

		if(con != null)
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

