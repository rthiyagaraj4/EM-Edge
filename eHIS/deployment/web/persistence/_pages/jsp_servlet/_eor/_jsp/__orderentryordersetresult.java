package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentryordersetresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryOrderSetResult.jsp", 1709119816000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!-- \n--------------------------------------------------------------------------------------------------------------------------\nDate       \t\tEdit History      Name        \t\t\tR.Date\t\tR.Name\t\t\t\tDescription\n----------------------------------------------------------------------------------------------------------------------------\n?             \t100            \t\t?           \t\t?\t\t\t?\t\t\t\t\tcreated\n24/10/2011    \tIN029071      \tChowminya G      \t    ?           ?                   Incident No: IN029071 -  <CRF - new rules for Discharge advice> \n25/09/2012\t\tIN030279\t\tRamesh G\t\t        ?           ?                  Bru-HIMS-CRF-160\n21/11/2012\t\tIN036347\t\tRamesh G\t\t\t\t?\t\t\t?\t\t\t\tManaged Deceased/Body Part->When cannot place Laboratory and Dietary Orders->We get script error when we click on Place Order\n13/08/2013\t    IN042045\t\tChowminya G\t       \t\t?\t\t\t?\t\t\t\tSystem should not allow to copy for the drugs for which Verbal Order Applicable is not selected\t\n01/12/2013\t\tIN038787\t\tRamesh G\t\t\t\t?\t\t\t?\t\t\t\tBru-HIMS-CRF-358\n30/11/2016\t  \tIN062319\t   Karthi L\t\t\t\t\t?\t\t\t?\t\t\t\tML-MMOH-CRF-0508.1 [IN062319]\n17/07/2018\t\tIN064543\t\tKamalakannan\t\t 17/07/2018\t\tRamesh G\t\tML-MMOH-CRF-0776\t\t\n28/02/2019  IN068370    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0014\n28/02/2019  IN068373    Dinesh T      28/02/2019    Ramesh G    PMG2018-GHL-CRF-0015\n27/05/2019\t\tIN069027\tRamesh G\t\t\t\t\t\t\t\t\t\t\tMMS-DM-CRF-0150\n05/02/2020\tIN068314\tNijitha S\t05/02/2020\tRamesh G\tML-MMOH-CRF-1229\n20/12/2022\t39892\tRamesh Goli\t\t\t\t\t\tML-MMOH-SCF-2255\n-----------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n\t<head>\n\t\t<title></title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t\t</link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryToolTip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<style> <!-- violated to show the cursor as wait -->\n\t\tA:active {\n\t\t\tCOLOR: blue;\n\t\t\tCURSOR : wait;\n\t\t}\n\t</style>\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n<form name=\"orderSetResultForm\" id=\"orderSetResultForm\" method=\"POST\" action=\"OrderEntryOrderSetResult.jsp\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<table cellpadding=0 cellspacing=0 width=\"100%\" align=\"center\">\n\t\t\t<tr>\n\t\t\t\t<!-- <td width=\"10%\" class=\"white\"></td>  -->\n\t\t\t\t<!-- <td class=\'label\'></td> -->\n\t\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n                <td width=\"20%\" class=\"white\">&nbsp;\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\"  align=\"center\">\n\t\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\t\t\t\t\t\n\t\t\t\t\t\t<td class=\"LABEL\"  width=\"20%\" onClick=\'displayToolTip(escape(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\"),escape(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\"),\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\",\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"orderSetResultForm\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\' onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\",\"orderSetResultForm\")\' onMouseOut=\"hideToolTip()\"> <font size=1 color=\"BLUE\"><!-- IN042045 included pract_type -->\n\t\t\t\t\t\t<a class=\'gridLink\' href=\'javascript:;\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t  <td class=\"LABEL\"  width=\"20%\" onMouseOver=\'showToolTip(\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\",\"orderSetResultForm\")\' onMouseOut=\"hideToolTip()\"><font size=1>\n\t\t\t\t\t\t  ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t\n\t\t\t\t\t<input type=\"hidden\" name=\"catalog_desc";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"catalog_desc";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t</font></td>\n\t\t\t\t\t<td class=\"LABEL\"  width=\"5%\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =" <!--";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="-->\n\t\t\t\t\t<!-- IN064543 Start -->\t\n\t\t\t\t\t<!--IN069027 checkDiagnosis method added-->\n\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"ck";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" id=\"ck";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" value=\"Y\" onClick=\'checkDiagnosis(\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\",this);setCheckBoxVal(this,escape(\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\"),\"orderSetResultForm\");";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="showEditor(this,\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\");";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="displayToolTipForInstructions(this,escape(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" > \n\t\t\t\t\t<!--IN064543 End-->\t\t\n\t\t\t\t\t\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" id=\"h1";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\"> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"h2";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"prompt_desc";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"prompt_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bill_warn";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" id=\"bill_warn";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bill_warn_err";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" id=\"bill_warn_err";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t\t\t\t<input type=\"hidden\" name=\"bill_error";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"bill_error";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n  \t\t\t\t\t\t<input type=\"hidden\" name=\"explanatory_text";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"explanatory_text";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"LABEL\"  width=\"3%\" >\n\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\t\t\t\t\t\t\n\t\t\t\t\t<img id=\"authorization";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\" src=\"../../eOR/images/Authorization.gif\" align=\"center\" title=\"Authorization\"></img>\n\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\t\t\t\t\t\t\n\t\t\t\t\t<img id=\"special_approval";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" src=\"../../eOR/images/SpecialApproval.gif\" align=\"center\" title=\"Special Approval\"></img>\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t</TR><TR>\n\t\t\t\t";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t<script>//alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));</script>\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t<script>//parent.result_hdr.rows =\"18%,*,*\" </script>\n\t<input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\" name=\"order_type\" id=\"order_type\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"hidden\" name=\"activity_type\" id=\"activity_type\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"order_nature\" id=\"order_nature\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"hidden\" name=\"orderable_text\" id=\"orderable_text\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"criteria\" id=\"criteria\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" name=\"display_records\" id=\"display_records\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"hidden\" name=\"restrict_by\" id=\"restrict_by\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\"hidden\" name=\"group_frame_count\" id=\"group_frame_count\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t<input type=\"hidden\" name=\"atomic_frame_count\" id=\"atomic_frame_count\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\"hidden\" name=\"profile_frame_count\" id=\"profile_frame_count\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\"hidden\" name=\"check_box_val\" id=\"check_box_val\" value=\"N\">\n\t<input type=\"hidden\" name=\"care_set_check_box_val\" id=\"care_set_check_box_val\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\t\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t<input type=\"hidden\" name=\"admission_date\" id=\"admission_date\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=\"discharge_date_time\" id=\"discharge_date_time\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t<input type=\"hidden\" name=\"order_dispaly_verticalYN\" id=\"order_dispaly_verticalYN\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"> <!--  IN038787 -->\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t\n\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t<div name=\"tooltiplayer\" id=\"tooltiplayer\" style=\"position:absolute; width:20%; visibility:hidden;\" bgcolor=\"blue\">\n\t\t<table id=\"tooltiptable\" cellpadding=0 cellspacing=0 border=\"0\" width=\"100%\"   align=\"center\">\n\t\t   \t<tr>\n\t\t \t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\t\t\n</form>\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\t\t \n\t\t\t<!-- Added BY Arvind  -->\n\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t\t<script>\n\t\t\t\t\t\tcheckFrameMembers(\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\', \'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\');\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\n\t\t\t<!-- End Here -->\n\n\t\t\t<script>\n \t\t\t\tparent.parent.criteriaMainFrame.document.addlSearchCriteriaForm.search.disabled = false;\n\t\t </script>\n\t  </body>\n</html>\n\n";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block6Bytes, _wl_block6);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
    response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
    response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085	
	String bean_id 		 		= request.getParameter("bean_id");
	String bean_name 			= request.getParameter("bean_name");
	String  order_dispaly_verticalYN			= request.getParameter("order_dispaly_verticalYN")==null?"N":(String)request.getParameter("order_dispaly_verticalYN");  //Ramesh
	/* Initialize Function specific start */
	//OrderEntryBean bean 		= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	CommonBean.setLanguageId(localeName);
	OrderEntryBean  bean		= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);

	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	// If it is a new pa tient set it, other wise get the patient id
	// orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	// boolean searched			= request.getParameter( "searched" ) == null?false : true  ;
	String order_category		= bean.checkForNull(request.getParameter("order_category"),"");
	// String p_order_category		= order_category; //Used for Care Sets
	String order_type			= bean.checkForNull(request.getParameter("order_type"),"");
	String activity_type		= bean.checkForNull(request.getParameter("activity_type"),"");
	String order_nature	= bean.checkForNull(request.getParameter("order_nature"),"");
	String order_catalog_nature	= bean.checkForNull(request.getParameter("order_catalog_nature"),"");
	String orderable_text		= bean.checkForNull(request.getParameter("orderable_text"),"");
	String criteria				= bean.checkForNull(request.getParameter("criteria"),"");
	String restrict_by			= bean.checkForNull(request.getParameter("restrict_by"),"");
	String priv_applicability_yn			= bean.checkForNull(request.getParameter("priv_applicability_yn"),"");
	
	ArrayList recArrayList = new ArrayList();
	if(request.getQueryString()!=null)
	{
		bean.setPrivApplicability(priv_applicability_yn);
	}
	priv_applicability_yn = bean.getPrivApplicability();
	String function_from			= bean.checkForNull(request.getParameter("function_from"),"");
	int group_frame_count		= Integer.parseInt(bean.checkForNull(request.getParameter("group_frame_count"),"0"));
	int atomic_frame_count		= Integer.parseInt(bean.checkForNull(request.getParameter("atomic_frame_count"),"0"));
	int profile_frame_count		= Integer.parseInt(bean.checkForNull(request.getParameter("profile_frame_count"),"0"));
	String prev_group_title 	= "";
	String group_title			= "";
	String str					= "";
	String sqlQuery				= "";

	String checkedAttribute		= "";
	String disabled				= "";
	String amend_key			= "";
	String order_catalog_category= "";
	String care_set_order		= "N";
	care_set_order=bean.checkForNull(request.getParameter("care_set_check_box_val"),"");
	String ph_install_yn		= "N";
	//int display_records			= OrRepository.DISPLAY_MIN_RECORDS;// 12 records as set in repository
	//int display_records			= Integer.parseInt(bean.checkForNull(request.getParameter("display_records"),"0"));
	//if((atomic_frame_count==0 && order_nature.equals("A")) || (profile_frame_count==0 && order_nature.equals("P")))
	int 	display_records			= OrRepository.DISPLAY_MAX_RECORDS;// 52 records as set in repository
 	String key					= (bean.getPatientId()+bean.getEncounterId());
	HashMap previousValues		= null;
	//String called_from="OH";
	//String called_from="";
	//ML-MMOH-CRF-0508.1 [IN062319] - Start
	String ord_formt_multi_chk_nonmandate_yn = bean.getMultiSelectListItemMandatYN();// ML-MMOH-CRF-0508.1 [IN062319] 
	if("Y".equals(ord_formt_multi_chk_nonmandate_yn)){
		bean.clearMultiListCompMnemonicMap();
		bean.clearMultiListCompMnemonicMapClone();
		bean.clearMultiCheckCompMnemonicList();
		bean.clearCompleteMultiCheckCompList();
		bean.clearDupeMultiCompMnemonicMapClone();
		bean.clearValidateAllMnemonicList();
		bean.clearValidateMnemonicList();
		bean.clearValidateMnemonicMap();
	}
	// ML-MMOH-CRF-0508.1 [IN062319] - End
	HashMap amendPreviousValues	= null;
	
	StringTokenizer stBillMsg	= null;
	String bill_warn_message	= null;
	String bill_warn_err_message= null;
	String bill_error_message	= null;
	String measure_id			= "", contr_msr_panel_id = ""; 
	String category				= "";
	String entryValue 			= null;
	String frm1 = "" , frm2 = "" , frm3 = "";


	ArrayList records			= null;

	Set setValues 				= null;
	Iterator iterator 	 		= null;
	String orderset_records_count = "";
	String orderSetVal = "";
	String panelVal = "";
	String individualVal  = "";
	String  panel_count			   ="";
	String individual_count	   ="";
	String p_pract_type = "";
	String l_synonym_type = ""; 
	//--[IN029071] - modified - Start
	String pat_id = bean.getPatientId(); 
	String enc_id = bean.getEncounterId();
	String discharge_adv_date_time = "";
	discharge_adv_date_time = bean.getDischargeAdvDateTime(pat_id,enc_id); 
	bean.setSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	Boolean is_ss_order_catlg_fac_wise = bean.isSiteSpecific("ORDER_CATALOG_FAC_WISE");//IN068370,IN068373
	Boolean isfppapplicable = bean.getIsfppapplicable();//IN068314
	String fpp_patient_yn = bean.getFpp_patient_yn();//IN068314
	String ss_order_catlg_fac_wise_yn =  is_ss_order_catlg_fac_wise?"Y":"N";//IN068370,IN068373
	//int rec = 0;
	
	//restrict_by=N
	if(discharge_adv_date_time == "" || discharge_adv_date_time==null){
	//sqlQuery 			= OrRepository.getOrKeyValue("SQL_OR_ORDER_ENTRY_CATALOG_ORDER_TYPE_ALL");
	
	//IN030279,IN036347 Start
	//sqlQuery 			= "SELECT  a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN042045 commented for IN064543 
	//IN068370,IN068373 Start.
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL## AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
	//ML-MMOH-SCF-2255 Start.
	//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL## AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP##  ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
	sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL## AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND (1= ( CASE WHEN GENDER IS NULL THEN 1 WHEN GENDER = ? THEN 1 ELSE 0 END )) AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,null,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP##  ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
	//ML-MMOH-SCF-2255 End.
	//IN068370,IN068373 end.
	//IN030279,IN036347 End.
	}
	else{
	//IN030279,IN036347 Start
		//sqlQuery 			= "SELECT  a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id, a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN042045 commented for IN064543 
		//IN068370,IN068373 start.
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type,a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL##  AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543//IN068314
		//ML-MMOH-SCF-2255 Start.
		//sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type,a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL##  AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND NVL(GENDER,'M')=? AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543
		sqlQuery 			= "SELECT  DISTINCT a.order_catalog_code order_catalog_code , CATALOG_SYNONYM  catalog_synonym,a.order_catalog_nature  Group_Name,a.order_category order_category,a.order_type_code order_type_code,   c.ord_auth_reqd_yn ord_auth_reqd_yn, c.ord_cosign_reqd_yn ord_cosign_reqd_yn, c.ord_spl_appr_reqd_yn ord_spl_appr_reqd_yn,a.result_applicable_yn result_applicable_yn, a.result_auth_reqd_yn result_auth_reqd_yn,a.chart_result_type chart_result_type,a.discr_msr_panel_id discr_msr_panel_id,a.contr_mod_id contr_mod_id,NVL(a.INVOKE_INSTRN_WINDOW_YN,'N')INVOKE_INSTRN_WINDOW_YN,NVL(a.instrn_content_type,'T')instrn_content_type,a.contr_msr_panel_id contr_msr_panel_id,prompt_alert_yn ,prompt_alert_msg,?,?,?,?,?,?, '*|*|*'  bill_message,   'Y'  enable_yn, a.image_link_id image_link_id, a.explanatory_text explanatory_text ##FILTERPRIV## FROM or_order_catalog_lang_vw a,or_catalog_synonym_lang_vw b,or_order_catalog_by_ptcl c,or_order_catalog_by_ptcl d  WHERE a.order_catalog_code =b.order_catalog_code AND a.order_catalog_code = c.order_catalog_code AND a.order_catalog_code = d.order_catalog_code  AND b.language_id=? AND A.LANGUAGE_ID=? ##GLOBALANDLOCAL##  AND b.catalog_synonym_type  = nvl(( select catalog_synonym_type FROM	or_ordeR_catalog_synonym               WHERE	catalog_synonym_type = ? AND    order_catalog_code   = A.ORDER_CATALOG_CODE AND eff_status ='Y'),'PR')  AND (a.dept_only_yn = 'N'  or a.dept_only_yn = 'Y'  and exists (select 1 from OR_ORD_RULE_BY_PRACT where PRACT_TYPE=? and ORDER_CATEGORY_CODE=a.order_category and PLACE_DEPT_ONLY_YN='Y' )) AND a.order_category = nvl(?,a.order_category)  AND a.order_catalog_nature = nvl(?,a.order_catalog_nature) AND (upper(b.catalog_synonym) LIKE DECODE(?,'C',Upper(?),'S',upper(?),'E',upper(?)) or upper(a.short_desc) LIKE  DECODE(?,'C',UPPER('%'||?||'%'),'S',UPPER(?||'%'),'E',UPPER('%'||?)) ) AND c.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND REVIEW_APPLICABLITY = 'A'),'*A') AND d.patient_class=Nvl((SELECT PATIENT_CLASS     			FROM OR_ORDEr_CATALOG_BY_PTCL WHERE ORDEr_CATALOG_CODE = a.order_catalog_code AND PATIENT_CLASS = ?  AND SETTING_APPLICABILITY = 'A'),'*A') AND  (D.AGE_GROUP_CODE IS NULL OR  EXISTS (SELECT 1 FROM  AM_AGE_GROUP  WHERE AGE_GROUP_CODE=D.AGE_GROUP_CODE AND (1= ( CASE WHEN GENDER IS NULL THEN 1 WHEN GENDER = ? THEN 1 ELSE 0 END )) AND TRUNC(SYSDATE)-to_date(?,'DD/MM/YYYY') BETWEEN DECODE(AGE_UNIT,'Y',365,'M',30,1)*MIN_AGE 		     AND DECODE(AGE_UNIT,'Y',365,'M',30,1)*MAX_AGE AND EFF_STATUS='E') ) AND D.SETTING_APPLICABILITY = 'A' AND a.eff_status ='E' AND a.ORDER_CATEGORY in ( select order_category from or_order_category ia where 'Y' =  OR_GET_ACCESS_RULE(?,?,ia.order_category,?,?,?,?,##MODECEASEDCON1##,##MODECEASEDCON2##,##MODECEASEDCON3##,##MODECEASEDCON4##,a.order_type_code,a.order_catalog_code,?) and  ia.order_category = nvl(?,ia.order_category))   AND 'Y' =   OR_ORDER_SET_APPLICABLE(a.order_catalog_nature,a.indexed_yn,a.order_catalog_code,?,?,?,?,?) and a.order_type_code = nvl(?, a.order_type_code)  AND nvl(a.activity_type,'!') = nvl(?,nvl(activity_type,'!')) ##FILTERCAT## ##CATCODE## ##FILTERFPP## ORDER BY Group_Name DESC, b.catalog_synonym";//IN064543
		//ML-MMOH-SCF-2255 End.
	
	//IN068370,IN068373 end.
	//IN030279,IN036347 End.
	}
	//IN030279 Start
	String p_resp_id = (String)bean.getResponsibilityId() ==null? "" :(String)bean.getResponsibilityId();
	String  medico_legal_yn =	bean.checkForNull(request.getParameter("medico_legal_yn"),"");
	String  callingFrom =	bean.checkForNull(request.getParameter("callingFrom"),"");
	
	String[] deceasRecord  = bean.getDeceasedPatientYn((String)bean.getPatientId());
	if("MO".equalsIgnoreCase(p_resp_id)){
		sqlQuery = sqlQuery.replace("##MODECEASEDCON1##","'"+p_resp_id+"'");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON2##","'"+callingFrom+"'");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON3##","'"+medico_legal_yn+"'");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON4##","'Y'");
	}else{
		sqlQuery = sqlQuery.replace("##MODECEASEDCON1##","null");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON2##","null");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON3##","null");
		sqlQuery = sqlQuery.replace("##MODECEASEDCON4##","'"+(String)deceasRecord[0]+"'");
	}	
	//IN030279 End.
	
	//--[IN029071] - modified - End
	if(restrict_by.equalsIgnoreCase("N"))
	{
			sqlQuery = sqlQuery.replace("##CATCODE##","");
	}
	else 
	{
		ph_install_yn				= bean.getModuleInstallYn("PH"); //Pass the module_id to found out whether the module has been installed or not
		if(ph_install_yn.equalsIgnoreCase("Y")) // 'PH' module has been installed
		{
				sqlQuery = sqlQuery.replace("##CATCODE##"," AND a.order_catalog_code IN (SELECT drug_code  code FROM ph_generic_name_for_service a,ph_drug b WHERE a.generic_id = b.generic_id AND a.eff_status ='E' AND service_code = ? UNION SELECT order_catalog_code  code FROM or_order_catalog_by_index WHERE service_code = ?  )");
		}
		else
		{
				sqlQuery = sqlQuery.replace("##CATCODE##"," AND a.order_catalog_code IN (SELECT order_catalog_code  code FROM or_order_catalog_by_index WHERE service_code = ?)");
		} // If 'PH' module has not been installed
	} // End of else restrict_by 'Y'
	if(priv_applicability_yn.equalsIgnoreCase("Y"))
	{
		
		sqlQuery = sqlQuery.replace("##FILTERCAT##"," and 'Y' = OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?)");
		sqlQuery = sqlQuery.replace("##FILTERPRIV##"," , OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
		
	}
	else if(priv_applicability_yn.equalsIgnoreCase("N"))
	{
		sqlQuery = sqlQuery.replace("##FILTERCAT##","");
		sqlQuery = sqlQuery.replace("##FILTERPRIV##",",  OR_GET_PRIV_APPL_YN(?,?,'OR',a.order_catalog_code,?) priv_yn");
	}
	else
	{
		sqlQuery = sqlQuery.replace("##FILTERCAT##","");
		sqlQuery = sqlQuery.replace("##FILTERPRIV##",", 'Y' priv_yn");
	}
	//IN068370,IN068373, starts
	if("Y".equals(ss_order_catlg_fac_wise_yn)){
		sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##"," AND  EXISTS (SELECT 1 FROM OR_ORDER_CATALOG_BY_FACILITY f WHERE f.ORDER_CATALOG_CODE=a.ORDER_CATALOG_CODE AND f.APPLICABLE_FACILITY_ID ='"+bean.getLoginFacilityId()+"')"); 
	}else{
		sqlQuery = sqlQuery.replace("##GLOBALANDLOCAL##","");		
	}
	//IN068370,IN068373, end.
	int i						= 0;
	if(isfppapplicable){
	if("Y".equals(fpp_patient_yn)){
		//sqlQuery = sqlQuery.replace("##FILTERFPP##","");
		sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND a.FPP_YN = 'Y' ");
	}
	else{
		sqlQuery = sqlQuery.replace("##FILTERFPP##"," AND (a.FPP_YN IS NULL OR a.FPP_YN = 'N') ");
	}
	}
	else{
		sqlQuery = sqlQuery.replace("##FILTERFPP##","");
	}
try
	{
		//Common parameters.
		HashMap sqlMap = new HashMap();
			//Include all the common parameters.
		sqlMap.put( "sqlData",sqlQuery);
		//Function Parameters
		HashMap funcMap = new HashMap();
			//Display Fields
		ArrayList displayFields = new ArrayList();

		displayFields.add( "Group_Name" );
		displayFields.add( "order_catalog_code" );
		displayFields.add( "catalog_synonym" );
		displayFields.add( "discr_msr_panel_id" );  //3
		displayFields.add( "order_category" );
		displayFields.add( "order_type_code" );
		displayFields.add( "prompt_alert_yn" );
		displayFields.add( "prompt_alert_msg" );
		displayFields.add( "ord_auth_reqd_yn" );//8
		displayFields.add( "contr_msr_panel_id" );
		displayFields.add( "ord_spl_appr_reqd_yn" );//10
		displayFields.add( "bill_message" ); //11
		displayFields.add( "enable_yn");//12
		displayFields.add( "explanatory_text");//13
		displayFields.add( "priv_yn");//13
		displayFields.add( "invoke_instrn_window_yn");//14//IN064543
		displayFields.add( "INSTRN_CONTENT_TYPE");//15//IN064543
		//Where condition put in order
		ArrayList chkFields = new ArrayList();
		//chkFields.add( bean.getPractitionerType() );
		//chkFields.add(localeName);
		chkFields.add( bean.getLoginFacilityId() );
		chkFields.add( bean.getPatientId() );
		chkFields.add( bean.getEncounterId() );
		chkFields.add( bean.getPatientClass() );

		chkFields.add( bean.getEpisodeID() );			// Episode_id
		chkFields.add( bean.getEpisodeVisitNum() );		// visit_num
		/*Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
		if((priv_applicability_yn.equalsIgnoreCase("Y"))||(priv_applicability_yn.equalsIgnoreCase("N")))
		{
			chkFields.add(bean.getPractitionerId());		//P_PRACTITIONER_ID
			chkFields.add(bean.getResponsibilityId());		//P_RESP_ID
			chkFields.add(bean.getPrivilegeApplicability());		//P_PRIV_APPL_YN
			
		}
		/*End here*/
		chkFields.add(localeName);//Added by Uma on 4/13/2010 for performance tuning
		chkFields.add(localeName);//Added by Uma on 4/13/2010 for performance tuning
		//chkFields.add( bean.getPractitionerType() );
		/*Added by Uma for performance tuning*/
		p_pract_type = (String)bean.getPractitionerType();
		if ((p_pract_type.equalsIgnoreCase("AN"))||(p_pract_type.equalsIgnoreCase("PS"))||(p_pract_type.equalsIgnoreCase("DN"))||(p_pract_type.equalsIgnoreCase("MD"))||(p_pract_type.equalsIgnoreCase ("SG"))||(p_pract_type.equalsIgnoreCase("NS"))) 
		{
			l_synonym_type = "DC" ;
		}
		else if((p_pract_type.equalsIgnoreCase("RD"))||(p_pract_type.equalsIgnoreCase("PT"))) 
		{
  			 l_synonym_type = "AD" ;
		}
		chkFields.add( l_synonym_type );
		/*Ends Here for performance tuning*/
		chkFields.add( bean.getPractitionerType() );
		chkFields.add( bean.getOrderCategoryValue() );	
		chkFields.add( order_nature );
		chkFields.add( criteria);
		chkFields.add( "%"+orderable_text+"%");
		chkFields.add( orderable_text+"%");
		chkFields.add( "%"+orderable_text);
		chkFields.add( criteria);
		chkFields.add( "%"+orderable_text+"%");
		chkFields.add( orderable_text+"%");
		chkFields.add( "%"+orderable_text);
		//chkFields.add( bean.getPatientClass() );
		//chkFields.add( bean.getPatientId() );
		//chkFields.add( bean.getSex() );					 // Sex
		//chkFields.add( bean.getVisitAdmDate() );		 //DATE_OF_BIRTH Commented this 1/8/2009 for considering the age group while placing the order by uma
		//chkFields.add( bean.getDob() );		 //DATE_OF_BIRTH 
		//chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getSex() );
		chkFields.add( bean.getDob() );

		chkFields.add( bean.getLoginFacilityId() );
		chkFields.add( bean.getEncounterId() );
		chkFields.add( bean.getPatientClass() );
		chkFields.add( bean.getVisitAdmDate() );		//ADMISSION_DATE
		chkFields.add( bean.getDischargeDateTime() );	//DISCHARGE_DATE_TIME
		if(discharge_adv_date_time != "" && discharge_adv_date_time!=null) //--[IN029071] - Start
		{
		chkFields.add( discharge_adv_date_time ); // DISCHARGE_ADVICE_DATE_TIME 
		} //--[IN029071] - End
		chkFields.add( bean.getPractitionerType() ); //IN042045
		chkFields.add( bean.getOrderCategoryValue() ); //Passing order category again
		chkFields.add( bean.getLoginFacilityId());
		chkFields.add( bean.getServiceCode());
		chkFields.add( bean.getPractitionerId());
		chkFields.add( bean.getLocationType());
		chkFields.add( bean.getLocationCode());
		//chkFields.add( bean.getLoginFacilityId());Commented by Uma for performance tuning
		chkFields.add( order_type.trim());
		chkFields.add( activity_type.trim());
		
		/*Added by Uma on 8/22/2009 for PMG20089 CRF 641*/
		if(priv_applicability_yn.equalsIgnoreCase("Y"))
		{
			chkFields.add(bean.getPractitionerId());		//P_PRACTITIONER_ID
			chkFields.add(bean.getResponsibilityId());		//P_RESP_ID
			chkFields.add(bean.getPrivilegeApplicability());		//P_PRIV_APPL_YN
			
		}	
		if(restrict_by.equalsIgnoreCase("Y"))
		{
			if(ph_install_yn.equalsIgnoreCase("Y"))			// If PH has been installed
			{
				chkFields.add( bean.getServiceCode() );
			}
			chkFields.add( bean.getServiceCode() );
		}		
		// Adding function related array list into the HashMap
		funcMap.put( "displayFields", displayFields );
		funcMap.put( "chkFields", chkFields );
		//Calling the Result from Common Adapter as an arraylist.
		ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request,display_records);
		// ArrayList result=(ArrayList)CommonBean.getQueryResultPage(sqlMap, funcMap, request,false,false);
		recArrayList.add(result.size());
		
		if((result.size()>=3) && ( !( ((String) result.get(0)).equals("0")) )){

            _bw.write(_wl_block9Bytes, _wl_block9);

				// To display the previous/next link
					out.println(result.get(1));

            _bw.write(_wl_block10Bytes, _wl_block10);
 //IN038787 Start.
			if("N".equals(order_dispaly_verticalYN)){
		
            _bw.write(_wl_block11Bytes, _wl_block11);

			}
			//IN038787 End.
		
            _bw.write(_wl_block2Bytes, _wl_block2);

				//Retrieving the records from result arraylist
				records=new ArrayList();
				
				for(int recCount=2; recCount<result.size(); recCount++) 
				{
					checkedAttribute = "";disabled= "";
					records=(ArrayList) result.get( recCount );
					
					str = bean.checkForNull( (String)records.get(0) );
					group_title = str;
					if(group_title.equalsIgnoreCase("P"))
					{						
						group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels");
						 panel_count=(String)result.get(0);					 
						panelVal = "P";					 
					}else if(group_title.equalsIgnoreCase("S"))
					{						
						group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSet.label","or_labels");	
						orderset_records_count = (String)result.get(0);	
						orderSetVal = "S";						
					}
					else if(group_title.equalsIgnoreCase("A"))
					{						
						group_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Individual.label","common_labels");	
						individual_count=(String)result.get(0);	
						individualVal  = "A";						 
					}
					if(!prev_group_title.equals(group_title))
					{	
						if("N".equals(order_dispaly_verticalYN)){  //IN038787
							if(order_nature.equals("P") || order_nature.equals("S"))
								out.println("<td colspan=\"5\" align=\"right\" class=\"CAGROUP\" >"+group_title+"</td><td colspan=\"7\" align=\"right\" class=\"CAGROUP\">("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ClickonCatalogtoViewIndividualDetails.label","or_labels")+") </td>");	   
							else
								out.println("<td colspan=\"12\" align=\"center\" class=\"CAGROUP\" >"+group_title+" </td>");
							out.println("</tr><tr>");						
							//IN038787 Start.
						}else if("Y".equals(order_dispaly_verticalYN)){
							out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");
							out.println("<tr>");					
							if(order_nature.equals("P") || order_nature.equals("S"))											
								out.println("<td colspan=\"1\" align=\"right\" class=\"CAGROUP\" >&nbsp;</td><td colspan=\"2\" align=\"center\" class=\"CAGROUP\" >"+group_title+"</td><td colspan=\"1\" align=\"right\" class=\"CAGROUP\">("+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ClickonCatalogtoViewIndividualDetails.label","or_labels")+") </td>");	   
							else
								out.println("<td colspan=\"4\" align=\"center\" class=\"CAGROUP\" >"+group_title+" </td>");
							out.println("</tr><tr>");
							out.println("<TD width='25%' valign='top'>");
							out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");						
						}
						//IN038787 End.
					}
					if(order_nature.equals("P") || order_nature.equals("S"))
					{
						contr_msr_panel_id 	= ( (String)records.get(9) );
						category     		= ( (String)records.get(4) );
						if(order_nature.equals("P")) // Pass the discrete_measure_id & contr_msr_panel_id
						{
							measure_id = ((String)records.get(3)); // discrete_measure_id
						}
						else if(order_nature.equals("S")) // Pass the catalog_code
						{
							measure_id = ( (String)records.get(1) ); // Catalog Code
						}
					} // End of If
					if(!order_nature.equals("") && (order_nature.equalsIgnoreCase("P")) || order_nature.equalsIgnoreCase("S"))
					{	//IN038787 Start.
						if("Y".equals(order_dispaly_verticalYN)){
						
            _bw.write(_wl_block12Bytes, _wl_block12);

						} //IN038787 End.
					
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(contr_msr_panel_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_nature));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(category));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_pract_type));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((String)records.get(2)));
            _bw.write(_wl_block20Bytes, _wl_block20);
	
					}
					else
					{ //IN038787 Start.
						if("Y".equals(order_dispaly_verticalYN)){
						
            _bw.write(_wl_block12Bytes, _wl_block12);

						} //IN038787 End.
					
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((String)records.get(2)));
            _bw.write(_wl_block23Bytes, _wl_block23);
	
					}  
					
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf((String)records.get(1)));
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf((String)records.get(1)));
            out.print( String.valueOf(i));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)records.get(2)));
            _bw.write(_wl_block27Bytes, _wl_block27);

					String prevValue	= "";	
					previousValues = (HashMap)orderEntryRecordBean.getCheckedEntries(key);
					if(previousValues!=null)
					{
			   			setValues 		 = previousValues.keySet();
			   			iterator 	 = setValues.iterator();
												
			   			// Till here
						for(int prev_count=0;prev_count<previousValues.size();prev_count++)
			   			{
							entryValue = bean.checkForNull(((String)iterator.next()),"") ;
							prevValue  = entryValue.substring(0,2);
							//if(!care_set_order.equalsIgnoreCase("Y")) // For the First Time, it will be "N"
							//{
								if(prevValue.equalsIgnoreCase("h1")) // For the Care Sets, to set the Order Category, there will be only one record for Care Sets at a time
								{
									care_set_order = (String)previousValues.get(entryValue) ;
									if(care_set_order.equalsIgnoreCase("CS")) // Only if it is CS
									{
										//Added By Jyothi to fix IN020587 on 09/04/2010
										bean.setTempValues("OrderSetChecked","1");
										care_set_order = "Y";
									}
								}
							//}
							if(entryValue.equalsIgnoreCase("ck"+(String)records.get(1)))
							{
								checkedAttribute = "CHECKED";
								break;
							}
							else  checkedAttribute = "";
						}
					}

					// From the query
					if(((String)records.get(12))!=null && (((String)records.get(12)).equals("Y"))) // To enable or disable the checkbox depending upon the privilege
						disabled		 = "";
					else
						disabled		 = "DISABLED";
					/*Added by Uma on 8/22/2009 for PMG20089-CRF 641*/
					if(((String)records.get(14))!=null && (((String)records.get(14)).equals("Y"))) // To enable or disable the checkbox depending upon the privilege applicability of the Ordering Practitioner
						disabled		 = "";
					else
						disabled		 = "disabled";
					/*End Here*/

					// For Amend of Review Order
					if(bean.getAmendOrder().equalsIgnoreCase("existing_order"))
					{
						amend_key			= (bean.getPatientId()+bean.getEncounterId()+bean.getOrderId());  // Unique key (For Existing Orders) to keep the Value in the Bean
						amendPreviousValues	= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
						if(amendPreviousValues!=null)
						{
							setValues 		 = amendPreviousValues.keySet();
							iterator 	 = setValues.iterator();
							for(int prev_count=0;prev_count<amendPreviousValues.size();prev_count++)
							{
								entryValue = bean.checkForNull( ((String)iterator.next()),"") ;
								if(entryValue.equalsIgnoreCase("ck"+(String)records.get(1)))
								{
									checkedAttribute = "CHECKED";
									disabled		 = "DISABLED";
									break;
								}
							}
						} // End of amendPreviousValues
					}
					if(order_nature.equals("S")) // For Care Sets
					{
						if(((String)records.get(4)).equalsIgnoreCase("PH"))
							order_catalog_category 	= ((String)records.get(4));
						else // If it is an order set
							order_catalog_category 	= "CS";
							order_category			= "CS";
						//if(checkedAttribute.equalsIgnoreCase("CHECKED"))
						if(previousValues.size() > 0)
							care_set_order 			= "Y";
					}
					else
					   order_catalog_category = ((String)records.get(4));
					// Billing Informations Retrieved
					if(((String)records.get(11))!=null)
					{
						stBillMsg	= new StringTokenizer(((String)records.get(11)),"|");
						while(stBillMsg.hasMoreTokens())
						{
							  bill_warn_message		= stBillMsg.nextToken();
							  bill_warn_err_message	= stBillMsg.nextToken();
							  bill_error_message	= stBillMsg.nextToken();
							  if(bill_warn_message.equals("*")) bill_warn_message 	= "";
							  if(bill_warn_err_message.equals("*")) bill_warn_err_message = "";
							  if(bill_error_message.equals("*")) bill_error_message 	= "";
						}
					}
					
					
            _bw.write(_wl_block28Bytes, _wl_block28);
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf((String)records.get(4)));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf((String)records.get(6)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block34Bytes, _wl_block34);

							if(order_nature.equalsIgnoreCase("A")&& ((String)records.get(15)).equals("Y"))
							{
							
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order_nature));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(category));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)records.get(16)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)records.get(2)));
            _bw.write(_wl_block36Bytes, _wl_block36);

							}else if(order_nature.equalsIgnoreCase("S")||order_nature.equalsIgnoreCase("P")){
							
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(measure_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(contr_msr_panel_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(order_nature));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(category));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(i));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_pract_type));
            _bw.write(_wl_block36Bytes, _wl_block36);

							}
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(checkedAttribute));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(disabled));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order_catalog_category));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)records.get(5)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf((String)records.get(7)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bill_warn_message));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bill_warn_err_message));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(bill_error_message));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf((String)records.get(1)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(((String)records.get(13)==null?"":(String)records.get(13))));
            _bw.write(_wl_block42Bytes, _wl_block42);
            _bw.write(_wl_block55Bytes, _wl_block55);
 		
				if(((String)records.get(8)).equalsIgnoreCase("Y")) // For Authorization Required
				{
				
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);

				}	
 				if(((String)records.get(10)).equalsIgnoreCase("Y")) // For Special Approval Required
				{
				
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);

				}	
				
            _bw.write(_wl_block60Bytes, _wl_block60);

				//IN038787 Start.
				if("Y".equals(order_dispaly_verticalYN)){
            _bw.write(_wl_block61Bytes, _wl_block61);
}
				//IN038787 End.
				
            _bw.write(_wl_block62Bytes, _wl_block62);

					i++;
					if("N".equals(order_dispaly_verticalYN)){  //IN038787 Start.
						if( i % 4 == 0)
							  out.println("</tr><tr>");
					//IN038787 Start.
					}else if("Y".equals(order_dispaly_verticalYN)){
						if(i==11||i==22||i==33){						
							out.println("</TABLE>");
							out.println("</TD>");
							out.println("<TD width='25%' valign='top'>");
							out.println("<table border='0' cellpadding='0' cellspacing='0' width='100%'  align='center'>");						
						}else if(i==44){
							out.println("</TABLE>");
							out.println("</TD>");
							out.println("</TR>");
						}
					}
					//IN038787 End.
					prev_group_title = group_title;
				} // End of for count
				
				if("N".equals(order_dispaly_verticalYN)){  //IN038787
					if( i % 4 > 0)
					{
						for (int u=0;u<4-i%4;u++)
							out.println("<td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td>");
						out.println("</tr>");
					}
					//IN038787 Start.
				}else if("Y".equals(order_dispaly_verticalYN)){
					if( i % 11 > 0)
					{
						for (int u=0;u<10-i%11;u++)
							out.println("<tr><td width=\"20%\" colspan=\"3\" align=\"left\">&nbsp;&nbsp;</td></tr>");
						out.println("</TABLE>");
						out.println("</TD>");	
						if(i<11){
							out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
							out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
							out.println("<TD width='25%' valign='top'>&nbsp;</TD>");
						}
						out.println("</TR>");
					}
				}
				//IN038787 End.
				out.println("</table>");
				out.flush();
				} 
				else
				{
				
            _bw.write(_wl_block63Bytes, _wl_block63);

				}
				
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(order_type));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(order_nature));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(orderable_text));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(criteria));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(display_records));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(restrict_by));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(group_frame_count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(atomic_frame_count));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(profile_frame_count));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(care_set_order));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean.getEncounterId()));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(bean.getVisitAdmDate()));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(bean.getDischargeDateTime()));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(order_dispaly_verticalYN));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(CommonBean.setFormTransaction(request)));
            _bw.write(_wl_block86Bytes, _wl_block86);

		//Added By Jyothi to fix IN020587 on 09/04/2010
		putObjectInBean(bean_id,bean,request);
		//End
			//out.println(CommonBean.setFormTransaction(request, "../../eOR/jsp/OrderEnterOrderSetResult.jsp", false));
	 } 
	 catch(Exception e) 
	{
		//  out.print("Exception @ Result JSP :"+e.toString());//COMMON-ICN-0181
		  e.printStackTrace();
	}

            _bw.write(_wl_block87Bytes, _wl_block87);
 	
				Integer pageVist = (Integer) session.getAttribute("pageVist")==null?0: (Integer)session.getAttribute("pageVist");
				int cnt = pageVist.intValue()+1;
				if(!orderSetVal.equals(""))
				{
					session.setAttribute("orderSetVal", orderSetVal);
				}

				if(!panelVal.equals(""))
				{
					session.setAttribute("panelVal", panelVal);
				}

				if(!individualVal.equals(""))
				{
					session.setAttribute("individualVal", individualVal);
				}			
				session.setAttribute("pageVist", new Integer(cnt));
				frm1 =(String) session.getAttribute("orderSetVal")==null?"": (String)session.getAttribute("orderSetVal");
				frm2 = (String)session.getAttribute("panelVal")==null?"": (String)session.getAttribute("panelVal");
				frm3 = (String)session.getAttribute("individualVal")==null?"": (String)session.getAttribute("individualVal");
				
				if(cnt == 3)
				{		
				
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(frm1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(frm2));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(frm3));
            _bw.write(_wl_block90Bytes, _wl_block90);

				}
				else if(!order_catalog_nature.equals(""))
				{
				
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(frm1));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(frm2));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(frm3));
            _bw.write(_wl_block90Bytes, _wl_block90);

				}
				
            _bw.write(_wl_block91Bytes, _wl_block91);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
