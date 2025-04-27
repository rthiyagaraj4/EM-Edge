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

public final class __manageworkscheduleswap extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleSwap.jsp", 1709121639105L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"JavaScript\" src=\"../../eRS/js/ManageWorkScheduleSwap.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eRS/js/RSMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body>\n<form name=\"ManageWorkScheduleSwap\" id=\"ManageWorkScheduleSwap\" action=\'../../servlet/eRS.ManageWorkScheduleSwapServlet\' target=\'blankFrame\' method=\"post\">\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=\'right\'>\n\n<tr>\n\t<td class=\'label\' align=\'right\' width=\'30%\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'querydata\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t<td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td class=\'label\' align=\'right\' width=\'30%\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td class=\'label\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td colspan=\'3\'>&nbsp;</td>\n</tr>\n<tr>\n\t<td width=\'30%\'>&nbsp;</td>\n\t<td class=\'querydata\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="&nbsp;&nbsp;&nbsp;</td>\n\t<td class=\'querydata\' align=\'left\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n<tr>\n<td>&nbsp;</td>\n<td>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>\n<td align=\'left\'><INPUT TYPE=\"button\" class=\'button\' value=\'";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\' onclick=\"swapwith()\"></td>\n</tr>\n<tr>\n<td colspan=\'3\'>&nbsp;</td>\n</tr>\n</table>\n<INPUT TYPE=\"hidden\" name=\"staff1_allocated_shifts_string\" id=\"staff1_allocated_shifts_string\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_shift_code\" id=\"p_shift_code\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_requirement_id\" id=\"p_requirement_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_workplace_code\" id=\"p_workplace_code\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_schedule_date\" id=\"p_schedule_date\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_role_type\" id=\"p_role_type\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_staff_id\" id=\"p_staff_id\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_staff_type\" id=\"p_staff_type\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_position_code\" id=\"p_position_code\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<INPUT TYPE=\"hidden\" name=\"grade_code\" id=\"grade_code\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n<INPUT TYPE=\"hidden\" name=\"grade_level\" id=\"grade_level\" value=\"";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\">\n<INPUT TYPE=\"hidden\" name=\"staff_subs_same_grade_yn\" id=\"staff_subs_same_grade_yn\" value=\"";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\">\n<INPUT TYPE=\"hidden\" name=\"staff_subs_high_to_low_yn\" id=\"staff_subs_high_to_low_yn\" value=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n<INPUT TYPE=\"hidden\" name=\"staff_subs_low_to_high_yn\" id=\"staff_subs_low_to_high_yn\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<INPUT TYPE=\"hidden\" name=\"mnemonic\" id=\"mnemonic\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"staff1_shiftcode_value\" id=\"staff1_shiftcode_value\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"shift_start_time\" id=\"shift_start_time\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"shift_end_time\" id=\"shift_end_time\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"mode\" id=\"mode\" value=\"insert\">\n<INPUT TYPE=\"hidden\" name=\"shift_indicator\" id=\"shift_indicator\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"productive_flag\" id=\"productive_flag\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"count\" id=\"count\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n</form>\n</body>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</html>\n\n";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

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

