package jsp_servlet._exh._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.text.SimpleDateFormat;
import java.text.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eXH.*;
import eXH.XHDBAdapter;
import java.io.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __tracknotificationsetupadminmain extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/exh/jsp/TrackNotificationSetupAdminMain.jsp", 1732991021138L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<HEAD>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'\n\ttype=\'text/css\'></link>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eXH/html/xhtab.css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/Validate.js\"></script>\n<script language=\"javascript\" src=\"../../eXH/js/XHAjaxUtil.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eXH/js/trackNotificationTable.js\"></script>\n<script src=\"https://cdnjs.cloudflare.com/ajax/libs/moment.js/2.18.1/moment.min.js\"></script>\n<script language=\"javascript\" src=\"../../eCA/js/jquery-1.7.2.min.js\"></script>\n<script type=\"text/javascript\">\n$(document).ready(function() {  \n\tonChangeApplication();\n});\n</script>\n<head>\n\n<title>Track Notification</title>\n</head>\n<style>\n.container .btn {\n\tposition: absolute;\n\tbottom: 5px;\n\tright: 0px;\n}\n</style>\n<body onload=\"load();\">\n\t<form id=\"trackNotification\" name=\"trackNotification\" id=\"trackNotification\">\n\t\t<div class=\"container\">\n\t\t\t<div>\n\t\t\t\t<TABLE cellSpacing=0 cellPadding=0 width=\"100%\">\n\t\t\t\t\t<TBODY>\n\t\t\t\t\t\t<TR class=COMMONTOOLBARFUNCTION>\n\t\t\t\t\t\t\t<TD class=COMMONTOOLBARFUNCTION>Track Notification</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t\t<TR>\n\t\t\t\t\t\t\t<TD bgcolor=\"#E2E3F0\"><INPUT onclick=\"myReset();\" class=BUTTON type=reset value=Reset>\n\t\t\t\t\t\t\t\t<INPUT\n\t\t\t\t\t\t\t\t\tonclick=parent.parent.parent.frames[1].expand(this);menuHide()\n\t\t\t\t\t\t\t\t\tclass=BUTTON type=button value=Menu>\n\t\t\t\t\t\t\t</TD>\n\t\t\t\t\t\t</TR>\n\t\t\t\t\t</TBODY>\n\t\t\t\t</TABLE>\n\n\t\t\t\t\n\n\t\t\t</div>\n\t\t\t\n\t\t\t<table style=\"width: 100%;\">\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\n\t\t\t\t\t\t<table style=\"width: 90%;\">\n\t\t\t\t\t\t\t<tr style=\"height: 40px;\">\n\t\t\t\t\t\t\t\t<td class=label>Application ID</td>\n                                \n\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t\t\t\t\t\t\t\t\t\t<select class=\'select\' id=\'app_id\' name=\'app_id\' id=\'app_id\' style=\"width: 200px;\" onchange=\"onChangeApplication()\">\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" - ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=label>Event Type</td>\n\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\t<select class=\"select\" id=\"event_type\" name=\"event_type\" id=\"event_type\" tabindex=1 >\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t\t</select>\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td class=label>Notification Type</td>\n\t\t\t\t\t\t\t\t<td><select name=\"notification_type\" id=\"notification_type\" id=\"notification_type\"\n\t\t\t\t\t\t\t\t\tvalue=\"SMS\" style=\"width: 200px;\">\n\t\t\t\t\t\t\t\t\t\t<option value=\"\">SMS</option>\n\n\t\t\t\t\t\t\t\t</select></td>\n\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr style=\"height: 40px;\">\n\n\t\t\t\t\t\t\t\t<td class=label>Refresh interval</td>\n\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =" <select class=\'select\'\n\t\t\t\t\t\t\t\t\tname=\'ref_interval\' id=\'ref_interval\' id=\'ref_interval\' style=\"width: 200px;\">\n\t\t\t\t\t\t\t\t\t\t<!-- <option value=\'\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option> -->\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n\t\t\t\t\t\t\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t\t\t\t\t\t\t\tmins\n\t\t\t\t\t\t\t\t\t\t</option>\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=label>Last Refresh Date & Time</td>\n\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 =" <input class=\'select\' name=\'last_ref_date_time\' id=\'last_ref_date_time\'\n\t\t\t\t\t\t\t\t\tid=\'last_ref_date_time\' type=text\n\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' disabled=\"disabled\"\n\t\t\t\t\t\t\t\t\tstyle=\"width: 200px;\"> ";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\n\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t<td class=label>Next Refresh Date & Time</td>\n\t\t\t\t\t\t\t\t<td class=label>\n\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" <input class=\'select\' id=\'next_ref_date_time\'\n\t\t\t\t\t\t\t\t\tname=\'next_ref_date_time\' id=\'next_ref_date_time\' type=text\n\t\t\t\t\t\t\t\t\tvalue=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t\t\t\t\t\t</td>\n\n\t\t\t\t\t\t\t</tr>\n\n\t\t\t\t\t\t\t<tr style=\"height: 40px;\">\n\t\t\t\t\t\t\t\t<td class=label>Notification Status</td>\n\t\t\t\t\t\t\t\t<td class=label><select class=\"select\"\n\t\t\t\t\t\t\t\t\tname=notification_status id=notification_status\n\t\t\t\t\t\t\t\t\tstyle=\"width: 200px;\">\n\t\t\t\t\t\t\t\t\t\t<option value=\'Failed\' selected=\"selected\">Failed</option>\n\t\t\t\t\t\t\t\t\t\t<option value=\'Success\'>Success</option>\n\t\t\t\t\t\t\t\t\t\t<!-- <option value=\'Sent\'>Sent</option> -->\n\t\t\t\t\t\t\t\t\t\t<option value=\'All\'>All</option>\n\n\t\t\t\t\t\t\t\t</select></td>\n\n\t\t\t\t\t\t\t\t<td class=label>Notification From</td>\n\n\t\t\t\t\t\t\t\t<td class=\'fields\'>\n\t\t\t\t\t\t\t\t <input type=\"text\" name=\"specimen_from_date\" id=\"specimen_from_date\"\n           value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\" size=\"16\" maxlength=\"16\"\n           onClick=\"checkDateRange(\'specimen_from_date\', \'specimen_to_date\');\">\n    <input type=\"image\" name=\"showcalndr\" id=\"showcalndr\"\n           src=\"../../eCommon/images/CommonCalendar.gif\"\n           onClick=\"event.preventDefault(); showCalendar(\'specimen_from_date\', null, \'hh:mm\'); return false;\">\n\t\t\t\t\t\t\t\t<td class=label>Notification To</td>\n\n\t\t\t\t\t\t\t\t<td class=\"fields\"> <input type=\"text\" name=\"specimen_to_date\" id=\"specimen_to_date\"\n           value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\" size=\"16\" maxlength=\"16\"\n           onClick=\"checkDateRange(\'specimen_from_date\', \'specimen_to_date\');\">\n    <input type=\"image\" name=\"showcalndr\" id=\"showcalndr\"\n           src=\"../../eCommon/images/CommonCalendar.gif\"\n           onClick=\"event.preventDefault(); showCalendar(\'specimen_to_date\', null, \'hh:mm\'); return false;\">\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t\t\t<td></td>\n\t\t\t\t\t\t\t\t<td></td>\n\n\n\t\t\t\t\t\t\t\t<td align=\"right\"><INPUT class=BUTTON type=button\n\t\t\t\t\t\t\t\t\tid=\"resubmitButton\" value=\"Re-Submit\" onclick=\"resubmit();\"> <INPUT class=BUTTON type=button\n\t\t\t\t\t\t\t\t\tvalue=\"Search\"\n\t\t\t\t\t\t\t\t\tonclick=\"checkDateRange();\"></td>\n\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t</table>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t\t\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 =" \n\n\t\t\t\t\t<input type=\"hidden\" id=\"allowedUserOrNot\" name=\"allowedUserOrNot\" id=\"allowedUserOrNot\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\" >\n\n\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\n\t\t\t\n\t\t\t\n\t\t\t<hr style=\"border: 1px solid #BED2DC;\" />\n\n\t\t\t<div id=\"tabledata\"></div>\n\t\t\t<div id=\"resubmitteddata\"></div>\n\n\t\t</div>\n\t</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

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

	request.setCharacterEncoding("UTF-8");

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
            _bw.write(_wl_block1Bytes, _wl_block1);

	String locale = ((String) session.getAttribute("LOCALE"));

	// to fetch current date and time (for specimen to date)
	Date specimen_to = new Date();
	SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");
	String specimen_to_date = simpleDateFormat1.format(specimen_to);

	Date sdf1 = simpleDateFormat1.parse(specimen_to_date);

	// to fetch date and time 24 hours back (for specimen from date)	
	Date specimen_from = new Date(System.currentTimeMillis()
			- (24 * 60 * 60 * 1000));
	SimpleDateFormat simpleDateFormat2 = new SimpleDateFormat(
			"dd/MM/yyyy HH:mm");
	String specimen_from_date = simpleDateFormat2.format(specimen_from);

	Date sdf2 = simpleDateFormat1.parse(specimen_from_date);
	
	String ecis_jdbc_user = (String) session.getAttribute("login_user");
	Connection con = null;
	Statement stmt = null;
	ResultSet rs = null;
	String selected = "selected";

            _bw.write(_wl_block5Bytes, _wl_block5);

	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			? (String) session.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";
	sStyle = "IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
