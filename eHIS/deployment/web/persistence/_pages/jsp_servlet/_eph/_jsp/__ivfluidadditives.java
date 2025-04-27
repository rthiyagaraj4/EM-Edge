package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivfluidadditives extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVFluidAdditives.jsp", 1709245426947L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t\t<!-- \timport the calendar script -->\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script> \n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/dchk.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/DrugNameCommonLookup.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescription.js\"></SCRIPT>\n\t</HEAD>\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t<FORM name=\"formIVPrescriptionAdditives\" id=\"formIVPrescriptionAdditives\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\" style=\"border-color:#004080;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t\t<TD colspan=\"9\" class=\"label\" align=\"right\" >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t\t<!--  RUT-CRF-0062 [IN029600]  buildMAR_enable added below to enable/disable based on Build MAR Rule -->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="  onclick=\'assignValue(this);\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\' disabled>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t\t<TR>  \n\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\"8%\">\n\t\t\t\t\t\t\t\t\t\t\t<img  style=\"visibility:";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"id=\"ADR_img_";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\" src=\'../../ePH/images/ADR.gif\' height =20 width =20 title=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' ></img>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"active";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\" id=\"active";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" value=\"Y\" checked style=\"visibility:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"color:red;font-weight:bold\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<TD width=\"20%\" class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"FLUID_NAME";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"FLUID_NAME";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" VALUE=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  SIZE=\"40\" MAXLENGTH=\"40\" onChange=\"searchIVFluid1(formIVPrescriptionAdditives,\'D\', FLUID_NAME";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =",1)\"><!-- added for SKR-SCF-1391 -->\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<!-- COMMENTED for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"fluid_search1\" id=\"fluid_search1\" value=\"?\" ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" onclick=\"searchIVFluid1(formIVPrescriptionAdditives,\'D\', FLUID_NAME";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =",1)\" ><!-- REMOVED onfocus for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'>  <!-- newly added for  Bru-HIMS-CRF-347 [IN:037862]  -->\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"disp_locn1\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" </label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  width=\'11%\' nowrap><!--now rap added for MMS Internal Testing -->\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"disp_locn_desc";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"><b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"per_facility_id";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" id=\"per_facility_id";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"disp_locn_code";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"disp_locn_code";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"disp_locn_type";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"disp_locn_type";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" value=\' \'/><!--Added for MMS Internal Testing -->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"17%\" id=\'tdDuration";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' style=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<label  id=\"duration";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"DURATION";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"DURATION";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" SIZE=\"1\" MAXLENGTH=\"3\" CLASS=\"number\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" onBlur=\"CheckNum(this);chkDurationAD(DURATION";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =",";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 =");strtEndDateTime(";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="); return validateDuration(this,INFUSION_PERIOD_VALUE";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =",InfusionRateUnit";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =",INFUSION_PERIOD_VALUE_MIN";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 =",\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\');\" onKeyPress=\"return allowValidNumber(this,event,3,0);\"  tabIndex=\"-1\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =">\n\t\t\t\t\t\t\t\t\t\t\t<label id=\'durn_unit";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' class=\"label\" ><b>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</b>\t</label>\n\t\t\t\t\t\t\t\t\t\t\t<br><label id=\"ForRepeat_leg";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju--></label>\n\t\t\t\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'8%\'>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"start_time_leg1\">";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'10%\' nowrap><!--now rap added for MMS Internal Testing -->\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"START_DATE";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"START_DATE";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"   SIZE=\"14\" MAXLENGTH=\"16\" onBlur=\"chkDurationAD(DURATION";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="); strtEndDateTime(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =");\" style=\"visibility:visible\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =">\n\t\t\t\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\"Calendar";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" onclick=\"showCalendar(\'START_DATE";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\',null,\'hh:mm\');document.formIVPrescriptionAdditives.START_DATE";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =".focus();return false;\" style=\"visibility:visible\" ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =">\n\t\t\t\t\t\t\t\t\t\t</td> \n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'7%\' >\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"end_time_leg1\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'8%\'><INPUT TYPE=\"text\" name=\"END_DATE";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"END_DATE";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"  SIZE=\"14\" MAXLENGTH=\"16\" READONLY style=\"visibility:visible\" ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\t\t\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FLUID_CODE";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" id=\"FLUID_CODE";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"INF_RATE_UOM";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" id=\"INF_RATE_UOM";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"stock_uom_code";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" id=\"stock_uom_code";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"stock_value";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"stock_value";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_volume";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"base_volume";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"INFUSION_PERIOD_UOM";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"INFUSION_PERIOD_UOM";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" VALUE=\'\' >\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"infusion_over_insert_value";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" id=\"infusion_over_insert_value";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" VALUE=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' >\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"mfr_yn";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" id=\"mfr_yn";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' >\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"volume_reference";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" id=\"volume_reference";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"  >\n\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap style=\"visibility:visible\" id=\"TDstrenght";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"  >\n\t\t\t\t\t\t\t\t\t\t<label ";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 =">";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</label>\n\t\t\t\t\t\t\t\t\t    ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t\t    <label id=\"strength_label";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" class=\"label\" style=\"font-size:12px;\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</label></td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"inf_rate_leg1\">";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" CLASS=\"number\" name=\"INF_RATE";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"INF_RATE";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" SIZE=\"3\" MAXLENGTH=\"7\"  onBlur=\"CheckNum(this);calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =",INF_RATE";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 =",infusionOverStr";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =");chkDurationAD(DURATION";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 =");\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" style=\"visibility:visible\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\"  ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 =">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" SIZE=\"3\" MAXLENGTH=\"7\"  onBlur=\"CheckNum(this);validateRate(this,volume";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =",INFUSION_PERIOD_VALUE";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 =",DURATION";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\');chkDurationAD(DURATION";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- <label id=\'uom_display1\' class=\"label\"><b>";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="/Hr</b></label> -->\n\t\t\t\t\t\t\t\t\t\t\t<label id=\'uom_display1\' class=\"label\" style=\"font-size:9px;\"><b>";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\n\t\t\t\t\t\t\t\t\t\t\t<select name=\"InfusionRateUnit";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"InfusionRateUnit";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\" onChange=\"ChangeInfuseOverTime(this,\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\');calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 =">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\');validateRate(INF_RATE";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 =",volume";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\')\" style=\"visibility:visible\" ";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =" >";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id=\"tdOrderQty_leg";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 =" <!--added for SKR-CRF-0035 start-->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" id=\"tdOrd_qty";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" style=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' class=\"NUMBER\" name=\'order_qty";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\' id=\'order_qty";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' size=\"1\" maxlength=\"3\" value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' disabled>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' onKeyPress=\"return allowValidNumber(this,event,2,0);\" onchange=\"calcTotalVolume(\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\')\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"ord_qty_uom";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" class=\"label\" style=\"font-size:9px;\">";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' id=\"tdVolumePerUnit";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"volumePerUnit_leg";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="/";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"volumePerUnit";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" id=\"volumePerUnit";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" size=\"3\" class=\"NUMBER\" readOnly value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' >&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"volPerUnitUom_leg";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\" class=\"label\" style=\"font-size:9px;\"><b>";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\'";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\' id=\"Totalvolume_leg";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="</label>&nbsp;\n\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"volume_leg";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" disabled name=\"volume";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\" id=\"volume";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\" size=\"3\" MAXLENGTH=\"5\" class=\"NUMBER\" style=\"visibility:visible\" Value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\"  disabled  >\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"volume";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\"  disabled >\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\n\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" disabled name=\"volume";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\"  onBlur=\"CheckNum(this); setStockValue(this,\'";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\'); validateRate(INF_RATE";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" >\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" >\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"vol_uom";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="</label> <!--added for SKR-CRF-0035 End -->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"infuse_over_leg1\">";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"INFUSION_PERIOD_VALUE";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" id=\"INFUSION_PERIOD_VALUE";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" VALUE= \"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" SIZE=\"1\" MAXLENGTH=\"7\" CLASS=\"number\" onBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" style=\"visibility:visible\" tabIndex=\"-1\" ";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\');calculateRate(this,volume";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"visibility:visible\" id=\"colon";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\"><b>:</b></label>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"INFUSION_PERIOD_VALUE_MIN";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" id=\"INFUSION_PERIOD_VALUE_MIN";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" SIZE=\"1\" MAXLENGTH=\"2\" CLASS=\"number\" onBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"visibility:visible\" id=\"hr";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t<br><label align=\"left\"  width=\'15%\'class=\'label\' id=\"infusionOverStr";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\" style=\"visibility:visible\"></label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\t\t\t\t\t<td CLASS=\"label\" nowrap id=\"allow_alternate";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="&nbsp;\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' onclick =\"setAllowAlternate(this)\" name=\'allow_alternate_yn";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' id=\'allow_alternate_yn";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' value=\'N\' ";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="  > </td><!-- GHL-CRF-0549-->\n\t\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\n\t\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\'9\' class=\"label\" >\n\t\t\t\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRate(\'";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\',\'";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\');\" id=\'mfrLink";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\'>";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="</a><img src=\"../../eCommon/images/enabled.gif\"  id=\'MFR_Indicator";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\'> &nbsp;&nbsp;<a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\');\" id=\'mfrRemarksLink";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="</a><!-- Modified for TFS-13907 -->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mfr_remarks";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" id=\"mfr_remarks";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\"\t\tvalue=\"";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\t\t\t\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\'9\' class=\"label\" >\n\t\t\t\t\t\t\t\t\t\t\t<a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="</a>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mfr_remarks";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\t\t\t\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\teval(document.getElementById(\"infusionOverStr\"+";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 =")).innerHTML  = \"[\"+ \'";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\'+\" Hrs \"+ \'";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' + \" Mins]\";\n\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tsetInf_unit(";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 =");  \n\t\t\t\t\t</script>\t\n";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\" style=\"border-color:#004080;\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td>\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t\t\t\t<TD colspan=\"9\" class=\"label\"align=\"right\">";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\' disabled>\n";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</TABLE>\n\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\"8%\">\n\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\" id=\"ADR_img_";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' ></img>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" checked name=\"active";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\" value=\"Y\"  style=\"visibility:visible\" ";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =" >&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label style=\"color:red;font-weight:bold\">";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<TD width=\"20%\" class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"FLUID_NAME";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="  SIZE=\"40\" MAXLENGTH=\"40\"  onChange=\"searchIVFluid1(formIVPrescriptionAdditives,\'D\', FLUID_NAME";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 =",1)\"><!-- added for SKR-SCF-1391 --> <!-- Modified for MMS-DM-CRF-0177 -->\n";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="<!-- COMMENTED for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"fluid_search";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\" id=\"fluid_search";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\" value=\"?\"  onclick=\"searchIVFluid1(formIVPrescriptionAdditives,\'D\', FLUID_NAME";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 =",1)\" ><!-- removed onfocus for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\"  name=\"flude_img";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(FLUID_CODE";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 =".value);\">\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'>  <!-- newly added for  Bru-HIMS-CRF-347 [IN:037862]  -->\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"disp_locn1\">";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =" </label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\"  width=\'11%\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"disp_locn_desc";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\"><b></b></label>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"per_facility_id";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\" value=\'\' />\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\"disp_locn_code";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\" value=\'\' />\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"17%\" id=\'tdDuration";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t<label id=\"duration";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"DURATION";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 =");return validateDuration(this,INFUSION_PERIOD_VALUE";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\');\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" tabIndex=\"-1\">\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<label id=\'durn_unit";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\' class=\"label\" >\n\t\t\t\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t<br><label id=\"ForRepeat_leg";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="</label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju--></label>\n\t\t\t\t\t\t\t\t\t\t</label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\"  width=\"8%\">\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"start_time_leg";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="</label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\"  width=\"10%\">\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"START_DATE";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"   SIZE=\"13\" MAXLENGTH=\"16\" onBlur=\"chkDurationAD(DURATION";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =");\" style=\"visibility:visible\">\n\t\t\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\"Calendar";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 =".focus();return false;\" style=\"visibility:visible\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"7%\">\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"end_time_leg";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 =" </label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"8%\">\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"END_DATE";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\"  SIZE=\"13\" MAXLENGTH=\"16\" READONLY style=\"visibility:visible\">\t\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FLUID_CODE";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"INF_RATE_UOM";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="\">\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"stock_uom_code";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"stock_value";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_volume";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"sTimeFrame";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\" id=\"sTimeFrame";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 ="\">\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"INFUSION_PERIOD_UOM";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 ="\" VALUE=\'\' >\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"infusion_over_insert_value";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 ="\' >\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"mfr_yn";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 ="\" VALUE=\'\' >\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"volume_reference";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\"  >\n\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap>\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"inf_rate_leg";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 ="</label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start-->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\" SIZE=\"3\" MAXLENGTH=\"7\"  value=\'";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="\'  onBlur=\"CheckNum(this);calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 =");\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" style=\"visibility:visible\"  >&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="\'  onBlur=\"CheckNum(this);validateRate(this,volume";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<label id=\'uom_display";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 ="\' class=\"label\"><b>";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 ="/</b></label>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\" onChange=\"ChangeInfuseOverTime(this,";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 =");calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 =");\" style=\"visibility:visible\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 =");validateRate(INF_RATE";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\')\" style=\"visibility:visible\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end-->\n\t\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="</option>\n\t\t\t\t\t\t\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="</option>\n\t\t\t\t\t\t\t\t\t\t</select>\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\"display:none;\" id=\"tdOrderQty_leg";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 =" <!--added for SKR-CRF-0035 start-->\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" id=\"tdOrd_qty";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\" style=\"display:none;\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' class=\"NUMBER\" name=\'order_qty";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\' size=\"1\" maxlength=\"3\" onKeyPress=\"return allowValidNumber(this,event,2,0);\"  onchange=\"calcTotalVolume(\'";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\')\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label id=\"ord_qty_uom";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\"  style=\"display:none;\" id=\"tdVolumePerUnit";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\">\n\t\t\t\t\t\t\t\t\t\t<label id=\"volumePerUnit_leg";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"volumePerUnit";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\" size=\"3\" class=\"NUMBER\" readOnly>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label id=\"volPerUnitUom_leg";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"display:none\" id=\"Totalvolume_leg";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"volume_leg";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"volume";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\" onblur=\"setStockValue(this,\'";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\'); chkDurationAD(DURATION";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="); CalculateDateTime(END_DATE";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 =",START_DATE";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" >\n\t\t\t\t\t\t\t\t\t\t<label id=\"vol_uom";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\"  class=\"label\" style=\"visibility:hidden;font-size:9px;\"><b>&nbsp";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="</b></label><!--added for SKR-CRF-0035 End-->\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"infuse_over_leg";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="</label> &nbsp;\n\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" style=\"visibility:visible\" tabIndex=\"-1\"><label class=\"label\" style=\"visibility:visible\" id=\"colon";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" style=\"visibility:visible\" tabIndex=\"-1\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end -->\t\t\t\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"visibility:visible\" id=\"hr";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="</b>\n\t\t\t\t\t\t\t\t\t\t<br><label align=\"left\"  width=\'15%\'class=\'label\' id=\"infusionOverStr";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\" style=\"visibility:visible\"></label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'9\' class=\"label\" >\n\t\t\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRate(\'";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\' style=\"visibility:visible\">";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="</a><img src=\"../../eCommon/images/disabled.gif\"  id=\'MFR_Indicator";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\' style=\"visibility:";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\"> &nbsp;&nbsp;<a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks(\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\' style=\"visibility:visible\" >&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="</a>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mfr_remarks";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t<script language=\"javascript\">\n\t\t\t\t\t\t\t\teval(\"document.formIVPrescriptionAdditives.volume\"+";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 =").focus();\n\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );

    private final static java.lang.String  _wl_block309 ="\n\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\" style=\"border-color:#004080\">\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t<TD colspan=\"9\"></TD>\n\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\"8%\"><img  id=\"ADR_img_";
    private final static byte[]  _wl_block309Bytes = _getBytes( _wl_block309 );

    private final static java.lang.String  _wl_block310 ="\' style=\"visibility:hidden\" ></img>&nbsp;<input type=\"checkbox\" name=\"active";
    private final static byte[]  _wl_block310Bytes = _getBytes( _wl_block310 );

    private final static java.lang.String  _wl_block311 ="\" value=\"Y\" style=\"visibility:";
    private final static byte[]  _wl_block311Bytes = _getBytes( _wl_block311 );

    private final static java.lang.String  _wl_block312 ="\">&nbsp;<label style=\"color:red;font-weight:bold;visibility:";
    private final static byte[]  _wl_block312Bytes = _getBytes( _wl_block312 );

    private final static java.lang.String  _wl_block313 ="\" id=\"fluid_leg";
    private final static byte[]  _wl_block313Bytes = _getBytes( _wl_block313 );

    private final static java.lang.String  _wl_block314 ="</td>\n\n\t\t\t\t\t\t\t\t\t<TD class=\"fields\" width=\"20%\" ><INPUT TYPE=\"text\" name=\"FLUID_NAME";
    private final static byte[]  _wl_block314Bytes = _getBytes( _wl_block314 );

    private final static java.lang.String  _wl_block315 ="\" VALUE=\"\" SIZE=\"40\" MAXLENGTH=\"40\"  onblur=\"checkValidDrug(\'f\', this.value)\"  onChange=\"searchIVFluid1(formIVPrescriptionAdditives,\'D\', FLUID_NAME";
    private final static byte[]  _wl_block315Bytes = _getBytes( _wl_block315 );

    private final static java.lang.String  _wl_block316 =")\" style=\"visibility:";
    private final static byte[]  _wl_block316Bytes = _getBytes( _wl_block316 );

    private final static java.lang.String  _wl_block317 ="\"><!-- added for SKR-SCF-1391 -->\n";
    private final static byte[]  _wl_block317Bytes = _getBytes( _wl_block317 );

    private final static java.lang.String  _wl_block318 ="<!-- COMMENTED FOR SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"fluid_search";
    private final static byte[]  _wl_block318Bytes = _getBytes( _wl_block318 );

    private final static java.lang.String  _wl_block319 ="\"><!-- REMOVED onfocus for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\"  name=\"flude_img";
    private final static byte[]  _wl_block319Bytes = _getBytes( _wl_block319 );

    private final static java.lang.String  _wl_block320 =".value);\"></TD>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'>  <!-- newly added for  Bru-HIMS-CRF-347 [IN:037862]  -->\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:visible\" id=\"disp_locn1\">";
    private final static byte[]  _wl_block320Bytes = _getBytes( _wl_block320 );

    private final static java.lang.String  _wl_block321 ="</label>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"DURATION";
    private final static byte[]  _wl_block321Bytes = _getBytes( _wl_block321 );

    private final static java.lang.String  _wl_block322 ="\" VALUE=\"24\" SIZE=\"1\" MAXLENGTH=\"3\" CLASS=\"number\"  onBlur=\"chkDurationAD(DURATION";
    private final static byte[]  _wl_block322Bytes = _getBytes( _wl_block322 );

    private final static java.lang.String  _wl_block323 ="\');\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" tabIndex=\"-1\">\n\t\t\t\t\t\t\t\t\t\t<label id=\'durn_unit";
    private final static byte[]  _wl_block323Bytes = _getBytes( _wl_block323 );

    private final static java.lang.String  _wl_block324 ="</label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'8%\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"start_time_leg";
    private final static byte[]  _wl_block324Bytes = _getBytes( _wl_block324 );

    private final static java.lang.String  _wl_block325 ="</label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'10%\'>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"START_DATE";
    private final static byte[]  _wl_block325Bytes = _getBytes( _wl_block325 );

    private final static java.lang.String  _wl_block326 ="\" SIZE=\"13\" MAXLENGTH=\"16\" onBlur=\"chkDurationAD(DURATION";
    private final static byte[]  _wl_block326Bytes = _getBytes( _wl_block326 );

    private final static java.lang.String  _wl_block327 =");\" style=\"visibility:hidden\"><IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\"Calendar";
    private final static byte[]  _wl_block327Bytes = _getBytes( _wl_block327 );

    private final static java.lang.String  _wl_block328 =".focus();return false;\" style=\"visibility:hidden\"></td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'7%\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"end_time_leg";
    private final static byte[]  _wl_block328Bytes = _getBytes( _wl_block328 );

    private final static java.lang.String  _wl_block329 =" </label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'8%\'>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"END_DATE";
    private final static byte[]  _wl_block329Bytes = _getBytes( _wl_block329 );

    private final static java.lang.String  _wl_block330 ="\" SIZE=\"13\" MAXLENGTH=\"16\" READONLY style=\"visibility:hidden\">\t\t\n\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FLUID_CODE";
    private final static byte[]  _wl_block330Bytes = _getBytes( _wl_block330 );

    private final static java.lang.String  _wl_block331 ="\" VALUE=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"INF_RATE_UOM";
    private final static byte[]  _wl_block331Bytes = _getBytes( _wl_block331 );

    private final static java.lang.String  _wl_block332 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"stock_uom_code";
    private final static byte[]  _wl_block332Bytes = _getBytes( _wl_block332 );

    private final static java.lang.String  _wl_block333 ="\" VALUE=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"stock_value";
    private final static byte[]  _wl_block333Bytes = _getBytes( _wl_block333 );

    private final static java.lang.String  _wl_block334 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_volume";
    private final static byte[]  _wl_block334Bytes = _getBytes( _wl_block334 );

    private final static java.lang.String  _wl_block335 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"INFUSION_PERIOD_UOM";
    private final static byte[]  _wl_block335Bytes = _getBytes( _wl_block335 );

    private final static java.lang.String  _wl_block336 ="\"  >\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap >\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"inf_rate_leg";
    private final static byte[]  _wl_block336Bytes = _getBytes( _wl_block336 );

    private final static java.lang.String  _wl_block337 ="</label></td>\n\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block337Bytes = _getBytes( _wl_block337 );

    private final static java.lang.String  _wl_block338 ="\" VALUE=\"\" SIZE=\"3\" MAXLENGTH=\"7\"  onBlur=\"CheckNum(this);calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block338Bytes = _getBytes( _wl_block338 );

    private final static java.lang.String  _wl_block339 =");\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" style=\"visibility:hidden\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block339Bytes = _getBytes( _wl_block339 );

    private final static java.lang.String  _wl_block340 ="\" VALUE=\"\" SIZE=\"3\" MAXLENGTH=\"7\"  onBlur=\"CheckNum(this);validateRate(this,volume";
    private final static byte[]  _wl_block340Bytes = _getBytes( _wl_block340 );

    private final static java.lang.String  _wl_block341 ="\'); strtEndDateTime(";
    private final static byte[]  _wl_block341Bytes = _getBytes( _wl_block341 );

    private final static java.lang.String  _wl_block342 ="\' class=\"label\"></label>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block342Bytes = _getBytes( _wl_block342 );

    private final static java.lang.String  _wl_block343 =");\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block343Bytes = _getBytes( _wl_block343 );

    private final static java.lang.String  _wl_block344 ="\')\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block344Bytes = _getBytes( _wl_block344 );

    private final static java.lang.String  _wl_block345 ="\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094  end-->\n\t\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block345Bytes = _getBytes( _wl_block345 );

    private final static java.lang.String  _wl_block346 ="</option>\n\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\"display:none;\" id=\"tdOrderQty_leg";
    private final static byte[]  _wl_block346Bytes = _getBytes( _wl_block346 );

    private final static java.lang.String  _wl_block347 =" <!--added for SKR-CRF-0035 start-->\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" class=\"NUMBER\" id=\"tdOrd_qty";
    private final static byte[]  _wl_block347Bytes = _getBytes( _wl_block347 );

    private final static java.lang.String  _wl_block348 ="\" style=\"display:none;\">\n\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'order_qty";
    private final static byte[]  _wl_block348Bytes = _getBytes( _wl_block348 );

    private final static java.lang.String  _wl_block349 ="\' size=\"1\" maxlength=\"3\" style=\"display:none;\" onKeyPress=\"return allowValidNumber(this,event,2,0);\" onchange=\"calcTotalVolume(\'";
    private final static byte[]  _wl_block349Bytes = _getBytes( _wl_block349 );

    private final static java.lang.String  _wl_block350 ="\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\"display:none;\" id=\'tdVolumePerUnit";
    private final static byte[]  _wl_block350Bytes = _getBytes( _wl_block350 );

    private final static java.lang.String  _wl_block351 ="\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"display:none;\" id=\"volumePerUnit_leg";
    private final static byte[]  _wl_block351Bytes = _getBytes( _wl_block351 );

    private final static java.lang.String  _wl_block352 ="\" size=\"3\" class=\"NUMBER\" style=\"display:none;\" readOnly>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label id=\"volPerUnitUom_leg";
    private final static byte[]  _wl_block352Bytes = _getBytes( _wl_block352 );

    private final static java.lang.String  _wl_block353 ="\" class=\"label\" style=\"display:none;font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"display:none\" id=\"Totalvolume_leg";
    private final static byte[]  _wl_block353Bytes = _getBytes( _wl_block353 );

    private final static java.lang.String  _wl_block354 ="\" size=\"3\" MAXLENGTH=\"5\" class=\"NUMBER\" style=\"visibility:hidden\" onblur=\"setStockValue(this,\'";
    private final static byte[]  _wl_block354Bytes = _getBytes( _wl_block354 );

    private final static java.lang.String  _wl_block355 =");\" onKeyPress=\"return allowValidNumber(this,event,6,2);\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t<label id=\"vol_uom";
    private final static byte[]  _wl_block355Bytes = _getBytes( _wl_block355 );

    private final static java.lang.String  _wl_block356 ="\"  class=\"label\" style=\"visibility:hidden;font-size:9px;\"></label><!--added for SKR-CRF-0035 End-->\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"infuse_over_leg";
    private final static byte[]  _wl_block356Bytes = _getBytes( _wl_block356 );

    private final static java.lang.String  _wl_block357 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094  start-->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block357Bytes = _getBytes( _wl_block357 );

    private final static java.lang.String  _wl_block358 ="\" VALUE=\"\" SIZE=\"1\" MAXLENGTH=\"7\" CLASS=\"number\" onBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block358Bytes = _getBytes( _wl_block358 );

    private final static java.lang.String  _wl_block359 =");  strtEndDateTime(";
    private final static byte[]  _wl_block359Bytes = _getBytes( _wl_block359 );

    private final static java.lang.String  _wl_block360 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" style=\"visibility:hidden\" tabIndex=\"-1\"><label class=\"label\" style=\"visibility:hidden\" id=\"colon";
    private final static byte[]  _wl_block360Bytes = _getBytes( _wl_block360 );

    private final static java.lang.String  _wl_block361 ="\" VALUE=\"\" SIZE=\"1\" MAXLENGTH=\"2\" CLASS=\"number\" onBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block361Bytes = _getBytes( _wl_block361 );

    private final static java.lang.String  _wl_block362 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" style=\"visibility:hidden\" tabIndex=\"-1\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block362Bytes = _getBytes( _wl_block362 );

    private final static java.lang.String  _wl_block363 ="\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end-->\n\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"visibility:hidden\" id=\"hr";
    private final static byte[]  _wl_block363Bytes = _getBytes( _wl_block363 );

    private final static java.lang.String  _wl_block364 ="\" style=\"visibility:hidden\"></label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\'9\' class=\"label\" >\n\t\t\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRate(\'";
    private final static byte[]  _wl_block364Bytes = _getBytes( _wl_block364 );

    private final static java.lang.String  _wl_block365 ="\" >&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block365Bytes = _getBytes( _wl_block365 );

    private final static java.lang.String  _wl_block366 ="</a><!-- Modified for TFS-13907 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mfr_remarks";
    private final static byte[]  _wl_block366Bytes = _getBytes( _wl_block366 );

    private final static java.lang.String  _wl_block367 ="\">\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block367Bytes = _getBytes( _wl_block367 );

    private final static java.lang.String  _wl_block368 ="\n\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\" style=\"border-color:#004080;\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t\t<TD colspan=\"9\" align=\'right\' class=\"label\" > ";
    private final static byte[]  _wl_block368Bytes = _getBytes( _wl_block368 );

    private final static java.lang.String  _wl_block369 ="&nbsp;\n";
    private final static byte[]  _wl_block369Bytes = _getBytes( _wl_block369 );

    private final static java.lang.String  _wl_block370 ="\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block370Bytes = _getBytes( _wl_block370 );

    private final static java.lang.String  _wl_block371 =" onclick=\'assignValue(this);\'>\n";
    private final static byte[]  _wl_block371Bytes = _getBytes( _wl_block371 );

    private final static java.lang.String  _wl_block372 ="\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block372Bytes = _getBytes( _wl_block372 );

    private final static java.lang.String  _wl_block373 ="\n\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\" style=\"border-color:#004080\">\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"fields\" width=\"8%\">\n\t\t\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\" id=\"ADR_img_";
    private final static byte[]  _wl_block373Bytes = _getBytes( _wl_block373 );

    private final static java.lang.String  _wl_block374 ="\' ></img>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"active";
    private final static byte[]  _wl_block374Bytes = _getBytes( _wl_block374 );

    private final static java.lang.String  _wl_block375 ="\" value=\"Y\" checked style=\"visibility:hidden\"> &nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<label ";
    private final static byte[]  _wl_block375Bytes = _getBytes( _wl_block375 );

    private final static java.lang.String  _wl_block376 ="  style=\"color:red;font-weight:bold;";
    private final static byte[]  _wl_block376Bytes = _getBytes( _wl_block376 );

    private final static java.lang.String  _wl_block377 ="\"> ";
    private final static byte[]  _wl_block377Bytes = _getBytes( _wl_block377 );

    private final static java.lang.String  _wl_block378 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t\t\t\t\t<TD class=\"fields\" width=\"20%\" ><INPUT TYPE=\"text\" name=\"FLUID_NAME";
    private final static byte[]  _wl_block378Bytes = _getBytes( _wl_block378 );

    private final static java.lang.String  _wl_block379 ="\" VALUE=\"\" SIZE=\"35\" MAXLENGTH=\"40\"  onblur=\"checkValidDrug(\'f\', this.value)\"  onChange=\"searchIVFluid1(formIVPrescriptionAdditives,\'D\', FLUID_NAME";
    private final static byte[]  _wl_block379Bytes = _getBytes( _wl_block379 );

    private final static java.lang.String  _wl_block380 =")\" style=";
    private final static byte[]  _wl_block380Bytes = _getBytes( _wl_block380 );

    private final static java.lang.String  _wl_block381 ="><!-- added for SKR-SCF-1391 -->\n";
    private final static byte[]  _wl_block381Bytes = _getBytes( _wl_block381 );

    private final static java.lang.String  _wl_block382 ="<!-- COMMENTED FOR SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"button\" class=\"button\" name=\"fluid_search";
    private final static byte[]  _wl_block382Bytes = _getBytes( _wl_block382 );

    private final static java.lang.String  _wl_block383 ="><!-- REMOVED onFocus for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t\t\t\t<img style=\"visibility:hidden\"  name=\"flude_img";
    private final static byte[]  _wl_block383Bytes = _getBytes( _wl_block383 );

    private final static java.lang.String  _wl_block384 =".value);\"></img>\n\t\t\t\t\t\t\t\t\t\t\t</TD>\t\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'> <!-- Added for Bru-HIMS-CRF-347 [IN:037862] -->\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"disp_locn";
    private final static byte[]  _wl_block384Bytes = _getBytes( _wl_block384 );

    private final static java.lang.String  _wl_block385 ="\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'11%\'>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"disp_locn_desc";
    private final static byte[]  _wl_block385Bytes = _getBytes( _wl_block385 );

    private final static java.lang.String  _wl_block386 ="\" class=\"label\"></label>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_code";
    private final static byte[]  _wl_block386Bytes = _getBytes( _wl_block386 );

    private final static java.lang.String  _wl_block387 ="\" value=\"\">\t\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_locn_type";
    private final static byte[]  _wl_block387Bytes = _getBytes( _wl_block387 );

    private final static java.lang.String  _wl_block388 ="\" value=\"\">\t\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"per_facility_id";
    private final static byte[]  _wl_block388Bytes = _getBytes( _wl_block388 );

    private final static java.lang.String  _wl_block389 ="\" value=\"\">\t\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\"17%\" id=\'tdDuration";
    private final static byte[]  _wl_block389Bytes = _getBytes( _wl_block389 );

    private final static java.lang.String  _wl_block390 ="\' style=\'visibility:hidden;\' >\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\"duration";
    private final static byte[]  _wl_block390Bytes = _getBytes( _wl_block390 );

    private final static java.lang.String  _wl_block391 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"DURATION";
    private final static byte[]  _wl_block391Bytes = _getBytes( _wl_block391 );

    private final static java.lang.String  _wl_block392 ="\" VALUE=\"24\" SIZE=\"1\" MAXLENGTH=\"3\" CLASS=\"number\"  onBlur=\"CheckNum(this);chkDurationAD(DURATION";
    private final static byte[]  _wl_block392Bytes = _getBytes( _wl_block392 );

    private final static java.lang.String  _wl_block393 ="\');\" onKeyPress=\"return allowValidNumber(this,event,3,0); \" tabIndex=\"-1\">\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\'durn_unit";
    private final static byte[]  _wl_block393Bytes = _getBytes( _wl_block393 );

    private final static java.lang.String  _wl_block394 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t\t<br><label id=\"ForRepeat_leg";
    private final static byte[]  _wl_block394Bytes = _getBytes( _wl_block394 );

    private final static java.lang.String  _wl_block395 ="</label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'7%\'>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"start_time_leg";
    private final static byte[]  _wl_block395Bytes = _getBytes( _wl_block395 );

    private final static java.lang.String  _wl_block396 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'10%\'>\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"START_DATE";
    private final static byte[]  _wl_block396Bytes = _getBytes( _wl_block396 );

    private final static java.lang.String  _wl_block397 =");\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t<IMG SRC=\"../../eCommon/images/CommonCalendar.gif\" id=\"Calendar";
    private final static byte[]  _wl_block397Bytes = _getBytes( _wl_block397 );

    private final static java.lang.String  _wl_block398 =".focus();return false;\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  width=\'8%\' >\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"end_time_leg";
    private final static byte[]  _wl_block398Bytes = _getBytes( _wl_block398 );

    private final static java.lang.String  _wl_block399 =" </label>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" width=\'8%\'>\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"END_DATE";
    private final static byte[]  _wl_block399Bytes = _getBytes( _wl_block399 );

    private final static java.lang.String  _wl_block400 ="\" SIZE=\"13\" MAXLENGTH=\"16\" READONLY style=\"visibility:hidden\">\t\t\n\t\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FLUID_CODE";
    private final static byte[]  _wl_block400Bytes = _getBytes( _wl_block400 );

    private final static java.lang.String  _wl_block401 ="\" VALUE=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"INF_RATE_UOM";
    private final static byte[]  _wl_block401Bytes = _getBytes( _wl_block401 );

    private final static java.lang.String  _wl_block402 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"stock_uom_code";
    private final static byte[]  _wl_block402Bytes = _getBytes( _wl_block402 );

    private final static java.lang.String  _wl_block403 ="\" VALUE=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"stock_value";
    private final static byte[]  _wl_block403Bytes = _getBytes( _wl_block403 );

    private final static java.lang.String  _wl_block404 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_volume";
    private final static byte[]  _wl_block404Bytes = _getBytes( _wl_block404 );

    private final static java.lang.String  _wl_block405 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"INFUSION_PERIOD_UOM";
    private final static byte[]  _wl_block405Bytes = _getBytes( _wl_block405 );

    private final static java.lang.String  _wl_block406 ="\" VALUE=\'\' >\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"infusion_over_insert_value";
    private final static byte[]  _wl_block406Bytes = _getBytes( _wl_block406 );

    private final static java.lang.String  _wl_block407 ="\' >\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"mfr_yn";
    private final static byte[]  _wl_block407Bytes = _getBytes( _wl_block407 );

    private final static java.lang.String  _wl_block408 ="\" VALUE=\'\' >\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"volume_reference";
    private final static byte[]  _wl_block408Bytes = _getBytes( _wl_block408 );

    private final static java.lang.String  _wl_block409 ="\"  >\n\t\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block409Bytes = _getBytes( _wl_block409 );

    private final static java.lang.String  _wl_block410 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap style=\"display:none\" id=\"TDstrenght";
    private final static byte[]  _wl_block410Bytes = _getBytes( _wl_block410 );

    private final static java.lang.String  _wl_block411 ="\"  >\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"";
    private final static byte[]  _wl_block411Bytes = _getBytes( _wl_block411 );

    private final static java.lang.String  _wl_block412 ="</label>\n\t\t\t\t\t\t\t\t\t        <label  id=\"strength_label";
    private final static byte[]  _wl_block412Bytes = _getBytes( _wl_block412 );

    private final static java.lang.String  _wl_block413 ="\" class=\"label\" style=\"font-size:12px;";
    private final static byte[]  _wl_block413Bytes = _getBytes( _wl_block413 );

    private final static java.lang.String  _wl_block414 ="\"  ></label></td>\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block414Bytes = _getBytes( _wl_block414 );

    private final static java.lang.String  _wl_block415 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" nowrap >\n\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"inf_rate_leg";
    private final static byte[]  _wl_block415Bytes = _getBytes( _wl_block415 );

    private final static java.lang.String  _wl_block416 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start -->\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block416Bytes = _getBytes( _wl_block416 );

    private final static java.lang.String  _wl_block417 ="<INPUT TYPE=\"text\" CLASS=\"number\" name=\"INF_RATE";
    private final static byte[]  _wl_block417Bytes = _getBytes( _wl_block417 );

    private final static java.lang.String  _wl_block418 ="\" VALUE=\"\" SIZE=\"3\" MAXLENGTH=\"7\" \tonBlur=\"CheckNum(this);calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block418Bytes = _getBytes( _wl_block418 );

    private final static java.lang.String  _wl_block419 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" CLASS=\"number\" name=\"INF_RATE";
    private final static byte[]  _wl_block419Bytes = _getBytes( _wl_block419 );

    private final static java.lang.String  _wl_block420 ="\" VALUE=\"\" SIZE=\"3\" MAXLENGTH=\"7\" \tonBlur=\"CheckNum(this);validateRate(this,volume";
    private final static byte[]  _wl_block420Bytes = _getBytes( _wl_block420 );

    private final static java.lang.String  _wl_block421 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\'uom_display";
    private final static byte[]  _wl_block421Bytes = _getBytes( _wl_block421 );

    private final static java.lang.String  _wl_block422 ="\' class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block422Bytes = _getBytes( _wl_block422 );

    private final static java.lang.String  _wl_block423 ="<select name=\"InfusionRateUnit";
    private final static byte[]  _wl_block423Bytes = _getBytes( _wl_block423 );

    private final static java.lang.String  _wl_block424 ="\" onChange=\"calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block424Bytes = _getBytes( _wl_block424 );

    private final static java.lang.String  _wl_block425 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<select name=\"InfusionRateUnit";
    private final static byte[]  _wl_block425Bytes = _getBytes( _wl_block425 );

    private final static java.lang.String  _wl_block426 =")\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block426Bytes = _getBytes( _wl_block426 );

    private final static java.lang.String  _wl_block427 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end-->\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block427Bytes = _getBytes( _wl_block427 );

    private final static java.lang.String  _wl_block428 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block428Bytes = _getBytes( _wl_block428 );

    private final static java.lang.String  _wl_block429 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\"display:none;\" id=\"tdOrderQty_leg";
    private final static byte[]  _wl_block429Bytes = _getBytes( _wl_block429 );

    private final static java.lang.String  _wl_block430 ="<!--added for SKR-CRF-0035 start-->\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" id=\"tdOrd_qty";
    private final static byte[]  _wl_block430Bytes = _getBytes( _wl_block430 );

    private final static java.lang.String  _wl_block431 ="\" style=\"display:none;\">\n\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094  start-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block431Bytes = _getBytes( _wl_block431 );

    private final static java.lang.String  _wl_block432 ="<input type=\'text\' disabled class=\"NUMBER\" name=\'order_qty";
    private final static byte[]  _wl_block432Bytes = _getBytes( _wl_block432 );

    private final static java.lang.String  _wl_block433 ="\' size=\"1\" maxlength=\"3\" >&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block433Bytes = _getBytes( _wl_block433 );

    private final static java.lang.String  _wl_block434 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' disabled class=\"NUMBER\" name=\'order_qty";
    private final static byte[]  _wl_block434Bytes = _getBytes( _wl_block434 );

    private final static java.lang.String  _wl_block435 ="\' size=\"1\" maxlength=\"3\" onKeyPress=\"return allowValidNumber(this,event,2,0);\" onchange=\"calcTotalVolume(\'";
    private final static byte[]  _wl_block435Bytes = _getBytes( _wl_block435 );

    private final static java.lang.String  _wl_block436 ="\')\" >&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block436Bytes = _getBytes( _wl_block436 );

    private final static java.lang.String  _wl_block437 ="\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end -->\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\"ord_qty_uom";
    private final static byte[]  _wl_block437Bytes = _getBytes( _wl_block437 );

    private final static java.lang.String  _wl_block438 ="\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\"display:none;\" id=\"tdVolumePerUnit";
    private final static byte[]  _wl_block438Bytes = _getBytes( _wl_block438 );

    private final static java.lang.String  _wl_block439 ="\">\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\"volumePerUnit_leg";
    private final static byte[]  _wl_block439Bytes = _getBytes( _wl_block439 );

    private final static java.lang.String  _wl_block440 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" disabled name=\"volumePerUnit";
    private final static byte[]  _wl_block440Bytes = _getBytes( _wl_block440 );

    private final static java.lang.String  _wl_block441 ="\" size=\"3\" class=\"NUMBER\"  readOnly>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\"volPerUnitUom_leg";
    private final static byte[]  _wl_block441Bytes = _getBytes( _wl_block441 );

    private final static java.lang.String  _wl_block442 ="\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"display:none;\" id=\"Totalvolume_leg";
    private final static byte[]  _wl_block442Bytes = _getBytes( _wl_block442 );

    private final static java.lang.String  _wl_block443 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"volume_leg";
    private final static byte[]  _wl_block443Bytes = _getBytes( _wl_block443 );

    private final static java.lang.String  _wl_block444 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start -->\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block444Bytes = _getBytes( _wl_block444 );

    private final static java.lang.String  _wl_block445 ="<input type=\"text\"  disabled name=\"volume";
    private final static byte[]  _wl_block445Bytes = _getBytes( _wl_block445 );

    private final static java.lang.String  _wl_block446 ="\" size=\"3\" MAXLENGTH=\"5\" class=\"NUMBER\" style=\"visibility:hidden\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block446Bytes = _getBytes( _wl_block446 );

    private final static java.lang.String  _wl_block447 ="\" size=\"3\" MAXLENGTH=\"5\" class=\"NUMBER\" style=\"visibility:hidden\" onblur=\"setStockValue(this,";
    private final static byte[]  _wl_block447Bytes = _getBytes( _wl_block447 );

    private final static java.lang.String  _wl_block448 ="); chkDurationAD(DURATION";
    private final static byte[]  _wl_block448Bytes = _getBytes( _wl_block448 );

    private final static java.lang.String  _wl_block449 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" >&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block449Bytes = _getBytes( _wl_block449 );

    private final static java.lang.String  _wl_block450 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094  end -->\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\"vol_uom";
    private final static byte[]  _wl_block450Bytes = _getBytes( _wl_block450 );

    private final static java.lang.String  _wl_block451 ="\"  class=\"label\" style=\"visibility:hidden;font-size:9px;\"></label><!--added for SKR-CRF-0035 End-->\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<TD class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"infuse_over_leg";
    private final static byte[]  _wl_block451Bytes = _getBytes( _wl_block451 );

    private final static java.lang.String  _wl_block452 ="</label>\n\t\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start-->\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block452Bytes = _getBytes( _wl_block452 );

    private final static java.lang.String  _wl_block453 ="<INPUT TYPE=\"text\" name=\"INFUSION_PERIOD_VALUE";
    private final static byte[]  _wl_block453Bytes = _getBytes( _wl_block453 );

    private final static java.lang.String  _wl_block454 ="\" VALUE=\"\" SIZE=\"1\" MAXLENGTH=\"3\" CLASS=\"number\"\tonBlur=\"CheckNum(this);calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block454Bytes = _getBytes( _wl_block454 );

    private final static java.lang.String  _wl_block455 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"INFUSION_PERIOD_VALUE";
    private final static byte[]  _wl_block455Bytes = _getBytes( _wl_block455 );

    private final static java.lang.String  _wl_block456 ="\" VALUE=\"\" SIZE=\"1\" MAXLENGTH=\"3\" CLASS=\"number\"\tonBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block456Bytes = _getBytes( _wl_block456 );

    private final static java.lang.String  _wl_block457 =");calculateRate(this,volume";
    private final static byte[]  _wl_block457Bytes = _getBytes( _wl_block457 );

    private final static java.lang.String  _wl_block458 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block458Bytes = _getBytes( _wl_block458 );

    private final static java.lang.String  _wl_block459 ="<INPUT TYPE=\"text\" name=\"INFUSION_PERIOD_VALUE_MIN";
    private final static byte[]  _wl_block459Bytes = _getBytes( _wl_block459 );

    private final static java.lang.String  _wl_block460 ="\" VALUE=\"\" SIZE=\"1\" MAXLENGTH=\"2\" CLASS=\"number\"\tonBlur=\"CheckNum(this);calVolumeInfuseRate(this,volumePerUnit";
    private final static byte[]  _wl_block460Bytes = _getBytes( _wl_block460 );

    private final static java.lang.String  _wl_block461 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"INFUSION_PERIOD_VALUE_MIN";
    private final static byte[]  _wl_block461Bytes = _getBytes( _wl_block461 );

    private final static java.lang.String  _wl_block462 ="\" VALUE=\"\" SIZE=\"1\" MAXLENGTH=\"2\" CLASS=\"number\"\tonBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block462Bytes = _getBytes( _wl_block462 );

    private final static java.lang.String  _wl_block463 ="\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end -->\n\t\t\t\t\t\t\t\t\t\t\t\t<label  class=\"label\" style=\"visibility:hidden;font-size:9px;\" id=\"hr";
    private final static byte[]  _wl_block463Bytes = _getBytes( _wl_block463 );

    private final static java.lang.String  _wl_block464 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t\t<br><label style=\'text-align:right;\'  width=\'15%\'class=\'label\' id=\"infusionOverStr";
    private final static byte[]  _wl_block464Bytes = _getBytes( _wl_block464 );

    private final static java.lang.String  _wl_block465 ="\" style=\"visibility:hidden\"></label>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t";
    private final static byte[]  _wl_block465Bytes = _getBytes( _wl_block465 );

    private final static java.lang.String  _wl_block466 ="\" style=\"visibility:hidden;\">";
    private final static byte[]  _wl_block466Bytes = _getBytes( _wl_block466 );

    private final static java.lang.String  _wl_block467 ="&nbsp;\n\t\t\t\t\t\t\t\t<input type=\'checkbox\' name=\'allow_alternate_yn";
    private final static byte[]  _wl_block467Bytes = _getBytes( _wl_block467 );

    private final static java.lang.String  _wl_block468 ="\' onclick =\"setAllowAlternate(this);\"value=\'N\' ";
    private final static byte[]  _wl_block468Bytes = _getBytes( _wl_block468 );

    private final static java.lang.String  _wl_block469 ="\n\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" colspan=\'9\'>\n\t\t\t\t\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRate(\'";
    private final static byte[]  _wl_block469Bytes = _getBytes( _wl_block469 );

    private final static java.lang.String  _wl_block470 ="\">&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block470Bytes = _getBytes( _wl_block470 );

    private final static java.lang.String  _wl_block471 ="</a>\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"mfr_remarks";
    private final static byte[]  _wl_block471Bytes = _getBytes( _wl_block471 );

    private final static java.lang.String  _wl_block472 ="\"\tvalue=\"";
    private final static byte[]  _wl_block472Bytes = _getBytes( _wl_block472 );

    private final static java.lang.String  _wl_block473 ="\">\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block473Bytes = _getBytes( _wl_block473 );

    private final static java.lang.String  _wl_block474 ="\n\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"1\" style=\"border-color:#004080\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t<TABLE CELLPADDING=\"0\" CELLSPACING=\"0\" WIDTH=\"100%\" ALIGN=\"center\" BORDER=\"0\">\n\t\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t\t\t<TD colspan=\"9\"></TD>\n\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t\t\t\t<td class=\"fields\" width=\"8%\"><img style=\"visibility:hidden\" id=\"ADR_img_";
    private final static byte[]  _wl_block474Bytes = _getBytes( _wl_block474 );

    private final static java.lang.String  _wl_block475 ="\' ></img>&nbsp;<input type=\"checkbox\" name=\"active";
    private final static byte[]  _wl_block475Bytes = _getBytes( _wl_block475 );

    private final static java.lang.String  _wl_block476 ="\" value=\"Y\" checked style=\"visibility:hidden\">&nbsp;<label style=\"color:red;font-weight:bold;visibility:";
    private final static byte[]  _wl_block476Bytes = _getBytes( _wl_block476 );

    private final static java.lang.String  _wl_block477 ="\" >";
    private final static byte[]  _wl_block477Bytes = _getBytes( _wl_block477 );

    private final static java.lang.String  _wl_block478 ="</td>\n\t\t\t\t\t\t\t\t\t\t<TD width=\"20%\" class=\"fields\">\n";
    private final static byte[]  _wl_block478Bytes = _getBytes( _wl_block478 );

    private final static java.lang.String  _wl_block479 ="<!-- COMMENTED for SKR-SCF-1317 -->\n\t\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"text\" name=\"FLUID_NAME";
    private final static byte[]  _wl_block479Bytes = _getBytes( _wl_block479 );

    private final static java.lang.String  _wl_block480 ="\"><input type=\"button\" class=\"button\" name=\"fluid_search";
    private final static byte[]  _wl_block480Bytes = _getBytes( _wl_block480 );

    private final static java.lang.String  _wl_block481 ="\"><!-- REMOVED ONFocus for SKR-SCF-1317 --><!-- added for SKR-SCF-1391 -->\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'9%\'> <!-- Added for Bru-HIMS-CRF-347 [IN:037862] -->\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"disp_locn";
    private final static byte[]  _wl_block481Bytes = _getBytes( _wl_block481 );

    private final static java.lang.String  _wl_block482 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'11%\'>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"disp_locn_desc";
    private final static byte[]  _wl_block482Bytes = _getBytes( _wl_block482 );

    private final static java.lang.String  _wl_block483 ="\" value=\"\">\t\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\"  width=\"17%\" id=\'tdDuration";
    private final static byte[]  _wl_block483Bytes = _getBytes( _wl_block483 );

    private final static java.lang.String  _wl_block484 ="\' style=\'visibility:hidden;\'>\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"duration";
    private final static byte[]  _wl_block484Bytes = _getBytes( _wl_block484 );

    private final static java.lang.String  _wl_block485 ="</label>&nbsp;<INPUT TYPE=\"text\" name=\"DURATION";
    private final static byte[]  _wl_block485Bytes = _getBytes( _wl_block485 );

    private final static java.lang.String  _wl_block486 ="\" SIZE=\"1\" MAXLENGTH=\"3\" CLASS=\"number\"  value=\"\" onBlur=\"chkDurationAD(DURATION";
    private final static byte[]  _wl_block486Bytes = _getBytes( _wl_block486 );

    private final static java.lang.String  _wl_block487 ="\');\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" tabIndex=\"-1\"><label id=\'durn_unit";
    private final static byte[]  _wl_block487Bytes = _getBytes( _wl_block487 );

    private final static java.lang.String  _wl_block488 ="</b></label>\n\t\t\t\t\t\t\t\t\t\t\t<br><label id=\"ForRepeat_leg";
    private final static byte[]  _wl_block488Bytes = _getBytes( _wl_block488 );

    private final static java.lang.String  _wl_block489 ="</label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td ><label style=\"visibility:hidden\" id=\"start_time_leg";
    private final static byte[]  _wl_block489Bytes = _getBytes( _wl_block489 );

    private final static java.lang.String  _wl_block490 ="</label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'10%\'><INPUT TYPE=\"text\" name=\"START_DATE";
    private final static byte[]  _wl_block490Bytes = _getBytes( _wl_block490 );

    private final static java.lang.String  _wl_block491 ="\" VALUE=\"\" SIZE=\"13\" MAXLENGTH=\"16\" onBlur=\"chkDurationAD(DURATION";
    private final static byte[]  _wl_block491Bytes = _getBytes( _wl_block491 );

    private final static java.lang.String  _wl_block492 =".focus();return false;\" style=\"visibility:hidden\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'7%\'><label style=\"visibility:hidden\" id=\"end_time_leg";
    private final static byte[]  _wl_block492Bytes = _getBytes( _wl_block492 );

    private final static java.lang.String  _wl_block493 =" </label></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'8%\'><INPUT TYPE=\"text\" name=\"END_DATE";
    private final static byte[]  _wl_block493Bytes = _getBytes( _wl_block493 );

    private final static java.lang.String  _wl_block494 ="\" VALUE=\"\" SIZE=\"13\" MAXLENGTH=\"16\" READONLY style=\"visibility:hidden\">\t\t\n\t\t\t\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"FLUID_CODE";
    private final static byte[]  _wl_block494Bytes = _getBytes( _wl_block494 );

    private final static java.lang.String  _wl_block495 ="\" VALUE=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"INF_RATE_UOM";
    private final static byte[]  _wl_block495Bytes = _getBytes( _wl_block495 );

    private final static java.lang.String  _wl_block496 ="\" VALUE=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"stock_value";
    private final static byte[]  _wl_block496Bytes = _getBytes( _wl_block496 );

    private final static java.lang.String  _wl_block497 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"base_volume";
    private final static byte[]  _wl_block497Bytes = _getBytes( _wl_block497 );

    private final static java.lang.String  _wl_block498 ="\" value=\"\">\n\t\t\t\t\t\t\t\t\t\t<INPUT TYPE=\"hidden\" name=\"INFUSION_PERIOD_UOM";
    private final static byte[]  _wl_block498Bytes = _getBytes( _wl_block498 );

    private final static java.lang.String  _wl_block499 ="\"  >\n\t\t\t\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block499Bytes = _getBytes( _wl_block499 );

    private final static java.lang.String  _wl_block500 ="</label>\n\t\t\t\t\t\t\t\t\t    <label id=\"strength_label";
    private final static byte[]  _wl_block500Bytes = _getBytes( _wl_block500 );

    private final static java.lang.String  _wl_block501 ="></label></td>\n\t\t\t\t\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block501Bytes = _getBytes( _wl_block501 );

    private final static java.lang.String  _wl_block502 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" ><label style=\"visibility:hidden\" id=\"infuse_over_leg";
    private final static byte[]  _wl_block502Bytes = _getBytes( _wl_block502 );

    private final static java.lang.String  _wl_block503 ="</label></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"data\" width=\"26%\">\n\t\t\t\t\t\t\t\t\t\t\t<label align=\"left\"  width=\'15%\' class=\'label\' id=\"infusionOverStr";
    private final static byte[]  _wl_block503Bytes = _getBytes( _wl_block503 );

    private final static java.lang.String  _wl_block504 ="\" style=\"visibility:hidden\"></label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<TD class=\"fields\">\n\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block504Bytes = _getBytes( _wl_block504 );

    private final static java.lang.String  _wl_block505 ="\" VALUE= \"\" SIZE=\"1\" MAXLENGTH=\"7\" CLASS=\"number\" onBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block505Bytes = _getBytes( _wl_block505 );

    private final static java.lang.String  _wl_block506 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<label class=\"label\" style=\"visibility:hidden\" id=\"colon";
    private final static byte[]  _wl_block506Bytes = _getBytes( _wl_block506 );

    private final static java.lang.String  _wl_block507 ="\"><B>:</B></label>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block507Bytes = _getBytes( _wl_block507 );

    private final static java.lang.String  _wl_block508 ="\" VALUE= \"\" SIZE=\"1\" MAXLENGTH=\"2\" CLASS=\"number\" onBlur=\"CheckNum(this);checkHr(this,DURATION";
    private final static byte[]  _wl_block508Bytes = _getBytes( _wl_block508 );

    private final static java.lang.String  _wl_block509 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" style=\"visibility:hidden\" tabIndex=\"-1\"><label class=\"label\" style=\"visibility:hidden\" id=\"hr";
    private final static byte[]  _wl_block509Bytes = _getBytes( _wl_block509 );

    private final static java.lang.String  _wl_block510 ="</b>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block510Bytes = _getBytes( _wl_block510 );

    private final static java.lang.String  _wl_block511 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end -->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\"display:none;\" id=\"tdOrderQty_leg";
    private final static byte[]  _wl_block511Bytes = _getBytes( _wl_block511 );

    private final static java.lang.String  _wl_block512 ="\"> <!--added for SKR-CRF-0035 start-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block512Bytes = _getBytes( _wl_block512 );

    private final static java.lang.String  _wl_block513 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" id=\"tdOrd_qty";
    private final static byte[]  _wl_block513Bytes = _getBytes( _wl_block513 );

    private final static java.lang.String  _wl_block514 ="\" style=\"display:none;\">\n\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' CLASS=\"number\" name=\'order_qty";
    private final static byte[]  _wl_block514Bytes = _getBytes( _wl_block514 );

    private final static java.lang.String  _wl_block515 ="\')\">&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"ord_qty_uom";
    private final static byte[]  _wl_block515Bytes = _getBytes( _wl_block515 );

    private final static java.lang.String  _wl_block516 ="\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" style=\"display:none;\" id=\"tdVolumePerUnit";
    private final static byte[]  _wl_block516Bytes = _getBytes( _wl_block516 );

    private final static java.lang.String  _wl_block517 ="\" size=\"3\" class=\"NUMBER\" readOnly>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"volPerUnitUom_leg";
    private final static byte[]  _wl_block517Bytes = _getBytes( _wl_block517 );

    private final static java.lang.String  _wl_block518 ="\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"display:none\" id=\"Totalvolume_leg";
    private final static byte[]  _wl_block518Bytes = _getBytes( _wl_block518 );

    private final static java.lang.String  _wl_block519 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"volume_leg";
    private final static byte[]  _wl_block519Bytes = _getBytes( _wl_block519 );

    private final static java.lang.String  _wl_block520 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" name=\"volume";
    private final static byte[]  _wl_block520Bytes = _getBytes( _wl_block520 );

    private final static java.lang.String  _wl_block521 ="\" size=\"3\" MAXLENGTH=\"5\" class=\"NUMBER\" style=\"visibility:hidden\" Value=\"\" onblur=\"setStockValue(this,\'";
    private final static byte[]  _wl_block521Bytes = _getBytes( _wl_block521 );

    private final static java.lang.String  _wl_block522 =");\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" >&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<label id=\"vol_uom";
    private final static byte[]  _wl_block522Bytes = _getBytes( _wl_block522 );

    private final static java.lang.String  _wl_block523 ="\"  class=\"label\" style=\"visibility:hidden;font-size:9px;\"></label><!--added for SKR-CRF-0035 End-->\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" nowrap colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t\t\t<label style=\"visibility:hidden\" id=\"inf_rate_leg";
    private final static byte[]  _wl_block523Bytes = _getBytes( _wl_block523 );

    private final static java.lang.String  _wl_block524 ="</label>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 start-->\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block524Bytes = _getBytes( _wl_block524 );

    private final static java.lang.String  _wl_block525 ="\');strtEndDateTime(";
    private final static byte[]  _wl_block525Bytes = _getBytes( _wl_block525 );

    private final static java.lang.String  _wl_block526 =");\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" style=\"visibility:hidden\" value=\"\" >&nbsp;<label id=\'uom_display";
    private final static byte[]  _wl_block526Bytes = _getBytes( _wl_block526 );

    private final static java.lang.String  _wl_block527 ="\' class=\"label\"></label>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block527Bytes = _getBytes( _wl_block527 );

    private final static java.lang.String  _wl_block528 ="\n\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block528Bytes = _getBytes( _wl_block528 );

    private final static java.lang.String  _wl_block529 ="\n\t\t\t\t\t\t\t\t\t\t\t<!-- If else condtions added for aakh-crf-0094 end-->\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block529Bytes = _getBytes( _wl_block529 );

    private final static java.lang.String  _wl_block530 ="</option>\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\'9\' class=\"label\" >\n\t\t\t\t\t\t\t\t\t\t\t<a HREF=\"#\" onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRate(\'";
    private final static byte[]  _wl_block530Bytes = _getBytes( _wl_block530 );

    private final static java.lang.String  _wl_block531 ="\" >&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block531Bytes = _getBytes( _wl_block531 );

    private final static java.lang.String  _wl_block532 ="\">\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block532Bytes = _getBytes( _wl_block532 );

    private final static java.lang.String  _wl_block533 ="\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block533Bytes = _getBytes( _wl_block533 );

    private final static java.lang.String  _wl_block534 ="\">\n\t\t\t<input type=\"hidden\" name=\"act_patient_class\" id=\"act_patient_class\"\tvalue=\"";
    private final static byte[]  _wl_block534Bytes = _getBytes( _wl_block534 );

    private final static java.lang.String  _wl_block535 ="\">\n\t\t\t<input type=\"hidden\" name=\"form_code\" id=\"form_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block535Bytes = _getBytes( _wl_block535 );

    private final static java.lang.String  _wl_block536 ="\">\n\t\t\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\"\t\tvalue=\"";
    private final static byte[]  _wl_block536Bytes = _getBytes( _wl_block536 );

    private final static java.lang.String  _wl_block537 ="\">\t\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_id\" id=\"bean_id\"\t\t\tVALUE=\"";
    private final static byte[]  _wl_block537Bytes = _getBytes( _wl_block537 );

    private final static java.lang.String  _wl_block538 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"bean_name\" id=\"bean_name\"\t\tVALUE=\"";
    private final static byte[]  _wl_block538Bytes = _getBytes( _wl_block538 );

    private final static java.lang.String  _wl_block539 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block539Bytes = _getBytes( _wl_block539 );

    private final static java.lang.String  _wl_block540 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\"\tvalue=\"";
    private final static byte[]  _wl_block540Bytes = _getBytes( _wl_block540 );

    private final static java.lang.String  _wl_block541 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_code\" id=\"order_type_code\" value=\"";
    private final static byte[]  _wl_block541Bytes = _getBytes( _wl_block541 );

    private final static java.lang.String  _wl_block542 ="\">\n\t\t\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block542Bytes = _getBytes( _wl_block542 );

    private final static java.lang.String  _wl_block543 ="\">\n\t\t\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\"\t\tvalue=\"";
    private final static byte[]  _wl_block543Bytes = _getBytes( _wl_block543 );

    private final static java.lang.String  _wl_block544 ="\">\n\t\t\t<input type=\"hidden\" name=\"LOCN_CODE\" id=\"LOCN_CODE\"\t\tvalue=\"";
    private final static byte[]  _wl_block544Bytes = _getBytes( _wl_block544 );

    private final static java.lang.String  _wl_block545 ="\">\n\t\t\t<input type=\"hidden\" name=\"locn_type\" id=\"locn_type\"\t\tvalue=\"";
    private final static byte[]  _wl_block545Bytes = _getBytes( _wl_block545 );

    private final static java.lang.String  _wl_block546 ="\">\t\n\t\t\t<input type=\"hidden\" name=\"base_uom\" id=\"base_uom\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block546Bytes = _getBytes( _wl_block546 );

    private final static java.lang.String  _wl_block547 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode1\" id=\"mode1\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block547Bytes = _getBytes( _wl_block547 );

    private final static java.lang.String  _wl_block548 ="\">\t\n\t\t\t<input type=\"hidden\" name=\"back_date\" id=\"back_date\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"future_date\" id=\"future_date\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\"\t\tvalue=\"";
    private final static byte[]  _wl_block548Bytes = _getBytes( _wl_block548 );

    private final static java.lang.String  _wl_block549 ="\">\n\t\t\t<input type=\"hidden\" name=\"iv_calc_infuse_by\" id=\"iv_calc_infuse_by\" value=\"";
    private final static byte[]  _wl_block549Bytes = _getBytes( _wl_block549 );

    private final static java.lang.String  _wl_block550 ="\">\n\t\t\t<input type=\"hidden\" name=\"param_volume_cal\" id=\"param_volume_cal\" value=\"";
    private final static byte[]  _wl_block550Bytes = _getBytes( _wl_block550 );

    private final static java.lang.String  _wl_block551 ="\"><!-- Added for AAKH-CRF_0094 -->\n\t\t\t<input type=\"hidden\" name=\"item_type_site_app\" id=\"item_type_site_app\"\tvalue=\"";
    private final static byte[]  _wl_block551Bytes = _getBytes( _wl_block551 );

    private final static java.lang.String  _wl_block552 ="\">\n\t\t\t<input type=\"hidden\" name=\"ext_disp_appl_yn\" id=\"ext_disp_appl_yn\"\tvalue=\"";
    private final static byte[]  _wl_block552Bytes = _getBytes( _wl_block552 );

    private final static java.lang.String  _wl_block553 ="\"> <!--Added for NMC-JD-CRF-0046-->\n\t\t\t<input type=\"hidden\" name=\"new_generic_name\" id=\"new_generic_name\"\tvalue=\"\"> <!-- Added for MMS-DM-CRF-0177 -->\n\t\t\t\n<script type=\"text/javascript\">\n";
    private final static byte[]  _wl_block553Bytes = _getBytes( _wl_block553 );

    private final static java.lang.String  _wl_block554 ="/* added for mms-dm-crf-0204 */\ncallCancel(\'";
    private final static byte[]  _wl_block554Bytes = _getBytes( _wl_block554 );

    private final static java.lang.String  _wl_block555 ="\'); \n";
    private final static byte[]  _wl_block555Bytes = _getBytes( _wl_block555 );

    private final static java.lang.String  _wl_block556 ="\n</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t\t</FORM>\n\t</BODY>\n</HTML>\n";
    private final static byte[]  _wl_block556Bytes = _getBytes( _wl_block556 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
16/4/2020		IN072917			Shazana												SKR-SCF-1317
07/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
15/07/2020      IN:073424		   Prabha												SKR-SCF-1391
06/01/2021		TFS-7345           Prabha      06/01/2020	  Manickavasagam J         MMS-DM-CRF-0177
12/02/2021      TFS-13907     	   Prabha 		12/02/2021     Manickam           	   PH-eCommon label issue in various transactions
2/3/2021		15129				Shazana						Manickam				ph eCommon labels issue 		
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");	
		String sStyle= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection con			= null;    //added for GHL-CRF-0549
	try{
		con						   = ConnectionManager.getConnection(request);//added for GHL-CRF-0549
   	  	boolean item_type_site_app = eCommon.Common.CommonBean.isSiteSpecific(con,"PH","ITEM_TYPE_APP");//added for GHL-CRF-0549
   	 boolean strength_display_app =eCommon.Common.CommonBean.isSiteSpecific(con,"PH","STRENGTH_DISPLAY_APP");//added for NMC-JD-CRF-0026
   	boolean op_take_home_med_flag = eCommon.Common.CommonBean.isSiteSpecific(con,"PH", "OP_TAKE_HOME_MEDICATION");//added for NMC-JD-CRF-0063[13355]
   	boolean req_diag_pres_found=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","REQ_DIAG_PRES_FOUND");
			String patient_id		= request.getParameter("patient_id");
			String encounter_id		= request.getParameter("encounter_id");
			String act_patient_class	= request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");
			String patient_class	= request.getParameter("patient_class")==null?act_patient_class:request.getParameter("patient_class");
			String start_date		= request.getParameter("start_date");
			String order_type_flag	= request.getParameter("order_type_flag");
			if(order_type_flag == null){ order_type_flag="";}
			String prev_order		= request.getParameter("prev_order")== null?"":request.getParameter("prev_order");   // Modified For IN:062361
			
			if(prev_order == null){ prev_order="";}
			String order_id1        = request.getParameter("order_id");
			String iv_prep_default	= request.getParameter("iv_prep_default")==null?act_patient_class:request.getParameter("iv_prep_default");
			String order_set_code	= request.getParameter("order_set_code")==null?act_patient_class:request.getParameter("order_set_code");
			String form_code		= "";
			String route_code		= "";
			String order_type_code	= "";
			String selected1		= "selected";
			String selected2		= "";
			String take_home_medication	= request.getParameter("take_home_medication")==null?"":request.getParameter("take_home_medication"); // Added For IN:062361
			String priority	= request.getParameter("priority")==null?"":request.getParameter("priority");   // Added For IN:062361
			
			//GHL-CRF-0549 - start
			String disp_by_alt_form_param = "";
			String disp_by_alt_form_drug = "";
			String item_type = "";
			String mm_item_low_cost_yn = ""; 
			String mm_item_high_margin_yn = "";
			String mm_item_Innovator_yn  = "";
			String allow_alternate_yn ="N"; //GHL-CRF-0549
			String allow_alternate_disabled	= "";
			String allow_alternate_checked = "";
			String allow_alternate		   = "N";
			//GHL-CRF-0549 - end
			//added for NMC-LD-CRF-0026 START	
			String strength_label_display="";
			if(strength_display_app){
				
				strength_label_display="display:inline;";
				
			}
			else{
				strength_label_display="display:none;";
				
			}
			//added for NMC-LD-CRF-0026 END
			ArrayList orderSetCodes	=new ArrayList();
			int t					= 0;
			String mode1= request.getParameter("mode");
			if(mode1==null) mode1	= "";
			String mode				= CommonRepository.getCommonKeyValue( "MODE_MODIFY" ); 
			String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
			String bean_name		= "ePH.IVPrescriptionBean";
			IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject( bean_id, bean_name, request ) ;
			bean.setOrderDate(com.ehis.util.DateUtils.convertDate(start_date,"DMYHM",locale,"en"));
			bean.setPatientClass(patient_class);
			bean.setPatId(patient_id);
			bean.setEncId(encounter_id);
			bean.setMode( mode ) ;
			String param_volume_cal=bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
			String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
			String or_bean_name		= "eOR.OrderEntryBean";
			OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject( or_bean_id, or_bean_name , request) ;
			String locn_type		= (String)ORbean.getLocationType();
			String locn_code		= (String)ORbean.getLocationCode();
			String pract_id			= (String)ORbean.getPractitionerId();
			String pract_name		= (String)ORbean.getPractitionerName();
			if(prev_order.equals("previous")){
				ORbean.setOrderId(order_id1);
			}
			String order_id			= (String)ORbean.getOrderId();
			bean.setLocationType(locn_type);
			bean.setLocationCode(locn_code);
			bean.setPractionerID(pract_id);
			String end_date			= "";
			String mfr_display		= "hidden";
			String remarksDisplay	= "display:inline";
			//String drug_code	= "";
			HashMap hm_fluid_details = null;
			String act_pat_class		= request.getParameter("act_pat_class")==null?"":request.getParameter("act_pat_class");  //RUT-CRF-0062
			if(bean.getAmendFluidDetails()==null){
				bean.loadAmendDetails(order_id, patient_id,act_pat_class);  //RUT-CRF-0062
			}else if(bean.getAmendFluidDetails() !=null && (bean.getAmendFluidDetails()).size()==0){
				bean.loadAmendDetails(order_id, patient_id,act_pat_class); //RUT-CRF-0062
			}
			hm_fluid_details = bean.getAmendFluidDetails();
			if(hm_fluid_details !=null){
				if(hm_fluid_details.size()>0){
					//drug_code	=	(String)hm_fluid_details.get("drug_code");
					start_date	=	(String)hm_fluid_details.get("START_DATE_TIME");
					end_date	=	(String)hm_fluid_details.get("END_DATE_TIME");
					start_date	=	bean.getOrderDate();
				}
			}

			if(start_date.equals(""))
				start_date = bean.getSysdate();
			String buildMAR_yn		= "";
			String MAR_app_yn		= "";
			String buildMAR_checked = "";
			
			String buildMAR_enable  = ""; // RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- begin
			String buildMAR_rule	= "";  
			String facility_id		=(String)session.getValue("facility_id");	// RUT-CRF-0062 [IN029600] Added to get Build MAR Rule CRF 0062 -- end
			/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
			String buildMAR_enable	= "";				 SRR20056-CRF-0649.1 */
			MAR_app_yn				= request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
			buildMAR_yn				= MAR_app_yn;
			
			//Start of NMC-JD-CRF-0046
			String ext_disp_appl_yn="";
			String  disp_loc = (String)bean.getDisp_locn_code();
			ext_disp_appl_yn = bean.getExtDispYN(disp_loc);
		       //End of NMC-JD-CRF-0046
			
			
			/*  RUT-CRF-0062 [IN029600] Commented to set Build MAR value based on Build MAR Rule
			if(MAR_app_yn.equals("Y")){
				/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(patient_class.equals("IP"))
					buildMAR_enable ="disabled";
				 SRR20056-CRF-0649.1 
				if(buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
			}*/
			ArrayList ExistingIVRecords;
			HashMap record;
			String catalog_desc			="";
			String qty_value			="";
			String infusion_rate		="";
			String infusion_over		="";
			String infuse_over_hr		="";
			String infuse_over_mi		="";
			String durnn_value			="";
			String start_date_time		="";
			String end_date_time		="";
			String readonly				="readonly";
			String disable				="disabled";
			String order_catalog_code	="";
			String stock_value			="";
			String stock_uom			="";
			String durn_unit			="H";
			String qty_unit				="";
			String actveVal				="hidden";
			String base_volume			="";
			String qty_unit_disp		="";
			String mfr_yn				="";
			String mfr_remarks			="";
			int i						=0;
			String row_count			="";
			int fluid_adr_count			=0;
			String fluid_adr_dispaly	="hidden";
			String disable_for_mfr		="";
			int totRec					=0;
			String perf_locn_code		=""; // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
			String perf_locn_desc		=""; // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
			String per_facility_id		=""; // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
			String  act_strength_value="";//added for NMC-JD-CRF-0026
			String  strength_uom_desc="";//added for NMC-JD-CRF-0026
			String  strength_per_value_pres_uom_val="";//added for NMC-JD-CRF-0026
			String  pres_base_uom_desc="";//added for NMC-JD-CRF-0026
			String diagnosis_found_yn="";//added for mms-dm-crf-0204
			String new_generic_name = ""; //Added for MMS-DM-CRF-0177
					
			HashMap mfr_recs			= new HashMap();
			ArrayList mfr_rec_detail	= new ArrayList();
			if(patient_class!=null ){//added for NMC-JD-CRF-0063 [13355] start
				if(patient_class.equals("EM")|| patient_class.equals("OP") ){  
					if(op_take_home_med_flag){
						bean.setTakeHomeMedicationOp("Y");
					}else{
						bean.setTakeHomeMedicationOp("N");
					}
				}
			}//END
			if(mode1.equals("amend")){
				bean.setOrderID(order_id1);
			}
			String iv_calc_infuse_by=bean.getIVCalcInfuseBy(); //added for SKR-CRF-0035
			if(order_type_flag.equals("Existing")||mode1.equals("amend")){	 
				String iv_calc_infuse_display="",  order_uom="", iv_durn_display; //iv_durn_display added for SKR-SCF-1077 [IN:054499]
				String order_qty = "";
				if(iv_calc_infuse_by.equals("I")){
					iv_calc_infuse_display="display:inline;";
					iv_durn_display="display:none;"; //added for SKR-SCF-1077 [IN:054499]
				}
				else{
					iv_calc_infuse_display="display:none;";
					iv_durn_display="display:inline;"; //added for SKR-SCF-1077 [IN:054499]
				} //added for SKR-CRF-0035 end
				ExistingIVRecords=new ArrayList();
				String answer = request.getParameter("answer")== null?"": request.getParameter("answer"); 
				ExistingIVRecords=(ArrayList)bean.getExistingIVRecords(order_id1,answer,act_pat_class);  //passed answer for IN24251 --16/12/2010-- priya
				ArrayList ord_disp_location = null; // Added For IN:062361
				for(i=0;i<ExistingIVRecords.size();i++){
					System.out.println("---->246 ExistingIVRecords><-----"+ExistingIVRecords);
					record=new HashMap();
					record=(HashMap)ExistingIVRecords.get(i);
					order_uom = (String)record.get("ORDER_UOM");
					mfr_yn = (String)record.get("MFR_YN");
					mfr_remarks = (String)record.get("MFR_REMARKS");
					order_catalog_code=(String)record.get("ORDER_CATALOG_CODE");
					catalog_desc=(String)record.get("CATALOG_DESC");
					start_date_time=(String)record.get("START_DATE_TIME");
					qty_value=(String)record.get("QTY_VALUE");
					infusion_rate=(String)record.get("INFUSION_RATE");
					infusion_over=(String)record.get("INFUSE_OVER");
					allow_alternate = (String)record.get("ALLOW_ALTERNATE_YN")==null?"N":(String)record.get("ALLOW_ALTERNATE_YN"); //GHL-CRF-0549
					 //ADDED FOR NMC-JD-CRF-0026 START
					System.out.println("---->246 DIAGNOSIS_FOUND_YN><-----"+(String)record.get("DIAGNOSIS_FOUND_YN"));
					
					 act_strength_value					= (String) record.get("STRENGTH_VALUE");
					  strength_uom_desc					= bean.getUomDisplay((String)session.getValue("facility_id"),(String) record.get("STRENGTH_UOM"));
					  strength_per_value_pres_uom_val		= (String) record.get("STRENGTH_PER_VALUE_PRES_UOM");
					  pres_base_uom_desc					= bean.getUomDisplay((String)session.getValue("facility_id"),(String) record.get("PRES_BASE_UOM"));
						if(req_diag_pres_found){
							diagnosis_found_yn= (String)record.get("DIAGNOSIS_FOUND_YN");//added for mms-dm-crf-0204	
						}
						else{
							diagnosis_found_yn="G";//added for mms-dm-crf-0204
						}
						System.out.println("---->246 DIAGNOSIS_FOUND_YN><-----"+diagnosis_found_yn);
					String strength_disply=act_strength_value+" "+strength_uom_desc+" / "+strength_per_value_pres_uom_val+" "+pres_base_uom_desc;
					//ADDED FOR NMC-JD-CRF-0026 END
					allow_alternate_disabled = "disabled";
					if(allow_alternate.equals("Y")){
					 allow_alternate_checked = "checked";
					}
					// Starting of IN:062361
					if(prev_order.equals("previous")){
						 
						 ord_disp_location  = (ArrayList) bean.getOrderDispenseLocation(locn_type,locn_code,take_home_medication,priority,"5","",patient_id,encounter_id);
						 perf_locn_code = (String)(ord_disp_location.get(0)) ==null?"":(String)ord_disp_location.get(0);
						 perf_locn_desc = (String)(ord_disp_location.get(2)) ==null?"":(String)ord_disp_location.get(2);;
					}else{
						perf_locn_code=(String)record.get("DISP_LOCN_CODE");  // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
						perf_locn_desc=(String)record.get("DISP_LOCN_DESC");  // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
						
					}//End of IN:062361
					per_facility_id=(String)record.get("PER_FACILITY_ID");  // Added for Bru-HIMS-CRF-347 [IN:037862] -- Begin
					if(infusion_over.indexOf(".") != -1){
						infuse_over_hr = infusion_over.substring(0,infusion_over.indexOf("."));
						Double temp = new Double(infusion_over);
						temp = temp*60;
						temp = (temp%60);
						infuse_over_mi = temp+""; // infuse_over_mi = xx.0
						infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx
					}
					else{
						infuse_over_hr = infusion_over;
						infuse_over_mi = "";
					}
					infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
					infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
					durnn_value=(String)record.get("DURN_VALUE");
					qty_unit=(String)record.get("QTY_UNIT");
					end_date_time=(String)record.get("END_DATE_TIME");
					durnn_value = mfr_yn.equals("Y")?"":durnn_value;
					if(!mfr_yn.equals("Y") && ((String)record.get("INFUSION_PER_UNIT")).equals("M")){
						selected1 = "";
						selected2 = "selected";
					}
					else{
						selected2 = "";
						selected1 = "selected";
					}
					fluid_adr_count = bean.getADRCount(patient_id,order_catalog_code);
					if(fluid_adr_count>0){
						fluid_adr_dispaly ="visible";
					}
					else{
						fluid_adr_dispaly ="hidden";
					}

					if(record.get("BUILD_MAR_YN")==null || record.get("BUILD_MAR_YN").equals("")){
						record.put("BUILD_MAR_YN",MAR_app_yn);
					}
					buildMAR_yn = (String) record.get("BUILD_MAR_YN");
					bean.setBuildMAR_yn(buildMAR_yn); //   RUT-CRF-0062 [IN029600] 
					/*	if(MAR_app_yn.equals("Y")){		//Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
						if(patient_class.equals("IP"))
							buildMAR_enable ="disabled";
						SRR20056-CRF-0649.1	*/
						/*RUT-CRF-0062 [IN029600] Commented to set the Build MAR Value based on Build  MAR Rule -- begin
						if(buildMAR_yn!= null && buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
						else
							buildMAR_checked="";
					}*/
					
					if(i==0){// Disable property will be loaded based on Buil MAR Rule , Checked Property will be loaded based on Existing value for the first drug selected
						if(buildMAR_yn.equals("Y"))
							buildMAR_checked ="Checked";
						else
							buildMAR_checked="";
						buildMAR_rule = record.get("BUILD_MAR_RULE").toString();

						if(buildMAR_rule.equals("CE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("UE")){
							buildMAR_enable="";
						}
						else if(buildMAR_rule.equals("CD")){
							buildMAR_enable="disabled";
						}
						else if(buildMAR_rule.equals("UD")){
							buildMAR_enable="disabled";
						}
						
						if(ext_disp_appl_yn.equals("Y"))   //ADDED FOR NMC-JD-CRF-0046--AMEND ORDER
						{
							buildMAR_enable="disabled";
							buildMAR_checked="";
							buildMAR_yn = "N";
						}
						
						bean.setBuildMAR_yn(buildMAR_yn);
					}
					// RUT-CRF-0062 [IN029600] Commented to set the Build MAR Value based on Build  MAR Rule -- end
					row_count=(i+1)+"";
					String temp_end_date_time = "";	
					if(!mode1.equals("amend")){
						if(end_date_time!=null && !(end_date_time.equals(""))){//Code added for IN23819 -- 21/09/2010-- priya
							 temp_end_date_time = DateUtils.convertDate(end_date_time, "DMYHM",locale,"en");
						}
						start_date_time=(String)bean.comp_date_time(temp_end_date_time,order_id,row_count); //passed temp_end_date_time instead of end_date_time for IN23819 -- 21/09/2010-- priya
						if(start_date_time!=null && !(start_date_time.equals(""))){//Code added for IN23819 -- 21/09/2010-- priya
							start_date_time = DateUtils.convertDate(start_date_time, "DMYHM","en",locale);
						}
						end_date_time = bean.populateEndDate(start_date_time, durnn_value, durn_unit);
					}								
					ArrayList stockDetails = bean.getStockDetails(order_catalog_code, "1");
					if(stockDetails.size()>0) {
						stock_value	=(String)stockDetails.get(0);
						base_volume = stock_value;
						stock_uom	=(String)stockDetails.get(1);
					}
					if(prev_order.equals("previous")){
						actveVal = "visible";
					}
					qty_unit_disp = bean.getUomDisplay((String)session.getValue("facility_id"),qty_unit);
					order_qty = Math.ceil(Float.parseFloat(qty_value)/Float.parseFloat(stock_value))+"";
					order_qty = order_qty.substring(0,order_qty.indexOf(".")); 
					if(mfr_yn.equals("Y")){
						disable_for_mfr = "disabled";
						mfr_recs = bean.getMFRRecs();
						totRec = Integer.parseInt((String)mfr_recs.get("totRec")==null?"0":(String)mfr_recs.get("totRec"));
						qty_value = "0";
						for(int k=1; k<=totRec; k++){
							mfr_rec_detail = (ArrayList)mfr_recs.get("MFR"+k);
							qty_value = (Float.parseFloat(qty_value)+Float.parseFloat((String)mfr_rec_detail.get(0)==null?"0":(String)mfr_rec_detail.get(0)))+""; //volume
						
							if(k == 1)
								start_date_time = (String)mfr_rec_detail.get(6);
							end_date_time = (String)mfr_rec_detail.get(7);
						}
					}
 
            _bw.write(_wl_block9Bytes, _wl_block9);

							if(i==0){

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

										if(MAR_app_yn.equals("Y")){ 
											if(!ext_disp_appl_yn.equals(""))  //nmc-jd-crf-0046
											{

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block14Bytes, _wl_block14);

										}
										}
										
										else{

            _bw.write(_wl_block15Bytes, _wl_block15);

										}

            _bw.write(_wl_block16Bytes, _wl_block16);

							}

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(fluid_adr_dispaly));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(actveVal));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( catalog_desc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block29Bytes, _wl_block29);
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(disable));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(perf_locn_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(per_facility_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(perf_locn_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(iv_durn_display));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( durnn_value  ));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( start_date_time ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( end_date_time ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_catalog_code ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(stock_uom ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(qty_value));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(base_volume));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(infusion_over));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(mfr_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block94Bytes, _wl_block94);
//added for NMC-JD-CRF-0026 START
									if(strength_display_app){
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strength_label_display));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
if(act_strength_value != null && act_strength_value !="" && !act_strength_value.equals("0")){ 
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strength_label_display));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(strength_disply));
            _bw.write(_wl_block101Bytes, _wl_block101);
} 
            _bw.write(_wl_block102Bytes, _wl_block102);
}//added for NMC-JD-CRF-0026 END
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( infusion_rate  ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block113Bytes, _wl_block113);
}else{   
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( infusion_rate  ));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block113Bytes, _wl_block113);
}
											
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(qty_unit ));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(qty_unit_disp ));
            _bw.write(_wl_block120Bytes, _wl_block120);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block125Bytes, _wl_block125);
}else{   
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block125Bytes, _wl_block125);
}
											
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block136Bytes, _wl_block136);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block140Bytes, _wl_block140);
}else { 
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(order_qty));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block142Bytes, _wl_block142);
} 
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,order_uom)));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(qty_unit_disp ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
if(param_volume_cal.equals("N")){ 

											
												if(mfr_yn.equals("Y")){ 
												
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(qty_value ));
            _bw.write(_wl_block161Bytes, _wl_block161);
	
											}
											else{
												
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(qty_value ));
            _bw.write(_wl_block163Bytes, _wl_block163);
			
											}

                                   			  }else { 											
												if(mfr_yn.equals("Y")){ 
											
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(qty_value ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block167Bytes, _wl_block167);
		}
											else{
											
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(qty_value ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block168Bytes, _wl_block168);
			
											}

                                            } 
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(qty_unit_disp ));
            _bw.write(_wl_block170Bytes, _wl_block170);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block157Bytes, _wl_block157);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_hr ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block125Bytes, _wl_block125);
}else{   
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_hr ));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block125Bytes, _wl_block125);
}
											
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block178Bytes, _wl_block178);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_mi ));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block125Bytes, _wl_block125);
}else{   
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_mi ));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block125Bytes, _wl_block125);
}
											
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block184Bytes, _wl_block184);
				
						
								if(item_type_site_app){ //GHL-CRF-549
			
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(allow_alternate_disabled));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(allow_alternate_checked));
            _bw.write(_wl_block189Bytes, _wl_block189);

								} 
								//GHL-CFR-0549 - end
			
            _bw.write(_wl_block190Bytes, _wl_block190);

									if(mfr_yn.equals("Y")){

            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(mode1));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block194Bytes, _wl_block194);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block202Bytes, _wl_block202);
			
									}
									else{
										
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block198Bytes, _wl_block198);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block205Bytes, _wl_block205);

									}
								
            _bw.write(_wl_block206Bytes, _wl_block206);

					if(!mfr_yn.equals("Y")){

            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block210Bytes, _wl_block210);

					}

            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block212Bytes, _wl_block212);
		
				}
			}
			else {
				if(iv_prep_default.equals("5") && !order_set_code.equals("")){
					orderSetCodes = bean.getOrdersetCodes(order_set_code);
				}
				if((orderSetCodes!= null) && (orderSetCodes.size() != 0 )){
					int te=0;
					String sQtyValue	= "";
					String sQtyUnit		= "";
					String sReqdROpt	= "";
					String sTimeFrame	= "0";
					String sChekBox		= "";
					ArrayList orderSetValues = bean.getOrderSetValues();
					start_date=bean.getSysdate();
					for(te=0;te<orderSetCodes.size();te++){
						order_set_code=(String)orderSetCodes.get(te);
						fluid_adr_count = bean.getADRCount(patient_id,order_set_code);
						if(fluid_adr_count>0){
							fluid_adr_dispaly ="visible";
						}
						else{
							fluid_adr_dispaly ="hidden";
						}
						String drug_desc=bean.getDrugDesc(order_set_code);
						if(drug_desc== null){drug_desc="";}
						order_type_code	= bean.getOrderType(order_set_code);
						bean.setFluidDetails(order_set_code,"","","",""); // CRF-0062 NEWLY ADDED
						ArrayList stockDetails = bean.getStockDetails(order_set_code, "1");
						String infuse	=	bean.getInfuseOverValue(order_set_code,"");
						String inf="";
						String stock_uom_code="";
						java.util.StringTokenizer sts =null;
						int inf_rate=0;
						if(infuse != null && !infuse.equals("")){
							sts = new java.util.StringTokenizer(infuse,"::");
						}
						while(sts.hasMoreTokens()){
							inf=	(String)sts.nextToken();
							sts.nextToken();
							sts.nextToken();
							sts.nextToken();
						}
						if(te==0){//  RUT-CRF-0062 [IN029600] To get Build MAR Rule flag  -- begin
							HashMap fluidDtls = (HashMap) bean.getFluidDetails();
							buildMAR_rule =fluidDtls.get("BUILD_MAR_RULE").toString();
							buildMAR_yn="N";
							if(buildMAR_rule==null)		
								buildMAR_rule="";
										
							if(buildMAR_rule.equals("CE")){
								buildMAR_checked ="checked";		
								buildMAR_enable="";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UE")){
								buildMAR_checked ="";		
								buildMAR_enable="";
							}
							else if(buildMAR_rule.equals("CD")){
								buildMAR_checked ="checked";		
								buildMAR_enable="disabled";
								buildMAR_yn="Y";
							}
							else if(buildMAR_rule.equals("UD")){
								buildMAR_checked ="";		
								buildMAR_enable="disabled";
							}
							bean.setBuildMAR_yn(buildMAR_yn);
						}//  RUT-CRF-0062 [IN029600] To get Build MAR Rule flag  -- end

						if(inf.indexOf(".") != -1){
							infuse_over_hr = inf.substring(0,inf.indexOf("."));
							Double temp = new Double(inf);
							temp = temp*60;
							temp = (temp%60);
							infuse_over_mi = temp+""; // infuse_over_mi = xx.0
							infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx
						}
						else{
							infuse_over_hr = inf;
							infuse_over_mi = "";
						}
						infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
						infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
						if (stockDetails!=null && stockDetails.size() != 0){
							stock_value=(String)stockDetails.get(0);
							base_volume = stock_value;
							stock_uom_code=(String)stockDetails.get(1);
							//start_date=bean.getSysdate();
							if(orderSetValues.size() > 0){
								for(int si=0; si<orderSetValues.size(); si=si+8){
									if(orderSetValues.get(si).equals(order_set_code)){
										sQtyValue	= (String)orderSetValues.get(si+1);
										sQtyUnit	= (String)orderSetValues.get(si+2);
										sReqdROpt	= (String)orderSetValues.get(si+6);
										sTimeFrame	= (String)orderSetValues.get(si+7);
									}
								}
							}
							if(sReqdROpt.equals("R")) sChekBox = "disabled"; else sChekBox = "";
							stock_value		= sQtyValue;
							stock_uom_code  = sQtyUnit;
							start_date		= bean.populateEndDate(start_date, sTimeFrame, "H");
							if(!inf.equals("") && !inf.equals("0")){
							  inf_rate=new Float(Math.ceil((Float.parseFloat(stock_value)/Float.parseFloat(inf)))).intValue();
							}
							end_date		= bean.populateEndDate(start_date, inf, "H");

            _bw.write(_wl_block213Bytes, _wl_block213);

									if(te == 0){

            _bw.write(_wl_block214Bytes, _wl_block214);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

												if(MAR_app_yn.equals("Y")){ //RUT-CRF-0062 [IN029600]  buildMAR_enable added below to enable/disable based on Build MAR Rule
													if(!ext_disp_appl_yn.equals("")) { //nmc-jd-crf-0046
														

            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block14Bytes, _wl_block14);

												}}
												else{

            _bw.write(_wl_block216Bytes, _wl_block216);

												}

            _bw.write(_wl_block217Bytes, _wl_block217);

									}

            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(fluid_adr_dispaly));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(sChekBox));
            _bw.write(_wl_block222Bytes, _wl_block222);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(new_generic_name));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(readonly));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block225Bytes, _wl_block225);
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block231Bytes, _wl_block231);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(inf.equals("0") ? "24":inf));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block240Bytes, _wl_block240);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( start_date));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( end_date));
            _bw.write(_wl_block248Bytes, _wl_block248);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_set_code ));
            _bw.write(_wl_block249Bytes, _wl_block249);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(stock_uom_code ));
            _bw.write(_wl_block250Bytes, _wl_block250);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(stock_uom_code ));
            _bw.write(_wl_block251Bytes, _wl_block251);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(stock_value ));
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(base_volume));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(sTimeFrame));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(infusion_over));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block260Bytes, _wl_block260);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(inf_rate));
            _bw.write(_wl_block262Bytes, _wl_block262);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block263Bytes, _wl_block263);
}else{   
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf(inf_rate));
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block263Bytes, _wl_block263);
}
											
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block267Bytes, _wl_block267);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block270Bytes, _wl_block270);
}else{   
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block272Bytes, _wl_block272);
}
											
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(te+2));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block294Bytes, _wl_block294);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block178Bytes, _wl_block178);
}else{   
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(i+1));
            _bw.write(_wl_block178Bytes, _wl_block178);
}
											
            _bw.write(_wl_block296Bytes, _wl_block296);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block297Bytes, _wl_block297);
}else{   
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block297Bytes, _wl_block297);
}
											
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block301Bytes, _wl_block301);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block305Bytes, _wl_block305);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block307Bytes, _wl_block307);
            out.print( String.valueOf(te+1));
            _bw.write(_wl_block308Bytes, _wl_block308);
	
			}
			//if(te !=0 ){
			start_date = end_date;
			//	}
		}
		String visblty = "hidden";
		if(te < 6){
			for(t=te;t<6;t++){ 
				if (t==te) 
					visblty = "visible"; 
				else 
					visblty = "hidden";			  

            _bw.write(_wl_block309Bytes, _wl_block309);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block310Bytes, _wl_block310);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block311Bytes, _wl_block311);
            out.print( String.valueOf(visblty));
            _bw.write(_wl_block312Bytes, _wl_block312);
            out.print( String.valueOf(visblty));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block314Bytes, _wl_block314);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(visblty));
            _bw.write(_wl_block317Bytes, _wl_block317);
            _bw.write(_wl_block318Bytes, _wl_block318);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(visblty));
            _bw.write(_wl_block319Bytes, _wl_block319);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block320Bytes, _wl_block320);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block321Bytes, _wl_block321);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block322Bytes, _wl_block322);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block323Bytes, _wl_block323);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block266Bytes, _wl_block266);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block324Bytes, _wl_block324);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block325Bytes, _wl_block325);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( start_date ));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block328Bytes, _wl_block328);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block329Bytes, _wl_block329);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( end_date ));
            _bw.write(_wl_block330Bytes, _wl_block330);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block331Bytes, _wl_block331);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block332Bytes, _wl_block332);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block333Bytes, _wl_block333);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block334Bytes, _wl_block334);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block335Bytes, _wl_block335);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(infusion_over));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block336Bytes, _wl_block336);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block337Bytes, _wl_block337);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block338Bytes, _wl_block338);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block339Bytes, _wl_block339);
}else{   
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block340Bytes, _wl_block340);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block341Bytes, _wl_block341);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block339Bytes, _wl_block339);
}
											
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block342Bytes, _wl_block342);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block343Bytes, _wl_block343);
}else{   
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block344Bytes, _wl_block344);
}
											
            _bw.write(_wl_block345Bytes, _wl_block345);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block346Bytes, _wl_block346);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block347Bytes, _wl_block347);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block348Bytes, _wl_block348);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block349Bytes, _wl_block349);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block350Bytes, _wl_block350);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block351Bytes, _wl_block351);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag57(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag58(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block352Bytes, _wl_block352);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block353Bytes, _wl_block353);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag59(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag60(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block354Bytes, _wl_block354);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(t+2));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block355Bytes, _wl_block355);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block356Bytes, _wl_block356);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag61(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block357Bytes, _wl_block357);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block178Bytes, _wl_block178);
}else{   
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block358Bytes, _wl_block358);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block178Bytes, _wl_block178);
}
											
            _bw.write(_wl_block296Bytes, _wl_block296);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block362Bytes, _wl_block362);
}else{   
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block361Bytes, _wl_block361);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block362Bytes, _wl_block362);
}
											
            _bw.write(_wl_block363Bytes, _wl_block363);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag62(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block364Bytes, _wl_block364);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag63(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block365Bytes, _wl_block365);

            if (_jsp__tag64(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block366Bytes, _wl_block366);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block367Bytes, _wl_block367);

						}
					}
				}
				else{ 
 
            _bw.write(_wl_block368Bytes, _wl_block368);

            if (_jsp__tag65(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block369Bytes, _wl_block369);

										if(MAR_app_yn.equals("Y")){
											if(!ext_disp_appl_yn.equals("")) { //nmc-jd-crf-0046 //RUT-CRF-0062 [IN029600]  buildMAR_enable added below to enable/disable based on Build MAR Rule
												  

            _bw.write(_wl_block370Bytes, _wl_block370);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block371Bytes, _wl_block371);

										}}
										else{

            _bw.write(_wl_block15Bytes, _wl_block15);

										}

            _bw.write(_wl_block372Bytes, _wl_block372);

					//Below code added and removed multiple fields and loaded using for loop 
					String fluidVisible="";
					String fluidID="";
					for(int row=1;row<=6;row++){
						if(row!=1){
							fluidVisible=" visibility:hidden;";
							fluidID="id=\"fluid_leg"+row+"\"";
						}
						else{
							fluidVisible="";
							fluidID="";
						}

            _bw.write(_wl_block373Bytes, _wl_block373);
            out.print( String.valueOf(row));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag66(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block374Bytes, _wl_block374);
            out.print( String.valueOf(row));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(row));
            _bw.write(_wl_block375Bytes, _wl_block375);
            out.print( String.valueOf(fluidID));
            _bw.write(_wl_block376Bytes, _wl_block376);
            out.print( String.valueOf(fluidVisible));
            _bw.write(_wl_block377Bytes, _wl_block377);

            if (_jsp__tag67(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block378Bytes, _wl_block378);
            out.print( String.valueOf(row));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(row));
            _bw.write(_wl_block379Bytes, _wl_block379);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(fluidVisible));
            _bw.write(_wl_block381Bytes, _wl_block381);
            _bw.write(_wl_block382Bytes, _wl_block382);
            out.print( String.valueOf(row));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(row));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block380Bytes, _wl_block380);
            out.print( String.valueOf(fluidVisible));
            _bw.write(_wl_block383Bytes, _wl_block383);
            out.print( String.valueOf(row));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(row));
            _bw.write(_wl_block384Bytes, _wl_block384);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag68(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block385Bytes, _wl_block385);
            out.print( String.valueOf(row));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(row));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(row));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(row));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(row));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(row));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row));
            _bw.write(_wl_block389Bytes, _wl_block389);
            out.print( String.valueOf(row));
            _bw.write(_wl_block390Bytes, _wl_block390);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag69(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block391Bytes, _wl_block391);
            out.print( String.valueOf(row));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(row));
            _bw.write(_wl_block392Bytes, _wl_block392);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(row));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(row));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block393Bytes, _wl_block393);
            out.print( String.valueOf(row));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag70(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block394Bytes, _wl_block394);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag71(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block395Bytes, _wl_block395);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag72(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block396Bytes, _wl_block396);
            out.print( String.valueOf(row));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(row));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( start_date ));
            _bw.write(_wl_block326Bytes, _wl_block326);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block397Bytes, _wl_block397);
            out.print( String.valueOf(row));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(row));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(row));
            _bw.write(_wl_block398Bytes, _wl_block398);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag73(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block399Bytes, _wl_block399);
            out.print( String.valueOf(row));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(row));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( end_date ));
            _bw.write(_wl_block400Bytes, _wl_block400);
            out.print( String.valueOf(row));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row));
            _bw.write(_wl_block401Bytes, _wl_block401);
            out.print( String.valueOf(row));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(row));
            _bw.write(_wl_block402Bytes, _wl_block402);
            out.print( String.valueOf(row));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(row));
            _bw.write(_wl_block403Bytes, _wl_block403);
            out.print( String.valueOf(row));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(row));
            _bw.write(_wl_block404Bytes, _wl_block404);
            out.print( String.valueOf(row));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(row));
            _bw.write(_wl_block405Bytes, _wl_block405);
            out.print( String.valueOf(row));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(row));
            _bw.write(_wl_block406Bytes, _wl_block406);
            out.print( String.valueOf(row));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(row));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(infusion_over));
            _bw.write(_wl_block407Bytes, _wl_block407);
            out.print( String.valueOf(row));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(row));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(row));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row));
            _bw.write(_wl_block409Bytes, _wl_block409);
