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

public final class __manageworkscheduleswapdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleSwapDynamicValues.jsp", 1709121639293L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t<script>\n\t\t\tvar temp_id = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n\t\t\tvar temp_name=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n\t\t\tvar opt=parent.ManageWorkScheduleSwap_frame.document.createElement(\"OPTION\");\n\t\t\topt.text=temp_name;\n\t\t\topt.value=temp_id;\n\t\t\tvar comp=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =";\n\t\t\tcomp.add(opt)\n\t</script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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
		
	

	String p_facility_id  = request.getParameter("p_facility_id");
	String new_workplace_code = request.getParameter("new_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_position_code  = request.getParameter("p_position_code");
	String p_schedule_date=request.getParameter("p_schedule_date");
	String staff1_grade_level=request.getParameter("grade_level");
	String staff_subs_same_grade_yn=request.getParameter("staff_subs_same_grade_yn");
    String staff_subs_high_to_low_yn=request.getParameter("staff_subs_high_to_low_yn");
	String staff_subs_low_to_high_yn=request.getParameter("staff_subs_low_to_high_yn");
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	String staff_id="";
	String staff_name="";
	String comp=" ";
				
	try{	
		con = ConnectionManager.getConnection(request);
		String sql="select distinct a.role_type,a.staff_id,a.staff_name from rs_work_schedule c, am_staff_vw a, rs_grade b where c.facility_id = ? and c.workplace_code =? and c.schedule_date = to_date(?,'dd/mm/yyyy') and c.position_code =? and c.role_type = ? and c.staff_id != ? and a.role_type = c.role_type and a.staff_id = c.staff_id and b.grade_code = a.grade_code ";

		if(staff_subs_same_grade_yn.equalsIgnoreCase("Y") || staff_subs_high_to_low_yn.equalsIgnoreCase("Y") || staff_subs_low_to_high_yn.equalsIgnoreCase("Y")){
			sql = sql + " and ( ";
		}
	
		int flag = 0;
		if(staff_subs_same_grade_yn.equalsIgnoreCase("Y")){
			sql = sql +	" b.grade_level = '"+staff1_grade_level+"' ";
			flag = 1;
		}
		if(staff_subs_high_to_low_yn.equalsIgnoreCase("Y")){
			if(flag == 1){
				sql = sql + " or ";
			}
			
			sql = sql + " b.grade_level > '"+staff1_grade_level+"' ";
			flag = 1;
		}	

		if(staff_subs_low_to_high_yn.equalsIgnoreCase("Y")){
			if(flag == 1){
				sql = sql + " or ";
			}
			sql = sql + " b.grade_level < '"+staff1_grade_level+"' ";
		}

		if(staff_subs_same_grade_yn.equalsIgnoreCase("Y") || staff_subs_high_to_low_yn.equalsIgnoreCase("Y") || staff_subs_low_to_high_yn.equalsIgnoreCase("Y")){
			sql = sql + " ) ";
		}
		sql = sql + " order by a.staff_name ";
		System.err.println("sql---->"+sql);
		
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,new_workplace_code);
		pstmt.setString(3,p_schedule_date);
		pstmt.setString(4,p_position_code);
		pstmt.setString(5,p_role_type);
		pstmt.setString(6,p_staff_id);
		rs = pstmt.executeQuery();
		//System.err.println("rs------>"+rs);
		while( rs!=null && rs.next()){
			staff_id=rs.getString("staff_id");
			staff_name=rs.getString("staff_name");
			comp="parent.ManageWorkScheduleSwap_frame.document.forms[0].new_staff";


            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(staff_id));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(staff_name));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(comp));
            _bw.write(_wl_block5Bytes, _wl_block5);
	
		
		}
		if(pstmt != null)
			pstmt.close();
		if(rs != null)
			rs.close();
	}
	catch(Exception e){
		out.print(e);
	}
	finally {
		if(pstmt != null)
			pstmt.close();
		if(rs != null)
			rs.close();
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
