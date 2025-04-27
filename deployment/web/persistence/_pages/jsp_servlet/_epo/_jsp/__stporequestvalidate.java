package jsp_servlet._epo._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePO.*;
import ePO.Common.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __stporequestvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ePO/jsp/STPORequestValidate.jsp", 1741325944468L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="  \n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
	String locale			=		(String)session.getAttribute("LOCALE");
    String check_status		=		request.getParameter("check_status");
    String stitem_code		=		request.getParameter("item_code");
	String bean_id			=		request.getParameter("bean_id");
	String bean_name		=		request.getParameter("bean_name");
    String functionType		=		request.getParameter("function_type");

	if ((bean_id == null) || (bean_id.equals("")))
		return;

  
	STPORequestBean bean		=		(STPORequestBean) getBeanObject(bean_id, bean_name, request  );
	bean.setLanguageId(locale);

	Hashtable hash			=		(Hashtable) XMLobj.parseXMLString(request);
    hash					=		(Hashtable) hash.get ("SEARCH");
	boolean result			=		false;
	boolean result1			=		false;
	String message			=		"";
	String flag				=		"";
		
		if(functionType.equals("PHYSICALCHK"))
		{
			try {
				try {
					String item_code	= request.getParameter("item_code");
					String store_code	= request.getParameter("store_code");					
					String phy_inv_id   = "";
						result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
					if(result1){
						phy_inv_id=(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
						
						out.println("document.formPORequestDetail.phy_inv_id.value = '"+bean.checkForNull(phy_inv_id,"")+"';");
						throw new Exception("PHY_INV_PROCESS_INITIATED");
					}
					result = true;
					out.println(" assignResult(" + result + ",\"" + "" +"\", \"0\");") ;
				}catch (Exception exception) {
					exception.printStackTrace();
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
				hmminmax =	bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_ITEM_STORE_MIN_MAX_SELECT"),minmaxarg);

				/*if((bean.getAllowDecimalsYN(item_code)).equals("Y")){
					out.println(" document.getElementById("Qty_onhand_label").innerHTML  = '<B>"+bean.setNumber(bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0"),bean.getNoOfDecimals())+"</B>' ");
				}else{
					out.println(" document.getElementById("Qty_onhand_label").innerHTML  = '<B>"+bean.setNumber(bean.checkForNull((String)hmminmax.get("QTY_ON_HAND"),"0"),0)+"</B>' ");
				}*/
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
					String uom_code		= request.getParameter("uom_code");
					String store_code   = request.getParameter("store_code");
				
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
				System.out.println("UOM_CODE = "+uom_code);
				System.out.println("pur_uom_code = "+pur_uom_code);
				System.out.println("item_code = "+item_code);
				int am_count=Integer.parseInt((String)bean.fetchRecord("SELECT  count(*) count  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("COUNT"));
				int item_uom_count=Integer.parseInt((String)bean.fetchRecord("SELECT count(*) count   FROM mm_item_uom_defn WHERE uom_code = ? AND eqvl_uom_code = ? AND item_code = ?",new String[]{uom_code, pur_uom_code,item_code}).get("COUNT"));
				
				//Added against Inc#35347 by Abdul Rabbani on 28/09/12
				String uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{uom_code, locale}).get("SHORT_DESC");
				
				String pur_uom_desc=(String)bean.fetchRecord("SELECT SHORT_DESC FROM AM_UOM_LANG_VW WHERE UOM_CODE=? AND LANGUAGE_ID=?",new String[]{pur_uom_code, locale}).get("SHORT_DESC");
				//Added ends
		
				if(item_uom_count!=0){
				HashMap  stEqvl_value1=bean.fetchRecord("SELECT eqvl_value,eqvl_uom_qty , (eqvl_value / eqvl_uom_qty) conv_factor FROM mm_item_uom_defn a, st_item b WHERE uom_code = ? AND eqvl_uom_code = ? AND a.item_code = ? AND a.item_code = b.item_code ",new String[]{uom_code, pur_uom_code,item_code});
				//String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_code +" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_code;
				String conver=(String)stEqvl_value1.get("EQVL_VALUE")+" "+uom_desc +" = "+(String)stEqvl_value1.get("EQVL_UOM_QTY")+" "+pur_uom_desc;
				
				String stEqvl_value=(String)stEqvl_value1.get("CONV_FACTOR");
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else if(am_count!=0){				
				String stEqvl_value=(String)bean.fetchRecord("SELECT EQVL_VALUE  FROM am_uom_eqvl WHERE uom_code = ? AND eqvl_uom_code = ?",new String[]{uom_code, pur_uom_code}).get("EQVL_VALUE");
				//String conver=stEqvl_value+" "+uom_code+" = 1 "+pur_uom_code;
				  String conver=stEqvl_value+" "+uom_desc+" = 1 "+pur_uom_desc;
				out.println("setUOMConvFactor1('"+stEqvl_value+"','"+conver+"');");
				result=true;
				}
				else{
				String stEqvl_value="1";
				//String conver="1"+" "+uom_code+" = 1 "+pur_uom_code;
				String conver="1"+" "+uom_desc+" = 1 "+pur_uom_desc;
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

				double frm_tmp_conv=bean.getConvFactTemp(item_code,frm_store_code);
				//double to_tmp_conv=bean.getConvFactTemp(item_code,frm_store_code);
				double to_tmp_conv=1;
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
					result1 = bean.isPhysicalInventoryProcessStartedForStore(item_code,store_code,"");
					if(result1){
						phy_inv_id=(String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_ST_PHY_INV_ID_SELECT"),new String[]{item_code,store_code}).get("PHY_INV_ID");
					
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
		{	System.out.println("hash==>"+hash);
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
					STPORequestDetailBean detailBean;
					for (int i=0;	i<totalSize;	i++){
						itemStoreKey = (String) alItemKeys.get(i);
						detailBean = (STPORequestDetailBean)hmItemStore.get(itemStoreKey);
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
		STPORequestDetailBean requestDetail;
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
				//String authorize_res = bean.getAuthorizeForRequest(store_code);   // Commented by Padmapriya
				//Added by Padmapriya
				java.util.HashMap resultMap = bean.canAuthorize(store_code);
				String authorize_res = "";
				if (resultMap != null) {
					authorize_res = (String)resultMap.get("PRQ_FINALIZE_ALLOWED_YN");  
				}
				System.out.println("po req validate authorize_res : "+authorize_res);
				//End by Padmapriya
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
			String request_on_store = (String) hash.get("request_on_store");
			if (request_on_store != null && request_on_store.trim().equals("")) {
				out.println("errorDisplay();");
				return;
			}
			System.out.println("request_on_store==>"+request_on_store);
			java.util.HashMap resultMap = bean.canAuthorize(request_on_store);
			if (resultMap != null) {
				String authorize = (String)resultMap.get("REQ_APPROVE_ALLOWED_YN");  // Added by Padmapriya
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
					ArrayList req_by_stores = bean.getOnStores(request_by_store);
					HashMap record = null;
					for(int i=0; i< req_by_stores.size(); i++) {
						record = (HashMap)req_by_stores.get(i);
						out.println("addListItem(\"formPORequestQueryCriteria.request_on_store\", \"" + record.get("CODE") + "\",\"" + record.get("DESCRIPTION") + "\");");
						
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

		else if (functionType.equals("DOC_TYPE_CODE")){
			bean.setDoc_type_code(request.getParameter("purchase_type"));
			System.out.println("DOC_TYPE_CODE in stpo validate=371=>"+bean.getDoc_type_code());
			result	=	true;
		}
		else if(functionType.equals("DOCNO_ENABLE_YN")) {
			
			String purchase_unit				=		request.getParameter("purchase_unit");			
			System.out.println("purchase_unit=>"+purchase_unit);
			HashMap hashRecord = bean.fetchRecord("SELECT REQ_DOC_NO_GEN_METHOD FROM PO_DOCNO_CONTROL");

			String doc_no_md = bean.checkForNull((String) hashRecord.get("REQ_DOC_NO_GEN_METHOD"));

	//		bean.setDoc_no_md(doc_no_md);

			System.out.println("doc_no_md=>"+doc_no_md);

			if(doc_no_md.equals("A")){
			out.println("document.formPORequestHeader.doc_no.disabled=true");
			out.println("document.formPORequestHeader.autono_yn.value='Yes'");
			}else{
			out.println("document.formPORequestHeader.doc_no.disabled=false");
			out.println("document.formPORequestHeader.autono_yn.value='No'");
			}	

			ArrayList params = new ArrayList();
			params.add(bean.getLoginById());
			params.add(purchase_unit);

			String def_store_code = (String)bean.fetchRecord(bean.getPoRepositoryValue("SQL_PO_USER_ACCESS_ALLOW_AUTHORIZE_SELECT"),params).get("DFLT_STORE_CODE");
			
			out.println("document.formPORequestHeader.request_by_store.value='"+bean.checkForNull(def_store_code)+"'");
							
		}
		else if (functionType.equals("PRINTONLINEDOC")){
			try{
			
			ArrayList doc_no=bean.getPrintDocNo();
			System.out.println("doc_no====>396 jsp"+doc_no);
			String pdocno = "";
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


            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