//added for NMC-JD-CRF-0026 START
									if(strength_display_app){
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(row));
            _bw.write(_wl_block411Bytes, _wl_block411);
            out.print( String.valueOf(strength_label_display));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag74(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block412Bytes, _wl_block412);
            out.print( String.valueOf(row));
            _bw.write(_wl_block413Bytes, _wl_block413);
            out.print( String.valueOf(strength_label_display));
            _bw.write(_wl_block414Bytes, _wl_block414);
} //added for NMC-JD-CRF-0026END
									 
            _bw.write(_wl_block415Bytes, _wl_block415);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag75(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block416Bytes, _wl_block416);
 if(param_volume_cal.equals("N")){
												
            _bw.write(_wl_block417Bytes, _wl_block417);
            out.print( String.valueOf(row));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(row));
            _bw.write(_wl_block418Bytes, _wl_block418);
            out.print( String.valueOf(row));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block339Bytes, _wl_block339);
 }else{ 
            _bw.write(_wl_block419Bytes, _wl_block419);
            out.print( String.valueOf(row));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(row));
            _bw.write(_wl_block420Bytes, _wl_block420);
            out.print( String.valueOf(row));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(row));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block339Bytes, _wl_block339);
 }
            _bw.write(_wl_block421Bytes, _wl_block421);
            out.print( String.valueOf(row));
            _bw.write(_wl_block422Bytes, _wl_block422);
 if(param_volume_cal.equals("N")){
												
            _bw.write(_wl_block423Bytes, _wl_block423);
            out.print( String.valueOf(row));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(row));
            _bw.write(_wl_block424Bytes, _wl_block424);
            out.print( String.valueOf(row));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block343Bytes, _wl_block343);
 }else{ 
            _bw.write(_wl_block425Bytes, _wl_block425);
            out.print( String.valueOf(row));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(row));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(row));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(row));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(row));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(row));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block426Bytes, _wl_block426);
 }
            _bw.write(_wl_block427Bytes, _wl_block427);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag76(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag77(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block429Bytes, _wl_block429);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag78(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block430Bytes, _wl_block430);
            out.print( String.valueOf(row));
            _bw.write(_wl_block431Bytes, _wl_block431);
 if(param_volume_cal.equals("N")){
												
            _bw.write(_wl_block432Bytes, _wl_block432);
            out.print( String.valueOf(row));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(row));
            _bw.write(_wl_block433Bytes, _wl_block433);
 }else{ 
            _bw.write(_wl_block434Bytes, _wl_block434);
            out.print( String.valueOf(row));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(row));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(row));
            _bw.write(_wl_block436Bytes, _wl_block436);
 }
            _bw.write(_wl_block437Bytes, _wl_block437);
            out.print( String.valueOf(row));
            _bw.write(_wl_block438Bytes, _wl_block438);
            out.print( String.valueOf(row));
            _bw.write(_wl_block439Bytes, _wl_block439);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag79(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag80(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block440Bytes, _wl_block440);
            out.print( String.valueOf(row));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(row));
            _bw.write(_wl_block441Bytes, _wl_block441);
            out.print( String.valueOf(row));
            _bw.write(_wl_block442Bytes, _wl_block442);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag81(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block443Bytes, _wl_block443);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag82(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block444Bytes, _wl_block444);
 if(param_volume_cal.equals("N")){
												
            _bw.write(_wl_block445Bytes, _wl_block445);
            out.print( String.valueOf(row));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(row));
            _bw.write(_wl_block446Bytes, _wl_block446);
 }else{ 
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(row));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(row));
            _bw.write(_wl_block447Bytes, _wl_block447);
            out.print( String.valueOf(row));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(row));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(row));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(row));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block448Bytes, _wl_block448);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(row));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(row+1));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block449Bytes, _wl_block449);
 }
            _bw.write(_wl_block450Bytes, _wl_block450);
            out.print( String.valueOf(row));
            _bw.write(_wl_block451Bytes, _wl_block451);
            out.print( String.valueOf(row));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag83(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block452Bytes, _wl_block452);
 if(param_volume_cal.equals("N")){
												
            _bw.write(_wl_block453Bytes, _wl_block453);
            out.print( String.valueOf(row));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(row));
            _bw.write(_wl_block454Bytes, _wl_block454);
            out.print( String.valueOf(row));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(row));
            _bw.write(_wl_block178Bytes, _wl_block178);
 }else{ 
            _bw.write(_wl_block455Bytes, _wl_block455);
            out.print( String.valueOf(row));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(row));
            _bw.write(_wl_block456Bytes, _wl_block456);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(row));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block360Bytes, _wl_block360);
            out.print( String.valueOf(row));
            _bw.write(_wl_block178Bytes, _wl_block178);
 }
            _bw.write(_wl_block458Bytes, _wl_block458);
 if(param_volume_cal.equals("N")){
												
            _bw.write(_wl_block459Bytes, _wl_block459);
            out.print( String.valueOf(row));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(row));
            _bw.write(_wl_block460Bytes, _wl_block460);
            out.print( String.valueOf(row));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block362Bytes, _wl_block362);
 }else{ 
            _bw.write(_wl_block461Bytes, _wl_block461);
            out.print( String.valueOf(row));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(row));
            _bw.write(_wl_block462Bytes, _wl_block462);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block457Bytes, _wl_block457);
            out.print( String.valueOf(row));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(row));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(row));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row));
            _bw.write(_wl_block362Bytes, _wl_block362);
 }
            _bw.write(_wl_block463Bytes, _wl_block463);
            out.print( String.valueOf(row));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag84(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block464Bytes, _wl_block464);
            out.print( String.valueOf(row));
            _bw.write(_wl_block465Bytes, _wl_block465);
				

								if(item_type_site_app){ //GHL-CRF-549
			
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(row));
            _bw.write(_wl_block466Bytes, _wl_block466);

            if (_jsp__tag85(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block467Bytes, _wl_block467);
            out.print( String.valueOf(row));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(row));
            _bw.write(_wl_block468Bytes, _wl_block468);
            out.print( String.valueOf(allow_alternate_disabled));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(allow_alternate_checked));
            _bw.write(_wl_block189Bytes, _wl_block189);

								 
								} //GHL-CFR-0549 - end
			
            _bw.write(_wl_block469Bytes, _wl_block469);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(row));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(row));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag86(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(row));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(row));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(row));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block470Bytes, _wl_block470);

            if (_jsp__tag87(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block471Bytes, _wl_block471);
            out.print( String.valueOf(row));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(row));
            _bw.write(_wl_block472Bytes, _wl_block472);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block473Bytes, _wl_block473);

					}
				} 
			} 
			if((order_type_flag.equals("Existing")||mode1.equals("amend"))&& i<6){
				String prev_Vsb = "hidden";
				for( t=i;t<6;t++){ 
					if(!mode1.equals("amend")){
						if(t==i){
							prev_Vsb = "visible";}
						else{
							prev_Vsb = "hidden";
						}			  
					}
  
            _bw.write(_wl_block474Bytes, _wl_block474);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag88(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block475Bytes, _wl_block475);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block476Bytes, _wl_block476);
            out.print( String.valueOf(prev_Vsb));
            _bw.write(_wl_block313Bytes, _wl_block313);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block477Bytes, _wl_block477);

            if (_jsp__tag89(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block478Bytes, _wl_block478);
            _bw.write(_wl_block479Bytes, _wl_block479);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block315Bytes, _wl_block315);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(prev_Vsb));
            _bw.write(_wl_block480Bytes, _wl_block480);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block316Bytes, _wl_block316);
            out.print( String.valueOf(prev_Vsb));
            _bw.write(_wl_block481Bytes, _wl_block481);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag90(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block482Bytes, _wl_block482);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block386Bytes, _wl_block386);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block387Bytes, _wl_block387);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block388Bytes, _wl_block388);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block483Bytes, _wl_block483);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block484Bytes, _wl_block484);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag91(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block485Bytes, _wl_block485);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block486Bytes, _wl_block486);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block487Bytes, _wl_block487);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag92(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block488Bytes, _wl_block488);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag93(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block489Bytes, _wl_block489);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag94(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block490Bytes, _wl_block490);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block491Bytes, _wl_block491);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block327Bytes, _wl_block327);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block492Bytes, _wl_block492);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag95(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block493Bytes, _wl_block493);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block494Bytes, _wl_block494);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block495Bytes, _wl_block495);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block496Bytes, _wl_block496);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block497Bytes, _wl_block497);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block498Bytes, _wl_block498);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(infusion_over));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block408Bytes, _wl_block408);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block499Bytes, _wl_block499);
