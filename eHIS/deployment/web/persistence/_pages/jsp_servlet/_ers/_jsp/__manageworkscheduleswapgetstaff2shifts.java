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

public final class __manageworkscheduleswapgetstaff2shifts extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ManageWorkScheduleSwapGetStaff2Shifts.jsp", 1709121639512L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n";
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

    private final static java.lang.String  _wl_block7 ="\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/common.js\"></script>\n<script language=\"javascript\" src=\"../../eCommon/js/dchk.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eCommon/js/messages.js\"></script> -->\n<!-- <script language=\"javascript\" src=\"../../eCommon/js/MstCodeCommon.js\"></script>\n --><script language=\"JavaScript\" src=\"../../eRS/js/ManageWorkScheduleSwap.js\"></script>\n<!-- <script language=\"JavaScript\" src=\"../../eRS/js/RSMessages.js\"></script> -->\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body>\n<form name=\"ManageWorkScheduleStaff2shifts_form\" id=\"ManageWorkScheduleStaff2shifts_form\" action=\'../../servlet/eRS.ManageWorkScheduleSwapServlet\' target=\'blankFrame\' method=\"post\">\n<table cellpadding=0 cellspacing=0 border=0 width=\"103%\" align=\'right\'>\n<tr>\n\t<td width=\'30%\'>&nbsp;</td>\n\t<td class=\'querydata\'>&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t<td class=\'querydata\' align=\'left\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="&nbsp;<img src=\"../../eCommon/images/mandatory.gif\"></td>\n</tr>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<tr>\n\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t<td>&nbsp;&nbsp;&nbsp;<SELECT name=\"reason\" id=\"reason\" onchange=\'validate();\' >\n\t\t\t<option value=\"\">----------";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="----------</option>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</SELECT><img src=\"../../eCommon/images/mandatory.gif\">\n\t</td>\n\t<td></td>\n</tr>\n\n<tr>\n\t<td class=\'label\' width=\'30%\' align=\'right\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t<td>&nbsp;&nbsp;&nbsp;<TEXTAREA NAME=\"remarks\" COLS=\"30\" onkeypress=\'return notallowenter(event);\'></TEXTAREA>\n\t</td>\n\t<td></td>\n\t\n</tr>\n\n<tr>\n\t<td colspan=\'3\'>&nbsp;</td>\n</tr>\n\n</table>\n\t\n\t<INPUT TYPE=\"hidden\" name=\"staff2_shiftcode_value\" id=\"staff2_shiftcode_value\" value=\"\">\n\n<INPUT TYPE=\"hidden\" name=\"staff2_allocated_shifts_string\" id=\"staff2_allocated_shifts_string\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n<INPUT TYPE=\"hidden\" name=\"durn_for_swap_from_sos\" id=\"durn_for_swap_from_sos\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_facility_id\" id=\"p_facility_id\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_workplace_code\" id=\"p_workplace_code\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_requirement_id\" id=\"p_requirement_id\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_schedule_date\" id=\"p_schedule_date\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_role_type\" id=\"p_role_type\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_position_code\" id=\"p_position_code\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<INPUT TYPE=\"hidden\" name=\"p_staff_type\" id=\"p_staff_type\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"p_staff_id\" id=\"p_staff_id\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"staff1_shift_code\" id=\"staff1_shift_code\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"new_workplace_code\" id=\"new_workplace_code\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"new_staff_id\" id=\"new_staff_id\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"staff2_shift_code\" id=\"staff2_shift_code\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"old_shift_indicator\" id=\"old_shift_indicator\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"old_productive_flag\" id=\"old_productive_flag\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"old_mnemonic_key\" id=\"old_mnemonic_key\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"new_shift_indicator\" id=\"new_shift_indicator\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"new_productive_flag\" id=\"new_productive_flag\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"new_mnemonic_key\" id=\"new_mnemonic_key\" value=\"\">\n</form>\n</body>\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

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


	String p_facility_id  = request.getParameter("p_facility_id");
	String p_workplace_code = request.getParameter("p_workplace_code");
	String p_role_type  = request.getParameter("p_role_type");
	String p_position_code  = request.getParameter("p_position_code");
	String p_schedule_date=request.getParameter("p_schedule_date");
	
	String p_requirement_id = request.getParameter("p_requirement_id");
	String new_workplace_code = request.getParameter("new_workplace_code");
	String new_staff_id = request.getParameter("new_staff_id");
	String curr_shift_swap_yn="";
	String durn_for_swap_from_sos="";
	if(new_workplace_code.equals(""))
	new_workplace_code=p_workplace_code;

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rs=null;
	PreparedStatement pstmt_staff = null;
	ResultSet rs_staff=null;
		
    try
	{	
		con = ConnectionManager.getConnection(request);
		
		String sql="Select max_continuous_work_duration, curr_shift_swap_yn, durn_for_swap_from_sos from rs_parameter Where facility_id =?";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,p_facility_id);
		rs = pstmt.executeQuery();
		while( rs!=null && rs.next())
		{
			curr_shift_swap_yn=rs.getString("curr_shift_swap_yn");
			durn_for_swap_from_sos=rs.getString("durn_for_swap_from_sos");
		}
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();

		String sql_req="select shift_code from rs_workplace_requirement_dtl where facility_id=? and workplace_code = ? and requirement_id = ? and position_code = ?";

		pstmt = con.prepareStatement(sql_req);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_workplace_code);
		pstmt.setString(3,p_requirement_id);
		pstmt.setString(4,p_position_code);
		rs = pstmt.executeQuery();
		String valid_shifts_string="|";
		while( rs!=null && rs.next())
		{
			valid_shifts_string +=rs.getString("shift_code")+"|";
		}
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();

		//String sql_newshifts="select a.productive_flag productive_flag,a.shift_indicator shift_indicator, a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic, decode(instr(?,'|'||a.shift_code||'|'),0,'N',decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4)))/ (24*60)))),1,'N','Y')))valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and	a.shift_code = b.shift_code and sysdate between b.shift_start_time  and b.actual_end_time union all select a.productive_flag,a.shift_indicator, 	b.shift_code,a.long_desc,a.mnemonic_key,	decode(instr(?,'|'||a.shift_code||'|'),0,'N','Y') valid_yn from am_shift a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and a.shift_code=b.shift_code order by shift_desc";
		String sql_newshifts="select a.productive_flag productive_flag,a.shift_indicator shift_indicator, a.shift_code shift_code, a.long_desc shift_desc, a.mnemonic_key shift_mnemonic, decode(instr(?,'|'||a.shift_code||'|'),0,'N',decode(?,'N','N',decode(sign(sysdate - (b.shift_start_time +(((to_number(substr(?,1,2))*60) + to_number(substr(?,4)))/ (24*60)))),1,'N','Y')))valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and trunc(sysdate) = to_date(?,'dd/mm/yyyy') and a.shift_code = b.shift_code and sysdate between b.shift_start_time  and b.actual_end_time and a.language_id = ? union all select a.productive_flag,a.shift_indicator,  b.shift_code,a.long_desc,a.mnemonic_key, decode(instr(?,'|'||a.shift_code||'|'),0,'N','Y') valid_yn from am_shift_lang_vw a, rs_work_schedule b where b.facility_id = ? and b.workplace_code = ? and b.role_type = ? and b.staff_id = ? and b.schedule_date=to_date(?,'dd/mm/yyyy') and b.shift_start_time > sysdate and a.shift_code=b.shift_code and a.language_id = ? order by shift_desc";

		String valid_yn="";
		String shift_code="";
		String shift_mnemonic="";
		String shift_desc="";

		pstmt_staff = con.prepareStatement(sql_newshifts);
		pstmt_staff.setString(1,valid_shifts_string);
		pstmt_staff.setString(2,curr_shift_swap_yn);
		pstmt_staff.setString(3,durn_for_swap_from_sos);
		pstmt_staff.setString(4,durn_for_swap_from_sos);
		pstmt_staff.setString(5,p_facility_id);
		pstmt_staff.setString(6,new_workplace_code);
		pstmt_staff.setString(7,p_role_type);
		pstmt_staff.setString(8,new_staff_id);
		pstmt_staff.setString(9,p_schedule_date);
		pstmt_staff.setString(10,locale);
		pstmt_staff.setString(11,valid_shifts_string);
		pstmt_staff.setString(12,p_facility_id);
		pstmt_staff.setString(13,new_workplace_code);
		pstmt_staff.setString(14,p_role_type);
		pstmt_staff.setString(15,new_staff_id);
		pstmt_staff.setString(16,p_schedule_date);
		pstmt_staff.setString(17,locale);
		rs_staff = pstmt_staff.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);


	String staff2_allocated_shifts_string="|";
	while( rs_staff!=null && rs_staff.next())
	{
		staff2_allocated_shifts_string +=rs_staff.getString("shift_code")+"|";
		valid_yn=rs_staff.getString("valid_yn");
		shift_code=rs_staff.getString("shift_code");
		shift_desc=rs_staff.getString("shift_desc");
		shift_mnemonic=rs_staff.getString("shift_mnemonic");
		
		if(valid_yn.equalsIgnoreCase("N")){
		out.println("<tr>");
		out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
		out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+shift_desc+"&nbsp;&nbsp;"+shift_mnemonic+"</td>");
		
		out.println("<td align='left'><INPUT TYPE='radio' disabled name='staff2_shft_code' id='staff2_shft_code' value='"+shift_code+"'' ></td>");

		out.println("</tr>");
		}
		else{
			out.println("<tr>");
			out.println("<td class='label' width='30%' align='right'>&nbsp;</td>");
			out.println("<td class='label' width='30%' align='left'>&nbsp;&nbsp;&nbsp;&nbsp;"+shift_desc+"&nbsp;&nbsp;"+shift_mnemonic+"</td>");
			
			out.println("<td align='left'><INPUT TYPE='radio'  name='staff2_shft_code' id='staff2_shft_code' value='"+shift_code+"' onClick='staff2shiftchk(this);validate();' ></td>");

			out.println("</tr>");
		}
	}
	if (pstmt_staff != null) pstmt_staff.close();
	if (rs_staff != null) rs_staff.close();

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

	String sql_reason="select reason_code,reason_desc from rs_reason where activity_type_code = 'SW' and eff_status = 'E' order by reason_desc";
	pstmt = con.prepareStatement(sql_reason);
	rs = pstmt.executeQuery();
	

            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
	
		while(rs!=null  && rs.next())
		  {
			out.println("<option value='"+rs.getString("reason_code")+"'>"+rs.getString("reason_desc")+"</option>");
		  }
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
	

            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(staff2_allocated_shifts_string));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(durn_for_swap_from_sos));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(p_facility_id));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(p_workplace_code));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(p_requirement_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(p_schedule_date));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(p_role_type));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(p_position_code));
            _bw.write(_wl_block24Bytes, _wl_block24);
	}
	catch(Exception e){out.print(e.toString());}
	finally {
		if (pstmt != null) pstmt.close();
		if (rs != null) rs.close();
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eRS.AllocatedShifts.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reason.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.defaultSelect.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
