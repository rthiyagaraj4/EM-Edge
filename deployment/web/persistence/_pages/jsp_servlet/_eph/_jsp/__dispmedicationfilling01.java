package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __dispmedicationfilling01 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationFilling01.jsp", 1709120727364L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\">\t\t\n\t<input type=\"hidden\" name=\"IssueByUOM\" id=\"IssueByUOM\" value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\t\t\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t<input type=\"hidden\" name=\"ValuesChanged\" id=\"ValuesChanged\" value=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type=\"hidden\" name=\"bean_id_1\" id=\"bean_id_1\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\"hidden\" name=\"bean_name_1\" id=\"bean_name_1\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\t\t\t\n\t<input type=\"hidden\" name=\"approval_no\" id=\"approval_no\" value=\"\">\t\t\t\n    <input type=\"hidden\" name=\"pres_qty_alert\" id=\"pres_qty_alert\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\n\n\t\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n\t<input type=\"hidden\" name=\"disp_stage\" id=\"disp_stage\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\" name=\"source_code\" id=\"source_code\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\t<input type=\"hidden\" name=\"source_type\" id=\"source_type\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t<input type=\"hidden\" name=\"ordering_facility_id\" id=\"ordering_facility_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\" name=\"ord_date_time\" id=\"ord_date_time\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"performing_pract_id\" id=\"performing_pract_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"module_id\" id=\"module_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"tot_rec\" id=\"tot_rec\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"curr_stage\" id=\"curr_stage\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\t\n\t\n\t<input type=\"hidden\" name=\"disp_level\" id=\"disp_level\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"disp_locn_catg\" id=\"disp_locn_catg\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"ord_type\" id=\"ord_type\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n\t<input type=\"hidden\" name=\"IncludeZeroQty\" id=\"IncludeZeroQty\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t<input type=\"hidden\" name=\"EquivalentNormalOrder\" id=\"EquivalentNormalOrder\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t<input type=\"hidden\" name=\"tpn_wrksheet_rcrd\" id=\"tpn_wrksheet_rcrd\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\n\t\n\t<input type=\"hidden\" name=\"fill_list\" id=\"fill_list\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"bPatientPaid\" id=\"bPatientPaid\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\t\t\n\t<input type=\"hidden\" name=\"strAutoCompletePartialDisp\" id=\"strAutoCompletePartialDisp\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">  \n\t<input type=\"hidden\" name=\"no_of_decimals\" id=\"no_of_decimals\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"disp_decimal_dtls_yn\" id=\"disp_decimal_dtls_yn\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"> \n\t<input type=\"hidden\" name=\"allow_amend_alt_drug_dtl\" id=\"allow_amend_alt_drug_dtl\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\"> \n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"tpn_mf_label\" id=\"tpn_mf_label\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\"> \n\t<input type=\"hidden\" name=\"displayGrossAmtYn\" id=\"displayGrossAmtYn\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"> \n\t<input type=\"hidden\" name=\"IncludeZeroQtyForIP\" id=\"IncludeZeroQtyForIP\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"intractn_req_yn\" id=\"intractn_req_yn\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"approval_no_flag\" id=\"approval_no_flag\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" name=\"approval_no_app_for_patient_class\" id=\"approval_no_app_for_patient_class\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"finding_remarks_app\" id=\"finding_remarks_app\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\t\n\n\t\t\n\t\t\n\t\t\n\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

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

	System.out.println("==============in==========>DispMedicationFilling01.jsp");
	String parvalues=request.getParameter("parvalues");
	String[] arrParValues = parvalues.split("~");
	String parvalues01=request.getParameter("parvalues01");
	String[] arrParValues01 = parvalues01.split("~");
	String parvalues02=request.getParameter("parvalues02");
	String[] arrParValues02 = parvalues02.split("~");
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(arrParValues02[0]));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(arrParValues02[1]));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues02[2]));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(arrParValues02[3]));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(arrParValues02[4]));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(arrParValues02[5]));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(arrParValues02[6]));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(arrParValues02[7]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(arrParValues02[8]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(arrParValues01[0]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(arrParValues01[1]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(arrParValues01[2]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(arrParValues01[3]));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(arrParValues01[4]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrParValues01[5]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(arrParValues01[6]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(arrParValues01[7]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(arrParValues01[8]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(arrParValues01[9]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(arrParValues01[10]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(arrParValues01[11]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(arrParValues[0]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(arrParValues[1]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(arrParValues[2]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(arrParValues[3]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(arrParValues[4]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(arrParValues[5]));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(arrParValues[6]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(arrParValues[7]));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(arrParValues[8]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(arrParValues[9]));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(arrParValues[10]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(arrParValues[11]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(arrParValues[12]));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(arrParValues[13]));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(arrParValues[14]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(arrParValues[15]));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(arrParValues[16]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(arrParValues[17]));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(arrParValues[18]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(arrParValues[19]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(arrParValues[20]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(arrParValues[21]));
            _bw.write(_wl_block44Bytes, _wl_block44);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
