package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import webbeans.op.CurrencyFormat;
import com.ehis.util.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.util.*;

public final class __blnursingunitqueryresultsfinsummarybody extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLNursingUnitQueryResultsFinSummaryBody.jsp", 1743496760855L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<HTML>\n<HEAD>\n</HEAD>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\t\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/CommonResult.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\n\t\t\n\t\t<style>\n\t\tthead td, thead td.locked\t{\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\t</style>\n\n<script>\n\nfunction hideToolTip(obj,imgObj,row)\t\n{ \n\tdynamichide(obj, window.event,row);\t \n}\n\nfunction callMouseOver(obj)\t\n{\n\tcurrClass = obj.className ;\n\tobj.className = \'selectedcontextMenuItem\';\n}\n\nfunction callOnMouseOut(obj)\n{\n\tobj.className = \'contextMenuItem\';\n}\n\nfunction resizeWindow(orderctlHDR)\n{\n\tvar orderctlHDR1 = orderctlHDR.id;\n\n\tvar wdth = document.getElementById(\'orderctlHDR1\').offsetWidth;\n\tvar hght1 = document.getElementById(\'orderctlHDR1\').offsetHeight;\t\t\n\tvar wdth1 = getPos(orderctlHDR).x +wdth;\n\tvar hght = getPos(orderctlHDR).y ;\t\n\n\tbodwidth  = document.body.offsetWidth\n\tbodheight = document.body.offsetHeight\n\n\tvar z = bodwidth- (event.x + wdth);\t\n\t\n\tvar x \t  = event.x;\n\tvar y \t  = event.y;\t\n\n\tx \t  = x + (document.getElementById(\"tooltiplayer\").offsetWidth);\n\ty \t  = hght + (document.getElementById(\"tooltiplayer\").offsetHeight);\t\n\n\tif(x<bodwidth){\n\t\tx= wdth1;\t\t\t\n\t}else{\t\t\t\n\t\tx = getPos(orderctlHDR).x;\n\t}\n\tif(y<bodheight){\t\t\t\n\t\ty = hght;\n\t\t\n\t}else\n\t{\n\t\ty = y - (document.getElementById(\"tooltiplayer\").offsetHeight*2) + hght1 ;\t\n\t}\n\n\tdocument.getElementById(\"tooltiplayer\").style.posLeft= x;\n\tdocument.getElementById(\"tooltiplayer\").style.posTop = y;\n\tdocument.getElementById(\"tooltiplayer\").style.visibility=\'visible\';\n\n}\nfunction displayToolTip(orderctlHDR,imgObj,i,strPatientId,strEpisodeType,strEpisodeId,strEncounterId)\n{\n\tcallMouseOverOnTD(orderctlHDR,imgObj,i);\n\tbuildTable(i);\n\tresizeWindow(orderctlHDR)\n}\n\nfunction buildTable(curr_rec)\n{\n\tvar val = (\"Bill/Payment Details,Diagnosis,Procedures\");\n\tvar row  = (\"Bill/Payment Details,Diagnosis,Procedures\");\n\tvar rowval   = val.split (\",\");\t\t\n\trowval1      = row.split(\",\");\n\tvar tab_dat  = \"<table id=\'tooltiptable1\' class=\'contextMenu\' width=\'100%\' height=\'100%\' align=\'center\'>\";\n\tfor( var i=0; i<rowval.length; i++ ) {\n\t\tvar colval  = rowval[i]\n\t\tvar colval1 = rowval1[i];\n        if (colval != \"\")\n         {     \n\t\t\t\ttab_dat     += \"<tr>\"\n\t\t\t\tif(colval1 == \"Bill/Payment Details\"){\n\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=\'javascript:funViewEncounterDet(\"+curr_rec+\")\'>\"+colval+\" </a></td>\";\n\t\t\t\t}\n\t\t\t\telse if(colval1 == \"Diagnosis\"){\n\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:funAmend()>\"+colval+\" </a></td>\";\n\t\t\t\t}else{\n\t\t\t\t\ttab_dat     += \"<td class = \'contextMenuItem\' nowrap id=\'mouse\' onMouseOver=\'callMouseOver(this)\' onMouseOut=\'callOnMouseOut(this);\'><a class= \'contextMenuLink\' href=javascript:funCancel()>\"+colval+\" </a></td>\";\n\t\t\t\t}\n\t\t\t\ttab_dat     += \"</tr> \";\n\t\t}\n\t  }\n\t\ttab_dat     += \"</table> \"\n\t\tdocument.getElementById(\"t\").innerHTML = tab_dat;\n}\n\nfunction funViewEncounterDet(curr_rec)\n{\n\tvar strPatientId=\"\", strEpisodeType=\"\", strEpisodeId=\"\", strEncounterId=\"\";\n\n\tvar total_records = document.forms[0].total_records.value;\n\tfor(var i=0;i<total_records;i++)\n\t{\n\t\tif(i == curr_rec)\n\t\t{\n\t\t\tvar pat_id = eval(document.getElementById(\'pat_id\'+curr_rec));\n\t\t\tstrPatientId = pat_id.innerText;\n\n\t\t\tvar enc_id = eval(document.getElementById(\'enc_id\'+curr_rec));\n\t\t\tstrEpisodeId = enc_id.innerText;\n\n\t\t\tstrEncounterId = strEpisodeId;\n\n\t\t\tvar episode_type = eval(\"document.forms[0].episode_type\"+curr_rec);\n\t\t\tstrEpisodeType = episode_type.value;\n\t\t}\n\t}\n\tvar center=\'1\';\n\tvar dialogTop = \"320\";\n\tvar dialogHeight = \"25\" ;\n\tvar dialogWidth = \"70\" ;\n\tvar features= \"dialogTop:\" + dialogTop + \"; dialogHeight:\" + dialogHeight + \"; center:\" + center + \"; dialogWidth:\" + dialogWidth +\";status=no\" ;\n\tvar title=\"\";\n\ttitle=encodeURIComponent(title);\t\n\tvar arguments = \"\" ;\n\tvar column_sizes = escape(\"\");               \n\tvar column_descriptions =\"\";\t\n\tvar param = \"title=\"+title+\"&\"+\"column_sizes=\"+column_sizes+\"&\"+\"column_descriptions=\"+column_descriptions+\"&patient_id=\"+strPatientId+\"&episode_type=\"+strEpisodeType+\"&episode_id=\"+strEpisodeId+\"&encounter_id=\"+strEncounterId;\n\tretVal=window.showModalDialog(\"../../eBL/jsp/BLViewEncounterBillDetMain.jsp?\"+param,arguments,features);\n}\n\nfunction getBlngGrpSearch(blng_grp_id)\n{\n\tvar billing_group=blng_grp_id;\n\t\n\tif((billing_group!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"400px\" ;\n\t\tvar dialogWidth\t= \"700px\" ;\n\t\tvar dialogTop = \"0\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLBillingGrpDetFrame.jsp?billing_group=\t\"+billing_group;\n\t\tretVal = top.window.showModalDialog(url,arguments,features);\n\t}\n}\n\nfunction getCustDet(cust_grp_code,cust_code)\n{\n\tif((cust_code!=\"\"))\n\t{\n\t\tvar retVal;\n\t\tvar dialogHeight= \"400px\" ;\n\t\tvar dialogWidth\t= \"700px\" ;\n\t\tvar dialogTop = \"350\" ;\n\t\tvar center = \"1\" ;\t\t\t\t\t\t\t\t\t\t\t\t\t\t   \n\t\tvar status=\"no\";\n\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\t\tvar arguments\t= \"\" ;\n\t\tvar url = \"../../eBL/jsp/BLCustomerDetFrame.jsp?cust_code=\"+cust_code+\"&cust_grp_code=\"+cust_grp_code;\n\t\tretVal = top.window.showModalDialog(url,arguments,features);\n\t}\n}\n\n</script>\n<body onLoad=\"\" onKeyDown= \"lockKey();\" onMouseDown=\"CodeArrest();\" \t\t\t\t\t      \t\t\t\t\t  onSelect=\"codeArrestThruSelect();\">\n<form name=\'BLNursingUnitQueryForm\' id=\'BLNursingUnitQueryForm\' action=\"\" method=\"post\" target=\"\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<!--\t\t<div>\n\t\t<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align = \'center\' id=\'\' width=\'100%\'>\t\t\t\t\t\t\n\t\t\t<tr>\t\n\t\t\t<td width=\"80%\" class=\"white\">&nbsp;</td>\n\t\t\t<td width=\"20%\" class=\"white\">&nbsp;\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</table>\n\t\t</div>\n\t\t-->\n\t\t<div id=\"tbl-container\" STYLE=\"overflow: auto; height: 160px;   padding:3px; margin: 0px\">\n\t\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t\t<thead>\n\t\t\t<tr>\t\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'40%\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="/";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'12%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t</tr>\n\t\t</thead>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<tbody>\n\t\t\t<tr id=row";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =">\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n<!--\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" width=\'40%\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\t \n-->\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =" width=\'40%\'><a href=\"javascript:getBlngGrpSearch(\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\');\">";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</a></td>\t \n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" width=\'40%\'><a href=\"javascript:getCustDet(\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\',\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n<!--\n\t\t\t\t<td width=\'10%\' wrap style=\'cursor:pointer\' class=\'gridDataBlue\' id=\"blng_grp_id_";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</td>\n-->\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 =" width=\'12%\'><DIV id=\'unb_amt";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' style=\'text-align:right\'>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</DIV></td>\t \n\t\t\t\t<td class=";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" width=\'12%\'><DIV id=\'billd_amt";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</DIV></td>\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 =" width=\'12%\'><DIV id=\'paid_amt";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</DIV></td>\t \t\t\t\t\n\t\t\t\t<td class=";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" width=\'12%\'><DIV id=\'outst_amt";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" width=\'12%\'><DIV id=\'inv_amt";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</DIV></td>\t \n\t\t\t</tr>\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t</tbody>\n\t\t</table>\n\t\t</div>\n";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n<!--\n\t\t<div id=\"tbl-container\" STYLE=\"overflow: auto; width: 615px; height: 195px;   padding:3px; margin: 0px\">\n\t\t<table border=\'1\' cellpadding=\'3\' cellspacing=\'0\'  id=\'tbl\' width=\'100%\'>\t\n\t\t<thead>\n\t\t\t<tr>\t\t\t\n\t\t\t\t<td class=\'COLUMNHEADER\' width=\'40%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t</tr>\n\t\t</thead>\n\t\t\t<tbody>\n-->\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n<script>\n\t\talert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"COMMON\"));\n</script>\n\n<!--\n\t\t\t<tr>\n\t\t\t\t\t<td colspan=\'10\'><div align=\'center\'>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 =" </div></td>\n\t\t\t</tr>\n\n\t\t\t</tbody>\n\t\t\t</table></div>\n-->\n";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\n\t<input type=\'hidden\' name=\'total_records\' id=\'total_records\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\t\n\t<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\t\n\n\t<script>parent.frames[2].location.href=\'../../eCommon/html/blank.html\';</script>\n\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:12%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\'  width=\'100%\' height=\'100%\' align=\'center\'>\n\t\t\t<tr>\n\t\t\t\t<td width=\'100%\' id=\'t\'></td>\n\t\t\t</tr>\n\t\t</table>\n\t</div>\n\t\n</form>\n<!--\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 =" -->\n</body>\n</HTML>\n\n";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

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

            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block2Bytes, _wl_block2);

    request.setCharacterEncoding("UTF-8");
	Connection con = null;
	PreparedStatement pstmt = null ;
	ResultSet rs	=null;
	PreparedStatement pstmt1 = null ;
	ResultSet rs1	=null;

	HttpSession httpSession = request.getSession(false);
	//Properties p = (Properties)httpSession.getValue("jdbc");			
	String locale	= (String)session.getAttribute("LOCALE");	
	if(locale==null || locale.equals("")) locale="en";	
	String classval=""; String strFacilityId=""; int total_records=0;
	int noofdecimal = 2;
	String strPatientId="", strNursingUnitCode = "", strCalledFrom="",strCalledFor="";
	String strBlngGrpId="", strBlngGrpDesc="", strUnbilledAmt="", strBilledAmt="", strPaidAmt="", strOutstAmt="", strInvAmt="", strRemarks="", strEpisodeType="";
	String strCustGrpCode="", strCustCode="";
	String params = "";
	boolean searched = (request.getParameter("searched") == null) ?false:true;	
	java.util.Locale loc = new java.util.Locale(locale);
	java.util.ResourceBundle bl_labels = java.util.ResourceBundle.getBundle("eBL.resources.Labels",loc);
	java.util.ResourceBundle bl_messages = java.util.ResourceBundle.getBundle("eBL.resources.Messages",loc);
	String strTitle=(String) bl_labels.getString("eBL.PAT_ENCOUNTER_DETAILS.label");

	try
	{
		con	=	ConnectionManager.getConnection(request);

		CurrencyFormat cf = new CurrencyFormat();

		strFacilityId = (String)httpSession.getValue("facility_id");
		if(strFacilityId==null) strFacilityId="";

		strPatientId = request.getParameter("patient_id");
		if(strPatientId==null) strPatientId="";	

		strNursingUnitCode = request.getParameter("nursing_unit_code");
		if(strNursingUnitCode==null) strNursingUnitCode="";	

		strCalledFrom = request.getParameter("called_from");
		if(strCalledFrom==null) strCalledFrom="";	


		strCalledFor = request.getParameter("called_for");
		if(strCalledFor==null) strCalledFor="";	

		
		params = request.getQueryString();
		if(params==null) params="";	

		try
		{		
			pstmt1 = con.prepareStatement( " select nvl(no_of_decimal,2) from  sm_acc_entity_param");
			rs1 = pstmt1.executeQuery();	
			while(rs1.next())
			{
				noofdecimal  =  rs1.getInt(1);		
			}	
			rs1.close();
			pstmt1.close();
			
		}
		catch(Exception e)
		{
			System.out.println("3="+e.toString());
		}

            _bw.write(_wl_block6Bytes, _wl_block6);

		String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		try
		{				
			String sqlPatEncDet="";
			if(strCalledFor.equals("CIP"))
			{
				if(strCalledFrom.equals("FSB"))
				{
					 sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"') group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"') group by a.blng_grp_id) x group by x.blng_grp_id";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"') group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"') group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
				}
			}
			else if(strCalledFor.equals("TED"))
			{
				if(strCalledFrom.equals("FSB"))
				{
//					 sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by a.blng_grp_id) x group by x.blng_grp_id";
					sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.blng_grp_id) x group by x.blng_grp_id";
				}
				else if(strCalledFrom.equals("FSP"))
				{
//					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"'  and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) and exists (select 'X' from IP_DISCHARGE_ADVICE c where c.ENCOUNTER_ID=a.ENCOUNTER_ID and c.DIS_ADV_STATUS <> '9' and trunc(c.EXPECTED_DISCHARGE_DATE)=trunc(sysdate)) group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"' and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from IP_OPEN_ENCOUNTER_VW b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D')  and a.episode_id=b.encounter_id  and b.nursing_unit_code='"+strNursingUnitCode+"'  and trunc(b.EXP_DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
				}
			}
			else if(strCalledFor.equals("TDP"))
			{
				if(strCalledFrom.equals("FSB"))
				{
					 sqlPatEncDet="Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.blng_grp_id BLNG_GRP_ID from (Select blng_grp_id,sum(upd_net_charge_amt) Unbilled_amt,0 Billed_amt ,0 Paid_amt,0 Outstdg_amt,0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by blng_grp_id union Select a.blng_grp_id, 0 Unbilled_amt, sum(BILL_AMT) Billed_amt ,sum(BILL_PAID_AMT) Paid_amt,sum(BILL_TOT_OUTST_AMT) Outstdg_amt,sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.blng_grp_id) x group by x.blng_grp_id";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					sqlPatEncDet = "Select sum(x.Unbilled_amt) UNBILLED_AMT,sum(x.Billed_amt) BILLED_AMT,sum(x.Paid_amt) PAID_AMT,sum(x.Outstdg_amt) OUTST_AMT,sum(x.Invoiced_amt) INC_AMT,x.cust_group_code CUST_GRP_CODE,x.cust_code CUST_CODE from (Select cust_group_code,cust_code,  sum(upd_net_charge_amt) Unbilled_amt, 0 Billed_amt , 0 Paid_amt, 0 Outstdg_amt, 0 Invoiced_amt from bl_patient_charges_folio a where bill_doc_type_code is null and a.cust_code is not null and exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and  b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code union Select  a.cust_group_code,a.cust_code, 0 Unbilled_amt,  sum(BILL_AMT) Billed_amt , sum(BILL_PAID_AMT) Paid_amt, sum(BILL_TOT_OUTST_AMT) Outstdg_amt, sum(decode(bill_nature_code,'A',AMT_TRANSFERRED,0)) Invoiced_amt from bl_bill_hdr a where a.cust_code is not null and exists (Select 'X' from PR_ENCOUNTER b where a.OPERATING_FACILITY_ID=b.FACILITY_ID and b.facility_id='"+strFacilityId+"' and a.EPISODE_TYPE=decode(b.PATIENT_CLASS,'IP','I','DC','D') and a.episode_id=b.encounter_id and b.ASSIGN_CARE_LOCN_CODE='"+strNursingUnitCode+"' and trunc(b.DISCHARGE_DATE_TIME)=trunc(sysdate)) group by a.cust_group_code,a.cust_code) x group by x.cust_group_code,x.cust_code";
				}
			}
