package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import eIP.advbedmgmt.transaction.patientsearch.PatientSearchConstants;
import org.apache.log4j.Logger;
import java.sql.*;
import java.lang.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __ipadvbedmgmt extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmt.jsp", 1709293411190L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!DOCTYPE>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<html>\n<head>\n<link type=\"text/css\" rel=\"stylesheet\"\n\thref=\"../../eIP/html/JQuery/ToolTip/jquery.cluetip.css\" />\n<link type=\"text/css\" rel=\"stylesheet\"\n\thref=\"../../eIP/html/IPAdvBedMgmtStyle.css\" />\n<link type=\"text/css\" rel=\"stylesheet\"\n\thref=\"../../eIP/html/PopupStyle.css\" />\n<script type=\"text/javascript\"\n\tsrc=\"../../eIP/html/JQuery/jquery-1.7.2.min.js\"></script>\n<script type=\"text/javascript\"\n\tsrc=\"../../eIP/html/JQuery/ToolTip/jquery.hoverIntent.js\"></script>\n<script type=\"text/javascript\"\n\tsrc=\"../../eIP/html/JQuery/ToolTip/jquery.cluetip.js\"></script>\n<script src=\"../../eIP/js/IPAdvBedMgmtTrns.js\" language=\"JavaScript\"></script>\n<script src=\'../../eIP/js/IPAdvBedMgmtSupplementary.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n<script type=\"text/javascript\">\n\t\t\t//var isBedBubbleShown = false;\n\t\t\t\n\t\t\t//var refreshInAction = false;\n\n\t\t\t$(document).ready(function() {\n\t\t\t\t$(\'a.jt\').cluetip({\n\t\t\t\t\tcluetipClass: \'jtip\',\n\t\t\t\t\twidth:676,\n\t\t\t\t\theight:8vh9,\n\t\t\t\t\ttopOffset:\'0\',\n\t\t\t\t\tleftOffset:\'0\',\n\t\t\t\t\tactivation:\'click\',\n\t\t\t\t\tpositionBy:\'auto\',\n\t\t\t\t\ttracking:false,\n\t\t\t\t\tarrows: true,\n\t\t\t\t\tdropShadow: false,\n\t\t\t\t\tsticky: true,\n\t\t\t\t\tmouseOutClose: false,\n\t\t\t\t\tonActivate : openBedBubble,\n\t\t\t\t\tonHide : afterBedBubbleHide,\n\t\t\t\t\tclosePosition: \'title\',\n\t\t\t\t\tcloseText: \'<img id=\"tooltipClose\" src=\"../../eIP/html/JQuery/ToolTip/cross.png\" alt=\"close\" />\'\n\t\t\t\t});\n\t\t\t\t$(\'.assignedBed\').mouseover(function(){\n\t\t\t\t\tvar bedId=$(this).attr(\'id\');\n\t\t\t\t\t//alert($(this).attr(\'id\'))\n\t\t\t\t\t//alert($(\"#\"+bedId+\'Enc\').val())\n\t\t\t\t\t$(\'#bedSelectId\').val($(this).attr(\'id\'));\n\t\t\t\t\t$(\'#encSelectId\').val($(\"#\"+bedId+\'Enc\').val());\n\t\t\t\t\t//alert($(this).attr(\'id\'))\n\t\t\t\t\t//$(\'#log\').append(\'<div>Handler for .mouseover() called.</div>\');\n\t\t\t\t\t//bedOverId\n\t\t\t\t});\n\t\t\t\t$(\'#floorWrapper\').width(document.documentElement.clientWidth)\n\t\t\t\t$(\'#floorWrapper\').height(document.documentElement.clientHeight)\n\t\t\t});\n\t\t\twindow.onresize=function(){\n\t\t\t\t$(\'#floorWrapper\').width(document.documentElement.clientWidth);\n\t\t\t};\n\t\t\t\n\t\t\t/* function openBedBubble(bedNumber,nursingUnit,patientClass,encounterId,operStnId,\n\t\t\t\t\ttransAllowed,knownAllergyYN,overdueCnt,dueCount,abnormalResultCnt,\n\t\t\t\t\tnursingUnitDesc,roomNumber,roomName){\n\t\t\t\t// this function launches the bed bubble\n\t\t\t\talert(\'bed bubble\');\n\t\t\t} */\n\t\t\t\n\t\t\tfunction openBedBubble(){\n\t\t\t\t// this function launches the bed bubble\n\t\t\t\t//alert(\'bed bubble\');\n\t\t\t\t//$(\'a.jt\').trigger(\'showCluetip\');\n\t\t\t\tisBedBubbleShown = true;\n\t\t\t}\n\t\t\t\n\t\t\tfunction afterBedBubbleHide(){\n\t\t\t\tisBedBubbleShown = false;\n\t\t\t}\n\t\t\t\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<style type=\"text/css\">\n\n/* .bedhighlightinnerdiv{\n\tdisplay: block;\n\tborder-left: 2px solid #004eff;\n\tborder-right: 2px solid #004eff;\n} */\n\n</style>\n\t\t\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<!--Below code was modified on 08-JAN-2013 against [IN037130] -->\n<body onKeyDown=\"lockKey()\">\n\t<form name=\'bedLayOutMgmt\' id=\'bedLayOutMgmt\' method=\'post\'>\n\t\t<div id=\"floorWrapper\" class=\'floorWrapper\'>\n\t\t\t<div class=\"floor\" id=\"floor\"\n\t\t\t\tstyle=\"width:";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="px; height:";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="px;\">\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\" class=\"room\"\n\t\t\t\t\tstyle=\"top:";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="px; left:";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="px;width:";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="px;background:";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n\t\t\t\t\t<div class=\'roomheader\'>\n\t\t\t\t\t\t<!--<table width=\'100%\'><tr><th>-->";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<!--</th></tr></table>-->\n\t\t\t\t\t</div>\n\t\t\t\t\t<div class=\'roombody\' style=\"height:";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="px;\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t<div id=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" class=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"\n\t\t\t\t\t\t\tstyle=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t<a class=\"jt\"\n\t\t\t\t\t\t\t\trel=\"../../eIP/jsp/IPAdvBedMgmtToolTip.jsp?bed_no=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nursing_unit=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&appl_patient_class=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&encounter_id=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&operStnId=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&trnsAllowed=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&KNOWN_ALLERGY_YN=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&overdue_count=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&due_count=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&abnormal_rslt_count=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&nursing_unit_desc=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="&room_number=";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="&room_name=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\"\\\n\t\t\t\t\t\t\t\ttitle=\"Manage Bed\">\n\t\t\t\t\t\t\t\t <b class=\"bedtop\"\n\t\t\t\t\t\t\t\tstyle=\'background:";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t\t\t\t\t\t<b id=\"btopfirst_";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\" style=\'background:";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =";\'></b> \n\t\t\t\t\t\t\t\t\t<b id=\"btopsecond_";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =";\'></b> \n\t\t\t\t\t\t\t\t\t<b id=\"btopthird_";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" style=\' background:";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =";\'></b>\n\t\t\t\t\t\t\t\t\t<b id=\"btopfour_";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =";\'></b>\n\t\t\t\t\t\t\t\t\t<b id=\"btoplast_";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\"\tstyle=\'background:";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =";\'></b>\n\t\t\t\t\t\t\t\t</b>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<div id=\"innerDiv_";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\"  style=\'width:";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="px;\' >\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<div class=\'bedheader\' style=\'color:";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="</div>\n\t\t\t\t\t\t\t<div class=\'bedbody\' style=\'color:";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n\t\t\t\t\t\t\t\t<div class=\"bedrowpatid\" id=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="Dummy\'>\n\t\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="</div>\n\t\t\t\t\t\t\t\t<div class=\"bedrowpatid\">\n\t\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<div class=\"bedrowpatid\">\n\t\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="&nbsp;|&nbsp;";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="&nbsp;/&nbsp;";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="<div class=\"bedrowencid\" id=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="Enc\'\n\t\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n\t\t\t\t\t\t\t\t\t\t&nbsp;";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="&nbsp;";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="|&nbsp;";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="<div class=\"ipiconrow\">\n\t\t\t\t\t\t\t\t\t<div style=\"float:left;position:relative;\">&nbsp;</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="<div class=\"ipicon\"\n\t\t\t\t\t\t\t\t\t\t\tid=\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="alrgy\'\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"background-image: url(\'../../eCommon/images/PI_Allergies.gif\');\"\n\t\t\t\t\t\t\t\t\t\t\tonclick=\'callAllergy(event,\"";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\")\'></div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="<div class=\"ipicon\"\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"background-image: url(\'../../eIP/images/BillPrepared.gif\');\"></div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<div class=\"ipicon\"\n\t\t\t\t\t\t\t\t\t\t\tstyle=\"background-image: url(\'../../eIP/images/future.gif\');\"></div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="<div class=\"ipicon\">\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/MedicationOverdue.png\'\n\t\t\t\t\t\t\t\t\t\t\t\ttitle=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' />\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="<div class=\"ipicon\">\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/MedicationDue.gif\'\n\t\t\t\t\t\t\t\t\t\t\t\tonclick=\'due_medication(event)\' title=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="<div class=\"ipicon\">\n\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/AbnormalResults.png\'\n\t\t\t\t\t\t\t\t\t\t\t\ttitle=\'Abnormal Results\' />\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="<div class=\"ipicon\">\n\t\t\t\t\t\t\t\t\t\t<img src=\'../images/PendingOrders.png\' title=\'Outstanding orders\'/>\n\t\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\t\t\t\t\t<!-- this is for providing vertical space --> \n\t\t\t\t\t\t\t\t<div style=\'background:";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =";height:2px;\'></div>\n\t\t\t\t\t\t\t   </div>\n\t\t\t\t\t\t\t\t <b class=\"bedbottom\" style=\'background:";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\'>\n\t\t\t\t\t\t\t\t \t<b id=\"bbottomfirst_";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =";\'></b>\n\t\t\t\t\t\t\t\t\t<b id=\"bbottomsecond_";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =";\'></b>\n\t\t\t\t\t\t\t\t\t<b id=\"bbottomthird_";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =";\'></b>\n\t\t\t\t\t\t\t\t\t<b id=\"bbottomfour_";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =";\'></b>\n\t\t\t\t\t\t\t\t\t<b id=\"bbottomlast_";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =";\'></b>\n\t\t\t\t\t\t\t\t </b>\n\t\t\t\t\t\t\t\t</a>\n\t\t\t\t\t\t</div>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t</div>\n\t\t\t\t</div>\n\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t</div>\n\t\t</div>\n\t\t<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' id=\'facilityId\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\' /> <input type=\'hidden\' name=\'nursingUnit\' id=\'nursingUnit\'\n\t\t\tid=\'nursingUnitId\' value=\'";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'bl_operational\' id=\'bl_operational\' id=\'bl_operational\' value=\'";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\' />\n\t\t<!-- bl operational at facility level-->\n\t\t<input type=\'hidden\' name=\'setup_bl_dtls_in_ip_yn\' id=\'setup_bl_dtls_in_ip_yn\'\n\t\t\tid=\'setup_bl_dtls_in_ip_yn\' value=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\' /> <input type=\'hidden\' name=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\' id=\'bl_interfaced_yn\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'allow_discharge_date\' id=\'allow_discharge_date\' id=\'allow_discharge_date\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'chk_for_pen_orders_bfr_dis_adv\' id=\'chk_for_pen_orders_bfr_dis_adv\'\n\t\t\tid=\'chk_for_pen_orders_bfr_dis_adv\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'dis_adv_allow_yn\' id=\'dis_adv_allow_yn\' id=\'dis_adv_allow_yn\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'chk_for_pen_orders_bfr_dis\' id=\'chk_for_pen_orders_bfr_dis\' id=\'chk_for_pen_orders_bfr_dis\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'dis_allow_yn\' id=\'dis_allow_yn\' id=\'dis_allow_yn\' value=\'";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\' /> <input type=\'hidden\' name=\'max_disch_period_for_dc\' id=\'max_disch_period_for_dc\'\n\t\t\tid=\'max_disch_period_for_dc\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\' />\n\t\t<input type=\'hidden\' name=\'mother_cut_off_age\' id=\'mother_cut_off_age\' id=\'mother_cut_off_age\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'mother_max_age\' id=\'mother_max_age\' id=\'mother_max_age\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\' />\n\n\t\t<input type=\'hidden\' name=\'disch_reason_mand_yn\' id=\'disch_reason_mand_yn\'\n\t\t\tid=\'disch_reason_mand_yn\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\' /> <input type=\'hidden\' name=\'allow_late_discharge_reason\' id=\'allow_late_discharge_reason\'\n\t\t\tid=\'allow_late_discharge_reason\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\' id=\'deactivate_pseudo_bed_yn\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'diag_update_period_max_unit\' id=\'diag_update_period_max_unit\' id=\'diag_update_period_max_unit\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'dis_date_chk_days_unit\' id=\'dis_date_chk_days_unit\' id=\'dis_date_chk_days_unit\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'dis_date_chk_days\' id=\'dis_date_chk_days\' id=\'dis_date_chk_days\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'bed_block_period_dis\' id=\'bed_block_period_dis\' id=\'bed_block_period_dis\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'discharge_checklist_app_yn\' id=\'discharge_checklist_app_yn\' id=\'discharge_checklist_app_yn\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'pat_check_in_allowed_yn\' id=\'pat_check_in_allowed_yn\' id=\'pat_check_in_allowed_yn\'\n\t\t\tvalue=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'room\' id=\'room\' value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\' /> <input type=\'hidden\'\n\t\t\tname=\'bedSelect\' id=\'bedSelect\' id=\'bedSelectId\' value=\'\' /> <input type=\'hidden\'\n\t\t\tname=\'encSelect\' id=\'encSelect\' id=\'encSelectId\' value=\'\' /> <input type=\'hidden\'\n\t\t\tname=\'cluetipOpenYN\' id=\'cluetipOpenYN\' id=\'cluetipOpenYNId\' value=\'N\' /> <input type=\'hidden\' name=\'jsp_name\' id=\'jsp_name\' value=\'\' /> <input type=\'hidden\'\n\t\t\tname=\'modal\' id=\'modal\' value=\"\"> <input type=\'hidden\'\n\t\t\tname=\'win_height\' id=\'win_height\' value=\"34\"> <input type=\'hidden\'\n\t\t\tname=\'win_width\' id=\'win_width\' value=\"50\"> <input type=\'hidden\'\n\t\t\tname=\'dialogTop\' id=\'dialogTop\' value=\"65\"> <input type=\'hidden\'\n\t\t\tname=\'module\' id=\'module\' value=\"\"> <input type=\'hidden\'\n\t\t\tname=\'model_window\' id=\'model_window\' value=\"\">\n\t\t\t\n\t\t\t<!--  hidden components  -->\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\" name=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\" value=\"";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\">\n\t\t\t<input type=\"hidden\" id=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t\n\t\t\t\n\t</form>\n\t<script>\n\t\t\t\n\t\t\tself.setInterval(\'checkAndRefreshPage()\',(";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="*60*1000));\n\t\t\tfunction checkAndRefreshPage(){\n\t\t\t\tif(typeof isBedBubbleShown != \'undefined\'){\n\t\t\t\t\tif(isBedBubbleShown == true){\n\t\t\t\t\t\treturn;\n\t\t\t\t\t}\t\n\t\t\t\t}\n\t\t\t\t\n\t\t\t\tparent.serachFrame.popDynamicValues(true);\t\t\t\t\n\t\t\t} \n\t\t\t\n\t\t\t$(document).ready(function() {\n\t\t\t\tscrollToSearchedPatient();\n\t\t     });\n\t\t\t\n\t\t</script>\n</body>\n";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n</html>\n";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );
public static String checkForNull(String inputString) {
		return (((inputString == null) || (inputString.equals("null"))) ? ""
				: inputString);
	}

	public static String checkForNull(String inputString, String defaultValue) {
		return (((inputString == null) || (inputString.equals("null"))) ? defaultValue
				: inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	/* String sStyle = checkForNull(
			(String) session.getAttribute("PREFERRED_STYLE"),
			"IeStyle.css"); */
	String nursingUnit = request.getParameter("nursingUnit") == null ? ""
			: request.getParameter("nursingUnit");
	// there is a need for the selected nursing unit description as well
	// this needs to be passed to inner page - ipadvbedmgmttooltip.jsp
	String nursingUnitDesc = request.getParameter("nursingUnitDesc");
	if(nursingUnitDesc == null){
		nursingUnitDesc = "";
	}
	String room = request.getParameter("room") == null ? "" : request
			.getParameter("room");
	request.setCharacterEncoding("UTF-8");
	Connection con = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	ArrayList floorRoomBedList = new ArrayList();
	String facility_id = (String) session.getAttribute("facility_id");
	String user_id = (String) session.getAttribute("login_user");
	
	// code added to get extra request parameters - these are required for
	// patient search related functionality
	String patSrchYN = request.getParameter(PatientSearchConstants.PATIENT_SRCH_REQUEST_PARAM_KEY);
	patSrchYN = CommonBean.checkForNull(patSrchYN);		
	String patSrchPatientId = request.getParameter(PatientSearchConstants.PATIENT_SRCH_PATIENTID_REQUEST_PARAM_KEY);
	patSrchPatientId = CommonBean.checkForNull(patSrchPatientId);
	String roomNumInSrch = request.getParameter(PatientSearchConstants.PATIENT_SRCH_ROOM_NUM_REQUEST_PARAM_KEY);
	roomNumInSrch = CommonBean.checkForNull(roomNumInSrch);
	String bedNumInSrch = request.getParameter(PatientSearchConstants.PATIENT_SRCH_BED_NUM_REQUEST_PARAM_KEY);
	bedNumInSrch = CommonBean.checkForNull(bedNumInSrch);
		
	String patSrchHighlightStyle = "";
	

            _bw.write(_wl_block3Bytes, _wl_block3);

	HashMap floorLayoutmap = new HashMap();
	String floorWidth = "0";
	String floorHeight = "0";
	String locale = (String) session.getAttribute("LOCALE");
	long beforeAllTime = System.currentTimeMillis();
	long afterConnTime = 0;
	long afterHugeQueryTime = 0;
	long afterAllQueryTime = 0;
	long beforeDataProcTime = 0;
	long afterDataProcTime = 0;
	Logger loggerInst = Logger.getLogger("APPLICATION_LOG");
	String logMessage = null;
	try {
		con = ConnectionManager.getConnection(request);
		afterConnTime = System.currentTimeMillis();
		//session.setAttribute("bl_operational", "N");
		//session.setAttribute("bl_install_yn", "N");
		String bl_operational = checkForNull(
				(String) session.getAttribute("bl_operational"), "N");
		// to get all rooms of nursing unit starts
		stmt = con.createStatement();
		floorRoomBedList = eIP.IPAdvBedMgmtBean
				.getNursingUnitRoomBedTrnsData(con, stmt, rs,
						nursingUnit, facility_id, locale, user_id,
						bl_operational);
		afterHugeQueryTime = System.currentTimeMillis();
		// to get all rooms of nursing unit ends
		floorLayoutmap = eIP.IPAdvBedMgmtConfigBean.getFloorLayout(con,
				facility_id, nursingUnit);
		floorWidth = (String) floorLayoutmap.get("floor_width");
		floorHeight = (String) floorLayoutmap.get("floor_height");
		String appl_patient_class = (String) floorLayoutmap
				.get("appl_patient_class");
		HashMap paramOprStnMap = eIP.IPAdvBedMgmtBean
				.getParamOprStnData(con, pstmt, rs, facility_id,
						user_id);
		afterAllQueryTime = System.currentTimeMillis();
		
		
		if(loggerInst != null){
			logMessage = "Nursing unit="+nursingUnit+";beforeAllTime="+beforeAllTime+",afterConnTime="+afterConnTime+",afterHugeQueryTime="+afterHugeQueryTime+",afterAllQueryTime="+afterAllQueryTime;
			loggerInst.debug(logMessage);
		}
		System.out.println("beforeAllTime="+beforeAllTime+",afterConnTime="+afterConnTime+",afterHugeQueryTime="+afterHugeQueryTime+",afterAllQueryTime="+afterAllQueryTime);
		
		String operStnId = (String) paramOprStnMap.get("oper_stn_id");
		String setup_bl_dtls_in_ip_yn = (String) paramOprStnMap
				.get("setup_bl_dtls_in_ip_yn");
		String bl_interfaced_yn = (String) paramOprStnMap
				.get("bl_interfaced_yn");
		String allow_discharge_date = (String) paramOprStnMap
				.get("allow_discharge_date");
		String chk_for_pen_orders_bfr_dis_adv = checkForNull(
				(String) paramOprStnMap
						.get("chk_for_pen_orders_bfr_dis_adv"),
				"N");
		String dis_adv_allow_yn = checkForNull(
				(String) paramOprStnMap.get("dis_adv_allow_yn"), "N");
		String chk_for_pen_orders_bfr_dis = checkForNull(
				(String) paramOprStnMap
						.get("chk_for_pen_orders_bfr_dis"),
				"N");
		String dis_allow_yn = checkForNull(
				(String) paramOprStnMap.get("dis_allow_yn"), "N");
		String max_disch_period_for_dc = (String) paramOprStnMap
				.get("max_disch_period_for_dc");
		String mother_cut_off_age = (String) paramOprStnMap
				.get("mother_cut_off_age");
		String mother_max_age = (String) paramOprStnMap
				.get("mother_max_age");
		String pat_check_in_allowed_yn = (String) paramOprStnMap
				.get("pat_check_in_allowed_yn");

		String disch_reason_mand_yn = (String) paramOprStnMap
				.get("disch_reason_mand_yn");
		String allow_late_discharge_reason = (String) paramOprStnMap
				.get("allow_late_discharge_reason");
		String deactivate_pseudo_bed_yn = (String) paramOprStnMap
				.get("deactivate_pseudo_bed_yn");
		String diag_update_period_max_unit = (String) paramOprStnMap
				.get("diag_update_period_max_unit");
		String dis_date_chk_days_unit = (String) paramOprStnMap
				.get("dis_date_chk_days_unit");
		String dis_date_chk_days = (String) paramOprStnMap
				.get("dis_date_chk_days");
		String bed_block_period_dis = (String) paramOprStnMap
				.get("bed_block_period_dis");
		String discharge_checklist_app_yn = (String) paramOprStnMap
				.get("discharge_checklist_app_yn");
		String refresh_interval = (String) paramOprStnMap
				.get("refresh_interval");
		// this will be set with the room number value obtained from the bean
		String roomNumber = "";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(floorWidth));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(floorHeight));
            _bw.write(_wl_block6Bytes, _wl_block6);

					if (floorRoomBedList.size() > 0) {
							beforeDataProcTime = System.currentTimeMillis();
							Iterator iterator = floorRoomBedList.iterator();
							int roomCounter = 0;
							while (iterator.hasNext()) {
								HashMap tempMap = (HashMap) iterator.next();
								roomNumber = (String) tempMap.get("roomNo");
								String roomName = (String) tempMap.get("roomName");
								String room_clr = (String) tempMap.get("room_clr");
								String roomTopPos = (String) tempMap.get("roomTopPos");
								String roomLeftPos = (String) tempMap
										.get("roomLeftPos");
								String roomWidth = (String) tempMap.get("roomWidth");
								String roomHeight = (String) tempMap.get("roomHeight");
								ArrayList roomBedsList = (ArrayList) tempMap
										.get("roomBedsList");
								int roomHeight1 = Integer.parseInt(roomHeight) - 20;
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(roomNumber ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(roomTopPos));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(roomLeftPos));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(roomWidth));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(roomHeight));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(room_clr));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(roomName));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(roomHeight1));
            _bw.write(_wl_block14Bytes, _wl_block14);

							if (roomBedsList != null && roomBedsList.size() > 0) {
											Iterator bedItr = roomBedsList.iterator();
											while (bedItr.hasNext()) {
												HashMap roomBedsMap = (HashMap) bedItr.next();
												//System.out.println("roomBedsMap:"+roomBedsMap.toString());
												String bedNo = (String) roomBedsMap
														.get("bedNo");
												String bedClock = (String) roomBedsMap
														.get("bedClock");
												String bedColorExt = (String) roomBedsMap
														.get("bedColorExt");
												String disc_bill_exists = (String) roomBedsMap
														.get("disc_bill_exists");
												String bedTopPos = (String) roomBedsMap
														.get("bedTopPos");
												String bedLeftPos = (String) roomBedsMap
														.get("bedLeftPos");
												String bedWidth = (String) roomBedsMap
														.get("bedWidth");
												String bedHeight = (String) roomBedsMap
														.get("bedHeight");
												String bedColor = (String) (roomBedsMap
														.get("bedColor") == null ? ""
														: roomBedsMap.get("bedColor"));
												//String bookingType = (String)(roomBedsMap.get("bookingType")==null?"":roomBedsMap.get("bookingType"));
												String bedStatus = (String) (roomBedsMap
														.get("bedStatus") == null ? ""
														: roomBedsMap.get("bedStatus"));
												String bedTextColor = (String) (roomBedsMap
														.get("bedTextColor") == null ? "white"
														: roomBedsMap.get("bedTextColor"));
												String trnsAllowed = (String) (roomBedsMap
														.get("trnsAllowed") == null ? "Y"
														: roomBedsMap.get("trnsAllowed"));
												String gender = (String) (roomBedsMap
														.get("gender") == null ? ""
														: roomBedsMap.get("gender"));
												//System.out.println("bedNo @jsp:"+bedNo);
												//System.out.println("bedClock @jsp:"+bedClock);
												//System.out.println("bedColor @jsp:"+bedColor);
												//System.out.println("bedColorExt @jsp:"+bedColorExt);
												if (bedColorExt.equals("")) {
													bedColorExt = bedColor;
												}
												if (gender.equals("M")) {
													gender = MessageManager.getLabel(locale,
															"Common.male.label", "Common");
												} else if (gender.equals("F")) {
													gender = MessageManager.getLabel(locale,
															"Common.female.label", "Common");
												} else if (gender.equals("U")) {
													gender = MessageManager.getLabel(locale,
															"Common.unknown.label", "Common");
												}
												String pat_age = (String) (roomBedsMap
														.get("pat_age") == null ? ""
														: roomBedsMap.get("pat_age"));
												String patient_id = (String) (roomBedsMap
														.get("patient_id") == null ? ""
														: roomBedsMap.get("patient_id"));
												String patient_name = (String) (roomBedsMap
														.get("patient_name") == null ? ""
														: roomBedsMap.get("patient_name"));
												String KNOWN_ALLERGY_YN = (String) (roomBedsMap
														.get("KNOWN_ALLERGY_YN") == null ? ""
														: roomBedsMap.get("KNOWN_ALLERGY_YN"));
												String overdue_count = (String) (roomBedsMap
														.get("overdue_count"));
												String overdue_time = (String) (roomBedsMap
														.get("overdue_time"));
												String due_count = (String) (roomBedsMap
														.get("due_count"));
												String due_time = (String) (roomBedsMap
														.get("due_time"));
												int abnormal_rslt_count = ((Integer) roomBedsMap
														.get("abnormal_rslt_count")).intValue();
												
												int ost_orders_count=Integer.parseInt((String)(roomBedsMap.get("ost_orders_count")==null?"0":roomBedsMap.get("ost_orders_count")));
												
												//int abnormal_rslt_count=(Integer)roomBedsMap.get("abnormal_rslt_count");
												//System.out.println("AA:"+(Integer)roomBedsMap.get("abnormal_rslt_count"));
												//overdue_count="1";
												//due_count="1";
												//abnormal_rslt_count=1; 
												String practitioner_name = (String) (roomBedsMap
														.get("practitioner_name") == null ? ""
														: roomBedsMap.get("practitioner_name"));
												String admission_date_time = (String) (roomBedsMap
														.get("admission_date_time") == null ? ""
														: roomBedsMap
																.get("admission_date_time"));
												String exp_discharge_date_time = (String) (roomBedsMap
														.get("exp_discharge_date_time") == null ? ""
														: roomBedsMap
																.get("exp_discharge_date_time"));
												String encounter_id = (String) (roomBedsMap
														.get("encounter_id") == null ? ""
														: roomBedsMap.get("encounter_id"));
												String bed_class_short_desc = (String) (roomBedsMap
														.get("bed_class_short_desc") == null ? ""
														: roomBedsMap
																.get("bed_class_short_desc"));
												String bed_type_short_desc = (String) (roomBedsMap
														.get("bed_type_short_desc") == null ? ""
														: roomBedsMap
																.get("bed_type_short_desc"));
												//System.out.println("Data @"+bedNo+":overdue_count:"+overdue_count+":overdue_time:"+overdue_time+":due_count:"+due_count+":due_time:"+due_time+":");
												if (/*(bookingType.equals("T")||bookingType.equals("N")||bookingType.equals("L")||bookingType.equals("B")) &&*/bedStatus
														.equals("B")
														&& (!encounter_id.equals(""))) {
													encounter_id = "";
												}
												
												// code added to high light the bed
												// var to hold the style applied to the bed
												String bedStyle = "top:"+bedTopPos+"px; left:"+bedLeftPos+"px;width:"+bedWidth+"px; height:"+bedHeight+"px;background-color:"+bedColor+";";
												// this is the width and the height that will be set to the 
												// inner div
												String innerDivWidthStr = bedWidth;
												int innerDivWidth = 0;
												try{
													innerDivWidth = Integer.parseInt(innerDivWidthStr);
													innerDivWidth -= 4;
													innerDivWidthStr = innerDivWidth+"";
												}catch(NumberFormatException nex){
													// nothing much can be done
												}
												
												String innerDivHeightStr = bedHeight;
												int innerDivHeight = 0;
												try{
													innerDivHeight = Integer.parseInt(innerDivHeightStr);
													innerDivHeight -= (2*5);
													innerDivHeightStr = innerDivHeight+"";
												}catch(NumberFormatException nex){
													// nothing much can be done
												}
												
												
												String innerDivStyle = "bedinnerdiv";
												String bedStyleClass = "bedWOHighlight";
												String bedToponeClass = "bedtopone";
												String bedToptwoClass = "bedtoptwo";
												String bedTopthreeClass = "bedtopthree";
												String bedTopfourClass = "bedtopfour";
												String bedTopfiveClass = "bedtopfive";
												String bedBottomoneClass = "bedbottomone";
												String bedBottomtwoClass = "bedbottomtwo";
												String bedBottomthreeClass = "bedbottomthree";
												String bedBottomfourClass = "bedbottomfour";
												String bedBottomfiveClass = "bedbottomfive";
												
												boolean highlightNeeded = false;
												// check if patient search parameters are set
												// this implies user has searched for a patient
												// in this case the bed should be highlighted
												if(PatientSearchConstants.PATIENT_SRCH_REQUEST_VALUE.equalsIgnoreCase(patSrchYN) 
																				&& patSrchPatientId.equals(patient_id)){
													highlightNeeded = true;
													//bedStyle += "border:2px #0000DD solid";
													bedStyleClass = "bedWithHighlight";
													
													innerDivStyle = "bedhighlightinnerdiv";
													bedToponeClass = "bedhighlighttopone";
													bedToptwoClass = "bedhighlighttoptwo";
													bedTopthreeClass = "bedhighlighttopthree";
													bedTopfourClass = "bedhighlighttopfour";
													bedTopfiveClass = "bedhighlighttopfive";
													bedBottomoneClass = "bedhighlightbottomone";
													bedBottomtwoClass = "bedhighlightbottomtwo";
													bedBottomthreeClass = "bedhighlightbottomthree";
													bedBottomfourClass = "bedhighlightbottomfour";
													bedBottomfiveClass = "bedhighlightbottomfive";
													
													// code added to set the room num and the bed num values
													// used in patient search functionality
													// this is needed to reset the old selected beds
													if("".equals(roomNumInSrch.trim())){
														roomNumInSrch = roomNumber;
													}
													
													if("".equals(bedNumInSrch.trim())){
														bedNumInSrch = bedNo;
													}
												}
												
												
												
												
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedStyleClass ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bedStyle));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(nursingUnit));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(appl_patient_class));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(operStnId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(trnsAllowed));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(KNOWN_ALLERGY_YN));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(overdue_count));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(due_count));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(abnormal_rslt_count));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(nursingUnitDesc ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(roomNumber ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(roomName ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(room_clr));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedToponeClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedColor));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedToptwoClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedColor));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedTopthreeClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedColor));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedTopfourClass));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bedColor));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedTopfiveClass));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bedColor));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(innerDivStyle));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(innerDivWidthStr ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(innerDivHeightStr ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(bedTextColor));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(bedTextColor));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block48Bytes, _wl_block48);

										if (trnsAllowed.equals("N")) {
								
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block50Bytes, _wl_block50);

											if (!encounter_id.equals("")) {
										
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pat_age));
            _bw.write(_wl_block50Bytes, _wl_block50);

											}
										
            _bw.write(_wl_block53Bytes, _wl_block53);

										} else {
								
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block57Bytes, _wl_block57);

											if (!encounter_id.equals("")) {
										
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(pat_age));
            _bw.write(_wl_block50Bytes, _wl_block50);

											}
										
            _bw.write(_wl_block53Bytes, _wl_block53);

										}
								
            _bw.write(_wl_block59Bytes, _wl_block59);

											if (KNOWN_ALLERGY_YN.equals("Y")) {
										
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block62Bytes, _wl_block62);

											} 
										
            _bw.write(_wl_block63Bytes, _wl_block63);

										if (disc_bill_exists.equals("Y")) {
										
            _bw.write(_wl_block64Bytes, _wl_block64);

											} 
										
            _bw.write(_wl_block65Bytes, _wl_block65);

											if (!bedClock.equals("")) {
										
            _bw.write(_wl_block66Bytes, _wl_block66);

											} 																
										
            _bw.write(_wl_block67Bytes, _wl_block67);

											if (Integer.parseInt(overdue_count) > 0) {
										
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(overdue_time));
            _bw.write(_wl_block69Bytes, _wl_block69);

											} 
										
            _bw.write(_wl_block50Bytes, _wl_block50);

											if (Integer.parseInt(due_count) > 0) {
										
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(due_time));
            _bw.write(_wl_block69Bytes, _wl_block69);

											} 
										
            _bw.write(_wl_block50Bytes, _wl_block50);

											if (abnormal_rslt_count > 0) {
										
            _bw.write(_wl_block71Bytes, _wl_block71);

											} 
										
            _bw.write(_wl_block67Bytes, _wl_block67);

											if(ost_orders_count > 0) {
										
            _bw.write(_wl_block72Bytes, _wl_block72);

											}
										
            _bw.write(_wl_block73Bytes, _wl_block73);
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(bedColorExt));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(room_clr));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedBottomoneClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedColorExt));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedBottomtwoClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedColorExt));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedBottomthreeClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedColorExt));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedBottomfourClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedColorExt));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(roomNumber ));
            out.print( String.valueOf(bedNo));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bedBottomfiveClass));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bedColorExt));
            _bw.write(_wl_block81Bytes, _wl_block81);

							}//while loop for roomBedsList ends
										}//if condition roomBedsList ends
						
            _bw.write(_wl_block82Bytes, _wl_block82);

					roomCounter++;
							}//while loop for floorRoomBedList ends
							afterDataProcTime = System.currentTimeMillis();
							if(loggerInst != null){
								logMessage = "Nursing unit="+nursingUnit+";beforeDataProcTime="+beforeDataProcTime+";afterDataProcTime="+afterDataProcTime;
								loggerInst.debug(logMessage);
							}
							System.out.println("beforeDataProcTime="+beforeDataProcTime+";afterDataProcTime="+afterDataProcTime);
						}//if condition floorRoomBedList ends
				
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(nursingUnit));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(setup_bl_dtls_in_ip_yn));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(bl_interfaced_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(allow_discharge_date));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(chk_for_pen_orders_bfr_dis_adv));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(dis_adv_allow_yn));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(chk_for_pen_orders_bfr_dis));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(dis_allow_yn));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(max_disch_period_for_dc));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(mother_cut_off_age));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(mother_max_age));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(disch_reason_mand_yn));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(allow_late_discharge_reason));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(deactivate_pseudo_bed_yn));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(diag_update_period_max_unit));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(dis_date_chk_days_unit));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(dis_date_chk_days));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(bed_block_period_dis));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(discharge_checklist_app_yn));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(pat_check_in_allowed_yn));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(room));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(patSrchYN));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_PATIENTID_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_PATIENTID_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(patSrchPatientId));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_ROOM_NUM_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_ROOM_NUM_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(roomNumInSrch));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_BED_NUM_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(PatientSearchConstants.PATIENT_SRCH_BED_NUM_REQUEST_PARAM_KEY ));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(bedNumInSrch));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(refresh_interval));
            _bw.write(_wl_block111Bytes, _wl_block111);

	} catch (Exception ex) {
		ex.printStackTrace();
	} finally {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (pstmt != null)
				pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (con != null)
			ConnectionManager.returnConnection(con, request);
	}

            _bw.write(_wl_block112Bytes, _wl_block112);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
