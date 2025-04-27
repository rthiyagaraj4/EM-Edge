<!DOCTYPE html>
<!--
/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			     Description
--------------------------------------------------------------------------------------------------------------
?				100					?                created
05/12/2017      [IN:064158]     Devindra    Change in barcode scanning functionality in Dispense Medication(in each scan one quantity need to add).
11/5/2022		TFS:25853			Shazana				SKR-SCF-1643
11/5/2022		TFS:25854			Shazana				SKR-SCF-1644
11/5/2022		TFS:25855			Shazana				SKR-SCF-1645
31/07/2022                          Chandrashekar Raju  MMS-MD-SCF-0204
---------------------------------------------------------------------------------------------------------------
*/ -->
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="java.text.DecimalFormat,java.util.*, ePH.*, ePH.Common.*,eST.*,eST.Common.*, eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>
<%-- Mandatory declarations start --%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>

<HTML>
	<HEAD>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= (String)session.getAttribute("facility_id");  //Added for RUT-CRF-0035 [IN029926]
		
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<SCRIPT LANGUAGE="javascript" SRC="../../eCommon/js/common.js"></SCRIPT>
		<script language="JavaScript" src="../../ePH/js/DispMedicationAllStages.js"></script>
		<SCRIPT LANGUAGE="Javascript" SRC="../../eCommon/js/ValidateControl.js"></SCRIPT>
		<SCRIPT LANGUAGE="JavaScript" SRC="../../ePH/js/PhCommon.js"></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</HEAD>
