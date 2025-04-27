package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import eCommon.Common.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __chartsummaryactiveproblemsd extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ChartSummaryActiveProblemsD.jsp", 1739431300490L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!-- \n--------------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n29/11/2012  IN035950      Nijitha        CHL Hospital suggested that the presentation of the Clinician desktop be changed and \n\t\t\t\t\t more appealing. Keeping the display of information more clear and visible.\n07/12/2012  IN030460\t  Nijitha\t BRU-HIMS-CRF-019\t\t\n24/01/2012\tIN036001\t  Chowminya G\t Record Diagnosis in Thai language screen.Data lang not changed\t\t\t \n12/02/2013\tIN030459\t  Karthi L\t \tTo show diagnosis list with the encounter information in Chart Summary\n07/06/2013  IN037737\t  Nijitha S  ML-BRU-SCF-0682\n15/10/2013\tIN043924\t  Vijayakumar K Alpha-CA>Patient Without Encounter>Chief Complaint recorded for the patient is not displayed\n02/06/2014\tIN037701\t  Nijitha\t\tSKR-CRF-0036\n07/05/2015  IN055047 \t  AAKH-SCF-0197\n10/11/2017  IN061896\t  kamalakannan G  System should show date/time in diagnosis widget\n16/11/2017\tIN65780   Kamalakannan G  Data/Time column color change \n--------------------------------------------------------------------------------------------------------\nDate       \tEdit History      \tName        \tRev.Date\t\tRev.Name\t\tDescription\n---------------------------------------------------------------------------------------------------------\n28/06/2018\tIN065341\t\tPrakash C\t29/06/2018\t\tRamesh G \t\tMMS-DM-CRF-0115\n21/08/2018\tIN067855\t\tRamya       22/08/2018\t\tRamesh G \t\tML-MMOH-CRF-1202\n30/01/2019\tIN069327\t\tPrakash C   30/01/2019\t\tRamesh G \t\tML-MMOH-CRF-1281.1\n23/03/2023  38981        Krishna Pranay   23/03/2023     Ramesh G     ML-MMOH-CRF-1986\n30/03/2023  42995        Krishna Pranay   30/03/2023     Ramesh G    CA-ML-MMOH-CRF-1986\n\n\n---------------------------------------------------------------------------------------------------------\n-------------->\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<!--IN037701 Start-->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!--IN037701 Ends-->\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<title>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</title><!-- [IN035950] -->\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' type=\'text/css\' />\n\n   \t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n    <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t<script src=\"../../eCA/js/ResearchPatient.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<script>\n\t\n\t\t\tvar detailArray = new Array();\n\t\t\tasync function showProblem(Patient_Id,term_code,term_set_id,short_desc,Encounter_Id)\n\t\t\t{\n\t\t\t//alert(\'here\');\n\t\t\tvar dialogHeight=20;\n\t\t\tvar dialogWidth=30;\n\t\t\t//var title\t\t\t= getLabel(\"Common.ChiefComplaint.label\",\"Common\")+\" \"+(getLabel(\"Common.Problem.label\",\"Common\"));\n\t\t\tvar features=\'dialogHeight:\' + dialogHeight + \'; dialogWidth:\' + dialogWidth +\'; scroll=auto; status=no\';\n\t\t\tretVal=await window.showModalDialog(\"../../eMR/jsp/selectProblemFrames.jsp?callFunction=showProblem&patient_id=\"+Patient_Id+\"&encounter_id=\"+Encounter_Id+\"&term_code=\"+term_code+\"&term_set_id=\"+term_set_id+\"&short_desc=\"+short_desc+\" \"\t,arguments,features);\n\t\t\t}\n\n\n\t\t\tasync function CallAuathorize(patientid,mode,authorize)\n\t\t\t{\n\t\t\t\tvar p_called_from = document.getElementById(\"p_called_from\").value;//IN037701\n\t\t\t\tif(authorize == \'Y\')\n\t\t\t\t{\n\t\t\t\t\tvar params=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\';\n\t\t\t\t\tvar ind= params.lastIndexOf(\"&authorize\");\n\t\t\t\t\tif(ind!=-1)\n\t\t\t\t\t\tparams=params.substring(0,ind);\n\t\t\t\t\tparams+=\"&authorize=N\";\n\t\t\t\t\twindow.location.href=\'ChartSummaryActiveProblemsD.jsp?\'+params;//IN037701\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\tvar val1 = \'V\' ;\n\t\t\t\t\tvar val2 = \'Ass\' ;\n\t\t\t\t\tvar val3=\'C\'\n\t\t\t\t\tif(\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'==\"PatientQueue\")\n\t\t\t\t\t\tval3=\"O\";\n\t\t\t\t\tvar val = val1+\'/\'+val2+\'/\'+val3+\'/\';\n\n\t\t\t\t\tvar retVal = \tnew String();\n\t\t\t\t\tvar dialogHeight= \"30vh\" ;\n\t\t\t\t\tvar dialogWidth\t= \"30vw\" ;\n\t\t\t\t\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\t\t\t\tvar arguments\t= \"\" ;\n\t\t\t\t\t\n\t\t\t\t\tretVal = await top.window.showModalDialog(\"AuthorizeMRAccess.jsp?constr=\"+val,arguments,features);\n\n\t\t\t\t\tif(retVal==\"T\"){\n\t\t\t\t\t\t\n\t\t\t\t\t\tvar params=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\';\n\t\t\t\t\t\tvar ind= params.lastIndexOf(\"&authorize\");\n\t\t\t\t\t\tif(ind!=-1)\n\t\t\t\t\t\t\tparams=params.substring(0,ind);\n\t\t\t\t\t\tparams+=\"&authorize=Y\";\n\t\t\t\t\t\twindow.location.href=\'ChartSummaryActiveProblemsD.jsp?\'+params;//IN037701\n\t\t\t\t\t}\n\t\t\t\t\telse{\n\t\t\t\t\t\tvar params=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\';\n\t\t\t\t\t\tvar ind= params.lastIndexOf(\"&authorize\");\n\t\t\t\t\t\t\tif(ind!=-1)\n\t\t\t\t\t\tparams=params.substring(0,ind);\n\t\t\t\t\t\tparams+=\"&authorize=N\";\n\t\t\t\t\t\twindow.location.href=\'ChartSummaryActiveProblemsD.jsp?\'+params;//IN037701\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\n\t\t\t}\n\t\n\tfunction callMouseOverDiag(obj,index)\n\t{\n\t\t\n\t\tvar tabdata = \'<table class=\"grid\" cellpadding=0 cellspacing=0 border=1><tr><td class=columnHeadercenter nowrap>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&nbsp;</td><td class=columnHeadercenter nowrap>&nbsp;";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&nbsp;";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td></tr>\';\n\n\t\t\ttabdata +=detailArray[index]+\"</table>\";\n\t\t\tdocument.getElementById(\"details\").innerHTML = tabdata;\n\n\t\t\t\tvar wdth \t  = obj.offsetWidth;\n\t\t\t\tvar hght1 \t  = obj.offsetHeight;\n\n\t\t\t\tvar wdth1 = getPos(obj).x - wdth;\n\t\t\t\tvar hght = getPos(obj).y + hght1;\n\t\t\t\t\n\t\t\t\tdocument.getElementById(\"details\").style.posTop  = hght;\n\t\t\t\tdocument.getElementById(\"details\").style.posLeft  = wdth1;\n\t\t\t\tdocument.getElementById(\"details\").style.visibility = \'visible\' ;\n\t\t\t\t\t\n\n\t}\n\tfunction callOnMouseOutDiag(obj)\n\t{\n\t\tdocument.getElementById(\"details\").style.visibility=\'hidden\' ;\n\t}\n\n\tfunction getPos(inputElement)\n\t{\n\t\tvar coords =  new Object();\n\t\tcoords.x = 0;\n\t\tcoords.y = 0;\n\t\ttry\n\t\t{\n\t\t\ttargetElement = inputElement;\n\t\t\tif(targetElement.x && targetElement.y)\n\t\t\t{\n\t\t\t\tcoords.x = targetElement.x;\n\t\t\t\tcoords.y = targetElement.y;\n\t\t\t}\n\t\t\telse\n\t\t\t{\n\t\t\t\tif(targetElement.offsetParent)\n\t\t\t\t{\n\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\twhile(targetElement = targetElement.offsetParent)\n\t\t\t\t\t{\n\t\t\t\t\t\tcoords.x += targetElement.offsetLeft;\n\t\t\t\t\t\tcoords.y += targetElement.offsetTop;\n\t\t\t\t\t}\n\t\t\t\t}\n\t\t\t\telse\n\t\t\t\t{\n\t\t\t\t\t//alert(\"Could not find any reference for coordinate positioning.\");\n\t\t\t\t}\n\t\t\t}\n\t\t\treturn coords;\n\t\t}\n\t\tcatch(error)\n\t\t{\n\t\t\treturn coords;\n\t\t}\n\t}\t\n\t\t</script>\n\t<!--IN037737 Starts-->\n\t<style>\n\t.highlite\n\t{\n\tborder-left:2px;\n\tborder-right:2px;\n\tborder-top:2px;\n\tborder-bottom:2px;\n\tborder-color:blue;\n\tborder-style:solid;\n\t}\n\t</style>\n\t<!--IN037737 Ends-->\n</head>\n<body onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<center>\n\t\t\t<a class=\'gridLink\' href=\"javascript:CallAuathorize(\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\',\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\" onMouseOver=\"showToolTip(this,\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\')\" onMouseOut=\"javascript:hideToolTip()\" ><font size=\'2\' color=\'red\'> [";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="] </a></font></center>\n\t\t\t\n\t\t\t<table class=\'grid\'  width=\'100%\'><br>\t\n\n\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n    <table class=\'grid\' align=\'center\' width=\'100%\'>\n\t<!--<tr>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</font></td>\n\t\t\t\t<td align=\'center\'  wrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="/";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</font></td>\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="</font></td>\n\t</tr>[IN035950 Commented]-->\n\t<!--IN035950 Starts-->\n\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<tr>\n\t\t\t\t<!--IN037701 Starts-->\n\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" Classification</font></td>\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER\' ><font align=\'top\'>Practitioner</font></td> \n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font align=\'top\'>";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="</font></td><!-- called label name from java for IN65780  -->\n\t\t\t    <td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font align=\'top\'>";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="</font></td><!--38981-->\n\t\t\t    <td class=\'COLUMNHEADERCENTER\'   width=\"6%\">";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</td> <!-- 38981 -->\n\t\t\t    \n\t\t\t\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font size=1 >&nbsp;</font></td>\n\t\t\t\t<td align=\'center\'  wrap class=\'COLUMNHEADERCENTER\'><font size=1 align=\'top\'>";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER\'><font align=\'top\'>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="</font></td><!--38981-->\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="<!--IN065341-->\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER\' ><font align=\'top\'>Linked Encounters</font></td>\n\t\t\t";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\n\t\t\t<td class=\'COLUMNHEADERCENTER\'   width=\"6%\">";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="</td> <!-- 38981 -->\n\t\t\t\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\n\t\t\t\t<!--IN037701 Ends-->\n\t</tr>\n\t";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\n\t<tr>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'><font size=1 >&nbsp;</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'><font size=1 >&nbsp;</font></td>\t\t\t\t\n\t\t\t\t<td align=\'center\'  wrap class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'><font align=\'top\'>";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="</font></td>\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\' ><font align=\'top\'>";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="</font></td>\n\t\t\t\t<td align=\'center\' nowrap class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="<!--IN065341-->\n\t\t\t\t<td align=\'center\'  nowrap class=\'COLUMNHEADERCENTER";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\' ><font align=\'top\'>Linked Encounters</font></td> <!-- added for IN030459 -->\n\t\t\t";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\n\t\t\t<td class=\'COLUMNHEADERCENTER\'  width=\"6%\">";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="</td> <!-- 38981 -->\n\t\t\t\n\t</tr>\n\t";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\n\t<!--IN035950 Ends-->\n\t";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\n\t<!-- IN061896 starts --><tr><td class=\'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\' >&nbsp;</td><td class=\'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'><img src=\'../../eCommon/images/Problems.gif\'>";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="</td><td class=\'";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\'>";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

    private final static java.lang.String  _wl_block61 ="</td></tr><!--Removed the Decoder from complaint desc for EMR fix--><!-- IN061896 ends -->\n";
    private final static byte[]  _wl_block61Bytes = _getBytes( _wl_block61 );

    private final static java.lang.String  _wl_block62 ="\n\t\t\t\n\n\t\t\t<tr>\n\t\t\t";
    private final static byte[]  _wl_block62Bytes = _getBytes( _wl_block62 );

    private final static java.lang.String  _wl_block63 ="\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block63Bytes = _getBytes( _wl_block63 );

    private final static java.lang.String  _wl_block64 ="\' ><font color=\'blue\' ><b>C</font></td>\n\t\t\t";
    private final static byte[]  _wl_block64Bytes = _getBytes( _wl_block64 );

    private final static java.lang.String  _wl_block65 ="\' >&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block65Bytes = _getBytes( _wl_block65 );

    private final static java.lang.String  _wl_block66 ="\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block66Bytes = _getBytes( _wl_block66 );

    private final static java.lang.String  _wl_block67 ="\'><img src=\'../../eCommon/images/CurrentEncounter.gif\'></td>\n\t\t\t";
    private final static byte[]  _wl_block67Bytes = _getBytes( _wl_block67 );

    private final static java.lang.String  _wl_block68 ="\'>&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block68Bytes = _getBytes( _wl_block68 );

    private final static java.lang.String  _wl_block69 ="\n\t\t\t<!-- IN030460 Starts -->\n\t\t\t<!--<td class=\'";
    private final static byte[]  _wl_block69Bytes = _getBytes( _wl_block69 );

    private final static java.lang.String  _wl_block70 ="\'>-->\t\n\t\t\t<!--IN037701 Starts-->\n\t\t\t";
    private final static byte[]  _wl_block70Bytes = _getBytes( _wl_block70 );

    private final static java.lang.String  _wl_block71 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block71Bytes = _getBytes( _wl_block71 );

    private final static java.lang.String  _wl_block72 ="\n\t\t\t<!--IN037701 Ends-->\n\t\t\t<td class=\'";
    private final static byte[]  _wl_block72Bytes = _getBytes( _wl_block72 );

    private final static java.lang.String  _wl_block73 ="\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block73Bytes = _getBytes( _wl_block73 );

    private final static java.lang.String  _wl_block74 ="\n\t\t\t\n\t\t\t<img class=\'highlite\' src=\'../../eCommon/images/PI_HighRisk.gif\' align=\'left\'></img><!--IN037737-->\n\t\t\t";
    private final static byte[]  _wl_block74Bytes = _getBytes( _wl_block74 );

    private final static java.lang.String  _wl_block75 ="\n\t\t\t<!-- IN030460 Ends -->\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block75Bytes = _getBytes( _wl_block75 );

    private final static java.lang.String  _wl_block76 ="\n\t\t\t<img src=\'../../eCommon/images/Differentials.gif\'></img>\n\t\t\t";
    private final static byte[]  _wl_block76Bytes = _getBytes( _wl_block76 );

    private final static java.lang.String  _wl_block77 ="\n\t\t\t";
    private final static byte[]  _wl_block77Bytes = _getBytes( _wl_block77 );

    private final static java.lang.String  _wl_block78 ="  \n\t\t\t\t<img src=\'../../eCommon/images/LinkView.gif\' align=\'right\' onMouseOver=\'callMouseOverDiag(this,\"";
    private final static byte[]  _wl_block78Bytes = _getBytes( _wl_block78 );

    private final static java.lang.String  _wl_block79 ="\")\' onMouseOut=\'callOnMouseOutDiag(this);\'>\n\t\t\t\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block79Bytes = _getBytes( _wl_block79 );

    private final static java.lang.String  _wl_block80 ="\n\t\t</td>\n\t\t<!--IN037701 Starts-->\n\t\t";
    private final static byte[]  _wl_block80Bytes = _getBytes( _wl_block80 );

    private final static java.lang.String  _wl_block81 ="<!--IN069327-->\n\t\t\t\t";
    private final static byte[]  _wl_block81Bytes = _getBytes( _wl_block81 );

    private final static java.lang.String  _wl_block82 ="\n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block82Bytes = _getBytes( _wl_block82 );

    private final static java.lang.String  _wl_block83 =" </td> \n\t\t\t\t";
    private final static byte[]  _wl_block83Bytes = _getBytes( _wl_block83 );

    private final static java.lang.String  _wl_block84 =" </td>\n\t\t\t\t";
    private final static byte[]  _wl_block84Bytes = _getBytes( _wl_block84 );

    private final static java.lang.String  _wl_block85 =" </td>\t<!--IN069327-->\n\t\t\t";
    private final static byte[]  _wl_block85Bytes = _getBytes( _wl_block85 );

    private final static java.lang.String  _wl_block86 =" </td> \n\t\t\t\t<td  class=\'";
    private final static byte[]  _wl_block86Bytes = _getBytes( _wl_block86 );

    private final static java.lang.String  _wl_block87 =" </td> \n\t\t";
    private final static byte[]  _wl_block87Bytes = _getBytes( _wl_block87 );

    private final static java.lang.String  _wl_block88 ="\n\t\t\t\t";
    private final static byte[]  _wl_block88Bytes = _getBytes( _wl_block88 );

    private final static java.lang.String  _wl_block89 =" </td> ";
    private final static byte[]  _wl_block89Bytes = _getBytes( _wl_block89 );

    private final static java.lang.String  _wl_block90 =" </td><!--IN069327-->\n\t\t\t";
    private final static byte[]  _wl_block90Bytes = _getBytes( _wl_block90 );

    private final static java.lang.String  _wl_block91 ="\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block91Bytes = _getBytes( _wl_block91 );

    private final static java.lang.String  _wl_block92 =" </td><!--IN061896--> \t\t\t\t\n\t\t\t\t<!-- 38981 start -->\n           ";
    private final static byte[]  _wl_block92Bytes = _getBytes( _wl_block92 );

    private final static java.lang.String  _wl_block93 ="\t\t\t\n\t\t\t    <!-- 38981 end -->\n\t\t\t\t";
    private final static byte[]  _wl_block93Bytes = _getBytes( _wl_block93 );

    private final static java.lang.String  _wl_block94 ="<!--IN065341-->\n\t\t\t\t<td class=\'";
    private final static byte[]  _wl_block94Bytes = _getBytes( _wl_block94 );

    private final static java.lang.String  _wl_block95 ="\'>&nbsp; <a class=\'gridLink\' href=\"javascript:showLinkedEncounters(\'";
    private final static byte[]  _wl_block95Bytes = _getBytes( _wl_block95 );

    private final static java.lang.String  _wl_block96 ="\')\"><img src=\'../../eCA/images/Encounters.png\'></a></td> <!-- added for IN030459 -->\n\t\t\t";
    private final static byte[]  _wl_block96Bytes = _getBytes( _wl_block96 );

    private final static java.lang.String  _wl_block97 ="\t<!--IN065341-->\n\t\t\t\n\t\t\t<!-- 38981 start -->\n\t\t\t ";
    private final static byte[]  _wl_block97Bytes = _getBytes( _wl_block97 );

    private final static java.lang.String  _wl_block98 ="\t\n\t\t\t<!-- 38981 end --> \n\t\t";
    private final static byte[]  _wl_block98Bytes = _getBytes( _wl_block98 );

    private final static java.lang.String  _wl_block99 ="\n\t\t<!--IN037701 Ends-->\n\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block99Bytes = _getBytes( _wl_block99 );

    private final static java.lang.String  _wl_block100 ="\n    </table>\n\t<input type=\"hidden\" id=\"p_called_from\" name=\"p_called_from\" id=\"p_called_from\" value=\"";
    private final static byte[]  _wl_block100Bytes = _getBytes( _wl_block100 );

    private final static java.lang.String  _wl_block101 ="\"> <!--IN037701 Starts-->\n\t<div id=\'authorizeMode\' style=\'position:absolute; visibility:hidden;overflow:overflow\'></div>\n";
    private final static byte[]  _wl_block101Bytes = _getBytes( _wl_block101 );

    private final static java.lang.String  _wl_block102 ="\n<div name=\'details\' id=\'details\' style=\'position:absolute; width:60%; visibility:hidden;\' bgcolor=\'blue\'>\n\n</div>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block102Bytes = _getBytes( _wl_block102 );

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
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//[IN035950] Starts
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String p_called_from = (request.getParameter("p_called_from") == null) ? "" : request.getParameter("p_called_from");//IN037701

            _bw.write(_wl_block6Bytes, _wl_block6);