request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block5Bytes, _wl_block5);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
  
	Connection con = null;

	PreparedStatement pstmt = null;

	ResultSet rs = null;
	ResultSet prs = null;

	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_date  = request.getParameter("p_date");
	int p_cell_no  = Integer.parseInt(request.getParameter("p_cell_no"));
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_staff_type  = request.getParameter("p_staff_type");
	String p_position_code  = request.getParameter("p_position_code");
	String p_shift_code  = request.getParameter("p_shift_code");
	String p_shift_mnemonic  = request.getParameter("p_shift_mnemonic");
	String p_schedule_date="";
	String p_staff_name="";
	String p_requirement_id = "";
	String staff_subs_same_grade_yn="";
	String staff_subs_high_to_low_yn="";
	String staff_subs_low_to_high_yn="";     
	String curr_shift_swap_yn="";
	String durn_for_swap_from_sos="";
	String count="";
	String grade_code =""; 
	String grade_level="";
	String[] wrk_record=null;
   String p_workplace_desc="";
	try{
		
		con = ConnectionManager.getConnection(request);
        StringBuffer temp_shift = new StringBuffer("'" + p_shift_code + "'");
	    //out.println("temp_shift----->"+temp_shift);
        while(temp_shift.toString().indexOf('|') != -1)
		{
			
            int index = temp_shift.toString().indexOf('|');
			//out.println("index--|"+index+"|---");
			
            temp_shift.replace(index,index+1,"','");
        }
		p_shift_code = temp_shift.toString();
		p_shift_code=p_shift_code.substring(1,(p_shift_code.length()-1));
		
       
		StringBuffer temp_mnemo = new StringBuffer("'" + p_shift_mnemonic + "'");
		//out.println("temp_mnemo---->"+temp_mnemo);
        while(temp_mnemo.toString().indexOf('|') != -1){
            int index = temp_mnemo.toString().indexOf('|');
			
            temp_mnemo.replace(index,index+1,"','");


        }
		p_shift_mnemonic = temp_mnemo.toString();
		//out.println("p_shift_mnemonic---->"+p_shift_mnemonic);
		p_shift_mnemonic=p_shift_mnemonic.substring(1,(p_shift_mnemonic.length()-1));
		//out.println("p_shift_mnemonic---->"+p_shift_mnemonic);
		
		String sql_sch_date = "select to_char(to_date(?,'dd/mm/yyyy') + ?,'dd/mm/yyyy' )p_schedule_date from dual";
		pstmt = con.prepareStatement(sql_sch_date);
		pstmt.setString(1,p_date);
		pstmt.setInt(2,p_cell_no);
		rs = pstmt.executeQuery();
		
		if(rs!=null){
			
			if(rs.next()){
				
				p_schedule_date = rs.getString("p_schedule_date");
				
			}
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();

		String rs_param="select	staff_subs_same_grade_yn, staff_subs_high_to_low_yn, staff_subs_low_to_high_yn ,curr_shift_swap_yn, durn_for_swap_from_sos from rs_parameter where facility_id =?";
		pstmt = con.prepareStatement(rs_param);
		pstmt.setString(1,p_facility_id);
		rs = pstmt.executeQuery();
		if(rs!=null)
		{	
			if(rs.next())
			{	
					
			staff_subs_same_grade_yn=rs.getString("STAFF_SUBS_SAME_GRADE_YN");
			staff_subs_high_to_low_yn=rs.getString("STAFF_SUBS_HIGH_TO_LOW_YN");
			staff_subs_low_to_high_yn=rs.getString("STAFF_SUBS_LOW_TO_HIGH_YN");     
			curr_shift_swap_yn= rs.getString("CURR_SHIFT_SWAP_YN"); 
			durn_for_swap_from_sos = rs.getString("DURN_FOR_SWAP_FROM_SOS");
			}
			
		}
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	
		if(staff_subs_same_grade_yn.equalsIgnoreCase("N") && staff_subs_high_to_low_yn.equalsIgnoreCase("N") && staff_subs_low_to_high_yn.equalsIgnoreCase("N")){
			out.println("<script>alert(getMessage('STAFF_SUBSTITUTION_FEATURE_NOT_ENABLED','RS'));</script>");
			out.println("<script>window.close();</script>");
		}
	
		String sql_satf_name ="select a.staff_name, a.grade_code, a.position_code, b.grade_level from am_staff_vw a, rs_grade b where role_type = ? and staff_id =?";
		 pstmt = con.prepareStatement(sql_satf_name);
		 pstmt.setString(1,p_role_type);
		 pstmt.setString(2,p_staff_id);
		 rs = pstmt.executeQuery();
		 
		 if(rs!=null){
			 
			if(rs.next()){
				
				p_staff_name = rs.getString("staff_name");
				grade_code = rs.getString("grade_code");
				grade_level = rs.getString("grade_level");

			}
		
		 }
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();

		
		//String sql_workplace_desc ="select workplace_desc from rs_workplace where facility_id=? and workplace_code=?";
		String sql_workplace_desc ="select workplace_desc from rs_workplace_lang_vw where facility_id=? and workplace_code=? and language_id = ?";

		pstmt = con.prepareStatement(sql_workplace_desc);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_workplace_code);
		pstmt.setString(3,locale);
		 rs = pstmt.executeQuery();
		/* System.out.println("Values in manageworkscheduleswap.jsp 131-------->");
		 System.out.println("p_facility_id 132----|"+p_facility_id+"|---p_workplace_code 133----|"+p_workplace_code+"|---locale 134---|"+locale+"|---");*/
		 if(rs!=null){
			 
			if(rs.next()){
				
				p_workplace_desc = rs.getString("workplace_desc");
				
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		 }
		 

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_schedule_date));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_workplace_desc));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_staff_name));
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	//String sql_shifts = "select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss') actual_end_time, decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time + (((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift a, rs_work_schedule b where a.shift_code in (?) and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key,	to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'),	to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in (?) and a.shift_code=b.shift_code";

	String sql_shifts = "select a.productive_flag productive_flag,a.shift_indicator shift_indicator,a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic,to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss') shift_start_time,to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss') actual_end_time, decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time + (((to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'N','Y')) valid_yn from am_shift_lang_vw a, rs_work_schedule b where a.shift_code in (?) and a.shift_code = b.shift_code and b.facility_id = ? and b.workplace_code = ? and b.role_type = ?   and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and sysdate between b.shift_start_time and b.actual_end_time and a.language_id = ? union all select a.productive_flag,a.shift_indicator,b.shift_code,a.long_desc,a.mnemonic_key, to_char(b.shift_start_time,'dd/mm/yyyy hh24:mi:ss'), to_char(b.actual_end_time,'dd/mm/yyyy hh24:mi:ss'),'Y' valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type=? and b.staff_id=? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and b.shift_code in (?) and a.shift_code=b.shift_code and a.language_id = ?";
    


	pstmt = con.prepareStatement(sql_shifts);
	pstmt.setString(1,curr_shift_swap_yn);
	pstmt.setString(2,durn_for_swap_from_sos);
	pstmt.setString(3,durn_for_swap_from_sos);
	pstmt.setString(4,p_shift_code);
	pstmt.setString(5,p_facility_id);
	pstmt.setString(6,p_workplace_code);
	pstmt.setString(7,p_role_type);
	pstmt.setString(8,p_staff_id);
	pstmt.setString(9,p_schedule_date);
	pstmt.setString(10,locale);
	pstmt.setString(11,p_facility_id);
	pstmt.setString(12,p_workplace_code);
	pstmt.setString(13,p_role_type);
	pstmt.setString(14,p_staff_id);
	pstmt.setString(15,p_schedule_date);
	pstmt.setString(16,p_shift_code);
	pstmt.setString(17,locale);
	
	prs = pstmt.executeQuery();
	
	String staff1_allocated_shifts_string="|";
	String valid_yn="";
	int shifts=0;
	if(prs!=null){
		int i = 0;
		while(prs.next()){
			 shifts=1;
			staff1_allocated_shifts_string +=prs.getString("shift_code")+"|";
			valid_yn=prs.getString("valid_yn");
			if(valid_yn.equalsIgnoreCase("N"))	{
				out.println("<tr>");
				out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
				out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+prs.getString("shift_desc")+"&nbsp;&nbsp;"+prs.getString("shift_mnemonic")+"</td>");
				out.println("<td align='left'><INPUT TYPE='radio' disabled name='staff1_shft_code' id='staff1_shft_code' value='"+prs.getString("shift_code")+"' onclick=''></td>");
			}
			else{
			out.println("<tr>");
			out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
			out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+prs.getString("shift_desc")+"&nbsp;&nbsp;"+prs.getString("shift_mnemonic")+"</td>");
			out.println("<td align='left'><INPUT TYPE='radio'  name='staff1_shft_code' id='staff1_shft_code' value='"+prs.getString("shift_code")+"' onClick='shiftchk(this)' ></td>");
			out.println("</tr>");
			i++;
			}
		}
		i--;
		count = ""+i;
	}
	if(pstmt!=null) pstmt.close();
	if(prs!=null) prs.close();
	
	if(shifts==0){
		out.println("<script>alert(getMessage('NO_VALID_SHIFTS_SWAP','RS'));</script>");
		out.println("<script>window.close();</script>");
	}

            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(staff1_allocated_shifts_string));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_shift_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_requirement_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_workplace_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_schedule_date));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_role_type));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_staff_id));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_staff_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_position_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(grade_code));
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(grade_level));
            _bw.write(_wl_block27Bytes, _wl_block27);
            out.print( String.valueOf(staff_subs_same_grade_yn));
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(staff_subs_high_to_low_yn));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(staff_subs_low_to_high_yn));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(count));
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
	catch (Exception e)
	{
		out.println(e.toString());
	}
	finally
	{
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block32Bytes, _wl_block32);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.SwapShifts.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.ScheduleDate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Workplace.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Staff.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.AllocatedShifts.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.SwapWith.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${rs_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
