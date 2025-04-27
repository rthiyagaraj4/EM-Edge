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
import java.text.*;
import webbeans.eCommon.*;
import com.ehis.util.*;
import eCommon.XSSRequestWrapper;

public final class __displayapptdetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/DisplayApptDetails.jsp", 1743078611578L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<html>\n<head>  \n <script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n<form name=\"single_pract\" id=\"single_pract\">\n<input type=\'hidden\' name=\'help_function_id\' id=\'help_function_id\' value=\'RESCHEDULE_APPOINTMENT\'>\n<table cellspacing=\'0\' width=\'100%\' cellpadding=\'0\' border=\'0\' width=\'90%\'>\n\t<th align=left><b>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" ";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n - ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</b></th>\n<tr><td class=\'white\'></td></tr>\n</table>\n<form name=\"single_pract\" id=\"single_pract\">\n<table border=\'0\' cellspacing=\'0\' width=\'100%\' cellpadding=\'0\'> \n<tr>\n<td>\n<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'0\'>\n\n\t<tr>\n\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t<td class=\'label\' width=\'10%\'>&nbsp;</td>\n\t</td><td class=\'label\' >\n\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="<a href=javascript:over_booking() >\n\t\t\t\t<b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b> \n\t\t\t\t</a> \n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\n\t</tr>\n\t</table>\n\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=\'1\'>\n\t<tr>\n\t<td class=\'label\' >&nbsp;</td>\n\t<td class=\'label\' align=middle>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<b>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</b>\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t</td>\t\n\t<td class=\'label\'><b>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</b></td>\n\t<td class=\'label\'><b>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</b></td>\n\t<td class=\'label\'>\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\t\t\n\t\t<b>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n    <!--Below line Modified for this CRF ML-MMOH-CRF-0606--> \n\t<!--Below line Modified for this CRF ML-MMOH-CRF-0609 by Mano-->\n\t<td class=\'label\'><b>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&nbsp;";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</b></td>\n\t<!--End this CRF ML-MMOH-CRF-0609-->\n\t<!--End this CRF ML-MMOH-CRF-0606-->\n\t</tr>\n\t<tr>\n\t<td class=\'label\' ><b>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</b></td>\n\t<td class=\'label\' >\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</td>\t\n\t<td class=\'label\' align=middle>\n\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t\t&nbsp;\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<b>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</b>\n\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t</td>\n\t<td class=\'label\' align=middle>\n\t\t\t\t";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t</td>\n\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</b></td>\n\n\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="</b> </td>\n\t<td class=\'label\' align=middle>\n\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t&nbsp;\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t</td>\n\t<td class=\'label\' align=middle>&nbsp;</td>\n\t<td class=\'label\' align=middle>&nbsp;</td>\n\t</tr>\t\n\t<tr>\n\t<td class=\'label\' ><b>";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="</b></td>\n\t<!-- <td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="</b></td>\t -->\n\t<td class=\'label\' >\n\t\t\t\t";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\t\t\t\t\n\t\t\t\t<b>";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 =" <!--ends here-->\n\t</td>\n\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="</b></td>\n\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="</b></td>\n\t<td class=\'label\' align=middle>\n\t";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\n\t</td>\n\t<td class=\'label\' align=middle>&nbsp;</td>\n\t<td class=\'label\' align=middle>&nbsp;</td>\n\t</tr>\n\t<tr>\n\t<!--Below line modified for this CRF ML-MMOH-CRF-0606-->\n\t<td class=\'label\' nowrap width=\'2%\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\'>&nbsp;</td>\n\t<td class=\'label\' align=middle><b>";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="</b></td>\n\t\n\t</tr>\n\t\t\n</table>\t\n</table>\t\n<script>\nasync function over_booking()\n{\n\tvar appt_ref_no   =\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'\n\tvar clinic_code   =\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'\n\tvar pract_id\t  =\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'\n\tvar appt_date\t  =\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'\n\tvar from_time     =\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'\n\tvar to_time\t\t  =\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'\n\tvar over_booked\t  =\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'\n\tvar overbooked_yn =\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'\n\tvar to_over_book_yn =\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'\n\tvar old_date\t  =\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'\n\tvar p_o_time_tab_type =\'";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\'\n\tvar over_book_rights_yn = \'";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\'\n\tvar alcn_criteria=\'";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\'\n\n\tvar res_type= \'";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\'\n\tvar clinic_type= \'";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );

    private final static java.lang.String  _wl_block58 ="\'\n\tvar new_day = \'";
    private final static byte[]  _wl_block58Bytes = _getBytes( _wl_block58 );

    private final static java.lang.String  _wl_block59 ="\'\n\tvar retVal = \tnew String();\n\tvar dialogHeight= \"40\" ;\n\tvar dialogWidth\t= \"85\" ;\n\tvar dialogTop = \"65\" ;\n\tvar center = \"1\" ;\n\tvar status=\"no\";\n\tif(over_booked ==\'Y\' && to_over_book_yn==\'Y\'){\n\t\t/*var appt_dateArr=appt_date.split(\"/\");\n\t\tvar old_dateArr=old_date.split(\"/\");\n\t\tif(appt_dateArr[0]==old_dateArr[0] && appt_dateArr[1]==old_dateArr[1] && appt_dateArr[2]==old_dateArr[2]){\n\t\t\talert(\'OverBooking Appointment can\\\'t be transferred to same date\');\n\t\t\treturn;\n\t\t}*/\n\t\talert(getMessage(\'OVER_BOOK_NOT_ALLOWED_TO_ANOTHER_OVER_BOOK\',\'OA\'));  \n\t\treturn;\n\t}\n\tvar features\t= \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth + \"; center: \" + center + \"; status: \" + status + \"; dialogTop :\" + dialogTop;\n\tvar arguments\t= \"\" ;\n    if (over_book_rights_yn==\"N\")\n\t{\n       alert(getMessage(\'OVER_BOOK_NOT_ALLOWED\',\'OA\'));       \n\t}\n\telse{\n\t\tvar url=\"../../eOA/jsp/TransferAppointmentDetailsFrame.jsp?i_appt_ref_no=\"+appt_ref_no+\"&i_clinic_code=\"+clinic_code+\"&i_practitioner_id=\"+pract_id+\"&new_day=\"+new_day+\"&i_appt_date=\"+appt_date+\"&i_from_time=\"+from_time+\"&i_to_time=\"+to_time+\"&over_booked=\"+over_booked+\"&overbooked_yn=\"+overbooked_yn+\"&i_time_table_type=\"+p_o_time_tab_type+\"&old_date=\"+old_date+\"&to_over_book_yn=\"+to_over_book_yn+\"&clinic_type=\"+clinic_type+\"&res_type=\"+res_type+\"&alcn_criteria=\"+alcn_criteria;\n\n\tretVal = await window.showModalDialog(url,arguments,features);\n\tif(retVal==\'closed\')\n\t{\n\tsetTimeout(\'close_main_wind()\',1000);\n\t}\n\t}\n}\n\nfunction close_main_wind(){\n\tparent.window.returnValue=\'closed\';\n\tparent.window.close();\n\n}\n\n</script>\n";
    private final static byte[]  _wl_block59Bytes = _getBytes( _wl_block59 );

    private final static java.lang.String  _wl_block60 ="\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block60Bytes = _getBytes( _wl_block60 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
