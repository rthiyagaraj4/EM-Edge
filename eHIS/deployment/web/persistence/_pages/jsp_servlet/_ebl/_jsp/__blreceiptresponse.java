package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
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

public final class __blreceiptresponse extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLReceiptResponse.jsp", 1743576046330L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script language=\'javascript\' src=\'../js/BLReprintReportReceipt.js\'></script>\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Report</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\t\n<script type=\"text/javascript\">\nfunction removeAllRecord(){\t\t\n\t\n\tvar trlast = $(parent.selectedFrame.document).find(\'#tblSelectedReport tr:last\');\n\tvar lastindx =  $(trlast).attr(\'indexval\');\n\tvar i=1;\n\t\n\tfor(i=1;i<=lastindx;i++) {\n\t\n\t\tvar docTypeCode =  $.trim($(\'#doc_typ_code\'+i).val());\n\t\tvar docNum = $.trim($(\'#doc_num\'+i).val());\n\t\tvar uniqueReceiptId = docTypeCode+\"_\"+docNum;\n\t\tvar dataArray = selectedReceipt.split(\'####\');\n\t\tdataArray.splice($.inArray(uniqueReceiptId, dataArray),1);\n\t\tselectedReceipt = dataArray.join(\'####\');\t\t\n\t\t$(\'#row\'+i).remove();\n\t}\t\n\t\n}\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\tvar selectedReceipt = window.parent.selectedFrame.selectedReceipt;// \'\';\n\t$(document).ready(function(){\n\t\t$(\"input[type=\'text\']\").keydown(function(e){\n\t\t\tif (e.which === 8 && !$(e.target).is(\"input[type=\'text\']:not([readonly])\")) {\n\t\t\t\te.preventDefault();\n\t\t\t\t\n\t\t    }\n\t\t});\n\t\n\t\t\n\t\tif(document.ReprotPrint.modeType.value==\'R\'  ){\n\t\t\tvar dataArr = (document.ReprotPrint.retVal.value).split(\"::\");\t\n\t\t\n\t\t\tvar pgim_id_R = dataArr[0];\n\t\t\n\t\t\tvar sessionId_R = dataArr[1];\n\t\t\tvar pgim_date_R = (dataArr[2]);\n\t\t\tvar pgim_id_C = (dataArr[3]);\n\t\t\tvar sessionId_C = (dataArr[4]);\n\t\t\tvar pgim_date_C = (dataArr[5]);\n\t\t\tvar pgim_id_A1 = (dataArr[6]);\n\t\t\tvar sessionId_A1 = (dataArr[7]);\n\t\t\tvar pgim_date_A1 = (dataArr[8]);\n\t\t\tvar pgim_id_A2 = (dataArr[9]);\n\t\t\tvar sessionId_A2 = (dataArr[10]);\n\t\t\tvar pgim_date_A2 = (dataArr[11]);\n\t\t\tvar print_option = dataArr[15];\n\t\t\tvar facilityId = dataArr[16];\n\t\t\tvar language_id = dataArr[17];\n\t\t\n\t\t\tif(print_option==\'R\'){\n\t\t\t\tif(pgim_id_R != null && pgim_id_R != \"\") {\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\tvar dummyDoc = parent.messageFrame.document;\n\t\t  \t\t\tvar htmlVal = \"<html><body>\";\n\t\t  \t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+facilityId+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+language_id+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+pgim_id_R+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_detailed_YN\' id=\'p_detailed_YN\' value=\'\"+\"N\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+sessionId_R+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+pgim_date_R+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+pgim_id_R+\"\'>\";\t\t\t\t\n\t\t  \t\t\thtmlVal += \"</form></body></html>\";\n\t\t  \t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t  \t\t\tdummyDoc.dummy_frm.submit();\n\t\t\t\t}else if(pgim_id_C != null && pgim_id_C != \"\") {\n\t\t\t\t\tvar dummyDoc = parent.messageFrame.document;\n\t\t  \t\t\tvar htmlVal = \"<html><body>\";\n\t\t  \t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+facilityId+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+language_id+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+pgim_id_C+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_detailed_YN\' id=\'p_detailed_YN\' value=\'\"+\"N\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+sessionId_C+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+pgim_date_C+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+pgim_id_C+\"\'>\";\t\t\t\t\n\t\t  \t\t\thtmlVal += \"</form></body></html>\";\n\t\t  \t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t  \t\t\tdummyDoc.dummy_frm.submit();\n\t\t\t\t}\n\t\t\t}else if (print_option == \'A\') {\n\t\t\t\tif(pgim_id_A1 != null && pgim_id_A1 != \"\") {\n\t\t\t\t\tvar dummyDoc = parent.messageFrame.document;\n\t\t  \t\t\tvar htmlVal = \"<html><body>\";\n\t\t  \t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+facilityId+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+language_id+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+pgim_id_A1+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_detailed_YN\' id=\'p_detailed_YN\' value=\'\"+\"N\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+sessionId_A1+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+pgim_date_A1+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+pgim_id_A1+\"\'>\";\t\t\t\t\n\t\t  \t\t\thtmlVal += \"</form></body></html>\";\n\t\t  \t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t  \t\t\tdummyDoc.dummy_frm.submit();\n\t\t\t\t}else if(pgim_id_A2 != null && pgim_id_A2 != \"\") {\n\t\t\t\t\tvar dummyDoc = parent.messageFrame.document;\n\t\t  \t\t\tvar htmlVal = \"<html><body>\";\n\t\t  \t\t\thtmlVal += \"<form name=\'dummy_frm\' id=\'dummy_frm\'  action=\'../../eCommon/jsp/report_options.jsp\' >\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_facility_id\' id=\'p_facility_id\' value=\'\"+facilityId+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_language_id\' id=\'p_language_id\' value=\'\"+language_id+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_report_id\' id=\'p_report_id\' value=\'\"+pgim_id_A2+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_detailed_YN\' id=\'p_detailed_YN\' value=\'\"+\"N\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_session_id\' id=\'p_session_id\' value=\'\"+sessionId_A2+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_date\' id=\'p_pgm_date\' value=\'\"+pgim_date_A2+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_module_id\' id=\'p_module_id\' value=\'\"+\"BL\"+\"\'>\";\n\t\t  \t\t\thtmlVal += \"<input type=\'hidden\' name=\'p_pgm_id\' id=\'p_pgm_id\' value=\'\"+pgim_id_A2+\"\'>\";\t\t\t\t\n\t\t  \t\t\thtmlVal += \"</form></body></html>\";\n\t\t  \t\t\tdummyDoc.body.insertAdjacentHTML(\"afterbegin\",htmlVal);\n\t\t  \t\t\tdummyDoc.dummy_frm.submit();\n\t\t\t\t}\n\t\t\t}else if(print_option == \'B\'){\t\t\t \n\t\t\t\t\t var dialogHeight    = \'8\' ;\n\t\t\t\t\t var dialogWidth = \'20\' ;\t\n\t\t\t\t\t var dialogTop = \'100\' ;\t \n\t\t\t\t\t var center    = \'1\'  ;\t\n\t\t\t\t\t var arguments =   \'\';\n\t\t\t\t\t var features    = \'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; center:\' + center +\'; dialogTop:\' + dialogTop +\'; status=no;\';\t\t\n\t\t\t\t\t var param=\"data=\"+document.ReprotPrint.retVal.value;\n\t\t\t\t\t\n\t\t\t\t\t var getUrl1  = \"../../eBL/jsp/BLReceiptMultipleReport.jsp?\"+param;\n\t\t\t\t\t var retVal = window.showModalDialog(getUrl1,arguments,features);\t\n\t\t\t\t\t window.returnValue = \'Y\';\n\t\t\t\t\t window.close();\t\n\t\t\t\t}\n\t\t} else if(document.ReprotPrint.modeType.value==\'C\'  && document.ReprotPrint.succ.value == \'Y\' ){\t\n\t\t\tvar errors = document.ReprotPrint.Status.value.split(\"<<\");\t\t\t\n\t\t\tvar allError=\"\";\n\t\t\tvar i=0;\t\t\n\t\t\t\n\t\t\tfor(i=0;i<(errors.length);i++){\t\t\t\t\n\t\t\t\tallError+=errors[i]+\"\\n\";\t\t\t\t\t\t\n\t\t\t}\t\t\n\t\t\t\n\t\t\tparent.search_hdr.document.BLReceiptReprint.search_but.click();\n\t\t\talert(allError);\n\t\t\t//alert(document.ReprotPrint.Status.value);\n\t\t\tparent.selectedFrame.location.href=\"../../eBL/jsp/BLReprintReceiptSelected.jsp\";\t\n\t\t\tparent.buttonFrame.location.href=\"../../eBL/jsp/BLReprintReceiptBtn.jsp\";\n\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t\n\t\t}else if(document.ReprotPrint.modeType.value==\'C\'  && document.ReprotPrint.succ.value == \'N\' ){\t\t\t\n\t\t\tvar errors = document.ReprotPrint.Status.value.split(\"<<\");\t\t\t\n\t\t\tvar allError=\"\";\n\t\t\tvar i=0;\t\t\n\t\t\t\n\t\t\tfor(i=0;i<(errors.length)-1;i++){\n\t\t\t\tif(errors[i]!=\'10\'){\n\t\t\t\tallError+=errors[i]+\"\\n\";\n\t\t\t\t}\t\t\t\t\n\t\t\t}\t\t\t\n\t\t\tif(errors[errors.length-2]==\'10\') {\n\t\t\t\tparent.search_hdr.document.BLReceiptReprint.search_but.click();\n\t\t\t\t\n\t\t\t\tparent.selectedFrame.location.href=\"../../eBL/jsp/BLReprintReceiptSelected.jsp\";\t\n\t\t\t\tparent.buttonFrame.location.href=\"../../eBL/jsp/BLReprintReceiptBtn.jsp\";\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t}else{\n\t\t\t\talert(allError);\n\t\t\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/error.jsp\';\n\t\t\t}\n\t\t\t\n\t\t}\t\t\n\t});\n</script>\n</head>\n<BODY CLASS=\"MESSAGE\" onKeyDown = \'lockKey()\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<form name=\'ReprotPrint\' id=\'ReprotPrint\'>\n\t\t<input type=\'hidden\' id=\'Status\' name=\'Status\' id=\'Status\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\t\n\t\t<input type=\'hidden\' id=\'modeType\' name=\'modeType\' id=\'modeType\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\t\n\t\t<input type=\'hidden\' id=\'succ\' name=\'succ\' id=\'succ\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t\t\t\t\t\n\t\t</form >\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t<form name=\'ReprotPrint\' id=\'ReprotPrint\'>\n\t\t\t\t\t\n\t\t\t\t<input type=\'hidden\' id=\'modeType\' name=\'modeType\' id=\'modeType\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\t\n\t\t\t\t<input type=\'hidden\' id=\'retVal\' name=\'retVal\' id=\'retVal\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\t\n\t\t\t\t\t\n\t\t\t\t</form >\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</body>\n</html>\n\n";
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
		System.err.println("Exception while Decoding ->"+e);
	}
	return output;
}


public String replaceNull(String input){
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

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	request.setCharacterEncoding("UTF-8");
	String retValue = decodeParam(request.getParameter("retValue"));
	System.err.println("retValue->"+retValue);
	String dataArr[] = retValue.split("::");
	String type = replaceNull(dataArr[0]);
	String succ= replaceNull(dataArr[1]);
//	String warning= replaceNull(dataArr[2]);	
	 if ("C".equals(type)) {
		System.out.println("in c");
		String mes="";	
		
		if("Y".equals(succ) ) {
			if(!dataArr[2].equals("N")){	
				mes = dataArr[2];
			}
			mes = mes+"APP-SM0070 Operation Completed Successfully ....";	
			
			// mes =  "APP-SM0070 Operation Completed Successfully ....";				
			System.out.println("cancel success mes="+mes);
		}else if("N".equals(succ)) {
			mes=dataArr[2];
			System.out.println("cancel error "+dataArr[2]);
		}
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mes));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(succ));
            _bw.write(_wl_block12Bytes, _wl_block12);
 }else {
				type="R";
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(retValue));
            _bw.write(_wl_block15Bytes, _wl_block15);
	} 
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
