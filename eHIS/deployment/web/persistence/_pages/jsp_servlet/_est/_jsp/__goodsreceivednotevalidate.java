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
import java.lang.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __goodsreceivednotevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/GoodsReceivedNoteValidate.jsp", 1718356761588L ,"10.3.6.0","Asia/Calcutta")) return true;
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
-------------------------------------------------------------------------------------------------------------------------------------------
Date		       Edit History	        Name		       Rev.Date		     Rev.Name			     Description
-------------------------------------------------------------------------------------------------------------------------------------------
27/11/2019      IN:071539               B Haribabu         28/11/2019         Manickam                NMC-JD-CRF-0029
22/4/2021		TFS:14012				Shazana			22/4/2021	   			Manickam				MO-CRF-20165 
9/2/2022		TFS28606				Shazana															MO-CRF-20178 
--------------------------------------------------------------------------------------------------------------------------------------------
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
	String user_name=		(String)session.getAttribute("login_user"); // MOHE-CRF-0167
	GoodsReceivedNoteBean bean = (GoodsReceivedNoteBean)getBeanObject( "goodsReceivedNoteBean","eST.GoodsReceivedNoteBean", request) ;  
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
	
	String flag_1="";
	String store_code				=	bean.checkForNull((String)request.getParameter("store_code"));
	String item_qty_normal			=	request.getParameter("item_qty_normal");
	String item_qty_sample			=	request.getParameter("item_qty_sample");
	String item_qty_bonus			=	request.getParameter("item_qty_bonus");
	String uom_desc					=	request.getParameter("uom_desc");
	String uom_code					=	request.getParameter("uom_code");
	String pur_uom_code				=	request.getParameter("pur_uom_code");
	//String stock_available			=	request.getParameter("stock_available");
	//String remarks					=	request.getParameter("remarks");
	String pur_uom_conv				=	request.getParameter("pur_uom_conv");
	String no_of_labels				=	request.getParameter("no_of_labels");
	String grn_unit_cost_in_pur_uom				=	request.getParameter("grn_unit_cost_in_pur_uom");

	String doc_srl_no				=	request.getParameter("doc_srl_no");
	//String item_unit_cost			=	request.getParameter("item_unit_cost");
	String item_cost_value			=	request.getParameter("item_cost_value");
	String to_conv_fact				=	request.getParameter("to_conv_fact");
	String po_cost					=	request.getParameter("po_cost");
	String po_discount				=	request.getParameter("po_discount");
	String po_tax					=	request.getParameter("po_tax");
	String expiry_yn				=	bean.checkForNull(request.getParameter("expiry_yn"),"");
	//String stock_item_yn			=	request.getParameter("stock_item_yn");
	String exp_rec_date=bean.checkForNull(request.getParameter("expiry_receipt_date"));
	String batch_id=bean.checkForNull(request.getParameter("batch_id"));
    //String expiry_date_or_receipt_date = bean.checkForNull(request.getParameter("expiry_date_or_receipt_date"));
	String label_reqd_yn			=	bean.checkForNull(request.getParameter("label_reqd_yn")).equals("true")?"Y":"N";
	String replace_on_expiry_yn		=	bean.checkForNull(request.getParameter("replace_on_expiry_yn")).equals("true")?"Y":"N";
	String index					=	request.getParameter("index");
	boolean	result					=	false;
	String allow_deci_yn            =   bean.checkForNull(request.getParameter("allow_yn"),"N");
	String no_deci					=   bean.checkForNull(request.getParameter("no_decimals"),"0");
	String pur_uom_conv_id           =   bean.checkForNull(request.getParameter("pur_uom_conv_id"),pur_uom_conv);

	String ordered_qty  =   bean.checkForNull(request.getParameter("ordered_qty"));
	String delivery_date  =   bean.checkForNull(request.getParameter("delivery_date"));
	String conversion_rate =   bean.checkForNull(request.getParameter("conversion_rate"));
	String manufacture_id = bean.checkForNull(request.getParameter("manufacturer_id")); //added for MO-CRF-20165 start
	String remarks_desc =bean.checkForNull(request.getParameter("remarks_desc"),""); 
	String catalog_code = bean.checkForNull(request.getParameter("catalog_code"),""); //end 
	String 	manufac_remarks = 	bean.checkForNull(request.getParameter("manufac_remarks"),""); //MO-CRF-20178
	boolean site= false; //Added for KDAH-CRF-0372
     Connection con=null;  //Added for KDAH-CRF-0372
