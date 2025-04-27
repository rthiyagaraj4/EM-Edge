package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryplaceorderheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryPlaceOrderHeader.jsp", 1741170282000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n  <head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/></link>\n\t</link>\n\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry1.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryPreview.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n  </head>\n  <body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n   <form name=\"placeOrderHeaderForm\" id=\"placeOrderHeaderForm\">\n ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n   \t<table cellpadding=3 cellspacing=0 width=\"100%\" align=\"center\">\n  \t\t<tr>\n  \t\t\t <td id=\"hdg\" class=\"label\" colspan=\'2\'>\n\t\t\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t<!-- <label  id=\"link\"  style=\"display:none\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</label> -->\n\t\t\t\t\t\t<label  id=\\\"links1\\\"  style=\"display:none\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</label>\n\t\t\t</td>\n  \t\t\t<td id=\"imageId\" class=\"label\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n  \t\t\t<td id=\"authorizedId\" class=\"label\" align=\"left\">\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\n\t\t\t\t<label  id=\"auths\"  style=\"display\"><a class=\'gridLink\' href=\'javascript:CheckAuthorization(\"X\")\' title=\'Authorize\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</a></label><label  id=\"auth\"  style=\"display:none\">\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</label>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t </td>\n\t\t\t <td id=\"imageCosignId\" class=\"label\" align=\"left\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n  \t\t\t <td id=\"cosignId\" class=\"label\" align=\"left\" nowrap>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:CheckCosign(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\")\' title=\'Cosign\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n \t\t\t</td>\n \t\t\t<td id=\"imageSpecialId\" class=\"label\" align=\"left\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n  \t\t\t<td id=\"specialId\" class=\"label\" align=\"left\">\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:CheckSpecialApproval(\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\")\' title=\'Special Approval\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\n\t\t\t </td>\n  \t\t\t <td class=\"label\" colspan=\"4\">&nbsp;</td>\n  \t\t</tr>\n  \t\t<tr>\n  \t\t\t<td class=\"label\" style=\"width: 4%;\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n  \t\t\t<td  class=\"fields\">\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t \t\t\t<select name=\"priority\" id=\"priority\" onChange=\"setAllPriorities(this)\">\n  \t\t\t\t\t<option value=R>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\n\t    \t\t\t<option value=U>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</option>\n\t     \t\t\t<option value=S>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</option>\n\t    \t\t</select>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n  \t\t\t</td>\n  \t\t\t<td class=\"label\" >&nbsp;</td>   \n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</td>\n  \t\t\t<td  class=\"fields\"><input type=\"text\" name=\"order_date_time\" id=\"order_date_time\" size=\"16\" maxLength=\"16\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\"  ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="><input type=\"hidden\" name =\"order_date_time_calendar\" id=\"order_date_time_calendar\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\"><!--<img src=\"../../eCommon/images/CommonCalendar.gif\"  onClick=\"return showCalendar(\'order_date_time_calendar\',null,\'hh:mm\');\" style=\'cursor:pointer\'> onBlur=\"changeDateTime(this,\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\')\" --></td>\n  \t\t\t<td class=\"label\" >&nbsp;</td>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\t\t\t<td  class=\"label\">";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n  \t\t\t<td  class=\"data\"><b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</b></td>\n  \t\t\t<td class=\"label\" colspan=\'2\'>&nbsp;</td>\n\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t\t<td align=\"right\" colspan=\"4\" class=\"label\">&nbsp;</td>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n  \t\t</tr>\n  \t\t<tr>\n  \t\t\t<td  >\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t<a class=\'gridLink\' href=\'javascript:orderFormatForHeader(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\",\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\",\"\",\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\")\' title=\'Order Format\'> <!-- additional parameter \"function_from\" added for ML-MMOH-CRF-0508.1 -->\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n  \t\t\t</td>\n  \t\t\t<td class=\"label\" colspan=\"2\">&nbsp;</td>\n\n\t\t\t<td  class=\"label\"><input type=\"hidden\" name=\"header_comments\" id=\"header_comments\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" >\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =" <!--[101]--passed header_comments in place of obj-->\n\t\t\t\t<a class=\'gridLink\'  href=\'javascript:DisplayAmendComments(\"header_comments\",\"CLINICAL\",\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\")\' title=\'Clinical Comments\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</a>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<input  id=\"cl_cmt_mand\" name=\"cl_cmt_mand\"  Title=\"Clinical Comment\"  style=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"></input></td>    \n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t<a class=\'gridLink\' href=\'javascript:DisplayClinicalComments(\"header_comments\",\"CLINICAL\",\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\")\' title=\'Clinical Comments\'> ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a> <!-- [IN00747]-->\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="<label  id=\"cl_cmt_mand\" Title=\"Clinical Comment\"  style=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"><img src=\"../../eCommon/images/mandatory.gif\"></img></label></td>\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\t\t\t<td  class=\"label\" colspan=\'2\'>&nbsp;</td>\n\t\t\t<td  class=\"label\" nowrap>";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t\t<td class=\"data\"> <b>&nbsp;";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</b> </td>\n\t\t\t<td class=\"label\"  colspan=\'2\'>&nbsp;</td>\n\t\t</tr>\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<tr>\n\t\t\t <td class=\"label\" colspan=\"6\">&nbsp;</td>\n\t\t\t <td class=\"label\" >";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\t\t\t <td class=\"DATA\" align=\"left\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</td>\n\t\t\t <td class=\"label\" colspan=\"2\">&nbsp;</td>\n\t\t </tr>\n";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t</table>\n\t\t<input type=\"hidden\" name=\"authorized\" id=\"authorized\" value=\"false\">\n\t\t<input type=\"hidden\" name=\"cosigned\" id=\"cosigned\" value=\"false\">\n\t\t<input type=\"hidden\" name=\"special_approved\" id=\"special_approved\" value=\"false\">\n\n\t\t<input type=\"hidden\" name=\"future_order_date\" id=\"future_order_date\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t\t<input type=\"hidden\" name=\"past_order_date\" id=\"past_order_date\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t\t<input type=\"hidden\" name=\"physician_name\" id=\"physician_name\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\n\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t\t<input type=\"hidden\" name=\"commentsclinic\" id=\"commentsclinic\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t<input type=\"hidden\" name=\"ammend_called_from\" id=\"ammend_called_from\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t\t<input type=\"hidden\" name=\"nationality\" id=\"nationality\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\t<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t\t<input type=\"hidden\" name=\"location_name\" id=\"location_name\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t\t<input type=\"hidden\" name=\"auth_reqd\" id=\"auth_reqd\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t\t<input type=\"hidden\" name=\"rd_install_yn\" id=\"rd_install_yn\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t<input type=\"hidden\" name=\"ot_install_yn\" id=\"ot_install_yn\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t\t<input type=\"hidden\" name=\"signature_yn\" id=\"signature_yn\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t\t<input type=\"hidden\" name=\"clin_cmts_reqd_yn\" id=\"clin_cmts_reqd_yn\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t\t<input type=\"hidden\" name=\"clin_cmts_value_entered_yn\" id=\"clin_cmts_value_entered_yn\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t\t<input type=\"hidden\" name=\"amend_order_id\" id=\"amend_order_id\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"> <!-- Used in OrderEntry.js to open the Modal Dialog if mandatory-->\n\t\t<input type=\"hidden\" name=\"cosign_reqd_yn\" id=\"cosign_reqd_yn\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\"> <!-- Used in to set the Cosign_reqd_yn = \'Y\' When nurse is logging in -->\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t\t<input type=\"hidden\" name=\"order_format\" id=\"order_format\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\n\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t\t<input type=\"hidden\" name=\"rd_oa_integration_yn\" id=\"rd_oa_integration_yn\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\"> <!-- IN031304 -->\n\t\t<!--<input type=\"hidden\" name=\"order_format_onload\" id=\"order_format_onload\" value=\"Y\"> IN045512 -->\n\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n\t<script>parent.legendsFrame.location.href=\"OrderEntryLegends.jsp?";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="&order_format_mandatory=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="&order_format=";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\"</script>\n  </form>\n  </body>\n </html>\n\n";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );
	
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
--------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        Description
--------------------------------------------------------------------------------------------------------------
?             100            ?           created
28/6/2011     101            Chowminya      Incident No: IN027797 - <Mandatory flag issue in the header order format> 
11/08/2011	  IN00747		 Chowminya		Incident No: IN00747 - <Clinical comments mandatory check in Preview  screen>
29/11/2012	  IN031304		Karthi L		To load three tier waiting list screen when RD_OA_INTEGRATION_YN param is Y and order_category is RD(IN035976) 		
11/12/2013  IN045512		Nijithas	    The dependent field option is not displayed in View Order Format
21/04/2019	IN070295		Ramesh G		ML-BRU-SCF-1939
---------------------------------------------------------------------------------------------------------------
*/
	request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	//String practitioner_type = (String)session.getAttribute("practitioner_type");
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 			 = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean.setLanguageId(localeName);
	String rd_oa_integration_yn = bean.getOaIntegrationKey(); // added for IN031304
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();

	//orderEntryRecordBean.setLanguageId(localeName);
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	String key						 = (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
   	HashMap previousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
   	/*	---------Till Here------------- */
	Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
   	String ammend_called_from		 = bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_id = bean.checkForNull(request.getParameter("order_id"),"");
	if(order_id.equals(""))
		order_id=bean.getOrderId();	
	String function_from			 = bean.checkForNull(request.getParameter("function_from"),"");
	//String practitioner_id			 = bean.checkForNull(request.getParameter("practitioner_id"),"");
	//String practitioner_name			 = bean.checkForNull(request.getParameter("practitioner_name"),"");
	//String query_string				 = bean.checkForNull(request.getQueryString(),"");
   	String order_category			 = request.getParameter("order_category");
	//System.out.println("order_category="+order_category);
	String signature_yn				 = "N";	
   	//String signature_yn            = bean.getSignatureYN();
	String auth_reqd = "";
	
   	//String auth_reqd				 = bean.getAccessReqd(order_category,"auth_yn");	// Column Name. auth_yn is passed
   	String cosign_reqd				 = bean.getAccessReqd(order_category,"cosign_yn");	// Column Name. cosign_yn is passed
   	String special_approval_reqd	 = bean.getAccessReqd(order_category,"ord_spl_appr_reqd_yn");	// Column Name. auth_yn is passed
  	//String forceStatus=bean.getForceStatus(practitioner_type,order_category);
	//System.out.println("forceStatus="+forceStatus);
	//String fStatus[]=forceStatus.split(":");
	//if(fStatus[0].equals("Y"))
	//auth_reqd="X";
	//if(fStatus[1].equals("Y"))
	//cosign_reqd="X";

	String vist_admin_date =bean.getVisitAdmDate();
	
	if(vist_admin_date != null && vist_admin_date!="")
	{
	  vist_admin_date= com.ehis.util.DateUtils.convertDate(bean.getVisitAdmDate(),"DMYHM","en",localeName);
	}
	String format_id				 = "", pract_id		  ="";
   	String format_id_mandatory_yn	 = "N";
   	String physician_name			 = "";String readOnly = "READONLY";
   	//String location_type			 = bean.checkForNull(bean.getLocationType(),"");
   	//String location_code			 = bean.checkForNull(bean.getLocationCode(),"");
   	String location_name			 = "";
	/*ArrayList locn_dtls			 = new ArrayList();
	locn_dtls			 = bean.getLocationName(location_type,location_code);
	if(locn_dtls.size()>0)
	{
		for(int dtls=0;dtls<locn_dtls.size();dtls++)
		{
			String location=(String)locn_dtls.get(dtls);
			dtls++;
			String source_type       =(String)locn_dtls.get(dtls);
			if(source_type.equalsIgnoreCase("C"))
			{								
				source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(source_type.equalsIgnoreCase("N"))
			{
				source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(source_type.equalsIgnoreCase("R"))
			{
				source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}
			else if(source_type.equalsIgnoreCase("D"))
			{
				source_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels");
			}
			location_name=source_type+" / "+location;
		}

	}*/
   	String order_types_comb			 = bean.checkForNull(bean.getOrderTypes(previousValues),"");  // Order Types Combination for the order_category
   	String rd_install_yn			 = "N";
	String ot_install_yn			 = "N";
// 	if(order_category.equals("RD"))   //  IN070295 
	   rd_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
//	else if(order_category.equals("OT"))  //IN070295
	   ot_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N"); // check whether the ot_module is installed or not, used in EJB & order formats
   	String nationality_desc			 = "";
   	String patient_name				 = "";
	String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N"); // For clinical cmts to be mandatory or not.
   	ArrayList Nationality  = new ArrayList();
	//Nationality = bean.getNationality(bean.getPatientId());// Get the Nationality Desc
   	//if(Nationality!=null && Nationality.size() > 0)
   	//{
   	    //nationality_desc = (String)Nationality.get(0);
   	    //patient_name     = (String)Nationality.get(1); // Get the patient_name
   	//}
	String cosign_reqd_yn			 = "N";
  	String[] amendRecords 			 = null;
	String[] records				 = null;
 	int count						 = 0;
   	int order_format_mandatory		 = 0, order_format = 0;
	String display_style="visibility:hidden";
	//String displaying_style="visibility:hidden";
	//String displays_style="visibility:hidden";
	String displays_style1="visibility:hidden";
	String displays_style2="visibility:hidden";
	
	String clin_cmts_value_entered_yn="N";
	StringBuffer comments = new StringBuffer();
	
	//Modified by Ambiga.M on 2/3/2010 for Clinical comments issue.
	if(ammend_called_from.equalsIgnoreCase("existing_order"))
	{		
		if(bean.getAmendClinicalComments().length() > 0 )
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendClinicalComments());		
		}
		else
		{
			comments = new StringBuffer();
			comments.append(bean.getAmendComments(order_id));
		}
	}
	else
	{		
		comments				= (StringBuffer)orderEntryRecordBean.getOrderFormats(order_category+"_CLINICALCOMMENTS",order_category+"_CLINICALCOMMENTS_0");
		
		if(comments==null)
		{		
			comments 				= new StringBuffer();
		}
	}


 
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

 	if(function_from.equals("AMEND_ORDER")  || function_from.equals("COPY_ORDER")  || (previousValues!=null && previousValues.size()>0))
   	{
 		
 		//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
		//java.util.Date date_time	 	= new java.util.Date();
		//String dateString 			= dtSystemFormat.format(date_time);
		String dateString				= bean.getSysDate();
		String future_order_date	 	= "", past_order_date = "";
		physician_name				 	= bean.getPractitionerName();
		//System.out.println("physician_name=="+physician_name);
		pract_id				 		= (String)bean.getPractitionerId();
		// Query to get the values from the Header already recorded
		
		if(function_from.equals("AMEND_ORDER"))
		{
			readOnly					= "READONLY";
			ArrayList AmendPlaceOrderHeader	= bean.getAmendPlaceOrderHeader(bean.getOrderId());// Only one record will be there for the order_id
			for(int i=0; i<AmendPlaceOrderHeader.size(); i++)
			{
				amendRecords = (String[])AmendPlaceOrderHeader.get(i);
			}
			if(AmendPlaceOrderHeader != null && AmendPlaceOrderHeader.size() == 0)
			{
				//Modified by Uma on 3/12/2010 for IN019169
				amendRecords = new String[11];
				amendRecords[0] = "";
				amendRecords[1] = "";
				amendRecords[2] = "";
				amendRecords[3] = "";
			}
			dateString					= amendRecords[2];
			//Commented by Uma on 3/10/2010 for IN019713
			//physician_name				= amendRecords[3];
			//System.out.println("physician_name==="+physician_name);
			AmendPlaceOrderHeader		= null;
		}//Nullifying the objects
		//System.out.println("dateString===="+dateString);
		// Get the Future Date and the past date
		ArrayList PlaceOrderItems		= bean.getDate(dateString);

		//System.err.println("PlaceOrderItems"+PlaceOrderItems);
		for(int i=0; i<PlaceOrderItems.size(); i++)
		{
			records 			= (String[])PlaceOrderItems.get(i);
			future_order_date	 		= records[0];
			past_order_date 	 		= records[1];
		}
		PlaceOrderItems					= null;  //Nullifying the objects

            _bw.write(_wl_block8Bytes, _wl_block8);
			/*if(!order_category.equalsIgnoreCase("CS"))
				{
							
					if(!auth_reqd.equalsIgnoreCase("X") || !cosign_reqd.equalsIgnoreCase("X") || !special_approval_reqd.equalsIgnoreCase("X"))
					{  
						displays_style="visibility:visible";
						displaying_style="visibility:hidden";
					}
					else
					{
						displaying_style="visibility:visible";
						displays_style="visibility:hidden";
						}
				}*/
						
            _bw.write(_wl_block9Bytes, _wl_block9);
out.println("&nbsp;"); 
            _bw.write(_wl_block10Bytes, _wl_block10);
out.println("<b>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PressLinkto.label","or_labels")+"</b>"); 
            _bw.write(_wl_block11Bytes, _wl_block11);
