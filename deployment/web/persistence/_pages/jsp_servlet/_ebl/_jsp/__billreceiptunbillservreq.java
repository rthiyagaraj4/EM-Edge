package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eBL.billreceipt.model.BillReceiptUnbillOutst;
import java.util.List;
import java.util.HashMap;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.request.BillReceiptRequest;
import org.apache.commons.codec.binary.Base64;

public final class __billreceiptunbillservreq extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptUnbillServReq.jsp", 1734679731834L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Unbilled Service Request-Episode </title>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'/>\n   <style>\n\t.Unprocessed{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: #52BD15;\n\t}\n\t.Unconfirmed{\n\t\twidth: 50px;\n\t\theight: 12.5px;\n\t\tbackground: red;\n\t}\n\n</style>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BillReceipt.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\t$(document).ready(function(){\t\t\n\t\tvar noOfDecimals = $(\'#noOfDecimal\').val();\t\t\n\t\t$(\'[id^=tdGrossAmt_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=tdDiscAmt_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=tdNetAmt_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=tdSumm_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t});\n</script>\n</head>\n<body>\n<br/>\n<div style=\"float:left; width: 100%\">\n<table width=\'100%\' align=\"left\" cellpadding=\'3\'  cellspacing=0 >\n\t\t<td class=\'LABEL\' width=\"5%\" >Facility ID</td>\t\t\n\t\t<td width=\"10%\" class=\'LABEL\'>\n\t\t<span id=\'facilityId\' name=\'facilityId\' size=\'3\' readonly >";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</span>\n\t\t</td>\t\t\n\t\t<td class=\'LABEL\' width=\"5%\" >Episode ID</td>\n\t\t<td width=\"10%\" class=\'LABEL\'>\n\t\t\t\t<span id=\'facilityId\' name=\'facilityId\' size=\'3\' readonly >";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\n\t\t</td>\t\t\n\t\t<td class=\'LABEL\' width=\"5%\" >Visit No</td>\n\t\t<td width=\"10%\" class=\'LABEL\'>\n\t\t\t\t<span id=\'facilityId\' name=\'facilityId\' size=\'3\' readonly >";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n\t\t</td>\t\t\n\t</tr>\t\n</table>\n</div>\n<br/>\n<br/>\n\n<div style=\"float:left; width: 99%\">\n<table class=\'grid\' border=\'1\' width=\'100%\' align=\"left\" cellpadding=\'3\'  cellspacing=0 >\n\t\n\t<tr>\n\t<td class=\'COLUMNHEADER\' width=\"2%\" >Status</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"1%\" >Module</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"12%\" >Service Date</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"12%\" >Transaction Date</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"2%\" >Billing Service</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" >Description</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"2%\" >Qty</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"8%\" >Gross Charge</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"8%\" >Discount</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"8%\" >Net Charge</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<tr>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t<td style=\"width: 2%;\">\n\t\t\t<span class=\'Unconfirmed\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n\t\t\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<td style=\"width: 2%;\">\n\t\t\t\t<span class=\'Unprocessed\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\t\t\t\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t<td style=\"width: 2%;\">\n\t\t\t<span class=\'label\'>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</span>\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td class=\'LABEL\' width=\"1%\" id=\'ModuleId";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' >\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\n\t\t</td>\n\t\t<td class=\'LABEL\' width=\"12%\" id=\'BillDate";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\n\t\t</td>\n\t\t<td class=\'LABEL\' width=\"12%\" id=\'TrxDate";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\n\t\t</td>\n\t\t<td class=\'LABEL\' width=\"2%\" id=\'BlngServCode";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\n\t\t</td>\n\t\t<td class=\'LABEL\' width=\"15%\" id= \'BlngServDesc";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\n\t\t</td>\n\t\t\n\t\t<td class=\'LABEL\' width=\"2%\"  id= \'Qty";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  style=\"text-align: right;\">\n\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' width=\"8%\" id=\'tdGrossAmt_";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' style=\"text-align: right;\">  \n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' width=\"8%\" id=\'tdDiscAmt_";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' style=\"text-align: right;\">\n\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' width=\"8%\" id=\'tdNetAmt_";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t</td>\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<tr  colspan=\"7\">\n\t\t<td>\n\t\t\t&nbsp;\n\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t<tr>\n\t\t<td  class=\'LABEL\' colspan=\"7\"  style=\"text-align: right\">\n\t\t\tTotal\n\t\t</td>\n\t\t<td  class=\'LABEL\' width=\"3%\" id=\'tdSumm_Gross\' style=\"text-align: right\">\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</td>\n\t\t<td  class=\'LABEL\' width=\"3%\" id=\'tdSumm_Disc\' style=\"text-align: right\">\n\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</td>\n\t\t<td  class=\'LABEL\'  width=\"3%\" id=\'tdSumm_Net\' style=\"text-align: right\">\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t</td>\n\t</tr>\n</table>\n</div>\n<input type=\'hidden\' name=\'noOfDecimal\'  id=\'noOfDecimal\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);

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
	String locale = (String) session.getValue("LOCALE");
	String episodeId = replaceNull(request.getParameter("episode_id"));	
	String noOfDecimals = request.getParameter("noOfDecimals");	
	String visitId = replaceNull(request.getParameter("visit_id"));
	
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLocale(locale);
	billRequest.setEpisodeType(replaceNull(request.getParameter("episode_type")));
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);	
	
	BillReceiptBC billReceiptBC = new BillReceiptBC();
	HashMap<String,List<BillReceiptUnbillOutst>> unBillServMap = billReceiptBC.getUnBilledEpisodeRequest(billRequest);	
	
	List<BillReceiptUnbillOutst> dtlList = unBillServMap.get("detail");
	List<BillReceiptUnbillOutst> summList = unBillServMap.get("summary");	
	
	BillReceiptUnbillOutst summBean = null;
	if(summList != null && !summList.isEmpty()){
		summBean = summList.get(0);
		if(summBean == null){
			summBean = new BillReceiptUnbillOutst();
		}
	}
	if(dtlList == null){
		dtlList = new ArrayList<BillReceiptUnbillOutst>();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(visitId));
            _bw.write(_wl_block6Bytes, _wl_block6);

	int indx = 1;
	for(BillReceiptUnbillOutst bill:dtlList){ 	

		if(bill == null){
			bill = new BillReceiptUnbillOutst();
		}

		
	
            _bw.write(_wl_block7Bytes, _wl_block7);
if(("N".equals(bill.getConfirmed())) && ("Y".equals(bill.getProcessed()))){
			
			
            _bw.write(_wl_block8Bytes, _wl_block8);
} else if ("N".equals(bill.getProcessed())) {
		
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
			
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(bill.getModuleId() ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bill.getBillDate() ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(replaceNull(bill.getTrxDate()) ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(bill.getBlngServCode() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(replaceNull(bill.getBlngServDesc()) ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bill.getQty() ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(replaceNull(bill.getGrossAmt()) ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(replaceNull(bill.getDiscountAmt() )));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(replaceNull(bill.getNetAmt()) ));
            _bw.write(_wl_block25Bytes, _wl_block25);

	indx++;
	} 
            _bw.write(_wl_block26Bytes, _wl_block26);
if(summBean == null){
		summBean = new BillReceiptUnbillOutst();
	} 
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(summBean.getGrossAmt() ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(summBean.getDiscountAmt() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(summBean.getNetAmt() ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(noOfDecimals ));
            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
