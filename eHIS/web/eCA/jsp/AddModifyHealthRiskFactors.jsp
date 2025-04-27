<!-- 
--------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------
?             100            ?           	created
08/05/2013	  IN039490		Ramesh G 		Term Set->Select the 'Diagnosis Set'->Select the 'Diagnosis'->
											Now unselect the 'Diagnosis Set' ->System is not refreshing and on clicking 'Apply' button, Exception error is displayed.
08/05/2013	  IN039498		Ramesh G 		System is not filtering the 'Risk factor Type' and the 'Diagnosis Set' list values to single value, 
											since the system is not allowing the user to modify those fields.
--------------------------------------------------------------------------------------------------------
-->
<%@ page import ="webbeans.eCommon.*,java.sql.*,java.util.*,eCA.*,eCommon.Common.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<title></title>

<head>
	<%
	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
%>

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/common.js" 			language = "javascript" ></script>
	<script src="../../eCommon/js/ValidateControl.js" 	language = "javascript" ></script>	
	<Script src ="../../eCommon/js/CommonLookup.js" 	language = "JavaScript" ></Script>
	<script src="../../eCommon/js/dchk.js"				language = "javascript" ></script>
	<!--<script src="../../eCommon/js/CommonCalendar.js" 	language = "javascript" ></script>-->
	<script src="../../eCommon/js/DateUtils.js"			language = "javascript" ></script>
	<script src='../../eCA/js/HealthRiskFactors.js' 			language = 'javascript' ></script>
	<script src="../../ePH/js/DrugNameCommonLookup.js"	language = 'javascript' ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">

