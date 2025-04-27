package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.Common.CommonBean;
import java.util.*;
import java.sql.*;
import java.io.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __ipadwidget extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/iPadWidget.jsp", 1709118027271L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n\n\n\n<!DOCTYPE html> \n<html> \n<head> \n<title>widget</title> \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n <meta name=\"apple-mobile-web-app-capable\" content=\"yes\" />\n\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" />  \n\n<link rel=\"stylesheet\" href=\"../css/iPadwidget.css\" />\n\n<script src=\"../jquery-1.5.2.min.js\"></script>  \n\n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n \n<script>\n  var orientation = \"\";\n  function closeWindow()\n  {\n\t // window.history.back();\n\t// window.close();\n\t window.location = \"IpadBasePage.jsp\";\n  }\n  function showLoadingMsg()\n  {\n\tvar hdnMainPageURLComp = document.getElementById(\"hdnMainPageURL\");\n  \tvar mainPageUrl;\n  \tif(hdnMainPageURLComp){\n  \t\tmainPageUrl = hdnMainPageURLComp.value;\n  \t}\n  \t//alert(\"Url to show in ipadwidget =\"+mainPageUrl);\n  \tvar hdnParamComp = document.getElementById(\"hdnParams\");\n  \tvar parameterVal=\"\";\n  \tif(hdnParamComp){\n  \t\tparameterVal = hdnParamComp.value;\n  \t}\n  \t//alert(\"parameter value=\"+parameterVal);\n  \t//alert(\'main page url =\'+mainPageUrl);\n  \t\n  \tmainPageUrl += \"?\" + parameterVal;\n  \tdocument.getElementById(\"widgetFrame\").src = mainPageUrl;//\"../html/widget.html\"\n \t$.mobile.pageLoading();\n \n \t\n  }\n  function hideLoading()\n  {\n  \t$.mobile.pageLoading(true);\n  }\n  function SelectOrder()\n  {\n\t // document.getElementById(\"widgetFrame\").src = \"SelectOrders.html\";\n  }\n  function showNotes()\n  {\n\t  document.getElementById(\"widgetFrame\").src = \"ViewNotes.jsp\";\n  }\n  function showCreateNotes()\n  {\n\t  //var gender = document.getElementById(\"hdnSex\").value;\n\t   var patclass = document.getElementById(\"hdnPatientClass\").value;\n\t  document.getElementById(\"widgetFrame\").src = \"CreateNotes.jsp?patclass=\" + patclass;\n  }\n  function dispNotesContent(accessionNum,noteType)\n  {\n\t  var patclass = document.getElementById(\"hdnPatientClass\").value;\n\t  document.getElementById(\"widgetFrame\").src = \"CreateNotes.jsp?patclass=\" + patclass +\"&fromfunc=recentNotes&note_type=\" + noteType+\"&accessionNum=\" + accessionNum; \n  }\n  function showRecNotes()\n  {\n\t  document.getElementById(\"widgetFrame\").src = \"RecentNotes.jsp\"\n  }\n  function showRecordChart()\n  {\n\t  var gender = document.getElementById(\"hdnSex\").value;\n\t  var patclass = document.getElementById(\"hdnPatientClass\").value;\n\t // document.getElementById(\"widgetFrame\").src = \"RecordCharts.jsp?gender=\" + gender;\n\t  document.getElementById(\"widgetFrame\").src = \"RecordCharts.jsp?patclass=\" + patclass;\n  }\n  function showSelectOrders()\n  {\n\t  var patclass = document.getElementById(\"hdnPatientClass\").value;\n\t  document.getElementById(\"widgetFrame\").src = \"SelectOrderBasePage.jsp?patientclass=\" + patclass + \"&orientation=\" + orientation;\n  }\n// function added to show the clinical event history page\n  function showClinicalEventHistory(patientId,facilityId)\n  {\n\t  //alert(\'PatientId =\'+patientId+\' ,Facility=\'+facilityId);\n\t  // the patient list is being passed as IP as the clinical\n\t  // history functionality is being shown for IP list only\n\t  // in future, when the OP, DC and EM patient list types\n\t  // are supported, then the parameter should be set\n\t  // in the page itself\n\t  document.getElementById(\"widgetFrame\").src = \"ViewClinicalEventHistory.jsp?patient_id=\"+patientId+\"&facility_id=\"+facilityId+\"&patientlist=IP&selectedperiod=LOD\";\n  }\n  function scrolTop()\n  {\n\t  //alert(\"helloj\");\n\t  $.mobile.silentScroll(-2000);\n  }\n  function showChartView()\n  {\n\t  document.getElementById(\"widgetFrame\").src = \"ChartView.jsp\";\n  }\n  \n  function openMainWindow(params){\n\t  //window.location = \"IpadBasePage.jsp\"+\"?\"+params;\n\t  window.location = \"IpadBasePage.jsp\"+\"?\"+params;\n  }\n  \n  $(document).ready(function () {\n\t  \n\t  if (window.DeviceOrientationEvent) {  \n\t\t  window.addEventListener(\'orientationchange\', myOrientResizeFunction, false);\n\t\t  orientation = Math.abs(window.orientation) === 90 ? \'landscape\' : \'portrait\';\n\t\t  }\n\t \n\t  function myOrientResizeFunction(orientation){     \n\t\t // alert(Math.abs(window.orientation));\n\t\t \n\t\t   var orient = Math.abs(window.orientation) === 90 ? \'landscape\' : \'portrait\';\n\t\t   \n\t\t   if(orient == \"landscape\")\n\t\t\t   {\n\t\t\t     document.getElementById(\"widgetFrame\").style.height = \"553px\";\n\t\t\t     document.getElementById(\"widgetFrame\").contentWindow.changeOrientation(orient);\n\t\t\t   }\n\t\t   else\n\t\t\t   {\n\t\t\t   document.getElementById(\"widgetFrame\").style.height = \"809px\";\n\t\t\t   document.getElementById(\"widgetFrame\").contentWindow.changeOrientation(orient);\n\t\t\t   }\n\t\t    \n\t\t  }\n\t  \n  });\n</script>\n</head> \n<body onload = \"showLoadingMsg()\"> \n<section id=\"page1\" data-role=\"page\"  style = \"padding:0px;width:100%\"> \n<form name = \"frmwidget\">\n<header data-role=\"header\"  style=\"height:175px;padding:0px;border : 0px\">\n<div id = \"divheader\" class=\"dvheader\"    >\n\n<table border = \"0\" style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\">\n\n<tr  class=\"BannerTitle\"align = \"center\">\n \n<td align = \"left\" style =\"width:33%\"><span class=\"spTitle\">Enterprise Management-12.0.2</span></td>\n<td align = \"center\" style =\"width:34%\"><span class=\"spFooter2\">";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="</span></td>\n<td align = \"right\" style =\"width:33%\"><span class=\"spFooter3\" >";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="</span></td>\n\n</tr>\n</table>\n \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n<table border = \"0\" style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" class = \"tbIcon\">\n\t<tr class=\"tIcon\"  >\n\t\n\t\t<td align = \"left\" style =\"width:5%\" valign = \"bottom\" class = \"iconDivider\">\n\t\t<!--   <img src = \"../images/Disabled State.png\" ></img>-->\n\t\t</td>\n\t\t    \n\t\t<td align = \"left\" style =\"width:10%\" valign = \"center\" class = \"iconDivider\" onclick = \"showCreateNotes()\">\n\t\t    <img src = \"../images/Edit notes.png\"></img>\n\t\t</td>\n\t\t<td align = \"left\" style =\"width:10%\" valign = \"center\" class = \"iconDivider\" onclick = \"showNotes()\">\n\t\t    <img src = \"../images/View Notes.png\" ></img>\n\t\t</td>\n\t\t\n\t\t<td align = \"left\" style =\"width:10%\" valign = \"center\" class = \"iconDivider\" onclick = \"showRecordChart()\">\n\t\t  \n\t\t  <img src = \"../images/Record Chart.png\"></img>\n\t\t</td>\n\t\t\n\t\t<td align = \"left\" style =\"width:10%\" valign = \"center\" class = \"iconDivider\" onclick = \"showChartView()\">\n\t\t     <img src = \"../images/View Chart.png\"></img>\n\t\t</td>\n\t\t\n\n\t\t\n\t\t<td align = \"left\" style =\"width:10%\" valign = \"center\" class = \"iconDivider\" onclick = \"showClinicalEventHistory(\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\',\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\')\">\n\t\t<img src = \"../images/View Event History.png\"></img>\n\t\t  \n\t\t</td>\n\t\t\n\t\t<td align = \"left\" style =\"width:10%\" valign = \"center\" class = \"iconDivider\" onclick = \"showSelectOrders()\">\n\t\t  <img src = \"../images/Select-Order.PNG\"></img>\n\t\t</td>\n\t\t\n\t\t<td align = \"center\" style =\"width:10%\" valign = \"center\">\n\t\t  \n\t\t</td>\n\t\t\n\t\t<td align = \"center\" style =\"width:18%\" valign = \"center\">\n\t\t  \n\t\t</td>\n\t\t\n\t\t<td align = \"center\" style =\"width:7%\" valign=\"middle\">\n\t\t\n\t\t<img src = \"../images/Back.png\" class=\"imgLogoutt\" onclick=\"closeWindow()\"></img>\n\t\t</td>\n\t\n\t</tr>\n</table>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<table border = \"0\" style = \"width:100%\" cellpadding = \"0\" cellspacing = \"0\" class = \"tbBanner\" style = \"position:fixed\">\n<tr class=\"patBanner\">\n <td align = \"left\" style =\"width:13%\" valign = \"center\" >\n    <img src = \"../images/Patient Banner Photo.png\" class = \"imgBanner\" ></img>  \n </td>\n<td align = \"center\" style =\"width:87%\">\n  <table style = \"width:100%;height:100%\" border = \"0\" cellspacing = \"0\" cellpadding = \"0\">\n    \n       ";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n       <tr style = \"width:100%\">\n    \n      <td valign = \"middle\" style = \"width:100%\">\n       <input type = \"textbox\"  data-inline = \"true\" data-role = \"none\" readonly = \"true\"  class = \" txtPatientNameBanner1\" value = \"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" \" />\n       <!--  <img src = \"images/Patient Banner Star.png\"></img>  --> \n           </td>\n      \n    </tr>\n       \n        ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="  \n          \n       ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n       <tr style = \"width:100%\">\n     \n      <td valign = \"middle\" >\n         <input type = \"textbox\"  data-role = \"none\" readonly = \"true\"  class = \" txtPatientNameBanner\" value = \"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" \" />\n         \n          </td>\n      \n    </tr>\n       ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n     <!-- \n     <tr style = \"width:100%\" >\n     \n      <td valign = \"middle\" style = \"width : 100%\"> \n      \n      - -->\n       ";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n       <tr style = \"width:100%\" >\n     \n      <td valign = \"middle\" style = \"width : 100%\"> \n      <input type = \"textbox\"  data-role = \"none\" readonly = \"true\"  class = \" txtPatientNameBanner\" value = \"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \" />\n         </td>\n      \n    </tr>\n      ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" \n    \n     \n        ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n       <tr style = \"width:100%\" >\n     \n      <td valign = \"middle\" > \n         <input type = \"textbox\"  data-role = \"none\" readonly = \"true\"  class = \" txtPatientNameBanner\" value = \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" \" />\n           </td>\n      \n    </tr>\n       \n       ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n  \n    \n  </table>\n</td>\n\n\n</tr>\n\n</table>\n\n\n\n</div>\n\n</header>\n\n<div class =\'divwidget\' id = \'dvmain\'   style=\"background-color:white;padding:0px\">\n\n<div id = \"divView\"   style = \"height:auto;overflow:auto;backgound-color:white;padding:0px\" > \n  \n   \n  \n  <iframe frameborder=\"0\" id=\"widgetFrame\" src=\"\" scrolling =\"yes\" style=\"padding:0px;display:block\" ></iframe>  \n\n\n     </div>         \n\n</div>\n\n   <footer data-role = \"footer\"   style=\"padding:0px;height:20px;;border : 0px\">  \n\t\t    <div id = \"divFooter\" class=\"dvFooter\"    data-role = \"none\"> \n\t\t\t\t<table border = \"0\" style = \"width:100%;height:100%\" cellpadding = \"0\" cellspacing = \"0\" class=\"tbFooter\">\n\t\t\t\t\t<tr valign=\"center\">\n\t\t\t\t\t\t<td align = \"left\" style =\"width:30%\" valign=\"top\"><span class=\"spFooter1\">";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="-";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</span></td>\n\t\t\t\t\t\t<td align = \"right\" style =\"width:64%\" valign=\"top\"><span class=\"spFooter2\">Copyright 2012 Computer Sciences Corporation - All rights reserved</span></td>\n\t\t\t\t\t\t<td align = \"right\" style =\"width:6%\" valign=\"top\"><img src=\"../images/CSC_Logo.png\" class=\"imgWidgetLogo\"></img></td>\n\t\t\t\t\t\n\t\t\t\t\t</tr>\n\t\t\t\t</table>\n\t\t   </div> \n\t\t  </footer>  \n   <input type = \"hidden\" name = \"hdnSex\" id = \"hdnSex\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" />\n   <input type = \"hidden\" name = \"hdnPatientClass\" id = \"hdnPatientClass\" value = \"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" />\n   <input type=\"hidden\" name=\"hdnMainPageURL\" id=\"hdnMainPageURL\" id=\"hdnMainPageURL\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\"/>\n   <input type=\"hidden\" name=\"hdnParams\" id=\"hdnParams\" id=\"hdnParams\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\"/>\n   \n</form>\n</section>\n ";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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
String PatientID = "";//request.getParameter("hdnPatientId");
String strEpisodeId = "";//request.getParameter("hdnEpisodeId");
String admitDate = "";
String dischargeDateTime = "";
String locnCode = "";
String locnType = "";
String serviceCode = "";