<%
	try{
	String drug_code			=	CommonBean.checkForNull(request.getParameter("drug_code"));
	String item_code			=	CommonBean.checkForNull(request.getParameter("item_code"));
	String patient_id			=	CommonBean.checkForNull(request.getParameter("patient_id"));
	String order_id				=	CommonBean.checkForNull(request.getParameter("order_id"));
	String order_line_no		=	CommonBean.checkForNull(request.getParameter("order_line_no"));
	String drug_color			=	CommonBean.checkForNull(request.getParameter("drug_color"));
	String alt_drug_code		=	CommonBean.checkForNull(request.getParameter("alt_drug_code"));
	String qty					=	CommonBean.checkForNull(request.getParameter("qty"));
	String uom					=	CommonBean.checkForNull(request.getParameter("uom_code"));
	String uom_code				=	CommonBean.checkForNull(request.getParameter("uom_code"));
	String source				=	CommonBean.checkForNull(request.getParameter("source"));
	String recno				=	CommonBean.checkForNull(request.getParameter("no"));
	String store_code			=	CommonBean.checkForNull(request.getParameter("store_code"));
	String end_date				=	CommonBean.checkForNull(request.getParameter("end_date"));
	String drug_strength		=	CommonBean.checkForNull(request.getParameter("drug_strength"));
	String alt_drug_strength	=	CommonBean.checkForNull(request.getParameter("alt_drug_strength"));
	String called_from			=	CommonBean.checkForNull(request.getParameter("called_from"));
	String bms_strength			=	CommonBean.checkForNull(request.getParameter("bms_strength"));
	String oper_mode			=	CommonBean.checkForNull(request.getParameter("oper_mode"));
	String drug_class			=	CommonBean.checkForNull(request.getParameter("drug_class"));
	String stk_qty				=	CommonBean.checkForNull(request.getParameter("stk_qty"));	
	String min_end_date			=	CommonBean.checkForNull(request.getParameter("min_end_date"));
    String main_strength_per_value_pres_uom =CommonBean.checkForNull(request.getParameter("main_strength_per_value_pres_uom"));
    String alt_drg_no			=	CommonBean.checkForNull(request.getParameter("alt_drg_no"));
    String prescribed_strength	=	CommonBean.checkForNull(request.getParameter("prescribed_strength"));
    String barcode_flg			=	request.getParameter("barcode_flg");//Added for KDAH-CRF-0231 [IN-034551]
	String all_params			=	request.getQueryString();
	String bms_qty				=	qty;
	String main_drug_bms_qty    =   qty; 
	if(drug_strength==null)		
	     drug_strength		=	"";
	if(alt_drug_strength==null) 
	     alt_drug_strength	=	"";
	if(called_from==null)		
	     called_from			=	"";
	if(oper_mode==null)			
	      oper_mode	=	"";

	String class_name			=	"";
	String batch_id				=	"";
	String expiry_date			=	"";
	String issue_qty			=	"";
	String item_drug_code		=	"";
	String trade_name			=	"";
	String manufacturer_name	=	"";
	String bin_location			=	"";
	String trade_id				=	"";
	String bin_locn_code		=	"";
	String fractroundupyn       =   "";
	String drug_pack_size       =   "";
	String repeat_value		    =   "";
	String strength_value       =   "";
	String qty_value		    =   "";
	String strength_per_value_pres_uom="";
//	String tot_strength			=   "";	
	String bms_strength_1		=	"";	
	String dflt_issue_uom		=   "";
	String base_uom				=	"";
	String sOrigBatchId			=	"";
	String sPastExpDate			=	"";
	String sPastBinLocn			=	"";
	String  disp_avail_qty = ""; //Added for  MMS-SCF-0040 [IN:041888]
	boolean bConsiderOldBatchDetails	=false;
	int duration				=   0;	
	int duration1				=   0;
	if(drug_color==null)	
				drug_color		=	"";
	if(alt_drug_code==null)	
				alt_drug_code	=	"";

	HashMap		stock				=	new HashMap();
	ArrayList   for_stock_1			=	new ArrayList();
	ArrayList   for_stock_2			=	new ArrayList();
	ArrayList	stock_detail		=	new ArrayList();
	HashMap		drug_detail			=	new HashMap();
	ArrayList	all_drug_detail		=	new ArrayList();

	ArrayList batch_val=new ArrayList();//new list object added for KDAH-CRF-0231 [IN-034551] 
	String bean_id					= "DispMedicationAllStages" ;
	String bean_name				= "ePH.DispMedicationAllStages";
	DispMedicationAllStages bean	= (DispMedicationAllStages)getBeanObject( bean_id, bean_name , request) ;
	bean.setLanguageId(locale);

	String	bean_id_1				=	"DispMedicationBean" ;
	String	bean_name_1				=	"ePH.DispMedicationBean";	
	DispMedicationBean bean_1		= (DispMedicationBean)getBeanObject( bean_id_1, bean_name_1, request);
	bean_1.setLanguageId(locale);

	String Image_bean_id				= "@DrugTradeImageBean";
	String Image_bean_name				= "ePH.DrugTradeImageBean";
	DrugTradeImageBean drug_trade_bean	= (DrugTradeImageBean)getBeanObject( Image_bean_id, Image_bean_name, request );

    String	bean_id_2				=	"StUtilities" ;
	String	bean_name_2				=	"eST.Common.StUtilities";

	String	bean_id_3				=	"batchSearchBean" ;
	String	bean_name_3				=	"eST.BatchSearchBean";

	String disp_auth_yn				=   CommonBean.checkForNull((String)bean_1.getDispAutharizationYN(drug_code));	
	String strResetQty				=	bean_1.getStrResetQty()==null?"":bean_1.getStrResetQty();
	boolean bPRNOrAbsOrder			=	bean.getBPRNOrAbsOrder();
	if( strResetQty.equals("null"))
     	strResetQty="";
   
	int opdispperiod			   = Integer.parseInt(bean_1.getFillPeriod());

	if(bPRNOrAbsOrder)
		opdispperiod = 999;

	String sRepeatFreqCode		= "";
	String sFreqCode			= "";
	// For Multi Frequency 
	String  st_disp_decimal_dtls_yn="", st_allow_decimals_yn="N"; //Added for AAKH-SCF-0113 [IN:048937] start
	st_disp_decimal_dtls_yn =bean.getSt_disp_decimal_dtls_yn(); // Added for AAKH-SCF-0113 [IN:048937] -end

	sRepeatFreqCode			=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[0];
	sFreqCode				=	bean_1.getFreqRepeatCode(order_id, order_line_no).split("~")[1];

	Float fTotalDuration = Float.parseFloat(bean_1.getDurationValue(order_id+order_line_no));

	String sOrigDispUnit	= bean_1.getStrChangedDispenseUnit() != null?bean_1.getStrChangedDispenseUnit():"D";
	String sOrigDispPeriod	= bean_1.getStrChangedDispensePeriod() != null?bean_1.getStrChangedDispensePeriod():"1";

	String userAuthPINYN		= bean.getUserAuthPINRequiredYN(); //RUT-CRF-0035 [IN029926] Added for User Auth PIN Validation
    String medical_applicable=bean.checkMedicalItemYN(item_code);//added for ghl-crf-0548
	if(sRepeatFreqCode.equals("W")){
		if(sOrigDispUnit.equals("H")){
			//opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/(24*7)))*7; // divide by 24 to make day and divide by 7 to convert to week and ceil it.
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/7)*7);//Added for ARYU-SCF-0077 removed 24 because opdispperiod already converted to day in validation page
		}else if(sOrigDispUnit.equals("D")){
			//opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/7))*7;//Commented for ARYU-SCF-0077
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/7)*7);//Added for ARYU-SCF-0077
		}else if(sOrigDispUnit.equals("M"))
			opdispperiod = (int) Integer.parseInt(sOrigDispPeriod)*4*7;
	}
	else if(sRepeatFreqCode.equals("M")){
		if(sOrigDispUnit.equals("H"))
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/(24*30)))*30; 
		else if(sOrigDispUnit.equals("D"))
			opdispperiod = (int) Math.ceil((Float.parseFloat(opdispperiod+"")/30))*30;
		else if(sOrigDispUnit.equals("W"))
			opdispperiod = (int)Math.ceil((Float.parseFloat(opdispperiod+"")/4))*30 ;
	}

	if(sFreqCode.equals("H"))
		fTotalDuration = fTotalDuration/24;
	else if(sFreqCode.equals("W"))
		fTotalDuration = fTotalDuration*7;
	else if(sFreqCode.equals("L"))
		fTotalDuration = fTotalDuration*30;
	else if(sFreqCode.equals("Y"))
		fTotalDuration = fTotalDuration*365;

    String allow_short_expiry_drugs_yn =bean_1.getAllow_short_expiry_drugs_yn();
	String	sys_date		=	bean.getCurrDate();
	ArrayList disp_info		=	new ArrayList(2);
	if(!oper_mode.equals("auto")) {
		disp_info	=	bean.getLastDispense(order_id,order_line_no);
	}

	/** Stock Bean Integration -Start ***/
	StUtilities bean_2=null;
	try { 
		bean_2 = (StUtilities) getBeanObject( bean_id_2,  bean_name_2, request );
		bean_2.setLanguageId(locale);
	}	
	//catch (eST.Common.InsufficientBatchException exception) {
	//	out.println(exception.getAvailableQuantity());
	//	exception.printStackTrace();
	//}
	catch (Exception exception) {
		out.println(exception);
		exception.printStackTrace();
	}

	BatchSearchBean bean_3	= (BatchSearchBean)getBeanObject( bean_id_3, bean_name_3, request);
	bean_3.setLanguageId(locale);
	/** Stock Bean Integration -End ***/ 
	if(strResetQty.equals("") || strResetQty.equals("false")){
		if(alt_drug_code.equals("")) {
			//stock_qty			=	bean.getTotalStockQty(patient_id,order_id,order_line_no);
			all_drug_detail		=	bean.getDrugDetail(patient_id,order_id,order_line_no);
		}
		else {
			//stock_qty			=	bean.getTotalAlternateStockQty(patient_id,order_id,order_line_no);
			all_drug_detail		=	bean.getAlternateDrugDetail(patient_id,order_id,order_line_no,alt_drug_code);
		}
	}
	else{
		if(alt_drug_code.equals("")) {
		      bean.setDrugDetail(patient_id,order_id,order_line_no,new ArrayList());
		}
		else{
			  bean.setAlternateDrugDetail(patient_id,order_id, order_line_no,new ArrayList(),alt_drug_code);
		}
	}
	if(all_drug_detail.size()!=0) {
		for(int k=0; k<all_drug_detail.size(); k+=10) { //9->10 for MMS-SCF-0040 [IN:041888]
			for_stock_1		=	new ArrayList();
			batch_id		=	(String)all_drug_detail.get(k+1);
			expiry_date		=	(String)all_drug_detail.get(k+2);
			bin_locn_code	=	(String)all_drug_detail.get(k+7);				
			for_stock_1.add(batch_id);
			for_stock_1.add(expiry_date);
			for_stock_1.add(bin_locn_code);
			for_stock_2.add(for_stock_1);
		}
	}
	
	sOrigBatchId	= batch_id;
	sPastExpDate	= expiry_date;
	sPastBinLocn	= bin_locn_code;
	if(called_from != null && called_from.equals("stock")&& sOrigBatchId!=null && !sOrigBatchId.equals("")&& sPastExpDate!=null && !sPastExpDate.equals("")&& sPastBinLocn!=null && !sPastBinLocn.equals("")){
		bConsiderOldBatchDetails = true;
	}

	if(alt_drug_code.equals("")){
		item_drug_code	=	drug_code;
	}
	else{
		item_drug_code	=	alt_drug_code;
	}

	if(!called_from.equals("")) {
		bean.setStockAvailability(order_id+order_line_no,item_code);
	} 

	String tmp_drug_code		=	item_drug_code;
	String tmp_drug_color		=	drug_color;
	String item_drug_color		=	drug_color; 
	String tmp_item_code		=	"";
	String quantity				=	"";
	String select_status		=	"";
	String Order_qty            =   "";
	String split_yn				=   "";
	ArrayList stock_items		=	new ArrayList();
	String  image_path			=   "";
	String default_yn			=   "N";
	double base_to_disp_uom_equl	=   0;
	double base_to_def_uom_equl	=	0; 
	double conv_factor				=   0;
	double  issue_qty_val     = 0;
	double  issue_qty_val_1   = 0;
	//Added for KDAH-CRF-0231 [IN-034551]
	int temp_count=0;
	ArrayList batch_chk_list=new ArrayList();
	HashMap batch_chk_map=new HashMap();
	HashMap st_batch_map=new HashMap();
	int tot_alt_drug_qty        = 0;
	//Added for KDAH-CRF-0231 [IN-034551]
	HashMap tempstock=new HashMap();
	//Added for KDAH-CRF-0231 [IN-034551]
	if(alt_drug_code.equals("")) {
		bean.addItems(drug_code,item_code);
		qty		=	new Float(qty).intValue()+"";
	}
	else {
		bean.removeItems(drug_code);
		bean.addItems(alt_drug_code,item_code);
		//HashMap pack_dtls	=	bean.getPackSize(alt_drug_code);
		fractroundupyn      =   bean.getFractRoundupYN(alt_drug_code);
		//int pack_size		=	1;

		/*if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				pack_size	=	Integer.parseInt(((String)pack_dtls.get("PACK_SIZE")));
			}		
		}*/

         ArrayList  multi_drugs	    = bean.getMultiDrugs(patient_id,order_id,order_line_no);
		 String alt_qty1        	= "";
		 String alt_strength_value1 = "";
		 String alt_drug_code1		="";
		 ArrayList alt_qty			= new ArrayList();
		 HashMap pack_dtls1			= new HashMap();
		 HashMap alternateHmAllowMoreQty=new HashMap(); //newly added for IN035407 ML-BRU-SCF-0474
		 float tmp_alloc			= 0;
		 float pack_size1              = 0; //changed from int to float type for  [IN:036634]
		 float strength_per_value1  =0;
		 
         for(int n=0; n<multi_drugs.size(); n+=5)	{ /* code added for SCF 24184 -start*/
			alt_qty1		          =	 bean.getAlternateDrugQuantity(patient_id,order_id,order_line_no,alt_drug_code); 
			alt_strength_value1     =	(String)multi_drugs.get(n+3);
			alt_drug_code1		  =	(String)multi_drugs.get(n);
			pack_dtls1              =	 bean.getPackSize(alt_drug_code1);
			if(pack_dtls1.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls1.get("PACK_SIZE")).equals("")) {
					pack_size1	        =	Float.parseFloat(((String)pack_dtls1.get("PACK_SIZE"))); // Integer.parseInt changed to Float.parseFloat for [IN:036634]
					if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
							strength_per_value1	=	Float.parseFloat(((String)pack_dtls1.get("STRENGTH_PER_VALUE_PRES_UOM")));
				
					}}		
			}

			if(bean_1.getAlternateHmAllowMoreQty(alt_drug_code1,locale).equals("Y")){//if else newly added for IN035407 ML-BRU-SCF-0474 -- start
				alternateHmAllowMoreQty.put(alt_drug_code1,"Y");
			}
			else{
				alternateHmAllowMoreQty.put(alt_drug_code1,"N");
			}
			bean_1.setHmAllowMoreQty(alternateHmAllowMoreQty); //if else newly added for IN035407 ML-BRU-SCF-0474 -- end
			if(!alt_qty1.equals("") && !alt_qty1.equals("0")) {
				//alt_qty.add(alt_drug_code1);
				//alt_qty.add(alt_qty1);				
				//alt_qty.add(alt_strength_value1);
				if(!alt_drug_code1.equals(alt_drug_code) && !medical_applicable.equals("Y") )
					tmp_alloc	+=	 ((Float.parseFloat(alt_strength_value1)) * Float.parseFloat(alt_qty1)*pack_size1)/strength_per_value1 ; // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
			}
		}
		if(Float.parseFloat(prescribed_strength)>0)
			bms_strength = (Float.parseFloat(prescribed_strength) - tmp_alloc)+"";/* code added for SCF 24184 -start -End*/

		if(fractroundupyn.equals("N")){

			HashMap qty_dtls	        = bean.getqtyvalue(alt_drug_code,order_id,order_line_no);		
			if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
			strength_per_value_pres_uom =(String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");
			}
			
			//tot_strength			    = (String)qty_dtls.get("TOT_STRENGTH");	
			//tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(tot_strength)/Float.parseFloat(alt_drug_strength))/(Float.parseFloat(strength_per_value_pres_uom)))).intValue();
			if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
			tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(alt_drug_strength)))).intValue();
			}
			HashMap pack_dtls	    = bean.getPackSize(alt_drug_code);

			if(pack_dtls.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
					drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
					tot_alt_drug_qty = (int)Math.ceil(tot_alt_drug_qty/Float.parseFloat(drug_pack_size));
				 }		
		    }
			
			if(!bms_strength.equals("") && !alt_drug_strength.equals("") && !bms_strength.equals("0.0")) { //modified for ghl-crf-0548
				//bms_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)/Float.parseFloat(alt_drug_strength))/(Float.parseFloat(strength_per_value_pres_uom)))).intValue()+"";
				bms_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(alt_drug_strength)))).intValue()+"";
				qty		=	bms_qty = tot_alt_drug_qty+"";
			} 
			else if(!medical_applicable.equals("Y")) {//ghl-crf-0548
				bms_qty=qty;
				tot_alt_drug_qty =Integer.parseInt(qty);
			}
			//if(bean_1.getDispLocnCatg().equals("O") ){
				 String disp_locn_code	= bean_1.getDispLocnCode();
				// opdispperiod           = bean_1.getopdispperiod( disp_locn_code);
				//opdispperiod  = Integer.parseInt(bean_1.getFillPeriod());
				 strength_value			= (String)qty_dtls.get("STRENGTH_VALUE");
			//}
		}
		else{
			//if(bean_1.getDispLocnCatg().equals("O") ){
			duration					=  0;
			String disp_locn_code		= bean_1.getDispLocnCode();
			duration					=  new Float(Math.ceil(fTotalDuration)).intValue();
			HashMap qty_dtls			= bean.getqtyvalue(alt_drug_code,order_id,order_line_no);
			repeat_value				= (String)qty_dtls.get("repeat_value");
			strength_value				= (String)qty_dtls.get("STRENGTH_VALUE");
			strength_per_value_pres_uom= (String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");
			qty_value					= (String)qty_dtls.get("QTY_VALUE");
			split_yn					= (String)qty_dtls.get("SPLIT_DOSE_YN");
			// opdispperiod			=  0;
			// tot_strength			= (String)qty_dtls.get("TOT_STRENGTH");	
			// opdispperiod           = bean_1.getopdispperiod( disp_locn_code);	

			if(strength_per_value_pres_uom.equals(""))
				strength_per_value_pres_uom = "0";

			if(alt_drug_strength.equals(""))
				alt_drug_strength = "0";

			//if(tot_strength.equals(""))
			//tot_strength = "0";

			tot_alt_drug_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)/Float.parseFloat(alt_drug_strength))/(Float.parseFloat(strength_per_value_pres_uom)))).intValue();

			duration1              = duration;
			if(repeat_value.equals("")||repeat_value==null){
				repeat_value = "1";
			}

			Order_qty	=(String)bean.getOrderqty(order_id,order_line_no);
			if(split_yn.equals("Y")){
				qty_value = (new Float(Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(repeat_value))).intValue())+"";
			}
			if(!Order_qty.equals(qty)){
				duration			=	duration-opdispperiod;
				//String per_day_qty	=	( new Float((Math.ceil(Float.parseFloat(Order_qty)/duration1 ))).intValue())+"" ;
				float per_day_qty	=	Float.parseFloat(Order_qty)/duration1 ;
				duration			= ( new Float((Math.ceil(Float.parseFloat(qty)/per_day_qty ))).intValue()) ;
			}
			if(duration!=duration1){
				bms_qty				=	((int) (((Math.ceil((Float.parseFloat(bms_strength)/((Float.parseFloat(strength_value)))))*(duration))/duration1))*(Float.parseFloat(main_strength_per_value_pres_uom)))+"";
			}
			else{
				bms_qty				=	((int) ((Math.ceil((Float.parseFloat(bms_strength)/((Float.parseFloat(strength_value)))))*(duration))/duration1))+"";
			}

			qty		=	bms_qty;
			/*}else{
				HashMap qty_dtls			= bean.getqtyvalue(alt_drug_code,order_id,order_line_no);		
				strength_per_value_pres_uom = (String)qty_dtls.get("STRENGTH_PER_VALUE_PRES_UOM");

				if(!bms_strength.equals("") && !alt_drug_strength.equals("")) { 
					bms_qty	=	new Float(Math.ceil((Float.parseFloat(bms_strength)/	Float.parseFloat(alt_drug_strength)))).intValue()+"";
					qty		=	bms_qty;
				}else{
					 bms_qty=qty;
			   }        
			}	*/	 
		}
	} 