ResultSet rs=null;
Statement stmt=null;
PreparedStatement pstmt=null;
String new_date=(String)request.getParameter("new_appt_date");
String end_time ="";
String clinic_code=(String)request.getParameter("i_clinic_code");
String practitioner_id=(String)request.getParameter("i_practitioner_id");
if( practitioner_id == null || practitioner_id.equals("null") ) practitioner_id="";
String facilityid=(String)session.getValue("facility_id");
String curr_user_id=(String)session.getValue("login_user");
String over_book_rights_yn="";
int no_of_slots = 0;
String over_booked=(String)request.getParameter("over_booked");
if (over_booked== null || over_booked.equals("null") ) over_booked="";
String over_book_yn=(String)request.getParameter("obook_appt_yn");
if (over_book_yn== null || over_book_yn.equals("null") ) over_book_yn="";
String to_over_book_yn=(String)request.getParameter("overbook1");
if (to_over_book_yn== null || to_over_book_yn.equals("null") ) to_over_book_yn="";


String old_date=(String)request.getParameter("i_appt_date");
if(old_date  == null || old_date.equals("null")) old_date="";
String old_from_time=(String)request.getParameter("i_from_time");
if(old_from_time  == null || old_from_time.equals("null")) old_from_time="";
String old_to_time=(String)request.getParameter("i_to_time");
if(old_to_time  == null || old_to_time.equals("null")) old_to_time="";
String appt_ref_no=(String)request.getParameter("i_appt_ref_no");
if(appt_ref_no  == null || appt_ref_no.equals("null")) appt_ref_no="";
String alcn_criteria=(String)request.getParameter("alcn_criteria");
String global_locn_yn="";

