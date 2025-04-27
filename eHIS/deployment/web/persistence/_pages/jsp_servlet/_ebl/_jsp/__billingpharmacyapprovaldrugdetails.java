package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.io.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.XSSRequestWrapper;
import eCommon.Common.*;
import eBL.RecordApprovalPatientDataBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __billingpharmacyapprovaldrugdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BillingPharmacyApprovalDrugDetails.jsp", 1727248168449L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1669269240919L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1669269240778L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!-- \r\n-----------------------------------------------------------------------------------------------\r\nDate       Edit History   Name        Description\r\n-----------------------------------------------------------------------------------------------\r\n\r\n-----------------------------------------------------------------------------------------------\r\nSr No              Version                Incident              SCF/CRF                        Developer Name\r\n1                                                            MMS-DM-CRF-0273         \t\t\tChandra Shekar Raju Arram\r\n\r\n-->\r\n\r\n\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 =" \r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\r\n\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n \r\n<html>\r\n<head>\r\n<title>Pharmacy Approval Status</title>\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\r\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\r\n<script language=\"JavaScript\" src=\"../../eBL/js/BillingRecordApprovalScript.js\"></script>\r\n</head>\r\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\r\n  <body onScroll=\"processScroll()\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\"  onSelect=\"codeArrestThruSelect();\">\r\n\t <form  id=\"BillingPreApprovalRequestDetailsForm\" name=\"BillingPreApprovalRequestDetailsForm\" >\r\n        \t<table align=\'center\'  cellpadding=3 cellspacing=0  width=\'100%\' id=\"record_approval_details_table\" name=\"record_approval_details_table\" border=\"1\">\t\t \r\n\t\t<THEAD>\r\n\t\t<TR>\t\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\r\n\t\t\t<td class=\'columnheader\' \twidth=\'3%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\r\n\t\t\t<td class=\'columnheader\' \twidth=\'20%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\r\n\t\t\t<td class=\'columnheader\' \twidth=\'8%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\r\n\t\t\t<td class=\'columnheader\' \twidth=\'20%\'\talign=\"left\"\t> Reasons for Rejection / Clarification </td>\r\n\t\t\t<td class=\'columnheader\' \twidth=\'8%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\r\n\t\t\t<td class=\'columnheader\' \twidth=\'6%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\r\n\t\t\t<td class=\'columnheader\' \twidth=\'10%\'\talign=\"left\"\t>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\r\n\t\t</TR>\r\n\t</THEAD>\r\n\t <!--  <tr>\r\n\t\t<td nowrap=\"nowrap\">\r\n\t\t<input type=\'text\' name=\'encounterIdFilter\' id=\'encounterIdFilter\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' size=\'12\'>\t\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'item_code_filter\' name=\'item_code_filter\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' size=\'10\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'item_desc_filter\' name=\'item_desc_filter\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\' size=\'30\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'orderDate_filter\' name=\'orderDate_filter\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' size=\'12\' onblur=\'isValidDate(this);\'>\r\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'orderDate_ctrl_filter\' onClick=\'return showCalendar(\"orderDate_filter\")\' />\t\t\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'item_qty_filter\' name=\'item_qty_filter\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' size=\'3\' >\r\n\t\t</td>\r\n\t\t<td nowrap>\r\n\t\t\t<select id=\"approval_status_filter\"\tname=\"approval_status_filter\" style=\"width: 100px;\">\r\n\t\t\t<option value=\'\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</option>\r\n\t\t\t\t<option value=\"A\"  ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" >Approved</option>\r\n\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" >Rejected</option>\r\n\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" >Pending</option>\r\n\t\t\t\t<option value=\"S\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 =" >Send to Insurance</option>\r\n\t\t\t\t<option value=\"H\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" >Hold</option>\r\n\t\t\t\t<option value=\"C\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =" >Clarification</option>\t\t\t\t\r\n\t\t\t</select>\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'reason_filter\' name=\'reason_filter\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' size=\'20\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'startDate_filter\' name=\'startDate_filter\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\' size=\'12\' onblur=\'isValidDate(this);\'>\r\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'startDate_ctrl_filter\' onClick=\'return showCalendar(\"startDate_filter\")\' />\r\n\t\t\t\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'endDate_filter\' name=\'endDate_filter\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' size=\'12\' onblur=\'isValidDate(this);\'>\r\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' id=\'endDate_ctrl_filter\' onClick=\'return showCalendar(\"endDate_filter\")\' />\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'freq_filter\' name=\'freq_filter\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' size=\'10\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'duration_filter\' name=\'duration_filter\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' size=\'3\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'durn_type_filter\' name=\'durn_type_filter\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' size=\'6\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'form_filter\' name=\'form_filter\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' size=\'8\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'uom_filter\' name=\'uom_filter\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' size=\'8\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'req_id_filter\' name=\'req_id_filter\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' size=\'10\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t<input type=\'text\' id=\'apprl_no_filter\' name=\'apprl_no_filter\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' size=\'10\' >\r\n\t\t</td>\r\n\t\t<td nowrap align=\"left\">\r\n\t\t\t&nbsp;\r\n\t\t</td>\r\n\t\t</tr>-->\r\n\r\n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\r\n            \r\n\r\n\t  <TR>\r\n\t    <td  class=\"fields\" \t\t><input type=\"text\" name=\"encounter_id";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\" id=\"encounter_id";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" disabled size=\'12\'/></td>\r\n\t\t<td  class=\"fields\" \t><input type=\"text\" name=\"item_code";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\" id=\"item_code";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\" disabled  size=\'10\'/></td>\r\n\t\t<input type=\"hidden\" name=\"drug_code";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" id=\"drug_code";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\"  value =\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\" size=\'10\'>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"item_desc";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\" id=\"item_desc";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" disabled  size=\'30\'/></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"order_date";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\" id=\"order_date";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\" disabled  size=\'12\'/></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"serv_qty";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\" id=\"serv_qty";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" disabled size=\'3\' /></td>\r\n\t\t<td  class=\"fields\" \t\t\t>\r\n\t\t     <input type=\"hidden\" name=\"approval_status";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\" id=\"approval_status";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" size=\'10\'>\r\n\t\t\t\t<select id=\"approval_status";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\"\tname=\"approval_status";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" onchange=\"asignStatus(this,\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\')\"";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="> \r\n\t\t\t\t<option  value=\"A\" ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" >Approved</option>\r\n\t\t\t\t<option  value=\"R\" ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =" >Rejected</option>\r\n\t\t\t\t<option  value=\"P\"  ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" >Pending</option>\r\n\t\t\t\t<option  value=\"S\" ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" >Send to Insurance</option>\r\n\t\t\t\t<option  value=\"H\" ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =" >Hold</option>\r\n\t\t\t\t<option  value=\"C\" ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =" >Clarification</option>\t\t\t\t\r\n\t\t\t\t</select></td>\r\n\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"reason";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\" id=\"reason";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\"  size=\'20\' ";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="/></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"start_date";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\" id=\"start_date";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\" disabled size=\'12\' /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"end_date";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" id=\"end_date";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\" disabled size=\'12\' /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"frequency";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\" id=\"frequency";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\" disabled size=\'10\' /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"duration";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" id=\"duration";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" disabled size=\'3\' /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"duration_type";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"duration_type";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\" disabled size=\'6\' /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"form";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"form";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" disabled size=\'8\' /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"pres_uom";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\" id=\"pres_uom";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" disabled size=\'8\' /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"request_id";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\" id=\"request_id";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" disabled  size=\'10\'/></td>\r\n\t\t                            <input type=\"hidden\" name=\"request_id_hid";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\" id=\"request_id_hid";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" size=\'10\'>\r\n\t\t<td  class=\"fields\" \t\t><input type=\"text\" name=\"apprl_no";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" id=\"apprl_no";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\"  size=\'10\' ";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =" /></td>\r\n\t\t<td  class=\"fields\" \t\t><input type=\'Checkbox\' id=\"select";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" name=\"select";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" value =\"N\" onClick=\" check_Status(this);\" align=\"left\"   ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="/></td>\r\n\t\t<input type=\"hidden\" name=\"order_id";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" id=\"order_id";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\r\n\t\t<input type=\"hidden\" name=\"order_line_num";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\" id=\"order_line_num";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\r\n";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\r\n\t\t\r\n</TR>\r\n</table>\r\n            <input type=\'hidden\' name=\'locale\'\tid=\'locale\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'\t/ >\r\n\t\t\t<input type=\'hidden\' name=\'calledForm\'\tid=\'calledForm\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' / >\r\n\t\t\t<input type=\'hidden\' name=\'facilityId\'\tid=\'facilityId\' \tvalue=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\" >\r\n\t\t\t<input type=\'hidden\' name=\'patinetId\' \tid=\'patinetId\'\t\tvalue=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" >\r\n\t\t\t<input type=\'hidden\' name=\'episodeType\' id=\'episodeType\'\tvalue=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" >\r\n\t\t\t<input type=\'hidden\' name=\'encounterId\'  id=\'encounterId\'\tvalue=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" >\r\n\t\t\t<input type=\'hidden\' name=\'policyTypeCode\' id=\'policyTypeCode\'\tvalue=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\" >\r\n\t\t\t<input type=\'hidden\' name=\'custGroupCode\' id=\'custGroupCode\'\tvalue=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" >\r\n\t\t\t<input type=\'hidden\' name=\'custCode\' \tid=\'custCode\'\t\tvalue=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" />\r\n\t\t\t<input type=\'hidden\' name=\'episodeId\' \t\tid=\'episodeId\'\tvalue=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" />\r\n\t\t\t<input type=\'hidden\' name=\'row_count\' \t\tid=\'row_count\'\tvalue=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" />\r\n\t\t\t<input type=\'hidden\' name=\'rowCount\'\tid=\'rowCount\' value=\"\"\t/ >\r\n</form>\r\n</body>\r\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\r\n</html>\r\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

