<!DOCTYPE html>
<%@ page import= "java.sql.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		String patient_id= request.getParameter("patient_id");	
		String encounter_id= request.getParameter("episode_id");	//out.println("encounter_id"+encounter_id);
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		Connection con=null;
	%>
<html>
<head>
	<%
		String sStyle =

	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language='javascript' src='../../eCommon/js/common.js'></script><script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
</head>

	<%
		//String sql="select count(*) from mr_death_register_hdr where patient_id = '"+patient_id+"' and finalize_yn = 'N' ";//common-icn-0180
	String sql="select count(*) from mr_death_register_hdr where patient_id = ? and finalize_yn = 'N' ";//common-icn-0180
		int count =0;
		try
			{
				con=ConnectionManager.getConnection(request);
				pstmt=con.prepareStatement(sql);
				pstmt.setString(1,patient_id);//common-icn-0180
				rs=pstmt.executeQuery();
		
				if(rs!=null)
				{
					rs.next();
					count=rs.getInt(1);
				}
				if(count>0)
				{
	%>

			<frameset rows='*'>
				<frame name='f_query_add_mod' id='f_query_add_mod' 				src='../../eMR/jsp/PaintDeathRegisterPatient.jsp?patient_id=<%=patient_id%>&encounter_id=<%=encounter_id%>' frameborder=0 scrolling='no'> 
				<!-- <frame name='f_query_add_mod1' id='f_query_add_mod1' 	src='../../eCommon/html/blank.html' frameborder=0 scrolling='auto'>  -->
			</frameset>
<%
				}
				else
				{
					%>
						<script>
							alert(getMessage('DEATH_REG_NOT_APPL'));
						</script>
					<%
				}
			}catch(Exception e)
			{
				//out.println(e);//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally
			{
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();

				if(con!=null)ConnectionManager.returnConnection(con,request);
			}
					%>
				
				</html>

