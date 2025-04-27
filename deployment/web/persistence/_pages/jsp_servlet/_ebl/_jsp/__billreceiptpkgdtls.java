package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.model.BillReceiptPackageInfo;
import java.util.List;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.request.BillReceiptRequest;

public final class __billreceiptpkgdtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptPkgDtls.jsp", 1737913853650L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Package Folio Window</title>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\"javascript\" src=\"../../eBL/js/BillReceipt.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script>\nvar noOfDecimal=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t$(document).ready(function(){\n\t\t$(\'#close\').click(function(){\n\t\t\twindow.close();\n\t\t});\n\t\t\n\t\t\n\t\t$(\'[id^=gross_amt]\').each(function(){\n\t\t\t\t\n\t\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\t\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(this).text(\'0\');\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\n\t\t\t\t}\n\t\t\t});\n\t\t$(\'[id^=disc_amt]\').each(function(){\n\t\t\t\t\n\t\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\t\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse{\n\t\t\t\t\t$(this).text(\'0\');\n\t\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\n\t\t\t\t}\n\t\t\t});\n\t\t$(\'[id^=net_amt]\').each(function(){\n\t\t\t\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\t\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimal);\n\t\t\t}\n\t\t});\n\t});\n</script>\n</head>\n<body>\n\t<br/>\n\t<table class=\'grid\' border=\'1\' width=\'100%\' align=\"center\" cellpadding=\'3\'  cellspacing=0 >\n\t\t\n\t\t<tr>\n\t\t\t<td class=\'COLUMNHEADER\' width=\"7%\" >Episode Type</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\"7%\" >Episode Id</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\"8%\" >Package Code</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\"12%\" >Package Description</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\"10%\" >Billing Service</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\"12%\" >Service Description</td>\n\t\t\t<td class=\'COLUMNHEADER\' width=\"7%\" >Gross Amount</td>\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\"7%\" >Disc Amount</td>\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\"7%\" >Net Amount</td>\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\"7%\" >Priority</td>\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\"8%\" >Blng Grp Id</td>\t\n\t\t\t<td class=\'COLUMNHEADER\' width=\"8%\" >Customer</td>\t\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<tr>\t\t\t\t\t\n\t\t\t<td class=\'LABEL\'>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\'>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t</td>\t\t\t\n\t\t\t<td class=\'LABEL\'>\n\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\'LABEL\'>\n\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\' id=\'gross_amt\'>\n\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\' id=\'disc_amt\'>\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\' id=\'net_amt\'>\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\'LABEL\'>\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t\t<td class=\'LABEL\'>\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</td>\n\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\n\t\t</table>\n\t\t<br/>\n\t<br/>\n\t\t<table align=\"right\">\n\t\t<tr></tr>\n\t\t<tr></tr>\n\t\t\t<td colspan=\"12\" align=\"right\">\t\t\t\t\n\t\t\t\t<input type=\'button\' class=\'button\' name=\'close\' id=\'close\' id=\'close\' value=\'Close\'>\n\t\t\t</td>\n\t\t\n\t</table>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css"; 
	
	String patientId = replaceNull(request.getParameter("patient_id"));
	String episodeType = replaceNull(request.getParameter("episode_type"));
	String episodeId = replaceNull(request.getParameter("episode_id"));
	String visitId = replaceNull(request.getParameter("visit_id"));
	String facilityId = (String) session.getValue("facility_id");
	String noOfDecimal = replaceNull(request.getParameter("noOfDecimal"));
	String locale = (String) session.getValue("LOCALE");
	
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setEpisodeType(episodeType);
	billRequest.setEpisodeId(episodeId);
	billRequest.setVisitId(visitId);
	billRequest.setFacilityId(facilityId);
	billRequest.setLocale(locale);

	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptPackageInfo>  pkgInfoList = billReceiptBC.getPackageDtls(billRequest);

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(noOfDecimal));
            _bw.write(_wl_block5Bytes, _wl_block5);

		int indx = 1;
		for(BillReceiptPackageInfo pkgInfo:pkgInfoList){ 	
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(pkgInfo.getEpisodeType() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(replaceNull(pkgInfo.getEpisodeId()) ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(pkgInfo.getPackageCode() ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(pkgInfo.getPackageDesc() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pkgInfo.getBlngServCode()));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(pkgInfo.getBlngServDesc()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(pkgInfo.getGrossAmt() ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(pkgInfo.getDiscAmt() ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(pkgInfo.getNetAmt() ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(pkgInfo.getBlngGrpId() ));
            _bw.write(_wl_block7Bytes, _wl_block7);
if("".equals(replaceNull(pkgInfo.getCustDes()))){ 
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(replaceNull(pkgInfo.getCustDes()) ));
            _bw.write(_wl_block15Bytes, _wl_block15);
} 
            _bw.write(_wl_block16Bytes, _wl_block16);

		indx++;
		} 
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
