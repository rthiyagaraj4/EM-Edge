package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __catabinsuranceformdaman extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/CATabInsuranceFormDaman.jsp", 1738424506409L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
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

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<meta charset=\"utf-8\">\n<title>Page DAMAN</title>\n<link rel=\'StyleSheet\' href=\'../html/CATabInsuranceAuthorization.css\' type=\'text/css\'/>\n<style type=\"text/css\">\n\n\n</style>\n<script type=\"text/javascript\">\nfunction on() {\n\tdocument.getElementById(\"somediv\").style.display = \"block\";\n\tvar canvas = document.getElementById(\'can\');\n\tvar ctx = canvas.getContext(\'2d\');\n\tctx.fillStyle = \'white\';\n\tctx.fillRect(0, 0, canvas.width, canvas.height);\n}\n\tfunction off() {\n\t  document.getElementById(\"somediv\").style.display = \"none\";\n}\n</script>\n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCA/js/CATabInsuranceAuthorizationForm.js\"></script>\n</head>\n\n<body onload=\"init();viewImage(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\')\">\n<div id=\'somediv\' style=\"display:none;\">\n\t<div>\n\t<canvas id=\"can\" width=\"800\" height=\"200\" class=\"center\"\n\t\tstyle=\"border: 2px solid; background-color:#ffffff;\"></canvas>\n\t<canvas id=\"blank\" style=\'display:none\'></canvas>\n\t</div>\n\t<div>\n\t\t<input type=\"button\" value=\"Save\" id=\"btn\" size=\"30\" onclick=\"off();saveData(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\');\">\n\t\t<input type=\"button\" value=\"Clear\" id=\"btn\" size=\"30\" onclick=\"clearSign()\">\n\t\t<input type=\"button\" value=\"Close\" id=\"btn\" size=\"30\" onclick=\"off()\">\t\n\t</div>\n\t\n</div>\n\t\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t\t\t<tbody>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\">\n\t\t\t\t\t\t<table width=\"100%\" border=\"0\" cellspacing=\"0\" cellpadding=\"0\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"bg1 txtbig\">Authorization Request for Inpatient / OutPatient Form</td>\n\t\t\t\t\t\t\t\t\t<td align=\"right\" width=\"75px\">\n\t\t\t\t\t\t\t\t\t\t<img src=\"../../eCA/images/Logo_daman.jpg\" width=\"68\" height=\"60\" alt=\"\"/>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\" class=\"content-txt tdH1\" style=\"\">Patient\'s\n\t\t\t\t\t\tDetails (To be filled by the Admission Department)\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\" class=\"border1\"><table width=\"100%\"\n\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">Patient\'s Name: (as\n\t\t\t\t\t\t\t\t\t\twritten on card) <br> ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td rowspan=\"6\" width=\"30%\" class=\"borderleft\"><img src=\'../../eCA/jsp/CATABDisplayImages.jsp?patient_id=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="&encounterid=";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&patient_class=";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&facility_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&Param=PAT_PHOTO\' width=\"400\" border=0 height=\"250\"></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">Card ID Number : ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">Patient Contact\n\t\t\t\t\t\t\t\t\t\tNo.:(Mobile) (mandatory)<br>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">Provider\'s Name / Code :\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">Physician\'s License No.: ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \">Date: ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\" class=\"content-txt tdH1\" style=\"\">Service\n\t\t\t\t\t\t/Admission Information (To be filled by the admission Department)</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\"><table width=\"100%\" cellpadding=\"0\"\n\t\t\t\t\t\t\tcellspacing=\"0\" class=\"border2\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\tname=\"checkbox1\" id=\"checkbox1\" id=\"checkbox1\" ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="> <label \n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox1\">Inpatient </label></td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\tname=\"checkbox2\" id=\"checkbox2\" id=\"checkbox2\" ";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="> <label\n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox2\">Outpatient </label></td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\tname=\"checkbox3\" id=\"checkbox3\" id=\"checkbox3\" ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="> <label \n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox3\">Day\tCare</label></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\">&nbsp;</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\"><table width=\"100%\" cellpadding=\"0\"\n\t\t\t\t\t\t\tcellspacing=\"0\" class=\"border1\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt\">Category:<br> <br> \n\t\t\t\t\t\t\t\t\t<input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\tname=\"checkbox4\" id=\"checkbox4\" id=\"checkbox4\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =">\n\t\t\t\t\t\t\t\t\t\t<label\n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox4\">ER</label> <br> <input type=\"checkbox\" name=\"checkbox5\" id=\"checkbox5\" id=\"checkbox5\" ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="> <label\n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox5\">Work\n\t\t\t\t\t\t\t\t\t\tRelated Accident</label>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \"><input name=\"checkbox4\" id=\"checkbox4\"\n\t\t\t\t\t\t\t\t\t\ttype=\"checkbox\" id=\"checkbox5\" ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="> <label\n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox5\"></label> New Visit<br> <input type=\"checkbox\" name=\"checkbox8\" id=\"checkbox8\" id=\"checkbox8\" ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="> <label\n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox8\">Referral</label></td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \"><input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\tname=\"checkbox4\" id=\"checkbox4\" ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" id=\"checkbox6\"> <label for=\"checkbox6\">Follow-up<br>\n\t\t\t\t\t\t\t\t\t\t\t<input type=\"checkbox\" name=\"checkbox9\" id=\"checkbox9\" id=\"checkbox9\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =">\n\t\t\t\t\t\t\t\t\t\t\tRoad Traffic Accident\n\t\t\t\t\t\t\t\t\t</label></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"3\" class=\"content-txt \">If referral please\n\t\t\t\t\t\t\t\t\t\tspecify source: <u>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</u></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\" class=\"content-txt \" style=\"\">Medical Details\n\t\t\t\t\t\t(To be filled by Medical Doctor- Please do not use abbreviations)</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\" class=\"border1\"><table width=\"100%\"\n\t\t\t\t\t\t\tcellpadding=\"0\" cellspacing=\"0\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td style=\"word-wrap:break-word;\"  colspan=\"4\" class=\"borderBot content-txt \">Chief\n\t\t\t\t\t\t\t\t\t\tComplaints:\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  style=\"word-wrap:break-word;\" colspan=\"4\" class=\"borderBot content-txt \">Diagnosis\n\t\t\t\t\t\t\t\t\t\t(ICD-9 Description):\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td  style=\"word-wrap:break-word;\" colspan=\"3\" class=\"borderBot content-txt \">Anticipated\n\t\t\t\t\t\t\t\t\t\tManagement Plan:\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">Estimated Cost :\n\t\t\t\t\t\t\t\t\t\t________________________________</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"content-txt \">Expected Length of\n\t\t\t\t\t\t\t\t\t\tStay:";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\" content-txt \">Days</td>\n\t\t\t\t\t\t\t\t\t<td class=\" content-txt \">Expected Date of Admission/\n\t\t\t\t\t\t\t\t\t\tService :\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"borderBot content-txt \"><input type=\"checkbox\" name=\"checkbox10\" id=\"checkbox10\" id=\"checkbox10\" ";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="> <label\n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox10\">Day Care </label></td>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">&nbsp;</td>\n\t\t\t\t\t\t\t\t\t<td class=\"borderBot content-txt \">Estimated Cost :\n\t\t\t\t\t\t\t\t\t\t________________________________</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"4\" class=\" content-txt \">Services requiring\n\t\t\t\t\t\t\t\t\t\tapproval from National Health Insurance Company- Daman<br>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"4\" class=\" content-txt \"><input type=\"checkbox\" name=\"checkbox11\" id=\"checkbox11\" id=\"checkbox11\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="> <label\n\t\t\t\t\t\t\t\t\t\tfor=\"checkbox11\">Admission <input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\t\tname=\"checkbox12\" id=\"checkbox12\" id=\"checkbox12\" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="> MRI <input type=\"checkbox\" name=\"checkbox13\" id=\"checkbox13\" ";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" id=\"checkbox13\"> CT\n\t\t\t\t\t\t\t\t\t\t\tScan <input type=\"checkbox\" name=\"checkbox14\" id=\"checkbox14\" id=\"checkbox14\" ";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 =">\n\t\t\t\t\t\t\t\t\t\t\tPhysiotherapy <input type=\"checkbox\" name=\"checkbox15\" id=\"checkbox15\"\n\t\t\t\t\t\t\t\t\t\t\tid=\"checkbox15\" ";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="> Home Nursing <input type=\"checkbox\"\n\t\t\t\t\t\t\t\t\t\t\tname=\"checkbox16\" id=\"checkbox16\" id=\"checkbox16\" ";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="> Endoscopy <input type=\"checkbox\" name=\"checkbox17\" id=\"checkbox17\" id=\"checkbox17\" ";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =">\n\t\t\t\t\t\t\t\t\t\t\tOthers\n\t\t\t\t\t\t\t\t\t</label></td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td colspan=\"4\" class=\" content-txt \">Specify:\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="__________________________________________________________________________";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \">Doctor\'s name: ";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="</td>\n\t\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"content-txt\">\n\t\t\t\t\t\t\t\t\t\t<table width=\"100%\" cellpadding=\"0\" cellspacing=\"0\"><tr><td valign=\"center\" class=\"content-txt \" width=\"40%\">\n\t\t\t\t\t\t\t\t\t\tSignature and stamp of\n\t\t\t\t\t\t\t\t\t\tdoctor:</td><td width=\"60%\"><U><img src=\'../../eCA/jsp/CATABDisplayImages.jsp?attend_practitioner_id=";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="&Param=PRACTITIONER_SIGN\' width=\"250\" border=0 height=\"40\"></td></tr></table>\n\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt \">Date:</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\t\t\t\t<table><!-- IN070213 starts -->\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\n\t\t\t\t\t\t\t\t<p>Patient\n\t\t\t\t\t\t\t\tconsent: I the undersigned hereby authorize the National Health\n\t\t\t\t\t\t\t\tInsurance Company- Daman, to get all needed medical information\n\t\t\t\t\t\t\t\tabout my case from the provider upon its request, for the purpose\n\t\t\t\t\t\t\t\tof claim review.</p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td class=\"Txtcontent\" width=\"50%\">\n\t\t\t\t\t\t\t\t<p>Patient signature: </p><img id=\"canvasimg\" style=\"display:none\" width=200 src=\"\"/>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=\"Txtcontent\" width=\"50%\">\n\t\t\t\t\t\t\t\t <p>:ت�?�?�?ع/بص�?ة ا�?إصبع �?�?�?ر�?ض</p><img id=\"canvasimg\" style=\"display:none\" width=200 src=\"\"/>\n\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\n\t\t\t\t\t\t\t\t<p>\n\t\t\t\t\t\t\t\t\n\t\t\t\tإ�?رار ا�?�?ر�?ض أ�?ا ا�?�?�?�?ع أد�?ا�? أخ�?�? ا�?شر�?ة ا�?�?ط�?�?ة �?�?ض�?ا�? ا�?صح�?- ض�?ا�? ا�?حص�?�? ع�?�? ج�?�?ع ا�?�?ع�?�?�?ات ا�?طب�?ة ا�?�?تع�?�?ة بحا�?ت�? ا�?صح�?ة �?�? �?ب�? �?ز�?د ا�?رعا�?ة ا�?صح�?ة ع�?د ط�?ب�?ا �?�?راجعة ا�?�?طا�?بة ا�?طب�?ة.\n\t\t\t\t\t\t\t\t</p>\n\t\t\t\t\t\t\t\t<p>\n\t\t\t\t\t\t\t\t...........ت�?�?�?ع/بص�?ة ا�?إصبع �?�?�?ر�?ض\n\t\t\t\t\t\t\t\t</p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\n\t\t\t\t\t\t\t\t\t<p>Authorization review shall not, in any way, impair treatment\n\t\t\t\t\t\t\t\ttimelines. The patient, provider and concerned medical care\n\t\t\t\t\t\t\t\tprofessionals are liable for all treatment decisions to improve\n\t\t\t\t\t\t\t\tthe quality of life of the patient.</p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\n\t\t\t\t\t\t\t<p>\n�?�? �?�?�?�? ا�?اذ�? با�?�?�?ا�?�?ة ا�?طب�?ة �?�? أ�? تأث�?ر ع�?�? ا�?جد�?�? ا�?ز�?�?�? �?ت�?د�?�? ا�?ع�?اج. �?ب�?�? �?ز�?د ا�?رعا�?ة ا�?صح�?ة �?ا�?�?تخص�?�? �?�? �?جا�? ا�?ع�?اج ا�?طب�? �?ا�?�?ر�?ض �?�?س�? �?حد�?�? ا�?�?سؤ�?�?�?�? ع�? ج�?�?ع ا�?�?رارات ا�?�?تع�?�?ة با�?ع�?اج �?تحس�?�? �?�?ع�?ة ح�?اة ا�?�?ر�?ض.\n\t\t\t\t\t\t\t</p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\n\t\t\t\t\t\t\t\t<p>This Notification does not guarantee payment. Payment is\n\t\t\t\t\t\t\t\tsubject to the Patient\'s eligibility and contract benefits at the\n\t\t\t\t\t\t\t\ttime of service.</p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\n\t\t\t\t\t\t\t\t<p>\n�?ا �?عتبر �?ذا ا�?إشعار ب�?ثابة ض�?ا�?ة با�?د�?ع. �?ب�?�? ا�?د�?ع �?رتبط بأ�?�?�?ة ا�?�?ر�?ض �?�?تغط�?ة �?�?�?ا�?ع ع�?د ا�?تأ�?�?�? �?�? تار�?خ ت�?د�?�? ا�?خد�?ة.</p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t<td colspan=\"2\" class=\"Txtcontent\" style=\"\">\n\t\t\t\t\t\t<p>National Health Insurance Company - Daman (P.O. Box 128888,\n\t\t\t\t\t\t\tAbu Dhabi, U.A.E. Tel No. +97126149555 Fax No. +97126149550)</p>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table><!-- IN070213 ends -->\n\t\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td colspan=\"2\"><table width=\"100%\" cellpadding=\"0\"\n\t\t\t\t\t\t\tcellspacing=\"0\" class=\"border2\">\n\t\t\t\t\t\t\t<tbody>\n\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt\">Doc Ctrl No.:</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt borderleft-thin\">FRM/AU.20</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt borderleft-thin\">Version No.:</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt borderleft-thin\">2.0</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt borderleft-thin\">Date of Issue:</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt borderleft-thin\">07.09.2011</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt borderleft-thin\">Page No(s).:</td>\n\t\t\t\t\t\t\t\t\t<td class=\"content-txt borderleft-thin\">1 of 1</td>\n\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t</tbody>\n\t\t\t\t\t\t</table></td>\n\t\t\t\t</tr>\n\t\t\t\t<tr></tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<TD class=\"label\" align=\"right\">\n\t\t\t\t\t\t<!-- <input type=\"button\" name=\"save\" id=\"save\" VALUE=\'save\' onclick=\"saveData()\" > -->\n\t\t\t\t\t\t<button id=\"sign\" onclick=\"on()\">Sign</button>\n\t\t\t\t\t</TD>\n\t\t\t\t</tr>\n\t\t\t</tbody>\n\t\t</table>\n\t<script type=\"text/javascript\">\n\tvar canvas, ctx, flag = false, prevX = 0, currX = 0, prevY = 0, currY = 0, dot_flag = false;\n\tvar x = 0, y = 2;\n\tfunction init() {\n\t\tcanvas = document.getElementById(\'can\');\n\t\tctx = canvas.getContext(\"2d\");\n\t\tw = canvas.width;\n\t\th = canvas.height;\n\n\t\tcanvas.addEventListener(\"mousemove\", function(e) {\n\t\t\tfindxy(\'move\', e)\n\t\t}, false);\n\t\tcanvas.addEventListener(\"mousedown\", function(e) {\n\t\t\tfindxy(\'down\', e)\n\t\t}, false);\n\t\tcanvas.addEventListener(\"mouseup\", function(e) {\n\t\t\tfindxy(\'up\', e)\n\t\t}, false);\n\t\t\n\t\t// Set up touch events for mobile, etc\n\t\tcanvas.addEventListener(\"touchstart\", function (e) {\n\t\t\tmousePos = getTouchPos(canvas, e);\n\t\t  \tvar touch = e.touches[0];\n\t\t \tvar mouseEvent = new MouseEvent(\"mousedown\", {\n\t\t    \tclientX: touch.clientX,\n\t\t    \tclientY: touch.clientY\n\t\t  \t});\n\t\t  \tcanvas.dispatchEvent(mouseEvent);\n\t\t}, false);\n\t\tcanvas.addEventListener(\"touchend\", function (e) {\n\t\t  var mouseEvent = new MouseEvent(\"mouseup\", {});\n\t\t  canvas.dispatchEvent(mouseEvent);\n\t\t}, false);\n\t\tcanvas.addEventListener(\"touchmove\", function (e) {\n\t\t  var touch = e.touches[0];\n\t\t  var mouseEvent = new MouseEvent(\"mousemove\", {\n\t\t    clientX: touch.clientX,\n\t\t    clientY: touch.clientY\n\t\t  });\n\t\t  canvas.dispatchEvent(mouseEvent);\n\t\t}, false);\n\t}\n\n\tfunction draw() {\n\t\tctx.beginPath();\n\t\tctx.moveTo(prevX, prevY);\n\t\tctx.lineTo(currX, currY);\n\t\tctx.strokeStyle = x;\n\t\tctx.lineWidth = y;\n\t\tctx.stroke();\n\t\tctx.closePath();\n\t}\n\t\n\tfunction clearSign() {\n            ctx.clearRect(0, 0, w, h);\n            document.getElementById(\"canvasimg\").style.display = \"none\";\n            var canvas = document.getElementById(\'can\');\n        \tctx.fillStyle = \'white\';\n        \tctx.fillRect(0, 0, canvas.width, canvas.height);\n\t}\n\tfunction findxy(res, e) {\n\t\tif (res == \'down\') {\n\t\t\tprevX = currX;\n\t\t\tprevY = currY;\n\t\t\tcurrX = e.clientX - canvas.offsetLeft;\n\t\t\tcurrY = e.clientY - canvas.offsetTop;\n\n\t\t\tflag = true;\n\t\t\tdot_flag = true;\n\t\t\tif (dot_flag) {\n\t\t\t\tctx.beginPath();\n\t\t\t\tctx.fillStyle = x;\n\t\t\t\tctx.fillRect(currX, currY, 2, 2);\n\t\t\t\tctx.closePath();\n\t\t\t\tdot_flag = false;\n\t\t\t}\n\t\t}\n\t\tif (res == \'up\') {\n\t\t\tflag = false;\n\t\t}\n\t\tif (res == \'move\') {\n\t\t\tif (flag) {\n\t\t\t\tprevX = currX;\n\t\t\t\tprevY = currY;\n\t\t\t\tcurrX = e.clientX - canvas.offsetLeft;\n\t\t\t\tcurrY = e.clientY - canvas.offsetTop;\n\t\t\t\tdraw();\n\t\t\t}\n\t\t}\n\t}\n\t\n\t// Get the position of a touch relative to the canvas\n\tfunction getTouchPos(canvasDom, touchEvent) {\n\t  var rect = canvasDom.getBoundingClientRect();\n\t  return {\n\t    x: touchEvent.touches[0].clientX - rect.left,\n\t    y: touchEvent.touches[0].clientY - rect.top\n\t  };\n\t}\n\t\tfunction viewImage(patient_id,encounter_id,p_report_id) {\n\t\t\t xmlStr = \"<root><SEARCH \";\n\t\t\t xmlStr += \" patient_id=\\\"\" +patient_id+ \"\\\"\";\n\t\t\t xmlStr += \" encounter_id=\\\"\" +encounter_id+ \"\\\"\";\n\t\t\t xmlStr += \" p_report_id=\\\"\" +p_report_id+ \"\\\"\";\n\t\t\t xmlStr += \" /></root>\";\n\t\t\t var xmlDoc;\n\t\t\t var xmlHttp;\n\t\t\t xmlHttp = new XMLHttpRequest();\n\t\t\t var oParser = new DOMParser();\n\t\t\t xmlDoc = oParser.parseFromString(xmlStr,\"text/xml\");\n\t\t\t xmlHttp.open(\"POST\", \"CATabIntermediateValidate.jsp\", false);\n\t\t\t xmlHttp.send(xmlDoc);\n\t\t\t responseText = xmlHttp.responseText ;\n\t\t\t eval(responseText);\n\t}\n\t\n\tfunction testView(data){\n\t\t \tvar imageURL = \"data:image/jpeg;base64,\"+data;\n\t        document.getElementById(\"canvasimg\").src = imageURL;\n\t\t\tdocument.getElementById(\"canvasimg\").style.display = \"inline\"; \n\t\t\t document.getElementById(\"canvasimg\").src = imageURL;\n\t}\n\t\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );
	
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

