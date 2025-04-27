package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.sql.*;
import java.text.*;
import java.util.*;

public final class __transferdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/TransferDetails.jsp", 1742461415276L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<script language =\'javascript\' src=\'../../eIP/js/BedBookingTransfer.js\'></script>\t\n<!--<script language =\'javascript\' src=\'../../eIP/js/PatientEmergencyTransfer.js\'></script>\t-->\n<script language =\'javascript\' src=\'../../eIP/js/IPPractitionerComponent.js\'></script>\t\n<script language =\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<script>\n\n</script>\n<table border=0 width=\"100%\"  cellspacing=0>\t\n\t\t\t<tr>\n\t\t\n       <th  class=\'columnheader\' align=center colspan=\'2\'>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</th>\n\t\t<th   class=\'columnheader\' align=center colspan=\'2\'>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</th>\n\t\n\t</tr>\n\t\n\t<tr>\n\t\t<td colspan=4 class=\'CAGROUP\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t</tr> \n\t<tr>\n\t\t<td class=\"label\" width=\'25%\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td  class=\'querydata\' width=\'25%\' >";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t<input type=\"hidden\" name=\"fr_nursing_unit_code\" id=\"fr_nursing_unit_code\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t<input type=\"hidden\" name=\"fr_nursing_unit_desc\" id=\"fr_nursing_unit_desc\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t\t</td>\n\t\t<td class=\'label\' width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t<!--//Maheshwaran included confirm_request condition for GHL-CRF-0362-->\n\t\t<td nowrap class=\'fields\' width=\'25%\'><input type=text  name=\"nursing_unit_desc\" id=\"nursing_unit_desc\"   value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" maxlength=15 size=15  ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="onblur=\"beforeGetNursingUnit(\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\',\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\');CheckNursingUnit();";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" enbldisbchk_tfrDtls(this);";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" ><input type=button class=button name=nursing_unit_lookup id=nursing_unit_lookup value=\'?\' onClick=\"NursingUnitLookup(\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\');\" >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\">\n\t\t<input type=hidden name=\"nurs_desc_hid\" id=\"nurs_desc_hid\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t\t<input type=hidden name=\"nursing_unit\" id=\"nursing_unit\"   value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t\t<input type=hidden name=\"additional_locale\" id=\"additional_locale\"   value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t</td>\n\t\n</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t<td  class=\'querydata\' >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_service_code\" id=\"fr_service_code\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n\t\t\t\t<input type=\"hidden\" name=\"fr_service_desc\" id=\"fr_service_desc\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t\t\t</td>\n\t\t\t\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t\t<td class=\'fields\'><select name=\"service\" id=\"service\"  onChange=\'PopulateSubService()\'>\n\t\t\t<option value=\"\">-----&nbsp;";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="&nbsp;-----</option>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t</select><img src=\"../../eCommon/images/mandatory.gif\">\n\t\t\t</td>\n\n\t\t</tr>\n\t\t\n\t\t<tr>\n\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t<td  class=\'querydata\' >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<input type=\"hidden\" name=\"fr_subservice_code\" id=\"fr_subservice_code\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t\t\t<input type=\"hidden\" name=\"fr_subservice_desc\" id=\"fr_subservice_desc\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t\t</td>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\n\t\t\t<td class=\'fields\'><select name=\"sub_service\" id=\"sub_service\"><option value=\"\">-----&nbsp;";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t</select>\n\t\t\t</td>\n\t\t\t\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n\t\t\t\t<td  class=\'querydata\'  >";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t\t<td class=\"label\" >&nbsp;</td>\n\t\t\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'bed_change\' id=\'bed_change\'  onClick=\"setEnable_tfrDtls();\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" disabled ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =">\n\t\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</td>\n\t\t\t<td class=\'querydata\'  >";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_bed_class\" id=\"fr_bed_class\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" >\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</td>\n\t\t\t\t<td class=\'fields\'><input type=\'checkbox\' name=\'bed_change\' id=\'bed_change\'  onClick=\"setEnable_tfrDtls();\"  disabled>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\t\n\n\t\t\t<td  class=\'fields\'>\n\t\t\t\t<select name=\'Bedcode\' id=\'Bedcode\' onChange=\'getBedtype_tfrDtls();\'  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =">\n\t\t\t\t\t<option value=\"\">-----&nbsp;";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="&nbsp;-----</option>\n\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="<option value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" selected>";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</option>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t</select>\n\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img >\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<input type=\"hidden\" name=\"hid_bed_class\" id=\"hid_bed_class\" ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"  disabled ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="   value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" >";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\n<input type=\"hidden\" name=\"hid_bed_class_descn\" id=\"hid_bed_class_descn\" ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" >\n\n\t</td>\n\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\n\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</td>\n\t\t\t<td class=\'querydata\'  >\n\t\t\t\t<input type=\"hidden\" name=\"fr_bed_type\" id=\"fr_bed_type\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\n\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="><option value=\"\">-----&nbsp;";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="&nbsp;-----</option>\n\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n\t</select>\n\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" >\n\n\t</td>\n";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td>\n\t\t\t<td class=\'fields\'>\n\t\t\t<select name=\'bed_type_code\' id=\'bed_type_code\' onChange=\'ChangeBedtype_tfrDtls();\' ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t\t<option value=\"\" >-----&nbsp;";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t</select>\n\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t<img align=\"center\" id=\'\'  src=\"../../eCommon/images/mandatory.gif\"></img>\n\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t<input type=\"hidden\" name=\"hid_bed_type\" id=\"hid_bed_type\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" >\n\t\t\t<input type=\"hidden\" name=\"hid_tobedtypedesc\" id=\"hid_tobedtypedesc\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" >\n\t\t\t</td>\n\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</td>\n\t\t\t<td class=\'querydata\'  ><input type=\"hidden\" name=\"fr_bed_no\" id=\"fr_bed_no\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t<td class=\'fields\'><select name=\'bed_type_code\' id=\'bed_type_code\' onChange=\'ChangeBedtype_tfrDtls();\' ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="><option value=\"\" >-----&nbsp;";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="&nbsp;-----</option>\n\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</select>\n\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n\t<input type=\"hidden\" name=\"hid_bed_type\" id=\"hid_bed_type\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t\t<input type=\"hidden\" name=\"hid_tobedtypedesc\" id=\"hid_tobedtypedesc\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t\t\t<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</td>\n\t\t\t<td class=\'fields\'><input type=\"text\" name=\"to_bed_no\" id=\"to_bed_no\"  value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" size=8 maxlength=8 onBlur=\"ChangeUpperCase(this);getRoomNo_tfrDtls(this);";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="chkforVacantNormalBed();";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" onKeyPress=\'return CheckForSpecChars(event)\' onchange=\'clearRoom();\' readOnly><input type=\"button\" class=\"button\" value=\"?\" id=\'bedlookkup\' name=\"bed_avail_chart\" id=\"bed_avail_chart\" ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="onblur=\"chkforVacantNormalBed()\" ";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =" onclick=\"callBedAvailChart_tfrDtls();\" ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 =">\n\t\t\t";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n\t\t\t\t<img align=\"center\" id=\'bedoimg\'  src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\n\t\t\t<input type=\"hidden\" name=\"hid_tobedno\" id=\"hid_tobedno\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t</td>\n";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t<td class=\'querydata\'  ><input type=\"hidden\" name=\"fr_room_no\" id=\"fr_room_no\"  value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\n<!-- Modified by Sangeetha on 25/05/17 for GDOH-CRF-0151-->\n<td class=\"label\" >";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="  onclick=\"callBedAvailChart_tfrDtls();\" ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="<input type=\"hidden\" name=\"hid_toroomno\" id=\"hid_toroomno\"  value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\"></td>\n\t\t\t<td class=\'fields\'><input type=\"text\" name=\"to_room_no\" id=\"to_room_no\"  value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" size=10 maxlength=10 onBlur=\"specialChar(this,\'Char\')\" readonly = true></td>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\t\n\t\t</tr>\t\t\n\t\t\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_speciality_code\" id=\"fr_speciality_code\" value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t</td>\n\n";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n<td class=\"label\" >";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</td>\n\t\t\t<td class=\'fields\'><input type=text name=\'Splcode_desc\' id=\'Splcode_desc\' maxlength=15 size=15 ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =" onFocus=\"checkForNursing();\" onblur=\"clearVal_tfrDtls(this);BeforeGetSpecialty(this, \'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\');\"  ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="><input type=button name=\'Splcode_lookup\' id=\'Splcode_lookup\'id=\'splid\' value=\'?\' class=button onFocus=\"checkForNursing();\"  onClick=\"checkTxtVal(Splcode_desc, \'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\');\" ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'align=\'center\'></img>\n\t\t\t";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\n\t\t\t</td>\n\n\t\t\t<input type=hidden name=\'Splcode\' id=\'Splcode\'  value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" >\n\t\t\t<input type=hidden name=\"spec_desc_hid\" id=\"spec_desc_hid\" value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="</td>\n\t\t\t<td class=\'querydata\' nowrap id=\"PractDesc\"  >";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\n\t\t\t\t<input type=\"hidden\" name=\"fr_practitioner_id\" id=\"fr_practitioner_id\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</td>\n\t\t\t<td nowrap class=\'fields\'><input type=\'hidden\' name=\'practid\' id=\'practid\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t\t\t\n\t\t\t\t<input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' size=\'30\' maxlength=\'30\'  ";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="    value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 =" onblur=\"BeforeGetPractitioner(document.forms[0].practid,pract_desc, \'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\');\" onFocus=\"checkForValues();\"  ";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="><input type=\'button\' name=\'pract_id_search\' id=\'pract_id_search\' value=\'?\' id=\'practlookup\' class=\'button\' onClick=\"checkPractTxtVal(document.forms[0].practid,pract_desc, \'";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t<img align=\"center\" src=\"../../eCommon/images/mandatory.gif\"></img>\n\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t<input type=hidden name=\"pract_desc_hid\" id=\"pract_desc_hid\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" >\n\t\t\t<!--//Maheshwaran added for GHL-CRF-0362-->\n\t\t\t<input type=hidden name=\"practid4\" id=\"practid4\" value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" >\n\t\t\t</td>\t\t\t\n\t\t\n";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\t\t\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"label\" >";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="</td>\n\t\t\t<td  class=\'querydata\'  id=\"MedTeamDesc\">";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\n\t\t\t<input type=\"hidden\" name=\"fr_team_id\" id=\"fr_team_id\" value=\"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\">\n\t\t\t\n\t\t\t<input type=\'text\' name=\'pract_desc\' id=\'pract_desc\' size=\'30\' maxlength=\'30\'  ";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" >\n\t\t\t</td>\t\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="<input type=\"hidden\" name=\"selecTeam\" id=\"selecTeam\" value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"></td>\n\t\t<!-- added by raghavendra for confirm bed class... -->\n\t\t\t<td nowrap class=\'fields\'><select name=\"team_id\" id=\"team_id\" ";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =">\n\t\t\t\t\t<option value=\'\' >-----&nbsp;";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="&nbsp;-----</option>\t\t\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\t\t\t\t\t\n\t\t\t\n\t</select></td>\n\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\t\n\t\t</tr>\n";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t<tr>\n\t\t<td>&nbsp;</td>\n\t\t<td>&nbsp;</td>\n\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\t\t\t\t\t\n\t\t\t\n\t</select></td>\n\t</tr>\n";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\n\t\t</table>\n\t <!--below line added for this CRF GHL-CRF-0340 -->     \n\t <input type=\"hidden\" name=\"specialtyCheck\" id=\"specialtyCheck\" value=\"0\">   \n\t <input type=\"hidden\" name=\"practitionerCheck\" id=\"practitionerCheck\" value=\"0\"> \n     <input type=\"hidden\" name=\"request_facilityId\" id=\"request_facilityId\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">   \t \n\t <!--End GHL-CRF-0340 -->\n\t\n\t<input type=\"hidden\" name=\"locale1\" id=\"locale1\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\n\t<input type=\"hidden\" name=\"from_bed_type\" id=\"from_bed_type\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\n\t<input type=\"hidden\" name=\"patient_id2\" id=\"patient_id2\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\t\n\t<input type=\"hidden\" name=\"function_ID\" id=\"function_ID\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\t\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t<input type=\"hidden\" name=\"to_daily_rate\" id=\"to_daily_rate\"  value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t<input type=\"hidden\" name=\"bed_class_allowed\" id=\"bed_class_allowed\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t<input type=\"hidden\" name=\"ipparam_bed_yn\" id=\"ipparam_bed_yn\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t<input type=\"hidden\" name=\"gender\" id=\"gender\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t<input type=\"hidden\" name=\"tfr_type\" id=\"tfr_type\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t<input type=\"hidden\" name=\"pseudo_bed_yn\" id=\"pseudo_bed_yn\" value=\"\">\n\t<input type=\"hidden\" name=\"deactivate_pseudo_bed_yn\" id=\"deactivate_pseudo_bed_yn\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t<input type=\"hidden\" name=\"admissiondate\" id=\"admissiondate\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\n\t<input type=\"hidden\" name=\"bed_blocking_period\" id=\"bed_blocking_period\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\">\n\t<input type=\"hidden\" name=\"bed_block_remarks\" id=\"bed_block_remarks\" value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\">\n\t<input type=\"hidden\" name=\"blocking_type_code\" id=\"blocking_type_code\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\">\n\t<input type=\"hidden\" name=\"mother_bed_status\" id=\"mother_bed_status\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\">\n\t<input type=\"hidden\" name=\"override_yn\" id=\"override_yn\" value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\">\t\n\t";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\t\n\t\n\t\t<script>\n\t\tvar count=0\n\t\t\tif(count==0)\n\t\t\t{\n\t\t\t\t\n\t\t\t}\n\t\t//Added by Kishore on 9/7/2004\n\t\t";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\n\t\t\tdocument.forms[0].Bedcode.disabled=true;\n\t\t\tdocument.forms[0].bed_type_code.disabled=true;\n\t\t\tdocument.forms[0].sub_service.disabled=true;\n\t\t\tdocument.forms[0].service.disabled=true;\n\t\t\tdocument.forms[0].team_id.disabled=true;\n\t\t\tdocument.getElementById(\"practlookup\").disabled=true;\n\t\t\tdocument.forms[0].pract_desc.disabled=true;\n\t\t\tdocument.getElementById(\'rejection\').style.visibility\t    =\t\"Hidden\";\n\t\t\tdocument.forms[0].to_bed_no.disabled=true;\n\t\t\tdocument.forms[0].to_room_no.disabled=true;\n\t\t\tdocument.getElementById(\'bedlookkup\').disabled=true;\n\t\t\tdocument.getElementById(\'bedoimg\').style.visibility\t    =\t\"Hidden\";\n\t\t\tdocument.getElementById(\'splid\').disabled=true;\n\t\t\tdocument.forms[0].Splcode_desc.disabled=true;\n\t\t\tdocument.forms[0].nursing_unit_desc.disabled=true;\n\t\t\tdocument.forms[0].nursing_unit_lookup.disabled=true;\n\t\t";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\n\t\t\tdocument.forms[0].to_bed_no.disabled=true;\n\t\t\tdocument.forms[0].to_room_no.disabled=true;\n\t\t\tdocument.getElementById(\'bedlookkup\').disabled=true;\n\t\t\tdocument.getElementById(\'bedoimg\').style.visibility\t    =\t\"Hidden\";\t\n\n\t\t";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\n\t//else if(call_function.equals(\"confirm_request\")||call_function.equals(\"cancel_request\")||call_function.equals(\"confirm_details\")){%>\n\t\t\t";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\n\t\t\tdocument.forms[0].Bedcode.disabled=true;\n\t\t\tdocument.forms[0].bed_type_code.disabled=true;\n\t\t\t";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\n\t\t\tdocument.forms[0].bed_type_code.disabled=true;\n\t\t\tdocument.forms[0].nursing_unit_desc.disabled=true;\n\t\t\tdocument.forms[0].nursing_unit_lookup.disabled=true;\n\t\t\tdocument.forms[0].sub_service.disabled=true;\n\t\t\tdocument.forms[0].service.disabled=true;\n\t\t\tdocument.forms[0].team_id.disabled=true;\n\t\t\tdocument.getElementById(\"practlookup\").disabled=true;\n\t\t\tdocument.forms[0].pract_desc.disabled=true;\n\t\t\tdocument.forms[0].to_room_no.readOnly=true;\n\t\t\t";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\n\t\t\tdocument.forms[0].to_bed_no.disabled=true;\n\t\t\tdocument.getElementById(\'bedlookkup\').disabled=true;\n\t\t\tdocument.getElementById(\'bedoimg\').style.visibility\t    =\t\"Hidden\";\n\t\t\t";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\t\t\tdocument.getElementById(\'splid\').disabled=true;\n\t\t\tdocument.forms[0].Splcode_desc.disabled=true;;\n\t\t";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\tdocument.forms[0].nursing_unit_desc.readOnly=true;\n\t\t";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\n\t\t\t/*document.forms[0].to_bed_no.disabled=true;\n\t\t\tdocument.forms[0].to_room_no.disabled=true;\n\t\t\tdocument.getElementById(\'bedlookkup\').disabled=true;\n\t\t\tdocument.getElementById(\'bedoimg\').style.visibility\t    =\t\"Hidden\";\t\n\t\t\t*/\n\t\t";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\n\t\tdocument.forms[0].Bedcode.disabled=false;\n\t\tdocument.forms[0].bed_type_code.disabled=false;\n\t\t";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t</script>\n\t";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\n</html>\n\n";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\n\n\n";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	?	defaultValue	:	inputString;
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
	String locale				= (String)session.getAttribute("LOCALE");
	
	Connection con			= null;
	Statement stmt			= null;
	PreparedStatement pstmt	= null;
	ResultSet rset			= null;
	StringBuffer StrBuf		= new StringBuffer();
	String topractitionerid	= "";
	String topractdesc		= "";
	String tospecialitycode	= "";
	String tospecialitydesc	= "";
	String tobedclass		= "";
	String tonursingunitcode= "";
	String tonursingunitdesc= "";
	String tobedno			= "";
	String toroomno			= "";
	String tobedtype		= "";
	String tobedtypedesc	= "";
	String tobedclassdesc	= "";
	int    frdailycharge	= 0;
	String medcode 			= "";
	String meddesc 			= "";
	String toteamid 		= "";
	String toservicecode	= "";
	String tosubservcode	= "";
	String subsel			= "";
	String eid				="";
	String patientid		="";
	int BED_BLOCK_PERIOD_MAX=0;
	String TRN_TYPE			="";
	String blocking_period	="";
	String blocking_remark	="";
	String blocking_type_code="";
	String mother_bed_status="";
	String overrideyn		="N";
	String isreadonly		= "";
	String isenable			= "";  
	
	String res_reserve_bed_intraward_yn="N"; //Added for this CRF GHL-CRF-0340
	HashMap ResultParamHashMap = new HashMap();	

	String loginUser				= checkForNull((String)session.getValue("login_user"));
	String facilityId				= checkForNull((String)session.getValue("facility_id"));
	patientid						= checkForNull((String)session.getValue("patientid"));
	String call_function			= checkForNull(request.getParameter("call_function"));
	String admissiondate			= checkForNull(request.getParameter("admission_date"));
	String frpractitionerid			= checkForNull(request.getParameter("frpractitionerid")); 
	String frpractdesc				= checkForNull(request.getParameter("frpractdesc"));
	String frspecialitycode			= checkForNull(request.getParameter("frspecialitycode"));   
	String frspecialitydesc			= checkForNull(request.getParameter("frspecialitydesc"));
	String frbedclass				= checkForNull(request.getParameter("frbedclass"));  
	String frbedclassdesc			= checkForNull(request.getParameter("frbedclassdesc")); 
	String frnursingunitcode	 	= checkForNull(request.getParameter("frnursingunitcode")); 
	String frnursingunitdesc	 	= checkForNull(request.getParameter("frnursingunitdesc")); 
	String frbedno					= checkForNull(request.getParameter("frbedno"));      
	String frroomno					= checkForNull(request.getParameter("frroomno"));
	String frbedtype				= checkForNull(request.getParameter("frbedtype")); 
	String frbedtypedesc			= checkForNull(request.getParameter("frbedtypedesc"));
	String frdailychargeStr			= checkForNull(request.getParameter("frdailycharge"));
	String age						= checkForNull(request.getParameter("age"));
	String gender					= checkForNull(request.getParameter("gender"));
	String frservicecode			= checkForNull(request.getParameter("frservicecode"));
	String frservicedesc			= checkForNull(request.getParameter("frservicedesc"));
	String frsubservcode			= checkForNull(request.getParameter("frsubservcode"));
	String frsubservdesc			= checkForNull(request.getParameter("frsubservdesc"));
	String patient_class			= checkForNull(request.getParameter("patient_class"));
	String frmeddesc				= checkForNull(request.getParameter("frmeddesc"));
	String frmedid					= checkForNull(request.getParameter("frmedid"));
	String BED_BLOCK_PERIOD_MAXS	= checkForNull(request.getParameter("BED_BLOCK_PERIOD_MAX"));
	String max_blk_type				= checkForNull(request.getParameter("max_blk_type"));
	String bed_class_allowed		= checkForNull(request.getParameter("ch_bed_class_param"));
	String deactivate_pseudo_bed_yn = checkForNull(request.getParameter("deact_pseudo_bed"));
	String func_id					= checkForNull(request.getParameter("func_id"));
	if(func_id!=null && func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
			isreadonly = "ReadOnly";
			isenable = "Disabled";
		}

	if(!BED_BLOCK_PERIOD_MAXS.equals(""))
		BED_BLOCK_PERIOD_MAX		= Integer.parseInt(BED_BLOCK_PERIOD_MAXS);
	if(max_blk_type.equals("D"))
		BED_BLOCK_PERIOD_MAX=(BED_BLOCK_PERIOD_MAX)*24;

	if(!frdailychargeStr.equals(""))
	    frdailycharge				= Integer.parseInt(frdailychargeStr);

	if(!call_function.equals("confirm_details"))
		eid							= checkForNull((String)session.getValue("encounter_id"));
	else
		eid							= checkForNull((String)session.getValue("encounter_id"));
	long    encounterid				=	Long.parseLong(eid);

	try
	{
		con							= ConnectionManager.getConnection(request);

		Boolean restrictPseudoBed	= CommonBean.isSiteSpecific(con,"IP","RESTRICT_PSEUDO_BED"); //Added by Sangeetha on  23/05/17 for GDOH-CRF-0151
				
	
	if(call_function.equals("Change_Bedclass"))
	{
		if(StrBuf.length()>0) StrBuf.delete(0,StrBuf.length());
		// Changed by vinod  6/21/2006


/*  Commented this query for PE By Suresh on 09/06/2010

		StrBuf.append("SELECT" );
		StrBuf.append("  REQ_NURSING_UNIT_CODE" );
		StrBuf.append("  ,IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, REQ_NURSING_UNIT_CODE,'"+locale+"','2') REQ_NURSING_UNIT_SHORT_DESC" );
		StrBuf.append("  , TO_SERVICE_CODE" );
		StrBuf.append("  ,AM_GET_DESC.AM_SERVICE(TO_SERVICE_CODE,'"+locale+"','2') TO_SERVICE_SHORT_DESC" );
		StrBuf.append("  , TO_SUBSERVICE_CODE" );
		StrBuf.append("  , AM_GET_DESC.AM_SUBSERVICE(TO_SERVICE_CODE, TO_SUBSERVICE_CODE,'"+locale+"','2')TO_SUBSERVICE_SHORT_DESC" );
		StrBuf.append("  ,REQ_BED_CLASS_CODE" );
		StrBuf.append("  ,IP_GET_DESC.IP_BED_CLASS(REQ_BED_CLASS_CODE,'"+locale+"','2') REQ_BED_CLASS_SHORT_DESC" );
		StrBuf.append("  , REQ_BED_TYPE_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_BED_TYPE(REQ_BED_TYPE_CODE,'"+locale+"','2') REQ_BED_TYPE_SHORT_DESC" );
		StrBuf.append("  ,REQ_BED_NO" );
		StrBuf.append("  , REQ_ROOM_NO" );
		StrBuf.append("  ,TO_SPECIALTY_CODE" );
		StrBuf.append("  , AM_GET_DESC.AM_SPECIALITY(TO_SPECIALTY_CODE,'"+locale+"','2') TO_SPECIALTY_SHORT_DESC" );
		StrBuf.append("  , TO_PRACTITIONER_ID" );
		StrBuf.append("  , AM_GET_DESC.AM_PRACTITIONER(TO_PRACTITIONER_ID,'"+locale+"','1') TO_PRACTITIONER_NAME" );
		StrBuf.append("  , TO_TEAM_ID" );
		StrBuf.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(FACILITY_ID,TO_TEAM_ID,'"+locale+"','2') TO_TEAM_SHORT_DESC" );
		StrBuf.append("  ,TRN_TYPE" );
		StrBuf.append("  ,BLOCKING_PERIOD" );
		StrBuf.append("  , BLOCKING_REMARKS" );
		StrBuf.append("  ,BLOCKING_TYPE_CODE " );
		StrBuf.append("  ,DELINK_BABY_YN " );
		StrBuf.append("FROM" );
		StrBuf.append("  ip_bed_class_request " );
		StrBuf.append("WHERE encounter_id ='"+eid+"' " );
		StrBuf.append("  AND facility_id = '"+facilityId+"' " );
		StrBuf.append("  AND REQUEST_STATUS='0'" );	
		stmt  = con.createStatement();
		rset  = stmt.executeQuery(StrBuf.toString());

		if(rset!=null && rset.next())
		{
			tonursingunitcode	= checkForNull(rset.getString("REQ_NURSING_UNIT_CODE"));
			tonursingunitdesc	= checkForNull(rset.getString("REQ_NURSING_UNIT_SHORT_DESC"));
			toservicecode		= checkForNull(rset.getString("TO_SERVICE_CODE"));
			tobedclass			= checkForNull(rset.getString("REQ_BED_CLASS_CODE"));
			tobedtype			= checkForNull(rset.getString("REQ_BED_TYPE_CODE"));
			tobedtypedesc		= checkForNull(rset.getString("REQ_BED_TYPE_SHORT_DESC"));
			tobedclassdesc		= checkForNull(rset.getString("REQ_BED_CLASS_SHORT_DESC"));
			tobedno				= checkForNull(rset.getString("REQ_BED_NO"));
			toroomno			= checkForNull(rset.getString("REQ_ROOM_NO"));
			tospecialitycode	= checkForNull(rset.getString("TO_SPECIALTY_CODE"));
			tospecialitydesc	= checkForNull(rset.getString("TO_SPECIALTY_SHORT_DESC"));
			topractitionerid	= checkForNull(rset.getString("TO_PRACTITIONER_ID"));
			topractdesc			= checkForNull(rset.getString("TO_PRACTITIONER_NAME"));
			toteamid			= checkForNull(rset.getString("TO_TEAM_ID"));
			tosubservcode		= checkForNull(rset.getString("TO_SUBSERVICE_CODE"));
			TRN_TYPE 			= checkForNull(rset.getString("TRN_TYPE"));
			blocking_period 	= checkForNull(rset.getString("BLOCKING_PERIOD"));
			blocking_remark 	= checkForNull(rset.getString("BLOCKING_REMARKS"));
			blocking_type_code 	= checkForNull(rset.getString("BLOCKING_TYPE_CODE"));
			mother_bed_status	= checkForNull(rset.getString("DELINK_BABY_YN"));
			
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		}
		*/

			tonursingunitcode	= checkForNull(request.getParameter("tonursingunitcode"));
			tonursingunitdesc	= checkForNull(request.getParameter("tonursingunitdesc"));
			toservicecode		= checkForNull(request.getParameter("toservicecode"));
			tobedclass			= checkForNull(request.getParameter("tobedclass"));
			tobedtype			= checkForNull(request.getParameter("tobedtype"));
			tobedtypedesc		= checkForNull(request.getParameter("tobedtypedesc"));
			tobedclassdesc		= checkForNull(request.getParameter("tobedclassdesc"));
			tobedno				= checkForNull(request.getParameter("tobedno"));
			toroomno			= checkForNull(request.getParameter("toroomno"));
			tospecialitycode	= checkForNull(request.getParameter("tospecialitycode"));
			tospecialitydesc	= checkForNull(request.getParameter("tospecialitydesc"));
			topractitionerid	= checkForNull(request.getParameter("topractitionerid"));
			topractdesc			= checkForNull(request.getParameter("topractdesc"));
			toteamid			= checkForNull(request.getParameter("toteamid"));
			tosubservcode		= checkForNull(request.getParameter("tosubservcode"));
			TRN_TYPE 			= checkForNull(request.getParameter("TRN_TYPE"));
			blocking_period 	= checkForNull(request.getParameter("blocking_period"));
			blocking_remark 	= checkForNull(request.getParameter("blocking_remark"));
			blocking_type_code 	= checkForNull(request.getParameter("blocking_type_code"));
			mother_bed_status	= checkForNull(request.getParameter("mother_bed_status"));
	}
//Condition for Request For Transfer by kishore on 9/10/2004
	else if(call_function.equals("Request_Trasnfer") || call_function.equals("EMERGENCY_TRANSFER"))
	{
	 
		  tobedclass		= frbedclass;
		  tobedtype			= frbedtype;
		  tobedtypedesc		= frbedtypedesc;
		  tobedclassdesc	= frbedclassdesc;
		  topractitionerid	= frpractitionerid;
		  topractdesc		= frpractdesc;
		  tospecialitydesc	= frspecialitydesc;
		  tospecialitycode	= frspecialitycode;
		  toteamid			= frmedid;
		  
	}
//Condition for Transfer Patient by kishore on 9/10/2004
	else if(call_function.equals("Transfer_patient"))
	{
		  tonursingunitcode	= frnursingunitcode;
		  tonursingunitdesc	= frnursingunitdesc;
		  toservicecode		= frservicecode;
		  tosubservcode		= frsubservcode;
		  tobedclass		= frbedclass;
		  tobedtype			= frbedtype;
		  tobedtypedesc		= frbedtypedesc;
		  tobedclassdesc	= frbedclassdesc;
		  topractitionerid	= frpractitionerid;
		  topractdesc		= frpractdesc;
		  tospecialitydesc	= frspecialitydesc;
		  tospecialitycode	= frspecialitycode;
		  toteamid			= frmedid;
	}
//Condition for Confirm Request For Transfer by kishore on 9/10/2004
	else if(call_function.equals("confirm_request")||call_function.equals("cancel_request")||call_function.equals("confirm_details"))
	{
		if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
		// Changed by vinod  4:47 PM
				
		StrBuf.append("select" );
		StrBuf.append("  REQ_NURSING_UNIT_CODE NURSING_UNIT_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_NURSING_UNIT(FACILITY_ID, REQ_NURSING_UNIT_CODE,'"+locale+"',2)NURSING_UNIT_SHORT_DESC" );
		StrBuf.append("  , REQ_SPECIALTY_CODE SPECIALTY_CODE" );
		StrBuf.append("  , AM_GET_DESC.AM_SPECIALITY( REQ_SPECIALTY_CODE,'"+locale+"',2) SPECIALTY_SHORT_DESC" );
		StrBuf.append("  , REQ_PRACTITIONER_ID PRACTITIONER_ID" );
		StrBuf.append("  , AM_GET_DESC.AM_PRACTITIONER(REQ_PRACTITIONER_ID,'"+locale+"',1) PRACTITIONER_NAME" );
		StrBuf.append("  , REQ_BED_CLASS_CODE BED_CLASS_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_BED_CLASS(REQ_BED_CLASS_CODE,'"+locale+"',2) BED_CLASS_SHORT_DESC" );
		StrBuf.append("  , REQ_BED_TYPE_CODE BED_TYPE_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_BED_TYPE(REQ_BED_TYPE_CODE,'"+locale+"',2) BED_TYPE_SHORT_DESC" );
		StrBuf.append("  , REQ_ROOM_NO ROOM_NO" );
		StrBuf.append("  , REQ_BED_NO BED_NO" );
		StrBuf.append("  , TFR_REQ_TYPE" );
		StrBuf.append("  , IP_GET_DESC.IP_TRANSFER_TYPE(TFR_REQ_TYPE, '"+locale+"',2) TRANSFER_TYPE_SHORT_DESC" );
		StrBuf.append("  , to_char(TFR_REQ_DATE_TIME, 'dd/mm/rrrr hh24:mi') BOOKING_DATE_TIME" );
		StrBuf.append("  , PRIORITY_CODE" );
		StrBuf.append("  , IP_GET_DESC.IP_TRANSFER_PRIORITY(FACILITY_ID,PRIORITY_CODE,'"+locale+"',2) PRIORITY_SHORT_DESC" );
		StrBuf.append("  , AM_GET_DESC.AM_SERVICE(REQ_SERVICE_CODE, '"+locale+"',2) SERVICE_SHORT_DESC" );
		StrBuf.append("  , AM_GET_DESC.AM_SUBSERVICE(REQ_SERVICE_CODE, REQ_SUBSERVICE_CODE,'"+locale+"',2) SUBSERVICE_SHORT_DESC" );
		StrBuf.append("  , AM_GET_DESC.AM_MEDICAL_TEAM(FACILITY_ID, REQ_TEAM_ID,'"+locale+"',2) TEAM_SHORT_DESC" );
		StrBuf.append("  , REQ_TEAM_ID TEAM_ID" );
		StrBuf.append("  , REQ_SERVICE_CODE SERVICE_CODE" );
		StrBuf.append("  , REQ_SUBSERVICE_CODE SUBSERVICE_CODE " );
		StrBuf.append("from" );
		StrBuf.append("  IP_TRANSFER_REQUEST " );
		StrBuf.append("where FACILITY_ID = '"+facilityId+"' " );
		StrBuf.append("  and ENCOUNTER_ID = '"+encounterid+"' " );

		if(!call_function.equals("confirm_details"))
		{
			if(bed_class_allowed.equals("Y"))
			StrBuf.append("and BED_CLASS_REQ_STATUS='1'");
			StrBuf.append(" and TFR_REQ_TYPE='RT' and TFR_REQ_STATUS ='0' ");
			StrBuf.append(" and (PRIORITY_EXP_DATE is null or PRIORITY_EXP_DATE >= sysdate)");
		}
		else
			StrBuf.append(" and tfr_req_status = '1'");
		stmt  = con.createStatement();
		
		rset  = stmt.executeQuery(StrBuf.toString());
		if(rset!=null && rset.next())
		{
			tonursingunitcode		= checkForNull(rset.getString("nursing_unit_code"));
			tonursingunitdesc		= checkForNull(rset.getString("nursing_unit_short_desc"));
			toservicecode			= checkForNull(rset.getString("SERVICE_CODE"));
			tobedclass				= checkForNull(rset.getString("BED_CLASS_CODE"));
			tobedclassdesc			= checkForNull(rset.getString("BED_CLASS_SHORT_DESC"));
			tobedtype				= checkForNull(rset.getString("BED_TYPE_CODE"));
			tobedtypedesc			= checkForNull(rset.getString("BED_TYPE_SHORT_DESC"));
			tobedno					= checkForNull(rset.getString("bed_no"));
			toroomno				= checkForNull(rset.getString("room_no"));
			tospecialitycode		= checkForNull(rset.getString("specialty_code"));
			tospecialitydesc		= checkForNull(rset.getString("specialty_short_desc"));
			topractitionerid		= checkForNull(rset.getString("practitioner_id"));
			topractdesc			= checkForNull(rset.getString("practitioner_name"));
			toteamid					= checkForNull(rset.getString("TEAM_ID"));
			tosubservcode			= checkForNull(rset.getString("SUBSERVICE_CODE"));
			if(rset!=null) rset.close();
			if(stmt!=null) stmt.close();
		}
	}//End Here by kishore on 9/10/2004


            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(frnursingunitdesc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(frnursingunitcode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(frnursingunitdesc));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(tonursingunitdesc));
            _bw.write(_wl_block15Bytes, _wl_block15);
if(!call_function.equals("Transfer_patient")){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block18Bytes, _wl_block18);
if(call_function.equals("Request_Trasnfer") || call_function.equals("EMERGENCY_TRANSFER") || call_function.equals("confirm_request") ){
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(loginUser));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(tonursingunitdesc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(tonursingunitcode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(frservicedesc));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(frservicecode));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(frservicedesc));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

			if(!call_function.equals("EMERGENCY_TRANSFER")){
				String sel="";
				String service_code=""; String service_desc ="";
				
				if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
								
				// Changed by Vinod 6/19/2006 4:48 PM
				StrBuf.append("SELECT" );
				StrBuf.append("  service_code" );
				StrBuf.append("  , AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc " );
				StrBuf.append("FROM" );
				StrBuf.append("  IP_NURS_UNIT_FOR_SERVICE " );
				StrBuf.append("WHERE facility_id = '"+facilityId+"' " );
				StrBuf.append("  AND nursing_unit_code = '"+tonursingunitcode+"' " );
				StrBuf.append("UNION" );
				StrBuf.append("  " );
				StrBuf.append("SELECT" );
				StrBuf.append("  service_code" );
				StrBuf.append("  , AM_GET_DESC.AM_SERVICE(service_code,'"+locale+"','2') service_short_desc " );
				StrBuf.append("FROM" );
				StrBuf.append("  IP_NURSING_UNIT " );
				StrBuf.append("WHERE facility_id = '"+facilityId+"' " );
				StrBuf.append("  AND nursing_unit_code = '"+tonursingunitcode+"' " );
				StrBuf.append("ORDER BY" );
				StrBuf.append("  2" );


				pstmt = con.prepareStatement(StrBuf.toString());
				
				rset = pstmt.executeQuery();
				if(rset!=null )
				{
					while(rset.next())
					{
						service_code  = rset.getString("service_code");
						service_desc = rset.getString("service_short_desc");
						
						if (service_code.equals(toservicecode))
							sel = "selected";
						else
							sel = "";

						out.print("<option value=\""+service_code+"\" "+sel+">"+service_desc+"");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close(); 
				}
			}
		  
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(frsubservdesc));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(frsubservcode));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(frsubservdesc));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
	
			try
			{
				if(!call_function.equals("EMERGENCY_TRANSFER")){
					String subservice_code = "", subservice_desc = "";
					if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());

				   // Changed By vinod 6/19/2006 4:49 PM
					StrBuf.append("SELECT" );
					StrBuf.append("  service_code" );
					StrBuf.append("  ,am_get_desc.am_service(service_code,'"+locale+"',2) service_short_desc" );
					StrBuf.append("  , subservice_code" );
					StrBuf.append("  ,am_get_desc.am_subservice(service_code,subservice_code,'"+locale+"',2) subservice_short_desc " );
					StrBuf.append("FROM" );
					StrBuf.append("  AM_FACILITY_SUBSRVC " );
					StrBuf.append("WHERE operating_facility_id = '"+facilityId+"' " );
					StrBuf.append("  AND service_code = '"+toservicecode+"' " );
					StrBuf.append("  AND eff_status = 'E' " );
					StrBuf.append("ORDER BY" );
					StrBuf.append("  2 " );
	
					pstmt = con.prepareStatement(StrBuf.toString());
					rset = pstmt.executeQuery();
					if(rset!=null)
					{
						while(rset.next())
						{
						subservice_code  = rset.getString("subservice_code");
						subservice_desc = rset.getString("subservice_short_desc");

						if (subservice_code.equals(tosubservcode))
							subsel = "selected";
						else
							subsel = "";
						out.print("<option value=\""+subservice_code+"\" "+subsel+">"+subservice_desc+"");
						}
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					}
				}
			}catch(Exception e)
			{
				//out.println("<script>alert('Exception : "+e.toString()+"');</script>");
				e.printStackTrace();
			}
			
			
            _bw.write(_wl_block38Bytes, _wl_block38);

		if(!call_function.equals("Change_Bedclass")&& !call_function.equals("confirm_request") && !call_function.equals("cancel_request") && !call_function.equals("confirm_details")){

		if(bed_class_allowed.equals("Y")){
		
            _bw.write(_wl_block39Bytes, _wl_block39);

				if(!call_function.equals("EMERGENCY_TRANSFER")){
			
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
if(call_function.equals("Request_Trasnfer") || func_id.equals("MODIFY_SERVICE_INPATIENT")){
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);

		}
	 }//close of if, this if will not let change bed class in Bed Class change
		
            _bw.write(_wl_block46Bytes, _wl_block46);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(frbedclassdesc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(frbedclass));
            _bw.write(_wl_block49Bytes, _wl_block49);
if(call_function.equals("EMERGENCY_TRANSFER")){
				if(!call_function.equals("Change_Bedclass")&& !call_function.equals("confirm_request") && !call_function.equals("cancel_request") && !call_function.equals("confirm_details")){

				if(bed_class_allowed.equals("Y")){
			
            _bw.write(_wl_block40Bytes, _wl_block40);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
}}}else {
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);

					//Maheshwaran added if condition to populate bed class on load of this pagefor GHL-CRF-0362
					//Start
					if(call_function.equals("confirm_request"))
						{
						try{
						if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
//						StrBuf.append("Select bed_class_code,ip_get_desc.ip_bed_class(bed_class_code,'"+locale+"',2)short_desc from IP_BED_CLASS where eff_status='E'  tonursingunitcodeorder by short_desc ");
						StrBuf.append("SELECT DISTINCT bed_class_code, ip_get_desc.ip_bed_class(bed_class_code,?,2) short_desc FROM ip_nursing_unit_bed WHERE facility_id = ? AND eff_status = 'E' AND nursing_unit_code = ?  ORDER BY short_desc");
						String bedcode="";
						String beddesc="";
						pstmt = con.prepareStatement(StrBuf.toString());
						pstmt.setString(1,locale);
						pstmt.setString(2,facilityId);
						pstmt.setString(3,tonursingunitcode);
						rset = pstmt.executeQuery();
						if( rset != null )
							{
							while( rset.next() )
								{
								bedcode   = rset.getString("bed_class_code") ;
								beddesc   = rset.getString("short_desc") ;
								if (bedcode.equals(tobedclass))
									{
									subsel = "selected";					
									}
								else
								subsel = "";
								out.println("<option value=\""+bedcode+"\" "+subsel+">"+beddesc+"</option>");
								}
								if(rset!=null) rset.close();
								if(pstmt!=null) pstmt.close();
							}
						}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
			
						}
					else
						{
						
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(tobedclass));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(tobedclassdesc));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
						//End
						
            _bw.write(_wl_block58Bytes, _wl_block58);

		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	
            _bw.write(_wl_block60Bytes, _wl_block60);
