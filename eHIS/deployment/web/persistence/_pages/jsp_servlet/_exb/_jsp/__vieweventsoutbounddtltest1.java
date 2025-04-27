package jsp_servlet._exb._jsp;

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
import eXB.*;
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
        if (sci.isResourceStale("/exb/jsp/ViewEventsOutboundDtlTest1.jsp", 1709122250962L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\t\n\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/menu.css\' type=\'text/css\'></link>\n<link rel=\'stylesheet\' href=\'../../eXH/html/ViewEvents.css\' type=\'text/css\'></link>\n\n<!-- these style setting are used for table scroll -->\n<style>\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\tdiv {float: left}\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t.testSty\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t{\n\t\twidth:expression(document.getElementById(\"indicatorTable\").clientWidth-document.getElementById(\"left_child\").clientWidth);\n\t\toverflow: scroll;\n\t}\n</style>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<script language=\'javascript\' src=\"../../eCommon/js/common.js\"></script>\n<script Language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eXB/js/XHAjaxUtil.js\"></script>\n<script Language=\"javascript\" src=\"../../eXB/js/ViewEventsOutbound.js\"></script>\n<script Language=\"javascript\" src=\"../../eXB/js/ViewEvents.js\"></script>\n<SCRIPT language=\'javascript\' src=\'../../eXH/js/menu.js\'></script>\n<Script Language=\'javascript\'>\n\n//function funSubmit\nfunction funSubmit()\n{\n\tparent.f_query_add_mod.VIEW_EVENTS.action = \'../../eXB/jsp/ViewEventsOutboundDtlTest1.jsp\';\n\tparent.f_query_add_mod.VIEW_EVENTS.target=\"f_query_add_mod\";\n\tparent.f_query_add_mod.VIEW_EVENTS.submit();\n}\n//function funModify\nfunction funModify(obj)\n{\n\tparent.commontoolbarFrame.document.forms[0].apply.style.display=\'block\';\n}\n//function changeMe\nfunction changeMe(msgId) \n{\t\n\tdocument.getElementById(msgId).style.color = \"green\";\n}\n//function doChanges\nfunction doChanges() \n{\n\tthis.document.forms[0].action=\"../../eXB/jsp/ViewEventsOutboundDtlTest1.jsp\";\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n\n\twindow.event.target.style.color = \"green\";\n\twindow.event.target.style.font = \"bold\";\n\twindow.event.target.style.fontSize = \"15px\";\n} \n//function funAction\nfunction funAction(typ)\n{  \n\tparent.f_query_add_mod.VIEW_EVENTS.action_type.value = typ;\n\tfunSubmit();\n\n}\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\t\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXB/jsp/ViewEventsOutboundDtlTest1.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\n\n//function func1\nfunction  func1(accessionNumber,externalAccessionNumber,applicationId,applicationName,facilityId,facilityName,\n\t\t\t\t\tmsgId,eventType,reason,purge_status,interface_module,sub_module,protocol_link_id,Rule,\n\t\t\t\t\tmsgProcessed,msgStatus,eventStatus,msgDate,patID,episodeID,episodeType,visitID)\n{\t  \t  \n\tvar url=\'&accessionNumber=\'+accessionNumber+\n\t\t\t\'&externalAccessNumber=\'+externalAccessionNumber+\n\t\t\t\'&applicationId=\'+applicationId+\n\t\t\t\'&applicationName=\'+applicationName+\n\t\t\t\'&facilityId=\'+facilityId+\n\t\t\t\'&facilityName=\'+facilityName+\n\t\t\t\'&msgId=\'+msgId+\n\t\t\t\'&eventType=\'+eventType+\n\t\t\t\'&reason=\'+reason+\n\t\t\t\'&purge_status=\'+purge_status+\n\t\t\t\'&interface_module=\'+interface_module+\n\t\t\t\'&sub_module=\'+sub_module+\n\t\t\t\'&protocol_link_id=\'+protocol_link_id+\n\t\t\t\'&Rule=Y\'+\n\t\t\t\'&msgProcessed=\'+msgProcessed+\n\t\t\t\'&msgStatus=\'+msgStatus+\n\t\t\t\'&eventStatus=\'+eventStatus+\n\t\t\t\'&msgDate=\'+msgDate+\n\t\t\t\'pat_id=\'+patID+\n\t\t\t\'episode_id=\'+episodeID+\'&episode_type=\'+episodeType+\'&visit_id=\'+visitID;\t\t\t\t\n\t\n\tthis.document.forms[0].action=\"../../eXB/jsp/ViewEventsOutboundFooter.jsp?\"+url;\n\tthis.document.forms[0].target = \"messageFrame\";\n\tthis.document.forms[0].submit();\n}\n\n</Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n\n<body onKeyDown =\'lockKey()\' onMouseDown=\'CodeArrest()\'>\n<form name=\"VIEW_EVENTS\" id=\"VIEW_EVENTS\" method=\"POST\" action=\'../../eXB/jsp/ViewEventsOutboundHeader.jsp\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n<input type=\'hidden\' name=\'msg_status\' id=\'msg_status\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' >\n<input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n<input type=\'hidden\' name=\'temp\' id=\'temp\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n<input type=\'hidden\' name=\'facility\' id=\'facility\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n<input type=\'hidden\' name=\'msg_id1\' id=\'msg_id1\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n<input type=\'hidden\' name=\'msg_dt1\' id=\'msg_dt1\' value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\'>\n<input type=\'hidden\' name=\'msg_id2\' id=\'msg_id2\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n<input type=\'hidden\' name=\'msg_dt2\' id=\'msg_dt2\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n<input type=\'hidden\' name=\'orderBy\' id=\'orderBy\' value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'> \n<input type=\'hidden\' name=\'order\' id=\'order\' value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'>\n<input type=\'hidden\' name=\'merg_pat_id\' id=\'merg_pat_id\' value=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\'>\n<input type=\'hidden\' name=\'episode_type\' id=\'episode_type\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\'>\n<input type=\'hidden\' name=\'visit_id\' id=\'visit_id\' value=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\'>\n<input type=\'hidden\' name=\'action_typ\' id=\'action_typ\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'>\n<input type=\'hidden\' name=\'last_processed_date\' id=\'last_processed_date\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\' name=\'not_req_rsn\' id=\'not_req_rsn\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\'>\n<input type=\'hidden\' name=\'addid\' id=\'addid\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'>\n<input type=\'hidden\' name=\'addeddate\' id=\'addeddate\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\'>\n<input type=\'hidden\' name=\'addedwsno\' id=\'addedwsno\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'modfid\' id=\'modfid\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'modifieddate\' id=\'modifieddate\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'modifiedwsno\' id=\'modifiedwsno\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'msg_date\' id=\'msg_date\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'applnname\' id=\'applnname\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'eventtype\' id=\'eventtype\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'whereClause\' id=\'whereClause\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'purge_status\' id=\'purge_status\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'event_status\' id=\'event_status\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'externalAccNoFrom\' id=\'externalAccNoFrom\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'externalAccNoTo\' id=\'externalAccNoTo\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'interface_module\' id=\'interface_module\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'tableNameSuffix\' id=\'tableNameSuffix\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'sub_module\' id=\'sub_module\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'comm_mode\' id=\'comm_mode\' value=\'Outbound\'>\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'rebuildAut\' id=\'rebuildAut\' id=\"rebuildAut\" value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'replayAut\' id=\'replayAut\' id=\"replayAut\" value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\'hidden\' name=\'commExpAut\' id=\'commExpAut\' id=\"commExpAut\" value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'audtiAut\' id=\'audtiAut\' id=\"audtiAut\" value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'viewAuth\' id=\'viewAuth\' id=\"viewAuth\" value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=\'hidden\' name=\'dispMode\' id=\'dispMode\' id=\"dispMode\" value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'protocol_link_id\' id=\'protocol_link_id\' id=\"protocol_link_id\" value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'protocol_link_name\' id=\'protocol_link_name\' id=\"protocol_link_name\" value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n\n";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\t\n\n<script>\t\n\talert(getMessage(\'XH1021\',\'XH\'));\n\teditQuery(); // calling header page with the query criteria in the request object\n</script>\n\n";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n\n<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' align=center>\n<tr>\n\t<td colspan=\"2\" align=\"center\" class=\"COLUMNHEADER\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</td>\n</tr>\n<tr>\t   \n\t<td align=\"left\" class=\"CAGROUP\">\n\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"editQuery();\" TITLE=\"Edit Query\">\n\t\t\tEditQuery\n\t\t</A>\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t<A class=\'linkClass1\' onmouseover=\'hotStateImage(this)\' onmouseout=\'restorePrevState(this)\' style=\'cursor:pointer\' onClick=\"refreshResults(\'ViewEventsOutboundDtlTest1\');\" TITLE=\"Refresh Events\">\n\t\t\tRefresh\n\t\t</A>\n\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t</td>\n\t<td align=\"right\" class=\"CAGROUP\"> \n\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="</A>\n\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</A>\n\t</td>\n</tr>\n</table>\n\n<div id=\"left_child\" style=\"display:none;\">\n<table id=\"table1\" cellspacing=0 cellpadding=3 border=1>\t\n\t<tr>\n\t\t<td class=\'COLUMNHEADER\' title=\"Select\">\n\t\t          <font color=white>Select</font> </td>\t\n\t\t</td>\n\n\t\t<td class=\'COLUMNHEADER\' title=\"Event Status\">\n\t\t\t&nbsp; $ &nbsp;\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' title=\"Message Status\" href=\"javascript:callForOrderBy(\'MESSAGE_STATUS_DESC\',\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\');\" onclick=\'\'>\n\t\t\t<font color=white>\n\t\t\t&nbsp; # &nbsp; \n\t\t\t</font>\n\t\t</td> \n<!--\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'lpad(Message_ID,20)\',\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\');\" onclick=\'\'>\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'application_name\',\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\');\"onclick=\'\'>\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'EVENT_TYPE\',\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\');\"onclick=\'\' >\n\t\t\t<font color=white>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'MESSAGE_DATE\',\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'FACILITY_NAME\',\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'protocol_link_ID\',\'";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\');\"onclick=\'\'><font color=white>Gateway</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_ID\',\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="</font>\n\t\t</td> -->\n\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'lpad(INV_NO,20)\',\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\');\" onclick=\'\'>\n\t\t\t<font color=white>Invoice Number</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'INV_DATE\',\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\');\"onclick=\'\'>\n\t\t\t<font color=white>Invoice Date</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'AMOUNT\',\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\');\"onclick=\'\' >\n\t\t\t<font color=white>Amount</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'VISIT_DATE\',\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\');\"onclick=\'\' >\n\t\t\t<font color=white>Visit Date</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_NAME\',\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\');\"onclick=\'\' >\n\t\t\t<font color=white>Patient Name</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'PATIENT_TYPE\',\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\');\"onclick=\'\'><font color=white>Patient Type</font>\n\t\t</td>\n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'CARD_ID\',\'";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\');\"onclick=\'\' >\n\t\t\t<font color=white>Card ID</font>\n\t\t</td> \n\t\t<td class=\'COLUMNHEADER\'>\n\t\t\t<a id=\'a001\' href=\"javascript:callForOrderBy(\'CARD_ISS_DATE\',\'";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\');\"onclick=\'\' >\n\t\t\t<font color=white>Card Issue Date</font>\n\t\t</td> \n\t</tr>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t<tr>\n\t<td  ";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 =" align=\"left\" >\n\t\t<input type=checkbox name=\'\' id=\'\' value=\'\' >\n\t</td>\n\t<td nowrap  ";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 =" align=\"center\" ><font size=1 >&nbsp;<img src=\'../../eXH/images/blue_square.jpg\' height=10 ></td>\n\t<td nowrap  ";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 =" align=\"center\" ><font size=1 >&nbsp;<img src=\'../../eXH/images/blue_square.jpg\' height=10 ></td>\n\t\n\t<td  ";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" align=\"left\" >\n\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t</td>\n\t<td  ";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t</td>\n\t</tr>\n</table>\n</div>\n\t\n<SCRIPT>\n\tdocument.getElementById(\"left_child\").style.display = \"block\";\n\tdocument.getElementById(\"right_child\").style.display = \"block\";\n\tparent.messageFrame.location.href = \"../../eXB/jsp/ViewEventsOutboundFooter.jsp?commType=outbound\"; \n</SCRIPT>\n\t\n\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\n\n</form>\n</html>\n\n\n";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

request.setCharacterEncoding("UTF-8"); 
String locale = ((String)session.getAttribute("LOCALE"));

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
 
String msg_status,facility,msg_id1,msg_dt1,msg_id2,msg_dt2,order;
String tabValue,pat_id,merg_pat_id,episode_type,episode_id,visit_id,action_typ,last_processed_date,not_req_rsn,addid,addeddate,addedwsno,modfid,modifieddate,modifiedwsno,msg_date,applnname,eventtype,whereClause,pmode,eventStatus;
String statusColor="../../eXH/images/black_square.jpg";
String sstatusColor="../../eXH/images/blue_square.jpg";     
String status;									  
String mstatus;
String orderBy;
String tableNameSuffix= "";
String function_id = XHDBAdapter.checkNull(request.getParameter("function_id")); // Used in ViewEventsOutboundHeader when Edit Query is clicked.
msg_status=null;
facility=null;									    
msg_id1=null;						    
msg_dt1=null;
msg_id2=null;
msg_dt2=null;
order=null;
orderBy=null;	
tabValue=null;
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
String externalAccNoFrom = null;
String externalAccNoTo = null;
String purge_status = null; 
String protocol_link_ID = null;
String maxRecords = "24";
String Rule=XHDBAdapter.checkNull(request.getParameter("Rule"));
boolean msgProcessed = false;

Properties p = (Properties) session.getValue("jdbc");
String loggedUser = p.getProperty("login_user");


            _bw.write(_wl_block9Bytes, _wl_block9);

System.out.println("test123");
boolean boolToggle =  true;	
String strTDClass = "";
Connection conn = null;
try
{   
	action_type	= XHDBAdapter.checkNull(request.getParameter("action_type"));
	msg_status = XHDBAdapter.checkNullNoTrim(request.getParameter("msg_status"));
	facility = XHDBAdapter.checkNull(request.getParameter("facility")); 
	msg_id1	= XHDBAdapter.checkNull(request.getParameter("msg_id1")); 
	msg_id2	= XHDBAdapter.checkNull(request.getParameter("msg_id2"));  
	msg_dt1	= XHDBAdapter.checkNull(request.getParameter("msg_dt1")); 
	msg_dt2	= XHDBAdapter.checkNull(request.getParameter("msg_dt2")); 
	orderBy	= XHDBAdapter.checkNull(request.getParameter("orderBy"));
	order = XHDBAdapter.checkNull(request.getParameter("order"));
	tabValue = XHDBAdapter.checkNull(request.getParameter("tabValue"));
	pat_id = XHDBAdapter.checkNull(request.getParameter("pat_id"));
	merg_pat_id	= XHDBAdapter.checkNull(request.getParameter("merg_pat_id"));
	episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
	episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
	visit_id = XHDBAdapter.checkNull(request.getParameter("visit_id"));
	action_typ = XHDBAdapter.checkNull(request.getParameter("action_typ"));
	last_processed_date	= XHDBAdapter.checkNull(request.getParameter("last_processed_date"));
	not_req_rsn	= XHDBAdapter.checkNull(request.getParameter("not_req_rsn"));
	addid = XHDBAdapter.checkNull(request.getParameter("addid"));
	addeddate = XHDBAdapter.checkNull(request.getParameter("addeddate"));
	addedwsno = XHDBAdapter.checkNull(request.getParameter("addedwsno"));
	modfid = XHDBAdapter.checkNull(request.getParameter("modfid"));
	modifieddate = XHDBAdapter.checkNull(request.getParameter("modifieddate"));	
	modifiedwsno = XHDBAdapter.checkNull(request.getParameter("modifiedwsno"));
	msg_date = XHDBAdapter.checkNull(request.getParameter("msg_date"));
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

	System.out.println("protocol_link_name "+protocol_link_name);
	
	String authSql = "SELECT replay_yn,rebuild_yn,reload_yn,comm_exception_yn,write_to_excel,audit_yn,view_yn FROM xh_authorized_user WHERE UPPER(LOGIN_NAME)=UPPER('"+loggedUser+"')"; 
	
	ResultSet authRS = null;

	boolean authToAudit = false;	
	boolean authToVwCommErr = false;
	boolean authToRebuild = false;
	boolean authToReplay = false;
	boolean xlsAuth = false;
	boolean viewAuth = false;

	String Inv_No = "";
	String Inv_Date = "";
	String Amount = "";
	String Visit_Date = "";
	String Patient_Name = "";
	String Patient_Type = "";
	String Card_ID = "";
	String Card_Iss_Date = "";

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
		System.out.println("sub_module.... "+sub_module);
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
	whereClause =" WHERE "; // Not using for eBilling 
	String whereClause1 =  "";
	/*",SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,4)-1),  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,5)-1) ,  A.PATIENT_ID HN,  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,6)-1),   SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,7)-1) ,  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,8)-1) ,      SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,9)-1) ,  SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,10)-1), SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)+1,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12) - INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,11)-1) , SUBSTR(SYS_DEF_MESSAGE_TEXT,INSTR(SYS_DEF_MESSAGE_TEXT,'|',1,12)+1)  FROM XB_EVENT_APPL_MESSAGE_XL_VW A "; */

	whereClause1 = whereClause1+"  WHERE  EVENT_TYPE = NVL('EB1',EVENT_TYPE) AND EVENT_STATUS = NVL('S',EVENT_STATUS) AND MESSAGE_STATUS = NVL('H',MESSAGE_STATUS)  ORDER BY 1,3,9";

    System.out.println("whereClause1 : "+whereClause1);

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
			whereClause =whereClause +" AND TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
								"TO_DATE(NVL('"+messageDateFrom+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')"+
								" AND "+ "TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
		} 

		if((flag==false) && (msg_dt1 != null) && (!(msg_dt1.equals(""))))			
		{
			whereClause =whereClause +"  TO_DATE(MESSAGE_DATE) BETWEEN  "+  	
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
				whereClause = whereClause +" AND TO_DATE(MESSAGE_DATE) <  "+  								
								" TO_DATE(NVL('"+messageDateTo+"',TO_CHAR(MESSAGE_DATE,'dd/mm/yyyy')),'dd/mm/yyyy')";
			}
		} 

		if((flag==false) && (msg_dt2 != null) && (!(msg_dt2.equals(""))))			
		{
			if((msg_dt1 != null) && (!(msg_dt1.equals("")))) {}
			else
			{
				whereClause = whereClause +" TO_DATE(MESSAGE_DATE) <  "+  								
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
		System.out.println("orderBy "+orderBy);
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

//	request.setAttribute(XHQueryRender.strQueryId,"VIEW_GENERAL_EVENTS"); eBilling
	request.setAttribute(XHQueryRender.strQueryId,"VIEW_GENERAL_EVENTS_EBILL");
	request.setAttribute("tableName",tableNameSuffix);
//	request.setAttribute(XHQueryRender.col,"27"); eBilling
    request.setAttribute(XHQueryRender.col,"51");
	request.setAttribute(XHQueryRender.maxRec,maxRecords);
//	request.setAttribute(XHQueryRender.whereClause,whereClause);	Commented for eBilling
	request.setAttribute(XHQueryRender.whereClause,whereClause1);	
//	conn = ConnectionManager.getConnection(request);
	HashMap resultsQry = XHQueryRender.getResults(request,session,conn);	
	ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 
	ArrayList arrCol = null;
	System.out.println("test1234");

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
 	
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(msg_status));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(temp));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(msg_id1 ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(msg_dt1 ));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(msg_id2 ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(msg_dt2 ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(orderBy ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(order));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(merg_pat_id ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(episode_type ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(visit_id ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(action_typ ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(last_processed_date ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(not_req_rsn ));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(addid ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(addeddate ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(addedwsno ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(modfid ));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(modifieddate ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(modifiedwsno ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(msg_date ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(applnname ));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(eventtype ));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(java.net.URLEncoder.encode(whereClause) ));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(purge_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(eventStatus));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(externalAccNoFrom));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(externalAccNoTo));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(interface_module));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(tableNameSuffix));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(sub_module));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(authToRebuild));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(authToReplay));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(authToVwCommErr));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(authToAudit));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(viewAuth));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(dispMode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(protocol_link_ID));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(protocol_link_name));
            _bw.write(_wl_block52Bytes, _wl_block52);

if(arrRow.size()==0){

            _bw.write(_wl_block53Bytes, _wl_block53);

}  
else{

            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
 if(authToRebuild || authToReplay){ 
            _bw.write(_wl_block56Bytes, _wl_block56);
 } 
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf( strNext ));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(order));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(order));
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(order));
            _bw.write(_wl_block63Bytes, _wl_block63);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(order));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(order));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(order));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(order));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(order));
            _bw.write(_wl_block65Bytes, _wl_block65);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(order));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(order));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(order));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(order));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(order));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(order));
            _bw.write(_wl_block76Bytes, _wl_block76);
            out.print( String.valueOf(order));
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(order));
            _bw.write(_wl_block78Bytes, _wl_block78);

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
        String episode_typ = "";
		String enabled_yn = "";
		String policy_dsc = "";

	
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(41))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(42))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(43))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(44))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(45))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(46))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(47))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(48))+""));
            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(strTDClass));
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(XBDBAdapter.checkNull((String)arrCol.get(49))+""));
            _bw.write(_wl_block85Bytes, _wl_block85);

		}
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

            _bw.write(_wl_block86Bytes, _wl_block86);
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
}
