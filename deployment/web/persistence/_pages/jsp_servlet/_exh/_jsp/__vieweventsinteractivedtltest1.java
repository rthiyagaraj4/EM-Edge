package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.net.*;
import java.util.*;
import java.lang.String;
import java.util.ArrayList;
import eXH.XHDBAdapter;
import eXH.*;
import java.util.*;
import com.ehis.util.*;

public final class __vieweventsinteractivedtltest1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewEventsInteractiveDtlTest1.jsp", 1742550740486L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\t\t\t\t\t\t\t\t\t  \n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<style>\n\tdiv {float: left}\n\t/*\n\t.testSty \t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t{ \n\t\twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t\twidth: auto;\n\t\twhite-space: nowrap;\n\t}\n\t*/\n\t.left_child{\n\t\twidth:1365px;\n\t\toverflow-x:scroll;\n\t }\n</style>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<script language=\'javascript\' src=\"../../eCommon/js/common.js\"></script>\n<script Language=\"JavaScript\"  src=\"../../eCommon/js/ValidateControl.js\" ></script>\n<script Language=\"javascript\" src=\"../../eXH/js/Viewtreeimage.js\"></script>\n\n \n<SCRIPT language=\'javascript\' src=\'../../eXH/js/menu.js\'></script>\n<Script Language=\'JavaScript\'> \n//function funSubmit\nfunction funSubmit()\n{\n\tparent.f_query_add_mod.VIEW_EVENTS.action = \'../../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp\';\n\tparent.f_query_add_mod.VIEW_EVENTS.target=\"f_query_add_mod\";\n\tparent.f_query_add_mod.VIEW_EVENTS.submit();\n}\n//function funModify\nfunction funModify(obj)\n{\n\tparent.commontoolbarFrame.document.forms[0].apply.style.display=\'block\';\t\t\t\t\t\t\t\t  \n}\n//function changeMe\nfunction changeMe(msgId) \n{\n   document.getElementById(\'msgId\').style.color = \"green\";\n}\n//function doChanges\nfunction doChanges() \n{\n   this.document.forms[0].action=\"../../eXH/jsp/ViewEventsOutboundDtlTest1.jsp\";\n   this.document.forms[0].target = \"f_query_add_mod\";\n   this.document.forms[0].submit();\n\t\t  \n   window.event.target.style.color = \"green\";\n   window.event.target.style.font = \"bold\";\n   window.event.target.style.fontSize = \"15px\";\n} \n//function funAction\nfunction funAction(typ)\n{  \n\tparent.f_query_add_mod.VIEW_EVENTS.action_type.value = typ;\n\tfunSubmit();\n\t\n}\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\n\n\tif (obj==\"Message_ID\")\n\t{\t\t\n\t\tif(order == \'A\') obj = \"MESSAGE_DATE ASC, \"+ obj + \' asc\';\t\t\t\t\t\t\t\t\t\t\t\t\t     \n\t\tif(order == \'D\') obj = \"MESSAGE_DATE DESC, \"+ obj + \' desc\';\t\t\n\t}\n\telse\n\t{\n\t\tif(order == \'A\') obj =  obj + \' asc,\'+\"MESSAGE_DATE ASC\";\t\t\t\t\t\t\t\t\t\t\t\t\t     \n\t\tif(order == \'D\') obj =  obj + \' desc,\'+\"MESSAGE_DATE DESC\";\t\n\t}\n\t\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\tthis.document.forms[0].action=\"../../eXH/jsp/ViewEventsInteractiveDtlTest1.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n\tparent.frames[2].document.href=\'../../eCommon/html/blank.html\';\t\t\t\t\t\t\t   \n}\n\n\nfunction  func1(message_id,application_id,  facility_id,request_date,  event_type, patient_id, merged_patient_id, episode_type, encounter_id, accession_num, ext_accession_num,   profile_id,Reason,Process_id,added_at_ws_no)\n{\n\n}\n\n\n \n</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n  \n<body onLoad=\'funonload()\' >\n<form name=\"VIEW_EVENTS\" id=\"VIEW_EVENTS\" method=\"POST\" action=\'\'  >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t<script>\n\t//\tparent.f_query_footer.location.href=\'../../eCommon/html/blank.html\';\n\t\talert(getMessage(\'XH1021\',\'XH\'));\n\t\thistory.go(-1);\n\t\t/*var function_id=parent.document.getElementById(\"function_id\").value;\n\t\tparent.f_query_add_mod.location.href=\'../../eXH/jsp/ViewEventsOutboundHeader.jsp?function_id=\'+function_id;\n\t\tparent.messageFrame.location.href=\'../../eCommon/jsp/MstCodeError.jsp\';\t   */\n\n\t</script>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\t\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\n<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n<tr>\n\t<td colspan=\"27\" class=\"COLUMNHEADER\" align=\'center\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n</tr>\n<tr>\t   \n<td align=\"left\" class=\"CAGROUP\">\n\t\t<A class=\'linkClass1\'   style=\'cursor:pointer\' onClick=\"editQuery();\" TITLE=\"Edit Query\"> \n\t\t\tEditQuery\n\t\t</A>\n\t\t<A class=\'linkClass1\'  style=\'cursor:pointer\' onClick=\"refreshResults(\'ViewEventsInteractiveDtlTest1\');\" TITLE=\"Refresh Events\">\n\t\t\tRefresh\n\t\t</A>\n\t\t</td>\n\t<!--<td align=\"left\" class=\"CAGROUP\">\t\t\t\t\t\t\t\t\t\t\t\t\t  \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"editQuery();\" TITLE=\"Edit query criteria\">\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</A>\n\t</td>-->\n\t<td align=\"right\" class=\"CAGROUP\" > \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</A>\n\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</A>\n\t</td>\n</tr>\n</table>\n\n\t<div id=\"left_child\" class=\"left_child\">\n<table id=\"table1\" cellspacing=0 cellpadding=3 border=1 width=\"100%\" style=\"overflow-y:scroll;overflow:-moz-scrollbars-vertical;display:block;\">\t\n\t\n\t\t\n\t   \t<tr>\n\t    <td class=\'COLUMNHEADER\' nowrap>\n\t\t\t<font color=white>$</font>\n\t\t</td>\t\t\t\t\t\t\t\t    \n\t\t<!---MESSAGE_ID0----> \n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'Message_ID\',\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\');\" onclick=\'\'>\n\t\t<font color=white>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font>\n\t\t</td>\n\t\t<!---APPLICATION_ID3--->\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'APPLICATION_ID\',\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\');\"onclick=\'\'>\n\t\t<font color=white>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</font>\n\t\t</td>\n\t\t <!----FACILITY_ID4----->\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'FACILITY_ID\',\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\');\"onclick=\'\' >\n\t\t<font color=white>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</font>\n\t\t</td>\n\t\t\t<!-----2----->\n\t\t<!--\t<td class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ACK_Message_ID\',\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</font>\n\t\t</td>---->\n        <!-----EVENT_TYPE6----->\n\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'EVENT_TYPE\',\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</font>\n\t\t</td>\n        <!----PGM_ID------>\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'PGM_ID\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</font>\n\t\t</td> \n        <!------PROFILE_ID13---->\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'PROFILE_ID\',\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font>\n\t\t</td>\n\t    <!------ACCESSION_NUM11---->\n        <td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ACCESSION_NUM\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\n\t\t</td>\n        <!------EXT_ACCESSION_NUM12---->\n\t\t<td class=\'COLUMNHEADER\' nowrap>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'EXT_ACCESSION_NUM\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font>\n\t\t</td>\n\t\t<!------PATIENT_ID7---->\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_ID\',\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font>\n\t\t</td>\n        <!-----ENCOUNTER_ID10----->\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ENCOUNTER_ID\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>\n\t\t</td>\n        <!-----ADDED_BY_ID14----->\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ADDED_BY_ID\',\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font>\n\t\t</td>\n\t\t<!-----ADDED_DATE15----->\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ADDED_DATE\',\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font>\n\t\t</td>\n\t\n\t\t<!----MODIFIED_BY_ID16------>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MODIFIED_BY_ID\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="</font>\n\t\t</td>\n\t\t<!-----MODIFIED_DATE17----->\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MODIFIED_DATE\',\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font>\n\t\t</td>\n\t\t<!-----ADDED_AT_WS_NO18----->\n\t\t <td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ADDED_AT_WS_NO\',\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font>\n\t\t</td>\n\t\t<!-----ADDED_FACILITY_ID19-----> \n\t\t\n\t\t <td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ADDED_FACILITY_ID\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font>\n\t\t</td>\n\t\t<!-----MODIFIED_AT_WS_NO20----->\n\t\t<td  nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MODIFIED_AT_WS_NO\',\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font>\n\t\t</td>\n\t\t<!-----MODIFIED_FACILITY_ID21----->\n\t\t <td nowrap class=\'COLUMNHEADER\'>\n\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MODIFIED_FACILITY_ID\',\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</font>\n\t\t</td>\n\n\t</tr>\n\n  ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\n\n<tr id=\"testID\" >\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" align=\"center\" ><font size=1 >&nbsp;<img src=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\' height=10 ></td>\n        <!----Messsge Id------> \n\t\t<td nowrap  ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="  id=\'mes";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'  align=\"left\"  onClick=\'changeMe(\"mes\"+ ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 =")\'  onMouseDown=\"buildIIMenuList(\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\',\n\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\', \'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\',\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\',\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\',\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\');\">  \n<font size=1 color=\"blue\">&nbsp;";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t</font> \n\t\t</td>  \n\t\t<!------Applictaion----> \n\t\t<td nowrap  ";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 =" align=\"center\" ><font size=1 >&nbsp;";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t<!-----Facility----->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</td>\n\t\n\t\t<!-----Event type----->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="</td>\n\t\t<!----PGM_id------>\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n\t\t<!---profile------->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n\t\t<!------ACC.no---->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</td>\n\t\t<!------ex.acc---->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</td>\n\t\t\n\t\t<!-- Added by Sethu -->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</td>\n\n\t\t<!----encounterid------>\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td>\n\t\t<!-------added--->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="</td>\n\t\t<!-----addeddat----->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td>\n\t\t<!---------->\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 =" align=\"center\"><font size=1 >&nbsp;";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</td>\n\n\n\t\t<td nowrap  ";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</td>\n\n\n\t</tr>\n\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t    \n</table>\n</div>\n \n \n<table width=\"100%\" id=\"indicatorTable\">\n\t<tr><td></td></tr>\n\t</table>\n\t\t<input type=\'hidden\' name=\'purge_status\' id=\'purge_status\' id=\'purge_status\'  value=\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\'> \n\t\t<input type=\'hidden\' name=\'msg_status\' id=\'msg_status\' value=";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 =" >\n\t\t<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>\n\t\t<input type=\'hidden\' name=\'temp\' id=\'temp\' value=\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\'>\n\t\t<input type=\'hidden\' name=\'facility\' id=\'facility\' value=";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =">\n\t\t<input type=\'hidden\' name=\'msg_id1\' id=\'msg_id1\' value=";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =">\n\t\t<input type=\'hidden\' name=\'msg_dt1\' id=\'msg_dt1\' value=";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 =">\n\t\t<input type=\'hidden\' name=\'msg_id2\' id=\'msg_id2\' value=";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 =">\n\t\t<input type=\'hidden\' name=\'msg_dt2\' id=\'msg_dt2\' value=";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =">\n\t\t<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' id=\'orderBy\' value=";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 =">\n\t\t<input type=\'hidden\' name=\'order\' id=\'order\' value=";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =">\n\t\t<input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' value=";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 =">\n\t\t<input type=\'hidden\' name=\'merg_pat_id\' id=\'merg_pat_id\' value=";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 =">\t\t  \n\t\t<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 =">\n\t\t<input type=\'hidden\' name=\'episode_id\' id=\'episode_id\' value=";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =">\n\t\t<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =">\n\t\t<input type=\'hidden\' name=\'action_typ\' id=\'action_typ\' value=";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =">\n\t\t<input type=\'hidden\' name=\'last_processed_date\' id=\'last_processed_date\' value=";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =">\n\t\t<input type=\'hidden\' name=\'not_req_rsn\' id=\'not_req_rsn\' value=";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =">\n\t\t<input type=\'hidden\' name=\'addid\' id=\'addid\' value=";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =">\n\t\t<input type=\'hidden\' name=\'addeddate\' id=\'addeddate\' value=";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =">\n\t\t<input type=\'hidden\' name=\'addedwsno\' id=\'addedwsno\' value=";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =">\n\t\t<input type=\'hidden\' name=\'modfid\' id=\'modfid\' value=";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 =">\n\t\t<input type=\'hidden\' name=\'modifieddate\' id=\'modifieddate\' value=";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =">\n\t\t<input type=\'hidden\' name=\'modifiedwsno\' id=\'modifiedwsno\' value=";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =">\n\t\t<input type=\'hidden\' name=\'msg_date\' id=\'msg_date\' value=";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 =">\n\t\t<input type=\'hidden\' name=\'applnname\' id=\'applnname\' value=";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =">\n\t\t<input type=\'hidden\' name=\'eventtype\' id=\'eventtype\' value=";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 =">\n\t\t\t  \n\t\t<input type=\'hidden\' name=\'event_status\' id=\'event_status\' value=\'";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\'>\t\t \n\t\t<input type=\'hidden\' name=\'externalAccNo\' id=\'externalAccNo\' value=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>\n\t\t<input type=\'hidden\' name=\'interface_module\' id=\'interface_module\' value=\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\'>\n\t\t<input type=\'hidden\' name=\'tableNameSuffix\' id=\'tableNameSuffix\' value=\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\'>\n\t\t<input type=\'hidden\' name=\'sub_module\' id=\'sub_module\' value=\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\'>\n\t\t<input type=\'hidden\' name=\'comm_mode\' id=\'comm_mode\' value=\'Outbound\'>\n\t\t<input type=\'hidden\' name=\'rebuildAut\' id=\'rebuildAut\' id=\"rebuildAut\" value=\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\'>\t\t\t   \n       <input type=\'hidden\' name=\'replayAut\' id=\'replayAut\' id=\"replayAut\" value=\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\'>\n       <input type=\'hidden\' name=\'commExpAut\' id=\'commExpAut\' id=\"commExpAut\" value=\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\'>\n        <input type=\'hidden\' name=\'audtiAut\' id=\'audtiAut\' id=\"audtiAut\" value=\'";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\'>\n\t\t<input type=\'hidden\' name=\'viewAuth\' id=\'viewAuth\' id=\"viewAuth\" value=\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\'>\n\t\t<input type=\'hidden\' name=\'protocol_link_id\' id=\'protocol_link_id\' id=\"protocol_link_id\" value=\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\'>\n\t\t <input type=\'hidden\' name=\'pmode\' id=\'pmode\' id=\"pmode\" value=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>   \n\t\t\t <input type=\'hidden\' name=\'function_id\' id=\'function_id\' id=\"function_id\" value=\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\'>   \t\t\n</form>\n";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\n</html>\n\n\n";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
 String locale = ((String)session.getAttribute("LOCALE"));	
            _bw.write(_wl_block5Bytes, _wl_block5);
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
		Statement s=null;																			    
		ResultSet r=null;
		String res_txt=null;
		String status=null;
		Properties p = (Properties) session.getValue("jdbc");
		String loggedUser = p.getProperty("login_user");

		String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order;
		String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause,pmode,eventStatus;
		//String applicationName="";
		//String facilityName="";
		String orderBy;
		String function_id=XHDBAdapter.checkNull(request.getParameter("function_id"));
		String tableNameSuffix= "";
		msg_status=null;
		facility=null;									    
		msg_id1=null;						    							  
		msg_dt1=null;
		msg_id2=null;
		msg_dt2=null;
		order=null; 
		orderBy=null;	
		tabValue=null;
		//statusColor=null;
		pat_id=null;
		merg_pat_id=null;
		episode_type=null;
		episode_id=null;
		visit_id=null;
		action_typ=null;
		last_processed_date=null;
		not_req_rsn=null;
		addid=null;
		addeddate=null;
		addedwsno=null;
		modfid=null;
		modifieddate=null;
		modifiedwsno=null;
		msg_date=null;
		applnname=null;
		eventtype=null;
		eventStatus=null;
		whereClause=null;
		String action_type=null;
		String temp=null;
		String interface_module=null;
		String sub_module = null;
		pmode=null;
		String externalAccNo = null;
		String purge_status = null;
		String protocol_link_ID = null;

            _bw.write(_wl_block8Bytes, _wl_block8);

  boolean boolToggle =  true;	
  String strTDClass = "";
  Connection conn = null;
  	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToRebuild = false;
	boolean authToReplay = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;
	
  try
  {   
	 action_type=request.getParameter("action_type");
  	 msg_status=request.getParameter("msg_status");
	 facility =request.getParameter("facility"); 
     msg_id1 =request.getParameter("msg_id1"); 
 	 msg_id2 =request.getParameter("msg_id2");  
     msg_dt1 =request.getParameter("msg_dt1"); 
 	 msg_dt2 =request.getParameter("msg_dt2"); 				 
	 orderBy =request.getParameter("orderBy");
     order=request.getParameter("order");
     tabValue=request.getParameter("tabValue");
     pat_id=request.getParameter("pat_id");
     merg_pat_id=request.getParameter("merg_pat_id");
     episode_type=request.getParameter("episode_type");
     episode_id=request.getParameter("episode_id");
     visit_id=request.getParameter("visit_id"); 
     action_typ=request.getParameter("action_typ");
	 last_processed_date=request.getParameter("last_processed_date");
	 not_req_rsn=request.getParameter("not_req_rsn");
	 addid=request.getParameter("addid");
	 addeddate=request.getParameter("addeddate");
	 addedwsno=request.getParameter("addedwsno");
	 modfid=request.getParameter("modfid");
	 modifieddate=request.getParameter("modifieddate");
	 modifiedwsno=request.getParameter("modifiedwsno");
	 msg_date=request.getParameter("msg_date");
	 eventtype=request.getParameter("eventtype");
	 applnname=request.getParameter("applnname");
	 interface_module = request.getParameter("interface_module");
	 sub_module = request.getParameter("sub_module");
									 
	 eventStatus= request.getParameter("event_status");												  
	 externalAccNo = request.getParameter("externalAccNo");
	 purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));
	 protocol_link_ID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));
	 pmode=request.getParameter("pmode");	
    whereClause=XHDBAdapter.checkNull(request.getParameter("wherecaluse"));
	
	