if(!order_category.equalsIgnoreCase("CS"))out.println("<img id=\"textimg\" src=\"../../eOR/images/Authorization.gif\" align=\"left\" style=\"display:none\"> ");
            _bw.write(_wl_block12Bytes, _wl_block12);

			if(!order_category.equalsIgnoreCase("CS"))
			{
				if(!auth_reqd.equalsIgnoreCase("X")) 
				{
					displays_style1="visibility:visible";
					displays_style2="visibility:hidden";
				}
				else
				{
					displays_style2="visibility:visible";
					displays_style1="visibility:hidden";
				}
			}
			if(!order_category.equalsIgnoreCase("CS"))
			{
			
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Authorize.label","common_labels")+"");
            _bw.write(_wl_block15Bytes, _wl_block15);

			}
			
            _bw.write(_wl_block16Bytes, _wl_block16);
if(!order_category.equalsIgnoreCase("CS"))out.println("<img id=\"textcosignimg\" src=\"../../eOR/images/Cosign_click.gif\" align=\"right\"> ");
            _bw.write(_wl_block17Bytes, _wl_block17);

 			if(!order_category.equalsIgnoreCase("CS"))
 			{
 				if(!cosign_reqd.equalsIgnoreCase("X")) { out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CosignReqd.label","common_labels")+"");
			 } else {

            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(cosign_reqd));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 				}
 			}	
            _bw.write(_wl_block21Bytes, _wl_block21);