String old_pract_id1=(String)request.getParameter("old_pract_id1");
if(old_pract_id1  == null || old_pract_id1.equals("null")) old_pract_id1="";

String old_clinic_code=(String)request.getParameter("old_clinic_code");
if(old_clinic_code  == null || old_clinic_code.equals("null")) old_clinic_code="";

String clinic_type=request.getParameter("clinic_type");
String res_type=request.getParameter("res_type");

if (clinic_type==null) clinic_type = "C";
if (res_type==null) res_type = "P";

String locale=(String)session.getAttribute("LOCALE");




String P_O_PRACTITIONER       ="";       
String P_O_MAX_PAT            ="";       
String P_O_MAX_OVER_BOOK      ="";       
String P_O_BOOKED             ="";       
String P_O_OVER_BOOKED        ="";       

String P_O_TIME_TAB_TYPE     ="";        
String P_O_TO_TIME            ="";       
String P_O_MAX_FORCED_BOOK    ="";
String P_O_FORCED_BOOK		  =""; 	
String P_O_MAX_GLOBAL_BOOK    ="";
String P_O_GLOBAL_BOOK		  =""; 	

String P_O_MAX_SLOTS_FOR_FIRST_VISITS = "";
String P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
String P_O_MAX_FIRST_VISITS = "";
String P_O_MAX_FIRST_VISITSTemp = "";

String P_O_TOTAL_FIRST_VISIT = "";
String new_day = "";
String visit_type_ind = "";
String over_book_sql ="";
String P_O_MAX_SLOTS_PER_DAY="";
String P_O_MAX_OTHER_VISITS="";
String P_O_TOTAL_OTHER_VISITS="";

String TOTAL_NORMAL_TFR="";
String TOTAL_BULK_TFR="";

String slot_appt_ctrl=request.getParameter("slot_appt_ctrl");
String visit_limit_rule=request.getParameter("clinic_type");

no_of_slots = Integer.parseInt(request.getParameter("no_of_slots_value1"));
visit_type_ind =request.getParameter("old_visit_type_ind1");

