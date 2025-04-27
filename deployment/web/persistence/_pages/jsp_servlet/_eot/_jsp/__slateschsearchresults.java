package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.SlateBean;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.util.HashMap;
import webbeans.eCommon.ConnectionManager;
import java.net.URLDecoder;
import java.lang.Object;

public final class __slateschsearchresults extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/SlateSchSearchResults.jsp", 1709120352892L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n <html>\n\t<head>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t\t<script language=\"Javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"Javascript\" src=\"../../eOT/js/Slate.js\"></script>\n\t\t<script>\n\t\t\tvar operationsProcedures_value=getLabel(\"eOT.OperationsProcedures.Label\",\"OT\");\n\t\t\tvar reason_value=getLabel(\"Common.reason.label\",\"common\");\n\t\t\tvar ctxPath = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\"; //Modified against 50878\n\t\t\tfunction clickDrugInfo()\n\t\t\t{\n\t\t\t\treturn true;\n\t\t\t}\n//Added by MuthuN against CRF-268 Starts Here \n\nfunction hideToolTip(){\n  document.getElementById(\"tooltiplayer1\").style.visibility = \'hidden\';\n}\n\nfunction localTrimString(sInString) {\n\t  return sInString.replace(/[\\[\\]\']+/g,\"\");\n}\nfunction  reasonToolTip1(rownum,patient_id,appt_ref_num,appt_date){\n\tvar formObj = document.SlateSchSearchResultForm;\n\tvar facilityid=formObj.facilityid.value;\n\tvar xmlDoc = \"\" ;\n\tvar xmlHttp = new XMLHttpRequest();\n\tvar xmlStr =\"<root><SEARCH \";\n\txmlStr +=\" /></root>\";\n\txmlDoc = new DOMParser().parseFromString(xmlStr, \"text/xml\");\txmlHttp.open(\"POST\",\"OTCommonValidation.jsp?func_mode=pick_list_slate_status&facilityid=\"+facilityid+\"&appt_date=\"+appt_date+\"&patient_id=\"+patient_id+\"&appt_ref_num=\"+appt_ref_num,false);\t\n\txmlHttp.send(xmlDoc);\n\tvar retVal = trimString(xmlHttp.responseText);\n\tvar arrMsg=retVal;\n\tvar arr=new Array();\n\tarr=arrMsg.split(\",\");\n\tvar cou=0;\n\tvar oper_proc_label=getLabel(\"eOT.PickListStatus.Label\",\"ot_labels\");\n\tvar tab_dat  = \"<table id =\'tooltiptable1\' cellpadding=\'3\' cellspacing=0 border=\'0\' class=\'BOX\' width=\'100%\' height=\'100%\' align=\'center\'>\";\n\tvar id_name_colval  =\'\';\n\t//if(arr[0]==\"\" || arr[0]==null){\n\t//id_name_colval  =oper_proc_label;\n\t//}else{\n\tid_name_colval  = \"Pick List Generation Status\"\n\t//}\n\ttab_dat     += \"<tr>\"\n\ttab_dat     += \"<th   nowrap > <B>\"+id_name_colval + \" </B> </a> </th>\"\n\ttab_dat     += \"</tr> \";\n\n\tfor( cou=0;cou<arr.length;cou++){\n\t\tmsg=arr[cou]; // commented by MuthuN for testing\n\t\tvar msg1 = localTrimString(msg);//Added By MuthuN against CRF-268\n\t\ttab_dat     += \"<tr>\"\n\t\ttab_dat     += \"<td class=\'label\' > <B>\"+msg1+ \" </B> </a> </td>\"\n\t\ttab_dat     += \"</tr> \";\n\t}\n\ttab_dat     += \"</table> \";\n\tdocument.getElementById(\"tooltiplayer1\").innerHTML = tab_dat;\n\tresizeWindow1();\n}\n\nfunction resizeWindow1(){ \n\tbodwidth = parent.frames[1].document.body.offsetWidth\n\tbodheight = parent.frames[1].document.body.offsetHeight\n\n\tvar x =event.x\n\tvar y =  event.y;\n\n\tx = x + (document.getElementById(\"tooltiplayer1\").offsetWidth)\n\ty = y + (document.getElementById(\"tooltiplayer1\").offsetHeight)\n\n\tif(x<bodwidth)\n\t\tx =event.x\n\telse\n\t\tx = x - (document.getElementById(\"tooltiplayer1\").offsetWidth*1)\n\n\tif(y<bodheight){\n\t\t y =event.y\n\t}else{\n\t\ty = y - (document.getElementById(\"tooltiplayer1\").offsetHeight*1)\n\t}\n\n\ty+=document.body.scrollTop\n\tx+=document.body.scrollLeft\n\n\tdocument.getElementById(\"tooltiplayer1\").style.posLeft= x\n\tdocument.getElementById(\"tooltiplayer1\").style.posTop = y\n\tdocument.getElementById(\"tooltiplayer1\").style.visibility=\'visible\'\n}\n//Added by MuthuN against CRF-268 Ends Here\n</script>\n</head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\' >\n<script type=\"text/javascript\" src=\"../../eOT/js/wz_tooltip.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<form name=\"SlateSchSearchResultForm\" id=\"SlateSchSearchResultForm\">   \n\t<table class=\'grid\' border=\"1\" cellpadding=\"3\" cellspacing=\"0\" width=\"100%\" align=\"center\" name=\"resultTable\" id=\"resultTable\" id=\"resultTable\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<tr id=\"slate_results_table_row1\">\n\t\t\t<td class=\"columnHeader\"  colspan=\"11\">\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img id=\"img_src_res\" src=\'../../eOT/images/gripper.gif\' onclick=\'extractResultFrame()\'>\n\t\t\t</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<tr id=\"slate_results_table_row1\">\n\t\t\t<td class=\"columnHeader\"  colspan=\"11\">\n\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t</td>\n\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<tr>\n\t</tr>\n\t\n\t<tr id=\"slate_results_table_row1\">\n\t\t\t<td class=\'columnHeader\' ></td>\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t\t\t<td class=\'columnHeader\' ></td><!-- Added by MuthuN against CRF - 268 -->\n\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t<td class=\'columnHeader\' >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" </td>\n\t\t\t\t<td class=\'columnHeader\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t<td class=\'columnHeader\' >";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td> <!-- CRF-0021-->\n\t\t\t\t<td class=\'columnHeader\' >";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\n\t</tr>\t\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<tr>\t\t\n\t\t\t<!--Modified by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012-->\n\t\t\t<td style=\"font-size:10pt;font-weight:bold;color:";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =";background-color:";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\" OnMouseOver=\"Tip(indicatorToolTip(\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"  onmouseout=\"UnTip()\" >\n\t\t\t<img src=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' class=\'img\' name=\'img1";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'  id=\'img1";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'  OnMouseDown=\"clickDrugInfo()\">\n\t\t\t</td>\n\t\t<!-- Added by MuthuN against CRF-268 Starts Here -->\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<td style=\"font-size:10pt;font-weight:bold;color:";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\" OnMouseOver=\"reasonToolTip1(\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\')\"  onmouseout=\"hideToolTip1()\" >\n\t\t\t<img src=\'../../eOT/images/picklist.png\' class=\'img\' name=\'img1";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'  OnMouseDown=\"clickDrugInfo()\">\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<td></td>\n\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<!-- Added by MuthuN against CRF-268 Ends Here -->\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t<td class=\"gridData\" style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\" OnMouseOver=\"Tip(reasonToolTip4(\'reason\',\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\',\'sch_case\'),JUMPHORZ,true)\" onMouseOut=\"UnTip();\">\n\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="-\n\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t<img src=\'../../eOT/images/R_indicator.png\' class=\'img\' name=\'img3";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'img3";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'   Onmousedown=\"clickDrugInfo()\">\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<td class=\"gridData\" style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\" >\n\t\t\t\t";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t<td  class=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\" style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\"  > ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</font>\t\t\t\t\t\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t\t<!-- GHL-CRF 356.1-->\n\t\t\t\t<td id=\'orderctl";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'  onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\',this,\'SLATE\',this,\'imgArrow";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\');external_doc(\'patient_id_";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\');\" style=\'cursor:pointer\' class=\'gridDataBlue\' onMouseOver=\" hidemenu();\" >\n\t\t\t\t\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t<img align=\'right\' src=\'../../eCommon/images/inactiveArrow.gif\' name=\'imgArrow";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t</td>\n";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\t\t\t\t<td class=\"gridDataBlue\" style=\'cursor:pointer\'  >\n\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t   </td>\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t<input type=\'hidden\' name=\"patient_name_";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\" id=\"patient_name_";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\" value=\"";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\">\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\"  wrap>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</td>\n\t\t\t<!-- ML-BRU-SCF-1054 by MuthuN -->\n\t\t\t\t\t<!--<td  class=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\" OnMouseOver=\"reasonToolTip(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\',\'scheduled_cases\')\"   onmouseout=\"hideToolTip1()\">-->\n\t\t\t\t\t<!--Tip(indicatorToolTip(\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)-->\n\t\t\t\t\t<td  class=\"";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\" OnMouseOver=\"Tip(reasonToolTip(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\',\'scheduled_cases\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)\"   onmouseout=\"UnTip()\"><!--058860-->\n\t\t\t\t\t<img src=\'../../eOT/images/drugInfo.gif\' class = \'img\' name=\'img2";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' id =name=\'img2";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\'   Onmousedown=\"clickDrugInfo()\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n                       \n\t\t\t\t\t</td>\n\t\t\t\t<!-- Added New CRF-0021\t\t-->\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\" >\n\t\t\t\t ";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =" \n\t\t\t\t\n\t\t\t\t</td>\n\t\t    <!-- end  -->\t\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t<td class=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =";background-color: ";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\" >All Surgeons\n\t\t\t\t\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t\t\t\t\n\t\t<!--<td class=\"";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\"  style=\"font-size:7pt;font-weight:normal;color:";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\" OnMouseOver=\"reasonToolTip3(\'reason\',\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\',\'sch_case\')\" onMouseOut=\"hideToolTip3();\">-->\n\t\t<!--Tip(indicatorToolTip(\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\'),FONTFACE, \'TimesNewRoman\', FONTSIZE, \'9pt\',HEIGHT,-100,CLICKCLOSE,true,STICKY, true)-->\n\t\t<td class=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" OnMouseOver=\"Tip(reasonToolTip3(\'reason\',\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\',\'sch_case\'),JUMPHORZ,true)\" onMouseOut=\"UnTip();\"><!--058860-->\n\n\t\t\t <img src=\'../../eOT/images/drugInfo.gif\' class=\'img\' name=\'img3";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\'   Onmousedown=\"clickDrugInfo()\">\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" \n\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\t(";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =")\n\t\t\t";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\n           \n\t\t\t</td>  \n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 =" \"OnMouseOver=\"Tip(reasonStatusToolTip(\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'),JUMPHORZ,true)\" onmouseout=\"UnTip()\">\n\t\t\t\t<img src=\'../../eOT/images/drugInfo.gif\' class = \'img\' name=\'img4";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' id=\'img4";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'  onmousedown=\"clickDrugInfo()\">\n\t\t\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" OnMouseOver=\"Tip(reasonStatusToolTip(\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'),JUMPHORZ,true)\"  onmouseout=\"UnTip()\">\n\t\t\t\t<img src=\'../../eOT/images/drugInfo.gif\' class = \'img\' name=\'img4";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\t\t\t\t\t\t\t\t\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="<!-- MMS-SCF-0430 [IN:051824] -->\n\t\t\t</td>\n\t\t\t<input type=\"hidden\" name=\"patient_id_";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" id=\"patient_id_";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t<input type=\"hidden\" name=\"order_id_";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\" id=\"order_id_";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t<input type=\"hidden\" name=\"oper_code_";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\" id=\"oper_code_";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t<input type=\"hidden\" name=\"speciality_code_";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" id=\"speciality_code_";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<input type=\"hidden\" name=\"surgeon_code_";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\" id=\"surgeon_code_";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t<input type=\"hidden\" name=\"oper_status_";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\" id=\"oper_status_";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\">\n\t\t\t<input type=\"hidden\" name=\"oper_num_";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\" id=\"oper_num_";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\">\n\t\t\t<input type=\"hidden\" name=\"asa_score_code_";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\" id=\"asa_score_code_";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\"> <!-- crf -0021-->\n<!-- \n\t\t\t <input type=\"hidden\" name=\"implant_entry_cmp_yn_";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\" id=\"implant_entry_cmp_yn_";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\">\n\t\t\t<input type=\"hidden\" name=\"consumable_entry_cmp_yn_";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\" id=\"consumable_entry_cmp_yn_";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\">\n\t\t\t<input type=\"hidden\" name=\"equipment_entry_cmp_yn_";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\" id=\"equipment_entry_cmp_yn_";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\">\n\t\t\t<input type=\"hidden\" name=\"instrument_entry_cmp_yn_";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\" id=\"instrument_entry_cmp_yn_";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\"> \n\t\t\t<input type=\"hidden\" name=\"proc_chrg_cmp_yn_";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\" id=\"proc_chrg_cmp_yn_";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\"> -->\n\t\t\t<input type=\"hidden\" name=\"appt_ref_num_";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\" id=\"appt_ref_num_";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\"> \n\t\t\t<input type=\"hidden\" name=\"facilityid";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" id=\"facilityid";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" value=";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="><!--IE-11 Issue-->\n\t\t\t<input type=\"hidden\" name=\"appt_date";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" id=\"appt_date";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\">\t\t\t\n\t\t\t<input type=\"hidden\" name=\"waitlist_num_";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" id=\"waitlist_num_";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\" value=\"\">\n\t\t\t<input type=\"hidden\" name=\"nursing_doc_comp_yn_";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" id=\"nursing_doc_comp_yn_";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n\t\t\t<input type=\"hidden\" name=\"surgeon_doc_comp_yn_";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\" id=\"surgeon_doc_comp_yn_";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\">\n\t\t\t<input type=\"hidden\" name=\"anaesthesia_doc_comp_yn_";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\" id=\"anaesthesia_doc_comp_yn_";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\">\t\n\t\t\t\n\t\t\t<input type=\"hidden\" name=\"speciality_desc_";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\" id=\"speciality_desc_";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\">\t\n\n\t\t\t<input type=\"hidden\" name=\"surgeon_desc_";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\" id=\"surgeon_desc_";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\">\n\t\t\t<!-- Below line was added by venkatesh.S on 27-Aug-2013 against RUT-CRF-0083.4[IN041509] -->\n\t\t\t<input type=\"hidden\" name=\"episod_id_";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" id=\"episod_id_";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\">\n\t\t\t<input type=\"hidden\" name=\"patient_class_";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" id=\"patient_class_";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\">\n\t\t\t<input type=\"hidden\" name=\"current_locn_";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" id=\"current_locn_";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\">\n\t\t\t<!-- end RUT-CRF-0083.4[IN041509] --> \n\t\t\n\t\t</tr>\n\t";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\n\t</table>\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\" value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\">\n\t<input type=\"hidden\" name=\"appt_ref_date\" id=\"appt_ref_date\" value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\">\n\t<input type=\"hidden\" name=\"menu_id\" id=\"menu_id\" value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\">\t\t\n\t<input type=\"hidden\" name=\"bean_id\" id=\"bean_id\" value=\"";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\">\n\t<input type=\"hidden\" name=\"bean_name\" id=\"bean_name\" value=\"";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\">\n\t<input type=\"hidden\" name=\"user_role\" id=\"user_role\" value=\"";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\">\t\t\n\t<input type=\"hidden\" name=\"login_user\" id=\"login_user\" value=\"";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\">\t\t\n\n\t<input type=\"hidden\" name=\"function_id_list\" id=\"function_id_list\" value=\"\">\t\t\n\t<input type=\"hidden\" name=\"function_name_list\" id=\"function_name_list\" value=\"\">\t\t\n\t<input type=\"hidden\" name=\"url_desc_list\" id=\"url_desc_list\" value=\"\">\t\t\n\t<input type=\"hidden\" name=\"sch_unsch_flag\" id=\"sch_unsch_flag\" value=\"SCHEDULED\">\n\t <input type=\"hidden\" name=\"text_color_1\" id=\"text_color_1\" value=\"";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\">\t\t \n\t<input type=\"hidden\" name=\"text_color_2\" id=\"text_color_2\" value=\"";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\">\n\t<input type=\"hidden\" name=\"bill_flag\" id=\"bill_flag\" value=\"";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\">\n\t<input type=\"hidden\" name=\"search_page_view_by\" id=\"search_page_view_by\" value=\"";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\">\n\t<input type=\"hidden\" name=\"more_Less_result_Flag\" id=\"more_Less_result_Flag\" value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\">\n\t<input type=\"hidden\" name=\"facilityid\" id=\"facilityid\" value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\">\n\t<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\">\n\t<input type=\"hidden\" name=\"surgery_date\" id=\"surgery_date\" value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\">\n\t<input type=\"hidden\" name=\"appt_ref_num\" id=\"appt_ref_num\" value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\">\n\t<input type=\"hidden\" name=\"appt_date\" id=\"appt_date\" value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\">\n \t  <!-- Below line was added by venkatesh.S on 27-Aug-2013 against RUT-CRF-0083.4[IN041509] -->\n\t<input type=\"hidden\" name=\"size\" id=\"size\" value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\">\n\t<input type=\"hidden\" name=\"resp_id\" id=\"resp_id\" value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\" value=\"OT\">\n\t<input type=\"hidden\" name=\"language_id\" id=\"language_id\" value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" >\n\t<input type=\"hidden\" name=\"calledFrom\" id=\"calledFrom\" value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" > ";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\n\t<input type=\"hidden\" name=\"customer_name\" id=\"customer_name\" value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\"> <!-- Added for IN:41808 -->\n\t<!-- end RUT-CRF-0083.4[IN041509] --> \n\t<input type=\"hidden\" name=\"auto_schdl_yn\" id=\"auto_schdl_yn\" value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\"> <!-- Added by Gaurav Against ML-MMOH-CRF-1791-US04-->\t\t\n\t\t\t\n</form>\n\t<div name=\'tooltiplayer1\' id=\'tooltiplayer1\' style=\'position:absolute;  width:30%; visibility:hidden;\' bgcolor=\'blue\' ></div>\n\t<div name=\'tooltiplayer3\' id=\'tooltiplayer3\' style=\'position:absolute; width:36%; visibility:hidden;\' bgcolor=\'blue\'></div>\n \t<div name=\'tooltiplayer2\' id=\'tooltiplayer2\' style=\'position:absolute; width:70%; visibility:hidden; overflow:auto\' bgcolor=\'blue\'></div>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\n\t <table id=\'tooltiptable\' cellpadding=\"0\" cellspacing=0 border=\'0\'   style=\'position:absolute;\' width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' id=\'menu_table\'></td>\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\n</body>\n</html>\n<script language=\"javascript\">\n\n</script>\n";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getContextPath()));
            _bw.write(_wl_block8Bytes, _wl_block8);

	Connection conn=null;
	ResultSet rs_locn_room_bed=null;
	String surgery_date="",appt_date_hmap="",more_Less_result_Flag="",reschedule_count="",splty_and_nature_desc = "",nature_short_desc = "",current_locn="",room_bed_no="",curr_locn="",roomNo="",bed_no="",classvalue="",color_ind	= "",text_color	= "",appt_ref_num = "",oper_num="",case_called_time="",check_out_from_ward_time="",rescheduled_count="",appt_date="",asa_score_code="";
	String locale = (String)session.getAttribute("LOCALE"); 
	PreparedStatement pstmt1 = null;
	ResultSet rst1 = null;
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
	PreparedStatement pstmt2 = null;	
	ResultSet rst2 = null;
	PreparedStatement pstmt = null;	
	ResultSet rst = null;
	String Disp_Image="";
	//Added by MuthuN against CRF-268 Starts Here
	PreparedStatement pstmt3 = null;
	ResultSet rst3 = null;
	PreparedStatement pstmt4 = null;
	ResultSet rst4 = null;
	PreparedStatement pstmt5 = null;
	ResultSet rst5 = null;
	int count=0;
	String auto_schdl_yn = "";// Added By Gaurav Against ML-MMOH-CRF-1791-US04...
    String item_type="";
	String ot_Param="";
	String curr_encounter_id="";
	String curr_patient_class="";
	String episod_id="";
	String visit_id="";
	String resp_id = (String)session.getValue("responsibility_id") == null ? "" : (String)session.getValue("responsibility_id");
	String customer_id1="";// Added for IN:41808
	String sql_sm_report="select customer_id from SM_SITE_PARAM where rownum = 1"; 
	String calledFrom = ""; //IN052054	 
	//Added by MuthuN against CRF-268 Starts Here
