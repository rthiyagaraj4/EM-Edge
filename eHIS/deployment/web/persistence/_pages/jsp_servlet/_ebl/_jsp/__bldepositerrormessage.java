package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import eXH.CreditCardTransactions;
import java.sql.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import java.io.*;
import java.util.*;
import java.net.*;
import java.lang.*;
import ecis.utils.OnlineReport;
import ecis.utils.OnlineReports;
import java.util.*;
import com.ehis.util.*;

public final class __bldepositerrormessage extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLDepositErrorMessage.jsp", 1737915871710L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<head>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"JavaScript\">\n$(document).ready(function(){\n\tvar dtDisp = \'\';\n\tif($(\'#currdate\').val() != \'\'){\n\t\tvar curDt = $(\'#currdate\').val().split(\" \");\n\t\tvar timeArr = curDt[1].split(\":\");\n\t\tdtDisp = curDt[0]+\" \"+timeArr[0]+\":\"+timeArr[1];\n\t}\n\t\n\tparent.frames[4].document.forms[0].postmthyr.value=$(\'#month\').val();\n\tparent.frames[4].document.forms[0].postmonthyr.value=$(\'#year\').val();\t\t\t\t\t\t\n\tparent.frames[4].document.forms[0].doc_date.value= dtDisp;\n\tparent.frames[4].document.forms[0].cash_ctr.value=$(\'#cash_counter_code\').val();\n\tparent.frames[4].document.forms[0].shift.value=$(\'#shift_id\').val();\n\tif($(\'#sys_warning\').val()!=\'\'){\n\t\talert(getMessage($(\'#sys_warning\').val(),\'BL\'));\n\t}\n\talert($(\'#errorMessage\').val());\n\tif($(\'#printYn\').val() == \'Y\'){\n\t\tcallAsyncOnlinePrint();\t\t\n\t}\n\n\tif($(\'#err_val\').val() == 1){\n\t\t//window.close();\n\t    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n\t    dialogTag.close();\n\t}\n\telse{\n\t\tparent.frames[2].document.forms[0].target = \'\';\n\t}\n\n});\n\nfunction callAsyncOnlinePrint(){\t\t\n\t\n\tvar xmlStr=\"<root><report/></root>\";\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest() ;\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\n\txmlHttp.open(\"POST\",\"../../eBL/jsp/BLAdhocDiscOnlineReport.jsp\",true);\n\txmlHttp.send(xmlDoc);\t\n}\n</script >\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</head>\n\n<html>\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n<form id=\'messageFrm\'>\n<p align=\"left\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<input type=\'hidden\' name=\'month\' id=\'month\' id=\'month\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n<input type=\'hidden\' name=\'year\' id=\'year\' id=\'year\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=\'hidden\' name=\'currdate\' id=\'currdate\' id=\'currdate\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=\'hidden\' name=\'cash_counter_code\' id=\'cash_counter_code\' id=\'cash_counter_code\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=\'hidden\' name=\'shift_id\' id=\'shift_id\' id=\'shift_id\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'printYn\' id=\'printYn\' id=\'printYn\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'errorMessage\' id=\'errorMessage\' id=\'errorMessage\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'err_val\' id=\'err_val\' id=\'err_val\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'sys_warning\' id=\'sys_warning\' id=\'sys_warning\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

private String decodeParam(String input){
	String output = "";
	try{
		if(input!=null){
			input = input.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
			input = input.replaceAll("\\+", "%2B");
			output = URLDecoder.decode(input,"UTF-8");
		}
	}
	catch(Exception e){
		System.err.println("Exception while Decoding BillReceiptAjax->"+e);
	}
	return output;
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);


	request.setCharacterEncoding("UTF-8");
	String locale	= (String)session.getAttribute("LOCALE");
	String month = decodeParam(request.getParameter("month"));
	String year = decodeParam(request.getParameter("year"));
	String currdate = decodeParam(request.getParameter("currdate"));
	String cash_counter_code = decodeParam(request.getParameter("cash_counter_code"));
	String shift_id = decodeParam(request.getParameter("shift_id"));
	String printYn = decodeParam(request.getParameter("printYn"));
	String errorMessage = decodeParam(request.getParameter("errorMessage"));
	String err_val = decodeParam(request.getParameter("err_val"));
	String sys_warning = decodeParam(request.getParameter("sys_warning"));

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(month));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(year));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(currdate));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(shift_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(printYn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(errorMessage));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(err_val));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(sys_warning));
            _bw.write(_wl_block16Bytes, _wl_block16);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
