<!-- Last Modified Date Time : 9/23/2005 5:25 PM --> 

<jsp:useBean id="obj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%@ page import="java.sql.Connection, java.sql.Statement, java.sql.ResultSet, java.util.Hashtable, webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
	request.setCharacterEncoding("UTF-8");%>

<%
    Hashtable hash	= (Hashtable)obj.parseXMLString(request);
 	hash			= (Hashtable)hash.get("SEARCH");

	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
    try
    {
		con	= ConnectionManager.getConnection(request);
        stmt = con.createStatement();
           
		String frmObj		= (String) hash.get("frmObj");
		String toObj		= (String) hash.get("toObj");
		String param_val	= (String) hash.get("param_val") ;

		if(frmObj == null) frmObj = "";
		if(toObj == null) toObj = "";
		if(param_val == null) param_val = "";
			
		param_val = new String(param_val.getBytes(),"UTF-8");

		String sql ="";
        
        if(!frmObj.substring(frmObj.length()-1).equals("6"))
        {
			if(frmObj.indexOf("oth_lang")==-1)
            {
				param_val=param_val.toUpperCase( );
                sql ="select other_name_loc_lang  from mp_std_other_name where upper(other_name)='"+ param_val +"'" ;					
			}
            else
			{
				sql ="select other_name from mp_std_other_name where other_name_loc_lang='"+ param_val +"'" ;
			}
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				if(rs.next())
				{
					String objValue = rs.getString(1);
					%>	
					var strobj = eval('document.forms[0].<%=toObj%>');
					strobj.value = '<%=objValue%>'
					<%
				}
			}
			if(rs != null)  rs.close();
		}
		else
		{
			if(frmObj.indexOf("oth_lang")==-1)
			{
				param_val = param_val.toUpperCase( );
				sql = "select last_name_loc_lang from mp_std_family_name where upper(last_name)='"+ param_val +"' ";
			}
			else
			{
				sql = "select last_name from mp_std_family_name where last_name_loc_lang='"+ param_val +"' ";
			}
			rs = stmt.executeQuery(sql) ;
			if(rs!=null)
			{
				if(rs.next())
				{
					String objValue = rs.getString(1);	
					%>	
					var strobj = eval('document.forms[0].<%=toObj%>');						
					strobj.value = '<%=objValue%>'
					<%
				}
			}
			if(rs != null)  rs.close() ;
		}
		if(stmt!=null) stmt.close();

		hash.clear();
	}
	catch(Exception e){out.println("tst "+e);}
	finally
	{	
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	%>
