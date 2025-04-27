package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import eCommon.Common.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivprescriptionadmindetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPrescriptionAdminDetail.jsp", 1741694101421L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<!-- ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<HTML>\n\t<HEAD>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/ValidateControl.js\"></SCRIPT>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/DrugNameCommonLookup.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n \n\t</HEAD>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t<form name=\"formIVPrescriptionAdminDetail\" id=\"formIVPrescriptionAdminDetail\">\n\t\t\t<input type=\"hidden\" name=\"MFR_start_time\" id=\"MFR_start_time\" value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"8\"><font style=\"font-size:9\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></td>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'10%\' class=\'label\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t<td width=\'20%\' class=\'label\'>\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t<input type=\"text\" class=\"number\" size=\"5\" maxlength=\"9\" name=\"INFUSION_VALUE\" id=\"INFUSION_VALUE\" value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'  onBlur=\"CheckNum(this);setInfusion_uom();calVolumeInfuseOver();showAdminRate();\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =">\n\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t<input type=\"text\" class=\"number\" size=\"5\" maxlength=\"9\" name=\"INFUSION_VALUE\" id=\"INFUSION_VALUE\" value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'  onBlur=\"CheckNum(this);setInfusion_uom();setInfuseOverValue();showAdminRate();\" onKeyPress=\"return allowValidNumber(this,event,6,2);\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<label align=\"left\" class=\'label\' id=\'infusion_uom_display\'><b>&nbsp;";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</b></label>\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t<select name=\"lstInfusionRateDurnUnit\" id=\"lstInfusionRateDurnUnit\" onChange=\"ChangeInfuseOverTime(this);calVolumeInfuseOver()\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t<select name=\"lstInfusionRateDurnUnit\" id=\"lstInfusionRateDurnUnit\" onChange=\"ChangeInfuseOverTime(this);setInfuseOverValue()\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t<option value=\"M\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</option>\n\t\t\t\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t\t\t\t\t</select>\n\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" width=\'10%\' id=\"tdOrderQty_leg\" style=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" width=\'15%\' id=\"tdOrd_qty\" style=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t<input disabled type=\'text\' class=\"NUMBER\" name=\'order_qty\' id=\'order_qty\' size=\"1\" maxlength=\"3\" disabled>&nbsp;<label id=\"ord_qty_uom\" class=\"label\" style=\"font-size:9px;\" ></label>\n\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t<input type=\'text\' class=\"NUMBER\" name=\'order_qty\' id=\'order_qty\' size=\"1\" maxlength=\"3\" onKeyPress=\"return allowValidNumber(this,event,2,0);\" onchange=\"calcTotalVolume()\">&nbsp;<label id=\"ord_qty_uom\" class=\"label\" style=\"font-size:9px;\" ></label>\n\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'8%\' class=\'label\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" &nbsp;</label>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'19%\' class=\'label\'>\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t<input type=\"text\" class=\"number\" size=\'1\' maxlength=\"2\" name=\"INFUSION_PERIOD_VALUE\" id=\"INFUSION_PERIOD_VALUE\" value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  onKeyPress=\"return allowValidNumber(this,event,3,0);\"  onBlur=\"CheckNum(this);checkHr(INFUSION_PERIOD_VALUE,\'H\');calVolumeInfuseRate();showAdminRate();\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t\t<input type=\"text\" class=\"number\" size=\'1\' maxlength=\"2\" name=\"INFUSION_PERIOD_VALUE\" id=\"INFUSION_PERIOD_VALUE\" value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'  onKeyPress=\"return allowValidNumber(this,event,3,0);\"  onBlur=\"CheckNum(this);checkHr(INFUSION_PERIOD_VALUE,\'H\');setInfuseRateValue();showAdminRate();\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<b>:</b>\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 START -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t<input type=\"text\" class=\"number\" size=\'1\' maxlength=\"2\" name=\"INFUSION_PERIOD_VALUE_MIN\" id=\"INFUSION_PERIOD_VALUE_MIN\" value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'  onKeyPress=\"return allowValidNumber(this,event,3,0);\"  onBlur=\"CheckNum(this);checkHr(INFUSION_PERIOD_VALUE_MIN,\'M\');calVolumeInfuseRate();showAdminRate();\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t<input type=\"text\" class=\"number\" size=\'1\' maxlength=\"2\" name=\"INFUSION_PERIOD_VALUE_MIN\" id=\"INFUSION_PERIOD_VALUE_MIN\" value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'  onKeyPress=\"return allowValidNumber(this,event,3,0);\"  onBlur=\"CheckNum(this);checkHr(INFUSION_PERIOD_VALUE_MIN,\'M\');setInfuseRateValue();showAdminRate();\" ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end -->\n\t\t\t\t\t\t\n\t\t\t\t\t\t<!--<label align=\"left\"  width=\'5%\'class=\'label\' id=\"infusionOverUnit\"><b>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</b></label>-->\n\t\t\t\t\t\t<label align=\"left\"  width=\'5%\'class=\'label\' ><b>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b></label>\n\t\t\t\t\t\t<label align=\"left\"  width=\'5%\'class=\'label\' name=\"infusionOverStr\" id=\"infusionOverStr\">";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</label>\n\t\t\t\t\t</td>\t\t\n\t\t\t\t\t<td width=\'8%\' class=\'label\' style=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<br><label style=\"visibility:visible\" id=\"\">";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</label><!-- added Bllow label ForRepeat for the INC NO:32739 By chandrashekar raju-->\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'10%\' class=\'label\' style=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\t\t\t\t\t\t<input type=\"text\" class=\"number\" size=\"1\" maxlength=\"2\" value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' name=\"DURN_VALUE\" onChange=\"CheckNum(this);chkDuration(this,\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\');\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =">&nbsp;<b>";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</b>&nbsp; <!-- Onblur Changed to Onchange for SKR-SCF-1392 -->\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\'*\'class=\'label\'>&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr> \n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t<input type=\"text\" name=\"START_DATE\" id=\"START_DATE\" value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" size=\"14\" maxlength=\"16\"  onblur=\"resetInfuse(this)\" tabindex=\"-1\">&nbsp;<IMG src=\"../../eCommon/images/CommonCalendar.gif\" id=Calendar onclick=\"showCalendar(\'START_DATE\',null,\'hh:mm\');document.formIVPrescriptionAdminDetail.START_DATE.focus();return false;\"  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =">&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" ></img>\n\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t<td class=\'label\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="&nbsp;&nbsp;</td>\n\t\t\t\t\t<td class=\'label\'>\n\t\t\t\t\t<input type=\"text\" name=\"END_DATE\" id=\"END_DATE\" value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" size=\"14\" maxlength=\"12\"  readonly>&nbsp; \n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\'label\' calspan=\'4\'> \n\t\t\t\t\t\t<A HREF onMouseOver=\"changeCursor(this);\" onClick=\"adminRate();\" style=\"visibility:hidden\" id=\'adminrate\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" </A>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\n\t\t\t<input type=\"hidden\" name=\"BEAN_ID\" id=\"BEAN_ID\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<input type=\"hidden\" name=\"BEAN_NAME\" id=\"BEAN_NAME\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"LOCN_TYPE\" id=\"LOCN_TYPE\" VALUE=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"LOCN_CODE\" id=\"LOCN_CODE\" VALUE=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"INFUSION_PERIOD_UOM\" id=\"INFUSION_PERIOD_UOM\" VALUE=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' >\n\t\t\t<INPUT TYPE=\"hidden\" name=\"DURN_UNIT\" id=\"DURN_UNIT\" VALUE=\'H\'>\n\t\t\t<INPUT TYPE=\"hidden\" name=\"INFUSION_UOM\" id=\"INFUSION_UOM\" VALUE=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"FREQUENCY\" id=\"FREQUENCY\" VALUE = \'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>\n\t\t\t<input type=\"hidden\" name=\"freq_desc\" id=\"freq_desc\" value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' >\n\t\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t\t<input type=\"hidden\" name=\"drug_codes\" id=\"drug_codes\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t\t\t<input type=\"hidden\" name=\"INFUSION_UOM_DISPLAY\" id=\"INFUSION_UOM_DISPLAY\" value=\"\">\n\t\t\t<INPUT TYPE=\"hidden\" name=\"PRACT_ID\" id=\"PRACT_ID\" VALUE=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t\t<input type=\"hidden\" name=\"EQVL_UOM_CODE\" id=\"EQVL_UOM_CODE\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"INFUSION_PER_UNIT\" id=\"INFUSION_PER_UNIT\" value=\"H\">\n\t\t\t<input type=\"hidden\" name=\"order_type_flag\" id=\"order_type_flag\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t\t<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t\t<input type=\"hidden\" name=\"prev_order\" id=\"prev_order\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t\t<input type=\"hidden\" name=\"infusion_over_insert_value\" id=\"infusion_over_insert_value\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name=\"errorFound\" id=\"errorFound\" value=\"false\">\n\t\t\t<input type=\"hidden\" name=\"MFR_YN_Flag\" id=\"MFR_YN_Flag\" value=\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'>\n\t\t\t<input type=\"hidden\" name=\"INFUSION_VALUE_WITHOUT_ROUND\" id=\"INFUSION_VALUE_WITHOUT_ROUND\" value=\'\'><!--added for IN61608-->\n\t\t\t<input type=\"hidden\" name=\"previous\" id=\"previous\" value=\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\'><!-- new hidden var - prev order copy MFR issue : 26465 -->\n\t\t\t<input type=\"hidden\" name=\"iv_calc_infuse_by\" id=\"iv_calc_infuse_by\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"> <!-- SKR-CRF-0035 -->\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\n\t\t</FORM>\n\t</body>\n\t<script>\n\t\tvar str = getHrsMinStr(document.formIVPrescriptionAdminDetail.INFUSION_PERIOD_VALUE.value,document.formIVPrescriptionAdminDetail.lstInfusionRateDurnUnit.value);\n\t\t//document.formIVPrescriptionAdminDetail.all.infusionOverStr.innerHTML\t= str;\n\t</script>\n";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t<script>\n\t\t\tchkDuration(document.formIVPrescriptionAdminDetail.DURN_VALUE,\'1\');\n\t\t\tshowAdminRate();\n\t\t</script>\n";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n</HTML>\n\n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );
	
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
23/07/2020      IN073425           Prabha											   SKR-SCF-1392
--------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

	String patient_id			= request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String encounter_id			= request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
	String patient_class		= request.getParameter("act_patient_class")==null?"":request.getParameter("act_patient_class");
	String start_date			= request.getParameter("start_date")==null?"":request.getParameter("start_date");
	String mode					= request.getParameter("mode")==null?"":request.getParameter("mode");
	String pr_order_id			= request.getParameter("order_id")==null?"":request.getParameter("order_id");
	String prev_order			= request.getParameter("prev_order")==null?"":request.getParameter("prev_order");
	String locale = (String) session.getAttribute("LOCALE");
	String mfr_yn				= "";
	String disable_for_mfr		= "";
	String infusion_rate		= "";
	String infuse_over			= "";
	String duration				= "24";
	String start_time			= "";
	String end_time				= "";
	String disabled				= "";
	String order_line_num		= "";
	String QTY_UNIT				= "";
	String renewOrderStartDate  = "";
	String selected1  = "selected";
	String selected2  = "";
	String timeFrame			= "";
	String infusion_period_uom ="H"; 
	String infusionOverUnit =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
	infusion_period_uom="H"; 
	ArrayList orderSetValues	= new ArrayList();

	ArrayList exstngIVOrders = new ArrayList();
	HashMap   record = new HashMap();

	String order_type_flag = request.getParameter("order_type_flag")==null?"":request.getParameter("order_type_flag");
	String	infuse_over_hr = "";
	String	infuse_over_mi = "";

	if(order_type_flag.equals("Existing")) 
		disabled = "disabled";
	if(mode.equals("amend")) 
		disabled = "";

	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id, bean_name,request) ;
	
	bean.setPatId(patient_id);
	bean.setEncId(encounter_id);
	bean.setLanguageId(locale);
	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
	String locn_type	= (String)ORbean.getLocationType();
	String locn_code	= (String)ORbean.getLocationCode();
	String pract_id		= (String)ORbean.getPractitionerId()==null?"":(String)ORbean.getPractitionerId();
	String iv_calc_infuse_by=bean.getIVCalcInfuseBy(); //added for SKR-CRF-0035 start
	String iv_calc_infuse_display="", iv_calc_duration_display="";
	if(iv_calc_infuse_by.equals("I")){
		iv_calc_infuse_display="display:inline;";
		iv_calc_duration_display="display:none;";
	}
	else{
		iv_calc_infuse_display="display:none;";
		iv_calc_duration_display="display:inline;";
	} //added for SKR-CRF-0035 end
	String param_volume_cal=bean.getParamVolumeCalc();//aDDED FOR AAKH-CRF-0094
	
	String disp_str = "";
	if(!prev_order.equals("") && prev_order.equals("previous")){
		ORbean.setOrderId(pr_order_id);
		disabled = "";
	}
	String order_id		= (String)ORbean.getOrderId();
	String freq_code = "";
	String freq_desc = "";

	ArrayList frequency = bean.getFrequency();
	if(frequency.size() > 0){
		freq_code = (String)frequency.get(0);
		freq_desc = (String)frequency.get(1);
	}
	if((order_type_flag.equals("Existing") || mode.equals("amend"))){
		exstngIVOrders = bean.getAllExistingIVOrders();
		record = (HashMap)exstngIVOrders.get(0);
// the below 3 vars were assigned inside the if(!mfr_yn.equals("Y")){} block , now its assigned outside if block- prev order copy MFR issue : 26465
		start_time = (String)record.get("START_DATE_TIME");
		end_time = (String)record.get("END_DATE_TIME");
		order_line_num = (String)record.get("ORDER_LINE_NUM");

		mfr_yn = (String)record.get("MFR_YN")==null?"":(String)record.get("MFR_YN");
		if(!mfr_yn.equals("Y")){
			infusion_rate = (String)record.get("INFUSION_RATE");
			infuse_over = (String)record.get("INFUSE_OVER");
			if(!infusion_rate.equals("")){
				if(Float.parseFloat(infusion_rate)<1 && Float.parseFloat(infusion_rate)>0)
				infusion_rate=Float.parseFloat(infusion_rate)+"";
			}
			if(infuse_over.indexOf(".") != -1){
				infuse_over_hr = infuse_over.substring(0,infuse_over.indexOf("."));
				Double temp = new Double(infuse_over);
				temp = temp*60;
				temp = (temp%60);

				infuse_over_mi = Math.round(temp)+""; // infuse_over_mi = xx.0
				if(infuse_over_mi.indexOf(".") != -1)
					infuse_over_mi = infuse_over_mi.substring(0,infuse_over_mi.indexOf(".")); // infuse_over_mi = xx
			}
			else{
				infuse_over_hr = infuse_over;
				infuse_over_mi = "";
			}
			infuse_over_hr = infuse_over_hr.equals("")?"0":infuse_over_hr;
			infuse_over_mi = infuse_over_mi.equals("")?"0":infuse_over_mi;
			disp_str = "["+infuse_over_hr+" Hrs "+infuse_over_mi+" Mins]";
			if(iv_calc_infuse_by.equals("I"))
				duration = "24";
			else
				duration = (String)record.get("DURN_VALUE");
			
			QTY_UNIT  = (String)record.get("QTY_UNIT")==null?"":(String)record.get("QTY_UNIT");
			if(!QTY_UNIT.equals("")) 
				QTY_UNIT = QTY_UNIT+" / ";

	//		infusion_period_uom				=(String)record.get("INFUSION_PER_UNIT")==null?"H":(String)record.get("INFUSION_PER_UNIT");
			infusion_period_uom				=(String)record.get("INF_PERIOD_UNIT")==null?"H":(String)record.get("INF_PERIOD_UNIT");

			if(infusion_period_uom.equals("H")){
				selected2="";
				selected1="selected";
				infusionOverUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Hour(s).label","common_labels");
				infusion_period_uom="H";
			}
			else  if(infusion_period_uom.equals("M")){ 
				selected1="";
				selected2="selected";
				infusionOverUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Minute(s).label","common_labels");
			}
		}
		else{
			disable_for_mfr = "disabled";
			if(iv_calc_infuse_by.equals("I"))
				duration="24";
			else
				duration = (String)((HashMap)bean.getMFRRecs()).get("totDurnHrs");
		}
	}

	if(!mode.equals("amend")){
		renewOrderStartDate=bean.comp_date_time(end_time,order_id,order_line_num);
		start_time =renewOrderStartDate;
	}
	if(!start_date.equals("") && (prev_order==null || !prev_order.equals("previous"))) {
		start_time  = start_date;
		if(!locale.equals("en")){ //if condition added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574] Leap Year Issue
			start_time = DateUtils.convertDate(start_time, "DMYHM",locale,"en");	//added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
			//sys_date_time_str = DateUtils.convertDate(sys_date_time_str, "DMYHM","en",locale); //commented for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
		}
		end_time	= bean.populateEndDate(start_time,"24","H");//added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
		start_time  = DateUtils.convertDate(start_time, "DMYHM","en",locale);//added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
		end_time    = DateUtils.convertDate(end_time, "DMYHM","en",locale); //added for RollForward from SRR - SRR20056-SCF-9423 [IN:056574]
	}																						//added for [IN:56574]