if(request.getParameter("hdnPatientId") != null)
{
	PatientID = request.getParameter("hdnPatientId");
}
if(request.getParameter("hdnEpisodeId") != null)
{
	strEpisodeId = request.getParameter("hdnEpisodeId");
}
session.putValue("PatientID", PatientID);
session.putValue("EpisodeId", strEpisodeId);
String strPatientClass =  "";
if(request.getParameter("hdnPatClass") != null)
{
	strPatientClass = request.getParameter("hdnPatClass");
}
if(request.getParameter("hdnAdmitDate") != null)
{
	admitDate = request.getParameter("hdnAdmitDate");
}
if(request.getParameter("hdnDischargeDateTime") != null)
{
	dischargeDateTime = request.getParameter("hdnDischargeDateTime");
}
if(request.getParameter("hdnLocnCode") != null)
{
	locnCode = request.getParameter("hdnLocnCode");
}
if(request.getParameter("hdnLocnType") != null)
{
	locnType = request.getParameter("hdnLocnType");
}
if(request.getParameter("hdnServiceCode") != null)
{
	serviceCode = request.getParameter("hdnServiceCode");
}

session.putValue("AdmitDate", admitDate);
session.putValue("DischargeDateTime", dischargeDateTime);
session.putValue("LocnCode", locnCode);
session.putValue("LocnType", locnType);
session.putValue("ServiceCode", serviceCode);

