package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eBL.BLReportIdMapper;
import java.sql.*;
import webbeans.eCommon.*;
import java.net.*;
import java.io.*;
import com.ehis.util.*;
import java.util.*;
import eBL.Common.*;
import eBL.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __blbillslmttype extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLBillSlmtType.jsp", 1738044650019L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \nSr No        Version              TFS              SCF/CRF           \t\t   Developer Name\n-----------------------------------------------------------------------------------------------\n1            V210113             8157          NMC-JD-CRF-0072               Shikha Seth\n2\t\t\t V211010\t\t\t24402\t\t\tGHL-SCF-1600\t\t\t\t Nandhini\n -->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<html>\n  \t\t<head>\n\t\t<!--\n\t\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></link>-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!--\t\t<script language=\"javascript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\t\t\t\n\t\t\t<script language=\'javascript\' ></script>\t\t\n\t\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n\t\t\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/FieldFormatMethods.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/jquery-3.6.3.js\'></script>\n\t\t\t<script language=\'javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n\t\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\n\t\t\t<style>\n\t\t\t\tthead td, thead td.locked\t{\n\t\t\t\tbackground-color: navy;\n\t\t\t\tcolor: white;\n\t\t\t\tposition:relative;}\t\n\t\t\t\tthead td {\n\t\t\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-2); \n\t\t\t\tz-index: 20;}\n\t\t\t\tthead td.locked {z-index: 30;}\n\t\t\t\ttd.locked,  th.locked{\n\t\t\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\t\t\tposition: relative;\n\t\t\t\tz-index: 10;}\n\t\t\t\ttd.locked,  th.locked{\n\t\t\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\t\t\tposition: relative;\n\t\t\t\tz-index: 10;}\n\t\t\t</style>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\n\n\tfunction selected(i)\n\t{\n\t\t\tvar selected_row=eval(\"document.forms[0].selected_row\"+i);\n\t\t\t\n\t\t\tif(selected_row.checked==false)\n\t\t\t{\n\t\t\t\tselected_row.checked=false;\n\t\t\t\tdocument.forms[0].checked_row.value=\"\";\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tvar total_records=document.forms[0].total_records.value;\n\t\t\t\tfor(var j=0;j<total_records;j++)\n\t\t\t{\n\t\t\t\tvar temp=eval(\"document.forms[0].selected_row\"+j);\n\t\t\t\ttemp.checked=false;\n\t\t\t\t//temp.value=\"false\";\n\t\t\t}\n\t\t\t\tselected_row.checked=true;\n\t\t\t\t//selected_row.value=\"true\";\n\t\t\t\tdocument.forms[0].checked_row.value=i;\n\t\t\t}\n\t\t\t\n\t}\n\nfunction tot_setld_amt()\n{\n\tvar total_settled=0.0;\t\n\tvar tot_setl=\"\";\n\tvar a1=new Array();\n\tvar formObj = parent.BillSlmtTypeFrame.document.BillSlmtTypeForm;\n\tvar\ttotalRecords =eval(formObj.total_records.value);\t\n\tfor(var i=0;i<totalRecords;i++)\n\t{\n\t  tot_setl=eval(\"parent.frames[1].document.forms[0].billslmtamt\"+i);\n\t  a1[i]=tot_setl.value;\n\t  if(a1[i]==\"\"){a1[i]=\"0.0\";}\n\t  total_settled=parseFloat(total_settled) + parseFloat(a1[i]);\t  \n\t}\t\n\tdocument.forms[0].total_settled_amt.value=total_settled;\n\tvar temp_total_settled=eval(\"document.forms[0].total_settled_amt\");\n\tputdeci(temp_total_settled);\n\tvar v_set_amt=parent.frames[0].document.forms[0].billslmtamtdet.value;\n\tif(parseFloat(temp_total_settled.value)==parseFloat(v_set_amt))\n\t{\n\t\tparent.frames[0].document.forms[0].billslmtamtdet.readOnly=true;\n\t}\n}\n\n\nfunction putdeci(object)\n\t{\t\n\t\tif(object.value!=\'\')\n\t\t{\n\t\tvar decimal=document.forms[0].noofdecimal.value;\n\t\tputDecimal(object,17,decimal);\n\t\t}\n\t}\n\nfunction chkForDfltSlmtType()\n{\n\tdocument.forms[0].add_bill_stlmt_button.click();\n}\n\nfunction check_box(i)\n\t{\n\t\tvar onlineapproval=eval(\"document.forms[0].onlineapproval\"+i);\n\n\t\tif(onlineapproval.value==\"checked\")\n\t\t{\n\t\t\tonlineapproval.checked=true;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tonlineapproval.checked=false;\n\t\t}\n\t}\n\n</script>\n\t\t\n  \t</head>\n\t<!--<body onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\" \"    onSelect=\"codeArrestThruSelect();\"> -->\n\t<body  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n\t<form name=\'BillSlmtTypeForm\' id=\'BillSlmtTypeForm\' id=\'BillSlmtTypeForm\' method=\'post\' action=\'\'  scrolling=no >\t\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n<div>\n\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align=\'center\' width=\'99%\'>\t\n\t<tr><th align = \'left\' class=\'columnHeader\' colspan=\'16\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</th></tr>\n\t</table></div>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t<div id=\"tbl-container\" STYLE=\"overflow: auto; width: 99%; height: 100%;   padding:3px; margin: 0px\">\n\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<div id=\"tbl-container\" STYLE=\"overflow: auto; width: 99%; height: 100%;   padding:3px; margin: 0px\">\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\' align = \'center\' id=\'bill_slmt_data\' width=\'100%\'>\t\n\t\t\n\t\t<thead><tr>\n\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\t\t\t\n\t\t<td class=\'COLUMNHEADER\' width=\"6%\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\t\t\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\t\t\n\t\t<td class=\'COLUMNHEADER\' width=\"6%\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\n\t\t<td class=\'COLUMNHEADER\' width=\"6%\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t<td class=\'COLUMNHEADER\' width=\'8%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\t\n\t\t\n\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'9%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\t\n\t\t<td class=\'COLUMNHEADER\' width=\'9%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'4%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t<td class=\'COLUMNHEADER\' width=\'5%\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t<!--  Added by Monika Gupta for NMC-JD-CRF-0199\t -->\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n\t\t</tr></thead>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n<tbody>\n\t<tr id=row";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 =">\n\t<tr>\n\t<td class=";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" width=\'6%\'><input type=\"checkbox\" name=\'selected_row";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' id=\'selected_row";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onClick=\"selected(";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =")\"></td>\t \n\n\t<td class=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" width=\"6%\"><INPUT TYPE=\"TEXT\" name=\'billslmtamt";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' id=\'billslmtamt";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' SIZE=\"10\" MAXLENGTH=\"20\" \tVALUE=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'  style=\'text-align:right\' readonly> </td>\t\n\t\n\t<td class=";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =" width=\"6%\" >\n\t<input type=\'text\' name=\'shortdesc";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' id=\'shortdesc";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' size=\'10\' maxlength=\'20\'value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'>\n\t<input type=\'hidden\' name=\'slmttype";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'slmttype";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' readonly>\n\t<input type=\'hidden\' name=\'couponcode";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\' id=\'couponcode";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' >\n\t</td>\n\t<td class=";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" width=\"6%\" class=\"fields\"><input type=\'text\' name=\'cash_given";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' id=\'cash_given";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' size=\'10\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' readonly> </td>\n\t<td class=";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 =" width=\"6%\" class=\"fields\"><input type=\'text\' name=\'cash_return";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' id=\'cash_return";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' readonly> </td>\n\n\t<td class=";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" width=\"8%\" ><input type=\'text\' name=\'instref";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\' id=\'instref";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' size=\'10\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' readonly>\n\t<td class=";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 =" width=\"6%\"><input type=\'text\' name=\'instdate";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' id=\'instdate";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\' size=\'10\' maxlength=\'10\' value=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' readonly></td>\t\n\t<td class=";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" width=\"9%\"><input type=\'text\' readonly name=\'creditcardco";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' id=\'creditcardco";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\' maxlength=\'30\' size=\'10\'  tabindex=\'0\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' readonly></td>\n\t<td class=";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 =" width=\"9%\"><input type=\'text\' readonly name=\'instbankname";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\' id=\'instbankname";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' maxlength=\'60\' size=\'10\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' readonly></td>  \n\n\t<td class=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =" width=\"6%\"><input type=\'text\' readonly name=\'instbranch";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' id=\'instbranch";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' ></td>  \n\t<input type= hidden name=\"instremarkcode";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" id=\"instremarkcode";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\"  value=\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\'>\t        \n\t\n\t <td class=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="width=\"4%\"><input type=\'text\' name=\'batchno";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\' id=\'batchno";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' readonly>4</td>\t\n\t <td class=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="width=\"5%\" ><input type=\'text\' name=\'apprrefno";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\' id=\'apprrefno";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' size=\'20\' maxlength=\'30\' \n\t value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' readonly></td>\n\t <td class=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="width=\"5%\" ><input type=\'text\' name=\'saledraftno";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' id=\'saledraftno";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' size=\'20\' maxlength=\'20\' value=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' readonly></td>\t\n<!--  Added by Monika Gupta for NMC-JD-CRF-0199\t\t -->\n\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n\t<td class=";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =" width=\"6%\"><input type=\'text\' name=\'cc_term_id_num";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' id=\'cc_term_id_num";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' size=\'20\' maxlength=\'30\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' readonly></td>\t\n\t";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\t\n\t\t<input type=\'hidden\' name=\'cc_term_id_num";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t <td class=";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="width=\"6%\" ><input type=\'text\' name=\'payername";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' id=\'payername";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' size=\'20\' maxlength=\'20\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\" readonly></td>\n\t <td class=";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 =" width=\"6%\"><input type=\'text\' name=\'recrefidno";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' id=\'recrefidno";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' readonly></td>\n\t<INPUT TYPE=\"HIDDEN\" name=\'ext_acc_interface_yn";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' id=\'ext_acc_interface_yn";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' MAXLENGTH=\"10\" VALUE=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\'>\n\t<INPUT TYPE=\"HIDDEN\" name=\'ext_acc_fac_id";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\' id=\'ext_acc_fac_id";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t<INPUT TYPE=\"HIDDEN\" name=\'credit_card_machine_int_yn";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\' id=\'credit_card_machine_int_yn";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\' VALUE=\'\'>\n\t<INPUT TYPE=\"HIDDEN\" name=\'Cash_check";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\' id=\'Cash_check";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\' VALUE=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t\n\t<td class=";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" width=\"6%\"><input type=\'checkbox\' name=\'onlineapproval";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\' id=\'onlineapproval";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 =" readonly  onclick=\'check_box(";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 =")\'></td>\t\t\n\t </tr>\n";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\n\t<tr id=row";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'  style=\'text-align:right\' onBlur=\'\'> </td>\t\n\t\n\t<td class=";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' size=\'20\' maxlength=\'40\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t<input type=\'hidden\' name=\'couponcode";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\' >\n\t</td>\n\n\t<td class=";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\' size=\'10\' maxlength=\'30\' style=\'text-align:right\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'> </td>\n\t<td class=";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'> </td>\n\n\t<td class=";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n\t<td width=\"6%\" class=";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="><input type=\'text\' name=\'instdate";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' size=\'10\' maxlength=\'10\'value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'></td>\t\n\t<td width=\"9%\" class=";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="><input type=\'text\' readonly name=\'creditcardco";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\'></td>\n\t<td class=";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\' ></td>  \t\n\n\t<td class=";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'></td>\t\n\t <td class=";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'></td>\n\t <td class=";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'></td>\n\t   <!--  Added by Monika Gupta for NMC-JD-CRF-0199\t\t -->\n\t   ";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 =" width=\"4%\"><input type=\'text\' name=\'cc_term_id_num";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\' readonly></td>\t\n\t ";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\' >\n\t";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\"></td>\n\t <td width=\"5%\" class=";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="><input type=\'text\' name=\'recrefidno";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'></td>\n\t <INPUT TYPE=\"HIDDEN\" name=\'ext_acc_interface_yn";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n\t<INPUT TYPE=\"HIDDEN\" name=\'Cash_check";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 =" ><input type=\'checkbox\' name=\'onlineapproval";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 =" readonly    onclick=\'check_box(";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 =")\'></td>\t\t\t\n\t</tr>\n\n\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t\t\t\t<tr id=row";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 =">\n\t\t\t\t<tr>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 =")\"></td>\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\'  style=\'text-align:right\' readonly> </td>\t\t\t\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 =" width=\"6%\" ><input type=\'text\' name=\'shortdesc";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\'>\n\t\t\t\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'><input type=\'hidden\' name=\'slmttype";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" readonly>\n\t\t\t\t</td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\' readonly> </td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\' readonly> </td>\n\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\' readonly>\n\t\t\t\t<td width=\"6%\" class=";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\' readonly></td>\t\n\t\t\t\t<td width=\"9%\" class=";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\' maxlength=\'30\' size=\'10\'  tabindex=\'0\' value=\'\' value=\'\' readonly></td>\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\' maxlength=\'60\' size=\'15\' value=\'";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\' readonly></td>  \n\t\t\t\t\n\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\' ></td>  \n\t\t\t\t<input type= hidden name=\"instremarkcode";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\'>\t        \n\t\t\t\t\n\t\t\t\t <td class=";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\' readonly></td>\t\n\t\t\t\t <td class=";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\' readonly></td>\n\t\t\t\t <td class=";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" readonly ></td>\n\t\t\t\t <td width=\"5%\" class=";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\' readonly></td>\n\t\t\t\t<INPUT TYPE=\"HIDDEN\" name=\'ext_acc_interface_yn";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\' MAXLENGTH=\"10\" VALUE=\'\'>\n\t\t\t\t<INPUT TYPE=\"HIDDEN\" name=\'ext_acc_fac_id";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\' MAXLENGTH=\"10\" VALUE=\'\'>\n\t\t\t\t<INPUT TYPE=\"HIDDEN\" name=\'credit_card_machine_int_yn";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\' VALUE=\'\'>\n\t\t\t\t<INPUT TYPE=\"HIDDEN\" name=\'Cash_check";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\' VALUE=\'\'> <!-- Added V070618-Subha/IN67859  -->\n\t\t\t\t<td width=\"6%\" class=";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 =")\'></td>\t\t\t\t\t\n\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\n\t<tr id=row";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\' SIZE=\"10\" MAXLENGTH=\"20\" \tVALUE=\'\'  style=\'text-align:right\' readonly> </td>\t\n\t\n\t<td class=";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\' size=\'20\' maxlength=\'40\'>\n\t<input type=\'hidden\' name=\'Case\' id=\'Case\' value=\'1\'><input type=\'hidden\' name=\'slmttype";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\' value=\'\' readonly>\n\n\t</td>\n\n\t<td class=";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\' size=\'10\' maxlength=\'30\' value=\'\' readonly> </td>\n\t<td class=";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\' size=\'10\' maxlength=\'30\' value=\'\' readonly> </td>\n\n\t<td class=";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\' size=\'10\' maxlength=\'20\' readonly>\n\t<td width=\"6%\" class=";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\' size=\'10\' maxlength=\'10\' readonly></td>\t\n\t<td width=\"9%\" class=";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\' maxlength=\'30\' size=\'10\'  tabindex=\'0\' value=\'\' readonly></td>\n\t<td class=";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\' maxlength=\'60\' size=\'15\' value=\'\' readonly></td>  \n\t\n\n\t<td class=";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\' maxlength=\'60\' size=\'15\' value=\'\' ></td>  \n\t<input type= hidden name=\"instremarkcode";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\"  value=\'\'>\t        \n\t\n\t <td class=";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

    private final static java.lang.String  _wl_block186 ="\' size=\'10\' maxlength=\'10\' readonly></td>\t\n\t <td class=";
    private final static byte[]  _wl_block186Bytes = _getBytes( _wl_block186 );

    private final static java.lang.String  _wl_block187 ="\' size=\'10\' maxlength=\'10\' readonly></td>\n\t <td class=";
    private final static byte[]  _wl_block187Bytes = _getBytes( _wl_block187 );

    private final static java.lang.String  _wl_block188 ="\' size=\'10\' maxlength=\'10\' value=\'\' readonly></td>\n\t <td class=";
    private final static byte[]  _wl_block188Bytes = _getBytes( _wl_block188 );

    private final static java.lang.String  _wl_block189 ="\' size=\'20\' maxlength=\'20\' value=\'\' readonly></td>\n\t <td width=\"5%\" class=";
    private final static byte[]  _wl_block189Bytes = _getBytes( _wl_block189 );

    private final static java.lang.String  _wl_block190 ="\' size=\'20\' maxlength=\'20\' value=\'\' readonly></td>\n\t<INPUT TYPE=\"HIDDEN\" name=\'ext_acc_interface_yn";
    private final static byte[]  _wl_block190Bytes = _getBytes( _wl_block190 );

    private final static java.lang.String  _wl_block191 ="\' MAXLENGTH=\"10\" VALUE=\'\'>\n\t<INPUT TYPE=\"HIDDEN\" name=\'ext_acc_fac_id";
    private final static byte[]  _wl_block191Bytes = _getBytes( _wl_block191 );

    private final static java.lang.String  _wl_block192 ="\' MAXLENGTH=\"10\" VALUE=\'\'>\n\t<INPUT TYPE=\"HIDDEN\" name=\'credit_card_machine_int_yn";
    private final static byte[]  _wl_block192Bytes = _getBytes( _wl_block192 );

    private final static java.lang.String  _wl_block193 ="\' VALUE=\'\'>\n\t<td width=\"6%\" class=";
    private final static byte[]  _wl_block193Bytes = _getBytes( _wl_block193 );

    private final static java.lang.String  _wl_block194 ="\' value=\'\' CHECKED readonly  onclick=\'check_box(";
    private final static byte[]  _wl_block194Bytes = _getBytes( _wl_block194 );

    private final static java.lang.String  _wl_block195 =")\'></td>\t\n\t\n </tr>\n";
    private final static byte[]  _wl_block195Bytes = _getBytes( _wl_block195 );

    private final static java.lang.String  _wl_block196 ="\n\t</tbody>\n\t</table>\n\t</div>\t\n\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block196Bytes = _getBytes( _wl_block196 );

    private final static java.lang.String  _wl_block197 ="\'>\n\t<input type=\'hidden\' name=\'checked_row\' id=\'checked_row\' value=\'\' >\t\n\t<input type= hidden name=\"locale\" id=\"locale\"  value=\'";
    private final static byte[]  _wl_block197Bytes = _getBytes( _wl_block197 );

    private final static java.lang.String  _wl_block198 ="\'>\n\t<input type= hidden name=\"noofdecimal\" id=\"noofdecimal\"  value=\'";
    private final static byte[]  _wl_block198Bytes = _getBytes( _wl_block198 );

    private final static java.lang.String  _wl_block199 ="\'>\n\t<input type= hidden name=\"rtnCurrSlmt\" id=\"rtnCurrSlmt\"  value=\'\'>\n\t<input type=hidden name=\'cc_terminal_id_enable\' id=\'cc_terminal_id_enable\' value=\"";
    private final static byte[]  _wl_block199Bytes = _getBytes( _wl_block199 );

    private final static java.lang.String  _wl_block200 ="\">\t\t<!--Added by Monika for NMC-JD-CRF-0199 on 04/08/2023 -->\t\n\t<input type= hidden name=\"rtnCurrSlmtBAL\" id=\"rtnCurrSlmtBAL\"  value=\'\'>\n\n\t<input type= hidden name=\"rtnPendSlmt\" id=\"rtnPendSlmt\"  value=\'\'>\n\t<input type= hidden name=\"services_tot_records\" id=\"services_tot_records\"  value=\'\'>\n\t<input type= hidden name=\"rtnArrayDt\" id=\"rtnArrayDt\"  value=\'\'>\n\t<input type= hidden name=\"rtnArrayDocref\" id=\"rtnArrayDocref\"  value=\'\'>\n\t<input type= hidden name=\"rtnArrayDocrefLine\" id=\"rtnArrayDocrefLine\"  value=\'\'>\n\t<input type= hidden name=\"rtnArrayDocrefSeq\" id=\"rtnArrayDocrefSeq\"  value=\'\'>\n\n\t<input type= hidden name=\"rtnBlngServCode\" id=\"rtnBlngServCode\"  value=\'\'>\n\n\t<input type= hidden name=\"roundingamt\" id=\"roundingamt\"  value=\'\'>\n\t<input type= hidden name=\"rtnTrxDate\" id=\"rtnTrxDate\"  value=\'\'>\n\t<input type= hidden name=\"rtnPrtGrpHdrCode\" id=\"rtnPrtGrpHdrCode\"  value=\'\'>\n\t<input type= hidden name=\"rtnPrtGrpLineCode\" id=\"rtnPrtGrpLineCode\"  value=\'\'>\n\t<input type= hidden name=\"rtnUpdGrossChrgAmt\" id=\"rtnUpdGrossChrgAmt\"  value=\'\'>\n\t<input type= hidden name=\"rtnUpdNetChrgAmt\" id=\"rtnUpdNetChrgAmt\"  value=\'\'>\n\n\t<input type= hidden name=\"tot_rec_for_serv_insert\" id=\"tot_rec_for_serv_insert\"  value=\'\'>\n\n\t\t<input type= hidden name=\"refnumber\" id=\"refnumber\"  value=\'\'>\n\n\n\n\t<input type= hidden name=\"rec_refund_amt\" id=\"rec_refund_amt\"  value=\'\'>\n\t<input type= hidden name=\"function_id\" id=\"function_id\"  value=\'";
    private final static byte[]  _wl_block200Bytes = _getBytes( _wl_block200 );

    private final static java.lang.String  _wl_block201 ="\'>\n\t<input type= hidden name=\"querystring\" id=\"querystring\"  value=\'";
    private final static byte[]  _wl_block201Bytes = _getBytes( _wl_block201 );

    private final static java.lang.String  _wl_block202 ="\'>\n\n\t<input type= hidden name=\"rcpt_rfnd_ind\" id=\"rcpt_rfnd_ind\"  value=\'\'>\n\t<input type= hidden name=\"rcpt_nature_code\" id=\"rcpt_nature_code\"  value=\'\'>\n\t<input type= hidden name=\"rcpt_type_code\" id=\"rcpt_type_code\"  value=\'\'>\n\t<input type= hidden name=\"patient_id\" id=\"patient_id\"  value=\'\'>\n\t<input type= hidden name=\"episode_type\" id=\"episode_type\"  value=\'\'>\n\t<input type= hidden name=\"episode_id\" id=\"episode_id\"  value=\'\'>\n\t<input type= hidden name=\"visit_id\" id=\"visit_id\"  value=\"";
    private final static byte[]  _wl_block202Bytes = _getBytes( _wl_block202 );

    private final static java.lang.String  _wl_block203 ="\">\n\t<input type= hidden name=\"encounter_id\" id=\"encounter_id\"  value=\'\'>\n\t<input type= hidden name=\"cash_counter_code\" id=\"cash_counter_code\"  value=\'";
    private final static byte[]  _wl_block203Bytes = _getBytes( _wl_block203 );

    private final static java.lang.String  _wl_block204 ="\'>\n\t<input type= hidden name=\"shift_id\" id=\"shift_id\"  value=\'\'>\n\t<input type= hidden name=\"doc_amt\" id=\"doc_amt\"  value=\'\'>\n\t<input type= hidden name=\"narration\" id=\"narration\"  value=\'\'>\n\t<input type= hidden name=\"ip_adm_trf_dep_ind\" id=\"ip_adm_trf_dep_ind\"  value=\'\'>\n\t<input type= hidden name=\"rec_ref_format_ind\" id=\"rec_ref_format_ind\"  value=\'\'>\n\t<input type= hidden name=\"rfnd_dep_in_use_yn\" id=\"rfnd_dep_in_use_yn\"  value=\'\'>\n\t<input type= hidden name=\"pmnt_thru_mail\" id=\"pmnt_thru_mail\"  value=\'\'>\n\t<input type= hidden name=\"ext_acc_facility_id\" id=\"ext_acc_facility_id\"  value=\'\'>\n\t<input type= hidden name=\"ext_acc_code\" id=\"ext_acc_code\"  value=\'\'>\n\t<input type= hidden name=\"ext_acc_dept_code\" id=\"ext_acc_dept_code\"  value=\'\'>\n\t<input type= hidden name=\"mult_slmt_yn\" id=\"mult_slmt_yn\"  value=\'\'>\n\t<input type= hidden name=\"downtime_entry_yn\" id=\"downtime_entry_yn\"  value=\'\'>\n\t<input type= hidden name=\"downtime_doc_type_code\" id=\"downtime_doc_type_code\"  value=\'\'>\n\t<input type= hidden name=\"downtime_doc_num\" id=\"downtime_doc_num\"  value=\'\'>\n\t<input type= hidden name=\"downtime_doc_date\" id=\"downtime_doc_date\"  value=\'\'>\n\t<input type=\'hidden\' name=\"downtime_reason_code\" id=\"downtime_reason_code\" value=\'\'  onBlur=\"\">\n\t<input type= hidden name=\"cc_machine_id\" id=\"cc_machine_id\"  value=\'\'>\n\t\t<input type= hidden name=\"request_id\" id=\"request_id\"  value=\'\'>\n\t<input type= hidden name=\"payers_add1\" id=\"payers_add1\"  value=\'\'>\n\t<input type= hidden name=\"payers_add2\" id=\"payers_add2\"  value=\'\'>\n\t<input type= hidden name=\"payers_add3\" id=\"payers_add3\"  value=\'\'>\n\t<input type= hidden name=\"payers_tel_num\" id=\"payers_tel_num\"  value=\'\'>\n\t<input type= hidden name=\"consolidated_receipt_yn\" id=\"consolidated_receipt_yn\"  value=\'\'>\n\t<input type= hidden name=\"currdate\" id=\"currdate\"  value=\'\'>\n\t<input type= hidden name=\"str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd\" id=\"str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd\"  value=\'\'>\n\t<input type= hidden name=\"hand_without_counter_chk_out\" id=\"hand_without_counter_chk_out\"  value=\'\'>\n\t\t<input type= hidden name=\"customercode\" id=\"customercode\"  value=\'\'>\n\t<input type= hidden name=\"remark\" id=\"remark\"  value=\'\'>\n\t<input type= hidden name=\"origdocnumber\" id=\"origdocnumber\"  value=\'\'>\n\t<input type= hidden name=\"ref\" id=\"ref\"  value=\'\'>\n\t<input type= hidden name=\"totalbill\" id=\"totalbill\"  value=\'\'>\n\t<input type= hidden name=\"billpaid\" id=\"billpaid\"  value=\'\'>\n\t\n\t<input type= hidden name=\"orgdoctype\" id=\"orgdoctype\"  value=\'\'>\n\t<input type= hidden name=\"orgdocnumber\" id=\"orgdocnumber\"  value=\'\'>\n\t<input type= hidden name=\"orgdocsrno\" id=\"orgdocsrno\"  value=\'\'>\n\t\n\t\n\t\n\t<input type= hidden name=\"pkgSeqNo\" id=\"pkgSeqNo\"  value=\'\'>\n\t\t<input type= hidden name=\"total_settled_amt\" id=\"total_settled_amt\"  value=\'\'>\n\t\n\t<!-- Added for MMS SCF 501.1 -->\n\t<input type= \'hidden\' name=\"pkgSequenceNumber\" id=\"pkgSequenceNumber\"  value=\'\'>\n\t<input type=\'hidden\' name=\'pkgSequenceAmount\' id=\'pkgSequenceAmount\' value=\'\'>\n\t<input type=\'hidden\' name=\'splAgnDpstYN\' id=\'splAgnDpstYN\' value=\'\'>\n\t<input type= \'hidden\' name=\"splAgnDepEffFrom\" id=\"splAgnDepEffFrom\"  value=\'\'>\n\t<input type=\'hidden\' name=\'splAgnDepEffTo\' id=\'splAgnDepEffTo\' value=\'\'>\n\n\n</form>\t \n\n<script>\n\t\tif(document.forms[0].function_id.value==\'rcpt_rfnd\' || document.forms[0].function_id.value==\'PKG_BILLING\')\n\t\t{\t\t\t\n\t\t\tvar rec_refund_amt=document.forms[0].rec_refund_amt.value;\n\t\t\tvar querystring=document.forms[0].querystring.value;\n\t\t\tparent.frames[3].location.href=\"../../eBL/jsp/BLBillSlmtTypeBtn.jsp?rec_refund_amt=\"+rec_refund_amt+\"&\"+querystring;\t\n\n\t\t}\n\t\telse{\n\t//var query_string=document.forms[0].query_string.value;\t\n\tparent.frames[3].location.href=\"../../eBL/jsp/BLBillSlmtTypeBtn.jsp?";
    private final static byte[]  _wl_block204Bytes = _getBytes( _wl_block204 );

    private final static java.lang.String  _wl_block205 ="\";\t\n\t\t}\n</script>\n\n</body>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block205Bytes = _getBytes( _wl_block205 );
	
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

