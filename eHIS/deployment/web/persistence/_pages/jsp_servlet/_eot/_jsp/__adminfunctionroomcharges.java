package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import eOR.OrderEntryBillingQueryBean;
import eOT.OTBillingBean;
import eST.OTTransactionBean;
import eST.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __adminfunctionroomcharges extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/AdminFunctionRoomCharges.jsp", 1709117246000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String locale = (String)session.getAttribute("LOCALE");
	request.setCharacterEncoding("UTF-8");

	String or_bean_id 				= "Or_billingQueryBean";
	String or_bean_name 			= "eOR.OrderEntryBillingQueryBean";
	OrderEntryBillingQueryBean or_bean			= (OrderEntryBillingQueryBean)getBeanObject( or_bean_id, or_bean_name, request ) ;
	

	String bean_id 				= "OTBillingBean";
	String bean_name 			= "eOT.OTBillingBean";
	OTBillingBean billing_bean			= (OTBillingBean)getBeanObject( bean_id, bean_name, request ) ;

	HashMap bill_info=new HashMap();
	StringBuilder bl_bfr = new StringBuilder();
	String called_from = request.getParameter("key")== null?"":request.getParameter("called_from");
	String room_id = request.getParameter("room_id")== null?"":request.getParameter("room_id");
	String key = request.getParameter("key")== null?"":request.getParameter("key");
	String oper_num = request.getParameter("oper_num")== null?"":request.getParameter("oper_num");
	String key_line = request.getParameter("key_line")== null?"":request.getParameter("key_line");
	String room_code = request.getParameter("bay_code")== null?"":request.getParameter("bay_code");
	String service_code = request.getParameter("service_code")== null?"":request.getParameter("service_code");
	String charge_units = request.getParameter("charge_units")== null?"":request.getParameter("charge_units");
	String flag = request.getParameter("charge_units")== null?"":request.getParameter("flag");

	
	String patient_id = request.getParameter("patient_id")== null?"":request.getParameter("patient_id");
	String encounter_id=request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String episode_id = request.getParameter("episode_id")== null?"":request.getParameter("episode_id");
	String visit_id = request.getParameter("visit_id")== null?"":request.getParameter("visit_id");
	String serv_date = request.getParameter("serv_date")== null?"":request.getParameter("serv_date");
	String pract_staff_id = request.getParameter("pract_staff_id")== null?"":request.getParameter("pract_staff_id");
	String patient_class = request.getParameter("patient_class")== null?"":request.getParameter("patient_class");
	String bl_episode_type = request.getParameter("bl_episode_type")== null?"":request.getParameter("bl_episode_type");
	String order_id1 = request.getParameter("order_id1")== null?"":request.getParameter("order_id1");

	HashMap bill_info_reqd_dtls =new HashMap();
	

	bill_info_reqd_dtls.put("patient_id",patient_id);
	bill_info_reqd_dtls.put("encounter_id",encounter_id);
	bill_info_reqd_dtls.put("episode_id",episode_id);
	bill_info_reqd_dtls.put("visit_id",visit_id);
	bill_info_reqd_dtls.put("serv_date",serv_date);
	bill_info_reqd_dtls.put("pract_staff_id",pract_staff_id);
	bill_info_reqd_dtls.put("patient_class",patient_class);
	bill_info_reqd_dtls.put("bl_episode_type",bl_episode_type);
	bill_info_reqd_dtls.put("order_id",order_id1);
	String bill_str="";
	String panel_str="";
	try{
		if(called_from.equals("PassBillDetails")){
			bill_info = or_bean.getOrderBillDtls(key+key_line);
			//if(bill_info==null && ("onblur").equals(flag)){
				bill_info = new HashMap();
				bill_info.put("key",key);
				bill_info.put("key_line_no",key_line);
				bill_info.put("oper_code",room_code);			//pass room  in oper_code
				if(room_id.equals("HB")){
					bill_info.put("acc_type","HB");
				}else if(room_id.equals("OR")){
					bill_info.put("acc_type","OR");
				}else if(room_id.equals("RR")){
					bill_info.put("acc_type","RR");
				}
				bill_info.put("oper_num",oper_num);
				bill_info.put("locale",locale);
				bill_info.put("oper_num",oper_num);
				bill_info.put("module_id","OT");
				bill_info.put("service_code",service_code);
				bill_info.put("quantity",charge_units);
				bill_info = billing_bean.getBillingParamsForAdmin(bill_info,room_id,bill_info_reqd_dtls);//C-> for Surgical Accessories Billing
				or_bean.setOrderBillDtls(key+key_line,bill_info);
				putObjectInBean(or_bean_id,or_bean,request);
			//}
			panel_str = (String) bill_info.get("bl_panel_str");	
			bl_bfr.append(checkForNull(""+bill_info.get("total_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_payable"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("patient_paid_amt"),"0.0")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("charged_yn"),"N")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("incl_excl_ind"),"null")).append("::");
			bl_bfr.append(checkForNull(""+bill_info.get("preapp_yn"),"null")).append("::");
			
			bill_str = bl_bfr.toString();

	 }
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally{
	}


            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
