package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;

public final class __billreceiptexisordersummary extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptExisOrderSummary.jsp", 1738423906538L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="    \n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\'javascript\' src=\'../../eBL/js/BillReceipt.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\t$(document).ready(function(){\n\t\t$(\'#exclRefresh\').click(function(){\n\t\t\tvar detDoc = parent.BillReceiptExisOrderDetails.document;\n\t\t\tvar queryString = $(detDoc).find(\"#queryString\").val();\n\t\t\tdetDoc.location.href = \'../jsp/BillReceiptExistOrderGroup.jsp?\'+queryString;\n\t\t\t\n\t\t});\n\t\t\n\t\t$(\'#colorStatus\').click(async function(){\n\t\t\tvar dialogHeight= \"12\" ;\n\t\t\tvar dialogWidth\t= \"13\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\tvar status=\"no\";\n\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status: \" + status + \"; scroll=auto; center:yes\";\n\t\t\tvar pDoc = parent.BillReceiptExisOrderSearch.document;\n\t\t\tvar params = \"../jsp/BillReceiptColourIndicator.jsp\";\n\t\t\tvar popupWindow =await window.showModalDialog(params,null,features);  \n\t\t});\n\t\t\n\t\t$(\'#summaryDiv\').show();\n\t\tvar pDoc = parent.BillReceiptExisOrderDetails.document;\n\t\tvar infoDoc = parent.BillReceiptInfo.document;\n\t\tvar noOfDecimal = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t\t$(\'#approxPayerAmt\').text($(pDoc).find(\'#approx_pyr_amt\').val());\n\t\t$(\'#approxPatAmt\').text($(pDoc).find(\'#approx_pat_amt\').val());\n\t\t$(\'#patAmt\').text($(pDoc).find(\'#patient_amt\').val());\n\t\t$(\'#exemptReq\').val($(pDoc).find(\'#exemption_amt\').val());\n\t\t$(\'#deposits\').text($(pDoc).find(\'#deposit_amt\').val());\n\t\t$(\'#totNetAmt\').text($(pDoc).find(\'#net_amt\').val());\n\t\t$(\'#splDepAdj\').text($(pDoc).find(\'#spl_dep_adj_amt\').val());\n\t\t$(\'#slmtAmt\').val($(pDoc).find(\'#slmt_amt\').val());\n\t\t$(\'#totSplDep\').text($(pDoc).find(\'#spl_dep_amt\').val());\n\t\t$(\'#availSplDep\').text($(pDoc).find(\'#available_spl_dep_amt\').val());\n\t\t$(\'#adjSplDep\').text($(pDoc).find(\'#adjustable_spl_dep_amt\').val());\n\t\t$(\'#balSplDep\').text($(pDoc).find(\'#balance_spl_dep_amt\').val());\n\t\t$(\'#docAmt\').val($(pDoc).find(\'#slmt_amt\').val());\n\t\t$(\'#docAmt1\').val($(pDoc).find(\'#slmt_amt\').val());\n\t\t$(\'#patDepAdj\').val($(pDoc).find(\'#patDepAdj\').val());\n\t\t$(\'#patDepBal\').val($(pDoc).find(\'#patDepBal\').val());\n\t\t$(\'#patPrepayAdj\').val($(pDoc).find(\'#patPrepayAdj\').val());\n\t\t$(\'#patPrepayBal\').val($(pDoc).find(\'#patPrepayBal\').val());\n\t\t$(\'#depAdjustedYn\').val($(pDoc).find(\'#depAdjustedYn\').val());\n\t\t$(\'#preAdjustedYn\').val($(pDoc).find(\'#preAdjustedYn\').val());\t\n\t\t\n\t\t$(\'#prevDepAdjAmt\').val($(pDoc).find(\'#prevDepAdjAmt\').val());\n\t\t$(\'#prevPreAdjAmt\').val($(pDoc).find(\'#prevPreAdjAmt\').val());\t\n\n\t\t$(parent.BillReceiptInfo.document).find(\'#depAdjustedYn\').val($(\'#depAdjustedYn\').val());\n\t\t$(parent.BillReceiptInfo.document).find(\'#preAdjustedYn\').val($(\'#preAdjustedYn\').val());\t\n\n\t\n\t\t$(parent.BillReceiptInfo.document).find(\'#patDepAdj\').text($(\'#patDepAdj\').val());\n\t\t$(parent.BillReceiptInfo.document).find(\'#patDepBal\').text($(\'#patDepBal\').val());\n\t\t$(parent.BillReceiptInfo.document).find(\'#patPrepayAdj\').text($(\'#patPrepayAdj\').val());\n\t\t$(parent.BillReceiptInfo.document).find(\'#patPrepayBal\').text($(\'#patPrepayBal\').val());\n\t\tvar total = $(pDoc).find(\'#totalGroup\').val();\n\t\tif(parseInt(total)<1){\n\t\t\t$(infoDoc).find(\'#patDepBal\').text($.trim($(infoDoc).find(\'#availPatDep\').text()));\n\t\t\t$(infoDoc).find(\'#patPrepayBal\').text($.trim($(infoDoc).find(\'#availPatPrepay\').text()));\n\t\t\t\n\t\t\t$(infoDoc).find(\'#depAdjChk\').prop(\'checked\',false);\n\t\t\t$(infoDoc).find(\'#prePayChk\').prop(\'checked\',false);\n\t\t}\n\t\t\t\n\t\t\tif($(parent.BillReceiptInfo.document).find(\'#patDepAdj\').text() != \'\'){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patDepAdj\'),17,noOfDecimal);\t\n\t\t\t\t}\n\t\t\telse{\n\t\t\t\t$(parent.BillReceiptInfo.document).find(\'#patDepAdj\').text(\'0\');\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patDepAdj\'),17,noOfDecimal);\n\t\t\t}\n\t\t\t\n\t\t\tif($(parent.BillReceiptInfo.document).find(\'#patDepBal\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patDepBal\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(parent.BillReceiptInfo.document).find(\'#patDepBal\').text(\'0\');\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patDepBal\'),17,noOfDecimal);\n\t\t\t}\n\t\t\tif($(parent.BillReceiptInfo.document).find(\'#patPrepayAdj\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patPrepayAdj\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(parent.BillReceiptInfo.document).find(\'#patPrepayAdj\').text(\'0\');\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patPrepayAdj\'),17,noOfDecimal);\n\t\t\t}\n\t\t\tif($(parent.BillReceiptInfo.document).find(\'#patPrepayBal\').text() != \'\'){\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patPrepayBal\'),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\n\t\t\t\t$(parent.BillReceiptInfo.document).find(\'#patPrepayBal\').text(\'0\');\n\t\t\t\tputDecimal_Text($(parent.BillReceiptInfo.document).find(\'#patPrepayBal\'),17,noOfDecimal);\n\t\t\t}\n\t\t\n\t\t\n\t\tif($(pDoc).find(\'#splDepYN\').val() != \'Y\'){\n\t\t\t$(\'#splDepTr\').hide();\n\t\t}\n\t\t\n\t\tvar noOfDecimals = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t\t$(\'input:text\').each(function(){\n\t\t\tif($(this).val() != \'\'){\n\t\t\t\tputDecimal_field($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal_field($(this).get(0),17,noOfDecimals);\n\t\t\t}\t\t\t\t\n\n\t\t});\n\n\t\t$(\'span\').each(function(){\n\t\t\tif($(this).attr(\'roundToVal\') == \'Y\'){\n\t\t\t\t\n\t\t\t\tif($.trim($(this).text()) != \'\'){\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(this).text(\'0\');\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t\t}\n\t\t\t}\n\t\t});\n\t\t\n\t\tif($(\'#docAmt\').val() != \'\'){\n\t\t\tputDecimal_field($(\'#docAmt\').get(0),17,noOfDecimal);\t\t\t\t\n\t\t}\n\t\telse{\n\t\t\n\t\t\t$(\'#docAmt\').val(\'0\');\n\t\t\tputDecimal_field($(\'#docAmt\').get(0),17,noOfDecimal);\n\t\t}\n\t\t\n\t});\n</script>\n</head>\n<body>\n\t<div id=\'summaryDiv\' style=\"display: none;\">\n\t\t<table style=\"width: 100%;\">\n\t\t\t<tr>\n\t\t\t\t<td class=\"grid\" border=\"1px;\">\n\t\t\t\t<table style=\"width: 100%;\" align=\"center\" >\n\t\t\t<tr>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tApprox Payer Amt\n\t\t\t\t</td>\n\t\t\t\t<td  width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'approxPayerAmt\' id=\'approxPayerAmt\'></span>\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tPatient Amt\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'patAmt\' id=\'patAmt\'></span>\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tTotal Net Amt\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'totNetAmt\' id=\'totNetAmt\'></span>\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tTotal Special Dep\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'totSplDep\' id=\'totSplDep\'></span>\t\t\n\t\t\t\t</td>\n\t\t\t\t<td id=\'remarksByCashier\' class=\'label\' width=\'15%\'>\n\t\t\t\t\t<span style=\"color: blue; cursor: pointer;\" onclick=\"javascript:captureRemarks()\">Remarks</span>\n\t\t\t\t\t<input type=\'hidden\' name=\'remarksDtl\' id=\'remarksDtl\'  value=\"\">\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tApprox Patient Amt\n\t\t\t\t</td>\n\t\t\t\t<td  width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'approxPatAmt\' id=\'approxPatAmt\'></span>\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tExempt Req\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'fields\' align=\"right\">\n\t\t\t\t\t<input type=\'text\' size=\'17\' style=\"text-align: right;\" name=\'exemptReq\'  id=\'exemptReq\' value=\'\' onblur=\"if(this.value>0){exemptReqValidate(this);}\" onchange=\"\"></td>\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tDeposits\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'deposits\' id=\'deposits\'></span>\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tSettlement Amount\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' size=\'17\' style=\"text-align: right;\" name=\'slmtAmt\'  id=\'slmtAmt\' value=\'\' onblur=\"slmtAmtValidate(this);\"></td>\t\t\n\t\t\t\t</td>\n\t\t\t\t<td  width=\'15%\' class=\'fields\'>\n\t\t\t\t\t<!-- <input type=\'button\' class=\'button\' name=\'colorStatus\' id=\'colorStatus\' id=\'colorStatus\' value=\'Color Status\'></td> -->\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t<tr id=\'splDepTr\'>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tSpl Dep Adjusts&nbsp;<input type=\'checkbox\'  name=\'splDepChk\' id=\'splDepChk\'  value=\'\'>\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'18%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'splDepAdj\' id=\'splDepAdj\'></span>\t\t\n\t\t\t\t\t</td>\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tAvail Spl Dep\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'availSplDep\' id=\'availSplDep\'></span>\t\t\n\t\t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tAdjust\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\'  name=\'adjSplDep\' id=\'adjSplDep\'></span>\t\t\n\t\t\t\t</td>\n\t\t\t\t<td class=\'LABEL\' width=\'12%\'>\n\t\t\t\t\tBalance\n\t\t\t\t</td>\n\t\t\t\t<td   width=\'8%\' class=\'LABEL\' style=\"text-align: right\">\n\t\t\t\t\t<Span roundToVal=\'Y\' name=\'balSplDep\' id=\'balSplDep\'></span>\t\t\n\t\t\t\t</td>\n\t\t\t\t<input type=\'hidden\' name=\'docAmt1\' id=\'docAmt1\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'docAmt\' id=\'docAmt\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'patDepAdj\' id=\'patDepAdj\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'patDepBal\' id=\'patDepBal\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'patPrepayAdj\' id=\'patPrepayAdj\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'patPrepayBal\' id=\'patPrepayBal\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'depAdjustedYn\' id=\'depAdjustedYn\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'preAdjustedYn\' id=\'preAdjustedYn\'  value=\'\'>\t\n\t\t\t\t<input type=\'hidden\' name=\'prevDepAdjAmt\' id=\'prevDepAdjAmt\'  value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'prevPreAdjAmt\' id=\'prevPreAdjAmt\'  value=\'\'>\t\t\t\t\n\t\t\t</tr>\t\t\t\n\t\t</table>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t\n\t</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
