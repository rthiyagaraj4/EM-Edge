<%
/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------
24/05/2017		IN063603			Badmavathi B						GHL-CRF-0456
31/12/2020		TFS-8224           Prabha      31/12/2020		Manickam	  MMS-DM-CRF-0177
---------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.util.*, eST.Common.*, eST.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>


<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>
<%
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
		

	String bean_id = request.getParameter("bean_id");
	String bean_name = request.getParameter("bean_name");
	int functionType = Integer.parseInt(request.getParameter("function_type"));
	if ((bean_id == null) || (bean_id.equals("")))
		return;
	ItemForStoreBean bean = (ItemForStoreBean)getBeanObject(bean_id,  bean_name,request );
	bean.setLanguageId(locale);

	Hashtable hash = (Hashtable) XMLobj.parseXMLString(request);
    hash = (Hashtable) hash.get ("SEARCH");
		switch (functionType) {
		case 1: 
			{
				String temp_store_code = "";
				String store_code = (String) hash.get("store_code");
				//String item_code = (String) hash.get("item_code");
				String to_store_code = (String) hash.get("to_store_code");
				if ((store_code == null) && (to_store_code == null)) {
					out.println("errorDisplay();");
					return;
				}
				if (store_code == null) {
					temp_store_code = to_store_code;
					out.println("clearListItems('formItemForStoreMultipleDetail.m_bin_location_code'); ");
				}
				else {
					out.println("setMedicalItem(\"" + bean.getMedicalItem(store_code) + "\"); ");
					temp_store_code = store_code;
					out.println("clearListItems('formItemForStoreSingleDetail.bin_location_code'); ");
				}
				out.println("document.formItemForStoreSingleDetail.stock_item_yn.disabled= "+bean.isNonStockStore(temp_store_code)+";");
				out.println("document.formItemForStoreSingleDetail.stock_item_yn.checked = false;");
				out.println("document.formItemForStoreSingleDetail.bin_location_code.disabled = true;");
				
							ArrayList binLocation = bean.getBinLocations(store_code);
					for(int i=0; i< binLocation.size(); i++) {
						String[] record = (String[])binLocation.get(i);
						if (store_code == null) {
							out.println("addListItem(\"formItemForStoreMultipleDetail.m_bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\"); ");
						}
						else {
							out.println("addListItem(\"formItemForStoreSingleDetail.bin_location_code\", \"" + record[0] + "\",\"" + record[1] + "\"); ");
						}
					}
					}
			break;
		case 2: //Update single
			{					
				String store_code =(String) hash.get("store_code");
				String item_code = (String) hash.get("item_code");
				ArrayList alPhyInv = new ArrayList() ;
				alPhyInv   = bean.selectInvType(item_code) ;

                HashMap hmTemp = (HashMap)alPhyInv.get(0) ;
				
                ArrayList alTempPhyInv = new ArrayList() ;
				alTempPhyInv.add(bean.checkForNull( (String)hmTemp.get("PHY_INV_TYPE"),"" ));
				alTempPhyInv.add(bean.checkForNull( (String)hmTemp.get("PHY_INV_COUNT_PER_YEAR"),"" ));
			
				hash.put("phy_inv_type",alTempPhyInv.get(0));
				hash.put("phy_inv_count_per_year",alTempPhyInv.get(1));
		                				
				String editing = (String) hash.get("editing");
				if (editing.equals("1") && bean.recordAlreadyExists(store_code,item_code)) {
					out.println("assignResult(false ,getMessage(\"CODE_ALREADY_EXISTS\",'Common'), \"0\");");
					return;
				}
				if (editing.equals("1") && bean.recordsExists(store_code,item_code)) {
					out.println("assignResult(false ,getMessage(\"DUPLICATE_CODE_EXISTS\",'Common'), \"0\");");
					return;
				}
				bean.addSingleRecord(hash);
				out.println("assignResult(true,\"\", \"0\");");
			}
			break;
		case 3:  // Update Multiple
			{
				
				bean.addMultipleRecord(hash);
			}
			break;
		case 4:
		{			out.println("clearListItems('document.formItemForStoreSingleDetail.request_uom'); ");
					out.println("clearListItems('document.formItemForStoreSingleDetail.issue_uom'); ");
					String uom_code = request.getParameter("request_uom");
					String item_code = (String) hash.get("item_code");
			 		ArrayList alEncounterList = bean.getPur_uom_code_List(uom_code,item_code);
					HashMap record	= null;
					for(int i=0; i< alEncounterList.size(); i++) 
					{
					record	=	(HashMap)alEncounterList.get(i);
					String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
					String listRecord2	=	(String)record.get("SHORT_DESC");
					out.println("addListItem(\"document.formItemForStoreSingleDetail.request_uom\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
					
					out.println("addListItem(\"document.formItemForStoreSingleDetail.issue_uom\", \"" +listRecord1+ "\",\"" +listRecord2+ "\") ; ");
										}
					//Added for GHL-CRF-0456 starts
					if(!bean.isSalesAllowed(item_code))
					{
						out.println("document.formItemForStoreSingleDetail.sales_allowed_yn.checked = true");
						out.println("document.formItemForStoreSingleDetail.sales_allowed_yn.disabled = false");
					}
					//Added for GHL-CRF-0456 ends
					
					//Added for MMS-DM-CRF-0177
					String pre_alloc_appl_yn = "N";
					String drug_yn = bean.getDrugSearchYN(item_code);
					ArrayList pre_alloc_check = null;
					pre_alloc_check	=	bean.getPreAllocCheck();
					if(pre_alloc_check!=null && pre_alloc_check.size() > 1) {
						pre_alloc_appl_yn	  = pre_alloc_check.get(0)==null?"N":pre_alloc_check.get(0).toString();
						}
					if(pre_alloc_appl_yn.equals("Y") && drug_yn.equals("Y"))
						{
						 	out.println("searchDrugYN();");
						}
					}	
					//Added for MMS-DM-CRF-0177
					
				break; 
		case 5:
		{		
			
			String store_code = (String) hash.get("store_code");
				HashMap hmRecord=bean.fetchRecord(" SELECT dflt_bin_location_code bin_loc_code   FROM		st_store  WHERE store_code = ?", store_code);
				String bin_loc_code=bean.checkForNull((String) hmRecord.get("BIN_LOC_CODE"),"");
				out.println("setBinLocCode('"+bin_loc_code+"');");
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
