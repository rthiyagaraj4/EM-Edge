<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History     Name      			Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
11/05/2018	IN063838		Ramesh G											ML-MMOH-CRF-0813
23/10/2018	IN067402		Prakash				10/09/2018		Ramesh Goli		ML-MMOH-CRF-0813.1
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>

<%@page import="java.util.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp" %>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String recordedScoreYN = request.getParameter("recordedScoreYN")==null?"":request.getParameter("recordedScoreYN");
String stageOfPuberty = request.getParameter("stageOfPuberty")==null?"":request.getParameter("stageOfPuberty");
String pubicHair = request.getParameter("pubicHair")==null?"":request.getParameter("pubicHair");
String isAuditYN = request.getParameter("isAuditYN")==null?"N":request.getParameter("isAuditYN");//IN067402
%>
<html>
	<head>	
		<link rel='StyleSheet' href='../html/CATannerStaging.css' type='text/css'>	
		<script language='javascript' src='../js/json2.js'></script>	
		<script language='javascript' src='../../eCommon/js/common.js'></script>
		<script language='javascript' src='../js/CATannerStaging.js'></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
	</head>
	<style>
	.Em_Col_header01
	{
		background-color:#eeeeee;
		height:110px;
		border-bottom:1px solid #d9d8d8;
		text-align:center;
		font-weight:bold;
		color:#0c6780;
	}
	.Em_Col_header02
	{
		background-color:#e7e7e7;
		height:110px;
		border-bottom:1px solid #d9d8d8;
		text-align:center;
		font-weight:bold;
		color:#0c6780;
	}
	.Em_Cell
	{
		height:110px;
		border-bottom:1px solid #d9d8d8;
		border-right:1px solid #98b9c2;
	}
	.Em_Cell01
	{
		height:110px;
		border-bottom:1px solid #d9d8d8;
	}
	.Em_box
	{
	height:80px;
	background-color:#f4f9fa;
	border-radius:3px;
	margin:10px;
	padding:5px;
	}

	.Em_box_Select
	{
	height:80px;
	background-color:#98b9c2;
	border-radius:3px;
	margin:10px;
	padding:5px;
	}
	</style>
	<body class='CONTENT' onMouseDown="CodeArrest()" onKeyDown="lockKey()">
		<form name='TannerStagingForm' id='TannerStagingForm' method ='post' target='messageFrame' action='../../servlet/eCA.TannerStagingServlet'>
			<div class="Em_Body_container">
				<table width="100%" border="0" cellspacing="0" cellpadding="0">
					<tr>
						<td width="10%" align="left" valign="top">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td align="left" valign="middle" class="Em_header">Stages of puberty</td>
								</tr>
								<tr>
									<td align="left" valign="middle" class="Em_Col_header01">Stage 01</td>
								</tr>
								<tr>
									<td align="left" valign="middle" class="Em_Col_header02">Stage 02</td>
								</tr>
								<tr>
									<td align="left" valign="middle" class="Em_Col_header01">Stage 03</td>
								</tr>
								<tr>
									<td align="left" valign="middle" class="Em_Col_header02">Stage 04</td>
								</tr>
								<tr>
									<td align="left" valign="middle" class="Em_Col_header01">Stage 05</td>
								</tr>
							</table>
						</td>
						<td align="left" valign="top">
							<table width="100%" border="0" cellspacing="0" cellpadding="0">
								<tr>
									<td width="50%" align="left" valign="middle" class="Em_header"><fmt:message key="eCA.GenitalDevelopment.label" bundle="${ca_labels}"/></td>
									<td width="50%" align="left" valign="middle" class="Em_header"><fmt:message key="eCA.PubicHair.label" bundle="${ca_labels}"/></td>
								</tr>
								<tr>
									<td colspan="2" align="left" valign="top" class="Em_Cell">
										<div id="SP1" class="Em_box"  onClick="selectTannerStaging('SP','1');">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr class="Em_box_H">
													<td width="15%" align="center" valign="top" bgcolor="#f4f9fa">
														&nbsp;
													</td>
													<td width="38%" align="left" valign="top" class="Em_box_Dis">Pre-adolescent, testes, scrotum and penis are of about the same size and proportion as in early childhood.</td>
													<td width="44%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Pre-adolescent. The vellus over the pubes is not further developed than that over the abdominal wall, i.e. no pubic hair.</td>
													<td width="4%" align="center" id="SP10" valign="bottom">&nbsp;</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="left" valign="top" class="Em_Cell">
										<div id="SP2" class="Em_box" onClick="selectTannerStaging('SP','2');">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr class="Em_box_H" >
													<td width="14%" align="center" valign="top" bgcolor="#FFFFFF">
														<img src="../../eCA/images/B_H_Stage02.PNG" width="144" height="80" />
													</td>
													<td width="38%" align="left" valign="top" class="Em_box_Dis">Enlargement of scrotum and testes. Skin of scrotum reddens and changes in texture. Little or no enlargement of penis at this stage.</td>
													<td width="44%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Sparse growth of long, slightly pigmented downy hair, straight or slightly curled at the base of the penis.</td>
													<td width="4%" align="center" valign="bottom" id="SP20" >&nbsp;</td>
													</tr>
											</table>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="left" valign="top" class="Em_Cell">
										<div id="SP3" class="Em_box"  onClick="selectTannerStaging('SP','3');">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr class="Em_box_H">
													<td width="15%" align="center" valign="top" bgcolor="#FFFFFF">
														<img src="../../eCA/images/B_H_Stage03.PNG" width="144" height="80" />
													</td>
													<td width="38%" align="left" valign="top" class="Em_box_Dis">Enlargement of the penis which occurs at first mainly in length. Further growth of the testes and scrotum.</td>
													<td width="44%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Considerably darker, coarser and more curled. The hair spreads sparsely over the junction of the pubes.</td>
													<td width="4%" align="center" valign="bottom" id="SP30" >&nbsp;</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="left" valign="top" class="Em_Cell">
										<div id="SP4" class="Em_box"  onClick="selectTannerStaging('SP','4');">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr class="Em_box_H">
													<td width="15%" align="center" valign="top" bgcolor="#FFFFFF">
														<img src="../../eCA/images/B_H_Stage04.PNG" width="144" height="80" />
													</td>
													<td width="38%" align="left" valign="top" class="Em_box_Dis">Increased size of penis with growth in breadth and development of glans. Testes and scrotum larger, scrotal skin darkened.</td>
													<td width="44%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Hair now adult in type, but area covered is still considerably smaller than in the adult, No spread to the medial surface of thighs.</td>
													<td width="4%" align="center" valign="bottom" id="SP40" >&nbsp;</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
								<tr>
									<td colspan="2" align="left" valign="top" class="Em_Cell">
										<div id="SP5" class="Em_box"  onClick="selectTannerStaging('SP','5');">
											<table width="100%" border="0" cellspacing="0" cellpadding="0">
												<tr class="Em_box_H">
													<td width="15%" align="center" valign="top" bgcolor="#FFFFFF">
														<img src="../../eCA/images/B_H_Stage05.PNG" width="144" height="80" />
													</td>
													<td width="38%" align="left" valign="top" class="Em_box_Dis">Genitalia adult in size and shape.</td>
													<td width="44%" align="left" valign="top" class="Em_box_Dis EM_Leftborder">Adult in quantity and type with distribution of the horizontal (or classically feminine) pattern. Spread to medial surface of thighs but not up linea alba or elsewhere above the base of the inverse triangle (spread up linea alba occurs late and is rated stage 6).</td>
													<td width="4%" align="center" valign="bottom" id="SP50" >&nbsp;</td>
												</tr>
											</table>
										</div>
									</td>
								</tr>
							</table>
						</td>
					</tr>
				</table>
			</div>
			<input type="hidden" name="patientId" id="patientId" value="<%=patient_id%>"/>
			<input type="hidden" name="encounterId" id="encounterId" value="<%=encounter_id%>"/>
			<input type="hidden" name="recordedScoreYN" id="recordedScoreYN" value="<%=recordedScoreYN%>"/>
			<input type="hidden" name="stageOfPuberty" id="stageOfPuberty" value="<%=stageOfPuberty%>"/>
			<input type="hidden" name="pubicHair" id="pubicHair" value="<%=pubicHair%>"/>
			<input type="hidden" name="isAuditYN" id="isAuditYN" value="<%=isAuditYN%>"/><!--IN067402-->
			<SCRIPT>
			if('Y'=='<%=recordedScoreYN%>'){
				if('N'=='<%=isAuditYN%>'){//IN067402
					parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.record.disabled="disabled";
					parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.print.disabled="";
				}//IN067402
				//selectTannerStaging('SP','<%=stageOfPuberty%>','D');//commented for IN067402
				displayRecordedDetails('SP','<%=stageOfPuberty%>','D');//IN067402 Method name alone changed to block click method in audit trail
			}else{
				parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.record.disabled="";
				parent.TannerStagingButtonFrame.document.TannerStagingButtonForm.print.disabled="disabled";
			}
			</SCRIPT>
		</form>
	</body>
</html>

