<!DOCTYPE html>
 <!--This file is saved on 07/11/2005-->
<%-- Modified By Raghunath
	Modification ::
		Now the function will work depending on the licenceRights
--%>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8"  import="java.util.*, ePH.*, ePH.Common.* , eCommon.Common.*" %>
<%-- Mandatory declarations start --%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>
<html>
	<head>
    <!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
27/05/2020       IN072875          Prabha                      		                  MMS-DM-CRF-0169
--------------------------------------------------------------------------------------------------------------
*/


		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>

		<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<!-- 		<script language="JavaScript" src="../../eCommon/js/messages.js"></script>
 -->		<script language="Javascript" src="../../eCommon/js/FieldFormatMethods.js"></script>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
		<script language="JavaScript" src="../js/PhCommon.js"></script>
<!-- 		<script language="JavaScript" src="../js/PhMessages.js"></script>
 -->		<script language="JavaScript" src="../js/Parameter.js"></script>
		<script language="JavaScript" src="../js/SetupAuditLog.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	 </head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()" >
<%
		String mode						= "";
		String bean_id					= "Phparameter" ;
		String bean_name				= "ePH.ParameterBean";
		String log_bean_id		= "SetupAuditLogBean" ;
		String log_bean_name	= "ePH.SetupAuditLogBean";

		boolean allow_modify			= false;
		String st_install_yn			= "";
		String disabled					= "" ;
		String drug_item_code_link      = "";
		String drug_item_code_link_desc = "";
		String drug_item_code_relation  = "";
		String drug_item_code_relation_desc="";
		String display_trade_name = "";
		String gen_drug_code            = "";
		String gen_drug_code_desc       = "";
		String drug_item_set_up         = "";
		String drug_item_set_up_desc    = "";
		String split_dose_freq          = "";
		String stat_dose_freq           = "";
		String route_transfusion        = "";
		String default_frequency        = "";
		String checked                  = "";
		String allow_refill             = "";
		String refill_allowed           = "";
		String refill_prescription      = "";
		String print_refill             = "";
		String licenceRights = PhLicenceRights.getKey();
		String OrderGeneric				="";  
		String OrderAll				="";  
		String OrderDrug				="";  
		String OrderTrade				="";  
		String OrderCommonName				="";   // Added for SKR-CRF-0007
		String elapsed_period_of_orders_adr ="";
		String imageFilePath = "";
//added for audit log
		String Not_Applicable_legend= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		String audit_log_visible="visibility:hidden";
		String table_id			="PH_PARAM";
		String build_setup_log_yn="";
		String build_setup_log_check="";
		String max_length_prn_remarks = "";
		String backgrndColor= "", fntColor="" ,route_color = "" ;	// added for CRF RUT-CRF-0034.1[IN:037389]-start
		
		String eprescription_content_yn = "N";         //added for MMS-DM-CRF-0619
		String eprescription_content_yn_checked = "";  //added for MMS-DM-CRF-0619
		

		ArrayList routetransfusion		= new ArrayList();
		ArrayList defaultfrequencyfrtpn		= new ArrayList();
		HashMap existrec				= new HashMap();

