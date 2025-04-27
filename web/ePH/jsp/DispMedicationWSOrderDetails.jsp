<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*,java.text.DecimalFormat, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
<%
		request.setCharacterEncoding("UTF-8");
//Added  for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/common.js"></script>
		<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		String bean_id = "DispMedicationBean" ;
		String bean_name = "ePH.DispMedicationBean";
		DispMedicationBean bean = (DispMedicationBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(locale);
		bean.clearOrderedQty();

		String facility_id					= (String) session.getValue("facility_id");
		String param_bean_id				= "@DrugInterfaceControlBean";
		String param_bean_name				= "ePH.DrugInterfaceControlBean";
		DrugInterfaceControlBean param_bean	= (DrugInterfaceControlBean)getBeanObject( param_bean_id, param_bean_name, request );
		param_bean.setLanguageId(locale);

		String drug_db_interface_yn			= param_bean.getDrugDBInterface_yn(facility_id); 
		param_bean.clear();

		String store_code = bean.getStoreCode();
		String patient_id = request.getParameter("patient_id");
		String order_id   = request.getParameter("order_id");
		String order_line_no = request.getParameter("order_line_no");
		//String disp_stage = request.getParameter("disp_stage");
		Hashtable result = bean.showWSOrderDetails(order_id);
		ArrayList ingredients = (ArrayList)result.get("ingredients");

		String sColumnName		= "";
		String sShowHideColumns = "style='display:none'";
		//String sMakeReadonly	= "false";
		String sIngredientsType = "S";
		String ip_scope             = bean.getIPScope();  // Added for ML-MMOH-CRF-0434 [IN057356]
		if(bean.getOrderType().equals("CO") && ingredients.size()>0 ){
			if(ingredients.get(8).equals("R")){
				sColumnName			= SpringCacheBean.getLabel(pageContext,"ePH.Ratio.label","ph_labels.resources.Labels");		
				sShowHideColumns	= "style='display:All'";
				//sMakeReadonly		= "true";
			}
			else if(ingredients.get(8).equals("P")){
				sColumnName			= SpringCacheBean.getLabel(pageContext,"ePH.Percentage.label","ph_labels.resources.Labels");
				sShowHideColumns	= "style='display:All'";
				//sMakeReadonly		= "true";
			}
		}
		//if(bean.checkHold(order_id,order_line_no)) 
			//continue;
		ArrayList fluids = (ArrayList)result.get("fluids");
		
		/*String worksheet_id = bean.getWorksheetID();
		if(((bean.getHTWSAllocateBatches()).size()==0)&&(!worksheet_id.equals(""))){
			bean.setWSDrugDetails(order_id,worksheet_id);
			bean.setWSBatchDetails(order_id);
		}*/
		String classvalue = "";
		String bean_id_1 = "DispMedicationAllStages" ;
		String bean_name_1 = "ePH.DispMedicationAllStages";
		DispMedicationAllStages bean_1 = (DispMedicationAllStages)getBeanObject( bean_id_1, bean_name_1, request ) ;
		bean_1.setLanguageId(locale);
		ArrayList multi_drugs = new ArrayList();
		if(order_line_no!=null){
			multi_drugs	=	bean_1.getMultiDrugs(patient_id,order_id,order_line_no);
		}
		int rowCount = 1;	
		String drug_code, drug_desc, order_line_num, qty_value, qty_unit, fluid_external_prod_id, sPresQty, sPresUOM, encoded_drug_desc, ingredient_external_prod_id, sReqQty, sDerivedQty, sDerivedUom, multi_strength;
		String alt_drug_code, alt_drug_desc, alt_qty, alt_qty_uom, sRatioOrPercent;

%>
		<form name="frmDispMedicationWSOrderDetails" id="frmDispMedicationWSOrderDetails">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1" id="wsorderdetailstable">
				<tr>
					<td  class="COLUMNHEADER" class="label" colspan="4"><fmt:message key="ePH.DrugDetails/Quantity.label" bundle="${ph_labels}"/></td>
				</tr>
<%
				if(fluids.size()>0){
					bean_1.addPatient(patient_id);
					bean_1.addPrescription(patient_id,order_id);			
%>
					<tr>
						<br>
						<td  style="background:#FDE6D0;font-size:10" width="75%"><b><fmt:message key="ePH.Fluid.label" bundle="${ph_labels}"/></b></td>
						<td  style="background:#FDE6D0;font-size:10" width="15%" ><b><fmt:message key="ePH.ReqQty.label" bundle="${ph_labels}"/></b></td>
						<td  style="background:#FDE6D0;font-size:10"><b><fmt:message key="Common.Quantity.label" bundle="${common_labels}"/></b></td>
					</tr>
<%
					for (int i=0;i<fluids.size();i=i+10){
						if ( rowCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;
						drug_code					= (String)fluids.get(i);
						drug_desc					= (String)fluids.get(i+1);
						order_line_num				= (String)fluids.get(i+3);
						qty_value					= (String)fluids.get(i+4);
						qty_unit						= (String)fluids.get(i+5);
						fluid_external_prod_id		= (String)fluids.get(i+7);
						sPresQty						= (String)fluids.get(i+8);
						sPresUOM						= (String)fluids.get(i+9);
						encoded_drug_desc =java.net.URLEncoder.encode(drug_desc,"UTF-8");
						if((bean_1.loadHoldRemarks(order_id,order_line_num).isEmpty() && ip_scope.equals("A")) || !(ip_scope.equals("A"))) {   // if condition Added for ML-MMOH-CRF-0434 [IN057356]
%>
						<tr>
							<td  class="<%=classvalue%>">&nbsp;&nbsp;&nbsp;&nbsp;
<%
							if(!bean_1.checkHold(order_id,order_line_num)){
%>
								<label style='font-size:9' id="fluid_name<%=rowCount%>" style='cursor:pointer;color:blue;font-size:9' onClick="callCalSection('<%=drug_code%>','<%=encoded_drug_desc%>','<%=qty_value%>','<%=rowCount%>','F','<%=order_line_num%>','<%=qty_unit%>')"><%=drug_desc%></label>
<%
							}
							else{
%>
								<label style='font-size:9' id="fluid_name<%=rowCount%>" style='font-size:9' ><%=drug_desc%></label>
<%
							}
%>
							<label style='font-size:9;display:none' id="lbl_fluid_name<%=rowCount%>"><%=drug_desc%></label>
<%
							if ((fluid_external_prod_id!=null)&& !(fluid_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
								<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=fluid_external_prod_id%>','<%=encoded_drug_desc%>')"></img>
<%  
							}
%>
							</td>
							<td  class="<%=classvalue%>">
								<label style='font-size:9;'><%=sPresQty%> <%=bean.getUomDisplay(facility_id,sPresUOM)%></label>
							</td>	
							<td  class="<%=classvalue%>">
								<label style='font-size:9;'><%=qty_value%> <%=bean.getUomDisplay(facility_id,qty_unit)%> </label>
							</td>
						</tr>
<%
						bean.setOrderedQty(order_line_num,qty_value);
						rowCount++;
					}
				   }
				}
				if(ingredients.size()>0){
%>
					<tr >
						<td class="white" colspan="2" >&nbsp;</td>
					</tr>
					<tr>
						<td  style="background:#FDE6D0;font-size:10" width="55%"><b>(<fmt:message key="ePH.Ingredient.label" bundle="${ph_labels}"/>)</b></td>
						<td  style="background:#FDE6D0;font-size:10" width="15%" <%=sShowHideColumns%>><b><%=sColumnName%></b></td>
						<td  style="background:#FDE6D0;font-size:10" width="15%" <%=sShowHideColumns%>><b><fmt:message key="ePH.ReqQty.label" bundle="${ph_labels}"/></b></td>
<%		
						if(!sShowHideColumns.contains("All")){
%>
							<td  style="background:#FDE6D0;font-size:10" width="15%" ><b><fmt:message key="ePH.ReqQty.label" bundle="${ph_labels}"/></b></td>
<%		
						}
%>
						<td  style="background:#FDE6D0;font-size:10" width="15%"><b><fmt:message key="ePH.DerivedQty.label" bundle="${ph_labels}"/></b></td>
					</tr>
<%
					String sFinalQty					= (String)ingredients.get(11);
					String sFinalUom					= (String)ingredients.get(12);
					for (int i=0;i<ingredients.size();i=i+15){
						if ( rowCount % 2 == 0 )
							classvalue = "QRYODD" ;
						else
							classvalue = "QRYEVEN" ;

						drug_code		= (String)ingredients.get(i);
						drug_desc		= (String)ingredients.get(i+1);
						order_line_num	= (String)ingredients.get(i+3);
						qty_value		= (String)ingredients.get(i+4);
						qty_unit			= (String)ingredients.get(i+5);
						ingredient_external_prod_id= (String)ingredients.get(i+7);
						encoded_drug_desc =java.net.URLEncoder.encode(drug_desc,"UTF-8");
						sRatioOrPercent="";
						sReqQty="";
						sDerivedQty="";
						sDerivedUom="";
						sPresQty="";
						sPresUOM="";

						if(sShowHideColumns.contains("All")){ // if its a compound order
							if(ingredients.get(i+8).equals("P")){ //For percentage
								// If the percentage column is null then the ingredient is prescribed with Base Qty. So "Base Qty" should be displayed instead of the percentage.
								sRatioOrPercent		= ingredients.get(i+9).toString().equals("")?SpringCacheBean.getLabel(pageContext,"ePH.BaseQty.label","ph_labels.resources.Labels"):ingredients.get(i+9).toString()+" %";
								sIngredientsType	= "P";
							}
							else{
								sRatioOrPercent		= (String)ingredients.get(i+9);
								sIngredientsType	= "R";
							}

							sReqQty					= retunFormatedInt((String)ingredients.get(i+10));
							sDerivedQty				= retunFormatedInt((String)ingredients.get(i+13));
							sDerivedUom				= (String)ingredients.get(i+14);
						}
						else{
							sPresQty				= (String)ingredients.get(i+13);
							sPresUOM				= (String)ingredients.get(i+14);
						}

						multi_strength ="N";
						bean_1.addDrugs(patient_id,order_id,drug_code,multi_strength,order_line_num);	
						
						if((bean_1.loadHoldRemarks(order_id,order_line_num).isEmpty() && ip_scope.equals("A")) || !(ip_scope.equals("A")))  {  // if condition Added for ML-MMOH-CRF-0434 [IN057356]
%>
						<tr>
							<td  class="<%=classvalue%>">
								<input type="hidden" name="order_line_no<%=rowCount%>" id="order_line_no<%=rowCount%>" value="<%=order_line_num%>">
<%
								if(multi_strength.equals("Y")){
%>
									<img src='../../ePH/images/altenate.jpg' height='15' width='15' style="cursor:pointer" onClick="callMultiStrength('<%=drug_code%>','<%=encoded_drug_desc%>','<%=patient_id%>','<%=order_id%>','<%=order_line_num%>','WORKSHEET','<%=store_code%>','<%=qty_value%>','')" title="Alternate Drug">
<%
								}
								else{
%>
									&nbsp;
<%
								}
								if(!bean_1.checkHold(order_id,order_line_num)){
%>
									<label  onClick="callCalSection('<%=drug_code%>','<%=encoded_drug_desc%>','<%=qty_value%>','<%=rowCount%>','I','<%=order_line_num%>','<%=qty_unit%>')" style='cursor:pointer;color:blue;font-size:9' id="ingredient_name<%=rowCount%>"><%=drug_desc%></label>
<%    
								}
								else{
%>
									<label   style='font-size:9' id="ingredient_name<%=rowCount%>"><%=drug_desc%></label>
<%
								}
%>
								<label  style='font-size:9;display:none' id="lbl_ingredient_name<%=rowCount%>"><%=drug_desc%></label>
<% 
								if ((ingredient_external_prod_id!=null)&& !(ingredient_external_prod_id.equals(""))&& drug_db_interface_yn.equals("Y")){
%>
									<img style="cursor:pointer;filter:Chroma(Color=#FFFFFF)" src="../../ePH/images/info.gif" height='20'  width='20' onClick="showDrugInfo('<%=ingredient_external_prod_id%>','<%=encoded_drug_desc%>')"></img>
<%
								}
%>
								</td>
								<td  class="<%=classvalue%>"  <%=sShowHideColumns%>>
									<label style='font-size:9;'><%=sRatioOrPercent%></label>
								</td>		
								<td  class="<%=classvalue%>"  <%=sShowHideColumns%>>
									<label style='font-size:9;'><%=sReqQty%> <%=bean.getUomDisplay(facility_id,sFinalUom)%></label>
								</td>	
<%
								if(!sShowHideColumns.contains("All")){ // if its not a compound order then show the prescribed uom as req qty
%>
									<td  class="<%=classvalue%>">
										<label style='font-size:9;'><%=sPresQty%> <%=bean.getUomDisplay(facility_id,sPresUOM)%></label>
									</td>				
<%
								}
								if(sShowHideColumns.contains("All")){ // if its a compound order
%>
									<td  class="<%=classvalue%>">
										<label style='font-size:9;'><%=sDerivedQty%> <%=bean.getUomDisplay(facility_id,sDerivedUom)%></label>
									</td>	
<%
								}
								else {
%>
									<td  class="<%=classvalue%>">
										<label style='font-size:9;'><%=qty_value%> <%=bean.getUomDisplay(facility_id,qty_unit)%></label>
									</td>		
<%	
								}
%>
							</tr>
<%
							bean.setOrderedQty(order_line_num,qty_value);
							if(multi_drugs.size()>0){
								int altRecCount=0;
								for(int n=0; n<multi_drugs.size(); n+=5){ 
									altRecCount++;
									alt_drug_code			=	(String)multi_drugs.get(n);
									alt_drug_desc			=   (String)multi_drugs.get(n+1);
									alt_qty=(String)multi_drugs.get(n+3);
									alt_qty_uom =(String)multi_drugs.get(n+4);
									encoded_drug_desc =java.net.URLEncoder.encode(alt_drug_desc,"UTF-8");
%>
									<tr>
										<td>
											<label style='background-color:#CC99CC;'>&nbsp;&nbsp;</label>
											<label style='cursor:pointer;color:blue;font-size:9' onClick="callCalSection('<%=alt_drug_code%>','<%=encoded_drug_desc%>','<%=alt_qty%>','<%=altRecCount%>','IM','<%=order_line_num%>','<%=alt_qty_uom%>')" id="alt_ingredient_name<%=altRecCount%>"><%=alt_drug_desc%></label>
											<label style='font-size:9;display:none' id="lbl_alt_ingredient_name<%=altRecCount%>"><%=alt_drug_desc%></label>
										</td>
										<td>
											<label style='font-size:9;'><%=alt_qty%> <%=bean.getUomDisplay(facility_id,alt_qty_uom)%></label>
										</td>
									</tr>
<%
							}
						}
						rowCount++;
					}
				}
%>
					<tr>
						<td colspan="2" style="text-align:right" <%=sShowHideColumns%>><fmt:message key="ePH.TotalQuantity.label" bundle="${ph_labels}"/>&nbsp;&nbsp;</td>
						<td><label style='font-size:9;' <%=sShowHideColumns%>><%=sFinalQty%> <%=bean.getUomDisplay(facility_id,sFinalUom)%></label></td>
						<TD <%=sShowHideColumns%>>&nbsp;</TD>
					</tr>
<%
				}	
%>	
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>">
			<input type="hidden" name="tot_num_of_drugs" id="tot_num_of_drugs" value="<%=rowCount-1%>">
			<input type="hidden" name="selected_drug" id="selected_drug" value="">
			<!-- <input type="hidden" name="MakeReadOnly" id="MakeReadOnly" value=""> -->
			<input type="hidden" name="IngredientsType" id="IngredientsType" value="<%=sIngredientsType%>">
			<input type="hidden" name="orderType" id="orderType" value="<%=bean.getOrderType()%>">
		</form>
	</body>
</html>
<%
	if(fluids.size()>0){
%>
		<script language="javascript">
		document.getElementById("fluid_name1").click();
		document.getElementById("fluid_name1").style.backgroundColor	= "#FDE6D0";
		document.getElementById("selected_drug").value="1";
		/*for(var i=1;i<=document.getElementById("tot_num_of_drugs").value;i++){
			if(eval("document.getElementById("ingredient_name")"+i)!=null){
				alert("inside if")
				eval("document.getElementById("ingredient_name")"+i).style.display="none";
				eval("document.getElementById("lbl_ingredient_name")"+i).style.display="inline";
			}else if(eval("document.getElementById("alt_ingredient_name")"+i)!=null){
				alert("inside else if");
				eval("document.getElementById("alt_ingredient_name")"+i).style.display="none";
				eval("document.getElementById("lbl_alt_ingredient_name")"+i).style.display="inline";
			}
		}*/
		</script>
<%
	}
	else if(ingredients.size()>0){
%>
		<script language="javascript">
        document.getElementById("ingredient_name1").click();
	    document.getElementById("ingredient_name1").style.backgroundColor	= "#FDE6D0";
	    document.getElementById("selected_drug").value="1";
       </script>

<%
	}
%>
<%! 
	DecimalFormat dfToInteger = new DecimalFormat("#.####");
	private String retunFormatedInt(String sValue){
		if(sValue != null && !sValue.equals("")){
			return dfToInteger.format(Double.parseDouble(sValue));
		}
		return "";
	}
%>
<%
putObjectInBean(param_bean_id,param_bean,request);
putObjectInBean(bean_id,bean,request);
putObjectInBean(bean_id_1,bean_1,request);
%>

