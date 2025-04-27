<!DOCTYPE html>
<%
/*
---------------------------------------------------------------------------------------------------------------------------------	
	Date		Edit History	Name		Rev.Date   	Rev.By 		Description
--------------------------------------------------------------------------------------------------------------------------------

22/11/2019      IN070800        PRATHYUSHA                          ML-MMOH-SCF-1303
-------------------------------------------------------------------------------------------------------------------------------
*/
%>

<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%-- Mandatory declarations end --%>
<html>
	<head>
	<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<script language="javascript" src="../../eCommon/js/CommonCalendar.js"></script>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../eCommon/js/CommonLookup.js"></SCRIPT>	   
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/dchk.js"></SCRIPT>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/DateUtils.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DispMedication.js"></script>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<script language="JavaScript" src="../../ePH/js/PhCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
 <!-- Added for RollForward from SRR - SRR20056-SCF-9422 -->
		<title><fmt:message key="ePH.ManufacturingLabelDetails.label" bundle="${ph_labels}"/></title>
	</head>
<%!
	public String roundTwoDigits(String a){
		try{
			String bb = "";
			if (a.indexOf(".")==-1){
				bb=a.substring(0,a.length());
			}
			else{
				bb=a.substring(a.indexOf("."),a.length());
				if (bb.length() > 3){
					bb=a.substring(0,a.indexOf(".")+3);
				}
				else{
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
	<!-- <body topmargin="0"> -->
	<body onMouseDown="" onKeyDown="lockKey()" topmargin="0">
<%
Connection con			= null;  // Added for ML-MMOH-crf-0468 

		try{
		//String params = request.getQueryString();
		con				= ConnectionManager.getConnection(request);  // Added for ML-MMOH-crf-0468 
        boolean tpn_mf_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468
		boolean verify_adm_drug = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","VERIFY_ADM_DRUG");// added for MMS-KH-CRF-0017
		verify_adm_drug = true;
		String mode				= "";
		String order_id1	    = request.getParameter( "order_id" );
		if(order_id1 == null) 
		order_id1 = "";
		String ord_type			= "";

		String	bean_id			=	"DispMedicationBean" ;
		String	bean_name		=	"ePH.DispMedicationBean";
		DispMedicationBean bean	= (DispMedicationBean)getBeanObject( bean_id, bean_name, request);
		//bean.setLanguageId(locale);

		String	bean_id1				=	"DispMedicationAllStages" ;
		String	bean_name1				=	"ePH.DispMedicationAllStages";
		DispMedicationAllStages beanAs	= (DispMedicationAllStages)getBeanObject( bean_id1, bean_name1, request);
		//beanAs.setLanguageId(locale);

		String bean_id2			 = "TPNWorkSheetBean";
		String bean_name2		 = "ePH.TPNWorkSheetBean";
		TPNWorkSheetBean bean_ws = (TPNWorkSheetBean)getBeanObject(bean_id2,bean_name2,request);
		bean_ws.setLanguageId(locale);

		ord_type	=	bean.getOrderType();
		mode		=	bean.getDispStage();
		String disp_locn1	=	bean.getDispLocnCode();
		String today		=	bean.getTodaysDateTime();
		String order_id		=	bean.getOrderID();	

		if(order_id.equals("")){
			order_id = bean.getOrderID1();
		}

		String sUpdateMFGDetails = "N";
		String disp_locn_catg	 = bean.getDispLocnCatg();
		if(( (bean.getDispStage().equals("F") && bean.getFillingStatus().equals("A"))|| (bean.getDispStage().equals("A") && bean.getFillingStatus().equals("B")))&&(!disp_locn_catg.equals("I"))){
			 sUpdateMFGDetails ="Y";
		}

		String product_name		 = "";
		String batch_id			 = "";
		String expire_date		 = "";
		String qty_value		 = "";
		String qty_uom			 = "";
		String stability_hrs	 = "";
		String tmp_stb_hrs		 = "";
		String facility_id		 = "";
		String disp_locn		 = "";
		String worksheet_id		 = "";
		String admin_remarks	 = "";
		String infusion_line	 = "";
		String batch_wrksht_id	 = "";
		String overage_volume    ="";
		String flow_rate		 = "";
		String infuse_over		 = "";
		String batchIpOptions="";//Added for ml-mmoh-crf-0468
		String expieryDateOptions="";//Added for ml-mmoh-crf-0468
		ArrayList manfctr_dtls = new ArrayList();
		ArrayList drugDtls = new ArrayList();
		HashMap drugValues = new HashMap();
		String finalise_yn_deli =  "";
		String finalise_yn_val  =  "N";
		String finalised_style="";
		String tpn_param_expiary_date ="";
		String display_legends ="visibility:visible";

		if(mode.equals("D")||disp_locn_catg.equals("O")){
			finalise_yn_deli = "checked disabled"; 
			//if((bean.getDispStage().equals("F") && (bean.getFillingStatus().equals("A")  ))|| (bean.getDispStage().equals("A") && (bean.getFillingStatus().equals("B")  ))||(bean.getDispStage().equals("D"))){
				finalise_yn_val  = "Y";
			//}
		}
		if(disp_locn_catg.equals("O")){
			finalised_style  ="Display:none";
		}
		if(!mode.equals("D")){
			if(ord_type.equals("IVAD")||ord_type.equals("IVAA") || ord_type.equals("IVID")||ord_type.equals("IVIA") || ord_type.equals("CA") || ord_type.equals("CO")){
				batch_wrksht_id = bean.getWorksheetID();
					if(batch_wrksht_id.equals("")) { 
						batch_wrksht_id = bean.getNxtWrkshtId("IVRCA",disp_locn1);
					} 
				batch_id = batch_wrksht_id +"/"+today.substring(6,10);
			}
			else if(ord_type.equals("TA")  || (ord_type.equals("TD") && tpn_mf_label) ) {//modified for ml-mmoh-crf-0468
				batch_wrksht_id = bean.getTPNWorksheetID(order_id);
				if(batch_wrksht_id.equals("")) { 
					batch_wrksht_id = bean.getNxtWrkshtId("TPN",disp_locn1);
				} 
				batch_id = batch_wrksht_id +"/"+today.substring(6,10);
			}
		}

		if(ord_type.equals("IVAA")||ord_type.equals("IVAD") || ord_type.equals("IVIA")||ord_type.equals("IVID") || ord_type.equals("CA") || ord_type.equals("CO")){

			if(!mode.equals("D")){
				manfctr_dtls = bean.getManufactureDetails(order_id);
				if(!ord_type.equals("CO")){
					product_name = product_name + "Mixture of ";
					product_name = product_name + (String)manfctr_dtls.get(1);
					product_name = product_name + " injection";
				}

				if(manfctr_dtls.size()>1){	
					drugDtls =(ArrayList)manfctr_dtls.get(2);

					for(int i=0; i<drugDtls.size(); i++){
						drugValues = (HashMap)drugDtls.get(i);
						tmp_stb_hrs	= (String)drugValues.get("STABILITY_HRS");
					
						if(tmp_stb_hrs != null && !tmp_stb_hrs.equals("0") ){
						  if(stability_hrs.equals("")) stability_hrs = 	(String)drugValues.get("STABILITY_HRS");
						  tmp_stb_hrs = (String)drugValues.get("STABILITY_HRS");
						  if(Integer.parseInt(tmp_stb_hrs) < Integer.parseInt(stability_hrs)) stability_hrs = tmp_stb_hrs;
						}else{
							stability_hrs="0";
						}
					}
				}
				if(Integer.parseInt(stability_hrs) >0) 
					expire_date = bean.getExpireDateMixture(stability_hrs);
				drugDtls	=(ArrayList)manfctr_dtls.get(0); 
				String fluid_line =(String)drugDtls.get(1);
				if(!ord_type.equals("CO")){
					if(fluid_line.equals("1")) qty_value = (String)drugDtls.get(2);
				}
				drugDtls =(ArrayList)manfctr_dtls.get(2); 
				drugValues = (HashMap)drugDtls.get(0);
				if(!ord_type.equals("CO")){
					qty_uom = (String)drugValues.get("PRES_BASE_UOM");
				}

			   manfctr_dtls = bean.getMfctrLabelDtls(order_id);	
			   if(manfctr_dtls.size() > 0){
					facility_id		= (String)manfctr_dtls.get(0);
					disp_locn		= (String)manfctr_dtls.get(1);
					worksheet_id	= (String)manfctr_dtls.get(2);
					product_name	= (String)manfctr_dtls.get(3);
					batch_id		= (String)manfctr_dtls.get(4);
					expire_date		= (String)manfctr_dtls.get(5);
					qty_value		= (String)manfctr_dtls.get(6);
					qty_uom			= (String)manfctr_dtls.get(7);
					admin_remarks	= (String)manfctr_dtls.get(8);

					if(facility_id==null || facility_id=="null") 
						facility_id="";

					if(disp_locn==null || disp_locn=="null")
						disp_locn="";

					if(worksheet_id==null || worksheet_id=="null")
						worksheet_id="";

					if(product_name==null || product_name=="null")
						product_name="";

					if(batch_id==null || batch_id=="null")
						batch_id="";

					if(expire_date==null || expire_date=="null") 
						expire_date="";

					if(qty_value==null || qty_value=="null")
						qty_value="1";

					if(qty_uom==null || qty_uom=="null") 
						qty_uom="";

					if(admin_remarks==null || admin_remarks=="null") 
						admin_remarks="";			
				}
			}
			else{
				manfctr_dtls = bean.getMfctrLabelDtls(order_id1);	
				worksheet_id=bean.getWorksheetID();

				if(manfctr_dtls.size() > 0){
					facility_id		= (String)manfctr_dtls.get(0);
					disp_locn		= (String)manfctr_dtls.get(1);
					worksheet_id	= (String)manfctr_dtls.get(2);
					product_name	= (String)manfctr_dtls.get(3);
					batch_id		= (String)manfctr_dtls.get(4);
					expire_date		= (String)manfctr_dtls.get(5);
					qty_value		= (String)manfctr_dtls.get(6);
					qty_uom			= (String)manfctr_dtls.get(7);
					admin_remarks	= (String)manfctr_dtls.get(8);

					if(facility_id==null || facility_id=="null") 
						facility_id="";

					if(disp_locn==null || disp_locn=="null")
						disp_locn="";

					if(worksheet_id==null || worksheet_id=="null")
						worksheet_id="";

					if(product_name==null || product_name=="null")
						product_name="";

					if(batch_id==null || batch_id=="null")
						batch_id="";

					if(expire_date==null || expire_date=="null") 
						expire_date="";

					if(qty_value==null || qty_value=="null")
						qty_value="1";

					if(qty_uom==null || qty_uom=="null") 
						qty_uom="";

					if(admin_remarks==null || admin_remarks=="null") 
						admin_remarks="";			
				}
			}
			infuse_over		= bean_ws.getInfuseOver(order_id);
			if(!ord_type.equals("CO")){
				flow_rate		= (Float.parseFloat(qty_value) /Float.parseFloat(infuse_over))+"";
				flow_rate		= roundTwoDigits(flow_rate); 
			}
			tpn_param_expiary_date="";
		}
		else if(ord_type.equals("TA")) {
			manfctr_dtls = bean.getManufactureDetailsTPN(order_id,disp_locn1);	
			expire_date = bean_ws.getTPNExpDate();
			tpn_param_expiary_date =expire_date;
			if(manfctr_dtls.size() > 0){
				facility_id		= (String)manfctr_dtls.get(0);
				disp_locn		= (String)manfctr_dtls.get(1);
				worksheet_id	= (String)manfctr_dtls.get(2);
				product_name	= (String)manfctr_dtls.get(3);
				batch_id		= (String)manfctr_dtls.get(4);
				expire_date		= (String)manfctr_dtls.get(5);
				qty_value		= (String)manfctr_dtls.get(6);
				qty_uom			= (String)manfctr_dtls.get(7);
				admin_remarks	= (String)manfctr_dtls.get(8);
				infusion_line	= (String)manfctr_dtls.get(9);
				if(facility_id==null || facility_id=="null")
					facility_id="";

				if(disp_locn==null || disp_locn=="null") 
					disp_locn="";

				if(worksheet_id==null || worksheet_id=="null") 
					worksheet_id="";

				if(product_name==null || product_name=="null") 
					product_name="";

				if(batch_id==null || batch_id=="null") 
					batch_id="";

				if(expire_date==null || expire_date=="null") 
					expire_date="";

				if(qty_value==null || qty_value=="null")
					qty_value="1";

				if(qty_uom==null || qty_uom=="null") 
					qty_uom="";
				if(admin_remarks==null || admin_remarks=="null") 
					admin_remarks="";
			}
			
			if(qty_value.equals("")) //Added for ICN-35047[ReOpen]-Start
				qty_value	= beanAs.getTPNQty();
			if(qty_value.equals(""))
				qty_value = "0";   //Added for ICN-35047[ReOpen]-end

			if(!mode.equals("D")){
				if(qty_value.equals("")){
					qty_value		= beanAs.getTPNQty();
				}

				qty_uom	= bean_ws.getPrescBaseUnit();

				if(product_name.equals("")){
					product_name	= bean.getTPNNonStdRegimenDesc(order_id);
				}
				if(infusion_line.equals("")){
					infusion_line   = bean.getInfusionLine(order_id);
				}
			}
			overage_volume	= beanAs.getOverageVol();
			if(overage_volume == null || overage_volume.equals("")){
				overage_volume = "";
				bean_ws.setOverageVolume(order_id);
				overage_volume	= bean_ws.getOverageVolume();
						if(overage_volume == null || overage_volume.equals("")){ overage_volume = "0";}
			}
			infuse_over		= bean_ws.getInfuseOver(order_id);
			flow_rate		= ((Float.parseFloat(qty_value) - Float.parseFloat(overage_volume))/Float.parseFloat(infuse_over))+"";
			flow_rate		= roundTwoDigits(flow_rate);
			display_legends  ="visibility:hidden";
		}
		//Added for ml-mmoh-crf-0468 start
	if( ord_type.equals("TD") && tpn_mf_label)	{ 
		System.out.println("order_id1"+order_id1);
		System.out.println("helllooooooooooo"+ bean.getManufactureDetailsTPN(order_id1,disp_locn1));	
		
		//prathyusha
		System.out.println("label page -->"+beanAs.getDrugDetail(bean.getPatientID(), order_id1, "1"));
		manfctr_dtls = bean.getManufactureDetailsTPN(order_id,disp_locn1);	
		
//label page -->[TPN, EWQ, 30/12/2017, 10, ML, , ALPRANAX, 02, 0.0, ML, TPN, SFSFS, 25/04/2018, 29, ML, , ALPRANAX, 02, 0.0, ML]
		ArrayList BatchDetails = new ArrayList();
BatchDetails = beanAs.getDrugDetail(bean.getPatientID(), order_id1 , "1");
System.out.println("helllooooooooooo2BatchDetails"+ BatchDetails);	
int batch_size = BatchDetails.size();
int tc=batch_size/10;
int temp_qty=0;
manfctr_dtls = bean.getManufactureDetailsTPN(order_id1,disp_locn1);	
expire_date = bean_ws.getTPNExpDate();
tpn_param_expiary_date =expire_date;
if(manfctr_dtls.size() > 0 && batch_size == 0){
	facility_id		= (String)manfctr_dtls.get(0);
	disp_locn		= (String)manfctr_dtls.get(1);
	worksheet_id	= (String)manfctr_dtls.get(2);
	product_name	= (String)manfctr_dtls.get(3);
	batch_id		= (String)manfctr_dtls.get(4);
	expire_date		= (String)manfctr_dtls.get(5);
	qty_value		= (String)manfctr_dtls.get(6);
	qty_uom			= (String)manfctr_dtls.get(7);
	admin_remarks	= (String)manfctr_dtls.get(8);
	infusion_line	= (String)manfctr_dtls.get(9);
	if(facility_id==null || facility_id=="null")
		facility_id="";

	if(disp_locn==null || disp_locn=="null") 
		disp_locn="";

	if(worksheet_id==null || worksheet_id=="null") 
		worksheet_id="";

	if(product_name==null || product_name=="null") 
		product_name="";

	if(batch_id==null || batch_id=="null") 
		batch_id="";

	if(expire_date==null || expire_date=="null") 
		expire_date="";

	if(qty_value==null || qty_value=="null")
		qty_value="1";

	if(qty_uom==null || qty_uom=="null") 
		qty_uom="";
	if(admin_remarks==null || admin_remarks=="null") 
		admin_remarks="";
	
	batchIpOptions  =batchIpOptions+"<option value='"+batch_id+"' selected>"+batch_id+"</option>";
    expieryDateOptions  =expieryDateOptions+"<option value='"+expire_date+"' selected>"+expire_date+"</option>"; 
    temp_qty = Integer.parseInt(qty_value);
}
else{
System.out.println("if  batch_size"+batch_size);
for(int i=1;i<batch_size;i=i+10){
	if(i==1){
		batchIpOptions  =batchIpOptions+"<option value='"+(String) BatchDetails.get(i)+"' selected>"+(String) BatchDetails.get(i)+"</option>";
		expieryDateOptions  =expieryDateOptions+"<option value='"+(String) BatchDetails.get(i+1)+"' selected>"+(String) BatchDetails.get(i+1)+"</option>";
	   
	}
	else{
		
		batchIpOptions  =batchIpOptions+"<option value='"+(String) BatchDetails.get(i)+"'>"+(String) BatchDetails.get(i)+"</option>";
		expieryDateOptions  =expieryDateOptions+"<option value='"+(String) BatchDetails.get(i+1)+"'>"+(String) BatchDetails.get(i+1)+"</option>";
	}
	
	qty_value =(String) BatchDetails.get(i+2);
	
	temp_qty +=Integer.parseInt(qty_value);  
	qty_uom = (String) BatchDetails.get(i+3);
	
}
}

            qty_value = ""+temp_qty;

				if(!mode.equals("D")){
			if(qty_value.equals("")){
				qty_value		= beanAs.getTPNQty();
			}

			//qty_uom	= bean_ws.getPrescBaseUnit();//commented for ML-MMOH-SCF-1303

			if(product_name.equals("")){
				product_name	= bean.getTPNNonStdRegimenDesc(order_id1);
			}
			if(infusion_line.equals("")){
				infusion_line   = bean.getInfusionLine(order_id1);
			}
		}
		overage_volume	= beanAs.getOverageVol();
		if(overage_volume == null || overage_volume.equals("")){
			overage_volume = "";
			bean_ws.setOverageVolume(order_id);
			overage_volume	= bean_ws.getOverageVolume();
					if(overage_volume == null || overage_volume.equals("")){ overage_volume = "0";}
		}
		infuse_over		= bean_ws.getInfuseOver(order_id1);
		flow_rate		= ((Float.parseFloat(qty_value) - Float.parseFloat(overage_volume))/Float.parseFloat(infuse_over))+"";
		flow_rate		= roundTwoDigits(flow_rate);
		display_legends  ="visibility:hidden";
		}
				//Added for ml-mmoh-crf-0468 end
		boolean showHideExtraColumns = true;
		int iSelectedIndex	=	2;
	   if(ord_type.equals("CO"))
			iSelectedIndex	=	0;
		else if(ord_type.equals("CA"))
			iSelectedIndex	=	2;
		else
			iSelectedIndex	=	1;
//out.println("=== ord_type $"+ord_type+"$ "+ ord_type.equals("CO") + " == iSelectedIndex "+ iSelectedIndex);
%>
		<form name="fromDispMedicationWSLabel" id="fromDispMedicationWSLabel" >
			<table cellpadding="0" cellspacing="0" width="103%" align="center" border="0">
				<tr>
					<td class="label" style ="<%=display_legends%>" ><fmt:message key="ePH.Admixture.label" bundle="${ph_labels}"/> <fmt:message key="Common.type.label" bundle="${common_labels}"/></td>
					<td  style ="<%=display_legends%>">&nbsp;&nbsp;
						<select name="OrderType" id="OrderType" onchange="resetProductName()">
							<option value="CR"><fmt:message key="ePH.CompoundingOrder.label" bundle="${ph_labels}"/> </option>
							<option value="IV"><fmt:message key="Common.IVAdmixture.label" bundle="${common_labels}"/></option>
							<option value="OA"><fmt:message key="ePH.OncologyAdmixture.label" bundle="${ph_labels}"/></option>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label" ><fmt:message key="Common.ProductName.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;
						<input type="text" name="mfg_unit" id="mfg_unit" value="<%=product_name%>" size="40" maxlength="40">
						<input type="button" name="searchPrdName" id="searchPrdName" onclick="searchPrdCode()" class="button" value="?" style ="<%=display_legends%>">
						<img src="../../eCommon/images/mandatory.gif" align="center" ></img>
					</td>
				</tr>
				
			<%	if( ord_type.equals("TD") && tpn_mf_label )	{//IF condtion added for ml-mmoh-crf-0468 %>
				<tr>
					<td class="label" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					
					<td  >&nbsp;&nbsp;
						<select name="batch_id" id="batch_id" id="batch_id" onchange="bachChange(this)">
						
							<%=batchIpOptions%>
						</select>
					</td>
				</tr>
				
				<%}
				else{ %>
								
				<tr>
					<td class="label" ><fmt:message key="Common.BatchID.label" bundle="${common_labels}"/></td>
					<td >&nbsp;&nbsp;
						<input type="text" name="batch_id" id="batch_id" value="<%=batch_id%>" size="10" maxlength="10" onKeyPress="return  CheckForSpecialChars(event,'<%=verify_adm_drug%>');" onblur="changeToSingleQuotes(this)"><!--changed restrictAMP to CheckForSpecialChars for MMS-KH-CRF-0017-->
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
					</td>
				</tr>
			<%	}
				%>
				<%if(ord_type.equals("TD") && tpn_mf_label){ //IF condtion added for ml-mmoh-crf-0468  %>
				<tr>
					<td class="label" ><fmt:message key="ePH.ExpiryDate/Time.label" bundle="${ph_labels}"/></td>
					<td >&nbsp;&nbsp;
						<select name="expiry_date" id="expiry_date"  id ="expiry_date" disabled >
						
							<%=expieryDateOptions%>
						</select>
						<img src="../../eCommon/images/mandatory.gif" align="center" ></img> <!-- <img src="../../eCommon/images/mandatory.gif" align="center" ></img> Added for IN64820-->
					</td>
				</tr><%}
				else{%>
				<tr>
					<td class="label" ><fmt:message key="ePH.ExpiryDate/Time.label" bundle="${ph_labels}"/></td>
					<td >&nbsp;&nbsp;
						<input type="text" name="expiry_date" id="expiry_date" value="<%=com.ehis.util.DateUtils.convertDate(expire_date,"DMYHM","en",locale)%>" size="16" maxlength="16" onBlur="if(CheckDateLeap(this,'DMYHM','<%=locale%>')) validateExpiryDate(this,today,'<%=tpn_param_expiary_date%>','<%=ord_type%>');"> <!--CheckDateLeap Added RollForward from SRR - SRR20056-SCF-9422 -->
						<img SRC="../../eCommon/images/CommonCalendar.gif" id=Calendar onclick="showCalendar('expiry_date',null,'hh:mm',true);document.fromDispMedicationWSLabel.expiry_date.focus();return false;" >
						<img src="../../eCommon/images/mandatory.gif" align="center"></img>
						<input type="hidden" name="today" id="today" value="<%=today%>" size="16" maxlength="16" >
					</td>
				</tr>
				<%}%>
				
<%
				if(ord_type.equals("TA")){
%>
					<tr>
						<td class="label" ><fmt:message key="ePH.PreparedQty/UOM.label" bundle="${ph_labels}"/></td>
						<td  class="label">&nbsp;
							<input type="text" name="qty_volume" id="qty_volume" value="<%=qty_value%>" size="7" maxlength="11" onkeyPress='return allowValidNumber(this,event,6,4)' onBlur="if(CheckNum(this)){return validateNumbers(this,6,4);}" >&nbsp;<input type="text" name="qty_uom" id="qty_uom" value="<%=beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)%>" size="6" maxlength="6"  onkeypress="return restrictAMP(event)" onblur="changeToSingleQuotes(this)"> <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 -->
							<img src="../../eCommon/images/mandatory.gif" align="center"></img>&nbsp;&nbsp;
						    <fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/><label class="label" id="flow_rate" name="flow_rate" value=""><b>&nbsp;<%=flow_rate%>&nbsp; <%=beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)%>/Hour</b></label> <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 -->
						</td>
					</tr>
<%
				}
				else{
%>
					<tr>
						<td class="label" ><fmt:message key="ePH.PreparedQty.label" bundle="${ph_labels}"/></td>
						<td  class="label">&nbsp;
						<%	 if( ord_type.equals("TD") && tpn_mf_label)	{%>
							<input type="text" name="qty_volume" id="qty_volume" disabled value="<%=qty_value%>" size="7" maxlength="11" onkeyPress='return allowValidNumber(this,event,6,4)'  onBlur="if(CheckNum(this)){return validateNumbers(this,6,4);};" >&nbsp;<input disabled  type="text" name="qty_uom" id="qty_uom" value="<%=beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)%>" size="6" maxlength="6"   onkeypress="return restrictAMP(event)" onblur="changeToSingleQuotes(this)"><img src="../../eCommon/images/mandatory.gif" align="center"></img>&nbsp;&nbsp; <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 --> 
<%
                             }
							 else{ %>
								 <input type="text" name="qty_volume" id="qty_volume"  value="<%=qty_value%>" size="7" maxlength="11" onkeyPress='return allowValidNumber(this,event,6,4)'  onBlur="if(CheckNum(this)){return validateNumbers(this,6,4);};" >&nbsp;<input type="text" name="qty_uom" id="qty_uom" value="<%=beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)%>" size="6" maxlength="6"   onkeypress="return restrictAMP(event)" onblur="changeToSingleQuotes(this)"><img src="../../eCommon/images/mandatory.gif" align="center"></img>&nbsp;&nbsp; <!-- beanAs.getUOMDesc(qty_uom) added for TBMC-SCF-0015 -->
					<%	}
						if(!ord_type.equals("CO")){if( ord_type.equals("TD") && tpn_mf_label)	{//ADDED FOR ML-MMOH-SCF-1303
%>
							<fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/><label class="label" id="flow_rate" name="flow_rate" value=""><b>&nbsp;<%=flow_rate%>&nbsp; <%=beanAs.checkForNull(beanAs.getUOMDesc(bean_ws.getPrescBaseUnit()),bean_ws.getPrescBaseUnit())%>/Hour</b></label> <!-- qty_uom Changed to beanAs.getUOMDesc(qty_uom) for ML-MMOH-SCF-1041  Modified for TBMC-SCF-0015 -->
<%
						}else{
	%>
	    <fmt:message key="ePH.FlowRate.label" bundle="${ph_labels}"/><label class="label" id="flow_rate" name="flow_rate" value=""><b>&nbsp;<%=flow_rate%>&nbsp; <%=beanAs.checkForNull(beanAs.getUOMDesc(qty_uom),qty_uom)%>/Hour</b></label> <!-- qty_uom Changed to beanAs.getUOMDesc(qty_uom) for ML-MMOH-SCF-1041  Modified for TBMC-SCF-0015 -->
	<%						
						}}
%>
						</td>
					</tr>
	<!-- <tr>
		<td class="label" ><fmt:message key="ePH.QtyUOM.label" bundle="${ph_labels}"/></td>
		<td >&nbsp;&nbsp;
			<input type="text" name="qty_uom" id="qty_uom" value="<%=qty_uom%>" size="15" maxlength="15">
			<img src="../../eCommon/images/mandatory.gif" align="center"></img> 
		</td>
	</tr> -->
<%
				}
%>
				<tr>
					<td class="label" ><fmt:message key="ePH.AdministrationInstruction.label" bundle="${ph_labels}"/></td>
					<td >&nbsp;&nbsp;
						<textarea cols="31" rows="2" name="Admin_Inst" onkeypress="return restrictAMP(event);" onblur="changeToSingleQuotes(this);return ChkMaxLen('Administration Instruction',this,60,''); " ><%=admin_remarks%></textarea>			
					</td>
				</tr>
<%
				if(ord_type.equals("TA") || ( ord_type.equals("TD") && tpn_mf_label )  ) { //modified for ml-mmoh-crf-0468
%>
					<tr>
						<Td   class="label" ><fmt:message key="ePH.InfusionLine.label" bundle="${ph_labels}"/></Td>
						<Td   colspan=1>&nbsp;&nbsp;
<% 
						if (infusion_line.equals("C")){
%>
							<SELECT name="infusion_line" id="infusion_line" id="infusion_line" disabled>
								<OPTION value="C" Selected><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
<%
						}
						else{
%>
						   <SELECT name="infusion_line" id="infusion_line" id="infusion_line">
						   <OPTION value="C" ><fmt:message key="Common.Central.label" bundle="${common_labels}"/></OPTION>
						   <OPTION value="P" Selected><fmt:message key="ePH.Peripheral.label" bundle="${ph_labels}"/></OPTION>
<%
						}
%>
						</SELECT>
						</Td>
					</tr>
<% 
				}
%>
				<tr>
					<td class="label" style='<%=finalised_style%>'><b><fmt:message key="ePH.Finaliseworksheet.label" bundle="${ph_labels}"/> ?</b></td>
					<td style='<%=finalised_style%>'>&nbsp;&nbsp;
						<input type="checkbox" name="finalise_yn" id="finalise_yn"  value="<%=finalise_yn_val%>" onclick="assignValue(this)" <%=finalise_yn_deli%>>
					</td>
				</tr>
				<tr>
					<td class="white" colspan="2" align='right'>
						<input type="button" name="btnOK" id="btnOK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' class="button" onClick="saveMFGLabelDetails('<%=mode%>','<%=ord_type%>')">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
					</td>
				</tr>
				
			</table>
<% 
			String searchSQL = "SELECT product_code code, short_desc description  FROM ph_admixture_products_lang_vw WHERE UPPER (product_code) LIKE UPPER (?) AND UPPER (short_desc) LIKE UPPER (?) AND language_id = '"+bean.getLanguageId()+"' AND eff_status = 'E' AND admixture_type IN "; 
%>
			<input type="hidden" name="bean_id" id="bean_id"				value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name"			value="<%=bean_name%>">
			<input type="hidden" name="facility_id" id="facility_id"			value="<%=facility_id%>">
			<input type="hidden" name="disp_locn" id="disp_locn"			value="<%=disp_locn%>">
			<input type="hidden" name="worksheet_id" id="worksheet_id"		value="<%=worksheet_id%>">
			<input type="hidden" name="prep_qty_volume" id="prep_qty_volume"		value="<%=qty_value%>">
			<input type="hidden" name="overage_volume" id="overage_volume"		value="<%=overage_volume%>">
			<input type="hidden" name="infuse_over" id="infuse_over"			value="<%=infuse_over%>">
			<input type="hidden" name="language_id" id="language_id"			value="<%=locale%>">
			<input type='hidden' name="ord_type" id="ord_type"			value="<%=ord_type%>">
	<!--    <input type='hidden' name="language_id" id="language_id"			value="<%=bean.getLanguageId()%>"> Commented for RollForward from SRR - SRR20056-SCF-9422 -->
			<input type="hidden" name="searchSQL" id="searchSQL"			value="<%=searchSQL%>" >
			<input type="hidden" name="UpdateMFGDetails" id="UpdateMFGDetails"	value="<%=sUpdateMFGDetails%>" >
			
		</form>
	</body>
</html>
<script>
	document.fromDispMedicationWSLabel.OrderType.selectedIndex = <%=iSelectedIndex%>;
</script>
<%
//putObjectInBean(bean_id,bean,request);
//putObjectInBean(bean_id1,beanAs,request);
putObjectInBean(bean_id2,bean_ws,request);
}catch(Exception e){
	e.printStackTrace();
}
finally{ // Added for ML-MMOH-SCF-0468 start
	
	if(con != null)
		ConnectionManager.returnConnection(con,request);	
} // Added for ML-MMOH-SCF-0468 end

%>

