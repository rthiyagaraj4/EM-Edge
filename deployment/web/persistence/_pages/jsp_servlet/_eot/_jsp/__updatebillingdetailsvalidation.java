package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.OrderEntryBillingQueryBean;
import java.util.HashMap;
import eOT.OTBillingBean;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __updatebillingdetailsvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/UpdateBillingDetailsValidation.jsp", 1709117294000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}

	
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
  
	String trace="0";
	String panel_str = "";
	HashMap bill_info		= new HashMap();
	HashMap orig_bill_info		= new HashMap();
	StringBuilder bl_bfr	= new StringBuilder();
	HashMap hash = new HashMap();
try{
	// This page is being called only from Implants and Consumables pages.
	//bean_id name shouldn't be changed.
	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	

	String bean_id 					= "OTBillingBean";
	String bean_name 				= "eOT.OTBillingBean";
	OTBillingBean billing_bean		= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	String order_id			= "";//checkForNull(request.getParameter("order_id"));
	String order_line_num	= checkForNull(request.getParameter("order_line_num"));
	String key				= checkForNull(request.getParameter("key"));
	String key_line			= checkForNull(request.getParameter("key_line"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String encounter_id		= checkForNull(request.getParameter("encounter_id"));
	String patient_class	= checkForNull(request.getParameter("patient_class"));
	String surgeon_code		= checkForNull(request.getParameter("surgeon_code"));
	String catalog_code		= checkForNull(request.getParameter("catalog_code"));
	String booking_date		= checkForNull(request.getParameter("booking_date"));
	String locale			= checkForNull(request.getParameter("locale"));
	String p_qty			= checkForNull(request.getParameter("p_qty"));
	String oper_num			= checkForNull(request.getParameter("oper_num"));
	String oper_code			= checkForNull(request.getParameter("oper_code"));
	String acc_code			= checkForNull(request.getParameter("acc_code"));
	String acc_type			= checkForNull(request.getParameter("acc_type"));
	
	hash = billing_bean.getORBillingParams(oper_num);
	trace="1";
	catalog_code	= acc_type+"#"+acc_code;
	booking_date	= (String) hash.get("service_date");
	patient_id	    = (String)hash.get("patient_id");
	encounter_id	= (String)hash.get("encounter_id");
	surgeon_code	= (String)hash.get("pract_staff_id");
	patient_class   = (String)hash.get("patient_class");
	trace="1.5";
	ArrayList bill_dtls=or_bean.getBillChargeDetails(p_qty,catalog_code,booking_date,locale,order_id,order_line_num,patient_id,encounter_id,patient_class,surgeon_code);	
	trace="2";
	orig_bill_info		= or_bean.getOrderBillDtls(key+key_line);
//.err.println("54:UpdateBillingDetailsValidation: before......getOrderBillDtls==="+orig_bill_info);
	bill_info			 = billing_bean.formatBillingDetails(bill_dtls);
	panel_str = (String) bill_info.get("bl_panel_str");
	trace="3";
	orig_bill_info.put("quantity",p_qty);
	orig_bill_info.put("key",key);
	orig_bill_info.put("bl_panel_str",panel_str);
	//bill_info.putAll(hash);
	//set billing details from OTBillingBean........	
	or_bean.setOrderBillDtls(key,orig_bill_info);
	putObjectInBean(or_bean_id,or_bean,request);
	String overridden_action_reason_code=null;
	String overridden_incl_excl_ind=null;
	bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
	bl_bfr.append(overridden_incl_excl_ind).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("serv_panel_ind"),"S")).append("::");
	bl_bfr.append(overridden_action_reason_code).append("::");
	bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"")).append("::");
	String bill_str = bl_bfr.toString();
	out.println(bill_str+"OTMS_SEP"+panel_str);
}catch(Exception e){
	bl_bfr.setLength(0);
	e.printStackTrace();
}

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