// code added to get the main page url from the request
String mainPageUrl = request.getParameter("hdnMainPageURL");
mainPageUrl = CommonBean.checkForNull(mainPageUrl);
if("".equals(mainPageUrl.trim())){
	mainPageUrl = "../html/widget.html";
}

String params = request.getParameter("hdnParams");

// code added to get the parameter which will be useful
// in hiding the navigation icons
// hiding of these icons should happen in the case
// of previous results screen part of pending results functionality
// in the normal flow, this parameter will not be set
String hideIconParam = request.getParameter("hdnHideIcon");
hideIconParam = CommonBean.checkForNull(hideIconParam, "N");

String site = "";
String jdbc_user = "";
String facility_name = "";
String facility_id= "";
String locale = "en";

Boolean bPatientId = false;
Boolean bPatientName = false;
Boolean bAge = false;
Boolean bGender = false;
Boolean bDOB = false;
Boolean bEncounter = false;
Boolean bNationality = false;
Boolean bNursingUnit = false;
Boolean bBedNo = false;
Boolean bLanguage = false;

String strBannerPatientID = "";
String strBannerPatientName = "";
String strAge = "";
String strGender = "";
String strDOB = "";
String strEncounter = "";
String strNationality = "";
String strNursingUnit = "";
String strBedNo = "";
String strLanguage = "";

