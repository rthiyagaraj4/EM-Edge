package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __goodsreturntovendorvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

    private static void _releaseTags(javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag t) {
        while (t != null) {
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, t);
            if(t instanceof javax.servlet.jsp.tagext.Tag) {
                javax.servlet.jsp.tagext.Tag tmp = (javax.servlet.jsp.tagext.Tag)t;
                t = ((javax.servlet.jsp.tagext.Tag) t).getParent();
                try {
                    tmp.release();
                } catch(java.lang.Exception ignore) {}
            }
            else {
                t = ((javax.servlet.jsp.tagext.SimpleTag)t).getParent();
            }
        }
    }

    public boolean _isStale(){
        boolean _stale = _staticIsStale((weblogic.servlet.jsp.StaleChecker) getServletConfig().getServletContext());
        return _stale;
    }

    public static boolean _staticIsStale(weblogic.servlet.jsp.StaleChecker sci) {
        if (sci.isResourceStale("/est/jsp/GoodsReturnToVendorValidate.jsp", 1719569230877L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "UTF-8".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="  \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
---------------------------------------------------------------------------------------------------------
Date			Edit History    	Name		Rev. Date		Rev. By			Description
---------------------------------------------------------------------------------------------------------

23/01/2018							Chithra										GHL-CRF-496 
---------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block3Bytes, _wl_block3);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block4Bytes, _wl_block4);

	request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String user_name=		(String)session.getAttribute("login_user");
	GoodsReturnToVendorBean bean = (GoodsReturnToVendorBean)getBeanObject( "goodsReturnToVendorBean","eST.GoodsReturnToVendorBean", request ) ;  
		bean.setLanguageId(locale);
	String validate		=	request.getParameter("validate");
	String item_desc	=	request.getParameter("item_desc");
	
	Hashtable htFormValues = (Hashtable) XMLobj.parseXMLString(request);
    htFormValues = (Hashtable) htFormValues.get ("SEARCH");

	String message			=	"";
	String flag				=	"";
	//String facility_id=(String)session.getValue("facility_id");
	HashMap hashmapDtl=new HashMap();
	String item_code				=	request.getParameter("item_code");
	String store_code				=	request.getParameter("store_code");
	String supp_code				=	request.getParameter("supp_code");

			/** @Name - Priya
			* @Date - 06/04/2010
			* @Inc# - 20490
			* @Desc - To avoid Empty String Exception, have checked using equals method
			*/


	String item_qty_normal			=	bean.checkForNull((String)request.getParameter("item_qty_normal"),"0");
	if(item_qty_normal.equals("")){
		 item_qty_normal = "0";
	}
	//String item_qty_sample			=	request.getParameter("item_qty_sample");
	String item_qty_bonus			=	bean.checkForNull(request.getParameter("item_qty_bonus"),"0");
	if(item_qty_bonus.equals("")){
		 item_qty_bonus = "0";
	}
	String uom_desc					=	request.getParameter("uom_desc");
	String uom_code					=	request.getParameter("uom_code");
	String pur_uom_code				=	request.getParameter("pur_uom_code");
	//String pur_uom_conv				=	request.getParameter("pur_uom_conv");
	//String stock_available			=	request.getParameter("stock_available");
	String remarks					=	request.getParameter("remarks");
	String max_item_qty_normal		=	bean.checkForNull((String)request.getParameter("max_item_qty_normal"),"0");
	if(max_item_qty_normal.equals("")){
		 max_item_qty_normal = "0";
	}
	String max_item_qty_bonus		=	bean.checkForNull((String)request.getParameter("max_item_qty_bonus"),"0");
	if(max_item_qty_bonus.equals("")){
		 max_item_qty_bonus = "0";
	}
	String doc_srl_no				=	request.getParameter("doc_srl_no");
	//String item_unit_cost			=	request.getParameter("item_unit_cost");
	//String item_cost_value			=	request.getParameter("item_cost_value");
	String expiry_yn				=	request.getParameter("expiry_yn");
	String to_conv_fact				=	request.getParameter("to_conv_fact");
	String gen_uom_desc				=	request.getParameter("gen_uom_desc");
	String allow_deci_yn            =   bean.checkForNull(request.getParameter("allow_yn"),"N");
	String no_deci                  =   bean.checkForNull(request.getParameter("no_decimals"),"0");

	//String stock_item_yn			=	request.getParameter("stock_item_yn");
	//String label_reqd_yn			=	bean.checkForNull(request.getParameter("label_reqd_yn")).equals("true")?"Y":"N";
	//String replace_on_expiry_yn		=	bean.checkForNull(request.getParameter("replace_on_expiry_yn")).equals("true")?"Y":"N";
	String index					=	request.getParameter("index");
	boolean	result					=	false;
	try {
		if (validate.equals("ADD_TO_LIST")) {
			flag="";
			double lTotal_qty	=0;
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("uom_code",			uom_code		);
			hashmapDtl.put("item_qty_normal",	bean.checkForNull(item_qty_normal,"0")	);
			hashmapDtl.put("item_qty_bonus",	bean.checkForNull(item_qty_bonus,"0")	);
			hashmapDtl.put("item_cost_value",	"1"	);
			hashmapDtl.put("max_item_qty_normal",	max_item_qty_normal	);
			hashmapDtl.put("max_item_qty_bonus",	max_item_qty_bonus	);
			hashmapDtl.put("max_item_qty_bonus",	max_item_qty_bonus	);
			hashmapDtl.put("remarks",	remarks	);
			hashmapDtl.put("to_conv_fact",	to_conv_fact	);
			hashmapDtl.put("gen_uom_desc",	gen_uom_desc	);
			hashmapDtl.put("no_deci",		no_deci);
			hashmapDtl.put("allow_deci_yn",		allow_deci_yn);
			
			
			if (Double.parseDouble(bean.setNumber(item_qty_bonus,Integer.parseInt(no_deci)))>Double.parseDouble(bean.setNumber(max_item_qty_bonus,Integer.parseInt(no_deci)))) {
				throw new Exception("TFR_QTY_LESS_THAN_AVL_QTY");
			}
			if (Double.parseDouble(bean.setNumber(item_qty_normal,Integer.parseInt(no_deci)))>Double.parseDouble(bean.setNumber(max_item_qty_normal,Integer.parseInt(no_deci)))) {
				throw new Exception("TFR_QTY_LESS_THAN_AVL_QTY");
			}
			
			if (Double.parseDouble(bean.checkForNull(item_qty_normal,"0"))!=0) {
				lTotal_qty	=lTotal_qty+Double.parseDouble(bean.checkForNull(item_qty_normal,"0"));
			}
			/** @Name - Priya
				* @Date - 10/02/2010
				* @Inc# - 19094 
				* @Desc - LONG IS CHANGED TO DOUBLE AS 'item_qty_bonus' IS HAVING DECIMAL VALUES.
			*/
			if (Double.parseDouble(bean.checkForNull(item_qty_bonus,"0"))!=0) {
				lTotal_qty	=lTotal_qty+Double.parseDouble(bean.checkForNull(item_qty_bonus,"0"));
			}
//hashmapDtl.put("item_cost_value",	item_cost_value	);
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");

			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);
			/**
			 * @Name - Priya
			 * @Date - 28/05/2010
			 * @Inc# - 
			 * @Desc -  To get no of decimals for cost  
			 */
			int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
			double dItem_cost_value=bean.dAvg_unit_cost*lTotal_qty;
			/*dItem_cost_value*=1000;
			dItem_cost_value=Math.round(dItem_cost_value);
			dItem_cost_value/=1000;	*/


			hashmapDtl.put("item_cost_value",	bean.setNumber(""+dItem_cost_value,noOfDecimalsForCost)	);


			result			=	true;
		}
		// from here
		else if(validate.equals("GET_STATUS")) {
			String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result)
				{
					String phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formGoodsReturnToVendorListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}


			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				throw new Exception("RECORD_ALREADY_EXISTS");
			try { 
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock"))+Double.parseDouble((String)hmStockAvailabilityStatus.get("expired_stock")))+"\");");
//out.println("alert(\""+hmStockAvailabilityStatus.get("expired_stock")+"\");");
//				out.println("setStockDetails(\""+bean.getStock_item_yn(item_code, store_code)+"\",\""+available_stock+"\");");
				HashMap hmMaxRetQty	=	bean.getMaxReturnableQty(item_code,supp_code);
				if (hmMaxRetQty.get("MAX_RETURNABLE_NORMAL")==null||hmMaxRetQty.get("MAX_RETURNABLE_BONUS")==null) {
					throw new Exception("INSUFFICIENT_BATCH_QTY");

				}	out.println("setMaxReturnableQty(\""+hmMaxRetQty.get("MAX_RETURNABLE_NORMAL")+"\", \""+hmMaxRetQty.get("MAX_RETURNABLE_BONUS")+"\");");	
				
				out.println("parent.parent.frameGoodsReturnToVendorHeader.document.formGoodsReturnToVendorHeader.supp_code.disabled=true;");
			}
			catch (Exception exception) {
				//exception.printStackTrace();
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
					throw exception;
				}
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				if (exception.getMessage().equals("INSUFFICIENT_BATCH_QTY"))
					throw exception;
				else
					throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			result=true;
		}else if(validate.equals("setToConv")){
			
			
			double tmp_conv=bean.getConvFactTemp(item_code,store_code);
	
			bean.setTempConvFact(tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
		}
		else if(validate.equals("CHECK_AUTHORIZE_ALLOWED")) {
			String stFinalize_allowed	=	bean.getFinalize_allowed_yn(store_code);
			out.println("setFinalize_allowed('"+stFinalize_allowed+"');");
			result=true;
		}
		else if(validate.equals("GET_CONV_FACTOR")) {
			try { 
				String stEqvl_value=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT"),new String[]{uom_code, pur_uom_code}).get("EQVL_VALUE");
				out.println("setUOMConvFactor('"+stEqvl_value+"');");
				result=true;
			}
			catch (Exception exception) {
				exception.printStackTrace();
				throw new Exception("NO_CONV_FACTOR_FOR_UOM_CODE");
			}
		}
		// till here

//  Added for online printing on 9/24/2004

		else if (validate.equals("printOnlineDoc")){
			try{
				ArrayList doc_no=bean.getPrintDocNo();
				String pdocno = "";
				for(int i=0;i<doc_no.size();i++){
					pdocno=(String)doc_no.get(i);
					//bean.doOnlineReportPrinting(pdocno);
					bean.doOnlineReportPrinting(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
				}
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}
		// End of Online printing on 9/22/2004
		//	added for GHL-CRF-496 
		else if (validate.equals("StoreTotalBatchQty"))
				{
			String total_qty="";	
			try{		
				
				HashMap tot_datamap=bean.fetchRecord("select sum(qty_on_hand)-sum(COMMITTED_QTY) TOT_QTY  from st_item_batch where item_code=? and store_code=?",new String[]{item_code,store_code});
				
				total_qty=bean.checkForNull((String)tot_datamap.get("TOT_QTY"),"0");
				
				
			}
			catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
			message = "true"+";"+item_code+";"+store_code+";"+total_qty;
	}//end GHL-CRF-496 
		else if (validate.equals("GET_GTIN")){//Adding start for MOHE-CRF-0167
			String barcode = request.getParameter("barcode");  
			       store_code = request.getParameter("store_code");  
			       item_code =request.getParameter("item_code")==null?"":request.getParameter("item_code");  
			String barcode_item ="";
			int item_store_exists = 0;
			int gtin_count =0;
	        gtin_count =bean.getGTINItemCount(barcode);
		if(gtin_count==1){ 
			barcode_item  = bean.checkForNull(bean.getItemByGTIN(barcode)); 
			HashMap barcodeData  =new HashMap();
			 LinkedList batchData=new LinkedList();	 
	         barcodeData =bean.getBarcodeData();
			 int j =0;
		 if(barcode_item!=""){

	        result = bean.isPhysicalInventoryProcessStartedForStore(barcode_item,store_code,"");
		if(result){
															
				throw new Exception("PHY_INV_PROCESS_INITIATED");
		  }

	        item_store_exists=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from ST_ITEM_STORE where store_code = ? and item_code =? and eff_status = 'E'",new String[]{store_code,barcode_item}).get("COUNT"));
	if(item_store_exists>0){
			if(barcodeData.containsKey(barcode_item))
				batchData = (LinkedList)barcodeData.get(barcode_item);
			if(item_code.equals("")){
				String barcode_item_desc="";
				String Item_desc_val="";
				String IteamSearchBy="";
				IteamSearchBy=(String) bean.fetchRecord("select DFLT_ITEM_SEARCH from st_user_access_for_store where USER_ID=? and STORE_CODE=?",new String[]{user_name,store_code}).get("DFLT_ITEM_SEARCH");
				if(IteamSearchBy.equals("IN")){
				barcode_item_desc=(String) bean.fetchRecord("select short_desc from mm_item_lang_vw where item_code=? and language_id='en'",new String[]{barcode_item}).get("SHORT_DESC");
				Item_desc_val=barcode_item_desc;
				} else if(IteamSearchBy.equals("IC")){
					Item_desc_val=barcode_item;	
				}	
			  out.println("document.formGoodsReturnToVendorListHeader.item_desc.value = '"+bean.checkForNull(Item_desc_val,"")+"';");
			  out.println("document.formGoodsReturnToVendorListHeader.barcode.value = ''");
			    result=true;
			}else{
				out.println("document.formGoodsReturnToVendorListHeader.barcode.value = ''");
			 }
		   }else{
			    throw new Exception ("ITEM_STORE_NOT_FOUND1");

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
	} //END

	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean("goodsReturnToVendorBean",bean,request);

            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