//-----code for validating OP_DISP_PERIOD in ph_disp_locn starts---------------
	duration				=   0;
	// opdispperiod			=   0;
	//if(bean_1.getDispLocnCatg().equals("O") ){
	if(!alt_drug_code.equals("")){
		String disp_locn_code	= bean_1.getDispLocnCode();			
		duration                = new Float(Math.ceil(fTotalDuration)).intValue();
		//opdispperiod            = bean_1.getopdispperiod( disp_locn_code);
		HashMap pack_dtls	    = bean.getPackSize(alt_drug_code);
		duration1				= duration;
		if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
			}		
		}
		if(opdispperiod !=0 ){
			Order_qty=(String)bean. getOrderqty(order_id,order_line_no);

			float per_day_qty=Float.parseFloat(Order_qty)/duration1 ;
			if(!Order_qty.equals(qty)){
				duration=duration-opdispperiod;
				duration= new Float(Math.ceil((Float.parseFloat(main_drug_bms_qty))/per_day_qty)).intValue()  ;
			}
			if(duration >opdispperiod){ 
				// quantity=  (new Float (Math.ceil((Float.parseFloat(bms_qty)*opdispperiod)/duration1)).intValue())+""; 
				// quantity=  (new Float (Math.ceil((Float.parseFloat(bms_qty/((Float.parseFloat(Order_qty)/duration1 )))*opdispperiod)/duration1)).intValue())+""; 
				quantity= ((int)Math.ceil(((float)tot_alt_drug_qty/(float)duration1 )*((float)opdispperiod)))+"";
				//quantity=( new Float(Math.ceil((Float.parseFloat(quantity)*(Float.parseFloat(strength_per_value_pres_uom)))/ Float.parseFloat(drug_pack_size))).intValue())+"" ;	
				//quantity=( new Float(Math.ceil((Float.parseFloat(quantity)*(Float.parseFloat(strength_per_value_pres_uom))))).intValue())+"" ;	
				//if(!quantity.equals(""))
			if(!medical_applicable.equals("Y")){//added for ghl-crf-0548
					qty   =   quantity; 	
			}
			
			}
			/*else{
				bms_strength_1=(Float.parseFloat(bms_qty))*(Float.parseFloat(strength_value))+"";
				if(Float.parseFloat(bms_strength_1)>Float.parseFloat(bms_strength)){
					  bms_qty=(Float.parseFloat(bms_strength))/(Float.parseFloat(strength_value))+"";
				}
				quantity=( new Float(Math.ceil(Float.parseFloat(bms_qty)*(Float.parseFloat(strength_per_value_pres_uom))/Float.parseFloat(drug_pack_size))).intValue())+"" ; 
				qty=quantity; 
			}*/
		}
		else{
			bms_strength_1=((Float.parseFloat(bms_qty))*(Float.parseFloat(strength_value)))+"";
			if(Float.parseFloat(bms_strength_1)>Float.parseFloat(bms_strength)){
				bms_qty=(Float.parseFloat(bms_strength))/(Float.parseFloat(strength_value))+"";
			}
			quantity=( new Float(Math.ceil((Float.parseFloat(bms_qty)*(Float.parseFloat(strength_per_value_pres_uom)))/ Float.parseFloat(drug_pack_size))).intValue())+"" ;     
			qty=quantity;   
		}
	}
	else{
		String disp_locn_code	= bean_1.getDispLocnCode();
		duration                = new Float(Math.ceil(fTotalDuration)).intValue();
		//opdispperiod            = bean_1.getopdispperiod( disp_locn_code);
		HashMap pack_dtls	    = bean.getPackSize(drug_code);
		duration1				= duration;

		if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
			}		
		}

		if(opdispperiod !=0 ){
			Order_qty=(String)bean. getOrderqty(order_id,order_line_no);
			float per_day_qty=Float.parseFloat(Order_qty)/duration1 ;
			if(!Order_qty.equals(quantity)){
				//String per_day_qty=( new Float((Math.ceil(Float.parseFloat(Order_qty)/duration1 ))).intValue())+"" ;
				duration= new Float(Math.ceil(Float.parseFloat(qty)/per_day_qty )).intValue();
			}
			if(opdispperiod >duration1){ 
				opdispperiod =duration1;
			}

			/*if(!Order_qty.equals(quantity)){					
			quantity=( new Float((Math.ceil(Float.parseFloat(Order_qty)/duration1 ))*opdispperiod).intValue())+"" ;
			}else{		
			quantity=  (new Float (Math.ceil((Float.parseFloat(quantity)*opdispperiod)/duration)).intValue())+"";		
			}
			quantity=( new Float(Math.ceil(Float.parseFloat(quantity)/ Float.parseFloat(drug_pack_size))).intValue())+"" ;	
			*/

			//	if(bms_qty.equals("")){
			//   quantity= (new Float(Math.ceil(((Float.parseFloat(Order_qty)/(Float.parseFloat(duration1+"")) ))*((float)opdispperiod))).intValue())+"";
			//}else{
			// quantity= (new Float(Math.ceil(((Float.parseFloat(bms_qty)/((float)duration1) ))*((float)opdispperiod))).intValue())+"";

			quantity= new Float(Math.ceil(per_day_qty*(float)opdispperiod)).intValue()+"";
			if(Float.parseFloat(quantity)>Float.parseFloat(bms_qty)) // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
				quantity =bms_qty ;

			//quantity= (new Float(Math.ceil(((Float.parseFloat(bms_qty)/(Float.parseFloat(duration+"")) ))*((float)opdispperiod))).intValue())+"";
			//}

			//quantity=( new Float(Math.ceil((Float.parseFloat(quantity)*(Float.parseFloat(strength_per_value_pres_uom))))).intValue())+"" ;	
			qty   =   quantity; 

			/*	}else{	
			if(!Order_qty.equals(quantity)){         
			//quantity=( new Float(Math.ceil(Float.parseFloat(quantity)/ Float.parseFloat(drug_pack_size))).intValue())+"" ;
			}            
			}*/
		}
	}
	//}

	if(alt_drug_code.equals("")) {
		stock_items				=	bean.getItems(drug_code);
	}
	else {
		stock_items				=	bean.getItems(alt_drug_code);
		HashMap pack_dtls	    =   bean.getPackSize(alt_drug_code);
		float pack_size			=	1;
		if(pack_dtls.containsKey("PACK_SIZE")) {
			if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
				pack_size	=	Float.parseFloat(((String)pack_dtls.get("PACK_SIZE")));	
			}		
		}
		/*
		if(!bms_strength.equals("")) {
			//bms_qty=qty;
		}*/
		// charles bms_qty       =( new Float(Math.ceil((Float.parseFloat(bms_qty))/ pack_size)).intValue())+"" ;     
		/*if(bean_1.getDispLocnCatg().equals("I") ){

		qty       =( new Float(Math.ceil((Float.parseFloat(qty))/ pack_size)).intValue())+"" ;     
		quantity  =	qty;   
		bms_qty   = qty;
		}*/
	}

	long diff_qty	=0;
	if(alt_drug_code.equals("")){
		diff_qty		    =	(Long.parseLong(stk_qty))-(Long.parseLong(qty));
	}

	HashMap params			=	new HashMap();
	ArrayList st_detail	=	new ArrayList();
	String item_cost	= "";
	ArrayList stk_dtls =  new ArrayList();
	if(alt_drug_code.equals("")){
		stk_dtls =(ArrayList)bean.getStockItems(item_code);
	}
	String iv_prep_yn						=  CommonBean.checkForNull((String)bean.getIVFlag(order_id),"N");
	HashMap IssueUOMAndBaseUOM		=(HashMap)bean.getStoreDfltIssueUOMAndBaseUOM(store_code,drug_code);
	if(dflt_issue_uom.equals("")){
		dflt_issue_uom	 =	(String)IssueUOMAndBaseUOM.get("DEF_ISSUE_UOM");
	}
	base_uom			 = (String)IssueUOMAndBaseUOM.get("BASE_UOM");
	st_allow_decimals_yn	= CommonBean.checkForNull((String)IssueUOMAndBaseUOM.get("ALLOW_DECIMALS_YN")); //  Added for AAKH-SCF-0113 [IN:048937]
	if( (stk_dtls.size()>0 && stk_dtls.get(0).equals("Y"))|| !alt_drug_code.equals("") || !iv_prep_yn.equals("7") || (iv_prep_yn.equals("7")&& allow_short_expiry_drugs_yn.equals("Y")) ){ //!iv_prep_yn.equals("7") -->  added for [IN:045912]
		/*==code added to handle if dispense uom and default uom in item store is different=====*/
		HashMap IssueUomQty=(HashMap)bean.getIssueUomQty();
		/*if(IssueUomQty.containsKey((order_id+order_line_no+drug_code+"_base_to_disp_uom_equl"))){
			base_to_disp_uom_equl	=Double.parseDouble(((String)IssueUomQty.get(order_id+order_line_no+drug_code+"_base_to_disp_uom_equl")));
		}
		if(IssueUomQty.containsKey((order_id+order_line_no+drug_code+"_base_to_def_uom_equl"))){
			base_to_def_uom_equl	=Double.parseDouble(((String)IssueUomQty.get(order_id+order_line_no+drug_code+"_base_to_def_uom_equl")));
		}*/ //Commented for  MMS-SCF-0040 [IN:041888]
		if(base_to_disp_uom_equl ==0)
			base_to_disp_uom_equl    =	bean.getEqulValue ( item_code, base_uom, uom_code);
		if(base_to_def_uom_equl ==0)
			base_to_def_uom_equl	 =  bean.getEqulValue ( item_code, base_uom,dflt_issue_uom);
		if(base_to_disp_uom_equl!=base_to_def_uom_equl){
			conv_factor = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
			if(conv_factor == 0)
				conv_factor=1;
			issue_qty_val_1  =  new Double(Math.ceil(Float.parseFloat(qty)*base_to_disp_uom_equl)); // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
			issue_qty_val  = new Double(Math.ceil(((Math.ceil(issue_qty_val_1/conv_factor))*(conv_factor))/base_to_def_uom_equl));
			issue_qty_val_1  =  new Float(Math.ceil(issue_qty_val*base_to_def_uom_equl)).doubleValue(); //Added for  MMS-SCF-0040 [IN:041888]
		}
		else{
			 if(uom_code!=base_uom){  //if block and else condition added for  MMS-SCF-0040 [IN:041888]
				 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
				 issue_qty_val  = new Double(Math.ceil(Float.parseFloat(qty)*base_to_disp_uom_equl)); // Integer.parseInt changed to Float.parseFloat for ML-BRU-SCF-1249 [IN:047253]
			 }
			 else{
				issue_qty_val     = Double.parseDouble(qty);	
			 }	
			issue_qty_val_1    = issue_qty_val;	
		}

		if(!alt_drug_code.equals("")){
			HashMap pack_dtls	    = bean.getPackSize(alt_drug_code);
			duration1				= duration;
			if(pack_dtls.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
					drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
				}		
			}
		}
		else{
			HashMap pack_dtls	    = bean.getPackSize(drug_code);
			duration1				= duration;
			if(pack_dtls.containsKey("PACK_SIZE")) {
				if(!((String)pack_dtls.get("PACK_SIZE")).equals("")) {
					drug_pack_size	=	(String)pack_dtls.get("PACK_SIZE");			
				}		
			}	
		}
		//if(!drug_pack_size.equals(""))//COMMENTD FOR 26145 BY NAVEEN ON 3Feb2011
		//issue_qty_val_1 = issue_qty_val_1 * Double.parseDouble(drug_pack_size);

		/*===============ends here==========================================================*/
		String trade_code   =  (String)bean_1.gettrade_codes(order_id,order_line_no,drug_code);

		if( !(trade_code.equals(""))&& all_drug_detail.size()==0){
			params.put("ITEM_CODE",item_code+"="+trade_code); 	
		}
		else{
			params.put("ITEM_CODE",item_code);
		}
		//qty =issue_qty_val+""; //commented for MMS-SCF-0040 [IN:041888]
		qty =issue_qty_val_1+""; //added for MMS-SCF-0040 [IN:041888]
		bms_qty =qty; //added for MMS-SCF-0040 [IN:041888]
		if(!alt_drug_code.equals("") && base_to_disp_uom_equl!=base_to_def_uom_equl && uom_code!=base_uom ){ // Added for ML-BRU-SCF-1880 - Start
			bms_qty =(Math.ceil((float)tot_alt_drug_qty *Float.parseFloat(qty)))+"";
		} // Added for ML-BRU-SCF-1880 - End
		params.put("STORE_CODE",store_code);
		//params.put("TRN_QTY",qty);
		if(bean_1.getOrderType().equals("NOR") && ((bean_1.getBarcode_id()!=null && !bean_1.getBarcode_id().equals("")) || bean_1.getBarcode_Scan_YN().equals("Y"))) // if condition added for [IN:064158] else condition for existing functionality  - Start // getBarcode_Scan_YN() Added for GHL-CRF-0463
		   params.put("TRN_QTY","1"+"");
		else
		   params.put("TRN_QTY",issue_qty_val_1+""); // if condition added for [IN:064158]/[IN:006614] else condition for existing functionality - End
		params.put("INCLUDE_SUSPENDED","FALSE");
		params.put("INCLUDE_EXPIRED","FALSE");
		params.put("CUT_OFF_DATE",end_date);
		params.put("VERIFY_INSUFFICIENT_QTY","FALSE");
		params.put("MIN_EXP_DATE",min_end_date);
		params.put("BARCODE_ID",bean_1.getBarcode_id());
		//System.err.println("bean_1.getBarcode_id()==="+bean_1.getBarcode_id());
		if(bean_1.get2DBarcodeApplicable().equals("Y") && !bean_1.getBarcode_id().equals("")){//Added if condition for MMS-DM-CRF-0174.5
			stock = (HashMap)bean_2.get2DBarcodeDetails(params);
		}else{
			stock	  = (HashMap)bean_2.getBatches(params);
		}
		if(bean_1.getBarcode_id()!=null && !bean_1.getBarcode_id().equals("") && !stock.containsKey("EXCEPTION")){//if & else block added for KDAH-CRF-0231 [IN-034551]
			bean_1.setBarcode_Scan_YN("Y");
			//Commented for KDAH-CRF-0231 [IN-034551]
				/*barcode_flg="Y";
				if(bean_1.getStockDtl().containsKey("barcode_id")){
				    bean_1.setStockDtlKey("EXCEPTION", "EXCEPTION");
				    bean_1.setStockDtlKey("autoalloc","Y");
				}
		}else if(bean_1.getBarcode_id()!=null && !bean_1.getBarcode_id().equals("")){// if stock contains data without exception set list to bean added for KDAH-CRF-0231 [IN-034551]*/
		//Commented for KDAH-CRF-0231 [IN-034551]
		batch_val=(ArrayList)stock.get("BATCH_DATA");
		//Added for KDAH-CRF-0231 [IN-034551]
		bean_1.setStockDtlKey("barcode_applicable"+item_code,"Y");
		//Added for KDAH-CRF-0231 [IN-034551] - Start
		Iterator batch_chk=bean_1.getBatch_val().iterator();
		while(batch_chk.hasNext()){
			batch_chk_list=(ArrayList)batch_chk.next();
			ArrayList batch_temp_val=batch_chk_list;
			HashMap batch_val_map=new HashMap();
			HashMap batch_val_map1=new HashMap();
			Iterator batch_val_iterate=batch_temp_val.iterator();
			if(batch_val_iterate.hasNext()){
				while(batch_val_iterate.hasNext()){
					batch_val_map=(HashMap)batch_val_iterate.next();
					batch_val_map1.put(batch_val_map.get("BATCH_ID").toString()+batch_val_map.get("ITEM_CODE").toString(), batch_val_map.get("BATCH_ID").toString());
				}
			}
			else{
				batch_chk_map=(HashMap)batch_chk_list.get(0);
			}
			st_batch_map=(HashMap)batch_val.get(0);
			if(batch_val_map1.containsKey(st_batch_map.get("BATCH_ID").toString()+st_batch_map.get("ITEM_CODE").toString())){
				temp_count++;
				batch_val_map1.clear();
				break;
			}
			else{
				batch_chk_map=(HashMap)batch_chk_list.get(0);
				String batch_chk_cmp=batch_chk_map.get("BATCH_ID").toString()+batch_chk_map.get("ITEM_CODE").toString();
				if(batch_chk_cmp.equals(st_batch_map.get("BATCH_ID").toString()+st_batch_map.get("ITEM_CODE").toString())){//34551
					temp_count++;
					if(temp_count>1){
						break;
					}
				  }	
			   } 
			}
			if(temp_count<1){
				bean_1.setBatch_val(batch_val);//Assign list of batch data to setter method added for KDAH-CRF-0231 [IN-034551]
			}//Added for KDAH-CRF-0231 [IN-034551] - End
		}
		item_cost	=	bean.getItemCost(item_code,store_code,issue_qty_val+"",end_date);
		if(item_cost.equals("")) 
			item_cost		=	"0";
		else
			item_cost		=	Float.parseFloat(item_cost)+"";

		stock_detail		=	(ArrayList)stock.get("BATCH_DATA");
		if(called_from.equals("stock") && bean_3.getSelectedList()!=null) {
			st_detail.add(bean_3.getSelectedList());
			batch_val.clear();//batch_val list is cleared on stockavailibility button click scenario added for KDAH-CRF-0231 [IN-034551]
			barcode_flg="N";//Added for KDAH-CRF-0231 [IN-034551]	-Start
			bean_1.getBatch_val().clear();
			bean_1.setStockDtlKey("barcode_applicable"+item_code,"Y");	//Added for KDAH-CRF-0231 [IN-034551]	-End
		} 
		else if(all_drug_detail.size()!=0 && bean_1.getBarcode_id()!=null && bean_1.getBarcode_id().equals("")) { //&& bean_1.getBarcode_id()!=null && bean_1.getBarcode_id().equals("") added for KDAH-CRF-0231 [IN-034551] 
			if(allow_short_expiry_drugs_yn.equals("Y"))
				params.put("CUT_OFF_DATE","");
			stock			=	bean_2.getBatches(params,for_stock_2);
			st_detail.add((ArrayList)stock.get("BATCH_DATA"));
		}
		else {
			st_detail.add((ArrayList)stock.get("BATCH_DATA"));
		}
	}
	
	String pres_qty_alert = bean_1.getPresQtyAlert();//code added for AMS-CRF-0035[IN033551]	
