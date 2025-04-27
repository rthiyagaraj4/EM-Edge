package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.StringTokenizer;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Types;
import webbeans.eCommon.ConnectionManager;
import eCommon.Common.CommonBean;
import java.sql.CallableStatement;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __schedulehdr extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/ScheduleHdr.jsp", 1726763226000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n ";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'/>\n\t<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"javascript\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eCommon/js/DateUtils.js\"></script>\n\t<script language=\"Javascript\" src=\"../../eOT/js/Schedule.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body onload=\"disablereset(); onloadAssignDay();\">\n<form name=\"ScheduleHdr\" id=\"ScheduleHdr\" method=\"POST\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n<table class=\'white\' border=\"0\" cellpadding=3  cellspacing=\"0\" width=\"100%\" align=\"center\">\n\t<tr> \n\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t<b class=\'label\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =":</b>\n\t\t</td>\n\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t</td>\n\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t<b>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t</td> \n\t</tr>\n\t<tr>\n\t\t<td class=\'label\' width=\'25%\'>\n\t\t\t<b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td  class=\'label\' width=\'25%\' nowrap> \n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</td>\n\t\t<td  class=\'label\' width=\'25%\' nowrap> \n\t\t\t<input type=\'text\' name=\'sch_date\' id=\'sch_date\' id=\'sch_date\' size=\'8\'  value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onblur=\'isValidDateLocal(this)\'>\n\t\t\t<img src=\'../../eCommon/images/CommonCalendar.gif\' onClick=\"parent.showCalendar_loc(this.previousElementSibling,\'dd/mm/y\',this.parentElement.nextElementSibling.querySelector(\'#day\'));\"></img>\n\t\t\t<img src=\'../../eCommon/images/mandatory.gif\'></img>\n\t\t</td>\n\t\t<td  class=\'label\' width=\'25%\' nowrap> \n\t\t\t<input type=\'text\' name=\"day\" id=\"day\" readonly  value=\"\" tabindex=\'-1\' style=\"border=1\"/>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'25%\'>\n\t\t\t<input type=\'button\' class=\'button\' value=\'Go\' onClick=\'loadSchedulePage();\'>\n\t\t<td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<td id=\'overBooking\' width=\'25%\'>\n\t\t\t\t<input type=\'button\' class=\'button\' value=\'Over Booking\' onClick=\'showBookingDialogOverBook(\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\", \"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\", \"\", \"\", \"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\");\'>\n\t\t\t</td>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t</tr>\n</table>\n\n<input type=\'hidden\' name=\'locale\' id=\'locale\' value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<input type=\'hidden\' name=\'facility_id\' id=\'facility_id\' value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<input type=\'hidden\' name=\'bkng_no\' id=\'bkng_no\' value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<input type=\'hidden\' name=\'startTime\' id=\'startTime\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\'> <!-- 44528 - Chaitanya -->\n<input type=\'hidden\' name=\'endTime\' id=\'endTime\' value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\'>\n<input type=\'hidden\' name=\'bkng_date\' id=\'bkng_date\' value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<input type=\'hidden\' name=\'HsurgeonDesc\' id=\'HsurgeonDesc\' value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<input type=\'hidden\' name=\'HroomDesc\' id=\'HroomDesc\' value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\'hidden\' name=\'HroomCode\' id=\'HroomCode\' value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\'hidden\' name=\'HspecialityDesc\' id=\'HspecialityDesc\' value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\'hidden\' name=\'HsurgeonCode\' id=\'HsurgeonCode\' value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\'hidden\' name=\'Hspeciality_code\' id=\'Hspeciality_code\' value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\'hidden\' name=\'Horderid\' id=\'Horderid\' value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input type=\'hidden\' name=\'selOrderIds\' id=\'selOrderIds\' id=\'selOrderIds\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'> ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\n<input type=\'hidden\' name=\'Hprocedure\' id=\'Hprocedure\' value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\'hidden\' name=\'Hcalled_from\' id=\'Hcalled_from\' value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\'hidden\' name=\'Hfunction_id\' id=\'Hfunction_id\' value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\'hidden\' name=\'Hfull_vacant\' id=\'Hfull_vacant\' value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"chkSize\" id=\"chkSize\" id=\"chkSize\" value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n<input type=\"hidden\" name=\"fullVacantVal\" id=\"fullVacantVal\" id=\"fullVacantVal\" value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n<input type=\"hidden\" name=\"frameNmbr\" id=\"frameNmbr\" id=\"frameNmbr\" value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n<input type=\"hidden\" name=\"selSurgeonCode\" id=\"selSurgeonCode\" id=\"selSurgeonCode\" value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\"> <!-- 051825 -->\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
   String facility_id = (String) session.getValue("facility_id");

            _bw.write(_wl_block2Bytes, _wl_block2);
	request.setCharacterEncoding("UTF-8");
    //Added Against MMS Vulnerability Issue - Starts
    request= new XSSRequestWrapper(request);
    response.addHeader("X-XSS-Protection", "1; mode=block");
    response.addHeader("X-Content-Type-Options", "nosniff");
	//Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block6Bytes, _wl_block6);

