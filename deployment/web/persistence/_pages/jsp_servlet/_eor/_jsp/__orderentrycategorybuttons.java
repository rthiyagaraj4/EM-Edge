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

public final class __orderentrycategorybuttons extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderEntryCategoryButtons.jsp", 1743584761067L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n-----------------------------------------------------------------------\nDate\t\t\tEdit History   Name        Description\n-----------------------------------------------------------------------\n?             \t100         \t?           created\n23/01/2012    \tIN030563    \tRamesh G   \tThe Pin No. for placing ordering is selected as Logged in Practitioner s Pin ? \n\t\t\t\t\t\t\t\t\t\t\tPrompt once for all categories. \t\t\t\t\t\t \n\t\t\t\t\t\t\t\t\t\t\tBut the Pin No. is prompted each time we Place a Category and also when we record the category.\n\n25/01/2012\t  \tIN030566\t\tRamesh G\tWhen we place another Order of the same category the Pin No. is prompted again even if the Patient chart is not closed.\t\n\n25/09/2012\t\tIN030279\t\tRamesh G\tBru-HIMS-CRF-160 \t\t\t\t\t\t\t  \n12/03/2013    \tIN029601        Chowminya G Display Pregnancy details on place order - PH screen\t\t\t\t\t  \n22/03/2013\t\tIN030469\t\tDineshT\t\tOrder Entry Place order screen to show catalogs on load\n22/05/2013    \tIN029601        Chowminya G Display Pregnancy details on place order - PH screen- FD Modification \n18/06/2013    \tIN040685        Chowminya G Display Pregnancy details on place order - PH screen- FD Modification \n-----------------------------------------------------------------------\nDate\t\t\tEdit History\t\tName\t\t\tRev.Date\t\tRev.Name\t\t\tDescription\n--------------------------------------------------------------------------------------------------------\n12/02/2018\t\tIN066055\t\tRaja S\t\t\t12/02/2018\t\tRamesh \t\t\tML-MMOH-CRF-0891.2\n11/02/2019\tIN069657\tDinesh  T\t11/02/2019\tRamesh G\tIN069657\n-------------------------------------------------------------------------------------------------------\n-->\n";
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

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/></link>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<script>\n\t\tfunction callexternalPH(patid,encid,user_id)\n\t\t{\n\t\t\tvar extph_function_id=document.categoryForm.extph_function.value\n\n\t\t\tvar query_string=\"Mode=GenerateExtURL&extph_function_id=\"+extph_function_id+\"&patient_id=\"+patid+\"&encounter_id=\"+encid+\"&user_id=\"+user_id;\n\t\t\t//var xmlDoc  = new ActiveXObject( \"Microsoft.XMLDom\" ) ;\n\t\t\t//var xmlDoc = \"\"; \n\t\t\tvar xmlHttp = new XMLHttpRequest() ;\n\t\t\tvar xmlStr  = \"<root><SEARCH \";\n\t\t\txmlStr +=\" /></root>\";\n\t\t\t\n\t\t\tvar xmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\t\n\t\t\txmlHttp.open(\"POST\",\"PlaceOrderIntermediate.jsp?\"+query_string, false ) ;\n\t\t\txmlHttp.send(xmlDoc);\n\t\t\tif(trimString(xmlHttp.responseText)!=\"Success\")\n\t\t\t{\n\t\t\t\tresponseText=trimString(xmlHttp.responseText);\n\t\t\t\teval(responseText);\n\t\t\t}\n\t\t}\n\t\t</script>\n\t\t<STYLE>\n\t\tTD.ORSUBCOLOR\n\t\t{\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tCOLOR:red;\n\t\t\tBACKGROUND-COLOR: WHITE;\n\t\t\tBORDER-STYLE: none;\n\t\t\tfont-Weight : bold;\n\t\t\tWORD-WRAP: break-word\n\t\t}\t\n\t\t</STYLE>\n\t</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" onLoad=\"parent.loadButtons();\">\n<form name=\"categoryForm\" id=\"categoryForm\">\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<table width=\"100%\" border=\"0\" cellspacing=0 cellpadding=\"0\" id=\"tab\">\n\n\t\t<tr>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<table border=\"0\" cellspacing=0 cellpadding=\"\" id=\"tab\">\n\n\t\t<tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td id=\"Consults\"  class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap>\n\t\t\t<a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'Consults\')\">\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</a></td>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t<td id=\"DietaryService\"  class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap>\n\t\t\t<a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'DietaryService\')\">\t\t\t\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\t\t\t</a></td>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<td id=\"Laboratory\" class=\"CASECONDSELECTHORZ\" onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\" \tonClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap>\n\t\t\t<a style=\"color:white;cursor:pointer\"  href=\"javascript:parent.change_tab_buttons(\'Laboratory\')\">\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<td id=\"Miscellaneous\" \t class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\"  href=\"javascript:parent.change_tab_buttons(\'Miscellaneous\')\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</a></td>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t<td id=\"Nursing\"\t class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'Nursing\')\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td id=\"OralHealth\" \t class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'OralHealth\')\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</a></td>\n\t\t    \n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t<td id=\"OrderSets\" \t class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'OrderSets\')\">";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<td id=\"PatientCare\"   class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'PatientCare\')\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<td id=\"Radiology\"  class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'Radiology\')\">";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td id=\"RadiologyDept\"  class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'RadiologyDept\')\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td id=\"Surgical\"  class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap>\n\t\t<a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'Surgical\')\">\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t</a></td>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<td id=\"Treatment\"  class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap><a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'Treatment\')\">";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t</a></td>\n\t\t\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t<td  width=\"8%\" id=\"Pharmacy\"   class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap>\n\t\t\t\t\t<a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'Pharmacy\')\">\n\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t</a>\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t\t\n\t\t\t\t\t<td width=\"85%\" align=\"left\" nowrap>\n\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap> Pregnant :</td> <td class=\"ORSUBCOLOR\" nowrap>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td> \n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\t\n\t\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap> Pregnancy Trimester :</td> <td class=\"ORSUBCOLOR\" nowrap>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td> \n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap> Pregnancy Stage :</td> <td class=\"ORSUBCOLOR\" nowrap>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" Weeks</td> </td>\n\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\n\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap> </td> <td class=\"ORSUBCOLOR\" nowrap></td> \n\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap></td> <td class=\"ORSUBCOLOR\" nowrap></td> </td>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t<td  id=\"Pharmacy\"   class=\"CAFIRSTSELECTHORZ\"  onMouseOver=\"parent.callOnMouseOver(this);\" onMouseOut=\"parent.callOnMouseOut(this);\"   onClick=\"parent.changeColor(this,\'OR_BUTTONS\')\" nowrap>\n\t\t\t\t\t<a style=\"color:white;cursor:pointer\" href=\"javascript:parent.change_tab_buttons(\'Pharmacy\')\">\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t</a>\t\t\t\n\t\t\t\t\t</td>\n\t\t\t\t\t<td width=\"85%\" align=\"left\" nowrap>\n\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap> No Record of Pregnancy </td> <td class=\"ORSUBCOLOR\" nowrap></td> \n\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap> </td> <td class=\"ORSUBCOLOR\" nowrap></td> \n\t\t\t\t\t\t<td width=\"30%\" class=\"ORSUBCOLOR\" nowrap></td> <td class=\"ORSUBCOLOR\" nowrap></td> \n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t\t\t</a>\t\t\t\n\t\t\t\t\t</td>\n";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t</tr>\n\t\t</table>\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<input type=\"hidden\" name=\"extph_function\" id=\"extph_function\" value=\"\">\n\t\t\t\n";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n\t<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\">\n\t<input type=\"hidden\" name=\"ammend_called_from\" id=\"ammend_called_from\" value=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\">\n\t<input type=\"hidden\" name=\"function_from\" id=\"function_from\" value=\"";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t<!-- IN030279 Start -->\n\t<input type=\"hidden\" name=\"deceased_yn\" id=\"deceased_yn\" value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n\t<input type=\"hidden\" name=\"medico_legal_yn\" id=\"medico_legal_yn\" value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n\t<input type=\"hidden\" name=\"postmortem_status\" id=\"postmortem_status\" value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n\t<input type=\"hidden\" name=\"callingFrom\" id=\"callingFrom\" value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\">\n\t<input type=\"hidden\" name=\"body_part_yn\" id=\"body_part_yn\" value=\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\">\n\t<input type=\"hidden\" name=\"registration_no\" id=\"registration_no\" value=\"";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\">\n\t<!-- IN030279 End. -->\n\t<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\">\n\t<input type=\"hidden\" name=\"location_code\" id=\"location_code\" value=\"";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\">\n\t<input type=\"hidden\" name=\"patient_class\" id=\"patient_class\" value=\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\">\n\t<input type=\"hidden\" name=\"lb_instal_yn\" id=\"lb_instal_yn\" value=\"";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\">\n\t<input type=\"hidden\" name=\"session_id\" id=\"session_id\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t<input type=\"hidden\" name=\"iv_prep_yn\" id=\"iv_prep_yn\" value=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\">\n\t<input type=\"hidden\" name=\"order_id\" id=\"order_id\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\">\n\t<input type=\"hidden\" name=\"p_order_catalog_code\" id=\"p_order_catalog_code\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\">\n\t<input type=\"hidden\" name=\"p_start_date_time\" id=\"p_start_date_time\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\">\n\t<input type=\"hidden\" name=\"p_task_code\" id=\"p_task_code\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\">\n\t<input type=\"hidden\" name=\"p_task_srl_no\" id=\"p_task_srl_no\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\">\n\t<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\">\n\t<input type=\"hidden\" name=\"episode_id\" id=\"episode_id\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\">\n\t<input type=\"hidden\" name=\"pract_reln_id\" id=\"pract_reln_id\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\">\n\t<input type=\"hidden\" name=\"p_called_from_ca\" id=\"p_called_from_ca\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\">\n\t<input type=\"hidden\" name=\"Sex\" id=\"Sex\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\">\n\t<input type=\"hidden\" name=\"Age\" id=\"Age\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\">\n\t<input type=\"hidden\" name=\"Dob\" id=\"Dob\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\">\n\t<input type=\"hidden\" name=\"visit_adm_date\" id=\"visit_adm_date\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\">\n\t<input type=\"hidden\" name=\"licence_key\" id=\"licence_key\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\">\n\t<input type=\"hidden\" name=\"pract_id\" id=\"pract_id\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t<input type=\"hidden\" name=\"pract_name\" id=\"pract_name\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\">\n\t<input type=\"hidden\" name=\"order_mode\" id=\"order_mode\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t<input type=\"hidden\" name=\"bt_module_install\" id=\"bt_module_install\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\">\n\t<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\">\n\t<input type=\"hidden\" name=\"time_frame\" id=\"time_frame\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\">\n\t<!--<input type=\"hidden\" name=\"tempPass\" id=\"tempPass\" value=\"\"> [IN030566]--> <!-- [IN030563] --> \n";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\t</form>\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\n\t\t<script>parent.setCopyCatalogCode(\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\");</script>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            eOR.OrderEntryQueryBean beanQueryObj= null;{
                beanQueryObj=(eOR.OrderEntryQueryBean)pageContext.getAttribute("beanQueryObj");
                if(beanQueryObj==null){
                    beanQueryObj=new eOR.OrderEntryQueryBean();
                    pageContext.setAttribute("beanQueryObj",beanQueryObj);

                }
            }
            _bw.write(_wl_block6Bytes, _wl_block6);

	try
	{
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
// [IN030566] String temp_pass	= ((session.getAttribute("TEMP_PASS")!=null)||(session.getAttribute("TEMP_PASS")!=""))?(String)session.getAttribute("TEMP_PASS"):"";	//[IN030563]  


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String patient_id					= request.getParameter("patient_id");
	String encounter_id					= request.getParameter("encounter_id");
	if(encounter_id==null)
		encounter_id					= request.getParameter("episode_id");
	String bean_id 						= request.getParameter("bean_id");
	String bean_name 					= request.getParameter("bean_name");

	/* Initialize Function specific start */
	//OrderEntryBean bean 				= (OrderEntryBean)mh.getBeanObject( bean_id, request,  bean_name ) ;
	beanQueryObj.setLanguageId(localeName);

	OrderEntryBean bean					= (OrderEntryBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(localeName);
	bean.setRDInstallYN(bean.getFacilityModuleInstallYn("RD"));//IN069657

	//  Get the bean_id and bean_name from the existing order, if it is "COPY_ORDER"
	MultiPatientOrdersBean multi_bean_obj= null; // For MULTI_PATIENT_ORDERS
	ExternalOrdersBean external_bean_obj= null; // For EXTERNAL_ORDER
	ExistingOrder existing_bean_obj		= null; // For COPY_ORDER
	String function_from				= bean.checkForNull(request.getParameter("function_from"),"");
	//IN030279 Start.
		String deceased_yn = ((String)request.getParameter("deceased_yn"))==null ? "" : (String)request.getParameter("deceased_yn");
		String medico_legal_yn = ((String)request.getParameter("medico_legal_yn"))==null ? "" : (String)request.getParameter("medico_legal_yn");
		String postmortem_status = ((String)request.getParameter("postmortem_status"))==null ? "" : (String)request.getParameter("postmortem_status");
		String body_part_yn = ((String)request.getParameter("body_part_yn"))==null ? "" : (String)request.getParameter("body_part_yn");
		String registration_no = ((String)request.getParameter("registration_no"))==null ? "" : (String)request.getParameter("registration_no");
		String callingFrom = ((String)request.getParameter("callingFrom"))==null ? "" : (String)request.getParameter("callingFrom");		
	//IN030279 End.
	String function_id				= bean.checkForNull(request.getParameter("function_id"),"");
	String existing_bean_id				= "";
	String existing_bean_name			= "";
	String user_id = (String)session.getValue("login_user");//IN066055
	beanQueryObj.setSiteSpecific("EXTERNAL_PH");//IN066055
	String ext_PH_Link				= "";//IN066055

	if(function_from.equals("COPY_ORDER")) 
	{
		existing_bean_id				= "@existingorderbean"+patient_id+encounter_id;
		existing_bean_name				= "eOR.ExistingOrder";
		//existing_bean_obj				= (ExistingOrder)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		existing_bean_obj 				= (ExistingOrder)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
	} 
	else if(function_from.equals("EXTERNAL_ORDER")) 
	{
		existing_bean_id 				= "Or_ExternalOrders";
		existing_bean_name				= "eOR.ExternalOrdersBean";
		//external_bean_obj				= (ExternalOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		external_bean_obj 				= (ExternalOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
	} 
	else if(function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		existing_bean_id 				= "Or_MultiPatientOrders";
		existing_bean_name 				= "eOR.MultiPatientOrdersBean";
		//multi_bean_obj				= (MultiPatientOrdersBean)mh.getBeanObject( existing_bean_id, request,  existing_bean_name ) ;
		multi_bean_obj 					= (MultiPatientOrdersBean)getBeanObject( existing_bean_id, existing_bean_name, request ) ;
		//multi_bean_obj = (MultiPatientOrdersBean)getObjectFromBean(existing_bean_id, existing_bean_name,session);
	}

	eOR.Common.OrderEntryRecordBean orderEntryRecordBean = (eOR.Common.OrderEntryRecordBean) bean.getOrderEntryRecordBean();
	/* if(function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		ArrayList multi = (ArrayList)multi_bean_obj.getMultiPatientDetails();
		
		if(multi.size()>0)
		{
			HashMap multihash = new HashMap();
			multihash.put("key",multi);
			orderEntryRecordBean.setMultiPatientDetails("multi_patient_details", multihash);
		}
		
		HashMap outhash = new HashMap();
		outhash = (HashMap)orderEntryRecordBean.getMultiPatientDetails("multi_patient_details");
	}*/
	String existing_query_string		= "";
	String queryString						= "";
	ArrayList copyOrderDetails			= null;
	if(function_from.equals("COPY_ORDER"))	// Existing Order Bean
	{
		existing_query_string			= existing_bean_obj.getExistingQueryString();	// Get from the existing order, to send as a parameter when refreshing for COPY_ORDER
		/*Added by Uma on 2/24/2010 for IN019470*/
		if(existing_query_string.equals(""))
		{
			String location_type = request.getParameter("location_type")==null?"":request.getParameter("location_type");
			String location_code = request.getParameter("location_code")==null?"":request.getParameter("location_code");
			String sex = request.getParameter("Sex")==null?"":request.getParameter("Sex");
			String age = request.getParameter("Age")==null?"":request.getParameter("Age");
			String dob = request.getParameter("Dob")==null?"":request.getParameter("Dob");
			String visit_adm_date = request.getParameter("visit_adm_date")==null?"":request.getParameter("visit_adm_date");
			//String existing_order_called_from = request.getParameter("existing_order_called_from")==null?"":request.getParameter("existing_order_called_from");
			String multi_called_from = request.getParameter("multi_called_from")==null?"":request.getParameter("multi_called_from");
			String patient_class=(String)bean.getPatientClass()==null?"":(String)bean.getPatientClass();
			queryString = "patient_id="+patient_id+"&encounter_id="+encounter_id+"&function_from=PASSED_ORDERS&location_type="+location_type+"&location_code="+location_code+"&p_called_from_ca=Y&Sex="+sex+"&Age="+age+"&Dob="+dob+"&visit_adm_date="+visit_adm_date+"&episode_id="+encounter_id+"&locn_code="+location_code+"&locn_type="+location_type+"&patient_class="+patient_class+"&multi_called_from="+multi_called_from;
			existing_query_string = queryString;
		}
		/*Ends Here IN019470*/
	}
	else if(function_from.equals("EXTERNAL_ORDER"))
		existing_query_string			= external_bean_obj.getExistingQueryString();	// Get from the existing order, to send as a parameter when refreshing for EXTERNAL_ORDER
	else if(function_from.equals("MULTI_PATIENT_ORDERS"))
	{
		existing_query_string			= multi_bean_obj.getQryString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		/*Added by Uma on 2/18/2010 for IN017231*/
		String patientString			= (String)multi_bean_obj.getPatString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String encounterString			= (String)multi_bean_obj.getEncString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String episodeString			= (String)multi_bean_obj.getEpiString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String episodevisitString			=(String)multi_bean_obj.getVisitString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		String patientclassString			= (String)multi_bean_obj.getPatClassString();	// Get from the existing order, to send as a parameter when refreshing for MULTI_PATIENT_ORDERS
		
		StringTokenizer stoken = new StringTokenizer(patientString,"!$!");
		StringTokenizer stoken1 = new StringTokenizer(encounterString,"!$!");
		StringTokenizer stoken2 = new StringTokenizer(episodeString,"!$!");
		StringTokenizer stoken3 = new StringTokenizer(episodevisitString,"!$!");
		StringTokenizer stoken4 = new StringTokenizer(patientclassString,"!$!");
		
		String [] record = null;
		ArrayList arr_patient_id		 = new ArrayList();
		
		while(stoken.hasMoreTokens()) 
		{
			record = new String [5];
			String mpatient_id		= stoken.nextToken();
			String mencounter_id		= stoken1.nextToken();
			String mepisode_id		= stoken2.nextToken();
			String mepisodevisit_id		= stoken3.nextToken();
			String mpatient_class		= stoken4.nextToken();
			if(mpatient_id == "~" || mpatient_id.equals("~")) mpatient_id="";
			if(mencounter_id == "~" || mencounter_id.equals("~")) mencounter_id="";
			if(mepisode_id == "~" || mepisode_id.equals("~")) mepisode_id="";
			if(mepisodevisit_id == "~" || mepisodevisit_id.equals("~")) mepisodevisit_id="";
			if(mpatient_class == "~" || mpatient_class.equals("~")) mpatient_class="";
			
			record[0]		= mpatient_id;
			record[1]		= mencounter_id;
			record[2]		= mepisode_id;
			record[3]		= mepisodevisit_id;
			record[4]		= mpatient_class;
			arr_patient_id.add(record);
		}
		bean.setMultiPatientDetails(arr_patient_id);
	}	
	/*Ends Here for IN017231*/
	// If it is a new patient set it, other wise get the patient id
	//orderEntryRecordBean.getPatient(bean.getPatientId());
	/* Initialize Function specific end */
	Properties properties				= (Properties) session.getValue( "jdbc" ); //Properties to be passed to the bean to get the connection if using the query bean and not the functional bean 
	String ammend_called_from			= bean.checkForNull(request.getParameter("ammend_called_from"),"");
	String order_id						= bean.checkForNull(request.getParameter("order_id"),"");
	String order_line_num				= bean.checkForNull(request.getParameter("order_line_num"),"");
	String iv_prep_yn					= bean.checkForNull(request.getParameter("iv_prep_yn"),"");
	/*  CP Module Related parameters */
	String p_order_catalog_code				= bean.checkForNull(request.getParameter("p_order_catalog_code"),"");
	String p_start_date_time			= bean.checkForNull(request.getParameter("p_start_date_time"),"");
	String p_task_code					= bean.checkForNull(request.getParameter("p_task_code"),"");
	String p_task_srl_no				= bean.checkForNull(request.getParameter("p_task_srl_no"),"");
	String reject_order					= bean.checkForNull(request.getParameter("reject_order"),"");
 	/* Till here CP Module related parameters*/
	String amend_key					= (bean.getPatientId()+bean.getEncounterId()+order_id);  // Unique key (For Existing Orders) to keep the Value in the Bean
//	String copy_key						= (bean.getPatientId()+bean.getEncounterId());  // Unique key (For COPY Orders) to keep the Value in the Bean
	String key							= (bean.getPatientId()+bean.getEncounterId());  // Unique key (For New Orders) to keep the Value in the Bean
	String ph_instal_yn					= "N";
	String lb_instal_yn		="N";			//=bean.checkForNull(bean.getFacilityModuleInstallYn("RL"),"N"); // check whether the lb_module is installed or not, used in EJB
	String session_id					= bean.checkForNull(bean.getSessionId(),""); //  used in EJB
	String catalog						= "";

	// Till here
	HashMap previousValues 				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);

	// If it is an Amend/Review order, call a method to set the value in the bean.
	if(function_from.equals("AMEND_ORDER") || function_from.equalsIgnoreCase("COPY_ORDER") || function_from.equals("RENEW_ORDER"))
	{
		if( function_from.equals("AMEND_ORDER") || function_from.equals("RENEW_ORDER")) 
		{
			bean.setAmendCode(amend_key,order_id.trim(),order_line_num);	
		}
        else if(function_from.equals("COPY_ORDER") && previousValues==null && (!reject_order.equalsIgnoreCase("Y")))
		{	// GET FROM THE Existing Order bean for the COPY_ORDER
			copyOrderDetails			= existing_bean_obj.getCopyOrderDetails();		// ArrayList
 			bean.setCopyOrderDetails(copyOrderDetails);		// Setting into the Order Entry Bean
			copyOrderDetails			= bean.getCopyOrderDetails();				// Getting the value for the COPY_ORDER
			catalog						= bean.setCopyCode(key, copyOrderDetails);	// Setting the value into tbe bean for the copy order, for the first time
			previousValues				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
		}
		bean.setOrderId(order_id);
		bean.setOrderLineNo(order_line_num);
		bean.setAmendOrder(ammend_called_from);
		bean.setCalledFromFunction(function_from);
	}
	//IN030469, starts
	if(function_from.equals("HIGH_RISK_ASSESS"))
	{
		bean.setCatalogCodes((String)session.getValue(key+"CHK_BOX"));
		orderEntryRecordBean.setCheckedEntries(key, (HashMap)session.getValue(key+"CHK_BOX_DTLS"));
		previousValues				= (HashMap)orderEntryRecordBean.getCheckedEntries(key);
	}
	//IN030469, ends
	

	HashMap amendPreviousValues			= (HashMap)orderEntryRecordBean.getCheckedEntries(amend_key);
	String category						= "";
	String ordering_applicable_yn		= "N";
   	String refresh_yn					= bean.checkForNull(bean.getRefreshYn(),"N");
   	// first time or in any case, refresh_yn will be "N", unless insertion/updation is done and catalog code is not more, then it will be set to "Y" in the removeBeanValues() method in the bean
    ph_instal_yn						= bean.getModuleInstallYn("PH"); // To check whether PH Module has been installed or not
	ArrayList OrderCategoryArr			= beanQueryObj.getOrderCategory(properties); // Get the Order category	
	HashMap hmOrderCategory				= new HashMap();
	HashMap hashMap						= new HashMap();
	String record[]						= null;
	//IN029601 - Start
	ArrayList PregDtls		= beanQueryObj.getPHPregDtls(properties,patient_id,encounter_id); 
	String record1[]						= null;
	String preg_trim					= "";
	String preg_stage					= "";
	String preg_chk					    = "N";	
	String PH_age_chk					= "N";
	String PH_param_chk					= "N";
	
	PH_age_chk = beanQueryObj.getPHagechk(properties,patient_id);	
	
	if(PregDtls!=null && PregDtls.size() > 0)
	{
		record1 = new String[3];
		for(int i=0;i<PregDtls.size(); i++) 
		{
			record1 = ((String[])PregDtls.get(i));
			preg_chk = record1[0];
		}
	}	
	//IN029601 - end	
	if(OrderCategoryArr!=null && OrderCategoryArr.size() > 0)
	{
		record = new String[2];
		for(int i=0;i<OrderCategoryArr.size(); i++) 
		{
			record = ((String[])OrderCategoryArr.get(i));
			hmOrderCategory.put( record[0] , record[0]);
			hmOrderCategory.put( record[0] , record[1]);
		} // end of for
	} // end of if OrderCategoryArr

	if(refresh_yn.equals("N") && (previousValues==null || (previousValues!=null && previousValues.size()==0) )&&(!function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS")))
    {
      	if(ph_instal_yn.equals("Y")) // Only if PH Module has been installed
      	{
			// Call a function to execute and based upon the ordering rule set up for the patient class, allow or come out
			ordering_applicable_yn		= bean.checkForNull(bean.getOrderingRuleYn("PH"),"N"); // Pass the order_category
			if(ordering_applicable_yn.equals("Y"))
				category				= "PH"; //If the User enters directly in the New Order, click the Place Order, then paint the Pharmacy Tab obly
		}
	}
	else
		category						= "";
 
	if(function_from.equalsIgnoreCase("AMEND_ORDER") || (previousValues!=null && previousValues.size()>0) || (category.equals("PH") && !function_from.equalsIgnoreCase("COPY_ORDER")) )
   	{
		//IN029601 - Start Modified
		if(category.equals("PH") && PregDtls!=null && PregDtls.size() > 0 && ("Y".equals(PH_age_chk)))
		{

            _bw.write(_wl_block9Bytes, _wl_block9);

		}
		else
		{

            _bw.write(_wl_block10Bytes, _wl_block10);

		}//IN029601 - End Modified
 		if(category.equals("PH") && (! (function_from.equalsIgnoreCase("AMEND_ORDER") || function_from.equalsIgnoreCase("COPY_ORDER") || function_from.equalsIgnoreCase("RENEW_ORDER"))) )
		{ // || function_from.equalsIgnoreCase("RENEW_ORDER")
			hashMap.put("PH","PH"); //Putting the OrderCategory into the temporarily hashmap
		}
		else if(!(function_from.equalsIgnoreCase("AMEND_ORDER") || function_from.equalsIgnoreCase("RENEW_ORDER"))  ) // If it is coming for New orders or for COPY Order then only category has been selected
		{
			hashMap = bean.getOrderCategories(previousValues);
		}
		else 
		{// For Amend Order
 			hashMap = bean.getOrderCategories(amendPreviousValues);
		}
	
		if(hashMap!=null && hashMap.containsKey("CN")) 
		{ 

            _bw.write(_wl_block11Bytes, _wl_block11);

			if(hmOrderCategory.containsKey("CN")) 
			{ 
				out.println((String)hmOrderCategory.get("CN")); 
			} 
			else 
			{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

			}

            _bw.write(_wl_block13Bytes, _wl_block13);
 
		} 
		
		if(hashMap!=null && hashMap.containsKey("DS")) 
		{ 

            _bw.write(_wl_block14Bytes, _wl_block14);

			if(hmOrderCategory.containsKey("DS")) 
			{ 
				out.println((String)hmOrderCategory.get("DS")); 
			} 
			else 
			{

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

			}

            _bw.write(_wl_block16Bytes, _wl_block16);
		} 
			
		if(hashMap!=null && hashMap.containsKey("LB")) 
		{ 

            _bw.write(_wl_block17Bytes, _wl_block17);
			
			if(hmOrderCategory.containsKey("LB")) 
			{ 
				out.println((String)hmOrderCategory.get("LB"));
			}
			else 
			{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			}

            _bw.write(_wl_block13Bytes, _wl_block13);
		} 
			
		if(hashMap!=null && hashMap.containsKey("MI")) 
		{ 

            _bw.write(_wl_block19Bytes, _wl_block19);
if(hmOrderCategory.containsKey("MI")) { out.println((String)hmOrderCategory.get("MI")); } else {

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block20Bytes, _wl_block20);
 
		} 
		
		if(hashMap!=null && hashMap.containsKey("NC")) 
		{

            _bw.write(_wl_block21Bytes, _wl_block21);
if(hmOrderCategory.containsKey("NC")) { out.println((String)hmOrderCategory.get("NC")); } else {

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block20Bytes, _wl_block20);
	
		} 
		//[IN030566]
		if(hashMap!=null && hashMap.containsKey("OH")) 
		{ 

            _bw.write(_wl_block22Bytes, _wl_block22);
if(hmOrderCategory.containsKey("OH")) { out.println((String)hmOrderCategory.get("OH")); } else {

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block23Bytes, _wl_block23);
		}
		//[IN030566]
		if(hashMap!=null && hashMap.containsKey("CS")) 
		{ 

            _bw.write(_wl_block24Bytes, _wl_block24);
if(hmOrderCategory.containsKey("CS")) { out.println((String)hmOrderCategory.get("CS")); } else {

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block23Bytes, _wl_block23);
		} 
		
		if(hashMap!=null && hashMap.containsKey("PC")) 
		{ 

            _bw.write(_wl_block25Bytes, _wl_block25);
if(hmOrderCategory.containsKey("PC")) { out.println((String)hmOrderCategory.get("PC")); } else {

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block20Bytes, _wl_block20);

		} 

		if(hashMap!=null && hashMap.containsKey("RD")) 
		{ 

            _bw.write(_wl_block26Bytes, _wl_block26);
if(hmOrderCategory.containsKey("RD")) { out.println((String)hmOrderCategory.get("RD")); } else {

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block20Bytes, _wl_block20);

		} 

		if(hashMap!=null && hashMap.containsKey("RX")) 
		{ 

            _bw.write(_wl_block27Bytes, _wl_block27);
if(hmOrderCategory.containsKey("RX")) { out.println((String)hmOrderCategory.get("RX")); } else {

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
}
            _bw.write(_wl_block20Bytes, _wl_block20);

		} 
			
		if(hashMap!=null && hashMap.containsKey("OT")) 
		{ 

            _bw.write(_wl_block28Bytes, _wl_block28);

		if(hmOrderCategory.containsKey("OT")) 
		{ 
			out.println((String)hmOrderCategory.get("OT")); 
		} 
		else 
		{

            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

		}

            _bw.write(_wl_block29Bytes, _wl_block29);

		} 
			
		if(hashMap!=null && hashMap.containsKey("TR")) 
		{ 

            _bw.write(_wl_block30Bytes, _wl_block30);
if(hmOrderCategory.containsKey("TR")) { 
				out.println((String)hmOrderCategory.get("TR")); 
			} 
			else 
			{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;

			}

            _bw.write(_wl_block31Bytes, _wl_block31);

		} 
		
		if(hashMap!=null && hashMap.containsKey("PH")) 
		{
			//IN029601 - Start Modified
			PH_param_chk = beanQueryObj.getPHparamchk(properties);
			int week = 0;//IN040685
			if(PregDtls!=null && PregDtls.size() > 0 && ("Y".equals(PH_age_chk)) )
			{
				record1 = new String[3];
				for(int i=0;i<PregDtls.size(); i++) 
				{
					record1 = ((String[])PregDtls.get(i));
					if(record1[0].equals("Y"))
					{
						preg_stage = record1[2];
						week = Integer.parseInt(preg_stage); //IN040685
						
						preg_trim		= beanQueryObj.getPHTrimDtls(properties,preg_stage);		
						record1[0] = "Yes";
					}	
					else 
						record1[0] = "No";		

	
            _bw.write(_wl_block32Bytes, _wl_block32);

					if(hmOrderCategory.containsKey("PH")) 
					{ 
						out.println((String)hmOrderCategory.get("PH"));
					} 
					else 
					{
	
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

					}
	
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(record1[0]));
            _bw.write(_wl_block36Bytes, _wl_block36);

					if(preg_chk.equals("Y"))//IN029601//IN040685 added conditions for trimester and stage display
					{
						if(!("0").equals(preg_trim))
						{
	
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(preg_trim));
            _bw.write(_wl_block38Bytes, _wl_block38);
						}
						if(week <= 44)
						{

            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(preg_stage));
            _bw.write(_wl_block40Bytes, _wl_block40);
	
						}	
					}
					else
					{
	
            _bw.write(_wl_block41Bytes, _wl_block41);
					
						
					}
						
				} 
			}
			else 
			{
				if("Y".equals(PH_param_chk) && ("Y".equals(PH_age_chk)))
				{

            _bw.write(_wl_block42Bytes, _wl_block42);

					if(hmOrderCategory.containsKey("PH")) 
					{ 
						out.println((String)hmOrderCategory.get("PH"));
					} 
					else 
					{

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

					}

            _bw.write(_wl_block43Bytes, _wl_block43);

				}
				else
				{

            _bw.write(_wl_block42Bytes, _wl_block42);

					if(hmOrderCategory.containsKey("PH")) 
					{ 
						out.println((String)hmOrderCategory.get("PH"));
					} 
					else 
					{

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block2Bytes, _wl_block2);

					}

            _bw.write(_wl_block44Bytes, _wl_block44);

					
				}
			}	
			//IN029601 - end Modified
		} 
			

            _bw.write(_wl_block45Bytes, _wl_block45);
	} 
	else 
	{   // Refreshing Part Done Here
		/*Modified by Uma on 2/18/2010 for IN017231*/
		//IN066055 changes starts
		boolean isExternalPHEnabled = beanQueryObj.isSiteSpecific("EXTERNAL_PH");
		if(refresh_yn.equals("N") && ph_instal_yn.equals("N") && isExternalPHEnabled){
			String phExtUrlarr[] = null;
			String facility_id=(String)session.getValue("facility_id");
			String extFuncCalledFrom = "";
			HashMap tabdata				= new HashMap();
			String externalUrl = "";
			tabdata			= beanQueryObj.getExtPHValidation(properties,patient_id,encounter_id,user_id,facility_id);

            _bw.write(_wl_block46Bytes, _wl_block46);

			if(tabdata.containsKey("ERROR")){
				out.println("<script>alert('Atleast one Diagnosis should be recorded')</script>");
			}else{

				if(tabdata.get("DISCHARGESTATUS").equals("7"))
				{
					out.println("<script>var confirmSelect = window.confirm('Do you want to open \"PHIS- Discharge Medication\" screen ?');");
					out.println("if(confirmSelect == true){document.categoryForm.extph_function.value='PHIS_DISCHARGE_MEDICATION'");
					out.println("}else{document.categoryForm.extph_function.value='PHIS_MEDICATION_ORDER'}</script>");
				}else{
					out.println("<script>document.categoryForm.extph_function.value='PHIS_MEDICATION_ORDER'</script>");
				}
			out.println("<script>callexternalPH('"+patient_id+"','"+encounter_id+"','"+user_id+"');</script>");
			}
			ext_PH_Link="EXT_PH_CALLED";
			
		}
		//IN066055 changes ends
			
			
		if(refresh_yn.equals("N") && ph_instal_yn.equals("N") && !ext_PH_Link.equals("EXT_PH_CALLED"))
		    out.println("<script>alert(parent.getMessage('CLICK_ONE_ORDERABLE','OR'))</script>");
		else if(refresh_yn.equals("N") && ph_instal_yn.equals("Y") && ordering_applicable_yn.equals("N"))
		{
			if(!function_from.equalsIgnoreCase("MULTI_PATIENT_ORDERS"))
			{
		 		out.println("<script>alert(parent.getMessage('ORDERS_CANNOT_BE_PLACED','OR'))</script>");
			}
			else
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
			}
			/*Ends Here IN017231*/
		}
		else
		{
			bean.clear();// Clear the bean values
			if(function_from.equals("COPY_ORDER"))			// For COPY ORDER Only, to put it into existing orders
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
				existing_bean_obj.clear(); // Clear the existing order bean also
			}
			else if(function_from.equals("EXTERNAL_ORDER"))	// For EXTERNAL ORDER Only, to put it into EXTERNAL orders
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
				external_bean_obj.clear(); // Clear the External Order bean also
			}
			else if(function_from.equals("MULTI_PATIENT_ORDERS"))	// For MULTI PATIENT ORDER Only, to put it into Multi Patient Orders
			{
				out.println("<script>parent.refreshTab('"+function_from+"','"+existing_query_string+"');</script>");
				//multi_bean_obj.clear(); // Clear the Multi Patient Order Bean also
			}
			//IN066055 starts
			else if (ext_PH_Link.equals("EXT_PH_CALLED")){
				//background leaves black to focus the external pharmacy
			}
			//IN066055 ends
			else out.println("<script>parent.refreshTab('','');</script>");	// For Other orders, reload to call existing orders
	 	}
	}

            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(ammend_called_from));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(function_from));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(deceased_yn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(medico_legal_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(postmortem_status));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(callingFrom));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(body_part_yn));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(registration_no));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(bean.getLocationType()));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bean.getLocationCode()));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(bean.getPatientClass()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(lb_instal_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(session_id));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(iv_prep_yn));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(p_order_catalog_code));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(p_start_date_time));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(p_task_code));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(p_task_srl_no));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("episode_id"),"")));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("pract_reln_id"),"")));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("p_called_from_ca"),"")));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("Sex"),"")));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("Age"),"")));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("Dob"),"")));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("visit_adm_date"),"")));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("licence_key"),"")));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("pract_id"),"")));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("pract_name"),"")));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("order_mode"),"")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("bt_module_install"),"")));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("called_from"),"")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(beanQueryObj.checkForNull(request.getParameter("time_frame"),"")));
            _bw.write(_wl_block85Bytes, _wl_block85);

			// Nullifying the Objects
	copyOrderDetails		= null; // Nullifying the Objects
	previousValues			= null;	 amendPreviousValues	= null;
	record					= null;  OrderCategoryArr		= null;
	hmOrderCategory			= null;	 hashMap				= null;	
			

            _bw.write(_wl_block86Bytes, _wl_block86);
	if(function_from.equals("COPY_ORDER") && !(bean.checkForNull(catalog,"").equals("")) ) 
	{ 

            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(catalog));
            _bw.write(_wl_block88Bytes, _wl_block88);
	} 

	// set it back persistence
	putObjectInBean(bean_id,bean,request);

	if(function_from.equals("COPY_ORDER")) 
	{ 
		putObjectInBean(existing_bean_id,existing_bean_obj,request);
	} 
	else if(function_from.equals("EXTERNAL_ORDER")) 
	{
		putObjectInBean(existing_bean_id,external_bean_obj,request);
  	} 
	else if(function_from.equals("MULTI_PATIENT_ORDERS")) 
	{
		putObjectInBean(existing_bean_id,multi_bean_obj,request);
	}
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}

            _bw.write(_wl_block89Bytes, _wl_block89);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Consults.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.Dietary.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Laboratory.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.Miscellaneous.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.NursingCare.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderSet.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.OrderSet.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientCare.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Radiology.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.RadiologyDept.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgical.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Treatment.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.pharmacy.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.pharmacy.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.pharmacy.label", java.lang.String .class,"key"));
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
}