%>
<!-- <body> -->
	<body onMouseDown="" onKeyDown="lockKey()" > 
		<form name="DispMedicationAllocateDrugsWithStock" id="DispMedicationAllocateDrugsWithStock">
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="1">
<%	
				double tot_qty		=	0;
				tmp_item_code		=	"";
				//double tmp_qty		=	0;
				int rec_no			=	0;
				String fill_period	=	null;
				String fill_unit	=	null;	
				
				for(int i=0; i<st_detail.size(); i++)	{
					batch_id			=	"";
					expiry_date			=	"";
					issue_qty			=	"";
					//qty_uom				=	"";
					trade_id			=	"";
					bin_locn_code		=	"";
					item_drug_code		=	tmp_drug_code;
					item_drug_color		=	tmp_drug_color;
					drug_color			=	item_drug_color;
					//Commented for KDAH-CRF-0231 [IN-034551]
					/*if(bean_1.getBarcode_Scan_YN().equals("N")){//if block added for KDAH-CRF-0231 [IN-034551] 
					    barcode_flg="N";
					}*/
					//Commented for KDAH-CRF-0231 [IN-034551]
					if(st_detail.get(i) != null)
						stock_detail		=	(ArrayList) st_detail.get(i);
						
						Iterator batch_chk1=bean_1.getBatch_val().iterator();//Added for KDAH-CRF-0231 [IN-034551] - Start
						String temp_code="";
						String batch_id_chk="";
						while(batch_chk1.hasNext()){
						    batch_chk_list=(ArrayList)batch_chk1.next();
						    batch_chk_map=(HashMap)batch_chk_list.get(0);
						    st_batch_map=(HashMap)stock_detail.get(0);
						    temp_code=batch_chk_map.get("ITEM_CODE").toString();
						    if(temp_code.equals(tmp_drug_code)){
							   barcode_flg="N";
							   break;
						    }
						}
						//Added for KDAH-CRF-0231 [IN-034551] - End
					if((batch_val.size()!=0 || bean_1.getBatch_val().size()>0 && temp_code.equals(tmp_drug_code)) && (bean_1.getBarcode_Scan_YN().equals("Y") && alt_drug_code.equals(""))){//Added for KDAH-CRF-0231 [IN-034551] // && (barcode_flg.equals("Y") && !alt_drug_code.equals("")) Added for MMS-DM-SCF-0083//&& !bean_1.getOrderType().equals("NOR") removed chandra
					    //bean_1.setBatch_val(stock_detail);//Assign list of batch data to setter method added for KDAH-CRF-0231 [IN-034551]
					    bean_1.setStockDtlKey("barcode_applicable"+item_drug_code,"Y");//Added for KDAH-CRF-0231 [IN-034551]
						//Added for KDAH-CRF-0231 [IN-034551]    
						Set stockDtlset = new HashSet(bean_1.getBatch_val()); // Assign list value to set which removes duplicate value on the list added for KDAH-CRF-0231 [IN-034551]
						Iterator stockDtllist=stockDtlset.iterator(); // iterate the set value from the list added for KDAH-CRF-0231 [IN-034551]
						while(stockDtllist.hasNext()){
							stk_dtls.add("Y");
							bean.setStockItems(drug_code,stk_dtls);
							batch_val=(ArrayList)stockDtllist.next(); // Assign set value to list to get each batch data added for KDAH-CRF-0231 [IN-034551]
							Iterator stockDtllist1=batch_val.iterator(); //Iterate the list to excecute the batch data added for KDAH-CRF-0231 [IN-034551]
							while(stockDtllist1.hasNext()){ 
								drug_detail			=	(HashMap)stockDtllist1.next();// Assign each batch list to map to get key element from the batch added for KDAH-CRF-0231 [IN-034551]
								issue_qty			=	(String)drug_detail.get("AVAIL_QTY");
								if(Double.parseDouble(issue_qty)<1.0)
									continue;
								item_drug_code		=	(String)drug_detail.get("ITEM_CODE");	
								expiry_date			=	(String)drug_detail.get("EXPIRY_DATE");	
								batch_id			=	(String)drug_detail.get("BATCH_ID");	
								trade_id			=	(String)drug_detail.get("TRADE_ID");	
								trade_name			=	(String)drug_detail.get("TRADE_NAME");	
								manufacturer_name	=	(String)drug_detail.get("MANUFACTURER_NAME");	
								bin_locn_code		=	(String)drug_detail.get("BIN_LOCATION_CODE");
								bin_location		=	(String)drug_detail.get("BIN_DESC");
								if(tmp_drug_code.equals(drug_detail.get("ITEM_CODE").toString())){//Added for KDAH-CRF-0231 [IN-034551]
									issue_qty			=	retunFormatedInt(Math.floor(Double.parseDouble(issue_qty))+""); // To make avaiilable qty as whole quantity
									quantity			=	"";
									select_status		=	"";
									tot_qty		+=	Double.parseDouble(issue_qty);
									if(2==0)
										class_name	=	"QRYEVENSMALL"; 
									else
										class_name	=	"QRYODDSMALL";

									// For getting the allocated quantity
									if(alt_drug_code.equals("")){
										 if(strResetQty.equals("") || strResetQty.equals("false")){
											// This condion is added to default the qty same like old batch Id. If the batch id is different also
											// the calculated qty should be same. ref spira id #IN015288
											if(bConsiderOldBatchDetails) {
												quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
											}
											else
												quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,batch_id,expiry_date,bin_locn_code);
										  }
										  else{
											  quantity	= "";
										  }
									}
									else{
										if(strResetQty.equals("") || strResetQty.equals("false")){
											// This condion is added to default the qty same like old batch Id. If the batch id is different also
											// the calculated qty should be same. ref spira id #IN015288
											if(bConsiderOldBatchDetails)
												quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
											else
												quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,batch_id,expiry_date,bin_locn_code);
										}
										else{
											quantity	= "";
										}
									}
									disp_avail_qty = quantity;
									//Added for KDAH-CRF-0231 [IN-034551] - Start
									 ArrayList batch_det=(ArrayList)stock.get("BATCH_DATA");
									 HashMap batch_det_stock=(HashMap)batch_det.get(0);
									
									if(temp_count>=1 && batch_det_stock.get("BATCH_ID").equals(batch_id)){
										if(bean_1.getStockDtl().containsKey("batchqty"+item_drug_code+batch_id)){
										
										  quantity = Integer.parseInt(bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString())+"";//Added of r INC 49122

										 
										quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
										 quantity=Double.parseDouble(quantity)+1+"";
											System.err.println("quantity @@ 899 ==="+quantity);
										}
									}
									else{
										if(!bean_1.getStockDtl().containsKey("batchqty"+item_drug_code+batch_id)){//Added ! for MMS-ICN-0128
											
											//quantity=bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString();
											//Commented and added below condition by Ganga 
											if(batch_det_stock.get("BATCH_ID").equals(batch_id)){
												quantity=batch_det_stock.get("QTY").toString();
											//Commented for MMS-ICN-0128	
											 /*if(all_drug_detail.size()>0 && bean_1.getBarcode_Scan_YN().equals("Y") && bean_1.getOrderType().equals("NOR")){ // Added for [IN:064158] - Start
												for(int k=0; k<all_drug_detail.size(); k+=10){
												   if(((String)all_drug_detail.get(k+1)).equals(batch_id)){
													   quantity = (String)all_drug_detail.get(k+3);
												       //break;
												   }
												}
											 }*/ // Added for [IN:064158] - End//Commenteing end for MMS_ICN-0128
												
											}
											else{
												quantity=bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString();
												
										}
									}else{//Adding start for MMS-ICN-0128

										if(bean_1.getStockDtl().containsKey("batchqty"+item_drug_code+batch_id)){
										     quantity=(String)bean_1.getStockDtl().get("batchqty"+item_drug_code+batch_id).toString();
											quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
System.err.println("quantity @@ 931 ==="+quantity);
											 if(quantity.equals("0") || quantity.equals("0.0")){//Added for Manual allocation screen QTY not allocation properly
												 if(batch_det_stock.get("BATCH_ID").equals(batch_id)){
												    quantity=batch_det_stock.get("QTY").toString();
													quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
													System.err.println("quantity @@ 935 ==="+quantity);
												 }
											 }
										}else{
										   if(batch_det_stock.get("BATCH_ID").equals(batch_id)){
												quantity=batch_det_stock.get("QTY").toString();
												quantity =  new Double(Math.ceil(Float.parseFloat(quantity)/conv_factor))+"";//Added of r INC 49122
												System.err.println("quantity @@ 941 ==="+quantity);
												//quantity= new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(quantity)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";
												
										   }
										}
									 }//Adding end for MMS-ICN-0128
									}										//Added for KDAH-CRF-0231 [IN-034551]- End
									
									String stock_qty="";
									if(item_drug_code.equals(bean_1.getStockDtl().get("drug_code").toString()) && bean_1.getStockDtl().containsKey(item_drug_code)){
										stock_qty=bean_1.getStockDtl().get(item_drug_code).toString();
									}
									else{
										stock_qty=quantity;
									}
									tempstock.put(item_drug_code+"~"+batch_id,order_id+"~"+order_line_no+"~"+stock_qty+"~"+item_cost+"~"+uom_code+"~"+base_uom);//Added for KDAH-CRF-0231 [IN-034551] //base_uom is added for [IN:049778]
									bean_1.setTempStockDtls(tempstock);
									//Added for KDAH-CRF-0231 [IN-034551]

									if(quantity.equals("") ||bConsiderOldBatchDetails==true) {
										if( (Double.parseDouble(qty) < Double.parseDouble(issue_qty))) {
											quantity	=	qty;
											qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
											if(Float.parseFloat(qty)<0){
												qty=0+"";
											}
										//qty_arrived	=	true;
										}
										else  {
											quantity	=	issue_qty;
											qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
											//qty			=	tmp_qty+"";
										}				
									}
				 
									int  alloc_qty      = 0;
									disp_avail_qty = issue_qty; //"0"; //Commented for  MMS-SCF-0040 [IN:041888]//uncommented for MMC-ICN-0128
									if(base_to_disp_uom_equl!=base_to_def_uom_equl  ){
										if(all_drug_detail.size()==0){
											quantity       = ( new Float(Math.ceil(((Float.parseFloat(quantity))/base_to_disp_uom_equl))).intValue())+"";
										}
										//disp_avail_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";  //Commented for  MMS-SCF-0040 [IN:041888]
									}
									else{
										disp_avail_qty = retunFormatedInt(issue_qty);
									}
									quantity =retunFormatedInt(quantity);
									// Check/Uncheck Select checkbox based on quantity value
									if(!quantity.equals(""))
										select_status	=	"checked";

									if(stock_items.size() > 1) {
										if(!item_drug_code.equals(tmp_item_code)) {
											tmp_item_code		=	item_drug_code;
%>
											<tr><td colspan="8"  class="CURRTEXT"><font size="1" style="font-weight:bold"><fmt:message key="Common.item.label" bundle="${common_labels}"/> : <%=tmp_item_code%></font></td></tr>
<%
										}
									}
								//	bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity) ; //Added for KDAH-CRF-0231 [IN-034551] brought from down to here for MMS-ICN-0128
									quantity= new Double(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(quantity)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";//Added for MMS-ICN_0128
									quantity =retunFormatedInt(quantity);
									//System.err.println("quantity@@@999=="+quantity);
									bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity) ; //Added for KDAH-CRF-0231 [IN-034551] brought from down to here for MMS-ICN-0128
												
%>
									<tr>
										<td  width="10%" class="<%=class_name%>">
											<input type="hidden" name="item_drug_code<%=rec_no%>" id="item_drug_code<%=rec_no%>" value="<%=item_drug_code%>"><input type="hidden" name="item_drug_color<%=rec_no%>" id="item_drug_color<%=rec_no%>" value="<%=item_drug_color%>">&nbsp;<%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%><input type="hidden" name="expiry_date<%=rec_no%>" id="expiry_date<%=rec_no%>" value="<%=expiry_date%>">
										</td>
										<td  width="10%" class="<%=class_name%>">&nbsp;<%=batch_id%><input type="hidden" name="batch_id<%=rec_no%>" id="batch_id<%=rec_no%>" value="<%=batch_id%>"></td>
										<td  width="20%" class="<%=class_name%>">&nbsp;<%=trade_name%>
<%
										image_path				=  drug_trade_bean.getImagePath(drug_code,trade_id);	
										if ((image_path!=null)&& !(image_path.equals(""))){
%>
											<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height=20  width=20 onClick="showImage('<%=drug_code%>','<%=trade_id%>')">
<%  
										}
%>
										<input type="hidden" name="trade_id<%=rec_no%>" id="trade_id<%=rec_no%>" value="<%=trade_id%>">
										</td>
										<td  width="20%" class="<%=class_name%>">&nbsp;<%=manufacturer_name%></td>
										<td  width="15%" class="<%=class_name%>">&nbsp;<%=bin_location%><input type="hidden" name="bin_locn_code<%=rec_no%>" id="bin_locn_code<%=rec_no%>" value="<%=bin_locn_code%>"></td>
										<td  width="10%" class="<%=class_name%>">&nbsp;<%=issue_qty%><input type="hidden" name="alloc_qty<%=rec_no%>" id="alloc_qty<%=rec_no%>" value="<%=disp_avail_qty+""%>"></td>
<%	
										int tmp_unit_qty =	0;
%>
										<td  width="15%" class="<%=class_name%>">
										<input type="text" class="flat" size="8" value="<%=(int)Math.floor(Double.parseDouble(quantity))%>" name="issue_qty<%=rec_no%>" style="text-align:right"   onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,6,0);}else{return false;}"  onBlur="if(validateQty(this,'<%=rec_no%>')){setQtyBsdOnIssueUOM(this,'<%=rec_no%>')};" maxlength="5">&nbsp;<b><label class="label" id="issue_uom_lbl<%=rec_no%>" style="font-size:9"><%=bean.getUOMDesc(base_uom)%></label></b> <!--MMS-SCF-0040 uom_code - > base_uom -->
<%
									//	bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity) ; //Added for KDAH-CRF-0231 [IN-034551]//Moved to above for MMS-ICN-0128
%>
										<input type="hidden" name="base_uom<%=rec_no%>" id="base_uom<%=rec_no%>" value="<%=base_uom%>">
										<input type="hidden" name="issue_uom<%=rec_no%>" id="issue_uom<%=rec_no%>" value="<%=dflt_issue_uom%>">
										<input type="hidden" name="disp_uom<%=rec_no%>" id="disp_uom<%=rec_no%>" value="<%=uom_code%>">
										<input type="hidden" name="base_to_disp_uom_equl<%=rec_no%>" id="base_to_disp_uom_equl<%=rec_no%>" value="<%=base_to_disp_uom_equl%>">
										<input type="hidden" name="base_to_def_uom_equl<%=rec_no%>" id="base_to_def_uom_equl<%=rec_no%>" value="<%=base_to_def_uom_equl%>">
										<input type="hidden" name="issue_qty_old<%=rec_no%>" id="issue_qty_old<%=rec_no%>" value="<%=quantity%>">
										<input type="hidden" name="issue_uom_qty<%=rec_no%>" id="issue_uom_qty<%=rec_no%>" value="">
										<input type="hidden" name="issue_uom_uom<%=rec_no%>" id="issue_uom_uom<%=rec_no%>" value="">
										<input type="hidden" name="issue_uom_desc<%=rec_no%>" id="issue_uom_desc<%=rec_no%>" value="">
										<input type="hidden" name="issue_uom_equl<%=rec_no%>" id="issue_uom_equl<%=rec_no%>" value="">
										</td>
										<td  width="5%" class="<%=class_name%>"><input type="checkbox"  name="select<%=rec_no%>" id="select<%=rec_no%>" <%=select_status%> onClick="validateCheck(this,'<%=rec_no%>')"></td>
									</tr>
<%	
									bean_1.setStockDtlKey("stockQty", (int)Math.floor(Double.parseDouble(quantity))+"");// stockQty key added for KDAH-CRF-0231 [IN-034551]
									rec_no++;
							 }
						}//Added for KDAH-CRF-0231 [IN-034551]
					}
				  	bean_1.setBarcode_multi_id("N");//Added for KDAH-CRF-0231 [IN-034551]
				}
				else{
				    //Added for KDAH-CRF-0231 [IN-034551] - Start
				    if(barcode_flg==null){
						barcode_flg="";
				    }    //Added for KDAH-CRF-0231 [IN-034551]	-End
					issue_qty = issue_qty_val_1+""; //Added for  MMS-SCF-0040 [IN:041888]
					for(int j=0; j<stock_detail.size(); j++ ) {
					  //if(!bean_1.getOrderType().equals("NOR")) // if condition added for GHL-CRF-0463 and commented for MMS-KH-CRF-0038
					    //bean_1.setBarcode_Scan_YN("N"); 

						stk_dtls.add("Y");
						bean.setStockItems(drug_code,stk_dtls);
						drug_detail			=	(HashMap)stock_detail.get(j);
						issue_qty			=	(String)drug_detail.get("AVAIL_QTY");
						if(Double.parseDouble(issue_qty)<1.0)
							continue;
						item_drug_code		=	(String)drug_detail.get("ITEM_CODE");	
						expiry_date			=	(String)drug_detail.get("EXPIRY_DATE");	
						batch_id			=	(String)drug_detail.get("BATCH_ID");	
						trade_id			=	(String)drug_detail.get("TRADE_ID");	
						trade_name			=	(String)drug_detail.get("TRADE_NAME");	
						manufacturer_name	=	(String)drug_detail.get("MANUFACTURER_NAME");	
						bin_locn_code		=	(String)drug_detail.get("BIN_LOCATION_CODE");
						bin_location		=	(String)drug_detail.get("BIN_DESC");
						issue_qty			=	retunFormatedInt(Math.floor(Double.parseDouble(issue_qty))+""); // To make avaiilable qty as whole quantity
						
					//	System.err.println("barcode_flg@@==="+barcode_flg+"getTempStockDtls=="+bean_1.getTempStockDtls()+"item_drug_code=="+item_drug_code+"bean_1.getStockDtl()==="+bean_1.getStockDtl());
						if(!barcode_flg.equals("") && barcode_flg.equals("N") ||  bean_1.getTempStockDtls().containsKey(item_drug_code) && bean_1.getTempStockDtls().get(item_drug_code).equals(item_drug_code)|| bean_1.getStockDtl().containsKey("barcode_applicable"+item_drug_code) && bean_1.getStockDtl().get("barcode_applicable"+item_drug_code).equals("Y") || bean_1.getStockDtl().containsKey("allocated"+item_drug_code+batch_id) && bean_1.getStockDtl().get("allocated"+item_drug_code+batch_id).equals(item_drug_code) || all_drug_detail.contains(item_drug_code)){ //if block Added for KDAH-CRF-0231 [IN-034551]//all_drug_detail.contains(item_drug_code) Added for MMS-DM-CRF-0174.5
							bean_1.setStockDtlKey("barcode_applicable"+item_drug_code,"N");
							if(!barcode_flg.equals("") && barcode_flg.equals("Y")){
								bean_1.setBatch_val(stock_detail);
							}
						}
						quantity			=	"";
						select_status		=	"";
						tot_qty				+=	Double.parseDouble(issue_qty);
						if(j%2==0)
							class_name	=	"QRYEVENSMALL"; 
						else
							class_name	=	"QRYODDSMALL";

						// For getting the allocated quantity
						if(alt_drug_code.equals("")){
							 if(strResetQty.equals("") || strResetQty.equals("false")){
								// This condion is added to default the qty same like old batch Id. If the batch id is different also
								// the calculated qty should be same. ref spira id #IN015288
								if(bConsiderOldBatchDetails) {
									quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
								}
								else
									quantity	=	bean.getStockQuantity(patient_id,order_id,order_line_no,item_drug_code,batch_id,expiry_date,bin_locn_code);
								/*if(quantity==null || quantity.equals("")) //added for MMS-KH-CRF-0038
									quantity="0";*/ //commented for SKR-SCF-1643,SKR-SCF-1644,SKR-SCF-1645  

							  }
							  else{
								  quantity	= "";
							  }
						}
						else{ // else block added for KDAH-CRF-0231 [IN-034551] -start
							if(strResetQty.equals("") || strResetQty.equals("false")){
								// This condion is added to default the qty same like old batch Id. If the batch id is different also
								// the calculated qty should be same. ref spira id #IN015288
								if(bConsiderOldBatchDetails)
									quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,sOrigBatchId,sPastExpDate,sPastBinLocn);
								else
									quantity	=	bean.getAlternateStockQuantity(patient_id,order_id,order_line_no,alt_drug_code,item_drug_code,batch_id,expiry_date,bin_locn_code);
								if(uom_code!=base_uom && !quantity.equals("") ){  //if block added for  ML-BRU-SCF-1803 - Start
									 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									// quantity       = new Double(Math.ceil(Float.parseFloat(quantity)*base_to_disp_uom_equl))+"";//Commented for ML-BRU-SCF-1443
								 } //if block added for  ML-BRU-SCF-1803 - End
							}
							else{
								quantity	= "";

							}
						}
						//disp_avail_qty = quantity; //Added for  MMS-SCF-0040 [IN:041888]
						if(quantity.equals("") ||bConsiderOldBatchDetails==true) {
							if( (Double.parseDouble(qty) < Double.parseDouble(issue_qty))) {
							  if(bean_1.getBarcode_Scan_YN().equals("Y") && !alt_drug_code.equals("") && bean_1.getOrderType().equals("NOR")) // if else Added for MMS-DM-SCF-0083
								  quantity ="0";
							  else
								quantity	=	qty; 
								qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
								if(Float.parseFloat(qty)<0){
									qty=0+"";
								}
							//qty_arrived	=	true;
							}
							else  {
								quantity	=	issue_qty;
								qty		    =	(Double.parseDouble(qty) - (int)Double.parseDouble(issue_qty))+"";
								//qty			=	tmp_qty+"";
							}				
						}
						int  alloc_qty      = 0;
						disp_avail_qty = issue_qty; //"0"; //Commented for  MMS-SCF-0040 [IN:041888]
						if(base_to_disp_uom_equl!=base_to_def_uom_equl  ){
							if(all_drug_detail.size()==0){
								quantity       = ( new Float(Math.ceil(((Float.parseFloat(quantity))/base_to_disp_uom_equl))).intValue())+"";
								if(uom_code!=base_uom && !quantity.equals("")){  //if block added for  ML-BRU-SCF-1803 - Start
									 conv_factor    = bean.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
									 quantity       = new Double(Math.ceil(Float.parseFloat(quantity)*base_to_disp_uom_equl))+"";
								 } //if block added for  ML-BRU-SCF-1803 - End
							}
							//disp_avail_qty = new Float(Math.ceil(((Math.ceil((Float.parseFloat((Double.parseDouble(issue_qty)*base_to_def_uom_equl)+""))/(conv_factor)))*(conv_factor))/base_to_disp_uom_equl)).intValue()+"";  //Commented for  MMS-SCF-0040 [IN:041888]
							if(Double.parseDouble(issue_qty)<Double.parseDouble(disp_avail_qty)) //if block added for  MMS-SCF-0040 [IN:041888]
								quantity = "0";
						}
						else{ 
							disp_avail_qty = retunFormatedInt(issue_qty);
							/*if(all_drug_detail.size()==0){
							//quantity       = ( new Float(Math.ceil(((Float.parseFloat(quantity))/base_to_disp_uom_equl))).intValue())+"";
							}*/
						}
						quantity =retunFormatedInt(quantity);

						// Check/Uncheck Select checkbox based on quantity value
						if(!quantity.equals("")) 
							select_status	=	"checked";

						if(stock_items.size() > 1) {
							if(!item_drug_code.equals(tmp_item_code)) { 
								tmp_item_code		=	item_drug_code;
%>
								<tr><td colspan="8"  class="CURRTEXT"><font size="1" style="font-weight:bold"><fmt:message key="Common.item.label" bundle="${common_labels}"/> : <%=tmp_item_code%></font></td></tr>
<%
							}
						}
%>
						<tr>
							<td  width="10%" class="<%=class_name%>">
								<input type="hidden" name="item_drug_code<%=rec_no%>" id="item_drug_code<%=rec_no%>" value="<%=item_drug_code%>"><input type="hidden" name="item_drug_color<%=rec_no%>" id="item_drug_color<%=rec_no%>" value="<%=item_drug_color%>">&nbsp;<%=com.ehis.util.DateUtils.convertDate(expiry_date,"DMY","en",locale)%><input type="hidden" name="expiry_date<%=rec_no%>" id="expiry_date<%=rec_no%>" value="<%=expiry_date%>">
							</td>
							<td  width="10%" class="<%=class_name%>">&nbsp;<%=batch_id%><input type="hidden" name="batch_id<%=rec_no%>" id="batch_id<%=rec_no%>" value="<%=batch_id%>"></td>
							<td  width="20%" class="<%=class_name%>">&nbsp;<%=trade_name%>
<%
							image_path				=  drug_trade_bean.getImagePath(drug_code,trade_id);	
							if ((image_path!=null)&& !(image_path.equals(""))){
%>
								<img style="cursor:pointer;" src="../../ePH/images/camera.gif" height=20  width=20 onClick="showImage('<%=drug_code%>','<%=trade_id%>')">
<%   
							}
%>
							<input type="hidden" name="trade_id<%=rec_no%>" id="trade_id<%=rec_no%>" value="<%=trade_id%>">
							</td>
							<td  width="20%" class="<%=class_name%>">&nbsp;<%=manufacturer_name%></td>
							<td  width="15%" class="<%=class_name%>">&nbsp;<%=bin_location%><input type="hidden" name="bin_locn_code<%=rec_no%>" id="bin_locn_code<%=rec_no%>" value="<%=bin_locn_code%>"></td>
							<td  width="10%" class="<%=class_name%>">&nbsp;<%=issue_qty%><input type="hidden" name="alloc_qty<%=rec_no%>" id="alloc_qty<%=rec_no%>" value="<%=disp_avail_qty+""%>"></td>
<%	
							int tmp_unit_qty =	0;
							bean_1.setStockDtlKey("batchqty"+item_drug_code+batch_id,quantity); // Added for KDAH-CRF-0231 [IN-034551]
%>
							<td  width="15%" class="<%=class_name%>">
								<input type="text" class="flat" size="8" value="<%=(int)Math.floor(Double.parseDouble(quantity))%>" name="issue_qty<%=rec_no%>" style="text-align:right"  onKeyPress="if(event.keyCode!=13) {return allowValidNumber(this,event,6,0);}else{return false;}"  onBlur="if(validateQty(this,'<%=rec_no%>')){setQtyBsdOnIssueUOM(this,'<%=rec_no%>')};" maxlength="5">&nbsp;<b><label class="label" id="issue_uom_lbl<%=rec_no%>" style="font-size:9"><%=bean.getUOMDesc(base_uom)%></label></b>
								<input type="hidden" name="base_uom<%=rec_no%>" id="base_uom<%=rec_no%>" value="<%=base_uom%>">
								<input type="hidden" name="issue_uom<%=rec_no%>" id="issue_uom<%=rec_no%>" value="<%=dflt_issue_uom%>">
								<input type="hidden" name="disp_uom<%=rec_no%>" id="disp_uom<%=rec_no%>" value="<%=uom_code%>">
								<input type="hidden" name="base_to_disp_uom_equl<%=rec_no%>" id="base_to_disp_uom_equl<%=rec_no%>" value="<%=base_to_disp_uom_equl%>">
								<input type="hidden" name="base_to_def_uom_equl<%=rec_no%>" id="base_to_def_uom_equl<%=rec_no%>" value="<%=base_to_def_uom_equl%>">
								<input type="hidden" name="issue_qty_old<%=rec_no%>" id="issue_qty_old<%=rec_no%>" value="<%=quantity%>">
								<input type="hidden" name="issue_uom_qty<%=rec_no%>" id="issue_uom_qty<%=rec_no%>" value="">
								<input type="hidden" name="issue_uom_uom<%=rec_no%>" id="issue_uom_uom<%=rec_no%>" value="">
								<input type="hidden" name="issue_uom_desc<%=rec_no%>" id="issue_uom_desc<%=rec_no%>" value="">
								<input type="hidden" name="issue_uom_equl<%=rec_no%>" id="issue_uom_equl<%=rec_no%>" value="">
							</td>
							<td  width="5%" class="<%=class_name%>"><input type="checkbox"  name="select<%=rec_no%>" id="select<%=rec_no%>" <%=select_status%> onClick="validateCheck(this,'<%=rec_no%>')"></td>
						</tr>
<%	
						
						rec_no++;
						bean_1.setBarcode_multi_id("N");
					//}
					} //Added for KDAH-CRF-0231 [IN-034551]
				}
			}
