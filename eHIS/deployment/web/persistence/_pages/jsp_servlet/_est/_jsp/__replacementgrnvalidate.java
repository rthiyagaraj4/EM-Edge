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
import java.io.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __replacementgrnvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ReplacementGRNValidate.jsp", 1719569491215L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");

	ReplacementGRNBean bean = (ReplacementGRNBean)getBeanObject( "replacementGRNBean", "eST.ReplacementGRNBean",request) ;  
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
	String rtv_unit_cost				=	request.getParameter("rtv_unit_cost");

	String doc_srl_no				=	request.getParameter("doc_srl_no");
//	String item_unit_cost			=	request.getParameter("item_unit_cost");
	String item_cost_value			=	request.getParameter("item_cost_value");
	String expiry_yn				=	bean.checkForNull(request.getParameter("expiry_yn"),"");
	//String stock_item_yn			=	request.getParameter("stock_item_yn");
	String label_reqd_yn			=	bean.checkForNull(request.getParameter("label_reqd_yn")).equals("true")?"Y":"N";
	String replace_on_expiry_yn		=	bean.checkForNull(request.getParameter("replace_on_expiry_yn")).equals("true")?"Y":"N";
	String index					=	request.getParameter("index");
	String to_conv_fact				=	request.getParameter("to_conv_fact");
	String po_cost					=	request.getParameter("po_cost");
	String po_discount				=	request.getParameter("po_discount");
	String po_tax					=	request.getParameter("po_tax");
	String allow_deci_yn            =   bean.checkForNull(request.getParameter("allow_yn"),"N");
	String no_deci            =   bean.checkForNull(request.getParameter("no_decimals"),"0");
	boolean	result					=	false;
	String pur_uom_conv_id           =   bean.checkForNull(request.getParameter("pur_uom_conv_id"),pur_uom_conv);
	try {
//		out.println("alert('"+item_code+"');");
	//	String operation							=	request.getParameter("operation");
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
			hashmapDtl.put("rtv_unit_cost",	rtv_unit_cost	);
			hashmapDtl.put("no_of_labels",	no_of_labels	);
			hashmapDtl.put("to_conv_fact",	to_conv_fact	);
			hashmapDtl.put("po_cost",		po_cost	);
			hashmapDtl.put("po_discount",	po_discount	);
			hashmapDtl.put("po_tax",		po_tax	);
			hashmapDtl.put("no_deci",		no_deci);
			hashmapDtl.put("allow_deci_yn",		allow_deci_yn);
			hashmapDtl.put("pur_uom_conv_id",	pur_uom_conv_id);

			String[] stNames={"item_code"};
			String[] stValues={item_code};
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index)))
				throw new Exception("RECORD_ALREADY_EXISTS");

			

			result			=	true;

			//checking for RTV Ref details...if RTV Ref is null thrown error..
             
            HashMap hmRTVDtlRecord = new HashMap();
            hmRTVDtlRecord = bean.getGRNRecords() ;

			if(hmRTVDtlRecord.size() > 0)
			{
              if(hmRTVDtlRecord.get(item_code) == null )
  				throw new Exception("RTV_REF_CANNOT_BLANK");
			}
			else
			{
				throw new Exception("RTV_REF_CANNOT_BLANK");

			}
			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);
			//ended...
		}
		// from here
		else if(validate.equals("GET_STATUS")) {
			String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
//			String[] stParameters = {item_code, store_code, "0", "N", "", "N", "" };
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			
			result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
				if(result)
				{
					String phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					out.println("document.formGoodsReceivedNoteListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}

			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				throw new Exception("RECORD_ALREADY_EXISTS");
			try { 
				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				/* @Name - Priya
				* @Date - 31/05/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and passed it in the setStockDetails() function and  assign it to the item_unit_cost field
				*/
				String storeItemUnitCost=bean.getUnitCost(item_code,store_code);
			 	//out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\");");
				out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+storeItemUnitCost+"\");");

				boolean bLabel_reqd_yn	= bean.getLabel_reqd_yn(item_code).equals("Y");
				out.println("document.formGoodsReceivedNoteListHeader.label_reqd_yn.checked="+bLabel_reqd_yn+";");
				out.println("document.formGoodsReceivedNoteListHeader.no_of_labels.disabled=!"+bLabel_reqd_yn+";");

				
			}
			catch (Exception exception) {
		//		exception.printStackTrace();
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
					throw exception;
				}
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}

				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
			result=true;
		}else if(validate.equals("setToConv")){
			double tmp_conv=bean.getConvFactTemp(item_code,store_code);
			bean.setTempConvFact(tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
		}else if(validate.equals("setToConv1")){
			int tmp_conv=Integer.parseInt(request.getParameter("tmp_conv"));
			bean.setTempConvFact(tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
		}
		else if(validate.equals("SET_PUR_UOM_LIST")){
			try { 	out.println("clearListItemsNoSelect('document.formGoodsReceivedNoteListHeader.pur_uom_code'); ");
				uom_code		= request.getParameter("uom_code");
			 		ArrayList alEncounterList = bean.getPur_uom_code_Lists(uom_code,item_code);
					HashMap record	=	null;
					for(int i=0; i< alEncounterList.size(); i++) 
					{
						record				=	(HashMap)alEncounterList.get(i);
						String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
						String listRecord2	=	(String)record.get("SHORT_DESC");
						out.println("addListItem(\"document.formGoodsReceivedNoteListHeader.pur_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +uom_code+"\") ; ");
					}
					}
				catch (Exception exception) {
				exception.printStackTrace();
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
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, pur_uom_code,item_code}).get("COUNT"));
				if(item_uom_count >0){

				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty)  conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, pur_uom_code,item_code});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+ uom_code+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_code;
				String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				
				}else if(am_count>0){
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
			}
			catch (Exception exception) {
				exception.printStackTrace();
				throw new Exception("NO_CONV_FAC_FOR_PUR_UOM_CODE");
			}
		}
		else if(validate.equals("CHECK_RTV_UNIT_COST")) {
			result = true;
			HashMap hmgrnrecords = new HashMap();
			HashMap hmrtvdetails = new HashMap();
			hmgrnrecords = bean.getGRNRecords();
			ArrayList arrrtvdtl = (ArrayList) hmgrnrecords.get(item_code);
			String rtv_unit_cost_temp = (String)(((HashMap) arrrtvdtl.get(0)).get("rtv_unit_cost"));
			for (int i = 0;i<arrrtvdtl.size();i++)
			{
				hmrtvdetails = (HashMap) arrrtvdtl.get(i);
				if (rtv_unit_cost_temp != hmrtvdetails.get("rtv_unit_cost"))
				{
					result = false;
					break;
				}
			}
			if(result)
			{
				flag =rtv_unit_cost_temp;
			}
	}
	else if (validate.equals("DISP_PUR_COST")){
			try{
				/**
				 * @Name - Priya
				 * @Date - 31/05/2010
				 * @Inc# - 
				 * @Desc -  To get no of decimals for cost
				 */
				int noOfDecimalsForCost=Integer.parseInt(bean.getNoOfDecimalsCost());
				String last_pur_cost=bean.setNumber(bean.checkForNull(bean.getLastPurCost(item_code,store_code),"0"),noOfDecimalsForCost);
				out.println("document.formGoodsReceivedNoteListHeader.rtv_unit_cost.value='"+last_pur_cost+"';");
				out.println("set_unit_cost('"+last_pur_cost+"');");
				
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}
		else if(validate.equals("SET_REMARKS")) {
			bean.setRemarks((String)htFormValues.get("remarks_code_2"));
		}
		//Added by Rabbani #Inc no :42903(TTM-SCF-0026) on 05-AUG-13
		else if (validate.equals("printOnlineDoc")){
			try{
			ArrayList doc_no=bean.getPrintDocNo();
			ArrayList alResult = new ArrayList();
			HashMap hmTemp = new HashMap();
			String pdocno = "";
			
			String pdoc_type_code = bean.checkForNull(bean.getPrintDocTypecode());
			for(int k=0;k<doc_no.size();k++){
				pdocno = (String)doc_no.get(k);
				
			 alResult = bean.fetchRecords("SELECT ITEM_CODE,LABEL_REQD_YN, NO_OF_LABELS FROM ST_GRN_DTL WHERE DOC_TYPE_CODE = ? AND DOC_NO = ?",new String[]{pdoc_type_code,pdocno});
		 
			for(int i=0;i<alResult.size();i++){
				hmTemp = (HashMap)alResult.get(i);
				no_of_labels = bean.checkForNull((String)hmTemp.get("NO_OF_LABELS"),"0");
				if(((String)hmTemp.get("LABEL_REQD_YN")).equals("Y") && !(no_of_labels).equals("0")){
						bean.doOnlineReportPrintingOfLabel(pdocno,request,response); 
				}
			 }
			 }
			 pdocno = "";
			for(int i=0;i<doc_no.size();i++){
				pdocno=(String)doc_no.get(i);
				bean.doOnlineReportPrinting(pdocno,request,response);
			}
			}catch(Exception e){
				e.printStackTrace();
			}
			result =  true;
			message = request.getParameter("msg");
		}

	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
//		exception.printStackTrace();
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean("replacementGRNBean",bean,request);

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
