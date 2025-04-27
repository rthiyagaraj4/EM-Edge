package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blreceiptmultiplereportmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReceiptMultipleReportMain.jsp", 1743576022987L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\";\n\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\tdummyDoc.dummy_frm.submit();\n  \t\t} else if (print==\"R\"){  \t\t\t  \t  \t\t\t\t\n  \t\t\tvar dummyDoc = parent.document.frames[1].document;\n  \t\t\tvar htmlVal = \"<html><body>\";\n  \t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+document.ReprotPrint.facilityId.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+document.ReprotPrint.locale.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+document.ReprotPrint.pgim_id_R.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_detailed_YN\' id=\'p_detailed_YN\' value=\'\"+\"N\"+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+document.ReprotPrint.sessionId_R.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+document.ReprotPrint.pgim_date_R.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+document.ReprotPrint.pgim_id_R.value+\"\'>\";\t\t\t\t\n  \t\t\thtmlVal += \"</form></body></html>\";\n  \t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n  \t\t\tdummyDoc.dummy_frm.submit();\n  \t  \t} else if (print==\"A2\"){  \t\t\t\t\t\t\n  \t\t\tvar dummyDoc =parent.document.frames[1].document;\n  \t\t\tvar htmlVal = \"<html><body>\";\n  \t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+document.ReprotPrint.facilityId.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+document.ReprotPrint.locale.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+document.ReprotPrint.pgim_id_A2.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_detailed_YN\' id=\'p_detailed_YN\' value=\'\"+\"N\"+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+document.ReprotPrint.sessionId_A2.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+document.ReprotPrint.pgim_date_A2.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+document.ReprotPrint.pgim_id_A2.value+\"\'>\";\t\t\t\t\n  \t\t\thtmlVal += \"</form></body></html>\";\n  \t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n  \t\t\tdummyDoc.dummy_frm.submit();\n  \t  \t\t} else if (print==\"C\"){  \t\t\t\t\t\t\n  \t\t\tvar dummyDoc = parent.document.frames[1].document;\n  \t\t\tvar htmlVal = \"<html><body>\";\n  \t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+document.ReprotPrint.facilityId.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+document.ReprotPrint.locale.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+document.ReprotPrint.pgim_id_C.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_detailed_YN\' id=\'p_detailed_YN\' value=\'\"+\"N\"+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+document.ReprotPrint.sessionId_C.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+document.ReprotPrint.pgim_date_C.value+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\n  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+document.ReprotPrint.pgim_id_C.value+\"\'>\";\t\t\t\t\n  \t\t\thtmlVal += \"</form></body></html>\";\n  \t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n  \t\t\tdummyDoc.dummy_frm.submit();\n  \t  \t\t}\n  \t\t\n  \t}\n  \t\n  \tfunction windowClose()\n  \t  {\n  \t\t\n  \t\tparent.window.close();\n  \t  }\n  \t\n  \t</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<body>\n\t<form name=\'ReprotPrint\' id=\'ReprotPrint\'>\n\t\t<div id=\"tableContainer\">\n\t\t<tr style=\" border: \'0\';\" id=\'trProgress\'>\n\t\t<table border=\'0\' cellpadding=\'25\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'  align=\'center\' > \t\t\n\t\t<tbody>\t\t\t\n\t\t<tr>\n\t\t<td class=\"label\" >Report Options</td>\t\n\t\t<td>\n\t\t<select name=\'print_option\' id=\'print_option\' id=\'print_option\' onChange=\"\">\t \n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<option value=\'R\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</option>\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t<option value=\'C\'>Coupan</option>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<option value=\'A1\'>Acknowledgement</option>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\n\t\t<option value=\'A2\'>Acknowledgement</option>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</select>\n\t\t</td>\n\t\t</tr>\n\t\t<tr ><td class=\"label\" ><input type=\'button\' class=\'button\' onclick=\'runReport(print_option.value);\' value=\"Run\"  name=\'run_report\' id=\'run_report\' >\n\t\t<input type=\'button\' class=\'button\' onclick=\'windowClose();\' value=\"Close\"  name=\'close_report\' id=\'close_report\' >\n\t\t</td>\t\t\n\t\t</tr>\t\t\t\t\t\t\n\t\t</tbody>\t\n\t\t</tr> \n\t\t<input type=\'hidden\' id=\'facilityId\' name=\'facilityId\' id=\'facilityId\' value=\'RP\'>\n\t\t<input type=\'hidden\' id=\'locale\' name=\'locale\' id=\'locale\' value=\'en\'>\n\t\t<input type=\'hidden\' id=\'pgim_id_R\' name=\'pgim_id_R\' id=\'pgim_id_R\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t<input type=\'hidden\' id=\'sessionId_R\' name=\'sessionId_R\' id=\'sessionId_R\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t<input type=\'hidden\' id=\'pgim_date_R\' name=\'pgim_date_R\' id=\'pgim_date_R\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\t\t\n\t\t<input type=\'hidden\' id=\'pgim_id_C\' name=\'pgim_id_C\' id=\'pgim_id_C\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\t\t<input type=\'hidden\' id=\'sessionId_C\' name=\'sessionId_C\' id=\'sessionId_C\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t\t<input type=\'hidden\' id=\'pgim_date_C\' name=\'pgim_date_C\' id=\'pgim_date_C\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t\t<input type=\'hidden\' id=\'pgim_id_A1\' name=\'pgim_id_A1\' id=\'pgim_id_A1\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\t\t<input type=\'hidden\' id=\'sessionId_A1\' name=\'sessionId_A1\' id=\'sessionId_A1\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n\t\t<input type=\'hidden\' id=\'pgim_date_A1\' name=\'pgim_date_A1\' id=\'pgim_date_A1\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\t\t\n\t\t<input type=\'hidden\' id=\'pgim_id_A2\' name=\'pgim_id_A2\' id=\'pgim_id_A2\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t<input type=\'hidden\' id=\'sessionId_A2\' name=\'sessionId_A2\' id=\'sessionId_A2\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n\t\t<input type=\'hidden\' id=\'pgim_date_A2\' name=\'pgim_date_A2\' id=\'pgim_date_A2\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n\t\t</table>\n  \t</div>\n  \t</form>\n  \t</body>\n  </HTML>\n  \n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

 private String checkForNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
}


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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

