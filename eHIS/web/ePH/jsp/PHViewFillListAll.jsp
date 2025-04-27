<!DOCTYPE html>
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,eCommon.XSSRequestWrapper" %>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
 <%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<HTML>
	<HEAD>
		<!-- <LINK REL="stylesheet" TYPE="text/css" HREF="../../eCommon/html/IeStyle.css"></LINK> -->
<%
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/PHReports.js"></SCRIPT>
		<SCRIPT LANGUAGE="javascript" SRC="../js/IPFillAll.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	</HEAD>
	<title><fmt:message key="ePH.FillList.label" bundle="${ph_labels}"/> </title>
<%

	String disp_locn_code			 = request.getParameter("disp_locn_code");
	String OrderingFacility_code	 = request.getParameter("OrderingFacility_code");
	String compound_drug_ind		 = request.getParameter("compound_drug_ind");
	String nursing_unit_or_locn		 = request.getParameter("nursing_unit_or_locn");
	String Nursing_Unit_From		 = request.getParameter("Nursing_Unit_From");
	String Nursing_Unit_To			 = request.getParameter("Nursing_Unit_To");
	String Proc_Type				 = request.getParameter("Proc_Type");
//	if(Proc_Type.equals("R")){Proc_Type = "Routine";}else if(Proc_Type.equals("I")){Proc_Type="Incremental";}
	String schedule_start			 = request.getParameter("schedule_start");
	String Ip_Fill_Prd_Ahead		 = request.getParameter("Ip_Fill_Prd_Ahead");
	int Ip_Fill_Prd_Ahead_inDays     = Integer.parseInt(Ip_Fill_Prd_Ahead)/24;
	String fill_int_start_date_time  = request.getParameter("fill_int_start_date_time");
	String fill_int_end_date_time	 = request.getParameter("fill_int_end_date_time");
	String order_by_for_list		 = request.getParameter("order_by_for_list");
	String Building_Code			 = request.getParameter("Building_Code_from");
	String Building_Code_to			 = request.getParameter("Building_Code_to");
	String Floor_Code				 = request.getParameter("Floor_Code");
	if(Building_Code ==  null){Building_Code = "";}
	if(Floor_Code ==  null){Floor_Code = "";}
	String intermittent				 = "N";

	String iv_drug_ind				 = request.getParameter("iv_drug_ind");	
	String ip_excl_intermittent_fill = request.getParameter("ip_excl_intermittent_fill");
	String ip_prn_drugs              = request.getParameter("ip_prn_drugs");
	String ip_medical_items          = request.getParameter("ip_medical_items");
	String ip_fill_prd_unit			 = request.getParameter("ip_fill_prd_unit");
	String ip_fill_excl_prd_behind   = request.getParameter("ip_fill_excl_prd_behind");
	String cut_off_limit_for_new_ord = request.getParameter("cut_off_limit_for_new_ord");
	ArrayList un_alloc_records       = new ArrayList();
	int unalloc_record_cnt           =0;
	
	ArrayList seq_num_list=null;
	String mode	= CommonRepository.getCommonKeyValue("MODE_INSERT");
	HashMap fill_list_dtl = new HashMap();
	
	fill_list_dtl.put("iv_drug_ind",iv_drug_ind);
	fill_list_dtl.put("compound_drug_ind",compound_drug_ind);
	fill_list_dtl.put("ip_excl_intermittent_fill",ip_excl_intermittent_fill);
	fill_list_dtl.put("nursing_unit_or_locn",nursing_unit_or_locn);
	fill_list_dtl.put("Nursing_Unit_From_Code",Nursing_Unit_From);
	fill_list_dtl.put("Nursing_Unit_To_Code",Nursing_Unit_To);
	fill_list_dtl.put("Building_Code",Building_Code);
	fill_list_dtl.put("Building_Code_to",Building_Code_to);
	fill_list_dtl.put("Floor_Code",Floor_Code);
	fill_list_dtl.put("Proc_Type",Proc_Type);
	fill_list_dtl.put("schedule_start",schedule_start);
	fill_list_dtl.put("Ip_Fill_Prd_Ahead",Ip_Fill_Prd_Ahead_inDays+"");
	fill_list_dtl.put("Fill_Period_Unit",ip_fill_prd_unit);
	fill_list_dtl.put("ip_fill_excl_prd_behind",ip_fill_excl_prd_behind);	
	fill_list_dtl.put("order_by_for_list",order_by_for_list);
	fill_list_dtl.put("disp_locn_code",disp_locn_code);
	fill_list_dtl.put("fill_int_start_date_time",fill_int_start_date_time);
	fill_list_dtl.put("fill_int_end_date_time",fill_int_end_date_time);
	fill_list_dtl.put("cut_off_limit_for_new_ord",cut_off_limit_for_new_ord);
	fill_list_dtl.put("ip_prn_drugs",ip_prn_drugs);
	fill_list_dtl.put("ip_medical_items",ip_medical_items);
	fill_list_dtl.put("locale",locale);
	String bean_id = "IpFillAllBean" ;
	String bean_name = "ePH.IpFillAllBean";
	/* Initialize Function specific start */
	IpFillAllBean bean = (IpFillAllBean)getBeanObject(bean_id, bean_name, request ) ;
