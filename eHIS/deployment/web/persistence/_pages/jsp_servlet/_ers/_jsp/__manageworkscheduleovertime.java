package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __manageworkscheduleovertime extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleOvertime.jsp", 1709121638199L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"JavaScript\" src=\"../../eRS/js/ManageWorkScheduleOvertime.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body onload=\'FocusFirstElement()\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\n<form target=\'blankFrame\' name=\"ManageWorkSchedule_Overtime\" id=\"ManageWorkSchedule_Overtime\" method=\'post\' action=\'../../servlet/eRS.ManageWorkScheduleOvertimeServlet\'>\n\t\n<table cellpadding=0 cellspacing=0 border=0 width=\"103%\" align=\'right\'>\n<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t<td></td>\n</tr>\n<tr>\n\t<td class=\'querydata\' align=\'right\' width=\'30%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'label\' width=\'30%\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td></td>\n</tr>\n\t<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t<td></td>\n</tr>\n<tr>\n\t<td class=\'label\' align=\'right\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td>&nbsp;&nbsp;&nbsp;<select name=\"shift\" id=\"shift\" onChange=\'ChangeType(this.form,this);display(start_time)\'>\n\t\t\t<option value=\"\">-----";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="-----</option>\n\t\t\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<option value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="</option>\t\t\t\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</SELECT>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\">\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t<input type=\"hidden\" name=\"shift_mnemonic\" id=\"shift_mnemonic\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t<input type=\"hidden\" name=\"start_time1\" id=\"start_time1\" value=\"\">\n\t\t<input type=\"hidden\" name=\"end_time1\" id=\"end_time1\" value=\"\" >\n\t\t\t\t\t\n\t</td>\n\t<td id=\"start_time\" class=\"data\"></td>\n\t\t\n</tr>\n<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td></td>\n\n</tr>\n<tr>\n\t<td class=\'label\' width=\'25%\' align=\'right\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t<td class=\"label\">&nbsp;&nbsp;&nbsp;<input type=\"text\" size=\"1\" maxlength=\"2\" name=\"over_time_durn1\" id=\"over_time_durn1\" onblur=\'CheckForHours(this)\' onkeypress=\"return allowPositiveNumber()\">:<input type=\"text\" size=\"1\" maxlength=\"2\" name=\"over_time_durn2\" id=\"over_time_durn2\" onblur=\'CheckForMinutes(this,over_time_durn1);\' onkeypress=\"return allowPositiveNumber()\">&nbsp;hh:mi&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n\t\t<td></td>\n</tr>\n\t\t<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t\t\t<td></td>\n</tr>\n<tr>\n\t<td class=\'label\' width=\'25%\' align=\'right\'>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</td>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t<td>&nbsp;&nbsp;&nbsp;<SELECT name=\"reason\" id=\"reason\">\n\t\t\t<option value=\"\">----------";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="----------</option>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t</SELECT>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\">\n\t</td>\n\t<td></td>\n</tr>\n<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td></td>\n\n</tr>\n<tr>\n\t<td class=\'label\' width=\'25%\' align=\'right\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t<td>&nbsp;&nbsp;&nbsp;<TEXTAREA NAME=\"remarks\" COLS=\"25\" onKeyPress=\"checkMaxLimit(this,2000);\"></TEXTAREA></td>\n\t<td></td>\n</tr>\n<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td></td>\n</tr>\n<tr>\n\t<td>&nbsp;</td>\n\t<td></td>\n\t<td align=\'right\'><INPUT TYPE=\"button\" class=\'button\' value=\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\' onclick=\"apply()\"><INPUT TYPE=\"button\" class=\'button\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onclick=\"windclose()\"></td>\n\n</tr>\n<tr>\n\t<td colspan=\'2\'>&nbsp;</td>\n\t\t<td></td>\n\n</tr>\n</table>\n<input type=\"hidden\" name=\"p_shift_code\" id=\"p_shift_code\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<input type=\"hidden\" name=\"p_requirement_id\" id=\"p_requirement_id\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<input type=\"hidden\" name=\"p_workplace_code\" id=\"p_workplace_code\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<input type=\"hidden\" name=\"p_schedule_date\" id=\"p_schedule_date\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n<input type=\"hidden\" name=\"p_role_type\" id=\"p_role_type\" value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n<input type=\"hidden\" name=\"p_staff_id\" id=\"p_staff_id\" value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n<input TYPE=\"hidden\" name=\"p_staff_type\" id=\"p_staff_type\" value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n<input type=\"hidden\" name=\"p_position_code\" id=\"p_position_code\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<input type=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<input type=\"hidden\" name=\"date_type\" id=\"date_type\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<input type=\"hidden\" name=\"shift_start_time\" id=\"shift_start_time\" value=\"\">\n<input type=\"hidden\" name=\"actual_end_time\" id=\"actual_end_time\" value=\"\">\n<input type=\"hidden\" name=\"curr_shift_overtime_yn\" id=\"curr_shift_overtime_yn\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<input type=\"hidden\" name=\"durn_for_overtime_from_sos\" id=\"durn_for_overtime_from_sos\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=\"hidden\" name=\"shift_end_date_time\" id=\"shift_end_date_time\" value=\"\">\n<input type=\"hidden\" name=\"shift_start_date_time\" id=\"shift_start_date_time\" value=\"\">\n<input type=\"hidden\" name=\"actual_end_date_time\" id=\"actual_end_date_time\" value=\"\">\n<input type=\"hidden\" name=\"mode\" id=\"mode\" value=\"insert\">\n</form>\n</body>\n\t\t\n";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\n</html>\t\n\n";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

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
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	Connection conn = null;

	PreparedStatement pstmt_schedule_date = null;
	PreparedStatement pstmt_date_type = null;
	PreparedStatement pstmt_curr_overtime = null;
	PreparedStatement pstmt_reqid_v = null;
	PreparedStatement pstmt_reqid_c = null;
	PreparedStatement pstmt_shift_code = null;
	PreparedStatement pstmt_shift = null;
	PreparedStatement pstmt_reason = null;
	PreparedStatement pstmt_start_end_time = null;

	ResultSet rs_schedule_date = null;
	ResultSet rs_date_type = null;
	ResultSet rs_curr_overtime = null;
	ResultSet rs_reqid_v = null;
	ResultSet rs_reqid_c = null;
	ResultSet rs_shift_code = null;
	ResultSet rs_shift = null;
	ResultSet rs_reason = null;
	ResultSet rs_start_end_time = null;

	String p_facility_id  = request.getParameter("p_facility_id")==null?"":request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code")==null?"":request.getParameter("p_workplace_code");
	String p_date  = request.getParameter("p_date")==null?"":request.getParameter("p_date");
	int p_cell_no  = Integer.parseInt(request.getParameter("p_cell_no")==null?"":request.getParameter("p_cell_no"));
	String p_role_type  = request.getParameter("p_role_type")==null?"":request.getParameter("p_role_type");
	String p_staff_type  = request.getParameter("p_staff_type")==null?"":request.getParameter("p_staff_type");
	String p_staff_id  = request.getParameter("p_staff_id")==null?"":request.getParameter("p_staff_id");
	String p_position_code  = request.getParameter("p_position_code")==null?"":request.getParameter("p_position_code");
	String p_shift_code  = request.getParameter("p_shift_code")==null?"":request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic")==null?"":request.getParameter("p_shift_mnemonic");
	String p_requirement_id = "";
	String date_type = "";
	String curr_shift_overtime_yn = "";
	String durn_for_overtime_from_sos = "";
	String p_schedule_date = "";
	Vector shift_list = new	Vector();

	try{
		conn = ConnectionManager.getConnection(request);

		String sql_schedule_date="select to_char(to_date(?,'dd/mm/yyyy') + ?,'dd/mm/yyyy') p_schedule_date from dual";
		pstmt_schedule_date=conn.prepareStatement(sql_schedule_date);
		pstmt_schedule_date.setString(1,p_date);
		pstmt_schedule_date.setInt(2,p_cell_no);
		rs_schedule_date = pstmt_schedule_date.executeQuery();

		while(rs_schedule_date!=null && rs_schedule_date.next()){
			p_schedule_date = rs_schedule_date.getString("p_schedule_date");
		}
		if(pstmt_schedule_date != null) 
			pstmt_schedule_date.close();
		if(rs_schedule_date != null)
			rs_schedule_date.close();
		String sql_date_type = "SELECT DECODE( SIGN(TRUNC(SYSDATE) - TO_DATE('2/8/2005','dd/mm/yyyy')),0,'C','F')date_type FROM dual";

		pstmt_date_type=conn.prepareStatement(sql_date_type);
		rs_date_type = pstmt_date_type.executeQuery();

		while(rs_date_type!=null && rs_date_type.next()){
			date_type = rs_date_type.getString("date_type");
		}
		if(pstmt_date_type != null)
			pstmt_date_type.close();
		if(rs_date_type != null)
			rs_date_type.close();

		String sql_curr_overtime="Select max_continuous_work_duration, curr_shift_overtime_yn, durn_for_overtime_from_sos from rs_parameter Where facility_id = ?";

		pstmt_curr_overtime = conn.prepareStatement(sql_curr_overtime);
		pstmt_curr_overtime.setString(1,p_facility_id);
		rs_curr_overtime = pstmt_curr_overtime.executeQuery();
		while(rs_curr_overtime.next() && rs_curr_overtime!=null){
			curr_shift_overtime_yn=rs_curr_overtime.getString("curr_shift_overtime_yn")==null ? "":rs_curr_overtime.getString("curr_shift_overtime_yn");
			durn_for_overtime_from_sos=rs_curr_overtime.getString("durn_for_overtime_from_sos") == null ? "":rs_curr_overtime.getString("durn_for_overtime_from_sos");
		}
		if(pstmt_curr_overtime != null)
			pstmt_curr_overtime.close();
		if(rs_curr_overtime != null)
			rs_curr_overtime.close();

		String sql_requiredid_v="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and  requirement_type = 'V' and to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to";

		pstmt_reqid_v=conn.prepareStatement(sql_requiredid_v);
		pstmt_reqid_v.setString(1,p_facility_id);
		pstmt_reqid_v.setString(2,p_workplace_code);
		pstmt_reqid_v.setString(3,p_schedule_date);
		rs_reqid_v=pstmt_reqid_v.executeQuery();
		while(rs_reqid_v.next() && rs_reqid_v!=null){
			p_requirement_id=rs_reqid_v.getString("requirement_id");
		}
		if(pstmt_reqid_v != null) 
			pstmt_reqid_v.close();
		if(rs_reqid_v != null)
			rs_reqid_v.close();
		if(p_requirement_id.equals("")){
			String sql_requiredid_c="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code =? and requirement_type = 'C' and requirement_date_fm is null and requirement_date_to is null";
			pstmt_reqid_c=conn.prepareStatement(sql_requiredid_c);
			pstmt_reqid_c.setString(1,p_facility_id);
			pstmt_reqid_c.setString(2,p_workplace_code);
			rs_reqid_c=pstmt_reqid_c.executeQuery();
			while(rs_reqid_c.next() && rs_reqid_c!=null){
				p_requirement_id=rs_reqid_c.getString("requirement_id");
			}
			if(pstmt_reqid_c != null)
				pstmt_reqid_c.close();
			if(rs_reqid_c != null)
				rs_reqid_c.close();
		}
			
		//String sql_shift_code = "Select distinct a.shift_code,a.long_desc shift_desc,b.shift_mnemonic from am_shift a,rs_shift_for_workplace b where b.facility_id=? and a.shift_code In(";
		String sql_shift_code = "Select distinct a.shift_code,a.long_desc shift_desc,b.shift_mnemonic from am_shift_lang_vw a,rs_shift_for_workplace b where b.facility_id=? and a.language_id = ? and a.shift_code In(";
		StringTokenizer ShiftCode = new StringTokenizer(p_shift_code,"|");
		boolean flag = true;
		while(ShiftCode.hasMoreTokens()){
			if(!flag)
				sql_shift_code =sql_shift_code + ",";
			if(flag){
				sql_shift_code = sql_shift_code +"'" + (ShiftCode.nextToken().trim()) + "'";
				flag = false;
			}
			else{
				sql_shift_code =sql_shift_code + "'" + (ShiftCode.nextToken().trim()) + "'";
			}
		}
		StringTokenizer shift_mnemonic = new StringTokenizer(p_shift_mnemonic,"|");
		sql_shift_code =sql_shift_code	+	") and b.shift_mnemonic in(";
		flag	=	true;
		while(shift_mnemonic.hasMoreTokens()){				
			if(!flag)
			sql_shift_code	=sql_shift_code 	+ ",";
			if(flag){
				sql_shift_code	=sql_shift_code + "'"+(shift_mnemonic.nextToken().trim())+"'";
				flag	=	false;
			} 
			else{
				sql_shift_code	=sql_shift_code + "'"+(shift_mnemonic.nextToken().trim())+"'";
			}
		}
		sql_shift_code	=sql_shift_code	+ ") and a.shift_code=b.shift_code and a.shift_indicator = 'P' ";
		
		pstmt_shift_code = conn.prepareStatement(sql_shift_code);
		pstmt_shift_code.setString(1,p_facility_id);
		pstmt_shift_code.setString(2,locale);
		rs_shift_code = pstmt_shift_code.executeQuery();
		while(rs_shift_code.next() && rs_shift_code!=null)	{
			shift_list.add(rs_shift_code.getString("shift_code"));
			shift_list.add(rs_shift_code.getString("shift_desc"));
			shift_list.add(rs_shift_code.getString("shift_mnemonic"));
		}
		if(pstmt_shift_code != null)
			pstmt_shift_code.close();
		if(rs_shift_code != null)
			rs_shift_code.close();

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_schedule_date));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

		for(int i=0;i<shift_list.size();i +=3){

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(shift_list.get(i)));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((String)shift_list.get(i+1)));
            _bw.write(_wl_block15Bytes, _wl_block15);

		}

            _bw.write(_wl_block16Bytes, _wl_block16);

		for(int i=0;i<shift_list.size();i +=3){

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(shift_list.get(i+2)));
            _bw.write(_wl_block18Bytes, _wl_block18);

		}

            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

	//String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code = 'OT' and eff_status = 'E' order by reason_desc";
	String sql_reason="select reason_code,reason_desc from rs_reason_lang_vw where language_id = ? and activity_type_code = 'OT' and eff_status = 'E' order by reason_desc";
	pstmt_reason = conn.prepareStatement(sql_reason);
	pstmt_reason.setString(1,locale);
	
	rs_reason = pstmt_reason.executeQuery();
	

            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
	
		while(rs_reason.next() && rs_reason!=null){
			out.println("<option value='"+rs_reason.getString("reason_code")+"'>"+rs_reason.getString("reason_desc")+"</option>");
		}
		if(pstmt_reason != null)
			pstmt_reason.close();
		if(rs_reason != null)
			rs_reason.close();

            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(p_shift_code));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(p_requirement_id));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(p_workplace_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(p_schedule_date));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(p_role_type));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(p_staff_id));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(p_staff_type));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(p_position_code));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(date_type));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(curr_shift_overtime_yn));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(durn_for_overtime_from_sos));
            _bw.write(_wl_block39Bytes, _wl_block39);

	}catch (Exception e){
		out.println(e.toString());
	}
	finally{
		try
		{
		if(rs_schedule_date!=null) rs_schedule_date.close();
		if(rs_reqid_v!=null) rs_reqid_v.close();
		if(rs_reqid_c!=null) rs_reqid_c.close();
		if(rs_shift_code!=null) rs_shift_code.close();
		if(rs_shift!=null) rs_shift.close();
		if(rs_reason!=null) rs_reason.close();
		if(rs_date_type!=null) rs_date_type.close();
		if(rs_curr_overtime!=null) rs_curr_overtime.close();
		if(rs_start_end_time!=null) rs_start_end_time.close();

		if(pstmt_start_end_time!=null) pstmt_start_end_time.close();
		if(pstmt_schedule_date!=null) pstmt_schedule_date.close();
		if(pstmt_reqid_v!=null) pstmt_reqid_v.close();
		if(pstmt_reqid_c!=null) pstmt_reqid_c.close();
		if(pstmt_shift_code!=null) pstmt_shift_code.close();
		if(pstmt_shift!=null) pstmt_shift.close();
		if(pstmt_reason!=null) pstmt_reason.close();
		if(pstmt_curr_overtime!=null) pstmt_curr_overtime.close();
		if(pstmt_reason!=null) pstmt_reason.close();

		ConnectionManager.returnConnection(conn,request);
		}
		catch(Exception exp)
		{
			out.println(exp.toString());
		}
	}

            _bw.write(_wl_block40Bytes, _wl_block40);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ScheduleDate.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.SHIFT.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.OverTimeDuration.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.apply.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.close.label", java.lang.String .class,"key"));
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