if(call_function.equals("Change_Bedclass")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tobedclass));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(frbedclass));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
if(call_function.equals("Change_Bedclass")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tobedclassdesc));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(frbedclassdesc));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block67Bytes, _wl_block67);
}
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(frbedtypedesc));
            _bw.write(_wl_block70Bytes, _wl_block70);
if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);

		try{
			
			if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
	
				//StrBuf.append("Select bed_class_code,short_desc from IP_BED_CLASS_LANG_VW where language_id='"+locale+"' and  eff_status='E' order by short_desc ");
				/*Wednesday, April 28, 2010 , modified for PE*/
				StrBuf.append("Select bed_class_code,ip_get_desc.ip_bed_class(bed_class_code,'"+locale+"',2)short_desc from IP_BED_CLASS where eff_status='E' order by short_desc ");
			

			String bedcode="";
			String beddesc="";
			pstmt = con.prepareStatement(StrBuf.toString());
			rset = pstmt.executeQuery();

			if( rset != null )
				{
				  while( rset.next() )
				  {
					bedcode   = rset.getString("bed_class_code") ;
					 beddesc   = rset.getString("short_desc") ;

					if (bedcode.equals(tobedclass))
					  {
						subsel = "selected";					
					  }
					else
						subsel = "";
					out.println("<option value=\""+bedcode+"\" "+subsel+">"+beddesc+"</option>");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
		
	
            _bw.write(_wl_block73Bytes, _wl_block73);

		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	
            _bw.write(_wl_block59Bytes, _wl_block59);

		}
	
            _bw.write(_wl_block60Bytes, _wl_block60);
if(call_function.equals("Change_Bedclass")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tobedclass));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(frbedclass));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
if(call_function.equals("Change_Bedclass")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tobedclassdesc));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(frbedclassdesc));
            _bw.write(_wl_block66Bytes, _wl_block66);
}
            _bw.write(_wl_block74Bytes, _wl_block74);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

			//Maheshwaran added if condition to populate bed type on load of this pagefor GHL-CRF-0362
			//Start
			if(call_function.equals("confirm_request")){
			try{
			if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
			StrBuf.append("SELECT DISTINCT bed_type_code ,ip_get_desc.ip_bed_type(bed_type_code,'"+locale+"',2) short_desc FROM IP_NURSING_UNIT_BED WHERE facility_id = '"+facilityId+"' AND nursing_unit_code = '"+tonursingunitcode+"' AND bed_class_code = '"+tobedtype+"' AND eff_status='E'  ORDER BY short_desc");
			pstmt = con.prepareStatement(StrBuf.toString());
			rset = pstmt.executeQuery();
			if( rset != null )
				{
				 while( rset.next() )
				  {
					String short_desc = rset.getString( "short_desc" ) ;
					String bed_type_code = rset.getString( "bed_type_code" ) ;
					if (bed_type_code.equals(tobedtype))
					  {
						subsel = "selected";					
					  }
					else
					subsel = "";
					out.println("<option value=\""+bed_type_code+"\" "+subsel+">"+short_desc+"</option>");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
			}
			else
				{
				
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(frbedtypedesc));
            _bw.write(_wl_block78Bytes, _wl_block78);

				}
				//End
			
            _bw.write(_wl_block79Bytes, _wl_block79);

		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	
            _bw.write(_wl_block80Bytes, _wl_block80);

		}
	
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(tobedtype));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(tobedtypedesc));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(frbedno));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(frbedno));
            _bw.write(_wl_block87Bytes, _wl_block87);
