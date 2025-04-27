<!DOCTYPE html>
<%/* 
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       			Edit History    	Name        	Description
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
15/03/2013			IN030469			Ramesh G		BRU-HIMS-CRF-028 Continuous and opportunistic screening for diseases will be performed if the patient fits the criteria. The general practitioner will be alerted if such patients attend the clinic
----------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
---------------------------------------------------------------------------------------------------------
24/05/2018	IN065341	Prakash C	25/05/2018		Ramesh G		ML-MMOH-CRF-0115
31/08/2018      IN068080	Sharanraj	31/08/2018		Ramesh G		MMS-ICN-00091
--------------------------------------------------------------------------------------------------------
*/%>
<%@ page import="java.util.*,java.io.*,java.net.*,java.text.*,org.jfree.ui.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.data.time.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,eCA.ChartComponentFormulaBean,java.text.SimpleDateFormat,org.jfree.data.category.DefaultCategoryDataset.*,org.jfree.chart.axis.*,org.jfree.chart.block.*,org.jfree.chart.title.CompositeTitle,org.jfree.chart.title.LegendTitle,org.jfree.data.category.*,org.jfree.chart.renderer.category.*,webbeans.eCommon.*,java.sql.*" %>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,org.apache.commons.codec.binary.Base64,eCommon.XSSRequestWrapper"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
//String patid=request.getParameter("Patient_ID"); 
//IN065341 starts
	String bean_id1 = "ca_CentralizedBean" ;
	String bean_name1 = "eCA.CentralizedBean";
	CentralizedBean bean1 = (CentralizedBean)getBeanObject( bean_id1, bean_name1, request ) ;
	bean1.setLanguageId(localeName);
	bean1.clear() ;
	bean1.setFunctionId(bean1.checkForNull(request.getParameter("function_id")));
	String patid="";
	String encId="";
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");	
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	//27788 Start.
	String compressed =request.getParameter("compressed")==null?"N":(String)request.getParameter("compressed"); 
	if("Y".equals(compressed)){	 
		if(called_from.equals("CDR")){
			if(request.getParameter("enc_id1")!=null)
				encId= new String(Base64.decodeBase64(((String)request.getParameter("enc_id1")).getBytes()));
			if(request.getParameter("patient_id")!=null)
				patid= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
				
		}else{//IN065341 ends
			if(request.getParameter("Patient_ID")!=null)
				patid = new String(Base64.decodeBase64(((String)request.getParameter("Patient_ID")).getBytes()));
			if(request.getParameter("encounter_id")!=null)
				encId = new String(Base64.decodeBase64(((String)request.getParameter("encounter_id")).getBytes()));
		}//IN065341
	}else{
		//27788 End.
		if(called_from.equals("CDR")){
			encId = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
			patid=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
		}else{//IN065341 ends
			patid=request.getParameter("Patient_ID");
			encId = request.getParameter("encounter_id");
		}//IN065341
	} //27788
	
	
