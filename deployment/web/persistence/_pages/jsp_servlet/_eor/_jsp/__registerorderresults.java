package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __registerorderresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/RegisterOrderResults.jsp", 1743590404992L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------------------------\nDate\t\tEdit History\tName\t\tRev.Date\tRev.Name\tDescription\n--------------------------------------------------------------------------------------------------------------------------------\n15/12/2017\tIN065942\t\tDinesh T\t15/12/2017\tRamesh G\tIn Nuclear medicine  department we required the \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tbarcode functionality at the time of \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tRegistration of order,required patient \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tId,patient name,age,sex,register date and name \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\tof study.\n23/04/2020\tIN071618\t    Nijitha S\t \t\t\t\t\t\tPMG2019-MMS-CRF-0004\n--------------------------------------------------------------------------------------------------------------------------------\n*/\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!---->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script><!-- used for date validation-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/RegisterOrder.js\"></script>\n \t<script language=\"JavaScript\" src=\"../js/OrCommonFunction.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t<!-- <style>\n\t*\n\t{\n\t\tmargin :0;\n\t\tpadding : 0;\n\t}\n\t</style> -->\n \t<Script>\n \tfunction dummy(){\n\t}\n\n\tfunction hideToolTip(obj,imgObj,row)\t\n\t{\n\t\tdynamichide(obj, window.event,row);\n\t /*document.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n\t  if (obj != null)\n\t  {\n\t\t\tobj.className = \'gridDataBlue\';\n\t\t\teval(\"document.all.\"+imgObj).src = \"../../eCommon/images/inactiveArrow.gif\";\n\t  }*/\n\t}\n\n\n\tfunction callMouseOver(obj)\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = \'contextMenuItem\';\n\t}\t\n\n\tfunction resizeWindow(orderctlHDR)\n\t{\n\t    var orderctlHDR1 = orderctlHDR.id;\n\n\t\t/*var wdth = eval(\"document.all.\"+orderctlHDR1).offsetWidth;\n\t\tvar hght1 = eval(\"document.all.\"+orderctlHDR1).offsetHeight;*/\n\n\t\tvar element = document.getElementById(orderctlHDR1);\n\t\tvar wdth = element.offsetWidth;\n\t\tvar hght1 = element.offsetHeight;\t\t\n\t\t\n\t\tvar wdth1 = getPos(orderctlHDR).x +wdth;\n\t\tvar hght = getPos(orderctlHDR).y ;\t\n\n\t\tbodwidth  = document.body.offsetWidth\n\t\tbodheight = document.body.offsetHeight\n\t\n\t\tvar z = bodwidth- (event.x + wdth);\t\n\t\t\n\t\tvar x \t  = event.x;\n\t\tvar y \t  = event.y;\t\n\n\t\tx \t  = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\t\ty \t  = hght + (document.getElementById(\"tooltiplayer\").offsetHeight);\t\n\n\t\tif(x<bodwidth){\n\t\t\tx= wdth1;\t\t\t\n\t\t}else{\t\t\t\n\t\t\tx = getPos(orderctlHDR).x;\n\t\t}\n\t\tif(y<bodheight){\t\t\t\n\t\t\ty = hght;\n\t\t\t\n\t\t}else\n\t\t{\n\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2) + hght1 ;\t\n\t\t}\n\t\n\t\tdocument.getElementById(\"tooltiplayer\").style.left= x+\"px\";\n\t\tdocument.getElementById(\"tooltiplayer\").style.top = y+\"px\";\n\t\tdocument.getElementById(\"tooltiplayer\").style.background=\'grey\';\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\';\n\t}\n\n\tfunction displayToolTip(val,ord_cat,val1,orderId,patient_id,sex,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,source_type,source_code,dob,orderctlHDR,imgObj) {\n\t\t\tcallMouseOverOnTD(orderctlHDR,imgObj)\n\n\t\t  \tbuildTable (val,ord_cat,val1,orderId,patient_id,sex,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,source_type,source_code,dob)\n\t\t\tresizeWindow(orderctlHDR)\n\n\t}\n\n\tfunction buildTable(val,ord_cat,val1,orderId,patient_id,sex,order_line_num,performing_facility,performing_location_type,performing_location,encounter_id,int_or_ext,priority,patient_class,order_type_code,source_type,source_code,dob) {\n\n//\t\talert(val);\n//\t\talert(val1);\n        var rowval   = val.split (\",\");\n\t\tvar row      = (\"View,ChangePerformLocn,SentOut,ReceiveResult,\");\n\t\trowval1      = row.split(\",\");\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n\t\tfor( var i=0; i<rowval.length; i++ ) {\n\t\t\tvar colval  = rowval[i]\n\n\t\t\tvar colval1 = rowval1[i];\n\t\tif (colval != \"\")\n\t\t{\n\t\t\n\t\t\ttab_dat = tab_dat+\"<tr>\"\n\t\t\ttab_dat=tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions(\'\"+colval1+\"\',\'\"+ord_cat+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+encounter_id+\"\',\'\"+int_or_ext+\"\',\'\"+priority+\"\',\'\"+patient_class+\"\',\'\"+order_type_code+\"\',\'\"+source_type+\"\',\'\"+source_code+\"\',\'\"+dob+\"\')>\"+colval+\" </a></td>\"\n\t\t\ttab_dat=tab_dat+ \"</tr> \"\n\t\t}\n\t\t}\n\t\t\ttab_dat=tab_dat+ \"</table> \"\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat\n\t}\n</Script>\n    <!-- <STYLE TYPE=\"text/css\">\n       \tA:link\n       \t {\n       \t     COLOR: blue;\n       \t }\n     \tA:visited\n     \t {\n             COLOR: blue ;\n         }\n        A:active\n         {\n             COLOR: red;\n         }\n       \n\n  \t</STYLE> -->\n</head>\n<body  onScroll=\"processScroll()\" onload=\'FocusFirstElement()\'  onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t<script>\n\t\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"))\n\t\t\tparent.RegisterOrderSearch.document.register_order_search.search_btn.disabled = false;\n\t\t\t//parent.RegisterOrderHeader.location.href = \"../../eCommon/html/blank.html\"\n\t\t\tparent.RegisterOrderResult.location.href = \"../../eCommon/html/blank.html\"\n\t\t\tparent.RegisterOrderBtn.location.href = \"../../eCommon/html/blank.html\"\n\t\t</script>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\'register_order_dtl\' id=\'register_order_dtl\'  action=\"../../eOR/jsp/RegisterOrderResults.jsp\" method=\"post\">\n<div id=\"divHeadSep\" >\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" height=\"\" id=\"tableresult\" class=\"grid\">\n<tr id=\"heading\">\n\t\t\n\t\t<th class=columnheader width=\'\' nowrap align=\'left\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th> \n\t\t<th class=columnheader width=\'\' nowrap align=\'left\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t<th class=columnheader width=\'\' nowrap align=\'left\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</th>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<th class=columnheader width=\'\' nowrap align=\'left\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t</tr>\n\t\t\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\n\t\t\t\t\t<tr  align=\"right\">\n\t\t\t\t\t\t<td colspan=\"8\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="   \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\t\t\t\t\t \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="  \n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\n\t\t\t    ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<!-- <tr>\n\t\t\t<th colspan=7 align=left> <font size=1>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font></th>\n\t\t</tr> -->\n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\n\t\t<tr>\n\t\t\t<!-- <td width=\'15%\' class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'> <font size=1>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font></td> -->\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' nowrap>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</td>\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t<input type=hidden name=\'ord_id";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'ord_id";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n\t\t\t<input type=hidden name=\'view_by";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' id=\'view_by";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\" nowrap>  </td>\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' nowrap> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<td width=\'\' nowrap  id=\'orderctl";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' class=\'gridDataBlue\' style = \'cursor:pointer\' onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\')\"   onMouseOver=\"hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\')\"> ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\n\n\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<img align=\'right\' src=\"../../eCommon/images/inactiveArrow.gif\" name=\"imgArrow";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\" id=\"imgArrow";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\">\n\t\t\t</td>\n            ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n\n\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 =" </td>\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<td width=\'\' class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'><input type=checkbox name=\'chk";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\' id=\'chk";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' onClick=\"chkSentOut(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\')\"></td><td class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' width=\'\' nowrap></td>\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' width=\'\' id=\'status";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'nowrap><input type=checkbox name=\'chk";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'  ";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 =" onClick=\"chkUnbilled(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\')\"></td><!-- Modified for //IN071618  -->\n\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' width=\"\" nowrap><a class=\"gridLink\"  href=\"javascript:callBilling(\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\')\" title=\'Charge Details\'> <!--";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="-->";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</a></td>\n\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' width=\"\" nowrap>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t<input type=hidden name=\"ord_consent_status";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" id=\"ord_consent_status";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" value=\"";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\">\n\t\t\t\t<input type=hidden name=\"order_set_id";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" id=\"order_set_id";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\">\n\t\t\t\t<input type=hidden name=\"order_category";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" id=\"order_category";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\"><!--IN065942-->\n\t\t\t\t<input type=hidden name=\"prn_reg_ord";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" id=\"prn_reg_ord";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\"><!--IN065942-->\n\t\t\t\t<input type=\"hidden\" name=\"split_unbilled_order_yn";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" id=\"split_unbilled_order_yn";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\"><!-- IN071618  -->\n\t\t</tr>\n";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n</table>\n</div>\n";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\n<input type=hidden name=\'total_recs\' id=\'total_recs\' value=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\'>\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n<input type=\"hidden\" name=\"practitioner_id\" id=\"practitioner_id\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n<input type=\"hidden\" name=\"function_id\" id=\"function_id\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n<input type=\"hidden\" name=\"view_by\" id=\"view_by\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n<input type=\"hidden\" name=\"ord_cat\" id=\"ord_cat\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n<input type=\"hidden\" name=\"single_multi\" id=\"single_multi\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n<input type=\"hidden\" name=\"ord_type\" id=\"ord_type\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n<input type=\"hidden\" name=\"priority\" id=\"priority\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n<input type=\"hidden\" name=\"location_type\" id=\"location_type\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n<input type=\"hidden\" name=\"locn\" id=\"locn\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n<input type=\"hidden\" name=\"patientId\" id=\"patientId\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n<input type=\"hidden\" name=\"encntr_id\" id=\"encntr_id\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n<input type=\"hidden\" name=\"order_no\" id=\"order_no\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n<input type=\"hidden\" name=\"date_from\" id=\"date_from\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n<input type=\"hidden\" name=\"date_to\" id=\"date_to\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n <input type=\"hidden\" name=\"performing_location_code\" id=\"performing_location_code\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n<input type=\"hidden\" name=\"int_or_ext\" id=\"int_or_ext\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n<input type=\"hidden\" name=\"specimen_no\" id=\"specimen_no\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n<input type=\"hidden\" name=\"activity_type\" id=\"activity_type\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n<input type=\"hidden\" name=\"login_value\" id=\"login_value\" value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n<input type=\"hidden\" name=\"pract_type\" id=\"pract_type\" value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\"><!--IN065942-->\n  \n <!-- For Next & previous -->\n<input type=\'hidden\' name=\'from\' id=\'from\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n<input type=\'hidden\' name=\'to\' id=\'to\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n<!-- IN071618 Starts -->\n\n<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n<input type=\"hidden\" name=\"called_from\" id=\"called_from\" value=\"\">\n<!-- IN071618 Ends -->\n <!-- For Next & previous -->\n <script>\n\t\t\t//if(parent.RegisterOrderHeader.document.getElementById(\"tableheader\")==null)\n\t\t\t//{\n\t\t\t\t//setTimeout(\"alignHeading();\",300);\n\t\t\t//}\n\t\t\t//else \n\t\t\t\t//alignHeading();\n\t\t\t</script>\n\n</form>\n\t\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:15%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n</body>\n<script>parent.RegisterOrderSearch.document.register_order_search.search_btn.disabled = false;</script>\n</html>\n";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );
	
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);


	/* Mandatory checks start */
	String mode	   = "1";//request.getParameter( "mode" ) ;
	String total_query_records  = "0";
	String view_by = request.getParameter( "view_by" ) ;
	String ord_cat = request.getParameter( "ord_cat" ) ;
	String single_multi = request.getParameter( "single_multi" ) ;
	String ord_type = request.getParameter( "ord_type" ) ;
	String priority = request.getParameter( "priority" ) ;
	String location_type = request.getParameter( "location_type" ) ;
	String locn = request.getParameter( "locn" ) ;
	String patientId = request.getParameter( "patientId" ) ;
	String encntr_id = request.getParameter( "encntr_id" ) ;

	String order_no = request.getParameter( "order_no" ) ;
	String date_from = request.getParameter( "date_from" ) ;
	String date_to = request.getParameter( "date_to" ) ;
	String performing_location_code = request.getParameter("performing_location_code");
	String int_or_ext = request.getParameter("int_or_ext");
	String specimen_no = request.getParameter("specimen_no");
	String activity_type = request.getParameter("activity_type")==null?"":request.getParameter("activity_type");
	String login_value = request.getParameter("login_value")==null?"":request.getParameter("login_value");
	String location="";

	view_by = (view_by == null) ? "" : view_by.trim();
	ord_cat = (ord_cat == null) ? "" : ord_cat.trim();
	single_multi = (single_multi == null) ? "" : single_multi.trim();
	ord_type = (ord_type == null) ? "" : ord_type.trim();
	priority = (priority == null) ? "" : priority.trim();
	location_type = (location_type == null) ? "" : location_type.trim();
	locn = (locn == null) ? "" : locn.trim();
	patientId = (patientId == null) ? "" : patientId.trim();
	encntr_id = (encntr_id == null) ? "" : encntr_id.trim();
	order_no = (order_no == null) ? "" : order_no.trim();
	date_from = (date_from == null) ? "" : date_from.trim();
	date_to = (date_to == null) ? "" : date_to.trim();
	performing_location_code = (performing_location_code == null) ? "" : performing_location_code.trim();
	int_or_ext = (int_or_ext == null) ? "" : int_or_ext.trim();
	specimen_no = (specimen_no == null) ? "" : specimen_no.trim();

	/*view_by = view_by.trim();
	ord_cat = ord_cat.trim();
	single_multi = single_multi.trim();
	ord_type = ord_type.trim();
	priority = priority.trim();
	location_type = location_type.trim();
	locn = locn.trim();
	patientId = patientId.trim();
	encntr_id = encntr_id.trim();
	order_no = order_no.trim();
	date_from = date_from.trim();
	date_to = date_to.trim();*/


	//String function_id = request.getParameter( "function_id" ) ;
	String bean_id = "Or_RegisterOrder" ;
	String bean_name = "eOR.RegisterOrder";

	String practitioner_id = (String)session.getValue("ca_practitioner_id");
	String pract_type = (String)session.getValue("practitioner_type");//IN065942
	//String facility_id = (String)session.getValue("facility_id");
	String resp_id = (String)session.getValue("responsibility_id");
	if(resp_id== null)resp_id = "";
	if(practitioner_id == null)practitioner_id = "";