if(!order_category.equalsIgnoreCase("CS"))out.println("<img id=\"textspecialimg\" src=\"../../eOR/images/SpecialApproval.gif\" align=\"right\"> ");
            _bw.write(_wl_block22Bytes, _wl_block22);

 			if(!order_category.equalsIgnoreCase("CS"))
 			{
 				if(!special_approval_reqd.equalsIgnoreCase("X")) { out.println(""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecialApprovalReqd.label","common_labels")+"");
			 } else {

            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(special_approval_reqd));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
 				}
 			}	
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
			if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
			{
				if(amendRecords[1].equalsIgnoreCase("R")) out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+"");
				else if(amendRecords[1].equalsIgnoreCase("U")) out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels")+"");
				else out.println(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels")+"");
				out.println("<input type=\"hidden\" name=\"priority\" id=\"priority\" value='"+amendRecords[1]+"'>");
			}
			else
			{

            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
			} 
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(readOnly));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block36Bytes, _wl_block36);

		if(bean.getAttendPractitionerName()!=null && (!bean.getAttendPractitionerName().equals("")) && (!bean.getEncounterId().equals("")))
		{
	
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(bean.getAttendPractitionerName()));
            _bw.write(_wl_block39Bytes, _wl_block39);
	}	else  { 
            _bw.write(_wl_block40Bytes, _wl_block40);
	}	
            _bw.write(_wl_block41Bytes, _wl_block41);

 			if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
 			{
 				count 				= bean.getFormatAmendCount(bean.getOrderId(),"");
 				order_types_comb	= "'"+bean.checkForNull(bean.getAmendOrderType(),"")+"'";
 			}
			if((count<=0 || !bean.getAmendOrder().equalsIgnoreCase("existing_order")) && !order_category.equalsIgnoreCase("CS"))
 			{
				format_id = bean.checkForNull(bean.getFormatIdHdr(order_category,order_types_comb,bean.getSex(), bean.getDob()),"");
				if(!format_id.trim().equals("") )
 				{
 					StringTokenizer stFormat = new StringTokenizer(format_id,"~");
 					while(stFormat.hasMoreTokens())
 					{
 						format_id_mandatory_yn	 	= bean.checkForNull(stFormat.nextToken(),"N");
 						format_id 	 	 			= bean.checkForNull(stFormat.nextToken(),"");
 					}
				}
 			} // End of bean.getAmendOrder()

 			if(!format_id.equals("") || count!=0)
 			{
				//---[101]/start--- commented
				//if(bean.getAmendOrder().equalsIgnoreCase("existing_order") && previousValues!=null && previousValues.size() > 0 )
					//format_id_mandatory_yn = "Y";
				//---[101]/end--- commented	

            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(java.net.URLEncoder.encode(format_id)));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bean.getOrderId()));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block45Bytes, _wl_block45);

 			} // End of if format_id
 			if(!format_id.equals("") || count!=0)
 			{
				if(format_id_mandatory_yn!=null && format_id_mandatory_yn.equalsIgnoreCase("Y"))
 				{
 					order_format_mandatory++;
					out.println("<img src='../../eOR/images/Flex_red.gif' align='center'></img></a>");
					out.println("<input type='hidden' name='format_id_yn' id='format_id_yn' value='N'>");
 					ArrayList arrSeqNo = (ArrayList) orderEntryRecordBean.getOrderFormats(order_category, order_category+"_0");
					if(arrSeqNo!=null && arrSeqNo.size()>0 && (!bean.getAmendOrder().equalsIgnoreCase("existing_order")) )
						out.println("<script>setOrderFormat('Y');</script>");
 	     		}else{
					order_format++;
 					out.println("<img src='../../eOR/images/Flex_blue.gif' align='center'></img></a>");
 					out.println("<input type='hidden' name='format_id_yn' id='format_id_yn' value='Y'>");
 				}
 			}
 			else
 				out.println("<input type='hidden' name='format_id_yn' id='format_id_yn' value='Y'>");
			out.println("<input type='hidden' name='format_id_mandatory_yn' id='format_id_mandatory_yn' value='"+format_id_mandatory_yn+"'>");
			out.println("<input type='hidden' name='format_id' id='format_id' value='"+format_id+"'>");

 
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(comments));
            _bw.write(_wl_block47Bytes, _wl_block47);

			if(bean.getAmendOrder().equalsIgnoreCase("existing_order")) 
			{ 
				StringBuffer ammend_comment=bean.getAmendComments((String)bean.getOrderId());
				if(ammend_comment!=null && ammend_comment.length()>0)
				{
					clin_cmts_value_entered_yn="Y";
				}
				
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.getOrderId()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
if(clin_cmts_reqd_yn.equals("Y")){display_style="visibility:visible";}else{display_style="visibility:hidden";}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(display_style));
            _bw.write(_wl_block52Bytes, _wl_block52);
 } else { 
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
if(clin_cmts_reqd_yn.equals("Y")){display_style="visibility:visible";}else{display_style="visibility:hidden";}
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(display_style));
            _bw.write(_wl_block57Bytes, _wl_block57);
            _bw.write(_wl_block58Bytes, _wl_block58);
 } 
            _bw.write(_wl_block59Bytes, _wl_block59);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean.getPractitionerLocale(pract_id)));
            _bw.write(_wl_block61Bytes, _wl_block61);