//	bean.clear() ;
//	bean.setMode( mode ) ;
//	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
    String alt_drug_remarks_ind = bean.getAltDrugRemarksInd(); //added for  Bru-HIMS-CRF-082 [IN:029948]
	String alt_drug_remarks_disp = ""; //added for  Bru-HIMS-CRF-082 [IN:029948]
	String display_dosage_details = bean.getDisplayDosageDetails(); //added for MMS-DM-CRF-0011 [IN:055302] -start
	String disp_pat_dosage_style = "display:none";
	if(display_dosage_details.equals("Y"))
		disp_pat_dosage_style = "display:inline"; //added for MMS-DM-CRF-0011 [IN:055302] -end

	bean.setFillListDtl(fill_list_dtl);
	String userAuthPINYN=bean.getUserAuthPINYN(OrderingFacility_code,disp_locn_code); // Added for RUT-CRF-0035 [IN029926] 
			userAuthPINYN=userAuthPINYN==null?"":userAuthPINYN;// Added for RUT-CRF-0035 [IN029926] 

	if(!locale.equals("en")){
		fill_int_start_date_time = com.ehis.util.DateUtils.convertDate(fill_int_start_date_time,"DMYHM",locale,"en");
		fill_int_end_date_time   = com.ehis.util.DateUtils.convertDate(fill_int_end_date_time,"DMYHM",locale,"en");
	}

	ArrayList ip_fill_list = (ArrayList)bean.getIpFillList(fill_int_start_date_time,fill_int_end_date_time,Proc_Type,intermittent,disp_locn_code,nursing_unit_or_locn,compound_drug_ind,Building_Code,Building_Code_to,Floor_Code,Nursing_Unit_From,Nursing_Unit_To,order_by_for_list,locale,OrderingFacility_code,ip_fill_excl_prd_behind,ip_excl_intermittent_fill,ip_prn_drugs,ip_medical_items);

	HashMap ip_fill_order		= new HashMap();
	String logged_fcy = bean.getLoggedInFacility();
	String prvs_nursing_unit_code = "";
	String prves_order_id = "";
	String nursing_unit_code = "";
	String nursing_unit_desc = "";
	StringTokenizer disp_qty_dtl  = new StringTokenizer("S");
	ArrayList legends=new ArrayList();
