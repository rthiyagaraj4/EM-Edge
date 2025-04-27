package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import com.itextpdf.text.log.SysoLogger;
import java.util.*;
import ePH.*;
import eOR.*;
import ePH.Common.*;
import eOR.Common.*;
import java.sql.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ivprescriptionfluiddetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/IVPrescriptionFluidDetail.jsp", 1743130590647L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n<!-- ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" -->\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<HTML>\n\t<HEAD>\n\t<!-- <LINK REL=\"stylesheet\" TYPE=\"text/css\" HREF=\"../../eCommon/html/IeStyle.css\"></LINK> -->\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'></link>\n\t\t<link rel=\"stylesheet\" type =\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> \n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../../eCommon/js/common.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/DrugNameCommonLookup.js\"></SCRIPT>\n\t\t<SCRIPT LANGUAGE=\"javascript\" SRC=\"../js/IVPrescriptionWithAdditives.js\"></SCRIPT>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script> \n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</HEAD>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<script>\n\n\t\t\tparent.f_iv_drug_details.location.href=\"../../ePH/jsp/IVPrescriptionDrugDetailFrames.jsp?";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\";\n\n\t\t</script>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<BODY onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" > \n\t\t<form name=\"formIVPrescriptionDetails\" id=\"formIVPrescriptionDetails\">\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td class=\"COLUMNHEADER\" colspan=\"8\">\n\t\t\t\t\t\t<font style=\"font-size:9\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n                    <TD CLASS=\"label\" COLSPAN=\"\" NOWRAP WIDTH=\"4%\" ><img style=\"visibility:";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" id=\"fluid_ADR_img\" name=\"fluid_ADR_img\" src=\'../../ePH/images/ADR.gif\' height =\'20\' width =\'20\' title=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' ></img>\n\t\t\t\t\t</TD>\n\t\t\t\t\t<td   width=\'20%\' >\n\t\t\t\t\t\t<SELECT name=\"fluid\" id=\"fluid\" onchange=\"changeFluid(\'this\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\')\"  ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="> <!-- \'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' added for AAKH-CRF-0094 -->\n\t\t\t\t\t\t\t<option value=\"\" >----------";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="----------</option>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' selected>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</option>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t\t\t  </SELECT>\n\t\t\t\t\t\t<img id=\"img1\" style=\"visibility:visible\" src=\"../../eCommon/images/mandatory.gif\" ></img>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<img id=\"edl_info\" style=\"visibility:visible;cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(fluid.value);\">\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t\t<img id=\"edl_info\" style=\"visibility:hidden;cursor:pointer;filter:Chroma(Color=#FFFFFF)\" src=\"../../ePH/images/FD-ICON-rollOverInformationIcon.gif\" height=20  width=20 onClick=\"openEDLDetails(fluid.value);\">\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t</td>\n\t\t\t\t\t<td class=\"label\" width=\'16%\' style=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' id=\"tdVolumePerUnit\">\n\t\t\t\t\t\t<label id=\"volumePerUnit_leg\">";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="/";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</label>&nbsp;\n\t\t\t\t\t\t<input type=\"text\" name=\"volumePerUnit\" id=\"volumePerUnit\" size=\"3\" class=\"NUMBER\" readOnly>&nbsp;\n\t\t\t\t\t\t<label id=\"volPerUnitUom_leg\" class=\"label\" style=\"font-size:9px;\"></label>\n\t\t\t\t\t</td>\n\t\t\t\t\t<td   width=\'10%\' class=\"label\" ><label style=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="&nbsp;</label>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =": </td>\n\t\t\t\t\t<input type=\"hidden\" name=\"stock_uom_code\" id=\"stock_uom_code\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" >\n\n";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 start -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<td class=\'label\' width=\'15%\'><input type=\"text\" maxlength=\"5\" size=\"5\" style=\"text-align:right\" name=\"stock_value\" id=\"stock_value\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" onblur=\"setStockValue(this)\" onKeyPress=\"return allowValidNumber(this,event,5,0);\"  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" disabled> &nbsp;<label id=\'stock_display\' name=\'stock_display\' ><b> ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</b></label></td>\n\t\t\t\t\t\t\t \n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t\t\t\t<td class=\'label\' width=\'15%\'><input type=\"text\" maxlength=\"5\" size=\"5\" style=\"text-align:right\" name=\"stock_value\" id=\"stock_value\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =" > &nbsp;<label id=\'stock_display\' ><b> ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</b></label></td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end-->\n\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" onblur=\"setStockValue(this)\" onKeyPress=\"return allowValidNumber(this,event,5,0);\" ";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" disabled> &nbsp;<label id=\'stock_display\' ><b> ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</b></label></td>\n\t\t\t\t\t\t\t ";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end-->\n\t\t\t\t\t\t\t\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\t\t\t\t<!-- Added for AAKH-CRF-0094 start -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</b></label></td>\n\t\t\t\t\t\t \n\t\t\t\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t<!-- Added for AAKH-CRF-0094 end-->\n";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t\t\t\t\t<td class=\'label\' width=\'10%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="&nbsp;<input type=\"checkbox\" name=\"admixture\" id=\"admixture\" ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="  onClick=\"setAdmixtureValue(formIVPrescriptionDetails),checkadmixture(formIVPrescriptionDetails)\" ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="></td>\n";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" onClick=\"setAdmixtureValue(formIVPrescriptionDetails)\" ></td>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t<td class=\'label\' width=\'10%\' nowrap>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="&nbsp;\n\t\t\t\t\t\t<!-- RUT-CRF-0062 [IN029600]-- Added buildMAR_enable flag to enable/disable based on Build MAR Rule -->\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="   ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="  onclick=\'assignValue(this);\'></td>\n";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t<td class=\'label\'width=\'10%\' nowrap>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="&nbsp;\n\t\t\t\t\t\t<input type=\'checkbox\' name=\'buildMAR_yn\' id=\'buildMAR_yn\' value=\'N\' disabled>\n\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t<td class=\'label\'>\t\t\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\n\t\t\t\t\t<a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"javascript:showMultipleFlowRate(\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\',\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');\" id=\'mfrLink\'>&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</a> <!-- Modified for TFS-13907 -->\n";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t\t<img src=\"../../eCommon/images/enabled.gif\"  id=\'MFR_Indicator\'>\n";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t\t\t\t<img src=\"../../eCommon/images/disabled.gif\"  id=\'MFR_Indicator\'>\n";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t<a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMultipleFlowRate(\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\');\" id=\'mfrLink\' >&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</a>\n\t\t\t\t\t\t<img src=\"../../eCommon/images/enabled.gif\"  id=\'MFR_Indicator\'>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t<br><a href=\"#\"  onMouseOver=\"changeCursor(this);\" onClick=\"showMFRRemarks();\" id=\'mfrRemarksLink\' style=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" >&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</a>\n\t\t\t</td></tr> \n\t\t\t</table>\n\t\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t\t<input type=\"hidden\" name=\"form_code\" id=\"form_code\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t<input type=\"hidden\" name=\"route_code\" id=\"route_code\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t\t<input type=\"hidden\" name=\"base_uom\" id=\"base_uom\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"eqvl_uom_value\" id=\"eqvl_uom_value\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"ORDER_TYPE_CODE\" id=\"ORDER_TYPE_CODE\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t\t<input type=\"hidden\" name=\"STOCK_VALUE\" id=\"STOCK_VALUE\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t\t<input type=\"hidden\" name=\"DRUG_VOLUME\" id=\"DRUG_VOLUME\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"STOCK_UOM_CODE\" id=\"STOCK_UOM_CODE\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t\t<input type=\"hidden\" name=\"BASE_VOLUME\" id=\"BASE_VOLUME\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_type_flag1\" id=\"order_type_flag1\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_set_code\" id=\"order_set_code\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t\t<input type=\"hidden\" name=\"mfr_yn\" id=\"mfr_yn\" value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\'>\n\t\t\t<input type=\"hidden\" name=\"mfr_remarks\" id=\"mfr_remarks\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t\t\t<input type=\"hidden\" name=\"back_date\" id=\"back_date\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"future_date\" id=\"future_date\"\t\tvalue=\"\">\n\t\t\t<input type=\"hidden\" name=\"volume_reference\" id=\"volume_reference\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"><!-- Added for AAKH-CRF-0094 -->\n                        <input type=\"hidden\" name=\"param_volume_cal\" id=\"param_volume_cal\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\"><!-- Added for AAKH-CRF-0094 -->\n                         <input type=\"hidden\" name=\"ext_disp_appl_yn\" id=\"ext_disp_appl_yn\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\"><!-- added for nmc-jd-crf-0046 -->\n";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t\t\t<input type=\"hidden\"\tname=\"alert_practitioner_yn\" id=\"alert_practitioner_yn\"\tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t\t</FORM>\n";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t</body>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t<script>document.formIVPrescriptionDetails.img1.style.visibility=\"hidden\";</script>\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t<script>\n\t\t\tvar bean_id\t\t\t= document.getElementById(\"bean_id\").value;\n\t\t\tvar bean_name\t\t= document.getElementById(\"bean_name\").value;\n\t\t\tvar qryString\t\t= bean_id+\"&bean_name=\"+bean_name+\"&validate=STOCKDETAILS&drug_code=";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="&mode=";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="&order_set_code=";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\";\n\t\t\tsetTimeout(\"submitXML(qryString, \\\"\\\")\",1000);\n\n\t\t</script>\n ";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n </HTML>\n\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
--------------------------------------------------------------------------------------------------------------
Date			Edit History		Name		Rev.Date		Rev.Name				Description
--------------------------------------------------------------------------------------------------------------
05/09/2019      IN070451		   B Haribabu   06/09/2019     Manickam                 ML-MMOH-CRF-1408
04/06/2020      IN072753           Prabha											   NMC-JD-CRF-0046
12/02/2021      TFS-13907     	   Prabha 		12/02/2021     Manickam           	   PH-eCommon label issue in various transactions
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
		String locale			= (String)session.getAttribute("LOCALE");
		//
		String facility_id				=(String)session.getValue("facility_id");
		String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);



