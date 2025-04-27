<!DOCTYPE html>

 <%-- JSP Page specific attributes start --%>
<%@ page contentType="text/html;charset=UTF-8"  import=" ePH.*, ePH.Common.* , eCommon.Common.*, java.text.*,java.lang.*, java.util.*,java.lang.*,eCommon.XSSRequestWrapper" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<html>
	<head> 
<% 
/* 
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
10/01/2019	  	IN068344	     	Manickavasagam 		  								GHL-CRF-0549 [IN068344] 
01/12/2020  	 IN8219   		   Prabha	  12/01/2021	 Manickavasagam J   	    MMS-DM-CRF-0177
21/01/2021	    TFS-12204          Prabha     21/01/2021	 Manickavasagam J           MMS-DM-CRF-0177
03/02/2021		TFS-15266          Haribabu   03/02/2021     Manickavasagam J           NMC-JD-SCF-0159
16/04/2021  	TFS id:-16341    Haribabu	 16/04/2021	 	 Manickavasagam J          NMC-JD-CRF-0097
--------------------------------------------------------------------------------------------------------------
*/
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	


	    String locale			= (String)session.getAttribute("LOCALE");
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";
		String facility_id   = (String)session.getValue( "facility_id" );
		 String login_user	= (String)session.getValue("login_user");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js" ></script>
		<script language="javascript" src="../../eCommon/js/common.js" ></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../../ePH/js/DrugNameCommonLookup.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
		<script>
			function tab_click1(id){
				selectTab(id);
				Display(id);
			}
		</script>
	</head>

	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
		<form name="frmDrugNameCommonLookupSearchCriteria" id="frmDrugNameCommonLookupSearchCriteria">
