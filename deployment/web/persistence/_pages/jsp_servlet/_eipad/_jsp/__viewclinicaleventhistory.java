package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import java.sql.*;
import java.io.*;
import eIPAD.clinicaleventhistory.*;
import eIPAD.*;
import java.util.*;

public final class __viewclinicaleventhistory extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/ViewClinicalEventHistory.jsp", 1709118032927L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<title>Insert title here</title>\n<meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n<meta name=\"viewport\"\n\tcontent=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />\n<link rel=\"stylesheet\" href=\"../css/iPadViewClinicalEventHistory.css\" />\n<script src=\"../jquery-1.5.2.min.js\"></script>\n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script>\nfunction loadWidgets()\n{\n\twindow.parent.showLoadingMsg();\n}\n\nfunction collapseExpand(obj,index)\n{\n\tvar tableObject = document.getElementById(\"tableId\"+index);\n\tif(obj.value == \' - \')\n\t{\n\t\ttableObject.style.display = \'none\';\n\t\ttableObject.width=\'100%\';\n\t\tobj.value = \' + \';\n\t}\n\telse if(obj.value == \' + \')\n\t{\n\t\ttableObject.style.display = \'inline\';\n\t\ttableObject.width=\'100%\';\n\t\tobj.value = \' - \';\n\t}\n}\n\nfunction getText(Histrectype,Contrsysid,Accessionnum,Contrsyseventcode)\n{\n\tvar patient_id = \"\";//document.forms[0].patient_id.value;\n\tvar hiddenPatientId = document.getElementById(\"hiddenPatientId\");\n\tif(hiddenPatientId){\n\t\t//alert(hiddenPatientId.value);\n\t\tpatient_id = hiddenPatientId.value;\n\t}\n\t\n\tvar enc_id = \"\";//document.forms[0].enc_id.value;\n\tvar encounterIdCombo = document.getElementById(\"EncounterIDComp\");\n\tif(encounterIdCombo){\n\t\t//alert(\'selected index =\'+encounterIdCombo.selectedIndex+\';options length=\'+encounterIdCombo.length);\n\t\tvar selectedEncounterIndex = encounterIdCombo.selectedIndex;\n\t\tif(selectedEncounterIndex >=0){\n\t\t\tenc_id = encounterIdCombo.options[selectedEncounterIndex].value;\n\t\t\t//alert(enc_id);\n\t\t}\n\t}\n\t\n\tvar win_height\t\t= \"37.5\";\n\tvar win_width\t\t= \"50\";\n\tvar win_scroll_yn\t= \"yes\";\n\n\tif(Histrectype != \'CLNT\'){\n\t\twin_height\t\t= \"37.5\";\n\t\twin_width\t\t= \"50\";\n\t\t//win_top\t\t\t= \"200\";\n\t\t//win_scroll_yn\t= \"no\";\n\t}\n\n\tvar retVal = new String();\n\t//var dialogHeight = \"28\" ;\n\t//var dialogWidth = \"50\" ;\n\t\n\tvar dialogHeight = win_height ;\n\tvar dialogWidth = win_width ;\n\tvar dialogTop = \"122\";\n\tvar status = \"no\";\n\tvar scroll = win_scroll_yn;\n\tvar features = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; status:\"+ status + \"; scroll:\"+ scroll+\";dialogTop :\" + dialogTop;\n\tvar arguments\t= Accessionnum ;\n\t\n\tAccessionnum\t=\tescape(Accessionnum);\n\t\n\tdocument.getElementById(\"notesContentFrame1\").src = \"NotesDetail.jsp?\"+\"Histrectype=\"+Histrectype+\"&Contrsysid=\"+Contrsysid+\"&Accessionnum=\"+Accessionnum+\"&Contrsyseventcode=\"+Contrsyseventcode+\"&patient_id=\"+patient_id+\"&enc_id=\"+enc_id;\n\t$.mobile.changePage(\"#notesContentFrame\", \"pop\", false,false);\n\t//var finalString\t= \"Histrectype=\"+Histrectype+\"&Contrsysid=\"+Contrsysid+\"&Accessionnum=\"+Accessionnum+\"&Contrsyseventcode=\"+Contrsyseventcode+\"&patient_id=\"+patient_id+\"&enc_id=\"+enc_id;//INO30714\n\t//retVal = window.showModalDialog(\"../../eCA/jsp/FlowSheetText.jsp?\"+finalString,arguments,features);\n}\n\nfunction closenotes()\n{\n\t $.mobile.changePage(\"mainpage\",\"pop\", true,false);\n}\n</script>\n</head>\n<body>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script type=\"text/javascript\">\nvar periodCombo = document.getElementById(\"PeriodComp\");\nvar onchangehandler = function(){\n\tvar resultsDivComp = document.getElementById(\"resultsdiv\");\n\tif(resultsDivComp){\n\t\tresultsDivComp.innerHTML = \"\";\t\n\t}\n\t\n\tcalculateTimePeriod();\n\tcalculateToPeriod();\n\tgetEncounterId();\n\tsetTimeout(\"getEventHistoryRecords()\",300);\n\tcollapseAllTables();\n}\n\nvar encounterIdChangeHandler = function(){\n\tvar resultsDivComp = document.getElementById(\"resultsdiv\");\n\tif(resultsDivComp){\n\t\tresultsDivComp.innerHTML = \"\";\t\n\t}\n\tsetTimeout(\"getEventHistoryRecords()\",300);\n\tcollapseAllTables();\n}\n\nvar patientClassChangeHandler = function(){\n\tvar resultsDivComp = document.getElementById(\"resultsdiv\");\n\tif(resultsDivComp){\n\t\tresultsDivComp.innerHTML = \"\";\t\n\t}\n\tgetEncounterId();\n\tsetTimeout(\"getEventHistoryRecords()\",300);\n\tcollapseAllTables();\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t<section id = \"mainpage\" data-role=\"page\" style=\"padding:0px;background:#ffffff\">\n\t<form name=\"viewClinicalEventHist\" id=\"viewClinicalEventHist\" id=\"viewClinicalEventHist\">\n\t\t<div data-role=\"none\" id=\'dvmain\' class=\'divmain\' style=\"padding: 0px\">\n\t\t\t<div data-role=\"none\" class=\"divHeader\">\n\t\t\t\t<table style=\"width: 100%; height: 100%\" border=\"0\" cellpadding=\"0\"\n\t\t\t\t\tcellspacing=\"0\">\n\t\t\t\t\t<tr style=\"width: 100%; height: 100%\">\n\t\t\t\t\t\t<td style=\"width: 95%\" align=\"left\" valign=\"center\"><span\n\t\t\t\t\t\t\tclass=\"spanHeader\">Clinical Event History</span></td>\n\t\t\t\t\t\t<td style=\"width: 5%\" align=\"center\" valign=\"middle\"\n\t\t\t\t\t\t\tonclick=\"loadWidgets()\"><img\n\t\t\t\t\t\t\tsrc=\"../images/Close.png\"></img></td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t<div id=\"dvCriteria\" data-role=\"none\" style = \"height:65px;overflow :none\">\n\t\t\t\t<table style=\"height:65px;width: 100%\" border=\"0\" cellpadding=\"0\"\n\t\t\t\t\tcellspacing=\"0\">\n\t\t\t\t\t<tr style=\"height:30px; width: 100%\">\n\t\t\t\t\t\t<td align=\"left\" valign = \"bottom\" style=\"width: 20%\"><span\n\t\t\t\t\t\t\tclass=\"spanFilterCriteria\">Period</span></td>\n\t\t\t\t\t\t<td align=\"left\" style=\"width: 20%\" valign = \"bottom\"><span\n\t\t\t\t\t\t\tclass=\"spanFilterCriteria\" valign = \"bottom\">Encounter Type</span></td>\n\t\t\t\t\t\t<td align=\"left\" style=\"width: 20%\" valign = \"bottom\"><span\n\t\t\t\t\t\t\tclass=\"spanFilterCriteria\">Encounter ID</span></td>\n\t\t\t\t\t\t<td align=\"left\" style=\"width: 4%\"></td>\n\t\t\t\t\t\t<td align=\"left\" style=\"width: 36%\" valign = \"bottom\">\n\t\t\t\t\t\t   <span id=\"EncounterPeriodFullText\" class=\"spanEncounterPeriod1\">Encounter Period: </span>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t\t<tr style=\"height:35px; width: 100%\">\n\t\t\t\t\t\t<td align=\"left\" style=\"width: 20%\" valign = \"top\">\n\t\t\t\t\t\t<select id=\"PeriodComp\" data-role=\"none\" class=\"cmbFilterBy\" onchange=\"\">\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t\t\t\t<option value=\"LOD\" selected=\"selected\">Last One Day</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\t\n\t\t\t\t\t\t\t\t<option value=\"LOD\">Last One Day</option>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t\t\t\t\t\t\t<option value=\"LTD\" selected=\"selected\">Last Three Days</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t\t\t\t\t\t\t\t<option value=\"LTD\">Last Three Days</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t\t\t\t\t<option value=\"LOW\" selected=\"selected\">Last One Week</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\n\t\t\t\t\t\t\t\t<option value=\"LOW\">Last One Week</option>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t<option value=\"LOM\" selected=\"selected\">Last One Month</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\n\t\t\t\t\t\t\t\t<option value=\"LOM\">Last One Month</option>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t\t<option value=\"LOY\" selected=\"selected\">Last One Year</option>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\t\n\t\t\t\t\t\t\t\t<option value=\"LOY\">Last One Year</option>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"left\" style=\"width: 20%\" valign = \"top\">\n\t\t\t\t\t\t<select\n\t\t\t\t\t\t\tid=\"encounterTypeComp\" data-role=\"none\" class=\"cmbFilterBy\">\n\t\t\t\t\t\t\t<option value=\"OP\">Outpatient</option>\n\t\t\t\t\t\t\t<option selected=\"selected\" value=\"IP\">Inpatient</option>\n\t\t\t\t\t\t\t<option value=\"DC\">Daycare</option>\n\t\t\t\t\t\t\t<option value=\"EM\">Emergency</option>\t\n\t\t\t\t\t\t</select>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"left\" style=\"width: 20%\" valign = \"top\">\n\t\t\t\t\t\t<select\n\t\t\t\t\t\t\tid=\"EncounterIDComp\" data-role=\"none\" class=\"cmbFilterBy\">\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<option>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</option>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t</select></td>\n\t\t\t\t\t\t<td align=\"right\" style=\"width: 4%;padding-right:5px;\" valign = \"top\">\n\t\t\t\t\t\t&nbsp;\n\t\t\t\t\t\t\n\t\t\t\t\t\t</td>\n\t\t\t\t\t\t<td align=\"left\" style=\"width : 36%\" valign = \"top\">\n\t\t\t\t\t\t\n\t\t\t\t\t\t<table border=\"0\" style=\"width : 100%\">\n\t\t\t\t\t\t  <!-- \n\t\t\t\t\t\t    <tr>\n\t\t\t\t\t\t\t     <td align=\"left\" valign = \"top\">\n\t\t\t\t\t\t\t        <span id=\"EncounterPeriodFullText\" class=\"spanEncounterPeriod1\">Encounter Period: </span>\n\t\t\t\t\t\t\t     </td>\n\t\t\t\t\t\t\t     <td>\n\t\t\t\t\t\t\t       &nbsp;\n\t\t\t\t\t\t\t     </td>\n\t\t\t\t\t\t\t        <td>\n\t\t\t\t\t\t\t       &nbsp;\n\t\t\t\t\t\t\t     </td>\n\t\t\t\t\t\t\t        <td>\n\t\t\t\t\t\t\t       &nbsp;\n\t\t\t\t\t\t\t     </td>\n\t\t\t\t\t\t    </tr>\n\t\t\t\t\t\t     -->\n\t\t\t\t\t\t\t<tr style = \"width:100%\">\n\t\t\t\t\t\t\t  <td style = \"width:100%\">\n\t\t\t\t\t\t\t    <table border=\"0\" style=\"width:100%\" cellspacing = \"0\" cellpadding = \"0\">\n\t\t\t\t\t\t\t       <tr>\n\t\t\t\t\t\t\t\t\t\t<td align=\"left\" style = \"width:5%\">\n\t\t\t\t\t\t\t\t\t\t<span id=\"EncounterPeriodFromText\" class=\"spanEncounterPeriod1\">From</span>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style = \"width:45%\">\n\t\t\t\t\t\t\t\t\t\t<span id=\"EncounterPeriodFromValue\" class=\"spanEncounterPeriod1\"></span>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style = \"width:5%\">\n\t\t\t\t\t\t\t\t\t\t<span id=\"EncounterPeriodToText\" class=\"spanEncounterPeriod1\">To</span>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t\t<td align=\"center\" style = \"width:45%\">\n\t\t\t\t\t\t\t\t\t\t<span id=\"EncounterPeriodToValue\" class=\"spanEncounterPeriod1\"></span>\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t  </td>\t\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t\t</td>\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t\t</div>\n\t\t\t\n\t\t\t<input type=\"hidden\" id=\"hiddenPatientId\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\"/>\n\t\t\t<input type=\"hidden\" id=\"hiddenFacilityId\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"/>\n\t\t\t<input type=\"hidden\" id=\"hiddenPatientClass\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\"/>\n\t\t\t<input type=\"hidden\" id=\"hiddenLastPatientClass\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\"/>\n\t\t\t\n\t</form>\n\t<div id=\"resultsdiv\" style=\"min-height: 381px;\">\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\n\t\n\t</div>\n\t\n\t<div id=\"icondiv\" style=\"width:100%;height:15%;background:#ffffff\">\n\t  <table width=\"80%\" border=0>\n\t  \t<tr>\n\t  \t\t<td width=\"8%\" align=\"center\">\n\t  \t\t\t<img src=\"../images/NI_High.gif\"/>\n\t  \t\t\t<span>High</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"8%\" align=\"center\">\n\t  \t\t\t<img src=\"../images/NI_Low.gif\"/>\n\t  \t\t\t<span>Low</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"12%\" align=\"center\">\n\t  \t\t\t<img src=\"../images/NI_Abnormal.gif\"/>\n\t  \t\t\t<span>Abnormal</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"10%\" align=\"center\">\n\t  \t\t\t<img src=\"../images/NI_Critical.gif\"/>\n\t  \t\t\t<span>Critical</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"15%\" align=\"center\">\n\t  \t\t\t<img src=\"../images/NI_CriticallyHigh.gif\"/>\n\t  \t\t\t<span>Critical High</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"15%\" align=\"center\">\n\t  \t\t\t<img src=\"../images/NI_CriticallyLow.gif\"/>\n\t  \t\t\t<span>Critical Low</span>\n\t  \t\t</td>\n\t  \t\t<td width=\"10%\" align=\"center\">\n\t  \t\t\t<img src=\"../images/NI_Normal.gif\"/>\n\t  \t\t\t<span>Normal</span>\n\t  \t\t</td>\n\t  \t</tr>\n\t  </table>\n\t  </div>\n\t\n\t\n\t</section>\n\t\n\t<section id=\"notesContentFrame\" data-role = \"page\" style = \"background-color: #ffffff;padding:0px\">\n\t  <div  style = \"height:auto;overflow:auto;padding:0px;background-color: #ffffff\" data-role = \"none\">\n     \t<iframe frameborder=\"0\" id=\"notesContentFrame1\" src=\"\" scrolling =\"yes\" style=\"padding:0px;display:block\" width = \"100%\"  ></iframe>\n     </div>\n\t</section>\n\t\n\t<script>\n\twindow.onload = initializeFunction;\n\t\n\t\tfunction initializeFunction(){\n\t\t\tbindFunction();\n\t\t\tcalculateTimePeriod();\n\t\t\tcalculateToPeriod();\n\t\t\tsetPatientClass();\n\t\t\t//getEventHistoryRecords();\n\t\t\tsetTimeout(\"getEventHistoryRecords()\",300);\n\t\t\tcollapseAllTables();\n\t\t}\n\t\n\t\tfunction bindFunction(){\n\t\t\tvar periodCombo = document.getElementById(\"PeriodComp\");\n\t\t\tif(periodCombo){\n\t\t\t\tperiodCombo.onchange=onchangehandler;\t\n\t\t\t}\n\t\t\tvar encounterIdCombo = document.getElementById(\"EncounterIDComp\");\n\t\t\tif(encounterIdCombo){\n\t\t\t\tencounterIdCombo.onchange = encounterIdChangeHandler;\n\t\t\t}\n\t\t\tvar patientClassCombo = document.getElementById(\"encounterTypeComp\");\n\t\t\tvar selectedPatientClass;\n\t\t\tif (patientClassCombo) {\n\t\t\t\tpatientClassCombo.onchange = patientClassChangeHandler;\n\t\t\t}\n\t\t}\n\t\n\t\tfunction calculateTimePeriod() {\n\t\t\tvar periodCombo = document.getElementById(\"PeriodComp\");\n\t\t\t\n\t\t\tvar selectedValue;\n\t\t\tif (periodCombo) {\n\t\t\t\tselectedValue = periodCombo.options[periodCombo.selectedIndex].value;\n\t\t\t}\n\n\t\t\tvar xmlHttp = getHttpObject();\n\t\t\txmlHttp.onreadystatechange=function(){\n\t\t\t\t//alert(xmlHttp.readyState+\' \'+xmlHttp.status);\n\t\t\t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\n\t\t\t\t\t//alert(xmlHttp.responseText);\n\t\t\t\t\tdocument.getElementById(\"EncounterPeriodFromValue\").innerHTML=xmlHttp.responseText;\n\t\t\t\t\t\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\txmlHttp.open(\"POST\", \"../../servlet/eIPAD.clinicaleventhistory.servlet.EncounterPeriodServlet\", true);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\tvar sendString = \"timeperiod=\"+selectedValue+\"&datetype=From\";\n\t\t\txmlHttp.send(sendString);\n\n\t\t}\n\t\t\n\t\tfunction calculateToPeriod(){\n\t\t\t//alert(\'in second function\');\n\t\t\tvar xmlHttp2 = getHttpObject();\n\t\t\txmlHttp2.onreadystatechange=function(){\n\t\t\t\t//alert(xmlHttp2.readyState+\' \'+xmlHttp2.status);\n\t\t\t\tif(xmlHttp2.readyState==4 && xmlHttp2.status==200){\n\t\t\t\t\tdocument.getElementById(\"EncounterPeriodToValue\").innerHTML=xmlHttp2.responseText;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\txmlHttp2.open(\"POST\", \"../../servlet/eIPAD.clinicaleventhistory.servlet.EncounterPeriodServlet\", true);\n\t\t\txmlHttp2.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\tvar sendString = \"datetype=To\";\n\t\t\txmlHttp2.send(sendString);\n\t\t}\n\t\t\n\t\tfunction getHttpObject(){\n\t\t\tvar xmlHttp;\n\t\t\tif (window.XMLHttpRequest) {\n\t\t\t\txmlHttp = new XMLHttpRequest();\n\t\t\t} else if (window.ActiveXObject) {\n\t\t\t\txmlHttp = new ActiveXObject(\"Microsoft.XMLHTTP\");\n\t\t\t}\n\t\t\treturn xmlHttp;\n\t\t}\n\t\t\n\t\tfunction getEventHistoryRecords(){\n\t\t\tvar periodCombo = document.getElementById(\"PeriodComp\");\n\t\t\tvar selectedPeriod;\n\t\t\tif (periodCombo) {\n\t\t\t\tselectedPeriod = periodCombo.options[periodCombo.selectedIndex].value;\n\t\t\t\t//selectedPeriod = \"LTY\";\n\t\t\t}\n\t\t\t\n\t\t\tvar encounterIdCombo = document.getElementById(\"EncounterIDComp\");\n\t\t\tvar selectedEncounterId=\"\";\n\t\t\tif(encounterIdCombo){\n\t\t\t\t//alert(\'selected index =\'+encounterIdCombo.selectedIndex+\';options length=\'+encounterIdCombo.length);\n\t\t\t\tvar selectedEncounterIndex = encounterIdCombo.selectedIndex;\n\t\t\t\tif(selectedEncounterIndex >=0){\n\t\t\t\t\tselectedEncounterId = encounterIdCombo.options[selectedEncounterIndex].value;\t\n\t\t\t\t}else{\n\t\t\t\t\tvar resultsDivComp = document.getElementById(\"resultsdiv\");\n\t\t\t\t\tresultsDivComp.innerHTML = \"<table style = \'height:100px;width:100%\'><tr style = \'height:100%;width:100%\'><td style = \'height:100%;width:100%\' align = \'center\' valign = \'top\'><span style = \'font-name:Arial;font-size:12pt\'>No Records Found</span></td></tr> </table>\";//\"<span>No records found for the selected values</span>\";\n\t\t\t\t\treturn false;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\tvar patientClassCombo = document.getElementById(\"encounterTypeComp\");\n\t\t\tvar selectedPatientClass;\n\t\t\tif (patientClassCombo) {\n\t\t\t\tselectedPatientClass = patientClassCombo.options[patientClassCombo.selectedIndex].value;\n\t\t\t}\n\t\t\t\n\t\t\tvar hiddenPatientIdComp = document.getElementById(\"hiddenPatientId\");\n\t\t\tvar patientId;\n\t\t\tif(hiddenPatientIdComp){\n\t\t\t\tpatientId = hiddenPatientIdComp.value;\n\t\t\t}\n\t\t\tvar hiddenFacilityIdComp = document.getElementById(\"hiddenFacilityId\");\n\t\t\tvar facilityId;\n\t\t\tif(hiddenFacilityIdComp){\n\t\t\t\tfacilityId = hiddenFacilityIdComp.value;\n\t\t\t}\n\t\t\t\n\t\t\tvar xmlHttp = getHttpObject();\n\t\t\txmlHttp.onreadystatechange=function(){\n\t\t\t\t//alert(xmlHttp.readyState+\' \'+xmlHttp.status);\n\t\t\t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\n\t\t\t\t\t//alert(xmlHttp.responseText);\n\t\t\t\t\tdocument.getElementById(\"resultsdiv\").innerHTML=xmlHttp.responseText;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\txmlHttp.open(\"POST\", \"../../servlet/eIPAD.clinicaleventhistory.servlet.ClinicalEventHistoryServlet\", true);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\tvar sendString = \"selectedperiod=\"+selectedPeriod+\"&patientclass=\"+selectedPatientClass+\"&encounter_id=\"+selectedEncounterId+\"&patientid=\"+patientId+\"&facility_id=\"+facilityId;\n\t\t\tsendString += \"&episode_type=B\"+\"&hist_type=&event_class=&event_group=&event_item=&event_date=&abnormal=N&normalcy=I&viewconfres=E&performed_by=&errorEvent=&episode_wise=N&viewby=E&graphorder=desc&show_mode=C&relationship_id=\";\n\t\t\txmlHttp.send(sendString);\n\t\t}\n\t\t\n\t\tfunction getEncounterId(){\n\t\t\tvar periodCombo = document.getElementById(\"PeriodComp\");\n\t\t\tvar selectedPeriod;\n\t\t\tif (periodCombo) {\n\t\t\t\tselectedPeriod = periodCombo.options[periodCombo.selectedIndex].value;\n\t\t\t}\n\t\t\t\n\t\t\tvar patientClassCombo = document.getElementById(\"encounterTypeComp\");\n\t\t\tvar selectedPatientClass;\n\t\t\tif (patientClassCombo) {\n\t\t\t\tselectedPatientClass = patientClassCombo.options[patientClassCombo.selectedIndex].value;\n\t\t\t}\n\t\t\n\t\t\tvar hiddenPatientIdComp = document.getElementById(\"hiddenPatientId\");\n\t\t\tvar patientId;\n\t\t\tif(hiddenPatientIdComp){\n\t\t\t\tpatientId = hiddenPatientIdComp.value;\n\t\t\t}\n\t\t\tvar hiddenFacilityIdComp = document.getElementById(\"hiddenFacilityId\");\n\t\t\tvar facilityId;\n\t\t\tif(hiddenFacilityIdComp){\n\t\t\t\tfacilityId = hiddenFacilityIdComp.value;\n\t\t\t}\n\t\t\t\n\t\t\tvar xmlHttp = getHttpObject();\n\t\t\txmlHttp.onreadystatechange=function(){\n\t\t\t\t//alert(xmlHttp.readyState+\' \'+xmlHttp.status);\n\t\t\t\tif(xmlHttp.readyState==4 && xmlHttp.status==200){\n\t\t\t\t\tvar encounterIdComp = document.getElementById(\"EncounterIDComp\");\n\t\t\t\t\tif(encounterIdComp){\n\t\t\t\t\t\tencounterIdComp.options.length = 0;\n\t\t\t\t\t}\n\t\t\t\t\t//alert(\'response for getencounterid=\'+xmlHttp.responseText);\n\t\t\t\t\tif(encounterIdComp){\n\t\t\t\t\t\tencounterIdComp.innerHTML = xmlHttp.responseText;\n\t\t\t\t\t}\n\t\t\t\t\t//document.getElementById(\"EncounterIDComp\").innerHTML=xmlHttp.responseText;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t\txmlHttp.open(\"POST\", \"../../servlet/eIPAD.clinicaleventhistory.servlet.EncounterIdServlet\", true);\n\t\t\txmlHttp.setRequestHeader(\"Content-type\",\"application/x-www-form-urlencoded\");\n\t\t\tvar sendString = \"selectedperiod=\"+selectedPeriod+\"&patientclass=\"+selectedPatientClass+\"&patientid=\"+patientId+\"&facility_id=\"+facilityId;\n\t\t\t//sendString += \"&episode_type=B\"+\"&hist_type=&event_class=&event_group=&event_item=&event_date=&abnormal=&normalcy=&viewconfres=E&performed_by=&errorEvent=&episode_wise=N&view_by=E&graphorder=desc&show_mode=C&relationship_id=\";\n\t\t\txmlHttp.send(sendString);\n\t\t\t\n\t\t}\n\t\t\n\t\tfunction setPatientClass(){\n\t\t\tvar hiddenLastPatientClassComp = document.getElementById(\"hiddenLastPatientClass\");\n\t\t\tvar hiddenLastPatientClass=\"\";\n\t\t\tif(hiddenLastPatientClassComp){\n\t\t\t\thiddenLastPatientClass = hiddenLastPatientClassComp.value;\n\t\t\t}\n\t\t\t\n\t\t\tvar encounterTypeComp = document.getElementById(\"encounterTypeComp\");\n\t\t\tif(encounterTypeComp){\n\t\t\t\t//alert(\'inside comparison\');\n\t\t\t\tif(hiddenLastPatientClass == \"IP\"){\n\t\t\t\t\tencounterTypeComp.selectedIndex = 1;\t\n\t\t\t\t}else if(hiddenLastPatientClass == \"OP\"){\n\t\t\t\t\tencounterTypeComp.selectedIndex = 0;\n\t\t\t\t}else if(hiddenLastPatientClass == \"DC\"){\n\t\t\t\t\tencounterTypeComp.selectedIndex = 2;\n\t\t\t\t}else if(hiddenLastPatientClass == \"EM\"){\n\t\t\t\t\tencounterTypeComp.selectedIndex = 3;\n\t\t\t\t}\t\n\t\t\t}\n\t\t\t\n\t\t\t\n\t\t}\n\t\t\n\t\tfunction collapseAllTables(){\n\t\t\tvar index = 1;\n\t\t\tvar tableObj;\n\t\t\t//alert(\'in collapse function\');\n\t\t\twhile(true){\n\t\t\t\ttableObj = document.getElementById(\"tableId\"+index);\n\t\t\t\t//alert(tableObj);\n\t\t\t\tif(tableObj){\n\t\t\t\t\t//tableObj.style.display = \'none\';\n\t\t\t\t\tindex++;\n\t\t\t\t}else{\n\t\t\t\t\tbreak;\n\t\t\t\t}\n\t\t\t}\n\t\t\t\n\t\t}\n\t\t\n\t\tfunction changeOrientation(orient)\n\t\t{\n\t\t\tif(orient == \"landscape\")\n\t\t\t   {\n\t\t\t\t\n\t\t\t    $(\"#notesContentFrame1\").css(\'min-height\',\'491px\');\n\t\t\t\n\t\t\t    document.getElementById(\"notesContentFrame1\").contentWindow.changeOrientation(orient);\n\t\t\t   \n\t\t\t\t   \n\t\t\t   }\n\t\t     else\n\t\t\t   {\n\t\t    \t\n\t\t    \t$(\"#notesContentFrame1\").css(\'min-height\',\'747px\');\n\t\t \n\t\t    \t document.getElementById(\"notesContentFrame1\").contentWindow.changeOrientation(orient);\n\t\t    \n\t\t  \t   \n\t\t\t   }\n\t\t}\n\t</script>\n\t\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String patientid = request.getParameter("patient_id");
	if (patientid == null) {
		patientid = "";
	}
	String facilityid = request.getParameter("facility_id");
	if (facilityid == null) {
		facilityid = "";
	}
	String patientList = request.getParameter("patientlist");
	if (patientList == null || patientList.trim().equals("")) {
		patientList = request.getParameter("hiddenPatientClass");
		patientList = CommonBean.checkForNull(patientList,IPADConstants.INPATIENT_KEYWORD);
	}
	
	String selectedTimePeriod = request.getParameter("selectedperiod");
	if(selectedTimePeriod == null || selectedTimePeriod.trim().equals("")){
		selectedTimePeriod = IPADConstants.LAST_ONE_DAY;
	}

	// get the patient class data
	PatientClassRequest patientClassRequest = new PatientClassRequest();
	patientClassRequest.setPatientId(patientid);
	patientClassRequest.setFacilityId(facilityid);
	patientClassRequest.setRequest(request);
	patientClassRequest.setSession(session);

	ClinicalEventHistory beanInst = new ClinicalEventHistory();
	String patientClass = "";
	/* PatientClassResponse patientClassResponse = beanInst.getPatientClass(patientClassRequest);
	if(patientClassResponse != null){
		patientClass = patientClassResponse.getPatientClass();
	}
	// just a safe check and reinitialization
	if(patientClass == null){
		patientClass = "";
	} */

	PatientClassAndEncounterIdRequest patClassEncounterIdRequest = new PatientClassAndEncounterIdRequest();
	patClassEncounterIdRequest.setPatientId(patientid);
	patClassEncounterIdRequest.setFacilityId(facilityid);
	patClassEncounterIdRequest.setRequest(request);
	patClassEncounterIdRequest.setSession(session);
	// for the first time when this page is loaded, the selected time period is Last one day
	patClassEncounterIdRequest.setSelectedTimePeriod("LOD");

	PatientClassAndEncounterIdResponse patClassEncounterIdResponse = beanInst
			.getPatientClassAndEncounterIdList(patClassEncounterIdRequest);
	Map<PatientClassResponse, List<EncounterIdContainer>> dataMap = patClassEncounterIdResponse
			.getDataMap();
	Set<PatientClassResponse> patientClassSet = null;
	if (dataMap != null) {
		patientClassSet = dataMap.keySet();
	}
	// this is for storing the last patient class which
	// is obtained from the patient iterator
	String lastPatientClass = null;
	Iterator<PatientClassResponse> patientClassItr = null;
	List<EncounterIdContainer> ipEncounterIdList = new ArrayList<EncounterIdContainer>();
	if (patientClassSet != null && !patientClassSet.isEmpty()) {
		patientClassItr = patientClassSet.iterator();
	}
	
	if (patientClassItr != null) {
		PatientClassResponse patClassResponse = null;
		while (patientClassItr.hasNext()) {
			patClassResponse = patientClassItr.next();
			lastPatientClass = patClassResponse.getPatientClass();
			ipEncounterIdList = dataMap.get(patClassResponse);
		}
	}

            _bw.write(_wl_block3Bytes, _wl_block3);

								if(IPADConstants.LAST_ONE_DAY.equals(selectedTimePeriod)){
								
            _bw.write(_wl_block4Bytes, _wl_block4);

								} else{
								
            _bw.write(_wl_block5Bytes, _wl_block5);

								}
								if(IPADConstants.LAST_THREE_DAYS.equals(selectedTimePeriod)){
								
            _bw.write(_wl_block6Bytes, _wl_block6);

								} else{
									
            _bw.write(_wl_block7Bytes, _wl_block7);

								}
								if(IPADConstants.LAST_ONE_WEEK.equals(selectedTimePeriod)){
								
            _bw.write(_wl_block8Bytes, _wl_block8);

								} else{
								
            _bw.write(_wl_block9Bytes, _wl_block9);

								}
								if(IPADConstants.LAST_ONE_MONTH.equals(selectedTimePeriod)){
								
            _bw.write(_wl_block10Bytes, _wl_block10);

								} else{
								
            _bw.write(_wl_block11Bytes, _wl_block11);

								}
								if(IPADConstants.LAST_ONE_YEAR.equals(selectedTimePeriod)){
								
            _bw.write(_wl_block12Bytes, _wl_block12);

								} else{
								
            _bw.write(_wl_block13Bytes, _wl_block13);

								}
								
            _bw.write(_wl_block14Bytes, _wl_block14);

							if (ipEncounterIdList != null && !ipEncounterIdList.isEmpty()) {
								for (EncounterIdContainer encounterId : ipEncounterIdList) {
						
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(encounterId.getEncounterId()));
            _bw.write(_wl_block16Bytes, _wl_block16);

								}
							}
							
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(patientid ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(facilityid ));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(patientList ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(lastPatientClass));
            _bw.write(_wl_block21Bytes, _wl_block21);

		/* ClinicalEventHistory eventHistory = new ClinicalEventHistory();
		EventHistoryRequest eventHistoryRequest = new EventHistoryRequest();
		eventHistoryRequest.setRequest(request);
		eventHistoryRequest.setSession(session);
		eventHistoryRequest.setPatientId(patientid);
		eventHistoryRequest.setFacilityId(facilityid);
		eventHistoryRequest.setPatientClass(patientList);
		eventHistoryRequest.setLocale("en");
		// need to find out how encounter id from the html component
		// can be passed here
		eventHistoryRequest.setEncounterId("");
		eventHistoryRequest.setSelectedTimePeriod("");
		
		EventHistoryResponse eventHistoryResponse = eventHistory
				.getEventHistory(eventHistoryRequest); */
		
	
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
