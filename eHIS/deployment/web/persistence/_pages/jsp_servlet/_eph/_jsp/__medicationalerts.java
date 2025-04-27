package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import java.lang.*;
import ePH.Common.*;
import ePH.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;

public final class __medicationalerts extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAlerts.jsp", 1709525594148L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\t</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<iframe name=\'FrameMedicationDisplayDetails\' id=\'FrameMedicationDisplayDetails\'\t\t\t\tsrc=\"../../ePH/jsp/MedicationAlerts_MIMS.jsp?patient_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&external_product_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&srl_no=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&drug_db_interact_check_flag=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&drug_db_duptherapy_flag=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&drug_db_contraind_check_flag=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&drug_db_dosecheck_flag=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&dosage_reason=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&duplicate_reason=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&conotra_reason=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&interaction_reason=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&alergy_reason=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&pract_name=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&drug_db_allergy_flag=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" frameborder=0 scrolling=\'auto\' style=\'height:65vh;width:100vw\'></iframe><iframe name=\'FrameMedicationAlertDetails\' id=\'FrameMedicationAlertDetails\'\t\t\t\tsrc=\"../../ePH/jsp/MedicationAlertDetails.jsp?patient_id=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&dosage_interface=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" frameborder=0 scrolling=\'auto\' style=\'height:30vh;width:100vw\'></iframe><iframe name=\'FrameMedicationAlertButtons\' id=\'FrameMedicationAlertButtons\'\t\t\t\tsrc=\"../../ePH/jsp/MedicationAlertButtons.jsp\" frameborder=0 scrolling=\'no\' style=\'height:5vh;width:100vw\'></iframe> \n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\t    \n\n\t\t\t<iframe name=\'FrameMedicationAlertDetails\' id=\'FrameMedicationAlertDetails\'\t\t\t\tsrc=\"../../ePH/jsp/MedicationAlertDetails.jsp?patient_id=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" frameborder=0 scrolling=\'auto\' style=\'height:95vh;width:100vw\'> </iframe>\n\t\t\t<!--\t<frame name=\'FrameMedicationAlertDetails\' id=\'FrameMedicationAlertDetails\'\t\t\t\tsrc=\"../../ePH/jsp/MedicationAlertDetails.jsp?patient_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" frameborder=0 scrolling=\'auto\'> -->\n\t\t\t<iframe name=\'FrameMedicationAlertButtons\' id=\'FrameMedicationAlertButtons\'\tsrc=\"../../ePH/jsp/MedicationAlertButtons.jsp\" frameborder=0 scrolling=\'no\'style=\'height:5vh;width:100vw\'></iframe>\n\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</html>  \n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block5Bytes, _wl_block5);

		String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		request.setCharacterEncoding("UTF-8");
		//Added by Himanshu for MMS-ME-SCF-0097 Starts 
				request= new XSSRequestWrapper(request); 
				response.addHeader("X-XSS-Protection", "1; mode=block"); 
				response.addHeader("X-Content-Type-Options", "nosniff"); 
				//Added by Himanshu for MMS-ME-SCF-0097 ends

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

	String  patient_id="",external_product_id="",drug_db_interact_check_flag="",drug_db_duptherapy_flag="",drug_db_contraind_check_flag="";
	patient_id						=   request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	external_product_id				=	request.getParameter("external_product_id");
	drug_db_interact_check_flag		=	request.getParameter("drug_db_interact_check_flag")==null?"": request.getParameter("drug_db_interact_check_flag");
	drug_db_duptherapy_flag			=	request.getParameter("drug_db_duptherapy_flag")==null?"": request.getParameter("drug_db_duptherapy_flag");
	drug_db_contraind_check_flag	=	request.getParameter("drug_db_contraind_check_flag")==null?"": request.getParameter("drug_db_contraind_check_flag");
	String drug_db_dosecheck_flag   =   request.getParameter("drug_db_dosecheck_flag")==null?"": request.getParameter("drug_db_dosecheck_flag");
	String drug_db_allergy_flag   =   request.getParameter("drug_db_allergy_flag")==null?"": request.getParameter("drug_db_allergy_flag");

	String srl_no					=   request.getParameter("srl_no")==null?"": request.getParameter("srl_no");
	String dosage_reason			=	request.getParameter("dsg_reason")==null?"": request.getParameter("dsg_reason");
	String duplicate_reason			=	request.getParameter("dup_reason")==null?"": request.getParameter("dup_reason");
	String conotra_reason			=	request.getParameter("con_reason")==null?"": request.getParameter("con_reason");
	String interaction_reason		=	request.getParameter("int_reason")==null?"": request.getParameter("int_reason");
	String alergy_reason			=	request.getParameter("alg_reason")==null?"": request.getParameter("alg_reason");
	String pract_name				=	request.getParameter("pract_name")==null?"": request.getParameter("pract_name");

	String dosage_interface			=	request.getParameter("dosage_interface")==null?"": request.getParameter("dosage_interface");

   // Added in JUNE 2012 - New changes 
	String ex_bean_id				= "@ExternalProductLinkBean";
	String ex_bean_name				= "ePH.ExternalProductLinkBean";
	//String dosage_flag  = "N";
	ExternalProductLinkBean beanex = (ExternalProductLinkBean)getBeanObject(ex_bean_id,ex_bean_name,request);
	if(beanex!=null && beanex.getProdID()!=null && (beanex.getProdID()).equals("CIMS")){ // for CIMS
 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(external_product_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_dosecheck_flag));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(dosage_reason,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(duplicate_reason,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(conotra_reason,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(interaction_reason,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(alergy_reason,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(external_product_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_dosecheck_flag));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(dosage_reason,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(duplicate_reason,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(conotra_reason,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(interaction_reason,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(alergy_reason,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dosage_interface));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	else {  // For FDB or other 

            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(external_product_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_dosecheck_flag));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(java.net.URLEncoder.encode(dosage_reason,"UTF-8")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(java.net.URLEncoder.encode(duplicate_reason,"UTF-8")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(java.net.URLEncoder.encode(conotra_reason,"UTF-8")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(interaction_reason,"UTF-8")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(java.net.URLEncoder.encode(alergy_reason,"UTF-8")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(java.net.URLEncoder.encode(pract_name,"UTF-8")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(external_product_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(srl_no));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(drug_db_interact_check_flag));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(drug_db_duptherapy_flag));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drug_db_contraind_check_flag));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(drug_db_dosecheck_flag));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(dosage_reason));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(duplicate_reason));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(conotra_reason));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(interaction_reason));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(alergy_reason));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(drug_db_allergy_flag));
            _bw.write(_wl_block28Bytes, _wl_block28);

		} // Added in JUNE 2012 - New changes 
		putObjectInBean(ex_bean_id,beanex,request); 

            _bw.write(_wl_block29Bytes, _wl_block29);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MedicationAlerts.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
