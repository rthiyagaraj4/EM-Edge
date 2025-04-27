<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
12/08/2015	  	IN0037673	   		Karthi	 					SRR20056-SCF-9532
21/02/2016		IN0057461			B.Badmavathi					ML-MMOH-CRF-0448
22/06/2017		IN0064609			B.Badmavathi					ML-BRU-SCF-1720 
8/8/2021		TFS:21452        	Shazana                      	ML-MMOH-SCF-1861
---------------------------------------------------------------------------------------------------------------
*/ 
%>

<%@page contentType="text/html;charset=UTF-8" import=" eST.ProductTransferBean,eST.Common.*,java.util.HashMap,java.util.ArrayList,webbeans.eCommon.*"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale						= (String)session.getAttribute("LOCALE");
			
    ProductTransferBean bean			= (ProductTransferBean)getBeanObject("ProductTransferBean", "eST.ProductTransferBean", request ) ;
	bean.setLanguageId(locale);
//  bean.clear();
	bean.initialize();
	StHeaderBean beanHdr				= (StHeaderBean) getBeanObject( "stHeaderBean", "eST.Common.StHeaderBean" ,request);
	beanHdr.setLanguageId(locale);
    bean.setProductTransferHeaderBean(beanHdr);   

	String validate						= request.getParameter("validate");
//	Hashtable htFormValues				= (Hashtable) XMLobj.parseXMLString(request);
	
    String doc_srl_no 					=	"";
    String message						=	"";
	String flag							=	"";
	String item_code					=	"";
	String store_code					=	"";
    String fm_item_code					=	"";
    String to_item_code					=	"";
	String fm_stock_uom_code			=	"";
    String to_stock_uom_code			=	"";
	String repack_uom_1					=	"";
    String fm_batch_id					=   "";
    String to_batch_id					=   "";
	String auto_gen_batch_yn			=	 request.getParameter("auto_gen_batch_yn")==null?"":request.getParameter("auto_gen_batch_yn");
	String next_batch_id				=	 "";
	String fm_expiry_yn					=	 "";
	String to_expiry_yn					=	 "";
    String fm_expiry_date				=	 "";
	String to_expiry_date				=	 "";
	String stk_uom						=	 "";
	String to_stk_uom					=	 "";
	String eqvlvalue_1					=	"";
    String fm_trade_id					=	"";
	String to_trade_id					=	"";
    String fm_bin_location_code			=	"";
	String to_bin_location_code			=	"";
	String fm_stk_uom_conv_factor		=	"" ;
	String to_stk_uom_conv_factor		=	"" ;
	String fm_item_qty					=	"" ;
    String to_item_qty					=	"" ;
    String fm_item_unit_cost			=	"" ;
	String to_item_unit_cost			=	"" ;
    String fm_item_cost_value			=	"" ;
    String to_item_cost_value			=	"" ;
	String remarks						=	"";
	//String repackgroup				=	""; 
	String gl_item_code					=	"";
	String eqvlvalue					=	request.getParameter("eqvlvalue")==null?"":request.getParameter("eqvlvalue");
	String repack_group1				=	request.getParameter("repack_group1")==null?"":request.getParameter("repack_group1");
	String repack_group2				=	request.getParameter("repack_group2")==null?"":request.getParameter("repack_group2");
