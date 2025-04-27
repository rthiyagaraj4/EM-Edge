package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import eCommon.Common.*;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __dairyscheduleforsuregonrecord extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/DairyScheduleForSuregonRecord.jsp", 1709120206000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n<script language=\'javascript\' src=\'../../eOT/js/DairyScheduleForSuregon.js\'></script>\n<script language=\'javascript\' src=\'../../eOT/js/Hashtable.js\'></script>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body onLoad=\"spltyEnaDis();\" OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n<form name=\"DiaryScheduleForSurgeonForm\" id=\"DiaryScheduleForSurgeonForm\"  >\n<input type=\'hidden\' name=\'params\' id=\'params\' value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<table border=\'0\' cellspacing=\'0\' cellpadding=\'3\' width=\'100%\'  >\n\n<tr>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<td class=\"label\">\n\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</td>\n\t<td class=\"fields\">\n\t\t<input type=\"hidden\" name=\"surgeon_code\" id=\"surgeon_code\" value=\"*ALL\" >\n\t<input type=\"text\" name=\"surgeon_desc\" id=\"surgeon_desc\" size=10  value=\"*All Surgeons\" disabled>\n\t<input type=\"button\" class=\"button\" name=\"generic_search_for_day\" id=\"generic_search_for_day\" value=\"?\" disabled>\n\t</td>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<td class=\"label\">\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t</td>\n\t<td class=\"fields\">\n\t\t<input type=\"hidden\" name=\"surgeon_code\" id=\"surgeon_code\" value=\"\" >\n\t<input type=\"text\" name=\"surgeon_desc\" id=\"surgeon_desc\" value=\"\" size=10 onblur=\"if(this.value!=\'\')callSurgeoncode(surgeon_desc); else surgeon_code.value=\'\' \">\n\t<input type=\"button\" class=\"button\" name=\"generic_search_for_day\" id=\"generic_search_for_day\" value=\"?\" onclick=\'callSurgeoncode(surgeon_desc)\' >\n\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n\t<td class=\"label\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t<td align=\"left\">\n\t<input type=\"hidden\" name=\"speciality_code\" id=\"speciality_code\" value=\"\">\n\t<input type=\"text\" name=\"speciality_desc\" id=\"speciality_desc\" value=\"\" size=\'8\' \n\tonBlur=\"if(this.value!=\'\')callSpecialitycode(speciality_code,speciality_desc); else speciality_code.value=\'\' \">\n\t<input type=\"button\" class=\"button\" name=\"generic_search_for_speciality\" id=\"generic_search_for_speciality\" value=\"?\"  onclick=\'callSpecialitycode(speciality_code,speciality_desc);\' ><img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n</tr>\n<tr>\n\t<td class=\"label\">\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t</td>\n\t<td class=\"fields\">\n\t<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t<input type=\"text\" name=\"start_time\" id=\"start_time\" value=\"\"  size=\'5\' maxlength=\'5\' onblur=\'isValidTime(this);chkTimeRange();checkUnitTime();calcSlots();\' >\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<input type=\"text\" name=\"start_time\" id=\"start_time\" value=\"\"  size=\'5\' maxlength=\'5\' onblur=\'isValidTime(this);\' >\n\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n\t<img src=\'../../eCommon/images/mandatory.gif\'> (hh24:mi)\n\t</td>\n\n\t<td class=\"label\">\n\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t<input type=\"text\" name=\"end_time\" id=\"end_time\" value=\"\"  size=\'5\' maxlength=\'5\' onblur=\' isValidTime(this);chkTimeRange();checkUnitTime();calcSlots();\'><img src=\'../../eCommon/images/mandatory.gif\'>(hh24:mi)\n\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<input type=\"text\" name=\"end_time\" id=\"end_time\" value=\"\"  size=\'5\' maxlength=\'5\' onblur=\' isValidTime(this);\'><img src=\'../../eCommon/images/mandatory.gif\'>(hh24:mi)\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n\t</td>\n</tr>\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n<tr>\n\t<td class=\"label\">\n\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t</td>\n\t<td class=\"fields\">\n\t<input type=\"text\" name=\"total_Slots\" id=\"total_Slots\" value=\"\"  size=\'4\' disabled >\n\t</td>\n\n\t<td class=\"label\">\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t</td>\n\t<td class=\"fields\">\n\t<input type=\"text\" name=\"restricted_Slots\" id=\"restricted_Slots\" value=\"\"  size=\'4\' maxlength=\'4\' onblur=\'checkResSlotsNumber(\"restricted_Slots\");\'><img src=\'../../eCommon/images/mandatory.gif\'>&nbsp;&nbsp;Slots\t\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n<tr>\n\t<td class=\"label\">\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t</td>\n\t<td class=\"fields\">\n\t\t<select name=\"schedule_type\" id=\"schedule_type\" onchange=\'chkBoxEnableDisable(this);\' >\n\t\t<option value=\'A\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</option>\n\t\t<option value=\'S\' selected>";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</option>\n\t\t</select>\n\t</td>\n\n\t<td class=\"label\">\n\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n\t</td>\n\t<td class=\'fields\'>\n\t<input type=\"hidden\" name=\"day_code\" id=\"day_code\" value=\"\">\n\t<input type=\"hidden\" name=\"day_status\" id=\"day_status\" value=\"\">\n\t<select name=\"days\" id=\"days\" onchange=\"assignDayStatus(this);\">\n\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\t\n             <option value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\" >";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="</option>\n ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'LABELLEFT\' nowrap>\n\t\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t</td>\n\t<td class=\'LABELLEFT\' nowrap>\n\t\t\t\t1W<input type=\"checkbox\" name=\"week1\" id=\"week1\" value=\"N\"  onClick=\"setCheckValue(this)\">&nbsp;&nbsp;\n\t\t\t\t2W<input type=\"checkbox\" name=\"week2\" id=\"week2\" value=\"N\"  onClick=\"setCheckValue(this)\">&nbsp;&nbsp;\n\t\t\t\t3W<input type=\"checkbox\" name=\"week3\" id=\"week3\" value=\"N\"  onClick=\"setCheckValue(this)\">&nbsp;&nbsp;\n\t\t\t\t4W<input type=\"checkbox\" name=\"week4\" id=\"week4\" value=\"N\"  onClick=\"setCheckValue(this)\">&nbsp;&nbsp;\n\t\t\t\t5W<input type=\"checkbox\" name=\"week5\" id=\"week5\" value=\"N\"  onClick=\"setCheckValue(this)\">\n\t</td>\n\n    <td class=\'button\' colspan=\"2\" nowrap width=\'20%\'>\t\t\n\t\t<input type=\'button\' name=\'select\' id=\'select\' class=\'button\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\' onClick=\'addRow();spltyEnaDis()\'   >\n\t\t<input type=\'button\' name=\'cancel\' id=\'cancel\' class=\'button\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\' onClick=\'removeRow();spltyEnaDis()\'  >\n\t</td>\n\n\t\t\n</tr>\n</table>\n\t";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t\t\t\t\t <img src=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\' width=\'100%\' height=\'15\'/> \n\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\n<input type=\'hidden\' name=\'recId\' id=\'recId\' value=\'\'>\n<input type=\'hidden\' name=\'mode\' id=\'mode\' value=\'I\'>\n<input type=\'hidden\' name=\'selected_weeks\' id=\'selected_weeks\' value=\"\">\n<input type=\'hidden\' name=\'oper_room_code1\' id=\'oper_room_code1\' value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\'hidden\' name=\'theatre_code\' id=\'theatre_code\' value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\'hidden\' name=\'unit_ot_time_DB\' id=\'unit_ot_time_DB\' value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n<input type=\'hidden\' name=\'wd_start_time\' id=\'wd_start_time\' value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n<input type=\'hidden\' name=\'wd_end_time\' id=\'wd_end_time\' value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n<input type=\'hidden\' name=\'hd_start_time\' id=\'hd_start_time\' value=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n<input type=\'hidden\' name=\'hd_end_time\' id=\'hd_end_time\' value=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n<input type=\'hidden\' name=\'menu_change_flag\' id=\'menu_change_flag\' value=\"";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\">\n<input type=\'hidden\' name=\'restrict_by_splty_yn\' id=\'restrict_by_splty_yn\' value=\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\">\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n<input type=\'hidden\' name=\'ot_Param\' id=\'ot_Param\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<!-- CRF-004 Authorize Slots for Booking - Rajesh V -->\n</form>\n</body>\n</html>\n\n\n";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
String imgUrl="";
	if(sStyle.equals("IeStyle.css"))
	 {
			imgUrl= "../../eCommon/images/searchBoxBG.jpg";	 
	 }


            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block7Bytes, _wl_block7);