<form name= 'HealthRiskFactorsfrm' id= 'HealthRiskFactorsfrm' action="../../servlet/eCA.HealthRiskFactorsSetupServlet" method="post" target="messageFrame">
	<%
	Connection con				= null;
	ResultSet rs				= null;
	PreparedStatement pstmt		= null;
	
	String mode	   = request.getParameter( "mode" ) ;
	String toDate 			= "";
	String locale			= "";
	String systime 			= "";
	String operator_ind	 	= "";
	String fcator_ind		= "";
	String factor_set_id	= "";
	String factor_code		= "";
	String risk_factor_id	= "";
	String rfiReadOnlyYN	= "";
	String risk_fact_desc	= "";
	String rfdDisabled		= "";
	String factor_type 		= "";
	String rftReadOnlyYN	= "";
	String eff_status		= "E";
	String enabled_checked	= "checked";
	String rowId			= "0";
	
	
	String ageGroup_id		= "";
	String agrfi			= "";
	String ageRemarks		= "";
	
	String allergenId		= "";
	String allergenRFIId	= "";
	String allergenRemarks	= "";
	String allergenStaus	= "";
	
	String chiefComplaintId			= "";
	String chiefComplaintRFIId		= "";
	String chiefComplaintRemarks	= "";
	
	String drugId			="";
	String pharmacyRFIId	= "";
	String pharmacyRemarks	= "";
	String pharmacyOperator	= "";
	
	String diagnosisSetId 	= "";
	String termSetCode		= "";
	String termSetOperator	= "";
	String termSetRFIId		= "";
	String termSetRemarks	= "";	
	
	String discreateMeaserId = "";
	
	ArrayList gridDtls = new ArrayList();
	String discreateUOM		 = "";
	try{
		
		java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;
		locale 	= (String) p.getProperty("LOCALE");
		toDate 	= com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
		systime	= com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
		
		if("update".equals(mode)){
			rfiReadOnlyYN		= "ReadOnly";
			rfdDisabled 		= "disabled";
			rftReadOnlyYN		= "disabled='disabled'";
			risk_factor_id = request.getParameter("risk_factor_id")==null?"":(String)request.getParameter("risk_factor_id");
			HealthRiskFactorsBean bean = new HealthRiskFactorsBean();
			bean.getHealthRiskFactorsDeatils(risk_factor_id);
			
			factor_type			= (String)bean.getFactorType();
			risk_fact_desc		= (String)bean.getRiskFactorDesc();		
			eff_status			= (String)bean.getEffStatus();
			if("E".equals(eff_status))
				enabled_checked = "checked";
			else
				enabled_checked = "";
			
			if("AG".equals(factor_type)){
				ageGroup_id				= (bean.getAgeGroupId())==null?"":(String)bean.getAgeGroupId();
				agrfi					= (bean.getAgrfi())==null?"":(String)bean.getAgrfi();
				ageRemarks				= (bean.getAgRemarks())==null?"":(String)bean.getAgRemarks();
			}else if("AL".equals(factor_type)){
				allergenId				= (bean.getAllergenId())==null?"":(String)bean.getAllergenId();
				allergenRFIId			= (bean.getAllergenRFIId())==null?"":(String)bean.getAllergenRFIId();
				allergenRemarks			= (bean.getAllergenRemarks())==null?"":(String)bean.getAllergenRemarks();
				allergenStaus			= (bean.getAllergenStaus())==null?"":(String)bean.getAllergenStaus();
			}else if("CC".equals(factor_type)){
				chiefComplaintId		= (bean.getChiefComplaintId())==null?"":(String)bean.getChiefComplaintId();
				chiefComplaintRFIId		= (bean.getChiefComplaintRFIId())==null?"":(String)bean.getChiefComplaintRFIId();
				chiefComplaintRemarks	= (bean.getChiefComplaintRemarks())==null?"":(String)bean.getChiefComplaintRemarks();
			}else if("PH".equals(factor_type)){
				fcator_ind				= (bean.getRiskFactorInd())==null?"":(String)bean.getRiskFactorInd();
				factor_set_id			= (bean.getRiskFactorSetId())==null?"":(String)bean.getRiskFactorSetId();
				factor_code				= (bean.getRiskFactorCode())==null?"":(String)bean.getRiskFactorCode();
				
				drugId					= (bean.getDrugId())==null?"":(String)bean.getDrugId();
				pharmacyRFIId			= (bean.getPharmacyRFIId())==null?"":(String)bean.getPharmacyRFIId();
				pharmacyRemarks			= (bean.getPharmacyRemarks())==null?"":(String)bean.getPharmacyRemarks();
				pharmacyOperator		= (bean.getPharmacyOperator())==null?"":(String)bean.getPharmacyOperator();	
				
			}else if("TS".equals(factor_type)){
				fcator_ind				= (bean.getRiskFactorInd())==null?"":(String)bean.getRiskFactorInd();
				factor_set_id			= (bean.getRiskFactorSetId())==null?"":(String)bean.getRiskFactorSetId();
				factor_code				= (bean.getRiskFactorCode())==null?"":(String)bean.getRiskFactorCode();
				
				diagnosisSetId 			= (bean.getDiagnosisSetId())==null?"":(String)bean.getDiagnosisSetId();
				termSetCode				= (bean.getTermSetCode())==null?"":(String)bean.getTermSetCode();
				termSetOperator			= (bean.getTermSetOperator())==null?"":(String)bean.getTermSetOperator();
				termSetRFIId			= (bean.getTermSetRFIId())==null?"":(String)bean.getTermSetRFIId();
				termSetRemarks			= (bean.getTermSetRemarks())==null?"":(String)bean.getTermSetRemarks();	
				
			}else if("CA".equals(factor_type) || "LB".equals(factor_type) || "OR".equals(factor_type) || "RD".equals(factor_type) || "BM".equals(factor_type) ){
				fcator_ind				= (bean.getRiskFactorInd())==null?"":(String)bean.getRiskFactorInd();
				factor_set_id			= (bean.getRiskFactorSetId())==null?"":(String)bean.getRiskFactorSetId();
				factor_code				= (bean.getRiskFactorCode())==null?"":(String)bean.getRiskFactorCode();
				
				discreateMeaserId		= (bean.getDiscreateMeaserId())==null?"":(String)bean.getDiscreateMeaserId();
				operator_ind			= (bean.getDiscreateMeaserType())==null?"":(String)bean.getDiscreateMeaserType();
				gridDtls  				= (ArrayList)bean.getGridDtls();
				rowId					= ((gridDtls.size())-1)+"";
			}
		}
		//HealthRiskIndicatorBean indiBean = new HealthRiskIndicatorBean();
		//ArrayList indicatorList = indiBean.getRiskIndicatorCode();
	}catch(Exception e){
			e.printStackTrace(System.err);
	}
	%>
	<table align=center width = '95%'>
	<BR><BR><BR>
		<tr>
			<td align=center>
				<table  width = '70%'>
					<tr>	
						<td  class=label width = '30%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>			
						<td width = '70%'><input type='text' name='risk_factor_id' id='risk_factor_id' size="4" maxLength="4"  onkeypress="return CheckForSpecChars(event)"  onBlur="ChangeUpperCase(this)" value="<%=risk_factor_id%>" <%=rfiReadOnlyYN%>  >
							<img src='../../eCommon/images/mandatory.gif'>
						</td>			
					</tr>
					<tr>		
						<td  class=label width = '30%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>			
						<td width = '70%'><input type='text' name='risk_fact_desc' id='risk_fact_desc' size="30" maxLength="30" value="<%=risk_fact_desc%>" onBlur="makeValidString(this)" onkeypress='return CheckForSpecCharsNoCaps(event)'>
							<img src='../../eCommon/images/mandatory.gif'>
						</td>  
							
					</tr>
					<tr>
						<td  class=label width = '30%'><fmt:message key="eCA.RiskFactorType.label" bundle="${ca_labels}"/></td>			
						<td width = '70%'>
							<!-- [IN039498] Start. -->
							<!-- <select name="factor_type" id="factor_type" onchange = "selectFactoryType();" style='display:none'> -->
							<select name="factor_type" id="factor_type" onchange = "selectFactoryType();" <%if("update".equals(mode)){%> style='display:none' <%}else{%>style="width:160px;display;"<%}%>>
							<!-- [IN039498] End. -->
								<option value=""	<%=rftReadOnlyYN%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option  value="AG" <%=rftReadOnlyYN%>>Age Group</option>
								<option  value="AL"	<%=rftReadOnlyYN%>>Allergy</option>
								<option  value="BM"	<%=rftReadOnlyYN%>>BMI</option>
								<option  value="CC" <%=rftReadOnlyYN%>>Chief Complaint</option>
								<option  value="CA" <%=rftReadOnlyYN%>>Discrete Measure</option>
								<option  value="LB" <%=rftReadOnlyYN%>>Lab Results</option>
								<option  value="OR"	<%=rftReadOnlyYN%>>Order Catalog</option>
								<option  value="PH" <%=rftReadOnlyYN%>>Pharmacy Items</option>
								<option  value="RD" <%=rftReadOnlyYN%>>Radiology</option>
								<option  value="TS" <%=rftReadOnlyYN%>>Term Set</option>
							</select>
							<input type="text" name="factor_type_txt" id="factor_type_txt" size="30" maxLength="30" readonly value="" <%if("update".equals(mode)){%> style='display' <%}else{%>style='display:none'<%}%>/>  <!-- IN039498 -->
							<img src='../../eCommon/images/mandatory.gif'>
						</td>			
					</tr>
					<tr>		
						<td class=label width = '30%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
						<td class='fields'  width = '70%'><input type="checkbox" name="effstatus" id="effstatus"  <%=enabled_checked%> onclick="setEffStauts(this);"></td>			
					</tr>
					
				<!-- Age Group Start -->
					<tr id="ageGroup_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.AgeGrp.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'><select name="ageGroup_id" id="ageGroup_id" onchange = "" style="width:160px;">
											<option  value="" disabled>    --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>																
										</select>
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.RiskFactorIndicator.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<table width="30%" border="0">
											<tr>
												<td width="15%">High</td>
												<td width="10%"><input type="radio" name="AGRFI" id="AGRFI" value="H" checked /></td>
												<td width="5%">&nbsp;</td>
												<td width="25%">Average</td>
												<td width="10%"><input type="radio" name="AGRFI" id="AGRFI" value="A"/></td>
												<td width="5%">&nbsp;</td>
												<td width="15%">Low</td>
												<td width="10%"><input type="radio" name="AGRFI" id="AGRFI" value="L"/></td>
											</tr>
											<input type="hidden" name="agrfiID" id="agrfiID" value=""/>
										</table>
									</td>	
								</tr>
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<input type="text" name="agRemarks" id="agRemarks" size="50" maxLength="100" value="<%=ageRemarks%>" />
									</td>
								</tr>					
							</table>
						</td>			
					</tr>
					
				<!-- Age Group End -->		
				<!-- Allergy Start -->
					<tr id="allergy_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.AdverseEventType.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<select name="adverse_event_id" id="adverse_event_id" onchange = "populateData('AL_A',this.value)" style="width:160px;">
											<option value="">    --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
											<!--<option  value="1">Test1</option> -->
																		
										</select>
										<img src='../../eCommon/images/mandatory.gif'>
									</td>
								</tr>
								<tr>
									<td width = '30%'class=label ><fmt:message key="eCA.Allergen.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<select name="allergen_id" id="allergen_id"  style="width:160px;">
											<option value="">    --- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
											<!--<option  value="1">Test1</option>-->
											
										</select>
										<img src='../../eCommon/images/mandatory.gif'>
									</td>		
								</tr>
								<tr>
									<td width = '30%'class=label ><fmt:message key="eCA.Status.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<select id="allergenStaus" name="allergenStaus" id="allergenStaus"  style="width:160px;">
											<option  value="AL" >All</option>
											<option  value="AC" selected >Active</option>							
																		
										</select>
									</td>
								</tr>
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.RiskFactorIndicator.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<table width="30%" border="0">
											<tr>
												<td width="15%">High</td>
												<td width="10%"><input type="radio" name="ALRFI" id="ALRFI" value="H" checked /></td>
												<td width="5%">&nbsp;</td>
												<td width="25%">Average</td>
												<td width="10%"><input type="radio" name="ALRFI" id="ALRFI" value="A"/></td>
												<td width="5%">&nbsp;</td>
												<td width="15%">Low</td>
												<td width="10%"><input type="radio" name="ALRFI" id="ALRFI" value="L"/></td>
											</tr>
											<input type="hidden" name="allergenRFIId" id="allergenRFIId" value=""/>
										</table>
									</td>	
								</tr>
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<input type="text" size="50" maxLength="100" name="allergenRemarks" id="allergenRemarks" value="<%=allergenRemarks%>" />
									</td>
								</tr>	
							</table>
						</td>			
					</tr>
				<!-- Allergy End -->

				<!-- BMI Start -->
					<tr id="bmi_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">
								<!--<tr>
									<td  class=label width = '30%'>BMI</td>			
									<td width = '70%'><select name="" id="" onchange = "" style="width:160px;">
											<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
											<option  value="UW">Underweight</option>
											<option  value="OW">Overweight</option>
											<option  value="OB">Obese</option>								
										</select>
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>-->
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.Weight.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<input type="text" name="weight_desc" id="weight_desc" size="50" maxlength="50" value=""  <%if("insert".equals(mode)){%> onBlur="if(this.value !='')getWeightDiscreateId(weight_desc)" <%}else{%> readonly <%}%>  >
										<input type='hidden'  name='weight_id' id='weight_id' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='getWeightDiscreateId(weight_desc)' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>
								</tr>
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.Height.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<input type="text" name="height_desc" id="height_desc" size="50" maxlength="50" value=""  <%if("insert".equals(mode)){%> onBlur="if(this.value !='')getHeightDiscreateId(height_desc)" <%}else{%> readonly <%}%> >
										<input type='hidden'  name='height_id' id='height_id' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='getHeightDiscreateId(height_desc)' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>
								</tr>								
							</table>
						</td>			
					</tr>
				<!-- BMI End -->	

				<!-- Chief Complaint Start -->
					<tr id="chiefComplaint_" style='display:none'>	 	
						<td colspan="2" >
							<table width="100%">
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.ChiefComplaint.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<input type='text' name='complaint_desc' id='complaint_desc' size='50' maxlength='50'   <%if("insert".equals(mode)){%> OnBlur ='getViewCode(this)' <%}else{%> readonly <%}%>   value="" ></input>
										<input type='hidden' name='complaint_id' id='complaint_id' value=''/>
										<input type='button' name='ComplaintSrch' id='ComplaintSrch' value='?' <%if("update".equals(mode)){%>disabled<%}%> OnClick='getViewCode(this);' class='button' />
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>					
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.RiskFactorIndicator.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<table width="30%" border="0">
											<tr>
												<td width="15%">High</td>
												<td width="10%"><input type="radio" name="CCRFI" id="CCRFI" value="H" checked /></td>
												<td width="5%">&nbsp;</td>
												<td width="25%">Average</td>
												<td width="10%"><input type="radio" name="CCRFI" id="CCRFI" value="A"/></td>
												<td width="5%">&nbsp;</td>
												<td width="15%">Low</td>
												<td width="10%"><input type="radio" name="CCRFI" id="CCRFI" value="L"/></td>
												<input type="hidden" name="chiefComplaintRFIId" id="chiefComplaintRFIId" value=""/>
											</tr>
										</table>
									</td>	
								</tr>
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<input type="text" size="50" maxLength="100" name="chiefComplaintRemarks" id="chiefComplaintRemarks" value="<%=chiefComplaintRemarks%>" />
									</td>
								</tr>
							</table>
						</td>			
					</tr>
				<!-- Chief Complaint End -->	

				<!-- Discrete Measure Start -->
					<tr id="discreteMeasure_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">								
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.DiscreteMeasure.label" bundle="${ca_labels}"/></td>			
									<td width = '40%' nowrap>
										<input type="text" name="discreate_desc" id="discreate_desc" size="50" maxlength="50" value="" <%if("insert".equals(mode)){%>  onBlur="if(this.value !='')getDiscreateId(discreate_desc)" <%}else{%> readonly <%}%> >
										<input type='hidden'  name='discreate_id' id='discreate_id' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='getDiscreateId(discreate_desc)' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
									<td id="dmType" class=label width = '30%' nowrap>&nbsp;
									</td>									
								</tr>					
							</table>
						</td>			
					</tr>
					
				<!-- Discrete Measure End -->

				<!-- Lab Results Start -->
					<tr id="labResult_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">					
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.LabResults.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<input type="text" name="lbCatalog_desc" id="lbCatalog_desc" size="50" maxlength="50" value="" <%if("insert".equals(mode)){%> onBlur="if(this.value !='')getLBCatalogId(lbCatalog_desc)" <%}else{%> readonly <%}%>>
										<input type='hidden'  name='lbCatalog_id' id='lbCatalog_id' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='getLBCatalogId(lbCatalog_desc)' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>
								
							</table>
						</td>			
					</tr>
				<!-- Lab Result End -->	

				<!-- Order Catalog Start -->
					<tr id="orderCatalog_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">					
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.OrderCatalog.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<input type="text" name="oRCatalog_desc" id="oRCatalog_desc" size="50" maxlength="50" value="" <%if("insert".equals(mode)){%> onBlur="if(this.value !='')getOrderCatalogId(oRCatalog_desc)" <%}else{%> readonly <%}%>>
										<input type='hidden'  name='oRCatalog_id' id='oRCatalog_id' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='getOrderCatalogId(oRCatalog_desc)' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>					
							</table>
						</td>			
					</tr>
				<!-- Order Catalog End -->	

				<!-- Pharmacy Items Start -->
				<tr id="pharmacyItems_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">					
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.DrugName.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>										
										<input type="text" name="drug_name" id="drug_name" size="50" maxlength="50" value="" <%if("insert".equals(mode)){%> onBlur="if(this.value !='')searchForDrug(drug_name)" <%}else{%> readonly <%}%>>
										<input type='hidden'  name='drug_id' id='drug_id' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='searchForDrug(drug_name)' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>
								<tr>
									<td width = '30%'class=label ><fmt:message key="eCA.Status.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<select name="pharmacyOperator" id="pharmacyOperator"  style="width:160px;">
											<option  value="AL" >All</option>
											<option  value="AC" selected>Active</option>								
											<option  value="CL" >Closed</option>							
										</select>
										<img src='../../eCommon/images/mandatory.gif'>
									</td>
								</tr>
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.RiskFactorIndicator.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<table width="30%" border="0">
											<tr>
												<td width="15%">High</td>
												<td width="10%"><input type="radio" name="PHRFIId" id="PHRFIId" value="H" checked /></td>
												<td width="5%">&nbsp;</td>
												<td width="25%">Average</td>
												<td width="10%"><input type="radio" name="PHRFIId" id="PHRFIId" value="A"/></td>
												<td width="5%">&nbsp;</td>
												<td width="15%">Low</td>
												<td width="10%"><input type="radio" name="PHRFIId" id="PHRFIId" value="L"/></td>
												<input type="hidden" name="pharmacyRFIId" id="pharmacyRFIId" value=""/>
											</tr>
										</table>
									</td>	
								</tr>
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<input type="text" size="50" maxLength="100" name="pharmacyRemarks" id="pharmacyRemarks" value="<%=pharmacyRemarks%>" />
									</td>
								</tr>
							</table>
						</td>			
					</tr>
				<!-- Pharmacy Items End -->	

				<!-- Radiology Start -->
				<tr id="radiology_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">					
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.Radiology.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<input type="text" name="rDCatalog_desc" id="rDCatalog_desc" size="50" maxlength="50" value="" <%if("insert".equals(mode)){%> onBlur="if(this.value !='')getRDCatalogId(rDCatalog_desc)" <%}else{%> readonly <%}%>>
										<input type='hidden'  name='rDCatalog_id' id='rDCatalog_id' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='getRDCatalogId(rDCatalog_desc)' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>					
							</table>
						</td>			
					</tr>	
				<!-- Radiology End -->	

				<!-- Term Set Start -->
					<tr id="termSet_" style='display:none'>		
						<td colspan="2" >
							<table width="100%">
								<tr>
									<td width = '30%'class=label ><fmt:message key="eMR.DiagnosisSet.label" bundle="${mr_labels}"/></td>
									<td width = '70%'>
										<!-- [IN039490] Start-->
										<!-- <select name="diagnosisSet_code" id="diagnosisSet_code"  style="width:160px;"> -->
										<select name="diagnosisSet_code" id="diagnosisSet_code"  style="width:160px;" onChange="clearTermSetDtl();">
										<!-- [IN039490] End.-->
											<%if(diagnosisSetId=="" && diagnosisSetId.equals("")){%> <!-- [IN039498]-->
											<option value=''>----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> -----</option>
											<%}%> <!-- [IN039498]-->
											<%
												try{
													con = ConnectionManager.getConnection(request);
													//[IN039498] Start.
													String temSetQuery ="";
													if(diagnosisSetId!="" && !diagnosisSetId.equals("")){
														temSetQuery="WHERE TERM_SET_ID='"+diagnosisSetId+"'";
													}
													//pstmt = con.prepareStatement("SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET ORDER BY TERM_SET_DESC");
													pstmt = con.prepareStatement("SELECT TERM_SET_ID,TERM_SET_DESC FROM MR_TERM_SET "+temSetQuery+" ORDER BY TERM_SET_DESC");
													//[IN039498] End.
													rs = pstmt.executeQuery();
													while(rs.next())
													{
														String code = rs.getString("term_set_id");
														String desc = rs.getString("term_set_desc");
														out.print("<option value='"+code+"' "+rftReadOnlyYN+">"+desc+"</option>");
														code = null;
														desc = null;
													}
												}catch(Exception e){
												
												}finally{
													if(pstmt!=null)pstmt.close();
													if(rs!=null)rs.close();
													if(con!=null)con.close();
												}
												
											%>
										</select>
									</td>
								</tr>
								<tr>
									<!--<td  class=label width = '30%'><fmt:message key="eCA.TermSet.label" bundle="${ca_labels}"/></td> -->
									<td  class=label width = '30%'><fmt:message key="Common.diagnosis.label" bundle="${common_labels}"/></td>									
									<td width = '70%'>
										<input type="text" name="termSet_desc" id="termSet_desc" size="50" maxlength="50" value="" readonly>
										<input type='hidden'  name='termSet_code' id='termSet_code' value="" />
										<input type='button' name='id' id='id' value='?'  class='button' <%if("update".equals(mode)){%>disabled<%}%> onClick='show_diagnosis()' >
										<img src='../../eCommon/images/mandatory.gif'>
									</td>	
								</tr>
								<tr>
									<td width = '30%'class=label ><fmt:message key="eCA.Status.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<select name="termSetOperator" id="termSetOperator"  style="width:160px;">
											<option  value="AL" >All</option>
											<option  value="AC" selected >Active</option>								
											<option  value="CL" >Closed</option>							
										</select>
									</td>
								</tr>
								<tr>
									<td  class=label width = '30%'><fmt:message key="eCA.RiskFactorIndicator.label" bundle="${ca_labels}"/></td>			
									<td width = '70%'>
										<table width="30%" border="0">
											<tr>
												<td width="15%">High</td>
												<td width="10%"><input type="radio" name="TSRFI" id="TSRFI" value="H" checked /></td>
												<td width="5%">&nbsp;</td>
												<td width="25%">Average</td>
												<td width="10%"><input type="radio" name="TSRFI" id="TSRFI" value="A"/></td>
												<td width="5%">&nbsp;</td>
												<td width="15%">Low</td>
												<td width="10%"><input type="radio" name="TSRFI" id="TSRFI" value="L"/></td>
												<input type="hidden" name="termSetRFIId" id="termSetRFIId" value=""/>
											</tr>
										</table>
									</td>	
								</tr>
								<tr>
									<td width = '30%' class=label ><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></td>
									<td width = '70%'>
										<input type="text" size="50" name="termSetRemarks" id="termSetRemarks" maxLength="100" value="<%=termSetRemarks%>" />
									</td>
								</tr>
							</table>
						</td>			
					</tr>
				<!-- Term Set End -->
				</table>
			</td>
		</tr>
				
		
		<tr>		
			<td>&nbsp;</td>			
		</tr>
		<tr id="displayGrid_" style='display:none'>		
			<td align="center">
			<DIV style="width:100vw;height:75vh;overflow:auto">
				<table cellpadding='3' id="CADisplayGrid" name = 'CADisplayGrid' cellspacing='0' border='0' width="100%">
					<tr>
						<th class='columnHeadercenter' width="100%" colspan="13"><fmt:message key="eCA.RuleforRiskFactor.label" bundle="${ca_labels}"/></th>
					</tr>
					<tr>						
						<th class='columnHeadercenter' width="7%">&nbsp;</th>
						<th class='columnHeadercenter' width="5%">&nbsp;</th>
						<th class='columnHeadercenter' width="5%">&nbsp;</th>
						<th class='columnHeadercenter' width="10%" colspan="2"><fmt:message key="eCA.Start.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="10%" colspan="2"><fmt:message key="eCA.End.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="70%" colspan="6">&nbsp;</th>						
					</tr>
					<tr>
						<th class='columnHeadercenter' width="7%">
							<input type="button" value="-" onClick="deleteRowDisplayGrid('CADisplayGrid')"/>&nbsp;
							<input type="button" value="+" onClick="addRowCADisplayGrid('CADisplayGrid','ADD')"/>
						</th>
						<th class='columnHeadercenter' width="5%">Gender</th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.AllAges.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.Age.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.Units.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.Age.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.Units.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="10%"><fmt:message key="eCA.Operator.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="28%"><fmt:message key="Common.Value.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.High.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.Average.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="5%"><fmt:message key="eCA.Low.label" bundle="${ca_labels}"/></th>
						<th class='columnHeadercenter' width="10%"><fmt:message key="eCA.Remarks.label" bundle="${ca_labels}"/></th>
					</tr>
					
				<table>
			</DIV>
			</td>			
		</tr>
		
	</table>
	<input type="hidden" name="mode" id="mode" value="<%=mode%>"/>
	<input type="hidden" name="patientSex" id="patientSex" value=""/>
	<input type="hidden" name="factor_type_" id="factor_type_" value="<%=factor_type%>">
	<input type="hidden" name="ageGroup_id_" id="ageGroup_id_" value="<%=ageGroup_id%>">
	<input type="hidden" name="allergen_id_" id="allergen_id_" value="<%=allergenId%>">
	<input type="hidden" name="diagnosisSet_code_" id="diagnosisSet_code_" value="<%=diagnosisSetId%>">
	<input type="hidden" name="eff_status" id="eff_status" value="<%=eff_status%>"/>
	<input type="hidden" name="rowId" id="rowId" value="<%=rowId%>"/>
	<input type="hidden" name="operator_ind" id="operator_ind" value="<%=operator_ind%>"/>
	<input type="hidden" name="discreateUOM" id="discreateUOM" value="<%=discreateUOM%>"/>
	<input type="hidden" name="factor_set_id" id="factor_set_id" value="<%=factor_set_id%>"/>
	<input type="hidden" name="factor_code" id="factor_code" value="<%=factor_code%>"/>
	<input type="hidden" name="locale" id="locale" value="<%=locale%>"/>
	
	<script>
	if("AG"=="<%=factor_type%>"){	
		document.getElementById("ageGroup_").style='display';			
		document.HealthRiskFactorsfrm.factor_type.value="AG";
		document.HealthRiskFactorsfrm.factor_type_txt.value="Age Group"; //[IN039498]
		populateData("AG","<%=ageGroup_id%>","<%=mode%>");			
		var agradioButtons=document.getElementsByName("AGRFI");					
		for(var i=0;i<agradioButtons.length;i++){						
			if(agradioButtons[i].value=="<%=agrfi%>"){
				agradioButtons[i].checked=true;
			}
		}
	}else if("AL"=="<%=factor_type%>"){
		document.getElementById("allergy_").style='display';
		document.HealthRiskFactorsfrm.factor_type.value="AL";
		document.HealthRiskFactorsfrm.factor_type_txt.value="Allergy"; //[IN039498]
		document.HealthRiskFactorsfrm.allergenStaus.value="<%=allergenStaus%>";
		populateData("AL_Query","<%=allergenId%>","<%=mode%>");
		var agradioButtons=document.getElementsByName("ALRFI");					
		for(var i=0;i<agradioButtons.length;i++){						
			if(agradioButtons[i].value=="<%=allergenRFIId%>"){
				agradioButtons[i].checked=true;
			}
		}
	}else if("CC"=="<%=factor_type%>"){
		document.getElementById("chiefComplaint_").style='display';
		document.HealthRiskFactorsfrm.factor_type.value="CC";
		document.HealthRiskFactorsfrm.factor_type_txt.value="Chief Complaint"; //[IN039498]
		populateData("CC","<%=chiefComplaintId%>","<%=mode%>");
		var agradioButtons=document.getElementsByName("CCRFI");					
		for(var i=0;i<agradioButtons.length;i++){						
			if(agradioButtons[i].value=="<%=chiefComplaintRFIId%>"){
				agradioButtons[i].checked=true;
			}
		}
	}else if("PH"=="<%=factor_type%>"){
		document.HealthRiskFactorsfrm.factor_type_txt.value="Pharmacy Items"; //[IN039498]
		document.getElementById("pharmacyItems_").style='display';
		document.HealthRiskFactorsfrm.factor_type.value="<%=factor_type%>";
		document.HealthRiskFactorsfrm.factor_set_id.value="<%=factor_set_id%>";
		document.HealthRiskFactorsfrm.factor_code.value="<%=factor_code%>";
		
		populateData("PH","<%=drugId%>","<%=mode%>");
		
		var agradioButtons=document.getElementsByName("PHRFIId");					
		for(var i=0;i<agradioButtons.length;i++){						
			if(agradioButtons[i].value=="<%=pharmacyRFIId%>"){
				agradioButtons[i].checked=true;
			}
		}
		document.HealthRiskFactorsfrm.pharmacyOperator.value="<%=pharmacyOperator%>";

	}else if("TS"=="<%=factor_type%>"){
		document.HealthRiskFactorsfrm.factor_type_txt.value="Term Set"; //[IN039498]
		document.getElementById("termSet_").style='display';
		document.HealthRiskFactorsfrm.factor_type.value="<%=factor_type%>";
		document.HealthRiskFactorsfrm.factor_set_id.value="<%=factor_set_id%>";
		document.HealthRiskFactorsfrm.factor_code.value="<%=factor_code%>";
		
		document.HealthRiskFactorsfrm.diagnosisSet_code.value="<%=diagnosisSetId%>";		
		
		populateData("TS","<%=termSetCode%>","<%=mode%>","<%=diagnosisSetId%>");
		
		var agradioButtons=document.getElementsByName("TSRFI");					
		for(var i=0;i<agradioButtons.length;i++){						
			if(agradioButtons[i].value=="<%=termSetRFIId%>"){
				agradioButtons[i].checked=true;
			}
		}
		document.HealthRiskFactorsfrm.termSetOperator.value="<%=termSetOperator%>";

	}else if("CA"=="<%=factor_type%>" || "LB"=="<%=factor_type%>" || "OR"=="<%=factor_type%>" || "RD"=="<%=factor_type%>" || "BM"=="<%=factor_type%>" ){		
		document.getElementById("displayGrid_").style='display';			
		document.HealthRiskFactorsfrm.factor_type.value="<%=factor_type%>";
		document.HealthRiskFactorsfrm.factor_set_id.value="<%=factor_set_id%>";
		document.HealthRiskFactorsfrm.factor_code.value="<%=factor_code%>";
		if("CA"=="<%=factor_type%>"){
			document.HealthRiskFactorsfrm.factor_type_txt.value="Discrete Measure"; //[IN039498]
			document.getElementById("discreteMeasure_").style='display';
			populateData("CA_DMS","<%=discreateMeaserId%>","<%=mode%>");
		}else if("LB"=="<%=factor_type%>"){
			document.HealthRiskFactorsfrm.factor_type_txt.value="Lab Results"; //[IN039498]
			document.getElementById("labResult_").style='display';
			populateData("LB_OCC","<%=factor_code%>","<%=mode%>");
		}else if("OR"=="<%=factor_type%>"){
			document.HealthRiskFactorsfrm.factor_type_txt.value="Order Catalog"; //[IN039498]
			document.getElementById("orderCatalog_").style='display';
			populateData("OR_OCC","<%=factor_code%>","<%=mode%>");
		}else if("RD"=="<%=factor_type%>"){
			document.HealthRiskFactorsfrm.factor_type_txt.value="Radiology"; //[IN039498]
			document.getElementById("radiology_").style='display';
			populateData("RD_OCC","<%=factor_code%>","<%=mode%>");
		}
		else if("BM"=="<%=factor_type%>"){
			document.HealthRiskFactorsfrm.factor_type_txt.value="BMI"; //[IN039498]
			document.getElementById("bmi_").style='display';
			populateData("BM","<%=factor_set_id%>","<%=mode%>","WEIGHT");
			populateData("BM","<%=factor_code%>","<%=mode%>","HEIGHT");
		}
		<%
			for(int i=0;i<gridDtls.size();i++){
				HashMap gridHash=new HashMap();
				gridHash = (HashMap)gridDtls.get(i);
				
				String gender				= (gridHash.get("PATIENT_SEX"))==null?"":(String)gridHash.get("PATIENT_SEX");
				String allAges				= (gridHash.get("ALL_AGE_YN"))==null?"":(String)gridHash.get("ALL_AGE_YN");
				String starAge				= (gridHash.get("START_AGE"))==null?"":(String)gridHash.get("START_AGE");
				String starAgeUnit			= (gridHash.get("START_AGE_UNITS"))==null?"":(String)gridHash.get("START_AGE_UNITS");
				String endAge				= (gridHash.get("END_AGE"))==null?"":(String)gridHash.get("END_AGE");
				String endAgeUnit			= (gridHash.get("END_AGE_UNITS"))==null?"":(String)gridHash.get("END_AGE_UNITS");
				String operator				= (gridHash.get("RISK_FACTOR_OPERATOR"))==null?"":(String)gridHash.get("RISK_FACTOR_OPERATOR");
				String operatorFromValue	= (gridHash.get("RISK_FACTOR_FRM_VAL"))==null?"":(String)gridHash.get("RISK_FACTOR_FRM_VAL");
				String operatorToValue		= (gridHash.get("RISK_FACTOR_TO_VAL"))==null?"":(String)gridHash.get("RISK_FACTOR_TO_VAL");
				String riskFactorInd		= (gridHash.get("RISK_FACTOR_SCORE_IND"))==null?"":(String)gridHash.get("RISK_FACTOR_SCORE_IND");
				String remarks				= (gridHash.get("RISK_FACTOR_MESG"))==null?"":(String)gridHash.get("RISK_FACTOR_MESG");
				String operatorFromUnit		= (gridHash.get("RISK_FACTOR_FRM_UNIT"))==null?"":(String)gridHash.get("RISK_FACTOR_FRM_UNIT");
				String operatorToUnit		= (gridHash.get("RISK_FACTOR_TO_UNIT"))==null?"":(String)gridHash.get("RISK_FACTOR_TO_UNIT");
				String riskFactorOccur		= (gridHash.get("RISK_FACTOR_OCCUR"))==null?"":(String)gridHash.get("RISK_FACTOR_OCCUR");		
		%>		
			addRowCADisplayGrid("CADisplayGrid","UPDATE",<%=i%>);
			document.getElementById("gender"+<%=i%>).value = "<%=gender%>"; 
			
			if("Y"=="<%=allAges%>"){
				document.getElementById("allAge"+<%=i%>).checked = true;
			}else{
				document.getElementById("allAge"+<%=i%>).checked = false;
			}
			clickAllAge(document.getElementById("allAge"+<%=i%>),<%=i%>);
			document.getElementById("startAge"+<%=i%>).value = "<%=starAge%>";
			document.getElementById("startAgeUnit"+<%=i%>).value = "<%=starAgeUnit%>";
			document.getElementById("endAge"+<%=i%>).value = "<%=endAge%>";
			document.getElementById("endAgeUnit"+<%=i%>).value = "<%=endAgeUnit%>";
			document.getElementById("operator"+<%=i%>).value = "<%=operator%>";
			operatorChage(document.getElementById("operator"+<%=i%>),<%=i%>);			
			document.getElementById("operatorFromValue"+<%=i%>).value = "<%=operatorFromValue%>";
			if("B"=="<%=operator%>"){
				document.getElementById("operatorToValue"+<%=i%>).value = "<%=operatorToValue%>";
			}
			if("PV"=="<%=operator%>"){
				document.getElementById("operatorIncreDecre"+<%=i%>).value = "<%=operatorFromUnit%>";
				document.getElementById("operatorOccur"+<%=i%>).value = "<%=riskFactorOccur%>";
			}
			var agradioButtons=eval('document.HealthRiskFactorsfrm.riskFactorInd'+<%=i%>);
			for(var i=0;i<agradioButtons.length;i++){						
				if(agradioButtons[i].value=="<%=riskFactorInd%>")
					agradioButtons[i].checked=true;
			}
			document.getElementById("riskFactorIndValue"+<%=i%>).value="<%=riskFactorInd%>";
			document.getElementById("remarks"+<%=i%>).value = "<%=remarks%>";
		<%}%>	
	}
	</script>
</form>
</body>
</html>

