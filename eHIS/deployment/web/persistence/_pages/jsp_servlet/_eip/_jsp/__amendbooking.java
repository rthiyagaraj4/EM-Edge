package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import com.ehis.util.*;
import eCommon.Common.*;
import java.text.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __amendbooking extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/AmendBooking.jsp", 1735036579136L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\"../../eIP/js/AmendBooking.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n <!-- Included for the CRF - RUT-CRF013 - 23396 -->\n<title> ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </title>\n<script>\n\nasync function displayDetails()\n{\n\t\n\tvar contactdetails = document.forms[0].contactvals.value;\n\n\tvar retVal\t\t = \tnew String();\n\tvar dialogHeight = \"300px\" ;\n\tvar dialogWidth\t = \"420px\" ;\n\t\n\t//Below line added for ML-MMOH-CRF-0860.2\n\tif(document.forms[0].increasedaddressLength && document.forms[0].increasedaddressLength.value ==\"true\") dialogWidth = \"35\";\n\t//End ML-MMOH-CRF-0860.2\n\t\n\tvar status\t\t = \"no\";\n\tvar features\t = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth +\" ; scroll=no;status:\" + status;\n\tvar arguments\t = document.forms[0].contactvals;\n\n\tvar url=\"../jsp/BookAppointmentContact.jsp?FromQuery=Y&contactdetails=\"+escape(contactdetails);\n\tretVal = await window.showModalDialog(url,arguments,features);\n}\n\nfunction confirmBooking(bkg_lst_ref_no)\n{\n\tvar callFrom = \"Confirm\";\n\tshowModal(bkg_lst_ref_no,callFrom);\n}\n\nfunction callRevise(bkg_lst_ref_no)\n{\n\t/*\n\tif(confirm(getMessage(\'RELEASE_BED_BOOKING\',\'IP\')))\n\t{\n\t\tvar callFrom = \"Revise\";\n\t\tshowModal(bkg_lst_ref_no,callFrom);\t\n\t}\n\telse\n\t{\n\t}\n\t*/\n\t/*Monday, July 20, 2009 IN012449*/\n\tvar bed_no = document.forms[0].bed_no.value;\n\tvar callFrom = \"Revise\";\n\tif(bed_no != \"\")\n\t{\n\t\tif(confirm(getMessage(\'RELEASE_BED_BOOKING\',\'IP\')))\n\t\t{\n\t\t\tshowModal(bkg_lst_ref_no,callFrom);\t\n\t\t}\n\t\telse\n\t\t{\n\t\t}\n\t}\n\telse\n\t{\n\t\tshowModal(bkg_lst_ref_no,callFrom);\t\n\t}\n\t\n\n}\n\nasync function showModal(obj,callFrom)\n{\n\tvar dialogHeight= \"1000px\";\n\tvar dialogWidth = \"1200px\";\n\tvar dialogTop\t= \"87\";\n\n\tif(document.forms[0].booking_valid.value == \'1\' || callFrom == \"Confirm\")\n\t{\n\t\tbkg_lst_ref_no\t\t= obj.value\n\t\tvar retVal\t\t\t= \tnew String();\n\t\tif(callFrom == \"Revise\")\n\t\t{\n\n\t\t\tfunction_name\t= \"Revise%20Booking\";\n\t\t}\n\t\telse\n\t\t{\t\n\t\t\tfunction_name\t= \"Confirm%20Booking\";\n\t\t}\n\n\t\tvar center\t\t\t= \"1\" ;\n\t\tvar status\t\t\t=\"no\";\n\t\tvar features\t\t= \"dialogHeight:\" + dialogHeight + \"; scroll=no; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop ;\n\t\tvar arguments\t\t= \"\" ;\n\n\t\tretVal = await window.showModalDialog(\"../jsp/Booking.jsp?module_id=IP&bkg_lst_ref_no=\"+bkg_lst_ref_no+\"&function_id=BOOKING&oper_stn_id=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&revise_booking_yn=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&confirm_booking_yn=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&create_booking_yn=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&create_booking_with_conf_yn=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&function_name=\"+function_name+\"&function_type=F&callFrom=\"+callFrom+\"&access=NYNNN\",arguments,features);\n\n\t\tif(retVal != null)\n\t\t{\n\t\t\t//parent.window.close();\n\t\tlet dialogBody = parent.parent.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue = retVal;\n    \n    const dialogTag = parent.parent.document.getElementById(\"dialog_tag\");    \n    dialogTag.close(); \n\t\t}\t\n\n\t}\n\telse if (callFrom != \"Confirm\")\n\t{\n\t   alert(getMessage(\"BKG_GRACE_PERIOD_EXCEEDED\",\'IP\'));\n\t}\n}\n\nfunction exitwin() \n{\n\tvar u=\"close\";\n\t//parent.window.returnValue=u;\n\t//parent.window.close();\n\t\n\tlet dialogBody = top.document.getElementById(\'dialog-body\');\n    dialogBody.contentWindow.returnValue = u;\n    \n    const dialogTag = top.document.getElementById(\"dialog_tag\");    \n    dialogTag.close();\n}\n\nfunction sh_focus() \n{\n\t\n\tdocument.getElementById(\"allbuttons\").style.visibility=\"visible\";\n\tdocument.getElementById(\"turndowntxt\").style.visibility=\"hidden\";\t\t\n\tdocument.getElementById(\"revisetxt\").style.visibility=\"hidden\";\n\n\tdocument.getElementById(\"cancelbuttons\").style.visibility=\"hidden\";\n\tif(document.getElementById(\"NUInstsExist\")){\n\t\tdocument.getElementById(\"NUInstsExist\").style.visibility=\'hidden\';\n\t}\n\tdocument.getElementById(\"revisebuttons\").style.visibility=\"hidden\";\n\tif(document.getElementById(\"transferbuttons\"))\n\t{\n\t\tdocument.getElementById(\"transferbuttons\").style.visibility=\"hidden\";\n\t}\n\tdocument.getElementById(\"turndownbuttons\").style.visibility=\"hidden\";\n\t\n}\n\nfunction sh_layer() {\n\n\tif(document.forms[0].cancelappt)\n\t{\n\t\tdocument.forms[0].reason_for_revision.value=\"\";\n\t}\n\tdocument.getElementById(\"allbuttons\").style.visibility=\"hidden\";\n\tdocument.getElementById(\"revisetxt\").style.visibility=\"visible\";\n\tdocument.getElementById(\"cancelbuttons\").style.visibility=\"visible\";\n\tcheckPatInstns();\n}\n\nfunction cancel_layer() {\n\n\tdocument.getElementById(\"allbuttons\").style.visibility=\"visible\";\n\tdocument.getElementById(\"revisetxt\").style.visibility=\"hidden\";\n\tdocument.getElementById(\"cancelbuttons\").style.visibility=\"hidden\";\n}\n\nfunction tdopen() {\n\tdocument.getElementById(\"allbuttons\").style.visibility=\"hidden\";\n\tdocument.getElementById(\"turndowntxt\").style.visibility=\"visible\";\n\tdocument.getElementById(\"turndownbuttons\").style.visibility=\"visible\";\n\tdocument.getElementById(\"reason_for_turndown\").focus();\n}\t\n\nfunction cancel_text_area() {\n\tdocument.getElementById(\"allbuttons\").style.visibility=\"visible\";\n\tdocument.getElementById(\"turndowntxt\").style.visibility=\"hidden\";\n\tdocument.getElementById(\"turndownbuttons\").style.visibility=\"hidden\";\n}\n\n\nfunction valcheck1(Obj) \n{\n\tif(document.forms[0].reason_for_revision.value==\"\") \n\t{\n\t\talert(getMessage(\"CANCEL_REAS_NOT_BLNK\",\'IP\'));\n\t\tdocument.forms[0].reason_for_revision.focus();\n\t}\n\telse\n\t{\n\t\tdocument.forms[0].submit();\n\t}\n}\n\nfunction valcheck10(Obj) \n{\n\tif(document.forms[0].reason_for_turndown.value==\"\") {\n\t\talert(getMessage(\"TURNDOWN_REAS_NOT_BLNK\",\'IP\'));\n\tdocument.forms[0].reason_for_turndown.focus();\t\n}\nelse{\n\tdocument.forms[0].submit();\n\t}\n}\n\nfunction checkMaxLimit1(obj,maxSize)\n{\t\n   if(makeValidString(obj)==false)\n\t   return false\n   else\n\t{\n\t\tif ( obj.value.length >= maxSize )\n\t\t{\n\t\t\talert(getMessage(\"CANT_XCEED_500_CHARS\",\'IP\'));\t\n\t\t\tobj.focus();obj.select();\n\t\t}\n\t}\n}\nasync function showRemarks(viewremarks)\n{\n\t\t\tvar retVal1;\n\t\t\tvar calling_from\t\t\t= \"BookingReferenceLookupResult\";\n\t\t\tvar arguments\t\t\t\t= \"\";\n\t\t\tvar facilityid\t\t\t\t= \'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\';\n\t\t\tvar dialogHeight\t\t\t= \"12\" ;\n\t\t\tvar dialogWidth\t\t\t\t= \"23\" ;\n\t\t\tvar dialogTop\t\t\t\t= \"330\";\n\t\t\tvar dialogLeft\t\t\t\t= \"430\";\n\t\t\t\tvar features\t\t\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+ \"; dialogLeft:\" +dialogLeft+ \"; dialogTop:\" +dialogTop+ \"; status:no;scroll:no\" ;\n\t\t\tretVal1\t\t\t\t\t\t= await window.showModalDialog(\"../../eIP/jsp/remarks.jsp?remarks=\"+calling_from+\"&facilityid=\"+facilityid+\"&bookingremarks=\"+encodeURIComponent(viewremarks)+\" \",arguments,features);\n}\nfunction callMouseOverRemarks(obj,viewremarks)\n{\n\t\t\t\t\n\t\tvar Remarks = getLabel(\"Common.remarks.label\",\"Common\");\n\t\t\n\t\tvar tabdata = \"<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'></head><body><table class=\'grid\' cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>\"+Remarks+\"</td></tr><tr><td>\"+viewremarks+\"</td></tr></table></body></html>\";\n\n\t\tdocument.getElementById(\"details\").innerHTML = tabdata;\n\n\t\tvar wdth \t  = obj.offsetWidth;\n\t\tvar hght1 \t  = obj.offsetHeight;\n\n\t\tvar wdth1 = getPos(obj).x - wdth;\n\t\tvar hght = getPos(obj).y + hght1;\n\t\t\t\t\n\t\tdocument.getElementById(\"details\").style.posTop  = hght;\n\t\tdocument.getElementById(\"details\").style.posLeft  = wdth1;\n\t\tdocument.getElementById(\"details\").style.visibility = \'visible\' ;\n\t\t\t\t\t\n\n}\nfunction callOnMouseOutRemarks(obj)\n{\n\tdocument.getElementById(\"details\").style.visibility=\'hidden\' ;\n}\nfunction getPos(inputElement)\n{\n\tvar coords =  new Object();\n\tcoords.x = 0;\n\tcoords.y = 0;\n\ttry\n\t{\n\t\ttargetElement = inputElement;\n\t\tif(targetElement.x && targetElement.y)\n\t\t{\n\t\t\tcoords.x = targetElement.x;\n\t\t\tcoords.y = targetElement.y;\n\t\t}\n\t\telse\n\t\t{\n\t\t\tif(targetElement.offsetParent)\n\t\t\t{\n\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\twhile(targetElement = targetElement.offsetParent)\n\t\t\t\t{\n\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t\treturn coords;\n\t}\n\tcatch(error)\n\t{\n\t\treturn coords;\n\t}\n}\n</script>\n\t\n</head>\n\n<body onLoad=\'sh_focus()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\" style=\"overflow-x: hidden;\">\n\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n<form name=\'amend_booking\' id=\'amend_booking\' action=\'../../servlet/eIP.AmendBookingServlet\' method=\'post\' target=\'messageFrame\'>\n\n<TABLE border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\'>\n\n\t<tr>\n\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TD>\n\t\t<TD class=\'QUERYDATA\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</TD>\n\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t<td class=\'QUERYDATA\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TD>\n\t\t<TD class=\'label\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</TD>\n\t\t<TD class=\'QUERYDATA\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 =" <input type=\'hidden\' name=\'med_ser_grp_code\' id=\'med_ser_grp_code\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'></TD>\n\t</TR>\n\t\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</TD>\n\t\t<TD class=\'label\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'><b>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</b></td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="<input type=\'hidden\' name=\'bkg_lst_ref_no\' id=\'bkg_lst_ref_no\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'></TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<TR>\n\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</TD>\n\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t<td class=\'QUERYDATA\' width=\'25%\' style = \'word-break:break-all;\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</td>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" <td class=\'QUERYDATA\'  nowrap width=\'25%\'>&nbsp;</td>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\n\n\t\t<TD class=\'label\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  style = \'word-break:break-all;\' width=\'25%\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\n\t<TR>\n\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="&nbsp;";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t\t<td class=\'QUERYDATA\' width=\'25%\'  style = \'word-break:break-all;\'>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t<TD class=\'label\'  nowrap width=\'25%\'><!--/*modification for SRR20056-CRF-0506*/-->";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  nowrap style = \'word-break:break-all;\' width=\'25%\'>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t<TR>\n\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</TD>\n\t\t<TD class=\'label\'  nowrap width=\'25%\'><!--/*modification for SRR20056-CRF-0506*/-->";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</TD>\n\t\t\t<TD class=\'QUERYDATA\'  nowrap width=\'25%\' style = \'word-break:break-all;\'>";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t<TR>\n\t\t\t\t <TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</TD>\n\t\t        <TD class=\'QUERYDATA\'  style = \'word-break:break-all;\' width=\'25%\'>";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="</TD>\n\t\t\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</TD>\n\t\t         <TD class=\'QUERYDATA\'  style = \'word-break:break-all;\' width=\'25%\'>";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="</TD>\n\t\t</TR>\n\t\t<tr>\n\t\t\t<td colspan=\'4\'>&nbsp;</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t\t<TD class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="</TD>\n\t\t\t<!--<TD class=\'QUERYDATA\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="<a href=\"javascript:showRemarks(\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\')\">";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="</a>";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="</TD>-->\n\t\t\t";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\n\t\t\t<td class=\'QUERYDATA\'  style = \'word-break:break-all;\' width=\'25%\'>";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t<TD class=\'label\'  nowrap width=\'25%\'><!--/*modification for SRR20056-CRF-0506*/-->";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</TD>\n\t\t</tr>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\n\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t<tr>\n\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'><b>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</b></td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\' colspan =\'4\'>&nbsp;</TD>\n\t</TR>\n\t<tr>\n\t\t<TD class=\'label\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="</TD>\n\t\t<TD class=\'label\'   width=\'25%\'  style = \'word-break:break-all;\'>";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  width=\'25%\' style = \'word-break:break-all;\'>";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="<input type=\'hidden\' name=\'gender\' id=\'gender\' value=\"";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\"></TD>\n\t\t<TD class=\'label\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="Y/";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="M/";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="D </TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'  nowrap >";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  >";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="</TD>\n\t\t<TD class=\'label\'  >&nbsp;</TD>\n\t\t<TD class=\'label\' >&nbsp;</TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="</TD>\n\t\t<TD class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  width=\'25%\'>";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="</TD>\n\t\t\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="</TD>\n\t\t<TD class=\'label\'  width=\'25%\'>";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'  width=\'25%\' >";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  width=\'25%\' colspan=\'3\'>";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="</TD>\n\t</TR>\n";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\n\t<tr>\n\t\t<td colspan=\'4\'  class=\'fileds\'><input type=\'button\' class=\'button\' name=\'contact_dtls\' id=\'contact_dtls\' value=\'";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\'  onClick=\'displayDetails();\'></td>\n\t</tr>\n";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\n\t<tr>\n\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'><b>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="</b></td></tr>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\' colspan =\'4\'>&nbsp;</TD>\n\t</TR>\n\t<TR>\n\t\t<TD class=\'label\'  nowrap width=\'25%\'>";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  nowrap width=\'25%\' >";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'  width=\'25%\' nowrap>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</TD>\n\t</TR>\n\t<TR>\n\t\t<TD class=\'label\' colspan =\'4\'>&nbsp;</TD>\n\t</TR>\n\t<!--\n</TABLE>\n<TABLE border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id= \'bed_details\'> -->\n<div id = \'bed_details\'>\n\t<tr>\n\t\t<td class=\"COLUMNHEADER\" colspan=\'4\'><b>";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="</b></td>\n\t</tr>\n\t<tr>\n\t\t<td class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\' nowrap width=\'25%\'>";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="</TD>\n\t\t<TD class=\'QUERYDATA\'  nowrap width=\'30%\'>";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" </TD>\n\t\t\n\t</TR>\n\t<tr>\n\t\t<td class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="</TD>\n\t\t<TD class=\'QUERYDATA\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</TD>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<!--Tuesday, February 15, 2011,SRR20056-SCF-6436 [IN:025877]-->\n\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="\n\t<tr>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="</TD>\n\t\t<TD class=\'QUERYDATA\'   nowrap width=\'25%\'>\n\t\t";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\n\t\t\t\t<img src=\'../../eCommon/images/enabled.gif\'align=\'center\'></img>\n\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\n\t\t\t\t<img src=\'../../eCommon/images/RRnwd.gif\'align=\'center\'></img>\n\t\t";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\n\t\t</TD>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="</TD>\n\t</tr>\n\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="<!--SRR20056-SCF-6436 [IN:025877] end-->\n\t<!--Maheshwaran K added for the CRF : RUT-CRF-0012 (23395\t) as on 09/01/2013\n\tStart-->\n\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\n\t<TR>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'></TD>\n\t\t<TD class=\'QUERYDATA\'   nowrap width=\'25%\'></TD>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="</TD>\n\t</TR>\n\t<tr>\n\t\t<td class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'></TD>\n\t\t<TD class=\'QUERYDATA\'   nowrap width=\'25%\'></TD>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 ="</TD>\n\t</TR>\n\t\t";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="\n\t\t\t<tr>\n\t\t<td class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<TR>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'></TD>\n\t\t<TD class=\'QUERYDATA\'   nowrap width=\'25%\'></TD>\n\t\t<TD class=\'label\'   nowrap width=\'25%\'>";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="</TD>\n\t</TR>\n\t\t\t";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="\n\t\t\n\t\n\t<!--End-->\n\t</div>\n</TABLE>\n<TABLE border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'revisetxt\'>\n\t<tr>\n\t\t<td class=\"label\" colspan=\'4\'>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\'25%\' nowrap>";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\n\t\t<td  nowrap width=\'75%\' class=\'fileds\'><select name=\"reason_for_revision\" id=\"reason_for_revision\">\n\t\t<option value=\"\">--- ";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 ="---</option>\n\t\t";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="\n\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\'>";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</option>\n\t\t\t\t";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="\n\t\t\t</select>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t</tr>\n\t<tr>&nbsp;\n\t</tr>\n\t<!-- Included for the CRF - RUT-CRF013 - 23396 -->\n\t<tr>\n\t\t<td  class=\'label\'><a href=\'javascript:PatInsModalWindow()\'>";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="</a>\n\t\t<img src=\'../../eCommon/images/InfoAlert.PNG\' id=\'NUInstsExist\' style=\'visibility:hidden\'/></td>\t\n\t\t<td  colspan=3></td>\n\t</tr>\n</TABLE>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'98%\' id=\'turndowntxt\' >\n\t<tr>\n\t\t<td  class=\'label\' width=\'30%\' >";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="</td>\n\t\t<td  nowrap class=\'fileds\'><textarea name=\'reason_for_turndown\' rows=2 cols=\'60\' onBlur=\'checkMaxLimit1(this,500)\'>";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="</textarea>\n\t\t<img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></td>\n\t</tr>\n</table>\t\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' id=\'allbuttons\' align=\'right\' >\n\t<tr>\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t<td  class=\'fileds\'><input type=\'button\' name=\'conappt\' id=\'conappt\' value=\'";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="\' class=\"BUTTON\" onclick=\"confirmBooking(bkg_lst_ref_no)\"></td>\n\t\t";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\n\t\t\t\t\t<td  class=\'fileds\'><input type=\'button\' name=\'revappt\' id=\'revappt\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' class=\"BUTTON\" onclick=\"callRevise(bkg_lst_ref_no)\"></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\n\t\t\t\t\t\t<td  class=\'fileds\'><input type=\'button\' name=\'revappt\' id=\'revappt\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' class=\"BUTTON\" onclick=\"callRevise(bkg_lst_ref_no)\"></td>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\n\t\t\t\t<td class=\'fileds\'><input type=\'button\' name=\'cancelappt\' id=\'cancelappt\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'  class=\"BUTTON\" onclick=\'sh_layer()\'></td>\n\t\t\t\t";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\t<input type=\'hidden\' name=\"booking_valid\" id=\"booking_valid\" value=\"";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\">\t\n\t\t<td class=\'fileds\'><input type=\'button\' name=\'close\' id=\'close\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'  class=\"BUTTON\" onclick=\"exitwin()\"></td>\n\t</tr>\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' align=\'right\' id=\'cancelbuttons\'>\n\t<tr>\t\t\n\t\t<td class=\'white\' width=\'75%\' align=\'right\'></td>\n\t\t<td class=\'fileds\'class=\'white\'><input type=\'button\' name=\'confcancel\' id=\'confcancel\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\' class=\"BUTTON\" onclick=\'valcheck1(this)\'></td>\n\t\t<td  class=\'fileds\' class=\'white\' ><input type=\'button\' name=\'abcancel\' id=\'abcancel\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'  class=\"BUTTON\" onclick=\'sh_focus()\'></td>\n\t\t<td  class=\'fileds\' class=\'white\'><input type=\'button\' name=\'cancelclose\' id=\'cancelclose\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'  class=\"BUTTON\" onclick=\'cancel_layer();exitwin()\'></td>\n\t</tr>\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'turndownbuttons\'>\n\t<tr>\t\t\n\t\t<td></td>\n\t\t<td   class=\'fileds\'><input type=\'button\' name=\'cancel\' id=\'cancel\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\' class=\"BUTTON\" onclick=\'cancel_text_area();\'></td>\n\t\t<td   class=\'fileds\'><input type=\'button\' name=\'confcancel\' id=\'confcancel\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\' class=\"BUTTON\" onclick=\'valcheck10(this)\'></td>\n\t\t<td  class=\'fileds\'><input type=\'button\' name=\'cancelclose\' id=\'cancelclose\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'  class=\"BUTTON\" onclick=\'exitwin()\'></td>\n\t</tr>\n</table>\t\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'revisebuttons\' >\n\t<tr>\n\t\t<td></td>\n\t\t<td  class=\'fileds\'><input type=\'button\' name=\'confrevise\' id=\'confrevise\' value=\'";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

    private final static java.lang.String  _wl_block133 ="\' class=\"BUTTON\" onclick=\'valcheck2(this)\'></td>\n\t\t<td    class=\'fileds\'><input type=\'button\' name=\'abrevise\' id=\'abrevise\' value=\'";
    private final static byte[]  _wl_block133Bytes = _getBytes( _wl_block133 );

    private final static java.lang.String  _wl_block134 ="\'  class=\"BUTTON\" onclick=\'sh_focus()\'></td>\n\t\t<td  class=\'fileds\'><input type=\'button\' name=\'reviseclose\' id=\'reviseclose\' value=\'";
    private final static byte[]  _wl_block134Bytes = _getBytes( _wl_block134 );

    private final static java.lang.String  _wl_block135 ="\'  class=\"BUTTON\" onclick=\'exitwin()\'></td>\n\t</tr>\n</table>\n<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'100%\' id=\'transferbuttons\'>\n\t<tr>\n\t\t<td></td>\n\t\t<td></td>\n\t\t<td  class=\'fileds\'><input type=\'button\' name=\'abort_revision\' id=\'abort_revision\' value=\'";
    private final static byte[]  _wl_block135Bytes = _getBytes( _wl_block135 );

    private final static java.lang.String  _wl_block136 ="\'  class=\"BUTTON\" onclick=\'abortwin()\'></td>\n\t\t<td class=\'fileds\'><input type=\'button\' name=\'reviseclose\' id=\'reviseclose\' value=\'";
    private final static byte[]  _wl_block136Bytes = _getBytes( _wl_block136 );

    private final static java.lang.String  _wl_block137 ="\'  class=\"BUTTON\" onclick=\'exitwin()\'></td>\n\t</tr>\n</table>\n<input type=\'hidden\' name=\"contactvals\" id=\"contactvals\" value=\"";
    private final static byte[]  _wl_block137Bytes = _getBytes( _wl_block137 );

    private final static java.lang.String  _wl_block138 ="\">\n<input type=\'hidden\' name=\'iscapture_fin_dtls_yn\' id=\'iscapture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block138Bytes = _getBytes( _wl_block138 );

    private final static java.lang.String  _wl_block139 ="\'>\n<input type=\'hidden\' name=\'isBlInstalled\' id=\'isBlInstalled\' value=\'";
    private final static byte[]  _wl_block139Bytes = _getBytes( _wl_block139 );

    private final static java.lang.String  _wl_block140 ="\'>\n<input type=\'hidden\' name=\'bed_no\' id=\'bed_no\' value=\'";
    private final static byte[]  _wl_block140Bytes = _getBytes( _wl_block140 );

    private final static java.lang.String  _wl_block141 ="\'>\n<!-- Included for the CRF - RUT-CRF013 - 23396 -->\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block141Bytes = _getBytes( _wl_block141 );

    private final static java.lang.String  _wl_block142 ="\'>\n<input type=\'hidden\' name=\'nursing_unit\' id=\'nursing_unit\' value=\'";
    private final static byte[]  _wl_block142Bytes = _getBytes( _wl_block142 );

    private final static java.lang.String  _wl_block143 ="\'>\n<!--//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023\t-->\n<input type=\'hidden\' name=\'smartCardFunc\' id=\'smartCardFunc\' value=\'";
    private final static byte[]  _wl_block143Bytes = _getBytes( _wl_block143 );

    private final static java.lang.String  _wl_block144 ="\'>\n<input type=\'hidden\' name=\'biometric_reason\' id=\'biometric_reason\' value=\'";
    private final static byte[]  _wl_block144Bytes = _getBytes( _wl_block144 );

    private final static java.lang.String  _wl_block145 ="\'>\n<!--Ends-->\n<!--Below line added for ML-MMOH-CRF-0860.2-->\n<input type=\'hidden\' name=\'increasedaddressLength\' id=\'increasedaddressLength\' value=\'";
    private final static byte[]  _wl_block145Bytes = _getBytes( _wl_block145 );

    private final static java.lang.String  _wl_block146 ="\'>\n\n</form>\n";
    private final static byte[]  _wl_block146Bytes = _getBytes( _wl_block146 );

    private final static java.lang.String  _wl_block147 ="\n\t<script>if(document.forms[0].revappt) document.forms[0].revappt.enabled = \'true\' </script>\t\n";
    private final static byte[]  _wl_block147Bytes = _getBytes( _wl_block147 );

    private final static java.lang.String  _wl_block148 ="\n\t<script>if(document.forms[0].revappt) document.forms[0].revappt.disabled = \'false\' </script>\n\n";
    private final static byte[]  _wl_block148Bytes = _getBytes( _wl_block148 );

    private final static java.lang.String  _wl_block149 ="\n\t<script>if(document.forms[0].conappt) document.forms[0].conappt.enabled = \'true\' </script>\n";
    private final static byte[]  _wl_block149Bytes = _getBytes( _wl_block149 );

    private final static java.lang.String  _wl_block150 ="\n\t<script>if(document.forms[0].conappt) document.forms[0].conappt.disabled = \'false\' </script>\n\n";
    private final static byte[]  _wl_block150Bytes = _getBytes( _wl_block150 );

    private final static java.lang.String  _wl_block151 ="\n\t<script>if(document.forms[0].cancelappt) document.forms[0].cancelappt.enabled = \'true\'</script>\t\n";
    private final static byte[]  _wl_block151Bytes = _getBytes( _wl_block151 );

    private final static java.lang.String  _wl_block152 ="\n\t<script>if(document.forms[0].cancelappt) document.forms[0].cancelappt.disabled = \'false\'</script>\t\n\t\n";
    private final static byte[]  _wl_block152Bytes = _getBytes( _wl_block152 );

    private final static java.lang.String  _wl_block153 ="\n\t<script>if(document.forms[0].conappt) document.forms[0].conappt.enabled = \'false\'</script>\t\n";
    private final static byte[]  _wl_block153Bytes = _getBytes( _wl_block153 );

    private final static java.lang.String  _wl_block154 ="\n\t<script>if(document.forms[0].conappt) document.forms[0].conappt.enabled = \'true\'</script>\t\n";
    private final static byte[]  _wl_block154Bytes = _getBytes( _wl_block154 );

    private final static java.lang.String  _wl_block155 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block155Bytes = _getBytes( _wl_block155 );

	/// Added by Sridhar R , on 4/26/2005.. these functions will chk for null values & initialize inputString values...
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}

	public static String isSiteSpecificforBiometric(Connection con)
	 {
	 	String function_name="";
	 	PreparedStatement pstmt		= null;
	 	ResultSet rs 				= null;
	 	try
	 	{
	 	String siteSpecificSQL="select nvl(VALUE_2,'00') VALUE_2 from sm_function_control a,SM_SITE_PARAM b  where module_id='MP' and FUNCTIONALITY_ID='SMART_CARD_INTG' and a.SITE_ID=B.CUSTOMER_ID";
	 	pstmt= con.prepareStatement(siteSpecificSQL);
	     rs= pstmt.executeQuery();
	     if(rs!=null && rs.next())
	 	{
	 	function_name=rs.getString("VALUE_2");
	 	}	
	 	}catch(Exception esql)
	 	{
	 		esql.printStackTrace();
	 	}finally
	 	{
	 		try{
	 	 if(pstmt != null)pstmt.close();
	 	 if(rs != null)rs.close();
	 		}catch(Exception fe){
	 			
	 		}
	 	}
	 	return function_name;
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
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String locale				= (String)session.getAttribute("LOCALE");
	String facility_id			= (String)session.getAttribute("facility_id");
	String oper_stn_id			= request.getParameter("oper_stn_id");
	String revise_booking_yn	= request.getParameter("revise_booking_yn");
	if(revise_booking_yn == null) revise_booking_yn = "";

	String cancel_booking_yn	= request.getParameter("cancel_booking_yn");
	if(cancel_booking_yn == null) cancel_booking_yn = "";

	String confirm_booking_yn	= request.getParameter("confirm_booking_yn");
	if(confirm_booking_yn == null) confirm_booking_yn = "";

	String create_booking_with_conf_yn = request.getParameter("create_booking_with_conf_yn");
	if(create_booking_with_conf_yn == null) create_booking_with_conf_yn = "";

	String create_booking_yn	= request.getParameter("create_booking_yn");
	if(create_booking_yn == null) create_booking_yn = "";

	String bl_interfaced_yn		= request.getParameter("bl_interfaced_yn");
	if(bl_interfaced_yn == null) bl_interfaced_yn = "N";

	String capture_fin_dtls_yn	= request.getParameter("capture_fin_dtls_yn");
	if(capture_fin_dtls_yn == null) capture_fin_dtls_yn = "N";
	String calling				= checkForNull(request.getParameter("calling"));
//out.println("<script>alert(\"bl_interfaced_yn : "+bl_interfaced_yn+"\");</script>");
//out.println("<script>alert(\"bl_interfaced_yn : "+capture_fin_dtls_yn+"\");</script>");

            _bw.write(_wl_block6Bytes, _wl_block6);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(revise_booking_yn));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(confirm_booking_yn));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(create_booking_yn));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(create_booking_with_conf_yn));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block15Bytes, _wl_block15);

		Connection	con		= null;
		Statement	stmt	= null;
		PreparedStatement	stmt2	= null;
		Statement	PrStmt	= null;
		ResultSet	rs		= null;
		ResultSet	rset2	= null;
		ResultSet	PrRs	= null;

		String bookingRefNo			= request.getParameter("bookingRefNo");