boolean site_MFR_greater_than_24hr = false;//added start for ML-MMOH-CRF-1222
Connection con = null;
try{

		  con	= ConnectionManager.getConnection(request);
		 site_MFR_greater_than_24hr = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","MFR_GREATER_THAN_24H");

}catch(Exception e) {
			out.print("Exception @ Result JSP :"+e.toString());
			e.printStackTrace();
}
finally{
	if(con != null)
		ConnectionManager.returnConnection(con,request);
}


	String buildMAR_yn		= "";
	String MAR_app_yn		= "";
	String buildMAR_checked	= "";
	// RUT-CRF-0062 [IN029600] To build -- begin 
	String buildMAR_rule	= "";  
	String buildMAR_enable	= "";
	// RUT-CRF-0062 [IN029600] -- end
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
	String buildMAR_enable	= "";
		 SRR20056-CRF-0649.1 */
	String params			= request.getQueryString();
	String adr_count		= request.getParameter("adr_count") == null ? "0":request.getParameter("adr_count");
	String patient_id		= request.getParameter("patient_id");
	String encounter_id 	= request.getParameter("encounter_id");
	String patient_class	= request.getParameter("act_patient_class");
	String iv_option		= request.getParameter("iv_option") == null ? "":request.getParameter("iv_option");
	String iv_prep_yn		= request.getParameter("iv_prep_yn") == null ? "":request.getParameter("iv_prep_yn");
 	String order_type_flag	= request.getParameter("order_type_flag") == null ? "":request.getParameter("order_type_flag");
	String order_set_code	= request.getParameter("order_set_code") == null ? "":request.getParameter("order_set_code");
	String weight= request.getParameter("weight") == null ? "":request.getParameter("weight");//Added for IN:070451
	String bsa= request.getParameter("bsa") == null ? "":request.getParameter("bsa");//Added for IN:070451
	ArrayList orderSetCodes	= new ArrayList();
	HashMap   orderSetFluid = new HashMap();
	String iv_prep_default	= request.getParameter("iv_prep_default") == null ? "":request.getParameter("iv_prep_default");

	MAR_app_yn = request.getParameter("MAR_app_yn")==null?"":request.getParameter("MAR_app_yn");
	buildMAR_yn = MAR_app_yn;

	//RUT-CRF-0062 [IN029600] Commented to display Build MAR field based on Build MAR Rule -- begin
	/*if(MAR_app_yn.equals("Y")){
		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
		if(patient_class.equals("IP"))
			buildMAR_enable  =	"disabled";
		 SRR20056-CRF-0649.1 
		if(buildMAR_yn.equals("Y"))
		buildMAR_checked =	"Checked";
	}
	*/
	//RUT-CRF-0062 [IN029600] -- end

	String form_code			=	"";
	String route_code			=	"";
	String order_type_code		=	"";
	String Disabled				=	"";
	String checkVal				=   "";
	String admix_value			=   "";
	String CATALOG_DESC			=   "";
	String ORDER_CATALOG_CODE   =   "";
	String fluid_code			=   "";
	String stock_value			=   "";
	String stock_uom_code		=   "";
	String time_flag            =   ""; 
	String disable_addmixture	=   "";
	String alert_practitioner_yn=   "";
	String chk_addmixture       =   ""; 
	String base_volume			=   "";	
    String fluid_adr_display    =   "hidden";
	String mfr_display			=	"hidden";
	String read					=	"";
	String mfr_remarks			=	"";
	String remarksDisplay		=	"display:none";
	String ext_disp_appl_yn = "";   //added for nmc-jd-crf-0046
	ArrayList exstngIVOrders	= new ArrayList();
	HashMap   record			= new HashMap();

	String or_bean_id		= "@orderentrybean"+patient_id+encounter_id;
	String or_bean_name		= "eOR.OrderEntryBean";
	OrderEntryBean ORbean	= (OrderEntryBean)getBeanObject(or_bean_id,or_bean_name,request) ;
	
	String order_id			= (String)ORbean.getOrderId();
	String bean_id			= "@IVPrescriptionBean"+patient_id+encounter_id;
	String bean_name		= "ePH.IVPrescriptionBean";
	IVPrescriptionBean bean	= (IVPrescriptionBean)getBeanObject(bean_id,bean_name,request) ;

	bean.setLanguageId(locale);
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
	if(iv_prep_default.equals("1") || iv_prep_default.equals("2")){
		
		if(!order_set_code.equals("")) 
			orderSetCodes = bean.getOrdersetCodes(order_set_code);
		if((orderSetCodes.size() != 0) &&(bean.getFluidCompatibility().equals("Y"))) {
			orderSetFluid = bean.getOrderSetDrugs((String)orderSetCodes.get(0)); 
			ArrayList orderSetValues	= bean.getOrderSetValues();
			String	sReqRnot			= "";
			fluid_code					= (String)orderSetFluid.get("drug_code");
			CATALOG_DESC				= (String)orderSetFluid.get("drug_desc");
			bean.setFluidDetails(fluid_code,"","","",""); // CRF-0062 NEWLY ADDED

			if(orderSetValues.get(0).equals(fluid_code)){
				stock_value				= (String)orderSetValues.get(1);		
				sReqRnot				= (String)orderSetValues.get(6);
			}
			if(sReqRnot.equals("R")) 
				Disabled = "disabled";
		} 
	}