//	StringTokenizer disp_qty_btch = new StringTokenizer("S");
	String disp_qty		= "";
	String disp_qty_uom	= "";
	String disp_btch = "";
	String disp_drug_code = "";
	String disp_drug_desc = "";
	String drug_choice	  = "";
	String patient_id	  = "";
	String patient_details= "";
	String drug_color	  = "";
	String order_id		  = "";
	String order_line_num = "";
	String iv_prep_yn	  = "";
	String chk_dsbl		  = "";
	String ord_drug_code  = "";
	String ord_drug_name  = "";
	String ord_drug_qty	  = "";
	String ord_drug_uom   = "";
	String total_drugs	  = "";
	String ip_fill_chk_value = "N";
	String ip_fill_chked	 = "checked";
	String line_flag  	  = "N";
	String sex  	  = "";
	String date_of_birth  	  = "";
	String patient_Name  	  = "";
	String gender  	  = "";
	String chk_dsb1 = "disabled";
	String pre_Order_type_legend = "";
	String prev_patient_id = "";
	String disp_alt_symbol = "";
	String disp_multi_strength_yn = bean.getDispAlternate();

	String IV_with_Additives_lg="",IV_Intermittent_lg="",IV_without_Additives_lg="",Order_type_legend="";
	legends=bean.getIVLegends();
	IV_with_Additives_lg=(String)legends.get(0);
	IV_Intermittent_lg=(String)legends.get(1);
	IV_without_Additives_lg=(String)legends.get(2);
	int iv_drug_count  =0;
	String prev_iv_prep_yn  ="";
	String dosage_details = "", patient_id_disp=""; //added for MMS-DM-CRF-0011 [IN:055302]

	//intialising un allocated drug list
	bean.setUnAllocDrugList(un_alloc_records);

	/* Checking if user is a Pharmacist */
	//int continueop=bean.validatePharmacist();
	//if (continueop==0){
%>
	<!-- <script>alert("User is not a Pharmacist!!!");window.location.href =
'../../eCommon/jsp/dmenu.jsp'</script> -->
<%
	//}
	/* To get the dispense location based on the work station no */
//	ArrayList dispLocn=bean.getDispenseLocation();
	//if (dispLocn.size()==0){
%>
		<!-- <script>alert("This facility cannot be accessed from this workstation!!!");window.location.href =
'../../eCommon/jsp/dmenu.jsp'</script> -->
<%
	//}
%>
	<body onMouseDown="" onKeyDown="lockKey()">
		<FORM name="formPHViewFillList" id="formPHViewFillList"  TARGET="messageFrame" >
