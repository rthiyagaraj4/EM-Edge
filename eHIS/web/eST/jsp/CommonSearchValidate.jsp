
<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
09/02/2017		IN061112			Badmavathi B					        GHL-CRF-0413 - Barcode search
24/05/2017		IN063603			Badmavathi B							GHL-CRF-0456
2/09/2017		IN064209			Soorya Prakash M						GHL-CRF-0465
18/09/2017		IN064209			Chithra M								GHL-CRF-413.7 changes
6/11/2017		IN064968			Shazana hasan							MMS-DM-CRF-0112 - Barcode Encoding
30/01/2020              IN071972                        Haribabu                                                 AAKH-CRF-0117.2 
21/08/2020              IN073577                        Haribabu                                                 MMS-DM-CRF-0174.2
07/09/2020      IN073938        B Haribabu          07/09/2020                    MMS-DM-CRF-0174.2
19/01/2021      TFS id:6938        B Haribabu          19/01/2021                    MMS-DM-CRF-0174.3
22/9/2021		TFS:22321			Shazana												GHL-SCF-1587
---------------------------------------------------------------------------------------------------------
*/
%>
 <%@page  import=" eST.*,eST.Common.*,eCommon.Common.*,java.util.*,java.sql.*,java.io.*,java.lang.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=ISO-8859-1"%>  

