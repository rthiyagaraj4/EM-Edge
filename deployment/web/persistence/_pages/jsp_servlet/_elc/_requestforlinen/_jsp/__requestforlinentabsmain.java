package jsp_servlet._elc._requestforlinen._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.iba.framework.core.pojo.web.MessageReader;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.Constants;

public final class __requestforlinentabsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/RequestForLinen/jsp/RequestForLinenTabsMain.jsp", 1709118358604L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\">\n";
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

    private final static java.lang.String  _wl_block11 ="\n<html>\n\t<head>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/dwrlc/engine.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/dwrlc/util.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/framework/js/Ajax_DWR.js\'></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/framework/js/hashtable.js\"></script>\n\t<script  type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/framework/js/validations.js\"></script>\n\t<script src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t</head>\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<table border=0 width=\'100%\'align=\"center\"><tr height=\'500\'><td>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t<iframe frameborder=0 scrolling=auto\tsrc=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="/RequestForLinenAction.do?vo.viewCode=placeLinenRequestFrame&method=1&vo.functionId=LC_REQ_FOR_LINEN\" \n\t\t\t\twidth=\"100%\" height=\"100%\" name=\"placeLinenRequestFrame\"></iframe>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<iframe frameborder=0 scrolling=auto\tsrc=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="/eLC/RequestForLinen/jsp/RequestForLinenFrames.jsp?vo.viewCode=requestsListFrame&method=1&vo.functionId=LC_REQ_FOR_LINEN\"\n\t\t\t name=\"requestsListFrame\" width=\"100%\" height=\"100%\"></iframe>\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td></tr>\n\t</table>\t\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block17Bytes, _wl_block17);
             org.ditchnet.jsp.taglib.tabs.handler.TabConfigTag __tag0 = null ;
            int __result__tag0 = 0 ;

            if (__tag0 == null ){
                __tag0 = new  org.ditchnet.jsp.taglib.tabs.handler.TabConfigTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
            }
            __tag0.setJspContext(pageContext);

            _activeTag=__tag0;
            __tag0.doTag();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
            _bw.write(_wl_block18Bytes, _wl_block18);

		String facilityId=(String)session.getAttribute("facility_id");	
		pageContext.setAttribute("values", request.getQueryString());
		Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().indexOf("org.ditchnet.jsp.tabs") != -1) {
						cookies[i].setValue("");
					}
				}
			}

			MessageReader mr=new MessageReader();

			pageContext.setAttribute("RequestList",mr.getMessage(request,"com.iba.ehis.lc.requestForLinen.requestList"));
			pageContext.setAttribute("PlaceLinenRequest",mr.getMessage(request,"com.iba.ehis.lc.requestForLinen.placeLinenRequest"));
			pageContext.setAttribute("rootDir",request.getContextPath(),PageContext.PAGE_SCOPE);

		
            _bw.write(_wl_block19Bytes, _wl_block19);
             org.ditchnet.jsp.taglib.tabs.handler.TabContainerTag __tag1 = null ;
            int __result__tag1 = 0 ;

            if (__tag1 == null ){
                __tag1 = new  org.ditchnet.jsp.taglib.tabs.handler.TabContainerTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
            }
            __tag1.setJspContext(pageContext);

            __tag1.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("RequestForLinenTabs", java.lang.String .class,"id"));
            __tag1.setSelectedTabPaneId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("requestForLinenTab", java.lang.String .class,"selectedTabPaneId"));
            _activeTag=__tag1;
             javax.servlet.jsp.tagext.JspFragment _jspx_frag0 = new JspFragmentHelper(0, pageContext, _activeTag);
            __tag1.setJspBody(_jspx_frag0);
            __tag1.doTag();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
    private class JspFragmentHelper extends javax.servlet.jsp.tagext.JspFragment {

        private javax.servlet.jsp.tagext.JspTag parent;
        private javax.servlet.jsp.tagext.JspTag _activeTag;
        private int discriminator;
        private javax.servlet.jsp.JspContext jspContext;
        private javax.servlet.jsp.PageContext pageContext;
        private javax.servlet.ServletResponse response;
        private javax.servlet.ServletRequest request;
        public JspFragmentHelper(int discriminator, javax.servlet.jsp.JspContext jspContext, javax.servlet.jsp.tagext.JspTag parent) {
            this.discriminator = discriminator;
            this.jspContext = jspContext;
            this.pageContext = null;
            if(jspContext instanceof javax.servlet.jsp.PageContext) {
                this.pageContext = (javax.servlet.jsp.PageContext)jspContext;
                request=this.pageContext.getRequest();
                response = this.pageContext.getResponse();
            }
            this.parent = parent;
        }

        public javax.servlet.jsp.JspContext getJspContext() {
            return jspContext;
        }

        public javax.servlet.jsp.tagext.JspTag getParentTag() {
            return parent;
        }
        public void invoke0(javax.servlet.jsp.JspWriter out) throws java.lang.Throwable {
            weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
            _bw.write(_wl_block20Bytes, _wl_block20);
             org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag __tag2 = null ;
            int __result__tag2 = 0 ;

            if (__tag2 == null ){
                __tag2 = new  org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
            }
            __tag2.setJspContext(pageContext);
            __tag2.setParent(parent);
            __tag2.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("PlaceLinenRequestTab", java.lang.String .class,"id"));
            __tag2.setTabTitle(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${PlaceLinenRequest}",java.lang.String.class,pageContext,_jspx_fnmap));
            _activeTag=__tag2;
             javax.servlet.jsp.tagext.JspFragment _jspx_frag1 = new JspFragmentHelper(1, pageContext, _activeTag);
            __tag2.setJspBody(_jspx_frag1);
            __tag2.doTag();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
            _bw.write(_wl_block23Bytes, _wl_block23);
             org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag __tag3 = null ;
            int __result__tag3 = 0 ;

            if (__tag3 == null ){
                __tag3 = new  org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
            }
            __tag3.setJspContext(pageContext);
            __tag3.setParent(parent);
            __tag3.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("RequestsListTab", java.lang.String .class,"id"));
            __tag3.setTabTitle(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${RequestList}",java.lang.String.class,pageContext,_jspx_fnmap));
            _activeTag=__tag3;
             javax.servlet.jsp.tagext.JspFragment _jspx_frag2 = new JspFragmentHelper(2, pageContext, _activeTag);
            __tag3.setJspBody(_jspx_frag2);
            __tag3.doTag();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
            _bw.write(_wl_block18Bytes, _wl_block18);
        }public void invoke1(javax.servlet.jsp.JspWriter out) throws java.lang.Throwable {
            weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${rootDir}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block22Bytes, _wl_block22);
        }public void invoke2(javax.servlet.jsp.JspWriter out) throws java.lang.Throwable {
            weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${rootDir}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block25Bytes, _wl_block25);
        }public void invoke(java.io.Writer writer) throws javax.servlet.jsp.JspException {
            javax.servlet.jsp.JspWriter out = null; 
            if (writer != null) {
                out = jspContext.pushBody(writer);
            } else {
                out = jspContext.getOut();
            }
            try {
                switch(discriminator) {
                    case 0:
                    invoke0(out);
                    break;
                    case 1:
                    invoke1(out);
                    break;
                    case 2:
                    invoke2(out);
                    break;
                }
            }
            catch (java.lang.Throwable e) {
                if (e instanceof javax.servlet.jsp.SkipPageException) throw (javax.servlet.jsp.SkipPageException) e;
                throw new javax.servlet.jsp.JspException(e);
            }
            finally {
                if (writer!=null) {
                     jspContext.popBody();
                }
            }
        }
    }
}
