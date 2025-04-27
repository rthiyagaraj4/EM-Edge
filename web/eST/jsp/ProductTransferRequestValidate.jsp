

<%@page  import=" eST.*,eST.Common.*,java.util.*,java.sql.*,webbeans.eCommon.*"
contentType="text/html;charset=UTF-8" %>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp"%>
<jsp:useBean id="XMLobj" scope="page" class="webbeans.eCommon.XMLStringParser"/>

<%
	request.setCharacterEncoding("UTF-8");
	String locale						=		(String)session.getAttribute("LOCALE");
		
	ProductTransferRequestBean bean		=		(ProductTransferRequestBean)getBeanObject("ProductTransferRequestBean", "eST.ProductTransferRequestBean" ,request ) ;
	bean.setLanguageId(locale);

    String message						=		"";
	String flag							=		"";
	String item_code					=		request.getParameter("item_code")==null?"":request.getParameter("item_code");
	String store_code					=		request.getParameter("store_code")==null?"":request.getParameter("store_code");
	String stk_uom						=		request.getParameter("stk_uom")==null?"":request.getParameter("stk_uom");
	String stk_uom_to					=		request.getParameter("stk_uom_to")==null?"":request.getParameter("stk_uom_to");
	String label						=		request.getParameter("label");	
	String repackgroup2					=		request.getParameter("repack_group2")==null?"":request.getParameter("repack_group2");
	String eqvlvalue					=		request.getParameter("eqvlvalue")==null?"":request.getParameter("eqvlvalue");
	String fm_item_code					=		request.getParameter("from_item_code");
	String to_item_code					=		request.getParameter("to_item_code");
	String fm_stk_uom_conv_factor		=		request.getParameter("fm_stk_uom_conv_factor");
	String to_stk_uom_conv_factor		=		request.getParameter("to_stk_uom_conv_factor");

	String fm_item_qty					=		request.getParameter("quantity");
    String to_item_qty					=		request.getParameter("required_qty");
	String remarks						=		request.getParameter("remarks");
	String requested_by					=		request.getParameter("requested_by");
	String from_trade_id_yn				=		request.getParameter("from_trade_id_yn")==null?"":request.getParameter("from_trade_id_yn");
	String to_trade_id_yn				=		request.getParameter("to_trade_id_yn")==null?"":request.getParameter("to_trade_id_yn");
	String repackgroup					=		""; 
	String repackuom					=		""; 
	String repackuomTo					=		"";
	String eqvlvalue_to					=		"";
