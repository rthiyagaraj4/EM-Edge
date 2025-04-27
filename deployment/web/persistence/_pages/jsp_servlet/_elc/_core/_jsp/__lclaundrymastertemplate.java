package jsp_servlet._elc._core._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.vo.UserPreferences;
import com.iba.framework.cache.pojo.business.Cache;
import com.iba.framework.cache.pojo.business.CacheManager;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.Constants;

public final class __lclaundrymastertemplate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/core/jsp/LcLaundryMasterTemplate.jsp", 1709118039693L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/framework/html/Tag.text", 1669269889579L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\r\n<script>\r\n\tvar loadMethod=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\"\r\n\tvar applyMethod=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"\r\n\tvar queryMethod=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\"\r\n\tvar updateMethod=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"\r\n\tvar deleteMethod=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"\r\n\tvar contextPath=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"\r\n\tvar dwrMessage=\"\";\r\n\t\r\n</script>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t \n\t<frameset rows=\"19%,*,10%\" frameborder=\"0\" framespacing=\"0\">\n\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\n</frameset>\n\n\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(Constants.LOAD));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(Constants.CREATE));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(Constants.QUERY));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(Constants.UPDATE));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(Constants.DELETE));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            _bw.write(_wl_block11Bytes, _wl_block11);
             org.apache.struts.taglib.tiles.UseAttributeTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.apache.struts.taglib.tiles.UseAttributeTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setPageContext(pageContext);
            __tag0.setParent(null);
            __tag0.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lclaundrytoolbar", java.lang.String .class,"name"));
            __tag0.setClassname(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("String", java.lang.String .class,"classname"));
            _activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.tiles.UseAttributeTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag0);
                return;
            }
            _activeTag=__tag0.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            __tag0.release();
             String lclaundrytoolbar=( String )pageContext.findAttribute("lclaundrytoolbar");
            _bw.write(_wl_block12Bytes, _wl_block12);
             org.apache.struts.taglib.tiles.UseAttributeTag __tag1 = null ;
            int __result__tag1 = 0 ;

            if (__tag1 == null ){
                __tag1 = new  org.apache.struts.taglib.tiles.UseAttributeTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
            }
            __tag1.setPageContext(pageContext);
            __tag1.setParent(null);
            __tag1.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("content", java.lang.String .class,"name"));
            __tag1.setClassname(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("String", java.lang.String .class,"classname"));
            _activeTag=__tag1;
            __result__tag1 = __tag1.doStartTag();

            if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.tiles.UseAttributeTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag1);
                return;
            }
            _activeTag=__tag1.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
            __tag1.release();
             String content=( String )pageContext.findAttribute("content");
            _bw.write(_wl_block12Bytes, _wl_block12);
             org.apache.struts.taglib.tiles.UseAttributeTag __tag2 = null ;
            int __result__tag2 = 0 ;

            if (__tag2 == null ){
                __tag2 = new  org.apache.struts.taglib.tiles.UseAttributeTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
            }
            __tag2.setPageContext(pageContext);
            __tag2.setParent(null);
            __tag2.setName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("messageFrame", java.lang.String .class,"name"));
            __tag2.setClassname(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("String", java.lang.String .class,"classname"));
            _activeTag=__tag2;
            __result__tag2 = __tag2.doStartTag();

            if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.tiles.UseAttributeTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
            }
            if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag2);
                return;
            }
            _activeTag=__tag2.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
            __tag2.release();
             String messageFrame=( String )pageContext.findAttribute("messageFrame");
            _bw.write(_wl_block12Bytes, _wl_block12);

			String languageId = (String) session.getAttribute("LOCALE");
			UserPreferences userPrefs =new UserPreferences();
			userPrefs.setDateFormat("dd/MM/yyyy") ;
  			userPrefs.setTimeFormat("HH:mm");
			userPrefs.setLocale(languageId);

			/* Cache cache = CacheManager.getCache();
			cache.putObject(Constants.USER_SESSION_CACHE, request.getSession().getId(), Constants.USER_PREFS,userPrefs); */ //AMRI-SCF-0679
			
		
            _bw.write(_wl_block13Bytes, _wl_block13);
             org.apache.struts.taglib.html.FrameTag __tag3 = null ;
            int __result__tag3 = 0 ;

            if (__tag3 == null ){
                __tag3 = new  org.apache.struts.taglib.html.FrameTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
            }
            __tag3.setPageContext(pageContext);
            __tag3.setParent(null);
            __tag3.setFrameName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("lclaundrytoolbar", java.lang.String .class,"frameName"));
            __tag3.setHref(lclaundrytoolbar
);
            __tag3.setNoresize(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
            __tag3.setScrolling(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("no", java.lang.String .class,"scrolling"));
            _activeTag=__tag3;
            __result__tag3 = __tag3.doStartTag();

            if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag3);
                return;
            }
            _activeTag=__tag3.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
            __tag3.release();
            _bw.write(_wl_block14Bytes, _wl_block14);
             org.apache.struts.taglib.html.FrameTag __tag4 = null ;
            int __result__tag4 = 0 ;

            if (__tag4 == null ){
                __tag4 = new  org.apache.struts.taglib.html.FrameTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
            }
            __tag4.setPageContext(pageContext);
            __tag4.setParent(null);
            __tag4.setFrameName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("content", java.lang.String .class,"frameName"));
            __tag4.setHref(content
);
            __tag4.setNoresize(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
            _activeTag=__tag4;
            __result__tag4 = __tag4.doStartTag();

            if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag4);
                return;
            }
            _activeTag=__tag4.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
            __tag4.release();
            _bw.write(_wl_block14Bytes, _wl_block14);
             org.apache.struts.taglib.html.FrameTag __tag5 = null ;
            int __result__tag5 = 0 ;

            if (__tag5 == null ){
                __tag5 = new  org.apache.struts.taglib.html.FrameTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
            }
            __tag5.setPageContext(pageContext);
            __tag5.setParent(null);
            __tag5.setFrameName(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("messageFrame", java.lang.String .class,"frameName"));
            __tag5.setHref(messageFrame
);
            __tag5.setNoresize(java.lang.Boolean.valueOf( weblogic.utils.StringUtils.valueOf("true")).booleanValue());
            __tag5.setScrolling(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("no", java.lang.String .class,"scrolling"));
            _activeTag=__tag5;
            __result__tag5 = __tag5.doStartTag();

            if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag5);
                return;
            }
            _activeTag=__tag5.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
            __tag5.release();
            _bw.write(_wl_block15Bytes, _wl_block15);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
