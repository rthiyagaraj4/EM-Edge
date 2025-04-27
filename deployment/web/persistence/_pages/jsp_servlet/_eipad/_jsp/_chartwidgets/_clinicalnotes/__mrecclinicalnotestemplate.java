package jsp_servlet._eipad._jsp._chartwidgets._clinicalnotes;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __mrecclinicalnotestemplate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesTemplate.jsp", 1738426277120L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n\n \n<!-- <html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=utf-8\" />\n<title>Sample Page</title>\n<link rel=\"stylesheet\" href=\"kendo.common.min.css\" />\n    <link rel=\"stylesheet\" href=\"kendo.default.min.css\" />\n    <script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n    <script src=\"kendo.all.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body class=\"mbody\">   -->\n\n<form id=\"CNSectionTemplateForm\" name=\"CNSectionTemplateForm\" id=\"CNSectionTemplateForm\" method=\"post\" action=\"\" class=\"mform row\">                               \n\t<div id=\"NoteSectBodyWrapper\" style=\"position: absolute;z-index: 1;width: 100%;height: 100%;overflow: hidden;\">\n\t   <div style=\"position: absolute;z-index: 1;width: 100%;\">\n\t      ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t      ";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<div style=\"position: absolute;z-index: 1;width: 100%; padding-top: 20px; text-align:center; color:#a3a3a3;\">\n\t\t \tEmpty section template configured. No fields available to display\n\t\t \t</div> \n\t      ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t   </div>\n\t</div>\n\t<input type=\"hidden\" id=\"section_code\" name=\"section_code\" id=\"section_code\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"/>      \n\t<input type=\"hidden\" id=\"child_section_code\" name=\"child_section_code\" id=\"child_section_code\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"/>    \n\t<input type=\"hidden\" id=\"child_section_type\" name=\"child_section_type\" id=\"child_section_type\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\"/>                    \n</form>\n\n<script>\n\ndocument.addEventListener(\'touchmove\', function (e) { e.preventDefault(); }, false);\n\nvar clinicalNotesSectBodyScroll;\nfunction assignclinicalNotesSectBodyScroll() {\n\tclinicalNotesSectBodyScroll = new IScroll(\'#NoteSectBodyWrapper\', { \n\t\tscrollX: true, \n\t\tscrollY: true, \n\t\tscrollbars: true,\n\t\tinteractiveScrollbars: true,\n\t\tclick: false,\n\t\tuseTransition: false,\n\t\tbindToWrapper: true,\n\t\tpreventDefaultException: {tagName:/.*/},\n\t\tonBeforeScrollStart: function (e) {\nvar target = e.target;\nwhile (target.nodeType != 1) target = target.parentNode;\nif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\')\ne.preventDefault();\t\t\n\t}});\n\tclinicalNotesSectBodyScroll.refresh();\n}\nvar clinicalNotesMatrixScroll;\nfunction assignMatrixScroll(){\n  var getMatID;\n\n  $(\"table[data-matrix]\").each( function (index, value) {\n\n\t    getMatID =$(this).attr(\'data-matrix\');\t\n\t     \n\n\t    clinicalNotesMatrixScroll = new IScroll(\"#\"+getMatID, { \n\t   \tscrollX: true, \n\t   \tscrollbars: false,\n\t   \tinteractiveScrollbars: true,\n\t   \tclick: true,\n\t   \tuseTransition: false,\n\t   \tbindToWrapper: true\n\t   });\n\n  });\n\n}\n\n\n\nvar clinicalNotesGridScroll;\nfunction assignGridScroll(){\n \n  $(\"div[id~=\'gridScroll\']\").each(function (i, el) {\n         var gridID = $(this).find(\"table\").attr(\"id\");\n\t     console.log(\"gridID::\", gridID);\n\t\n\t\tclinicalNotesGridScroll = new IScroll(\"#\"+gridID, { \n\t   \t  scrollX: true, \n\t   \t  scrollbars: false,\n\t   \t  interactiveScrollbars: true,\n\t   \t  click: true,\n\t   \t  useTransition: false,\n\t   \t  bindToWrapper: true,\n\t\t  preventDefaultException: {tagName:/.*/},\n\t\tonBeforeScrollStart: function (e) {\nvar target = e.target;\nwhile (target.nodeType != 1) target = target.parentNode;\nif (target.tagName != \'SELECT\' && target.tagName != \'INPUT\' && target.tagName != \'TEXTAREA\')\ne.preventDefault();\t\t\n\t}\n\t    });\n\t\t \n\t\t \n     });\n\n  \n  \n\n  \n}\n\n\n\n//To be revisited on later point of time.\n$(document).ready(function(){\n\t\n\tsetTimeout(function(){\n\t\tassignclinicalNotesSectBodyScroll()\n\t},500);\n    \n\tassignMatrixScroll();\n\tassignGridScroll();\n\t\n});\n\t\n\t\n</script>\n               \n\n<!-- </body>\n</html> -->\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();
     static {_jspx_fnmap.mapFunction("fn:escapeXml", org.apache.taglibs.standard.functions.Functions.class, "escapeXml", new Class[]{java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:join", org.apache.taglibs.standard.functions.Functions.class, "join", new Class[]{java.lang.String[].class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:replace", org.apache.taglibs.standard.functions.Functions.class, "replace", new Class[]{java.lang.String.class ,java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:split", org.apache.taglibs.standard.functions.Functions.class, "split", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:toUpperCase", org.apache.taglibs.standard.functions.Functions.class, "toUpperCase", new Class[]{java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:endsWith", org.apache.taglibs.standard.functions.Functions.class, "endsWith", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:length", org.apache.taglibs.standard.functions.Functions.class, "length", new Class[]{java.lang.Object.class });
        _jspx_fnmap.mapFunction("fn:containsIgnoreCase", org.apache.taglibs.standard.functions.Functions.class, "containsIgnoreCase", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:substringAfter", org.apache.taglibs.standard.functions.Functions.class, "substringAfter", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:substringBefore", org.apache.taglibs.standard.functions.Functions.class, "substringBefore", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:indexOf", org.apache.taglibs.standard.functions.Functions.class, "indexOf", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:substring", org.apache.taglibs.standard.functions.Functions.class, "substring", new Class[]{java.lang.String.class ,int.class ,int.class });
        _jspx_fnmap.mapFunction("fn:contains", org.apache.taglibs.standard.functions.Functions.class, "contains", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:startsWith", org.apache.taglibs.standard.functions.Functions.class, "startsWith", new Class[]{java.lang.String.class ,java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:trim", org.apache.taglibs.standard.functions.Functions.class, "trim", new Class[]{java.lang.String.class });
        _jspx_fnmap.mapFunction("fn:toLowerCase", org.apache.taglibs.standard.functions.Functions.class, "toLowerCase", new Class[]{java.lang.String.class });
    }

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
            _bw.write(_wl_block2Bytes, _wl_block2);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

String curr_sec_hdg_code = (request.getParameter("section_code") == null) ? "" : request.getParameter("section_code");
String curr_child_sec_hdg_code = (request.getParameter("child_section_code") == null) ? "" : request.getParameter("child_section_code");
String curr_section_type = (request.getParameter("child_section_type") == null) ? "" : request.getParameter("child_section_type");


            _bw.write(_wl_block3Bytes, _wl_block3);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block4Bytes, _wl_block4);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(curr_sec_hdg_code));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(curr_child_sec_hdg_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(curr_section_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
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
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("path", java.lang.String .class,"var"));
        __tag0.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.Object.class,pageContext,_jspx_fnmap));
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
         org.apache.taglibs.standard.tag.rt.core.ImportTag __tag1 = null ;
        int __result__tag1 = 0 ;
        boolean _skipPage__tag1= false;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.ImportTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setUrl(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("/eIPAD/jsp/xsl/RecClinicalNotesTemplateRecordingView.xsl", java.lang.String .class,"url"));
        __tag1.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("MCN_xsltTemplate", java.lang.String .class,"var"));
        try {_activeTag=__tag1;
            __result__tag1 = __tag1.doStartTag();

            if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.ImportTag __tag2 = null ;
        int __result__tag2 = 0 ;
        boolean _skipPage__tag2= false;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.ImportTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setUrl(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("/eIPAD/jsp/chartwidgets/clinicalnotes/MRecClinicalNotesTemplateXML.jsp?<%=request.getQueryString()%>", java.lang.String .class,"url"));
        __tag2.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("MCN_TemplateXML", java.lang.String .class,"var"));
        try {_activeTag=__tag2;
            __result__tag2 = __tag2.doStartTag();

            if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                }
            }
            if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _skipPage__tag2 = true;
                return true;
            }
            _activeTag=__tag2.getParent();
            _skipPage__tag2 = false;
        } catch (java.lang.Throwable __t){
            __tag2.doCatch(__t);
        } finally {
            __tag2.doFinally();
            if (!_skipPage__tag2){
                weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
                __tag2.release();
            }else{
                _releaseTags(pageContext, __tag2);
            }
        }
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.common.core.ChooseTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.common.core.ChooseTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.common.core.ChooseTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block4Bytes, _wl_block4);

                if (_jsp__tag4(request, response, pageContext, _activeTag, __tag3))
                 return true;
                _bw.write(_wl_block4Bytes, _wl_block4);

                if (_jsp__tag6(request, response, pageContext, _activeTag, __tag3))
                 return true;
                _bw.write(_wl_block4Bytes, _wl_block4);
            } while (__tag3.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.common.core.ChooseTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.WhenTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.core.WhenTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(parent);
        __tag4.setTest(((Boolean) weblogic.servlet.jsp.ELHelper.evaluate("${fn:trim(MCN_TemplateXML) != \'\'}",java.lang.Boolean.class,pageContext,_jspx_fnmap)).booleanValue());
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.WhenTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block5Bytes, _wl_block5);

                if (_jsp__tag5(request, response, pageContext, _activeTag, __tag4))
                 return true;
                _bw.write(_wl_block4Bytes, _wl_block4);
            } while (__tag4.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.WhenTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.xml.TransformTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.xml.TransformTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(parent);
        __tag5.setDoc(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${MCN_TemplateXML}",java.lang.Object.class,pageContext,_jspx_fnmap));
        __tag5.setXslt(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${MCN_xsltTemplate}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.common.core.ChooseTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.common.core.OtherwiseTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.common.core.OtherwiseTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(parent);
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                 throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.common.core.OtherwiseTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
            }
            do {
                _bw.write(_wl_block6Bytes, _wl_block6);
            } while (__tag6.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
