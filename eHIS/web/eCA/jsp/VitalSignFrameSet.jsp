<!DOCTYPE html>
<%
/* 
--------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
--------------------------------------------------------------------------------------------------------------------			 	
11/04/2019	IN069244		Ramya Maddena		25/01/2019		Ramesh Goli		MMS-KH-CRF-0005.1
01/07/2020	IN072777		Ramesh Goli			01/07/2020		Ramesh Goli		AAKH-CRF-0097.2
19/10/2023         32779                     Srinivasa N T                                   Ramesh Goli           AAKH-CRF-0165
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eCA.*, eCA.Common.*, eCommon.Common.*,java.text.DecimalFormat,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String graphMode ="";
	Connection con=null;
	String interval = request.getParameter("interval_val");
	PreparedStatement pstmt=null;
	ResultSet rs=null;
	try{
		
		con=ConnectionManager.getConnection(request);
		String sql="SELECT THIRDPARTY_VITALS_VIEW FROM CA_PARAM";
		boolean siteUom =eCommon.Common.CommonBean.isSiteSpecific(con, "CA","UOM_DETAILS");//AAKH-CRF-0165
		//System.out.println("@@@@@------siteUom@@@34---"+siteUom);
		pstmt=con.prepareStatement(sql);
		rs=pstmt.executeQuery();
		if(rs.next())
			 graphMode=rs.getString("THIRDPARTY_VITALS_VIEW")==null?"T":rs.getString("THIRDPARTY_VITALS_VIEW");
		
		session.setAttribute("graphMode", graphMode);//32779
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script src="../../eCommon/js/common.js"></script>
	<script language="JavaScript" src="../js/VitalSign.js"></script>
	<script src="../../eCommon/js/messages.js"></script></head>
	
	<frameset rows="90%,10%">
		<%if("G".equals(graphMode)){%>
			<frameset cols="35%,65%" border=1 >
				<frame name='VitalSignDetals' src="../../eCA/jsp/InterfacedVitalSignDetals.jsp?<%=request.getQueryString()%>&graphMode=<%=graphMode%>" frameborder=1 style="overflow-x:hidden;" scrolling="auto" noresize></frame>
				<frame name='VitalSignGraphDetals' src="../../eCA/jsp/blank.jsp" frameborder=1  scrolling="auto" noresize></frame>
			</frameset>		
		<%}else if("T".equals(graphMode)){%>
		<frameset cols="25%,75%" border=1 > <!-- AAKH-CRF-0165 -->
			<frame name='VitalSignDetals' src="../../eCA/jsp/blank.jsp" frameborder=1 style="overflow-x:hidden;" scrolling="auto" noresize></frame> <!-- IN072777 -->
			<frame name='VitalSignFrame' src="../../eCA/jsp/VitalSignResult.jsp?<%=request.getQueryString()%>&graphMode=<%=graphMode%>" frameborder=1 style="overflow-x:hidden;" scrolling="auto" noresize></frame>
						
		</frameset> <!-- IN072777 -->

		<%}else if(siteUom) {%>
		<frameset cols="25%,75%" border=1 > <!-- 32779 -->
			<frame name='VitalSignDetals' src="../../eCA/jsp/blank.jsp" frameborder=1 style="overflow-x:hidden;" scrolling="auto" noresize></frame> <!-- IN072777 -->
		<frame name='VitalSignFrame' src="../../eCA/jsp/VitalSignDTResult.jsp?<%=request.getQueryString()%>&graphMode=<%=graphMode%>" frameborder=1 style="overflow-x:hidden;" scrolling="auto" noresize></frame>
									
		</frameset> <!-- 32779 -->
		<%}%>
		<frame name='VitalSignButtonFrm' src= "" scrolling='no' frameborder=0 noresize></frame>
	</frameset>	
</html>
<% 	}catch(Exception e)
	{
		e.printStackTrace();
	}finally{
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(con != null)ConnectionManager.returnConnection(con,request);
	}
	%>