StringBuffer sqlStr = new StringBuffer("");
StringBuffer sbPatientDetails = new StringBuffer("");
StringBuffer sbPatientLocationDetails = new StringBuffer("");
StringBuffer sbPatientGenderDetails = new StringBuffer("");
StringBuffer sqlPatientDetails = new StringBuffer("");

String strFromdate = DateUtils.getCurrentDate("DMY", "en");

if(session.getValue("facility_id") != null )
{
	facility_id = (String)session.getValue("facility_id");
}
if(session.getValue("userSite") != null)
{
 site = (String)session.getValue("userSite");
}

if(session.getValue("jdbc_user") != null)
{
	jdbc_user = (String)session.getValue("jdbc_user");
}

if(session.getValue("facility_name") != null)
{
	facility_name = (String)session.getValue("facility_name");
}



sqlStr.append(" SELECT   a.elmt_ref element_ref, a.display_length display_len, a.line_ref display_line, a.disp_ord display_order, a.tool_tip_text tool_tip, a.prefix_label_text display_text,");
sqlStr.append(" a.num_of_spaces no_of_spaces, b.elmt_desc element_desc, b.max_length max_length, b.disp_length_config_yn config, b.dflt_disp_length default_disp_length, b.dflt_line_ref default_disp_line, b.dflt_disp_ord default_disp_order, b.dflt_tool_tip_text default_tool_tip, b.dflt_sel_yn def_sel_yn, ");
sqlStr.append(" b.prefix_label_type prefix_label_type, b.elmt_ref element_ref_def, b.icon_based_yn icon_yn, b.image_name img_name ");
sqlStr.append(" FROM mp_pat_banner_dtl a, mp_pat_banner_elmt b");
sqlStr.append(" WHERE a.banner_ref(+) = 'U01' AND a.banner_categ(+) = 'E' AND a.elmt_ref(+) = b.elmt_ref  AND b.appl_categ IN ('E','B') ORDER BY DECODE (b.elmt_ref, 'PAT_PHOTO', 1, 2), NVL2 (a.line_ref, a.line_ref, b.dflt_line_ref), a.disp_ord,  b.dflt_disp_ord");

