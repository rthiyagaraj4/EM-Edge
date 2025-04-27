<!DOCTYPE html>
 <%/* 
--------------------------------------------------------------------------------------------------------------------
Date		Edit History		Name		Description
--------------------------------------------------------------------------------------------------------------------
	
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page import="java.sql.*, java.util.*, java.text.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
	<head>
	

		<%
			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request); 
			response.addHeader("X-XSS-Protection", "1; mode=block"); 
			response.addHeader("X-Content-Type-Options", "nosniff"); 
			String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
			String params = request.getQueryString() ;
			String source = url + params ;
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			Connection con = null;
			PreparedStatement stmt=null; 
			ResultSet rset =null;
			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			String login_user=(String)session.getValue("login_user");
			try{
				con =  ConnectionManager.getConnection(request);
				
				String sql= "select func_role_id, AM_GET_DESC.AM_PRACTITIONER(func_role_id,?,'1') practitioner_name from sm_appl_user where appl_user_id = ? and func_role ='P' ";
				String func_role_id="",practitioner_name="";
	
				stmt=con.prepareStatement(sql);
				stmt.setString(1,locale);
				stmt.setString(2,login_user);
	
				rset=stmt.executeQuery();	
				if(rset !=null && rset.next()){
					func_role_id=rset.getString("func_role_id");
					if(func_role_id == null) func_role_id="";

					practitioner_name=rset.getString("practitioner_name");
					if(practitioner_name == null) practitioner_name="";
					
					session.putValue("ca_practitioner_id",func_role_id);
					session.putValue("practitioner_name",practitioner_name);
					//System.out.println("------------func_role_id----->"+func_role_id);
					//System.out.println("-----------practitioner_name------>"+practitioner_name);
				}
				
			}catch(Exception e){
				e.printStackTrace();
			}
			finally{
				if (rset !=null) rset.close();
				if (stmt!=null) stmt.close();
				if (con !=null) ConnectionManager.returnConnection(con,request);				

			}	
			
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language="JavaScript" src="../js/PhQuotaLimitApproval.js"></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


	

	</head>
	
	<iframe name="commontoolbarFrame" id="commontoolbarFrame" frameborder="0" scrolling="no" noresize src="<%=source%>" style="height:9vh;width:100vw"></iframe><iframe name='QuotaLimitApprovalCriteriaFrame' id='QuotaLimitApprovalCriteriaFrame' src='PhQuotaLimitApprovalCriteria.jsp?<%=request.getQueryString()%>' frameborder=0 scrolling='no' noresize style='height:19vh;width:100vw'></iframe>
	<iframe name='QuotaLimitApprovalBottom' id='QuotaLimitApprovalBottom' src='../../eCommon/html/blank.html' frameborder=0 scrolling='no' style='height:63vh;width:100vw'></iframe><iframe name="messageFrame" id="messageFrame" src="../../eCommon/jsp/error.jsp" frameborder="0" noresize scrolling="auto" style="height:9vh;width:100vw"></iframe>	
</html>

