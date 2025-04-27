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

public final class __evaluatecareplandiagandgoallist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/EvaluateCarePlanDiagAndGoalList.jsp", 1709116581231L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/common.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script src=\"../../eCP/js/EvaluateCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</head>\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\'eval_cp_diagandgoallist\' id=\'eval_cp_diagandgoallist\' target=\'blankFrame\' method=\'post\' action=\"../../servlet/eCP.EvaluateCarePlanServlet\">\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr >\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</td>\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'><b>&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</b></td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'><b>&nbsp;";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</b></td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=5 class=\'label\' align=left>&nbsp;";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t</td>\n\t</tr>\n\t\t<td colspan=\'4\' align=left>&nbsp;&nbsp; <textarea name=\'eval_remarks\' rows=\'3\' cols=\'80\' onblur=\'checkForMax(this);\'></textarea>\n\t\t</td>\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<BR>\n\t\t\t<select name=\'eval_status\' id=\'eval_status\'>\n\t\t\t\t<option value=\'A\' selected>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</option>\n\t\t\t\t<option value=\'C\'>";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</option>\n\t\t\t\t<option value=\'D\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</option>\n\t\t\t</select>\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=5 class=\'label\' align=left>&nbsp;&nbsp;&nbsp;</td>\n\t</tr>\n<table>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n<table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\" align=\'center\' id=\"DiagGoalTable\">\n\t<tr>\n\t\t<td class=\'ITRVNHDR\' colspan=\'2\' width=\'30%\' align=\'left\'><B>";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'23%\' align=\'left\'><B>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'7%\'>&nbsp;</td>\n\t\t<td class=\'ITRVNHDR\' colspan=\'30\' align=\'left\'><B>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'5%\' nowrap align=\'left\'></td>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t<td class=\'ITRVNHDR\' width=\'5%\'><B>";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="</B></td>\n";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t<td class=\'ITRVNHDR\' width=\'5%\'>&nbsp;</td>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t</tr>\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t\t<TD class=\"FONTVAL\" title=\"TermCode Measure\" ><INPUT TYPE=\"button\" class=\"button\" ";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="  value=\"?\" onclick=\"showTermcodeMsr(\'";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\',\'";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\')\"></TD>\n\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\t\t\t\t<TD class=\"FONTVAL\" title=\"Goal Measure\" ><INPUT TYPE=\"button\" class=\"button\" value=\"?\" ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" onclick=\"showMsr(\'Goal\',\'";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\n\t<tr>\n\t\t<td id=\'dynacreation_outcome\' colspan=\'36\'>&nbsp;</td>\n\t</tr>\n</table>\n<INPUT TYPE=\"hidden\" name=\"diag_count\" id=\"diag_count\" value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n<INPUT TYPE=\"hidden\" name=\"goal_count\" id=\"goal_count\" value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n<INPUT TYPE=\"hidden\" name=\"outcome_count\" id=\"outcome_count\" value=\"\">\n<INPUT TYPE=\"hidden\" name=\"care_plan_id\" id=\"care_plan_id\" value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\">\n<INPUT TYPE=\"hidden\" name=\"md_plan_id\" id=\"md_plan_id\" value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n<INPUT TYPE=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n<input type=hidden name=pract_id value=\'";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\'>\n<input type=hidden name=encounter_id value=\'";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\'>\n<input type=hidden name=locale value=\'";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\'>\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

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
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

Connection con = null;
PreparedStatement stmt = null;
ResultSet rs = null;
ResultSet rs_eval_cnt = null;
// Added on Nov 11 2005

Statement stmt_termCode_msr_id = null;
ResultSet  rs_termCode_msr_id = null;
Statement stmt_goal_msr_id = null;
ResultSet  rs_goal_msr_id = null;

//end