//added for NMC-JD-CRF-0026 START
									if(strength_display_app){
            _bw.write(_wl_block410Bytes, _wl_block410);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(strength_label_display));
            _bw.write(_wl_block97Bytes, _wl_block97);

            if (_jsp__tag96(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block500Bytes, _wl_block500);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(strength_label_display));
            _bw.write(_wl_block501Bytes, _wl_block501);
}//ADDED FOR NMC-JD-CRF-0026 END
									
            _bw.write(_wl_block502Bytes, _wl_block502);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag97(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block503Bytes, _wl_block503);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block504Bytes, _wl_block504);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block362Bytes, _wl_block362);
}else{   
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block505Bytes, _wl_block505);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block362Bytes, _wl_block362);
}
											
            _bw.write(_wl_block506Bytes, _wl_block506);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block507Bytes, _wl_block507);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag98(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block510Bytes, _wl_block510);
}else{   
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block508Bytes, _wl_block508);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block359Bytes, _wl_block359);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block509Bytes, _wl_block509);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag99(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block510Bytes, _wl_block510);
}
											
            _bw.write(_wl_block511Bytes, _wl_block511);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block512Bytes, _wl_block512);

            if (_jsp__tag100(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block513Bytes, _wl_block513);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block514Bytes, _wl_block514);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block435Bytes, _wl_block435);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block515Bytes, _wl_block515);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block516Bytes, _wl_block516);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag101(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);

            if (_jsp__tag102(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block517Bytes, _wl_block517);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block518Bytes, _wl_block518);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag103(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block519Bytes, _wl_block519);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag104(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block520Bytes, _wl_block520);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block521Bytes, _wl_block521);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(t+2));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block522Bytes, _wl_block522);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block523Bytes, _wl_block523);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag105(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block524Bytes, _wl_block524);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block527Bytes, _wl_block527);
}else{   
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block526Bytes, _wl_block526);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block527Bytes, _wl_block527);
}
											
            _bw.write(_wl_block528Bytes, _wl_block528);
 if(param_volume_cal.equals("N")){  
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block426Bytes, _wl_block426);
}else{   
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block525Bytes, _wl_block525);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block426Bytes, _wl_block426);
}
											
            _bw.write(_wl_block529Bytes, _wl_block529);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag106(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block428Bytes, _wl_block428);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block130Bytes, _wl_block130);

            if (_jsp__tag107(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block530Bytes, _wl_block530);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag108(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(mfr_display));
            _bw.write(_wl_block531Bytes, _wl_block531);

            if (_jsp__tag109(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(t+1));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block532Bytes, _wl_block532);
 
				}
			} 

            _bw.write(_wl_block533Bytes, _wl_block533);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block534Bytes, _wl_block534);
            out.print( String.valueOf(act_patient_class));
            _bw.write(_wl_block535Bytes, _wl_block535);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block536Bytes, _wl_block536);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block537Bytes, _wl_block537);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block538Bytes, _wl_block538);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block539Bytes, _wl_block539);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block540Bytes, _wl_block540);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block541Bytes, _wl_block541);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block542Bytes, _wl_block542);
            out.print( String.valueOf(pract_id));
            _bw.write(_wl_block543Bytes, _wl_block543);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block544Bytes, _wl_block544);
            out.print( String.valueOf(locn_code));
            _bw.write(_wl_block545Bytes, _wl_block545);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block546Bytes, _wl_block546);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block547Bytes, _wl_block547);
            out.print( String.valueOf(mode1));
            _bw.write(_wl_block548Bytes, _wl_block548);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block549Bytes, _wl_block549);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block550Bytes, _wl_block550);
            out.print( String.valueOf(param_volume_cal));
            _bw.write(_wl_block551Bytes, _wl_block551);
            out.print( String.valueOf(item_type_site_app));
            _bw.write(_wl_block552Bytes, _wl_block552);
            out.print( String.valueOf(ext_disp_appl_yn));
            _bw.write(_wl_block553Bytes, _wl_block553);
