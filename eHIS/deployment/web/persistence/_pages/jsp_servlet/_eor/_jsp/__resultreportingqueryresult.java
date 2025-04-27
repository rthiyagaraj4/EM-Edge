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
import java.net.URLEncoder;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __resultreportingqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/ResultReportingQueryResult.jsp", 1743590530623L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'/>\n\t\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<!---->\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/dchk.js\"></script>\n\t<!--<script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script>-->\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/ResultReporting.js\"></script>\n \t<script language=\"JavaScript\" src=\"../../eOR/js/OrCommonFunction.js\"></script>\n \t<script src=\'../../eCA/js/CAMenu.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\n\t<script>\n\n\tfunction hideToolTip(obj,imgObj,row)\t\n\t{\n\t\tdynamichide(obj, window.event,row);\n\t  /*document.getElementById(\"tooltiplayer\").style.visibility = \'hidden\'\n\t   if (obj != null)\n\t  {\n\t\t\tobj.className = \'gridDataBlue\';\n\t\t\teval(\"document.all.\"+imgObj).src = \"../../eCommon/images/inactiveArrow.gif\";\n\t  }*/\n\n\t}\n\n\n\tfunction callMouseOver(obj)\t{\n\t\tcurrClass = obj.className ;\n\t\tobj.className = \'selectedcontextMenuItem\';\n\n\t}\n\n\tfunction callOnMouseOut(obj){\n\t\tobj.className = \'contextMenuItem\';\n\t}\n\n\n//aaaa\n\tfunction displayToolTip(val,val1,orderId, encounterId,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performed_only,performing_location_type,performing_location,int_or_ext,sent_out_flag,order_type_code,priority,source_type,source_code,patient_dtls,discr_msr_id,proc_code_scheme,orderctlHDR,imgObj,order_set_id,pat_dob,accssion_num) {\n\n\t\tcallMouseOverOnTD(orderctlHDR,imgObj);\n\n\t  \tbuildTable (val,val1,orderId, encounterId,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performed_only,performing_location_type,performing_location,int_or_ext,sent_out_flag,order_type_code,priority,source_type,source_code,patient_dtls,discr_msr_id,proc_code_scheme,order_set_id,pat_dob,accssion_num);\n\t\t\n\t\tvar orderctlHDR1 = orderctlHDR.id;\n\n\t\t/*var wdth = eval(\"document.all.\"+orderctlHDR1).offsetWidth;\n \t\tvar hght1 = eval(\"document.all.\"+orderctlHDR1).offsetHeight;*/\n\n\t\tvar element = document.getElementById(orderctlHDR1);\n\t\tvar wdth = element.offsetWidth;\n\t\tvar hght1 = element.offsetHeight;\t\t\n\t\t\n\t\tvar wdth1 = getPos(orderctlHDR).x +wdth;\n\t\tvar hght = getPos(orderctlHDR).y ;\n\n\t\tbodwidth  = document.body.offsetWidth\n\t\tbodheight = document.body.offsetHeight\n\t\n\t\tvar z = bodwidth- (event.x + wdth);\t\n\t\t\n\t\tvar x \t  = event.x;\n\t\tvar y \t  = event.y;\t\n\n\t\tx \t  = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\t\ty \t  = hght + (document.getElementById(\"tooltiplayer\").offsetHeight);\t\n\n\t\tif(x<bodwidth){\n\t\t\tx= wdth1;\t\t\t\n\t\t}else{\t\t\t\n\t\t\tx = getPos(orderctlHDR).x;\n\t\t}\n\t\tif(y<bodheight){\t\t\t\n\t\t\ty = hght;\n\t\t\t\n\t\t}else\n\t\t{\n\t\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2) + hght1 ;\t\n\t\t}\n\t\t   y += 100;\n\t\tdocument.getElementById(\"tooltiplayer\").style.Left= x+\"px\";\n\t\tdocument.getElementById(\"tooltiplayer\").style.Top = y+\"px\";\n\t\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\'\n\t\t\n\t}\n\n\tfunction buildTable(val,val1,orderId, encounterId,sex,patient_id,procedure_code,patient_class,ord_cat,order_status,order_line_num,performing_facility,performed_only,performing_location_type,performing_location,int_or_ext,sent_out_flag,order_type_code,priority,source_type,source_code,patient_dtls,discr_msr_id,proc_code_scheme,order_set_id,pat_dob,accssion_num) {\n//Replace/Add\n\n        var rowval   = val.split (\",\");\n\t\tvar nn=0;\n\t\t\n\t\t//var row      = (\"UpdateOrder,UpdateLine,Completion,Notes,Image,ResultEntry,RecordProcedure,Preps,Comments,Instructions,Discontinue,Hold,Resume,Renew,ChangePerformLocn,SentOut,ReceiveResult,Replace,ChangeChargeType\");\n\t\tvar row=new Array();\n\t\tif(val.indexOf(\"View\")==-1)\n\t\t{\n\t\t\t//IN061903 starts\n\t\t\trow      = (\"Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn\");\n\t\t\t//IN061903 ends\t\t\t\n\t\t}\n\t\telse\n\t\t{\n\t\t\t//IN061903 start\n\t\t\t row      = (\"View,Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn\");\n\t\t\t //row      = (\"View,Completion,ResultEntry,RecordProcedure,SentOut,ReceiveResult,LB,Discontinue,Hold,UpdateLine,UpdateOrder,LB,Replace,ChangePerformLocn\");\n\t\t\t//IN061903 ends\n\t\t}\n\t\n\t\trowval1      = row.split(\",\");\n\t\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\"\n \t\tfor( var i=0; i<rowval.length; i++ ) {\n\t\t\tvar colval  = rowval[i];\n\t\t\tvar colval1 = rowval1[i];\n\t\tif (colval != \"\")\n\t\t{\t\t\t\t\n\t\t\t\t\ttab_dat   =  tab_dat+\"<tr>\" ;\n\t\t\t\t\tif(colval1==\"LB\"){\n\t\t\t\t\t\t\tif(colval==\"LINE\")\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\tif(nn>0)\n\t\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\t\ttab_dat    = tab_dat+ \"<td class=\'contextMenuItemSeperator\'  nowrap id=\'mouse\' ><hr class=\'contextMenuItemSeperator\' width=\'88%\' align=center></td>\" ;\n\t\t\t\t\t\t\t\t\tnn=0;\n\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t{\n\t\t\t\t\t\t\t\ttab_dat    = tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'>\"+colval+\" </td>\" ;\n\t\t\t\t\t\t\t\tnn=nn+1;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t\telse\tif (colval1 != \"ChangePerformLocn\" && colval1 != \"SentOut\" && colval1 != \"ReceiveResult\" && (!((sent_out_flag == \'S\' || sent_out_flag == \'R\') && (colval1 == \"ResultEntry\" || colval1 == \"Completion\"))) ||  colval1 == \"Replace\" ||  colval1 == \"ChangeChargeType\" || colval1==\"View\") {\n\t\t\t\t\t\tnn=nn+1;\n\t\t\t\t\t\ttab_dat    =tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+encounterId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+escape(procedure_code)+\"\',\'\"+patient_class+\"\',\'\',\'\"+ord_cat+\"\',\'\"+order_status+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+int_or_ext+\"\',\'\"+sent_out_flag+\"\',\'\"+escape(patient_dtls)+\"\',\'\"+escape(discr_msr_id)+\"\',\'\"+proc_code_scheme+\"\',\'\"+order_type_code+\"\',\'\"+order_set_id+\"\',\'\"+pat_dob+\"\',\'\"+accssion_num+\"\',\'\"+performed_only+\"\');>\"+colval+\" </a></td>\" ;\n\t\t\t\t\t}\n\t\t\t\t\telse {\n\t\t\t\t\t\tnn=nn+1;\n\n\t\t\t\t\t\ttab_dat    = tab_dat+ \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:callPerfMenuFunctions(\'\"+colval1+\"\',\'\"+escape(val1)+\"\',\'\"+orderId+\"\',\'\"+encounterId+\"\',\'\"+sex+\"\',\'\"+patient_id+\"\',\'\"+escape(procedure_code)+\"\',\'\"+patient_class+\"\',\'\"+ord_cat+\"\',\'\"+order_status+\"\',\'\"+order_line_num+\"\',\'\"+performing_facility+\"\',\'\"+performing_location_type+\"\',\'\"+performing_location+\"\',\'\"+int_or_ext+\"\',\'\"+sent_out_flag+\"\',\'\"+priority+\"\',\'\"+order_type_code+\"\',\'\"+source_type+\"\',\'\"+source_code+\"\',\'\"+pat_dob+\"\');>\"+colval+\" </a></td>\" ;\n\t\t\t\t\t}\n\t\t\t\t\ttab_dat     =tab_dat+ \"</tr> \" ;\n\t\t\t}\n\t\t}\n\t\t\ttab_dat     =tab_dat+ \"</table> \";\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat;\n\t}\n\n\t\n\n\tfunction dummy()\n\t{}\n\n\n\t</script>\n      <!--  <STYLE TYPE=\"text/css\">\n       \tA:link\n       \t {\n       \t     COLOR: blue;\n       \t }\n     \tA:visited\n     \t {\n             COLOR: blue ;\n         }\n        A:active\n         {\n             COLOR: red;\n         }         \n\n   </STYLE> -->\n   \n</head>\n\n<body onscroll=\'processScroll()\'  onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<script>\n\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"common\"));\n\tclearValuesfor(); //added by prasad\n\t</script>\n ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<form name=\'result_reporting\' id=\'result_reporting\'  action=\"../../eOR/jsp/ResultReportingQueryResult.jsp\" method=\"post\">\n<div id=\"divHeadSep\" style=\"position: ;\">\n<table cellpadding=3 cellspacing=0 border=1 width=\"100%\" height=\"\" id=\"tableresult\" class=\"grid\">\n<tr id=\"heading\">\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n        <td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t<td class=columnheader width=\'\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n</tr>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\t\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<tr align=\"right\">\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<td colspan=\"6\">\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<td colspan=\"5\">\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t  ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" \n\t\t  ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\t\n\t\t  ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="   \n\t\t  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\t\t\t\t\t \n\t\t  ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="  \n\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="<!--<script>alert(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\');</script>-->";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n        <tr>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n            <td class=columnheader colspan=6> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n            ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n            <td class=columnheader colspan=5> ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\n            ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</td>\n             ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n            ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n           ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</td>\n        \n               ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="            \n            <td class=columnheader colspan=6> ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="            \n            <td class=columnheader colspan=5> ";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\n  \n\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t<tr>\t\t\t\n\t\t\t<td width=\'\' id=\'orderctl";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' class=\'gridDataBlue\' style=\'cursor:pointer\' nowrap  onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\',\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\', \'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\',this,\'imgArrow";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\')\"    onMouseOver=\"hideToolTip(this,\'imgArrow";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\">";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<img align=\'right\' src=\"../../eCommon/images/inactiveArrow.gif\" name=\"imgArrow";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\" id=\"imgArrow";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\" style=\"margin-top: 7px;\"></td>\n          \t<td class=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\' width=\'\' nowrap> ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 =" ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" </td>\n\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' width=\'\' nowrap> <a class=\"gridLink\" href=\'#\' onClick=\"callMenuFunctions(\'View\',\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'\',\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<IMG SRC=\"../images/Alert.gif\" WIDTH=\"27\" HEIGHT=\"36\" BORDER=0 ALT=\"Alert\">";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =" </td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\' width=\'\' wrap>";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</td>\n\t\t\t<!-- 19112 Start.-->\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\t\t\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\n\t\t\t<td width=\'\' nowrap class=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\'>&nbsp;</td>\t\n\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t<!-- 19112 End.-->\n\t\t\t\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" \n\t\t\t<!-- Added BY Arvind --->\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t<br>\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t\t\t <img title=\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\' src=\"../../eCA/images/ForwardNotes.gif\"/>\n\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\' src=\"../../eCA/images/MarkError.gif\"/>\n\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\' src=\"../../eCA/images/modify1.gif\"/>\n\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\t\n\t\t\t</td>\n\t\t\t<input type=\'hidden\' name=\'procedure_code";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\' id=\'procedure_code";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\' value=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'>\n\t\t\t<input type=\'hidden\' name=\'result_type";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' id=\'result_type";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'>\n\t\t\t<input type=\'hidden\' name=\'instrn_type";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' id=\'instrn_type";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\'>\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n</table>\n</div>\n ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\n\t\n\t<input type=\"hidden\" name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\">\n\t<input type=\"hidden\" name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\">\n\t<Input type=\"hidden\" name=\"order_category\" id=\"order_category\" value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\">\n\t<Input type=\"hidden\" name=\"can_location_type\" id=\"can_location_type\" value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\">\n\t<Input type=\"hidden\" name=\"can_location\" id=\"can_location\" value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\">\n\t<Input type=\"hidden\" name=\"can_order_category\" id=\"can_order_category\" value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\">\n\t<Input type=\"hidden\" name=\"can_single_multi\" id=\"can_single_multi\" value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\">\n\t<Input type=\"hidden\" name=\"can_priority\" id=\"can_priority\" value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\">\n\t<Input type=\"hidden\" name=\"can_date_from\" id=\"can_date_from\" value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\">\n\t<Input type=\"hidden\" name=\"can_date_to\" id=\"can_date_to\" value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t<Input type=\"hidden\" name=\"can_patient_id\" id=\"can_patient_id\" value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t<Input type=\"hidden\" name=\"can_order_id\" id=\"can_order_id\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t<Input type=\"hidden\" name=\"can_encounter_id\" id=\"can_encounter_id\" value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t<Input type=\"hidden\" name=\"can_patient_id_found\" id=\"can_patient_id_found\" value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t<Input type=\"hidden\" name=\"can_order_type\" id=\"can_order_type\" value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t<Input type=\"hidden\" name=\"can_performing_location_code\" id=\"can_performing_location_code\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t<Input type=\"hidden\" name=\"can_task_status\" id=\"can_task_status\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t<Input type=\"hidden\" name=\"can_specimen_no\" id=\"can_specimen_no\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t<Input type=\'hidden\' name=\'accession_num\' id=\'accession_num\' value=\'\'>\n\t<input type=\'hidden\' name=\'note_signed\' id=\'note_signed\' value=\'\'>\n\t<input type=\'hidden\' name=\'total_recs\' id=\'total_recs\' value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t<input type=\'hidden\' name=\'patient_id_found\' id=\'patient_id_found\' value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t<input type=\'hidden\' name=\'group_by\' id=\'group_by\' value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t<input type=\'hidden\' name=\'from_ca\' id=\'from_ca\' value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t<input type=\'hidden\' name=\'location\' id=\'location\' value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t<input type=\'hidden\' name=\'single_multi\' id=\'single_multi\' value=\"";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t<input type=\'hidden\' name=\'priority\' id=\'priority\' value=\"";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\">\n\t<input type=\'hidden\' name=\'date_from\' id=\'date_from\' value=\"";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t<input type=\'hidden\' name=\'date_to\' id=\'date_to\' value=\"";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\">\n\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\"";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\">\n\t<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\"";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\">\n\t<input type=\'hidden\' name=\'encounter_id\' id=\'encounter_id\' value=\"";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n   \t<input type=\'hidden\' name=\'order_type\' id=\'order_type\' value=\"";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\">\n   \t<input type=\'hidden\' name=\'performing_location_code\' id=\'performing_location_code\' value=\"";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n   \t<input type=\'hidden\' name=\'view_by\' id=\'view_by\' value=\"";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\">\n  \t<input type=\'hidden\' name=\'specimen_no\' id=\'specimen_no\' value=\"";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n  \t<input type=\'hidden\' name=\'catalog_desc\' id=\'catalog_desc\' value=\"";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\">\n  \t<input type=\'hidden\' name=\'task_status\' id=\'task_status\' value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\n  \t<input type=\'hidden\' name=\'source_type\' id=\'source_type\' value=\"";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\">\n  \t<input type=\'hidden\' name=\'peforming_location_code\' id=\'peforming_location_code\' value=\"";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\">\n  \t<input type=\'hidden\' name=\'source_location\' id=\'source_location\' value=\"";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\">\n  \t<input type=\'hidden\' name=\'search_criteria\' id=\'search_criteria\' value=\"";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\">\n  \t<input type=\'hidden\' name=\'activity_type\' id=\'activity_type\' value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\">\n\n\t<Input type=\"hidden\" name=\"can_catalog_desc\" id=\"can_catalog_desc\" value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\">\n\t<Input type=\"hidden\" name=\"can_search_criteria\" id=\"can_search_criteria\" value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\">\n\t<Input type=\"hidden\" name=\"can_source_location_type\" id=\"can_source_location_type\" value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\">\n\t<Input type=\"hidden\" name=\"can_source_locn\" id=\"can_source_locn\" value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\n\t<Input type=\"hidden\" name=\"can_group_by\" id=\"can_group_by\" value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\">\n\t<input type=\"hidden\" name=\"localeName\" id=\"localeName\" value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\">\n\t<input type=\"hidden\" name=\"performed_only\" id=\"performed_only\" value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\">\n\t<input type=\"hidden\" name=\"period_mod_rslt_completed\" id=\"period_mod_rslt_completed\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t<input type=\"hidden\" name=\"by_24hrs_yn\" id=\"by_24hrs_yn\" value=\"";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\">\n\t<script>\n\t\t\t//if(parent.parent.ResultReportingHeader.document.getElementById(\"tableheader\")==null)\n\t\t\t//{\n\t\t\t\t//setTimeout(\"alignHeading();\",300);\n\t\t\t//}\n\t\t\t//else \n\t\t\t\t//alignHeading();\n\t</script>\n</form>\n<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:15%; left: 227px; top: 40px; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t\t<tr>\n\t\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</div>\n</body>\n<script>\nif(parent.parent.ResultReportingSearch)\nparent.parent.ResultReportingSearch.document.result_reporting_search.search_btn.disabled= false;\nelse \nparent.parent.parent.ResultReportingSearch.document.result_reporting_search.search_btn.disabled= false;\n\t</script>\n</html>\n";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\n\n";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );
	
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



    private boolean compareDate(String from_date,String to_date) {
    try{
        java.text.SimpleDateFormat formatter = new java.text.SimpleDateFormat ("dd/MM/yyyy kk:mm");
		
         // Parse the previous string back into a Date.
         java.text.ParsePosition pos = new java.text.ParsePosition(0);
         java.text.ParsePosition pos1 = new java.text.ParsePosition(0);
         java.util.Date from = formatter.parse(from_date, pos);
         java.util.Date to = formatter.parse(to_date, pos1);
        
         int result = from.compareTo(to);
         if (result > 0) {
            return false;
         } else {
            return true;
         }
    } catch(Exception e) {
        
		e.printStackTrace();	
    }
    return true;
    }


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