private String replaceNull(String input){
	if(input == null || "null".equals(input)){
		input = "";
	}
	return input;
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
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);


	Connection con = null;
	//Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rscurr=null;
	request.setCharacterEncoding("UTF-8");


	String		strfacilityid ="";	
	String		strslmtidno = request.getParameter("slmtidno");	
	String		strslmtpayername = request.getParameter("slmtpayername");	
	String		strbilldoctypecode = request.getParameter("billdoctypecode");
	if ( strbilldoctypecode == null || strbilldoctypecode.equalsIgnoreCase("null")) 
	{strbilldoctypecode = "";}
	String		strbilldocnum = request.getParameter("billdocnum");	
	if ( strbilldocnum == null || strbilldocnum.equalsIgnoreCase("null")) 
	{strbilldocnum = "";}
	String querystring=(String)request.getQueryString();
	String error_flag="";
	error_flag=request.getParameter("error_flag");
	if ( error_flag == null || error_flag.equalsIgnoreCase("null")) 
	{error_flag = "";}
	String cash_counter_code = request.getParameter("cashcounter");
	if(cash_counter_code == null) cash_counter_code="";
	
	//String	str_receipt_type_code = "";	//String	str_ext_acc_facility_id = "";
	//String	str_ext_account_code	= "";	//String	str_ext_dept_ind = "";
	//String	str_ext_dept_code     = ""; 	//String	str_single_service_grp_yn = "";
	//String	str_service_grp		= ""; 	//String	str_acc_episode_type= "";
	//String	str_acc_category_code	= "";	//String	str_acc_serv_grp_used_yn	= "";
	//String	str_reln_code		= "";	//String	str_episode_type		= "";
	
	int totalRecords=0; 	int noofdecimal=2;	
	String classval="";	String remove_check="";	
	ArrayList output_records=new ArrayList();
	//ArrayList output_records1=new ArrayList();
	ArrayList a1=new ArrayList();ArrayList a2=new ArrayList(); ArrayList a3=new ArrayList();ArrayList a4=new ArrayList();ArrayList a5=new ArrayList();ArrayList a6=new ArrayList();ArrayList a7=new ArrayList();ArrayList a8=new ArrayList();ArrayList a9=new ArrayList();ArrayList a10=new ArrayList();ArrayList a11=new ArrayList();ArrayList a12=new ArrayList();ArrayList a13=new ArrayList();ArrayList a14=new ArrayList();
	ArrayList a15=new ArrayList();ArrayList a16=new ArrayList();ArrayList a17=new ArrayList();ArrayList a18=new ArrayList();ArrayList a19=new ArrayList();ArrayList a20=new ArrayList();ArrayList a21=new ArrayList();ArrayList a22=new ArrayList();ArrayList a23=new ArrayList();
	String function_id="";
	String locale	= (String)session.getAttribute("LOCALE");	
	
	if ( strslmtidno == null || strslmtidno.equalsIgnoreCase("null")) 
	{strslmtidno = "";}

	if ( strslmtpayername == null || strslmtpayername.equalsIgnoreCase("null")) 
	{strslmtpayername = "";}

	con	=	ConnectionManager.getConnection(request);
	//Added for ML-MMOH-CRF-1088 Rajesh V
	boolean chequeLengthChange = CommonBean.isSiteSpecific(con, "BL", "CHEQUE_OTHERS_MAX_CHARS");
	/*  Added by Monika against NMC-JD-CRF-0199	*/
	boolean cc_terminal_id_enable = CommonBean.isSiteSpecific(con, "BL", "CC_TERMINAL_ID_ENABLE");
		String strslmttype= request.getParameter("slmttype");	
		strfacilityid	=  (String) session.getValue("facility_id");
		//unused variable, commented on 09/06/05
		//strloggeduser	=  (String) session.getValue("login_user");

		
		//String ext_acc_interface_yn = "";
		if( strslmttype == null) strslmttype="";
		function_id = request.getParameter("function_id");
		if(function_id==null) function_id="";	
		String strepisode_id = replaceNull(request.getParameter("episode_id"));	
		int episode_id=0;
		if("".equals(strepisode_id)){
			episode_id=0;
		}		
		else
		{
			try
			{
				episode_id=Integer.parseInt(strepisode_id);	
			}catch(Exception e)
			{
				episode_id=0;
			}
		}//if(episode_id==null) episode_id="";		
		System.out.println("episode_id settlement type="+episode_id);
		
		String strVisit_id = replaceNull(request.getParameter("visit_id"));	
		int visit_id=0;
		if("".equals(strVisit_id)){
			visit_id=0;
		}		
		else
		{
			try
			{
				visit_id=Integer.parseInt(strVisit_id);	
			}catch(Exception e)
			{
				visit_id=0;
			}
		}
		System.out.println("visit_id="+visit_id);
		String strencounter_id = replaceNull(request.getParameter("encounter_id"));	
		int encounter_id=0;
		if("".equals(strencounter_id)){
			encounter_id=0;
		}		
		else
		{
			try
			{
				encounter_id=Integer.parseInt(strencounter_id);	
			}catch(Exception e)
			{
				encounter_id=0;
			}
		}
		System.out.println("encounter_id="+encounter_id);
	

	String custId = BLReportIdMapper.getCustomerId();
		

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);


	try{		
		pstmt = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
		rscurr = pstmt.executeQuery();	
		while(rscurr.next())
		{
			noofdecimal  =  rscurr.getInt(1);		
		}		
			rscurr.close();
			pstmt.close();
		}catch(Exception e) {System.out.println("3="+e.toString());}
		try
		{		
			remove_check=request.getParameter("remove_check");
			if(remove_check==null) remove_check="";			
			String checked_row="";
			String record_count="";
			int total_records=0;
			int selected_index=0;		
			if(checked_row==null) checked_row="";
			if(remove_check.equals("remove"))
			{
				if(!(error_flag.equals(""))){ //CRF-13
				error_flag="";}                 
				record_count=request.getParameter("total_records");
				if(record_count==null) record_count="";
				total_records=Integer.parseInt(record_count);			
				checked_row=request.getParameter("checked_row");
				if(checked_row==null) checked_row="";
				selected_index=Integer.parseInt(checked_row);	
				
					for(int i=0;i<total_records;i++)
					{	
						//System.err.println("199,inside for--->"+((i==selected_index)));
						//if(!(i==selected_index)) //commented against GHL-SCF-1600 
						if((i==selected_index)) //added By Nandhini against GHL-SCF-1600 V211010
						{							
						try{
						String temp1=request.getParameter("billslmtamt"+i);						
						a1.add(temp1);							
						temp1=request.getParameter("shortdesc"+i);						
						a2.add(temp1);	
						temp1=request.getParameter("slmttype"+i);						
						a3.add(temp1);	
						temp1=request.getParameter("cash_given"+i);						
						a4.add(temp1);	
						temp1=request.getParameter("cash_return"+i);						
						a5.add(temp1);							
						temp1=request.getParameter("instref"+i);						
						a6.add(temp1);				
						temp1=request.getParameter("instdate"+i);										
						a7.add(temp1);	
						temp1=request.getParameter("creditcardco"+i);						
						a8.add(temp1);	
						temp1=request.getParameter("instbankname"+i);						
						a9.add(temp1);	
						temp1=request.getParameter("instbranch"+i);						
						a10.add(temp1);	
						temp1=request.getParameter("instremarkcode"+i);						
						a11.add(temp1);	
						temp1=request.getParameter("batchno"+i);						
						a12.add(temp1);	
						temp1=request.getParameter("apprrefno"+i);						
						a13.add(temp1);	
						temp1=request.getParameter("saledraftno"+i);						
						a14.add(temp1);	
						temp1=request.getParameter("payername"+i);						
						a15.add(temp1);	
						temp1=request.getParameter("recrefidno"+i);								
						a16.add(temp1);	
//						System.out.println("checked_row remove :16");
						temp1=request.getParameter("onlineapproval"+i);						
						a17.add(temp1);	
						temp1=request.getParameter("ext_acc_interface_yn"+i);						
						a18.add(temp1);	
						temp1=request.getParameter("ext_acc_fac_id"+i);						
						a19.add(temp1);	
						temp1=request.getParameter("credit_card_machine_int_yn"+i);						
						a20.add(temp1);	
						temp1=request.getParameter("Cash_check"+i);						
						a21.add(temp1);	
						temp1=request.getParameter("couponcode"+i);			//V210113			
						a22.add(temp1);	
						/*   Added by Monika Gupta for NMC-JD-CRF-0199		 */
						temp1=request.getParameter("cc_term_id_num"+i);						
						a23.add(temp1);	
						}catch(Exception e){System.out.println("Exception in :"+e);}
					//j++;
					}	
					
			System.out.println("257,17--selected_index>>>"+selected_index);
		//	selected_index=1;
		
			a1.remove(selected_index);
			a2.remove(selected_index);
			a3.remove(selected_index);
			a4.remove(selected_index);
			a5.remove(selected_index);
			a6.remove(selected_index);
			a7.remove(selected_index);
			a8.remove(selected_index);
			a9.remove(selected_index);
			a10.remove(selected_index);
			a11.remove(selected_index);
			a12.remove(selected_index);
			a13.remove(selected_index);
			a14.remove(selected_index);
			a15.remove(selected_index);
			a16.remove(selected_index);
			a17.remove(selected_index);
			a18.remove(selected_index);
			a19.remove(selected_index);
			//added by nandhini against GHL-SCF-1600 V211010
			a20.remove(selected_index);
			a21.remove(selected_index);
			a22.remove(selected_index);
			a23.remove(selected_index);
			}
			}
		
	}catch(Exception eX)
	{	
		//out.println("Error1= "+eX);
		//System.out.println("Error in remove" +eX);
		eX.printStackTrace();
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

	
try{

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

		if(function_id.equals("rcpt_rfnd") || function_id.equals("PKG_BILLING"))
		{
	
            _bw.write(_wl_block12Bytes, _wl_block12);

		}else {
	
            _bw.write(_wl_block13Bytes, _wl_block13);
			}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
if(custId.equals("GP")){ 
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
}else{ 
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
if(chequeLengthChange){ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{ 
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
if(cc_terminal_id_enable){ 
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
} 
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

		int  record_select=0;
		if(error_flag.equals("true"))
		{

			int i=0;
			String[] output1=new String[21];
			output_records=(ArrayList)session.getAttribute("existing_records_array");

			for(int k=0;k<output_records.size();k++)
				{
				output1=(String[])output_records.get(k);
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}	

            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(output1[0]));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(output1[19]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(output1[1]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(output1[20]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(output1[2]));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(output1[3]));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(output1[4]));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(output1[5]));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(output1[6]));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(output1[7]));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(output1[8]));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(output1[18]));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(output1[10]));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(output1[11]));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[12]));
            _bw.write(_wl_block89Bytes, _wl_block89);