//	String facility_id					=	(String)session.getValue("facility_id");

	String to_batch_id_applicable_yn	=	"";
	String fm_trade_id_applicable_yn	=	""; 
	String to_trade_id_applicable_yn	=	"";
	String prepare_location				=	""  ;
	String actual_qty					=	""  ;
	String expect_bal_qty				=	""  ;
	String expect_act_qty				=	""  ;
	String counter_check				=	""  ;
	String time_taken					=	""  ;
	String p_auth_by					=	""  ;
	String p_packed_by					=	""	;
	String no_of_labels					=	""	;
    String request_no					=	""	;
	String repack_uom					=	""	; 
	String request_flag					=	""	;
	String item_code_1					=	""	;
	String to_sale_price				=	"";
	String fm_sale_price				=	"";
	String sale_price_appl_yn			=   "";
	boolean	result1						=	true;
	String to_barcode_id                   = ""; //11/05/12
	String fm_barcode_id                   = ""; //11/05/12

	HashMap hashmapDtl					=	new HashMap();
	boolean	result						=	false;
	String prod_transfer_mode = ""; //ML-MMOH-SCF-1861   
	String doc_no ="";
	String doc_type_code =""; //end 

	try {

		String label					=	request.getParameter("label");

		if(validate.equals("ITEM_CODE")) {

			item_code					=	request.getParameter("item_code");
			//item_code_1				=	request.getParameter("item_code_1");
			item_code_1					=	request.getParameter("item_code_1")==null?"":request.getParameter("item_code_1");
            store_code					=	request.getParameter("store_code");
			
			if(item_code_1.equals(""))
			{
				result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				

				if(result1)
				{
					String phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("parent.frameProductTransferAddModify.document.getElementById('phy_inv_id').value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					out.println("phy_inv_progress1();");
				}
			}
			else
			{
				result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code_1,store_code,"");
				if(result1)
				{
					String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code_1,store_code}).get("PHY_INV_ID");
					out.println("parent.frameProductTransferAddModify.document.getElementById('phy_inv_id').value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					out.println("phy_inv_progress2();");
				}

			}
			stk_uom = request.getParameter("stk_uom")==null?"":request.getParameter("stk_uom");
			request_flag = request.getParameter("requestflag")==null?"":request.getParameter("requestflag");

			to_stk_uom=request.getParameter("to_stk_uom")==null?"":request.getParameter("to_stk_uom");

			fm_expiry_yn = request.getParameter("fm_expiry_yn")==null?"":request.getParameter("fm_expiry_yn");
		to_expiry_yn =request.getParameter("to_expiry_yn")==null?"":request.getParameter("to_expiry_yn");



			fm_trade_id_applicable_yn =request.getParameter("fm_trade_id_applicable_yn")==null?"":request.getParameter("fm_trade_id_applicable_yn");
			to_trade_id_applicable_yn =request.getParameter("to_trade_id_applicable_yn")==null?"":request.getParameter("to_trade_id_applicable_yn");
			to_batch_id_applicable_yn =request.getParameter("to_batch_id_applicable_yn")==null?"":request.getParameter("to_batch_id_applicable_yn");



			try {

				ArrayList alBatchList=new ArrayList();
				alBatchList=bean.getBatchDetails(item_code,store_code);
				String allowDecimalsYN = "";
				String noOfDecimals = "";
            
			allowDecimalsYN = bean.getAllowDecimalsYN(item_code);
					noOfDecimals = ""+bean.getNoOfDecimals();
					out.println("setDecimalParameters('"+allowDecimalsYN+"','"+ noOfDecimals +"','"+label+"');");

				String stock_item_yn =(String)(alBatchList.get(5));
				String stock_availability=(String)(alBatchList.get(0));
				//newly added for delete function
				String prt_delete_yn = bean.getMfg_delete_yn(); 
				out.println("parent.frameProductTransferAddModify.document.getElementById('prt_delete_yn').value='"+prt_delete_yn+"'");
				if(stock_item_yn.equals("N"))
				{

					if(label.equals("from"))
					   out.println( "from_stock_item_check();" ) ;
					else
					   out.println( "to_stock_item_check();" ) ;
				}
				else
				{
				  if(fm_expiry_yn.equals("")||to_expiry_yn.equals("")||fm_expiry_yn.equals(to_expiry_yn))
					 {
						 
						  
					   if(stock_availability.equals("Y"))
						 {		
								 out.println( "from_enable_Batch_Button();" ) ;
								  out.println( "from_display_data();") ;

								  if(to_expiry_yn.equals("N"))
									{
									 out.println( "to_disable_expiry_date();" ) ;
									}

						 }
						else
						 {
								if(label.equals("from"))
								{
								   out.println( "from_disable_Batch_Button();" ) ;
								}
								else{
								  //out.println( "to_disable_Batch_Button();" ) ;
								  //out.println( "to_display_data();") ;
								}
						 }

				   }
				   else
				   {
						if(label.equals("from")){

						  out.println( "fn_from_expiry_yn();") ;
						  }
						else{

						  out.println( "fn_to_expiry_yn();") ;
						 }
				   }

				 
// Commented on 9/9/2005  as per the requirement from Shenoy not to display the default trade name for sole source item.Trade name  has to be considered from-item trade name

/*	 Starts 9/9/2005
				if(!(to_trade_id_applicable_yn.equals("")) && to_trade_id_applicable_yn.equals("N"))
					{
					   ArrayList alDfltTradeId=bean.getDefltTradeId();
					   String dfltTradeId=(String)alDfltTradeId.get(0);
					   out.println( "setDefaultTradeId(\"" + dfltTradeId + "\" );" ) ;
					} */
			// Ends 9/9/2005
					/*if(!(to_batch_id_applicable_yn.equals("")) && to_batch_id_applicable_yn.equals("E"))
					{

					   ArrayList alDfltTradeId=bean.getDefltTradeId();
					   String dfltTradeId=(String)alDfltTradeId.get(0);
					   out.println( "setDefaultTradeId(\"" + dfltTradeId + "\" );" ) ;
					}*/
					// added on 06/09/2004
                 	   if( !(fm_trade_id_applicable_yn.equals("")) && fm_trade_id_applicable_yn.equals("N") && !(to_trade_id_applicable_yn.equals("")) && to_trade_id_applicable_yn.equals("Y") )
						{
						  
				           out.println( "fn_trade_id_applicable_yn();") ;
						  
						  /// throw new Exception("ONLY_TRADE_SPEC_ITEM_ALWD");

						}
						else{
				     
	   						if(!stk_uom.equals("") && to_stk_uom.equals(""))
							{
								
								ArrayList alRepUom=new ArrayList();
								alRepUom=bean.getRepackUom(item_code);
								
								if(alRepUom.size()>0){
								  repack_group1=CommonBean.checkForNull((String)alRepUom.get(0));
								
								if(!repack_group1.equals("")){
					 			out.println("parent.frameProductTransferAddModify.document.getElementById('repack_group1').value='"+repack_group1+"'");

							}
					  
					  
								repack_uom =CommonBean.checkForNull((String)alRepUom.get(1));
					  
					}
					
					if(repack_uom.equals(""))
					{
						
					    eqvlvalue="1";
						

					}
					
					
					if(!repack_uom.equals(""))
					{	
							ArrayList alUOM=new ArrayList();
							alUOM=bean.getEqvlUom(stk_uom,repack_uom);
							
							if(alUOM.size()>0)
							{   
								eqvlvalue=CommonBean.checkForNull((String)alUOM.get(0));
							
							}
							else if(alUOM.size()==0)
							{
								 eqvlvalue="1";
							}
							out.println("parent.frameProductTransferAddModify.document.getElementById('eqvlvalue').value='"+eqvlvalue+"'");
							gl_item_code = item_code;
							
					}
				 
				}
				

						
				if(!to_stk_uom.equals("")&& !stk_uom.equals(""))
				{
							 ArrayList alRegroupUom=new ArrayList();
							 alRegroupUom=bean.getRepackUom(item_code);
							 if(alRegroupUom.size()>0){
							  repack_group2=CommonBean.checkForNull((String)alRegroupUom.get(0));
							  
							  repack_uom_1=CommonBean.checkForNull((String)alRegroupUom.get(1));

							  if(repack_uom_1.equals(""))
								{
						
									eqvlvalue_1="1";
								}
								if(!repack_uom_1.equals(""))
								{	
									ArrayList alUOM=new ArrayList();


									alUOM=bean.getEqvlUom(to_stk_uom,repack_uom_1);
									
						
								if(alUOM.size()>0)
								{
									eqvlvalue_1=CommonBean.checkForNull((String)alUOM.get(0));
								}
								else if(alUOM.size()==0)
								{   
									
									if (to_stk_uom.equals(repack_uom_1))
									{
										eqvlvalue_1 ="1";
									}
									else
									{
									
									 out.println("conv_factor_not_defined();");
									 result= false;
									}
								}
								//out.println("parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.eqvlvalue.value='"+eqvlvalue+"'");
								out.println("parent.frameProductTransferAddModify.document.getElementById('p_fm_factor').value='"+eqvlvalue_1+"'");
								if(!request_flag.equals("Y"))
								{
								out.println("ComputeToQuantity();");
								}
							//gl_item_code = item_code;
							
					}
							  out.println("parent.frameProductTransferAddModify.document.getElementById('repack_group2').value='"+repack_group2+"'");
							 
							 }

							 //out.println("parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.repack_group2.value='"+repack_group2+"'");
						
							 if(!repack_group2.equals(""))
							 bean.setRepackGroup(repack_group2);

				}

				/*if(repack_group1.equals("") || repack_group2.equals(""))
				{
					out.println("enable_batch_id();" ) ;
				}*/
				
				/*	if(!to_stk_uom.equals("")&& !stk_uom.equals("")  && !repack_group1.equals(repack_group2))
					 {
					
							out.println("repacking_groups_different();");
							result=false;
					  }
					  else
					  */if(!to_stk_uom.equals("")&& !stk_uom.equals("") && repack_group1.equals("") && repack_group2.equals(""))
					{
						out.println("repacking_groups_different();");
						result=false;
					  }
					else
					{	
					System.out.println("to_batch_id_applicable_yn===prductvalidate=>" +to_batch_id_applicable_yn);
						if(!(to_batch_id_applicable_yn.equals("")) && to_batch_id_applicable_yn.equals("N"))
						{
					   ArrayList alDfltBatchId=bean.getDefltBatchId();
					   String dfltBatchId=(String)alDfltBatchId.get(0);
					   out.println( "setDefaultBatchId(\"" + dfltBatchId + "\" );" ) ;
					   out.println("bin_location_populate();");
						}
							
						else if(!(to_batch_id_applicable_yn.equals("")) && to_batch_id_applicable_yn.equals("E"))
						{

                         
					   out.println( "parent.frameProductTransferAddModify.document.formProductTransferAddModify.p_to_batch_id.disabled=true" ) ;
					   out.println("parent.frameProductTransferAddModify.document.getElementById('imgs').style.visibility='hidden';");
					   out.println("bin_location_populate();");
						}
						else				
					 
						if(!to_stk_uom.equals("") && !(to_batch_id_applicable_yn.equals("")) && to_batch_id_applicable_yn.equals("Y"))
						{
							
							out.println("bin_location_populate();");
							ArrayList alAutoGenYn=new ArrayList();
							
							if(!repack_group2.equals(""))
							{
								
							
								alAutoGenYn=bean.getAutoGenYn(repack_group2);
								auto_gen_batch_yn=CommonBean.checkForNull((String)alAutoGenYn.get(0));
							
								out.println("parent.frameProductTransferAddModify.document.getElementById('auto_gen_batch_yn').value='"+auto_gen_batch_yn+"'");
								if(auto_gen_batch_yn.equals("Y"))
								{
							 
									next_batch_id=CommonBean.checkForNull((String)alAutoGenYn.get(1));
									out.println("parent.frameProductTransferAddModify.document.getElementById('next_batch_id').value='"+next_batch_id+"'");
									out.println("next_batch_id(\"" + next_batch_id + "\" );" ) ;
									}
									else
									{
									out.println("enable_batch_id();" ) ;
									}

		  				   		}
								else
								{
									out.println("enable_batch_id();" ) ;
								}
						}
			      	}
				  //}
			  }
			}

		    }catch(Exception exception) {
				exception.printStackTrace();
			}
  		  result =	true;
		}
		if(validate.equals("BIN_LOCATION")) {
            store_code	=	request.getParameter("store_code");
            item_code	=	request.getParameter("item_code");
   			ArrayList alBinLocationCode = bean.getBinLocation(store_code,item_code);
			//String stBinLocationCode=(String)alBinLocationCode.get(0);
			ArrayList BinLocationList = bean.getSTITBin_location_code_ArrayList(store_code,item_code,locale);
			String temp_bin_location_code = (String)alBinLocationCode.get(0) ;
			out.println("clearListItems('formProductTransferAddModify.p_to_bin_location'); ");
			try{
				HashMap record = null;
				for(int i=0; i< BinLocationList.size(); i++) {
				   record = (HashMap)BinLocationList.get(i);
				   out.println("addListItem(\"formProductTransferAddModify.p_to_bin_location\", \"" + record.get("BIN_LOCATION_CODE") + "\",\"" + record.get("SHORT_DESC") + "\",\"" + temp_bin_location_code + "\" );");
				}
			}
			catch(Exception e){
				e.printStackTrace();
			}
			result =true ;
		}

       if(validate.equals("ADD_TO_LIST")) {
		   

	     doc_srl_no						=	request.getParameter("doc_srl_no");
		 store_code						=   request.getParameter("store_code");
         fm_item_code					=	request.getParameter("fm_item_code");
		 to_item_code					=	request.getParameter("to_item_code");
		 fm_stock_uom_code				=	request.getParameter("fm_uom_code");
		 to_stock_uom_code				=	request.getParameter("to_uom_code");
		 fm_batch_id					=	request.getParameter("fm_batch_id");
		 to_batch_id					=	request.getParameter("to_batch_id");
		 fm_expiry_date					=	request.getParameter("fm_expiry_date");
		 to_expiry_date					=	request.getParameter("to_expiry_date");
         fm_trade_id					=	request.getParameter("fm_trade_id");
       	 //ArrayList alItemCodeTradeId	=	new ArrayList();
		 //alItemCodeTradeId			=	bean.checkItemCodeTradeId(to_item_code,fm_trade_id);
		 //to_trade_id					=	(String)alItemCodeTradeId.get(1);
		 to_trade_id					=	request.getParameter("to_trade_id");
		 fm_bin_location_code			=	request.getParameter("fm_bin_location_code");
		 to_bin_location_code			=	request.getParameter("to_bin_location_code");
		 fm_stk_uom_conv_factor			=	request.getParameter("fm_conversion_factor");
		 to_stk_uom_conv_factor			=	request.getParameter("to_conversion_factor");
		 fm_item_qty					=   request.getParameter("fm_item_quantity");
		 to_item_qty					=   request.getParameter("actual_qty");
		 remarks						=   CommonBean.checkForNull(request.getParameter("remarks"));
		 actual_qty						=   CommonBean.checkForNull(request.getParameter("to_item_quantity"));
		 expect_bal_qty					=   CommonBean.checkForNull(request.getParameter("expect_bal_qty"));
		 expect_act_qty					=   CommonBean.checkForNull(request.getParameter("expect_act_qty"));
	     counter_check					=   CommonBean.checkForNull(request.getParameter("counter_check"));
	     time_taken						=   CommonBean.checkForNull(request.getParameter("time_taken"));
	     p_auth_by						=   CommonBean.checkForNull(request.getParameter("p_auth_by"));
		 p_packed_by					=   CommonBean.checkForNull(request.getParameter("p_packed_by"));
		 prepare_location				=   CommonBean.checkForNull(request.getParameter("prepare_location"));
		 no_of_labels					=   CommonBean.checkForNull(request.getParameter("no_of_labels")); 
         request_no						=   CommonBean.checkForNull(request.getParameter("request_no"),"");
		 
		 fm_sale_price					=	CommonBean.checkForNull(request.getParameter("fr_sale_price")); 
		 to_sale_price					=	CommonBean.checkForNull(request.getParameter("to_sale_price")); 
		 sale_price_appl_yn				=	CommonBean.checkForNull(request.getParameter("sale_price_appl_yn"),"N"); 
         to_barcode_id				    =	CommonBean.checkForNull(request.getParameter("to_barcode_id"),"");	
         fm_barcode_id				    =	CommonBean.checkForNull(request.getParameter("fm_barcode_id"),"");	
         prod_transfer_mode 			=	CommonBean.checkForNull(request.getParameter("prod_transfer_mode"),"");	//ML-MMOH-SCF-1861  
         doc_no = CommonBean.checkForNull(request.getParameter("doc_no"),"");	
         doc_type_code = CommonBean.checkForNull(request.getParameter("doc_type_code"),"");//end  

		 //System.out.println("fm_sale_price" +fm_sale_price);
		 //System.out.println("sale_price_appl_yn" +sale_price_appl_yn);
		 
 		 /**
		 * @Name - Priya
		 * @Date - 07/06/2010
		 * @Inc# - 
		 * @Desc -  To get no of decimals for cost 
		 */
			int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());


		 ArrayList alForUnitCostFrom	=		new ArrayList();
 		 /*alForUnitCostFrom				=		bean.getBatchDetails(fm_item_code,store_code);
		 Double doubleObjUnitCostFrom	=		(Double)alForUnitCostFrom.get(2);*/
		 //Modified by suresh.r on 25-11-2014 against Inc# 52256
		Double doubleObjUnitCostFrom=bean.getBaseUnitCost(fm_item_code);
         fm_item_unit_cost				=		String.valueOf(doubleObjUnitCostFrom.doubleValue());
          fm_item_cost_value				=		bean.setNumber( String.valueOf( Double.parseDouble(fm_item_qty) * Double.parseDouble(fm_item_unit_cost) ),noOfDecimalsForCost);
          to_item_cost_value				=		bean.setNumber(String.valueOf( Double.parseDouble(fm_item_qty) * Double.parseDouble(fm_item_unit_cost) ),noOfDecimalsForCost);
          double tempItemCostValue		=		Double.parseDouble(to_item_cost_value) ;
         double int_to_item_qty			=		Double.parseDouble(actual_qty);
		 double tempItemUnitCost		=		tempItemCostValue/int_to_item_qty;
		 
		 to_item_unit_cost				=		bean.setNumber((String.valueOf(tempItemUnitCost)),noOfDecimalsForCost);
		 fm_item_unit_cost				=		bean.setNumber(fm_item_unit_cost,noOfDecimalsForCost);//Added by suresh.r on 25-11-2014 against Inc# 52256
 		 //String trn_type				=		"PRT" ;
		 String FINALIZED_YN			=		"Y"   ;
		 //String gl_interfaced_yn		=		"Y" ;


			flag="";

			hashmapDtl.put("doc_srl_no",	doc_srl_no	);
			hashmapDtl.put("store_code",store_code);
			hashmapDtl.put("fm_item_code",fm_item_code ) ;
			hashmapDtl.put("to_item_code" ,to_item_code ) ;
			hashmapDtl.put("fm_stk_uom_code" , fm_stock_uom_code ) ;
			hashmapDtl.put("to_stk_uom_code" , to_stock_uom_code ) ;
			hashmapDtl.put("fm_stk_uom_conv_factor" , fm_stk_uom_conv_factor );
			hashmapDtl.put("to_stk_uom_conv_factor" , to_stk_uom_conv_factor );
			hashmapDtl.put("fm_item_batch_id" ,fm_batch_id ) ;
			hashmapDtl.put("to_item_batch_id" ,to_batch_id ) ;
			hashmapDtl.put("fm_expiry_date"   ,fm_expiry_date) ;
			hashmapDtl.put("to_expiry_date"   ,to_expiry_date) ;
            hashmapDtl.put("fm_trade_id"   ,fm_trade_id) ;
			hashmapDtl.put("to_trade_id"   ,to_trade_id) ;
			hashmapDtl.put("fm_bin_location_code"   ,fm_bin_location_code) ;
			hashmapDtl.put("to_bin_location_code"   ,to_bin_location_code) ;
			hashmapDtl.put("fm_item_qty" ,fm_item_qty );
			hashmapDtl.put("to_item_qty" ,to_item_qty );
			hashmapDtl.put("finalized_yn" , FINALIZED_YN ) ;
			//hashmapDtl.put("gl_interfaced_yn" ,gl_interfaced_yn );
			//hashmapDtl.put("trn_type" , trn_type ) ;
			hashmapDtl.put("fm_item_unit_cost" , fm_item_unit_cost ) ;
			hashmapDtl.put("to_item_unit_cost" , to_item_unit_cost ) ;
            hashmapDtl.put("fm_item_cost_value" , fm_item_cost_value ) ;
			hashmapDtl.put("to_item_cost_value" , to_item_cost_value ) ;
            hashmapDtl.put("fm_stock_item_yn" , "Y" ) ;
			hashmapDtl.put("to_stock_item_yn" , "Y" ) ;
            hashmapDtl.put("remarks" , remarks ) ;
			hashmapDtl.put("actual_qty" , actual_qty ) ;
			hashmapDtl.put("expect_bal_qty" , expect_bal_qty ) ;
			hashmapDtl.put("expect_act_qty" , expect_act_qty ) ;
			hashmapDtl.put("time_taken" , time_taken ) ;
			hashmapDtl.put("p_packed_by" , p_packed_by ) ;
			hashmapDtl.put("counter_check" , counter_check ) ;
			hashmapDtl.put("p_auth_by" , p_auth_by ) ;
            hashmapDtl.put("prepare_location" , prepare_location ) ;
			hashmapDtl.put("no_of_labels" , no_of_labels ) ;
            hashmapDtl.put("request_no" , request_no ) ;
			hashmapDtl.put("fm_item_unit_price" , fm_sale_price) ;
			hashmapDtl.put("to_item_unit_price" , to_sale_price) ;
			hashmapDtl.put("sale_price_appl_yn" , sale_price_appl_yn) ;
			hashmapDtl.put("fm_barcode_id" , fm_barcode_id) ;
			hashmapDtl.put("to_barcode_id" , to_barcode_id) ;
			hashmapDtl.put("prod_transfer_mode" , prod_transfer_mode) ;//ML-MMOH-SCF-1861
			hashmapDtl.put("doc_no" , doc_no) ; 
			hashmapDtl.put("doc_type_code" , doc_type_code) ; ////ML-MMOH-SCF-1861 
			
			//System.out.println("hashmapDtl==prt=>" +hashmapDtl);
			
			
			bean.setDetailValues(hashmapDtl);

		//bean.setExpValues(htFormValues);

		result			=	true;

	   }


	   if(validate.equals("ITEM_FROM_SEARCH")) {
		   String itemcode=request.getParameter("item_code")==null?"":request.getParameter("item_code");
		   String itemlabel=request.getParameter("itemlabel")==null?"":request.getParameter("itemlabel");
		   
		   String storecode=request.getParameter("store_code")==null?"":request.getParameter("store_code");
		   
			ArrayList allist=new ArrayList();
			allist=bean.getItemSearchDetails(itemcode,storecode);
			HashMap hmmap=(HashMap)allist.get(0);

			ArrayList alBatchList=new ArrayList();
				alBatchList=bean.getBatchDetails(itemcode,storecode);
		    	//String stock_item_yn =(String)(alBatchList.get(5));
				String stock_availability=(String)(alBatchList.get(0));
				String allowDecimalsYN = "";
				String noOfDecimals = "";
            
			//allowDecimalsYN = bean.getAllowDecimalsYN(itemcode);
				allowDecimalsYN =(String) hmmap.get("ALLOW_DECIMALS_YN");
					noOfDecimals = ""+bean.getNoOfDecimals();
					out.println("setDecimalParameters('"+allowDecimalsYN+"','"+ noOfDecimals +"','"+itemlabel+"');");
			
		
			if (itemlabel.equals("from"))
			{	
						//out.println("parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.from_item_code.value='"+hmmap.get("ITEM_CODE")+"'");
					
					if(stock_availability.equals("Y"))
						 {		
								 out.println( "from_enable_Batch_Button();" ) ;
						 }
					out.println("parent.frameProductTransferAddModify.document.getElementById('fm_item_code').value='"+hmmap.get("ITEM_CODE")+"'");
					out.println("parent.frameProductTransferAddModify.document.getElementById('fm_expiry_yn').value='"+hmmap.get("EXPIRY_YN")+"'");
					out.println("parent.frameProductTransferAddModify.document.getElementById('fm_uom_code').value='"+hmmap.get("GEN_UOM_CODE")+"'");
					out.println("parent.frameProductTransferAddModify.document.getElementById('from_req_trade_id_applicable_yn').value='"+hmmap.get("TRADE_ID_APPLICABLE_YN")+"'");
					out.println("parent.frameProductTransferAddModify.document.getElementById('from_uom_desc').value='"+hmmap.get("UOM_DESC")+"'");
					out.println("parent.frameProductTransferAddModify.document.getElementById('from_item_desc').value=\""+hmmap.get("ITEM_DESC")+"\"");//added for product transfer itemcode desc (special characters) to disabled mode.
					
			  }
			  if(!itemcode.equals("") && itemlabel.equals("to"))
			  {

				   //out.println("parent.frameProductTransferAddModify.document.formProductTransferAddModify.document.formProductTransferAddModify.too_item_code.value='"+hmmap.get("ITEM_CODE")+"'");
				
					if(stock_availability.equals("Y"))
						 {		
								 out.println( "from_enable_Batch_Button();" ) ;
						 } out.println("parent.frameProductTransferAddModify.document.getElementById('to_item_code').value='"+hmmap.get("ITEM_CODE")+"'");
				   out.println("parent.frameProductTransferAddModify.document.getElementById('to_trade_id_applicable_yn').value='"+hmmap.get("TRADE_ID_APPLICABLE_YN")+"'");
				   out.println("parent.frameProductTransferAddModify.document.getElementById('to_expiry_yn').value='"+hmmap.get("EXPIRY_YN")+"'");
				   out.println("parent.frameProductTransferAddModify.document.getElementById('to_req_trade_id_applicable_yn').value='"+hmmap.get("TRADE_ID_APPLICABLE_YN")+"'");
				   out.println("parent.frameProductTransferAddModify.document.getElementById('to_req_batch_id_applicable_yn').value='"+hmmap.get("BATCH_ID_APPLICABLE_YN")+"'");
				   out.println("parent.frameProductTransferAddModify.document.getElementById('to_uom_code').value='"+hmmap.get("GEN_UOM_CODE")+"'");				  
				   out.println("parent.frameProductTransferAddModify.document.getElementById('too_item_desc').value=\""+hmmap.get("ITEM_DESC")+"\"");//added for product transfer itemcode desc (special characters) to disabled mode.
				   out.println("parent.frameProductTransferAddModify.document.getElementById('too_uom_desc').value='"+hmmap.get("UOM_DESC")+"'");
				   
				 
			  }
		
			result=true;
			
	   }
	  
	   
	   
	    if (validate.equals("printOnlineDoc")){
		try{
			//String labelreqd=request.getParameter("labelreqd")==null?"":request.getParameter("labelreqd");
			String nooflabels=request.getParameter("nooflabels")==null?"":request.getParameter("nooflabels");
			String pdocno=bean.getPrintDocNo();
			//bean.doOnlineReportPrinting(pdocno);//,session);
			bean.doOnlineReportPrinting(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
			if(!nooflabels.equals(""))
			{	
				//for(int i=0;i<Integer.parseInt(nooflabels);i++)
				//{
					//bean.doOnlineReportPrintingOfLabel(pdocno);//,session);
					bean.doOnlineReportPrintingOfLabel(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
					//}
			}
			}catch(Exception e){
		
			}
			result =  true;
			message = request.getParameter("msg");
		}
		
		if(validate.equals("SALE_PRICE")) {
            String login_facility_id	=   bean.getLoginFacilityId();
			String episode_type			=	CommonBean.checkForNull(request.getParameter("episode_type"));
            fm_item_code				=	CommonBean.checkForNull(request.getParameter("fm_item_code"));
			fm_trade_id					=	CommonBean.checkForNull(request.getParameter("fm_trade_id"));
			fm_batch_id					=	CommonBean.checkForNull(request.getParameter("fm_batch_id"));
			//System.out.println("sale_price" +fm_item_code);
			//System.out.println("sale_price" +fm_trade_id);
			//System.out.println("sale_price" +fm_batch_id);
			String sale_price	=	bean.getSalePrice(login_facility_id, episode_type, fm_item_code,fm_trade_id, fm_batch_id);

			System.out.println("sale_price" +sale_price);
			//if(sale_price == null || sale_price.equals("Error No-->BL9646"))
			//Added by Rabbani #Inc no :49480 on 06-JUN-2014
			if(sale_price == null || sale_price.equals("Error No-->BL9646") || sale_price.contains("Error Description -->"))
			sale_price = "0";
			
			System.out.println("sale_price" +sale_price);
			out.println("var sales="+sale_price);
			result =true ;
		} 
		if (validate.equals("BARCODE")) {	   //Added by Rabbani #inc no:29973 on 11/05/2012
		
			String	trn_type     =	bean.checkForNull(request.getParameter("trn_type"));
			String  facility_id  =  bean.checkForNull(bean.getLoginFacilityId());
			String  formname     =	bean.checkForNull(request.getParameter("formObj"));
			String  fromStore    =  bean.checkForNull(request.getParameter("fromStore"));
			String  toStore      =  bean.checkForNull(request.getParameter("toStore"));
			String  bar_code      =  bean.checkForNull(request.getParameter("bar_code"));
			String allow_decimals_yn="";
			HashMap alTemp	=	new HashMap();
			try {
			ArrayList alBarCodeListDetails = bean.getBarCodeDetailArrayList(bar_code,fromStore);						
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
						//System.out.println("temp_record==>"+temp_record);
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
				// System.out.println("record==>"+record);
				 String itemcode	=	(String)record.get("ITEM_CODE");
				 String batchid	    =	(String)record.get("BATCH_ID");
				 String expirydate	=	(String)record.get("EXPIRY_DATE");
				 String binlocation	=	(String)record.get("BIN_LOCATION_CODE");
				 String tradeid     =	(String)record.get("TRADE_ID");
				 int availqty		=	Integer.parseInt((String)record.get("AVAIL_QTY"));
				//String bindesc =  bean.getSTITBin_location_code_List(fromStore,itemcode,binlocation,locale);
		   if(availqty<=0 )				 
			 throw new Exception("INSUFFICIENT_BATCH_QTY");
		else{	
				//to get the item details
				ArrayList alItemDetails = bean.getItemDetailArrayList(locale,itemcode,fromStore);
				alTemp = (HashMap)alItemDetails.get(0);
                // System.out.println("alTemp:" +alTemp);
				 item_code  = (String)alTemp.get("ITEM_CODE") ;
				String item_desc1  = (String)alTemp.get("ITEM_DESC") ;
				String expiry_yn  = (String)alTemp.get("EXPIRY_YN") ;
				String uom_code   = (String)alTemp.get("GEN_UOM_CODE") ;
				String uom_desc   = (String)alTemp.get("GEN_UOM_DESC") ;
                String batch_id_applicable_yn   = (String)alTemp.get("BATCH_ID_APPLICABLE_YN") ; 
                String trade_id_applicable_yn   = (String)alTemp.get("TRADE_ID_APPLICABLE_YN") ; 
                String manufacturer_id   = bean.checkForNull((String)alTemp.get("MANUFACTURER_ID")) ;
				 //System.out.println("manufacturer_id:" +manufacturer_id);

				String supplier_id = bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_BATCH_CONTROL_SELECT_FOR_BAR_CODE_RULE"),new String[]{itemcode,batchid,expirydate}).get("SUPP_CODE"));
				// System.out.println("supplier_id:" +supplier_id);
				String mrp     =  bean.checkForNull((String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_BATCH_LEVEL_SALES_PRICE"),new String[]{facility_id,"I",itemcode,tradeid,batchid}).get("MRP_PRICE"));				
				
				//System.out.println("alItemDetails==>"+alItemDetails);
				String[] stParameters = {itemcode, fromStore, "0", "N", "", "N", toStore };
				String phy_inv_id = "";
			try { 
				result = bean.isPhysicalInventoryProcessStartedForStore(itemcode,fromStore,toStore);
				if(result){
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,fromStore}).get("PHY_INV_ID");
						if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,toStore}).get("PHY_INV_ID");
			
						out.println("document."+formname+".phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				String use_after_expiry_yn =(String)bean.fetchRecord("select USE_AFTER_EXPIRY_YN from st_item where item_code =?",new String[]{item_code}).get("USE_AFTER_EXPIRY_YN");
				double avail_stock=0;												
				if(use_after_expiry_yn.equals("Y")){
					avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")));
				}else{
					avail_stock=(double)(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")));  
				}
				allow_decimals_yn=(String)hmStockAvailabilityStatus.get("allow_decimals_yn");
				String  storeItemUnitCost=bean.getUnitCost(itemcode,fromStore);
                out.println("document."+formname+".p_fm_item_desc.value = '"+item_desc1+"';");
				out.println("document."+formname+".p_fm_item_desc.readOnly = true;");
				out.println("document."+formname+".fm_trade_id_applicable_yn.value = '"+trade_id_applicable_yn+"';");
				out.println("document."+formname+".fm_item_code.value = '"+item_code+"';");
				out.println("document."+formname+".fm_uom_code.value = '"+uom_code+"';");
				out.println("document."+formname+".fm_item_unit_cost.value = '"+storeItemUnitCost+"';");
				out.println("document."+formname+".fm_barcode.value = '"+bar_code+"';");  
				out.println("document."+formname+".manufacturer_id.value = '"+manufacturer_id+"';"); 
				out.println("document."+formname+".supplier_id.value = '"+supplier_id+"';");  
				out.println("document."+formname+".mrp.value = '"+mrp+"';");  
				
				//HashMap bin_desc=	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_BIN_LOCN_SELECT_LIST"),new String[]{fromStore,item_code,locale});
				HashMap bin_desc=    bean.fetchRecord("SELECT st.bin_location_code, mm.short_desc FROM st_item_store_bin_locn st, mm_bin_location_lang_vw mm WHERE st.store_code=mm.store_code AND  st.bin_location_code=mm.bin_location_code AND st.store_code=? AND st.item_code=? AND st.bin_location_code = ? AND mm.eff_status ='E' AND mm.language_id = ? and st.eff_status = 'Y' ORDER BY short_desc",new String[]{fromStore,item_code,binlocation,locale});
			  System.out.println("bin_desc======>" +bin_desc);
				
				String bin_short_desc = bean.checkForNull((String)bin_desc.get("SHORT_DESC"));
				//System.out.println("bin_short_desc 212" +bin_short_desc);
				HashMap TRADE_NAME =	bean.fetchRecord("SELECT a.trade_id, b.short_name FROM MM_TRADE_NAME_FOR_ITEM a, AM_TRADE_NAME b WHERE a.trade_id = b.trade_id AND b.eff_status = 'E' AND item_code =?  ORDER BY short_name",new String[]{item_code});
				//System.out.println("TRADE_NAME 216" +TRADE_NAME);
				String trade_name = (String)TRADE_NAME.get("SHORT_NAME");
			   //System.out.println("trade_name 216" +trade_name);
			   String nod =(String)bean.fetchRecord("select NOD from st_batch_search_lang_view where ITEM_CODE =? AND EXPIRY_DATE = TO_DATE (?, 'dd/mm/yyyy') AND BATCH_ID =? AND TRADE_ID =? AND BIN_LOCATION_CODE =? AND LANGUAGE_ID =? AND LANG1 =? AND LANG2 =?",new String[]{item_code,expirydate,batchid,tradeid,binlocation,locale,locale,locale}).get("NOD");
			   
		out.println("BarcodeApply('"+uom_desc+"','"+binlocation+"','"+batchid+"','"+expirydate+"','"+tradeid+"','"+availqty+"','"+bin_short_desc+"','"+nod+"','"+expiry_yn+"','"+trade_name+"')");
				if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y"))
				{
					if( hmStockAvailabilityStatus.get("available_stock").equals("0"))
						throw new Exception("STOCK_NOT_AVAILABLE");
				} else
					throw new Exception("NOT_STOCK_ITEM");		
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
				//System.out.println("message.... "+message);	
                					 			
			}
			}else{
			//out.println("document."+formname+".bar_or_item_code.value = 'I';");
			//out.println("document."+formname+".BARCODE_YN.value = 'TRUE';");			
			out.println("callItemSearchScreenFrom()");
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
	if(validate.equals("SET_REPORT")) {
	 String  report_id      =  bean.checkForNull(request.getParameter("report_id"));
	 //System.out.println("report_id" +report_id);
	 bean.setReport_id(report_id);
	 //System.out.println("setReport_id=====>" +bean.getReport_id());

      }	
//ends

	}

	catch (Exception exception) {
		result	=	false;
		message	=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%>
<%
putObjectInBean("ProductTransferBean",bean,request);
%>
