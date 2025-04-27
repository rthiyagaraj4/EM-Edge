package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import java.sql.*;
import webbeans.eCommon.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __medicationalerts_mims extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAlerts_MIMS.jsp", 1709117352133L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<?xml version=\'1.0\' encoding=\"UTF-8\"?>\n<?xml-stylesheet type=\"text/xsl\" href=\"../../ePH/html/CIMSAlertDisplay.xsl\"?>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t \n";
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
        response.setHeader("Content-Type", "application/xml;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("application/xml;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

		StringBuffer dup_drug_det_sbf = new   StringBuffer();
		String  patient_id="",external_product_id="",drug_db_interact_check_flag="",drug_db_duptherapy_flag="",DosageAlert="",AllergyAlert="",drug_db_contraind_check_flag="",dup_drug_det="",drug_db_allergy_flag="";
		patient_id						=   request.getParameter("patient_id");
		external_product_id				=	request.getParameter("external_product_id");
		drug_db_interact_check_flag		=	request.getParameter("drug_db_interact_check_flag");
		drug_db_duptherapy_flag			=	request.getParameter("drug_db_duptherapy_flag");
		drug_db_contraind_check_flag	=	request.getParameter("drug_db_contraind_check_flag");
		drug_db_allergy_flag             =	request.getParameter("drug_db_allergy_flag");
		String drug_db_dosecheck_flag	        =   request.getParameter("drug_db_dosecheck_flag");
		String conotra_reason			        =	request.getParameter("conotra_reason")==null?"": request.getParameter("conotra_reason");
		if(!conotra_reason.equals(""))
			conotra_reason = java.net.URLDecoder.decode(conotra_reason,"UTF-8");
		String interaction_reason		        =	request.getParameter("interaction_reason")==null?"": request.getParameter("interaction_reason");
		if(!interaction_reason.equals(""))
			interaction_reason = java.net.URLDecoder.decode(interaction_reason,"UTF-8");
		String alergy_reason			        =	request.getParameter("alergy_reason")==null?"": request.getParameter("alergy_reason");
		if(!alergy_reason.equals(""))
			alergy_reason = java.net.URLDecoder.decode(alergy_reason,"UTF-8");
		String duplicate_reason			        =	request.getParameter("duplicate_reason")==null?"": request.getParameter("duplicate_reason");
		if(!duplicate_reason.equals(""))
			duplicate_reason = java.net.URLDecoder.decode(duplicate_reason,"UTF-8");

		String dosage_reason			        =	request.getParameter("dosage_reason")==null?"": request.getParameter("dosage_reason");
		if(!dosage_reason.equals(""))
			dosage_reason = java.net.URLDecoder.decode(dosage_reason,"UTF-8");

		String pract_name						=	request.getParameter("pract_name");	
		pract_name = java.net.URLDecoder.decode(pract_name,"UTF-8");
		//pract_name=pract_name.replaceAll("%20"," ");
		String srl_no							=   request.getParameter("srl_no");
		String ex_bean_id   = "@ExternalProductLinkBean";
		String ex_bean_name = "ePH.ExternalProductLinkBean";
		//String dosage_flag  = "N";
		ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
		//HashMap externalDBCheckResult	=   beanex.getExternalDBCheckResult(external_product_id, srl_no);

		StringBuffer externalDBCheckResult	= new StringBuffer();	  // Added in June 2012
		dup_drug_det_sbf				= beanex.getStoreResult();				  // Added in June 2012
		HashMap drugProduct				= beanex.getDrugProduct();
		if(drug_db_duptherapy_flag.equals("Y") || drug_db_interact_check_flag.equals("Y") ||  drug_db_contraind_check_flag.equals("Y") || drug_db_allergy_flag.equals("Y") || drug_db_dosecheck_flag.equals("Y")){

			 String ext_prod_id_without_delim = "";
			 if(external_product_id.indexOf("::")!=-1)
					ext_prod_id_without_delim = external_product_id.substring(external_product_id.indexOf("::")+2);
				else
					ext_prod_id_without_delim  = external_product_id;
			//Added in January 2014 - to remove the unncessary warnings for dosage..
//			dup_drug_det_sbf = (StringBuffer)beanex.getWithoutDosageWarningXML(dup_drug_det_sbf, ext_prod_id_without_delim);    //IN066787- Performance


			StringBuffer dup_drug_det_sbf_result= new StringBuffer();
			 dup_drug_det_sbf_result = (StringBuffer)beanex.getContentXML(dup_drug_det_sbf, ext_prod_id_without_delim, drugProduct);

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(dup_drug_det_sbf_result));
            _bw.write(_wl_block3Bytes, _wl_block3);

		}
		putObjectInBean(ex_bean_id,beanex,request); 

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