boolean grn_newfields_applicable = false; //added for MO-CRF-20165 
	try {

		//String operation							=	request.getParameter("operation");
		if (validate.equals("ADD_TO_LIST")) {
			flag="";
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("uom_code",			uom_code		);
			hashmapDtl.put("pur_uom_code",		pur_uom_code	);
			
			hashmapDtl.put("item_qty_normal",	bean.checkForNull(item_qty_normal,"0")	);
			hashmapDtl.put("item_qty_bonus",	bean.checkForNull(item_qty_bonus,"0")	);
			hashmapDtl.put("item_qty_sample",	bean.checkForNull(item_qty_sample,"0")	);
			hashmapDtl.put("item_cost_value",	item_cost_value	);
			hashmapDtl.put("label_reqd_yn",		label_reqd_yn	);
			hashmapDtl.put("replace_on_expiry_yn",	replace_on_expiry_yn	);
			hashmapDtl.put("pur_uom_conv",	pur_uom_conv	);
			hashmapDtl.put("grn_unit_cost_in_pur_uom",	grn_unit_cost_in_pur_uom	);
			hashmapDtl.put("no_of_labels",	no_of_labels	);
			hashmapDtl.put("to_conv_fact",	to_conv_fact	);
			hashmapDtl.put("po_cost",		po_cost	);
			hashmapDtl.put("po_discount",	po_discount	);
			hashmapDtl.put("po_tax",		po_tax	);
			hashmapDtl.put("no_deci",		no_deci);
			hashmapDtl.put("allow_deci_yn",		allow_deci_yn);
			hashmapDtl.put("pur_uom_conv_id",	pur_uom_conv_id);

			hashmapDtl.put("by_po",	"N");
			hashmapDtl.put("ordered_qty",	ordered_qty);
			hashmapDtl.put("delivery_date",	delivery_date);
			hashmapDtl.put("conversion_rate",	conversion_rate);
			hashmapDtl.put("manufacturer_id",	manufacture_id);  //added for MO-CRF-20165 START
			hashmapDtl.put("remarks_desc",	bean.checkForNull(remarks_desc,""));  
			hashmapDtl.put("grn_remarks_desc",	bean.getGrnRemarks()); 
			hashmapDtl.put("catalog_code", bean.checkForNull(catalog_code,""));//end		 
			hashmapDtl.put("manufac_remarks", bean.checkForNull(manufac_remarks,""));//MO-CRF-20178  
			bean.setItemRemarks("");//end 
	
			//hashmapDtl.put("expiry_yn",	expiry_yn	);
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");
			
			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);

			result			=	true;
		}else if(validate.equals("setToConv")){

			double tmp_conv=bean.getConvFactTemp(item_code,store_code);
			bean.setTempConvFact(tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
		}else if(validate.equals("setToConv1")){
			double tmp_conv=Integer.parseInt(request.getParameter("tmp_conv"));
			bean.setTempConvFact(tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
		}
		else if(validate.equals("GET_STATUS")) {
//			String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
			String[] stNames={"item_code"};
			String[] stValues={item_code};

			result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
			//System.out.println("result:"+result);
				if(result)
				{
					String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formGoodsReceivedNoteListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				throw new Exception("RECORD_ALREADY_EXISTS");
			try { 
//				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
			 //alert("StockAvailabilityStatus"+hmStockAvailabilityStatus)	out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\");");
   				boolean bLabel_reqd_yn	= bean.getLabel_reqd_yn(item_code).equals("Y");
				out.println("document.formGoodsReceivedNoteListHeader.label_reqd_yn.checked="+bLabel_reqd_yn+";");
				out.println("document.formGoodsReceivedNoteListHeader.no_of_labels.disabled=!"+bLabel_reqd_yn+";");
			}
			catch (Exception exception) {
				exception.printStackTrace();
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
					throw exception;
				}
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			result=true;
		}
		else if(validate.equals("SET_PUR_UOM_LIST")){
			try { 
				out.println("clearListItemsNoSelect('document.formGoodsReceivedNoteListHeader.pur_uom_code'); "); 
				uom_code		= request.getParameter("uom_code");
	     		ArrayList alEncounterList = bean.getPur_uom_code_Lists(uom_code,item_code);
				HashMap record	=	new HashMap();
					for(int i=0; i< alEncounterList.size(); i++){
						record	=	(HashMap)alEncounterList.get(i);
						String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
						String listRecord2	=	(String)record.get("SHORT_DESC");
						out.println("addListItem(\"document.formGoodsReceivedNoteListHeader.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +uom_code+"\") ; ");
					}
				}
				catch (Exception exception) {
				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			result=true;
		}
		else if(validate.equals("CHECK_AUTHORIZE_ALLOWED")) {
			String stFinalize_allowed	=	bean.getFinalize_allowed_yn(store_code);
			out.println("setFinalize_allowed('"+stFinalize_allowed+"');");
			result=true;
		}
		else if(validate.equals("GET_CONV_FACTOR")) {
			try { 

				//Added against Inc#35108 by Sakti Sankar
				String uom_description=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{uom_code, locale}).get("SHORT_DESC");
				
				String pur_uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{pur_uom_code, locale}).get("SHORT_DESC");
				//Added ends

				//Added by Sakti sankar against RUT-SCF-0248 displaying special characters

				uom_description = bean.checkForNull(uom_description).replaceAll(" ","%20");
				uom_description = java.net.URLEncoder.encode(uom_description,"UTF-8");
				uom_description = uom_description.replaceAll("%2520","%20");

				pur_uom_desc = bean.checkForNull(pur_uom_desc).replaceAll(" ","%20");
				pur_uom_desc = java.net.URLEncoder.encode(pur_uom_desc,"UTF-8");
				pur_uom_desc = pur_uom_desc.replaceAll("%2520","%20");
				//Added ends

				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, pur_uom_code,item_code}).get("COUNT"));
				//Added by suresh.r 19-11-2013 against MMS-SCF-0166 for Sale Price validation beg
				if(request.getParameter("val_unitcost").equals("Y")){
					double sal_price=Double.parseDouble(bean.checkForNull(request.getParameter("sal_price"),"0"));
					double unit_cost=Double.parseDouble(bean.checkForNull(request.getParameter("unit_cost"),"0"));
					double mul_unit_cost=0,conv_fact=0;
					String status_flg="YES",eqvl_value="";
					if(item_uom_count>0){
						eqvl_value=(String)bean.fetchRecord("SELECT (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, pur_uom_code,item_code}).get("CONV_FACTOR");
						conv_fact=Double.parseDouble(eqvl_value);
						mul_unit_cost=conv_fact*sal_price;
						if(mul_unit_cost<unit_cost){
							status_flg="NO";
						}
					}else if(am_count>0){
						eqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("EQVL_VALUE");
						conv_fact=Double.parseDouble(eqvl_value);
						mul_unit_cost=conv_fact*sal_price;
						if(mul_unit_cost<unit_cost){
							status_flg="NO";
						}
					}else{
						if(sal_price<unit_cost){
							status_flg="NO";
						}
					}
					out.println(status_flg);
					flag_1="Not Req";
				}else{
				//Added by suresh.r 19-11-2013 against MMS-SCF-0166 end
					if(item_uom_count>0){
						HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty ,(eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, pur_uom_code,item_code});
						//String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_code+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_code;
						String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_description+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_desc;
						String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
						out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
						result=true;

				
					}else if(am_count>0){
						String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("EQVL_VALUE");
				
						//String conver=stEqvl_value+" "+uom_code+" = 1 "+pur_uom_code;
						String conver=stEqvl_value+" "+uom_description+" = 1 "+pur_uom_desc;
						out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				
						result=true;
					}else{
						String stEqvl_value="1";
						//String conver="1"+" "+uom_code+" = 1 "+pur_uom_code;
						String conver="1"+" "+uom_description+" = 1 "+pur_uom_desc;
						out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
						result=true;
		
					}
				}//Added by suresh.r 19-11-2013 against MMS-SCF-0166 
			}
			catch (Exception exception) {
				exception.printStackTrace();
				throw new Exception("NO_CONV_FAC_FOR_PUR_UOM_CODE");
			}
		}

		// till here
