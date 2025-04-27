<%@page import ="java.sql.*,java.util.*,java.io.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<jsp:useBean id="obj"   scope="page"  class="webbeans.eCommon.XMLStringParser" />


<%
    Hashtable hash = (Hashtable)obj.parseXMLString( request ) ;
 	hash = (Hashtable)hash.get("SEARCH") ;
	Connection con = null;
	Statement stmt = null;
    ResultSet rs = null ;
    try
    {
            
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			String facility_id = (String) session.getValue("facility_id");
			String PractID = (String) hash.get("PractID") ;
			if(PractID == null) PractID="";

                
            String sql ="select 'X' from op_pract_for_clinic where facility_id = '"+facility_id+"' and practitioner_id = '"+PractID+"'";
			rs = stmt.executeQuery(sql) ;			
			if (rs.next())
			{
			%>
				alert(parent.frames[1].getMessage("PRACT_EXISTS_CLINIC_NU","AM"));
				parent.frames[1].document.forms[0].pract_id_exists.value='Y';
			    
			<% if(rs!=null)rs.close();}			
			else
			{
				sql = "select 'X' from ip_nursing_unit_for_pract where facility_id = '"+facility_id+"' and practitioner_id = '"+PractID+"'";
				rs = stmt.executeQuery(sql) ;
				if (rs.next())
				{	
				%>
					alert(parent.frames[1].getMessage("PRACT_EXISTS_CLINIC_NU","AM"));
					parent.frames[1].document.forms[0].pract_id_exists.value='Y';
				<%}			
				else
				{%>
					parent.frames[1].document.forms[0].pract_id_exists.value='N';
				<%}
			}
    hash.clear();}
    catch(Exception e){out.println("tst "+e);}
    finally
    {
        if(rs != null)  rs.close() ;
		if(stmt!=null) stmt.close();
		ConnectionManager.returnConnection(con,request);
		
    }
   
    %>