String restrict_by_splty_yn=request.getParameter("restrict_by_splty_yn");
String locale = (String)session.getAttribute("LOCALE"); 
request.setCharacterEncoding("UTF-8");
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
String oper_room = checkForNull(request.getParameter("oper_room_code"));
String oper_room_cde[]=oper_room.split("@@");
String oper_room_code=oper_room_cde[0];
String facility_id=(String) session.getAttribute("facility_id");
String all_days_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AllDays.label","common_labels");
String all_days="";
String code1="";
String status1="";
String val="";
String day_code="";
//String speciality_desc=""; 
//String speciality_code="";
//String day_code="";
//String day_desc="";
//String start_time="";
//String end_time="";
String sql="";
String unit_ot_time="";
String sqlForUnitTime="SELECT TO_CHAR(unit_ot_time, 'hh24:mi') FROM   ot_param_for_facility  WHERE  operating_facility_id = ?"; 

//Modified against 046233
//sql="SELECT A.RESOURCE_ID RESOURCE_ID, A.SPECIALITY_CODE,B.SHORT_DESC,A.DAY_CODE,DECODE(A.DAY_CODE,0,'"+all_days_title+"', (SELECT DAY_OF_WEEK FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_OF_WEEK, TO_CHAR(A.FROM_TIME,'HH24:MI'), TO_CHAR(A.TO_TIME,'HH24:MI'),NVL(A.FIRST_WEEK_YN,'N'),NVL(A.SECOND_WEEK_YN,'N'), NVL(A.THIRD_WEEK_YN,'N'), NVL(A.FOURTH_WEEK_YN,'N'), NVL(A.FIFTH_WEEK_YN,'N'),A.SCHEDULE_TYPE, D.SHORT_NAME, DECODE(A.DAY_CODE,0,'W',(SELECT DAY_STATUS FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_STATUS,  NVL(AVAILABLE_SLOTS,0) AVAILABLE_SLOTS, PERMISSIBLE_SLOTS FROM OT_DIARY_TIMETABLE A, (SELECT LANGUAGE_ID, SPECIALITY_CODE, SHORT_DESC FROM AM_SPECIALITY_LANG_VW UNION SELECT LANGUAGE_ID, '*ALL', NVL(short_desc, 'All Specialities') FROM am_speciality_lang_vw Where language_id='"+locale+"' and speciality_code = '*ALL') B, (SELECT PRACTITIONER_ID, SHORT_NAME FROM AM_PRACTITIONER UNION SELECT '*ALL' PRACTITIONER_ID, '*All Surgeons' SHORT_NAME FROM DUAL)D WHERE B.LANGUAGE_ID='"+locale+"' AND A.SPECIALITY_CODE= B.SPECIALITY_CODE AND A.OPERATING_FACILITY_ID=? AND A.OPER_ROOM_CODE =? AND A.RESOURCE_ID = D.PRACTITIONER_ID ORDER BY 2";