try
{			

			con = ConnectionManager.getConnection(request);
			stmt=con.createStatement();

			

			String display_details=null;
			if(practitioner_id.equals("")){
			//	display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+new_date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'  and Practitioner_id is null";
				display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=? and care_locn_type_ind =? and resource_class=? and Practitioner_id is null";
			}else{
				//display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,'"+locale+"','1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,'"+locale+"','1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,'"+locale+"','2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id='"+facilityid+"' and clinic_date  =to_date('"+new_date+"','dd/mm/yyyy') and clinic_code='"+clinic_code+"' and care_locn_type_ind ='"+clinic_type+"' and resource_class='"+res_type+"'  and Practitioner_id = '"+practitioner_id+"'";
				display_details="select OP_GET_DESC.OP_CLINIC(FACILITY_ID,CLINIC_CODE,?,'1') clinic_name, decode(resource_class, 'P', AM_GET_DESC.AM_PRACTITIONER(PRACTITIONER_ID,?,'1'), 'R', AM_GET_DESC.AM_FACILITY_ROOM(FACILITY_ID, PRACTITIONER_ID,?,'2'), AM_GET_DESC.AM_RESOURCE(FACILITY_ID, PRACTITIONER_ID,?,'2')) practitioner_name, time_table_type, max_patients_per_day, nvl(max_over_booking,0) max_over_booking, total_slots_booked, nvl(total_slots_overbooked,0)total_slots_overbooked, start_time,end_time, nvl(total_first_visit_slots_booked,0) total_first_visit_slots_booked, nvl(max_slots_for_first_visit,0) max_slots_for_first_visit,  nvl(total_first_visit,0)+nvl(total_first_visits_blocked,0) total_first_visit, nvl(max_first_visits,'') max_first_visits, nvl(max_other_visits,0) max_other_visits, nvl(total_follow_up,0)+nvl(total_routine,0)+nvl(total_series,0)+nvl(total_consult,0)+nvl(total_emergency,0)+nvl(total_other_visits_blocked,0) total_other_visits, nvl(max_slots_per_day,0) max_slots_per_day,nvl(MAX_FORCED_IN_BOOKING,0)MAX_FORCED_IN_BOOKING , nvl(TOTAL_FORCED_IN_BOOKED,0)TOTAL_FORCED_IN_BOOKED, nvl(MAX_GLOBAL_BOOKING,0)MAX_GLOBAL_BOOKING , nvl(TOTAL_GLOBAL_BOOKED,0)TOTAL_GLOBAL_BOOKED, TOTAL_NORMAL_TFR, TOTAL_BULK_TFR from oa_clinic_schedule where facility_id=? and clinic_date  =to_date(?,'dd/mm/yyyy') and clinic_code=? and care_locn_type_ind =? and resource_class=?  and Practitioner_id = ?";
			}
						
		//	rs = stmt.executeQuery(display_details);
			pstmt = con.prepareStatement(display_details);
			pstmt.setString(1,locale);
			pstmt.setString(2,locale);
			pstmt.setString(3,locale);
			pstmt.setString(4,locale);
			pstmt.setString(5,facilityid);
			pstmt.setString(6,new_date);
			pstmt.setString(7,clinic_code);
			pstmt.setString(8,clinic_type);
			pstmt.setString(9,res_type);
			if(practitioner_id.equals("")){
			}
			else{
			pstmt.setString(10,practitioner_id);
			}
			rs = pstmt.executeQuery();
			if(rs!=null){
			while ( rs.next() )
			{

				P_O_PRACTITIONER 	= rs.getString("practitioner_name");
				if( P_O_PRACTITIONER == null) P_O_PRACTITIONER="";
				P_O_MAX_PAT 		= rs.getString("max_patients_per_day");
				P_O_TIME_TAB_TYPE    = rs.getString("time_table_type" );  
				
				P_O_MAX_FORCED_BOOK  =rs.getString("MAX_FORCED_IN_BOOKING");
				if(P_O_MAX_FORCED_BOOK==null)P_O_MAX_FORCED_BOOK="";
				P_O_FORCED_BOOK	=rs.getString("TOTAL_FORCED_IN_BOOKED");
				if(P_O_FORCED_BOOK==null)P_O_FORCED_BOOK="";

				P_O_MAX_GLOBAL_BOOK  =rs.getString("MAX_GLOBAL_BOOKING");
				if(P_O_MAX_GLOBAL_BOOK==null)P_O_MAX_GLOBAL_BOOK="";
				P_O_GLOBAL_BOOK	=rs.getString("TOTAL_GLOBAL_BOOKED");
				if(P_O_GLOBAL_BOOK==null)P_O_GLOBAL_BOOK="";

				TOTAL_NORMAL_TFR  =rs.getString("TOTAL_NORMAL_TFR");
				if(TOTAL_NORMAL_TFR==null)TOTAL_NORMAL_TFR="0";
				TOTAL_BULK_TFR	=rs.getString("TOTAL_BULK_TFR");
				if(TOTAL_BULK_TFR==null)TOTAL_BULK_TFR="0";
				

				P_O_MAX_OVER_BOOK   =rs.getString("max_over_booking" ); 
				if(P_O_MAX_OVER_BOOK==null) P_O_MAX_OVER_BOOK="";
				P_O_BOOKED                 	=rs.getString("total_slots_booked" );   if( P_O_BOOKED ==null) P_O_BOOKED="";
				P_O_OVER_BOOKED        =rs.getString( "total_slots_overbooked" );    if(  P_O_OVER_BOOKED ==null) P_O_OVER_BOOKED="";
				P_O_TO_TIME                  =rs.getString("start_time" );	if(P_O_TO_TIME == null) P_O_TO_TIME="";
				P_O_MAX_SLOTS_FOR_FIRST_VISITS = rs.getString("max_slots_for_first_visit"); if( P_O_MAX_SLOTS_FOR_FIRST_VISITS == null) P_O_MAX_SLOTS_FOR_FIRST_VISITS="";
				P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED= rs.getString("total_first_visit_slots_booked"); if( P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED == null) P_O_TOTAL_VIRST_VISIT_SLOTS_BOOKED="";
				P_O_MAX_FIRST_VISITSTemp = rs.getString("max_first_visits"); 
				
				if( !(P_O_MAX_FIRST_VISITSTemp == null || P_O_MAX_FIRST_VISITSTemp.equals("null"))){
					P_O_MAX_FIRST_VISITS=P_O_MAX_FIRST_VISITSTemp;
				}else{
					P_O_MAX_FIRST_VISITS="";
				}

				P_O_MAX_SLOTS_PER_DAY = rs.getString("MAX_SLOTS_PER_DAY"); if( P_O_MAX_SLOTS_PER_DAY== null) P_O_MAX_SLOTS_PER_DAY="";
				
				P_O_TOTAL_FIRST_VISIT = rs.getString("total_first_visit"); if( P_O_TOTAL_FIRST_VISIT == null) P_O_TOTAL_FIRST_VISIT="";
				P_O_MAX_OTHER_VISITS = rs.getString("max_other_visits"); if( P_O_MAX_OTHER_VISITS == null) P_O_MAX_OTHER_VISITS="";
				P_O_TOTAL_OTHER_VISITS = rs.getString("total_other_visits"); if( P_O_TOTAL_OTHER_VISITS == null) P_O_TOTAL_OTHER_VISITS="";
				if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("P"))
					P_O_BOOKED = String.valueOf(Integer.parseInt(P_O_TOTAL_FIRST_VISIT)+Integer.parseInt(P_O_TOTAL_OTHER_VISITS));
				if (!(visit_limit_rule.equals("N")))
				{
					if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && 	 
					   ! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals(""))
						{
							if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && visit_type_ind.equals("F")&&Integer.parseInt(P_O_MAX_FIRST_VISITS)>0)
												to_over_book_yn         ="Y";					
						}			
					if(! P_O_MAX_FIRST_VISITS.equals("") &&  !P_O_TOTAL_FIRST_VISIT.equals("") && 	 
					   ! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals("")&&visit_limit_rule.equals("E"))
						{
							if (Integer.parseInt(P_O_MAX_FIRST_VISITS) <= Integer.parseInt(P_O_TOTAL_FIRST_VISIT)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && visit_type_ind.equals("F"))
								to_over_book_yn         ="Y";					
						}			

					if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && 	
						! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals("")&&Integer.parseInt(P_O_MAX_OTHER_VISITS)>0)
						{
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS)>0 &&Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && (!(visit_type_ind.equals("F"))))
							to_over_book_yn         ="Y";
					}
						if(! P_O_MAX_OTHER_VISITS.equals("") &&  !P_O_TOTAL_OTHER_VISITS.equals("") && 	
						! P_O_MAX_OVER_BOOK.equals("")    && !P_O_OVER_BOOKED.equals("")&&visit_limit_rule.equals("E"))
						{
						if (Integer.parseInt(P_O_MAX_OTHER_VISITS) <= Integer.parseInt(P_O_TOTAL_OTHER_VISITS)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED) && (!(visit_type_ind.equals("F"))))
							to_over_book_yn         ="Y";
					}
					
