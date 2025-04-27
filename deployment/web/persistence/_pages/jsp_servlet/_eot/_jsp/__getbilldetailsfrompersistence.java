package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.OrderEntryBillingQueryBean;
import java.util.HashMap;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __getbilldetailsfrompersistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/GetBillDetailsFromPersistence.jsp", 1709117260000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
try{
	//bean_id name shouldn't be changed.
	String bean_id 							= "Or_billingQueryBean";
	String bean_name 						= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean bean			= (OrderEntryBillingQueryBean)getBeanObject( bean_id, bean_name, request );
	//if it is comming from instrument/equipments/implants/consumables key --> orderid = bill sub_regn_key & order_line_num = bill sub_regn_line_key
	String order_id			= checkForNull(request.getParameter("order_id"));
	String order_line_no	= checkForNull(request.getParameter("order_line_num"));
	String oper_code		= checkForNull(request.getParameter("oper_code"));
	String key		= checkForNull(request.getParameter("key"));
	String key_line		= checkForNull(request.getParameter("key_line"));
	String patient_id		= checkForNull(request.getParameter("patient_id"));
	String called_from		= checkForNull(request.getParameter("called_from"));
	HashMap bill_info		= new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
if(called_from.equals("SURG_ACC_EDIT")){
	bill_info = bean.getOrderBillDtls(key+key_line);	
}else{
	if(!"".equals(order_line_no)){
		bill_info = bean.getOrderBillDtls(order_id+order_line_no);
	}else{
		//if called from SURG_ACC calling surgical accessories
		bill_info = ("SURG_ACC".equals(called_from))?bean.getOrderBillDtls(order_id):bean.getOrderBillDtls(patient_id+oper_code); 
	}
}
trace="6";
		bl_bfr.append(bill_info.get("key")).append("::");
trace="6.1";
		bl_bfr.append(bill_info.get("key_line_no")).append("::");
trace="6.2";
		bl_bfr.append(bill_info.get("oper_code")).append("::");
trace="6.3";
		bl_bfr.append(bill_info.get("patient_id")).append("::");
trace="6.4";
		bl_bfr.append(bill_info.get("episode_type")).append("::");
trace="6.5";
		bl_bfr.append(bill_info.get("episode_id")).append("::");
trace="6.6";
		bl_bfr.append(bill_info.get("visit_id")).append("::");
trace="6.7";
		bl_bfr.append(bill_info.get("encounter_id")).append("::");
trace="6.8";
		bl_bfr.append(bill_info.get("service_date")).append("::");
trace="6.9";
		bl_bfr.append("P").append("::");
trace="6.10";
		bl_bfr.append(bill_info.get("pract_staff_id")).append("::");
trace="6.11";
		bl_bfr.append(bill_info.get("serv_panel_ind")).append("::");
trace="6.12";
		bl_bfr.append(bill_info.get("serv_panel_code")).append("::");
trace="6.13";
		bl_bfr.append(bill_info.get("bl_panel_str")).append("::");
trace="6.14";
		bl_bfr.append(bill_info.get("total_payable")).append("::");
trace="6.15";
		bl_bfr.append(bill_info.get("patient_payable")).append("::");
trace="6.16";
		bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"N")).append("::");
trace="6.17";
		bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
trace="6.18";
		bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
trace="6.19";
		bl_bfr.append(bill_info.get("quantity")).append("::");//050795
trace="6.20";
		bl_bfr.append(bill_info.get("order_line_no"));//050795
trace="7";
		out.println(bl_bfr.toString());
trace="8";
		bl_bfr.setLength(0);
trace="9";
}catch(Exception e){
	System.err.println("Exception in GetBillDetailsFromPersistence:::trace=="+trace);
	System.err.println("Exception in GetBillDetailsFromPersistence:::"+e);
	e.printStackTrace();
}

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