Statement stmt				= null;
ResultSet rs				= null;

Statement stmt1				= null;
ResultSet rs1				= null;
ResultSet rs2				= null;
Connection conn=null;
int maxRecord = 0;
int start = 0 ;
int end = 0 ;
int i=1;
String strRowCount = "";
try {
conn = ConnectionManager.getConnection(request);
if(conn != null)
{
	stmt = conn.createStatement();
	stmt1	 = conn.createStatement();
}
if (rs!=null) rs.close();  
if(stmt != null)
{
 rs = stmt.executeQuery(sqlStr.toString());
}

if(rs != null)
{
	String strBannerElement = "";
	//out.println("hi");
	 while (  rs.next() )
	 {
		 strBannerElement = rs.getString("element_ref");
		 if(strBannerElement != null && strBannerElement.equals("PATIENT_ID"))
		 {
			 bPatientId = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("PATIENT_NAME"))
		 {
			 bPatientName = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("AGE"))
		 {
			 bAge = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("GENDER"))
		 {
			 bGender = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("DATE_OF_BIRTH"))
		 {
			 bDOB = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("DATE_OF_BIRTH"))
		 {
			 bDOB = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("ENCOUNTER_ID"))
		 {
			 bEncounter = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("NATIONALITY"))
		 {
			 bNationality = true;
		 }
		 if(strBannerElement != null && strBannerElement.equals("LOCN_BED_ROOM_NO"))
		 {
			 bNursingUnit = true;
		 }
		 //
		 if(strBannerElement != null && strBannerElement.equals("PAT_NAME_LOCAL_LANG"))
		 {
			 bLanguage = true;
		 }
		 
	 }
	 rs.close(); 
	 if ( stmt != null ) stmt.close() ;
	
}

sqlPatientDetails.append(" SELECT   a.patient_id, REPLACE (DECODE ('" + locale+ "' , '" + locale + "' , a.patient_name,NVL (a.patient_name_loc_lang, a.patient_name) ),'''', '' ) patient_name, ");
sqlPatientDetails.append(" TO_CHAR (a.dob, 'dd/mm/yyyy') dob,  a.sex, a.patient_name_loc_lang, NVL (a.age_hrs, a.age) age,  c.LONG_DESC, a.episode_id, ");
sqlPatientDetails.append(" ip_get_desc.ip_nursing_unit ('" + facility_id + "' , a.cur_ward_code, '" + locale + "' , '1') locn_name, ");
sqlPatientDetails.append(" NVL (a.cur_room_num, ' ') room_num, NVL (a.cur_bed_num, ' ') bed_num FROM mp_country  c, ca_ip_active_episode_vw a JOIN mp_patient b on a.patient_id = b.patient_id");
sqlPatientDetails.append(" WHERE a.facility_id = '" + facility_id  + "' AND a.patient_id = '" + PatientID + "' AND a.patient_class = '"+strPatientClass + "' AND (a.adt_status IN ('01', '02')) and c.country_code = b.NATIONALITY_CODE AND (NOT EXISTS (  SELECT 1  FROM mo_mortuary_regn  WHERE patient_id = a.patient_id  AND body_part_obtained_from IS NULL)  ) AND UPPER (a.cur_bed_num) LIKE UPPER ('%') ");


if (rs1 !=null) rs1.close(); 
if(stmt1 != null)
{
	rs1 = stmt1.executeQuery(sqlPatientDetails.toString());
}
if(rs1 != null)
{
	String sex = "";
	if(rs1.next())
	{
		 strBannerPatientID = rs1.getString("patient_id");
		 strBannerPatientName = rs1.getString("patient_name");
		 strAge = rs1.getString("age");
		 if(rs1.getString("sex").equals("M") )
		 {
		  strGender = "Male";
		  sex = "M";
		 }
		 else
		 {
			 strGender = "Female";
			 sex = "F";
		 }
		 strDOB = rs1.getString("dob") ;
		 strEncounter = rs1.getString("episode_id") ;
		 strNationality = rs1.getString("LONG_DESC") ;
		 strNursingUnit = rs1.getString("locn_name") ;
		 strBedNo = rs1.getString("bed_num") ;
		 strLanguage = rs1.getString("patient_name_loc_lang") ;
	}
	rs1.close();
	if ( stmt1 != null ) stmt1.close() ;
	session.putValue("DOB",strDOB);
	session.putValue("Gender",sex);
	
	
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(jdbc_user));
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(strFromdate ));
            _bw.write(_wl_block3Bytes, _wl_block3);

