package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __evaluatecareplanactiveplansresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/EvaluateCarePlanActivePlansResult.jsp", 1709116580075L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" type=\"text/javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n<script src=\"../../eCP/js/EvaluateCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCP/js/EvaluateCarePlanMarkError.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\'eval_cp_result\' id=\'eval_cp_result\'>\n<input type=hidden name=encounter_id value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n<input type=hidden name=facilty_id value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n<input type=hidden name=p_care_mgr_id value=\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\'>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\t<tr height=\'5px\'>\n\t\t\t\t\t\t\t\t<td align=\'center\' class=CLASSHEAD width=\'1%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\'center\' class=CLASSHEAD width=\'7%\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'23%\'>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\'right\' class=CLASSHEAD width=\'3%\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&nbsp;</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD  width=\'14%\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</td>\n\t\t\t\t\t\t\t\t<td class=CLASSHEAD width=\"15%\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'3%\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\"14%\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</td>\n\t\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'15%\' colspan=\'2\'>";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="</td>\n\t\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t\t<tr height=\'5px\'>\n\t\t\t\t\t\t\t<td align=\'center\' class=CLASSHEAD width=\'1%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'center\' class=CLASSHEAD width=\'7%\'>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'23%\'>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'2%\'>&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'right\' class=CLASSHEAD width=\'3%\'>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD  width=\'14%\'>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</td>\n\t\t\t\t\t\t\t<td class=CLASSHEAD width=\"15%\">";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'3%\'>";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\"14%\">";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'15%\' colspan=\'2\'>";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="</td>\n\t\t\t\t\t\t</tr>\n";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t<SCRIPT>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</SCRIPT>\n";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\n\t<SCRIPT>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));</SCRIPT>\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n</table>\n</form>\n</body>\n</html>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

//This file is saved on 19/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	String facilty_id = request.getParameter("facilty_id");
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");;
	String p_patient_id = request.getParameter("p_patient_id")==null?"":request.getParameter("p_patient_id");
	String p_care_mgr_id = request.getParameter("p_care_manager_id")==null?"":request.getParameter("p_care_manager_id");
	String p_t_set_id = request.getParameter("p_term_set_id")==null?"":request.getParameter("p_term_set_id");
	String p_t_code = request.getParameter("p_term_code")==null?"":request.getParameter("p_term_code");
	String view_plans = request.getParameter("view_plans")==null?"":request.getParameter("view_plans");
	String view_summary = request.getParameter("view_summary")==null?"":request.getParameter("view_summary");
	String p_fr_date = 
	request.getParameter("p_fr_date")==null?"":request.getParameter("p_fr_date");
	String p_to_date = 
	request.getParameter("p_to_date")==null?"":request.getParameter("p_to_date");
	Connection con = null;
	PreparedStatement pstmt = null;
	PreparedStatement pstmt_cnt = null;
	PreparedStatement pstmt_diag_goal = null;
	PreparedStatement pstmt_intvn = null;
	PreparedStatement pstmt_outcome = null;
	ResultSet rs = null;
	ResultSet rs_cnt = null;
	ResultSet rs_diag_goal = null;
	ResultSet rs_intvn = null;
	ResultSet rs_outcome = null;

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(facilty_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_care_mgr_id));
            _bw.write(_wl_block11Bytes, _wl_block11);

