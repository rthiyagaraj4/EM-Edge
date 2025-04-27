package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eOT.StaffAssignmentTimeBean;
import eOT.Common.OTRepository;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import webbeans.op.CurrencyFormat;
import eBL.Common.*;
import eCommon.Common.*;
import webbeans.eOT.StaffAssignmentBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __staffassignmentrolemodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/StaffAssignmentRoleModify.jsp", 1723542896000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------------------------------\nDate       Edit History   Name        Description\n-----------------------------------------------------------------------------------------------\n20/11/12      100         pparthasarathy  created\nActs as create and Modify screen for Payer Group Mapping screen\ncalled on click of create button from common tool bar\non submission (apply) request will be submitted to BLPayerGroupServlet.java\n-----------------------------------------------------------------------------------------------\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n<link rel=\'StyleSheet\' href=\'../../eOT/html/style.css\' type=\'text/css\'/>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\'javascript\' src=\'../../eCommon/js/CommonCalendar.js\' ></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/FieldFormatMethods.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eOT/js/StaffAssignment.js\"></script>\n<script type=\'text/javascript\' src=\'../../eCommon/js/dchk.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<script>\n\n\nvar roleTypeArray;\nvar headTop = -1;\nvar FloatHead1;\nfunction processScroll()\n{\n\tif (headTop < 0)\n\t{\n\t\tsaveHeadPos();\n\t\t\n\t}\n\tif (headTop>0)\n\t{\n\t\tif (document.documentElement && document.documentElement.scrollTop)\n\t\t\ttheTop = document.documentElement.scrollTop;\n\t\telse if (document.body)\n\t\t\ttheTop = document.body.scrollTop;\n\n\t\tif (theTop>headTop)\n\t\t\tFloatHead1.style.top = (theTop-headTop) + \'px\';\n\t\telse\n\t\t\tFloatHead1.style.top = \'0px\';\n\t}\n}\n\nfunction saveHeadPos()\n{\n\tparTable = document.getElementById(\"divHeadSep\");\n\tif (parTable != null)\n\t{\n\t\theadTop = parTable.offsetTop + 3;\n\t\tFloatHead1 = document.getElementById(\"heading\");\n\t\tFloatHead1.style.position = \"relative\";\n\t}\n}\n\t\nfunction lockKey()\n{\n\t \t \n\tif(event.keyCode == 93)\n\t\talert(\"Welcome to eHIS\");\n}\n\n function lockbackSpace()\n {\n// alert(document.order_type_form.mode.value);\n   var mode = document.mode.value;\n    // alert(window.event.keyCode);\n if(mode==\'modify\' && window.event.keyCode==8)\n  {\n         //return false;\n  }\n }\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\n</script>\n</head>\n<style>\n\t\tthead td, thead td.locked\t{ \n\t\tbackground-color: navy;\n\t\tcolor: white;\n\t\tposition:relative;}\t\n\t\tthead td {\n\t\ttop: expression(document.getElementById(\"tbl-container\").scrollTop-4); \n\t\tz-index: 20;}\n\t\tthead td.locked {z-index: 30;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative;\n\t\tz-index: 10;}\n\t\ttd.locked,  th.locked{\n\t\tleft: expression(parentNode.parentNode.parentNode.parentNode.scrollLeft);\n\t\tposition: relative; \n\t\tz-index: 10;}\n\t\t</style>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n<script>\t\n roleTypeArray = [\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\t\n\t\t[\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" , \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\"] ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n];\t\n \n </script>\t\t\n<body>\n\t<form name=\"StaffAssignmentRoleForm\" id=\"StaffAssignmentRoleForm\" >\n\t\t<div class=\"main\" style=\"width:99%; height:380px; overflow: auto; \">\n\t\t\t\t<div class=\"stfdet\">\n\t\t\t\t\t<div class=\"floatleft\" ><span class=\"stftitle\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span> </div>\n\t\t\t\t</div>\n\t\t\t\t<div class=\"tablediv\" style=\"width:100%; height:100%;  \"> \n\t\t\t\t\t<table  class=\"crstaffgrid\"  border=\"0\" cellspacing=\"0\" id=\'AssignmentTimeTable\'>\n\t\t\t\t\t\t<th width=\'17%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</th>\n\t\t\t\t\t\t<th width=\'17%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</th>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\t\n\t\t\t\t\t\n\t\t\t\t\t\t<table class=\"modstaffgrid\" cellspacing=\"0\" id=\"OuterTable";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<th  class=\"alignimgtext\"  width=\'85%\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'assignmentDate";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' id=\'assignmentDate";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' value=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' />\n\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'operRoomCode";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' id=\'operRoomCode";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' />\n\t\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t\t\t<th  class=\"alignimgtext\"  width=\'15%\' >\n\t\t\t\t\t\t\t\t\t<input class=\"oldbtn\" id=\'addBtn";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' type=\"button\" value=\"Add\" onclick=\'javascript:addRoleRow(";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =")\' disabled/>\n\t\t\t\t\t\t\t\t\t <img id=\'arrow";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' src=\"../../eOT/images/Arrow1.PNG\" class=\"arrowps\" onclick=\'javascript:showHideDateDetails(";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =")\'/>\n\t\t\t\t\t\t\t\t</th>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\'2\'>\n\t\t\t\t\t\t\t\t\t<div id=\"dateDetailDiv";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" style=\'display:none;visibility:visible;overflow:auto\'>\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t<table class=\"modstaffgrid\" cellspacing=\"0\" id=\"RoleTable";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t\t\t\t\t\t\t\t\t\t\t<tr>\t\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\" width=\'17%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<select class=\"brdclr\" name=\'roleType";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' id=\'roleType";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\" width=\'17%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practitionerId";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\' id=\'practitionerId";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'text\' name=\'practitionerName";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' id=\'practitionerName";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'  size=\'20\' onblur=\"if(this.value!=\'\')searchDoctor(roleType";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =", practitionerId";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =",practitionerName";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =", 1); else practitionerId";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =".value=\'\';\" > \n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'button\' class=\'button\' value=\'?\' onClick=\'searchDoctor(roleType";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 =", 1);\'  > \n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td  width=\'17%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"checkbox\" name=\'showWidgetYN";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' id=\'showWidgetYN";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\' value=\'Y\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\" width=\'17%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'fromTime";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\' id=\'fromTime";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\' size=\'5\' onblur=\'javascript:checkTimeFormat(this)\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\" width=\'17%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'toTime";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'toTime";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' size=\'5\' onblur=\'javascript:checkTimeFormat(this)\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\" width=\'17%\'>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\t<script>\n\t\t\t\t\t\t\t\t\t\t\t\tpopulateAndSetComboModify(\'\', ";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =",1);\n\t\t\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\t\t\n\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'staffAssignmentId";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'staffAssignmentId";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'rowModified";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' id=\'rowModified";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' value=\'\' />\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'roleType";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' />\n\t\t\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input type=\'hidden\' name=\'practitionerId";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td >\n\t\t\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"checkbox\" name=\'showWidgetYN";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' value=\'Y\' ";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 =" onclick=\"setRowModified(";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =",";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 =")\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'fromTime";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\' size=\'5\' value=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onblur=\"checkTimeModify(this, ";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 =")\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td class=\"alignimgtext\">\n\t\t\t\t\t\t\t\t\t\t\t\t\t<input class=\"brdclr\"class=\"brdclr\" type=\"text\" name=\'toTime";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 =")\"/>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<img src=\"../../eOT/images/Close.png\" class=\"midalign\" onclick=\'javascript:deleteRoleRow(";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 =", ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 =")\'/>\n\t\t\t\t\t\t\t\t\t\t\t\t\t<span class=\"tbtxt\" >Delete</span>\n\t\t\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\t\n\t\t\t\t\t\t\t\t<input type=\"hidden\" name=\'rowCount";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\' id=\'rowCount";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\' />\n\t\t\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t</div>\n\t\t\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t\t\t</tr>\t\t\n\t\t\t\t\t\t</table>\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\t\n\t\t\t\t\t</table>\t\n\t\t\t\t\t\n\t\t\t\t</div>\n\t\t\t</div>\t\n\t\t\t<input class=\"oldbtn1 floatright\" type=\"button\" value=\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\' onclick=\'javascript:viewAuditTrail()\'/>\n\t\t</div>\n\t\t\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\'";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\' />\n\t\t\t<input type=\'hidden\' name=\'deleteId\' id=\'deleteId\' value=\'\' />\n\t\t\t<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'modify\' />\n\t\t\t<input type=\'hidden\' name=\'dateCount\' id=\'dateCount\' value=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' />\n\t\t\t<input type=\'hidden\' name=\'assignmentFromDate\' id=\'assignmentFromDate\' value=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' />\n\t\t\t<input type=\'hidden\' name=\'assignmentToDate\' id=\'assignmentToDate\' value=\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\' />\n\t\t\t<input type=\'hidden\' name=\'operRoomCode\' id=\'operRoomCode\' value=\'";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\' />\n\t</form>\t\n\n";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\t\n\t\n\t\n</body>\n";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n</html>\n\n";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );
	
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

	
private String checkForNull(String inputString)
{
	return (inputString == null) ? "" :	inputString;
}
	
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String sStyle =		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


	String mode = checkForNull(request.getParameter("mode"));
	String facilityId = (String) session.getValue( "facility_id" ) ;
	facilityId = facilityId.substring(facilityId.length() - 2);
	String locale = (String)session.getAttribute("LOCALE");
	String assignmentFromDate = checkForNull(request.getParameter("assignmentFromDate"));
	String assignmentToDate = checkForNull(request.getParameter("assignmentToDate"));
	String operRoomCode = checkForNull(request.getParameter("operRoomCode"));
	Properties p = (Properties) session.getValue( "jdbc" ) ;
	
	int index = 0;

            _bw.write(_wl_block8Bytes, _wl_block8);

