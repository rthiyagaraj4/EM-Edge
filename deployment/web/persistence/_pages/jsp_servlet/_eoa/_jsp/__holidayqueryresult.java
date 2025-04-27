package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __holidayqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/HolidayQueryResult.jsp", 1729083142868L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<Script Language=\"JavaScript\" src=\"../../eOA/js/Holiday.js\"></Script>\n\n\n<HTML><head>\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\n\n</head>\n\n\n\n\n<BODY  class=\'CONTENT\' onLoad=\'ClearMsg()\' onKeyDown = \'lockKey()\'>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\nfunction  nextRecs(start,end,whereclause,fromPag){\n\tvar flag=false;\n\tvar len=document.getElementById(\"checkBox\").length;\n\tvar currentPage=document.forms[0].currentPage.value;\n\tvar fmode =document.forms[0].fmode.value;\n\tvar clinic_code=document.forms[0].clinic_code.value;\n\tvar clinic_desc=document.forms[0].clinic_desc.value;\n\tvar holiday_date=document.getElementById(holiday_date).value;\n\tvar locn_type=document.forms[0].locn_type.value;\n\tvar orderCols=document.forms[0].orderCols.value;\n\tfor(i=0;i<len;i++){\n\t\tif(document.getElementById(\"checkBox\")[i]){\n\t\t\tif(document.getElementById(\"checkBox\")[i].checked==true){\n\t\t\t\tflag=true;\n\t\t\t}\n\t\t}\n\t}\n\tif(flag==false){\n\t\tvar url=\"../../eOA/jsp/HolidayQueryResult.jsp?mode=\"+fmode+\"&from=\"+(start)+\"&to=\"+(end)+\"&whereclause=Y\"+\"&clinic_code=\"+encodeURIComponent(clinic_code)+\"&clinic_desc=\"+encodeURIComponent(clinic_desc)+\"&holiday_date=\"+holiday_date+\"&locn_type=\"+locn_type+\"&orderCols=\"+orderCols+\"&fromPage=\"+currentPage+\"&link=next&selCheckBoxes=\";\n\t\tparent.f_query_add_mod.location.href=url;\n\t}else{\n\t\tvar conf = confirm(getMessage(\"DELETE_CANCEL_HOLIDAY_NEXT\",\"OA\"));\n\t\tif(conf){\n\t\t\tvar selValues=\"\";\n\t\t\tvar selValues1=\"\";\n\t\t\tlen=parent.frames[1].document.HolidayQueryResult.checkBox.length;\n\t\t\tobj=parent.frames[1].document.HolidayQueryResult.checkBox;\n\t\t\tObj=parent.frames[1].document.HolidayQueryResult;\n\t\t\tif (Obj.selectall.checked){\n\t\t\t\tvar str=\"111111111111111\";\n\t\t\t}else{\n\t\t\t\tvar str=\"000000000000000\";\n\t\t\t}\n\t\t\tif (len!=null && len!=\'\'){\n\t\t\t\tfor (i=0;i<len;i++){\n\t\t\t\t\tif (obj[i].checked){ \n\t\t\t\t\t\tstr=parent.frames[1].replace(str,i+1,\'1\') ;\n\t\t\t\t\t\tselValues1=Obj.locnCode[i].value+\'$\'+Obj.clinicCode[i].value+\'$\'+Obj.holidayDate[i].value+\'|\';\n\t\t\t\t\t\tselValues+=selValues1;\n\t\t\t\t\t }\n\t\t\t\t}\n\t\t\t}else if(len==null){\n\t\t\t\tvar str=\"10000000000000\";\n\t\t\t\tselValues=Obj.locnCode.value+\'$\'+Obj.clinicCode.value+\'$\'+Obj.holidayDate.value+\'|\';\n\t\t\t}\n\t\t\tparent.frames[1].document.HolidayQueryResult.selectedValues.value=selValues;\n\t\t\tparent.frames[1].document.HolidayQueryResult.selCheckBoxes.value=str;\n\t\t\tparent.frames[1].document.HolidayQueryResult.prevnextsubm.value=\"Y\";\n\t\t\tvar fromPage=parent.frames[1].document.HolidayQueryResult.currentPage.value;\n\t\t\tparent.frames[1].document.HolidayQueryResult.submit();\n\t\t\t//parent.parent.frames[2].document.getElementById(\"holiday\").rows=\"8%,28%,*,8%\";\n\t\t}else{\n\t\t\tClearAll();\n\t\t\tvar url=\"../../eOA/jsp/HolidayQueryResult.jsp?mode=\"+fmode+\"&from=\"+start+\"&to=\"+end+\"&whereclause=Y\"+\"&clinic_code=\"+encodeURIComponent(clinic_code)+\"&clinic_desc=\"+encodeURIComponent(clinic_desc)+\"&holiday_date=\"+holiday_date+\"&locn_type=\"+locn_type+\"&orderCols=\"+orderCols+\"&fromPage=\"+currentPage+\"&link=next&selCheckBoxes=\";\n\t\t\tparent.f_query_add_mod.location.href=url;\n\t\t\t//var url=\"../../eOA/jsp/HolidayQueryResult.jsp\";\n\t\t}\n\t}\n}\nfunction ClearAll(){\n\tvar len=document.getElementById(\"checkBox\").length\n\tfor(i=0;i<len;i++){\n\t\tif(document.getElementById(\"checkBox\")[i]){\n\t\t\tif(document.getElementById(\"checkBox\")[i].checked==true){\n\t\t\t\tdocument.getElementById(\"checkBox\")[i].checked=false;\n\t\t\t}\n\t\t}\n\t}\n\tif(document.forms[0].selectall.checked==true){\n\t\tdocument.forms[0].selectall.checked=false;\n\t}\n}\nfunction  prevRecs(start,end,whereclause,fromPag){\n\tvar flag=false;\n\tvar len=document.getElementById(\"checkBox\").length;\n\tvar fmode=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\tvar currentPage=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\tvar clinic_code=document.forms[0].clinic_code.value;\n\tvar clinic_desc=document.forms[0].clinic_desc.value;\n\tvar holiday_date=document.forms[0].holiday_date.value;\n\tvar locn_type=document.getElementById(locn_type.value);\n\tvar orderCols=document.forms[0].orderCols.value;\n\tfor(i=0;i<len;i++){\n\t\tif(document.getElementById(\"checkBox\")[i]){\n\t\t\tif(document.getElementById(\"checkBox\")[i].checked==true){\n\t\t\t\tflag=true;\n\t\t\t}\n\t\t}\n\t}\n\tif(flag==false){\n\t\t//parent.f_query_add_mod.location.href=\"../../eOA/jsp/HolidayQueryResult<MAP NAME=\".jsp\">\t<AREA SHAPE=\"\" HREF=\"\" COORDS=\"\" ALT=\"\"></MAP>?mode=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&from=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&to=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&whereclause=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&fromPage=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&link=prev&selCheckBoxes=\";\n\t\tvar url=\"../../eOA/jsp/HolidayQueryResult.jsp?mode=\"+fmode+\"&from=\"+(start)+\"&to=\"+(end)+\"&whereclause=Y\"+\"&clinic_code=\"+encodeURIComponent(clinic_code)+\"&clinic_desc=\"+encodeURIComponent(clinic_desc)+\"&holiday_date=\"+holiday_date+\"&locn_type=\"+locn_type+\"&orderCols=\"+orderCols+\"&fromPage=\"+currentPage+\"&link=prev&selCheckBoxes=\";\n\t\tparent.f_query_add_mod.location.href=url;\n\t}else{\n\t\tvar conf = confirm(getMessage(\"DELETE_CANCEL_HOLIDAY_PREV\",\"OA\"));\n\t\tif(conf){\n\t\t\tvar selValues=\"\";\n\t\t\tvar selValues1=\"\";\n\t\t\tlen=parent.frames[1].document.HolidayQueryResult.checkBox.length;\n\t\t\tobj=parent.frames[1].document.HolidayQueryResult.checkBox;\n\t\t\tObj=parent.frames[1].document.HolidayQueryResult;\n\t\t\tif (Obj.selectall.checked){\n\t\t\t\tvar str=\"111111111111111\";\n\t\t\t}else{\n\t\t\t\tvar str=\"000000000000000\";\n\t\t\t}\n\t\t\tif (len!=null && len!=\'\'){\n\t\t\t\tfor (i=0;i<len;i++){\n\t\t\t\t\tif (obj[i].checked){ \n\t\t\t\t\t\tstr=parent.frames[1].replace(str,i+1,\'1\') ;\n\t\t\t\t\t\tselValues1=Obj.locnCode[i].value+\'$\'+Obj.clinicCode[i].value+\'$\'+Obj.holidayDate[i].value+\'|\';\n\t\t\t\t\t\tselValues+=selValues1;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t}else if(len==null){\n\t\t\t\tvar str=\"10000000000000\";\n\t\t\t\tselValues=Obj.locnCode.value+\'$\'+Obj.clinicCode.value+\'$\'+Obj.holidayDate.value+\'|\';\n\t\t\t}\n\t\t\tparent.frames[1].document.HolidayQueryResult.selectedValues.value=selValues;\n\t\t\tparent.frames[1].document.HolidayQueryResult.selCheckBoxes.value=str;\n\t\t\tvar fromPage=parent.frames[1].document.HolidayQueryResult.currentPage.value;\n\t\t\tparent.frames[1].document.HolidayQueryResult.prevnextsubm.value=\"Y\";\n\t\t\tparent.frames[1].document.HolidayQueryResult.submit();\n\t\t\t//parent.parent.frames[2].document.getElementById(\"holiday\").rows=\"8%,28%,*,8%\";\n\t\t}else{\n\t\t\tClearAll();\n\t\t\t//parent.f_query_add_mod.location.href=\"../../eOA/jsp/HolidayQueryResult.jsp?mode=\"+fmode+\"&from=\"+(start-14)+\"&to=\"+(end-14)+\"&whereclause=\"+whereclaus+\"&fromPage=\"+currentPage+\"&link=prev&selCheckBoxes=\";\n\t\t\tvar url=\"../../eOA/jsp/HolidayQueryResult.jsp?mode=\"+fmode+\"&whereclause=Y\"+\"&clinic_code=\"+encodeURIComponent(clinic_code)+\"&clinic_desc=\"+encodeURIComponent(clinic_desc)+\"&holiday_date=\"+holiday_date+\"&locn_type=\"+locn_type+\"&orderCols=\"+orderCols+\"&fromPage=\"+currentPage+\"&link=prev&selCheckBoxes=\";\n\t\t\tparent.f_query_add_mod.location.href=url;\n\t\t}\n\t}\n}\t\n</script>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =" \n\t\t\t\t\n<P>\n\n<table  align=\'right\'>\n<tr>\n<!-- <td  id=\'display_prev_next\' value=\'as\'>\n -->";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n<td align =\'right\' id=\'prev\'><A HREF=\'javascript:prevRecs(\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\",\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</A></td>\t\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><A HREF=\'javascript:nextRecs(\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</A></td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</td>\n</tr>\n</table>\n<br><br>\n</P>\n<form name=\'HolidayQueryResult\' id=\'HolidayQueryResult\' method=\'post\' action=\'../../servlet/eOA.HolidayServlet\' target=\'messageFrame\'>\n\t<table id=\'QRTable\' border=\"1\" width=\"100%\" cellspacing=\'0\' cellpadding=\'0\'>\n\t<tr>\n\t<th class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</th>\n\t<th class=\'COLUMNHEADER\' >";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&nbsp;";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="<input type=\'checkbox\' name=\'selectall\' id=\'selectall\' onClick=\'selectAll_S(this);\' ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="></th>\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t\t\t<tr>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\' >\n\n\t\t\t<!-- java.net.URLEncoder.encode for reason and locn_type_desc added by dharma against HSA-CRF-0184 [IN:049544] on Mar 11th 2015-->\n\t\t\n\t\t\t<a href=\'javascript:qryModify(\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\")\'>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t&nbsp;</a><input type=hidden name=\'locnCode\' id=\'locnCode\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'></td>\t\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\' >\n\t\t\t<a href=\'javascript:qryModify(\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\")\'>\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</a><input type=hidden name=\'clinicCode\' id=\'clinicCode\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'></td>\t\n\t\t\t\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n\n\t\t\t<a href=\'javascript:qryModify(\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</a>\n\t\t\t</td><td class=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</a><input type=hidden name=\'holidayDate\' id=\'holidayDate\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n\t\t\t<a href=\'javascript:qryModify(\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\")\'> \n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="&nbsp;</a></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</a></td>\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\' align=\'center\'><input type=\'checkbox\' id=\'check_Box";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\' name=\'checkBox\' onClick=\'javascript:checkBoxOnClick(this,";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 =");\'  ";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="></td>\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));history.go(-1);</script>\n\t";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\n</td></tr>\n</table>\n<input type=\'HIDDEN\' name=\'selCheckBoxes\' id=\'selCheckBoxes\' value=\'00000000000000\'>\n<input type=\'HIDDEN\' name=\'selectedValues\' id=\'selectedValues\' value=\'\'>\n<input type=\'HIDDEN\' name=\'function_name\' id=\'function_name\' value=\'delete\'>\n<input type=\'hidden\' name=\'fromWhere\' id=\'fromWhere\' value=\'multipleDelete\'>\n<input type=\'hidden\' name=\'currentPage\' id=\'currentPage\' value=\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'>\n<input type=\'hidden\' name=\'fmode\' id=\'fmode\' value=\'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'>\n<input type=\'hidden\' name=\'prevnextsubm\' id=\'prevnextsubm\' value=\'\'>\n<input type=\'hidden\' name=\'clinic_code\' id=\'clinic_code\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'>\n<input type=\'hidden\' name=\'clinic_desc\' id=\'clinic_desc\' value=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'>\n<input type=\'hidden\' name=\'holiday_date\' id=\'holiday_date\' value=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'>\n<input type=\'hidden\' name=\'locn_type\' id=\'locn_type\' value=\'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'>\n<input type=\'hidden\' name=\'orderCols\' id=\'orderCols\' value=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>\n</form>\n<br><center>\n</center>\n</BODY>\n</HTML>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	