/*If condition added by S.Sathish for IN019815 on Monday, March 15, 2010*/
					 if(!P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals(""))
						if((Integer.parseInt(P_O_MAX_PAT) > Integer.parseInt(P_O_BOOKED)) && (old_date.equals(new_date)) && (old_pract_id1.equals(practitioner_id)) && (old_clinic_code.equals(clinic_code))){
							to_over_book_yn         ="N";
						}




				}
				if(! P_O_MAX_PAT.equals("") &&  !P_O_BOOKED.equals("") && !P_O_MAX_OVER_BOOK.equals("") && !P_O_OVER_BOOKED.equals(""))
					{
		 				if (Integer.parseInt(P_O_MAX_PAT) == Integer.parseInt(P_O_BOOKED)  &&  Integer.parseInt(P_O_MAX_OVER_BOOK)  > Integer.parseInt(P_O_OVER_BOOKED))							to_over_book_yn         ="Y";
					}
				}

			}
			if(rs !=null) rs.close();
	 if (to_over_book_yn.equals("Y"))
		{
		 if(practitioner_id.equals("")){
			// over_book_sql = "select to_char(to_date('"+new_date+"','dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id ='"+facilityid+"' and clinic_code = '"+clinic_code+"' and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and practitioner_id is null";
			 over_book_sql = "select to_char(to_date(?,'dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id =? and clinic_code = ? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id is null";
		 }else{
			 //over_book_sql = "select to_char(to_date('"+new_date+"','dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id ='"+facilityid+"' and clinic_code = '"+clinic_code+"' and clinic_date=to_date('"+new_date+"','dd/mm/yyyy') and practitioner_id ='"+practitioner_id+"'";
			 over_book_sql = "select to_char(to_date(?,'dd/mm/yyyy'),'Day') new_day, to_char(end_time,'hh24:mi') end_time from oa_clinic_schedule where facility_id =? and clinic_code = ? and clinic_date=to_date(?,'dd/mm/yyyy') and practitioner_id =?";
		 }
		//rs = stmt.executeQuery(over_book_sql);
		pstmt = con.prepareStatement(over_book_sql);
		pstmt.setString(1,new_date);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,clinic_code);
		pstmt.setString(4,new_date);
		if(practitioner_id.equals("")){
		 }else{
		pstmt.setString(5,practitioner_id);
		}
		rs = pstmt.executeQuery();
		while(rs!=null&&rs.next())
			{
			new_day = rs.getString("new_day");
			end_time = rs.getString("end_time");
			}
		if (rs!=null) rs.close();
		 //over_book_sql = "select nvl(b.obook_appt_yn,'N') over_book_rights_yn,global_locn_yn from op_clinic a,am_os_user_locn_access_vw b where a.clinic_code ='"+clinic_code+"' and a.facility_id='"+facilityid+"'  and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind='A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id='"+facilityid+"'  AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id ='"+curr_user_id+"' AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id='"+curr_user_id+"' and (b.book_appt_yn='Y' or b.book_appt_wo_pid_yn='Y' or b.obook_appt_yn='Y' or b.book_appt_across_catg_yn='Y' or b.tfr_appt_yn='Y' or b.tfr_appt_across_catg_yn='Y' or b.canc_appt_yn='Y') ";
		 over_book_sql = "select nvl(b.obook_appt_yn,'N') over_book_rights_yn,global_locn_yn from op_clinic a,am_os_user_locn_access_vw b where a.clinic_code =? and a.facility_id=? and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn='Y' and a.level_of_care_ind='A' and b.oper_stn_id=(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=?  AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.appl_user_id=? and (b.book_appt_yn='Y' or b.book_appt_wo_pid_yn='Y' or b.obook_appt_yn='Y' or b.book_appt_across_catg_yn='Y' or b.tfr_appt_yn='Y' or b.tfr_appt_across_catg_yn='Y' or b.canc_appt_yn='Y') ";
		//rs = stmt.executeQuery(over_book_sql);
		pstmt = con.prepareStatement(over_book_sql);
		pstmt.setString(1,clinic_code);
		pstmt.setString(2,facilityid);
		pstmt.setString(3,facilityid);
		pstmt.setString(4,curr_user_id);
		pstmt.setString(5,curr_user_id);
		rs = pstmt.executeQuery();
		while(rs!=null&&rs.next())
			{
			over_book_rights_yn = rs.getString("over_book_rights_yn");
			global_locn_yn = rs.getString("global_locn_yn");
			if(global_locn_yn==null)global_locn_yn="N";
			}
		if (rs!=null) rs.close();


		}		
		if(alcn_criteria==null)alcn_criteria="";