System.err.println("====135======stock_value========>"+stock_value);
	bean.setPatId(patient_id);
	bean.setEncId(encounter_id);
	
	//Start of NMC-JD-CRF-0046
	String  disp_loc = (String)bean.getDisp_locn_code();
	ext_disp_appl_yn = bean.getExtDispYN(disp_loc);

    //End of NMC-JD-CRF-0046
   
    
	if(iv_prep_yn.equals("1")){
		checkVal="unchecked";
		admix_value = "N";
	}
	else if(iv_prep_yn.equals("2")){
		checkVal="checked";
		admix_value = "Y";
	}
	else checkVal="";
	String mode = request.getParameter("mode");
		if(mode == null) mode="";
	if(order_type_flag.equals("Existing") || (mode.equals("amend"))){
		Disabled = "disabled";
  
		exstngIVOrders		= bean.getAllExistingIVOrders();
		record				= (HashMap)exstngIVOrders.get(0);
		CATALOG_DESC		= (String)record.get("CATALOG_DESC");
		ORDER_CATALOG_CODE	= (String)record.get("ORDER_CATALOG_CODE");
		mfr_remarks			= (String)record.get("MFR_REMARKS");
		fluid_code			= ORDER_CATALOG_CODE;
		bean.setFluidDetails(ORDER_CATALOG_CODE,"","","",""); // CRF-0062 NEWLY ADDED
		if (bean.checkForStock()) {
			ArrayList stockDetails = bean.getStockDetails(ORDER_CATALOG_CODE, "1");
			if (stockDetails.size() != 0){
				stock_value    = (String)stockDetails.get(0);
				stock_uom_code = (String)stockDetails.get(1);
				base_volume    = stock_value;
			}
		}
		stock_value     = (String)record.get("QTY_VALUE");
		order_type_code	= bean.getOrderType(ORDER_CATALOG_CODE);
		bean.setPatientClass(patient_class);
		HashMap MFRRecs = new HashMap();
		MFRRecs         = bean.getMFRRecs();
		bean.clear();
		bean.setMFRRecs(MFRRecs);
		if(MFRRecs != null && MFRRecs.size()>0){
			bean.setMFRYN("Y");
			mfr_display = "";
			
		}
		bean.setPatId(patient_id);
		bean.setEncId(encounter_id);
		for(int i=1;i<exstngIVOrders.size();i++){
			bean.setPatientClass(patient_class);
			record					= (HashMap)exstngIVOrders.get(i);
			ORDER_CATALOG_CODE		= (String)record.get("ORDER_CATALOG_CODE");
			bean.setWeight(weight);//Added for IN:070451
			bean.setBSA(bsa);//Added for IN:070451
			bean.setDrugDetails(ORDER_CATALOG_CODE,ORbean.getPractitionerId(),ORbean.getResponsibilityId(),"","","","");  //CRF-0062 // Added getPractitionerId and getResponsibilityId for ML-MMOH-CRF-0343 [IN:057182]
			bean.setIVPB("N");
		}
		//added for SRR20056-SCF-7882 -29157 - start
		/*if(record.get("BUILD_MAR_YN")==null){
			record.put("BUILD_MAR_YN",MAR_app_yn);
		}*/
		buildMAR_yn		= (String) record.get("BUILD_MAR_YN");
		// RUT-CRF-0062 [IN029600] Added to get the Build MAR Rule -- begin
		buildMAR_rule = record.get("BUILD_MAR_RULE").toString();
		/*if(MAR_app_yn.equals("Y")){
			if(buildMAR_yn !=null && buildMAR_yn.equals("Y"))
				buildMAR_checked ="Checked";
			else
				buildMAR_checked="";
		//}
		//added for SRR20056-SCF-7882 -29157 - End */
		// Disable property will be loaded based on Buil MAR Rule , Checked Property will be loaded based on Existing value
		
		if(buildMAR_yn !=null && buildMAR_yn.equals("Y"))
			buildMAR_checked ="Checked";
		else
			buildMAR_checked="";
		buildMAR_rule=buildMAR_rule==null?"":buildMAR_rule;  
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
			buildMAR_yn="N";
		}
		bean.setBuildMAR_yn(buildMAR_yn);// RUT-CRF-0062 [IN029600] Added to get the Build MAR Rule -- end
	}
	else {
		String resetYN = request.getParameter("reset")==null?"": request.getParameter("reset");
		HashMap hm_fluid_details = null;

		if(!resetYN.equals("Y")){
			if(bean.getAmendFluidDetails()==null || (bean.getAmendFluidDetails()).size()==0){
				bean.loadAmendDetails(order_id, patient_id,"");// RUT-CRF-0062 
			}
		}
		hm_fluid_details = bean.getAmendFluidDetails();
		bean.setPatientClass(patient_class);
		if(hm_fluid_details != null){
			if(hm_fluid_details.size()>0){
				fluid_code		= (String)hm_fluid_details.get("DRUG_CODE");
				order_type_code = (String)hm_fluid_details.get("ORDER_TYPE_CODE");
				if(hm_fluid_details.get("BUILD_MAR_YN")==null){
					hm_fluid_details.put("BUILD_MAR_YN",MAR_app_yn);
				}
				buildMAR_yn		= (String) hm_fluid_details.get("BUILD_MAR_YN");
				buildMAR_rule = hm_fluid_details.get("BUILD_MAR_RULE").toString(); // RUT-CRF-0062 [IN029600]-- Added to get the Build MAR Rule value

		/* Commented for SRR20056-CRF-0649.1 to (deselect)enable BuildMAR fo rIP
				if(MAR_app_yn.equals("Y")){
					if(patient_class.equals("IP"))
						buildMAR_enable ="disabled";
		 SRR20056-CRF-0649.1 */
		 /* RUT-CRF-0062 [IN029600] Added / Commented to set the Build MAR value based on Build MAR Rule-- begin
					if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
						buildMAR_checked ="Checked";
					else
						buildMAR_checked="";
		*/
			// Disable property will be loaded based on Buil MAR Rule , Checked Property will be loaded based on Existing value
				if(buildMAR_yn!=null && buildMAR_yn.equals("Y"))
					buildMAR_checked ="Checked";
				else
					buildMAR_checked="";
					
				buildMAR_rule=(buildMAR_rule==null)?"":buildMAR_rule;
				
	
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
				if(ext_disp_appl_yn.equals("Y"))  //Added for NMC-JD-CRF-0046
				{
					buildMAR_enable="disabled";
				        buildMAR_checked="";
				}
				bean.setBuildMAR_yn(buildMAR_yn);// RUT-CRF-0062 [IN029600]-- Added to get the Build MAR Rule value	-- end
				//}
			}
		}
	}	
    if( Integer.parseInt(adr_count)>0){
		int fluid_adr_count = bean.getADRCount(patient_id,fluid_code);
		if(fluid_adr_count>0)
			fluid_adr_display ="visible";
	}
	bean.setIVPB("N");
	bean.setIVType("IVD");
	HashMap record1;
 /******************************************************************************************
	  New Enhancement for malasiya :Code for validating IVADMIXTURE APPLICAPABLE and FROM_TIME and 
	                TO_TIME in PHPARAMETER FOR FACILITY UNDER IVADMIXTURE TAB starts 
	  date:11/22/2004
	*****************************************************************************************/
	//if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){   
	record1					=	new HashMap(); 
	record1					=	bean.ChkAdMixture();
	chk_addmixture			=	(String)record1.get("IV_ADMIXTURE_APPL_YN");
	alert_practitioner_yn	=	(String)record1.get("ALERT_PRACTITIONER_YN");

	if(chk_addmixture.equals("N") || mfr_display.equals(""))
	   disable_addmixture	=	"Disabled";		    
	else{
	   disable_addmixture	=	"";
	}
	if(order_type_flag.equals("Existing")){

            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(params));
            _bw.write(_wl_block12Bytes, _wl_block12);

	} 

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(fluid_adr_display));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(param_volume_cal));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(Disabled));
            _bw.write(_wl_block18Bytes, _wl_block18);