//  Added for online printing on 9/22/2004

		else if (validate.equals("printOnlineDoc")){
			try{
			ArrayList doc_no=bean.getPrintDocNo();
			String pdocno = "";
			for(int k=0;k<doc_no.size();k++){
			pdocno=(String)doc_no.get(k);
			int count=Integer.parseInt((String)	bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_GRN_DTL WHERE DOC_NO = ?",pdocno).get("COUNT"));
			ArrayList alResult = new ArrayList();
			alResult = bean.fetchRecords("SELECT ITEM_CODE,LABEL_REQD_YN, NO_OF_LABELS FROM ST_GRN_DTL WHERE DOC_NO = ?",pdocno);
			HashMap hmTemp = new HashMap();
			for(int i=0;i<count;i++){
				hmTemp = (HashMap)alResult.get(i);
				if(((String)hmTemp.get("LABEL_REQD_YN")).equals("Y")){
					for(int j=0;j<Integer.parseInt((String)hmTemp.get("NO_OF_LABELS"));j++){
						//bean.doOnlineReportPrintingOfLabel(pdocno,(String)hmTemp.get("ITEM_CODE"));
						bean.doOnlineReportPrintingOfLabel(pdocno,(String)hmTemp.get("ITEM_CODE"),request,response);
					}
				}
			}
			}
			 pdocno = "";
			for(int i=0;i<doc_no.size();i++){
				pdocno=(String)doc_no.get(i);
				//bean.doOnlineReportPrinting(pdocno);	
				bean.doOnlineReportPrinting(pdocno,request,response);//Added By Sakti Sankar on 06/03/2013 against Inc#
			}
			//bean.doOnlineReportPrinting(pdocno);	
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}
		
		else if (validate.equals("DISP_PUR_COST")){
			try{
				String last_pur_cost=bean.getLastPurCost(item_code,store_code);
				out.println("set_unit_cost('"+last_pur_cost+"');");
				
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			//message = request.getParameter("msg");
		}
// End of Online printing on 9/22/2004
// Added on 2/8/2006 for alert for Suspended batches
		else if(validate.equals("CHECK_CONFIRM"))
		{
			String batch_status=bean.getbatchstatus(exp_rec_date,batch_id,item_code);
			if( (batch_status.equals("C"))||(batch_status.equals("S")))
			{
				//result=true;
				//message=batch_id;
				//flag=exp_rec_date;
				out.println(batch_status+"##"+batch_id+"##"+exp_rec_date) ;
				flag_1="YES";
				
			// batch_count+=batch_id;
			// exp_count+=exp_rec_date;
	//String confirmmsg="The Expired Batches are "+batch_count+" and "+exp_count+" Do u want to proceed ?";
	//out.println("confirmbox('"+confirmmsg+"');");
			}
			else
			{
				out.println(batch_status+"##"+batch_id+"##"+exp_rec_date) ;
				flag_1="no";
			 
			 }
		}else if(validate.equals("TRNTYPE")) {
			String doc_type_code = (String)request.getParameter("doc_type_code");
			try { 
				String trn_type=(String)	bean.fetchRecord("select distinct trn_type from st_trn_doc_type where doc_type_code = ? and facility_id = ?",new String[]{doc_type_code,bean.getLoginFacilityId()}).get("TRN_TYPE");
				bean.setTrn_type(bean.checkForNull(trn_type));
				result=true;
			}
			catch (Exception exception) {
				exception.printStackTrace();
			}
		}else if (validate.equals("LOAD_DETAILS")){
			try{
				String po_doc_type_code			=	(String)request.getParameter("po_doc_type_code");
				String po_doc_no				=	(String)request.getParameter("po_doc_no");
				String phy_inv_id				= "";
				String fm_store_code			=(String)request.getParameter("fm_store_code");
				boolean result1 = false;
				bean.setPO_doc_type_code(po_doc_type_code);
				bean.setPo_no(po_doc_no);
				bean.loadPODetailPage(po_doc_no,po_doc_type_code);
				ArrayList alDetailData=(ArrayList)bean.getDtlRecords();
				HashMap data1=new HashMap();
				if(alDetailData.size()!=0){
				result = true;
				}
				for(int i=0;i<alDetailData.size();i++){
					data1 = (HashMap)alDetailData.get(i);
					result1 = bean.isPhysicalInventoryProcessStartedForStore((String)data1.get("item_code"),fm_store_code,fm_store_code);
					if(result1){
							phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)data1.get("item_code"),fm_store_code}).get("PHY_INV_ID");
						if(bean.checkForNull(phy_inv_id,"").equals(""))
							phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{(String)data1.get("item_code"),fm_store_code}).get("PHY_INV_ID");
						out.println("dispMess('"+phy_inv_id+"');");
							throw new Exception("PHY_INV_PROCESS_INITIATED");
					}
				}
			}catch(Exception e){
				if (e.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					result = false;
					throw e;
				}
			}
		}else if(validate.equals("SET_REMARKS")) {
			bean.setRemarks((String)htFormValues.get("remarks_code_2"));
			con						= ConnectionManager.getConnection(request);  //Added for MO-CRF-20165
			grn_newfields_applicable = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","ST_GRN_NEW_FIELDS");   
			if(grn_newfields_applicable){ 
				bean.setGrnRemarks((String)htFormValues.get("remarks"));
			}//end 
		   
		}else if(validate.equals("CONSIGNMENT_ITEM")) { 
		//Added by Rabbani #inc no:30127 on 09/01/11  
		 con						= ConnectionManager.getConnection(request);  //Added for KDAH-CRF-0372
			 try { 
				 site = eCommon.Common.CommonBean.isSiteSpecific(con, "ST","GRN_CONSIGNMENT_ITEM_YN");   //Added for KDAH-CRF-0372
				HashMap  st_detail=bean.fetchRecord("SELECT CONSIGNMENT_ITEM_YN, APPL_FOR_CONS FROM st_item   WHERE item_code = ?",item_code);
				String consignment_item_yn =(String)st_detail.get("CONSIGNMENT_ITEM_YN");
				System.out.println(" consignment_item_yn--->" + consignment_item_yn);
				String appl_for_cons=(String)st_detail.get("APPL_FOR_CONS");
				System.out.println(" appl_for_cons-----> " + appl_for_cons);
				//Added for KDAH-CRF-0372 starts
					if(site){
						if(consignment_item_yn.equals("Y") && appl_for_cons.equals("Y")){
						      result = true;
			                }	
				}else{ //Added for KDAH-CRF-0372 ends
				if(consignment_item_yn.equals("Y") && appl_for_cons.equals("N")){
			      result = true;
			   }else{
			   result = false;
		      }} //Added for KDAH-CRF-0372
			}catch(Exception e){
				e.printStackTrace();
			}
			//Added for KDAH-CRF-0372 starts
				finally{
					con.close();
				}
			//Added for KDAH-CRF-0372 ends
		}
		else if (validate.equals("SET_PO_DETAILS")){
			try{
				//System.out.println("doc_no---375--->"+request.getParameter("doc_no"));
				
				String mode    = bean.checkForNull(request.getParameter("mode"));	
				String doc_no  = bean.checkForNull(request.getParameter("doc_no"));
				String nextdeldate = bean.checkForNull(request.getParameter("nextdeldate"));
				//String pohdrStatus = bean.checkForNull(request.getParameter("pohdrStatus"));// Status is handled in ejb here it is no use.Commented for unused local variable

				//System.out.println("mode---375--->"+mode);

				//bean.setPOhdrStatus(pohdrStatus);

				if(mode.equals("1"))
				bean.doinitialize();
				
				index = "-1";				
				
				HashMap hmTemp = null;
				ArrayList altemp = new ArrayList();
				ArrayList alRecords = new ArrayList();
				HashMap hmRecord = null;
				HashMap hmTempRecord;

				HashMap hmBatchRecord = new HashMap();
				

				ArrayList podetails = bean.getPoItemDetails(doc_no);

//System.out.println("podetails---375--->"+podetails);

				String loc_batch_string = (String)htFormValues.get("loc_batch_string");

				loc_batch_string = loc_batch_string.substring(2,loc_batch_string.length());
				
//System.out.println("loc_batch_string---371--->"+loc_batch_string);


				StringTokenizer stListItems=new StringTokenizer(loc_batch_string,"||");
				//Added for IN:071539(US03) start, commented for (us04)
			/*	int rec_count=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from XI_TRN_PO_DTLS_IB where FACILITY_ID=? and RESP_NUM=?",new String[]{bean.getLoginFacilityId(),doc_no}).get("COUNT"));
				if(rec_count!=0){
				int count_same_doc_type_code=Integer.parseInt((String)	bean.fetchRecord("select count(*) COUNT from XI_TRN_PO_DTLS_IB where FACILITY_ID=? and RESP_NUM=? and DOC_TYPE_CODE=?",new String[]{bean.getLoginFacilityId(),doc_no,bean.getDoc_type_code()}).get("COUNT"));
			System.out.println("doc_type_code>> "+count_same_doc_type_code);
			if(count_same_doc_type_code==0){
				String grn_doc_type_code=bean.getDoc_type_code();
				String po_doc_type_code= (String)	bean.fetchRecord("select DOC_TYPE_CODE from XI_TRN_PO_DTLS_IB where FACILITY_ID=? and RESP_NUM=?",new String[]{bean.getLoginFacilityId(),doc_no}).get("DOC_TYPE_CODE");
				String grn_doc_type_desc = (String)	bean.fetchRecord("SELECT short_desc FROM sy_doc_type_master_lang_vw sy_doc_type_master WHERE doc_type_code=? AND language_id = ?",new String[]{grn_doc_type_code,bean.getLanguageId()}).get("SHORT_DESC");
				String po_doc_type_desc = (String)	bean.fetchRecord("SELECT short_desc FROM sy_doc_type_master_lang_vw sy_doc_type_master WHERE doc_type_code=? AND language_id = ?",new String[]{po_doc_type_code,bean.getLanguageId()}).get("SHORT_DESC");
				System.out.println("doc_type_code>> "+grn_doc_type_code+" "+po_doc_type_code+" "+grn_doc_type_desc+" "+po_doc_type_desc);
				if(po_doc_type_desc==null)
					po_doc_type_desc="";
				out.println("diffDocType(\"" +grn_doc_type_desc+ "\" ,\"" +po_doc_type_desc+ "\");");
				throw new Exception("PO_GRN_DOC_TYPE_DIFFERET"); 
			}
				}*/
				//Added for IN:071539(US03) end,, commented for (us04)

			   while (stListItems.hasMoreTokens()) {
//System.out.println("stListItems======535=========>"+stListItems);
			   StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),";");
				
			   String pitem_code = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String grn_item_qty = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String poitemStatus =  stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String req_no =  stListValueText.hasMoreTokens()?stListValueText.nextToken().trim():"";
			   String do_no =  stListValueText.hasMoreTokens()?stListValueText.nextToken().trim():"";


			   req_no =	bean.checkForNull(req_no);
			   do_no =	bean.checkForNull(do_no);


//System.out.println("pitem_code======535=========>"+pitem_code);
//System.out.println("grn_item_qty======535=========>"+grn_item_qty);
//System.out.println("poitemStatus======535=========>"+poitemStatus);
//System.out.println("req_no======535=========>"+req_no);
//System.out.println("do_no======535=========>"+do_no);

			   boolean check = true;

					String [] param = {pitem_code,store_code};
					HashMap itemstore = bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_ITEM_STORE WHERE ITEM_CODE=? AND STORE_CODE=? " ,param);
					int count = Integer.parseInt((String)itemstore.get("COUNT"));
					if(count==0){
						throw new Exception ("ITEM_STORE_NOT_FOUND");
					}
					result	= bean.isPhysicalInventoryProcessStartedForStore(pitem_code,store_code,"");

					if(result){
						String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{pitem_code,store_code}).get("PHY_INV_ID");
						out.println("document.forms[0].phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					}

				for(int i =0 ;i<podetails.size();i++){

					HashMap podtl = (HashMap)podetails.get(i);

					if(((String)podtl.get("ITEM_CODE")).equals(pitem_code)  &&  (bean.checkForNull((String)podtl.get("REQ_NO"))).equals(req_no) && (bean.checkForNull((String)podtl.get("DO_NO"))).equals(do_no)){		
							
						if (bean.getDtlRecords()!=null && bean.getDtlRecords().size()>0){
							altemp = bean.getDtlRecords();
							for (int j = 0 ; j < altemp.size() ; j++){
								HashMap temp = (HashMap)altemp.get(j);
								if((temp.get("item_code")).toString().equals(pitem_code)) {
									int mdoc_srl_no =  Integer.parseInt((String)temp.get("doc_srl_no"));
									--mdoc_srl_no;

									if(mode.equals("1")){		
										float new_item_qty	= Float.parseFloat((String)temp.get("item_qty_normal"))+ Float.parseFloat(grn_item_qty) ; 
										temp.put("item_qty_normal",	""+new_item_qty);
										
										float new_order_qty	= Float.parseFloat((String)temp.get("ordered_qty"))+ Float.parseFloat((String)podtl.get("ITEM_QTY_NORMAL")) ; 
										temp.put("ordered_qty",	""+new_order_qty);

										float new_item_value	= Float.parseFloat((String)temp.get("item_cost_value"))+ Float.parseFloat((String)podtl.get("ITEM_COST_VALUE")) ; 
										temp.put("item_cost_value",	""+new_item_value);

										float new_item_qty_bonus	= Float.parseFloat((String)temp.get("item_qty_bonus"))+ Float.parseFloat((String)podtl.get("DO_QTY_BONUS")) ; 
										temp.put("item_qty_bonus",	""+new_item_qty_bonus);

										float new_item_qty_sample	= Float.parseFloat((String)temp.get("item_qty_sample"))+ Float.parseFloat(bean.checkForNull((String)podtl.get("DO_QTY_SAMPLE"),"0")) ; 
										temp.put("item_qty_sample",	""+new_item_qty_sample);

									}else if(mode.equals("2")){									
										temp.put("item_qty_normal",	""+grn_item_qty);
										temp.put("ordered_qty",	(String)podtl.get("ITEM_QTY_NORMAL"));
									}
									bean.updateDtlRecord(mdoc_srl_no, temp);
									check = false;
								}
							 }
						 }

						
							hmTemp = new HashMap();

							if(check){
							hmTemp.put("item_code",			pitem_code);
							hmTemp.put("item_desc",			(String)podtl.get("ITEM_DESC"));
							hmTemp.put("expiry_yn",			(String)podtl.get("EXPIRY_YN"));
							hmTemp.put("uom_desc",			(String)podtl.get("GEN_UOM_DESC"));
							hmTemp.put("uom_code",			(String)podtl.get("UOM_CODE"));
							hmTemp.put("pur_uom_code",		(String)podtl.get("PUR_UOM_CODE"));			
							hmTemp.put("item_qty_normal",	grn_item_qty);
							hmTemp.put("item_qty_bonus",	bean.checkForNull((String)podtl.get("DO_QTY_BONUS"),"0"));
							hmTemp.put("item_qty_sample",	bean.checkForNull((String)podtl.get("DO_QTY_SAMPLE"),"0"));
							//hmTemp.put("item_cost_value",	"0");
							hmTemp.put("item_cost_value",			bean.checkForNull((String)podtl.get("ITEM_COST_VALUE"),"0"));							
							hmTemp.put("pur_uom_conv",				(String)podtl.get("PO_GEN_UOM_CONV_FACTOR"));
							hmTemp.put("grn_unit_cost_in_pur_uom",	(String)podtl.get("ITEM_UNIT_COST"));
							hmTemp.put("to_conv_fact",				""+bean.getConvFactTemp(pitem_code,store_code));
							hmTemp.put("ordered_qty",				(String)podtl.get("ITEM_QTY_NORMAL"));
							hmTemp.put("allow_deci_yn",				bean.checkForNull((String)podtl.get("ALLOW_DECIMALS_YN"),"N"));
							hmTemp.put("no_deci",					bean.checkForNull((""+bean.getNoOfDecimals()),"0"));
							hmTemp.put("pur_uom_conv_id",			(String)podtl.get("PO_GEN_UOM_CONV_FACTOR"));
							hmTemp.put("conversion_rate",			(String)podtl.get("CONVERSION_RATE"));
							hmTemp.put("by_po",	"Y");
							hmTemp.put("delivery_date",	bean.checkForNull((String)podtl.get("EXPECTED_DELV_DATE")));
							
							hmTemp.put("label_reqd_yn",		bean.getLabel_reqd_yn(pitem_code)	);//Changed N to getLabel_reqd_yn for NMC-JD-CRF-0208
							hmTemp.put("replace_on_expiry_yn",	"N"	);
							hmTemp.put("no_of_labels",	""	);
							hmTemp.put("po_cost",	""	);
							hmTemp.put("po_discount",	""	);
							hmTemp.put("po_tax",	""	);

							//Added by suresh.r on 04-06-2014 against ML-BRU-SCF-1356 beg
							String uom_description	=	(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{(String)podtl.get("UOM_CODE"), locale}).get("SHORT_DESC");
							String pur_uom_desc		=	(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{(String)podtl.get("PUR_UOM_CODE"), locale}).get("SHORT_DESC");
							
							int am_count		=	Integer.parseInt((String)bean.fetchRecord("SELECT  count(1) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE")}).get("COUNT"));
							int item_uom_count	=	Integer.parseInt((String)bean.fetchRecord("SELECT count(1) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE"),(String)podtl.get("ITEM_CODE")}).get("COUNT"));
							
							if(item_uom_count >0){
								HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty)  conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE"),(String)podtl.get("ITEM_CODE")});
								String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_description+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_desc;
								hmTemp.put("pur_uom_conv_id",conver);
								hmTemp.put("pur_uom_conv",bean.checkForNull((String)stEqvl_value1.get("CONV_FACTOR"),"1"));
							}else if(am_count >0){
								String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE")}).get("EQVL_VALUE");
								String conver=stEqvl_value+" "+uom_description+" = 1 "+pur_uom_desc;
								hmTemp.put("pur_uom_conv_id",conver);
							}else{
								String conver="1"+" "+uom_description+" = 1 "+pur_uom_desc;
								hmTemp.put("pur_uom_conv_id",conver);
							}
							//Added by suresh.r on 04-06-2014 against ML-BRU-SCF-1356 end
							
							bean.updateDtlRecord(Integer.parseInt(index), hmTemp);
							}
						    hmRecord = new HashMap();

							hmRecord.put("po_number",		(String)podtl.get("PO_NO"));
							hmRecord.put("item_code",		(String)podtl.get("ITEM_CODE"));
							hmRecord.put("grn_item_qty",    grn_item_qty);
							hmRecord.put("pur_req_no",		bean.checkForNull((String)podtl.get("REQ_NO")));
							hmRecord.put("pur_req_facility_id",    (String)podtl.get("REQ_FACILITY_ID"));
							hmRecord.put("pur_req_doc_srl_no",		bean.checkForNull((String)podtl.get("REQ_SRL_NO")));
							hmRecord.put("po_doc_srl_no",		(String)podtl.get("PO_SRL_NO"));
							hmRecord.put("pur_unit_code",		(String)podtl.get("PUR_UNIT_CODE"));
							hmRecord.put("store_code",		(String)podtl.get("REQ_STORE_CODE"));
							hmRecord.put("poitemStatus",		poitemStatus);
							hmRecord.put("do_no",		bean.checkForNull((String)podtl.get("DO_NO")));

							alRecords.add(hmRecord);
							
						if(!(do_no.equals(""))){
							ArrayList alBatch = new ArrayList();
							ArrayList alBatch1 = new ArrayList();
							//ArrayList alBatchGroup = new ArrayList(); Commented for unused local variable
							
							String [] parameter = {do_no,(String)podtl.get("PO_NO"),pitem_code,bean.getLoginFacilityId(),store_code,req_no};
							alBatch = bean.fetchRecords("SELECT DO_NO,ITEM_CODE,DO_QTY_NORMAL,BATCH_ID,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE,DO_QTY_NORMAL + NVL(DO_QTY_BONUS,0) - NVL(GRN_QTY,0) AVAIL_QTY,NVL(DO_QTY_BONUS,0)DO_QTY_BONUS ,DO_SRL_NO,TO_CHAR(SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE,DIST_FACILITY_ID,DIST_STORE_CODE,TRADE_ID,PO_NO,PO_SRL_NO,(SELECT BIN_LOCATION_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=A.DIST_STORE_CODE AND ITEM_CODE=A.ITEM_CODE) BIN_LOCATION_CODE FROM PO_DELV_ORD_DTL_BAT A WHERE DO_NO = ? AND PO_NO = ? AND ITEM_CODE = ? AND DIST_FACILITY_ID = ? AND DIST_STORE_CODE = ? AND  NVL(REQ_NO,'*A') = NVL(?,'*A') AND (NVL(DO_QTY_NORMAL,0) - NVL(GRN_QTY,0)) > 0" ,parameter);
							
							for (int j=0; j<alBatch.size(); j++) {
								HashMap hmTempdetail	=	new HashMap();	
								hmTempRecord =	(HashMap)alBatch.get(j);
								hmTempdetail.put("grn_item_qty", hmTempRecord.get("AVAIL_QTY"));             
								hmTempdetail.put("do_qty_bonus", hmTempRecord.get("DO_QTY_BONUS"));             
								hmTempdetail.put("trade_id", hmTempRecord.get("TRADE_ID"));                 
								hmTempdetail.put("expiry_date_or_receipt_date", hmTempRecord.get("EXPIRY_DATE"));
								hmTempdetail.put("item_code", hmTempRecord.get("ITEM_CODE"));                
								hmTempdetail.put("store_code", store_code);               
								hmTempdetail.put("dist_store_code", hmTempRecord.get("DIST_STORE_CODE"));               
								hmTempdetail.put("batch_id", hmTempRecord.get("BATCH_ID"));                 
								hmTempdetail.put("do_no", hmTempRecord.get("DO_NO"));                 
								hmTempdetail.put("po_no", hmTempRecord.get("PO_NO"));                 
								hmTempdetail.put("po_srl_no", hmTempRecord.get("PO_SRL_NO"));                 
								hmTempdetail.put("do_srl_no", hmTempRecord.get("DO_SRL_NO"));                 
								hmTempdetail.put("dist_facility_id", hmTempRecord.get("DIST_FACILITY_ID"));                 
								hmTempdetail.put("sch_delv_date", hmTempRecord.get("SCH_DELV_DATE"));   
								hmTempdetail.put("bin_location_code", hmTempRecord.get("BIN_LOCATION_CODE"));   
								hmTempdetail.put("sale_price", "");
								hmTempdetail.put("by_do", "Y"); 
								
								alBatch.set(j, hmTempdetail);
							}
							
								
							if(hmBatchRecord.containsKey(pitem_code)){
								alBatch1 = (ArrayList)hmBatchRecord.get(pitem_code);

								for(int a=0;a<alBatch.size();a++){
										alBatch1.add(alBatch.get(a));
								}
							}else{
								alBatch1 = alBatch;
							}
						
							hmBatchRecord.put(pitem_code,alBatch1);	
							bean.setExpRecords(bean.getDoc_srl_no()-1, alBatch1);
							//System.out.println("getDoc_srl_nog="+bean.getDoc_srl_no());
						}

						break; 

						}
				   }    
				}				
			
				bean.setPODetails(alRecords);	
				
				if(!(nextdeldate.equals("")))
					bean.setPONextDelDate(nextdeldate);
				

				if(hmBatchRecord!=null){
					bean.setDoExpRecords(hmBatchRecord);
				}
				