%>
			</table>
			<br>
			<br>
			<br>
			<table cellpadding="0" cellspacing="0" width="100%" align="center" border="0">
<% 	
				if(disp_info.size() > 0 && (((String)disp_info.get(1)).equals("Y")) ) { 
					String info		=	((String)disp_info.get(0)).substring(31,36) +"&nbsp;&nbsp;"+((String)disp_info.get(0)).substring(52,((String)disp_info.get(0)).length());
%>
					<tr><td  class="DISPDTL"><font color="WHITE" size="2"><fmt:message key="ePH.AlreadyDispensed-Todayat.label" bundle="${ph_labels}"/> :<%=info%> </font></td></tr>
<%	
				} 
%>
			</table>
			<input type="hidden" name="bean_id" id="bean_id" value="<%=bean_id%>">
			<input type="hidden" name="bean_name" id="bean_name" value="<%=bean_name%>">
			<input type="hidden" name="drug_code" id="drug_code" value="<%=drug_code%>"> 
			<input type="hidden" name="totalRecords" id="totalRecords" value="<%=rec_no%>"> 
			<input type="hidden" name="alt_drug_code" id="alt_drug_code" value="<%=alt_drug_code%>"> 
			<input type="hidden" name="patient_id" id="patient_id" value="<%=bean_1.getSelectedPatientID()%>"> 
			<input type="hidden" name="order_id" id="order_id" value="<%=order_id%>"> 
			<input type="hidden" name="sys_date" id="sys_date" value="<%=sys_date%>">
			<input type="hidden" name="uom" id="uom" value="<%=uom%>">
			<input type="hidden" name="bms_qty" id="bms_qty" value="<%=bms_qty%>">
			<input type="hidden" name="order_line_no" id="order_line_no" value="<%=order_line_no%>">
			<input type="hidden" name="source" id="source" value="<%=source%>">
			<input type="hidden" name="recno" id="recno" value="<%=recno%>">
			<input type="hidden" name="tot_qty" id="tot_qty" value="<%=tot_qty%>">
			<input type="hidden" name="item_cost" id="item_cost" value="<%=item_cost%>">
			<input type="hidden" name="oper_mode" id="oper_mode" value="<%=oper_mode%>">
			<input type="hidden" name="drug_class" id="drug_class" value="<%=drug_class%>">
			<input type="hidden" name="disp_narcotic_yn" id="disp_narcotic_yn" value="<%=bean_1.getDispNarcoticYN()%>">
			<input type="hidden" name="disp_controlled_yn" id="disp_controlled_yn" value="<%=bean_1.getDispControlledYN()%>"> <!--added for SKR-SCF-0688 [IN:036036]-->
			<input type="hidden" name="disp_auth_yn" id="disp_auth_yn" value="<%=disp_auth_yn%>">
			<input type="hidden" name="issuebyuom" id="issuebyuom" value="<%=bean_1.getIssueByUOM()%>">
			<input type="hidden" name="alt_drg_no" id="alt_drg_no" value="<%=alt_drg_no%>">
			<input type="hidden" name="userAuthPINYN" id="userAuthPINYN"	value="<%=userAuthPINYN%>">  <!-- Added for RUT-CRF-0035 [IN029926] -->
			<input type="hidden" name="pres_qty_alert" id="pres_qty_alert" value="<%=pres_qty_alert%>"><!-- code added for AMS-CRF-0035[IN033551] -->   
			<input type="hidden" name="disp_decimal_dtls_yn" id="disp_decimal_dtls_yn" value="<%=st_disp_decimal_dtls_yn%>"> <!-- Added for AAKH-SCF-0113 [IN:048937] -->
			<input type="hidden" name="allow_decimals_yn" id="allow_decimals_yn" value="<%=st_allow_decimals_yn%>">  <!-- Added for AAKH-SCF-0113 [IN:048937] -->
