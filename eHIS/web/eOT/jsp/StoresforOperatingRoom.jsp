<!DOCTYPE html>
<%@ page import ="java.sql.Connection,java.sql.ResultSet,java.sql.Types,java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager,eCommon.XSSRequestWrapper" contentType=" text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%@ page contentType=" text/html;charset=UTF-8" %>
<% request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<html>
	<head>
 	 <script language='javascript' src='../../eOT/js/StoresforOperatingRoom.js'></script> 
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eOT/js/Hashtable.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%
		String url = "../../eCommon/jsp/MstCodeToolbar.jsp?" ;
		String params = request.getQueryString() ;
		String function_id=request.getParameter("function_id");
		String facility_id = (String)session.getValue("facility_id");
		String source = url + params ;

	String SQL = "SELECT ST_INTERFACE_FLAG,REC_SURG_ACCESSORIES_UNDER FROM ot_param_for_facility  WHERE  OPERATING_FACILITY_ID=?";
	Connection con = null;
	PreparedStatement pstmt= null;
	ResultSet rst = null;
	String st_interface_flag_YN="";
	try{
			con = ConnectionManager.getConnection();
			pstmt=con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			rst = pstmt.executeQuery();
			while(rst.next()){
				st_interface_flag_YN= checkForNull(rst.getString(1),"N");
			}
		}catch(Exception e){
		e.printStackTrace();
		//System.err.println("Err Msg from Stores For Operating Room .jsp "+e);
	}finally{
		if(pstmt!=null)pstmt.close();
		if(con!=null)con.close();
	}


	%>
	<iframe name='commontoolbarFrame' id='commontoolbarFrame'	src=<%=source%>  scrolling='no' noresize style='height:8vh;width:100vw' frameborder='0'></iframe>
		<iframe name='f_query_add_mod' id='f_query_add_mod' src='../../eCommon/html/blank.html' scrolling="no" noresize style='height:83vh;width:100vw' frameborder='0'></iframe>
		<iframe name='messageFrame' id='messageFrame'	src='../../eCommon/jsp/MstCodeError.jsp'  noresize scrolling='auto' style='height:9vh;width:100vw' frameborder='0'></iframe>
		<iframe name='hidden_frame' id='hidden_frame'	src='../../eOT/jsp/CommonMasterObjectCollect.jsp'  noresize scrolling='' style='height:0vh;width:100vw' frameborder='0'></iframe>
</html>

<%
/*if(("OT_STORES_FOR_OPER_ROOM".equals(function_id)  && "N".equals(st_interface_flag_YN)) ){
		//out.println("<script>callAlertFunction('APP-OT0135')</script>");
		out.print(" <script>alert(getMessage('APP-OT0135','OT'));document.location.href='../../eCommon/jsp/dmenu.jsp';</script>");
	}*/
%>