//System.out.println("bean.getPoRecords=484"+bean.getPoRecords());
//System.out.println("bean.getExpRecords=485"+bean.getExpRecords());
//System.out.println("hmBatchRecord======535=========>"+hmBatchRecord);
//System.out.println("getDoExpRecords======535=========>"+bean.getDoExpRecords());

				result=true;
			}catch(Exception e){
					result = false;					
					if (e.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw e;
					}
					if (e.getMessage().equals("ITEM_STORE_NOT_FOUND")) {
					throw e;
					}
					throw e;
			}
		}

		else if (validate.equals("SET_DO_DETAILS")){
			try{
				//System.out.println("doc_no---585--->"+request.getParameter("doc_no"));
				
				String mode    = bean.checkForNull(request.getParameter("mode"));	
				String doc_no  = bean.checkForNull(request.getParameter("doc_no"));

				//System.out.println("mode---591--->"+mode);


				if(mode.equals("1"))
				bean.doinitialize();
				
				index = "-1";				
				
				HashMap hmTemp = null;
				ArrayList altemp = new ArrayList();
				ArrayList alRecords = new ArrayList();
				HashMap hmRecord = null;
				HashMap hmTempRecord;

				HashMap hmBatchRecord = new HashMap();
				

				ArrayList podetails = bean.getPoItemDetails(doc_no);

//System.out.println("podetails---608--->"+podetails);

				String loc_batch_string = (String)htFormValues.get("loc_batch_string");

				loc_batch_string = loc_batch_string.substring(2,loc_batch_string.length());
				
//System.out.println("loc_batch_string---614--->"+loc_batch_string);


				StringTokenizer stListItems=new StringTokenizer(loc_batch_string,"||");

			   while (stListItems.hasMoreTokens()) {
//System.out.println("stListItems======620=========");
			   StringTokenizer stListValueText=new StringTokenizer(stListItems.nextToken(),";");
				
			   String pitem_code = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String grn_item_qty = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String do_srl_no = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String sch_date = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String pbatch_id = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String pexpiry_date = stListValueText.hasMoreTokens()?stListValueText.nextToken():"";
			   String req_no =  stListValueText.hasMoreTokens()?stListValueText.nextToken().trim():"";
			   String po_no =  stListValueText.hasMoreTokens()?stListValueText.nextToken().trim():"";
			   String po_srl_no =  stListValueText.hasMoreTokens()?stListValueText.nextToken().trim():"";


			   req_no =	bean.checkForNull(req_no);
			   po_no =	bean.checkForNull(po_no,"*A");
			   po_srl_no =	bean.checkForNull(po_srl_no,"1");


//System.out.println("pitem_code======634=========>"+pitem_code);
//System.out.println("grn_item_qty======635=========>"+grn_item_qty);
//System.out.println("req_no======637=========>"+req_no);
//System.out.println("po_no======637=========>"+po_no);
//System.out.println("po_srl_no======637=========>"+po_srl_no);
//System.out.println("do_srl_no======637=========>"+do_srl_no);
//System.out.println("sch_date======637=========>"+sch_date);
//System.out.println("pbatch_id======637=========>"+pbatch_id);
//System.out.println("pexpiry_date======637=========>"+pexpiry_date);

			   boolean check = true;

					String [] param = {pitem_code,store_code};
					HashMap itemstore = bean.fetchRecord("SELECT COUNT(*) COUNT FROM ST_ITEM_STORE WHERE ITEM_CODE=? AND STORE_CODE=? " ,param);
					int count = Integer.parseInt((String)itemstore.get("COUNT"));
					if(count==0){
						throw new Exception ("ITEM_STORE_NOT_FOUND");
					}
					result	= bean.isPhysicalInventoryProcessStartedForStore(pitem_code,store_code,"");

					if(result){
						String	phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{pitem_code,store_code}).get("PHY_INV_ID");
						out.println("document.forms[0].phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					}

				for(int i =0 ;i<podetails.size();i++){

					HashMap podtl = (HashMap)podetails.get(i);
//System.out.println("podtl======668=========>"+podtl);
					if(((String)podtl.get("ITEM_CODE")).equals(pitem_code) &&  (bean.checkForNull((String)podtl.get("DO_SRL_NO"))).equals(do_srl_no)&&  (bean.checkForNull((String)podtl.get("SCH_DELV_DATE"))).equals(sch_date)&&  (bean.checkForNull((String)podtl.get("BATCH_ID"))).equals(pbatch_id)&&  (bean.checkForNull((String)podtl.get("EXPIRY_DATE"))).equals(pexpiry_date)&&  (bean.checkForNull((String)podtl.get("PO_SRL_NO"))).equals(po_srl_no)&&  
						(bean.checkForNull((String)podtl.get("REQ_NO"))).equals(req_no) && (bean.checkForNull((String)podtl.get("PO_NO"))).equals(po_no)){	

//System.out.println("podtl======668====inside=====>"+podtl);							
						if (bean.getDtlRecords()!=null && bean.getDtlRecords().size()>0){
							altemp = bean.getDtlRecords();
							for (int j = 0 ; j < altemp.size() ; j++){
								HashMap temp = (HashMap)altemp.get(j);
								if((temp.get("item_code")).toString().equals(pitem_code)) {
									int mdoc_srl_no =  Integer.parseInt((String)temp.get("doc_srl_no"));
									--mdoc_srl_no;

									if(mode.equals("1")){		
										float new_item_qty	= Float.parseFloat((String)temp.get("item_qty_normal"))+ Float.parseFloat(grn_item_qty) ; 
										temp.put("item_qty_normal",	""+new_item_qty);
										
										float new_order_qty	= Float.parseFloat((String)temp.get("ordered_qty"))+ Float.parseFloat((String)podtl.get("ITEM_QTY_NORMAL")) ; 
										temp.put("ordered_qty",	""+new_order_qty);

										float new_item_value	= Float.parseFloat((String)temp.get("item_cost_value"))+ Float.parseFloat((String)podtl.get("ITEM_COST_VALUE")) ; 
										temp.put("item_cost_value",	""+new_item_value);

										float new_item_qty_bonus	= Float.parseFloat((String)temp.get("item_qty_bonus"))+ Float.parseFloat(bean.checkForNull((String)podtl.get("DO_QTY_BONUS"),"0")) ; 
										temp.put("item_qty_bonus",	""+new_item_qty_bonus);

										float new_item_qty_sample	= Float.parseFloat((String)temp.get("item_qty_sample"))+ Float.parseFloat((String)podtl.get("DO_QTY_SAMPLE")) ; 
										temp.put("item_qty_sample",	""+new_item_qty_sample);

								

									}else if(mode.equals("2")){									
										//temp.put("item_qty_normal",	""+grn_item_qty); This is commented for Qty should cannot be changed in qry mode
										//temp.put("ordered_qty",	(String)podtl.get("ITEM_QTY_NORMAL"));
									}
									bean.updateDtlRecord(mdoc_srl_no, temp);
									check = false;
								}
							 }
						 }

						
							hmTemp = new HashMap();

							if(check){
							hmTemp.put("item_code",			pitem_code);
							hmTemp.put("item_desc",			(String)podtl.get("ITEM_DESC"));
							hmTemp.put("expiry_yn",			(String)podtl.get("EXPIRY_YN"));
							hmTemp.put("uom_desc",			(String)podtl.get("GEN_UOM_DESC"));
							hmTemp.put("uom_code",			(String)podtl.get("UOM_CODE"));
							hmTemp.put("pur_uom_code",		bean.checkForNull((String)podtl.get("PUR_UOM_CODE")));			
							hmTemp.put("item_qty_normal",	grn_item_qty);
							hmTemp.put("item_qty_bonus",	bean.checkForNull((String)podtl.get("DO_QTY_BONUS"),"0"));
							hmTemp.put("item_qty_sample",	bean.checkForNull((String)podtl.get("DO_QTY_SAMPLE"),"0"));
							//hmTemp.put("item_cost_value",	"0");
							hmTemp.put("item_cost_value",			bean.checkForNull((String)podtl.get("ITEM_COST_VALUE"),"0"));
							hmTemp.put("pur_uom_conv",				(String)podtl.get("DO_CONV_FACTOR"));
							hmTemp.put("grn_unit_cost_in_pur_uom",	(String)podtl.get("ITEM_UNIT_COST"));
							hmTemp.put("to_conv_fact",				""+bean.getConvFactTemp(pitem_code,store_code));
							hmTemp.put("ordered_qty",				(String)podtl.get("ITEM_QTY_NORMAL"));
							hmTemp.put("allow_deci_yn",				bean.checkForNull((String)podtl.get("ALLOW_DECIMALS_YN"),"N"));
							hmTemp.put("no_deci",					bean.checkForNull((""+bean.getNoOfDecimals()),"0"));
							hmTemp.put("pur_uom_conv_id",			(String)podtl.get("DO_CONV_FACTOR"));
							hmTemp.put("conversion_rate",			(String)podtl.get("CONVERSION_RATE"));
							hmTemp.put("by_po",	"Y");
							hmTemp.put("delivery_date",	bean.checkForNull((String)podtl.get("EXPECTED_DELV_DATE")));
							
							hmTemp.put("label_reqd_yn",		"N"	);
							hmTemp.put("replace_on_expiry_yn",	"N"	);
							hmTemp.put("no_of_labels",	""	);
							hmTemp.put("po_cost",	""	);
							hmTemp.put("po_discount",	""	);
							hmTemp.put("po_tax",	""	);
							
							//Added by suresh.r on 04-06-2014 against ML-BRU-SCF-1356 beg
							String uom_description	=	(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{(String)podtl.get("UOM_CODE"), locale}).get("SHORT_DESC");
							String pur_uom_desc		=	(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{(String)podtl.get("PUR_UOM_CODE"), locale}).get("SHORT_DESC");
							
							int am_count		=	Integer.parseInt((String)bean.fetchRecord("SELECT  count(1) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE")}).get("COUNT"));
							int item_uom_count	=	Integer.parseInt((String)bean.fetchRecord("SELECT count(1) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE"),(String)podtl.get("ITEM_CODE")}).get("COUNT"));
							
							if(item_uom_count >0){
								HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty)  conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE"),(String)podtl.get("ITEM_CODE")});
								String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_description+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_desc;
								hmTemp.put("pur_uom_conv_id",conver);
								hmTemp.put("pur_uom_conv",bean.checkForNull((String)stEqvl_value1.get("CONV_FACTOR"),"1"));
							}else if(am_count >0){
								String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{(String)podtl.get("UOM_CODE"), (String)podtl.get("PUR_UOM_CODE")}).get("EQVL_VALUE");
								String conver=stEqvl_value+" "+uom_description+" = 1 "+pur_uom_desc;
								hmTemp.put("pur_uom_conv_id",conver);
							}else{
								String conver="1"+" "+uom_description+" = 1 "+pur_uom_desc;
								hmTemp.put("pur_uom_conv_id",conver);
							}
							//Added by suresh.r on 04-06-2014 against ML-BRU-SCF-1356 end
							
							bean.updateDtlRecord(Integer.parseInt(index), hmTemp);
							}
						    hmRecord = new HashMap();

							hmRecord.put("po_number",		(String)podtl.get("PO_NO"));
							hmRecord.put("item_code",		(String)podtl.get("ITEM_CODE"));
							hmRecord.put("grn_item_qty",    grn_item_qty);
							hmRecord.put("pur_req_no",		bean.checkForNull((String)podtl.get("REQ_NO")));
							hmRecord.put("pur_req_facility_id",    bean.checkForNull((String)podtl.get("REQ_FACILITY_ID")));
							hmRecord.put("pur_req_doc_srl_no",		bean.checkForNull(bean.checkForNull((String)podtl.get("REQ_SRL_NO"))));
							hmRecord.put("po_doc_srl_no",		(String)podtl.get("PO_SRL_NO"));
							hmRecord.put("pur_unit_code",		(String)podtl.get("PUR_UNIT_CODE"));
							hmRecord.put("store_code",		bean.checkForNull((String)podtl.get("REQ_STORE_CODE"),store_code));
							hmRecord.put("poitemStatus",		"");
							hmRecord.put("do_no",		bean.checkForNull((String)podtl.get("DO_NO")));

							alRecords.add(hmRecord);
							
						//if(!(do_no.equals(""))){
							ArrayList alBatch = new ArrayList();
							ArrayList alBatch1 = new ArrayList();
							//ArrayList alBatchGroup = new ArrayList(); Commented for unused local variable
				
							String [] parameter = {doc_no,pitem_code,do_srl_no,sch_date,po_no,po_srl_no,pbatch_id,pexpiry_date,bean.getLoginFacilityId(),store_code};
							alBatch = bean.fetchRecords("SELECT DO_NO,ITEM_CODE,DO_QTY_NORMAL,BATCH_ID,TO_CHAR(EXPIRY_DATE,'DD/MM/YYYY')EXPIRY_DATE,DO_QTY_NORMAL + NVL(DO_QTY_BONUS,0) - NVL(GRN_QTY,0) AVAIL_QTY,NVL(DO_QTY_BONUS,0) DO_QTY_BONUS ,DO_SRL_NO,TO_CHAR(SCH_DELV_DATE,'DD/MM/YYYY')SCH_DELV_DATE,DIST_FACILITY_ID,DIST_STORE_CODE,TRADE_ID,PO_NO,PO_SRL_NO,(SELECT BIN_LOCATION_CODE FROM ST_ITEM_STORE WHERE STORE_CODE=A.DIST_STORE_CODE AND ITEM_CODE=A.ITEM_CODE) BIN_LOCATION_CODE FROM PO_DELV_ORD_DTL_BAT A WHERE DO_NO = ? AND ITEM_CODE = ? AND DO_SRL_NO = ? AND TRUNC(SCH_DELV_DATE) = TO_DATE(? ,'DD/MM/YYYY') AND PO_NO = ? AND PO_SRL_NO = ? AND BATCH_ID = ? AND TRUNC(EXPIRY_DATE) = TO_DATE(? ,'DD/MM/YYYY')  AND DIST_FACILITY_ID = ? AND DIST_STORE_CODE = ? AND (NVL(DO_QTY_NORMAL,0) - NVL(GRN_QTY,0)) > 0" ,parameter);
							
							for (int j=0; j<alBatch.size(); j++) {
								HashMap hmTempdetail	=	new HashMap();	
								hmTempRecord =	(HashMap)alBatch.get(j);
								hmTempdetail.put("grn_item_qty", hmTempRecord.get("AVAIL_QTY"));             
								hmTempdetail.put("do_qty_bonus", hmTempRecord.get("DO_QTY_BONUS"));             
								hmTempdetail.put("trade_id", hmTempRecord.get("TRADE_ID"));                 
								hmTempdetail.put("expiry_date_or_receipt_date", hmTempRecord.get("EXPIRY_DATE"));
								hmTempdetail.put("item_code", hmTempRecord.get("ITEM_CODE"));                
								hmTempdetail.put("store_code", store_code);               
								hmTempdetail.put("dist_store_code", hmTempRecord.get("DIST_STORE_CODE"));               
								hmTempdetail.put("batch_id", hmTempRecord.get("BATCH_ID"));                 
								hmTempdetail.put("do_no", hmTempRecord.get("DO_NO"));                 
								hmTempdetail.put("po_no", hmTempRecord.get("PO_NO"));                 
								hmTempdetail.put("po_srl_no", hmTempRecord.get("PO_SRL_NO"));                 
								hmTempdetail.put("do_srl_no", hmTempRecord.get("DO_SRL_NO"));                 
								hmTempdetail.put("dist_facility_id", hmTempRecord.get("DIST_FACILITY_ID"));                 
								hmTempdetail.put("sch_delv_date", hmTempRecord.get("SCH_DELV_DATE"));                 
								hmTempdetail.put("bin_location_code", hmTempRecord.get("BIN_LOCATION_CODE"));                 
								hmTempdetail.put("sale_price", "");                 
								hmTempdetail.put("by_do", "Y");                 
								
								alBatch.set(j, hmTempdetail);
							}
							
								
							if(hmBatchRecord.containsKey(pitem_code)){
								alBatch1 = (ArrayList)hmBatchRecord.get(pitem_code);

								for(int a=0;a<alBatch.size();a++){
										alBatch1.add(alBatch.get(a));
								}
							}else{
								alBatch1 = alBatch;
							}
						
							hmBatchRecord.put(pitem_code,alBatch1);		
							bean.setExpRecords(bean.getDoc_srl_no()-1, alBatch1);
							//System.out.println("getDoc_srl_no="+bean.getDoc_srl_no());
						//}

						break; 

						}
				   }    
				}				
			
				bean.setPODetails(alRecords);	


				if(hmBatchRecord!=null){
					bean.setDoExpRecords(hmBatchRecord);
				}
				
