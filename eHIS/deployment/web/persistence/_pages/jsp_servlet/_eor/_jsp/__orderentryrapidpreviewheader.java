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

public final class __orderentryrapidpreviewheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryRapidPreviewHeader.jsp", 1709119826000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n---------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n---------------------------------------------------------------------------------------------------------\n?             100            ?           created\n\n11/08/2011\t  IN00747\t\t Chowminya\t\tIncident No: IN00747 - <Clinical comments mandatory check in Preview  screen>\n29/11/2012\t  IN031304\t\tKarthi L\t\tTo load three tier waiting list screen when RD_OA_INTEGRATION_YN param is Y and order_category is RD(IN035976) \n04/06/2013\t  IN039587\t\tNijitha S\t Alpha-ADHOC-OR-System displays \'null\' in External orders- Amend - Preview window. \n28/08/2013    IN030284\t\tChowminya\t\tjava.lang.IllegalArgumentException: Invalid format\n15/11/2013\t  IN044216\t\tVijayakumar K\tAlpha-CA-Facilty name displayed with special characters at Order Entry preview page.\n\n-------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\tRev.Date\t\tRev.Name\t\t\tDescription\n-------------------------------------------------------------------------------------------------------\n\n09/05/2016\t  IN058811\t\tRaja S\t\t\t10/05/2016\t\tRamesh G\t\tMO-CRF-20107 :National ID to be captured in any orderable \n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t(ALL Order Categories) is a national requirement.\n06/07/2018\t  IN067246\t\tRaja S\t\t\t06/07/2018\t\tRamesh G\t\tGHL-CRF-0516\n11/02/2019\tIN069657\tDinesh  T\t11/02/2019\tRamesh G\tIN069657\t\n---------------------------------------------------------------------------------------------------\n-->\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n  <head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t</link>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry1.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryPreview.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryRapidPreview.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n  </head>\n   <body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n   <form name=\"placeOrderHeaderForm\" id=\"placeOrderHeaderForm\">\n ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"3\" align=center height=\"auto\">\n\t<tr>\n\t<!-- IN044216 starts -->\n\t\t<!--<td class=\"BODYCOLORFILLED\"   colspan=5 width=\"auto\"><font size=\"1\"><b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</b></font></td>-->\n\t\t<td class=\"BODYCOLORFILLED\"   colspan=5 width=\"auto\"><font size=\"1\"><b>&nbsp;&nbsp;";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></font></td>\n\t<!-- IN044216 ends -->\t\n\t\t<td  class=\"BODYCOLORFILLED\"  width=\'auto\'><font size=\"1\"><b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</b></font></td>\n\t</tr>\n\t<table CLASS=\"BOX\" width=\'100%\' border=\'0\' cellspacing=\'0\' cellpadding=\'3\' align=center height=\'auto\'>\n\t\t<tr>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></b>\n\t\t\t</td>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\"><font size=\"1\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font>\n\t\t\t</td>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</b></font>\n\t\t\t</td>\n\t\t\t<input type=\"hidden\" name=\"order_date_time\" id=\"order_date_time\"  value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" id=\"order_date_time_href_id\">:&nbsp;<font size=\"1\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font><input type=\"hidden\" name =\"order_date_time_calendar\"  id=\"order_date_time_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"></td>\n\t\t\t<!--id=\"order_date_time_id\"<a href=\"#\" onClick=\"javascript:return changeHeaderDateTime(\'order_date_time_id\')\" title=\"OrderDateTime\"></a>-->\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></font>\n\t\t\t</td>\n\t\t\t<td class=\"BODYCOLORFILLED\"  \twidth=\"auto\"><font size=\"1\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</b></font>\n\t\t\t</td>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" id=\"priority_id\"><font size=\"1\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="<a class=\"gridLink\" href=\"javascript:changePriority(\'R\')\" title=\"Routine\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</a><a href=\"javascript:changePriority(\'U\')\" title=\"Urgent\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a><a href=\"javascript:changePriority(\'S\')\" title=\"Stat\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></font></td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\"BODYCOLORFILLED\"  width=\"auto\" nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></font>\n\t\t\t</td>\n\t\t\t<!--<td  colspan=3 class=\"BODYCOLORFILLED\"  width=\"auto\"><font size=\"1\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =",";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font>\n\t\t\t</td>\t-->\t  <!--commented for IN058811 -->\n\t\t\t<!--IN058811 starts-->\n\t\t\t<td   class=\"BODYCOLORFILLED\"  width=\"auto\"><font size=\"1\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>\n\t\t\t</td>  \n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b></font>\n\t\t\t</td>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\"><font size=\"1\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font>\n\t\t\t</td>\n\t\t\t<!--IN058811 Ends-->\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=\"BODYCOLORFILLED\"  width=\"auto\" nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td  class=\"BODYCOLORFILLED\"  width=\"auto\" valign=top nowrap><font size=\"1\"><b>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</b></font>\n\t\t\t</td>\n\t\t\t<td  colspan=3 class=\"BODYCOLORFILLED\"  width=\"auto\"><font size=\"1\"><input type=\"hidden\" name=\"header_comments\" id=\"header_comments\" value=\"\" >\t<a class=\"gridLink\"  href=\'javascript:DisplayClinicalComments(\"header_comments\",\"CLINICAL\",\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\")\' title=\'Clinical Comments\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</a></font> <!-- Modified [IN00747] -->\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<label  id=\"cl_cmt_mand\" Title=\"Clinical Comment\"  style=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"><img src=\"../../eCommon/images/mandatory.gif\"></img></label></td>\n\t\t</tr>\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n\t\t<input type=\"hidden\" name=\"authorized\" id=\"authorized\" value=\"false\">\n\t\t<input type=\"hidden\" name=\"cosigned\" id=\"cosigned\" value=\"false\">\n\t\t<input type=\"hidden\" name=\"special_approved\" id=\"special_approved\" value=\"false\">\n\n\t\t<input type=\"hidden\" name=\"future_order_date\" id=\"future_order_date\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"> \n\t\t<input type=\"hidden\" name=\"past_order_date\" id=\"past_order_date\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t\t<input type=\"hidden\" name=\"facility_name\" id=\"facility_name\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t\t<input type=\"hidden\" name=\"physician_name\" id=\"physician_name\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t\t<input type=\"hidden\" name=\"sys_date\" id=\"sys_date\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\n\t\t<input type=\"hidden\" name=\"sex\" id=\"sex\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t\t<input type=\"hidden\" name=\"age\" id=\"age\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"hidden\" name=\"dob\" id=\"dob\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t\t<input type=\"hidden\" name=\"ammend_called_from\" id=\"ammend_called_from\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t\t<input type=\"hidden\" name=\"nationality\" id=\"nationality\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t\t<input type=\"hidden\" name=\"patient_name\" id=\"patient_name\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t\t<input type=\"hidden\" name=\"location_name\" id=\"location_name\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t\t<input type=\"hidden\" name=\"auth_reqd\" id=\"auth_reqd\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t\t<input type=\"hidden\" name=\"rd_install_yn\" id=\"rd_install_yn\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t\t<input type=\"hidden\" name=\"ot_install_yn\" id=\"ot_install_yn\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t\t<input type=\"hidden\" name=\"amend_order_id\" id=\"amend_order_id\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\"> <!-- Used in OrderEntry.js to open the Modal Dialog if mandatory-->\n\t\t<input type=\"hidden\" name=\"cosign_reqd_yn\" id=\"cosign_reqd_yn\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\"> <!-- Used in to set the Cosign_reqd_yn = \'Y\' When nurse is logging in -->\n\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t\t<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"R\"><!--Routine by Default -->\n\t\t<input type=\"hidden\" name=\"format_id_mandatory_yn\" id=\"format_id_mandatory_yn\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"format_id\" id=\"format_id\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"clin_cmts_reqd_yn\" id=\"clin_cmts_reqd_yn\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t\t<input type=\"hidden\" name=\"clin_cmts_value_entered_yn\" id=\"clin_cmts_value_entered_yn\" value=\"N\">\n\t\t<input type=\"hidden\" name=\"clin_category_comments\" id=\"clin_category_comments\" value=\"N\">\t\n\t\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'>\n\t\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t<input type=\"hidden\" name=\"commentsclinic\" id=\"commentsclinic\" value=\"\">\n\t\t<input type=\"hidden\" name=\"rd_oa_integration_yn\" id=\"rd_oa_integration_yn\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\"> <!-- IN031304 -->\n\t\t<input type=\"hidden\" name=\"care_set_count\" id=\"care_set_count\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\"> <!-- IN067246 -->\n\t\t<input type=\"hidden\" name=\"total_size\" id=\"total_size\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\"> <!-- IN067246 -->\n\t\t<input type=\"hidden\" name=\"orset_ind_flag\" id=\"orset_ind_flag\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\"><!--IN067246-->\n\n";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t</form>\t\t\n\t</body>\n\n\t<script>\n\t\t//IN069657, starts\n\t\t//parent.criteriaDetailFrame.location.href=\"OrderEntryRapidPreviewRecordButtons.jsp?";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\";\n\t\tvar l_hidden_refresh;\n\t\t\n\t\tif(document.placeOrderHeaderForm.order_category)\n\t\t{\n\t\t\tvar p_order_category=document.placeOrderHeaderForm.order_category.value;\n\t\t\tl_hidden_refresh = (p_order_category!=null && p_order_category==\"CS\")?\"Y\":\"N\";\n\t\t}\n\t\t\n\t\tparent.criteriaDetailFrame.location.href=\"OrderEntryRapidPreviewRecordButtons.jsp?";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"+\"&hideRefresh=\"+l_hidden_refresh;\n\t\t//IN069657, ends\n\t\t//if(document.placeOrderHeaderForm.function_from.value==\"EXTERNAL_ORDER\" &&(document.placeOrderHeaderForm.order_category.value==\"CS\"))\n\t\tif(document.placeOrderHeaderForm.order_category)\n\t\t{\n\t\t\tvar p_order_category=document.placeOrderHeaderForm.order_category.value;\n\t\t\tvar care_set_count=document.placeOrderHeaderForm.care_set_count.value;//IN067246\n\t\t\tvar total_size=document.placeOrderHeaderForm.total_size.value;//IN067246\n\t\t\tif(p_order_category!=null)\n\t\t\t{\n\t\t\t\tif(p_order_category==\"CS\")\n\t\t\t\t{\n\t\t\t\t\t//IN067246 starts\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\"==\"true\" && \"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"==\"OP_VISIT_REG\"){\n\t\t\t\t\t\tparent.orderTabsFrame.location.href=\"OrderEntryPlaceOrderTabs.jsp?";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="&passed_from=Rapid Preview&p_order_category=\"+p_order_category+\"&total_size=\"+total_size;\n\t\t\t\t\t}\n\t\t\t\t\t//IN067246 ends\n\t\t\t\t\tparent.placeOrderDetailFrame.location.href=\"OrderEntryPlaceOrderCareSetResults.jsp?";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="&passed_from=Rapid Preview&p_order_category=\"+p_order_category;\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//IN067246 starts\n\t\t\t\t\tif(\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="&p_order_category=\"+p_order_category+\"&total_size=\"+total_size;\n\t\t\t\t\t}\n\t\t\t\t\t//IN067246 ends\n\t\t\t\t\tparent.placeOrderDetailFrame.location.href=\"OrderEntryRapidPreviewPlaceOrderResult.jsp?";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="&total_size=\"+total_size\n\t\t\t\t}\n\t\t\t}\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//IN067246 starts\n\t\t\tif(\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"==\"OP_VISIT_REG\"){\n\t\t\t\twindow.close();\n\t\t\t}else{\n\t\t\t//IN067246 ends\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"COMMON\"));\n\t\t\twindow.close();\n\t\t\t}\n\t\t}\n\t</script>\n </html>\n\n ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );
	
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


