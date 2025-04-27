<!DOCTYPE html>
<%@page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
	
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<title><fmt:message key="eCA.ViewPatientListbyMedicalService.label" bundle="${ca_labels}"/></title>
	</head>
	<%
			//Connection con = (Connection)session.getValue("connection");
			Connection con = ConnectionManager.getConnection(request);
			PreparedStatement stmt = null;
			String establishrelnreqyn = "";
			ResultSet rset = null;
			String queryString =request.getQueryString();

			try
			{
				String sql = " select establish_reln_req_yn  from ca_encntr_param ";
				//rset = stmt.executeQuery(sql);
				stmt = con.prepareStatement(sql);
				rset=stmt.executeQuery();
				if(rset.next())
				{
					establishrelnreqyn = rset.getString("establish_reln_req_yn")==null?"Y":rset.getString("establish_reln_req_yn");
				}
				if(rset!=null) rset.close();
				if(stmt!=null) stmt.close();
			}
			catch (Exception e)
			{
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
				
				if(con!=null)
					ConnectionManager.returnConnection(con,request);
			}
	%>
	
	<iframe name='PatCriteriaFr' id='PatCriteriaFr' src='RecentPatListDetails.jsp?<%=queryString%>&reln_req_yn=<%=establishrelnreqyn%>' frameborder=0 scrolling='auto' style='height:93vh;width:100vw'></iframe>
		<iframe name='colorRefframe' id='colorRefframe' src='CAPatColorReference.jsp?reln_req_yn=<%=establishrelnreqyn%>' noresize  frameborder=1  marginheight=0 marginwidth=0 SCROLLING='no' class='normal' style='height:5vh;width:100vw'></iframe>
	
</html>

