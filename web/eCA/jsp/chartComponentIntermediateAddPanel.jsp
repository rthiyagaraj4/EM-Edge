<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager,eCA.ChartComponentFormulaBean,eCA.ChartComponentResultsetBean,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCA.ChartComponentAddPanel.label" bundle="${ca_labels}"/></title>
<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../../eCA/js/ChartComponent.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<%
			String chart_id = request.getParameter("chart_id") == null?"":request.getParameter("chart_id");		
			String panel_id = request.getParameter("panel_id") == null?"":request.getParameter("panel_id");
			String display_order_seq = request.getParameter("display_order_seq") == null?"":request.getParameter("display_order_seq");
			//String seqGrpVal = request.getParameter("seqGrpVal") == null?"":request.getParameter("seqGrpVal");
			StringBuffer  finalString = new StringBuffer();
			String order_serial_no = "";
			String discr_msr_desc = "";
			String discr_msr_id = "";
			String result_type = "";
			String summary_yn = "";
			String summary_column = "";
			String summary_type = "";
			String default_yn = "";			
			String sqlAddDiscrMsr = "";
			String associate_score_yn = "";
			//String disc_disp_order_seq = "";
			String sqlChartComp = "";
			String formulaDefn = "";
			//String formulaDefnForDisp = "";
			String sqlSumm = "";
			//String sum_col = "";
			//String tempSum = "";
			//String tempAvg = "";
			//String tempMin = "";
			//String tempMax = "";
			//String	 tempPct = "";
			//String disabled ="";
			//String readOnly = "";
			//String disChkSumm = "";
			//String checked = "";
			//String checkedSumm = "";
			//String style = "";
			//String finalSummaryValue = "";
			StringBuffer finalSummaryValue = new StringBuffer();
			String panel_desc_id = "";
			String recordValues = "";
			String mandatory_yn = "";

			String summary_req_yn = "";
			String change_at_trans = "";
			String sqlTrans = "";
			String element_type = "##";
			
			HashMap tabFormula = null;
			HashMap tableForRecs = null;
			HashMap tabSummary = null;

			int counter = 0;
			int i = 0;

			Connection con = null;
			PreparedStatement psAddDiscrMsr = null;
			PreparedStatement psChartComp = null;
			PreparedStatement psSumm = null;
			ResultSet rsAddDiscrMsr = null;
			ResultSet rsChartComp = null;
			ResultSet rsSumm = null;
			PreparedStatement psTrans = null;
			ResultSet resTrans = null;

			try{

				tabFormula = new HashMap();
				tableForRecs= new HashMap();
				tabSummary = new HashMap(); 

				con = ConnectionManager.getConnection(request);

				ChartComponentFormulaBean formulaBean  = (ChartComponentFormulaBean)session.getAttribute("formulaBean");
				ChartComponentResultsetBean recordsBean  = (ChartComponentResultsetBean)session.getAttribute("recordsBean");

				tableForRecs = recordsBean.getRecords();
				tabSummary = formulaBean.getSummary();
			
				sqlChartComp = "select FORMULA_DEF,SUMMARY_TYPE,SUMMRY_COLUMN,DEFAULT_DISPLAY_YN,SUM_YN,MANDATORY_YN,ELEMENT_TYPE from ca_chart_section_comp where chart_id = ? and panel_id = ?  and discr_msr_id = ?";
				psChartComp =con.prepareStatement(sqlChartComp);

				sqlTrans = " select summary_req_yn, config_type from ca_chart where chart_id = ?"; 
				psTrans = con.prepareStatement(sqlTrans);
				psTrans.setString(1,chart_id);
				resTrans = psTrans.executeQuery();
				while(resTrans.next()){
					summary_req_yn = resTrans.getString(1);
					change_at_trans = resTrans.getString(2) == null ? "N" : resTrans.getString(2);					
				}
				if(resTrans!=null) resTrans.close();
				

				sqlAddDiscrMsr = "select A.DISCR_MSR_ID, DISCR_MSR.SHORT_DESC DISCR_MSR_DESC, DISCR_MSR.RESULT_TYPE, A.ORDER_SRL_NO,DISCR_MSR.ASSOCIATE_SCORE_YN from AM_DISCR_MSR_BATTERY A, AM_DISCR_MSR SECTION,AM_DISCR_MSR DISCR_MSR WHERE A.DISCR_MSR_BATTERY_ID = ? AND   SECTION.DISCR_MSR_ID = A.DISCR_MSR_BATTERY_ID and DISCR_MSR.DISCR_MSR_ID=  A.DISCR_MSR_ID AND DISCR_MSR.CH_APPL_YN='Y' ORDER BY A.ORDER_SRL_NO ";
				
				psAddDiscrMsr = con.prepareStatement(sqlAddDiscrMsr);
				//psAddDiscrMsr.setString(1,chart_id);
				psAddDiscrMsr.setString(1,panel_id);
				
				rsAddDiscrMsr = psAddDiscrMsr.executeQuery();
				
				while(rsAddDiscrMsr.next()){					
					i++;
					
					order_serial_no = rsAddDiscrMsr.getString("ORDER_SRL_NO") == null?"":rsAddDiscrMsr.getString("ORDER_SRL_NO");


					discr_msr_desc = rsAddDiscrMsr.getString("DISCR_MSR_DESC") == null?"":rsAddDiscrMsr.getString("DISCR_MSR_DESC");
					discr_msr_id = rsAddDiscrMsr.getString(1) == null?"":rsAddDiscrMsr.getString(1);
					result_type = rsAddDiscrMsr.getString(3) == null?"":rsAddDiscrMsr.getString(3);
					associate_score_yn = rsAddDiscrMsr.getString("ASSOCIATE_SCORE_YN") == null?"N":rsAddDiscrMsr.getString("ASSOCIATE_SCORE_YN");

					//disc_disp_order_seq = rsAddDiscrMsr.getString("DISPLAY_ORDER_SEQ") == null?"":rsAddDiscrMsr.getString("DISPLAY_ORDER_SEQ") ;
				
					panel_desc_id = chart_id + ":" + panel_id + ":" + discr_msr_id;
					recordValues = result_type+"$"+order_serial_no+"$"+display_order_seq;

					tableForRecs.put(panel_desc_id,recordValues);
					//recordsBean.addRecords(tableForRecs);

					sqlSumm = "select short_desc from am_discr_msr where discr_msr_id = ?";
					psSumm = con.prepareStatement(sqlSumm);

					psChartComp.setString(1,chart_id);
					psChartComp.setString(2,panel_id);
					psChartComp.setString(3,discr_msr_id);
					rsChartComp = psChartComp.executeQuery();


					while(rsChartComp.next()){
						counter++;
										
						summary_type = rsChartComp.getString(2) ==null?"":rsChartComp.getString(2);
						summary_column = rsChartComp.getString(3) ==null?"":rsChartComp.getString(3);
						default_yn = rsChartComp.getString(4) ==null? "N":rsChartComp.getString(4);
						summary_yn = rsChartComp.getString(5) == null? "N":rsChartComp.getString(5) ;
						mandatory_yn = rsChartComp.getString(6) == null? "N":rsChartComp.getString(6) ;
						element_type = rsChartComp.getString(7) == null? "##":rsChartComp.getString(7) ;


						if(summary_column.equals(""))
							summary_column = "X";
						if(summary_type.equals(""))
							summary_type = "X";	
						finalSummaryValue.append(summary_column + ":" +summary_type + ":" + default_yn + ":" + summary_yn + ":" + mandatory_yn + ":" + change_at_trans+ ":" + element_type);
						tabSummary.put(panel_desc_id,finalSummaryValue.toString());
						//formulaBean.setSummary(tabSummary);

						if(!summary_column.equals("X")){
							psSumm.setString(1,summary_column);
							rsSumm = psSumm.executeQuery();
							//style = " disabled ";
							//readOnly=" readOnly ";
							while(rsSumm.next()){
								//sum_col = rsSumm.getString(1) == null?"":rsSumm.getString(1);
							}

                          if(rsSumm!=null) rsSumm.close(); 
                          if(psSumm!=null) psSumm.close();

						}
						else{
							//sum_col = "";
							//style = " disabled ";
							//readOnly= " readOnly ";
						}


					}
					if(counter==0){
						summary_column = "X";
						summary_type = "X";	
						default_yn = "Y";
						summary_yn = "N";
						mandatory_yn = "N";
						element_type = "##";

						//finalSummaryValue = summary_column + ":" +summary_type + ":" + default_yn + ":" + summary_yn + ":" + mandatory_yn + ":" + change_at_trans;
						finalSummaryValue = new StringBuffer();
						finalSummaryValue.append(summary_column + ":" + summary_type + ":" + default_yn + ":" + summary_yn + ":" + mandatory_yn + ":" + change_at_trans+ ":" + element_type);

						tabSummary.put(panel_desc_id,finalSummaryValue.toString());
						//formulaBean.setSummary(tabSummary);
					}

				/*	if(default_yn.equals("Y")) 
						//checked="checked";
					else 
						//checked="";
				*/

					if(summary_yn.equals("Y")){
						//checkedSumm=" checked ";
						//disChkSumm = " disabled ";
						//readOnly= " readOnly ";
						//style = " disabled ";
					}
					else{
						//checkedSumm="";
						//disChkSumm = "";
						//readOnly= " readOnly ";
						//style = " disabled ";
					}					

					if(summary_column.equals("X"))
						summary_column= "";
					if(summary_type.trim().equals("SUM"))
					{
						//tempSum="selected";
						//disabled ="disabled";
						// tempAvg = "";
						// tempMin = "";
						 //tempMax = "";
						 //tempPct = "";
					}
					else if(summary_type.trim().equals("AVERAGE"))
					{
						//tempAvg="selected";
						//disabled ="disabled";
						//tempSum = "";
						//tempMin = "";
						//tempMax = "";
						//tempPct = "";
					}
					else if(summary_type.trim().equals("MAXIMUM"))
					{
						//tempMax="selected";						
						//disabled ="disabled";
						//tempSum = "";
						//tempAvg = "";
						//tempMin = "";
						// tempPct = "";
					}
					else if(summary_type.trim().equals("MINIMUM"))
					{
						//tempMin="selected";disabled ="disabled";
						//tempSum = "";
						//tempAvg = "";
						//tempMax = "";
						//tempPct = "";
					}
					else if(summary_type.trim().equals("PERCENTAGE"))
					{
						//tempPct="selected";disabled ="disabled";
						//tempSum = "";
						//tempAvg = "";
						//tempMin = "";
						//tempMax = "";
					}
					else
					{
						//tempSum = "";
						//tempAvg = "";
						//tempMin = "";
						//tempMax = "";
						//tempPct = "";
						//disabled ="disabled";
					}
					if(result_type.equals("A")){

						if(rsChartComp !=null) rsChartComp.close();
						rsChartComp = psChartComp.executeQuery();
						while(rsChartComp.next())
						{
							formulaDefn = rsChartComp.getString(1) == null ? "" : rsChartComp.getString(1);
							tabFormula.put(panel_desc_id,formulaDefn);
						}
						if(rsChartComp !=null) rsChartComp.close();
					}
					if(finalString.toString().equals("")){
						finalString.append(discr_msr_desc+ "||" + discr_msr_id +"||"+ order_serial_no + "||" + result_type+"||"+associate_score_yn);
					}
					else
					{
						finalString.append( "~" +discr_msr_desc+ "||" + discr_msr_id +"||"+ order_serial_no + "||" + result_type+"||"+associate_score_yn);
					}


				recordsBean.addRecords(tableForRecs);
				formulaBean.addFormula(tabFormula);
				formulaBean.setSummary(tabSummary);

				}				
				if(finalString.toString().length() != 0){
			%>
			<script>
				displayDiscrMsrForPanel('<%=chart_id%>','<%=panel_id%>','<%=finalString.toString()%>','<%=summary_req_yn%>','<%=change_at_trans%>','<%=mandatory_yn%>','<%=associate_score_yn%>');
			</script>
			<%				
				}
			
			}//end of try-1
			catch(Exception e){
				//out.println("Exception in try-1 of chartComponentIntermediateAddPanel.jsp"+e.toString());//COMMON-ICN-0181
				e.printStackTrace();//COMMON-ICN-0181
			}
			finally{
				/*tableForRecs.clear();
				tabFormula.clear();
				tabSummary.clear();*/

			if(rsAddDiscrMsr!=null) rsAddDiscrMsr.close();
			
			
			if(resTrans!=null) resTrans.close();
			if(psAddDiscrMsr!=null) psAddDiscrMsr.close();
			if(psChartComp!=null) psChartComp.close();
			
			if(psTrans!=null) psTrans.close();
			

				if(con!=null) ConnectionManager.returnConnection(con,request);
			}
%>
	</body>
</html>