/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       		Edit History      		Name        		Rev.Date				Rev.Name		Description
------------------------------------------------------------------------------------------------------------------------------------------------------
25/06/2019		IN070757			Sivabagyam M	  		25/06/2019				Ramesh G.		AAKH-CRF-0079.8
---------------------------------------------------------------------------------------------------------------------------------------------
*/ 

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String path = request.getContextPath(); 
	java.util.Properties p=(java.util.Properties) session.getValue( "jdbc" );
	String locale = p.getProperty("LOCALE");
	String added_by_id			= p.getProperty("login_user");//login_by_id			
	String added_at_ws_no		= p.getProperty("client_ip_address");//login_at_ws_no
	String patient_id = request.getParameter("patientid") == null ? "": request.getParameter("patientid");
	String encounterid = request.getParameter("encounterid") == null ? "": request.getParameter("encounterid");
	String facility_id = request.getParameter("facilityid") == null ? "": request.getParameter("facilityid");
	String p_report_id = "CAAKINFDAMAN";
	String bean_id="CAInsurenceAuthorizationFormsBean";
	String bean_name="eCA.CAInsurenceAuthorizationFormsBean";
	eCA.CAInsurenceAuthorizationFormsBean bean = (eCA.CAInsurenceAuthorizationFormsBean)getBeanObject( bean_id,bean_name,request);
	ArrayList<String> formData = bean.getFormData(patient_id,encounterid,facility_id);	
	String disable_flag = "disabled";
	/***********************************ICON SWAPPER****************************************************/
	/***********************************CHECKBOX FLAGS **************************************************/
	String ip_chk = "";
	String op_chk = "";
	String dc_chk = "";
	String em_chk = "";
	String newVisit_chk = "";
	String followup_chk = "";
	String rd_traffic_accident_chk = "";
	String referral_chk = "";
	String admission_chk = "";
	String mri_chk = "";
	String ct_scan_chk = "";
	String physio_chk = "";
	String home_nursing_chk = "";
	String endoscopy_chk = "";
	String others_chk = "";
	String daycare="";
	
	/****************************************************************************************************/
	/***********************************FORM INPUTS ****************************************************/
	String patient_name 			= formData.get(0);//patient_name
	String card_id_no				= formData.get(1);//card_id_no
	String contact_no				= formData.get(2);//contact_no
	String provider_name			= formData.get(3);//provider_name
	String physician_license_no 	= formData.get(4);//physician_license_no
	String date 					= formData.get(5);//date
	String patient_class			= formData.get(6);//patient_class
	String visit_adm_type_ind		= formData.get(7);//visit_adm_type_ind
	String mv_accident_yn			= formData.get(8);//mv_accident_yn
	String referral_id				= formData.get(9);//referral_id
	String referral_source			= formData.get(10);//referral_source
	String exp_length_of_stay		= formData.get(11);//exp_length_of_stay
	String exp_date					= formData.get(12);//exp_date
	String specify					= formData.get(13);//specify
	String doctor_name				= formData.get(14);//doctor_name
	String admission_yn				= formData.get(15);//admission_yn 
	String mri_yn					= formData.get(16);//mri_yn
	String ct_scan_yn				= formData.get(17);//ct_scan_yn
	String physio_yn				= formData.get(18);//physio_yn
	String home_nursing_yn			= formData.get(19);//home_nursing_yn
	String endoscopy_yn				= formData.get(20);//endoscopy_yn
	String others_yn				= formData.get(21);//others_yn
	String chiefComplaints			= formData.get(22);//chiefComplaints
	String attend_practitioner_id	= formData.get(23); //attend_practitioner_id
	String diagnosis_desc			= formData.get(24); //diagnosis ic9
	String anti_man_plan			= formData.get(25); //anticipated plan
	String daicare					= formData.get(26); //day care************************************************/
	/***********************************CHECKBOX VALIDATIONS ********************************************/
	if("IP".equals(patient_class)){
		ip_chk = "checked";
		op_chk = "";
		dc_chk = "";
		em_chk = "";
	}else if("OP".equals(patient_class)){
		ip_chk = "";
		op_chk = "checked";
		dc_chk = "";
		em_chk = "";
	}else if("DC".equals(patient_class)){
		ip_chk = "";
		op_chk = "";
		dc_chk = "checked";
		em_chk = "";
	}else if("EM".equals(patient_class)){
		ip_chk = "";
		op_chk = "";
		dc_chk = "";
		em_chk = "checked";
	}
	if("F".equals(visit_adm_type_ind)){
		newVisit_chk = "checked";
		followup_chk = "";
	}else if("L".equals(visit_adm_type_ind)){
		newVisit_chk = "";
		followup_chk = "checked";
	}
	if("Y".equals(mv_accident_yn)){
		rd_traffic_accident_chk = "checked";
	}
	if(!"".equals(referral_id) && referral_id!=null){
		referral_chk = "checked";
	}
	if("Y".equals(admission_yn)){
		admission_chk = "checked";
	}
	if("Y".equals(mri_yn)){
		mri_chk = "checked";
	}
	if("Y".equals(ct_scan_yn)){
		ct_scan_chk = "checked";
	}
	if("Y".equals(physio_yn)){
		physio_chk = "checked";
	}
	if("Y".equals(home_nursing_yn)){
		home_nursing_chk = "checked";
	}
	if("Y".equals(endoscopy_yn)){
		endoscopy_chk = "checked";
	}
	if("Y".equals(others_yn)){
		others_chk = "checked";
	}
	if(daicare.equals("Y"))
	{
		daycare="checked";
	}
		
	/****************************************************************************************************/

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_report_id));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(p_report_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(added_by_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(added_at_ws_no));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(patient_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(encounterid));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(patient_class));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(card_id_no));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(contact_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(provider_name));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(physician_license_no));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(date));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(ip_chk));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(op_chk));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(dc_chk));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(em_chk));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(newVisit_chk));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(referral_chk));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(followup_chk));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rd_traffic_accident_chk));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(referral_source));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(chiefComplaints ));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(diagnosis_desc ));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(anti_man_plan ));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(exp_length_of_stay));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(exp_date));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(daycare));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(admission_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(mri_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(ct_scan_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(physio_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(home_nursing_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(endoscopy_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(others_chk));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block43Bytes, _wl_block43);
if("".equals(specify)){
            _bw.write(_wl_block44Bytes, _wl_block44);
}
										else{
            out.print( String.valueOf(specify));
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(doctor_name ));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(attend_practitioner_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
