package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __addmodifypatfinclassdetailsvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/AddModifyPatFinClassDetailsValidation.jsp", 1709114324926L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<script language=\'javascript\' src=\'../../eBL/js/AddModifyPatFinDetails.js\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar val1 = \"parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t\t\t\tvar val2 = \"parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t\t\t\tvar val3 = \"parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t\t\t\tvar val4 = \"parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t\t\t\tvar val5 = \"parent.parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t\t\t\tvar val6 = \"parent.parent.frames[0].document.forms[0].";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\t\t\t\t\t\teval(val1).value= \"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\";\n\t\t\t\t\t\teval(val2).value= \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\";\n\t\t\t\t\t\teval(val5).value= \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\";\n\t\t\t\t\t\teval(val6).value= \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\";\n\t\t\t\t\t\teval(val3).disabled = true;\n\t\t\t\t\t\teval(val4).disabled = true;\n\t\t\t\t\t </script>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\";\n\t\t\t\t\t\teval(val1).value= \"\";\n\t\t\t\t\t\teval(val2).value= \"\";\n\t\t\t\t\t\teval(val5).value= \"\";\n\t\t\t\t\t\teval(val6).value= \"\";\n\t\t\t\t\t\teval(val3).disabled = false;\n\t\t\t\t\t\teval(val4).disabled = false;\n\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar val1 = \"parent.frames[0].document.forms[0].class_code\";\n\t\t\t\t\tvar val2 = \"parent.frames[0].document.forms[0].class_desc\";\n\t\t\t\t\tvar val3 = \"parent.frames[0].document.forms[0].cash_pay_pat_YN\";\n//\t\t\t\t\tvar val4 = \"parent.frames[0].document.forms[0].remarks\";\n\t\t\t\t\tvar val5 = \"parent.frames[0].document.forms[0].inc_asset_ind\";\n\t\t\t\t\tvar val6 = \"parent.frames[0].document.forms[0].ind_inc\";\n\t\t\t\t\tvar val7 = \"parent.frames[0].document.forms[0].ind_inc_freq\";\n\t\t\t\t\tvar val8 = \"parent.frames[0].document.forms[0].spouse_inc\";\n\t\t\t\t\tvar val9 = \"parent.frames[0].document.forms[0].spouse_inc_freq\";\n\t\t\t\t\tvar val10 = \"parent.frames[0].document.forms[0].dependent_inc\";\n\t\t\t\t\tvar val11 = \"parent.frames[0].document.forms[0].dependent_inc_freq\";\n\t\t\t\t\tvar val12 = \"parent.frames[0].document.forms[0].tot_inc_asset\";\n\t\t\t\t\tvar val13 = \"parent.frames[0].document.forms[0].no_of_dependants\";\n\t\t\t\t\tvar val14 = \"parent.frames[0].document.forms[0].fam_mem_incl_YN\";\n\t\t\t\t\tvar val15 = \"parent.frames[0].document.forms[0].valid_from\";\n\t\t\t\t\tvar val16 = \"parent.frames[0].document.forms[0].valid_to\";\n\t\t\t\t\tvar val17 = \"parent.frames[0].document.forms[0].last_date\";\n\t\t\t\t\tvar val18 = \"parent.frames[0].document.forms[0].social_pensioner_id\";\n\t\t\t\t\tvar val19 = \"parent.frames[0].document.forms[0].blng_grp_id\";\n\t\t\t\t\tvar val20 = \"parent.frames[0].document.forms[0].blng_grp_desc\";\n\n\t\t\t\t\tvar val21 = \"parent.parent.frames[0].document.forms[0].class_code\";\n\t\t\t\t\tvar val22 = \"parent.parent.frames[0].document.forms[0].class_desc\";\n\t\t\t\t\tvar val23 = \"parent.parent.frames[0].document.forms[0].cash_pay_pat_YN\";\n//\t\t\t\t\tvar val24 = \"parent.parent.frames[0].document.forms[0].remarks\";\n\t\t\t\t\tvar val25 = \"parent.parent.frames[0].document.forms[0].inc_asset_ind\";\n\t\t\t\t\tvar val26 = \"parent.parent.frames[0].document.forms[0].ind_inc\";\n\t\t\t\t\tvar val27 = \"parent.parent.frames[0].document.forms[0].ind_inc_freq\";\n\t\t\t\t\tvar val28 = \"parent.parent.frames[0].document.forms[0].spouse_inc\";\n\t\t\t\t\tvar val29 = \"parent.parent.frames[0].document.forms[0].spouse_inc_freq\";\n\t\t\t\t\tvar val30 = \"parent.parent.frames[0].document.forms[0].dependent_inc\";\n\t\t\t\t\tvar val31 = \"parent.parent.frames[0].document.forms[0].dependent_inc_freq\";\n\t\t\t\t\tvar val32 = \"parent.parent.frames[0].document.forms[0].tot_inc_asset\";\n\t\t\t\t\tvar val33 = \"parent.parent.frames[0].document.forms[0].no_of_dependants\";\n\t\t\t\t\tvar val34 = \"parent.parent.frames[0].document.forms[0].fam_mem_incl_YN\";\n\t\t\t\t\tvar val35 = \"parent.parent.frames[0].document.forms[0].valid_from\";\n\t\t\t\t\tvar val36 = \"parent.parent.frames[0].document.forms[0].valid_to\";\n\t\t\t\t\tvar val37 = \"parent.parent.frames[0].document.forms[0].last_date\";\n\t\t\t\t\tvar val38 = \"parent.parent.frames[0].document.forms[0].social_pensioner_id\";\n\t\t\t\t\tvar val39 = \"parent.parent.frames[0].document.forms[0].blng_grp_id\";\n\t\t\t\t\tvar val40 = \"parent.parent.frames[0].document.forms[0].blng_grp_desc\";\n\n\t\t\t\t\tvar val41 = \"parent.frames[0].document.forms[0].class_code_btn\";\n\t\t\t\t\tvar val42 = \"parent.frames[0].document.forms[0].blng_grp_btn\";\n\t\t\t\t\t\n\t\t\t\t\tvar val43 = \"parent.frames[0].document.forms[0].tot_inc_asset\";\n\t\t\t\t\tvar val44 = \"parent.parent.frames[0].document.forms[0].tot_inc_asset\";\n\n\t\t\t\t\teval(val1).value= \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\";\n\t\t\t\t\teval(val2).value= \"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\";\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" == \"C\")\n\t\t\t\t\t\teval(val3).value=\'Y\';\n//\t\t\t\t\teval(val4).value= \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\";\n\t\t\t\t\teval(val5).value= \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\";\n\t\t\t\t\teval(val6).value= \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\";\n\t\t\t\t\teval(val7).value= \"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\";\n\t\t\t\t\teval(val8).value= \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\";\n\t\t\t\t\teval(val9).value= \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\";\n\t\t\t\t\teval(val10).value= \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\";\n\t\t\t\t\teval(val11).value= \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\";\n\t\t\t\t\teval(val12).value= \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\";\n\t\t\t\t\teval(val13).value= \"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\";\n\t\t\t\t\teval(val14).value= \"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\";\n\t\t\t\t\teval(val15).value= \"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\";\n\t\t\t\t\teval(val16).value= \"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\";\n\t\t\t\t\teval(val17).value= \"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\";\n\t\t\t\t\teval(val18).value= \"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\";\n\t\t\t\t\teval(val19).value= \"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\";\n\t\t\t\t\teval(val20).value= \"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\";\n\n\t\t\t\t\teval(val21).value= \"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\";\n\t\t\t\t\teval(val22).value= \"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" == \"C\")\n\t\t\t\t\t\teval(val23).value= \"Y\";\n//\t\t\t\t\teval(val24).value= \"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\";\n\t\t\t\t\teval(val25).value= \"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\";\n\t\t\t\t\teval(val26).value= \"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\";\n\t\t\t\t\teval(val27).value= \"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\";\n\t\t\t\t\teval(val28).value= \"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\";\n\t\t\t\t\teval(val29).value= \"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\";\n\t\t\t\t\teval(val30).value= \"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\";\n\t\t\t\t\teval(val31).value= \"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\";\n\t\t\t\t\teval(val32).value= \"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\";\n\t\t\t\t\teval(val33).value= \"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\";\n\t\t\t\t\teval(val34).value= \"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\";\n\t\t\t\t\teval(val35).value= \"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\";\n\t\t\t\t\teval(val36).value= \"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\";\n\t\t\t\t\teval(val37).value= \"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\";\n\t\t\t\t\teval(val38).value= \"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\";\n\t\t\t\t\teval(val39).value= \"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\";\n\t\t\t\t\teval(val40).value= \"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\";\n//Commented V170512-Gayathri/GDOH-SCF-0277/Start\n\t\t\t\t/*\teval(val2).disabled = true;\n\t\t\t\t\teval(val3).disabled = true;\n//\t\t\t\t\teval(val4).disabled = false;\n\t\t\t\t\teval(val5).disabled = true;\n\t\t\t\t\teval(val6).disabled = true;\n\t\t\t\t\teval(val7).disabled = true;\n\t\t\t\t\teval(val8).disabled = true;\n\t\t\t\t\teval(val9).disabled = true;\n\t\t\t\t\teval(val10).disabled = true;\n\t\t\t\t\teval(val11).disabled = true;\n\t\t\t\t\teval(val12).disabled = true;\n\t\t\t\t\teval(val13).disabled = true;\n\t\t\t\t\teval(val15).disabled = true;*/\n//\t\t\t\t\teval(val16).disabled = true;\n\t\t\t\t//\teval(val18).disabled = false;\n\t\t\t\t\teval(val20).disabled = true;\n\t\t\t\t/*\teval(val41).disabled = true;\n\t\t\t\t\teval(val42).disabled = true;*/\n\t\t\t\t\t//Commented V170512-Gayathri/GDOH-SCF-0277/End\n\t\t\t\t\tparent.frames[0].calcTotalInc();\n\n\t\t\t\t </script>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t<script>\n\t\t\t\t\tvar val1 = \"parent.frames[0].document.forms[0].class_code\";\n\t\t\t\t\tvar val2 = \"parent.frames[0].document.forms[0].class_desc\";\n\t\t\t\t\tvar val3 = \"parent.frames[0].document.forms[0].cash_pay_pat_YN\";\n//\t\t\t\t\tvar val4 = \"parent.frames[0].document.forms[0].remarks\";\n\t\t\t\t\tvar val5 = \"parent.frames[0].document.forms[0].inc_asset_ind\";\n\t\t\t\t\tvar val6 = \"parent.frames[0].document.forms[0].ind_inc\";\n\t\t\t\t\tvar val7 = \"parent.frames[0].document.forms[0].ind_inc_freq\";\n\t\t\t\t\tvar val8 = \"parent.frames[0].document.forms[0].spouse_inc\";\n\t\t\t\t\tvar val9 = \"parent.frames[0].document.forms[0].spouse_inc_freq\";\n\t\t\t\t\tvar val10 = \"parent.frames[0].document.forms[0].dependent_inc\";\n\t\t\t\t\tvar val11 = \"parent.frames[0].document.forms[0].dependent_inc_freq\";\n\t\t\t\t\tvar val12 = \"parent.frames[0].document.forms[0].tot_inc_asset\";\n\t\t\t\t\tvar val13 = \"parent.frames[0].document.forms[0].no_of_dependants\";\n\t\t\t\t\tvar val14 = \"parent.frames[0].document.forms[0].fam_mem_incl_YN\";\n\t\t\t\t\tvar val15 = \"parent.frames[0].document.forms[0].valid_from\";\n\t\t\t\t\tvar val16 = \"parent.frames[0].document.forms[0].valid_to\";\n\t\t\t\t\tvar val17 = \"parent.frames[0].document.forms[0].last_date\";\n\t\t\t\t\tvar val18 = \"parent.frames[0].document.forms[0].social_pensioner_id\";\n\t\t\t\t\tvar val19 = \"parent.frames[0].document.forms[0].blng_grp_id\";\n\t\t\t\t\tvar val20 = \"parent.frames[0].document.forms[0].blng_grp_desc\";\n\n\t\t\t\t\tvar val21 = \"parent.parent.frames[0].document.forms[0].class_code\";\n\t\t\t\t\tvar val22 = \"parent.parent.frames[0].document.forms[0].class_desc\";\n\t\t\t\t\tvar val23 = \"parent.parent.frames[0].document.forms[0].cash_pay_pat_YN\";\n//\t\t\t\t\tvar val24 = \"parent.parent.frames[0].document.forms[0].remarks\";\n\t\t\t\t\tvar val25 = \"parent.parent.frames[0].document.forms[0].inc_asset_ind\";\n\t\t\t\t\tvar val26 = \"parent.parent.frames[0].document.forms[0].ind_inc\";\n\t\t\t\t\tvar val27 = \"parent.parent.frames[0].document.forms[0].ind_inc_freq\";\n\t\t\t\t\tvar val28 = \"parent.parent.frames[0].document.forms[0].spouse_inc\";\n\t\t\t\t\tvar val29 = \"parent.parent.frames[0].document.forms[0].spouse_inc_freq\";\n\t\t\t\t\tvar val30 = \"parent.parent.frames[0].document.forms[0].dependent_inc\";\n\t\t\t\t\tvar val31 = \"parent.parent.frames[0].document.forms[0].dependent_inc_freq\";\n\t\t\t\t\tvar val32 = \"parent.parent.frames[0].document.forms[0].tot_inc_asset\";\n\t\t\t\t\tvar val33 = \"parent.parent.frames[0].document.forms[0].no_of_dependants\";\n\t\t\t\t\tvar val34 = \"parent.parent.frames[0].document.forms[0].fam_mem_incl_YN\";\n\t\t\t\t\tvar val35 = \"parent.parent.frames[0].document.forms[0].valid_from\";\n\t\t\t\t\tvar val36 = \"parent.parent.frames[0].document.forms[0].valid_to\";\n\t\t\t\t\tvar val37 = \"parent.parent.frames[0].document.forms[0].last_date\";\n\t\t\t\t\tvar val38 = \"parent.parent.frames[0].document.forms[0].social_pensioner_id\";\n\t\t\t\t\tvar val39 = \"parent.parent.frames[0].document.forms[0].blng_grp_id\";\n\t\t\t\t\tvar val40 = \"parent.parent.frames[0].document.forms[0].blng_grp_desc\";\n\n\t\t\t\t\tvar val41 = \"parent.frames[0].document.forms[0].class_code_btn\";\n\t\t\t\t\tvar val42 = \"parent.frames[0].document.forms[0].blng_grp_btn\";\n\n\t\t\t\t\teval(val1).value= \"\";\n\t\t\t\t\teval(val2).value= \"\";\n\t\t\t\t\teval(val3).value=\"N\";\n//\t\t\t\t\teval(val4).value= \"\";\n\t\t\t\t\teval(val5).value= \"\";\n\t\t\t\t\teval(val6).value= \"\";\n\t\t\t\t\teval(val7).value= \"\";\n\t\t\t\t\teval(val8).value= \"\";\n\t\t\t\t\teval(val9).value= \"\";\n\t\t\t\t\teval(val10).value= \"\";\n\t\t\t\t\teval(val11).value= \"\";\n\t\t\t\t\teval(val12).value= \"\";\n\t\t\t\t\teval(val13).value= \"\";\n\t\t\t\t\teval(val14).value= \"\";\n\t//\t\t\t\teval(val15).value= \"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\";\n\t//\t\t\t\teval(val16).value= \"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\";\n\t//\t\t\t\teval(val17).value= \"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\";\n\t\t\t\t\teval(val18).value= \"\";\n\t\t\t\t\teval(val19).value= \"\";\n\t\t\t\t\teval(val20).value= \"\";\n\n\t\t\t\t\teval(val21).value= \"\";\n\t\t\t\t\teval(val22).value= \"\";\n\t\t\t\t\teval(val23).value= \"\";\n//\t\t\t\t\teval(val24).value= \"\";\n\t\t\t\t\teval(val25).value= \"\";\n\t\t\t\t\teval(val26).value= \"\";\n\t\t\t\t\teval(val27).value= \"\";\n\t\t\t\t\teval(val28).value= \"\";\n\t\t\t\t\teval(val29).value= \"\";\n\t\t\t\t\teval(val30).value= \"\";\n\t\t\t\t\teval(val31).value= \"\";\n\t\t\t\t\teval(val32).value= \"\";\n\t\t\t\t\teval(val33).value= \"\";\n\t\t\t\t\teval(val34).value= \"\";\n\t//\t\t\t\teval(val35).value= \"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\";\n\t//\t\t\t\teval(val36).value= \"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\";\n\t//\t\t\t\teval(val37).value= \"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\";\n\t\t\t\t\teval(val38).value= \"\";\n\t\t\t\t\teval(val39).value= \"\";\n\t\t\t\t\teval(val40).value= \"\";\n\n\t\t\t\t\teval(val2).disabled = false;\n\t\t\t\t\teval(val3).disabled = false;\n//\t\t\t\t\teval(val4).disabled = false;\n\t\t\t\t\teval(val5).disabled = false;\n\t\t\t\t\teval(val6).disabled = false;\n\t\t\t\t\teval(val7).disabled = false;\n\t\t\t\t\teval(val8).disabled = false;\n\t\t\t\t\teval(val9).disabled = false;\n\t\t\t\t\teval(val10).disabled = false;\n\t\t\t\t\teval(val11).disabled = false;\n\t\t\t\t\teval(val12).disabled = false;\n\t\t\t\t\teval(val13).disabled = false;\n\t\t\t\t\teval(val15).disabled = false;\n//\t\t\t\t\teval(val16).disabled = true;\n\t\t\t\t\teval(val18).disabled = false;\n\t\t\t\t\teval(val20).disabled = false;\n\n\t\t\t\t\teval(val41).disabled = false;\n\t\t\t\t\teval(val42).disabled = false;\n\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\tvar val1 = \"parent.frames[0].document.forms[0].class_code\";\n\t\t\t\t\tvar val2 = \"parent.frames[0].document.forms[0].class_desc\";\n\t\t\t\t\tvar val3 = \"parent.frames[0].document.forms[0].cash_pay_pat_YN\";\n//\t\t\t\t\tvar val4 = \"parent.frames[0].document.forms[0].remarks\";\n\t\t\t\t\tvar val5 = \"parent.frames[0].document.forms[0].inc_asset_ind\";\n\t\t\t\t\tvar val6 = \"parent.frames[0].document.forms[0].ind_inc\";\n\t\t\t\t\tvar val7 = \"parent.frames[0].document.forms[0].ind_inc_freq\";\n\t\t\t\t\tvar val8 = \"parent.frames[0].document.forms[0].spouse_inc\";\n\t\t\t\t\tvar val9 = \"parent.frames[0].document.forms[0].spouse_inc_freq\";\n\t\t\t\t\tvar val10 = \"parent.frames[0].document.forms[0].dependent_inc\";\n\t\t\t\t\tvar val11 = \"parent.frames[0].document.forms[0].dependent_inc_freq\";\n\t\t\t\t\tvar val12 = \"parent.frames[0].document.forms[0].tot_inc_asset\";\n\t\t\t\t\tvar val13 = \"parent.frames[0].document.forms[0].no_of_dependants\";\n\t\t\t\t\tvar val14 = \"parent.frames[0].document.forms[0].fam_mem_incl_YN\";\n\t\t\t\t\tvar val15 = \"parent.frames[0].document.forms[0].valid_from\";\n\t\t\t\t\tvar val16 = \"parent.frames[0].document.forms[0].valid_to\";\n\t\t\t\t\tvar val17 = \"parent.frames[0].document.forms[0].last_date\";\n\t\t\t\t\tvar val18 = \"parent.frames[0].document.forms[0].social_pensioner_id\";\n\t\t\t\t\tvar val19 = \"parent.frames[0].document.forms[0].blng_grp_id\";\n\t\t\t\t\tvar val20 = \"parent.frames[0].document.forms[0].blng_grp_desc\";\n\n\t\t\t\t\tvar val21 = \"parent.parent.frames[0].document.forms[0].class_code\";\n\t\t\t\t\tvar val22 = \"parent.parent.frames[0].document.forms[0].class_desc\";\n\t\t\t\t\tvar val23 = \"parent.parent.frames[0].document.forms[0].cash_pay_pat_YN\";\n//\t\t\t\t\tvar val24 = \"parent.parent.frames[0].document.forms[0].remarks\";\n\t\t\t\t\tvar val25 = \"parent.parent.frames[0].document.forms[0].inc_asset_ind\";\n\t\t\t\t\tvar val26 = \"parent.parent.frames[0].document.forms[0].ind_inc\";\n\t\t\t\t\tvar val27 = \"parent.parent.frames[0].document.forms[0].ind_inc_freq\";\n\t\t\t\t\tvar val28 = \"parent.parent.frames[0].document.forms[0].spouse_inc\";\n\t\t\t\t\tvar val29 = \"parent.parent.frames[0].document.forms[0].spouse_inc_freq\";\n\t\t\t\t\tvar val30 = \"parent.parent.frames[0].document.forms[0].dependent_inc\";\n\t\t\t\t\tvar val31 = \"parent.parent.frames[0].document.forms[0].dependent_inc_freq\";\n\t\t\t\t\tvar val32 = \"parent.parent.frames[0].document.forms[0].tot_inc_asset\";\n\t\t\t\t\tvar val33 = \"parent.parent.frames[0].document.forms[0].no_of_dependants\";\n\t\t\t\t\tvar val34 = \"parent.parent.frames[0].document.forms[0].fam_mem_incl_YN\";\n\t\t\t\t\tvar val35 = \"parent.parent.frames[0].document.forms[0].valid_from\";\n\t\t\t\t\tvar val36 = \"parent.parent.frames[0].document.forms[0].valid_to\";\n\t\t\t\t\tvar val37 = \"parent.parent.frames[0].document.forms[0].last_date\";\n\t\t\t\t\tvar val38 = \"parent.parent.frames[0].document.forms[0].social_pensioner_id\";\n\t\t\t\t\tvar val39 = \"parent.parent.frames[0].document.forms[0].blng_grp_id\";\n\t\t\t\t\tvar val40 = \"parent.parent.frames[0].document.forms[0].blng_grp_desc\";\n\n\t\t\t\t\tvar val41 = \"parent.frames[0].document.forms[0].class_code_btn\";\n\t\t\t\t\tvar val42 = \"parent.frames[0].document.forms[0].blng_grp_btn\";\n\n\t\t\t\t\teval(val1).value= \"\";\n\t\t\t\t\teval(val2).value= \"\";\n\t\t\t\t\teval(val3).value=\"N\";\n//\t\t\t\t\teval(val4).value= \"\";\n\t\t\t\t\teval(val5).value= \"\";\n\t\t\t\t\teval(val6).value= \"\";\n\t\t\t\t\teval(val7).value= \"\";\n\t\t\t\t\teval(val8).value= \"\";\n\t\t\t\t\teval(val9).value= \"\";\n\t\t\t\t\teval(val10).value= \"\";\n\t\t\t\t\teval(val11).value= \"\";\n\t\t\t\t\teval(val12).value= \"\";\n\t\t\t\t\teval(val13).value= \"\";\n\t\t\t\t\teval(val14).value= \"\";\n\t//\t\t\t\teval(val15).value= \"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\";\n\t\t\t\t\teval(val38).value= \"\";\n\t\t\t\t\teval(val39).value= \"\";\n\t\t\t\t\teval(val40).value= \"\";\n\n\t\t\t\t\teval(val2).disabled = false;\n\t\t\t\t\teval(val3).disabled = false;\n//\t\t\t\t\teval(val4).disabled = false;\n\t\t\t\t\teval(val5).disabled = false;\n\t\t\t\t\teval(val6).disabled = false;\n\t\t\t\t\teval(val7).disabled = false;\n\t\t\t\t\teval(val8).disabled = false;\n\t\t\t\t\teval(val9).disabled = false;\n\t\t\t\t\teval(val10).disabled = false;\n\t\t\t\t\teval(val11).disabled = false;\n\t\t\t\t\teval(val12).disabled = false;\n\t\t\t\t\teval(val13).disabled = false;\n\t\t\t\t\teval(val15).disabled = false;\n//\t\t\t\t\teval(val16).disabled = true;\n\t\t\t\t\teval(val18).disabled = false;\n\t\t\t\t\teval(val20).disabled = false;\n\n\t\t\t\t\teval(val41).disabled = false;\n\t\t\t\t\teval(val42).disabled = false;\n\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n</head>\n</html>\n\n";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

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
 
	Connection con = ConnectionManager.getConnection();
