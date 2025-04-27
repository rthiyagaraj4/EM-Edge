<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.PastRecords.label" bundle="${ca_labels}"/></title>
		<%
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
		<body onKeyDown="lockKey()">
			<form name='ChartRecordingSplChtSplGrpForm' id='ChartRecordingSplChtSplGrpForm'>
				<table border='0' cellpadding='0' cellspacing='0' width='100%'>
					<tr>
						<td class='label' width='30%'><fmt:message key="Common.Chart.label" bundle="${common_labels}"/> <fmt:message key="Common.Group.label" bundle="${common_labels}"/></td>
						<td class='label' width='70%'>
						<select name="splChrtGrp" id="splChrtGrp" onChange='loadKeyValPage(this)'>
				<%
					String splChtType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
					String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
					String chart_id = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");

					java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
					String locale = (String) p.getProperty("LOCALE");

					String grpId = "";
					String grpDesc = "";
					Connection con = null;
					PreparedStatement ps = null;
					ResultSet res = null;

					String sqlGrpId = "select SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC from CA_SPL_CHTY_GRP_LANG_VW where SPL_CHART_TYPE = ? AND LANGUAGE_ID = ?";

					try
					{
						con = ConnectionManager.getConnection(request);
						ps = con.prepareStatement(sqlGrpId);
						ps.setString(1,splChtType);
						ps.setString(2,locale);
						res = ps.executeQuery();

						while(res.next())
						{
							grpId = res.getString("SPL_CHART_TYPE_GRP_ID");
							grpDesc = res.getString("SPL_CHART_TYPE_GRP_DESC");
							//out.println("<input type='radio' name='splChrtGrp' id='splChrtGrp' value='"+grpId+"' onclick='loadKeyValPage(this)'><b>"+grpDesc+"</b></input>");
							out.println("<option  value='"+grpId+"' onclick='loadKeyValPage(this)'><b>"+grpDesc+"</b></option>");
						}
						
						if(res != null) res.close();
						if(ps != null) ps.close();
					}
					catch(Exception e)
					{
						
						e.printStackTrace();
					}
					finally
					{
						if(con!=null) ConnectionManager.returnConnection(con,request);
					}

				%>
					</select>
				</td>
				</tr>
				</table>
				<input type='hidden' name='chart_id' id='chart_id' value='<%=chart_id%>'>
				<input type='hidden' name='patient_id' id='patient_id' value='<%=patient_id%>'>
				<input type='hidden' name='splChtType' id='splChtType' value='<%=splChtType%>'>
			</form>
		</body>
		<script>
			//document.ChartRecordingSplChtSplGrpForm.splChrtGrp[0].click();
			loadKeyValPage(document.ChartRecordingSplChtSplGrpForm.splChrtGrp);
		</script>
</html>