/*==============================================================================================================*/
//Code added for IN23819 -- 21/09/2010-- priya
	if(prev_order!=null && prev_order.equals("previous")){
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm"); 
		try{ 
			 java.util.Date sys_date_time =  df.parse(bean.getSysdate());  
			 String sys_date_time_str = df.format(sys_date_time);
				if(!locale.equals("en")){
					start_time = DateUtils.convertDate(start_time, "DMYHM","en",locale);
					sys_date_time_str = DateUtils.convertDate(sys_date_time_str, "DMYHM","en",locale);
				}
				java.util.Date ord_end_date_time = df.parse(start_time);             
				if((df.parse(end_time)).compareTo(df.parse(sys_date_time_str))< 0){
					start_time = sys_date_time_str;
				}
				else{
					start_time = df.format(ord_end_date_time);
				}	
				end_time	= bean.populateEndDate(df.format(df.parse(start_time)),"24","H");
			
				// whole of if condition added, so that the duration is passed correctly of mfr- prev order copy MFR issue : 26465
				if(mfr_yn.equals("Y")){
					end_time	= bean.populateEndDate(df.format(df.parse(start_time)),duration,"H");
				}

				/*if(!locale.equals("en")){
					start_time = DateUtils.convertDate(start_time, "DMYHM","en",locale);
					end_time = DateUtils.convertDate(end_time, "DMYHM","en",locale);
				} */
		}
		catch (Exception e) {
			e.printStackTrace();
		} 
	}
	orderSetValues = bean.getOrderSetValues();
	if(orderSetValues.size() > 0){
		start_date = bean.getSysdate();
		timeFrame			= (String)orderSetValues.get(7);
		for(int i = 0; i < orderSetValues.size(); i=i+8){
			if(Integer.parseInt((String)orderSetValues.get(i+7)) > Integer.parseInt(timeFrame)){
				timeFrame	= (String)orderSetValues.get(i+7);
			}
		}
		start_time	= bean.populateEndDate(start_date,timeFrame,"H");
		start_date = start_time;
	}
	if(start_date.equals("")) { 
		start_date = start_time;
	} 

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(infusion_rate));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
					else{  
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(infusion_rate));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(QTY_UNIT));
            _bw.write(_wl_block21Bytes, _wl_block21);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
					else{  
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(selected2));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(selected1));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block30Bytes, _wl_block30);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block31Bytes, _wl_block31);
}
					else{  
            _bw.write(_wl_block32Bytes, _wl_block32);
 } 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
					else{  
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(infuse_over_hr));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block39Bytes, _wl_block39);
if(param_volume_cal.equals("N")){ 
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
}
					else{  
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(infuse_over_mi));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block17Bytes, _wl_block17);
 } 
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(infusionOverUnit));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(disp_str));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(iv_calc_duration_display));
            _bw.write(_wl_block48Bytes, _wl_block48);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(iv_calc_duration_display));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(duration));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(disable_for_mfr));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( locn_type ));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( locn_code ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(infusion_period_uom));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(infusion_period_uom));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(freq_code));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( bean.getDrugCodes() ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf( pract_id ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order_type_flag));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(prev_order));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(infuse_over));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(mfr_yn));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(prev_order));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(iv_calc_infuse_by));
            _bw.write(_wl_block82Bytes, _wl_block82);
 
			putObjectInBean(bean_id,bean,request); 
			putObjectInBean(or_bean_id,ORbean,request);

            _bw.write(_wl_block83Bytes, _wl_block83);

	if((order_type_flag.equals("Existing") || mode.equals("amend")) && !mfr_yn.equals("Y")){

            _bw.write(_wl_block84Bytes, _wl_block84);

	}

            _bw.write(_wl_block85Bytes, _wl_block85);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdministrationDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfusionRate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Minute(s).label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.OrderQuantity.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.InfuseOver.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Hour(s).label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.ForRepeat.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.hours.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AdminRate.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
