package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __scheduleresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/ScheduleResult.jsp", 1737962358831L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n\t<head>\n\t\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script src=\"../../eOA/js/Validate1.js\" language=\"JavaScript\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t\t<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script><!--@UAT-3-->\n\t\t<script>\n\t\t\tfunction assign(){\n\t\t\t\tif(parent.frames[1].document.getElementById(\'calender3\')){\n\t\t\t\t\tvar result1frame = parent.document.getElementById(\"result1\").contentDocument;\n\t\t\t\t\t\n\t\t\t\t\tvar tab1= document.getElementById(\"divTitleTable1\");\n\t\t\t\t\tvar tab2=document.getElementById(\"divTitleTable\");\n\t\t\t\t\tvar tab3=document.getElementById(\"divTitleTable23\");\n\t\t\t\t\tvar topValue=4;\n\t\t\t\t\tvar widthValue=400;\n\t\t\t\t\tif (typeof(tab1) != \'undefined\' && tab1 != null)\n\t\t\t\t\t{\n\t\t\t\t\t\ttab1.style.top=topValue+\"px\";\n\t\t\t\t\t\ttab1.style.left=\"0px\";\n\t\t\t\t\t\ttab1.style.width=widthValue+\"px\";\n\t\t\t\t\t\ttab1.style.visibility=\'visible\';\n\t\t\t\t\t}\n\t\t\t\t\tif (typeof(tab2) != \'undefined\' && tab2 != null)\n\t\t\t\t\t{\n\t\t\t\t\t\ttab2.style.top=\"0px\"; //4px\n\t\t\t\t\t\ttab2.style.left=widthValue+\"px\";\n\t\t\t\t\t\ttab2.style.width=\"713px\";\n\t\t\t\t\t\ttab2.style.visibility=\'visible\';\n\t\t\t\t\t}\n\t\t\t\t\tif (typeof(tab3) != \'undefined\' && tab3 != null)\n\t\t\t\t\t{\n\t\t\t\t\t\ttab3.style.top=\"65px\";\n\t\t\t\t\t\ttab3.style.left=\"0px\";\n\t\t\t\t\t\ttab3.style.width=widthValue+\"px\";\n\t\t\t\t\t\ttab3.style.visibility=\'visible\';\n\t\t\t\t\t\ttab3.style.position=\'absolute\';\n\t\t\t\t\t}\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\tif (parent.frames[1].document.getElementById(\'calender3\') != null){\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].prefenddate.value=parent.parent.frames[1].document.schedule_appointment.p_to.value;\n\t\t\t\t}\n\t\t\t\tif (parent.frames[1].document.getElementById(\'calender3\') != null){\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].prefdate.value=parent.parent.frames[1].document.schedule_appointment.p_from.value;\n\t\t\t\t}\n\t\t\t}\n\t\t\tfunction scrollTitle(){\n\t\t\t\tvar tab1=document.getElementById(\"divTitleTable1\");\n\t\t\t\tvar tab2=document.getElementById(\"divTitleTable\");\n\t\t\t\tvar tab3=document.getElementById(\"divTitleTable23\");\n\t\t\t\tvar widthValue=400;\n\t\t\t\tvar x = document.body.scrollLeft;\n\t\t\t\tvar y = document.body.scrollTop;\n\t\t\t\tif(x>0){\n\t\t\t\t\ttab1.style.left=(x-4)+\"px\";\n\t\t\t\t\ttab3.style.left=(x-4)+\"px\";\n\t\t\t\t}else{\n\t\t\t\t\ttab1.style.left=\"0px\";\n\t\t\t\t\ttab3.style.left=\"0px\";\n\t\t\t\t\tx=0;\n\t\t\t\t}if(y>0){\t\t\n\t\t\t\t\ttab1.style.top=(y-5)+\"px\";\n\t\t\t\t\ttab2.style.top=(y-5)+\"px\";\n\t\t\t\t}else{\n\t\t\t\t\ttab1.style.top=\"0px\"; //4px\n\t\t\t\t\ttab2.style.top=\"0px\"; //4px\n\t\t\t\t\ty=4;\n\t\t\t\t}\n\t\t\t}\n\t\t</script>\n\t</head>\n\t<meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n\t<body onLoad=\'assign();\' OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' onscroll=\"scrollTitle()\">\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<style type=\"text/css\">\n\t\t\t\t\t\t.menu {text-align:left;position:fixed;width:400px;}\n\t\t\t\t\t\t.menu1 {text-align:left;position:fixed;width:860px;}\n\t\t\t\t\t\tTD.USH {\n\t\t\t\t\t\t  FONT-FACE: verdana ;\n\t\t\t\t\t\t  FONT-SIZE: 8pt ;\n\t\t\t\t\t\t  BACKGROUND-COLOR: WHITE;\n\t\t\t\t\t\t  COLOR:blue;\n\t\t\t\t\t\t}\n\t\t\t\t\t</style>\n\t\t\t\t\t<div id=\"divTitleTable\" class=\'menu\' style=\"z-index:100;\">\n\t\t\t\t\t<table border=0 width=\'860px\' bgColor=white align=\"center\" >\n\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t\t<td width=\'35%\' class=USH  align=\'center\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t<td  width=\'2%\'class=OASCH>&nbsp;&nbsp;</td>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t\t\t<td width=\'35%\' class=USH >";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\t\n\t\t\t\t\t\t\t\t\t\t\t<td  width=\'35%\' class=USH align=\'left\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<td  width=\'2%\'class=OASCH>&nbsp;&nbsp;</td>\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t<td width=\'35%\' class=USH align=\'left\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\t\t<td  width=\'35%\' class=USH align=\'right\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t</tr>\t\n\t\t\t\t\t</table>\n\t\t\t\t\t<table border=1 width=\'860px\' bgColor=white  id=\'colors\' align=\"center\">\n\t\t\t\t\t<tr>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t<td class=OALABEL width=\'21px\' >\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t\t\t<td class=OALABEL width=\'21px\'>&nbsp;&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\t\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 =" \' width=\'21px\' title=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\t\n\t\t\t\t\t\t\t<input type=\'hidden\' name=day";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="  value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\' >\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\' width=\'21px\'>&nbsp;&nbsp;\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\t\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\'divTitleTable1\' name=\"divTitleTable1\"  class=\'menu1\' style=\"z-index:200;\">\n\t\t\t\t\t<table border=1 width=\'400px\' bgColor=white align=\"center\">\n\t\t\t\t\t<form name=\'calender1\' id=\'calender1\'>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'OALABEL\' width=\'59%\' height=\'10\'>&nbsp;</td>\n\t\t\t\t\t<td class=\'OALABEL\' >&nbsp;</td>\n\t\t\t\t\t<td class=\'OALABEL\'>&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'OALABEL\' >&nbsp;</td>\n\t\t\t\t\t<td class=\'OALABEL\' >&nbsp;</td>\n\t\t\t\t\t<td class=\'OALABEL\' >&nbsp;</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr>\n\t\t\t\t\t<td class=\'OALABEL\'> \n\t\t\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>\n\t\t\t\t\t<td class=\'OALABEL\'> \n\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t<td class=\'OALABEL\'>S</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t</table>\n\t\t\t\t\t</form>\n\t\t\t\t\t</div>\n\t\t\t\t\t<div id=\"divTitleTable23\"  style=\"z-index:100;\">\n\t\t\t\t\t<table border=1 width=\'400px\' bgColor=white align=\"center\" height=\'20px\'>\n\t\t\t\t\t<form name=\'calender\' id=\'calender\'>\n";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t\t\t\t\t<tr onClick=\'aaa1(this)\' height=\'27px\'>\n\t\t\t\t\t\t<td class=\'OALABEL\' width=\'193px\' NOWRAP title=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="/";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="<input type=\'hidden\' name=\'location";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\' id=\'location";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="||";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 =" \n\t\t\t\t\t\t<td class=\'OALABEL\'  width=\'115px\' nowrap title=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t<input type=\'hidden\' name=\'practitioner";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' id=\'practitioner";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' \t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="<input type=\'hidden\' name=\'practitioner";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</td>\n\t\t\t\t\t\t<td   width=\'5px\' class=\"";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\"><input type=checkbox name=\'check";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\' id=\'check";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' onClick=anyCheck(calender)></td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t\t\t\t\t<input type=\'hidden\' name=\'counter\' id=\'counter\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\" >\n\t\t\t\t\t</form>\n\t\t\t\t\t</table>\n\t\t\t\t\t</div>\n\t\t\t\t\t<!--END DIV TBALE3-->\n\t\t\t\t\t<!-- Detail FORM-->\n\t\t\t\t\t<table border=1 width=\'1260px\' align=\"left\" height=\'20px\'>\n\t\t\t\t\t<TR height=\'62px\'><td class=\'ush\'  NOWRAP height=\'26\'>&nbsp;</td></TR>\n";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\t\t\n\t\t\t\t\t\t\t<tr height=\'27px\'>\n\t\t\t\t\t\t\t<td class=\'ush\' width=\'366px\' NOWRAP height=\'24\'>&nbsp;\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'OAGREEN\' width=\'21px\' ";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 =" height=\'22\' title=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\' onClick=\'bbb1(this)\'>\n\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:moveNext(\'";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\',\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\')\">";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</a>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'OALIGHTGREEN\'  width=\'21px\' ";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'OADARKGREEN\' width=\'21px\' ";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'OAFULL\' \t\t width=\'21px\'  height=\'22\' onClick=\'bbb1(this)\'>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\n\t\t\t\t\t\t\t\t\t\t<a \thref=\"javascript:moveNext(\'";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\')\">&nbsp;&nbsp;</a>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t\t\t\t\t\t\t<!--Modified by Ashwini on 06-Jun-2019 for ML-MMOH-SCF-1212-->\n\t\t\t\t\t\t\t\t\t\t<td class=\'OAYELLOW\' ";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 =" width=\'21px\'onClick=\'bbb1(this)\' height=\'22\'>\n\t\t\t\t\t\t\t\t\t\t<a href=\"javascript:moveNext(\'";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="\')\">&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'OAFORCED\' ";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\'OARED\' title =\"";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\" width=\'21px\' height=\'22\'>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t\t\t\t\t\t\t\t<!-- The below line is changed for Incident NO:33301 by Srinivas.Y-->\n\t\t\t\t\t\t\t\t\t\t<td class=\'OAHOLIDAY\' title =\"";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\" height=\'22\' align = \'center\' width=\'21px\'>H\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\" width=\'21px\' height=\'22\'>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t\t\t\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\" width=\'21px\'  height=\'22\'>\n\t\t\t\t\t\t\t\t\t&nbsp;&nbsp;\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t\t\t\t\t</td>\t\t\t\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t</table>\n\t\t\t\t\t<form name=\'calender3\' id=\'calender3\'>\n\t\t\t\t\t<input type=\'hidden\' name=\'p_from\' id=\'p_from\'  value=\"";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'pref_start_date\' id=\'pref_start_date\'  value=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'pref_end_date\' id=\'pref_end_date\'  value=\"";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'call_date_yn\' id=\'call_date_yn\'  value=\"";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'p_to\' id=\'p_to\'  value=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'clinic\' id=\'clinic\' value=\"";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'practitioner\' id=\'practitioner\' value=\"";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'practitioner_type\' id=\'practitioner_type\' value=\"";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'speciality\' id=\'speciality\' value=\"";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\"  >\n\t\t\t\t\t<input type=\'hidden\' name=\'visittype\' id=\'visittype\' value=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'ca_mode\' id=\'ca_mode\' value=\"";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\"";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'start_sch_date\' id=\'start_sch_date\' value=\"";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\" >\n\t\t\t\t\t<input type=\'hidden\' name=\'callingMode\' id=\'callingMode\' value=\"";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'calledFrom\' id=\'calledFrom\' value=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'or_catalogue_code\' id=\'or_catalogue_code\' value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'order_id\' id=\'order_id\' value=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'order_line_num\' id=\'order_line_num\' value=\"";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\"";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"slot_appt_ctrl\" id=\"slot_appt_ctrl\" value=\"";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"visit_limit_rule\" id=\"visit_limit_rule\" value=\"";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"alcn_criteria\" id=\"alcn_criteria\" value=\"";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"override_no_of_slots_yn\" id=\"override_no_of_slots_yn\" value=\"";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="\">\n\t\t\t\t\t<input type=\'hidden\' name=\'req_id\' id=\'req_id\' value=\'";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\"install_yn_val\" id=\"install_yn_val\" value=\"";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"from_OR\" id=\"from_OR\" value=\"";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\"create_wait_list_yn\" id=\"create_wait_list_yn\" value=\"";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\">\n\t\t\t\t\t<input type=\"hidden\" name=\'visit_flag_OP\' id=\'visit_flag_OP\' value=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'contact_num_reqd_yn\' id=\'contact_num_reqd_yn\' value=\'";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'care_locn_ind\' id=\'care_locn_ind\' value=\'";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'rd_appt_yn\' id=\'rd_appt_yn\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'no_dwm\' id=\'no_dwm\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'dwm_desc\' id=\'dwm_desc\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'from_page\' id=\'from_page\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'min_ela_per_resc_noshow_in_day\' id=\'min_ela_per_resc_noshow_in_day\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'noshow_ctrl_by_splty_or_clinic\' id=\'noshow_ctrl_by_splty_or_clinic\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'from_facility_id\' id=\'from_facility_id\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'from_encounter_id\' id=\'from_encounter_id\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'no_of_noshow_appts_for_alert\' id=\'no_of_noshow_appts_for_alert\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'per_chk_for_no_show_alert\' id=\'per_chk_for_no_show_alert\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'position\' id=\'position\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n\t\t\t\t\t<input type=\"hidden\" name=\'addtl_splty\' id=\'addtl_splty\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\t\t\n\t\t\t\t\t<script>\n\t\t\t\t\tsetTimeout(\"LoadAppt_Dummy()\",500);\n\t\t\t\t\tfunction LoadAppt_Dummy(){ \n\t\t\t\t\tparent.parent.frames[1].document.forms[0].p_from.value = parent.frames[1].document.forms[2].p_from.value;\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].p_to.value = parent.frames[1].document.forms[2].p_to.value;\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].oper_stn_id.value = parent.frames[1].document.forms[2].oper_stn_id.value;\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].clinic1.value = parent.frames[1].document.forms[2].clinic.value;\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].practitioner1.value = parent.frames[1].document.forms[2].practitioner.value;\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].speciality1.value = parent.frames[1].document.forms[2].speciality.value;\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].visittype1.value = parent.frames[1].document.forms[2].visittype.value;\n\t\t\t\t\tparent.parent.frames[1].document.forms[0].start_sch_date.value = parent.frames[1].document.forms[2].start_sch_date.value;\n\t\t\t\t\t}\n\t\t\t\t\t//parent.arrows.document.forms[0].forward.disabled=false;\n\t\t\t\t\tvar call_date_yn =parent.frames[1].document.forms[2].call_date_yn.value;\n\t\t\t\t\tif (call_date_yn==\"N\"){\n\t\t\t\t\t\tvar fromarray;\n\t\t\t\t\t\tvar toarray;\n\t\t\t\t\t\tvar fromdate = parent.frames[1].document.forms[2].p_from.value ;\n\t\t\t\t\t\tvar todate   = parent.frames[1].document.forms[2].pref_start_date.value ;\n\t\t\t\t\t\tif(fromdate.length > 0 && todate.length > 0 ){\n\t\t\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\t\t\t\tif(Date.parse(todt) == Date.parse(fromdt)) {\t\t\t\t\n\t\t\t\t\t\t\t\tparent.arrows.document.forms[0].back.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\tparent.arrows.document.forms[0].back.disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar fromdate1 = parent.frames[1].document.forms[2].p_to.value ;\t\t\t\n\t\t\t\t\t\tvar todate1   = parent.frames[1].document.forms[2].pref_end_date.value ;\t\t\t\n\t\t\t\t\t\tif(fromdate1.length > 0 && todate1.length > 0 ){\n\t\t\t\t\t\t\tfromarray1 = fromdate1.split(\"/\");\n\t\t\t\t\t\t\ttoarray1 = todate1.split(\"/\");\n\t\t\t\t\t\t\tvar fromdt1 = new Date(fromarray1[2],fromarray1[1],fromarray1[0]);\n\t\t\t\t\t\t\tvar todt1 = new Date(toarray1[2],toarray1[1],toarray1[0]);\n\t\t\t\t\t\t\tif(Date.parse(todt1) == Date.parse(fromdt1))\n\t\t\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\t\t  parent.arrows.document.forms[0].forward.disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t parent.arrows.document.forms[0].forward.disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\n\t\t\t\t";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\n\t\t\t\t\t<form name=\'calender3\' id=\'calender3\'>\n\t\t\t\t\t<input type=hidden name=\'p_from\' id=\'p_from\'  value=\"";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\" >\n\t\t\t\t\t<input type=hidden name=\'p_to\' id=\'p_to\'  value=\"";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\" >\n\t\t\t\t\t<input type=hidden name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\" >\n\t\t\t\t\t<input type=hidden name=\'clinic\' id=\'clinic\' value=\"";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\" >\n\t\t\t\t\t<input type=hidden name=\'practitioner\' id=\'practitioner\' value=\"";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\" >\n\t\t\t\t\t<input type=hidden name=\'practitioner_type\' id=\'practitioner_type\' value=\"";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\" >\n\t\t\t\t\t<input type=hidden name=\'speciality\' id=\'speciality\' value=\"";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\"  >\n\t\t\t\t\t<input type=hidden name=\'visittype\' id=\'visittype\' value=\"";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\" >\n\t\t\t\t\t<script>\n\t\t\t\t\tsetTimeout(\"LoadAppt_Dummy1()\",500);\n\t\t\t\t\tfunction LoadAppt_Dummy1(){\t\t\t\t\t\t\n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\'p_from\').value = parent.frames[1].document.getElementById(\'p_from\').value;\n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\'p_to\').value = parent.frames[1].document.getElementById(\'p_to\').value;\n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\'oper_stn_id\').value = parent.frames[1].document.getElementById(\'oper_stn_id\').value;\n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\'clinic1\').value = parent.frames[1].document.getElementById(\'clinic\').value;\n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\'practitioner1\').value = parent.frames[1].document.getElementById(\'practitioner\').value;\n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\'speciality1\').value = parent.frames[1].document.getElementById(\'speciality\').value;\n\t\t\t\t\tparent.parent.frames[1].document.getElementById(\'visittype1\').value = parent.frames[1].document.getElementById(\'visittype\').value;\n\t\t\t\t\t}\n\t\t\t\t\tparent.arrows.document.getElementById(\'forward\').disabled=true;\n\t\t\t\t\tparent.arrows.document.getElementById(\'back\').disabled=true;\n\t\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\n\t\t\t\t\t\t<script>\t\t\n\t\t\t\t\t\tvar error = getMessage(\'SCH_NOT_AVAILABLE\',\'OA\');// Normal schedule search\n\t\t\t\t\t\tparent.parent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\t\t\n\t\t\t\t\t\tparent.arrows.document.getElementById(\'forward\').disabled=true;\n\t\t\t\t\t\tparent.arrows.document.getElementById(\'back\').disabled=false;\t\t\t//changed\n\t\t\t\t\t\t//parent.frames[0].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\n\t\t\t\t\t\t<script>\n\t\t\t\t\t\tvar error = getMessage(\'SCH_NOT_AVAILABLE\',\'OA\');//when searching for schedules from Pending order Schedule\n\t\t\t\t\t\talert(error);\n\t\t\t\t\t\tparent.arrows.document.getElementById(\'forward\').disabled=true;\n\t\t\t\t\t\tparent.arrows.document.getElementById(\'back\').disabled=false;//changed\n\t\t\t\t\t\t//parent.frames[0].location.href=\'../../eCommon/html/blank.html\'; \n\t\t\t\t\t\t</script>\n\t\t\t\t\t";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tparent.checkbox.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\tvar call_date_yn =\"";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\";\n\t\t\t\t\tif (call_date_yn==\"N\"){\n\t\t\t\t\t\tvar fromarray;\n\t\t\t\t\t\tvar toarray;\n\t\t\t\t\t\tvar fromdate = \"";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\" ;\n\t\t\t\t\t\tvar todate   = \"";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\";\n\t\t\t\t\t\tif(fromdate.length > 0 && todate.length > 0 ){\n\t\t\t\t\t\t\tfromarray = fromdate.split(\"/\");\n\t\t\t\t\t\t\ttoarray = todate.split(\"/\");\n\t\t\t\t\t\t\tvar fromdt = new Date(fromarray[2],fromarray[1],fromarray[0]);\n\t\t\t\t\t\t\tvar todt = new Date(toarray[2],toarray[1],toarray[0]);\n\t\t\t\t\t\t\tif(Date.parse(todt) == Date.parse(fromdt)) {\t\t\t\t\n\t\t\t\t\t\t\t\tparent.arrows.document.getElementById(\'back\').disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t\tparent.arrows.document.getElementById(\'back\').disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t\tvar fromdate1 = \"";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\";\t\t\t\n\t\t\t\t\t\tvar todate1   = \"";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\";\t\t\t\n\t\t\t\t\t\tif(fromdate1.length > 0 && todate1.length > 0 ){\n\t\t\t\t\t\t\tfromarray1 = fromdate1.split(\"/\");\n\t\t\t\t\t\t\ttoarray1 = todate1.split(\"/\");\n\t\t\t\t\t\t\tvar fromdt1 = new Date(fromarray1[2],fromarray1[1],fromarray1[0]);\n\t\t\t\t\t\t\tvar todt1 = new Date(toarray1[2],toarray1[1],toarray1[0]);\n\t\t\t\t\t\t\tif(Date.parse(todt1) == Date.parse(fromdt1))\n\t\t\t\t\t\t\t{\t\t\t\t\t\n\t\t\t\t\t\t\t  parent.arrows.document.getElementById(\'forward\').disabled=true;\n\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\telse\n\t\t\t\t\t\t\t parent.arrows.document.getElementById(\'forward\').disabled=false;\n\t\t\t\t\t\t}\n\t\t\t\t\t}\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\n\t\t\t\t<form name=\'calender3\' id=\'calender3\'>\n\t\t\t\t<input type=\'hidden\' name=\'p_from\' id=\'p_from\'  value=\"";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'p_to\' id=\'p_to\'  value=\"";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'oper_stn_id\' id=\'oper_stn_id\' value=\"";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'clinic\' id=\'clinic\' value=\"";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'practitioner\' id=\'practitioner\' value=\"";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'practitioner_type\' id=\'practitioner_type\' value=\"";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'speciality\' id=\'speciality\' value=\"";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\"  >\n\t\t\t\t<input type=\'hidden\' name=\'visittype\' id=\'visittype\' value=\"";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'ca_mode\' id=\'ca_mode\' value=\"";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\" >\n\t\t\t\t<input type=\'hidden\' name=\'ca_patient_id\' id=\'ca_patient_id\' value=\"";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

    private final static java.lang.String  _wl_block156 ="\" >\n\t\t\t\t<script>\n\t\t\t\tsetTimeout(\"LoadAppt_Dummy2()\",500);\n\t\t\t\t\tfunction LoadAppt_Dummy2(){ \n\t\t\t\tparent.parent.frames[1].document.forms[0].p_from.value = parent.frames[1].document.forms[0].p_from.value;\n\t\t\t\tparent.parent.frames[1].document.forms[0].p_to.value = parent.frames[1].document.forms[0].p_to.value;\n\t\t\t\tparent.parent.frames[1].document.forms[0].oper_stn_id.value = parent.frames[1].document.forms[0].oper_stn_id.value;\n\t\t\t\tparent.parent.frames[1].document.forms[0].clinic1.value = parent.frames[1].document.forms[0].clinic.value;\n\t\t\t\tparent.parent.frames[1].document.forms[0].practitioner1.value = parent.frames[1].document.forms[0].practitioner.value;\n\t\t\t\tparent.parent.frames[1].document.forms[0].speciality1.value = parent.frames[1].document.forms[0].speciality.value;\n\t\t\t\tparent.parent.frames[1].document.forms[0].visittype1.value = parent.frames[1].document.forms[0].visittype.value;\n\t\t\t\t}\n\t\t\t\tparent.arrows.document.forms[0].forward.disabled=true;\n\t\t\t\tparent.arrows.document.forms[0].back.disabled=true;\n\t\t\t\tparent.parent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block156Bytes = _getBytes( _wl_block156 );

    private final static java.lang.String  _wl_block157 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tparent.arrows.document.forms[0].forward.disabled=true;\n\t\t\t\t\tparent.arrows.document.forms[0].back.disabled=true;\n\t\t\t\t\tvar error = getMessage(\'SCH_NOT_AVAILABLE\',\'OA\');\n\t\t\t\t\tparent.parent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\n\t\t\t\t\tparent.frames[0].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block157Bytes = _getBytes( _wl_block157 );

    private final static java.lang.String  _wl_block158 ="\n\t\t\t\t\t<script>\t\n\t\t\t\t\tvar error = getMessage(\'SCH_NOT_AVAILABLE\',\'OA\');\n\t\t\t\t\talert(error);\t\t\n\t\t\t\t\tparent.arrows.document.forms[0].forward.disabled=true;\n\t\t\t\t\tparent.arrows.document.forms[0].back.disabled=true;\n\t\t\t\t\tparent.frames[0].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block158Bytes = _getBytes( _wl_block158 );

    private final static java.lang.String  _wl_block159 ="\n\t<script>parent.checkbox.location.href=\'../../eCommon/html/blank.html\'</script>\n";
    private final static byte[]  _wl_block159Bytes = _getBytes( _wl_block159 );

    private final static java.lang.String  _wl_block160 ="\n\t<script>\n\tparent.parent.frames[2].location.href=\'../../eCommon/html/blank.html\';\n\t</script>\n\t";
    private final static byte[]  _wl_block160Bytes = _getBytes( _wl_block160 );

    private final static java.lang.String  _wl_block161 ="\n\t\t<script>\n\t\tvar error = getMessage(\'SCH_NOT_AVAILABLE\',\'OA\');\t\n\tparent.parent.parent.frames[2].location.href=\"../../eCommon/jsp/error.jsp?err_num=\"+error;\t\n\tparent.arrows.document.forms[0].forward.disabled=true;\n\t\t\tparent.arrows.document.forms[0].back.disabled=true;\t\n\t\t\tparent.frames[0].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block161Bytes = _getBytes( _wl_block161 );

    private final static java.lang.String  _wl_block162 ="\n\t\t<script>\nvar error = getMessage(\'SCH_NOT_AVAILABLE\',\'OA\');\n\t\talert(error);\n\t\tparent.arrows.document.forms[0].forward.disabled=true;\n\t\t\tparent.arrows.document.forms[0].back.disabled=true;\n\t\t\tparent.frames[0].location.href=\'../../eCommon/html/blank.html\';\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block162Bytes = _getBytes( _wl_block162 );

    private final static java.lang.String  _wl_block163 ="\n\t<script>parent.checkbox.location.href=\'../../eCommon/html/blank.html\';</script>\t\n\t";
    private final static byte[]  _wl_block163Bytes = _getBytes( _wl_block163 );

    private final static java.lang.String  _wl_block164 ="\n<input type=\'hidden\' name=\'patient_id_temp\' id=\'patient_id_temp\' value=\"";
    private final static byte[]  _wl_block164Bytes = _getBytes( _wl_block164 );

    private final static java.lang.String  _wl_block165 ="\" >\n<input type=\'hidden\' name=\'name_prefix\' id=\'name_prefix\' value=\"";
    private final static byte[]  _wl_block165Bytes = _getBytes( _wl_block165 );

    private final static java.lang.String  _wl_block166 ="\" >\n<input type=\'hidden\' name=\'first_name\' id=\'first_name\' value=\"";
    private final static byte[]  _wl_block166Bytes = _getBytes( _wl_block166 );

    private final static java.lang.String  _wl_block167 ="\" >\n<input type=\'hidden\' name=\'second_name\' id=\'second_name\' value=\"";
    private final static byte[]  _wl_block167Bytes = _getBytes( _wl_block167 );

    private final static java.lang.String  _wl_block168 ="\" >\n<input type=\'hidden\' name=\'third_name\' id=\'third_name\' value=\"";
    private final static byte[]  _wl_block168Bytes = _getBytes( _wl_block168 );

    private final static java.lang.String  _wl_block169 ="\" >\n<input type=\'hidden\' name=\'family_name\' id=\'family_name\' value=\"";
    private final static byte[]  _wl_block169Bytes = _getBytes( _wl_block169 );

    private final static java.lang.String  _wl_block170 ="\" >\n<input type=\'hidden\' name=\'name_suffix\' id=\'name_suffix\' value=\"";
    private final static byte[]  _wl_block170Bytes = _getBytes( _wl_block170 );

    private final static java.lang.String  _wl_block171 ="\" >\n<input type=\'hidden\' name=\'name_prefix_oth_lang\' id=\'name_prefix_oth_lang\' value=\"";
    private final static byte[]  _wl_block171Bytes = _getBytes( _wl_block171 );

    private final static java.lang.String  _wl_block172 ="\" >\n<input type=\'hidden\' name=\'first_name_oth_lang\' id=\'first_name_oth_lang\' value=\"";
    private final static byte[]  _wl_block172Bytes = _getBytes( _wl_block172 );

    private final static java.lang.String  _wl_block173 ="\" >\n<input type=\'hidden\' name=\'second_name_oth_lang\' id=\'second_name_oth_lang\' value=\"";
    private final static byte[]  _wl_block173Bytes = _getBytes( _wl_block173 );

    private final static java.lang.String  _wl_block174 ="\" >\n<input type=\'hidden\' name=\'third_name_oth_lang\' id=\'third_name_oth_lang\' value=\"";
    private final static byte[]  _wl_block174Bytes = _getBytes( _wl_block174 );

    private final static java.lang.String  _wl_block175 ="\" >\n<input type=\'hidden\' name=\'family_name_oth_lang\' id=\'family_name_oth_lang\' value=\"";
    private final static byte[]  _wl_block175Bytes = _getBytes( _wl_block175 );

    private final static java.lang.String  _wl_block176 ="\" >\n<input type=\'hidden\' name=\'name_suffix_oth_lang\' id=\'name_suffix_oth_lang\' value=\"";
    private final static byte[]  _wl_block176Bytes = _getBytes( _wl_block176 );

    private final static java.lang.String  _wl_block177 ="\" >\n<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\"";
    private final static byte[]  _wl_block177Bytes = _getBytes( _wl_block177 );

    private final static java.lang.String  _wl_block178 ="\" >\n<input type=\'hidden\' name=\'contact_no\' id=\'contact_no\' value=\"";
    private final static byte[]  _wl_block178Bytes = _getBytes( _wl_block178 );

    private final static java.lang.String  _wl_block179 ="\" >\n<input type=\'hidden\' name=\'language_code_temp\' id=\'language_code_temp\' value=\"";
    private final static byte[]  _wl_block179Bytes = _getBytes( _wl_block179 );

    private final static java.lang.String  _wl_block180 ="\" >\n<input type=\'hidden\' name=\'nationality_code_temp\' id=\'nationality_code_temp\' value=\"";
    private final static byte[]  _wl_block180Bytes = _getBytes( _wl_block180 );

    private final static java.lang.String  _wl_block181 ="\" >\n<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\"";
    private final static byte[]  _wl_block181Bytes = _getBytes( _wl_block181 );

    private final static java.lang.String  _wl_block182 ="\" >\n<input type=\'hidden\' name=\'linking_code\' id=\'linking_code\' value=\"";
    private final static byte[]  _wl_block182Bytes = _getBytes( _wl_block182 );

    private final static java.lang.String  _wl_block183 ="\" >\n\n</form>\n<script>\nif(parent.parent.frames[1].document.forms[0].search)\nparent.parent.frames[1].document.forms[0].search.disabled=false;\nif(parent && parent.arrows){\n\tvar frm_dt=convertDate(\'";
    private final static byte[]  _wl_block183Bytes = _getBytes( _wl_block183 );

    private final static java.lang.String  _wl_block184 ="\',\'DMY\',\'en\',localeName);\n\tvar to_dt=convertDate(\'";
    private final static byte[]  _wl_block184Bytes = _getBytes( _wl_block184 );

    private final static java.lang.String  _wl_block185 ="\',\'DMY\',\'en\',localeName);\n\tparent.arrows.document.getElementById(\"date_period\").innerHTML=\"From:\"+frm_dt+\" - To:\"+to_dt;\n}\n</script>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block185Bytes = _getBytes( _wl_block185 );

	public double calcGregorian(int year,int month,int day)
	{
	    month--;

	   double j, weekday;

	   j = gregorian_to_jd(year, month + 1, day) +
	           (Math.floor(0 + 60 * (0 + 60 * 0) + 0.5) / 86400.0);
	   jd_to_islamic(j);
	   weekday = jwday(j);


	    return weekday;
	}

		public double gregorian_to_jd(int year, int month,int day)
	{
		double GREGORIAN_EPOCH = 1721425.5;
			
	    return (GREGORIAN_EPOCH - 1) +
	           (365 * (year - 1)) +
	           Math.floor((year - 1) / 4) +
	           (-Math.floor((year - 1) / 100)) +
	           Math.floor((year - 1) / 400) +
	           Math.floor((((367 * month) - 362) / 12) +
	           ((month <= 2) ? 0 :
	                               (leap_gregorian(year) ? -1 : -2)
	           ) +
	           day);
	}

		public boolean leap_gregorian(int year)
	{
	    return ((year % 4) == 0) &&
	            (!(((year % 100) == 0) && ((year % 400) != 0)));
	}

	public void jd_to_islamic(double jd)
	{
		double ISLAMIC_EPOCH = 1948439.5;
	    double year,month, day;
	
	    jd = Math.floor(jd) + 0.5;
	    year = Math.floor(((30 * (jd - ISLAMIC_EPOCH)) + 10646) / 10631);
	    month = Math.min(12,Math.ceil((jd - (29 + islamic_to_jd(year, 1, 1))) / 29.5) + 1);
	    day = (jd - islamic_to_jd(year, month, 1)) + 1;	    
	}

	public double islamic_to_jd(double year, double month, double day)
	{
		double ISLAMIC_EPOCH = 1948439.5;
		/*double tt=(1 +
        Math.ceil(29.5 * (1 - 1)) +
        (year - 1) * 354 +
        Math.floor((3 + (11 * year)) / 30) +
        ISLAMIC_EPOCH) - 1;*/
	    return (day +
	            Math.ceil(29.5 * (month - 1)) +
	            (year - 1) * 354 +
	            Math.floor((3 + (11 * year)) / 30) +
	            ISLAMIC_EPOCH) - 1;
	}
	
	public double jwday(double j)
	{
		return mod(Math.floor((j + 1.5)), 7);
				
	}
	
	public double mod(double a,double b)
	{
		return a - (b * Math.floor(a / b));
		
	}


private String calculate_date_range(String fromdate, String todate, PageContext pageContext) {
		DateUtils du = new DateUtils();
		fromdate = du.convertDate(fromdate, "DMY", "en", "ar");
		todate = du.convertDate(todate, "DMY", "en", "ar");

		int daysInMonth[] = { 30, 29, 30, 29, 30, 29, 30, 29, 30, 29, 30, 29 };

		//String Month[] = { "MuHarram", "Safar","Rabi`al-Awwal", "Rabi`ath-Thani", "Jumadal-Ula","Jumada t-Tania", "Rajab", "Sha`ban", "Ramadan", "Shawwal",				"Dhul-Qa`da", "Dhu l-Hijja" };
		String Month[] = { com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.January.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.February.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.March.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.April.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.May.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.June.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.July.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.August.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.September.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.October.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.November.label","oa_labels"),
			com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOA.December.label","oa_labels") };
		String month_year_str = "";
		String[] from;
		String[] to;
		from = fromdate.split("/");
		to = todate.split("/");
		int from_month = Integer.parseInt(from[1]);
		int to_month = Integer.parseInt(to[1]);
		int from_year = Integer.parseInt(from[2]);
		int to_year = Integer.parseInt(to[2]);
		int from_day = Integer.parseInt(from[0]);
		//int to_day = Integer.parseInt(to[0]);

		int no_of_days = daysInMonth[from_month - 1];

		int rem_days = no_of_days - from_day;

		int to_count = 0;
       
	    /*Below line commented for the incident  KAUH-SCF-0129.2 [IN:049853]*/
		/*if (rem_days <= 5) {
			from_month = from_month + 1;
		}*/
		/*End  KAUH-SCF-0129.2 [IN:049853]*/
		
		//if ((to_month >= 1) && (to_month < from_month)) { //commented  KAUH-SCF-0129.2 [IN:049853]
			to_count = 12;
			for (int i = from_month; i <= to_count; i++) {
				month_year_str = month_year_str + Month[i - 1] + ","
					+ from_year + "|";
			}

			for (int i = 1; i <= to_month; i++) {
				month_year_str = month_year_str + Month[i - 1] + "," + to_year
						+ "|";
			}

         /*Below line commented or the incident KAUH-SCF-0129.2 [IN:049853]*/
		/*} else {
			for (int i = from_month; i <= to_month; i++) {
				month_year_str = month_year_str + Month[i - 1] + ","
						+ from_year + "|";
			}
		}*/
		/*End  KAUH-SCF-0129.2 [IN:049853]*/
		return month_year_str;

	}
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
	 
    // Modified for CRF - SRR -0425 -- Order Catalog.
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	session.putValue("Pat_id","N");
	String callingMode = request.getParameter("callingMode");//calling mode will be "OR" if called from pending order schedule
	if (callingMode==null) callingMode = "";
	String Date=(String)request.getParameter("Date");
	String end_date=(String)request.getParameter("end_date");
	int arr[]={0,31,28,31,30,31,30,31,31,30,31,30,31};
	HashMap hm_month = new HashMap();
	hm_month.put("JAN","FEB");
	hm_month.put("FEB","MAR");
	hm_month.put("MAR","APR");
	hm_month.put("APR","MAY");
	hm_month.put("MAY","JUN");
	hm_month.put("JUN","JUL");
	hm_month.put("JUL","AUG");
	hm_month.put("AUG","SEP");
	hm_month.put("SEP","OCT");
	hm_month.put("OCT","NOV");
	hm_month.put("NOV","DEC");
	hm_month.put("DEC","JAN");
	//String dayValue[]={"","Su","Mo","Tu","We","Th","Fr","Sa"};
	int date=0;
	//int cou=0,count=0,date=0,dayStart=0,dat=0,flag=0,holidayCount=0,date11=0,month11=0,year11=0;
	String classValue="";
	//String dateStr="";
	String dateValue="";
	String tmpDate="";
	//String wk_day[] = {"S", "S", "M", "T", "W", "T", "F"};
	String wk_day[] = {"Su", "Mo", "Tu", "We", "Th", "Fr", "Sa"};
	dateValue = request.getParameter("Date");
	String from_facility_id= request.getParameter("from_facility_id");
	if(from_facility_id ==null) from_facility_id="";
	String from_encounter_id= request.getParameter("from_encounter_id");
	if(from_encounter_id ==null) from_encounter_id="";
	String disp_ear_sch=(String)request.getParameter("disp_ear_sch");
	String start_sch_date = request.getParameter("start_sch_date");
	if(start_sch_date ==null) start_sch_date="";
	if (disp_ear_sch==null) disp_ear_sch="N";
	ArrayList arrLst=new ArrayList();
	String locale=(String)session.getAttribute("LOCALE");
	String facilityid=(String)session.getValue("facility_id");
	String ca_mode=(String)request.getParameter("ca_mode");
	String ca_patient_id=(String)request.getParameter("ca_patient_id");
	String pref_start_date=(String)request.getParameter("pref_start_date");
	if(pref_start_date == null || pref_start_date.equals(" ") || pref_start_date.equals("null")) pref_start_date="";
	String pref_end_date=(String)request.getParameter("pref_end_date");
	if(pref_end_date == null || pref_end_date.equals(" ") || pref_end_date.equals("null")) pref_end_date="";
	String visit_flag_OP=request.getParameter("visit_flag_OP");
		if(visit_flag_OP==null) visit_flag_OP="N";	
	String call_date_yn=(String)request.getParameter("call_date_yn");
	if(call_date_yn == null || call_date_yn.equals(" ") || call_date_yn.equals("null")) call_date_yn="";
	String oper_stn_id=(String)request.getParameter("oper_stn_id");
	if(oper_stn_id == null || oper_stn_id.equals(" ") || oper_stn_id.equals("null") ) oper_stn_id="";
	String clinic=(String)request.getParameter("clinic");
	if(clinic == null || clinic.equals(" ") || clinic.equals("null")) clinic="";
	String practitioner=(String)request.getParameter("practitioner");
	if(practitioner == null || practitioner.equals("null")) practitioner="";
	String practitioner_type =  request.getParameter("practitioner_type");
	practitioner_type = (practitioner_type==null)?"":practitioner_type;
	String speciality=(String)request.getParameter("speciality");
	if(speciality == null || speciality.equals("null")) speciality="";
	String visittype=(String)request.getParameter("visittype");
	if(visittype == null || visittype.equals("null")) visittype ="";
	String difference=(String)request.getParameter("Difference");
	int diff_in_no=Integer.parseInt(difference);
	String curr_user_id=(String)session.getValue("login_user");
	String hddSpeclty=(String)request.getParameter("hddSpeclty");
	String order_catalog_code=request.getParameter("order_catalog_code");//from pending order schedule
	if(order_catalog_code ==null) order_catalog_code="";
	String order_id=request.getParameter("order_id");
	if(order_id ==null) order_id="";
	String order_line_num=request.getParameter("order_line_num");
	if(order_line_num ==null) order_line_num="";	
	String specialty_codema1=request.getParameter("specialty_codema1");
	if(specialty_codema1 ==null) specialty_codema1="";
	String calledFrom=request.getParameter("calledFrom");  //Added by Sathish.S for IN020026 on Monday, March 22, 2010 
	if(calledFrom ==null) calledFrom="";	
	String p_position="";
	String care_locn_ind=request.getParameter("care_locn_ind");
	String res_class=request.getParameter("res_class");
	String or_catalogue_code=request.getParameter("or_catalogue_code")==null?"":request.getParameter("or_catalogue_code");//from selecting order catalog in schedule appointment
	String rd_appt_yn=request.getParameter("rd_appt_yn")==null?"N":request.getParameter("rd_appt_yn");
	if(rd_appt_yn.equals(""))rd_appt_yn="N";
	String schedule_gender=request.getParameter("schedule_gender")==null?"":request.getParameter("schedule_gender"); //Added for this Line [Bru-HIMS-CRF-167]
	String from_OR=request.getParameter("from_OR");//from peding order  from_OR will be "Y"
	if(from_OR ==null) from_OR="N";
	String create_wait_list_yn=request.getParameter("create_wait_list_yn");
	if(create_wait_list_yn ==null) create_wait_list_yn="";
	if(care_locn_ind==null) care_locn_ind="";
	if(res_class==null) res_class="";
	String req_id=request.getParameter("req_id");
	if(req_id ==null) req_id="";
	String alcn_slot_visit="";
	String slot_appt_ctrl="";
	String visit_limit_rule="";
	String alcn_criteria="";
	String override_no_of_slots_yn="";
	String min_ela_per_resc_noshow_in_day="";
	String noshow_ctrl_by_splty_or_clinic="";
	String no_of_noshow_appts_for_alert ="";  
	String per_chk_for_no_show_alert =""; 	
	String from_page=request.getParameter("from_page");
	if(from_page ==null) from_page="";
	//these are for out put paramrters
	String  O_Clinic_Code    	 ="";
	String  O_Clinc_Name         ="";
	String  O_Clinc_long_Name         ="";
	String  O_Practitioner_I		="";
	String  O_Practitioner_N		="";
	String  O_Practitioner_full_N		="";
	String  O_Care_locn_ind		="";
	String  O_res_class		="";
	String strcode[]=null;
	String cr_locn_ind[]=null;
	String res_cls[]=null;
	String pos_clxn[]=null;
	String res_class_desc="";
	String care_locn_ind_desc="";
	String install_yn_val=request.getParameter("install_yn_val");
	if(install_yn_val ==null) install_yn_val="N";
	String capture_fin_dtls_yn="N";
	String contact_num_reqd_yn="N";
	//String practiioner_type1="";
	String no_dwm=request.getParameter("no_dwm");
	if(no_dwm ==null) no_dwm="";
	String dwm_desc=request.getParameter("dwm_desc");
	if(dwm_desc ==null) dwm_desc="";	
	String position=request.getParameter("position")==null?"":request.getParameter("position");
	String addtl_splty=request.getParameter("addtl_splty")==null?"":request.getParameter("addtl_splty");
 	String patient_id_temp			= checkForNull(request.getParameter("patient_id_temp"));
	String name_prefix				= checkForNull(request.getParameter("name_prefix")); 
	String first_name				= checkForNull(request.getParameter("first_name")); 
	String second_name				= checkForNull(request.getParameter("second_name"));
	String third_name				= checkForNull(request.getParameter("third_name")); 
	String family_name				= checkForNull(request.getParameter("family_name"));
	String name_suffix				= checkForNull(request.getParameter("name_suffix")); 	
	String name_prefix_oth_lang				= checkForNull(request.getParameter("name_prefix_oth_lang")); 
	String first_name_oth_lang				= checkForNull(request.getParameter("first_name_oth_lang")); 
	String second_name_oth_lang				= checkForNull(request.getParameter("second_name_oth_lang"));
	String third_name_oth_lang				= checkForNull(request.getParameter("third_name_oth_lang")); 
	String family_name_oth_lang				= checkForNull(request.getParameter("family_name_oth_lang"));
	String name_suffix_oth_lang				= checkForNull(request.getParameter("name_suffix_oth_lang")); 
	String gender					= checkForNull(request.getParameter("gender")); 
	String contact_no				= checkForNull(request.getParameter("contact_no"));
	String language_code_temp		= checkForNull(request.getParameter("language_code_temp")); 
	String nationality_code_temp	= checkForNull(request.getParameter("nationality_code_temp"));
	String term_set_id				= checkForNull(request.getParameter("term_set_id"));
	String linking_code				= checkForNull(request.getParameter("linking_code"));
	String thai_date;
	thai_date = com.ehis.util.DateUtils.convertDate(request.getParameter("Date"),"DMY","en",locale);
	int month=0,year=0;
	StringTokenizer strToken=new StringTokenizer(dateValue,"/");
	String tmp_mon="";
	String tmp_mon1="";
	String add_lgc="";
	String tmp_yr="";
	int lapse_days=0;
	String check_flg="N";
	String out3 = "";
	String out4 = "";
	if(strToken.hasMoreTokens()){
		date=Integer.parseInt(strToken.nextToken());
		month=Integer.parseInt(strToken.nextToken());
		year=Integer.parseInt(strToken.nextToken());
	}
	if(month==2){
		if(year%100==0&&year%400==0){
			arr[month]=arr[month]+1;
			//eOT.LogFile.log("OTDebugger","Workinghere",this);
		}else if((year%100)!=0&&(year%4)==0){
			arr[month]=arr[month]+1;
			//eOT.LogFile.log("OTDebugger","Workinghere1",this);
		}
	}

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

		Connection con = null;
		CallableStatement statement =null;
		CallableStatement statement2 = null;
		Statement stmt =null;
		PreparedStatement pstmt = null;
		ResultSet rs=null;
		try{			
			con = ConnectionManager.getConnection(request);
			stmt = con.createStatement();
			//String sql_date="select to_char(to_date('"+dateValue+"','dd/mm/yyyy'),'D') from dual";
			//rs=stmt.executeQuery(sql_date);
			//if(rs !=null && rs.next()){
				//dayStart=Integer.parseInt(rs.getString(1));
			//}
			//below lines modified by Kamatchi S for security issue against COMMON-ICN-0165
			//alcn_slot_visit="select slot_appt_ctrl,visit_limit_rule,ALCN_CRITERIA,override_no_of_slots_yn,CAPTURE_FIN_DTLS_YN,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT ,PER_CHK_FOR_NO_SHOW_ALERT,	(select last_day(to_date('"+pref_start_date+"','dd/mm/yyyy'))-to_date('"+pref_start_date+"','dd/mm/yyyy') laspse_days from dual) lapse_days from oa_param where module_id='OA'";
			//rs=stmt.executeQuery(alcn_slot_visit);
			alcn_slot_visit="select slot_appt_ctrl,visit_limit_rule,ALCN_CRITERIA,override_no_of_slots_yn,CAPTURE_FIN_DTLS_YN,MIN_ELA_PER_RESC_NOSHOW_IN_DAY,NOSHOW_CTRL_BY_SPLTY_OR_CLINIC,CONTACT_NUM_REQD_YN,NO_OF_NOSHOW_APPTS_FOR_ALERT ,PER_CHK_FOR_NO_SHOW_ALERT,	(select last_day(to_date(?,'dd/mm/yyyy'))-to_date(?,'dd/mm/yyyy') laspse_days from dual) lapse_days from oa_param where module_id='OA'";
			 pstmt=con.prepareStatement(alcn_slot_visit);
			 pstmt.setString(1, pref_start_date);
		     pstmt.setString(2, pref_start_date);
			 rs = pstmt.executeQuery();
			if(rs !=null && rs.next()){
				//dayStart=Integer.parseInt(rs.getString("sysdt"));
				slot_appt_ctrl   = rs.getString("slot_appt_ctrl");
				visit_limit_rule = rs.getString("visit_limit_rule");
				alcn_criteria= rs.getString("ALCN_CRITERIA")==null?"":rs.getString("ALCN_CRITERIA");
				override_no_of_slots_yn=rs.getString("override_no_of_slots_yn");
				if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";
				capture_fin_dtls_yn=rs.getString("CAPTURE_FIN_DTLS_YN");
				min_ela_per_resc_noshow_in_day=rs.getString("MIN_ELA_PER_RESC_NOSHOW_IN_DAY");
				if(min_ela_per_resc_noshow_in_day==null) min_ela_per_resc_noshow_in_day="";
				noshow_ctrl_by_splty_or_clinic=rs.getString("NOSHOW_CTRL_BY_SPLTY_OR_CLINIC");
				if(noshow_ctrl_by_splty_or_clinic==null) noshow_ctrl_by_splty_or_clinic="";
				contact_num_reqd_yn=rs.getString("CONTACT_NUM_REQD_YN");
				no_of_noshow_appts_for_alert=rs.getString("NO_OF_NOSHOW_APPTS_FOR_ALERT");
				if(no_of_noshow_appts_for_alert==null)   no_of_noshow_appts_for_alert=""; 
				per_chk_for_no_show_alert=rs.getString("PER_CHK_FOR_NO_SHOW_ALERT");
				if(per_chk_for_no_show_alert==null)   per_chk_for_no_show_alert="";	
				lapse_days=rs.getInt("lapse_days");
			}		
			if(rs !=null) rs.close();
			//statement2=con.prepareCall("{call get_schedule_status_hdr( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			if( position.equals("") &&  addtl_splty.equals("")){
				statement2=con.prepareCall("{call oa_schedules.get_status_hdr( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}else{
				statement2=con.prepareCall("{call oa_schedules.get_status_hdr_SRR( ?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}");
			}
			System.out.println(" ********************** Inside Schedule Result 319 \n "
					+" \n Date : "+Date
					+" \n end_date : "+end_date
					+" \n diff_in_no : "+diff_in_no
					+" \n pref_start_date : "+pref_start_date
					+" \n pref_end_date : "+pref_end_date
					+" \n call_date_yn : "+call_date_yn
					+" \n disp_ear_sch : "+disp_ear_sch
					+" \n facilityid : "+facilityid					
					+" \n speciality : "+speciality
					+" \n practitioner : "+practitioner
					+" \n clinic : "+clinic
					+"  ********************** ");
			statement2.setString( 1,	Date ) ;
			statement2.setString( 2,	end_date ) ;
			statement2.setInt(3,	diff_in_no );
			statement2.setString( 4,	pref_start_date ) ;
			statement2.setString( 5,	pref_end_date ) ;
			statement2.setString(6,	call_date_yn );
			statement2.setString(7,	disp_ear_sch );
			statement2.setString(8,	facilityid );			
			statement2.setString(9,	speciality );
			//statement2.setString(9,			"04,13" );
			statement2.setString(10,	practitioner );
			statement2.setString(11,	clinic );
			statement2.registerOutParameter(12,	Types.VARCHAR ) ;
			statement2.registerOutParameter(13,	Types.VARCHAR ) ;
			statement2.registerOutParameter(14,	Types.VARCHAR ) ;
			statement2.registerOutParameter(15,	Types.VARCHAR ) ;
			statement2.registerOutParameter(16,	Types.VARCHAR ) ;
			statement2.registerOutParameter(17,	Types.VARCHAR ) ;
			if(! position.equals("") || !addtl_splty.equals("")){			
				statement2.setString(18,	position );
				statement2.setString(19,	addtl_splty );
				statement2.setString(20,	term_set_id );
				statement2.setString(21,	linking_code );		
				statement2.setString(22,	schedule_gender);
				statement2.setString(23,	rd_appt_yn);
			}else{
				statement2.setString(18,	term_set_id );
				statement2.setString(19,	linking_code );	
				statement2.setString(20,	schedule_gender);	
				statement2.setString(21,	rd_appt_yn);	
			}
			statement2.execute() ;
			String out1= statement2.getString( 14 );
			String out2=statement2.getString( 15 );
			String day1=statement2.getString( 16 );
			out3=statement2.getString( 12 );
			out4=statement2.getString( 13 );
			String monthname=statement2.getString( 17 );
			if (out1==null) out1="";
			if (out2==null) out2="";
			if (out3==null) out3="";
			if (out4==null) out4="";
			if (day1==null) day1="";
			String tempStr=null;
			if (!((monthname==null)||monthname.equals("null")|| monthname.equals(""))){
				StringTokenizer d_token = new StringTokenizer(out1, "|");
				int d_counter=d_token.countTokens();
				String d_code[]=new String[d_counter];
				int d_track=0;
				while (d_token.hasMoreTokens()){
					d_code[d_track]=d_token.nextToken();
					d_track++;
				}			
				d_token=null;
				d_track=0;
				d_token = new StringTokenizer(day1, "|");
				String d_day[]=new String[d_token.countTokens()];
				while (d_token.hasMoreTokens()){				
					d_day[d_track]=d_token.nextToken();
					d_track++;
				}
				d_token=null;
				d_track=0;
				d_token = new StringTokenizer(monthname, "|");
				String d_mon[]=new String[d_token.countTokens()];
				while (d_token.hasMoreTokens()){
					d_mon[d_track]=d_token.nextToken();
					d_track++;
				}

				d_token=null;
				d_token = new StringTokenizer(out2, "|");			
				String d_code2[]=new String[d_token.countTokens()];
				int d_track2=0;
				while (d_token.hasMoreTokens()){
					tempStr=d_token.nextToken();	
					//if(tempStr!=null && !tempStr.equals("~")){
						d_code2[d_track2]=tempStr;
					//}
					if(d_track2==1){
						tmp_mon=d_code2[d_track2].substring(0,3);	
						tmp_yr=d_code2[d_track2].substring(4,8);
					}
					if(d_track2==3 && !d_code2[d_track2].equals("~")){					
						tmp_mon1=(String) hm_month.get(tmp_mon);
						tmp_mon=d_code2[d_track2].substring(0,3);
						if(!tmp_mon1.equals(tmp_mon)){
							add_lgc="Y";
							d_code2[d_track2]=tmp_mon1+" "+tmp_yr;
						}
					}else if(diff_in_no == -1 || diff_in_no == 1){					
						if(d_track2==1){
							tmp_mon=d_code2[d_track2].substring(0,3);						
						}	
						if(d_track2==3){
							tmp_mon1=(String) hm_month.get(tmp_mon);
							add_lgc="Y";
							//d_code2[d_track2]=tmp_mon1+" "+tmp_yr;
						}

					}else if(diff_in_no == 0 && d_code2[d_track2].equals("~")){
						check_flg="Y";
						if(d_track2==1){
							tmp_mon=d_code2[d_track2].substring(0,3);							
						}
						if(d_track2==3){
							tmp_mon1=(String) hm_month.get(tmp_mon);
							add_lgc="Y";
							//d_code2[d_track2]=tmp_mon1+" "+tmp_yr;
						}

					}
					d_track2++;
				}
				String cc3=d_code2[2];
				if(cc3.equals("~")) cc3="0";
				//int d_diff=Integer.parseInt(d_code2[0]);
				int d_diff=0;
				//int d_diff=Integer.parseInt(d_code2[0]);
				int d_diff1=0;
				if (difference.equals("0")) start_sch_date = d_code[0];
				try{
					//statement=con.prepareCall("{call get_schedule_status(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
					if(position.equals("") && addtl_splty.equals("")){
						statement=con.prepareCall("{call oa_schedules.get_status(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
					}else{
						statement=con.prepareCall("{call oa_schedules.get_status_SRR(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)}" );
					}
					
					System.out.println(" ********************** Inside Schedule Result 458 \n "
							+" \n facilityid : "+facilityid
							+" \n oper_stn_id : "+oper_stn_id
							+" \n curr_user_id : "+curr_user_id
							+" \n care_locn_ind : "+care_locn_ind
							+" \n speciality : "+speciality
							+" \n clinic : "+clinic
							+" \n visittype : "+visittype
							+" \n res_class : "+res_class					
							+" \n practitioner : "+practitioner
							+" \n d_code[0] : "+d_code[0]
							+" \n d_code[d_counter-1] : "+d_code[d_counter-1]
							+" \n care_locn_ind : "+care_locn_ind
							+" \n res_class : "+res_class
							+" \n order_catalog_code : "+order_catalog_code					
							+" \n locale : "+locale
							+"  ********************** ");
					
					
					statement.setString( 1,	facilityid ) ;
					statement.setString( 2,	oper_stn_id ) ;
					statement.setString( 3,	curr_user_id);
					if(care_locn_ind.equals("Y"))care_locn_ind="D";			
					if(callingMode.equals("OP") || callingMode.equals("IP")){
						if(clinic.length()==0)
						{
							speciality=hddSpeclty;
						}
						
					}
					if(callingMode.equals("OR") )
					{
					if(clinic.length()==0)
						{
							speciality=specialty_codema1;
						}
					}
					statement.setString( 4,	speciality);
					//statement.setString( 4,	"04,13");
					statement.setString( 5,	clinic);
					statement.setString( 6,	visittype);
					statement.setString( 7,	res_class);
					statement.setString( 8,	practitioner);
					statement.setString( 9,	d_code[0]);
					statement.setString( 10,d_code[d_counter-1]);
					statement.setString( 11,care_locn_ind);
					//statement.setString( 11,"C");
					statement.setString( 12,res_class);
					if(callingMode.equals("OR"))
					{
					statement.setString( 13,order_catalog_code);
					}else
					{
					statement.setString( 13,or_catalogue_code);
					}
					statement.setString( 14,	locale);			
					statement.registerOutParameter(15,	Types.VARCHAR ) ;
					statement.registerOutParameter(16,	Types.VARCHAR ) ;
					statement.registerOutParameter(17,	Types.VARCHAR ) ;
					statement.registerOutParameter(18,	Types.VARCHAR ) ;
					statement.registerOutParameter(19,	Types.VARCHAR ) ;
					statement.registerOutParameter(20,	Types.VARCHAR ) ;
					statement.registerOutParameter(21,	Types.VARCHAR ) ;
					statement.registerOutParameter(22,	Types.VARCHAR ) ;
					statement.registerOutParameter(23,	Types.VARCHAR ) ;
					statement.registerOutParameter(24,	Types.VARCHAR ) ;
					statement.registerOutParameter(25,	Types.VARCHAR ) ;
					statement.registerOutParameter(26,	Types.VARCHAR ) ;
					statement.registerOutParameter(27,	Types.VARCHAR ) ;
					statement.registerOutParameter(28,	Types.VARCHAR ) ;
					statement.registerOutParameter(29,	Types.VARCHAR ) ;
					statement.registerOutParameter(30,	Types.VARCHAR ) ;
					statement.registerOutParameter(31,	Types.VARCHAR ) ;
					statement.registerOutParameter(32,	Types.VARCHAR ) ;
					statement.registerOutParameter(33,	Types.VARCHAR ) ;
					statement.registerOutParameter(34,	Types.VARCHAR ) ;
					statement.registerOutParameter(35,	Types.VARCHAR ) ;
					statement.registerOutParameter(36,	Types.VARCHAR ) ;
					statement.registerOutParameter(37,	Types.VARCHAR ) ;
					statement.registerOutParameter(38,	Types.VARCHAR ) ;
					statement.registerOutParameter(39,	Types.VARCHAR ) ;
					statement.registerOutParameter(40,	Types.VARCHAR ) ;
					statement.registerOutParameter(41,	Types.VARCHAR ) ;
					statement.registerOutParameter(42,	Types.VARCHAR ) ;
					statement.registerOutParameter(43,	Types.VARCHAR ) ;
					statement.registerOutParameter(44,	Types.VARCHAR ) ;
					statement.registerOutParameter(45,	Types.VARCHAR ) ;
					statement.registerOutParameter(46,	Types.VARCHAR ) ;
					statement.registerOutParameter(47,	Types.VARCHAR ) ;
					statement.registerOutParameter(48,	Types.VARCHAR ) ;
					statement.registerOutParameter(49,	Types.VARCHAR ) ;
					statement.registerOutParameter(50,	Types.VARCHAR ) ;
					statement.registerOutParameter(51,	Types.VARCHAR ) ;
					statement.registerOutParameter(52,	Types.VARCHAR ) ;
					statement.registerOutParameter(53,	Types.VARCHAR ) ;
					if(! position.equals("") || !addtl_splty.equals("")){
						statement.setString( 54,	position);
						statement.setString( 55,	addtl_splty);
						statement.setString(56,	term_set_id );
						statement.setString(57,	linking_code );	
						statement.setString(58,	schedule_gender);
						statement.setString(59,	rd_appt_yn);
					}else{
						statement.setString(54,	term_set_id );
						statement.setString(55,	linking_code );	
						statement.setString(56,	schedule_gender);	  //Added for this line [Bru-HIMS-CRF-167]				
						statement.setString(57,	rd_appt_yn);	 			
					}
					/*
					statement.registerOutParameter(15,	Types.CLOB ) ;
					statement.registerOutParameter(16,	Types.CLOB ) ;
					statement.registerOutParameter(17,	Types.CLOB ) ;
					statement.registerOutParameter(18,	Types.CLOB ) ;
					statement.registerOutParameter(19,	Types.CLOB ) ;
					statement.registerOutParameter(20,	Types.CLOB ) ;
					statement.registerOutParameter(21,	Types.CLOB ) ;
					statement.registerOutParameter(22,	Types.CLOB ) ;
					statement.registerOutParameter(23,	Types.CLOB ) ;
					statement.registerOutParameter(24,	Types.CLOB ) ;
					statement.registerOutParameter(25,	Types.CLOB ) ;
					statement.registerOutParameter(26,	Types.CLOB ) ;
					statement.registerOutParameter(27,	Types.CLOB ) ;
					statement.registerOutParameter(28,	Types.CLOB ) ;
					statement.registerOutParameter(29,	Types.CLOB ) ;
					statement.registerOutParameter(30,	Types.CLOB ) ;
					statement.registerOutParameter(31,	Types.CLOB ) ;
					statement.registerOutParameter(32,	Types.CLOB ) ;
					statement.registerOutParameter(33,	Types.CLOB ) ;
					statement.registerOutParameter(34,	Types.CLOB ) ;
					statement.registerOutParameter(35,	Types.CLOB ) ;
					statement.registerOutParameter(36,	Types.CLOB ) ;
					statement.registerOutParameter(37,	Types.CLOB ) ;
					statement.registerOutParameter(38,	Types.CLOB ) ;
					statement.registerOutParameter(39,	Types.CLOB ) ;
					statement.registerOutParameter(40,	Types.CLOB ) ;
					statement.registerOutParameter(41,	Types.CLOB ) ;
					statement.registerOutParameter(42,	Types.CLOB ) ;
					statement.registerOutParameter(43,	Types.CLOB ) ;
					statement.registerOutParameter(44,	Types.CLOB ) ;
					statement.registerOutParameter(45,	Types.CLOB ) ;
					statement.registerOutParameter(46,	Types.CLOB ) ;
					statement.registerOutParameter(47,	Types.CLOB ) ;
					statement.registerOutParameter(48,	Types.CLOB ) ;
					statement.registerOutParameter(49,	Types.CLOB ) ;
					statement.registerOutParameter(50,	Types.CLOB ) ;
					statement.registerOutParameter(51,	Types.CLOB ) ;
					statement.registerOutParameter(52,	Types.CLOB ) ;
					statement.registerOutParameter(53,	Types.CLOB ) ;
					*/
					statement.execute() ;
					O_Clinic_Code=statement.getString( 15 );
					O_Clinc_Name =statement.getString( 16 );
					O_Clinc_long_Name =statement.getString( 50 );
					O_Practitioner_I=statement.getString( 17);
					O_Practitioner_N=statement.getString( 18);
					O_Practitioner_full_N=statement.getString( 49);
					O_Care_locn_ind=statement.getString( 51);
					O_res_class=statement.getString( 52);
					p_position=statement.getString( 53);
				}catch(Exception e){
					e.printStackTrace();
					//out.println("exception in schedule result line559" + e.toString());
				}	
				if(O_Clinic_Code!=null && (!(O_Clinic_Code.equals("null")) || !(O_Clinic_Code.equals("")))){
					String  O_Date_Status [] = new String [32];
					int count1=0;
					for(int i=19; i < 49;i++){
						if (statement.getString(i) != null )
						{
							O_Date_Status[count1] = statement.getString(i);
						}else{
							O_Date_Status[count1]="";
						}
						count1++;
					}
					//THIS IS FOR CLINIC_NAME			
					d_token=null;
					d_token = new StringTokenizer(O_Clinc_Name, "|");
					int counter=d_token.countTokens();
					String code[]=new String[counter];
					int track=0;
					while (d_token.hasMoreTokens()){
						code[track]=d_token.nextToken();
						track++;
					}
					//THIS IS FOR CLINIC_long_NAME
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Clinc_long_Name, "|");
					String code_long[]=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						code_long[track]=d_token.nextToken();
						track++;
					}			
					//THIS IS FOR care_locn_ind
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Care_locn_ind, "|");
					cr_locn_ind=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						cr_locn_ind[track]=d_token.nextToken();
						track++;
					}
					//THIS IS FOR resource_class
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_res_class, "|");
					res_cls=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						res_cls[track]=d_token.nextToken();
						track++;
					}				
					//THIS IS FOR resource_class
					d_token=null;
					track=0;
					d_token = new StringTokenizer(p_position, "|");
					pos_clxn=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						pos_clxn[track]=d_token.nextToken();
						track++;
					}
					//THIS IS FOR CLINIC_CODE	
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Clinic_Code, "|");
					strcode=new String[d_token.countTokens()];
					while (d_token.hasMoreTokens())
					{
						strcode[track]=d_token.nextToken();
						track++;
					}	
					// THIS IS FOR PRACTITIONER_NAME
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Practitioner_N, "|");
					String code1[]=new String[counter];
					if(d_token.countTokens() > 0)
					{
						while (d_token.hasMoreTokens())
						{
							code1[track]=d_token.nextToken();
							if(code1[track].equals("~")) code1[track]="";
							track++;
						}
					}
					// THIS IS FOR PRACTITIONER_FULL_NAME
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Practitioner_full_N, "|");
					String code1_full[]=new String[counter];
					if(d_token.countTokens() > 0)
					{
						while (d_token.hasMoreTokens())
						{
							code1_full[track]=d_token.nextToken();
							if(code1_full[track].equals("~")) code1_full[track]="";
							track++;

						}
					}
					String practiioner_type[]=new String[counter];
					// THIS IS FOR PRACTITIONER_ID
					d_token=null;
					track=0;
					d_token = new StringTokenizer(O_Practitioner_I, "|");
					String strcode1[]=new String[counter];
					if(d_token.countTokens() > 0)
					{
						while (d_token.hasMoreTokens())
						{
							strcode1[track]=d_token.nextToken();
							if(strcode1[track].equals("~")) strcode1[track]="";				
							track++;
						}
					}
					//code Optimisation done on 05-dec-03 by Jit
					for(int cntr=0;cntr<=29;cntr++){						
						d_token=null;
						track=0;
						String arrPop[]=new String[counter];
						d_token = new StringTokenizer(O_Date_Status[cntr], "|");
						
						while (d_token.hasMoreTokens())
						{
							arrPop[track]=d_token.nextToken();
							track++;
						}
						arrLst.add(arrPop);						
					}		
					//End Jit

            _bw.write(_wl_block7Bytes, _wl_block7);

					try{
						String local_month_range=null;
						StringTokenizer local_mn_token=null;
						//String lcl_mn_arr[]=null;
						int i=0;
						//int disp=0;
						int tval=0;
						String locarr[]=null;
						if(locale.equals("ar")){
							local_month_range=calculate_date_range(out3,out4,pageContext);
							//out.println("<script>alert('"+local_month_range+"')</script>");
							local_mn_token=new StringTokenizer(local_month_range,"|");
							//out.println("<script>alert('"+local_mn_token.countTokens()+"')</script>");
							tval=local_mn_token.countTokens();
							locarr=new String[tval];
							while(local_mn_token.hasMoreElements()){
							//out.println("<script>alert('"+local_mn_token.nextToken()+"')</script>");
							locarr[i]=local_mn_token.nextToken();
							i++;
							}
						}
						String entered="N";
						i=0;
						boolean from_mon_disp = false;
						boolean to_mon_disp = false;
						/*for(int p=1;p<28;p++){
							if(locale.equals("ar")){
								if(p==1){
									StringTokenizer tk1=new StringTokenizer(locarr[0],",");
									String mn_name1=tk1.nextToken();
									String mn1=tk1.nextToken();
									i++;
								
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mn_name1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mn1));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else if(p==10 && i < tval){
									StringTokenizer tk2=new StringTokenizer(locarr[1],",");
									String mn_name2=tk2.nextToken();
									String mn2=tk2.nextToken();
								
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mn_name2));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mn2));
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);
}
							}else{
								if(!from_mon_disp){
									String from_date=d_code2[1];
									String from_month=from_date.substring(0,4);
									from_date=from_date.substring(4,from_date.length());
									String from_date_display=DateUtils.convertDate(from_date,"YY","en",locale);
									if(Integer.parseInt(d_code2[0])>0){
										
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(from_month));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(from_date_display));
            _bw.write(_wl_block13Bytes, _wl_block13);

									}
									from_mon_disp = true;
								}else if((from_mon_disp && !to_mon_disp) && (p >Integer.parseInt(d_code2[0]))){
									if(Integer.parseInt(d_code2[2])>0){
										entered="Y";
										String to_date=d_code2[3];
										String to_month=to_date.substring(0,4);
										to_date=to_date.substring(4,to_date.length());
										String to_date_display=DateUtils.convertDate(to_date,"YY","en",locale);
										
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(to_month));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(to_date_display));
            _bw.write(_wl_block13Bytes, _wl_block13);

										to_mon_disp = true;
									}			
								}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
							}
						}*/
						if(!from_mon_disp){
							if(locale.equals("ar")){
								StringTokenizer tk1=new StringTokenizer(locarr[0],",");
								String mn_name1=tk1.nextToken();
								String mn1=tk1.nextToken();
								if(Integer.parseInt(d_code2[0])>0){
								
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mn_name1));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mn1));
            _bw.write(_wl_block10Bytes, _wl_block10);

								}
							}else{
								String from_date=d_code2[1];
								String from_month=from_date.substring(0,4);
								from_date=from_date.substring(4,from_date.length());
								String from_date_display=DateUtils.convertDate(from_date,"YY","en",locale);
								if(Integer.parseInt(d_code2[0])>0){
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(from_month));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(from_date_display));
            _bw.write(_wl_block10Bytes, _wl_block10);
}
							}
						}
						if(!to_mon_disp){
							if(locale.equals("ar")){
								StringTokenizer tk2=new StringTokenizer(locarr[1],",");
								String mn_name2=tk2.nextToken();
								String mn2=tk2.nextToken();
								if(Integer.parseInt(d_code2[2])>0){
								
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mn_name2));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(mn2));
            _bw.write(_wl_block10Bytes, _wl_block10);

								}
							}else{
								if(Integer.parseInt(d_code2[2])>0){
									entered="Y";
									String to_date=d_code2[3];
									String to_month=to_date.substring(0,4);
									to_date=to_date.substring(4,to_date.length());
									String to_date_display=DateUtils.convertDate(to_date,"YY","en",locale);
									
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(to_month));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(to_date_display));
            _bw.write(_wl_block18Bytes, _wl_block18);

								}
							}
						}
					}catch(Exception e){
						e.printStackTrace();
					}

            _bw.write(_wl_block19Bytes, _wl_block19);

					try{
						for(int d_init=0;d_init<d_track;d_init++){
							String tm_date_str=d_code[d_init];
							StringTokenizer strToken1=new StringTokenizer(tm_date_str,"/");
							int dt=0;
							int mn=0;
							int yr=0;
							if(strToken1.hasMoreTokens()){
								dt=Integer.parseInt(strToken1.nextToken());
								mn=Integer.parseInt(strToken1.nextToken());
								yr=Integer.parseInt(strToken1.nextToken());
							}
							double day_value=calcGregorian(yr,mn,dt);
							int int_val=(int)day_value;
							if(locale.equals("ar")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(wk_day[int_val]));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(d_day[d_init].substring(0,2)));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
						}
						for(int u=0;u<(30-d_track);u++){
            _bw.write(_wl_block23Bytes, _wl_block23);
}
					}catch(Exception e){
						e.printStackTrace();
					}
            _bw.write(_wl_block24Bytes, _wl_block24);

					try {
						String work_hol="";
						int pos1=0;
						for(int d_init=0;d_init<d_track;d_init++){
							work_hol=d_mon[d_init];
							pos1=work_hol.indexOf("*");
							work_hol=work_hol.substring(pos1 +1);
							if((d_code[d_init].substring(0,2)).equals("")){
								work_hol="OALABEL";
							}else{
								if(work_hol.equals("H")){
									work_hol="OAHOLIDAY";
								}else{
									work_hol="OALABEL";
								}
							}
							
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(work_hol));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(d_day[d_init]));
            _bw.write(_wl_block27Bytes, _wl_block27);

							tmpDate=DateUtils.convertDate(d_code[d_init],"DMY","en",locale);
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(tmpDate.substring(0,2)));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(d_init));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(d_code[d_init].substring(0,10)));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
						for(int u=0;u<(30-d_track);u++){
							work_hol="OALABEL";
						
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(work_hol));
            _bw.write(_wl_block32Bytes, _wl_block32);
}
					}catch(Exception e){
						e.printStackTrace();
					}

            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

					for(int init=0;init<counter;init++){
						care_locn_ind_desc=cr_locn_ind[init];
						String care_locn_ind_desc1="";
						if(care_locn_ind_desc.equals("C")){
						care_locn_ind_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
						}else if(care_locn_ind_desc.equals("E")){
							care_locn_ind_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
						}else if(care_locn_ind_desc.equals("D")){
							care_locn_ind_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
						}

            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(care_locn_ind_desc1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code_long[init]));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(code[init].length() >7){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code[init]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strcode[init]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(code[init]));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(init));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strcode[init]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(care_locn_ind_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
}if(code[init].length() == 5){
            _bw.write(_wl_block43Bytes, _wl_block43);
}else	if(code[init].length() == 6){
            _bw.write(_wl_block43Bytes, _wl_block43);
}else if(code[init].length() == 7){
            _bw.write(_wl_block43Bytes, _wl_block43);
}else{
            _bw.write(_wl_block43Bytes, _wl_block43);
}					
						res_class_desc=res_cls[init];
						String pos_value=pos_clxn[init];
						if(pos_value.equals("~")){
							pos_value="";
						}				
						String res_class_desc1="";
						if(res_class_desc.equals("P"))
						{		   res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
						}else if(res_class_desc.equals("E"))
						{
						res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
						}else if(res_class_desc.equals("R"))
						{
						res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
						}else if(res_class_desc.equals("O"))
						{
						res_class_desc1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
						}
						if(res_class_desc.equals("P")){
							if(!strcode1[init].equals("")){
							//String sql3="select POSITION_DESC from am_practitioner_lang_vw where practitioner_id='"+strcode1[init]+"' and language_id='"+locale+"'";
							//rs=stmt.executeQuery(sql3);
									//if(rs!=null){
										//if(rs.next()){
											 //practiioner_type1=rs.getString("POSITION_DESC");
											 //practiioner_type1=pos_value;
											 if(pos_value.equals("")){
												 pos_value="";
												 practiioner_type[init]=pos_value;
											}else{
												practiioner_type[init]="/"+pos_value;
											}
										//}	
									//}
									//if(rs !=null) rs.close();
							}else{
								practiioner_type[init]="";
							}
						}else{
							practiioner_type[init]="";
						}

            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(res_class_desc1));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(code1_full[init]));
            out.print( String.valueOf(practiioner_type[init]));
            _bw.write(_wl_block38Bytes, _wl_block38);