//		String loginUser			= (String)session.getValue("login_user");
		String pref_adm_date_desc	= "";
		String med_ser_short_desc	= ""; 
		String bkg_lst_ref_no		= "";     
		String patient_id			= "";         
		String patient_name			= "";       
		String national_id_no		= "";     
		String alt_id1_no			= "";         
		String gender				= "";             
		String date_of_birth		= ""; 
		String bed_class_desc		= "";
		String bed_type_short_desc	= "";
		String birth_place_desc		= "";
		String citizen_yn			= "";
		String ethnic_grp_desc		= "";
		String legal_yn				= "";
		String race_desc			= "";
		String res_tel_no			= "";         
		String oth_contact_no		= "";     
		String email_id				= "";           
		String practitioner_name	= "";
		String specialty_short_desc	= "";
		String exp_days_of_stay		= "";
		String expected_discharge_date = "";
		String nursing_unit_short_desc ="";
		String nursing_unit ="";// Included for the CRF - RUT-CRF013 - 23396 
		String room_no				= "";            
		String bed_no				= "";  
		String age					= "";
		String med_ser_grp_code		= "";
		String nationality			= "";
		String nat_id_prompt		= "";
		String contact_email		= "";
		String postal_code			= "";
		String country_code			= "";
		String addr_line_1			= "";
		String addr_line_2			= "";
		String addr_line_3			= "";
		String addr_line_4			= "";										  
		StringBuffer contact_vals	= new StringBuffer();
		String booking_date_time	= "";
		String booking_status		= "";
		int valid_booking			= 0;
		String medteamdesc			= "";
		String turn_down_reason		= ""; 
		String calling_func			= "";
		String ALT_ID1_TYPE_SHORT_DESC ="";
		String bkg_type				= "";
		String pref_adm_date_desc_converted = "";
		String bl_operational		= "";
		String proc_surg_date		= "";
		String pre_op_days			= "";
		String booking_reason		= "";
		String revision_reason		= "";
		String booking_remarks		= "";
		String contact_reason		= "";
		String booking_type_desc	= "";
		String DAYS					= "";
		String MONTHS				= "";
		String AGE					= "";
		String override_yn			= "N";
		//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
		//Start
		String surgery_order="";
		String surgery_date="";
		//End
		//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023
		String smartCardFunc ="";
		String biometric_reason="";
		//Ends
		
		//Below line added for this ML-MMOH-CRF-0860.2
		Boolean increasedaddressLength = false;	

		Boolean isReviseBkgAftrConfrmAppl = false; //Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
					
			try
			{
			con = ConnectionManager.getConnection(request);
			//Maheshwaran K added for AAKH-CRF-0175 as on 23-08-2023	
			smartCardFunc	= isSiteSpecificforBiometric(con);
			if(smartCardFunc.equals("01")) {
			biometric_reason = (String) session.getValue( "biometric_reason" ) ;
			
			session.removeAttribute("biometric_reason");
			}
			//Ends	
			//added for ML-MMOH-CRF-0860.2
			increasedaddressLength = eCommon.Common.CommonBean.isSiteSpecific(con, "MP","INCREASED_ADDRESS_LINE_LENGTH");

			isReviseBkgAftrConfrmAppl = eCommon.Common.CommonBean.isSiteSpecific(con, "IP","REVISE_BKG_AFTR_CONFIRM");//Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622
						
			bl_operational		= (String)session.getValue("bl_operational");

			calling_func		= request.getParameter("call_function");			

			if(calling_func == null || calling_func.equals("null")) calling_func = "";
			bkg_type	= request.getParameter("bkg_type");
			if(bkg_type == null || bkg_type.equals("null")) bkg_type = "";
			StringBuffer sql = new StringBuffer();
			/*Monday, April 26, 2010 , commented for PE , getting these values from AmendBookingLookup.jsp*/
			/*
			sql.append("select bl_interfaced_yn,capture_fin_dtls_yn from ip_param where facility_id='"+facility_id+"'"); 

			stmt	=	con.createStatement();
			rs		=	stmt.executeQuery(sql.toString());
			
			if( rs.next())
			{
				bl_interfaced_yn			= checkForNull(rs.getString("BL_INTERFACED_YN"));
				capture_fin_dtls_yn			= checkForNull(rs.getString("CAPTURE_FIN_DTLS_YN"));
			}			
			if (rs != null) rs.close();
			if (stmt != null) stmt.close();
			*/
						
			if(bkg_type.equals("D"))
			{
				if(sql.length() > 0) sql.delete(0,sql.length());

				sql.append("SELECT" );
				sql.append("  a.appt_time" );
				sql.append("  , TO_CHAR(a.appt_time,'DD/MM/rrrr HH24:MI Day ') pref_adm_date_desc" );
				sql.append("  , a.appt_ref_no bkg_lst_ref_no" );
				sql.append("  , a.patient_id" );
				sql.append("  , decode('"+locale+"','en',A.patient_name, nvl(A.patient_name_loc_lang, A.patient_name))patient_name" );
				sql.append("  , a.national_id_no" );
				sql.append("  , a.alt_id1_no" );
				sql.append("  , mp_get_desc.mp_alternate_id_type(a.alt_id1_type, '"+locale+"', 1) alt_id1_type_short_desc " );
				sql.append("  , a.gender" );
				sql.append("  , get_age(a.date_of_birth)age" );
				sql.append("  , TO_CHAR(a.date_of_birth,'dd/mm/rrrr') date_of_birth" );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , calculate_age(TO_CHAR(a.date_of_birth,'dd/mm/rrrr'),1) Years" );
				sql.append("  , calculate_age(TO_CHAR(a.date_of_birth,'dd/mm/rrrr'),2) Months" );
				sql.append("  , calculate_age(TO_CHAR(a.date_of_birth,'dd/mm/rrrr'),3) Days" );
				/**/
				sql.append("  , a.res_tel_no" );
				sql.append("  , a.oth_contact_no" );
				sql.append("  , a.email_id contact_email" );
				sql.append("  , a.res_addr_line1" );
				sql.append("  , a.res_addr_line2" );
				sql.append("  , a.res_addr_line3" );
				sql.append("  , a.res_addr_line4" );
				sql.append("  , a.postal_code" );
				sql.append("  , a.country_code" );
				sql.append("  , a.practitioner_id" );
				sql.append("  , am_get_desc.am_practitioner(a.practitioner_id, '"+locale+"', 1) practitioner_name" );
				sql.append("  , b.speciality_code specialty_code" );
				sql.append("  , am_get_desc.am_speciality(b.speciality_code, '"+locale+"', 2) specialty_short_desc" );
				sql.append("  , mp_get_desc.mp_country(a.country_code, '"+locale+"', 1) nationality_long_desc" );
				sql.append("  , am_get_desc.am_medical_team(a.facility_id, a.team_id, '"+locale+"', 2) team_short_desc" );
				sql.append("  , TO_CHAR(a.appt_time,'dd/mm/rrrr hh24:mi') booking_date_time" );
				sql.append("  , a.appt_status booking_status" );
				sql.append("  , substr(a.email_id,1,24)|| '\n'||substr(a.email_id,25,50) email_id" );
				sql.append("  , mp_get_desc.mp_birth_place(a.birth_place_code, '"+locale+"', 1) birth_place_desc" );
				sql.append("  , a.citizen_yn" );
				sql.append("  , mp_get_desc.mp_ethnic_group(a.ethnic_group_code, '"+locale+"', 1) ethnic_group_desc" );
				sql.append("  , a.legal_yn legal_illegal_yn" );
				sql.append("  , mp_get_desc.mp_race(a.race_code, '"+locale+"', 1) race_desc" );
				sql.append("  , am_get_desc.am_service(b.service_code, '"+locale+"', 2) service_short_desc" );
				sql.append("  , (" );
				sql.append("  SELECT" );
				sql.append("    nat_id_prompt " );
				sql.append("  FROM" );
				sql.append("    mp_param " );
				sql.append("  WHERE module_id ='MP'" );
				sql.append("  ) nat_id_prompt " );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , (SELECT SIGN((TO_DATE(TO_CHAR(a.appt_time,'dd/mm/rrrr hh24:mi'),'dd/mm/rrrr hh24:mi')+NVL(bkg_grace_period,0) - sysdate))valid_flag FROM ip_param WHERE facility_id='"+facility_id+"') valid_flag ");
				/**/
				sql.append("FROM" );
				sql.append("  oa_appt a" );
				sql.append("  , op_clinic b " );
				sql.append("WHERE a.facility_id = '"+facility_id+"' " );
				sql.append("  AND a.appt_ref_no = '"+bookingRefNo+"' " );
				sql.append("  AND a.facility_id = b.facility_id " );
				sql.append("  AND a.clinic_code = b.clinic_code " );
			}
			else
			{
				if(sql.length() > 0) sql.delete(0,sql.length());
				sql.append(" SELECT" );
				sql.append(" preferred_date" );
				sql.append("  , TO_CHAR(preferred_date,'DD/MM/rrrr HH24:MI Day ') pref_adm_date_desc" );
				sql.append("  , ip_get_desc.ip_medical_service_group (facility_id, med_ser_grp_code, '"+locale+"', 2) med_ser_short_desc" );
				sql.append("  , bkg_lst_ref_no" );
				sql.append("  , patient_id" );
				sql.append("  , decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name))patient_name" );
				sql.append("  , national_id_no" );
				sql.append("  , alt_id1_no" );
				sql.append("  , mp_get_desc.mp_alternate_id_type(alt_id1_type, '"+locale+"', 1) alt_id1_type_short_desc" );
				sql.append("  , gender" );
				sql.append("  , get_age(date_of_birth)age " );
				sql.append("  , TO_CHAR(date_of_birth,'dd/mm/rrrr') date_of_birth" );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),1) Years" );
				sql.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),2) Months" );
				sql.append("  , calculate_age(TO_CHAR(date_of_birth,'dd/mm/rrrr'),3) Days" );
				/**/
				sql.append("  , res_tel_no" );
				sql.append("  , oth_contact_no" );
				sql.append("  , email_id contact_email" );
				sql.append("  , res_addr_line1" );
				sql.append("  , res_addr_line2" );
				sql.append("  , res_addr_line3" );
				sql.append("  , res_addr_line4" );
				sql.append("  , postal_code" );
				sql.append("  , country_code" );
				sql.append("  , practitioner_id" );
				sql.append("  , am_get_desc.am_practitioner(practitioner_id, '"+locale+"', 1) practitioner_name" );
				sql.append("  , specialty_code" );
				sql.append("  , am_get_desc.am_speciality(specialty_code, '"+locale+"', 2) specialty_short_desc" );
				sql.append("  , nursing_unit_code" );
				sql.append("  , ip_get_desc.ip_nursing_unit(facility_id, nursing_unit_code, '"+locale+"', 2) nursing_unit_short_desc" );
				sql.append("  , room_no" );
				sql.append("  , bed_no" );
				sql.append("  , med_ser_grp_code" );
				sql.append("  , turn_down_reason" );
				sql.append("  , mp_get_desc.mp_country(nationality_code, '"+locale+"', 1) nationality_long_desc" );
				sql.append("  , am_get_desc.am_medical_team(facility_id, team_id, '"+locale+"', 2) team_short_desc" );
				sql.append("  , TO_CHAR(booking_date_time,'dd/mm/rrrr hh24:mi') booking_date_time" );
				sql.append("  , booking_status" );
				sql.append("  , substr(email_id,1,24)|| '\n'||substr(email_id,25,50) email_id" );
				sql.append("  , ip_get_desc.IP_BED_CLASS(bed_class_code, '"+locale+"', 2) bed_class_short_desc" );
				sql.append("  , ip_get_desc.IP_BED_TYPE(bed_type_code,'"+locale+"','2') bed_type_short_desc ");
				sql.append("  , mp_get_desc.mp_birth_place(birth_place_code, '"+locale+"', 1) birth_place_desc" );
				sql.append("  , citizen_yn" );
				sql.append("  , mp_get_desc.mp_ethnic_group(ethnic_grp_code, '"+locale+"', 1) ethnic_group_desc" );
				sql.append("  , legal_illegal_yn" );
				//sql.append("  , ot_date_time" );
				sql.append("  , TO_CHAR(ot_date_time,'dd/mm/rrrr hh24:mi') ot_date_time" );
				sql.append("  , patient_type_code" );
				sql.append("  , mp_get_desc.mp_race(race_code, '"+locale+"', 1) race_desc" );
				sql.append("  , am_get_desc.am_service(service_code, '"+locale+"', 2) service_short_desc" );
				sql.append("  , exp_days_of_stay" );
				sql.append("  , TO_CHAR(expected_discharge_date,'dd/mm/rrrr hh24:mi') expected_discharge_date" );
				sql.append("  ,round(ot_date_time-preferred_date) pre_op_days ");
				sql.append("  , (" );
				sql.append("  SELECT" );
				sql.append("    nat_id_prompt ");
				sql.append("  FROM" );
				sql.append("    MP_PARAM ");
				sql.append("  WHERE module_id ='MP' ");
				sql.append("  ) nat_id_prompt ");
				sql.append("  , am_get_desc.am_complaint (chief_complaint,'"+locale+"', '1'  ) booking_reason " );
				sql.append("  , am_get_desc.am_contact_reason (reason_for_revision_code,'"+locale+"', '1'  ) revision_reason" );
				sql.append("  ,am_get_desc.am_contact_reason(decode(booking_status,'9',CANCEL_REASON_CODE),'"+locale+"',1)contact_reason" );
				sql.append("  , diagnosis_remarks booking_remarks" );
				sql.append("  , ip_get_desc.ip_booking_type(booking_type_code,'"+locale+"','2') booking_type_desc" );
				sql.append("  , diagnosis_remarks booking_remarks" );
				sql.append("  , override_yn " );
				/*Monday, April 26, 2010 , added for PE*/
				sql.append("  , (SELECT SIGN((TO_DATE(TO_CHAR(booking_date_time,'dd/mm/rrrr hh24:mi'),'dd/mm/rrrr hh24:mi')+NVL(bkg_grace_period,0)- sysdate))valid_flag FROM ip_param WHERE facility_id='"+facility_id+"') valid_flag ");
				/**/
				//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
				//Start 
				sql.append("  ,oper_short_desc surgery_order,TO_CHAR(pref_surg_date,'DD/MM/YYYY') surgery_date");
				//End
				sql.append(" FROM " );
				sql.append("  IP_BOOKING_LIST ");
				sql.append(" WHERE facility_id ='"+facility_id+"' ");
				sql.append("  AND bkg_lst_ref_no='"+bookingRefNo+"' ");
			}



			stmt	=	con.createStatement();
			rs		=	stmt.executeQuery(sql.toString());
			
			if(rs!=null)
			{
				if(rs.next())
				{
					pref_adm_date_desc			= checkForNull(rs.getString("pref_adm_date_desc")); 
					if(pref_adm_date_desc!=null)
					{
						pref_adm_date_desc = pref_adm_date_desc.trim();
						int dateLength=pref_adm_date_desc.length();
						
						String pref_adm_date_time="";
						String pref_adm_day="";
						if(dateLength > 16)
						{
							 pref_adm_date_time= pref_adm_date_desc.substring(0,16).trim();
							 pref_adm_day=pref_adm_date_desc.substring(17,dateLength).trim();
							 if(!(pref_adm_day==null || pref_adm_day.equals("")))
							{
								 if(pref_adm_day.equalsIgnoreCase("Sunday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels");
								 else if(pref_adm_day.equalsIgnoreCase("Monday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels");
								 else if(pref_adm_day.equalsIgnoreCase("Tuesday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Wednesday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Thursday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Friday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels");
								else if(pref_adm_day.equalsIgnoreCase("Saturday"))
									pref_adm_day = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels");
							}
						}
						
						if(!(pref_adm_date_time==null || pref_adm_date_time.equals("")))
							pref_adm_date_desc_converted = DateUtils.convertDate(pref_adm_date_time,"DMYHM","en",locale);
						pref_adm_date_desc_converted = pref_adm_date_desc_converted+" "+pref_adm_day;
					}


					bkg_lst_ref_no				= checkForNull(rs.getString("bkg_lst_ref_no"));  
					nursing_unit = checkForNull(rs.getString("nursing_unit_code"));// Included for the CRF - RUT-CRF013 - 23396 
					patient_id					= checkForNull(rs.getString("patient_id"));        
					patient_name				= checkForNull(rs.getString("patient_name"));    
					national_id_no				= checkForNull(rs.getString("national_id_no"));   
					alt_id1_no					= checkForNull(rs.getString("alt_id1_no"));
					ALT_ID1_TYPE_SHORT_DESC		= checkForNull(rs.getString("alt_id1_type_short_desc"));
					gender						= checkForNull(rs.getString("gender"));      
					if (gender.equals("M"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					else if (gender.equals("F"))
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					else 
						gender = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");

					date_of_birth				= checkForNull(rs.getString("date_of_birth")); 
					if(!date_of_birth.equals(""))
						date_of_birth			= DateUtils.convertDate(date_of_birth,"DMY","en",locale); 
					/*Monday, April 26, 2010 , added for PE*/
					AGE							= checkForNull(rs.getString("Years"));
					MONTHS						= checkForNull(rs.getString("Months"));
					DAYS						= checkForNull(rs.getString("Days"));
					valid_booking				= rs.getInt("valid_flag");
					/**/
					res_tel_no					= checkForNull(rs.getString("res_tel_no"));
					oth_contact_no				= checkForNull(rs.getString("oth_contact_no")); 
					email_id					= checkForNull(rs.getString("email_id"));  
					contact_email				= checkForNull(rs.getString("CONTACT_EMAIL"));
					postal_code					= checkForNull(rs.getString("POSTAL_CODE"));
					country_code				= checkForNull(rs.getString("COUNTRY_CODE"));
					addr_line_1					= checkForNull(rs.getString("RES_ADDR_LINE1"));
					addr_line_2					= checkForNull(rs.getString("RES_ADDR_LINE2"));
					addr_line_3					= checkForNull(rs.getString("RES_ADDR_LINE3"));
					addr_line_4					= checkForNull(rs.getString("RES_ADDR_LINE4"));
					practitioner_name			= checkForNull(rs.getString("practitioner_name"));
 					specialty_short_desc		= checkForNull(rs.getString("specialty_short_desc"));
					if(!bkg_type.equals("D"))
					{
						med_ser_short_desc		= checkForNull(rs.getString("med_ser_short_desc"));
						nursing_unit_short_desc	= checkForNull(rs.getString("nursing_unit_short_desc"));
						room_no					= checkForNull(rs.getString("room_no"));     
						bed_no					= checkForNull(rs.getString("bed_no")); 
						med_ser_grp_code		= checkForNull(rs.getString("med_ser_grp_code"));
						turn_down_reason		= checkForNull(rs.getString("turn_down_reason"));
						bed_class_desc			= checkForNull(rs.getString("bed_class_short_desc"));
						bed_type_short_desc		= checkForNull(rs.getString("bed_type_short_desc"));
						proc_surg_date			= checkForNull(rs.getString("ot_date_time"));
						if(!proc_surg_date.equals(""))
							proc_surg_date		= DateUtils.convertDate(proc_surg_date,"DMYHM","en",locale); 

						pre_op_days				= checkForNull(rs.getString("pre_op_days"));			
						if(pre_op_days==null || pre_op_days.equals(""))
							pre_op_days = "0";
				
					}
					exp_days_of_stay		= checkForNull(rs.getString("exp_days_of_stay"));
					expected_discharge_date	= checkForNull(rs.getString("expected_discharge_date"));
					if(!expected_discharge_date.equals(""))
						expected_discharge_date		= DateUtils.convertDate(expected_discharge_date,"DMYHM","en",locale); 
					age							= checkForNull(rs.getString("age"));				
					nationality					= checkForNull(rs.getString("nationality_long_desc"));
					medteamdesc					= checkForNull(rs.getString("team_short_desc"));
					
					booking_date_time			= checkForNull(rs.getString("booking_date_time"));
					if(!booking_date_time.equals(""))
						booking_date_time		= DateUtils.convertDate(booking_date_time,"DMYHM","en",locale); 

					booking_status				= checkForNull(rs.getString("booking_status"));
					
					birth_place_desc			= checkForNull(rs.getString("birth_place_desc"));
					citizen_yn					= checkForNull(rs.getString("citizen_yn"));
					ethnic_grp_desc				= checkForNull(rs.getString("ethnic_group_desc"));
					legal_yn					= checkForNull(rs.getString("legal_illegal_yn"));
					race_desc					= checkForNull(rs.getString("race_desc"));
					nat_id_prompt				= checkForNull(rs.getString("nat_id_prompt"));
					booking_reason				= checkForNull(rs.getString("booking_reason"));
					revision_reason				= checkForNull(rs.getString("revision_reason"));
					booking_remarks				= checkForNull(rs.getString("booking_remarks"));
					contact_reason				= checkForNull(rs.getString("contact_reason"));
					booking_type_desc			= checkForNull(rs.getString("booking_type_desc"));
					override_yn					= checkForNull(rs.getString("override_yn"),"N");
					//Maheshwaran K added for the CRF : RUT-CRF-0012 (23395	) as on 28/01/2013
					//Start
					surgery_order					= checkForNull(rs.getString("surgery_order"),"");
					surgery_date = checkForNull(com.ehis.util.DateUtils.convertDate(rs.getString("surgery_date"),"DMY","en",locale));	
					//End
						
									
					if(legal_yn.equals("Y")) 
						legal_yn = "Legal";
					else
						legal_yn = "Illegal";
					if(citizen_yn.equals("Y")) 
						citizen_yn = "Citizen";
					else
						citizen_yn = "Non-Citizen";
					contact_vals.append(res_tel_no+"||");
					contact_vals.append(oth_contact_no+"||");
					contact_vals.append(contact_email+"||");
					contact_vals.append(postal_code+"||");
					contact_vals.append(country_code+"||");
					contact_vals.append(addr_line_1+"||");
					contact_vals.append(addr_line_2+"||");
					contact_vals.append(addr_line_3+"||");
					contact_vals.append(addr_line_4);
				}
			}	
		
		if (rs != null) rs.close();
		if (stmt != null) stmt.close();
//out.println("<script>alert(\"booking_remarks : "+booking_remarks.length()+"\");</script>");	
		/*Monday, April 26, 2010 commented for for PE and added in main query*/
		/*
		StringBuffer Check_val = new StringBuffer();
		Check_val.append("SELECT SIGN((TO_DATE('");
		Check_val.append(booking_date_time);
		Check_val.append("','dd/mm/rrrr hh24:mi')+NVL(bkg_grace_period,0)- sysdate))");
		Check_val.append(" valid_flag FROM ip_param WHERE facility_id='");
		Check_val.append(facility_id);
		Check_val.append("'");
		stmt = con.createStatement();		
		rs = stmt.executeQuery(Check_val.toString());
		if(rs != null)
		{
			while(rs.next())
			{
				 valid_booking = rs.getInt("valid_flag");
			}
		}
		if (rs != null) rs.close();
		//if (stmt != null) stmt.close(); 
		
		String DAYS,MONTHS,AGE;
		String age_sql = "select calculate_age('"+date_of_birth+"',1) from dual";
		rs = stmt.executeQuery(age_sql);
		rs.next();
		AGE = rs.getString(1);
		if (rs != null) rs.close();

		String MONTHS_sql = "select calculate_age('"+date_of_birth+"',2) from dual";
				
		rs = stmt.executeQuery(MONTHS_sql);
		rs.next();
		MONTHS = rs.getString(1);
		if (rs != null) rs.close();

		String DAYS_sql = "select calculate_age('"+date_of_birth+"',3) from dual";
				
		rs = stmt.executeQuery(DAYS_sql);
		rs.next();
		DAYS = rs.getString(1);
//out.println("AGE"+AGE);
//out.println("MONTHS"+MONTHS);
//out.println("DAYS"+DAYS);
		if (rs != null) rs.close();
		if (stmt != null) stmt.close(); 
		*/
		

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(proc_surg_date));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(pre_op_days));
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(pref_adm_date_desc_converted));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(med_ser_short_desc));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(med_ser_grp_code));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(exp_days_of_stay));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(expected_discharge_date));
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(booking_date_time));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bkg_lst_ref_no));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(bkg_lst_ref_no));
            _bw.write(_wl_block30Bytes, _wl_block30);
 if(!calling_func.equals("CB")){
		
            _bw.write(_wl_block31Bytes, _wl_block31);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if(booking_reason != null && !booking_reason.equals("")) {
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(booking_reason));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(revision_reason));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block32Bytes, _wl_block32);
if(booking_remarks != null && !booking_remarks.equals("")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(booking_remarks));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(booking_type_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
}  if(calling_func.equals("CB")) {
			 if(booking_status.equals("9")) {
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(contact_reason));
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(booking_type_desc));
            _bw.write(_wl_block43Bytes, _wl_block43);
} else  if(booking_status.equals("1")) { 
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(booking_reason));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(revision_reason));
            _bw.write(_wl_block51Bytes, _wl_block51);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block52Bytes, _wl_block52);