try{
	
	more_Less_result_Flag	=	request.getParameter("more_Less_result_Flag");
	calledFrom = request.getParameter("calledFrom") == null ? "" : request.getParameter("calledFrom");//IN052054
	if(more_Less_result_Flag==null || more_Less_result_Flag.equals("null") || more_Less_result_Flag.equals(""))
	more_Less_result_Flag = "N";
	String room_no_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomno.label","common_labels") ;
	String bed_no_legend =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels") ;
	String facilityid  = (String) session.getValue("facility_id");
	String login_user	= (String)session.getValue("login_user");
	String user_role = request.getParameter("user_role");
	String theatre_date = request.getParameter("theatre_date");
	String bill_flag = request.getParameter("bill_flag");
	String view_by = request.getParameter("view_by");
	theatre_date = com.ehis.util.DateUtils.convertDate(request.getParameter("theatre_date"),"DMY",locale,"en");
	String bean_id	 = "SlateBean";
	String bean_name = "eOT.SlateBean";
	String patient_id = "";
	int count_val=0;
	SlateBean bean	 = (SlateBean)mh.getBeanObject( bean_id, request, bean_name );
	HashMap all_scheduled_case_details = bean.getScheduledCases();
	HashMap scheduled_case_details=new HashMap();
	int size = all_scheduled_case_details.size();
		conn = ConnectionManager.getConnection(request);
		pstmt1=conn.prepareStatement(sql_sm_report); // Added for IN:41808
			rst1=pstmt1.executeQuery();
			if(rst1 !=null && rst1.next())
			{
			customer_id1=checkForNull(rst1.getString("customer_id"));
			}	
			if(rst1!=null)rst1.close();
			if(pstmt1!=null)pstmt1.close();// End for IN:41808
		//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012
		 pstmt2 = conn.prepareStatement("SELECT * from PR_HIGH_RISK_CONDITION where PATIENT_ID=? AND CLOSE_DATE IS NULL") ;

		String sql="SELECT TO_CHAR(SYSDATE,'DD/MM/YYYY') CURRENT_DATE FROM DUAL";
		pstmt1 = conn.prepareStatement(sql) ;
		rst1 = pstmt1.executeQuery();
		while(rst1.next()){
			surgery_date=com.ehis.util.DateUtils.convertDate(rst1.getString("CURRENT_DATE"),"DMY","en",locale);
		}
	//Added by Muthu against CRF_268 starts here
	String sqlOtParam = "select NVL(cssd_interface_yn,'N') facility from ot_param_for_facility where operating_facility_id = ?";
	try{
			pstmt3 = conn.prepareStatement(sqlOtParam);
			pstmt3.setString(1,facilityid);
			rst3=pstmt3.executeQuery();
			if(rst3 !=null && rst3.next())
			{
				ot_Param=rst3.getString("facility");
			}		
		}catch(Exception e){	
				System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
				e.printStackTrace();
			}finally{
			try{
			if(rst3!=null)    rst3.close();
			if(pstmt3!=null)  pstmt3.close();
			}catch(Exception e){}
		}
	//Added by Muthu against CRF_268 ends here
	
            _bw.write(_wl_block9Bytes, _wl_block9);
if(view_by.equals("A")){
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
if("Y".equalsIgnoreCase(ot_Param)){
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

	for (int i=1;i<=size;i++){
		scheduled_case_details=(HashMap)all_scheduled_case_details.get(i+"");
		appt_ref_num	= (String)scheduled_case_details.get("appt_ref_num");
		appt_date = (String)scheduled_case_details.get("appt_date");
		/*Below line was added by venkatesh.s on 27 -Aug-2013 againt against RUT-CRF-0083.4[IN041509] */
		curr_encounter_id=(String)scheduled_case_details.get("curr_encounter_id")==null ? "" :(String)scheduled_case_details.get("curr_encounter_id");		
        curr_patient_class=(String)scheduled_case_details.get("curr_patient_class")==null ? "" :(String)scheduled_case_details.get("curr_patient_class");
		
		  
		  if(!curr_encounter_id.equals("") && !curr_patient_class.equals("") && curr_patient_class.equals("IP") ){
		     episod_id=curr_encounter_id;
			
		  }else{
                if( !curr_encounter_id.equals("") && !curr_patient_class.equals("")){
				   
				   episod_id=curr_encounter_id.substring(0,8);
				   visit_id=curr_encounter_id.substring(8,curr_encounter_id.length());
				   
				  
				 }}		  
		       /* end against RUT-CRF-0083.4[IN041509] */
		    
		case_called_time	= (String)scheduled_case_details.get("case_called_time");
		check_out_from_ward_time	= (String)scheduled_case_details.get("check_out_from_ward_time");
		rescheduled_count	= (String)scheduled_case_details.get("reschedule_count");
		oper_num	= (String)scheduled_case_details.get("oper_num");
		if(oper_num==null) oper_num="";
		current_locn	= (String)scheduled_case_details.get("current_locn");
		if(current_locn ==null) current_locn="";
		asa_score_code	= (String)scheduled_case_details.get("asa_score_code"); //crf-0021
		if(asa_score_code ==null) asa_score_code="";
		
		reschedule_count	= checkForNull((String)scheduled_case_details.get("reschedule_count"));
		if(reschedule_count.equals("")) reschedule_count="0";
		classvalue = (i%2==0)?"gridData":"gridData";
		color_ind	= (String)scheduled_case_details.get("color_ind");
		text_color	= (String)scheduled_case_details.get("text_color");

		if( current_locn !="")
		{
			int counter=0;
			StringTokenizer strToken1=new StringTokenizer(current_locn,"$$");
			 counter=strToken1.countTokens();
			if(strToken1.hasMoreTokens()){
					 if(counter <=1)
					{
						 curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo="";
						 bed_no="";
					}else if(counter <=2)
					{
						 curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						  if(roomNo.equals("^")) roomNo="";
						  bed_no="";
					}else
					{
						curr_locn=strToken1.nextToken();
						 if(curr_locn.equals("^")) curr_locn="";
						 roomNo=strToken1.nextToken();
						 if(roomNo.equals("^")) roomNo="";
						 bed_no=strToken1.nextToken();
						 if(bed_no.equals("^")) bed_no="";
					}
		}		
			room_bed_no=room_no_legend+" : "+roomNo+" "+bed_no_legend+" : "+bed_no; 
	}
	//IN:051238 start
	else {
			curr_locn="";
			roomNo="";
			bed_no="";
			room_bed_no=room_no_legend+" : "+roomNo+" "+bed_no_legend+" : "+bed_no; 
	     }
	 //IN:051238 end
	//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 starts here
	 patient_id = (String)scheduled_case_details.get("patient_id");
	 pstmt2.setString(1,patient_id);
	 rst2 = pstmt2.executeQuery();
		if(rst2.next()){
			Disp_Image ="../../eOT/images/High_risk.gif";
				}
		else{
			Disp_Image ="../../eOT/images/drugInfo.gif";
				}
//Added by lakshmi against BRU-HIMS-CRF-003 highrisk image crf on 16/03/2012 ends here

	
            _bw.write(_wl_block21Bytes, _wl_block21);

	//Added Newly for Icon Disable on 12/28/2012 AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') 
	if("Y".equalsIgnoreCase(ot_Param)){	
	String sqlOTSlate_Status = "SELECT count(*) FROM ot_pick_lists WHERE booking_num = '"+appt_ref_num+"' AND operating_facility_id = '"+facilityid+"' AND surgery_date = TO_DATE (?, 'dd/mm/yyyy') and (item_type='I' or item_type='P')  and (nvl(cssd_status,'X') <>'F')";
	try{
			pstmt5 = conn.prepareStatement(sqlOTSlate_Status);
			pstmt5.setString(1, appt_date);
			rst5=pstmt5.executeQuery();
			if(rst5 !=null && rst5.next())
			{
				count_val=rst5.getInt(1);
			}		
		}catch(Exception e){	
			System.err.println("Err From PickGenByDate.jsp "+e.getMessage());
			e.printStackTrace();
		}finally{
			try{
			if(rst5!=null)    rst5.close();
			if(pstmt5!=null)  pstmt5.close();
			}catch(Exception e){}
		}
	}
	String orderid=checkForNull((String)scheduled_case_details.get("order_id"));// GHL-CRF 356.1
	//Added Newly for Icon Disable on 12/28/2012
	
	    //Added by Gaurav Against ML-MMOH-CRF-1791-US04...starts
	
		String sql_2 = "SELECT AUTO_SCHDL_TO_NXTDAY_YN FROM OT_PARAM_FOR_FACILITY ";
		pstmt = conn.prepareStatement(sql_2);
		rst=pstmt.executeQuery();
		if(rst !=null && rst.next())
		{			
			auto_schdl_yn = rst.getString(1);			
		}
		
	     //Added by Gaurav Against ML-MMOH-CRF-1791-US04...ends
		
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(i));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(Disp_Image));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block28Bytes, _wl_block28);
if("Y".equalsIgnoreCase(ot_Param)){
				if(count_val>0){
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(i));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(i));
            _bw.write(_wl_block33Bytes, _wl_block33);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}	}
            _bw.write(_wl_block35Bytes, _wl_block35);