request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
	StringBuffer strsql2=new StringBuffer();
	StringBuffer sql=new StringBuffer();
	StringBuffer where1=new StringBuffer();
	String whereClause = request.getParameter("whereclause");
	//URLDecoder.decode(request.getParameter("whereclause"));
	where1=where1.append(whereClause);
	String fmode	   = request.getParameter("mode") ;
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	String orderCols="";
  

	String holiday_date="";
	String holiday_date1="";

// added by Rajendra for keeping Selected Check Boxes in Session
   
   String fromPage1=request.getParameter("fromPage")==null?"0":request.getParameter("fromPage");
   String selCheckBoxes=request.getParameter("selCheckBoxes")==null?"":request.getParameter("selCheckBoxes");
   String selHolidays=request.getParameter("selHolidays")==null?"":request.getParameter("selHolidays");
   String link =request.getParameter("link")==null?"":request.getParameter("link");
   String locale=(String)session.getAttribute("LOCALE");
	

	

   int fromPage=Integer.parseInt(fromPage1);
   int currPage=0;
   String checked[] = new String[15];
   ArrayList al= new ArrayList(25);
   al.add(0,"000000000000000");
   ArrayList al1= new ArrayList(25);
   al1.add(0,"");
  
   String currSelVals="";
   try{
	//MAINTAING SESSION FOR CHECK BOXES
   ArrayList selVals= (ArrayList)session.getAttribute("selVals");
   ArrayList selVals1= (ArrayList)session.getAttribute("selVals1");

    if (selCheckBoxes.equals("") && selVals!=null) {
		session.removeAttribute("selVals");
		selCheckBoxes="000000000000000";
		selVals=null;

		session.removeAttribute("selVals1");
		selHolidays="";
		selVals1=null;
		
	}

	if (selVals==null){
		session.setAttribute("selVals",al);
	}else{
		if (selVals.size() > fromPage){
		selVals.set(fromPage,selCheckBoxes);
		}else{
		selVals.add(selCheckBoxes);
		}
		session.setAttribute("selVals",selVals);
	}

	//MAINTAING SESSION FOR SELECTED LOCATION CODE-CLINI-HOLIDAY DATE

	

		
		
	

	if (selVals1==null){
		session.setAttribute("selVals1",al1);
	}else{
		if (selVals1.size() > fromPage){
		selVals1.set(fromPage,selHolidays);
		}else{
		selVals1.add(selHolidays);
		}
		session.setAttribute("selVals1",selVals1);
	}


	if (link.equals("prev")){
		currPage=fromPage-1;
	}else if(link.equals("next")){
		currPage=fromPage+1;
	}

	for ( int i=0;i<15;i++) checked[i]="";


	if (selVals !=null){
	
	
	if (selVals.size() > currPage){
		currSelVals=(String)selVals.get(currPage);
	
		for(int i=0;i<currSelVals.length();i++){
		
		
		if (currSelVals.charAt(i)=='1'){
			checked[i]="CHECKED";

		}else{
			checked[i]="";
		}
			}

	}
   }//if
   if (selVals!=null){
	   selVals.clear();
   }
	if (selVals1!=null){
		selVals1.clear();
	}
}catch(Exception e){
	e.printStackTrace();
}
	String p_clinic_code = request.getParameter("clinic_code") == null ? "" : request.getParameter("clinic_code") ;
	String p_clinic_desc = request.getParameter("clinic_desc") == null ? "" : request.getParameter("clinic_desc") ;
	if(p_clinic_desc!=null && p_clinic_desc.equals("")){
		p_clinic_desc=java.net.URLDecoder.decode(p_clinic_desc);
	}
	//out.println("<script>alert('"+p_clinic_desc+"')</script>");
	holiday_date = request.getParameter("holiday_date") == null ? "" : request.getParameter("holiday_date") ;
	holiday_date1 = request.getParameter("holiday_date") == null ? "" : request.getParameter("holiday_date") ;
	holiday_date=DateUtils.convertDate(holiday_date,"DMY",locale,"en");
	String p_locn_type= request.getParameter("locn_type") == null ? "" : request.getParameter("locn_type") ;
	if(!(p_clinic_code == null || p_clinic_code.equals(""))){
		p_clinic_code=p_clinic_code.toUpperCase();
		sql =sql.append(" and upper(locn_code) like upper('"+p_clinic_code+"%')");
	}
	if(!(p_clinic_desc == null || p_clinic_desc.equals(""))){
			sql =sql.append( " and upper(long_desc) like  upper('"+p_clinic_desc+"%') ");

	}
	if(!(p_locn_type== null || p_locn_type.equals(""))){
		p_locn_type=p_locn_type.toUpperCase();
			sql =sql.append( " and upper(a.care_locn_type_ind) like upper('"+p_locn_type+"%') ");
	}
	if(!(holiday_date == null || holiday_date.equals(""))){
			sql=sql.append( " and holiday_date =to_date( '"+holiday_date+"' ,'dd/mm/yyyy') ");
	}
	if((whereClause == null || whereClause.equals(""))){		
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");
		if (!(ord == null || ord .equals("")) ){
			sql=sql.append(" order by ");
			orderCols=" order by ";
			for ( int i=0;i < ord.length;i++ ){
				if ( i == ord.length - 1 ){
					sql=sql.append(ord[i]);
					orderCols=orderCols+ord[i];
				}else{
					sql=sql.append(ord[i]);
					sql=sql.append(" ,");
					orderCols=orderCols+ord[i]+", ";
				}
			}
			//out.println("orderCols ==>"+orderCols);
		}
	}else {
		//sql = where1;
		orderCols=" "+request.getParameter("orderCols") == null ? "" : request.getParameter("orderCols");
		sql =sql.append(orderCols);		
	}
	//out.println("sql ==>"+sql);

	int start = 0 ;
	int end = 0 ;
	int i=1;
	if ( from == null ){
		start = 1 ;
	}else{
		start = Integer.parseInt( from ) ;
	}

	if ( to == null ){
	  	end = 14 ;
	}else{
		end = Integer.parseInt( to ) ;
	}

