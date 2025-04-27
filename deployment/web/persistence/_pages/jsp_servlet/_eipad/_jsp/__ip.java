package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.io.*;
import eIPAD.*;
import eIPAD.HealthObjects.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __ip extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/IP.jsp", 1738426031836L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>IP View</title> \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n <link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> \n\n<link rel=\"stylesheet\" href=\"../css/ipad.css\" />  \n<script language=\"javascript\" src=\"../../eCommon/js/jquery-3.6.3.js\"></script>\n\n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script> \n<script type=\"text/javascript\">\n/*\n $(document).bind(\"swipe\", function(event, data){\n\t//alert(\"helloo\")\n\tevent.preventDefault();\t\n });\n */\n var bShCriteria = true;\n function scrolTop()\n {\n\t  //alert(\"helloj\");\n\t window.parent.scrolTop();\n }\n function showCriteria()\n {\n\t $(\'#divSrchCriteria\').slideToggle(\'fast\');\n\t if(bShCriteria)\n\t   {\n\t\t        bShCriteria = false;\n\t\t\t   document.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-Up-Arrow.png\" ;\n\t   }\n\t   else\n\t   {\n\t\t       bShCriteria = true;\n\t\t\t   document.getElementById(\"imgCriteria\").src = \"../images/Heading-Panel-down-Arrow.png\";\n\t   }\n }\n $(document).ready(function () {\n\t window.parent.HideLoadingMsg();\n\t/* \n\t $(document).scroll(function(){\n\t\t alert(\"higip\");\n         if ($(window).scrollTop() + $(window).height() == $(document).height())\n         {\n             \n            alert(\"hi\");\n         }\n     });\n*/\n    if(document.getElementById(\"hdnOrderBy\").value != \"\")\n\t document.getElementById(\"cmbOrderBy\").value = document.getElementById(\"hdnOrderBy\").value;\n });\n function appendIP()\n {\n\t// alert(\"hihih\");\n\t// $(\'#ulIP\').append(\"<li class =\'ui-btn-text-data1\'  >   <a href=\'#\' rel =\'external\' style = \'height:65px\'> <ul style=\'list-style-type: none;\' ><li class=\'firstleftUl\'><img src=\'human.png\'></img> </li></ul> </a></li>\");\n\t// $(\'#ulIP\').append(\"<li class =\'ui-btn-text-data1\'  >   <a href=\'#\' rel =\'external\' style = \'height:65px\'> <ul style=\'list-style-type: none;\' ><li class=\'firstleftUl\'><img src=\'human.png\'></img> </li></ul> </a></li>\");\n\t// $(\'#ulIP\').append(\"<li class =\'ui-btn-text-data1\'  >   <a href=\'#\' rel =\'external\' style = \'height:65px\'> <ul style=\'list-style-type: none;\' ><li class=\'firstleftUl\'><img src=\'human.png\'></img> </li></ul> </a></li>\");\n\t// $(\'#divcnt\').append(\"<ul><li class =\'ui-btn-text-data1\'  >   <a href=\'#\' rel =\'external\' style = \'height:65px\'> <ul style=\'list-style-type: none;\' ><li class=\'firstleftUl\'><img src=\'human.png\'></img> </li></ul> </a></li></ul>\");\n\t//$(\'#divcnt\').append(\"<table><tr><td>ghgh</td></tr></table>\");\n\t// $(\'#divcnt\').append(\"<ul data-role=\'listview\'><li class =\'ui-btn-text-data1\'  >   <a href=\'#\' rel =\'external\' style = \'height:65px\'> <ul style=\'list-style-type: none;\' ><li class=\'firstleftUl\'><img src=\'human.png\'></img> </li></ul> </a></li></ul>\");\n }\n function test()\n {\n\t var i = 0;\n\t// alert(\"hihih\");\n\t for(i=0;i<20;i++)\n\t\t {\n\t      // $(\'#divcnt\').append(\"<ul data-role=\'listview\'><li class =\'ui-btn-text-data1\'  >   <a href=\'#\' rel =\'external\' style = \'height:65px\'> <ul style=\'list-style-type: none;\' ><li class=\'firstleftUl\'><img src=\'human.png\'></img> </li></ul> </a></li></ul>\");\n\t \n        }\n\t // $(\'#divcnt\').append(\"<table style=\'height:100px;width:100%\'><tr><td><span class=\'lz-list-label\'>Naren</span></td><td><img src=\'human.png\'></img> </td></tr></table>\")\n }\n function openPatient(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode)\n {\n\t\n\t window.parent.slidee(\"true\");\n\t\n\t//alert(patientid);\n\t//alert(\"hi\");\n\t//alert(episodeId);\n\twindow.parent.loadwidgets(patientid,episodeId,admitDate,dischargeDateTime,locnType,locnCode,servicecode);\n\t//document.getElementById(\"IpForm\").submit();\n\t//window.open(\"Appointment.html\");\n }\n function show(objBtn)\n {\n\t  //alert(\"hiii\");\n\t    var myBars = \'directories=no,location=no,menubar=no,status=no\' ;\n\t\tvar myOptions = \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=no, fullscreen=yes\' ;\n\t\t//var myFeatures = myBars + \', \' + myOptions ;\n\t\tvar myFeatures =  myOptions ;\n\t\t//var ecisWindow = open( \'iPadWidget.html\', \'iPadWidget.html\', myFeatures,false ) ;\n\t\t\n\t\t//var retval = window.showModalDialog(\"AppView.jsp\", \"\", myFeatures);\n\t\t//$.mobile.changePage(\'#Dialog\',{role:\'dialog\'})\n\t\t//$.mobile.changePage(\'#Dialog\',{role:\'dialog\',transition: \"pop\"})\n\t//\tdocument.getElementById(\"srchFrame\").src = \"appview.html\";\n    //   $.mobile.changePage(\"#Dialog\", \"slide\" , false,false);\n\t\t//alert(\"finished\");\n\t\tobjBtn.style.border = \"3px solid #48d1d8\";\n\t\tdocument.getElementById(\"hdnPatientId\").value = document.getElementById(\"txtPatientId\").value;\n\t\t//document.getElementById(\"hdnClinicianId\").value = document.getElementById(\"txtPracId\").value;\n\t\t//document.getElementById(\"hdnNursingUnit\").value = document.getElementById(\"txtNursingUnit\").value;\n\t\t//document.getElementById(\"hdnSpeciality\").value = document.getElementById(\"txtSpeciality\").value;\n\t\tdocument.getElementById(\"IpForm\").submit();\n\n\n }\n function clearValues()\n {\n\t //alert(\"hiiii\");\n\t    document.getElementById(\"hdnPatientId\").value = \"\";\n\t\tdocument.getElementById(\"txtPatientId\").value = \"\";\n\t\tdocument.getElementById(\"hdnClinicianId\").value = \"\";\n\t\tdocument.getElementById(\"txtPracId\").value = \"\";\n\t\tdocument.getElementById(\"hdnNursingUnit\").value = \"\"; \n\t\tdocument.getElementById(\"txtNursingUnit\").value = \"\";\n\t\tdocument.getElementById(\"hdnSpeciality\").value = \"\";\n\t\tdocument.getElementById(\"txtSpeciality\").value = \"\";\n }\n function test(strCode,strDesc)\n {\n\t// alert(\"ip\");\n\t //$(\"#Dialog\").dialog(\"close\");\n\t //$.mobile.changePage(\'#page1\', \"\" , false,false);\n\t  \n\t  document.getElementById(\"txtNursingUnit\").value = strDesc;\n\t  document.getElementById(\"hdnNursingUnit\").value = strCode;\n\t  \n\t  \n\t  $(\"#IpForm\").toggle(\"fast\");\n\t  $(\"#Dialog\").toggle(\"fast\");\n\t  scrolTop();\n\t  document.getElementById(\"srchFrame\").src = \"\";\n }\n function Practitioner(strCode,strDesc)\n {\n\t  document.getElementById(\"hdnClinicianId\").value = strCode; \n\t  document.getElementById(\"txtPracId\").value  = strDesc;\n\t  $(\"#IpForm\").toggle(\"fast\");\n\t  $(\"#Dialog\").toggle(\"fast\");\n\t  scrolTop();\n\t  document.getElementById(\"srchFrame\").src = \"\";\n }\n function Speciality(strCode,strDesc)\n {\n\t  document.getElementById(\"hdnSpeciality\").value = strCode;\n\t  document.getElementById(\"txtSpeciality\").value = strDesc;\n\t  $(\"#IpForm\").toggle(\"fast\");\n\t  $(\"#Dialog\").toggle(\"fast\");\n\t  scrolTop();\n\t  document.getElementById(\"srchFrame\").src = \"\";\n }\n function showNursingUnit()\n {\n\t \n\t\n\t// $.mobile.changePage(\"#Dialog\", \"slide\" , false,false);\n\t document.getElementById(\"srchFrame\").src = \"NursingUnit.jsp?PracId=\" +  document.getElementById(\"hdnClinicianId\").value;\n\t  $(\"#IpForm\").toggle(\"fast\");\n\t  $(\"#Dialog\").toggle(\"fast\");\n\t \n }\n function showPractitioner()\n {\n\t document.getElementById(\"srchFrame\").src = \"Practitioner.jsp\";\n\t  $(\"#IpForm\").toggle(\"fast\");\n\t  $(\"#Dialog\").toggle(\"fast\");\n\t \n }\n function showspeciality()\n {\n\t document.getElementById(\"srchFrame\").src = \"specialitySFS.jsp\";\n\t  $(\"#IpForm\").toggle(\"fast\");\n\t  $(\"#Dialog\").toggle(\"fast\");\n\t \n }\n function CloseSearchCriteria()\n {\n\t $(\"#IpForm\").toggle(\"fast\");\n\t  $(\"#Dialog\").toggle(\"fast\");\n\t  document.getElementById(\"srchFrame\").src = \"\";\n }\n function fnOrderBy(objCmbOrderBy)\n {\n\t// alert(objCmbOrderBy.value);\n\t document.getElementById(\"hdnOrderBy\").value = objCmbOrderBy.value;\n\t document.getElementById(\"IpForm\").submit();\n }\n function LoadValues()\n {\n\t \n }\n\n\n </script>\n<body style= \"width:100%\" >\n <section id=\"page1\" data-role=\"page\"  style=\"padding:0px;width:100%\"> \n  <form name=\'IpForm\' id=\'IpForm\' method=\'post\' id=\"IpForm\" style = \"width:100%\">\n  <!--  <div style=\"width:100%;height:auto\"></div> -->\n\t  <div id = \"divSrch\"  data-role =\"none\" class=\"dvApp\" onclick = \"showCriteria()\">\n\t\t  <!--  <span class = \"spanDvsrch\">Search</span> -->\n\t\t <!--    <img src = \"Heading-Panel-down-Arrow.png\" class = \"imgg\"></img>  -->\n\t\t <table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  <tr style = \"height:100%;width:100%\">\n\t\t\t    <td style = \"width:95%\">\n\t\t\t         <span class = \"spanDvsrch\">Search</span>\n\t\t\t    </td>\n\t\t\t    <td style = \"width:5%\" align = \"center\" valign = \"center\">\n\t\t\t        <img src = \"../images/Heading-Panel-down-Arrow.png\" id = \"imgCriteria\"></img> \t\n\t\t\t    </td>\n\t\t\t    \n\t\t\t    \n\t\t\t  </tr>\n\t\t    </table>\t  \n\t\t \n\t  </div>\n  \n  <div class = \"dvStroke\" data-role =\"none\"></div> \n\n\t  <div id=\"divSrchCriteria\"  data-role =\"none\"  style = \"display:none;height:auto;padding:0px\" class = \"dvCriteria\">\n\t   \n\t\t   <table style=\"height:135px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\n\t\t\t     <tr style=\"height:30px;width:100%\">\n\t\t\t      <td align = \"left\" style=\"width:33%\"><span class = \"spIpCriteria\">Patient Id</span></td>\n\t\t\t      <td align = \"left\" style=\"width:33%\"><span class = \"spIpCriteria\">Speciality</span></td>\n\t\t\t      <td align = \"left\" style=\"width:33%\"><span class = \"spIpCriteria\">Nursing Unit</span></td>\n\t\t\t      <td style=\"width:1%\">&nbsp;</td>\n\t\t\t     </tr>\n\t\t\t     <tr style=\"height:35px;width:100%\">\n\t\t\t      <td align = \"left\" style=\"width:33%\"><input type = textbox name = \"txtPatientId\" id = \"txtPatientId\"   data-role = \"none\" class = \"tbPatCriteria\" value = \"";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\"/></td>\n\t\t\t      <td align = \"left\" style=\"width:33%\"><input type = textbox data-role = \"none\" name = \"txtSpeciality\" id = \"txtSpeciality\" class = \"tbCriteria\" readonly = \"true\" onclick = \"showspeciality()\" value = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"/></td>\n\t\t\t      <td align = \"left\" style=\"width:33%\"><input type = textbox data-role = \"none\" name = \"txtNursingUnit\" id = \"txtNursingUnit\" class = \"tbCriteria\" readonly = \"true\" onclick = \"showNursingUnit()\" value = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" /></td>\n\t\t\t        <td style=\"width:1%\">&nbsp;</td>\n\t\t\t     </tr>\n\t\t\t     <tr style=\"height:30px;width:100%\">\n\t\t\t      <td align = \"left\" style=\"width:33%\"><span class = \"spIpCriteria\">Practitioner</span></td>\n\t\t\t      <td style=\"width:33%\"></td>\n\t\t\t      <td style=\"width:33%\"></td>\n\t\t\t       <td style=\"width:1%\">&nbsp;</td>\n\t\t\t    \n\t\t\t     </tr>\n\t\t\t\n\t\t\t     <tr style=\"height:35px;width:100%\">\n\t\t\t      <td align = \"left\" style=\"width:33%\"><input type = textbox data-role = \"none\" name = \"txtPracId\"  id = \"txtPracId\" readonly = \"true\" class = \"tbCriteria\" onclick = \"showPractitioner()\" value = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" /></td>\n\t\t\t      <td style=\"width:33%\">&nbsp;</td>\n\t\t\t      <td style=\"width:33%\" nowrap = \"false\">\n\t\t\t        <!--   <input type =\"button\" name=\'search_btn\' id=\'search_btn\' value=\'Search\' class=\"btnType1\" data-role = \"none\" onclick = \"show()\"/><input type =\"button\" name=\'clear_btn\' id=\'clear_btn\' value=\'Clear\' class=\"btnType1\" data-role = \"none\"/>  -->\n\t\t\t      </td>\n\t\t\t       <td style=\"width:1%\">&nbsp;</td>\n\t\t\t     </tr>\n\t\t\t     \n\t\t\t     <tr style=\"height:5px;width:100%\">\n\t\t\t       <td>&nbsp;</td>\n\t\t\t     </tr>\n\t\t   </table>\n\t   \n\t\t      <div id = \"divSrchPanel\" style=\"height:auto\" class = \"dvSrchPanel\" data-role =\"none\">\n\t\t\t      <table style=\"height:44px;width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t        <tr style=\"width:100%\">\n\t\t\t          <td style=\"width:75%\">&nbsp;</td>\n\t\t\t          <td style= \"width:25%\" nowrap = \"false\"> \n\t\t\t            <table style=\"width:100%\" border = \"0\">\n\t\t\t             <tr style=\"width:100%\">\n\t\t\t             <td align = \"right\" valign =\"center\">\n\t\t\t               <input type =\"button\" name=\'search_btn\' id=\'search_btn\' value=\'Search\' class=\"btnType1\"  data-role = \"none\" onclick = \"show(this)\"/>\n\t\t\t             </td>\n\t\t\t             <td style=\"width:7%\"></td> \n\t\t\t             <td> \n\t\t\t               <input type =\"button\" name=\'clear_btn\' id=\'clear_btn\' value=\'Clear\' class=\"btnType1\"  data-role = \"none\" onclick = \"clearValues()\"/>\n\t\t\t             </td>  \n\t\t\t             </tr>\n\t\t\t            </table>\n\t\t\t          </td>\n\t\t\t          <!--  <td style=\"width:1%\">&nbsp;</td>  -->\n\t\t\t        </tr>\n\t\t\t      </table>\n\t     </div>\n\t   </div>\n\t   \n\t  <div  data-role =\"none\" class =\"dvApp\">\n\t\t\t<table style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\" border = \"0\">\n\t\t\t  <tr style = \"height:100%;width:100%\">\n\t\t\t    <td style = \"width:77%\">\n\t\t\t         <span class = \"spanDvsrch\"> InPatients</span>\n\t\t\t    </td>\n\t\t\t    <td style = \"width:23%\" align = \"center\" valign = \"center\">\n\t\t\t        <select data-inline=\"true\" class=\"cmbOrderBy\" data-role=\"none\" id=\"cmbOrderBy\" name = \"cmbOrderBy\" onchange = \"fnOrderBy(this)\" data-native-menu=\"true\"> \t\t\t\t\t\n\t\t\t\t\t\t\t<option value = \"OR\">Order By</option> \n\t\t\t\t\t\t\t<option value = \"patient_name\">Patient Name</option> \n\t\t\t\t\t\t\t<option value = \"physician_name\">Practitioner</option>\t\n\t\t\t\t\t\t\t<option value = \"bed_num\">Bed No</option> \t\t\t\t\n\t\t\t\t\t\t</select> \t\n\t\t\t    </td>\n\t\t\t \n\t\t\t    \n\t\t\t  </tr>\n\t\t    </table>\t  \n\t  </div>\n   <div class = \"dvStroke\"></div> \n     <div id = \'divcnt\'  class = \'divcontent\' >\n\n\t  ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t   \n\t   <table class = \"tbIpContent2\" cellpadding = \"0\" cellspacing = \"0\"  border = \"0\" onclick = \"openPatient(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' , \'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\')\">\n\t        <tr class=\"trIpRows";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" >\n\t           <td style=\"width:6%\" align=\"center\" valign = \"center\">\n\t             ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t              <div class = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" ></div>\n\t              \n\t              ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t            \t   <div class = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" ><font size=5><b>*</b></font></div> \n\t            \t   ";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t           </td>\n\t           <td style = \"width:7%\" align=\"center\" valign = \"center\" >\n\t             <img src=\"../images/Photo-4.png\"  class = \"imgPhoto\"></img>\n\t           </td>\n\t           <td style=\"width:82%\">\n\t             <table style = \"width:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t                <tr class=\"trIpChildRows\">\n\t                         <td style=\"width:100%\" colspan = \"2\" >\n\t                        ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t                          <input type = \"textbox\" class = \"txtRows";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\" data-role = \"none\" readonly = \"true\"/>\n\t                         </td>\n\t                         \n\t                </tr>\n\t                \n\t                <tr class=\"trIpChildRows\">\n\t                   <td style=\"width:60%\" >\n\t                     <span class=\"lz-list-label\">Room,Bed No :</span><span class=\"lz-list-data1\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =",";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</span>  \n\t                    \n\t                   </td>\n\t                    <td style=\"width:40%\" >\n\t                     <span class=\"lz-list-label1\">Adm Date :</span><span class=\"lz-list-data1\">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span>  \n\t                     \n\t                     \n\t                    </td>\n\t                    \n\t                </tr>\n\t                 <tr class=\"trIpChildRows\">\n\t                         <td style=\"width:100%\" colspan = \"2\">\n\t                          <span class=\"lz-list-label\">Practitioner :</span><span class=\"lz-list-data1\">";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</span>\n\t                         </td>\n\t                         \n\t                </tr>\n\t             </table>\n\t           \n\t           </td>\n\t           <td style = \"width:4%\" align = \"center\" valign = \"center\">\n\t             <img src=\"../images/More.png\"  ></img>\n\t           </td>\n\t              <td style = \"width:1%\" align = \"center\" valign = \"center\">  \n\t             \n\t           </td>\n\t        </tr>\n\t   </table>   \n\t   ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t  \n\t\t\t   ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t ";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t  \n\t\t<table class = \"tblegends\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\" >\n\t\t\t<tr style = \"width:100%;height:100%\">\n\t\t\t\t  \n\t\t\t\t  <td style = \"width:75%;height:100%\" class=\"tdlegends\"> \n\t\t\t\t\t  <table style = \"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t         <tr style = \"width:100%;height:52%\">\n\t\t\t\t\t           <td style = \"width:25%;height:100%\" align=\"center\"><div class = \"divLegends\" style=\"background-color:black\"></div> </td>\n\t\t\t\t\t           <td style = \"width:25%;height:100%\" align=\"center\"><div class = \"divLegends\" style=\"background-color:pink\"></div> </td>\n\t\t\t\t\t           <td style = \"width:25%;height:100%\" align=\"center\"><div class = \"divLegends\" style=\"background-color:orange\"></div> </td>\n\t\t\t\t\t        </tr>\n\t\t\t\t\t        <tr style = \"width:100%;height:48%\">\n\t\t\t\t\t           <td style = \"width:25%;height:100%\" align=\"center\" ><span class=\"spLegends\">Deceased </span></td>\n\t\t\t\t\t           <td style = \"width:25%;height:100%\" align=\"center\" nowrap = \"false\"><span class=\"spLegends\">Newborn Exist</span> </td>\n\t\t\t\t\t           <td style = \"width:25%;height:100%\" align=\"center\" ><span class=\"spLegends\">Discharged </span></td>\n\t\t\t\t\t        </tr>\n\t\t\t\t\t     </table>\n\t\t\t\t  \n\t\t\t\t  <td>\n\t\t\t\t  <td style = \"width:25%;height:100%\"> \n\t\t\t\t    <table style = \"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t\t\t\t\t         <tr style = \"width:100%;height:52%\">\n\t\t\t\t\t           <td style = \"width:100%;height:100%\" align=\"center\"><div class = \"dvLegendNoRelation\" ><font size=5><b>*</b></font></div> </td>\n\t\t\t\t\t           \n\t\t\t\t\t        </tr>\n\t\t\t\t\t        <tr style = \"width:100%;height:48%\">\n\t\t\t\t\t           <td style = \"width:100%;height:100%\" align=\"center\" nowrap = \"false\"><span class=\"spLegends\">No PP Relationship </span></td>\n\t\t\t\t\t           \n\t\t\t\t\t        </tr>\n\t\t\t\t\t     </table>\n\t\t\t\t  <td>\n\t\t\t</tr>\n\t\t\n\t\t\n\t\t</table>   \n\t\t\n\t\t\n    </div>\n\n<input type = \"hidden\" name =\"hdnPatientId\" id =\"hdnPatientId\" value = \"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\"/>\n<input type = \"hidden\" name =\"hdnNursingUnit\" id =\"hdnNursingUnit\" value = \"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\"/>\n<input type = \"hidden\" name =\"hdnClinicianId\" id =\"hdnClinicianId\" value = \"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\"/>\n<input type = \"hidden\" name =\"hdnSpeciality\" id =\"hdnSpeciality\" value = \"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\"/>\n<input type = \"hidden\" name =\"hdnOrderBy\" id =\"hdnOrderBy\" value = \"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\"/>\n</form> \n\n <div data-role=\"none\" id=\'Dialog\' style=\"width:100%; height:auto;display:none\">\n     <iframe src = \"\" width = \"100%\" height = \"1000px\" scrolling = \"yes\" id=\"srchFrame\" frameborder=\"0\"></iframe>  \n</div>\n\n</section>\n  \n  ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n</body>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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
            _bw.write(_wl_block0Bytes, _wl_block0);

