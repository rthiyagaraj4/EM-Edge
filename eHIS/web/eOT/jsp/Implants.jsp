<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.CallableStatement,webbeans.eCommon.ConnectionManager,eCommon.Common.CommonBean,java.sql.Types,eCommon.XSSRequestWrapper" %>

<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>

<html>
	<head>
 	<script language='javascript' src='../../eOT/js/Implants.js'></script>
	<script src="../../eCommon/js/common.js" language="javascript"></script>
	<script language='javascript' src='../../eCommon/js/CommonLookup.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


		</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String source = url + params ;
		String modules_list = "";
		String ph_module_yn="";
		String facility_id  = (String)session.getValue("facility_id");
		Connection connection = null;
		PreparedStatement pstmt = null;
		CallableStatement cstmt = null;

	try{
		connection = ConnectionManager.getConnection(request);
		//for checking whether the ph, or module is installed or not
		cstmt=connection.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("PH|")>=0) {
			ph_module_yn="Y";	// When PH is  Operational
		} else {
			ph_module_yn="N";	// When PH is not Operational
		}
	}catch(Exception e){
		e.printStackTrace();
		 //System.err.println("Err Msg in CheckModuleExistence: "+e.getMessage());
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){e.printStackTrace();}
	}

	params=params+"&ph_module_yn="+ph_module_yn+"&facility_id="+facility_id;
	source=source+"&ph_module_yn="+ph_module_yn+"&facility_id="+facility_id;
%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%> scrolling='no' noresize frameborder='0' style='height:8vh;width:100vw'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' noresize frameborder='0' style='height:83vh;width:100vw'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp' noresize frameborder='0' scrolling='auto' style='height:9vh;width:100vw'></iframe>
	<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
		<form name="ImplantsForm" id="ImplantsForm">
			<input type="hidden" name="params" id="params" value="<%=params%>">
			<input type="hidden" name="ph_module_yn" id="ph_module_yn" value="<%=ph_module_yn%>">
		</form>
	</body>
</html>