Connection conn = ConnectionManager.getConnection(request);

Statement stmt=null;
Statement stmt1=null;
ResultSet rset1=null;
ResultSet rs=null;
int maxRecord = 0;


            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(fmode));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(currPage));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(fmode));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(start-14));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(end-14));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(URLEncoder.encode(sql.toString())));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(currPage));
            _bw.write(_wl_block16Bytes, _wl_block16);

try
{	

	String facilityId = (String) session.getValue( "facility_id" ) ;

	stmt = conn.createStatement();
	strsql2.append(" select locn_code,to_char(holiday_date, 'dd/mm/yyyy') holiday_val_date,a.holiday_date,a.care_locn_type_ind ,long_desc,REASON_FOR_HOLIDAY, a.facility_id facilityId, to_char(holiday_date,'Day') D ,a.care_locn_type_ind clti  from oa_holiday a,op_clinic_lang_vw b where trunc(holiday_date) >= trunc(sysdate) and b.language_id='"+locale+"'  and a.facility_id ='"+facilityId+"' and a.care_locn_type_ind=b.care_locn_type_ind and a.facility_id=b.facility_id and a.locn_code=b.clinic_code  ");

	strsql2.append(sql);
	


	rs = stmt.executeQuery(strsql2.toString());
	
	strsql2.setLength(0);

		if ( start != 1 )
		 for( int j=1; j<start; i++,j++ ){
		  rs.next() ;
			}

			int k=1;
		while ( i<=end && rs.next()  )
		{
			if(maxRecord==0)
			{

	
            _bw.write(_wl_block17Bytes, _wl_block17);
if ( !(start <= 1) ){
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf((start-14)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((end-14)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(URLEncoder.encode(sql.toString())));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(currPage));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

}
//if ( !( (start+14) > maxRecord ) )
	{
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf((start+14)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf((end+14)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(URLEncoder.encode(sql.toString())));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(currPage));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
}
sql.setLength(0);
  

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(checked[0]));
            _bw.write(_wl_block28Bytes, _wl_block28);
 }
	

		
		String classValue = "" ;
	
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
			String locn_type="";
			String care_locn_desc="";
			String locn_type_desc="";
			String holiday_date_disp="";
			
			
			String cliniccode 	= "";
			
			 holiday_date="";
			String reason="";
			String holiday="";
			String clti="";
			 facilityId="";
			 facilityId	=rs.getString("facilityId")==null?"":rs.getString("facilityId");		
			 clti=rs.getString("clti")==null?"":rs.getString("clti");
			care_locn_desc =rs.getString("care_locn_type_ind");
			// out.println("locn_type :" +locn_type);
			if(care_locn_desc.equals("C"))
			{
				 locn_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
			 }
			 else if(care_locn_desc.equals("D"))
			{
				locn_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels");
			  }
			  else if(care_locn_desc.equals("E"))
			{
				locn_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels");
			}
				
			 locn_type_desc=rs.getString("long_desc");
			if(locn_type_desc == null) locn_type_desc="";
			
			 cliniccode 	= rs.getString("locn_code");
			if(cliniccode == null) cliniccode="";
			 holiday_date=rs.getString("holiday_val_date")==null?"":rs.getString("holiday_val_date");

			 holiday_date_disp=DateUtils.convertDate(holiday_date,"DMY","en",locale);

			 reason=rs.getString("REASON_FOR_HOLIDAY")==null?"":rs.getString("REASON_FOR_HOLIDAY");
			holiday=rs.getString("D")==null?"":rs.getString("D");

			holiday=holiday.trim();

			if(holiday.equalsIgnoreCase("Monday"))
								{
									holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								}else if(holiday.equalsIgnoreCase("Tuesday"))
								{
									holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								}else if(holiday.equalsIgnoreCase("Wednesday"))
								{
									holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								}else if(holiday.equalsIgnoreCase("Thursday"))
								{
									holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								}else if(holiday.equalsIgnoreCase("Friday"))
								{
									holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								}else if(holiday.equalsIgnoreCase("Saturday"))
								{
									holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
								}else  if(holiday.equalsIgnoreCase("Sunday"))
								{
									holiday=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								}

		
			
			
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(clti));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(reason)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_type_desc)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(locn_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(clti));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clti));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(reason)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_type_desc)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(clti));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(reason)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_type_desc)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(locn_type_desc));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(clti));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(reason)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_type_desc)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(holiday_date_disp));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(clti));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(reason)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_type_desc)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(holiday));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(clti));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday_date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(reason)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(holiday));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(java.net.URLEncoder.encode(locn_type_desc)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facilityId));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(reason));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(k));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(k));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(checked[k]));
            _bw.write(_wl_block49Bytes, _wl_block49);

			k=k+1;
			i++;
			maxRecord++;
		}//endwhile
	//}

	if(maxRecord == 0)
	{
            _bw.write(_wl_block50Bytes, _wl_block50);
}

	if ( maxRecord < 14 || (!rs.next()) ) {
	
            _bw.write(_wl_block51Bytes, _wl_block51);
 
			} else {
            _bw.write(_wl_block52Bytes, _wl_block52);
}

	if(stmt!=null)	stmt.close();
	if(stmt1!=null)	stmt1.close();
	if(rs!=null)	rs.close();
	if(rset1!=null)	rset1.close();
al.clear();
al1.clear();

}catch(Exception e){
		//out.println(e.toString());
		e.printStackTrace();
}
finally {
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(currPage));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(fmode));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(p_clinic_code));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(p_clinic_desc));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(holiday_date1));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(p_locn_type));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(orderCols));
            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationcode.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.HolidayDate.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.HolidayDay.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonForHoliday.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.selectall.label", java.lang.String .class,"key"));
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
}