request.setCharacterEncoding("UTF-8");
InPatientContext oInPatientContext = new InPatientContext();
oInPatientContext.setRequest(request);
String facility_id= ""; //(String)session.getValue("facility_id");
String clinicianId = "" ;//(String)session.getValue("ca_practitioner_id");
String sPatientId = "" ;
String sNursingUnitCode = "";
String sNursingUnit = "";
String sClinicianDesc = "";
String sSpecialityCode = "";
String sSpeciality = "";
String sOrderBy = "";
String sFacilityId = "";
String sPractionerId = "";
String sPractionerDesc = "";
if(session.getValue("facility_id") != null && session.getValue("facility_id") != "")
{
	facility_id = (String)session.getValue("facility_id");
	oInPatientContext.setFacilityId(facility_id);
}

if(session.getValue("ca_practitioner_id") != null && session.getValue("ca_practitioner_id") != "")
{
	clinicianId = (String)session.getValue("ca_practitioner_id");
	oInPatientContext.setClinicianId(clinicianId);
}

String className = "dvLegendNotRequired";
StringTokenizer st = null;
String deceasedYn = "";
int noofchildren = 0;
String relationYn = "";
String tempDischargeDate = "";
String strPatientDetails = "";


if(request.getParameter("hdnPatientId") != null && request.getParameter("hdnPatientId") != "" && request.getParameter("hdnPatientId") != " ")
{
 
	sPatientId = (String)request.getParameter("hdnPatientId");
	oInPatientContext.setPatientId(sPatientId);
 
}

