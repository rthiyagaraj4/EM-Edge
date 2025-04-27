<!DOCTYPE html>



<%@ page import ="java.sql.*,java.net.*,java.text.*,java.util.*, webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<title><fmt:message key="eCA.SpecialChartLinks.label" bundle="${ca_labels}"/></title>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
			String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

			java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
			String locale = (String) p.getProperty("LOCALE");
			
			String splChartType		= request.getParameter("splChartType") == null ? "" : request.getParameter("splChartType");
			String patientID		= request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
			String facility_id		= request.getParameter("facility_id") == null ? "" : request.getParameter("facility_id");
			String encounterId		= request.getParameter("encounterId") == null ? "" : request.getParameter("encounterId");
			String chartID			= request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
			String Sex				= request.getParameter("Sex") == null ? "" : request.getParameter("Sex");
			String Xaxis			= request.getParameter("Xaxis") == null ? "" : request.getParameter("Xaxis");
			String sqlGrpId			= "select SPL_CHART_TYPE_GRP_ID, SPL_CHART_TYPE_GRP_DESC from CA_SPL_CHTY_GRP_LANG_VW where SPL_CHART_TYPE = ? AND LANGUAGE_ID = ? ";

			String grpId = "";
			String grpDesc = "";
			String chkRadBtn = "";
			String classValue = "";
			String xAxisElementType = "";
			String xAxisElementTypeDesc = "";
			String yAxisElementType = "";
			String yAxisElementTypeDesc = "";
			String sel = "";
			String xAxisElementValue ="*K";
			String splChartGrpId ="";
			int count = 0;

			Connection con = null;
			PreparedStatement ps = null;
			ResultSet res = null;
			
			String elementsSql = "select a.ELEMENT_TYPE ele_type,  b.ELEMENT_TYPE_DESC ele_type_desc from ca_chart_section_comp a, CA_SPL_CHART_ELTY_LANG_VW b where  a.chart_id = ? and b.ELEMENT_TYPE = a.ELEMENT_TYPE and b.language_id = ?";
			
		%>
		
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body style='background-color:#E2E3F0;' onKeyDown="lockKey()">
		<form name='splChartUserInputForm' id='splChartUserInputForm'>
			<table class='grid' width='100%'>
				<tr>
					<td class='CACHARTFOURTHLEVELCOLOR' align='left'><fmt:message key="eCA.CustomView.label" bundle="${ca_labels}"/> 
					</td>
				</tr>
				<%
					try
					{
						con = ConnectionManager.getConnection(request);
						try
						{
							ps = con.prepareStatement(sqlGrpId);
							ps.setString(1,splChartType);
							ps.setString(2,locale);

							res = ps.executeQuery();

							while(res.next())
							{
								

								/*if(count %2 == 0) classValue = "QRYEVEN";
								else classValue = "QRYODD";*/

								 classValue="gridData";

								grpId = res.getString("SPL_CHART_TYPE_GRP_ID");
								grpDesc = res.getString("SPL_CHART_TYPE_GRP_DESC");
								if(count == 0) {
									chkRadBtn = "checked";
									splChartGrpId=grpId;
								}else chkRadBtn = "";
								out.println("<tr><td class='"+classValue+"'>");
								out.println("<input type='radio' "+chkRadBtn+" name='splChrtGrp' id='splChrtGrp' value='"+grpId+"' > <b>"+grpDesc+"</b></input>");
								out.println("</td></tr>");
								count++;
							}
							
							if(res != null) res.close();
							if(ps != null) ps.close();
						}
						catch(Exception ee)
						{
							
							ee.printStackTrace();
						}
				%>
					
				<tr>
					<td class='gridData' align='center' >X <fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/> : 
					<select name='xaxisValue' id='xaxisValue' onchange='validateElementType(this,document.forms[0].xaxisValue1);'>						
				<%
					if(Xaxis.equals("*K"))
						sel = "selected";
					else
						sel = "";
				%>
						<option value='*K' <%=sel%>><fmt:message key="Common.age.label" bundle="${common_labels}"/></option>
				<%
						try
						{
							ps = con.prepareStatement(elementsSql);
							ps.setString(1,chartID);
							ps.setString(2,locale);
							res = ps.executeQuery();							
							while(res.next())
							{
								xAxisElementType = res.getString("ele_type") == null ? "" : res.getString("ele_type");
								xAxisElementTypeDesc = res.getString("ele_type_desc") == null ? "" : res.getString("ele_type_desc");								
								if(xAxisElementType.equals(Xaxis)){
									sel = "selected";
									xAxisElementValue = xAxisElementType;
								}else{
									sel = "";
								}
								out.println("<option value='"+xAxisElementType+"' "+sel+">"+xAxisElementTypeDesc+"</option>");
							}
							if(res != null) res.close();
							if(ps != null) ps.close();
						}
						catch(Exception e)
						{
							//out.println("Exception in try of ChartRecordingSplChtUserInput.jsp --"+e.toString());//COMMON-ICN-0181
							e.printStackTrace();
						}
				%>
					</select>
					<input type='hidden' name='xaxisValue1' id='xaxisValue1' value='<%=xAxisElementValue%>' />
					</td>
				</tr>
				<tr>
					<td class='gridData' align='center' >Y <fmt:message key="eCA.Axis.label" bundle="${ca_labels}"/> : 
					<select name='yaxisValue' id='yaxisValue' onchange='validateElementType(this,document.forms[0].yaxisValue1);'>
						<option value='*'>-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<%
					try
					{
						ps = con.prepareStatement(elementsSql);
						ps.setString(1,chartID);
						ps.setString(2,locale);
						res = ps.executeQuery();

						while(res.next())
						{
							yAxisElementType = res.getString("ele_type") == null ? "" : res.getString("ele_type");
							yAxisElementTypeDesc = res.getString("ele_type_desc") == null ? "" : res.getString("ele_type_desc");
							if(!yAxisElementType.equals(Xaxis))
								out.println("<option value='"+yAxisElementType+"'>"+yAxisElementTypeDesc+"</option>");
						}

						if(res != null) res.close();
						if(ps != null) ps.close();
					}
					catch(Exception e)
					{
						//out.println("Exception in try of ChartRecordingSplChtUserInput.jsp --"+e.toString());//COMMON-ICN-0181
						e.printStackTrace();
					}
				}
				catch(Exception mainExp)
				{

					//out.println("Exception in main try of ChartRecordingSplChtUserInput.jsp--"+mainExp.toString()+"--");//COMMON-ICN-0181
					mainExp.printStackTrace();
				}
				finally
				{
					if(con!=null)
						ConnectionManager.returnConnection(con,request);
				}

	%>			
				</select>
				<input type='hidden' name='yaxisValue1' id='yaxisValue1' value='*' />
				</td>
				</tr>
				<tr>
					<td class='CAGROUPHEADING' align='left'>
						<input type='button' name='graph' id='graph' onclick='loadGraph()' title='Show Graph'  value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.Viewgraph.label","ca_labels")%>'>
					</td>
				</tr>
			</table>
			<input type='hidden' name='splChartType' id='splChartType' value='<%=splChartType%>'>
			<input type='hidden' name='patient_id' id='patient_id' value='<%=patientID%>'>
			<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
			<input type='hidden' name='encounterId' id='encounterId' value='<%=encounterId%>'>
			<input type='hidden' name='chart_id' id='chart_id' value='<%=chartID%>'>
			
			<input type='hidden' name='Sex' id='Sex' value='<%=Sex%>'>
		</form>
	</body>
</html>

