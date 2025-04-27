<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXI.XIDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<HEAD>
<%String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXI/js/NewItemArrival.js" ></script>
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script language="JavaScript">
//function validatecheckbox
	
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY  leftmargin=0 topmargin=0  bgcolor='#F0F0F2'onMouseDown="CodeArrest()" onKeyDown ='lockKey()'>
<form name="MasterInterfaceForm" id="MasterInterfaceForm" target='messageFrame' method='post' >
<table border=0 cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
<tr>
	<td class=label><fmt:message key="eXI.ItemCategory.Label" bundle="${xi_labels}"/></td>
	<td	align=left>
	<select name ='Itemcategory_txt'  id='Itemcategory_txt'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>

	<%
	Connection con=null;
Statement stmt=null;
ResultSet rs=null;
try
{
con=ConnectionManager.getConnection();
		String sql="SELECT distinct XI_ITEM_CATEGORY_CODE FROM XI_ITEM ";
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql);

		while(rs.next())
		{
System.out.println("rs.getString(1)"+rs.getString(1));

			%>



<option value='<%=rs.getString(1)%>'><%=rs.getString(1)%></option>
<%
		}
%>

</select></td>

<%
}
catch(Exception e)
{
	 
 System.out.println("Error in calling getconnection method of FilteringRuleApplicationsearch.jsp  :"+e.toString());
		e.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
finally{
			
			if(rs!=null)rs.close();
	        if(stmt!=null)stmt.close();			
			
}
	%>

	<!---<td	align=left><input type=text name=item_Arrival   onKeyPress='' onBlur='' maxlength="15" size=15><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ItemSearch value='?'    onClick="searchCategory()">
<input type="hidden" name="Itemcategory_txt" id="Itemcategory_txt" value=""></td>--------->
</tr>
<tr>
	<td class=label><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
	
	<td	align=left>
	<select name ='organization_txt' id='organization_txt'>
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>

	<%
	
Statement stmt1=null;
ResultSet rs1=null;
try
{

		String sql1="SELECT distinct XI_ORGANIZATION_ID FROM XI_ITEM ";
		stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);

		while(rs1.next())
		{
//System.out.println("rs.getString(1)"+rs1.getString(1));

			%>



<option value='<%=rs1.getString(1)%>'><%=rs1.getString(1)%></option>
<%
		}
%>

</select></td>

<%
}
catch(Exception e)
{
	 
 System.out.println("Error in calling getconnection method of FilteringRuleApplicationsearch.jsp  :"+e.toString());
		e.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
finally{
			
			if(rs1!=null)rs1.close();
	        if(stmt1!=null)stmt1.close();			
			ConnectionManager.returnConnection(con);
}
	%>
	
	<!--<input type=text name=Organization  
	 onKeyPress='' onBlur='' maxlength="15" size=15><input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=ItemSearch value='?'    onClick="searchOrganization()">
<input type="hidden" name="organization_txt" id="organization_txt" value=""></td>---->
</tr>
<tr>
<td class=label ><fmt:message key="eXI.AfterDate.Label" bundle="${xi_labels}"/></td>
				<td class='fields'><input type=text name='after_date' id="after_date" size=11 onBlur='CheckDate(this);'> <input type='image' src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('after_date','dd/mm/y');" ><img src='../../eCommon/images/mandatory.gif' align=middle></td>  
</tr>

<tr>
<td colspan=2 class='BUTTON' style="text-align: right;"><input class='BUTTON' type="button"  name='search' id='search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick="goSearch();"></td>
<input type='hidden' name='action_type' id='action_type'  value='S' >
</tr>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
</table>





</form>
</body>
</html>

