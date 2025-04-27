package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import java.net.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __addmodifygroupappointment extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/AddModifyGroupAppointment.jsp", 1709700974015L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n   ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<head><title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title></head>\n\t<iframe name=\'f_query_add_mod\' id=\'f_query_add_mod\' src=\"../../eOA/jsp/AppointmentGroupSelect.jsp?i_clinic_code=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="&i_clinic_name=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&i_practitioner_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&i_practitioner_name=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&i_appt_date=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&i_from_time=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&i_to_time=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&i_time_table_type=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&i_patient_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&clinic_type=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&res_type=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&or_catalogue_code=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&order_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&order_line_num=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&order_catalog_code=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&create_wait_list_yn=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&entitlement_by_pat_cat_yn=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&max_patients_per_slab=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"  scrolling=\'no\' marginheight=\'0\' marginwidth=\'0\' style=\'height:86vh;width:100vw\'></iframe>\n\t<iframe name=\'ButtonFrame\' id=\'ButtonFrame\'  src=\'../../eOA/jsp/BookApptButtons.jsp?fromPage=GroupAppoinment\'  noresize scrolling=\'no\' marginheight=\'0\' marginwidth=\'0\' style=\'height:5vh;width:100vw\'></iframe>\n\t<iframe name=\'messageFrame\' id=\'messageFrame\'  src=\'../../eCommon/jsp/error.jsp\'  noresize scrolling=\'auto\' marginheight=\'0\' marginwidth=\'0\' style=\'height:9vh;width:100vw\'></iframe></html>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );


public static String checkForNull(String inputString)
{
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

try{
		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
String i_clinic_code= checkForNull(request.getParameter("i_clinic_code"));
String i_clinic_name=checkForNull(request.getParameter("i_clinic_name"));
String i_practitioner_id=checkForNull(request.getParameter("i_practitioner_id"));
String i_practitioner_name=checkForNull(request.getParameter("i_practitioner_name"));
String i_appt_date=checkForNull(request.getParameter("i_appt_date"));
String i_from_time=checkForNull(request.getParameter("i_from_time"));
String i_to_time=checkForNull(request.getParameter("i_to_time"));
String i_time_table_type=checkForNull(request.getParameter("i_time_table_type"));
String i_patient_id=checkForNull(request.getParameter("i_patient_id"));
String clinic_type=checkForNull(request.getParameter("clinic_type"));
String res_type=checkForNull(request.getParameter("res_type"));
String or_catalogue_code=checkForNull(request.getParameter("or_catalogue_code"));
String order_id=checkForNull(request.getParameter("order_id"));
String order_line_num=checkForNull(request.getParameter("order_line_num"));
String order_catalog_code=checkForNull(request.getParameter("order_catalog_code"));
String create_wait_list_yn=checkForNull(request.getParameter("create_wait_list_yn"));
String entitlement_by_pat_cat_yn	= checkForNull(request.getParameter("entitlement_by_pat_cat_yn"));
String max_patients_per_slab	= checkForNull(request.getParameter("max_patients_per_slab"));
String calling_mode	= checkForNull(request.getParameter("calling_mode"));

System.out.println("i_clinic_code==>"+i_clinic_code);
System.out.println("i_clinic_name==>"+i_clinic_name);
System.out.println("i_practitioner_id==>"+i_practitioner_id);
System.out.println("i_practitioner_name==>"+i_practitioner_name);
System.out.println("i_appt_date==>"+i_appt_date);
System.out.println("i_from_time==>"+i_from_time);
System.out.println("i_to_time==>"+i_to_time);
System.out.println("i_time_table_type==>"+i_time_table_type);
System.out.println("i_patient_id==>"+i_patient_id);
System.out.println("clinic_type==>"+clinic_type);
System.out.println("res_type==>"+res_type);
System.out.println("entitlement_by_pat_cat_yn==>"+entitlement_by_pat_cat_yn);
   
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(i_clinic_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(i_clinic_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(i_practitioner_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(i_practitioner_name));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i_appt_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(i_from_time));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(i_to_time));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i_time_table_type));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i_patient_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(entitlement_by_pat_cat_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(max_patients_per_slab));
            _bw.write(_wl_block26Bytes, _wl_block26);

   }catch(Exception e){
		e.printStackTrace();
	}
		
            _bw.write(_wl_block27Bytes, _wl_block27);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.AppointmentGroups.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