if(!reschedule_count.equals("0") && auto_schdl_yn.equals("Y")){
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(i));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)scheduled_case_details.get("appt_date"),"DMY","en",locale)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)scheduled_case_details.get("appt_from_time")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)scheduled_case_details.get("appt_to_time")));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(com.ehis.util.DateUtils.convertDate((String)scheduled_case_details.get("appt_date"),"DMY","en",locale)));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf((String)scheduled_case_details.get("appt_from_time")));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf((String)scheduled_case_details.get("appt_to_time")));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf((String)scheduled_case_details.get("patient_id")));
            _bw.write(_wl_block50Bytes, _wl_block50);

			appt_date_hmap=com.ehis.util.DateUtils.convertDate((String)scheduled_case_details.get("appt_date"),"DMY","en",locale);

			boolean flag=com.ehis.util.DateUtils.isBefore(appt_date_hmap,surgery_date,"DMY",locale);
			//belosw stmt Added by DhanasekarV on 07/06/2012  for report intenernalization leap year
			//flag = true;
			if(flag)
			{

            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(i));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(i));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(curr_encounter_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(current_locn));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf((String)scheduled_case_details.get("patient_name")));
            _bw.write(_wl_block2Bytes, _wl_block2);

					//IN052054
					if(calledFrom != null && !calledFrom.equals("CA"))
					{

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(i));
            _bw.write(_wl_block57Bytes, _wl_block57);

					}
					//IN052054

            _bw.write(_wl_block58Bytes, _wl_block58);

			}
			else
			{

            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf((String)scheduled_case_details.get("patient_name")));
            _bw.write(_wl_block60Bytes, _wl_block60);

			}

            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(i));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(scheduled_case_details.get("patient_name")));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf((String)scheduled_case_details.get("oper_room_desc")));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(i));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(i));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(i));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(i));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(i));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("oper_desc"))));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("asa_score_code"))));
            _bw.write(_wl_block76Bytes, _wl_block76);

				
				
				splty_and_nature_desc = checkForNull((String)scheduled_case_details.get("speciality_desc"));
				nature_short_desc = checkForNull((String)scheduled_case_details.get("nature_short_desc"));
				nature_short_desc = nature_short_desc==null?"":nature_short_desc;
				nature_short_desc = nature_short_desc.equals("null")?"":nature_short_desc;
				if(!nature_short_desc.equals(""))
					splty_and_nature_desc= splty_and_nature_desc+"("+nature_short_desc+")";
			
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(splty_and_nature_desc));
            _bw.write(_wl_block46Bytes, _wl_block46);

			String surgeon_name=checkForNull((String)scheduled_case_details.get("surgeon_name"));
				if(surgeon_name.equals("")){
			
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block79Bytes, _wl_block79);
}else {
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("surgeon_name"))));
            _bw.write(_wl_block46Bytes, _wl_block46);
}
            _bw.write(_wl_block80Bytes, _wl_block80);

			//status_times = bean.getSlateStatusTimes("SCH",scheduled_case_details,reschedule_count);
			out.println("<input type='hidden' name='check_out_from_ward_time_"+i+"' id='check_out_from_ward_time_"+i+"' value=\""+check_out_from_ward_time+"\" >");
			out.println("<input type='hidden' name='case_called_time_"+i+"' id='case_called_time_"+i+"' value=\""+case_called_time+"\" >");
			out.println("<input type='hidden' name='rescheduled_count_"+i+"' id='rescheduled_count_"+i+"' value=\""+rescheduled_count+"\" >");
			
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(i));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(i));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(i));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(i));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(i));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("status_desc"))));
            _bw.write(_wl_block89Bytes, _wl_block89);
