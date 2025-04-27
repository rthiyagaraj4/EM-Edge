package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BlServiceDiscPriceBean;
import webbeans.eCommon.ConnectionManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.util.*;
import com.ehis.util.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import java.lang.*;
import java.text.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __blamendmultiservicepricedtlsdrugmeditem extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eBL/jsp/BLAmendMultiServicePriceDtlsDrugMedItem.jsp", 1726819560198L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\r\n\r\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\r\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\r\n<script>\r\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\r\n</script>\r\n\r\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\r\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\r\n<html>\r\n<head>\r\n<script>\r\nfunction fnApplyDiscPrice(val,index)\r\n{\r\n\tvar effFromDate             = document.getElementById(\"effFromDate\"+index).value;\r\n\tvar effToDate               = document.getElementById(\"effToDate\"+index).value;\r\n\tvar DrugItemPriceSetupMMSYN = document.getElementById(\"DrugItemPriceSetupMMSYN\").value;\r\n\tvar serviceind              = document.getElementById(\"serviceind\").value;\r\n\tif(effFromDate == \'\'){\r\n\t\talert(\"Effective From cannot be Blank\");\r\n\t\tdocument.getElementById(\'apply_discount\'+index).checked = false;\r\n\t\tdocument.getElementById(\"effFromDate\"+index).focus();\r\n\t\treturn false;\r\n\t}\r\n\r\n\tif(val.checked==true || val.checked==\'true\'){\r\n\r\n\t\tdocument.getElementById(\'apply_discount\'+index).value=\'Y\';\r\n\t\tdocument.getElementById(\'applydiscount\'+index).value=\'Y\';\r\n\t\tparent.BLMultiDiscPrice.location.href =\'../../eBL/jsp/BLMultiDiscPriceCreate.jsp\'+\"?effFromDate=\"+effFromDate+\"&effToDate=\"+effToDate+\"&DrugItemPriceSetupMMSYN=\"+DrugItemPriceSetupMMSYN+\"&serviceind=\"+serviceind;\t\t\r\n\t\tdocument.getElementById(\"dtls\"+index).disabled=false;\r\n\t\tdocument.getElementById(\"indexSelected\").value=index;\r\n\t}else{\r\n\t\tdocument.getElementById(\'apply_discount\'+index).value=\'N\';\r\n\t\tdocument.getElementById(\'applydiscount\'+index).value=\'N\';\r\n\t\tparent.BLMultiDiscPrice.location.href =\'../../eCommon/html/blank.html\';\r\n\t\tdocument.getElementById(\"dtls\"+index).disabled=true;\r\n\t\tdocument.getElementById(\"indexSelected\").value=\'\';\r\n\t}\r\n}\r\n\t\r\n\r\nfunction costind(val,index)\r\n{\r\n\tif(checkDisc_indicator(index)){\r\n\t\tdocument.getElementById(\'cost_ind\'+index).value=val.value;\r\n\t\tdocument.getElementById(\'costind\'+index).value=val.value;\r\n\t\r\n\t}\r\n}\r\nfunction checkDisc_indicator(i) {\r\n\t\r\n\tvar cost_indicator = document.getElementById(\"cost_ind\"+i).value;\r\n\tvar cost_amount    = document.getElementById(\"cost_amt\"+i);\r\n\tif(cost_indicator == \'P\'){\t\t\t\r\n\t\tif(cost_amount.value > 100){\r\n\t\t\talert(\'Percentage cannot be greater than 100\');\r\n\t\t\tcost_amount.value = \"\";\r\n\t\t\treturn false;\r\n\t}\r\n\t}\t\r\n\telse if(cost_indicator == \'N\' && cost_amount.value !=\'\'){\r\n\t\talert(\'Cost Indicator Not applicable \');\r\n\t\tcost_amount.value = \"\";\r\n\t\treturn false;\r\n\t}\r\n\t\treturn true;\r\n}\r\n\t\r\n</script>\r\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n<title>Insert title here</title>\r\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'/>\r\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\r\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\r\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\r\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\r\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\r\n<script language=\"javascript\" src=\"../../eBL/js/BLServiceDiscountPrice.js\"></script>\r\n<script language=\'javascript\' src=\'../../eCommon/js/jquery.js\'></script>\t\r\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\r\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\r\n<STYLE TYPE=\"text/css\">\r\ndiv.tableContainer {\r\n\twidth: 100%;\t\t/* table width will be 99% of this*/\r\n\theight: 460px; \t/* must be greater than tbody*/\r\n\toverflow: auto;\r\n\tmargin: 0 auto;\r\n}\r\ntable {\r\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\r\n\tborder: none;\r\n\tbackground-color: #f7f7f7;\r\n\t}\r\n\t\r\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\r\n\toverflow: auto; \r\n\theight: 120x;\r\n\toverflow-x: hidden;\r\n\t}\r\n\t\r\n /*thead tr\t{     added against MMS-QH-CRF-0128.4 */\r\n\tposition:relative; \r\n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\r\n\t}\r\n\t\t\r\n\t\tdiv.tableContainer {\r\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\r\n\t\theight: 140px; \t/* must be greater than tbody*/\r\n\t\toverflow: scroll;\r\n\t\tmargin: 0 auto;\r\n\t}\t*/\t\r\n\r\n\t\tTD.YELLOW \r\n\t\t{\t\t\t\r\n\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\tFONT-SIZE: 8pt ;\r\n\t\t\tborder-style: dashed;\r\n\t\t\tborder-left-color: #D5E2E5;\r\n\t\t\tborder-right-color: #D5E2E5;\r\n\t\t\tborder-top-color: #D5E2E5;\r\n\t\t\tborder-bottom-color: #D5E2E5; \r\n\t\t}\r\n\t\t\r\n\t\t.LocalYellow\r\n\t\t{\r\n\t\t\tCOLOR:#444444;\r\n\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\tFONT-SIZE: 8pt ;\r\n\t\t\tborder: 1x;\r\n\t\t\tborder-style: dashed;\r\n\t\t\tborder-left-color: #D5E2E5;\r\n\t\t\tborder-right-color: #D5E2E5;\r\n\t\t\tborder-top-color: #D5E2E5;\r\n\t\t\tborder-bottom-color: #D5E2E5; \r\n\t\t\tPADDING-LEFT:7px;\r\n  \t\t\tPADDING-RIGHT:7px\r\n\t\t}\r\nSPAN.LABEL\r\n{\r\n  COLOR:#444444;\r\n  /*background-color:#FFFFFF;*/\r\n  background-color:#FFFFFF;\r\n  FONT-SIZE: 8pt;\r\n  TEXT-ALIGN: LEFT;\r\n  /*TEXT-ALIGN: RIGHT;*/\r\n  PADDING-LEFT:7px;\r\n  PADDING-RIGHT:7px\r\n}\r\nSPAN.SpanYellow\r\n\t\t{\r\n\t\t\tCOLOR:#444444;\r\n\t\t\tBACKGROUND-COLOR: yellow ;\r\n\t\t\tFONT-SIZE: 8pt ;\r\n\t\t\tPADDING-LEFT:7px;\r\n  \t\t\tPADDING-RIGHT:7px\r\n\t\t}\r\n\t\t\r\n</STYLE>\r\n</head>\r\n<!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\r\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\r\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onload=\"changeFieldColor(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'); showDiscAvailable(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\');\">\r\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\r\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\">\r\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\r\n\t<form  method=\'post\' name = \'Pricedtlsbulkadd\' id=\'Pricedtlsbulkadd\'>\t\r\n\t<div id=\"tableContainer\">\t\r\n      \t\t<table cellpadding=0 cellspacing=0  width=\"100%\" id=\'MultipricebulkupdDrugMedItem\' name=\'MultipricebulkupdDrugMedItem\'>\r\n\t\t\t\t\r\n\t\t<tr>\r\n\t\t\t<td colspan=\'19\' align=\"left\" nowrap>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" </td>\r\n\t\t</tr>\r\n\t\t<tr>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\">\r\n\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\">\r\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'IPLbl\'>\r\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'OPLbl\'>\r\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'EMLbl\'>\r\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'EXLbl\'>\r\n\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'DCLbl\'>\r\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'reimbursableLbl\'>\r\n\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'overRideLbl\' >\r\n\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'reimbursableTypeLbl\' >\r\n\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'reimbursableAmtLbl\' >\r\n\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" id=\'publicPriceLbl\' >\r\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\">\r\n\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\r\n\t\t\t</td>\r\n\t\t\t<td class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" colspan=2>\r\n\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\r\n\t\t\t</td>\r\n\r\n      \t\t</tr>\r\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\r\n\t\t\t\t\t<!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\r\n\t\t\t<tr  onclick=\"changeFieldColor(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'); if(alrdSelect(\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\')){showDiscAvailable(\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');}\">\r\n\t\t\t\r\n\t\t\t<td id=\'effectiveFrmDate";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' width=\'20%\' nowrap class=\'fields\'>\t\t\t\t\t\t\t\r\n\t\t\t\t<input type=\'text\' name=\'effFromDate";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'effFromDate";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'size=\'10\' maxlength=\'10\' onBlur=\'isValidDate(this,\"EF\",";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="); callValidateDate_Drug(1);\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' readonly />\r\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effFromDate_ctrl";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onClick=\"return showCalendar(\'effFromDate";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\');\" disabled />&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td id=\'effectivetoDate";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\' width=\'20%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\'text\' name=\'effToDate";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'effToDate";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'  size=\'10\' maxlength=\'10\' onBlur=\'isValidDate(this,\"ET\",";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="); discdate(";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =");\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" />\r\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effToDate_ctrl";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' onClick=\"return showCalendar(\'effToDate";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\');\" ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 =" />\r\n\t\t\t</td>\r\n\t\t\t<td id=\'disc_ip";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_ip";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'discPer_ip";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' readonly onkeypress=\"return checkForSpecChars(event)\" onblur=\"checkForNumberDecimal(this,";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =",\'ip\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'  />\r\n\t\t\t</td>\r\n\t\t\t<td id=\'disc_op";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_op";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'discPer_op";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =",\'op\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'/>\r\n\t\t\t</td>\t\t\t\r\n\t\t\t<td id=\'disc_em";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_em";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' id=\'discPer_em";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =",\'em\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' />\r\n\t\t\t</td>\r\n\t\t\t<td id=\'disc_ex";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_ex";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' id=\'discPer_ex";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =",\'ex\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' />\r\n\t\t\t</td>\r\n\t\t\t<td id=\'disc_dc";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_dc";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' id=\'discPer_dc";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =",\'dc\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' />\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'  id=\'reimbursableFld\'>\r\n      \t\t\t\t<input type=\"checkbox\" name=\'reimbursable";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'reimbursable";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' disabled ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" />\r\n\t\t\t</td>\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'  id=\'overrideFld\'>\r\n      \t\t\t\t<input type=\"checkbox\" name=\'override";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'override";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =" />\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'15%\' nowrap class=\'fields\' id=\'reimbursableTypeFld\'>\r\n\t\t    <select name=\'reimbursableType";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' id=\'reimbursableType";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' disabled>\r\n\t\t        \r\n\t\t        <option value=\"F\" ";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\r\n\t\t            ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\r\n\t\t        </option>\r\n\t\t        <option value=\"P\" ";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\r\n\t\t        </option>\r\n\t\t        <option value=\"N\" ";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =">\r\n      \t\t       ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\r\n\t\t        </option>\r\n\t\t    </select>\r\n\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'  id=\'reimbursableAmtFld\'>\r\n\t\t\t\t<input type=\"text\" name=\'reimbursableAmt";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\'  size=\'10\' maxlength=\"10\" readonly id=\'reimbursableAmt";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'/>\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'  id=\'publicPriceFld\'>\r\n\t\t\t\t<input type=\"text\" name=\'publicPriceFld";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'  size=\'10\' maxlength=\"10\" readonly id=\'publicPriceFld";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\'/>\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\r\n\t\t\t\r\n\t\t\t\r\n\t\t\t<td id=\'cost_indicator";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' width=\'10%\' nowrap class=\'fields\' >\r\n\t\t\t\t    <select name=\'cost_ind";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'cost_ind";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' disabled onchange=\"costind(this,";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =");\" readonly>\r\n\t\t\t\t        <option value=\'N\' ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =">\r\n\t\t\t\t            ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\r\n\t\t\t\t        </option>\r\n\t\t\t\t        <option value=\"A\" ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\r\n\t\t\t\t        </option>\r\n\t\t\t\t        <option value=\"P\" ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\r\n\t\t\t\t        </option>\r\n\t\t\t\t    </select>\r\n\t\t\t</td>\r\n\t\t\t\t<!-- Modified By Nandhini costamt Readonly for MMS-QH-CRF-0128.4 -->\r\n\t\t\t\t<td id=\'cost_amount";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' width=\'10%\' nowrap class=\'fields\'>\r\n      \t\t\t\t<input type=\"text\" name=\'cost_amt";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'  id=\'cost_amt";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' size=\'10\' maxlength=\"10\" readonly maxlength=\"10\" onblur=\"checkForNumberDecimal(this,";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =",\'ca\');\" value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\r\n      \t\t\t</td>\r\n      \t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\r\n\t\t\t<td id=\'apply_dis";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' width=\'5%\' nowrap class=\'fields\'>\r\n      \t\t\t\t<input type=\"checkbox\" name=\'apply_discount";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' id=\'apply_discount";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' disabled onclick=\'fnApplyDiscPrice(this,";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' />\r\n\t\t\t\t\t<a href=\"#\"  onclick=\"showDisc(";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =")\" name=\"dtls";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" id=\"dtls";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\" disabled value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" >Dtls</a>\r\n\t\t\t\t\t<input type=\'hidden\' name=\'discStringForBlngClass_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'discStringForBlngClass_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' />\t\t\t\t\t\r\n\t\t\t</td>\r\n";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' width=\'5%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"checkbox\" name=\'apply_discount";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 =");\' checked value=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' />\r\n\t\t\t\t<a href=\"#\"  onclick=\"showDisc(";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" >Dtls</a>\r\n\t\t\t\t<input type=\'hidden\' name=\'discStringForBlngClass_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' />\t\t\t\t\r\n\t\t\t</td>\r\n";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\t\r\n\t\t\t\t</tr>\t\r\n\r\n\t\t\t\r\n\t\t\t\t<input type=\'hidden\' name=\'discString";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' id=\'discString";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' value=\'\'><!--to catch the disc dtls-->\t\t\t\t\r\n\t\t\t\t<input type=\'hidden\' name=\'discDtls";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' id=\'discDtls";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' value=\'\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'applydiscount";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' id=\'applydiscount";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'effFrmDate";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' id=\'effFrmDate";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'efftodate";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\' id=\'efftodate";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'discPerip";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' id=\'discPerip";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'discPerop";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' id=\'discPerop";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'discPerem";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' id=\'discPerem";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'discPerex";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' id=\'discPerex";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'discPerdc";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' id=\'discPerdc";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'costind";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' id=\'costind";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'costamt";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\' id=\'costamt";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\'>\r\n\t\t\t\t\r\n\t\t\t\t\r\n\t\t\t\t<input type=\'hidden\' name=\'reimbursableType";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'reimbursableAmt";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' id=\'reimbursableAmt";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'publicPriceFld";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' id=\'publicPriceFld";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'reimbursable";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'override";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\r\n\t\t\t\t\r\n\t\t\t\t<input type=\'hidden\' name=\'rowMode_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' id=\'rowMode_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\' value=\'modify\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'billingdesc";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' id=\'billingdesc";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\' value=\'\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'inclRowCnt\' id=\'inclRowCnt\' value=\'";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\'>\r\n\t\t\t\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\r\n\t\t\t\t<input type=\'hidden\' name=\'indexSelected\' id=\'indexSelected\' value=\'";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\'> <!--128.4-->\r\n\t\t\t\t<input type=\'hidden\' name=\'isDiscSavedYN";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' id=\'isDiscSavedYN";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' value=\"N\" /> \r\n\t\t\t<input type=\'hidden\' name=\'DrugItemPriceSetupMMSYN\' id=\'DrugItemPriceSetupMMSYN\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" > <!-- V240722 -->\r\n\t\t\t\r\n\t\t\t\t";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\r\n\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\r\n\t\t<tr>\r\n\t\t\t\t\t\t\r\n\t\t\t<td width=\'20%\' nowrap class=\'fields\'>\t\t\t\t\t\t\t\r\n\t\t\t\t<input type=\'text\' name=\'effFromDate";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 =");checkDatesDrugMedItem(";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 =");\' value=\'\' />\r\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effFromDate_ctrl";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' onClick=\"if(valDrugMedItemsDtls()){return showCalendar(\'effFromDate";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\');}\"/>\r\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\r\n\t\t\t</td>\r\n\t\t\t\t\t<td width=\'20%\' nowrap class=\'fields\'>\r\n\t\t\t\t\t<input type=\'text\' name=\'effToDate";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 =");\' value=\'\' />\r\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effToDate_ctrl";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' onClick=\"if(valDrugMedItemsDtls()){return showCalendar(\'effToDate";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\');}\" />\r\n\t\t\t</td>\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_ip";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' onkeypress=\"return checkForSpecChars(event);\" onblur=\"if(valDrugMedItemsDtls()){checkForFloatNumbers(this);}else{ fnClearCode(discPer_ip";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="); }\" size=\'10\' maxlength=\"10\" value=\'\' />\r\n\t\t\t</td>\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_op";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\' onkeypress=\"return checkForSpecChars(event);\" onblur=\"if(valDrugMedItemsDtls()){checkForFloatNumbers(this);}else{ fnClearCode(discPer_op";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="); }\" size=\'10\' maxlength=\"10\" value=\'\' />\r\n\t\t\t</td>\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_em";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' onkeypress=\"return checkForSpecChars(event);\" onblur=\"if(valDrugMedItemsDtls()){checkForFloatNumbers(this);}else{ fnClearCode(discPer_em";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="); }\" size=\'10\' maxlength=\"10\" value=\'\' />\r\n\t\t\t</td>\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_ex";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' onkeypress=\"return checkForSpecChars(event);\" onblur=\"if(valDrugMedItemsDtls()){checkForFloatNumbers(this);}else{ fnClearCode(discPer_ex";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 =");}\" size=\'10\' maxlength=\"10\" value=\'\' />\r\n\t\t\t</td>\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<input type=\"text\" name=\'discPer_dc";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\' onkeypress=\"return checkForSpecChars(event);\" onblur=\"if(valDrugMedItemsDtls()){checkForFloatNumbers(this);}else{ fnClearCode(discPer_dc";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 =");}\" size=\'10\' maxlength=\"10\" value=\'\' />\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'  id=\'reimbursableFld\'>\r\n      \t\t\t\t<input type=\"checkbox\" name=\'reimbursable";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' onclick=\"reimbursableIsCheck(";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 =");\" />\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'  id=\'overrideFld\'>\r\n      \t\t\t\t<input type=\"checkbox\" name=\'override";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' />\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'15%\' nowrap class=\'fields\' id=\'reimbursableTypeFld\'>\r\n\t\t\t\t\t<select name=\'reimbursableType";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' disabled id=\'reimbursableType";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' onchange=\"reimbursableTypeIsFull(";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 =")\">\r\n      \t\t\t\t\t    <option value=\"N\" >";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 =" </option>\r\n      \t\t\t\t\t    <option value=\"F\" >";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 =" </option>\r\n      \t\t\t\t\t    <option value=\"P\" >";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="</option>\r\n      \t\t\t\t</select>\r\n\t\t\t\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'  id=\'reimbursableAmtFld\'>\r\n\t\t\t\t<input type=\"text\" disabled name=\'reimbursableAmt";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' onblur=\"checkForFloatNumbers(this);\" onkeypress=\"return checkForSpecChars(event);\"  size=\'10\' maxlength=\"10\"  id=\'reimbursableAmt";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\' />\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\' id=\'publicPriceFld\'>\r\n\t\t\t\t<input type=\"text\" name=\'publicPriceFld";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' onblur=\"checkForFloatNumbers(this);\" onkeypress=\"return checkForSpecChars(event);\" size=\'10\' maxlength=\"10\" id=\'publicPriceFld";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' />\r\n\t\t\t</td>\r\n\t\t\t\r\n\t\t\r\n\t\t\t\r\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\r\n\t\t\t\t<select name=\'cost_ind";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' onchange=\"if(valDrugMedItemsDtls()){costind(this,";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="); } \">\r\n      \t\t\t\t\t    <option value=\'N\' >";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="</option>\r\n      \t\t\t\t\t\t<option value=\"A\" >";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 =" </option>\r\n\t      \t\t\t\t\t<option value=\"P\" >";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="</option>\r\n      \t\t\t\t</select>\r\n      \t\t\t</td>\r\n\t\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\r\n      \t\t\t\t<input type=\"text\" name=\'cost_amt";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' size=\'10\' maxlength=\"10\"  onkeypress=\"return checkForSpecChars(event);\"  onblur=\"if(valDrugMedItemsDtls()){checkForFloatNumbers(this); checkDisc_indicator(";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 =");}else{fnClearCode(cost_amt";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =");}\" value=\'\'>\r\n      \t\t\t</td>\r\n\t\t\t<td width=\'5%\' nowrap class=\'fields\'>\r\n      \t\t\t\t<input type=\"checkbox\" name=\'apply_discount";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' onclick=\'fnApplyDiscPrice(this,";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 =");\' value=\'N\' />\r\n\t\t\t\t\t<a href=\"#\" onclick=\"showDiscDrugMedItem(";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\" disabled value=\"\" >Dtls</a>\r\n\t\t\t\t\t<input type=\'hidden\' name=\'isDiscountSavedYN_";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\' id=\'isDiscountSavedYN_";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\' value=\'Y\'>\t\t\t\t\t\r\n\t\t\t\t\t<input type=\'hidden\' name=\'discStringForBlngClass_";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\' />\t\t\t\t\t\r\n\t\t\t</td>\t\t\t\r\n\t\t\t\r\n\t\t\t<input type=\'hidden\' name=\'discString";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' value=\'\'>\t\t\t\r\n\t\t\t<input type=\'hidden\' name=\'discDtls";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'applydiscount";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\' value=\'N\'>\r\n\t\t\t<input type=\'hidden\' name=\'billingclass";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' id=\'billingclass";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'billingdesc";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'priceindbot";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="\' id=\'priceindbot";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'effFrmDate";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'efftodate";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'discPerip";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'discPerop";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'discPerem";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'discPerex";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'discPerdc";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'Applicability";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 ="\' id=\'Applicability";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'baseqty";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 ="\' id=\'baseqty";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'publicchk";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\' id=\'publicchk";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 ="\' value=\'N\'>\r\n\t\t\t<input type=\'hidden\' name=\'mincharge";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' id=\'mincharge";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'maxcharge";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\' id=\'maxcharge";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'checkcostavl_";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="\' id=\'checkcostavl_";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'costind";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'costamt";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'rate_Basis_Ind";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="\' id=\'rate_Basis_Ind";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'rowMode_";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 ="\' value=\'add\'>\r\n\t\t\t<input type=\'hidden\' name=\'patCatCode_";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 ="\' id=\'patCatCode_";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 ="\' value=\'\'>\r\n\t\t\t<input type=\'hidden\' name=\'inclRowCnt\' id=\'inclRowCnt\' value=\'";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\'>\r\n\t\t\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' value=\"";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 ="\" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\r\n\t\t\t<input type=\'hidden\' name=\'indexSelected\' id=\'indexSelected\' value=\'";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="\'> <!--128.4-->\r\n\t\t\t<input type=\'hidden\' name=\'isDiscSavedYN";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 ="\' value=\"N\" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\r\n\t\t\t<input type=\'hidden\' name=\'DrugItemPriceSetupMMSYN\' id=\'DrugItemPriceSetupMMSYN\' value=\"";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="\" > <!-- V240722 -->\r\n\t\t\t\r\n</tr>\t\r\n";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\r\n\t</table>\r\n\t</div>\t\r\n\t<table width=\'100%\'>\r\n\t\t<tr>\r\n\t\t\t<td width=\'90%\'> &nbsp;\r\n\t\t\t</td>\r\n\t\t\t<td width=\'10%\' align=\'right\'>\r\n\t\t\t\t<input type=\'button\' name=\'priceBulkAdd\' id=\'priceBulkAdd\' value=\'";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 ="\' onclick=\'addRowDrugMedItem(\"pricedtlbulk\")\'>\r\n\t\t\t</td>\r\n\t\t</tr>\r\n\t</table>\r\n\t<input type=\'hidden\' name=\'called\' id=\'called\' value=\'pricedtls\'>\r\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 ="\'>\r\n\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\'>\r\n\t<input type=\'hidden\' name=\'pricedtls\' id=\'pricedtls\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'eachDisc\' id=\'eachDisc\' value=\'\'>\r\n\t\r\n\t<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'service_ind\' id=\'service_ind\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'service_desc\' id=\'service_desc\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'price_ind\' id=\'price_ind\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'price_code\' id=\'price_code\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'price_desc\' id=\'price_desc\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'cust_grp_code\' id=\'cust_grp_code\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'cust_grp_desc\' id=\'cust_grp_desc\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'cust_code\' id=\'cust_code\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'cust_desc\' id=\'cust_desc\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'Add\'>\r\n\t<input type=\'hidden\' name=\'policy_code\' id=\'policy_code\' value=\'\'>\r\n\t<input type=\'hidden\' name=\'policy_desc\' id=\'policy_desc\' value=\'\'>\r\n\t\r\n\t<input type=\'hidden\' name=\'DrugItemPriceSetupMMSYN\' id=\'DrugItemPriceSetupMMSYN\' value=\"";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 ="\" > <!-- V240722 -->\r\n\t<input type=\'hidden\' name=\'serviceind\' id=\'serviceind\' value=\'";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'> \r\n\t</form>\r\n</body>\r\n</html>\r\n";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );
	
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


     private String checkForNull(String inputString) {
 		return (inputString == null) ? "" : inputString;
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

/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217            14525 	       	MMS-QH-CRF-0128.2		       Nandhini M 
2			 V160522							MMS-QH-CRF-0128.4			   Nandhini M 
3                                               MMS-CRF-212                      Isaac Hanna 

 */

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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			int tableIndex = 1; // added against 128.2
	String locale = (String)session.getAttribute("LOCALE");
	String facility_id;
	String mode = checkForNull(request.getParameter("mode"));
	String bean_id					= "BlServiceDiscPriceBean" ;
	String bean_name				= "eBL.BlServiceDiscPriceBean";
	BlServiceDiscPriceBean blDiscPriceBean = null;
	BlServiceDiscPriceBean bean	= (BlServiceDiscPriceBean)getBeanObject( bean_id, bean_name , request) ;
	BlServiceDiscPriceBean callingObj = new BlServiceDiscPriceBean();
	System.err.println("32,mode==>"+mode);
	
	System.err.println("the parameters in request is "+request.getQueryString());
	
	if("modify".equals(mode)){
		facility_id = checkForNull(request.getParameter("facilityId"));
	}
	else{		
		facility_id = (String)session.getAttribute("facility_id");
	}			
			
	String servInd = request.getParameter("servInd");
	if(servInd == null) servInd = "";
	
	
	
	String custGrpCode = request.getParameter("custGrpCode");
	if(custGrpCode == null) custGrpCode = "";
	
	String custCode = request.getParameter("cust_code");
	if(custCode == null) custCode = "";
	
	
	String service_code = request.getParameter("servCode");
	if(service_code == null) service_code = "";
	
	
	String effFrom = request.getParameter("effFrom");
	String effTo = request.getParameter("effTo");
	
	String DrugItemPriceSetupMMSYN = request.getParameter("DrugItemPriceSetupMMSYN");
	if(DrugItemPriceSetupMMSYN == null) DrugItemPriceSetupMMSYN = "";
	System.err.println("90,DrugItemPriceSetupMMSYN==>"+DrugItemPriceSetupMMSYN);
	
		
	String costInd 			=""; 	
	String costAmt 			="";	
	String ipRate 			="";
	String opRate 			="";			
	String emRate 			="";
	String exRate 			="";
	String dcRate 			="";
	
	String applyDiscount 		="N";
	String priceEffFrom 		="";
	String priceEffTo 		="";	
		
	String discStringForBlngClass = "";
	

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

if("modify".equals(mode)){

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block8Bytes, _wl_block8);
}else{
            _bw.write(_wl_block9Bytes, _wl_block9);
}
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

			
			System.out.println("the mode is "+mode);
				if("modify".equals(mode)){
					System.out.println(facility_id+" , "+ effFrom+" , "+effTo+" , "+service_code +" , "+ custGrpCode+" , "+custCode);
					ArrayList blDiscPrceBean = (ArrayList)bean.getloadpricecls_DrugItem(facility_id, effFrom,effTo ,service_code, custGrpCode, custCode);
					System.err.println("blDiscPriceBean rec size-"+blDiscPrceBean.size());
			
			if(blDiscPrceBean.size()!=0){
				for(int i=0;i<blDiscPrceBean.size();i=i+16){// we add 16 cause the data it 16 as length and we show one record only 
				
					
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(blDiscPrceBean.get(i)));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(blDiscPrceBean.get(i+1)));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( !"".equals(blDiscPrceBean.get(i+1)) ? "readonly":""));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( !"".equals(blDiscPrceBean.get(i+1)) ? "disabled":""));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(blDiscPrceBean.get(i+5)));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(blDiscPrceBean.get(i+6)));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(blDiscPrceBean.get(i+9)));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(blDiscPrceBean.get(i+8)));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(blDiscPrceBean.get(i+7)));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( blDiscPrceBean.get(i + 10).equals("Y") ? "checked='checked'" : "" ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( blDiscPrceBean.get(i + 11).equals("Y") ? "checked='checked'" : "" ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( blDiscPrceBean.get(i+12).equals("F") ? "selected='selected'" : "" ));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( blDiscPrceBean.get(i+12).equals("P") ? "selected='selected'" : "" ));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( blDiscPrceBean.get(i+12).equals("N") ? "selected='selected'" : "" ));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+13)));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+4)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf( blDiscPrceBean.get(i+2).equals("N") ? "selected='selected'" : "" ));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf( blDiscPrceBean.get(i+2).equals("A") ? "selected='selected'" : "" ));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf( blDiscPrceBean.get(i+2).equals("P") ? "selected='selected'" : "" ));
            _bw.write(_wl_block89Bytes, _wl_block89);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(blDiscPrceBean.get(i+3)));
            _bw.write(_wl_block97Bytes, _wl_block97);

				if((blDiscPrceBean.get(i+14)).equals("N") || (blDiscPrceBean.get(i+14)).equals("")){					
				
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(blDiscPrceBean.get(i+14)));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(blDiscPrceBean.get(i+15)));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(discStringForBlngClass));
            _bw.write(_wl_block108Bytes, _wl_block108);

			}
			else
			{

            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(blDiscPrceBean.get(i+14)));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(blDiscPrceBean.get(i+15)));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+15)));
            _bw.write(_wl_block113Bytes, _wl_block113);
 
			}
			

            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+14)));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+1)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+5)));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+6)));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+9)));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+8)));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+7)));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+2)));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+3)));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+12)));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+13)));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+4)));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+10)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(blDiscPrceBean.get(i+11)));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(DrugItemPriceSetupMMSYN));
            _bw.write(_wl_block155Bytes, _wl_block155);
						
					tableIndex++;
				 
            _bw.write(_wl_block156Bytes, _wl_block156);
	}
			
			}
			}
			else
			{

            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block180Bytes, _wl_block180);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block181Bytes, _wl_block181);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block182Bytes, _wl_block182);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block189Bytes, _wl_block189);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block190Bytes, _wl_block190);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block191Bytes, _wl_block191);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(discStringForBlngClass));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block213Bytes, _wl_block213);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block215Bytes, _wl_block215);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block237Bytes, _wl_block237);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block238Bytes, _wl_block238);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block239Bytes, _wl_block239);
            out.print( String.valueOf(DrugItemPriceSetupMMSYN));
            _bw.write(_wl_block240Bytes, _wl_block240);

			}

            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf(DrugItemPriceSetupMMSYN));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf(servInd));
            _bw.write(_wl_block246Bytes, _wl_block246);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PriceDetails.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IP.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OP.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EM.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EX.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DC.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Reimbursable.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ReimbursableType.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ReimbursableAmt.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PublicPrice.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CostIndicator.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CostAmt.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Discount.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FULL.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PART.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NA.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NA.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Amount.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Percentage.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NA.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FULL.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PART.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.NA.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Amount.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Percentage.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