//	out.println(">"+practitioner_id+"<<br>");
//	out.println(">"+resp_id+"<");
	ArrayList allValues = new ArrayList();
/* Mandatory checks end */

	/* Initialize Function specific start */
	RegisterOrder bean = (RegisterOrder)getBeanObject( bean_id, bean_name, request) ;
	bean.setLanguageId(localeName);
	bean.setFunctionId(bean.checkForNull(request.getParameter("function_id")));
	bean.setMode( mode ) ;
	String bill_yn=bean.checkForNull((String)bean.getBillInterfaceYn(),"N");
	//IN071618 Starts
	String split_unbilled_order_yn="N";
	String split_order_site_speci_yn=bean.checkForNull((String)bean.getSpiltUnBilledOrderYN(),"N");
	String order_stage = "";
	String checkyn     = "";
	//IN071618 Ends
	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;

	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start	 = Integer.parseInt(from);
	int end		 = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
  		bean.clear() ;
	//}


	/*if(view_by.equals("H")){
		//out.println("<script>alert('resp_id="+resp_id+",practitioner_id="+practitioner_id+",ord_cat="+ord_cat+"')</script>");
		allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code);
	}else{
		allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code);
	}*/

//	out.println("<script>alert('view_by-"+view_by+"--int_or_ext="+int_or_ext+",specimen_no="+specimen_no+"')</script>");
//	if(from!=null && from.equals("1")) {
  		allValues		= bean.getSearchDetails(view_by,ord_cat,single_multi,ord_type,priority,location_type,locn,patientId,encntr_id,order_no,date_from,date_to,practitioner_id,resp_id,performing_location_code,int_or_ext,specimen_no,activity_type,start,end,login_value);
 		// Setting as a persistence bean
		//bean.setDetails(allValues);
 	//} else {
	//	allValues=bean.getDetails();
  	//}


