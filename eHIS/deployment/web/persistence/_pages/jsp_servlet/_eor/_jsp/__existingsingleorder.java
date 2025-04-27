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

public final class __existingsingleorder extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ExistingSingleOrder.jsp", 1709117172000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/ExistingSingleOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommon.js\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script>function_id = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";</script>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<frameset rows=\'34%,*\'>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<frameset rows=\'15%,*\'><!--Menaka -->\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<frame name=\'ExistingOrderSearch\' src=\'ExistingSingleOrderSearch.jsp?patient_id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&episode_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&encounter_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&pract_reln_id=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&location_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&location_code=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&patient_class=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&p_called_from_ca=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&Sex=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&Age=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&Dob=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&visit_adm_date=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&function_from=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&patientId=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&speciality_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&locn_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&locn_type=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&multi_called_from=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&include_checkout_patients=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' frameborder=0  scrolling=no noresize>\n\n\t<frame name=\'ExistingOrderResult\' src=\'../../eCommon/html/blank.html\' frameborder=0 scrolling=yes noresize>\n</frameset>\n</html>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(request.getParameter("function_id")));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);


    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String patient_id =		(String)request.getParameter("patient_id");
	String encounter_id =	(String)request.getParameter("episode_id");
	String pract_reln_id = (String)request.getParameter("relationship_id");
	String visit_adm_date = (String)request.getParameter("visit_adm_date");

	String location_type			= (String)request.getParameter("location_type");
	String locn_type			= (String)request.getParameter("locn_type")==null?"": (String)request.getParameter("locn_type");
	String location_code			= (String)request.getParameter("location_code");
	String locn_code			= (String)request.getParameter("locn_code")==null?"":(String)request.getParameter("locn_code");
	String patient_class			= (String)request.getParameter("patient_class");
	String p_called_from_ca			= (String)request.getParameter("p_called_from_ca");
	String function_from			= (String)request.getParameter("function_from")==null?"":(String)request.getParameter("function_from");
	String sex						= (String)request.getParameter("Sex");
	String age						= (String)request.getParameter("Age");
	String dob						= (String)request.getParameter("Dob");
	String patientId = request.getParameter("patientId")==null?"":request.getParameter("patientId") ;
	String speciality_code = request.getParameter("speciality_code")==null?"": request.getParameter("speciality_code");
	String multi_called_from = request.getParameter("multi_called_from")==null?"": request.getParameter("multi_called_from");
	String include_checkout_patients = request.getParameter("include_checkout_patients")==null?"": request.getParameter("include_checkout_patients");
	
 	if(patient_id!=null)
		patient_id = patient_id.trim();
	if(encounter_id!=null)
	encounter_id = encounter_id.trim();
	if(patient_class!=null)
	patient_class = patient_class.trim();
	if(function_from.equalsIgnoreCase("PASSED_ORDERS"))
	{

            _bw.write(_wl_block6Bytes, _wl_block6);

	}
	else
	{
	
            _bw.write(_wl_block7Bytes, _wl_block7);

	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pract_reln_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_called_from_ca));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(age));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(dob));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(visit_adm_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(include_checkout_patients));
            _bw.write(_wl_block27Bytes, _wl_block27);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
