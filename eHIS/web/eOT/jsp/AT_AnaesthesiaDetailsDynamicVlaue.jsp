<!DOCTYPE html>
<%@page  import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>

<html>
<head>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel="StyleSheet" type="text/css" href="../../eCommon/html/<%=sStyle%>"></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	
</head>
<%
	String patient_id = request.getParameter("patient_id");
	String patient_name="";
	String sql_patient_name="SELECT PATIENT_NAME FROM MP_PATIENT WHERE PATIENT_ID ='"+patient_id+"'";
	Connection connection   = null ;
	Statement stmt = null ;
	ResultSet resultSet     = null ;
	try{
			connection			= ConnectionManager.getConnection(request);
			stmt				= connection.createStatement() ;
			resultSet			= stmt.executeQuery(sql_patient_name);
			while(resultSet!=null && resultSet.next())
				{
					patient_name = resultSet.getString("SHORT_NAME");
				}
		}catch (Exception e) {
            e.printStackTrace() ;
		}finally {
            try{						
					if(resultSet!=null) resultSet.close();
					if(stmt!=null) stmt.close();
					if(connection!=null) ConnectionManager.returnConnection(connection,request);
				}catch(Exception es){es.printStackTrace();}
        }
%>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="form_temp" id="form_temp" >
<script>
	parent.frames[2].frames[0].document.RecordAnesthesiaDetailsForm.patient_name.value='<%=patient_name%>';
	parent.frames[2].frames[0].document.RecordAnesthesiaDetailsForm.patient_name.disabled=true;
</script>
</form>
</body>
</html>