<%
			String res_by_service = request.getParameter("res_by_service");
			String res_by_service_checked="";
			if (res_by_service.equals("Y")){
				res_by_service_checked="checked";
			}
			else{
				res_by_service_checked="";
			}

			String service_code		= request.getParameter("service_code")==null?"":request.getParameter("service_code");
			String patient_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");
			String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
			String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");	
			String source_type		= request.getParameter("source_type")==null?"":request.getParameter("source_type");	
			String source_code		= request.getParameter("source_code")==null?"":request.getParameter("source_code");	
			String drugorfluid      = request.getParameter("drugorfluid")==null?"":request.getParameter("drugorfluid");
			String iv_prep_yn      = request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
			String calledfrom      = request.getParameter("calledfrom")==null?"":request.getParameter("calledfrom"); 
				
			String	bean_id			=	request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
			String priority			=	request.getParameter("priority")==null?"":request.getParameter("priority");
			String discharge_yn		=	request.getParameter("discharge_yn")==null?"Y":request.getParameter("discharge_yn");
			String disp_locn_code      = request.getParameter("disp_locn_code")==null?"":request.getParameter("disp_locn_code");
			String date_of_birth	=   request.getParameter("date_of_birth")==null?"":request.getParameter("date_of_birth");
			String gender			=   request.getParameter("gender")==null?"":request.getParameter("gender");
			String normalRx_yn		=   request.getParameter("normalRx_yn")==null?"":request.getParameter("normalRx_yn");//GHL-CRF-0549
			String home_leave_yn_val			=   request.getParameter("home_leave_yn_val")==null?"":request.getParameter("home_leave_yn_val");//added home_leave_yn_val for Bru-HIMS-CRF-093[29960] 
			String alternateOrder	=	request.getParameter("alternateOrder");//added for  JD-CRF-0198 [IN:058599] 
			String	bean_name		=	"ePH.DrugSearchBean";
			DrugSearchBean bean		=	(DrugSearchBean)getBeanObject( bean_id, bean_name , request) ;
			bean.setLanguageId(locale);
			bean.setDrugOrFluid(drugorfluid.trim());
			bean.setPatientId(patient_id.trim());

			bean.setEncounterId(encounter_id.trim());
			bean.setDOB(date_of_birth.trim());
			bean.setGender(gender.trim());

			bean.setIv_prep_yn(iv_prep_yn.trim());
			bean.setcalledfrom(calledfrom.trim());
			bean.setsource_type(source_type.trim());
			bean.setsource_code(source_code.trim());

			bean.clearMainCriteriaData() ;
			bean.clearOtherCriteriaData();
			bean.setServiceCode(service_code.trim());
			bean.setDischargeYN(discharge_yn.trim());
			bean.setHomeLeaveYN(home_leave_yn_val.trim());//added home_leave_yn_val for Bru-HIMS-CRF-093[29960]
			bean.setPriority(priority);

			bean.setPatientClass(patient_class);
			bean.setDispLocnCode(disp_locn_code);
			ArrayList arrListAll	=	(ArrayList)bean.getAllDefaultValues();
			ArrayList arrListStrength	=	(ArrayList)arrListAll.get(2);
			ArrayList arrListOrderType = null;
			String selectedOption = request.getParameter("select");
			String searchByGeneric="checked";
			String searchByDrug="";
			String searchByTrade="";
			String searchByAll	="";
			String searchBySynonym	="";
			String name="Generic Name";
			String default_text ="";
			String form_code	="";
			String form_desc	="";
			String route_desc	="";
			String route_code	="";
			String lookupdisable = "";
			String alternateDisable	= "";//added for  JD-CRF-0198 [IN:058599]
			String identity = CommonBean.checkForNull(request.getParameter("identity"));
			bean.setIdentity(identity);
			String order_type_code = CommonBean.checkForNull(request.getParameter("order_type_code"));

			//code addded for setting drug search text.....
			String getDrugSearchName = bean.getDefaultDrugSetting();
			
			/*if(selectedOption.equals("D")){
				getDrugSearchName="D";
				}
				*/

			default_text = request.getParameter("default_text")==null?"":request.getParameter("default_text");
			default_text = java.net.URLDecoder.decode(default_text.trim(),"UTF-8"); 
			
			//Added for TFS id:-16341 start
			boolean default_disp_locn_select_appl=bean.defaultDispLocnSelectAppl();
			String default_disp_locn_select_yn="N";
			if(default_disp_locn_select_appl){
				default_disp_locn_select_yn="Y";
			}
			String sql="select DISP_LOCN_CODE,SHORT_DESC from PH_DISP_LOCN_LANG_VW where FACILITY_ID='?' and LANGUAGE_ID='?' and DISP_LOCN_TYPE in ('P','C','N') and EFF_STATUS='E'";
			ArrayList disp_locn_params= new ArrayList();
			disp_locn_params.add(facility_id);
			disp_locn_params.add(locale);
			String default_disp_locn="";
			//Added for TFS id:-16341 end
			//Added for MMS-DM-CRF-0177
			boolean pre_alloc_appl = false;
			String pre_alloc_yn ="N";
			String pre_alloc_appl_disp_style= "visibility:visible";
			pre_alloc_yn = bean.getPreAllocStatusYN();
			//NMC-JD-CRF-0197 - Splitted and taken as it is related on change
			StringTokenizer pre_alloc_or_dispense_location=null; 
			String alw_disp_loc_drug_search_yn = "N";
			System.err.println("===NMC-JD-CRF-0197=== initial for string tokenizer pre_alloc_yn "+pre_alloc_yn);
			if(pre_alloc_yn!=null) {
				 pre_alloc_or_dispense_location = new StringTokenizer(pre_alloc_yn,"$");

				 if(pre_alloc_or_dispense_location.hasMoreTokens()) {
						while (pre_alloc_or_dispense_location.hasMoreTokens()){
							pre_alloc_yn				= pre_alloc_or_dispense_location.nextToken();  //First one will be pre_alloc_yn
							alw_disp_loc_drug_search_yn = pre_alloc_or_dispense_location.nextToken();  //Second  one will be alw_disp_loc_drug_search_yn
					}
				}
			}
			else 
				pre_alloc_yn = "N";

			System.err.println("===NMC-JD-CRF-0197==="+pre_alloc_yn+"==alw_disp_loc_drug_search_yn"+alw_disp_loc_drug_search_yn);

			bean.setPreAllocAppl(pre_alloc_appl);
			String pre_alloc_check =  "N"; //Added for MMS-DM-CRF-0177
			//Added for TFS id:-16341 start 
			if(default_disp_locn_select_appl){
					default_disp_locn=bean.getDefaultDispLocn();
			}

			if(pre_alloc_yn.equals("Y") && identity.equals("MedicationOrder") && (iv_prep_yn.equals("") || iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4") || iv_prep_yn.equals("5") || iv_prep_yn.equals("6") ) )
 			{
				pre_alloc_appl = true;
				bean.setPreAllocAppl(pre_alloc_appl);
				
				//Added for TFS id:-16341
				name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.GenericName/TradeName.label","ph_labels"); //Modified for MMS-DM-CRF-0177
				bean.setSearchBy("A");
				searchByAll			= "checked";
				searchByTrade		= "";
				searchByGeneric		= "";
				searchByDrug		= "";
				searchBySynonym="";
				//lookupdisable = "disabled"; //Modified for MMS-DM-CRF-0177
				pre_alloc_appl_disp_style="display:none";
				pre_alloc_check = "Y"; //Added for MMS-DM-CRF-0177
 			}
			else{  //Added for MMS-DM-CRF-0177
			if (getDrugSearchName.equals("G")){
				name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GenericName.label","common_labels");
			}
			else if (getDrugSearchName.equals("D")){
				name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DrugName.label" ,"common_labels");
				searchByDrug = "checked";
				searchByGeneric="";
				searchByAll	   = "";
				searchBySynonym="";
			}
			else if (getDrugSearchName.equals("T")){
				name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TradeName.label","common_labels");
				searchByTrade="checked";
				searchByGeneric="";
				searchByAll	   = "";
				searchBySynonym="";
			}
			else if (getDrugSearchName.equals("C")){
				name = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.CommonName.label","ph_labels");
				searchBySynonym="checked";
				searchByTrade="";
				searchByGeneric="";
				searchByAll	   = "";
				lookupdisable = "disabled";
			}
			else if (getDrugSearchName.equals("A")){
				bean.setSearchBy("A");
				name				= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.name.label","common_labels");
				searchByAll			= "checked";
				searchByTrade		= "";
				searchByGeneric		= "";
				searchByDrug		= "";
				searchBySynonym="";
				lookupdisable = "disabled";
			}
			} //Added for MMS-DM-CRF-0177
			
			System.err.println("====pre_alloc_appl==="+pre_alloc_appl+"==default_disp_locn_select_appl"+default_disp_locn_select_appl);
			//NMC-JD-CRF-0197 - Till here

			String strOrderType="";
			if(identity.equals("MedicationOrder")){
				arrListOrderType = bean.getOrderTypeValues();
				if (!order_type_code.equals("")){
					strOrderType = "disabled";
				}		
			}
			if(alternateOrder.equals("Y")){//added for  JD-CRF-0198 [IN:058599]
				String	bean_id_1					=	"DispMedicationBean" ;
				String	bean_name_1					=	"ePH.DispMedicationBean";
				DispMedicationBean bean_1			= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
				bean.setGeneric_id_alternate(bean_1.getGenericId());
				lookupdisable = "disabled";
				alternateDisable = "disabled";
			}
			else
				bean.setGeneric_id_alternate("");//added for  JD-CRF-0198 [IN:058599]
			if(priority.equalsIgnoreCase("Routine"))
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
			else if(priority.equalsIgnoreCase("Urgent"))
				priority=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
%>

			<table border="0" width="50%" cellspacing="0" cellpadding="0">
				<tr>	
					<tr width= "50%" class="white">
						<ul id="tablist" name="tablist" class="tablist" style="padding-left:0px">
						<li class="tablistitem" title='<fmt:message key="ePH.DrugByCharacteristics.label" bundle="${ph_labels}"/>'>
							<a onclick="tab_click1('DrugByCharacteristics_tab')" class="tabClicked" id="DrugByCharacteristics_tab" >
								<span class="tabSpanclicked" id="DrugByCharacteristics_tabspan"><fmt:message key="ePH.DrugByCharacteristics.label" bundle="${ph_labels}"/></span>
							</a>
						</li>
						<li class="tablistitem" title='<fmt:message key="ePH.ByATCClassification.label" bundle="${ph_labels}"/>'>
							<a onclick="tab_click1('ByATC_tab')" class="tabA" id="ByATC_tab" <%=alternateDisable %>><!--//added for  JD-CRF-0198 [IN:058599]-->
								<span class="tabAspan" id="ByATC_tabspan"><fmt:message key="ePH.ByATCClassification.label" bundle="${ph_labels}"/></span>
							</a>
						</li>
						</ul>
					<tr>
				</tr>
			</table>
			<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>

			<table cellpadding=0 cellspacing=0 width="100%" align="center"  border="0" id="drugCharacteristicsTable" name="drugCharacteristicsTable">
				<th colspan="4"><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></th>
				
				<tr style='<%=pre_alloc_appl_disp_style%>'> <!-- Added for MMS-DM-CRF-0177 -->
					<td  class="label" width="20%"><fmt:message key="Common.searchby.label" bundle="${common_labels}"/>&nbsp;</td>
					<td colspan="3" >
						<input type="radio" name="search_by" id="search_by"  value="G" onClick="displayLegend(this,'<%=identity%>')" <%=searchByGeneric%>><label class="label" ><fmt:message key="Common.GenericName.label" bundle="${common_labels}"/></label>
						<input type="radio" name="search_by" id="search_by" value="D" onClick="displayLegend(this,'<%=identity%>')" <%=searchByDrug%> <%=alternateDisable %>><label class="label"  ><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></label>
						<input type="radio" name="search_by" id="search_by" value="T" onClick="displayLegend(this,'<%=identity%>')" <%=searchByTrade%> <%=alternateDisable %>><label class="label" ><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></label>
						<input type="radio" name="search_by" id="search_by" value="C" onClick="displayLegend(this,'<%=identity%>')" <%=searchBySynonym%> <%=alternateDisable %>><label class="label" ><fmt:message key="ePH.CommonName.label" bundle="${ph_labels}"/></label>
						<input type="radio" name="search_by" id="search_by" value="A" onClick="displayLegend(this,'<%=identity%>')" <%=searchByAll%> <%=alternateDisable %>><label class="label" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></label>
					</td>
				</tr>
				<tr>
					<td  class="label" id="tdname" name="tdname"><%=name%></td>
					<td >&nbsp;<input type="hidden" name="code" id="code" >&nbsp;<input type="text" name="searchText" id="searchText" size="40" maxlength="40" value="<%= default_text %>"  onChange="clearCodeRelatedFields();searchCodeNew(searchText,'Name');" <%=alternateDisable %>><input type="button" value="?" class="button" onClick="searchCode(searchText,'Name')" style="align:center" name="btnSearch" id="btnSearch" <%=lookupdisable%>><!--//added for  JD-CRF-0198 [IN:058599]-->  <!--added searchCodeNew for NMC-JD-SCF-0159-->
<%
						String select = request.getParameter("select");
						String visibilityFlag="";
						//if((identity.equals("MedicationOrder") && !select.equals("D"))|| identity.equals("General")){
						if(identity.equals("MedicationOrder") || identity.equals("General")){
							visibilityFlag="visible";
						}
						else{
							visibilityFlag="hidden";
						}

						if(getDrugSearchName.equals("G"))
							visibilityFlag="visible";
%>
						<img src="../../eCommon/images/mandatory.gif" align="center" style="visibility:<%=visibilityFlag%>" id="imgMandatory"></img>
					</td>

                   <td class="label" ><fmt:message key="Common.searchby.label" bundle="${common_labels}"/></td>
				  <td class="label" width="17%">&nbsp;&nbsp;<select name="drug_search_by" id="drug_search_by" <%=strOrderType%>>
						<option value="S" selected><fmt:message key="Common.startsWith.label" bundle="${common_labels}"/></option>
						<option value="C"><fmt:message key="Common.contains.label" bundle="${common_labels}"/></option>
						<option value="E"><fmt:message key="Common.endsWith.label" bundle="${common_labels}"/></option>
                
                  </select>
				  </td>



				</tr>
				<tr>
					<td class="label" ><fmt:message key="ePH.Form.label" bundle="${ph_labels}"/></td>
<%			
			//Added for MMS-DM-CRF-0177
				if(pre_alloc_appl) {
%>
					<td nowrap>&nbsp;&nbsp;<select name="form_desc" id="form_desc" <%=strOrderType%> onChange="saveFormCode(this);"> <!-- Modified for MMS-DM-CRF-0177 -->
					<%=bean.getListValuesNew(locale) %>
					</select></td>
<%
					}
				else{ 
%>
					<td nowrap>&nbsp;&nbsp;<input type="text" name="form_desc" id="form_desc" value="<%=form_desc%>" ><input type="button" value="?" class="button" name="btnformsearch" id="btnformsearch"  onClick="searchform()" ></td>
<%
					} //Added for MMS-DM-CRF-0177

					if(identity.equals("MedicationOrder")){	
%>
						<td class="label"  width="18%"><fmt:message key="Common.OrderType.label" bundle="${common_labels}"/></td>
						<td class="label" width="17%">&nbsp;&nbsp;<select name="order_type" id="order_type" <%=strOrderType%>>
						<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
							for(int i=0;i<arrListOrderType.size();i=i+2){
								String strOrderTypeSelect ="";
								if(!order_type_code.equals("")){
									if (order_type_code.equals(arrListOrderType.get(i))){
										strOrderTypeSelect = "selected";
									}
								}
%>
								<option value="<%=arrListOrderType.get(i)%>" <%=strOrderTypeSelect%>><%=arrListOrderType.get(i+1)%></option>
<%
							}
%>
						</select>
						</td>
<%
					}
					else { 	
%>
						<td class="label" colspan="2">&nbsp;</td>
<%	
					}
%>
					 <input type="hidden" name="form_code" id="form_code"	value="<%=form_code%>">	
							
				</tr>
				<tr>
					<td  class="label"><fmt:message key="Common.Strength.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;<input type="text" name="strength_value" id="strength_value" size="4" maxlength="4" class="NUMBER" onBlur="CheckNum(this);CheckZero(this);">&nbsp;
					<select name="strength_uom" id="strength_uom">
						<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
						for (int i=0;i<arrListStrength.size()-1;i++){
%>
							<option value="<%=arrListStrength.get(i)%>"><%=arrListStrength.get(++i)%></option>
<%
						}
%>
					</select>
					</td>
					<%
					if(identity.equals("MedicationOrder")){
%>
						<td class="label" ><fmt:message key="Common.RestrictbyService.label" bundle="${common_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<input type="checkbox" name="res_by_service" id="res_by_service" <%=res_by_service_checked%>></td>
<%	
					}
					else {	
%>
						<td class="label" colspan="2">&nbsp;</td>
<%	
					}
%>	

					</tr>
					<tr>
						<td  class="label"><fmt:message key="Common.Route.label" bundle="${common_labels}"/></td>
						<td nowrap >&nbsp;&nbsp;<input type="text" name="route_desc" id="route_desc" value="<%=route_desc%>"  ><input type="button" value="?" class="button" name="btnformsearch" id="btnformsearch"  onClick="searchroute()" ></td>
<%
					if(identity.equals("MedicationOrder")){
%>
						<td class="label" >&nbsp;&nbsp;<fmt:message key="ePH.InFormularyOnly.label" bundle="${ph_labels}"/></td>
						<td class="label">&nbsp;&nbsp;<input type="checkbox" name="in_formulary_yn" id="in_formulary_yn" value="E" checked></td>
<%	
					}
					else {	
%>
						<td class="label" colspan="2">&nbsp;</td>	
<%	
					}
%>						 <input type="hidden" name="route_code" id="route_code"	value="<%=route_code%>">
						 
					</tr>
<%					if(identity.equals("MedicationOrder")){
						String priviligeCheckValue = bean.getDefaultPriviligeDrugSelection(facility_id)==null?"":bean.getDefaultPriviligeDrugSelection(facility_id);
						String selected ="";
						String NPBReqApp ="";
						if((iv_prep_yn == null || iv_prep_yn.equals("")) && !calledfrom.equals("DIRECT") )
							NPBReqApp = bean.getNPBReqForPatient(patient_id); //added for Bru-HIMS-CRF-070[IN029935] 

				//	out.println("@@priviligeCheclValue-->"+priviligeCheclValue);//ePH.PrivilegeCheck.label
%>
							<input type = 'hidden' name='drugPriviligecheckHidden' id='drugPriviligecheckHidden' value ='<%=priviligeCheckValue%>' />
							<tr>
								<td class="label" ><fmt:message key="ePH.PrivilegeCheck.label" bundle="${ph_labels}"/> </td>
								 <td class="label">&nbsp;<select name="priviligeCheck" id="priviligeCheck">
								 <%if(priviligeCheckValue.equals("A"))
										selected ="selected";
									else
										selected ="";
									%>
								 <option value="A" <%=selected %> ><fmt:message key="ePH.ALLDRUGS.label" bundle="${ph_labels}"/></option> 
								 <%if(priviligeCheckValue.equals("S"))
										selected ="selected";
									else
										selected ="";
									%>
								<option value="S" <%=selected %>><fmt:message key="ePH.SELFPRIVILEGEDRUGS.label" bundle="${ph_labels}"/></option>
							</select>
							</td>
							<td class="label" ><fmt:message key="ePH.NBPDRUG.label" bundle="${ph_labels}"/> </td>
<%
							if(NPBReqApp.equals("Y")){ //added for Bru-HIMS-CRF-070[IN029935] -Start
%>
								<td class="label">&nbsp;&nbsp;<input type="checkbox" checked name="npb_drug" id="npb_drug" value="E"></td>
<%
							}
							else{
%>
								<td class="label">&nbsp;&nbsp;<input type="checkbox" name="npb_drug" id="npb_drug" value="D" disabled></td>
<%
							} //added for Bru-HIMS-CRF-070[IN029935]  -End
%>
							  </tr>
<%				
					}
%>
					<tr>
					<!-- Added for TFS id:-16341 start-->
					<%  //if(pre_alloc_appl && default_disp_locn_select_appl){ // condition changed for NMC-JD-CRF-0197
						if( (alw_disp_loc_drug_search_yn!=null && alw_disp_loc_drug_search_yn.equalsIgnoreCase("Y") && default_disp_locn_select_appl && !iv_prep_yn.equals("5")) ){ // condition changed for NMC-JD-CRF-0197
					%>
					<td  class="label" nowrap><fmt:message key="ePH.DispenseLocation.label" bundle="${ph_labels}"/></td>
					<td class="fields">&nbsp;
					<select name="default_disp_locn" id="default_disp_locn"  onChange="setDefaultDispLocn(this,'<%=bean_id%>','<%=bean_name%>')" > <%=bean.getListValues(sql,disp_locn_params,default_disp_locn) %> </select> <img src="../../eCommon/images/mandatory.gif" align="center" ></img>
					</td>
					
<%}//Added for TFS id:-16341 end
if(alternateOrder.equals("Y")){//added for  JD-CRF-0198 [IN:058599]
%>
						<td align="right" colspan="4">
						<input type="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="searchBasedOnCriteriaForAlternate('<%=alternateOrder%>')" name="btnCriteriaSearch" id="btnCriteriaSearch">
<%
}else{//added for  JD-CRF-0198 [IN:058599]
%>
						<td align="right" colspan="4">
						<input type="button" value='<fmt:message key="Common.search.label" bundle="${common_labels}"/>' class="button" onClick="searchBasedOnCriteria('Search','<%=identity%>','<%=normalRx_yn%>')" name="btnCriteriaSearch" id="btnCriteriaSearch"> <!-- normal Rx added for GHL-CRF-0549-->
<%} %>
<%
					if(identity.equals("General")){
%>
						<input type="button" value='<fmt:message key="ePH.OtherCriteria.label" bundle="${ph_labels}"/>' class="button" onClick="showOtherCriteria()">
<%
					}
					String  modalYN			=   request.getParameter("modalYN");
					if(modalYN!=null){
						if(modalYN.equals("N") || ((modalYN).trim()).equals("null")){
							modalYN="N";
						}
					}
					if(!modalYN.equals("N")){
%>
						<input type="button" value='<fmt:message key="Common.close.label" bundle="${common_labels}"/>'  class="button" onClick="closew()">
<%
					}
%>
					</td>
				</tr>
			</table>
			<input type="hidden" name="SearchCriteria" id="SearchCriteria" value="SearchCriteria">
			<input type="hidden" name="bean_id" id="bean_id" value="<%= bean_id %>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%= bean_name %>">
			<input type="hidden" name="SQL_PH_DRUG_SEARCH_GENERIC" id="SQL_PH_DRUG_SEARCH_GENERIC" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT1")%>">
			<input type="hidden" name="SQL_PH_DRUG_SEARCH_DRUG" id="SQL_PH_DRUG_SEARCH_DRUG" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT2")%>">
			<input type="hidden" name="SQL_PH_DRUG_SEARCH_TRADE" id="SQL_PH_DRUG_SEARCH_TRADE" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT3")%>">		
			<input type="hidden" name="SQL_PH_DRUG_SEARCH_FORM" id="SQL_PH_DRUG_SEARCH_FORM" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT4A")%>">
			<input type="hidden" name="SQL_PH_DRUG_SEARCH_ROUTE" id="SQL_PH_DRUG_SEARCH_ROUTE" value="<%=PhRepository.getPhKeyValue("SQL_PH_DRUG_SEARCH_SELECT6A")%>">
			<input type="hidden" name="identity" id="identity" value="<%=identity%>">
			<input type="hidden" name="select" id="select" value="<%=selectedOption%>">
			<input type="hidden" name="default_text" id="default_text" value="<%=default_text%>">
			<input type="hidden" name="service_code" id="service_code" value="<%=service_code%>">
			<input type="hidden" name="locale" id="locale" value="<%=locale%>">
			<input type="hidden" name="normalRx_yn" id="normalRx_yn" value="<%=normalRx_yn%>"><!--added for GHL-CRF-0549 -->
			<input type="hidden" name="pre_alloc_check" id="pre_alloc_check" value="<%=pre_alloc_check%>"><!--added for MMS-DM-CRF-0177 -->
			<input type="hidden" name="default_disp_locn_select_yn" id="default_disp_locn_select_yn" value="<%=default_disp_locn_select_yn%>"><!-- Added for TFS id:-16341 -->
			
			<input type="hidden" name="generic_trade" id="generic_trade" value=""><!--added for MMS-DM-CRF-0177 -->
		</form>
	</body>
	<script language="javascript">
		document.getElementById("searchText").focus();
		/* Added for MMS-DM-CRF-0177 */
		//Modified for TFS id:-16341 start
		if(document.frmDrugNameCommonLookupSearchCriteria.pre_alloc_check.value == "Y" && document.frmDrugNameCommonLookupSearchCriteria.default_disp_locn_select_yn.value == "Y"){
			var searchText = document.getElementById("searchText").value;
			var disp_locn_code=document.getElementById("default_disp_locn").value;
			searchCode(searchText,'Name');
			if(disp_locn_code!=""){
				document.getElementById("btnCriteriaSearch").click();
			}
			
			
		}
		else if(document.frmDrugNameCommonLookupSearchCriteria.pre_alloc_check.value == "Y"){
			var searchText = document.getElementById("searchText").value;
			searchCode(searchText,'Name');
			document.getElementById("btnCriteriaSearch").click();
		}
		//Modified for TFS id:-16341 end
		else
			{
			if(document.getElementById("searchText").value != ""){
				document.getElementById("btnCriteriaSearch").click();
			}
		}
		/* Added for MMS-DM-CRF-0177 */
	</script>
<Script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></Script>



</html>
<%
	putObjectInBean(bean_id,bean,request);
%>