if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);

		try{
			
			if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
			//StrBuf.append("Select short_desc,bed_type_code from IP_BED_TYPE_LANG_VW where language_id='"+locale+"' and eff_status='E' order by short_desc ");
			/*Wednesday, April 28, 2010 , modified for PE*/
			StrBuf.append("Select ip_get_desc.IP_BED_TYPE(bed_type_code,'"+locale+"',2)short_desc,bed_type_code from IP_BED_TYPE where eff_status='E' and bed_type_code like '%%'  order by short_desc ");
			pstmt = con.prepareStatement(StrBuf.toString());
			rset = pstmt.executeQuery();
				if( rset != null )
				{
				  while( rset.next() )
				  {
					String short_desc = rset.getString( "short_desc" ) ;
					String bed_type_code = rset.getString( "bed_type_code" ) ;
					if (bed_type_code.equals(tobedtype))
					  {
						subsel = "selected";					
					  }
					else
						subsel = "";
					
					out.println("<option value=\""+bed_type_code+"\" "+subsel+">"+short_desc+"</option>");
					}
				if(rset!=null) rset.close();
				if(pstmt!=null) pstmt.close();
				}
			}catch(Exception e) {/* out.println(e.toString()); */e.printStackTrace();}
		
	
            _bw.write(_wl_block91Bytes, _wl_block91);

		if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
		{
	
            _bw.write(_wl_block80Bytes, _wl_block80);

		}
	
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(tobedtype));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(tobedtypedesc));
            _bw.write(_wl_block83Bytes, _wl_block83);
}else{ 
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(tobedno));
            _bw.write(_wl_block96Bytes, _wl_block96);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block97Bytes, _wl_block97);
 }
            _bw.write(_wl_block98Bytes, _wl_block98);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block99Bytes, _wl_block99);
 }
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block101Bytes, _wl_block101);

			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			
            _bw.write(_wl_block102Bytes, _wl_block102);

			}
			
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tobedno));
            _bw.write(_wl_block104Bytes, _wl_block104);
}
            _bw.write(_wl_block105Bytes, _wl_block105);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(frroomno));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(frroomno));
            _bw.write(_wl_block107Bytes, _wl_block107);