/* Initialize Function specific start */
		ParameterBean bean = (ParameterBean)getBeanObject( bean_id,bean_name,request) ;
		bean.setLanguageId(locale);
		SetupAuditLogBean log_bean = (SetupAuditLogBean)getBeanObject( log_bean_id, log_bean_name,request ) ;
		log_bean.setLanguageId(locale);
		bean.clear() ;
		st_install_yn			= bean.stockInstallYN();
		routetransfusion		= (ArrayList)bean.loadRouteforTransfusion();
		defaultfrequencyfrtpn   = (ArrayList)bean.defaultFrequencyforTpn();
		existrec				= (HashMap)bean.loadExistData();

		if(existrec!=null){
			mode								=CommonRepository.getCommonKeyValue("MODE_MODIFY") ;
			drug_item_code_link			=(String)existrec.get("drug_item_code_link_reqd_yn");
			drug_item_code_relation	=(String)existrec.get("drug_and_item_code_same_ind");
			gen_drug_code				=(String)existrec.get("drug_code_gen_rule");
			drug_item_set_up			=(String)existrec.get("drug_to_item_mapping");
			split_dose_freq				=(String)existrec.get("dflt_split_dose_freq_code");
			stat_dose_freq				=(String)existrec.get("dflt_stat_dose_freq_code");
			route_transfusion				=(String)existrec.get("dflt_iv_route_code");
			default_frequency			=(String)existrec.get("deflt_freq_fr_tpn");
			elapsed_period_of_orders_adr=(String)existrec.get("elapsed_period_of_orders_adr");
			build_setup_log_yn			=(String)existrec.get("build_setup_log_yn")==null?"N":(String)existrec.get("build_setup_log_yn");
			
			display_trade_name            =(String)existrec.get("trade_display_yn");

			imageFilePath				=(String)existrec.get("imageFilePath")==null?"":(String)existrec.get("imageFilePath");
			if(elapsed_period_of_orders_adr == null){
				elapsed_period_of_orders_adr="";
			}

			if (((String)existrec.get("medn_order_by")).equals("D")){
			   OrderDrug = "selected";
			}
			else if (((String)existrec.get("medn_order_by")).equals("G")){
				OrderGeneric = "selected";
			}
			else if (((String)existrec.get("medn_order_by")).equals("A")){
				OrderAll = "selected";
			}
			else if (((String)existrec.get("medn_order_by")).equals("T")){
				OrderTrade = "selected";
			}
			else if (((String)existrec.get("medn_order_by")).equals("C")){ // if block Added for SKR-CRF-0007
				OrderCommonName = "selected";
			}

			allow_refill            =(String)existrec.get("refill_yn");
			refill_allowed          =(String)existrec.get("max_refills_for_pres");
			if(refill_allowed!=null && refill_allowed.equals("0"))
				refill_allowed="";
			refill_prescription     =(String)existrec.get("max_durn_for_refill_pres");    if(refill_prescription!=null && refill_prescription.equals("0"))refill_prescription="";
			print_refill            =(String)existrec.get("print_refill_pres_with_main_yn");
			
			max_length_prn_remarks = (String)existrec.get("max_length_prn_reason");
			if(max_length_prn_remarks == null)
				max_length_prn_remarks = "";

			if( (st_install_yn!=null && st_install_yn.equals("Y")) && (drug_item_code_link!=null && drug_item_code_link.equals("X")) ){
				if(!licenceRights.equals("PHBASIC")){
					allow_modify=true;
				}
				else{
					allow_modify=false;
				}
			}
			
			if(existrec.get("EPRESCRIPTION_CONTENT_YN")!= null)   //start of MMS-DM-CRF-0619
			{
				eprescription_content_yn   =existrec.get("EPRESCRIPTION_CONTENT_YN")==null?"":(String)existrec.get("EPRESCRIPTION_CONTENT_YN");
			}
			 else
			 {
				 eprescription_content_yn = "N";    //end of MMS-DM-CRF-0619
			 } 	
		
	}
		else{
			allow_modify=true;
			mode=CommonRepository.getCommonKeyValue("MODE_INSERT") ;
		}
		bean.setMode( mode ) ;	

		/*-------------------------code added for showing audit log---------------------------*/
		//code for adding pk_values
		ArrayList Pk_values    =new ArrayList();
		Pk_values.add("PH");  
		
		if(build_setup_log_yn.equals("Y"))
			build_setup_log_check = "checked";
		else
			build_setup_log_check="";

		String display_audit_log_button_yn = log_bean.ShowAuditLogYN(table_id,Pk_values);
		if(display_audit_log_button_yn.equals("Y")){
			audit_log_visible= "visibility:visible";
		}
		else{
			audit_log_visible= "visibility:hidden";
			log_bean.clear();
		}
		/*--------------------------------------ends here---------------------------------------*/
		String Audit_log_legend= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AuditLog.label" ,"common_labels");
%>
		<form name="parameter_header_form" id="parameter_header_form" >
			<table cellpadding=0 cellspacing=0 width="100%" align="center" border="0">
				<tr>
					<td align="right" class="label" width="25%" style="visibility:hidden"><fmt:message key="ePH.BuildAuditLogForSetup.label" bundle="${ph_labels}"/></td>
					<td align="left" width="12%" style="visibility:hidden"><input type='checkbox' name='audit_log_yn' id='audit_log_yn' value='<%=build_setup_log_yn%>' <%=build_setup_log_check%> onclick="checkAuditLog(this,'<%=display_audit_log_button_yn%>');" ></td>
					<td style="visibility:hidden">&nbsp;</td>
					<td class="label" align='right' style="display:none"><INPUT TYPE="button" CLASS="button" name="audit_log" id="audit_log" VALUE="<%=Audit_log_legend%>"   onClick="viewauditlogdetails('<%=table_id%>','PH')" style="<%=audit_log_visible%>">
					</td>
				</tr>
				<th colspan="4" align="left"><fmt:message key="ePH.DrugRelated.label" bundle="${ph_labels}"/></th>
				<tr>
