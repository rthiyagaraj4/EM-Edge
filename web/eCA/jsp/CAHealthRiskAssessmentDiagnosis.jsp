<!DOCTYPE html>
<%/*  
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date       			Edit History    	Name        	Description
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
15/03/2013			IN030469			Ramesh G		Continuous and opportunistic screening for diseases will be performed if the patient fits the criteria. 
														The general practitioner will be alerted if such patients attend the clinic.   								 
-------------------------------------------------------------------------------------------------
Date       	Edit History      	Name        	Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------
28/06/2018	IN065341		Prakash C	29/06/2018		Ramesh G 		MMS-DM-CRF-0115
07/03/2022	27788			Ramesh Goli		07/03/2022		RAMESH G    	MMS-ME-SCF-0067
---------------------------------------------------------------------------------------------------------
*/%>
<%@ page import="java.util.*,java.io.*,java.net.*,eCA.*,java.text.*,org.jfree.ui.*,javax.servlet.*,javax.servlet.http.*,org.jfree.chart.*,org.jfree.chart.axis.*,org.jfree.chart.entity.StandardEntityCollection,org.jfree.chart.labels.*,org.jfree.chart.plot.*,org.jfree.chart.renderer.*,org.jfree.chart.servlet.ServletUtilities,org.jfree.chart.urls.*,org.jfree.data.*,org.jfree.data.time.*,org.jfree.chart.title.TextTitle,org.jfree.data.xy.*,org.jfree.chart.labels.StandardXYToolTipGenerator,org.jfree.chart.renderer.xy.XYLineAndShapeRenderer,org.jfree.chart.imagemap.StandardToolTipTagFragmentGenerator,javax.swing.JPanel,eCA.ChartComponentFormulaBean,java.text.SimpleDateFormat,org.jfree.data.category.DefaultCategoryDataset.*,org.jfree.chart.axis.*,org.jfree.chart.block.*,org.jfree.chart.title.CompositeTitle,org.jfree.chart.title.LegendTitle,org.jfree.data.category.*,org.jfree.chart.renderer.category.*,webbeans.eCommon.*,java.sql.*" %>
<%@page import="java.sql.*,java.net.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@page import="java.util.*, eCA.*,eOR.*,eOR.Common.*, eCommon.Common.*, java.sql.*, webbeans.eCommon.*,eCA.Common.*,org.apache.commons.codec.binary.Base64"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String prefStyleSheet = request.getParameter("prefStyle");
String content_ID = request.getParameter("content_ID");
String reqString = request.getQueryString();
//IN065341 starts
	
	String patid="";
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String clob_data=request.getParameter("clob_data")==null?"":request.getParameter("clob_data");
	String encId="";
	if(called_from.equals("CDR")){
		encId = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		patid=request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	}else{//IN065341 ends
		patid=request.getParameter("Patient_ID");
	   	encId = request.getParameter("encounter_id");
	}//IN065341
String defaultDiag = "";
String bean_id ="AssessmentBean"+patid+encId;

DefaultCategoryDataset dataset = new DefaultCategoryDataset(); 

//27788 Start.
StringBuffer paramStringBuffer= new StringBuffer();
paramStringBuffer.append("prefStyle="+prefStyleSheet+"&content_ID="+content_ID);
if(request.getParameter("patient_id")!=null)
	paramStringBuffer.append("&patient_id="+new String(Base64.encodeBase64(((String)request.getParameter("patient_id")).getBytes())));
if(request.getParameter("Patient_ID")!=null)
	paramStringBuffer.append("&Patient_ID="+new String(Base64.encodeBase64(((String)request.getParameter("Patient_ID")).getBytes())));
if(request.getParameter("enc_id1")!=null)
	paramStringBuffer.append("&enc_id1="+new String(Base64.encodeBase64(((String)request.getParameter("enc_id1")).getBytes())));
if(request.getParameter("encounter_id")!=null)
	paramStringBuffer.append("&encounter_id="+new String(Base64.encodeBase64(((String)request.getParameter("encounter_id")).getBytes())));

