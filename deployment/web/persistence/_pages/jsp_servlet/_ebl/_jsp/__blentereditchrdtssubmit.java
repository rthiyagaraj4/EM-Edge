package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eBL.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import eBL.*;
import eOR.*;
import eOR.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blentereditchrdtssubmit extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLEnterEditChrDtsSubmit.jsp", 1726462987137L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n\n<script>\n\t\n\t//parent.window.close();\n\tparent.parent.document.getElementById(\'dialog_tag\').close();\n\n</script>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n</html>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	//HttpSession httpSession = request.getSession(false);
//	Properties p = (Properties)httpSession.getValue("jdbc");	
	request.setCharacterEncoding("UTF-8");
	String episode_id="";
	String episode_type="";
	String patient_id="";
	String visit_id="";

	String str_panel="";
	String accept_chk="";
	String service_panel_ind="";
	String p_module_id="";

	String incl_excl_action_code_to_or="";
	String action_reason_code_to_or="";
	String total_payable_to_or="";
	String patient_payable_to_or="";
	String total_paid_to_or="";
	//String str_override_yn="";

	String str_or_bean_id=""; // Added for BL_OR Enhancement
	String str_or_key ="";
	String str_or_key_line_no="",excl_incl_ind_for_screen="";
	String rate_temp="";

	/****ghl-crf-1.2*************/
	String calledfrmencYN="N";
	String bean_id_bl ="";
	//String bean_name_bl="";
	/******end*******************/

	String mod_pract_ind="", mod_physician_id="";
	
	HashMap bill_dtls_to_or_bean = null;

	try
	{
		episode_type=request.getParameter("h_episode_type");
		episode_id=request.getParameter("h_episode_id");
		patient_id=request.getParameter("h_patient_id");
		visit_id=request.getParameter("h_visit_id");

		service_panel_ind=request.getParameter("service_panel_ind");
		if(service_panel_ind==null )service_panel_ind="";

		p_module_id=(String)request.getParameter("h_module_id");
		if(p_module_id==null) p_module_id="";

		String str_panel_hdr =request.getParameter("p_str");
		String str_panel_body =request.getParameter("p_str1");

		str_or_bean_id=request.getParameter("str_or_bean_id");
		if(str_or_bean_id==null) str_or_bean_id="";

		str_or_key=request.getParameter("str_or_key");
		if(str_or_key==null) str_or_key="";
		
		str_or_key_line_no=request.getParameter("str_or_key_line_no");
		if(str_or_key_line_no==null || str_or_key_line_no.equals("")) str_or_key_line_no="";

		if(!(str_or_key.equals("") && str_or_key_line_no.equals("")))
		{
			str_or_key=str_or_key+str_or_key_line_no;
		}

		incl_excl_action_code_to_or=request.getParameter("incl_excl_action_code_to_or");
		if(incl_excl_action_code_to_or==null) incl_excl_action_code_to_or="";

		action_reason_code_to_or=request.getParameter("action_reason_code_to_or");
		if(action_reason_code_to_or==null) action_reason_code_to_or="";

		total_payable_to_or=request.getParameter("total");
		if(total_payable_to_or == null) total_payable_to_or="";

		patient_payable_to_or=request.getParameter("patient");
		if(patient_payable_to_or == null) patient_payable_to_or="";

		total_paid_to_or=request.getParameter("patient_paid");
		if(total_paid_to_or == null) total_paid_to_or="";

		rate_temp=request.getParameter("rate_temp");
		if(rate_temp == null) rate_temp="";	

		excl_incl_ind_for_screen=request.getParameter("excl_incl_ind_for_screen");
		if(excl_incl_ind_for_screen == null) excl_incl_ind_for_screen="";	

		mod_pract_ind = request.getParameter("mod_pract_ind");
		if(mod_pract_ind == null) mod_pract_ind="";	

		mod_physician_id = request.getParameter("mod_physician_id");
		if(mod_physician_id == null) mod_physician_id="";	
			
		
		if(service_panel_ind.equals("L"))
		{
			str_panel=str_panel_hdr+str_panel_body;
		}
		else if(service_panel_ind.equals("S"))
		{
			str_panel=str_panel_hdr+str_panel_body;
		}
		accept_chk=request.getParameter("accept_chk");

  
		
		//pString.put("episode_type",episode_type);
		//pString.put("episode_id",episode_id);
		//pString.put("patient_id",patient_id);
		//pString.put("visit_id",visit_id);	
		//pString.put("accept_chk",accept_chk);

		 calledfrmencYN = request.getParameter("calledfrmencYN");
		 if(calledfrmencYN == null || calledfrmencYN.equals("")) calledfrmencYN="N";
		 bean_id_bl=request.getParameter("bean_id_bl");
		 if(bean_id_bl == null || bean_id_bl.equals("")) bean_id_bl="N";


	
		if(p_module_id.equals("OP") || p_module_id.equals("AE") || (p_module_id.equals("MP") && calledfrmencYN.equals("N")))
		{
//			System.err.println("Inside IF of Submit Charge Dtls");
			HashMap pString = new HashMap();
			pString.put("panel_str",str_panel);
			session.setAttribute("BlChargeRecord",(HashMap)pString);
		}/*
		else if(p_module_id.equals("BL"))
		{

			bill_dtls_to_or_bean= null;

			BLEnterServiceRequestBean ServPanlBean			= (BLEnterServiceRequestBean)getBeanObject( str_or_bean_id, "eBL.BLEnterServiceRequestBean", request ) ;

			if(!str_or_bean_id.equals(""))
			{
				bill_dtls_to_or_bean=(HashMap)ServPanlBean.getSelectedServPanlDtls(str_or_key);

				bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
				bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
				bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);
	

				bill_dtls_to_or_bean.put("total_payable" , total_payable_to_or);
				bill_dtls_to_or_bean.put("patient_payable" , patient_payable_to_or);
				bill_dtls_to_or_bean.put("patient_paid_amt" , total_paid_to_or);
						
				ServPanlBean.setSelectedServPanlDtls(str_or_key, bill_dtls_to_or_bean); 
			}
		}*/
		else if(calledfrmencYN.equals("Y") && p_module_id.equals("MP") ) {
			BLPatRegChargesBean bean			= (BLPatRegChargesBean)getBeanObject( bean_id_bl, "eBL.BLPatRegChargesBean", request ) ;
			if(bean!=null)
			{
				bean.setPanelString(str_panel);		
				if(service_panel_ind.equals("S"))
				{
								
					bean.setTotPay(total_payable_to_or);
					bean.setTotPatPay(patient_payable_to_or);
				}
			}		
		}
		else
		{

			bill_dtls_to_or_bean= null;

/*			bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
			bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
			bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);  // which we will pass it to your Billing routine before recording the Order
*/

			OrderEntryBillingQueryBean orderEntryBillBean = null;
			FutureOrder	FutureBeanObj  = null;
			OrderEntryBean	beanObj  = null;
			if(!str_or_bean_id.equals(""))
			{

				if(str_or_bean_id.equals("Or_FutureOrder"))
				{
					FutureBeanObj  = (FutureOrder)getBeanObject( str_or_bean_id, "eOR.FutureOrder", request ) ;
					orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) FutureBeanObj.getOrderEntryBillBean();
				}
				else
				{
					beanObj  = (OrderEntryBean)getBeanObject( str_or_bean_id, "eOR.OrderEntryBean", request ) ;
					orderEntryBillBean = (eOR.OrderEntryBillingQueryBean) beanObj.getOrderEntryBillBean();
				}
				bill_dtls_to_or_bean=(HashMap)orderEntryBillBean.getOrderBillDtls(str_or_key);
				bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
				bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
				bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);
				

				if(service_panel_ind.equals("S"))
				{
								
					bill_dtls_to_or_bean.put("total_payable" , total_payable_to_or);
					bill_dtls_to_or_bean.put("patient_payable" , patient_payable_to_or);
					bill_dtls_to_or_bean.put("patient_paid_amt" , total_paid_to_or);
					bill_dtls_to_or_bean.put("rate" , rate_temp);
					bill_dtls_to_or_bean.put("excl_incl_ind_for_screen" , excl_incl_ind_for_screen);
					bill_dtls_to_or_bean.put("mod_pract_ind",mod_pract_ind);
					bill_dtls_to_or_bean.put("mod_physician_id" , mod_physician_id);

				}
				
				
				orderEntryBillBean.setOrderBillDtls(str_or_key, bill_dtls_to_or_bean); 


				if(str_or_bean_id.equals("Or_FutureOrder"))
				{
					putObjectInBean(str_or_bean_id,FutureBeanObj,request); // set it back in persistence
				}
				else
				{
					putObjectInBean(str_or_bean_id,beanObj,request); // set it back in persistence
				}
			}
			else
			{
				orderEntryBillBean = (OrderEntryBillingQueryBean)getBeanObject( "Or_billingQueryBean", "eOR.OrderEntryBillingQueryBean", request ) ;
				bill_dtls_to_or_bean=(HashMap)orderEntryBillBean.getOrderBillDtls(str_or_key);
				bill_dtls_to_or_bean.put("incl_excl_action", incl_excl_action_code_to_or);
				bill_dtls_to_or_bean.put("incl_excl_action_reason", action_reason_code_to_or);			
				bill_dtls_to_or_bean.put("bl_panel_str" , str_panel);

				if(service_panel_ind.equals("S"))
				{
					bill_dtls_to_or_bean.put("total_payable" , total_payable_to_or);
					bill_dtls_to_or_bean.put("patient_payable" , patient_payable_to_or);
					bill_dtls_to_or_bean.put("patient_paid_amt" , total_paid_to_or);
					bill_dtls_to_or_bean.put("rate" , rate_temp);
					bill_dtls_to_or_bean.put("excl_incl_ind_for_screen" , excl_incl_ind_for_screen);
					bill_dtls_to_or_bean.put("mod_pract_ind",mod_pract_ind);
					bill_dtls_to_or_bean.put("mod_physician_id" , mod_physician_id);

				}


				orderEntryBillBean.setOrderBillDtls(str_or_key, bill_dtls_to_or_bean); 

				putObjectInBean("Or_billingQueryBean",orderEntryBillBean,request);
			}
		}
		session.setAttribute("acc_flag","true");
/*
		session.setAttribute("episode_type",episode_type);
		session.setAttribute("episode_id",episode_id);
		session.setAttribute("patient_id",patient_id);
		session.setAttribute("visit_id",visit_id);
*/

            _bw.write(_wl_block4Bytes, _wl_block4);

	}
	catch(Exception e)
	{
		e.printStackTrace();
		System.out.println("Exception in Main:"+e);
	}

            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