//System.out.println("=pract_id="+pract_id);
            _bw.write(_wl_block62Bytes, _wl_block62);
//System.out.println("=ca_practitioner_id="+(String)session.getValue("ca_practitioner_id"));
            _bw.write(_wl_block1Bytes, _wl_block1);
	if(!pract_id.equals((String)session.getValue("ca_practitioner_id"))) {  
		cosign_reqd_yn = "Y";

            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(bean.getPractitionerLocale((String)session.getValue("ca_practitioner_id"))));
            _bw.write(_wl_block65Bytes, _wl_block65);
	} 
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(future_order_date,"DMYHM","en",localeName)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(past_order_date,"DMYHM","en",localeName)));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean.getFacilityName()));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(physician_name));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(bean.getSex()));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(bean.getAge()));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(comments));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean.getDob()));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(ammend_called_from));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bean.getLocationType()));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(bean.getLocationCode()));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(location_name));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(auth_reqd));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(rd_install_yn));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(ot_install_yn));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(signature_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(clin_cmts_reqd_yn));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(clin_cmts_value_entered_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(bean.getOrderId()));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(cosign_reqd_yn));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(order_format));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(vist_admin_date));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(rd_oa_integration_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
 } 
			// Nullifying the Objects
			//previousValues	= null;	// Nullifying the Objects
			//Nationality		= null;	amendRecords	= null; records = null;

			// no need to set it back persistence
			//putObjectInBean(bean_id,bean,request);
	
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(order_format_mandatory));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(order_format));
            _bw.write(_wl_block103Bytes, _wl_block103);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Authorize.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cosign.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SpecialApproval.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Stat.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDateTime.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.AttendPractitioner.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderingPractitioner.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderingBy.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