/*
			HashMap sqlMap = new HashMap();
			sqlMap.put("sqlData",sqlPatEncDet);
			HashMap funcMap = new HashMap();
			ArrayList displayFields = new ArrayList();
			ArrayList chkFields = new ArrayList();
			displayFields.add("UNBILLED_AMT");
			displayFields.add("BILLED_AMT");
			displayFields.add("PAID_AMT");
			displayFields.add("OUTST_AMT");
			displayFields.add("INC_AMT");
			if(strCalledFrom.equals("FSB"))
			{
				displayFields.add("BLNG_GRP_ID");
			}
			else if(strCalledFrom.equals("FSP"))
			{
				displayFields.add("CUST_GRP_CODE");
				displayFields.add("CUST_CODE");
			}
			funcMap.put("displayFields", displayFields);
			funcMap.put("chkFields", chkFields);
			ArrayList result=(ArrayList)CommonBean.getQueryResultPage(pageContext,sqlMap, funcMap, request);
			//out.println("resutl==>"+result.size());
			if((result.size()>=3) && (!(((String) result.get(0)).equals("0")))) 
			{
*/

            _bw.write(_wl_block9Bytes, _wl_block9);
			
//				out.println(result.get(1));

            _bw.write(_wl_block10Bytes, _wl_block10);

			if(strCalledFrom.equals("FSB"))
			{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			}
			else if(strCalledFrom.equals("FSP"))
			{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

			}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

			pstmt = con.prepareStatement(sqlPatEncDet);
			rs = pstmt.executeQuery();	
			if( rs != null) 
			{
			while(rs.next())
			{
				int i=0;
/*	
			int i=0;	
			ArrayList records=new ArrayList();
			for(int j=2; j<result.size(); j++)
			{
*/
   				if(i % 2 == 0 )
					{
						classval	=	"QRYEVEN";
					}
					else
					{
						classval	=	"QRYODD";
					}
/*
				records=(ArrayList) result.get(j);		
			
				strUnbilledAmt = (String)records.get(0);
				if(strUnbilledAmt==null) strUnbilledAmt="0";

				strBilledAmt = (String)records.get(1);
				if(strBilledAmt==null) strBilledAmt="0";

				strPaidAmt = (String)records.get(2);
				if(strPaidAmt==null) strPaidAmt="0";

				strOutstAmt = (String)records.get(3);
				if(strOutstAmt==null) strOutstAmt="0";

				strInvAmt = (String)records.get(4);
				if(strInvAmt==null) strInvAmt="0";

				if(strCalledFrom.equals("FSB"))
				{
					strBlngGrpId = (String)records.get(5);
					if(strBlngGrpId==null) strBlngGrpId="";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					strCustGrpCode = (String)records.get(5);
					if(strCustGrpCode==null) strCustGrpCode="";

					strCustCode = (String)records.get(6);
					if(strCustCode==null) strCustCode="";
				}
*/
				strUnbilledAmt = rs.getString(1);
				if(strUnbilledAmt==null) strUnbilledAmt="0";

				strBilledAmt = rs.getString(2);
				if(strBilledAmt==null) strBilledAmt="0";

				strPaidAmt = rs.getString(3);
				if(strPaidAmt==null) strPaidAmt="0";

				strOutstAmt = rs.getString(4);
				if(strOutstAmt==null) strOutstAmt="0";

				strInvAmt = rs.getString(5);
				if(strInvAmt==null) strInvAmt="0";

				if(strCalledFrom.equals("FSB"))
				{
					strBlngGrpId = rs.getString(6);
					if(strBlngGrpId==null) strBlngGrpId="";
				}
				else if(strCalledFrom.equals("FSP"))
				{
					strCustGrpCode = rs.getString(6);
					if(strCustGrpCode==null) strCustGrpCode="";

					strCustCode = rs.getString(7);
					if(strCustCode==null) strCustCode="";
				}
				strUnbilledAmt = cf.formatCurrency(strUnbilledAmt, noofdecimal);
				strBilledAmt = cf.formatCurrency(strBilledAmt, noofdecimal);
				strPaidAmt = cf.formatCurrency(strPaidAmt, noofdecimal);
				strOutstAmt = cf.formatCurrency(strOutstAmt, noofdecimal);
				strInvAmt = cf.formatCurrency(strInvAmt, noofdecimal);

				try
				{		
					pstmt1 = con.prepareStatement( " select SHORT_DESC from bl_blng_grp_lang_vw where language_id='"+locale+"' and blng_grp_id='"+strBlngGrpId+"'");
					rs1 = pstmt1.executeQuery();	
					while(rs1.next())
					{
						strBlngGrpDesc  =  rs1.getString(1);		
					}	
					if(rs1!=null) rs1.close();
					pstmt1.close();
				}
				catch(Exception e)
				{
					System.out.println("Exception in strBlngGrpDesc="+e.toString());
				}	
				if(strBlngGrpDesc == null) strBlngGrpDesc="";

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(i));
            _bw.write(_wl_block18Bytes, _wl_block18);

				if(strCalledFrom.equals("FSB"))			
				{

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(strBlngGrpDesc));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strBlngGrpId));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strBlngGrpId));
            _bw.write(_wl_block24Bytes, _wl_block24);

				}
				else if(strCalledFrom.equals("FSP"))
				{

            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strCustGrpCode));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strCustCode));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(strCustGrpCode));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(strCustCode));
            _bw.write(_wl_block24Bytes, _wl_block24);

				}

            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(i));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strBlngGrpId));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strUnbilledAmt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strBilledAmt));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strPaidAmt));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strOutstAmt));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classval));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(i));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(strInvAmt));
            _bw.write(_wl_block40Bytes, _wl_block40);

				i++;
				total_records++; 
			}//for loop
				rs.close();
			}

            _bw.write(_wl_block41Bytes, _wl_block41);

				out.flush();
/*
			}
			else
*/
			if(total_records == 0)
			{


			 
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);

		String noRecord = bl_messages.getString("BL9813");

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(noRecord));
            _bw.write(_wl_block45Bytes, _wl_block45);

			}
		}
		catch(Exception ee)
		{
			System.err.println("Exception in Fin Summary Qury Result" +ee); 
		}

	}
	catch(Exception eee)
	{
		System.err.println("Exception main"+ eee);
	}
	finally 
	{
		if(con!=null)
		{
			ConnectionManager.returnConnection(con, request);
		}
	}

            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(total_records));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(params));
            _bw.write(_wl_block48Bytes, _wl_block48);
out.println(CommonBean.setForm (request ,"../../eBL/jsp/BLNursingUnitQueryResultsFinSummaryBody.jsp",searched));
            _bw.write(_wl_block49Bytes, _wl_block49);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Payer.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAYER_GROUP.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNBILLED_AMT.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAID_AMT.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INV_AMT.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BillingGroup.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.UNBILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.BILLED_AMT.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.PAID_AMT.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outstandingamount.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eBL.INV_AMT.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${bl_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
