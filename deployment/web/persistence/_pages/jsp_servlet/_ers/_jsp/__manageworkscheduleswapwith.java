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

public final class __manageworkscheduleswapwith extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleSwapWith.jsp", 1709121639762L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n<html>\n<head>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"JavaScript\" src=\"../../eRS/js/ManageWorkScheduleSwap.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eRS/js/RSMessages.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body>\n<form name=\"ManageWorkScheduleSwap1\" id=\"ManageWorkScheduleSwap1\" action=\'\' target=\'blankFrame\' method=\"post\">\n<table cellpadding=0 cellspacing=0 border=0 width=\"100%\" align=\'right\'>\n<tr>\n\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td>&nbsp;&nbsp;&nbsp;<SELECT name=\"new_workplace\" id=\"new_workplace\" onchange=\"populateStaff(this.form)\">\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</SELECT>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\">\n\t</td>\n\t<td>&nbsp;</td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t<td>&nbsp;&nbsp;&nbsp;<SELECT name=\"new_staff\" id=\"new_staff\" onchange=\"populateNewShifts()\">\n\t<option value\"\">------";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="------</option>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t</SELECT>&nbsp;<img src=\"../../eCommon/images/mandatory.gif\">\n\t</td>\n\t<td>&nbsp;</td>\n\n</table>\n<INPUT TYPE=\"hidden\" name=\"new_staff_id\" id=\"new_staff_id\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"new_workplace_code\" id=\"new_workplace_code\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"p_workplace_code\" id=\"p_workplace_code\" value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_requirement_id\" id=\"p_requirement_id\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_schedule_date\" id=\"p_schedule_date\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_role_type\" id=\"p_role_type\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_staff_id\" id=\"p_staff_id\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_position_code\" id=\"p_position_code\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\"hidden\" name=\"grade_code\" id=\"grade_code\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\"hidden\" name=\"grade_level\" id=\"grade_level\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT TYPE=\"hidden\" name=\"staff_subs_same_grade_yn\" id=\"staff_subs_same_grade_yn\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<INPUT TYPE=\"hidden\" name=\"staff_subs_high_to_low_yn\" id=\"staff_subs_high_to_low_yn\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<INPUT TYPE=\"hidden\" name=\"staff_subs_low_to_high_yn\" id=\"staff_subs_low_to_high_yn\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\n</form>\n</body>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</html>\n\t\n\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

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

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
		
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	PreparedStatement pstmt_staff = null;
	ResultSet rs_staff = null;

    try
	{
	con = ConnectionManager.getConnection(request);
	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_staff_id  = request.getParameter("p_staff_id");
	String p_position_code  = request.getParameter("p_position_code");
	String staff1_shift_code  = request.getParameter("staff1_shift_code");
	String p_schedule_date=request.getParameter("p_schedule_date");
	String grade_code=request.getParameter("grade_code");
	String staff1_grade_level=request.getParameter("grade_level");
	String staff_subs_same_grade_yn=request.getParameter("staff_subs_same_grade_yn");
    String staff_subs_high_to_low_yn=request.getParameter("staff_subs_high_to_low_yn");
	String staff_subs_low_to_high_yn=request.getParameter("staff_subs_low_to_high_yn");
	String workplace_code="";
	String workplace_desc="";
	String staff_id="";
	String staff_name="";
	String p_requirement_id="";

	String sql_requirement_v="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code =? and requirement_type = 'V' and to_date(?,'dd/mm/yyyy') between requirement_date_fm and requirement_date_to";
	pstmt=con.prepareStatement(sql_requirement_v);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,p_workplace_code);
	pstmt.setString(3,p_schedule_date);
	rs=pstmt.executeQuery();
	while(rs!=null && rs.next()){
		p_requirement_id = rs.getString("requirement_id");
		
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(p_requirement_id=="" || p_requirement_id==null){
		String sql_requirement_c="Select requirement_id from rs_workplace_requirement where facility_id = ? and workplace_code = ? and requirement_type = 'C'and requirement_date_fm is null and requirement_date_to is null";
		pstmt=con.prepareStatement(sql_requirement_c);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_workplace_code);
		rs=pstmt.executeQuery();
		while(rs!=null && rs.next()){
			p_requirement_id = rs.getString("requirement_id");
		 }
		if(pstmt!=null) pstmt.close();
		if(rs!=null) rs.close();
	}
	String sql="select distinct a.role_type,a.staff_id,a.staff_name from rs_work_schedule c, am_staff_vw a, rs_grade b where c.facility_id = ? and c.workplace_code =? and c.schedule_date = to_date(?,'dd/mm/yyyy') and c.position_code = ? and c.role_type = ? and c.staff_id != ? and a.role_type = c.role_type and a.staff_id = c.staff_id and b.grade_code = a.grade_code ";

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

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
	
