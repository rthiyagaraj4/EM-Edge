<!DOCTYPE html>
<!-- /* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
03/07/2019      [IN:067952]     Devindra             MMS-KH-CRF-0013 [IN:067952] 
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History	Name				Rev.Date	Rev.Name			Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
05/11/2019	IN070606		Ramesh Goli											MMS-KH-CRF-0029	
23/08/2020		IN073641		Manickavasagam			MMS-KH-CRF-0034 
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page import="java.sql.Connection,webbeans.eCommon.ConnectionManager"%> <!--added for MMS-KH-CRF-0013 [IN:067952] -->
<%@page contentType="text/html; charset=UTF-8" import="java.util.*, ePH.*,eOR.*, ePH.Common.* , eCommon.Common.*,eCommon.XSSRequestWrapper" %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
<%
	try{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
		<script language="JavaScript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<script language="Javascript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<SCRIPT LANGUAGE="javascript" SRC="../../ePH/js/DrugInteraction.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 
	</head>
<style>
textarea {
  resize: none;
}
</style>	
	<body onMouseDown="CodeArrest();" onKeyDown="lockKey()" topmargin="0">
<%
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ;
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );
		String bean_id		= "DrugInteractionBean";
		String bean_name	= "ePH.DrugInteractionBean";
		String mode			= request.getParameter("mode");
		String call_from			= request.getParameter("call_from")==null?"":request.getParameter("call_from");
		DrugInteractionBean bean = (DrugInteractionBean)getBeanObject( bean_id,bean_name,request) ;
		String established_sel="",probable_sel="",suspected_sel="",possible_sel="",unlimited_sel="",blank_sel="selected"; // added for FD-RUT-CRF-0066.1 [IN036975]
	    String drug_drug_sel="selected",drug_food_sel="",drug_lab_sel="",drug_icd_sel="";  //IN070606 drug_icd_sel added for MMS-DM-CRF-0229
	        boolean intractn_req_yn = false; // Added for MMS-KH-CRF-0013 [IN:067952] -Start
	        Connection con			= null;  
                try{
			con				= ConnectionManager.getConnection(request);
			intractn_req_yn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_STAGE_INTRACTN_REQ_YN");
                }
                catch(Exception e){
			e.printStackTrace();
	         }
                 finally{
        	  if(con != null)
          		ConnectionManager.returnConnection(con,request);
                 } // Added for MMS-KH-CRF-0013 [IN:067952] -End
		bean.setLanguageId(locale);
		bean.setMode( mode ) ;
		if(call_from.equals("CREATE"))
			bean.clear();
		String facility_id					= (String) session.getValue("facility_id");
		String sql_ph_generic_name_lookup=PhRepository.getPhKeyValue("SQL_PH_GENERIC_NAME_SELECT_LOOKUP");
		String sql_ph_drug_lookup=PhRepository.getPhKeyValue("SQL_PH_DRUG_ORDER_CAT_NOT_LINK_SELECT1");
		String sql_ds_foodItem_lookup=PhRepository.getPhKeyValue("SQL_DS_INGREDIENT_DETAILS");		//IN070606
		String sql_lb_labOrderCatalog_lookup=PhRepository.getPhKeyValue("SQL_OR_LABORDERCATALOG_DETAILS"); //IN070606
		String intr_option="G",intr_name1="",intr_name2="",intr_code1="",intr_code2="", severity_level="H", significant_level="1", probability="", interaction_desc="", restrict_transaction="N", editable="", restr_check="", eff_status="", eff_status_Chk="", eff_editable="", form_code1="", form_code2="", form_desc1="", form_desc2="",eff_status_old="";  // Modified for FD-RUT-CRF-0066.1 [IN036975] // eff_status_old Added for MMS-KH-CRF-0013 [IN:067952]
		String intr_option_type="D"; //IN070606
		ArrayList dosageForms1 = null;
		ArrayList dosageForms2 = null;
		String lab_ord_chk_upto = "";// MMS-KH-CRF-0034
		String term_desc="",term_code ="",term_set_code="";//Adding start for MMS-DM-CRF-0229
		ArrayList termlist=new ArrayList(); 
        HashMap termlistvalues=new HashMap();
		termlist=bean.getTermList();//Adding end for MMS-DM-CRF-0229
		String term_visible ="visibility:hidden";


		if(mode.equals("2")){
			intr_option = request.getParameter("intr_option");
			intr_code1 = request.getParameter("intr_code1");
			intr_code2 = request.getParameter("intr_code2");
			form_code1 = request.getParameter("form_code1");
			form_code2 = request.getParameter("form_code2");
			intr_option_type = request.getParameter("intr_type"); //IN070606
			HashMap hmDrugInteractionDtl = 	bean.getInteractionDtl(intr_option,intr_code1, intr_code2,form_code1, form_code2,intr_option_type);  //intr_option_type added for IN070606
			intr_name1 =(String) hmDrugInteractionDtl.get("intr_name1");
			intr_name2 = (String)hmDrugInteractionDtl.get("intr_name2"); 
			severity_level = (String)hmDrugInteractionDtl.get("severity_level")==null?"":(String)hmDrugInteractionDtl.get("severity_level");
			significant_level = (String)hmDrugInteractionDtl.get("significant_level")==null?"":(String)hmDrugInteractionDtl.get("significant_level");
			probability = (String)hmDrugInteractionDtl.get("probability")==null?"":(String)hmDrugInteractionDtl.get("probability");
			restrict_transaction = (String)hmDrugInteractionDtl.get("restrict_transaction")==null?"N":(String)hmDrugInteractionDtl.get("restrict_transaction");
			interaction_desc = (String)hmDrugInteractionDtl.get("interaction_desc");
			eff_status = (String)hmDrugInteractionDtl.get("eff_status")==null?"D":(String)hmDrugInteractionDtl.get("eff_status");
			eff_status_old = (String)hmDrugInteractionDtl.get("eff_status")==null?"D":(String)hmDrugInteractionDtl.get("eff_status"); // Added for MMS-KH-CRF-0013 [IN:067952]
			//form_code1 = (String)hmDrugInteractionDtl.get("form_code1")==null?"":(String)hmDrugInteractionDtl.get("form_code1");
			//form_code2 = (String)hmDrugInteractionDtl.get("form_code2")==null?"":(String)hmDrugInteractionDtl.get("form_code2");
			form_desc1 = (String)hmDrugInteractionDtl.get("form_desc1")==null?"":(String)hmDrugInteractionDtl.get("form_desc1");
			form_desc2 = (String)hmDrugInteractionDtl.get("form_desc2")==null?"":(String)hmDrugInteractionDtl.get("form_desc2"); 
			intr_option_type= (String)hmDrugInteractionDtl.get("intr_type")==null?"":(String)hmDrugInteractionDtl.get("intr_type"); //IN070606
			lab_ord_chk_upto = (String)hmDrugInteractionDtl.get("LAB_ORD_CHK_UPTO_NO_OF_DAYS")==null?"":(String)hmDrugInteractionDtl.get("LAB_ORD_CHK_UPTO_NO_OF_DAYS"); //MMS-KH-CRF-0034
			term_set_code   = (String)hmDrugInteractionDtl.get("TERM_SET_ID")==null?"":(String)hmDrugInteractionDtl.get("TERM_SET_ID");

			//dosageForms1 = bean.getDosageForms(intr_option, intr_code1);
			//dosageForms2 = bean.getDosageForms(intr_option, intr_code2);
			editable = "disabled";
			if("I".equals(intr_option_type)){//Added for MMS-DM-CRF-0229
			   term_visible ="visibility:visible";
			}
			if(restrict_transaction.equals("Y"))
				restr_check = "Checked";
			if(eff_status.equals("E"))
				eff_status_Chk = "Checked";
			else
				eff_editable = "disabled";
			blank_sel="";  // added for FD-RUT-CRF-0066.1 [IN036975] -- begin
		}
		if(call_from.equals("UPDATE")){
			intr_option = request.getParameter("intr_option");
			intr_code1 = request.getParameter("intr_code1");
			intr_code2 = request.getParameter("intr_code2");
			form_code1 = request.getParameter("form_code1");
			form_code2 = request.getParameter("form_code2");
			String key = intr_option+"_"+intr_code1+"_"+form_code1+"_"+intr_code2+"_"+form_code2;
			ArrayList DrugInteractionDtl = null;
			HashMap hmDrugIntList = bean.getDrugIntrList();
			if(hmDrugIntList!=null && hmDrugIntList.containsKey(key))
				DrugInteractionDtl =(ArrayList) hmDrugIntList.get(key);
			if(DrugInteractionDtl !=null && DrugInteractionDtl.size()>0){
				intr_name1 = (String)DrugInteractionDtl.get(3);//"intr_name1"
				intr_name2 = (String)DrugInteractionDtl.get(4); //"intr_name2"
				severity_level = (String)DrugInteractionDtl.get(5);//"severity_level"
				significant_level = (String)DrugInteractionDtl.get(6);//"significant_level"
				probability = (String)DrugInteractionDtl.get(7);//"probability"
				restrict_transaction = (String)DrugInteractionDtl.get(8);//"restrict_transaction"
				interaction_desc = (String)DrugInteractionDtl.get(9);//"interaction_desc"
				//interaction_desc = java.net.URLEncoder.encode(DrugInteractionDtl.get(9).toString(),"UTF-8");//"interaction_desc"   - added for FD-RUT-CRF-0066.1 [IN036975]
				//form_code1 = (String)DrugInteractionDtl.get(11);//"form_code1"
				//form_code2 = (String)DrugInteractionDtl.get(12);//"form_code2"
				intr_option_type= (String)DrugInteractionDtl.get(15);//"interaction_Type"  //IN070606
				lab_ord_chk_upto = (String)DrugInteractionDtl.get(16); //MMS-KH-CRF-0034
				term_set_code = (String)DrugInteractionDtl.get(17); //MMS-KH-CRF-0034
				
			}
			dosageForms1 = bean.getDosageForms(intr_option, intr_code1);
			dosageForms2 = bean.getDosageForms(intr_option, intr_code2);
			editable = "disabled";
			eff_editable = "";
			if(restrict_transaction.equals("Y"))
				restr_check = "Checked";
			if("I".equals(intr_option_type)){//Added for MMS-DM-CRF-0229
			   term_visible ="visibility:visible";
			}
		}
		if(probability.equals("E"))
			established_sel="selected";
		else if(probability.equals("P"))
			probable_sel="selected";
		else if(probability.equals("S"))
			suspected_sel="selected";
		else if(probability.equals("O"))
			possible_sel="selected";
		else if(probability.equals("U"))
			unlimited_sel="selected";
		else
			blank_sel="selected"; // FD-RUT-CRF-0066.1 [IN036975] -- end
		//IN070606 Start.	
		if("D".equals(intr_option_type)){
			drug_drug_sel	= "selected";
			drug_food_sel	= "";
			drug_lab_sel 	= "";
		}else if("F".equals(intr_option_type)){
			drug_drug_sel	= "";
			drug_food_sel	= "selected";
			drug_lab_sel 	= "";
			drug_icd_sel    = "";//Added for MMS-DM-CRF-0229
		}else if("L".equals(intr_option_type)){
			drug_drug_sel	= "";
			drug_food_sel	= "";
			drug_lab_sel 	= "selected";
			drug_icd_sel    = "";//Added for MMS-DM-CRF-0229
		}
		else if("I".equals(intr_option_type)){
			drug_drug_sel	= "";
			drug_food_sel	= "";
			drug_lab_sel 	= "";
			drug_icd_sel    = "selected";//Added for MMS-DM-CRF-0229
		}
		//IN070606 End.
%>
		<form name="DrugInteracionAddModify" id="DrugInteracionAddModify" >
			<table cellpadding=0 cellspacing=3 width="100%" align="center" border="0">
				<TR><TH  ALIGN="Center" COLSPAN="4"></TH></TR>
				<TR><td  ALIGN="Center" COLSPAN="4"> &nbsp;</td></TR>				
				<!-- IN070606 Start--->
				<tr>
					<td align="right" class="label" width='10%'>
						<fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/> &nbsp; Type						
					</td>
					<td align="left" class="fields" colspan='3'>
						<select name="InteractionType" id="InteractionType" style="width: 125px;" onChange="onChangeInteractionType(this);" <%=editable%>>
							<option value='D' <%=drug_drug_sel%>><fmt:message key="ePH.DrugtoDrug.label" bundle="${ph_labels}"/> </option>
							<option value='L' <%=drug_lab_sel%>><fmt:message key="ePH.DrugtoLabaratory.label" bundle="${ph_labels}"/></option>
							<option value='F' <%=drug_food_sel%>><fmt:message key="ePH.DrugtoFood.label" bundle="${ph_labels}"/></option>
							<option value='I' <%=drug_icd_sel%>><fmt:message key="ePH.DrugDisease.label" bundle="${ph_labels}"/></option><!-- Added for MMS-DM-CRF-0229 -->
							
						</select>
					</td>
				</tr>
				<!-- IN070606 End-->
				<tr id="drugInteractionBy">
					<td align="right" class="label" width='10%'>
						<fmt:message key="Common.DrugInteraction.label" bundle="${common_labels}"/>
						<fmt:message key="ePH.By.label" bundle="${ph_labels}"/>
					</td>
					<td align="left" class="fields" ><select name="InteractionBy" id="InteractionBy" style="width: 125px;" onChange="onChangeDrugInteraction();" <%=editable%>><!-- Removed colspan for MMS-DM-CRF-0229 -->
<%
						if(intr_option.equals("G")){
%>
							<option value='G'selected><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></option>
							<option value='D'><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
<%
						}
						else{
%>
							<option value='G'><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></option>
							<option value='D' selected><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
<%
						}
%>
					</select>
					</td>
					     <td  class="label" id="term_set" style=<%=term_visible%>><fmt:message key="Common.TermSet.label" bundle="${common_labels}"/></td>
                         <td >&nbsp;
                           <select name="TermSetList" id="TermSetList" style=<%=term_visible%> <%=editable%>>
			                   <option value="" >-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
<%                                  for(int i=0; i<termlist.size(); i++)
				                     {
					                      termlistvalues = (HashMap)termlist.get(i);
					                      term_code = (String)termlistvalues.get("code");
                                          term_desc = (String)termlistvalues.get("desc");
                                 String term_selct ="";
								  if(term_set_code.equals(term_code)){
									  term_selct ="selected";
								  }
			
%>
                                <OPTION value="<%=term_code%>" <%=term_selct%> ><%=term_desc%></OPTION>
<%			
}
%>
			             </select>
			                <img name='term_mandatory' id='term_mandatory' style=<%=term_visible%> src="../../eCommon/images/mandatory.gif">
                        </td>

				</tr>
				<TR><TH  ALIGN="Center" COLSPAN="4"><fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.details.label" bundle="${common_labels}"/></TH>
				</TR>
				<tr>	
					<td class="label" WIDTH="10%" > <label id='lblIntName1'>
<%
						if(intr_option.equals("G")){
%>
							<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></label>1
<%
						}
						else{
%>
							<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/>1
<%
						}
%>
					</td>
					<td class="label"   WIDTH="30%">
						<input type='text' name='intr_name1' id='intr_name1' value='<%=intr_name1%>' size='60' <%=editable%> onBlur="searchCode1( intr_name1,intr_code1,'<%=mode%>','1' );">
						<input type="button" name="btnintr_name1" id="btnintr_name1"  value="?" class="button"  onClick="searchCode( intr_name1,intr_code1,'<%=mode%>' ,'1');" <%=editable%>>
						<img  src="../../eCommon/images/mandatory.gif" ></img>
						<input type="hidden" name="intr_code1" id="intr_code1" value="<%=intr_code1%>" >			
					</td>
					<td class="label" WIDTH="10%" id='lblIntNametd' > 
					<%if("D".equals(intr_option_type)){%>
					<label id='lblIntName2'>
					<%if(intr_option.equals("G")){%>
							<fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></label>2
					<%}else{%>
							<fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></label>2
					<%}%>
					<%}else if("F".equals(intr_option_type)){%>
						<fmt:message key="ePH.FoodItemIngredients.label" bundle="${ph_labels}"/>
					<%}else if("L".equals(intr_option_type)){%>
						<fmt:message key="ePH.LaboratoryTestCode.label" bundle="${ph_labels}"/>
					<%}else if("I".equals(intr_option_type)){%>
						<fmt:message key="Common.TermCode.label" bundle="${common_labels}"/><!-- Added for MMS-DM-CRF-0229 -->
					<%}%>
					</td>
					<td class="label"  WIDTH="30%" > 
						<input type='text' name='intr_name2' id='intr_name2' value='<%=intr_name2%>' size='60' <%=editable%> onBlur="searchCode1( intr_name2,intr_code2,'<%=mode%>','2' );">
						<input type="button" name="btnIntrName2" id="btnIntrName2"  value="?" class="button" onClick="searchCode( intr_name2,intr_code2,'<%=mode%>','2' );" <%=editable%>>
						<img  src="../../eCommon/images/mandatory.gif" ></img>
						<input type="hidden" name="intr_code2" id="intr_code2" value="<%=intr_code2%>" >		
					</td>
				</tr>
				<tr>	
					<td class="label" WIDTH="10%" >
						<fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>1
					</td>
					<td class="label"   WIDTH="30%">
						<select name="dosageForm1" id="dosageForm1" onChange="setFormCode(this, '1');" <%=editable%>>
<%
							if(mode.equals("1") ){
								if(!call_from.equals("UPDATE")){
%>
								<option value='' selected>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
								}
								else if(intr_option.equals("G")) {
%>
								<option value='*A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
								}
%>
								<%=bean.getListOptionTag(dosageForms1, form_code1)%>
<%
							}
							else if(mode.equals("2")){

%>
								<option value='<%=form_code1%>' selected><%=form_desc1%></option>
<%
							}
%>
						</select>
						<img  src="../../eCommon/images/mandatory.gif" ></img>
					</td>
					<%if("D".equals(intr_option_type)){%>
					<td class="label" WIDTH="10%" id="dosageFormtd1" >
						<fmt:message key="ePH.DosageForm.label" bundle="${ph_labels}"/>2
					</td>
					<td class="label"  WIDTH="30%" id="dosageFormtd2" > 					
						<select name="dosageForm2" id="dosageForm2" onChange="setFormCode(this, '2');"  <%=editable%>>
<%
							if(mode.equals("1")){
								if(!call_from.equals("UPDATE")){
%>
								<option value='' selected>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
<%
								}
								else if(intr_option.equals("G")) {
%>
								<option value='*A' selected><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
<%
								}
%>
								<%=bean.getListOptionTag(dosageForms2, form_code2)%>
<%
							}
							else if(mode.equals("2")){

%>
								<option value='<%=form_code2%>' selected><%=form_desc2%></option>
<%
							}
%>
						</select>
						<img  src="../../eCommon/images/mandatory.gif" ></img>
					</td>
					<%
					//IN070606 Start.
					}else{%>
					<td class="label" WIDTH="10%" style="display:none;" id="dosageFormtd1">
						&nbsp;
					</td>
					<td class="label" WIDTH="30%" style="display:none;" id="dosageFormtd2"> 
						&nbsp;
					</td>
					<%}%>
					<td class="label" WIDTH="10%" style="display:none;" id="foodFormtd1">
						&nbsp;
					</td>
					<td class="label" WIDTH="30%" style="display:none;" id="foodFormtd2"> 
						&nbsp;
					</td>
					<td class="label" WIDTH="10%" style="display:none;" id="labCatlogCodetd1">
						&nbsp;
					</td>
					<td class="label" WIDTH="30%" style="display:none;" id="labCatlogCodetd2"> 
						&nbsp;
					</td>
				</tr>
				<tr> 
					<td  class="label" >
						<fmt:message key="ePH.SeverityLevel.label" bundle="${ph_labels}"/>
					</td>
					<td class="label" >
						<select name="Severity_Level" id="Severity_Level" onChange="" <%=eff_editable%>>
<%
						if(severity_level.equals("H")){
%>
							<option value='H' selected><fmt:message key="ePH.Major.label" bundle="${ph_labels}"/></option>
							<option value='M'><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
							<option value='L'><fmt:message key="ePH.Minor.label" bundle="${ph_labels}"/></option>
<%
						}
						else if(severity_level.equals("M")){
%>
							<option value='H'><fmt:message key="ePH.Major.label" bundle="${ph_labels}"/></option>
							<option value='M' selected><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
							<option value='L' ><fmt:message key="ePH.Minor.label" bundle="${ph_labels}"/></option>
<%
						}
						else{
%>
							<option value='H'><fmt:message key="ePH.Major.label" bundle="${ph_labels}"/></option>
							<option value='M' ><fmt:message key="Common.Moderate.label" bundle="${common_labels}"/></option>
							<option value='L' selected><fmt:message key="ePH.Minor.label" bundle="${ph_labels}"/></option>
<%
						}
%>
						</select>
						&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
					</td>
					<td align="right" class="label"  >
						<fmt:message key="ePH.SignificantLevel.label" bundle="${ph_labels}"/>	
					</td>
					<td class="label" WIDTH="10%">
						<select name="Significant_level" id="Significant_level" <%=eff_editable%>>
<%
						if(significant_level.equals("1")){
%>
							<option value='1' selected>1</option>
							<option value='2'>2</option>
							<option value='3'>3</option>
							<option value='4'>4</option>
							<option value='5'>5</option>
<%
						}
						else if(significant_level.equals("2")){
%>
							<option value='1'>1</option>
							<option value='2' selected>2</option>
							<option value='3'>3</option>
							<option value='4'>4</option>
							<option value='5'>5</option>
<%
						}
						else if(significant_level.equals("3")){
%>
							<option value='1'>1</option>
							<option value='2'>2</option>
							<option value='3' selected>3</option>
							<option value='4'>4</option>
							<option value='5'>5</option>
<%
						}
						else if(significant_level.equals("4")){
%>
							<option value='1'>1</option>
							<option value='2'>2</option>
							<option value='3'>3</option>
							<option value='4' selected>4</option>
							<option value='5'>5</option>
<%
						}
						else{
%>
							<option value='1'>1</option>
							<option value='2'>2</option>
							<option value='3'>3</option>
							<option value='4'>4</option>
							<option value='5' selected>5</option>
<%
						}
%>
						</select>
						&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
					</td>
				</tr>
				<!-- added for MMS-KH-CRF-0034-->
				<tr><td class="label" WIDTH="10%" id="LabOrdChkUpto" style="display:none;"><fmt:message key="ePH.CheckDrugLabIntResultComUpto.label" bundle="${ph_labels}"/> </td>
				<td class="label" id="LabOrdChkUpto1" style="display:none;"><input type="text" name="lab_ord_check_for_upto" id="lab_ord_check_for_upto" onchange="validateCheck(this)" oncopy="return false" onpaste="return false" onKeyPress="return allowValidNumber(this,event,3,0);" value="<%=lab_ord_chk_upto%>" size="3" maxlength="2"><fmt:message key="Common.days.label" bundle="${common_labels}"/>
				</td></tr>
				<tr>
					<td align="right" class="label"  name="tdProbability">
						<fmt:message key="ePH.documentation.label" bundle="${ph_labels}"/>	<!-- probability modified as documentation for FD-RUT-CRF-0066.1 [IN036975]   -->
					</td>
					<td class="label" >
						<select name="Probability" id="Probability" onChange="" <%=eff_editable%>>
<%
				//		if(probability.equals("D")){
%>							<!--  Commented and added for FD-RUT-CRF-0066.1 [IN036975] 
							<option value='D' selected><fmt:message key="Common.Definitive.label" bundle="${common_labels}"/></option>
							<option value='P'><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></option> -->
							<option value=''   <%=blank_sel%>>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>   <!-- Added for FD-RUT-CRF-0066.1 [IN036975] -->
							<option value='E'  <%=established_sel%>><fmt:message key="ePH.established.label" bundle="${ph_labels}"/></option>
							<option value='P'  <%=probable_sel%>><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></option>
							<option value='S'  <%=suspected_sel%>><fmt:message key="ePH.suspected.label" bundle="${ph_labels}"/></option>
							<option value='O'  <%=possible_sel%>><fmt:message key="ePH.Possible.label" bundle="${ph_labels}"/></option>
							<option value='U'  <%=unlimited_sel%>><fmt:message key="ePH.Unlikely.label" bundle="${ph_labels}"/></option>  <!-- FD-RUT-CRF-0066.1 [IN036975]  -- end  -->
<%
					/*	}
						else{*/
