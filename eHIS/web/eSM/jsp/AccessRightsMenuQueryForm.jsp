<!DOCTYPE html>
<!doctype html public "-//w3c//dtd html 4.0 transitional//en">
<%@ page import ="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<html>
<head>
<title> <fmt:message key="eSM.AccessRightsforMenu.label" bundle="${sm_labels}"/></title>
<%
        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eSM/js/AccessRightsMenuFunc.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
function  PopVal()
{
	parent.frames[1].location.href= '../eSM/jsp/InpatientLookupQueryResult.jsp'		
}

async function showSubfunctions(menuval,moduleval,funcid,funcval,rownum)
{
		var subfuncval = eval("document.forms[0].subfunctionvalues"+rownum+".value");
		
		 var dialogHeight= "15" ;
		 var dialogWidth = "40" ;
		 var dialogTop = "300" ;
		 var dialogLeft = "155" ;
		 var features    = "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth+";dialogTop:" + dialogTop+";dialogLeft:" + dialogLeft+";status=no;scroll=no" ;
         var arguments   = "" ;
	     var retVal = await window.showModalDialog("../../eSM/jsp/AccessRightsMenuSubFunc.jsp?MenuID="+menuval+"&ModuleID="+moduleval+"&FunctionID="+funcid+"&FunctionVal="+funcval+"&SubFunctionValues="+subfuncval,arguments,features);

		if(retVal != null)	
			eval("document.forms[0].subfunctionvalues"+rownum).value = retVal;
		else
			eval("document.forms[0].subfunctionvalues"+rownum).value = "";
}
</script>
</head>
<%
    Connection con=null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt1 = null;
	ResultSet rs=null;
	ResultSet rs1=null;

	try
	{
		request.setCharacterEncoding("UTF-8");
		con = ConnectionManager.getConnection(request);
		String menuVal 	 = request.getParameter("menuVal");		if(menuVal == null) menuVal = "";
		String moduleVal = request.getParameter("moduleVal");	if(moduleVal == null) moduleVal = "";
		String funcVal 	 = request.getParameter("funcVal");		if(funcVal == null) funcVal = "";
		String menuId    = request.getParameter("menuId"); 		if(menuId == null) menuId = "";

		String 	insertyn = "";
		String 	deleteyn = "";
		String 	queryyn  = "";
		String 	printyn  = "";
		String 	updateyn = "";		
	    int countdata=0;
		String 	insertyn1 = "";
		String 	deleteyn1 = "";
		String 	queryyn1  = "";
		String 	printyn1  = "";
		String 	updateyn1 = "";		
		
		String insert_disabled="disabled";
		String update_disabled="disabled";
		String delete_disabled="disabled";
		String query_disabled="disabled";
		String print_disabled="disabled";

		String insert_checked="checked";
		String update_checked="checked";
		String delete_checked="checked";
		String query_checked="checked";
		String print_checked="checked";

		String  functionVal = "";
		String 	menuid	 = "";
		String  module_id = "";
		String  optionsequenceno = "";
		String  functionid = "";
		String  classValue = "";
		StringBuffer  sql=new StringBuffer();
		String  subfunction_yn = "N";
		int p = 0;
		int rec_cnt = 0;
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="AccessRightsMenuQuery_Form" id="AccessRightsMenuQuery_Form" method=post  action='../../servlet/eSM.AccessRightsMenuFuncServlet' target='messageFrame' >

<table border='1' width='102%' cellpadding='0' cellspacing='0' align='center' >
	 <tr>
		<th align='left' width='45%'><fmt:message key="Common.FunctionName.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.Insert.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.Update.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.delete.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.query.label" bundle="${common_labels}"/></th>
		<th align='center' width='10%'><fmt:message key="Common.print.label" bundle="${common_labels}"/></th>	
	 </tr> 
<%
	try
	{
		 if (!(funcVal.equals("")))
		 {
				if (!moduleVal.equals(""))
				{
					sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					sql.append(" b.print_access_yn,b.query_only_access_yn ");
					sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					sql.append(" a.function_id=b.function_id and ");
					sql.append(" a.module_id = '"+ moduleVal+"' ");
					sql.append(" and a.menu_id = '"+menuId+"' 	");
					sql.append(" and upper(a.FUNCTION_NAME) like upper(('"+funcVal+"%') )");
				}
				else if (moduleVal.equals(""))
				{
					sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					 sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					 sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					 sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					 sql.append(" b.print_access_yn,b.query_only_access_yn ");
					 sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					 sql.append(" a.function_id=b.function_id  ");
					 sql.append(" and a.menu_id = '"+menuId+"' 	");
					 sql.append(" and upper(a.FUNCTION_NAME) like upper(('"+funcVal+"%') )");
				 }
		 }
		 else if(funcVal.equals(""))
		{
				if (!moduleVal.equals(""))
				{
					 sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					 sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					 sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					 sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					 sql.append(" b.print_access_yn,b.query_only_access_yn ");
					 sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					 sql.append(" a.function_id=b.function_id and ");
					 sql.append(" a.module_id = '"+ moduleVal+"' ");
					 sql.append(" and a.menu_id = '"+menuId+"' 	");
				}
				else
				{
					sql.append(" SELECT a.menu_id,a.option_sequence_no,a.function_id, ");
					sql.append(" a.module_id,a.function_name,a.insert_access_yn,a.update_access_yn,");
					sql.append(" a.delete_access_yn,a.print_access_yn,a.query_only_access_yn, ");
					sql.append(" b.insert_access_yn,b.update_access_yn,b.delete_access_yn, ");
					sql.append(" b.print_access_yn,b.query_only_access_yn ");
					sql.append(" from sm_menu_dtl_vw a, sm_function b where 	");
					sql.append(" a.function_id=b.function_id  ");
					sql.append(" and a.menu_id = '"+menuId+"' 	");
				}
		}

		pstmt = con.prepareStatement(sql.toString());
		rs = pstmt.executeQuery();

		pstmt1 = con.prepareStatement("Select count(*) from SM_MENU_SFUNC_DTL WHERE MODULE_ID = '"+module_id+"' and MENU_ID = '"+menuid+"' and OPTION_SEQUENCE_NO = '"+optionsequenceno+"' and FUNCTION_ID= '"+functionid+"' ");	
			rs1 = pstmt1.executeQuery();
		int  i = 1;
		if(rs!=null)
		{
			out.println("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccessRightsForMenuFunctions.label","sm_labels")+"</b>");
		   while(rs.next())
		   {countdata=1;
				p++;
				if ( i%2 == 0 )
					classValue="QRYEVEN";
				else
					classValue="QRYODD";
				
				menuid	 = rs.getString(1);
				if(menuid  == null) menuid = "";
				
				optionsequenceno = rs.getString(2);
				if(optionsequenceno == null) optionsequenceno ="";	
				
				functionid = rs.getString(3);
				  if(functionid == null ) functionid ="";
			   
				module_id = rs.getString(4);
				  if(module_id == null ) module_id ="";

				functionVal = rs.getString(5);
				  if(functionVal  == null ) functionVal = "";
	   	  
			  insertyn    = rs.getString(6);
				if(insertyn  == null ) insertyn = "";
				else if(insertyn.equals("Y")) insert_checked="checked";
				else if(insertyn.equals("N")) insert_checked="";

				updateyn    = rs.getString(7);
				  if(updateyn  == null ) updateyn = "";
				  else if(updateyn.equals("Y")) update_checked="checked";
				  else if(updateyn.equals("N")) update_checked="";
				  
				deleteyn    = rs.getString(8);
				  if(deleteyn  == null ) deleteyn = "";
				  else if(deleteyn.equals("Y")) delete_checked="checked";
				  else if(deleteyn.equals("N")) delete_checked="";
				  
				printyn     = rs.getString(9);
				  if(printyn  == null ) printyn = "";
				  else if(printyn.equals("Y")) print_checked="checked";
				  else if(printyn.equals("N")) print_checked="";
				  
				queryyn     = rs.getString(10);
				  if(queryyn  == null ) queryyn = ""; 
				  else if(queryyn.equals("Y")) query_checked="checked";
				  else if(queryyn.equals("N")) query_checked="";

				insertyn1    = rs.getString(11);
				  if(insertyn1  == null ) insertyn1 = "";
				  else if(insertyn1.equals("Y")) insert_disabled="";
				  
				updateyn1    = rs.getString(12);
				  if(updateyn1  == null ) updateyn1 = "";
				  else if(updateyn1.equals("Y")) update_disabled="";
				  
				deleteyn1    = rs.getString(13);
				  if(deleteyn1  == null ) deleteyn1 = "";
				  else if(deleteyn1.equals("Y")) delete_disabled="";
				  
				printyn1     = rs.getString(14);
				  if(printyn1  == null ) printyn1 = "";
				  else if(printyn1.equals("Y")) print_disabled="";
				  
				queryyn1     = rs.getString(15);
				  if(queryyn1  == null ) queryyn1 = ""; 
				  else if(queryyn1.equals("Y")) query_disabled="";

			

			if(rs1.next())
				rec_cnt = rs1.getInt(1);

			if(rec_cnt > 0)
				subfunction_yn = "Y";
			else
				subfunction_yn = "N";

		if(subfunction_yn.equals("Y"))
		{
	%>	   
			<tr>
			<td width = '45%' class='<%=classValue%>'><a href="javascript:showSubfunctions('<%=menuid%>','<%=module_id%>','<%=functionid%>','<%=functionVal%>','<%=p%>')"><%=functionVal%></a></td>	  
	<%
		}
		else
		{
	%>
			<tr>
			<td width = '45%' class='<%=classValue%>'><%=functionVal%></td>	  
	<%
		}
	%>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'ins<%=p%>' value = 'Y' <%=insert_checked%> <%=insert_disabled%>></td>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'upd<%=p%>' value = 'Y' <%=update_checked%> <%=update_disabled%>></td>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'del<%=p%>' value = 'Y' <%=delete_checked%> <%=delete_disabled%>></td>	   
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'qry<%=p%>' value = 'Y' <%=query_checked%> <%=query_disabled%>></td>
		<td width = '10%' class='<%=classValue%>' align=center><input type = 'checkbox' name = 'prn<%=p%>' value = 'Y' <%=print_checked%> <%=print_disabled%>></td>
		
		<input type = 'hidden' name = 'optionsequenceno<%=p%>' value = '<%=optionsequenceno %>'>
		<input type = 'hidden' name = 'functionid<%=p%>' value = '<%=functionid%>'>
		<input type = 'hidden' name = 'menuid<%=p%>' 	   value = '<%=menuid%>'>
		<input type = 'hidden' name = 'subfunctionvalues<%=p%>' value = ''>
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
		if(countdata==0)
		{
	 	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].document.location.href='../../eCommon/html/blank.html'</script>");
		}

	}catch(Exception e ){//out.println("Error "+e   );
		e.printStackTrace();
	}
%>
</table>			
<input type = 'hidden' name = 'Pval' value = '<%=p%>'>
</form>
</body>
<%

	if(rs != null)		rs.close();
	if(rs1 != null)		rs1.close();
	if(pstmt != null)	pstmt.close();
	if(pstmt1 != null)	pstmt1.close();


}catch(Exception e){//out.println(e);
	e.printStackTrace();
}
finally 
{ 
if(con != null)
	ConnectionManager.returnConnection(con,request);
}
%>
</html>

