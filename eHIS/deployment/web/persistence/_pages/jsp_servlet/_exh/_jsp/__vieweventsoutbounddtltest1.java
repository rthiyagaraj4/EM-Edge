package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __vieweventsoutbounddtltest1 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/ViewEventsOutboundDtlTest1.jsp", 1729586307893L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\t\n\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\' type=\'text/css\'></link>\n\n<!-- these style setting are used for table scroll -->\n<style>\n\tdiv {float: left}\n\t.testSty\n\t{\n\t\twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n</style>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<script language=\'javascript\' src=\"../../eCommon/js/common.js\"></script>\n<script Language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/XHAjaxUtil.js\"></script>\n<script Language=\"javascript\" src=\"../../eXH/js/ViewEventsOutbound.js\"></script>\n<script Language=\"javascript\" src=\"../../eXH/js/ViewEvents.js\"></script>\n<SCRIPT language=\'javascript\' src=\'../../eXH/js/menu.js\'></script>\n<Script Language=\'javascript\'>\n\n//function funSubmit\nfunction funSubmit()\n{\n\tparent.f_query_add_mod.VIEW_EVENTS.action = \'../../eXH/jsp/ViewEventsOutboundDtlTest1.jsp\';\n\tparent.f_query_add_mod.VIEW_EVENTS.target=\"f_query_add_mod\";\n\tparent.f_query_add_mod.VIEW_EVENTS.submit();\n}\n//function funModify\nfunction funModify(obj)\n{\n\tparent.commontoolbarFrame.document.forms[0].apply.style.display=\'block\';\n}\n//function changeMe\nfunction changeMe(msgId) \n{\t\n\tdocument.getElementById(msgId).style.color = \"green\";\n}\n//function doChanges\nfunction doChanges() \n{\n\tthis.document.forms[0].action=\"../../eXH/jsp/ViewEventsOutboundDtlTest1.jsp\";\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n\n\twindow.event.target.style.color = \"green\";\n\twindow.event.target.style.font = \"bold\";\n\twindow.event.target.style.fontSize = \"15px\";\n} \n//function funAction\nfunction funAction(typ)\n{  \n\tparent.f_query_add_mod.VIEW_EVENTS.action_type.value = typ;\n\tfunSubmit();\n\n}\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\t\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXH/jsp/ViewEventsOutboundDtlTest1.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\n\n//function func1\nfunction  func1(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,\n\t\t\t\t\tmsgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,\n\t\t\t\t\tmsgProcessed,msgStatus,eventStatus,msgDate,patID,episodeID,episodeType,visitID)\n{\t  \t  \n\tvar url=\'&accessionNumber=\'+accessionNumber+\n\t\t\t\'&externalAccessNumber=\'+externalAccessionNumber+\n\t\t\t\'&applicationId=\'+applicationId+\n\t\t\t\'&applicationName=\'+applicationName+\n\t\t\t\'&facilityId=\'+facilityId+\n\t\t\t\'&facilityName=\'+facilityName+\n\t\t\t\'&msgId=\'+msgId+\n\t\t\t\'&eventType=\'+eventType+\n\t\t\t\'&reason=\'+reason+\n\t\t\t\'&purge_status=\'+purge_status+\n\t\t\t\'&interface_module=\'+interface_module+\n\t\t\t\'&sub_module=\'+sub_module+\n\t\t\t\'&protocol_link_id=\'+protocol_link_id+\n\t\t\t\'&Rule=Y\'+\n\t\t\t\'&msgProcessed=\'+msgProcessed+\n\t\t\t\'&msgStatus=\'+msgStatus+\n\t\t\t\'&eventStatus=\'+eventStatus+\n\t\t\t\'&msgDate=\'+msgDate+\n\t\t\t\'pat_id=\'+patID+\n\t\t\t\'episode_id=\'+episodeID+\'&episode_type=\'+episodeType+\'&visit_id=\'+visitID;\t\t\t\t\n\t\n\tthis.document.forms[0].action=\"../../eXH/jsp/ViewEventsOutboundFooter.jsp?\"+url;\n\tthis.document.forms[0].target = \"messageFrame\";\n\tthis.document.forms[0].submit();\n}\n\n</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onKeyDown =\'lockKey()\' onMouseDown=\'CodeArrest()\'>\n<form name=\"VIEW_EVENTS\" id=\"VIEW_EVENTS\" method=\"POST\" action=\'../../eXH/jsp/ViewEventsOutboundHeader.jsp\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<input type=\'hidden\' name=\'msg_status\' id=\'msg_status\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' >\n<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<input type=\'hidden\' name=\'temp\' id=\'temp\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'msg_id1\' id=\'msg_id1\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'msg_dt1\' id=\'msg_dt1\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'msg_id2\' id=\'msg_id2\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'msg_dt2\' id=\'msg_dt2\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'order\' id=\'order\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n<input type=\'hidden\' name=\'pat_id\' id=\'pat_id\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'action_typ\' id=\'action_typ\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'last_processed_date\' id=\'last_processed_date\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=\'hidden\' name=\'not_req_rsn\' id=\'not_req_rsn\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\' name=\'addid\' id=\'addid\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'addeddate\' id=\'addeddate\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'addedwsno\' id=\'addedwsno\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'modfid\' id=\'modfid\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'modifieddate\' id=\'modifieddate\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'modifiedwsno\' id=\'modifiedwsno\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'msg_date\' id=\'msg_date\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'applnname\' id=\'applnname\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'eventtype\' id=\'eventtype\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'whereClause\' id=\'whereClause\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'purge_status\' id=\'purge_status\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'event_status\' id=\'event_status\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'externalAccNoFrom\' id=\'externalAccNoFrom\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'externalAccNoTo\' id=\'externalAccNoTo\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'interface_module\' id=\'interface_module\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'tableNameSuffix\' id=\'tableNameSuffix\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'sub_module\' id=\'sub_module\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'comm_mode\' id=\'comm_mode\' value=\'Outbound\'>\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'rebuildAut\' id=\'rebuildAut\' id=\"rebuildAut\" value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'replayAut\' id=\'replayAut\' id=\"replayAut\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'commExpAut\' id=\'commExpAut\' id=\"commExpAut\" value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\'hidden\' name=\'audtiAut\' id=\'audtiAut\' id=\"audtiAut\" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'viewAuth\' id=\'viewAuth\' id=\"viewAuth\" value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'dispMode\' id=\'dispMode\' id=\"dispMode\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=\'hidden\' name=\'protocol_link_id\' id=\'protocol_link_id\' id=\"protocol_link_id\" value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'protocol_link_name\' id=\'protocol_link_name\' id=\"protocol_link_name\" value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\t\n\n<script>\t\n\talert(getMessage(\'XH1021\',\'XH\'));\n\teditQuery(); // calling header page with the query criteria in the request object\n</script>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td colspan=\"2\" align=\"center\" class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td>\n</tr>\n<tr>\t   \n\t<td align=\"left\" class=\"CAGROUP\">\n\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"editQuery();\" TITLE=\"Edit Query\">\n\t\t\tEditQuery\n\t\t</A>\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"refreshResults(\'ViewEventsOutboundDtlTest1\');\" TITLE=\"Refresh Events\">\n\t\t\tRefresh\n\t\t</A>\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t</td>\n\t<td align=\"right\" class=\"CAGROUP\"> \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="</A>\n\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</A>\n\t</td>\n</tr>\n</table>\n\n<div id=\"left_child\" style=\"width: 50vw; display:none;\">\n<table id=\"table1\" cellspacing=0 cellpadding=3 border=1>\t\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' title=\"Event Status\">\n\t\t\t&nbsp; $ &nbsp;\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' title=\"Message Status\" href=\"javascript:callForOrderBy(\'MESSAGE_STATUS_DESC\',\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\');\" onclick=\'\'>\n\t\t\t<font color=white>\n\t\t\t&nbsp; # &nbsp;\n\t\t\t</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'lpad(Message_ID,20)\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\" onclick=\'\'>\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'application_name\',\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\');\"onclick=\'\'>\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'EVENT_TYPE\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\');\"onclick=\'\' >\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MESSAGE_DATE\',\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'FACILITY_NAME\',\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'protocol_link_ID\',\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\');\"onclick=\'\'><font color=white>Gateway</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_ID\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="</font>\n\t\t</td>\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\n\t\n\t<tr id=\"testID\">\t\t\t\t\t\t\t\t\n\n\t<!---Event Status-->\n\t<td nowrap ";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 =" align=\"center\"><img src=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' height=10 ></td>\n\n\t<!---Message Status-->\n\t<td nowrap ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' height=10 ></td>\n\n\t<!---Message Id-->\n\t<td  nowrap ";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 =" id=\'mes";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' onMouseOver=this.style.cursor=\'hand\' onClick=\'changeMe(\"mes\"+";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 =")\' onMouseDown=\"buildOBMenuList(\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\',\n\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\',\t\t\n\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\',\n\t\t\t\t\t\t\t\t\t\t\t\'\',\t\t\t\t\t\t\t    \n\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\',\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\',";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =",\n\t\t\t\t\t\t\t\t\t\t\t\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\'); \">\n\t<font size=1 color=\"blue\">&nbsp;";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</font></td>\n\n\t<!---Application-->\n\t<td nowrap  ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" ><font size=1>&nbsp;";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</td>\n\n\t<!---Event-->\n\t<td nowrap  ";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" > <font size=1>&nbsp;";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</td>\n\n\t<!---Message Date-->\n\t<td nowrap ";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</td>\n\n\t<!---Facility-->\n\t<td nowrap ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="</td>\n\n\t<!---Protocol Link ID-->\n\t<td nowrap  ";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</td>\n\n\t<!---Patient ID-->\n\t<td ";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" align=\"center\"><font size=1>&nbsp;";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n</table>\n</div>\n<div id=\"right_child\" class=\"testSty\"  style=\"overflow-y: scroll;display: block; width: 48.9vw;\">\n<table id=\"table2\" cellspacing=0 cellpadding=3 border=1>\n\t<tr>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'EPISODE_ID\',\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'EPISODE_TYPE\',\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'VISIT_ID\',\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ACCESSION_NUM\',\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\' style=\"display:none;\">\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'EXT_ACCESSION_NUM\',\'";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\');\"onclick=\'\'>\n\t\t\t<font color=white>Ext.Accession Number</font>\n\t\t</td>\n\t\t\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ACTION_TYPE\',\'";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'LAST_PROC_DATE\',\'";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\');\"onclick=\'\'>\n\t\t\t<font color=white>L";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ADDED_BY_ID\',\'";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ADDED_DATE\',\'";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'ADDED_AT_WS_NO\',\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MODIFIED_BY_ID\',\'";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MODIFIED_DATE\',\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</font>\n\t\t</td>\n\t\t<td nowrap class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MODIFIED_AT_WS_NO\',\'";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="</font>\n\t\t</td>\t\t\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t<tr>\n\t";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\n\t<!---Episode ID-->\n\t<td nowrap  ";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\n\t<!---Episode Type-->\n\t<td nowrap ";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="</td>\n\n\t<!---Visit ID-->\n\t<td  nowrap ";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</td>\n\n\t<!---Accession Number-->\n\t<td  nowrap ";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\n\t<!---External Accession Number-->\n\t<td nowrap  ";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 =" style=\"display:none;\"> \n\t\t<a href=\"javascript:getInboundDetails(\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\')\">\n\t\t<font size=1>&nbsp;";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="</a>\n\t</td>\t\n\n\t<!---Action Type-->\n\t<td nowrap ";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="</td>\n\n\t<!---Last Processed date-->\n\t<td nowrap  ";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="</td>\t\n\n\t<!---Added ID-->\n\t<td nowrap ";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="</td>\n\n\t<!---Added Date-->\n\t<td nowrap ";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="</td>\n\n\t<!---Added WS No-->\n\t<td nowrap ";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="</td>\n\n\t<!---Modified Id-->\n\t<td  nowrap ";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="</td>\n\n\t<!---Modified Date-->\n\t<td nowrap ";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="</td>\n\n\t<!---Modified WS No-->\n\t<td nowrap  ";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="</td>\n\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\n\t</tr>\n</table>\n</div>\n\t\n<SCRIPT>\n\tdocument.getElementById(\"left_child\").style.display = \"block\";\n\tdocument.getElementById(\"right_child\").style.display = \"block\";\n\tparent.messageFrame.location.href = \"../../eXH/jsp/ViewEventsOutboundFooter.jsp?commType=outbound\"; \n</SCRIPT>\n\t\n\t";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\n\n</form>\n</html>\n\n\n";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
request.setCharacterEncoding("UTF-8"); 
String locale = ((String)session.getAttribute("LOCALE"));

            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order;
String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause,pmode,eventStatus;
String statusColor="../../eXH/images/black_square.jpg";
String sstatusColor="../../eXH/images/blue_square.jpg";     
String status;									  
String mstatus;
String orderBy;
String tableNameSuffix= "";
String function_id = XHDBAdapter.checkNull(request.getParameter("function_id")); // Used in ViewEventsOutboundHeader when Edit Query is clicked.
msg_status = null;
facility = null;									    
msg_id1 = null;						    
msg_dt1 = null;
msg_id2 = null;
msg_dt2 = null;
order = null;
orderBy = null;	
tabValue = null;
pat_id = null;
merg_pat_id = null;
episode_type = null;
episode_id = null;
visit_id = null;
action_typ = null;
last_processed_date = null;
not_req_rsn = null;
addid = null;
addeddate = null;
addedwsno = null;
modfid = null;
modifieddate = null;
modifiedwsno = null;
msg_date = null;
applnname = null;
eventtype = null;
eventStatus = null;
whereClause = null;
String action_type = null;
String temp = null;
String interface_module = null;
String sub_module = null;
pmode=null;
String externalAccNoFrom = null;
String externalAccNoTo = null;
String purge_status = null;
String protocol_link_ID = null;
String maxRecords = "24";
String Rule=XHDBAdapter.checkNull(request.getParameter("Rule"));
boolean msgProcessed = false;

Properties p = (Properties) session.getValue("jdbc");
String loggedUser = p.getProperty("login_user");


            _bw.write(_wl_block8Bytes, _wl_block8);

boolean boolToggle =  true;	
String strTDClass = "";
Connection conn = null;
try
{   
	action_type	= XHDBAdapter.checkNull(request.getParameter("action_type"));
	msg_status  = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
	facility    = XHDBAdapter.checkNull(request.getParameter("facility")); 
	msg_id1	= XHDBAdapter.checkNull(request.getParameter("msg_id1")); 
	msg_id2	= XHDBAdapter.checkNull(request.getParameter("msg_id2"));  
	msg_dt1	= XHDBAdapter.checkNull(request.getParameter("msg_dt1")); 
	msg_dt2	= XHDBAdapter.checkNull(request.getParameter("msg_dt2")); 
	orderBy	= XHDBAdapter.checkNull(request.getParameter("orderBy"));
	order	= XHDBAdapter.checkNull(request.getParameter("order"));
	tabValue = XHDBAdapter.checkNull(request.getParameter("tabValue"));
	pat_id   = XHDBAdapter.checkNull(request.getParameter("pat_id"));
	merg_pat_id	 = XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
	episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
	episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	visit_id   = XHDBAdapter.checkNull(request.getParameter("visit_id"));
	action_typ = XHDBAdapter.checkNull(request.getParameter("action_typ"));
	last_processed_date	= XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
	not_req_rsn	= XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
	addid = XHDBAdapter.checkNull(request.getParameter("addid"));
	addeddate = XHDBAdapter.checkNull(request.getParameter("addeddate"));
	addedwsno = XHDBAdapter.checkNull(request.getParameter("addedwsno"));
	modfid	  = XHDBAdapter.checkNull(request.getParameter("modfid"));
	modifieddate = XHDBAdapter.checkNull(request.getParameter("modifieddate"));	
	modifiedwsno = XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));
	msg_date  = XHDBAdapter.checkNull(request.getParameter("msg_date"));
	eventtype = XHDBAdapter.checkNull(request.getParameter("eventtype"));
	applnname = XHDBAdapter.checkNull(request.getParameter("applnname"));	
	interface_module = XHDBAdapter.checkNull(request.getParameter("interface_module"));	
	sub_module = XHDBAdapter.checkNull(request.getParameter("sub_module"));	
	eventStatus= request.getParameter("event_status");
	externalAccNoFrom = XHDBAdapter.checkNull(request.getParameter("externalAccNoFrom"));
	externalAccNoTo = XHDBAdapter.checkNull(request.getParameter("externalAccNoTo"));
	purge_status = XHDBAdapter.checkNull(request.getParameter("purge_status"));	
	protocol_link_ID = XHDBAdapter.checkNull(request.getParameter("protocol_link_id"));	
	pmode = XHDBAdapter.checkNull(request.getParameter("pmode"));
	String protocol_link_name = XHDBAdapter.checkNull(request.getParameter("protocol_link_name"));
	String dispMode = XHDBAdapter.checkNull(request.getParameter("dispMode"));

