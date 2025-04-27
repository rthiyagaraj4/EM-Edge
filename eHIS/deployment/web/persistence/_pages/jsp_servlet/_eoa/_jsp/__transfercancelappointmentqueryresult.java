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

public final class __transfercancelappointmentqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/TransferCancelAppointmentQueryResult.jsp", 1742299607626L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n    ";
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

    private final static java.lang.String  _wl_block6 ="\n\t<HTML>\n\t<head>\n\t\t<!-- <script src=\"../../eOP/js/menu.js\" language=\"JavaScript1.2\"></script> -->\n\t\t<script src=\"../../eOA/js/QueryLocnForDay.js\"></script>\n\n\t\t ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t<script language=\'javascript\' src=\"../../eOA/js/TransferCancelAppointment.js\"></script>\n<script type=\"text/javascript\">\t\nfunction showTooltip(e,text,div,title,desc)\n{ \nif(text!=\"\"&&text==\"t2\"){\n div.style.display = \'inline\'; \n// div.style.position = \'relative\';\ndiv.style.position = \'absolute\'; \n//div.style.position = \'inside\';\n //div.style.float=\'right\';\n document.getElementById(\"t2\").style.top = e.y;\n document.getElementById(\"t2\").style.left = e.x;\n div.style.width = \'380\';\n div.style.backgroundColor = \'#CCCCFF\';  \n div.style.border = \'dashed 1px black\';\n div.style.padding = \'8px\';\n//div.innerHTML = \'<b> \' + title + \' </b><div style=\"padding-left:10; padding-right:5\">\' + desc + \'</div>\';\ndiv.innerHTML =\'<div style=\"padding-left:1; padding-right:1;\"><b>\'+title+\'</b>: \' +desc+ \'</div>\';\n }else{\n hideTooltip(div);\n }\n \n}\n \nfunction hideTooltip(div)\n{\n div.style.display = \'none\';\n}\n</script>\t\n\n\n\n\t</head>\n\t<body OnMouseDown=\'CodeArrest();\'onKeyDown = \'lockKey()\' >\n\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t<form name=\'QueryApptForPatient\' id=\'QueryApptForPatient\' action=\'../../servlet/eOA.AppointmentDetailsServlet\' method=\'post\' target=\'messageFrame\'>\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<form name=\'QueryApptForPatient\' id=\'QueryApptForPatient\' >\n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\t<!-- <script>\n\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t\t</script> -->\n\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<p align=\'right\'>\n\t\t<table border=\"0\" cellspacing=\'0\' cellpadding=\'0\'>\n\n\t\t<tr>\n\t\t<td>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" \n\t\t\t<td align =\'right\' id=\'prev\'><a href=\"../../eOA/jsp/TransferCancelAppointmentQueryResult.jsp?operation_mode=Previous&start_index=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&end_index=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="&oper_stn_id=";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="&called_for=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&practcode=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&gender=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&clinic_type=";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="&res_type=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&patientid=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&patname=";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&cliniccode=";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="&appttodate=";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="&apptfromdate=";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="&function_id=";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="&group_chk=";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</a>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><a href=\"../../eOA/jsp/TransferCancelAppointmentQueryResult.jsp?operation_mode=Next&start_index=";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\" >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</a></td>\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t<td align =\'right\' id=\'prev\'><a href=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\",\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\",\"Previous\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t<td align =\'right\' id=\'next\' style=\'visibility:hidden\'><a href=\'javascript:submitPrevNext(\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\",\"Next\")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t</tr>\n\t\t</table>\n\t</p>\n\t<table border=\"1\" width=\"100%\" cellspacing=\'0\'id=\'vv\' cellpadding=\'0\'>\n\t\t<tr>\n\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t<td class=\'COLUMNHEADER\' nowrap>&nbsp;</td>\n\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td>\n\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="</td> \n\t\t\t<td class=\'COLUMNHEADER\' nowrap>";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\n\t\t\t\t\t\n\t\t\t\t<tr>\n\t\t\t\t";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\t\n\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' nowrap><input type=\"checkbox\"  name=\'check_val";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\' id=\'check_val";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\' onclick=\"show_second(this,\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\')\" ";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 =" ></input><input type=\'hidden\' name=\'final_val";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\' id=\'final_val";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\' value=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="|";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'></input></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\n\t\t\t\t";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n\t\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="\n\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\' onMouseOver=\'hideToolTip()\' onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\',\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\',\t\'";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\',\'N\',\'";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\',\'\',\'";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\')\" nowrap>\n\t\t\t\t\t\t<a href=\"javascript:callDummy()\">";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="</a></td>\n\t\t\t\t\t\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t\t<td  class = \'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'  nowrap>";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\n\n\t\t\t\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\' onClick=\"displaydet_for_sec(\'";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\')\" nowrap> \n\t\t\t\t\t\t\t<a href=\"javascript:callDummy()\">";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="</a></td>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\n\n\t\t\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="\n\t\t\t\t\t\n\t\t\t\t\t";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\n\t\t\t\t\t<td  title = \'Forced Appointment\' class = \'OAFORCED\' onClick=\"displayToolTip(\'";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\',\'F\',\'";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="\')\" nowrap> \n\t\t\t\t\t<a href=\"javascript:callDummy()\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="</a></td>\n\t\t\t\t\t";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 ="\n\t\t\t\t<td  title = \'Forced Appointment\' class = \'OAFORCED\'  nowrap>";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 ="\n\t\t\t\t\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 ="\" nowrap onClick=hideToolTip()>";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 ="</td>\n\n\t\t\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t<td nowrap class=\"";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 ="\">\n\t\t\t\t\t";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 ="<a href=\"javascript:show_Reference_details(\'";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\')\">";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 ="</a>\n\t\t\t\t";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="&nbsp;</td>\n\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="                \n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\" nowrap onClick=hideToolTip() style=\"background-color:";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 =";cursor:pointer;\" onMouseOut=\"hideTooltip(t2)\" onMouseOver=\"showTooltip(event,\'";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\',t2,\'";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\')\">\n\t\t\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\" nowrap onClick=hideToolTip()>\n\t\t\t\t";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\n\t\t\t\t</td>\n\t\t\t\t<td class=\"";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\" nowrap >\t";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

    private final static java.lang.String  _wl_block103 =",";
    private final static byte[]  _wl_block103Bytes = _getBytes( _wl_block103 );

    private final static java.lang.String  _wl_block104 ="</td>\n\t\t\t\t\t\n\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block104Bytes = _getBytes( _wl_block104 );

    private final static java.lang.String  _wl_block105 ="\'>";
    private final static byte[]  _wl_block105Bytes = _getBytes( _wl_block105 );

    private final static java.lang.String  _wl_block106 ="</td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block106Bytes = _getBytes( _wl_block106 );

    private final static java.lang.String  _wl_block107 ="</td>\t\t\n\t\t\t\t<td nowrap style=\"background-color:";
    private final static byte[]  _wl_block107Bytes = _getBytes( _wl_block107 );

    private final static java.lang.String  _wl_block108 =";FONT-SIZE:8pt;\">";
    private final static byte[]  _wl_block108Bytes = _getBytes( _wl_block108 );

    private final static java.lang.String  _wl_block109 ="</td> ";
    private final static byte[]  _wl_block109Bytes = _getBytes( _wl_block109 );

    private final static java.lang.String  _wl_block110 ="\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block110Bytes = _getBytes( _wl_block110 );

    private final static java.lang.String  _wl_block111 ="</td>\n\t\t\t\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block111Bytes = _getBytes( _wl_block111 );

    private final static java.lang.String  _wl_block112 ="&nbsp;</td>\n\t\t\t\t<td nowrap class=\'";
    private final static byte[]  _wl_block112Bytes = _getBytes( _wl_block112 );

    private final static java.lang.String  _wl_block113 ="&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t\t";
    private final static byte[]  _wl_block113Bytes = _getBytes( _wl_block113 );

    private final static java.lang.String  _wl_block114 ="\n\t\t<script>alert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));</script>\n\t";
    private final static byte[]  _wl_block114Bytes = _getBytes( _wl_block114 );

    private final static java.lang.String  _wl_block115 ="\n\t\t<script >\n\t\tif (document.getElementById(\"next\"))\n\t\t\tdocument.getElementById(\"next\").style.visibility=\'hidden\';\n\t\t</script>\n\t";
    private final static byte[]  _wl_block115Bytes = _getBytes( _wl_block115 );

    private final static java.lang.String  _wl_block116 ="\n\t\t<script >\n\t\tif (document.getElementById(\'next\'))\n\t\t\tdocument.getElementById(\'next\').style.visibility=\'visible\';\n\t\t</script>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n\t";
    private final static byte[]  _wl_block116Bytes = _getBytes( _wl_block116 );

    private final static java.lang.String  _wl_block117 ="  \n\t</table>\n\t<div name=\'tooltiplayer\' id=\'tooltiplayer\' style=\'position:absolute; width:20%; visibility:hidden;\' bgcolor=\'blue\'>\n\t\t<table id=\'tooltiptable\' cellpadding=0 cellspacing=0 border=\'0\' width=\'auto\' height=\'100%\' align=\'center\'>\n\t\t\t<tr><td width=\'100%\' id=\'t\'></td></tr>\n\t\t</table>\n\t</div>\t \n</center>\n\t<div style=\"display:none;float:center;\" id=\"t2\"></div>\n\n<input type=\'hidden\' name=\'canc_appt_yn\' id=\'canc_appt_yn\' value=\'";
    private final static byte[]  _wl_block117Bytes = _getBytes( _wl_block117 );

    private final static java.lang.String  _wl_block118 ="\' >\n<input type=\'hidden\' name=\'alcn_criteria\' id=\'alcn_criteria\' value=\'";
    private final static byte[]  _wl_block118Bytes = _getBytes( _wl_block118 );

    private final static java.lang.String  _wl_block119 ="\' >\n<input type=\'hidden\' name=\'cnt\' id=\'cnt\' value=\'";
    private final static byte[]  _wl_block119Bytes = _getBytes( _wl_block119 );

    private final static java.lang.String  _wl_block120 ="\' >\n<input type=\'hidden\' name=\'forced\' id=\'forced\' value=\'";
    private final static byte[]  _wl_block120Bytes = _getBytes( _wl_block120 );

    private final static java.lang.String  _wl_block121 ="\' >\n<input type=\'hidden\' name=\'reason_for_cancellation\' id=\'reason_for_cancellation\' value=\'";
    private final static byte[]  _wl_block121Bytes = _getBytes( _wl_block121 );

    private final static java.lang.String  _wl_block122 ="\' >\n<input type=\'hidden\' name=\'function1\' id=\'function1\' value=\'BulkCancel\' >\n<input type=\'hidden\' name=\'final_value\' id=\'final_value\' value=\'\'>\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\'";
    private final static byte[]  _wl_block122Bytes = _getBytes( _wl_block122 );

    private final static java.lang.String  _wl_block123 ="\'>\n<input type=\'hidden\' name=\'from_part\' id=\'from_part\' value=\'\'>\n<input type=\'hidden\' name=\'slot_appt_ctrl\' id=\'slot_appt_ctrl\' value=\'";
    private final static byte[]  _wl_block123Bytes = _getBytes( _wl_block123 );

    private final static java.lang.String  _wl_block124 ="\'>\n<input type=\'hidden\' name=\'visit_limit_rule\' id=\'visit_limit_rule\' value=\'";
    private final static byte[]  _wl_block124Bytes = _getBytes( _wl_block124 );

    private final static java.lang.String  _wl_block125 ="\'>\n<input type=\'hidden\' name=\'capture_fin_dtls_yn\' id=\'capture_fin_dtls_yn\' value=\'";
    private final static byte[]  _wl_block125Bytes = _getBytes( _wl_block125 );

    private final static java.lang.String  _wl_block126 ="\'>\n<input type=\'hidden\' name=\'override_no_of_slots_yn\' id=\'override_no_of_slots_yn\' value=\'";
    private final static byte[]  _wl_block126Bytes = _getBytes( _wl_block126 );

    private final static java.lang.String  _wl_block127 ="\'>\n<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=\'";
    private final static byte[]  _wl_block127Bytes = _getBytes( _wl_block127 );

    private final static java.lang.String  _wl_block128 ="\'>\n<input type=\'hidden\' name=\'practitioner_name\' id=\'practitioner_name\' value=\'";
    private final static byte[]  _wl_block128Bytes = _getBytes( _wl_block128 );

    private final static java.lang.String  _wl_block129 ="\'>\n<input type=\'hidden\' name=\'res_type\' id=\'res_type\' value=\'";
    private final static byte[]  _wl_block129Bytes = _getBytes( _wl_block129 );

    private final static java.lang.String  _wl_block130 ="\'>\n<input type=\'hidden\' name=\'customer_id\' id=\'customer_id\' value=\'";
    private final static byte[]  _wl_block130Bytes = _getBytes( _wl_block130 );

    private final static java.lang.String  _wl_block131 ="\'>\n<input type=\'hidden\' name=\'rule_appl_yn\' id=\'rule_appl_yn\' value=\'";
    private final static byte[]  _wl_block131Bytes = _getBytes( _wl_block131 );

    private final static java.lang.String  _wl_block132 ="\'>\n\n\n\n</form>\n</body>\n<script>\n\t\n\tif(parent.frames[1].document.forms[0].select)\n \tparent.frames[1].document.forms[0].select.disabled=false;\n\n</script>\t\n</html>\n\n";
    private final static byte[]  _wl_block132Bytes = _getBytes( _wl_block132 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
            webbeans.eCommon.RecordSet apptRecordSet= null;synchronized(session){
                apptRecordSet=(webbeans.eCommon.RecordSet)pageContext.getAttribute("apptRecordSet",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(apptRecordSet==null){
                    apptRecordSet=new webbeans.eCommon.RecordSet();
                    pageContext.setAttribute("apptRecordSet",apptRecordSet,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	HashMap	htRecord		=	null;
	String	operation_mode	=	"";
	String fac_id		= (String) session.getValue( "facility_id" ) ;
	StringBuffer sql3=new StringBuffer("") ;

	String curr_user_id	=(String) session.getValue( "login_user" ) ;
	String appt_ref_no	=   request.getParameter("appt_ref_no")== null?"":request.getParameter("appt_ref_no");
	String patientid	="";
	patientid = request.getParameter("patientid")== null?"":request.getParameter("patientid");
	String patname		=	java.net.URLDecoder.decode(request.getParameter("patientname")== null?"":request.getParameter("patientname"));
	String cliniccode	=	request.getParameter("cliniccode")== null?"":request.getParameter("cliniccode");
	String practcode	=	request.getParameter("practcode")== null?"":request.getParameter("practcode");
	String gender		=	request.getParameter("gender")== null?"":request.getParameter("gender");
	String apptfromdate	=	request.getParameter("apptfromdate")== null?"":request.getParameter("apptfromdate");
	String appttodate	=	request.getParameter("appttodate") == null?"":request.getParameter("appttodate");
	String clinic_type=	request.getParameter("clinic_type") == null?"":request.getParameter("clinic_type");
	String res_type=	request.getParameter("res_type") == null?"":request.getParameter("res_type");
	String day_of_week=	request.getParameter("day_of_week") == null?"":request.getParameter("day_of_week");
	String not_iden_pract=	request.getParameter("not_iden_pract") == null?"":request.getParameter("not_iden_pract");

	String reason_for_cancellation=	request.getParameter("reason_for_cancellation") == null?"":request.getParameter("reason_for_cancellation");
	
	String group_chk=request.getParameter("group_chk") == null?"":request.getParameter("group_chk"); //this line added for this CRF Bru-HIMS-CRF-191
	
	String called_for=request.getParameter("called_for"); 
	if(called_for==null) called_for="";
	String function_id=request.getParameter("function_id");
	if(function_id ==null)function_id="";

	String locale=(String)session.getAttribute("LOCALE");
	
	if(apptfromdate ==null)apptfromdate="";
	if(appttodate ==null)appttodate="";	
	apptfromdate=DateUtils.convertDate(apptfromdate,"DMY",locale,"en");
	appttodate=DateUtils.convertDate(appttodate,"DMY",locale,"en");




	String patientname = patname.toUpperCase();
	String alcn_criteria="";
	String order_id="";
	String select_yn="";
	String chk="";
	String dis="";
	String 	apptrefno		="";
	String 	forced_yn		="";
	String cliniccode1		="";
	String patientid1="";
	String gender1="";
	String practitionerid	="";
	String apptdate			= "";
	String overbookedyn ="";	
	String apptslabfromtime= "";
	String apptslabtotime="";
	String canc_appt_yn  =""; 
	String tfr_appt_yn="";
	String tfr_appt_across_catg_yn="";
	String resourcetype="";
	String dis_age			="";
	String appt_duration	="";
	String visit_type_short_desc="";
	String clinic_short_desc="";
	String practitioner_short_name="";
	String referral_id		="";
	String classValue	 = "";
	String appt_day1	 = "";
	String visit_type_ind	 = "";
	String team_id	 = "";
	String appt_status="";
	String carelocndesc="";
	String locnType="";
	String resourceClass="";
	String book_appt_across_catg_yn="";
	String book_appt_yn="";
	String book_appt_wo_pid_yn="";
	String obook_appt_yn="";
	String create_wait_list_yn="";
	String slot_appt_ctrl="";
	String visit_limit_rule="";
	String capture_fin_dtls_yn="";
	String override_no_of_slots_yn="";
	String clinic_name="";
	String practitioner_name="";
	String time_table_type="";
	// Added for RUT-CRF-0005 Starts
	String appt_category="";
	String speciality_code="";
	String rd_appt_yn="";
	String customer_id=(String)session.getValue("CUSTOMER_ID");
	
	// Added for RUT-CRF-0005 Ends
	//Below Line Added for this CRF [Bru-HIMS-CRF-177]
	String colour_indicator="";
			
			
	int cnt=0;	
	//PreparedStatement stmtps=null;
	String secCnt="";
	//ResultSet rsps=null;
	int		lower_limit		=	0,		upper_limit			=	0;
	int		maxDispRecord	=	0;
	if(function_id.equals(""))
	{
		maxDispRecord	=	14;
	}else
	{
		maxDispRecord	=	20;
	}

	String	start_index		=	"",		end_index			=	"";

	operation_mode	=	(request.getParameter("operation_mode")==null)	?	""		:	request.getParameter("operation_mode");
	start_index		=	(request.getParameter("start_index")==null)		?	"0"		:	request.getParameter("start_index");
	if(function_id.equals(""))
	{
	end_index		=	(request.getParameter("end_index")==null)		?	"14"	:	request.getParameter("end_index");
	}else
	{
			end_index		=	(request.getParameter("end_index")==null)		?	"20"	:	request.getParameter("end_index");
	}
	lower_limit		=	Integer.parseInt(start_index);
	upper_limit		=	Integer.parseInt(end_index);

	if (!patientname.equals(""))
	{
		patientname		= 	patientname + "%" ;
	}
	
	String group_id				= "";	
	String group_name           =""; //this line added for this CRF  Bru-HIMS-CRF-191

	Statement stmt				= null;
	ResultSet rs				= null;
	Connection conn=null;
	
	String rule_appl_yn="N";
	
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";



            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
	if(!function_id.equals("")) {
            _bw.write(_wl_block9Bytes, _wl_block9);
}else {
            _bw.write(_wl_block10Bytes, _wl_block10);
}
            _bw.write(_wl_block11Bytes, _wl_block11);

	try 
	{
		conn = ConnectionManager.getConnection(request);
		stmt	 = conn.createStatement();
		
		if (appt_ref_no ==null) appt_ref_no="";
		String oper_stn_id="";



			try
			{
			
				oper_stn_id=request.getParameter("oper_stn_id");
				if(oper_stn_id==null)	oper_stn_id	=	"";

				
					

					//String sql1 = "";
					StringBuffer sql1 = new StringBuffer();
					StringBuffer sql2 = new StringBuffer();
String sql_param="SELECT ALCN_CRITERIA,SLOT_APPT_CTRL,VISIT_LIMIT_RULE,CAPTURE_FIN_DTLS_YN,override_no_of_slots_yn,rule_appl_yn FROM oa_param where module_id='OA'";
rs 	= stmt.executeQuery(sql_param);		
if(rs !=null && rs.next())
{
		alcn_criteria=rs.getString("ALCN_CRITERIA");
		if(alcn_criteria ==null) alcn_criteria="";
		slot_appt_ctrl=rs.getString("SLOT_APPT_CTRL");
		if(slot_appt_ctrl ==null) slot_appt_ctrl="";
		visit_limit_rule=rs.getString("VISIT_LIMIT_RULE");
		if(visit_limit_rule ==null) visit_limit_rule="";
		capture_fin_dtls_yn=rs.getString("CAPTURE_FIN_DTLS_YN");
		if(capture_fin_dtls_yn ==null) capture_fin_dtls_yn="N";
		override_no_of_slots_yn=rs.getString("override_no_of_slots_yn");
		if(override_no_of_slots_yn ==null) override_no_of_slots_yn="";
		rule_appl_yn = rs.getString("rule_appl_yn") ==null?"N":rs.getString("rule_appl_yn");
		
}

	
 /*Below Query Modified for this incident[35078]*/	
 
	sql1=sql1.append("SELECT NVL (b.canc_appt_yn, 'N') canc_appt_yn, (select count(appt_ref_no) cntr from oa_resource_for_appt where appt_ref_no = a.appt_ref_no and FACILITY_ID=a.FACILITY_ID) CNT, team_id, NVL (b.tfr_appt_yn, 'N') tfr_appt_yn, NVL (b.tfr_appt_across_catg_yn, 'N') tfr_appt_across_catg_yn, b.BOOK_APPT_ACROSS_CATG_YN,b.BOOK_APPT_YN,b.BOOK_APPT_WO_PID_YN,b.OBOOK_APPT_YN,b.create_wait_list_yn, a.patient_id,  decode('"+locale+"','en',a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, get_age (a.date_of_birth) age, a.appt_type_code visit_type_ind, a.gender, TO_CHAR (a.appt_date, 'Day') appt_day1, a.appt_ref_no, NVL (a.forced_appt_yn, 'N') forced_appt_yn, TO_CHAR (a.appt_date, 'dd/mm/rrrr') appt_date, NVL (TO_CHAR (a.appt_slab_from_time, 'hh24:mi'),'00:00') appt_slab_from_time, NVL (TO_CHAR (a.appt_slab_to_time, 'hh24:mi'),'00:00') appt_slab_to_time, NVL (TO_CHAR (a.appt_duration, 'hh24:mi'), '00:00') appt_duration, OP_GET_DESC.OP_VISIT_TYPE(a.FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc, OP_GET_DESC.OP_CLINIC(A.FACILITY_ID, A.CLINIC_CODE,'"+locale+"','1') clinic_short_desc,	decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1'), 'R', a.practitioner_id, AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_short_name , a.clinic_code, a.practitioner_id, a.overbooked_yn, a.referral_id, a.alcn_criteria, AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id='"+fac_id+"' and CLINIC_CODE=a.clinic_code),'"+locale+"','1') care_locn_type_desc, a.care_locn_type_ind,  a.resource_class resource_class_desc, a.resource_class,a.ORDER_ID,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(a.practitioner_id,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2'),'O', AM_GET_DESC.AM_RESOURCE(a.FACILITY_ID, a.practitioner_id,'"+locale+"','2'))  practitioner_name, a.time_table_type,a.appt_category,a.speciality_code,a.rd_appt_yn,COLOR_INDICATOR,a.group_id ,(select GROUP_NAME from oa_group_hdr g where g.GROUP_ID=a.GROUP_ID) group_name"); 
	
	/*Above line modified for this CRF Bru-HIMS-CRF-191*/
	
	 

if(!function_id.equals(""))
	{
		sql2 = sql2.append(",(case when order_id is not null or referral_id is not null then 'N' else 'Y' end) select_yn");
	}


	sql2 =sql2.append(" FROM oa_appt a, am_os_user_locn_access_vw b, op_visit_type c WHERE a.facility_id = '"+fac_id+"' and a.facility_id = b.facility_id and b.locn_type !='N' AND a.clinic_code = b.locn_code AND b.oper_stn_id = '"+oper_stn_id+"' AND b.appl_user_id = '"+curr_user_id+"' AND a.appt_date BETWEEN TO_DATE (nvl('"+apptfromdate+"','01/01/1400'),'dd/mm/yyyy') AND TO_DATE (nvl('"+appttodate+"','31/12/5000'), 'dd/mm/yyyy') AND TO_DATE (TO_CHAR (a.appt_date, 'dd/mm/yyyy') || ' '|| TO_CHAR (a.appt_time, 'hh24:mi'),'dd/mm/yyyy hh24:mi') >=TO_DATE (TO_CHAR (SYSDATE, 'dd/mm/yyyy hh24:mi'), 'dd/mm/yyyy hh24:mi') AND appt_status != 'A'");

	 //Above Line Added "op_visit_type" table for this [Bru-HIMS-CRF-177]
	
		if(!patientid.equals(""))
		{
			sql2 = sql2.append("AND a.patient_id = '"+patientid+"'");
		}
		if(!patientname.equals(""))
		{
			sql2 = sql2.append("AND UPPER(a.patient_name) like  ('%"+patientname+"%')");
		}	if(!gender.equals(""))
		{
			sql2 = sql2.append("AND a.gender  = '"+gender+"'");
		}	if(!cliniccode.equals(""))
		{
			sql2 = sql2.append("AND a.clinic_code = '"+cliniccode+"'");
		}	
		if(!not_iden_pract.equals("Y"))
		{
		if(!practcode.equals(""))
		{
			sql2 = sql2.append("AND a.practitioner_id = '"+practcode+"'");
		}
		}else
		{
			//sql2 = sql2.append("and nvl(practitioner_id,'X') = nvl('','X')");
			//Wednesday, December 15, 2010
			sql2 = sql2.append("and a.practitioner_id is null");
		}
		if(!appt_ref_no.equals(""))
		{
			sql2 = sql2.append("AND a.appt_ref_no = '"+appt_ref_no+"'");
		}
		
		
					if(!called_for.equals("")){
						sql2 = sql2.append(" and a.RECUR_WO_SEC_RES='Y'");
					}

					if(!clinic_type.equals("")){
						sql2 = sql2.append(" and a.care_locn_type_ind='"+clinic_type+"'");
					}

					if(!res_type.equals("")){
						sql2 = sql2.append(" and a.resource_class='"+res_type+"' ");
					}

					if(!apptfromdate.equals("")){
						sql2 = sql2.append(" and trunc(to_date('"+apptfromdate+"','dd/mm/yyyy')) >= trunc(sysdate) ");
					}

					if(!day_of_week.equals(""))
				{
						sql2 = sql2.append("AND To_Char(a.appt_date,'DY') = Upper('"+day_of_week+"')");
					}
                     
sql2= sql2.append("and a.facility_id = c.facility_id and a.appt_type_code =c.VISIT_TYPE_CODE"); 
// Above line Added for this CRF[Bru-HIMS-CRF-177]
				 
					sql2= sql2.append( " order by a.appt_date,a.appt_slab_from_time, to_number(a.appt_ref_no)") ;

					
					if (rs!=null) rs.close();
			

						sql3.append(sql1.toString());
						sql3.append(sql2.toString());	

			
						rs 	= stmt.executeQuery(sql3.toString());
						sql2.setLength(0);
						sql3.setLength(0);
						apptRecordSet.clearAll();
						
					while ( rs != null && rs.next() )
					{
						
						htRecord		= new HashMap();
						try
						{

							tfr_appt_yn				=rs.getString("tfr_appt_yn");	
							rd_appt_yn				=rs.getString("rd_appt_yn")==null?"N":rs.getString("rd_appt_yn");	
							secCnt					=rs.getString("CNT");
							tfr_appt_across_catg_yn	=rs.getString("tfr_appt_across_catg_yn");	
							canc_appt_yn			=rs.getString("canc_appt_yn");	
							apptrefno				=rs.getString("appt_ref_no")	;
							forced_yn				=rs.getString("FORCED_APPT_YN")	;
							cliniccode1				=rs.getString("clinic_code"); 
							practitionerid			=rs.getString("practitioner_id"); 
							if(practitionerid==null) practitionerid="";
							apptdate				=rs.getString("appt_date"); 
							overbookedyn 			=rs.getString("overbooked_yn");   
							team_id 				=rs.getString("team_id");
							carelocndesc			=rs.getString("CARE_LOCN_TYPE_DESC") ;
							resourcetype			=rs.getString("resource_class_desc");
							if(resourcetype==null) resourcetype="";
							locnType = rs.getString("care_locn_type_ind");
							resourceClass=rs.getString("resource_class");
							
							if(resourcetype.equals("P"))
			{
			resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
			 }
			 else if(resourcetype.equals("E"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels");
			  }
			  else if(resourcetype.equals("R"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels");
			}
			else if(resourcetype.equals("O"))
			{
				resourcetype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels");
			}
						}
						catch(Exception e)
						{
							e.printStackTrace();
						}
					
						team_id				= rs.getString("team_id")== null?"":rs.getString("team_id");
						patientid1				=rs.getString("patient_id")== null?"":rs.getString("patient_id");
						patname					=rs.getString("patient_name")== null?"":rs.getString("patient_name");
						
						dis_age					=rs.getString("age")== null?"":rs.getString("age");
						gender1					=rs.getString("gender")== null?"":rs.getString("gender");
						apptslabfromtime		=rs.getString("appt_slab_from_time")== null?"":rs.getString("appt_slab_from_time");
						apptslabtotime			=rs.getString("appt_slab_to_time")== null?"":rs.getString("appt_slab_to_time");
						appt_duration			=rs.getString("appt_duration")== null?"":rs.getString("appt_duration");
						visit_type_short_desc	=rs.getString("visit_type_short_desc")== null?"":rs.getString("visit_type_short_desc");
						clinic_short_desc		=rs.getString("clinic_short_desc")== null?"":rs.getString("clinic_short_desc");
						practitioner_short_name	=rs.getString("practitioner_short_name")== null?"":rs.getString("practitioner_short_name");
						referral_id				=rs.getString("referral_id")== null?"":rs.getString("referral_id");
						alcn_criteria				=rs.getString("alcn_criteria")== null?"":rs.getString("alcn_criteria");
						appt_day1				=rs.getString("appt_day1")== null?"":rs.getString("appt_day1");
						visit_type_ind			=rs.getString("visit_type_ind")== null?"":rs.getString("visit_type_ind");
						 book_appt_across_catg_yn=rs.getString("book_appt_across_catg_yn")== null?"N":rs.getString("book_appt_across_catg_yn");
						 book_appt_yn=rs.getString("book_appt_yn")== null?"N":rs.getString("book_appt_yn");
						 book_appt_wo_pid_yn=rs.getString("book_appt_wo_pid_yn")== null?"N":rs.getString("book_appt_wo_pid_yn");
						 obook_appt_yn=rs.getString("obook_appt_yn")== null?"N":rs.getString("obook_appt_yn");
						 create_wait_list_yn=rs.getString("create_wait_list_yn")== null?"N":rs.getString("create_wait_list_yn");
						order_id				=rs.getString("order_id")== null?"":rs.getString("order_id");
						clinic_name				=rs.getString("clinic_name")== null?"":rs.getString("clinic_name");
						practitioner_name				=rs.getString("practitioner_name")== null?"":rs.getString("practitioner_name");
						time_table_type				=rs.getString("time_table_type")== null?"":rs.getString("time_table_type");
						if(!function_id.equals(""))
						{
						select_yn				=rs.getString("select_yn")== null?"":rs.getString("select_yn");
						}
						
						if (practitionerid==null)	practitionerid	=	"";
						appt_category				=rs.getString("appt_category")== null?"":rs.getString("appt_category");
						speciality_code				=rs.getString("speciality_code")== null?"":rs.getString("speciality_code");
                       
					    /*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
				       colour_indicator=rs.getString("COLOR_INDICATOR")== null?"":rs.getString("COLOR_INDICATOR");
				  		
					   group_id				=rs.getString("group_id")==null?"":rs.getString("group_id");
					   
					   group_name				=rs.getString("group_name")==null?"":rs.getString("group_name");
						

						try
						{
				
						htRecord.put	("tfr_appt_yn",					tfr_appt_yn				);
						htRecord.put	("secCnt",					secCnt				);
						htRecord.put	("tfr_appt_across_catg_yn",		tfr_appt_across_catg_yn	);
						htRecord.put	("canc_appt_yn",				canc_appt_yn			);
						htRecord.put	("apptrefno",					apptrefno				);
						htRecord.put	("carelocndesc", carelocndesc);
						htRecord.put	("resourcetype", resourcetype);
						htRecord.put	("forced_yn",					forced_yn				);
						htRecord.put	("cliniccode1",					cliniccode1				);
						htRecord.put	("practitionerid",				practitionerid			);
						htRecord.put	("apptdate",					apptdate				);
						htRecord.put	("overbookedyn",				overbookedyn 			);
						htRecord.put	("apptslabfromtime",			apptslabfromtime		);
						htRecord.put	("apptslabtotime",				apptslabtotime			);
						htRecord.put	("patientid",					patientid1				);
						htRecord.put	("patname",						patname					);
						htRecord.put	("dis_age",						dis_age					);
						htRecord.put	("gender",						gender1					);
						htRecord.put	("appt_duration",				appt_duration			);
						htRecord.put	("visit_type_short_desc",		visit_type_short_desc	);
						htRecord.put	("clinic_short_desc",			clinic_short_desc		);
						htRecord.put	("practitioner_short_name",		practitioner_short_name	);
						htRecord.put	("referral_id",					referral_id				);
						htRecord.put	("appt_day1",					appt_day1				);
						htRecord.put	("visit_type_ind",				visit_type_ind			);
						htRecord.put	("alcn_criteria",			    alcn_criteria		);
						htRecord.put	("team_id",			    team_id		);
						htRecord.put    ("appt_status", appt_status);
						htRecord.put	("resourceClass",resourceClass);
						htRecord.put	("locnType",locnType);
						htRecord.put	("book_appt_across_catg_yn",book_appt_across_catg_yn);
						htRecord.put	("book_appt_yn",book_appt_yn);
						htRecord.put	("book_appt_wo_pid_yn",book_appt_wo_pid_yn);
						htRecord.put	("obook_appt_yn",obook_appt_yn);
						htRecord.put	("create_wait_list_yn",create_wait_list_yn);
						htRecord.put	("clinic_name",clinic_name);
						htRecord.put	("practitioner_name",practitioner_name);
						htRecord.put	("time_table_type",time_table_type);
						
						
						htRecord.put	("order_id",order_id);
						if(!function_id.equals(""))
						{
						htRecord.put	("select_yn",select_yn);
						}
						htRecord.put	("appt_category",appt_category);
						htRecord.put	("speciality_code",speciality_code);
						htRecord.put	("rd_appt_yn",rd_appt_yn);
						/*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
						htRecord.put("colour_indicator",colour_indicator);
						
								
						htRecord.put("group_id",group_id);
                        
 						htRecord.put("group_name",group_name);
						
						apptRecordSet.putObject(htRecord);


						}
					
						catch(Exception e)
						{
							e.printStackTrace();
						}
						
					}

			if (rs!=null) rs.close();	
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
int totalRecords=0;
		 totalRecords = apptRecordSet.getSize();
	
	/*	if(cnt == 0)
					{ */
					
            _bw.write(_wl_block12Bytes, _wl_block12);
	
			//		}else{
		
	
            _bw.write(_wl_block13Bytes, _wl_block13);

		int upper_limit1=0;
		upper_limit1=upper_limit;

			try
		{
			if(upper_limit>totalRecords)	upper_limit1	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit1; i++)
			{
				if(cnt==0)
				{
			if(function_id.equals(""))
					{
			if(!(lower_limit <= 1))
			{ /*Below line modified for this incident [44249]*/
		
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((lower_limit-maxDispRecord)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((upper_limit-maxDispRecord)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_for));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practcode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patname));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(DateUtils.convertDate(appttodate,"DMY","en",locale)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(DateUtils.convertDate(apptfromdate,"DMY","en",locale)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(group_chk));
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

			}

			if(upper_limit < totalRecords)
			{   /*Below line modified for this incident [44249]*/
		
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf((lower_limit+maxDispRecord)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((upper_limit+maxDispRecord)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(oper_stn_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_for));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(practcode));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(patname));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cliniccode));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(DateUtils.convertDate(appttodate,"DMY","en",locale)));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(DateUtils.convertDate(apptfromdate,"DMY","en",locale)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(group_chk));
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

			}	
		}else
		{
		if(!(lower_limit <= 1))
			{
		
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf((lower_limit-maxDispRecord)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((upper_limit-maxDispRecord)));
            _bw.write(_wl_block36Bytes, _wl_block36);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

			}

			if(upper_limit < totalRecords)
			{
		
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf((lower_limit+maxDispRecord)));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf((upper_limit+maxDispRecord)));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

			}
		}
		
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!function_id.equals("")) {
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
if(called_for.equals("")){
            _bw.write(_wl_block44Bytes, _wl_block44);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block45Bytes, _wl_block45);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block46Bytes, _wl_block46);
 }
	/*	try
		{
			if(upper_limit>totalRecords)	upper_limit	=	totalRecords;
			int rowcolor=0;

			for(int i=lower_limit; i <upper_limit; i++)
			{ */
				
				htRecord				=		(java.util.HashMap)	apptRecordSet.getObject(i);
				tfr_appt_yn				=		(String)	htRecord.get	("tfr_appt_yn");
				secCnt					=		(String)	htRecord.get	("secCnt");
				tfr_appt_across_catg_yn	=		(String)	htRecord.get	("tfr_appt_across_catg_yn");
				canc_appt_yn			=		(String)	htRecord.get	("canc_appt_yn");			
				apptrefno				=		(String)	htRecord.get	("apptrefno");	carelocndesc	        =		(String)	htRecord.get	("carelocndesc");
				resourcetype			=    (String) htRecord.get ("resourcetype");
				forced_yn				=		(String)	htRecord.get	("forced_yn");	
				
				cliniccode1				=		(String)	htRecord.get	("cliniccode1");		
				practitionerid			=		(String)	htRecord.get	("practitionerid");
				apptdate				=		(String)	htRecord.get	("apptdate");			
				appt_status             =       (String)    htRecord.get    ("appt_status");
				overbookedyn 			=		(String)	htRecord.get	("overbookedyn");		
				apptslabfromtime		=		(String)	htRecord.get	("apptslabfromtime");		
				apptslabtotime			=		(String)	htRecord.get	("apptslabtotime");
				patientid				=		(String)	htRecord.get	("patientid");		
				if(patientid==null || patientid.equals("")){
					patientid="dummy_patinetID";
				}
				resourceClass			=		(String)    htRecord.get	("resourceClass");
				locnType				=		(String)	htRecord.get	("locnType");
				if(patientid==null || patientid.equals("")) patientid="";
				patname					=		(String)	htRecord.get	("patname");
				dis_age					=		(String)	htRecord.get	("dis_age");
				if(dis_age==null || dis_age.equals("")) dis_age="&nbsp;";
				gender					=		(String)	htRecord.get	("gender");			
				appt_duration			=		(String)	htRecord.get	("appt_duration");	
				visit_type_short_desc	=		(String)	htRecord.get	("visit_type_short_desc");
				
				clinic_short_desc		=		(String)	htRecord.get	("clinic_short_desc");	
				if(clinic_short_desc==null || clinic_short_desc.equals("")) clinic_short_desc="&nbsp;";
				practitioner_short_name	=		(String)	htRecord.get	("practitioner_short_name");
				if(practitioner_short_name==null || practitioner_short_name.equals("")) practitioner_short_name="&nbsp;";
				referral_id				=		(String)	htRecord.get	("referral_id");
				if(referral_id==null || referral_id.equals("")) referral_id="";
				
				alcn_criteria				=		(String)	htRecord.get	("alcn_criteria");
				if(alcn_criteria==null || alcn_criteria.equals("")) alcn_criteria="";
				appt_day1				=		(String)	htRecord.get	("appt_day1");
				visit_type_ind				=		(String)	htRecord.get	("visit_type_ind");
				team_id				=		(String)	htRecord.get	("team_id");
				book_appt_across_catg_yn				=		(String)	htRecord.get	("book_appt_across_catg_yn");
				book_appt_yn				=		(String)	htRecord.get	("book_appt_yn");
				book_appt_wo_pid_yn				=		(String)	htRecord.get	("book_appt_wo_pid_yn");
				obook_appt_yn				=		(String)	htRecord.get	("obook_appt_yn");
				create_wait_list_yn				=		(String)	htRecord.get	("create_wait_list_yn");
			
				order_id	=		(String)	htRecord.get	("order_id");
				
				clinic_name	=		(String)	htRecord.get	("clinic_name");
				practitioner_name	=		(String)	htRecord.get	("practitioner_name");
				/*Below Line Added for this Incident [IN34988]*/
				//practitioner_name=practitioner_name.replaceAll("'","\\\\'");
				time_table_type	=		(String)	htRecord.get	("time_table_type");
				appt_category	=		(String)	htRecord.get	("appt_category");
				speciality_code	=		(String)	htRecord.get	("speciality_code");
				rd_appt_yn	=		(String)	htRecord.get	("rd_appt_yn");
				/*Below Line Added for this CRF [Bru-HIMS-CRF-177] */
				colour_indicator=(String)	htRecord.get("colour_indicator");
						
				group_id	= (String)	htRecord.get("group_id");
				
				/*Below line Added for this CRF Bru-HIMS-CRF-191*/
				group_name = (String)	htRecord.get("group_name");
				if(group_name==null || group_name.equals("")) group_name="";
				String minpat_indicator="",div_val="", disply_title="";
				if(!group_id.equals("")){
				minpat_indicator="#B2B2FF";
				div_val="t2";
				disply_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.GroupName.label","common_labels");
				}
				//End  Bru-HIMS-CRF-191*
				
				if(!function_id.equals(""))
						{
				select_yn	=		(String)	htRecord.get	("select_yn");
						}
				if(appt_day1==null || appt_day1.equals("")) appt_day1="";
				if(visit_type_ind==null || visit_type_ind.equals("")) visit_type_ind="";
				if(team_id==null || team_id.equals("")) team_id="";

												
				if ( rowcolor % 2 == 0 )
				classValue = "QRYEVEN" ;
				else
				classValue = "QRYODD" ;
				
				if(select_yn.equals("Y"))
				{
					chk="CHECKED";
					dis="";
				}else
				{
					chk="";
					dis="DISABLED";
				}
			String referral_value="C";
			String episode_type="";
				if(locnType.equals("D"))
				{
					episode_type="I";
				}else
				{
					episode_type="O";

				}
				String apptdate_display="";
				apptdate_display=DateUtils.convertDate(apptdate,"DMY","en",locale);
				
            _bw.write(_wl_block47Bytes, _wl_block47);
	if(!function_id.equals("")) {
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(i));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(i));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(chk));
            out.print( String.valueOf(dis));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(i));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(i));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(referral_value));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(episode_type));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(forced_yn));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block57Bytes, _wl_block57);
}
            _bw.write(_wl_block58Bytes, _wl_block58);
 if(forced_yn.equals("N")){ 
            _bw.write(_wl_block59Bytes, _wl_block59);
if(called_for.equals("")){
            _bw.write(_wl_block60Bytes, _wl_block60);
if(function_id.equals("")) {
						/*Below Line Modified for this Incident [IN34988]*/
										
						
            _bw.write(_wl_block61Bytes, _wl_block61);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block62Bytes, _wl_block62);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(cliniccode1));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptslabfromtime));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_day1.trim()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(resourceClass));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locnType));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(book_appt_across_catg_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(book_appt_wo_pid_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_category));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block67Bytes, _wl_block67);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block68Bytes, _wl_block68);
}else {
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
}else{
            _bw.write(_wl_block73Bytes, _wl_block73);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block74Bytes, _wl_block74);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(cliniccode1));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block64Bytes, _wl_block64);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptslabfromtime));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_day1.trim()));
            _bw.write(_wl_block65Bytes, _wl_block65);
            out.print( String.valueOf(resourceClass));
            _bw.write(_wl_block75Bytes, _wl_block75);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
 } else {
            _bw.write(_wl_block78Bytes, _wl_block78);
if(function_id.equals("")) {			
					/*Below Line Modified for this Incident [IN34988]*/
					
            _bw.write(_wl_block79Bytes, _wl_block79);
            out.print( String.valueOf(tfr_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(cliniccode1));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptslabfromtime));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_day1.trim()));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(visit_type_ind));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block80Bytes, _wl_block80);
            out.print( String.valueOf(resourceClass));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(locnType));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(book_appt_across_catg_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(book_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(book_appt_wo_pid_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(obook_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(create_wait_list_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(referral_id));
            _bw.write(_wl_block66Bytes, _wl_block66);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(appt_category));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(rd_appt_yn));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block81Bytes, _wl_block81);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block82Bytes, _wl_block82);
}else {
            _bw.write(_wl_block83Bytes, _wl_block83);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block84Bytes, _wl_block84);
 }
            _bw.write(_wl_block85Bytes, _wl_block85);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(apptdate_display));
            _bw.write(_wl_block87Bytes, _wl_block87);