response.setHeader("Cache-Control","no-cache"); //HTTP 1.1   
response.setHeader("Pragma","no-cache"); //HTTP 1.0   
response.setDateHeader ("Expires", 0); //prevents caching at the proxy server


String beanId = "ot_StaffAssignmentBean" ;
String beanName = "webbeans.eOT.StaffAssignmentBean";
List<String> condnList = new ArrayList<String>();


try  
{
	
	Map<String, String> otRoomMap = null;
	Map <String,List<StaffAssignmentTimeBean>> timeBeanMap = null;
	List<StaffAssignmentTimeBean> timeBeanList = null;
	StaffAssignmentBean staffAssignmentBean = (StaffAssignmentBean)getBeanObject(beanId, beanName, request) ;
	condnList.add(facilityId);
	condnList.add(locale);
	otRoomMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROOM_SELECT"), condnList);

	Map<String,String> roleMap = null;
	
	condnList = new ArrayList<String>();
	condnList.add(locale);
	roleMap = staffAssignmentBean.getCodeValueMap(OTRepository.getOTKeyValue("OT_STAFF_ASSIGNMENT_ROLE_SELECT"), condnList);
	timeBeanMap = staffAssignmentBean.fetchStaffAssignmentDetails(assignmentFromDate, assignmentToDate, operRoomCode, facilityId, locale, p);

	int dateIndex = 0;
	int timeIndex = 0;
	
	String checkedValue = "";
	String indexSuffix = null;
	

            _bw.write(_wl_block9Bytes, _wl_block9);
	
	index = 0;
	for(String key : roleMap.keySet())
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(key ));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(roleMap.get(key) ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf( index++ < (roleMap.keySet().size() -1) ? "," : "" ));
            _bw.write(_wl_block1Bytes, _wl_block1);

		
	}

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

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
            _bw.write(_wl_block16Bytes, _wl_block16);

						if(timeBeanMap != null && !timeBeanMap.isEmpty())
						{
							
							for(String key : timeBeanMap.keySet())
							{
								String [] keyArray = key.split("~");
								timeBeanList = timeBeanMap.get(key);
								dateIndex++;
								indexSuffix = dateIndex + "_1"; 
								
					
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf( keyArray[0] ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( keyArray[0] ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( keyArray[1] ));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(dateIndex  ));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(dateIndex ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(dateIndex ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block48Bytes, _wl_block48);

											if(timeBeanList != null && !timeBeanList.isEmpty())
											{
												timeIndex = 1;
												for(StaffAssignmentTimeBean timeBean : timeBeanList)
												{
													timeIndex++;
													if("Y".equals(timeBean.getShowWidgetYN()))
													{
														checkedValue = "checked";
													}
													else
													{
														checkedValue = "";
													}
													indexSuffix = dateIndex + "_" + timeIndex; 
														
								
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( timeBean.getStaffAssginmentId() ));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( timeBean.getRoleId() ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( timeBean.getRoleDesc() ));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf( timeBean.getStaffId() ));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf( timeBean.getStaffName() ));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf( checkedValue ));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(timeIndex));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( timeBean.getFromTime()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(timeIndex));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(indexSuffix));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf( timeBean.getToTime()));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(dateIndex));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(timeIndex));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf( dateIndex));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf( timeIndex ));
            _bw.write(_wl_block66Bytes, _wl_block66);

										}
									}			
							
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(dateIndex ));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(dateIndex ));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(timeIndex ));
            _bw.write(_wl_block69Bytes, _wl_block69);

							}
						}
					
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf( dateIndex ));
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(assignmentFromDate));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf( assignmentToDate));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(operRoomCode ));
            _bw.write(_wl_block76Bytes, _wl_block76);

	//putObjectInBean(beanId,payerGroupBean,request);

            _bw.write(_wl_block77Bytes, _wl_block77);

}
catch(Exception e)
{
	System.out.println("Exception in StaffAssignmentAdd.jsp::"+e.toString());
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block78Bytes, _wl_block78);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.StaffDetails.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SARole.Label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SAName.Label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ShowInWidget.Label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FromTime.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ToTime.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SAAction.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.AuditTrail.Label", java.lang.String .class,"key"));
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
}