if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block108Bytes, _wl_block108);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(tobedno));
            _bw.write(_wl_block96Bytes, _wl_block96);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block97Bytes, _wl_block97);
 }
            _bw.write(_wl_block98Bytes, _wl_block98);
 if(restrictPseudoBed){ 
            _bw.write(_wl_block99Bytes, _wl_block99);
 }
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block101Bytes, _wl_block101);

			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			
            _bw.write(_wl_block102Bytes, _wl_block102);

			}
			
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tobedno));
            _bw.write(_wl_block104Bytes, _wl_block104);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(toroomno));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(toroomno));
            _bw.write(_wl_block112Bytes, _wl_block112);
}
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(frspecialitydesc));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(frspecialitycode));
            _bw.write(_wl_block115Bytes, _wl_block115);
if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(toroomno));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(toroomno));
            _bw.write(_wl_block112Bytes, _wl_block112);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
if(!call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tospecialitydesc));
            _bw.write(_wl_block118Bytes, _wl_block118);
}
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block101Bytes, _wl_block101);

			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			
            _bw.write(_wl_block124Bytes, _wl_block124);

			}
			
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(tospecialitycode));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(tospecialitydesc));
            _bw.write(_wl_block127Bytes, _wl_block127);
}
            _bw.write(_wl_block128Bytes, _wl_block128);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(frpractdesc));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(frpractitionerid));
            _bw.write(_wl_block115Bytes, _wl_block115);
