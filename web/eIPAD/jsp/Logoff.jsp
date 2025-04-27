<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%
try{
//	java.sql.Connection con = (java.sql.Connection) session.getValue( "connection" ) ;
	/*java.sql.*/

	

	String valueNames[] = session.getValueNames();
		for(int i=0;i<valueNames.length;i++){
			String attribute = (String)valueNames[i];
			session.removeValue(attribute);
		}

	session.invalidate();
}catch(Exception e){out.println(e);
//e.printStackTrace();
}
			finally {
                try
                {

                } catch(Exception e) {}
}
%>
