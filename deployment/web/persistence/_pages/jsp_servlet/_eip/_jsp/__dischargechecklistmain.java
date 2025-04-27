package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dischargechecklistmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DischargeCheckListMain.jsp", 1720004752334L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html> \n<head>\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></Script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n\t<Script src=\"../../eCommon/js/dchk.js\" language=\"JavaScript\"></Script>\n\t<script src=\'../../eIP/js/DischargeCheckList.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\'DischargeCheckListMain\' id=\'DischargeCheckListMain\' action=\'../../servlet/eIP.DischargeCheckListServlet\' method=\'post\' target=\'submitFrame\' >\n\t<table border=\"1\" cellpadding=\"1\" cellspacing=\"1\" width=\"100%\" align=\'center\'>\n\t<tr>\n\t\t<td class=\'data\' id=\'tab_1\' style=\'cursor:pointer;background:BLUE;width:114\' onclick=\"call_jsp_main(\'D\');\" align=\'center\'><font color=\'WHITE\' size=1>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</font></td>\n\t\t<td class=\'data\' id=\'tab_2\' style=\'cursor:pointer;background:NAVY;width:114\' onclick=\"call_jsp_main(\'R\');\" align=\'center\'><font color=\'WHITE\'size=1>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n        </font></td> \n\t\t<td class=\'data\' id=\'tab_3\' style=\'cursor:pointer;background:NAVY;width:114\' onclick=\"call_jsp_main(\'H\');\" align=\'center\'><font color=\'WHITE\' size=1>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></td>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<td class=\'data\' id=\'tab_4\' style=\'cursor:pointer;background:NAVY;width:114\' onclick=\"call_jsp_main(\'P\');\" align=\'center\'><font color=\'WHITE\' size=1>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<td class=\'data\' id=\'tab_5\' style=\'cursor:pointer;background:NAVY;width:114\' onclick=\"call_jsp_main(\'O\');\" align=\'center\' wrap><font color=\'WHITE\' size=1>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<td class=\'data\' id=\'tab_6\' style=\'cursor:pointer;background:NAVY;width:114\' onclick=\"call_jsp_main(\'L\');\" align=\'center\'><font color=\'WHITE\' size=1>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</tr>\n</table>\n\n<input type=\'hidden\' name=\'h_iv_catheters_chk\' id=\'h_iv_catheters_chk\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' >\n<input type=\'hidden\' name=\'h_iv_removed_by\' id=\'h_iv_removed_by\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'h_iv_removed_dt\' id=\'h_iv_removed_dt\'value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'h_tubes_chk\' id=\'h_tubes_chk\'value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'h_tubes_removed_by\' id=\'h_tubes_removed_by\'value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'hidden\' name=\'h_tubes_removed_dt\' id=\'h_tubes_removed_dt\'value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'h_drg_chk\' id=\'h_drg_chk\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'h_drg_removed_by\' id=\'h_drg_removed_by\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'h_drg_removed_dt\' id=\'h_drg_removed_dt\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'h_ngt_tube_chk\' id=\'h_ngt_tube_chk\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=\'hidden\' name=\'h_ngt_tube_removed_by\' id=\'h_ngt_tube_removed_by\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\' name=\'h_ngt_tube_removed_dt\' id=\'h_ngt_tube_removed_dt\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'> \n<input type=\'hidden\' name=\'h_cngt_tube_chk\' id=\'h_cngt_tube_chk\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'h_cngt_tube_removed_by\' id=\'h_cngt_tube_removed_by\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'h_cngt_tube_removed_dt\' id=\'h_cngt_tube_removed_dt\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'h_urn_chk\' id=\'h_urn_chk\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'h_urn_removed_by\' id=\'h_urn_removed_by\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'h_urn_removed_dt\' id=\'h_urn_removed_dt\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'h_curn_chk\' id=\'h_curn_chk\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'h_curn_removed_by\' id=\'h_curn_removed_by\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'h_curn_removed_dt\' id=\'h_curn_removed_dt\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'h_sto_chk\' id=\'h_sto_chk\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'h_sto_removed_by\' id=\'h_sto_removed_by\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'h_sto_removed_dt\' id=\'h_sto_removed_dt\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'h_dressing_chk\' id=\'h_dressing_chk\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'h_dressing_removed_by\' id=\'h_dressing_removed_by\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'h_dressing_removed_dt\' id=\'h_dressing_removed_dt\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'h_blng_returned\' id=\'h_blng_returned\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'h_blng_returned_dt\' id=\'h_blng_returned_dt\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'h_blng_remarks\' id=\'h_blng_remarks\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'h_vlb_returned\' id=\'h_vlb_returned\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'h_vlb_returned_by\' id=\'h_vlb_returned_by\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\'hidden\' name=\'h_vlb_witness\' id=\'h_vlb_witness\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'h_witness_id\' id=\'h_witness_id\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'h_vlb_user\' id=\'h_vlb_user\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n\n<input type=\'hidden\' name=\'h_tp_arranged\' id=\'h_tp_arranged\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'h_tp_returned_dt\' id=\'h_tp_returned_dt\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'h_tp_remarks\' id=\'h_tp_remarks\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'h_adv_cnt_parent\' id=\'h_adv_cnt_parent\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<input type=\'hidden\' name=\'h_adv_cnt_guardian\' id=\'h_adv_cnt_guardian\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n<input type=\'hidden\' name=\'h_wc_chk\' id=\'h_wc_chk\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n<input type=\'hidden\' name=\'h_wc_given_by\' id=\'h_wc_given_by\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<input type=\'hidden\' name=\'h_wc_given_dt\' id=\'h_wc_given_dt\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=\'hidden\' name=\'h_nu_chk\' id=\'h_nu_chk\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n<input type=\'hidden\' name=\'h_nu_given_by\' id=\'h_nu_given_by\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<input type=\'hidden\' name=\'h_nu_given_dt\' id=\'h_nu_given_dt\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n<input type=\'hidden\' name=\'h_mc_chk\' id=\'h_mc_chk\' value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\'>\n<input type=\'hidden\' name=\'h_mc_given_by\' id=\'h_mc_given_by\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\'>\n<input type=\'hidden\' name=\'h_mc_given_dt\' id=\'h_mc_given_dt\' value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\'>\n<input type=\'hidden\' name=\'h_ph_chk\' id=\'h_ph_chk\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\'>\n<input type=\'hidden\' name=\'h_ph_given_by\' id=\'h_ph_given_by\' value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\'>\n<input type=\'hidden\' name=\'h_ph_given_dt\' id=\'h_ph_given_dt\' value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'>\n<input type=\'hidden\' name=\'h_cop_chk\' id=\'h_cop_chk\' value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n<input type=\'hidden\' name=\'h_cop_given_by\' id=\'h_cop_given_by\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n<input type=\'hidden\' name=\'h_cop_given_dt\' id=\'h_cop_given_dt\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n<input type=\'hidden\' name=\'h_coc_chk\' id=\'h_coc_chk\' value=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n<input type=\'hidden\' name=\'h_coc_given_by\' id=\'h_coc_given_by\' value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\'>\n<input type=\'hidden\' name=\'h_coc_given_dt\' id=\'h_coc_given_dt\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>\n<input type=\'hidden\' name=\'h_cot_chk\' id=\'h_cot_chk\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'>\n<input type=\'hidden\' name=\'h_cot_given_by\' id=\'h_cot_given_by\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\'>\n<input type=\'hidden\' name=\'h_cot_given_dt\' id=\'h_cot_given_dt\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\'>\n<input type=\'hidden\' name=\'h_oth_he_chk\' id=\'h_oth_he_chk\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n<input type=\'hidden\' name=\'h_oth_text\' id=\'h_oth_text\' value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\'>\n<input type=\'hidden\' name=\'h_oth_given_by\' id=\'h_oth_given_by\' value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\n<input type=\'hidden\' name=\'h_oth_given_dt\' id=\'h_oth_given_dt\' value=\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\'>\n<input type=\'hidden\' name=\'h_top_to_toe_chk\' id=\'h_top_to_toe_chk\' value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n<input type=\'hidden\' name=\'h_co_umb_stmp_chk\' id=\'h_co_umb_stmp_chk\' value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'>\n<input type=\'hidden\' name=\'h_care_of_skin_chk\' id=\'h_care_of_skin_chk\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'>\n<input type=\'hidden\' name=\'h_care_of_eye_chk\' id=\'h_care_of_eye_chk\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n<input type=\'hidden\' name=\'h_expr_br_mlk_chk\' id=\'h_expr_br_mlk_chk\' value=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'>\n<input type=\'hidden\' name=\'h_tube_feed_chk\' id=\'h_tube_feed_chk\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n<input type=\'hidden\' name=\'h_gst_feed_chk\' id=\'h_gst_feed_chk\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\'>\n<input type=\'hidden\' name=\'h_frm_milk_chk\' id=\'h_frm_milk_chk\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n<input type=\'hidden\' name=\'h_imn_sch_chk\' id=\'h_imn_sch_chk\' value=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'>\n<input type=\'hidden\' name=\'h_care_of_stoma_chk\' id=\'h_care_of_stoma_chk\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\'>\n<input type=\'hidden\' name=\'h_anl_dil_chk\' id=\'h_anl_dil_chk\' value=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\'>\n<input type=\'hidden\' name=\'h_pop_chk\' id=\'h_pop_chk\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\'hidden\' name=\'h_fever_chk\' id=\'h_fever_chk\' value=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\'>\n<input type=\'hidden\' name=\'h_sz_chk\' id=\'h_sz_chk\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n<input type=\'hidden\' name=\'h_jnd_chk\' id=\'h_jnd_chk\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\n<input type=\'hidden\' name=\'h_gpd_chk\' id=\'h_gpd_chk\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n<input type=\'hidden\' name=\'h_stlc_chk\' id=\'h_stlc_chk\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n<input type=\'hidden\' name=\'h_stlf_chk\' id=\'h_stlf_chk\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n<input type=\'hidden\' name=\'h_coptb_chk\' id=\'h_coptb_chk\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n<input type=\'hidden\' name=\'h_oth_ph_chk\' id=\'h_oth_ph_chk\' value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\n<input type=\'hidden\' name=\'h_bfd_chk\' id=\'h_bfd_chk\' value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n<input type=\'hidden\' name=\'h_stm_cr_chk\' id=\'h_stm_cr_chk\' value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n<input type=\'hidden\' name=\'h_oper_chk\' id=\'h_oper_chk\' value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n<input type=\'hidden\' name=\'h_pop_care_chk\' id=\'h_pop_care_chk\' value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n<input type=\'hidden\' name=\'h_oth_pamphlets\' id=\'h_oth_pamphlets\' value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n<input type=\'hidden\' name=\'h_dn_given_chk\' id=\'h_dn_given_chk\' value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n<input type=\'hidden\' name=\'h_db_given_chk\' id=\'h_db_given_chk\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item1\' id=\'h_oth_app_fix_item1\' value=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item1_given1\' id=\'h_oth_app_fix_item1_given1\' value=\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item1_dt1\' id=\'h_oth_app_fix_item1_dt1\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item2\' id=\'h_oth_app_fix_item2\' value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item2_given2\' id=\'h_oth_app_fix_item2_given2\' value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item2_dt2\' id=\'h_oth_app_fix_item2_dt2\' value=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item3\' id=\'h_oth_app_fix_item3\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item3_given3\' id=\'h_oth_app_fix_item3_given3\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item3_dt3\' id=\'h_oth_app_fix_item3_dt3\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item4\' id=\'h_oth_app_fix_item4\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item4_given4\' id=\'h_oth_app_fix_item4_given4\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item4_dt4\' id=\'h_oth_app_fix_item4_dt4\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item5\' id=\'h_oth_app_fix_item5\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item5_given5\' id=\'h_oth_app_fix_item5_given5\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n<input type=\'hidden\' name=\'h_oth_app_fix_item5_dt5\' id=\'h_oth_app_fix_item5_dt5\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item6\' id=\'h_oth_app_fix_item6\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item6_given6\' id=\'h_oth_app_fix_item6_given6\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item6_dt6\' id=\'h_oth_app_fix_item6_dt6\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item7\' id=\'h_oth_app_fix_item7\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item7_given7\' id=\'h_oth_app_fix_item7_given7\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item7_dt7\' id=\'h_oth_app_fix_item7_dt7\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item8\' id=\'h_oth_app_fix_item8\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item8_given8\' id=\'h_oth_app_fix_item8_given8\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item8_dt8\' id=\'h_oth_app_fix_item8_dt8\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item9\' id=\'h_oth_app_fix_item9\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item9_given9\' id=\'h_oth_app_fix_item9_given9\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item9_dt9\' id=\'h_oth_app_fix_item9_dt9\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'>\n\n<input type=\'hidden\' name=\'h_oth_app_fix_item10\' id=\'h_oth_app_fix_item10\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item10_given10\' id=\'h_oth_app_fix_item10_given10\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'><input type=\'hidden\' name=\'h_oth_app_fix_item10_dt10\' id=\'h_oth_app_fix_item10_dt10\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\n\n\n\n<input type=\'hidden\' name=\'h_ref_ltr_chk\' id=\'h_ref_ltr_chk\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'><input type=\'hidden\' name=\'h_confirm_chk\' id=\'h_confirm_chk\' value=\'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\n<input type=\'hidden\' name=\'h_rep_ltr_chk\' id=\'h_rep_ltr_chk\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'><input type=\'hidden\' name=\'h_rep_dtl_txt\' id=\'h_rep_dtl_txt\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n<input type=\'hidden\' name=\'h_rep_cnf_txt\' id=\'h_rep_cnf_txt\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'><input type=\'hidden\' name=\'h_cln_doc_chk\' id=\'h_cln_doc_chk\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n<input type=\'hidden\' name=\'h_cln_dtl_txt\' id=\'h_cln_dtl_txt\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'><input type=\'hidden\' name=\'h_cln_cnf_txt\' id=\'h_cln_cnf_txt\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n<input type=\'hidden\' name=\'h_oth_doc_chk\' id=\'h_oth_doc_chk\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'><input type=\'hidden\' name=\'h_oth_dtl_txt1\' id=\'h_oth_dtl_txt1\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n<input type=\'hidden\' name=\'h_oth_cnf_txt1\' id=\'h_oth_cnf_txt1\' value=\'";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\'><input type=\'hidden\' name=\'h_oth_doc_txt\' id=\'h_oth_doc_txt\' value=\'";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\'>\n<input type=\'hidden\' name=\'h_relationship\' id=\'h_relationship\' value=\'";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\'><input type=\'hidden\' name=\'h_rel_date_time\' id=\'h_rel_date_time\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\n<input type=\'hidden\' name=\'h_rem_lv_ward\' id=\'h_rem_lv_ward\' value=\'";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'><input type=\'hidden\' name=\'h_sc_care_home\' id=\'h_sc_care_home\'>\n<input type=\'hidden\' name=\'h_name_of_patient\' id=\'h_name_of_patient\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'><input type=\'hidden\' name=\'h_mot_ic_no\' id=\'h_mot_ic_no\' value=\'";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n<input type=\'hidden\' name=\'h_rn_txt\' id=\'h_rn_txt\' value=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'><input type=\'hidden\' name=\'h_ward_txt\' id=\'h_ward_txt\' value=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n<input type=\'hidden\' name=\'h_discharge_date\' id=\'h_discharge_date\' value=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'><input type=\'hidden\' name=\'h_weight_txt\' id=\'h_weight_txt\' value=\'";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n<input type=\'hidden\' name=\'h_length_txt\' id=\'h_length_txt\' value=\'";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\'><input type=\'hidden\' name=\'h_head_circum\' id=\'h_head_circum\' value=\'";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\'>\n<input type=\'hidden\' name=\'h_adv_given\' id=\'h_adv_given\' value=\'";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\'>\n\n<input type=\'hidden\' name=\'h_relationship_txt\' id=\'h_relationship_txt\' value=\'";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n<input type=\'hidden\' name=\'h_mother_name\' id=\'h_mother_name\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\'>\n<input type=\'hidden\' name=\'h_mother_no\' id=\'h_mother_no\' value=\'";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'>\n<input type=\'hidden\' name=\'h_father_name\' id=\'h_father_name\' value=\'";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\n<input type=\'hidden\' name=\'h_father_no\' id=\'h_father_no\' value=\'";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n<input type=\'hidden\' name=\'h_Remarks\' id=\'h_Remarks\' value=\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'>\n\n<input type=\'hidden\' name=\'h_date_time_txt\' id=\'h_date_time_txt\'><input type=\'hidden\' name=\'h_user_txt\' id=\'h_user_txt\'>\n\n<input type=\'hidden\' name=\'h_dis_medication\' id=\'h_dis_medication\' value=\'";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'><input type=\'hidden\' name=\'h_dis_summ_prep\' id=\'h_dis_summ_prep\' value=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'><input type=\'hidden\' name=\'h_dis_summ_prep_by\' id=\'h_dis_summ_prep_by\' value=\'";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n<input type=\'hidden\' name=\'h_informed_to\' id=\'h_informed_to\' value=\'";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\'><input type=\'hidden\' name=\'h_cert_no\' id=\'h_cert_no\' value=\'";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n<input type=\'hidden\' name=\'h_loc_txt\' id=\'h_loc_txt\' ><input type=\'hidden\' name=\'h_rem_by_txt\' id=\'h_rem_by_txt\'>\n<input type=\'hidden\' name=\'h_apt_date_time\' id=\'h_apt_date_time\'>\n\n<input type=\'hidden\' name=\'system_date_time\' id=\'system_date_time\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\n\n<input type=\'hidden\' name=\'h_inform_to\' id=\'h_inform_to\' value=\"\">\n<input type=\'hidden\' name=\'h_informed_date\' id=\'h_informed_date\' value=\"\">\n<input type=\'hidden\' name=\'h_informed_name\' id=\'h_informed_name\' value=\"\">\n<input type=\'hidden\' name=\'h_chargeable_item_yn\' id=\'h_chargeable_item_yn\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\"><!-- Added by chandra for MMS-KH-CRF-0052.1 -->\n\n";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\n<input type=\'hidden\' name=\'operation\' id=\'operation\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n<input type=\'hidden\' name=\'call_function\' id=\'call_function\' value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\n<!-- fields for retaining values from database -->\n<input type=\'hidden\' name=\'hh_iv_catheters_chk\' id=\'hh_iv_catheters_chk\' value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\"><input type=\'hidden\' name=\'hh_iv_removed_by\' id=\'hh_iv_removed_by\'  value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\"><input type=\'hidden\' name=\'hh_iv_removed_dt\' id=\'hh_iv_removed_dt\' value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" >\n<input type=\'hidden\' name=\'hh_tubes_chk\' id=\'hh_tubes_chk\' value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\"><input type=\'hidden\' name=\'hh_tubes_removed_by\' id=\'hh_tubes_removed_by\' value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\">\n<input type=\'hidden\' name=\'hh_tubes_removed_dt\' id=\'hh_tubes_removed_dt\' value=\"";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\"><input type=\'hidden\' name=\'hh_drg_chk\' id=\'hh_drg_chk\' value=\"";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\">\n<input type=\'hidden\' name=\'hh_drg_removed_by\' id=\'hh_drg_removed_by\' value=\"";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\"><input type=\'hidden\' name=\'hh_drg_removed_dt\' id=\'hh_drg_removed_dt\' value=\"";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\"> \n<input type=\'hidden\' name=\'hh_ngt_tube_chk\' id=\'hh_ngt_tube_chk\' value=\"";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\"><input type=\'hidden\' name=\'hh_ngt_tube_removed_by\' id=\'hh_ngt_tube_removed_by\' value=\"";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\"><input type=\'hidden\' name=\'hh_ngt_tube_removed_dt\' id=\'hh_ngt_tube_removed_dt\' value=\"";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\">\n<input type=\'hidden\' name=\'hh_cngt_tube_chk\' id=\'hh_cngt_tube_chk\' value=\"";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\"><input type=\'hidden\' name=\'hh_cngt_tube_removed_by\' id=\'hh_cngt_tube_removed_by\' value=\"";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\"><input type=\'hidden\' name=\'hh_cngt_tube_removed_dt\' id=\'hh_cngt_tube_removed_dt\' value=\"";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\">\n<input type=\'hidden\' name=\'hh_urn_chk\' id=\'hh_urn_chk\' value=\"";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\"><input type=\'hidden\' name=\'hh_urn_removed_by\' id=\'hh_urn_removed_by\' value=\"";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n<input type=\'hidden\' name=\'hh_urn_removed_dt\' id=\'hh_urn_removed_dt\' value=\"";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\"><input type=\'hidden\' name=\'hh_curn_chk\' id=\'hh_curn_chk\' value=\"";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\">\n<input type=\'hidden\' name=\'hh_curn_removed_by\' id=\'hh_curn_removed_by\' value=\"";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\"><input type=\'hidden\' name=\'hh_curn_removed_dt\' id=\'hh_curn_removed_dt\' value=\"";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\"><input type=\'hidden\' name=\'hh_sto_chk\' id=\'hh_sto_chk\' value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n<input type=\'hidden\' name=\'hh_sto_removed_by\' id=\'hh_sto_removed_by\' value=\"";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\"><input type=\'hidden\' name=\'hh_sto_removed_dt\' id=\'hh_sto_removed_dt\' value=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n<input type=\'hidden\' name=\'hh_dressing_chk\' id=\'hh_dressing_chk\' value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\"><input type=\'hidden\' name=\'hh_dressing_removed_by\' id=\'hh_dressing_removed_by\' value=\"";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"><input type=\'hidden\' name=\'hh_dressing_removed_dt\' id=\'hh_dressing_removed_dt\' value=\"";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n<input type=\'hidden\' name=\'hh_blng_returned\' id=\'hh_blng_returned\' value=\"";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\"><input type=\'hidden\' name=\'hh_blng_returned_dt\' id=\'hh_blng_returned_dt\' value=\"";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\">\n<input type=\'hidden\' name=\'hh_blng_remarks\' id=\'hh_blng_remarks\' value=\"";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\"><input type=\'hidden\' name=\'hh_vlb_returned\' id=\'hh_vlb_returned\' value=\"";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\">\n<input type=\'hidden\' name=\'hh_vlb_returned_by\' id=\'hh_vlb_returned_by\' value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\"><input type=\'hidden\' name=\'hh_vlb_witness\' id=\'hh_vlb_witness\' value=\"";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\">\n<input type=\'hidden\' name=\'hh_witness_id\' id=\'hh_witness_id\' value=\'";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\'><input type=\'hidden\' name=\'hh_vlb_user\' id=\'hh_vlb_user\' value=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n<input type=\'hidden\' name=\'hh_tp_arranged\' id=\'hh_tp_arranged\' value=\"";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\"><input type=\'hidden\' name=\'hh_tp_returned_dt\' id=\'hh_tp_returned_dt\' value=\"";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\">\n<input type=\'hidden\' name=\'hh_tp_remarks\' id=\'hh_tp_remarks\' value=\"";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\"><input type=\'hidden\' name=\'hh_adv_cnt_parent\' id=\'hh_adv_cnt_parent\' value=\"";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\">\n<input type=\'hidden\' name=\'hh_adv_cnt_guardian\' id=\'hh_adv_cnt_guardian\' value=\"";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\"><input type=\'hidden\' name=\'hh_wc_chk\' id=\'hh_wc_chk\' value=\"";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\">\n<input type=\'hidden\' name=\'hh_wc_given_by\' id=\'hh_wc_given_by\' value=\"";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\"><input type=\'hidden\' name=\'hh_wc_given_dt\' id=\'hh_wc_given_dt\' value=\"";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\">\n<input type=\'hidden\' name=\'hh_nu_chk\' id=\'hh_nu_chk\' value=\"";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\"><input type=\'hidden\' name=\'hh_nu_given_by\' id=\'hh_nu_given_by\' value=\"";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\">\n<input type=\'hidden\' name=\'hh_nu_given_dt\' id=\'hh_nu_given_dt\' value=\"";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\"><input type=\'hidden\' name=\'hh_mc_chk\' id=\'hh_mc_chk\' value=\"";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\">\n<input type=\'hidden\' name=\'hh_mc_given_by\' id=\'hh_mc_given_by\' value=\"";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\"><input type=\'hidden\' name=\'hh_mc_given_dt\' id=\'hh_mc_given_dt\' value=\"";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\">\n<input type=\'hidden\' name=\'hh_ph_chk\' id=\'hh_ph_chk\' value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\"><input type=\'hidden\' name=\'hh_ph_given_by\' id=\'hh_ph_given_by\' value=\"";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\">\n<input type=\'hidden\' name=\'hh_ph_given_dt\' id=\'hh_ph_given_dt\' value=\"";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\"><input type=\'hidden\' name=\'hh_cop_chk\' id=\'hh_cop_chk\' value=\"";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\">\n<input type=\'hidden\' name=\'hh_cop_given_by\' id=\'hh_cop_given_by\' value=\"";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\"><input type=\'hidden\' name=\'hh_cop_given_dt\' id=\'hh_cop_given_dt\' value=\"";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\">\n<input type=\'hidden\' name=\'hh_coc_chk\' id=\'hh_coc_chk\' value=\"";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\"><input type=\'hidden\' name=\'hh_coc_given_by\' id=\'hh_coc_given_by\' value=\"";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\">\n<input type=\'hidden\' name=\'hh_coc_given_dt\' id=\'hh_coc_given_dt\' value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\"><input type=\'hidden\' name=\'hh_cot_chk\' id=\'hh_cot_chk\' value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n<input type=\'hidden\' name=\'hh_cot_given_by\' id=\'hh_cot_given_by\' value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\"><input type=\'hidden\' name=\'hh_cot_given_dt\' id=\'hh_cot_given_dt\' value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n<input type=\'hidden\' name=\'hh_oth_he_chk\' id=\'hh_oth_he_chk\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\"><input type=\'hidden\' name=\'hh_oth_text\' id=\'hh_oth_text\' value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\">\n<input type=\'hidden\' name=\'hh_oth_given_by\' id=\'hh_oth_given_by\' value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\"><input type=\'hidden\' name=\'hh_oth_given_dt\' id=\'hh_oth_given_dt\' value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\">\n<input type=\'hidden\' name=\'hh_top_to_toe_chk\' id=\'hh_top_to_toe_chk\' value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"><input type=\'hidden\' name=\'hh_co_umb_stmp_chk\' id=\'hh_co_umb_stmp_chk\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\">\n<input type=\'hidden\' name=\'hh_care_of_skin_chk\' id=\'hh_care_of_skin_chk\' value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\"><input type=\'hidden\' name=\'hh_care_of_eye_chk\' id=\'hh_care_of_eye_chk\' value=\"";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\"><input type=\'hidden\' name=\'hh_expr_br_mlk_chk\' id=\'hh_expr_br_mlk_chk\' value=\"";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\">\n<input type=\'hidden\' name=\'hh_tube_feed_chk\' id=\'hh_tube_feed_chk\' value=\"";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\"><input type=\'hidden\' name=\'hh_gst_feed_chk\' id=\'hh_gst_feed_chk\' value=\"";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n<input type=\'hidden\' name=\'hh_frm_milk_chk\' id=\'hh_frm_milk_chk\' value=\"";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\"><input type=\'hidden\' name=\'hh_imn_sch_chk\' id=\'hh_imn_sch_chk\' value=\"";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n<input type=\'hidden\' name=\'hh_care_of_stoma_chk\' id=\'hh_care_of_stoma_chk\' value=\"";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\"><input type=\'hidden\' name=\'hh_anl_dil_chk\' id=\'hh_anl_dil_chk\' value=\"";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\">\n<input type=\'hidden\' name=\'hh_pop_chk\' id=\'hh_pop_chk\' value=\"";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\"><input type=\'hidden\' name=\'hh_fever_chk\' id=\'hh_fever_chk\' value=\"";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\">\n<input type=\'hidden\' name=\'hh_sz_chk\' id=\'hh_sz_chk\' value=\"";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\"><input type=\'hidden\' name=\'hh_jnd_chk\' id=\'hh_jnd_chk\' value=\"";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\">\n<input type=\'hidden\' name=\'hh_gpd_chk\' id=\'hh_gpd_chk\' value=\"";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"><input type=\'hidden\' name=\'hh_stlc_chk\' id=\'hh_stlc_chk\' value=\"";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="\">\n<input type=\'hidden\' name=\'hh_stlf_chk\' id=\'hh_stlf_chk\' value=\"";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\"><input type=\'hidden\' name=\'hh_coptb_chk\' id=\'hh_coptb_chk\' value=\"";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\">\n<input type=\'hidden\' name=\'hh_oth_ph_chk\' id=\'hh_oth_ph_chk\' value=\"";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 ="\"><input type=\'hidden\' name=\'hh_bfd_chk\' id=\'hh_bfd_chk\' value=\"";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\">\n<input type=\'hidden\' name=\'hh_stm_cr_chk\' id=\'hh_stm_cr_chk\' value=\"";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\"><input type=\'hidden\' name=\'hh_oper_chk\' id=\'hh_oper_chk\' value=\"";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\">\n<input type=\'hidden\' name=\'hh_pop_care_chk\' id=\'hh_pop_care_chk\' value=\"";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="\"><input type=\'hidden\' name=\'hh_oth_pamphlets\' id=\'hh_oth_pamphlets\' value=\"";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\">\n<input type=\'hidden\' name=\'hh_dn_given_chk\' id=\'hh_dn_given_chk\' value=\"";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 ="\"><input type=\'hidden\' name=\'hh_db_given_chk\' id=\'hh_db_given_chk\' value=\"";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\">\n<input type=\'hidden\' name=\'hh_oth_app_fix_item1\' id=\'hh_oth_app_fix_item1\' value=\"";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item1_given1\' id=\'hh_oth_app_fix_item1_given1\' value=\"";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item1_dt1\' id=\'hh_oth_app_fix_item1_dt1\' value=\"";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item2\' id=\'hh_oth_app_fix_item2\' value=\"";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item2_given2\' id=\'hh_oth_app_fix_item2_given2\' value=\"";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item2_dt2\' id=\'hh_oth_app_fix_item2_dt2\' value=\"";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item3\' id=\'hh_oth_app_fix_item3\' value=\"";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item3_given3\' id=\'hh_oth_app_fix_item3_given3\' value=\"";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item3_dt3\' id=\'hh_oth_app_fix_item3_dt3\' value=\"";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item4\' id=\'hh_oth_app_fix_item4\' value=\"";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item4_given4\' id=\'hh_oth_app_fix_item4_given4\' value=\"";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item4_dt4\' id=\'hh_oth_app_fix_item4_dt4\' value=\"";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item5\' id=\'hh_oth_app_fix_item5\' value=\"";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item5_given5\' id=\'hh_oth_app_fix_item5_given5\' value=\"";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item5_dt5\' id=\'hh_oth_app_fix_item5_dt5\' value=\"";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item6\' id=\'hh_oth_app_fix_item6\' value=\"";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item6_given6\' id=\'hh_oth_app_fix_item6_given6\' value=\"";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item6_dt6\' id=\'hh_oth_app_fix_item6_dt6\' value=\"";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item7\' id=\'hh_oth_app_fix_item7\' value=\"";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item7_given7\' id=\'hh_oth_app_fix_item7_given7\' value=\"";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item7_dt7\' id=\'hh_oth_app_fix_item7_dt7\' value=\"";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item8\' id=\'hh_oth_app_fix_item8\' value=\"";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item8_given8\' id=\'hh_oth_app_fix_item8_given8\' value=\"";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item8_dt8\' id=\'hh_oth_app_fix_item8_dt8\' value=\"";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item9\' id=\'hh_oth_app_fix_item9\' value=\"";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item9_given9\' id=\'hh_oth_app_fix_item9_given9\' value=\"";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item9_dt9\' id=\'hh_oth_app_fix_item9_dt9\' value=\"";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\">\n\n<input type=\'hidden\' name=\'hh_oth_app_fix_item10\' id=\'hh_oth_app_fix_item10\' value=\"";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item10_given10\' id=\'hh_oth_app_fix_item10_given10\' value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\"><input type=\'hidden\' name=\'hh_oth_app_fix_item10_dt10\' id=\'hh_oth_app_fix_item10_dt10\' value=\"";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\">\n\n<input type=\'hidden\' name=\'hh_ref_ltr_chk\' id=\'hh_ref_ltr_chk\' value=\"";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\"><input type=\'hidden\' name=\'hh_confirm_chk\' id=\'hh_confirm_chk\' value=\"";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\">\n<input type=\'hidden\' name=\'hh_rep_ltr_chk\' id=\'hh_rep_ltr_chk\' value=\"";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\"><input type=\'hidden\' name=\'hh_rep_dtl_txt\' id=\'hh_rep_dtl_txt\' value=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'>\n<input type=\'hidden\' name=\'hh_rep_cnf_txt\' id=\'hh_rep_cnf_txt\' value=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\'><input type=\'hidden\' name=\'hh_cln_doc_chk\' id=\'hh_cln_doc_chk\' value=\"";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\">\n<input type=\'hidden\' name=\'hh_cln_dtl_txt\' id=\'hh_cln_dtl_txt\' value=\'";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\'><input type=\'hidden\' name=\'hh_cln_cnf_txt\' id=\'hh_cln_cnf_txt\' value=\"";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\">\n<input type=\'hidden\' name=\'hh_oth_doc_chk\' id=\'hh_oth_doc_chk\' value=\"";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\"><input type=\'hidden\' name=\'hh_oth_dtl_txt1\' id=\'hh_oth_dtl_txt1\' value=\'";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\'>\n<input type=\'hidden\' name=\'hh_oth_cnf_txt1\' id=\'hh_oth_cnf_txt1\' value=\'";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\'><input type=\'hidden\' name=\'hh_oth_doc_txt\' id=\'hh_oth_doc_txt\' value=\'";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\'>\n<input type=\'hidden\' name=\'hh_relationship\' id=\'hh_relationship\' value=\"";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\"><input type=\'hidden\' name=\'hh_rel_date_time\' id=\'hh_rel_date_time\' value=\"";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="\">\n<input type=\'hidden\' name=\'hh_rem_lv_ward\' id=\'hh_rem_lv_ward\' value=\"";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\"><input type=\'hidden\' name=\'hh_sc_care_home\' id=\'hh_sc_care_home\'>\n<input type=\'hidden\' name=\'hh_name_of_patient\' id=\'hh_name_of_patient\' value=\"";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 ="\"><input type=\'hidden\' name=\'hh_mot_ic_no\' id=\'hh_mot_ic_no\' value=\"";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\">\n<input type=\'hidden\' name=\'hh_rn_txt\' id=\'hh_rn_txt\' value=\"";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="\"><input type=\'hidden\' name=\'hh_ward_txt\' id=\'hh_ward_txt\' value=\"";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\">\n<input type=\'hidden\' name=\'hh_discharge_date\' id=\'hh_discharge_date\' value=\"";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 ="\"><input type=\'hidden\' name=\'hh_weight_txt\' id=\'hh_weight_txt\' value=\"";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="\">\n<input type=\'hidden\' name=\'hh_length_txt\' id=\'hh_length_txt\' value=\"";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\"><input type=\'hidden\' name=\'hh_head_circum\' id=\'hh_head_circum\' value=\"";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\">\n<input type=\'hidden\' name=\'hh_adv_given\' id=\'hh_adv_given\' value=\"";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="\">\n\n\n<input type=\'hidden\' name=\'hh_relationship_txt\' id=\'hh_relationship_txt\' value=\"";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="\">\n<input type=\'hidden\' name=\'hh_mother_name\' id=\'hh_mother_name\' value=\"";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\">\n<input type=\'hidden\' name=\'hh_mother_no\' id=\'hh_mother_no\' value=\"";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 ="\">\n<input type=\'hidden\' name=\'hh_father_name\' id=\'hh_father_name\' value=\"";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 ="\">\n<input type=\'hidden\' name=\'hh_father_no\' id=\'hh_father_no\' value=\"";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 ="\">\n<input type=\'hidden\' name=\'hh_Remarks\' id=\'hh_Remarks\' value=\"";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\">\n\n\n<input type=\'hidden\' name=\'hh_date_time_txt\' id=\'hh_date_time_txt\' value=\"";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\"><input type=\'hidden\' name=\'hh_user_txt\' id=\'hh_user_txt\' value=\"";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\">\n\n<input type=\'hidden\' name=\'hh_dis_medication\' id=\'hh_dis_medication\' value=\"";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\"><input type=\'hidden\' name=\'hh_dis_summ_prep\' id=\'hh_dis_summ_prep\' value=\"";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\"><input type=\'hidden\' name=\'hh_dis_summ_prep_by\' id=\'hh_dis_summ_prep_by\' value=\"";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\"> \n<input type=\'hidden\' name=\'hh_informed_to\' id=\'hh_informed_to\' value=\"";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\"><input type=\'hidden\' name=\'hh_cert_no\' id=\'hh_cert_no\' value=\"";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="\">\n<input type=\'hidden\' name=\'hh_loc_txt\' id=\'hh_loc_txt\' ><input type=\'hidden\' name=\'hh_rem_by_txt\' id=\'hh_rem_by_txt\'>\n<input type=\'hidden\' name=\'hh_apt_date_time\' id=\'hh_apt_date_time\'>\n<input type=\'hidden\' name=\'patient_age\' id=\'patient_age\' value=\"";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\">\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 ="\">\n<input type=\'hidden\' name=\'admission_date_time\' id=\'admission_date_time\' value=\'";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\'>\n<input type=\'hidden\' name=\'system_date_display\' id=\'system_date_display\' value=\'";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\'>\n<input type=\'hidden\' name=\'max_trn_date_time\' id=\'max_trn_date_time\' value=\"";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 ="\">\n\n<!--Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620-->\n<input type=\'hidden\' name=\'cert_num\' id=\'cert_num\' value=\"";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\">\n<input type=\'hidden\' name=\'cert_from_date\' id=\'cert_from_date\' value=\"";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\">\n<input type=\'hidden\' name=\'cert_to_date\' id=\'cert_to_date\' value=\"";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="\">\n<input type=\'hidden\' name=\'duration\' id=\'duration\' value=\"";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 ="\">\n<input type=\'hidden\' name=\'duration_dmy\' id=\'duration_dmy\' value=\"";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\">\n<!--Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050-->\n<input type=\'hidden\' name=\'deli_cert_num\' id=\'deli_cert_num\' value=\"";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\">\n\n<!--Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142-->\n<input type=\'hidden\' name=\'isChangesInAdditionalDtlsTabAppl\' id=\'isChangesInAdditionalDtlsTabAppl\' value=\"";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\">\n\n<input type=\'hidden\' name=\'h_iv_remove_chk\' id=\'h_iv_remove_chk\' value=\'";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\' >\n<input type=\'hidden\' name=\'h_iv_remarks\' id=\'h_iv_remarks\' value=\'";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\' >\n<input type=\'hidden\' name=\'h_tubes_remove_chk\' id=\'h_tubes_remove_chk\' value=\'";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\' >\n<input type=\'hidden\' name=\'h_tubes_remarks\' id=\'h_tubes_remarks\' value=\'";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\' >\n<input type=\'hidden\' name=\'h_drg_remove_chk\' id=\'h_drg_remove_chk\' value=\'";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 ="\' >\n<input type=\'hidden\' name=\'h_drg_remarks\' id=\'h_drg_remarks\' value=\'";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\' >\n<input type=\'hidden\' name=\'h_ngt_remove_chk\' id=\'h_ngt_remove_chk\' value=\'";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="\' >\n<input type=\'hidden\' name=\'h_ngt_remarks\' id=\'h_ngt_remarks\' value=\'";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\' >\n<input type=\'hidden\' name=\'h_urn_remove_chk\' id=\'h_urn_remove_chk\' value=\'";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 ="\' >\n<input type=\'hidden\' name=\'h_urn_remarks\' id=\'h_urn_remarks\' value=\'";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 ="\' >\n<input type=\'hidden\' name=\'h_sto_remove_chk\' id=\'h_sto_remove_chk\' value=\'";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\' >\n<input type=\'hidden\' name=\'h_sto_remarks\' id=\'h_sto_remarks\' value=\'";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 ="\' >\n<input type=\'hidden\' name=\'h_dressing_remove_chk\' id=\'h_dressing_remove_chk\' value=\'";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\' >\n<input type=\'hidden\' name=\'h_dressing_remarks\' id=\'h_dressing_remarks\' value=\'";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\' >\n\n<input type=\'hidden\' name=\'hh_iv_remove_chk\' id=\'hh_iv_remove_chk\' value=\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\' >\n<input type=\'hidden\' name=\'hh_iv_remarks\' id=\'hh_iv_remarks\' value=\'";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="\' >\n<input type=\'hidden\' name=\'hh_tubes_remove_chk\' id=\'hh_tubes_remove_chk\' value=\'";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\' >\n<input type=\'hidden\' name=\'hh_tubes_remarks\' id=\'hh_tubes_remarks\' value=\'";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\' >\n<input type=\'hidden\' name=\'hh_drg_remove_chk\' id=\'hh_drg_remove_chk\' value=\'";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="\' >\n<input type=\'hidden\' name=\'hh_drg_remarks\' id=\'hh_drg_remarks\' value=\'";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\' >\n<input type=\'hidden\' name=\'hh_ngt_remove_chk\' id=\'hh_ngt_remove_chk\' value=\'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 ="\' >\n<input type=\'hidden\' name=\'hh_ngt_remarks\' id=\'hh_ngt_remarks\' value=\'";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\' >\n<input type=\'hidden\' name=\'hh_urn_remove_chk\' id=\'hh_urn_remove_chk\' value=\'";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\' >\n<input type=\'hidden\' name=\'hh_urn_remarks\' id=\'hh_urn_remarks\' value=\'";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\' >\n<input type=\'hidden\' name=\'hh_sto_remove_chk\' id=\'hh_sto_remove_chk\' value=\'";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\' >\n<input type=\'hidden\' name=\'hh_sto_remarks\' id=\'hh_sto_remarks\' value=\'";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="\' >\n<input type=\'hidden\' name=\'hh_dressing_remove_chk\' id=\'hh_dressing_remove_chk\' value=\'";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\' >\n<input type=\'hidden\' name=\'hh_dressing_remarks\' id=\'hh_dressing_remarks\' value=\'";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\' >\n<!--End ML-MMOH-CRF-1142-->\n\n<!--Added by Mano on 19-Mar-2018 for ML-MMOH-CRF-1049-->\n<input type=\'hidden\' id=\'isAutoPopDurationApplyn\' value=\"";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\"/>\n\n<!--Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218-->\n<input type=\'hidden\' name=\'isItemOnLoanOthersDisableDateAppl\' id=\'isItemOnLoanOthersDisableDateAppl\' value=\"";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 ="\">\n<input type=\'hidden\' name=\'h_itemloan_chk\' id=\'h_itemloan_chk\' value=\'";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="\'>\n<input type=\'hidden\' name=\'h_itemloan_removed_by\' id=\'h_itemloan_removed_by\' value=\'";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="\'>\n<input type=\'hidden\' name=\'h_itemloan_removed_dt\' id=\'h_itemloan_removed_dt\' value=\'";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="\'>\n<input type=\'hidden\' name=\'h_itemloan_remove_chk\' id=\'h_itemloan_remove_chk\' value=\'";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 ="\'>\n<input type=\'hidden\' name=\'h_itemloan_remarks\' id=\'h_itemloan_remarks\' value=\'";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\'>\n<input type=\'hidden\' name=\'hh_itemloan_chk\' id=\'hh_itemloan_chk\' value=\"";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\">\n<input type=\'hidden\' name=\'hh_itemloan_removed_by\' id=\'hh_itemloan_removed_by\' value=\"";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\">\n<input type=\'hidden\' name=\'hh_itemloan_removed_dt\' id=\'hh_itemloan_removed_dt\' value=\"";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\">\n<input type=\'hidden\' name=\'hh_itemloan_remove_chk\' id=\'hh_itemloan_remove_chk\' value=\'";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\'>\n<input type=\'hidden\' name=\'hh_itemloan_remarks\' id=\'hh_itemloan_remarks\' value=\'";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\'>\n<input type=\'hidden\' name=\'h_others_chk\' id=\'h_others_chk\' value=\'";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="\'>\n<input type=\'hidden\' name=\'h_others_removed_by\' id=\'h_others_removed_by\' value=\'";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\'>\n<input type=\'hidden\' name=\'h_others_removed_dt\' id=\'h_others_removed_dt\' value=\'";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\'>\n<input type=\'hidden\' name=\'h_others_remove_chk\' id=\'h_others_remove_chk\' value=\'";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="\'>\n<input type=\'hidden\' name=\'h_others_remarks\' id=\'h_others_remarks\' value=\'";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="\'>\n<input type=\'hidden\' name=\'hh_others_chk\' id=\'hh_others_chk\' value=\"";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="\">\n<input type=\'hidden\' name=\'hh_others_removed_by\' id=\'hh_others_removed_by\' value=\"";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 ="\">\n<input type=\'hidden\' name=\'hh_others_removed_dt\' id=\'hh_others_removed_dt\' value=\"";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 ="\">\n<input type=\'hidden\' name=\'hh_others_remove_chk\' id=\'hh_others_remove_chk\' value=\'";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 ="\'>\n<input type=\'hidden\' name=\'hh_others_remarks\' id=\'hh_others_remarks\' value=\'";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\'>\n<!--End ML-MMOH-CRF-1218-->\n<input type=\'hidden\' name=\'hh_chargeable_item_yn\' id=\'hh_chargeable_item_yn\' value=\"";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\"><!-- Added by chandra for MMS-KH-CRF-0052.1 -->\n<script>\nif(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1)\n{\n\tif(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0])\n\t{\n\t\tif(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication)\n\t\t{\n\t\t\tparent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication.value=document.forms[0].h_dis_medication.value;\n\t\t\tif(document.forms[0].h_dis_medication.value == \'Y\')\t\n\t\t\tparent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_medication.checked = true;\n\t\t}\n\t\tif(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn)\n\t\t{//Adding start by Chandra for MMS-KH-CRF-0052.1\n\t\t\tparent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn.value=document.forms[0].h_chargeable_item_yn.value;\n\t\t\tif(document.forms[0].h_chargeable_item_yn.value == \'Y\')\t\n\t\t\tparent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].chargeable_item_yn.checked = true;\n\t\t}//Adding end for MMS-KH-CRF-0052.1\n\t\tif(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep)\n\t\t{\n\t\t\tparent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep.value=document.forms[0].h_dis_summ_prep.value;\n\t\t\tif(document.forms[0].h_dis_summ_prep.value == \'Y\')\n\t\t\tparent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep.checked = true;\n\t\t}\n\n\t\tif(parent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep_by)\n\t\t{\n\t\t\tparent.DischargeCheckList_frame2.DischargeCheckListTab1_frame1.document.forms[0].dis_summ_prep_by.value=document.forms[0].h_dis_summ_prep_by.value;\n\t\t}\n\t}\n}\n\n</script>\n";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\" \tvalue=\"";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\">\n\t<input type=\"hidden\" name=\"p_encounter_id\" id=\"p_encounter_id\" value=\"";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\">\n\t<input type=\"hidden\" name=\"p_resp_id\" id=\"p_resp_id\" value=\"";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\">\n";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\n</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null;
    ResultSet rset          = null;
	StringBuffer SqlSB		= new StringBuffer();
	String system_date		= "";
	String encounter_id		= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_id		= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");	
	String call_function	= request.getParameter("call_function")==null?"":request.getParameter("call_function");

	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String cert_num	= request.getParameter("cert_num")==null?"":request.getParameter("cert_num");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String cert_from_date	= request.getParameter("cert_from_date")==null?"":request.getParameter("cert_from_date");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String cert_to_date	= request.getParameter("cert_to_date")==null?"":request.getParameter("cert_to_date");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String duration	= request.getParameter("duration")==null?"":request.getParameter("duration");
	//Added by Ashwini on 30-Jan-2017 for ML-MMOH-CRF-0620
	String duration_dmy	= request.getParameter("duration_dmy")==null?"":request.getParameter("duration_dmy");
	//Added by Shanmukh on 2nd-MAY-2018 for ML-MMOH-CRF-1050
	String  deli_cert_num = request.getParameter("deli_cert_num")==null?"":request.getParameter("deli_cert_num");//shanmukh
    
	//Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
	Boolean isChangesInAdditionalDtlsTabAppl = false;
	
	//Added by Mano on 19-Mar-2018 aganist ML-MMOH-CRF-1049
	Boolean isAutoPopDurationApplyn = false;

	//Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
	Boolean isItemOnLoanOthersDisableDateAppl = false;
	int patient_age = 0;
	String dob="",age="";
	String facilityid = (String) session.getValue("facility_id" ) ;
	String p_resp_id		= (String) session.getValue("responsibility_id");
	String user_name		= (String) session.getValue( "login_user" ) ;
	String locale			= (String)session.getAttribute("LOCALE");
	String h_dis_medication		= "";
	String h_dis_summ_prep		= "";
	String h_dis_summ_prep_by   = "";
	String h_informed_to		= "";
	String h_cert_no			= "";
	String h_iv_catheters_chk   = "";
	String h_iv_removed_by		= "";
	String h_iv_removed_dt		= "";
	String h_tubes_chk			= "";	
	String h_tubes_removed_by   = "";
	String h_tubes_removed_dt   = "";
	String h_drg_chk			= "";
	String h_drg_removed_by		= "";
	String h_drg_removed_dt		= "";
	String h_ngt_tube_chk		= "";
	String h_ngt_tube_removed_by = "";
	String h_ngt_tube_removed_dt = "";
	String h_cngt_tube_chk		= "";
	String h_cngt_tube_removed_by	= "";
	String h_cngt_tube_removed_dt = "";
	String h_urn_chk				= "";
	String h_urn_removed_by		= "";
	String h_urn_removed_dt		= "";
	String h_curn_chk			= "";
	String h_curn_removed_by    = "";
	String h_curn_removed_dt    ="";
	String h_sto_chk			= "";
	String h_sto_removed_by		= "";
	String h_sto_removed_dt		= "";
	String h_dressing_chk		= "";
	String h_dressing_removed_by= "";
	String h_dressing_removed_dt= "";
	String h_blng_returned		= "";
	String h_blng_returned_dt   = "";
	String h_blng_remarks		= "";
	String h_vlb_returned		= "";
	String h_vlb_returned_by    = "";
	String h_vlb_witness		= "";
	String h_witness_id			= "";
	String h_vlb_user			= "";
	String h_tp_arranged    = "";
	String h_tp_returned_dt    = "";
	String h_tp_remarks    = "";	
	String h_adv_cnt_given    = "";	
	String h_adv_cnt_parent    = "";	
	String h_adv_cnt_guardian    = "";	
	String h_wc_chk    = "";
	String h_wc_given_by    = "";		
	String h_wc_given_dt    = "";
	String h_nu_chk    = "";
	String h_nu_given_by    = "";
	String h_nu_given_dt    = "";
	String h_mc_chk    = "";
	String h_mc_given_by    = "";
	String h_mc_given_dt    = "";
	String h_ph_chk    = "";
	String h_ph_given_by    = "";
	String h_ph_given_dt    = "";
	String h_cop_chk    = "";
	String h_cop_given_by    = "";
	String h_cop_given_dt    = "";
	String h_coc_chk    = "";
	String h_coc_given_by    = "";
	String h_coc_given_dt    = "";
	String h_cot_chk    = "";
	String h_cot_given_by    = "";
	String h_cot_given_dt    = "";
	String h_oth_he_chk    = "";
	String h_oth_text    = "";
	String h_oth_given_by    = "";
	String h_oth_given_dt    = "";
	String h_top_to_toe_chk    = "";
	String h_co_umb_stmp_chk    = "";
	String h_care_of_skin_chk    = "";
	String h_care_of_eye_chk    = "";
	String h_expr_br_mlk_chk    = "";
	String h_tube_feed_chk    = "";
	String h_gst_feed_chk    = "";
	String h_frm_milk_chk    = "";
	String h_imn_sch_chk    = "";
	String h_care_of_stoma_chk    = "";
	String h_anl_dil_chk    = "";
	String h_pop_chk    = "";
	String h_fever_chk    = "";
	String h_sz_chk    = "";
	String h_jnd_chk    = "";
	String h_gpd_chk    = "";
	String h_stlc_chk    = "";
	String h_stlf_chk    = "";
	String h_coptb_chk    = "";
	String h_oth_ph_chk    = "";
	String h_bfd_chk    = "";
	String h_stm_cr_chk    = "";
	String h_oper_chk    = "";
	String h_pop_care_chk    = "";
	String h_dn_given_chk    = "";
	String h_db_given_chk    = "";
	String h_oth_pamphlets    = "";
	String h_oth_app_fix_item1    = "";
	String h_oth_app_fix_item1_given1  ="";
	String h_oth_app_fix_item1_dt1  = "";
	String h_oth_app_fix_item2  = "";
	String h_oth_app_fix_item2_given2  = "";
	String h_oth_app_fix_item2_dt2  = "";
	String h_oth_app_fix_item3  = "";
	String h_oth_app_fix_item3_given3  ="";
	String h_oth_app_fix_item3_dt3  = "";
	String h_oth_app_fix_item4  = "";
	String h_oth_app_fix_item4_given4  = "";
	String h_oth_app_fix_item4_dt4  = "";
	String h_oth_app_fix_item5  = "";
	String h_oth_app_fix_item5_given5  = "";
	String h_oth_app_fix_item5_dt5  = "";
	String h_oth_app_fix_item6  = "";
	String h_oth_app_fix_item6_given6  = "";
	String h_oth_app_fix_item6_dt6  = "";
	String h_oth_app_fix_item7  = "";
	String h_oth_app_fix_item7_given7  = "";
	String h_oth_app_fix_item7_dt7  = "";
	String h_oth_app_fix_item8  = "";
	String h_oth_app_fix_item8_given8  = "";
	String h_oth_app_fix_item8_dt8  = "";
	String h_oth_app_fix_item9  = "";
	String h_oth_app_fix_item9_given9  = "";
	String h_oth_app_fix_item9_dt9  = "";
	String h_oth_app_fix_item10  = "";
	String h_oth_app_fix_item10_given10  = "";
	String h_oth_app_fix_item10_dt10  = "";
	String h_ref_ltr_chk  = "";
	String h_rep_ltr_chk  = "";
	String h_cln_doc_chk  = "";
	String h_oth_doc_chk  = "";
	String h_ref_ltr_conf_chk  = "";
	String h_rep_ltr_dtls  = "";
	String h_rep_ltr_conf  = "";
	String h_cln_doc_dtls  = "";
	String h_cln_doc_conf  = "";
	String h_oth_doc_desc  = "";
	String h_oth_doc_dtls  = "";
	String h_oth_doc_conf  = "";
	String h_relationship  = "";
	String h_rel_date_time  = "";
	String h_rem_lv_ward  = "";
	String h_name_of_patient  = "";
	String h_mot_ic_no  = "";
	String h_rn_txt  = "";
	String h_ward_txt  = "";
	String h_discharge_date  = "";
	String h_weight_txt  = "";
	String h_length_txt  = "";
	String h_head_circum  = "";
	String h_adv_given  = "";
	String h_relationship_txt  = "";
	String h_mother_name  = "";
	String h_mother_no  = "";
	String h_father_name  = "";
	String h_father_no  = "";
	String h_Remarks  = "";
	String disch_chklist_status  = "";
	String h_user_txt  = "";
	String operation = "";
	String h_date_time_txt = "";
	String admission_date_time = "";
	String system_date_display = "";
	String max_trn_date_time	= "";

	/*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
	String h_iv_remove_chk			 = "";
	String h_iv_remarks				 = "";
	String h_tubes_remove_chk		 = "";
	String h_tubes_remarks			 = "";
	String h_drg_remove_chk			 = "";
	String h_drg_remarks			 = "";
	String h_ngt_remove_chk			 = "";
	String h_ngt_remarks			 = "";
	String h_urn_remove_chk			 = "";
	String h_urn_remarks			 = "";
	String h_sto_remove_chk			 = "";
	String h_sto_remarks			 = "";
	String h_dressing_remove_chk	 = "";
	String h_dressing_remarks		 = "";
	/*End ML-MMOH-CRF-1142*/

	/*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
	String h_itemloan_chk			= "";
	String h_itemloan_removed_by	= "";
	String h_itemloan_removed_dt	= "";
	String h_itemloan_remove_chk	= "";
	String h_itemloan_remarks		= "";
	String h_others_chk				= "";
	String h_others_removed_by		= "";
	String h_others_removed_dt		= "";
	String h_others_remove_chk		= "";
	String h_others_remarks			= "";
	/*End ML-MMOH-CRF-1218*/
	String h_chargeable_item_yn ="";//Added for MMS-KH-CRF-0052.1

	try
	{		
		con = ConnectionManager.getConnection(request);

		isChangesInAdditionalDtlsTabAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","DISCHRG_CHKLST_ADD_DTLS"); //Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
		
		isAutoPopDurationApplyn = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","AUTO_POPULATE_DURATION"); //Added by Mano on 19-Mar-2018 aganist ML-MMOH-CRF-1049 
		isItemOnLoanOthersDisableDateAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP", "ADD_ITEMS_AND_DISBL_DATE"); //Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218
		
		pstmt = con.prepareStatement(" select WITNESS_ID,RETURNED_YN,RETURNED_BY_ID from pr_patient_valuables WHERE facility_id = '"+facilityid+"' AND encounter_id = '"+encounter_id+"' ");

		rset = pstmt.executeQuery();
		if (rset.next())
		{
			h_vlb_returned = rset.getString("RETURNED_YN");
			h_vlb_user = rset.getString("RETURNED_BY_ID");
			h_witness_id = rset.getString("WITNESS_ID");
		}
		if(rset!=null)rset.close();
		if(pstmt!=null)pstmt.close();

		SqlSB.append(" select FACILITY_ID,ENCOUNTER_ID,PATIENT_ID,DISCHARGE_MEDICATION_YN,DISCH_SUMMARY_SIGNED_YN,DISCH_SUMMARY_PREP_BY_ID,");		SqlSB.append("INFORMED_YN,MEDICAL_CERT_AVAIL_YN,REM_ITEM01_YN,REM_ITEM01_REMOVED_BY,to_char(REM_ITEM01_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM01_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM02_YN,REM_ITEM02_REMOVED_BY,to_char(REM_ITEM02_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM02_REMOVED_DATE,REM_ITEM03_YN,REM_ITEM03_REMOVED_BY,to_char(REM_ITEM03_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM03_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM04_YN,REM_ITEM04_REMOVED_BY,to_char(REM_ITEM04_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM04_REMOVED_DATE,REM_ITEM05_YN,REM_ITEM05_REMOVED_BY,to_char(REM_ITEM05_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM05_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM06_YN,REM_ITEM06_REMOVED_BY,to_char(REM_ITEM06_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM06_REMOVED_DATE,REM_ITEM07_YN,REM_ITEM07_REMOVED_BY,to_char(REM_ITEM07_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM07_REMOVED_DATE,");
		SqlSB.append(" REM_ITEM08_YN,REM_ITEM08_REMOVED_BY,to_char(REM_ITEM08_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM08_REMOVED_DATE,REM_ITEM09_YN,REM_ITEM09_REMOVED_BY,to_char(REM_ITEM09_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM09_REMOVED_DATE,");
		SqlSB.append(" BELONGINGS_RETN_YN,to_char(BELONGINGS_RETN_DATE,'dd/mm/rrrr hh24:mi')BELONGINGS_RETN_DATE,");		
		SqlSB.append(" BELONGINGS_REMARKS, VALUABLES_RETN_YN,VALUABLES_RETN_BY_ID, VALUABLES_WITNESS_ID, TRANSPORT_ARRANGED_YN, to_char(TRANSPORT_ARRANGED_DATE,'dd/mm/rrrr hh24:mi')TRANSPORT_ARRANGED_DATE,TRANSPORT_REMARKS,HED_ADVICE_GIVEN_TO,HED_ITEM01_YN,HED_ITEM01_GIVEN_BY,to_char(HED_ITEM01_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM01_DATE,");
		SqlSB.append(" HED_ITEM02_YN,HED_ITEM02_GIVEN_BY,to_char(HED_ITEM02_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM02_DATE,HED_ITEM03_YN,HED_ITEM03_GIVEN_BY,to_char(HED_ITEM03_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM03_DATE,HED_ITEM04_YN,HED_ITEM04_GIVEN_BY,to_char(HED_ITEM04_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM04_DATE,HED_ITEM05_YN,HED_ITEM05_GIVEN_BY,to_char(HED_ITEM05_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM05_DATE,HED_ITEM06_YN,HED_ITEM06_GIVEN_BY,to_char(HED_ITEM06_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM06_DATE,HED_ITEM07_YN,HED_ITEM07_GIVEN_BY,to_char(HED_ITEM07_DATE,'dd/mm/rrrr hh24:mi')HED_ITEM07_DATE,HED_OTHERS_YN,HED_OTHERS,HED_OTHERS_GIVEN_BY,to_char(HED_OTHERS_DATE,'dd/mm/rrrr hh24:mi')HED_OTHERS_DATE,");		SqlSB.append("PHG_ITEM01_YN,PHG_ITEM02_YN,PHG_ITEM03_YN,PHG_ITEM04_YN,NUTR_ITEM01_YN,NUTR_ITEM02_YN,NUTR_ITEM03_YN,NUTR_ITEM04_YN,NUTR_ITEM05_YN,NUTR_ITEM06_YN,NUTR_ITEM07_YN,NUTR_ITEM08_YN,NUTR_ITEM09_YN,NUTR_ITEM10_YN,NUTR_ITEM11_YN,NUTR_ITEM12_YN,NUTR_ITEM13_YN,NUTR_ITEM14_YN,NUTR_ITEM15_YN,NUTR_ITEM16_YN,PLET_ITEM01_YN,");		SqlSB.append("PLET_ITEM02_YN,PLET_ITEM03_YN,PLET_ITEM04_YN,PLET_ITEM05_YN,PLET_ITEM06_YN,PLET_OTHERS,APF_ITEM01,APF_ITEM01_GIVEN_BY,to_char(APF_ITEM01_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM01_DATE,APF_ITEM02,APF_ITEM02_GIVEN_BY,to_char(APF_ITEM02_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM02_DATE,APF_ITEM03,APF_ITEM03_GIVEN_BY,to_char(APF_ITEM03_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM03_DATE,APF_ITEM04,APF_ITEM04_GIVEN_BY,to_char(APF_ITEM04_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM04_DATE,APF_ITEM05,APF_ITEM05_GIVEN_BY,to_char(APF_ITEM05_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM05_DATE,APF_ITEM06,APF_ITEM06_GIVEN_BY,to_char(APF_ITEM06_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM06_DATE,APF_ITEM07,APF_ITEM07_GIVEN_BY,to_char(APF_ITEM07_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM07_DATE,APF_ITEM08,APF_ITEM08_GIVEN_BY,to_char(APF_ITEM08_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM08_DATE,APF_ITEM09,APF_ITEM09_GIVEN_BY,to_char(APF_ITEM09_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM09_DATE,APF_ITEM10,APF_ITEM10_GIVEN_BY,to_char(APF_ITEM10_DATE,'dd/mm/rrrr hh24:mi')APF_ITEM10_DATE,");
		SqlSB.append(" ODC_REF_LTR_YN, ODC_REF_LTR_CONF_YN, ODC_ITEM01_YN, ODC_ITEM01_DETAIL1, ODC_ITEM01_DETAIL2, ODC_ITEM02_YN,ODC_ITEM02_DETAIL1, ODC_ITEM02_DETAIL2, ODC_OTHERS_YN,ODC_OTHERS_DESC, ODC_OTHERS_DETAIL1, ODC_OTHERS_DETAIL2,				LWA_RELATIONSHIP,to_char(LWA_DATE,'dd/mm/rrrr hh24:mi')LWA_DATE,LWA_REMARKS,SCH_PATIENT_NAME,SCH_MOTHERS_NRIC,SCH_R_NURSE,SCH_WARD,to_char(SCH_DATE_OF_DISCH,'dd/mm/rrrr hh24:mi')SCH_DATE_OF_DISCH,");		SqlSB.append("SCH_WEIGHT,SCH_LENGTH,SCH_HEAD_CIR,SCH_ADVICE_GIVEN_TO,SCH_RELATIONSHIP,DISCH_CHKLIST_STATUS,DISCH_CHKLIST_PREPARED_BY,DISCH_CHKLIST_CONFIRMED_BY,ADDED_BY_ID,ADDED_DATE,ADDED_FACILITY_ID,ADDED_AT_WS_NO,MODIFIED_BY_ID,to_char(MODIFIED_DATE,'dd/mm/rrrr hh24:mi')MODIFIED_DATE,MODIFIED_FACILITY_ID,MODIFIED_AT_WS_NO,SCH_MOTHERS_NAME, SCH_FATHERS_NAME, SCH_FATHERS_NRIC, SCH_OTHER, REM_ITEM01_REMOVE_YN, REM_ITEM01_REMARKS, REM_ITEM02_REMOVE_YN, REM_ITEM02_REMARKS, REM_ITEM03_REMOVE_YN, REM_ITEM03_REMARKS, REM_ITEM04_REMOVE_YN, REM_ITEM04_REMARKS, REM_ITEM06_REMOVE_YN, REM_ITEM06_REMARKS, REM_ITEM08_REMOVE_YN, REM_ITEM08_REMARKS, REM_ITEM09_REMOVE_YN, REM_ITEM09_REMARKS, REM_ITEM10_REMARKS, REM_ITEM10_REMOVED_BY, to_char(REM_ITEM10_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM10_REMOVED_DATE, REM_ITEM10_REMOVE_YN, REM_ITEM10_YN, REM_ITEM11_REMARKS, REM_ITEM11_REMOVED_BY, to_char(REM_ITEM11_REMOVED_DATE,'dd/mm/rrrr hh24:mi')REM_ITEM11_REMOVED_DATE, REM_ITEM11_REMOVE_YN, REM_ITEM11_YN,CHARGEABLE_ITEM_YN from IP_DISCHARGE_CHECKLIST where facility_id = ? and encounter_id = ? ");//CHARGEABLE_ITEM_YN Added by chandra for MMS-KH-CRF-0052.1
		//Above query modified by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142
		//Above query modified by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218

		pstmt = con.prepareStatement(SqlSB.toString());
		pstmt.setString(1,facilityid);
		pstmt.setString(2,encounter_id);

		rset = pstmt.executeQuery();
		while(rset.next())
		{
			 h_dis_medication    = checkForNull(rset.getString("DISCHARGE_MEDICATION_YN"));
			 h_chargeable_item_yn = checkForNull(rset.getString("CHARGEABLE_ITEM_YN"));//Added for MMS-KH-CRF-0052.1
			 h_dis_summ_prep    = checkForNull(rset.getString("DISCH_SUMMARY_SIGNED_YN"));	
			 h_dis_summ_prep_by    = checkForNull(rset.getString("DISCH_SUMMARY_PREP_BY_ID"));	
			 h_informed_to    = checkForNull(rset.getString("INFORMED_YN"));	
			 h_cert_no    = checkForNull(rset.getString("MEDICAL_CERT_AVAIL_YN"));	
			 h_iv_catheters_chk    = checkForNull(rset.getString("REM_ITEM01_YN"));	
			 h_iv_removed_by    = checkForNull(rset.getString("REM_ITEM01_REMOVED_BY"));	
			 h_iv_removed_dt    = checkForNull(rset.getString("REM_ITEM01_REMOVED_DATE"));	
			 h_tubes_chk    = checkForNull(rset.getString("REM_ITEM02_YN"));	
			 h_tubes_removed_by    =checkForNull(rset.getString("REM_ITEM02_REMOVED_BY"));	
			 h_tubes_removed_dt    = checkForNull(rset.getString("REM_ITEM02_REMOVED_DATE"));	
			 h_drg_chk    = checkForNull(rset.getString("REM_ITEM03_YN"));	
			 h_drg_removed_by    = checkForNull(rset.getString("REM_ITEM03_REMOVED_BY"));	
			 h_drg_removed_dt    = checkForNull(rset.getString("REM_ITEM03_REMOVED_DATE"));	
			 h_ngt_tube_chk    = checkForNull(rset.getString("REM_ITEM04_YN"));	
			 h_ngt_tube_removed_by    =checkForNull(rset.getString("REM_ITEM04_REMOVED_BY"));	
			 h_ngt_tube_removed_dt    = checkForNull(rset.getString("REM_ITEM04_REMOVED_DATE"));	
			 h_cngt_tube_chk    = checkForNull(rset.getString("REM_ITEM05_YN"));	
			 h_cngt_tube_removed_by    = checkForNull(rset.getString("REM_ITEM05_REMOVED_BY"));	
			 h_cngt_tube_removed_dt    = checkForNull(rset.getString("REM_ITEM05_REMOVED_DATE"));	
			 h_urn_chk    = checkForNull(rset.getString("REM_ITEM06_YN"));	
			 h_urn_removed_by    = checkForNull(rset.getString("REM_ITEM06_REMOVED_BY"));	
			 h_urn_removed_dt    = checkForNull(rset.getString("REM_ITEM06_REMOVED_DATE"));	
			 h_curn_chk    = checkForNull(rset.getString("REM_ITEM07_YN"));	
			 h_curn_removed_by    = checkForNull(rset.getString("REM_ITEM07_REMOVED_BY"));	
			 h_curn_removed_dt    =checkForNull(rset.getString("REM_ITEM07_REMOVED_DATE"));	
			 h_sto_chk    = checkForNull(rset.getString("REM_ITEM08_YN"));	
			 h_sto_removed_by    = checkForNull(rset.getString("REM_ITEM08_REMOVED_BY"));	
			 h_sto_removed_dt    =checkForNull(rset.getString("REM_ITEM08_REMOVED_DATE"));	
			 h_dressing_chk    = checkForNull(rset.getString("REM_ITEM09_YN"));	
			 h_dressing_removed_by    = checkForNull(rset.getString("REM_ITEM09_REMOVED_BY"));	
			 h_dressing_removed_dt    = checkForNull(rset.getString("REM_ITEM09_REMOVED_DATE"));	
			 h_blng_returned    =checkForNull(rset.getString("BELONGINGS_RETN_YN"));	
			 h_blng_returned_dt    = checkForNull(rset.getString("BELONGINGS_RETN_DATE"));	
			 h_blng_remarks    = checkForNull(rset.getString("BELONGINGS_REMARKS"));	
			 h_tp_arranged    = checkForNull(rset.getString("TRANSPORT_ARRANGED_YN"));	
			 h_tp_returned_dt    = checkForNull(rset.getString("TRANSPORT_ARRANGED_DATE"));	
			 h_tp_remarks    =checkForNull(rset.getString("TRANSPORT_REMARKS"));			
			 h_adv_cnt_given    = checkForNull(rset.getString("HED_ADVICE_GIVEN_TO"));		
			 /*Added by Ashwini on 01-Aug-2018 for ML-MMOH-CRF-1218*/
			 h_itemloan_chk			= checkForNull(rset.getString("REM_ITEM10_YN"));	
			 h_itemloan_removed_by	= checkForNull(rset.getString("REM_ITEM10_REMOVED_BY"));	
			 h_itemloan_removed_dt	= checkForNull(rset.getString("REM_ITEM10_REMOVED_DATE"));	
			 h_itemloan_remove_chk	= checkForNull(rset.getString("REM_ITEM10_REMOVE_YN"));	
			 h_itemloan_remarks		= checkForNull(rset.getString("REM_ITEM10_REMARKS"));
			 h_others_chk			= checkForNull(rset.getString("REM_ITEM11_YN"));	
			 h_others_removed_by	= checkForNull(rset.getString("REM_ITEM11_REMOVED_BY"));	
			 h_others_removed_dt	= checkForNull(rset.getString("REM_ITEM11_REMOVED_DATE"));	
			 h_others_remove_chk	= checkForNull(rset.getString("REM_ITEM11_REMOVE_YN"));	
			 h_others_remarks		= checkForNull(rset.getString("REM_ITEM11_REMARKS"));
			 /*End ML-MMOH-CRF-1218*/

			 if(h_adv_cnt_given.equals("2"))
			 {
				h_adv_cnt_parent="Y";						
				h_adv_cnt_guardian="Y";						
			 }
			 else if(h_adv_cnt_given.equals("1"))
			 {
				h_adv_cnt_parent="N";						
				h_adv_cnt_guardian="Y";					
			 }
			 else if(h_adv_cnt_given.equals("0"))
			 {
				h_adv_cnt_parent="Y";						
				h_adv_cnt_guardian="N";					
			 }
			 else if(h_adv_cnt_given.equals(""))
			 {
				h_adv_cnt_parent="N";						
				h_adv_cnt_guardian="N";					
			 }
			 h_wc_chk    = checkForNull(rset.getString("HED_ITEM01_YN"));			
			 h_wc_given_by    = checkForNull(rset.getString("HED_ITEM01_GIVEN_BY"));			
			 h_wc_given_dt    = checkForNull(rset.getString("HED_ITEM01_DATE"));
			 h_nu_chk    = checkForNull(rset.getString("HED_ITEM02_YN"));
			 h_nu_given_by    = checkForNull(rset.getString("HED_ITEM02_GIVEN_BY"));
			 h_nu_given_dt    = checkForNull(rset.getString("HED_ITEM02_DATE"));
			 h_mc_chk    = checkForNull(rset.getString("HED_ITEM03_YN"));
			 h_mc_given_by    = checkForNull(rset.getString("HED_ITEM03_GIVEN_BY"));
			 h_mc_given_dt    =checkForNull(rset.getString("HED_ITEM03_DATE"));
			 h_ph_chk    = checkForNull(rset.getString("HED_ITEM04_YN"));
			 h_ph_given_by    = checkForNull(rset.getString("HED_ITEM04_GIVEN_BY"));
			 h_ph_given_dt    = checkForNull(rset.getString("HED_ITEM04_DATE"));
			 h_cop_chk    = checkForNull(rset.getString("HED_ITEM05_YN"));
			 h_cop_given_by    =checkForNull(rset.getString("HED_ITEM05_GIVEN_BY"));
			 h_cop_given_dt    = checkForNull(rset.getString("HED_ITEM05_DATE"));
			 h_coc_chk    = checkForNull(rset.getString("HED_ITEM06_YN"));
			 h_coc_given_by    = checkForNull(rset.getString("HED_ITEM06_GIVEN_BY"));
			 h_coc_given_dt    = checkForNull(rset.getString("HED_ITEM06_DATE"));
			 h_cot_chk    = checkForNull(rset.getString("HED_ITEM07_YN"));
			 h_cot_given_by    = checkForNull(rset.getString("HED_ITEM07_GIVEN_BY"));
			 h_cot_given_dt    = checkForNull(rset.getString("HED_ITEM07_DATE"));
			 h_oth_he_chk    = checkForNull(rset.getString("HED_OTHERS_YN"));
			 h_oth_text    =checkForNull(rset.getString("HED_OTHERS"));
			 h_oth_given_by    = checkForNull(rset.getString("HED_OTHERS_GIVEN_BY"));
			 h_oth_given_dt    = checkForNull(rset.getString("HED_OTHERS_DATE"));
			 h_top_to_toe_chk    = checkForNull(rset.getString("PHG_ITEM01_YN"));
			 h_co_umb_stmp_chk    = checkForNull(rset.getString("PHG_ITEM02_YN"));
			 h_care_of_skin_chk    = checkForNull(rset.getString("PHG_ITEM03_YN"));
			 h_care_of_eye_chk    = checkForNull(rset.getString("PHG_ITEM04_YN"));
			 h_expr_br_mlk_chk    =checkForNull(rset.getString("NUTR_ITEM01_YN"));
			 h_tube_feed_chk    =checkForNull(rset.getString("NUTR_ITEM02_YN"));
			 h_gst_feed_chk    = checkForNull(rset.getString("NUTR_ITEM03_YN"));
			 h_frm_milk_chk    = checkForNull(rset.getString("NUTR_ITEM04_YN"));
			 h_imn_sch_chk    = checkForNull(rset.getString("NUTR_ITEM05_YN"));
			 h_care_of_stoma_chk    = checkForNull(rset.getString("NUTR_ITEM06_YN"));
			 h_anl_dil_chk    = checkForNull(rset.getString("NUTR_ITEM07_YN"));
			 h_pop_chk    =checkForNull(rset.getString("NUTR_ITEM08_YN"));
			 h_fever_chk    = checkForNull(rset.getString("NUTR_ITEM09_YN"));
			 h_sz_chk    = checkForNull(rset.getString("NUTR_ITEM10_YN"));
			 h_jnd_chk    = checkForNull(rset.getString("NUTR_ITEM11_YN"));
			 h_gpd_chk    = checkForNull(rset.getString("NUTR_ITEM12_YN"));
			 h_stlc_chk    = checkForNull(rset.getString("NUTR_ITEM13_YN"));
			 h_stlf_chk    = checkForNull(rset.getString("NUTR_ITEM14_YN"));
			 h_coptb_chk    =checkForNull(rset.getString("NUTR_ITEM15_YN"));
			 h_oth_ph_chk    = checkForNull(rset.getString("NUTR_ITEM16_YN"));

			 h_bfd_chk    = checkForNull(rset.getString("PLET_ITEM01_YN"));

			 h_stm_cr_chk    = checkForNull(rset.getString("PLET_ITEM02_YN"));
			 h_oper_chk    = checkForNull(rset.getString("PLET_ITEM03_YN"));
			 h_pop_care_chk    = checkForNull(rset.getString("PLET_ITEM04_YN"));
			 h_dn_given_chk    = checkForNull(rset.getString("PLET_ITEM05_YN"));
			 h_db_given_chk    = checkForNull(rset.getString("PLET_ITEM06_YN"));
			 h_oth_pamphlets    = checkForNull(rset.getString("PLET_OTHERS"));

			 h_oth_app_fix_item1    = checkForNull(rset.getString("APF_ITEM01"));
			 h_oth_app_fix_item1_given1  =checkForNull(rset.getString("APF_ITEM01_GIVEN_BY"));
			 h_oth_app_fix_item1_dt1  = checkForNull(rset.getString("APF_ITEM01_DATE"));
			 h_oth_app_fix_item2  = checkForNull(rset.getString("APF_ITEM02"));
			 h_oth_app_fix_item2_given2  = checkForNull(rset.getString("APF_ITEM02_GIVEN_BY"));
			 h_oth_app_fix_item2_dt2  = checkForNull(rset.getString("APF_ITEM02_DATE"));
			 h_oth_app_fix_item3  = checkForNull(rset.getString("APF_ITEM03"));
			 h_oth_app_fix_item3_given3  = checkForNull(rset.getString("APF_ITEM03_GIVEN_BY"));
			 h_oth_app_fix_item3_dt3  = checkForNull(rset.getString("APF_ITEM03_DATE"));

			 h_oth_app_fix_item4  = checkForNull(rset.getString("APF_ITEM04"));
			 h_oth_app_fix_item4_given4  = checkForNull(rset.getString("APF_ITEM04_GIVEN_BY"));
			 h_oth_app_fix_item4_dt4  = checkForNull(rset.getString("APF_ITEM04_DATE"));

			 h_oth_app_fix_item5  = checkForNull(rset.getString("APF_ITEM05"));
			 h_oth_app_fix_item5_given5  = checkForNull(rset.getString("APF_ITEM05_GIVEN_BY"));
			 h_oth_app_fix_item5_dt5  = checkForNull(rset.getString("APF_ITEM05_DATE"));

			 h_oth_app_fix_item6  = checkForNull(rset.getString("APF_ITEM06"));
			 h_oth_app_fix_item6_given6  = checkForNull(rset.getString("APF_ITEM06_GIVEN_BY"));
			 h_oth_app_fix_item6_dt6  = checkForNull(rset.getString("APF_ITEM06_DATE"));

			 h_oth_app_fix_item7  = checkForNull(rset.getString("APF_ITEM07"));
			 h_oth_app_fix_item7_given7  = checkForNull(rset.getString("APF_ITEM07_GIVEN_BY"));
			 h_oth_app_fix_item7_dt7  = checkForNull(rset.getString("APF_ITEM07_DATE"));

			 h_oth_app_fix_item8  = checkForNull(rset.getString("APF_ITEM08"));
			 h_oth_app_fix_item8_given8  = checkForNull(rset.getString("APF_ITEM08_GIVEN_BY"));
			 h_oth_app_fix_item8_dt8  = checkForNull(rset.getString("APF_ITEM08_DATE"));

			 h_oth_app_fix_item9  = checkForNull(rset.getString("APF_ITEM09"));
			 h_oth_app_fix_item9_given9  = checkForNull(rset.getString("APF_ITEM09_GIVEN_BY"));
			 h_oth_app_fix_item9_dt9  = checkForNull(rset.getString("APF_ITEM09_DATE"));
				
			 h_oth_app_fix_item10  = checkForNull(rset.getString("APF_ITEM10"));
			 h_oth_app_fix_item10_given10  = checkForNull(rset.getString("APF_ITEM10_GIVEN_BY"));
			 h_oth_app_fix_item10_dt10  = checkForNull(rset.getString("APF_ITEM10_DATE"));

			 h_ref_ltr_chk  = checkForNull(rset.getString("ODC_REF_LTR_YN"));
			 h_ref_ltr_conf_chk  = checkForNull(rset.getString("ODC_REF_LTR_CONF_YN"));

			 h_rep_ltr_chk  = checkForNull(rset.getString("ODC_ITEM01_YN"));
			 h_rep_ltr_dtls  = checkForNull(rset.getString("ODC_ITEM01_DETAIL1"));
			 h_rep_ltr_conf  = checkForNull(rset.getString("ODC_ITEM01_DETAIL2"));

			 h_cln_doc_chk  = checkForNull(rset.getString("ODC_ITEM02_YN"));
			 h_cln_doc_dtls  = checkForNull(rset.getString("ODC_ITEM02_DETAIL1"));
			 h_cln_doc_conf  = checkForNull(rset.getString("ODC_ITEM02_DETAIL2"));

			 h_oth_doc_chk  = checkForNull(rset.getString("ODC_OTHERS_YN"));
			 h_oth_doc_desc  = checkForNull(rset.getString("ODC_OTHERS_DESC"));
			 h_oth_doc_dtls  = checkForNull(rset.getString("ODC_OTHERS_DETAIL1"));
			 h_oth_doc_conf  = checkForNull(rset.getString("ODC_OTHERS_DETAIL2"));

			 h_relationship  = checkForNull(rset.getString("LWA_RELATIONSHIP"));
			 h_rel_date_time  = checkForNull(rset.getString("LWA_DATE"));
			 h_rem_lv_ward  = checkForNull(rset.getString("LWA_REMARKS"));

			 h_name_of_patient  = checkForNull(rset.getString("SCH_PATIENT_NAME"));
			 h_mot_ic_no  =checkForNull(rset.getString("SCH_MOTHERS_NRIC"));
			 h_rn_txt  =checkForNull(rset.getString("SCH_R_NURSE"));
			 h_ward_txt  = checkForNull(rset.getString("SCH_WARD"));
			 h_discharge_date  = checkForNull(rset.getString("SCH_DATE_OF_DISCH"));
			 h_weight_txt  = checkForNull(rset.getString("SCH_WEIGHT"));
			 h_length_txt  = checkForNull(rset.getString("SCH_LENGTH"));
			 h_head_circum  = checkForNull(rset.getString("SCH_HEAD_CIR"));
			 h_adv_given  = checkForNull(rset.getString("SCH_ADVICE_GIVEN_TO"));
			 h_relationship_txt  = checkForNull(rset.getString("SCH_RELATIONSHIP"));
			 
			 h_mother_name  = checkForNull(rset.getString("SCH_MOTHERS_NAME"));
			 h_mother_no  = checkForNull(rset.getString("SCH_MOTHERS_NRIC"));
			 h_father_name  = checkForNull(rset.getString("SCH_FATHERS_NAME"));
			 h_father_no  = checkForNull(rset.getString("SCH_FATHERS_NRIC"));
			 h_Remarks  = checkForNull(rset.getString("SCH_OTHER"));
				
			 /*Added by Ashwini on 25-Apr-2018 for ML-MMOH-CRF-1142*/
			 h_iv_remove_chk		= checkForNull(rset.getString("REM_ITEM01_REMOVE_YN"));	
			 h_iv_remarks			= checkForNull(rset.getString("REM_ITEM01_REMARKS"));
			 h_tubes_remove_chk		= checkForNull(rset.getString("REM_ITEM02_REMOVE_YN"));	
			 h_tubes_remarks		= checkForNull(rset.getString("REM_ITEM02_REMARKS"));
			 h_drg_remove_chk		= checkForNull(rset.getString("REM_ITEM03_REMOVE_YN"));	
			 h_drg_remarks			= checkForNull(rset.getString("REM_ITEM03_REMARKS"));
			 h_ngt_remove_chk		= checkForNull(rset.getString("REM_ITEM04_REMOVE_YN"));	
			 h_ngt_remarks			= checkForNull(rset.getString("REM_ITEM04_REMARKS"));
			 h_urn_remove_chk		= checkForNull(rset.getString("REM_ITEM06_REMOVE_YN"));	
			 h_urn_remarks			= checkForNull(rset.getString("REM_ITEM06_REMARKS"));
			 h_sto_remove_chk		= checkForNull(rset.getString("REM_ITEM08_REMOVE_YN"));	
			 h_sto_remarks			= checkForNull(rset.getString("REM_ITEM08_REMARKS"));
			 h_dressing_remove_chk	= checkForNull(rset.getString("REM_ITEM09_REMOVE_YN"));	
			 h_dressing_remarks		= checkForNull(rset.getString("REM_ITEM09_REMARKS"));
			 /*End ML-MMOH-CRF-1142*/

			 disch_chklist_status  = checkForNull(rset.getString("DISCH_CHKLIST_STATUS"));				
			 h_user_txt=checkForNull(rset.getString("DISCH_CHKLIST_CONFIRMED_BY"));
			 if(h_user_txt.equals(""))
				 h_user_txt  = checkForNull(rset.getString("DISCH_CHKLIST_PREPARED_BY"));
	
			 h_date_time_txt  =checkForNull(rset.getString("MODIFIED_DATE"));	
		}

		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();

		if (SqlSB.length() > 0)
			SqlSB.delete(0, SqlSB.length());

		SqlSB.append(" select to_char(DATE_OF_BIRTH,'dd/mm/rrrr')dob, calculate_age(to_char(date_of_birth,'dd/mm/rrrr'),1)age,to_char(sysdate,'dd/mm/rrrr hh24:mi') dttm,(SELECT to_char(admission_date_time, 'dd/mm/rrrr hh24:mi')admission_date_time FROM IP_OPEN_ENCOUNTER WHERE facility_id = '"+facilityid+"' AND encounter_id = '"+encounter_id+"' AND patient_id = '"+patient_id+"') admission_date_time ");
		SqlSB.append(" , (Select to_char(MAX(TRN_DATE_TIME),'dd/mm/rrrr hh24:mi') trn_date_time from IP_ADT_TRN where encounter_id = '"+encounter_id+"' and facility_id  = '"+facilityid+"')max_trn_date_time ");
		SqlSB.append(" from mp_patient where patient_id='"+patient_id+"' ");
		pstmt = con.prepareStatement(SqlSB.toString());
		rset = pstmt.executeQuery();
		while(rset.next())
		{
			dob    = checkForNull(rset.getString("dob"));
			age    = rset.getString("age")==null?"0":rset.getString("age");	
			admission_date_time = rset.getString("admission_date_time");
			system_date         = rset.getString("dttm");	
			max_trn_date_time	= checkForNull(rset.getString("max_trn_date_time"));
		}
		if (rset != null) rset.close();
		if (pstmt != null) pstmt.close();
		patient_age = Integer.parseInt(age);
		system_date_display = DateUtils.convertDate(system_date,"DMYHM","en",locale);
	}catch(Exception e){	e.printStackTrace();}
	finally
	{
		if(con!=null)ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	
	if(patient_age <= 12)  
	{	
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	}	
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	if(patient_age <= 12)
	{	
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
	}	
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(h_iv_catheters_chk));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(h_iv_removed_by));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(h_iv_removed_dt));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(h_tubes_chk));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(h_tubes_removed_by));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(h_tubes_removed_dt));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(h_drg_chk));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(h_drg_removed_by));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(h_drg_removed_dt));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(h_ngt_tube_chk));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(h_ngt_tube_removed_by));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(h_ngt_tube_removed_dt));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(h_cngt_tube_chk));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(h_cngt_tube_removed_by));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(h_cngt_tube_removed_dt));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(h_urn_chk));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(h_urn_removed_by));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(h_urn_removed_dt));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(h_curn_chk));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(h_curn_removed_by));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(h_curn_removed_dt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(h_sto_chk));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(h_sto_removed_by));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(h_sto_removed_dt));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(h_dressing_chk));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(h_dressing_removed_by));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(h_dressing_removed_dt));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(h_blng_returned));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(h_blng_returned_dt));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(h_blng_remarks));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(h_vlb_returned));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(h_vlb_returned_by));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(h_vlb_witness));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(h_witness_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(h_vlb_user));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(h_tp_arranged));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(h_tp_returned_dt));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(h_tp_remarks));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(h_adv_cnt_parent));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(h_adv_cnt_guardian));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(h_wc_chk));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(h_wc_given_by));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(h_wc_given_dt));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(h_nu_chk));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(h_nu_given_by));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(h_nu_given_dt));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(h_mc_chk));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(h_mc_given_by));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(h_mc_given_dt));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(h_ph_chk));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(h_ph_given_by));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(h_ph_given_dt));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(h_cop_chk));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(h_cop_given_by));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(h_cop_given_dt));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(h_coc_chk));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(h_coc_given_by));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(h_coc_given_dt));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(h_cot_chk));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(h_cot_given_by));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(h_cot_given_dt));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(h_oth_he_chk));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(h_oth_text));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(h_oth_given_by));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(h_oth_given_dt));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(h_top_to_toe_chk));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(h_top_to_toe_chk));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(h_care_of_skin_chk));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(h_care_of_eye_chk));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(h_expr_br_mlk_chk));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(h_tube_feed_chk));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(h_gst_feed_chk));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(h_frm_milk_chk));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(h_imn_sch_chk));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(h_care_of_stoma_chk));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(h_anl_dil_chk));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(h_pop_chk));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(h_fever_chk));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(h_sz_chk));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(h_jnd_chk));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(h_gpd_chk));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(h_stlc_chk));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(h_stlf_chk));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(h_coptb_chk));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(h_oth_ph_chk));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(h_bfd_chk));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(h_stm_cr_chk));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(h_oper_chk));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(h_pop_care_chk));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(h_oth_pamphlets));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(h_dn_given_chk));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(h_db_given_chk));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(h_oth_app_fix_item1));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(h_oth_app_fix_item1_given1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(h_oth_app_fix_item1_dt1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(h_oth_app_fix_item2));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(h_oth_app_fix_item2_given2));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(h_oth_app_fix_item2_dt2));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(h_oth_app_fix_item3));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(h_oth_app_fix_item3_given3));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(h_oth_app_fix_item3_dt3));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(h_oth_app_fix_item4));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(h_oth_app_fix_item4_given4));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(h_oth_app_fix_item4_dt4));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(h_oth_app_fix_item5));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(h_oth_app_fix_item5_given5));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(h_oth_app_fix_item5_dt5));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(h_oth_app_fix_item6));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(h_oth_app_fix_item6_given6));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(h_oth_app_fix_item6_dt6));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(h_oth_app_fix_item7));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(h_oth_app_fix_item7_given7));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(h_oth_app_fix_item7_dt7));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(h_oth_app_fix_item8));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(h_oth_app_fix_item8_given8));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(h_oth_app_fix_item8_dt8));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(h_oth_app_fix_item9));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(h_oth_app_fix_item9_given9));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(h_oth_app_fix_item9_dt9));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(h_oth_app_fix_item10));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(h_oth_app_fix_item10_given10));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(h_oth_app_fix_item10_dt10));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(h_ref_ltr_chk));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(h_ref_ltr_conf_chk));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(h_rep_ltr_chk));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(h_rep_ltr_dtls));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(h_rep_ltr_conf));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(h_cln_doc_chk));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(h_cln_doc_dtls));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(h_cln_doc_conf));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(h_oth_doc_chk));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(h_oth_doc_dtls));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(h_oth_doc_conf));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(h_oth_doc_desc));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(h_relationship));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(h_rel_date_time));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(h_rem_lv_ward));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(h_name_of_patient));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(h_mot_ic_no));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(h_rn_txt));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(h_ward_txt));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(h_discharge_date));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(h_weight_txt));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(h_length_txt));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(h_head_circum));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(h_adv_given));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(h_relationship_txt));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(h_mother_name));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(h_mother_no));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(h_father_name));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(h_father_no));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(h_Remarks));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(h_dis_medication));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(h_dis_summ_prep));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(h_dis_summ_prep_by));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(h_informed_to));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(h_cert_no));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(system_date));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(h_chargeable_item_yn));
            _bw.write(_wl_block173Bytes, _wl_block173);