//String sql_work="select facility_id,workplace_code,workplace_desc from rs_workplace where facility_id = ? and workplace_code in(select workplace_code from rs_staff_for_workplace where facility_id = ? and role_type = ? and staff_id = ? and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy'))) and workplace_code in (SELECT a.workplace_code FROM RS_WORKPLACE_REQUIREMENT a  WHERE a.facility_id = ?  AND a.requirement_type = 'V' AND TO_DATE(?,'dd/mm/yyyy') BETWEEN a.requirement_date_fm AND a.requirement_date_to AND ? = (select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id   and position_code = ? and shift_code =?) AND EXISTS(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code =? and shift_code !=?) UNION SELECT a.workplace_code FROM RS_WORKPLACE_REQUIREMENT a WHERE a.facility_id =? AND a.requirement_type = 'C' AND a.requirement_date_fm IS NULL AND a.requirement_date_to IS NULL  AND ? =(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code =?)AND  EXISTS (select shift_code from rs_workplace_requirement_dtl where facility_id = ?  and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code != ?))";

    /*System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_role_type----"+p_role_type);
	System.err.println("p_staff_id----"+p_staff_id);
	System.err.println("p_schedule_date----"+p_schedule_date);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_schedule_date----"+p_schedule_date);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_workplace_code----"+p_workplace_code);
	System.err.println("p_requirement_id----"+p_requirement_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_facility_id----"+p_facility_id);
	System.err.println("p_workplace_code----"+p_workplace_code);
	System.err.println("p_requirement_id----"+p_requirement_id);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("p_position_code----"+p_position_code);
	System.err.println("staff1_shift_code----"+staff1_shift_code);
	System.err.println("locale----"+locale);  */


