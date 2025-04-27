package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __blcheckprocessedcount extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLCheckProcessedCount.jsp", 1737915827334L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Progress Status</title>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<Script language =\"JavaScript\" src =\'../../eCommon/js/CommonLookup.js\'></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\t$(document).ready(function(){\n\t\tvar reqId = $(\'#reqId\').val();\n\t\tvar patData = loadPatientDetails(reqId);\n\t\tvar patDataArr = patData.split(\'::\');\n\t\t\n\t\t$(\'#trRow1\').css(\'visibility\',\'visible\');\n\t\t$(\'#trRow2\').css(\'visibility\',\'visible\');\n\t\t$(\'#trRow3\').css(\'visibility\',\'visible\');\n\t\t\n\t\t$(\'#patIdLabel\').text(\'Patient Id\');\n\t\t$(\'#patId\').text(patDataArr[0]);\n\t\t$(\'#epiTypeLabel\').text(\'Episode Type\');\n\t\t$(\'#epiType\').text(patDataArr[1]);\n\t\t\n\t\t$(\'#patNameLabel\').text(\'Patient Name\');\n\t\t$(\'#patName\').text(patDataArr[4]);\n\t\t$(\'#epiLabel\').text(\'Episode Id\');\n\t\t$(\'#episode\').text(patDataArr[2]);\n\t\t$(\'#visitLabel\').text(\'Visit Id\');\n\t\t$(\'#visitId\').text(patDataArr[3]);\n\t\t\n\t\tvar progress = checkProgress(reqId);\n\t\tvar progArr = progress.split(\'::\');\n\t\tif(progArr[0] == \'C\'){\n\t\t\twindow.returnValue = \'Y\';\n\t\t\twindow.close();\n\t\t}\n\t\telse if(progArr[0] == \'F\'){\n\t\t\twindow.returnValue = \'F\';\n\t\t\twindow.close();\n\t\t}\n\t\telse{\n\t\t\t$(\'#message\').css(\'visibility\',\'visible\');\n\t\t\t$(\'#processed\').text(progArr[1]);\n\t\t\t$(\'#total\').text(progArr[2]);\n\t\t\tvar cnt = 1;\n\t\t\tvar intr = setInterval(function chkProg(){\n\t\t\t\tcnt++;\n\t\t\t\tvar status = checkProgress(reqId);\n\t\t\t\tvar statusArr = status.split(\'::\');\n\t\t\t\tif(statusArr[0] == \'C\'){\n\t\t\t\t\tclearInterval(intr);\n\t\t\t\t\twindow.returnValue = \'Y\';\n\t\t\t\t\twindow.close();\n\t\t\t\t}\n\t\t\t\telse if(statusArr[0] == \'F\'){\n\t\t\t\t\tclearInterval(intr);\n\t\t\t\t\twindow.returnValue = \'F\';\n\t\t\t\t\twindow.close();\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(\'#processed\').text(statusArr[1]);\n\t\t\t\t\t$(\'#total\').text(statusArr[2]);\n\t\t\t\t}\n\t\t\t}, 5000);\n\t\t}\n\t\t\n\t\t$(\'#refersh\').click(function(){\n\t\t\tvar status = checkProgress(reqId);\n\t\t\tvar statusArr = status.split(\'::\');\n\t\t\tif(statusArr[0] == \'C\'){\n\t\t\t\t$(\'#processed\').text(statusArr[1]);\n\t\t\t\t$(\'#total\').text(statusArr[2]);\n\t\t\t\twindow.returnValue = \'Y\';\n\t\t\t\twindow.close();\n\t\t\t\t\n\t\t\t}\n\t\t\telse if(statusArr[0] == \'F\'){\n\t\t\t\twindow.returnValue = \'F\';\n\t\t\t\twindow.close();\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(\'#processed\').text(statusArr[1]);\n\t\t\t\t$(\'#total\').text(statusArr[2]);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'#close\').click(function(){\n\t\t\twindow.returnValue = \'Y\';\n\t\t\twindow.close();\n\t\t});\n\t});\n\t\n\tfunction checkProgress(reqId){\n\t\tvar progress = \'I\';\n\t\t$.ajax({\n\t\t\ttype:\"GET\",\n\t\t\turl:\"../jsp/PkgSubscriptionValidation.jsp?reqId=\"+reqId,\n\t\t\tdata:\"func_mode=getProgressCount\",\n\t\t\tdataType:\"text\",\n\t\t\tasync:false,\n\t\t\tsuccess: function(data){\n\t\t\t\tprogress = $.trim(data);\n\t\t\t\t\n\t\t\t},\n\t\t\t error: function(data){\n\t\t\t\t progress = \'I\';\n\t\t      }\n\t\t});\n\t\treturn progress;\n\t}\n\t\n\tfunction loadPatientDetails(reqId){\n\t\tvar patData = \'\';\n\t\t$.ajax({\n\t\t\ttype:\"GET\",\n\t\t\turl:\"../jsp/PkgSubscriptionValidation.jsp?reqId=\"+reqId,\n\t\t\tdata:\"func_mode=getPatData\",\n\t\t\tdataType:\"text\",\n\t\t\tasync:false,\n\t\t\tsuccess: function(data){\n\t\t\t\tpatData = $.trim(data);\n\t\t\t\t\n\t\t\t},\n\t\t\t error: function(data){\n\t\t\t\t patData = \'\';\n\t\t      }\n\t\t});\n\t\treturn patData;\n\t}\n</script>\n</head>\n<body>\n\t<table width=\"90%\" align=\"center\">\n\t\t<tr id=\'trRow1\' style=\"visibility: hidden;\">\n\t\t\t<td id=\'patIdLabel\'  style=\"width: 25%; font-size: 11px;\"></td>\n\t\t\t<td id=\'patId\' style=\"width: 25%; font-size: 11px;\"></td>\n\t\t\t<td id=\'epiTypeLabel\' style=\"width: 25%; font-size: 11px;\" ></td>\n\t\t\t<td id=\'epiType\' class=\'label\' style=\"width: 25%\"></td>\n\t\t</tr>\n\t\t<tr id=\'trRow2\' style=\"visibility: hidden;\">\n\t\t\t<td id=\'epiLabel\' style=\"width: 25%; font-size: 11px;\" ></td>\n\t\t\t<td id=\'episode\' style=\"width: 25%; font-size: 11px;\" ></td>\n\t\t\t<td id=\'visitLabel\' style=\"width: 25%; font-size: 11px;\" ></td>\n\t\t\t<td id=\'visitId\' style=\"width: 25%; font-size: 11px;\" ></td>\n\t\t\t\n\t\t</tr>\n\t\t<tr  id=\'trRow3\' style=\"visibility: hidden;\">\n\t\t\t<td id=\'patNameLabel\' style=\"width: 25%; font-size: 11px;\" ></td>\n\t\t\t<td id=\'patName\' style=\"width: 25%; font-size: 11px;\" ></td>\n\t\t</tr>\n\t</table>\n\t<div align=\"center\">\n\t\t<br/>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<h6 >Financial Calculation in Progress for the previous job request...</h6>\n\t\t\t<h6 >Current job request cannot be processed until the previous request has been completed...</h6>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t\t<h6 >Financial Calculation in Progress...</h6>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<br/>\n\t\t<h6  id=\'message\' style=\"visibility: hidden;\"><span id=\'processed\' style=\"padding-right: 5px;padding-left: 5px;\"></span>of<span id=\'total\' style=\"padding-left: 5px;padding-right: 5px;\"></span> Records Processed</h6>\n\t\t<br/>\n\t\t<input class=\'button\' type=\'button\' id=\'refersh\' name=\'refresh\' id=\'refresh\' value=\'Refresh\'> &nbsp;\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<input class=\'button\' type=\'button\' id=\'close\' name=\'close\' id=\'close\' value=\'Close\' disabled>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<input class=\'button\' type=\'button\' id=\'close\' name=\'close\' id=\'close\' value=\'Close\' >\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t</div>\n\t<input type=\'hidden\' name=\'reqId\' id=\'reqId\' id=\'reqId\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

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

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	String reqId = request.getParameter("reqId");
	String closeDisabled = request.getParameter("closeDisable");
	if(closeDisabled == null)	closeDisabled="";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
if("Y".equals(closeDisabled)){ 
            _bw.write(_wl_block4Bytes, _wl_block4);
}
		else{ 
            _bw.write(_wl_block5Bytes, _wl_block5);
} 
            _bw.write(_wl_block6Bytes, _wl_block6);
if("Y".equals(closeDisabled)){ 
            _bw.write(_wl_block7Bytes, _wl_block7);
}
		else{ 
            _bw.write(_wl_block8Bytes, _wl_block8);
} 
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(reqId ));
            _bw.write(_wl_block10Bytes, _wl_block10);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
