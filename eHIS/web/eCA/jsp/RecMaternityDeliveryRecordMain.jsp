<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.RecMaternityConsMain.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
			String queryString = request.getQueryString() == null ? "" : request.getQueryString();

			String facility_id       = (String) session.getValue("facility_id");
//			String encounter_id	=	request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
			String mother_patient_id	=	request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
			String cycle_no	=	request.getParameter("cycle_no")==null?"":request.getParameter("cycle_no");
			String splt_event_status	=	request.getParameter("splt_event_status")==null?"":request.getParameter("splt_event_status");
			String modevalue = "";
//			int count = 0;
			Connection			con		=	null;
			PreparedStatement	pstmt	=	null;
			ResultSet			rs		=	null;
			String query_section_details		=	"";
			String finalize_yn		=	"N";
		
			

			try
			{		
					con = ConnectionManager.getConnection();
					//query_section_details="SELECT FINALIZE_YN FROM CA_SPL_DELIVERY_RECORD WHERE FACILITY_ID = ? AND MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";		
					query_section_details="SELECT FINALIZE_YN FROM CA_SPL_DELIVERY_RECORD WHERE  MOTHER_PATIENT_ID = ? AND CYCLE_NO = ?";		
				
					pstmt		=	con.prepareStatement(query_section_details);
									
					//pstmt.setString(1,facility_id);
					//pstmt.setString(2,encounter_id);
					pstmt.setString(1,mother_patient_id);
					pstmt.setString(2,cycle_no);
					
					rs	 =	pstmt.executeQuery();

					if (rs.next()){									
						finalize_yn = rs.getString("FINALIZE_YN")==null?"N":rs.getString("FINALIZE_YN");
						modevalue = "Update";
					}					
				 if(rs != null) rs.close();
				 if(pstmt != null) pstmt.close();

			}catch(Exception e)
			{
				e.printStackTrace();
			}
			finally
			{
				if(con!=null)	ConnectionManager.returnConnection(con,request);
			} 
			if(splt_event_status.equals("C"))
			{
				finalize_yn ="Y";
			}

		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
	</head>

	<frameset rows='*,5%' framespacing='0' frameborder='1'>	
		<%if(finalize_yn.equals("N")) {				
			%>
			<frame name='recMatDeliveryDetails' id='recMatDeliveryDetails'   src='../../eCA/jsp/RecMaternityDeliveryRecord.jsp?<%=queryString%>&modevalue=<%=modevalue%>' frameborder="yes" scrolling="no" ></frame>
		 <%}else{
					modevalue = "V";
				%>
			<frame name='recMatDeliveryView' id='recMatDeliveryView' src='../../eCA/jsp/RecMaternityDeliveryView.jsp?<%=queryString%>' frameborder="yes" scrolling="yes" ></frame> 
		 <%}%> 
		<frame name='recMatConsBtnsFrame' id='recMatConsBtnsFrame' src='../../eCA/jsp/RecMaternityConsDeliveryToolbar.jsp?modeValue=<%=modevalue%>' frameborder="yes" scrolling="no" ></frame>		
	</frameset>
</html>

<script>
top.content.messageFrame.location.href='../../eCommon/jsp/error.jsp';
</script>

