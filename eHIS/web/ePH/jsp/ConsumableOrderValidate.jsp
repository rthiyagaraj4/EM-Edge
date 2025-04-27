
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
07/09/2017	    IN:065199	        Mukesh M	                                        Remarks added in Two lines shown in single line while clicking confirm button for medical item  
07/01/2019		IN068345		    Devindra				 		                    Required changes in item substitute mapping setup
29/05/2020		IN:072092	        Manickavasagam J			     GHL-CRF-0618
03/10/2023	  	50818  			    Himanshu 						GHL-SCF-1738 					GHL-SCF-1738 
----------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/
%>
<%@page  import="java.sql.*,java.text.DecimalFormat, java.util.*, java.io.*, ePH.Common.*, eOR.Common.*, ePH.*, eOR.*, com.ehis.util.*  " %>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%-- Mandatory declarations end --%>
<jsp:useBean id="xmlObj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
	String validate			= request.getParameter("validate")==null?"":request.getParameter("validate");
	Hashtable hash			= (Hashtable)xmlObj.parseXMLString( request ) ;
    hash					= (Hashtable)hash.get( "SEARCH" ) ;
	String bean_id			= request.getParameter( "bean_id" );
	String bean_name		= request.getParameter( "bean_name" );
	ConsumableOrderBean bean		=	(ConsumableOrderBean)getBeanObject( bean_id, bean_name, request ) ;
	String preferredDrug = request.getParameter("preferredDrug") == null?"":request.getParameter("preferredDrug");
	if(validate.equals("storeSelectedItemLKP")){
		bean.storeSelectedItem(hash);
		HashMap ht=(HashMap)bean.getSelectedItems();
		if (preferredDrug.equals("")){
			if (ht.size()>0){
			
				
		        
		        out.println("enableDisableSelectButton('false');");
		       
			}
			else{
				out.println("enableDisableSelectButton('true')");
			}
		}
		else{
			if (ht.size()>0){
				out.println("enableDisableSelectButton_preferred('false')");
			}
			else{
				out.println("enableDisableSelectButton_preferred('true')");
			}
		}
	}
	else if(validate.equals("getSelectedDrugs")){
		
		HashMap ht=(HashMap)bean.getSelectedItems();
		out.println("returnItems('"+ht.values()+"')");
		bean.setSelectedItems();
	}
	else if(validate.equals("addItemsForOrder")){
		String itemCodes	= (String) hash.get( "itemCodes" )==null?"":(String) hash.get( "itemCodes" );
		String tradeCodes	= (String) hash.get( "tradeCodes" )==null?"":(String) hash.get( "tradeCodes" );
		String tradeNames	= (String) hash.get( "tradeNames" )==null?"":(String) hash.get( "tradeNames" );
		String bl_install_yn		= (String) hash.get( "bl_install_yn" )==null?"":(String) hash.get( "bl_install_yn" );
		String available_stock	=	(String) hash.get( "available_Qty" )==null?"0":(String) hash.get( "available_Qty" ); //<!--//Added By Himanshu for GHL-SCF-1738-->
		String bl_disp_charge_dtl_in_rx_yn	= (String) hash.get( "bl_disp_charge_dtl_in_rx_yn" )==null?"":(String) hash.get( "bl_disp_charge_dtl_in_rx_yn" );
		String take_home_medication	= (String) hash.get( "take_home_medication" )==null?"":(String) hash.get( "take_home_medication" );
		String priority	= (String) hash.get( "priority" )==null?"":(String) hash.get( "priority" );
		String pract_id	= (String) hash.get( "pract_id" )==null?"":(String) hash.get( "pract_id" );
		String resp_id	= (String) hash.get( "resp_id" )==null?"":(String) hash.get( "resp_id" );
		String episode_type	= (String) hash.get( "episode_type" )==null?"":(String) hash.get( "episode_type" );
		String patient_id	= (String) hash.get( "patient_id" )==null?"":(String) hash.get( "patient_id" );
		String encounter_id	= (String) hash.get( "encounter_id" )==null?"":(String) hash.get( "encounter_id" );
		String tradeCodesArr[] = tradeCodes.split(",");
		String tradeNamesArr[] = tradeNames.split(",");
		String item_code="";
		String item_desc="";
		String trade_code="";
		String trade_name="";
		int trade_count=0;
		//String locale= bean.getLanguageId();	//Commented for Checkstyle
		itemCodes = itemCodes.replace('[',' ');
		itemCodes = itemCodes.replace(']',' ');
		StringTokenizer stTtemCodes = new StringTokenizer(itemCodes.trim(),",");
		ArrayList presItemList= null; //added for KDAH-SCF-0326 [IN:056879]-start
		HashMap itemDetail = null;
		String temp_item_code ="";
		boolean dupItemFound = false;
		StringBuffer dupItemCodes = new StringBuffer(); //added for KDAH-SCF-0326 [IN:056879] -end
		
		while(stTtemCodes.hasMoreTokens()){
			item_code	=stTtemCodes.nextToken();
			if(trade_count < tradeCodesArr.length){
				trade_code=tradeCodesArr[trade_count];
				trade_name = tradeNamesArr[trade_count++];
			}
			else{
				trade_code = "";
				trade_name = "";
			}
			presItemList=(ArrayList)bean.getPresItemList(); //added for KDAH-SCF-0326 [IN:056879] -start
			if(presItemList!= null && presItemList.size()>0){
				for(int i=0;i<presItemList.size();i++){			
					itemDetail=(HashMap) presItemList.get(i);
					temp_item_code = (String)itemDetail.get("ITEM_CODE");
					if(temp_item_code.equals(item_code)){
						dupItemFound = true;
						dupItemCodes.append(item_code +", ");
						break;
					}
				}
			}
			if(dupItemFound){
				out.println("alertDupFound('"+dupItemCodes.toString()+"')");
				return;
			}
			else //added for KDAH-SCF-0326 [IN:056879] -end
				bean.loadItemDetail(item_code,"","", trade_code, trade_name, bl_install_yn, bl_disp_charge_dtl_in_rx_yn, take_home_medication, priority, pract_id, resp_id,available_stock); //<!--//param modfied By Himanshu for GHL-SCF-1738 added (available_stock) -->
		}
		presItemList=(ArrayList)bean.getPresItemList();
		if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
			ArrayList blErrorDrugs = new ArrayList();
			String qty_value="";
			String bl_error_code="";
			String bl_sys_message_id="";
			String bl_error_text="";

			for(int i=0;i<presItemList.size();i++){			
				itemDetail=(HashMap) presItemList.get(i);
				item_code = (String)itemDetail.get("ITEM_CODE");
				item_desc = (String)itemDetail.get("ITEM_DESC");
				qty_value	= (String)itemDetail.get("QTY_VALUE"); 
				
				bean.setBillingDetail(itemDetail, episode_type, patient_id, encounter_id, item_code, qty_value,take_home_medication);
				bl_error_code = (String)itemDetail.get("BL_ERROR_CODE")==null?"":(String)itemDetail.get("BL_ERROR_CODE");     
				bl_sys_message_id = (String)itemDetail.get("BL_SYS_MESSAGE_ID")==null?"":(String)itemDetail.get("BL_SYS_MESSAGE_ID"); 
				bl_error_text = (String)itemDetail.get("BL_ERROR_TEXT")==null?"":(String)itemDetail.get("BL_ERROR_TEXT");   
				
				if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
					blErrorDrugs.add(item_code.trim());
					blErrorDrugs.add(item_desc);
					blErrorDrugs.add(bl_error_code);
					blErrorDrugs.add(bl_sys_message_id);
					blErrorDrugs.add(bl_error_text);
				}
			}
			if(blErrorDrugs.size()>0){
				out.println("alertBLErrorDrugs('"+blErrorDrugs+"','BLERROR');");
				for(int i=0; i<blErrorDrugs.size(); i+=5){
					item_code = (String)blErrorDrugs.get(i);
					for(int j=0;j<presItemList.size();j++){			
						itemDetail=(HashMap) presItemList.get(j);
						if(item_code.equals(itemDetail.get("ITEM_CODE"))){
							presItemList.remove(j);
						}
					}
				}
			}
		}
		if(presItemList!=null && presItemList.size()>0){
			out.println("loadItemDetails()");
		}
	}
	else if(validate.equals("confirmItem")){
		String item_code	= (String) hash.get( "item_code" )==null?"":(String) hash.get( "item_code" );
		String trade_code	= (String) hash.get( "trade_code" )==null?"":(String) hash.get( "trade_code" );
		String trade_name	= (String) hash.get( "trade_name" )==null?"":(String) hash.get( "trade_name" );
		String take_home_medication	= (String) hash.get( "take_home_medication" )==null?"":(String) hash.get( "take_home_medication" );
		if(!trade_name.equals(""))
			trade_name=java.net.URLDecoder.decode(trade_name,"UTF-8");
		String qty_value	= (String) hash.get( "qty_value" )==null?"":(String) hash.get( "qty_value" );
		String allow_alternate_yn = (String) hash.get( "allow_alternate_yn" )==null?"":(String) hash.get( "allow_alternate_yn" ); // Added for GHL-CRF-0548 [IN:068345] - Devindra
		String index	= (String) hash.get( "index" )==null?"":(String) hash.get( "index" );
		String bl_install_yn		= (String) hash.get( "bl_install_yn" )==null?"":(String) hash.get( "bl_install_yn" );
		String bl_disp_charge_dtl_in_rx_yn	= (String) hash.get( "bl_disp_charge_dtl_in_rx_yn" )==null?"":(String) hash.get( "bl_disp_charge_dtl_in_rx_yn" );
		String patient_id	= (String) hash.get( "patient_id" )==null?"":(String) hash.get( "patient_id" );
		String encounter_id	= (String) hash.get( "encounter_id" )==null?"":(String) hash.get( "encounter_id" );
		//String patient_class	= (String) hash.get( "patient_class" )==null?"":(String) hash.get( "patient_class" );	//Commented for Checkstyle
		//String priority	= (String) hash.get( "priority" )==null?"":(String) hash.get( "priority" );	//Commented for Checkstyle
		//String pract_id	= (String) hash.get( "pract_id" )==null?"":(String) hash.get( "pract_id" ); //Commented for Checkstyle
		//String resp_id	= (String) hash.get( "resp_id" )==null?"":(String) hash.get( "resp_id" ); //Commented for Checkstyle
		String episode_type	= (String) hash.get( "episode_type" )==null?"":(String) hash.get( "episode_type" );
		String medication_remarks	= (String) hash.get( "medication_remarks" )==null?"":(String) hash.get( "medication_remarks" );//Added for GHL-CRF-470
		ArrayList presItemList=(ArrayList)bean.getPresItemList();
		HashMap itemDetail = null; //added for KDAH-SCF-0326 [IN:056879] -start
		String temp_item_code ="";
           	if(!medication_remarks.equals("")) // Added for IN:065199
		{
             		medication_remarks = java.net.URLDecoder.decode(medication_remarks,"UTF-8"); // Added for IN:065199
		}
		boolean dupItemFound = false;
		StringBuffer dupItemCodes = new StringBuffer();
		if(presItemList!= null && presItemList.size()>0){
			for(int i=0;i<presItemList.size();i++){			
				itemDetail=(HashMap) presItemList.get(i);
				temp_item_code = (String)itemDetail.get("ITEM_CODE");
				if(temp_item_code.equals(item_code) && i!= Integer.parseInt(index)){
					dupItemFound = true;
					dupItemCodes.append(item_code +", ");
					break;
				}
			}
		}
		if(dupItemFound){
			out.println("alertDupFound('"+dupItemCodes.toString()+"')");
			return;
		} //added for KDAH-SCF-0326 [IN:056879] -end
		if(presItemList!=null && presItemList.size()>0 && !index.equals("")){
			itemDetail=(HashMap)presItemList.get(Integer.parseInt(index));
			itemDetail.put("TRADE_CODE", trade_code);
			itemDetail.put("TRADE_NAME", trade_name);
			itemDetail.put("QTY_VALUE", qty_value);
			itemDetail.put("CONFIRMED_YN", "Y");
			itemDetail.put("ALLOW_ALTERNATE_YN", allow_alternate_yn); // Added for GHL-CRF-0548 [IN:068345] - Devindra
			itemDetail.put("ITEM_REMARKS", medication_remarks);//Added for GHL-CRF-0470
			//itemDetail.put("PERFORMING_FACILITY_ID", performingFacilityId); // Commented for IN25955 --18/01/2011-- priya (Perf_facility_id is put on loading the drug itself in bean)
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
				ArrayList blErrorDrugs = new ArrayList();
				String bl_error_code="";
				String bl_sys_message_id="";
				String bl_error_text="";

				bean.setBillingDetail(itemDetail, episode_type, patient_id, encounter_id, item_code, qty_value,take_home_medication);
				bl_error_code = (String)itemDetail.get("BL_ERROR_CODE")==null?"":(String)itemDetail.get("BL_ERROR_CODE");     
				bl_sys_message_id = (String)itemDetail.get("BL_SYS_MESSAGE_ID")==null?"":(String)itemDetail.get("BL_SYS_MESSAGE_ID"); 
				bl_error_text = (String)itemDetail.get("BL_ERROR_TEXT")==null?"":(String)itemDetail.get("BL_ERROR_TEXT");   
				String item_desc = (String)itemDetail.get("ITEM_DESC")==null?"":(String)itemDetail.get("ITEM_DESC");   
				
				if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
					blErrorDrugs.add(item_code.trim());
					blErrorDrugs.add(item_desc);
					blErrorDrugs.add(bl_error_code);
					blErrorDrugs.add(bl_sys_message_id);
					blErrorDrugs.add(bl_error_text);
				}
				if(blErrorDrugs.size()>0){
					out.println("alertBLErrorDrugs('"+blErrorDrugs+"','BLERROR');");
					for(int i=0; i<blErrorDrugs.size(); i+=5){
						item_code = (String)blErrorDrugs.get(i);
						for(int j=0;j<presItemList.size();j++){			
							itemDetail=(HashMap) presItemList.get(j);
							if(item_code.equals(itemDetail.get("ITEM_CODE"))){
								presItemList.remove(j);
							}
						}
					}
				}
			}
		}
	}	
	else if(validate.equals("removeItem")){
		String item_code	= (String) hash.get( "item_code" )==null?"":(String) hash.get( "item_code" );
		String index	= (String) hash.get( "index" )==null?"":(String) hash.get( "index" );
		HashMap itemDetail = new HashMap();

		ArrayList presItemList=(ArrayList)bean.getPresItemList();
		if(presItemList!=null && presItemList.size()>0 && !index.equals("")){
			itemDetail=(HashMap) presItemList.get(Integer.parseInt(index));
			if(item_code.equals((String)itemDetail.get("ITEM_CODE"))){
				presItemList.remove(Integer.parseInt(index));
			}
		}
	}
	else if(validate.equals("deleteBLErrorItems")){
		String itemCodes	= (String) hash.get( "itemCodes" )==null?"":(String) hash.get( "itemCodes" );
		String item_code = "";

		ArrayList presItemList=(ArrayList)bean.getPresItemList();
		HashMap itemDetail = new HashMap();
		itemCodes = itemCodes.replace('[',' ');
		itemCodes = itemCodes.replace(']',' ');
		StringTokenizer stTtemCodes = new StringTokenizer(itemCodes.trim(),",");
		
		while(stTtemCodes.hasMoreTokens()){
			item_code	=stTtemCodes.nextToken();
			for(int j=0;j<presItemList.size();j++){			
				itemDetail=(HashMap) presItemList.get(j);
				if(item_code.equals(itemDetail.get("ITEM_CODE"))){
					presItemList.remove(j);
				}
			}
		}
	}
	else if(validate.equals("release")){
		String facility_id	= (String) hash.get( "facility_id" )==null?"":(String) hash.get( "facility_id" );
		String patient_id	= (String) hash.get( "patient_id" )==null?"":(String) hash.get( "patient_id" );
		String encounter_id	= (String) hash.get( "encounter_id" )==null?"":(String) hash.get( "encounter_id" );
		String patient_class	= (String) hash.get( "patient_class" )==null?"":(String) hash.get( "patient_class" );
		String act_patient_class	= (String) hash.get( "act_patient_class" )==null?"":(String) hash.get( "act_patient_class" );
		String location_type	= (String) hash.get( "location_type" )==null?"":(String) hash.get( "location_type" );
		String location_code	= (String) hash.get( "location_code" )==null?"":(String) hash.get( "location_code" );
		String height	= (String) hash.get( "height" )==null?"":(String) hash.get( "height" );
		String height_uom	= (String) hash.get( "height_uom" )==null?"":(String) hash.get( "height_uom" );
		String weight		= (String) hash.get( "weight" )==null?"":(String) hash.get( "weight" );
		String weight_uom	= (String) hash.get( "weight_uom" )==null?"":(String) hash.get( "weight_uom" );
		String bsa		= (String) hash.get( "bsa" )==null?"":(String) hash.get( "bsa" );
		String bsa_uom	= (String) hash.get( "bsa_uom" )==null?"":(String) hash.get( "bsa_uom" );
		String bmi		= (String) hash.get( "bmi" )==null?"":(String) hash.get( "bmi" );
		String room_num	= (String) hash.get( "room_num" )==null?"":(String) hash.get( "room_num" );
		String bed_num	= (String) hash.get( "bed_num" )==null?"":(String) hash.get( "bed_num" );
		String ordered_date	= (String) hash.get( "order_date_time" )==null?"":(String) hash.get( "order_date_time" );
		String take_home_medication	= (String) hash.get( "take_home_medication" )==null?"":(String) hash.get( "take_home_medication" );
		String priority	= (String) hash.get( "priority" )==null?"":(String) hash.get( "priority" );
		String pract_id	= (String) hash.get( "pract_id" )==null?"":(String) hash.get( "pract_id" );
		String resp_id	= (String) hash.get( "resp_id" )==null?"":(String) hash.get( "resp_id" );

		String item_code	= (String) hash.get( "item_code" )==null?"":(String) hash.get( "item_code" );
		String allow_alternate_yn = (String) hash.get( "allow_alternate_yn" )==null?"":(String) hash.get( "allow_alternate_yn" ); // Added for GHL-CRF-0548 [IN:068345] - Devindra
		String trade_code	= (String) hash.get( "trade_code" )==null?"":(String) hash.get( "trade_code" );
		String trade_name	= (String) hash.get( "trade_name" )==null?"":(String) hash.get( "trade_name" );
		if(!(trade_name.equals("")))
			trade_name = java.net.URLDecoder.decode(trade_name,"UTF-8"); //added for IN24579 --26/10/2010-- priya
		String qty_value	= (String) hash.get( "qty_value" )==null?"":(String) hash.get( "qty_value" );
		String index	=	  (String) hash.get( "index" )==null?	""	:(String) hash.get( "index" );
		String called_from	= (String) hash.get( "called_from" )==null?"":(String) hash.get( "called_from" );
		String bl_install_yn		= (String) hash.get( "bl_install_yn" )==null?"":(String) hash.get( "bl_install_yn" );
		String bl_disp_charge_dtl_in_rx_yn	= (String) hash.get( "bl_disp_charge_dtl_in_rx_yn" )==null?"":(String) hash.get( "bl_disp_charge_dtl_in_rx_yn" );
		String source_type	= (String) hash.get( "source_type" )==null?"":(String) hash.get( "source_type" );
		String source_code	= (String) hash.get( "source_code" )==null?"":(String) hash.get( "source_code" );
		String allow_pres_without_stock_yn	= (String) hash.get( "allow_pres_without_stock_yn" )==null?"":(String) hash.get( "allow_pres_without_stock_yn" );
		//String performingFacilityId	= (String) hash.get( "performingFacilityId" )==null?"":(String) hash.get( "performingFacilityId" );	//Commented for Checkstyle
		//GHL-CRF-0470 start
		String pres_bean_id			 = "@PrescriptionBean_1"+patient_id+encounter_id;
		String pres_bean_name		 = "ePH.PrescriptionBean_1";
		PrescriptionBean_1 pres_bean = (PrescriptionBean_1)getBeanObject(pres_bean_id,pres_bean_name,request) ;
		bean.setPresRemarks(pres_bean.getPresRemarks());
		//GHL-CRF-0470 end
		
		String check_available_qty="";
		String ord_approved_yn = "";
		String ord_authorized_yn = "";
		String auth_reqd_yn = "";
		String apprvl_reqd_yn = "";
		String cosign_reqd_yn = "";
		String order_status = "";
		String selected_yn = "";
		String item_desc = "";

		String episode_type = "";
		ArrayList blErrorDrugs = new ArrayList();
		HashMap itemDetail = null;
		String bl_error_code="";
		String bl_sys_message_id="";
		String bl_error_text="";
		//String medication_remarks="";	//Added for GHL-CRF-0470 //Commented for Checkstyle
		ArrayList OrderID = new ArrayList();
		//String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();//Added for Bru-HIMS-CRF-393_1.0//commented for KAUH-SCF-0229 [IN:056384] 
		if(!act_patient_class.equals(""))
			episode_type = act_patient_class.substring(0,1);
		if(episode_type.equals("X"))
			episode_type="R";

		ArrayList presItemList=(ArrayList)bean.getPresItemList();
		if(presItemList==null || presItemList.size()==0){
			out.println("noItemAlert();");
			return;
		}
		int count=0;
		for(int j=0;j<presItemList.size();j++){
			itemDetail=(HashMap)presItemList.get(j);
			if(((String)itemDetail.get("SELECTED_YN")).equals("N")){
				count++;
			}
		}
		if(count==presItemList.size()){
			out.println("selectOne();");
			return;
		}
		for(int j=0;j<presItemList.size();j++){
			itemDetail=(HashMap)presItemList.get(j);
			if(((String)itemDetail.get("SELECTED_YN")).equals("N")){
				presItemList.remove(j);
				j=j-1;
			}
		}
		if(!item_code.equals("") && !index.equals("") ){
			if(presItemList!=null && presItemList.size()>0 && !index.equals("")){	
				if (Integer.parseInt(index)<presItemList.size()){ //line inseted by changed by kiran 
				itemDetail=(HashMap)presItemList.get(Integer.parseInt(index));
				itemDetail.put("TRADE_CODE", trade_code);
				itemDetail.put("TRADE_NAME", trade_name);
				itemDetail.put("QTY_VALUE", qty_value);
				itemDetail.put("CONFIRMED_YN", "Y");
				itemDetail.put("ALLOW_ALTERNATE_YN", allow_alternate_yn);// Added for GHL-CRF-0548 [IN:068345] - Devindra
			//	itemDetail.put("PERFORMING_FACILITY_ID", performingFacilityId);  // added for IN25723 --05/01/2011-- priya // Commented for IN25955 --18/01/2011-- priya ( Perf_facility_id is put on loading the drug itself in bean)
				}
			}
		}
		if(called_from.equals("TAB")||(called_from.equals("ORDERSET")))
			OrderID=(ArrayList)bean.genOrderID(presItemList.size(),patient_class);

		for(int j=0;j<presItemList.size();j++){
			itemDetail		=(HashMap) presItemList.get(j);
			item_code			=(String) itemDetail.get("ITEM_CODE");
			item_desc			=(String) itemDetail.get("ITEM_DESC");
			ord_approved_yn		=(String) itemDetail.get("ORD_APPROVED_YN")==null?"":(String) itemDetail.get("ORD_APPROVED_YN");
			ord_authorized_yn			=(String) itemDetail.get("ORD_AUTHORIZED_YN")==null?"":(String) itemDetail.get("ORD_AUTHORIZED_YN");
			auth_reqd_yn		=	(String) itemDetail.get("ORD_AUTH_REQD_YN")==null?"":(String) itemDetail.get("ORD_AUTH_REQD_YN");    
			apprvl_reqd_yn	=	(String) itemDetail.get("ORD_SPL_APPR_REQD_YN")==null?"":(String) itemDetail.get("ORD_SPL_APPR_REQD_YN");
			cosign_reqd_yn	=	(String) itemDetail.get("ORD_COSIGN_REQD_YN")==null?"":(String) itemDetail.get("ORD_COSIGN_REQD_YN"); 
			selected_yn	=	(String) itemDetail.get("SELECTED_YN")==null?"":(String) itemDetail.get("SELECTED_YN"); 
			qty_value	=	(String) itemDetail.get("QTY_VALUE")==null?"1":(String) itemDetail.get("QTY_VALUE"); 
			String available_stock	=	(String) itemDetail.get("available_stock")==null?"0":(String) itemDetail.get("available_stock"); //<!--//Added By Himanshu for GHL-SCF-1738-->
			//Added By Himanshu for GHL-SCF-1738 Starts-->
			//if(Float.parseFloat(bean.getOrderQty(ext_drugData,qty_value,sch_size,durn_value,dosage,conv_factor)) > Float.parseFloat(available_stock)) 
			 String[] splitArray = available_stock.split(",");
			for (String s : splitArray) 
	        {
	        	available_stock=s;
	        }
			if(allow_pres_without_stock_yn.equals("N"))
			{
				if(Float.parseFloat(qty_value) > Float.parseFloat(available_stock))
				{
					out.println("alertNoAvailStock()") ;
					check_available_qty="N";
					return;
				}
			}
			//Added By Himanshu for GHL-SCF-1738 Ends-->
			if(!(called_from.equals("TAB")||called_from.equals("ORDERSET"))){
				if(selected_yn==null || !selected_yn.equals("Y")){
					presItemList.remove(j);
					continue;
				}
			}
			if(bl_install_yn.equals("Y") && bl_disp_charge_dtl_in_rx_yn.equals("Y")){
				bean.setBillingDetail(itemDetail, episode_type, patient_id, encounter_id, item_code, qty_value,take_home_medication);
				bl_error_code = (String)itemDetail.get("BL_ERROR_CODE")==null?"":(String)itemDetail.get("BL_ERROR_CODE");     
				bl_sys_message_id = (String)itemDetail.get("BL_SYS_MESSAGE_ID")==null?"":(String)itemDetail.get("BL_SYS_MESSAGE_ID"); 
				bl_error_text = (String)itemDetail.get("BL_ERROR_TEXT")==null?"":(String)itemDetail.get("BL_ERROR_TEXT");   
				
				if ((bl_error_code.equals("10") && (!bl_error_text.equals(""))) ||!bl_sys_message_id.equals("")){
					blErrorDrugs.add(item_code.trim());
					blErrorDrugs.add(item_desc);
					blErrorDrugs.add(bl_error_code);
					blErrorDrugs.add(bl_sys_message_id);
					blErrorDrugs.add(bl_error_text);
				}
			}

			itemDetail.put("FACILITY_ID", facility_id);
			if(OrderID.size()>j)
				itemDetail.put("ORDER_ID", (String)OrderID.get(j));
			itemDetail.put("ORDER_TYPE_CODE", "MS");
			itemDetail.put("PATIENT_ID", patient_id);
			itemDetail.put("ENCOUNTER_ID", encounter_id);
			itemDetail.put("PATIENT_CLASS", patient_class);
			itemDetail.put("LOCATION_TYPE", location_type);
			itemDetail.put("LOCATION_CODE", location_code);
			itemDetail.put("HEIGHT", height);
			itemDetail.put("HEIGHT_UOM", height_uom);
			itemDetail.put("WEIGHT", weight);
			itemDetail.put("WEIGHT_UOM", weight_uom);
			itemDetail.put("BSA", bsa);
			itemDetail.put("BSA_UOM", bsa_uom);
			itemDetail.put("BMI", bmi);
			itemDetail.put("ROOM_NUM", room_num);
			itemDetail.put("BED_NUM", bed_num);
			itemDetail.put("ORDERED_DATE", ordered_date);
			itemDetail.put("TAKE_HOME_MEDICATION", take_home_medication);
			itemDetail.put("PRIORITY", priority);
			itemDetail.put("PRACT_ID", pract_id);
			itemDetail.put("ORD_PRACT_ID", pract_id);
			itemDetail.put("RESP_ID", resp_id);
			itemDetail.put("CONFIRMED_YN", "Y");
			//if(called_from.equals("TAB")){
				itemDetail.put("SOURCE_TYPE", source_type);
				itemDetail.put("SOURCE_CODE", source_code);
			//}
			if(auth_reqd_yn.equals("Y")){
				if(apprvl_reqd_yn.equals("Y")){
					if(ord_approved_yn.equals("Y")){
						itemDetail.put("ORD_APPR_REQD_YN","N");
						order_status	=	"10"; //OS - Ordered
					}
					else{
						if(ord_authorized_yn.equals("Y")){
							order_status	=	"05"; //PS - Pending Spl Approval
						}
						else{
							order_status	=	"03"; //PO - Pending Authorization
						}
					}
				}
				else{
					if(ord_authorized_yn.equals("Y")){
						itemDetail.put("ORD_AUTH_REQD_YN","N");
						order_status	=	"10"; //OS - Ordered
					}
					else{
						order_status	=	"03"; //PO - Pending Authorization
					}
				}
			}
			else{
				if(apprvl_reqd_yn.equals("Y")){
					if(ord_approved_yn.equals("Y")){
						itemDetail.put("ORD_APPR_REQD_YN","N");
						order_status	=	"10"; //OS - Ordered
					}
					else{
						order_status	=	"05"; //PS - Pending Spl Approva
					}
				}
				else{
					order_status	=	"10"; //OS - Ordered
				}
			}
			itemDetail.put("ORDER_STATUS", order_status);
		}
		if(blErrorDrugs.size()>0){
			out.println("alertBLErrorDrugs('"+blErrorDrugs+"','CONFIRM');");
			for(int i=0; i<blErrorDrugs.size(); i+=5){
				item_code = (String)blErrorDrugs.get(i);
				for(int j=0;j<presItemList.size();j++){			
					itemDetail=(HashMap) presItemList.get(j);
					if(item_code.equals(itemDetail.get("ITEM_CODE"))){
						presItemList.remove(j);
					}
				}
			}
			return;
		}
		if((called_from.equals("TAB")||(called_from.equals("ORDERSET"))) && !check_available_qty.equals("N"))
			out.println("calFormApply()");//Commented for Bru-HIMS-CRF-393_1.0//added for KAUH-SCF-0229 [IN:056384] 
			//out.println("calFormApply(\""+print_ord_sht_rule_ind+"\")");//Added for Bru-HIMS-CRF-393_1.0//commented for KAUH-SCF-0229 [IN:056384] 
		else
			out.println("toCloseTopShowModal();");
	}
	else if(validate!= null && validate.equals("clearData")){
		String or_bean_id	    =  "";
		String patient_id	    = (String) hash.get( "patient_id" );
		String encounter_id	    = (String) hash.get( "encounter_id" );
		String pract_type		=  hash.get("pract_type")==null?"":(String) hash.get("pract_type");//Added for ML-BRU-SCF-0958 [IN:042045]
		String order_set_code	= "";
		if(hash.containsKey("order_set_code")){
		   order_set_code	= (String) hash.get( "order_set_code" );
		}
		String or_bean_name	="eOR.OrderEntryBean";
		or_bean_id="@orderentrybean"+patient_id+encounter_id;
		OrderEntryBean orbean = (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
		eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) orbean.getOrderEntryRecordBean();
		String key	= (orbean.getPatientId()+orbean.getEncounterId());
		// Unique key to keep the Value in the Bean
		java.util.HashMap previousValues= (java.util.HashMap)orderEntryRecordBean.getCheckedEntries(key);
		String order_catalog_code 		= orbean.getOrderCatalogCode(previousValues,"PH", pract_type); //Added for ML-BRU-SCF-0958 [IN:042045]
		ArrayList ordeCatalogCode = new ArrayList();
		if(order_catalog_code != null && !order_catalog_code.equals("")){/*	Added on 07 Sep 2007, to handle the multiple occurance of a same drug from orderset.*/
			StringTokenizer token = new StringTokenizer(order_catalog_code, ",");
			StringTokenizer catalogdetail;
			String temp;
			while(token.hasMoreTokens()){
				temp = token.nextToken();
				if(temp.indexOf("#")!= -1){
					catalogdetail = new StringTokenizer(temp, "#");
					while(catalogdetail.hasMoreTokens()){
						ordeCatalogCode.add(catalogdetail.nextToken());
					}
				}
				else{
					ordeCatalogCode.add(temp);
					ordeCatalogCode.add("1");
					ordeCatalogCode.add("PH");
				}

			}
		}
		String checkedKey	=	null;
		for(int i=0;i<ordeCatalogCode.size();i+=3){
			checkedKey=(String) ordeCatalogCode.get(i);
			orderEntryRecordBean.removeCheckedEntries (key,"ck"+checkedKey);
			orderEntryRecordBean.removeCheckedEntries (key,"h1"+checkedKey);
			orderEntryRecordBean.removeCheckedEntries (key,"h2"+checkedKey);
			if(!order_set_code.equals("")){			//code written  on 9/1/2005 for orderset reloading problem
				orderEntryRecordBean.removeCheckedEntries (key,"ck"+order_set_code);
				orderEntryRecordBean.removeCheckedEntries (key,"h1"+order_set_code);
				orderEntryRecordBean.removeCheckedEntries (key,"h2"+order_set_code);
			}
		}
		ArrayList arrCheckCatalog = (java.util.ArrayList)orderEntryRecordBean.getOrderFormats("CK_CODE",("CK_CODE_0"));
		String removable_catalog_code="";
		int index=0;
		if(arrCheckCatalog!=null){
			for(int i=0;i<ordeCatalogCode.size();i+=3){
				checkedKey=(String) ordeCatalogCode.get(i);
				removable_catalog_code= "ck"+checkedKey;
				 index=0;
				if(arrCheckCatalog.contains(removable_catalog_code)){
					index			  =	arrCheckCatalog.indexOf(removable_catalog_code);
					if(index!=-1){ // If found
						if(((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
							arrCheckCatalog.remove(index);
					}
				} 				
			} 
			if(!order_set_code.equals("")){/*	code wriien   on 9/1/2005 for orderset reloading problem */
			   removable_catalog_code= "ck"+order_set_code;
				if(arrCheckCatalog.contains(removable_catalog_code)){
					 index			  =	arrCheckCatalog.indexOf(removable_catalog_code);
				}
				if(((String)arrCheckCatalog.get(index)).equalsIgnoreCase(removable_catalog_code))
					arrCheckCatalog.remove(index);
			}
			if(arrCheckCatalog.size() > 0){
				orderEntryRecordBean.setOrderFormats("CK_CODE", ("CK_CODE_0"),arrCheckCatalog);
			}
			else{
				orbean.setRefreshYn("Y");
			}
		}
		bean.clear();
		putObjectInBean(or_bean_id,orbean,request);	
	}
	else if(validate.equals("setSelected_yn")){
		String chk_Select	= (String) hash.get( "chk_Select" )==null?"":(String) hash.get( "chk_Select" );
		String index	= (String) hash.get( "index" )==null?"":(String) hash.get( "index" );
		ArrayList presItemList=(ArrayList)bean.getPresItemList();
		if(presItemList!=null && presItemList.size()>0 && !index.equals("")){
			HashMap itemDetail=(HashMap)presItemList.get(Integer.parseInt(index));
			itemDetail.put("SELECTED_YN", chk_Select);
		}
	}
	else if(validate.equals("cancel")){
		bean.clear();
	}
	else if ( validate.equals("GET_TRNGROUPREF")){
		String tokens_generated_yn = bean.getTokensGeneratedYN();
		String trn_group_ref = "";
		if(tokens_generated_yn.equals("Y")){
			trn_group_ref = bean.getTrnGroupRef();
		}
		out.println(trn_group_ref);
	}
	else if ( validate.equals("onLinePrinting")){// Code added for printing prescription for Medical Items --IN23133-- 18/08/2010-- priya
		String locn_code	= (String) hash.get( "locn_code" );
		String patient_class= (String) hash.get( "patient_class" );
		String prescriptionPrint	= (String) hash.get("prescriptionPrint");
		if(prescriptionPrint.equals("Y")){
			ArrayList OrderID = new ArrayList();
			OrderID = bean.getOrderID();

			boolean	printed =(boolean)bean.doPrinting(request,response,locn_code,patient_class,prescriptionPrint);
			if(!printed){
				out.println("alert('APP-PH001 Error during print. Please check Application log for detail.');");
			}
			bean.clear();
		}
	}
	else if ( validate.equals("setPriorityforMI")){ //added for IN26242 --02/02/2011-- priya
		String priority		= (String) hash.get( "priority" );
		bean.setPriority(priority);
	}
	else if(validate.equals("GetPrintOrdShtRuleInd")){//added for KAUH-SCF-0229 [IN:056384] 
		String print_ord_sht_rule_ind=bean.getPrintOrdShtRuleInd();
		out.println(print_ord_sht_rule_ind);			
	}
	//GHL-CRF-0470 starts
	else if(validate.equals("itemRemarks")){
		//String item_code	= (String) hash.get( "item_code" )==null?"":(String) hash.get( "item_code" ); //Commented for Checkstyle
		String index	= (String) hash.get( "index" )==null?"":(String) hash.get( "index" );
		String medication_remarks	= (String) hash.get( "medication_remarks" )==null?"":(String) hash.get( "medication_remarks" ); 
		ArrayList presItemList=(ArrayList)bean.getPresItemList();
		if(presItemList!=null && presItemList.size()>0 && !index.equals("")){
			HashMap itemDetail=(HashMap)presItemList.get(Integer.parseInt(index));
			medication_remarks = java.net.URLDecoder.decode(medication_remarks,"UTF-8"); // Added for 65199	
			itemDetail.put("ITEM_REMARKS", medication_remarks);
			System.err.println("itemDetail===>"+itemDetail);
		}
	}
	//GHL-CRF-0470 ends
	else if(validate.equals("saveSelectedDrug")){ // Added for  GHL-CRF-0548 [IN:068345] - Start - Devindra
		String item_code	       = (String) hash.get( "item_code" )==null?"":(String) hash.get( "item_code");
		String item_tech_code      = (String) hash.get( "item_tech_code" )==null?"":(String) hash.get( "item_tech_code");
		String act_patient_class   = (String) hash.get( "act_patient_class" )==null?"":(String) hash.get( "act_patient_class");	
		String index               = (String) hash.get( "index" )==null?"":(String) hash.get( "index");
		String promptAlert         = (String) hash.get( "promptAlert" )==null?"":(String) hash.get( "promptAlert");
		if(bean.getAltItemClicked(item_code)!="Y"){
			bean.setAltItemClicked(item_code);
			out.println("displayAlternateItem('"+item_code+"','"+item_tech_code+"','"+act_patient_class+"');");
		}
		else{
			out.println("selectItemIfAltItemNotAppl('"+index+"','"+promptAlert+"');");
		}
	} // Added for  GHL-CRF-0548 [IN:068345] - End - Devindra
	else if(validate != null && validate.equals("nonPreferenceRemarks")){ //added for GHL-CRF-0618- start
			String patient_id		= (String) hash.get("patient_id");
			String item_code		= (String) hash.get("item_code");
			String remarks_code		= (String) hash.get("remarks_code");
			bean.setNonPrefernceRemarksMedicalItem(item_code,remarks_code);
			out.println("closeRemarksWindow()");

		}
	putObjectInBean(bean_id,bean,request);
%>
