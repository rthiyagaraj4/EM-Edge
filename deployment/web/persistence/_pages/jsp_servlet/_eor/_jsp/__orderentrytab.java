package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.util.*;
import eOR.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __orderentrytab extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryTab.jsp", 1731668052000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n-----------------------------------------------------------------------\nDate       \t\tEdit History   Name       Description\n-----------------------------------------------------------------------\n?             \t100         ?          \tcreated\n23/01/2012    \tIN030563    Ramesh G\tThe Pin No. for placing ordering is selected as Logged in Practitioner s Pin ? \n\t\t\t\t\t\t\t\t\t\tPrompt once for all categories. \t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\tBut the Pin No. is prompted each time we Place a Category and also when we record the category.\n\n25/01/2012\t\tIN030566\tRamesh G\tWhen we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.\t\t\t\t\t\t\t\t  \n25/09/2012\t\tIN030279\tRamesh G\tBru-HIMS-CRF-160 \n22/03/2013\t\tIN030469\tDineshT\t\tOrder Entry Place order screen to show catalogs on load\n13/06/2013\t\tIN038776\tRamesh G\tThis is a child cr for  MMS-QH-CRF- 0042 to cover the Billing related changes\n27/05/2019\t\tIN069027\tRamesh G\t\t\t\t\t\t\t\tMMS-DM-CRF-0150\n31/05/2023\t\t44884\t\tKrishna\t\tMO-CRF-20183\n-----------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head><title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/></link>\n \t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryTab.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntrySearch.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntry1.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryRapidPreview.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eOR/js/OrderEntryGlobal.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<script>\n\t\t//var check_box_val\t= new Array(); //Global Variable, used to keep track of the code selected(order wise)\n\t</script>\n\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<STYLE>\t<!-- override the color from the IeStyle.css -->\n\t\tTD.OR_PLACEORDER \n\t\t{\n\t\t\tcolor:BLACK;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tbackground-color:#C0C0C0;\n\t\t\tborder-width: thin ;\n\t\t\tborder-style: double ;\n\t\t\tBORDER-LEFT-COLOR: RED;\n\t\t\tBORDER-RIGHT-COLOR: RED;\n\t\t\tBORDER-TOP-COLOR: RED;\n\t\t\tBORDER-BOTTOM-COLOR: RED ;\n\t\t}\n\t</STYLE>\n</head>\n \n\t<body OnMouseDown=\"CodeArrest()\"; onKeyDown=\"lockKey()\">\n \t<form name=\"formTab\" id=\"formTab\" >\n\t<table id=\"tab\" cellspacing=0 cellpadding=\"0\" border=\"0\">\n\t<tr>\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\t \t\n\t\t\t\t\t<td id=\"frequentOrders\" class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"display(this)\" nowrap><a  style=\'color:white;cursor:pointer\' href=\"javascript:change_tab(\'FrequentOrders\')\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a></td>\n\t\t\t \n \n\t\t\t \n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t<td id=\"additionalSearch\" class=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"display(this)\" nowrap><a  style=\'color:white;cursor:pointer\' href=\"javascript:change_tab(\'AdditionalSearch\')\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t<td id=\"tickSheet\" class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"display(this)\" nowrap><a style=\'color:white;cursor:pointer\'  href=\"javascript:change_tab(\'TickSheet\')\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t<td id=\"image\" class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"display(this)\" nowrap><a  style=\'color:white;cursor:pointer\' href=\"javascript:change_tab(\'Image\')\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</a></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t<td id=\"careSet\"  class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\" onclick=\"display(this)\" nowrap><a style=\'color:white;cursor:pointer\' href=\"javascript:change_tab(\'CareSet\')\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\n\t\t\t\t\t<td id=\"placeOrder\"\t class=\"OR_PLACEORDER\"  onMouseOver=\"callOnMouseOver(this);\" onMouseOut=\"callOnMouseOut(this);\"  nowrap>\n\t\t\t\t\t<a style=\'color:white;cursor:pointer\' href=\"javascript:checkPharmacy(this)\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</a></td> <!--IN030469--><!--IN069027 checkPharmacy method added-->\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<td id=\"patientDetails\" class=\"LABEL\"><b>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</b></td>\t\t\t\n\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td id=\"empty_tab\" colspan=\"6\" width=\"60%\" >&nbsp;</td>\n\t\t\t<td id=\"bloodTransfusion\" width=\"22%\"  class=\"EMERGENT\" align=\"right\" ><a style=\'color:white;cursor:pointer\' href=\"javascript:callBloodHistory()\" title=\"Blood Transfusion\" COLOR=\"BLUE\"><font size=\"1\"><b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b></font></a></td> \n\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\n\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'FrequentOrders\'>\n\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t<input type=\'hidden\' name=\'flag\' id=\'flag\' value=\'AdditionalSearch\'>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\t\t\n\t</tr>\n\t</table>\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<!-- IN030279 Start -->\n\t<input type=\"hidden\" name=\"deceased_yn\" id=\"deceased_yn\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\" name=\"medico_legal_yn\" id=\"medico_legal_yn\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\"hidden\" name=\"callingFrom\" id=\"callingFrom\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\"hidden\" name=\"postmortem_status\" id=\"postmortem_status\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\"hidden\" name=\"body_part_yn\" id=\"body_part_yn\" value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\"hidden\" name=\"registration_no\" id=\"registration_no\" value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<!-- IN030279 End. -->\n   \t<input type=\"hidden\" name=\"ammend_called_from\" id=\"ammend_called_from\" value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n   \t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"bed_num\" id=\"bed_num\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"room_num\" id=\"room_num\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"pract_reln_id\" id=\"pract_reln_id\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" name=\"p_called_from_ca\" id=\"p_called_from_ca\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"Sex\" id=\"Sex\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" name=\"Age\" id=\"Age\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<input type=\"hidden\" name=\"Dob\" id=\"Dob\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\"hidden\" name=\"licence_key\" id=\"licence_key\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\"hidden\" name=\"order_mode\" id=\"order_mode\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\" name=\"bt_module_install\" id=\"bt_module_install\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\"hidden\" name=\"p_order_catalog_code\" id=\"p_order_catalog_code\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"hidden\" name=\"p_start_date_time\" id=\"p_start_date_time\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"p_task_code\" id=\"p_task_code\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"hidden\" name=\"p_task_srl_no\" id=\"p_task_srl_no\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"ck";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" id=\"ck";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" value=\"Y\">\t<!--catalog_code-->\n\t<input type=\"hidden\" name=\"h1";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" id=\"h1";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\"><!--exist_order_category-->\n\t<input type=\"hidden\" name=\"h2";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"h2";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"><!--exist_order_type_code-->\n\t\n\t<input type=\"hidden\" name=\"exist_activity_type_code\" id=\"exist_activity_type_code\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\"hidden\" name=\"exist_activity_type_desc\" id=\"exist_activity_type_desc\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" name=\"existing_order_called_from\" id=\"existing_order_called_from\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type=\"hidden\" name=\"multi_called_from\" id=\"multi_called_from\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t<input type=\"hidden\" name=\"reject_order\" id=\"reject_order\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=\"ph_instal_yn\" id=\"ph_instal_yn\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t<!-- 44884 Start. -->\n\t<input type=\"hidden\" name =\"practitionerRel\" id =\"practitionerRel\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSMI\" id =\"restBfrPlaceOrderSMI\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSOT\" id =\"restBfrPlaceOrderSOT\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSCN\" id =\"restBfrPlaceOrderSCN\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSLB\" id =\"restBfrPlaceOrderSLB\" value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSTR\" id =\"restBfrPlaceOrderSTR\" value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSPC\"  id =\"restBfrPlaceOrderSPC\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSPH\"  id =\"restBfrPlaceOrderSPH\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSNC\" id =\"restBfrPlaceOrderSNC\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSDS\" id =\"restBfrPlaceOrderSDS\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSRX\" id =\"restBfrPlaceOrderSRX\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSRD\"  id =\"restBfrPlaceOrderSRD\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSCS\" id =\"restBfrPlaceOrderSCS\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\t\t\t\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderSOH\"  id =\"restBfrPlaceOrderSOH\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFMI\" id =\"restBfrPlaceOrderFMI\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFOT\" id =\"restBfrPlaceOrderFOT\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFCN\" id =\"restBfrPlaceOrderFCN\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFLB\"  id =\"restBfrPlaceOrderFLB\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFTR\" id =\"restBfrPlaceOrderFTR\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFPC\"   id =\"restBfrPlaceOrderFPC\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFPH\"  id =\"restBfrPlaceOrderFPH\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFNC\" id =\"restBfrPlaceOrderFNC\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFDS\" id =\"restBfrPlaceOrderFDS\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFRX\"  id =\"restBfrPlaceOrderFRX\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFRD\" id =\"restBfrPlaceOrderFRD\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFCS\"  id =\"restBfrPlaceOrderFCS\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\t\t\t\n\t<input type=\"hidden\" name =\"restBfrPlaceOrderFOH\" id =\"restBfrPlaceOrderFOH\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<!-- 44884 End. -->\n</form>\n\t<script>change_tab(\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\")</script>\n\t<script>\n\t//IN030469, starts\n\tif(\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' == \'HIGH_RISK_ASSESS\')\n\tdocument.getElementById(\'placeOrder\').click();\n\t//IN030469, ends\n\t</script>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	// [IN030566] session.setAttribute("TEMP_PASS","");  //[IN030563]

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


		request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
        response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085		
		Properties properties			= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
		String ammend_called_from		= request.getParameter("ammend_called_from");

		beanQueryObj.setLanguageId(localeName);

		if(ammend_called_from == null)
				ammend_called_from 		= "";
		String function_from			= request.getParameter("function_from");
		if(function_from == null)	function_from 	= "";
		//IN030279 Start.
		String deceased_yn = ((String)request.getParameter("deceased_yn"))==null ? "" : (String)request.getParameter("deceased_yn");
		String medico_legal_yn = ((String)request.getParameter("medico_legal_yn"))==null ? "" : (String)request.getParameter("medico_legal_yn");
		String postmortem_status = ((String)request.getParameter("postmortem_status"))==null ? "" : (String)request.getParameter("postmortem_status");
		String body_part_yn = ((String)request.getParameter("body_part_yn"))==null ? "" : (String)request.getParameter("body_part_yn");
		String registration_no = ((String)request.getParameter("registration_no"))==null ? "" : (String)request.getParameter("registration_no");
		String callingFrom = ((String)request.getParameter("callingFrom"))==null ? "" : (String)request.getParameter("callingFrom");		
		//IN030279 End.
		String order_id					= request.getParameter("order_id");
		if(order_id == null)
							order_id 	= "";
		String iv_prep_yn				= request.getParameter("iv_prep_yn");
		String patient_id				= request.getParameter("patient_id");
		if(patient_id == null)	patient_id 	= "";
		//[IN038776] Start.
		if((session.getAttribute(patient_id+"ScreeningServiceValues"))!=null){
				session.setAttribute(patient_id+"ScreeningServiceValues",""); 
		}
		if((session.getAttribute(patient_id+"Check_Boxs"))!=null){
				session.setAttribute(patient_id+"Check_Boxs","");  
		}
		//[IN038776] End.
		String encounter_id				= request.getParameter("episode_id");
		String bean_id 					= request.getParameter("bean_id");
		String bean_name 				= request.getParameter("bean_name");
		String patient_class 			= request.getParameter("patient_class");
		String existing_order_called_from 			= request.getParameter("existing_order_called_from")==null?"":request.getParameter("existing_order_called_from");
		String multi_called_from 			= request.getParameter("multi_called_from")==null?"":request.getParameter("multi_called_from");
		String reject_order 			= request.getParameter("reject_order")==null?"":request.getParameter("reject_order");
		String strGender				="";
		String temp						="";
		String[] newrecord 					= null;
		String[] details 					= null;
		String[] apend 					= null;
		String login_user               = (String) session.getValue("login_user");
		String practitioner_id    		= (String) session.getValue("ca_practitioner_id");
 		if (practitioner_id == null || practitioner_id.equals("null") || practitioner_id.equals("")) 
		{
			   String [] practitioner_details = beanQueryObj.getPractitionerDetails(properties, login_user);
				if (practitioner_details.length == 2)	
				{
			       practitioner_id		= practitioner_details[0];
 				} // End of practitioner_details length
		} // end of if practitioner_id
  		String responsibility_id		= (String) session.getValue("responsibility_id");
		String relationship_id			= request.getParameter("relationship_id");
		//String p_option_function_name	= request.getParameter("p_option_function_name");
		String function_id				= request.getParameter("function_id");
		if(function_id==null)	function_id = "ORDERS";
		
		// Function_id will be passed from Pharmacy module as "MEDICATION_ADMIN"/"EXTERNAL_ORDERS", IF NOTHING IS PASSED DEFAULT IS ORDERS
 	//	String class_value				= "";
		String first_class_value		= "";
		String default_tab				= "";
	    String bt_module_install		= request.getParameter("bt_module_install");
	   	if(bt_module_install==null)	bt_module_install = "";
	   	String called_from				= request.getParameter("called_from");
	   	if(called_from==null)	called_from = "";
		String p_order_catalog_code			= beanQueryObj.checkForNull(request.getParameter("p_order_catalog_code"),"");
   		String p_task_code				= beanQueryObj.checkForNull(request.getParameter("p_task_code"),"");
		String p_task_srl_no			= beanQueryObj.checkForNull(request.getParameter("p_task_srl_no"),"");
		String p_start_date_time		= beanQueryObj.checkForNull(request.getParameter("p_start_date_time"),"");
		
		String licence_key				= eOR.OR_license_rights.getKey(); // Get the Licence Key from the class
		ArrayList TabsHdg				= new ArrayList();
		String[] record					= null;
		String patfinal="";
		String location_code            =beanQueryObj.checkForNull(request.getParameter("location_code"),"");
		String location_type           =beanQueryObj.checkForNull(request.getParameter("location_type"),"");
		String bed_num                  =beanQueryObj.checkForNull(request.getParameter("bed_num"),"");
		String room_num                 =beanQueryObj.checkForNull(request.getParameter("room_num"),"");
	
	//	String access_bean_id 			= "@accessrightbean"+patient_id+encounter_id;
	//	String access_bean_name			= "eOR.Common.AccessRightBean";
	/* Mandatory checks end */
	/* Initialize Function specific start */
		//OrderEntryBean bean 			= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
		//OrderEntryBean bean				= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		//AccessRightBean access_bean   = (AccessRightBean)mh.getBeanObject( access_bean_id, request,  access_bean_name ) ;
	//	AccessRightBean access_bean	    = (AccessRightBean)getBeanObject( access_bean_id, access_bean_name, request ) ;
	   	String transfusion_display_yn   = "X";
	   	if(licence_key.equals("ORFV") && bt_module_install.equals("Y"))
	   	{
	   		ArrayList BloodTransfusion  = new ArrayList();
	   		// Check atleast any one record is present or not
	   		transfusion_display_yn		= beanQueryObj.getMenu("TRANS_HIST",responsibility_id,relationship_id, properties);
			if(!transfusion_display_yn.equals("X") )
	   			BloodTransfusion 		= beanQueryObj.getBloodTransfusion(patient_id, properties);

	   		if(BloodTransfusion.size() == 0)
	   			transfusion_display_yn 	= "X";
		}

		String ph_install_yn			= beanQueryObj.getModuleInstallYn("PH", properties);
		//String patient_details			= beanQueryObj.checkForNull(request.getParameter("patient_details"),"");
  		TabsHdg	= beanQueryObj.getTabs(properties, practitioner_id,patient_class,function_id, ph_install_yn); //Pass the Practitoner_id and the Team_id

	/* Initialize Function specific end */
		String exist_order_category = beanQueryObj.checkForNull(request.getParameter("exist_order_category"),"");;
  		String exist_order_type_code= beanQueryObj.checkForNull(request.getParameter("exist_order_type_code"),"");;
  		//--String exist_activity_type_code= beanQueryObj.checkForNull(request.getParameter("exist_activity_type_code"),"");;
  		//--String exist_activity_type_desc= beanQueryObj.checkForNull(request.getParameter("exist_order_type_code"),"");;
		String exist_activity_type_code="";
		String exist_activity_type_desc="";

 
		ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
		String existing_bean_id		= "";
		String existing_bean_name	= "";
		existing_bean_id 		= "Or_ExternalOrders";
		existing_bean_name		= "eOR.ExternalOrdersBean";

		if(function_from.equals("EXTERNAL_ORDER")) 
		{ // Get the Bean Instance of External Orders
			if(called_from.equalsIgnoreCase("OH"))
			{
				external_bean_obj	    = (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
				external_bean_obj.setOrderCatalogCode(beanQueryObj.checkForNull(request.getParameter("p_order_catalog_code"),""));
				external_bean_obj.setOrderCategory("CS");
			 	external_bean_obj.setOrderType(beanQueryObj.checkForNull(request.getParameter("order_type_code"),""));
				external_bean_obj.setCalledFrom("OH");
				putObjectInBean(existing_bean_id,external_bean_obj,request);
			}
		}  

		if(function_from.equals("EXTERNAL_ORDER")) 
		{ // Get the Bean Instance of External Orders
			
			//external_bean_obj		= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  	existing_bean_name ) ;
			external_bean_obj	    = (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
			p_order_catalog_code	= beanQueryObj.checkForNull(external_bean_obj.getOrderCatalogCode(),"");
			exist_order_category	= beanQueryObj.checkForNull(external_bean_obj.getOrderCategory(),"");
			exist_order_type_code	= beanQueryObj.checkForNull(external_bean_obj.getOrderType(),"");
			exist_activity_type_code	= beanQueryObj.checkForNull(external_bean_obj.getActivity_Type(),"");
			exist_activity_type_desc	= beanQueryObj.checkForNull(external_bean_obj.getActivity_Desc(),"");
					
			//Modified by Ambiga.M for 19623 (if condition added to avoid nullPointer exception)
			if(!patient_id.equals(""))
			{
				ArrayList patDetails=external_bean_obj.getPatientName(patient_id) ;
				for( int i=0 ; i< patDetails.size() ; i++ ) 
				{
					newrecord = (String[])patDetails.get(i);
				}
			temp= newrecord[0];
			details=temp.split(":");
			apend=details[1].split("/");
			
			
			if(newrecord[1].equals("M"))
			{
				strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");					
			}
			else if(newrecord[1].equals("F"))
			{
				strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					
			}
			else
			{
				strGender=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					
			}
			 patfinal=details[0]+":"+strGender+"/"+apend[1];
		 }

		} else if(function_from.equals("CP") || function_from.equals("MO")) 
		{	// For CP/MO
		// Get the order_category and the order_type_code
 			String[] category_details= new String[2];	
			category_details		= beanQueryObj.getCategoryDetails(properties, p_order_catalog_code); // Get the 	Details
			exist_order_category	= beanQueryObj.checkForNull(category_details[0],"");
			exist_order_type_code	= beanQueryObj.checkForNull(category_details[1],"");
			category_details		= null; // Nullifying the objects
 		}// End of function-from

 		String frequent_orders_allowed_yn	=  "N"; // Remove this variable and reference later, when frequent order is given
		String pharmacy_scope = beanQueryObj.checkForNull(request.getParameter("pharmacy_scope"),"");
	//IN069027 starts
		OrderEntryBean bean1					= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
		bean1.setLanguageId(localeName);
		//44884 Start.
		String practitionerRel=bean1.getPractitionerRelation(bean1.getPractitionerId(),patient_id);
		HashMap restrictedNewOrdersSF=bean1.restrictedNewOrdersSF(bean1.getPractitionerId(),practitionerRel,function_from);
		//44884 End.
		String  ph_instal_yn						= bean1.getModuleInstallYn("PH");	
	//IN069027 ends
	
            _bw.write(_wl_block10Bytes, _wl_block10);

	if(TabsHdg!=null && TabsHdg.size() > 0 ) 
	{
		for(int i=0; i<TabsHdg.size(); i++)
		{
			record = (String[])TabsHdg.get(i);
 			if(i==0)	// Only for the first record
			{
			
 				first_class_value	= "CASECONDSELECTHORZ";
				if(record[i].equalsIgnoreCase("frequentOrders")) 
				{ 
					default_tab		= "FrequentOrders";	// Get only the first tab, so that to load 
					if(frequent_orders_allowed_yn.equals("Y"))
					{
						default_tab		= "FrequentOrders";	// Get only the first tab, so that to load 
					//else if(record[i].equalsIgnoreCase("drawingTools") || drawing_tools_allowed_yn.equals("Y") ) 
					//	default_tab		= "DrawingTools";	
					}
					else 
					{
						default_tab		= "AdditionalSearch";	// Get only the first tab, so that to load 
					}
   				} else if(record[i].equalsIgnoreCase("additionalSearch"))
				{
					default_tab		= "AdditionalSearch";	// Get only the first tab, so that to load the tab(obj-->name-->called on click of the hyperlink)
				}
				else if(record[i].equalsIgnoreCase("tickSheet"))
				{
					default_tab		= "TickSheet";			// Get only the first tab, so that to load the tab
				}
				else if(record[i].equalsIgnoreCase("image"))
				{
					default_tab		= "Image";				// Get only the first tab, so that to load the tab
				}
				else if(record[i].equalsIgnoreCase("careSet"))
				{
					default_tab		= "CareSet";			// Get only the first tab, so that to load the tab
				}
				else if(record[i].equalsIgnoreCase("placeOrder"))
				{
					default_tab		= "PlaceOrder";			// Get only the first tab, so that to load the tab
				}
 				if((function_from.equalsIgnoreCase("AMEND_ORDER") || function_from.equalsIgnoreCase("COPY_ORDER") || function_from.equals("RENEW_ORDER"))||function_id.equalsIgnoreCase("MEDICATION_ADMIN")||function_id.equalsIgnoreCase("EXTERNAL_ORDERS")||pharmacy_scope.equals("PH"))
				{
					if(function_from.equalsIgnoreCase("COPY_ORDER"))
					{
						existing_bean_id				= "@existingorderbean"+patient_id+encounter_id;
						existing_bean_name				= "eOR.ExistingOrder";
						ExistingOrder existing_bean_obj = (ExistingOrder)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
						ArrayList copyOrderDetails			= new ArrayList();
						copyOrderDetails = (ArrayList)existing_bean_obj.getCopyOrderDetails();
						if(copyOrderDetails!=null)
						{
							default_tab		= "PlaceOrder";			// Get only the first tab, so that to load the tab
						}						
					}
					else
					{
						default_tab		= "PlaceOrder";		
					}
				}
			} 
			else 
			{
				first_class_value		= "CAFIRSTSELECTHORZ";
				//	class_value				= "CAFIRSTSELECTHORZ";
			}
			
			if(default_tab.equals("PlaceOrder"))
			{
				first_class_value	= "CAFIRSTSELECTHORZ";
			//	class_value			= "CASECONDSELECTHORZ";
			}
 			if(licence_key.equals("ORPV") && called_from.equals("ON_LOAD"))
			{
				default_tab				= "PlaceOrder";
				first_class_value		= "CAFIRSTSELECTHORZ";
			//	class_value 			= "CASECONDSELECTHORZ";
			}
			 if(record[0].equalsIgnoreCase("frequentOrders")  && frequent_orders_allowed_yn.equals("Y"))  
			{ //Name (record[0] --> Sys_tab_name --> System defined
			 
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(first_class_value));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block13Bytes, _wl_block13);

				} 
				else if(record[0].equalsIgnoreCase("additionalSearch") && !function_from.equals("HIGH_RISK_ASSESS")) //IN030469
				{ //Name (record[0] --> Sys_tab_name --> System defined

					if((!called_from.equalsIgnoreCase("OH"))&&(!(function_id.equalsIgnoreCase("MEDICATION_ADMIN")))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))
					{
					
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(first_class_value));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block16Bytes, _wl_block16);
	
					}
				} 
				else if(record[0].equalsIgnoreCase("tickSheet") && !function_from.equals("HIGH_RISK_ASSESS"))  //IN030469
				{ 
					
					if((!called_from.equalsIgnoreCase("OH"))&&(!function_id.equalsIgnoreCase("MEDICATION_ADMIN"))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))
					{
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(first_class_value));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block16Bytes, _wl_block16);

					}
				} 
				else if(record[0].equalsIgnoreCase("image") && !function_from.equals("HIGH_RISK_ASSESS")) //IN030469
				{
					if(licence_key.equals("ORFV") && !function_from.equals("EXTERNAL_ORDER"))
					{ 
						if((!called_from.equalsIgnoreCase("OH"))&&(!function_id.equalsIgnoreCase("MEDICATION_ADMIN"))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))						
						{
						
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(first_class_value));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block21Bytes, _wl_block21);

						}
					}
				} 
				else	if(record[0].equalsIgnoreCase("careSet") && !function_from.equals("HIGH_RISK_ASSESS"))    //IN030469
				{
 					 if(!function_from.equals("AMEND_ORDER") && !function_from.equals("EXTERNAL_ORDER"))					
					{ 	// For New Orders
						if((!called_from.equalsIgnoreCase("OH"))&&(!function_id.equalsIgnoreCase("MEDICATION_ADMIN"))&&(!function_id.equalsIgnoreCase("EXTERNAL_ORDERS")))
						{
					
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(first_class_value));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block16Bytes, _wl_block16);

						}
					}
				} 
				else if(record[0].equalsIgnoreCase("placeOrder"))  
				{ 
				
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(record[1]));
            _bw.write(_wl_block25Bytes, _wl_block25);
	
				}
			} // End of for
		} // End of if TabsHdg.size()
	
		if(function_from.equals("EXTERNAL_ORDER")) 
		{ 
		
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(patfinal));
            _bw.write(_wl_block27Bytes, _wl_block27);

		} 
		if(licence_key.equals("ORFV") && bt_module_install.equals("Y") && !transfusion_display_yn.equals("X")) 
		{ 
		
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

		}
		
            _bw.write(_wl_block30Bytes, _wl_block30);
	
		if(frequent_orders_allowed_yn.equals("Y")) 
		{
		
            _bw.write(_wl_block31Bytes, _wl_block31);

		} 
		else 
		{ 
            _bw.write(_wl_block32Bytes, _wl_block32);
	
		} 
		
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(medico_legal_yn));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(callingFrom));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(body_part_yn));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(ammend_called_from));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(location_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(bed_num));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(room_num));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("episode_id"),"")));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("pract_reln_id"),"")));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("p_called_from_ca"),"")));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("Sex"),"")));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("Age"),"")));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("Dob"),"")));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("visit_adm_date"),"")));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("licence_key"),"")));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("pract_id"),"")));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("pract_name"),"")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("order_mode"),"")));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("bt_module_install"),"")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(p_start_date_time));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(p_task_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(p_task_srl_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(exist_order_category));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(exist_order_type_code));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(exist_activity_type_code));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(exist_activity_type_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(existing_order_called_from));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(multi_called_from));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(reject_order));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(ph_instal_yn));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(beanQueryObj.checkForNull(practitionerRel,"N")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSMI"),"N")));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOT"),"N")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCN"),"N")));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSLB"),"N")));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSTR"),"N")));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPC"),"N")));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSPH"),"N")));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSNC"),"N")));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSDS"),"N")));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRX"),"N")));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSRD"),"N")));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSCS"),"N")));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderSOH"),"N")));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFMI"),"N")));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOT"),"N")));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCN"),"N")));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFLB"),"N")));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFTR"),"N")));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPC"),"N")));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFPH"),"N")));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFNC"),"N")));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFDS"),"N")));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRX"),"N")));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFRD"),"N")));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFCS"),"N")));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(beanQueryObj.checkForNull((String)restrictedNewOrdersSF.get("restBfrPlaceOrderFOH"),"N")));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(default_tab));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block112Bytes, _wl_block112);

	if(!p_order_catalog_code.equals("")) // When only comes from external order
			out.println("<script>loadPreview(\""+function_from+"\",\""+p_order_catalog_code+"\",\""+exist_order_category+"\")</script>");

            _bw.write(_wl_block113Bytes, _wl_block113);


		// set it back persistence		(no need to set)
		//putObjectInBean(bean_id,bean,request);
		//putObjectInBean(access_bean_id,access_bean,request);
		

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderEntryMain.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransfusionHistory.label", java.lang.String .class,"key"));
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
}