try
{
	PreparedStatement pstmt = null;
	ResultSet rs = null;
//	String  params		=  (String) session.getValue("params");
	HttpSession httpSession = request.getSession(false);
	String facilityId =  (String)httpSession.getValue("facility_id");
	if(facilityId == null) facilityId="";
	String locale			= (String)session.getAttribute("LOCALE");

	System.err.println("Inside the Class Validation Page");
	String called_for = request.getParameter("called_for") == null ? "" :  request.getParameter("called_for");
	String strModuleId = request.getParameter("strModuleId") == null ? "" :  request.getParameter("strModuleId");
	String siteSpec = request.getParameter("siteSpec") == null ? "" :  request.getParameter("siteSpec");
	
	System.err.println("siteSpec "+siteSpec);


	if(called_for.equals("def_blng_grp_id"))
	{
		String  sql = request.getParameter("sql") == null ? "" : request.getParameter("sql");
		sql = sql.replace('`','\'') ;

		String code  = "";
		String desc  = "";
		String codeField  = request.getParameter("codeField") == null ? "" :  request.getParameter("codeField");
		String descField  = request.getParameter("descField") == null ? "" :  request.getParameter("descField");
		String buttonField  = request.getParameter("buttonField") == null ? "" :  request.getParameter("buttonField");

		boolean flag = false;

		if(!sql.equals(""))
		{
			try
			{	
//				System.err.println("sql:"+sql);

				pstmt = con.prepareStatement(sql);
				rs = pstmt.executeQuery();
				if(rs.next())
				{
					code = rs.getString(1);
					desc = rs.getString(2);
					flag = true;
				}
				else
				{
					flag = false;
				}
			}
			catch(Exception e)
			{
				System.err.println("Exception from query:"+e );
			}
			finally
			{
				if (pstmt!=null) pstmt.close();
				if (rs!=null)	 rs.close();
			}
//			System.err.println("code:"+code);
//			System.err.println("desc:"+desc);

			if(flag)
			{ 
					/* if (!strModuleId.equals("OP"))
				{ 
 */
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(codeField));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(descField));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(buttonField));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(descField));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(codeField));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(descField));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

				//}
				System.err.println("Assigning to head fields");
			}
			else
			{

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(codeField));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(descField));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(buttonField));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(descField));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(codeField));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(descField));
            _bw.write(_wl_block17Bytes, _wl_block17);

			}
		}
	}
	else if(called_for.equals("enc_level_def_IA_class_dtls"))
	{
		String curr_class_type = request.getParameter("class_type") == null ? "" : request.getParameter("class_type");
//		String curr_class_code = request.getParameter("class_code") == null ? "" : request.getParameter("class_code");
		String billing_mode = request.getParameter("billing_mode") == null ? "" : request.getParameter("billing_mode");
		String operation =  request.getParameter("operation") == null? "" :request.getParameter("operation");
		String patient_id = request.getParameter("patient_id") == null ? "" : request.getParameter("patient_id");
		String blng_grp_id = "", blng_grp_desc = "", slmt_ind="", class_type = "", class_code = "", class_desc = "", remarks = "", social_pensioner_id = "";
		String inc_asset_ind = "", ind_inc = "", ind_inc_freq = "", spouse_inc = "", spouse_inc_freq = "", dependent_inc = "";
		String dependent_inc_freq = "", tot_inc_asset = "", no_of_dependants = "", fam_mem_incl_YN="N";
		String valid_from = "", valid_to = "", last_date = "", annual_income="",family_asset="";
		String sql="";
		int assessmentMonths=0;
//		int temp_total_inc = 0;

		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			/*HashMap bl_data=(HashMap)session.getAttribute("financial_details");
			System.err.println("Financial Session value in validation:"+bl_data);
			if(!(bl_data==null || bl_data.isEmpty()))
			{
				System.err.println("Session Values Found");
				blng_grp_id=((String)bl_data.get("blng_grp")).trim();
				if(blng_grp_id == null) blng_grp_id="";

				slmt_ind=((String)bl_data.get("slmt_ind")).trim();
				if(slmt_ind == null) slmt_ind="";

				class_type=((String)bl_data.get("class_type")).trim();
				if(class_type == null) class_type="";

				class_code=((String)bl_data.get("class_code")).trim();
				if(class_code == null) class_code="";

				remarks=((String)bl_data.get("fin_remarks")).trim();
				if(remarks == null) remarks="";

				inc_asset_ind=((String)bl_data.get("inc_asset_ind")).trim();
				if(inc_asset_ind == null) inc_asset_ind="";

				ind_inc=((String)bl_data.get("ind_inc")).trim();
				if(ind_inc == null) ind_inc="";

				ind_inc_freq=((String)bl_data.get("ind_inc_freq")).trim();
				if(ind_inc_freq == null) ind_inc_freq="";

				spouse_inc=((String)bl_data.get("spouse_inc")).trim();
				if(spouse_inc == null) spouse_inc="";

				spouse_inc_freq=((String)bl_data.get("spouse_inc_freq")).trim();
				if(spouse_inc_freq == null) spouse_inc_freq="";

				dependent_inc=((String)bl_data.get("dependent_inc")).trim();
				if(dependent_inc == null) dependent_inc="";

				dependent_inc_freq=((String)bl_data.get("dependent_inc_freq")).trim();
				if(dependent_inc_freq == null) dependent_inc_freq="";

				no_of_dependants=((String)bl_data.get("no_of_dependants")).trim();
				if(no_of_dependants == null) no_of_dependants="";

				valid_from=((String)bl_data.get("valid_from")).trim();
				if(valid_from == null) valid_from="";

				valid_to=((String)bl_data.get("valid_to")).trim();
				if(valid_to == null) valid_to="";

				last_date=((String)bl_data.get("last_date")).trim();
				if(last_date == null) last_date="";

				social_pensioner_id=((String)bl_data.get("social_pensioner_id")).trim();
				if(social_pensioner_id == null) social_pensioner_id="";
			}
			else
			{*/
//				System.err.println("Session Values Not Found:"+patient_id);
				if(!patient_id.equals(""))
				{
					try
					{
						String sql_mp_level_class_dtls = "select BLNG_GRP_ID,SETTLEMENT_IND,CLASSIFICATION_TYPE,CLASSIFICATION_CODE,FINANCIAL_REMARKS,PATIENT_INC_ASSET_IND,PATIENT_INC_ASSET_AMT,PATIENT_INC_ASSET_FREQ,SPOUSE_INC_ASSET_AMT,SPOUSE_INC_ASSET_FREQ,DEPENDENT_INC_ASSET_AMT,DEPENDENT_INC_ASSET_FREQ,NUM_OF_DEPENDENTS,to_char(CLASSIFICATION_START_DATE,'DD/MM/YYYY'),to_char(CLASSIFICATION_END_DATE,'DD/MM/YYYY'),SOCIAL_PENSIONER_ID,ANNUAL_FAMILY_INCOME,FAMILY_ASSETS_VALUE from bl_patient_fin_dtls where patient_id=?";
//						System.err.println("sql_mp_level_class_dtls:"+sql_mp_level_class_dtls);
						pstmt = con.prepareStatement(sql_mp_level_class_dtls);
						pstmt.setString(1, patient_id);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							blng_grp_id=rs.getString(1);
							if(blng_grp_id == null) blng_grp_id="";

							slmt_ind=rs.getString(2);
							if(slmt_ind == null) slmt_ind="";

							class_type=rs.getString(3);
							if(class_type == null) class_type="";

							class_code=rs.getString(4);
							if(class_code == null) class_code="";

							remarks=rs.getString(5);
							if(remarks == null) remarks="";

							inc_asset_ind=rs.getString(6);
							if(inc_asset_ind == null) inc_asset_ind="";

							ind_inc=rs.getString(7);
							if(ind_inc == null) ind_inc="";

							ind_inc_freq=rs.getString(8);
							if(ind_inc_freq == null) ind_inc_freq="";

							spouse_inc=rs.getString(9);
							if(spouse_inc == null) spouse_inc="";

							spouse_inc_freq=rs.getString(10);
							if(spouse_inc_freq == null) spouse_inc_freq="";

							dependent_inc=rs.getString(11);
							if(dependent_inc == null) dependent_inc="";

							dependent_inc_freq=rs.getString(12);
							if(dependent_inc_freq == null) dependent_inc_freq="";

							no_of_dependants=rs.getString(13);
							if(no_of_dependants == null) no_of_dependants="";

							valid_from=rs.getString(14);
							if(valid_from == null) valid_from="";

							valid_to=rs.getString(15);
							if(valid_to == null) valid_to="";

							social_pensioner_id=rs.getString(16);
							if(social_pensioner_id == null) social_pensioner_id="";

							annual_income = rs.getString(17);
							if(annual_income == null) annual_income="";

							family_asset = rs.getString(18);
							if(family_asset == null) family_asset="";

							if(inc_asset_ind.equals("I"))
							{
								tot_inc_asset = annual_income;
							}
							else if(inc_asset_ind.equals("A"))
							{
								tot_inc_asset = family_asset;
							}
						}
					}
					catch(Exception e)
					{
						System.err.println("Exception from query:"+e );
					}
					finally
					{
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();
					}

					try
					{
						String sql_assesement = "SELECT ASSESSMENT_MONTHS FROM BL_PARAMETERS WHERE OPERATING_FACILITY_ID =?";
						
						pstmt = con.prepareStatement(sql_assesement);
						pstmt.setString(1,facilityId);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							assessmentMonths = rs.getInt("ASSESSMENT_MONTHS");
						}
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();

//						System.err.println("assessmentMonths:"+assessmentMonths);

						String sql_last_date = "SELECT to_char(add_months(to_date('"+valid_from+"','DD/MM/YYYY'),"+assessmentMonths+"),'dd/mm/yyyy') LAST_DATE FROM DUAL";

						pstmt = con.prepareStatement(sql_last_date);
						rs = pstmt.executeQuery();
						if(rs.next())
						{
							last_date = rs.getString("LAST_DATE");
						}
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();
//						System.err.println("last_date :"+last_date);

						if(last_date == null) last_date="";
					}
					catch(Exception e)
					{
						System.err.println("Exception from query:"+e );
					}
					finally
					{
						if (pstmt!=null) pstmt.close();
						if (rs!=null)	 rs.close();
					}
				}
	//		}
		}

		if(billing_mode.equals("Modify") || operation.equals("Update"))
		{
			if(!class_code.equals(""))
			{
				sql = "SELECT SHORT_DESC CLASSIFICATION_DESC,NVL(INCL_FAMILY_YN,'N') INCL_FAMILY_YN FROM BL_CLASSFCTN_CODE_LANG_VW WHERE CLASSIFICATION_CODE = ? AND LANGUAGE_ID = ?";
				try
				{
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,class_code);
					pstmt.setString(2,locale);
					rs = pstmt.executeQuery();
					if(rs.next())
					{
						class_desc = rs.getString("CLASSIFICATION_DESC");
						fam_mem_incl_YN = rs.getString("INCL_FAMILY_YN");
					}
				}
				catch(Exception e)
				{
					System.err.println("Exception from CLASSIFICATION_DESC:"+e );
				}
				finally
				{
					if (pstmt!=null) pstmt.close();
					if (rs!=null)	 rs.close();
				}
				if(class_desc == null) class_desc="";
//				System.err.println("class_desc in validation:"+class_desc);
//				System.err.println("fam_mem_incl_YN in validation:"+fam_mem_incl_YN);
			}
			if(!blng_grp_id.equals(""))
			{
				sql = "SELECT SHORT_DESC BILLING_DESC FROM BL_BLNG_GRP_LANG_VW WHERE BLNG_GRP_ID=? AND LANGUAGE_ID = ?";
				try
				{
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,blng_grp_id);
					pstmt.setString(2,locale);
					rs = pstmt.executeQuery();
					if(rs.next())
						blng_grp_desc = rs.getString("BILLING_DESC");
				}
				catch(Exception e)
				{
					System.err.println("Exception from BILLING_DESC:"+e );
				}
				finally
				{
					if (pstmt!=null) pstmt.close();
					if (rs!=null)	 rs.close();
				}
				if(blng_grp_desc == null) blng_grp_desc="";