if(request.getParameter("hdnNursingUnit") != null && request.getParameter("hdnNursingUnit") != "" && request.getParameter("hdnNursingUnit") != " ")
{
  
 sNursingUnitCode = (String)request.getParameter("hdnNursingUnit");
// oInPatientContext.setClinicianDesc(sClinicianDesc);
 oInPatientContext.setNursingUnitCode(sNursingUnitCode);
}
if(request.getParameter("hdnClinicianId") != null && request.getParameter("hdnClinicianId") != "" && request.getParameter("hdnClinicianId") != " ")
{

 sPractionerId = (String)request.getParameter("hdnClinicianId");
 oInPatientContext.setPractionerId(sPractionerId);
 
}
if(request.getParameter("hdnSpeciality") != null && request.getParameter("hdnSpeciality") != "" && request.getParameter("hdnSpeciality") != " ")
{

 sSpecialityCode = (String)request.getParameter("hdnSpeciality");
 oInPatientContext.setSpecialityCode(sSpecialityCode);
}

if(request.getParameter("hdnOrderBy") != null &&  request.getParameter("hdnOrderBy") != "")
{
	
	sOrderBy = (String)request.getParameter("hdnOrderBy");
	oInPatientContext.setOrderBy(sOrderBy);
}


if(request.getParameter("txtPracId") != null &&  request.getParameter("txtPracId") != "")
{
	
	sPractionerDesc = (String)request.getParameter("txtPracId");
	oInPatientContext.setPractionerDesc(sPractionerDesc);
}