String sql_work="select facility_id,workplace_code,workplace_desc from rs_workplace_lang_vw where facility_id = ? and workplace_code in(select workplace_code from rs_staff_for_workplace where facility_id = ? and role_type = ? and staff_id = ? and to_date(?,'dd/mm/yyyy') between eff_date_from and nvl(eff_date_to,to_date('31/12/2200','dd/mm/yyyy'))) and workplace_code in (SELECT a.workplace_code FROM rs_workplace_requirement a  WHERE a.facility_id = ?  AND a.requirement_type = 'V' AND TO_DATE(?,'dd/mm/yyyy') BETWEEN a.requirement_date_fm AND a.requirement_date_to AND ? = (select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id   and position_code = ? and shift_code =?) AND EXISTS(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code =? and shift_code !=?) UNION SELECT a.workplace_code FROM RS_WORKPLACE_REQUIREMENT a WHERE a.facility_id =? AND a.requirement_type = 'C' AND a.requirement_date_fm IS NULL AND a.requirement_date_to IS NULL  AND ? =(select shift_code from rs_workplace_requirement_dtl where facility_id = ? and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code =?)AND  EXISTS (select shift_code from rs_workplace_requirement_dtl where facility_id = ?  and workplace_code = ? and requirement_id = ? and position_code = ? and shift_code !=? intersect select shift_code from rs_workplace_requirement_dtl where facility_id = a.facility_id and workplace_code = a.workplace_code and requirement_id = a.requirement_id and position_code = ? and shift_code != ?)) and language_id = ?";

	pstmt = con.prepareStatement(sql_work);
	pstmt.setString(1,p_facility_id);
	pstmt.setString(2,p_facility_id);
	pstmt.setString(3,p_role_type);
	pstmt.setString(4,p_staff_id);
	pstmt.setString(5,p_schedule_date);
	pstmt.setString(6,p_facility_id);
	pstmt.setString(7,p_schedule_date);
	pstmt.setString(8,staff1_shift_code);
	pstmt.setString(9,p_facility_id);
	pstmt.setString(10,p_position_code);
	pstmt.setString(11,staff1_shift_code);
	pstmt.setString(12,p_facility_id);
	pstmt.setString(13,p_workplace_code);
	pstmt.setString(14,p_requirement_id);
	pstmt.setString(15,p_position_code);
	pstmt.setString(16,staff1_shift_code);
	pstmt.setString(17,p_position_code);
	pstmt.setString(18,staff1_shift_code);
	pstmt.setString(19,p_facility_id);
	pstmt.setString(20,staff1_shift_code);
	pstmt.setString(21,p_facility_id);
	pstmt.setString(22,p_position_code);
	pstmt.setString(23,staff1_shift_code);
	pstmt.setString(24,p_facility_id);
	pstmt.setString(25,p_workplace_code);
	pstmt.setString(26,p_requirement_id);
	pstmt.setString(27,p_position_code);
	pstmt.setString(28,staff1_shift_code);
	pstmt.setString(29,p_position_code);
	pstmt.setString(30,staff1_shift_code);
	pstmt.setString(31,locale);

	rs = pstmt.executeQuery();

	if(rs!=null){
		while(rs.next()){
			workplace_code = rs.getString("workplace_code");
			workplace_desc= rs.getString("workplace_desc");
			if(workplace_code.equalsIgnoreCase(p_workplace_code)){
			  out.println("<option selected value='"+workplace_code+"'>"+workplace_desc+"</option>");
			}
			else{
			  out.println("<option value='"+workplace_code+"'>"+workplace_desc+"</option>");
			}
		}
	}
	if(pstmt!=null) pstmt.close();
	if(rs!=null) rs.close();

            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	System.err.println("sql------->"+sql);

	pstmt_staff = con.prepareStatement(sql);
    pstmt_staff.setString(1,p_facility_id);
    pstmt_staff.setString(2,p_workplace_code);
    pstmt_staff.setString(3,p_schedule_date);
    pstmt_staff.setString(4,p_position_code);
    pstmt_staff.setString(5,p_role_type);
    pstmt_staff.setString(6,p_staff_id);

   System.err.println("p_facility_id------->"+p_facility_id);
   System.err.println("p_workplace_code------->"+p_workplace_code);
   System.err.println("p_schedule_date------->"+p_schedule_date);
   System.err.println("p_position_code------->"+p_position_code);
   System.err.println("p_role_type------->"+p_role_type);
   System.err.println("p_staff_id------->"+p_staff_id);
	rs_staff = pstmt_staff.executeQuery();
	 
	if(rs_staff!=null){
		while(rs_staff.next()){
			staff_id = rs_staff.getString("staff_id");
			staff_name= rs_staff.getString("staff_name");
			out.println("<option value="+staff_id+'>'+staff_name+"</option>");
		}
	}
	if(pstmt_staff!=null) pstmt_staff.close();
	if(rs_staff!=null) rs_staff.close();
	

            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(p_workplace_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(p_requirement_id));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(p_schedule_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(p_role_type));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(p_staff_id));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_position_code));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(grade_code));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(staff1_grade_level));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(staff_subs_same_grade_yn));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(staff_subs_high_to_low_yn));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(staff_subs_low_to_high_yn));
            _bw.write(_wl_block25Bytes, _wl_block25);

	}
	catch (Exception e){
		out.println(e.toString());
	}
	finally{
		if(rs_staff!=null) rs_staff.close();
		if(pstmt_staff!=null) pstmt_staff.close();
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block26Bytes, _wl_block26);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.WorkPlace.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.Staff.label", java.lang.String .class,"key"));
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
}