if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block117Bytes, _wl_block117);
if(!call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(tospecialitydesc));
            _bw.write(_wl_block118Bytes, _wl_block118);
}
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block101Bytes, _wl_block101);

			if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
			{
			
            _bw.write(_wl_block124Bytes, _wl_block124);

			}
			
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(tospecialitycode));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(tospecialitydesc));
            _bw.write(_wl_block131Bytes, _wl_block131);
}else{
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(topractitionerid));
            _bw.write(_wl_block133Bytes, _wl_block133);
if(!call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(topractdesc));
            _bw.write(_wl_block118Bytes, _wl_block118);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block101Bytes, _wl_block101);

				if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
				{
			
            _bw.write(_wl_block138Bytes, _wl_block138);

				}
			
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(topractdesc));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(topractitionerid));
            _bw.write(_wl_block141Bytes, _wl_block141);
}
            _bw.write(_wl_block142Bytes, _wl_block142);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(frmeddesc));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(frmedid));
            _bw.write(_wl_block115Bytes, _wl_block115);
if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block116Bytes, _wl_block116);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(topractitionerid));
            _bw.write(_wl_block145Bytes, _wl_block145);
if(!call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(topractdesc));
            _bw.write(_wl_block118Bytes, _wl_block118);
}
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(isreadonly));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block101Bytes, _wl_block101);

				if(func_id!=null && !func_id.equals("MODIFY_SERVICE_INPATIENT"))
				{
			
            _bw.write(_wl_block138Bytes, _wl_block138);

				}
			
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(topractdesc));
            _bw.write(_wl_block146Bytes, _wl_block146);
}else{
            _bw.write(_wl_block147Bytes, _wl_block147);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(toteamid));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

					if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
					StrBuf.append(" select team_id,am_get_desc.am_medical_team(facility_id,team_id,'"+locale+"',2) team_short_desc from am_pract_for_team_vw where facility_id = '"+facilityId+"' and practitioner_id ='"+topractitionerid+"' and speciality_code = '"+tospecialitycode+"'");
					pstmt = con.prepareStatement(StrBuf.toString());
					rset = pstmt.executeQuery();
					if(rset!= null)
					{
						while(rset.next())
						{				
							medcode = rset.getString("team_id");
							if(medcode == null) medcode="";
							meddesc = rset.getString("team_short_desc");
							String optSelected="";
							if(medcode.equals(toteamid))
								optSelected="selected";
							else
								optSelected="";
							out.println("<option value=\""+medcode+"\"" +optSelected+">"+meddesc+"</option>");				
						}			
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					}					

            _bw.write(_wl_block152Bytes, _wl_block152);
}
            _bw.write(_wl_block153Bytes, _wl_block153);