if(!disch_chklist_status.equals("")) operation="modify";
else operation = "insert"; 
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(operation));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(h_iv_catheters_chk));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(h_iv_removed_by));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(h_iv_removed_dt));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(h_tubes_chk));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(h_tubes_removed_by));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(h_tubes_removed_dt));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(h_drg_chk));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(h_drg_removed_by));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(h_drg_removed_dt));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(h_ngt_tube_chk));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(h_ngt_tube_removed_by));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(h_ngt_tube_removed_dt));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(h_cngt_tube_chk));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(h_cngt_tube_removed_by));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(h_cngt_tube_removed_dt));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(h_urn_chk));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(h_urn_removed_by));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(h_urn_removed_dt));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(h_curn_chk));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(h_curn_removed_by));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(h_curn_removed_dt));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(h_sto_chk));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(h_sto_removed_by));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(h_sto_removed_dt));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(h_dressing_chk));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(h_dressing_removed_by));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(h_dressing_removed_dt));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(h_blng_returned));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(h_blng_returned_dt));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(h_blng_remarks));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(h_vlb_returned));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(h_vlb_user));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(h_witness_id));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(h_witness_id));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(h_vlb_user));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(h_tp_arranged));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(h_tp_returned_dt));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(h_tp_remarks));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(h_adv_cnt_parent));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(h_adv_cnt_guardian));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(h_wc_chk));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(h_wc_given_by));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(h_wc_given_dt));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(h_nu_chk));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(h_nu_given_by));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(h_nu_given_dt));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(h_mc_chk));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(h_mc_given_by));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(h_mc_given_dt));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(h_ph_chk));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(h_ph_given_by));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(h_ph_given_dt));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(h_cop_chk));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(h_cop_given_by));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(h_cop_given_dt));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(h_coc_chk));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(h_coc_given_by));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(h_coc_given_dt));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(h_cot_chk));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(h_cot_given_by));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(h_cot_given_dt));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(h_oth_he_chk));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(h_oth_text));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(h_oth_given_by));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(h_oth_given_dt));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(h_top_to_toe_chk));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(h_co_umb_stmp_chk));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(h_care_of_skin_chk));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(h_care_of_eye_chk));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(h_expr_br_mlk_chk));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(h_tube_feed_chk));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(h_gst_feed_chk));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(h_frm_milk_chk));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(h_imn_sch_chk));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(h_care_of_stoma_chk));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(h_anl_dil_chk));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(h_pop_chk));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(h_fever_chk));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(h_sz_chk));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(h_jnd_chk));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(h_gpd_chk));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(h_stlc_chk));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf(h_stlf_chk));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(h_coptb_chk));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(h_oth_ph_chk));
            _bw.write(_wl_block263Bytes, _wl_block263);
            out.print( String.valueOf(h_bfd_chk));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(h_stm_cr_chk));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(h_oper_chk));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(h_pop_care_chk));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(h_oth_pamphlets));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(h_dn_given_chk));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(h_db_given_chk));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(h_oth_app_fix_item1));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(h_oth_app_fix_item1_given1));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(h_oth_app_fix_item1_dt1));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(h_oth_app_fix_item2));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(h_oth_app_fix_item2_given2));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(h_oth_app_fix_item2_dt2));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(h_oth_app_fix_item3));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(h_oth_app_fix_item3_given3));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(h_oth_app_fix_item3_dt3));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(h_oth_app_fix_item4));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(h_oth_app_fix_item4_given4));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(h_oth_app_fix_item4_dt4));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(h_oth_app_fix_item5));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(h_oth_app_fix_item5_given5));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(h_oth_app_fix_item5_dt5));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(h_oth_app_fix_item6));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(h_oth_app_fix_item6_given6));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(h_oth_app_fix_item6_dt6));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(h_oth_app_fix_item7));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(h_oth_app_fix_item7_given7));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(h_oth_app_fix_item7_dt7));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(h_oth_app_fix_item8));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(h_oth_app_fix_item8_given8));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(h_oth_app_fix_item8_dt8));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(h_oth_app_fix_item9));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(h_oth_app_fix_item9_given9));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(h_oth_app_fix_item9_dt9));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(h_oth_app_fix_item10));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(h_oth_app_fix_item10_given10));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(h_oth_app_fix_item10_dt10));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(h_ref_ltr_chk));
            _bw.write(_wl_block301Bytes, _wl_block301);
            out.print( String.valueOf(h_ref_ltr_conf_chk));
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(h_rep_ltr_chk));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(h_rep_ltr_dtls));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(h_rep_ltr_conf));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(h_cln_doc_chk));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(h_cln_doc_dtls));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(h_cln_doc_conf));
            _bw.write(_wl_block308Bytes, _wl_block308);
            out.print( String.valueOf(h_oth_doc_chk));
            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(h_oth_doc_dtls));
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(h_oth_doc_conf));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(h_oth_doc_desc));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(h_relationship));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(h_rel_date_time));
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(h_rem_lv_ward));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(h_name_of_patient));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(h_mot_ic_no));
            _bw.write(_wl_block317Bytes, _wl_block317);
            out.print( String.valueOf(h_rn_txt));
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(h_ward_txt));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(h_discharge_date));
            _bw.write(_wl_block320Bytes, _wl_block320);
            out.print( String.valueOf(h_weight_txt));
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(h_length_txt));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(h_head_circum));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(h_adv_given));
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(h_relationship_txt));
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(h_mother_name));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(h_mother_no));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(h_father_name));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(h_father_no));
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(h_Remarks));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(h_date_time_txt));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(h_user_txt));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(h_dis_medication));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(h_dis_summ_prep));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(h_dis_summ_prep_by));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(h_informed_to));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(h_cert_no));
            _bw.write(_wl_block337Bytes, _wl_block337);
            out.print( String.valueOf(patient_age));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block339Bytes, _wl_block339);
            out.print( String.valueOf(admission_date_time));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(system_date_display));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block342Bytes, _wl_block342);
            out.print( String.valueOf(max_trn_date_time));
            _bw.write(_wl_block343Bytes, _wl_block343);
            out.print( String.valueOf(cert_num));
            _bw.write(_wl_block344Bytes, _wl_block344);
            out.print( String.valueOf(cert_from_date));
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(cert_to_date));
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(duration));
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(duration_dmy));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(deli_cert_num));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(isChangesInAdditionalDtlsTabAppl));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(h_iv_remove_chk));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(h_iv_remarks));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(h_tubes_remove_chk));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(h_tubes_remarks));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(h_drg_remove_chk));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(h_drg_remarks));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(h_ngt_remove_chk));
            _bw.write(_wl_block357Bytes, _wl_block357);
            out.print( String.valueOf(h_ngt_remarks));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(h_urn_remove_chk));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(h_urn_remarks));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(h_sto_remove_chk));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(h_sto_remarks));
            _bw.write(_wl_block362Bytes, _wl_block362);
            out.print( String.valueOf(h_dressing_remove_chk));
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(h_dressing_remarks));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(h_iv_remove_chk));
            _bw.write(_wl_block365Bytes, _wl_block365);
            out.print( String.valueOf(h_iv_remarks));
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(h_tubes_remove_chk));
            _bw.write(_wl_block367Bytes, _wl_block367);
            out.print( String.valueOf(h_tubes_remarks));
            _bw.write(_wl_block368Bytes, _wl_block368);
            out.print( String.valueOf(h_drg_remove_chk));
            _bw.write(_wl_block369Bytes, _wl_block369);
            out.print( String.valueOf(h_drg_remarks));
            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(h_ngt_remove_chk));
            _bw.write(_wl_block371Bytes, _wl_block371);
            out.print( String.valueOf(h_ngt_remarks));
            _bw.write(_wl_block372Bytes, _wl_block372);
            out.print( String.valueOf(h_urn_remove_chk));
            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(h_urn_remarks));
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(h_sto_remove_chk));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(h_sto_remarks));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(h_dressing_remove_chk));
            _bw.write(_wl_block377Bytes, _wl_block377);
            out.print( String.valueOf(h_dressing_remarks));
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(isAutoPopDurationApplyn));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(isItemOnLoanOthersDisableDateAppl));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(h_itemloan_chk));
            _bw.write(_wl_block381Bytes, _wl_block381);
            out.print( String.valueOf(h_itemloan_removed_by));
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(h_itemloan_removed_dt));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(h_itemloan_remove_chk));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(h_itemloan_remarks));
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(h_itemloan_chk));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(h_itemloan_removed_by));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(h_itemloan_removed_dt));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(h_itemloan_remove_chk));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(h_itemloan_remarks));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(h_others_chk));
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(h_others_removed_by));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(h_others_removed_dt));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(h_others_remove_chk));
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(h_others_remarks));
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(h_others_chk));
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(h_others_removed_by));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(h_others_removed_dt));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(h_others_remove_chk));
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(h_others_remarks));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(h_chargeable_item_yn));
            _bw.write(_wl_block401Bytes, _wl_block401);

	if(call_function.equals("VIEW_DISCHARGE_CHECKLIST"))
	{

            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(user_name));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(p_resp_id));
            _bw.write(_wl_block405Bytes, _wl_block405);

	}

            _bw.write(_wl_block406Bytes, _wl_block406);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.DischargeDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.additionaldetails.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.HealthEducation.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PaediatricDetails.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ApplFixturesDocuments.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SupportiveCare.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }
}