if(request.getParameter("txtNursingUnit") != null &&  request.getParameter("txtNursingUnit") != "")
{
	
	sNursingUnit = (String)request.getParameter("txtNursingUnit");
	oInPatientContext.setNursingUnit(sNursingUnit);
	
}
if(request.getParameter("txtSpeciality") != null &&  request.getParameter("txtSpeciality") != "")
{
	
	sSpeciality = (String)request.getParameter("txtSpeciality");
	oInPatientContext.setSpeciality(sSpeciality);
	
}


//out.println(sqlStr.toString());






            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(oInPatientContext.getPatientId() ));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(oInPatientContext.getsSpeciality() ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(oInPatientContext.getNursingUnit() ));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(oInPatientContext.getPractionerDesc() ));
            _bw.write(_wl_block5Bytes, _wl_block5);

	  int nClassCount = 1;
	  int cnt = 0;
	  String Status = "";
	  String emergencyYn = "";
	  String n = null;
	  
	  InPatientList bean = new InPatientList();
	  List<InPatients> objInPatientList = new ArrayList<InPatients>(); 
	  int nRowCount = 1;	//To hold the rowcount and to limit the row size to 6.		       			    
	  int nCssCount = 1;  // To display alternate Row Color.
	 
	  int nListSize = 0;

	  int nLoopCount = 0;
	  InPatients oInPatients = null;
	  try {
		  objInPatientList = bean.getInPatientLis(oInPatientContext);
		  if(objInPatientList != null)
		  {
		       nListSize =  objInPatientList .size();
		       
		  }
		 if(nListSize > 0)
		 {
		   for(nLoopCount = 0 ; nLoopCount < nListSize;nLoopCount ++)
			{
		 
			   oInPatients = objInPatientList.get(nLoopCount); 
			   if(oInPatients != null)
			   {
		        Status = oInPatients.sStatus;
		        st = new StringTokenizer(Status,"|");
				  while (st.hasMoreTokens())
					{
						emergencyYn = st.nextToken();
						deceasedYn = st.nextToken();
						n = st.nextToken();
						if(!(n == null || n.equals("")))
							noofchildren = Integer.parseInt(n);
						relationYn = st.nextToken();
					}
		  
				  if(oInPatients.sDischargeDateTime != null)
				  {
						if( !oInPatients.sDischargeDateTime.equals(""))
							className = "dvLegendDischarged";
				  }
				  
					
					if(deceasedYn.equals("D"))
					{
						className = "dvLegendDeceased";
						
					}
					if(noofchildren > 0) 
						className = "dvLegendNewBorn";
					
					if(relationYn.equals("N"))
					{
						className = "dvLegendNoRelation";
					}
					
					 deceasedYn = "";
					 noofchildren = 0;
					 relationYn = "";
					 tempDischargeDate = "";
	  
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(oInPatients.sPatientId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(oInPatients.sEpisodeId));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oInPatients.sDischargeDateTime));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oInPatients.locationType));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oInPatients.locationCode));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(oInPatients.serviceCode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(nCssCount ));
            _bw.write(_wl_block10Bytes, _wl_block10);
 
	               if(className != "dvLegendNoRelation")
	               {
	             
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(className ));
            _bw.write(_wl_block12Bytes, _wl_block12);

	               }
	               else
	               {
	            	   
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(className ));
            _bw.write(_wl_block14Bytes, _wl_block14);
 
	               }
	              
            _bw.write(_wl_block15Bytes, _wl_block15);
  
	                        // strPatientDetails = out.println(rs.getString("patient_name") )+ " " + out.println(rs.getString("sex"),rs.getString("age")) + " " + out.println(rs.getString("patient_id"));
	                        strPatientDetails = oInPatients.sPatientName + " " + oInPatients.sGender + "," + oInPatients.sAge + " " + oInPatients.sPatientId;
	                         
	                         
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(nCssCount ));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strPatientDetails ));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(oInPatients.sRoomNo));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(oInPatients.sBedNo));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(oInPatients.sAdmDateTime));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(oInPatients.sPhysicianName));
            _bw.write(_wl_block22Bytes, _wl_block22);

			   }
	   className = "dvLegendNotRequired";
	     nRowCount = nRowCount + 1;
		  if(nCssCount==1)
		  {
			   nCssCount = nCssCount +1;
		  }
		  else
		  {
			  nCssCount = nCssCount -1;
		  }	 
	   }//for
	 
		 }//if listsize 
		 else
		 {
			 
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf( IPADConstants.NORECORDS_HTML));
            _bw.write(_wl_block24Bytes, _wl_block24);
 
		 }
	  
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(oInPatientContext.getPatientId()));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(oInPatientContext.getNursingUnitCode() ));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(oInPatientContext.getPractionerId() ));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(oInPatientContext.getSpecialityCode() ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(oInPatientContext.getOrderBy() ));
            _bw.write(_wl_block30Bytes, _wl_block30);

}catch ( Exception e ){
	out.println("Exception " + e);
	e.printStackTrace();
}
finally{

}

            _bw.write(_wl_block31Bytes, _wl_block31);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
