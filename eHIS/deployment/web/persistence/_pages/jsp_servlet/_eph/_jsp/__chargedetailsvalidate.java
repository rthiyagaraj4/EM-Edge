package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.DecimalFormat;
import ePH.Common.*;
import ePH.*;
import eOR.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __chargedetailsvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/ChargeDetailsValidate.jsp", 1732509261659L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="   ";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String bean_id		= request.getParameter("bean_id")==null?"":request.getParameter("bean_id");
	String bean_name	= request.getParameter("bean_name")==null?"":request.getParameter("bean_name");
	String validate		= request.getParameter("validate")==null?"":request.getParameter("validate");
	String iv_prep_yn	= request.getParameter("iv_prep_yn")==null?"":request.getParameter("iv_prep_yn");
	String fluid_yn		= request.getParameter("fluid_yn")==null?"":request.getParameter("fluid_yn");
	String drug_code	= request.getParameter("drug_code")==null?"":request.getParameter("drug_code");
	String patient_id	= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String take_home_medication	= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication");
	String encounter_id	= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String episode_type	= request.getParameter("episode_type")==null?"":request.getParameter("episode_type");
	String rx_order_type= request.getParameter("rx_order_type")==null?"":request.getParameter("rx_order_type");
	String drug_index	= request.getParameter("drug_index")==null?"":request.getParameter("drug_index");
	String bl_incl_excl_override_value  = request.getParameter("bl_incl_excl_override_value")==null?"":request.getParameter("bl_incl_excl_override_value");
	String bl_override_reason_code		= request.getParameter("bl_override_reason_code")==null?"":request.getParameter("bl_override_reason_code");
	String bl_override_reason_desc		= request.getParameter("bl_override_reason_desc")==null?"":request.getParameter("bl_override_reason_desc");

	Hashtable hash			= (Hashtable)XMLobj.parseXMLString( request ) ;
    hash					= (Hashtable)hash.get( "SEARCH" ) ;
	ArrayList drugList		= new ArrayList();
	HashMap drugDetails		= new HashMap();
	String temp_drug_code	= "";
	String item_code		= "";
	String in_formulary_yn	= "";
	String ordered_qty		= "";
	String bl_included_IE	= "";
	String bl_charge_amt	= "";
	String bl_patient_payable	= "";
	String bl_apprvl_reqd_yn	= "";
	String bl_decimal_format_string	= "";
	String bl_override_allowed_yn	= "";
		   validate				    = validate.trim();

	if (validate!= null && validate.equals("getChargeDetails")){
		if(rx_order_type.equals("IV")){

			IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request);
			if(iv_prep_yn.equals("5"))
				drugList = bean.getAllFluids();
			else{
				if(fluid_yn.equals("Y"))
					drugDetails = bean.getFluidDetails();
				else
					drugList = bean.getDrugDetails();
			}
			if(drugDetails == null || drugDetails.size() <= 0){
				for(int j=0;j<drugList.size();j++){
				  drugDetails				=(HashMap) drugList.get(j);
				  temp_drug_code				=(String) drugDetails.get("DRUG_CODE");
					if( drug_code.equals(temp_drug_code) ){
						break;
					}
				}
			}
			if(drugDetails!= null && drugDetails.size()>0){

				//String called_from		= (String) hash.get("called_from")==null?"":(String) hash.get("called_from");
				//String drug_desc = "";

				item_code = (String) drugDetails.get("ITEM_CODE")==null?"":(String) drugDetails.get("ITEM_CODE");
				in_formulary_yn = (String) drugDetails.get("IN_FORMULARY_YN")==null?"":(String) drugDetails.get("IN_FORMULARY_YN");
				if(in_formulary_yn.equals("Y")){
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON",bl_override_reason_code);
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_override_reason_desc);
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE",bl_incl_excl_override_value);

					ordered_qty = (String)drugDetails.get("ORDERED_QTY")==null?"0.0":(String)drugDetails.get("ORDERED_QTY");

					bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );

					bl_included_IE = (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE");          
					
					
					bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");  
					bl_charge_amt = (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");

					bl_patient_payable = (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE");      
					bl_apprvl_reqd_yn = (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");       
					bl_decimal_format_string = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
					bl_override_allowed_yn = (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");

					String bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
					String bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
					String bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");

					
					out.println("assignChargeDetails('"+bl_charge_amt+"','"+bl_patient_payable+"','"+bl_included_IE+"','"+bl_apprvl_reqd_yn+"','"+bl_override_allowed_yn+"','"+bl_error_code+"','"+bl_sys_message_id+"','"+bl_error_text+"','"+drug_index+"','"+bl_decimal_format_string+"');");

					return;
				}
				else{
					out.println("clearDrugdetails('"+drug_index+"');");
				}
			}
			putObjectInBean(bean_id,bean,request);	
		}
		else if(rx_order_type.equals("ONC")){

			OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name, request);
			HashMap CompFluidDetails = bean.getCompFluidDetails();
			drugList = bean.getDrugDetails();
			String found="";
			HashMap fluidDetails = new HashMap();
			String ocurrance_num ="";

			if(fluid_yn.equals("Y"))
				 ocurrance_num =request.getParameter("ocurrance_num")==null?"":request.getParameter("ocurrance_num");

			if(drugDetails == null || drugDetails.size() <= 0){
				for(int j=0;j<drugList.size();j++){
                        if(!fluid_yn.equals("Y")){
							drugDetails				=(HashMap) drugList.get(j);
							if(drugDetails != null && drugDetails.size()>0){
								temp_drug_code				=(String) drugDetails.get("DRUG_CODE");
								if( drug_code.equals(temp_drug_code) ){								
									found = "D";
									break;
								}
							}
						}else{
							fluidDetails = (HashMap)CompFluidDetails.get(drug_code+"_"+ocurrance_num);
							if(fluidDetails != null){
								if(fluidDetails!= null || fluidDetails.size() > 0){
									//temp_drug_code				=(String) fluidDetails.get("DRUG_CODE");
									//if( drug_code.equals(temp_drug_code) ){
										found = "F";
										//break;
									//}
								}
							}
						}
					
				}
			}
			if(found.equals("F"))
				drugDetails = fluidDetails;

			if(drugDetails!= null && drugDetails.size()>0){

				//String called_from		= (String) hash.get("called_from")==null?"":(String) hash.get("called_from");
				//String drug_desc = "";

				item_code = (String) drugDetails.get("ITEM_CODE")==null?"":(String) drugDetails.get("ITEM_CODE");
				in_formulary_yn = (String) drugDetails.get("IN_FORMULARY_YN")==null?"":(String) drugDetails.get("IN_FORMULARY_YN");

				if(in_formulary_yn.equals("Y")){

					drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON",bl_override_reason_code);
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_override_reason_desc);
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE",bl_incl_excl_override_value);

					ordered_qty				 = (String)drugDetails.get("ORDERED_QTY")==null?"0.0":(String)drugDetails.get("ORDERED_QTY");

					bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );

					bl_included_IE			 = (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE");          
					bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");       
					bl_charge_amt			 = (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");
					bl_patient_payable		 = (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE");      
					bl_apprvl_reqd_yn		 = (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");       
					bl_decimal_format_string = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
					bl_override_allowed_yn	 = (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");

					String bl_error_code	 = (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
					String bl_sys_message_id = (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
					String bl_error_text	 = (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");

					out.println("assignChargeDetails('"+bl_charge_amt+"','"+bl_patient_payable+"','"+bl_included_IE+"','"+bl_apprvl_reqd_yn+"','"+bl_override_allowed_yn+"','"+bl_error_code+"','"+bl_sys_message_id+"','"+bl_error_text+"','"+drug_index+"','"+bl_decimal_format_string+"');");
					return;
				}
				else{
					out.println("clearDrugdetails('"+drug_index+"');");
				}
			}
			putObjectInBean(bean_id,bean,request);	
		}
		if(rx_order_type.equals("MS")){

			ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
			drugList = bean.getPresItemList();
			for(int j=0;j<drugList.size();j++){
			  drugDetails				=(HashMap) drugList.get(j);
			  temp_drug_code				=(String) drugDetails.get("ITEM_CODE");
				if( drug_code.equals(temp_drug_code) ){
					break;
				}
			}
			if(drugDetails!= null && drugDetails.size()>0){

				item_code = (String) drugDetails.get("ITEM_CODE")==null?"":(String) drugDetails.get("ITEM_CODE");

				drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON",bl_override_reason_code);
				drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC",bl_override_reason_desc);
				drugDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE",bl_incl_excl_override_value);

				ordered_qty = (String)drugDetails.get("QTY_VALUE")==null?"0.0":(String)drugDetails.get("QTY_VALUE");

				bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );

				bl_included_IE = (String)drugDetails.get("BL_INCL_EXCL_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_VALUE");          
				bl_incl_excl_override_value = (String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE")==null?"":(String)drugDetails.get("BL_INCL_EXCL_OVERRIDE_VALUE");       
				bl_charge_amt = (String)drugDetails.get("BL_CHARGE_AMT")==null?"0.0":(String)drugDetails.get("BL_CHARGE_AMT");

				bl_patient_payable = (String)drugDetails.get("BL_PATIENT_PAYABLE")==null?"0.0":(String)drugDetails.get("BL_PATIENT_PAYABLE");      
				bl_apprvl_reqd_yn = (String)drugDetails.get("BL_APPRVL_REQD_YN")==null?"":(String)drugDetails.get("BL_APPRVL_REQD_YN");       
				bl_decimal_format_string = (String)drugDetails.get("BL_DECIMAL_FORMAT_STRING")==null?"#0.00":(String)drugDetails.get("BL_DECIMAL_FORMAT_STRING");
				bl_override_allowed_yn = (String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN")==null?"":(String)drugDetails.get("BL_OVERRIDE_ALLOWED_YN");

				String bl_error_code			= (String)drugDetails.get("BL_ERROR_CODE")==null?"":(String)drugDetails.get("BL_ERROR_CODE"); 
				String bl_sys_message_id		= (String)drugDetails.get("BL_SYS_MESSAGE_ID")==null?"":(String)drugDetails.get("BL_SYS_MESSAGE_ID");
				String bl_error_text			= (String)drugDetails.get("BL_ERROR_TEXT")==null?"":(String)drugDetails.get("BL_ERROR_TEXT");
				out.println("assignChargeDetails('"+bl_charge_amt+"','"+bl_patient_payable+"','"+bl_included_IE+"','"+bl_apprvl_reqd_yn+"','"+bl_override_allowed_yn+"','"+bl_error_code+"','"+bl_sys_message_id+"','"+bl_error_text+"','"+drug_index+"','"+bl_decimal_format_string+"');");

				return;
			}
			putObjectInBean(bean_id,bean,request);	
		}
	}
	else if (validate!= null && validate.equals("cancelOverrideDetail")){
		if(rx_order_type.equals("IV")){
			IVPrescriptionBean bean = (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request);
			if(iv_prep_yn.equals("1") || iv_prep_yn.equals("2") || iv_prep_yn.equals("3") || iv_prep_yn.equals("4")){
				drugDetails = bean.getFluidDetails();
				if(drugDetails!= null && drugDetails.size()>0){

					item_code = (String) drugDetails.get("ITEM_CODE")==null?"":(String) drugDetails.get("ITEM_CODE");
					in_formulary_yn = (String) drugDetails.get("IN_FORMULARY_YN")==null?"":(String) drugDetails.get("IN_FORMULARY_YN");

					if(in_formulary_yn.equals("Y")){

						drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON","");
						drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC","");
						drugDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE","");

						ordered_qty = (String)drugDetails.get("ORDERED_QTY")==null?"0.0":(String)drugDetails.get("ORDERED_QTY");
						bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
					}
				}
			}

			drugList = bean.getDrugDetails();
			for (int i=0; i<drugList.size(); i++) {

				drugDetails	= (HashMap)drugList.get(i);
				in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
				if(in_formulary_yn.equals("Y")){
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON","");
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC","");
					drugDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE","");

					ordered_qty = (String)drugDetails.get("ORDERED_QTY")==null?"0.0":(String)drugDetails.get("ORDERED_QTY");
					bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
				}
			}
			putObjectInBean(bean_id,bean,request);	
		}
		else if(rx_order_type.equals("ONC")){

			OncologyRegimenBean bean	= (OncologyRegimenBean)getBeanObject(bean_id, bean_name, request);
			HashMap CompFluidDetails = bean.getCompFluidDetails();
			drugList = bean.getDrugDetails();
			String found="";
			HashMap fluidDetails = new HashMap();

			if(drugDetails == null || drugDetails.size() <= 0){
				for(int j=0;j<drugList.size();j++){
					drugDetails				=(HashMap) drugList.get(j);
					temp_drug_code = (String) drugDetails.get("DRUG_CODE");
					in_formulary_yn = (String)drugDetails.get("IN_FORMULARY_YN")==null?"":(String)drugDetails.get("IN_FORMULARY_YN");
					if(in_formulary_yn.equals("Y")){
						item_code = (String) drugDetails.get("ITEM_CODE");
						drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON","");
						drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC","");
						drugDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE","");

						ordered_qty = (String)drugDetails.get("ORDERED_QTY")==null?"0.0":(String)drugDetails.get("ORDERED_QTY");
						bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
					}
					fluidDetails = (HashMap)CompFluidDetails.get(temp_drug_code);
					if(fluidDetails != null && fluidDetails.size() > 0){
						in_formulary_yn = (String)fluidDetails.get("IN_FORMULARY_YN")==null?"":(String)fluidDetails.get("IN_FORMULARY_YN");
						if(in_formulary_yn.equals("Y")){
							item_code = (String) drugDetails.get("ITEM_CODE");
							fluidDetails.put("BL_INCL_EXCL_OVERRIDE_REASON","");
							fluidDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC","");
							fluidDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE","");

							ordered_qty = (String)fluidDetails.get("ORDERED_QTY")==null?"0.0":(String)fluidDetails.get("ORDERED_QTY");
							bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
						}
					}
				}
			}
			putObjectInBean(bean_id,bean,request);	
		}
		else if(rx_order_type.equals("MS")){
			ConsumableOrderBean bean			= (ConsumableOrderBean)getBeanObject( bean_id, bean_name, request );
			drugList = bean.getPresItemList();
			for(int j=0;j<drugList.size();j++){
			  drugDetails				=(HashMap) drugList.get(j);
				item_code = (String)drugDetails.get("ITEM_CODE")==null?"":(String)drugDetails.get("ITEM_CODE");
				drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON","");
				drugDetails.put("BL_INCL_EXCL_OVERRIDE_REASON_DESC","");
				drugDetails.put("BL_INCL_EXCL_OVERRIDE_VALUE","");

				ordered_qty = (String)drugDetails.get("QTY_VALUE")==null?"0.0":(String)drugDetails.get("QTY_VALUE");
				bean.setBillingDetail(drugDetails, episode_type, patient_id, encounter_id, item_code, ordered_qty,take_home_medication );
			}

			putObjectInBean(bean_id,bean,request);	
		}
	}
	else if (validate!= null && validate.equals("getTotalAmount")){
		bl_decimal_format_string = request.getParameter("bl_decimal_format_string")==null?"":request.getParameter("bl_decimal_format_string");
		String bl_tot_charge_amt = request.getParameter("bl_tot_charge_amt")==null?"0.0":request.getParameter("bl_tot_charge_amt");
		String bl_tot_patient_payable = request.getParameter("bl_tot_patient_payable")==null?"0.0":request.getParameter("bl_tot_patient_payable");
		DecimalFormat dfTest = dfTest = new DecimalFormat(bl_decimal_format_string);
		bl_tot_charge_amt = dfTest.format(Double.parseDouble(bl_tot_charge_amt));
		bl_tot_patient_payable = dfTest.format(Double.parseDouble(bl_tot_patient_payable));
		out.println("assignTotalAmount('"+bl_tot_charge_amt+"','"+bl_tot_patient_payable+"');");
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