/*
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
*/
/*
-----------------------------------------------------------------------
Date       Edit History      Name        		Description
-----------------------------------------------------------------------
?             100            ?           		created
26/06/2012    IN033488      Chowminya G      	Incident No: IN033488 -  Error Marking - Result completed indicator> 
-----------------------------------------------------------------------
------------------------------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History      		Name        		Rev.Date		Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
10/07/2017	IN061903			Krishna Gowtham J 			10/07/2017		Ramesh G		ML-MMOH-CRF-0555		
14/03/2019	IN068778			Selvin M					14/03/2019		Ramesh G		TBMC-CRF-0011
22/08/2020	IN073625			Ramesh Goli				22/08/2020		Ramesh G		OR-PMG2020-TECH-CRF-0001/01-Place Order
16/08/2021	19112			Ramesh												NMC-JD-CRF-0106
------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

   request.setCharacterEncoding("UTF-8");
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);
            _bw.write(_wl_block1Bytes, _wl_block1);

	HashMap Parameters = new HashMap();
	Enumeration paramNames = request.getParameterNames();
	while(paramNames.hasMoreElements())
	{
		String pName = (String)paramNames.nextElement();
		String paramValue = request.getParameter(pName);
		if(paramValue == null)	paramValue = "";
		else paramValue = paramValue.trim();
		Parameters.put(pName, paramValue);
	}
	//19112 Start.
	Connection connection =  null;	
	boolean isSiteSpecificBillStatus = false; 
	try{
		connection = ConnectionManager.getConnection(request); 	
		isSiteSpecificBillStatus = eCommon.Common.CommonBean.isSiteSpecific(connection, "OR","BILL_STATUS_DISPLAY");
	}catch(Exception e){
		out.println("Exception@1: "+e);
	}finally{
		if(connection!=null)	ConnectionManager.returnConnection(connection,request);
	}
	//19112 End.
	/* Mandatory checks start */
	String location="";
	String mode	   				= "1";//request.getParameter( "mode" ) ;
	String function_id 			= request.getParameter( "function_id" ) ;
	String practitioner_id 		= (String)session.getValue("ca_practitioner_id");
	String responsibility_id 	= (String)session.getValue("responsibility_id");
	String facility_id 			= (String)session.getValue("facility_id");
	String practitioner_type 	= (String)session.getValue("practitioner_type");
	String patient_id_found 	= request.getParameter("patient_id_found");
	String order_category 		= request.getParameter("order_category");
 	String group_by             = request.getParameter("group_by");
 	String performing_location_code             = request.getParameter("performing_location_code");
 	//String taskCode             = request.getParameter("taskCode");
	String from_ca              = request.getParameter("from_ca");
	String can_location_type			= request.getParameter("location_type");
	String can_location					= request.getParameter("location");
	String can_order_category			= request.getParameter("order_category");
	String can_single_multi				= request.getParameter("single_multi");
	String can_priority					= request.getParameter("priority");
	String can_date_from				= request.getParameter("date_from");
	String can_date_to					= request.getParameter("date_to");
	String can_patient_id				= request.getParameter("patient_id");
	String can_order_id					= request.getParameter("order_id");
	String can_encounter_id				= request.getParameter("encounter_id");
	String can_patient_id_found			= request.getParameter("patient_id_found");
	String can_order_type				= request.getParameter("order_type");
	String can_performing_location_code = request.getParameter("performing_location_code");
	String can_view_by 					= request.getParameter("view_by");
	//String can_task_status 				= request.getParameter("can_task_status");
	String can_specimen_no				= request.getParameter("specimen_no");
	String can_catalog_desc				= request.getParameter("catalog_desc");
	String can_search_criteria			= request.getParameter("search_criteria");
	String can_task_status 				= request.getParameter("task_status");
	String can_source_location_type		= request.getParameter("source_type");
	String can_source_locn 				= request.getParameter("source_location");
	String can_group_by 				= request.getParameter("group_by");
	String performed_only 				= request.getParameter("performed_only")==null ?"":request.getParameter("performed_only");
	String period_mod_rslt_completed 				= request.getParameter("period_mod_rslt_completed")==null ?"":request.getParameter("period_mod_rslt_completed");
	String by_24hrs_yn 				= request.getParameter("by_24hrs_yn")==null ?"":request.getParameter("by_24hrs_yn");
	String total_query_records			= "0";	
	can_catalog_desc 		= (can_catalog_desc == null) ? "" : can_catalog_desc;
	can_search_criteria 		= (can_search_criteria == null) ? "" : can_search_criteria;
	can_source_location_type 		= (can_source_location_type == null) ? "" : can_source_location_type;
	can_source_locn 		= (can_source_locn == null) ? "" : can_source_locn;
	can_group_by 		= (can_location_type == null) ? "" : can_group_by;
	if(practitioner_id == null)	practitioner_id = "";
	if(responsibility_id == null)	responsibility_id = "";
	if(facility_id == null) facility_id = "";
	if(practitioner_id == null)practitioner_id = "";
	if(order_category == null) order_category = "";
	if (group_by == null) group_by = "";
	if (from_ca == null) from_ca = "";
	if(can_location_type == null) can_location_type = "";
	if(can_location == null) can_location = "";
	if(can_order_category == null) can_order_category = "";
	if(can_single_multi == null) can_single_multi = "";
	if(can_priority == null) can_priority = "";
	if(can_date_from == null) can_date_from = "";
	if(can_date_to == null) can_date_to = "";
	if(can_patient_id == null) can_patient_id = "";
	if(can_order_id == null) can_order_id = "";
	if(can_encounter_id == null) can_encounter_id = "";
	if(can_patient_id_found == null) can_patient_id_found = "";
	if(can_order_type == null) can_order_type = "";
	if(can_performing_location_code == null) can_performing_location_code = "";
	if(can_view_by == null) can_view_by = "";
	if (can_task_status == null) can_task_status = "";
	if (can_specimen_no == null) can_specimen_no = "";
	Parameters.put("practitioner_id", practitioner_id);
	Parameters.put("responsibility_id", responsibility_id);
	Parameters.put("facility_id", facility_id);
	Parameters.put("practitioner_type", practitioner_type);
	Parameters.put("from_ca",from_ca);
	Parameters.put("catalog_desc",can_catalog_desc);
	Parameters.put("search_criteria",can_search_criteria);
	Parameters.put("performing_location_code",performing_location_code);
	Parameters.put("period_mod_rslt_completed",period_mod_rslt_completed);
	Parameters.put("by_24hrs_yn",by_24hrs_yn);
	Parameters.put("pract_reln_id",request.getParameter("pract_reln_id")==null ?"":request.getParameter("pract_reln_id"));
	//Parameters.put("taskCode",taskCode);

	String bean_id = "Or_ResultReporting";//request.getParameter("bean_id");
	String bean_name = "eOR.ResultReportingBean";//request.getParameter("bean_name");