/* Initialize Function specific end */

	if(allValues.size() == 0)
	{

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
            _bw.write(_wl_block13Bytes, _wl_block13);

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
            _bw.write(_wl_block14Bytes, _wl_block14);

		if(bill_yn.equalsIgnoreCase("Y"))
		{
		
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		
            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block17Bytes, _wl_block17);

	String slClassValue = "";
	String tmp_ord_cat = "";
	String cont_order_ind = "";
	String order_line_num = "";
    String	encounter_dtls="";

	if (view_by.equals("H")) order_line_num = "1";
	int i = 0;

/*	if(allValues.size() < 7 || end > allValues.size()) {
			end = allValues.size();
	}	*/
	//for(int i=0; i<allValues.size(); i++){
		for(int k=0; k<allValues.size(); k++){
		//String[] register_details = new String[15];
		//register_details = (String[])allValues.get(i);
		String[] register_details = (String[])allValues.get(k);
		if(k==0){
			//if(register_details[29] != null)//IN065942
			if(register_details[31] != null)//IN065942//IN071618
				//total_query_records = bean.checkForNull((String)register_details[29],"0");//IN065942
				total_query_records = bean.checkForNull((String)register_details[31],"0");//IN065942//IN071618
			
            _bw.write(_wl_block18Bytes, _wl_block18);

				if((Integer.parseInt(total_query_records)>0) || (start>1))
				{
			
            _bw.write(_wl_block19Bytes, _wl_block19);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("chk")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("register_order_dtl")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block26Bytes, _wl_block26);

				}
			}
		if (view_by.equals("L")) order_line_num = register_details[10];

		
		StringBuffer menu_text = new StringBuffer();

		String sent_out_flag = "";

		StringTokenizer menuTokenizer = new StringTokenizer(register_details[13],"!");

		int count = 0;
		while (menuTokenizer.hasMoreTokens()) {
		  String tempToken = menuTokenizer.nextToken();
		  switch (count) {
		      case 0: if (tempToken.equals("V")) menu_text.append( "'+getLabel('Common.view.label','Common')+'"); break;

              case 1: if (tempToken.equals("C")) menu_text.append( ",'+getLabel('eOR.RedirectOrder.label','OR')+'");
		               else if (tempToken.equals("N")) menu_text.append( ",");break;

              case 2: if (tempToken.equals("N")) menu_text.append(",");
                       else if (tempToken.equals("S")) {menu_text.append( ",'+getLabel('eOR.SendOut.label','OR')+'");sent_out_flag = "S";}
                       else if (tempToken.equals("R")) {menu_text.append( ",,'+getLabel('eOR.ReceiveResult.label','OR')+'");sent_out_flag = "R";}
					   break;

              case 3: if (tempToken.equals("N")) sent_out_flag = "";
                       else if (tempToken.equals("Y") && (sent_out_flag.equals("S"))) sent_out_flag = "S";
					   else if (tempToken.equals("Y") && (sent_out_flag.equals("R"))) sent_out_flag = "R";
					   else sent_out_flag = "";break;
		  }
          count++;

		}
		slClassValue="gridData";
		if(view_by.equals("L")){
			out.println("<input type=hidden name='line_id"+i+"' id='line_id"+i+"' value='"+register_details[10]+"'>");
		}else{
			cont_order_ind = (String)register_details[10];
			out.println("<input type=hidden name='cont_order_ind"+i+"' id='cont_order_ind"+i+"' value='"+cont_order_ind+"'>");
		}

		if(!(tmp_ord_cat.equals(register_details[8]))){
			tmp_ord_cat = (String)register_details[8];
	
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(register_details[9]));
            _bw.write(_wl_block28Bytes, _wl_block28);
}
			//System.out.println("==========="+register_details[12]+"==="+register_details[7]);
			String patientdetails="";
			String sex1;
				sex1="";
				if (register_details[12].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(register_details[12].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
			if((register_details[20]==null) || (register_details[20].equals("")))
			{
				register_details[20]="R";
			}
			if(register_details[20].equalsIgnoreCase("C"))
			{
						location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(register_details[20].equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(register_details[20].equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}

			patientdetails=register_details[7]+","+sex1+"/"+register_details[25]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+register_details[11];
			encounter_dtls=patientdetails+"<br>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+register_details[17]+","+location+"/"+register_details[26];
			if(register_details[4].compareTo("R")==0)
			{
				register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
									
			}
				else if(register_details[4].compareTo("U")==0)
			{
				
				register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
								

			}
				else if(register_details[4].compareTo("S")==0)
			{
			
				register_details[4]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					

			}	
			if(register_details[12]!=null)
			{
				if(register_details[12].compareTo("M")==0){
					register_details[12]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
										
				}
					else if(register_details[12].compareTo("F")==0)
				{
					
					register_details[12]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
									

				}
			}else
				{
					register_details[12]="";
				}
			//IN071618 Starts
			String isDisabled = "";
			String chkColor = slClassValue;
			String  color_billed = slClassValue;

			
			if(!"null".equals(register_details[30]) || !"".equals(register_details[30]))
			{
					StringTokenizer stoken = new StringTokenizer(register_details[30],"!");
				
					while (stoken.hasMoreTokens()) 
					{
					  
					      order_stage = stoken.nextToken();
			          
					  
					      checkyn = stoken.nextToken();
					 
						  split_unbilled_order_yn = stoken.nextToken();
						  color_billed = stoken.nextToken();
					 
					}	
					
					
						if (color_billed.equals("FULLYORPARTIALLYPAID")) {
						  chkColor = "QRY3";
						} 
						if (order_stage.equals("NOTPAID")) {
						  chkColor = "QRY5";
						}
					
					if(checkyn.equals("N") )
					{
						isDisabled = "disabled";
						
					}
				} 
			//IN071618 Ends
		
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(register_details[1]));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(register_details[9]));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(register_details[2]));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(register_details[2]));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(register_details[3],"DMYHM","en",localeName)));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(register_details[4]));
            _bw.write(_wl_block43Bytes, _wl_block43);
            _bw.write(_wl_block18Bytes, _wl_block18);

				if(register_details[6].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])register_details[6].split("!~!");
					String order_detail ="";
					String[] strtitle = null;
					for(int s=0;s<str.length;s++)
					{
						if(str[s].indexOf("$$RD##")!=-1)
						{
							String line_order = (String)str[s];
							strtitle  =line_order.split("::");
							String titleText = "";
							if(strtitle[1].length()>0)
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels")+"\n"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Reason.label","or_labels")+":"+ strtitle[1];
							}
							else
							{
								titleText = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderedFromRadiology.label","or_labels");
							}
							strtitle[0] = "<img src='../../eOR/images/IN_RD_ADD_TEST.gif' title='"+titleText+"'>";
							order_detail = order_detail+strtitle[0]+strtitle[2]+", ";
						}
						else
						{
							order_detail = order_detail+str[s]+", ";
						}
					}
					register_details[6]  = order_detail;
					if(register_details[6].lastIndexOf(",") ==((register_details[6].length())-2))
					{
						register_details[6] = register_details[6] .substring(0,((register_details[6].length())-2));
					}
				}
				if(register_details[6].indexOf("!~!")!=-1)
				{
					register_details[6] = register_details[6].replace("!~!",",");
				}
			
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(i));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(menu_text));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[0]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[1]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[2]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[11]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[12]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[14]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[15]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[16]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[17]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[18]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[5]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[19]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[8]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[20]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[21]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[28]));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(register_details[6]));
            _bw.write(_wl_block50Bytes, _wl_block50);

 			if(register_details[22]!=null && register_details[22].equals("Y")) {
				out.println("<img src=\"../images/Alert.gif\" align=center>");
			} 
		
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
 
				//	System.out.println("==="+register_details[7]);
	/*	if (encounter_dtls.indexOf(",")!=-1){

			StringTokenizer fieldTokenizer = new StringTokenizer(encounter_dtls,",");
			encounter_dtls="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();
		 
		   if ((tempToken.indexOf('/'))==1)
			{
			  String tempstr=tempToken.substring(1);
			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
			encounter_dtls=encounter_dtls.concat(tempToken).concat(",");
			  
         

		}
					 }*/
		
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(encounter_dtls));
            _bw.write(_wl_block56Bytes, _wl_block56);
            _bw.write(_wl_block18Bytes, _wl_block18);
