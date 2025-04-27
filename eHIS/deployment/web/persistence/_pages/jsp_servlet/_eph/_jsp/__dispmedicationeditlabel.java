package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.DecimalFormat;
import eST.*;
import eST.Common.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispmedicationeditlabel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispMedicationEditLabel.jsp", 1734671325246L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- /* \n--------------------------------------------------------------------------------------------------------------\nDate\t\t\tEdit History       Name\t\t\t     Description\n--------------------------------------------------------------------------------------------------------------\n13/08/2019      IN070605\t\t Devindra           MMS-KH-CRF-0028  \n10/08/2020     IN073523\t\t    Shazana                                             PHIS-PH-Alpha - Exceed Dosage Limit Icon in Fill and Deliver Stage\n14/08/2020\t   IN73343         Shazana \t\t\t\t\t\t\t\t\t\t\t\tPHIS-PH-Alpha - Medical Supply, Special Characters issue in SIKARIN\n17/05/2023\t   IN43751\t\t   Sushant Tambe\t\tML-BRU-SCF-2223\n---------------------------------------------------------------------------------------------------------------\n*/ -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="  \n<html>\n\t<head> \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedicationAllStages.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../ePH/js/DispMedication.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n\t<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t\t<form name=\"DispMedicationEditLabel\" id=\"DispMedicationEditLabel\" action=\'DispMedicationValidation.jsp\' method=\'post\' target=\"dummyFrame\">\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t<div style=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' id=\'nonEditableLabel\'>\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"1\" width=\"100%\" align=\"center\" border=\"0\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class= \"COLUMNHEADER\" width=\"100%\" align=\"left\"><font style=\'font-size:12;\'><B>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</B></font></td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class= \"COLUMNHEADER\" colspan=\"4\" align=\"left\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\"4\">&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'15%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="   :</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'20%\'><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'15%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" </td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'50%\'><b>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'15%\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" :</td>\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'20%\'><b>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'15%\' colspan = 2></td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\'15%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </td>\n\t\t\t\t\t\t\t\t<td class=\"label\" width=\'50%\'><b>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\"4\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\t\n\t\t\t\t<div style=\"width:100%; overflow:auto;height:";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =";\">\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"4\">&nbsp;</td> \n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"4\">&nbsp;</td> \n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class= \"COLUMNHEADER\" colspan=\"4\" align=\"center\"><b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" # ";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</b></td> \n\t\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class= \"COLUMNHEADER\" colspan=\"4\" align=\"left\">";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t <tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\"3\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr> \n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'20%\'><b>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</b></td><!-- changed drug_name to drug_desc for 73523 -->\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'10%\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =":&nbsp;</td>\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'10%\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="<b></td>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" >&nbsp;&nbsp;";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\">\n\t\t\t\t\t\t\t\t\t\t\t<select name=\"line_bms_remarks_code_";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" id=\"line_bms_remarks_code_";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"line_bms_remarks_code_id_";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\'\'>---";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="---</option>\n";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" selected>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</option>\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'curBMSReasonVisibility\' id=\'curBMSReasonVisibility\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n\t\t\t\t\t\t\t\t\t\n\t\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'30%\'  style=\'TEXT-ALIGN:right;\' ><b>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</b>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" maxLength=\"3\" size=\"3\" name=\"noOfPrints";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" id=\"noOfPrints";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\" value=\"1\" > <!-- readonly removed for RUT req-->\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'30%\'  style=\'TEXT-ALIGN:right;\'><b>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</b>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t&nbsp;\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"noOfPrints";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\" maxLength=\"3\" size=\"2\" name=\"noOfPrints";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" onKeyPress=\"return(ChkNumberInput(this,event,\'0\'))\" onblur=\"validateNoOfPrints(this, \'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');\"  ><!--allow_label_zero_copy,Added for ML-BRU-SCF-1122 [IN:044833]-->\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =" \n\t\t\t\t\t\t\t\t\t<!-- Code Added For RUT-CRF-0067 - End-->\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" colspan=\"2\"><b>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</b></td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'20%\' ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" >";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =":&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t<td class=\"label\" width=\'20%\'  ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" colspan=\"4\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" border=\"0\">\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td class= \"COLUMNHEADER\" colspan=\"4\" align=\"left\">";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td> \n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"label\" colspan=\"4\">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t <!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] Start-->\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"3\">&nbsp;<textarea name=\"remarks_new_";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\"  size=\"150\" maxlength=\"150\"  rows=\'3\' cols=\'50\' readonly>";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</textarea><!-- code \'getPrescriptionRemarks\' is replaced by \'getDrugInstructions\' for ML-BRU-SCF-0981  -->  \n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</td> \n\t\t\t\t\t\t\t\t\t\t<td >&nbsp;<select name=\"caution_1_";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"caution_1_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =" onchange=\"changeLocalInstr(this,\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\',\'C\');\" width=\"500\" style=\"width: 500px\"><!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->\n\t\t\t\t\t\t\t\t\t\t<option value=\"\">-------------------------------";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="--------------------------------</option>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\" >\n\t\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="</td>\n\t\t\t\t\t\t\t\t\t<td>&nbsp;<select name=\"special_1_";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"special_1_";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\',\'S\');\" width=\"500\" style=\"width: 500px\"> <!-- width fixed to 500px for MMS-QH-CRF-0200 [IN:052044]-->\n\t\t\t\t\t\t\t\t\t<option value=\"\">-------------------------------";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td  >&nbsp;\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td>&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\t\t\t\t\t\t\t\t\t<td colspan=\"3\">&nbsp;<textarea rows=\"3\" cols=\"50\" maxLength=\"150\" ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" size=\"150\"   name=\"patient_int_";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" onKeyPress=\"return checkMaxLimit(this,150);\" onblur=\"validmaxlength(this);\">";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</textarea><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->\n\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"Copy\" id=\"Copy\" value=\"Copy\" onClick=\"CopyDrugRemarksValue(DispMedicationEditLabel,\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\');\">\t<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->\t\t\t\t\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t\t\t\t\t\t\t\t<td colspan=\"3\">&nbsp;<select name=\"pres_remarks_";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"pres_remarks_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 =">\n\t\t\t\t\t\t\t\t<option value=\"\">----";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="----</option>\n";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\"  ";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->\n\t\t\t\t\t\t\t\t<tr style=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n\t\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</td>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" align=\"left\">&nbsp;<textarea name=\"drug_ind_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\"value=\"\"  maxlength=\"500\"  rows=\'3\' cols=\'50\' onKeyPress=\"return checkMaxLimit(this,500);\" onblur =\"return checkDrugIndMaxLimit(this,500);\">";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</textarea>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  class=\"label\" colspan=\"4\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t <tr> \n\t\t\t\t\t\t\t\t <td class= \"COLUMNHEADER\" colspan=\"4\" >";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  class=\"label\" colspan=\"4\">&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</td>\n\t\t\t\t\t\t\t\t<td  class=\"label\" colspan=\"3\">\n";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\t\t\t\t\t\t\t<input type=\"text\" maxLength=\"60\" size=\"60\" name=\"loc_caution_1_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" id=\"loc_caution_1_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="  >\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\t\n\t\t\t\t\t\t\t\t\t<textarea rows=\"3\" cols=\"100\" maxLength=\"200\" name=\"loc_caution_1_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =" style=\'text-align:right\' class=\'OTHLANGTEXT\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</textarea><!--changed to textarea for MMS-QH-CRF-0200 [IN:052044]-->\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t\t\t\t\t\t </td> \n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n\t\t\t\t\t\t\t\t\t<input type=\"text\" maxLength=\"60\" size=\"60\" name=\"loc_special_1_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" id=\"loc_special_1_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' >\n";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\n\t\t\t\t\t\t\t\t\t<textarea rows=\"3\" cols=\"100\" maxLength=\"200\" name=\"loc_special_1_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\n\t\t\t\t\t\t\t\t\t<td  class=\"label\"colspan=\"3\">\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t\t\t\t\t<textarea rows=\"3\" cols=\"50\" maxLength=\"150\" ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 =" size=\"150\"   name=\"loc_patient_int_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" onKeyPress=\"return checkMaxLimit(this,150);\"onblur=\"validmaxlength(this);\" >";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] start-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"button\" name=\"Copy\" id=\"Copy\" value=\"Copy\" onClick=\"CopyDrugRemarksValue(DispMedicationEditLabel,\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\');\">\n\t\t\t\t\t\t\t\t\t\t<tr style=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\"label\">";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\" align=\"left\">&nbsp;<textarea name=\"loc_drug_ind_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\" readOnly maxlength=\"500\"  rows=\'3\' cols=\'50\' onKeyPress=\"return checkMaxLimit(this,500);\" onblur =\"return checkDrugIndMaxLimit(this,500);\">";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] end-->\n";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\" onKeyPress=\"return checkMaxLimit(this,150);\"  onblur=\"validmaxlength(this);\" style=\'text-align:right\' class=\'OTHLANGTEXT\'>";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="</td>\n\t\t\t\t\t\t\t\t\t\t\t<td colspan=\"2\" align=\"left\">&nbsp;<textarea name=\"drug_ind_";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\"  readOnly maxlength=\"500\"  rows=\'3\' cols=\'50\' onKeyPress=\"return checkMaxLimit(this,500);\" onblur =\"return checkDrugIndMaxLimit(this,500);\">";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="</textarea></td>\n\t\t\t\t\t\t\t\t\t\t</tr><!--Added newly for NewRequirement for client CRF[ML-BRU-CRF-072[Inc:29938]] End-->\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</table>\n";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" id=\"drug_code_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"order_line_no_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"order_id_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\"  value=\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\">\n\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_no_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" id=\"disp_no_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\"> <!-- Added for TTMWM-SCF-0184 -->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_srl_no_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\" id=\"disp_srl_no_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\"> <!-- Added for TTMWM-SCF-0184 -->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"allocQty";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\" id=\"allocQty";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\"><!--Code Added FOR RUT-CRF-0067-->\n\t\t\t\t\t\t<input type=\"hidden\" name=\"allow_label_zero";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" id=\"allow_label_zero";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\"><!--Added for ML-BRU-SCF-1122 [IN:044833]-->\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t\t\t\t\t</div> <!-- drugs labels--> \n\t\t\t\t</div><!--nonEditable Label -->\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t\t\t\t\t<div  id=\'editableLabel\'  style=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'>\n\t\t\t\t\t\t<table cellpadding=\"10\" cellspacing=\"0\" width=\"100%\" border=\"0\" id=\'EditableLabelPatDtl\'>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class= \"COLUMNHEADER\" colspan=\'2\' align=\"left\"><font style=\'font-size:12;\'><B>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="</B></font></td>\n\t\t\t\t\t\t\t\t<td width=\'30%\' class= \"COLUMNHEADER\" ><label style=\'";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\'>";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="&nbsp;&nbsp;</label>\n\t\t\t\t\t\t\t\t\t<select name=\"labelLanguageId\" id=\"labelLanguageId\" onchange=\'setlabelLangId(this, \"EDIT\");\' style=\'";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\'>\n\t\t\t\t\t\t\t\t\t<option value=\"en\" ";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="> ";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t\t\t\t\t\t<option value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td width=\'20%\'><b>";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="</b></td>\n\t\t\t\t\t\t\t\t<td width=\'60%\'>";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="<br>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td width=\'20%\'>&nbsp;</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t<div style=\"width:100%; overflow:auto;height:";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 =";\">\n\t\t\t\t\t\t\t<table cellpadding=\"10\" cellspacing=\"0\" width=\"100%\" border=\"1\" id=\'EditableLabel\'>\n";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\' width=\'20%\'><b>";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\'lblDispQty";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' style=\'";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\'>&nbsp;/<br>\n\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="</label></b></td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'  width=\'60%\'>";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<label id=\'fldDispQty";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'dispQty";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' id=\'dispQty";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' value=\'";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' size=\'4\' maxlength=\'3\' onpaste=\'return false\' onKeyPress=\"return allowValidNumber(this,event,3,0);\">&nbsp;";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="&nbsp;";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\" style=\'";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'></label>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'  width=\'20%\'><label  id=\'lblnoOfPrints";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t<b>";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="</b>&nbsp;\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"text\" id=\"noOfPrints";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" onKeyPress=\"return allowValidNumber(this,event,3,0);\" onblur=\"validateNoOfPrints(this, \'";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\');\"  style=\'";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'><b>";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</b></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'><input type=\'text\' name=\'dosageDtl_";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' id=\'dosageDtl_";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'  value=\'\' size=\'80\' maxlength=\'170\' onKeyPress=\"return checkMaxLimit(this,170);\" onblur =\"return checkDrugIndMaxLimit(this,170);\"></b>\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\n\n\t\t\t\t\t\t\t\t\t\t\t\t<img  src=\"../../eCommon/images/mandatory.gif\"></td>\n";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\n\t\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\t\tvar jsdosageDtl = decodeURIComponent(\'";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\');\n\t\t\t\t\t\t\t\t\t\t\t\t\teval(\'document.DispMedicationEditLabel.dosageDtl_\'+\'";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\').value=jsdosageDtl;\n\t\t\t\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'><b>";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="</b></td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'><textarea name=\'instruction_";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' maxlength=\"270\"  rows=\'4\' cols=\'70\' onKeyPress=\"return checkMaxLimit(this,270);\" onblur =\"return checkDrugIndMaxLimit(this,270);\">";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="</textarea>\n\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t<td class=\'label\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t<tr style=\'height:2;\'><td colspan=\'3\'>&nbsp</td>\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_id_";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"order_line_no_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_code_";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"pres_drug_code_";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\" id=\"pres_drug_code_";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"dispUOM";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\" id=\"dispUOM";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"encodedDosageDtl_";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\" id=\"encodedDosageDtl_";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\">\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"disp_no_";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\"> <!-- Added for TTMWM-SCF-0184 -->\n\t\t\t\t\t\t                               <input type=\"hidden\" name=\"disp_srl_no_";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\"> <!-- Added for TTMWM-SCF-0184 -->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"allocQty";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\"><!--Code Added FOR RUT-CRF-0067-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"allow_label_zero";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\"><!--Added for ML-BRU-SCF-1122 [IN:044833]-->\n\t\t\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\"drug_yn";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\" id=\"drug_yn";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\"><!--added for ML-BRU-SCF-1524 [IN:053164]-->\n";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\n\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t<input type=\"hidden\" name=\"labelLangId\" id=\"labelLangId\"  value=\"";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\">\n\t\t\t\t\t\t</div>\n\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\n\t\t\t\t\t\t<br>\n\t\t\t\t\t\t<div style=\"width:100%;overflow:auto;height:";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 =";text-align:center;\" id=\'editableLabelPreview\'  style=\'";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\'>\n\t\t\t\t\t\t\t<table cellpadding=\"10\" cellspacing=\"0\" style=\"width:500\"  border=\"1\" id=\'EditableLabel\'>\n";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\'2\' style=\'font: bold 20px Calibri,western;\'>";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td width=\'50%\' style=\'font: bold 20px Calibri,western;border-right-width:0\'>";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="</td>\n\t\t\t\t\t\t\t\t\t\t<td width=\'50%\' style=\'font: bold 20px Calibri,western; text-align:right;border-left-width:0\'>";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\'2\' style=\'font: bold 16px Calibri,western;text-align:center;\'>";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\'2\' style=\'font: bold 16px Calibri,western;font-weight:bold;text-align:center;\'><label id=\'dosageDtl_";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\'></label></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td colspan=\'2\'style=\'font: italic 12px Calibri,western;text-align:left;\'><label id=\'instruction_";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\'></label></td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr ><td colspan=\'2\' style=\'height:2;border-right:0;border-left:0;border-top:0;border-bottom:0;\'>&nbsp;</td></tr>\n";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\teval(document.getElementById(\"dosageDtl_\"+\'";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\')).innerText=decodeURIComponent(\'";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\');\n\t\t\t\t\t\t\t\t\t</script>\n";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\n\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\teval(document.getElementById(\"instruction_\"+\'";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\')).innerText= decodeURIComponent(\'";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\n\t\t\t\t<INPUT TYPE=\"hidden\" name=\"params\" id=\"params\" Value=\"";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\">\n\t\t\t\t\n";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\"NO_EDIT_LABELS\",\"PH\"));\n\t\t\t\t\tvar  zeroQtyFlag1 = ";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 =" ; // added for KAUH-SCF-001\t\t\n\t\t\t\t\tif(parent.buttonFrame!=undefined)\n\t\t\t\t\t\tif(zeroQtyFlag1 != true )  // added for KAUH-SCF-001\n\t\t\t\t\t\tparent.buttonFrame.document.frmPrintDialogButtons.btnCancel.onclick();\n\t\t\t\t\telse\n\t\t\t\t\t\tif(zeroQtyFlag1 != true )  // added for KAUH-SCF-001\n\t\t\t\t\t\t\twindow.close();\n\t\t\t\t</script>\n";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\n\t\t\t</div>\n\t\t\t<table cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" border=\"0\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td  align=\"right\" width=\"100%\" ";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =">\n\t\t\t\t\t<input  type=\"button\" ";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\'class=\"button\" onClick=\"validateEditDetailsReset(DispMedicationEditLabel);\">\n\t\t\t\t\t<input  type=\"button\" ";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\' class=\"button\"  onClick=\"validateEditDetails(DispMedicationEditLabel);\">\n\t\t\t\t\t<input  type=\"button\" value=\'";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\' class=\"button\" onClick=\"validateEditDetailsCancel(DispMedicationEditLabel);\">\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\n\t\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\"   value=\"";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\">\n\t\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\">\n\t\t\t<input type=\"hidden\" name=\"calledFrom\" id=\"calledFrom\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"ComputeSetOrder\" id=\"ComputeSetOrder\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"PrintDialogFrame\" id=\"PrintDialogFrame\" value=\"parent.printSelectFrame.document.DispMedicationPrintDialog\">\n\t\t\t<input type=\"hidden\" name=\"sDispStage\" id=\"sDispStage\" value=\"";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\" >\n\t\t\t<input type=\"hidden\" name=\"func_mode\" id=\"func_mode\" value=\"";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\">\n\t\t\t<input type=\"hidden\" name=\"totalRecordds\" id=\"totalRecordds\"  value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\">\n\t\t\t<input type=\"hidden\" name=\"editLabelFlag\" id=\"editLabelFlag\"  value=\"fill_allocate\"><!-- Code Added For RUT-CRF-0067 -->\n\t\t\t<input type=\"hidden\" name=\"allow_edit_disp_label\" id=\"allow_edit_disp_label\"  value=\"";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\"> <!-- Added for Bru-HIMS-CRF-414 [IN:045554]-->\n\t\t\t<input type=\"hidden\" name=\"sCalledFrom\" id=\"sCalledFrom\"  value=\"";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\"> <!-- Added for Bru-HIMS-CRF-414 [IN:045554]-->\n\t\t\t<input type=\"hidden\" name=\"allocQtyFlag\" id=\"allocQtyFlag\" id=\"allocQtyFlag\" value=\"";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\" ><!-- added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)  -->\n\t\t\t<input type=\"hidden\" name=\"IncludeZeroQtyForIP\" id=\"IncludeZeroQtyForIP\" value=\"";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\"><!-- Added for ML-BRU-CRF-0473 -->\n            <input type=\"hidden\" name=\"IncludeZeroQtyForOP\" id=\"IncludeZeroQtyForOP\" value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\"><!-- Added for ML-BRU-CRF-0473 -->\n            <input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\"><!-- Added for ML-BRU-CRF-0473 -->\n\t\t\t\n\n\t\t</form>\n\t\t<script>\n";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\n\t\t\t\talert(getMessage(\"NO_EDIT_LABELS\",\"PH\"));\n\t\t\t\twindow.close();\n";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 ="\n\t\t</script>\n";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		Connection con			= null;  // Added for ML-MMOH-crf-1089 start
	    con				= ConnectionManager.getConnection(request);
	    // Added for ML-MMOH-CRF-1089 - End

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

		try{
	
			String facility_id			=	(String) session.getValue("facility_id");
			String sShowButtons			=	request.getParameter("buttons")==null?"":" style='display:none' ";
			String drug_code			=	request.getParameter("drug_code");                                             
			String order_line_no		=	request.getParameter("order_line_no");                                         
			String order_id				=	request.getParameter("order_id");                                              
			String patientid			=	request.getParameter("patientid"); 
			String called_from          =   request.getParameter("called_from") == null?"":request.getParameter("called_from"); // called_from Added for BSP-SCF-0033
			if(patientid == null)
				patientid			    =	request.getParameter("patient_id");

			String order_date			=	request.getParameter("order_date");                                            
			String drug_name			=	request.getParameter("drug_name");	
			String patient_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//Added here for ML-BRU-CRF-0473
			
			String from_editlabel_yn    ="N"; //Added from_editlabel_yn flag for the incident number 22383 on 29/june/2010 by Naveen S
			if(drug_name!=null)
				from_editlabel_yn="Y";

			String sShowLabels			=	request.getParameter("showLabels");                                          
			String alt_drug_flag1			=	request.getParameter("alt_drug_flag"); // added for ML-BRU-SCF-0179 [IN:032578]
			String pres_qty				=	request.getParameter("pres_qty");                                              
			String uom					=	request.getParameter("uom");                                                     
			String sCalledFrom			=	request.getParameter("CalledFrom") == null?"":request.getParameter("CalledFrom");
			String bean_id				=	"DispMedicationAllStages" ;
			String bean_name			=	"ePH.DispMedicationAllStages";

			String sDispBean			=	"DispMedicationBean" ;
			String sDispBeanName		=	"ePH.DispMedicationBean";

			boolean siteTpnStd = eCommon.Common.CommonBean.isSiteSpecific(con, "PH","TPN_STD_REGIMEN_LABEL");// added for ML-MMOH-CRF-1089
		  	boolean sitebmsApp=eCommon.Common.CommonBean.isSiteSpecific(con, "PH","BMS_REMAEKS_APP");// added for jd-crf-0221
			String sMode				=	request.getParameter("mode")== null?"":request.getParameter("mode");
			String func_mode			=	"editlabel";
			String dosage				= "";
			String caution_1			= "";
			String caution_2			= "";
			String special_1			= "";
			String special_2			= "";
			String patient_int			= "";
			String loc_caution_1		= "";
			String loc_caution_2		= "";
			String loc_special_1		= "";
			String loc_special_2		= "";
			String loc_patient_int		= "";
			String pres_rermark			= "";
			String sShowExpDate			= "";
			boolean bShowDrugCount		= false;
			String caution_id			= "";
			String special_id			= "";
			String no_of_prints         = "";//Code Added For RUT-CRF-0067 Start
			String allocQty             = "";
			String disableChk           = "N";//Code Added For RUT-CRF-0067 End
			String alt_drug_flag		= "N"; 
			String drug_desc			= "";
			String alt_drug_desc		= "";
			boolean allocQtyFlag = false; //-added forMO-GN-5434(BMS in print dailog when allocate qty is zero)
			String new_drug_indication="", drug_ind_display="";//Added for  ML-BRU-CRF-072[Inc:29938]
			DispMedicationAllStages bean = (DispMedicationAllStages)getBeanObject( bean_id, bean_name, request);
			bean.setLanguageId(locale);
			ArrayList alBMSReasons = bean.getBMSReasons(locale);//added for jd-crf-o221	
			String bmsReasonVisible = "hidden";//added for jd-crf-0221
			
			if(patientid!=null)
				bean.addPatient(patientid);//added for ML-BRU-SCF-1521.1 [IN:055331]
			DispMedicationBean dispBean = (DispMedicationBean)getBeanObject( sDispBean, sDispBean, request);
			dispBean.setLanguageId(locale);

			//String patient_name			=   bean.getPatientName(patientid);Commented on 15/Nov/2010 for the incident num:24949===By Sandhya
			String patient_name			=   dispBean.getPatient_name(patientid,locale); //Calling from Dispmedication bean.
			String pres_by				=	request.getParameter("pres_by")==null?bean.getSPerformPractId():request.getParameter("pres_by"); 
			String pract_name			=	bean.getPractitionerName(pres_by);
			String customer_id = dispBean.getCustomerID();
			String hide_exp_date_pres_qty ="";
			String allow_edit_disp_label = dispBean.getAllowEditDispLabel(); //added for Bru-HIMS-CRF-414 [IN:045554] -start
			String callLangChange		=	request.getParameter("callLangChange")==null?"":request.getParameter("callLangChange"); 
			String editLabelDisp = "display:none", nonEditLabelDisp="display:inline", editLabelPreviewDisp="display:none";
			String strIncludeZeroQty    = dispBean.getStrIncludeZeroAllocQtyItems();//Added for ML-BRU-CRF-0473
			String strIncludeZeroQtyForIP    = dispBean.getStrIncludeZeroAllocQtyItemsForIP();//Added for ML-BRU-CRF-0473
			if(allow_edit_disp_label.equals("Y")){
				editLabelDisp = "display:inline";
				nonEditLabelDisp="display:none";
				hide_exp_date_pres_qty =" style='display:none' ";
			} //added for Bru-HIMS-CRF-414 [IN:045554]-end
			HashMap hmEditLabelValues	= new HashMap();
			ArrayList DispNoAndSrlNo    = new ArrayList(); // Added for TTMWM-SCF-0184 -Start
			String disp_srl_no          ="";
			String disp_no              = "";  // Added for TTMWM-SCF-0184 -End
			int iLabelPairs				= 0;
			String sDisableAll			= "";
			String sDispStage			= dispBean.getDispStage();

			if( sMode.equals("preview")){
				sDisableAll				= "Disabled";
				if(allow_edit_disp_label.equals("Y")){
					editLabelPreviewDisp = "display:inline";
					editLabelDisp = "display:none";
					nonEditLabelDisp="display:none";
				}
			}
			if(sCalledFrom.equals("PrintDialog") && !dispBean.getBEditDispLabelAfterDisp() && (sDispStage.equals("D") || sDispStage.equals("AS")))
				sDisableAll				= "Disabled";

			ArrayList alEditLabelPairs	= new ArrayList();
			if(customer_id.equals("SRR")){
				 hide_exp_date_pres_qty =" style='display:none' ";
			}String sEnableTab				=   "N";//Added for jd-crf-0221
			System.out.println("dispBean.getDispStage()"+dispBean.getDispStage());
			System.out.println("patient_class"+patient_class);

if((dispBean.getDispStage().equals("F") ||  dispBean.getDispStage().equals("A") || dispBean.getDispStage().equals("AS") || dispBean.getDispStage().equals("D") )  && patient_class.equals("O")){	//Added for jd-crf-0221
							sEnableTab			= "Y";
							
						}
			HashMap data = null;
			ArrayList disp_nos = bean.getDispNos();//Code added For RUT-CRF-0067 Alloc quantity -ICN [IN:029605]
			ArrayList exp = null;
			ArrayList	 values	 = null;
			String allow_label_zero_copy=dispBean.getAllow_Label_Zero_Copy()==null?"N":dispBean.getAllow_Label_Zero_Copy();//Added for ML-BRU-SCF-1122 [IN:044833]
			HashMap hmAllocBmsCheck	= dispBean.getHmAllocBmsChk() == null?new HashMap():dispBean.getHmAllocBmsChk();
			boolean bKeepWindow		= false;
			boolean zeroQtyFlag = true ; // add for KAUH-SCF-001
			ArrayList alDispQtyVal = new ArrayList();
			String dispNosOrder , tempDispNos, tmpOrdId, ordId, exp_date, sHeight="0";
			//Code added For RUT-CRF-0067 Alloc quantity Start -ICN [IN:029605] 
			ArrayList orderIdList = new ArrayList();
			if(order_id != null){
				if(alt_drug_flag1.equals("Y")){ // added if condition for ML-BRU-SCF-0179 [IN:032578]
					alEditLabelPairs = bean.getAlEditLabelPairValues();
				}
				else{
					hmEditLabelValues.put("order_id",order_id);
					hmEditLabelValues.put("pres_drug_code",drug_code);
					hmEditLabelValues.put("drug_code",drug_code);
					hmEditLabelValues.put("order_line_no",order_line_no);
					hmEditLabelValues.put("ord_date_time",order_date);
					hmEditLabelValues.put("drug_name_1",drug_name);
					hmEditLabelValues.put("pres_qty",pres_qty);
					hmEditLabelValues.put("uom",uom);
					alEditLabelPairs.add(hmEditLabelValues);
					alEditLabelPairs = bean.getAlEditLabelPairValues();
				}
			}
			else{
				alEditLabelPairs = bean.getAlEditLabelPairValues();
			}
			if(alEditLabelPairs!=null && alEditLabelPairs.size()>0)
				bShowDrugCount	 = true;
			if(bShowDrugCount){
				sHeight = "500px";
				if(!sShowButtons.equals("")){
					sHeight = "350px";
				}
			}
			for(int g=0;g<alEditLabelPairs.size();g++){
				hmEditLabelValues = (HashMap)alEditLabelPairs.get(g);
				order_id = (String) hmEditLabelValues.get("order_id");
				orderIdList.add(order_id);
			}		
			if(disp_nos!=null){
				for(int q=0;q<disp_nos.size();q++){
					ordId= bean.getOrderIdForDisp((String)disp_nos.get(q),sDispStage);
					for(int h=0;h<orderIdList.size();h++){
						if(((String)orderIdList.get(h)).equals(ordId)){
							tmpOrdId = ordId+"-"+disp_nos.get(q);
							orderIdList.set(h,tmpOrdId);
						}
					}
				}
			}
			if(!allow_edit_disp_label.equals("Y") ){

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(nonEditLabelDisp));
            _bw.write(_wl_block9Bytes, _wl_block9);
	
					if(!sShowButtons.equals("")){

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

					}

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block17Bytes, _wl_block17);

								if(order_date!=null){

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(order_date,"DMYHM","en",locale)));
            _bw.write(_wl_block20Bytes, _wl_block20);

								}
								else{

            _bw.write(_wl_block21Bytes, _wl_block21);

								}

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(pract_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(sHeight));
            _bw.write(_wl_block25Bytes, _wl_block25);
                String bms_remarks_code="";//added for jd-crf-0221
                 ArrayList alBMSdtl =null;//added for jd-crf-0221
				//Code added For RUT-CRF-0067 Alloc quantity End -ICN [IN:029605] 
				for(iLabelPairs=0;iLabelPairs<alEditLabelPairs.size();iLabelPairs++){
					zeroQtyFlag = false ; // add for KAUH-SCF-001
					hmEditLabelValues = (HashMap)alEditLabelPairs.get(iLabelPairs);
					drug_code			=	(String) hmEditLabelValues.get("drug_code");
					order_line_no		=	(String) hmEditLabelValues.get("order_line_no");
					order_id			=	(String) hmEditLabelValues.get("order_id");
					order_date			=	(String) hmEditLabelValues.get("ord_date_time");
					pres_by				=	(String) hmEditLabelValues.get("order_id");
					alt_drug_flag		= 	(String) hmEditLabelValues.get("alt_drug_flag")==null?"N":(String) hmEditLabelValues.get("alt_drug_flag");   // added for ML-BRU-SCF-0179 [IN:032578]
					drug_name			=	(String) hmEditLabelValues.get("drug_name_1");	
					//added for IN073523,IN073343
					
					
					if(order_id !=null && !order_id.equals(""))
						alBMSdtl= dispBean.getNextCollectionDate(order_id);
					
					if(alBMSdtl!=null && alBMSdtl.size()>0){
						
					if( dispBean.getDispStage().equals("D")){
						bms_remarks_code=dispBean.getBmsCode(order_id, order_line_no);
					}else{
						bms_remarks_code = (String)alBMSdtl.get(1)==null?"":(String)alBMSdtl.get(1);
					}
					}
							if(sDispStage.equalsIgnoreCase("F") || sDispStage.equalsIgnoreCase("A")){
						drug_name			=	(String) hmEditLabelValues.get("drug_desc");	
					}
					drug_desc = drug_name;		// added for ML-BRU-SCF-0179 [IN:032578]
				
					if(alt_drug_flag.equals("Y")){
						drug_name			=	(String) hmEditLabelValues.get("alt_drug_desc");
					//	drug_code			=   (String) hmEditLabelValues.get("alt_drug_code");

					}
					int ordLen = order_id.length();
					tempDispNos  = (String)orderIdList.get(iLabelPairs);
					if(tempDispNos.length()!= order_id.length()){
						tempDispNos =tempDispNos.substring(0,ordLen);
						if(tempDispNos.equals(order_id)){
							dispNosOrder = ((String)orderIdList.get(iLabelPairs)).substring(ordLen+1,((String)orderIdList.get(iLabelPairs)).length());
							allocQty = bean.getDispQuantity(dispNosOrder,order_id,order_line_no,sDispStage,alt_drug_flag,drug_code);//,alt_drug_flag,drug_code added for ML-BRU-SCF-1714
							//alt_drug_flag,drug_code added for ML-BRU-SCF-1714
						}
					}
					else{
						/* if(sCalledFrom.equals("PrintDialog")){ // commented for ML-BRU-SCF-1789 - Start
							allocQty="0";
						}
						else{
							allocQty="";
							disableChk="checked";
						} */ // commented for ML-BRU-SCF-1789 - End
						
					     ArrayList alt_drug_dt = new ArrayList(); // Added for ML-BRU-SCF-1789 - Start
					     int tot_alt_qty = 0;
					
					     if(!alt_drug_flag.equals("N")){ 
					   
						    alt_drug_dt = bean.getAlternateDrugDetail(patientid,order_id,order_line_no,drug_code);
					
						    for(int i=0; i<alt_drug_dt.size(); i+=10){
							  tot_alt_qty=tot_alt_qty+(int)Double.parseDouble((String)alt_drug_dt.get(i+3)); 
						    }	
						
						 allocQty = String.valueOf(tot_alt_qty);
					     }
					    else{
					    	if(!bean.getDrugQuantity(patientid,order_id,order_line_no).equals("")){
					    	  allocQty=String.valueOf((int)Double.parseDouble(bean.getDrugQuantity(patientid,order_id,order_line_no)));
					    	}
					    } 
					     if(!sCalledFrom.equals("PrintDialog")){
					    	 disableChk="checked";
					     } // Added for ML-BRU-SCF-1789 - End
					}
				if(allocQty == null || allocQty.equals("")) // added for BSP-SCF-0029 added on 09-sep-2015 for MMS-QF-SCF-0517 [IN:057438]
					allocQty = "0";//added for BSP-SCF-0029
				if(allocQty.equals("0")){	//if block added for ICN-31165
						allocQty = bean.getTPNDispQuantity(order_id,order_line_no,sDispStage);
						if(hmAllocBmsCheck.containsKey(order_id+order_line_no)){ // add this for EMR(MO-GN-5434 [IN:043669]) - START
							zeroQtyFlag = true; // add this for KAUH-SCF-001  
							continue;
						}	
						else
							bKeepWindow = true; // add this for EMR(MO-GN-5434 [IN:043669]) - END
					}
				if(Integer.parseInt(allocQty) > 0)//added for MO-GN-5434(BMS in print dailog when allocate qty is zero)
					allocQtyFlag = true;
					//if(!allocQty.equals("")){//commented if condition for Regression -> Alpha -> PH Edit Label window blank [IN:058748] 
						if(!sCalledFrom.equals("PrintDialog")){
							drug_ind_display = "display:none";
							if(from_editlabel_yn.equals("Y")){   //Added If condition  for the incident number 22383 on 29/june/2010 
	//if else condtion newly added for ML-BRU-SCF-0179 [IN:032578]
								if(alt_drug_flag.equals("Y")){
									drug_name	=	drug_name != null? java.net.URLDecoder.decode((String) hmEditLabelValues.get("alt_drug_desc"),"UTF-8"):""; 
								}
								else{
									System.out.println("before in else  "+(String) hmEditLabelValues.get("drug_name_1"));
//									System.out.println("after in else  "+java.net.URLDecoder.decode((String) hmEditLabelValues.get("drug_name_1"),"UTF-8"));
								
								// 	drug_name =	drug_name != null? java.net.URLDecoder.decode((String) hmEditLabelValues.get("drug_name_1"),"UTF-8"):""; /* this is commented because of %(space) special character not able to decode it BSP-SCF-0029*/ 
								drug_name =	drug_name != null?(String) hmEditLabelValues.get("drug_name_1"):""; //added for BSP-SCF-0029
								}
							}
							//drug_name			=	drug_name != null? (String) hmEditLabelValues.get("drug_name_1"):"";
						}
						else{
							drug_ind_display = "display:inline";
							if(alt_drug_flag.equals("Y")){
								drug_name	=	drug_name != null? (String) hmEditLabelValues.get("alt_drug_desc"):"";
							}
							else{
								drug_name	=	drug_name != null? (String) hmEditLabelValues.get("drug_name_1"):"";
							}
							drug_desc = drug_name; //Added for ML-BRU-SCF-2223
						}
						pres_qty	=	(String) hmEditLabelValues.get("pres_qty");
						uom			=   (String) hmEditLabelValues.get("uom");
						if(hmAllocBmsCheck.containsKey(order_id+order_line_no)){
							zeroQtyFlag = true; // add this for KAUH-SCF-001  
							sEnableTab			= "Y";//added for jd-crf-0221
							continue;
						}	
						else
							bKeepWindow = true;
						no_of_prints = bean.getPrintNoOfCopies(drug_code);//Code Added For RUT-CRF-0067 Start
						exp				=	bean.getDrugDetail(patientid,order_id,order_line_no);
						exp_date				=   "";
						if(!customer_id.equals("SRR")){
							if(exp.size() > 1){
								 exp_date				=	(String)exp.get(2);
								 if(exp_date!=null && !exp_date.equals(""))
									exp_date = com.ehis.util.DateUtils.convertDate(exp_date,"DMY","en",locale);
								 sShowExpDate			= "";
							}
							else
								 sShowExpDate			= "style=display:none";
						}
						else{
						   sShowExpDate			= "style=display:none";
						}

						values	=   bean.getEditLabelValues((order_id+"_"+drug_code+"_"+order_line_no).trim()); //drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
						if(values.size()==0){
							bean.getDispEditLabeldetails(order_id,order_line_no,drug_code);  //drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
							values			=  (ArrayList) bean.getEditLabelValues((order_id+"_"+drug_code+"_"+order_line_no).trim());//drug_code newly added for ML-BRU-SCF-0179 [IN:032578]
						}
						HashMap labels				= (HashMap) bean.loadLabels();
						ArrayList	cautions		= (ArrayList) labels.get("caution");
						ArrayList	spl_instruction = (ArrayList) labels.get("spl_instruction");
						ArrayList	pres_remarks      = (ArrayList)  bean.getPrescriptionRemarks(drug_code);
						String pres_remark_code       =(String)bean.getPrescriptionRemark(order_id,order_line_no);
						if(alt_drug_flag.equals("Y")){
							new_drug_indication			= dispBean.getAlternateDrugIndication(drug_code)==null?"":dispBean.getAlternateDrugIndication(drug_code);
						}
						else{
							new_drug_indication			= dispBean.getDrugIndication(order_id,order_line_no);
						}
						//if(!new_drug_indication.equals(""))
							//new_drug_indication = java.net.URLDecoder.decode(new_drug_indication,"UTF-8"); 
						String loc_lang_from_tab      ="";
						caution_1			= "";
						loc_caution_1		= "";
						loc_lang_from_tab	= "";
						special_1			= "";
						loc_special_1		= "";
						patient_int			= "";
						loc_patient_int		= "";
						caution_id			= "";
						special_id			= "";

						if(values.size() > 0){
							//for(int i=0;i<values.size();i++){
								caution_1		= (String)values.get(0);
								//caution_2		= (String)values.get(1);
								special_1		= (String)values.get(2);
								//special_2		= (String)values.get(3);
								patient_int		= (String)values.get(4);
								loc_caution_1	= (String)values.get(5);
								//loc_caution_2	= (String)values.get(6);
								loc_special_1	= (String)values.get(7);
								//loc_special_2	= (String)values.get(8);
								loc_patient_int	= (String)values.get(9);
								pres_rermark    = (String)values.get(10);
								new_drug_indication =(String)values.get(11);//Added for  ML-BRU-CRF-072[Inc:29938] 
								loc_lang_from_tab = (String)labels.get("sec_lang_id");
							//}
						}
						else{
            // modified for ML-MMOH-CRF-1089 START
							ArrayList	instructions	=null;
						System.out.println("drug_code"+drug_code+"order_id"+order_id+"order_line_no"+order_line_no);
						
						if(dispBean.getWsType().equals("7")  && siteTpnStd){
							instructions =bean.getInstructionsSTD(drug_code,order_id,order_line_no);	
						}
						else {
							instructions=bean.getInstructions(drug_code,order_id,order_line_no);	
						}
            // modified for ML-MMOH-CRF-1089 END
							ArrayList caution = new ArrayList();
							ArrayList special = new ArrayList();
							ArrayList pat_int = new ArrayList();
							pres_rermark      =   pres_remark_code;
							if(instructions.size() > 0){
								caution	= (ArrayList)instructions.get(0);
								special	= (ArrayList)instructions.get(1);
								pat_int =   (ArrayList)instructions.get(2);
								if(caution.size()>0){	
									for(int i=0;i<caution.size();i+=3){
										caution_id		= bean.checkForNull((String)caution.get(i));	//added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										if(caution.get(i+2).equals("en")){
											 caution_1		= java.net.URLDecoder.decode((String)caution.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											 //caution_1		= bean.checkForNull((String)caution.get(i));	
										}
										else{
											 loc_caution_1	= java.net.URLDecoder.decode((String)caution.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											// loc_caution_1	= bean.checkForNull((String)caution.get(i+1));
											 loc_lang_from_tab =(String)caution.get(i+2);
										}
									}
								}

								if(special.size()>0){
									for(int i=0;i<special.size();i+=3){
										special_id		= bean.checkForNull((String)special.get(i)); //added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
										if(special.get(i+2).equals("en")){
											special_1		= java.net.URLDecoder.decode((String)special.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//special_1		= bean.checkForNull((String)special.get(i+1));
										}
										else{
											loc_special_1	= java.net.URLDecoder.decode((String)special.get(i+1),"UTF-8"); //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//loc_special_1	= bean.checkForNull((String)special.get(i+1));
											loc_lang_from_tab =(String)special.get(i+2);
									  }
								   }
								}
								if(pat_int.size()>0){
									for(int i=0;i<pat_int.size();i+=2){
										if(pat_int.get(i+1).equals("en")){
											patient_int		=java.net.URLDecoder.decode((String)pat_int.get(i),"UTF-8");  //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//patient_int		= bean.checkForNull((String)pat_int.get(i));
										}
										else{
											loc_patient_int	= java.net.URLDecoder.decode((String)pat_int.get(i),"UTF-8");  //URLDecoder added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											//loc_patient_int	= bean.checkForNull((String)pat_int.get(i));
											loc_lang_from_tab =(String)pat_int.get(i+1);
										}
									}
								}
							}
						}
						if(caution_id == null || caution_id.equals(""))
							caution_id = caution_1;
						if(special_id == null || special_id.equals(""))
							special_id = special_1;

            _bw.write(_wl_block26Bytes, _wl_block26);

							if(iLabelPairs > 0){

            _bw.write(_wl_block27Bytes, _wl_block27);
	
							}
							if(bShowDrugCount){

            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(  drug_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);

							}

            _bw.write(_wl_block31Bytes, _wl_block31);
 
									if(customer_id.equals("SRR")){

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

									}
									else{

            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

									}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(drug_desc));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(hide_exp_date_pres_qty));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
                                      if(called_from.equals("DispMedication")) // if - else condition added for BSP-SCF-0033 -Start
                                        { 

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(hide_exp_date_pres_qty));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(allocQty));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block41Bytes, _wl_block41);
                                      }
										else{

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(hide_exp_date_pres_qty));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(pres_qty));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block41Bytes, _wl_block41);

										} // if - else condition added for BSP-SCF-0033 -End
										if(Integer.parseInt(pres_qty) >Integer.parseInt(allocQty)){
											sEnableTab="Y";
											System.out.println("if sEnableTab"+sEnableTab);
										}
										else{
											
											
												sEnableTab="N";
											System.out.println("else sEnableTab"+sEnableTab);
										}
										

            _bw.write(_wl_block42Bytes, _wl_block42);
                                    if(sitebmsApp && sEnableTab.equals("Y")){
										if(alBMSReasons!=null && alBMSReasons.size()>0)
											bmsReasonVisible = "visible";
										else
											bmsReasonVisible = "hidden";

            _bw.write(_wl_block43Bytes, _wl_block43);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);

												if(alBMSReasons!=null && alBMSReasons.size()>0){
													for(int indx=0; indx<alBMSReasons.size(); indx+=2){
														System.out.println("bms_remarks_code"+bms_remarks_code);

																if(bms_remarks_code.equals((String)alBMSReasons.get(indx))){

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)alBMSReasons.get(indx)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((String)alBMSReasons.get(indx+1)));
            _bw.write(_wl_block51Bytes, _wl_block51);

													}
													else{

            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)alBMSReasons.get(indx)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((String)alBMSReasons.get(indx+1)));
            _bw.write(_wl_block51Bytes, _wl_block51);

												}

														
													}
												}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bmsReasonVisible));
            _bw.write(_wl_block54Bytes, _wl_block54);
}
										//Code Added For RUT-CRF-0067 - Start
										if(sCalledFrom.equals("PrintDialog")){
											if(no_of_prints.equals("N")){

            _bw.write(_wl_block55Bytes, _wl_block55);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block58Bytes, _wl_block58);
	
											}
											else { 

            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(allocQty));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(allocQty));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(allow_label_zero_copy));
            _bw.write(_wl_block65Bytes, _wl_block65);

											}
										}

            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(dosage));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(sShowExpDate));
            _bw.write(_wl_block68Bytes, _wl_block68);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sShowExpDate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(exp_date));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf( bean.getDrugInstructions(order_id,order_line_no)));
            _bw.write(_wl_block74Bytes, _wl_block74);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(loc_lang_from_tab));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block79Bytes, _wl_block79);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

										for(int i=0;i<cautions.size();i++){
											data = (HashMap)cautions.get(i);
											if(data!=null){
												//Changed the following variable label_text_1 to label_text_id for Incident No.28951
												if( (((String)data.get("label_text_id")).trim()).equals(caution_id) || (((String)data.get("label_text_1")).trim()).equals(caution_1))	{
												//if( (((String)data.get("label_text_id")).trim()).equals(caution_1) )	{//commented and the above line added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(data.get("label_text_id")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(data.get("label_text_1")));
            _bw.write(_wl_block51Bytes, _wl_block51);

												}	
												else{ 

            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(data.get("label_text_id")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(data.get("label_text_1")));
            _bw.write(_wl_block51Bytes, _wl_block51);
	
												}
											}
										}

            _bw.write(_wl_block82Bytes, _wl_block82);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(loc_lang_from_tab));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block85Bytes, _wl_block85);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block80Bytes, _wl_block80);

									for(int i=0;i<spl_instruction.size();i++){
										data = (HashMap)spl_instruction.get(i);
										if(data!=null){
										//Changed the following variable label_text_1 to label_text_id for Incident No.28951
											//if( (((String)data.get("label_text_id")).trim()).equals(special_1) )	{ //commented and the bellow line added for SKR-SCF-0221 ICN 29319 (SRR20056-SCF-5435)
											if( (((String)data.get("label_text_id")).trim()).equals(special_id) || (((String)data.get("label_text_1")).trim()).equals(special_1)){

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(data.get("label_text_id")));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(data.get("label_text_1")));
            _bw.write(_wl_block51Bytes, _wl_block51);

											} 
											else	{

            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(data.get("label_text_id")));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(data.get("label_text_1")));
            _bw.write(_wl_block51Bytes, _wl_block51);

											}
										}
									}

            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(patient_int));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block95Bytes, _wl_block95);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);

								String remark_selected ="";
								for(int i=0;i<pres_remarks.size();i=i+3){   
									if(pres_rermark.equals("")&& values.size()==0){
										if(pres_remarks.get(i+2).equals("Y")){
											remark_selected="selected";
										}
										else{
											remark_selected="";
										}
									}
									else {
										if( (((String)pres_remarks.get(i)).trim()).equals(pres_rermark) ){
											remark_selected="selected";
										}
										else{
											remark_selected="";
										}
									}					

            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(pres_remarks.get(i)));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(remark_selected));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(pres_remarks.get(i+1)));
            _bw.write(_wl_block51Bytes, _wl_block51);
					
								}

            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(drug_ind_display));
            _bw.write(_wl_block100Bytes, _wl_block100);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(new_drug_indication));
            _bw.write(_wl_block103Bytes, _wl_block103);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

								if(! loc_lang_from_tab.equals("ar")){

            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(loc_caution_1));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block108Bytes, _wl_block108);

								}
								else{ 

            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(loc_caution_1));
            _bw.write(_wl_block111Bytes, _wl_block111);

								}

            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);

								if(! loc_lang_from_tab.equals("ar")){

            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(loc_special_1));
            _bw.write(_wl_block116Bytes, _wl_block116);

								}
								else{

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(loc_special_1));
            _bw.write(_wl_block111Bytes, _wl_block111);

								}

            _bw.write(_wl_block118Bytes, _wl_block118);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block119Bytes, _wl_block119);

									if(! loc_lang_from_tab.equals("ar")){

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(loc_patient_int));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(drug_ind_display));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(new_drug_indication));
            _bw.write(_wl_block128Bytes, _wl_block128);

									}
									else{

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(loc_patient_int));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(drug_ind_display));
            _bw.write(_wl_block125Bytes, _wl_block125);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(new_drug_indication));
            _bw.write(_wl_block132Bytes, _wl_block132);

									}
                          DispNoAndSrlNo= bean.getDispNoAndSrlNo(drug_code, order_id, order_line_no, sDispStage); // Added for TTMWM-SCF-0184 - Start
                          if(DispNoAndSrlNo.size()>=2){
                        	  disp_no  = (String)DispNoAndSrlNo.get(0); 
                              disp_srl_no = (String)DispNoAndSrlNo.get(1); 
                          } // Added for TTMWM-SCF-0184 - End

            _bw.write(_wl_block133Bytes, _wl_block133);

						//}//commented if condition for Regression -> Alpha -> PH Edit Label window blank [IN:058748] 

            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(disp_srl_no));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(allocQty));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(allow_label_zero_copy));
            _bw.write(_wl_block149Bytes, _wl_block149);

					}

            _bw.write(_wl_block150Bytes, _wl_block150);

			}
			else if(allow_edit_disp_label.equals("Y") ){ //added for Bru-HIMS-CRF-414 [IN:045554] -start
				//String patient_class	= request.getParameter("patient_class")==null?"":request.getParameter("patient_class");//Commented heare and added above for ML-BRU-CRF-0473
				String params = request.getQueryString() ;
				String dispDate = bean.getCurrDate();
				String labelLangId = dispBean.getEditableLabelLangId();
				String sDfltLangForDispLabel	= dispBean.getDefaultLanguageForDispenseLabel(patientid);
				String sDefaultEnglish			="selected",sDefaultLocLang="";
				ArrayList langIdName = null;
				String localLang="", drug_yn="";
				StringBuffer sbDispNos = new StringBuffer(); //added for ML-BRU-SCF-1521.1 [IN:055331] -start
				if(disp_nos!=null && disp_nos.size()>0){
					for(int i=0; i<disp_nos.size();i++){
						if(i==0)
							sbDispNos.append(disp_nos.get(i));
						else
							sbDispNos.append(", "+disp_nos.get(i));
					}
				}//added for ML-BRU-SCF-1521.1 [IN:055331] -end
				if(sDfltLangForDispLabel.equals("L")){
					if((!callLangChange.equals("Y") && !sMode.equals("preview")) || labelLangId == null || labelLangId.equals("") )
						labelLangId=bean.getSMLOcalLanguageID();
					langIdName = bean.getLangNameAndId(labelLangId);
				}
				else if((!callLangChange.equals("Y") && !sMode.equals("preview") ) || labelLangId == null || labelLangId.equals(""))
					labelLangId="en";
				langIdName = bean.getDefLangForLabel(patient_class);
				if(langIdName==null || langIdName.size()==0 ){
					if(!locale.equals("en") ){
						langIdName = bean.getLangNameAndId(locale);
					}
					else{
						langIdName = bean.getLangNameAndId(bean.getSMLOcalLanguageID());
					}
				}
				else {
					if(((String)langIdName.get(0)).equals("en")){
						langIdName = bean.getLangNameAndId(bean.getSMLOcalLanguageID());
					}
				}
				if(labelLangId==null || labelLangId.equals(""))
					labelLangId = locale;
				if(labelLangId.equals("en")){
					sDefaultEnglish		=	"selected";
					sDefaultLocLang		=	"";
				}
				else{
					sDefaultEnglish		=	"";
					sDefaultLocLang		=	"selected";
				}
				dispBean.SetEditableLabelLangId(labelLangId);
				String dispQty="", dosageDtl="", instruction="", printDiagDisp="visibility:hidden", printDiagHide="display:inline", pres_drug_code="", no_of_copies=""; 
				int ordLen=0;
				if( !sMode.equals("preview")){
					if(sCalledFrom.equals("PrintDialog")){
						printDiagDisp="visibility:visible"; 
						printDiagHide="display:none"; 
					}

            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(editLabelDisp));
            _bw.write(_wl_block152Bytes, _wl_block152);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(printDiagHide));
            _bw.write(_wl_block154Bytes, _wl_block154);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(printDiagHide));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(sDefaultEnglish));
            _bw.write(_wl_block157Bytes, _wl_block157);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block51Bytes, _wl_block51);

									if(langIdName!=null && langIdName.size()>0 && !((String)langIdName.get(0)).equals("en")){
										localLang = langIdName.get(1)==null?"":(String)langIdName.get(1);

            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(langIdName.get(0)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(sDefaultLocLang));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(localLang));
            _bw.write(_wl_block51Bytes, _wl_block51);

									}

            _bw.write(_wl_block159Bytes, _wl_block159);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dispDate,"DMY","en",labelLangId)));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(sHeight));
            _bw.write(_wl_block164Bytes, _wl_block164);

								for(iLabelPairs=0;iLabelPairs<alEditLabelPairs.size();iLabelPairs++){
									zeroQtyFlag = false ; 
									dispQty="";
									dosageDtl="";
									instruction="";
									no_of_copies="";
									allocQty = ""; // Added for ML-BRU-CRF-0473   
									hmEditLabelValues = (HashMap)alEditLabelPairs.get(iLabelPairs);
									drug_code			=	(String) hmEditLabelValues.get("drug_code");
									pres_drug_code			=	(String) hmEditLabelValues.get("pres_drug_code");
									order_line_no		=	(String) hmEditLabelValues.get("order_line_no");
									order_id			=	(String) hmEditLabelValues.get("order_id");
									alt_drug_flag		= 	(String) hmEditLabelValues.get("alt_drug_flag")==null?"N":(String) hmEditLabelValues.get("alt_drug_flag");
									drug_name			=	(String) hmEditLabelValues.get("drug_desc");	
									uom			=   (String) hmEditLabelValues.get("uom");

									values	=   bean.getEditLabelValues((order_id+"_"+drug_code+"_"+order_line_no).trim());
									if(values.size()==0){
										bean.getDispEditLabeldetails(order_id,order_line_no,drug_code);
									}

									values	=   bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId );
									if(values==null || values.size()==0){
										bean.getDispEditableLabeldetails(order_id, order_line_no, pres_drug_code, drug_code, labelLangId, sDispStage, sbDispNos.toString());// sDispStage Added for ML-BRU-SCF-1521[IN:053157] //sbDispNos added for ML-BRU-SCF-1521.1 [IN:055331]
										values			=  (ArrayList) bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId);
									}
									if(values!=null && values.size()>0){
										if(pres_drug_code==null || pres_drug_code.equals(""))
											pres_drug_code			=	(String) values.get(0);	
										if(drug_code == null || drug_code.equals(""))
											drug_code			=	(String) values.get(1);	
										dispQty			=	(String) values.get(2);	
										if( values.get(3)!=null && !((String) values.get(3)).equals(""))
											uom			=	(String) values.get(3);	
										dosageDtl		=	(String) values.get(4);	
										no_of_copies	=	(String) values.get(5);	
										instruction		=	(String) values.get(6);	
										drug_yn		=	(String) values.get(7);	//added for ML-BRU-SCF-1524 [IN:053164]
									}
									drug_desc = drug_name;
									if(alt_drug_flag.equals("Y")){
										drug_name			=	(String) hmEditLabelValues.get("alt_drug_desc");
									}

									if(hmAllocBmsCheck.containsKey(order_id+order_line_no)){
										if((patient_class.equals("I") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQtyForIP.equals("Y")) || (patient_class.equals("O") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQty.equals("Y"))){//Adding start for ML-BRU-CRF-0473
										System.err.println("in new condition@@@");
										
									
												bKeepWindow = true;
									
										}else{
										       zeroQtyFlag = true; 
											   System.err.println("in else condition======");
										       continue;
										}
									}	
									else{
										bKeepWindow = true;
									}
									if(sCalledFrom.equals("PrintDialog") ){
										no_of_prints = bean.getPrintNoOfCopies(drug_code);
									}
									ordLen = order_id.length();
									tempDispNos  = (String)orderIdList.get(iLabelPairs);
									if(tempDispNos.length()!= order_id.length()){
										tempDispNos =tempDispNos.substring(0,ordLen);
										if(tempDispNos.equals(order_id)){
											dispNosOrder = ((String)orderIdList.get(iLabelPairs)).substring(ordLen+1,((String)orderIdList.get(iLabelPairs)).length());
											allocQty = bean.getDispQuantity(dispNosOrder,order_id,order_line_no,sDispStage,alt_drug_flag,drug_code);//alt_drug_flag,drug_code added for ML-BRU-SCF-1714
										}
									}
									else{
										/*if(sCalledFrom.equals("PrintDialog")){ // commented for ML-BRU-SCF-1789 - Start
											allocQty="0";
										}
										else{
											allocQty="";
										}*/ // commented for ML-BRU-SCF-1789 - End
										ArrayList alt_drug_dt = new ArrayList(); // Added for ML-BRU-SCF-1789 - Start
										int tot_alt_qty = 0;
										
										if(!alt_drug_flag.equals("N")){ 
										   
											alt_drug_dt = bean.getAlternateDrugDetail(patientid,order_id,order_line_no,drug_code);
										
											for(int i=0; i<alt_drug_dt.size(); i+=10){
												tot_alt_qty=tot_alt_qty+(int)Double.parseDouble((String)alt_drug_dt.get(i+3)); 
											}	
											
											allocQty = String.valueOf(tot_alt_qty);
										}
										else{
										  if(!bean.getDrugQuantity(patientid,order_id,order_line_no).equals("")){
											allocQty=String.valueOf((int)Double.parseDouble(bean.getDrugQuantity(patientid,order_id,order_line_no)));
										  }
										}  // Added for ML-BRU-SCF-1789 - End
									}
									if(allocQty.equals("0")){
										allocQty = bean.getTPNDispQuantity(order_id,order_line_no,sDispStage);
									}
									if(dispQty.equals(""))
										dispQty = allocQty;
									if(allocQty == null || allocQty.equals("")) // added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
										allocQty = "0";
									if(no_of_copies.equals("") && !no_of_prints.equals("N") && !no_of_prints.equals("")) // && !no_of_prints.equals("") Added for ML-BRU-SCF-1789
										no_of_copies = allocQty;
									else if(no_of_copies.equals("") && no_of_prints.equals("N")) // && no_of_prints.equals("N") Added for ML-BRU-SCF-1789
										no_of_copies = "1";

									if(Integer.parseInt(allocQty) > 0)//added for MO-GN-5434 (BMS in print dailog when allocate qty is zero)
										allocQtyFlag = true;
								if(patient_class.equals("O") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQty.equals("Y"))//Added for ML-BRU-CRF-0473
								       	  no_of_copies="0";//Added for ML-BRU-CRF-0473
								if(patient_class.equals("I") && (allocQty.equals("0") || allocQty.equals("")) && strIncludeZeroQtyForIP.equals("Y")){
									      no_of_copies="0";//Added for ML-BRU-CRF-0473
										  allocQtyFlag = true;
										  zeroQtyFlag = true;
								}


									if((!allocQty.equals("0") || (patient_class.equals("O") && strIncludeZeroQty.equals("Y"))) || (!allocQty.equals("0") || (patient_class.equals("I") && strIncludeZeroQtyForIP.equals("Y")) ) || !sCalledFrom.equals("PrintDialog")){// || strIncludeZeroQty.equals("Y")Added for ML-BRU-CRF-0473

            _bw.write(_wl_block165Bytes, _wl_block165);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(printDiagDisp));
            _bw.write(_wl_block168Bytes, _wl_block168);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(drug_name));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(printDiagDisp));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(printDiagDisp));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(allocQty));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(bean.getUomDisplay(facility_id,uom)));
            _bw.write(_wl_block175Bytes, _wl_block175);
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(printDiagDisp));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(printDiagDisp));
            _bw.write(_wl_block178Bytes, _wl_block178);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(no_of_copies));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(allocQty));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(allow_label_zero_copy));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(printDiagDisp));
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block185Bytes, _wl_block185);

											if(drug_yn.equals("Y")){

            _bw.write(_wl_block186Bytes, _wl_block186);

											}
											if(!dosageDtl.equals("")){
												dosageDtl=dosageDtl.replaceAll(" ","%20");
												dosageDtl = java.net.URLEncoder.encode(dosageDtl,"UTF-8");
												dosageDtl=dosageDtl.replaceAll("%2520"," ");

            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(dosageDtl));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block189Bytes, _wl_block189);

											}
											 DispNoAndSrlNo= bean.getDispNoAndSrlNo(drug_code, order_id, order_line_no, sDispStage); // Added for TTMWM-SCF-0184 - Start
					                          if(DispNoAndSrlNo.size()>=2){
					                        	  disp_no  = (String)DispNoAndSrlNo.get(0); 
					                              disp_srl_no = (String)DispNoAndSrlNo.get(1); 
					                          } // Added for TTMWM-SCF-0184 - End

            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(instruction));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(order_line_no));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(drug_code));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(pres_drug_code));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(uom));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(dosageDtl));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(disp_no));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(disp_srl_no));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(allocQty));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(allow_label_zero_copy));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(drug_yn));
            _bw.write(_wl_block208Bytes, _wl_block208);

									}
								}

            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(labelLangId));
            _bw.write(_wl_block210Bytes, _wl_block210);

				}
				else if( sMode.equals("preview")){

            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(sHeight));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(editLabelPreviewDisp));
            _bw.write(_wl_block213Bytes, _wl_block213);

							for(iLabelPairs=0;iLabelPairs<alEditLabelPairs.size();iLabelPairs++){
								bKeepWindow = true;
								dispQty="";
								dosageDtl="";
								instruction="";
								hmEditLabelValues = (HashMap)alEditLabelPairs.get(iLabelPairs);
								drug_code			=	(String) hmEditLabelValues.get("drug_code");
								pres_drug_code			=	(String) hmEditLabelValues.get("pres_drug_code");
								order_line_no		=	(String) hmEditLabelValues.get("order_line_no");
								order_id			=	(String) hmEditLabelValues.get("order_id");
								alt_drug_flag		= 	(String) hmEditLabelValues.get("alt_drug_flag")==null?"N":(String) hmEditLabelValues.get("alt_drug_flag");
								drug_name			=	(String) hmEditLabelValues.get("drug_desc");	
								uom			=   (String) hmEditLabelValues.get("uom");
								values	=   bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId );
								if(values==null || values.size()==0){
									bean.getDispEditableLabeldetails(order_id, order_line_no, pres_drug_code, drug_code, labelLangId, sDispStage, sbDispNos.toString());// sDispStage Added for ML-BRU-SCF-1521[IN:053157] //sbDispNos added for ML-BRU-SCF-1521.1 [IN:055331]
									values			=  (ArrayList) bean.getEditableLabelValues(order_id+"_"+drug_code+"_"+order_line_no+"_"+labelLangId);
								}
								if(values!=null && values.size()>0){
									dispQty			=	(String) values.get(2);	
									uom			=	(String) values.get(3);	
									dosageDtl		=	(String) values.get(4);	
									instruction		=	(String) values.get(6);	
									if(!dispQty.equals(""))
										dispQty = "("+dispQty+bean.getUomDisplay(facility_id,uom)+")";
								}
								drug_desc = drug_name;
								if(alt_drug_flag.equals("Y")){
									drug_name			=	(String) hmEditLabelValues.get("alt_drug_desc");
								}

            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dispDate,"DMY","en",labelLangId)));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(drug_name));
            out.print( String.valueOf(dispQty));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block220Bytes, _wl_block220);

								if(!dosageDtl.equals("")){
									dosageDtl=dosageDtl.replaceAll(" ","%20");
									dosageDtl = java.net.URLEncoder.encode(dosageDtl,"UTF-8");
									dosageDtl=dosageDtl.replaceAll("%2520"," ");

            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(dosageDtl));
            _bw.write(_wl_block223Bytes, _wl_block223);

								}
								if(!instruction.equals("")){
									instruction=instruction.replaceAll(" ","%20");
									instruction = java.net.URLEncoder.encode(instruction,"UTF-8");
									instruction=instruction.replaceAll("%2520"," ");

            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(instruction));
            _bw.write(_wl_block223Bytes, _wl_block223);

								}
							}

            _bw.write(_wl_block226Bytes, _wl_block226);

				}

            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(params ));
            _bw.write(_wl_block228Bytes, _wl_block228);

			}//Added for Bru-HIMS-CRF-414 [IN:045554] -end
			if(!bKeepWindow){

            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(zeroQtyFlag));
            _bw.write(_wl_block230Bytes, _wl_block230);

			}

            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(sShowButtons));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(sDisableAll));
            _bw.write(_wl_block115Bytes, _wl_block115);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block234Bytes, _wl_block234);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(sDispStage));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(func_mode));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(iLabelPairs));
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf(allow_edit_disp_label));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(sCalledFrom));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(allocQtyFlag));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(strIncludeZeroQtyForIP));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(strIncludeZeroQty));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block246Bytes, _wl_block246);
 
			if(alEditLabelPairs.size()==0 && sCalledFrom.equals("")){

            _bw.write(_wl_block247Bytes, _wl_block247);

			}

            _bw.write(_wl_block248Bytes, _wl_block248);

	}
	catch(Exception exception){
		exception.printStackTrace();
	}
finally{ // Added for ML-MMOH--1089 start
		
		if(con != null)
			ConnectionManager.returnConnection(con,request);	
	} // Added for ML-MMOH-crf-1089 end

            _bw.write(_wl_block249Bytes, _wl_block249);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EditLabel.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescBy.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Drug.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugDetail.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.Drug/DosageDetail.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Qty.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.BalanceMedicationRemarks.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoOfPrints.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoOfPrints.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.expiryDate.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AuxillaryInstructions.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugRemarks.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CautionaryInstructions.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.SpecialInstructions.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientInstructions.label", java.lang.String .class,"key"));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.PrescriptionRemarks.label", java.lang.String .class,"key"));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.AuxillaryInstructions.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.CautionaryInstructions.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.SpecialInstructions.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientInstructions.label", java.lang.String .class,"key"));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DrugIndications.label", java.lang.String .class,"key"));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.EditLabel.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Language.label", java.lang.String .class,"key"));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.English.label", java.lang.String .class,"key"));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DrugName.label", java.lang.String .class,"key"));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DispensedQty.label", java.lang.String .class,"key"));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.NoOfPrints.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("ePH.DosageDetail.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ph_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Instructions.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reset.label", java.lang.String .class,"key"));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ok.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
