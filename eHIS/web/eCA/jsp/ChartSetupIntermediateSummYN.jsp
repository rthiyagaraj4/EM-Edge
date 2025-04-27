<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8"); %>
<html>
	<head>
		<title><fmt:message key="eCA.ChartSetUpIntermediate.label" bundle="${ca_labels}"/></title>
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/ChartSetup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form name='tempformSummYN' id='tempformSummYN'>
			<%
				String chart_id = request.getParameter("ch_id") == null? "":request.getParameter("ch_id");
				String sqlSummYN = "";
				String summYN = "";
			
			
				Connection con = null;
				PreparedStatement psSummYN = null;
				ResultSet resSummYN = null;
				
				try{
					sqlSummYN = "select summary_req_yn from ca_chart where chart_id = ?";
					con = ConnectionManager.getConnection(request);
					psSummYN = con.prepareStatement(sqlSummYN);
					psSummYN.setString(1,chart_id);
					resSummYN = psSummYN.executeQuery();

					while(resSummYN.next()){
						summYN = resSummYN.getString(1);				
					}

					if(summYN.equals("Y")){
					%>
					<script>
						var confirmSelect = window.confirm(getMessage("REVERSE_SUMMARY_SELECTION","CA"));						 
						if(confirmSelect == true){
							parent.f_query_add_mod.document.AddModifyChartSetupForm.summ_req_yn.value = 'N';
						}
						else{
							parent.f_query_add_mod.document.AddModifyChartSetupForm.summ_req_yn.value = 'Y';
							parent.f_query_add_mod.location.reload();
						}						
					</script>
					<%
					}
					if(resSummYN != null) resSummYN.close();
					if(psSummYN != null) psSummYN.close();
				}
				catch(Exception e){
					out.println("Exception in ChartSetupIntermediateSummYN.jsp"+e.toString());
				}
				finally
				{
					if(con != null) ConnectionManager.returnConnection(con,request);
				}
			%>
		</form>
	</body>
</html>

