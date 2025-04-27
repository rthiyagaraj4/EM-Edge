<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
 <%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<title><fmt:message key="eCA.ViewPatientListbyProviderService.label" bundle="${ca_labels}"/></title>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	</head>
	<%
	Connection con	= null;
	PreparedStatement stmt	= null;
	ResultSet rs	= null;
	String reln_req_yn="", firstFrameSrc  = "";
	try
	{	
		con		=	ConnectionManager.getConnection(request);
		String sql_query="select establish_reln_req_yn from ca_encntr_param";
		stmt	=	con.prepareStatement(sql_query);
		rs		=	stmt.executeQuery();

		if(rs.next())
		{
			reln_req_yn = rs.getString("establish_reln_req_yn");
		}
		if((reln_req_yn == null) || reln_req_yn.equals("null"))reln_req_yn="N";

		if(rs!=null) rs.close();
		if(stmt != null)stmt.close();
	}
	catch(Exception e)
	{
		//out.println("Exception in getting connection"+e);//common-icn-0181
		e.printStackTrace();//COMMON-ICN-0181
	}
	finally
	{
		
		if(con!=null)
			ConnectionManager.returnConnection(con,request);
	}

	if(reln_req_yn.equals("Y"))
	{
		firstFrameSrc  = "../jsp/PatListByRelnProvCriteria.jsp";
	}
	else
	{
		firstFrameSrc  = "../jsp/PatListByRelnProvCriteria.jsp";
	}

	%>
	<!-- Modified by kishore kumar N on 19-12-2008 for CRF 0387, altered farmeset size. -->
	<iframe name='PatCriteriaFr' id='PatCriteriaFr' src='<%=firstFrameSrc%>' frameborder=0 scrolling='no' noresize style='height:40vh;width:98vw'></iframe>
		<iframe name='PatResultFr' id='PatResultFr' src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto' noresize  style='height:50vh;width:98vw'></iframe>
		<iframe name='colorRefframe' id='colorRefframe' src='CAPatColorReference.jsp?reln_req_yn=<%=reln_req_yn%>' noresize  frameborder=1  marginheight=0 marginwidth=0 SCROLLING='no' class='normal' style='height:7vh;width:98vw'></iframe>
</html>

