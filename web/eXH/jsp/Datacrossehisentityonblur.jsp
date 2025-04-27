<!DOCTYPE html>
 
<%@ page contentType="text/html;charset=UTF-8"  import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.*" %>

<html>
<head>
<title><fmt:message key="eOA.SecondaryResources.label" bundle="${oa_labels}"/></title>
<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<Script src="../../eCommon/js/common.js" language="JavaScript"></Script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language="javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="JavaScript">

function Message() 
{
	
}


</script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey()'>
 <table border='1' cellpadding='0' cellspacing='0' wrap width='102%' align='center' >
<%
String Translateentity="";
String ehisentity=request.getParameter("ehisentity");
String Title=request.getParameter("Title");
//System.out.println("String ehisentity"+ehisentity); 
ResultSet rs=null;														   
Statement stmt=null;
Connection con=null;
String sqlStmt="select  distinct TRANS_TABLE_ID from XH_MAPPING "+
				"WHERE MASTER_TABLE_ID='"+ehisentity+"' "; 

//System.out.println("(Datacrossehisentityonblur.jsp:sqlTransTableIDQuery) : "+sqlStmt);
try
{
	con = ConnectionManager.getConnection();
	stmt = con.createStatement();
	rs = stmt.executeQuery(sqlStmt);
while(rs.next())
	{
Translateentity=rs.getString(1); 
	}
	if(rs!=null)rs.close();
	if(stmt!=null)stmt.close();

}
catch(Exception ex)
{
	System.out.println("Datacrossehisentityonblur.jsp:error  :"+ex.toString());
}
finally
{
	ConnectionManager.returnConnection(con);
}





%>

 <tr>
			 <td  class='PATIENTLINECOLOROTHLANG'  nowrap width='30%' align='left' colspan='2'><font size='-1'><b><%=Title%></b></font></td></tr>
<tr>
<input type=hidden name='Translateentity' id='Translateentity' value='<%=Translateentity%>' >
</tr>

<script>


window.returnValue='<%=Translateentity%>';
window.close();
</script>
</table>
</body>
</html> 