//System.out.println("bean.getPoRecords=792"+bean.getPoRecords());
//System.out.println("bean.getExpRecords=793"+bean.getExpRecords());
//System.out.println("hmBatchRecord======794=========>"+hmBatchRecord);
//System.out.println("getDoExpRecords======795=========>"+bean.getDoExpRecords());

				result=true;
			}catch(Exception e){
					result = false;					
					if (e.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw e;
					}
					if (e.getMessage().equals("ITEM_STORE_NOT_FOUND")) {
					throw e;
					}
					throw e;
			}
		}
		// Added for IN:071539 start
		else if(validate.equals("SUPP_CODE")){
			
			String po_no	= request.getParameter("po_no");
			String [] param = {po_no};
			String suplier	=	(String)bean.fetchRecord("select hdr.supp_code from  po_order_hdr hdr, ap_supplier sp where hdr.SUPP_CODE=SP.SUPP_CODE and HDR.PO_NO=?",param).get("SUPP_CODE");//Chnaged selecting short name to supp code for NMC-JD-SCF-0326 supp code going wrongly
			System.err.println("suplier==="+suplier+"po_no=="+po_no);
			
			if(suplier==null){
				throw new Exception ("SUPPLIER_NOT_FOUND");
			}
			else{
				out.println("document.formGoodsReceivedNoteHeader.supp_code_new.value = '"+bean.checkForNull(suplier,"")+"';");
			}
	     		
		}
		// Added for IN:071539 end
	else if(validate.equals("GET_MANUFACTURER")){//Added for MO-CRF-20165 START
			String [] param = {item_code};
			HashMap manufacturer_id  = bean.fetchRecord("select MANUFACTURER_ID from mm_item where ITEM_CODE=? " ,param);
			String manufacId =(String)manufacturer_id.get("MANUFACTURER_ID"); 
			System.out.println("manufacId: "+manufacId); 
			if(manufacId!=null){ 
				out.println("document.formGoodsReceivedNoteListHeader.manufacturer_id.value = '"+bean.checkForNull(manufacId,"")+"';"); 
			}
			//message = manufacId; 
			bean.setManufacturerId(manufacId); 
		}