String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

String strSurgeonName=CommonBean.checkForNull(request.getParameter("surgeonName"));
String strRoomDesc=CommonBean.checkForNull(request.getParameter("roomDesc"));
String roomCode=CommonBean.checkForNull(request.getParameter("roomCode"));
String strSpecialityDesc=CommonBean.checkForNull(request.getParameter("speciality_desc"));
//Commented convertDate for IN024449 by AnithaJ on 10/15/2010
String strBookingDate=CommonBean.checkForNull(com.ehis.util.DateUtils.convertDate(request.getParameter("booking_date"),"DMY","en",locale));
String strBookingDateProc=CommonBean.checkForNull(request.getParameter("booking_date"));
String strBookingNo=CommonBean.checkForNull(request.getParameter("booking_no"));
String startTime=CommonBean.checkForNull(request.getParameter("startTime"));// 44528 - Chaitanya
String endTime=CommonBean.checkForNull(request.getParameter("endTime"));
String surgeonCode=CommonBean.checkForNull(request.getParameter("surgeonCode"));
String selSurgeonCode = CommonBean.checkForNull(request.getParameter("selSurgeonCode")); // 051825
String speciality_code=CommonBean.checkForNull(request.getParameter("speciality_code"));
String orderid=CommonBean.checkForNull(request.getParameter("orderid"));
String selOrderIds=CommonBean.checkForNull(request.getParameter("selOrderIds")); // ChAiTu - 186
System.out.println("====selOrderIds==header=="+selOrderIds);
String procedure=CommonBean.checkForNull(request.getParameter("procedure"));
String called_from=CommonBean.checkForNull(request.getParameter("called_from"));
String function_id=CommonBean.checkForNull(request.getParameter("function_id"));
String full_vacant=CommonBean.checkForNull(request.getParameter("full_vacant"));
String chkSize = CommonBean.checkForNull(request.getParameter("chkSize"));
String strStatus="";
String strPatientID="";
String strResultString = "";
StringTokenizer strToken = null;
String strValue = "";
String fullVacantVal = CommonBean.checkForNull(request.getParameter("fullVacantVal"));
String frameNmbr = CommonBean.checkForNull(request.getParameter("frameNmbr"));
String overBookingWindowYN=CommonBean.checkForNull(request.getParameter("overBookingWindowYN"));

CallableStatement callableStatement = null;
Connection conn = null;
/*Below line Added for Senthil*/
PreparedStatement pstmt = null;
ResultSet overbooking_rs=null;