<%
			HashMap hmAllowMoreQty = bean_1.getHmAllowMoreQty();
			if(hmAllowMoreQty == null)
				hmAllowMoreQty = new HashMap();
%>
			<input type="hidden" name="AllowMoreThanPresQty" id="AllowMoreThanPresQty" value="<%=hmAllowMoreQty.get(drug_code)%>">

		</form>
	</body>
	<script>
<%
		all_params=all_params+"&source="+bean_1.getStockDtl().get("source").toString();//34551
%>
		controlStockImage('<%=tot_qty%>','<%=bms_qty%>','<%=all_params%>','<%=barcode_flg%>','<%=bean_1.getStockDtl().get("barcode_id")%>','<%=rec_no%>')// added for KDAH-CRF-0231 [IN-034551]
		</script>
<%
//added for MMS-KH-CRF-0038
		if(bean_1.getBarcode_id()!=null && bean_1.getBarcode_id().equals("")) //if added for MMS-KH-CRF-0038
		{%>
	<script>
		issueUOM(parent.f_stock_dtls.DispMedicationStockDetails.issue_uom_select);
	</script>
	<%}%>
<%! 
	DecimalFormat dfToInteger = new DecimalFormat("#.##");
	private String retunFormatedInt(String sValue){
		if(sValue != null && !sValue.equals("")){
			return dfToInteger.format(Double.parseDouble(sValue));
		}
		return "";
	}
%>
<%
	// objects nullified after usage
	stock				=	null;
	for_stock_1			=	null;
	for_stock_2			=	null;
	stock_detail		=	null;
	drug_detail			=	null;
	all_drug_detail		=	null;
	stock_items			=	null;
	params				=	null;
	st_detail			=	null;
%>
</html>
<%
	putObjectInBean(bean_id,bean,request);
	putObjectInBean(bean_id_1,bean_1,request);
	putObjectInBean(bean_id_2,bean_2,request);
	putObjectInBean(bean_id_3,bean_3,request);
}
catch(Exception e){
	e.printStackTrace();
}
%>