String tmp_ref_no=apptrefno;
            _bw.write(_wl_block58Bytes, _wl_block58);
if(called_for.equals("")){
            _bw.write(_wl_block88Bytes, _wl_block88);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block89Bytes, _wl_block89);
if(!secCnt.equals("0")){
            _bw.write(_wl_block90Bytes, _wl_block90);
            out.print( String.valueOf(tmp_ref_no));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(fac_id));
            _bw.write(_wl_block91Bytes, _wl_block91);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block92Bytes, _wl_block92);
}
            _bw.write(_wl_block93Bytes, _wl_block93);
}  /*Below line modified for this incident [44249]*/
				if(!group_id.equals("") && !group_chk.equals("")&&group_chk.equals("TRANSFERCANCELAPPT")){
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(minpat_indicator));
            _bw.write(_wl_block96Bytes, _wl_block96);
            out.print( String.valueOf(div_val));
            _bw.write(_wl_block97Bytes, _wl_block97);
            out.print( String.valueOf(disply_title));
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(group_name));
            _bw.write(_wl_block98Bytes, _wl_block98);
}else{
            _bw.write(_wl_block99Bytes, _wl_block99);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block100Bytes, _wl_block100);
}
					if(patientid.equals("dummy_patinetID")){
						out.println("&nbsp;");
					}else{
						out.println(patientid);
					}					
				
            _bw.write(_wl_block101Bytes, _wl_block101);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block102Bytes, _wl_block102);
            out.print( String.valueOf(patname));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(gender));
            _bw.write(_wl_block103Bytes, _wl_block103);
            out.print( String.valueOf(dis_age));
            _bw.write(_wl_block104Bytes, _wl_block104);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(apptslabfromtime));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(appt_duration));
            _bw.write(_wl_block107Bytes, _wl_block107);
            out.print( String.valueOf(colour_indicator));
            _bw.write(_wl_block108Bytes, _wl_block108);
            out.print( String.valueOf(visit_type_short_desc));
            _bw.write(_wl_block109Bytes, _wl_block109);
