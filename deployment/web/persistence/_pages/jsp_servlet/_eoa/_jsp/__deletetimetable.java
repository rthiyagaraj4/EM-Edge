package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __deletetimetable extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/DeleteTimeTable.jsp", 1709119232412L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n   ";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<HTML>\n\n\t<HEAD>\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t\n\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"> </script>\n\t<script language=\"javascript\" src=\"../../eCommon/js/common.js\"> \t\t</script>\n\t<script language=\"javascript\" src=\"../../eOA/js/TimeTable.js\">\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t</HEAD>\n\t<BODY onLoad=\"javascript:timetableType()\"  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\'>\n\t<FORM name=\'TimeTable\' id=\'TimeTable\' method=\'post\' action=\'../../servlet/eOA.TimeTableServlet\' target=\'messageFrame\'>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\n\t<TABLE WIDTH=\'100%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'>\n\t<tr><td class=\'BODYCOLORFILLED\'>&nbsp;</td></tr>\n\t<tr><td>&nbsp;</td></tr>\n\t<TR>\n\t<TD CLASS=\'BORDER\'>\n\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'  ALIGN=\'CENTER\'>\n\t<TR>\n\t<TD>\n\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'>\n\t<TR>\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Clinic</TD>\n\t<TD class=\"label\" align=\'left\'  width=\'15%\'>&nbsp;&nbsp;\n\t<INPUT name=\'b_clinic_name\' id=\'b_clinic_name\' VALUE=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' readonly>\n\t<INPUT TYPE=\'hidden\' name=\'b_clinic\' id=\'b_clinic\' VALUE=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n\t</TD>\n\t\t\t\t\n\t<TD class=\"label\" align=\'right\' width=\'19%\'>Practitioner</TD>\n\t<TD class=\"label\" align=\'left\'  width=\'16%\'>&nbsp;&nbsp;\n\n\t<INPUT name=\'b_practitioner_name\' id=\'b_practitioner_name\' VALUE=\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\' readonly>\n\t<INPUT TYPE=\'hidden\' name=\'b_practitioner\' id=\'b_practitioner\' VALUE=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t</TD>\n\t</TR>\n\t<TR>\n\t\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Day</TD>\n\t<TD class=\"label\" align=\'left\'  width=\'15%\'>&nbsp;&nbsp;\n\t<INPUT name=\'b_week_day\' id=\'b_week_day\' VALUE=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\' readonly>\n\t</TD>\n\t\t\t\t\n\t<TD class=\"label\" align=\'right\' width=\'19%\'>Roster Required ?</TD>\n\t<TD class=\"label\" align=\'left\'  width=\'16%\'>&nbsp;\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t<INPUT TYPE=CHECKBOX name=\'b_roster_reqd\' id=\'b_roster_reqd\' ";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =">\n\t</TD>\n\t</TR>\n\n\t<TR>\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Time Table Type</TD>\n\t<TD class=\"label\" align=\'left\'  width=\'15%\' COLSPAN=\'1\'>&nbsp;&nbsp;\n\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\n\t<INPUT TYPE=\'HIDDEN\' name=\'b_time_table_type_hd\' id=\'b_time_table_type_hd\' VALUE=\'";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\'>\n\t<INPUT TYPE=\'HIDDEN\' name=\'b_day\' id=\'b_day\' VALUE=\'";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\'>\n\n\t</TD>\n\t<td><input type=\'hidden\' name=\'l_ident_at_checkin\' id=\'l_ident_at_checkin\'></td>\n\t<td><input type=\'hidden\' name=\'l_fi_visit_type_appl_yn\' id=\'l_fi_visit_type_appl_yn\'></td>\n\t</TR>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t</TABLE>\n\t</TD></TR>\n\t<tr><td>&nbsp;</td></tr>\n\t<tr><td class=\'BODYCOLORFILLED\'>&nbsp;</td></tr>\n\n\t<TR>\n\t<TD class=\'BORDER\'>\n\t<TABLE WIDTH=\'100%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\' ALIGN=\'CENTER\'>\n\t<TH align=\'left\'>Clinic Charactersitics</TH>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t<tr><td>&nbsp;</td></tr>\n\n\t<TR>\n\t<TD class=\'BORDER\'>\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\' ALIGN=\'CENTER\'>\n\t<TR>\n\t<TD CLASS=\'BORDER\'>\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'>\n\t<TR>\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Start Time</TD>\n\t<TD class=\"label\" align=\'left\' width=\'15%\' >&nbsp;&nbsp;\n\t<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'b_start_time\' id=\'b_start_time\' VALUE=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\'\"> \n\t&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img></TD>\n\t\t\t\t\t\n\t<TD class=\"label\" align=\'right\' width=\'19%\'>End Time</TD>\n\t<TD class=\"label\" align=\'left\' width=\'16%\'>&nbsp;&nbsp;\n\t<INPUT TYPE=TEXT SIZE=5 MAXLENGTH=5 name=\'b_end_time\' id=\'b_end_time\'   VALUE=\'";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\' \"> \n\t&nbsp;<img src=\"../../eCommon/images/mandatory.gif\" align=\'center\'></img></TD>\n\t<td><input type=\'hidden\' name=\'l_p_fi_visit_type_appl_yn\' id=\'l_p_fi_visit_type_appl_yn\'></td>\n\t</TR>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\n\t<TR>\n\t<TD class=\'BORDER\'>\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\' ALIGN=\'CENTER\'>\n\t<TR>\n\t<TD CLASS=\'BORDER\'>\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'>\n\t<TR>\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Time per Patient</TD>\n\t<TD class=\"label\" align=\'left\' width=\'15%\' >&nbsp;&nbsp;\n\t<INPUT name=\'b_time_per_patient\' id=\'b_time_per_patient\' TYPE=TEXT SIZE=5 MAXLENGTH=5 VALUE=\'";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\' > </TD>\n\t\n\t<TD class=\"label\" align=\'right\' width=\'19%\'>Maximum Patients per Day</TD>\n\t<TD class=\"label\" align=\'left\' width=\'16%\'>&nbsp;&nbsp;\n\t<INPUT name=\'b_max_patients_per_day\' id=\'b_max_patients_per_day\' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE=\'";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\' > </TD>\n\t<td><input type=\'hidden\' name=\'l_max_pat_per_day\' id=\'l_max_pat_per_day\'></td>\n\t</TR>\n\n\t<TR>\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Time per Slab</TD>\n\t<TD class=\"label\" align=\'left\' width=\'15%\' >&nbsp;&nbsp;\n\t<INPUT name=\'b_time_per_slab\' id=\'b_time_per_slab\' TYPE=TEXT SIZE=5 MAXLENGTH=5 VALUE=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' > </TD>\n\t\n\t<TD class=\"label\" align=\'right\' width=\'19%\'>Maximum Patients per Slab</TD>\n\t<TD class=\"label\" align=\'left\' width=\'16%\'>&nbsp;&nbsp;\n\t<INPUT name=\'b_max_patients_per_slab\' id=\'b_max_patients_per_slab\' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' > </TD>\n\t</TR>\n\n\t<TR>\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Maximum First Visit</TD>\n\t<TD class=\"label\" align=\'left\' width=\'15%\'>&nbsp;&nbsp;\n\t<INPUT name=\'b_max_first_visit\' id=\'b_max_first_visit\' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' > </TD>\n\t\n\t<TD class=\"label\" align=\'right\' width=\'19%\'>Maximum Over Bookings</TD>\n\t<TD class=\"label\" align=\'left\' width=\'16%\'>&nbsp;&nbsp;\n\t<INPUT name=\'b_max_over_bookings\' id=\'b_max_over_bookings\' TYPE=TEXT SIZE=5 MAXLENGTH=3 VALUE=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' > </TD>\n\t</TR>\n\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t<tr><td colspan=\'3\'>&nbsp;</td></tr>\n\n\t<TR>\n\t<TD class=\'BORDER\'>\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\' ALIGN=\'CENTER\'>\n\t<TR>\n\t<TD CLASS=\'BORDER\'>\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\'>\n\t<TR>\n\t<TD class=\"label\" align=\'right\' width=\'15%\'>Remarks</TD>\n\t<TD class=\"label\" align=\'left\' width=\'49%\' >&nbsp;&nbsp;\n\t<INPUT name=\'b_remarks\' id=\'b_remarks\' TYPE=TEXT SIZE=67 VALUE=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' MAXLENGTH=60></TD>\n\t</TR>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t<tr><td>&nbsp;</td>\n\t</tr>\n\t<tr><td class=\'BODYCOLORFILLED\'>&nbsp;</td></tr>\n\t\n\t<TR>\n\t<TD class=\'BORDER\'>\n\t<TABLE WIDTH=\'90%\' CELLPADDING=\'0\' CELLSPACING=\'0\' BORDER=\'0\' ALIGN=\'CENTER\'>\n\t<TR>\n\t<TD align=\'left\' width=\'15%\'>\n\t<INPUT TYPE=\'HIDDEN\' name=\'fmode\' id=\'fmode\' VALUE=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n\t<INPUT TYPE=\'HIDDEN\' name=\'ftotstr\' id=\'ftotstr\' >\n\t</TD>\n\t</TR>\n\t</TABLE>\n\t</TD>\n\t</TR>\n\t</TABLE>\n\t</FORM>\n\t</BODY>\n\t</HTML>\n\t\n\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	Connection con = null;
		Statement stmt   	= null ;
		ResultSet rs   	= null;
		String fac_id    	= (String) session.getValue( "facility_id" ) ;
		String f_mode		= "delete" ;
		String p_clinic_code	= request.getParameter("clinic_code") ;
		String p_pract_id	= request.getParameter("practid") ;
		String p_day_no		= request.getParameter("dayno") ;
		String p_time_table_type= request.getParameter("timetabletype") ;
		String p_roster_checked = "" ;
		StringBuffer sql=new StringBuffer("") ;