//	String facility_id					=		(String)session.getValue("facility_id");
	boolean	result						=		true;
	boolean	result1						=		true;
	try {
		
		 
		if (label.equals("setvalue"))
		{
			bean.setRequest_Store(store_code);
			bean.setItem_Used	(fm_item_code);
			bean.setRepack_Item	(to_item_code);
			bean.setRepack_Factor(fm_stk_uom_conv_factor);
			bean.setTo_Factor	(to_stk_uom_conv_factor);
			bean.setQuantity		(fm_item_qty);
			bean.setRequired_Qty	(to_item_qty);
			bean.setRemarks		(remarks);
			bean.setRequested_By	(requested_by);
			result = true;
		}
		/*ML-MMOH-SCF-1065 STARTS*/
		else if(label.equals("convfactor"))
		{
			String item_code1		=	request.getParameter("item_code")== null?"":request.getParameter("item_code").toUpperCase();
			String store_code1		=	request.getParameter("store_code")== null?"":request.getParameter("store_code");
			String UOM_Desc		=	request.getParameter("UOM_Desc")== null?"":request.getParameter("UOM_Desc");
			String Equivalen_uom_desc		=	request.getParameter("Equivalen_uom_desc")== null?"":request.getParameter("Equivalen_uom_desc");
			String lang_id		=	request.getParameter("lang_id")== null?"":request.getParameter("lang_id");
			try{
				ArrayList conv_fact= bean.getConvCode(item_code1,UOM_Desc,Equivalen_uom_desc,lang_id);	
				String fromuom="";
				String touom="";
	
				fromuom= conv_fact.get(0).toString();
				touom=conv_fact.get(1).toString();
				System.out.println("fromuom"+fromuom);
				System.out.println("touom"+touom);
				out.println("");
				out.println("getconvfact('" + fromuom + "','" + touom + "');");
				out.println("");
				result = true;
			}
						
			catch(Exception exception){
				exception.printStackTrace();
				result = false;
			}
		//	out.println("document.formProductTransferRequestAddModify.conv_fact.value='"+conv_fact+"'");
		
		}
		/*ML-MMOH-SCF-1065 ENDS*/
		else{
		if (label.equals("print")){
			//String storecode	=	request.getParameter("store_code")==null?"":request.getParameter("store_code");
			String req_no		=	request.getParameter("req_no")== null?"":request.getParameter("req_no");
			try{
				//bean.doOnlineReportPTRPrinting(req_no,locale,session);
				bean.doOnlineReportPTRPrinting(req_no,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
				result = true;
			}catch(Exception exception){
				exception.printStackTrace();
				result = false;
			}
		}
		else{
				ArrayList alRepUom		=		new ArrayList();
				alRepUom				=		bean.getRepackUom(item_code);
				repackgroup				=		(String)alRepUom.get(0);
				repackuom				=		(String)alRepUom.get(1);
				String allowDecimalsYN = "";
				String noOfDecimals = "";
            
			allowDecimalsYN = bean.getAllowDecimalsYN(item_code);
					noOfDecimals = ""+bean.getNoOfDecimals();
					out.println("setDecimalParameters('"+allowDecimalsYN+"','"+ noOfDecimals +"','"+label+"');");
				if(label.equals("from")){
										
					result1				=		bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result1){
					String	phy_inv_id	=		(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formProductTransferRequestAddModify.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					out.println("phy_inv_progress1();");
				}
			
				if(!item_code.equals(to_item_code)){  
					if(!(from_trade_id_yn.equals("N") && to_trade_id_yn.equals("Y")) ){
					
						if(repackgroup.equals(repackgroup2) && !repackgroup.equals("") && !repackgroup2.equals("")){
							out.println("document.formProductTransferRequestAddModify.repack_group1.value='"+repackgroup+"'");
							out.println("document.formProductTransferRequestAddModify.to_repack_uom_code.value='"+repackuom+"'");
							if(repackuom.equals(""))
								eqvlvalue		=	"1";
							else{
								// if the fractional uom of target item and used item r same then default the eqvl value b/w stockuom and fractional uom of target item into pack size.
								 repackuomTo	=	(String)((bean.getRepackUom(to_item_code)).get(1));
							
									if(repackuomTo != "" && repackuomTo != null && repackuom.equals(repackuomTo)){
										
										if(stk_uom_to.equals(repackuomTo)){
											eqvlvalue			=	"1";
									
										}
										else{
											ArrayList alUOM		=	new ArrayList();
											alUOM				=	bean.getEqvlUom(stk_uom_to,repackuomTo);
										
											if(alUOM.size()>=1 )
												eqvlvalue_to	=	(String)alUOM.get(0);
											else 
												out.println("conv_factor_not_defined();");
										}

									}else{
										eqvlvalue				=		"1";
										eqvlvalue_to			=		"1";
									
									}
							}
								
							if(repackuom.equals("") && repackuomTo.equals("") ){
								
									eqvlvalue_to				=		"1";
									out.println("document.formProductTransferRequestAddModify.repack_factor.value='"+eqvlvalue_to+"'");
							}
							if(stk_uom.equals(repackuom)){
									eqvlvalue					=		"1";
									
							}
							else{
								if (bean.getEqvlUom(stk_uom,repackuom).size()>=1){
									eqvlvalue					=		(String)(bean.getEqvlUom(stk_uom,repackuom)).get(0);
								//	out.println("document.formProductTransferRequestAddModify.eqvlvalue.value='"+(bean.getEqvlUom(stk_uom,repackuom)).get(0)+"'");
								}else{
									eqvlvalue					=		"1";
								//	out.println("document.formProductTransferRequestAddModify.eqvlvalue.value='"+eqvlvalue+"'");
								}
							//out.println("document.formProductTransferRequestAddModify.eqvlvalue.value='"+eqvlvalue+"'");
							
							}
							out.println("document.formProductTransferRequestAddModify.eqvlvalue.value='"+eqvlvalue+"'");
							out.println("document.formProductTransferRequestAddModify.repack_factor.value='"+eqvlvalue_to+"'");
							
					}else{
						  out.println("repacking_groups_different();");
						  result = false;
					}
				 }else{
					out.println("Trade_ID_not_applicable();");
					result = false;
				 }
			}else{	
				out.println("Item_difference();");
				result = false;
			}
		}
		else if (label.equals("to")){	
				result1= bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result1){
					String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formProductTransferRequestAddModify.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					out.println("phy_inv_progress();");
				//	throw new Exception("PHY_INV_PROCESS_INITIATED");
				}

				alRepUom	=	bean.getRepackUom(item_code);
				repackuom	=	(String)alRepUom.get(1);
			//	ArrayList alUOM=new ArrayList();
			//	alUOM=bean.getEqvlUom(stk_uom,repackuom);
				out.println("document.formProductTransferRequestAddModify.repack_group2.value='"+repackgroup+"'");
				//out.println("document.formProductTransferRequestAddModify.eqvlvalue.value='"+alUOM.get(0)+"'");

		}
		}
		}
		
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
putObjectInBean("ProductTransferRequestBean",bean,request);
%>