//				System.err.println("blng_grp_desc:"+blng_grp_desc);
			}
		}

		if(class_type.equals("IA") && curr_class_type.equals("IA"))
		{
			System.err.println("Inside IA");
			if (!strModuleId.equals("MP"))
			{ 

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(class_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(ind_inc));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(spouse_inc));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dependent_inc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(tot_inc_asset));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(no_of_dependants));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(fam_mem_incl_YN));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(social_pensioner_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(class_code));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(class_desc));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(slmt_ind));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(remarks));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(inc_asset_ind));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(ind_inc));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(ind_inc_freq));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(spouse_inc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(spouse_inc_freq));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(dependent_inc));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dependent_inc_freq));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(tot_inc_asset));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(no_of_dependants));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(fam_mem_incl_YN));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(social_pensioner_id));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(blng_grp_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(blng_grp_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);

			}
		}
		else
		{
			System.err.println("Inside non IA");
			if (!strModuleId.equals("MP"))
			{
				if(siteSpec.equals("true")){
					if(!(strModuleId.equals("OP")||strModuleId.equals("AE"))){

            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block64Bytes, _wl_block64);

				 }
				}
				else{
					
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(valid_from));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(valid_to));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(last_date));
            _bw.write(_wl_block66Bytes, _wl_block66);
 
				}
			}
		}
	}
}
catch(Exception e)
{
	System.err.println("Main Exception in class validation:"+e);
	out.println(e);
}
finally
{
	ConnectionManager.returnConnection(con, request);
}

            _bw.write(_wl_block67Bytes, _wl_block67);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
