package jsp_servlet._eds._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.ArrayList;
import java.util.*;
import com.ehis.util.*;

public final class __mealprepareservedrejecteditems extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eds/jsp/MealPrepareServedRejectedItems.jsp", 1724772292000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">\n<html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n\t<script type=\"text/javascript\" src=\"../../framework/js/hashtable.js\"></script>\n\t<script src=\'../../eCommon/js/messages.js\' language=\'javascript\'></script>\n\t<script type=\"text/javascript\" src=\"../../core/lookup/js/Lookup.js\"></script>\n\t<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script type=\'text/javascript\' src=\'../../eDS/js/MealPreparedServedComplaints.js\'></script>\n\t<script type=\"text/javascript\" src=\"../../framework/js/hashtable.js\"></script>\n\t<script language=\"Javascript\" src=\"../../framework/js/PopupWindow.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script src=\"../../eCommon/js/dchk.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n</head>\n<script>\n</script>\n<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n\n<body OnMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" \tonLoad=\"getFoodItem(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\', \'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\">\n\t<form name=\"rejectedItemsForm\" id=\"rejectedItemsForm\" method=\"post\">\n\n\t\t<table  id=\"contentTable1\" border=\'0\' cellspacing=\'0\' width=\'100%\'  align=\'center\'>\n\t\t<tr>\n\t\t<th width=\'30%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t<th width=\'10%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th width=\'25%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\t\t\n\t\t<th width=\'30%\'>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t</th>\n\t\t\n\t\t</tr>\n\t\t</table>\n\t\t<div id=\"listContentLayer\" style=\"overflow: auto;height: 180px;\">\n\t\t<table  id=\"contentTable\" border=\'1\' cellspacing=\'0\' width=\'100%\' align=\'center\'>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t<tr>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\" width=\"30%\" nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n\t\t\t\t<input type=\"hidden\" name=\"itemCode";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" id=\"itemCode";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n\t\t\t\t<input type=\"hidden\" name=\"rejectedQty";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\" id=\"rejectedQty";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" width=\"10%\" nowrap>\n\t\t\t\t\t<input type=\"checkbox\" name=\"rejectedYn";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" id=\"rejectedYn";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" onclick=\"getCellVal(this,\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\')\"/>\n\t\t\t\t\t<script>\n\t\t\t\t\t\tvar chk=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\';\n\t\t\t\t\t\tvar i=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =";\n\t\t\t\t\t\tif(chk==\"Y\") {\n\t\t\t\t\t\t\tdocument.getElementById(\"rejectedYn\"+i).checked=true;\n\t\t\t\t\t\t\tdocument.getElementById(\"rejectedYn\"+i).value=\'Y\';\n\t\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" width=\"25%\" nowrap>\n\t\t\t\t\t<input type=\"text\" name=\"rejdate";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\" id=\"rejdate";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" length=\"16\" onblur=\"val_date(this)\"/>\n\t\t\t\t\t<a onclick=\"return showCalForNonFreq(\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\',\'rejdate";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\',\'%d/%m/%Y %H:%M\',\'24\',true,\'rejdate";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\');\" >\n\t\t\t\t\t\t<img id=\"cal";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" disabled src=\"../../framework/images/img.gif\">\n\t\t\t\t\t</a>\n\t\t\t\t</td>\n\t<td class=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" width=\"30%\" nowrap>\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\t\t\t\n\t\t<input type=\"text\" disabled size=\"35\" name=\"complaintDesc";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"complaintDesc";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" onblur=\"showComplaintslookup(this,\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\')\"  value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t\t<input type=\"hidden\" name=\"complaintCode";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" id=\"complaintCode";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t\t<input type=\"button\" id=\"RejectedItemLookup";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" disabled class=\"BUTTON\" value=\"?\" onclick=\"showComplaintslookup(this,\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\" />\n\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\t\t\t\n\t\t<input type=\"text\" size=\"35\" name=\"complaintDesc";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" class=\"BUTTON\" value=\"?\" onclick=\"showComplaintslookup(this,\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<input type=\"text\" size=\"35\" name=\"complaintDesc";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\n\t\t<!-- Added Against Start ML-MMOH-CRF-1125[IN:067026] -->\n\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\t\t<a id=\"othersLink";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" name=\"othersLink";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="  disabled href=\"javascript:OtherCompReject(";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =")\"; > &nbsp&nbsp Others </a>\t\t\n\t\t<input type=\"hidden\" id=\"othersComp";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\" name=\"othersComp";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\" />\n\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" href=\"javascript:OtherCompReject(";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" />\t\n\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t<!-- Added Against End ML-MMOH-CRF-1125[IN:067026] -->\n\t\t<img id=\"mandatory";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\" style=\"visibility:hidden\" src=\"../../framework/images/mandatory.gif\"/>\n\t</td>\n</tr>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\t\t<input type=\"hidden\" name=\"index\" id=\"index\" value=\"";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"/>\n\t</table>\n</div>\n\t<table  id=\"buttonTable\" border=\'0\' cellspacing=\'0\' width=\'100%\'  align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'30%\'></td>\n\t\t\t<td width=\'10%\'></td>\n\t\t\t<td width=\'25%\'></td>\n\t\t\t<td width=\'30%\' align=\'right\'>\n\t\t<!-- TODO: setDate validation -->\n\t\t<input type=\'button\'  class=\'BUTTON\' name=\'select\' id=\'select\' value=\'Select\' onClick=\'submit123()\'/>\n\t\t<input type=\'reset\' class=\'BUTTON\' name=\'cancel\' id=\'cancel\' value=\'Cancel\' onClick=\'parent.parent.document.getElementById(\"dialog_tag\").close(); \'/></td>\n\t\t</tr>\n\t</table>\n\t\t<input type=\"hidden\" name=\"method\" id=\"method\" />\n\t\t<input type=\"hidden\" name=\"functionId\" id=\"functionId\" value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" />\n\t\t<input type=\"hidden\" name=\"moduleId\" id=\"moduleId\" value=\"";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" />\n\t\t<!-- <input type=\"text\" name=\"method\" id=\"method\" /> -->\n\t\t<input type=\"hidden\" name=\"checkFlag\" id=\"checkFlag\" value=\"Y\"  />\n\t\t<input type=\"hidden\" name=\"updateFlag\" id=\"updateFlag\" value=\"N\"/>\t\t\n\t\t<input type=\"hidden\" name=\"mealType\" id=\"mealType\" value=\"";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" />\n\t\t<input type=\"hidden\" name=\"sourceCode\" id=\"sourceCode\" value=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" />\t\t\n\t\t<input type=\"hidden\" name=\"sourceType\" id=\"sourceType\" value=\"N\" />\n\t\t\n\t\t<input type=\"hidden\" name=\"splFoodItemYn\" id=\"splFoodItemYn\" value=\"N\" />\n\t\t\n\t\t<input type=\"hidden\" name=\"freqYn\" id=\"freqYn\" value=\"N\" />\n\t\t<input type=\"hidden\" name=\"encounterId\" id=\"encounterId\" value=\"";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" />\n\t\t<input type=\"hidden\" name=\"patientClass\" id=\"patientClass\" value=\"";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" />\n\t\t<input type=\"hidden\" name=\"kitchenCode\" id=\"kitchenCode\" value=\"";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" />\n\t\t<input type=\"hidden\" name=\"operatingFacilityId\" id=\"operatingFacilityId\" value=\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" />\n\t\t<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" />\n\t\t<input type=\"hidden\" name=\"mealServedDate\" id=\"mealServedDate\" value=\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" />\n\t\t<input type=\"hidden\" name=\"mealServedDatePattern\" id=\"mealServedDatePattern\" value=\"dd/MM/yyyy HH:mm\" />\n\t\t<input type=\"hidden\" name=\"servingDate\" id=\"servingDate\" value=\"";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" />\n\t\t<input type=\"hidden\" name=\"servingDatePattern\" id=\"servingDatePattern\" value=\"dd/MM/yyyy\" />\n\t\t<input type=\"hidden\" name=\"dietType\" id=\"dietType\" value=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" />\n\t\t<input type=\"hidden\" name=\"locale1\" id=\"locale1\" value=\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" />\n\t\t<input type=\"hidden\" name=\"languageId\" id=\"languageId\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" />\n\t\t<input type=\"hidden\" name=\"eventDate\" id=\"eventDate\" value=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" />\n\t\t<input type=\"hidden\" name=\"index\" id=\"index\"/>\n\t\t<input type=\"hidden\" name=\"index1\" id=\"index1\"/>\n\t\t<input type=\"hidden\" name=\"status\" id=\"status\" value=\"MS\" />\n\t\t\n\t\t<input type=\"hidden\" name=\"complaintCode\" id=\"complaintCode\" value=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" />\n\t\t<input type=\"hidden\" name=\"complaintDesc\" id=\"complaintDesc\" value=\"";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" />\n\t\t<input type=\"hidden\" name=\"menuCode\" id=\"menuCode\" value=\"";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" />\n\t\t<input type=\"hidden\" name=\"mealClass\" id=\"mealClass\" value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" />\n\t\t<input type=\"hidden\" name=\"mealCategory\" id=\"mealCategory\" value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" />\n\t\t\n\t\t<input type=\"hidden\" name=\"splFoodItemYn\" id=\"splFoodItemYn\" value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" />\n\t\t<input type=\"hidden\" name=\"frameName\" id=\"frameName\"  value=\"mealTypeFrame\" />\n\t\t<input type=\"hidden\" name=\"status\" id=\"status\"  value=\"MS\" />\n\t\t<input type=\"hidden\" name=\"status1\" id=\"status1\"  value=\"PMR\" />\n\n\t\t<input type=\"hidden\" name=\"totalItems\" id=\"totalItems\"  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" />\n\t\t<input type=\"hidden\" name=\"isMealComplaints\" id=\"isMealComplaints\" id=\"isMealComplaints\"  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" /> <!-- Added Against ML-MOH-CRF-1125 -->\n\t</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
	
    //Added Against MMS Vulnerability Issue - Starts
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

    String functionId = (String) session.getAttribute("functionId");
	String facility_id = (String)session.getAttribute("facility_id");

	String title = (String) request.getParameter("title");
	String moduleId = (String) session.getAttribute("moduleId");
	String encounterId = (String) request.getParameter("encounterId");
	String mealType = (String) request.getParameter("mealType");
	String servingDate = (String) request.getParameter("servingDate");
	String eventDate = (String) request.getParameter("eventDate");
	String languageId = (String) request.getParameter("languageId");
	String sourceCode = (String) request.getParameter("sourceCode");
	String patientId = (String) request.getParameter("patientId");
	String patientClass = (String) request.getParameter("patientClass");
	String kitchenCode = (String) request.getParameter("kitchenCode");
	String mealCategory = (String) request.getParameter("mealCategory");
	String dietType = (String) request.getParameter("dietType");
	String mealClass = (String) request.getParameter("mealClass");
	//String status = (String) request.getParameter("status");
	String complaintCode = (String) request.getParameter("complaintCode");
	String complaintDesc = (String) request.getParameter("complaintDesc");
	String menuCode = (String) request.getParameter("menuCode");
	String splFoodItemYn = (String) request.getParameter("splFoodItemYn");
	//Added Against Start ML-MMOH-CRF-1125[IN:067026]
	String othersComp = (String) request.getParameter("othersComp");
	boolean isMealComplaints =false;
	isMealComplaints=Boolean.valueOf(request.getParameter("isMealComplaints"));	
	//Added Against End ML-MMOH-CRF-1125[IN:067026]
	//String fName = (String) request.getParameter("fName");

	String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
					.getAttribute("PREFERRED_STYLE") != "")) ? (String) session
					.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			if (sStyle == null)
				sStyle = "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(title));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mealType));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(servingDate));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(languageId));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(splFoodItemYn));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