if(booking_remarks != null) {
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(booking_remarks));
            _bw.write(_wl_block54Bytes, _wl_block54);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block55Bytes, _wl_block55);
}
            _bw.write(_wl_block56Bytes, _wl_block56);
if(booking_remarks != null && !booking_remarks.equals("")) {
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(booking_remarks));
            _bw.write(_wl_block34Bytes, _wl_block34);
}else{
            _bw.write(_wl_block35Bytes, _wl_block35);
}
            _bw.write(_wl_block58Bytes, _wl_block58);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(booking_type_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
	} }
            _bw.write(_wl_block60Bytes, _wl_block60);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block61Bytes, _wl_block61);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block62Bytes, _wl_block62);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(nat_id_prompt));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(national_id_no));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(ALT_ID1_TYPE_SHORT_DESC));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(alt_id1_no));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block67Bytes, _wl_block67);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(AGE));
            _bw.write(_wl_block68Bytes, _wl_block68);
            out.print( String.valueOf(MONTHS));
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(DAYS));
            _bw.write(_wl_block70Bytes, _wl_block70);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block71Bytes, _wl_block71);
            out.print( String.valueOf(date_of_birth));
            _bw.write(_wl_block72Bytes, _wl_block72);

            if (_jsp__tag29(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf( birth_place_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag30(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(citizen_yn));
            _bw.write(_wl_block75Bytes, _wl_block75);

            if (_jsp__tag31(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(legal_yn));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag32(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(nationality));
            _bw.write(_wl_block76Bytes, _wl_block76);

            if (_jsp__tag33(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(race_desc));
            _bw.write(_wl_block73Bytes, _wl_block73);

            if (_jsp__tag34(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(ethnic_grp_desc));
            _bw.write(_wl_block64Bytes, _wl_block64);

            if (_jsp__tag35(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(res_tel_no));
            _bw.write(_wl_block77Bytes, _wl_block77);

            if (_jsp__tag36(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oth_contact_no));
            _bw.write(_wl_block78Bytes, _wl_block78);

            if (_jsp__tag37(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(email_id));
            _bw.write(_wl_block80Bytes, _wl_block80);

	if(calling_func.equals("AB")) { 
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ContactDetails.label","common_labels")));
            _bw.write(_wl_block82Bytes, _wl_block82);
 } 
            _bw.write(_wl_block83Bytes, _wl_block83);

            if (_jsp__tag38(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block84Bytes, _wl_block84);

            if (_jsp__tag39(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(nursing_unit_short_desc));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag40(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(specialty_short_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);

            if (_jsp__tag41(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag42(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(medteamdesc));
            _bw.write(_wl_block87Bytes, _wl_block87);

            if (_jsp__tag43(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block88Bytes, _wl_block88);

            if (_jsp__tag44(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(bed_class_desc));
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag45(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block89Bytes, _wl_block89);
            out.print( String.valueOf(bed_type_short_desc));
            _bw.write(_wl_block90Bytes, _wl_block90);

            if (_jsp__tag46(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block92Bytes, _wl_block92);

            if (_jsp__tag47(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(room_no));
            _bw.write(_wl_block93Bytes, _wl_block93);
if(!bed_no.equals("")){
            _bw.write(_wl_block94Bytes, _wl_block94);

            if (_jsp__tag48(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block95Bytes, _wl_block95);
if(override_yn.equals("Y"))
			{ 
            _bw.write(_wl_block96Bytes, _wl_block96);
	}
			else
			{	
            _bw.write(_wl_block97Bytes, _wl_block97);
	}	
            _bw.write(_wl_block98Bytes, _wl_block98);

            if (_jsp__tag49(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(surgery_order));
            _bw.write(_wl_block99Bytes, _wl_block99);
}
            _bw.write(_wl_block100Bytes, _wl_block100);
if(bed_no.equals("")){
            _bw.write(_wl_block101Bytes, _wl_block101);

            if (_jsp__tag50(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(surgery_order));
            _bw.write(_wl_block102Bytes, _wl_block102);

            if (_jsp__tag51(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block103Bytes, _wl_block103);
}
		
		else
			{
			
            _bw.write(_wl_block104Bytes, _wl_block104);

            if (_jsp__tag52(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(surgery_date));
            _bw.write(_wl_block105Bytes, _wl_block105);

			}
			
            _bw.write(_wl_block106Bytes, _wl_block106);

            if (_jsp__tag53(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block107Bytes, _wl_block107);

            if (_jsp__tag54(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block108Bytes, _wl_block108);

			StringBuffer  sqlreason = new StringBuffer();
			/*sqlreason.append("Select Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON_LANG_VW ");
			sqlreason.append(" where language_id='"+locale+"' and Cancel_Booking_Yn = 'Y' and Eff_Status = 'E' order by 1");*/
			if(calling.equals("") && !calling_func.equals("AB"))
			{
				sqlreason.append("Select am_get_desc.am_contact_reason(Contact_Reason_code,?,1)Contact_Reason, Contact_Reason_Code from AM_CONTACT_REASON ");
				sqlreason.append(" where Cancel_Booking_Yn = 'Y' and Eff_Status = 'E' order by 1");

				stmt2 = con.prepareStatement(sqlreason.toString());
				stmt2.setString(1,locale);
				rset2 = stmt2.executeQuery();
				if(rset2 != null)
				{
					while(rset2.next())
					{
						String CDesc = rset2.getString("Contact_Reason");
						String CCode = rset2.getString("Contact_Reason_Code"); 
            _bw.write(_wl_block109Bytes, _wl_block109);
            out.print( String.valueOf(CCode));
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(CDesc));
            _bw.write(_wl_block111Bytes, _wl_block111);
	}			
				}	
			}
            _bw.write(_wl_block112Bytes, _wl_block112);

            if (_jsp__tag55(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block113Bytes, _wl_block113);

            if (_jsp__tag56(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block114Bytes, _wl_block114);
            out.print( String.valueOf(turn_down_reason));
            _bw.write(_wl_block115Bytes, _wl_block115);

		if(calling.equals("") && !calling_func.equals("AB"))
		{
			if(!booking_status.equals("1"))
			{	
		
            _bw.write(_wl_block116Bytes, _wl_block116);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmBooking.label","common_labels")));
            _bw.write(_wl_block117Bytes, _wl_block117);

			}	
			if(!calling_func.equals("AB")) 
			{	
				/*Added by Thamizh selvi on 22nd May 2018 against ML-MMOH-CRF-0622 Start*/
				if(isReviseBkgAftrConfrmAppl){
					
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revisebooking.label","common_labels")));
            _bw.write(_wl_block119Bytes, _wl_block119);

				}else{/*End*/
					 if(!booking_status.equals("1"))
					{
						
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.revisebooking.label","common_labels")));
            _bw.write(_wl_block121Bytes, _wl_block121);

					}
				}
				
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancelBooking.label","common_labels")));
            _bw.write(_wl_block123Bytes, _wl_block123);

			}
			
		}
		
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(valid_booking));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.ConfirmCancellation.label","ip_labels")));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortCancellation.label","ip_labels")));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abort.label","common_labels")));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.TurnDown.label","ip_labels")));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block132Bytes, _wl_block132);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ConfirmRevision.label","common_labels")));
            _bw.write(_wl_block133Bytes, _wl_block133);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortRevision.label","ip_labels")));
            _bw.write(_wl_block134Bytes, _wl_block134);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block135Bytes, _wl_block135);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.AbortRevision.label","ip_labels")));
            _bw.write(_wl_block136Bytes, _wl_block136);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.close.label","common_labels")));
            _bw.write(_wl_block137Bytes, _wl_block137);
            out.print( String.valueOf(contact_vals));
            _bw.write(_wl_block138Bytes, _wl_block138);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block139Bytes, _wl_block139);
            out.print( String.valueOf(bl_operational));
            _bw.write(_wl_block140Bytes, _wl_block140);
            out.print( String.valueOf(bed_no));
            _bw.write(_wl_block141Bytes, _wl_block141);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block142Bytes, _wl_block142);
            out.print( String.valueOf(nursing_unit));
            _bw.write(_wl_block143Bytes, _wl_block143);
            out.print( String.valueOf(smartCardFunc));
            _bw.write(_wl_block144Bytes, _wl_block144);
            out.print( String.valueOf(biometric_reason));
            _bw.write(_wl_block145Bytes, _wl_block145);
            out.print( String.valueOf(increasedaddressLength));
            _bw.write(_wl_block146Bytes, _wl_block146);

	}catch(Exception e) 
	{
		//out.println("err"+e);
		e.printStackTrace();
	}
	finally
	{
		try
		{
			if (rs != null)		rs.close();
			if (stmt2 != null)	stmt2.close();
			if (stmt != null)	stmt.close();
			if (rset2 != null)	rset2.close();
			if (PrRs != null)	PrRs.close();
			if (PrStmt != null) PrStmt.close();
		}
		catch(Exception e) {out.println("err"+e);}
		ConnectionManager.returnConnection(con,request);
	}

if(revise_booking_yn.equals("Y")) {

            _bw.write(_wl_block147Bytes, _wl_block147);
 } else if	(revise_booking_yn.equals("N")) { 
            _bw.write(_wl_block148Bytes, _wl_block148);
 } if(confirm_booking_yn.equals("Y")) {
            _bw.write(_wl_block149Bytes, _wl_block149);
 } else if	(confirm_booking_yn.equals("N")) { 
            _bw.write(_wl_block150Bytes, _wl_block150);
 } if(cancel_booking_yn.equals("Y")) {
            _bw.write(_wl_block151Bytes, _wl_block151);
 } else if	(cancel_booking_yn.equals("N")) { 
            _bw.write(_wl_block152Bytes, _wl_block152);
} if(booking_status.equals("1"))
{ 
            _bw.write(_wl_block153Bytes, _wl_block153);
}
else {
            _bw.write(_wl_block154Bytes, _wl_block154);
}

	if(calling_func.equals("AT") || calling_func.equals("AB") || calling_func.equals("RCB") || calling_func.equals("Booking_Admission")) 
		out.println("<script>document.getElementById('bed_details').style.visibility='visible';</script>");
	else		
		out.println("<script>document.getElementById('bed_details').style.visibility='hidden';</script>");

            _bw.write(_wl_block155Bytes, _wl_block155);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Cancellation.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ProcedureSurgeryDateTime.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PreOpPreparationDays.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.PrefAdmDateTime.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.MedicalServiceGroup.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpdaysofStay.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ExpectedDischargeDateTime.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingDetails.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingDateTime.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BookingRefNo.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Reasonforbooking.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Reasonforrevision.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingType.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforCancellation.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingType.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Reasonforbooking.label", java.lang.String .class,"key"));
        __tag17.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.Reasonforrevision.label", java.lang.String .class,"key"));
        __tag18.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booking.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
        __tag20.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag21(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag21 = null ;
        int __result__tag21 = 0 ;

        if (__tag21 == null ){
            __tag21 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag21);
        }
        __tag21.setPageContext(pageContext);
        __tag21.setParent(null);
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.view.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag21;
        __result__tag21 = __tag21.doStartTag();

        if (__result__tag21!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag21== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag21.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag21);
            return true;
        }
        _activeTag=__tag21.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag21);
        __tag21.release();
        return false;
    }

    private boolean _jsp__tag22(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag22 = null ;
        int __result__tag22 = 0 ;

        if (__tag22 == null ){
            __tag22 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag22);
        }
        __tag22.setPageContext(pageContext);
        __tag22.setParent(null);
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BookingType.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag22;
        __result__tag22 = __tag22.doStartTag();

        if (__result__tag22!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag22== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag22.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag22);
            return true;
        }
        _activeTag=__tag22.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag22);
        __tag22.release();
        return false;
    }

    private boolean _jsp__tag23(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag23 = null ;
        int __result__tag23 = 0 ;

        if (__tag23 == null ){
            __tag23 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag23);
        }
        __tag23.setPageContext(pageContext);
        __tag23.setParent(null);
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
        __tag23.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag23;
        __result__tag23 = __tag23.doStartTag();

        if (__result__tag23!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag23== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag23.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag23);
            return true;
        }
        _activeTag=__tag23.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag23);
        __tag23.release();
        return false;
    }

    private boolean _jsp__tag24(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag24 = null ;
        int __result__tag24 = 0 ;

        if (__tag24 == null ){
            __tag24 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag24);
        }
        __tag24.setPageContext(pageContext);
        __tag24.setParent(null);
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
        __tag24.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag24;
        __result__tag24 = __tag24.doStartTag();

        if (__result__tag24!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag24== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag24.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag24);
            return true;
        }
        _activeTag=__tag24.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag24);
        __tag24.release();
        return false;
    }

    private boolean _jsp__tag25(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag25 = null ;
        int __result__tag25 = 0 ;

        if (__tag25 == null ){
            __tag25 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag25);
        }
        __tag25.setPageContext(pageContext);
        __tag25.setParent(null);
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientName.label", java.lang.String .class,"key"));
        __tag25.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag25;
        __result__tag25 = __tag25.doStartTag();

        if (__result__tag25!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag25== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag25.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag25);
            return true;
        }
        _activeTag=__tag25.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag25);
        __tag25.release();
        return false;
    }

    private boolean _jsp__tag26(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag26 = null ;
        int __result__tag26 = 0 ;

        if (__tag26 == null ){
            __tag26 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag26);
        }
        __tag26.setPageContext(pageContext);
        __tag26.setParent(null);
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.gender.label", java.lang.String .class,"key"));
        __tag26.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag26;
        __result__tag26 = __tag26.doStartTag();

        if (__result__tag26!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag26== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag26.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag26);
            return true;
        }
        _activeTag=__tag26.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag26);
        __tag26.release();
        return false;
    }

    private boolean _jsp__tag27(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag27 = null ;
        int __result__tag27 = 0 ;

        if (__tag27 == null ){
            __tag27 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag27);
        }
        __tag27.setPageContext(pageContext);
        __tag27.setParent(null);
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.age.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag27;
        __result__tag27 = __tag27.doStartTag();

        if (__result__tag27!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag27== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag27.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag27);
            return true;
        }
        _activeTag=__tag27.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag27);
        __tag27.release();
        return false;
    }

    private boolean _jsp__tag28(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag28 = null ;
        int __result__tag28 = 0 ;

        if (__tag28 == null ){
            __tag28 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag28);
        }
        __tag28.setPageContext(pageContext);
        __tag28.setParent(null);
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthDate.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag28;
        __result__tag28 = __tag28.doStartTag();

        if (__result__tag28!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag28== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag28.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag28);
            return true;
        }
        _activeTag=__tag28.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag28);
        __tag28.release();
        return false;
    }

    private boolean _jsp__tag29(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag29 = null ;
        int __result__tag29 = 0 ;

        if (__tag29 == null ){
            __tag29 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag29);
        }
        __tag29.setPageContext(pageContext);
        __tag29.setParent(null);
        __tag29.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.birthPlace.label", java.lang.String .class,"key"));
        __tag29.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag29;
        __result__tag29 = __tag29.doStartTag();

        if (__result__tag29!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag29== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag29.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag29);
            return true;
        }
        _activeTag=__tag29.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag29);
        __tag29.release();
        return false;
    }

    private boolean _jsp__tag30(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag30 = null ;
        int __result__tag30 = 0 ;

        if (__tag30 == null ){
            __tag30 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag30);
        }
        __tag30.setPageContext(pageContext);
        __tag30.setParent(null);
        __tag30.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.residency.label", java.lang.String .class,"key"));
        __tag30.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag30;
        __result__tag30 = __tag30.doStartTag();

        if (__result__tag30!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag30== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag30.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag30);
            return true;
        }
        _activeTag=__tag30.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag30);
        __tag30.release();
        return false;
    }

    private boolean _jsp__tag31(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag31 = null ;
        int __result__tag31 = 0 ;

        if (__tag31 == null ){
            __tag31 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag31);
        }
        __tag31.setPageContext(pageContext);
        __tag31.setParent(null);
        __tag31.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
        __tag31.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag31;
        __result__tag31 = __tag31.doStartTag();

        if (__result__tag31!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag31== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag31.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag31);
            return true;
        }
        _activeTag=__tag31.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag31);
        __tag31.release();
        return false;
    }

    private boolean _jsp__tag32(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag32 = null ;
        int __result__tag32 = 0 ;

        if (__tag32 == null ){
            __tag32 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag32);
        }
        __tag32.setPageContext(pageContext);
        __tag32.setParent(null);
        __tag32.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nationality.label", java.lang.String .class,"key"));
        __tag32.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag32;
        __result__tag32 = __tag32.doStartTag();

        if (__result__tag32!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag32== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag32.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag32);
            return true;
        }
        _activeTag=__tag32.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag32);
        __tag32.release();
        return false;
    }

    private boolean _jsp__tag33(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag33 = null ;
        int __result__tag33 = 0 ;

        if (__tag33 == null ){
            __tag33 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag33);
        }
        __tag33.setPageContext(pageContext);
        __tag33.setParent(null);
        __tag33.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.race.label", java.lang.String .class,"key"));
        __tag33.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag33;
        __result__tag33 = __tag33.doStartTag();

        if (__result__tag33!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag33== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag33.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag33);
            return true;
        }
        _activeTag=__tag33.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag33);
        __tag33.release();
        return false;
    }

    private boolean _jsp__tag34(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag34 = null ;
        int __result__tag34 = 0 ;

        if (__tag34 == null ){
            __tag34 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag34);
        }
        __tag34.setPageContext(pageContext);
        __tag34.setParent(null);
        __tag34.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.ethnicity.label", java.lang.String .class,"key"));
        __tag34.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag34;
        __result__tag34 = __tag34.doStartTag();

        if (__result__tag34!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag34== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag34.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag34);
            return true;
        }
        _activeTag=__tag34.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag34);
        __tag34.release();
        return false;
    }

    private boolean _jsp__tag35(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag35 = null ;
        int __result__tag35 = 0 ;

        if (__tag35 == null ){
            __tag35 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag35);
        }
        __tag35.setPageContext(pageContext);
        __tag35.setParent(null);
        __tag35.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eMP.telephoneres.label", java.lang.String .class,"key"));
        __tag35.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${mp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag35;
        __result__tag35 = __tag35.doStartTag();

        if (__result__tag35!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag35== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag35.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag35);
            return true;
        }
        _activeTag=__tag35.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag35);
        __tag35.release();
        return false;
    }

    private boolean _jsp__tag36(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag36 = null ;
        int __result__tag36 = 0 ;

        if (__tag36 == null ){
            __tag36 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag36);
        }
        __tag36.setPageContext(pageContext);
        __tag36.setParent(null);
        __tag36.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.othertelno.label", java.lang.String .class,"key"));
        __tag36.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag36;
        __result__tag36 = __tag36.doStartTag();

        if (__result__tag36!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag36== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag36.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag36);
            return true;
        }
        _activeTag=__tag36.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag36);
        __tag36.release();
        return false;
    }

    private boolean _jsp__tag37(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag37 = null ;
        int __result__tag37 = 0 ;

        if (__tag37 == null ){
            __tag37 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag37);
        }
        __tag37.setPageContext(pageContext);
        __tag37.setParent(null);
        __tag37.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.email.label", java.lang.String .class,"key"));
        __tag37.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag37;
        __result__tag37 = __tag37.doStartTag();

        if (__result__tag37!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag37== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag37.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag37);
            return true;
        }
        _activeTag=__tag37.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag37);
        __tag37.release();
        return false;
    }

    private boolean _jsp__tag38(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag38 = null ;
        int __result__tag38 = 0 ;

        if (__tag38 == null ){
            __tag38 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag38);
        }
        __tag38.setPageContext(pageContext);
        __tag38.setParent(null);
        __tag38.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NursingUnitDetails.label", java.lang.String .class,"key"));
        __tag38.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag38;
        __result__tag38 = __tag38.doStartTag();

        if (__result__tag38!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag38== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag38.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag38);
            return true;
        }
        _activeTag=__tag38.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag38);
        __tag38.release();
        return false;
    }

    private boolean _jsp__tag39(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag39 = null ;
        int __result__tag39 = 0 ;

        if (__tag39 == null ){
            __tag39 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag39);
        }
        __tag39.setPageContext(pageContext);
        __tag39.setParent(null);
        __tag39.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
        __tag39.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag39;
        __result__tag39 = __tag39.doStartTag();

        if (__result__tag39!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag39== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag39.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag39);
            return true;
        }
        _activeTag=__tag39.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag39);
        __tag39.release();
        return false;
    }

    private boolean _jsp__tag40(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag40 = null ;
        int __result__tag40 = 0 ;

        if (__tag40 == null ){
            __tag40 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag40);
        }
        __tag40.setPageContext(pageContext);
        __tag40.setParent(null);
        __tag40.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
        __tag40.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag40;
        __result__tag40 = __tag40.doStartTag();

        if (__result__tag40!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag40== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag40.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag40);
            return true;
        }
        _activeTag=__tag40.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag40);
        __tag40.release();
        return false;
    }

    private boolean _jsp__tag41(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag41 = null ;
        int __result__tag41 = 0 ;

        if (__tag41 == null ){
            __tag41 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag41);
        }
        __tag41.setPageContext(pageContext);
        __tag41.setParent(null);
        __tag41.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.AdmittingPractitioner.label", java.lang.String .class,"key"));
        __tag41.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag41;
        __result__tag41 = __tag41.doStartTag();

        if (__result__tag41!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag41== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag41.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag41);
            return true;
        }
        _activeTag=__tag41.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag41);
        __tag41.release();
        return false;
    }

    private boolean _jsp__tag42(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag42 = null ;
        int __result__tag42 = 0 ;

        if (__tag42 == null ){
            __tag42 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag42);
        }
        __tag42.setPageContext(pageContext);
        __tag42.setParent(null);
        __tag42.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.medicalteam.label", java.lang.String .class,"key"));
        __tag42.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag42;
        __result__tag42 = __tag42.doStartTag();

        if (__result__tag42!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag42== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag42.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag42);
            return true;
        }
        _activeTag=__tag42.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag42);
        __tag42.release();
        return false;
    }

    private boolean _jsp__tag43(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag43 = null ;
        int __result__tag43 = 0 ;

        if (__tag43 == null ){
            __tag43 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag43);
        }
        __tag43.setPageContext(pageContext);
        __tag43.setParent(null);
        __tag43.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.BedDetails.label", java.lang.String .class,"key"));
        __tag43.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag43;
        __result__tag43 = __tag43.doStartTag();

        if (__result__tag43!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag43== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag43.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag43);
            return true;
        }
        _activeTag=__tag43.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag43);
        __tag43.release();
        return false;
    }

    private boolean _jsp__tag44(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag44 = null ;
        int __result__tag44 = 0 ;

        if (__tag44 == null ){
            __tag44 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag44);
        }
        __tag44.setPageContext(pageContext);
        __tag44.setParent(null);
        __tag44.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.BedClass.label", java.lang.String .class,"key"));
        __tag44.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag44;
        __result__tag44 = __tag44.doStartTag();

        if (__result__tag44!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag44== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag44.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag44);
            return true;
        }
        _activeTag=__tag44.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag44);
        __tag44.release();
        return false;
    }

    private boolean _jsp__tag45(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag45 = null ;
        int __result__tag45 = 0 ;

        if (__tag45 == null ){
            __tag45 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag45);
        }
        __tag45.setPageContext(pageContext);
        __tag45.setParent(null);
        __tag45.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedtype.label", java.lang.String .class,"key"));
        __tag45.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag45;
        __result__tag45 = __tag45.doStartTag();

        if (__result__tag45!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag45== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag45.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag45);
            return true;
        }
        _activeTag=__tag45.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag45);
        __tag45.release();
        return false;
    }

    private boolean _jsp__tag46(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag46 = null ;
        int __result__tag46 = 0 ;

        if (__tag46 == null ){
            __tag46 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag46);
        }
        __tag46.setPageContext(pageContext);
        __tag46.setParent(null);
        __tag46.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.bedno.label", java.lang.String .class,"key"));
        __tag46.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag46;
        __result__tag46 = __tag46.doStartTag();

        if (__result__tag46!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag46== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag46.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag46);
            return true;
        }
        _activeTag=__tag46.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag46);
        __tag46.release();
        return false;
    }

    private boolean _jsp__tag47(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag47 = null ;
        int __result__tag47 = 0 ;

        if (__tag47 == null ){
            __tag47 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag47);
        }
        __tag47.setPageContext(pageContext);
        __tag47.setParent(null);
        __tag47.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.roomno.label", java.lang.String .class,"key"));
        __tag47.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag47;
        __result__tag47 = __tag47.doStartTag();

        if (__result__tag47!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag47== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag47.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag47);
            return true;
        }
        _activeTag=__tag47.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag47);
        __tag47.release();
        return false;
    }

    private boolean _jsp__tag48(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag48 = null ;
        int __result__tag48 = 0 ;

        if (__tag48 == null ){
            __tag48 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag48);
        }
        __tag48.setPageContext(pageContext);
        __tag48.setParent(null);
        __tag48.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.override.label", java.lang.String .class,"key"));
        __tag48.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag48;
        __result__tag48 = __tag48.doStartTag();

        if (__result__tag48!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag48== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag48.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag48);
            return true;
        }
        _activeTag=__tag48.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag48);
        __tag48.release();
        return false;
    }

    private boolean _jsp__tag49(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag49 = null ;
        int __result__tag49 = 0 ;

        if (__tag49 == null ){
            __tag49 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag49);
        }
        __tag49.setPageContext(pageContext);
        __tag49.setParent(null);
        __tag49.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryOrder.label", java.lang.String .class,"key"));
        __tag49.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag49;
        __result__tag49 = __tag49.doStartTag();

        if (__result__tag49!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag49== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag49.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag49);
            return true;
        }
        _activeTag=__tag49.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag49);
        __tag49.release();
        return false;
    }

    private boolean _jsp__tag50(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag50 = null ;
        int __result__tag50 = 0 ;

        if (__tag50 == null ){
            __tag50 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag50);
        }
        __tag50.setPageContext(pageContext);
        __tag50.setParent(null);
        __tag50.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryOrder.label", java.lang.String .class,"key"));
        __tag50.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag50;
        __result__tag50 = __tag50.doStartTag();

        if (__result__tag50!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag50== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag50.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag50);
            return true;
        }
        _activeTag=__tag50.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag50);
        __tag50.release();
        return false;
    }

    private boolean _jsp__tag51(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag51 = null ;
        int __result__tag51 = 0 ;

        if (__tag51 == null ){
            __tag51 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag51);
        }
        __tag51.setPageContext(pageContext);
        __tag51.setParent(null);
        __tag51.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryDate.label", java.lang.String .class,"key"));
        __tag51.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag51;
        __result__tag51 = __tag51.doStartTag();

        if (__result__tag51!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag51== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag51.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag51);
            return true;
        }
        _activeTag=__tag51.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag51);
        __tag51.release();
        return false;
    }

    private boolean _jsp__tag52(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag52 = null ;
        int __result__tag52 = 0 ;

        if (__tag52 == null ){
            __tag52 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag52);
        }
        __tag52.setPageContext(pageContext);
        __tag52.setParent(null);
        __tag52.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.SurgeryDate.label", java.lang.String .class,"key"));
        __tag52.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag52;
        __result__tag52 = __tag52.doStartTag();

        if (__result__tag52!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag52== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag52.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag52);
            return true;
        }
        _activeTag=__tag52.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag52);
        __tag52.release();
        return false;
    }

    private boolean _jsp__tag53(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag53 = null ;
        int __result__tag53 = 0 ;

        if (__tag53 == null ){
            __tag53 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag53);
        }
        __tag53.setPageContext(pageContext);
        __tag53.setParent(null);
        __tag53.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ReasonforCancellation.label", java.lang.String .class,"key"));
        __tag53.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag53;
        __result__tag53 = __tag53.doStartTag();

        if (__result__tag53!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag53== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag53.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag53);
            return true;
        }
        _activeTag=__tag53.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag53);
        __tag53.release();
        return false;
    }

    private boolean _jsp__tag54(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag54 = null ;
        int __result__tag54 = 0 ;

        if (__tag54 == null ){
            __tag54 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag54);
        }
        __tag54.setPageContext(pageContext);
        __tag54.setParent(null);
        __tag54.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
        __tag54.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag54;
        __result__tag54 = __tag54.doStartTag();

        if (__result__tag54!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag54== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag54.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag54);
            return true;
        }
        _activeTag=__tag54.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag54);
        __tag54.release();
        return false;
    }

    private boolean _jsp__tag55(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag55 = null ;
        int __result__tag55 = 0 ;

        if (__tag55 == null ){
            __tag55 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag55);
        }
        __tag55.setPageContext(pageContext);
        __tag55.setParent(null);
        __tag55.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eAM.PatInstructions.label", java.lang.String .class,"key"));
        __tag55.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${am_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag55;
        __result__tag55 = __tag55.doStartTag();

        if (__result__tag55!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag55== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag55.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag55);
            return true;
        }
        _activeTag=__tag55.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag55);
        __tag55.release();
        return false;
    }

    private boolean _jsp__tag56(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag56 = null ;
        int __result__tag56 = 0 ;

        if (__tag56 == null ){
            __tag56 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag56);
        }
        __tag56.setPageContext(pageContext);
        __tag56.setParent(null);
        __tag56.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eIP.ReasonforTurnDownAdmission.label", java.lang.String .class,"key"));
        __tag56.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ip_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag56;
        __result__tag56 = __tag56.doStartTag();

        if (__result__tag56!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag56== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag56.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag56);
            return true;
        }
        _activeTag=__tag56.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag56);
        __tag56.release();
        return false;
    }
}