/*Added by Uma on 5/4/2010 for IN021062*/
private String decodeLocal(String field,String objVal,PageContext pageContext)
{
	String returntext="";
	if(objVal.trim().equalsIgnoreCase(""))
	{
		return	"";
	}
	if(field.equalsIgnoreCase("sex"))
	{
		if(objVal.equalsIgnoreCase("M"))
		{			
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");	
		}
		else if(objVal.equalsIgnoreCase("F"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
		}
		//IN039587 Starts
		else if(objVal.equalsIgnoreCase("U"))
		{
			returntext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
		}
		//IN039587 Ends
	}
	else
	{
		return "";
	}
	if((returntext.length()>0)&&(returntext!=null))
		return returntext;
	else
		return "";
}
/*Ends Here by Uma on 5/4/2010 for IN021062*/


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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

			 request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String bean_id					= request.getParameter("bean_id");
	String bean_name 				= request.getParameter("bean_name");
	int care_set_count=0;
	/* Mandatory checks end */
	/* Initialize Function specific start */
	//OrderEntryBean bean 			 = (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean				 = (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	String rd_oa_integration_yn = bean.getOaIntegrationKey(); // added for IN031304
	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();

	Properties properties			= (Properties) session.getValue( "jdbc" ); 
	String key						 = (bean.getPatientId()+bean.getEncounterId());  // Unique key to keep the Value in the Bean
	HashMap 	previousValues			 = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	
	String ammend_called_from		 = "";
	String function_from			 = bean.checkForNull(request.getParameter("function_from"),"");
 	String physician_name			 = "";// pract_id = "";
//	String sys_date					 = "";
	String cosign_reqd_yn			 = "N";
	String visitdate="";
	String vformat="";
	String pract_id				 	= bean.getPractitionerId();
	ArrayList locn_dtls=new ArrayList();
	if(!pract_id.equals((String)session.getValue("ca_practitioner_id")))   
		cosign_reqd_yn = "Y";
	String display_style="visibility:hidden";
	bean.setSiteSpecificYN("ORSET_IND_FOR_OPREG");//IN067246
	boolean orset_ind_flag = bean.isSiteSpecific("ORSET_IND_FOR_OPREG");//IN067246
	String called_from =bean.checkForNull(request.getParameter("called_from"),"");//IN067246

            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

 	if(function_from.equals("AMEND_ORDER")  || function_from.equals("COPY_ORDER")  || (previousValues!=null && previousValues.size()>0))
   	{
   		//SimpleDateFormat dtSystemFormat = new SimpleDateFormat("dd/MM/yyyy k:mm");
		//java.util.Date date_time	 	= new java.util.Date();
		//String dateString 			= dtSystemFormat.format(date_time);
		String dateString				= bean.getSysDate();
		String future_order_date	 	= "", past_order_date = "";
		physician_name				 	= bean.getPractitionerName();
		//	pract_id				 		= bean.getPractitionerId();
		// Query to get the values from the Header already recorded
		//String[] amendRecords 			= null;
		// Get the Future Date and the past date
		ArrayList PlaceOrderItems		= bean.getDate(dateString);
		for(int i=0; i<PlaceOrderItems.size(); i++)
		{
			String[] records 			= (String[])PlaceOrderItems.get(i);
			future_order_date	 		= records[0];
			past_order_date 	 		= records[1];
			records						= null; // Nullifying the objects
		}
		String order_category			= bean.checkForNull(request.getParameter("order_category"),"");
		String auth_reqd				 = "";
		String location_type			 = bean.checkForNull(bean.getLocationType(),"");
		String location_code			 = bean.checkForNull(bean.getLocationCode(),"");
		String location_name="";
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

	}
 //  	String order_types_comb			 = bean.checkForNull(bean.getOrderTypes(previousValues),"");  // Order Types Combination for the order_category
   	String rd_install_yn			 = "N";
	String ot_install_yn			 = "N";
   	//if(order_category.equals("RD"))
	 rd_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("RD"),"N"); // check whether the rd_module is installed or not, used in EJB
	//else if(order_category.equals("OT"))
	 ot_install_yn				= bean.checkForNull(bean.getFacilityModuleInstallYn("OT"),"N"); // check whether the ot_module is installed or not, used in EJB & order formats
   	String nationality_desc			 = "";
   	String patient_name				 = "";
	String national_id				 = ""; //IN058811
	String sex						 = (String)bean.getSex();
	sex = (String)decodeLocal("sex",sex,pageContext);
	ArrayList Nationality			 = bean.getNationality(bean.getPatientId());// Get the Nationality Desc
   	if(Nationality!=null && Nationality.size() > 0)
   	{
   	    nationality_desc = (String)Nationality.get(0);
   	    patient_name     = (String)Nationality.get(1); // Get the patient_name
		national_id		 = (String)Nationality.get(2); //IN058811
   	}
 //  	int count						 = 0;
 //  	int order_format_mandatory		 = 0;// order_format = 0;
	String clin_cmts_reqd_yn		 = bean.checkForNull(beanQueryObj.getClinicalCmtsYn(properties, order_category),"N");


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(bean.getFacilityName()));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(java.net.URLDecoder.decode(bean.getFacilityName(),"UTF-8")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(physician_name));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(!function_from.equals("MO")) { 

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
} else {

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean.getAge()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bean.getAge()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(national_id));
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(bean.getDob(),"DMY","en",localeName)));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(location_name));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

			if(clin_cmts_reqd_yn.equalsIgnoreCase("Y"))
			{
				display_style="visibility:visible";
			}
			else
			{
				display_style="visibility:hidden";
			}
			
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(display_style));
            _bw.write(_wl_block37Bytes, _wl_block37);

			Set setValues			= null;
			Iterator iterator 		= null;
			String entryValue   	= null;
			String keyItems[]		= null;
			if(previousValues!=null)		// Get the Previous Values from the Bean
			{
					setValues 			= previousValues.keySet();
					iterator 				= setValues.iterator();
					String chk_value="";
					for(int z=0;z<previousValues.size();z++)
					{
						entryValue 	 = ((String)iterator.next()) ;
						chk_value= (String)previousValues.get(entryValue);
						keyItems	 = orderEntryRecordBean.getKey(entryValue);  // Method Called from Bean to split the chk/h1 and get the value
						if( keyItems[0].equals("h1"))     // If it is a hidden (h1--denotes order_category)
						{
							order_category = (String)previousValues.get("h1"+keyItems[1]) ;
							if(order_category.equals("CS"))
							{
								care_set_count++;
							}
						}
					}
			}
			//IN067246 starts
			if(care_set_count==1)
				order_category="CS";
			if(!(orset_ind_flag && "OP_VISIT_REG".equals(called_from))){
			//IN067246 ends
			if(care_set_count>0&&previousValues.size()>3)
			{
				out.println("<script>alert(getMessage('CANNOT_PLACE_ORDER','OR'));window.close()</script>");
			}
   			}

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(future_order_date,"DMYHM","en",localeName)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(past_order_date,"DMYHM","en",localeName)));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.getFacilityName()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.getPatientId()));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(physician_name));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(dateString,"DMYHM","en",localeName)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(bean.getSex()));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getAge()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean.getDob()));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(ammend_called_from));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(bean.getLocationType()));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bean.getLocationCode()));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(nationality_desc));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(location_name));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(auth_reqd));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(rd_install_yn));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(ot_install_yn));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.getOrderId()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(cosign_reqd_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);

			visitdate=bean.getVisitAdmDate();
		if(visitdate.length()>11)
		{
			vformat="DMYHMS";
		}else
		{
			vformat="DMY";
		}

		
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(bean.getVisitAdmDate(),vformat,"en",localeName)));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(clin_cmts_reqd_yn));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(rd_oa_integration_yn));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(care_set_count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(previousValues.size()));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(orset_ind_flag));
            _bw.write(_wl_block72Bytes, _wl_block72);

		PlaceOrderItems	= null; // Nullifying the objects
		Nationality		= null;
		
	 } 
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(orset_ind_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(orset_ind_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(orset_ind_flag));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block82Bytes, _wl_block82);

	// no need to set it back persistence
	//putObjectInBean(bean_id,bean,request);

 
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderNo.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Tobegenerated.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.practitioner.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.routine.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.urgent.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.R.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.U.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.S.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NationalId.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.encounterid.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderLocation.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ClinicalComments.label", java.lang.String .class,"key"));
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
}
