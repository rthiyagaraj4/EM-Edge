<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=Edge" />		
<meta charset="utf-8">
<%@ page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%	
	request.setCharacterEncoding("UTF-8");
	
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	//IN073001 Start.
	String request_num = request.getParameter("request_num") == null ? "" : request.getParameter("request_num");
	String request_line_num = request.getParameter("request_line_num") == null ? "" : request.getParameter("request_line_num");
	String direct_facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
%>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<html>
<%

	Connection con = null;
	PreparedStatement pstmt=null; 
	ResultSet rset =null;
	String jspBasedOnFunctionID = "";
	String pageCalledYN = (String) session.getAttribute("pageCalledYN");
	if(pageCalledYN == null) pageCalledYN = "N";

	String strSqlValidUser = "select preferred_style,(select facility_name from sm_facility_param where facility_id=?) facility_name  from sm_appl_user where UPPER(APPL_USER_ID)=UPPER(?) and APPL_USER_PASSWORD= app_password.ENCRYPT(UPPER(?)) ";
	String strSqlValidResp = "SELECT 1 FROM SM_RESP_FOR_USER WHERE UPPER(APPL_USER_ID)=UPPER(?) AND RESP_ID=? ";
	String sql_chartTitle = "select APPL_TASK_DESC from CA_APPL_TASK where option_id = ? ";

	PreparedStatement pstmtValidUser = null;
	PreparedStatement pstmtValidResp = null;

	String client_ip_address = "";
	client_ip_address = request.getRemoteAddr();
	String jdbc_props = "";
	String direct_resp_id = request.getParameter("responsibility_id") == null ? "" : request.getParameter("responsibility_id");
	String direct_login_user = request.getParameter("login_user") == null ? "" : request.getParameter("login_user");
	String direct_login_pwd = request.getParameter("login_pwd") == null ? "" : request.getParameter("login_pwd");
	String limit_function_id = request.getParameter("function_id") == null ? "" : request.getParameter("function_id");

	String preferred_style="",facility_name="";	
	String locale = request.getParameter("locale") == null ? "" : request.getParameter("locale");
	String calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");//V230106
	String visit_id = "";

	System.err.println("direct_login_user "+direct_login_user+" direct_login_pwd "+direct_login_pwd+" direct_facility_id "+direct_facility_id);

	session.putValue("responsibility_id",direct_resp_id);
	session.putValue("facility_id",direct_facility_id);
	session.putValue("login_user",direct_login_user);
	session.putValue("connection_pooling_yn","Y");
	Properties p = new Properties() ;
	p.setProperty( "login_user",direct_login_user ) ;
	p.setProperty("connection_pooling_yn","Y") ;
	p.setProperty("client_ip_address",client_ip_address) ;
	p.setProperty("jdbc_props",jdbc_props) ;
	p.setProperty("LOCALE",locale) ;
	session.putValue( "jdbc",p ) ;

	try{
		
		String query_string = (String) request.getQueryString();
		query_string = query_string + "&pageCalledYN="+ pageCalledYN;
		if(limit_function_id.equals("MOD_FIN_DTLS")){
			jspBasedOnFunctionID = "../../eBL/jsp/BLModifyFinancialDetailsMain.jsp";
		}else if(limit_function_id.equals("PRICE_LIST")){
			jspBasedOnFunctionID = "../../eBL/jsp/BLServItemPriceList.jsp";
		}else if(limit_function_id.equals("ENC_TRF_CHARGES")){
			jspBasedOnFunctionID = "../../eBL/jsp/BLEncTrfChargesMain.jsp";
		}
		
%>
		<jsp:include page="<%=jspBasedOnFunctionID%>" >
			<jsp:param name="flush" value="true" />
			<jsp:param name="facility_id"  value='<%=direct_facility_id%>'/>
			<jsp:param name="calledFrom"  value='managePatientPopup'/>
			<jsp:param name="login_user"  value='<%=direct_login_user%>'/>
			<jsp:param name="function_id"  value='<%=limit_function_id%>'/>
			<jsp:param name="responsibility_id"  value='EBL_MANAGER'/>
			<jsp:param name="pageCalledYN"  value='<%=pageCalledYN%>'/>
			<jsp:param name="locale"  value='<%=locale%>'/>
		</jsp:include> 
</html>
<%
	}
	catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if (pstmt!=null) pstmt.close();
		if (rset !=null) rset.close();

		if(con!=null)ConnectionManager.returnConnection(con,request);		
	}
%>