<%
	            if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
				    if(st_install_yn!=null && st_install_yn.equals("N")){
				    //String Not_Applicable1= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
 %>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.DrugandItemCodeLinkRequired.label" bundle="${ph_labels}"/></td><td align="left" width="12%">
						<input type="text" name="drug_item_code_link_desc" id="drug_item_code_link_desc" value="<%=Not_Applicable_legend%>" size="18" disabled><input type="hidden" name="drug_item_code_link" id="drug_item_code_link" value="X" >
<%
					}
					else if(st_install_yn!=null && st_install_yn.equals("Y") && licenceRights.equals("PHBASIC")){
					//String Not_Applicable= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
%>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.DrugandItemCodeLinkRequired.label" bundle="${ph_labels}"/></td><td align="left" width="12%"><input type="text" name="drug_item_code_link_desc" id="drug_item_code_link_desc" value="<%=Not_Applicable_legend%>" size="18" disabled><input type="hidden" name="drug_item_code_link" id="drug_item_code_link" value="X" >
<%
					}
					else{
%>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.DrugandItemCodeLinkRequired.label" bundle="${ph_labels}"/></td>
						<td align="left" width="12%"><select name="drug_item_code_link" id="drug_item_code_link" onChange="validateDrugItemRelation(this);" >
								<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
								<option value="N"><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
								<option value="Y"><fmt:message key="Common.required.label" bundle="${common_labels}"/></option>
							</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
						</td>
<%
					}
				}
				else{

					if(drug_item_code_link!=null && drug_item_code_link.equals("X")) 
						drug_item_code_link_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
					else if(drug_item_code_link!=null && drug_item_code_link.equals("Y"))
						drug_item_code_link_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.required.label","common_labels");
					else if(drug_item_code_link!=null && drug_item_code_link.equals("N"))
						drug_item_code_link_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notrequired.label","common_labels");

					if(allow_modify){
%>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.DrugandItemCodeLinkRequired.label" bundle="${ph_labels}"/></td>
						<td align="left" width="12%"><select name="drug_item_code_link" id="drug_item_code_link" onChange="validateDrugItemRelation(this);" >
								<option selected>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
								<option value="Y" ><fmt:message key="Common.required.label" bundle="${common_labels}"/></option>
								<option value="N"><fmt:message key="Common.notrequired.label" bundle="${common_labels}"/></option>
							</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
<%
					}
					else{
%>
						<td align="right" class="label" width="25%" nowrap><fmt:message key="ePH.DrugandItemCodeLinkRequired.label" bundle="${ph_labels}"/></td>
						<td align="left" width="12%">
							<input type="text" name="drug_item_code_link_desc" id="drug_item_code_link_desc" value="<%=drug_item_code_link_desc%>" disabled>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
							<input type="hidden" name="drug_item_code_link" id="drug_item_code_link" value="<%=drug_item_code_link%>" >
<%
					}
				}
%>
				</td>
