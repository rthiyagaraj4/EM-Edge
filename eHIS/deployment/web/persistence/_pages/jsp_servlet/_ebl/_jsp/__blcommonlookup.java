package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import org.jaxen.util.FollowingAxisIterator;
import javax.swing.plaf.metal.MetalIconFactory.FolderIcon16;
import eCommon.XSSRequestWrapper;

public final class __blcommonlookup extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCommonLookup.jsp", 1719576190000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\r\n<html>\r\n<head>\r\n<script type=\"text/javascript\" src=\'../../eBL/js/BLCommonLookup.js\'></script>\r\n<script>\r\nfunction resetLookupForm(){\r\n\tdocument.getElementById(\'searchText\').value = \"\";\r\n\tdocument.getElementById(\'searchBy\').selectedIndex = 0;\r\n\tdocument.getElementById(\'searchCriteria\').selectedIndex = 0;\r\n\t\r\n\t/*if(document.getElementById(\'called_for\').value == \"PKG_DTLS_LKUP\")\r\n\t{\r\n\t\t$(\'#pkgLkupResult\').empty();\r\n\t}else{\r\n\t\t$(\'#popup-results\').empty();\r\n\t}*/\r\n\t\r\n\tif($(\'#called_for\').val() ==\'PAT_ID_LKUP\'){\r\n\t\t$(\'#popup-results\').empty();\r\n\t}\r\n\t\r\n\tif(($(\'#called_for\').val()==\'PAT_ID_LKUP\' && $(\'#searchMainScreenVal\').val()!=\'\') || $(\'#called_for\').val()!=\'PAT_ID_LKUP\'){\r\n    \t\t $(\'#modifyFinancialDetails\').find(\'#Srch\').click();\r\n    }\r\n}\r\n</script>\r\n</head>\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<body>\r\n\t<div class=\"lookupContainer\" >\r\n    \t<div id=\"headerDiv\" class=\"lookup-headercontainer\" style=\"background-color: #00A0DD;\">\r\n\t\t\t<div class=\"lookup-title\">";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</div>\r\n\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n\t\t\t<input type=\"Button\" class=\"icon-button\" value=\"X\" onclick=\"closePkgPopup()\" >\r\n\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\t\t\t<input type=\"Button\" class=\"icon-button\" id=\'closeLookup\' value=\"X\" onclick=\"closePopup()\" >\r\n\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n\t\t\t<!-- <div class=\"buttoncontainer\">\r\n\t\t\t\t<span class=\"close-btn\" onclick=\"closePopup()\">X</span>\r\n\t\t\t</div> -->\r\n\t\t</div>\r\n\t\t<div id=\"searchDiv\" class=\"lookup-subcontainer\">\r\n\t\t\t<div class=\"col-11\">\r\n\t\t\t\t<div class=\"input-wrapper inputLargeContainer\">\r\n\t\t\t\t\t<label  class=\"label-select\">Search By</label>\r\n\t\t\t\t\t\t<select class=\"inputselect\" id=\"searchBy\" name=\"searchBy\">\r\n\t\t\t\t\t\t\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\r\n\t\t\t\t\t\t\t<option class=\"label-select\" selected value=\'PI\'>Patient ID</option>\r\n\t\t\t\t\t\t\t<option class=\"label-select\"  value=\'PN\'>Patient Name</option>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n\t\t\t\t\t\t\t<option class=\"label-select\" selected value=\'EI\'>Encounter ID</option>\r\n\t\t\t\t\t\t\t<option class=\"label-select\"  value=\'PI\'>Patient ID</option>\t\t\t\t\t\t    \r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t\t\t\t\t\t   <option class=\"label-select\" selected value=\'PC\'>Package Code</option>\r\n\t\t\t\t\t\t   <option class=\"label-select\"  value=\'PD\'>Package Desc</option>\r\n\t\t\t\t\t\t   <option class=\"label-select\"  value=\'PS\'>Package SEQ</option>\r\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t\t\t\t\t\t\t<option class=\"label-select\" id=\'description\' value=\'desc\'>Description</option>\r\n\t\t\t\t\t\t\t<option class=\"label-select\" id=\'code\' value=\'code\'>Code</option>\t\t\t\t\t\t    \r\n\t\t\t\t\t    ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\r\n\t\t\t\t\t\t </select>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t<div class=\"col-11\">\r\n\t\t\t\t<div class=\"input-wrapper inputLargeContainer\">\r\n\t\t\t\t\t<label  class=\"label-select\">Search Criteria</label>\r\n\t\t\t\t\t<select class=\"inputselect\" id=\"searchCriteria\">\r\n\t\t\t\t\t\t<option class=\"label-select\"  value=\"S\">Starts with</option>\r\n\t\t\t\t\t\t<option class=\"label-select\"  value=\"E\">Ends with</option>\r\n\t\t\t\t\t\t<option class=\"label-select\"  value=\"C\">Contains</option>\r\n\t\t\t\t\t</select>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t<div class=\"col-11\">\r\n\t\t\t\t<div class=\"input-wrapper inputLargeContainer\">\r\n\t\t\t\t\t<label  class=\"label\">Search Text</label>\r\n\t\t\t\t\t<input type=\"text\" class=\"input\" id=\"searchText\" autocomplete=\"off\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\r\n\t\t\t\t</div>\r\n\t\t\t</div>\r\n\t\t\t\r\n\t\t</div>\r\n\t\t<br>\r\n\t\t<div class=\"buttoncontainer\" >\r\n\t\t\t\t<input type=\"Button\" class=\"btn btn-primary\"  id=\"Srch\" value=\"Search\" onClick=\"search();\">\r\n\t\t\t\t<input type=\"Button\" class=\"btn btn-primary\"  value=\"Reset\" onclick=\"resetLookupForm()\" >&nbsp;&nbsp;\r\n\t\t</div>\r\n    \t<div id=\"resultDiv\" class=\"lookup-subcontainer\">\r\n    \t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\t\t\t<div class=\"table\" id=\"pkgLkupResult\" contenteditable=\"false\">\r\n\t\t\t</div>\r\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n    \t\t<div class=\"table\" id=\"popup-results\" contenteditable=\"false\" style=\"display: none\">\r\n\t\t\t</div>\r\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n    \t</div>\r\n    </div>\r\n   \r\n    <input type=\"hidden\" id=\"column_descriptions\"  value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\r\n    <input type=\"hidden\" id=\"strWhereColumn\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\r\n    <input type=\"hidden\" id=\"strWhereColumnType\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\r\n    <input type=\"hidden\" id=\"searchMainScreenVal\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\r\n    <input type=\"hidden\" id=\"called_for\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" />\r\n    <input type=\"hidden\" id=\"searchFieldID\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" /> \r\n    <input type=\"hidden\" id=\"paramForQuery\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\"/>\r\n    <input type=\"hidden\" id=\"searchOpt\" name=\'searchOpt\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"/>\r\n</body>\r\n <script type=\"text/javascript\">\r\n/*  $(document).ready(function(){\r\n\t if(document.getElementById(\'searchOpt\').value != \"\")\r\n\t\tdocument.getElementById(\'searchBy\').value = document.getElementById(\'searchOpt\').value;\r\n\t if(($(\'#called_for\').val()==\'PAT_ID_LKUP\' && $(\'#searchMainScreenVal\').val()!=\'\') || $(\'#called_for\').val()!=\'PAT_ID_LKUP\'){\r\n\t\t$(\'#modifyFinancialDetails\').find(\'#Srch\').click();\r\n\t\t// const myTimeout = setTimeout( $(\'#modifyFinancialDetails\').find(\'#Srch\').click(), 100000);\r\n\t }\r\n  }); */\r\n //var v=setTimeout(onloadfunc ,10000);\r\n     \r\n  \t\r\n     $(\'#closeLookup\').click(function() {\r\n\t    \tvar searchFieldID=$(\'#searchFieldID\').val();\r\n\t    \tif(searchFieldID!=\'\'){\r\n\t    \t\tvar srchArr=searchFieldID.split(\',\');\r\n\t    \t\tif(srchArr.length>0){\r\n\t    \t\t\t document.getElementById(array[0]).value = \'\';\r\n\t\t\t\t\t document.getElementById(array[1]).value = \'\';\r\n\t    \t\t}\r\n\t    \t}\r\n\t    });\r\n</script>\r\n</html>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
 
	request.setCharacterEncoding("UTF-8");
	request = new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");

            _bw.write(_wl_block1Bytes, _wl_block1);

	String queryString=request.getQueryString();
	String title = request.getParameter("title");
	request.setCharacterEncoding("UTF-8");
	String column_names = "";
	String called_for = request.getParameter("called_for");
	String column_descriptions = request.getParameter("column_descriptions");
	String column_sizes = request.getParameter("column_sizes");
	String searchMainScreenVal = request.getParameter("searchMainScreenVal");
	String strWhereColumnType = request.getParameter("strWhereColumnType");
	String strWhereColumn = request.getParameter("strWhereColumn");
	String searchFieldID = request.getParameter("searchFieldID");
	if(searchFieldID==null) searchFieldID="";
	String facility_id=request.getParameter("facility_id");
	String paramForQuery = request.getQueryString();
	String srch_by_index = request.getParameter("srch_by_clmn_index");
	if(srch_by_index == null) srch_by_index="1";
	int srch_by_clmn_index = Integer.parseInt(srch_by_index);
	String col_show_hide = request.getParameter("col_show_hide");
	if(col_show_hide == null) col_show_hide=""; 
	String searchOpt=request.getParameter("searchOpt");
	if(searchOpt == null) searchOpt=""; 
	
	System.err.println("title="+title+"&column_sizes="+column_sizes+"&column_descriptions="+column_descriptions+"&searchFieldID="+searchFieldID);

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(title ));
            _bw.write(_wl_block3Bytes, _wl_block3);
 if(called_for.equals("PKG_DTLS_LKUP")){ 
            _bw.write(_wl_block4Bytes, _wl_block4);
} else{ 
            _bw.write(_wl_block5Bytes, _wl_block5);
} 
            _bw.write(_wl_block6Bytes, _wl_block6);
if(called_for.equals("PAT_ID_LKUP")){
            _bw.write(_wl_block7Bytes, _wl_block7);
}else if(called_for.equals("ENC_ID_LKUP")){ 
            _bw.write(_wl_block8Bytes, _wl_block8);
}else if(called_for.equals("PKG_DTLS_LKUP")){
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
						//selected 
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(searchMainScreenVal));
            _bw.write(_wl_block12Bytes, _wl_block12);
if(called_for.equals("PKG_DTLS_LKUP")){ 
            _bw.write(_wl_block13Bytes, _wl_block13);
}else{ 
            _bw.write(_wl_block14Bytes, _wl_block14);
} 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(column_descriptions ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf( strWhereColumn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( strWhereColumnType));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(searchMainScreenVal ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(called_for));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(searchFieldID ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(paramForQuery ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(searchOpt));
            _bw.write(_wl_block23Bytes, _wl_block23);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
