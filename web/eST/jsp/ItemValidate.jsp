<%@page import="java.util.*, eST.Common.*, eST.*,java.sql.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper"
contentType="text/html;charset=UTF-8"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<jsp:useBean id="XMLobj"   scope="page"  class="webbeans.eCommon.XMLStringParser"/>
<%

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
//response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
//response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086	

	String locale					=		(String)session.getAttribute("LOCALE");
	String bean_id					=		request.getParameter("bean_id");
	String bean_name				=		request.getParameter("bean_name");
	String func_mode				=		(String)request.getParameter("func_mode");
	//String validate				=		request.getParameter("validate");
	String message					=		"";
	String flag						=		"";
	boolean	result					=		false;
	boolean	result1					=		false;
	String sole_source_yn			=		"";
	String ps_item_yn				=		"";
	String inventory_module_scope	=		"";
	//String supplier_desc			=		"";
	String sql1						=		"";
	String gen_uom_code				=		"";
	String eqvl_uom_code			=		"";
	boolean value					=		false;

	if ((bean_id == null) || (bean_id.equals("")))
		return;

	ItemBean bean					=		(ItemBean) getBeanObject(bean_id,bean_name,request);
	bean.setLanguageId(locale);

	Hashtable hash					=		(Hashtable) XMLobj.parseXMLString(request);
    hash							=		(Hashtable) hash.get ("SEARCH");
	String item_code				=		(String) hash.get("item_code");
	bean.setItemCode( item_code );
	if((bean.checkForNull(func_mode)).equals("toolBar")){
       String toolBarString = request.getQueryString() ;
	 //  out.println("alert(\"Before:"+toolBarString+"\")") ;
	   session.removeValue("queryString") ;
       session.putValue( "queryString", toolBarString ) ;

	}
	try {
				try{
						HashMap hmValues			=		bean.getMMInstallationParameter();
						if(hmValues==null) return;
						inventory_module_scope		=		bean.checkForNull((String)hmValues.get("INVENTORY_MODULE_SCOPE"),"");
					} catch( Exception e) {
					e.printStackTrace();}
				
				if(inventory_module_scope.equals("P")) {
				
						sql1						=		bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_INV_P");
					//	SQL_ST_ITEM_SELECT_INV_P_1
					} else {
					
						sql1						=		bean.getStRepositoryValue("SQL_ST_ITEM_SELECT_SINGLE");
					}
						result1						=		bean.checkItemExist();
						out.println(result1);
					if(bean.checkItemExist())
						throw new ItemAlreadyExistsException("ITEM_CODE_ALREADY_EXIST");
					else
					{
						ArrayList arr_lang			=		new ArrayList();
						arr_lang.add(item_code);
						arr_lang.add(locale);
						HashMap hmDefaultValues		=		bean.fetchRecord(sql1,arr_lang);
					
						if(hmDefaultValues==null||hmDefaultValues.size()==0)
							throw new Exception("INVALID_ITEM_CODE");

						String short_desc			=		bean.checkForNull((String) hmDefaultValues.get("SHORT_DESC"),"");
						String long_desc			=		bean.checkForNull((String) hmDefaultValues.get("LONG_DESC"),"");
					
						String short_desc1			=		"";
						for(int k=0; k<short_desc.length(); k++){
							if (short_desc.charAt(k) == '\''){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else if (short_desc.charAt(k) == '\"'){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else if (short_desc.charAt(k) == '\\'){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}
								else
									short_desc1		=		short_desc1 + short_desc.charAt(k);
						}
						String long_desc1			=		"";
						for(int k=0; k<long_desc.length(); k++){
							if (long_desc.charAt(k) == '\''){
									long_desc1			=		long_desc1+ "\\"+long_desc.charAt(k);
								}
								else if (long_desc.charAt(k) == '\"'){
									long_desc1			=		long_desc1+ "\\"+long_desc.charAt(k);
								}
								else if (long_desc.charAt(k) == '\\'){
									long_desc1			=		long_desc1+ "\\"+long_desc.charAt(k);
								}
								else{
									long_desc1		=		long_desc1 + long_desc.charAt(k);
								}
						}
						
						out.println("document.getElementById('td_short_desc').innerText= '"+short_desc1+"';");
						
						out.println("document.getElementById('long_desc').value= '"+long_desc1+"';");
						short_desc					=		bean.checkForNull((String) hmDefaultValues.get("SUPP_SHORT_NAME"),"");
						short_desc1					=		"";
						for(int k=0; k<short_desc.length(); k++){
							if (short_desc.charAt(k) == '\''){
								short_desc1			=		short_desc1+ "\\"+short_desc.charAt(k);
								}else
									short_desc1		=		short_desc1 + short_desc.charAt(k);
						}
						out.println("document.getElementById('td_short_desc').title= '"+short_desc1+"';");
						String solesource_legend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SoleSource.label","common_labels");
						String trade_legend				=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Trade.label","common_labels");
						String manufaturer_legend		=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Manufacturer.label","common_labels");
						String stockuom_legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StockUOM.label","common_labels");
						String ConversionFactor_legend	=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConversionFactor.label","common_labels");
						String PSItem_legend			=		com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.PharmacyStockItem.label","mm_labels");
						sole_source_yn					=		bean.checkForNull((String)hmDefaultValues.get("SOLE_SOURCE_YN"),"N");

						if (sole_source_yn.equals("Y")) {
							
							out.println("document.getElementById('td_sole_source_yn').innerHTML =\"&nbsp;"+solesource_legend+" <img align='center' src=\'../../eCommon/images/enabled.gif\'></img>\";");
							out.println("document.getElementById('td_trade_id_applicable_yn').innerHTML =\""+trade_legend+" <img align='center' src=\'../../eCommon/images/disabled.gif\'></img>\";");
							out.println("document.getElementById('td_manufacturer').innerHTML=\""+manufaturer_legend+"<b> "+hmDefaultValues.get("SHORT_NAME")+"</b>\";");
							out.println("document.formItemHeader.spare_part_id.disabled='false';");
							out.println("document.formItemHeader.machine_code.disabled='true';");
						} else {
							out.println("document.getElementById('td_sole_source_yn').innerHTML =\"&nbsp;"+solesource_legend+" <img align='center' src=\'../../eCommon/images/disabled.gif\'></img>\";");
							out.println("document.getElementById('td_trade_id_applicable_yn').innerHTML =\""+trade_legend+" <img align='center' src=\'../../eCommon/images/enabled.gif\'></img>\";");
							out.println("document.formItemHeader.trade_id_applicable_yn.value='Y';");
							out.println("document.formItemHeader.mfg_item_yn.disabled='true';");
						}
						ps_item_yn						=		bean.checkForNull((String)hmDefaultValues.get("PS_ITEM_YN"),"N");

						if(ps_item_yn.equals("Y")) {
							out.println("document.getElementById('td_ps_item_yn').innerHTML =\""+PSItem_legend+"<img align='center' src=\'../../eCommon/images/enabled.gif\'></img>\";");
							out.println("document.formItemHeader.machine_code.disabled=true;");
							out.println("document.formItemHeader.medical_item_yn.checked=true;");
							out.println("document.formItemHeader.medical_item_yn.disabled=true;");
							out.println("document.formItemHeader.drug_item_yn.disabled=false;");
							out.println("document.formItemHeader.spare_part_id.disabled=false;");	
							out.println("DrugCheck();");	   
						} else {
							out.println("document.formItemHeader.medical_item_yn.disabled=false;");
							out.println("document.getElementById('td_ps_item_yn').innerHTML =\""+PSItem_legend +"<img align='center' src=\'../../eCommon/images/disabled.gif\'></img>\";");
							out.println("document.formItemHeader.machine_code.disabled=false;");
							out.println("document.formItemHeader.spare_part_id.disabled='true';");
									}
						out.println("document.getElementById('td_gen_uom_code').innerHTML ='"+stockuom_legend +"<b > "+hmDefaultValues.get("UOM_DESC")+"</b>';");

						eqvl_uom_code					=		(String)hmDefaultValues.get("GEN_UOM_CODE");
						out.println("clearListItems('document.formItemHeader.repacking_uom');");

						String chkParameters[]			=		{eqvl_uom_code,locale,eqvl_uom_code,locale};
						ArrayList alRecords1			=		new ArrayList();
						try
						{
						 alRecords1						=		bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_ITEM_UOM_SELECT_LIST"),chkParameters);
						}
						catch (Exception e1)
						{	
							System.err.println("Error occured in Item Validate = "+e1);
						}
							HashMap hmRecord			=	null;
							for (int i=0;i<alRecords1.size();i++){
							hmRecord					=	(HashMap)alRecords1.get(i);

							out.println("addListItem(\"document.formItemHeader.repacking_uom\",\""+hmRecord.get("EQVL_UOM_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+eqvl_uom_code+"\");" );
							if(gen_uom_code.equals(hmRecord.get("eqvl_uom_code")))
								value					=			true;			
								}
							gen_uom_code				=			(String)hmDefaultValues.get("GEN_UOM_CODE");
							if(!(gen_uom_code==null || gen_uom_code.equals("")))
							{
								out.println("document.formItemHeader.item_gen_uom_code.value='"+gen_uom_code+"';");
								out.println("clearListItems('document.formItemHeader.sale_uom');");
								ArrayList arr_lang1		=			new ArrayList();
								arr_lang1.add(locale);
								ArrayList alRecords		=			bean.fetchRecords(bean.getStRepositoryValue("SQL_ST_AM_UOM_SELECT"),arr_lang1);
								for (int i=0;i<alRecords.size();i++){
								hmRecord		=			(HashMap)alRecords.get(i);
								if (gen_uom_code.equals("")){
								}
								out.println("addListItem(\"document.formItemHeader.sale_uom\",\""+hmRecord.get("UOM_CODE")+"\",\""+hmRecord.get("SHORT_DESC")+"\",\""+gen_uom_code+"\");" );
								if(gen_uom_code.equals(hmRecord.get("UOM_CODE")))
								value					=		true;			
							}
								if(value)
								out.println("document.getElementById('td_sale_stk_uom_conv').innerText='"+ConversionFactor_legend +" 1';");
						}
						result	=	true;
						message	=	"Done";
						return;
					}
			}
			catch (ItemAlreadyExistsException exception) {
				result	=	false;
				message	=	exception.getMessage();
				flag	=	exception.getMessage();
				out.println("document.formItemHeader.item_search.disabled='false';");
			}
			catch (Exception ex) {
				result	=	false;
				message	=	ex.getMessage();
				flag	=	ex.getMessage();
				//out.println("document.formItemHeader.item_search.disabled='false';");
				//out.println("document.formItemHeader.reset();");
				//out.println("document.getElementById("td_sale_stk_uom_conv").innerHTML='&nbsp';");
			}
	finally{
		out.println(" assignResult(" + result + ", \"" + message + "\", \"" + flag + "\" ) ; ") ;
	}
%><%
putObjectInBean(bean_id,bean,request);
%>
