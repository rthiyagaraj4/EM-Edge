package jsp_servlet._elc._requestforcleaninglinen._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.util.Constants;
import com.iba.framework.core.pojo.web.MessageReader;

public final class __requestforcleaninglinentabsmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/elc/RequestForCleaningLinen/jsp/RequestForCleaningLinenTabsMain.jsp", 1709118357682L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block11 ="\n\n<html>\n\t<head>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="/dwrlc/engine.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/dwrlc/util.js\'></script>\n\t\t<script src=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="/eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="/dwrlc/interface/RequestForCleaning.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="/framework/js/Ajax_DWR.js\'></script>\n\t<script type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="/framework/js/hashtable.js\"></script>\n\t<script  type=\"text/javascript\" src=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="/framework/js/validations.js\"></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="/dwrlc/util.js\'></script>\n\t<script type=\'text/javascript\' src=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="/dwrlc/interface/LinenIssue.js\'></script>\n\t<script type=\"text/javascript\" src=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="/eLC/RequestForCleaningLinen/js/RequestForCleaningLinen.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\n\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n<script>\nif(\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'==\'N\')\n\t{\n\t\t\n\t\tif(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'==\'Y\')\n\t\t\t{\n\t\t\t\t\n\t\t\t   alert(\"You are not authorised to use the function\")\n\t\t\t   parent.parent.parent.frames[1].expand(this);\n\t\t\t   parent.parent.parent.frames[2].location.href = contextPath +\"/eCommon/jsp/maindisplay.jsp\";\n\t\t\t\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t\n\t}\n\t</script>\n\t</head>\n<body onload=\"checkUser()\" OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<table border=0 width=\'100%\'cellspacing=0 cellpadding=0>\n<tr height=\'500\'>\n<td> \n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \n<iframe frameborder=0 scrolling=auto src=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="/RequestForCleaningLinenAction.do?vo.viewCode=placeCleanLinenRequestFrame&method=1&";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" name=\"placeCleanLinenRequestFrame\" width=\"100%\" height=\"100%\" >\n</iframe> \n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" \n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="/eLC/RequestForCleaningLinen/jsp/RequestForCleaningLinenFrames.jsp?vo.viewCode=cleaningRequestsListTab&method=1&";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" name=\"requestsListFrame\" width=\"100%\" height=\"100%\">\n</iframe> \n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="  \n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n<iframe frameborder=0 scrolling=no\tsrc=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="/eLC/RequestForCleaningLinen/jsp/PendingCountFrames.jsp?vo.viewCode=pendingCountTab&method=1&";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" name=\"pendingCountFrame\" width=\"100%\" height=\"100%\">\n</iframe> \n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" \n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" \n</td>\n\n</tr> \n</table>\n<input type=\"hidden\" name=\"facilityId\" id=\"facilityId\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"/>\n<input type=\"hidden\" name=\"loggedInUser\" id=\"loggedInUser\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\"/>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block21Bytes, _wl_block21);
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
            _bw.write(_wl_block22Bytes, _wl_block22);

			String facilityId=(String)session.getAttribute("facility_id");
			String loggedInUser = (String) session.getAttribute("login_user");
			String flag=(String) request.getParameter("flag");
			String dirtyFlag=(String) request.getParameter("dirtyFlag");
			String userFlag=(String) request.getParameter("userFlag");
			String cutoffTime=(String)request.getParameter("cutoffTime");
			String delParamDate=(String)request.getParameter("delParamDate");
			String scheduleDate=(String)request.getParameter("scheduleDate");
			String reqDate=(String)request.getParameter("requestDate");
			String functionId = (String) request.getParameter("vo.functionId");
			String moduleId = (String) request.getParameter("vo.moduleId");
			//out.println(functionId+" "+moduleId);
			Cookie[] cookies = request.getCookies();
			if (cookies != null) {
				for (int i = 0; i < cookies.length; i++) {
					if (cookies[i].getName().indexOf("org.ditchnet.jsp.tabs") != -1) {
						cookies[i].setValue("");
					}
				}
			}

		MessageReader mr=new MessageReader();
		pageContext.setAttribute("placeCleanLinenRequest",mr.getMessage(request,"com.iba.ehis.lc.placeCleanLinenRequest"));
		pageContext.setAttribute("cleaningRequestsList",mr.getMessage(request,"com.iba.ehis.lc.cleaningRequestsList"));
		pageContext.setAttribute("pendingCountConfirmation",mr.getMessage(request,"com.iba.ehis.lc.pendingCountConfirmation"));
		pageContext.setAttribute("rootDir",request.getContextPath(),PageContext.PAGE_SCOPE);
		
		pageContext.setAttribute("queryString", request.getQueryString());
	
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dirtyFlag));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(userFlag));
            _bw.write(_wl_block25Bytes, _wl_block25);
             org.ditchnet.jsp.taglib.tabs.handler.TabContainerTag __tag1 = null ;
            int __result__tag1 = 0 ;

            if (__tag1 == null ){
                __tag1 = new  org.ditchnet.jsp.taglib.tabs.handler.TabContainerTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
            }
            __tag1.setJspContext(pageContext);

            __tag1.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("RequestForCleaningLinenTabs", java.lang.String .class,"id"));
            __tag1.setSelectedTabPaneId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("requestForCleaningLinenTab", java.lang.String .class,"selectedTabPaneId"));
            _activeTag=__tag1;
             javax.servlet.jsp.tagext.JspFragment _jspx_frag0 = new JspFragmentHelper(0, pageContext, _activeTag);
            __tag1.setJspBody(_jspx_frag0);
            __tag1.doTag();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(loggedInUser));
            _bw.write(_wl_block40Bytes, _wl_block40);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
             org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag __tag2 = null ;
            int __result__tag2 = 0 ;

            if (__tag2 == null ){
                __tag2 = new  org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
            }
            __tag2.setJspContext(pageContext);
            __tag2.setParent(parent);
            __tag2.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("placeCleaningLinenRequestTab", java.lang.String .class,"id"));
            __tag2.setTabTitle(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${placeCleanLinenRequest}",java.lang.String.class,pageContext,_jspx_fnmap));
            _activeTag=__tag2;
             javax.servlet.jsp.tagext.JspFragment _jspx_frag1 = new JspFragmentHelper(1, pageContext, _activeTag);
            __tag2.setJspBody(_jspx_frag1);
            __tag2.doTag();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
            _bw.write(_wl_block29Bytes, _wl_block29);
             org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag __tag3 = null ;
            int __result__tag3 = 0 ;

            if (__tag3 == null ){
                __tag3 = new  org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
            }
            __tag3.setJspContext(pageContext);
            __tag3.setParent(parent);
            __tag3.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("cleaningRequestsListTab", java.lang.String .class,"id"));
            __tag3.setTabTitle(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${cleaningRequestsList}",java.lang.String.class,pageContext,_jspx_fnmap));
            _activeTag=__tag3;
             javax.servlet.jsp.tagext.JspFragment _jspx_frag2 = new JspFragmentHelper(2, pageContext, _activeTag);
            __tag3.setJspBody(_jspx_frag2);
            __tag3.doTag();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
            _bw.write(_wl_block32Bytes, _wl_block32);
             org.apache.struts.taglib.logic.EqualTag __tag4 = null ;
            int __result__tag4 = 0 ;

            if (__tag4 == null ){
                __tag4 = new  org.apache.struts.taglib.logic.EqualTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
            }
            __tag4.setPageContext(pageContext);
            __tag4.setParent( new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag)parent));
            __tag4.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
            __tag4.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
            __tag4.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("flag", java.lang.String .class,"parameter"));
            _activeTag=__tag4;
            __result__tag4 = __tag4.doStartTag();

            if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block33Bytes, _wl_block33);
                     org.apache.struts.taglib.logic.EqualTag __tag5 = null ;
                    int __result__tag5 = 0 ;

                    if (__tag5 == null ){
                        __tag5 = new  org.apache.struts.taglib.logic.EqualTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
                    }
                    __tag5.setPageContext(pageContext);
                    __tag5.setParent(__tag4);
                    __tag5.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("N", java.lang.String .class,"value"));
                    __tag5.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
                    __tag5.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"parameter"));
                    _activeTag=__tag5;
                    __result__tag5 = __tag5.doStartTag();

                    if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block33Bytes, _wl_block33);
                             org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag __tag6 = null ;
                            int __result__tag6 = 0 ;

                            if (__tag6 == null ){
                                __tag6 = new  org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
                            }
                            __tag6.setJspContext(pageContext);
                            __tag6.setParent(__tag5);
                            __tag6.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("pendingCountTab", java.lang.String .class,"id"));
                            __tag6.setTabTitle(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pendingCountConfirmation}",java.lang.String.class,pageContext,_jspx_fnmap));
                            _activeTag=__tag6;
                             javax.servlet.jsp.tagext.JspFragment _jspx_frag3 = new JspFragmentHelper(3, pageContext, _activeTag);
                            __tag6.setJspBody(_jspx_frag3);
                            __tag6.doTag();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
                            _bw.write(_wl_block1Bytes, _wl_block1);
                        } while (__tag5.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                    }
                    if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                        _activeTag = null;
                        _releaseTags(pageContext, __tag5);
                        return;
                    }
                    _activeTag=__tag5.getParent();
                    weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
                    __tag5.release();
                    _bw.write(_wl_block37Bytes, _wl_block37);
                } while (__tag4.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag4);
                return;
            }
            _activeTag=__tag4.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
            __tag4.release();
            _bw.write(_wl_block37Bytes, _wl_block37);
             org.apache.struts.taglib.logic.EqualTag __tag7 = null ;
            int __result__tag7 = 0 ;

            if (__tag7 == null ){
                __tag7 = new  org.apache.struts.taglib.logic.EqualTag ();
                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
            }
            __tag7.setPageContext(pageContext);
            __tag7.setParent( new javax.servlet.jsp.tagext.TagAdapter((javax.servlet.jsp.tagext.SimpleTag)parent));
            __tag7.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
            __tag7.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
            __tag7.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("userFlag", java.lang.String .class,"parameter"));
            _activeTag=__tag7;
            __result__tag7 = __tag7.doStartTag();

            if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block33Bytes, _wl_block33);
                     org.apache.struts.taglib.logic.EqualTag __tag8 = null ;
                    int __result__tag8 = 0 ;

                    if (__tag8 == null ){
                        __tag8 = new  org.apache.struts.taglib.logic.EqualTag ();
                        weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
                    }
                    __tag8.setPageContext(pageContext);
                    __tag8.setParent(__tag7);
                    __tag8.setValue(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Y", java.lang.String .class,"value"));
                    __tag8.setScope(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("request", java.lang.String .class,"scope"));
                    __tag8.setParameter(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("flag", java.lang.String .class,"parameter"));
                    _activeTag=__tag8;
                    __result__tag8 = __tag8.doStartTag();

                    if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                        if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                             throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.struts.taglib.logic.EqualTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                        }
                        do {
                            _bw.write(_wl_block33Bytes, _wl_block33);
                             org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag __tag9 = null ;
                            int __result__tag9 = 0 ;

                            if (__tag9 == null ){
                                __tag9 = new  org.ditchnet.jsp.taglib.tabs.handler.TabPaneTag ();
                                weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
                            }
                            __tag9.setJspContext(pageContext);
                            __tag9.setParent(__tag8);
                            __tag9.setId(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("pendingCountTab", java.lang.String .class,"id"));
                            __tag9.setTabTitle(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pendingCountConfirmation}",java.lang.String.class,pageContext,_jspx_fnmap));
                            _activeTag=__tag9;
                             javax.servlet.jsp.tagext.JspFragment _jspx_frag4 = new JspFragmentHelper(4, pageContext, _activeTag);
                            __tag9.setJspBody(_jspx_frag4);
                            __tag9.doTag();
                            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
                            _bw.write(_wl_block1Bytes, _wl_block1);
                        } while (__tag8.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
                    }
                    if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                        _activeTag = null;
                        _releaseTags(pageContext, __tag8);
                        return;
                    }
                    _activeTag=__tag8.getParent();
                    weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
                    __tag8.release();
                    _bw.write(_wl_block37Bytes, _wl_block37);
                } while (__tag7.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
            }
            if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
                _activeTag = null;
                _releaseTags(pageContext, __tag7);
                return;
            }
            _activeTag=__tag7.getParent();
            weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
            __tag7.release();
            _bw.write(_wl_block37Bytes, _wl_block37);
        }public void invoke1(javax.servlet.jsp.JspWriter out) throws java.lang.Throwable {
            weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${rootDir}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${queryString}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block28Bytes, _wl_block28);
        }public void invoke2(javax.servlet.jsp.JspWriter out) throws java.lang.Throwable {
            weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${rootDir}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${queryString}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block31Bytes, _wl_block31);
        }public void invoke3(javax.servlet.jsp.JspWriter out) throws java.lang.Throwable {
            weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${rootDir}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${queryString}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);
        }public void invoke4(javax.servlet.jsp.JspWriter out) throws java.lang.Throwable {
            weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${rootDir}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${queryString}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block36Bytes, _wl_block36);
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
                    case 3:
                    invoke3(out);
                    break;
                    case 4:
                    invoke4(out);
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
