<!DOCTYPE html>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%@page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager" %>
<%
    Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
 	hash = (Hashtable)hash.get("SEARCH") ;
	Connection con = null;
    try
    {
		request.setCharacterEncoding("UTF-8");	

		con = ConnectionManager.getConnection(request);
        Statement stmt = null;
        ResultSet rs = null ;
        stmt = con.createStatement(); 
		String postal_code = (String) hash.get("postal_code") ;
		if (postal_code==null) postal_code ="";
		String res_area_code = (String) hash.get("res_area_code") ;
		if (res_area_code==null) res_area_code ="";
		String res_town_code = (String) hash.get("res_town_code") ;
		if (res_town_code==null) res_town_code ="";


        String mode = request.getParameter("mode") ;
		if (mode==null) mode="";
	
		
		
		
		String sql = "";
		
        if (!postal_code.equals(""))
		{
			sql = "select res_town_code from mp_postal_code where postal_code = '"+postal_code+"'";
			rs = stmt.executeQuery(sql);
			if (rs.next())
			{
				res_town_code = rs.getString(1);
				if (res_town_code==null) res_town_code=""; %>
				<script>
				if (document.getElementById('res_town_code') !=null) 	document.getElementById('res_town_code').value="<%=res_town_code%>";
				</script>
			<%}
			 if(rs!=null) 	rs.close();
	         if(stmt!=null) 	stmt.close();

		}

		if (!res_town_code.equals(""))
		{
			sql = "select res_area_code, region_code from mp_res_area where res_area_code =(select res_area_code from mp_res_town where res_town_code = '"+res_town_code+"')";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql);
			if (rs.next())
			{ %>
				<script>
		         if (document.getElementById('res_area_code') != null) document.getElementById('res_area_code').value="<%= (rs.getString(1)==null ? "" : rs.getString(1))%>";
				<% if (postal_code.equals("")) %>
					if (document.getElementById('postal_code') !=null) 			
						document.getElementById('postal_code').value = '';
				</script>
				<%		        
			}	
			if(rs!=null) 	rs.close();
	         if(stmt!=null) 	stmt.close();
		}

		if (!res_area_code.equals(""))
		{
			sql = "select region_code from mp_region where region_code = (select region_code from mp_res_area where res_area_code ='"+res_area_code+"')";
			stmt = con.createStatement(); 
			rs = stmt.executeQuery(sql);
			if (rs.next())
			{%>
			<script>
				if (document.getElementById('res_town_code') !=null) 
					document.getElementById('res_town_code').value='';	
			</script>
			<%}
		}		
		if(rs!=null) 	rs.close();
	    if(stmt!=null) 	stmt.close();
		hash.clear();
    }
    catch(Exception e){out.println("tst "+e);}
    finally
    {
        ConnectionManager.returnConnection(con,request);
    }   
    %>
