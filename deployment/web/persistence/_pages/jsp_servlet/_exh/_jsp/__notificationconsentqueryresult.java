package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __notificationconsentqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/NotificationConsentQueryResult.jsp", 1733057719822L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eXH/jsp/CommonInclude.jsp", 1733047974702L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../eXH/js/CommonCalendar.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../eXH/js/NotificationConsent.js\"></SCRIPT>\n</head>\n\n\n\n<BODY LEFTMARGIN=\"0\" TOPMARGIN=\"0\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\'>\n<FORM ID=\"notificationConsentList\" name=\"notificationConsentList\" id=\"notificationConsentList\" METHOD=\"post\" ACTION=\'../servlet/eXH.notificationConsentSetupServlet\'>\n\n<TABLE CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"1\" WIDTH=\"100%\">\n<TR>\n\t<TD ALIGN=\"right\" CLASS=\"CAGROUP\" COLSPAN=\"7\"> \n\t\t<A CLASS=\'label\' onClick=\"funAction(\'P\')\" STYLE=\'cursor:pointer\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</A>\n\t\t<A CLASS=\'label\' onClick=\"funAction(\'N\')\" STYLE=\'cursor:pointer\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t</TD>\n</TR>\n<TR>\n\t<TD CLASS=\'COLUMNHEADER\'>Patient ID</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Contact Mode</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Language</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Status</TD>\n</TR>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<TR>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t\t<A HREF=\'#\' onClick=\'funModify(this)\' typeCode=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n\t</TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TD>\n</TR>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n</TABLE>\n\n<INPUT TYPE=\'hidden\' name=\'action_type\' id=\'action_type\' ID=\'action_type\' VALUE=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<INPUT TYPE=\'hidden\' name=\'requestType\' id=\'requestType\' ID=\'requestType\'>\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
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

	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${previousPage}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${nextPage}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${action_type}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block18Bytes, _wl_block18);
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
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag0 = null ;
        int __result__tag0 = 0 ;
        boolean _skipPage__tag0= false;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("notificationConsent", java.lang.String .class,"var"));
        __tag0.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationConsents}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block10Bytes, _wl_block10);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationConsent[4]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block11Bytes, _wl_block11);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationConsent[3]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationConsent[0]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${recipient[15]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block14Bytes, _wl_block14);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationConsent[4]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${recipient[15]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block14Bytes, _wl_block14);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${languages[notificationConsent[7]]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${recipient[15]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block14Bytes, _wl_block14);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationConsent[5]}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block16Bytes, _wl_block16);
                } while (__tag0.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag0 = true;
                return true;
            }
            _activeTag=__tag0.getParent();
            _skipPage__tag0 = false;
        } catch (java.lang.Throwable __t){
            __tag0.doCatch(__t);
        } finally {
            __tag0.doFinally();
            if (!_skipPage__tag0){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
                __tag0.release();
            }else{
                _releaseTags(pageContext, __tag0);
            }
        }
        return false;
    }
}