<%
				if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
					if(st_install_yn!=null && st_install_yn.equals("N")){
					//String Not_Applicable2= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
%>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.Drug/ItemSetUp.label" bundle="${ph_labels}"/></td>
						<td align="left" class="label" width="33%"><input type="text" name="drug_item_set_up_desc" id="drug_item_set_up_desc" value="<%=Not_Applicable_legend%>" size='18' disabled>
							<input type="hidden" name="drug_item_set_up" id="drug_item_set_up" value="X">
						</td>
<%
					}
					else if(st_install_yn!=null && st_install_yn.equals("Y")&&licenceRights.equals("PHBASIC")){
					//String Not_Applicable3= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
%>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.Drug/ItemSetUp.label" bundle="${ph_labels}"/></td>
						<td align="left" class="label" width="33%"><input type="text" name="drug_item_set_up_desc" id="drug_item_set_up_desc" value="<%=Not_Applicable_legend%>" size='18' disabled>
							<input type="hidden" name="drug_item_set_up" id="drug_item_set_up" value="X">
						</td>
<%
					}
					else{
%>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.Drug/ItemSetUp.label" bundle="${ph_labels}"/></td>
						<td align="left" class="label" width="33%">
							<select name="drug_item_set_up" id="drug_item_set_up"     onChange="validateGenDrugCode(this);" disabled>
								<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
								<option value="X"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
								<option value="S"><fmt:message key="ePH.OneDrugtoOneItem.label" bundle="${ph_labels}"/></option>
								<option value="D"><fmt:message key="ePH.OneDrugtoManyItem.label" bundle="${ph_labels}"/></option>
							</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
						</td>
<%
					}
				}
				else{

					if(drug_item_set_up!=null && drug_item_set_up.equals("X")) 
						drug_item_set_up_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
					else if(drug_item_set_up!=null && drug_item_set_up.equals("D")) 
						drug_item_set_up_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OneDrugtoManyItem.label","ph_labels");
					else if(drug_item_set_up!=null && drug_item_set_up.equals("S")) 
						drug_item_set_up_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OneDrugtoOneItem.label","ph_labels");

					if(allow_modify){
%>
						<td align="right" class="label" width="25%"><fmt:message key="ePH.Drug/ItemSetUp.label" bundle="${ph_labels}"/></td>
						<td align="left" class="label" width="33%">
							<select name="drug_item_set_up" id="drug_item_set_up"  onChange="validateGenDrugCode(this);"
<%
								if(st_install_yn!=null && st_install_yn.equals("Y")){
%>
									disabled >
										<option value="" selected >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
								}
								else{
%>
									disabled >
										<option value="X"><fmt:message key="Common.notapplicable.label" bundle="${common_labels}"/></option>
<%
								}
%>
								<option value="S"><fmt:message key="ePH.OneDrugtoOneItem.label" bundle="${ph_labels}"/></option>
								<option value="D"><fmt:message key="ePH.OneDrugtoManyItem.label" bundle="${ph_labels}"/></option>
							</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
						</td>
<%
						if(!allow_modify){
%>	
							<script>document.parameter_header_form.drug_item_set_up.value="<%=drug_item_set_up%>"</script>
<%
						}
						if(drug_item_code_relation!=null && drug_item_code_relation.equals("D")) {
%>
							<script>drug_item_set_up.disable=false;</script>
<%
						}
						else if(drug_item_code_relation!=null && drug_item_code_relation.equals("S")) {
%>
							<script>drug_item_set_up.disable=true;</script>
<%
						}
					}
					else{
%>
		                <td align="right" class="label" width="25%"><fmt:message key="ePH.Drug/ItemSetUp.label" bundle="${ph_labels}"/></td>
						<td align="left" width="33%"><input type="text" name="drug_item_set_up_desc" id="drug_item_set_up_desc" value="<%=drug_item_set_up_desc%>" size='20' disabled>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img><input type="hidden" name="drug_item_set_up" id="drug_item_set_up" value="<%=drug_item_set_up%>" ></td>
<%
		            }
	            }
%>
	        </tr>
			<tr>
<%
                if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
	                if(st_install_yn!=null && st_install_yn.equals("N")){
			//String Not_Applicable4= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
%>
						<td align="right" class="label" width="25%" nowrap><fmt:message key="ePH.DrugandItemCodeRelationship.label" bundle="${ph_labels}"/></td>
						<td align="left" width="23%">
							<input type="text" name="drug_item_code_relation_desc" id="drug_item_code_relation_desc" value="<%=Not_Applicable_legend%>" size="18" disabled>
							<input type="hidden" name="drug_item_code_relation" id="drug_item_code_relation" value="X" >
<%
					}
					else if(st_install_yn!=null && st_install_yn.equals("Y")&&licenceRights.equals("PHBASIC")){
%>
						<td align="right" class="label" width="25%" nowrap><fmt:message key="ePH.DrugandItemCodeRelationship.label" bundle="${ph_labels}"/></td>
						<td align="left" width="23%"><input type="text" name="drug_item_code_relation_desc" id="drug_item_code_relation_desc" value="<%=Not_Applicable_legend%>" size="18" disabled>
						    <input type="hidden" name="drug_item_code_relation" id="drug_item_code_relation" value="X" >
<%
					}
					else{
%>
						<td align="right" class="label" width="29%" nowrap><fmt:message key="ePH.DrugandItemCodeRelationship.label" bundle="${ph_labels}"/></td>
			            <td align="left" width="23%">
							<select name="drug_item_code_relation" id="drug_item_code_relation"     onChange="validateGenDrugCode(this);" disabled>
								<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>
							</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
<%
					}
%>
					</td>