%>
							<!--<option value='D'><fmt:message key="Common.Definitive.label" bundle="${common_labels}"/></option>
							<option value='P' selected><fmt:message key="Common.Probable.label" bundle="${common_labels}"/></option>-->
<%
						//}
%>
						</select>&nbsp;<img  src="../../eCommon/images/mandatory.gif"></img>
					</td>
					<td align="right" class="label" name="restricttransaction">
						<fmt:message key="ePH.RestrictTransaction.label" bundle="${ph_labels}"/>	
					</td>
					<td class="label" >
						<input type="checkbox" name="restrict_transaction" id="restrict_transaction" value="<%=restrict_transaction%>"  <%=restr_check%> onClick="setValue(this, 'RT')" <%=eff_editable%>></td>
					</tr>
					<tr>
						<td align="left" class="label"  name="InteractDesc">
							<fmt:message key="ePH.Interaction.label" bundle="${ph_labels}"/>&nbsp;<fmt:message key="Common.description.label" bundle="${common_labels}"/>
						</td>
						<td align="left" colspan="3"class="label" ><textarea  rows='7' cols='100' name="interaction_desc" id="interaction_desc" onKeyPress="return checkMaxLimit(this,2000,'');" onBlur="callCheckMaxLen(this,2000,'blr');" <%=eff_editable%> style="color:#666666 ;"><%=interaction_desc%></textarea>
							<img  src="../../eCommon/images/mandatory.gif"></img>	