if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(toteamid));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(isenable));
            _bw.write(_wl_block150Bytes, _wl_block150);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block151Bytes, _wl_block151);

					if(StrBuf.length() > 0 ) StrBuf.delete(0,StrBuf.length());
					StrBuf.append(" select team_id,am_get_desc.am_medical_team(facility_id,team_id,'"+locale+"',2) team_short_desc from am_pract_for_team_vw where facility_id = '"+facilityId+"' and practitioner_id ='"+topractitionerid+"' and speciality_code = '"+tospecialitycode+"'");
					pstmt = con.prepareStatement(StrBuf.toString());
					rset = pstmt.executeQuery();
					if(rset!= null)
					{
						while(rset.next())
						{				
							medcode = rset.getString("team_id");
							if(medcode == null) medcode="";
							meddesc = rset.getString("team_short_desc");
							String optSelected="";
							if(medcode.equals(toteamid))
								optSelected="selected";
							else
								optSelected="";
							out.println("<option value=\""+medcode+"\"" +optSelected+">"+meddesc+"</option>");				
						}			
					if(rset!=null) rset.close();
					if(pstmt!=null) pstmt.close();
					}					

            _bw.write(_wl_block155Bytes, _wl_block155);
}
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(frbedtype));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(frdailycharge));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(bed_class_allowed));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(age));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(TRN_TYPE));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(admissiondate));
            _bw.write(_wl_block172Bytes, _wl_block172);