if(cc_terminal_id_enable){ 
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(output1[18]));
            _bw.write(_wl_block94Bytes, _wl_block94);
}else{ 
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(output1[18]));
            _bw.write(_wl_block96Bytes, _wl_block96);
} 
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(output1[13]));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(output1[14]));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(output1[15]));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(output1[16]));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(output1[25]));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(output1[17]));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block119Bytes, _wl_block119);

				i++;
				 totalRecords=i;		
				}	
				error_flag = "";
	}
		else if(remove_check.equals("remove"))
			{		
			totalRecords=a1.size();
			record_select=1;
			for(int i=0;i<totalRecords;i++)
			{	
			if(i % 2 == 0 )
			{
				classval	=	"QRYEVEN";
			}
			else
			{
				classval	=	"QRYODD";
			}
			

            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(a1.get(i)));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(a2.get(i)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(a3.get(i)));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(a22.get(i)));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(a4.get(i)));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(a5.get(i)));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(a6.get(i)));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(a7.get(i)));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(a8.get(i)));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(a9.get(i)));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(a10.get(i)));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(a11.get(i)));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(a12.get(i)));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(a13.get(i)));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(a14.get(i)));
            _bw.write(_wl_block137Bytes, _wl_block137);
if(cc_terminal_id_enable){ 
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(a23.get(i)));
            _bw.write(_wl_block139Bytes, _wl_block139);
} else{ 
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(i));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(a23.get(i)));
            _bw.write(_wl_block140Bytes, _wl_block140);
} 
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(a15.get(i)));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(a16.get(i)));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(a18.get(i)));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(a19.get(i)));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(a20.get(i)));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(a21.get(i)));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(a17.get(i)));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(a17.get(i)));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);

		record_select++;
			}//for loop
		}//if remove_check
		else if(function_id.equals("PKG_BILLING")){
			//System.out.println("function_id inside"+function_id);
			String bean_id3		= "PkgEnterReceptRefundBean" ;
			String bean_name3= "eBL.PkgEnterReceptRefundBean";
			PkgEnterReceptRefundBean bean3			= (PkgEnterReceptRefundBean)getBeanObject( bean_id3, bean_name3, request ) ;	
			HashMap  support_data = bean3.getSupportData();		
			HashMap  mult_slmt_vals = new HashMap();
			if(support_data!=null && support_data.size()>0)
			{
			
			String str_tot_rec = (String)support_data.get("str_tot_rec");
			if(str_tot_rec==null) str_tot_rec="0";			
			int tot_rec=Integer.parseInt(str_tot_rec);			

			String str_doc_amt="",str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";
			str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd = (String)support_data.get("str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd");
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd==null) str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd="";						
			if(str_slmt_mode_wise_rcpt_yn_for_rcpt_refnd.equalsIgnoreCase("Y"))
			{
				 mult_slmt_vals = bean3.getMultSlmtVals();	
			}else{
				 mult_slmt_vals = bean3.getSlmtVals();					
			}			
		try{
		
			String str_slmt_type="",str_slmt_doc_ref_desc="",str_slmt_doc_ref_date="",str_slmt_doc_remarks="",str_app_ref_no="",str_cash_slmt_flag="",str_cc_batch_no="",str_cc_sale_draft_no="",str_cc_swipped_yn="",str_bank_code="",str_cash_amt_given="",str_cash_amt_return="",str_payer_name="",str_rcpt_rfnd_id_no="",str_nominee_name="",str_doc_sr_no="",str_bank_branch="",str_slmt_short_desc="",str_bank_name="",str_online_app="";
			ArrayList rtn_str_slmt_doc_amt=new ArrayList();
			ArrayList rtn_str_slmt_type_code=new ArrayList();
			ArrayList rtn_str_slmt_doc_ref_desc=new ArrayList();
			ArrayList rtn_str_slmt_doc_ref_date=new ArrayList();
			ArrayList rtn_str_slmt_doc_remarks=new ArrayList();
			ArrayList rtn_str_app_ref_no=new ArrayList();
			ArrayList rtn_str_cash_slmt_flag=new ArrayList();
			ArrayList rtn_str_cc_batch_no=new ArrayList();
			ArrayList rtn_str_cc_sale_draft_no=new ArrayList();
			ArrayList rtn_str_cc_swipped_yn=new ArrayList();
			ArrayList rtn_str_bank_code=new ArrayList();
			ArrayList rtn_str_bank_branch=new ArrayList();
			ArrayList rtn_str_cash_amt_given=new ArrayList();
			ArrayList rtn_str_cash_amt_return=new ArrayList();
			ArrayList rtn_str_payer_name=new ArrayList();
			ArrayList rtn_str_rcpt_rfnd_id_no=new ArrayList();
			ArrayList rtn_str_nominee_name=new ArrayList();
			ArrayList rtn_str_doc_sr_no=new ArrayList();
			ArrayList rtn_str_online_app=new ArrayList();

			ArrayList rtn_str_slmt_short_desc=new ArrayList();
			ArrayList rtn_str_bank_name=new ArrayList();

			rtn_str_slmt_doc_amt = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_amt");
			rtn_str_slmt_type_code = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_type_code");
			rtn_str_slmt_doc_ref_date = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_date");
			rtn_str_slmt_doc_ref_desc = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_ref_desc");
			rtn_str_slmt_doc_remarks = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_doc_remarks");
			rtn_str_app_ref_no = (ArrayList)mult_slmt_vals.get("rtn_str_app_ref_no");
			rtn_str_cash_slmt_flag = (ArrayList)mult_slmt_vals.get("rtn_str_cash_slmt_flag");
			rtn_str_cc_batch_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_batch_no");
			rtn_str_cc_sale_draft_no = (ArrayList)mult_slmt_vals.get("rtn_str_cc_sale_draft_no");			
			rtn_str_cc_swipped_yn = (ArrayList)mult_slmt_vals.get("rtn_str_cc_swipped_yn");
			rtn_str_bank_code = (ArrayList)mult_slmt_vals.get("rtn_str_bank_code");
			rtn_str_bank_branch = (ArrayList)mult_slmt_vals.get("rtn_str_bank_branch");
			rtn_str_cash_amt_given = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_given");
			rtn_str_cash_amt_return = (ArrayList)mult_slmt_vals.get("rtn_str_cash_amt_return");
			rtn_str_payer_name = (ArrayList)mult_slmt_vals.get("rtn_str_payer_name");
			rtn_str_rcpt_rfnd_id_no = (ArrayList)mult_slmt_vals.get("rtn_str_rcpt_rfnd_id_no");
			rtn_str_nominee_name = (ArrayList)mult_slmt_vals.get("rtn_str_nominee_name");
			rtn_str_doc_sr_no = (ArrayList)mult_slmt_vals.get("rtn_str_doc_sr_no");		

			rtn_str_slmt_short_desc = (ArrayList)mult_slmt_vals.get("rtn_str_slmt_short_desc");		
			rtn_str_bank_name = (ArrayList)mult_slmt_vals.get("rtn_str_bank_name");		
			rtn_str_online_app = (ArrayList)mult_slmt_vals.get("rtn_str_online_app");		
			
			for(int i=0;i<tot_rec;i++)
			{
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}				 
				 str_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
		    	 str_doc_amt=str_doc_amt.substring(0,str_doc_amt.length()-1);				 
				 str_slmt_type=(String)rtn_str_slmt_type_code.get(i);
		    	 str_slmt_type=str_slmt_type.substring(0,str_slmt_type.length()-1);
				 str_doc_amt=(String)rtn_str_slmt_doc_amt.get(i);
		    	 str_doc_amt=str_doc_amt.substring(0,str_doc_amt.length()-1);
				 str_slmt_doc_ref_desc=(String)rtn_str_slmt_doc_ref_desc.get(i);
		    	 str_slmt_doc_ref_desc=str_slmt_doc_ref_desc.substring(0,str_slmt_doc_ref_desc.length()-1);
				 str_slmt_doc_ref_date=(String)rtn_str_slmt_doc_ref_date.get(i);
		    	 str_slmt_doc_ref_date=str_slmt_doc_ref_date.substring(0,str_slmt_doc_ref_date.length()-1);
				 str_slmt_doc_remarks=(String)rtn_str_slmt_doc_remarks.get(i);
		    	 str_slmt_doc_remarks=str_slmt_doc_remarks.substring(0,str_slmt_doc_remarks.length()-1);
				 str_app_ref_no=(String)rtn_str_app_ref_no.get(i);
		    	 str_app_ref_no=str_app_ref_no.substring(0,str_app_ref_no.length()-1);
				 str_cash_slmt_flag=(String)rtn_str_cash_slmt_flag.get(i);
		    	 str_cash_slmt_flag=str_cash_slmt_flag.substring(0,str_cash_slmt_flag.length()-1);	
				 str_cc_batch_no=(String)rtn_str_cc_batch_no.get(i);
		    	 str_cc_batch_no=str_cc_batch_no.substring(0,str_cc_batch_no.length()-1);				 
				 str_cc_sale_draft_no=(String)rtn_str_cc_sale_draft_no.get(i);
		    	 str_cc_sale_draft_no=str_cc_sale_draft_no.substring(0,str_cc_sale_draft_no.length()-1);				 
				 str_cc_swipped_yn=(String)rtn_str_cc_swipped_yn.get(i);
		    	 str_cc_swipped_yn=str_cc_swipped_yn.substring(0,str_cc_swipped_yn.length()-1);				 
				 str_bank_code=(String)rtn_str_bank_code.get(i);
		    	 str_bank_code=str_bank_code.substring(0,str_bank_code.length()-1);				 
				 str_cash_amt_given=(String)rtn_str_cash_amt_given.get(i);
		    	 str_cash_amt_given=str_cash_amt_given.substring(0,str_cash_amt_given.length()-1);				 
				 str_cash_amt_return=(String)rtn_str_cash_amt_return.get(i);
		    	 str_cash_amt_return=str_cash_amt_return.substring(0,str_cash_amt_return.length()-1);				 
				 str_payer_name=(String)rtn_str_payer_name.get(i);
		    	 str_payer_name=str_payer_name.substring(0,str_payer_name.length()-1);				 
				 str_rcpt_rfnd_id_no=(String)rtn_str_rcpt_rfnd_id_no.get(i);
		    	 str_rcpt_rfnd_id_no=str_rcpt_rfnd_id_no.substring(0,str_rcpt_rfnd_id_no.length()-1);				 
				 str_nominee_name=(String)rtn_str_nominee_name.get(i);
		    	 str_nominee_name=str_nominee_name.substring(0,str_nominee_name.length()-1);				 
				 str_doc_sr_no=(String)rtn_str_doc_sr_no.get(i);
		    	 str_doc_sr_no=str_doc_sr_no.substring(0,str_doc_sr_no.length()-1);				 
				  str_bank_branch=(String)rtn_str_bank_branch.get(i);
		    	 str_bank_branch=str_bank_branch.substring(0,str_bank_branch.length()-1);				 
				 String slmt_code_flag=str_slmt_type+str_cash_slmt_flag;
				 str_slmt_short_desc=(String)rtn_str_slmt_short_desc.get(i);				  
		    	 str_slmt_short_desc=str_slmt_short_desc.substring(0,str_slmt_short_desc.length()-1);
				 str_bank_name=(String)rtn_str_bank_name.get(i);				
				 str_bank_name=str_bank_name.substring(0,str_bank_name.length()-1);			
				 str_online_app=(String)rtn_str_online_app.get(i);				
				 str_online_app=str_online_app.substring(0,str_online_app.length()-1);	
				 

            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(str_doc_amt));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(str_slmt_short_desc));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(slmt_code_flag));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_cash_amt_given));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(str_cash_amt_return));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(str_slmt_doc_ref_desc));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str_slmt_doc_ref_date));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(str_bank_name));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(str_bank_branch));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(str_bank_code));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str_cc_batch_no));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str_app_ref_no));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(str_cc_sale_draft_no));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(str_payer_name));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(str_rcpt_rfnd_id_no));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(str_online_app));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(str_online_app));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block173Bytes, _wl_block173);
				 //totalRecords=i;		


			}
			totalRecords=tot_rec;
			}catch(Exception ss)
				{
				System.out.println("Error in PkgEnterReceptRefundBean call :"+ss);
				ss.printStackTrace();
				}

		}	
		}
		else
		{
			for(int i=0;i<totalRecords;i++)
			{	
				if(i % 2 == 0 )
				{
					classval	=	"QRYEVEN";
				}
				else
				{
					classval	=	"QRYODD";
				}


            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(i));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(i));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(i));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(i));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(i));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(i));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(i));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(i));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(i));
            _bw.write(_wl_block185Bytes, _wl_block185);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(i));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block186Bytes, _wl_block186);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block187Bytes, _wl_block187);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block188Bytes, _wl_block188);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(i));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block189Bytes, _wl_block189);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block190Bytes, _wl_block190);
            out.print( String.valueOf(i));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block191Bytes, _wl_block191);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block192Bytes, _wl_block192);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block193Bytes, _wl_block193);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block194Bytes, _wl_block194);
            out.print( String.valueOf(i));
            _bw.write(_wl_block195Bytes, _wl_block195);

		