if(!"CA_SPC".equals(p_called_from)){
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);

String prefStyleSheet = request.getParameter("prefStyle");//Nijitha
String content_ID = request.getParameter("content_ID");
String title = request.getParameter("title");
String sessionStyle = "";
if(!"".equals(prefStyleSheet)){
 sessionStyle=prefStyleSheet;
}
/*else{
	sStyle=prefStyleSheet;
}*/
//[IN035950] Ends

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(title));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sessionStyle));
            _bw.write(_wl_block12Bytes, _wl_block12);
String context_value=request.getParameter("PQ");if (context_value==null) context_value="Y";
		//String facility_id= (String) session.getValue("facility_id");//commented for IN065341
		String loginuser=(String) session.getValue( "login_user" ) ;  //IN037701
		java.util.Properties property = (java.util.Properties) session.getValue( "jdbc" ) ;
		String locale = (String) property.getProperty("LOCALE");
		
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(context_value));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);


	Connection conn= null;

	PreparedStatement stmt =null, stmt1 = null,stmt2 = null,stmt3=null; // PreparedStatement stmt_11=null;
//	ResultSet rs	 =null, rs_11=null, rs1 = null,rs2 = null;
	ResultSet rs	 =null, rs1 = null,rs2 = null,rs3=null;
//	boolean rsval= true;
	String onset_date = "";//IN037701
	String diag_class_desc = "";//IN037701
	String onset_pract_name ="";//IN037701
	String curr_remarks="";//38981
	if (context_value ==null) context_value ="O";
	boolean isSiteSpecific=false;//IN069327

	String diagdesc ="";
	String patientid=request.getParameter("patient_id");
	//IN065341 starts
	String called_from=request.getParameter("called_from")==null?"":request.getParameter("called_from");
	String RepDb=request.getParameter("RepDb")==null?"":request.getParameter("RepDb");
	String encounter_id="";
	String facility_id="";
	if(called_from.equals("CDR")){
		 encounter_id = request.getParameter("enc_id1")==null?"":request.getParameter("enc_id1");
		 facility_id = request.getParameter("facility_id1")==null?"":request.getParameter("facility_id1");
	}else{//IN065341 ends
		 encounter_id=request.getParameter("encounter_id");
		 facility_id= (String) session.getValue("facility_id");
	}//IN065341
	String mode=request.getParameter("mode");
	
	String authorize = (request.getParameter("authorize")==null)?"N":request.getParameter("authorize");

	String contentId = request.getParameter("content_ID"); // added for CRF-018
	String f_authorize_yn="N";
    String classValue="";
    String termSetDesc="";
    String termSetDesc_prev="";
    String complaint_id="";
    String complaint_desc="";
    String onset_datetime="";//IN061896