if (sent_out_flag.equals("S") ||  sent_out_flag.equals("R")) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(sent_out_flag));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[0]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[1]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[2]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[11]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[12]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[14]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[15]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[16]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[17]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[18]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[5]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[19]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[8]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[20]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[21]));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(register_details[28]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
} else {
            _bw.write(_wl_block63Bytes, _wl_block63);

			StringBuffer menu_text1 = new StringBuffer();
			menu_text1.append( "'+getLabel('Common.view.label','Common')+'");
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(chkColor));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(i));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(i));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(i));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(isDisabled ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(bean.checkForNull(register_details[2],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[11],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[14],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[17],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[19],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[8],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
	// if(register_details[24] != null && register_details[24].equals("Y")){
            _bw.write(_wl_block18Bytes, _wl_block18);
if(!(register_details[0]).equalsIgnoreCase("PH")&&bill_yn.equalsIgnoreCase("Y"))
			{
			
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[2],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[11],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[14],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[17],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[19],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[12],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[0],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[1],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(order_line_num,"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[16],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[18],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[5],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[8],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[20],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[21],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(menu_text1));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[2],"")));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.checkForNull(register_details[27],"")));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
//}
            _bw.write(_wl_block18Bytes, _wl_block18);
}else if(bill_yn.equalsIgnoreCase("Y"))
				{
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block18Bytes, _wl_block18);
}
			if(register_details[23] ==null ) 
				register_details[23] ="";	

			
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(i));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(register_details[23]));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean.checkForNull(register_details[27],"")));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(i));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean.checkForNull(register_details[0],"")));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(bean.checkForNull(register_details[29],"N")));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(split_unbilled_order_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);

	i++;
	}

            _bw.write(_wl_block89Bytes, _wl_block89);
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(i));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf( bean_name ));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block95Bytes, _wl_block95);
//=bean.getFunctionId()
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(ord_cat));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(single_multi));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(ord_type));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(priority));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(location_type));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(locn));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(patientId));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(encntr_id));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(order_no));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(date_from));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(date_to));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(performing_location_code));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(int_or_ext));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(specimen_no));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(activity_type));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(login_value));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(pract_type));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(from));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(to));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block117Bytes, _wl_block117);

putObjectInBean(bean_id,bean,request);

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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderType.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ordercatalog.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChargeDtls.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.ChargeDtls.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.View/Edit.label", java.lang.String .class,"key"));
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
}
