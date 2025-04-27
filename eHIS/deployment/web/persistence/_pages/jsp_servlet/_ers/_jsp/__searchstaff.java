package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __searchstaff extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/SearchStaff.jsp", 1741325974206L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\t\n*\tCreated By\t\t:\tSuchilagna Panigrahi\n*\tCreated On\t\t:\t04 Oct 2004\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"JavaScript\" src=\"../js/RSCommon.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../js/RSMessages.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"> </script> -->\n<script language=\"javascript\" src=\"../js/SearchStaff.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t    <iframe name=\"commontoolbarFrame\" src=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\" frameborder=\"0\" scrolling=\"no\" noresize style=\"height:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =";width:98vw\"></iframe>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t<iframe name=\"f_query_select\" src=\'../../eRS/jsp/SearchStaffCriteria.jsp?p_role_type=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&p_staff_type=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&p_mode=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&p_primary_speciality_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&p_staff_id=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&p_staff_name=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&p_gender=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&p_age=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&p_empl_status=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&p_facility_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&p_position_code=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&p_position_desc=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&p_skill_code=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&p_license_code";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&p_training_code";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'  frameborder=\"0\" scrolling=\"no\" noresize style=\"height:";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =";width:98vw\"></iframe>\n\t<iframe name=\"f_query_details\" src=\'../../eCommon/html/blank.html?p_role_type=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' frameborder=\"0\" scrolling=\"auto\" noresize style=\"height:";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =";width:98vw\"></iframe>\n\t<iframe name=\"messageFrame\" src=\'../../eCommon/jsp/error.jsp\' frameborder=\"0\" noresize scrolling=\"auto\" style=\"height:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 =";width:98vw\"></iframe>\n\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
 
request.setCharacterEncoding("UTF-8");
String p_mode=request.getParameter("mode")==null ? "":request.getParameter("mode");
String source ="";
    if(!p_mode.equals(""))
	 source = "../../eRS/html/SearchStaff.html" ;
	else
	{
	String url = "../../eCommon/jsp/commonToolbar.jsp?" ;
 	String params = request.getQueryString();
	 source = url + params ;
	}
	String p_role_type=request.getParameter("p_role_type")==null ? "":request.getParameter("p_role_type");
	String p_staff_id=request.getParameter("p_staff_id")==null ? "":request.getParameter("p_staff_id");
	
 	String p_primary_speciality_code=request.getParameter("p_primary_speciality_code")==null ? "":request.getParameter("p_primary_speciality_code");

	String p_staff_name=request.getParameter("p_staff_name")==null ? "":request.getParameter("p_staff_name");
	String p_staff_type=request.getParameter("p_staff_type")==null ? "":request.getParameter("p_staff_type");
	String p_gender=request.getParameter("p_gender")==null ? "":request.getParameter("p_gender");
	String p_age=request.getParameter("p_age")==null ? "":request.getParameter("p_age");
	String p_empl_status=request.getParameter("p_empl_status")==null ? "":request.getParameter("p_empl_status");
	String p_facility_id=request.getParameter("p_facility_id")==null ? "":request.getParameter("p_facility_id");
	String p_position_code=request.getParameter("p_position_code")==null ? "":request.getParameter("p_position_code");
	String p_position_desc=request.getParameter("p_position_desc")==null ? "":request.getParameter("p_position_desc");
	String p_skill_code=request.getParameter("p_skill_code")==null ? "":request.getParameter("p_skill_code");
	String p_license_code=request.getParameter("p_license_code")==null ? "":request.getParameter("p_license_code");
	String p_training_code=request.getParameter("p_training_code")==null ? "":request.getParameter("p_training_code");
	String height1, height2, height3, height4;
	if(!p_mode.equals("")) {
	    height1 = "40vh";  
	    height2 = "5vh";   
	    height3 = "44vh"; 
	    height4 = "8vh";   
	} else {
	    height1 = "16vh";  
	    height2 = "76vh";  
	    height3 = "8vh";   
	    height4 = "0vh";   
	}
	
            _bw.write(_wl_block7Bytes, _wl_block7);
 if(!p_mode.equals("")) { 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( height1 ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 } else { 
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( source ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( height2 ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 } 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf( p_role_type ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( p_staff_type ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( p_mode ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf( p_primary_speciality_code ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf( p_staff_id ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( p_staff_name ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( p_gender ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( p_age ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( p_empl_status ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( p_facility_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( p_position_code ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( p_position_desc ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( p_skill_code ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( p_license_code ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( p_training_code ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( height3 ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( p_role_type ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( p_staff_type ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( p_mode ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( height4 ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( height4 ));
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.StaffDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
