<!DOCTYPE html>
<HTML>
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXI.XIDBAdapter"%>
<script language="javascript">

</script>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%request.setCharacterEncoding("UTF-8"); %>
<% // String locale = ((String)session.getAttribute("LOCALE"));	%>
<HEAD>
<%											 
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_facility_id		= (String) session.getValue( "facility_id" ) ;
//	System.out.println("p_facility_id : "+p_facility_id);
String selected = "";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXI/js/Validate.js" ></script>
<script language="javascript" src="../../eXI/js/QueryOrgwsItemStatus.js" ></script> 
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()' >

<%

String mode			= "";
String item_code	= "";
String item_desc	= "";
String status			= "";

mode				=	request.getParameter("mode");
	
%>

<form name="orgws_item_status_form" id="orgws_item_status_form" target='messageFrame' method='post' >
<table cellspacing=0 cellpadding=3 width='100%' align=center>
<tr>
	<td width='10%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='50%'></td> 
</tr>

<tr>
    <td> </td>
	<td class=label ><fmt:message key="Common.ItemCode.label" bundle="${common_labels}"/></td>
	<td colspan=2 align=left>
		<input type="text" name="item_code" id="item_code" size=15 onBlur=''  value="<%=XIDBAdapter.checkNull(item_code)%>">
	<!--	<input type=text id="item_desc"  name =item_desc size=25 value="<%=XIDBAdapter.checkNull(item_desc)%>"> <input style="background:navy; color:white ;font-size: 8pt;font-Weight:600 ;border-style: ridge;" type="button"  name=itemCodeSearch value='?'    onClick='searchItemCode();'>-->
<!--		<img src='../../eCommon/images/mandatory.gif' align=middle> -->
	</td>
</tr>

<tr>
    <td> </td>
	<td class=label ><fmt:message key="eXI.ItemCategory.Label" bundle="${xi_labels}"/></td>
	<td	align=left>
	<select name ='item_catg'  >
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
//System.out.println("rs.getString(1)"+rs.getString(1));

			%>



<option value='<%=rs.getString(1)%>'><%=rs.getString(1)%></option>
<%
		}
%>

</select></td>
    <td> </td>

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

</tr>

<tr>
    <td> </td>
	<td class=label ><fmt:message key="Common.Organization.label" bundle="${common_labels}"/></td>
	
	<td	align=left>
	<select name ='org_id'  >
		<!--		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option> -->
		<option value=''><fmt:message key="Common.all.label" bundle="${common_labels}"/></option> 

	<%
	
Statement stmt1=null;
ResultSet rs1=null;
try
{

//		String sql1="SELECT DISTINCT FACILITY_ID,XI_ORGANIZATION_ID FROM XI_ITEM";
		String sql1="SELECT DISTINCT FACILITY_ID,ORGANIZATION_ID FROM XI_QRY_ORG_ITM_STATUS";
		
		stmt1=con.createStatement();
		rs1=stmt1.executeQuery(sql1);

		while(rs1.next())
		{
	//		System.out.println("rs.getString(1)"+rs1.getString(1));
	//		System.out.println("rs.getString(2)"+rs1.getString(2));

			if(p_facility_id.equals(rs1.getString(1))){
                    selected = "selected";
			}
			else{
				  selected = "";
			}

			%>



<option value='<%=rs1.getString(2)%>' <%=selected%> ><%=rs1.getString(2)%></option>
<%
		}
%>

</select></td>
    <td> </td>
<%
}
catch(Exception e)
{
	 
 System.out.println("Error in calling getconnection method of QueryOrgwsItemStatusSearchCriteria.jsp  :"+e.toString());
		e.printStackTrace(System.err);
		//exceptions=exceptions+"1"+"*"+exp.toString();
      }
finally{
			
			if(rs1!=null)rs1.close();
	        if(stmt1!=null)stmt1.close();			
			ConnectionManager.returnConnection(con);
}
	%>
</tr>	

<tr>
    <td> </td>
	<td class=label ><fmt:message key="Common.status.label" bundle="${common_labels}"/></td> 
	<td class='fields'>
	<select name ='status'  >
		<option value=''>----------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
		<option value='Y' <%=status.equals("Y")?"selected":""%>><fmt:message key="Common.available.label" bundle="${common_labels}"/></option>
		<option value='N' <%=status.equals("N")?"selected":""%>><fmt:message key="Common.notavailable.label" bundle="${common_labels}"/></option> 
	</select>
	 <td> </td> 
</tr>

<tr>
<td> </td> <td> </td>  <td> </td> 
	<td >
		<input class='button' type="button"  name='Search' id='Search' value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' onClick='funSearch();'>
	</td>
<tr>

<tr>
	<td width='10%'></td>
	<td width='20%'></td>
	<td width='50%'></td>
	<td width='50%'></td> 
</tr>
</table>

<input type="hidden" name="act_mode" id="act_mode" value='<%=mode%>'>

</form>
</BODY>
</HTML> 

