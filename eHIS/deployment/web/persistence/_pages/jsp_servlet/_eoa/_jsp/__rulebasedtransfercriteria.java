package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;

public final class __rulebasedtransfercriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/RuleBasedTransferCriteria.jsp", 1709119271428L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="   \n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/CommonCalendar.css\'></link>\n<script src=\"../../eCommon/js/CommonCalendar.js\" language=\"JavaScript\"></script>\n<script language=\'javascript\' src=\"../../eOA/js/RuleBasedSchAppointment.js\"></script>\n<script src=\"../../eCommon/js/DateUtils.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n<script>\n</script>\n</head>\n<body  OnMouseDown=\"CodeArrest()\" onKeyDown = \'lockKey()\' >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<form name=\'RuleBasedTransfer_criteria\' id=\'RuleBasedTransfer_criteria\'>\n<br/>\n<table  border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'50%\' align=\'center\'>\n<tr>\n<td class=\'label\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n<td class=\'querydata\'><select name=\'specialty\' id=\'specialty\' tabindex=0 onchange = \'specialtyChange()\'><option value=\'\'>----- ";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" -----\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' selected>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</td>\n</tr>\n<tr>\n<td nowrap class=label >";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n<td class=\'fields\'>\n\t<select name=\'locn_type\' id=\'locn_type\' onchange=\'locnChange()\' nowrap disabled>\n\t\t<option value=\'\'>------ ";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =" -----</option>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t<option value=\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\' selected >";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t</select>\n</td>\n</tr>\n<tr>\n<td class=\"label\">";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n<td class=\'fields\'><input type=\'text\' size=\'25\' maxlength=\'25\' name=\'b_loc_val\' id=\'b_loc_val\' value=\'";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\' onblur=\"ena_loc_lookup_rule(this);\"><input type=\"hidden\" name=\"clinic\" id=\"clinic\" value=\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\' ><input type=\'button\' name=\"b_loc_search\" id=\"b_loc_search\" value=\"?\" onClick=\"open_loc_lookup_rule();\" class=\'button\'></td>\n</tr>\n<tr>\n<td class=\'label\'>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n<td class=\'fields\'><input type=\'text\' name=\'pref_date\' id=\'pref_date\' size=\'10\' maxlength=\'10\' value=\'\' onBlur=\"validDateObj(this,\'DMY\',localeName);checkDateAlert(this);\"><img id=\'frm_img\' style=\"cursor:pointer\" src=\"../../eCommon/images/CommonCalendar.gif\" onClick=\"return showCalendar(\'pref_date\');\">&nbsp;<input type=\'text\' name=\'From_timeval\' id=\'From_timeval\' value=\'\' size=\'3\' maxlength=\'5\' onBlur=\'CheckTime(this,\"FM\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\" > - <input type=\'text\' name=\'To_timeval\' id=\'To_timeval\' size=\'3\' maxlength=\'5\'  value=\'\' onBlur=\'CheckTime(this,\"TO\")\' onKeyUp=\"javascript:formatTimePerPatient(this)\"><img src=\'../../eCommon/images/mandatory.gif\' align=\'center\'></img></span>\n</td>\n</tr>\n</table>\n<br/>\n<table  border=\'0\' cellpadding=\'0\' cellspacing=\'0\' width=\'50%\' align=\'center\'>\n<tr>\n<td align=\'center\' class=\'button\'><input type=\'button\' name=\'search\' id=\'search\' class=\'button\' value=\'";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\' onclick=\'getRuleBasedResult()\'>&nbsp;<input type=\'button\' name=\'clear\' id=\'clear\' class=\'button\' value=\'";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\' onclick=\'clearFields()\'></td>\n<tr>\n</table>\n<input type=\'hidden\' name=\'speciality_code\' id=\'speciality_code\' value=\'";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\'>\n<input type=\'hidden\' name=\'practitioner_name\' id=\'practitioner_name\' value=\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\'>\n<input type=\'hidden\' name=\'clinic_name\' id=\'clinic_name\' value=\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\'>\n<input type=\'hidden\' name=\'tfr_appt_across_catg_yn\' id=\'tfr_appt_across_catg_yn\' value=\'";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\'>\n<input type=\'hidden\' name=\'apptrefno\' id=\'apptrefno\' value=\'";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\'>\n<input type=\'hidden\' name=\'cliniccode\' id=\'cliniccode\' value=\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\'>\n<input type=\'hidden\' name=\'practitionerid\' id=\'practitionerid\' value=\'";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\'>\n<input type=\'hidden\' name=\'apptdate\' id=\'apptdate\' value=\'";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\'>\n<input type=\'hidden\' name=\'overbookedyn\' id=\'overbookedyn\' value=\'";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\'>\n<input type=\'hidden\' name=\'apptslabfromtime\' id=\'apptslabfromtime\' value=\'";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\'>\n<input type=\'hidden\' name=\'apptslabtotime\' id=\'apptslabtotime\' value=\'";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\'>\n<input type=\'hidden\' name=\'appt_day\' id=\'appt_day\' value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=\'hidden\' name=\'visit_type_ind\' id=\'visit_type_ind\' value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=\'hidden\' name=\'team_id\' id=\'team_id\' value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n<input type=\'hidden\' name=\'forced\' id=\'forced\' value=\'";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\'>\n<input type=\'hidden\' name=\'rsClass\' id=\'rsClass\' value=\'";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\'>\n<input type=\'hidden\' name=\'locnType\' id=\'locnType\' value=\'";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\'>\n<input type=\'hidden\' name=\'no_of_slots_value\' id=\'no_of_slots_value\' value=\'";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\'>\n<input type=\'hidden\' name=\'patient_id\' id=\'patient_id\' value=\'";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\'>\n<input type=\'hidden\' name=\'time_table_type\' id=\'time_table_type\' value=\'";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\'>\n<input type=\'hidden\' name=\'term_set_id\' id=\'term_set_id\' value=\'";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\'>\n<input type=\'hidden\' name=\'linking_code\' id=\'linking_code\' value=\'";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\'>\n<input type=\'hidden\' name=\'language_code\' id=\'language_code\' value=\'";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\'>\n<input type=\'hidden\' name=\'sys_date\' id=\'sys_date\' value=\'";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );

    private final static java.lang.String  _wl_block52 ="\'>\n<input type=\'hidden\' name=\'order_catalog_code\' id=\'order_catalog_code\' value=\'";
    private final static byte[]  _wl_block52Bytes = _getBytes( _wl_block52 );

    private final static java.lang.String  _wl_block53 ="\'>\n\n</form>\n</body>\n\t";
    private final static byte[]  _wl_block53Bytes = _getBytes( _wl_block53 );

    private final static java.lang.String  _wl_block54 ="\n</html>\n\n";
    private final static byte[]  _wl_block54Bytes = _getBytes( _wl_block54 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");		
		String speciality_code="";		
		String practitioner_name=request.getParameter("practitioner_name")==null?"":request.getParameter("practitioner_name");		
		String clinic_name="";		
		String tfr_appt_across_catg_yn=request.getParameter("tfr_appt_across_catg_yn")==null?"":request.getParameter("tfr_appt_across_catg_yn");	
		String apptrefno=request.getParameter("apptrefno")==null?"":request.getParameter("apptrefno");		
		String cliniccode1="";		
		String practitionerid="";		
		String apptdate="";		
		String overbookedyn=request.getParameter("overbookedyn")==null?"":request.getParameter("overbookedyn");		
		String apptslabfromtime=request.getParameter("apptslabfromtime")==null?"":request.getParameter("apptslabfromtime");		
		String apptslabtotime=request.getParameter("apptslabtotime")==null?"":request.getParameter("apptslabtotime");		
		String appt_day1=request.getParameter("appt_day1")==null?"":request.getParameter("appt_day1");		
		String visit_type_ind=request.getParameter("visit_type_ind")==null?"":request.getParameter("visit_type_ind");		
		String team_id="";		
		String forced=request.getParameter("forced")==null?"":request.getParameter("forced");		
		String rsClass="";		
		String locnType="";		
		int no_of_slots_value=0;		
		String patient_id="";		
		String old_visit_type_ind="";
		String time_table_type="";
		String term_set_id ="";
		String linking_code = "";
		String language_code = "";
		Connection con=null;
		PreparedStatement pstmt =null;
		ResultSet rs=null;	 
		String splty_short_desc ="";
		String splty_code ="";
		//out.println("apptrefno :"+apptrefno);	
		String sys_date="";
		String order_catalog_code ="";
			
		try{
			Properties p =(Properties)session.getValue("jdbc");
			con=ConnectionManager.getConnection(request);
			String facilityid =(String)session.getValue("facility_id");
			String login_user = (String)p.getProperty("login_user");
			//out.println("facilityid :"+facilityid);	
			String sql="select a.speciality_code,a.CARE_LOCN_TYPE_IND,a.CLINIC_CODE,OP_GET_DESC.OP_CLINIC(a.FACILITY_ID, a.CLINIC_CODE,?,'1') clinic_name,a.PRACTITIONER_ID,TO_CHAR (a.appt_date, 'dd/mm/rrrr') appt_date,a.RESOURCE_CLASS,a.patient_id,b.visit_type_ind,a.no_of_slots,a.time_table_type,a.TERM_SET_ID,a.TERM_CODE,a.LANGUAGE_ID,a.TEAM_ID,TO_CHAR (sysdate, 'dd/mm/rrrr')sys_date,ORDER_CATALOG_CODE from oa_appt a, op_visit_type b where a.facility_id = ? and a.appt_ref_no=? and b.facility_id = a.facility_id and b.visit_type_code = a.appt_type_code ";
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,localeName);
			pstmt.setString(2,facilityid);
			pstmt.setString(3,apptrefno);
			rs = pstmt.executeQuery();
			while (rs !=null && rs.next()){
				speciality_code	 = rs.getString("speciality_code")==null?"":rs.getString("speciality_code");
				locnType 			= rs.getString("CARE_LOCN_TYPE_IND")==null?"":rs.getString("CARE_LOCN_TYPE_IND");
				cliniccode1 		= rs.getString("CLINIC_CODE")==null?"":rs.getString("CLINIC_CODE");
				clinic_name 		= rs.getString("clinic_name")==null?"":rs.getString("clinic_name");
				practitionerid 		= rs.getString("PRACTITIONER_ID")==null?"":rs.getString("PRACTITIONER_ID");
				apptdate	 		= rs.getString("appt_date")==null?"":rs.getString("appt_date");
				rsClass		 		= rs.getString("RESOURCE_CLASS")==null?"":rs.getString("RESOURCE_CLASS");
				old_visit_type_ind 	= rs.getString("visit_type_ind");
				no_of_slots_value	= rs.getInt("no_of_slots");
				patient_id			= rs.getString("patient_id")==null?"":rs.getString("patient_id");
				time_table_type 	= rs.getString("time_table_type")==null?"":rs.getString("time_table_type");
				term_set_id 		= rs.getString("TERM_SET_ID")==null?"":rs.getString("TERM_SET_ID");
				linking_code 		= rs.getString("TERM_CODE")==null?"":rs.getString("TERM_CODE");
				language_code 		= rs.getString("LANGUAGE_ID")==null?"":rs.getString("LANGUAGE_ID");
				team_id				= rs.getString("TEAM_ID")==null?"":rs.getString("TEAM_ID");
				sys_date			= rs.getString("sys_date")==null?"":rs.getString("sys_date");
				sys_date			= (DateUtils.convertDate(sys_date,"DMY","en",localeName));			
				order_catalog_code	= rs.getString("ORDER_CATALOG_CODE")==null?"":rs.getString("ORDER_CATALOG_CODE");				
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
			//String  sql3="Select clinic_code from op_clinic a, am_locn_for_oper_stn b where  a.facility_id=? and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E'";
			String specialtySQL="Select distinct c.speciality_code,am_get_desc.AM_SPECIALITY(c.speciality_code,?,2) short_desc from op_clinic a, am_locn_for_oper_stn b,am_speciality c where  a.facility_id=? and a.facility_id=b.facility_id and a.clinic_code=b.locn_code and a.allow_appt_yn ='Y' and a.level_of_care_ind = 'A' and a.eff_status='E' and b.oper_stn_id =(SELECT a.oper_stn_id FROM am_oper_stn a, am_user_for_oper_stn b WHERE a.facility_id=? AND a.facility_id=b.Facility_id AND a.oper_stn_id = b.oper_stn_id AND b. appl_user_id =? AND trunc(sysdate) between b.eff_date_from and nvl(b.eff_date_to,trunc(sysdate))) and b.eff_status='E' and a.speciality_code = c.speciality_code and c.EFF_STATUS = 'E' order by short_desc";			

			

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

	pstmt=con.prepareStatement(specialtySQL);
	pstmt.setString(1,localeName);
	pstmt.setString(2,facilityid);
	pstmt.setString(3,facilityid);
	pstmt.setString(4,login_user);
	rs = pstmt.executeQuery();
	while (rs !=null && rs.next()){
		splty_short_desc=rs.getString("short_desc");
		splty_code=rs.getString("speciality_code");
		if(speciality_code.equals(splty_code)){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(splty_short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(splty_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(splty_short_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
	}

            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

			if(pstmt!=null)	pstmt.close();
			if(rs!=null)	rs.close();
			pstmt=con.prepareStatement("select locn_type, am_get_desc.am_care_locn_type(locn_type,?,2) short_desc, CARE_LOCN_TYPE_IND from am_care_locn_type where SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y') order by short_desc");
			pstmt.setString(1,localeName);
			rs=pstmt.executeQuery();
			while(rs!=null && rs.next()) {
				if(locnType.equals(rs.getString("CARE_LOCN_TYPE_IND"))){
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("CARE_LOCN_TYPE_IND")));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}else{
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(rs.getString("CARE_LOCN_TYPE_IND")));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(rs.getString("short_desc")));
            _bw.write(_wl_block21Bytes, _wl_block21);
}
			}
		
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(cliniccode1));
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(speciality_code));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(practitioner_name));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(clinic_name));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(tfr_appt_across_catg_yn));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(apptrefno));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(cliniccode1));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(practitionerid));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(apptdate));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(overbookedyn));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(apptslabfromtime));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(apptslabtotime));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(appt_day1));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(old_visit_type_ind));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(team_id));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(forced));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(rsClass));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(locnType));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(no_of_slots_value));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(time_table_type));
            _bw.write(_wl_block48Bytes, _wl_block48);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(linking_code));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(language_code));
            _bw.write(_wl_block51Bytes, _wl_block51);
            out.print( String.valueOf(sys_date));
            _bw.write(_wl_block52Bytes, _wl_block52);
            out.print( String.valueOf(order_catalog_code));
            _bw.write(_wl_block53Bytes, _wl_block53);
}catch(Exception e ){
		e.printStackTrace();
	}finally{	
		ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block54Bytes, _wl_block54);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.speciality.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.locationtype.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Location.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.PreferredDate.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.search.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.clear.label", java.lang.String .class,"key"));
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
}
