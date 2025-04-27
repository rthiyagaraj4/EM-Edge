package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.text.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import eCommon.XSSRequestWrapper;
import webbeans.eCommon.ConnectionManager;
import java.util.Properties;
import eOT.Common.OTRepository;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.*;
import com.ehis.util.*;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __bookingcancel extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/BookingCancel.jsp", 1725001334000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html>\n<script type=\'text/javascript\' src=\'../../eCommon/js/common.js\'></script>\n<head>\n\t<title> ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"/>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></Script>\n\t<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n\t<script type=\'text/javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t<script type=\'text/javascript\' src=\'../../eOT/js/Booking.js\'></script>\n\t<script type=\"text/javascript\" src=\"../../eOT/js/OTCommon.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n<script type=\"text/javascript\">\n\treschedule_value=getLabel(\"Common.Reschedule.label\",\"common\");\n\treason_value=getLabel(\"Common.reason.label\",\"common\");\n\ttransfer_value=getLabel(\"Common.Transfer.label\",\"common\");\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<form name=\'PreOperHdr\' id=\'PreOperHdr\' >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body OnMouseDown=\'CodeArrest()\' onKeyDown = \'lockKey()\'>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\n<table border=\"1\" cellpadding=3 cellspacing=\"0\" width=\"100%\" align=\'center\'>\n<tr> \n\t<th class=\'columnheader\' >";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</th>\n</tr>\n</table>\n\n<table border=\'0\' cellpadding=3 cellspacing=\'0\' width=\'100%\' align=\'center\'>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n<tr>\n     <td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t<td  class=\'fields\' width=\"25%\" >\n\t\t<input type=\'text\' class=\'fields\' name=\'transfer_to\' id=\'transfer_to\' size=\'30\'   value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' disabled>\n\t</td>\n</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<tr>\n\t<td class=\'label\' width=\"25%\" >";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</td>\n\t<td  class=\'fields\' width=\"25%\" >\n\t\t<input type=\'text\' class=\'fields\' name=\'cancel_by1\' id=\'cancel_by1\' size=\'30\'   value=\'";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\' disabled>\n\t\t<!-- Added cancel_by hidden field by AnithaJ for 24448 on 10/18/2010-->\n\t\t<input type=\'hidden\' name=\'cancel_by\' id=\'cancel_by\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t</td>\n\t<td class=\'label\' width=\"25%\">\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t</td>\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\'text\' class=\'fields\' name=\'cancel_date\' id=\'cancel_date\' size=\'15\'   value=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\' disabled>\n\t</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\"25%\"   >\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</td>\n\t<td class=\'fields\' width=\"25%\"  colspan=\"3\">\n\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t<input type=\'text\' name=\'reason_desc\' id=\'reason_desc\' size=\'80\'  class=\'fields\' width=\"25%\" onblur=\"if(this.value!=\'\')callOnBlurReshedule(this,reschedule_value,\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\');\" value=\"\" >\n\t\t<input type=\'hidden\' name=\'reason_code\' id=\'reason_code\' value=\"\">\n\t\t<input type=\'button\' class=\'button\' name=\'quest1\' id=\'quest1\' value=\'?\' onClick=\"funOTCheckDetail1(\'Reshedule\',reschedule_value,\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\')\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t</img>\n\t</td>\n\t";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<input type=\'text\' name=\'reason_desc\' id=\'reason_desc\' size=\'80\' align=\'right\'  value=\"\" onblur=\"if(this.value!=\'\')callOnBlurReasonCode(this,transfer_value,\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\');\">\n\t\t<input type=\'hidden\' name=\'reason_code\' id=\'reason_code\' value=\"\">\n\t\t<input type=\'button\' class=\'button\' name=\'quest1\' id=\'quest1\' value=\'?\' onClick=\"funOTCheckDetail1(\'Transfer\',transfer_value,\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t<input type=\'text\' name=\'reason_desc\' id=\'reason_desc\' size=\'80\'  align=\'right\'  value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\" onblur=\"if(this.value!=\'\')callOnBlurReasonCode(this,reschedule_value,\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\');\">\n\t\t<input type=\'hidden\' name=\'reason_code\' id=\'reason_code\' value=\"\">\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t<input type=\'button\' class=\'button\' name=\'quest1\' id=\'quest1\' value=\'?\' onClick=\"funOTCheckDetail1(\'Reason\',reason_value,\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\">\n\t\t<img src=\'../../eCommon/images/mandatory.gif\'>\n\t\t</img>\n\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t</td>\n\t</tr>\n\t\n\t\n\t<tr>\n\t\t<td class=\'label\' width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\" colspan=\"3\">\n\t\t";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t\t</td>\n\t\t</tr>\n\t\t\n\t";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n\t\t<tr>\n\t\t<td class=\'label\' width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\n\t\t</td>\n\t\t<td class=\'fields\' width=\"25%\">\n\t\t\t<input type=\"checkbox\" name=\"ward_informed_yn\" id=\"ward_informed_yn\" onclick=\"checkWardInformedYN();\" ";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 =" ";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 =" >\n\t\t</td>\n\t<td class=\'label\' width=\"25%\">\n\t\t\t";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\n\t\t\t";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n\t</td>\n\n\t<td class=\'fields\' width=\"25%\">\n\t\t<input type=\'text\' name=\'inform_date\' id=\'inform_date\' size=\'8\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\' maxlength=\'10\' onBlur=\"isValidDate(this);\"  disabled >\n\t\t<input type=\'text\' name=\'inform_time\' id=\'inform_time\' size=\'2\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\' maxlength=\'5\' onBlur=\"isValidTime(this);\" disabled>\n\t\t<img type=\'image\' id=\"img1\" src=\"../../eCommon/images/Blank1.gif\"></img>\n\t\t</td>\t\t\n</tr>\t\n<tr>\n\t<td class=\'label\' width=\"25%\" >\n\t\t";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 =" \n\t</td>\n\t<td class=\'fields\' width=\"25%\" colspan=\"3\" >\n\t\t<input type=\"text\" name=\"cancelled_remarks\" id=\"cancelled_remarks\" maxlength=\'80\' size=\'80\' value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\" disabled>\n\t\t<img type=\'image\' id=\"img2\" src=\"../../eCommon/images/Blank1.gif\"></img>\n\t\t<img type=\'image\' id=\"img3\" src=\"../../eCommon/images/Blank1.gif\"></img>\n\n\t</td>\n</tr>\n\t";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\n</table>\n<input type=\'hidden\' name=\'orderid\' id=\'orderid\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\'hidden\' name=\'booking_num\' id=\'booking_num\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'startTime\' id=\'startTime\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'> <!-- 44528 - Chaitanya -->\n<input type=\'hidden\' name=\'endTime\' id=\'endTime\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=\'hidden\' name=\'start_time\' id=\'start_time\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'newTime\' id=\'newTime\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'called_from\' id=\'called_from\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\">\n<input type=\'hidden\' name=\'dt_time\' id=\'dt_time\' value=\"";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

    private final static java.lang.String  _wl_block55 ="\">\n<input type=\'hidden\' name=\'function_id\' id=\'function_id\' value=\"";
    private final static byte[]  _wl_block55Bytes = _getBytes( _wl_block55 );

    private final static java.lang.String  _wl_block56 ="\">\n<input type=\'hidden\' name=\'over_booking_case_yn\' id=\'over_booking_case_yn\' value=\"";
    private final static byte[]  _wl_block56Bytes = _getBytes( _wl_block56 );

    private final static java.lang.String  _wl_block57 ="\"> <!-- added By Yadav Icn 13718 -->\n</form>\n</BODY>\n</HTML>\n\n\n\n\n";
    private final static byte[]  _wl_block57Bytes = _getBytes( _wl_block57 );
 
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