try {
										con = ConnectionManager.getConnection();
										String qry = "select application_id, application_name from xh_application where notifiable_yn = 'Y'";
										stmt = con.createStatement();
										rs = stmt.executeQuery(qry);
            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block9Bytes, _wl_block9);
while (rs.next()) {
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
									} catch (Exception e1) {
										System.out.println("TrackNotificationSetupAdminMain.jsp Exc1 : " + e1.toString());
										e1.printStackTrace(System.err);
									} finally {
										if (rs != null)
											rs.close();
										if (stmt != null)
											stmt.close();
									}
            _bw.write(_wl_block14Bytes, _wl_block14);
            _bw.write(_wl_block15Bytes, _wl_block15);
try {
				con = ConnectionManager.getConnection();
				String qry = "select NVL(Notification_Refresh_Interval,'') Notification_Refresh_Interval from xh_param";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
while (rs.next()) {
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
}
            _bw.write(_wl_block9Bytes, _wl_block9);
} catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}
            _bw.write(_wl_block20Bytes, _wl_block20);
try {
				con = ConnectionManager.getConnection();
				String qry = "select Last_Notify_Refresh_Date_Time from xh_param";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);
				while (rs.next()) {
					String last_ref_date_time = rs.getString(1);
					if (rs.wasNull()) {
						last_ref_date_time = " ";
					}
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(last_ref_date_time));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
			} catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}
            _bw.write(_wl_block23Bytes, _wl_block23);
try {
				con = ConnectionManager.getConnection();
				String qry = "select Next_Notify_Refresh_Date_Time from xh_param";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);
				while (rs.next()) {
					String next_ref_date_time = rs.getString(1);
					if (rs.wasNull()) {
						next_ref_date_time = " ";
					}
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(next_ref_date_time));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
			} catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(specimen_from_date));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(specimen_to_date));
            _bw.write(_wl_block27Bytes, _wl_block27);
try {
				con = ConnectionManager.getConnection();
				String qry = "SELECT ALLOW_NOTIFICATION_YN FROM XH_AUTHORIZED_USER WHERE LOGIN_NAME = " + "'" + ecis_jdbc_user + "'";
				stmt = con.createStatement();
				rs = stmt.executeQuery(qry);
				while(rs.next()){
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( rs.getString(1) ));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
			}		 catch (Exception e1) {
				System.out
						.println("TrackNotificationSetupAdminMain.jsp Exc1 : "
								+ e1.toString());
				e1.printStackTrace(System.err);
			} finally {
				if (rs != null)
					rs.close();
				if (stmt != null)
					stmt.close();
			}
            _bw.write(_wl_block30Bytes, _wl_block30);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
}
