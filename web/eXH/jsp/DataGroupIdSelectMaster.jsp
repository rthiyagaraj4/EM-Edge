<!DOCTYPE html>
<HTML>  
<%@ page import = "java.util.*" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eXH.XHDBAdapter"%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%request.setCharacterEncoding("UTF-8"); %>

<% 

String dg_code = "";
String dg_desc = "";
String selected = "selected";
String defaultval = "";

String mode=request.getParameter("mode");
String detail_flag=request.getParameter("detail_flag");

if(mode.equals("U"))
{
	dg_code=request.getParameter("dg_code");
	defaultval=request.getParameter("dg_code");
	dg_desc=request.getParameter("dg_desc");
}

Connection con=null;
Statement stmt = null;
ResultSet rs  = null;

%>
<HEAD>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>	
<script language="javascript" src="../../eCommon/js/common.js" ></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
<script language="javascript" src="../../eXH/js/Validate.js" ></script>
<script language="javascript" src="../../eXH/js/DataGroupId.js" ></script>
<Script Language="JavaScript" src="../../eCommon/js/CommonLookup.js"></Script>
<script language="JavaScript">

function enblAddDetails(){
	document.forms[0].add_butt.disabled = false;
	document.forms[0].new_butt.disabled = true;
}
</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
<BODY  leftmargin=0 topmargin=0 onMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>

<form name="DatagroupId_setup_form" id="DatagroupId_setup_form" target='messageFrame' method='post' action='../../servlet/eXH.DataGroupIdAddModifyServlet'>

<table cellspacing=0 cellpadding=3 width='102%' align=center>
<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>


<tr>
<td class=label >Data</td> 

<td class='fields'>
<%
try
{

con=ConnectionManager.getConnection();
//String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP WHERE //LANGUAGE_ID='"+locale+"' ORDER BY 2";
String qry = "SELECT DATA_GROUP_ID,DESCRIPTION FROM XH_DATA_GROUP ORDER BY 2";
stmt = con.createStatement();
rs = stmt.executeQuery(qry);
%>
<!--
<select class='select' name='"+name+"' id='"+name+"'  "+disabled+"  onChange='onSelectMessageType(this)'> -->
<select class='select' name='dg_code' id='dg_code' onChange='enblAddDetails();' <%=mode.equals("U")?"readonly":""%> >
            <option value=''>-------Select-------</option>
<%
	
	while(rs.next())
            {     
			  if ((rs.getString(1)+"").equalsIgnoreCase(defaultval))
              {
				 
				 
				 selected = "selected";
              }
              else
              {
                 selected = " ";
              }
				 
			

%>
	<option value='<%=rs.getString(1)%>'  <%=selected%> ><%=rs.getString(2)%></option>
            
		<% 	}%>

</select>
<%

}catch(Exception e1){
	System.out.println("(DataGroupIdSelectMaster.jsp:Exceptions)"+e1.toString());
	e1.printStackTrace(System.err);
}

%>
<img src='../../eCommon/images/mandatory.gif' align=middle></td>
<td> </td> <td> </td></tr>

<!--
<tr>
	<td class=label ><fmt:message key="eXH.DataGroupCode.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=dg_code size=10 value='<%=dg_code%>'  title='DataGroup Code' <%=mode.equals("U")?"readonly":""%> > <img src='../../eCommon/images/mandatory.gif' align=middle>
	</td>
	<td> </td> <td> </td>
</tr>

<tr>
	<td class=label ><fmt:message key="eXH.DataGroupDesc.Label" bundle="${xh_labels}"/></td>
	<td align=left><input type=text name=dg_desc size=10 value='<%=dg_desc%>' > <img src='../../eCommon/images/mandatory.gif' align=middle></td>
	<td> </td> <td> </td>
</tr>
-->
<tr><td colspan=4 class='BUTTON'>
<input class='button' type="button"  name='new_butt' id='new_butt' value='New Data Group'
onClick='funNew()'>
<!-- <fmt:message key="eXH.NewDataGroup.Label" bundle="${xh_labels}"/> --> 
<input class='button' type="button"  name='add_butt' id='add_butt' value='Add Details'  disabled onClick='funAdd()'>
<!-- <fmt:message key="eXH.AddDetails.Label" bundle="${xh_labels}"/> -->
<input class='button' type="button"  name='Search' id='Search' value='Search' onClick='funSearch()'>
</td>
</tr>

<tr>
	<td width='40%'></td>
	<td width='60%'></td>
</tr>
</table>
<%
		if(stmt!=null)stmt.close();
		if(rs!=null)rs.close();
		ConnectionManager.returnConnection(con);
%>

<input type=hidden name=act_mode value='<%=mode%>'>
<input type=hidden name=detail_flag value='<%=detail_flag%>'>


</form>

</BODY>
</HTML> 