<% 
			if(ip_fill_list != null && ip_fill_list.size()>0){
%>
				<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
					<tr>
						<td class="BODYCOLORFILLED" ALIGN="right"><input type="checkbox" name="select_all" id="select_all" onclick="checkAll(this);" value="Y" checked></td>
					</tr>
				<table>
				<TABLE  ALIGN="center" CELLPADDING="0" CELLSPACING="0" BORDER="0" width="100%">
<%		
					seq_num_list=new ArrayList();
											
					total_drugs	  = ip_fill_list.size()+"";
					for(int i = 0; i<ip_fill_list.size();i++){
						ip_fill_order = (HashMap)ip_fill_list.get(i);
						if(!patient_id.equals((String)ip_fill_order.get("PATIENT_ID"))){
							patient_id		= (String)ip_fill_order.get("PATIENT_ID");
							patient_id_disp = patient_id;
							patient_details	= (String)ip_fill_order.get("Patient_Details");	
							patient_details=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels")+":"+patient_details;
							sex	= (String)ip_fill_order.get("sex");
							if(!display_dosage_details.equals("Y")){//if condition alone added for MMS-DM-CRF-0011 [IN:055302]
								if(sex.equals("M")){
									gender	=			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
									gender=gender+",";
								}
								else if(sex.equals("F")){
									gender	=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
									gender=gender+",";
								}
								else if(sex.equals("Unknown")){
									gender	=	com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
									gender=gender+",";
								}
							}
							date_of_birth	= (String)ip_fill_order.get("date_of_birth");
							date_of_birth   = date_of_birth+",";
							patient_Name	= (String)ip_fill_order.get("patient_Name");	
							line_flag       = "Y";
							seq_num_list.add(patient_id);
						}
						else{
							patient_details	= "";
							patient_id_disp ="";
							line_flag       = "N";
							date_of_birth   = "";
							gender   = "";
							patient_Name   = "";
							
						}					 
						//seq_num_list.add(patient_id);
						//seq_num_map.put("patient_id_"+i,seq_num_list);
						iv_prep_yn		  = (String)ip_fill_order.get("iv_prep_yn"); 
						order_id		  = (String)ip_fill_order.get("ORDER_ID"); 
						order_line_num	  = (String)ip_fill_order.get("ORDER_LINE_NUM"); 
						ord_drug_code	  = (String)ip_fill_order.get("Drug_Code"); 	
						ord_drug_name	  =	(String)ip_fill_order.get("Drug_Name");
						ord_drug_qty	  =	(String)ip_fill_order.get("ORDER_QTY");
						ord_drug_uom	  =	(String)ip_fill_order.get("ORDER_UOM");
						nursing_unit_code = (String)ip_fill_order.get("SOURCE_CODE"); 
						nursing_unit_desc = (String)ip_fill_order.get("NURSING_UNIT_DESC"); 
						disp_alt_symbol = (String)ip_fill_order.get("disp_alt_symbol"); 
						if(ip_fill_order.get("DOSAGE_DETAILS")!=null && display_dosage_details.equals("Y")) //added for MMS-DM-CRF-0011 [IN:055302]
							dosage_details = (String)ip_fill_order.get("DOSAGE_DETAILS");

					   if(iv_prep_yn.equals(""))
							Order_type_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NormalRx.label","ph_labels");
					   else if(iv_prep_yn.equals("1"))
							Order_type_legend=IV_with_Additives_lg;
						else if(iv_prep_yn.equals("3"))
							Order_type_legend=IV_Intermittent_lg;
						else if(iv_prep_yn.equals("5"))
							Order_type_legend=IV_without_Additives_lg;
						else if(iv_prep_yn.equals("9"))
							Order_type_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.OncologyRegimen.label","ph_labels");
						
						disp_qty_dtl = new StringTokenizer((String)ip_fill_order.get("Disp_qty"),"|");
						int count=disp_qty_dtl.countTokens();

						disp_qty		  ="";
						disp_qty_uom	  ="";
						disp_drug_code  ="";
						disp_drug_desc  ="";
						drug_choice     ="N";
						disp_btch		  =" ^ ^ ^ ^";

						if(count==5){
							while(disp_qty_dtl.hasMoreTokens()){
								disp_qty		= disp_qty_dtl.nextToken();
								disp_qty_uom	= disp_qty_dtl.nextToken();
								drug_choice		= disp_qty_dtl.nextToken();
								disp_drug_code  = disp_qty_dtl.nextToken();
								disp_drug_desc  = disp_qty_dtl.nextToken();
								if ( disp_drug_desc == null || disp_drug_desc.equals(" ") ){
								  disp_drug_desc= ord_drug_name;
								  ord_drug_code=ord_drug_code;
								  //drug_choice="#990033";
								  drug_color = "#990033";
								 // ip_fill_chked	 = "checked";
								  if(disp_qty.equals("0")) {
									  ip_fill_chked	 = "";
									  ip_fill_chk_value = "N";
								  }
								  else {
									  ip_fill_chked	 = "checked";
									  ip_fill_chk_value = "Y";
								  }
								  chk_dsbl = "";
								}
								drug_choice ="N";
								disp_btch		=" ^ ^ ^ ^";
							}
						}
						else if(count==6) {
							while(disp_qty_dtl.hasMoreTokens()){
							disp_qty		= disp_qty_dtl.nextToken();
							disp_qty_uom	= disp_qty_dtl.nextToken();
							drug_choice		= disp_qty_dtl.nextToken();
							disp_drug_code  = disp_qty_dtl.nextToken();
							disp_drug_desc  = disp_qty_dtl.nextToken();
							disp_btch		= disp_qty_dtl.nextToken();
							if ( (disp_drug_desc == null || disp_drug_desc.equals(" ")&&(!drug_choice.equals("C"))) ){
							  disp_drug_desc= ord_drug_name;
							  ord_drug_code=ord_drug_code;
							  //drug_choice="#990033";
							  drug_color = "#990033";
							  if(disp_qty.equals("0")){
								  ip_fill_chked	 = "";
								  ip_fill_chk_value = "N";
							  }
							  else{
								  ip_fill_chked	 = "checked";
								  ip_fill_chk_value = "Y";
							   }
							  chk_dsbl = "";
							 }
						   }//end while
						}//end else
						//System.err.println("drug_choice--->"+drug_choice);
						if(drug_choice.equals("S")){
							drug_color = "";			
							chk_dsbl = "enabled";
							//out.println("drug_choice--inside->"+drug_choice);
							//ip_fill_chked	 = "checked";
							if(disp_qty.equals("0")){
								ip_fill_chked	 = "";
								ip_fill_chk_value="N";
								chk_dsbl = "disabled";
							}
							else{
								ip_fill_chked	 = "checked";
								ip_fill_chk_value = "Y";
							}
						}
						else if(drug_choice.equals("A")){
							drug_color = "#CC6600";			
							chk_dsbl = "";
							//ip_fill_chked	 = "checked";
							if(disp_qty.equals("0")){
								ip_fill_chked	 = "";
								ip_fill_chk_value = "N"; 
							}
							else{
								ip_fill_chked	 = "checked";
								ip_fill_chk_value = "Y"; 
							}
						}
						else if(drug_choice.equals("M")){
							drug_color = "#CC00CC";
							chk_dsbl = "disabled";
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						else if(drug_choice.equals("N")){
							drug_color = "";
							disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.NoStock.label","ph_labels")+"'>";
							chk_dsbl = "disabled";
							/*if(disp_qty.equals("0")){
							  chk_dsbl = "disabled";
							 }else{
							  chk_dsbl = "";
							  } */
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						else if(drug_choice.equals("C")){
							drug_color = "red";
							disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ITEMSTORECOMBINOTFOUND.label","ph_labels")+"'>";
							chk_dsbl = "disabled";
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						else if(drug_choice.equals("U")){
							chk_dsbl = "disabled";
							drug_color = "";
							disp_drug_desc = "<img src='../../eCommon/images/disabled.gif' align='center' title='"+ com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.ItemUOMDEFNOTFound.label","ph_labels")+"'>";
							ip_fill_chk_value = "N";
							ip_fill_chked	 = "";
						}
						/*if(disp_qty.equals("0")){
							drug_color = "";
							chk_dsbl = "";
							ip_fill_chk_value = "N";
							//ip_fill_chked	 = "checked";
							ip_fill_chked	 = "";
						} */
						if(!prvs_nursing_unit_code.equals(nursing_unit_code)){
							prvs_nursing_unit_code = nursing_unit_code;
%>
							<TR>
							<th COLSPAN="10" align="left"><%=nursing_unit_desc%></th>
							</TR>
<%
						}
						if(!line_flag.equals("N")){
%>
							<TR>
							<th height="1" COLSPAN="10" align="left"></th>
							</TR>
<%
						}
%>
						<TR>
						<TD class="BODYCOLORFILLED" style="BORDER-STYLE: none solid none none" ALIGN="left" width = "27%">
						<font size="1" style="cursor:pointer;color:blue" title="Drug Profile" onclick="showDrugProfile('<%=patient_id%>');"> <label id='pat_id' style='<%=disp_pat_dosage_style%>' ><%=patient_id_disp%>&nbsp</label><%=patient_Name%>&nbsp;<%=date_of_birth%>&nbsp;<%=gender%>&nbsp;<%=patient_details%>&nbsp;</TD><!--added <label id='pat_id' for MMS-DM-CRF-0011 [IN:055302] -->
<%
						if(!pre_Order_type_legend.equals(Order_type_legend) || !prev_patient_id.equals(patient_id)){
%> 																   
							<TD class="BODYCOLORFILLED" ALIGN="left" width = "10%"><font size="1" style="font-weight:bold" title="View Order" nowrap>&nbsp;
							<%=Order_type_legend%></TD>
<%
							pre_Order_type_legend = Order_type_legend;
							prev_patient_id=patient_id;
						}
						else{
%>
							<TD class="BODYCOLORFILLED">&nbsp;</TD>
<%
						}
%>
						<TD class="BODYCOLORFILLED" ALIGN="left" width = "22%"><font size="1" style="cursor:pointer;color:blue" title="View Order"onClick="callMenuFunctions('View','Pharmacy','<%=order_id%>','','<%=patient_id%>')">
						<%=ord_drug_name%><label id='dose_dtl' style='<%=disp_pat_dosage_style%>' ><br><%=dosage_details%></label></TD><!--added <label id='dose_dtl' for MMS-DM-CRF-0011 [IN:055302] -->
						<TD class="BODYCOLORFILLED" width="3%" ALIGN="right"><font size="1"><%=ord_drug_qty%>&nbsp;</TD>
						<TD class="BODYCOLORFILLED" width="4%" style="BORDER-STYLE: none solid none none" ALIGN="left" nowrap>
						<font size="1"><%=bean.getUomDisplay(logged_fcy,ord_drug_uom)%>&nbsp;&nbsp;</TD>
<%	
						//if(drug_choice.equals("N")||drug_choice.equals("C")){
							if(!disp_multi_strength_yn.equals("Y") && disp_alt_symbol.equals("N")){//|| changed to && for IN0071324
%>
							<TD class="BODYCOLORFILLED" >&nbsp;</TD>
<%
						}
						else if(disp_alt_symbol.equals("Y")){
%>
							<TD class="BODYCOLORFILLED" align="left" nowrap style="cursor:pointer">&nbsp;<img src='../../ePH/images/altenate.jpg' height='15' width='15' align='top' onclick="altDrugSearch('<%=disp_locn_code%>','<%=ord_drug_qty%>','<%=fill_int_start_date_time%>','<%=fill_int_end_date_time%>','<%=ord_drug_code%>','<%=order_id%>','<%=order_line_num%>','<%=Proc_Type%>','<%=i%>','<%=iv_prep_yn%>','<%=nursing_unit_or_locn%>','<%=Nursing_Unit_From%>','<%=Nursing_Unit_To%>','<%=Building_Code%>','<%=Building_Code_to%>','<%=Floor_Code%>','<%=ip_fill_excl_prd_behind%>','<%=compound_drug_ind%>','<%=ip_medical_items%>','<%=ip_excl_intermittent_fill%>','<%=ip_prn_drugs%>','<%=alt_drug_remarks_ind%>')">
							</TD>
<%
						}
%>
						<input type="hidden" name="drug_code_<%=i%>" id="drug_code_<%=i%>" value="<%=disp_drug_code%>">
						<input type="hidden" name="ord_drug_code_<%=i%>" id="ord_drug_code_<%=i%>" value="<%=ord_drug_code%>">
						<input type="hidden" name="end_date_time_<%=i%>" id="end_date_time_<%=i%>" value="<%=fill_int_end_date_time%>">
						<TD class="BODYCOLORFILLED" ALIGN="left" width = "18%"  ><font size="1" color="<%=drug_color%>">
						<label id="disp_drug_id_<%=i%>" name="disp_drug_name_<%=i%>" ><%=disp_drug_desc%></label>
						&nbsp;&nbsp;&nbsp;<a href="javascript:openAltDrugRemarks('<%=order_id%>','<%= order_line_num%>','<%=alt_drug_remarks_ind%>','LINK');" id="alt_drug_remarks<%=i%>" style="display:none" title="Alternate Drug Remarks"><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a><img  style="display:none"  id="alt_remarks_image_<%=i%>" src="../../eCommon/images/mandatory.gif"></img></label>
						</TD>
						<TD class="BODYCOLORFILLED" style="BORDER-STYLE: none solid none none" ALIGN="center" nowrap><font size="1"><%=(String)ip_fill_order.get("Tot_Disp_Qty")%></TD>
<%
						if(drug_choice.equals("M") || drug_choice.equals("N") || drug_choice.equals("C")){
%>
							<TD class="BODYCOLORFILLED" style="BORDER-STYLE: none solid none none" ALIGN="left" nowrap><font size="1" style="" title="Batch Details" onclick="showBatchDetails('<%=i%>','<%=order_id%>');" ><label id="disp_qty_id_<%=i%>" name="disp_qty_<%=i%>" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_qty%></label>
							<input type='hidden' name="stock_yn<%=i%>" id="stock_yn<%=i%>" value='N'>
<%
						}
						else{
%>
							<TD class="BODYCOLORFILLED" style="BORDER-STYLE: none solid none none" ALIGN="left" nowrap><font size="1"  style="cursor:pointer;color:blue" title="Batch Details" onclick="showBatchDetails('<%=i%>','<%=order_id%>','<%=bean.getUomDisplay(logged_fcy,disp_qty_uom)%>');" ><label id="disp_qty_id_<%=i%>" name="disp_qty_<%=i%>" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=disp_qty%></label>
							<input type='hidden' name="stock_yn<%=i%>" id="stock_yn<%=i%>" value='Y'>
<%
						}
%>
						&nbsp;<label id="disp_qty_uom_id_<%=i%>" name="disp_qty_uom_<%=i%>" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<%=bean.getUomDisplay(logged_fcy,disp_qty_uom)%></label>
						<input type="hidden" name="disp_batch_dtl_<%=i%>" id="disp_batch_dtl_<%=i%>" value="<%=disp_btch%>">
						</TD>
						<input type="hidden" name="disp_uom_id_<%=i%>" id="disp_uom_id_<%=i%>" value="<%=disp_qty_uom%>">
<%
						if(!prves_order_id.equals(order_id)){   
							if(prev_iv_prep_yn.equals("1")||prev_iv_prep_yn.equals("3")||prev_iv_prep_yn.equals("4")||prev_iv_prep_yn.equals("9")){
%>
								 <script>
									 checktwo('<%=i%>',<%=iv_drug_count%>);
								 </script>  
<%
							}	
							iv_drug_count =0;
%>
							<TD class="BODYCOLORFILLED" ALIGN="right"><input type="checkbox" name="ip_fill_chk_<%=i%>" id="ip_fill_chk_<%=i%>" value="<%=ip_fill_chk_value%>" <%=chk_dsbl%> <%=ip_fill_chked%> onclick="checkOne(this,'<%=i%>')"></TD>
<% 
							prves_order_id = order_id; prev_iv_prep_yn =iv_prep_yn;
						}
						else{
							iv_drug_count =iv_drug_count+1;
%>
							<TD class="BODYCOLORFILLED" ALIGN="right"><input type="checkbox" name="ip_fill_chk_<%=i%>" id="ip_fill_chk_<%=i%>" value="<%=ip_fill_chk_value%>" <%=chk_dsb1%> <%=ip_fill_chked%> onclick="checkOne(this,'<%=i%>')"></TD>
<%
						}
						if(drug_choice.equals("N")){
							un_alloc_records.add(Proc_Type);
							un_alloc_records.add(nursing_unit_code);
							un_alloc_records.add(patient_id);
							un_alloc_records.add(ord_drug_code);
							un_alloc_records.add(disp_qty);
							un_alloc_records.add(disp_qty_uom);
							un_alloc_records.add(order_id); //Added for SRR20056-SCF-7499
							un_alloc_records.add(order_line_num); //Added for SRR20056-SCF-7499
							unalloc_record_cnt++;
%>      
							<TD class="BODYCOLORFILLED" ALIGN="right"><input type="checkbox" name="ip_fill_inculde_report_<%=i%>" id="ip_fill_inculde_report_<%=i%>" value="Y"  checked style ="visibility:hidden"></TD>
<%
						}
						else{
%>
							<TD class="BODYCOLORFILLED" ALIGN="right"><input type="checkbox" name="ip_fill_inculde_report_<%=i%>" id="ip_fill_inculde_report_<%=i%>" value="N" style ="visibility:hidden" ></TD>
<%
						}
%>
						</TR>
						<input type="hidden" name="order_id_<%=i%>" id="order_id_<%=i%>"  value="<%=order_id%>">
						<input type="hidden" name="order_line_num_<%=i%>" id="order_line_num_<%=i%>"   value="<%=order_line_num%>">
						<input type="hidden" name="drug_choice_<%=i%>" id="drug_choice_<%=i%>"   value="<%=drug_choice%>">
						<input type="hidden" name="patient_id<%=i%>" id="patient_id<%=i%>"   value="<%=patient_id%>">
						<input type="hidden" name="check_box_checked_yn_<%=i%>" id="check_box_checked_yn_<%=i%>"   value="Y">
						<input type="hidden" name="iv_prep_yn_<%=i%>" id="iv_prep_yn_<%=i%>"   value="<%=iv_prep_yn%>">
<%
					}
%>
					<script> 
						 checktwo(<%=total_drugs%>,<%=iv_drug_count%>);
					</script>
<%
					bean.setUnAllocDrugList(un_alloc_records);
					bean.setPatientList(seq_num_list);
%>
					<TR>
					<th height="1" COLSPAN="10" align="left"></th>
					</TR>
				</TABLE>
<%
			}
			else{
%>
				<script>
				alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","Common"));
				window.close();
				</script>
<%
			}
%>
			<INPUT TYPE="hidden" name="bean_id" id="bean_id"		VALUE="<%= bean_id %>">
			<INPUT TYPE="hidden" name="bean_name" id="bean_name"	VALUE="<%= bean_name %>">
			<INPUT TYPE="hidden" name="total_drugs" id="total_drugs"	VALUE="<%= total_drugs %>">
			<INPUT TYPE="hidden" name="store_code" id="store_code"	VALUE="<%=disp_locn_code%>">
			<INPUT TYPE="hidden" name="unalloc_record_cnt" id="unalloc_record_cnt"	VALUE="<%=unalloc_record_cnt%>">
			<INPUT TYPE="hidden" name="Proc_Type" id="Proc_Type"	VALUE="<%=Proc_Type%>">
			<INPUT TYPE="hidden" name="userAuthPINYN" id="userAuthPINYN" value="<%=userAuthPINYN%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
			<INPUT TYPE="hidden" name="alt_drug_remarks_ind" id="alt_drug_remarks_ind" value="<%=alt_drug_remarks_ind%>">
			<script>
				//checkAll(document.formPHViewFillList.select_all)	
			</script>
			</FORM>
			 <FORM name="formPHGenerateFillList" id="formPHGenerateFillList"  TARGET="messageFrame" >
			<br>
			<br>
			<INPUT TYPE="hidden" name="mode" id="mode"		VALUE="<%= mode %>">
			<INPUT TYPE="hidden" name="function_id" id="function_id" VALUE="<%= bean.getFunctionId() %>">
			<INPUT TYPE="hidden" name="facility_id" id="facility_id" VALUE="<%= logged_fcy %>">
			<INPUT TYPE="hidden" name="nursing_unit_query" id="nursing_unit_query" VALUE="<%= PhRepository.getPhKeyValue( "SQL_PH_NURSINGUNIT_LOOKUP" ) %>">
			<INPUT TYPE="hidden" name="Nursing_Unit_From_Code" id="Nursing_Unit_From_Code">
			<INPUT TYPE="hidden" name="Nursing_Unit_To_Code" id="Nursing_Unit_To_Code" >
			<INPUT TYPE="hidden" name="Default_Fill_Period" id="Default_Fill_Period" >
			<INPUT TYPE="hidden" name="Schedule_Start_Time_Routine" id="Schedule_Start_Time_Routine" >
			<INPUT TYPE="hidden" name="Exclude_Hrs" id="Exclude_Hrs" >
			<INPUT TYPE="hidden" name="Disp_Locn" id="Disp_Locn" >
			<INPUT TYPE="hidden" name="cDate" id="cDate" >
			<INPUT TYPE="hidden" name="cMonth" id="cMonth">
			<INPUT TYPE="hidden" name="cYear" id="cYear" >
			<INPUT TYPE="hidden" name="cHours" id="cHours">
			<INPUT TYPE="hidden" name="cMinutes" id="cMinutes">
			<INPUT TYPE="hidden" name="currHours" id="currHours">
			<INPUT TYPE="hidden" name="currMinutes" id="currMinutes">
			<INPUT TYPE="hidden" name="Fill_Period_Unit" id="Fill_Period_Unit">
			<INPUT TYPE="hidden" name="cut_off_limit_for_new_ord" id="cut_off_limit_for_new_ord">
			<INPUT TYPE="hidden" name="routinefillalreadyinvoked" id="routinefillalreadyinvoked">
			<INPUT TYPE="hidden" name="incstarttime" id="incstarttime">
			<INPUT TYPE="hidden" name="incendtime" id="incendtime">
			<INPUT TYPE="hidden" name="fill_int_start_date_time" id="fill_int_start_date_time" value="<%=fill_int_start_date_time%>"> 

		</FORM> 
		<!--<script>disableAll(true)</script>-->
		<% putObjectInBean(bean_id,bean,request); %>
	</body>
</html>