<%
				}
				else{
					if(drug_item_code_relation!=null && drug_item_code_relation.equals("X")) 
						drug_item_code_relation_desc=Not_Applicable_legend;
					else if(drug_item_code_relation!=null && drug_item_code_relation.equals("D")) 
						drug_item_code_relation_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Different.label","ph_labels");
					else if(drug_item_code_relation!=null && drug_item_code_relation.equals("S"))
						drug_item_code_relation_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Same.label","common_labels");
					if(allow_modify){
						if(st_install_yn!=null && st_install_yn.equals("Y")){
%>
							<td align="right" class="label" width="29%" nowrap><fmt:message key="ePH.DrugandItemCodeRelationship.label" bundle="${ph_labels}"/></td>
<%
						}
						else{
%>
							<td align="right" class="label" width="22%" nowrap><fmt:message key="ePH.DrugandItemCodeRelationship.label" bundle="${ph_labels}"/></td>
<%
						}
%>
						<td align="left" width="26%">
							<select name="drug_item_code_relation" id="drug_item_code_relation"  onChange="validateGenDrugCode(this);" disabled>
								<option value="" selected>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---   </option>
								<option value="S"><fmt:message key="Common.Same.label" bundle="${common_labels}"/></option>
						        <option value="D"><fmt:message key="ePH.Different.label" bundle="${ph_labels}"/></option>
							</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
		                </td>
<%
	                }
		            else{
%>
						<td class="label" width="29%" nowrap><fmt:message key="ePH.DrugandItemCodeRelationship.label" bundle="${ph_labels}"/></td>       <td align="left" width="22%"><input type="text" name="drug_item_code_relation_desc" id="drug_item_code_relation_desc" value="<%=drug_item_code_relation_desc%>" size="18" disabled>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
							<input type="hidden" name="drug_item_code_relation" id="drug_item_code_relation" value="<%=drug_item_code_relation%>" >
						</td>
<%
	                }
		        }
			    if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
					if(st_install_yn!=null && st_install_yn.equals("N")){
%>
						<td class="label" width="" nowrap><fmt:message key="ePH.GenerationofDrugCode.label" bundle="${ph_labels}"/></td>
<%
					}
					else{
%>
						<td class="label" width="" nowrap><fmt:message key="ePH.GenerationofDrugCode.label" bundle="${ph_labels}"/></td>
<%
					}
%>
					<td width="40%"><select name="gen_drug_code" id="gen_drug_code" >
						<option value="">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---&nbsp;&nbsp;</option>
<%
							if(st_install_yn!=null && st_install_yn.equals("Y")){
%>
								<script>document.parameter_header_form.gen_drug_code.disabled=false;</script>
<%
							}
%>
							<option value="G"><fmt:message key="ePH.SystemGenerateSequence.label" bundle="${ph_labels}"/></option>
							<option value="E"><fmt:message key="Common.UserEnterable.label" bundle="${common_labels}"/></option>
						</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img></td>
					</td>
<%
				}
				else{
					if(gen_drug_code!=null && gen_drug_code.equals("G")) 
						gen_drug_code_desc="System Generate Sequence";
					else if(gen_drug_code!=null && gen_drug_code.equals("E")) 
						gen_drug_code_desc="User Entrable";
					
					if(allow_modify){
%>
						<td align="right" class="label" width="17%" nowrap><fmt:message key="ePH.GenerationofDrugCode.label" bundle="${ph_labels}"/></td><td align="left" width="36%">
							<select name="gen_drug_code" id="gen_drug_code" onChange="validateDrugItemSetUp(this);" >
								<option value="G"><fmt:message key="ePH.SystemGenerateSequence.label" bundle="${ph_labels}"/></option>
								<option value="E"><fmt:message key="Common.UserEnterable.label" bundle="${common_labels}"/></option>
							</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
						</td>
<%
					}
					else{
%>
						<td align="right" class="label" width="20%" nowrap><fmt:message key="ePH.GenerationofDrugCode.label" bundle="${ph_labels}"/></td><td align="left" width="34%">
							<input type="text" name="gen_drug_code_desc" id="gen_drug_code_desc" value="<%=gen_drug_code_desc%>" size="23" disabled>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
							<input type="hidden" name="gen_drug_code" id="gen_drug_code" value="<%=gen_drug_code%>" >
					   </td>
<%
					}
				}
 %>
			</tr>		
			<tr><td class="label" align="right"><fmt:message key="ePH.DrugSearchBy.label" bundle="${ph_labels}"/></td>
				<td><select name="medn_order_by" id="medn_order_by" >
						<option value="A" <%=OrderAll%>><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
						<option value="G" <%=OrderGeneric%>><fmt:message key="Common.generic.label" bundle="${common_labels}"/></option>
						<option value="D" <%=OrderDrug%>><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></option>
						<option value="T" <%=OrderTrade%>><fmt:message key="Common.TradeName.label" bundle="${common_labels}"/></option>
						<option value="C" <%=OrderCommonName%>><fmt:message key="ePH.CommonName.label" bundle="${ph_labels}"/></option>  <!-- Added for SKR-CRF-0007 -->
					</select>
				</td>		
				<td class="label" align="right"><fmt:message key="ePH.ElapsedPeriodofordersforADR.label" bundle="${ph_labels}"/></td><td><input type="text" class="NUMBER" size="2" maxlength="3" name="elapsed_period_of_orders_adr" id="elapsed_period_of_orders_adr" value="<%=elapsed_period_of_orders_adr%>" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur="checkBlank(this); CheckNum(this);checkSplChars(this);">&nbsp;&nbsp;<label class="label"><fmt:message key="Common.days.label" bundle="${common_labels}"/></label>
				</td> <!-- checkBlank(this) added for ML-MMOH-SCF-0410 [IN:005009] -->
			</tr>
			