else if (validate.equals("SET_ITEM_REMARKS")){
		String item_remarks = request.getParameter("item_remarks");  
		out.println("document.formReplaceGRNItemRemarks.remarks.value = '"+bean.checkForNull(item_remarks,"")+"';");   
		bean.setItemRemarks(item_remarks); 
	}//END 
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
		  out.println("document.formGoodsReceivedNoteListHeader.item_desc.value = '"+bean.checkForNull(Item_desc_val,"")+"';");
		  out.println("document.formGoodsReceivedNoteListHeader.barcode.value = ''");
		    result=true;
		}else{
			out.println("document.formGoodsReceivedNoteListHeader.barcode.value = ''");
			if(item_code.equals(barcode_item)){
				for(int i=0;i<batchData.size();i+=2){
			     out.println("parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.document.formGoodsReceivedNoteListDetail.expiry_date_or_receipt_date_"+j+".value = '"+batchData.get(i+1)+"';");
				 out.println("parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.document.formGoodsReceivedNoteListDetail.batch_id_"+j+".value = '"+batchData.get(i)+"';");
				 j++;
				}
			}
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
}//END 
else if (validate.equals("ASSIGN_EXP")){
		 item_code =request.getParameter("item_code")==null?"":request.getParameter("item_code");  
		 HashMap barcodeData  =new HashMap();
		 LinkedList batchData=new LinkedList();	 
         barcodeData =bean.getBarcodeData();
		 int j =0;
		if(barcodeData.containsKey(item_code)){
			batchData = (LinkedList)barcodeData.get(item_code);
			for(int i=0;i<batchData.size();i+=2){
			     out.println("parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.document.formGoodsReceivedNoteListDetail.expiry_date_or_receipt_date_"+j+".value = '"+batchData.get(i+1)+"';");
				 out.println("parent.parent.frameGoodsReceivedNoteList.frameGoodsReceivedNoteListDetail.document.formGoodsReceivedNoteListDetail.batch_id_"+j+".value = '"+batchData.get(i)+"';");
				 j++;
				}
		}
		
	}//Adding end for MOHE-CRF-0167 
	


	}catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	}
	finally{
			if(flag_1.equals(""))
		{
			out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
			if(con!=null){//added for MO-CRF-20165 
				ConnectionManager.returnConnection(con,request); 
			}
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean("goodsReceivedNoteBean",bean,request);

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