//Added Against MMS Vulnerability Issue - Starts
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
//Added Against MMS Vulnerability Issue - Ends

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");
String locale = (String)session.getAttribute("LOCALE");


            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Properties p= (Properties)session.getValue("jdbc");
	String login_user=""+p.getProperty("login_user");
	String flag=checkForNull(request.getParameter("transfer"));
	int choice = (!flag.equals(""))?Integer.parseInt(flag):0;
	String strOrderId=checkForNull(request.getParameter("orderid"));
	String strCancelFlag=checkForNull(request.getParameter("cancel_flag"));
	String strBookingNum=checkForNull(request.getParameter("booking_no"));
	String startTime = checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
	String endTime = checkForNull(request.getParameter("endTime"));
	String start_time = checkForNull(request.getParameter("start_time"));
	String timeDifference = checkForNull(request.getParameter("timeDifference"));
	String newTime = "";
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		if(start_time != null && start_time.trim().length() > 0 && timeDifference !="") // condition Added for IN:45296 //added against 54761		
		{
			Date d = df.parse(start_time);
			Calendar cal = Calendar.getInstance();
			cal.setTime(d);
			cal.add(Calendar.MINUTE, Integer.parseInt(timeDifference));	
			newTime = df.format(cal.getTime());
		}
	String strFacilityId=checkForNull(request.getParameter("facility_id"));
	String called_from = checkForNull(request.getParameter("called_from"));
	String roomDesc = checkForNull(request.getParameter("roomDesc"));
	String over_booking_case_yn=checkForNull(request.getParameter("over_booking_case_yn"));
    over_booking_case_yn=over_booking_case_yn==null?"N":over_booking_case_yn;
    over_booking_case_yn=over_booking_case_yn.equals("null")?"N":over_booking_case_yn;
    over_booking_case_yn=over_booking_case_yn.equals("")?"N":over_booking_case_yn;
	String function_id=request.getParameter("function_id");
	String disable_flag=("BookingQry".equals(called_from))?"disabled":"";
	String func_role_id="",inform_date="",inform_time="",cancel_remarks="",checked_yn="",strUser="",strSysDate="",strHead="",strLabel="",strReasonDesc="",inform_date_time="",sql_cur_date="",dt_time="",sql="";	
	String[] dateArr= null;
	Connection conn=null;
	PreparedStatement pstmt=null;
	PreparedStatement pstmt1=null;
	ResultSet rs=null;		
	ResultSet rs1=null;		
	String strStatus = "";
	int range = 0;
	Pattern Regex = null;