paramStringBuffer.append("&called_from="+called_from+"&RepDb="+RepDb);
//27788 End.
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="JavaScript" src="../../eCA/js/CAHealthRiskAssessment.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body class='CONTENT' OnMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<form name='CAHealthRiskAssessmentDiagnosisForm' id='CAHealthRiskAssessmentDiagnosisForm'>  
	<table class='grid' cellpadding='1' cellspacing='1' border='0' width='100%' height='100%' >
				
		<tr style="height:20px;">
			<%if(sStyle.equals(prefStyleSheet) )
			{%>
				<th class='columnHeadercenter' nowrap width='55%'>Diagnosis</th>
				<th class='columnHeadercenter'  nowidth='20%'>Risk Score</th>
				<!--<th class='columnHeadercenter' nowrap width='21%'>&nbsp;</th>-->
				<th class='columnHeadercenter'  nowrap width='25%'>View</th>
			<%}else{ %>		
				<th class='columnHeadercentericons<%=content_ID%>' nowrap width='55%'>Diagnosis</th>
				<th class='columnHeadercentericons<%=content_ID%>'  nowidth='20%'>Risk Score</th>
				<th class='columnHeadercentericons<%=content_ID%>'  nowrap width='25%'>View</th>
			<%}%>
		</tr>	
		<tr>
			<td colspan="4" valign="top">
				<table cellpadding='0' cellspacing='0' border='0' width='100%'>							
					<%
						String termSetCode 	= "";
						String termDesc 	= "";
						PreparedStatement pstmt = null;
						ResultSet rs = null;
						//String qry = "SELECT TERM_SET_ID, TERM_SET_CODE, TERM_DESC || '(' ||TERM_SET_CODE || ')'  TERM_DESC ,         round(((  SUM (risk_factor_score) / (select sum(risk_factor_score) from CA_RISK_FACTOR_DTL where RISK_FACTOR_TYPE in ((SELECT risk_factor FROM ca_diag_risk_factor WHERE risk_grp_type = 'I' and term_set_id =A.term_set_id and  term_set_code = A.term_set_code  UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor a,ca_group_risk_factor_dtl b WHERE risk_grp_type = 'G' AND a.risk_factor = risk_factor_group and term_set_id =A.term_set_id and  term_set_code = A.term_set_code ))) ) * 100 ),0) risk_score_perc    FROM (SELECT   A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC TERM_DESC,SUM (RISK_FACTOR_SCORE) RISK_FACTOR_SCORE, 'A' GRAND_TOTAL FROM CA_HEALTH_RISK_ASSMNT_VW A, MR_TERM_CODE B WHERE PATIENT_ID = ? AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_SET_CODE = B.TERM_CODE AND 'Y' = CA_RISK_FACTOR_GRP_APPL(A.PATIENT_ID,A.ENCOUNTER_ID,A.FACILITY_ID,A.TERM_SET_ID,A.TERM_SET_CODE,A.RISK_GRP_TYPE,A.RISK_FACTOR,A.RISK_FACT_GRP,A.FACTOR_MAND_YN) and rownum <=10 GROUP BY A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC) A GROUP BY TERM_SET_ID, TERM_SET_CODE, TERM_DESC, GRAND_TOTAL,RISK_FACTOR_SCORE ORDER BY 4 DESC ";
						//String qry = "SELECT TERM_SET_ID, TERM_SET_CODE, TERM_DESC || '(' ||TERM_SET_CODE || ')'  TERM_DESC ,         round(((  SUM (risk_factor_score) / (select sum(risk_factor_score) from CA_RISK_FACTOR_DTL ##REPDB## where RISK_FACTOR_TYPE in ((SELECT risk_factor FROM ca_diag_risk_factor ##REPDB## WHERE risk_grp_type = 'I' and term_set_id =A.term_set_id and  term_set_code = A.term_set_code  UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor ##REPDB## a,ca_group_risk_factor_dtl ##REPDB## b WHERE risk_grp_type = 'G' AND a.risk_factor = risk_factor_group and term_set_id =A.term_set_id and  term_set_code = A.term_set_code ))) ) * 100 ),0) risk_score_perc    FROM (SELECT   A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC TERM_DESC,SUM (RISK_FACTOR_SCORE) RISK_FACTOR_SCORE, 'A' GRAND_TOTAL FROM CA_HEALTH_RISK_ASSMNT_VW##CLOB## A, MR_TERM_CODE ##REPDB## B WHERE PATIENT_ID = ? AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_SET_CODE = B.TERM_CODE AND 'Y' = CA_RISK_FACTOR_GRP_APPL##REPDB## (A.PATIENT_ID,A.ENCOUNTER_ID,A.FACILITY_ID,A.TERM_SET_ID,A.TERM_SET_CODE,A.RISK_GRP_TYPE,A.RISK_FACTOR,A.RISK_FACT_GRP,A.FACTOR_MAND_YN) and rownum <=10 GROUP BY A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC) A GROUP BY TERM_SET_ID, TERM_SET_CODE, TERM_DESC, GRAND_TOTAL,RISK_FACTOR_SCORE ORDER BY 4 DESC ";//IN065341
												
						String qry ="";
						/*if(called_from.equals("CDR")){
							//qry = "SELECT A.TERM_SET_ID, A.TERM_SET_CODE, A.TERM_DESC, A.risk_score_perc  FROM ca_health_risk_assmnt_score_vw  ##REPDB## A WHERE A.PATIENT_ID = ?  ";
							qry ="SELECT   c.term_set_id, c.term_set_code,c.term_desc || '(' || c.term_set_code || ')' term_desc, ROUND((  (  SUM (c.risk_factor_score)/ (SELECT SUM (e.risk_factor_score) FROM ca_risk_factor_dtl##REPDB## e WHERE e.risk_factor_type IN ((SELECT g.risk_factor FROM ca_diag_risk_factor##REPDB## g WHERE g.risk_grp_type = 'I' AND g.term_set_id = c.term_set_id AND g.term_set_code = c.term_set_code UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor##REPDB## a,ca_group_risk_factor_dtl##REPDB## b WHERE a.risk_grp_type = 'G' AND a.risk_factor =b.risk_factor_group )))) * 100),0) risk_score_perc FROM (SELECT   a.term_set_id, a.term_set_code, b.short_desc term_desc,SUM (a.risk_factor_score) risk_factor_score,'A' grand_total FROM ca_health_risk_assmnt_vw##REPDB## a, mr_term_code##REPDB## b WHERE a.patient_id = ? AND a.term_set_id = b.term_set_id AND a.term_set_code = b.term_code AND 'Y' =ca_risk_factor_grp_appl##REPDB## (a.patient_id,a.encounter_id,a.facility_id,a.term_set_id,a.term_set_code,a.risk_grp_type,a.risk_factor,a.risk_fact_grp,a.factor_mand_yn)AND ROWNUM <= 10 GROUP BY a.term_set_id, a.term_set_code, b.short_desc) c GROUP BY c.term_set_id,c.term_set_code,c.term_desc,c.grand_total,c.risk_factor_score ORDER BY 4 DESC";
						}else{
							qry = "SELECT TERM_SET_ID, TERM_SET_CODE, TERM_DESC || '(' ||TERM_SET_CODE || ')'  TERM_DESC ,         round(((  SUM (risk_factor_score) / (select sum(risk_factor_score) from CA_RISK_FACTOR_DTL ##REPDB## where RISK_FACTOR_TYPE in ((SELECT risk_factor FROM ca_diag_risk_factor ##REPDB## g WHERE g.risk_grp_type = 'I' and g.term_set_id =A.term_set_id and  g.term_set_code = A.term_set_code  UNION SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor ##REPDB## a,ca_group_risk_factor_dtl ##REPDB## b WHERE risk_grp_type = 'G' AND a.risk_factor = risk_factor_group and term_set_id =A.term_set_id and  term_set_code = A.term_set_code ))) ) * 100 ),0) risk_score_perc    FROM (SELECT   A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC TERM_DESC,SUM (RISK_FACTOR_SCORE) RISK_FACTOR_SCORE, 'A' GRAND_TOTAL FROM CA_HEALTH_RISK_ASSMNT_VW##CLOB## A, MR_TERM_CODE ##REPDB## B WHERE PATIENT_ID = ? AND A.TERM_SET_ID = B.TERM_SET_ID AND A.TERM_SET_CODE = B.TERM_CODE AND 'Y' = CA_RISK_FACTOR_GRP_APPL##REPDB## (A.PATIENT_ID,A.ENCOUNTER_ID,A.FACILITY_ID,A.TERM_SET_ID,A.TERM_SET_CODE,A.RISK_GRP_TYPE,A.RISK_FACTOR,A.RISK_FACT_GRP,A.FACTOR_MAND_YN) and rownum <=10 GROUP BY A.TERM_SET_ID, A.TERM_SET_CODE, B.SHORT_DESC) A GROUP BY TERM_SET_ID, TERM_SET_CODE, TERM_DESC, GRAND_TOTAL,RISK_FACTOR_SCORE ORDER BY 4 DESC ";
						}*/
						qry="SELECT   c.term_set_id, c.term_set_code, c.term_desc || '(' || c.term_set_code || ')' term_desc, ROUND ((( SUM (c.risk_factor_score) / (  NVL((SELECT SUM (e.risk_factor_score) FROM ca_risk_factor_dtl##REPDB## e  WHERE e.risk_factor_type IN ( (SELECT g.risk_factor FROM ca_diag_risk_factor##REPDB## g WHERE g.risk_grp_type = 'I' AND g.term_set_id = c.term_set_id  AND g.term_set_code = c.term_set_code))),0)  + NVL((SELECT SUM (z.risk_factor_score) FROM ca_risk_factor_dtl##REPDB## z WHERE z.risk_factor_type IN ( (SELECT b.risk_factor_type risk_factor FROM ca_diag_risk_factor##REPDB## y, ca_group_risk_factor_dtl##REPDB## b WHERE y.risk_grp_type = 'G' AND y.risk_factor = b.risk_factor_group))),0))) * 100), 0) risk_score_perc FROM (SELECT   a.term_set_id, a.term_set_code, b.short_desc term_desc,SUM (a.risk_factor_score) risk_factor_score,'A' grand_total  FROM ca_health_risk_assmnt_vw##REPDB## a, mr_term_code##REPDB## b WHERE a.patient_id = ? AND a.term_set_id = b.term_set_id AND a.term_set_code = b.term_code AND 'Y' = ca_risk_factor_grp_appl##REPDB## (a.patient_id, a.encounter_id,a.facility_id,a.term_set_id,a.term_set_code,a.risk_grp_type,a.risk_factor,a.risk_fact_grp,a.factor_mand_yn ) AND ROWNUM <= 10 GROUP BY a.term_set_id, a.term_set_code, b.short_desc) c GROUP BY c.term_set_id,c.term_set_code,c.term_desc,c.grand_total,c.risk_factor_score ORDER BY 4 DESC";
						Connection con = null;
						try{
							con = ConnectionManager.getConnection(request);	

							
							qry=qry.replaceAll("##REPDB##",RepDb);//IN065341
							qry=qry.replaceAll("##CLOB##",clob_data);//IN065341 ends
							pstmt = con.prepareStatement(qry);
							pstmt.setString(1,patid);
							rs = pstmt.executeQuery();
					
							int cnt = 0;
							String checked  = "";

							while(rs!=null && rs.next()){
								termDesc = rs.getString("TERM_DESC");
								termSetCode = rs.getString("TERM_SET_CODE");
								String riskScorePerc = rs.getString("RISK_SCORE_PERC");
								checked = "";
								cnt++;
								
								if(cnt <= 1)
								{
									checked = "checked";
									defaultDiag = termSetCode;
									//onLoadRiskFactorDesc = termDesc;
								}

								dataset.addValue(Integer.parseInt(riskScorePerc), "Diagnosis", termSetCode);
								%>
									<tr style="height:30px;">
										<td class=gridData width='60%'>
											<%=termDesc%>
										</td>
										<td class=gridData width='20%'>
											<%=riskScorePerc%>%
										</td>									
										<td class=gridData width='25%'  align="center" >
											<input type="checkbox" name="diagnosisChk" id="diagnosisChk" value="<%=termSetCode%>" <%=checked%> onclick = 'getCatelogRiskFactorDetails();'/>
										</td>
									</tr>
								<%											
							}
						}catch(Exception e){
							e.printStackTrace();
						}finally{
							if(pstmt!=null)pstmt.close();			
							if(rs!=null)rs.close();
							if(con!=null)con.close();
						}
						session.setAttribute(bean_id, dataset);
					%>													
				</table>
			</td>
		</tr>
		<input type="hidden" name="reqString" id="reqString" value="<%=reqString%>"/>
		<input type="hidden" name="called_from" id="called_from" value="<%=called_from%>"/>
	</table>
</form>

<script>
	<%if(!called_from.equals("CDR")){%>
	parent.CAHealthRiskAssessmentOrderCatalogFrm.location.href="../../eCA/jsp/CAHealthRiskAssessmentOrderCatalogs.jsp?<%=reqString%>&TermSetCode=<%=defaultDiag%>";
	<%}%>
	parent.CAHealthRiskAssessmentGraphFrm.location.href="../../eCA/jsp/CAHealthRiskAssessmentGraph.jsp?bean_id=<%=bean_id%>";
	//27788 Start.
	//parent.CAHealthRiskAssessmentHealthRiskFactorsFrm.location.href="../../eCA/jsp/CAHealthRiskAssessmentHealthRiskFactors.jsp?<%=reqString%>&TermSetCode=<%=defaultDiag%>";
	parent.CAHealthRiskAssessmentHealthRiskFactorsFrm.location.href="../../eCA/jsp/CAHealthRiskAssessmentHealthRiskFactors.jsp?<%=paramStringBuffer.toString()%>&compressed=Y&TermSetCode=<%=defaultDiag%>";
	//27788 End.
</script>
</body>
</html>

