<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartSetUpIntermediateUpdateComponentTable.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/ChartSetup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='tempformUpdateCopmTab' id='tempformUpdateCopmTab'>
		<%			
			request.setCharacterEncoding("UTF-8");	
			String chart_id = request.getParameter("ch_id") == null?"":request.getParameter("ch_id");
						
			String sqlCompTab = "";
			String nullString = "";

			int i = 0;

			Connection con = null;
			PreparedStatement psCompTab = null;
			//ResultSet resCompTab = null;
			try{
				con = ConnectionManager.getConnection(request);
				sqlCompTab = "update ca_chart_section_comp set SUM_YN = ?, SUMMARY_TYPE = ?, SUMMRY_COLUMN = ? where chart_id = ?";
				psCompTab = con.prepareStatement(sqlCompTab);
				psCompTab.setString(1,"N");
				psCompTab.setString(2,nullString);
				psCompTab.setString(3,nullString);
				psCompTab.setString(4,chart_id);
				i = psCompTab.executeUpdate();

				if(i != 0){
					con.commit();
				}
				else{
					con.rollback();
				}
				if(psCompTab != null) psCompTab.close();
			}//end of try-2
			catch(Exception e){
				//out.println("Exception in ChartSetupIntermediateUpdateCompTab.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
				//if(resUpdateTab != null) resUpdateTab.close();
				
				if(con != null) ConnectionManager.returnConnection(con,request);
			}
		%>			
		</form>
	</body>
</html>

