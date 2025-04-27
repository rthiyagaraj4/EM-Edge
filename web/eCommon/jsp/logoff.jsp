<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8" import= "java.util.*,java.sql.*,java.text.*,java.sql.*,webbeans.eCommon.*" %>
<%@include file="GetPersistenceBean.jsp" %>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<jsp:include page="CommonClearObjects.jsp?from=logoff" />


<%

try{
//	java.sql.Connection con = (java.sql.Connection) session.getValue( "connection" ) ;
	/*java.sql.*/

	cleanAll(session);

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

 <body onKeyDown = 'lockKey()' onLoad="parent.close();">
</body>