try
{
con = ConnectionManager.getConnection(request);

String tempString = "";	
String tempStrings = "";
String error_status = "";
String status_sql = "";
String eval_font = "";
String eval_title = "";
String rev_font = "";
String rev_title = "";
String task_font = "";
String task_title = "";
if(view_plans.equals("L"))
	status_sql = "(a.current_status in('O','F','C','D','9') or b.status in ('O','R','D','9'))";
else if(view_plans.equals("A"))
	status_sql = "(a.current_status = 'O' or b.status = 'O')";
// Queries
String eval_count_sql = "select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ?";
String rev_count_sql = "select count(*) from cp_pat_care_plan_revision where md_care_plan_id = ? and care_plan_id = ?";
//String sql_result = "select a.md_care_plan_id md_plan_id,a.care_plan_id plan_id, b.term_set_id term_set_id,b.term_code term_code, c.short_desc diag_desc,d.practitioner_name care_manager_name,	to_char(a.last_eval_datetime,'dd/mm/yyyy hh24:mi') last_eval_date_time,to_char(a.last_revision_date_time,'dd/mm/yyyy hh24:mi') last_revision_date_time,e.short_name eval_by_name,g.short_name rev_by_name, a.patient_id patient_id, f.patient_name pat_name, decode(f.sex,'F','Female','M','Male','U','Unknown') pat_sex,	get_age(f.date_of_birth) pat_age, to_char(a.CARE_PLAN_START_DATE,'dd/mm/yyyy hh24:mi') cp_start_date, to_char(a.CARE_PLAN_TARGET_DATE,'dd/mm/yyyy hh24:mi') cp_target_date,h.status error_status,h.eval_id,decode(sign(trunc(sysdate) - trunc(a.care_plan_start_date) ),0,1,1,(trunc(sysdate) - trunc(a.care_plan_start_date))+1) cp_day_no,a.current_status current_status FROM cp_pat_care_plan a, cp_pat_care_plan_term_code b,	mr_term_code c, am_practitioner d, am_practitioner e, mp_patient f, am_practitioner g,cp_pat_care_plan_eval h where a.patient_id = ? and a.current_facility_id = ? and (? is null or a.current_care_manager_id = ? ) and a.care_plan_start_date between nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date) and (nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date)+1)  and ( (? is null and ? is null) or ( exists (select 1 from cp_pat_care_plan_term_code  where md_care_plan_id = a.md_care_plan_id and care_plan_id = a.care_plan_id and (? is null or term_set_id = ?) and (? is null or term_code = ?) ) ) ) and b.md_care_plan_id = a.md_care_plan_id and h.md_care_plan_id(+) = a.md_care_plan_id and b.care_plan_id = a.care_plan_id and h.care_plan_id(+) = a.care_plan_id and	b.appl_yn = 'Y' and "+status_sql+" and	c.term_set_id = b.term_set_id and c.term_code = b.term_code  and	d.practitioner_id(+) = a.current_care_manager_id and e.practitioner_id(+) = a.last_eval_by and g.practitioner_id(+) = a.last_revision_pract_id and f.patient_id = a.patient_id order by patient_id, a.care_plan_id,b.term_code,h.eval_id desc";
String sql_result = "SELECT a.md_care_plan_id md_plan_id,a.care_plan_id plan_id, b.term_set_id term_set_id,b.term_code term_code, c.short_desc diag_desc,d.practitioner_name care_manager_name,	TO_CHAR(a.last_eval_datetime,'dd/mm/yyyy hh24:mi') last_eval_date_time,TO_CHAR(a.last_revision_date_time,'dd/mm/yyyy hh24:mi') last_revision_date_time,e.short_name eval_by_name,g.short_name rev_by_name, a.patient_id patient_id, f.patient_name pat_name,f.sex pat_sex,	get_age(f.date_of_birth) pat_age, TO_CHAR(a.CARE_PLAN_START_DATE,'dd/mm/yyyy hh24:mi') cp_start_date, TO_CHAR(a.CARE_PLAN_TARGET_DATE,'dd/mm/yyyy hh24:mi') cp_target_date,h.status error_status,h.eval_id,DECODE(SIGN(TRUNC(SYSDATE) - TRUNC(a.care_plan_start_date) ),0,1,1,(TRUNC(SYSDATE) - TRUNC(a.care_plan_start_date))+1) cp_day_no,a.current_status current_status FROM cp_pat_care_plan a, cp_pat_care_plan_term_code b,	mr_term_code c, am_practitioner_lang_vw d, am_practitioner_lang_vw e, mp_patient f, am_practitioner_lang_vw g,cp_pat_care_plan_eval h WHERE a.patient_id = ? AND a.current_facility_id = ? AND (? IS NULL OR a.current_care_manager_id = ? ) AND a.care_plan_start_date BETWEEN NVL(TO_DATE(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date) AND (NVL(TO_DATE(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date)+1)  AND ( (? IS NULL AND ? IS NULL) OR ( EXISTS (SELECT 1 FROM cp_pat_care_plan_term_code  WHERE md_care_plan_id = a.md_care_plan_id AND care_plan_id = a.care_plan_id AND (? IS NULL OR term_set_id = ?) AND (? IS NULL OR term_code = ?) ) ) ) AND b.md_care_plan_id = a.md_care_plan_id AND h.md_care_plan_id(+) = a.md_care_plan_id AND b.care_plan_id = a.care_plan_id AND h.care_plan_id(+) = a.care_plan_id AND	b.appl_yn = 'Y' AND "+status_sql+" AND	c.term_set_id = b.term_set_id AND c.term_code = b.term_code  AND	d.practitioner_id(+) = a.current_care_manager_id AND e.practitioner_id(+) = a.last_eval_by AND g.practitioner_id(+) = a.last_revision_pract_id AND f.patient_id = a.patient_id AND d.language_id(+) = ? AND e.language_id(+) = ?  AND g.language_id(+) = ? ORDER BY patient_id, a.care_plan_id,b.term_code,h.eval_id DESC";
// Query for Diag and Goal.
//String sql_diag_goal = "select a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no, b.short_desc||'('||a.term_set_id||')' diag_desc,a.last_progress_percent last_diag_prog_pct, c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,c.last_progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,to_char(a.target_date,'dd/mm/yyyy') diag_target_date,to_char(c.goal_target_date,'dd/mm/yyyy') goal_target_date from cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome d where a.md_care_plan_id = ? and a.care_plan_id = ? and a.appl_yn = 'Y' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.md_care_plan_id = ? and c.care_plan_id = ? and c.term_set_id = a.term_set_id and c.term_code = a.term_code and c.appl_yn = 'Y' and d.outcome_code = c.goal_code order by a.term_set_id,a.term_code,c.goal_code";
String sql_diag_goal = "SELECT a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no, b.short_desc||'('||a.term_set_id||')' diag_desc,a.last_progress_percent last_diag_prog_pct, c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,c.last_progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,TO_CHAR(a.target_date,'dd/mm/yyyy') diag_target_date,TO_CHAR(c.goal_target_date,'dd/mm/yyyy') goal_target_date FROM cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome_lang_vw d WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.appl_yn = 'Y' AND b.term_set_id = a.term_set_id AND b.term_code = a.term_code AND c.md_care_plan_id = ? AND c.care_plan_id = ? AND c.term_set_id = a.term_set_id AND c.term_code = a.term_code AND c.appl_yn = 'Y' AND d.outcome_code = c.goal_code AND d.language_id = ? ORDER BY a.term_set_id,a.term_code,c.goal_code";
// end of Diag and Goal Query.
// Query for Intervention and Outcome.
//	String sql_intvn = "select a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,decode(a.status,'O','Pending','D','Discontinued','9','Cancelled','P','Partially Completed','A','Achieved','N','Not Achieved') status from cp_pat_care_plan_intvn a, ca_intervention b where a.md_care_plan_id = ? and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code) and a.appl_yn = 'Y' and b.intervention_code = a.intervention_code order by a.term_set_id,a.term_code,a.group_id,a.intervention_code";
	String sql_intvn = "SELECT a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,a.status FROM cp_pat_care_plan_intvn a, ca_intervention_lang_vw b WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = NVL(?,a.term_set_id) AND a.term_code = NVL(?,a.term_code) AND a.goal_code = NVL(?,a.goal_code) AND a.appl_yn = 'Y' AND b.intervention_code = a.intervention_code AND b.language_id = ? ORDER BY a.term_set_id,a.term_code,a.group_id,a.intervention_code";
//	String sql_outcome = "select a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,a.last_progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome from cp_pat_care_plan_outcome a, cp_outcome b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d where a.md_care_plan_id = ?   and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code)   and a.appl_yn = 'Y' and b.outcome_code = a.outcome_code and c.md_care_plan_id = a.md_care_plan_id and c.care_plan_id = a.care_plan_id and c.term_set_id = a.term_set_id   and c.term_code = a.term_code and d.md_care_plan_id = a.md_care_plan_id and d.care_plan_id = a.care_plan_id and d.term_set_id = a.term_set_id and d.term_code = a.term_code and d.goal_code = a.goal_code order by a.term_set_id,a.term_code,a.group_id,a.outcome_code";
	String sql_outcome = "SELECT a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,a.last_progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome FROM cp_pat_care_plan_outcome a, cp_outcome_lang_vw b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d WHERE a.md_care_plan_id = ?   AND a.care_plan_id = ? AND a.term_set_id = NVL(?,a.term_set_id) AND a.term_code = NVL(?,a.term_code) AND a.goal_code = NVL(?,a.goal_code)   AND a.appl_yn = 'Y' AND b.outcome_code = a.outcome_code AND b.language_id = ? AND c.md_care_plan_id = a.md_care_plan_id AND c.care_plan_id = a.care_plan_id AND c.term_set_id = a.term_set_id   AND c.term_code = a.term_code AND d.md_care_plan_id = a.md_care_plan_id AND d.care_plan_id = a.care_plan_id AND d.term_set_id = a.term_set_id AND d.term_code = a.term_code AND d.goal_code = a.goal_code ORDER BY a.term_set_id,a.term_code,a.group_id,a.outcome_code";

	// End of Intervention and Outcome Queries.
	// End of Queries.
	pstmt=con.prepareStatement(sql_result);//,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt.setString(1,p_patient_id);
	pstmt.setString(2,facilty_id);
	pstmt.setString(3,p_care_mgr_id);
	pstmt.setString(4,p_care_mgr_id);
	pstmt.setString(5,p_fr_date);
	pstmt.setString(6,p_to_date);
	pstmt.setString(7,p_t_set_id);
	pstmt.setString(8,p_t_code);
	pstmt.setString(9,p_t_set_id);
	pstmt.setString(10,p_t_set_id);
	pstmt.setString(11,p_t_code);
	pstmt.setString(12,p_t_code);
	pstmt.setString(13,locale);
	pstmt.setString(14,locale);
	pstmt.setString(15,locale);
	rs=pstmt.executeQuery();

	String intvn_desc = "";
	String achv_pct = "";
	String notachv_pct = "";
	String achv_notachv_pct = "";
	String classvalue = "";
	String last_eval_date_time = "";
	String last_revision_date_time = "";
	String eval_by_name = "";
	String rev_by_name = "";
	String patient_id = "";
	String plan_id = "";
	String care_mgr = "";
	String eval_cnts = "";
	String rev_cnts = "";
	String term_set_id = "";
	String term_code = "";
	String goal_code = "";
	String Intvnkey = "";
	String outcomekey = "";
	String ItermSet = "";
	String ItermCode = "";
	String Igrpid = "";
	String IDesc = "";
	String Istatus = "";
	String Icode = "";
	String Icode_val = "";
	String otermSet = "";
	String otermCode = "";
	String ogrpid = "";
	String outcome_desc = "";
	String outcome_hyp = "";
	String markerror = "";
	String markerrortitle = "";
	String disp_style = "";
	String disp_font = "-";
	String disp_summary = "";
	String current_status = "";
	StringBuffer diag_percentage = new StringBuffer();
	StringBuffer goal_percentage = new StringBuffer();
	StringBuffer outcome_percentage = new StringBuffer();
	String callvar = "";
	String hand = "";
	String clr = "";
	int diag_pct = 0;
	int goal_pct = 0;
	int outcome_pct = 0;
	int i=1;
	int k=0;
	int eval_cnt=0;
	int rev_cnt=0;
	int diag_cnt = 0;
	int goal_cnt = 0;
	int outcome_cnt = 0;
	//int maxRecord=0;
	HashMap record = new HashMap();
	ArrayList result = null;
	if(view_summary.equals("S"))
	{
		disp_style = "none";
		disp_font = "&nbsp;";
	}
	int count=0;

		
	
	if(rs!=null )
	{
		while(rs.next())
		{	count++;
			care_mgr = rs.getString("care_manager_name")==null?"&nbsp":rs.getString("care_manager_name");
			last_eval_date_time = rs.getString("last_eval_date_time")==null?"&nbsp;":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date_time"),"DMYHM","en",locale);
			last_revision_date_time = rs.getString("last_revision_date_time")==null?"&nbsp;":com.ehis.util.DateUtils.convertDate(rs.getString("last_revision_date_time"),"DMYHM","en",locale);
			eval_by_name = rs.getString("eval_by_name")==null?"&nbsp;":rs.getString("eval_by_name");
			rev_by_name = rs.getString("rev_by_name")==null?"&nbsp;":rs.getString("rev_by_name");
			current_status = rs.getString("current_status");
			pstmt_cnt = con.prepareStatement(eval_count_sql);
			pstmt_cnt.setString(1,rs.getString("md_plan_id"));
			pstmt_cnt.setString(2,rs.getString("plan_id"));
			rs_cnt = pstmt_cnt.executeQuery();
			if(rs_cnt!=null)
				if(rs_cnt.next())
					eval_cnt = rs_cnt.getInt(1);
			if(rs_cnt!=null) rs_cnt.close(); 
			if(pstmt_cnt!=null) pstmt_cnt.close();
			if(eval_cnt==0)
			{
				eval_cnts = eval_cnt+"";
				eval_cnts = "&nbsp;";
				markerrortitle = "";
				markerror = "&nbsp;";
				callvar = "";
				hand = "";
				clr = "#00009D";
			}
			else
			{
				eval_cnts = eval_cnt+"";
				markerrortitle = "Mark Error";
				markerror = "X";
				callvar = "callvar";
				hand = "hand";
				clr = "blue";
			}
			error_status = rs.getString("error_status")==null?"":rs.getString("error_status");
			if(current_status.equals("O"))
			{
				eval_font = "E";
				eval_title = "Evaluate Plan";
				rev_font = "R";
				rev_title = "Revise Plan";
				task_font = "T";
				task_title = "Task List";
				if(error_status.equals("E"))
				{
					markerrortitle = "";
					markerror = "&nbsp;";
				}
			}
			else 
			{
				eval_font = "&nbsp;";
				rev_font = "&nbsp;";
				task_font = "&nbsp;";
				markerrortitle = "";
				eval_title = "";
				rev_title = "";
				markerror = "&nbsp;";
				task_title = "";
			}
			pstmt_cnt = con.prepareStatement(rev_count_sql);
			pstmt_cnt.setString(1,rs.getString("md_plan_id"));
			pstmt_cnt.setString(2,rs.getString("plan_id"));
			rs_cnt = pstmt_cnt.executeQuery();
			if(rs_cnt!=null)
				if(rs_cnt.next())
					rev_cnt = rs_cnt.getInt(1);
			if(rs_cnt!=null) rs_cnt.close(); 
			if(pstmt_cnt!=null) pstmt_cnt.close();
			if(rev_cnt==0)
			{
				rev_cnts = rev_cnt+"";
				rev_cnts = "&nbsp;";
			}
			else
				rev_cnts = rev_cnt+"";
			pstmt_diag_goal = con.prepareStatement(sql_diag_goal);
			pstmt_diag_goal.setString(1,rs.getString("md_plan_id"));
			pstmt_diag_goal.setString(2,rs.getString("plan_id"));
			pstmt_diag_goal.setString(3,rs.getString("md_plan_id"));
			pstmt_diag_goal.setString(4,rs.getString("plan_id"));
			pstmt_diag_goal.setString(5,locale);
			rs_diag_goal = pstmt_diag_goal.executeQuery();
			
			if(p_patient_id.equals(""))
			{
				if(!patient_id.equals(rs.getString("patient_id")))
				{
					i =1;
					patient_id = rs.getString("patient_id");
					String patSex=rs.getString("pat_sex");
					if(patSex.equals("F"))
						patSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.female.label","common_labels");
					if(patSex.equals("M"))
						patSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.male.label","common_labels");
					if(patSex.equals("U"))
						patSex=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.unknown.label","common_labels");
					out.println("<tr height='5px'>");
						out.println("<td class='CLASSVAL' colspan='5' align='left'>"+rs.getString("patient_id")+","+rs.getString("pat_name")+","+rs.getString("pat_age")+","+patSex+"</td>");
					out.println("</tr>");
				}
			}
			
			//out.println("<tr height='3px'>");
				if(!plan_id.equals(rs.getString("plan_id")))
				{
					if(view_summary.equals("S"))
					{
						if(!disp_summary.equals("S"))
						{

            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block20Bytes, _wl_block20);
		
							disp_summary = "S";
						}
					}
					else
					{

            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block26Bytes, _wl_block26);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block27Bytes, _wl_block27);

            if (_jsp__tag14(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag15(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);

					}
				tempString = java.net.URLEncoder.encode(care_mgr);
				plan_id = rs.getString("plan_id");
				out.println("<tr height='5px'>");
				out.println("<td align='center' class='FONTVALHYPERS' width='2%' onclick=rowcompress(this,'"+i+"')><B>"+disp_font+"</B></td>");
				out.println("<td align='center' class='FONTVALS' width='7%'>"+i+"</td>");
				out.println("<input type=hidden name='start"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' id='start"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' value='"+rs.getString("cp_start_date")+"'>");
				out.println("<input type=hidden name='target"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' id='target"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' value='"+rs.getString("cp_target_date")+"'>");
				out.println("<td width='23%' class='FONTVALS'>"+care_mgr+"</td>");
				out.println("<td width='2%' class='FONTVALS' onclick="+callvar+"('CP','"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"') title='Variance'><FONT COLOR='"+clr+"' style='cursor:"+hand+"'><B>V</B></FONT></td>");
				out.println("<td width='2%' class='FONTVALHYPERS' onclick=calltasklist(this,'"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+Icode_val+"','"+encounter_id+"') title='"+task_title+"'><B>"+task_font+"</B></td>");
				out.println("<td width='2%' class='FONTVALHYPERS' onclick=callplan('"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+tempString+"',this,'"+rs.getString("cp_day_no")+"') title='"+eval_title+"'><B>"+eval_font+"</B></td>");
				out.println("<td width='2%' class='FONTVALHYPERS' onclick=callplan('"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+tempString+"',this,'"+rs.getString("cp_day_no")+"') title='"+rev_title+"'><B>"+rev_font+"</B></td>");
				out.println("<td width='3%' align='right' class='FONTVALS'>"+rev_cnts+"&nbsp;</td>");
				out.println("<td width='15%' class='FONTVALS'>"+last_revision_date_time+"</td>");
				out.println("<td width='15%' class='FONTVALS'>"+rev_by_name+"</td>");
				out.println("<td width='3%' align='right' class='FONTVALS'>"+eval_cnts+"&nbsp;&nbsp;</td>");
				out.println("<td class='FONTVALS' width='14%'>"+last_eval_date_time+"</td>");
				out.println("<td class='FONTVALS' width='15%'>"+eval_by_name+"</td>");
				out.println("<td class='FONTVALHYPERS' width='5%' title='"+markerrortitle+"' onclick=showerror(this,'"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+rs.getString("current_status")+"','"+p_patient_id+"','"+tempString+"')><B>"+markerror+"</B></td>");
				out.println("</tr>");
				if(rs_diag_goal!=null)
				{
					diag_cnt = 0;
					out.println("<tr id='plan"+i+"' style='display:"+disp_style+"' height='5px'>");
					out.println("<td class=CLASSHEADDIAG colspan='8' align='left'>&nbsp;&nbsp;"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+"</td>");
					out.println("<td align='left' class=CLASSHEADDIAG colspan='3'><fmt:message key='eCP.TargetDate.label' bundle='${cp_labels}'/></td>");
					out.println("<td align='left' class=CLASSHEADDIAG colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
					while(rs_diag_goal.next())
					{
						if((!term_set_id.equals(rs_diag_goal.getString("termsetid")))||(!term_code.equals(rs_diag_goal.getString("termcode"))))
						{
							achv_notachv_pct = "";
							diag_percentage = new StringBuffer();
							diag_pct = Integer.parseInt(rs_diag_goal.getString("last_diag_prog_pct")==null?"104":rs_diag_goal.getString("last_diag_prog_pct"));
							for(diag_cnt = 0;diag_cnt<=100;diag_cnt+=4  )
							{
								if(diag_cnt == 0)
								{
									if(diag_cnt == diag_pct)
										achv_notachv_pct = "[";
									else
										diag_percentage.append("[");
									
								}
								else if (diag_cnt == 100)
								{
									if(diag_cnt == diag_pct)
										achv_notachv_pct = "]";
									else
										diag_percentage.append("]");
								}
								else
								{
									if (diag_cnt == diag_pct)
										diag_percentage.append("|");
									else
										diag_percentage.append("-");
								}
							}
							out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
							out.println("<td colspan='8'  class='CLASSHEADDIAGROW'><B>&nbsp;&nbsp;"+rs_diag_goal.getString("diag_desc")+"</B></td>");
							out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+rs_diag_goal.getString("diag_target_date")+"</B></td>");
							if(achv_notachv_pct.equals(""))	
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+diag_percentage.toString()+"</B></td>");
							else if(achv_notachv_pct.equals("["))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B><Font color='red'>"+achv_notachv_pct+"</Font>"+diag_percentage.toString()+"</B></td>");
							else if(achv_notachv_pct.equals("]"))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+diag_percentage.toString()+"<Font color='green'>"+achv_notachv_pct+"</Font></B></td>");
							out.println("</tr>");
							term_code = rs_diag_goal.getString("termcode");
							term_set_id = rs_diag_goal.getString("termsetid");
							goal_code = "";
						}
						if(!goal_code.equals(rs_diag_goal.getString("goalcode")))
						{
							achv_notachv_pct = "";
							achv_pct = "";
							notachv_pct = "";
							goal_percentage = new StringBuffer();
							goal_pct = Integer.parseInt(rs_diag_goal.getString("last_goal_prog_pct")==null?"104":rs_diag_goal.getString("last_goal_prog_pct"));
							for(goal_cnt = 0;goal_cnt<=100;goal_cnt+=4  )
							{
								if(goal_cnt == 0)
								{
									if(goal_cnt == goal_pct)
									{
										notachv_pct = "[";
										achv_notachv_pct = "notachv_pct";
									}
									else
										notachv_pct = "[";
								}
								else if (goal_cnt == 100)
								{
									if(goal_cnt == goal_pct)
									{
										achv_pct = "]";
										achv_notachv_pct = "achv_pct";
									}
									else
										achv_pct = "]";
								}
								else
								{
									if (goal_cnt == goal_pct)
										goal_percentage.append("|");
									else
										goal_percentage.append("-");
								}
							}
							goal_code = rs_diag_goal.getString("goalcode");
							classvalue = "";
							outcome_hyp = "";
							out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
							out.println("<td class='CLASSHEADDIAGROW' colspan='8' >&nbsp;&nbsp;"+rs_diag_goal.getString("goal_desc")+"</td>");
							out.println("<td colspan='3' class='CLASSHEADDIAGROW'>"+rs_diag_goal.getString("goal_target_date")+"</td>");
							if(achv_notachv_pct.equals(""))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+notachv_pct+"</B>"+goal_percentage.toString()+"<B>"+achv_pct+"</B></td>");
							else if (achv_notachv_pct.equals("notachv_pct"))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><Font color='red'><B>"+notachv_pct+"</B></Font>"+goal_percentage.toString()+"<B>"+achv_pct+"</B></td>");
							else if(achv_notachv_pct.equals("achv_pct"))
								out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+notachv_pct+"</B>"+goal_percentage.toString()+"<Font color='green'><B>"+achv_pct+"</B></Font></td>");
							out.println("</tr>");
							
							pstmt_intvn = con.prepareStatement(sql_intvn);
							pstmt_intvn.setString(1,rs.getString("md_plan_id"));
							pstmt_intvn.setString(2,rs.getString("plan_id"));
							pstmt_intvn.setString(3,term_set_id);
							pstmt_intvn.setString(4,term_code);
							pstmt_intvn.setString(5,goal_code);
							pstmt_intvn.setString(6,locale);
							rs_intvn = pstmt_intvn.executeQuery();
							//out.println("=md_plan_id="+rs.getString("md_plan_id")+"=plan_id="+rs.getString("plan_id")+"=term_code="+term_code+"=goal_code="+goal_code);
							if(rs_intvn!=null)
							{
								out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
								out.println("<td class='ITRVNHDR' colspan='1'>&nbsp;</td>");
								out.println("<td class='ITRVNHDR' colspan='5'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Interventions.label","cp_labels")+"</td>");
								out.println("<td class='ITRVNHDR' colspan='2' align='left'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
								out.println("<td class='ITRVNHDR' colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.outcome.label","common_labels")+"</td>");
								out.println("<td class='ITRVNHDR' colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels")+"</td>");
								out.println("</tr>");
								result = new ArrayList();
								record = new HashMap();
								while(rs_intvn.next())
								{
									ItermSet=rs_intvn.getString("term_set_id");
									ItermCode=rs_intvn.getString("term_code");
									Igrpid=rs_intvn.getString("group_id_intvn");
									IDesc=rs_intvn.getString("intvn_desc");
									Istatus=rs_intvn.getString("status");
							
									if(Istatus.equals("O")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");	
									if(Istatus.equals("D")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
									if(Istatus.equals("9")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");	
									if(Istatus.equals("P")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartiallyCompleted.label","common_labels");
									if(Istatus.equals("A")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Achieved.label","cp_labels");
									if(Istatus.equals("N")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.NotAchieved.label","cp_labels");
									if(Istatus.equals("C")) Istatus=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
									Icode=rs_intvn.getString("intervention_code");
									Intvnkey = ItermSet+ItermCode+Igrpid;
									if(record.containsKey(Intvnkey))
									{
										result=(ArrayList)record.get(Intvnkey);
										result.add(IDesc);
										result.add(Istatus);
										result.add(Icode);
										for(int l=0;l<2;l++)
										{
											result.add("");
										}
									}
									else
									{
										result=new ArrayList();
										result.add(IDesc);
										result.add(Istatus);
										result.add(Icode);
										for(int l=0;l<2;l++)
										{
											result.add("");
										}
										record.put(Intvnkey,result);
									}
								}
							}

							rs_intvn.close();
							pstmt_intvn.close();

							pstmt_outcome = con.prepareStatement(sql_outcome);
							pstmt_outcome.setString(1,rs.getString("md_plan_id"));
							pstmt_outcome.setString(2,rs.getString("plan_id"));
							pstmt_outcome.setString(3,term_set_id);
							pstmt_outcome.setString(4,term_code);
							pstmt_outcome.setString(5,goal_code);
							pstmt_outcome.setString(6,locale);
							rs_outcome = pstmt_outcome.executeQuery();
							if(rs_outcome!=null)
							{
								while(rs_outcome.next())
								{
									otermSet=rs_outcome.getString("term_set_id");
									otermCode=rs_outcome.getString("term_code");
									ogrpid=rs_outcome.getString("group_id_outcome");
									outcomekey=otermSet+otermCode+ogrpid;
									if(record.containsKey(outcomekey))
									{	
										k=0;
										result=(ArrayList)record.get(outcomekey);
										for(int j=0;j<result.size();j=j+5)
										{
											tempStrings = (String)result.get(j+3);
											if(!tempStrings.equals(""))
											{
												k=k+5;
											}
											else
											{	
												
												break;
											}
										}
										if(k<result.size())
										{
											result.set(k+3,rs_outcome.getString("outcome_desc"));
											result.set(k+4,rs_outcome.getString("outcome_prog_pct")==null?"104":rs_outcome.getString("outcome_prog_pct"));	
										}
										else
										{
											result.add("");
											result.add("");
											result.add("");
											result.add(rs_outcome.getString("outcome_desc"));
											result.add(rs_outcome.getString("outcome_prog_pct")==null?"104":rs_outcome.getString("outcome_prog_pct"));	
										}
									}		
								}
							}

							rs_outcome.close();
							pstmt_outcome.close();
							Set itr_set	= record.keySet();
							Iterator recordItr = itr_set.iterator();
							while(recordItr.hasNext())
							{
								if(classvalue.equals("CLASSINTVNOUTCOMEODD"))
								{
									classvalue="CLASSINTVNOUTCOMEEVEN";
									outcome_hyp = "CLASSINTVNOUTCOMEEVENHYP";
								}
								else
								{
									classvalue="CLASSINTVNOUTCOMEODD";
									outcome_hyp="CLASSINTVNOUTCOMEODDHYP";
								}
								outcomekey="";
								outcomekey=(String)recordItr.next();
								result=(ArrayList)record.get(outcomekey);
								for(int m=0;m<result.size();m+=5)
								{
									intvn_desc = (String)result.get(m)==null?"":(String)result.get(m);
									outcome_desc = (String)result.get(m+3)==null?"":(String)result.get(m+3);
									Icode_val = (String)result.get(m+2);
									out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
									if(intvn_desc.equals(""))
										out.println("<td colspan='1' align='right' class='"+outcome_hyp+"'>&nbsp;</td>");
									else
										out.println("<td colspan='1' align='right' class='"+outcome_hyp+"' onclick=calltasklist(this,'"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+p_patient_id+"','"+Icode_val+"','"+encounter_id+"')>+</td>");
									out.println("<td td colspan='5' class='"+classvalue+"'>&nbsp;"+result.get(m)+"</td>");
									out.println("<td colspan='2' class='"+classvalue+"'>&nbsp;"+result.get(m+1)+"&nbsp;</td>");
									out.println("<td colspan='3' class='"+classvalue+"'>"+result.get(m+3)+"</td>");
									if(!outcome_desc.equals(""))
									{
										achv_notachv_pct = "";
										achv_pct = "";
										notachv_pct = "";
										outcome_percentage = new StringBuffer();
										outcome_pct = Integer.parseInt((String)result.get(m+4));
										for(outcome_cnt = 0;outcome_cnt<=100;outcome_cnt+=4  )
										{
											if(outcome_cnt == 0)
											{
												if(outcome_cnt == outcome_pct)
												{
													notachv_pct = "[";
													achv_notachv_pct = "notachv_pct";
												}
												else
													notachv_pct = "[";
											}
											else if (outcome_cnt == 100)
											{
												if(outcome_cnt == outcome_pct)
												{
													achv_pct = "]";
													achv_notachv_pct = "achv_pct";
												}
												else
													achv_pct = "]";
											}
											else
											{
												if (outcome_cnt == outcome_pct)
													outcome_percentage.append("|");
												else
													outcome_percentage.append("-");
											}
										}
										if(achv_notachv_pct.equals(""))
											out.println("<td  colspan='3' class='"+classvalue+"'><B>"+notachv_pct+"</B>"+outcome_percentage.toString()+"<B>"+achv_pct+"</B></td>");
										else if(achv_notachv_pct.equals("notachv_pct"))
											out.println("<td  colspan='3' class='"+classvalue+"'><Font color='red'><B>"+notachv_pct+"</B></font>"+outcome_percentage.toString()+"<B>"+achv_pct+"</B></td>");
										else if(achv_notachv_pct.equals("achv_pct"))
											out.println("<td  colspan='3' class='"+classvalue+"'><B>"+notachv_pct+"</B>"+outcome_percentage.toString()+"<Font color='green'><B>"+achv_pct+"</B></font></td>");
									}
									else
										out.println("<td  colspan='3' class='"+classvalue+"'>&nbsp;</td>");
								}
							}
						}
					}
				}
				i++;
				rs_diag_goal.close();
			    pstmt_diag_goal.close();
			}
			/*else
			{
				out.println("<td colspan='2'>&nbsp;</td>");
				out.println("<td width='3%' class='FONTVALS'>"+rev_cnts+"</td>");
				out.println("<td width='13%' class='FONTVALS'>"+last_revision_date_time+"</td>");
				out.println("<td width='15%' class='FONTVALS'>"+rev_by_name+"</td>");
				out.println("<td width='3%' class='FONTVALS'>"+eval_cnts+"</td>");
				out.println("<td class='FONTVALS' width='13%'>"+last_eval_date_time+"</td>");
				out.println("<td class='FONTVALS' width='15%'>"+eval_by_name+"</td>");
			}*/
			//out.println("</tr>");
		}
		if(count == 0){ 
            _bw.write(_wl_block30Bytes, _wl_block30);
		}

	}else{
		//System.err.println("inside else");
	
            _bw.write(_wl_block31Bytes, _wl_block31);

	}
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
}
catch(Exception e)
{
	System.err.println(e.toString());
		e.printStackTrace();
}
finally
{
	try
	{
	if(rs!=null) rs.close();
	if(rs_diag_goal!=null)rs_diag_goal.close();
	if(rs_intvn!=null) rs_intvn.close();
	if(pstmt_intvn!=null) pstmt_intvn.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt_diag_goal!=null)pstmt_diag_goal.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.PlanNo.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.CareManager.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.R.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LastRevision.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.revisedby.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.E.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LastEvaluation.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.EvaluatedBy.label", java.lang.String .class,"key"));
        __tag7.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.PlanNo.label", java.lang.String .class,"key"));
        __tag8.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag9(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag9 = null ;
        int __result__tag9 = 0 ;

        if (__tag9 == null ){
            __tag9 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag9);
        }
        __tag9.setPageContext(pageContext);
        __tag9.setParent(null);
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.CareManager.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag9;
        __result__tag9 = __tag9.doStartTag();

        if (__result__tag9!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag9== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag9.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag9);
            return true;
        }
        _activeTag=__tag9.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag9);
        __tag9.release();
        return false;
    }

    private boolean _jsp__tag10(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag10 = null ;
        int __result__tag10 = 0 ;

        if (__tag10 == null ){
            __tag10 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag10);
        }
        __tag10.setPageContext(pageContext);
        __tag10.setParent(null);
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.R.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag10;
        __result__tag10 = __tag10.doStartTag();

        if (__result__tag10!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag10== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag10.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag10);
            return true;
        }
        _activeTag=__tag10.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag10);
        __tag10.release();
        return false;
    }

    private boolean _jsp__tag11(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag11 = null ;
        int __result__tag11 = 0 ;

        if (__tag11 == null ){
            __tag11 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag11);
        }
        __tag11.setPageContext(pageContext);
        __tag11.setParent(null);
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LastRevision.label", java.lang.String .class,"key"));
        __tag11.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag11;
        __result__tag11 = __tag11.doStartTag();

        if (__result__tag11!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag11== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag11.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag11);
            return true;
        }
        _activeTag=__tag11.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag11);
        __tag11.release();
        return false;
    }

    private boolean _jsp__tag12(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag12 = null ;
        int __result__tag12 = 0 ;

        if (__tag12 == null ){
            __tag12 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag12);
        }
        __tag12.setPageContext(pageContext);
        __tag12.setParent(null);
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.revisedby.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag12;
        __result__tag12 = __tag12.doStartTag();

        if (__result__tag12!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag12== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag12.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag12);
            return true;
        }
        _activeTag=__tag12.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag12);
        __tag12.release();
        return false;
    }

    private boolean _jsp__tag13(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag13 = null ;
        int __result__tag13 = 0 ;

        if (__tag13 == null ){
            __tag13 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag13);
        }
        __tag13.setPageContext(pageContext);
        __tag13.setParent(null);
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.E.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag13;
        __result__tag13 = __tag13.doStartTag();

        if (__result__tag13!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag13== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag13.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag13);
            return true;
        }
        _activeTag=__tag13.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag13);
        __tag13.release();
        return false;
    }

    private boolean _jsp__tag14(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag14 = null ;
        int __result__tag14 = 0 ;

        if (__tag14 == null ){
            __tag14 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag14);
        }
        __tag14.setPageContext(pageContext);
        __tag14.setParent(null);
        __tag14.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.LastEvaluation.label", java.lang.String .class,"key"));
        __tag14.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag14;
        __result__tag14 = __tag14.doStartTag();

        if (__result__tag14!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag14== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag14.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag14);
            return true;
        }
        _activeTag=__tag14.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag14);
        __tag14.release();
        return false;
    }

    private boolean _jsp__tag15(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag15 = null ;
        int __result__tag15 = 0 ;

        if (__tag15 == null ){
            __tag15 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag15);
        }
        __tag15.setPageContext(pageContext);
        __tag15.setParent(null);
        __tag15.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.EvaluatedBy.label", java.lang.String .class,"key"));
        __tag15.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag15;
        __result__tag15 = __tag15.doStartTag();

        if (__result__tag15!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag15== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag15.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag15);
            return true;
        }
        _activeTag=__tag15.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag15);
        __tag15.release();
        return false;
    }
}