String new_date_display=DateUtils.convertDate(new_date,"DMY","en",locale);


            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(new_date_display));
            _bw.write(_wl_block11Bytes, _wl_block11);
		
		if ( (to_over_book_yn.equals("Y") && global_locn_yn.equals("N")) && no_of_slots <=1) 
		{
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
 if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);
}
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
if (P_O_TIME_TAB_TYPE.equals("1") && slot_appt_ctrl.equals("S")){
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_O_MAX_SLOTS_PER_DAY));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(P_O_MAX_PAT));
            _bw.write(_wl_block16Bytes, _wl_block16);
}
            _bw.write(_wl_block26Bytes, _wl_block26);
if(P_O_MAX_FIRST_VISITS.equals("0")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_O_MAX_FIRST_VISITS));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block30Bytes, _wl_block30);
if(P_O_MAX_OTHER_VISITS.equals("0")){
            _bw.write(_wl_block27Bytes, _wl_block27);
}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_O_MAX_OTHER_VISITS));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(P_O_MAX_OVER_BOOK));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(P_O_MAX_GLOBAL_BOOK));
            _bw.write(_wl_block33Bytes, _wl_block33);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_O_MAX_FORCED_BOOK));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(P_O_BOOKED));
            _bw.write(_wl_block37Bytes, _wl_block37);