//=param_volume_cal
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

							if(order_type_flag.equals("Existing") || (mode.equals("amend"))){

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(CATALOG_DESC));
            _bw.write(_wl_block23Bytes, _wl_block23);

							}

            _bw.write(_wl_block24Bytes, _wl_block24);
					
						if(fluid_code != null && !fluid_code.equals("")){
            _bw.write(_wl_block25Bytes, _wl_block25);
						
						}
						else{

            _bw.write(_wl_block26Bytes, _wl_block26);
						
						}

            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(iv_calc_infuse_display));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(stock_uom_code));
            _bw.write(_wl_block34Bytes, _wl_block34);
					if(!mfr_display.equals("hidden")) {
						read = "readonly";
						checkVal = "disabled";
						remarksDisplay="";
					}
					else{
						read = "";
					}
					if (bean.checkForStock()) {
						if (iv_option.equals("Y")) {

            _bw.write(_wl_block35Bytes, _wl_block35);
	if(param_volume_cal.equals("N")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(read));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block39Bytes, _wl_block39);
	}  
							else{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(read));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
            _bw.write(_wl_block43Bytes, _wl_block43);

						}
						else {

            _bw.write(_wl_block35Bytes, _wl_block35);
	if(param_volume_cal.equals("N")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(read));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block46Bytes, _wl_block46);
	}  
							else{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(read));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
            _bw.write(_wl_block47Bytes, _wl_block47);

						}
					}
					else {

            _bw.write(_wl_block48Bytes, _wl_block48);
	if(param_volume_cal.equals("N")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(read));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block49Bytes, _wl_block49);
	}  
							else{
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(read));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getUomDisplay((String)session.getValue("facility_id"),stock_uom_code)));
            _bw.write(_wl_block42Bytes, _wl_block42);
} 
            _bw.write(_wl_block50Bytes, _wl_block50);

					}

            _bw.write(_wl_block51Bytes, _wl_block51);

					if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){

            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(checkVal));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(disable_addmixture));
            _bw.write(_wl_block55Bytes, _wl_block55);

					}
					else{

            _bw.write(_wl_block52Bytes, _wl_block52);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(checkVal));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(admix_value));
            _bw.write(_wl_block57Bytes, _wl_block57);
					
					}
					if(MAR_app_yn.equals("Y")){
						if(!ext_disp_appl_yn.equals("")){ //Added For NMC-JD-CRF_0046

            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(buildMAR_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(buildMAR_checked));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(buildMAR_enable));
            _bw.write(_wl_block62Bytes, _wl_block62);

					         	}
				}
					 
					else{

            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);

					}

            _bw.write(_wl_block65Bytes, _wl_block65);
				
				if(!mode.equals("amend") ){

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(site_MFR_greater_than_24hr));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

					if(mfr_display.equals("")){

            _bw.write(_wl_block70Bytes, _wl_block70);
					
					}
					else{

            _bw.write(_wl_block71Bytes, _wl_block71);
					
					}
				}
				else{
					if(mfr_display.equals("")){

            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(patient_id ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(encounter_id ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(site_MFR_greater_than_24hr));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
					
					}
					else{

            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

					}
				}				

            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(remarksDisplay));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(form_code));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(route_code));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(order_type_code));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( bean_id ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( patient_id ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( encounter_id ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(stock_uom_code));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(base_volume));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( order_type_flag ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( order_set_code ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( locale ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(read.equals("")?"N":"Y"));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(mfr_remarks));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(stock_value));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(param_volume_cal));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(ext_disp_appl_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);

			if(!order_type_flag.equals("Existing")&& !mode.equals("amend")){

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(alert_practitioner_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);

			}

            _bw.write(_wl_block100Bytes, _wl_block100);
 
		putObjectInBean(bean_id,bean,request); 
		putObjectInBean(or_bean_id,ORbean,request);

            _bw.write(_wl_block101Bytes, _wl_block101);

	if(mode.equals("amend")){

            _bw.write(_wl_block102Bytes, _wl_block102);

	}
	if(fluid_code!=null && !fluid_code.equals("")){

            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(fluid_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(order_set_code));
            _bw.write(_wl_block106Bytes, _wl_block106);

	}
 
            _bw.write(_wl_block107Bytes, _wl_block107);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Fluid.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Select.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Unit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.total.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.volume.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IVAdmixture.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.IVAdmixture.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BuildMAR.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MultipleFlowRate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.MFRRemarks.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
