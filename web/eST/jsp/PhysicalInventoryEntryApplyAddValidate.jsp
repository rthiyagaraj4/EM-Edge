
<%
/*
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      	Name       	Rev.Date   		Rev.By    	Description
--------------------------------------------------------------------------------------------------------------
20/02/2017		IN0063027		Badmavathi B					GHL-CRF-0413.7 - US005 - Barcode search
---------------------------------------------------------------------------------------------------------------
*/
%>
 <%@page  import=" eST.PhysicalInventoryEntryBean,java.util.Hashtable,java.util.ArrayList,java.util.HashMap"
contentType="text/html;charset=UTF-8"%>  
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<%@ page import= "webbeans.eCommon.*,java.util.*,java.text.*, java.sql.*" contentType="text/html;charset=UTF-8"%>
 

<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<jsp:useBean id="obj123" scope="page" class="eST.PhysicalInventoryEntryBean"/>
<%
	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String facility_id			= (String)session.getAttribute("facility_id");
		
	String bean_id = "PhysicalInventoryEntryBean";
	String bean_name = "eST.PhysicalInventoryEntryBean";
	PhysicalInventoryEntryBean bean = (PhysicalInventoryEntryBean) getBeanObject( bean_id, bean_name,request);  
	bean.setLanguageId(locale);
	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
	String validate = request.getParameter("validate");
	String flag		= "";
	String message	= "";
	boolean result1	= false;

	try{
		if(validate.equals("DATACORRECT")){
			//bean.clear();
			String phy_inv_id	= request.getParameter("phy_inv_id");
			String store_code	= request.getParameter("store_code");
			String item_code	= request.getParameter("item_code");
			//bean.loadDetailPage(phy_inv_id,store_code,item_code);
			System.out.println("here in update block");

				Connection			con 		= null;
				Statement			stmt		= null;
				PreparedStatement pstmt = null;
				try{
					con		= ConnectionManager.getConnection(request);
					String OT_SQL="update st_phy_inv_dtl set entry_completed_yn = 'Y' where item_code in (SELECT DISTINCT a.item_code item_code FROM st_phy_inv_hdr a,st_phy_inv_dtl d, st_item_batch e        WHERE a.phy_inv_id = NVL (?, a.phy_inv_id) AND a.store_code = NVL (?, a.store_code) AND a.facility_id = ? AND a.phy_inv_id =  d.phy_inv_id(+) AND a.store_code = d.store_code(+) AND a.item_code = d.item_code(+)  AND a.item_code = e.item_code(+) AND a.store_code = e.store_code(+) HAVING COUNT (DISTINCT (NVL (d.entry_completed_yn, 'NU'))) > 1 GROUP BY a.phy_inv_id,a.store_code, a.item_code) and phy_inv_id =? ";

					System.out.println("OT_SQL== "+ OT_SQL);
					//stmt	= con.createStatement();

					//int res	= stmt.executeUpdate(OT_SQL);
					pstmt = con.prepareStatement(OT_SQL);
					pstmt.setString(1,phy_inv_id);
					pstmt.setString(2,store_code);
					pstmt.setString(3,facility_id);
					pstmt.setString(4,phy_inv_id);
					int res	= pstmt.executeUpdate();
					System.out.println("res==" + res);
					con.commit();

				}catch ( Exception e ){
					e.printStackTrace() ;
					System.out.println(e.toString());   
				}finally{
					ConnectionManager.returnConnection(con,request);
				}


			result1	=	true;
		}else if(validate.equals("LOADDETAIL")){
			bean.clear();
			String phy_inv_id	= request.getParameter("phy_inv_id");
			String store_code	= request.getParameter("store_code");
			String item_code	= request.getParameter("item_code");
			bean.loadDetailPage(phy_inv_id,store_code,item_code);
			result1	=	true;
		}else if(validate.equals("REFRESHDETAIL")){
			int no_of_decimals = bean.getNoOfDecimals();
			int index	=	Integer.parseInt((String)request.getParameter("prev_index")); 
			String item_code = (String)hash.get("item_code");  // Added by Padmapriya for INC # 29976 on 31/08/2012
			String item_qty ="0"; 
			ArrayList	alRecords	=	new ArrayList();
			HashMap	hmDtlRecord	=	new HashMap();
			int total_rec	=	Integer.parseInt((String)hash.get("total_rec"));
			String entry_completed_yn ="";
           
			for(int i=0;i<total_rec;i++){
				hmDtlRecord.put("ITEM_CODE",(String)hash.get("item_code"));
				hmDtlRecord.put("BATCH_ID",(String)hash.get("batch_id_"+i));
				hmDtlRecord.put("BIN_LOC_CODE",(String)hash.get("bin_loc_code_"+i));
				hmDtlRecord.put("ITEM_QTY",(String)hash.get("item_qty_"+i));
/**
 * @Name - krishna
 * @Date - 20/01/2010
 * @Inc# - 15496
 * @Desc -  Decimal handling in item based.dec_allowed_yn 
 */
                item_qty = ""+(Double.parseDouble(item_qty) + Double.parseDouble(bean.checkForNull((String)hash.get("item_qty_"+i),"0")));
				if((bean.getAllowDecimalsYN((String)hash.get("item_code"))).equals("Y")){
				item_qty=bean.setNumber(item_qty,no_of_decimals);
				}else{
				item_qty=bean.setNumber(item_qty,0);
				}
				hmDtlRecord.put("NEW_BATCH_YN",(String)hash.get("new_batch_YN_"+i));
				hmDtlRecord.put("EXPIRY_DATE",(String)hash.get("expiry_date_"+i));
				hmDtlRecord.put("TRADE_ID",(String)hash.get("trade_id_"+i));
				hmDtlRecord.put("CHECK_YN",(String)hash.get("check_yn_"+i));
				hmDtlRecord.put("ENTRY_COMPLETED_YN",(String)hash.get("entry_completed_yn"));
				hmDtlRecord.put("GEN_UOM_DESC",(String)hash.get("genuom_id_"+i));//Added by suresh.r on 29-07-2014 against MMS-SCF-0390
				///Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 beg
				if(bean.getAllow_eqvl_uom().equals("Y")){
				hmDtlRecord.put("PHY_UOM_CODE",(String)hash.get("uom_code_"+i));
				hmDtlRecord.put("CONV_FACT",(String)hash.get("conv_fact_"+i));
				}
				///Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
				entry_completed_yn = (String)hash.get("entry_completed_yn");
				alRecords.add(hmDtlRecord);
				hmDtlRecord = new HashMap();
			}
			bean.setModRecords(index,alRecords);
			bean.updateModRecords(item_code,alRecords); // Added by Padmapriya for INC # 29976 on 31/08/2012
         
           out.println("colourChange('"+index+"','"+item_qty+"','"+total_rec+"','"+entry_completed_yn+"')");
		 
		}else if(validate.equals("ADDNEW")){
			ArrayList	alRecords	=	new ArrayList();
			int index	=	Integer.parseInt((String)request.getParameter("index"));
			String key_add_batch = request.getParameter("key_add_batch");
			alRecords	=	(ArrayList)bean.getModResult(index);
			
			HashMap	hmDtlRecord	=	new HashMap();
			HashMap	hmRecord	=	new HashMap();

				hmDtlRecord.put("ITEM_CODE",(String)request.getParameter("item_code"));
				hmDtlRecord.put("BATCH_ID",(String)request.getParameter("batch_id"));
				hmDtlRecord.put("BIN_LOC_CODE",(String)request.getParameter("bin_loc_code"));
				hmDtlRecord.put("ITEM_QTY",(String)request.getParameter("item_qty"));
				hmDtlRecord.put("EXPIRY_DATE",(String)request.getParameter("expiry_date"));
				hmDtlRecord.put("NEW_BATCH_YN",(String)request.getParameter("new_batch_yn"));
				hmDtlRecord.put("TRADE_ID",(String)request.getParameter("trade_id"));
				hmDtlRecord.put("GEN_UOM_DESC",(String)request.getParameter("gen_uom_desc"));//Added by suresh.r on 29-07-2014 against MMS-SCF-0390
				if(bean.getAllow_eqvl_uom().equals("Y")){
				hmDtlRecord.put("PHY_UOM_CODE",(String)request.getParameter("uom_code"));///Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253
				}
				hmDtlRecord.put("CHECK_YN","Y");
				hmDtlRecord.put("ENTRY_COMPLETED_YN","N");
				//Added By Sakti Sankar against Inc#34757
				hmRecord = bean.isDuplicateExists(key_add_batch,alRecords);
				//message	 = (String)hmRecord.get("message");
				message	     = bean.checkForNull((String)hmRecord.get("message"));
				flag	     = bean.checkForNull((String)hmRecord.get("flag"));
				//flag	     = (String)hmRecord.get("flag");
				
				if(message.equals("duplicate exists with out case sensitive")){
					result1  =true;
				}else{
					result1 = false;
				}
				
				if(!result1)
				//if(!(bean.isDuplicateExists(key_add_batch,alRecords)))
				{
					alRecords.add(hmDtlRecord);
					bean.setModRecords(index,alRecords);
					result1=true;		   
				}else{
					result1=false;			
				}

		}else if(validate.equals("LOADSTORE")){
			String phy_inv_id = request.getParameter("phy_inv_id");
			HashMap hmStore = (HashMap)bean.getStore(phy_inv_id);
			out.println("document.forms[0].store_code.value='"+bean.checkForNull((String)hmStore.get("STORE_CODE"))+"'");
			out.println("document.forms[0].store_desc.value='"+bean.checkForNull((String)hmStore.get("SHORT_DESC"))+"'");
		}else if(validate.equals("loadExpDtls"))
		{
        
		//ArrayList test = new ArrayList();
		  String order = request.getParameter("order");
		  String obj =request.getParameter("obj");
		   bean.setOrder(order);
		   bean.setObj(obj);
		  // result = "true";
		
		}else if(validate.equals("setstoreto"))
		{
		String to_store_code = request.getParameter("to_store_code");
		String from_store_code = request.getParameter("from_store_code");

		String batch_id	= ((request.getParameter("batch_id") == null) || (request.getParameter("batch_id").trim() == ""))  ? "%" : (request.getParameter("batch_id").trim())+"%";
	
		String Trade_code	= ((request.getParameter("Trade_code") == null) || (request.getParameter("Trade_code").trim() == ""))  ? "%" : (request.getParameter("Trade_code").trim())+"%";
//Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
		String cut_off_date_for_grn	= ((request.getParameter("cut_off_date_for_grn") == null) || (request.getParameter("cut_off_date_for_grn").trim() == ""))  ? "" : (request.getParameter("cut_off_date_for_grn").trim());

		String period_of_expiry	= ((request.getParameter("period_of_expiry") == null) || (request.getParameter("period_of_expiry").trim() == ""))  ? "" : (request.getParameter("period_of_expiry").trim());

		String includeExpiredBatches	= request.getParameter("includeExpiredBatches");
		
		String searchby = request.getParameter("searchby"); //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
//Added ends
		bean.setTostoreCode(to_store_code);
		bean.setFromstoreCode(from_store_code);

		bean.setBatch_id(batch_id) ; //Added against Inc#35134 by Sakti Sankar
		bean.setTrade_Code(Trade_code) ;//Added against Inc#35134 by Sakti Sankar 

		bean.setCut_off_date_for_grn(cut_off_date_for_grn); //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
		bean.setSearchby(searchby); //Added By Sakti against CRF# - RUT-CRF-0081 icn#34757
		bean.setPeriod_Of_Expiry(period_of_expiry);
		bean.setIncludeExpiredBatches(includeExpiredBatches);
		}

		else if(validate.equals("CHECK_COMMITTED_QTY"))
		{

		ArrayList alTemp = new ArrayList();
		ArrayList temp = null;
		boolean count = false;
		
		try{
		alTemp = bean.getArrayList();

		for (int i=0 ; i < alTemp.size() ; i++){
		temp = new ArrayList();
		temp = (ArrayList)alTemp.get(i);

		String _store_code   = (String)temp.get(2);
		String _item_code	 = (String)temp.get(3);	
		String _batch_id	 = (String)temp.get(4);	
		String _bin_loc_code = (String)temp.get(7);
		String _expiry_date  = (String)temp.get(6);
		String _item_qty  = (String)temp.get(5);

		String _committed_qty = (String)bean.getBatchCommittedQty(_item_code, _store_code,_batch_id,_bin_loc_code, _expiry_date).get("COMMITTED_QTY");
		String _qty_on_hand = (String)bean.getBatchCommittedQty(_item_code ,_store_code,_batch_id,_bin_loc_code,_expiry_date).get("QTY_ON_HAND");
		String _item_desc = (String)bean.getBatchCommittedQty(_item_code ,_store_code,_batch_id,_bin_loc_code,_expiry_date).get("ITEM_DESC");
		
		count = bean.isBatchExistInSTItemBatch(_item_code,_store_code,_batch_id,_bin_loc_code,_expiry_date);

		System.out.println("count"+count);
		
		if(count){
		if (  Double.parseDouble(_item_qty) < Double.parseDouble(_committed_qty)){
		throw new Exception ("Physical Qty cannot be less than Committed Qty - Item : "+_item_desc+" Batch ID :"+_batch_id +"  QOH : " + _qty_on_hand + "  Committed Qty : " +_committed_qty +" Physical Qty : " +_item_qty);
		}
		}
		}
		result1   = true;
		}
		catch(Exception e){
		e.printStackTrace();
		result1   = false;
		message = e.getMessage();
		}
		}
		//Added by suresh.r on 01-08-2014 against MMS-SCF-0390 beg
		else if(validate.equals("ALLOW_CONV_QTY"))
		{
			double item_qty			=	Double.parseDouble(request.getParameter("item_qty"));
			String item_code       	=   request.getParameter("item_code");
			String store_code		=	request.getParameter("store_code");
			double conv_value		=	1;
			String gen_uom_code		=	bean.getGenItemUOM(item_code);
			String def_iss_uom_code =	(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ISSUE_UOM_DEFAULT"),new String[]{item_code,store_code}).get("DEF_ISSUE_UOM");
			
			int am_count		=	Integer.parseInt((String)bean.fetchRecord("SELECT  count(1) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{gen_uom_code, def_iss_uom_code}).get("COUNT"));
			int item_uom_count	=	Integer.parseInt((String)bean.fetchRecord("SELECT count(1) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{gen_uom_code, def_iss_uom_code,item_code}).get("COUNT"));
			
			if(item_uom_count >0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{gen_uom_code, def_iss_uom_code,item_code});
				conv_value=Double.parseDouble((String)stEqvl_value1.get("EQVL_VALUE"));
			}else if(am_count >0){
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{gen_uom_code, def_iss_uom_code}).get("EQVL_VALUE");
				conv_value=Double.parseDouble(stEqvl_value);
			}else{
				conv_value=1;
			}
			
			if(item_qty%conv_value!=0){
				result1=false;
				//Modified against MMS-DM-SCF-0364
				//message="Item Quatntity Should Be In Multiples Of "+(int)conv_value;
				message="Item Quantity should be multiples of "+(int)conv_value;
			}else{
				result1=true;
			}
		}//Added by suresh.r on 01-08-2014 against MMS-SCF-0390 end
		//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 Beg
		else if(validate.equals("BASE_UOM_QTY"))
		{
			String item_code=request.getParameter("item_code");
			String uom_code=request.getParameter("uom_code");
			message=bean.getUOMConvfact(item_code, uom_code);
			
		}
		//Added by suresh.r on 03-03-2015 against MMS-QH-CRF-0205 Inc 52253 end
		//Added for GHL-CRF-0413.7 starts
				else if(validate.equals("VALID_BARCODE")){
					String barcode = request.getParameter("barcode");
					String store_code	= request.getParameter("store_code");
					String item_code1="";
					String barcode_2d_applicable_yn = bean.barcode2DApplicable();//Added for MMS-DM-CRF-0174.6
					try{
						if(barcode_2d_applicable_yn.equals("Y")){//Adding start for MMS-DM-CRF-0174.6
					             item_code1  =bean.get2DBarcodeItem(store_code,barcode);
				         }else{//Adding end for MMS-DM-CRF-0174.6
						         item_code1=bean.checkForNull((String)bean.fetchRecord("select item_code from st_item_batch where barcode_id =? and store_code =?",new String[]{barcode,store_code}).get("ITEM_CODE"), "");
						 }
						int valid_item =Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? AND ITEM_CODE =? AND EFF_STATUS = 'E'",new String[]{store_code,item_code1}).get("COUNT"));
						if(valid_item >0){
							ArrayList alDetailData			=		new ArrayList();
							alDetailData					=		bean.getDtlRecords();
							int count=0;
							int selectedBatch=0;
							HashMap batchRec = new HashMap();
							for(int i=0;i<alDetailData.size();i++){
								batchRec = (HashMap)alDetailData.get(i);
								if(batchRec.containsValue(item_code1)){
									count++;
									selectedBatch = i;
									bean.setBarcode(barcode);
								}
							}
							if(count > 0){
								result1 = true;
								message = ""+selectedBatch;
							}
						}
						else{
							result1 = false;
							message = "PHY_INV_BATCH_NOT_VALID";
							}
					}
					catch(Exception e){
						result1		=	false;
						message		=	e.getMessage();
						e.printStackTrace();
						flag = "";
					}
				}
				//Added for GHL-CRF-0413.7 ends
		else{
			HashMap for_modify = new HashMap();
			bean.clear_values();
			for_modify = bean.getData_map();

			String key_val_add = request.getParameter("key_value");
			String mode = request.getParameter("mode");
			Set total_keys_set = for_modify.keySet();
			Iterator total_keys = total_keys_set.iterator();
			String result="false";

			if(mode.equals("add"))
			{
			if (for_modify.size() > 0)
			{
			while(total_keys.hasNext())
				{
					String next_val = (String)total_keys.next();
					if( next_val.equals(key_val_add) )
					{
					result="true";
					}
				}
			}
			else
			{
			result="false";
			}
			out.println(" assignResult("+result+"); ") ;
			}
				
			if(mode.equals("modify"))
			{
			String dup_modify_value = request.getParameter("dup");
			if(dup_modify_value.equals("yes"))
				{
					if (for_modify.size() > 0)
					{
						while(total_keys.hasNext())
						{
							String next_val = (String)total_keys.next();
							if( next_val.equals(key_val_add) )
							{
							result="true";
							}
						}
					}
				out.println(" assignResult("+result+"); ") ;
				}
			else
				{
				String modify_value = request.getParameter("modify_value");
				bean.modify_To_values(key_val_add,modify_value);
				result="true";
				out.println(" assignResult("+result+"); ") ;
				}
			}
		}
	}
	catch (Exception exception) {
		result1		=	false;
		message		=	exception.getMessage();
	}
	finally{
		out.println(" assignResult(" + result1 + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

	%>
	<%
putObjectInBean(bean_id,bean,request);
%>
 
