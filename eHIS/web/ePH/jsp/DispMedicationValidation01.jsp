<%@page import="com.ehis.util.BundleMessage"%> 
<%@page import="org.jgroups.Message"%>
 <%@page contentType="text/html;charset=UTF-8" import="java.util.*, ePH.*, ePH.Common.*, eCommon.Common.*,java.text.DecimalFormat,eST.*,eST.Common.*,java.sql.*,webbeans.eCommon.*,eXH.*" %> 
<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History       Name			Description
--------------------------------------------------------------------------------------------------------------
?				100					?           created
09/08/2019      IN070605		 prathyusha  MMS-KH-CRF-0028
29/08/2020		IN073787		 shazana		ML-BRU-SCF-2047
09/11/2020		7405		 Manickavasagam			SKR-SCF-1459
29/11/2020  	IN:7977	        	Manickavasagam J                 SKR-SCF-1483
16/03/2021   IN15562         Manickavasagam J	 	   		 ML-MMOH-SCF-1741
26/04/2021   16820         Manickavasagam J	 	   		 MMS-KH-CRF-0038.1
06/01/2021	 TFS-25868		Prabha				GHL-CRF-0627
---------------------------------------------------------------------------------------------------------------
*/ %>
<%
	request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE"); 
   Connection con			= null;  // Added for ML-MMOH-crf-0468 start
    
    // Added for ML-MMOH-CRF-0468 - End
	
	boolean siteTpnStd =false;
	boolean siteTpn =false;
	boolean is_site_drug_label = false;
	boolean disp_sheet_check=false; //Added for GHL-CRF-0627
		
		java.util.Properties prop = (java.util.Properties) session.getValue( "jdbc" ) ; //added for IN070867
		String login_at_ws_no		        = prop.getProperty( "client_ip_address" );//added for IN070867
		String func_mode			= request.getParameter("func_mode");
	try {	
		con				= ConnectionManager.getConnection(request);
		siteTpn = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_MF_LABEL");// Added for ML-MMOH-CRF-0468 		
	    siteTpnStd = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
		is_site_drug_label = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DRUG_LABEL_FORMAT");// added for ARYU-CRF-0014
		disp_sheet_check = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","DISP_SHEET_CHECK");  //Added for GHL-CRF-0627
	}
	catch (Exception e) {
		out.println("alert(\"" + e + "\");") ;
		e.printStackTrace();
	}
	finally{ // Added for ML-MMOH-SCF-0468 start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-SCF-0468 end	
		
		
		if (func_mode==null) func_mode="";
		Hashtable hash				= (Hashtable)xmlObj.parseXMLString( request ) ;
		String bean_id				=	"";
		String bean_name			=	"";
		if(hash.containsKey("SEARCH")) {
			hash				= (Hashtable)hash.get( "SEARCH" ) ;
			bean_id				= (String) hash.get( "bean_id" );
			if (bean_id==null) 	bean_id			= "";
			bean_name			= (String) hash.get( "bean_name" );
			if (bean_name==null) bean_name		= "";
		}

		if(bean_id.equals("")){
			bean_id = request.getParameter("bean_id") == null?"":request.getParameter("bean_id") ;
			bean_name = request.getParameter("bean_name")== null?"":request.getParameter("bean_name") ;
		}

		DispMedicationAllStages beanObj =null;
		if (!bean_name.equals("")){
			beanObj		= (DispMedicationAllStages)getBeanObject(bean_id,bean_name,request);
			beanObj.setLanguageId(locale);
		}
		if(func_mode!= null && func_mode.equals("stock_items")){ 
			String patient_id		= (String) hash.get("patient_id");
			String order_id			= (String) hash.get("order_id");
			String order_line_no	= (String) hash.get("order_line_no");
			String drug_code		= (String) hash.get("drug_code");
			String alt_drug_code	= (String) hash.get("alt_drug_code");
			String totalRecords		= (String) hash.get("totalRecords");
			String source			= (String) hash.get("source");
			String recno			= (String) hash.get("recno");	
			String item_cost		= (String) hash.get("item_cost");	
			String oper_mode		= (String) hash.get("oper_mode");
			String multi_strength	=	"N";
			if(source==null)	source	=	"";
			int tot_recs			= Integer.parseInt(totalRecords);
			//String tmp_drug_code	= "";

			/*if(alt_drug_code.equals(""))
				tmp_drug_code		=	drug_code;	
			else
				tmp_drug_code		=	alt_drug_code;	*/
			DispMedicationBean beanObj_1	= (DispMedicationBean)getBeanObject("DispMedicationBean", "ePH.DispMedicationBean", request);

			if((beanObj_1.getDispStage().equals("F")&&(beanObj_1.getDispLocnCatg().equals("O")))|| beanObj_1.getFillList().equals("AF")){ 
				beanObj_1.setValuesChanged(true);
			}
			
			ArrayList drug_detail	=	new ArrayList();
			String	item_drug_code		=	null;
			String	item_drug_color		=	null;
			String	batch_id			=	null;
			String	expiry_date			=	null;
			String	issue_qty			=	null;	
			String	qty_uom				=	null;
			String	trade_id			=	null;
			String	bin_locn_code		=	null;
			String	select				=	null;
			String  issue_uom_qty		=	null;
			String  issue_uom_uom		=	null;
			String  issue_uom_desc		=	"";
			String  issue_uom_equl      =   "";
			String  alt_drug_sel        =   "N";
			String  altdrug_no			= 	"";
			String base_uom = "", issue_uom = "", disp_uom = "";
			double base_to_disp_uom_equl=0, base_to_def_uom_equl=0;
			double conv_factor			   = 1;
			double qty					=	0;
			//added for ML-BRU-SCF-2047
			//double qty_tmp					=	0;
			//double qty_totl					=	0;
			//END 
			double  tot_issue_uom_qty		=	0;
			String temp_issue_qty ="";//Added for ML-BRU-SCF-1803
			String bar_code_scan_site_YN  = beanObj_1.getBarcodeSiteYN();//Added for MMS-DM-CRF-0157.1
			String scan_count_required_yn="",alert_required_yn="",remarks_required_yn="",act_patient_class="";//Added for MMS-DM-CRF-0170
			//Added for KDAH-CRF-0231 [IN-034551].
			if(hash.get("alt_drg_no").equals("")){
			    altdrug_no="0";
			}
			else{
			    altdrug_no=hash.get("alt_drg_no").toString();
			}
			HashMap scaned_data = new HashMap();//Added for MMs-Dm-CRF-0157.1
			 String temp_batch_id="";//Added for MMs-Dm-CRF-0157.1
			 String entry_type= "";//Added for MMs-Dm-CRF-0157.1
			 String scan_key="";//Added for MMs-Dm-CRF-0157.1
             String scan_count_inc="";//Added for MMS-DM-CRF-0157.1
			int  alt_drg_no           =   Integer.parseInt((String) hash.get("alt_drg_no")==null?"0":altdrug_no );           
			ArrayList TPN_Det		=	new ArrayList();//added for ml-mmoh-crf-0468
			for(int i=0; i<tot_recs; i++)	{
				item_drug_code		=	(String) hash.get("item_drug_code"+i);
				item_drug_color		=	(String) hash.get("item_drug_color"+i);
				batch_id			=	(String) hash.get("batch_id"+i);
				expiry_date			=	(String) hash.get("expiry_date"+i);
				issue_qty			=	(String) hash.get("issue_qty"+i);
				qty_uom				=	(String) hash.get("issue_uom"+i);
				trade_id			=	(String) hash.get("trade_id"+i);
				bin_locn_code		=	(String) hash.get("bin_locn_code"+i);
				select				=	(String) hash.get("select"+i);
				issue_uom_qty 		=	(String) hash.get("issue_uom_qty"+i);
				issue_uom_uom 		=	(String) hash.get("issue_uom_uom"+i);
				issue_uom_desc		=	(String) hash.get("issue_uom_desc"+i);
				issue_uom_equl      =   (String) hash.get("issue_uom_equl"+i);
				base_uom      =   (String) hash.get("base_uom"+i);
				issue_uom      =   (String) hash.get("issue_uom"+i);
				disp_uom      =   (String) hash.get("disp_uom"+i);
				base_to_disp_uom_equl      =  Double.parseDouble((String) hash.get("base_to_disp_uom_equl"+i));
				base_to_def_uom_equl      =   Double.parseDouble((String) hash.get("base_to_def_uom_equl"+i));
				temp_issue_qty            =issue_qty;//Added for ML-BRU-SCF-1803
				//Added for KDAH-CRF-0231 [IN-034551].
				 beanObj_1.getTempStockDtls().put(item_drug_code,item_drug_code);
				 beanObj_1.setStockDtlKey("allocated"+item_drug_code+batch_id,item_drug_code);
				//Added for KDAH-CRF-0231 [IN-034551].
			//if(qty_uom==null)		qty_uom		=	"";

				if(select.equals("Y") && !issue_qty.equals(""))	{
					if( !disp_uom.equals(base_uom) && !alt_drug_code.equals("") ){//added for ML-BRU-SCF-1433 [IN:051291] Start
						conv_factor    = beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
						tot_issue_uom_qty  =  Math.ceil(((Math.ceil(Double.parseDouble(issue_qty)/conv_factor))*(conv_factor))/base_to_disp_uom_equl); 
						//modified for ML-BRU-SCF-2047
						//qty_totl = tot_issue_uom_qty + qty_tmp;
						//issue_qty = String.valueOf(qty_totl);	//END				 
				           

beanObj.setAlternateDrugQtyForCharge(patient_id,order_id,order_line_no,alt_drug_code,tot_issue_uom_qty+"");//Added for ML-BRU-SCF-1803 and changed issue_qty to tot_issue_uom_qty for ML-MMOH-SCF-1741
					}//added for ML-BRU-SCF-1433 [IN:051291] End
					drug_detail.add(item_drug_code);
					drug_detail.add(batch_id);
					drug_detail.add(expiry_date);
					drug_detail.add(Double.valueOf(temp_issue_qty).intValue() +"");//changed for ML-BRU-SCF-1433 [IN:051291] changed issue_qty to temp_issue_qty for ML-BRU-SCF-1803
					if( !disp_uom.equals(base_uom)) // if-else Commented for [IN:051261]//else,else if conditions are added for ML-BRU-SCF-1641 [IN:056918]
						drug_detail.add(disp_uom);
					else if(!disp_uom.equals(issue_uom))
						drug_detail.add(disp_uom);//drug_detail.add(issue_uom);//issue_uom is changed to disp_uom for - MMS-MD-SCF-0011 (this disp_uom will save in ph_disp_dtl table)
					else					
						drug_detail.add(issue_uom);// Added for [IN:051261]
					drug_detail.add(item_drug_color);
					drug_detail.add(trade_id);
					drug_detail.add(bin_locn_code);
					drug_detail.add(item_cost);
					drug_detail.add(base_uom);
					qty	 =	qty + Double.parseDouble(issue_qty);//COMMENTED FOR ML-BRU-SCF-2047 and removed for SKR-SCF-1459 & 1460
				//added for ML-BRU-SCF-2047 and removed for SKR-SCF-1459 & 1460
					/*qty	 =	 Double.parseDouble(temp_issue_qty);
					qty_tmp = qty + qty_tmp;//END
					*/
					if(issue_uom_qty != null && !issue_uom_qty.equals("")){
						tot_issue_uom_qty  +=	Double.parseDouble(issue_uom_qty);
					}
				}
		//added for ml-mmoh-crf-0468 start
			if(siteTpn){	
				  TPN_Det.add(order_id);
					TPN_Det.add("1");
					TPN_Det.add(item_drug_code);  
					TPN_Det.add(issue_qty);      //
					TPN_Det.add(issue_uom);     
					TPN_Det.add(drug_code);    
					TPN_Det.add(issue_qty);   
					TPN_Det.add(issue_uom);          
					TPN_Det.add(batch_id);          
					TPN_Det.add(expiry_date);      
					TPN_Det.add(trade_id);      
					TPN_Det.add(bin_locn_code);  
					TPN_Det.add(issue_qty);         
					TPN_Det.add(disp_uom); 
					System.out.println("TPN_Det"+TPN_Det);} //added for ml-mmoh-crf-0468 end
			}
		//added for ml-mmoh-crf-0468 start
			if(siteTpn)	{
			beanObj.setTPNValues(drug_detail);
				
			beanObj.setTPNDetails(TPN_Det);}
				//added for ml-mmoh-crf-0468 end
			if( !disp_uom.equals(base_uom) ){//changed from else if to if for ML-BRU-SCF-1433 [IN:051291] 
				conv_factor    = beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
				tot_issue_uom_qty  =  Math.ceil(((Math.ceil(qty/conv_factor))*(conv_factor))/base_to_disp_uom_equl); 
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_qty",tot_issue_uom_qty+"");
				if(!alt_drug_code.equals("")){//added for AAKH-SCF-0338
					beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_uom",disp_uom);
				}
				qty_uom = disp_uom;
				qty = tot_issue_uom_qty;
				if(issue_uom_equl!=null && !issue_uom_equl.equals("") && Double.parseDouble(issue_uom_equl)>0) //Added for  MMS_BETA_0054 [IN:046305]
					tot_issue_uom_qty = Math.ceil(tot_issue_uom_qty/Double.parseDouble(issue_uom_equl));
			}
			else if( base_to_disp_uom_equl!=base_to_def_uom_equl){//changed from  if to else if for ML-BRU-SCF-1433 [IN:051291] 
				conv_factor    = beanObj.lcm( base_to_disp_uom_equl,base_to_def_uom_equl);
				if( !disp_uom.equals(base_uom)){
					tot_issue_uom_qty  =  Math.ceil((Math.ceil(tot_issue_uom_qty/conv_factor)*(conv_factor))/base_to_disp_uom_equl); 
					qty_uom = disp_uom;
					qty = tot_issue_uom_qty;
					if(issue_uom_equl!=null && !issue_uom_equl.equals("") && Double.parseDouble(issue_uom_equl)>0) //Added for  MMS_BETA_0054 [IN:046305]
						tot_issue_uom_qty = Math.ceil(tot_issue_uom_qty/Double.parseDouble(issue_uom_equl));
				}
				else{
					tot_issue_uom_qty  =  Math.ceil((Math.ceil(tot_issue_uom_qty/conv_factor)*(conv_factor))/base_to_def_uom_equl); 
					qty_uom = base_uom;
					//qty = tot_issue_uom_qty;
				}
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_qty",tot_issue_uom_qty+"");
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_uom",issue_uom);
			/*} //commented else if for ML-BRU-SCF-1433 [IN:051291] 
			else if( !disp_uom.equals(base_uom) ){
				tot_issue_uom_qty  =  Math.ceil(((Math.ceil(qty/conv_factor))*(conv_factor))/base_to_disp_uom_equl); 
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_qty",tot_issue_uom_qty+"");
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_uom",disp_uom);
				qty_uom = disp_uom;
				qty = tot_issue_uom_qty;
				if(issue_uom_equl!=null && !issue_uom_equl.equals("") && Double.parseDouble(issue_uom_equl)>0) //Added for  MMS_BETA_0054 [IN:046305]
					tot_issue_uom_qty = Math.ceil(tot_issue_uom_qty/Double.parseDouble(issue_uom_equl)); */ //commented else if for ML-BRU-SCF-1433 [IN:051291] -end
			}
			else if( !disp_uom.equals(issue_uom_uom) ){ //else if block added for AAKH-SCF-0113 [IN:048937]
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_qty",tot_issue_uom_qty+"");
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_uom",issue_uom_uom);
			}
			else{
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_qty",tot_issue_uom_qty+"");
				beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_uom",issue_uom_uom);
				qty_uom = issue_uom_uom;
				qty = tot_issue_uom_qty;
			}

			beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_desc",issue_uom_desc);
			beanObj.setIssueUomQty(order_id+order_line_no+item_drug_code+"_equl",issue_uom_equl);
			//if(drug_detail.size() >= 1)	{
			if(alt_drug_code.equals("")) {
				beanObj.setDrugDetail(patient_id,order_id,order_line_no,drug_detail);
				beanObj.setDrugQuantity(patient_id,order_id,order_line_no,Math.ceil(qty));
			}
			else	{
				beanObj.setAlternateDrugDetail(patient_id,order_id,order_line_no,drug_detail,alt_drug_code);
				ArrayList tmpArrlist = beanObj.getMultiDrugs(patient_id,order_id,order_line_no);//// Added for [IN-041161]
				beanObj.setMultiDrugs(patient_id,order_id,order_line_no,tmpArrlist);//// Added for [IN-041161]
			}

			if(!alt_drug_code.equals("")){
				multi_strength	=	"Y";
				alt_drug_sel	=   "Y";
				alt_drg_no		=   alt_drg_no+5;
				if(alt_drg_no >= beanObj.getMultiDrugs(patient_id,order_id,order_line_no).size() ){
					alt_drg_no		=	99;
					multi_strength	=	"N";
					qty				=	0;
				}
			}
			qty_uom = beanObj.getUomDisplay((String) session.getValue("facility_id"),qty_uom);
			beanObj_1.setStockDtlKey("autoalloc","Y");//Added for KDAH-CRF-0231 [IN-034551].
			beanObj_1.setStockDtlKey(item_drug_code,qty+"");//Added for KDAH-CRF-0231 [IN-034551].
			beanObj_1.setOrderDrugdtl(order_id+"~"+order_line_no);//Added for KDAH-CRF-0231 [IN-034551].
			//System.err.println("drug_detail.toString()@@@======"+drug_detail);
			//Adding start for MMS-DM-CRF-0157.1
			if(bar_code_scan_site_YN.equals("Y")){
                  //Adding start for MMS-DM-CRF-0170
				  act_patient_class     =  beanObj.getEncounterPatientClass(beanObj_1.getEncounterID(), patient_id);//Added for MMS-DM-CRF-0170
				  if(act_patient_class.equals("I"))
						act_patient_class  ="IP";
					else if(act_patient_class.equals("O"))
						act_patient_class  ="OP";
					else if(act_patient_class.equals("E"))
						act_patient_class  ="EM";
					else if(act_patient_class.equals("D"))
						act_patient_class  ="DC";
					else if(act_patient_class.equals("R"))
						act_patient_class  ="XT";

				  ArrayList scanCountSetup    = beanObj_1.getScanCountReqForPatientClass(act_patient_class,"DISPENSE_MEDICATION");
				  if(scanCountSetup.size()>0){
					  scan_count_required_yn = (String)scanCountSetup.get(0);
					  alert_required_yn      = (String)scanCountSetup.get(1);
					  remarks_required_yn    = (String)scanCountSetup.get(2);
				}//Addign end for MMS-DM-CRF-0170

				 scaned_data = beanObj_1.getBarCodeScanedData();

				 if(drug_detail.size()>0)
				   temp_batch_id =(String)drug_detail.get(1);
				 scan_key=order_id+"~"+order_line_no+"~"+drug_code+"~"+temp_batch_id;
				if(alt_drg_no>0){
					ArrayList manulRemarks =beanObj_1.getManualBarcodeRemarks();
					
					boolean remove_element =false;
					for(int z=0;z<manulRemarks.size();z+=11){
						HashMap scaned_drug =(HashMap)manulRemarks.get(z);
						String existing_order_id =(String)scaned_drug.get("order_id");
						String existing_order_line_no =(String)scaned_drug.get("order_line_no");
						String existing_item_code =(String)scaned_drug.get("item_code");
						String existing_batch_id =(String)scaned_drug.get("batch_id");
						String existing_scan_key =order_id+"~"+order_line_no+"~"+existing_item_code+"~"+existing_batch_id;
						//System.err.println("existing_scan_key@@@===="+existing_scan_key);
						//System.err.println("existing_order_id@@@==="+existing_order_id+"order_id==="+order_id+"existing_order_line_no==="+existing_order_line_no+"order_line_no==="+order_line_no);
						if(existing_order_id.equals(order_id) && existing_order_line_no.equals(order_line_no)){
							//System.err.println("==========in if condition@@@===========");
							if(scaned_data.containsKey(existing_scan_key)){
								beanObj_1.getBarCodeScanedData().remove(existing_scan_key);
								beanObj_1.getManualBarcodeRemarks().remove(z);
								remove_element=true;
							}
						}
						//System.err.println("remove_element@@@==="+remove_element);
						if(!remove_element)
							break;
					}
					

				}
				if(!scaned_data.containsKey(scan_key)){
					beanObj_1.setBarCodeScanedData(scan_key, "M");//Added for MMs-Dm-CRF-0157.1 
					entry_type="M";
					scan_count_inc="Y";
				}else if (scaned_data.containsKey(scan_key)){
					 entry_type =(String)scaned_data.get(scan_key);
				}

				//System.err.println("beanObj_1.getBarCodeScanedData()@@@@==="+beanObj_1.getBarCodeScanedData());
	//	System.err.println("entry_type==="+entry_type+"scan_count_inc==="+scan_count_inc+"alert_required_yn@@@=="+alert_required_yn);
		   if(entry_type.equals("M") && scan_count_inc.equals("Y") && alert_required_yn.equals("Y")){//alert_required_yn addeed for MMS-DM-CRF-0170
			   out.println("callManualScanRemarks('"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+beanObj_1.getDispStage()+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+temp_batch_id+"','"+act_patient_class+"','"+remarks_required_yn+"')");//act_patient_class,remarks_required_yn added for MMS-DM-CRF-0170

		   }else if (entry_type.equals("S") ||(scan_count_required_yn.equals("Y") && alert_required_yn.equals("N"))){
			       
				  out.println("scanBarcodeCount('"+patient_id+"','"+beanObj_1.getEncounterID()+"','"+beanObj_1.getDispStage()+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','"+temp_batch_id+"','"+entry_type+"','"+act_patient_class+"')");//entry_type,act_patient_calss added for MMS-DM-CRF-0170
		   }
		   //Adding end for MMS-DM-CRF-0157.1

		}
			out.println("refreshStockWindow('"+patient_id+"','"+order_id+"','"+order_line_no+"','"+drug_code+"','','"+multi_strength+"','','','','"+qty_uom+"','"+qty+"','"+source+"','"+recno+"','"+oper_mode+"','"+alt_drg_no+"','"+alt_drug_sel+"')");
			//}
			// objects nullified after usage
			drug_detail		=	null;
		}else if(func_mode!= null && func_mode.equals("printPrescription")){ //added for GHL-CRF-0453 - start
			
			String login_user		=	(String)session.getValue("login_user");
			String facility_id		=	(String)session.getValue("facility_id");
			String tot_rec				= (String) hash.get("tot_rec");
			String patient_id			= (String) hash.get("patient_id");
			String patient_class		= (String) hash.get("patient_class");
			String locn_code			= (String) hash.get("locn_code");
			String print_yn				= "";
			ArrayList arrPrint			= new ArrayList();
			int order_cunt = 1;
			String from_order_id = "";
			String to_order_id = "";
			StringBuffer order_ids = new StringBuffer();
			StringBuffer order_catalog_codes = new StringBuffer();
		//	System.err.println("DispMedicationValidation.jsp===4230==tot_rec======>"+tot_rec);
			for(int i=1;i<Integer.parseInt(tot_rec);i++){
				print_yn = (String)hash.get("print_"+i);
				if(print_yn!=null && print_yn.equals("Y")){
					if(order_cunt==1)
					  from_order_id = (String)hash.get("order_id_"+i);
					else if(i==Integer.parseInt(tot_rec)-1)
					  to_order_id = (String)hash.get("order_id_"+i);

					arrPrint.add((String)hash.get("order_id_"+i));
					arrPrint.add((String)hash.get("order_line_num_"+i));
					arrPrint.add((String)hash.get("drug_code_"+i));
					order_cunt++;
				}
			}
			if(arrPrint!=null && arrPrint.size()>0){


				for (int i=0;i<arrPrint.size();i=i+3){
						if(arrPrint.size()==3){
							order_ids.append((String)arrPrint.get(0)+"");
							order_catalog_codes.append((String)arrPrint.get(2)+"");
						}else{
							if(i==(arrPrint.size()-3)){
								order_ids.append((String)arrPrint.get(i)+"");
								order_catalog_codes.append((String)arrPrint.get(i+2)+"");
							}
							else{
								order_ids.append((String)arrPrint.get(i)+"','");
								order_catalog_codes.append((String)arrPrint.get(i+2)+"','");
							}
						}
				}
			}
			beanObj.updatePrintValue(arrPrint);
			String report_id = "PHFILLAL";


		
			ecis.utils.OnlineReports onlineReports 		= new ecis.utils.OnlineReports() ;
//			ecis.utils.OnlineReport report1				= new ecis.utils.OnlineReport(facility_id,"PH",report_id) ;
			ecis.utils.OnlineReport report1	= new ecis.utils.OnlineReport( facility_id, "PH", report_id, "", "", "" , login_at_ws_no ); //added for IN070867				
			report1.addParameter("p_Report_id",report_id) ;
			report1.addParameter("P_USER_NAME",login_user) ;
			report1.addParameter("P_FACILITY_ID",facility_id) ;
			report1.addParameter("p_module_id","PH") ;
			report1.addParameter("p_language_id",locale);
			report1.addParameter("P_LOCNCODE",locn_code) ;
			report1.addParameter("P_FM_ORDER_ID",from_order_id) ;
			report1.addParameter("P_TO_ORDER_ID",to_order_id) ;
			report1.addParameter("p_patient_id",patient_id); 
			report1.addParameter("P_PATCLASS",patient_class) ;
//			report1.addParameter("P_PRINT_YN","Y");
			report1.addParameter("P_ORDER_ID",order_ids.toString());
			report1.addParameter("p_order_catlog",order_catalog_codes.toString());
			

		
			onlineReports.add(report1) ;
			String ReportOutput = onlineReports.execute(request, response );

			report1 = null; 
			
		}//added for GHL-CRF-0453 - end
			//added for IN070605 start
		
 		 		
 		
		putObjectInBean(bean_id,beanObj,request);
	
	
%>  
