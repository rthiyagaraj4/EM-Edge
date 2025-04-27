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
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import webbeans.eCommon.ConnectionManager;
import com.ehis.util.*;

public final class __appview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/AppView.jsp", 1709118012928L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title>Appointments View</title> \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.css\" /> \n<link rel=\"stylesheet\" href=\"ipad.css\" />  \n<script src=\"http://code.jquery.com/jquery-1.5.2.min.js\"></script> \n<script src=\"http://code.jquery.com/mobile/1.0a4.1/jquery.mobile-1.0a4.1.min.js\"></script> \n<script src=\"http://ajax.googleapis.com/ajax/libs/jqueryui/1.8/jquery-ui.min.js\"></script>\n\n\n<script type=\"text/javascript\">\n/*\n $(document).bind(\"swipe\", function(event, data){\n\t//alert(\"helloo\")\n\tevent.preventDefault();\t\n });\n */\n /*\n $(document).bind(\"mobileinit\", function(){ \n\t alert(\"hello\")\n\t $.extend($.mobile, {        loadingMessage: \"Chargement en cours...\"      \n\t\t });    \n});\n */\n /*\n $(\"#page12\").live(\"pagebeforecreate\", function() {\n\t\t// Asynchronously include a footer template\n\t$.mobile.loadingMessage = \'Loading...\';\t\n\t$.mobile.pageLoading();\n\t//alert(\"hitapp\");\n\t\t})\n\t\t*/\n $(document).bind(\"mobileinit\", function () {\n     // As of Beta 2, jQuery Mobile\'s Ajax navigation does not work in all cases (e.g.,\n     // when navigating from a mobile to a non-mobile page, or when clicking \"back\"\n     // after a form post), hence disabling it.\n     $.mobile.ajaxEnabled = false;\n     $.mobile.loadingMessage = \'loading\';\n\n });\n $(document).ready(function () {\n\t// alert(\"hihih\");\n\t window.parent.HideLoadingMsg();\n });\n// alert(\"loading\")\nfunction openPatient(patientid)\n {\n\t// alert(\"hi\");\n\t// window.parent.location =\"Appointment.html\";\n\t// $(\'#page12\').html(\"Loading.....\")\n\t//alert(patientid);\n\t window.parent.slidee(\"true\");\n\t// window.location =\"Appointment.html\";\n\t/*\n\tvar myBars = \'directories=no,location=no,menubar=no,status=no\' ;\n\t\t\tvar myOptions = \'width=\' + window.screen.availwidth + \', height=\' + window.screen.availheight + \', resizable=no, fullscreen=yes\' ;\n\t\t\t//var myFeatures = myBars + \', \' + myOptions ;\n\t\t\tvar myFeatures =  myOptions ;\n\t\t\tvar ecisWindow = open( \'iPadWidget.html\', \'iPadWidget.html\', myFeatures,false ) ;\n\n\t*/\n\t //window.parent.location =\"iPadWidget.html\";\n\t\n\twindow.parent.loadwidgets(patientid);\n\t\n\t//window.open(\"Appointment.html\");\n }\n function showCriteria()\n {\n\t $(\'#divSrchCriteria\').slideToggle(\'fast\');\n }\n function showLoadingMsg()\n {\n \t$.mobile.pageLoading();\n }\n /*\n function HideLoadingMsg()\n {\n \t $.mobile.pageLoading(true);\n }\n */\n function test()\n {\n\t var i = 0;\n\t\t// alert(\"hihih\");\n\t\t\n\t //$(\'#divcnt\').append(\"<table style=\'height:1000px;width:100%\' border = \'1\'><tr><td><span class=\'lz-list-label\'>Naren</span></td><td><img src=\'human.png\'></img> </td></tr></table>\")\n }\n </script>\n    \n<body >\n  \n    <section id=\"page12\" data-role=\"page\"  >  \n   <form>\n   <div id = \"divSrch\"  data-role =\"none\" class=\"dvApp\" onclick = \"showCriteria()\" >\n  \n  <span class = \"spanDvsrch\">Search Criteria</span> \n  <img src = \"Heading-Panel-down-Arrow.png\" class = \"imgg\"></img>\n \n  \n  </div>\n  \n  \n  <div id=\"divSrchCriteria\"  data-inset = \"true\" data-role = \"content\" data-theme = \"d\" style = \"display:none;height:200px\">\n   <table border = \"0\" style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\">\n   <tr width = \"100%\" style = \"height:30%\">\n      <td width = \"50%\" align = \"center\">\n     <!--   <div data-role=\"fieldcontain\"> -->\n\n      <label for=\"sample\">View List</label>\n      <select id = \"sample\" name = \"sample\"   data-native-menu=\"true\"  data-inline=\"true\" >\n       <option value=\"choose\" data-placeholder=\"true\">Choose...</option>\n       <option>sample content1</option>\n        <option>sample content2</option>\n         <option>sample content3</option>\n        <option>sample content4</option>  \n         \n       \n      </select>\n     \n     <!--   </div>  -->\n      </td>\n      <td width = \"50%\" align = \"center\">\n      <input type = \"search\"  value = \"PatientID\"/>\n      </td>\n   </tr>\n   <tr width = \"100%\" style = \"height:30%\">\n        <td width = \"50%\" align = \"center\">\n        <label for = \"txtprac\">Practitioner</label>\n        <input type = \"search\"  value = \"PatientID\" id =\"txtprac\" name = \"txtprac\"/>\n        </td>\n        <td width = \"50%\" align = \"center\">\n        <input type = \"search\"  value = \"Clinic\"/>\n        \n        </td>  \n   </tr>\n   <tr width = \"100%\" style = \"height:20%\">\n        <td width = \"50%\"></td>\n        <td width = \"50%\" align = \"center\">\n          <input type = \"button\" value = \"search\" data-inline=\"true\" />  <input type = \"button\" value = \"clear\"  data-inline=\"true\" />\n        </td>  \n   </tr>\n   </table>\n   </div> \n   \n   \n  <div  data-role =\"none\" class =\"dvApp\">\n  <span class = \"spanDvsrch\"> Appointment List</span> \n \n </div>\n\n \n  \n  \n  \n  <div id = \'divcnt\'  data-role = \"content\" class = \'divcontent\' >\n \n  <ul data-role=\"listview\" id=\"uiapp\">\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n  <!--  \n \n \n  -->\n  <li class =\"ui-btn-text-data";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"  >   <a href=\"#\" rel =\"external\" style = \"height:65px\"> \n  \n                  \n                 \n                    <ul style=\"list-style-type: none;\" >\n                  \t  <li class=\"firstleftUl\">\n                  \t    \n                  \t       <img src=\"human.png\"></img> \n                  \t    \n                    \t</li>\n                    \n                    </ul>\n                    <ul style=\"list-style-type: none;\" >\n                  \t  <li class=\"leftUl\">\n                  \t      <p onclick = \"openPatient(\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\')\"><span class=\"lz-list-label-Patient\" >";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span>&nbsp;&nbsp;&nbsp;<span class = \"lz-list-label-Patient\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span></p>\n                      \t\t  <p>\n                       \t\t\t  <span class=\"lz-list-label\">Appointment No.:</span><span class=\"lz-list-data\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n                       \t\t</p>\n                       \t\t\n                       \t\t<p>\n                       \t\t\t  <span class=\"lz-list-label\">Practitioner.:</span><span class=\"lz-list-data\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</span>\n                       \t\t</p>\n                    \t</li>\n                    \n                    </ul>\n                    <ul  style = \"list-style-type: none\"  >\n                    \t\t <li class=\"rightUl\">\n                      \t\t\t  <p>\n                           \t\t\t <span class=\"lz-list-label\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span> \n                       \t\t\t </p>\n                       \t\t\t \n                          \t\t  \n                            \t\t\n                            \t\t \n                            \t\t<p>\n                               \t\t\t <span class=\"lz-list-label\">Appointment Date.:</span> <span class=\"lz-list-data\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span> \n                            \t\t</p>\n                    \t\t</li>\n                </ul>\n                \n                <ul  style = \"list-style-type: none\"  >\n                    \t\t <li class=\"lastrightUl\">\n                      \t\t\t  <p>\n                          \t\t  \n                          \t\t     \n                          \t\t      \n                               \t\t\t <span class=\"lz-list-label\">LOC.:</span>\n                               \t\t\n                               \t\t\t\n                               \t\t\t  <span class=\"lz-list-data\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span> \n                               \t\t\t\t \n                            \t\t</p>\n                    \t\t</li>\n                </ul>\n                   </a> \n                </li>\n \n  \n\n    \n   ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n    \n  \n \n \n  </ul>\n  \n  </div>\n   \n  <input type = \"hidden\" name =\"hdComp\" value =\"csc\" />\n</form>\n       </section>  \n       \n     \n\n   \n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\n      </body>  \n    \n\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

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
String apptfromdate_greg = "04/04/2012";
String appttodate_greg = "05/04/2012";
String patientid = "SO00001819";
StringBuffer sql = new StringBuffer("") ;
sql.append("where");

