package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.bc.BillReceiptBC;
import java.util.List;
import eBL.billreceipt.model.BillReceiptUnbillOutst;
import eBL.billreceipt.request.BillReceiptRequest;
import org.apache.commons.codec.binary.Base64;

public final class __billreceiptoutstbill extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptOutstBill.jsp", 1737913491346L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version           TFS/Incident        SCF/CRF            \t\t Developer Name\n--------------------------------------------------------------------------------------------------------\n1            V210129            13523         MOHE-CRF-0060       \t\t  Shikha Seth\n--------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Total Outstanding Unbilled</title>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BillReceipt.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\t$(document).ready(function(){\n\t\tvar noOfDecimals = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t\t\t\t$(\'[id^=tdOutStdAmt_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\t/*else{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}*/\n\t\t});\n\t\t\n\t\t$(\'[id^=tdRfndAmt_]\').each(function(){\n\t\t\t\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=remSlmtAmt]\').each(function(){\n\t\t\t\n\t\t\tif(($(this).val() != \'\')&& ($(this).val() != \" \")){\n\t\t\t\t\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).val(\'0\');\n\t\t\t\tputDecimal($(this).get(0),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=tdExemAmt]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=tdBillAmt]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t});\n</script>\n<style>\n\t#foo {\n\t\tposition: absolute;\n\t\tbottom: 0;\n\t\tright: 0;\n\t  }\n</style>\n</head>\n<body>\n\n<div style=\"float:left; width: 100%\">\n<table width=\'100%\'  cellpadding=\'1\'  cellspacing=0 >\n\n<tr>\n\t<td class=\'LABEL\' width=\"10%\">Facility ID :</td>\n\t<td  class=\'fields\'>\n\t<td class=\'LABEL\'  id=\'facilityId\' name=\'facilityId\' style=\"text-align: left;\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</td>\n\n\t<td width=\"74%\" align=\"right\"  cellspacing=0 style=\"padding-right: 7px;\">\n\t<input class=\'button\' type=\"button\" name=\'btnSettlement\' id=\'btnSettlement\' value=\'Settlement\' onclick=\'insertConsolidatedBill();\'></td>\n\t<td width=\"08%\" style=\"padding-right: 4px;\">\n\t<input class=\'button\' type=\"button\" name=\'reset\' id=\'reset\' value=\'Reset\' onclick=\'reset();\'></td>\t\t\n</tr>\t\n</table>\n</div>\n\n<div style=\"float:left; width: 100%\" >\n<table class=\'grid\' border=\'2\' width=\'100%\' align=\"left\" cellpadding=\'1\'  cellspacing=0 >\n<tr>\n\t<td class=\'COLUMNHEADER\' width=\"3%\" >Select</td>\n\t<td class=\'COLUMNHEADER\' width=\"3%\" >Print Bill</td>\n\t<td class=\'COLUMNHEADER\' width=\"4%\" >Episode Type</td>\n\t<td class=\'COLUMNHEADER\' width=\"5%\" >Episode No</td>\n\t<td class=\'COLUMNHEADER\' width=\"3%\" >Visit</td>\n\t<td class=\'COLUMNHEADER\' width=\"10%\" >Bill Date</td>\n\t<td class=\'COLUMNHEADER\' width=\"8%\" >Doc Type</td>\n\t<td class=\'COLUMNHEADER\' width=\"8%\" >Bill No</td>\n\t<td class=\'COLUMNHEADER\' width=\"10%\" >Customer Code</td>\n\t<td class=\'COLUMNHEADER\' width=\"12%\" >Bill Amount</td>\n\t<td class=\'COLUMNHEADER\' width=\"11%\" >Slmt/Refund Amount</td>\n\t<td class=\'COLUMNHEADER\' width=\"10%\" >Exemption Amount</td>\n\t<td class=\'COLUMNHEADER\' width=\"13%\" >Outstanding Amount</td>\n\t<td class=\'COLUMNHEADER\' width=\"10%\" >Settlement Amount</td>\t\t\n</tr>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\t<tr>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<td class=\'LABEL\'>\n\t\t\t<input type=\'checkbox\' id=\'billSelect";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' name=\'billSelect";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' onclick=\"checkUncheck(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\">\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\n\t\t<td class=\'LABEL\'>\n\t\t\t<input type=\'checkbox\' id=\'billSelect";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' disabled >\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<td class=\'LABEL\'>\n\t\t\t<input type=\'checkbox\' id=\'bill_print_yn";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' name=\'bill_print_yn";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' >\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\n\t\t<td class=\'LABEL\'>\n\t\t\t<input type=\'checkbox\'  id=\'bill_print_yn";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<td class=\'LABEL\'  id=\'episode_type";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' style=\"text-align: left;\">\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\t\t\n\t\t\t\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'episode_id";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</td>\n\t\t<td class=\'LABEL\'id=\'visit_id";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t</td>\n\t\t<td class=\'LABEL\'  nowrap  id=\'trx_date";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t</td>\n\t\t<td class=\'LABEL\'id=\'doc_type";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'doc_num";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'cust_code";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</td>\n\t\t\n\t\t<td class=\'LABEL\' id=\'tdBillAmt";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' style=\"text-align: right;\">\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t</td>\n\t\t\n\t\t<td class=\'LABEL\' id=\'tdRfndAmt_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t</td>\n\t\t\t\n\t\t<td class=\'LABEL\' id=\'tdExemAmt";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t</td>\n\t\t\n\t\t<td class=\'LABEL\' id=\'tdOutStdAmt_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t</td>\n\t\t\n\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\t\t\n\t\t<td width=\'9%\' id=\'tdRemSlmtAmt";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'  class=\'fields\'  style=\"text-align: right;\">\n\t\t<input type=\'text\' data-id=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'remSlmtAmt";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' name=\'remSlmtAmt";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' size=\'20\' maxlength = \'17\' style=\"text-align: right;\" onkeypress=\'return checkAlpha(event);\' onblur=\'return checkRemSlmtAmt(this);\'></td>\n\n\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t<td width=\'9%\' id=\'tdRemSlmtAmt";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' readonly size=\'20\' maxlength = \'17\' style=\"text-align: right;\" onkeypress=\'return checkAlpha(event);\' onblur=\'return checkRemSlmtAmt(this);\'></td>\t\t\n\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\t\t\n\t</tr>\t\n\t\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t<input type=\'hidden\' id=\'billSelect";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' >\n\t<input type=\'hidden\' id=\'bill_print_yn";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' >\n\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\'  value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t<input type=\'hidden\' name=\'facilityId\' id=\'facilityId\'  value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\t<input type=\'hidden\' name=\'patientId\' id=\'patientId\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n\t<input type=\'hidden\' name=\'queryString\' id=\'queryString\'  value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t<input type=\'hidden\' name=\'noOfDecimals\' id=\'noOfDecimals\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\t<input type=\'hidden\' name=\'index\' id=\'index\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\t<input type=\'hidden\' name=\'encounterFacilityId\' id=\'encounterFacilityId\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t</table>\n\t</div>\n</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

	private String replaceNull(String input){
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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
			
	String queryString = request.getQueryString();
	
	//V220512
	//String patientId = request.getParameter("patient_id");
	String patientId="";
	if("Y".equals(request.getParameter("encoded")==null?"":request.getParameter("encoded"))){
		patientId	= new String(Base64.decodeBase64(((String)request.getParameter("patient_id")).getBytes()));
		}else{
		patientId	= request.getParameter("patient_id");
	}
	//V220512
	String facilityId = (String) session.getValue("facility_id");
	String noOfDecimals = request.getParameter("noOfDecimal");
	String encounterFacilityId = request.getParameter("encounterFacilityId"); //V210129 
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	//billRequest.setFacilityId(facilityId);//V210129 Commented
	billRequest.setFacilityId(encounterFacilityId); //V210129 Added
	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptUnbillOutst> outStandingBills = billReceiptBC.getOutstandingBills(billRequest);

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block6Bytes, _wl_block6);

	int indx = 1;
	String episode_type="",episode_no="",visit_id="",trx_date="",doc_type="",doc_num="",cust_code="",outstandAmt="",refundAmt="",remSlmtAmt="",exemAmt="",billAmt="",bill_print_yn="";
	
	for(BillReceiptUnbillOutst outStBill:outStandingBills){

            _bw.write(_wl_block7Bytes, _wl_block7);
if(outStBill.getCustCode()==null) {	
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block11Bytes, _wl_block11);
} else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block14Bytes, _wl_block14);
if(outStBill.getCustCode()==null) {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block17Bytes, _wl_block17);
} else{
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block14Bytes, _wl_block14);
if("O".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Outpatient";
		}
		else if("I".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Inpatient";
		}
		else if("D".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Daycare";
		}
		else if("E".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="Emergency";
		}
		else if("R".equals(replaceNull(outStBill.getEpisodeType()))){
			episode_type="External";
		}
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block22Bytes, _wl_block22);
if("".equals(replaceNull(outStBill.getEpisodeNo()))){
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(replaceNull(outStBill.getEpisodeNo()) ));
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block22Bytes, _wl_block22);
if("".equals(replaceNull(outStBill.getVisitId()))){ 
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(replaceNull(outStBill.getVisitId()) ));
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(replaceNull(outStBill.getTrxDate())));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(replaceNull(outStBill.getDocType())));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(replaceNull(outStBill.getDocNum())));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block22Bytes, _wl_block22);
if("".equals(replaceNull(outStBill.getCustCode()))){ 
            _bw.write(_wl_block23Bytes, _wl_block23);
}else{ 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(replaceNull(outStBill.getCustCode()) ));
            _bw.write(_wl_block24Bytes, _wl_block24);
} 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(replaceNull(outStBill.getBillAmt())));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(replaceNull(outStBill.getRefundAmt()) ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(replaceNull(outStBill.getExemAmt())));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(replaceNull(outStBill.getOutStndAmt()) ));
            _bw.write(_wl_block35Bytes, _wl_block35);
if(outStBill.getCustCode()==null) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(replaceNull(outStBill.getOutStndAmt())));
            _bw.write(_wl_block41Bytes, _wl_block41);
} else{
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(replaceNull(outStBill.getOutStndAmt())));
            _bw.write(_wl_block43Bytes, _wl_block43);
} 
            _bw.write(_wl_block44Bytes, _wl_block44);

		indx++;		
	}
	
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(facilityId ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patientId ));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(queryString ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(noOfDecimals ));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(indx ));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(encounterFacilityId ));
            _bw.write(_wl_block54Bytes, _wl_block54);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