<%		 if(display_trade_name.equals("Y"))
				checked="checked";
			else
				checked="";
%>
					
				<tr>
					<td class="label" align="right"><fmt:message key="ePH.PrescribebyTradeName.label" bundle="${ph_labels}"/></td>
					<td><input type="checkbox" name="display_trade_name" id="display_trade_name" value="<%=display_trade_name%>"  <%=checked%> onclick="assignValue(this);" />
					</td>		
					<td class="label" align="right" width="20%"><fmt:message key="ePH.MaxLengthforPRNRemarks.label" bundle="${ph_labels}"/>
					</td> 
					<td><input type="text" class="NUMBER" id="Max Length for PRN Remarks" name="max_length_for_prn_remarks" id="max_length_for_prn_remarks" size="3" maxlength="3" value="<%=max_length_prn_remarks%>" onKeyPress="return(ChkNumberInput(this,event,0));" onBlur=" validatePRNRemarksLength(this);" class="NUMBER" />&nbsp;&nbsp;<label class="label"><fmt:message key="ePH.characters.label" bundle="${ph_labels}"/></label>
					</td>
				</tr>
			

			<tr><td class="label" align="right"><fmt:message key="ePH.ImageFilePath.label" bundle="${ph_labels}"/></td>
				<td><input type="text" name="imageFilePath" id="imageFilePath" value='<%=imageFilePath%>' maxlength='200' size='50'>
				</td> 
				 <!--  start of mms-dm-crf-0169 -->
			   
<%			String eprescription_checked_yn = "";
			if(eprescription_content_yn!=null && eprescription_content_yn.equals("Y"))   
			{
        	   	   eprescription_content_yn_checked="checked";
			   eprescription_checked_yn = "Y";
			}
	               else
	               {
	                  eprescription_content_yn_checked="";
	    		  eprescription_checked_yn = "N";
	              }
%>	
            <td class="label" width="20%" align="right"><fmt:message key="ePH.PrescriptionContent.label" bundle="${ph_labels}"/></td>
            <td   colspan="2" ><input type='checkbox' name='eprescription_content_yn' id='eprescription_content_yn' value='<%=eprescription_checked_yn%>' <%=eprescription_content_yn_checked%> onclick='ValidatePresCont(this);' ></td>
    
       <!--  end of mms-dm-crf-0169 -->   
      </tr>
      
			<tr>
				<td colspan="4" class="label">&nbsp;</td>
			<tr>
			<th colspan="2" align="left" nowrap><fmt:message key="ePH.DefaultRouteforIVAdministration.label" bundle="${ph_labels}"/>
			<th colspan="2" align="left" nowrap><fmt:message key="ePH.DefaultFrequencyforTPNOrder.label" bundle="${ph_labels}"/>
			</th>
			<tr><td colspan="4" class="label">&nbsp;</td></tr>
<%----------------------------------------------------------------------------------------------------------
		Start comment
        <tr>
            <td align="right" class="label" width="26%"><fmt:message key="ePH.SplitDoseFrequency.label" bundle="${ph_labels}"/></td>
            <td align="left" width="24%">&nbsp;
                 <%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
                 %>
                 <select name="split_dose_freq" id="split_dose_freq" >
                  <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                 <%
                 for(int i=0;i<splidosefreq.size();i++){
                     HashMap data = new HashMap();
                     data = (HashMap)splidosefreq.get(i);
                 %>
                     <option value="<%=data.get("freq_code")%>"><%=data.get("freq_desc")%></option>
                <%
                 }
                 }else{
                %>
                        <select name="split_dose_freq" id="split_dose_freq" >
						<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                        <%
                            for(int i=0;i<splidosefreq.size();i++){
                            HashMap data = new HashMap();
                            data = (HashMap)splidosefreq.get(i);
                        %>
                            <option value="<%=data.get("freq_code")%>"><%=data.get("freq_desc")%></option>
                        <%
                        }
                        %>
                            <script>document.parameter_header_form.split_dose_freq.value="<%=split_dose_freq%>"</script>
                  <%
                  }
                  %>
                </select>
			</td>
		    <td align="right" class="label" width="20%"><fmt:message key="ePH.STATDoseFrequency.label" bundle="${ph_labels}"/></td>
            <td align="left" width="2%">
            <%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
            %>
                 <select name="stat_dose_freq" id="stat_dose_freq" width="75%">
                     <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
                 <%
                 for(int i=0;i<statdosefreq.size();i++){
                     HashMap data = new HashMap();
                     data = (HashMap)statdosefreq.get(i);
                 %>
                     <option value="<%=data.get("freq_code")%>"><%=data.get("freq_desc")%></option>
                <%
                 }
                 %>
                    </select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
                 <%
                 }else{
                 %>
                        <select name="stat_dose_freq" id="stat_dose_freq" >
                        <option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
                        <%
                            for(int i=0;i<statdosefreq.size();i++){
                            HashMap data = new HashMap();
                            data = (HashMap)statdosefreq.get(i);
                        %>
                            <option value="<%=data.get("freq_code")%>"><%=data.get("freq_desc")%></option>
                        <%
                        }
                        %>
                            </select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img> <script>document.parameter_header_form.stat_dose_freq.value="<%=stat_dose_freq%>"</script>
                    <%
                    }
                    %>
            </td>
        </tr> 
