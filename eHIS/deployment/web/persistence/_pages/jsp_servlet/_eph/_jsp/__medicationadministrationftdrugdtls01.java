package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __medicationadministrationftdrugdtls01 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/MedicationAdministrationFTDrugDtls01.jsp", 1742387564192L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \n\t<input type=\"hidden\" name=\"current_date_time\" id=\"current_date_time\"\tvalue=\"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t<input type=\"hidden\" name=\"admin_due_date\" id=\"admin_due_date\"\t\tvalue=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\">\n\t<input type=\"hidden\" name=\"assign_bed_num\" id=\"assign_bed_num\"\t\tvalue=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t<input type=\"hidden\" name=\"disp_locn_code\" id=\"disp_locn_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\">\n\t<input type=\"hidden\" name=\"nursing_unit\" id=\"nursing_unit\"\t\tvalue=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\">\n\t<input type=\"hidden\" name=\"patient_id_selected\" id=\"patient_id_selected\" value=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n\t<input type=\"hidden\" name=\"order_line_no\" id=\"order_line_no\"\t\tvalue=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\t\t\t\n\t<input type=\"hidden\" name=\"row_no\" id=\"row_no\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\t\n\t<input type=\"hidden\" name=\"tot_no_of_records\" id=\"tot_no_of_records\"\tvalue=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\t\n\t<input type=\"hidden\" name=\"non_iv_records\" id=\"non_iv_records\"\t\tvalue=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t<input type=\"hidden\" name=\"alt_non_iv_records\" id=\"alt_non_iv_records\"\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t<input type=\"hidden\" name=\"new_non_iv_records\" id=\"new_non_iv_records\"\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\" name=\"func_mode\" id=\"func_mode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\" name=\"drugCode\" id=\"drugCode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\" name=\"selDateTime\" id=\"selDateTime\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\" name=\"hold_discontinue_yn\" id=\"hold_discontinue_yn\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\" name=\"adr_recorded\" id=\"adr_recorded\"\t\tvalue=\"N\">\n\t<input type=\"hidden\" name=\"admin_recorded\" id=\"admin_recorded\"\t\tvalue=\"N\">\n\t<input type=\"hidden\" name=\"locale\" id=\"locale\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\" name=\"from_time\" id=\"from_time\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t<input type=\"hidden\" name=\"freq_nature\" id=\"freq_nature\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"><!-- Add for SKR-SCF-0304[29563] -->\n\t<input type=\"hidden\" name=\"userAuthPINYN\" id=\"userAuthPINYN\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"><!-- Add for SKR-SCF-0035 [IN029926] -->\n\t<input type=\"hidden\" name=\"admin_from_date\" id=\"admin_from_date\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"><!--added for AAKH-CRF-0024 [IN:038260]-->\n\t<input type=\"hidden\" name=\"admin_to_date\" id=\"admin_to_date\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"><!-- added for AAKH-CRF-0024 [IN:038260]  -->\n\t<input type=\"hidden\" name=\"dob\" id=\"dob\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"> <!--IN066125 -->\n\t<input type=\"hidden\" name=\"isSite_spec_patient_stock\" id=\"isSite_spec_patient_stock\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"> <!-- GHL-CRF-0482-->\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

	System.out.println("==============in==========>MedicationAdministrationFTDrugDtls01.jsp");
	String parvalues=request.getParameter("parvalues");
	String[] arrParValues = parvalues.split("~");	
	
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(arrParValues[0]));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(arrParValues[1]));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(arrParValues[2]));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(arrParValues[3]));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(arrParValues[4]));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(arrParValues[5]));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(arrParValues[6]));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(arrParValues[7]));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(arrParValues[8]));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(arrParValues[9]));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(arrParValues[10]));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(arrParValues[11]));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(arrParValues[12]));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(arrParValues[13]));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(arrParValues[14]));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(arrParValues[15]));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(arrParValues[16]));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(arrParValues[17]));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(arrParValues[18]));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(arrParValues[19]));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(arrParValues[20]));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(arrParValues[21]));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(arrParValues[22]));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(arrParValues[23]));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(arrParValues[24]));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(arrParValues[24]));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(arrParValues[25]));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(arrParValues[26]));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(arrParValues[27]));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(arrParValues[28]));
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