//	System.out.println("protocol_link_name "+protocol_link_name);
	
	String authSql = "SELECT * FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"+loggedUser+"')"; 
	
	ResultSet authRS = null;

	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToRebuild = false;
	boolean authToReplay = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;

	try
	{
		conn = ConnectionManager.getConnection(request);
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

/*********IMPORTANT*********** 
****	This code to be used when Interface Domain is required in the table name *****
****	Eg:- As of now table name is like XH_EVENT_APPL_MESSAGE, if the interface domain is
		also added this becomes as XH_XH_EVENT_APPL_MESSAGE *****

	if(interface_module != null && !interface_module.equalsIgnoreCase(""))
	{		
		tableNameSuffix = interface_module + "_"+ sub_module;
	}
	else
	{
		//System.out.println("sub_module.... "+sub_module);
		tableNameSuffix = sub_module;
	}
*/	
	if(pmode!=null)
	{
		if(pmode.equalsIgnoreCase("F"))
		{
			if(locale.equalsIgnoreCase("th"))
			{
			//	msg_dt1=com.ehis.util.DateUtils.convertDate(msg_dt1,"DMY","th","en");
			//	msg_dt2=com.ehis.util.DateUtils.convertDate(msg_dt2,"DMY","th","en");
				addeddate=com.ehis.util.DateUtils.convertDate(addeddate,"DMY","th","en");
				modifieddate=com.ehis.util.DateUtils.convertDate(modifieddate,"DMY","th","en");
				msg_date=com.ehis.util.DateUtils.convertDate(msg_date,"DMY","th","en");		  
			}
		}			
	}
	boolean flag =false;	
	whereClause =" WHERE ";

	try
	{

		//facility	
		if((facility != null ) && (!(facility.equals(""))))			
		{
			whereClause =whereClause + " amv.FACILITY_ID = NVL('#facility',amv.FACILITY_ID)";
			flag=true;
		} 

		//application_id
		if((flag==true) && (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " AND amv.APPLICATION_ID = NVL('#applnname',amv.APPLICATION_ID) ";
		} 

		if((flag==false) && (applnname != null) && (!(applnname.equals(""))))			
		{
			whereClause =whereClause + " amv.APPLICATION_ID = NVL('#applnname',amv.APPLICATION_ID) ";
			flag=true;
		} 

		//eventtype
		if((flag==true) && (eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " AND EVENT_TYPE = NVL('#eventtype',EVENT_TYPE) ";
		} 

		if((flag==false) && (eventtype != null) && (!(eventtype.equals(""))))			
		{
			whereClause =whereClause + " EVENT_TYPE = NVL('#eventtype',EVENT_TYPE) ";
			flag=true;
		} 

		//eventStatus
		if((flag==true) && (eventStatus != null) && !eventStatus.equals(""))			
		{
			if(eventStatus.equals(" "))
			{
				whereClause = whereClause + " AND EVENT_STATUS IS NULL ";
			}
			else
			{
				whereClause = whereClause + " AND EVENT_STATUS = NVL('#event_status',EVENT_STATUS) ";
			}
		} 

		if((flag==false) && (eventStatus != null) && !eventStatus.equals(""))			
		{
			if(eventStatus.equals(" "))
			{
				whereClause = whereClause + " EVENT_STATUS IS NULL ";
			}
			else
			{
				whereClause = whereClause + " EVENT_STATUS = NVL('"+eventStatus+"',EVENT_STATUS)";
			}
			flag=true;
		} 

		//msgstatus
		if((flag==true) && (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" AND MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" AND MESSAGE_STATUS = "+"NVL('#msg_status',MESSAGE_STATUS)";
		} 

		if((flag==false) && (msg_status != null) && (!msg_status.equals("")))			
		{
			if(msg_status.equals(" "))
				whereClause =whereClause +" MESSAGE_STATUS IS NULL ";
			else
				whereClause =whereClause +" MESSAGE_STATUS = "+						
								"NVL('#msg_status',MESSAGE_STATUS)";
			flag=true;
		} 

		//msg_id1
		if((flag == true) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" AND message_id >="+ 	
								"  nvl(lpad('#msg_id1',20),message_id)";
			}
			else
			{
				whereClause =whereClause +" AND message_id BETWEEN"+ 	
								"  nvl('#msg_id1',message_id) AND nvl('#msg_id2',message_id)";
			}
		} 

		if((flag == false) && (msg_id1 != null) && (!(msg_id1.equals(""))))			
		{
			if((msg_id2 != null) && ((msg_id2.equals(""))))
			{
				whereClause = whereClause +" message_id >="+ 	
								"  nvl(lpad('#msg_id1',20),message_id)";
			}
			else
			{
				whereClause = whereClause +" message_id BETWEEN"+ 	
									"  nvl('#msg_id1',message_id) AND nvl('#msg_id2',message_id)";
				flag = true;
			}
		} 

		//msg_id2
		if((flag == true) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" AND message_id <"+ 	
								"  nvl('#msg_id2',message_id)";
			}
		} 

		if((flag == false) && (msg_id2 != null) && (!(msg_id2.equals(""))))			
		{		
			if((msg_id1 != null) && (!(msg_id1.equals("")))){}
			else
			{
				whereClause = whereClause +" message_id <"+ 	
								"  nvl('#msg_id2',message_id)";
			}
			flag  =true;
		} 

		//msg_dt1

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

		if((flag == true) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause = whereClause +" AND TO_DATE(TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		} 

		if((flag==false) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause = whereClause +" TO_DATE(TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy'),'dd/mm/yyyy') BETWEEN  "+  	
								" TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			flag=true;
		}
		
		//msg_dt2
		if((flag==true) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" AND TO_DATE(MESSAGE_DATE) <=  "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		} 

		if((flag==false) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" TO_DATE(MESSAGE_DATE) <=  "+  								
								" TO_DATE(NVL('#msg_dt2',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
			flag=true;
		}

		//patient_id
		if((flag==true) && (pat_id != null) && (!(pat_id.equals(""))))			
		{
			whereClause =whereClause +" AND  PATIENT_ID= NVL('#pat_id' ,PATIENT_ID)";
		} 

		if((flag==false) && (pat_id != null) && (!(pat_id.equals(""))))		
		{
			whereClause =whereClause +" PATIENT_ID= NVL('#pat_id' ,PATIENT_ID)";
			flag=true;
		} 

		//merge_patient_id
		if((flag==true) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
		{
			whereClause =whereClause +" AND (NVL(MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
								"MERGED_PATIENT_ID = NVL('',MERGED_PATIENT_ID))";
		} 
		if((flag==false) && (merg_pat_id != null) && (!(merg_pat_id.equals(""))))			
		{
			whereClause =whereClause +" (NVL(MERGED_PATIENT_ID,  'X' ) = NVL('','X') OR  "+ 
								"MERGED_PATIENT_ID = NVL('',MERGED_PATIENT_ID))";
			flag=true;
		} 

		//episode_type
		if((flag==true) && (episode_type != null) && (!(episode_type.equals(""))))			
		{
			whereClause =whereClause +" AND EPISODE_TYPE= NVL('#episode_type' ,EPISODE_TYPE)";
		} 

		if((flag==false) && (episode_type != null) && (!(episode_type.equals(""))))			
		{
			whereClause =whereClause +" EPISODE_TYPE= NVL('#episode_type' ,EPISODE_TYPE)";
		} 

		//episode_id
		if((flag==true) && (episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" AND EPISODE_ID = NVL('#episode_id',EPISODE_ID)";
		} 

		if((flag==false) && (episode_id != null) && (!(episode_id.equals(""))))			
		{
			whereClause =whereClause +" EPISODE_ID = NVL('#episode_id',EPISODE_ID)";
			flag=true;
		} 

		//visit_id
		if((flag==true) && (visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause =whereClause +"  AND VISIT_ID= NVL('#visit_id' ,VISIT_ID)";
		} 

		if((flag==false) && (visit_id != null) && (!(visit_id.equals(""))))			
		{
			whereClause = whereClause +" VISIT_ID= NVL('#visit_id' ,VISIT_ID)";
			flag=true;
		} 

		//action type
		if(action_typ != null)
		{
			action_typ=action_typ.trim();	
		}
		if((flag==true) && (action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +"  AND ACTION_TYPE = NVL('#action_typ',ACTION_TYPE) ";
		} 

		if((flag==false) && (action_typ != null) && (!(action_typ.equals(""))))		
		{
			whereClause = whereClause +" ACTION_TYPE = NVL('#action_typ',ACTION_TYPE) ";
			flag=true;
		} 
		if((flag==true) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
		{
			whereClause = whereClause + " AND TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
								"=NVL('#last_processed_date',TO_CHAR(message_date,'dd/mm/yyyy'))";
		} 

		if((flag==false) && (last_processed_date != null) && (!(last_processed_date.equals(""))))			
		{
			whereClause = whereClause + " TO_CHAR(LAST_PROC_DATE,'dd/mm/yyyy')"+ 		
								"=NVL('#last_processed_date',TO_CHAR(message_date,'dd/mm/yyyy'))";
			flag=true;
		} 

		//not_required_reason
		if((flag==true) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" AND   NOT_REQ_REASON= NVL('#not_req_rsn'"+ 		 	
								",NOT_REQ_REASON)";
		} 

		if((flag==false) && (not_req_rsn != null) && (!(not_req_rsn.equals(""))))			
		{
			whereClause = whereClause +" NOT_REQ_REASON= NVL('#not_req_rsn'"+ 		 	
								",NOT_REQ_REASON) ";
			flag=true;
		}  

		//addid   
		if((flag==true) && (addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" AND (ADDED_BY_ID= NVL('#addid',ADDED_BY_ID))";
		} 

		if((flag==false) && (addid != null) && (!(addid.equals(""))))			
		{
			whereClause = whereClause +" (ADDED_BY_ID= NVL('#addid',ADDED_BY_ID))"; 		 	
			flag=true;
		}  

		//addeddate
		if((flag==true) && (addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" AND  TO_CHAR(ADDED_DATE,'dd/mm/yyyy')"+ 	
								"=NVL('#addeddate',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))";
		} 

		if((flag==false) && (addeddate != null) && (!(addeddate.equals(""))))			
		{
			whereClause = whereClause +" TO_CHAR(ADDED_DATE,'dd/mm/yyyy') =NVL('#addeddate',TO_CHAR(ADDED_DATE,'dd/mm/yyyy'))"; 		 	
			flag=true;
		}  

		//addedwsno
		if((flag==true) && (addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" AND ADDED_AT_WS_NO"+ 			         
								"=NVL('#addedwsno',ADDED_AT_WS_NO)";
		} 

		if((flag==false) && (addedwsno != null) && (!(addedwsno.equals(""))))			
		{
			whereClause = whereClause +" ADDED_AT_WS_NO"+
									"=NVL('#addedwsno',ADDED_AT_WS_NO)";
			flag=true;
		}  

		//modfied id
		if((flag==true) && (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" AND MODIFIED_BY_ID=NVL('#modfid',MODIFIED_BY_ID)";
		} 
		if((flag==false) && (modfid != null) && (!(modfid.equals(""))))			
		{
			whereClause =whereClause +" MODIFIED_BY_ID=NVL('#modfid',MODIFIED_BY_ID)";
			flag=true;
		}  
		//modifieddate
		if((flag==true) && (modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" AND TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('#modifieddate',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
		} 
		if((flag==false) && (modifieddate != null) && (!(modifieddate.equals(""))))			
		{
			whereClause =whereClause +" TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy')"+ 
								"=NVL('#modifieddate',TO_CHAR(MODIFIED_DATE,'dd/mm/yyyy'))";
			flag=true;
		}  

		// modifiedwsno
		if((flag==true) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause =whereClause +" AND MODIFIED_AT_WS_NO"+ 
								"=NVL('#modifiedwsno',MODIFIED_AT_WS_NO)";
		} 

		if((flag == false) && (modifiedwsno != null) && (!(modifiedwsno.equals(""))))			
		{
			whereClause = whereClause +"  MODIFIED_AT_WS_NO=NVL('#modifiedwsno',MODIFIED_AT_WS_NO)";
			flag = true;
		} 
		//External accession number From attribute
		if((flag == true) && (externalAccNoFrom != null) && (!(externalAccNoFrom.equals(""))))			
		{
			if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
			{
				whereClause = whereClause + " AND EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
			}
			else
			{
				whereClause = whereClause + " AND EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
			}
		}
		if((flag == false) && (externalAccNoFrom != null) && (!externalAccNoFrom.equals("")) )
		{
			if((externalAccNoTo != null) && (!(externalAccNoTo.equals(""))))
			{
				whereClause = whereClause + " EXT_ACCESSION_NUM BETWEEN '"+externalAccNoFrom+"' AND '"+externalAccNoFrom+"'";
			}
			else
			{
				whereClause = whereClause + " EXT_ACCESSION_NUM >= '"+externalAccNoFrom+"'";
			}
			flag = true;
		}

		//External accession number To attribute
		if((flag==true) && (externalAccNoTo != null) && (!(externalAccNoTo.equals("")))
							&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))			
		{
			whereClause = whereClause + " AND EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";		
		}
		if((flag == false) && (externalAccNoTo != null) && (!externalAccNoTo.equals(""))
							&& ((externalAccNoFrom == null) || (externalAccNoFrom.equals(""))))
		{
			whereClause = whereClause + " EXT_ACCESSION_NUM <= '"+externalAccNoTo+"'";
			flag = true;
		}

		//Protocol link id
		if((flag==true) && (protocol_link_ID != null) && (!(protocol_link_ID.equals(""))))			
		{
			whereClause = whereClause + " AND AMV.PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
		}
		if((flag == false) && (protocol_link_ID != null) && (!protocol_link_ID.equals("")) )
		{
			whereClause = whereClause + " AMV.PROTOCOL_LINK_ID='"+protocol_link_ID+"'";
			flag = true;
		}
	//	System.out.println("orderBy "+orderBy);
		if(whereClause.length() <= 7)
		{
			whereClause = "";
			if(orderBy != null && !orderBy.equals(""))
			{
				whereClause = whereClause +" WHERE AMV.PROTOCOL_LINK_ID=XPL.PROTOCOL_LINK_ID(+) order By " +orderBy;
			}
		}
		else
		{
			whereClause = whereClause +" AND AMV.PROTOCOL_LINK_ID=XPL.PROTOCOL_LINK_ID(+) order By " +orderBy;
		}
		
	//	System.out.println("whereClause "+whereClause);
		
		if((order != null) && (order.equals("A")))
		{
			order="D";
		}
		else
		{
			order="A";
		}	

		// Constructing the table or view name to be used for querying records.
		if(purge_status != null && !purge_status.equals(""))
		{
			tableNameSuffix = sub_module+"_"+purge_status+"_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		}
		else
		{
			tableNameSuffix = sub_module+"_EVENT_APPL_MESSAGE_VW AMV,XH_PROTOCOL_LINK XPL";
		}
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}

	request.setAttribute(XHQueryRender.strQueryId,"VIEW_GENERAL_EVENTS");
	request.setAttribute("tableName",tableNameSuffix);
	request.setAttribute(XHQueryRender.col,"27");
	request.setAttribute(XHQueryRender.maxRec,maxRecords);
	request.setAttribute(XHQueryRender.whereClause,whereClause);	
//	conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,conn);	
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
		strNext = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels");
	}
	else
	{
		strNext  = " ";
	}
 	
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(msg_status));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(facility ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(msg_id1 ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(msg_dt1 ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(msg_id2 ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(msg_dt2 ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(orderBy ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(order));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf( pat_id ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(visit_id ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(action_typ ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(last_processed_date ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(not_req_rsn ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(addid ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(addeddate ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(addedwsno ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(modfid ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modifieddate ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(modifiedwsno ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(msg_date ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(applnname ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(eventtype ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(java.net.URLEncoder.encode(whereClause) ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(eventStatus));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(externalAccNoFrom));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(externalAccNoTo));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(interface_module));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(tableNameSuffix));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(authToRebuild));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(authToReplay));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(authToVwCommErr));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(authToAudit));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(viewAuth));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(protocol_link_ID));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(protocol_link_name));
            _bw.write(_wl_block51Bytes, _wl_block51);

if(arrRow.size() == 0){

            _bw.write(_wl_block52Bytes, _wl_block52);

}
else{

            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
 if(authToRebuild || authToReplay){ 
            _bw.write(_wl_block55Bytes, _wl_block55);
 } 
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(order));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order));
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(order));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(order));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(order));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(order));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(order));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block69Bytes, _wl_block69);

//	ArrayList msgAttributes = new ArrayList();

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
	
		msgProcessed = false;
		sstatusColor = "../../eXH/images/blue_square.jpg";
		statusColor="../../eXH/images/blue_square.jpg";


	//	String s1 = ((String)arrCol.get(2)).equals("null")?"":(String)arrCol.get(2);
		status =((String)arrCol.get(16)).equals("null")?"":(String)arrCol.get(16);
		status=status.trim();		
		if(status.equalsIgnoreCase("S"))  
		{			
			statusColor="../../eXH/images/green_square.jpg" ;
			msgProcessed = true;
		}
		if(status.equalsIgnoreCase("N"))  statusColor="../../eXH/images/black_square.jpg";
		if(status.equalsIgnoreCase("E"))  
		{
			statusColor="../../eXH/images/red_square.jpg" ;
			msgProcessed = true;
		}
		if(status.equalsIgnoreCase("A"))  statusColor = "../../eXH/images/yello_square.jpg" ;
		if(status.equalsIgnoreCase(""))  statusColor = "../../eXH/images/blue_square.jpg" ;

		mstatus =((String)arrCol.get(24)).equals("null")?"":(String)arrCol.get(24);
		mstatus = mstatus.trim();
		if(mstatus.equalsIgnoreCase("S"))  sstatusColor = "../../eXH/images/green_square.jpg" ;
		if(mstatus.equalsIgnoreCase("A"))  sstatusColor = "../../eXH/images/darkgreen.jpg" ;
		if(mstatus.equalsIgnoreCase("R"))  sstatusColor = "../../eXH/images/black_square.jpg" ;
		if(mstatus.equalsIgnoreCase("F"))  sstatusColor = "../../eXH/images/pink_square.jpg" ;
		if(mstatus.equalsIgnoreCase("E"))  sstatusColor = "../../eXH/images/red_square.jpg" ;

		String queryDate = "";
		String Message_Date = "";

		queryDate = ((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);
		if(!queryDate.equals("")) 
		{
			queryDate = com.ehis.util.DateUtils.convertDate(queryDate,"DMYHMS","en",locale);			
			Message_Date = XHUtil.convertToDate(queryDate,"dd/MM/yyyy hh:mm:ss");			
		}

		String startDate = "";
		String Last_Processed_date = "";

		startDate = ((String)arrCol.get(15)).equals("null")?"":(String)arrCol.get(15);
		if(!startDate.equals("")) 
			Last_Processed_date = com.ehis.util.DateUtils.convertDate(startDate,"DMYHMS","en",locale);
//			Last_Processed_date = startDate;

		String endDate="";
		String Added_Date="";

		endDate = ((String)arrCol.get(19)).equals("null")?"":(String)arrCol.get(19);
		if(!endDate.equals("")) 
			Added_Date = com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);
		//	Added_Date = endDate;

		String endDate1 = "";
		String Modified_Date = "";

		endDate1 = ((String)arrCol.get(22)).equals("null")?"":(String)arrCol.get(22);
		if(!endDate1.equals("")) 
			Modified_Date = com.ehis.util.DateUtils.convertDate(endDate1,"DMYHMS","en",locale);
		//	Modified_Date = endDate1;
		
	//	String s2 = ((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1);
	//	String s3 = ((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);
	//	String s5 = ((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);
		
	/*	String ss = "Message Id     : "+s1 +"                                                             "+
		"Application      : "+s2 +"                                 "+
		"Event              : "+s3 +"                                                     "+
		"Message Date : "+queryDate+"                                    "+
		"Facility             : "+s5;
	
		msgAttributes.clear();
		msgAttributes.add(tableNameSuffix);
		msgAttributes.add(arrCol.get(0));
		msgAttributes.add(arrCol.get(2));
		msgAttributes.add(arrCol.get(4));
		msgAttributes.add(arrCol.get(8));
	*/
	
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(statusColor));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(sstatusColor));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(j));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(j));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf( arrCol.get(12) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(13) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(0) ));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf( arrCol.get(1) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(8) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(7) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(2) ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(4) ));
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf( purge_status ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( interface_module ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( sub_module ));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(25) ));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(Rule));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(msgProcessed));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf( XHDBAdapter.checkNullNoTrim((String)arrCol.get(24))));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( arrCol.get(16)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( Message_Date));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( (String)arrCol.get(5)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)arrCol.get(10)));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf((String)arrCol.get(9)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( (String)arrCol.get(11)));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf( XHUtil.getEventName(XHDBAdapter.checkNull((String)arrCol.get(4)))));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf( j ));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(((String)arrCol.get(2)).equals("null")?"":arrCol.get(2)));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(((String)arrCol.get(1)).equals("null")?"":arrCol.get(1)));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(4)).equals("null")?"":arrCol.get(4)));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(queryDate));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(((String)arrCol.get(7)).equals("null")?"":arrCol.get(7)));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(26)).equals("null")?"":arrCol.get(26)));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(((String)arrCol.get(5)).equals("null")?"":arrCol.get(5)));
            _bw.write(_wl_block93Bytes, _wl_block93);
}
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(order));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(order));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(order));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(order));
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(order));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

	boolToggle = true;
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
	
            _bw.write(_wl_block109Bytes, _wl_block109);

		msgProcessed = false;
		status =((String)arrCol.get(16)).equals("null")?"":(String)arrCol.get(16);
		status=status.trim();
		if(status.equals("S"))  
		{
			statusColor="../../eXH/images/green_square.jpg" ;
			msgProcessed = true;
		}
		if(status.equals("N"))  statusColor="../../eXH/images/black_square.jpg" ;
		if(status.equals("E"))  
		{
			statusColor="../../eXH/images/red_square.jpg" ;
			msgProcessed = true;
		}
		if(status.equals("A"))  statusColor="../../eXH/images/yello_square.jpg" ;

		mstatus =((String)arrCol.get(24)).equals("null")?"":(String)arrCol.get(24);
		mstatus=mstatus.trim();
		
		if(mstatus.equals("S"))  sstatusColor="../../eXH/images/green_square.jpg" ;
		if(mstatus.equals("A"))  sstatusColor="../../eXH/images/yello_square.jpg" ;
		if(mstatus.equals("R"))  sstatusColor="../../eXH/images/black_square.jpg" ;
		if(mstatus.equals("F"))  sstatusColor="../../eXH/images/pink_square.jpg" ;
		if(mstatus.equals("E"))  sstatusColor="../../eXH/images/red_square.jpg" ;

		String queryDate="";
		String Message_Date="";

		queryDate=((String)arrCol.get(3)).equals("null")?"":(String)arrCol.get(3);
		if(!queryDate.equals("")) 
			//Message_Date =com.ehis.util.DateUtils.convertDate(queryDate,"DMYHMS","en",locale);
			Message_Date =queryDate;

		String startDate="";
		String Last_Processed_date="";

		startDate=((String)arrCol.get(15)).equals("null")?"":(String)arrCol.get(15);
		if(!startDate.equals("")) 
			Last_Processed_date =com.ehis.util.DateUtils.convertDate(startDate,"DMYHMS","en",locale);
	//	Last_Processed_date =startDate;

		String endDate="";
		String Added_Date="";

		endDate=((String)arrCol.get(19)).equals("null")?"":(String)arrCol.get(19);
		if(!endDate.equals("")) 
			Added_Date =com.ehis.util.DateUtils.convertDate(endDate,"DMYHMS","en",locale);
		//	Added_Date = endDate;

		String endDate1="";
		String Modified_Date="";

		endDate1=((String)arrCol.get(22)).equals("null")?"":(String)arrCol.get(22);
		if(!endDate1.equals("")) 
			Modified_Date =com.ehis.util.DateUtils.convertDate(endDate1,"DMYHMS","en",locale);
		//	Modified_Date =endDate1;

	//	String s1=((String)arrCol.get(2)).equals("null")?"":(String)arrCol.get(2);
	//	String s2=((String)arrCol.get(1)).equals("null")?"":(String)arrCol.get(1);
	//	String s3=((String)arrCol.get(4)).equals("null")?"":(String)arrCol.get(4);
	//	String s5=((String)arrCol.get(7)).equals("null")?"":(String)arrCol.get(7);

	/*	String ss="Message Id     : "+s1 +"                                                             "+
		"Application      : "+s2 +"                                        "+
		"Event              : "+s3 +"                                                     "+
		"Message Date : "+queryDate+"                                    "+
		"Facility             : "+s5; */
	
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(((String)arrCol.get(10)).equals("null")?"":arrCol.get(10)));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(9)).equals("null")?"":arrCol.get(9)));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(((String)arrCol.get(11)).equals("null")?"":arrCol.get(11)));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(12)).equals("null")?"":arrCol.get(12)));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(((String)arrCol.get(13)).equals("null")?"":arrCol.get(13)));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(((String)arrCol.get(13)).equals("null")?"":arrCol.get(13)));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(14)).equals("null")?"":arrCol.get(14)));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(Last_Processed_date));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(((String)arrCol.get(18)).equals("null")?"":arrCol.get(18)));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(Added_Date));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(20)).equals("null")?"":arrCol.get(20)));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(21)).equals("null")?"":arrCol.get(21)));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(Modified_Date));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(((String)arrCol.get(23)).equals("null")?"":arrCol.get(23)));
            _bw.write(_wl_block125Bytes, _wl_block125);
 } 
	
            _bw.write(_wl_block126Bytes, _wl_block126);

	}
	if(arrRow!=null) arrRow.clear();
	if(arrCol!=null) arrCol.clear();
	if(resultsQry!=null) resultsQry.clear();
}
catch(Exception e1)
{
	out.println("(ViewEventsOutboundDt1Test1.jsp:Exception) "+e1);
	e1.printStackTrace(System.err);
}
finally
{
	ConnectionManager.returnConnection(conn);
}

            _bw.write(_wl_block127Bytes, _wl_block127);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.OutboundEvents.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.MessageID.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Application.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Event.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.MessageDate.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.facility.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patienttype.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitID.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AccessionNumber.Label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ActionType.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.LastProcessedDate.Label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.AddedWSNo.Label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedID.Label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedDate.Label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eXH.ModifiedWSNo.Label", java.lang.String .class,"key"));
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
}