/* Mandatory checks end */

/* Initialize Function specific start */

	ResultReportingBean bean = (ResultReportingBean)getBeanObject( bean_id, bean_name ,request ) ;
	bean.setLanguageId(localeName);
	bean.clear() ;
	bean.setFunctionId(bean.checkForNull(function_id));
	bean.setMode( mode ) ;

	String from	 = bean.checkForNull(request.getParameter( "from" ),"1") ;
	String to	 = bean.checkForNull(request.getParameter( "to" ),"7") ;
 	int start = Integer.parseInt(from);
	int end   = Integer.parseInt(to);
 	//if(from!=null && from.equals("1")) {
 		
	//}
	Parameters.put("start", String.valueOf(start));
	Parameters.put("end",String.valueOf(end));

 /* Initialize Function specific end */
    //String encounter_id = bean.checkForNull((String)Parameters.get("encounter_id"),"");
	ArrayList allValues = new ArrayList();
//	if(from!=null && from.equals("1")){
		allValues = bean.getSearchDetails(Parameters);
// 		bean.setDetails(allValues);
//	}else{
//		allValues=bean.getDetails();
//	}
	//ArrayList arrSysDateTime = bean.getSysDateTime();
	//String sys_date_time = (String)arrSysDateTime.get(2);

	String patient_id = "";
	String sex = "";
	//String[] Result_Type=new String[2];
	String discr_msr_id="";
	//String resultType = "";String discr_msr_id="";
	//String[] Result_Type=new String[2];

	int i = 0;
