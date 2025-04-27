package jsp_servlet._portal._jsp._result;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import portalrefimpl.PortalHelper;
import java.util.Date;
import java.text.MessageFormat;
import portalrefimpl.result.ResultConstants;
import portalrefimpl.common.CommonConstants;
import portalrefimpl.common.message.MessageContainer;
import portalrefimpl.common.response.ErrorInfo;
import portalrefimpl.result.viewresult.TestResultCache;
import portalrefimpl.result.viewresult.response.TestResult;
import java.util.List;
import portalrefimpl.PortalConstants;
import portalrefimpl.result.viewresult.TestResultCacheManager;

public final class __gettestresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/portal/jsp/result/GetTestResult.jsp", 1669269355937L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n<head>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<meta name=\"keywords\" content=\"\" />\r\n<meta name=\"description\" content=\"\" />\r\n<script src=\"../../js/kendo.all.min.js\"  type=\"text/javascript\"></script>\r\n<script src=\"../../js/ES_Kendo.js\"  type=\"text/javascript\"></script>\r\n<link rel=\"stylesheet\" href=\"../../css/style.css\" type=\"text/css\"/>\r\n<link rel=\"stylesheet\" href=\"../../css/style_ie.css\" type=\"text/css\"/>\r\n<style type=\"text/css\">\r\n#StripSpaceresultpopupdialog\r\n{\r\n\twidth:100%;\r\n\tdisplay:table-cell;\r\n}\r\n\r\n#popupwrapperrspage\r\n{\r\n\twidth:100%;\r\n\theight:358px;\r\n\tbackground-color:#ffffff;\r\n\t\r\n}\r\n\r\n#popupmsgboxresultpage\r\n{\r\n\twidth:100%;\r\n\theight:331px;\r\n\tbackground-color:#ffffff;\r\n\tdisplay:table;\r\n\tposition:relative;\r\n}\r\n\r\n#resultpopupdisplaypage\r\n{\r\n\theight:299px;\r\n\tposition:relative;\r\n\toverflow:auto;\r\n}\r\n\r\n</style>\r\n</head>\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n\r\n<div style=\"height:100%;width:100%;\">\r\n\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<span class=\"loginerror\">\r\n  ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n</span>\t\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t<span class=\"loginerror\">\r\n\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t</span>\r\n\r\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t</span>\r\n\t\t\t\r\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t\t<!-- Stripicon-->\r\n\t\t<div id=\"stripboxwithresult\">\r\n\t\t\t<div class=\"row\">\r\n\t\t        <div id=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\r\n\t\t           <div id=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\r\n\t\t\t\t\t<div id=\"resultpageheader\">\r\n\t\t\t\t\t<div class=\"row\">\r\n\t\t\r\n\t\t\t\t\t\t<div class=\"cell alignmiddle datacellresult\"> \r\n\t\t\t\t\t\t\t<span class=\"contenboldwhite\">Results</span>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t\t\t<div class=\"cell alignright datacellresults\" > \r\n\t\t\t\t\t\t\t<a onclick=\"showResultPopup(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\',\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\"><img src=\"../../images/maxi.png\"/></a>\r\n\t\t\t\t\t\t\t<!-- <a href=\"#\" onclick=\"showResultPopup()\"><img src=\"../../images/maxi.png\"/></a> -->\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\r\n\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t<!--  from here the results are to be shown -->\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t<div id=\"resultheaderpoppage\">\r\n\t\t\t\t\t\t\t\t<div class=\"row\">\r\n\t\t\t\t\t\t\t\t\t<div class=\"cell alignmiddle datacell\" > \r\n\t\t\t\t\t\t\t\t\t\t<span class=\"contenboldsetmargin\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<div class=\"cell alignmiddle datecell\">\r\n\t\t\t\t\t\t\t\t\t\t<span class=\"contenbold\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" at ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span> \r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"row\" style=\"width:100%;\">\r\n\t\t\t\t\t\t\t\t<div class=\"cell alignmiddle\" style=\"width:100%;\"> \r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\r\n\t\t\t\t\t\t\t\t\t<div  class=\"contennormalsetmargin\">\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n\t\t\t\t\t\t\t\t\t<!--  need to put horizontal line -->\r\n\t\t\t\t\t\t\t\t\t<div style=\"width:98%;height:1px;margin-top:5px;margin-left:5px;margin-right: 5px;margin-bottom:5px;background-color: #333333;\">\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<div  class=\"contennormalsetmargin\">\r\n\t\t\t\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\" >\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t\t\t\t\t\t\t\t\t<img class=\"imageresult\" src=\"../../images/";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\r\n\t\t\t\t\t\t\t\t\t\t<!-- display the result num -->\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\r\n\t\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\r\n\t\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\r\n\t\t\t\t\t\t\t\t\t\t(";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =" - ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =")\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\r\n\t\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\r\n\t\t\t\t\t\t\t\t\t<!--  horizontal line -->\r\n\t\t\t\t\t\t\t\t\t<div style=\"width:98%;height:1px;margin-top:5px;margin-left:5px;margin-right: 5px;margin-bottom:5px;background-color: #333333;\">\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t<div class=\"resultpanel\">\r\n\t\t\t\t\t\t\t\t\t\t<p><span class=\"resultnote\">\r\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\r\n\t\t\t\t\t\t\t\t\t\t</span></p>\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t\t<!-- now the chart -->\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\r\n\t\t\t\t\t\t   \t\t\t<!--  horizontal line -->\r\n\t\t\t\t\t\t\t\t\t<div style=\"width:98%;height:1px;margin-top:5px;margin-left:5px;margin-right: 5px;margin-bottom:5px;background-color: #333333;\">\r\n\t\t\t\t\t\t\t\t\t</div>\r\n\t   \t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\r\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\r\n\t\t\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\r\n\t\t\t\t\t</div>\r\n\t\t\t\t\t\r\n\t\t\t\t\t\r\n\t\t\t\t\t<div class=\"resultindicatorpage\" >\r\n\t\t\t\t\t\t<div class=\"row\" >\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\"  >\r\n\t\t\t\t\t\t\t\t<img class=\"imageresult\" src=\"../../images/highval.png\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle\" >\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">High value</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\" >\r\n\t\t\t\t\t\t\t\t<img class=\"imageresult\"  src=\"../../images/lowval.png\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle\" >\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">Low value</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\" >\r\n\t\t\t\t\t\t\t\t<img class=\"imageresult\" src=\"../../images/abnormal.png\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle\" >\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">Abnormal value</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\" >\r\n\t\t\t\t\t\t\t\t<img class=\"imageresult\" src=\"../../images/critical.png\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle \" >\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">Critical value</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\" >\r\n\t\t\t\t\t\t\t\t<img class=\"imageresult\"src=\"../../images/criticalhigh.png\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle\" >\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">Critical high value</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\" >\r\n\t\t\t\t\t\t\t\t<img class=\"imageresult\" src=\"../../images/criticallow.png\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle\" >\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">Critical low value</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle resultcellicon\" >\r\n\t\t\t\t\t\t\t\t<img class=\"imageresult\" src=\"../../images/normal.png\"/>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t\t<div class=\"cellindex alignmiddle\" >\r\n\t\t\t\t\t\t\t\t<span class=\"contentnormal\">Normal</span>\r\n\t\t\t\t\t\t\t</div>\r\n\t\t\t\t\t\t</div>\r\n\t\t\t\t\t</div>\r\n\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n      \t</div>\r\n      </div>\r\n    </div>  \t\r\n   ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\t\r\n      \t\r\n\t</div>\r\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String patientId = "";
	patientId = (String) session
			.getAttribute(PortalConstants.PATIENTID_REQUEST_PARAM_KEY);
	//patientId = request.getParameter("patientId");
	if (patientId == null) {
		patientId = (String) getServletConfig().getServletContext()
				.getAttribute("patientId");
		if (patientId == null) {
			patientId = "";
		}
	}
	
	String orderId = request.getParameter("orderId");
	if(orderId == null){
		orderId = "";
	}
	
	String order = "";
	order = request
			.getParameter(ResultConstants.TESTRESULT_ORDER_REQUEST_PARAM_KEY);
	if (order == null) {
		order = "";
	}
	
	String resultType = "";
	resultType = request
			.getParameter(ResultConstants.TESTRESULT_RESULTTYPE_REQUEST_PARAM_KEY);
	if (resultType == null) {
		resultType = "";
	}
	
	String orderDate = request
			.getParameter(ResultConstants.TESTRESULT_ORDERDATE_REQUEST_PARAM_KEY);
	if(orderDate == null){
		orderDate = "";
	}
	
	String counterStr = request.getParameter("counter");
	int counterVal = PortalHelper.getIntegerValue(counterStr, 0);
	
	String popup = request.getParameter("popup");
	if(popup == null || popup.trim().equals("")){
		popup = "N";
	}
	
	TestResultCacheManager cacheMgr = TestResultCacheManager.getInstance();
	TestResultCache testResultCache = cacheMgr.getTestResultsForPatient(patientId, orderId);
	List<TestResult> testResultList = null;
	
	String errorMessage = "";
	
	String kendoDivId = ""+ counterVal;

            _bw.write(_wl_block2Bytes, _wl_block2);

if(testResultCache == null ){
	errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.VIEWTESTRESULTS_MODULE_NAME, ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE);
	errorMessage = MessageFormat.format(errorMessage, new Object[]{orderId});

            _bw.write(_wl_block3Bytes, _wl_block3);

  	out.println(errorMessage);
  
            _bw.write(_wl_block4Bytes, _wl_block4);

}else{

	testResultList = testResultCache.getTestResultList();
	// no need to check for null
	/* ErrorInfo cacheErrorInfo = testResultCache.getErrorInfo(); */
	if(!testResultCache.hasExecuted()){
		errorMessage = MessageContainer.getInstance().getDisplayMessage(CommonConstants.VIEWTESTRESULTS_MODULE_NAME, ResultConstants.TESTRESULT_DATA_NOTOBTAINED_ERRORCODE);
		errorMessage = MessageFormat.format(errorMessage, new Object[]{orderId});
	
            _bw.write(_wl_block5Bytes, _wl_block5);

	  	out.println(errorMessage);
	  
            _bw.write(_wl_block6Bytes, _wl_block6);

	}else{
		if(!testResultCache.isSuccessful()){
			// TODO need to get the error message
			/* errorMessage = "Could not obtain test result."; */	
			errorMessage = testResultCache.getErrorMessage();
	
            _bw.write(_wl_block5Bytes, _wl_block5);

	  	out.println(errorMessage);
	  
            _bw.write(_wl_block7Bytes, _wl_block7);

		}else{
		
	
		String stripSpaceStyleId = "StripSpaceresultpop";
		String popupWrapperStyleId = "popwrapperrspage";
		String popupmsgboxStyleId = "popmsgboxresultpage";
		String resultpopupStyleId = "resultdisplaypage";
		if("Y".equalsIgnoreCase(popup)){
			stripSpaceStyleId = "StripSpaceresultpopupdialog";
			popupWrapperStyleId = "popupwrapperrspage";
			popupmsgboxStyleId = "popupmsgboxresultpage";
			resultpopupStyleId = "resultpopupdisplaypage";
			
			kendoDivId += "Popup";
		}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(stripSpaceStyleId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(popupWrapperStyleId));
            _bw.write(_wl_block10Bytes, _wl_block10);

						if(!("Y".equalsIgnoreCase(popup))){
						
						
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(order));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderId));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(resultType));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(orderDate));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(counterVal));
            _bw.write(_wl_block13Bytes, _wl_block13);

						}
						
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(popupmsgboxStyleId));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(resultpopupStyleId));
            _bw.write(_wl_block16Bytes, _wl_block16);

						String testResultDesc = "";
						//Date testResultPublishedDate = null;
						String testResultPublishedDateStr = "";
						String testResultPublishedTimeStr = "";
						String notesContent = "";
						String resultNumStr = "";
						String resultNumUOM = "";
						String normalLowStr = "";
						String normalHighStr = "";
						String criticalLowStr = "";
						String criticalHighStr = "";
						String resultStr = "";
						
						int resultNum = 0;
						int normalLow = 0;
						int normalHigh = 0;
						int criticalLow = 0;
						int criticalHigh = 0;
						
						String displayImage = null;
						
						final String DISPLAY_DATE_FORMAT = "MMM dd,yyyy";
						final String DISPLAY_TIME_FORMAT = "HH:mm";
						boolean resultBools[] = null;
						
						int counter = 1;
						
						for(TestResult testResult : testResultList){
							testResultDesc = testResult.getOrder();
							testResultPublishedDateStr = testResult.getDisplayPublishDate(DISPLAY_DATE_FORMAT);
							testResultPublishedTimeStr = testResult.getDisplayPublishTime(DISPLAY_TIME_FORMAT);
							/* testResultPublishedDate = testResult.getResultPublishDate();
							if (testResultPublishedDate != null) {
								testResultPublishedDateStr = PortalHelper
										.getDateAsString(
												testResultPublishedDate,
												ResultConstants.TESTRESULT_RESPONSE_PUBLISHDATE_FORMAT);
							} */
							notesContent = testResult.getNotesContent();
							
							// reset the image str
							displayImage = null;
						
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(testResultDesc ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(testResultPublishedDateStr ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(testResultPublishedTimeStr ));
            _bw.write(_wl_block20Bytes, _wl_block20);

										if(notesContent != null && !notesContent.trim().equals("")){
									
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(notesContent ));
            _bw.write(_wl_block22Bytes, _wl_block22);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);

									resultNumStr = testResult.getResultValue();
									resultNum = PortalHelper.getIntegerValue(resultNumStr, 0);
									resultNumUOM = testResult.getResultUOM();
									
									normalLowStr = testResult.getNormalLowValue();
									normalLow = PortalHelper.getIntegerValue(normalLowStr, 0);
									
									normalHighStr = testResult.getNormalHighValue();
									normalHigh = PortalHelper.getIntegerValue(normalHighStr, 0);
									
									criticalLowStr = testResult.getCriticalLowValue();
									criticalLow = PortalHelper.getIntegerValue(criticalLowStr, 0);
									
									criticalHighStr = testResult.getCriticalHighValue();
									criticalHigh = PortalHelper.getIntegerValue(criticalHighStr, 0);
									
									if(criticalHigh < normalHigh){
										criticalHigh = normalHigh + new Double(Math.ceil((double)normalHigh/10)).intValue();//(normalHigh / 10);
										// just for safety sake
										if(criticalHigh == normalHigh){
											criticalHigh = criticalHigh + 1;
										}
									}
									
									if(normalLow < criticalLow){
										//normalLow = criticalLow;
										criticalLow = normalLow;
									}
									
									resultStr = testResult.getResultStrValue();
									
									resultBools = testResult.getResultBoolean();
									
									if(resultNumStr != null && !resultNumStr.trim().equals("")){
									
            _bw.write(_wl_block24Bytes, _wl_block24);

										if(resultBools[TestResult.CRITICAL_LOW_INDEX]){
											displayImage = "criticalLow.png";
										}
										if(resultBools[TestResult.LOW_INDEX]){
											displayImage = "lowval.png";
										}
										if(resultBools[TestResult.NORMAL_INDEX]){
											displayImage = "normal.png";
										}
										if(resultBools[TestResult.HIGH_INDEX]){
											displayImage = "highval.png";
										}
										if(resultBools[TestResult.CRITICAL_HIGH_INDEX]){
											displayImage = "criticalhigh.png";
										}
										if(resultBools[TestResult.CRITICAL_INDEX]){
											displayImage = "critical.png";
										}
										
										// show the display image										
										if(displayImage != null && !displayImage.trim().equals("")){
									
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(displayImage));
            _bw.write(_wl_block26Bytes, _wl_block26);

										}
									
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(resultNumStr ));
            _bw.write(_wl_block28Bytes, _wl_block28);

										if(resultNumUOM != null && !resultNumUOM.trim().equals("")){
										
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(resultNumUOM ));
            _bw.write(_wl_block30Bytes, _wl_block30);

										}
										// now display the range
										if((normalLowStr != null && !normalLowStr.trim().equals("")) && (normalHighStr != null && !normalHighStr.trim().equals(""))){
										
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(normalLowStr ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(normalHighStr ));
            _bw.write(_wl_block33Bytes, _wl_block33);

										}
									
            _bw.write(_wl_block34Bytes, _wl_block34);
	
									}
									
            _bw.write(_wl_block35Bytes, _wl_block35);

									// show result str now
									if(resultStr != null && !resultStr.trim().equals("")){
									
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(resultStr ));
            _bw.write(_wl_block37Bytes, _wl_block37);

									}
									
            _bw.write(_wl_block38Bytes, _wl_block38);

										if(resultNumStr != null && !resultNumStr.trim().equals("")){							
											if(normalLow >= criticalLow && 
												normalHigh != 0 && criticalHigh != 0 
												&& criticalHigh > normalHigh){
										
							   			String divId = "kendodiv"+counter;
							   			
							   			kendoDivId = "kendodiv"+kendoDivId+counter;
							   			
							   			String lowColor = "8BBA00";
							   			String normalColor = "F6BD0F";
							   			String highColor = "FF654F";
							   			
							   			int maxUnit = new Double(Math.ceil((double)criticalHigh/5)).intValue();
							   			int minorUnit = new Double(Math.ceil((double)maxUnit/5)).intValue();
							   			
							   			String pageSrc = "./ES_Kendo_Linear.jsp?divID="+kendoDivId+"&xAxisMin="+criticalLow+"&xAxisMax="+criticalHigh+"&rCriticalLow="+criticalLow+"&rNormalLow="+normalLow+"&rLowColor="+lowColor+"&rNormalHigh="+normalHigh+"&rNormalColor="+normalColor+"&rCriticalHigh="+criticalHigh+"&rHighColor="+highColor+"&pValue="+resultNum+"&majorUnit="+maxUnit+"&minorUnit="+minorUnit;
						   			
            _bw.write(_wl_block39Bytes, _wl_block39);
            {java.lang.String __page =pageSrc
                ;
                java.lang.String[][] __queryParams = {};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block40Bytes, _wl_block40);

											}
										}
									
            _bw.write(_wl_block41Bytes, _wl_block41);

							counter++;
						} // end of for loop
						
            _bw.write(_wl_block42Bytes, _wl_block42);

			}
		}
	}
      
   
            _bw.write(_wl_block43Bytes, _wl_block43);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
