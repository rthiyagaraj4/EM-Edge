
<%@page contentType="text/html;charset=UTF-8" import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"%>  
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%> 
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale			=		(String)session.getAttribute("LOCALE");
    String check_status		=		request.getParameter("check_status");
    String stitem_code		=		request.getParameter("item_code");
	String bean_id			=		request.getParameter("bean_id");
	String bean_name		=		request.getParameter("bean_name");
    String functionType		=		request.getParameter("function_type");

	if ((bean_id == null) || (bean_id.equals("")))
		return;

  
	PORequestBean bean		=		(PORequestBean) getBeanObject(bean_id, bean_name, request  );
	bean.setLanguageId(locale);

	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		(Hashtable) hash.get ("SEARCH");
	boolean result			=		false;
	boolean result1			=		false;
	String message			=		"";
	String flag				=		"";
		
		if(functionType.equals("BATCHDETAILS"))
		{
			try {
				try {
					String item_code	= request.getParameter("item_code");
					String store_code	= request.getParameter("store_code");					
				//	String store_code_to	= request.getParameter("store_code_to");
					String phy_inv_id   = "";
						result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,store_code);
					if(result1){
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formPORequestDetail.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					}
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}catch (Exception exception) {
					exception.printStackTrace();

					if (exception.getMessage().equals("RECORD_ALREADY_EXISTS"))
						throw exception;
					if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED"))
						throw exception;

					throw new Exception("REQ_ON_ITEM_STORE_NOT_FOUND");
				}
			}catch (Exception exception) {
				result		=	false;
				message		=	exception.getMessage();
				exception.printStackTrace();
			}finally{
				out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}

		}else if(functionType.equals("CONVFACTTEMP"))
		{	
			try
			{
				String item_code = request.getParameter("item_code");
				String store_code = request.getParameter("store_code");
				String[]  minmaxarg = {""+bean.getConvFactTemp(item_code,store_code),item_code, store_code};
				HashMap hmminmax = new HashMap();
				hmminmax =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);
/**
* @Name - krishna
* @Date - 22/01/2010
* @Inc# - IN015496
* @Desc - Code added to accept decimal values dynamically.
*/				if((bean.getAllowDecimalsYN(item_code)).equals("Y")){
					out.println(" document.getElementById('Qty_onhand_label').innerHTML  = '<B>"+bean.setNumber(bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0"),bean.getNoOfDecimals())+"</B>' ");
				}else{
					out.println(" document.getElementById('Qty_onhand_label').innerHTML  = '<B>"+bean.setNumber(bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0"),0)+"</B>' ");
				}
			//	out.println(" document.getElementById('Qty_onhand_label').innerHTML  = '<B>"+bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"")+"</B>' ");
				out.println("document.getElementById('qty_on_hand').value = '"+bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0")+"';");
				result =  true ;
			
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}finally{
					out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
	

		}else if(functionType.equals("DEFAULTUOM"))
		{
		 try{
			try{
					String item_code = request.getParameter("item_code");
					String request_type = request.getParameter("request_type");
					String uom_code		= request.getParameter("uom_code");
					String store_code   = request.getParameter("store_code");
					ArrayList array = new ArrayList(); 
					array = (ArrayList)bean.getRequestTypeValue(item_code,request_type);
					
				
					result = true;
					String default_uom = bean.getDefaultUOM(item_code,store_code);
					
					out.println("clearListItemsNoSelect('document.formPORequestDetail.pur_uom_code'); ");

			 		ArrayList alEncounterList = bean.getPur_uom_code_List(uom_code,item_code);
					HashMap record = null;
					for(int i=0; i< alEncounterList.size(); i++) 
					{
					record	=	(HashMap)alEncounterList.get(i);
					String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2	=	(String)record.get("SHORT_DESC");
						out.println("addListItem(\"document.formPORequestDetail.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+"\") ; ");
						out.println("selectUOMcode('"+default_uom+"');");
					
					}
			}catch(Exception exception){
					throw new Exception("INVALID_ITEM_FOR_REQ_TYPE");
			}
		 }catch(Exception exception){
			 result		=	false;
			 message		=	exception.getMessage();
			 exception.printStackTrace();
		 }finally{
			 out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		 }
				
			
		}else  if(functionType.equals("CHECKUOMCONVFACTOR"))
		{

			{
		try{
			try { 
				String uom_code		= request.getParameter("uom");
				String pur_uom_code = request.getParameter("pur_uom_code");
				String item_code = request.getParameter("item_code");
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, pur_uom_code,item_code}).get("COUNT"));
		
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, pur_uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_code +" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_code;
				String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}else if(am_count!=0){
				
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("EQVL_VALUE");


				String conver=stEqvl_value+" "+uom_code+" = 1 "+pur_uom_code;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}else{
				String stEqvl_value="1";
				String conver="1"+" "+uom_code+" = 1 "+pur_uom_code;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
		
				}
			}catch (Exception exception) {
				exception.printStackTrace();
				
				throw new Exception("NO_CONV_FAC_FOR_REQ_UOM_CODE");
			}
		}catch (Exception exception) {
			result		=	false;
			message		=	exception.getMessage();
			exception.printStackTrace();
		}finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		}
		}else if(functionType.equals("CALREQUESTQTY")){
				result = false;
			try { 
				String item_code       =   (String)request.getParameter("item_code");
				String frm_store_code	=	(String)request.getParameter("frm_store_code");
			//	String to_store_code	=	(String)request.getParameter("to_store_code");
				double frm_tmp_conv=bean.getConvFactTemp(item_code,frm_store_code);
				double to_tmp_conv=bean.getConvFactTemp(item_code,frm_store_code);
				out.println("setTempConvFactor('"+frm_tmp_conv+"','"+to_tmp_conv+"');");
		
				result=true;
			}catch (Exception exception) {
				exception.printStackTrace();
			}
		
		}else if(functionType.equals("ADDITEMRECORD"))
	
			{
			try {
				try {
					String item_code	= request.getParameter("item_code");
					String store_code	= request.getParameter("store_code");					
				//	String store_code_to	= request.getParameter("store_code_to");
					String phy_inv_id   = "";
					result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,store_code);
					if(result1){
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formPORequestDetail.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					} 
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}
				catch (Exception exception) {
					exception.printStackTrace();

					if (exception.getMessage().equals("RECORD_ALREADY_EXISTS"))
						throw exception;
					if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED"))
						throw exception;

					throw new Exception("REQ_ON_ITEM_STORE_NOT_FOUND");
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

		} if (functionType.equals("MODIFYMODE")){
				java.util.HashMap addResult = bean.addDetailRecordModifyMode(hash);				
				out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}else if(functionType.equals("EDITING"))
		{
			java.util.HashMap addResult = bean.addDetailRecord(hash);
			out.println("assignResult("+addResult.get("result")+",\""+addResult.get("message")+"\", \"0\");");
		}else if(functionType.equals("UPDATECHECKSTATUS"))
		{
                ArrayList alItemKeys = new ArrayList();

				for(int i=0;i<bean.getItemKeys().size();i++) {
			      alItemKeys.add(bean.getItemKeys().get(i));	
		         } 
				
				java.util.ArrayList newKeys = bean.getItemKeysAdded();

				if (newKeys != null && newKeys.size() >0) {
					alItemKeys.addAll(newKeys);
				}

				HashMap hmItemStore = (HashMap)bean.getHmItemDetail();
				String itemStoreKey = "";

				if (alItemKeys != null && (alItemKeys.size()>0)) {
					int totalSize = alItemKeys.size();
					PORequestDetailBean detailBean;
					for (int i=0;	i<totalSize;	i++){
						itemStoreKey = (String) alItemKeys.get(i);
						detailBean = (PORequestDetailBean)hmItemStore.get(itemStoreKey);
						if(itemStoreKey.equals(stitem_code)){
							
							detailBean.setCheck_box_status(check_status);
                            hmItemStore.remove(itemStoreKey);
                            hmItemStore.put(itemStoreKey,detailBean);
                            bean.setHmItemDetail(hmItemStore);
						
							break ;
						}

					}//end of For loop
				}//end of if condition
              
		}else if(functionType.equals("ISSQTYCANNOTBEZERO"))
		{
		String item_code =  request.getParameter("item_code");
		PORequestDetailBean requestDetail;
		requestDetail					=			bean.getItemDetail(item_code);
		String required_qty				=			requestDetail.getRequired_qty();
		if(required_qty.equals("0"))
			result = false;
		else
			result = true;
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}else if(functionType.equals("AUTHORIZE"))
		{
		  try{
				String store_code = request.getParameter("store_code");
				String authorize_res = bean.getAuthorizeForRequest(store_code);
				message = authorize_res;
				result = true;

		  }catch(Exception exception){
			 result		=	false;
			 message		=	exception.getMessage();
			 exception.printStackTrace();
		  }
		  finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
			}
		}else if(functionType.equals("CHECKFORAUTHORIZE"))
		{
			String request_by_store = (String) hash.get("request_by_store");
			if (request_by_store != null && request_by_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			java.util.HashMap resultMap = bean.canAuthorize(request_by_store);
			if (resultMap != null) {
				String authorize = (String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN");
				if (authorize.equals("Y")) {
					authorize = "Yes";
				}
				else {
					authorize = "No";
				}
				out.println("setAuthorize('"+authorize+"');");
			}
		}else if(functionType.equals("LOADDEPARTMENT"))
		{
			String request_by_store = (String) hash.get("request_by_store");
			
				bean.setRequest_by_store(request_by_store);
					out.println("clearListItems('formPORequestQueryCriteria.request_on_store'); ");
					ArrayList req_by_stores = bean.getOnStores(bean.getRequest_by_store());

					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formPORequestQueryCriteria.request_on_store\", \"" + record.get("PARENT_STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}
				
		
			}else if(functionType.equals("LOADITEAMCLASS"))

			{
				String request_by_store = (String) hash.get("request_by_store");
				String request_on_store = (String) hash.get("request_on_store");
				if (request_on_store.trim().equals("") || request_by_store.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				
				out.println("clearListItems('formPORequestQueryCriteria.item_class_code'); ");
				ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
				HashMap record = null;
				for(int i=0; i< itemClasses.size(); i++) {
					record = (HashMap)itemClasses.get(i);
					out.println("addListItem(\"formPORequestQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
				}
		}



%>
<%
putObjectInBean(bean_id,bean,request);
%>
