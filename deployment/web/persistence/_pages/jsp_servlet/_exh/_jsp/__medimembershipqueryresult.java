package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.Connection;
import java.util.HashMap;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.XHQueryRender;
import eXH.XHDBAdapter;
import eXH.XHUtil;

public final class __medimembershipqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/MediMembershipQueryResult.jsp", 1743587031758L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<HTML>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\n<HEAD>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t  \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'></link>\t\t      \n<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/Tabs.css\'></link>\t    \n<style>\n.left_child{\n\toverflow-y:auto;\n }\n</style>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/jquery-3.6.3.js\' language=\'javascript\'></script>\n\n<script language=\"javascript\">\n\nfunction funSubmit()\n{\n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.action = \'../../eXH/jsp/MediMembershipQueryResult.jsp\';\n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.target=\"resultFrame\";\n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.submit();\n}\n\nfunction funAction(typ)\n{  \n\tparent.resultFrame.PAYER_CHECK_QUERY_FORM.action_type.value = typ;\n\tfunSubmit();\n}\n\n//function callForOrderBy\nfunction callForOrderBy(obj,order)\n{\t\n\tif(order == \'A\') obj = obj + \' asc\';\n\tif(order == \'D\') obj = obj + \' desc\';\n\tvar url = \'&orderBy=\' + obj + \'&order=\' + order;\n\n\tthis.document.forms[0].action_type.value = \"\";\n\tthis.document.forms[0].action = \"../../eXH/jsp/MediMembershipQueryResult.jsp?\"+url;\n\tthis.document.forms[0].target = \"f_query_add_mod\";\n\tthis.document.forms[0].submit();\n}\n\nasync function checkEligibility(obj)\n{\t\n\tvar checkType = \"\";\n\t\n\tvar checkTypeButtons = document.getElementsByName(\'CheckType\');\n\n\n\t//var request_status = obj.getAttribute(\'request_status\');\n    var trans_num = obj.getAttribute(\'trans_num\');\n\tvar event_type = obj.getAttribute(\'event_type\');\n\n\t//var event_type = document.forms[0].event_type.value;\n\t//var check_type = obj.getAttribute(\'check_type\');\n\t//var eligibility_status_type = obj.getAttribute(\'request_status\');\n\tvar dialogHeight = \"30vh\";    // have to remove \n\tvar dialogWidth  = \"55vw\";\n\tvar dialogTop    = \"50\";\n\n    if(!(event_type !=\"CLA\") || !(event_type !=\"CLE\")){\n\t\tdialogHeight = \"40vh\";    // have to remove \n\t\tdialogWidth  = \"75vw\";\n\t\tdialogTop    = \"50\";\n\t}\n\ttitle=\"Patient Claims Response Details \";\n\ttitle=encodeURIComponent(title);\n\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\n\tvar params= \"trans_num=\"+trans_num;\n\n\tvar arguments = new Array();\n\tvar url = \"../../eXH/jsp/MediQueryResponsePopUp.jsp?\" +params;\n\t\n\tvar retVal =await window.showModalDialog(url,arguments,features);\n      \n}\n\nfunction includeBoxChecked() {\n\n\tif (document.forms[0].includeMastercheckbox.checked == true) {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = true;\n\t\t\t}\n\t\t} else if (document.forms[0].gatewayservers.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = true;\n\t\t}\n\t}\n\telse {\n\t\tif (document.forms[0].includeCheckbox.length != undefined) {\n\t\t\tfor ( var a = 0; a < document.forms[0].includeCheckbox.length; a++) {\n\t\t\t\tdocument.forms[0].includeCheckbox[a].checked = false;\n\t\t\t}\n\t\t} else if (document.forms[0].includeCheckbox.length == undefined) {\n\t\t\tdocument.forms[0].includeCheckbox.checked = false;\n\t\t}\n\t}\n\treturn true;\n}\nasync function ViewTransDetails(obj){\n\n\t\tvar Patient_id = obj.getAttribute(\'patient_id\');\n\t    var Episode_id = obj.getAttribute(\'episode_id\');\n\t\tvar Visit_id = obj.getAttribute(\'visit_id\');\n\t\tvar doc_num = obj.getAttribute(\'doc_num\');\n\t\tvar bill_doc_code = obj.getAttribute(\'bill_doc_code\');\n\t\tvar trans_type = obj.getAttribute(\'trans_type\');\n\n\t\tdialogHeight = \"35vh\";    // have to remove \n\t\tdialogWidth  = \"55vw\";\n\t\tdialogTop    = \"50\";\t\n\t\t\n\t\tvar title=\"Previous Transaction Details \";\n\t\tvar features     = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:yes\" ;\n\n\t\t// we need to send required values which is need to be compared from existing and responseMsg\n\t\tif(Patient_id != null && Patient_id != \"\" && Patient_id != \" \")\n\t\t{\n\t\t\tvar arguments = new Array();\n\t\t\tvar url = \"../../eXH/jsp/MediClaimsTransDetailsPopup.jsp?Patient_id=\"+Patient_id+\"&Episode_id=\"+Episode_id+\"&Visit_id=\"+Visit_id+\"&doc_num=\"+doc_num+\"&bill_doc_code=\"+bill_doc_code+\"&trans_type=\"+trans_type;\n\t\t\tvar retVal =await window.showModalDialog(url,arguments,features);\n\t\t}\n\t\telse\n\t\t{\n\t\t\talert(\"APP-XH0070 Response is not available\");\n\t\t}\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n</head>\t\n\n<BODY leftmargin=0 topmargin=0 onMouseDown=\"CodeArrest()\" >\n\t<form name=\"PAYER_CHECK_QUERY_FORM\" id=\"PAYER_CHECK_QUERY_FORM\" method=\"POST\" action=\'\'  >\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t\t\t<script>\n\t\t\t\talert(\'APP-002415 Query caused no records to be retrieved\');\n\t\t\t\thistory.go(-1);\n\t\t\t\tparent.resultFrame.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t\t\t<table cellspacing=0 cellpadding=3 width=\'100%\' align=center border=1>\n\t\t\t\t\t<tr>\n\t\t\t\t\t\t<td colspan=\"27\" class=\"COLUMNHEADER\" align=\'center\'>Eclaims Query Result</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t   \n\t\t\t\t\t\t<td align=\"right\" class=\"CAGROUP\" > \n\t\t\t\t\t\t<A class=\'label\' style=\'cursor:pointer\' onClick=\"funAction(\'P\')\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</A>\n\t\t\t\t\t\t<A class=\'label\' onClick=\"funAction(\'N\')\" style=\'cursor:pointer\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</A>\n\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\n\t\t\t\t<div id=\"left_child\" class=\"left_child\">\n\t\t\t\t\t<table id=\"indicatorTable\" cellspacing=0 cellpadding=3 width=\'100%\' border=1 align=center>\t\n\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'13%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</font>\n\t\t\t\t\t\t\t</td>\n                            <td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t        <td class=\'COLUMNHEADER\' width=\'15%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t        <td class=\'COLUMNHEADER\' width=\'8%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'15%\'>\n\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</font>\n\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t<td class=\'COLUMNHEADER\' width=\'6%\'>\n\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</font>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t    <input type=\'hidden\' name=\'action_type\' id=\'action_type\' value=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\t\t     \n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<tr width=\'100%\' id = \'trGrpHeader";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' >\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td width=\'300\' style=\'display:block\' class=\'CAGROUP\' >";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t\t\t<td width=\'300\' style=\'display:block\' class=\'CAGROUP\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" </td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan = \"8\">\n\t\t\t\t\t\t\t\t<table  cellspacing=\"0\" cellpadding=\"3\" width=\"100%\" border=\"1\" align=\"center\">\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\' style=\"font-size:11px;\" width=\'8%\' align=\"center\">\n\t\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'12%\'>\n\t\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</font>\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'10%\'>\n\t\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'10%\'>\n\t\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'10%\'>\n\t\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</font>\n\t\t\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\' style=\"font-size:11px;\" width=\'8%\'>\n\t\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\' style=\"font-size:11px;\" width=\'12%\'>\n\t\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'15%\'>\n\t\t\t\t\t\t\t\t\t<font color=white>";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" ";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</font>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'15%\'>\n\t\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</font>\n\t\t\t\t\t\t\t\t</td>\t\t\n\t\t\t\t\t\t\t\t<td class=\'COLUMNSUBHEADER\'  style=\"font-size:11px;\" width=\'15%\'>\n\t\t\t\t\t\t\t\t\t<font color=white >";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font>\n\t\t\t\t\t\t\t\t</td>\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t\t<td class=\'gridData\' align=\'center\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</td>\n\t\t\t\t\t\t\t<td  class=\'gridData\' style=\"font-size:11px;\"> ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" </td>\n\t\t\t\t\t\t\t<td  class=\'gridData\' style=\"font-size:11px;\"> ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" </td>\n\t\t\t\t\t\t\t<td  class=\'gridNumericData\' style=\"font-size:11px;\"> ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</div>\n\t\t\n\t\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t</table>\n\t</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 																	    
request.setCharacterEncoding("UTF-8");
String locale = ((String)session.getAttribute("LOCALE"));
String sStyle =	(session.getAttribute("PREFERRED_STYLE")!=null)?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		String order = "";
		String orderBy = "";
		String action_type=null;
		Connection conn = null;
		Statement stmt=null;
		ResultSet rset=null ;
		ResultSet rsevent=null;

		String event_type = "";
		String dest_code = "";

		String rs_operating_facility_id = "", rs_patientId="",rs_encounterId = "", rs_billNumber = "", rs_sex = "", rs_nationalId = "", rs_transDate = "", rs_patientName = "",rs_episode_id ="";
		String rs_memberId = "", rs_serviceCode = "", rs_specialityCode = "", rs_custCode = "", rs_patientClass = "", rs_locationType = "", rs_destCode = "";
		String rs_firstName = "", rs_secondName = "", rs_intial = "", rs_dob = "",rs_familyName="",rs_approval_status = "",rs_request_status = "",rs_trans_Id = "",rs_user_name ="",rs_visit_id ="", rs_event_type = "",rs_trans_type = "",rs_doc_num = "",rs_doc_type = "",	rs_amount = "", rs_adm_date = "";

		String currentSubGroup = "",prevSubGroup = "",checkboxvalue = "",Checkboxname = "",l_img_vw_dtl_str = "";
		int billDetailsRowCount = 0;

		int l_srl_trans_no = 0;

		String rs_patientClass_desc = "",rs_approval_status_desc = "",rs_event_type_desc = "";

		String l_event_trans_query = "",l_event_trans_type = "", l_case_trans_no = "", l_approval_trans_status = "", l_current_status = "";

		HttpSession httpSession = request.getSession(false);
		String customer_id = XHDBAdapter.checkNull(request.getParameter("customer_id"));
		String patient_id= XHDBAdapter.checkNull(request.getParameter("patient_id"));
		String patient_class_episode = XHDBAdapter.checkNull(request.getParameter("patient_class_episode"));
		String episode_id = XHDBAdapter.checkNull(request.getParameter("episode_id"));
		String customer_group = XHDBAdapter.checkNull(request.getParameter("customer_group"));
		String episode_type = XHDBAdapter.checkNull(request.getParameter("episode_type"));
		String trans_from_dt = XHDBAdapter.checkNull(request.getParameter("trans_from_dt"));

		String bill_from = XHDBAdapter.checkNull(request.getParameter("bill_from"));
		String bill_to= XHDBAdapter.checkNull(request.getParameter("bill_to"));

		if(trans_from_dt!="" && trans_from_dt!=null)
		{
		   trans_from_dt = trans_from_dt+ " 00:00:00";
		}

		String trans_to_dt = XHDBAdapter.checkNull(request.getParameter("trans_to_dt"));
		if(trans_to_dt!="" && trans_to_dt!=null)
		{
		   trans_to_dt =trans_to_dt + " 23:59:59";
		}

		event_type = XHDBAdapter.checkNull(request.getParameter("event_type"));
		if(event_type.equals("ELC"))
		{
		   event_type ="ELCREQ";
		}
		if(event_type.equals("ECL"))
		{
		   event_type ="ECLREQ";
		}
		String check_type = XHDBAdapter.checkNull(request.getParameter("check_type"));
		String eligibility_status_type = XHDBAdapter.checkNull(request.getParameter("eligibility_status_type"));

		String isDebugYN = (XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM"));

		if(isDebugYN.equals("Y")){
			System.out.println("MediMembershipQueryResult.jsp:::customer_id....."+customer_id);
			System.out.println("MediMembershipQueryResult.jsp:::patient_id....."+patient_id);
			System.out.println("MediMembershipQueryResult.jsp:::trans_from_dt....."+trans_from_dt+" trans_to_dt :::: "+trans_to_dt );
			System.out.println("MediMembershipQueryResult.jsp:::event_type....."+event_type +"::: check_type ::: "+check_type+" ::: eligibility_status_type ::: "+eligibility_status_type);
		}
		/*"patient_id="+patient_id+"&encounter_id="+encounter_id+"&practitioner_id="+practitioner_id+"&patient_class="+patient_class+"&nursing_unit_code="+nursing_unit_code+"&period_dt1="+period_dt1+"&period_dt2="+period_dt1+"&company_name="+company_name; */

		boolean  boolToggle = true;
		String strTDClass = "";
		String whereClause = "";
		int totalRecords=0;

		Connection dbConn = null;
		ResultSet rs=null;
		PreparedStatement pstmt = null;

		try
		{ 
			conn = ConnectionManager.getConnection(request);

			/*

			whereClause = " where a.PATIENT_ID = b.PATIENT_ID AND b.patient_id = d.patient_id AND b.episode_id = d.episode_id and d.EVENT_TYPE = e.TRANS_TYPE AND d.APPROVAL_STATUS = e.STATUS_CODE(+) ";

			*/

			if(isDebugYN.equals("Y"))
			{
				System.out.println("on admission.. patient id..."+patient_id);
			}
			if(patient_id != null && patient_id != "" && patient_id != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND PATIENT_ID =  '#patient_id'";
				else
					whereClause = whereClause + " where PATIENT_ID =  '#patient_id'";
			}
			if(customer_id != null && customer_id != "" && customer_id != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND CUST_CODE =  '#customer_id'";
				else	
					whereClause = whereClause + " where CUST_CODE =  '#customer_id'";
			}
			if(customer_group != null && customer_group != "" && customer_group != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND CUST_GROUP_CODE = '#customer_group'";
				else
					whereClause = whereClause + " where CUST_GROUP_CODE =  '#customer_group'";
			}
			if(episode_id != null && episode_id != "" && episode_id != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND episode_id = '#episode_id'";
				else
					whereClause = whereClause + " where episode_id = '#episode_id'";
			}

			if(trans_from_dt!="" && trans_from_dt!=null && trans_to_dt!="" && trans_to_dt!=null)
			{		
				if (whereClause.length()>0)
					whereClause = whereClause + " And TO_Date(modified_date ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+trans_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+trans_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
				else
					whereClause = whereClause + " where TO_Date(modified_date ,'DD/MM/YY HH24:MI:SS') BETWEEN TO_Date('"+trans_from_dt+"','DD/MM/YYYY HH24:MI:SS') AND TO_Date('"+trans_to_dt+"', 'DD/MM/YYYY HH24:MI:SS')";
			}
			if(event_type != null && event_type != "" && event_type != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND TRANS_TYPE = '"+event_type+"'";
				else
					whereClause = whereClause + " where TRANS_TYPE =  '"+event_type+"' ";
			}

			if(check_type != null && check_type != "" && check_type != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND EVENT_TYPE = '"+check_type+"'";
				else
					whereClause = whereClause + " where EVENT_TYPE =  '"+check_type+"'";
			}
			if(bill_from != null && bill_from != "" && bill_from != " " && bill_to != null && bill_to != "" && bill_to != " ")
			{
				if (whereClause.length()>0)
					whereClause = whereClause + " AND DOC_NUM BETWEEN '#bill_from' AND '#bill_to'";
				else
					whereClause = whereClause + " where DOC_NUM BETWEEN '#bill_from' AND '#bill_to' ";
			}
			if(eligibility_status_type != null && eligibility_status_type != "" && eligibility_status_type != " " )
			{ 
				if (whereClause.length()>0)
					whereClause = whereClause + " AND APPROVAL_STATUS =  '#eligibility_status_type'";  
				else
					whereClause = whereClause + " where APPROVAL_STATUS =  '#eligibility_status_type'";
			}
	

			whereClause = whereClause + " order by patient_id, patient_name, sex, patient_class, episode_id, srl_no desc";

			request.setAttribute(XHQueryRender.strQueryId,"ELIGIBILITYCHECKQUERY");

			if(isDebugYN.equals("Y")){
				System.out.println("MediMembershipQueryResult :: whereClause....."+whereClause);
			}
			request.setAttribute(XHQueryRender.col,"36"); 
			request.setAttribute(XHQueryRender.maxRec,"7");
			request.setAttribute(XHQueryRender.whereClause,whereClause);
			HashMap resultsQry = XHQueryRender.getResults(request,session,conn,"");	
			//String sqlQuery= XHQueryRender.sqlQuery;	
			//System.out.println("sqlQuery... "+sqlQuery);
			ArrayList arrRow = (ArrayList)resultsQry.get("qry_result"); 

			ArrayList arrCol = null;
			boolean boolNext = ((Boolean)resultsQry.get("next")).booleanValue(); 
			boolean boolPrevious = ((Boolean)resultsQry.get("previous")).booleanValue(); 
			//if(isDebugYN)System.out.println("boolPrevious...."+boolPrevious);
			//if(isDebugYN)System.out.println("boolNext...."+boolNext);
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
			if(isDebugYN.equals("Y")){
				System.out.println("MediMembershipQueryResult :: action_type in jsp...."+action_type);
			}

			if(arrRow.size()==0)
			{
				
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
			else
			{
				
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf( strPrevious ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf( strNext ));
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
            out.print( String.valueOf(action_type));
            _bw.write(_wl_block18Bytes, _wl_block18);

						System.out.println("MediMembershipQueryResult :: Before getting details....."+arrRow.size());
						Map cmp = new HashMap();

						totalRecords=0;

						billDetailsRowCount = arrRow.size();
						int j = 0;

						dbConn = ConnectionManager.getConnection();
						
						System.out.println("MediMembershipQueryResult :: dbConn...."+dbConn);

						for (j=0; j<arrRow.size();j++)
						{
							arrCol = (ArrayList)arrRow.get(j);
							rs_operating_facility_id = arrCol.get(0).equals("null")?"":(String)arrCol.get(0);
							rs_patientId = arrCol.get(1).equals("null")?"":(String)arrCol.get(1);
							rs_patientName = arrCol.get(3).equals("null")?"":(String)arrCol.get(3);
							rs_firstName = arrCol.get(12).equals("null")?"":(String)arrCol.get(12);
							rs_secondName = arrCol.get(13).equals("null")?"":(String)arrCol.get(13);
							rs_dob = arrCol.get(15).equals("null")?"":(String)arrCol.get(15);
							rs_familyName = arrCol.get(20).equals("null")?"":(String)arrCol.get(20);
							rs_encounterId = arrCol.get(26).equals("null")?"":(String)arrCol.get(26);
							rs_episode_id = arrCol.get(2).equals("null")?"":(String)arrCol.get(2);
							rs_sex = arrCol.get(4).equals("null")?"":(String)arrCol.get(4);
							rs_patientClass = arrCol.get(6).equals("null")?"":(String)arrCol.get(6);
							rs_custCode = arrCol.get(29).equals("null")?"":(String)arrCol.get(29);
							rs_transDate = arrCol.get(7).equals("null")?"":(String)arrCol.get(7);
							rs_trans_Id = arrCol.get(23).equals("null")?"":(String)arrCol.get(23);
							rs_user_name = arrCol.get(25).equals("null")?"":(String)arrCol.get(25);
							rs_visit_id = arrCol.get(24).equals("null")?"":(String)arrCol.get(24);
							rs_approval_status = arrCol.get(22).equals("null")?"":(String)arrCol.get(22);
							rs_request_status = arrCol.get(27).equals("null")?"":(String)arrCol.get(27);
							rs_event_type = arrCol.get(28).equals("null")?"":(String)arrCol.get(28);
							rs_trans_type = arrCol.get(30).equals("null")?"":(String)arrCol.get(30);
							rs_doc_num = arrCol.get(31).equals("null")?"":(String)arrCol.get(31);
							rs_doc_type = arrCol.get(32).equals("null")?"":(String)arrCol.get(32);
							rs_amount = arrCol.get(33).equals("null")?"":(String)arrCol.get(33);
							rs_adm_date = arrCol.get(34).equals("null")?"":(String)arrCol.get(34);
							rs_approval_status_desc = arrCol.get(35).equals("null")?"":(String)arrCol.get(35);

							System.out.println("MediMembershipQueryResult :: rs_event_type...."+rs_event_type+"rs_approval_status...."+rs_approval_status);	

							rs_event_type_desc = "";

							if(rs_patientClass.equals("OP")){
								rs_patientClass_desc = "Out Patient";
							}
							if(rs_patientClass.equals("IP")){
								rs_patientClass_desc = "In Patient";
							}
							if(rs_patientClass.equals("EM")){
								rs_patientClass_desc = "Emergency Patient";
							}
							if(rs_patientClass.equals("DC")){
								rs_patientClass_desc = "Day Care";
							}

							if(rs_approval_status.equals("") || rs_approval_status.equals(" ") ){
								rs_approval_status_desc = "-";
							}
							if(rs_event_type.equals("IDC")){
								rs_event_type_desc = "ID Check";
							}
							if(rs_event_type.equals("FAM")){
								rs_event_type_desc = "FAM Check";
							}
							if(rs_event_type.equals("IEC")){
								rs_event_type_desc = "Insured Eligiblity Check";
							}
							if(rs_event_type.equals("UEC")){
								rs_event_type_desc = "UnInsured Eligiblity Check";
							}
							
							if(rs_event_type.equals("CLA") || rs_event_type.equals("CLE")){
								rs_event_type_desc = "Claims";
							}
							if(rs_event_type.equals("REV")){
								rs_event_type_desc = "Reversal";
							}
							if(rs_event_type.equals("EOC")){
								rs_event_type_desc = "End Of Case";
							}

							rs_event_type_desc = rs_event_type_desc + " - " + rs_approval_status_desc;

							currentSubGroup =rs_patientId+"@"+rs_patientName+"@"+rs_sex+"@"+rs_patientClass+"@"+rs_episode_id;
							System.out.println("MediMembershipQueryResult :: currentSubGroup...."+currentSubGroup);	
							
							l_img_vw_dtl_str = "<input type='image' id='claims_img' src='../../eXH/images/blist.gif' alt='View History' style='width:20px; height: 20px;' onClick='ViewTransDetails(this)'   patient_id='"+rs_patientId+"' episode_id='"+rs_episode_id+"'  visit_id='"+rs_visit_id+"' doc_num='"+rs_doc_num+"'  bill_doc_code='"+rs_doc_type+"' trans_type='"+rs_trans_type+"' > ";

							if (rs_trans_type.equals("ECLREQ"))
							{

								l_event_trans_query = "Select FACILITY_ID, PATIENT_ID, EPISODE_ID, VISIT_ID, DOC_TYPE_CODE, DOC_NUM, TRANS_TYPE, EVENT_TYPE, SRL_NO, CASE_NUM, "
											+"  nvl(APPROVAL_STATUS,'N') APPROVAL_STATUS "
											+"  from xf_eclaims_trx_hdr "
											+"	where srl_no in (select max(SRL_NO) from xf_eclaims_trx_hdr "
											+"						where FACILITY_ID = ? and PATIENT_ID = ? and EPISODE_ID = ? and VISIT_ID = ? "
											+"								and DOC_TYPE_CODE = ? and DOC_NUM = ?) ";
											
								System.out.println("MediMembershipQueryResult :: l_event_trans_query...."+l_event_trans_query);								
								
								System.out.println("MediMembershipQueryResult :: dbConn...."+dbConn);

								pstmt = dbConn.prepareStatement(l_event_trans_query);
								
								pstmt.setString(1, rs_operating_facility_id);
								pstmt.setString(2, rs_patientId);
								pstmt.setString(3, rs_episode_id);
								pstmt.setString(4, rs_visit_id);
								pstmt.setString(5, rs_doc_type);
								pstmt.setInt(6, Integer.parseInt(rs_doc_num));
								
								rsevent = pstmt.executeQuery();

								l_event_trans_type = ""; l_srl_trans_no = 0; l_case_trans_no = ""; l_approval_trans_status =""; l_current_status = "";
								
								while(rsevent.next())
								{
								   l_event_trans_type = rsevent.getString("EVENT_TYPE")==null?"":rsevent.getString("EVENT_TYPE");  
								   l_srl_trans_no = rsevent.getInt("SRL_NO");
								   l_case_trans_no = rsevent.getString("CASE_NUM")==null?"":rsevent.getString("CASE_NUM"); 
								   l_approval_trans_status = rsevent.getString("APPROVAL_STATUS")==null?"":rsevent.getString("APPROVAL_STATUS"); 
								}
								
								String l_status_code = "N", l_status_type = "CLA", l_trans_event = "ECL";

								if (l_event_trans_type.equals("CLA"))
								{
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "N";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
									{
										l_status_code = "P";
										l_status_type = "CLA";
									}

									if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
									{
										l_status_code = l_approval_trans_status;
										l_status_type = "CLA";
										l_trans_event = "ERA";
									}
								}

								if (l_event_trans_type.equals("REV"))
								{
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "CLA";
									}

									if (l_approval_trans_status.equals("A"))
									{
										l_status_code = "N";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "P";
										l_status_type = "CLA";
									}
								}

								if (l_event_trans_type.equals("EOC"))
								{
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "EOC";
									}

									if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P"))
									{
										l_status_code = "P";
										l_status_type = "EOC";
									}
									
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "P";
										l_status_type = "CLA";
									}
								}

								if (l_event_trans_type.equals("CLE"))
								{
									if (l_approval_trans_status.equals("R") || l_approval_trans_status.equals("F"))
									{
										l_status_code = "N";
										l_status_type = "CLA";
									}
									
									if (l_approval_trans_status.equals("99"))
									{
										l_status_code = "S";
										l_status_type = "EOC";
									}
									
									if (l_approval_trans_status.equals("A") || l_approval_trans_status.equals("P") || l_approval_trans_status.equals("W"))
									{
										l_status_code = "P";
										l_status_type = "EOC";
									}

									if (l_approval_trans_status.equals("0") || l_approval_trans_status.equals("1") || l_approval_trans_status.equals("2") || l_approval_trans_status.equals("3") || l_approval_trans_status.equals("4"))
									{
										l_status_code = l_approval_trans_status;
										l_status_type = "CLA";
										l_trans_event = "ERA";
									}
								}

								rsevent = null;
								
								String l_status_query = "";

								l_status_query = "Select STATUS_DESC from  XH_TRANS_STATUS "										
														+"	where TRANS_EVENT = ? AND TRANS_TYPE = ? AND STATUS_CODE = ? ";
														
								System.out.println("l_event_trans_query...."+l_event_trans_query);

								pstmt = dbConn.prepareStatement(l_status_query);
								pstmt.setString(1, l_trans_event);
								pstmt.setString(2, l_status_type);
								pstmt.setString(3, l_status_code);				

								rsevent = pstmt.executeQuery();

								rs_approval_status_desc ="";

								while(rsevent.next())
								{				   
								   l_current_status = rsevent.getString("STATUS_DESC")==null?"":rsevent.getString("STATUS_DESC"); 
								} 
							}

									
							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup))
							{
								if (j>0) {
								
            _bw.write(_wl_block19Bytes, _wl_block19);

								}
								String str="";	
								
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(j));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs_patientId));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs_patientName));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs_sex));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs_dob));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs_patientClass_desc));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs_adm_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs_episode_id));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

							}
							else
							{
								
            _bw.write(_wl_block35Bytes, _wl_block35);

							}

							checkboxvalue = "<img src='../../eXH/images/ViewDetails.gif' style='width:20px; height: 20px;' alt='Check Details' align='middle' onClick='checkEligibility(this)'   trans_num='"+rs_trans_Id+"' event_type='"+rs_event_type+"' >";
							   
						
							if (!(rs_doc_num.length()>0))
								rs_doc_num = "-";

							if (!(rs_doc_type.length()>0))
								rs_doc_type = "-";

							if (!(rs_amount.length()>0))
								rs_amount = "-";

							Checkboxname = "Check-"+j;
							
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checkboxvalue));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(rs_user_name));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs_doc_num));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs_doc_type));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(rs_amount));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs_trans_Id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs_transDate));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(rs_event_type_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(l_current_status));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(l_img_vw_dtl_str));
            _bw.write(_wl_block40Bytes, _wl_block40);

							if (!currentSubGroup.equalsIgnoreCase(prevSubGroup)){

							}
							prevSubGroup = currentSubGroup; 
							System.out.println("prevSubGroup...."+prevSubGroup);
							}
							if ((j>0) && (j==billDetailsRowCount)){
							
            _bw.write(_wl_block41Bytes, _wl_block41);

							}
						
            _bw.write(_wl_block42Bytes, _wl_block42);

				}
				if(arrRow!=null) arrRow.clear();
				if(arrCol!=null) arrCol.clear();
				if(resultsQry!=null) resultsQry.clear();

			}catch(Exception e1)
				{
				 System.out.println("(MediMembershipQueryResult.jsp:Exception)"+e1);
				 e1.printStackTrace(System.err);
				}
				finally
				{
				ConnectionManager.returnConnection(conn);
				}
	
            _bw.write(_wl_block43Bytes, _wl_block43);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sex.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DateofBirth.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientclass.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.VisitDateTime.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.episodeid.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.username.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_NO.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILL_DOC_TYPE.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transaction.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransactionDate.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Last.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Transaction.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.current.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.History.label", java.lang.String .class,"key"));
        __tag19.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