/*Modified for this CRF [Bru-HIMS-CRF-177]*/
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(carelocndesc));
            _bw.write(_wl_block106Bytes, _wl_block106);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(clinic_short_desc));
            _bw.write(_wl_block111Bytes, _wl_block111);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(resourcetype));
            _bw.write(_wl_block71Bytes, _wl_block71);

				//String patname10 = practitioner_short_name == null?"":practitioner_short_name;
				/*Above Line commented and Below Line Added for this incident [35078]*/
				String patname10 = practitioner_name == null?"":practitioner_name;
				
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(patname10));
            _bw.write(_wl_block93Bytes, _wl_block93);

				String patname11 = referral_id== null?"":referral_id;
				
            _bw.write(_wl_block110Bytes, _wl_block110);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(patname11));
            _bw.write(_wl_block112Bytes, _wl_block112);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block105Bytes, _wl_block105);
            out.print( String.valueOf(order_id));
            _bw.write(_wl_block113Bytes, _wl_block113);

				rowcolor++;		
				cnt++;
				//htRecord.clear();
				}

		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
//	}

	if(cnt == 0)
	{
            _bw.write(_wl_block114Bytes, _wl_block114);
}
int cantchk=0;
if(function_id.equals(""))
	{
	cantchk=14;
	}else
	{
		cantchk=20;
	}
	//boolean flag = false;
	if ( cnt < cantchk  ) {
	
            _bw.write(_wl_block115Bytes, _wl_block115);
 //flag = true;
			} else {
            _bw.write(_wl_block116Bytes, _wl_block116);
}

		//if (rsps!=null) rsps.close();
		if ( rs != null ) rs.close() ;
		//if (stmtps!=null) stmtps.close();
	    if ( stmt != null ) stmt.close() ;
	}
	catch ( Exception e )
	{
		e.printStackTrace();
	}
	finally
	{   
		if(conn !=null) ConnectionManager.returnConnection(conn,request);

	}

            _bw.write(_wl_block117Bytes, _wl_block117);
            out.print( String.valueOf(canc_appt_yn));
            _bw.write(_wl_block118Bytes, _wl_block118);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block119Bytes, _wl_block119);
            out.print( String.valueOf((lower_limit+maxDispRecord)));
            _bw.write(_wl_block120Bytes, _wl_block120);
            out.print( String.valueOf(forced_yn));
            _bw.write(_wl_block121Bytes, _wl_block121);
            out.print( String.valueOf(reason_for_cancellation));
            _bw.write(_wl_block122Bytes, _wl_block122);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block123Bytes, _wl_block123);
            out.print( String.valueOf(slot_appt_ctrl));
            _bw.write(_wl_block124Bytes, _wl_block124);
            out.print( String.valueOf(visit_limit_rule));
            _bw.write(_wl_block125Bytes, _wl_block125);
            out.print( String.valueOf(capture_fin_dtls_yn));
            _bw.write(_wl_block126Bytes, _wl_block126);
            out.print( String.valueOf(override_no_of_slots_yn));
            _bw.write(_wl_block127Bytes, _wl_block127);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block128Bytes, _wl_block128);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block129Bytes, _wl_block129);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block130Bytes, _wl_block130);
            out.print( String.valueOf(customer_id));
            _bw.write(_wl_block131Bytes, _wl_block131);
            out.print( String.valueOf(rule_appl_yn));
            _bw.write(_wl_block132Bytes, _wl_block132);
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptno.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.SecondaryResources.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patientId.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PatientDetails.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.fromtime.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.totime.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.duration.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.visittype.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcetype.label", java.lang.String .class,"key"));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.resourcename.label", java.lang.String .class,"key"));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.referralid.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OrderID.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