String data			= request.getParameter("data")==null?"": request.getParameter("data");
String dataArr[] = data.split("::");	
String pgim_id_R = checkForNull(dataArr[0]);
String sessionId_R = checkForNull(dataArr[1]);
String pgim_date_R = checkForNull(dataArr[2]);
String pgim_id_C = checkForNull(dataArr[3]);
String sessionId_C = checkForNull(dataArr[4]);
String pgim_date_C = checkForNull(dataArr[5]);
String pgim_id_A1 = checkForNull(dataArr[6]);
String sessionId_A1 = checkForNull(dataArr[7]);
String pgim_date_A1 = checkForNull(dataArr[8]);
String pgim_id_A2 = checkForNull(dataArr[9]);
String sessionId_A2 = checkForNull(dataArr[10]);
String pgim_date_A2 = checkForNull(dataArr[11]);


            _bw.write(_wl_block6Bytes, _wl_block6);
 if(!"".equals(pgim_id_R))	{
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);
}
		 if(!"".equals(pgim_id_C))	{
            _bw.write(_wl_block9Bytes, _wl_block9);
}
		 if(!"".equals(pgim_id_A1))	{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
		 if(!"".equals(pgim_id_A2))	{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pgim_id_R ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(sessionId_R ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(pgim_date_R ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(pgim_id_C ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(sessionId_C ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pgim_date_C ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(pgim_id_A1 ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(sessionId_A1 ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(pgim_date_A1 ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(pgim_id_A2 ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(sessionId_A2 ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pgim_date_A2 ));
            _bw.write(_wl_block24Bytes, _wl_block24);
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
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RECEIPT.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