String SqlQuery="", RoomQuery="";
int over_booking_count=0;
int over_booking_count_room=0;
boolean check_count=false;
try
{
	conn = ConnectionManager.getConnection(request);
	
	/*Added by Senthil*/
	SqlQuery = " select count(*) over_book_count from OT_BOOKING_HDR a, ot_booking_dtls b, mp_patient_mast c, OT_NATURE_OF_SURGERY d, ot_oper_mast_lang_vw e, Am_practitioner_lang_vw f where b.booking_num = a.booking_num and c.patient_id = a.patient_id and e.oper_code =  b.oper_code and e.language_id = ? and a.oper_room_code = ? and d.nature_code = a.nature_code and f.language_id(+) = ? and a.TEAM_DOCTOR_CODE = f.practitioner_id(+) and to_char(a.booking_date,'dd/mm/yyyy') = ? and a.OVER_BOOKED_YN=? and BOOKING_STATUS <> '9'";
	 pstmt = conn.prepareStatement(SqlQuery);
	 pstmt.setString(1,locale);
     pstmt.setString(2,roomCode);
     pstmt.setString(3,locale);    
     pstmt.setString(4,strBookingDate);
	 pstmt.setString(5,"Y"); 
     overbooking_rs = pstmt.executeQuery();	
	if(overbooking_rs!=null && overbooking_rs.next())
	{
	  over_booking_count=overbooking_rs.getInt("over_book_count");
	}
	  if(pstmt!=null)pstmt.close(); if(overbooking_rs!=null)overbooking_rs.close();
	  RoomQuery=" select NVL(OVER_BOOK_COUNT,0) over_book_roomcount from OT_OPER_ROOM where oper_room_code = ? and OPERATING_FACILITY_ID = ? ";
	  pstmt = conn.prepareStatement(RoomQuery);	
      pstmt.setString(1,roomCode);
	  pstmt.setString(2,facility_id);
	  overbooking_rs = pstmt.executeQuery();	
	if(overbooking_rs!=null && overbooking_rs.next())
	{
	  over_booking_count_room = overbooking_rs.getInt("over_book_roomcount");
	}
		
	if(pstmt!=null)pstmt.close(); if(overbooking_rs!=null)overbooking_rs.close();
	if(over_booking_count < over_booking_count_room) 
		check_count=true;
	//if(over_booking_count>over_booking_count_room) check_count=false;
	
	
	
	/*End Senthil*/	
	
	callableStatement=conn.prepareCall("{ call OT_SURGEON_CALENDAR(?,?,?,?,?)}");
	System.out.println("=====facility_id====schedulehdr=========="+facility_id);
	System.out.println("======surgeonCode===schedulehdr=========="+surgeonCode);
	System.out.println("=====roomCode====schedulehdr=========="+roomCode);
	System.out.println("=====strBookingDate====schedulehdr=========="+strBookingDate);
	callableStatement.setString(1, facility_id);
	callableStatement.setString(2, surgeonCode);
	callableStatement.setString(3, roomCode);
	callableStatement.setString(4, strBookingDateProc);		
	callableStatement.registerOutParameter(5, Types.VARCHAR);
	callableStatement.execute();
	strResultString = callableStatement.getString(5);
	strToken = new StringTokenizer(strResultString, "#");
	System.out.println("===strToken==="+strToken);
	if(strToken.hasMoreTokens())
	{
		strValue = strToken.nextToken();
		System.out.println("===strValue==="+strValue);
	}
}
catch(Exception ee)
{ 
	ee.printStackTrace();
}
finally
{
	if(conn!=null)
		conn.close();
}


            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strRoomDesc));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block15Bytes, _wl_block15);

/* 
		System.out.println("========strStatus=========schedulehdr========="+strStatus);
		System.out.println("========strPatientID=========schedulehdr========="+strPatientID);
		if(!strStatus.equals("30") && strPatientID.length() != 0)
		{
*/
		if(String.valueOf(strValue.charAt(0)).equals("O") )// && check_count)
		{

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(surgeonCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strSurgeonName.replaceAll("'", "")));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(roomCode));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strRoomDesc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(full_vacant));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(frameNmbr));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(overBookingWindowYN));
            _bw.write(_wl_block19Bytes, _wl_block19);

		}

            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(facility_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(strBookingNo));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(startTime));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(endTime));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(strBookingDate));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(strSurgeonName));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(strRoomDesc));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(roomCode));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(strSpecialityDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(surgeonCode));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(orderid));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(selOrderIds));
            _bw.write(_wl_block34Bytes, _wl_block34);
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(procedure));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(function_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(full_vacant));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(chkSize));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(fullVacantVal));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(frameNmbr));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(selSurgeonCode));
            _bw.write(_wl_block43Bytes, _wl_block43);
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Theatre.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apptdate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ScheduleDate.label", java.lang.String .class,"key"));
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
}