if( allValues.size() == 0){ 
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
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
            _bw.write(_wl_block14Bytes, _wl_block14);

		//19112 Start.
		if(isSiteSpecificBillStatus){
			
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		//19112 end.
		
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	String slClassValue = "";
	String tmp_ord_cat = "";
	//String temp_menu_text = ""; // temp variable created on 13/04/2007 - Anji Prasad
	
//	if(allValues.size() < 7 || end > allValues.size()) {
//			end = allValues.size();
//	}	

	
	for(int k=0; k<allValues.size(); k++)
	{
		String fontValue 		= "";
		String imageTag 		= "";
		String procedure_code	= "";
		String proc_code_scheme	= "";
		String result_type		= "";
		//String auto_report_yn	= "";
		//String bill_yn	= "";
		//String charge_type_applicable	= "";
		//String[] row_details = new String[18];
		//row_details = (String[])allValues.get(i);
		String[] row_details= (String[])allValues.get(k);
		/*for(int x=0;row_details[x]!="\0";x++)
			*/
		if(row_details[1].compareTo("R")==0){
					row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels");
										
				}
					else if(row_details[1].compareTo("U")==0)
				{
					
					row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels");
									

				}
					else if(row_details[1].compareTo("S")==0)
				{
				
				row_details[1]=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels");
					

				}	
				StringBuffer menuText = new StringBuffer();
				StringBuffer viewmenuText = new StringBuffer();
				StringTokenizer kv=new StringTokenizer(row_details[12],"|");
				int count=kv.countTokens();
				boolean linef=false;
				//boolean lined=false;
				boolean lineg=false;
				int menutext=0;
				String tempTokens="";
				StringBuffer stringtoken=new StringBuffer();
				while (kv.hasMoreTokens()) 
				{
					tempTokens = kv.nextToken();
					if(tempTokens.trim().length()>1)
					{
						String[] values1=row_details[12].split(":");
						proc_code_scheme=values1[1];
						procedure_code=values1[2];
						tempTokens=tempTokens.substring(0,1);
					}
					stringtoken.append(tempTokens);				
					stringtoken.append("|");				
				}
				row_details[12]=stringtoken.toString();
				stringtoken.setLength(0);
				int n=1;
				if(count>1)
				{
					//IN073625 Start.
					//String[] values=row_details[12].split("|");
					String[] values=(row_details[12]).split("\\|");
					//IN073625 Start.
					 menutext=0;
					//for(int m=0;m<count*2;m++)//IN073625
					for(int m=0;m<values.length;m++)//IN073625
					{
						//if(m%2==1) //IN073625
						//{ //IN073625
							if(values[m].equals("Y") || values[m].equals("_"))
							{
								menutext++;
								switch(n)
								{
									//IN061903 start
									/*
									case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;
									case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
									case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;*/
												/*String[] values1=row_details[12].split(":");
												proc_code_scheme=values1[1];
												procedure_code=values1[2];*/
									/*													
									break;
									case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
									case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
									case 6: menuText.append( "LINE,");break;
									case 7:*/ /*if(lineg)
												menuText.append( "LINE,");
												else
												menuText.append( ",");
												linef=true;*/
												/*menuText.append( "'+getLabel('Common.Discontinue.label','COMMON')+',");break;
									case 8: *//*if(!linef && lineg)
												{
													//menuText.append( "LINE,");
													menuText.append( ",");
												}
												else if(!linef && !lineg)
												menuText.append( ",");
												linef=true;*/
												/*menuText.append( "'+getLabel('Common.Hold.label','COMMON')+',");break;
									case 9:*/ /* if(!linef && lineg)
												menuText.append( "LINE,");
												else if(!linef && !lineg)
												menuText.append( ",");
												linef=true;*/
												/*menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
									case 10:*//* if(!linef && lineg)
												{
												menuText.append( "LINE,");
												linef=true;
												}*/
												/*menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
									case 11: menuText.append( "LINE,");break;
									case 12: 
												*//*if(!linef)
												menuText.append(",");
												if(linef || lineg)
												{
												menuText.append( "LINE,");
												lined=true;
												}*/
											/*	menuText.append( "'+getLabel('Common.Replace.label','COMMON')+',");break;
									case 13: */
												/*if(!linef && lineg)
												menuText.append(",");
												if((linef || lineg) && !lined)
												{
												menuText.append( "LINE,");
												lined=true;
												}*/
												/*menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break;
									*/
									
									case 1: menuText.append( "'+getLabel('eOR.OrderCompletion.label','OR')+',");lineg=true;break;
									case 2: menuText.append( "'+getLabel('eOR.ResultEntry.label','OR')+',");lineg=true;break;
									case 3: menuText.append( "'+getLabel('eOR.RecordProcedure.label','OR')+',");lineg=true;break;
									case 4: menuText.append( "'+getLabel('eOR.SentOut.label','OR')+',");lineg=true;break;
									case 5: menuText.append( "'+getLabel('eOR.ReceiveResult.label','OR')+',");lineg=true;break;
									case 6: menuText.append( "LINE,");break;
									case 7: menuText.append( "'+getLabel('Common.Discontinue.label','COMMON')+',");break;
									//case 8: menuText.append( "'+getLabel('Common.NOTDONE.label','COMMON')+',");break;
									case 8: menuText.append( "'+getLabel('Common.Hold.label','COMMON')+',");break;
									case 9: menuText.append( "'+getLabel('eOR.ReviewLineStatus.label','OR')+',");break;
									case 10:menuText.append( "'+getLabel('eOR.ReviewOrderStatus.label','OR')+',");break;
									case 11:menuText.append( "LINE,");break;
									case 12:menuText.append( "'+getLabel('Common.Replace.label','COMMON')+',");break;
									case 13:menuText.append( "'+getLabel('eOR.RedirectOrder.label','OR')+',");break; 
									//IN061903 ENDS										
									
									default: if(!linef)
												menuText.append(",");
												
			
								}
							}
							else
								menuText.append(",");						
							n++;
						//} //IN073625

					}
				 }
				 if(menutext==2)
				 {
					 viewmenuText.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels"));
					 viewmenuText.append(","+menuText);
					 menuText.setLength(0);
					 menuText.append(viewmenuText);
				 }
				String sex1;
				sex1="";
				if (row_details[14].equalsIgnoreCase("M"))
				  sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
			  else if(row_details[14].equalsIgnoreCase("F"))
			sex1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");

			if(row_details[18].equalsIgnoreCase("C"))
			{
						location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			}
			else if(row_details[18].equalsIgnoreCase("N"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
			}else if(row_details[18].equalsIgnoreCase("R"))
			{
				location=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels");
			}
			row_details[3]=row_details[3]+","+sex1+"/"+row_details[25]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ID:.label","or_labels")+row_details[11]+","+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Encounter Dtls:.label","or_labels")+row_details[16]+","+location+"/"+row_details[13]+",";
		/*	 if (row_details[3].indexOf(",")!=-1){
			StringTokenizer fieldTokenizer = new StringTokenizer(row_details[3],",");
			row_details[3]="";
		
		while (fieldTokenizer.hasMoreTokens()) {
		  String tempToken = fieldTokenizer.nextToken();


		  if ((tempToken.indexOf('/'))==2)
			{
			  String tempstr=tempToken.substring(2);

			  if (tempToken.charAt(0)=='M')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels")).concat(tempstr);
			  else if(tempToken.charAt(0)=='F')
				  tempToken=(" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels")).concat(tempstr);
			}
		row_details[3]=row_details[3].concat(tempToken).concat(",");
		}
			 }*/

		for (int index = 0;index < row_details.length;index++) 
		{
		  if (row_details[index] == null)  row_details[index] = "";
		}

		if(k==0) 
		{ 

		// Header
			if(row_details[36] != null)
				total_query_records = bean.checkForNull((String)row_details[36],"0");
	

            _bw.write(_wl_block18Bytes, _wl_block18);
if((Integer.parseInt(total_query_records)>0) || (start>1)){
            _bw.write(_wl_block19Bytes, _wl_block19);
if(isSiteSpecificBillStatus){
            _bw.write(_wl_block20Bytes, _wl_block20);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);
            {java.lang.String __page ="ResultScrolling.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("flush"), weblogic.utils.StringUtils.valueOf("true")},{ weblogic.utils.StringUtils.valueOf("from"), weblogic.utils.StringUtils.valueOf(start
                        )},{ weblogic.utils.StringUtils.valueOf("to"), weblogic.utils.StringUtils.valueOf(end
                        )},{ weblogic.utils.StringUtils.valueOf("total_size"), weblogic.utils.StringUtils.valueOf(total_query_records
                        )},{ weblogic.utils.StringUtils.valueOf("check_box_name"), weblogic.utils.StringUtils.valueOf("")},{ weblogic.utils.StringUtils.valueOf("form_name"), weblogic.utils.StringUtils.valueOf("result_reporting")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block1Bytes, _wl_block1);
		}  

		
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block31Bytes, _wl_block31);


		//String visit_adm_date = "";//bean.getVisAdmDate(facility_id,row_details[16]);	    
		patient_id = row_details[11];

		//if(row_details[5].trim().equalsIgnoreCase("PH") && !(can_order_type.equals("TDM")) && !(can_order_type.equals("PDC")))
		//	row_details[12] = "C";
		


		//if(row_details[5].trim().equalsIgnoreCase("PH") && !(row_details[7].equals("TDM")) && !(row_details[7].equals("PDC")))
		   //row_details[12] = "C";
        //row_details[12] = "Y";
		
 
		String grpCheckValue = "";
		if (group_by.equals("P")) {
		  grpCheckValue = (String)row_details[11];
		} else if (group_by.equals("") || group_by.equals("D")) {
		  grpCheckValue = (String)row_details[17];
		} else if (group_by.equals("C")) {
		  grpCheckValue = (String)row_details[5];
		}  else if (group_by.equals("T")) {
		  grpCheckValue = (String)row_details[7];
		}   else if (group_by.equals("L")) {
		  grpCheckValue = (String)row_details[18]+"/"+(String)row_details[13];
		}  else if (group_by.equals("U")) {
		  grpCheckValue = (String)row_details[1];
		}  else if (group_by.equals("O")) {
		  grpCheckValue = (String)row_details[2];
		}
		String result_applicable_yn = "";
		String complete_remarks 	= "";
		String complete_date_time 	= "";
		//StringBuffer menu_text = new StringBuffer();
		//String replace_text			= "";
		String sent_out_flag 		= "";
		String order_line_num 		= bean.checkForNull((String)row_details[37],"");

		  //order_line_num		= "1";
		  result_applicable_yn = (String)row_details[20];
		  complete_remarks = (String)row_details[21];
		  complete_date_time = bean.checkForNull((String)row_details[27],"");



			/*StringTokenizer menuTokenizer = new StringTokenizer(row_details[28],"!");
			int count = 0;
			while (menuTokenizer.hasMoreTokens()) {
			  String tempToken = menuTokenizer.nextToken();
			  switch (count) {

			      case 1: if (tempToken.equals("C")) menu_text .append(",Redirect Order");
			               else if (tempToken.equals("N")) menu_text.append(",");break;

			      case 2: if (tempToken.equals("N")) menu_text.append(",");
			               else if (tempToken.equals("S")) {menu_text.append(",Send Out");sent_out_flag = "S";}
			               else if (tempToken.equals("R")) {menu_text.append(",,Receive Results");sent_out_flag = "R";}
						   break;

			      case 3: if (tempToken.equals("N")) sent_out_flag = "";
			               else if (tempToken.equals("Y") && (sent_out_flag.equals("S"))) sent_out_flag = "S";
						   else if (tempToken.equals("Y") && (sent_out_flag.equals("R"))) sent_out_flag = "R";
						   else sent_out_flag = "";break;
			  }
			  count++;

			}*/
	

		/*StringTokenizer replaceTokenizer = new StringTokenizer(menu_text.toString(),",");
		String tempReplaceToken="";

		if(replaceTokenizer.countTokens()==0)
			replace_text=",,'+getLabel('eOR.Replace.label','OR')+'";
		else if(replaceTokenizer.countTokens()==1){
			tempReplaceToken = replaceTokenizer.nextToken();
			if(tempReplaceToken.equals("Redirect Order") )
				replace_text=",'+getLabel('eOR.Replace.label','OR')+'";
			else if(tempReplaceToken.equals("Send Out"))
				replace_text=",'+getLabel('eOR.Replace.label','OR')+'";
			else if(tempReplaceToken.equals("Receive Results"))
				replace_text="'+getLabel('eOR.Replace.label','OR')+'";
		}else if(replaceTokenizer.countTokens()==2){
			replaceTokenizer.nextToken();
			tempReplaceToken = replaceTokenizer.nextToken();
			if(tempReplaceToken.equals("Send Out"))
				replace_text=",'+getLabel('eOR.Replace.label','OR')+'";
			else if(tempReplaceToken.equals("Receive Results"))
				replace_text="'+getLabel('eOR.Replace.label','OR')+'";
		
		}*/
		
 		//if (result_applicable_yn.equals("Y") || (result_applicable_yn.equals("N") && complete_date_time.equals(""))) {
			/*if(i % 2 == 0){
				slClassValue = "QRYEVEN";
			}
			else{
				slClassValue = "QRYODD";
			}*/
			slClassValue="gridData";
          if(!(tmp_ord_cat.equals(grpCheckValue)))
		{
			

		
            _bw.write(_wl_block32Bytes, _wl_block32);
            _bw.write(_wl_block33Bytes, _wl_block33);
if ((group_by.equals("") || group_by.equals("D"))&& isSiteSpecificBillStatus) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(row_details[17],"DMY","en",localeName)));
            _bw.write(_wl_block35Bytes, _wl_block35);
tmp_ord_cat = (String)row_details[17];
            }else if (group_by.equals("") || group_by.equals("D")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(row_details[17],"DMY","en",localeName)));
            _bw.write(_wl_block35Bytes, _wl_block35);