--------------------------------------------------------------END Comment--%>
	
			<tr>
				<td align="right" class="label" width="25%" nowrap><fmt:message key="ePH.AdministrationRoute.label" bundle="${ph_labels}"/></td>
				<td align="left" width="12%">
<%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
%>
					<select name="route_transfusion" id="route_transfusion" >
						<option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
						for(int i=0;i<routetransfusion.size();i++){
							HashMap data = new HashMap();
							data = (HashMap)routetransfusion.get(i);
                            route_color=(String)data.get("route_color");	// added for CRF RUT-CRF-0034.1[IN:037389]-start
							if(route_color!= null && !route_color.equals("")){  
								if(route_color.length()==12){
									fntColor= route_color.substring(0, 6);
									backgrndColor= route_color.substring(6, 12);
								}
							}
							else{
								fntColor="";
								backgrndColor= "";
							}// added for CRF RUT-CRF-0034.1 [IN:037389]-end
%>
							<option value="<%=data.get("route_code")%>" style='color:<%=fntColor%>;background-color:<%=backgrndColor%>;'><%=data.get("route_desc")%></option>
<%
						}
%>
					</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
<%
                }
				else{
%>
					<select name="route_transfusion" id="route_transfusion" >
						<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
							String select_route = "";
                            for(int i=0;i<routetransfusion.size();i++){
								HashMap data = new HashMap();
								data = (HashMap)routetransfusion.get(i);
								route_color=(String)data.get("route_color");	// added for CRF RUT-CRF-0034.1[IN:037389]-start
								fntColor="";
								backgrndColor= "";
								if(route_color!= null && !route_color.equals("")){  
									if(route_color.length()==12){
										fntColor= route_color.substring(0, 6);
										backgrndColor= route_color.substring(6, 12);
									}
								}// added for CRF RUT-CRF-0034.1 [IN:037389]-end
	                            if (data.get("route_code").toString().equals(route_transfusion))
	                            	select_route = "SELECTED";
	                            else
	                            	select_route = "";
%>
                            <option style='color:<%=fntColor%>;background-color:<%=backgrndColor%>' value="<%=data.get("route_code")%>" <%= select_route %> ><%=data.get("route_desc")%></option>
<%
						}
%>
					</select>&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif"></img>
<%
				}
%>
				</td>
				<td align="right" class="label"  nowrap colspan=2>&nbsp;&nbsp;<fmt:message key="Common.Frequency.label" bundle="${common_labels}"/> &nbsp;&nbsp;
<%
                 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
%>
					 <select name="deflt_freq_fr_tpn" id="deflt_freq_fr_tpn" >
						 <option>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
<%
							for(int i=0;i<defaultfrequencyfrtpn.size();i++){
							HashMap data = new HashMap();
							data = (HashMap)defaultfrequencyfrtpn.get(i);
%>
						<option value="<%=data.get("freq_code")%>"><%=data.get("freq_desc")%></option>
<%
					}
%>
                    </select>&nbsp;
<%
				}
				else{
%>
					<select name="deflt_freq_fr_tpn" id="deflt_freq_fr_tpn" >
						<option>&nbsp;&nbsp;&nbsp;&nbsp;--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---&nbsp;&nbsp;&nbsp;&nbsp;</option>
<%
							String select_freq = "";
                            for(int i=0;i<defaultfrequencyfrtpn.size();i++){
								HashMap data = new HashMap();
								data = (HashMap)defaultfrequencyfrtpn.get(i);
	                            if (data.get("freq_code").toString().equals(default_frequency))
	                            	select_freq = "SELECTED";
	                            else
	                            	select_freq = "";
%>
								<option value="<%=data.get("freq_code")%>" <%= select_freq %>><%=data.get("freq_desc")%></option>
<%
							}
%>
						</select>&nbsp;
<%
					}
