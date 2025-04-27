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

public final class __op extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/OP.jsp", 1709118029005L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!DOCTYPE html> \n<html> \n<head> \n<title></title> \n<meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no\" />\n<link rel=\"stylesheet\" href=\"../jquery.mobile-1.0a4.1.min.css\" /> \n<link rel=\"stylesheet\" href=\"../css/ipad.css\" />  \n<script src=\"../jquery-1.5.2.min.js\"></script> \n<script src=\"../jquery.mobile-1.0a4.1.min.js\"></script> \n\n<script type=\"text/javascript\">\n\n $(document).bind(\"swipe\", function(event, data){\n\t//alert(\"helloo\")\n\tevent.preventDefault();\t\n });\n function showCriteria()\n {\n\t $(\'#divSrchCriteria\').slideToggle(\'fast\');\n }\n $(document).ready(function () {\n\t window.parent.HideLoadingMsg();\n });\n\n </script>\n<body >\n <section id=\"page1\" data-role=\"page\"  > \n  \n <div id = \"divSrch\"  data-role =\"none\" class=\"dvApp\" onclick = \"showCriteria()\">\n  <span class = \"spanDvsrch\">Search Criteria</span> \n  <img src = \"Heading-Panel-down-Arrow.png\" class = \"imgg\"></img>\n  <!--  <span class = \"spanDvsrch\">Search Criteria</span> \n  <table style=\"height:100%;width:100%\" border = \"1\">\n  <tr style=\"height:100%;width:100%\">\n  <td style=\"height:100%;width:98%\">hi</td>\n  <td style=\"height:100%;width:2%\">\n\t  <table>\n\t   <tr style=\"height:20%;width:100%\">\n\t    <td style=\"height:20%;width:100%\">hy</td>\n\t   </tr>\n\t  </table>\n  </td>\n  <tr>\n  </table>\n -->\n  </div>\n  \n  \n  <div id=\"divSrchCriteria\"  data-inset = \"true\" data-role = \"content\" data-theme = \"d\" style = \"display:none;height:200px\">\n   <table border = \"0\" style = \"height:100%;width:100%\" cellpadding = \"0\" cellspacing = \"0\">\n   <tr width = \"100%\" style = \"height:30%\">\n      <td width = \"50%\" align = \"center\">\n      <label for=\"sample\">View List</label>\n      <select id = \"sample\" name = \"sample\">\n       <option>sample content1</option>\n        <option>sample content2</option>\n      </select>\n      </td>\n      <td width = \"50%\" align = \"center\">\n      <input type = \"search\"  value = \"PatientID\"/>\n      </td>\n   </tr>\n   <tr width = \"100%\" style = \"height:30%\">\n        <td width = \"50%\" align = \"center\">\n        <label for = \"txtprac\">Practitioner</label>\n        <input type = \"search\"  value = \"PatientID\" id =\"txtprac\" name = \"txtprac\"/>\n        </td>\n        <td width = \"50%\" align = \"center\">\n        <input type = \"search\"  value = \"Clinic\"/>\n        \n        </td>  \n   </tr>\n   <tr width = \"100%\" style = \"height:20%\">\n        <td width = \"50%\"></td>\n        <td width = \"50%\" align = \"center\">\n          <input type = \"button\" value = \"search\" data-inline=\"true\" />  <input type = \"button\" value = \"clear\"  data-inline=\"true\" />\n        </td>  \n   </tr>\n   </table>\n   </div> \n   \n   \n  <div  data-role =\"none\" class =\"dvApp\">\n <span class = \"spanDvsrch\"> OutPatients List</span>\n   <table class = \"tbApp\" border = \"0\"> \n\n<tr style = \"width:100%;height:100%\"> \n<td style = \"width:40%;height:100%\"></td>\n<td style = \"width:60%;height:100%\" align =\"center\" valign = \"middle\"> \n\n<select data-inline=\"true\" class=\"cmb\" data-role=\"none\"> \n\n<option>Patient ID</option> \n<option>Patient ID</option> \n<option>Patient ID</option> \n<option>Patient ID</option>\n\n</select> \n\n</td> \n\n</tr> \n\n</table> \n  </div>\n \n \n     <div id = \'divcnt\' data-role = \'content\' class = \'divcontent\' >\n  <ul data-role=\"listview\" >\n  ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n \n<li class =\"ui-btn-text-data";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"  >   <a href=\"#\" rel =\"external\" style = \"height:65px\"> \n  \n  \n                 \n                    <ul style=\"list-style-type: none;\" >\n                  \t  <li class=\"firstleftUl\">\n                  \t    \n                  \t       <img src=\"human.png\"></img> \n                  \t    \n                    \t</li>\n                    \n                    </ul>\n                    <ul style=\"list-style-type: none;\" >\n                  \t  <li class=\"leftUl\">\n                  \t      <p onclick = \"openPatient()\"><span class=\"lz-list-label-Patient\" >";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</span>&nbsp;&nbsp;&nbsp;<span class = \"lz-list-label-Patient\">";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</span></p>\n                      \t\t  <p>\n                       \t\t\t  <span class=\"lz-list-label\">Room No.:</span><span class=\"lz-list-data\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</span>\n                       \t\t</p>\n                       \t\t\n                       \t\t<p>\n                       \t\t\t  <span class=\"lz-list-label\">Practitioner.:</span><span class=\"lz-list-data\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</span>\n                       \t\t</p>\n                    \t</li>\n                    \n                    </ul>\n                    <ul  style = \"list-style-type: none\"  >\n                    \t\t <li class=\"rightUl\">\n                      \t\t\t  <p>\n                           \t\t\t <span class=\"lz-list-label\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="/30M</span> \n                       \t\t\t </p>\n                       \t\t\t \n                          \t\t  \n                            \t\t\n                            \t\t \n                            \t\t<p>\n                               \t\t\t <span class=\"lz-list-label\">Bed No.:</span> <span class=\"lz-list-data\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</span> \n                            \t\t</p>\n                    \t\t</li>\n                </ul>\n                \n                <ul  style = \"list-style-type: none\"  >\n                    \t\t <li class=\"lastrightUl\">\n                      \t\t\t  <p>\n                          \t\t  \n                          \t\t     \n                          \t\t      \n                               \t\t\t <span class=\"lz-list-label\">LOC.:</span>\n                               \t\t\n                               \t\t\t\n                               \t\t\t  <span class=\"lz-list-data\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</span> \n                               \t\t\t\t \n                            \t\t</p>\n                    \t\t</li>\n                </ul>\n                   </a> \n                </li>\n\n\n    \n   ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n    \n  \n \n \n  </ul>\n  \n  </div>\n  \n<footer data-role = \"none\" >\n  \n<table class = \"tblegends\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n<tr style = \"width:100%;height:100%\">\n  <td style = \"width:42%;height:100%\" class=\"tdlegends\"> \n  \n     <table style = \"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n         <tr style = \"width:100%;height:50%\">\n           <td style = \"width:14%;height:100%\" align=\"center\"><img src=\"Legend-Critical.png\" style=\"vertical-align:middle;padding-top:5px\"></img> </td>\n           <td style = \"width:14%;height:100%\" align=\"center\"><img src=\"Legend-semi-critical.png\" style=\"vertical-align:middle;padding-top:5px\"></img> </td>\n           <td style = \"width:14%;height:100%\" align=\"center\"><img src=\"Legend-non-critical.png\" style=\"vertical-align:middle;padding-top:5px\"></img> </td>\n        </tr>\n        <tr style = \"width:100%;height:50%\">\n           <td style = \"width:14%;height:100%\" align=\"center\" nowrap =\"false\"><span class=\"spLegends\">Critical </span></td>\n           <td style = \"width:14%;height:100%\" align=\"center\" nowrap =\"false\"><span class=\"spLegends\">Semi-Critical</span> </td>\n           <td style = \"width:14%;height:100%\" align=\"center\" nowrap =\"false\"><span class=\"spLegends\">Non Critical </span></td>\n        </tr>\n     </table>\n     \n  <td>\n  \n  \n  <td style = \"width:42%;height:100%\" class=\"tdlegends\"> \n\t  <table style = \"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t         <tr style = \"width:100%;height:50%\">\n\t           <td style = \"width:14%;height:100%\" align=\"center\" ><img src=\"Legend-Deceased.png\" style=\"vertical-align:middle;padding-top:5px\"></img> </td>\n\t           <td style = \"width:14%;height:100%\" align=\"center\" ><img src=\"Legend-newborn-exists.png\" style=\"vertical-align:middle;padding-top:5px\"></img> </td>\n\t           <td style = \"width:14%;height:100%\" align=\"center\" ><img src=\"Legend-Discharged.png\" style=\"vertical-align:middle;padding-top:5px\"></img> </td>\n\t        </tr>\n\t        <tr style = \"width:100%;height:50%\">\n\t           <td style = \"width:14%;height:100%\" align=\"center\" nowrap =\"false\"><span class=\"spLegends\">Deceased </span></td>\n\t           <td style = \"width:14%;height:100%\" align=\"center\" nowrap =\"false\"><span class=\"spLegends\">Newborn Exists</span> </td>\n\t           <td style = \"width:14%;height:100%\" align=\"center\" nowrap =\"false\"><span class=\"spLegends\">Discharged </span></td>\n\t        </tr>\n\t     </table>\n  \n  <td>\n  <td style = \"width:16%;height:100%\"> \n    <table style = \"width:100%;height:100%\" border = \"0\" cellpadding = \"0\" cellspacing = \"0\">\n\t         <tr style = \"width:100%;height:50%\">\n\t           <td style = \"width:100%;height:100%\" align=\"center\"><img src=\"Legend-no-PP-relationship.png\" style=\"vertical-align:middle;padding-top:5px\"></img> </td>\n\t           \n\t        </tr>\n\t        <tr style = \"width:100%;height:50%\">\n\t           <td style = \"width:100%;height:100%\" align=\"center\" nowrap =\"false\"><span class=\"spLegends\">No PP Relationship </span></td>\n\t           \n\t        </tr>\n\t     </table>\n  <td>\n<tr>\n</table>\n</footer>\n\n  </section>\n  ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n</body>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

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



sql.append("  appt_date between to_date('"+apptfromdate_greg+"','dd/mm/yyyy') and ");
sql.append(" to_date('"+appttodate_greg+"','dd/mm/yyyy')  and patient_id is not null");

String locale = "en";
StringBuffer sqlStr = new StringBuffer("");



 
 sqlStr.append("select * from CA_OP_EPISODE_VW where rownum < 15");

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
            out.print( String.valueOf(rs.getString("patient_name")));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(rs.getString("patient_id")));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rs.getString("service_code")));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getString("physician_name")));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rs.getString("sex")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getString("queue_status")));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString("locn_code")));
            _bw.write(_wl_block10Bytes, _wl_block10);

	   if(u==1)
	   {
	   	u = u +1;
	   }
	   else
	   {
	   	u = u -1;
	   }
  }//while
  
            _bw.write(_wl_block11Bytes, _wl_block11);

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

            _bw.write(_wl_block12Bytes, _wl_block12);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