String defaultDiag = request.getParameter("TermSetCode")==null?"":(String)request.getParameter("TermSetCode");
String[] defaultDiag_=defaultDiag.split("\\|");
defaultDiag="";
for(int i=0;i<defaultDiag_.length;i++){
	defaultDiag=defaultDiag+"'"+defaultDiag_[i]+"'";
	if((i+1)!=defaultDiag_.length)
		defaultDiag=defaultDiag+",";
}
String normal_Yn = "N";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eCA/js/CAHealthRiskAssessment.js"></script>
<script src='../../eCA/js/FlowSheet.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='CAHealthRiskAssessmentHealthRiskFactorsForm' id='CAHealthRiskAssessmentHealthRiskFactorsForm'>  
	<table class='grid' cellpadding='0' cellspacing='0' border='0' width='100%' height='100%' >
		<tr style="height:20px;">
			<th class='columnHeadercenter' nowrap >Health Risk Factors</th>
		</tr>
		<tr>
		<td valign="top">
			<DIV style="height:350px;overflow:auto;" id='healthRiskFactorsTable'>
				<table cellpadding='1' cellspacing='1' border='0' width='100%'>	
				<%!
				String replaceSpecialChar(String resultStr){		
					if(resultStr.indexOf("\n")!=-1)
						resultStr = resultStr.replaceAll("\n","~");			
					if(resultStr.indexOf("\r")!=-1)
						resultStr = resultStr.replaceAll("\r","");
					if(resultStr.indexOf("'")!=-1)
						resultStr = resultStr.replaceAll("'","`");
					if(resultStr.indexOf("\"")!=-1)
						resultStr = resultStr.replaceAll("\"","|");
					return resultStr;
				}
				%>												
				<%
				PreparedStatement pstmt1 = null;
				ResultSet rs1 = null;
				Connection con = null;				
				//String qry1 = "SELECT   risk_grp_type, factor_mand_yn, risk_fact_grp,(SELECT risk_factor_desc FROM ca_group_risk_factor_type WHERE risk_factor_group = a.risk_fact_grp) risk_fact_grp_desc, risk_factor, (SELECT risk_factor_desc FROM ca_risk_factor_type WHERE risk_factor_type = a.risk_factor) risk_fact_desc, a.term_set_id, term_set_code, risk_factor_type, risk_factor_score, risk_factor_code, risk_factor_set_id, risk_factor_ind, srl_no, color_ind, risk_factor_mesg, patient_id, encounter_id, facility_id, event_date, DECODE (NVL (result_num_dec, 0), 0,  TO_CHAR (result_num), TO_CHAR (result_num, DECODE (result_num_dec, 1, '999999999999999990.0', 2, '99999999999999990.90', 3, '999999999999990.900', 4, '99999999999990.9000', 5, '9999999999990.90000', 6, '999999999990.900000', 7, '99999999990.9000000', 8, '9999999990.90000000', 9, '999999990.90000000', 0, '9999999999999999999', '9999999999999999999' ) ) ) result_num, result_num_uom, result_num_dec, result_num_prefix, result_str, normalcy_str, normalcy_ind, normal_low, normal_high, critical_low, critical_high, practitioner_id, performed_by_id, hist_rec_type, contr_sys_id, accession_num, contr_sys_event_code, short_desc, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code, abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code, 'NONE' ) FROM cr_clin_event_param) color_cell_ind, hist_data_type,(select count(1) from cr_encounter_detail_txt i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength(hist_data)>0) text_count,event_code,event_group FROM ca_health_risk_assmnt_vw a, mr_term_code b WHERE patient_id = ? AND a.term_set_id = b.term_set_id AND a.term_set_code = b.term_code AND 'Y' = ca_risk_factor_grp_appl (a.patient_id,a.encounter_id, a.facility_id,a.term_set_id,a.term_set_code, a.risk_grp_type,a.risk_factor,a.risk_fact_grp,a.factor_mand_yn) AND term_set_code in("+defaultDiag+") ORDER BY term_set_id, term_set_code, risk_fact_grp, risk_factor";
				String qry1 = "SELECT   risk_grp_type, factor_mand_yn, risk_fact_grp,(SELECT risk_factor_desc FROM ca_group_risk_factor_type ##REPDB## WHERE risk_factor_group = a.risk_fact_grp) risk_fact_grp_desc, risk_factor, (SELECT risk_factor_desc FROM ca_risk_factor_type ##REPDB## WHERE risk_factor_type = a.risk_factor) risk_fact_desc, a.term_set_id, term_set_code, risk_factor_type, risk_factor_score, risk_factor_code, risk_factor_set_id, risk_factor_ind, srl_no, color_ind, risk_factor_mesg, patient_id, encounter_id, facility_id, event_date, DECODE (NVL (result_num_dec, 0), 0,  TO_CHAR (result_num), TO_CHAR (result_num, DECODE (result_num_dec, 1, '999999999999999990.0', 2, '99999999999999990.90', 3, '999999999999990.900', 4, '99999999999990.9000', 5, '9999999999990.90000', 6, '999999999990.900000', 7, '99999999990.9000000', 8, '9999999990.90000000', 9, '999999990.90000000', 0, '9999999999999999999', '9999999999999999999' ) ) ) result_num, result_num_uom, result_num_dec, result_num_prefix, result_str, normalcy_str, normalcy_ind, normal_low, normal_high, critical_low, critical_high, practitioner_id, performed_by_id, hist_rec_type, contr_sys_id, accession_num, contr_sys_event_code, short_desc, (SELECT DECODE (a.normalcy_ind, high_str, high_color_code, low_str, low_color_code, crit_str, crit_color_code, abn_str, abn_color_code, crit_high_str, crit_high_color_code, crit_low_str, crit_low_color_code, 'NONE' ) FROM cr_clin_event_param ##REPDB##) color_cell_ind, hist_data_type,(select count(1) from cr_encounter_detail_txt##CLOB## i where i.hist_rec_type=a.hist_rec_type and i.contr_sys_id=a.contr_sys_id and i.accession_num=a.accession_num and i.contr_sys_event_code=a.contr_sys_event_code and dbms_lob.getlength (hist_data)>0) text_count,event_code,event_group FROM ca_health_risk_assmnt_vw##REPDB## a, mr_term_code ##REPDB## b WHERE patient_id = ? AND a.term_set_id = b.term_set_id AND a.term_set_code = b.term_code AND 'Y' = ca_risk_factor_grp_appl (a.patient_id,a.encounter_id, a.facility_id,a.term_set_id,a.term_set_code, a.risk_grp_type,a.risk_factor,a.risk_fact_grp,a.factor_mand_yn) AND term_set_code in("+defaultDiag+") ORDER BY term_set_id, term_set_code, risk_fact_grp, risk_factor";//IN065341

				try
				{
					con = ConnectionManager.getConnection(request);
					//IN065341 starts
					/*if(called_from.equals("CDR")){						
						bean1.executeCDR(con,patid,encId,RepDb,"CA_HEALTH_RISK_ASSMNT_VW");
					}*/
					
					qry1=qry1.replaceAll("##REPDB##",RepDb);//IN065341
					qry1=qry1.replaceAll("##CLOB##",clob_data);//IN065341 ends
					pstmt1 = con.prepareStatement(qry1);
					pstmt1.setString(1,patid);
					rs1 = pstmt1.executeQuery();
					String termSetDescTemp = "";
					int j=0;
					while(rs1!=null && rs1.next())
					{
						String riskFactDesc = rs1.getString("RISK_FACT_DESC");
						
						String histDataType = rs1.getString("hist_data_type")==null?"":rs1.getString("hist_data_type");
						String colorCellInd = rs1.getString("color_cell_ind")==null?"":rs1.getString("color_cell_ind");
						
						String normIndicator= rs1.getString("normalcy_ind")==null?"":rs1.getString("normalcy_ind");
						String normalLow= rs1.getString("normal_low")==null?"":rs1.getString("normal_low");
						String normalHigh= rs1.getString("normal_high")==null?"":rs1.getString("normal_high");
						
						String resultNum = rs1.getString("result_num")==null?"":rs1.getString("result_num");
						String resultNum_Uom = rs1.getString("result_num_uom")==null?"":rs1.getString("result_num_uom");
						String resultNumPrefix = rs1.getString("result_num_prefix")==null?"":rs1.getString("result_num_prefix");
						
						String resultStr = rs1.getString("result_str")==null?"":rs1.getString("result_str");
						String normalcyStr=rs1.getString("normalcy_str")==null?"":rs1.getString("normalcy_str");
						
						String textCount= rs1.getString("text_count")==null?"0":rs1.getString("text_count");
						String eventCode = rs1.getString("event_code")==null?"":rs1.getString("event_code");
						String eventGroup = rs1.getString("event_group")==null?"":rs1.getString("event_group");
						
						// Start.
						/*String histRecType ="";
						String accessionNum = "";
						String sysID = "";
						String sysEventCode =  "";
						String enctr_id = "";
						String fac_id = "";*/
						
						String histRecType = rs1.getString("hist_rec_type")==null?"":rs1.getString("hist_rec_type");
						String accessionNum = rs1.getString("accession_num")==null?"":rs1.getString("accession_num");
						String sysID = rs1.getString("contr_sys_id")==null?"":rs1.getString("contr_sys_id");
						String sysEventCode =  rs1.getString("contr_sys_event_code")==null?"":rs1.getString("contr_sys_event_code");
						String enctr_id = rs1.getString("encounter_id")==null?"":rs1.getString("encounter_id");
						String fac_id = rs1.getString("facility_id")==null?"":rs1.getString("facility_id");
						// End.
						
						String termSetDesc = rs1.getString("short_desc")==null?"":rs1.getString("short_desc");
						
						
						
						if(histDataType.equals("NUM")){									
							if(!resultNum.equals("")){
								if(colorCellInd.equals("NONE")){
									if(normIndicator.equals("."))
										normal_Yn = "Y";
									else if(!normalLow.equals("") && !normalHigh.equals("")){
										if(Float.parseFloat(resultNum) > 0){
											if ((Float.parseFloat(resultNum) >= Float.parseFloat(normalLow)) && (Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh)) )
												normal_Yn = "Y";
											else
												normal_Yn = "N";
										}else
											normal_Yn = "N";
									}else if(!normalLow.equals("") && normalHigh.equals("")){
										if(Float.parseFloat(resultNum) > 0){
											if (Float.parseFloat(resultNum) >= Float.parseFloat(normalLow))
												normal_Yn = "Y";
											else
												normal_Yn = "N";
										}else
											normal_Yn = "N";
									}else if(normalLow.equals("") && !normalHigh.equals("")){
										if(Float.parseFloat(resultNum) > 0){
											if(Float.parseFloat(resultNum) <= Float.parseFloat(normalHigh))
												normal_Yn = "Y";
											else
												normal_Yn = "N";
										}else
											normal_Yn = "N";
									}else
										normal_Yn = "N";
								}else
									normal_Yn = "N";
							}
						}
						else if(normIndicator.equals("."))
							normal_Yn = "Y";
						else
							normal_Yn = "N";
						
						
						if(!"".equals(resultNumPrefix))
							resultNum = resultNumPrefix + resultNum;
						
						String tempValue="";
						if(histDataType.equals("NUM")){
							
							if(!resultStr.equals("")) //if there is any STR
							{
								resultStr=replaceSpecialChar(resultStr);
								if(resultStr.length() > 10)
									tempValue = "<a  href='javascript:ShowComments(\""+resultStr+"\")'><font size='1' color='blue'><i>"+resultStr.substring(0,9)+"...</i></a>";
								else
									tempValue =resultStr;
							}
							if(!textCount.equals("0"))//if there is any TXT
							{								
							//IN065341 starts		
								//tempValue =tempValue+" <img id='imageFlowText' src='../../eCA/images/flow_text.gif' style='display' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";
								tempValue =tempValue+" <img id='imageFlowText' src='../../eCA/images/flow_text.gif' style='display' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"','"+called_from+"','"+RepDb+"','"+clob_data+"')\">";
							//IN065341 ends	
							}
							//tempValue =tempValue+" <img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patid+"','"+eventCode+"','"+eventGroup+"','"+histRecType+"')\" />";
							tempValue =tempValue+" <img src='../../eCA/images/chart.gif' alt='Graph' onclick=\"openGrpah('"+j+"','"+patid+"','"+eventCode+"','"+eventGroup+"','"+histRecType+"','"+RepDb+"','"+clob_data+"')\" />";//IN065341
						}
						else if(histDataType.equals("TXT") || histDataType.equals("HTM"))
						{
							if(!textCount.equals("0"))
							{								
								//tempValue = "<img id='imageFlowTextVis' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";//IN031989//IN033489
								tempValue = "<img id='imageFlowTextVis' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"','"+called_from+"','"+RepDb+"','"+clob_data+"')\">";//IN065341
							}
						}
						else 
						{
							if(resultStr.length() > 15)
							{
								resultStr=replaceSpecialChar(resultStr);
								tempValue = "<a  href=\"javaScript:ShowComments('"+resultStr+"')\"><font size='1' color='blue'>"+resultStr.substring(0,14)+"...</a><br>";
							}else
									tempValue =resultStr;
							if(!normalcyStr.equals(""))
							{
								tempValue = tempValue + " <font color=blue>( Normal Value : " + normalcyStr + " )</font>";
							}
							if(!textCount.equals("0"))//in case of STR if any TXT is there
							{
								//tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"')\">";//IN031989//IN033489
								tempValue =tempValue+"&nbsp;"+"<img id='imageFlowTextVis' style='display' src='../../eCA/images/flow_text.gif' onClick=\"return getText('"+histRecType+"','"+sysID+"','"+accessionNum+"','"+sysEventCode+"','"+enctr_id+"','"+fac_id+"','"+called_from+"','"+RepDb+"','"+clob_data+"')\">";//IN065341
							}
						}
						if(!"".equals(tempValue)){
							if(histDataType.equals("NUM")){
								String tempValue_="";
								if(!colorCellInd.equals("NONE"))
									tempValue_ = "<font  style='background-image:url(\"../../eCA/images/"+colorCellInd+"\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;";
								else if(normal_Yn.equals("Y"))
									tempValue_ = "<font  style='background-image:url(\"../../eCA/images/NI_Normal.gif\");size:1;width:16px;height:16px' >&nbsp;&nbsp;</font>&nbsp;" ;
									
								tempValue = tempValue_+"&nbsp;"+resultNum+"&nbsp;"+resultNum_Uom +tempValue;
								
							}
						}
						
						
%>
						<%
						if(!termSetDescTemp.equals(termSetDesc))
						{
						%>
						<tr>
							<td class='columnHeadercenter' colspan="2" width="100%" align="left"><%=termSetDesc%></td>
						</tr>

						<%termSetDescTemp = termSetDesc;
						}
						%>

						<tr>
							<td class=gridData width="50%"><%=riskFactDesc%></td>
							<td class=gridData width="50%">&nbsp;
							<%=tempValue%>
							</td>
						</tr>
<%
					j++;				
					}
				}
				catch(Exception e)
				{
					e.printStackTrace();
				}	
				finally
				{
					if(pstmt1!=null)pstmt1.close();			
					if(rs1!=null)rs1.close();
					if(con!=null)con.close();
				}
				
				%>
					</table>
				</DIV>
			</td>
		</tr>
	</table>							
	<input type="hidden" name="patient_id" id="patient_id" value="<%=patid %>"/> <!-- IN068080 -->					
</form>
</body>
</html>