if(P_O_BOOKED.equals("")){ //Added by S.Sathish for IN019815 on Monday, March 15, 2010 starts here
				P_O_BOOKED="0";
			
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(P_O_BOOKED));
            _bw.write(_wl_block29Bytes, _wl_block29);
				
			}else{
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(P_O_BOOKED));
            _bw.write(_wl_block29Bytes, _wl_block29);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(P_O_TOTAL_FIRST_VISIT));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_TOTAL_OTHER_VISITS));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_OVER_BOOKED));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(P_O_GLOBAL_BOOK));
            _bw.write(_wl_block41Bytes, _wl_block41);
if (!P_O_TIME_TAB_TYPE.equals("3")){
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(P_O_FORCED_BOOK));
            _bw.write(_wl_block16Bytes, _wl_block16);
}else{
            _bw.write(_wl_block34Bytes, _wl_block34);
}
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(TOTAL_NORMAL_TFR));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(TOTAL_BULK_TFR));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(appt_ref_no));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(clinic_code));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(practitioner_id));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(new_date));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(end_time));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(over_booked));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(over_book_yn));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(to_over_book_yn));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(old_date));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(P_O_TIME_TAB_TYPE));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(over_book_rights_yn));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(alcn_criteria));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(res_type));
            _bw.write(_wl_block57Bytes, _wl_block57);
            out.print( String.valueOf(clinic_type));
            _bw.write(_wl_block58Bytes, _wl_block58);
            out.print( String.valueOf(new_day));
            _bw.write(_wl_block59Bytes, _wl_block59);
 
	if (rs != null) rs.close();
	if (stmt != null) stmt.close();

}catch(Exception e) { 
	//out.println(e);
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(con,request);
}

  
            _bw.write(_wl_block60Bytes, _wl_block60);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Schedule.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Slot.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.patient.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.firstvisit.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.othervisit.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.overbooking.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Global.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.Forced.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.NormalReschedule.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.count.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOA.BulkReschedule.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${oa_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.count.label", java.lang.String .class,"key"));
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
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.maximum.label", java.lang.String .class,"key"));
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
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.booked.label", java.lang.String .class,"key"));
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
}