if(isMealComplaints){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

			String sql="select b.food_Item_Code,b.short_Desc,a.item_Qty from Ds_Epsd_Meal_Plan_Dtl a,Ds_Items b where a.encounter_Id like :encounterId and a.meal_Type like :mealType and to_char(a.serving_Date,'dd/MM/yyyy') like :srvDate and a.item_Code = b.food_Item_Code and b.language_Id like :languageId";
			String food_Item_Code="",foodItem_desc="",quantity="",classValue="",rejected_YN="",complaint_long_desc="",rejDateTime="",complaint_code="",othersCompDesc="",visibleStyle=""; //Added Against ML-MMOH-CRF-1125
			Connection connection   = null ;
			PreparedStatement pstmt = null ;
			PreparedStatement ps = null ;
			ResultSet resultSet     = null ;
			ResultSet rs     = null ;
			int i=0;
			try{
					connection			= ConnectionManager.getConnection(request);
					pstmt = connection.prepareStatement(sql);
					pstmt.setString(1,encounterId);
					pstmt.setString(2,mealType);
					pstmt.setString(3,servingDate);
					pstmt.setString(4,languageId);
					resultSet = pstmt.executeQuery();

					while(resultSet.next()){
						food_Item_Code= foodItem_desc = quantity= complaint_long_desc= rejected_YN= rejDateTime=complaint_code= othersCompDesc =""; //Added Against ML-MMOH-CRF-1125
// 						sysdate=resultSet.getString("sys_date");
// 						if(sysdate ==null) sysdate="";
						food_Item_Code=(resultSet.getString("food_Item_Code"));
						foodItem_desc=(resultSet.getString("short_Desc"));
						quantity=(resultSet.getString("item_Qty"));
						i++;
					classValue =(i%2==0)?"qryEven":"qryOdd";
					/* Modified Against Start ML-MOH-CRF-1125 */
					//String sql_rejItems="select rejections.REJECTED_YN,rejections.rejected_reason, complaints.long_desc,to_char(rejections.REJECTED_DATE,'DD/MM/YYYY hh24:mi') as rejDateTime,rejections.OTH_COMPLAINT_DESC from Ds_Epsd_Meal_Item_Rejections rejections,DS_COMPLAINTS_LANG_VW complaints where rejections.operating_Facility_Id =? and rejections.encounter_Id =? and  to_char(rejections.serving_date,'dd/mm/yyyy')=? and rejections.spl_Food_Item_Yn ='N' and rejections.meal_Type =? and  rejections.item_Code =? and rejections.rejected_reason=complaints.complaint_code and complaints.eff_status='E' and complaints.language_id=?";					
					String sql_rejItems="select rejections.REJECTED_YN, rejections.rejected_reason,ds_get_desc.ds_complaints(rejections.rejected_reason,?,'1') long_desc,TO_CHAR (rejections.rejected_date,'DD/MM/YYYY hh24:mi') AS rejDateTime,rejections.OTH_COMPLAINT_DESC from Ds_Epsd_Meal_Item_Rejections rejections WHERE rejections.operating_facility_id = ? AND rejections.encounter_id = ? AND TO_CHAR (rejections.serving_date, 'dd/mm/yyyy') = ? AND rejections.spl_food_item_yn = 'N' AND rejections.meal_type = ? AND rejections.item_code = ?";
					/* Modified Against End ML-MOH-CRF-1125 */
					ps = connection.prepareStatement(sql_rejItems);					 
					ps.setString(1,languageId);
					ps.setString(2,facility_id);
					ps.setString(3,encounterId);
					ps.setString(4,servingDate);
					ps.setString(5,mealType);
					ps.setString(6,food_Item_Code);					
					rs = ps.executeQuery();
					while(rs.next()){
						rejected_YN=rs.getString("REJECTED_YN");
						complaint_code=rs.getString("rejected_reason");
						if(complaint_code==null) complaint_code="";
						complaint_long_desc=rs.getString("long_desc");
						if(complaint_long_desc==null) complaint_long_desc="";
						rejDateTime=rs.getString("rejDateTime");
						if(rejDateTime==null) rejDateTime="";
						othersCompDesc=rs.getString("OTH_COMPLAINT_DESC"); //Added Against ML-MMOH-CRF-1125
						if(othersCompDesc==null) othersCompDesc=""; 
						
					}
					if(rs!=null) rs.close();
					if(ps!=null) ps.close();
		
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(foodItem_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(i));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(food_Item_Code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(quantity));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(i));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(rejected_YN));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rejDateTime));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
if(isMealComplaints){		
			if(othersCompDesc!=""){
		
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(complaint_long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(complaint_code ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
}else{
		
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(complaint_long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(complaint_code ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
}}else{
		
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(complaint_long_desc));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(complaint_code ));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
}
            _bw.write(_wl_block53Bytes, _wl_block53);
if(isMealComplaints){	
			if(!complaint_long_desc.equals("")){ 
				visibleStyle="style='visibility:visible;'"; 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(visibleStyle));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(othersCompDesc));
            _bw.write(_wl_block60Bytes, _wl_block60);
}else if(!othersCompDesc.equals("")){ 
			visibleStyle="style='visibility:visible;'"; 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(visibleStyle));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(othersCompDesc));
            _bw.write(_wl_block62Bytes, _wl_block62);
}else{ 
			visibleStyle="style='visibility:hidden;'"; 
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(visibleStyle));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(othersCompDesc));
            _bw.write(_wl_block62Bytes, _wl_block62);
}}
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(i));
            _bw.write(_wl_block64Bytes, _wl_block64);

	    } //While loop closing
		}catch(Exception e){
			e.printStackTrace();
	        System.err.println("Exception=="+e);
		}finally{
			if(resultSet!=null) resultSet.close();
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			if(ps!=null) ps.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
	    }

            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(functionId));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(moduleId));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(mealType));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(sourceCode));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(patientClass));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(kitchenCode));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(eventDate));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(servingDate));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(dietType));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(languageId));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(languageId));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(eventDate));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(complaintCode));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(complaintDesc));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(menuCode));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(mealClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(mealCategory));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(splFoodItemYn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(isMealComplaints));
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FoodItem.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Rejected.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Complaints.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.others.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.Complaints.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