try
{
	conn = ConnectionManager.getConnection(request);
}
catch(Exception e)
{
	System.out.println("Errors in Connection "+e); 
}
  String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE LOGIN_NAME='"+loggedUser+"'"; 
	
	ResultSet authRS = null;



	try
	{
		
		authRS = conn.createStatement().executeQuery(authSql);
		if(authRS.next())
		{		
			String strAutRebuild = authRS.getString("rebuild_yn");
			String strAutReplay = authRS.getString("replay_yn");
			String strAutCommExp = authRS.getString("comm_exception_yn");
			String strXlsAuth = authRS.getString("write_to_excel");
			String strAudit = authRS.getString("audit_yn");
			String strView = authRS.getString("view_yn");
			
			if(strAutRebuild != null && strAutRebuild.equalsIgnoreCase("Y")) authToRebuild = true;	
			if(strAutReplay != null && strAutReplay.equalsIgnoreCase("Y")) authToReplay = true;	
			if(strAutCommExp != null && strAutCommExp.equalsIgnoreCase("Y")) authToVwCommErr = true;
			if(strXlsAuth != null && strXlsAuth.equalsIgnoreCase("Y")) xlsAuth = true;
			if(strAudit != null && strAudit.equalsIgnoreCase("Y")) authToAudit = true;
			if(strView != null && strView.equalsIgnoreCase("Y")) viewAuth = true;
		}

		
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
	finally
	{
		if(authRS != null) authRS.close();
	}

	 tableNameSuffix="";
	 if(pmode!=null)
	 {
	        if(pmode.equalsIgnoreCase("F"))
	        {
               if(locale.equalsIgnoreCase("th"))
				{
			      msg_dt1=com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
			      msg_dt2=com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
			      addeddate=com.ehis.util.DateUtils.convertDate(addeddate,"DMY","th","en");
                  modifieddate=com.ehis.util.DateUtils.convertDate(modifieddate,"DMY","th","en");
		          msg_date=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","th","en");
		         }
	         }
			 if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
				

				 if(purge_status.equals(""))
				 {
				   tableNameSuffix = "XH_INTERACTIVE_INTEGRATION a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";		  
				 }																				 
				 else
				 {

					tableNameSuffix = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN a,XH_EVENT_APPL_MESSAGE_VW b where a.APPLICATION_ID=b.APPLICATION_ID(+)";
				 }
					
				// request.setAttribute("purge_status","Y");	   			   			  
			 }														   
	 }																					   


	System.out.println(" VIEWXHINTERACTIVE tableNameSuffix ::: "+tableNameSuffix);
	
	if(whereClause.equals("") || whereClause==null)
	{
	 boolean flag =false;	
	 whereClause =" ";																			   
	 //facility																							 
	 if((facility != null ) && (!(facility.equals(""))))			
	 {
	 	 whereClause =whereClause +"And  a.FACILITY_ID = NVL('#facility',a.FACILITY_ID)";
		 flag=true;
 	 } 
	 //application_id
	 if((applnname != null) && (!(applnname.equals(""))))			
	 {
	   	 whereClause =whereClause + " AND a.APPLICATION_ID IN (NVL('#applnname',a.APPLICATION_ID),'*A')";
 	 } 
	
	if((eventtype != null) && (!(eventtype.equals(""))))			
	{
	 	  whereClause =whereClause + " AND a.EVENT_TYPE = NVL('#eventtype',a.EVENT_TYPE)";
 	} 

	if((msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND TO_NUMBER(a.message_id) >="+ 	
								"  nvl(lpad('"+msg_id1+"',20),a.message_id)";
			}
			else															 
			{
				whereClause =whereClause +" AND TO_NUMBER(a.message_id) BETWEEN"+ 	
								"  nvl('"+msg_id1+"',a.message_id) AND nvl('"+msg_id2+"',a.message_id)";
			}
		} 
		
		if((msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" AND TO_NUMBER(a.message_id) <"+ 	
								"  nvl('"+msg_id2+"',a.message_id)";
			}																					 
		} 

	if((episode_type != null) && (!(episode_type.equals(""))))			
	{
		whereClause =whereClause +"AND a.EPISODE_TYPE= NVL('#episode_type' ,a.EPISODE_TYPE)";
	} 																							  
				
	if((episode_id != null) && (!(episode_id.equals(""))))			
	{
	   whereClause =whereClause +" AND a.EPISODE_ID = NVL('#episode_id',a.EPISODE_ID)";
	} 
		
	if(action_typ != null)
	{
		action_typ=action_typ.trim();	
	}
	 if((action_typ != null) && (!(action_typ.equals(""))))		
	 {
	 	whereClause =whereClause +"  AND a.ACTION_TYPE = NVL('#action_typ',a.ACTION_TYPE) ";
	 } 
			  
	 if( (addid != null) && (!(addid.equals(""))))			
	 {
	 	whereClause =whereClause +" AND (a.ADDED_BY_ID= NVL('#addid',a.ADDED_BY_ID))";
	 } 
	
	 if((addeddate != null) && (!(addeddate.equals(""))))			
	 {
		whereClause =whereClause +" AND  TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy')"+ 	
	                                                   "=NVL('#addeddate',TO_CHAR(a.ADDED_DATE,'dd/mm/yyyy'))";
 	 }

	if((pat_id != null) && (!(pat_id.equals(""))))			
	{
		whereClause = whereClause + " AND  a.patient_id = NVL('#pat_id' ,a.patient_id)";
	}

  		String messageDateFrom = msg_dt1;
		String messageDateTo = msg_dt2;
		// Converting the message date from thai to english locale
		if("th".equalsIgnoreCase(locale) && ((msg_dt1 != null) && (!(msg_dt1.equals("")))))
		{
			messageDateFrom = com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
			if(!("".equals(msg_dt2)))
			{
				messageDateTo = com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
			}
		} 

		if((msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause =whereClause +" AND TO_DATE(a.MESSAGE_DATE) BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		} 

		if((msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" AND TO_DATE(a.MESSAGE_DATE) < = "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(a.MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		} 

	if((addedwsno != null) && (!(addedwsno.equals(""))))			
	{
					
		whereClause =whereClause +" AND a.ADDED_AT_WS_NO"+ 			         
					 "=NVL('#addedwsno',a.ADDED_AT_WS_NO)";
	} 

	if((modfid != null) && (!(modfid.equals(""))))			
	{
			whereClause =whereClause +" AND a.MODIFIED_BY_ID=NVL('#modfid',a.MODIFIED_BY_ID)";
				
 	} 

	if((modifieddate != null) && (!(modifieddate.equals(""))))			
	{
			whereClause =whereClause +" AND TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy')"+ 
																	"=NVL('#modifieddate',TO_CHAR(a.MODIFIED_DATE,'dd/mm/yyyy'))";
				
 	} 

	if((modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
	{
				whereClause =whereClause +" AND a.MODIFIED_AT_WS_NO"+ 
																		"=NVL('#modifiedwsno',a.MODIFIED_AT_WS_NO)";
	
 	}
	
	System.out.println(" ::: orderBy ::: "+orderBy);
	
	if(whereClause.length()<=7)
	{
		if(orderBy.equals("")||orderBy==null)
		{
					whereClause="";
		}
		else
		{
		   whereClause=whereClause+" order  By " +orderBy;	 
		}
	}
			
    else
	{
		 whereClause=whereClause +" order  By " +orderBy;
	}

	if((order != null) && (order.equals("A")))
	{
		order="D";
	}
	else
	{
		order="A";
	}
	}	 
	else
	{
	}

	System.out.println(" VIEWXHINTERACTIVE Where Clause ::: "+whereClause);
	     request.setAttribute(XHQueryRender.strQueryId,"VIEWXHINTERACTIVE");		

	request.setAttribute("tableNameSuffix",tableNameSuffix); 

 
	//System.out.println("whereClause :"+whereClause); 			  
	request.setAttribute(XHQueryRender.col,"33"); 
	request.setAttribute(XHQueryRender.maxRec,"20");
    request.setAttribute(XHQueryRender.whereClause,whereClause);
    HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
	boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
	String strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	String strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	if (boolPrevious == true)
	{
		strPrevious = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels");
	}
	else
	{
		strPrevious = " ";
	}
	if (boolNext== true)
	{
		strNext  = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
		    	if(arrRow.size()==0){
			
            _bw.write(_wl_block9Bytes, _wl_block9);

				}
else
	{
	
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(order));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(order));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(order));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(order));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(order));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(order));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(order));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);

	for (int j=0; j<arrRow.size();j++)
	{
  	   arrCol = (ArrayList)arrRow.get(j);
	   if (boolToggle == true)
	   {
			strTDClass = "class='QRYEVEN'";
			boolToggle =  false;
	   }
	   else
	   {
			strTDClass = "class='QRYODD'";
			boolToggle =  true;
		}

		/*String s1=((String)arrCol.get(0)).equals("null")?"":(String)arrCol.get(0);
		String s2=((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(2);
		String s3=((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(5);
		String s5=((String)arrCol.get(2)).equals("null")?"":(String)arrCol.get(3);*/
		
	
		
		 String strResQuery="";

		String statusColor="../../eXH/images/green_square.jpg"; 
	   try
	   {
			s= conn.createStatement();


			
			    if(purge_status != null && !purge_status.equalsIgnoreCase("null"))
			 {
				

				 if(purge_status.equals(""))
				 {
				   strResQuery = "XH_INTERACTIVE_INTEGRATION where MESSAGE_ID='"+XHDBAdapter.checkNull((String)arrCol.get(0))+"' ";		  
				 }
				 else
				 {
					strResQuery = "XH"+"_"+purge_status+"_INTERACTVE_INTEGRTN where MESSAGE_ID='"+XHDBAdapter.checkNull((String)arrCol.get(0))+"'";
				 }
					
				// request.setAttribute("purge_status","Y");	   			   			  
			 }	

			 // Modified by Gopinath for ML-MMOH-SCF-2469 on 06/07/2023
			  //String resQuery="select RESPONSE_TEXT from "+strResQuery;
			  String resQuery="select RESPONSE_TEXT,STATUS from "+strResQuery;
			  r = s.executeQuery(resQuery);
			  while(r.next()) 
			 {
				res_txt=XHDBAdapter.checkNull(XHIdentify.returnvalue(r.getClob(1)));
				status=XHDBAdapter.checkNull(r.getString(2));
			 }    
			 
			 if(s!=null)s.close();
			 if(r!=null)r.close();

		}
		catch(Exception e)																				  
		{
			System.out.println("Exceptiong in ViewEventsInteractiveDtlTest1.jsp"+e);
		}

		// Modified by Gopinath for ML-MMOH-SCF-2469 on 06/07/2023
		/*if(res_txt==null||res_txt.equals("")||res_txt.equals(" "))
		{
		statusColor = "../../eXH/images/blue_square.jpg" ;	 
		}

		if(res_txt.length()>0)
		{
		 statusColor = "../../eXH/images/yello_square.jpg" ;	 
		}
		else
			{
		  statusColor = "../../eXH/images/blue_square.jpg" ;	
		}*/
		
		if (!res_txt.equals("") && status.equals("S")) {
			statusColor = "../../eXH/images/green_square.jpg";
		} else if (!res_txt.equals("") && (status.equals("F") || status.equals("W") || status.equals("E"))) {
			statusColor = "../../eXH/images/red_square.jpg";
		} else if (!res_txt.equals("") && status.equals("N")) {
			statusColor = "../../eXH/images/blue_square.jpg";
		} else {
			statusColor = "../../eXH/images/blue_square.jpg";
		}
		// Modification completed for ML-MMOH-SCF-2469
		

            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(statusColor));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(  j ));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(  j ));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf( arrCol.get(10) ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( arrCol.get(11) ));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf( arrCol.get(2)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(30)+"")));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(XHDBAdapter.checkNull(arrCol.get(31)+"")));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( arrCol.get(3) ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( arrCol.get(0) ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( arrCol.get(5) ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( arrCol.get(27) ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf( interface_module ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( sub_module ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( arrCol.get(29) ));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf( arrCol.get(22)));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf((String)arrCol.get(6)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)arrCol.get(8)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf((String)arrCol.get(12)));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( (String)arrCol.get(28) ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf( (String)arrCol.get(17) ));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(j+""));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(0))));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(2))));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(3))));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(5))));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(24))));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(12))));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(10))));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(11))));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(6))));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(9))));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(13))));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(14))));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(15))));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(16))));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(17))));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(18))));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(19))));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(XHDBAdapter.checkNull((String)arrCol.get(20))));
            _bw.write(_wl_block64Bytes, _wl_block64);
}
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf( msg_status ));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(facility ));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(msg_id1 ));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(msg_dt1 ));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(msg_id2 ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(msg_dt2 ));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(orderBy ));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order ));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(pat_id ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(merg_pat_id ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(episode_id ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(visit_id ));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(action_typ ));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(last_processed_date ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(not_req_rsn ));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(addid ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(addeddate ));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(addedwsno ));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(modfid ));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(modifieddate ));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(modifiedwsno ));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(msg_date ));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(applnname ));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(eventtype ));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(eventStatus));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(externalAccNo));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(interface_module));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(tableNameSuffix));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(authToRebuild));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(authToReplay));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(authToVwCommErr));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(authToAudit));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(viewAuth));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(protocol_link_ID));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(pmode));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block106Bytes, _wl_block106);

		}
if(arrRow!=null) arrRow.clear();
if(arrCol!=null) arrCol.clear();
if(resultsQry!=null) resultsQry.clear();
  }catch(Exception e1)
			{
			 out.println("(ViewEventsInteractiveDt1.jsp:Exception) "+e1);
			 e1.printStackTrace(System.err);
			}
			finally
			{
			ConnectionManager.returnConnection(conn);
			}
	
            _bw.write(_wl_block107Bytes, _wl_block107);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.InterActiveInterface.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.EditQuery.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.MessageID.Label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AckMessageid.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Program.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.Profile.Label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AccessionNumber.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ExternalAccessionNumber.Label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.encounterid.Label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedID.Label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedDate.Label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedID.Label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedDate.Label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedWSNo.Label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedFacility.Label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedWSNo.Label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedFacilityID.Label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${xh_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
