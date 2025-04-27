package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __visitregistrationpromptpatid extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/VisitRegistrationPromptPatID.jsp", 1730091900986L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--    Function Name VisitRegistration\n    Created by M.Sathis Kumar on 13/12/2000 -->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n    <head>\n        <meta http-equiv=\"Expires\" content=\"0\">\n        <title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n        \n       \n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n    </head>\n    <iframe name=\'prompt_patidf1\' id=\'prompt_patidf1\' src=\'../../eMP/jsp/VisitRegistrationPromptPatIDF1.jsp?q_booking_ref_no=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&q_from_funct=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&gen_file_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&calledFrom=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&Unregpatbkgyn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&q_clinic_code=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&q_appt_ref_no=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&p_referral_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&func_act=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&fromVR=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&q_booking_type=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&function_id=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' frameborder=0 scrolling=\'no\' noresize style=\'height:80vh;width:100vw\'></iframe>\n        <iframe name=\'prompt_patidf2\' id=\'prompt_patidf2\' src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'no\' style=\'height:10vh;width:100vw\'></iframe>\n    <body onKeyDown =\'lockKey()\'>\n        <form name=\"promptpatid1\" id=\"promptpatid1\">\n\n\t\t\t<input type=\"hidden\" name=\"gen_file_yn\" id=\"gen_file_yn\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n            <input type=\"hidden\" name=\"q_clinic_code\" id=\"q_clinic_code\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n            <input type=\"hidden\" name=\"q_appt_ref_no\" id=\"q_appt_ref_no\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n            <input type=\"hidden\" name=\"q_from_funct\" id=\"q_from_funct\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n            <input type=\"hidden\" name=\"q_booking_ref_no\" id=\"q_booking_ref_no\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t\t\t<input type=\"hidden\" name=\"q_booking_type\" id=\"q_booking_type\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\n        </form>\n    </body>\n</html>\n\n";
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

            String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		  	request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            String gen_file_yn      = request.getParameter("gen_file_yn")==null?"":request.getParameter("gen_file_yn");
            String q_clinic_code    = request.getParameter("q_clinic_code")==null?"":request.getParameter("q_clinic_code");
            String q_appt_ref_no    = request.getParameter("q_appt_ref_no")==null?"":request.getParameter("q_appt_ref_no");
            String q_from_funct = request.getParameter("q_from_funct")==null?"":request.getParameter("q_from_funct"); 
            String q_booking_ref_no = request.getParameter("q_booking_ref_no")==null?"":request.getParameter("q_booking_ref_no");
			String q_booking_type = request.getParameter("q_booking_type")==null?"":request.getParameter("q_booking_type");
			
            String p_referral_id    = request.getParameter("p_referral_id")==null?"":request.getParameter("p_referral_id");

            String func_act = request.getParameter("func_act")==null?"":request.getParameter("func_act");
            String fromVR = request.getParameter("from_VR");
            
            if(fromVR == null)  fromVR= "" ;
			String calledFrom         = request.getParameter("calledFrom");
			if(calledFrom==null) calledFrom =""; 
			String Unregpatbkgyn         = request.getParameter("Unregpatbkgyn");
			if(Unregpatbkgyn==null) Unregpatbkgyn ="N"; 

			String function_id=(request.getParameter("function_id") == null)?"":request.getParameter("function_id");
       
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(q_booking_ref_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(q_from_funct));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(gen_file_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Unregpatbkgyn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_referral_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(func_act));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(fromVR));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(q_booking_type));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(gen_file_yn));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(q_clinic_code));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(q_appt_ref_no));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(q_from_funct));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(q_booking_ref_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(q_booking_type));
            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.EnterPatientID.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
