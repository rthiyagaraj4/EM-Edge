<!DOCTYPE html>
<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	//java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
	//String locale = (String) p.getProperty("LOCALE");
%>
<html>
	<head>
		<script language="javascript" src="../../eCA/js/ChartRecording.js"></script>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>	
	<body onKeyDown="lockKey()">
		<form name='splChtPatDtlRecForm' id='splChtPatDtlRecForm' action='../../servlet/eCA.ChartRecordingSplChtPatRecDtlServlet' method='post'>
			<table border='1' cellspacing='0' cellpadding='0' width='100%' id='tdHeadingTab'>
	<%
		Connection con = null;
		PreparedStatement psDisc = null;
		ResultSet resDisc = null;
		PreparedStatement ps = null;
		ResultSet res = null;

		String keyVal = "";
		String keyDesc = "";
		String keyUnit = "";
		String prevKeyVal = "";
		String transVal = "";
		String classValue = "";
		String discrMsr = "";
		String elementType = "";
		String elementUOM= "";

		StringBuffer strConcatVals = new StringBuffer();
		String chartId = request.getParameter("chart_id") == null ? "" : request.getParameter("chart_id");
		String patientId = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String splChartType = request.getParameter("splChtType") == null ? "" : request.getParameter("splChtType");
		String splChartGrpId = request.getParameter("splChtGrpId") == null ? "" : request.getParameter("splChtGrpId");

		String age = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.age.label","common_labels");

		int minNums = 0;
		int maxNums = 0;
		int decNums = 0;
		int maxLength = 20;
		int i = 0;
		int j = 0;
		int z = 0;

		ArrayList discrList = new ArrayList();
		ArrayList keyValList = new ArrayList();
		ArrayList keyDescList = new ArrayList();
		ArrayList discrDtlList = new ArrayList();
		HashMap keyValsMap = new HashMap();
		StringTokenizer valsTokenizer = null;

		String sqlVals = "SELECT  A.KEY_VALUE key_val,START_VALUE||'-'||END_VALUE key_desc, Decode(A.VALUE_UNIT,'M','Months','D','Days','W','Weeks','Y','Years') unit_val, B.ELEMENT_TYPE element_type, B.TRNS_VALUE trns_val FROM    CA_SPL_CHART_KEY_VALUE A, CA_SPL_CHART_PAT_REC_DTL B WHERE  A.X_ELEMENT_TYPE='*K' AND A.SPL_CHART_TYPE =?   AND   A.SPL_CHART_TYPE_GRP_ID =?  AND   B.PATIENT_ID(+)=?  AND   B.CHART_ID(+) =?   AND   B.KEY_VALUE(+)=A.KEY_VALUE AND B.SPL_CHART_TYPE_GRP_ID(+)=A.SPL_CHART_TYPE_GRP_ID ORDER BY A.START_VALUE , B.ELEMENT_TYPE ";

		String sqlDiscrNames = "select a.element_type ele_type, c.element_uom ele_uom ,a.discr_msr_id, b.SHORT_DESC discr_desc, b.num_digits_max max_nums, b.num_digits_min min_nums, b.num_digits_dec dec_nums from ca_chart_section_comp a, am_discr_msr b, CA_SPL_CHART_ELEMENT_TYPE c where a.chart_id = ? and a.element_type is not null and a.discr_msr_id = b.discr_msr_id and b.RESULT_TYPE in ('I','N','A') and a.element_type= c. element_type order by a.ELEMENT_TYPE";

		try
		{
			con = ConnectionManager.getConnection(request);

			psDisc = con.prepareStatement(sqlDiscrNames);
			psDisc.setString(1,chartId);
			resDisc = psDisc.executeQuery();

			ps = con.prepareStatement(sqlVals);
			ps.setString(1,splChartType);
			ps.setString(2,splChartGrpId);
			ps.setString(3,patientId);
			ps.setString(4,chartId);

			out.println("<tr>");
			out.println("<th align='left' id='ageTD'>");
			out.println(age);
			out.println("</th>");			

			while(resDisc.next())
			{
				discrMsr = resDisc.getString("discr_desc") == null ? "" : resDisc.getString("discr_desc");
				elementType = resDisc.getString("ele_type") == null ? "" : resDisc.getString("ele_type");
				elementUOM = resDisc.getString("ele_uom") == null ? "" : resDisc.getString("ele_uom");
				if("KM".equals(elementUOM))
					elementUOM="Kg\\m2";
				minNums = resDisc.getInt("min_nums");
				maxNums = resDisc.getInt("max_nums") == 0 ? 10 : resDisc.getInt("max_nums");
				decNums = resDisc.getInt("dec_nums") == 0 ? 10 : resDisc.getInt("dec_nums");

				if(maxNums == 10) maxLength = 21;
				else maxLength = maxNums;

				out.println("<th >"+discrMsr+" ("+elementUOM+")");
				out.println("</th>");
				discrList.add(elementType);
				discrDtlList.add(minNums+"`"+maxNums+"`"+decNums);
			}
			out.println("</tr>");
			out.println("</table>");
			out.println("<table class='grid' width='100%' id='valuesTab'>");

			if(resDisc != null) resDisc.close();
			if(psDisc != null) psDisc.close();

			res = ps.executeQuery();

			while(res.next())
			{
				keyVal = res.getString("key_val") == null ? "" : res.getString("key_val");
				keyDesc = res.getString("key_desc") == null ? "" : res.getString("key_desc");
				keyUnit = res.getString("unit_val") == null ? "" : res.getString("unit_val");
				elementType = res.getString("element_type") == null ? " " : res.getString("element_type");
				transVal = res.getString("trns_val") == null ? " " : res.getString("trns_val");
				
				if(!prevKeyVal.equals(keyVal))
				{
					keyValList.add(keyVal);
					keyDescList.add(keyDesc);
				}

				if(prevKeyVal.equals(keyVal) || prevKeyVal.equals(""))
				{
					strConcatVals.append(elementType+"~"+transVal);
					strConcatVals.append("`");
				}
				else
				{
					keyValsMap.put(prevKeyVal,strConcatVals.toString());
					strConcatVals.setLength(0);
					strConcatVals.append(elementType+"~"+transVal);
					strConcatVals.append("`");
				}
				keyValsMap.put(keyVal,strConcatVals.toString());
				prevKeyVal = keyVal;
			}

			if(res != null) res.close();
			if(ps != null) ps.close();

			String mapValues = "";
			String tokenRows = "";
			String tknElementType = "";
			String tknElementValue = "";
			String tempMapValues = "";
			String tempDetailValues = "";
			StringTokenizer strTokenValues = null;
			StringTokenizer discrDtlValues = null;
			StringBuffer tdValues = new StringBuffer();

			String tempIndexVal = "";

			for(i=0;i<keyValList.size();i++)
			{
				if(i % 2 == 0) classValue = "gridData";
				else classValue = "gridData";
				tempMapValues = "";
				mapValues = (String)keyValsMap.get((String)keyValList.get(i));
				tdValues.append("<tr>");
				tdValues.append("<td class='"+classValue+"'>"+(String)keyDescList.get(i)+"</td>");
				out.println("<input type='hidden' name='keyValue"+i+"' id='keyValue"+i+"' value='"+(String)keyValList.get(i)+"'>");
				if(mapValues != null)
				{
					for(j=0;j<discrList.size();j++)
					{
						tempIndexVal = (String)discrList.get(j);
				
						if(tempMapValues.equals(""))
							tempMapValues = mapValues;
						else
							tempMapValues = tempMapValues;

						valsTokenizer = new StringTokenizer(tempMapValues,"`");
						tokenRows = (String)valsTokenizer.nextToken();						

						if(mapValues.indexOf(tempIndexVal) == -1)
						{
							tempDetailValues = (String)discrDtlList.get(j);

							discrDtlValues = new StringTokenizer(tempDetailValues,"`");
							minNums = Integer.parseInt((String)discrDtlValues.nextToken());
							maxNums = Integer.parseInt((String)discrDtlValues.nextToken());
							decNums = Integer.parseInt((String)discrDtlValues.nextToken());

							tdValues.append("<td class='"+classValue+"'><input type='text' name='txt"+i+"Vals"+j+"' id='txt"+i+"Vals"+j+"' size='"+maxNums+"' maxlength = '"+maxLength+"' onkeypress=\"return allowValidNumberLocal2(this, event, '"+maxLength+"','"+decNums+"')\" onblur=\"validateNums(this,'"+minNums+"','"+maxNums+"','"+decNums+"')\"></td>");
							out.println("<input type='hidden' name='element"+i+"Type"+j+"' id='element"+i+"Type"+j+"' value='"+tempIndexVal+"'>");
							z++;
						}
						else
						{
							strTokenValues = new StringTokenizer(tokenRows,"~");
							tknElementType = (String) strTokenValues.nextToken();
							tknElementValue = (String)strTokenValues.nextToken();
							tdValues.append("<td class='"+classValue+"'>"+tknElementValue+"</td>");
							tempMapValues = tempMapValues.substring(tempMapValues.indexOf("`")+1);
						}
					}
				}
				tdValues.append("</tr>");
			}
			out.println(tdValues.toString());
		}//end of try
		catch(Exception e)
		{
			
		//	out.println("Exception@@@@@@ in try of ChartRecordingSplChtDtlEntry.jsp--"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}
		finally
		{
			if(con!=null) ConnectionManager.returnConnection(con,request);
		}
	%>
			</table>
			<input type='hidden' value='<%=discrList.size()%>' name='numOfDiscrMsrs'>
			<input type='hidden' value='<%=chartId%>' name='chartId'>
			<input type='hidden' value='<%=patientId%>' name='patientId'>
			<input type='hidden' value='<%=splChartType%>' name='splChartType'>
			<input type='hidden' value='<%=splChartGrpId%>' name='splChartGrpId'>
			<input type='hidden' name='numOfRows' id='numOfRows' value='<%=i%>'>
			<input type='hidden' name='numOfCols' id='numOfCols' value='<%=j%>'>
			<input type='hidden' name='numOfTextBoxes' id='numOfTextBoxes' value='<%=z%>'>
			<input type='hidden' name='numOfRecords' id='numOfRecords' value=''>
			<input type='hidden' name='age' id='age' value='<%=age%>'>
		</form>
	</body>
	<script>
		document.getElementById("ageTD").innerText = document.getElementById("age").value+" (<%=keyUnit%>)";
		alignKeyValHdg();
	</script>
</html>