String p_pract_id = (String)session.getAttribute("ca_practitioner_id");
String care_mgr_name = request.getParameter("care_mgr_name")==null?"":request.getParameter("care_mgr_name");
String care_plan_id = request.getParameter("planid");
String md_plan_id = request.getParameter("md_plan_id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String cp_start_date = request.getParameter("cp_start_date")==null?"":com.ehis.util.DateUtils.convertDate(request.getParameter("cp_start_date"),"DMYHM","en",locale);
String cp_target_date = request.getParameter("cp_target_date")==null?"":com.ehis.util.DateUtils.convertDate(request.getParameter("cp_target_date"),"DMYHM","en",locale);
String mode = request.getParameter("mode")==null?"":request.getParameter("mode");
String eval_id = request.getParameter("eval_id")==null?"":request.getParameter("eval_id");
int diag_count = 1;
int goal_count = 1;
try
{
	String term_set_id = "";
	String term_code = "";
	String termcodeDesc="";
	String goal_code = "";
	String goal_desc="";
	String termcodemsrlookupdisabled="";
	String goalmsrlookupdisabled="";
	int diag_pct = 0;
	int goal_pct = 0;
	String evaluation_allowed_yn = "";
	String evaluation_allowed_goal_yn = "";
	String onclickwork_diag = "";
	String onclickwork_goal = "";
	String onclickchgcolorfr = "";
	String onclickchgcolorfr_goal = "";
	String onclickchgcolorbac = "";
	String onclickchgcolorbac_goal = "";
	String current_date="";
	String pract_id_diag = "";
	String pract_id_goal = "";
	String sql = "";
	// Added on nov 11 2005
	String termCodeMsrid="";
	String termCodeMsrDesc="";
	String termCodeMsrsql="";

	String goalMsrid="";
	String goalMsrDesc="";
	String goalMsrsql="";
	//end 
	int k = 1;
	int eval_cnt = 0;
	String eval_count_sql = "select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and status = 'V'";
	if(mode.equals(""))
		//sql = "select a.LAST_EVAL_TERM_CODE_MSR_ID,c.LAST_EVAL_GOAL_MSR_ID,a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no, b.short_desc||'('||a.term_set_id||')' diag_desc,a.last_progress_percent last_diag_prog_pct, c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,c.last_progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,to_char(a.target_date,'dd/mm/yyyy') diag_target_date,to_char(c.goal_target_date,'dd/mm/yyyy') goal_target_date from cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome d where a.md_care_plan_id = ? and a.care_plan_id = ? and a.appl_yn = 'Y' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.md_care_plan_id = ? and c.care_plan_id = ? and c.term_set_id = a.term_set_id and c.term_code = a.term_code and c.appl_yn = 'Y' and d.outcome_code = c.goal_code order by a.term_set_id,a.term_code,c.goal_code";
		sql = "SELECT a.LAST_EVAL_TERM_CODE_MSR_ID,c.LAST_EVAL_GOAL_MSR_ID,a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no, b.short_desc||'('||a.term_set_id||')' diag_desc,a.last_progress_percent last_diag_prog_pct, c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,c.last_progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,TO_CHAR(a.target_date,'dd/mm/yyyy') diag_target_date,TO_CHAR(c.goal_target_date,'dd/mm/yyyy') goal_target_date FROM cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome_lang_vw d WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.appl_yn = 'Y' AND b.term_set_id = a.term_set_id AND b.term_code = a.term_code AND c.md_care_plan_id = ? AND c.care_plan_id = ? AND c.term_set_id = a.term_set_id AND c.term_code = a.term_code AND c.appl_yn = 'Y' AND d.outcome_code = c.goal_code AND d.language_id = ? ORDER BY a.term_set_id,a.term_code,c.goal_code";
	else
		//sql = "select a.LAST_EVAL_TERM_CODE_MSR_ID,c.LAST_EVAL_GOAL_MSR_ID,a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no,b.short_desc||'('||a.term_set_id||')' diag_desc,f.progress_percent last_diag_prog_pct,c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,g.progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,to_char(a.target_date,'dd/mm/yyyy') diag_target_date,to_char(c.goal_target_date,'dd/mm/yyyy') goal_target_date from cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome d,cp_pat_term_code_eval f,cp_pat_goal_eval g where a.md_care_plan_id = ? and a.care_plan_id = ? and a.appl_yn = 'Y' and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.md_care_plan_id = ? and c.care_plan_id = ? and c.term_set_id = a.term_set_id and c.term_code = a.term_code and c.appl_yn = 'Y' and d.outcome_code = c.goal_code and f.md_care_plan_id = a.md_care_plan_id(+) and f.care_plan_id = a.care_plan_id(+) and f.eval_id = ? and  g.md_care_plan_id = a.md_care_plan_id and g.care_plan_id = a.care_plan_id and g.eval_id = ? order by a.term_set_id,a.term_code,c.goal_code";
		sql = "SELECT a.LAST_EVAL_TERM_CODE_MSR_ID,c.LAST_EVAL_GOAL_MSR_ID,a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no,b.short_desc||'('||a.term_set_id||')' diag_desc,f.progress_percent last_diag_prog_pct,c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,g.progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,TO_CHAR(a.target_date,'dd/mm/yyyy') diag_target_date,TO_CHAR(c.goal_target_date,'dd/mm/yyyy') goal_target_date FROM cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome_lang_vw d,cp_pat_term_code_eval f,cp_pat_goal_eval g WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.appl_yn = 'Y' AND b.term_set_id = a.term_set_id AND b.term_code = a.term_code AND c.md_care_plan_id = ? AND c.care_plan_id = ? AND c.term_set_id = a.term_set_id AND c.term_code = a.term_code AND c.appl_yn = 'Y' AND d.outcome_code = c.goal_code AND f.md_care_plan_id = a.md_care_plan_id(+) AND f.care_plan_id = a.care_plan_id(+) AND f.eval_id = ? AND  g.md_care_plan_id = a.md_care_plan_id AND g.care_plan_id = a.care_plan_id AND g.eval_id = ? AND d.language_id = ? ORDER BY a.term_set_id,a.term_code,c.goal_code";
	String  sql_curent_date = "select to_char(sysdate,'dd/mm/yyyy hh24:mi') cur_date from dual ";
	con = ConnectionManager.getConnection(request);
	stmt = con.prepareStatement(eval_count_sql);
	stmt.setString(1,md_plan_id);
	stmt.setString(2,care_plan_id);
	rs_eval_cnt = stmt.executeQuery();
	if(rs_eval_cnt != null)
		if(rs_eval_cnt.next())
			eval_cnt = rs_eval_cnt.getInt(1);
	if(rs_eval_cnt!=null) rs_eval_cnt.close();
	if(stmt!=null) stmt.close();
	stmt = con.prepareStatement(sql_curent_date);
	rs	=	stmt.executeQuery();
	while((rs!= null)&&rs.next())
	{
		current_date=com.ehis.util.DateUtils.convertDate(rs.getString("cur_date"),"DMYHM","en",locale);
	}
	if(rs != null) rs.close();
	if(stmt!=null) stmt.close();
	stmt = con.prepareStatement(sql);
	if(mode.equals(""))
	{
		stmt.setString(1,md_plan_id);
		stmt.setString(2,care_plan_id);
		stmt.setString(3,md_plan_id);
		stmt.setString(4,care_plan_id);
		stmt.setString(5,locale);
	}
	else
	{
		stmt.setString(1,md_plan_id);
		stmt.setString(2,care_plan_id);
		stmt.setString(3,md_plan_id);
		stmt.setString(4,care_plan_id);
		stmt.setString(5,eval_id);
		stmt.setString(6,eval_id);
		stmt.setString(7,locale);
	}
	rs = stmt.executeQuery();

            _bw.write(_wl_block8Bytes, _wl_block8);

if(mode.equals(""))
{

            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(care_mgr_name));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cp_start_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(cp_target_date));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(current_date ));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(eval_cnt));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

}

            _bw.write(_wl_block20Bytes, _wl_block20);

            if (_jsp__tag10(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag11(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag12(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);
if(mode.equals(""))
{
            _bw.write(_wl_block24Bytes, _wl_block24);

            if (_jsp__tag13(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block25Bytes, _wl_block25);
} else {
            _bw.write(_wl_block26Bytes, _wl_block26);
}
            _bw.write(_wl_block27Bytes, _wl_block27);

	if(rs!=null)
	{
		int i = 1;
		while(rs.next())
		{	
			if((!term_set_id.equals(rs.getString("termsetid")))||(!term_code.equals(rs.getString("termcode"))))
			{
					diag_pct = Integer.parseInt(rs.getString("last_diag_prog_pct")==null?"104":rs.getString("last_diag_prog_pct"));
					term_code = rs.getString("termcode");
					term_set_id = rs.getString("termsetid");
					termcodeDesc=rs.getString("diag_desc");
					termCodeMsrid=rs.getString("LAST_EVAL_TERM_CODE_MSR_ID")==null?"":rs.getString("LAST_EVAL_TERM_CODE_MSR_ID");
					if(!termCodeMsrid.equals("")){
						termCodeMsrsql ="Select TERM_CODE_MSR_DESC from CP_TERM_CODE_MSR where TERM_SET_ID='"+term_set_id+"' and TERM_CODE='"+term_code+"'and  TERM_CODE_MSR_ID='"+termCodeMsrid+"'";
						//System.err.println("outcomeMsrsql "+outcomeMsrsql);
						stmt_termCode_msr_id 	=	con.createStatement();
						rs_termCode_msr_id 	=	stmt_termCode_msr_id .executeQuery(termCodeMsrsql);
						if(rs_termCode_msr_id !=null){
							rs_termCode_msr_id .next();
							termCodeMsrDesc =rs_termCode_msr_id .getString("TERM_CODE_MSR_DESC");
						}
						if(rs_termCode_msr_id!=null)
							rs_termCode_msr_id.close();
						if(stmt_termCode_msr_id!=null)
							stmt_termCode_msr_id.close();
					}
				//	System.err.println("termCodeMsrDesc "+termCodeMsrDesc);
					out.println("<tr height='3px'>");
						out.println("<td colspan='2' width='30%' class='CLASHEAD'><B>"+termcodeDesc+"</B></td>");
						out.println("<td class='CLASHEAD' width='23%'><B>"+com.ehis.util.DateUtils.convertDate(rs.getString("diag_target_date"),"DMY","en",locale)+"</B></td>");
						out.println("<td class='CLASHEAD' width='10%'>&nbsp;</td>");
						if((rs.getString("diag_status").equals("9"))||(rs.getString("diag_status").equals("D"))||(rs.getString("diag_status").equals("R")))
							evaluation_allowed_yn = "N";
						else
							evaluation_allowed_yn = "Y";
						if(evaluation_allowed_yn .equals("N"))
						{
							 onclickwork_diag = "";
							 onclickwork_goal = "";
							 onclickchgcolorfr = "";
							 onclickchgcolorfr_goal = "";
							 onclickchgcolorbac = "";
							 onclickchgcolorbac_goal = "";
						}
						else
						{
							 onclickwork_diag = "valfix";
							 onclickwork_goal = "valfix";
							 onclickchgcolorfr = "colorcgfront";
							 onclickchgcolorfr_goal = "colorcgfront";
							 onclickchgcolorbac = "colorcgback";
							 onclickchgcolorbac_goal = "colorcgback";
						}
						if(!mode.equals(""))
						{
							 onclickwork_diag = "";
							 onclickwork_goal = "";
							 onclickchgcolorfr = "";
							 onclickchgcolorfr_goal = "";
							 onclickchgcolorbac = "";
							 onclickchgcolorbac_goal = "";
						}
						if(diag_pct==0)
							out.println("<td class='CLASSHEADVAL' style='color:red' onclick="+onclickwork_diag+"(00,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorfr+"(this) width='1%' id='id1"+i+"'><B>[</B></td>");
						else
							out.println("<td class='CLASSHEADVAL' onclick="+onclickwork_diag+"(00,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorfr+"(this) width='1%' id='id1"+i+"'><B>[</B></td>");
						if(diag_pct==4)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id2"+i+"' onclick="+onclickwork_diag+"(04,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id2"+i+"' onclick="+onclickwork_diag+"(04,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==8)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id3"+i+"' onclick="+onclickwork_diag+"(08,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id3"+i+"' onclick="+onclickwork_diag+"(08,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==12)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id4"+i+"' onclick="+onclickwork_diag+"(12,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id4"+i+"' onclick="+onclickwork_diag+"(12,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==16)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id5"+i+"' onclick="+onclickwork_diag+"(16,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id5"+i+"' onclick="+onclickwork_diag+"(16,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==20)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id6"+i+"' onclick="+onclickwork_diag+"(20,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id6"+i+"' onclick="+onclickwork_diag+"(20,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==24)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id7"+i+"' onclick="+onclickwork_diag+"(24,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id7"+i+"' onclick="+onclickwork_diag+"(24,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==28)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id8"+i+"' onclick="+onclickwork_diag+"(28,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id8"+i+"' onclick="+onclickwork_diag+"(28,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==32)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id9"+i+"' onclick="+onclickwork_diag+"(32,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id9"+i+"' onclick="+onclickwork_diag+"(32,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==36)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id10"+i+"' onclick="+onclickwork_diag+"(36,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id10"+i+"' onclick="+onclickwork_diag+"(36,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==40)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id11"+i+"' onclick="+onclickwork_diag+"(40,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id11"+i+"' onclick="+onclickwork_diag+"(40,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==44)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id12"+i+"' onclick="+onclickwork_diag+"(44,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id12"+i+"' onclick="+onclickwork_diag+"(44,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==48)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id13"+i+"' onclick="+onclickwork_diag+"(48,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id13"+i+"' onclick="+onclickwork_diag+"(48,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==52)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id14"+i+"' onclick="+onclickwork_diag+"(52,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id14"+i+"' onclick="+onclickwork_diag+"(52,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==56)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id15"+i+"' onclick="+onclickwork_diag+"(56,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id15"+i+"' onclick="+onclickwork_diag+"(56,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==60)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id16"+i+"' onclick="+onclickwork_diag+"(60,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id16"+i+"' onclick="+onclickwork_diag+"(60,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==64)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id17"+i+"' onclick="+onclickwork_diag+"(64,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id17"+i+"' onclick="+onclickwork_diag+"(64,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==68)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id18"+i+"' onclick="+onclickwork_diag+"(68,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id18"+i+"' onclick="+onclickwork_diag+"(68,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==72)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id19"+i+"' onclick="+onclickwork_diag+"(72,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id19"+i+"' onclick="+onclickwork_diag+"(72,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==76)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id20"+i+"' onclick="+onclickwork_diag+"(76,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id20"+i+"' onclick="+onclickwork_diag+"(76,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==80)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id21"+i+"' onclick="+onclickwork_diag+"(80,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id21"+i+"' onclick="+onclickwork_diag+"(80,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==84)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id22"+i+"' onclick="+onclickwork_diag+"(84,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id22"+i+"' onclick="+onclickwork_diag+"(84,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==88)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id23"+i+"' onclick="+onclickwork_diag+"(88,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id23"+i+"' onclick="+onclickwork_diag+"(88,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==92)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id24"+i+"' onclick="+onclickwork_diag+"(92,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id24"+i+"' onclick="+onclickwork_diag+"(92,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==96)
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id25"+i+"' onclick="+onclickwork_diag+"(96,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>|</B></td>");
						else
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id25"+i+"' onclick="+onclickwork_diag+"(96,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1')><B>-</B></td>");
						if(diag_pct==100){
							termcodemsrlookupdisabled ="disabled";
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' style='color:#1AFF1A' id='id26"+i+"' onclick="+onclickwork_diag+"(100,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorbac+"(this)><B>]</B></td>");
						}else{
							termcodemsrlookupdisabled ="";
							out.println("<td title ='"+termCodeMsrDesc+"' class='CLASSHEADVAL' width='1%' id='id26"+i+"' onclick="+onclickwork_diag+"(100,this,"+i+","+diag_count+",'Diag',"+diag_pct+",'1');"+onclickchgcolorbac+"(this)><B>]</B></td>");
						}
						out.println("<td class='CLASSHEADVAL' width='1%'>&nbsp;</td>");
						pract_id_diag = rs.getString("pract_id_diag")==null?"":rs.getString("pract_id_diag");
						if(!pract_id_diag.equals(""))
							out.println("<td class='CLASSHEADVAL' width='1%'onclick='showDiagHistory(\""+rs.getString("termsetid")+"\",\""+rs.getString("termcode")+"\",\""+rs.getString("term_code_srl_no")+"\",\""+rs.getString("diag_desc")+"\");'><B>H</B></td>");
						else
							out.println("<td class='CLASSHEADVAL' width='1%'>&nbsp;</td>");
						out.println("<td class='CLASHEAD' colspan='2'>&nbsp;</td>");
			
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf(termcodemsrlookupdisabled ));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(termcodeDesc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(diag_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(diag_pct));
            _bw.write(_wl_block31Bytes, _wl_block31);

						out.println("<td class='CLASSHEADVAL' width='10%' align='center' id='id27"+i+"' onclick=resetval(this,"+diag_pct+","+diag_count+",'Diag')><B>&nbsp;</B></td>");

					out.println("</tr>");
					// For DB action these vales are put into hidden fields.
					out.println("<input type='hidden' name='term_set_id_diag"+diag_count+"' id='term_set_id_diag"+diag_count+"' value='"+rs.getString("termsetid")+"'>");
					out.println("<input type='hidden' name='term_code_diag"+diag_count+"' id='term_code_diag"+diag_count+"' value='"+rs.getString("termcode")+"'>");
					out.println("<input type='hidden' name='term_code_srl_no_diag"+diag_count+"' id='term_code_srl_no_diag"+diag_count+"' value='"+rs.getString("term_code_srl_no")+"'>");
					out.println("<input type='hidden' name='dx_prog_pct"+diag_count+"' id='dx_prog_pct"+diag_count+"'>");
					out.println("<input type='hidden' name='diag_status"+diag_count+"' id='diag_status"+diag_count+"' value='"+rs.getString("diag_status")+"'>");
					out.println("<input type='hidden' name='evaluation_allowed_diag_yn"+diag_count+"' id='evaluation_allowed_diag_yn"+diag_count+"' value='"+evaluation_allowed_yn+"'>");
					out.println("<input type='hidden' name='evaluated_diag_yn"+diag_count+"' id='evaluated_diag_yn"+diag_count+"'>");
					out.println("<input type='hidden' name='tempidvaldiag"+diag_count+"' id='tempidvaldiag"+diag_count+"'>");
					out.println("<input type='hidden' name='DiagmsrID"+diag_count+"' id='DiagmsrID"+diag_count+"' value='"+termCodeMsrid+"'>");
					diag_count++;
					//End.
					
					goal_code = "";
					i++;
			}
			if(!goal_code.equals(rs.getString("goalcode")))
			{
				goal_pct = Integer.parseInt(rs.getString("last_goal_prog_pct")==null?"104":rs.getString("last_goal_prog_pct"));
				goal_code = rs.getString("goalcode");
				goal_desc=rs.getString("goal_desc");
				goalMsrid =rs.getString("LAST_EVAL_GOAL_MSR_ID")==null?"":rs.getString("LAST_EVAL_GOAL_MSR_ID");
//			System.err.println("goalMsrid  "+goalMsrid );
				if(!goalMsrid .equals("")){
//					goalMsrsql ="Select OUTCOME_MSR_DESC from CP_OUTCOME_MSR where OUTCOME_MSR_ID='"+goalMsrid+"' and OUTCOME_CODE='"+goal_code+"'";
					goalMsrsql ="SELECT OUTCOME_MSR_DESC FROM CP_OUTCOME_MSR_lang_vw WHERE OUTCOME_MSR_ID='"+goalMsrid+"' AND OUTCOME_CODE='"+goal_code+"' AND language_id ='"+locale+"'";
//					System.err.println("goalMsrsql "+goalMsrsql);
					stmt_goal_msr_id  	=	con.createStatement();
					rs_goal_msr_id  	=	stmt_goal_msr_id.executeQuery(goalMsrsql);
					if(rs_goal_msr_id  !=null){
						rs_goal_msr_id  .next();
						goalMsrDesc  =rs_goal_msr_id  .getString("OUTCOME_MSR_DESC");
					}
					if(rs_goal_msr_id!=null)
							rs_goal_msr_id.close();
						if(stmt_goal_msr_id!=null)
							stmt_goal_msr_id.close();
				}
//					System.err.println("goalMsrDesc  "+goalMsrDesc );

				out.println("<tr height='3px'>");
					out.println("<td class='FONTSTYL' width='5%'>&nbsp;</td>");
					out.println("<td class='FONTVALHYPER' onclick=callintvnandoutcomepg('"+care_plan_id+"','"+md_plan_id+"','"+rs.getString("termsetid")+"','"+rs.getString("termcode")+"','"+rs.getString("goalcode")+"','"+eval_id+"','"+mode+"') width='50%'>"+goal_desc+"</td>");
					if((rs.getString("goal_status").equals("9"))||(rs.getString("goal_status").equals("D"))||(rs.getString("goal_status").equals("A"))||(rs.getString("goal_status").equals("N")))
						evaluation_allowed_goal_yn = "N";
					else if((rs.getString("diag_status").equals("9"))||(rs.getString("diag_status").equals("D"))||(rs.getString("diag_status").equals("R")))
						evaluation_allowed_goal_yn = "N";
					else
						evaluation_allowed_goal_yn = "Y";
					out.println("<td width='23%' class='FONTSTYL'>"+com.ehis.util.DateUtils.convertDate(rs.getString("goal_target_date"),"DMY","en",locale)+"</td>");
					out.println("<td class='FONTSTYL' width='10%'>&nbsp;</td>");
					if(evaluation_allowed_goal_yn .equals("N"))
					{
						 onclickwork_goal = "";
						 onclickchgcolorfr_goal = "";
						 onclickchgcolorbac_goal = "";
					}
					else
					{
						 onclickwork_goal = "valfix";
						 onclickchgcolorfr_goal = "colorcgfront";
						 onclickchgcolorbac_goal = "colorcgback";
					}
					if(!mode.equals(""))
					{
						 onclickwork_goal = "";
						 onclickchgcolorfr_goal = "";
						 onclickchgcolorbac_goal = "";
					}
					if(goal_pct==0)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' id='ids1"+k+"' style='color:red' onclick="+onclickwork_goal+"(00,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorfr_goal+"(this) width='1%'><B>[</B></td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' id='ids1"+k+"' onclick="+onclickwork_goal+"(00,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorfr_goal+"(this) width='1%'><B>[</B></td>");
					if(goal_pct==4)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids2"+k+"' onclick="+onclickwork_goal+"(04,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids2"+k+"' onclick="+onclickwork_goal+"(04,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==8)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids3"+k+"' onclick="+onclickwork_goal+"(08,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids3"+k+"' onclick="+onclickwork_goal+"(08,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==12)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids4"+k+"' onclick="+onclickwork_goal+"(12,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids4"+k+"' onclick="+onclickwork_goal+"(12,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==16)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids5"+k+"' onclick="+onclickwork_goal+"(16,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids5"+k+"' onclick="+onclickwork_goal+"(16,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==20)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids6"+k+"' onclick="+onclickwork_goal+"(20,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids6"+k+"' onclick="+onclickwork_goal+"(20,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==24)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids7"+k+"' onclick="+onclickwork_goal+"(24,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids7"+k+"' onclick="+onclickwork_goal+"(24,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==28)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids8"+k+"' onclick="+onclickwork_goal+"(28,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids8"+k+"' onclick="+onclickwork_goal+"(28,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==32)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids9"+k+"' onclick="+onclickwork_goal+"(32,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids9"+k+"' onclick="+onclickwork_goal+"(32,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==36)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids10"+k+"' onclick="+onclickwork_goal+"(36,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids10"+k+"' onclick="+onclickwork_goal+"(36,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==40)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids11"+k+"' onclick="+onclickwork_goal+"(40,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids11"+k+"' onclick="+onclickwork_goal+"(40,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==44)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids12"+k+"' onclick="+onclickwork_goal+"(44,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids12"+k+"' onclick="+onclickwork_goal+"(44,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==48)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids13"+k+"' onclick="+onclickwork_goal+"(48,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids13"+k+"' onclick="+onclickwork_goal+"(48,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==52)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids14"+k+"' onclick="+onclickwork_goal+"(52,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids14"+k+"' onclick="+onclickwork_goal+"(52,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==56)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids15"+k+"' onclick="+onclickwork_goal+"(56,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids15"+k+"' onclick="+onclickwork_goal+"(56,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==60)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids16"+k+"' onclick="+onclickwork_goal+"(60,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids16"+k+"' onclick="+onclickwork_goal+"(60,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==64)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids17"+k+"' onclick="+onclickwork_goal+"(64,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids17"+k+"' onclick="+onclickwork_goal+"(64,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==68)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids18"+k+"' onclick="+onclickwork_goal+"(68,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids18"+k+"' onclick="+onclickwork_goal+"(68,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==72)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids19"+k+"' onclick="+onclickwork_goal+"(72,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids19"+k+"' onclick="+onclickwork_goal+"(72,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==76)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids20"+k+"' onclick="+onclickwork_goal+"(76,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids20"+k+"' onclick="+onclickwork_goal+"(76,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==80)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids21"+k+"' onclick="+onclickwork_goal+"(80,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids21"+k+"' onclick="+onclickwork_goal+"(80,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==84)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids22"+k+"' onclick="+onclickwork_goal+"(84,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids22"+k+"' onclick="+onclickwork_goal+"(84,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==88)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids23"+k+"' onclick="+onclickwork_goal+"(88,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids23"+k+"' onclick="+onclickwork_goal+"(88,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==92)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids24"+k+"' onclick="+onclickwork_goal+"(92,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids24"+k+"' onclick="+onclickwork_goal+"(92,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==96)
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids25"+k+"' onclick="+onclickwork_goal+"(96,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>|</td>");
					else
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids25"+k+"' onclick="+onclickwork_goal+"(96,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1')>-</td>");
					if(goal_pct==100){
						goalmsrlookupdisabled ="disabled";
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' style='color:#1AFF1A' width='1%' id='ids26"+k+"' onclick="+onclickwork_goal+"(100,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorbac_goal+"(this)><B>]</B></td>");
					}
					else{
						goalmsrlookupdisabled ="";
						out.println("<td title ='"+goalMsrDesc +"' class='FONTVAL' width='1%' id='ids26"+k+"' onclick="+onclickwork_goal+"(100,this,"+k+","+goal_count+",'Goal',"+goal_pct+",'1');"+onclickchgcolorbac_goal+"(this)><B>]</B></td>");
					}
					out.println("<td class='FONTVAL' width='1%'>&nbsp;</td>");
					pract_id_goal = rs.getString("pract_id_goal")==null?"":rs.getString("pract_id_goal");
					if(!pract_id_goal.equals(""))
						out.println("<td class='FONTVAL' width='1%' onclick='showGoalHistory(\""+rs.getString("termsetid")+"\",\""+rs.getString("termcode")+"\",\""+rs.getString("term_code_srl_no")+"\",\""+rs.getString("goalcode")+"\",\""+rs.getString("goal_srl_no")+"\",\""+rs.getString("goal_desc")+"\",\""+rs.getString("diag_desc")+"\");'>H</td>");
					else
						out.println("<td class='FONTVAL' width='1%'>&nbsp;</td>");
					out.println("<td class='FONTSTYL' colspan='2'>&nbsp;</td>");

				
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(goalmsrlookupdisabled));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(goal_code));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(goal_desc));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(goal_count));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(goal_pct));
            _bw.write(_wl_block31Bytes, _wl_block31);

					out.println("<td class='FONTVAL' width='10%' id='ids27"+k+"' onclick=resetval(this,"+goal_pct+","+goal_count+",'Goal') align='center'><B>&nbsp;</B></td>");
				//	out.println("<td class='CLASHEAD' colspan='2'>&nbsp;</td>");
				out.println("</tr>");
				// For DB action these vales are put into hidden fields.
				out.println("<input type='hidden' name='term_set_id_goal"+goal_count+"' id='term_set_id_goal"+goal_count+"' value='"+rs.getString("termsetid")+"'>");
				out.println("<input type='hidden' name='term_code_goal"+goal_count+"' id='term_code_goal"+goal_count+"' value='"+rs.getString("termcode")+"'>");
	//			goal_code = rs.getString("goalcode");
				out.println("<input type='hidden' name='term_code_srl_no_goal"+goal_count+"' id='term_code_srl_no_goal"+goal_count+"' value='"+rs.getString("term_code_srl_no")+"'>");
				out.println("<input type='hidden' name='goal_code"+goal_count+"' id='goal_code"+goal_count+"' value='"+rs.getString("goalcode")+"'>");
				out.println("<input type='hidden' name='goal_srl_no"+goal_count+"' id='goal_srl_no"+goal_count+"' value='"+rs.getString("goal_srl_no")+"'>");
				out.println("<input type='hidden' name='goal_status"+goal_count+"' id='goal_status"+goal_count+"' value='"+rs.getString("goal_status")+"'>");
				out.println("<input type='hidden' name='diag_status_for_goal"+goal_count+"' id='diag_status_for_goal"+goal_count+"' value='"+rs.getString("diag_status")+"'>");
				out.println("<input type='hidden' name='goal_prog_pct"+goal_count+"' id='goal_prog_pct"+goal_count+"' value=''>");
				out.println("<input type='hidden' name='evaluation_allowed_goal_yn"+goal_count+"' id='evaluation_allowed_goal_yn"+goal_count+"' value='"+evaluation_allowed_goal_yn+"'>");
				out.println("<input type='hidden' name='evaluation_goal_yn"+goal_count+"' id='evaluation_goal_yn"+goal_count+"' value=''>");
				out.println("<input type='hidden' name='tempidvalgoal"+goal_count+"' id='tempidvalgoal"+goal_count+"'>");
				out.println("<input type='hidden' name='GoalmsrID"+goal_count+"' id='GoalmsrID"+goal_count+"' value='"+goalMsrid+"'>");
				goal_count++;
				// End.
				k++;
			}
			termCodeMsrDesc="";
			goalMsrDesc="";
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
}
catch(Exception e)
{
	//out.println(e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181

}
finally
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(diag_count));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(goal_count));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(care_plan_id));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(md_plan_id));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(patient_id));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(p_pract_id));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block42Bytes, _wl_block42);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.CareManagerName.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.StartDate.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.TargetDate.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.EvaluationDate.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.NoOfEvals.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.remarks.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.status.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.active.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.completed.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Discontinued.label", java.lang.String .class,"key"));
        __tag9.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag10.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
        __tag10.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag11.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.TargetDate.label", java.lang.String .class,"key"));
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
        __tag12.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.EvaluationScore.label", java.lang.String .class,"key"));
        __tag12.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${cp_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
        __tag13.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.reset.label", java.lang.String .class,"key"));
        __tag13.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
}