if("BookingQry".equals(called_from) || "CancelTransfer".equals(called_from)){
	
            _bw.write(_wl_block8Bytes, _wl_block8);
}
		switch(choice){
		case 0: 
				strHead=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CancellationDetails.label","common_labels");	
				strLabel=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelledby.label","common_labels");		
				break;
		case 1: 
				strHead=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.TransferDetails.Label","ot_labels");
				strLabel=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TransferredBy.label","common_labels");
				break;
		case 6: 
				strHead=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.MarkforReschedule.Label","ot_labels");
				strLabel=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.RescheduledBy.Label","ot_labels");
				break;
		
	}
	try{
		 Regex = Pattern.compile("\\s",Pattern.CANON_EQ | Pattern.MULTILINE);
	}catch (PatternSyntaxException ex) {
		System.err.println("Err in Regular Expression from BookingCancel.jsp-->"+ex);
	}
	try{
				conn = ConnectionManager.getConnection(request);
				sql_cur_date=OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1");		
				pstmt=conn.prepareStatement(sql_cur_date);
				rs=pstmt.executeQuery();
				if(rs.next()){
					dt_time=checkForNull(rs.getString("DATE_TIME"));
				}
				rs.close();
				pstmt.close();



		// Modified by DhanasekarV agianist issue 26661  on 03/05/2011
		if("BookingQry".equals(called_from)==true)
				{
			
						sql = "SELECT NVL(B.ORDER_STATUS,'X') ORDERSTATUS FROM OT_BOOKING_HDR A,OR_ORDER B WHERE A.BOOKING_NUM = ?	AND B.ORDER_ID  = NVL(A.ORDER_ID,'X') AND A.OPERATING_FACILITY_ID =? " ;

						pstmt=conn.prepareStatement(sql);
						pstmt.setString(1,strBookingNum);
						pstmt.setString(2,strFacilityId);
						rs=pstmt.executeQuery();
						if(rs.next()){
						strStatus=checkForNull(rs.getString("ORDERSTATUS"));
						
						}
						rs.close();
						pstmt.close();
				 }
		//END 26661



			 
		if(strCancelFlag.equals("1")==true){
			sql="SELECT CANCELLED_BY CANCELLED_BY1,TO_CHAR(CANCELLATION_DATE,'DD/MM/YYYY HH24:MI')  CANCELLATION_DATE1,(SELECT REASON_DESC FROM OT_REASONS_LANG_VW RV WHERE LANGUAGE_ID = V.LANGUAGE_ID AND RV.REASON_CODE = R.REASON_CODE) REASON_DESC1,WARD_INFORMED_YN, TO_CHAR(WARD_INFORMED_TIME,'DD/MM/YYYY HH24:MI') INFORMED_TIME,CANCELLED_REMARKS REMRKS,TO_CHAR(V.ADDED_DATE,'DD/MM/YYYY HH24:MI') BOOKED_DATE FROM OT_BOOKINGS_VW V,OT_REASONS R WHERE NVL(R.STATUS,'E')='E' AND R.REASON_CODE IN (SELECT REASON_CODE FROM OT_REASON_ACTION_TYPE WHERE ACTION_TYPE = 'CA' AND NVL(ACTIVE_YN,'N') = 'Y') AND V.OPERATING_FACILITY_ID=? AND V.BOOKING_NUM=? AND V.CANCEL_REASON_CODE=R.REASON_CODE AND V.LANGUAGE_ID='"+locale+"' ";
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1,strFacilityId);
			pstmt.setString(2,strBookingNum);
			rs=pstmt.executeQuery();
			if(rs.next()){
				strUser=checkForNull(rs.getString("CANCELLED_BY1"));
				strSysDate=checkForNull(rs.getString("CANCELLATION_DATE1"));
				strReasonDesc=checkForNull(rs.getString("reason_desc1"));
				checked_yn = checkForNull(rs.getString("WARD_INFORMED_YN"));
				checked_yn=("Y".equals(checked_yn))?"checked":"";
				inform_date_time = checkForNull(rs.getString("INFORMED_TIME"));	
				cancel_remarks = checkForNull(rs.getString("REMRKS"));
				range = inform_date_time.trim().length();
				//Modified by DhanasekarV aginst 26661 on 21/11/2011	
				if (inform_date_time != null && inform_date_time.length()>0)
				{
				dateArr = Regex.split(inform_date_time,range);				
				inform_date =dateArr[0];
				inform_time = dateArr[1];
				}
				else 
				{
					inform_date ="";
					inform_time="";
				}

			}
			rs.close();
			pstmt.close();
		
	    }else{
				//Commented and added below query for 24448 on 10/18/2010 by ANithaJ
				//sql=OTRepository.getOTKeyValue("SQL_OT_BOOKINGCANCEL_SELECT1");		
				sql="select func_role_id from sm_appl_user_lang_vw where appl_user_id = ? and language_id = ?";		
				pstmt=conn.prepareStatement(sql);
				pstmt.setString(1,login_user);
				pstmt.setString(2,locale);
				rs=pstmt.executeQuery();
				if(rs.next()){
					strUser=checkForNull(rs.getString("func_role_id"));					
					//strSysDate=com.ehis.util.DateUtils.convertDate(rs.getString("SYSDATE1"),"DMYHM","en",locale);
				}
				rs.close();
				pstmt.close();
			  //Commented below query for 24448 on 10/18/2010 by ANithaJ
			  //String sql1="SELECT FUNC_ROLE_ID FROM SM_APPL_USER WHERE APPL_USER_ID = ?";
			  //strUser="";
			  //strUser=func_role_id; END	
		  	// Modified by DhanasekarV against issue IN026658 on 29/04/2011		
			strSysDate	= dt_time;		   
		   }
		// Modified by DhanasekarV against issue IN026658 on 29/04/2011		
		   strSysDate = com.ehis.util.DateUtils.convertDate(strSysDate,"DMYHM","en",locale);
		    //Added below query for 24448 by AnithaJ on 10/18/2010  START
  			  String sql1="SELECT SHORT_NAME  SHORT_NAME1 FROM AM_PRACTITIONER_LANG_VW where LANGUAGE_ID='"+locale+"' AND PRACTITIONER_ID=?";

			   pstmt1=conn.prepareStatement(sql1);
			   //pstmt1.setString(1,login_user);Anitha
			   pstmt1.setString(1,strUser);
			   rs1=pstmt1.executeQuery();
				if(rs1.next()){
					func_role_id=checkForNull(rs1.getString("SHORT_NAME1"));
				}
			//END
		}catch(Exception e){
			System.err.println("Exception in BookingProcedureDtl.jsp===="+e);
			e.printStackTrace();
		}finally{
			if(rs!=null)rs.close();
			if(rs1!=null)rs1.close();
			if(pstmt!=null)pstmt.close();
			if(pstmt1!=null)pstmt1.close();
			if(conn !=null) ConnectionManager.returnConnection(conn,request);
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(strHead));
            _bw.write(_wl_block10Bytes, _wl_block10);
