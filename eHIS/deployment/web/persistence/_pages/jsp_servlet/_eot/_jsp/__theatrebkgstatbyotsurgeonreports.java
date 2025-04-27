package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOT.*;
import eOT.Common.*;
import eCommon.Common.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eOT.*;
import java.util.*;
import com.ehis.util.*;

public final class __theatrebkgstatbyotsurgeonreports extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/TheatreBkgStatByOtSurgeonReports.jsp", 1709120404000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="             \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="             \n<html>\n <head>                   \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\" />\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eOT/js/OtReports.js\"> </script>\n\t<script language=\"javascript\" src=\"../../eOT/js/OTReportsLkupSQL.js\"> </script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<!-- <script src=\"../../eCommon/js/messages.js\" language=\"javascript\"></script>\n\t<script src=\"../../eOT/js/OTMessages.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n  </head>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<!-- <form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eCommon/jsp/report_options.jsp\" target=\"messageFrame\"> -->\n<form name=\'OtReportOptionsForm\' id=\'OtReportOptionsForm\' action=\"../../eOT/jsp/OTReportsIntermediate.jsp\"  target=\"messageFrame\">\n<table border=\'0\' cellpadding=\'3\' cellspacing=\'0\' width=\'100%\' align=\"center\">\n<tr> \n<!--57888 starts-->\n\t  <td class=\'label\' width=\'20%\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</td>\n\t<td class=\'fields\' width=\'17%\'>\n\t <input type=\'text\' name=\'param1_disp\' id=\'param1_disp\' size=\'8\' value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\' onKeyPress=\"return checkForSpecCharsforID(event);\" onBlur=\"isValidDate(this);\" maxlength=\'10\'>\n\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param1_disp\');\"> <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t<input type=\'hidden\' name=\'param1\' id=\'param1\' value=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\'>\n\t </td>\n\t <td class=\'label\' width=\'21%\'>\n\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</td>\n\t <td class=\'fields\' width=\'42%\'>\n\t\t  <input type=\'text\' name=\'param11_disp\' id=\'param11_disp\' size=\'8\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' onKeyPress=\"return checkForSpecCharsforID(event);\" onBlur=\"isValidDate(this);\" maxlength=\'10\'>\n\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\'onClick=\"return showCalendar(\'param11_disp\');\"> <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t<input type=\'hidden\' name=\'param11\' id=\'param11\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>\n\t </td>\n</tr>\n<!--57888 ends-->\n\t<tr>\n\t<td class=\'label\' width=\'20%\'>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</td>\n     <td class=\'fields\' width=\'17%\'>\n\t\t<input type=\'hidden\' name=\'param10\' id=\'param10\' value=\'\'> \n\t\t<input type=\'hidden\' name=\'param9\' id=\'param9\' value=\'\' > \n\t\t<input type=\'text\' name=\'from_surgeon_desc\' id=\'from_surgeon_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\' param1 = \'param9\'  param2 = \'param10\' key =\'SURGEON\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param9.value=\'\',param10.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t <input type=\'button\' class=\'button\' value=\'?\' name=\'FrmSurgeonLookUp\' id=\'FrmSurgeonLookUp\' onClick=\"callCommonLookup(from_surgeon_desc);\" >\n\t</td>\n\t<!--<td class=\'label\' align=\'right\' nowrap>To Surgeon &nbsp;</td>\n\t <td align=\'left\'>\n\t\t <input type=\'hidden\' name=\'param10\' id=\'param10\'> \n\t\t<input type=\'text\' name=\'to_surgeon_desc\' id=\'to_surgeon_desc\' size=\'20\' > \n\t\t <input type=\'button\' class=\'button\' value=\'?\' name=\'ToSurgeonLookUp\' id=\'ToSurgeonLookUp\' onClick=\"searchCode(param10,to_surgeon_desc,\'Surgeon\',document.forms[0].qry_surgeon.value);\" >-->\n\t\t\n\t<td class=\'label\' width=\'21%\'>\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</td>\n     <td class=\'fields\' width=\'42%\'>\n\t\t<input type=\'hidden\' name=\'param13\' id=\'param13\'> \n\t\t<input type=\'hidden\' name=\'param12\' id=\'param12\'> \n\t\t<input type=\'text\' name=\'from_oper_room_desc\' id=\'from_oper_room_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' param1 = \'param12\'  param2 = \'param13\' key =\'OPER_ROOM\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param12.value=\'\',param13.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'FrmOperRoomLookUp\' id=\'FrmOperRoomLookUp\' onClick=\"callCommonLookup(from_oper_room_desc);\" >\n\t</td>\n\t\t\n\t\t \n<!-- \t<td class=\'label\' align=\'right\' nowrap>To Operation Room &nbsp;</td>\n\t <td align=\'left\'>\n\t\t <input type=\'hidden\' name=\'param3\' id=\'param3\'> \n\t\t<input type=\'text\' name=\'to_oper_room_desc\' id=\'to_oper_room_desc\' size=\'20\'  > \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'ToOperRoomLookUp\' id=\'ToOperRoomLookUp\' onClick=\"searchCode(param3,to_oper_room_desc,\'Operation Rooms\',document.forms[0].qry_oper_room.value);\">\n\t</td> -->\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'20%\'>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n    <td class=\'fields\' width=\'17%\'>\n\t\t<input type=\'hidden\' name=\'param8\' id=\'param8\'> \n\t\t<input type=\'hidden\' name=\'param7\' id=\'param7\'> \n\t\t<input type=\'text\' name=\'from_speciality_desc\' id=\'from_speciality_desc\' size=\'20\' title=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' param1 = \'param7\'  param2 = \'param8\' key =\'SPECIALITY\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param7.value=\'\',param8.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'FrmSpecialityLookUp\' id=\'FrmSpecialityLookUp\' onClick=\"callCommonLookup(from_speciality_desc);\"  >\n\t</td>\n\t\t\t\n\n<!-- \t<td class=\'label\' align=\'right\' nowrap>To Speciality &nbsp;</td>\n\t <td align=\'left\'>\n\t\t <input type=\'hidden\' name=\'param8\' id=\'param8\'> \n\t\t<input type=\'text\' name=\'to_speciality_desc\' id=\'to_speciality_desc\' size=\'20\' > \n\t\t <input type=\'button\' class=\'button\' value=\'?\' name=\'ToSpecialityLookUp\' id=\'ToSpecialityLookUp\' onClick=\"searchCode(param8,to_speciality_desc,\'Speciality\',document.forms[0].qry_speciality.value);\" >\n\n\t </td>\n -->\n\t<td class=\'label\' width=\'21%\'>\n\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t</td>\n    <td class=\'fields\' width=\'42%\'>\n\t    <input type=\'hidden\' name=\'param5\' id=\'param5\' > \n\t\t<input type=\'hidden\' name=\'param4\' id=\'param4\' >\n\t\t<!-- ML-MMOH-CRF-0752.3-US001 -->\n\t\t<input type=\'text\' name=\'from_ward_desc\' id=\'from_ward_desc\' size=\'67\' title=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' param1 = \'param4\'  param2 = \'param5\' key =\'WARD\' onBlur=\"if(this.value!=\'\')callCommonLookup(this); else param4.value=\'\',param5.value=\'\' \" maxlength=\'70\' onKeyPress=\"return CheckForSpecChars_local(event);\"> \n\t\t<input type=\'button\' class=\'button\' value=\'?\' name=\'FrmWardLookUp\' id=\'FrmWardLookUp\' onClick=\"callCommonLookup(from_ward_desc);\" >\n\t</td>\n\t\t\t\n<!-- \t<td class=\'label\' align=\'right\' nowrap>To Ward &nbsp;</td>\n\t <td align=\'left\'>\n\t     <input type=\'hidden\' name=\'param5\' id=\'param5\' > \n\t\t  <input type=\'text\' name=\'to_ward_desc\' id=\'to_ward_desc\' size=\'20\' > \n\t\t   <input type=\'button\' class=\'button\' value=\'?\' name=\'ToWardLookUp\' id=\'ToWardLookUp\' onClick=\"searchCode(param5,to_ward_desc,\'Ward\',document.forms[0].qry_ward.value);\" >\n\t </td> -->\n</tr>\n\n<tr> \n\t<td class=\'label\' width=\'20%\'>\n\t\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t</td>\n\t<td class=\'fields\' colspan=\"3\">\n\t <select name=\"param6\" id=\"param6\" >  \n\t <option value=\"\">\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t</option>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t  <option value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\'> ";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t</option>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t </select>\n\t <img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t </td>\n\t</tr>\n\n\t<input type=\"hidden\" name=\"facility_id\" id=\"facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\" name=\"P_facility_id\" id=\"P_facility_id\"\tvalue=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\" name=\"p_user_id\" id=\"p_user_id\"\tvalue=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\" name=\"p_user_name\" id=\"p_user_name\"\tvalue=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\" name=\"user_id\" id=\"user_id\"\tvalue=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\" name=\"p_module_id\" id=\"p_module_id\"  value=\"OT\">\n\t<input type=\"hidden\" name=\"p_report_id\" id=\"p_report_id\" value=\"OTRDCBKS\">\n\t<input type=\"hidden\" name=\"pgm_id\" id=\"pgm_id\" value=\"OTRDCBKS\">\n\t<input type=\"hidden\" name=\"no_of_mandatory_fields\" id=\"no_of_mandatory_fields\" value=\"2\" disabled>\n\t<input type=\"hidden\" name=\"mandatory_fm_1\" id=\"mandatory_fm_1\" value=\"param1##";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\" disabled>\n    <input type=\"hidden\" name=\"mandatory_fm_2\" id=\"mandatory_fm_2\" value=\"param11##";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\" disabled>\n<!-- Current date validation removed for SRR-465 CRF as per dilip\'s instruction on 10/06/2010  -->\n<!-- \t<input type=\"hidden\" name=\"no_of_compare_date_fields\" id=\"no_of_compare_date_fields\" value=\"1\" disabled>\n\t<input type=\"hidden\" name=\"compare_date_fm_1\" id=\"compare_date_fm_1\" value=\"param1##Booking Date\" disabled>\n    <input type=\"hidden\" name=\"compare_date_to_1\" id=\"compare_date_to_1\" value=\"param11\" disabled>\n -->    \n\t<input type=\"hidden\" name=\"no_of_comparison_fields\" id=\"no_of_comparison_fields\" value=\"3\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_1\" id=\"compare_fm_1\" value=\"param12##Operation Room\" disabled>\n    <input type=\"hidden\" name=\"compare_to_1\" id=\"compare_to_1\" value=\"param13\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_2\" id=\"compare_fm_2\" value=\"param7##Speciality\" disabled> \n\t<input type=\"hidden\" name=\"compare_to_2\" id=\"compare_to_2\" value=\"param8\" disabled>\n\t<input type=\"hidden\" name=\"compare_fm_3\" id=\"compare_fm_3\" value=\"param4##Ward\" disabled>\n\t<input type=\"hidden\" name=\"compare_to_3\" id=\"compare_to_3\" value=\"param5\" disabled>\n\t<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n\t<input type=\"hidden\" name=\"p_language_id\" id=\"p_language_id\"\tvalue=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\" >\n\t<input type=\'hidden\' name=\'reportParams\' id=\'reportParams\' value=\"param1#param11#param9#param10#param12#param13#param7#param8#param4#param5#param6#P_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id\">\n</table>\n\n\n</form>\n</body>\n</html>\n\n\n\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

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
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String ward_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
	String frombookingdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromBookingDate.Label","ot_labels");
	String tobookingdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToBookingDate.Label","ot_labels");

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String booking_date = "";
	if(facility_id == null) facility_id="";
	//String SQL = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY ORDER BY 2";
	String SQL = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'   ORDER BY 2";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//booking_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			booking_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		if(pstmt!=null) pstmt.close();
		if(rst!=null) rst.close();
		pstmt = con.prepareStatement(SQL);
		rst = pstmt.executeQuery();

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(booking_date));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(DateUtils.convertDate(booking_date,"DMY",locale,"en")));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(booking_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(DateUtils.convertDate(booking_date,"DMY",locale,"en")));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(surgeon_title));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(operationRoom_title));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(speciality_title));
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(ward_title));
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
 while(rst.next()){ 
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rst.getString(1)));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rst.getString(2)));
            _bw.write(_wl_block28Bytes, _wl_block28);
   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg TheatreBkgStatByOtRoomReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(user_id));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(frombookingdate));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(tobookingdate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block38Bytes, _wl_block38);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.FromBookingDate.Label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ToBookingDate.Label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.OperatingRoom.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.nursingUnit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SurgeryType.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.all.label", java.lang.String .class,"key"));
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
}