String Clin_id=(String)session.getValue("ca_practitioner_id");

sql.append("  appt_date between to_date('"+apptfromdate_greg+"','dd/mm/yyyy') and ");
sql.append(" to_date('"+appttodate_greg+"','dd/mm/yyyy')  and patient_id is not null");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");
sqlStr.append(" Select patient_id,AM_GET_DESC.AM_CARE_LOCN_TYPE((select clinic_type from op_clinic where facility_id=oa_appt_patient_vw.facility_id and CLINIC_CODE=oa_appt_patient_vw.clinic_code),'"+locale+"','1')CARE_LOCN_TYPE_DESC , RESOURCE_CLASS ,CLINIC_CODE,CARE_LOCN_TYPE_IND,appt_ref_no, to_char(appt_date,'dd/mm/rrrr') appt_date1,appt_date,referral_id, nvl(to_char(appt_slab_from_time,'hh24:mi'),' ') appt_slab_from_time, appt_slab_from_time appt_slab_from_time1, nvl(to_char(appt_slab_to_time,'hh24:mi'),' ')appt_slab_to_time,nvl(to_char(appt_duration,'hh24:mi'),' ')appt_duration,OP_GET_DESC.OP_VISIT_TYPE(FACILITY_ID, APPT_TYPE_CODE,'"+locale+"','2') visit_type_short_desc , OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') CLINIC_SHORT_DESC ,decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'),'E', AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_full_name ,sm_get_desc.sm_appl_user(modified_by_id,'"+locale+"','1') modified_by,sm_get_desc.sm_appl_user(added_by_id,'"+locale+"','1') added_by,to_char(added_date,'dd/mm/yyyy hh24:mi') added_date, FACILITY_ID,  to_char(modified_date,'dd/mm/yyyy hh24:mi') modified_date ,AM_GET_DESC.AM_SPECIALITY(speciality_code,'"+locale+"','2')  SPECIALITY_DESC , SM_GET_DESC.SM_FACILITY_PARAM(FACILITY_ID,'"+locale+"',1)FACILITY_NAME ,appt_status,ORDER_CATALOG_CODE,decode('"+locale+"','en',patient_name, nvl(patient_name_loc_lang, patient_name)) patient_name,GENDER ,oth_contact_no,get_age(DATE_OF_BIRTH) age,(select DECEASED_YN from mp_patient where patient_id=oa_appt_patient_vw.patient_id) DECEASED_YN  from  ");
sqlStr.append("oa_appt_patient_vw ");
sqlStr.append(sql.toString()) ; 
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

try {
conn = ConnectionManager.getConnection(request);
stmt = conn.createStatement();
stmt1	 = conn.createStatement();
if (rs!=null) rs.close();   
rs = stmt.executeQuery(sqlStr.toString());







            _bw.write(_wl_block1Bytes, _wl_block1);

  int u = 1;
  while (  rs.next() ){ 
  
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(u ));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(rs.getString("patient_name")));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("appt_ref_no")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rs.getString("practitioner_full_name")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getString("gender")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString("age")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("appt_date1")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString("clinic_code")));
            _bw.write(_wl_block12Bytes, _wl_block12);

    if(u==1)
    {
    	u = u +1;
    }
    else
    {
    	u = u -1;
    }
  }//while
  
            _bw.write(_wl_block13Bytes, _wl_block13);

}catch ( Exception e ){
	out.println("Exception " + e);
	e.printStackTrace();
}
finally{
	if ( rs != null ) rs.close() ;	
	if ( rs1 != null ) rs1.close() ;	
	if(stmt1!=null) stmt1.close() ;
	if ( stmt != null ) stmt.close() ;

	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