try{
    String locale 						        = 	(String)session.getAttribute("LOCALE");
    String facilityId							=   (String) session.getValue( "facility_id" ) ;
	String patinetId							=	request.getParameter("patinetId")==null?"":request.getParameter("patinetId");
	String episodeType							=	request.getParameter("episodeType")==null?"":request.getParameter("episodeType");
	String episodeId							=	request.getParameter("episodeId")==null?"":request.getParameter("episodeId");
	String encounterId                          =	request.getParameter("encounterId")==null?"":request.getParameter("encounterId");
	String customerGroupCode					=	request.getParameter("custGroupCode")==null?"":request.getParameter("custGroupCode");
	String customerCode						    =	request.getParameter("custCode")==null?"":request.getParameter("custCode");
	String policyCode							=	request.getParameter("policyTypeCode")==null?"":request.getParameter("policyTypeCode");
	String calledForm                           =	request.getParameter("calledForm")==null?"":request.getParameter("calledForm");
	String pharmApprovStats      				= request.getParameter("pharmApprovStats")==null?"":request.getParameter("pharmApprovStats");//Added for MMS-DM-CRF-0273
 	String displayPh1 = ""; //Added for MMS-DM-CRF-0273
	System.err.println("calledForm@@@==="+calledForm);
	
	if(pharmApprovStats.equals("PHIS")){
		displayPh1 = "disabled";
	}
	else{
		displayPh1 = "";
	}
	String encounter_id                         =   "";
	String item_code                            =   "";
	String item_desc                            =   "";
	String order_date                           =   "";
	String serv_qty                             =   "";
	String start_date                           =   "";
	String end_date                             =   "";
	String pres_uom                             =   "";
	String freq_desc                            =   "";
	String duration                             =   "";
	String duration_type                        =   "";
	String app_request_id                       =   "";
	String approval_id                          =   "";
	String app_status                           =   "";
	String app_remarks                          =   "";
	String form                                 =   "";
	String encounterIdFilter                    =   "";
	String item_code_filter                     =   "";
	String item_desc_filter                     =   "";
	String order_id                             =   "";
	String order_line_num                       =   "";
    String serviceDate_filter ="", item_qty_filter="", approval_status_filter="",reason_filter ="",startDate_filter ="",endDate_filter ="",freq_filter ="",duration_filter ="",durn_type_filter ="",form_filter="",uom_filter="",req_id_filter="",apprl_no_filter="";
	int row_count                               =0;
    String bean_id								= 	"RecordApprovalPatientDataBean" ;
	String bean_name							= 	"eBL.RecordApprovalPatientDataBean";
	RecordApprovalPatientDataBean recordApprovalPatientDataBean								= 	(RecordApprovalPatientDataBean)getBeanObject( bean_id, bean_name, request ) ;
	System.err.println("facilityId=="+facilityId+"patinetId==="+patinetId+"episodeType==="+episodeType+"episodeId==="+episodeId+"customerGroupCode=="+customerGroupCode+"customerCode==="+customerCode+"policyCode==="+policyCode);
         ArrayList drugDetails = recordApprovalPatientDataBean.getDrugDetails(facilityId,patinetId,episodeType,episodeId,customerGroupCode,customerCode,policyCode);
		 System.err.println("drugDetails==="+drugDetails);

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounterIdFilter));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(item_code_filter ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(item_desc_filter ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(serviceDate_filter ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(item_qty_filter ));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(("A".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(("R".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(("P".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(("S".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(("H".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(("C".equals(approval_status_filter))?"selected":"" ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(reason_filter ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(startDate_filter ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(endDate_filter ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(freq_filter ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(duration_filter ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(durn_type_filter ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(form_filter ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(uom_filter ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(req_id_filter ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(apprl_no_filter ));
            _bw.write(_wl_block37Bytes, _wl_block37);
 
// System.err.println("drugDetails.size()=="+drugDetails.size());
         if(drugDetails.size()>0){
           for(int index=0;index <drugDetails.size();index=index+18){
			     encounter_id                         =   (String)drugDetails.get(index) ==null?"":(String)drugDetails.get(index);
			     item_code                            =   (String)drugDetails.get(index+1) ==null?"":(String)drugDetails.get(index+1);
				 item_desc                            =   (String)drugDetails.get(index+2) ==null?"":(String)drugDetails.get(index+2);
				 order_date                           =   (String)drugDetails.get(index+3) ==null?"":(String)drugDetails.get(index+3);
				 serv_qty                             =   (String)drugDetails.get(index+4) ==null?"":(String)drugDetails.get(index+4);
				 app_status                           =   (String)drugDetails.get(index+5) ==null?"P":(String)drugDetails.get(index+5);
				 app_remarks                          =   (String)drugDetails.get(index+6) ==null?"":(String)drugDetails.get(index+6);
				 start_date                           =   (String)drugDetails.get(index+7) ==null?"":(String)drugDetails.get(index+7);
				 end_date                             =   (String)drugDetails.get(index+8) ==null?"":(String)drugDetails.get(index+8);
				 freq_desc                            =   (String)drugDetails.get(index+9) ==null?"":(String)drugDetails.get(index+9);
				 duration                             =   (String)drugDetails.get(index+10) ==null?"":(String)drugDetails.get(index+10);
				 duration_type                        =   (String)drugDetails.get(index+11) ==null?"":(String)drugDetails.get(index+11);
				 form                                 =   (String)drugDetails.get(index+12) ==null?"":(String)drugDetails.get(index+12);
				 pres_uom                             =   (String)drugDetails.get(index+13) ==null?"":(String)drugDetails.get(index+13);
				 app_request_id                       =   (String)drugDetails.get(index+14) ==null?"":(String)drugDetails.get(index+14);
				 approval_id                          =   (String)drugDetails.get(index+15) ==null?"":(String)drugDetails.get(index+15);
				 order_id                             =   (String)drugDetails.get(index+16) ==null?"":(String)drugDetails.get(index+16);
				 order_line_num                       =   (String)drugDetails.get(index+17) ==null?"":(String)drugDetails.get(index+17);
//				 System.err.println("order_id==="+order_id+"order_line_num==="+order_line_num);
				 
         //System.err.println("encounter_id==="+encounter_id+"item_code=="+item_code+"item_desc=="+item_desc+"order_date=="+order_date+"serv_qty=="+serv_qty+"app_status=="+app_status+"app_remarks=="+app_remarks+"start_date=="+start_date+"end_date=="+end_date+"freq_desc=="+freq_desc+"duration=="+duration+"form=="+form+"pres_uom=="+pres_uom+"app_request_id=="+app_request_id+"approval_id=="+approval_id);

            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(item_code));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(item_code ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(item_desc));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(order_date));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(serv_qty));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(app_status ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( displayPh1 ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(app_status	!=	null && app_status.equalsIgnoreCase("A") ? "SELECTED" : "" ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(app_status	!=	null && app_status.equalsIgnoreCase("R") ? "SELECTED" : "" ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(app_status	!=	null && app_status.equalsIgnoreCase("P") ? "SELECTED" : "" ));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(app_status	!=	null && app_status.equalsIgnoreCase("S") ? "SELECTED" : "" ));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(app_status	!=	null && app_status.equalsIgnoreCase("H") ? "SELECTED" : "" ));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(app_status	!=	null && app_status.equalsIgnoreCase("C") ? "SELECTED" : "" ));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(app_remarks));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( displayPh1 ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(start_date));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(end_date));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(freq_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(duration));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(duration_type));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(form));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(index));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(pres_uom));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(app_request_id));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(app_request_id ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(approval_id));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( displayPh1 ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( displayPh1 ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_id ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(order_line_num ));
            _bw.write(_wl_block95Bytes, _wl_block95);

		  row_count++;
		   }
		 }

            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(calledForm));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(patinetId));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(episodeType));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(encounterId));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(policyCode));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(customerGroupCode));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(customerCode));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(episodeId));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(row_count));
            _bw.write(_wl_block107Bytes, _wl_block107);

}catch(Exception e){
	e.printStackTrace();
}

            _bw.write(_wl_block108Bytes, _wl_block108);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemCode.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ServiceQnty.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.enddate.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Frequency.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DurationType.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Form.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.uom.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.requestid.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ApprovalNumber.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
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
}