//Modified against IN048952
sql="SELECT A.RESOURCE_ID RESOURCE_ID, A.SPECIALITY_CODE,B.SHORT_DESC,A.DAY_CODE,DECODE(A.DAY_CODE,0,?, (SELECT DAY_OF_WEEK FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_OF_WEEK, TO_CHAR(A.FROM_TIME,'HH24:MI'), TO_CHAR(A.TO_TIME,'HH24:MI'),NVL(A.FIRST_WEEK_YN,'N'),NVL(A.SECOND_WEEK_YN,'N'), NVL(A.THIRD_WEEK_YN,'N'), NVL(A.FOURTH_WEEK_YN,'N'), NVL(A.FIFTH_WEEK_YN,'N'),A.SCHEDULE_TYPE, D.SHORT_NAME, DECODE(A.DAY_CODE,0,'W',(SELECT DAY_STATUS FROM  OT_DAY_OF_WEEK  X WHERE  NVL(DAY_STATUS, '$') <> 'S' AND X.DAY_CODE = A.DAY_CODE)) DAY_STATUS,  NVL(AVAILABLE_SLOTS,0) AVAILABLE_SLOTS, PERMISSIBLE_SLOTS FROM OT_DIARY_TIMETABLE A, (SELECT LANGUAGE_ID, SPECIALITY_CODE, SHORT_DESC FROM AM_SPECIALITY_LANG_VW UNION SELECT LANGUAGE_ID, '*ALL', 'All Specialities' FROM sm_language Where language_id=?) B, (SELECT PRACTITIONER_ID, SHORT_NAME FROM AM_PRACTITIONER UNION SELECT '*ALL' PRACTITIONER_ID, '*All Surgeons' SHORT_NAME FROM DUAL)D WHERE B.LANGUAGE_ID=? AND A.SPECIALITY_CODE= B.SPECIALITY_CODE AND upper(b.short_desc) != '*ALL' AND A.OPERATING_FACILITY_ID=? AND A.OPER_ROOM_CODE =? AND A.RESOURCE_ID = D.PRACTITIONER_ID ORDER BY 2";
String otParam = "";
//CRF-004 Authorize Slots for Booking - Rajesh V
Connection con=null;
PreparedStatement stmt=null;
ResultSet rs=null;
PreparedStatement stmt1=null;
ResultSet rs1=null;
String wd_start_time = "";
String wd_end_time = "";
String hd_start_time = "";
String hd_end_time = "";
String args = "";
String menu_change_flag="";
try{
	String sql_1 = "SELECT TO_CHAR(WD_START_TIME, 'HH24:MI') WD_START_TIME, TO_CHAR(WD_END_TIME, 'HH24:MI') WD_END_TIME, TO_CHAR(HD_START_TIME, 'HH24:MI') HD_START_TIME, TO_CHAR(HD_END_TIME, 'HH24:MI') HD_END_TIME FROM OT_OPER_ROOM WHERE  OPERATING_FACILITY_ID = ? AND OPER_ROOM_CODE = ?";
	con=ConnectionManager.getConnection(request);
	stmt=con.prepareStatement(sql_1);
    stmt.setString(1,facility_id);
	stmt.setString(2,oper_room_code);
	rs=stmt.executeQuery();
	while(rs.next()){		
		wd_start_time = rs.getString("WD_START_TIME");
		wd_end_time = rs.getString("WD_END_TIME");
		hd_start_time = rs.getString("HD_START_TIME");
		hd_end_time = rs.getString("HD_END_TIME");
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	
	//CRF-004 Authorize Slots for Booking - Rajesh V
	String sqlFacilityChk = "select NVL(SCHEDULE_RESTRICT_YN,'N') facility from OT_PARAM where rownum = 1";
	stmt=con.prepareStatement(sqlFacilityChk);
	rs=stmt.executeQuery();
	if(rs !=null && rs.next())
	{
		otParam=checkForNull(rs.getString("facility"));		
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	//CRF-004 Authorize Slots for Booking - Rajesh V
	//Newly Added By rajesh on 22/10 for defaulting all surgeons....,

	String sql_surgeon_yn="select DIARY_SCHED_FOR_SURG_REQD_YN from ot_param_for_facility where OPERATING_FACILITY_ID=?";
	stmt=con.prepareStatement(sql_surgeon_yn);
	stmt.setString(1,facility_id);
	rs=stmt.executeQuery();
	while (rs.next()){
		menu_change_flag=rs.getString(1);	
	}

	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();

	stmt1=con.prepareStatement(sqlForUnitTime);
	stmt1.setString(1,facility_id);
	rs1=stmt1.executeQuery();
	if(rs1.next()){
        unit_ot_time=rs1.getString(1);
	}
	if(stmt1!=null)stmt.close();
	if(rs1!=null)rs1.close();
	stmt=con.prepareStatement(sql);
	stmt.setString(1,all_days_title);
	stmt.setString(2,locale);
	stmt.setString(3,locale);
	stmt.setString(4,facility_id);
	stmt.setString(5,oper_room_code);
	rs=stmt.executeQuery();
	int index=0;
	while(rs.next()){
		index++;
		//CRF-004 Authorize Slots for Booking - Rajesh V
		if("Y".equalsIgnoreCase(otParam)){
		args = rs.getString(1)+"##"+rs.getString(2)+"##"+rs.getString(3)+"##"+rs.getString(4)+"@@"+rs.getString(15)+"##"+rs.getString(5)+"##"+rs.getString(6)+"##"+rs.getString(7)+"##"+rs.getString(8)+rs.getString(9)+rs.getString(10)+rs.getString(11)+rs.getString(12)+"##"+rs.getString(13)+"##"+rs.getString(14)+"##L"+"##"+rs.getString(16)+"##"+rs.getString(17);
		System.err.println("IF args.... ===> "+args);
		}
		else{
		args = rs.getString(1)+"##"+rs.getString(2)+"##"+rs.getString(3)+"##"+rs.getString(4)+"@@"+rs.getString(15)+"##"+rs.getString(5)+"##"+rs.getString(6)+"##"+rs.getString(7)+"##"+rs.getString(8)+rs.getString(9)+rs.getString(10)+rs.getString(11)+rs.getString(12)+"##"+rs.getString(13)+"##"+rs.getString(14)+"##L";
		System.err.println("ELSE args.... ===> "+args);
		}
		//CRF-004 Authorize Slots for Booking - Rajesh V
		out.println("<script>loadDBRows('"+args+"')</script>");
	}
	out.println("<script>refresh()</script>");

	
}catch(Exception e){
	e.printStackTrace();
	//System.err.println("Error in DairyScheduleForSuregonRecord.jsp"+e.getMessage());
}finally{
	try{
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		
		if(con!=null) 
		ConnectionManager.returnConnection(con,request);
	}catch(Exception e){e.printStackTrace();}
}

            _bw.write(_wl_block8Bytes, _wl_block8);

if(menu_change_flag.equals("N")){

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
}else{
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
}
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if("Y".equalsIgnoreCase(otParam)){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
	else{
            _bw.write(_wl_block17Bytes, _wl_block17);
}
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
if("Y".equalsIgnoreCase(otParam)){
            _bw.write(_wl_block19Bytes, _wl_block19);
}
	else{
            _bw.write(_wl_block20Bytes, _wl_block20);
}
            _bw.write(_wl_block21Bytes, _wl_block21);
if("Y".equalsIgnoreCase(otParam)){
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);
}
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

	try{
        con=ConnectionManager.getConnection(request);
		sql="SELECT 'ALL DAYS' DESCRIPTION1,'0' CODE1,'W' STATUS1 FROM   DUAL  UNION  SELECT INITCAP(DAY_OF_WEEK) DESCRIPTION2,DAY_CODE CODE2,DAY_STATUS STATUS2 FROM  OT_DAY_OF_WEEK  WHERE  NVL(DAY_STATUS, '$') <> 'S' ORDER BY 2";
		stmt=con.prepareStatement(sql);
		rs=stmt.executeQuery();
		while(rs!=null && rs.next()){
			 all_days=rs.getString(1);
			 day_code=rs.getString(2);
			 code1=rs.getString(2)+"@@"+rs.getString(3);
			 status1=rs.getString(3);
			 val=rs.getString(1)+"---("+rs.getString(3)+")";
 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(code1));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(val));
            _bw.write(_wl_block32Bytes, _wl_block32);
  }
	}catch(Exception e){e.printStackTrace();}
	finally{
		try{
		 if(rs!=null) rs.close();
		 if(stmt!=null) stmt.close();
			ConnectionManager.returnConnection(con);
		}catch(Exception e){e.printStackTrace();}
     }
 
            _bw.write(_wl_block33Bytes, _wl_block33);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block34Bytes, _wl_block34);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
if(!imgUrl.equals("")){ 
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(imgUrl));
            _bw.write(_wl_block38Bytes, _wl_block38);
}
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(oper_room_code));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(unit_ot_time));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(wd_start_time));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(wd_end_time));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(hd_start_time));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(hd_end_time));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(menu_change_flag));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(restrict_by_splty_yn));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(otParam));
            _bw.write(_wl_block51Bytes, _wl_block51);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Surgeon.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartTime.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.EndTime.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.TotalSlots.Label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.PermissibleSlots.Label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.ScheduleType.Label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.AllWeeks.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.SpecificWeeks.Label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.day.label", java.lang.String .class,"key"));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.weeks.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.cancel.label", java.lang.String .class,"key"));
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
}