if(code1[init].length() == 6){	
            out.print( String.valueOf(code1[init]));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(init));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(init));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(strcode1[init]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block38Bytes, _wl_block38);
}else{
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(code1[init]));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(init));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(init));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(strcode1[init]));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(res_class_desc));
            _bw.write(_wl_block50Bytes, _wl_block50);
}
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(init));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(init));
            _bw.write(_wl_block54Bytes, _wl_block54);

					}

            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(counter));
            _bw.write(_wl_block56Bytes, _wl_block56);
	
					String borderc = "";
					try {
						for(int init1=0;init1<counter;init1++){
							if (disp_ear_sch.equals("Y")){
								if (start_sch_date.equals(d_code[0]))
									borderc = "BORDERCOLOR='#FF0000'";
							}
							if ( init1 % 2 == 0 )
								classValue = "QRYEVEN" ;
							else
								classValue = "QRYODD" ;

            _bw.write(_wl_block57Bytes, _wl_block57);
	
							for(int kkk=0;kkk<arrLst.size();kkk++){
								String arrDisp[]=(String []) arrLst.get(kkk);					
								if(arrDisp[init1] !=null){
									String ss=arrDisp[init1];
									String Slot_det="";
									String time_val="";
								
									int ret_val=ss.indexOf('#');						
									if(ret_val!=-1){
										StringTokenizer time_fr_to = new StringTokenizer(ss,"#");
										while (time_fr_to.hasMoreTokens()){
											Slot_det=time_fr_to.nextToken();
											time_val=time_fr_to.nextToken();
										}
									}
									String date_display=d_code[kkk];
									String x=ss.substring(0,1);
									String y="";
									String holiday_title="";
									if(x.equals("B")){
										if( ss.length() > 1){
											y=ss.substring(11,ss.length());
										}else{
											y="&nbsp;&nbsp;";	
										}
										if( y.length() == 1){
											y="0"+y;
										}
									}else if(x.equals("H")){
										holiday_title=ss.substring(11,ss.length());			
									}else{							
										if( Slot_det.length() > 2){
											y=ss.substring(11,Slot_det.length());
										}else{
											y="&nbsp;";	
										}							
										if( y.length() == 1){
											y="0"+y;
										}
									}
									if(time_val.equals("$")){
										time_val=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FreeFormat.label","common_labels");
									}						
									if(x.equals("G")) {
									
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(borderc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(time_val));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(date_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode1[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cr_locn_ind[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_cls[init1]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(y));
            _bw.write(_wl_block63Bytes, _wl_block63);

										borderc = "";
									}else if(x.equals("L")) { // Modified against JD-CRF-0177 
									
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(borderc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(time_val));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(date_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode1[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cr_locn_ind[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_cls[init1]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(y));
            _bw.write(_wl_block63Bytes, _wl_block63);

										borderc = "";
									}else if(x.equals("D")) { // Modified against JD-CRF-0177 
									
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(borderc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(time_val));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(date_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode1[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cr_locn_ind[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_cls[init1]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(y));
            _bw.write(_wl_block63Bytes, _wl_block63);

										borderc = "";
									}else if(x.equals("R")) {
									
            _bw.write(_wl_block66Bytes, _wl_block66);
y=""; 
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(date_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode1[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cr_locn_ind[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_cls[init1]));
            _bw.write(_wl_block68Bytes, _wl_block68);

									}else if(x.equals("Y")) {
									
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(borderc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(date_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode1[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cr_locn_ind[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_cls[init1]));
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(y));
            _bw.write(_wl_block63Bytes, _wl_block63);

										borderc = "";
									}else if(x.equals("F")){
									
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(borderc));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(date_display));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(strcode1[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(cr_locn_ind[init1]));
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(res_cls[init1]));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(y));
            _bw.write(_wl_block63Bytes, _wl_block63);

										borderc = "";
									}else if(x.equals("B")) {
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(y));
            _bw.write(_wl_block74Bytes, _wl_block74);

										y="";
									}else if(x.equals("H")) {
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(holiday_title));
            _bw.write(_wl_block76Bytes, _wl_block76);

										y="";
									}else{
									
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(y));
            _bw.write(_wl_block79Bytes, _wl_block79);

									}
								}else{
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block81Bytes, _wl_block81);

								}
								
            _bw.write(_wl_block82Bytes, _wl_block82);

							}
							
            _bw.write(_wl_block83Bytes, _wl_block83);

						}
					}catch(Exception e){
						e.printStackTrace();
					}

            _bw.write(_wl_block84Bytes, _wl_block84);
            out.print( String.valueOf(out3));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(pref_start_date));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(pref_end_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(call_date_yn));
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(out4));
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(clinic));
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block92Bytes, _wl_block92);
            out.print( String.valueOf(res_class));
            _bw.write(_wl_block93Bytes, _wl_block93);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(visittype));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ca_mode ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(ca_patient_id ));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(start_sch_date));
            _bw.write(_wl_block98Bytes, _wl_block98);
            out.print( String.valueOf(callingMode));
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(calledFrom));
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(or_catalogue_code));
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(order_line_num));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(req_id));
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(install_yn_val));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(from_OR));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(visit_flag_OP));
            _bw.write(_wl_block113Bytes, _wl_block113);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(contact_num_reqd_yn));
            _bw.write(_wl_block115Bytes, _wl_block115);
            out.print( String.valueOf(care_locn_ind));
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(no_dwm));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(dwm_desc));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf(from_page));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(min_ela_per_resc_noshow_in_day));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(noshow_ctrl_by_splty_or_clinic));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(from_facility_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(from_encounter_id));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(no_of_noshow_appts_for_alert));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(per_chk_for_no_show_alert));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(position));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(addtl_splty));
            _bw.write(_wl_block128Bytes, _wl_block128);

				}/*if loop checking for clinic code*/else{
				
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(out3));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(out4));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(clinic));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(visittype));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(ca_mode ));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(ca_patient_id ));
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(pref_start_date));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(pref_end_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
            out.print( String.valueOf(call_date_yn));
            _bw.write(_wl_block137Bytes, _wl_block137);
		 
					if (callingMode.equals("")){
					
            _bw.write(_wl_block138Bytes, _wl_block138);

					}else{
					
            _bw.write(_wl_block139Bytes, _wl_block139);

					}
					
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(call_date_yn));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(out3));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(pref_start_date));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(out4));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(pref_end_date));
            _bw.write(_wl_block145Bytes, _wl_block145);
}

			}else{
			
            _bw.write(_wl_block146Bytes, _wl_block146);
            out.print( String.valueOf(out3));
            _bw.write(_wl_block147Bytes, _wl_block147);
            out.print( String.valueOf(out4));
            _bw.write(_wl_block148Bytes, _wl_block148);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block149Bytes, _wl_block149);
            out.print( String.valueOf(clinic));
            _bw.write(_wl_block150Bytes, _wl_block150);
            out.print( String.valueOf(practitioner));
            _bw.write(_wl_block151Bytes, _wl_block151);
            out.print( String.valueOf(practitioner_type));
            _bw.write(_wl_block152Bytes, _wl_block152);
            out.print( String.valueOf(speciality));
            _bw.write(_wl_block153Bytes, _wl_block153);
            out.print( String.valueOf(visittype));
            _bw.write(_wl_block154Bytes, _wl_block154);
            out.print( String.valueOf(ca_mode ));
            _bw.write(_wl_block155Bytes, _wl_block155);
            out.print( String.valueOf(ca_patient_id ));
            _bw.write(_wl_block156Bytes, _wl_block156);

				if (callingMode.equals("")){
				
            _bw.write(_wl_block157Bytes, _wl_block157);

				}else{
				
            _bw.write(_wl_block158Bytes, _wl_block158);

				}
				
            _bw.write(_wl_block159Bytes, _wl_block159);
} // end of else 
	if(rs !=null) rs.close();
	if(statement !=null) statement.close();
	if(statement2 !=null) statement2.close();
	if(stmt !=null) stmt.close();
	if(pstmt !=null) pstmt.close();
	arrLst.clear();
}catch(Exception e)
	{
		e.printStackTrace();
		
            _bw.write(_wl_block160Bytes, _wl_block160);
if (callingMode.equals("")){
            _bw.write(_wl_block161Bytes, _wl_block161);
}else{
            _bw.write(_wl_block162Bytes, _wl_block162);
}
            _bw.write(_wl_block163Bytes, _wl_block163);
}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
	}

            _bw.write(_wl_block164Bytes, _wl_block164);
            out.print( String.valueOf(patient_id_temp ));
            _bw.write(_wl_block165Bytes, _wl_block165);
            out.print( String.valueOf(name_prefix ));
            _bw.write(_wl_block166Bytes, _wl_block166);
            out.print( String.valueOf(first_name ));
            _bw.write(_wl_block167Bytes, _wl_block167);
            out.print( String.valueOf(second_name ));
            _bw.write(_wl_block168Bytes, _wl_block168);
            out.print( String.valueOf(third_name ));
            _bw.write(_wl_block169Bytes, _wl_block169);
            out.print( String.valueOf(family_name ));
            _bw.write(_wl_block170Bytes, _wl_block170);
            out.print( String.valueOf(name_suffix ));
            _bw.write(_wl_block171Bytes, _wl_block171);
            out.print( String.valueOf(name_prefix_oth_lang));
            _bw.write(_wl_block172Bytes, _wl_block172);
            out.print( String.valueOf(first_name_oth_lang));
            _bw.write(_wl_block173Bytes, _wl_block173);
            out.print( String.valueOf(second_name_oth_lang));
            _bw.write(_wl_block174Bytes, _wl_block174);
            out.print( String.valueOf(third_name_oth_lang));
            _bw.write(_wl_block175Bytes, _wl_block175);
            out.print( String.valueOf(family_name_oth_lang));
            _bw.write(_wl_block176Bytes, _wl_block176);
            out.print( String.valueOf(name_suffix_oth_lang));
            _bw.write(_wl_block177Bytes, _wl_block177);
            out.print( String.valueOf(gender ));
            _bw.write(_wl_block178Bytes, _wl_block178);
            out.print( String.valueOf(contact_no ));
            _bw.write(_wl_block179Bytes, _wl_block179);
            out.print( String.valueOf(language_code_temp ));
            _bw.write(_wl_block180Bytes, _wl_block180);
            out.print( String.valueOf(nationality_code_temp ));
            _bw.write(_wl_block181Bytes, _wl_block181);
            out.print( String.valueOf(term_set_id ));
            _bw.write(_wl_block182Bytes, _wl_block182);
            out.print( String.valueOf(linking_code ));
            _bw.write(_wl_block183Bytes, _wl_block183);
            out.print( String.valueOf(out3));
            _bw.write(_wl_block184Bytes, _wl_block184);
            out.print( String.valueOf(out4));
            _bw.write(_wl_block185Bytes, _wl_block185);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resource.label", java.lang.String .class,"key"));
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
}
