<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------
Date       	Edit History            Name        		             Description
---------------------------------------------------------------------------------------------------------------
28/05/2019	IN:067951	            Devindra			              MMS-KH-CRF-0016
10/10/2019  IN070786                PRATHYUSHA                       MMS-KH-CRF-0016.1
---------------------------------------------------------------------------------------------------------------
*/
%>
<%-- JSP Page specific attributes st art --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, eOR.*,ePH.*, ePH.Common.*,java.sql.*,webbeans.eCommon.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%-- Mandatory declarations end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/CommonBean.jsp" %>
<%-- Mandatory declarations end --%>

<html>
	<head>
		<title></title>
		<!-- <link rel="stylesheet" type ="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script language="JavaScript" src="../../ePH/js/PrescriptionTest.js"></script>
		<script language="Javascript" src="../../ePH/js/PhCommon.js"></script>
		<script language="Javascript" src="../../eCommon/js/common.js"></script>
		<script language="Javascript" src="../../eCommon/js/CommonResult.js"></script>
		<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
		<script language="JavaScript" src="../js/MedicationReconciliation.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	</head>
	<body onMouseDown="CodeArrest()" onKeyDown="lockKey()">
<%
		
		try{
			String pat_class	=	request.getParameter("pat_class");
			String ord_status	=	request.getParameter("ord_status");
			String order_from	=   request.getParameter("order_from");
			String order_to		=	request.getParameter("order_to");
			String pract_id		=	request.getParameter("pract_id");
			String patient_id	=	request.getParameter("patient_id");
			String encounter_id	=	request.getParameter("encounter_id");
			String discharge_ind =  request.getParameter("discharge_ind"); // added for #70618
			String group_by		=	"";
		    String called_by =  request.getParameter("called_by")==null?"":request.getParameter("called_by"); // added for #70618
			String log_pract_id	=	request.getParameter("log_pract_id");
			int l=0;
			int len=0, point=0;//added for IN070786
			String temp="";// added for IN070786
			
			String sys_date=(String) com.ehis.util.DateUtils.getCurrentDate("DMYHM",locale);
			String iv_prep_yn="";
			String rx_legend="";
			String rx_type		=	request.getParameter("rx_type");
			String from	= CommonBean.checkForNull(request.getParameter("from"));
			String to	= CommonBean.checkForNull(request.getParameter("to"));
			String drug_desc = CommonBean.checkForNull(request.getParameter("drug_desc"));
			String call_from = CommonBean.checkForNull(request.getParameter("call_from")); // Added for Inc#70652
			String checkcount = CommonBean.checkForNull(request.getParameter("checkcount"),"0");
			String pract_type = CommonBean.checkForNull(request.getParameter("pract_type"),""); 
			l = Integer.parseInt(checkcount);
			String bean_id		= "@PrescriptionBean_1"+patient_id+encounter_id;
			String bean_name	= "ePH.PrescriptionBean_1";
			PrescriptionBean_1 bean		= (PrescriptionBean_1)getBeanObject( bean_id,bean_name,request );
			String presBean_id			= "PrescriptionBean"+patient_id+encounter_id;
			String presBean_name		= "ePH.PrescriptionBean";
			PrescriptionBean presBean		= (PrescriptionBean)getBeanObject(presBean_id, presBean_name, request );
			bean.setLanguageId(locale);
			String facility_id					= (String) session.getValue("facility_id");
			String DMA_bean_id				=	"DispMedicationAllStages" ;     
			String DMA_bean_name		=	"ePH.DispMedicationAllStages";

			DispMedicationAllStages DMAbean = (DispMedicationAllStages)getBeanObject( DMA_bean_id, DMA_bean_name,request);
			DMAbean.setLanguageId(locale);

			String or_bean_name				= "eOR.OrderEntryBean";
			String or_bean_id				= "@orderentrybean"+patient_id+encounter_id;
			OrderEntryBean orbean			= (OrderEntryBean)getBeanObject( or_bean_id,or_bean_name,request ) ;
		    String drugsearch_bean_Id   = "ePH.DrugSearchBean";  //  Added for ML-BRU-SCF-0958 [IN:042045] Start
			String drugsearch_bean_name = "ePH.DrugSearchBean";
		    DrugSearchBean drugbean		=	(DrugSearchBean)getBeanObject( drugsearch_bean_Id, drugsearch_bean_name, request ) ; //  Added for ML-BRU-SCF-0958 [IN:042045] End
			orbean.setLanguageId(locale);
			String resp_id = orbean.getResponsibilityId();
			ArrayList result		=	new ArrayList();
			ArrayList alphabets		=	new ArrayList();
			ArrayList prescriptions	=  bean.getPrescriptions();
			
			if(call_from.equals("SEARCH")) // Added for Inc#70652 - Satrt
				bean.copyPresClear(); // Added for Inc#70652 - End
			if(called_by.equals("SEARCH"))
				bean.setExternal_drugs_tmp(new ArrayList()); // Added for Inc#70652 - End
			
			String checked			=	"";
			boolean found			=  false; 
			if(!locale.equals("en")){
				order_from = DateUtils.convertDate(order_from, "DMY",locale,"en");
				order_to = DateUtils.convertDate(order_to, "DMY",locale,"en");
			}

			String drug_priv_appln_yn			= (String) session.getValue("PrivilegeApplicability");
			if ( drug_priv_appln_yn == null || drug_priv_appln_yn.equals("")) 
				drug_priv_appln_yn = "N";
			HashMap total_result	=	bean.getMRPreviousOrders(pat_class,pract_id,patient_id,ord_status,order_from,order_to,from,to,drug_desc,group_by,drug_priv_appln_yn,resp_id, log_pract_id);
			ArrayList prescriptionDetails=(ArrayList)bean.getpresDetails();
			if(total_result.size()!=0 && group_by.equals("DR")) {
				result		=	(ArrayList)total_result.get("RESULT");
				//alphabets	=	(ArrayList)total_result.get("ALPHABETS");
			} 
			else{
				result		=	(ArrayList)total_result.get("RESULT");
			}
			int recCount		=	0;
			String classValue	=	"";
			String disabled		=	"";
			String pres_no		=	"";
			String order_id		=	"";
			String order_line_no		=	"";
			String drug_code	=	"";
			String ord_date="";
			String sliding_scale_yn = "";
			String priv_appl_yn = "";
			boolean taper_display = false;
		    String verb_order_appr_drug_yn = ""; //Added for ML-BRU-SCF-0958 [IN:042045] 
		    String Called_from_verbal_order = drugbean.getCalled_from_verbal_order(); //Added for ML-BRU-SCF-0958 [IN:042045]
			HashMap iv_legends = (HashMap) presBean.getIVLegends();
			String taper = "";
			String qty_uom, strength_value, taper_disabled=""; //taper_disabled added for [IN:048140]
			if(result.size()<1){
		%>
				<script>
					alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA",'Common'));
				</script>
		<%
				return;
			}
		%>
			<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()' style="overflow-x:hidden;overflow-y:scroll">
				<form name="frmPrescriptionPrevOrdersResult1" id="frmPrescriptionPrevOrdersResult1" >
				<!-- Display the Previous Next link -->
					<div id="HTab" style="width:100%;" align='left'>
						<table border="1" cellpadding="0" cellspacing="0" width="100%" align="left" name="resultTable" id="resultTable" style='position:relative;top:expression(this.offsetParent.scrollTop-2)'>
							<tr>  								
								<th  nowrap width="1%" style="font-size:10">&nbsp;</th>
								<th  nowrap width="5%" style="font-size:10" ><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></th>
								
								<th  width="12%"  style="font-size:10"><fmt:message key="Common.DrugName.label" bundle="${common_labels}"/></th>
								<th  width="12%"  style="font-size:10"><fmt:message key="ePH.DosageDetail.label" bundle="${ph_labels}"/></th>
								
								<th width="8%" style="font-size:10"><fmt:message key="Common.OrderedBy.label" bundle="${common_labels}"/></th>
								<th width="8%" style="font-size:10"><fmt:message key="ePH.OrderedLocation.label" bundle="${ph_labels}"/></th>
								<th  width="6%"  style="font-size:10"><fmt:message key="Common.facility.label" bundle="${common_labels}"/></th>
								<th width="7%" style="font-size:10"><fmt:message key="ePH.PrescribedQty.label" bundle="${ph_labels}"/></th>
								<th width="7%" style="font-size:10"><fmt:message key="ePH.DispensedQty.label" bundle="${ph_labels}"/></th>
								<th width="7%" style="font-size:10"><fmt:message key="ePH.admin.label" bundle="${ph_labels}"/><fmt:message key="Common.Qty.label" bundle="${common_labels}"/></th>
								<th  width="8%"  style="font-size:10"><fmt:message key="Common.StartDate.label" bundle="${common_labels}"/></th>
								<th  width="8%"  style="font-size:10"><fmt:message key="Common.enddate.label" bundle="${common_labels}"/></th>								
								<th  nowrap width="13%" style="font-size:10">&nbsp;</th>
		
							</tr>
						</table>
					</div>
					<div id="DataTab" style="height:310px; width:100%;" align='left'>
						<table border="1" cellpadding="0" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
		<% 		               
		                    String disContinue = "N";
							HashMap taperValues = null; //Added for RUT-CRF-0088 [IN036978]
							String order_qty ="";
							String dispense_qty = "";
						    String admin_qty = "";
						    String dosage_type				= "";//added for IN070786
							  String freq_nature		= "";//added for IN070786
							  String content_in_pres_base_uom = "";//added for IN070786
							int count = 1;
							for(int i=0; i<result.size(); i+=34) { // i+=22 to 23 Added for ML-BRU-SCF-0958 [EMR IN:1835]
							   order_qty = (String)result.get(i+24);
							     dosage_type				= (String)result.get(i+32);//added for IN070786
								   freq_nature		= (String)result.get(i+31);//added for IN070786
								   content_in_pres_base_uom = (String)result.get(i+30);//added for IN070786
								   strength_value = (String) result.get(i+33);//added for IN070786
							   		   if(!order_qty.equals(""))
								   order_qty =order_qty+" "+bean.getUomDisplay(facility_id,(String)result.get(i+25));
							  
							  dispense_qty = (String)result.get(i+23);
							  
							  if(!dispense_qty.equals(""))
								  dispense_qty =dispense_qty+" "+bean.getUomDisplay(facility_id,(String)result.get(i+25));
							  
							  admin_qty = (String)result.get(i+22);
							  
							  //added for IN070786 start
							  if(!admin_qty.equals("")  && !admin_qty.equals("0") && (dosage_type.equals("A") || dosage_type.equals("Q"))){

									len= admin_qty.length();
									if( len > 0 && Float.parseFloat(admin_qty)>1 ){
										temp = admin_qty;
										point= temp.indexOf(".")+1;
										if(point!=0 && temp.charAt(point)=='0')
											admin_qty = admin_qty.substring(0,point-1);
									}		
								}
								 
								else if(!admin_qty.equals("")  && !admin_qty.equals("0") && dosage_type.equals("S")){  
								
									admin_qty = Float.toString( Float.parseFloat(admin_qty) * Float.parseFloat(strength_value) );
									
									len= admin_qty.length();
									if( len > 0 && Float.parseFloat(admin_qty)>1 ){
										temp = admin_qty;
										point= temp.indexOf(".")+1;
										if(point!=0 && temp.charAt(point)=='0')
											admin_qty = admin_qty.substring(0,point-1);
									}						

									} 
							  if(admin_qty!=null && !admin_qty.equals("") && !admin_qty.equals("0") && freq_nature.equals("P")){ 
								  admin_qty =Float.toString( Float.parseFloat(admin_qty)*Float.parseFloat(content_in_pres_base_uom));
								  len= admin_qty.length();
								
								if( len > 0 ){
									temp = admin_qty;
									point= temp.indexOf(".")+1;
									if(point!=0 && temp.charAt(point)=='0')
										admin_qty = admin_qty.substring(0,point-1);
								}
							}
							  //added for IN070786 end
							  
							  if(!admin_qty.equals(""))
								admin_qty =admin_qty+" "+bean.getUomDisplay(facility_id,(String)result.get(i+28));
								
							    disContinue = "N";
								if(recCount%2==0)
									classValue="QRYEVENSMALL";
								else
									classValue="QRYODDSMALL";

								found	=	false;
								
								checked		=	"";
								disabled	=	"";
								order_id = (String)result.get(i+1);
								order_line_no = (String)result.get(i+2);
								drug_code = (String)result.get(i+3);
							    //verb_order_appr_drug_yn = (String)result.get(i+22); // Commented for ML-BRU-SCF-0958 [IN:042045  
								iv_prep_yn = (String)result.get(i+17);
									disContinue = (String)result.get(i+18);
									sliding_scale_yn = (String)result.get(i+19);
									priv_appl_yn = (String)result.get(i+20);
									verb_order_appr_drug_yn = (String)result.get(i+21); //  Added for ML-BRU-SCF-0958 [IN:042045]
								if(iv_prep_yn==null) 
									iv_prep_yn="";

								if(iv_prep_yn.equals(""))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.NormalRx.label", "ph_labels");
								else if(iv_prep_yn.equals("0"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyRegimen.label", "ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";
								else if(iv_prep_yn.equals("1"))
									rx_legend=(String)iv_legends.get("IVA")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label","common_labels");
								else if(iv_prep_yn.equals("2"))
									rx_legend= (String)iv_legends.get("IVA")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label", "common_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";
								else if(iv_prep_yn.equals("3"))
									rx_legend= (String)iv_legends.get("IVI")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//"IV Piggyback (Direct)";
								else if(iv_prep_yn.equals("4"))
									rx_legend= (String)iv_legends.get("IVI")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.Admixture.label", "ph_labels")+")";//"IV piggyback (Admixture)";
								else if(iv_prep_yn.equals("5"))
									rx_legend= (String)iv_legends.get("IVWA");//com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.IVwithAdditives.label", "common_labels");
								else if(iv_prep_yn.equals("6"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.CompoundingRx.label", "ph_labels");
								else if(iv_prep_yn.equals("7"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNStandardRegimen.label", "ph_labels");//"TPN Standard Regimen";
								else if(iv_prep_yn.equals("8"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.TPNNONStandardRegimen.label", "ph_labels");//"TPN NON Standard Regimen";
								else if(iv_prep_yn.equals("9"))
									rx_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext, "ePH.OncologyRegimen.label", "ph_labels")+"("+com.ehis.util.BundleMessage.getBundleMessage(pageContext, "Common.Direct.label", "common_labels")+")";//"Oncology Regimen (Direct)";

								if(prescriptions!= null && prescriptions.contains(result.get(i+3))){ 
									disabled	=	"disabled";
								}
								if(prescriptions!= null && prescriptions.contains(result.get(i+1)+","+result.get(i+2))){ 
									checked		=	"checked";
									disabled	=	"";
								}
								for(int j=0;j<prescriptionDetails.size();j++){
									if(((String)((HashMap) prescriptionDetails.get(j)).get("DRUG_CODE")).equals((String)result.get(i+3)) ) {
										found	=	true;
										break;
									}
								}

								if(found){
									disabled	=	"disabled";
								}
								taper_display=false; //Added for SKR-SCF-0823 [IN:041165]
								//count = DMAbean.chkfortapering(order_id,drug_code, order_line_no);//commented for RUT-CRF-0088 [IN036978]
								taperValues=DMAbean.chkfortapering(order_id,drug_code, order_line_no, patient_id);	//Modified for RUT-CRF-0088 [IN036978]  
								//count =Integer.parseInt(taperValues.get("COUNT").toString());  // Modified for RUT-CRF-0088 [IN036978]  //Commented for ML-BRU-SCF-1458 [IN:052366]
								count = bean.chkfortaperingCount(order_id);//commented for RUT-CRF-0088 [IN036978]
								if(count==1 ){
									taper_display=false;
								}

							if((count==1)||(!taper_display)){
		%>		
								<tr>
		<% 
									if( ((String)result.get(i)).equals("CN")){
		%>
										<td width="1%" class='CANCELLED'>&nbsp;</td>
		<%
									} 
									else if( ((String)result.get(i)).equals("DC")) { 
		%>
										<td width="1%" class='DISCONTINUED'>&nbsp;</td>
		<%
									}
									else{
		%>
										<td width="1%" class="<%=classValue%>">&nbsp;</td>
		<%	
									}

									if(rx_type.equals("") && iv_prep_yn.equals("")){
										if(disContinue.equals("Y") || (Called_from_verbal_order.equals("Y") && verb_order_appr_drug_yn.equals("N")) ||  (pract_type.equals("NS") && verb_order_appr_drug_yn.equals("N")))  //verbal order condition added for ML-BRU-SCF-0958 [IN:042045](pract_type.equals("NS") && verb_order_appr_drug_yn.equals("N")) -- //  Added for ML-BRU-SCF-0958 [EMR IN:1835] 
											disabled="disabled";

										if(prescriptions!=null && prescriptions.contains(result.get(i+1)+","+result.get(i+2))){ 
											checked		=	"checked";
											//disabled	=	"disabled";
										} 
		%>
										<input type ="hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",priv"%>" value="<%=priv_appl_yn%>"> 
										<td width="5%" class="<%=classValue%>"   id='drug_<%=(String)result.get(i+1)%>'><input type="checkbox" name='<%=result.get(i+1)+","+result.get(i+2)%>' id='<%=result.get(i+1)+","+result.get(i+2)%>' onClick=" return checkDuplicate1(this,'<%=priv_appl_yn%>','Previous'); "  value="<%=result.get(i+3)%>" <%=checked%> <%=disabled%>>
										<input type ="hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",drug_code"%>" value="<%=result.get(i+3)%>"></td>
										<input type = "hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",ord_status"%>" value = '<%=(String)result.get(i)%>'>
		<%
									}
									else{
		%>
										<td width="5%" class="<%=classValue%>"  >&nbsp;</td>
		<%
									}
		%>
									<input type ="hidden" name ="<%=result.get(i+1)+","+result.get(i+2)+",end_date"%>" value="<%=result.get(i+13)%>"></td>
		<%
									if((count>1)){
										taper = DMAbean.getTapervalue();
										taper_display = true;
									}
		%>
									
									<td width="12%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+4)%></td>
		<%
									if(sliding_scale_yn.equals("N")){										
										strength_value = (String) result.get(i+5);
										if(strength_value!=null && !strength_value.equals("") && Float.parseFloat(strength_value) < 1)
											strength_value = Float.parseFloat(strength_value)+"";
										qty_uom = (String) result.get(i+6);
										if(qty_uom!=null && !qty_uom.equals(""))
											qty_uom = bean.getUomDisplay(facility_id,result.get(i+6).toString());
										if(((String)result.get(i+8)).equals("(Divided)")){
		%>
											<td width="12%" style="font-size:10" class="<%=classValue%>"><%=strength_value+" "+qty_uom+"&nbsp;-&nbsp;<font  color=red>"+result.get(i+8)+"</font>&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)%></td>
		<%
										}
										else{
		%>
											<td width="12%" style="font-size:10" class="<%=classValue%>"><%=strength_value+" "+qty_uom+"&nbsp;-&nbsp;"+result.get(i+8)+"&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)%></td>
		<%
										}
									}
									else{
		%>
										<td width="12%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+8)+"&nbsp;for&nbsp;"+result.get(i+9)+" "+result.get(i+11)%></td>
		<%							
									}
		%>							<td width="8%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+15)%></td>
									<td width="8%" style="font-size:10" class="<%=classValue%>"><%=result.get(i+16)==null?"&nbsp;":result.get(i+16)%></td>
		                             
		                             <td width="6%" nowrap style="font-size:10" class="<%=classValue%>"><%=result.get(i+26)%></td>
									 <td width="7%" nowrap style="font-size:10" class="<%=classValue%>"><%=order_qty%>&nbsp;</td>
									 <td width="7%" nowrap style="font-size:10" class="<%=classValue%>"><%=dispense_qty%>&nbsp;</td>
									<td width="7%" nowrap style="font-size:10" class="<%=classValue%>"><%=admin_qty%>&nbsp;</td>		                       		                             
									<td width="8%" nowrap style="font-size:10" class="<%=classValue%>"><%=result.get(i+12)%></td>
									<td width="8%" nowrap style="font-size:10" class="<%=classValue%>"><%=result.get(i+13)%></td>
								<% if(rx_type.equals("") && iv_prep_yn.equals(""))
										if(!((String)result.get(i)).equals("DC") && !((String)result.get(i)).equals("CN"))
										{
								%>
									<td width="13%" nowrap style="font-size:10" class="<%=classValue%>"><input type="button" value="Discontinue/Cancel" name='<%=result.get(i+27)+","+result.get(i+3)+","+result.get(i+29)+","+order_id+","+order_line_no%>' id='<%=result.get(i+27)+","+result.get(i+3)+","+result.get(i+29)+","+order_id+","+order_line_no%>' onClick='discCancelOrders(this)'></td>
		                        <%
										} else{
								%>
								<td width="13%" nowrap style="font-size:10" class="<%=classValue%>">&nbsp;</td>
								<%} %>
								</tr>
		<%
							}
							order_qty ="";
							dispense_qty = "";
						    admin_qty = "";
						    
							recCount++;
						}	
		%>
						</table>
						<input type="hidden" name="from" id="from" value="">
						<input type="hidden" name="to" id="to" value="">
						<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
						<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
						<input type="hidden" name="pat_class" id="pat_class" value="<%=pat_class%>">
						<input type="hidden" name="ord_status" id="ord_status" value="<%=ord_status%>">
						<input type="hidden" value="<%=presBean_id%>" name="presBean_id">
						<input type="hidden" value="<%=presBean_name %>" name="presBean_name">
		<%
						if(!locale.equals("en")){ // added if condition for the incident : SKR-SCF-0748 [IN036983]
		%>
							<input type="hidden" name="order_from" id="order_from" value="<%=DateUtils.convertDate(order_from, "DMY","en",locale)%>">
							<input type="hidden" name="order_to" id="order_to" value="<%=DateUtils.convertDate(order_to, "DMY","en",locale)%>">
		<%				}
						else{
		%>
							<input type="hidden" name="order_from" id="order_from" value="<%=order_from%>">
							<input type="hidden" name="order_to" id="order_to" value="<%=order_to%>">
		<%              
						}
		%>
						<input type="hidden" name="pract_id" id="pract_id" value="<%=pract_id%>">
						<input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<%-- 						<input type="hidden" name="pat_id" id="pat_id" value="<%=pat_id%>"> --%>
						<input type="hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">	
						<input type="hidden" name="drug_desc" id="drug_desc" value="">
						<input type="hidden" name="tot_rec" id="tot_rec" value="<%=recCount%>">
						<input type="hidden" name="group_by" id="group_by" value="<%=group_by%>">
						<input type="hidden" name="rx_type" id="rx_type" value="<%=rx_type%>">
						<input type="hidden" name="checkcount" id="checkcount" value=<%=l%>>
						<input type="hidden" name="system_date" id="system_date" value="<%=sys_date%>">
						<input type="hidden" name="log_pract_id" id="log_pract_id" value="<%=log_pract_id%>">
						<input type="hidden" name="pract_type" id="pract_type" value="<%=pract_type%>">
						<input type="hidden" name="discharge_ind" id="discharge_ind" value="<%=discharge_ind%>">	<!-- added for #70618 -->					
						
				</form>
		<% 
			} 
		catch(Exception e) {
			out.print("Exception @ medicationreconsolationResult :"+e.toString());
			e.printStackTrace();
		}
		
%>
	</body>

</html>