if("".equals(called_from) && !("6").equals(flag)){
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(roomDesc));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strLabel));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(func_role_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(strUser));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(strSysDate));
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

	if(flag.equals("6")){
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block23Bytes, _wl_block23);
}else if(flag.equals("1")){
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block26Bytes, _wl_block26);
}else{
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strReasonDesc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block29Bytes, _wl_block29);
if(strCancelFlag.equals("1")==false){
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block31Bytes, _wl_block31);
}
            _bw.write(_wl_block32Bytes, _wl_block32);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block33Bytes, _wl_block33);

		//System.out.println("eOT strOrderId  "+strOrderId);
			if(strOrderId.length()==0){	
		// Modified by DhanasekarV agianist issue 26661  on 03/05/2011			
	
			if(strStatus.equals("OS")==true)
			out.println("<input type=checkbox name='cancelorder' id='cancelorder' disabled>");
			else
				out.println("<input type=checkbox name='cancelorder' id='cancelorder' checked disabled>");	
			}else{
				out.println("<input type=checkbox name='cancelorder' id='cancelorder'>");
			}
		}
            _bw.write(_wl_block34Bytes, _wl_block34);
 if("BookingQry".equals(called_from) || "CancelTransfer".equals(called_from)){ 
            _bw.write(_wl_block35Bytes, _wl_block35);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(checked_yn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(disable_flag));
            _bw.write(_wl_block38Bytes, _wl_block38);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block39Bytes, _wl_block39);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(inform_date));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(inform_time));
            _bw.write(_wl_block42Bytes, _wl_block42);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(cancel_remarks));
            _bw.write(_wl_block44Bytes, _wl_block44);
}
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(strOrderId));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(strBookingNum));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(endTime));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(start_time));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(newTime));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(strFacilityId));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block53Bytes, _wl_block53);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block54Bytes, _wl_block54);
            out.print( String.valueOf(dt_time));
            _bw.write(_wl_block55Bytes, _wl_block55);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block56Bytes, _wl_block56);
            out.print( String.valueOf(over_booking_case_yn));
            _bw.write(_wl_block57Bytes, _wl_block57);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.BookingWindow.Label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.TransferTo.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.datetime.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.CancelOrder.Label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ot_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InformedWard.Label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOT.InformedWard.Label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CancelRemarks.label", java.lang.String .class,"key"));
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
}
