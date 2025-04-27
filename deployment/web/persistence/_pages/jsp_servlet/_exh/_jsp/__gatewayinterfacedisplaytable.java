package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.GatewayServiceBO;
import java.util.ArrayList;
import java.util.List;
import java.util.*;
import com.ehis.util.*;

public final class __gatewayinterfacedisplaytable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/GatewayInterfaceDisplayTable.jsp", 1733051335716L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<HEAD>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\'\n\ttype=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/Gatewayinterface.css\'\n\ttype=\'text/css\'></link>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script type=\"text/javascript\" language=\"JAVASCRIPT\"\n\tsrc=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/eCommon/js/jquery-3.6.3.js\"></script>\n<script type=\"text/javascript\" language=\"JAVASCRIPT\"\n\tsrc=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="/eXH/js/GatewayInterfaceMonitor.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'JavaScript\' src=\'../../eCommon/js/common.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\n\n<style type=\"text/css\">\n.COLUMNHEADER {\n\tBACKGROUND-COLOR: #83AAB4;\n\tCOLOR: white;\n\tFONT-SIZE: 8pt;\n\tfont-weight: bolder;\n}\n\n#mytable {\n\twidth: 100%;\n\toverflow: scroll;\n}\n\n#bottomtabletr {\n\tfont-size: 0.8em;\n}\n\n.QRYEVEN {\n\tBACKGROUND-COLOR: #FFFFFF;\n\tFONT-SIZE: 8pt;\n\tBORDER-STYLE: SOLID;\n\tborder-left-color: #D5E2E5;\n\tborder-right-color: #D5E2E5;\n\tborder-top-color: #D5E2E5;\n\tborder-bottom-color: #D5E2E5;\n\theight: 14;\n\ttext-align: LEFT;\n}\n\n.QRYODD {\n\tFONT-SIZE: 9pt;\n\tBACKGROUND-COLOR: #FFFFFF;\n\tBORDER-STYLE: SOLID;\n\tborder-left-color: #D5E2E5;\n\tborder-right-color: #D5E2E5;\n\tborder-top-color: #D5E2E5;\n\tborder-bottom-color: #D5E2E5;\n\theight: 18;\n\ttext-align: LEFT;\n}\n\n.FIELDS { /*background-color:#FFFFFF;*/\n\tbackground-color: #FFFFFF;\n\tCOLOR: #000000;\n\tFONT-SIZE: 8pt;\n\tTEXT-ALIGN: LEFT\n}\n\n.divstyle {\n\tborder: 5px gray solid;\n}\n</style>\n\n<script type=\"text/javascript\">\n\tfunction refreshNow() {\n\t\tvar querystring = document.getElementById(\"queryString\").value;\n\t\tlocation.href = \"../servlet/eXH.CentralizedServlet?\" + querystring;\n\n\t}\n\n\tfunction quitNow() {\n\t\twindow.close();\n\t}\n\n\tfunction after5secs() {\n\t\tvar querystring = document.getElementById(\"queryString\").value;\n\n\t\tif (document.getElementById(\"refreshtime\").value == \"After 5 seconds\") {\n\t\t\tsetInterval(function() {\n\t\t\t\tlocation.href = \"../servlet/eXH.CentralizedServlet?\"\n\t\t\t\t\t\t+ querystring;\n\t\t\t}, 5000);\n\n\t\t} else if (document.getElementById(\"refreshtime\").value == \"Refresh Now\") {\n\t\t\tlocation.href = \"../servlet/eXH.CentralizedServlet?\" + querystring;\n}\n}\n\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\n</head>\n\n<BODY style=\"margin-top: 0px; padding-top: 0px;\" onload=\"after5secs();\">\n\t<form name=\"gatewayserverTableform\" id=\"gatewayserverTableform\" id=\"gatewayserverTableform\">\n\n\t\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=1 width=\'100%\'>\n\t\t\t<tr align=\"right\">\n\t\t\t\t<TD><select id=\"refreshtime\" name=\"refreshtime\" id=\"refreshtime\"\n\t\t\t\t\tstyle=\"background-color: #FFFFFF; color: #000000; font-size: 8pt; text-align: LEFT; width: 200px;\"\n\t\t\t\t\tonchange=\"after5secs();\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t<option style=\"font-size: 6pt;\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t</select> <input type=\"button\" TITLE=\"Refresh\" value=\'Refresh\'\n\t\t\t\t\tstyle=\"height: 20px; font-family: verdana; COLOR: #000000; FONT-SIZE: 8pt;\"\n\t\t\t\t\tonclick=\"refreshNow();\"> <input\n\t\t\t\t\tstyle=\"height: 20px; font-family: verdana; COLOR: #000000; FONT-SIZE: 8pt;\"\n\t\t\t\t\ttype=\"button\" TITLE=\"Quit\" value=\'Quit\' onclick=\"quitNow();\"></TD>\n\n\t\t\t</tr>\n\t\t</table>\n\n\n\t\t<div style=\"display:block; border: medium; overflow-y:scroll;overflow-x:no;\" >\n\t\t\t<table id=\"mytable\" cellspacing=0 cellpadding=0 border=1\n\t\t\t\tstyle=\"margin-top: 0px; padding-top: 0px;\" width=\'100%\'>\n\t\t\t\t<thead style=\"text-align: left; font-size: 10pt;\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>&nbsp;&nbsp;$&nbsp;&nbsp;</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>&nbsp;&nbsp;#&nbsp;&nbsp;</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Process</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Gateway Server</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Application</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Gateway</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Retries</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Last Comm Time</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Last Msg Id</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Total Messages</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Communication Type</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Start Date Time</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>Started By</th>\n\t\t\t\t\t\t<th nowrap class=\'COLUMNHEADER\'>End Date Time</th>\n\t\t\t\t\t</tr>\n\t\t\t\t</thead>\n\t\t\t\t<tbody>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<input type=\"hidden\" id=\"gatewayserverID\" name=\"gatewayserverID\" id=\"gatewayserverID\">\n\t\t\t\t\t\t\t<td align=\"center\"><img\n\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\"\n\t\t\t\t\t\t\t\talign=\"middle\" height=10\n\t\t\t\t\t\t\t\tonclick=\"document.getElementById(\'gatewayserverID\').value=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =";showModal();\">\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td align=\"center\"><img\n\t\t\t\t\t\t\t\tsrc=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"\n\t\t\t\t\t\t\t\talign=\"middle\" height=10></td>\n\t\t\t\t\t\t\t<td nowrap class=\'QRYEVEN\'>&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t<td nowrap class=\'QRYEVEN\'>&nbsp;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t</tbody>\n\t\t\t</table>\n\t\t</div>\n\n\t\t<input type=\"hidden\" name=\"frame\" id=\"frame\" value=\"body\"> <input type=\"hidden\" name=\"isQueryOnly\" id=\"isQueryOnly\" value=\"true\"> <input type=\"hidden\" id=\"queryString\" name=\"queryString\" id=\"queryString\"\n\t\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\n\t</form>\n</BODY>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String locale = ((String) session.getAttribute("LOCALE"));
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null) ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
	System.out.println("sstyle value....." + sStyle);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Map<Integer, GatewayServiceBO> boundMap = null;
	String selectedCommunimode = null;
	String clientID = null;
	String applicationID = null;
	String facilityID = null;
	String queryString = null;

	String refreshTimeArray[] = new String[2];

	refreshTimeArray[0] = "After 5 seconds";
	refreshTimeArray[1] = "Refresh Now";

	boundMap = (Map<Integer, GatewayServiceBO>) request
			.getAttribute("boundmap");
	queryString = (String) request.getAttribute("queryString");
	pageContext.setAttribute("boundMap", boundMap);
	pageContext.setAttribute("refreshTimeArray", refreshTimeArray);
	pageContext.setAttribute("queryString", queryString);

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(queryString));
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
        __tag0.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("communicationmode", java.lang.String .class,"var"));
        __tag0.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${refreshTimeArray}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag0;
            __result__tag0 = __tag0.doStartTag();

            if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block11Bytes, _wl_block11);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${communicationmode}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block12Bytes, _wl_block12);

                    if (_jsp__tag1(request, response, pageContext, _activeTag, __tag0))
                     return true;
                    _bw.write(_wl_block13Bytes, _wl_block13);
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, org.apache.taglibs.standard.tag.rt.core.ForEachTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.OutTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.core.OutTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(parent);
        __tag1.setValue(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${communicationmode}",java.lang.Object.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.core.ForEachTag __tag2 = null ;
        int __result__tag2 = 0 ;
        boolean _skipPage__tag2= false;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.core.ForEachTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setVar(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("mapObject", java.lang.String .class,"var"));
        __tag2.setItems(( java.lang.Object ) weblogic.servlet.jsp.ELHelper.evaluate("${boundMap}",java.lang.Object.class,pageContext,_jspx_fnmap));
        try {_activeTag=__tag2;
            __result__tag2 = __tag2.doStartTag();

            if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
                if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
                     throw  new  javax.servlet.jsp.JspTagException("Since tag class org.apache.taglibs.standard.tag.rt.core.ForEachTag does not implement BodyTag, it cannot return BodyTag.EVAL_BODY_BUFFERED");
                }
                do {
                    _bw.write(_wl_block15Bytes, _wl_block15);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.status}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block16Bytes, _wl_block16);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.key}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block17Bytes, _wl_block17);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${pageContext.request.contextPath}",java.lang.String.class,pageContext, null ));
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.commStatus}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block18Bytes, _wl_block18);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.processID}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.clientName}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.applicationName}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.protocolLinkName}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.numOfRetries}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.lastCommDateTime}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.lastMsgId}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.totalMsgs}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.protocolType}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.startDateTime}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.startedBy}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block19Bytes, _wl_block19);
                    out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${mapObject.value.stopDateTime}",java.lang.String.class,pageContext, null ));
                    _bw.write(_wl_block20Bytes, _wl_block20);
                } while (__tag2.doAfterBody()== javax.servlet.jsp.tagext.IterationTag.EVAL_BODY_AGAIN);
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
}