tmp_ord_cat = (String)row_details[17];
            }
            _bw.write(_wl_block37Bytes, _wl_block37);
if (group_by.equals("P") && isSiteSpecificBillStatus) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_details[3]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[11];
            }else if (group_by.equals("P")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[3]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[11];
            }
            _bw.write(_wl_block37Bytes, _wl_block37);
if (group_by.equals("C") && isSiteSpecificBillStatus) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[5];
            }else if (group_by.equals("C")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[5];
            }
            _bw.write(_wl_block39Bytes, _wl_block39);
if (group_by.equals("T") && isSiteSpecificBillStatus) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_details[8]));
            _bw.write(_wl_block40Bytes, _wl_block40);
tmp_ord_cat = (String)row_details[7];
            }else if (group_by.equals("T")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[8]));
            _bw.write(_wl_block40Bytes, _wl_block40);
tmp_ord_cat = (String)row_details[7];
            }
            _bw.write(_wl_block39Bytes, _wl_block39);
if (group_by.equals("L") && isSiteSpecificBillStatus) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((((String)row_details[18]).equals("") && ((String)row_details[19]).equals(""))? "Others" : location + "/" + (String)row_details[13]));
            _bw.write(_wl_block41Bytes, _wl_block41);
 tmp_ord_cat = (String)row_details[18]+"/"+(String)row_details[13];
            }else if (group_by.equals("L")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf((((String)row_details[18]).equals("") && ((String)row_details[19]).equals(""))? "Others" : location + "/" + (String)row_details[13]));
            _bw.write(_wl_block41Bytes, _wl_block41);
 tmp_ord_cat = (String)row_details[18]+"/"+(String)row_details[13];
            }
            _bw.write(_wl_block39Bytes, _wl_block39);
