<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%//@page contentType="text/html;charset=" import="java.util.*, eOT.*, eCommon.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%@page  contentType="text/html;charset=UTF-8" %>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<% request.setCharacterEncoding("UTF-8");%>
<%@page  import ="java.sql.Connection,java.sql.Statement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*"%>

<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/Common.jsp" %>
<%-- Mandatory declarations end --%>
<html>
<head>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eOT/js/AT_RecordAnesthesiaDetails.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<body  OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="form_temp" id="form_temp" >
<%
	String facility_id		= request.getParameter("facility_id");
	String theatre_type		= request.getParameter("theatre_type");
	String theatre_code="";
	String theatre_desc="";
	//String sql_patient_name="SELECT SHORT_DESC THEATRE_DESC, OPER_ROOM_CODE THEATRE_CODE FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = '"+facility_id+"' AND THEATRE_TYPE ='"+theatre_type+"' ORDER BY 1";
	String sql_patient_name="SELECT SHORT_DESC THEATRE_DESC, OPER_ROOM_CODE THEATRE_CODE FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"' AND THEATRE_TYPE ='"+theatre_type+"' ORDER BY 1";

	Connection connection   = null ;
	Statement stmt = null ;
	ResultSet resultSet     = null ;
	try{
			connection			= ConnectionManager.getConnection(request);
			stmt				= connection.createStatement() ;
			resultSet			= stmt.executeQuery(sql_patient_name);
			
			String comp="parent.interacive_query_hdr.document.forms[0].theatre";

			while(resultSet!=null && resultSet.next())
				{
					theatre_code = resultSet.getString("THEATRE_CODE");
					theatre_desc = resultSet.getString("THEATRE_DESC");
					%>
					<script>
						var temp_code='<%=theatre_code%>';
						var temp_desc='<%=theatre_desc%>';

						var opt=parent.interacive_query_hdr.document.createElement("OPTION");
						opt.text=temp_desc;
						opt.value=temp_code;
						var comp=<%=comp%>;
						comp.add(opt);

					</script>
	<%
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
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>




