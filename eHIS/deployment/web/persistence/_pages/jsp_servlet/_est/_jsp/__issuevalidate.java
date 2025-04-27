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
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __issuevalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/IssueValidate.jsp", 1720592921182L ,"10.3.6.0","Asia/Calcutta")) return true;
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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	IssueBean bean = (IssueBean)getBeanObject( "issueBean","eST.IssueBean", request ) ;  
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
	String to_store					=	request.getParameter("to_store_code");
	String item_qty					=	request.getParameter("item_qty");
	String for_bin_to_store_hidden	=	request.getParameter("for_bin_to_store_hidden");
		
	String uom_desc					=	request.getParameter("uom_desc");
	String stock_available			=	request.getParameter("stock_available");

	String remarks					= bean.checkForNull(request.getParameter("remarks"),"");
	String remarks_code				=	bean.checkForNull(request.getParameter("remarks_code"),"");
	//	String patient_id				=	request.getParameter("patient_id");

	String stock_item_yn			=	request.getParameter("stock_item_yn");
	String doc_srl_no				=	request.getParameter("doc_srl_no");
	String item_unit_cost			=	request.getParameter("item_unit_cost");
	String item_cost_value			=	request.getParameter("item_cost_value");
	String expiry_yn				=	request.getParameter("expiry_yn");
	//String stock_uom_code			=	request.getParameter("stock_uom_code");
	String uom_code					=	request.getParameter("uom_code");
	String index					=	request.getParameter("index");
	String close_yn					=	request.getParameter("close");
	String iss_uom_code				=	request.getParameter("iss_uom_code");
	String uom_conv_code			=	request.getParameter("uom_conv_code");
	String iss_uom_qty				=	request.getParameter("iss_uom_qty");
	String expired_batch			=	request.getParameter("expired_batch");
	String ex_param_days			=	request.getParameter("ex_param_days");
	String to_conv_fact				=	request.getParameter("to_conv_fact");
	String frm_conv_fact			=	request.getParameter("frm_conv_fact");

	String frm_store_uom_desc		=	request.getParameter("frm_store_uom_desc");
	String to_store_uom_desc		=	request.getParameter("to_store_uom_desc");
	String batch_records			=	request.getParameter("batch_records");
	String stock_uom_desc			=	request.getParameter("stock_uom_desc");
	String kit_item_yn				=	request.getParameter("kit_item_yn");
	String kit_template_uom			=	request.getParameter("kit_template_uom");
	String iss_uom_conv_text		=	request.getParameter("iss_uom_conv_text");
    String from_multiples			=	bean.checkForNull(request.getParameter("from_multiples"),"1");
    String to_multiples				=	bean.checkForNull(request.getParameter("to_multiples"),"1");
    String batch_multiples			=	bean.checkForNull(request.getParameter("batch_multiples"),"1");
    String issue_uom_multiples		=	bean.checkForNull(request.getParameter("issue_uom_multiples"),"1");
	String kit_temp_code             =  bean.checkForNull(request.getParameter("kit_temp_code"),"");  
    String usage_type                =  bean.checkForNull(request.getParameter("usage_type"),"");    
	HashMap hmminmaxlist=new HashMap();
	boolean	result					=	false;
	HashMap hresult= null;
	ArrayList alBatchRecords = null;
	
	try {
//		out.println("alert('"+item_code+"');");
		//String operation							=	request.getParameter("operation");
		if (validate.equals("ADD_TO_LIST")) {
			String barcode_scanned_yn	=  bean.checkForNull(request.getParameter("barcode_scanned_yn"),"N");//added for RUT-CRF-0079
			  //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014 STARTS
			  String iss_item_hold_yn         =  bean.checkForNull(request.getParameter("iss_item_hold_yn"),"Y"); 
			  String iss_item_hold_qty        =  bean.checkForNull(request.getParameter("iss_item_hold_qty"));  
			  String iss_item_hold_chk        =  bean.checkForNull(request.getParameter("iss_item_hold_chk"),"N"); 
			  
			  
			flag="";
			hashmapDtl.put("for_bin_to_store_hidden",		for_bin_to_store_hidden);
			hashmapDtl.put("doc_srl_no",		doc_srl_no		);
			hashmapDtl.put("item_code",			item_code		);
			hashmapDtl.put("item_desc",			item_desc		);
			hashmapDtl.put("stock_item_yn",		stock_item_yn	);
			hashmapDtl.put("expiry_yn",			expiry_yn		);
			hashmapDtl.put("uom_code",			uom_code		);
			hashmapDtl.put("item_qty",			item_qty		);
			hashmapDtl.put("item_unit_cost",	item_unit_cost	);
			hashmapDtl.put("item_cost_value",	item_cost_value	);
			hashmapDtl.put("uom_desc",			uom_desc		);
			hashmapDtl.put("stock_uom_desc",	stock_uom_desc	); 
			hashmapDtl.put("stock_available",	stock_available	);
			hashmapDtl.put("store_code",		store_code		);
			hashmapDtl.put("issue_uom",			iss_uom_code	);
			hashmapDtl.put("issue_uom_conv",	uom_conv_code	);
			hashmapDtl.put("issue_uom_qty",		iss_uom_qty		);
			hashmapDtl.put("includeSuspendedBatches",htFormValues.get("includeSuspendedBatches"));
			hashmapDtl.put("expired_batch",		expired_batch	);
			hashmapDtl.put("ex_param_days",		ex_param_days	);	
			hashmapDtl.put("to_conv_fact",		to_conv_fact	);
			hashmapDtl.put("frm_conv_fact",		frm_conv_fact	);
			hashmapDtl.put("frm_store_uom_desc",frm_store_uom_desc	);
			hashmapDtl.put("to_store_uom_desc",	to_store_uom_desc	);
			hashmapDtl.put("batch_records",		batch_records);
			hashmapDtl.put("batch_records",		batch_records);
			hashmapDtl.put("remarks",			remarks);
			hashmapDtl.put("remarks_code",		remarks_code);
			hashmapDtl.put("kit_template_uom",	kit_template_uom);
			hashmapDtl.put("kit_item_yn",		kit_item_yn);
			hashmapDtl.put("iss_uom_conv_text",		iss_uom_conv_text);
			hashmapDtl.put("from_multiples",	from_multiples);
			hashmapDtl.put("to_multiples",		to_multiples);
			hashmapDtl.put("batch_multiples",	batch_multiples);
			hashmapDtl.put("issue_uom_multiples",	issue_uom_multiples);
			hashmapDtl.put("kit_temp_code",	kit_temp_code);
			hashmapDtl.put("usage_type",	usage_type);
			//Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			hashmapDtl.put("iss_item_hold_yn",	iss_item_hold_yn); 
			hashmapDtl.put("iss_item_hold_qty",	iss_item_hold_qty);  
			hashmapDtl.put("iss_item_hold_chk",	iss_item_hold_chk);
           //ENDS	
			
			if(barcode_scanned_yn.equals("Y"))
				hashmapDtl.put("barcode_item_exist",	"M");//added for RUT-CRF-0079
			 
			bean.setRemarks(remarks);
			String[] stNames={"item_code"};
			String[] stValues={item_code};
			if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,Integer.parseInt(index))) { 
				throw new Exception("RECORD_ALREADY_EXISTS");
			}

			bean.updateDtlRecord(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecords(Integer.parseInt(index), htFormValues);

			/*  ========= Start of Min Max Validation ===========*/
			hmminmaxlist.put("frm_store_qty_on_hand",  request.getParameter("frm_store_qty_on_hand"));	
			hmminmaxlist.put("frm_store_min_stk_level",request.getParameter("frm_store_min_stk_level"));	
			hmminmaxlist.put("frm_store_max_stk_level",request.getParameter("frm_store_max_stk_level"));	
			hmminmaxlist.put("frm_store_reorder_level",request.getParameter("frm_store_reorder_level"));	
			hmminmaxlist.put("to_store_qty_on_hand",   request.getParameter("to_store_qty_on_hand"));	
			hmminmaxlist.put("to_store_min_stk_level", request.getParameter("to_store_min_stk_level"));	
			hmminmaxlist.put("to_store_max_stk_level", request.getParameter("to_store_max_stk_level"));	
			hmminmaxlist.put("to_store_reorder_level", request.getParameter("to_store_reorder_level"));	

			bean.updateMinMaxRecords(Integer.parseInt(index), hmminmaxlist);


			if(bean.getBarcodeApplicable().equals("Y")){
			hashmapDtl.put("ADD","NO");
			htFormValues.put("pindex",		""+index);
			bean.updateDtlRecordforBarCode(Integer.parseInt(index), hashmapDtl);
			bean.updateExpRecordsforBarCode(Integer.parseInt(index), htFormValues);
			bean.updateMinMaxRecordsforBarcode(Integer.parseInt(index), hmminmaxlist);
			}	 




//			bean.setDetailValues(hashmapDtl);
//			bean.setExpValues(htFormValues);
//			out.println("alert(\"item_code:"+item_code+"\");");
			//out.println("alert('bean:"+bean+"');");
			result			=	true;
		}
		// from here
		else if(validate.equals("GET_STATUS")) {
			String[] stParameters = {item_code, store_code, "0", "N", "", "N", to_store };
			String phy_inv_id = "";
			try { 

				result = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,to_store);
				if(result){
						phy_inv_id=(String)bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					if(bean.checkForNull(phy_inv_id,"").equals(""))
						phy_inv_id=(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,to_store}).get("PHY_INV_ID");
					out.println("document.formIssueListHeader.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
					throw new Exception("PHY_INV_PROCESS_INITIATED");
				}

				String[] stNames={"item_code"};
				String[] stValues={item_code};
				//if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1))
				//	throw new Exception("RECORD_ALREADY_EXISTS");


				if(bean.getBarcodeApplicable().equals("Y")){
				//if (bean.isDuplicateInArrayList(bean.getDtlRecordsforBarCode(),stNames,stValues,-1)){
				//	throw new Exception("RECORD_ALREADY_EXISTS");
				//}
				}
				else{
				if (bean.isDuplicateInArrayList(bean.getDtlRecords(),stNames,stValues,-1)){
					throw new Exception("RECORD_ALREADY_EXISTS");
				}
				}


				HashMap hmStockAvailabilityStatus = bean.getStockAvailabilityStatus(stParameters);
				/* @Name - Priya
				* @Date - 02/06/2010
				* @Inc# - 
				* @Desc - To get the Unit Cost from the function 'ST_DISPLAY_COST_DECIMALS' and passed it in the setStockDetails() function and  assign it to the item_unit_cost field
				*/
				//String storeItemUnitCost=bean.getUnitCost(item_code,store_code);
				Double storeItemUnitCost=bean.getBaseUnitCost(item_code);//Added against inc#50521 to display base unit cost

				//out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("to_stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("store_item_unit_cost")+"\",\""+hmStockAvailabilityStatus.get("available_stock")+"\",\""+bean.getConvFactTemp(item_code,store_code)+"\");");
				out.println("setStockDetails(\""+hmStockAvailabilityStatus.get("stock_item_yn")+"\",\""+hmStockAvailabilityStatus.get("to_stock_item_yn")+"\",\""+storeItemUnitCost+"\",\""+hmStockAvailabilityStatus.get("available_stock")+"\",\""+bean.getConvFactTemp(item_code,store_code)+"\");");
				if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y"))
				{
					if( !(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) > 0))
						throw new Exception("STOCK_NOT_AVAILABLE");
				} else
					throw new Exception("NOT_STOCK_ITEM");
			
			result		=	true;
			
			//code added for Issue UOM Details...
							
				String iss_default_uom		= bean.getDefaultIssueUOM(item_code,store_code);
				String gen_uom_code			= bean.getGenItemUOM(item_code);
				out.println("clearListItems('document.formIssueListHeader.iss_uom_code'); ");
			 		ArrayList iss_results = bean.getPur_uom_code_List(gen_uom_code,item_code);
					HashMap record	= null;
					for(int i=0; i< iss_results.size(); i++) 
					{
						record	=	(HashMap)iss_results.get(i);
						String listRecord1	=	(String)record.get("EQVL_UOM_CODE");
						String listRecord2	=	(String)record.get("SHORT_DESC");
						if(iss_default_uom !=null || iss_default_uom ==""){
							out.println("addListItem(\"document.formIssueListHeader.iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\",\"" +iss_default_uom+"\") ; ");
						}else{
							out.println("addListItem(\"document.formIssueListHeader.iss_uom_code\", \"" +listRecord1+ "\",\"" +listRecord2+ "\" ,\"" +gen_uom_code+"\") ; ");
						}
					}

					out.println("checkUOMConvFactor();");

			//code ended...
			}
			catch (Exception exception) {
		//		exception.printStackTrace();
				if (exception.getMessage().equals("RECORD_ALREADY_EXISTS")) {
					throw exception;
				}
				if (exception.getMessage().equals("PHY_INV_PROCESS_INITIATED")) {
					throw exception;
				}
				if (exception.getMessage().equals("STOCK_NOT_AVAILABLE")) {
					throw exception;
				}
				if (exception.getMessage().equals("NOT_STOCK_ITEM")) {
					throw exception;
				}
				
				throw new Exception("ITEM_STORE_NOT_FOUND");
			}
		}
		else if(validate.equals("CHECK_AUTHORIZE_ALLOWED")) {
			String stAuthorized_allowed	=	bean.getFinalize_allowed_yn(store_code);
			out.println("setFinalize_allowed('"+stAuthorized_allowed+"');");
			result=true;
		}
		else if(validate.equals("VALIDATE_DATA")) {
			result = false;
			try{
			//String validate_for_bin_to_store = bean.checkForNull(request.getParameter("for_bin_to_store_hidden"));
			ArrayList dtlRecords = (ArrayList)bean.getDtlRecords();
			HashMap hmDtlRecords = null;
			for(int i=0;i<dtlRecords.size();i++){
				hmDtlRecords = (HashMap)dtlRecords.get(i);
				if(((String)hmDtlRecords.get("for_bin_to_store_hidden")).equals("Y")){
					hresult = bean.validateData(i);
					result = ((Boolean)hresult.get("result")).booleanValue();
					if (!(((Boolean)hresult.get("result")).booleanValue())){
						message="TO_BIN_LOC_NOT_BLANK";
						flag = flag + (String)hresult.get("flag");
					}
				}
			}
			if((((String)flag).equals(""))){
				result = true;
			}
			}catch(Exception e){
				e.printStackTrace();
			}

		}

		else if (validate.equals("printOnlineDoc")){
			try{
			//String pdocno=bean.getPrintDocNo();
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

		else if(validate.equals("SET_REMARKS")) {
			bean.setHdrRemarks((String)htFormValues.get("remarks"));
			bean.setRemarks_code((String)htFormValues.get("remarks_code_2"));
		//	out.println("rem_fun(\"" + (String)htFormValues.get("remarks") + "\")" );
		}
		else if(validate.equals("SET_CLOSE_YN")) {
			bean.setClose_yn(close_yn);
		}
		else if(validate.equals("setnewbatch")) 
		{
				try
				{
						BatchSearchBean bean2 = (BatchSearchBean) getBeanObject("batchSearchBean","eST.BatchSearchBean",request );
						alBatchRecords = bean2.getSelectedList();
						bean.setExpRecords( Integer.parseInt(index), alBatchRecords);
						result =  true;
				}
				catch (Exception exception) 
				{
						result		=	false;
						message		=	exception.getMessage();
						exception.printStackTrace();
				}
		}
		else if(validate.equals("GET_INDEX")) {
			ArrayList alDetailData=(ArrayList)bean.getDtlRecords();
			HashMap hmRecord	= null;
			for(int i=0;i<alDetailData.size();i++){
				hmRecord	=	(HashMap)alDetailData.get(i);
				if (item_code.equals((String) hmRecord.get("item_code"))) {
					message=""+i;
					return;
				}
			}
		}
		else if(validate.equals("setToConv")){
			double tmp_conv=bean.getConvFactTemp(item_code,to_store);
			bean.setTempConvFact(tmp_conv);
			out.println("setTempConvFactor('"+tmp_conv+"');");
			double frm_tmp_conv=bean.getConvFactTemp(item_code,store_code);
			bean.setFrmTempConvFact(frm_tmp_conv);
			out.println("setFrmTempConvFactor('"+frm_tmp_conv+"');");
		}
		else if(validate.equals("KIT_TEMPLATE")){
			try{
				String kit_template_code = (String)request.getParameter("kit_template_code")==null?"":(String)request.getParameter("kit_template_code");
				String to_store_code = (String)request.getParameter("to_store_code")==null?"":(String)request.getParameter("to_store_code");
				 store_code = (String)request.getParameter("store_code")==null?"":(String)request.getParameter("store_code");
				
				if(!(kit_template_code.equals(""))){
					bean.kitTemplateValues(kit_template_code,store_code,to_store_code);
					bean.setKit_code(kit_template_code);
				}
				ArrayList alDetailData=(ArrayList)bean.getKitDtlData();
				HashMap hmStockAvailabilityStatus = new HashMap();			
				int count = (int)bean.getCount();
				HashMap ht = null;
				if(alDetailData.size()>count){
					ht = (HashMap)alDetailData.get(count);
					//String short_desc=bean.checkForNull((String)ht.get("SHORT_DESC"),"");
						out.println("document.formIssueListHeader.item_code.value = '"+bean.checkForNull((String)ht.get("ITEM_CODE"),"")+"';");
						out.println("document.formIssueListHeader.item_desc.value = \""+bean.checkForNull((String)ht.get("SHORT_DESC"))+"\";");
						out.println("document.formIssueListHeader.expiry_yn.value = '"+bean.checkForNull((String)ht.get("EXPIRY_YN"),"")+"';");
						out.println("document.formIssueListHeader.uom_code.value = '"+bean.checkForNull((String)ht.get("UOM_CODE"),"")+"';");
						out.println("document.formIssueListHeader.iss_uom_code.value = '"+bean.checkForNull((String)ht.get("DEF_ISSUE_UOM"),"")+"';");
						out.println("document.formIssueListHeader.item_unit_cost.value = '"+bean.checkForNull((String)ht.get("ITEM_UNIT_COST"),"")+"';");
						out.println("document.getElementById('id_item_sal_value').innerHTML = '"+bean.checkForNull((String)ht.get("ITEM_VALUE"),"0")+"';");
						out.println("document.formIssueListHeader.kit_temp_code.value = '"+bean.checkForNull((String)ht.get("KIT_TEMPLATE_CODE"),"")+"';");
						out.println("document.formIssueListHeader.usage_type.value = '"+bean.checkForNull((String)ht.get("USAGE_TYPE"),"")+"';");

						try{
							String[] stParameters = {bean.checkForNull((String)ht.get("ITEM_CODE"),""), store_code, "0", "N", "", "N", to_store_code };
							hmStockAvailabilityStatus = new HashMap();
							hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						}catch(Exception e){
							result = false;
						}
					if (hmStockAvailabilityStatus.get("stock_item_yn")!=null && hmStockAvailabilityStatus.get("stock_item_yn").equals("Y") && !(hmStockAvailabilityStatus.get("available_stock").equals("0"))){
						out.println("document.formIssueListHeader.item_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"")+";");
						out.println("document.formIssueListHeader.iss_uom_qty.value = "+bean.checkForNull((String)ht.get("QUANTITY"),"")+";");
						if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
							out.println("document.formIssueListHeader.item_qty.value = 0;");
							out.println("document.formIssueListHeader.iss_uom_qty.value = 0;");
							out.println("document.formIssueListHeader.item_unit_cost.value = 0;");
							out.println("document.getElementById('id_item_sal_value').innerHTML = 0;");
						}
					}else{
						out.println("document.formIssueListHeader.item_qty.value = 0;");
						out.println("document.formIssueListHeader.iss_uom_qty.value = 0;");
						out.println("document.formIssueListHeader.expiry_yn.value = 'XX';");
					}
						out.println("document.formIssueListHeader.kit.value = 'kit';");
						out.println("document.formIssueListHeader.kit_template_uom.value ='"+bean.checkForNull((String)ht.get("KIT_UOM_DESC"),"")+"';");
						out.println("document.formIssueListHeader.kit_item_yn.value ='"+bean.checkForNull((String)ht.get("KIT_ITEM_YN"),"N")+"';");
						out.println("document.formIssueListHeader.store_code.value = '"+bean.checkForNull((String)store_code,"")+"';");
						out.println("document.getElementById('id_uom').innerHTML = '"+bean.checkForNull((String)ht.get("STOCK_UOM_DESC"),"&nbsp;")+"';");
						out.println("document.getElementById('uom_desc').innerHTML = '"+bean.checkForNull((String)ht.get("GEN_UOM_DESC"),"&nbsp;")+"';");
						out.println("kitGetStatus();");
					result = true;
				}else{
					out.println("statusOfItem();");
					result = false;
				}
			}catch(Exception e){
				result = false;
				message = e.getMessage();
				e.printStackTrace();
			}
		}
//Check for alert
		else if(validate.equals("ERROR_MESSAGE")) {
			ArrayList alDtlData = new ArrayList();
			ArrayList errorList = new ArrayList();
			HashMap ht = null;
			HashMap hmStockAvailabilityStatus = null;
			//alDtlData = bean.getDtlRecords();
			alDtlData = bean.getKitDtlData();
			for(int i=0;i<alDtlData.size();i++){
				ht = (HashMap)alDtlData.get(i);
				String[] stParameters = {(String)ht.get("ITEM_CODE"), store_code, "0", "N", "", "N", to_store };
					result = bean.isPhysicalInventoryProcessStartedForStore((String)ht.get("ITEM_CODE"),store_code,to_store);
					if(result){
						errorList.add("PHY_INV_PROCESS_INITIATED");
						errorList.add((String)ht.get("SHORT_DESC"));
					}
					try{
						hmStockAvailabilityStatus = (HashMap)bean.getStockAvailabilityStatus(stParameters);
						if (hmStockAvailabilityStatus.get("stock_item_yn").equals("Y")){
							if( hmStockAvailabilityStatus.get("available_stock").equals("0")){
								errorList.add("STOCK_NOT_AVAILABLE");
								errorList.add((String)ht.get("SHORT_DESC"));
							}
							if(Double.parseDouble((String)hmStockAvailabilityStatus.get("available_stock")) < (Double.parseDouble((String)ht.get("QUANTITY")))) {
								errorList.add("INSUFFICIENT_BATCH_QTY");
								errorList.add((String)ht.get("SHORT_DESC"));
							}
						}else{
							errorList.add("NOT_STOCK_ITEM");
							errorList.add((String)ht.get("SHORT_DESC"));
						}
					}catch(Exception e){
						if(!result){
							errorList.add("ITEM_STORE_NOT_FOUND");
							errorList.add((String)ht.get("SHORT_DESC"));
						}
					}
			}
			out.println("displayMessage('"+errorList+"');");
			result		=	true;
		}
		else if(validate.equals("setUOM")){
	
			
			try { 
				uom_code = request.getParameter("uom_code");
				iss_uom_code = request.getParameter("iss_uom_code");
				//String store_code_temp = request.getParameter("store_code");
				String item_code_temp = request.getParameter("item_code");


				//Added against Inc#32347 by Sakti Sankar
				String uom_description=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{uom_code, locale}).get("SHORT_DESC");
				
				String iss_uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{iss_uom_code, locale}).get("SHORT_DESC");
				//Added ends
				
				//Added by Sakti sankar against RUT-SCF-0248 displaying special characters

				uom_description = uom_description.replaceAll(" ","%20");
				uom_description = java.net.URLEncoder.encode(uom_description,"UTF-8");
				uom_description = uom_description.replaceAll("%2520","%20");

				iss_uom_desc = iss_uom_desc.replaceAll(" ","%20");
				iss_uom_desc = java.net.URLEncoder.encode(iss_uom_desc,"UTF-8");
				iss_uom_desc = iss_uom_desc.replaceAll("%2520","%20");
				//Added ends

				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, iss_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, iss_uom_code,item_code_temp}).get("COUNT"));
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, iss_uom_code,item_code_temp});
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_description+" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+iss_uom_desc;
				String stEqvl_value=""+Double.parseDouble((String)stEqvl_value1.get("CONV_FACTOR"));
				out.println("setUOMIssConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				
				}else if(am_count!=0){
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, iss_uom_code}).get("EQVL_VALUE");
				
				String conver=stEqvl_value+" "+uom_description+" = 1 "+iss_uom_desc;
				out.println("setUOMIssConvFactor1('"+stEqvl_value+"','"+conver+"');");
				
				result=true;
				}else{
				String stEqvl_value="1";
				String conver="1"+" "+uom_description+" = 1 "+iss_uom_desc;
				out.println("setUOMIssConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
					}
			}
			catch (Exception exception) {
				exception.printStackTrace();
				result		=	false;
		        message		=	exception.getMessage();
				throw new Exception("NO_CONV_FAC_FOR_PUR_UOM_CODE");
				
			}
				
				
				
				
				/*String stEqvl_value=/*(String)	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_AM_UOM_EQL_CONVERSION_SELECT1"),new String[]{uom_code, iss_uom_code,uom_code, iss_uom_code,item_code,uom_code, iss_uom_code}).get("EQVL_VALUE")""+bean.getConvFactTemp(item_code_temp,store_code_temp);
				

				out.println("setUOMIssConvFactor('"+stEqvl_value+"');");

				
				result=true;
			}
			catch (Exception exception) {
				exception.printStackTrace();
				
				throw new Exception("NO_CONV_FAC_FOR_ISS_UOM_CODE");
			}
		}
			catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
		exception.printStackTrace();
		}*/
		finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
		}
		}
		else if (validate.equals("MIN_MAX_STATUS")){
			try{
				String[]  minmaxarg = {""+bean.getConvFactTemp(item_code,store_code),item_code, store_code};
				HashMap hmminmax = new HashMap();
				hmminmax =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);
				//out.println("document.getElementById("lb_frm_store_qty_on_hand").innerHTML = '"+bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_frm_store_min_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_frm_store_max_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_frm_store_reorder_level").innerHTML = '"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_frm_store_uom_desc").innerHTML = '"+bean.checkForNull((String)bean.getShortDesc(item_code,store_code),"&nbsp;")+"';");

				//out.println("document.getElementById("frm_store_qty_on_hand").value = '"+bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"0")+"';");
				out.println("document.getElementById('frm_store_min_stk_level').value = '"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('frm_store_max_stk_level').value = '"+bean.checkForNull((String)hmminmax.get("MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('frm_store_reorder_level').value = '"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"")+"';");
				//out.println("document.getElementById("frm_store_uom_desc").value = '"+bean.checkForNull((String)bean.getShortDesc(item_code,store_code),"&nbsp;")+"';");
				
				//Added by Rabbani#AMS-CRF-0068(49822) on 12-AUG-2014 
		        if(bean.getMin_Rol_yn(bean.getLoginById(),store_code)){
				 
				if(!(bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")).equals("0")){
				out.println("document.getElementById('id_min_stk_label').style.visibility = 'visible';");
				out.println("document.getElementById('id_min_str_stk').style.visibility = 'visible';");
				out.println("document.getElementById('id_min_str_stk').innerHTML = '<B>"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")+"</B>';");
				if 
				((Double.parseDouble(bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"0")) < Integer.parseInt(bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")))) {
						out.println("document.getElementById('id_min_str_stk').innerHTML = '<B style= background-color:red;color:yellow;>"+bean.checkForNull((String)hmminmax.get("MIN_STK_QTY"),"0")+"</B>';");
						 
				}
				}
				if(!(bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0")).equals("0")){
				out.println("document.getElementById('id_stk_rol_label').style.visibility = 'visible';");
				out.println("document.getElementById('id_stk_rol').style.visibility = 'visible';");
				out.println("document.getElementById('id_stk_rol').innerHTML = '<B >"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0")+"</B>';");
				
				if 
				((Double.parseDouble(bean.checkForNull((String)hmminmax.get("AVAILABLE_QTY"),"0")) < Integer.parseInt(bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0"))))
				 {
					out.println("document.getElementById('id_stk_rol').innerHTML = '<B style= background-color:red;color:yellow; >"+bean.checkForNull((String)hmminmax.get("REORDER_LEVEL"),"0")+"</B>';");
				 }
				}
		       } //ends
				
				String frm_storeUOMDesc = bean.checkForNull((String)bean.getShortDesc(item_code,store_code));
				if(!frm_storeUOMDesc.equals(""))
					frm_storeUOMDesc =  java.net.URLEncoder.encode(frm_storeUOMDesc,"UTF-8");


				String[]  minmaxarg1 = {item_code, to_store};
				HashMap hmminmax1 = new HashMap();
				//hmminmax1 =	bean.fetchRecord(bean.getStRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT1"),minmaxarg1);
				hmminmax1 =	bean.fetchRecord("SELECT   a.min_stk_qty, a.max_stk_qty, a.reorder_level, a.qty_on_hand, SUM (NVL (committed_qty, 0)), a.qty_on_hand available_qty FROM st_item_store a, st_item_batch b WHERE a.item_code = ? AND a.store_code = ? AND a.item_code = b.item_code(+) AND a.store_code = b.store_code(+) GROUP BY a.min_stk_qty, a.max_stk_qty, a.reorder_level, a.qty_on_hand, b.item_code, b.store_code",minmaxarg1);
				//out.println("document.getElementById("lb_to_store_qty_on_hand").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("AVAILABLE_QTY"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_to_store_min_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("MIN_STK_QTY"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_to_store_max_stk_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("MAX_STK_QTY"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_to_store_reorder_level").innerHTML = '"+bean.checkForNull((String)hmminmax1.get("REORDER_LEVEL"),"&nbsp;")+"';");
				//out.println("document.getElementById("lb_to_store_uom_desc").innerHTML = '"+bean.checkForNull((String)bean.getShortDesc(item_code,to_store),"&nbsp;")+"';");
			
				out.println("document.getElementById('to_store_qty_on_hand').value = '"+bean.checkForNull((String)hmminmax1.get("AVAILABLE_QTY"),"0")+"';");
				out.println("document.getElementById('to_store_min_stk_level').value = '"+bean.checkForNull((String)hmminmax1.get("MIN_STK_QTY"),"")+"';");
				out.println("document.getElementById('to_store_max_stk_level').value = '"+bean.checkForNull((String)hmminmax1.get("MAX_STK_QTY"),"")+"';");
				out.println("document.getElementById('to_store_reorder_level').value = '"+bean.checkForNull((String)hmminmax1.get("REORDER_LEVEL"),"")+"';");
				//out.println("document.getElementById("to_store_uom_desc").value = '"+bean.checkForNull((String)bean.getShortDesc(item_code,to_store),"&nbsp;")+"';");
				String to_storeUOMDesc = bean.checkForNull((String)bean.getShortDesc(item_code,store_code));
				if(!to_storeUOMDesc.equals(""))
					to_storeUOMDesc =  java.net.URLEncoder.encode(to_storeUOMDesc,"UTF-8");
				out.println("assignUOMDesc('"+frm_storeUOMDesc+"','"+to_storeUOMDesc+"')");

				
				if(((String)bean.getAccessCostDetails()).equals("Y")){
					out.println("document.getElementById('id_item_unit_cost_label').style.visibility = 'visible';");
					out.println("document.getElementById('id_item_unit_cost').style.visibility = 'visible';");
					out.println("document.getElementById('id_item_sal_value_label').style.visibility = 'visible';");
					out.println("document.getElementById('id_item_sal_value').style.visibility = 'visible';");
				}
			result =  true;
			}catch(Exception e){
				result		=	false;
				message		=	e.getMessage();
				e.printStackTrace();
			}

			
		}
		else if (validate.equals("POPULATE_TO_STORE")){
			String request_by_store=request.getParameter("request_by_store");
			
			bean.setFrom_store_code(request_by_store);
				//To populate the requisition_on_stores
					out.println("clearListItems('formIssueQueryCriteria.to_store'); ");
					ArrayList req_by_stores = bean.getOnStoresIssue(bean.getFrom_store_code());
					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formIssueQueryCriteria.to_store\", \"" + record.get("STORE_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
						
					}

		}
		else if (validate.equals("LOAD_ITEM_CLASS")){
				String request_by_store = request.getParameter("request_by_store");
				String request_on_store = request.getParameter("request_on_store");
				if (request_on_store.trim().equals("") || request_by_store.trim().equals("")) {
					out.println("errorDisplay();");
					return;
				}
				
				out.println("clearListItems('formIssueQueryCriteria.item_class_code'); ");
				ArrayList itemClasses = bean.getItemClasses(request_by_store,request_on_store);
				HashMap record = null;
				for(int i=0; i< itemClasses.size(); i++) {
					record = (HashMap)itemClasses.get(i);
					out.println("addListItem(\"formIssueQueryCriteria.item_class_code\", \"" + record.get("ITEM_CLASS_CODE") + "\",\"" + record.get("SHORT_DESC") + "\");");
				}

		}else if(validate.equals("ZERO_QUANTITY")){
			result = true;

			//ArrayList alDtlData = (ArrayList)bean.getDtlRecords();
			
			ArrayList alDtlData = new ArrayList();

			if(bean.getBarcodeApplicable().equals("Y")){
				alDtlData = bean.getDtlRecordsforBarCode();
				}
			else{	
				alDtlData = bean.getDtlRecords();
			}

			HashMap ht = null;
			if(Integer.parseInt(index)>alDtlData.size())
				return;

			//	ht = (HashMap)bean.getDtlRecord(Integer.parseInt(index));

				if(bean.getBarcodeApplicable().equals("Y")){
				ht = (HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
				}
				else{	
				ht = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
				}
					if(!((String)ht.get("item_unit_cost")).equals("")&&((String)ht.get("issue_uom_qty")).equals("0")){
						result = false;
					}
		}else if(validate.equals("QUANTITY")){
			result = true;
			String doc_no =  (String)request.getParameter("doc_no");
			String doc_qty = (String)bean.docComitQty(store_code,item_code,doc_no);
			out.println("document.formIssueListHeader.doc_qty.value = '"+doc_qty+"';");
		}else if(validate.equals("CONV_CALCULATE")){
			item_code       =   (String)request.getParameter("item_code");
			String to_store_code	=	(String)request.getParameter("to_store_code");
			String fm_store_code	=	(String)request.getParameter("fm_store_code");
			String issue_uom_code	=	(String)request.getParameter("issue_uom_code");
			
			
			HashMap conv_factors	=	(HashMap)bean.getConvFactTemp(item_code,fm_store_code,to_store_code,issue_uom_code);
				out.println("setMultiples('"+(String)conv_factors.get("FROM_STORE_MULTIPLES")+"','"+(String)conv_factors.get("TO_STORE_MULTIPLES")+"','"+(String)conv_factors.get("BATCH_QTY_MULTIPLES")+"','"+(String)conv_factors.get("ISSUE_UOM_MULTIPLES")+"');");
			result = true;
		}else if(validate.equals("USAGE_TYPE_STATUS")){  
			       usage_type=	(String)request.getParameter("usage_type");
			       index	=	(String)request.getParameter("index_");
			String  BARCODE_YN	=	(String)request.getParameter("BARCODE_YN");
			String   iss_item_hold_chk = bean.checkForNull((String)request.getParameter("iss_item_hold_chk"),"N"); //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
			    HashMap alDtl			=		new HashMap();
			   ArrayList alDtl1			=		new ArrayList();
			  if (BARCODE_YN.equals("TRUE")){
				alDtl = (HashMap)bean.getDtlRecordforBarCode(Integer.parseInt(index));
				}
				else{	
				alDtl = (HashMap)bean.getDtlRecord(Integer.parseInt(index));
				}
	            alDtl.put("usage_type",usage_type);
				alDtl.put("iss_item_hold_yn", "Y");              //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
	            alDtl.put("iss_item_hold_chk", iss_item_hold_chk); //Added By Rabbani #Inc no:27060 (MO-CRF-20048) on 17-Feb-2014
				
			 if (BARCODE_YN.equals("TRUE")){
           bean.updateDtlRecordforBarCode(Integer.parseInt(index), alDtl);
	     }else{
	    bean.updateDtlRecord(Integer.parseInt(index), alDtl);
	   }
			result = true;
	 }
	else if(validate.equals("BARCODE_ITEM_EXISTS")){ 
		
	       String 	barcode			=	bean.checkForNull(request.getParameter("barcode"));
	       String 	item_code_exp 	= "";
	       String 	barcode_exp 	= "";
	       boolean	barcode_exist	= false;	       
	       
	       HashMap hmExpRecords = new HashMap();
	       ArrayList alExpRecords = new ArrayList();
	       HashMap	hmExpRecord = new HashMap();
	       HashMap 	hmDtlRecord = new HashMap();
	       
	       if(bean.getBarcodeApplicable().equals("Y")){
	    	   hmExpRecords	 =	bean.getExpRecordsforBarCode();				
			}
			else{	
				hmExpRecords =	bean.getExpRecords();
			}
	       int i;
	       for(i=0;i<hmExpRecords.size();i++){
	    	   
	    	   if(barcode_exist)
	    		   break;
	    		   
		    	   alExpRecords 	= (ArrayList)hmExpRecords.get(""+i);
		    	   
		    	   if(bean.getBarcodeApplicable().equals("Y")){
		    		   hmDtlRecord	 =	bean.getDtlRecordforBarCode(i);				
					}
					else{	
						hmDtlRecord =	bean.getDtlRecord(i);
					}
		    	   
		    	   for(int j=0;j<alExpRecords.size();j++){
		    		   hmExpRecord 	= (HashMap)alExpRecords.get(j);
			    	   barcode_exp = bean.checkForNull((String)hmExpRecord.get("BARCODE_ID"));	
			    	   
			    	   if(barcode.equals(barcode_exp)){
			    		   //hmExpRecord.put("BARCODE_ITEM_EXIST","Y"); 
			    		   hmDtlRecord.put("barcode_item_exist","Y"); //here not reqd to check dtl and exp item code equals because dtl getting using index
			    		   barcode_exist = true;
			    		   break;
			    	   }
		    	   }	       		
	       }
	       
	       if(barcode_exist){
	    	   --i;
	       	   //out.println("eval(document.getElementById('a_"+ i +"')).click();"); 	  
	    	   out.println("modifyData('"+i+"','Y')"); 	
	       }else{
			   out.println("alert(getMessage('BARCODE_ITEM_NOT_EXISTS','ST'));");
	       }       
			result = true;
	}
	//Added for GHL-CRF-0413 starts
	else if(validate.equals("clearTmpBean"))  { 
		System.err.println("clearTmpBean starts");
		 try{
			 bean.getTempBatchRecords().clear();
		   }
		   catch(Exception exception){
				exception.printStackTrace();
				flag			=	"clearTmpBean";
				result			=	false;
			}
	}
	//Added against GHL-CRF-0413.2-US002 starts
	 else if(validate.equals("SET_IN_BEAN_ISS"))  { 
			String doc_srl_no_forbean = request.getParameter("doc_srl_no_forbean");
			int srl_no = Integer.parseInt(doc_srl_no_forbean);
			System.err.println("SET_IN_BEAN_ISS starts"+srl_no);
			System.err.println("SET_IN_BEAN_ISS starts"+bean.getDtlRecordforBarCode(srl_no));
			try{
					ArrayList OldExpRecords = new ArrayList();
					ArrayList alBatchRecords_tmp = new ArrayList();
					System.out.println("getting new batch from tmp"+bean.getTempBatchRecords());
					ArrayList alBatchRecords_tmp1 = new ArrayList(bean.getTempBatchRecords());
					bean.setExpRecordsforBarCode(srl_no, alBatchRecords_tmp1);
					out.println("parent.frames[1].document.forms[0].batchsearch.value = '';");
			   }
			   catch(Exception exception){
					exception.printStackTrace();
					flag			=	"SET_IN_BEAN_ISS";
					result			=	false;
				}
		} 
		//Added against GHL-CRF-0413.2-US002 ends
	 else if(validate.equals("SET_IN_BEAN_URG"))  { 
			System.err.println("SET_IN_BEAN_URG starts");
			String doc_srl_no_forbean = request.getParameter("doc_srl_no_forbean");
			int srl_no = Integer.parseInt(doc_srl_no_forbean);
			 try{
					ArrayList OldExpRecords = new ArrayList();
					ArrayList alBatchRecords_tmp = new ArrayList();
					alBatchRecords_tmp = bean.getTempBatchRecords();
					System.out.println("getting new batch from tmp");
					HashMap CurrBatchRecords = new HashMap();
				if(bean.getExpRecordsforBarCode(srl_no)!=null && bean.getExpRecordsforBarCode(srl_no).size()>0){
					OldExpRecords =  bean.getExpRecordsforBarCode(srl_no);
					int pdoc_srl_no = srl_no ;
					int OldExp = OldExpRecords.size();
					for ( int m1=0; m1 < alBatchRecords_tmp.size(); m1++ ){
					boolean isExist = false;
					CurrBatchRecords =(HashMap)alBatchRecords_tmp.get(m1) ;					
					for ( int m2 = 0 ; m2 < OldExp ; m2++){
					HashMap exp = (HashMap)OldExpRecords.get(m2);
					if (( CurrBatchRecords.get("ITEM_CODE").equals(exp.get("ITEM_CODE")) &&  CurrBatchRecords.get("BATCH_ID").equals(exp.get("BATCH_ID")) &&  CurrBatchRecords.get("EXPIRY_DATE").equals(exp.get("EXPIRY_DATE"))	&& 	CurrBatchRecords.get("BIN_LOCATION_CODE").equals(exp.get("BIN_LOCATION_CODE")) &&  CurrBatchRecords.get("TRADE_ID").equals(exp.get("TRADE_ID")))){
					isExist = true;
					}  					
					}
					if (!isExist){
					System.out.println("check in SalesListDetail.jsp ...CurrBatchRecords.."+CurrBatchRecords);
					OldExpRecords.add(CurrBatchRecords);
					System.out.println("check in SalesListDetail.jsp ...OldExpRecords.."+OldExpRecords);
					}				
					}					
					bean.setExpRecordsforBarCode( pdoc_srl_no, OldExpRecords);
				}
				else{
					ArrayList alBatchRecords_tmp1 = new ArrayList(bean.getTempBatchRecords());
					bean.setExpRecordsforBarCode(srl_no, alBatchRecords_tmp1);
				}
				System.out.println("setting data"+bean.getTempBatchRecords());
			   }
			   catch(Exception exception){
					exception.printStackTrace();
					flag			=	"SET_IN_BEAN_URG";
					result			=	false;
				}
		} 
		//Added for GHL-CRF-0413 ends
	}
	catch (Exception exception) {
		result		=	false;
		message		=	exception.getMessage();
	//	exception.printStackTrace();
		System.out.println("htFormValues===error===issuevalidate==>"+htFormValues);
	}
	finally{
		out.println(" assignResult(" + result + ",\"" + message + "\", \"" + flag + "\" ) ; ") ;
	}

            _bw.write(_wl_block0Bytes, _wl_block0);

putObjectInBean("issueBean",bean,request);

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