<%
							if(!mode.equals("2")){
%>
								<input type="button" name="add" id="add"  value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/>' CLASS="button" align="right"  onfocus="" onClick="checkForDuplicate();" align="right">&nbsp;&nbsp;&nbsp;
								<input type="button" name="clear" id="clear" value='<fmt:message key="Common.clear.label" bundle="${common_labels}"/>' CLASS="button" align="right"  onfocus="" onClick="Clear();" align="right">
<%
							}
							else{
%>
								&nbsp;&nbsp;&nbsp;&nbsp;<fmt:message key="Common.enabled.label" bundle="${common_labels}"/>	&nbsp;&nbsp;
								<input type="checkbox" name="eff_status" id="eff_status" value="<%=eff_status%>" <%=eff_status_Chk%> onClick="setValue(this, 'ES')"></td>
<%
							}

%>				<!-- added for MMS-KH-CRF-0034-->				
				<script>
				enableLabOrdCheck()
			</script>

						</td>
					</tr>
				</table>
				<input type="hidden" name="interact_desc" id="interact_desc" value="<%=java.net.URLEncoder.encode(interaction_desc,"UTF-8")%>">
				<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
				<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
				<input type="hidden" name="mode" id="mode" value="<%=mode%>">	
				<input type="hidden" name="locale" id="locale" value="<%=locale%>">
				<input type="hidden" name="sql_ph_generic_name_lookup" id="sql_ph_generic_name_lookup" value="<%=sql_ph_generic_name_lookup%>">
				<input type="hidden" name="sql_ph_drug_lookup" id="sql_ph_drug_lookup" value="<%=sql_ph_drug_lookup%>">				
				<input type="hidden" name="sql_ds_foodItem_lookup" id="sql_ds_foodItem_lookup" value="<%=sql_ds_foodItem_lookup%>">
				<input type="hidden" name="sql_lb_labOrderCatalog_lookup" id="sql_lb_labOrderCatalog_lookup" value="<%=sql_lb_labOrderCatalog_lookup%>">			
				<input type="hidden" name="call_from" id="call_from" value="<%=call_from%>">
				<input type="hidden" name="form_code1" id="form_code1" value="<%=form_code1%>">
				<input type="hidden" name="form_code2" id="form_code2" value="<%=form_code2%>">
				<input type="hidden" name="intr_option" id="intr_option" value="<%=intr_option%>"> <!-- Added for MMS-KH-CRF-0013 [IN:067952]-->				
				<input type="hidden" name="eff_status_old" id="eff_status_old" value="<%=eff_status_old%>"> <!-- Added for MMS-KH-CRF-0013 [IN:067952] -->
				<input type="hidden" name="intractn_req_yn" id="intractn_req_yn" value="<%=intractn_req_yn%>"> <!-- Added for MMS-KH-CRF-0013 [IN:067952] -->								
				<input type="hidden" name="lab_ord_chk_upto" id="lab_ord_chk_upto" value="<%=lab_ord_chk_upto%>"> <!-- Added for MMS-KH-CRF-0034 -->								

			</form>
		</body>
<%
		putObjectInBean(bean_id,bean,request);
	}
	catch(Exception e){
		e.printStackTrace();
	}
%>
</html>

