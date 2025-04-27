package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.XHDBAdapter;
import java.util.*;
import com.ehis.util.*;

public final class __filtercriteriasettings extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/FilterCriteriaSettings.jsp", 1742466155295L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01//EN\" \"http://www.w3.org/TR/html4/strict.dtd\">\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HTML>\n<HEAD>\n<link rel=\'StyleSheet\' href=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="/eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\n\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/eCommon/js/common.js\'> </Script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eCommon/js/ValidateControl.js\"></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eCommon/js/jquery-3.6.3.js\'></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="/eXH/js/FilterCriteriaSettings.js\'></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/eXH/js/Validate.js\'></script>\n<SCRIPT LANGUAGE=\"JAVASCRIPT\" SRC=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/eCommon/js/CommonLookup.js\"></Script>\n<script src=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n<script type=\'text/javascript\'>//<![CDATA[ \n$(window).load(function(){\n/**\n * Stop the backspace key from acting like the Back button\n */\n$(\'textarea[readonly]\').keydown(function(event) {\n    if (event.which === 8) {\n        event.preventDefault();\n    }\n});\n\n});//]]>  \n\n</script>\n\n\n\n</HEAD>\n<BODY LEFTMARGIN=\"0\" TOPMARGIN=\"0\" onMouseDown=\"CodeArrest()\" onKeyDown =\'lockKey()\' onLoad=\"criteriaSettingsInit()\">\n<FORM ID=\"FilterCriteriaSettings\" name=\"FilterCriteriaSettings\" id=\"FilterCriteriaSettings\" TARGET=\'messageFrame\' METHOD=\"post\" ACTION=\'../servlet/eXH.FilterCriteriaSettingsServlet\'>\n<TABLE CELLSPACING=\"10\" ALIGN=\"CENTER\">\n\t<TR>\n\t\t<TD>\n\t\t\t<INPUT class=\"BUTTON\" TYPE=\"button\" VALUE=\"(\" TITLE=\"Add Left bracket to filter criteria\" onClick=\"addLeftBracket()\">\n\t\t</TD>\n\t\t<TD CLASS=\'fields\'>\n\t\t\t<SELECT ID=\"criteriaElement\" name=\"criteriaElement\" id=\"criteriaElement\" onChange=\"criteriaElementChange()\">\n\t\t\t<OPTION VALUE=\"\" SELECTED>Select</OPTION>\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<OPTION VALUE=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</OPTION>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD CLASS=\'fields\'>\n\t\t\t<SELECT ID=\"operator\" name=\"operator\" id=\"operator\" onChange=\"operatorChange()\">\n\t\t\t\t<OPTION VALUE=\"\" SELECTED></OPTION>\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t<OPTION VALUE=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD CLASS=\'fields\'>\n\t\t\t<SELECT ID=\"filterValues\" name=\"filterValues\" id=\"filterValues\">\n\t\t\t\t<OPTION VALUE=\"\" SELECTED>Select</OPTION>\n\t\t\t</SELECT>\n\t\t\t<SELECT ID=\"filterValuesBTWN\" name=\"filterValuesBTWN\" id=\"filterValuesBTWN\" STYLE=\"display:none\">\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD>\n\t\t\t<INPUT class=\"BUTTON\" TYPE=\"button\" VALUE=\")\" TITLE=\"Add Right bracket to filter criteria\" onClick=\"addRightBracket()\">\n\t\t</TD>\n\t\t<TD CLASS=\'fields\'>\n\t\t\t<SELECT ID=\"logicOperator\" name=\"logicOperator\" id=\"logicOperator\">\n\t\t\t\t<OPTION VALUE=\"\" SELECTED>Operator</OPTION>\n\t\t\t\t<OPTION VALUE=\" AND \">AND</OPTION>\n\t\t\t\t<OPTION VALUE=\" OR \">OR</OPTION>\n\t\t\t</SELECT>\n\t\t</TD>\n\t\t<TD>\n\t\t\t<INPUT class=\"BUTTON\" TYPE=\"button\" name=\"ADD_FILTER\" id=\"ADD_FILTER\" VALUE=\"Add to Filter\" onClick=\"addFilterCriteria()\">\n\t\t</TD>\n\t</TR>\n</TABLE>\n<TABLE CELLSPACING=\"10\" ALIGN=\"CENTER\">\n\t<TR>\n\t\t<TD CLASS=\'fields\'>\n\t\t\t<TEXTAREA ID=\"guiFilterSyntax\" NAME=\"guiFilterSyntax\" ROWS=\"6\" COLS=\"50\" READONLY></TEXTAREA>\n\t\t</TD>\n\t</TR>\n\t<TR>\n\t\t<TD>\n\t\t\t<INPUT class=\"BUTTON\" TYPE=\"button\" name=\"CLEAR_FILTER\" id=\"CLEAR_FILTER\" VALUE=\"Clear Filter\" onClick=\"clearFilterCriteria()\">\n\t\t\t<INPUT class=\"BUTTON\" TYPE=\"button\" name=\"SAVE_FILTER\" id=\"SAVE_FILTER\" VALUE=\"Save\" onClick=\"saveFilterCriteria()\">\n\t\t</TD>\n\t</TR>\n</TABLE>\n\n<INPUT TYPE=\"HIDDEN\" ID=\"filterGroupCode\" name=\"filterGroupCode\" id=\"filterGroupCode\" VALUE=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =">\n<INPUT TYPE=\"HIDDEN\" ID=\"processingFilterSyntax\" name=\"processingFilterSyntax\" id=\"processingFilterSyntax\">\n<INPUT TYPE=\"HIDDEN\" ID=\"requestType\" name=\"requestType\" id=\"requestType\" VALUE=\"SAVE_FILTER\">\n<INPUT TYPE=\"HIDDEN\" ID=\"dependantCriteriaDtlsJSON\" name=\"dependantCriteriaDtlsJSON\" id=\"dependantCriteriaDtlsJSON\" VALUE=\"{}\">\n\n</FORM>\t\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String filter_group = request.getParameter("Filter_group_code");
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${param.filterGroupCode}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
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
        __tag0.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${criteriaElementList}",java.lang.Object.class,pageContext,_jspx_fnmap));
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("currentElement", java.lang.String .class,"var"));
        try {_activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${currentElement.key}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block16Bytes, _wl_block16);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${currentElement.value}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
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
        __tag1.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${operatorList}",java.lang.Object.class,pageContext,_jspx_fnmap));
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("currentOperator", java.lang.String .class,"var"));
        try {_activeTag=__tag1;
            __result__tag1 = __tag1.doStartTag();

            if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${currentOperator}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block20Bytes, _wl_block20);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${currentOperator}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
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
}
