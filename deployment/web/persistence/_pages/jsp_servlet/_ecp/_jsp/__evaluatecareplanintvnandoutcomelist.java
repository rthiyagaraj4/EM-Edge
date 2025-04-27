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
import java.util.*;
import com.ehis.util.*;

public final class __evaluatecareplanintvnandoutcomelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/EvaluateCarePlanIntvnAndOutcomeList.jsp", 1709116582309L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"JavaScript\" src=\"../../eCP/js/common.js\" ></script>\n<script language=\"JavaScript\"src=\"../../eCommon/js/ValidateControl.js\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCP/js/EvaluateCarePlan.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\'eval_cp_intvnandoutcomelist\' id=\'eval_cp_intvnandoutcomelist\'>\n<table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\" align=\'center\' id=\"outcometable\" >\n\t<tr>\n\t\t<td class=\'ITRVNHDR\' width=\'39%\' align=\'left\'><B>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'15%\' align=\'left\'><B>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'30%\' align=\'left\'><B>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</B></th>\n\t\t<td class=\'ITRVNHDR\' colspan=\'30\' nowrap align=\'left\'><B>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</B></th>\n\t<td class=\'ITRVNHDR\' width=\'5%\' nowrap align=\'left\'></td>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t<td class=\'ITRVNHDR\' width=\'*%\' align=\'right\'><B>";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</B></td>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<td class=\'ITRVNHDR\' width=\'*%\' align=\'right\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t</tr>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t<TR>\n\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</TD>\n\t\t\t\t<TD class=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =">";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</TD>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\" title=\"Outcome Measure\" ><INPUT TYPE=\"button\" ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 =" class=\"button\" value=\"?\" onclick=\"showMsr(\'Outcome\',\'";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\',\'";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\')\"></TD>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t</TR>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\n</table>\n";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\n</table>\n<INPUT TYPE=\"hidden\" name=\"outcome_count\" id=\"outcome_count\" value=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n<INPUT TYPE=\"hidden\" name=\"locale\" id=\"locale\" value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

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

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con = null;
PreparedStatement stmt_intvn = null;
ResultSet rs_intvn = null;
PreparedStatement stmt_outcome = null;
ResultSet  rs_outcome = null;
Statement stmt_outcome_msr_id = null;
ResultSet  rs_outcome_msr_id = null;
String care_plan_id = request.getParameter("planid");
String md_plan_id = request.getParameter("md_plan_id");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");;
String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");;
String goal_code = request.getParameter("goal_code")==null?"":request.getParameter("goal_code");
String evaluation_allowed_yn = "";
String onclickwork_outcome = "";
String onclickchgcolorfr = "";
String onclickchgcolorbac = "";
int outcome_count = 1;
String classvalue="ROWODD";
String sql_outcome = "";
String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
String eval_id = request.getParameter("eval_id")==null?"":request.getParameter("eval_id");
String msrlookupdisabled="";
//System.err.println("mode ********* "+mode);
try
{
	con = ConnectionManager.getConnection(request);
	//String sql_intvn = "select a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,decode(a.status,'O','Pending','D','Discontinued','9','Cancelled','P','Partially Completed','A','Achieved','N','Not Achieved') status from cp_pat_care_plan_intvn a, ca_intervention b where a.md_care_plan_id = ? and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code) and a.appl_yn = 'Y' and b.intervention_code = a.intervention_code order by a.term_set_id,a.term_code,a.group_id,a.intervention_code";
	String sql_intvn = "SELECT a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit, a.status FROM cp_pat_care_plan_intvn a, ca_intervention_lang_Vw b WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = NVL(?,a.term_set_id) AND a.term_code = NVL(?,a.term_code) AND a.goal_code = NVL(?,a.goal_code) AND a.appl_yn = 'Y' AND b.intervention_code = a.intervention_code AND b.language_id = ? ORDER BY a.term_set_id,a.term_code,a.group_id,a.intervention_code";
	if(mode.equals(""))
//		sql_outcome = "select a.LAST_EVAL_OUTCOME_MSR_ID,a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,a.last_progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome from cp_pat_care_plan_outcome a, cp_outcome b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d where a.md_care_plan_id = ?  and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code)   and a.appl_yn = 'Y' and b.outcome_code = a.outcome_code and c.md_care_plan_id = a.md_care_plan_id and c.care_plan_id = a.care_plan_id and c.term_set_id = a.term_set_id   and c.term_code = a.term_code and d.md_care_plan_id = a.md_care_plan_id and d.care_plan_id = a.care_plan_id and d.term_set_id = a.term_set_id and d.term_code = a.term_code and d.goal_code = a.goal_code order by a.term_set_id,a.term_code,a.group_id,a.outcome_code";
		sql_outcome = "SELECT a.LAST_EVAL_OUTCOME_MSR_ID,a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,a.last_progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome FROM cp_pat_care_plan_outcome a, cp_outcome_lang_vw b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d WHERE a.md_care_plan_id = ?  AND a.care_plan_id = ? AND a.term_set_id = NVL(?,a.term_set_id) AND a.term_code = NVL(?,a.term_code) AND a.goal_code = NVL(?,a.goal_code)   AND a.appl_yn = 'Y' AND b.outcome_code = a.outcome_code AND c.md_care_plan_id = a.md_care_plan_id AND c.care_plan_id = a.care_plan_id AND c.term_set_id = a.term_set_id   AND c.term_code = a.term_code AND d.md_care_plan_id = a.md_care_plan_id AND d.care_plan_id = a.care_plan_id AND d.term_set_id = a.term_set_id AND d.term_code = a.term_code AND d.goal_code = a.goal_code AND b.language_id = ? ORDER BY a.term_set_id,a.term_code,a.group_id,a.outcome_code";
	else
//		sql_outcome = "select a.LAST_EVAL_OUTCOME_MSR_ID,a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,e.progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome from cp_pat_care_plan_outcome a, cp_outcome b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d,cp_pat_outcome_eval e,CP_OUTCOME_MSR f where a.md_care_plan_id = ?  and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code)   and a.appl_yn = 'Y' and b.outcome_code = a.outcome_code and c.md_care_plan_id = a.md_care_plan_id and c.care_plan_id = a.care_plan_id and c.term_set_id = a.term_set_id   and c.term_code = a.term_code and b.outcome_code = e.outcome_code and d.md_care_plan_id = a.md_care_plan_id and d.care_plan_id = a.care_plan_id and d.term_set_id = a.term_set_id and d.term_code = a.term_code and d.goal_code = a.goal_code and e.md_care_plan_id = a.md_care_plan_id and e.care_plan_id = a.care_plan_id and e.OUTCOME_MSR_ID =f.OUTCOME_MSR_ID and e.eval_id = ? order by a.term_set_id,a.term_code,a.group_id,a.outcome_code";
		sql_outcome = "SELECT a.LAST_EVAL_OUTCOME_MSR_ID,a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,e.progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome FROM cp_pat_care_plan_outcome a, cp_outcome_lang_vw b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d,cp_pat_outcome_eval e,CP_OUTCOME_MSR f WHERE a.md_care_plan_id = ?  AND a.care_plan_id = ? AND a.term_set_id = NVL(?,a.term_set_id) AND a.term_code = NVL(?,a.term_code) AND a.goal_code = NVL(?,a.goal_code)   AND a.appl_yn = 'Y' AND b.outcome_code = a.outcome_code AND c.md_care_plan_id = a.md_care_plan_id AND c.care_plan_id = a.care_plan_id AND c.term_set_id = a.term_set_id   AND c.term_code = a.term_code AND b.outcome_code = e.outcome_code AND d.md_care_plan_id = a.md_care_plan_id AND d.care_plan_id = a.care_plan_id AND d.term_set_id = a.term_set_id AND d.term_code = a.term_code AND d.goal_code = a.goal_code AND e.md_care_plan_id = a.md_care_plan_id AND e.care_plan_id = a.care_plan_id AND e.OUTCOME_MSR_ID =f.OUTCOME_MSR_ID AND e.eval_id = ? AND b.language_id = ? ORDER BY a.term_set_id,a.term_code,a.group_id,a.outcome_code";

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
if(mode.equals("")){
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
}else{
            _bw.write(_wl_block15Bytes, _wl_block15);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

	stmt_intvn = con.prepareStatement(sql_intvn);
	stmt_intvn.setString(1,md_plan_id);
	stmt_intvn.setString(2,care_plan_id);
	stmt_intvn.setString(3,term_set_id);
	stmt_intvn.setString(4,term_code);
	stmt_intvn.setString(5,goal_code);
	stmt_intvn.setString(6,locale);
	rs_intvn = stmt_intvn.executeQuery();
	stmt_outcome = con.prepareStatement(sql_outcome);
	if(mode.equals(""))
	{
		stmt_outcome.setString(1,md_plan_id);
		stmt_outcome.setString(2,care_plan_id);
		stmt_outcome.setString(3,term_set_id);
		stmt_outcome.setString(4,term_code);
		stmt_outcome.setString(5,goal_code);
		stmt_outcome.setString(6,locale);
	}
	else
	{
		stmt_outcome.setString(1,md_plan_id);
		stmt_outcome.setString(2,care_plan_id);
		stmt_outcome.setString(3,term_set_id);
		stmt_outcome.setString(4,term_code);
		stmt_outcome.setString(5,goal_code);
		stmt_outcome.setString(6,eval_id);
		stmt_outcome.setString(7,locale);
	}
	rs_outcome = stmt_outcome.executeQuery();
	String Intvnkey = "";
	String outcomekey = "";
	String ItermSet = "";
	String ItermCode = "";
	//String IgoalCode = "";
	String Igrpid = "";
	String IDesc = "";
	String Istatus = "";
	String otermSet = "";
	String otermCode = "";
	String ogrpid = "";
	String outcome_desc = "";
//added on Nov 11 2005
	String outcomeMsrid="";
	String outcomeMsrDesc="";
	String outcomeMsrsql="";

//end

	String tempString="";
	String term_code_status = "";
	String goal_status = "";
	String outcome_status = "";
	String fontvals = "";
	String termsetid = "";
	String termcode = "";
	String term_code_srl_no = ""; 
	String goal_cde = "";
	String goal_srl_no = "";
	String outcome_code = "";
	String outcome_srl_no = "";
	String pract_id_outcome = "";
	String pract_id = "";
	int k=0;
	int outcome_pct = 0;
	HashMap record = new HashMap();
	ArrayList result = null;
	if(rs_intvn!=null)
	{
		while(rs_intvn.next())
		{
			ItermSet=rs_intvn.getString("term_set_id");
			ItermCode=rs_intvn.getString("term_code");
			Igrpid=rs_intvn.getString("group_id_intvn");
			IDesc=rs_intvn.getString("intvn_desc");
			Istatus=rs_intvn.getString("status");
			if(Istatus.equals("O")) Istatus= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
			if(Istatus.equals("D")) Istatus= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Discontinued.label","common_labels");
			if(Istatus.equals("9")) Istatus= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancelled.label","common_labels");	
			if(Istatus.equals("P")) Istatus= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PartiallyCompleted.label","common_labels");
			if(Istatus.equals("A")) Istatus= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.Achieved.label","cp_labels");
			if(Istatus.equals("N")) Istatus= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.NotAchieved.label","cp_labels");;
			Intvnkey = ItermSet+ItermCode+Igrpid;
			if(record.containsKey(Intvnkey))
			{
				result=(ArrayList)record.get(Intvnkey);
				result.add(IDesc);
				result.add(Istatus);
				for(int i=0;i<=15;i++)
				{
					result.add("");
				}
			}
			else
			{
				result=new ArrayList();
				result.add(IDesc);
				result.add(Istatus);
				for(int i=0;i<=15;i++)
				{
					result.add("");
				}
				record.put(Intvnkey,result);
			}
		}
	}
	if(rs_outcome!=null)
	{
		while(rs_outcome.next())
		{
			otermSet=rs_outcome.getString("term_set_id");
			otermCode=rs_outcome.getString("term_code");
			ogrpid=rs_outcome.getString("group_id_outcome");
			outcomekey=otermSet+otermCode+ogrpid;
			//System.err.println("LAST_EVAL_OUTCOME_MSR_ID "+rs_outcome.getString("LAST_EVAL_OUTCOME_MSR_ID"));
			if(record.containsKey(outcomekey))
			{	
				k=0;
				result=(ArrayList)record.get(outcomekey);
				for(int j=0;j<result.size();j=j+18)
				{
					tempString=(String)result.get(j+2);
					if(!tempString.equals(""))
					{
						k=k+18;
					}
					else
					{	
						
						break;
					}
				}
				if(k<result.size())
				{
					result.set(k+2,rs_outcome.getString("outcome_desc"));
					result.set(k+3,rs_outcome.getString("term_code_status"));
					result.set(k+4,rs_outcome.getString("goal_status"));
					result.set(k+5,rs_outcome.getString("outcome_status"));
					result.set(k+6,rs_outcome.getString("term_set_id"));
					result.set(k+7,rs_outcome.getString("term_code"));
					result.set(k+8,rs_outcome.getString("goal_code"));
					result.set(k+9,rs_outcome.getString("outcome_code"));
					result.set(k+10,rs_outcome.getString("term_code_srl_no"));
					result.set(k+11,rs_outcome.getString("goal_srl_no"));
					result.set(k+12,rs_outcome.getString("outcome_srl_no"));
					result.set(k+13,rs_outcome.getString("outcome_prog_pct")==null?"104":rs_outcome.getString("outcome_prog_pct"));				
					result.set(k+14,ogrpid);
					pract_id = rs_outcome.getString("pract_id_outcome")==null?"":rs_outcome.getString("pract_id_outcome");
					result.set(k+15,pract_id);
					result.set(k+16,rs_outcome.getString("LAST_EVAL_OUTCOME_MSR_ID")==null?"":rs_outcome.getString("LAST_EVAL_OUTCOME_MSR_ID"));	
				}
				else
				{
					result.add("");
					result.add("");
					result.add(rs_outcome.getString("outcome_desc"));
					result.add(rs_outcome.getString("term_code_status"));
					result.add(rs_outcome.getString("goal_status"));
					result.add(rs_outcome.getString("outcome_status"));
					result.add(rs_outcome.getString("term_set_id"));
					result.add(rs_outcome.getString("term_code"));
					result.add(rs_outcome.getString("goal_code"));
					result.add(rs_outcome.getString("outcome_code"));
					result.add(rs_outcome.getString("term_code_srl_no"));
					result.add(rs_outcome.getString("goal_srl_no"));
					result.add(rs_outcome.getString("outcome_srl_no"));
					result.add(rs_outcome.getString("outcome_prog_pct")==null?"104":rs_outcome.getString("outcome_prog_pct"));					
					result.add(ogrpid);
					pract_id = rs_outcome.getString("pract_id_outcome")==null?"":rs_outcome.getString("pract_id_outcome");
					result.add(pract_id);
					result.add(rs_outcome.getString("LAST_EVAL_OUTCOME_MSR_ID")==null?"":rs_outcome.getString("LAST_EVAL_OUTCOME_MSR_ID"));	
					result.add("");

				}
			}		
		}
	}
	Set itr_set			=	record.keySet();
	Iterator recordItr	=	itr_set.iterator();
	while(recordItr.hasNext())
	{
		if(classvalue.equals("ROWODD"))
		{
			classvalue="ROWEVEN";
			fontvals = "FONTSTYLEVEN";
		}
		else
		{
			classvalue="ROWODD";
			fontvals = "FONTSTYLODD";
		}
		outcomekey="";
		outcomekey=(String)recordItr.next();
		result=(ArrayList)record.get(outcomekey);
		for(int i=0;i<result.size();i=i+18)
		{

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(result.get(i)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(result.get(i+2)));
            _bw.write(_wl_block21Bytes, _wl_block21);

			outcome_desc = (String)	result.get(i+2);
			term_code_status = (String)result.get(i+3);
			goal_status = (String)result.get(i+4);
			outcome_status = (String)result.get(i+5);
			outcome_code = (String) result.get(i+9);
			outcomeMsrid=(String)result.get(i+16);
			if(!outcome_code.equals("")){
				if(!outcomeMsrid.equals("")){
//					outcomeMsrsql="Select OUTCOME_MSR_DESC from CP_OUTCOME_MSR where OUTCOME_MSR_ID='"+outcomeMsrid+"' and OUTCOME_CODE='"+outcome_code+"'";
					outcomeMsrsql="SELECT OUTCOME_MSR_DESC FROM CP_OUTCOME_MSR_lang_vw WHERE OUTCOME_MSR_ID='"+outcomeMsrid+"' AND OUTCOME_CODE='"+outcome_code+"' and language_id ='"+locale+"'";
					//System.err.println("outcomeMsrsql "+outcomeMsrsql);
					stmt_outcome_msr_id	=	con.createStatement();
					rs_outcome_msr_id	=	stmt_outcome_msr_id.executeQuery(outcomeMsrsql);
					if(rs_outcome_msr_id!=null){
						rs_outcome_msr_id.next();
						outcomeMsrDesc=rs_outcome_msr_id.getString("OUTCOME_MSR_DESC");
					}
					if(rs_outcome_msr_id!=null)
					rs_outcome_msr_id.close();
					if(stmt_outcome_msr_id!=null)
					stmt_outcome_msr_id.close();
				}
			}
			
			if((term_code_status.equals("R"))||(term_code_status.equals("9"))||(term_code_status.equals("D")))
				evaluation_allowed_yn = "N";
			else if((goal_status.equals("A"))||(goal_status.equals("9"))||(goal_status.equals("D"))||(goal_status.equals("N")))
				evaluation_allowed_yn = "N";
			else if((outcome_status.equals("A"))||(outcome_status.equals("9"))||(outcome_status.equals("D"))||(outcome_status.equals("N")))
				evaluation_allowed_yn = "N";
			else
				evaluation_allowed_yn = "Y";
			if(evaluation_allowed_yn .equals("N"))
			{
				 onclickwork_outcome = "";
				 onclickchgcolorfr = "";
				 onclickchgcolorbac = "";
			}
			else
			{
				 onclickwork_outcome = "valfix";
				 onclickchgcolorfr = "colorcgfront";
				 onclickchgcolorbac = "colorcgback";
			}
			if(!mode.equals(""))
			{
				 onclickwork_outcome = "";
				 onclickchgcolorfr = "";
				 onclickchgcolorbac = "";
			}
			if(!outcome_desc.equals(""))
			{
				outcome_pct = Integer.parseInt((String)result.get(i+13));
				if(outcome_pct==0)
					out.println("<td class='"+fontvals+"' style='color:red' id='ids1"+outcome_count+"' onclick="+onclickwork_outcome+"(00,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1');"+onclickchgcolorfr+"(this) width='1%'><B>[</B></td>");
				else
					out.println("<td class='"+fontvals+"' id='ids1"+outcome_count+"' onclick="+onclickwork_outcome+"(00,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1');"+onclickchgcolorfr+"(this) width='1%'><B>[</B></td>");
				if(outcome_pct==4)
					out.println("<td title ='"+outcomeMsrDesc+"'  class='"+fontvals+"' width='1%' id='ids2"+outcome_count+"' onclick="+onclickwork_outcome+"(4,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids2"+outcome_count+"' onclick="+onclickwork_outcome+"(4,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==8)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids3"+outcome_count+"' onclick="+onclickwork_outcome+"(8,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids3"+outcome_count+"' onclick="+onclickwork_outcome+"(8,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==12)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids4"+outcome_count+"' onclick="+onclickwork_outcome+"(12,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids4"+outcome_count+"' onclick="+onclickwork_outcome+"(12,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==16)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids5"+outcome_count+"' onclick="+onclickwork_outcome+"(16,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids5"+outcome_count+"' onclick="+onclickwork_outcome+"(16,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==20)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids6"+outcome_count+"' onclick="+onclickwork_outcome+"(20,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids6"+outcome_count+"' onclick="+onclickwork_outcome+"(20,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==24)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids7"+outcome_count+"' onclick="+onclickwork_outcome+"(24,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids7"+outcome_count+"' onclick="+onclickwork_outcome+"(24,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==28)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids8"+outcome_count+"' onclick="+onclickwork_outcome+"(28,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids8"+outcome_count+"' onclick="+onclickwork_outcome+"(28,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==32)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids9"+outcome_count+"' onclick="+onclickwork_outcome+"(32,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids9"+outcome_count+"' onclick="+onclickwork_outcome+"(32,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==36)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids10"+outcome_count+"' onclick="+onclickwork_outcome+"(36,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids10"+outcome_count+"' onclick="+onclickwork_outcome+"(36,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==40)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids11"+outcome_count+"' onclick="+onclickwork_outcome+"(40,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids11"+outcome_count+"' onclick="+onclickwork_outcome+"(40,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==44)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids12"+outcome_count+"' onclick="+onclickwork_outcome+"(44,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids12"+outcome_count+"' onclick="+onclickwork_outcome+"(44,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==48)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids13"+outcome_count+"' onclick="+onclickwork_outcome+"(48,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids13"+outcome_count+"' onclick="+onclickwork_outcome+"(48,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==52)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids14"+outcome_count+"' onclick="+onclickwork_outcome+"(52,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"'class='"+fontvals+"' width='1%' id='ids14"+outcome_count+"' onclick="+onclickwork_outcome+"(52,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==56)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids15"+outcome_count+"' onclick="+onclickwork_outcome+"(56,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids15"+outcome_count+"' onclick="+onclickwork_outcome+"(56,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==60)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids16"+outcome_count+"' onclick="+onclickwork_outcome+"(60,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids16"+outcome_count+"' onclick="+onclickwork_outcome+"(60,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==64)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids17"+outcome_count+"' onclick="+onclickwork_outcome+"(64,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids17"+outcome_count+"' onclick="+onclickwork_outcome+"(64,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==68)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids18"+outcome_count+"' onclick="+onclickwork_outcome+"(68,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids18"+outcome_count+"' onclick="+onclickwork_outcome+"(68,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==72)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids19"+outcome_count+"' onclick="+onclickwork_outcome+"(72,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids19"+outcome_count+"' onclick="+onclickwork_outcome+"(72,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==76)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids20"+outcome_count+"' onclick="+onclickwork_outcome+"(76,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids20"+outcome_count+"' onclick="+onclickwork_outcome+"(76,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==80)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids21"+outcome_count+"' onclick="+onclickwork_outcome+"(80,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids21"+outcome_count+"' onclick="+onclickwork_outcome+"(80,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==84)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids22"+outcome_count+"' onclick="+onclickwork_outcome+"(84,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids22"+outcome_count+"' onclick="+onclickwork_outcome+"(84,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==88)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids23"+outcome_count+"' onclick="+onclickwork_outcome+"(88,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids23"+outcome_count+"' onclick="+onclickwork_outcome+"(88,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==92)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids24"+outcome_count+"' onclick="+onclickwork_outcome+"(92,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids24"+outcome_count+"' onclick="+onclickwork_outcome+"(92,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==96)
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids25"+outcome_count+"' onclick="+onclickwork_outcome+"(96,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>|</td>");
				else
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' width='1%' id='ids25"+outcome_count+"' onclick="+onclickwork_outcome+"(96,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1')>-</td>");
				if(outcome_pct==100){
					out.println("<td title ='"+outcomeMsrDesc+"' class='"+fontvals+"' style='color:#1AFF1A'width='1%' id='ids26"+outcome_count+"' onclick="+onclickwork_outcome+"(100,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1');"+onclickchgcolorbac+"(this)><B>]</B></td>");
					msrlookupdisabled="disabled";
				}else{
					out.println("<td class='"+fontvals+"' width='1%' id='ids26"+outcome_count+"' onclick="+onclickwork_outcome+"(100,this,"+outcome_count+","+outcome_count+",'Outcome',"+outcome_pct+",'1');"+onclickchgcolorbac+"(this)><B>]</B></td>");
					msrlookupdisabled="";
				}
				termsetid = (String) result.get(i+6);
				termcode = (String) result.get(i+7);
				term_code_srl_no = (String) result.get(i+10); 
				goal_cde = (String) result.get(i+8);
				goal_srl_no = (String) result.get(i+11);
		//		outcome_code = (String) result.get(i+9);
				outcome_srl_no = (String) result.get(i+12);
				out.println("<td class='"+classvalue+"' width='1%'>&nbsp;</td>");
				pract_id_outcome = (String) result.get(i+15)==null?"":(String) result.get(i+15);
				if(!pract_id_outcome.equals("")){
					out.println("<td class='"+fontvals+"' width='1%' onclick='showOutcomeHistory(\""+termsetid+"\",\""+termcode+"\",\""+term_code_srl_no+"\",\""+goal_cde+"\",\""+goal_srl_no+"\",\""+outcome_code+"\",\""+outcome_srl_no+"\",\""+outcome_desc+"\")'>H</td>");
				}
				else{
					out.println("<td class='"+fontvals+"' width='1%'>&nbsp;</td>");
				}
					out.println("<td class='"+classvalue+"' colspan='2'>&nbsp;</td>");
				// Added on nov 8
			
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(fontvals));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(msrlookupdisabled));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(outcome_code));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(outcome_desc));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(outcome_count));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(outcome_pct));
            _bw.write(_wl_block26Bytes, _wl_block26);

					//End
				out.println("<td class='"+fontvals+"' width='10%' id='ids27"+outcome_count+"' onclick=resetval(this,"+outcome_pct+","+outcome_count+",'Outcome') align='center'><B>&nbsp;</B></td>");
				// For DB action these vales are put into hidden fields.
				out.println("<input type='hidden' name='group_id"+outcome_count+"' id='group_id"+outcome_count+"' value='"+(String) result.get(i+14)+"'>");
				out.println("<input type='hidden' name='term_code_status"+outcome_count+"' id='term_code_status"+outcome_count+"' value='"+(String) result.get(i+3)+"'>");
				out.println("<input type='hidden' name='goal_status"+outcome_count+"' id='goal_status"+outcome_count+"' value='"+(String) result.get(i+4)+"'>");
				out.println("<input type='hidden' name='outcome_status"+outcome_count+"' id='outcome_status"+outcome_count+"' value='"+(String) result.get(i+5)+"'>");
				out.println("<input type='hidden' name='term_set_id_outcome"+outcome_count+"' id='term_set_id_outcome"+outcome_count+"' value='"+(String) result.get(i+6)+"'>");
				out.println("<input type='hidden' name='term_code_outcome"+outcome_count+"' id='term_code_outcome"+outcome_count+"' value='"+(String) result.get(i+7)+"'>");
				out.println("<input type='hidden' name='goal_code_outcome"+outcome_count+"' id='goal_code_outcome"+outcome_count+"' value='"+(String) result.get(i+8)+"'>");
				out.println("<input type='hidden' name='outcome_code"+outcome_count+"' id='outcome_code"+outcome_count+"' value='"+(String) result.get(i+9)+"'>");
				out.println("<input type='hidden' name='term_code_srl_no_outcome"+outcome_count+"' id='term_code_srl_no_outcome"+outcome_count+"' value='"+(String) result.get(i+10)+"'>");
				out.println("<input type='hidden' name='goal_srl_no_outcome"+outcome_count+"' id='goal_srl_no_outcome"+outcome_count+"' value='"+(String) result.get(i+11)+"'>");
				out.println("<input type='hidden' name='outcome_srl_no"+outcome_count+"' id='outcome_srl_no"+outcome_count+"' value='"+(String) result.get(i+12)+"'>");
				out.println("<input type='hidden' name='outcome_prog_pct"+outcome_count+"' id='outcome_prog_pct"+outcome_count+"' value=''>");
				out.println("<input type='hidden' name='evaluation_allowed_outcome_yn"+outcome_count+"' id='evaluation_allowed_outcome_yn"+outcome_count+"' value='"+evaluation_allowed_yn+"'>");
				out.println("<input type='hidden' name='evaluation_outcome_yn"+outcome_count+"' id='evaluation_outcome_yn"+outcome_count+"' value=''>");
				out.println("<input type='hidden' name='tempidvaloutcome"+outcome_count+"' id='tempidvaloutcome"+outcome_count+"'>");
				// Added on nov 8
				out.println("<input type='hidden' name='OutcomemsrID"+outcome_count+"' id='OutcomemsrID"+outcome_count+"' value='"+outcomeMsrid+"'>");
				//End
				// End of DB action values.
			}
			else
			{
				out.println("<td align='center' colspan='32' class='"+classvalue+"'>&nbsp;</td>");
			}
			msrlookupdisabled="";

            _bw.write(_wl_block27Bytes, _wl_block27);

		outcome_count++;
		outcomeMsrDesc="";
		}
	}

            _bw.write(_wl_block28Bytes, _wl_block28);

}
catch(Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs_intvn!=null) rs_intvn.close();
	if(rs_outcome!=null) rs_outcome.close();
	if(stmt_intvn!=null) stmt_intvn.close();
	if(stmt_outcome!=null) stmt_outcome.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(outcome_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block31Bytes, _wl_block31);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Interventions.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.EvaluationScore.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reset.label", java.lang.String .class,"key"));
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