if(call_function.equals("Change_Bedclass"))
	{
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(blocking_period));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(blocking_remark));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(blocking_type_code));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(mother_bed_status));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(overrideyn));
            _bw.write(_wl_block178Bytes, _wl_block178);
}
            _bw.write(_wl_block179Bytes, _wl_block179);
if(call_function.equals("Change_Bedclass"))
		{
            _bw.write(_wl_block180Bytes, _wl_block180);
}
		else if(call_function.equals("Request_Trasnfer")){
            _bw.write(_wl_block181Bytes, _wl_block181);
}
		else if(call_function.equals("cancel_request")||call_function.equals("confirm_details")){
            _bw.write(_wl_block182Bytes, _wl_block182);
if(bed_class_allowed.equals("Y")){
			
            _bw.write(_wl_block183Bytes, _wl_block183);
}
            _bw.write(_wl_block184Bytes, _wl_block184);
if(call_function.equals("cancel_request")||call_function.equals("confirm_details"))
			{
            _bw.write(_wl_block185Bytes, _wl_block185);
}
            _bw.write(_wl_block186Bytes, _wl_block186);
}
		else if(call_function.equals("Transfer_patient")){
            _bw.write(_wl_block187Bytes, _wl_block187);
}else if(call_function.equals("EMERGENCY_TRANSFER")){
            _bw.write(_wl_block188Bytes, _wl_block188);
} else if(call_function.equals("confirm_request")) {
            _bw.write(_wl_block189Bytes, _wl_block189);
}
            _bw.write(_wl_block190Bytes, _wl_block190);
		
		if(stmt   != null)			stmt.close();
		if(rset	  != null)			rset.close();
	}catch(Exception e)
	{
		//out.print("Exception TransferDetails:"+e);
		e.printStackTrace();
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}
	 
            _bw.write(_wl_block191Bytes, _wl_block191);
            _bw.write(_wl_block192Bytes, _wl_block192);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.CurrentOccupancy.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferTo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.service.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.subservice.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RequestBedClassChange.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RequestBedClassChange.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.RequestBedClassChange.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomcubicleno.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AttendingPractitioner.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
}
