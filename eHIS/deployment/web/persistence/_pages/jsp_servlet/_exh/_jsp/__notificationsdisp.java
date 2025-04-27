package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __notificationsdisp extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/NotificationsDisp.jsp", 1709122369491L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../eCommon/js/CommonCalendar.js\"></SCRIPT>\n<SCRIPT LANGUAGE=\"javascript\" SRC=\"../eXH/js/NotificationsDisp.js\"></SCRIPT>\n\n<BODY LEFTMARGIN=\"0\" TOPMARGIN=\"0\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\"initNotificationDisp(\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\')\">\n<FORM ID=\"notificationDisp\" name=\"notificationDisp\" id=\"notificationDisp\" METHOD=\"post\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<TABLE CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"0\" WIDTH=\"100%\">\n<TR>\n\t<TD ALIGN=\"left\" CLASS=\"CAGROUP\" COLSPAN=\"1\">\n\t\tNotifications\n\t</TD>\n\t<TD ALIGN=\"right\" CLASS=\"CAGROUP\" COLSPAN=\"12\"> \n\t\t<A CLASS=\'label\' STYLE=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</A>\n\t\t<A CLASS=\'label\' onClick=\"funAction(\'N\')\" STYLE=\'cursor:pointer\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t</TD>\n</TR>\n</TABLE>\n<TABLE CELLSPACING=\"0\" CELLPADDING=\"3\" BORDER=\"1\" WIDTH=\"100%\">\n<TR>\n\t<TD CLASS=\'COLUMNHEADER\'>Status</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Message ID</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Recipient ID</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Message Date</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Message Type</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Facility</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Contact</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Recipient Type</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Recipient Dependency</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Contact Type</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Contact Mode</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Language</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Added By</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Added Date</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Added WSNO</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Added Facility</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Modified By</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Modified Date</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Modified WSNO</TD>\n\t<TD CLASS=\'COLUMNHEADER\'>Modified Facility</TD>\n</TR>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<TR>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"><IMG SRC=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\" HEIGHT=\"10\"></TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t\t<A HREF=\"#\" onClick=\"viewMessage(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\',\n\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\')\">\n\t\t\t<IMG BORDER=\"0\" SRC=\"../eXH/images/setting.png\" TITLE=\"View Message\">\n\t\t</A>\n\t</TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</TD>\n\t<TD CLASS=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</TD>\n</TR>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</TABLE>\n</FORM>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

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
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${noRecords}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block1Bytes, _wl_block1);
 System.out.println("Test JSP"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${previousPage}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${nextPage}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
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
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("notificationCriteriaBean", java.lang.String .class,"var"));
        __tag0.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${requestScope.notificationCriteriaBean}",java.lang.Object.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag1 = null ;
        int __result__tag1 = 0 ;
        boolean _skipPage__tag1= false;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("notification", java.lang.String .class,"var"));
        __tag1.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${notificationList}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag1;
            __result__tag1 = __tag1.doStartTag();

            if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block10Bytes, _wl_block10);

                    if (_jsp__tag2(request, response, pageContext, _activeTag, __tag1))
                     return true;
                    _bw.write(_wl_block11Bytes, _wl_block11);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'STATUS_COLOR\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block13Bytes, _wl_block13);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block14Bytes, _wl_block14);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'SMS_BODY_CONTENT_CLOB\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MAIL_BODY_CONTENT_CLOB\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'STATUS_TEXT\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block16Bytes, _wl_block16);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'RECIPIENT_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MESSAGE_DATE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'EVENT_NAME\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'FACILITY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'RECIPIENT_TYPE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'RECIPIENT_DEPENDENCY\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'CONTACT_TYPE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'CONTACT_MODE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'LANGUAGE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_BY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_DATE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_AT_WS_NO\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'ADDED_FACILITY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MODIFIED_DATE\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MODIFIED_AT_WS_NO\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${CLASS_NAME}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'MODIFIED_FACILITY_ID\']}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                } while (__tag1.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag1 = true;
                return true;
            }
            _activeTag=__tag1.getParent();
            _skipPage__tag1 = false;
        } catch (java.lang.Throwable __t){
            __tag1.doCatch(__t);
        } finally {
            __tag1.doFinally();
            if (!_skipPage__tag1){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
                __tag1.release();
            }else{
                _releaseTags(pageContext, __tag1);
            }
        }
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.SetTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.SetTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(parent);
        __tag2.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("CLASS_NAME", java.lang.String .class,"var"));
        __tag2.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${notification[\'TD_CLASS_NAME\']}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }
}