try
{
 con = ConnectionManager.getConnection(request);
		 stmt   	= con.createStatement() ;
	
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

	sql.append( "select clinic_code,clinic_name,day_no,day_of_week,practitioner_id,practitioner_name,") ; 
	sql.append( "time_table_type,to_char(start_time,'hh24:mi')start_time,to_char(end_time,'hh24:mi')end_time,");
	sql.append( "nvl(to_char(time_per_patient,'hh24:mi'),'00:00')time_per_patient,nvl(max_patients_per_day,0)max_patients_per_day,nvl(to_char(time_per_slab,'hh24:mi'),'00:00')time_per_slab,") ;
	sql.append( "nvl(max_patients_per_slab,0)max_patients_per_slab,nvl(max_first_visits,0)max_first_visits,nvl(max_over_booking,0)max_over_booking,NVL(phys_roster_reqd_yn,'N')phys_roster_reqd_yn,nvl(remarks,'&nbsp;')remarks  ") ;
	sql.append("from oa_clinic_time_table_vw where facility_id = '"+fac_id+"' " );
	sql.append("and clinic_code = '"+p_clinic_code+"' and practitioner_id = '"+p_pract_id+"' ");
	sql.append("and day_no = '"+p_day_no+"' and time_table_type = '"+p_time_table_type+"' ") ;

	rs = stmt.executeQuery(sql.toString());
	sql.setLength(0);
	rs.next() ;
	

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(rs.getString("clinic_name")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(rs.getString("clinic_code")));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(rs.getString("practitioner_name")));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(rs.getString("practitioner_id")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(rs.getString("day_of_week")));
            _bw.write(_wl_block14Bytes, _wl_block14);

	String chk = "" ;
	p_roster_checked = rs.getString("phys_roster_reqd_yn") ;

	if (p_roster_checked.equals("Y"))
	{
		chk = "checked" ;
	}
	else
	{
		chk = "" ;
	}
	
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(chk));
            _bw.write(_wl_block16Bytes, _wl_block16);

	out.println("<INPUT name='time_table_type' id='time_table_type' VALUE='");
	
	if (rs.getString("time_table_type").equals("1"))
	{
		out.println("Slot");out.println("' readonly>");
		out.println("<INPUT TYPE='hidden' NAME=b_time_table_type VALUE='1'>") ;
	}
	else if (rs.getString("time_table_type").equals("2"))
	{
		out.println("Slab");out.println("' readonly>");
		out.println("<INPUT TYPE='hidden' NAME=b_time_table_type VALUE='2'>") ;
	}
	else if (rs.getString("time_table_type").equals("3"))
	{
		out.println("Free Time");out.println("' readonly>");
		out.println("<INPUT TYPE='hidden' NAME=b_time_table_type VALUE='3'>") ;
	}
	
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("time_table_type")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(rs.getString("day_no")));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("start_time")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rs.getString("end_time")));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(rs.getString("time_per_patient")));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(rs.getString("max_patients_per_day")));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(rs.getString("time_per_slab")));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(rs.getString("max_patients_per_slab")));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(rs.getString("max_first_visits")));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(rs.getString("max_over_booking")));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(rs.getString("remarks")));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(f_mode));
            _bw.write(_wl_block29Bytes, _wl_block29);

	if (rs != null) rs.close();
	if (stmt != null) stmt.close();
}catch(Exception e) { 
	//out.println(e.toString());
e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}
finally
{

	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
