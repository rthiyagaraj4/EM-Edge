package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __authorizeordersvalidate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/AuthorizeOrdersValidate.jsp", 1731663212000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);

/* 
--------------------------------------------------------------------------------------------------------------
Date       		Edit History      Name        	Rev.Date	Rev.Name		Description
--------------------------------------------------------------------------------------------------------------
?             	100            		?           created
17/09/2014		IN051144		Nijitha S			?			?			Amend Reason Pop up Window is not displayed, when Amend Order while Authorization
23/11/2015	 	IN053846		Karthi L										The prescription printing automatically
---------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
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
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id = request.getParameter( "bean_id" ) ;
	String validate = request.getParameter( "validate" ) ;
//	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String facility_id = (String)session.getValue("facility_id");


	if ( bean_id == null || bean_id.equals( "" ) )
		return ;

	if ( validate == null || validate.equals( "" ) )
		return ;

	AuthoriseOrders beanObj = (AuthoriseOrders)getBeanObject( bean_id, "eOR.AuthoriseOrders",request ) ;
	beanObj.setLanguageId( (String) session.getAttribute("LOCALE") ) ;
	Hashtable hash = (Hashtable)XMLobj.parseXMLString( request ) ;
    hash = (Hashtable)hash.get( "SEARCH" ) ;
	 if ( validate.equals( "set_values" ) ) {

		String totalCount = (String)hash.get("totalCount") ;
		String order_catalog = "";
		String ord_id = "";

			String ord_typ_code = "";
			String ord_consent_yn = "";
			String cont_order_ind = "";
			String ord_appr_by_user_id = "";
			String ord_appr_reqd_yn = "";
			String order_category = "";

		int totalCountInt = Integer.parseInt(totalCount);

		HashMap all_final_values = new HashMap();

		for(int j=0; j<totalCountInt; j++){
			order_catalog = (String)hash.get("ord_catalog"+j) ;
			ord_id = (String)hash.get("ord_id"+j) ;
			ord_typ_code = (String)hash.get("ord_typ_code"+j) ;
			ord_consent_yn = (String)hash.get("ord_consent_yn"+j) ;
			cont_order_ind = (String)hash.get("cont_order_ind"+j) ;
			ord_appr_by_user_id = (String)hash.get("ord_appr_by_user_id"+j) ;
			ord_appr_reqd_yn = (String)hash.get("ord_appr_reqd_yn"+j) ;
			order_category = (String)hash.get("order_category"+j) ;
			//out.println( "<script>alert(\"" + order_catalog + "\",\"" + ord_id + "\") ;</script> " ) ;

			all_final_values.put("ord_catalog"+j, order_catalog);
			all_final_values.put("ord_id"+j, ord_id);
			all_final_values.put("ord_typ_code"+j, ord_typ_code);
			all_final_values.put("ord_consent_yn"+j, ord_consent_yn);
			all_final_values.put("cont_order_ind"+j, cont_order_ind);
			all_final_values.put("ord_appr_by_user_id"+j, ord_appr_by_user_id);
			all_final_values.put("ord_appr_reqd_yn"+j, ord_appr_reqd_yn);
			all_final_values.put("order_category"+j, order_category);
		}
			beanObj.setFinalValues(all_final_values);

	}else if( validate.equals( "VISIT_ADM_DATE" ) ) {
		String order_id = request.getParameter( "order_id" ) ;
		String patient_id = request.getParameter( "patient_id" ) ;
		String episode_id = request.getParameter( "episode_id" ) ;
		String pract_reln_id = request.getParameter( "pract_reln_id" ) ;
		String location_type = request.getParameter( "location_type" ) ;
		String location_code = request.getParameter( "location_code" ) ;
		String patient_class = request.getParameter( "patient_class" ) ;
		String p_called_from_ca = request.getParameter( "p_called_from_ca" ) ;
		String ord_cat = request.getParameter( "ord_cat" ) ;//IN051144
		String sex = request.getParameter( "sex" ) ;
		String age = request.getParameter( "age" ) ;
		String dob = request.getParameter( "dob" ) ;
		String visit_adm_date =  (String)beanObj.getVisitAdmnDate(facility_id, episode_id) ;
		out.println( "callAmmendFunctions(\"" +order_id + "\", \"" + patient_id + "\", \"" + episode_id + "\",\"" + pract_reln_id + "\",\"" + location_type + "\",\"" + location_code + "\",\"" + patient_class + "\",\"" + p_called_from_ca + "\",\"" + sex + "\",\"" + age + "\",\"" + dob + "\",\"" + visit_adm_date + "\",\""+ord_cat+"\") ; " ) ;//IN051144 added ord_cat
	}else if( validate.equals( "fing_values" ) ) {
	   //String fingurePrnYN	= "N";
	   String fingurePrnYN = beanObj.fingurePrintYN();
	   out.println("fingurePrnYN='"+fingurePrnYN+"'");
	  // System.out.println("fingurePrnYN=========order========================="+fingurePrnYN+"----");
	   //out.println("alert('Incorporate The Fingure Signature Function. Please Contact Srikanta');");
	}else if(validate.equals( "print_values" ) ) {
		Hashtable allValues = beanObj.getAllValues();
		OnLinePrinting online_print = new OnLinePrinting();
		// added for IN053846 - Start
		String order_type_code = "";
		String patient_class = "";
		String perf_loc_code = "";
		String order_category = "";
		StringBuilder orderTypeBuilder = new StringBuilder();
		StringBuilder patientClassBuilder = new StringBuilder();
		StringBuilder perfLocBuilder = new StringBuilder();
		StringBuilder orderCategoryBuilder = new StringBuilder();
		String s_total_recs = (String)allValues.get("total_recs");
		Integer w_total_recs = Integer.parseInt(s_total_recs);
		for(int i=0;i<w_total_recs;i++){
			if(((String)allValues.get("chk"+i)).equalsIgnoreCase("on")){
				orderTypeBuilder.append("'" + (String)allValues.get("ord_typ_code"+i) + "',");
				patientClassBuilder.append("'" + (String)allValues.get("patient_class"+i)+ "',");
				perfLocBuilder.append("'" + (String)allValues.get("source_code"+i) + "',");
				orderCategoryBuilder.append("'" + (String)allValues.get("order_category"+i) + "',");
			}
		}
		order_category = orderCategoryBuilder.toString();
		if(order_category.contains("PH")) {	
			order_type_code = orderTypeBuilder.toString();
			patient_class = patientClassBuilder.toString();
			perf_loc_code = perfLocBuilder.toString();
			if(order_type_code.length() != 0){
				order_type_code = order_type_code.substring(0, order_type_code.length()-1);
			}
			if(patient_class.length() != 0){
				patient_class = patient_class.substring(0, patient_class.length()-1);
			}
			if(perfLocBuilder.length() != 0){
				perf_loc_code = perfLocBuilder.substring(0, perfLocBuilder.length()-1);
			}
					
			String ordSheetRuleInd = beanObj.getOrderSheetRule(order_type_code, patient_class, perf_loc_code);
			allValues.put("ordSheetRuleInd", ordSheetRuleInd);
			if(ordSheetRuleInd.contains("C") || (ordSheetRuleInd.contains("S"))){
				if(ordSheetRuleInd.contains("C")) {
					out.println( "confirmRoutinePrint();") ;
					//out.println( "confirmRoutinePrint(\"" +w_total_recs + "\");") ;
				} 
				else if(ordSheetRuleInd.contains("S")) {
					online_print.callOnlinePrint(allValues,request,response);
				}
			} 
		}
		else {
			online_print.callOnlinePrint(allValues,request,response);
		}
		// added for IN053846 - End
		//System.out.println("==== online_print obj ?>?>?>" + online_print);
		//out.println("pharmacyPrint(\""+print_ord_sht_rule_ind+"\")");//Added for Bru-HIMS-CRF-393_1.0
		//online_print.callOnlinePrint(allValues,request,response); - Commented for IN053846
				
	} else if(validate.equals( "PRINT_CONFIRM_VALUES" ) ) { // added for IN053846 - Start
		Hashtable allValues = beanObj.getAllValues();
		String ordSheetRuleInd = (String)allValues.get("ordSheetRuleInd");
		String chk_yn = request.getParameter( "chk_yn" )== null ?"":request.getParameter( "chk_yn" ) ;
		if(chk_yn.equalsIgnoreCase("Y") || ordSheetRuleInd.contains("S")) {
			allValues.put("print_confirm_yn", chk_yn);
		 	OnLinePrinting online_print = new OnLinePrinting();
		 	online_print.callOnlinePrint(allValues,request,response);
		}  // added for IN053846 - End
	}

	putObjectInBean(bean_id,beanObj,request);

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