if (group_by.equals("U") && isSiteSpecificBillStatus) {
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[1];
            }else if (group_by.equals("U")) {
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[1];
            }
            _bw.write(_wl_block39Bytes, _wl_block39);
if (group_by.equals("O")) {
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[2];
            }else if (group_by.equals("O")) {
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block38Bytes, _wl_block38);
tmp_ord_cat = (String)row_details[2];
            }
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);

		String [] colorString = {"X","X","X"};
		String color_string = "";
		  /*if (can_view_by.equals("L")) {
		      color_string = bean.getColorCodings(facility_id,row_details[9],row_details[21],row_details[20]);
		  } else {
		      color_string = bean.getColorCodings(facility_id,row_details[9],"","");
		  }*/
		  StringTokenizer colorTokenizer = new StringTokenizer(color_string,",");
            int index = 0;
            while(colorTokenizer.hasMoreTokens()) {
                String tempToken = colorTokenizer.nextToken();
                if (tempToken.equals("#800080"))
                    colorString[index] = "QRY1";
                else if (tempToken.equals("#008080"))
                    colorString[index] = "QRY2";
                else if (tempToken.equals("#A52A2A"))
                    colorString[index] = "QRY3";
                else if (tempToken.equals("#FF0000"))
                    colorString[index] = "QRY4";
                else if (tempToken.equals("#40E0D0"))
                    colorString[index] = "QRY5";
                else if (tempToken.equals("#FF8C00"))
                    colorString[index] = "QRY6";
                else if (tempToken.equals("#CD5C5C"))
                    colorString[index] = "QRY7";
                else if (tempToken.equals("X"))
                    colorString[index] = slClassValue;
                index++;
            }
        
			
			//String [] record 	= bean.getProcedureCode(row_details[9]);
				//bill_yn				= bean.checkForNull(record[4],"");
				//charge_type_applicable= bean.checkForNull(record[5],"");
				//bill_yn="Y";
				//charge_type_applicable="M";
			/*if (!row_details[12].equalsIgnoreCase("C")) {				
				result_type			= bean.checkForNull(record[0],"");
				procedure_code		= bean.checkForNull(record[1],"");
				proc_code_scheme	= bean.checkForNull(record[2],"");
				auto_report_yn		= bean.checkForNull(record[3],"");
			}*/
			//procedure_code		= bean.checkForNull(record[1],"");
			//proc_code_scheme	= bean.checkForNull(record[2],"");
			//auto_report_yn		= bean.checkForNull(record[3],"");
			sex = row_details[14];
			if(row_details[1].equals("U")){
				fontValue = "<font size=1 color=red><b>";  // this is to indicate the different color for urgency
			}else if(row_details[1].equals("S")){
				fontValue = "<font size=1 color=brown><b>";  // this is to indicate the different color for Stat
				imageTag = "<img src=\"../images/StatOrders.gif\" width=\"26\" height=\"24\" border=0 alt=\"Stat\">";
			}else{
				fontValue = "<font size=1 color=black><b>";
			}
			
			//Result_Type = bean.getResultType(row_details[9]);
			//discr_msr_id = bean.checkForNull(Result_Type[1],"");
			