//	 i++;
			 totalRecords=i;		
			}
		}
	}finally
	{
		session.removeAttribute("existing_records_array");

		if(con!=null) {
					ConnectionManager.returnConnection(con, request);
								  }
	}


            _bw.write(_wl_block196Bytes, _wl_block196);
            out.print( String.valueOf(totalRecords));
            _bw.write(_wl_block197Bytes, _wl_block197);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block198Bytes, _wl_block198);
            out.print( String.valueOf(noofdecimal));
            _bw.write(_wl_block199Bytes, _wl_block199);
            out.print( String.valueOf(cc_terminal_id_enable));
            _bw.write(_wl_block200Bytes, _wl_block200);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block201Bytes, _wl_block201);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block202Bytes, _wl_block202);
            out.print( String.valueOf(visit_id));
            _bw.write(_wl_block203Bytes, _wl_block203);
            out.print( String.valueOf(cash_counter_code));
            _bw.write(_wl_block204Bytes, _wl_block204);
            out.print( String.valueOf(querystring));
            _bw.write(_wl_block205Bytes, _wl_block205);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PaymentDetails.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AMT_COLL.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SettlementType.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.AMOUNT_REND.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_GIVEN.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CASH_RETURNED.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHQ_CARD_BANK_NO_OTH.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CHQ_CARD_BANK_NO.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.CREDIT_CARD_CO.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BANK_NAME.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BRANCH_NAME.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BatchNo.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.APPROVAL_CODE.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.SALE_DRAFT_NO.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.TID_NO.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_NAME.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_DEP_REF_NO.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.ONLINE_APPROVAL.label", java.lang.String .class,"key"));
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
}