if(hideIconParam == null || hideIconParam.equals("") || "N".equalsIgnoreCase(hideIconParam)){

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(PatientID));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block6Bytes, _wl_block6);

}

            _bw.write(_wl_block7Bytes, _wl_block7);
 if(bPatientId) {
    	   sbPatientDetails.append(strBannerPatientID + " "); 
     
      
       
       
     } 
       
       if(bPatientName) {
    	   sbPatientDetails.append(strBannerPatientName) ;   
        
       } 
       if( bPatientId || bPatientName)
       {
       
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sbPatientDetails.toString() ));
            _bw.write(_wl_block9Bytes, _wl_block9);

       }
        
            _bw.write(_wl_block10Bytes, _wl_block10);

         if(bLanguage && strLanguage != null && !strLanguage.equals("") && !strLanguage.equals("   "))
         {
       
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(strLanguage ));
            _bw.write(_wl_block12Bytes, _wl_block12);
} 
            _bw.write(_wl_block13Bytes, _wl_block13);
 if(bDOB) {
    	   sbPatientGenderDetails.append("DOB : " + strDOB + "   ");   
       } 
       
        if(bGender) {
    	   sbPatientGenderDetails.append("Sex : " + strGender + "   ");  
      } 
       
          if(bAge) {
        	 sbPatientGenderDetails.append("Age : " + strAge + "   "); 
       } 
       
        if(bNationality) {
        	sbPatientGenderDetails.append("Nationality : " + strNationality );
      } 
        
      if(bDOB || bGender || bAge || bNationality)  
      {
      
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(sbPatientGenderDetails.toString() ));
            _bw.write(_wl_block15Bytes, _wl_block15);

      }
      
            _bw.write(_wl_block16Bytes, _wl_block16);
 if(bEncounter) {
        	sbPatientLocationDetails.append("Encounter Id : " + strEncounter + "   ");
        	//strNursingUnit
        	
        
      } 
       
       if(bNursingUnit) {
    	   sbPatientLocationDetails.append("Nursing unit and Bed no : " + strNursingUnit + "," + strBedNo + "   ");
         
       } 
       if(bEncounter || bNursingUnit)
       {
       
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(sbPatientLocationDetails.toString() ));
            _bw.write(_wl_block18Bytes, _wl_block18);

       }
       
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(facility_name ));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(site));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(strGender ));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strPatientClass ));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(mainPageUrl));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(params ));
            _bw.write(_wl_block25Bytes, _wl_block25);

}catch ( Exception e ){
	//out.println("Exception " + e);
	out.println(sqlStr.toString());
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block26Bytes, _wl_block26);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