/**
	modified by Deepa on 13/05/2010 for IN021020
	added dob to the function displayToolTip to handle multiple reference range
**/	
		
			
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(i));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(menuText));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(row_details[16]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(procedure_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[15]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[5]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[10]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[29]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(performed_only));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[30]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[31]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[32]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sent_out_flag));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[7]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[18]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[19]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode(row_details[3])));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(java.net.URLEncoder.encode(discr_msr_id)));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.checkForNull(row_details[35],"")));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[26]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(bean.checkForNull(row_details[38],"")));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate(row_details[0],"DMYHM","en",localeName)));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(fontValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(row_details[1]));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(imageTag));
            _bw.write(_wl_block59Bytes, _wl_block59);

				if(row_details[2].indexOf("$$RD##")!=-1)
				{
					String[] str = (String[])row_details[2].split("!~!");
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
					row_details[2]  = order_detail;
					if(row_details[2].lastIndexOf(",") ==((row_details[2].length())-2))
					{
						row_details[2] = row_details[2] .substring(0,((row_details[2].length())-2));
					}
				}
				if(row_details[2].indexOf("!~!")!=-1)
				{
					row_details[2] =row_details[2].replace("!~!",",");
				}
			
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(row_details[6]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[9]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[16]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(sex));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(procedure_code));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[15]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(row_details[33]));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(proc_code_scheme));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(row_details[38]));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(row_details[2]));
            _bw.write(_wl_block63Bytes, _wl_block63);
