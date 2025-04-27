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

public final class __manageworkscheduleovertimedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleOvertimeDynamicValues.jsp", 1709117439650L ,"10.3.6.0","Asia/Calcutta")) return true;
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser obj= null;{
                obj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("obj");
                if(obj==null){
                    obj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("obj",obj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);

	String shift_code = request.getParameter("shift_code1")==null?"":request.getParameter("shift_code1");
	String schedule_date = request.getParameter("schedule_date")==null?"":request.getParameter("schedule_date");
	String facility_id = request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	String workplace_code = request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	String role_type = request.getParameter("role_type")==null?"":request.getParameter("role_type");
	String staff_id = request.getParameter("staff_id")==null?"":request.getParameter("staff_id");
	String curr_shift_overtime_yn = request.getParameter("curr_shift_overtime_yn")==null?"":request.getParameter("curr_shift_overtime_yn");
	String durn_for_overtime_from_sos = request.getParameter("durn_for_overtime_from_sos")==null?"":request.getParameter("durn_for_overtime_from_sos");
	String hr = request.getParameter("over_time_durn1")==null?"0":request.getParameter("over_time_durn1");
	String mi = request.getParameter("over_time_durn2")==null?"0":request.getParameter("over_time_durn2");
	String shift_start_time = request.getParameter("shift_start_time")==null?"":request.getParameter("shift_start_time");
	String actual_end_time = request.getParameter("actual_end_time")==null?"":request.getParameter("actual_end_time");
	String shift_end_date_time = request.getParameter("shift_end_date_time")==null?"":request.getParameter("shift_end_date_time");
	String flag = request.getParameter("flag")==null?"":request.getParameter("flag");
	Connection con = null;

	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt_overtime = null;
	ResultSet rs_overtime = null;
		
	String start_time = "" ;
	String end_time = "";
	String valid_yn = "";
	String overlaps_yn = "";
	String shift_start_time1 = "";
	String actual_end_time1 = "";
	String shift_start_date_time = "";
	String actual_end_date_time = "";
	con = ConnectionManager.getConnection(request);

	try{
		if(flag.equals("changeshift")){
			String sql="select ?||to_char(shift_start_time,'hh24:mi') shift_start_date_time,to_char(to_date(?,'dd/mm/yyyy')+            decode(sign(to_date(to_char(shift_start_time,'hh24:mi'),'hh24:mi') -                    to_date(to_char(shift_end_time,'hh24:mi'),'hh24:mi')),1,1,0 ),'dd/mm/yyyy') ||to_char(shift_end_time,'hh24:mi')   shift_end_date_time,to_char(shift_start_time,'hh24:mi') shift_start_time,to_char(shift_end_time,'hh24:mi') shift_end_time from am_shift where shift_code=?";

			pstmt= con.prepareStatement(sql);	
			pstmt.setString(1,schedule_date);
			pstmt.setString(2,schedule_date);
			pstmt.setString(3,shift_code);
			rs=pstmt.executeQuery();
			while(rs.next()){     
								
				start_time = rs.getString("shift_start_time")==null ? "": rs.getString("shift_start_time");	
				end_time = rs.getString("shift_end_time")==null ? "": rs.getString("shift_end_time");	
				shift_start_date_time = rs.getString("shift_start_date_time")==null ? "": rs.getString("shift_start_date_time");
				shift_end_date_time = rs.getString("shift_end_date_time")==null ? "": rs.getString("shift_end_date_time");
				out.println( "assignDateRange(\"" + start_time + "\",\"" + end_time + "\",\"" + shift_start_date_time + "\" , \"" + shift_end_date_time+ "\") ; " ) ;
				
			}
			if(pstmt != null) pstmt.close();
			if(rs != null) rs.close();
				
			String sql_overtime = "select decode(?,'N','NA', decode(sign(sysdate - (shift_start_time + (( (to_number(substr(?,1,2))*60) + to_number(substr(?,4))) / (24*60)))),1,'DL','AL')) valid_yn, 	  to_char(shift_start_time,'dd/mm/yyyy') shift_start_time,to_char(actual_end_time,'dd/mm/yyyy') actual_end_time from rs_work_schedule where facility_id = ? and workplace_code = ? and role_type = ? and staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and shift_code = ? and sysdate between shift_start_time and actual_end_time union all select 'AL' valid_yn,to_char(shift_start_time,'dd/mm/yyyy') shift_start_time,to_char(actual_end_time,'dd/mm/yyyy') actual_end_time from rs_work_Schedule where facility_id = ? and workplace_code = ? and role_type =? and staff_id =? and schedule_date = to_date(?,'dd/mm/yyyy') AND shift_code = ? and shift_start_time > sysdate ";
			pstmt_overtime = con.prepareStatement(sql_overtime);
			pstmt_overtime.setString(1,curr_shift_overtime_yn);
			pstmt_overtime.setString(2,durn_for_overtime_from_sos);
			pstmt_overtime.setString(3,durn_for_overtime_from_sos);
			pstmt_overtime.setString(4,facility_id);
			pstmt_overtime.setString(5,workplace_code);
			pstmt_overtime.setString(6,role_type);
			pstmt_overtime.setString(7,staff_id);
			pstmt_overtime.setString(8,schedule_date);
			pstmt_overtime.setString(9,shift_code);
			pstmt_overtime.setString(10,facility_id);
			pstmt_overtime.setString(11,workplace_code);
			pstmt_overtime.setString(12,role_type);
			pstmt_overtime.setString(13,staff_id);
			pstmt_overtime.setString(14,schedule_date);
			pstmt_overtime.setString(15,shift_code);
			rs_overtime = pstmt_overtime.executeQuery();
			/*System.out.println("curr_shift_overtime_yn=====85===>" +curr_shift_overtime_yn);
			System.out.println("durn_for_overtime_from_sos=====86===>" +durn_for_overtime_from_sos);
			System.out.println("durn_for_overtime_from_sos=====87===>" +durn_for_overtime_from_sos);
			System.out.println("facility_id=====85===>" +facility_id);
			System.out.println("workplace_code=====89===>" +workplace_code);
			System.out.println("role_type=====89===>" +role_type);
			System.out.println("staff_id=====89===>" +staff_id);
			System.out.println("schedule_date=====89===>" +schedule_date);
			System.out.println("shift_code=====93===>" +shift_code);
			System.out.println("facility_id=====93===>" +facility_id);
			System.out.println("workplace_code=====93===>" +workplace_code);
			System.out.println("role_type=====93===>" +role_type);
			System.out.println("staff_id=====93===>" +staff_id);
			System.out.println("schedule_date=====93===>" +schedule_date);
			System.out.println("shift_code=====93===>" +shift_code);*/

			while(rs_overtime != null && rs_overtime.next()){
				valid_yn = rs_overtime.getString("valid_yn");
				shift_start_time1 = rs_overtime.getString("shift_start_time");
				actual_end_time1 = rs_overtime.getString("actual_end_time");
				out.println( "assignovertime(\"" + valid_yn + "\",\"" + shift_start_time1 + "\",\"" + actual_end_time1 + "\") ; " ) ;
			}
			//System.out.println("valid_yn=====107===>" +valid_yn);
			if(pstmt_overtime != null)
				pstmt_overtime.close();
			if(rs_overtime != null)
				rs_overtime.close();
		}
		else{
			String sql_overlap = "select decode(nvl(count(*),0),0,'N','Y')  overlaps_yn from rs_work_schedule where role_type = ? and staff_id =? and shift_code !=? and ( to_date(?,'dd/mm/yyyy hh24:mi') between shift_start_time and actual_end_time or to_date(?,'dd/mm/yyyy hh24:mi') + (((?*60)+(?))/(24*60))between shift_start_time and actual_end_time)";

			pstmt = con.prepareStatement(sql_overlap);
			pstmt.setString(1,role_type);
			pstmt.setString(2,staff_id);
			pstmt.setString(3,shift_code);
			pstmt.setString(4,shift_start_time);
			pstmt.setString(5,actual_end_time);
			pstmt.setString(6,hr);
			pstmt.setString(7,mi);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next()){
				overlaps_yn = rs.getString("overlaps_yn");
			}
			if(pstmt != null)
				pstmt.close();
			if(rs != null)
				rs.close();

			String sql_actual_end_time = "Select to_char(to_date(? ,'dd/mm/yyyyhh24:mi' ) +(((?* 60)+?) / (24*60)),'dd/mm/yyyyhh24:mi')actual_end_date_time from rs_work_Schedule";

			pstmt_overtime = con.prepareStatement(sql_actual_end_time);
			pstmt_overtime.setString(1,shift_end_date_time);
			pstmt_overtime.setString(2,hr);
			pstmt_overtime.setString(3,mi);
			rs_overtime = pstmt_overtime.executeQuery();

			while(rs_overtime != null && rs_overtime.next()){
				actual_end_date_time = rs_overtime.getString("actual_end_date_time");
			}
			if(pstmt_overtime != null)
				pstmt_overtime.close();
			if(rs_overtime != null)
				rs_overtime.close();
			out.println( "getoverlap(\"" + overlaps_yn + "\",\""+ actual_end_date_time + "\") ; " ) ;
		}
	}catch(Exception e) { 
		out.println("Main : "+e.toString());
	}
	finally{
		try
		{
		if (pstmt != null) pstmt.close();
		if (pstmt_overtime != null) pstmt_overtime.close();
		if (rs != null) rs.close();
		if (rs_overtime != null) rs_overtime.close();
		ConnectionManager.returnConnection(con,request); 
		}
		catch(Exception exp)
		{
			out.println(exp.toString());
		}
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