<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);	
	hash = (Hashtable) hash.get ("SEARCH");

	String locale			=	(String)session.getAttribute("LOCALE");

	System.out.println("hash = > "+hash);

	
	String BARCODE			=	request.getParameter("BARCODE_YN")==null?"":request.getParameter("BARCODE_YN");
	String checkAuthorizationYN			=	request.getParameter("CHECK_AUTH_YN")==null?"":request.getParameter("CHECK_AUTH_YN");//Added for ML-MMOH-CRF-0448 B.Badmavathi
	System.out.println("BARCODE = > "+BARCODE);
	boolean	result					=	false;
	String message			=	"";
	String flag				=	"";
	//Added for ML-MMOH-CRF-0448 B.Badmavathi starts
	if(checkAuthorizationYN.equals("CHECKAUTH")){
		ProductTransferBean ebean	=			(ProductTransferBean) getBeanObject( "ProductTransferBean","eST.ProductTransferBean", request );
		String store_code	=   request.getParameter("store_code");
		 System.out.println("in productvalidate store code"+store_code);
		String stAuthorized_allowed	= ebean.getFinalize_allowed_yn(store_code);
		System.out.println("stAuthorized_allowed"+stAuthorized_allowed);
		out.println("setFinalize_allowed('"+stAuthorized_allowed+"');");
		putObjectInBean("ProductTransferBean",ebean,request);
	}else{//Added for ML-MMOH-CRF-0448 B.Badmavathi ends
	
			if (BARCODE.equals("TRUE")){	
				try{	
					//eST.Common.StAdapter beanObj = null;
		
					String bean_id		= request.getParameter( "bean_id" );
					String bean_name	= request.getParameter( "bean_name" );
		
					//System.out.println("ebean id = > "+bean_id+" bean_name = > "+bean_name);
		
					Object beanObject = getBeanObject( bean_id,bean_name,request); 
									
					//eST.SalesBean ebean  = null;
					eST.Common.StTransaction ebean = null;
		
		
					if (beanObject  instanceof eST.Common.StTransaction) 	{
						ebean = (eST.Common.StTransaction)beanObject ; 
						//System.out.println("Instance of StTransaction");
					}
					
					HashMap hashmapDtl=new HashMap();
				
					int no_of_decimals				=	ebean.getNoOfDecimals();
					String pitem_desc				=	request.getParameter("item_desc");
					String pitem_code				=	request.getParameter("item_code");
					String pstore_code				=	request.getParameter("store_code");
					String pitem_qty				=	request.getParameter("item_qty");
					String psale_req_qty			=	ebean.checkForNull(request.getParameter("sale_req_qty"),"0");
					String puom_desc				=	request.getParameter("uom_desc");
					String puom_code				=	request.getParameter("uom_code");
					String pstock_available			=	request.getParameter("stock_available");
					String premarks					=	request.getParameter("remarks");
					String premarks_code			=	ebean.checkForNull(request.getParameter("remarks_code"));
					//String ppatient_id				=	request.getParameter("patient_id");Commanded for Unused local variable
					String pdoc_srl_no				=	request.getParameter("doc_srl_no");
					String pitem_unit_cost			=	request.getParameter("item_unit_cost");
					String pitem_cost_value			=	request.getParameter("item_cost_value");
					String pexpiry_yn				=	request.getParameter("expiry_yn");
					String pstock_item_yn			=	request.getParameter("stock_item_yn");
					String pindex					=	request.getParameter("index");
					//String pInpatient_yn			=	request.getParameter("Inpatient_yn");Commanded for Unused local variable
					//String poutpatient_yn			=	request.getParameter("outpatient_yn");Commanded for Unused local variable
					//String preferral_yn				=	request.getParameter("referral_yn");Commanded for Unused local variable
					//String pdaycare_yn				=	request.getParameter("daycare_yn");Commanded for Unused local variable
					//String pemergency_yn			=	request.getParameter("emergency_yn");Commanded for Unused local variable
					//String pdirectsale_yn			=	request.getParameter("directsale_yn");Commanded for Unused local variable
					String pbl_def_override_excl_incl_ind		=	ebean.checkForNull(request.getParameter("bl_def_override_excl_incl_ind"));
					String pbl_override_excl_incl_ind			=	ebean.checkForNull(request.getParameter("bl_override_excl_incl_ind")); //3
					String pbl_incl_excl_override_reason_code	=	ebean.checkForNull(request.getParameter("bl_incl_excl_override_reason_code"));
					String pbl_incl_excl_override_reason_desc	=	ebean.checkForNull(request.getParameter("bl_incl_excl_override_reason_desc")); //
					String ppat_paid_amt				=	ebean.checkForNull(request.getParameter("pat_paid_amt"));
					String pgross_charge_amt			=	ebean.checkForNull(request.getParameter("gross_charge_amt"));
					String ppat_net_amt					=	ebean.checkForNull(request.getParameter("pat_net_amt"));
					String papproval_reqd_yn			=	ebean.checkForNull(request.getParameter("approval_reqd_yn"));
					String pbl_override_allowed_yn		=	ebean.checkForNull(request.getParameter("bl_override_allowed_yn")); //1
					String pno_of_decimals1				=	request.getParameter("no_of_decimals");
					//String pdecimal_allowedYN1			=	request.getParameter("decimal_allowedYN"); commanded for Unsused Local Variables
					String pbillable_item_yn1			=	ebean.checkForNull(request.getParameter("billable_item_yn"),"N");
					String pbatch_records				=	(String)request.getParameter("batch_records");
					//String pbar_code					=	request.getParameter("bar_code");
					String pbatch_id					=	(String)request.getParameter("batch_id");
					String pexpiry_date					=	(String)request.getParameter("expiry_date");
					String validate						=	request.getParameter("validate");
				
				
					String expired_batch		=	request.getParameter("expired_batch");
					String ex_param_days		=	request.getParameter("ex_param_days");
					String to_conv_fact			=	request.getParameter("to_conv_fact"); 
					String frm_conv_fact		=	request.getParameter("frm_conv_fact");
					String frm_store_uom_desc	=	request.getParameter("frm_store_uom_desc");
					String to_store_uom_desc	=	request.getParameter("to_store_uom_desc");
					String kit_item_yn			=	request.getParameter("kit_item_yn"); 
					String from_multiples		=	request.getParameter("from_multiples");
					String to_multiples			=	request.getParameter("to_multiples"); 
					String batch_multiples		=	request.getParameter("batch_multiples");
				
					String stock_uom_desc			=	request.getParameter("uom_desc");
					String iss_uom_code				=	request.getParameter("iss_uom_code");
					String uom_conv_code			=	request.getParameter("uom_conv_code");
					String iss_uom_qty				=	ebean.checkForNull(request.getParameter("iss_uom_qty"),"0");
					String for_bin_to_store_hidden	=	request.getParameter("for_bin_to_store_hidden");
					String iss_uom_conv_text		=	request.getParameter("iss_uom_conv_text");
				    String issue_uom_multiples		=	ebean.checkForNull(request.getParameter("issue_uom_multiples"),"1");
					String kit_temp_code			=	ebean.checkForNull(request.getParameter("kit_temp_code"));
					String usage_type			=	ebean.checkForNull(request.getParameter("usage_type")); 
					String approval_no			=	ebean.checkForNull(request.getParameter("approval_no"));//Added for IN:071972 
				
					System.out.println("validate = >"+validate);
					System.out.println("pindex-------96------->"+pindex);
					System.out.println("kit_temp_code-------96------->"+kit_temp_code);
					
					if (validate.equals("BARCODE")) {	
						SalesBean salesbean	=			(SalesBean) getBeanObject( "SalesBean","eST.SalesBean", request );//GHL-SCF-1587 
						String frombarcode = ebean.checkForNull(request.getParameter("frombarcode"));
						String	trn_type     =	ebean.checkForNull(request.getParameter("trn_type"));
					//	String  facility_id  =  ebean.checkForNull(ebean.getLoginFacilityId()); Commanded for Unused local variable
						String  formname     =	ebean.checkForNull(request.getParameter("formObj"));
						//String  framename    =	ebean.checkForNull(request.getParameter("frameObj"));
						String  fromStore    =  ebean.checkForNull(request.getParameter("fromStore"));
						String  toStore      =  ebean.checkForNull(request.getParameter("toStore"));
						String bar_code		 = ebean.checkForNull(request.getParameter("bar_code"));
						String jsp_page		 = ebean.checkForNull(request.getParameter("jsp_page"));
						//Added for GHL-CRF-0413 starts
						String site		 = ebean.checkForNull(request.getParameter("site"));
						Boolean barcode_yn_new = Boolean.valueOf(site);
						System.err.println("barcode_yn_new==>"+barcode_yn_new);
						//Added for GHL-CRF-0413 ends
						String allow_decimals_yn	="";
						String BarcodeWithMultipleBatches = "N";
						String new_con_screen_yn =ebean.checkForNull(request.getParameter("new_con_screen_yn"));//Added for TH-KW-CRF-0043
						HashMap rol_min_level = new HashMap();
			
						System.out.println("BARCODE==>"+bar_code);	
						//System.out.println("jsp_page==>"+jsp_page);
					
						//HashMap record	=	new HashMap();
						HashMap alTemp	=	new HashMap();
						ArrayList alBarCodeListDetails = new ArrayList(); //added for GHL-SCF-1587
						System.out.println("trn_type==>"+trn_type);
						String barcode_2d_applicable_yn = ebean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6

		
						try {
							
							/*ArrayList alBarCodeListDetails = ebean.getBarCodeDetailArrayList(bar_code,fromStore);
							System.out.println("alBarCodeListDetails==>"+alBarCodeListDetails);		*/ // commented here and added down for GHL-SCF-1587				
							//System.out.println("alBarCodeListDetails==>"+alBarCodeListDetails.size());
							//Added against GHL-CRF-0456 starts
							if(trn_type.equals("SAL")){
								if(barcode_2d_applicable_yn.equals("Y"))//Added for MMS-DM-CRF-0174.6
									     alBarCodeListDetails = ebean.get2DBarcodeBacthes(fromStore,bar_code);
							    else
								         alBarCodeListDetails = salesbean.getBarCodeDetailArrayList1(bar_code,fromStore);//modified for GHL-SCF-1587 								
								for (int j=0;j<alBarCodeListDetails.size();j++){
									HashMap temp_data	= (HashMap)alBarCodeListDetails.get(j);
									String temp_item = (String)temp_data.get("ITEM_CODE");
									String barcodeverify = (String)ebean.fetchRecord("SELECT SALES_ALLOWED_YN FROM ST_ITEM_STORE WHERE ITEM_CODE = ? AND STORE_CODE = ?", new String[]{temp_item,fromStore}).get("SALES_ALLOWED_YN");
									if(barcodeverify==null)//added againt INC 64828
										barcodeverify="";//end INC 64828
									if(barcodeverify.equals("N") ){
										alBarCodeListDetails.remove(j);	
										j--;
									}
								}
							}else{//added from above for GHL-SCF-1587 
							       if(barcode_2d_applicable_yn.equals("Y"))//Added for MMS-DM-CRF-0174.6
									     alBarCodeListDetails = ebean.get2DBarcodeBacthes(fromStore,bar_code);
									   else
								         alBarCodeListDetails = ebean.getBarCodeDetailArrayList(bar_code,fromStore);
								System.out.println("alBarCodeListDetails==>"+alBarCodeListDetails);			
							}
							//Added against GHL-CRF-0456 ends
							// boolean bill = false; commanded for unssed local Variables
							if (alBarCodeListDetails.size() > 0 ){					 
								if(alBarCodeListDetails.size() > 1 ){
									HashMap prev_records = new HashMap();
									String itemcode2 = "";
									BarcodeWithMultipleBatches = "Y";
									for (int t=0;t<alBarCodeListDetails.size();t++){
										HashMap record	=	(HashMap)alBarCodeListDetails.get(t);
										String itemcode1 = (String)record.get("ITEM_CODE");
										if(prev_records.size()>0){
											if (!itemcode1.equals(itemcode2)){
											throw new Exception("BARCODE_WITH_MORE_ITEMS");
											}
										}
										prev_records = record;
										itemcode2 = (String)prev_records.get("ITEM_CODE");
									}
								}
		
								for(int i=0; i<1; i++) {
									//this is to handle multiple batch, select 1st avail_qty>0
									for(int t1=0; t1<alBarCodeListDetails.size();) {
										
										HashMap temp_record	=	(HashMap)alBarCodeListDetails.get(t1);
										System.out.println("temp_record==>"+temp_record);
										int temp_availqty		=	Integer.parseInt((String)temp_record.get("AVAIL_QTY"));
										
										if(temp_availqty<=0){
											t1++;
										}
										else{
											i = t1;
											break;
										}
									}
			
									 HashMap record	=	(HashMap)alBarCodeListDetails.get(i);
					
									 System.out.println("record==>"+record);
					
									 String itemcode	=	(String)record.get("ITEM_CODE");
									 //String storecode   =   (String)record.get("STORE_CODE");
									 String batchid	    =	(String)record.get("BATCH_ID");
									 String expirydate	=	(String)record.get("EXPIRY_DATE");
									 String binlocation	=	(String)record.get("BIN_LOCATION_CODE");
									 String tradeid     =	(String)record.get("TRADE_ID");
									 String manufacturer_desc ="";//Added for TH-KW-CRF-0043
					
									 int availqty		=	Integer.parseInt((String)record.get("AVAIL_QTY"));
									 
									System.out.println("itemcode==>"+itemcode);
									System.out.println("fromStore==>"+fromStore);
									System.out.println("toStore==>"+toStore);
									System.out.println("batchid==>"+batchid);
									System.out.println("expirydate==>"+expirydate);
									System.out.println("binlocation==>"+binlocation);
									System.out.println("tradeid==>"+tradeid);
									System.out.println("availqty==>"+availqty);
									System.out.println("mode"+ebean.getMode());
									System.out.println("mode"+barcode_yn_new);
									System.out.println("mode"+trn_type);
									if(barcode_yn_new && trn_type.equals("RET") && ebean.getMode().equals("2")){
										availqty =1;
										}
									System.out.println("availqty"+availqty);
									if(availqty<=0 )				 
										 throw new Exception("INSUFFICIENT_BATCH_QTY");
									else{	
							
										//to chk the available qty for sequence > 1 
						
										/* commented due to no validation required
										if(ebean.getExpRecordsforBarCode()!= null && ebean.getExpRecordsforBarCode().size()>0){
										HashMap Batchqty = ebean.getExpRecordsforBarCode();
										for (int a=0; a<Batchqty.size();a++){
										ArrayList Batchtemp = (ArrayList)Batchqty.get(""+a);
										for (int b=0; b<Batchtemp.size();b++){
										HashMap temp = (HashMap)Batchtemp.get(b);
										if (( temp.get("ITEM_CODE").equals(itemcode) &&  temp.get("BATCH_ID").equals(batchid) &&  temp.get("EXPIRY_DATE").equals(expirydate)	&& 	temp.get("BIN_LOCATION_CODE").equals(binlocation) &&  temp.get("TRADE_ID").equals(tradeid))){
											float prev_trans_qty=  Float.parseFloat((String)temp.get("QTY"))	;
											if (availqty-prev_trans_qty<=0){
											 throw new Exception("AVAIL_BATCH_QTY_ALREADY_USED");
											}
											}
										}
										}	
										} */
										//to get the item details
										ArrayList alItemDetails = ebean.getItemDetailArrayList(locale,itemcode,fromStore);
						
										alTemp = (HashMap)alItemDetails.get(0);
						
										String item_code  = (String)alTemp.get("ITEM_CODE") ;
										String item_desc  =  (String)alTemp.get("ITEM_DESC") ;
										
									/*Added by Shazana for Barcode Encoding MMS-DM-CRF-0112 START*/
										if(!item_desc.equals("")&&item_desc!=null){//Modified (un commented) for IN073577
											item_desc=item_desc.replaceAll(" ","%20");
											item_desc=	java.net.URLEncoder.encode(item_desc,"UTF-8");
											item_desc=item_desc.replaceAll("%2520","%20");
										}/*Added by Shazana for Barcode Encoding MMS-DM-CRF-0112 END*/
										
										//item_desc=	java.net.URLEncoder.encode(item_desc,"UTF-8");
										String expiry_yn  = (String)alTemp.get("EXPIRY_YN") ;
										String uom_code   = (String)alTemp.get("GEN_UOM_CODE") ;
										String uom_desc   = (String)alTemp.get("GEN_UOM_DESC") ;//Modified for In:073938	
									//	String def_issue_uom_code   = (String)alTemp.get("DEF_ISSUE_UOM") ;commanded for Unsed Local variable
										String def_issue_uom_desc   = (String)alTemp.get("DEF_ISSUE_UOM_DESC") ;
										
										
										
							
										System.err.println("alItemDetails==>"+alItemDetails);
						
						
										String[] stParameters = {itemcode, fromStore, "0", "N", "", "N", toStore };
										String phy_inv_id = "";
										try { 
							
											//result = ebean.isPhysicalInventoryProcessStartedForStore(itemcode,fromStore,"");
							
											result = ebean.isPhysicalInventoryProcessStartedForStore(itemcode,fromStore,toStore);
							
											System.out.println("result==>"+result);
			
											if(result){
													//phy_inv_id=(String)	ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{itemcode,fromStore}).get("PHY_INV_ID");
							
													phy_inv_id=(String)ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,fromStore}).get("PHY_INV_ID");
													if(ebean.checkForNull(phy_inv_id,"").equals(""))
													phy_inv_id=(String)	ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,toStore}).get("PHY_INV_ID");
										
													out.println("document."+formname+".phy_inv_id.value = '"+ebean.checkForNull(phy_inv_id,"")+"';");
													throw new Exception("PHY_INV_PROCESS_INITIATED");
											}
			
											HashMap hmStockAvailabilityStatus = ebean.getStockAvailabilityStatus(stParameters);
							
											System.out.println("hmStockAvailabilityStatus==>"+hmStockAvailabilityStatus);
							
											String use_after_expiry_yn =(String)ebean.fetchRecord("select USE_AFTER_EXPIRY_YN from st_item where item_code =?",new String[]{item_code}).get("USE_AFTER_EXPIRY_YN");
											double avail_stock=0;				
							
											if(!(trn_type.equals("SAL"))){								
												if(use_after_expiry_yn.equals("Y")){
													avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")));
												}else{
													avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")));  
												}
											}else{
												double tmp_conv=ebean.getConvFactTemp(itemcode,fromStore);
												avail_stock = Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))/tmp_conv;
											}
							
											allow_decimals_yn=(String)hmStockAvailabilityStatus.get("allow_decimals_yn");
											
											if((trn_type.equals("SAL"))){	
												out.println("document."+formname+".no_of_decimals.value = '"+no_of_decimals+"';");
												out.println("document."+formname+".decimal_allowedYN.value = '"+allow_decimals_yn+"';");
												out.println("document."+formname+".dec_allowed_yn.value = '"+allow_decimals_yn+"';");
											}
											else if((trn_type.equals("ISS"))||(trn_type.equals("RET"))){//Added against GHL-CRF-0413
											}
											else if (!(trn_type.equals("URG")) && !new_con_screen_yn.equals("Y")){//new_con_screen_yn Added for TH-KW-CRF-0043
							                 	out.println("document."+formname+".no_deci.value = '"+no_of_decimals+"';");
												if(allow_decimals_yn.equals("Y")){
													out.println("document."+formname+".allow_deci_yn.value = '"+allow_decimals_yn+"';");				
												}else{
													out.println("document."+formname+".no_deci.value = '0';");				
												}
											}
			                          if(!new_con_screen_yn.equals("Y")){ // if condition alone Added for TH-KW-CRF-0043
											out.println("document."+formname+".item_code.value = '"+item_code+"';");
											out.println("document."+formname+".item_desc.value =decodeURIComponent('"+item_desc+"');"); //Commented by Shazana for Barcode Encoding MMS-DM-CRF-0112,Modified for IN073577
											//out.println("setItemDescription('"+formname+"','"+item_desc+"');");Added by Shazana for Barcode Encoding MMS-DM-CRF-0112 
											out.println("document."+formname+".item_desc.readOnly = true;");
											out.println("document."+formname+".expiry_yn.value = '"+expiry_yn+"';");
											
											out.println("document."+formname+".uom_code.value = '"+uom_code+"';");			
			
											System.out.println("uom_code 310="+uom_code+"==def_issue_uom_desc=>"+def_issue_uom_desc);
			
											out.println("document.getElementById('id_uom').innerHTML = '"+def_issue_uom_desc+"';");
											if((trn_type.equals("SAL"))){	
												out.println("document.getElementById('id_uom1').innerHTML = '"+def_issue_uom_desc+"';");	
											//else if((trn_type.equals("URG")))
											}else if((trn_type.equals("URG")|| (trn_type.equals("ISS")))){//Modified against GHL-CRF-0413.2-US002
												String iss_default_uom1		= ebean.getDefaultIssueUOMforBarcode(item_code,fromStore);
												System.out.println("iss_default_uom1="+iss_default_uom1);
												String gen_uom_code1			= ebean.getGenItemUOM(item_code);
												out.println("clearListItems('document."+formname+".iss_uom_code'); ");
											 	ArrayList iss_results = ebean.getPur_uom_code_ListforBarcode(gen_uom_code1,item_code);
												HashMap record1	= null;
												for(int u=0; u< iss_results.size(); u++) 
												{
													record1	=	(HashMap)iss_results.get(u);
													String listRecord1	=	(String)record1.get("EQVL_UOM_CODE");
													String listRecord2	=	(String)record1.get("SHORT_DESC");
													if(iss_default_uom1 !=null || iss_default_uom1 ==""){
														out.println("addListItem(\"document."+formname+".iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +iss_default_uom1+"\") ; ");
													}else{
														out.println("addListItem(\"document."+formname+".iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ,\"" +gen_uom_code1+"\") ; ");
													}
												}
												out.println("checkUOMConvFactor();");
												out.println("document.getElementById('uom_desc').innerHTML = '"+uom_desc+"';");//Modified for In:073938	
			
											}
											out.println("document."+formname+".bar_or_item_code.value = 'B';");
									  }
											//String  storeItemUnitCost=ebean.getUnitCost(itemcode,fromStore);
											Double storeItemUnitCost=ebean.getBaseUnitCost(itemcode); //Added to get base unit cost for barcode against inc#50521
							
											System.out.println("storeItemUnitCost==>"+storeItemUnitCost);
							
											
											String  billable_item_yn=ebean.checkForNull((String)ebean.fetchRecord("SELECT NVL(BILLABLE_ITEM_YN,'N') BILLABLE_ITEM_YN FROM MM_ITEM WHERE ITEM_CODE=?", itemcode).get("BILLABLE_ITEM_YN"),"N");
											
							
											//System.out.println("billable_item_yn==>"+billable_item_yn);
							
											if((trn_type.equals("SAL")))
												out.println("setStockDetailsforBarCode(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+""+avail_stock+"\",\""+""+billable_item_yn+"\");");
											else if((trn_type.equals("CON")) && !new_con_screen_yn.equals("Y")){//Added for GHL-CRF-0413 starts, new_con_screen_yn added for TH-KW-CRF-0043
												out.println("document.getElementById('id_stock_available').innerHTML = '"+hmStockAvailabilityStatus.get("available_stock")+"';");
												out.println("document.getElementById('id_store_item_unit_cost').innerHTML = '"+storeItemUnitCost+"';");	
												out.println("document.getElementById('id_item_sal_value_label').style.visibility = 'visible';");
												out.println("document.getElementById('id_item_sal_value').style.visibility = 'visible';");
												out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+ebean.setNumber(String.valueOf(avail_stock),no_of_decimals)+"\",\""+ebean.getConvFactTemp(itemcode,fromStore)+"\");");
											}//Added for GHL-CRF-0413 ends
											else if(!new_con_screen_yn.equals("Y")) //if Condition alone added for TH-KW-CRF-0043
												//out.println("setStockDetailsforBarcode(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("to_stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+ebean.setNumber(String.valueOf(avail_stock),no_of_decimals)+"\",\""+hmStockAvailabilityStatus.get("expired_stock")+"\");");
												out.println("setStockDetailsforBarcode(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("to_stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+ebean.setNumber(String.valueOf(avail_stock),no_of_decimals)+"\",\""+hmStockAvailabilityStatus.get("expired_stock")+"\",\""+ebean.getConvFactTemp(itemcode,fromStore)+"\");");
												
			
											if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y"))
											{
												if( hmStockAvailabilityStatus.get("available_stock").equals("0"))
													throw new Exception("STOCK_NOT_AVAILABLE");
											} else
												throw new Exception("NOT_STOCK_ITEM");
							                      //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014
											       if((trn_type.equals("ISS")) || (trn_type.equals("URG")) || (trn_type.equals("TFR")) || (trn_type.equals("SAL"))){ 
													   if(ebean.getMin_Rol_yn(ebean.getLoginById(),fromStore)){
													   		rol_min_level = ebean.getROL1(itemcode,fromStore);
													   		String min_str_qty   =   (String)rol_min_level.get("MIN_STK_QTY") ;
												       		String reorder_level   = (String)rol_min_level.get("REORDER_LEVEL") ;
												
															if(!(ebean.checkForNull((String)min_str_qty,"0")).equals("0")){
																out.println("document.getElementById('id_min_stk_label').style.visibility = 'visible';");
																out.println("document.getElementById('id_min_str_stk').style.visibility = 'visible';");
																out.println("document.getElementById('id_min_str_stk').innerHTML = '<B>"+ebean.checkForNull((String)min_str_qty,"0")+"</B>';");
																if(avail_stock < Double.parseDouble(ebean.checkForNull(min_str_qty,"0"))) {
															     	out.println("document.getElementById('id_min_str_stk').innerHTML = '<B style= background-color:red;color:yellow; >"+ebean.checkForNull((String)min_str_qty,"0")+"</B>';");
																}
															
															}
															if(!(ebean.checkForNull((String)reorder_level,"0")).equals("0")){
																out.println("document.getElementById('id_stk_rol_label').style.visibility = 'visible';");
																out.println("document.getElementById('id_stk_rol').style.visibility = 'visible';");
																out.println("document.getElementById('id_stk_rol').innerHTML = '<B>"+ebean.checkForNull((String)reorder_level,"0")+"</B>';");
																if(avail_stock < Double.parseDouble(ebean.checkForNull(reorder_level,"0")))
																{
																	out.println("document.getElementById('id_stk_rol').innerHTML = '<B style= background-color:red;color:yellow; >"+ebean.checkForNull((String)reorder_level,"0")+"</B>';");
																}
													 		}
															if(((avail_stock < Double.parseDouble(ebean.checkForNull(min_str_qty,"0"))) || (avail_stock < Integer.parseInt(ebean.checkForNull(reorder_level,"0")))) && ebean.getReq_allowed_yn(ebean.getLoginById(),fromStore) && (trn_type.equals("SAL"))){	
												      			out.println("document.getElementById('sales_req_label').style.visibility = 'visible';");
													  
													   		}
												      	}
													
											       } //ends					
										}
										catch (Exception exception) {
											result		=	false;
											message		=	exception.getMessage();		
											exception.printStackTrace();	
			
											if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
												throw exception;
											}
											if (exception.getMessage().equals("STOCK_NOT_AVAILABLE")) {
												throw exception;
											}
											if (exception.getMessage().equals("NOT_STOCK_ITEM")) {
												throw exception;
											}
											if (exception.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
												throw exception;
											}			
											if(barcode_yn_new)
												throw new Exception("ITEM_STORE_NOT_FOUND1");
											else
											throw new Exception("ITEM_STORE_NOT_FOUND");
										}				
									}
							
									message = itemcode+";"+batchid+";"+expirydate+";"+BarcodeWithMultipleBatches;
									System.out.println("message.... "+message);	
							
									if (!trn_type.equals("SAL")){
										try
										{
											if(BarcodeWithMultipleBatches.equals("N")){
												eST.Common.StUtilities bean1 = (eST.Common.StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
												bean1.setLanguageId(locale);
						                       String item_2d_barcode = ebean.get2dBarcodeItems(itemcode+"~"+batchid);//Added for MMS-DM-CRF-174.6
								              // String barcode_2d_applicable_yn = ebean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
								               System.err.println("item_2d_barcode==="+item_2d_barcode+"barcode_2d_applicable_yn=="+barcode_2d_applicable_yn);
												HashMap hmParameters	=	new HashMap();
												ArrayList alBatchRecords = new ArrayList();
												hmParameters.put("ITEM_CODE",itemcode);
												hmParameters.put("STORE_CODE",fromStore);
												hmParameters.put("BATCH_ID",batchid);
												hmParameters.put("EXPIRY_DATE",expirydate);
												//hmParameters.put("BIN_LOCATION_CODE",binlocation);
												hmParameters.put("TRN_QTY","0");
												hmParameters.put("BARCODE_2D",item_2d_barcode);//Added for MMS-DM-CRF-174.6
								                hmParameters.put("BARCODE_2D_APPLICABLE_YN",barcode_2d_applicable_yn);//Added for MMS-DM-CRF-174.6
						                        System.err.println("Calling getBatchesforBarcode@@===");
												HashMap hmReturn	=	bean1.getBatchesforBarcode(hmParameters);
												System.err.println("hmParameters...."+hmParameters);
												System.err.println("hmReturn...."+hmReturn);
						
												alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
												System.err.println("alBatchRecords.... "+alBatchRecords);
									
												ebean.setBatchRecords(alBatchRecords);  //selected batch
												System.err.println("alBatchRecords..2.. "+ebean.getBatchRecords());
												
												
												putObjectInBean("stUtilities",bean1,request);
											}
										}
										catch(Exception ex)
										{
											ex.printStackTrace();					
										}
										if (!trn_type.equals("CON")){//Added for GHL-CRF-0413 starts
										out.println("MINMAX_CONVCALCULATE('"+allow_decimals_yn+"','"+trn_type+"')");
										}
										if(BarcodeWithMultipleBatches.equals("N")){
											if(!barcode_yn_new){//Added for GHL-CRF-0413
											out.println("editViewBatchForBarCode('"+jsp_page+"')");
											}
										}
									}				
								}
							}
							else if(!new_con_screen_yn.equals("Y")){//If Condition alone added for TH-KW-CRF-0043
								out.println("document."+formname+".bar_or_item_code.value = 'I';");
								out.println("document."+formname+".edit.disabled = 'true';");
								//out.println("document."+formname+".batchsearch.disabled = 'true';");
								out.println("document."+formname+".BARCODE_YN.value = 'TRUE';");			
								//System.err.println("@475"+site);//badma COMMENTD
								if(!barcode_yn_new || !frombarcode.equals("Y")){//Added for GHL-CRF-0413
								out.println("callItemSearchScreen()");
								}
								else{
									System.out.println("ITEM_STORE_NOT_FOUND1");
									System.err.println("ITEM_STORE_NOT_FOUND1");
									
									throw new Exception("ITEM_STORE_NOT_FOUND1");//Added for GHL-CRF-0413
								}
							}else if(new_con_screen_yn.equals("Y")){//Added for ICN-37637
								throw new Exception("ITEM_STORE_NOT_FOUND1");
							}
							result			=	true;			
					
						}
						catch(Exception e){
							//e.printStackTrace();
			
							if (e.getMessage().equals("INSUFFICIENT_BATCH_QTY")) {
								throw e;
							}
							if (e.getMessage().equals("AVAIL_BATCH_QTY_ALREADY_USED")) {
								throw e;
							}
							if (e.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
								throw e;
							}
							if (e.getMessage().equals("ITEM_STORE_NOT_FOUND1")) {//Added for GHL-CRF-0413
								throw e;
							}
							flag			=	"INVALID_BARCODE";
							result			=	false;
						}
				
					}else if(validate.equals("AFTER_BILLING_LINKED")){
		
						try
						{
							//String pjsp_page = ebean.checkForNull(request.getParameter("jsp_page")); commanded for unsed Local Variable
							String BarcodeWithMultipleBatches = ebean.checkForNull(request.getParameter("BarcodeWithMultipleBatches"),"N");
							
							if(BarcodeWithMultipleBatches.equals("N")){
								eST.Common.StUtilities bean1 = (eST.Common.StUtilities) getBeanObject("stUtilities","eST.Common.StUtilities",request);
								bean1.setLanguageId(locale);
			                    String item_2d_barcode = ebean.get2dBarcodeItems(pitem_code+"~"+pbatch_id);//Added for MMS-DM-CRF-174.6
								String barcode_2d_applicable_yn = ebean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
								System.err.println("item_2d_barcode==="+item_2d_barcode+"barcode_2d_applicable_yn=="+barcode_2d_applicable_yn);
								HashMap hmParameters	=	new HashMap();
								ArrayList alBatchRecords = new ArrayList();
								hmParameters.put("ITEM_CODE",pitem_code);
								hmParameters.put("STORE_CODE",pstore_code);
								hmParameters.put("BATCH_ID",pbatch_id);
								hmParameters.put("EXPIRY_DATE",pexpiry_date);
								//hmParameters.put("BIN_LOCATION_CODE",binlocation);
								hmParameters.put("TRN_QTY","0");
								hmParameters.put("BARCODE_2D",item_2d_barcode);//Added for MMS-DM-CRF-174.6
								hmParameters.put("BARCODE_2D_APPLICABLE_YN",barcode_2d_applicable_yn);//Added for MMS-DM-CRF-174.6
			                System.err.println("calling Barcode batches @@@607===");
								HashMap hmReturn	=	bean1.getBatchesforBarcode(hmParameters);
								alBatchRecords =(ArrayList)hmReturn.get("BATCH_DATA"); 
								ebean.setBatchRecords(alBatchRecords);  //selected batch
								putObjectInBean("stUtilities",bean1,request);
							}	
			
							result			=	true;
		
						}
						catch(Exception ex)
						{
							ex.printStackTrace();	
							flag			=	"INVALID_BARCODE1";
							result			=	false;
						}		
					}
					else if(validate.equals("ADD_TO_LIST")) {	
						try{
							HashMap hmminmaxlist=new HashMap();
				
							flag="";
						     
							System.out.println(".comm..records_to_delete..."+request.getParameter("records_to_delete"));   
							
							ebean.setRecords_to_delete_for_barcode(ebean.checkForNull((String)request.getParameter("records_to_delete")));
							//Added against GHL-CRF-0413.2-US002 starts
							String site_yn		 =ebean.checkForNull(request.getParameter("site"), "false"); 
							String trn_type_barcode = ebean.checkForNull(request.getParameter("trn_type_barcode"), "");
							String new_con_screen_yn =ebean.checkForNull(request.getParameter("new_con_screen_yn"));//Adding start for TH-KW-CRF-0043
							Hashtable tempHash    = new Hashtable();
							if(new_con_screen_yn.equals("Y")){
							  StockItemConsumptionBean conBean = (StockItemConsumptionBean) getBeanObject("stockItemConsumptionBean","eST.StockItemConsumptionBean",request);
						         tempHash =conBean.getTempHash();
								 hash =tempHash;
							}//Adding end for TH-KW-CRF-0043
			
							Boolean site_yn_new = Boolean.valueOf(site_yn);
							System.err.println("barcode_yn_new==>"+site_yn_new);
							//Added against GHL-CRF-0413.2-US002 ends
							hashmapDtl.put("item_code",			pitem_code		);
							hashmapDtl.put("stock_item_yn",		pstock_item_yn	);
							hashmapDtl.put("item_desc",			pitem_desc		);
							hashmapDtl.put("expiry_yn",			pexpiry_yn		);
							hashmapDtl.put("uom_desc",			puom_desc		);
							hashmapDtl.put("uom_code",			puom_code		);
							hashmapDtl.put("approval_no",			approval_no		);//Added for IN:071972 
				
							if(ebean.getAllowDecimalsYN( pitem_code).equals("Y")){
								hashmapDtl.put("item_qty",		ebean.setNumber(	pitem_qty,no_of_decimals)	);
							}else{
								hashmapDtl.put("item_qty",			ebean.setNumber(	pitem_qty,0));
							}
							hashmapDtl.put("item_unit_cost",	pitem_unit_cost	);
							hashmapDtl.put("item_cost_value",	pitem_cost_value	);
							hashmapDtl.put("stock_available",	pstock_available	);
							hashmapDtl.put("remarks",			premarks			);
							hashmapDtl.put("remarks_code",		premarks_code	);
							hashmapDtl.put("gross_charge_amt",	pgross_charge_amt	);
							hashmapDtl.put("pat_net_amt",		ppat_net_amt	);
							hashmapDtl.put("batch_records",		pbatch_records	);
				
							hashmapDtl.put("bl_def_override_excl_incl_ind",		pbl_def_override_excl_incl_ind	);
							hashmapDtl.put("p_overridden_excl_incl_ind",		pbl_override_excl_incl_ind	);
							hashmapDtl.put("p_overridden_action_reason",	pbl_incl_excl_override_reason_code	);
							hashmapDtl.put("bl_incl_excl_override_reason_desc",	pbl_incl_excl_override_reason_desc	);
							hashmapDtl.put("pat_paid_amt",	ppat_paid_amt	);
							hashmapDtl.put("approval_reqd_yn",	papproval_reqd_yn	);
							hashmapDtl.put("bl_override_allowed_yn",	pbl_override_allowed_yn	);
		
		
							//hashmapDtl.put("no_of_decimals",	pno_of_decimals1	);
							//hashmapDtl.put("decimal_allowedYN",	pdecimal_allowedYN1	);
				
							hashmapDtl.put("no_of_decimals",	pno_of_decimals1	);
							hashmapDtl.put("decimal_allowedYN",	(String)ebean.getAllowDecimalsYN(pitem_code));
				
				
				
							hashmapDtl.put("billable_item_yn",	pbillable_item_yn1	);
							hashmapDtl.put("sale_req_qty",	psale_req_qty	);
				
							hashmapDtl.put("doc_srl_no",		pdoc_srl_no		);
							hashmapDtl.put("store_code",		pstore_code		);
							hashmapDtl.put("expired_batch",		expired_batch	);
							hashmapDtl.put("ex_param_days",		ex_param_days	);
							hashmapDtl.put("to_conv_fact",		to_conv_fact	);
							hashmapDtl.put("frm_conv_fact",		frm_conv_fact	);
							hashmapDtl.put("frm_store_uom_desc",		frm_store_uom_desc);
							hashmapDtl.put("to_store_uom_desc",		to_store_uom_desc);
							hashmapDtl.put("kit_temp_code",	    kit_temp_code);
							hashmapDtl.put("usage_type",	    usage_type);
							hashmapDtl.put("kit_item_yn",		kit_item_yn);
							hashmapDtl.put("from_multiples",	from_multiples);
							hashmapDtl.put("to_multiples",		to_multiples);
							hashmapDtl.put("batch_multiples",	batch_multiples);
		
		
							hashmapDtl.put("issue_uom_multiples",	issue_uom_multiples);
							hashmapDtl.put("for_bin_to_store_hidden",		for_bin_to_store_hidden);
							hashmapDtl.put("issue_uom",			iss_uom_code	);
							hashmapDtl.put("issue_uom_conv",	uom_conv_code	);			
							hashmapDtl.put("iss_uom_conv_text",		iss_uom_conv_text);
							hashmapDtl.put("stock_uom_desc",		stock_uom_desc);
				
							if(ebean.getAllowDecimalsYN( pitem_code).equals("Y"))
								hashmapDtl.put("issue_uom_qty",		ebean.setNumber(	""+iss_uom_qty,no_of_decimals)	);
							else
								hashmapDtl.put("issue_uom_qty",			ebean.setNumber(	""+iss_uom_qty,0));	
							
							String store_alt_code = request.getParameter("store_alt_code");
				
							if(  !(store_alt_code == null || store_alt_code.equals("")) ){
								HashMap rol_min = new HashMap();
								try{
									rol_min = ebean.getROL1(pitem_code,store_alt_code);
								}catch(Exception e){
									e.printStackTrace();
								}
								if(!pstock_available.equals("")){
									if((Double.parseDouble(pstock_available) - Double.parseDouble(pitem_qty)) < Double.parseDouble((String)rol_min.get("REORDER_LEVEL")))
										hashmapDtl.put("ROL_YN", "Y"	);
									else
										hashmapDtl.put("ROL_YN", "N"	);
									
									if((Double.parseDouble(pstock_available) - Double.parseDouble(pitem_qty)) < Double.parseDouble((String)rol_min.get("MIN_STK_QTY")))
										hashmapDtl.put("Min_YN", "Y"	);
									else
										hashmapDtl.put("Min_YN", "N"	);
								}else{
										hashmapDtl.put("ROL_YN", "N"	);
										hashmapDtl.put("Min_YN", "N"	);
								}
							}
					
							String barcode_scanned_yn	=  ebean.checkForNull(request.getParameter("barcode_scanned_yn"),"N");//added for RUT-CRF-0079
							if(barcode_scanned_yn.equals("Y"))
								hashmapDtl.put("barcode_item_exist",	"M");
						
							//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
							String iss_item_hold_yn         =  ebean.checkForNull(request.getParameter("iss_item_hold_yn"),"Y");  
						  	String iss_item_hold_qty        =  ebean.checkForNull(request.getParameter("iss_item_hold_qty"));  
						  	String iss_item_hold_chk        =  ebean.checkForNull(request.getParameter("iss_item_hold_chk"),"N");  
						  
						    hashmapDtl.put("iss_item_hold_yn",	iss_item_hold_yn);  
							hashmapDtl.put("iss_item_hold_qty",	iss_item_hold_qty);  
							hashmapDtl.put("iss_item_hold_chk",	iss_item_hold_chk);  
							//ends
							
							boolean check = true;			
				
							ArrayList altemp =  new ArrayList();
							if (Integer.parseInt(pindex) == -1 ){
								System.err.println("ebean.getDtlRecordsforBarCode()@@@==="+ebean.getDtlRecordsforBarCode());
								if (ebean.getDtlRecordsforBarCode()!=null && ebean.getDtlRecordsforBarCode().size()>0){
						
									altemp = ebean.getDtlRecordsforBarCode();
						
									System.out.println("altemp==>"+altemp);
			
									for (int i = 0 ; i < altemp.size() ; i++){
						
										HashMap temp = (HashMap)altemp.get(i);
						
										if((temp.get("item_code")).toString().equals(pitem_code)) {
							
											hashmapDtl.put("ADD","YES");
											hashmapDtl.put("doc_srl_no",(String)temp.get("doc_srl_no"));
											hashmapDtl.put("mode",(String)temp.get("mode"));
										//	int mdoc_srl_no =  Integer.parseInt((String)temp.get("doc_srl_no"));
										//	--mdoc_srl_no;
										//Commented against GHL-CRF-0413.2-US002	
									/* float new_pat_paid_amt			= Float.parseFloat(ebean.checkForNull((String)temp.get("pat_paid_amt"),"0"))		+  Float.parseFloat(ebean.checkForNull(ppat_paid_amt,"0")) ;
									float new_pat_net_amt			= Float.parseFloat(ebean.checkForNull((String)temp.get("pat_net_amt"),"0"))		+  Float.parseFloat(ebean.checkForNull(ppat_net_amt,"0")) ;
									float new_gross_charge_amt		= Float.parseFloat(ebean.checkForNull((String)temp.get("gross_charge_amt"),"0"))  +  Float.parseFloat(ebean.checkForNull(pgross_charge_amt,"0")) ;
									float new_item_qty				= Float.parseFloat((String)temp.get("item_qty"))			+  Float.parseFloat(ebean.checkForNull(pitem_qty,"0")) ; 
									float new_item_cost_value		= Float.parseFloat(ebean.checkForNull((String)temp.get("item_cost_value"),"0"))	+  Float.parseFloat(ebean.checkForNull(pitem_cost_value,"0")) ;
									float new_iss_uom_qty=	0;
									if(temp.containsKey("issue_uom_qty"))
						 				new_iss_uom_qty			= Float.parseFloat(ebean.checkForNull((String)temp.get("issue_uom_qty"),"0"))	+ Float.parseFloat(ebean.checkForNull(iss_uom_qty,"0")) ; 
							 */			
							//Added against GHL-CRF-0413.2-US002 starts
									float new_pat_paid_amt			=0;
									float new_pat_net_amt=	0;
									float new_gross_charge_amt=	0;
									float new_item_qty=	0;
									float new_item_cost_value=	0;
									float new_iss_uom_qty=	0;
										if(site_yn_new && trn_type_barcode.equals("ISS")){
											 new_pat_paid_amt			=  Float.parseFloat(ebean.checkForNull(ppat_paid_amt,"0")) ;
											 new_pat_net_amt			=   Float.parseFloat(ebean.checkForNull(ppat_net_amt,"0")) ;
											 new_gross_charge_amt		=   Float.parseFloat(ebean.checkForNull(pgross_charge_amt,"0")) ;
											 new_item_qty				=   Float.parseFloat(ebean.checkForNull(pitem_qty,"0")) ; 
											 new_item_cost_value		= Float.parseFloat(ebean.checkForNull(pitem_cost_value,"0")) ;
											if(temp.containsKey("issue_uom_qty"))
												new_iss_uom_qty			=  Float.parseFloat(ebean.checkForNull(iss_uom_qty,"0")) ; 
										}
										else{
											 new_pat_paid_amt			= Float.parseFloat(ebean.checkForNull((String)temp.get("pat_paid_amt"),"0"))		+  Float.parseFloat(ebean.checkForNull(ppat_paid_amt,"0")) ;
											 new_pat_net_amt			= Float.parseFloat(ebean.checkForNull((String)temp.get("pat_net_amt"),"0"))		+  Float.parseFloat(ebean.checkForNull(ppat_net_amt,"0")) ;
											 new_gross_charge_amt		= Float.parseFloat(ebean.checkForNull((String)temp.get("gross_charge_amt"),"0"))  +  Float.parseFloat(ebean.checkForNull(pgross_charge_amt,"0")) ;
											 new_item_qty				= Float.parseFloat((String)temp.get("item_qty"))			+  Float.parseFloat(ebean.checkForNull(pitem_qty,"0")) ; 
											 new_item_cost_value		= Float.parseFloat(ebean.checkForNull((String)temp.get("item_cost_value"),"0"))	+  Float.parseFloat(ebean.checkForNull(pitem_cost_value,"0")) ;
											if(temp.containsKey("issue_uom_qty"))
												new_iss_uom_qty			= Float.parseFloat(ebean.checkForNull((String)temp.get("issue_uom_qty"),"0"))	+ Float.parseFloat(ebean.checkForNull(iss_uom_qty,"0")) ; 
										}
										//Added against GHL-CRF-0413.2-US002 ends
											//float new_item_qty = Float.parseFloat((String)temp.get("item_qty"));
							
											int mdoc_srl_no = i ;
											hashmapDtl.put("query_srl_no",""+i);
								
											ArrayList BatchSize  =(ArrayList)ebean.getExpRecordsforBarCode(mdoc_srl_no);
								
											System.out.println("altemp=ebean.getExpRecordsforBarCode=>"+ebean.getExpRecordsforBarCode());
								
								
											int new_batch_records = BatchSize.size();
							
											hashmapDtl.put("pat_paid_amt",	""+new_pat_paid_amt	);
											hashmapDtl.put("pat_net_amt",		""+new_pat_net_amt	);
											hashmapDtl.put("gross_charge_amt",	""+new_gross_charge_amt	);
											hashmapDtl.put("batch_records",		""+new_batch_records	);			
											if(ebean.getAllowDecimalsYN( pitem_code).equals("Y"))
												hashmapDtl.put("item_qty",		ebean.setNumber(	""+new_item_qty,no_of_decimals)	);
											else
												hashmapDtl.put("item_qty",			ebean.setNumber(	""+new_item_qty,0));
										
											hashmapDtl.put("item_cost_value",	ebean.setNumber(	""+new_item_cost_value,3)	);
							
							
										
											if(ebean.getAllowDecimalsYN( pitem_code).equals("Y"))
												hashmapDtl.put("issue_uom_qty",		ebean.setNumber(	""+new_iss_uom_qty,no_of_decimals)	);
											else
												hashmapDtl.put("issue_uom_qty",			ebean.setNumber(	""+new_iss_uom_qty,0));	
										
											if(kit_temp_code.equals(""))
												hashmapDtl.put("kit_temp_code",	ebean.checkForNull((String)temp.get("kit_temp_code")));
											
											if(usage_type.equals(""))
												hashmapDtl.put("usage_type",	ebean.checkForNull((String)temp.get("usage_type")));
										
											System.out.println("hashmapDtl===677=common===>" +hashmapDtl);
							
											ebean.updateDtlRecordforBarCode(Integer.parseInt(pindex), hashmapDtl);
											hash.put("pindex",		""+pindex	);
											if (pstock_item_yn.equals("Y")) 
												ebean.updateExpRecordsforBarCode(mdoc_srl_no, hash);
											check = false;
							
											System.out.println("getDtlRecordsforBarCode()===680=common===>" +ebean.getDtlRecordsforBarCode());
										}
									}
								}
								else{
									System.err.println("hashmapDtl=="+hashmapDtl);
									System.err.println("hash@@==="+hash);
									System.out.println("pdoc_srl_no=610=>"+pdoc_srl_no);
									System.out.println("pindex=610=>"+pindex);

									hashmapDtl.put("ADD","NO");
									hashmapDtl.put("doc_srl_no",		pdoc_srl_no		);
									hash.put("pindex",		""+pindex	);
									ebean.updateDtlRecordforBarCode(Integer.parseInt(pindex), hashmapDtl);
									if (pstock_item_yn.equals("Y")) 
										ebean.updateExpRecordsforBarCode(Integer.parseInt(pindex), hash);
									check = false;
								}
							}
					
							if(check){
								hashmapDtl.put("ADD","NO");
								hashmapDtl.put("doc_srl_no",		pdoc_srl_no		);
								hash.put("pindex",		""+pindex	);
								ebean.updateDtlRecordforBarCode(Integer.parseInt(pindex), hashmapDtl);
								if (pstock_item_yn.equals("Y")) 
									ebean.updateExpRecordsforBarCode(Integer.parseInt(pindex), hash);
							}
					
							System.out.println("hashmapDtl=709=>"+hashmapDtl);
							/*  ========= Start of Min Max Validation ===========*/
							/*System.out.println(request.getParameter("frm_store_qty_on_hand"));
							  System.out.println(request.getParameter("frm_store_min_stk_level"));
							  System.out.println(request.getParameter("frm_store_max_stk_level"));
							  System.out.println(request.getParameter("frm_store_reorder_level"));
				              System.out.println(request.getParameter("to_store_qty_on_hand"));
				              System.out.println(request.getParameter("to_store_min_stk_level"));
				              System.out.println(request.getParameter("to_store_max_stk_level"));
				              System.out.println(request.getParameter("to_store_reorder_level"));*/
							hmminmaxlist.put("frm_store_qty_on_hand",  request.getParameter("frm_store_qty_on_hand"));	
							hmminmaxlist.put("frm_store_min_stk_level",request.getParameter("frm_store_min_stk_level"));	
							hmminmaxlist.put("frm_store_max_stk_level",request.getParameter("frm_store_max_stk_level"));	
							hmminmaxlist.put("frm_store_reorder_level",request.getParameter("frm_store_reorder_level"));	
							hmminmaxlist.put("to_store_qty_on_hand",   request.getParameter("to_store_qty_on_hand"));	
							hmminmaxlist.put("to_store_min_stk_level", request.getParameter("to_store_min_stk_level"));	
							hmminmaxlist.put("to_store_max_stk_level", request.getParameter("to_store_max_stk_level"));	
							hmminmaxlist.put("to_store_reorder_level", request.getParameter("to_store_reorder_level"));	
						
							String trn = request.getParameter("trn_type");
						
							if(!(trn.equals("SAL")))
								ebean.updateMinMaxRecordsforBarcode(Integer.parseInt(pindex), hmminmaxlist);
							result			=	true;
							}
							catch(Exception ex)
							{
								result		=	false;
								System.out.println("Exception in CommonValidate.jsp...@validate = ADD_TO_LIST...");
								ex.printStackTrace();
							}
				
						}
						else if(validate.equals("setnewbatch")) 
						{
							try
							{	
								//String  pmode     =	ebean.checkForNull(request.getParameter("mode"));Commanded for Unused Local Variables
								System.out.println("pindex-------547------->"+pindex);
								ArrayList alBatchRecords = new ArrayList();
						
								BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean",request );
								alBatchRecords = bean2.getSelectedList();
					
								ArrayList OldExpRecords = new ArrayList();
								HashMap CurrBatchRecords = new HashMap();
								boolean checking = true;	
								ArrayList altemp =  new ArrayList();					
								if (ebean.getDtlRecordsforBarCode().size()>0  && Integer.parseInt(pindex) == -1  ){
									altemp = ebean.getDtlRecordsforBarCode();
									for (int m = 0 ; m < altemp.size() ; m++){
									HashMap temp = (HashMap)altemp.get(m);
									if((temp.get("item_code")).toString().equals(pitem_code)) {
									//int ndoc_srl_no = Integer.parseInt((String)temp.get("doc_srl_no"));
									//--ndoc_srl_no;
									int ndoc_srl_no = m ;
				
									OldExpRecords = ebean.getExpRecordsforBarCode(ndoc_srl_no);
				
									int OldExp = OldExpRecords.size();
									for ( int m1=0; m1 < alBatchRecords.size(); m1++ ){
									boolean isExist = false;
									CurrBatchRecords =(HashMap)alBatchRecords.get(m1) ;					
									
									for ( int m2 = 0 ; m2 < OldExp ; m2++){
									HashMap exp = (HashMap)OldExpRecords.get(m2);				
									if (( CurrBatchRecords.get("ITEM_CODE").equals(exp.get("ITEM_CODE")) &&  CurrBatchRecords.get("BATCH_ID").equals(exp.get("BATCH_ID")) &&  CurrBatchRecords.get("EXPIRY_DATE").equals(exp.get("EXPIRY_DATE"))	&& 	CurrBatchRecords.get("BIN_LOCATION_CODE").equals(exp.get("BIN_LOCATION_CODE")) &&  CurrBatchRecords.get("TRADE_ID").equals(exp.get("TRADE_ID")))){
									isExist = true;
									}					
									}
									if (!isExist){
									OldExpRecords.add(CurrBatchRecords);
									}
									}
				
									ebean.setExpRecordsforBarCode( ndoc_srl_no, OldExpRecords);
									checking = false;
									}
									}
									if (checking){
									ebean.setExpRecordsforBarCode( Integer.parseInt(pindex), alBatchRecords);
									}
								}
								else{
										ebean.setExpRecordsforBarCode( Integer.parseInt(pindex), alBatchRecords);
								}
								result =  true;
							}
							catch (Exception exception) 
							{
									result		=	false;
									message		=	exception.getMessage();
									System.out.println("Exception in CommonValidate.jsp ..validate=setnewbatch...");
									exception.printStackTrace();
							}
						}
						else if(validate.equals("addnewbatch")) 
						{
							try
							{	
								ArrayList alBatchRecords = new ArrayList();
				
								String AddBatchRecords = ebean.checkForNull(request.getParameter("AddBatchRecords"),"N");
								
								if(AddBatchRecords.equals("Y")){
								alBatchRecords = ebean.getAddBatchRecords();
								}
								else{
								BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean",request );
								alBatchRecords = bean2.getSelectedList();
								}
				
								ArrayList OldExpRecords = new ArrayList();
								HashMap CurrBatchRecords = new HashMap();
								boolean checking = true;	
								ArrayList altemp =  new ArrayList();
								if (ebean.getDtlRecordsforBarCode().size()>0){
									altemp = ebean.getDtlRecordsforBarCode();
									for (int m = 0 ; m < altemp.size() ; m++){
									HashMap temp = (HashMap)altemp.get(m);
				
									if((temp.get("item_code")).toString().equals(pitem_code)) {
									//int ndoc_srl_no = Integer.parseInt((String)temp.get("doc_srl_no"));
									//--ndoc_srl_no;
									int ndoc_srl_no = m ;
				
									OldExpRecords = ebean.getExpRecordsforBarCode(ndoc_srl_no);
				
									int OldExp = OldExpRecords.size();
									for ( int m1=0; m1 < alBatchRecords.size(); m1++ ){
									boolean isExist = false;
									CurrBatchRecords =(HashMap)alBatchRecords.get(m1) ;					
									
									for ( int m2 = 0 ; m2 < OldExp ; m2++){
									HashMap exp = (HashMap)OldExpRecords.get(m2);
								
									if (( CurrBatchRecords.get("ITEM_CODE").equals(exp.get("ITEM_CODE")) &&  CurrBatchRecords.get("BATCH_ID").equals(exp.get("BATCH_ID")) &&  CurrBatchRecords.get("EXPIRY_DATE").equals(exp.get("EXPIRY_DATE"))	&& 	CurrBatchRecords.get("BIN_LOCATION_CODE").equals(exp.get("BIN_LOCATION_CODE")) &&  CurrBatchRecords.get("TRADE_ID").equals(exp.get("TRADE_ID")))){
									isExist = true;
				
									if(AddBatchRecords.equals("Y")){
									double tot_trans_qty = Double.parseDouble((String)exp.get("QTY")) + Double.parseDouble((String)CurrBatchRecords.get("QTY")) ;
									exp.put("QTY",""+tot_trans_qty);
									}
									}					
									}
									if (!isExist){
									OldExpRecords.add(CurrBatchRecords);
									}
									}
				
									ebean.setExpRecordsforBarCode( ndoc_srl_no, OldExpRecords);
									checking = false;
									}
									}
									if (checking){
									ebean.setExpRecordsforBarCode( Integer.parseInt(pindex), alBatchRecords);
									}
								}
								else{
										ebean.setExpRecordsforBarCode( Integer.parseInt(pindex), alBatchRecords);
								}
								result =  true;
							}
							catch (Exception exception) 
							{
									result		=	false;
									message		=	exception.getMessage();
									System.out.println("Exception in CommonValidate.jsp ..validate=addnewbatch...");
									exception.printStackTrace();
							}
						}
						else if(validate.equals("BARCODE_APPL")) 
						{
							try
							{	
								//String	barcode_applicable = "N";commanded for  Unused Local Variable
								String	trn_type     =	ebean.checkForNull(request.getParameter("trn_type"));
								String  facility_id  =  ebean.checkForNull(ebean.getLoginFacilityId());
								String  _formname     =	ebean.checkForNull(request.getParameter("formObj"));
								boolean barcode_yn     =  (Boolean)ebean.isBarCodeApplicable(facility_id,trn_type);
								boolean defaultqty_yn     =  (Boolean)ebean.isBarCodeDefaultQtyApplicable(facility_id,trn_type);
								boolean editqty_yn     =  (Boolean)ebean.isBarCodeEditQtyApplicable(facility_id,trn_type);
			
								System.out.println("barcode_yn==>"+barcode_yn);
								System.out.println("defaultqty_yn==>"+defaultqty_yn);
								System.out.println("editqty_yn==>"+editqty_yn);
			
								if(barcode_yn){
								out.println("document."+_formname+".barcode_applicable1.value = 'Y';");				
								ebean.setBarcodeApplicable("Y");
								}else{
								out.println("document."+_formname+".barcode_applicable1.value = 'N';");
								ebean.setBarcodeApplicable("N");
								}
								if(defaultqty_yn){
								out.println("document."+_formname+".defaultqty_appl1.value = 'Y';");
								out.println("document."+_formname+".defaultqty_value1.value = '1';");				
								ebean.setBarcodeDefaultQtyAppl("Y");
								}else{
								out.println("document."+_formname+".defaultqty_appl1.value = 'N';");
								out.println("document."+_formname+".defaultqty_value1.value = '';");					
								ebean.setBarcodeDefaultQtyAppl("N");
								}
			
								if(editqty_yn){
								out.println("document."+_formname+".editqty_appl1.value = 'Y';");
								ebean.setBarcodeEditQtyAppl("Y");
								}else{
								out.println("document."+_formname+".editqty_appl1.value = 'N';");
								ebean.setBarcodeEditQtyAppl("N");
								}
				
								if(barcode_yn)
								result =  true;					
								else
								result =  false;
							
							}
							catch (Exception exception) 
							{
									result		=	false;
									message		=	exception.getMessage();
									System.out.println("Exception in CommonValidate.jsp ..validate=BARCODE_APPL...");
									exception.printStackTrace();
							}
						}
						else if(validate.equals("SETDETAILS_SRT")) 
						{
							try{
								System.out.println("SETDETAILS_SRT");
								String bar_code = request.getParameter("bar_code");
								String formObj  =	ebean.checkForNull(request.getParameter("formObj"));
								System.out.println("bar_code=============943==>"+bar_code);
								System.out.println("pstore_code=============944==>"+pstore_code);
						
								//ArrayList alBarCodeListDetails  = ebean.getBarCodeBatchDetailArrayList(locale,bar_code);
								ArrayList alBarCodeListDetails  = ebean.getBarCodeBatchDtlForSalesReturn(locale,bar_code,pstore_code);
							
								if (alBarCodeListDetails.size() > 0){
								if (alBarCodeListDetails.size() < 2){			
								HashMap alHash = (HashMap)alBarCodeListDetails.get(0);
						
								out.println("document."+formObj+".item_code.value = '"+(String)alHash.get("ITEM_CODE")+"';");
								out.println("document."+formObj+".batch_id.value = '"+(String)alHash.get("BATCH_ID")+"';");
								out.println("document."+formObj+".expiry_date.value = '"+(String)alHash.get("EXPIRY_DATE")+"';");
								out.println("document."+formObj+".trade_id.value = '"+(String)alHash.get("TRADE_ID")+"';");
								out.println("document."+formObj+".item_desc.value = '"+(String)alHash.get("SHORT_DESC")+"';");		
								out.println("document."+formObj+".binlocation.value = '"+(String)alHash.get("BIN_LOCATION_CODE")+"';");
								
								result = true;
								}else{
									throw new Exception("BARCODE_WITH_MORE_ITEMS");
								}
								}else{
									out.println("searchItemCode(document."+formObj+".item_desc)");
								}
							}catch(Exception exception) {
								result		=	false;
								message		=	exception.getMessage();
								System.out.println("Exception in CommonValidate.jsp ..validate=SETDETAILS_SRT...");
								exception.printStackTrace();
								if (exception.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
								}
							}
						}
						else if(validate.equals("SETDETAILS_RET")) 
						{
								
							try{
								System.out.println("SETDETAILS_RET");
								String bar_code = request.getParameter("bar_code");
								String formObj  =	ebean.checkForNull(request.getParameter("formObj"));
								System.out.println("bar_code=============980==>"+bar_code);
								//ArrayList alBarCodeListDetails  = ebean.getBarCodeBatchDetailArrayList(locale,bar_code);
								ArrayList alBarCodeListDetails  = ebean.getBarCodeBatchDtlForIssueReturn(locale,bar_code,pstore_code);
		
								if (alBarCodeListDetails.size() > 0){
						
									if (alBarCodeListDetails.size() < 2){
									
										System.out.println("alBarCodeListDetails=============987==>"+alBarCodeListDetails.size());
								
										HashMap alHash = (HashMap)alBarCodeListDetails.get(0);
										System.out.println("alBarCodeListDetails=======alHash=====1000==>"+alHash);
										out.println("document."+formObj+".item_code.value = '"+(String)alHash.get("ITEM_CODE")+"';");
										out.println("document."+formObj+".batch_id.value = '"+(String)alHash.get("BATCH_ID")+"';");
										out.println("document."+formObj+".expiry_date.value = '"+(String)alHash.get("EXPIRY_DATE")+"';");
										out.println("document."+formObj+".trade_id.value = '"+(String)alHash.get("TRADE_ID")+"';");
										out.println("document."+formObj+".item_desc.value = '"+(String)alHash.get("SHORT_DESC")+"';");		
										out.println("document."+formObj+".binlocation.value = '"+(String)alHash.get("BIN_LOCATION_CODE")+"';");	
								
										
										result = true;
									}else{
										throw new Exception("BARCODE_WITH_MORE_ITEMS");
									}
						
								}else{
									out.println("callItemSearchScreen(document."+formObj+".item_desc)");
								}
							}catch(Exception exception) {
								result		=	false;
								message		=	exception.getMessage();
								System.out.println("Exception in CommonValidate.jsp ..validate=SETDETAILS_RET...");
								exception.printStackTrace();
								if (exception.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
								}
							}
						}
						else if (validate.equals("BARCODE_ADJ")) {	
				
							//String	trn_type     =	ebean.checkForNull(request.getParameter("trn_type")); commanded for Unused Local Variable
							String  facility_id  =  ebean.checkForNull(ebean.getLoginFacilityId());
							String  formname     =	ebean.checkForNull(request.getParameter("formObj"));
							String  bar_code = ebean.checkForNull(request.getParameter("bar_code"));
							//String jsp_page = ebean.checkForNull(request.getParameter("jsp_page"));commanded for Unused Local Variable
							//String allow_decimals_yn=""; commanded for Unused Local Variable
							String  mode     =	ebean.checkForNull(request.getParameter("mode"));
				
							HashMap alTemp	=	new HashMap();
							try {
						
								ArrayList alBarCodeListDetails = ebean.getBarCodeDetailArrayList(bar_code,pstore_code);
		
								if (alBarCodeListDetails.size() > 0 ){	
									 if(alBarCodeListDetails.size() > 1 ){
										HashMap prev_records = new HashMap();
										String itemcode2 = "";
										for (int t=0;t<alBarCodeListDetails.size();t++){
											HashMap record	=	(HashMap)alBarCodeListDetails.get(t);
											String itemcode1 = (String)record.get("ITEM_CODE");
											if(prev_records.size()>0){
												if (!itemcode1.equals(itemcode2)){
												throw new Exception("BARCODE_WITH_MORE_ITEMS");
												}
											}
											prev_records = record;
											itemcode2 = (String)prev_records.get("ITEM_CODE");
										}
									}
		
									for(int i=0; i<1; i++) {
										//this is to handle multiple batch, select 1st avail_qty>0
										for(int t1=0; t1<alBarCodeListDetails.size();) {
											
											HashMap temp_record	=	(HashMap)alBarCodeListDetails.get(t1);
											System.out.println("temp_record==>"+temp_record);
											int temp_availqty		=	Integer.parseInt((String)temp_record.get("AVAIL_QTY"));
											
											if(temp_availqty<=0){
												t1++;
											}
											else{
												i = t1;
												break;
											}
										}
				
										 HashMap record	=	(HashMap)alBarCodeListDetails.get(i);
						
										 String itemcode	=	(String)record.get("ITEM_CODE");
										 String batchid	    =	(String)record.get("BATCH_ID");
										 String expirydate	=	(String)record.get("EXPIRY_DATE");
										 String binlocation	=	(String)record.get("BIN_LOCATION_CODE");
										 String tradeid     =	(String)record.get("TRADE_ID");
							 
				
							 			int availqty		=	Integer.parseInt((String)record.get("AVAIL_QTY"));
				
										if(availqty<=0 )				 
											 throw new Exception("INSUFFICIENT_BATCH_QTY");
										else{	
							
											//to get the item details
											ArrayList alItemDetails = ebean.getItemDetailArrayList(locale,itemcode,pstore_code);
							
											alTemp = (HashMap)alItemDetails.get(0);
							
											String item_code  = (String)alTemp.get("ITEM_CODE") ;
											String item_desc  = (String)alTemp.get("ITEM_DESC") ;
											String expiry_yn  = (String)alTemp.get("EXPIRY_YN") ;
											String uom_code   = (String)alTemp.get("GEN_UOM_CODE") ;
											//String uom_desc   = (String)alTemp.get("GEN_UOM_DESC") ;	commanded for Unused Local Variable
											//String def_issue_uom_code   = (String)alTemp.get("DEF_ISSUE_UOM") ; commanded for Unused Local Variable
											String def_issue_uom_desc   = (String)alTemp.get("DEF_ISSUE_UOM_DESC") ;
											String batch_id_appl_yn		= (String)alTemp.get("BATCH_ID_APPLICABLE_YN") ;
											String trade_id_appl_yn   = (String)alTemp.get("TRADE_ID_APPLICABLE_YN") ;
											String manufacturer_id   = ebean.checkForNull((String)alTemp.get("MANUFACTURER_ID")) ;
							
											String supplier_id = ebean.checkForNull((String)ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE_RULE"),new String[]{itemcode,batchid,expirydate}).get("SUPP_CODE"));
											String mrp     =  ebean.checkForNull((String)ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",itemcode,tradeid,batchid}).get("MRP_PRICE"));
							
											if(mrp.startsWith("Error"))
												mrp="";
				
				
											String[] stParameters = {itemcode, pstore_code, "0", "N", "", "N", "" };
											String phy_inv_id = "";
											try { 
							
												result = ebean.isPhysicalInventoryProcessStartedForStore(itemcode,pstore_code,"");
												if(result){
													phy_inv_id=(String)ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,pstore_code}).get("PHY_INV_ID");
														out.println("document."+formname+".phy_inv_id.value = '"+ebean.checkForNull(phy_inv_id,"")+"';");
														throw new Exception("PHY_INV_PROCESS_INITIATED");
												}
				
				
												HashMap hmStockAvailabilityStatus = ebean.getStockAvailabilityStatus(stParameters);
								
												 String stock_item_yn =(String)hmStockAvailabilityStatus.get("stock_item_yn");
								
												 if(stock_item_yn.equals("N")) {
													throw new Exception("NOT_STOCK_ITEM");
												 }
								
												double tmp_conv=ebean.getConvFactTemp(itemcode,pstore_code);
								
												out.println("document."+formname+".tmp_conv.value = '"+tmp_conv+"';");
								
												int noOfDecimalsForCost=Integer.parseInt(ebean.getNoOfDecimalsCost());
								
												double storeItemUnitCost=Double.parseDouble((String)ebean.getUnitCost(itemcode,pstore_code));
												double item_unit_cost=Double.parseDouble((String)hmStockAvailabilityStatus.get("item_unit_cost"));				
												
												out.println("document."+formname+".item_store_unit_cost_1.value = '"+storeItemUnitCost+"';");
				
												if(storeItemUnitCost==0){
													if(item_unit_cost!=0)
													{
														out.println( "document."+formname+".item_last_unit_cost.value='"+item_unit_cost+"'");
														storeItemUnitCost=item_unit_cost;
													}
													else
													{
														String item_last_cost=ebean.setNumber(ebean.checkForNull(ebean.getLastCostforBarcode(item_code),"0"),noOfDecimalsForCost);
														out.println( "document.item_last_unit_cost.value='"+item_last_cost+"'");
														storeItemUnitCost=Double.parseDouble(item_last_cost);
													}
												}
							
												double avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")));  
								
												out.println(" populateUnitCost("+ storeItemUnitCost + ",\'"+avail_stock + "',\""+ mode + "\" ) ; ") ;
												
												String[]  minmaxarg = {""+ebean.getConvFactTemp(itemcode,pstore_code),itemcode, pstore_code};
												HashMap hmminmax = new HashMap();
												hmminmax =	ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);
												out.println("document.getElementById('min_stk_qty_label').innerHTML = '<B>"+ebean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"&nbsp;")+"</B>'");
												out.println("document.getElementById('max_stk_qty_label').innerHTML = '<B>"+ebean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"&nbsp;")+"</B>'");
												out.println("document.getElementById('min_stk_qty').value = '"+ebean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"")+"';");
												out.println("document.getElementById('max_stk_qty').value = '"+ebean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"")+"';");
												out.println("document."+formname+".item_code.value = '"+item_code+"';");
												out.println("document."+formname+".item_desc.value = '"+item_desc+"';");
												out.println("document."+formname+".item_desc.disabled = true;");
												out.println("document."+formname+".item_search.disabled = true;");				
												out.println("document."+formname+".expiry_yn.value = '"+expiry_yn+"';");				
												out.println("document."+formname+".uom_code.value = '"+uom_code+"';");							
												out.println("document."+formname+".trade_id_applicable_yn.value = '"+trade_id_appl_yn+"';");				
												out.println("document."+formname+".batch_id_applicable_yn.value = '"+batch_id_appl_yn+"';");
												out.println("document."+formname+".uom.value = '"+def_issue_uom_desc+"';");	
						
												out.println("document."+formname+".bar_or_item_code.value = 'B';");
												out.println("document."+formname+".batchSearch.disabled = true;");
								
												String NewBarcodeString  = ebean.getNewBarCode(facility_id,pstore_code,itemcode,batchid,expirydate,tradeid,binlocation,manufacturer_id,supplier_id,mrp);
												//item_desc= java.net.URLEncoder.encode(item_desc,"UTF-8");
												//def_issue_uom_desc= java.net.URLEncoder.encode(def_issue_uom_desc,"UTF-8");
								
												out.println("editViewForBarCode('"+mode+"','"+item_desc+"','"+item_code+"','"+expiry_yn+"','"+uom_code+"','"+def_issue_uom_desc+"','"+batch_id_appl_yn+"','"+trade_id_appl_yn+"','"+batchid+"','"+expirydate+"','"+binlocation+"','"+tradeid+"','"+NewBarcodeString+"','"+manufacturer_id+"','"+supplier_id+"','"+mrp+"')");
								
											}
				
											catch (Exception exception) {
												result		=	false;
												message		=	exception.getMessage();		
												exception.printStackTrace();	
								
												if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
													throw exception;
												}
												if (exception.getMessage().equals("STOCK_NOT_AVAILABLE")) {
													throw exception;
												}
												if (exception.getMessage().equals("NOT_STOCK_ITEM")) {
													throw exception;
												}
												if (exception.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
													throw exception;
												}
												
												
												throw new Exception("ITEM_STORE_NOT_FOUND");
												
											}				
										}
							
										message = itemcode+";"+batchid+";"+expirydate;
										System.out.println("message.... "+message);		
														
									}
								}
								else{
									out.println("document."+formname+".bar_or_item_code.value = 'I';");
									//out.println("document."+formname+".batchSearch.disabled = 'true';");
									out.println("document."+formname+".BARCODE_YN.value = 'TRUE';");			
									out.println("callItemSearchScreen()");
								}		
								result			=	true;			
					
							}
							catch(Exception e){
								if (e.getMessage().equals("INSUFFICIENT_BATCH_QTY")) {
									throw e;
								}
								if (e.getMessage().equals("AVAIL_BATCH_QTY_ALREADY_USED")) {
									throw e;
								}
								if (e.getMessage().equals("BARCODE_WITH_MORE_ITEMS")) {
									throw e;
								}
								
								flag			=	"INVALID_BARCODE";
								result			=	false;
							}
				
						}
						else if(validate.equals("NEW_BARCODE_STRING")) 
						{
							try{
								System.out.println("NEW_BARCODE_STRING");
								String BarcodeRule = ebean.checkForNull(request.getParameter("BarcodeRule"),"M");
								String facility_id = ebean.checkForNull(request.getParameter("facility_id"),"");
								String trn_type	   = ebean.checkForNull(request.getParameter("trn_type"),"");
					
								String NewBarcodeString = "";
								
								boolean barcode_yn     =  (Boolean)ebean.isBarCodeApplicable(facility_id,trn_type);
								
								System.out.println("barcode_yn==========1255========>"+barcode_yn);
								if(barcode_yn){
									if(BarcodeRule.equals("P")){							
										String store_code = ebean.checkForNull(request.getParameter("store_code"),"");
										String item_code = ebean.checkForNull(request.getParameter("item_code"),"");
										String batch_id = ebean.checkForNull(request.getParameter("batch_id"),"");
										String Expiry_date = ebean.checkForNull(request.getParameter("Expiry_date"),"");
										String trade_id = ebean.checkForNull(request.getParameter("trade_id"),"");
										String binlocn_code = ebean.checkForNull(request.getParameter("binlocn_code"),"");
										String manufacturer_id = ebean.checkForNull(request.getParameter("manufacturer_id"),"");
										String supplier_id = ebean.checkForNull(request.getParameter("supplier_id"),"");
										String mrp = ebean.checkForNull(request.getParameter("mrp"),"");
										//boolean isexists = false;
										//isexists = ebean.isBatchExistInSTItemBatch(item_code,store_code,batch_id,binlocn_code,Expiry_date);
										//if(!isexists)
							
										 Expiry_date = Expiry_date.replaceAll("/","");
					
										 if(supplier_id.equals(""))
										 supplier_id = ebean.checkForNull((String)ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE_RULE"),new String[]{item_code,batch_id,Expiry_date}).get("SUPP_CODE"));
							 			 if(mrp.equals(""))
										 mrp     =  ebean.checkForNull((String)ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",item_code,trade_id,batch_id}).get("MRP_PRICE"));
										
										 if(mrp.startsWith("Error"))
										  mrp="";
							
										 NewBarcodeString  = ebean.getNewBarCode(facility_id,store_code,item_code,batch_id,Expiry_date,trade_id,binlocn_code,manufacturer_id,supplier_id,mrp);		
										
									}else if(BarcodeRule.equals("S")){			
										NewBarcodeString     =  ebean.checkForNull((String)ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_SELECT_BARCODE_SEQUENCE")).get("NEWBARCODE"));
									}
								}
								message		= NewBarcodeString;
								result		=	true;
					
								System.out.println("NewBarcodeString===1292===>"+NewBarcodeString);
				
							}catch(Exception exception) {
								result		=	false;
								message		=	exception.getMessage();
								System.out.println("Exception in CommonValidate.jsp ..validate=NEW_BARCODE_STRING...");
								exception.printStackTrace();
								
							}
						}	
					//Added for GHL-CRF-0413 starts
						else if(validate.equals("BATCH_EXP_DETAILS"))  { 
							System.err.println("BATCH_EXP_DETAILS starts");
							String valid_barcode = request.getParameter("barcode");
							try{
					       ArrayList barcodes = new ArrayList();
					       barcodes = ebean.getAlBarcodeExp();
					      if( barcodes.contains(valid_barcode))
					    	  result = true;
					      else
					    	  result = false;
							}
							catch(Exception exception){
								exception.printStackTrace();
								flag			=	"BATCH_EXP_DETAILS";
								result			=	false;
							}
					    }  	
						else if(validate.equals("ITEM_QTY_INCREMENT"))  { 
							System.err.println("ITEM_QTY_INCREMENT starts");
							String barcode_qty = request.getParameter("barcode");
							 try{
								 for(int m=0;m<ebean.getAlBarcodeExp().size();m++){
								 	if(ebean.getAlBarcodeExp().get(m).equals((String)barcode_qty))
								 		{
								 		message = ""+m ;
								 		result = true;
								 		}
								 	}
							 }
							 catch(Exception exception){
								exception.printStackTrace();
								flag			=	"ITEM_QTY_INCREMENT";
								result			=	false;
								}
						}
						else if(validate.equals("BARCODECHECK_SAMEITEM"))  { 
							System.err.println("BARCODECHECK_SAMEITEM starts");
							String newBarcode = request.getParameter("barcode");
							String init_store_code = request.getParameter("store_code");
							String barcode_2d_applicable_yn = ebean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
							   ArrayList oldItemCode = new ArrayList();
							   try{
							   oldItemCode = ebean.getAlItemcodeExp();
							   System.out.println("oldItemCode-->"+oldItemCode);
							   String newItemCode = "";
							   if(barcode_2d_applicable_yn.equals("Y")){ //Adding start for MMS-DM-CRF-0174.6
								   newItemCode = ebean.get2DBarcodeItem(init_store_code,newBarcode);
							   }else{
							   newItemCode=ebean.checkForNull((String)	ebean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{newBarcode,init_store_code}).get("ITEM_CODE"),"");
							   }
							   System.out.println("newItemCode-->"+newItemCode);
							   if( oldItemCode.contains(newItemCode))
							   	   result = true;
							   else
							       result = false;
							   }
							   catch(Exception exception){
									exception.printStackTrace();
									flag			=	"BARCODECHECK_SAMEITEM";
									result			=	false;
								}
						}
						else if(validate.equals("SUSPENDED_YN"))  { 
							System.err.println("SUSPENDED_YN starts");
							String suspend_bar_code = request.getParameter("barcode");
							String from_store = request.getParameter("store_code");
							
							String barcode_2d_applicable_yn = ebean.barcode2DApplicable();//Added for MOHE-CRF-0167
							ArrayList  alBarCodeList =new ArrayList();
							   try{
							 if(barcode_2d_applicable_yn.equals("Y")){//Added for MOHE-CRF-0167 
								    alBarCodeList = ebean.get2DBarcodeBacthes(from_store,suspend_bar_code);
							   } else{
								   alBarCodeList = ebean.getBarCodeDetailArrayList(suspend_bar_code,from_store);
							   }
									 System.out.println("alBarCodeList val" +alBarCodeList); 
									String user_id = ebean.getLoginById();
									 System.out.println("user_id--->   "+user_id);
									 String PROCESS_SUSPENDED_ITEMS_YN = ((String)	ebean.fetchRecord("SELECT PROCESS_SUSPENDED_ITEMS_YN FROM ST_USER_ACCESS_for_STORE WHERE USER_ID = ? AND STORE_CODE = ?",new String[]{user_id,from_store}).get("PROCESS_SUSPENDED_ITEMS_YN"));
									 System.out.println("PROCESS_SUSPENDED_ITEMS_YN--->   "+PROCESS_SUSPENDED_ITEMS_YN);
									 result			=	true;
									 HashMap record_suspend	=	(HashMap)alBarCodeList.get(0); 
										 if(PROCESS_SUSPENDED_ITEMS_YN.equals("N"))	{
											String suspend_yn = (String)record_suspend.get("SUSPENDED_YN");
											System.out.println("SUSPENDED_YN--->   "+suspend_yn);
											if(suspend_yn.equals("Y")){
												throw new Exception("SUSPENDED_BATCH");
											}
										} 
										 BatchSearchBeanForBarcode expiryBean				=		(BatchSearchBeanForBarcode) getBeanObject( "batchSearchBeanForBarcode","eST.BatchSearchBeanForBarcode",request );
										String expiry_date_check  =		(String)record_suspend.get("EXPIRY_DATE");
										String item_code_expiry = (String)record_suspend.get("ITEM_CODE");
									 String 	USE_AFTER_EXPIRY_YN = expiryBean.getUseAfterExpiry(item_code_expiry);
											 //((String) bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_EXPIRED_OR_NOT"), item_code_expiry).get("USE_AFTER_EXPIRY_YN"));
									 String PROCESS_EXPIRED_ITEMS_YN = ((String)	ebean.fetchRecord(ebean.getStRepositoryValue("SQL_ST_BATCH_EXPIRED_USER_ACCESS"),new String[]{from_store,user_id}).get("PROCESS_EXPIRED_ITEMS_YN"));
									 System.out.println("PROCESS_EXPIRED_ITEMS_YN--->   "+PROCESS_EXPIRED_ITEMS_YN);
									 System.out.println("USE_AFTER_EXPIRY_YN--->   "+USE_AFTER_EXPIRY_YN);
									 System.out.println("expiry_date--->   "+expiryBean.isGreaterThanSysdate(expiry_date_check));
									 if(!expiryBean.isGreaterThanSysdate(expiry_date_check)) 
									 {
										 if(PROCESS_EXPIRED_ITEMS_YN.equals("N") || USE_AFTER_EXPIRY_YN.equals("N")){
										 System.out.println("EXPIRED_BATCH----->532");
										 throw new Exception("EXPIRED_BATCH");
									 	}
									 }
									 putObjectInBean("batchSearchBeanForBarcode",expiryBean,request);	 
							}
							   catch(Exception exception){
									exception.printStackTrace();
									message	=	exception.getMessage();
									flag			=	message;
									result			=	false;
								}
						}
						else if(validate.equals("BarcodeWithMultipleBatches_yn"))  { 
							System.err.println("BarcodeWithMultipleBatches_yn starts");
							String BarcodeWithMultipleBatches_yn = request.getParameter("BarcodeWithMultipleBatches_yn");
							 try{
								 if(BarcodeWithMultipleBatches_yn.equals("N"))
									 result =true;
								 else
									 result = false;
							   }
							   catch(Exception exception){
									exception.printStackTrace();
									flag			=	"BarcodeWithMultipleBatches_yn";
									result			=	false;
								}
						}
						else if(validate.equals("VALID_BARCODE"))  { 
							System.err.println("VALID_BARCODE starts");
							String valid_barcode = request.getParameter("barcode");
							String valid_store_code = request.getParameter("store_code");
							String barcode_2d_applicable_yn = ebean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
							String newItemCode = "";//Moved here from down for MMS-DM-CRF-0174.6
							
							//String from_store = request.getParameter("store_code"); commanded for Unused Local Variable
							//String to_Store=request.getParameter("toStore"); commanded for Unused Local Variable
							int barcodeExists = 0;
							if(barcode_2d_applicable_yn.equals("Y")){//Adding start for MMS-DM-CRF-0174.6
									   newItemCode = ebean.get2DBarcodeItem(valid_store_code,valid_barcode);
									   System.err.println("newItemCode for 2DBarcode===="+newItemCode);
									   if(newItemCode !=null && !newItemCode.equals("")){
										   barcodeExists =1;
										   
									   }
						  }else{//Adding end for MMS-DM-CRF-0174.6
						    	barcodeExists=Integer.parseInt((String)	ebean.fetchRecord("select count(*) COUNT from ST_BATCH_CONTROL where barcode_id = ?",new String[]{valid_barcode}).get("COUNT"));
						  }
				 			//Added for GHL-CRF-0456 starts
							//String valid_trn_type = request.getParameter("trntype");
							String valid_trn_type =  ebean.checkForNull(request.getParameter("trntype"));
							//String newItemCode = "";
							if(!valid_trn_type.equals("")){// added if condition for GHL-CRF-413.7
							if(barcode_2d_applicable_yn.equals("N")){//Adding start for MMS-DM-CRF-0174.6
							newItemCode=ebean.checkForNull((String)	ebean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code}).get("ITEM_CODE"),"");
							}
						  	HashMap barcodeverify = ebean.fetchRecord("SELECT SALES_ALLOWED_YN , CONSUMPTION_ALLOWED_YN FROM ST_ITEM_STORE WHERE ITEM_CODE = ? AND STORE_CODE = ?", new String[]{newItemCode,valid_store_code});
				 		 	String sales_allowed_yn = ebean.checkForNull((String)barcodeverify.get("SALES_ALLOWED_YN"));
					 		String cons_allowed_yn = ebean.checkForNull((String)barcodeverify.get("CONSUMPTION_ALLOWED_YN"));
				 		  	if( barcodeExists != 0){
						   	 	 if(valid_trn_type.equals("SAL") && !sales_allowed_yn.equals("N"))
						   	 		result = true;
						   	 	 else if(valid_trn_type.equals("CON") && !cons_allowed_yn.equals("N"))
					   	 			result = true;
						   	 	 else if(!valid_trn_type.equals("CON") && !valid_trn_type.equals("SAL") )
						   	 		result = true;
				 		    	}
				 			//Added for GHL-CRF-0456 ends
							else
						   	  result = false;
							} else if(barcodeExists!=0)// added if-else condition for GHL-CRF-413.7
								result = true;
								else
								result = false;
								
							
						}
						//Added against GHL-CRF-0413.2-US002 starts
						else if(validate.equals("VALIDATE_ISS"))  { 
							System.err.println("VALIDATE_ISS starts");
							String valid_barcode = request.getParameter("barcode");
							String valid_trn_type = request.getParameter("trntype");
							String valid_store_code = request.getParameter("store_code");
							result = false;
							String barcode_2d_applicable_yn = ebean.barcode2DApplicable();
							int item_store_exists = 0;//Moved here from down for MMS-DM-CRF-0174.6
						    String newItemCode = "";//Moved here from down for MMS-DM-CRF-0174.6
							
							
							System.out.println("@1483 inside if"+valid_trn_type);
							try{
								if(valid_trn_type.equals("ISS")){
									int barcodeExists = 0;
									
								  if(barcode_2d_applicable_yn.equals("Y")){//Adding start for MMS-DM-CRF-0174.6
									   newItemCode = ebean.get2DBarcodeItem(valid_store_code,valid_barcode);
									   System.err.println("newItemCode for 2DBarcode===="+newItemCode);
									   if(newItemCode !=null && !newItemCode.equals("")){
										   barcodeExists =1;
										   item_store_exists =1;
									   }
								  }else{//Adding end for MMS-DM-CRF-0174.6
								    	barcodeExists=Integer.parseInt((String)	ebean.fetchRecord("select count(*) COUNT from ST_BATCH_CONTROL where barcode_id = ?",new String[]{valid_barcode}).get("COUNT"));
									}
						 		    if( barcodeExists != 0)
						 		    {
									System.out.println("bean dtl"+ebean.getDtlRecordsforBarCode());
									ArrayList alDtlBarcode = ebean.getDtlRecordsforBarCode();
									
									String authorized_item_qty = "";
									String authorized_qty1="";// added for GHL-CRF-0465
									if(barcode_2d_applicable_yn.equals("N")){//Added if Considtion alone for MMS-DM-CRF-0174.6
									   newItemCode=ebean.checkForNull((String)	ebean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code}).get("ITEM_CODE"),"");
									   System.out.println("newItemCode-->"+newItemCode);
									
									item_store_exists=Integer.parseInt((String)	ebean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? and item_code =? and eff_status = 'E'",new String[]{valid_store_code,newItemCode}).get("COUNT"));
									}
									 if(item_store_exists>0){ 
									  for(int a=0;a< alDtlBarcode.size();a++){
										  System.out.println("bean dtl 1488"+alDtlBarcode.get(a));
										  //{to_multiples=1, includeSuspendedBatches=Y, print_label_yn=N, authorized_item_qty=3, item_desc=Acarbose 100mg tablet, remarks=, mode=2, batch_multiples=1, store_code=RPIPPH, stock_item_yn=Y, item_code=PCT5747, stock_available=8629.0, item_qty=3, uom_desc=Tablets, item_cost_value=13.08, iss_uom_conv_text=1 Tablets = 1 Tablets, issue_uom_qty=3, remarks_code=, iss_item_hold_chk=N, ret_item_qty=0, doc_srl_no=1, issue_uom_multiples=1, usage_type=, to_str_qty=3.0, issue_uom=T001, item_unit_cost=4.36, iss_item_hold_yn=Y, store_desc=IP - RIPASH, for_bin_to_store_hidden=Y, uom_code=T001, issue_uom_conv=1, from_multiples=1, stock_uom_desc=Tablets}
										  HashMap hmDtlBarcode = new HashMap();
										  hmDtlBarcode = (HashMap)alDtlBarcode.get(a);
										  	if(hmDtlBarcode.containsValue(newItemCode))
										  	{
										  		if(hmDtlBarcode.containsKey("issue_uom_qty")){
										  			 authorized_item_qty = ebean.checkForNull((String)hmDtlBarcode.get("issue_uom_qty"), "");
										  			System.out.println("inside if"+authorized_item_qty);
										  			authorized_qty1=ebean.checkForNull((String)hmDtlBarcode.get("authorized_item_qty"), "");// adedd for GHL-CRF-0645
										  			out.println("checkQtyBarcode(\""+authorized_item_qty+"\",\""+newItemCode+"\",\""+authorized_qty1+"\");");//adedd for GHL-CRF-0645
										  		}
										  		result = true;
										  		break;
										  	}
										  	else
										  		continue;
									  }
									 }else{
										 message = "ITEM_STORE_NOT_FOUND1";
									 }
									}else{
										 message = "ST_INVALID_BAR_CODE";
									 }
								}
								else
									result = true;
							}catch(Exception exception){
								exception.printStackTrace();
								flag			=	"VALIDATE_ISS";
								result			=	false;
							}
						}
						else if(validate.equals("VALIDATE_ISS_BATCH"))  { 
							String valid_barcode = request.getParameter("barcode");
							String valid_trn_type = request.getParameter("trntype");
							String valid_store_code = request.getParameter("store_code");
							result = false;
							try{
								if(valid_trn_type.equals("ISS")){
									String newItemCode = "";
									newItemCode=ebean.checkForNull((String)	ebean.fetchRecord("select item_code from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code}).get("ITEM_CODE"),"");
									HashMap newBatchID = null;
									newBatchID=	(HashMap)ebean.fetchRecord("select batch_id from st_item_batch where barcode_id = ? and store_code = ?",new String[]{valid_barcode,valid_store_code});	
									HashMap hmExpBarcode = ebean.getExpRecordsforBarCode();
									int count = 0;
									for(int b=0;b< hmExpBarcode.size();b++){
										String j = ""+b;
										ArrayList alExp = new ArrayList();
										alExp = (ArrayList)hmExpBarcode.get(j);
										for(int c=0;c<alExp.size();c++)
										{
											HashMap hmExp = new HashMap();
											hmExp = (HashMap)alExp.get(c);
											if(hmExp.containsValue(newItemCode)){
											   if((hmExp.containsValue(newBatchID.get("BATCH_ID"))))
												  count++;
											}
										}
									}
									if(count==0){
										 message = "true"+";"+newItemCode+";"+newBatchID;//batch_id added for ICN65143 against GHL-CRF-0465
									}
									 result = true;
								}
								else
									result = true;
							}catch(Exception exception){
								exception.printStackTrace();
								flag			=	"VALIDATE_ISS_BATCH";
								result			=	false;
							}
						}
						//Added against GHL-CRF-0413.2-US002 ends
						
						//Added ICN 65143 against GHL-CRF-465
						else if(validate.equals("VALIDATE_SCANNED_AUNUTHORIZED_BATCH"))
						{
							//String valid_barcode = request.getParameter("barcode"); commented by Shazana for unused local variable
							//String valid_trn_type = request.getParameter("trntype"); commented by Shazana for unused local variable
							//String valid_store_code = request.getParameter("from_store");commented by Shazana for unused local variable
							String batch_id=request.getParameter("batch_item");
							result=true;
							try{
							if(ebean.getScannedbatchdtl().size()==0)
							{
							ebean.setScannedbatchdtl(batch_id);
							result =true;
							}else 
							{	System.err.println("1694^^^^^^^^^^^^^^ -->" +ebean.getScannedbatchdtl().size());
							for(int i=0;i<ebean.getScannedbatchdtl().size();i++)
								{
									if(ebean.getScannedbatchdtl().get(i).equals(batch_id))
									{
									result =false;
									break;
									}
								} 
								System.err.println("1694^^^^^^^^^^^^^^ -->" +ebean.getScannedbatchdtl());
									if(result==true)
										ebean.setScannedbatchdtl(batch_id);
								}
																System.err.println("1694fvgjkldf^^^^^^^^^^^^^^ -->" +ebean.getScannedbatchdtl());

									
							}
							catch(Exception exception)
							{
								exception.printStackTrace();
								flag			=	"VALIDATE_SCANNED_AUNUTHORIZED_BATCH";
								result			=	false;
							}
						}
						else if(validate.equals("REMOVE_AUTH_BATCH_IN_LIST"))
						{
							
							String batch_id=request.getParameter("batch_item");
							result=true;
							try{
							if(ebean.getScannedbatchdtl().size()>0)
							 
							{	
							for(int i=0;i<ebean.getScannedbatchdtl().size();i++)
								{
									if(ebean.getScannedbatchdtl().get(i).equals(batch_id))
									{
									ebean.getScannedbatchdtl().remove(i);
									break;
									}
								} 							
							}		
							}
							catch(Exception exception)
							{
								exception.printStackTrace();
								flag			=	"VALIDATE_SCANNED_AUNUTHORIZED_BATCH";
								result			=	false;
							}
						}// END ICN 65143 against GHL-CRF-465
						//Added for TFS id:6938 start
						else if(validate.equals("BARCODE_QUERY_FUNCTION")) {
							String barcode			=		request.getParameter("barcode");
							String callled_from			=		request.getParameter("calledfrom")==null?"":request.getParameter("calledfrom");
							String item_code1="";
							String store_code ="";
							String barcode_2d_applicable_yn = ebean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
							ebean.setLanguageId(locale);//Added for MMS-DM-CRF-0174.6
							try{
								if(barcode_2d_applicable_yn.equals("Y"))
                                   item_code1 = ebean.get2DBarcodeItem(store_code,barcode);
							    else
								  item_code1=	(String)ebean.fetchRecord("select item_code from st_item_batch where barcode_id =?",new String[]{barcode}).get("ITEM_CODE");

								item_code1 = ebean.checkForNull(item_code1, "");
								String item_desc1=	(String)ebean.fetchRecord("select short_desc from mm_item where item_code =?",new String[]{item_code1}).get("SHORT_DESC");
								item_desc1 = ebean.checkForNull(item_desc1, "");
								if(!item_desc1.equals("")&&item_desc1!=null){
									item_desc1=item_desc1.replaceAll(" ","%20");
									item_desc1=	java.net.URLEncoder.encode(item_desc1,"UTF-8");
									item_desc1=item_desc1.replaceAll("%2520","%20");
								}
								if(item_desc1.length() <= 0){
									result = false;
								}
								else
									result = true;
								
								if(result){
									if(callled_from.equals("SSBI")){
										out.println("document.formStockStatusQueryCriteria.item_code.value = '"+item_code1+"'");
									}
									else if(callled_from.equals("SSBS")){
										out.println("document.StockStatusByStoreCriteria_form.item_code.value = '"+item_code1+"'");
										out.println("document.StockStatusByStoreCriteria_form.item_desc.value = decodeURIComponent('"+item_desc1+"');");
										out.println("document.StockStatusByStoreCriteria_form.item_desc.readOnly=true;");
									}
									else if(callled_from.equals("BSFMI")){
										out.println("document.BatchSearchCriteria_Form.item_code_from.value = '"+item_code1+"'");
										out.println("document.BatchSearchCriteria_Form.item_code_to.value = '"+item_code1+"'"); //Added for TFS id:6938
										out.println("document.BatchSearchCriteria_Form.barcode_to.disabled = 'true'");//Added for TFS id:6938
									}
									else if(callled_from.equals("BSTOI")){
										out.println("document.BatchSearchCriteria_Form.item_code_to.value = '"+item_code1+"'");
									}
									else if(callled_from.equals("ITMMOV")){
										out.println("document.StockStatusByStoreCriteria_form.item_code.value = '"+item_code1+"'");
										out.println("document.StockStatusByStoreCriteria_form.item_desc.value = decodeURIComponent('"+item_desc1+"');");
										
									}
									else if(callled_from.equals("GRNH")){
										out.println("document.formGRNHistoryQueryCriteria.item_code.value = '"+item_code1+"'");
										out.println("document.formGRNHistoryQueryCriteria.item_desc.value = decodeURIComponent('"+item_desc1+"');");
										
									}
								}
							}
							catch(Exception ex) {
								ex.printStackTrace();
							}
						}
						//Added for TFS id:6938 end
						putObjectInBean(bean_id,ebean,request);
					}
					catch (Exception exception) {
						result		=	false;
						message		=	exception.getMessage();		
						exception.printStackTrace();
						
					}
					finally{
						out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
					}
				}else{
		
			CommonSearchBean bean = (CommonSearchBean) getBeanObject("commonSearch","eST.CommonSearchBean",request);	
			
			int functionType = Integer.parseInt((String)hash.get("function_type"));
		
			switch (functionType) {
			case 1:
				{
						String _item_code = (String) hash.get("item_desc");
						_item_code = _item_code.trim();
						bean.setCode(_item_code.toUpperCase());
						bean.execute(functionType);
						out.println("assignResult("+bean.getResult()+",getMessage(\"INVALID_ITEM_CODE\"), \"0\")");
						if (bean.getResult()) {
							out.println("code.value ='"+bean.getCode()+"';");
							out.println("desc.value ='"+bean.getDesc()+"';");
						}
				}
				break;
			case 2:
			{
				String trn_type 	= request.getParameter("trn_type");
				String store_code 	= request.getParameter("store_code");		
				result = bean.IsPromptForFinalizeRequired(trn_type,store_code);
				message="";
				flag="";
				
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}	
				break;
			default :
				//To be replaced with proper message
				out.println("alert(\'Invalid Function\');");
				return;
			}
		
			putObjectInBean("commonSearch",bean,request);
		
		 	}

	}//Added for ML-MMOH-CRF-0448 B.Badmavathi
%>
