package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.billreceipt.bc.BillReceiptBC;
import eBL.billreceipt.model.BillReceiptUnbillOutst;
import java.util.List;
import eBL.billreceipt.request.BillReceiptRequest;
import org.apache.commons.codec.binary.Base64;

public final class __billreceiptunbilledepisode extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BillReceiptUnbilledEpisode.jsp", 1737914018037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Total Outstanding Unbilled</title>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'/>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BillReceipt.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n\t$(document).ready(function(){\n\t\tvar noOfDecimals = $(parent.BillReceiptTab.document).find(\'#noOfDecimal\').val();\n\t\t$(\'#noofdeci\').val(noOfDecimals);\n\t\t\n\t\t$(\'[id^=tdGrossAmt_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=tdDiscAmt_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t\t\n\t\t$(\'[id^=tdNetAmt_]\').each(function(){\n\t\t\tif($.trim($(this).text() != \'\')){\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\t\t\t\t\n\t\t\t}\n\t\t\telse{\n\t\t\t\t$(this).text(\'0\');\n\t\t\t\tputDecimal_Text($(this),17,noOfDecimals);\n\t\t\t}\n\t\t});\n\t});\n\t\n</script>\n</head>\n<body>\n<br/>\n<div style=\"float:left; width: 10%\">\n\n</div>\n<div style=\"float:left; width: 90%\">\n<table width=\'30%\' align=\"left\" cellpadding=\'3\'  cellspacing=0 >\n\t\t\t\t\n\t\t\n\t\t<td class=\'LABEL\' width=\"5%\" >Facility ID</td>\n\t\t\n\t\t<td width=\"10%\" class=\'LABEL\'>\n\t\t<span id=\'facilityId\' name=\'facilityId\' size=\'3\' readonly >";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>\n\t\t</td>\n\t\t\n\t\t\t\t\n\t\t\n</table>\n</div>\n<br/>\n<br/>\n<div style=\"float:left; width: 5%\">\n\n</div>\n<div style=\"float:left; width: 95%\">\n<table class=\'grid\' border=\'1\' width=\'70%\' align=\"left\" cellpadding=\'3\'  cellspacing=0 >\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" >Episode Date</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" >Episode Type</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" >Episode No</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"10%\" >Visit</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" >Gross Amt</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" >Disc. Amt</td>\n\t\t<td class=\'COLUMNHEADER\' width=\"15%\" >Net Amt</td>\t\n\t\t\n\t\t<td class=\'COLUMNHEADER\' width=\'15%\' >Unbilled Services</td>\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<tr>\t\t\n\t\t<td class=\'LABEL\'>\n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t</td>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t<td class=\'LABEL\'> <span id=\'episode_type";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t</span>\n\t\t</td>\n\t\t<td class=\'LABEL\'> <span id= \'episode_id";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</span>\n\t\t</td>\n\t\t<td class=\'LABEL\'><span id= \'visit_id";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t</span>\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'tdGrossAmt_";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' style=\"text-align: right;\">\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t</td>\n\t\t\n\t\t<td class=\'LABEL\' id=\'tdDiscAmt_";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t</td>\n\t\t<td class=\'LABEL\' id=\'tdNetAmt_";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</td>\n\t\t<td class = \'button\' id=\'UnbillServReq\'  style=\"text-align: right;\"><a  href=\"javascript:fnUnBillServReq(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\">View</a> \n\t\t</td>\n\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t  value =\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n\t<input type=\"hidden\" name=\"noofdeci\" id=\"noofdeci\"\t value =\'\'>\n\t\n</table>\n</div>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);

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
	BillReceiptRequest billRequest = new BillReceiptRequest();
	billRequest.setPatientId(patientId);
	billRequest.setFacilityId(facilityId);
	BillReceiptBC billReceiptBC = new BillReceiptBC();
	List<BillReceiptUnbillOutst> unbilledEpidose = billReceiptBC.getUnBilledEpisode(billRequest);


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block5Bytes, _wl_block5);

	int indx = 1;
	String episode_type="";
	for(BillReceiptUnbillOutst bill:unbilledEpidose){ 	
		String date = "";
		System.out.println("date="+bill.getTrxDate() );
		if(bill.getTrxDate()== null) {
			date="";
		}else {
			date=bill.getTrxDate();
		}
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(date ));
            _bw.write(_wl_block7Bytes, _wl_block7);
if("O".equals(replaceNull(bill.getEpisodeType()))){
		episode_type="Outpatient";
		}
		else if("I".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="Inpatient";
		}
		else if("D".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="Daycare";
		}
		else if("E".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="Emergency";
		}
		else if("R".equals(replaceNull(bill.getEpisodeType()))){
			episode_type="External";
		}
		
		
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block10Bytes, _wl_block10);
 System.out.println("ghdusy"+bill.getEpisodeType());
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(replaceNull(bill.getEpisodeNo())));
            _bw.write(_wl_block12Bytes, _wl_block12);
System.out.println("ghdusy"+bill.getEpisodeNo()); 
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(replaceNull(bill.getVisitId())
			));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bill.getGrossAmt() ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bill.getDiscountAmt() ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(bill.getNetAmt() ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(indx));
            _bw.write(_wl_block19Bytes, _wl_block19);

	indx++;
	} 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block21Bytes, _wl_block21);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
