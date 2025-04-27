<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager,eCA.ChartComponentFormulaBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title>Bean JSP</title>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<BODY CLASS="MESSAGE" onKeyDown="lockKey()">
	<form name='tempformformula' id='tempformformula'>

	<p align="left">
	<%
		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	
		HashMap tabFormula = null;
		HashMap tabSummary = null;

		String sqlFormulaParser = "select distinct CA_GET_FORMULA_STRING(?) formula from CA_CHART_SECTION_COMP"; 

		String formulaString = "";

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet res = null;

		ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
		eCA.ChartComponentResultsetBean recordsBean = (eCA.ChartComponentResultsetBean)session.getAttribute("recordsBean");
		
		String calledFrom=request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
		try
		{
			con = ConnectionManager.getConnection(request);
	
			if(!calledFrom.equals("addRow")&&!calledFrom.equals("Summary") && !calledFrom.equals("SummaryFromSecond") && !calledFrom.equals("default"))
			{
				String panel_desc_id_Content = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
				String detail=request.getParameter("formulaDefinition")==null?"":request.getParameter("formulaDefinition");

				try
				{
					pstmt = con.prepareStatement(sqlFormulaParser);
					pstmt.setString(1,detail);

					res = pstmt.executeQuery();

					while(res.next())
					{
						formulaString = res.getString("formula") == null ? "" : res.getString("formula");
					}

					if(res != null) res.close();
					if(pstmt != null) pstmt.close();
				}
				catch(Exception e)
				{
					
					e.printStackTrace();
				}

			eCA.ExpressionParser parser = new eCA.ExpressionParser();

			if(!formulaString.equals(""))
			{
				if(parser.checkForValidity(formulaString.replace('~',' ')))
				{
					if(calledFrom.equals("OK"))
					{
						%>
							<script>
								 alert(getMessage("EXP_VALID","CA"));	
								 window.returnValue="<%=detail%>";										
							</script>
						<%
						
						if(formulaBean != null)
						{
							tabFormula = formulaBean.returnFormulaTab();
							if(tabFormula != null)
							{
								if(tabFormula.containsKey(panel_desc_id_Content)== true)
									tabFormula.remove(panel_desc_id_Content);
								tabFormula.put(panel_desc_id_Content,detail);
							}
						}
						%>
						<script>
							window.close();
						</script>

						<%
					}
					else if(calledFrom.equals("VALIDATE"))
					{
						%>
						<script>
							alert(getMessage("EXP_VALID","CA"));		
								
						</script>
						<%
					}
				}
				else
				{
					%>
						<script>
						alert(getMessage("EXP_INVALID","CA"));			
						</script>
					<%
				}
			}
			else
			{
				if(formulaBean != null)
				{
					tabFormula = formulaBean.returnFormulaTab();

					if(tabFormula != null)
					{
						if(tabFormula.containsKey(panel_desc_id_Content)== true)
							tabFormula.remove(panel_desc_id_Content);
					
						tabFormula.put(panel_desc_id_Content,detail);
					}
				}
			}
		
			parser = null;
			%>
			</p>
			<%
		}
		
		if(calledFrom.equals("Summary"))
		{
			String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
			String SummaryType = request.getParameter("SummaryType")==null?"":request.getParameter("SummaryType");
			String elementType = request.getParameter("element_type")==null?"":request.getParameter("element_type");

			String summaryColumn =  request.getParameter("SummaryColumn")==null?"":request.getParameter("SummaryColumn");
			String mandatory_yn=  request.getParameter("mandatory_yn")==null?"":request.getParameter("mandatory_yn");
			String default_yn=  request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
			String change_at_trans = request.getParameter("change_at_trans")==null?"":request.getParameter("change_at_trans");
			String sum_yn=  request.getParameter("sum_yn")==null?"":request.getParameter("sum_yn");
			String finalSummary = summaryColumn + ":" + SummaryType +":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans+":" +  elementType;	

			if(formulaBean != null)
			{
				tabSummary = formulaBean.getSummary();

				if(tabSummary != null)
				{
					if(tabSummary.containsKey(panel_desc_id)== true)
						tabSummary.remove(panel_desc_id);

					tabSummary.put(panel_desc_id,finalSummary);
				}
			}
		}

		if(calledFrom.equals("addRow"))
		{
			StringBuffer finalString  = new StringBuffer();
			String chart_id = request.getParameter("chart_id")==null?"":request.getParameter("chart_id");
			String summ_req_yn = "";
			String change_at_trans = "";
			PreparedStatement psSumDef = null;
			ResultSet resSumDef = null;

			try
			{
				String sqlSumDef = "select summary_req_yn, CONFIG_TYPE from ca_chart where chart_id = ?";
				psSumDef = con.prepareStatement(sqlSumDef);
				psSumDef.setString(1,chart_id);
				resSumDef = psSumDef.executeQuery();
				while(resSumDef.next())
				{
					summ_req_yn = resSumDef.getString(1);
					change_at_trans = resSumDef.getString(2);
				}
	
				if (resSumDef != null) resSumDef.close();
				if (psSumDef != null) psSumDef.close();
			}
			catch(Exception e)
			{
					//out.println("Exception in try-1 of ChartComponentBeanIntermediate.jsp"+e.toString());//COMMON-ICN-0181
                                          e.printStackTrace();//COMMON-ICN-0181
			}
			%>

			<script>
					parent.chartComponentListFrame.document.ChartComponentListForm.sum_req.value = '<%=summ_req_yn%>';
					parent.chartComponentListFrame.document.ChartComponentListForm.change_trans.value = '<%=change_at_trans%>';
			</script>
			<%

			String retVal = request.getParameter("retVal")==null?"":request.getParameter("retVal");
			String retValFlag =""; 
			String tempString = "";

			if(!retVal.equals(""))
			{
				retValFlag=formulaBean.getretValString()==null ? "" :formulaBean.getretValString() ;
			
				if(retValFlag.equals(""))
					finalString.append(retVal);
				else
				{
					tempString  = retValFlag + "~"  + retVal;
					finalString.append(tempString);
				}

				formulaBean.setretValString(finalString.toString());
			}			
		}		

		if(calledFrom.equals("SummaryFromSecond"))
		{
			String elementType = request.getParameter("element_type")==null?"":request.getParameter("element_type");
			String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
			String SummaryType = request.getParameter("SummaryType")==null?"":request.getParameter("SummaryType");
			String summaryColumn =  request.getParameter("SummaryColumn")==null?"":request.getParameter("SummaryColumn");
			String mandatory_yn=  request.getParameter("mandatory_yn")==null?"":request.getParameter("mandatory_yn");
			String default_yn=  request.getParameter("default_yn")==null?"":request.getParameter("default_yn");
			String change_at_trans = request.getParameter("change_at_trans")==null?"":request.getParameter("change_at_trans");
			String sum_yn =  request.getParameter("sum_yn")==null?"N":request.getParameter("sum_yn");
			String finalSummary = summaryColumn + ":" + SummaryType +":" + default_yn + ":" + sum_yn + ":" + mandatory_yn + ":" + change_at_trans+":" +  elementType;
			String recordValues = request.getParameter("recordValues")==null?"":request.getParameter("recordValues");

			if(formulaBean != null)
			{
				tabSummary = formulaBean.getSummary();
		
				if(tabSummary != null)
				{
					if(tabSummary.containsKey(panel_desc_id)== true)
						tabSummary.remove(panel_desc_id);

					tabSummary.put(panel_desc_id,finalSummary);					
					formulaBean.setSummary(tabSummary);
				}
			}		

			if(recordsBean != null)
			{
				HashMap tabRecords = recordsBean.getRecords();
		
				if(tabRecords != null)
				{
					if(tabRecords.containsKey(panel_desc_id)== true)
						tabRecords.remove(panel_desc_id);
					tabRecords.put(panel_desc_id,recordValues);
					recordsBean.addRecords(tabRecords);
				}
			}	
		}		

		if(calledFrom.equals("default"))
		{
			String panel_desc_id = request.getParameter("panel_desc_id")==null?"":request.getParameter("panel_desc_id");
			StringTokenizer tokenPipe = null;
			StringTokenizer tokenTilde=null;
			String finalSummary = "";
			String discr_msr_id = "";
			String finalConcatenatedString = request.getParameter("finalString")==null?"":request.getParameter("finalString");
			
			if(!panel_desc_id.equals("") && ! finalConcatenatedString.equals(""))
			{
				tokenPipe = new 	StringTokenizer(panel_desc_id ,"||");
				tokenTilde = new 	StringTokenizer(finalConcatenatedString ,"~");
			
				while(tokenPipe.hasMoreTokens() && tokenTilde.hasMoreTokens())
				{
					discr_msr_id = tokenPipe.nextToken().trim();
					finalSummary = tokenTilde.nextToken().trim();
				
					if(formulaBean != null)
					{
						tabSummary = formulaBean.getSummary();
						
						if(tabSummary != null)
						{
							if(tabSummary.containsKey(discr_msr_id)== true)
								tabSummary.remove(discr_msr_id);

							tabSummary.put(discr_msr_id,finalSummary);
						}
					}	
				 }
			}
		}
	}
	catch(Exception excep)
	{
		
		excep.printStackTrace();
	}
	finally
	{
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
%>
</body>
</html>