if(Integer.parseInt(reschedule_count)>0 && checkForNull((String)scheduled_case_details.get("status_desc")).equals("Scheduled"))
		{
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("reschedule_count"))+"R"));
            _bw.write(_wl_block91Bytes, _wl_block91);
}
            _bw.write(_wl_block92Bytes, _wl_block92);
if(!current_locn.equals(curr_locn+"$$^$$^")){
				
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(room_bed_no));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
} else {
				//IN:051238
				
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(room_bed_no));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(i));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(i));
            _bw.write(_wl_block97Bytes, _wl_block97);
 } 
				
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(curr_locn));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(i));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)scheduled_case_details.get("patient_id")));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(i));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("order_id"))));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(i));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)scheduled_case_details.get("oper_code")));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(i));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)scheduled_case_details.get("speciality_code")));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(i));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)scheduled_case_details.get("surgeon_code")));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(i));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("oper_status"))));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(i));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("oper_num"))));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(i));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("asa_score_code"))));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(i));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("implant_entry_cmp_yn"))));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(i));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("consumable_entry_cmp_yn"))));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(i));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("equipment_entry_cmp_yn"))));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(i));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("instrument_entry_cmp_yn"))));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(i));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("proc_chrg_cmp_yn"))));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(i));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(i));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(i));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(i));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(i));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(i));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(i));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)scheduled_case_details.get("nursing_doc_comp_yn")));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(i));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)scheduled_case_details.get("surgeon_doc_comp_yn")));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(i));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf((String)scheduled_case_details.get("anaesthesia_doc_comp_yn")));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(i));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("speciality_desc"))));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(i));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(checkForNull((String)scheduled_case_details.get("surgeon_name"))));
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(i));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(episod_id));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(i));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(curr_patient_class));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(i));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(i));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(current_locn));
            _bw.write(_wl_block152Bytes, _wl_block152);
 
		}
	
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf((String)session.getValue("facility_id")));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf((String)scheduled_case_details.get("appt_date")));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf("26"));
            _bw.write(_wl_block156Bytes, _wl_block156);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block157Bytes, _wl_block157);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block158Bytes, _wl_block158);
            out.print( String.valueOf(user_role));
            _bw.write(_wl_block159Bytes, _wl_block159);
            out.print( String.valueOf(login_user));
            _bw.write(_wl_block160Bytes, _wl_block160);
            out.print( String.valueOf(color_ind));
            _bw.write(_wl_block161Bytes, _wl_block161);
            out.print( String.valueOf(text_color));
            _bw.write(_wl_block162Bytes, _wl_block162);
            out.print( String.valueOf(bill_flag));
            _bw.write(_wl_block163Bytes, _wl_block163);
            out.print( String.valueOf(view_by));
            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(more_Less_result_Flag));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(facilityid));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(appt_ref_num));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(appt_date));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(size));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(resp_id));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block174Bytes, _wl_block174);
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(customer_id1));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(auto_schdl_yn));
            _bw.write(_wl_block177Bytes, _wl_block177);

		//bean.clear();
		if(rst2 != null) rst2.close();
		if(pstmt2 != null) pstmt2.close();
		
		}catch(Exception e){
			out.println(e);
		}finally{
		if(rs_locn_room_bed!=null) rs_locn_room_bed.close();
		if(conn!=null)
			ConnectionManager.returnConnection(conn, request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ScheduledCases.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ScheduledCases.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.DateTimeSlot.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Procedure.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AsaScore.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
}
