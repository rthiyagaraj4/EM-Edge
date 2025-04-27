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

public final class __blamendmultiservicepricedtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLAmendMultiServicePriceDtls.jsp", 1737916497243L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<script>\nfunction fnApplyDiscPrice(val,index)\n\t{\n\t\tvar selBlngClass = document.getElementById(\"billing_class\"+index).value;\n\t\tvar effFromDate = document.getElementById(\"effFromDate\"+index).value;\n\t\tvar effToDate = document.getElementById(\"effToDate\"+index).value;\n\n\t\tif(selBlngClass == \'\'){\n\t\t\talert(\"Billing Class Cannot be Blank\");\n\t\t\tdocument.getElementById(\'apply_discount\'+index).checked = false;\n\t\t\tdocument.getElementById(\"billing_class\"+index).focus();\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(effFromDate == \'\'){\n\t\t\talert(\"Effective From cannot be Blank\");\n\t\t\tdocument.getElementById(\'apply_discount\'+index).checked = false;\n\t\t\tdocument.getElementById(\"effFromDate\"+index).focus();\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tif(val.checked==true || val.checked==\'true\'){\n\t\t\tdocument.getElementById(\'apply_discount\'+index).value=\'Y\';\n\t\t\tdocument.getElementById(\'applydiscount\'+index).value=\'Y\';\n\t\t\tparent.BLMultiDiscPrice.location.href =\'../../eBL/jsp/BLMultiDiscPriceCreate.jsp\'+\"?selBlngClass=\"+selBlngClass+\"&effFromDate=\"+effFromDate+\"&effToDate=\"+effToDate;\t\t\n\t\t\tdocument.getElementById(\"dtls\"+index).disabled=false;\n\t\t\tdocument.getElementById(\"dtls\"+index).className = \"\";\n\t\t\tdocument.getElementById(\"indexSelected\").value=index;\n\t\t}else{\n\t\t\tdocument.getElementById(\'apply_discount\'+index).value=\'N\';\n\t\t\tdocument.getElementById(\'applydiscount\'+index).value=\'N\';\n\t\t\tparent.BLMultiDiscPrice.location.href =\'../../eCommon/html/blank.html\';\n\t\t\tdocument.getElementById(\"dtls\"+index).disabled=true;\n\t\t\tdocument.getElementById(\"dtls\"+index).className = \"disabled\";\n\t\t\tdocument.getElementById(\"indexSelected\").value=\'\';\n\t\t\t//document.getElementById(\"isDiscountSavedYN_\"+index).value=\"Y\";\n\t\t}\n\t\t//alert(\"after jsp\");\n\t}\n\t\nfunction fnPublicChk(val,index)\n\t{\n\t\tvar applicability=document.getElementById(\'applicability\'+index).value;\n\t\tvar BillingClass= document.getElementById(\'billing_class\'+index).value;\n\t\tvar priceInd= document.getElementById(\'price_ind_bot\'+index).value;\n\t\tvar effFromDate= document.getElementById(\'effFromDate\'+index).value;\n\t\tif(BillingClass==\"\"){\n\t\t\talert(\"Billing Class Cannot be Null\");\n\t\t\treturn false;\n\t\t}\n\t\telse if(priceInd==\"\"){\n\t\t\talert(\"Rate/Factor Cannot be Null\");\n\t\t\treturn false;\n\t\t}\n\t\telse if(effFromDate==\"\"){\n\t\talert(\"Effective From Date Cannot be Null\");\n\t\treturn false;\t\t\n\t\t}\n\t\telse if(applicability==\"\"){\n\t\t\talert(\"Applicability Cannot Be Null\");\n\t\t\treturn false;\n\t\t}\n\t\tif(val.checked==true || val.checked==\'true\'){\n\t\t\tdocument.getElementById(\'public_chk\'+index).value=\'Y\';\n\t\t\tdocument.getElementById(\'publicchk\'+index).value=\'Y\';\n\t\t\t\n\t\t}else{\n\t\t\tdocument.getElementById(\'public_chk\'+index).value=\'N\';\n\t\t\tdocument.getElementById(\'publicchk\'+index).value=\'N\';\n\t\t\t\n\t\t}\n\t\t//alert(\"after jsp\");\n\t}\n\t\nfunction priceindbot(val,index)\n\t{\n\t\tdocument.getElementById(\'price_ind_bot\'+index).value=val.value;\n\t\tvar price_ind_bot=document.getElementById(\'price_ind_bot\'+index).value;\n\t\t//alert(\"241,price_ind_bot:::\"+price_ind_bot);\n\t\tdocument.getElementById(\'priceindbot\'+index).value=val.value;\n\t\tvar servCode = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.value;\n\t\t//alert(\"servCode==>\"+servCode);\n\t\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\t\t\t\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\n\tvar temp_jsp=\"../../eBL/jsp/BLServiceDiscPriceValidation.jsp?servCode=\"+servCode+\"&functionMode=isServiceChargeBasedYN\";\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\t\n\t\n\t\tif(retVal==\"Y\" && price_ind_bot==\"R\")\n\t\t{\n\t\t\talert(\"Please Select Factor For Charge Based Services\");\n\t\t\tdocument.getElementById(\'price_ind_bot\'+index).value=\'\';\n\t\t\treturn false;\n\t\t} \n\t}\nfunction publicBasisPH(val,index)\n\t{\n\tvar servCode = parent.BLServiceDiscPrice.frmDiscPriceCreate.service_code.value;\n\t\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\tvar xmlDoc = \"\";\n\tvar xmlHttp = new XMLHttpRequest();\t\t\t\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\t\n\tvar temp_jsp=\"../../eBL/jsp/BLServiceDiscPriceValidation.jsp?servCode=\"+servCode+\"&functionMode=isServiceChargeBasedYN\";\n\txmlHttp.open(\"POST\",temp_jsp,false);\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\n\t}\n\t\nfunction applicabilitychg(val,index)\n\t{\n\t\tdocument.getElementById(\'applicability\'+index).value=val.value;\n\t\tdocument.getElementById(\'applicability\'+index).value=val.value;\n\t\t//alert(\"after document.getElementById(\'applicability\'+index).value--\"+document.getElementById(\'applicability\'+index).value);\n\t}\n\t\nfunction rateBasisInd(val,index)\n\t{\n\t\tvar applicability=document.getElementById(\'applicability\'+index).value;\n\t\tvar BillingClass= document.getElementById(\'billing_class\'+index).value;\n\t\tvar priceInd= document.getElementById(\'price_ind_bot\'+index).value;\n\t\tvar effFromDate= document.getElementById(\'effFromDate\'+index).value;\n\t\tif(BillingClass==\"\"){\n\t\t\talert(\"Billing Class Cannot be Null\");\n\t\t\treturn false;\n\t\t}\n\t\telse if(priceInd==\"\"){\n\t\t\talert(\"Rate/Factor Cannot be Null\");\n\t\t\treturn false;\n\t\t}\n\t\telse if(effFromDate==\"\"){\n\t\talert(\"Effective From Date Cannot be Null\");\n\t\treturn false;\t\t\n\t\t}\n\t\telse if(applicability==\"\"){\n\t\t\talert(\"Applicability Cannot Be Null\");\n\t\t\treturn false;\n\t\t}\n\t\t\n\t\tdocument.getElementById(\'rateBasisInd\'+index).value=val.value;\n\t\tdocument.getElementById(\'rate_Basis_Ind\'+index).value=val.value;\n\t\t//alert(\"after document.getElementById(\'rate_Basis_Ind\'+index).value--\"+document.getElementById(\'rate_Basis_Ind\'+index).value);\n\t}\n\t\nfunction costind(val,index)\n\t{\n\t\tdocument.getElementById(\'cost_ind\'+index).value=val.value;\n\t\tdocument.getElementById(\'costind\'+index).value=val.value;\n\t\t//alert(\"after document.getElementById(\'costind\'+index).value--\"+document.getElementById(\'costind\'+index).value);\n\t}\n\n</script>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eBL/js/BLServiceDiscountPrice.js\"></script>\n<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/DateUtils.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n<STYLE TYPE=\"text/css\">\ndiv.tableContainer {\n\twidth: 100%;\t\t/* table width will be 99% of this*/\n\theight: 460px; \t/* must be greater than tbody*/\n\toverflow: auto;\n\tmargin: 0 auto;\n}\ntable {\n\twidth: 100%;\t\t/*100% of container produces horiz. scroll in Mozilla*/\n\tborder: none;\n\tbackground-color: #f7f7f7;\n\t}\n\t\ntable>tbody\t{  /* child selector syntax which IE6 and older do not support*/\n\toverflow: auto; \n\theight: 120x;\n\toverflow-x: hidden;\n\t}\n\t\n /*thead tr\t{     added against MMS-QH-CRF-0128.4 */\n\tposition:relative; \n\ttop: expression(offsetParent.scrollTop); /*IE5+ only*/\n\t}\n\t\t\n\t\tdiv.tableContainer {\n\t\twidth: 100%;\t\t/* table width will be 99% of this*/\n\t\theight: 140px; \t/* must be greater than tbody*/\n\t\toverflow: scroll;\n\t\tmargin: 0 auto;\n\t}\t*/\t\n\n\t\tTD.YELLOW \n\t\t{\t\t\t\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t}\n\t\t\n\t\t.LocalYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tborder: 1x;\n\t\t\tborder-style: dashed;\n\t\t\tborder-left-color: #D5E2E5;\n\t\t\tborder-right-color: #D5E2E5;\n\t\t\tborder-top-color: #D5E2E5;\n\t\t\tborder-bottom-color: #D5E2E5; \n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\nSPAN.LABEL\n{\n  COLOR:#444444;\n  /*background-color:#FFFFFF;*/\n  background-color:#FFFFFF;\n  FONT-SIZE: 8pt;\n  TEXT-ALIGN: LEFT;\n  /*TEXT-ALIGN: RIGHT;*/\n  PADDING-LEFT:7px;\n  PADDING-RIGHT:7px\n}\nSPAN.SpanYellow\n\t\t{\n\t\t\tCOLOR:#444444;\n\t\t\tBACKGROUND-COLOR: yellow ;\n\t\t\tFONT-SIZE: 8pt ;\n\t\t\tPADDING-LEFT:7px;\n  \t\t\tPADDING-RIGHT:7px\n\t\t}\nA.disabled\n{\n  color: #A0A0A0;\t\n}\n\t\t\n</STYLE>\n</head>\n<!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" onload=\"changeFieldColor(\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'); showDiscAvailable(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<body onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\">\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<form  method=\'post\' name = \'Pricedtlsbulkadd\' id=\'Pricedtlsbulkadd\'>\t\n\t<div id=\"tableContainer\">\t\n      \t\t<table cellpadding=0 cellspacing=3  width=\"100%\" id=\'Multipricebulkupd\' name=\'Multipricebulkupd\' id=\'Multipricebulkupd\'>\n\t\t\t\t\n\t\t<tr>\n\t\t\t<td colspan=\'19\' align=\"left\" nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" </td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<th class=\'columnheader\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</th>\n\t\t\t<th class=\'columnheader\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t</th>\n\t\t\t<th class=\'columnheader\'\twidth=\'4%\'\talign=\"left\">\n\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t</th>\n\t\t\t<th class=\'columnheader\'\twidth=\'4%\'\talign=\"left\" colspan=2>\n\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t</th>\n\n      \t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t<!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\n\t\t\t<tr onclick=\"changeFieldColor(\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'); if(alrdSelect(\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\')){showDiscAvailable(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');}\">\n\t\t\t\n\t\t\t<td id=\'blng_class";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' width=\'10%\' nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'billing_class";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' id=\'billing_class";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' size=\'20\' maxlength=\"20\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" onKeypress=\"validatedtls();\" readonly>\n      \t\t\t\t<input type=\'button\' class=\'button\' id=\'billing_class_btn";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' name=\"billing_class_btn";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" value=\'?\' onClick=\"callCommonValidationDtls(1,billing_desc";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =",billing_class";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =",";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =");\" tabindex=\'2\' disabled>\n      \t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t<input type=\"hidden\"  name=\'billing_desc";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' id=\'billing_desc";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' value=\"\" >\t\t\t\t\n      \t\t\t</td>\n\t\t\t\t\n\t\t\t\t<td id=\'rateFactor";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' width=\'10%\' nowrap class=\'fields\'>\n      \t\t\t\t<!-- Modified By Nandhini rate/factor Readonly for MMS-QH-CRF-0128.4 -->\n      \t\t\t\t<select name=\'price_ind_bot";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'price_ind_bot";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' onChange=\'priceindbot(this,";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =")\' disabled >\n      \t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =">";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</option>\n      \t\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" </option>\n      \t\t\t\t\t<option value=\"F\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =" </option>\n      \t\t\t\t</select> \n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n      \t\t\t</td>\t\t\t\t\n\t\t\t<td id=\'effectiveFrmDate";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' width=\'20%\' nowrap class=\'fields\'>\t\t\t\t\t\t\t\n\t\t\t\t<input type=\'text\' name=\'effFromDate";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'effFromDate";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'size=\'10\' maxlength=\'10\' onBlur=\'isValidDate(this,\"EF\",";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =");\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' readonly />\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effFromDate_ctrl";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' onClick=\"return showCalendar(\'effFromDate";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\');\" disabled />&nbsp;<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\n\t\t\t</td>\n\t\t\t<td id=\'effectivetoDate";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' width=\'20%\' nowrap class=\'fields\'>\n\t\t\t\t<input type=\'text\' name=\'effToDate";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' id=\'effToDate";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'  size=\'10\' maxlength=\'10\' onBlur=\'isValidDate(this,\"ET\",";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="); discdate(";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" />\n\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effToDate_ctrl";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' onClick=\"return showCalendar(\'effToDate";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\" ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" />\n\t\t\t</td>\n\t\t\t<td id=\'disc_ip";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input style=\"padding:0px\" type=\"text\" name=\'discPer_ip";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'discPer_ip";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' readonly onkeypress=\"return checkForSpecChars(event)\" onblur=\"checkForNumberDecimal(this,";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =",\'ip\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" />\n\t\t\t</td>\n\t\t\t<td id=\'disc_op";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input  style=\"padding:0px\" type=\"text\" name=\'discPer_op";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' id=\'discPer_op";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =",\'op\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="/>\n\t\t\t</td>\t\t\t\n\t\t\t<td id=\'disc_em";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input  style=\"padding:0px\"  type=\"text\" name=\'discPer_em";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' id=\'discPer_em";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =",\'em\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="/>\n\t\t\t</td>\n\t\t\t<td id=\'disc_ex";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input   style=\"padding:0px\" type=\"text\" name=\'discPer_ex";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' id=\'discPer_ex";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =",\'ex\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="/>\n\t\t\t</td>\n\t\t\t<td id=\'disc_dc";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input  style=\"padding:0px\" type=\"text\" name=\'discPer_dc";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' id=\'discPer_dc";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =",\'dc\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="/>\n\t\t\t</td>\n\t\t\t<!-- Modified By Nandhini applicability Readonly for MMS-QH-CRF-0128.4 -->\n\t\t\t<td id=\'applblty";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<select name=\'applicability";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' id=\'applicability";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' disabled onChange=\"applicabilitychg(this,";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =")\" readonly>\n      \t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</option>\n      \t\t\t\t\t<option value=\"G\" ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </option>\n      \t\t\t\t\t<option value=\"N\" ";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</option>\n\t\t\t\t</select> <img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t\t<!-- Modified By Nandhini baseQty Readonly for MMS-QH-CRF-0128.4 -->\n\t\t\t<td id=\'base_quanty";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t<input type=\"text\" name=\'base_qty";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'base_qty";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' readonly onkeypress=\"return checkForNumChars(event)\" onblur=\"checkForNumber(this,";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =")\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' readonly />\n\t\t\t</td>\n\t\t\t<td id=\'public_check";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' width=\'5%\' nowrap class=\'fields\'>\n\t\t      \t\t<input type=\"checkbox\" name=\'public_chk";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' id=\'public_chk";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' disabled onclick=\'fnPublicChk(this,";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =");\' \n\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =">\n\t\t\t\t\t<img id=\"isPublicMandEnableYN_";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" src=\'../../eCommon/images/mandatory.gif\' style=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t\t\t</td>\n\t\t\t<!-- Modified By Nandhini rateBasisInd Readonly for MMS-QH-CRF-0128.4 -->\n\t\t\t<td id=\'rtbasisInd";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' width=\'10%\' nowrap class=\'fields\'> \n\t\t\t<select name=\'rateBasisInd";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' id=\'rateBasisInd";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' disabled onChange=\"rateBasisInd(this,";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 =")\" readonly> \n\t\t      \t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="</option>\n\t\t\t\t\t\t<option value=\'B\'  ";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</option>\n\t\t\t\t\t\t<option value=\'C\' ";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</option>\n\t\t\t\t\t\t<option value=\'V\' ";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</option>\n\t\t\t\t\t</select>\n\t\t\t\t\t<!-- //Added V181005-Gayathri/MMS-DM-SCF-0243.1/Ends-->\n\t\t\t\t<img id=\"isBasisEnableYN_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>\n\t\t\t</td>\n\t\t\t<!-- Modified By Nandhini mincharge Readonly for MMS-QH-CRF-0128.4 -->\n\t\t\t<td id=\'mini_chrg";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t<input type=\"text\" name=\'min_charge";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\' id=\'min_charge";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =",\'mc\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\' readonly />\n\t\t\t</td>\n\t\t\t<!-- Modified By Nandhini maxcharge Readonly for MMS-QH-CRF-0128.4 -->\n\t\t\t<td id=\'max_chrg";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t<input type=\"text\" name=\'max_charge";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' id=\'max_charge";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 =",\'maxc\')\" size=\'10\' maxlength=\"10\" value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' readonly />\n\t\t\t</td>\n\t\t\t<td id=\'costAval";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\' width=\'5%\' nowrap class=\'fields\'>\n      \t\t\t<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->\n      \t\t\t<input type=\"checkbox\" name=\'checkCostAvl";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\' id=\'checkCostAvl";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' disabled onclick= \'fnChkChkBox(this,";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'  ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" />\n\t\t\t</td>\n\t\t\t<!-- Modified By Nandhini costInd Readonly for MMS-QH-CRF-0128.4 -->\n\t\t\t<td id=\'cost_indicator";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<select name=\'cost_ind";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' id=\'cost_ind";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' disabled onchange=\"costind(this,";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 =");\" readonly >\n      \t\t\t\t\t<option value=\'\' ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</option>\n      \t\t\t\t\t\t<option value=\"A\" ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 =" </option>\n\t      \t\t\t\t\t<option value=\"P\" ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</option>\n      \t\t\t\t</select>\n      \t\t\t</td>\n\t\t\t\t<!-- Modified By Nandhini costamt Readonly for MMS-QH-CRF-0128.4 -->\n\t\t\t\t<td id=\'cost_amount";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\' width=\'10%\' nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'cost_amt";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' id=\'cost_amt";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'  id=\'cost_amt";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\' size=\'10\' readonly maxlength=\"10\" onblur=\"checkForNumberDecimal(this,";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 =",\'ca\')\" value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n      \t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\n\t\t\t<td id=\'apply_dis";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' width=\'5%\' nowrap class=\'fields\'>\n      \t\t\t\t<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->\n      \t\t\t\t<input type=\"checkbox\" name=\'apply_discount";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' id=\'apply_discount";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\' disabled onclick=\'fnApplyDiscPrice(this,";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\' />\n\t\t\t\t\t<a href=\"#\"  onclick=\"showDisc(";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 =")\" name=\"dtls";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\" id=\"dtls";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" disabled class=\"disabled\" value=\"";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\" >Dtls</a>\n\t\t\t\t\t<input type=\'hidden\' name=\'discStringForBlngClass_";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\' id=\'discStringForBlngClass_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\' />\t\t\t\t\t\n\t\t\t</td>\n";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\' width=\'5%\' nowrap class=\'fields\'>\n\t\t\t\t<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->\n\t\t\t\t<input type=\"checkbox\" name=\'apply_discount";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =");\' checked value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\' />\n\t\t\t\t<a href=\"#\" style=\"color: #696969;\" onclick=\"showDiscMod(";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" >Dtls</a>\n\t\t\t\t<input type=\'hidden\' name=\'discStringForBlngClass_";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\' />\t\t\t\t\n\t\t\t</td>\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\t\n\t\t<input type=\'hidden\' name=\'discString";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\' id=\'discString";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\' value=\'\'><!--to catch the disc dtls-->\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'discDtls";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\' id=\'discDtls";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'applydiscount";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' id=\'applydiscount";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'billingclass";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' id=\'billingclass";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'billingdesc";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' id=\'billingdesc";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'priceindbot";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' id=\'priceindbot";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'effFrmDate";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' id=\'effFrmDate";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'efftodate";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\' id=\'efftodate";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'discPerip";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' id=\'discPerip";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'discPerop";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' id=\'discPerop";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'discPerem";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' id=\'discPerem";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'discPerex";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' id=\'discPerex";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'discPerdc";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\' id=\'discPerdc";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'Applicability";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' id=\'Applicability";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'baseqty";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' id=\'baseqty";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'publicchk";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' id=\'publicchk";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'rate_Basis_Ind";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' id=\'rate_Basis_Ind";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'mincharge";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' id=\'mincharge";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'maxcharge";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' id=\'maxcharge";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'checkcostavl_";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' id=\'checkcostavl_";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'costind";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' id=\'costind";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'costamt";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' id=\'costamt";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\'>\n\n\t\t\t\t<input type=\'hidden\' name=\'rowMode_";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' id=\'rowMode_";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 ="\' value=\'modify\'>\n\t\t\t\t<input type=\'hidden\' name=\'billingdesc";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\' value=\'\'>\n\t\t\t\t<input type=\'hidden\' name=\'patCatCode_";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\' id=\'patCatCode_";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\t\t\t\t\t\n\t\t\t\t<input type=\'hidden\' name=\'inclRowCnt\' id=\'inclRowCnt\' id=\'inclRowCnt\' value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' id=\'prevClicked\' value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\n\t\t\t\t<input type=\'hidden\' name=\'indexSelected\' id=\'indexSelected\' id=\'indexSelected\' value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'> <!--128.4-->\n\t\t\t\t<input type=\'hidden\' name=\'isDiscSavedYN";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\' id=\'isDiscSavedYN";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\' value=\"N\" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\t\t\t\t\n\t\t</tr>\t\n";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\n\t\t<tr>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'billing_class";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\' size=\'20\' maxlength=\"20\" value=\"\" onKeypress=\"validatedtls(";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );

    private final static java.lang.String  _wl_block206 =");\" onblur=\"if(this.value!=\'\'){callCommonValidationDtls(1,billing_desc";
    private final static byte[]  _wl_block206Bytes = _getBytes( _wl_block206 );

    private final static java.lang.String  _wl_block207 =");} else{ fnClearCode(billing_class";
    private final static byte[]  _wl_block207Bytes = _getBytes( _wl_block207 );

    private final static java.lang.String  _wl_block208 ="); }\">\n\t\t\t\t\t<input type=\'button\' class=\'button\' id=\'billing_class_btn";
    private final static byte[]  _wl_block208Bytes = _getBytes( _wl_block208 );

    private final static java.lang.String  _wl_block209 ="\" value=\'?\' onClick=\"if(validatedtls()){  callCommonValidationDtls(1,billing_desc";
    private final static byte[]  _wl_block209Bytes = _getBytes( _wl_block209 );

    private final static java.lang.String  _wl_block210 =");}\" tabindex=\'2\'>\n      \t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t\t<input type=\"hidden\"  name=\'billing_desc";
    private final static byte[]  _wl_block210Bytes = _getBytes( _wl_block210 );

    private final static java.lang.String  _wl_block211 ="\' value=\"\">\n\t\t\t</td>\n\t\t\t\t\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->\n\t\t\t\t<!-- Added disabledForPackageGroup condition for enable/disable Rate option for V211109 -->\n\t\t\t\t<select name=\'price_ind_bot";
    private final static byte[]  _wl_block211Bytes = _getBytes( _wl_block211 );

    private final static java.lang.String  _wl_block212 ="\' onChange=\'if(validatedtls()){priceindbot(this,";
    private final static byte[]  _wl_block212Bytes = _getBytes( _wl_block212 );

    private final static java.lang.String  _wl_block213 =");}\'>\n\t\t\t\t\t<option value=\'\' >";
    private final static byte[]  _wl_block213Bytes = _getBytes( _wl_block213 );

    private final static java.lang.String  _wl_block214 ="</option>\n\t\t\t\t\t<option value=\"R\" ";
    private final static byte[]  _wl_block214Bytes = _getBytes( _wl_block214 );

    private final static java.lang.String  _wl_block215 =" </option>\n\t\t\t\t\t<option value=\"F\" >";
    private final static byte[]  _wl_block215Bytes = _getBytes( _wl_block215 );

    private final static java.lang.String  _wl_block216 =" </option>\n\t\t\t\t</select> \n\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\t\t\t\t\n\t\t\t<td width=\'20%\' nowrap class=\'fields\'>\t\t\t\t\t\t\t\n\t\t\t\t<input type=\'text\' name=\'effFromDate";
    private final static byte[]  _wl_block216Bytes = _getBytes( _wl_block216 );

    private final static java.lang.String  _wl_block217 =");checkDates(";
    private final static byte[]  _wl_block217Bytes = _getBytes( _wl_block217 );

    private final static java.lang.String  _wl_block218 =");callValidateDate(";
    private final static byte[]  _wl_block218Bytes = _getBytes( _wl_block218 );

    private final static java.lang.String  _wl_block219 =")\' value=\'\' />\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effFromDate_ctrl";
    private final static byte[]  _wl_block219Bytes = _getBytes( _wl_block219 );

    private final static java.lang.String  _wl_block220 ="\' onClick=\"if(validatedtls()){return showCalendar(\'effFromDate";
    private final static byte[]  _wl_block220Bytes = _getBytes( _wl_block220 );

    private final static java.lang.String  _wl_block221 ="\');}\"/>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;\n\t\t\t</td>\n\t\t\t\t\t<td width=\'20%\' nowrap class=\'fields\'>\n\t\t\t\t\t<input type=\'text\' name=\'effToDate";
    private final static byte[]  _wl_block221Bytes = _getBytes( _wl_block221 );

    private final static java.lang.String  _wl_block222 =");\' value=\'\' />\n\t\t\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'  id=\'effToDate_ctrl";
    private final static byte[]  _wl_block222Bytes = _getBytes( _wl_block222 );

    private final static java.lang.String  _wl_block223 ="\' onClick=\"if(validatedtls()){return showCalendar(\'effToDate";
    private final static byte[]  _wl_block223Bytes = _getBytes( _wl_block223 );

    private final static java.lang.String  _wl_block224 ="\');}\" />\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_ip";
    private final static byte[]  _wl_block224Bytes = _getBytes( _wl_block224 );

    private final static java.lang.String  _wl_block225 ="\' onkeypress=\"return checkForSpecChars(event);\" onblur=\"if(validatedtls()){checkForNumberDecimal(this,";
    private final static byte[]  _wl_block225Bytes = _getBytes( _wl_block225 );

    private final static java.lang.String  _wl_block226 =",\'ip\');}else{ fnClearCode(discPer_ip";
    private final static byte[]  _wl_block226Bytes = _getBytes( _wl_block226 );

    private final static java.lang.String  _wl_block227 ="); }\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_op";
    private final static byte[]  _wl_block227Bytes = _getBytes( _wl_block227 );

    private final static java.lang.String  _wl_block228 =",\'op\');}else{ fnClearCode(discPer_op";
    private final static byte[]  _wl_block228Bytes = _getBytes( _wl_block228 );

    private final static java.lang.String  _wl_block229 ="); }\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\t\t\t\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_em";
    private final static byte[]  _wl_block229Bytes = _getBytes( _wl_block229 );

    private final static java.lang.String  _wl_block230 =",\'em\');}else{ fnClearCode(discPer_em";
    private final static byte[]  _wl_block230Bytes = _getBytes( _wl_block230 );

    private final static java.lang.String  _wl_block231 ="); }\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_ex";
    private final static byte[]  _wl_block231Bytes = _getBytes( _wl_block231 );

    private final static java.lang.String  _wl_block232 =",\'ex\');}else{ fnClearCode(discPer_ex";
    private final static byte[]  _wl_block232Bytes = _getBytes( _wl_block232 );

    private final static java.lang.String  _wl_block233 =");}\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<input type=\"text\" name=\'discPer_dc";
    private final static byte[]  _wl_block233Bytes = _getBytes( _wl_block233 );

    private final static java.lang.String  _wl_block234 =",\'dc\');}else{ fnClearCode(discPer_dc";
    private final static byte[]  _wl_block234Bytes = _getBytes( _wl_block234 );

    private final static java.lang.String  _wl_block235 =");}\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<select name=\'applicability";
    private final static byte[]  _wl_block235Bytes = _getBytes( _wl_block235 );

    private final static java.lang.String  _wl_block236 ="\' onChange=\"if(validatedtls()){applicabilitychg(this,";
    private final static byte[]  _wl_block236Bytes = _getBytes( _wl_block236 );

    private final static java.lang.String  _wl_block237 =");}\">\n      \t\t\t\t\t<option value=\'\' >";
    private final static byte[]  _wl_block237Bytes = _getBytes( _wl_block237 );

    private final static java.lang.String  _wl_block238 ="</option>\n      \t\t\t\t\t\t<option value=\"G\" selected>";
    private final static byte[]  _wl_block238Bytes = _getBytes( _wl_block238 );

    private final static java.lang.String  _wl_block239 =" </option>\n      \t\t\t\t\t\t<option value=\"N\" >";
    private final static byte[]  _wl_block239Bytes = _getBytes( _wl_block239 );

    private final static java.lang.String  _wl_block240 ="</option>\n      \t\t\t\t</select>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t<input type=\"text\" name=\'base_qty";
    private final static byte[]  _wl_block240Bytes = _getBytes( _wl_block240 );

    private final static java.lang.String  _wl_block241 ="\' onkeypress=\"return checkForNumChars(event);\" onblur=\"if(validatedtls()){checkForNumber(this,";
    private final static byte[]  _wl_block241Bytes = _getBytes( _wl_block241 );

    private final static java.lang.String  _wl_block242 =");}else{ fnClearCode(base_qty";
    private final static byte[]  _wl_block242Bytes = _getBytes( _wl_block242 );

    private final static java.lang.String  _wl_block243 =");}\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\n\t\t\t<td width=\'5%\' nowrap class=\'fields\'>\n\t\t      \t<input type=\"checkbox\" name=\'public_chk";
    private final static byte[]  _wl_block243Bytes = _getBytes( _wl_block243 );

    private final static java.lang.String  _wl_block244 ="\' onclick=\'if(validatedtls()){fnPublicChk(this,";
    private final static byte[]  _wl_block244Bytes = _getBytes( _wl_block244 );

    private final static java.lang.String  _wl_block245 =");}\' value=\'\'> \n\t\t\t\t<img id=\"isPublicMandEnableYN_";
    private final static byte[]  _wl_block245Bytes = _getBytes( _wl_block245 );

    private final static java.lang.String  _wl_block246 ="\'>\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'> \n\t\t\t\t<select name=\'rateBasisInd";
    private final static byte[]  _wl_block246Bytes = _getBytes( _wl_block246 );

    private final static java.lang.String  _wl_block247 ="\' onChange=\"if(validatedtls()){rateBasisInd(this,";
    private final static byte[]  _wl_block247Bytes = _getBytes( _wl_block247 );

    private final static java.lang.String  _wl_block248 =")}\"> \n\t\t\t\t\t<option value=\'\' >";
    private final static byte[]  _wl_block248Bytes = _getBytes( _wl_block248 );

    private final static java.lang.String  _wl_block249 ="</option>\n\t\t\t\t\t<option value=\'B\'  >";
    private final static byte[]  _wl_block249Bytes = _getBytes( _wl_block249 );

    private final static java.lang.String  _wl_block250 ="</option>\n\t\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block250Bytes = _getBytes( _wl_block250 );

    private final static java.lang.String  _wl_block251 ="</option>\n\t\t\t\t\t<option value=\'V\'>";
    private final static byte[]  _wl_block251Bytes = _getBytes( _wl_block251 );

    private final static java.lang.String  _wl_block252 ="</option>\n\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t\t\t</select>\n\t\t\t\t<img id=\"isBasisEnableYN_";
    private final static byte[]  _wl_block252Bytes = _getBytes( _wl_block252 );

    private final static java.lang.String  _wl_block253 ="\'>\t\t\t\t\n\t\t\t\t\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t<input type=\"text\" name=\'min_charge";
    private final static byte[]  _wl_block253Bytes = _getBytes( _wl_block253 );

    private final static java.lang.String  _wl_block254 ="\' onkeypress=\"return checkForSpecChars(event)\" onblur=\"if(validatedtls()){checkForNumberDecimal(this,";
    private final static byte[]  _wl_block254Bytes = _getBytes( _wl_block254 );

    private final static java.lang.String  _wl_block255 =",\'mc\');}else{fnClearCode(min_charge";
    private final static byte[]  _wl_block255Bytes = _getBytes( _wl_block255 );

    private final static java.lang.String  _wl_block256 =");}\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t<input type=\"text\" name=\'max_charge";
    private final static byte[]  _wl_block256Bytes = _getBytes( _wl_block256 );

    private final static java.lang.String  _wl_block257 =",\'maxc\');}else{fnClearCode(max_charge";
    private final static byte[]  _wl_block257Bytes = _getBytes( _wl_block257 );

    private final static java.lang.String  _wl_block258 =");}\" size=\'10\' maxlength=\"10\" value=\'\' />\n\t\t\t</td>\n\t\t\t<td width=\'5%\' nowrap class=\'fields\'>\n      \t\t\t\t<!-- Modified V190828-Aravindh/PMG2019-NMC-JD-CRF-0002/Added disabled -->\n      \t\t\t\t<input type=\"checkbox\" name=\'checkCostAvl";
    private final static byte[]  _wl_block258Bytes = _getBytes( _wl_block258 );

    private final static java.lang.String  _wl_block259 ="\' onclick= \'if(validatedtls()){fnChkChkBox(this,";
    private final static byte[]  _wl_block259Bytes = _getBytes( _wl_block259 );

    private final static java.lang.String  _wl_block260 =");}\' value=\'\'  />\n\t\t\t</td>\n\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n\t\t\t\t<select name=\'cost_ind";
    private final static byte[]  _wl_block260Bytes = _getBytes( _wl_block260 );

    private final static java.lang.String  _wl_block261 ="\' onchange=\"if(validatedtls()){costind(this,";
    private final static byte[]  _wl_block261Bytes = _getBytes( _wl_block261 );

    private final static java.lang.String  _wl_block262 ="</option>\n      \t\t\t\t\t\t<option value=\"A\" >";
    private final static byte[]  _wl_block262Bytes = _getBytes( _wl_block262 );

    private final static java.lang.String  _wl_block263 =" </option>\n\t      \t\t\t\t\t<option value=\"P\" >";
    private final static byte[]  _wl_block263Bytes = _getBytes( _wl_block263 );

    private final static java.lang.String  _wl_block264 ="</option>\n      \t\t\t\t</select>\n      \t\t\t</td>\n\t\t\t\t<td width=\'10%\' nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"text\" name=\'cost_amt";
    private final static byte[]  _wl_block264Bytes = _getBytes( _wl_block264 );

    private final static java.lang.String  _wl_block265 ="\' size=\'10\' maxlength=\"10\" onblur=\"if(validatedtls()){checkForNumberDecimal(this,";
    private final static byte[]  _wl_block265Bytes = _getBytes( _wl_block265 );

    private final static java.lang.String  _wl_block266 =",\'ca\');}else{fnClearCode(cost_amt";
    private final static byte[]  _wl_block266Bytes = _getBytes( _wl_block266 );

    private final static java.lang.String  _wl_block267 =");}\" value=\'\'>\n      \t\t\t</td>\n\t\t\t<td width=\'5%\' nowrap class=\'fields\'>\n      \t\t\t\t<input type=\"checkbox\" name=\'apply_discount";
    private final static byte[]  _wl_block267Bytes = _getBytes( _wl_block267 );

    private final static java.lang.String  _wl_block268 ="\' onclick=\'fnApplyDiscPrice(this,";
    private final static byte[]  _wl_block268Bytes = _getBytes( _wl_block268 );

    private final static java.lang.String  _wl_block269 =");\' value=\'N\' />\n\t\t\t\t\t<a href=\"#\" onclick=\"showDisc(";
    private final static byte[]  _wl_block269Bytes = _getBytes( _wl_block269 );

    private final static java.lang.String  _wl_block270 ="\" disabled class=\"disabled\" value=\"\" >Dtls</a>\n\t\t\t\t\t<input type=\'hidden\' name=\'isDiscountSavedYN_";
    private final static byte[]  _wl_block270Bytes = _getBytes( _wl_block270 );

    private final static java.lang.String  _wl_block271 ="\' id=\'isDiscountSavedYN_";
    private final static byte[]  _wl_block271Bytes = _getBytes( _wl_block271 );

    private final static java.lang.String  _wl_block272 ="\' value=\'Y\'>\t\t\t\t\t\n\t\t\t\t\t<input type=\'hidden\' name=\'discStringForBlngClass_";
    private final static byte[]  _wl_block272Bytes = _getBytes( _wl_block272 );

    private final static java.lang.String  _wl_block273 ="\' />\t\t\t\t\t\n\t\t\t</td>\t\t\t\n\t\t\t\n\t\t\t<input type=\'hidden\' name=\'discString";
    private final static byte[]  _wl_block273Bytes = _getBytes( _wl_block273 );

    private final static java.lang.String  _wl_block274 ="\' value=\'\'>\t\t\t\n\t\t\t<input type=\'hidden\' name=\'discDtls";
    private final static byte[]  _wl_block274Bytes = _getBytes( _wl_block274 );

    private final static java.lang.String  _wl_block275 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'applydiscount";
    private final static byte[]  _wl_block275Bytes = _getBytes( _wl_block275 );

    private final static java.lang.String  _wl_block276 ="\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'billingclass";
    private final static byte[]  _wl_block276Bytes = _getBytes( _wl_block276 );

    private final static java.lang.String  _wl_block277 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'billingdesc";
    private final static byte[]  _wl_block277Bytes = _getBytes( _wl_block277 );

    private final static java.lang.String  _wl_block278 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'priceindbot";
    private final static byte[]  _wl_block278Bytes = _getBytes( _wl_block278 );

    private final static java.lang.String  _wl_block279 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'effFrmDate";
    private final static byte[]  _wl_block279Bytes = _getBytes( _wl_block279 );

    private final static java.lang.String  _wl_block280 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'efftodate";
    private final static byte[]  _wl_block280Bytes = _getBytes( _wl_block280 );

    private final static java.lang.String  _wl_block281 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'discPerip";
    private final static byte[]  _wl_block281Bytes = _getBytes( _wl_block281 );

    private final static java.lang.String  _wl_block282 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'discPerop";
    private final static byte[]  _wl_block282Bytes = _getBytes( _wl_block282 );

    private final static java.lang.String  _wl_block283 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'discPerem";
    private final static byte[]  _wl_block283Bytes = _getBytes( _wl_block283 );

    private final static java.lang.String  _wl_block284 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'discPerex";
    private final static byte[]  _wl_block284Bytes = _getBytes( _wl_block284 );

    private final static java.lang.String  _wl_block285 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'discPerdc";
    private final static byte[]  _wl_block285Bytes = _getBytes( _wl_block285 );

    private final static java.lang.String  _wl_block286 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'Applicability";
    private final static byte[]  _wl_block286Bytes = _getBytes( _wl_block286 );

    private final static java.lang.String  _wl_block287 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'baseqty";
    private final static byte[]  _wl_block287Bytes = _getBytes( _wl_block287 );

    private final static java.lang.String  _wl_block288 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'publicchk";
    private final static byte[]  _wl_block288Bytes = _getBytes( _wl_block288 );

    private final static java.lang.String  _wl_block289 ="\' value=\'N\'>\n\t\t\t<input type=\'hidden\' name=\'mincharge";
    private final static byte[]  _wl_block289Bytes = _getBytes( _wl_block289 );

    private final static java.lang.String  _wl_block290 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'maxcharge";
    private final static byte[]  _wl_block290Bytes = _getBytes( _wl_block290 );

    private final static java.lang.String  _wl_block291 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'checkcostavl_";
    private final static byte[]  _wl_block291Bytes = _getBytes( _wl_block291 );

    private final static java.lang.String  _wl_block292 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'costind";
    private final static byte[]  _wl_block292Bytes = _getBytes( _wl_block292 );

    private final static java.lang.String  _wl_block293 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'costamt";
    private final static byte[]  _wl_block293Bytes = _getBytes( _wl_block293 );

    private final static java.lang.String  _wl_block294 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'rate_Basis_Ind";
    private final static byte[]  _wl_block294Bytes = _getBytes( _wl_block294 );

    private final static java.lang.String  _wl_block295 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'rowMode_";
    private final static byte[]  _wl_block295Bytes = _getBytes( _wl_block295 );

    private final static java.lang.String  _wl_block296 ="\' value=\'add\'>\n\t\t\t<input type=\'hidden\' name=\'patCatCode_";
    private final static byte[]  _wl_block296Bytes = _getBytes( _wl_block296 );

    private final static java.lang.String  _wl_block297 ="\' value=\'\'>\n\t\t\t<input type=\'hidden\' name=\'inclRowCnt\' id=\'inclRowCnt\' id=\'inclRowCnt\' value=\'";
    private final static byte[]  _wl_block297Bytes = _getBytes( _wl_block297 );

    private final static java.lang.String  _wl_block298 ="\'>\n\t\t\t<input type=\'hidden\' name=\'prevClicked\' id=\'prevClicked\' id=\'prevClicked\' value=\"";
    private final static byte[]  _wl_block298Bytes = _getBytes( _wl_block298 );

    private final static java.lang.String  _wl_block299 ="\" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\n\t\t\t<input type=\'hidden\' name=\'indexSelected\' id=\'indexSelected\' id=\'indexSelected\' value=\'";
    private final static byte[]  _wl_block299Bytes = _getBytes( _wl_block299 );

    private final static java.lang.String  _wl_block300 ="\'> <!--128.4-->\n\t\t\t<input type=\'hidden\' name=\'isDiscSavedYN";
    private final static byte[]  _wl_block300Bytes = _getBytes( _wl_block300 );

    private final static java.lang.String  _wl_block301 ="\' value=\"N\" /> <!-- Modified By Nandhini for MMS-QH-CRF-0128.4 -->\n</tr>\t\n";
    private final static byte[]  _wl_block301Bytes = _getBytes( _wl_block301 );

    private final static java.lang.String  _wl_block302 ="\n\t</table>\n\t</div>\t\n\t<table width=\'100%\'>\n\t\t<tr>\n\t\t\t<td width=\'90%\'> &nbsp;\n\t\t\t</td>\n\t\t\t<td width=\'10%\' align=\'right\'>\n\t\t\t\t<input type=\'button\' name=\'priceBulkAdd\' id=\'priceBulkAdd\' id=\'priceBulkAdd\' value=\'";
    private final static byte[]  _wl_block302Bytes = _getBytes( _wl_block302 );

    private final static java.lang.String  _wl_block303 ="\' onclick=\'addRow(\"pricedtlbulk\")\'>\n\t\t\t</td>\n\t\t</tr>\n\t</table>\n\t<input type=\'hidden\' name=\'called\' id=\'called\' id=\'called\' value=\'pricedtls\'>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block303Bytes = _getBytes( _wl_block303 );

    private final static java.lang.String  _wl_block304 ="\'>\n\t<input type=\'hidden\' name=\'facilityid\' id=\'facilityid\' id=\'facilityid\' value=\'";
    private final static byte[]  _wl_block304Bytes = _getBytes( _wl_block304 );

    private final static java.lang.String  _wl_block305 ="\'>\n\t<input type=\'hidden\' name=\'pricedtls\' id=\'pricedtls\' id=\'pricedtls\' value=\'\'>\n\t<input type=\'hidden\' name=\'eachDisc\' id=\'eachDisc\' id=\'eachDisc\' value=\'\'>\n\t\n\t<input type=\'hidden\' name=\'facility\' id=\'facility\' id=\'facility\' value=\'\'>\n\t<input type=\'hidden\' name=\'service_ind\' id=\'service_ind\' id=\'service_ind\' value=\'\'>\n\t<input type=\'hidden\' name=\'service_code\' id=\'service_code\' id=\'service_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'service_desc\' id=\'service_desc\' id=\'service_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'price_ind\' id=\'price_ind\' id=\'price_ind\' value=\'\'>\n\t<input type=\'hidden\' name=\'price_code\' id=\'price_code\' id=\'price_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'price_desc\' id=\'price_desc\' id=\'price_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'cust_grp_code\' id=\'cust_grp_code\' id=\'cust_grp_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'cust_grp_desc\' id=\'cust_grp_desc\' id=\'cust_grp_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'cust_code\' id=\'cust_code\' id=\'cust_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'cust_desc\' id=\'cust_desc\' id=\'cust_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'mode\' id=\'mode\' id=\'mode\' value=\'Add\'>\n\t<input type=\'hidden\' name=\'policy_code\' id=\'policy_code\' id=\'policy_code\' value=\'\'>\n\t<input type=\'hidden\' name=\'policy_desc\' id=\'policy_desc\' id=\'policy_desc\' value=\'\'>\n\t<input type=\'hidden\' name=\'materialItemYN\' id=\'materialItemYN\' id=\'materialItemYN\' value=\'";
    private final static byte[]  _wl_block305Bytes = _getBytes( _wl_block305 );

    private final static java.lang.String  _wl_block306 ="\'>\t\n\t<input type=\'hidden\' name=\'pat_cat_code\' id=\'pat_cat_code\' id=\'pat_cat_code\' value=\'";
    private final static byte[]  _wl_block306Bytes = _getBytes( _wl_block306 );

    private final static java.lang.String  _wl_block307 ="\'>\t\n\t\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block307Bytes = _getBytes( _wl_block307 );

    private final static java.lang.String  _wl_block308 ="\t\n\n";
    private final static byte[]  _wl_block308Bytes = _getBytes( _wl_block308 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217            14525 	       	MMS-QH-CRF-0128.2		       Nandhini M 
2			 V160522							MMS-QH-CRF-0128.4			   Nandhini M 
 */

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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
	if("modify".equals(mode)){
		facility_id = checkForNull(request.getParameter("facilityId"));
	}
	else{		
		facility_id = (String)session.getAttribute("facility_id");
	}			
			
	String servInd = request.getParameter("servInd");
	if(servInd == null) servInd = "";
	
	String servCode = request.getParameter("servCode");
	if(servCode == null) servCode = "";
	
	String priceInd = request.getParameter("priceInd");
	if(priceInd == null) priceInd = "";
	
	String priceCode = request.getParameter("priceCode");
	if(priceCode == null) priceCode = "";
	
	String policyCode = request.getParameter("policyCode");
	if(policyCode == null) policyCode = "";
	
	String custGrpCode = request.getParameter("custGrpCode");
	if(custGrpCode == null) custGrpCode = "";
	
	String blngClass = request.getParameter("blngClass");
	if(blngClass == null) blngClass = "";
	
	String service_code = request.getParameter("service_code");
	if(service_code == null) service_code = "";
	
	System.err.println("56,service_code==>"+service_code);
	if("A".equals(blngClass)){
		blngClass = "**";
	}
	String effFrom = request.getParameter("effFrom");
	String effTo = request.getParameter("effTo");
	
	String blngClassCode	="";		
	String ratePriceInd 	="";	
	String chkCostAvl 		="N";	
	String costInd 			=""; 	
	String costAmt 			="";	
	String ipRate 			="";
	String opRate 			="";			
	String emRate 			="";
	String exRate 			="";
	String dcRate 			="";
	String minCharge 		 ="";
	String maxCharge 		 ="";
	String baseQty 		     ="";
	String Applicability 		="";
	String applyDiscount 		="N";
	String priceEffFrom 		="";
	String priceEffTo 		="";	
	String publicchk 		="N";	
	String rateind 		="N";	
	String discStringForBlngClass = "";
	String pat_cat_code = "";
	System.err.println("80,servCode==>"+servCode);
	
	int pkgGrpEnabledCount = 0; // V211109
	boolean isPkgGrpEnabledYN = false; // V211109
	String disabledForPackageGroup = ""; // V211109	
			
	Connection connection = null;
	PreparedStatement pstmt = null;
	ResultSet resultSet = null;
	
	try 
	{		
		connection = ConnectionManager.getConnection(request);
	
		//V211109
		try
		{
			String sql = "SELECT COUNT (*) FROM sm_function_control a, sm_site_param b  WHERE a.site_id = b.customer_id AND module_id = 'BL'  AND functionality_id = 'PACK_GRP_SETUP_AMD_PD'";
			System.out.println("sql for Package Group Function Control:"+sql);
			pstmt = connection.prepareStatement(sql);
			resultSet = pstmt.executeQuery();	
			if(resultSet.next())
			{
				pkgGrpEnabledCount=resultSet.getInt(1);
				System.err.println("count for Package Group Function Control:"+pkgGrpEnabledCount);
			}		
			
			if(pkgGrpEnabledCount > 0)
				isPkgGrpEnabledYN = true;
			else
				isPkgGrpEnabledYN = false;
		}catch(Exception e){
			System.out.println("Exception in Package Group Function Control Query :"+e);
			e.printStackTrace();
		}finally{
			if(resultSet!=null) resultSet.close();
			if(pstmt!=null) pstmt.close();	
		}
		
		//Changes done for MMS-KH-SCF-0187 by Manivel N
		
		String materialItemYN=callingObj.isServMatBased(servCode,servInd);
		String isServiceChargeBasedYN=callingObj.isServMMBased(servCode);
		System.err.println("94,materialItemYN==>"+materialItemYN);
		System.err.println("95,isServiceChargeBasedYN==>"+isServiceChargeBasedYN);
		
		if("PG".equals(servInd)){
			disabledForPackageGroup = "disabled";
		} else {
			disabledForPackageGroup = "";
		}		
		
		if("modify".equals(mode))
		{
			blDiscPriceBean = callingObj.loadDescriptions(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
				
			blngClassCode	= blDiscPriceBean.getBlngClassCode();
			pat_cat_code = callingObj.getBlngClassType(blngClassCode);
			System.err.println("pat_cat_code:"+pat_cat_code);

			// Added disabledForPackageGroup condition for enable/disable Rate option for V211109
			if("PG".equals(blDiscPriceBean.getServInd())){
				disabledForPackageGroup = "disabled";
			} else {
				disabledForPackageGroup = "";
			}
			System.err.println("disabledForPackageGroup--"+disabledForPackageGroup);		
			
		}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

if("modify".equals(mode)){

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block9Bytes, _wl_block9);
}else{
            _bw.write(_wl_block10Bytes, _wl_block10);
}
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

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

				if("modify".equals(mode)){
					
					ArrayList blDiscPrceBean = (ArrayList)bean.getloadpricecls(facility_id, servInd, servCode, priceInd, priceCode, custGrpCode, policyCode, blngClass, locale, effFrom, mode, effTo);
					System.err.println("blDiscPriceBean rec size-"+blDiscPrceBean.size());
			
			if(blDiscPrceBean.size()!=0){
				for(int i=0;i<blDiscPrceBean.size();i=i+19){
				
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(blngClassCode));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( tableIndex));
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
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((blDiscPrceBean.get(i)).equals("")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((blDiscPrceBean.get(i)).equals("R")?"selected":""));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(disabledForPackageGroup));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((blDiscPrceBean.get(i)).equals("F")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(blDiscPrceBean.get(i+1)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(blDiscPrceBean.get(i+2)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf( !"".equals(blDiscPrceBean.get(i+2)) ? "readonly":""));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf( !"".equals(blDiscPrceBean.get(i+2)) ? "disabled":""));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(blDiscPrceBean.get(i+3)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(("I".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(blDiscPrceBean.get(i+4)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(("O".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(blDiscPrceBean.get(i+5)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(("E".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(blDiscPrceBean.get(i+6)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(("X".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(blDiscPrceBean.get(i+7)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(("D".equals(pat_cat_code) || "**".equals(blngClassCode)) ? "" : "readonly"));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf((blDiscPrceBean.get(i+8)).equals("")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf((blDiscPrceBean.get(i+8)).equals("G")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf((blDiscPrceBean.get(i+8)).equals("N")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(blDiscPrceBean.get(i+9)));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(blDiscPrceBean.get(i+10)));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf("Y".equals(blDiscPrceBean.get(i+10))?"checked":""));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf((blDiscPrceBean.get(i+11)).equals("")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf((blDiscPrceBean.get(i+11)).equals("B")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf((blDiscPrceBean.get(i+11)).equals("C")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf((blDiscPrceBean.get(i+11)).equals("V")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(blDiscPrceBean.get(i+12)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(blDiscPrceBean.get(i+13)));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(blDiscPrceBean.get(i+14)));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf("Y".equals(blDiscPrceBean.get(i+14))?"checked":""));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf((blDiscPrceBean.get(i+15)).equals("")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf((blDiscPrceBean.get(i+15)).equals("A")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf((blDiscPrceBean.get(i+15)).equals("P")?"selected":""));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(blDiscPrceBean.get(i+16)));
            _bw.write(_wl_block131Bytes, _wl_block131);

				if((blDiscPrceBean.get(i+17)).equals("N")){
				
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(blDiscPrceBean.get(i+17)));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(blDiscPrceBean.get(i+18)));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(discStringForBlngClass));
            _bw.write(_wl_block143Bytes, _wl_block143);

			}
			else
			{

            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(blDiscPrceBean.get(i+17)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(blDiscPrceBean.get(i+18)));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+18)));
            _bw.write(_wl_block148Bytes, _wl_block148);
 
			}
			

            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+17)));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blngClassCode));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i)));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+1)));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+2)));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+3)));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+4)));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+5)));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+6)));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+7)));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf((blDiscPrceBean.get(i+8))));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+9)));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+10)));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+11)));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+12)));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+13)));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+14)));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+15)));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(blDiscPrceBean.get(i+16)));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block195Bytes, _wl_block195);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block203Bytes, _wl_block203);
						tableIndex++;
				}	
				}
			}
			else
			{

            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block205Bytes, _wl_block205);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block206Bytes, _wl_block206);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block207Bytes, _wl_block207);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block208Bytes, _wl_block208);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block209Bytes, _wl_block209);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block210Bytes, _wl_block210);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block211Bytes, _wl_block211);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block212Bytes, _wl_block212);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block213Bytes, _wl_block213);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block214Bytes, _wl_block214);
            out.print( String.valueOf(disabledForPackageGroup));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block215Bytes, _wl_block215);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block216Bytes, _wl_block216);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block218Bytes, _wl_block218);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block219Bytes, _wl_block219);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block220Bytes, _wl_block220);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block221Bytes, _wl_block221);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block217Bytes, _wl_block217);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block222Bytes, _wl_block222);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block223Bytes, _wl_block223);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block224Bytes, _wl_block224);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block226Bytes, _wl_block226);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block227Bytes, _wl_block227);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block228Bytes, _wl_block228);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block229Bytes, _wl_block229);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block230Bytes, _wl_block230);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block231Bytes, _wl_block231);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block232Bytes, _wl_block232);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block233Bytes, _wl_block233);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block225Bytes, _wl_block225);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block234Bytes, _wl_block234);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block235Bytes, _wl_block235);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block236Bytes, _wl_block236);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block238Bytes, _wl_block238);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block239Bytes, _wl_block239);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block240Bytes, _wl_block240);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block241Bytes, _wl_block241);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block242Bytes, _wl_block242);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block243Bytes, _wl_block243);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block244Bytes, _wl_block244);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block245Bytes, _wl_block245);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"));
            _bw.write(_wl_block246Bytes, _wl_block246);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block247Bytes, _wl_block247);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block248Bytes, _wl_block248);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block249Bytes, _wl_block249);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block250Bytes, _wl_block250);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block251Bytes, _wl_block251);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block252Bytes, _wl_block252);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(materialItemYN.equals("Y")? "visibility:visible" : "visibility:hidden"));
            _bw.write(_wl_block253Bytes, _wl_block253);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block255Bytes, _wl_block255);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block256Bytes, _wl_block256);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block254Bytes, _wl_block254);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block257Bytes, _wl_block257);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block258Bytes, _wl_block258);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block259Bytes, _wl_block259);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block260Bytes, _wl_block260);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block261Bytes, _wl_block261);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block237Bytes, _wl_block237);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block262Bytes, _wl_block262);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block263Bytes, _wl_block263);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block264Bytes, _wl_block264);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block265Bytes, _wl_block265);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block266Bytes, _wl_block266);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block267Bytes, _wl_block267);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block268Bytes, _wl_block268);
            out.print( String.valueOf( tableIndex));
            _bw.write(_wl_block269Bytes, _wl_block269);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block270Bytes, _wl_block270);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block271Bytes, _wl_block271);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block272Bytes, _wl_block272);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(discStringForBlngClass));
            _bw.write(_wl_block273Bytes, _wl_block273);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block274Bytes, _wl_block274);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block275Bytes, _wl_block275);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block276Bytes, _wl_block276);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block277Bytes, _wl_block277);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block278Bytes, _wl_block278);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block279Bytes, _wl_block279);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block280Bytes, _wl_block280);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block281Bytes, _wl_block281);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block282Bytes, _wl_block282);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block283Bytes, _wl_block283);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block284Bytes, _wl_block284);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block285Bytes, _wl_block285);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block286Bytes, _wl_block286);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block287Bytes, _wl_block287);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block288Bytes, _wl_block288);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block289Bytes, _wl_block289);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block290Bytes, _wl_block290);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block291Bytes, _wl_block291);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block292Bytes, _wl_block292);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block293Bytes, _wl_block293);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block294Bytes, _wl_block294);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block295Bytes, _wl_block295);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block296Bytes, _wl_block296);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(tableIndex));
            _bw.write(_wl_block297Bytes, _wl_block297);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block298Bytes, _wl_block298);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block299Bytes, _wl_block299);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block300Bytes, _wl_block300);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(tableIndex ));
            _bw.write(_wl_block301Bytes, _wl_block301);

			}

            _bw.write(_wl_block302Bytes, _wl_block302);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")));
            _bw.write(_wl_block303Bytes, _wl_block303);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block304Bytes, _wl_block304);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block305Bytes, _wl_block305);
            out.print( String.valueOf(materialItemYN));
            _bw.write(_wl_block306Bytes, _wl_block306);
            out.print( String.valueOf(pat_cat_code));
            _bw.write(_wl_block307Bytes, _wl_block307);

	}
	catch(Exception e) {
		System.err.println("Exception in BLAmendMultiServicePriceDtls.jsp:"+e);
		e.printStackTrace();
	} 
	finally{
		ConnectionManager.returnConnection(connection);
	}

            _bw.write(_wl_block308Bytes, _wl_block308);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BillingClass.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FactorRate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveFrom.Label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EffectiveTo.Label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.IP_amt.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.OP_amt.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EM_amt.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.EX_amt.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.DC_amt.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Applicability.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BASE_QTY.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Public.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Basis.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MIN_CHARGE.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.MAX_CHARGE.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ChkCostAvl.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CostIndicator.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CostAmt.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Discount.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RATE.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FACTOR.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BASE_PRICE.label", java.lang.String .class,"key"));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVERAGE_COST.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.COMPUTED_VALUE.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Amount.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Percentage.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.RATE.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.FACTOR.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Gross.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Net.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BASE_PRICE.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AVERAGE_COST.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.COMPUTED_VALUE.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Select.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels }",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Amount.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.Percentage.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }
}
