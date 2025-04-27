<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" 
import ="java.sql.*,java.util.*,webbeans.eCommon.*,eRS.*,eCommon.Common.* " %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	Connection con = null;
	Statement stmt_accessrights=null;
	ResultSet rs_accessrights=null;

	String clearAll="";
	String select="";
try
{
clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");
	
    	RecordSet	AccessRights	=	null;
		AccessRights	=	(webbeans.eCommon.RecordSet)	session.getAttribute("AccessRights");
		
		if(clearAll.equals("clearAll"))
		{	
			
			int n=AccessRights.getSize();
			for(int k=0;k<n;k++)
			{
				ArrayList al=new ArrayList();
                select="N";
                al=(ArrayList)AccessRights.getObject(k);
				al.set(1,select);
				AccessRights.setObject(k,al);
			}
		}
		else if(clearAll.equals("notCleared"))
		{
			int n=AccessRights.getSize();
			for(int k=0;k<n;k++)
			{
				ArrayList al=new ArrayList();
				select="Y";
                al=(ArrayList)AccessRights.getObject(k);
				al.set(1,select);
				AccessRights.setObject(k,al);
    		}
		}
%>
<html>
<head>
</head>
<body CLASS='MESSAGE'>
	<form name="Dynamic_form" id="Dynamic_form">
		<input type=hidden name=E value='<%=clearAll%>'>
		<input type=hidden name=R value=''>
		<input type=hidden name=S value=''>
		<input type=hidden name=X value=''>
		<input type=hidden name=Y value=''>
	</form>
</body>
</html>
<%
	}
	catch(Exception e){
	out.println(e.toString());
}
		finally{
        try
		{
		if(rs_accessrights!=null)
			  rs_accessrights.close();
		if(stmt_accessrights!=null)
			  stmt_accessrights.close();

		ConnectionManager.returnConnection(con,request);
		}
		catch(Exception exp)
		{
			out.println(exp.toString());
		}
	  }
%>