%>
					</td>
		        </tr>
				<tr><td colspan="4" class="label">&nbsp;</td></tr>

				<th align="left" colspan="4"><fmt:message key="ePH.RefillApplicability.label" bundle="${ph_labels}"/></th>
				<tr>
					<td align="right" class="label" width="28%"><fmt:message key="ePH.AllowRefill.label" bundle="${ph_labels}"/></td>
					<td align="left" width="5%">
<%
                    if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
						allow_refill="";
					}
					else{
						if(allow_refill != null){
							if(allow_refill.equals("Y") )
								checked="checked";
							else
								checked="";
						}else{
							allow_refill="";
						}
					}
%>
					<input type="checkbox" name="allow_refill" id="allow_refill" value="<%=allow_refill%>" onclick="ValidateRefill(this);" <%=checked%> >
	            </td>
		        <td colspan="2" align="left" class="label" width="16%">&nbsp;</td>
			</tr>
			<tr>
				<td align="right" class="label" width="28%"><fmt:message key="ePH.MaxNoofRefillsAllowed.label" bundle="${ph_labels}"/></td>
				<td align="left" width="5%">
<%
				if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
					refill_allowed="";
					disabled="disabled";
				}
%>
                <input type="text" size="2" maxlength="2" name="refill_allowed" id="refill_allowed" value="<%=refill_allowed%>" onKeyPress="return(ChkNumberInput(this,event,0));" <%=disabled%> class="NUMBER" onBlur="checkIsNotZero(this, 'Max No of Refills Allowed');checkSplChars(this);">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif" id="refill_allowed_man" style="visibility:hidden"></img>
            </td>
<%
			if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				if(allow_refill!=null && allow_refill.equals("Y") ){
%>
					<script>validateRefillAllowed("Y")</script>
<%
				}
				else if(allow_refill!=null && allow_refill.equals("N") ){
%>
					<script>validateRefillAllowed("N")</script>
<%
				}
			}
%>
          
            <td align="right" class="label" width="15%" nowrap><fmt:message key="ePH.MaxDaysforRefillPrescription.label" bundle="${ph_labels}"/></td>
            <td align="left" width="25%">
<%
			 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
				refill_prescription="";
				disabled="disabled";
			 }
%>
				 <input type="text" size="3" maxlength="3" name="refill_prescription" id="refill_prescription" value="<%=refill_prescription%>" onKeyPress="return(ChkNumberInput(this,event,0));" <%=disabled%> class="NUMBER" onBlur="checkIsNotZero(this, 'Max Days for Refill Prescription');checkSplChars(this);">&nbsp;<img align="center" src="../../eCommon/images/mandatory.gif" id="refill_prescription_man" style="visibility:hidden"></img>&nbsp;&nbsp;
			</td>
<%
			 if(mode.equals(CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
				 if(allow_refill!=null && allow_refill.equals("Y") ){
%>
					<script>validateRefillPrescription("Y")</script>
<%
				}
				else if(allow_refill!=null && allow_refill.equals("N") ){
%>
					<script>validateRefillPrescription("N")</script>
<%
				}
			}
%>
        </tr>
        <tr>
            <td align="right" class="label" width="28%" nowrap><fmt:message key="ePH.PrintRefillPrescriptionsalongwithMain.label" bundle="${ph_labels}"/></td>
            <td align="left" width="3%">
<%
					if(mode.equals(CommonRepository.getCommonKeyValue("MODE_INSERT"))){
	                    disabled="disabled";
						print_refill="N";
					}
					else{
						if (allow_refill != null){
							if(allow_refill.equals("Y")){
								if(print_refill.equals("Y")){
									checked="checked";
								}
								else{
									checked="";
								}
								disabled="";
							}
							else{
								print_refill="N";
								disabled="disabled";
								checked="";
							}
						}
						else{
							allow_refill="";
						}
                    }
%>
                    <input type="checkbox" name="print_refill" id="print_refill" value="<%=print_refill%>"  <%=checked%> <%=disabled%> onclick="assignValue(this)" >
				</td>
				<td align="left" class="label" colspan="2">&nbsp;</td>
			</tr>
			<tr><td colspan='4'>&nbsp;</td></tr>
			<input type="hidden" name="st_install_yn" id="st_install_yn" value="<%=st_install_yn%>" >
			<input type="hidden" name="mode" id="mode" value="<%=mode%>">
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="allow_modify" id="allow_modify" value="<%=allow_modify%>">
		</table>
	</body>
	<% putObjectInBean(bean_id,bean,request ) ; %> 
	<script>
		parent.f_query_details.location.href = "../../ePH/jsp/ParameterAddModifyDetails.jsp"
	</script>
</html>

