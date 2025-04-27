<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" import="java.io.*, java.sql.*, java.util.*, java.net.*, java.text.*, javax.ejb.*, java.rmi.*, javax.rmi.*, eMP.PatSearch.*, webbeans.eCommon.*, javax.naming.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>

<%
		String sessionID = session.getId();
		InitialContext context = new InitialContext();
		PatSearchRemote patSearchRemote = null;
		boolean ejbInJNDI = true;
		try{
			patSearchRemote = (PatSearchRemote)context.lookup(sessionID);
			if (patSearchRemote == null)ejbInJNDI = false;
		}catch(NameNotFoundException exc){
			ejbInJNDI = false;
		}		
		if (ejbInJNDI){
		  context.unbind(sessionID);
		  patSearchRemote.remove();
		}
%>
<html>
<body onLoad="window.close()" onKeyDown='lockKey()' >
<form>
</form>
</body>
</html>

