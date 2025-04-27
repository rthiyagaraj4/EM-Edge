<!DOCTYPE html>
<%-- saved on 26/10/2005 --%>
<% /*
Date       		   Edit History      Name      			Rev.Date		Rev.Name		                   Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
	?			   ?				 ?				    ?			    ?								   ?
29/01/2019		   IN068728		     Devindra				 		                                       ML-MMOH-CRF-1266 [IN:068728]
---------------------------------------------------------------------------------------------------------------------------------------------------------
*/ %>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8 " import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<!-- <script language="JavaScript" src="../../eCommon/js/MstCodeCommon.js"></script> -->
	<!-- <script language="Javascript" src="../../eCommon/js/messages.js"></script> -->
	<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
	<!-- <script language="JavaScript" src="../../ePH/js/PhMessages.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 -->
	
</head>
<%
	try{
	String	bean_id		=	"TPNUOMConstBean" ;
	String	bean_name	=	"ePH.TPNUOMConstBean";
	TPNUOMConstBean bean= (TPNUOMConstBean)getBeanObject( bean_id,bean_name,request) ;
	bean.clear();
	bean.setLanguageId(locale);
	Hashtable result = bean.paintConstituents(locale);	

	ArrayList group_codes = bean.getGroupCodes();

	Hashtable initial_data = bean.loadInitialData(locale);
	ArrayList arr_list_pres_base_unit = (ArrayList)initial_data.get("PRES_BASE_UNIT");

	Hashtable order_unit=bean.getForOrderingUnit();


	Hashtable ht_data_for_update =bean.loadDataForUpdate();
	


	Hashtable ht_quantity_uom_parameters = (Hashtable)ht_data_for_update.get("ht_quantity_uom_parameters");    
	

	String color = "";
   
%>
<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<form name="formTpnUomConstUOMQuantity" id="formTpnUomConstUOMQuantity" >
	<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
		<tr>
			<th align="left" colspan="5"><fmt:message key="ePH.QuantityUnitofMeasureforTPNConstituents.label"  bundle="${ph_labels}"/></th>
		</tr>
		<tr>
						<td>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<tr>
					<th align="right" class="white" width="29%"></th>
						<th align="center" class="white" width="20%"><b><fmt:message key="ePH.StandardRegimen.label" bundle="${ph_labels}"/> </b></th>		
						<th align="center" class="white" width="51%"><b><fmt:message key="ePH.NonStandardRegimen.label" bundle="${ph_labels}"/></b></th>					</tr>
				</table>
				</td>
		</tr>			 
		 
		<tr>
			<td>
				<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
					<tr>
						<th align="left" class="white" width="29%"><b><fmt:message key="ePH.Constituents.label" bundle="${ph_labels}"/></b></th>
						<th align="left" class="white" width="20%"><b><fmt:message key="ePH.RegimenSetup.label" bundle="${ph_labels}"/></b></th>
						<th align="left" class="white" width="17%"><b><fmt:message key="ePH.ConstituentsLimit.label" bundle="${ph_labels}"/></b></th>
						<th align="left" class="white" width="17%"><b><fmt:message key="Common.orderBy.label" bundle="${common_labels}"/> </b></th>
						<th align="left" class="white" width="17%"><b><fmt:message key="ePH.PreparationatPharmacy.label" bundle="${ph_labels}"/></b></th>
					</tr>
				<%
					int recCount = 0;
					int colorCount = 0;
					String classvalue = "";
					String srl_no = "";

					for (int i=0;i<group_codes.size();i=i+3){
						recCount++;
						String group_code = (String)group_codes.get(i);
						String for_order_unit_gp = "";
						if(order_unit.get(group_code) !=null)
							for_order_unit_gp=(String)order_unit.get(group_code);
						String for_order_unit_gp_abs	= "";
						String for_order_unit_gp_weight = "";
						
						if(for_order_unit_gp.equals("W")){
							for_order_unit_gp_abs	=	"";
							for_order_unit_gp_weight =  "selected";
						}else{
							for_order_unit_gp_abs	=	"selected";
							for_order_unit_gp_weight =  "";
						}

						ArrayList arr_list = (ArrayList)result.get(group_code);
						if(arr_list.size()==0){
							srl_no = (String)group_codes.get((i+2));
							colorCount++;
							ArrayList arr_list_qty_uom = (ArrayList)ht_quantity_uom_parameters.get(srl_no);
							if(arr_list_qty_uom==null) arr_list_qty_uom = new ArrayList();
							
							if(arr_list_qty_uom.size()>0){
								color = "red";
								for_order_unit_gp=(String )arr_list_qty_uom.get(3);
								if(for_order_unit_gp.equals("W")){
									for_order_unit_gp_abs	=	"";
									for_order_unit_gp_weight =  "selected";
								}else{
									for_order_unit_gp_abs	=	"selected";
									for_order_unit_gp_weight =  "";
								}
							}else{
								color = "";
							}

							if ( colorCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
				%>
					<input type="hidden" name="const_group_code<%=colorCount%>" id="const_group_code<%=colorCount%>" value="<%=group_code%>">				
					<input type="hidden" name="srl_no<%=colorCount%>" id="srl_no<%=colorCount%>" value="<%=srl_no%>">				
					<input type="hidden" name="group_or_individual_ind<%=colorCount%>" id="group_or_individual_ind<%=colorCount%>" value="G">				
					<tr >
						<td class="<%=classvalue%>" width="29%" style="color:<%=color%>;font-size:11"><b><%=group_codes.get(i+1)%></b></td>
						<td class="<%=classvalue%>" width="20%">
							<select name="regimen_setup_unit<%=colorCount%>" id="regimen_setup_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
								String strSelect = "";
								if(arr_list_qty_uom.size()>0){
									if(((String)arr_list_qty_uom.get(1)).equals((String)arr_list_pres_base_unit.get(ii))){
										strSelect="selected";
									}
								} 

								if(group_code.equals("FL") && arr_list_pres_base_unit.get(ii).equals("ML")){

								%>
									<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>>
									<%=arr_list_pres_base_unit.get(ii+1)%>
									</option>
								<%} else if(group_code.equals("MN") && ( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML") )){
								%>
									<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>>
									<%=arr_list_pres_base_unit.get(ii+1)%>
									</option>
								<%
								}
								else { // else Added for ML-MMOH-CRF-1126 - Start

									%>
										<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>

									<%
									 } // esle Added for ML-MMOH-CRF-1126 - End

							}
						%>
							</select>
						</td>
						<td class="<%=classvalue%>" width="17%">
							<select name="order_qty_limit_unit<%=colorCount%>" id="order_qty_limit_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
								String strSelect = "";
								if(arr_list_qty_uom.size()>0){
									if(((String)arr_list_qty_uom.get(2)).equals((String)arr_list_pres_base_unit.get(ii))){
										strSelect="selected";
									}
								}
						if(group_code.equals("FL") && arr_list_pres_base_unit.get(ii).equals("ML")){

						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>
						<%} else if(group_code.equals("MN") && ( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML"))){

						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>

						<%
							}
						else { // else Added for ML-MMOH-CRF-1126 - Start

							%>
								<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>

							<%
							 } // else Added for ML-MMOH-CRF-1126 - End
						}
						%>
							</select>
						</td>						
						
						<td class="<%=classvalue%>" width="17%">
							<select name="ordering_unit<%=colorCount%>" id="ordering_unit<%=colorCount%>" >
							
						<option value="A" <%=for_order_unit_gp_abs%>><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/>             </option>
						<option value="W" <%=for_order_unit_gp_weight%>><fmt:message key="Common.weight.label" bundle="${common_labels}"/>           </option>

					</select>
								
						</td>
						<td class="<%=classvalue%>" width="17%">
							<select name="prep_unit<%=colorCount%>" id="prep_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
							String strSelect = "";
							if(arr_list_qty_uom.size()>0){
								if(((String)arr_list_qty_uom.get(4)).equals((String)arr_list_pres_base_unit.get(ii))){
									strSelect="selected";
								}
							}
						if(arr_list_pres_base_unit.get(ii).equals("ML") ){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>   </option>
						<%
							}
						}
						%>
							</select>
						</td>
					</tr>
				<%
						}else{	

							ArrayList arr_list_qty_uom = null; 
						
							String for_order_unit = (String)arr_list.get(3);
							String order_unit_absolute ="";
							String order_unit_weight   ="";
							String order_unit_volume = "";
							if(for_order_unit.equals("P")){
								order_unit_weight="";
								order_unit_absolute="";
								order_unit_volume = "selected";
							}
							else if(for_order_unit.equals("W")){
								order_unit_weight="selected";
								order_unit_absolute="";
								order_unit_volume = "";
							}else{
								order_unit_weight="";
								order_unit_absolute="selected";
                                order_unit_volume = "";
							}

							srl_no = (String)group_codes.get((i+2));
								colorCount++;
								if ( colorCount % 2 == 0 )
									classvalue = "QRYODD" ;
								else
									classvalue = "QRYEVEN" ;
								arr_list_qty_uom = (ArrayList)ht_quantity_uom_parameters.get(srl_no);
								if(arr_list_qty_uom==null) arr_list_qty_uom = new ArrayList();
								if(arr_list_qty_uom.size()>0){
									color = "red";
									for_order_unit=(String )arr_list_qty_uom.get(3);
							if(for_order_unit.equals("P")){
								      order_unit_weight="";
								      order_unit_absolute="";
								      order_unit_volume = "selected";
							     }
									else if(for_order_unit.equals("W")){
										order_unit_absolute	=	"";
										order_unit_weight =  "selected";
										order_unit_volume ="";
									}else{
										order_unit_absolute	=	"selected";
										order_unit_weight =  "";
										order_unit_volume ="";
									}
							}else{
								color = "";
							}
				%>
					<input type="hidden" name="const_group_code<%=colorCount%>" id="const_group_code<%=colorCount%>" value="<%=group_code%>">
					<input type="hidden" name="srl_no<%=colorCount%>" id="srl_no<%=colorCount%>" value="<%=srl_no%>">				
					<input type="hidden" name="group_or_individual_ind<%=colorCount%>" id="group_or_individual_ind<%=colorCount%>" value="G">
					<tr>						
						<td class="<%=classvalue%>" style="color:<%=color%>;font-size:11" width="29%"><b><%=group_codes.get(i+1)%></b></td>
						<td class="<%=classvalue%>" width="20%">
							<select name="regimen_setup_unit<%=colorCount%>" id="regimen_setup_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
								String strSelect = "";	
								if(arr_list_qty_uom.size()>0){
									if(((String)arr_list_qty_uom.get(1)).equals((String)arr_list_pres_base_unit.get(ii))){
										strSelect="selected";
									}
								}
						if(group_code.equals("EL") &&( arr_list_pres_base_unit.get(ii).equals("MMOL") || arr_list_pres_base_unit.get(ii).equals("MEQT"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>>
							<%=arr_list_pres_base_unit.get(ii+1)%>   </option>
						<%}else if(group_code.equals("TR") && ( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML") || arr_list_pres_base_unit.get(ii).equals("MCG") ||arr_list_pres_base_unit.get(ii).equals("NCG") ||arr_list_pres_base_unit.get(ii).equals("MG") )){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>>
							<%=arr_list_pres_base_unit.get(ii+1)%>   </option>
						<%
						}else if(group_code.equals("VT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML") || arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>>
							<%=arr_list_pres_base_unit.get(ii+1)%>   </option>
						<%}else if(group_code.equals("OT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML") || arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>>
							<%=arr_list_pres_base_unit.get(ii+1)%>   </option>
						<%}
						else{ // else Added for ML-MMOH-CRF-1266 [IN:068728] - Start
							%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>
						<%
						} // else Added for ML-MMOH-CRF-1266 [IN:068728] - End
						}
						%>
							</select>
						</td>
						<td class="<%=classvalue%>" width="17%">
							<select name="order_qty_limit_unit<%=colorCount%>" id="order_qty_limit_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
							String strSelect = "";	
							if(arr_list_qty_uom.size()>0){
								if(((String)arr_list_qty_uom.get(2)).equals((String)arr_list_pres_base_unit.get(ii))){
									strSelect="selected";
								}
							}
							if(group_code.equals("EL") &&( arr_list_pres_base_unit.get(ii).equals("MMOL") || arr_list_pres_base_unit.get(ii).equals("MEQT"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
						<%
						  }else if(group_code.equals("TR") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML") || arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
						<%
						  }else if(group_code.equals("VT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML") || arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
						<%
						  }else if(group_code.equals("OT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML") || arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
						<%
						  }
						  else{ // else Added for ML-MMOH-CRF-1266 [IN:068728] - Start
								%>
								<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>
							<%
							} // else Added for ML-MMOH-CRF-1266 [IN:068728] - End

						}
						%>
							</select>
						</td>
						<td class="<%=classvalue%>" width="17%">
							<select name="ordering_unit<%=colorCount%>" id="ordering_unit<%=colorCount%>">
			
							<option value="A" <%=order_unit_absolute%>><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/>       </option> 
							<option value="W" <%=order_unit_weight%>><fmt:message key="Common.weight.label" bundle="${common_labels}"/>           </option>  
							<option value="P" <%=order_unit_volume%>><fmt:message key="ePH.PerLitre.label" bundle="${ph_labels}"/>       </option>
							</select>
									
						</td>
						<td class="<%=classvalue%>" width="17%">
							<select name="prep_unit<%=colorCount%>" id="prep_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
							String strSelect = "";
							if(arr_list_qty_uom.size()>0){
								if(((String)arr_list_qty_uom.get(4)).equals((String)arr_list_pres_base_unit.get(ii))){
									strSelect="selected";
								}
							}
							if(arr_list_pres_base_unit.get(ii).equals("ML") ){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>   </option>
						<%
							}
						}
						%>
							</select>
						</td>
					</tr>
				<%
							//}
						for (int j=0;j<arr_list.size();j=j+4){
							String for_order_unit_1 = (String)arr_list.get(j+3);
							String order_unit_absolute_1 ="";
							String order_unit_weight_1   ="";
							String order_unit_volume_1   ="";
							if(for_order_unit_1.equals("P")){
								order_unit_weight_1="";
								order_unit_absolute_1="";
								order_unit_volume_1   ="selected";
							}
							else if(for_order_unit_1.equals("W")){
								order_unit_weight_1="selected";
								order_unit_absolute_1="";
								order_unit_volume_1   ="";
							}else{
								order_unit_weight_1="";
								order_unit_absolute_1="selected";
								order_unit_volume_1   ="";
							}
							srl_no = (String)arr_list.get(j+2);
							colorCount++;
							if ( colorCount % 2 == 0 )
								classvalue = "QRYODD" ;
							else
								classvalue = "QRYEVEN" ;
							arr_list_qty_uom = (ArrayList)ht_quantity_uom_parameters.get(srl_no);
							if(arr_list_qty_uom==null)arr_list_qty_uom = new ArrayList();
							if(arr_list_qty_uom.size()>0){
								color = "red";
								for_order_unit_1=(String )arr_list_qty_uom.get(3);
									if(for_order_unit_1.equals("P")){
										order_unit_absolute_1	=	"";
										order_unit_weight_1 =  "selected";
										order_unit_volume_1   ="selected";
									}
									else if(for_order_unit_1.equals("W")){
										order_unit_absolute_1	=	"";
										order_unit_weight_1 =  "selected";
										order_unit_volume_1   ="";
									}else{
										order_unit_absolute_1	=	"selected";
										order_unit_weight_1 =  "";
										order_unit_volume_1   ="";
									}
							}else{
								color = "";
							}
				%>
					<input type="hidden" name="const_group_code<%=colorCount%>" id="const_group_code<%=colorCount%>" value="<%=group_code%>">
					<input type="hidden" name="srl_no<%=colorCount%>" id="srl_no<%=colorCount%>" value="<%=srl_no%>">				
					<input type="hidden" name="group_or_individual_ind<%=colorCount%>" id="group_or_individual_ind<%=colorCount%>" value="I">
					<tr>
						<%
							if(arr_list.size()==0){
						%>
							<td class="<%=classvalue%>" width="29%" style="color:<%=color%>;font-size:11" >&nbsp;&nbsp;&nbsp;<%=arr_list.get(j+1)%></td>
						<%
							}else{
						%>
							<td class="<%=classvalue%>" width="29%" style="color:<%=color%>;font-size:11" >&nbsp;&nbsp;<%=arr_list.get(j+1)%></td>
						<%
							}
						%>
						
						<td class="<%=classvalue%>" width="20%">
							<select name="regimen_setup_unit<%=colorCount%>" id="regimen_setup_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
								String strSelect = "";
								if(arr_list_qty_uom.size()>0){
									if(((String)arr_list_qty_uom.get(1)).equals((String)arr_list_pres_base_unit.get(ii))){
										strSelect="selected";
									}
								}
							if(group_code.equals("EL") &&( arr_list_pres_base_unit.get(ii).equals("MMOL") || arr_list_pres_base_unit.get(ii).equals("MEQT"))){

							%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
								
							<%}else if(group_code.equals("TR") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML")|| arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){

							%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
								
							<%}else if(group_code.equals("VT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML")|| arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){

							%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
								
							<%}else if(group_code.equals("OT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML")|| arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){

							%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>     </option>
								
				     		<%}
							else{ // else Added for ML-MMOH-CRF-1266 [IN:068728] - Start
								%>
								<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>
							<%
							} // else Added for ML-MMOH-CRF-1266 [IN:068728] - End
					  						 
						}
						%>
							</select>
						</td>
						<td class="<%=classvalue%>" width="17%">
							<select name="order_qty_limit_unit<%=colorCount%>" id="order_qty_limit_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
							String strSelect = "";	
							if(arr_list_qty_uom.size()>0){
								if(((String)arr_list_qty_uom.get(2)).equals((String)arr_list_pres_base_unit.get(ii))){
									strSelect="selected";
								}
							}
							if(group_code.equals("EL") &&( arr_list_pres_base_unit.get(ii).equals("MMOL") || arr_list_pres_base_unit.get(ii).equals("MEQT"))){

						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>       </option>
						<%} else if(group_code.equals("TR") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML")|| arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>       </option>
						<%} else if(group_code.equals("VT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML")|| arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>       </option>
						<%} else if(group_code.equals("OT") &&( arr_list_pres_base_unit.get(ii).equals("GM") || arr_list_pres_base_unit.get(ii).equals("ML")|| arr_list_pres_base_unit.get(ii).equals("MCG")|| arr_list_pres_base_unit.get(ii).equals("NCG")|| arr_list_pres_base_unit.get(ii).equals("MG"))){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>       </option>
						<%}
						else{ // else Added for ML-MMOH-CRF-1266 [IN:068728] - Start
							%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%>    </option>
						<%
						} // else Added for ML-MMOH-CRF-1266 [IN:068728] - End
						}
						%>
							</select>
						</td>
						<td class="<%=classvalue%>" width="17%">
						<select name="ordering_unit<%=colorCount%>" id="ordering_unit<%=colorCount%>">
							<option value="A" <%=order_unit_absolute_1%>><fmt:message key="Common.Absolute.label" bundle="${common_labels}"/>     </option>
							<option value="W" <%=order_unit_weight_1%>><fmt:message key="Common.weight.label" bundle="${common_labels}"/>           </option> 
                             <option value="P" <%=order_unit_volume_1%>><fmt:message key="ePH.PerLitre.label" bundle="${ph_labels}"/>       </option>
							</select>
						</td>
						<td class="<%=classvalue%>" width="17%">
							<select name="prep_unit<%=colorCount%>" id="prep_unit<%=colorCount%>">
							<option value="X">----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</option>
						<%
							for (int ii=0;ii<arr_list_pres_base_unit.size();ii=ii+2){
							String strSelect = "";
							if(arr_list_qty_uom.size()>0){
								if(((String)arr_list_qty_uom.get(4)).equals((String)arr_list_pres_base_unit.get(ii))){
									strSelect="selected";
								}
							}
						if(arr_list_pres_base_unit.get(ii).equals("ML") ){
						%>
							<option value="<%=arr_list_pres_base_unit.get(ii)%>" <%=strSelect%>><%=arr_list_pres_base_unit.get(ii+1)%></option>
						<%
							}
							}
						%>
							</select>
						</td>
					</tr>
				<%
							}
						}
					}
				%>
				</table>
			</td>
		</tr>		
	</table>
	<input type="hidden" name="total_count" id="total_count" value="<%=colorCount%>">

</form>
</body>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	}catch(Exception e){
			out.println(e);			
	}
%>