if(  req_diag_pres_found && diagnosis_found_yn.equals("N") ){ 
            _bw.write(_wl_block554Bytes, _wl_block554);
            out.print( String.valueOf(diagnosis_found_yn));
            _bw.write(_wl_block555Bytes, _wl_block555);
 }
            _bw.write(_wl_block556Bytes, _wl_block556);

putObjectInBean(bean_id,bean,request);
putObjectInBean(or_bean_id,ORbean,request);
}catch(Exception e){
	e.printStackTrace();
}finally{ 
       	if(con != null)
      		ConnectionManager.returnConnection(con,request);	 //added for GHL-CRF-0549
}


            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ForRepeat.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }

    private boolean _jsp__tag7(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag7 = null ;
        int __result__tag7 = 0 ;

        if (__tag7 == null ){
            __tag7 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag7);
        }
        __tag7.setPageContext(pageContext);
        __tag7.setParent(null);
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag7;
        __result__tag7 = __tag7.doStartTag();

        if (__result__tag7!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag7== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag7.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag7);
            return true;
        }
        _activeTag=__tag7.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag7);
        __tag7.release();
        return false;
    }

    private boolean _jsp__tag8(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag8 = null ;
        int __result__tag8 = 0 ;

        if (__tag8 == null ){
            __tag8 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag8);
        }
        __tag8.setPageContext(pageContext);
        __tag8.setParent(null);
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag8;
        __result__tag8 = __tag8.doStartTag();

        if (__result__tag8!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag8== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag8.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag8);
            return true;
        }
        _activeTag=__tag8.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag8);
        __tag8.release();
        return false;
    }

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }

    private boolean _jsp__tag16(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag16 = null ;
        int __result__tag16 = 0 ;

        if (__tag16 == null ){
            __tag16 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag16);
        }
        __tag16.setPageContext(pageContext);
        __tag16.setParent(null);
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag16;
        __result__tag16 = __tag16.doStartTag();

        if (__result__tag16!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag16== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag16.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag16);
            return true;
        }
        _activeTag=__tag16.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag16);
        __tag16.release();
        return false;
    }

    private boolean _jsp__tag17(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag17 = null ;
        int __result__tag17 = 0 ;

        if (__tag17 == null ){
            __tag17 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag17);
        }
        __tag17.setPageContext(pageContext);
        __tag17.setParent(null);
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag17;
        __result__tag17 = __tag17.doStartTag();

        if (__result__tag17!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag17== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag17.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag17);
            return true;
        }
        _activeTag=__tag17.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag17);
        __tag17.release();
        return false;
    }

    private boolean _jsp__tag18(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag18 = null ;
        int __result__tag18 = 0 ;

        if (__tag18 == null ){
            __tag18 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag18);
        }
        __tag18.setPageContext(pageContext);
        __tag18.setParent(null);
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag18;
        __result__tag18 = __tag18.doStartTag();

        if (__result__tag18!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag18== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag18.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag18);
            return true;
        }
        _activeTag=__tag18.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag18);
        __tag18.release();
        return false;
    }

    private boolean _jsp__tag19(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag19 = null ;
        int __result__tag19 = 0 ;

        if (__tag19 == null ){
            __tag19 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag19);
        }
        __tag19.setPageContext(pageContext);
        __tag19.setParent(null);
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag19;
        __result__tag19 = __tag19.doStartTag();

        if (__result__tag19!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag19== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag19.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag19);
            return true;
        }
        _activeTag=__tag19.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag19);
        __tag19.release();
        return false;
    }

    private boolean _jsp__tag20(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag20 = null ;
        int __result__tag20 = 0 ;

        if (__tag20 == null ){
            __tag20 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag20);
        }
        __tag20.setPageContext(pageContext);
        __tag20.setParent(null);
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllowAlternate.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag20;
        __result__tag20 = __tag20.doStartTag();

        if (__result__tag20!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag20== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag20.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag20);
            return true;
        }
        _activeTag=__tag20.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag20);
        __tag20.release();
        return false;
    }

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ForRepeat.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ForRepeat.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }

    private boolean _jsp__tag57(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag57 = null ;
        int __result__tag57 = 0 ;

        if (__tag57 == null ){
            __tag57 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag57);
        }
        __tag57.setPageContext(pageContext);
        __tag57.setParent(null);
        __tag57.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag57.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag57;
        __result__tag57 = __tag57.doStartTag();

        if (__result__tag57!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag57== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag57.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag57);
            return true;
        }
        _activeTag=__tag57.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag57);
        __tag57.release();
        return false;
    }

    private boolean _jsp__tag58(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag58 = null ;
        int __result__tag58 = 0 ;

        if (__tag58 == null ){
            __tag58 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag58);
        }
        __tag58.setPageContext(pageContext);
        __tag58.setParent(null);
        __tag58.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
        __tag58.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag58;
        __result__tag58 = __tag58.doStartTag();

        if (__result__tag58!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag58== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag58.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag58);
            return true;
        }
        _activeTag=__tag58.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag58);
        __tag58.release();
        return false;
    }

    private boolean _jsp__tag59(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag59 = null ;
        int __result__tag59 = 0 ;

        if (__tag59 == null ){
            __tag59 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag59);
        }
        __tag59.setPageContext(pageContext);
        __tag59.setParent(null);
        __tag59.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag59.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag59;
        __result__tag59 = __tag59.doStartTag();

        if (__result__tag59!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag59== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag59.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag59);
            return true;
        }
        _activeTag=__tag59.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag59);
        __tag59.release();
        return false;
    }

    private boolean _jsp__tag60(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag60 = null ;
        int __result__tag60 = 0 ;

        if (__tag60 == null ){
            __tag60 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag60);
        }
        __tag60.setPageContext(pageContext);
        __tag60.setParent(null);
        __tag60.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag60.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag60;
        __result__tag60 = __tag60.doStartTag();

        if (__result__tag60!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag60== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag60.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag60);
            return true;
        }
        _activeTag=__tag60.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag60);
        __tag60.release();
        return false;
    }

    private boolean _jsp__tag61(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag61 = null ;
        int __result__tag61 = 0 ;

        if (__tag61 == null ){
            __tag61 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag61);
        }
        __tag61.setPageContext(pageContext);
        __tag61.setParent(null);
        __tag61.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag61.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag61;
        __result__tag61 = __tag61.doStartTag();

        if (__result__tag61!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag61== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag61.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag61);
            return true;
        }
        _activeTag=__tag61.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag61);
        __tag61.release();
        return false;
    }

    private boolean _jsp__tag62(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag62 = null ;
        int __result__tag62 = 0 ;

        if (__tag62 == null ){
            __tag62 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag62);
        }
        __tag62.setPageContext(pageContext);
        __tag62.setParent(null);
        __tag62.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag62.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag62;
        __result__tag62 = __tag62.doStartTag();

        if (__result__tag62!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag62== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag62.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag62);
            return true;
        }
        _activeTag=__tag62.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag62);
        __tag62.release();
        return false;
    }

    private boolean _jsp__tag63(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag63 = null ;
        int __result__tag63 = 0 ;

        if (__tag63 == null ){
            __tag63 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag63);
        }
        __tag63.setPageContext(pageContext);
        __tag63.setParent(null);
        __tag63.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
        __tag63.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag63;
        __result__tag63 = __tag63.doStartTag();

        if (__result__tag63!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag63== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag63.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag63);
            return true;
        }
        _activeTag=__tag63.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag63);
        __tag63.release();
        return false;
    }

    private boolean _jsp__tag64(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag64 = null ;
        int __result__tag64 = 0 ;

        if (__tag64 == null ){
            __tag64 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag64);
        }
        __tag64.setPageContext(pageContext);
        __tag64.setParent(null);
        __tag64.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag64.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag64;
        __result__tag64 = __tag64.doStartTag();

        if (__result__tag64!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag64== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag64.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag64);
            return true;
        }
        _activeTag=__tag64.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag64);
        __tag64.release();
        return false;
    }

    private boolean _jsp__tag65(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag65 = null ;
        int __result__tag65 = 0 ;

        if (__tag65 == null ){
            __tag65 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag65);
        }
        __tag65.setPageContext(pageContext);
        __tag65.setParent(null);
        __tag65.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag65.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag65;
        __result__tag65 = __tag65.doStartTag();

        if (__result__tag65!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag65== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag65.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag65);
            return true;
        }
        _activeTag=__tag65.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag65);
        __tag65.release();
        return false;
    }

    private boolean _jsp__tag66(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag66 = null ;
        int __result__tag66 = 0 ;

        if (__tag66 == null ){
            __tag66 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag66);
        }
        __tag66.setPageContext(pageContext);
        __tag66.setParent(null);
        __tag66.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag66.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag66;
        __result__tag66 = __tag66.doStartTag();

        if (__result__tag66!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag66== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag66.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag66);
            return true;
        }
        _activeTag=__tag66.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag66);
        __tag66.release();
        return false;
    }

    private boolean _jsp__tag67(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag67 = null ;
        int __result__tag67 = 0 ;

        if (__tag67 == null ){
            __tag67 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag67);
        }
        __tag67.setPageContext(pageContext);
        __tag67.setParent(null);
        __tag67.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
        __tag67.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag67;
        __result__tag67 = __tag67.doStartTag();

        if (__result__tag67!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag67== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag67.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag67);
            return true;
        }
        _activeTag=__tag67.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag67);
        __tag67.release();
        return false;
    }

    private boolean _jsp__tag68(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag68 = null ;
        int __result__tag68 = 0 ;

        if (__tag68 == null ){
            __tag68 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag68);
        }
        __tag68.setPageContext(pageContext);
        __tag68.setParent(null);
        __tag68.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag68.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag68;
        __result__tag68 = __tag68.doStartTag();

        if (__result__tag68!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag68== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag68.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag68);
            return true;
        }
        _activeTag=__tag68.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag68);
        __tag68.release();
        return false;
    }

    private boolean _jsp__tag69(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag69 = null ;
        int __result__tag69 = 0 ;

        if (__tag69 == null ){
            __tag69 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag69);
        }
        __tag69.setPageContext(pageContext);
        __tag69.setParent(null);
        __tag69.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
        __tag69.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag69;
        __result__tag69 = __tag69.doStartTag();

        if (__result__tag69!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag69== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag69.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag69);
            return true;
        }
        _activeTag=__tag69.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag69);
        __tag69.release();
        return false;
    }

    private boolean _jsp__tag70(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag70 = null ;
        int __result__tag70 = 0 ;

        if (__tag70 == null ){
            __tag70 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag70);
        }
        __tag70.setPageContext(pageContext);
        __tag70.setParent(null);
        __tag70.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag70.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag70;
        __result__tag70 = __tag70.doStartTag();

        if (__result__tag70!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag70== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag70.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag70);
            return true;
        }
        _activeTag=__tag70.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag70);
        __tag70.release();
        return false;
    }

    private boolean _jsp__tag71(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag71 = null ;
        int __result__tag71 = 0 ;

        if (__tag71 == null ){
            __tag71 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag71);
        }
        __tag71.setPageContext(pageContext);
        __tag71.setParent(null);
        __tag71.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ForRepeat.label", java.lang.String .class,"key"));
        __tag71.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag71;
        __result__tag71 = __tag71.doStartTag();

        if (__result__tag71!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag71== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag71.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag71);
            return true;
        }
        _activeTag=__tag71.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag71);
        __tag71.release();
        return false;
    }

    private boolean _jsp__tag72(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag72 = null ;
        int __result__tag72 = 0 ;

        if (__tag72 == null ){
            __tag72 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag72);
        }
        __tag72.setPageContext(pageContext);
        __tag72.setParent(null);
        __tag72.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag72.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag72;
        __result__tag72 = __tag72.doStartTag();

        if (__result__tag72!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag72== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag72.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag72);
            return true;
        }
        _activeTag=__tag72.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag72);
        __tag72.release();
        return false;
    }

    private boolean _jsp__tag73(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag73 = null ;
        int __result__tag73 = 0 ;

        if (__tag73 == null ){
            __tag73 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag73);
        }
        __tag73.setPageContext(pageContext);
        __tag73.setParent(null);
        __tag73.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
        __tag73.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag73;
        __result__tag73 = __tag73.doStartTag();

        if (__result__tag73!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag73== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag73.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag73);
            return true;
        }
        _activeTag=__tag73.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag73);
        __tag73.release();
        return false;
    }

    private boolean _jsp__tag74(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag74 = null ;
        int __result__tag74 = 0 ;

        if (__tag74 == null ){
            __tag74 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag74);
        }
        __tag74.setPageContext(pageContext);
        __tag74.setParent(null);
        __tag74.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
        __tag74.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag74;
        __result__tag74 = __tag74.doStartTag();

        if (__result__tag74!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag74== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag74.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag74);
            return true;
        }
        _activeTag=__tag74.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag74);
        __tag74.release();
        return false;
    }

    private boolean _jsp__tag75(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag75 = null ;
        int __result__tag75 = 0 ;

        if (__tag75 == null ){
            __tag75 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag75);
        }
        __tag75.setPageContext(pageContext);
        __tag75.setParent(null);
        __tag75.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
        __tag75.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag75;
        __result__tag75 = __tag75.doStartTag();

        if (__result__tag75!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag75== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag75.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag75);
            return true;
        }
        _activeTag=__tag75.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag75);
        __tag75.release();
        return false;
    }

    private boolean _jsp__tag76(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag76 = null ;
        int __result__tag76 = 0 ;

        if (__tag76 == null ){
            __tag76 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag76);
        }
        __tag76.setPageContext(pageContext);
        __tag76.setParent(null);
        __tag76.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
        __tag76.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag76;
        __result__tag76 = __tag76.doStartTag();

        if (__result__tag76!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag76== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag76.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag76);
            return true;
        }
        _activeTag=__tag76.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag76);
        __tag76.release();
        return false;
    }

    private boolean _jsp__tag77(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag77 = null ;
        int __result__tag77 = 0 ;

        if (__tag77 == null ){
            __tag77 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag77);
        }
        __tag77.setPageContext(pageContext);
        __tag77.setParent(null);
        __tag77.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag77.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag77;
        __result__tag77 = __tag77.doStartTag();

        if (__result__tag77!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag77== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag77.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag77);
            return true;
        }
        _activeTag=__tag77.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag77);
        __tag77.release();
        return false;
    }

    private boolean _jsp__tag78(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag78 = null ;
        int __result__tag78 = 0 ;

        if (__tag78 == null ){
            __tag78 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag78);
        }
        __tag78.setPageContext(pageContext);
        __tag78.setParent(null);
        __tag78.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag78.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag78;
        __result__tag78 = __tag78.doStartTag();

        if (__result__tag78!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag78== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag78.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag78);
            return true;
        }
        _activeTag=__tag78.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag78);
        __tag78.release();
        return false;
    }

    private boolean _jsp__tag79(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag79 = null ;
        int __result__tag79 = 0 ;

        if (__tag79 == null ){
            __tag79 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag79);
        }
        __tag79.setPageContext(pageContext);
        __tag79.setParent(null);
        __tag79.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag79.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag79;
        __result__tag79 = __tag79.doStartTag();

        if (__result__tag79!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag79== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag79.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag79);
            return true;
        }
        _activeTag=__tag79.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag79);
        __tag79.release();
        return false;
    }

    private boolean _jsp__tag80(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag80 = null ;
        int __result__tag80 = 0 ;

        if (__tag80 == null ){
            __tag80 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag80);
        }
        __tag80.setPageContext(pageContext);
        __tag80.setParent(null);
        __tag80.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
        __tag80.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag80;
        __result__tag80 = __tag80.doStartTag();

        if (__result__tag80!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag80== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag80.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag80);
            return true;
        }
        _activeTag=__tag80.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag80);
        __tag80.release();
        return false;
    }

    private boolean _jsp__tag81(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag81 = null ;
        int __result__tag81 = 0 ;

        if (__tag81 == null ){
            __tag81 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag81);
        }
        __tag81.setPageContext(pageContext);
        __tag81.setParent(null);
        __tag81.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag81.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag81;
        __result__tag81 = __tag81.doStartTag();

        if (__result__tag81!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag81== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag81.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag81);
            return true;
        }
        _activeTag=__tag81.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag81);
        __tag81.release();
        return false;
    }

    private boolean _jsp__tag82(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag82 = null ;
        int __result__tag82 = 0 ;

        if (__tag82 == null ){
            __tag82 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag82);
        }
        __tag82.setPageContext(pageContext);
        __tag82.setParent(null);
        __tag82.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag82.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag82;
        __result__tag82 = __tag82.doStartTag();

        if (__result__tag82!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag82== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag82.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag82);
            return true;
        }
        _activeTag=__tag82.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag82);
        __tag82.release();
        return false;
    }

    private boolean _jsp__tag83(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag83 = null ;
        int __result__tag83 = 0 ;

        if (__tag83 == null ){
            __tag83 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag83);
        }
        __tag83.setPageContext(pageContext);
        __tag83.setParent(null);
        __tag83.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag83.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag83;
        __result__tag83 = __tag83.doStartTag();

        if (__result__tag83!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag83== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag83.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag83);
            return true;
        }
        _activeTag=__tag83.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag83);
        __tag83.release();
        return false;
    }

    private boolean _jsp__tag84(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag84 = null ;
        int __result__tag84 = 0 ;

        if (__tag84 == null ){
            __tag84 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag84);
        }
        __tag84.setPageContext(pageContext);
        __tag84.setParent(null);
        __tag84.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag84.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag84;
        __result__tag84 = __tag84.doStartTag();

        if (__result__tag84!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag84== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag84.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag84);
            return true;
        }
        _activeTag=__tag84.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag84);
        __tag84.release();
        return false;
    }

    private boolean _jsp__tag85(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag85 = null ;
        int __result__tag85 = 0 ;

        if (__tag85 == null ){
            __tag85 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag85);
        }
        __tag85.setPageContext(pageContext);
        __tag85.setParent(null);
        __tag85.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AllowAlternate.label", java.lang.String .class,"key"));
        __tag85.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag85;
        __result__tag85 = __tag85.doStartTag();

        if (__result__tag85!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag85== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag85.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag85);
            return true;
        }
        _activeTag=__tag85.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag85);
        __tag85.release();
        return false;
    }

    private boolean _jsp__tag86(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag86 = null ;
        int __result__tag86 = 0 ;

        if (__tag86 == null ){
            __tag86 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag86);
        }
        __tag86.setPageContext(pageContext);
        __tag86.setParent(null);
        __tag86.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
        __tag86.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag86;
        __result__tag86 = __tag86.doStartTag();

        if (__result__tag86!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag86== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag86.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag86);
            return true;
        }
        _activeTag=__tag86.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag86);
        __tag86.release();
        return false;
    }

    private boolean _jsp__tag87(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag87 = null ;
        int __result__tag87 = 0 ;

        if (__tag87 == null ){
            __tag87 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag87);
        }
        __tag87.setPageContext(pageContext);
        __tag87.setParent(null);
        __tag87.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag87.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag87;
        __result__tag87 = __tag87.doStartTag();

        if (__result__tag87!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag87== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag87.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag87);
            return true;
        }
        _activeTag=__tag87.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag87);
        __tag87.release();
        return false;
    }

    private boolean _jsp__tag88(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag88 = null ;
        int __result__tag88 = 0 ;

        if (__tag88 == null ){
            __tag88 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag88);
        }
        __tag88.setPageContext(pageContext);
        __tag88.setParent(null);
        __tag88.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdverseDrugReaction.label", java.lang.String .class,"key"));
        __tag88.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag88;
        __result__tag88 = __tag88.doStartTag();

        if (__result__tag88!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag88== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag88.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag88);
            return true;
        }
        _activeTag=__tag88.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag88);
        __tag88.release();
        return false;
    }

    private boolean _jsp__tag89(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag89 = null ;
        int __result__tag89 = 0 ;

        if (__tag89 == null ){
            __tag89 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag89);
        }
        __tag89.setPageContext(pageContext);
        __tag89.setParent(null);
        __tag89.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
        __tag89.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag89;
        __result__tag89 = __tag89.doStartTag();

        if (__result__tag89!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag89== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag89.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag89);
            return true;
        }
        _activeTag=__tag89.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag89);
        __tag89.release();
        return false;
    }

    private boolean _jsp__tag90(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag90 = null ;
        int __result__tag90 = 0 ;

        if (__tag90 == null ){
            __tag90 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag90);
        }
        __tag90.setPageContext(pageContext);
        __tag90.setParent(null);
        __tag90.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispenseLocation.label", java.lang.String .class,"key"));
        __tag90.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag90;
        __result__tag90 = __tag90.doStartTag();

        if (__result__tag90!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag90== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag90.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag90);
            return true;
        }
        _activeTag=__tag90.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag90);
        __tag90.release();
        return false;
    }

    private boolean _jsp__tag91(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag91 = null ;
        int __result__tag91 = 0 ;

        if (__tag91 == null ){
            __tag91 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag91);
        }
        __tag91.setPageContext(pageContext);
        __tag91.setParent(null);
        __tag91.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
        __tag91.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag91;
        __result__tag91 = __tag91.doStartTag();

        if (__result__tag91!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag91== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag91.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag91);
            return true;
        }
        _activeTag=__tag91.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag91);
        __tag91.release();
        return false;
    }

    private boolean _jsp__tag92(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag92 = null ;
        int __result__tag92 = 0 ;

        if (__tag92 == null ){
            __tag92 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag92);
        }
        __tag92.setPageContext(pageContext);
        __tag92.setParent(null);
        __tag92.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag92.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag92;
        __result__tag92 = __tag92.doStartTag();

        if (__result__tag92!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag92== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag92.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag92);
            return true;
        }
        _activeTag=__tag92.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag92);
        __tag92.release();
        return false;
    }

    private boolean _jsp__tag93(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag93 = null ;
        int __result__tag93 = 0 ;

        if (__tag93 == null ){
            __tag93 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag93);
        }
        __tag93.setPageContext(pageContext);
        __tag93.setParent(null);
        __tag93.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ForRepeat.label", java.lang.String .class,"key"));
        __tag93.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag93;
        __result__tag93 = __tag93.doStartTag();

        if (__result__tag93!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag93== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag93.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag93);
            return true;
        }
        _activeTag=__tag93.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag93);
        __tag93.release();
        return false;
    }

    private boolean _jsp__tag94(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag94 = null ;
        int __result__tag94 = 0 ;

        if (__tag94 == null ){
            __tag94 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag94);
        }
        __tag94.setPageContext(pageContext);
        __tag94.setParent(null);
        __tag94.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag94.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag94;
        __result__tag94 = __tag94.doStartTag();

        if (__result__tag94!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag94== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag94.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag94);
            return true;
        }
        _activeTag=__tag94.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag94);
        __tag94.release();
        return false;
    }

    private boolean _jsp__tag95(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag95 = null ;
        int __result__tag95 = 0 ;

        if (__tag95 == null ){
            __tag95 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag95);
        }
        __tag95.setPageContext(pageContext);
        __tag95.setParent(null);
        __tag95.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
        __tag95.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag95;
        __result__tag95 = __tag95.doStartTag();

        if (__result__tag95!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag95== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag95.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag95);
            return true;
        }
        _activeTag=__tag95.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag95);
        __tag95.release();
        return false;
    }

    private boolean _jsp__tag96(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag96 = null ;
        int __result__tag96 = 0 ;

        if (__tag96 == null ){
            __tag96 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag96);
        }
        __tag96.setPageContext(pageContext);
        __tag96.setParent(null);
        __tag96.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Strength.label", java.lang.String .class,"key"));
        __tag96.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag96;
        __result__tag96 = __tag96.doStartTag();

        if (__result__tag96!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag96== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag96.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag96);
            return true;
        }
        _activeTag=__tag96.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag96);
        __tag96.release();
        return false;
    }

    private boolean _jsp__tag97(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag97 = null ;
        int __result__tag97 = 0 ;

        if (__tag97 == null ){
            __tag97 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag97);
        }
        __tag97.setPageContext(pageContext);
        __tag97.setParent(null);
        __tag97.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag97.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag97;
        __result__tag97 = __tag97.doStartTag();

        if (__result__tag97!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag97== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag97.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag97);
            return true;
        }
        _activeTag=__tag97.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag97);
        __tag97.release();
        return false;
    }

    private boolean _jsp__tag98(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag98 = null ;
        int __result__tag98 = 0 ;

        if (__tag98 == null ){
            __tag98 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag98);
        }
        __tag98.setPageContext(pageContext);
        __tag98.setParent(null);
        __tag98.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag98.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag98;
        __result__tag98 = __tag98.doStartTag();

        if (__result__tag98!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag98== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag98.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag98);
            return true;
        }
        _activeTag=__tag98.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag98);
        __tag98.release();
        return false;
    }

    private boolean _jsp__tag99(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag99 = null ;
        int __result__tag99 = 0 ;

        if (__tag99 == null ){
            __tag99 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag99);
        }
        __tag99.setPageContext(pageContext);
        __tag99.setParent(null);
        __tag99.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
        __tag99.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag99;
        __result__tag99 = __tag99.doStartTag();

        if (__result__tag99!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag99== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag99.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag99);
            return true;
        }
        _activeTag=__tag99.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag99);
        __tag99.release();
        return false;
    }

    private boolean _jsp__tag100(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag100 = null ;
        int __result__tag100 = 0 ;

        if (__tag100 == null ){
            __tag100 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag100);
        }
        __tag100.setPageContext(pageContext);
        __tag100.setParent(null);
        __tag100.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag100.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag100;
        __result__tag100 = __tag100.doStartTag();

        if (__result__tag100!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag100== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag100.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag100);
            return true;
        }
        _activeTag=__tag100.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag100);
        __tag100.release();
        return false;
    }

    private boolean _jsp__tag101(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag101 = null ;
        int __result__tag101 = 0 ;

        if (__tag101 == null ){
            __tag101 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag101);
        }
        __tag101.setPageContext(pageContext);
        __tag101.setParent(null);
        __tag101.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag101.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag101;
        __result__tag101 = __tag101.doStartTag();

        if (__result__tag101!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag101== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag101.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag101);
            return true;
        }
        _activeTag=__tag101.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag101);
        __tag101.release();
        return false;
    }

    private boolean _jsp__tag102(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag102 = null ;
        int __result__tag102 = 0 ;

        if (__tag102 == null ){
            __tag102 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag102);
        }
        __tag102.setPageContext(pageContext);
        __tag102.setParent(null);
        __tag102.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
        __tag102.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag102;
        __result__tag102 = __tag102.doStartTag();

        if (__result__tag102!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag102== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag102.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag102);
            return true;
        }
        _activeTag=__tag102.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag102);
        __tag102.release();
        return false;
    }

    private boolean _jsp__tag103(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag103 = null ;
        int __result__tag103 = 0 ;

        if (__tag103 == null ){
            __tag103 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag103);
        }
        __tag103.setPageContext(pageContext);
        __tag103.setParent(null);
        __tag103.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
        __tag103.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag103;
        __result__tag103 = __tag103.doStartTag();

        if (__result__tag103!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag103== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag103.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag103);
            return true;
        }
        _activeTag=__tag103.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag103);
        __tag103.release();
        return false;
    }

    private boolean _jsp__tag104(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag104 = null ;
        int __result__tag104 = 0 ;

        if (__tag104 == null ){
            __tag104 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag104);
        }
        __tag104.setPageContext(pageContext);
        __tag104.setParent(null);
        __tag104.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
        __tag104.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag104;
        __result__tag104 = __tag104.doStartTag();

        if (__result__tag104!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag104== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag104.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag104);
            return true;
        }
        _activeTag=__tag104.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag104);
        __tag104.release();
        return false;
    }

    private boolean _jsp__tag105(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag105 = null ;
        int __result__tag105 = 0 ;

        if (__tag105 == null ){
            __tag105 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag105);
        }
        __tag105.setPageContext(pageContext);
        __tag105.setParent(null);
        __tag105.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
        __tag105.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag105;
        __result__tag105 = __tag105.doStartTag();

        if (__result__tag105!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag105== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag105.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag105);
            return true;
        }
        _activeTag=__tag105.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag105);
        __tag105.release();
        return false;
    }

    private boolean _jsp__tag106(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag106 = null ;
        int __result__tag106 = 0 ;

        if (__tag106 == null ){
            __tag106 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag106);
        }
        __tag106.setPageContext(pageContext);
        __tag106.setParent(null);
        __tag106.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
        __tag106.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag106;
        __result__tag106 = __tag106.doStartTag();

        if (__result__tag106!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag106== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag106.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag106);
            return true;
        }
        _activeTag=__tag106.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag106);
        __tag106.release();
        return false;
    }

    private boolean _jsp__tag107(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag107 = null ;
        int __result__tag107 = 0 ;

        if (__tag107 == null ){
            __tag107 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag107);
        }
        __tag107.setPageContext(pageContext);
        __tag107.setParent(null);
        __tag107.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag107.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag107;
        __result__tag107 = __tag107.doStartTag();

        if (__result__tag107!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag107== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag107.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag107);
            return true;
        }
        _activeTag=__tag107.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag107);
        __tag107.release();
        return false;
    }

    private boolean _jsp__tag108(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag108 = null ;
        int __result__tag108 = 0 ;

        if (__tag108 == null ){
            __tag108 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag108);
        }
        __tag108.setPageContext(pageContext);
        __tag108.setParent(null);
        __tag108.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
        __tag108.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag108;
        __result__tag108 = __tag108.doStartTag();

        if (__result__tag108!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag108== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag108.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag108);
            return true;
        }
        _activeTag=__tag108.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag108);
        __tag108.release();
        return false;
    }

    private boolean _jsp__tag109(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag109 = null ;
        int __result__tag109 = 0 ;

        if (__tag109 == null ){
            __tag109 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag109);
        }
        __tag109.setPageContext(pageContext);
        __tag109.setParent(null);
        __tag109.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag109.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag109;
        __result__tag109 = __tag109.doStartTag();

        if (__result__tag109!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag109== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag109.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag109);
            return true;
        }
        _activeTag=__tag109.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag109);
        __tag109.release();
        return false;
    }
}