//    String prob_cnt_str="";
    String diag_code="";
    String term_set_id="";
    String short_desc="";
    String curr_enc_yn="";
    String oh_accession_num="";
    String support_exisist_yn="";//38981
//	String oh_chart_num ="";
	String curr_accuracy_ind ="";
	String term_code_short_desc ="";
    	String term_code_short_desc_1 ="";//IN067855
	String complaint_id_lyr ="";
	String complaint_desc_lyr ="";
	String onset_datetime_lyr ="";
	String diag_code_disp ="";
	String occur_srl_no ="";
	String linkviewcnt_sql = "";
	int view_cnt = 0;
	int prob_cnt=0;
	int index=0;
	String high_risk_code="";//IN030460
	StringBuffer layer = new StringBuffer();
	int recordCount =0;//IN035950
	if(mode==null)
	{
	
		f_authorize_yn="N";
	}

try
{

	conn = ConnectionManager.getConnection(request);
	//IN069327 starts	
	 isSiteSpecific = CommonBean.isSiteSpecific(conn, "MR","ALLOW_MULTI_DESC");
	//IN069327 ends
//	String scheme="";
	String sensitive_exist_yn="N";
	//String SqlFindSensitive ="Select 'Y' from PR_DIAGNOSIS A,MR_TERM_CODE D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N') ='Y' AND ROWNUM=1 ";
	String SqlFindSensitive ="Select 'Y' from PR_DIAGNOSIS ##REPDB## A,MR_TERM_CODE ##REPDB## D WHERE D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N') ='Y' AND ROWNUM=1 ";//IN065341
	SqlFindSensitive=SqlFindSensitive.replaceAll("##REPDB##", RepDb);//IN065341

	stmt = conn.prepareStatement(SqlFindSensitive);
	stmt.setString(1,patientid);
	rs = stmt.executeQuery();
	while(rs.next())
		sensitive_exist_yn = rs.getString(1) == null ? "N" : rs.getString(1);

	if(rs != null) rs.close();
	if(stmt != null) stmt.close();
// IN037701 Start.
	if("CA_SPC".equals(p_called_from)){
	//IN065341 starts
		//stmt = conn.prepareStatement("SELECT VW_SEN_DIAG_FOR_CONS_PAT_YN access_rights_yn FROM MR_USER_ACCESS_RIGHTS WHERE APPL_USER_ID=? AND FACILITY_ID=?");
		String sql1 = "SELECT VW_SEN_DIAG_FOR_CONS_PAT_YN access_rights_yn FROM MR_USER_ACCESS_RIGHTS ##REPDB## WHERE APPL_USER_ID=? AND FACILITY_ID=?";
		sql1=sql1.replaceAll("##REPDB##", RepDb);
		stmt = conn.prepareStatement(sql1);
	//IN065341 ends
		stmt.setString(1,loginuser);
		stmt.setString(2,facility_id);
		rs = stmt.executeQuery();
		while(rs.next())
			authorize = (String)rs.getString("access_rights_yn");
		sensitive_exist_yn = "N";
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
	}
//IN037701 End.	
	//String Sql="SELECT A.TERM_SET_ID,A.OCCUR_SRL_NO, to_char(A.ONSET_DATE,'dd/mm/yyyy') onset_date, D.sensitive_yn, D.SHORT_DESC||'('|| A.TERM_CODE||')'||NVL2(A.CURR_REMARKS,'<br><B>Remarks</B>:'||CURR_REMARKS,null)  diag_desc,a.TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme,C.TERM_SET_DESC diag_code_scheme_desc,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn,a.accession_num,a.curr_accuracy_ind FROM PR_DIAGNOSIS A,MR_TERM_CODE D, MR_TERM_SET C where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N')) /*and A.TERM_SET_ID=?  and nvl(A.ONSET_STATUS,'N')='N'  and close_date is null */ order by A.ONSET_DATE desc,diag_scheme";//IN030460
	//String Sql="SELECT A.TERM_SET_ID,A.OCCUR_SRL_NO, to_char(A.ONSET_DATE,'dd/mm/yyyy') onset_date, D.sensitive_yn, D.SHORT_DESC||'('|| A.TERM_CODE||')'||NVL2(A.CURR_REMARKS,'<br><B>Remarks</B>:'||CURR_REMARKS,null)  diag_desc,a.TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme,C.TERM_SET_DESC diag_code_scheme_desc,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn,a.accession_num,a.curr_accuracy_ind,d.HIGH_RISK_CODE FROM PR_DIAGNOSIS A,MR_TERM_CODE D, MR_TERM_SET C where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N')) /*and A.TERM_SET_ID=?  and nvl(A.ONSET_STATUS,'N')='N'  and close_date is null */ order by A.ONSET_DATE desc,diag_scheme";//IN030460
	//String Sql="SELECT A.TERM_SET_ID,A.OCCUR_SRL_NO, to_char(A.ONSET_DATE,'dd/mm/yyyy') onset_date, D.sensitive_yn, D.SHORT_DESC||'('|| A.TERM_CODE||')'||NVL2(A.CURR_REMARKS,'<br><B>Remarks</B>:'||CURR_REMARKS,null)  diag_desc,mr_get_desc.mr_term_code (a.term_set_id, a.term_code,'"+locale+"','2' ) TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme,C.TERM_SET_DESC diag_code_scheme_desc,(SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL g where g.TERM_SET_ID=A.TERM_SET_ID and (g.TERM_CODE=A.TERM_CODE OR g.TERM_CODE_SHORT_DESC=A.TERM_CODE_SHORT_DESC) AND  ENCOUNTER_ID=? AND  FACILITY_ID=? ) prob_cnt,NVL((select 'Y' from PR_DIAGNOSIS_STATUS where patient_id =a.patient_id and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no and facility_id=? and encounter_id=? and rownum=1),'N')	curr_enc_yn,a.accession_num,a.curr_accuracy_ind,d.HIGH_RISK_CODE FROM PR_DIAGNOSIS A,MR_TERM_CODE D, MR_TERM_SET C where C.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_SET_ID=A.TERM_SET_ID AND D.TERM_CODE=A.TERM_CODE and patient_id=? and  nvl(A.CURR_STATUS,'O') = 'A' and nvl(sensitive_yn,'N')=decode(?,'N','N',NVL(sensitive_yn,'N')) /*and A.TERM_SET_ID=?  and nvl(A.ONSET_STATUS,'N')='N'  and close_date is null */ order by A.ONSET_DATE desc,diag_scheme";//IN030460//IN036001 //Commented for IN030459 CRF -019
	
	//String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc, mr_get_desc.mr_term_code (a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_STATUS WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1), 'N') curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT FROM PR_DIAGNOSIS A, MR_TERM_CODE D, MR_TERM_SET C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N')) /*and A.TERM_SET_ID=? and nvl(A.ONSET_STATUS,'N')='N' and close_date is null */ ORDER BY A.ONSET_DATE DESC, diag_scheme"; // modified for CRF - 019 IN030459
	//String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc, mr_get_desc.mr_term_code (a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS A, MR_TERM_CODE D, MR_TERM_SET C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme"; //  // modified for CRF - 019 IN030459//Changed table name to retrieve curr_enc_yn//commented for IN065341
	//String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc, mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//IN065341//commented for IN067855
	 // String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc,mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE_SHORT_DESC TERM_CODE_SHORT_DESC_1,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//IN067855
		//  String Sql= "SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO,A.CURR_REMARKS, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc,mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE_SHORT_DESC TERM_CODE_SHORT_DESC_1,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn, a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//38981
          String Sql="SELECT   A.TERM_SET_ID, A.OCCUR_SRL_NO,A.CURR_REMARKS, TO_CHAR (A.ONSET_DATE, 'dd/mm/yyyy hh24:mi') onset_date, D.sensitive_yn, ONSET_LOCN_CODE, ONSET_LOCN_TYPE, D.SHORT_DESC || '(' || A.TERM_CODE || ')'|| NVL2 (A.CURR_REMARKS, '<br><B>Remarks</B>:' || CURR_REMARKS, NULL) diag_desc,mr_get_desc.mr_term_code ##REPDB##(a.term_set_id, a.term_code, '"+locale+"','2') TERM_CODE_SHORT_DESC, A.TERM_CODE_SHORT_DESC TERM_CODE_SHORT_DESC_1,A.TERM_CODE diag_code, C.TERM_SET_DESC diag_scheme, C.TERM_SET_DESC diag_code_scheme_desc,(SELECT COUNT ( * ) FROM  PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## g WHERE g.TERM_SET_ID = A.TERM_SET_ID AND (g.TERM_CODE = A.TERM_CODE OR g.TERM_CODE_SHORT_DESC = A.TERM_CODE_SHORT_DESC) AND ENCOUNTER_ID = ? AND FACILITY_ID = ?) prob_cnt, NVL((SELECT 'Y' FROM PR_DIAGNOSIS_ENC_DTL ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ? AND encounter_id = ? AND ROWNUM = 1 AND status in ('A','R')), 'N' ) curr_enc_yn,NVL((select 'Y' from PR_SUPPORT_DIAGNOSIS where patient_id =a.patient_id  and term_set_id=a.term_set_id and term_code  =a.term_code and occur_srl_no =a.occur_srl_no  and rownum=1),'N') support_exisist_yn  , a.accession_num, a.curr_accuracy_ind, d.HIGH_RISK_CODE,(SELECT COUNT( * ) FROM PR_DIAGNOSIS_STATUS ##REPDB## WHERE patient_id = a.patient_id AND term_set_id = a.term_set_id AND term_code = a.term_code AND occur_srl_no = a.occur_srl_no AND facility_id = ?) ENC_CNT,(select short_desc from MR_DIAG_CLASS_LANG_VW ##REPDB## where diag_class_code = a.diag_class_code and language_id = ?) diag_class_desc,AM_GET_DESC.AM_PRACTITIONER ##REPDB##(a.ONSET_PRACTITIONER_ID,?,1) onset_pract_name FROM PR_DIAGNOSIS ##REPDB## A, MR_TERM_CODE ##REPDB## D, MR_TERM_SET ##REPDB## C WHERE C.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_SET_ID = A.TERM_SET_ID AND D.TERM_CODE = A.TERM_CODE AND A.patient_id = ? AND NVL (A.CURR_STATUS, 'O') = 'A' AND NVL (sensitive_yn, 'N') = DECODE (?, 'N', 'N', NVL (sensitive_yn, 'N'))  ORDER BY A.ONSET_DATE DESC, diag_scheme";//38981 
	
     //IN043924 starts
	//String problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id= ? and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime";
	String problem_qry ="";
	if(!encounter_id.equals(""))
		//problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? and a.encounter_id= ? and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime";//IN061896 
		problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint ##REPDB## a where a.facility_id= ? and a.encounter_id= ? and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## b where b.ENCOUNTER_ID= ? AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime";//IN065341
	else
		//problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint a where a.facility_id= ? AND a.encounter_id IN (select ENCOUNTER_ID from pr_encounter where patient_id = ?) and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL b where b.encounter_id IN (select ENCOUNTER_ID from pr_encounter where patient_id = ?) AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime ";//IN061896 
		problem_qry="select a.complaint_id, complaint_desc, a.remarks,to_char(a.onset_datetime,'dd/mm/yyyy hh24:mi') onset_datetime_str,a.added_by_id,to_char(a.added_date,'dd/mm/yyyy hh24:mi') added_date from ca_encntr_chief_complaint ##REPDB## a where a.facility_id= ? AND a.encounter_id IN (select ENCOUNTER_ID from pr_encounter ##REPDB## where patient_id = ?) and  not exists (select 1 from PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## b where b.encounter_id IN (select ENCOUNTER_ID from pr_encounter ##REPDB## where patient_id = ?) AND  b.FACILITY_ID=? and b.complaint_id=a.complaint_id ) order by a.onset_datetime ";//IN065341
	//IN043924 ends
	
//IN065341 starts
	//String linkDiagQry="select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT(a.complaint_id,?,'2') complaint_text,to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and ( a.term_code = ? or  a.term_code_short_desc = ?) AND OCCUR_SRL_NO =? order by a.onset_date desc";
	String linkDiagQry="select a.complaint_id complaint_id, CA_GET_DESC.CA_CHIEF_COMPLAINT ##REPDB##(a.complaint_id,?,'2') complaint_text,to_char(a.onset_date,'dd/mm/yyyy HH24:MI') onset_datetime_str from pr_diagnosis_compl_enc_dtl ##REPDB## a where a.facility_id=? and a.encounter_id=? and a.term_set_id=? and ( a.term_code = ? or  a.term_code_short_desc = ?) AND OCCUR_SRL_NO =? order by a.onset_date desc";
	linkDiagQry=linkDiagQry.replaceAll("##REPDB##",RepDb);
//IN065341 ends
	stmt2 = conn.prepareStatement(linkDiagQry);
	
	problem_qry=problem_qry.replaceAll("##REPDB##", RepDb);//IN065341
	stmt1 = conn.prepareStatement(problem_qry);
	stmt1.setString(1,facility_id);
	//IN043924 starts
	//stmt1.setString(2,encounter_id);
	//stmt1.setString(3,encounter_id);
	if(!encounter_id.equals(""))
	{
		stmt1.setString(2,encounter_id);
		stmt1.setString(3,encounter_id);
	 }
	 else
	 {
		stmt1.setString(2,patientid);
		stmt1.setString(3,patientid);
	 }
	 //IN043924 ends
	stmt1.setString(4,facility_id);
	rs1 = stmt1.executeQuery();
	Sql=Sql.replaceAll("##REPDB##", RepDb);//IN065341
	stmt = conn.prepareStatement(Sql);
	
	stmt.setString(1,encounter_id);
	stmt.setString(2,facility_id);
	stmt.setString(3,facility_id);
	stmt.setString(4,encounter_id);
	stmt.setString(5,facility_id);// added for CRF-018 - IN030459
	stmt.setString(6,locale);//IN037701
	stmt.setString(7,locale);//IN037701
	stmt.setString(8,patientid);  // modified for CRF-018 - IN030459	IN037701
	if(authorize.equals("N"))
		stmt.setString(9,f_authorize_yn);  // modified for CRF-018 - IN030459	
	else
		stmt.setString(9,"Y");  // modified for CRF-018 - IN030459	
	
	rs = stmt.executeQuery();
	if(!called_from.equals("CDR")){//IN065341
	if (sensitive_exist_yn.equals("Y") )
		{
//		System.out.println("Line:284:authorize"+authorize);
		
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(authorize));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(authorize));
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

		}
	}//IN065341

            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block30Bytes, _wl_block30);

	if(sStyle.equals(prefStyleSheet) || "CA_SPC".equals(p_called_from))//IN037701
	{
            _bw.write(_wl_block31Bytes, _wl_block31);
if("CA_SPC".equals(p_called_from)){
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag16(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
}else{
            _bw.write(_wl_block37Bytes, _wl_block37);

            if (_jsp__tag17(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag18(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

            if (_jsp__tag19(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag20(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag21(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!called_from.equals("CDR")){
            _bw.write(_wl_block40Bytes, _wl_block40);
}
            _bw.write(_wl_block41Bytes, _wl_block41);

            if (_jsp__tag22(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block42Bytes, _wl_block42);
}
            _bw.write(_wl_block43Bytes, _wl_block43);

	}
	else
	{
	
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block47Bytes, _wl_block47);

            if (_jsp__tag23(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag24(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag25(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block49Bytes, _wl_block49);

            if (_jsp__tag26(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag27(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);
if(!called_from.equals("CDR")){
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(content_ID));
            _bw.write(_wl_block52Bytes, _wl_block52);
}
            _bw.write(_wl_block53Bytes, _wl_block53);

            if (_jsp__tag28(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block54Bytes, _wl_block54);
}
            _bw.write(_wl_block55Bytes, _wl_block55);

	while(rs1.next())
	{
		recordCount++;//IN035950
		complaint_id =rs1.getString("complaint_id")==null?"":rs1.getString("complaint_id");
		complaint_desc =rs1.getString("complaint_desc")==null?"":rs1.getString("complaint_desc");
		onset_datetime =rs1.getString("onset_datetime_str")==null?"":rs1.getString("onset_datetime_str"); //IN061896 
		onset_datetime = com.ehis.util.DateUtils.convertDate(onset_datetime,"DMYHM","en",locale);//IN061896
		classValue="gridData";

            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(complaint_id));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(complaint_desc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(onset_datetime));
            _bw.write(_wl_block61Bytes, _wl_block61);


	}

 	int row=1;
	String sensitive_yn="N";
	
    while(rs.next())
	{
			recordCount++;
			sensitive_yn=rs.getString("sensitive_yn")==null?"":rs.getString("sensitive_yn");
			
			if(sensitive_yn.equals("Y"))
				classValue="PATQRED";
			else
				classValue="gridData";
						

			diagdesc =rs.getString("diag_desc");
			diag_code =rs.getString("diag_code");
			term_set_id =rs.getString("term_set_id");
			termSetDesc =rs.getString("diag_code_scheme_desc")==null?"":rs.getString("diag_code_scheme_desc");
			term_code_short_desc =rs.getString("TERM_CODE_SHORT_DESC")==null?"":rs.getString("TERM_CODE_SHORT_DESC");
			term_code_short_desc_1 =rs.getString("TERM_CODE_SHORT_DESC_1")==null?"":rs.getString("TERM_CODE_SHORT_DESC_1");//IN067855
			occur_srl_no =rs.getString("OCCUR_SRL_NO")==null?"":rs.getString("OCCUR_SRL_NO");
			high_risk_code =rs.getString("HIGH_RISK_CODE")==null?"":rs.getString("HIGH_RISK_CODE");//IN030460
			curr_remarks = rs.getString("curr_remarks")==null?"":rs.getString("curr_remarks"); //38981
			support_exisist_yn = rs.getString("support_exisist_yn")==null?"":rs.getString("support_exisist_yn"); //38981


			//if(!diag_code.equals("*OTH"))
				diag_code_disp = diag_code;
			//else
			//	diag_code_disp = "";


			prob_cnt= rs.getInt("prob_cnt");
			curr_enc_yn= rs.getString("curr_enc_yn");
			oh_accession_num= rs.getString("accession_num")==null?"":rs.getString("accession_num");
			curr_accuracy_ind= rs.getString("curr_accuracy_ind")==null?"":rs.getString("curr_accuracy_ind");
			//IN037701 Starts
			onset_date = rs.getString("onset_date")==null?"":rs.getString("onset_date");
			onset_date			= com.ehis.util.DateUtils.convertDate(onset_date,"DMYHM","en",locale);//IN037701
			diag_class_desc = rs.getString("diag_class_desc")==null?"":rs.getString("diag_class_desc");
			onset_pract_name = rs.getString("onset_pract_name")==null?"":rs.getString("onset_pract_name");
			//IN037701 Ends
			if(!termSetDesc.equals(termSetDesc_prev))
			{
				//out.println("<tr><td class='columnHeadercenter' colspan='7'><font size=1>"+termSetDesc+"</font></td></tr>");
				//termSetDesc_prev=termSetDesc;
			}
			 
            _bw.write(_wl_block62Bytes, _wl_block62);
 if(!oh_accession_num.equals("")){ 
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block64Bytes, _wl_block64);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block65Bytes, _wl_block65);
}
            _bw.write(_wl_block66Bytes, _wl_block66);
if(curr_enc_yn.equals("Y")){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block67Bytes, _wl_block67);
}else{
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block68Bytes, _wl_block68);
}
            _bw.write(_wl_block69Bytes, _wl_block69);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(termSetDesc));
            _bw.write(_wl_block59Bytes, _wl_block59);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block70Bytes, _wl_block70);
if("CA_SPC".equals(p_called_from)){
            _bw.write(_wl_block63Bytes, _wl_block63);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(termSetDesc));
            _bw.write(_wl_block71Bytes, _wl_block71);
}
            _bw.write(_wl_block72Bytes, _wl_block72);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block73Bytes, _wl_block73);
 if(!"".equals(high_risk_code)){
				
            _bw.write(_wl_block74Bytes, _wl_block74);
}
            _bw.write(_wl_block75Bytes, _wl_block75);
 if(curr_accuracy_ind.equals("U")){
				
            _bw.write(_wl_block76Bytes, _wl_block76);
}
            _bw.write(_wl_block77Bytes, _wl_block77);
            out.print( String.valueOf(diag_code_disp));
            _bw.write(_wl_block77Bytes, _wl_block77);

			if(prob_cnt>0){
				
			
			stmt2.setString(1,locale);
			stmt2.setString(2,facility_id);
			stmt2.setString(3,encounter_id);
			stmt2.setString(4,term_set_id);
			stmt2.setString(5,diag_code);
			stmt2.setString(6,termSetDesc);
			stmt2.setString(7,occur_srl_no);

			rs2 = stmt2.executeQuery();
			layer.setLength(0);
			while(rs2.next())
			{
								
				complaint_id_lyr =rs2.getString("complaint_id")==null?"":rs2.getString("complaint_id");
				complaint_desc_lyr =rs2.getString("complaint_text")==null?"":rs2.getString("complaint_text");
				onset_datetime_lyr =rs2.getString("onset_datetime_str")==null?"":rs2.getString("onset_datetime_str");
				//Date Conversion is done by Archana Dhal on 10/7/2010 related to IN024213.
				onset_datetime_lyr = com.ehis.util.DateUtils.convertDate(onset_datetime_lyr,"DMYHM","en",locale);
				
				layer.append("<tr><td class=gridData nowrap>"+complaint_id_lyr+"</td>"+
							"<td class=gridData>"+complaint_desc_lyr+"</td>"+
							"<td class=gridData>"+onset_datetime_lyr+"</td></tr>");


			}
			if(rs2 != null) rs2.close();

			out.println("<script>detailArray["+index+"]='"+layer.toString()+"';</script>");
            //Below if condition is added by Archana Dhal on 10/14/2010 related to incident no. IN024424.
			if(!diag_code.equals("*OTH"))
			{
					//IN065341 starts	
						//linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND  TERM_CODE = '"+diag_code+"' and OCCUR_SRL_NO='"+occur_srl_no+"'";
						//linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND  TERM_CODE = '"+diag_code+"' and OCCUR_SRL_NO='"+occur_srl_no+"'";//COMMON-ICN-0180
						linkviewcnt_sql="SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID= ? AND  TERM_CODE = ? and OCCUR_SRL_NO= ?";//COMMON-ICN-0180
						
						linkviewcnt_sql=linkviewcnt_sql.replaceAll("##REPDB##", RepDb);
					//IN065341 ends
					  stmt3=conn.prepareStatement(linkviewcnt_sql);
					//COMMON-ICN-0180 STARTS
					  stmt3.setString(1,encounter_id);
					  stmt3.setString(2,facility_id);
					  stmt3.setString(3,diag_code);
					  stmt3.setString(4,occur_srl_no);
					//COMMON-ICN-0180 END
			}
           else
			{
			
	
				/*Below code added by Channaveer B For issue 22594(secod point)*/
				//IN065341 starts	
					//linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO='"+occur_srl_no+"'";
					//linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID='"+encounter_id+"' AND  FACILITY_ID='"+facility_id+"' AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO='"+occur_srl_no+"'";//COMMON-ICN-0180
					linkviewcnt_sql = "SELECT count(*) FROM PR_DIAGNOSIS_COMPL_ENC_DTL ##REPDB## WHERE   ENCOUNTER_ID= ? AND  FACILITY_ID=? AND TERM_CODE_SHORT_DESC = ? and OCCUR_SRL_NO=?";//COMMON-ICN-0180
                    linkviewcnt_sql=linkviewcnt_sql.replaceAll("##REPDB##", RepDb);
				//IN065341 ends
					stmt3=conn.prepareStatement(linkviewcnt_sql);
					//stmt3.setString(1,term_code_short_desc);//Commented for IN067855
					//stmt3.setString(1,term_code_short_desc_1);//IN067855//COMMON-ICN-0180
					//COMMON-ICN-0180 STARTS
					  stmt3.setString(1,encounter_id);
					  stmt3.setString(2,facility_id);
					  stmt3.setString(3,term_code_short_desc_1);
					  stmt3.setString(4,occur_srl_no);
					//COMMON-ICN-0180 END
			}
				
				rs3=stmt3.executeQuery();
			   if(rs3 != null && rs3.next())
			    {
				view_cnt = rs3.getInt(1);
			    }
				if(rs2 != null) rs2.close();		//Checkstyle 4.0 Beta 6
				if(rs3 != null) rs3.close(); //Checkstyle
				if(stmt3 != null) stmt3.close();	//Checkstyle 4.0 Beta 6				
			if(view_cnt !=0 )
				{
				/*End here*/
			
            _bw.write(_wl_block78Bytes, _wl_block78);
            out.print( String.valueOf(index));
            _bw.write(_wl_block79Bytes, _wl_block79);

					}
			
			 index++;
		 }
			
            _bw.write(_wl_block80Bytes, _wl_block80);
if("CA_SPC".equals(p_called_from)){
			if(!isSiteSpecific){
            _bw.write(_wl_block81Bytes, _wl_block81);
if(!diag_code.equals("*OTH")){
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(term_code_short_desc));
            _bw.write(_wl_block83Bytes, _wl_block83);
}
				else{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(term_code_short_desc_1));
            _bw.write(_wl_block84Bytes, _wl_block84);
}
			}else{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(term_code_short_desc_1));
            _bw.write(_wl_block85Bytes, _wl_block85);
}
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(diag_class_desc));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(onset_pract_name));
            _bw.write(_wl_block86Bytes, _wl_block86);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block87Bytes, _wl_block87);
}else{
			if(!isSiteSpecific){
            _bw.write(_wl_block88Bytes, _wl_block88);
if(!diag_code.equals("*OTH")){
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(term_code_short_desc));
            _bw.write(_wl_block89Bytes, _wl_block89);
}
				else{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(term_code_short_desc_1));
            _bw.write(_wl_block84Bytes, _wl_block84);
}
			}else{
            _bw.write(_wl_block82Bytes, _wl_block82);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(term_code_short_desc_1));
            _bw.write(_wl_block90Bytes, _wl_block90);
}
            _bw.write(_wl_block91Bytes, _wl_block91);
            out.print( String.valueOf(classValue ));
            _bw.write(_wl_block60Bytes, _wl_block60);
            out.print( String.valueOf(onset_date));
            _bw.write(_wl_block92Bytes, _wl_block92);
   if(curr_remarks!="")
			{
				out.println("<td class='"+classValue+"' width='8%'><font size=1>");
				//out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('" + curr_remarks+ "')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
                  out.println("<a class='gridLink'  href=\"javascript: ShowRemarksDiag('"+patientid+"','"+diag_code+"','"+term_set_id+"','"+term_code_short_desc+"','"+occur_srl_no+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");//42995
				  out.println("</font></td>");
				
		    }
				
           else
				
           {
				out.print("<td class='"+classValue+"'> &nbsp;</td>");
				
           }
			
            _bw.write(_wl_block93Bytes, _wl_block93);
if(!called_from.equals("CDR")){
            _bw.write(_wl_block94Bytes, _wl_block94);
            out.print( String.valueOf(classValue));
            _bw.write(_wl_block95Bytes, _wl_block95);
            out.print( String.valueOf(patientid));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(diag_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(contentId));
            _bw.write(_wl_block96Bytes, _wl_block96);
}
            _bw.write(_wl_block97Bytes, _wl_block97);
if(support_exisist_yn.equals("Y"))
			{
			out.println("<td class='"+classValue+"' nowrap><font size=1>");
			out.println("<a href=\"javascript: ShowSupportingDiag('" + diag_code+"','"+occur_srl_no+"','"+patientid+"','"+term_set_id+"','"+(java.net.URLEncoder.encode(term_code_short_desc))+"("+diag_code+")"+"')\" >"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.view.label","common_labels")+"</a>");
			out.println("</font></td>");
			}
			else{
			out.println("<td class='"+classValue+"' nowrap>&nbsp<font size=1></font></td>");
			}	
            _bw.write(_wl_block98Bytes, _wl_block98);
}
            _bw.write(_wl_block99Bytes, _wl_block99);

             row++;
	}
	
	//IN035950  Starts
		if(recordCount==0)
		{
		out.println("<table class='grid' width='100%' cellspacing='0' cellpadding='0'><tr><td class='gridData'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCA.NODATAFOUND.label","ca_labels")+"</td></tr>");
		}
	//IN035950  Ends
	
            _bw.write(_wl_block100Bytes, _wl_block100);
            out.print( String.valueOf(p_called_from));
            _bw.write(_wl_block101Bytes, _wl_block101);



}
catch (Exception e){
		//out.println("Errors have occured"+e);//common-icn-0181
		e.printStackTrace();
}

finally
{
		if(rs!=null) rs.close();
		if(rs1!=null) rs1.close();
		if(stmt!=null) stmt.close();
		if(stmt1!=null) stmt1.close();
		if(stmt2!=null) stmt2.close();
		if (conn != null) ConnectionManager.returnConnection(conn,request);
}


            _bw.write(_wl_block102Bytes, _wl_block102);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Complaint.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.onsetdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sensitive.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Set.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Set.label", java.lang.String .class,"key"));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag16.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SupportingDiagCode.label", java.lang.String .class,"key"));
        __tag16.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag17.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag18.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag19.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag20.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag21.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag21.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag22.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SupportingDiagCode.label", java.lang.String .class,"key"));
        __tag22.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag23.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag24.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Problem.label", java.lang.String .class,"key"));
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
        __tag25.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag26.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Date/Time.label", java.lang.String .class,"key"));
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
        __tag27.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.DiagnosisRemarks.label", java.lang.String .class,"key"));
        __tag27.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag28.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SupportingDiagCode.label", java.lang.String .class,"key"));
        __tag28.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
