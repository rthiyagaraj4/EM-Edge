<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
25/04/2016	IN067051     Devindra							                Enhance TPN Ordering Functionality
--------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- saved 0n 24/10/2005 --%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, eOR.*, ePH.Common.* ,eOR.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<HTML>
<HEAD>
	<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	//Added by Himanshu for MMS-ME-SCF-0097 Starts 
	request= new XSSRequestWrapper(request); 
	response.addHeader("X-XSS-Protection", "1; mode=block"); 
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//Added by Himanshu for MMS-ME-SCF-0097 ends
	String locale = (String) session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
	<SCRIPT language="javascript" src="../../eCommon/js/ValidateControl.js"></SCRIPT>	
	<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
	<SCRIPT LANGUAGE="javascript" SRC="../js/TPNRegimen.js"></SCRIPT>

<!-- 	<SCRIPT LANGUAGE="javascript" SRC="../js/PhMessages.js"></SCRIPT>
 -->
</HEAD>
<!--Page level variables used basically to store default values on load and certain required parameters from query string-->
<%!
public String roundTwoDigits(String a)
{
	try
	{
		String bb = "";
		if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3){
					bb=a.substring(0,a.indexOf(".")+3);
				}else{
					bb=a;
				}
			}
			return bb;
	}
	catch (Exception e){
			return a;
	}
}
%>
<%try{
	String stressFactorWeight		= "";
	String recommendedEnergy		= "";
	String recommendedEnergyUnit	= "";
	String fluidValuesUnit			= "";
	String fluidValuesMax			= "";
	String fluidValuesStd			= "";
	String fluidValuesMin			= "";
	String proteinValuesUnit		= "";
	String lipidValuesUnit			= "";
	String proteinValuesHigh		= "";
	String lipidValuesHigh			= "";	
	String proteinValuesLow			= "";
	String lipidValuesLow			= "";
	String proteinValuesNormal		= "";
	String lipidValuesNormal		= "";
	String proteinEnergy			= "";
	String lipidEnergy				= "";
	String carboEnergy				= "";
	String proteinEnergyUnit		= "";
	String lipidEnergyUnit			= "";
	String carboEnergyUnit			= "";
	//String proteinDiv				= null;
	//String lipidDiv				= null;		
	//String carboDiv				= null;
	String proteinOrderQuantityVal	= "";
	String lipidOrderQuantityVal	= "";
	String carboOrderQuantityVal	= "";
	String proteinStrengthVal		= "";
	String lipidStrengthVal			= "";
	String carboStrengthVal			= "";
	String patient_sex				= "";
	String patient_age				= "";
	String patient_age_unit			= "";
	String eqvlvalP					= "";
	String eqvlvalL					= "";
	
	//creation of TPNRegimenBean object
	String patient_id		= request.getParameter("patient_id");
	String encounter_id		= request.getParameter("encounter_id");
	String height			= request.getParameter("height");
	String weight			= request.getParameter("weight");

	String bean_id			= "@TPNRegimenBean"+patient_id+encounter_id;
	String bean_name		= "ePH.TPNRegimenBean";
	TPNRegimenBean bean		= (TPNRegimenBean)getBeanObject( bean_id,bean_name,request) ;

	//creation of OrderEntryBean object
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
	//obtain sex of patient from OrderEntryBean and converting it into string passed to procedure
	patient_sex				= ORbean.getSex();
	//out.println("gendr o patient is"+patient_sex);

	if(patient_sex.equalsIgnoreCase("Male")){
		patient_sex = "M";
	}
	if(patient_sex.equalsIgnoreCase("Female")){
		patient_sex = "F";
	}
	
	ArrayList fluidReq			= new ArrayList(); 
	fluidReq					= bean.getFluidRequired(patient_id);

	ArrayList agegroupDetails	= new ArrayList(); 
	agegroupDetails				= bean.getPatientAgeGroupDetails(patient_id);
	String pat_gender			= "";
	String pat_age_in_days		= "";

	if ( agegroupDetails.size()>0){
		pat_gender=(String)agegroupDetails.get(0);
		pat_age_in_days=(String)agegroupDetails.get(1);
	}
	//to obtain the Protein-Lipid values/unit
	bean.getProtienLipidValues(pat_gender,pat_age_in_days);
	ArrayList proteinValue		= new ArrayList();
	proteinValue				= bean.getProteinValue();
  	ArrayList lipidValue		= new ArrayList();
	lipidValue					= bean.getLipidValue();
	boolean assesmentReqYn      = bean.isSiteSpecific("PH", "ASSESMENT_REQ_YN"); // Added for ML-MMOH-CRF-1126 - Start
    
	if ((proteinValue.size()==0 || lipidValue.size()==0) && (!bean.chkAssesmentApplicableYn().equals("Y") && assesmentReqYn)){
		return;
	} // if condition Added for ML-MMOH-CRF-1126 - End
	
	else if ( proteinValue.size()==0 || lipidValue.size()==0 )
	{
	%>	
		<script>alert(getMessage("PH_TPN_CONNST_NOT_DEFINED","PH"));</script>
	<%
		return;
	}

// These Variables used for keeping the Assessment page details while navigation

int iFormulaSelected =0;
int iWeightSelected = 0;
int iStressFactor = 0;
String sEnergy = "";
boolean bActFactor = true;
String sRecoEnergy = "";
String sCarboPercent= "";
String sLipidPercent= "";
String sProteinPercent= "";
String sFluid= "";
String sEnergyProvided= "";
int iProtenLevel=1;
int iLipidsLevel=1;
String sProteinValue="";
String sLipidValue="";

if(bean.getHmAssesValues() != null)
{
	HashMap hmAssesValues = bean.getHmAssesValues();
	iFormulaSelected  =hmAssesValues.get("iFormulaSelected")!=null?Integer.parseInt(hmAssesValues.get("iFormulaSelected").toString()):0; 
	iWeightSelected  = hmAssesValues.get("iWeightSelected")!=null?Integer.parseInt(hmAssesValues.get("iWeightSelected").toString()):0;
	iStressFactor  = hmAssesValues.get("iStressFactor")!=null?Integer.parseInt(hmAssesValues.get("iStressFactor").toString()):0;
	sEnergy = 		hmAssesValues.get("sEnergy")!=null?hmAssesValues.get("sEnergy").toString():"";
	bActFactor = hmAssesValues.get("bActFactor")!=null?Boolean.getBoolean(hmAssesValues.get("bActFactor").toString()):true;
	sRecoEnergy  =  hmAssesValues.get("sRecoEnergy")!=null?hmAssesValues.get("sRecoEnergy").toString():"";
	sCarboPercent= hmAssesValues.get("sCarboPercent")!=null?hmAssesValues.get("sCarboPercent").toString():"";
	sLipidPercent = hmAssesValues.get("sLipidPercent")!=null?hmAssesValues.get("sLipidPercent").toString():"";
	sProteinPercent = hmAssesValues.get("sProteinPercent")!=null?hmAssesValues.get("sProteinPercent").toString():"";
	sFluid = hmAssesValues.get("sFluid")!=null?hmAssesValues.get("sFluid").toString():"";
	sEnergyProvided = hmAssesValues.get("sEnergyProvided")!=null?hmAssesValues.get("sEnergyProvided").toString():"";
	iProtenLevel = hmAssesValues.get("iProtenLevel")!=null?Integer.parseInt(hmAssesValues.get("iProtenLevel").toString()):1;
	iLipidsLevel = hmAssesValues.get("iLipidsLevel")!=null?Integer.parseInt(hmAssesValues.get("iLipidsLevel").toString()):1;	
	sProteinValue = (String)proteinValue.get(iProtenLevel+1);
	sLipidValue = (String)lipidValue.get(iLipidsLevel+1);


%>
<script language="javascript">
	function loadExistingValues()
	{
		document.tpnRegimenAssessment.calc_energy_by[<%=iFormulaSelected%>].checked=true;
		document.tpnRegimenAssessment.stressFactor[<%=iStressFactor%>].selected = true;
		document.tpnRegimenAssessment.body_weight[<%=iWeightSelected%>].checked=true;
		document.tpnRegimenAssessment.energy.value ='<%=sEnergy%>';
		document.tpnRegimenAssessment.recoEnergy.value ='<%=sRecoEnergy%>';
		document.tpnRegimenAssessment.carbohydrate.value ='<%=sCarboPercent%>';
		document.tpnRegimenAssessment.lipid1.value ='<%=sLipidPercent%>';
		document.tpnRegimenAssessment.protein1.value ='<%=sProteinPercent%>';
		document.tpnRegimenAssessment.fluidReq.value ='<%=sFluid%>';
		document.tpnRegimenAssessment.energyProv.value ='<%=sEnergyProvided%>';
		document.tpnRegimenAssessment.protein[<%=iProtenLevel%>].selected = true;
		document.tpnRegimenAssessment.lipid[<%=iLipidsLevel%>].selected = true;
		document.tpnRegimenAssessment.incld_actvt_factor.checked = '<%=bActFactor%>';
		document.tpnRegimenAssessment.calc_energy_by[<%=iFormulaSelected%>].onclick();
		document.getElementById("LipidValue").innerText = document.tpnRegimenAssessment.lipid[<%=iLipidsLevel%>].value+ ' <%=lipidValue.get(0)%>';
		document.getElementById("ProteinValue").innerText =document.tpnRegimenAssessment.protein[<%=iProtenLevel%>].value+' <%=proteinValue.get(0)%>';
		//document.tpnRegimenAssessment.CalculateNutrients.onclick();
		//alert("document.getElementById("ProteinValue").innerText======200====>" +document.getElementById("ProteinValue").innerText.value);
	}
</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<!-- <BODY onload='loadExistingValues()'> -->
<BODY onload='loadExistingValues()' onMouseDown="" onKeyDown="lockKey()">
<%} else {%>
<BODY onload='defaultValues();'onMouseDown="" onKeyDown="lockKey()">
<%}%>
	<FORM name="tpnRegimenAssessment" id="tpnRegimenAssessment" > 
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center">
			<TH colspan='9'  ALIGN="left"><FONT STYLE="font-size:10"><fmt:message key="ePH.EnergyExpenditure.label" bundle="${ph_labels}"/></FONT></TH>
			<TR>
				   <TD  class="label" nowrap><fmt:message key="ePH.CalculateEnergyBy.label" bundle="${ph_labels}"/> </TD>
				   <TD   class="label" nowrap><input type="radio" name="calc_energy_by" id="calc_energy_by" onClick="clearWeightValues();"><fmt:message key="ePH.HarrisBenedictFormula.label" bundle="${ph_labels}"/></TD>
				   <TD colspan='7'  class="label" ><input type="radio" name="calc_energy_by" id="calc_energy_by" onClick="loadWeightValues('<%=patient_sex%>','<%=height%>')" ><fmt:message key="ePH.BodyWeight.label" bundle="${ph_labels}"/> </TD>
			</TR>
			<TR>
				   
				   <TD  class="label" ><fmt:message key="ePH.Stress_Activity Factor.label" bundle="${ph_labels}"/> </TD>
				   <TD colspan='8' align="left" >&nbsp;<select name="stressFactor" id="stressFactor" onchange="stressFactorChange(this)">
					<option value ='0' >-----<fmt:message key="ePH.Select.label" bundle="${ph_labels}"/>-----</option>
				   <!--Logic for the populating of default stress factor depending upon flag obtained from the database-->
				   <%ArrayList stressFactor = bean.populateStressFactorValues();
						for(int i=0;i<stressFactor.size(); i += 3){
							int j = i;
							String str = "Y";
							String value = new String(stressFactor.get(j+2).toString());
							String factorWeight = new  String(stressFactor.get(j+1).toString());

							if(value.equalsIgnoreCase(str)){%>
								<option value='<%=stressFactor.get(j+1)%>' SELECTED><%=stressFactor.get(j)%></option>
								<%stressFactorWeight = factorWeight;%>	
							
							<%}
							else{%>
								<option value='<%=stressFactor.get(j+1)%>'><%=stressFactor.get(j)%></option>
						<%}
					   }%>
					</select></TD>

					
					 <%//to calculate the recommended Energy
					try{
		/*						if(weight.equals(""))
							weight = "0";
						if(height.equals(""))
							height = "0";
							*/
						if(stressFactorWeight.equals(""))
							stressFactorWeight = "0"; 
							
						bean.calculateRecommendedEnergy(weight, height, patient_id,stressFactorWeight);
						recommendedEnergy=bean.getRecommendedEnergy();
							
						if(recommendedEnergy.equals("")||recommendedEnergy==null)
							recommendedEnergy = "0";
		
							//Round off to two digits
						recommendedEnergy=roundTwoDigits(recommendedEnergy);
						
						if(recommendedEnergy.equals("")||recommendedEnergy==null)
							recommendedEnergy = "0";
						recommendedEnergyUnit=bean.getRecommendedEnergyUnit();

					}
					catch(Exception e){			
						e.printStackTrace();
					}

							//to obtain age of patient in years or months
					patient_age = bean.getPatientAge();
					patient_age_unit = bean.getPatientAgeUnit();
					if(patient_age_unit.equalsIgnoreCase("M")){
						Float f_age = new Float(patient_age);
						float age_in_year = f_age.floatValue()/12;
						patient_age = (new Float(age_in_year)).toString();
					}
					%>
				
		<%
		//to obtain the default values for Fluid Required
		try{
					fluidValuesUnit			= (String)fluidReq.get(0);
					fluidValuesMin			= (String)fluidReq.get(1);
					fluidValuesMax			= (String)fluidReq.get(2);
					fluidValuesStd			= (String)fluidReq.get(3);
				}
				catch (Exception e)
				{
					fluidValuesUnit			= "";
					fluidValuesMin			= "";
					fluidValuesMax			= "";
					fluidValuesStd			= "";

				}
		%>

	</tr>
			
			<TR>
				   <TD  class="label" nowrap>
				   <fmt:message key="ePH.ActualBodyWeight.label" bundle="${ph_labels}"/>&nbsp;</TD>
				   <TD  class="label" nowrap><input type="text" size="3" name="act_bdy_wgt" id="act_bdy_wgt"  readonly> <input type="radio" name="body_weight" id="body_weight"  checked ></TD>
				   <TD colspan='2'  class="label" ></TD>
				   <TD style="text-align:right" class="label" nowrap><fmt:message key="ePH.Carbohydrate.label" bundle="${ph_labels}"/></TD> 
				   <TD align="right"> <input type="text" size="4" name="carbohydrate" id="carbohydrate"  onKeyPress="return(ChkNumberInput(this,event,'2'))"> </TD>
				   <TD colspan="2" align="left"> % </TD>
			</TR>
			<TR>
				   <TD class="label" nowrap>
				    <fmt:message key="ePH.IdealBodyWeight.label" bundle="${ph_labels}"/>  </TD>
				   <TD class="label" nowrap><input type="text" size="3" name="act_bdy_wgt" id="act_bdy_wgt"  readonly> <input type="radio" name="body_weight" id="body_weight"></TD>
				   <TD style="text-align:center" class="label" nowrap>
				    <fmt:message key="ePH.Enery@.label" bundle="${ph_labels}"/> <input type="text" size="3" name="energy" id="energy" onBlur="calRecommenedEnergy()" onKeyPress="return(ChkNumberInput(this,event,'2'))"> <B> <fmt:message key="ePH.KCal/Kg.label" bundle="${ph_labels}"/></B></TD>
				   <TD  class="label" nowrap>
				   <fmt:message key="ePH.IncludingActivityFactor.label" bundle="${ph_labels}"/> <input type="checkbox" name="incld_actvt_factor" id="incld_actvt_factor" checked onclick="calRecommenedEnergy()"></TD>
				   <TD class="label" style="text-align:right"> <fmt:message key="Common.Lipid.label" bundle="${common_labels}"/></TD> <TD align="right"> <input type="text" size="4" name="lipid1" id="lipid1"  onKeyPress="return(ChkNumberInput(this,event,'2'))"></TD>
				   <TD align = "left" colspan="2"> % </TD>
			</TR>
			<TR>
				   <TD  class="label" nowrap><fmt:message key="ePH.AdjustedBodyWeight.label" bundle="${ph_labels}"/> </TD>
				   <TD  class="label" nowrap> <input type="text" size="3" name="act_bdy_wgt" id="act_bdy_wgt"  readonly> <input type="radio" name="body_weight" id="body_weight" ></TD>
				   <TD class="label" style="text-align:right"><fmt:message key="ePH.RecommendedEnergy.label" bundle="${ph_labels}"/> </TD>
				   <TD class="right" > <input type="text" readonly  size='5' name="recoEnergy" id="recoEnergy" style={text-align:right} value='<%=recommendedEnergy%>'></input> <%=recommendedEnergyUnit%></TD>
				   <TD style="text-align:right" class="label" > <fmt:message key="ePH.Protein.label" bundle="${ph_labels}"/> </TD>
				   <TD align = "right"> <input type="text" size="4" name="protein1" id="protein1" onKeyPress="return(ChkNumberInput(this,event,'2'))"> </TD>
				   <TD colspan="2"> % </TD>
			</TR>
			<TR>

				   <TD colspan='4'  class="label" ></TD>
				   <TD  style="text-align:right" class="label"> <fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/> </TD>
				   <TD align="right"><input type="text" name='fluidReq' id='fluidReq' style={text-align:right} size='4' value='<%=fluidValuesStd%>' onblur='checkEnergyLimits(<%=fluidValuesMin%>,<%=fluidValuesMax%>,this,<%=fluidValuesStd%>)'  onKeyPress="return(ChkNumberInput(this,event,'2'))"></input> </TD>
				   <TD align = "Left" colspan = "2"> <%=fluidValuesUnit%> </TD>
			</TR>

			<TR>
				   <TD colspan='4'  class="label" ></TD>
		<%
			try{	
				proteinValuesUnit	= proteinValue.get(0)==null?"":(String)proteinValue.get(0);
				proteinValuesLow	= proteinValue.get(1)==null?"":(String)proteinValue.get(1);
				proteinValuesHigh	= proteinValue.get(2)==null?"":(String)proteinValue.get(2);
				proteinValuesNormal = proteinValue.get(3)==null?"":(String)proteinValue.get(3);
				lipidValuesUnit		= lipidValue.get(0)==null?"":(String)lipidValue.get(0);
				//eqvlvalP			= bean.getEqvlValues(proteinValuesUnit);
				//eqvlvalL			= bean.getEqvlValues(lipidValuesUnit);
				lipidValuesLow		= lipidValue.get(1)==null?"":(String)lipidValue.get(1);
				lipidValuesHigh		= lipidValue.get(2)==null?"":(String)lipidValue.get(2);
				lipidValuesNormal	= lipidValue.get(3)==null?"":(String)lipidValue.get(3);
			}
			catch(Exception e )	{
				e.printStackTrace();
			}
			if(recommendedEnergy.equals(""))
				recommendedEnergy	= "0";
			if(proteinValuesNormal.equals(""))
				proteinValuesNormal = "0";
			if(lipidValuesNormal.equals(""))
				lipidValuesNormal	= "0";

			if(bean.getHmAssesValues()==null)
				bean.calculateMacroNutrients(recommendedEnergy, proteinValuesNormal, lipidValuesNormal,weight);
			ArrayList energyValue = bean.getEnergyValue();

			if(energyValue.size() >0){
	
				proteinEnergy			= energyValue.get(0)==null?"":(String)energyValue.get(0);
				lipidEnergy				= energyValue.get(1)==null?"":(String)energyValue.get(1); //*9
				carboEnergy				= energyValue.get(2)==null?"":(String)energyValue.get(2);
				proteinEnergyUnit		= energyValue.get(3)==null?"":(String)energyValue.get(3);
				lipidEnergyUnit			= energyValue.get(4)==null?"":(String)energyValue.get(4);
				carboEnergyUnit			= energyValue.get(5)==null?"":(String)energyValue.get(5);
				proteinStrengthVal		= energyValue.get(6)==null?"":(String)energyValue.get(6);
				lipidStrengthVal		= energyValue.get(7)==null?"":(String)energyValue.get(7);
				carboStrengthVal		= energyValue.get(8)==null?"":(String)energyValue.get(8);
				proteinOrderQuantityVal = energyValue.get(9)==null?"":(String)energyValue.get(9);
				lipidOrderQuantityVal	= energyValue.get(10)==null?"":(String)energyValue.get(10);
				carboOrderQuantityVal	= energyValue.get(11)==null?"":(String)energyValue.get(11);
			}
	%>
 
			<TD class="label" style="text-align:right"> <fmt:message key="ePH.Energytobeprovided.label" bundle="${ph_labels}"/> </TD>
			<TD align="right"><input type="text" size='5' name="energyProv" id="energyProv" value='<%=recommendedEnergy%>'  onBlur='energyProvidedChange()' onKeyPress="return(ChkNumberInput(this,event,'2'))"></input> </TD>
			<TD align ="left" colspan ="2"><%=bean.getRecommendedEnergyUnit()%></TD>
			</TR>
			<TR>
				<TD class="label"  style="text-align:right"><fmt:message key="ePH.Protein.label" bundle="${ph_labels}"/></TD>
				<TD>
					<TABLE>
						<TR>
					
							<TD align="left"> <select name="protein" id="protein" onchange="proteinChange(this,'<%=proteinValuesUnit%>')">
										   <option value ='<%=proteinValuesHigh%>'>&nbsp;<fmt:message key="Common.High.label" bundle="${common_labels}"/></option>
										   <option value ='<%=proteinValuesNormal%>'>&nbsp;<fmt:message key="Common.Normal.label" bundle="${common_labels}"/>&nbsp;</option>
										   <option value ='<%=proteinValuesLow%>'>&nbsp;<fmt:message key="Common.Low.label" bundle="${common_labels}"/></option>
										   </select> </TD>
							<TD class="DATA" id='ProteinValue'>  <%=proteinValuesNormal+"    "+proteinValuesUnit%></TD>
						</TR>
					</TABLE>
				</TD>
				<TD class="label" style="text-align:right"> <fmt:message key="Common.Lipid.label" bundle="${ph_labels}"/></TD>
				<TD>
					<TABLE>
						<TR>
							<TD><select name="lipid" id="lipid" onchange="lipidChange(this,'<%=lipidValuesUnit%>')">
											<option value ='<%=lipidValuesHigh%>'>&nbsp;<fmt:message key="Common.High.label" bundle="${common_labels}"/></option>
											<option value ='<%=lipidValuesNormal%>'>&nbsp;<fmt:message key="Common.Normal.label" bundle="${common_labels}"/>&nbsp;</option>
											<option value ='<%=lipidValuesLow%>'>&nbsp;<fmt:message key="Common.Low.label" bundle="${common_labels}"/></option>
											</select></TD>
							<TD class="DATA" id='LipidValue'>  <%=lipidValuesNormal+"    "+lipidValuesUnit%></TD>
						</TR>
					</TABLE>
				</TD>
				<TD colspan ='4'></TD>

			</TR>
			<TR>
			
					<TD colspan='6' align="right"><input type='button'  name= "CalculateNutrients" value='<fmt:message key="ePH.CalculateNutrients.label" bundle="${ph_labels}"/>' class='BUTTON' onclick="if(checkForNull()){calculateMacroNutrients('<%=weight%>','<%=proteinValuesUnit%>','<%=lipidValuesUnit%>')}"></input></TD>
			</TR>
		</TABLE>
		
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
					<TH ALIGN="left" COLSPAN="6"><FONT STYLE="font-size:10"><fmt:message key="ePH.RecommendedMacroNutrients.label" bundle="${ph_labels}"/></FONT></TH>
		</TABLE>
		<TABLE CELLPADDING="3" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="1" name="macroNutrientsTable" id="macroNutrientsTable">
			<TR>
				<TD width='12%' align="center" class="CAGROUPHEADING" STYLE="border-style:solid"><FONT STYLE="font-size:11" FACE="verdana"><fmt:message key="ePH.MacroNutrients.label" bundle="${ph_labels}"/></FONT></TD>
				<TD width='12%' align="center" class="CAGROUPHEADING" STYLE="border-style:solid"><FONT STYLE="font-size:11" FACE="verdana"><fmt:message key="ePH.Energy.label" bundle="${ph_labels}"/></FONT></TD>
				<TD width='12%' align="center" class="CAGROUPHEADING" STYLE="border-style:solid"><FONT STYLE="font-size:11" FACE="verdana"><fmt:message key="ePH.OrderQuantity.label" bundle="${ph_labels}"/></FONT></TD>
				<TD width='12%' align="center" class="CAGROUPHEADING" STYLE="border-style:solid"><FONT STYLE="font-size:11" FACE="verdana"><fmt:message key="ePH.Strength/Weight.label" bundle="${ph_labels}"/></FONT></TD>
			<TR>
			
				<TD align="right" class="QRYODDSMALL" align='center'><fmt:message key="ePH.Carbohydrate.label" bundle="${ph_labels}"/></TD>
				<TD align="right" class="QRYODDSMALL" id="CarboEnergy"><%=carboEnergy+"       "+carboEnergyUnit%></TD>
				<TD align="right"  class="QRYODDSMALL" id="CarboOrdQtyVal"><%=carboOrderQuantityVal+"       "+proteinValuesUnit+"/Day"%></TD>
				<TD align="right" class="QRYODDSMALL" id="CarboStnVal"><%=carboStrengthVal+" "+proteinValuesUnit+"/ kg"%></TD>
			</TR>
			
			<TR>
				<TD align="right" class="QRYEVENSMALL" align='center'><fmt:message key="ePH.Protein.label" bundle="${ph_labels}"/></TD>
				<TD align="right"  class="QRYEVENSMALL" id="ProteinEnergy"><%=proteinEnergy+"       "+proteinEnergyUnit%></TD>
				<TD align="right"  class="QRYEVENSMALL" id ="ProteinOrdQtyVal"><%=proteinOrderQuantityVal+"       "+proteinValuesUnit+"/Day"%></TD>
				<TD align="right" class="QRYEVENSMALL" id="ProteinStnVal"><%=proteinStrengthVal+" "+ proteinValuesUnit+"/Kg"%></TD>
			</TR>
			<TR>
				<TD align="right" class="QRYODDSMALL" align='center'> <fmt:message key="Common.Lipid.label" bundle="${common_labels}"/></TD>
				<TD align="right"  class="QRYODDSMALL" id="LipidEnergy"><%=lipidEnergy+"       "+lipidEnergyUnit%></TD>
				<TD align="right"  class="QRYODDSMALL" id="LipidOrdQtyVal"><%=lipidOrderQuantityVal+"       "+lipidValuesUnit+"/Day"%></TD>
				<TD align="right" class="QRYODDSMALL" id="LipidStnVal"><%=lipidStrengthVal+" "+lipidValuesUnit +"/kg"%></TD>
			</TR>
		</TABLE>
		<TABLE CELLPADDING="0" CELLSPACING="0" WIDTH="100%" ALIGN="center" BORDER="0">
			<TR>
				<TD COLSPAN="4" align="right"><input type='button' value='<fmt:message key="Common.reset.label" bundle="${common_labels}"/>' class='BUTTON' onclick='resetDefault()'></input></TD>
				<!-- <TD width="5%" align="right"><input type='button' value='Record' class='BUTTON' onclick='recordData(this.form)'></input></TD> -->
			</TR>
			<TR><TD>&nbsp;</TD><TD>&nbsp;</TD><TD>&nbsp;</TD></TR>
		</TABLE>
		<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="hidden" name="patient_height" id="patient_height" value="<%=height%>">
		<input type="hidden" name="patient_weight" id="patient_weight" value="<%=weight%>">
		<input type="hidden" name="patient_sex" id="patient_sex" value="<%=patient_sex%>">
		<input type="hidden" name="patient_age" id="patient_age" value="<%=patient_age%>">

		<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">
		<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
		<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">

		<input type='hidden' name='CHO_ENERGY' id='CHO_ENERGY' value='<%=carboEnergy%>'>
		<input type='hidden' name='CHO_QTY' id='CHO_QTY' value='<%=carboOrderQuantityVal%>'>
		<input type='hidden' name='PRO_ENERGY' id='PRO_ENERGY' value='<%=proteinEnergy%>'>
		<input type='hidden' name='PRO_QTY' id='PRO_QTY' value='<%=proteinOrderQuantityVal%>'>
		<input type='hidden' name='LIPD_ENERGY' id='LIPD_ENERGY' value='<%=lipidEnergy%>'>
		<input type='hidden' name='LIPD_QTY' id='LIPD_QTY' value='<%=lipidOrderQuantityVal%>'>
		<input type='hidden' name='fluid_unit' id='fluid_unit' value='<%=fluidValuesUnit%>'>
	</FORM>
		<script>
			recordData("<%=bean_id%>","<%=bean_name%>");
			document.forms[0].stressFactor.focus();
		</script>
	<% putObjectInBean(bean_id,bean,request); 
	   putObjectInBean(or_bean_id,ORbean,request); 
	%>
  </BODY>
<%
		}
	catch(Exception e) {

			e.printStackTrace() ;
		}
%>
</HTML>

