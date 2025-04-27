<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.SpecialChartLinks.label" bundle="${ca_labels}"/></title>
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
		
		<body style='background-color:#E2E3F0;' onKeyDown="lockKey()">
			<form name='splChartLinksForm' id='splChartLinksForm'>
				<table border='1' cellpadding='0' cellspacing='0' width='100%'>
					<tr>
						<td class='CAGROUPHEADING' align='center' colspan='2'><fmt:message key="eCA.GrowthChart.label" bundle="${ca_labels}"/></td>
					</tr>
					<tr></tr>
				</table>
				<table class='grid' width='100%'>
					<tr>
						<td class='CACHARTFOURTHLEVELCOLOR' align='left' colspan='2'><fmt:message key="eCA.SpecificView.label" bundle="${ca_labels}"/></td>
					</tr>
				<%
					java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
					String locale = (String) p.getProperty("LOCALE");

					String splChartType = request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
					String patientID = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
					String encounterId = request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
					String facility_id = request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
					String chartID = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
					String Sex = request.getParameter("Sex") == null ? "" : request.getParameter("Sex");

					int i = 0;

					String graphCode = "";
					String graphDesc = "";
					String xAxisElementType = "";
					String yAxisElementType = "";
					String splChartTypeGrpId = "";
					String splChartTypeGrpDesc = "";
					String classValue = "";

					Connection con = null;
					PreparedStatement ps = null;
					PreparedStatement psSplGrpId = null;
					ResultSet res = null;
					ResultSet resSplGrpId = null;

					String sqlGrpId = "select SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC from CA_SPL_CHTY_GRP_LANG_VW where SPL_CHART_TYPE = ? AND LANGUAGE_ID = ?  AND EXISTS (SELECT 1 FROM CA_SPL_CHART_GRAPH WHERE SPL_CHART_TYPE=CA_SPL_CHTY_GRP_LANG_VW.SPL_CHART_TYPE AND SPL_CHART_TYPE_GRP_ID=CA_SPL_CHTY_GRP_LANG_VW.SPL_CHART_TYPE_GRP_ID)  UNION ALL 	SELECT '*A' SPL_CHART_TYPE_GRP_ID , 'NO GROUP' SPL_CHART_TYPE_GRP_DESC FROM DUAL WHERE NOT EXISTS (SELECT 1 FROM CA_SPL_CHART_TYPE WHERE SPL_CHART_TYPE = ? AND SPL_CHART_TYPE_GRP_APPL_YN='N' AND EXISTS (SELECT 1 FROM CA_SPL_CHART_GRAPH WHERE SPL_CHART_TYPE=CA_SPL_CHART_TYPE.SPL_CHART_TYPE  AND  SPL_CHART_TYPE_GRP_ID='*A')) ";

					StringBuffer sql = new StringBuffer("select GRAPH_CODE, GRAPH_DESC, X_AXIS_ELEMENT_TYPE, Y_AXIS_ELEMENT_TYPE from CA_SPL_CHART_GRAPH_LANG_VW where EFF_STATUS='E' AND language_id = ? and SPL_CHART_TYPE = ? and SPL_CHART_TYPE_GRP_ID = ? ");

					try
					{
						con = ConnectionManager.getConnection(request);
						psSplGrpId = con.prepareStatement(sqlGrpId);
						psSplGrpId.setString(1,splChartType);
						psSplGrpId.setString(2,locale);
						psSplGrpId.setString(3,splChartType);
						resSplGrpId = psSplGrpId.executeQuery();
						ps = con.prepareStatement(sql.toString());
					    ps.setString(1,locale);
						ps.setString(2,splChartType);


						while(resSplGrpId.next())
						{
							splChartTypeGrpId = resSplGrpId.getString("SPL_CHART_TYPE_GRP_ID");
							splChartTypeGrpDesc = resSplGrpId.getString("SPL_CHART_TYPE_GRP_DESC");
							if(!splChartTypeGrpId.equals("*A"))
							{
								out.println("<tr>");
								out.println("<td class='CAGROUPHEADING' colspan='2'>&nbsp;"+splChartTypeGrpDesc+"</td>");
								out.println("</tr>");						
							}							

							ps.setString(3,splChartTypeGrpId);
							res = ps.executeQuery();
							
							while(res.next())
							{
								graphCode = res.getString("GRAPH_CODE");
								graphDesc = res.getString("GRAPH_DESC");
								xAxisElementType = res.getString("X_AXIS_ELEMENT_TYPE");
								yAxisElementType = res.getString("Y_AXIS_ELEMENT_TYPE");
								
								/*if(i % 2 == 0) classValue = "QRYEVEN";
								else classValue = "QRYODD";*/

                                classValue="gridData";

								out.println("<tr>");
								//out.println("<td class='"+classValue+"' width='10%'>&nbsp;&nbsp;&nbsp;<img src='../../eCA/images/graph.gif' onclick='loadSplGraphs(\""+graphDesc+"\",\""+xAxisElementType+"\",\""+yAxisElementType+"\",\""+splChartType+"\",\""+splChartTypeGrpId+"\")' title='Show Graph'>&nbsp;&nbsp;</td>");
								//out.println("<td class='"+classValue+"'><a class='gridLink' href='javascript:loadSplGraphs(\""+graphDesc+"\", \""+xAxisElementType+"\", \""+yAxisElementType+"\", \""+splChartType+"\", \""+splChartTypeGrpId+"\")' id='anchorTag"+i+"'>"+graphDesc+"</a></td>");
								//out.println("<td class='"+classValue+"' width='10%'>&nbsp;&nbsp;&nbsp;<img src='../../eCA/images/graph.gif' onclick='loadSplGraphs(\""+i+"\")' title='Show Graph'>&nbsp;&nbsp;</td>");
								//out.println("<td class='"+classValue+"'><a class='gridLink' href='javascript:loadSplGraphs(\""+i+"\")' id='anchorTag"+i+"'>"+graphDesc+"</a></td>");
								out.println("<td class='"+classValue+"'><input type='radio' name='splChrt' id='splChrt' value='"+i+"'  onclick='setIndex(this)' >"+graphDesc+"</input></td>");
						%>
								<input type='hidden' name='graphDesc<%=i%>' id='graphDesc<%=i%>' value='<%=graphDesc%>'>
								<input type='hidden' name='xAxisElementType<%=i%>' id='xAxisElementType<%=i%>' value='<%=xAxisElementType%>'>
								<input type='hidden' name='yAxisElementType<%=i%>' id='yAxisElementType<%=i%>' value='<%=yAxisElementType%>'>
								<input type='hidden' name='splChartType<%=i%>' id='splChartType<%=i%>' value='<%=splChartType%>'>
								<input type='hidden' name='splChartTypeGrpId<%=i%>' id='splChartTypeGrpId<%=i%>' value='<%=splChartTypeGrpId%>'>
						<%
								out.println("</tr>");
								i++;
							}
							if(res != null) res.close();
						}

						//if(res != null) res.close();
						if(resSplGrpId != null) resSplGrpId.close();
						if(ps != null) ps.close();
						if(psSplGrpId != null) psSplGrpId.close();
					}
					catch(Exception e)
					{
						//out.println(e.toString());//COMMON-ICN-0181
						
						e.printStackTrace();
					}
					finally
					{
						if(con!=null)
							ConnectionManager.returnConnection(con,request);
					}
				%>
				<tr>
					<td class='CAGROUPHEADING' align='left'>
						<input type='button' name='graph' id='graph' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>' onclick ='loadSplGraphs()'>
					</td>
				</tr>
				</table>
				<input type='hidden' name='encounterId' id='encounterId' value='<%=encounterId%>'>
				<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
				<input type='hidden' name='patient_id' id='patient_id' value='<%=patientID%>'>
				<input type='hidden' name='chart_id' id='chart_id' value='<%=chartID%>'>
				<input type='hidden' name='Sex' id='Sex' value='<%=Sex%>'>
				<input type='hidden' name='splChartType' id='splChartType' value='<%=splChartType%>'>
				<input type='hidden' name='index' id='index' value=''>
			</form>				
		</body>
		<%
			String numOfchkedBoxes = request.getParameter("numOfchkedBoxes") == null ? "0" : request.getParameter("numOfchkedBoxes");
		%>
		<script>
			if('<%=numOfchkedBoxes%>' == '0' || '<%=numOfchkedBoxes%>' == '')
			{
				if('<%=splChartType%>' == 'GR')
				{					
					document.splChartLinksForm.index.value = '0';	
					if(document.splChartLinksForm.splChrt !="undefined" && document.splChartLinksForm.splChrt !=undefined){						
						if(document.splChartLinksForm.splChrt.value==undefined || document.splChartLinksForm.splChrt.value=="undefined"){
						document.splChartLinksForm.splChrt[0].checked=true;
						loadSplGraphs();
						}
						else{
							document.splChartLinksForm.splChrt.checked=true;
							loadSplGraphs();
						}
					}					
				}
				//if(document.getElementById("anchorTag0") != null)
					//document.getElementById("anchorTag0").click();
			}
			else
			{
				if('<%=splChartType%>' == 'GR')
				{	
					document.splChartLinksForm.index.value = '0';
					if(document.splChartLinksForm.splChrt != "undefined" && document.splChartLinksForm.splChrt != undefined){						
						if(document.splChartLinksForm.splChrt.value == undefined || document.splChartLinksForm.splChrt.value == "undefined"){
							document.splChartLinksForm.splChrt[0].checked = true;
						}
						else
						{
							document.splChartLinksForm.splChrt.checked = true;
						}
					}					
					
					//document.splChartLinksForm.splChrt[0].checked = true;
				}
				
			}
		</script>
</html>