if(row_details[34].equals("Y")){
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(row_details[3]));
            _bw.write(_wl_block67Bytes, _wl_block67);

			String billingStatus = row_details[40];
			if("B".equals(row_details[40]))
				billingStatus	= "Billed&nbsp;<img src='../../eOR/images/Billed.png' border='0'  title='Billed'/>";
			else if("U".equals(row_details[40]))
				billingStatus	= "Unbilled&nbsp;<img src='../../eOR/images/Unbilled.png' border='0'  title='Unbilled'/>";
			
			if(isSiteSpecificBillStatus && !"".equals(billingStatus))
			{
			
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(billingStatus));
            _bw.write(_wl_block70Bytes, _wl_block70);

			}else if(isSiteSpecificBillStatus)
			{
			
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block72Bytes, _wl_block72);

			}
			
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(slClassValue));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(row_details[4]));
            _bw.write(_wl_block74Bytes, _wl_block74);

				
			if(performed_only.equals("Y") && !row_details[38].equals("")){
            _bw.write(_wl_block75Bytes, _wl_block75);

				
				
				StringBuffer forward_desc=new StringBuffer();
				String forward_to_id = "";
				String modified_by_id = "";
				StringBuffer modify_desc=new StringBuffer();
				StringBuffer error_desc=new StringBuffer();				
				//--[IN033488]
				String forwardDescYN = "N";
				String modifyDescYN = "N";
				String errorDescYN = "N";
				//--[IN033488]
				
				ArrayList notesStatus = bean.getLatestStatus(row_details[38],facility_id,localeName);
				forward_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Forward.label","common_labels"));
				forward_desc.append(" ");
				forward_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.to.label","common_labels"));
				forward_desc.append(" ");

				error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.MarkedasError.label","ca_labels"));
				error_desc.append(" ");
				error_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
				error_desc.append(" ");
				modify_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Modified.label","common_labels"));
				modify_desc.append(" ");
				modify_desc.append(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.by.label","common_labels"));
				modify_desc.append(" ");
				
				if (notesStatus != null && notesStatus.size()>0){
					for (int j=0;j< notesStatus.size();j++){
							String[] latestStatus = (String[])notesStatus.get(j);
						if (latestStatus != null && latestStatus.length>0){
							if(latestStatus[1].equals("SP")){							
								
								if(!forward_to_id.equals( latestStatus[6])){
									forward_to_id = latestStatus[6];
									forward_desc.append(latestStatus[5]);
									forwardDescYN = "Y"; //--[IN033488]
								}
								forward_desc.append(",");
							}if(latestStatus[1].equals("FS"))	{								
								forward_desc.append(latestStatus[4]);								
								forward_desc.append(", ");
								forwardDescYN = "Y"; //--[IN033488]
							}if(latestStatus[1].equals("ER"))	{
								error_desc.append(latestStatus[0]);
								error_desc.append(", ");
								errorDescYN = "Y"; //--[IN033488]
							}if((latestStatus[1].equals("RV")) && (latestStatus[2].equals("CO")))	{									
								if(!modified_by_id.equals(latestStatus[3]))
								{
									modified_by_id = latestStatus[3];
									modify_desc.append(latestStatus[0]);	
									modifyDescYN = "Y"; //--[IN033488]
								}								
								modify_desc.append(", ");					
							}
						}
					}
				}
				//--[IN033488] Modified 		- Start		
				if (forwardDescYN.equals("Y"))
				{	forward_desc.delete(forward_desc.length()-1,forward_desc.length());					
					
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(forward_desc));
            _bw.write(_wl_block77Bytes, _wl_block77);
		}if (errorDescYN.equals("Y"))
				{
					error_desc.delete(error_desc.length()-2,error_desc.length());			
					
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(error_desc));
            _bw.write(_wl_block78Bytes, _wl_block78);
		}if (modifyDescYN.equals("Y"))
				{
						
						modify_desc.delete(modify_desc.length()-2,modify_desc.length());			
					
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(modify_desc));
            _bw.write(_wl_block79Bytes, _wl_block79);
		}//--[IN033488] Modified 	-End
				}
				
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(i));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(procedure_code));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(result_type));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(i));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(row_details[39]));
            _bw.write(_wl_block87Bytes, _wl_block87);
i++;
    }
            _bw.write(_wl_block88Bytes, _wl_block88);
 
	}
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(from));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(to));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(order_category));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(can_location_type));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(can_location));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(can_order_category));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(can_single_multi));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(can_priority));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(can_date_from));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(can_date_to));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(can_patient_id));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(can_order_id));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(can_encounter_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(can_patient_id_found));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(can_task_status));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(can_specimen_no));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(patient_id_found));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(group_by));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(from_ca));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(can_location));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(can_single_multi));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(can_priority));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(can_date_from));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(can_date_to));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(can_order_id));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(can_patient_id));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(can_encounter_id));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(can_order_type));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(can_performing_location_code));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(can_view_by));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(can_specimen_no));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(request.getParameter("catalog_desc")));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(request.getParameter("task_status")));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(request.getParameter("source_type")));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(request.getParameter("peforming_location_code")));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(request.getParameter("source_location")));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(request.getParameter("search_criteria")));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(request.getParameter("activity_type")));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(can_catalog_desc));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(can_search_criteria));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(can_source_location_type));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(can_source_locn));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(can_group_by));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(performed_only));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(period_mod_rslt_completed));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(by_24hrs_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block140Bytes, _wl_block140);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDate.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.priority.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderDetails.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.BillingStatus.label", java.lang.String .class,"key"));
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
}
