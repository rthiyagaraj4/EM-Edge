<%@page import=" eST.*, eST.Common.* , eCommon.Common.*, java.util.*,javax.servlet.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
		request.setCharacterEncoding("UTF-8");
		String locale			=		(String)session.getAttribute("LOCALE");
		String user_name=		(String)session.getAttribute("login_user");
		String bean_id			=		request.getParameter("bean_id");
		String bean_name		=		request.getParameter("bean_name");
		int functionType		=		Integer.parseInt(request.getParameter("function_type"));
		boolean	result			=	false;
		String message			=	"";
		String flag				=	"";
		if ((bean_id == null) ||		(bean_id.equals("")))
		return;

		ItemStoreBinLocationBean bean	=		(ItemStoreBinLocationBean) getBeanObject(bean_id,bean_name,request);
		bean.setLanguageId(locale);
		String facility_id  =  bean.getLoginFacilityId();
		Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
		hash							=		(Hashtable) hash.get ("SEARCH");
	
		switch (functionType) {
		case 1: 
			{
			
				if (hash.size() > 0) {
					bean.updateSelected_Bin_location_code(hash);
					
					out.println("alert(\' "+hash+"\');");
				}
								
			}
			break;
			case 2: 
			{
					String store_code				=		bean.getStore_code();
					String item_code				=		bean.getItem_code();
					String bin_location_code		=		request.getParameter("bin_location_code");
					int stock_status				=		bean.getStockStatus(store_code,item_code,bin_location_code);
					String index					=		request.getParameter("index");
				
					if(stock_status>0)
					{	
						
						out.println("document.formItemStoreBinLocationDetail.add_bin_location_"+index+".checked='true';");
						out.println("document.formItemStoreBinLocationDetail.stock_status.value='true';");
						out.println("alert(getMessage('STOCK_EXIST_BIN_LOCN','ST'));");
					}
					
				
					
			}
			break;
			case 3: 
			{	
					String select_all		=		(String)request.getParameter("select_all")==null?"":(String)request.getParameter("select_all");
					String totalRecords		=		request.getParameter("totalRecords");
					if(select_all.equals("Y"))bean.setSelect_All(select_all);
					bean.setTotalRecords(Integer.parseInt(totalRecords));
					if (hash.size() > 0) {
						bean.updateSelected_Bin_location_code(hash);
					}
								
			}
			break;
			case 4: 
			{	
					String total_records	= (String)hash.get("obj");
					bean.setTotalRecords(Integer.parseInt(total_records));
					
				
			}
			break;
			case 5:
			{
				 try {
				//Adding start for MOHE-CRF-0167
				eST.Common.StTransaction st_bean = (eST.Common.StTransaction)getBeanObject( "StTransaction",  "eST.Common.StTransaction",request  );
				String barcode = request.getParameter("barcode");  
				String store_code = request.getParameter("store_code");  
				String item_code =request.getParameter("item_code")==null?"":request.getParameter("item_code");  
				String barcode_item ="";
				int item_store_exists = 0;
				int gtin_count =0;
		        gtin_count =st_bean.getGTINItemCount(barcode);
			if(gtin_count==1){ 
				barcode_item  = bean.checkForNull(bean.getItemByGTIN(barcode)); 
				HashMap barcodeData  =new HashMap();
				 LinkedList batchData=new LinkedList();	 
		         barcodeData =bean.getBarcodeData();
				 int j =0;
				
			 if(barcode_item!=""){

		        result = st_bean.isPhysicalInventoryProcessStartedForStore(barcode_item,store_code,"");
			if(result){
																
					throw new Exception("PHY_INV_PROCESS_INITIATED");
			  }
				if(barcodeData.containsKey(barcode_item))
					batchData = (LinkedList)barcodeData.get(barcode_item);
				if(item_code.equals("")){
					String barcode_item_desc="";
					String Item_desc_val="";
					String IteamSearchBy="";
					if(store_code.equals("")){
						IteamSearchBy=(String) bean.fetchRecord("SELECT	DFLT_ITEM_SEARCH FROM st_facility_param WHERE facility_id=?",new String[]{facility_id}).get("DFLT_ITEM_SEARCH");					
					} else {
						IteamSearchBy=(String) bean.fetchRecord("select DFLT_ITEM_SEARCH from st_user_access_for_store where USER_ID=? and STORE_CODE=?",new String[]{user_name,store_code}).get("DFLT_ITEM_SEARCH");
						item_store_exists=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? and item_code =? and eff_status = 'E'",new String[]{store_code,barcode_item}).get("COUNT"));
						if(item_store_exists<1){
							throw new Exception ("ITEM_STORE_NOT_FOUND1");
						}
					}
					if(IteamSearchBy.equals("IN")){
					barcode_item_desc=(String) bean.fetchRecord("select short_desc from mm_item_lang_vw where item_code=? and language_id='en'",new String[]{barcode_item}).get("SHORT_DESC");
					Item_desc_val=barcode_item_desc;
					} else if(IteamSearchBy.equals("IC")){
						Item_desc_val=barcode_item;	
					}	
				  out.println("document.formItemStoreBinLocationHeader.item_desc.value = '"+bean.checkForNull(Item_desc_val,"")+"';");
				  out.println("document.formItemStoreBinLocationHeader.barcode.value = ''");
				    result=true;
				}else{
					out.println("document.formItemStoreBinLocationHeader.barcode.value = ''");
				 }
			   
			 }else{
				 
				     throw new Exception ("ST_INVALID_BAR_CODE");
			    }
			}else{
				if(gtin_count==0){
					throw new Exception ("ST_INVALID_BAR_CODE");
				}else if(gtin_count>1){
					throw new Exception ("BARCODE_WITH_MORE_ITEMS");
				}
			 }
				}
				catch (Exception exception) {
					result		=	false;
					message		=	exception.getMessage();
					exception.printStackTrace();
				}
				finally{
					out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
				} 
		
			}
			break;
		default :
			out.println("alert(\'Invalid Function : "+functionType+"\');");
			return;
	}
%>	
<%
	putObjectInBean(bean_id,bean,request);
%>
