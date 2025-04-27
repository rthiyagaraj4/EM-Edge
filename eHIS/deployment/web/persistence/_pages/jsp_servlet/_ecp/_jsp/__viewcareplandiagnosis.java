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

public final class __viewcareplandiagnosis extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanDiagnosis.jsp", 1736421326652L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------\nDate       Edit History   \t\tName        Description\n-----------------------------------------------------------------------\n?             100         \t\t?           created\n08/05/2012\t  IN032589\t\t\tMenaka V\tView Care Plan details>Diagnosis>Diagnosis/Intervention>The Label is displayed Wrongly for\n\t\t\t\t\t\t\t\t\t\t\tEvaluation Score as Status\n15/05/2012\t  IN032573\t\t\tMenaka V\tCA>View Care Plan details>Diagnosis>The status of  Intervention is displayed As Null after\n\t\t\t\t\t\t\t\t\t\t\tIntervention is Performed.\t\t\t\t\t\t\t\t\t\t\t\n-----------------------------------------------------------------------\n-->\n<html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<!--<script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script>-->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" type=\"text/javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></script>\n<!--<script src=\"../../eCommon/js/MstCodeCommon.js\" language=\"javascript\"></script>-->\n<script src=\"../../eCP/js/ViewCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCP/js/CpMessages.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\'view_cp_detail\' id=\'view_cp_detail\'>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t<tr id=\'plan\"+i+\"\' style=\'display:\"+disp_style+\"\' height=\'5px\'>\n\t<td class=CLASSHEADDIAG colspan=\'14\' align=\'left\'>&nbsp;&nbsp;Evaluation Details</td>\n\t</tr>\n\t<tr >\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'>&nbsp;Care Manager Name</td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'>&nbsp;Start Date</td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'>&nbsp;Target Date</td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'>&nbsp;Evaluation Date</td>\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'>&nbsp;No. of Evals</td>\n\t</tr>\n\t<tr>\n\t\t<td width=\'25%\' class=\'label\' align=\'left\'><b>&nbsp;";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</b></td>\n\t\t<td width=\'20%\' class=\'label\' align=\'left\'><b>&nbsp;";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</b></td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=5 class=\'label\' align=left>&nbsp;Remarks\n\t\t</td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'2\' align=left>&nbsp;&nbsp; <textarea name=\'eval_remarks\' rows=\'3\' cols=\'70\' onblur=\'checkForMax(this);\'></textarea>\n\t\t<td colspan=\'2\' width=\'25%\' class=\'label\' align=\'left\'>&nbsp;&nbsp;&nbsp;&nbsp;Status:\n\t\t\t&nbsp;<b>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</b><input type=\"hidden\" name=\"view_status\" id=\"view_status\" value=\"A\">\n\t\t</td>\n\t\t<td colspan=1 align=left><input type=button class=\'button\' name=\"History\" id=\"History\" value=\"History\" onclick=\"ShowHistory();\"></td>\n\t\t</tr>\n<table>\n<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<input type=\"hidden\" name=\"patient_id\" id=\"patient_id\" value=\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\">\n<input type=\"hidden\" name=\"care_manager\" id=\"care_manager\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n<input type=\"hidden\" name=\"care_plan_id\" id=\"care_plan_id\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<input type=\"hidden\" name=\"md_care_plan_id\" id=\"md_care_plan_id\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=\"hidden\" name=\"encounter_id\" id=\"encounter_id\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n</table>\n\n</form>\n</body>\n\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");;
	String p_patient_id = request.getParameter("PatientId")==null?"":request.getParameter("PatientId");
	String md_care_plan_id = request.getParameter("md_care_plan_id")==null?"":request.getParameter("md_care_plan_id");
	String care_plan_id = request.getParameter("care_plan_id")==null?"":request.getParameter("care_plan_id");
	String care_mgr_name = request.getParameter("care_mgr_name")==null?"":request.getParameter("care_mgr_name");
	String cp_start_date = request.getParameter("cp_start_date")==null?"":request.getParameter("cp_start_date");
	String cp_target_date = request.getParameter("cp_target_date")==null?"":request.getParameter("cp_target_date");
	String curr_status = request.getParameter("curr_status")==null?"":request.getParameter("curr_status");

	String strCurStatDisplay	=	"";
	
	if(curr_status.equals("C") )
		strCurStatDisplay	= "Completed";
	else if(curr_status.equals("D") )
		strCurStatDisplay	= "Discontinued";
	else
		strCurStatDisplay	= "Active";

	Connection con = null;
	PreparedStatement stmt = null;
	PreparedStatement pstmt_diag_goal = null;
	PreparedStatement pstmt_intvn = null;
	PreparedStatement pstmt_outcome = null;
	ResultSet rs = null;	
	ResultSet rs_view_cnt = null;
	ResultSet rs_diag_goal = null;	
	ResultSet rs_intvn = null;
	ResultSet rs_outcome = null;
	
	String current_date="";
	String intvn_desc = "";
	String achv_pct = "";
	String notachv_pct = "";
	String achv_notachv_pct = "";
	String classvalue = "";
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
	String disp_style = "";
	StringBuffer diag_percentage = new StringBuffer();
	StringBuffer goal_percentage = new StringBuffer();
	StringBuffer outcome_percentage = new StringBuffer();
	int diag_pct = 0;
	int goal_pct = 0;
	int outcome_pct = 0;
	int i=1;
	int k=0;
	int diag_cnt = 0;
	int goal_cnt = 0;
	int outcome_cnt = 0;
	HashMap record = new HashMap();
	ArrayList result = null;
	int eval_cnt = 0;
	String pract_id_diag = "";
	String pract_id_goal = "";
	String pract_id_outcome="";

try
{
con = ConnectionManager.getConnection(request);
stmt = con.prepareStatement("select to_char(sysdate,'dd/mm/yyyy hh24:mi') cur_date from dual ");
	rs	=	stmt.executeQuery();
	while((rs!= null)&&rs.next())
	{
		current_date=rs.getString("cur_date");
	}
	if(rs != null) rs.close();
	if(stmt!=null) stmt.close();
	
	stmt = con.prepareStatement("select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ? and status = 'V'");
	stmt.setString(1,md_care_plan_id);
	stmt.setString(2,care_plan_id);
	rs_view_cnt = stmt.executeQuery();
	if(rs_view_cnt != null)
		if(rs_view_cnt.next())
			eval_cnt = rs_view_cnt.getInt(1);
	if(rs_view_cnt!=null) rs_view_cnt.close();
	if(stmt!=null) stmt.close();
	
String tempStrings = "";
// Query for Diag and Goal.
String sql_diag_goal = "select a.term_set_id termsetid,a.term_code termcode,a.term_code_srl_no term_code_srl_no, b.short_desc||'('||a.term_set_id||')' diag_desc,a.last_progress_percent last_diag_prog_pct, c.goal_code goalcode,a.last_eval_by pract_id_diag,c.last_eval_by pract_id_goal,c.goal_srl_no goal_srl_no,d.short_desc goal_desc,c.last_progress_percent last_goal_prog_pct,a.status diag_status, c.status goal_status,to_char(a.target_date,'dd/mm/yyyy') diag_target_date,to_char(c.goal_target_date,'dd/mm/yyyy') goal_target_date from cp_pat_care_plan_term_code a, mr_term_code b,cp_pat_care_plan_goal c, cp_outcome d where a.md_care_plan_id = ? and a.care_plan_id = ? and b.term_set_id = a.term_set_id and b.term_code = a.term_code and c.md_care_plan_id = ? and c.care_plan_id = ? and c.term_set_id = a.term_set_id and c.term_code = a.term_code  and d.outcome_code = c.goal_code order by a.term_set_id,a.term_code,c.goal_code";
// end of Diag and Goal Query.
// Query for Intervention and Outcome.
	
	//String sql_intvn = "select a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,decode(a.status,'O','Pending','D','Discontinued','9','Cancelled','P','Partially Completed','A','Achieved','N','Not Achieved') status from cp_pat_care_plan_intvn a, ca_intervention b where a.md_care_plan_id = ? and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code) and b.intervention_code = a.intervention_code order by a.term_set_id,a.term_code,a.group_id,a.intervention_code";//IN032573
	String sql_intvn = "select a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,decode(a.status,'O','Pending','D','Discontinued','9','Cancelled','P','Partially Completed','A','Achieved','N','Not Achieved','C','Completed') status from cp_pat_care_plan_intvn a, ca_intervention b where a.md_care_plan_id = ? and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code) and b.intervention_code = a.intervention_code order by a.term_set_id,a.term_code,a.group_id,a.intervention_code";//IN032573
	
	String sql_outcome = "select a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,a.last_progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome from cp_pat_care_plan_outcome a, cp_outcome b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d where a.md_care_plan_id = ?   and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code)   and b.outcome_code = a.outcome_code and c.md_care_plan_id = a.md_care_plan_id and c.care_plan_id = a.care_plan_id and c.term_set_id = a.term_set_id   and c.term_code = a.term_code and d.md_care_plan_id = a.md_care_plan_id and d.care_plan_id = a.care_plan_id and d.term_set_id = a.term_set_id and d.term_code = a.term_code and d.goal_code = a.goal_code order by a.term_set_id,a.term_code,a.group_id,a.outcome_code";
	
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(care_mgr_name));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(cp_start_date));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(cp_target_date));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(current_date ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(eval_cnt));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(strCurStatDisplay));
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	pstmt_diag_goal = con.prepareStatement(sql_diag_goal);
	pstmt_diag_goal.setString(1,md_care_plan_id);
	pstmt_diag_goal.setString(2,care_plan_id);
	pstmt_diag_goal.setString(3,md_care_plan_id);
	pstmt_diag_goal.setString(4,care_plan_id);
	rs_diag_goal = pstmt_diag_goal.executeQuery();
	
	if(rs_diag_goal!=null)
	{
		diag_cnt = 0;
		out.println("<tr id='plan"+i+"' style='display:"+disp_style+"' height='5px'>");
		out.println("<td class=CLASSHEADDIAG colspan='8' align='left'>&nbsp;&nbsp;Diagnosis/Intervention</td>");
		out.println("<td align='left' class=CLASSHEADDIAG colspan='3'>Target Date</td>");
		//out.println("<td  align='left' class=CLASSHEADDIAG colspan='3'>Status</td>");//IN032589
		out.println("<td  align='left' class=CLASSHEADDIAG colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.EvaluationScore.label","cp_labels")+"</td>");//IN032589
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
					out.println("<td class='CLASSHEADDIAGROW' colspan='3'><B>"+diag_percentage.toString()+"</B>");
				else if(achv_notachv_pct.equals("["))
					out.println("<td   class='CLASSHEADDIAGROW' colspan='3'><B><Font color='red'>"+achv_notachv_pct+"</Font>"+diag_percentage.toString()+"</B>");
				else if(achv_notachv_pct.equals("]"))
					out.println("<td  class='CLASSHEADDIAGROW' colspan='3'><B>"+diag_percentage.toString()+"<Font color='green'>"+achv_notachv_pct+"</Font></B>");
					pract_id_diag = rs_diag_goal.getString("pract_id_diag")==null?"":rs_diag_goal.getString("pract_id_diag");
					if(!pract_id_diag.equals(""))
							out.println("<a href='#' onClick='showDiagHistory(\"\",\""+rs_diag_goal.getString("termsetid")+"\",\""+rs_diag_goal.getString("termcode")+"\",\""+rs_diag_goal.getString("term_code_srl_no")+"\",\""+rs_diag_goal.getString("diag_desc")+"\");' text-decoration='none'>H</a>");
					out.println("</td></tr>");
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
					out.println("<td   class='CLASSHEADDIAGROW' colspan='3'><B>"+notachv_pct+"</B>"+goal_percentage.toString()+"<B>"+achv_pct+"</B>");
				else if (achv_notachv_pct.equals("notachv_pct"))
					out.println("<td class='CLASSHEADDIAGROW' colspan='3'><Font color='red'><B>"+notachv_pct+"</B></Font>"+goal_percentage.toString()+"<B>"+achv_pct+"</B>");
				else if(achv_notachv_pct.equals("achv_pct"))
					out.println("<td  class='CLASSHEADDIAGROW' colspan='3'><B>"+notachv_pct+"</B>"+goal_percentage.toString()+"<Font color='green'><B>"+achv_pct+"</B></Font>");
					pract_id_goal = rs_diag_goal.getString("pract_id_goal")==null?"":rs_diag_goal.getString("pract_id_goal");
					if(!pract_id_goal.equals(""))
						out.println("<a href='#'  onclick='showGoalHistory(\"\",\""+rs_diag_goal.getString("termsetid")+"\",\""+rs_diag_goal.getString("termcode")+"\",\""+rs_diag_goal.getString("term_code_srl_no")+"\",\""+rs_diag_goal.getString("goalcode")+"\",\""+rs_diag_goal.getString("goal_srl_no")+"\",\""+rs_diag_goal.getString("goal_desc")+"\",\""+rs_diag_goal.getString("diag_desc")+"\");'>H</a>");
					
				out.println("</td></tr>");
				pstmt_intvn = con.prepareStatement(sql_intvn);
				pstmt_intvn.setString(1,md_care_plan_id);
				pstmt_intvn.setString(2,care_plan_id);
				pstmt_intvn.setString(3,term_set_id);
				pstmt_intvn.setString(4,term_code);
				pstmt_intvn.setString(5,goal_code);
				rs_intvn = pstmt_intvn.executeQuery();
				if(rs_intvn!=null)
				{
					out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
					out.println("<td class='ITRVNHDR' colspan='1' width='2%'>&nbsp;</td>");
					out.println("<td class='ITRVNHDR' colspan='5'>Intervention</td>");
					out.println("<td class='ITRVNHDR' colspan='2' align='left'>Status</td>");
					out.println("<td class='ITRVNHDR' colspan='3'>Outcome</td>");
					//out.println("<td class='ITRVNHDR' colspan='3'>Status</td>");//IN032589
					out.println("<td class='ITRVNHDR' colspan='3'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.EvaluationScore.label","cp_labels")+"</td>");//IN032589
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
						Icode=rs_intvn.getString("intervention_code");
						Intvnkey = ItermSet+ItermCode+Igrpid;
						if(record.containsKey(Intvnkey))
						{
							result=(ArrayList)record.get(Intvnkey);
							result.add(IDesc);
							result.add(Istatus);
							result.add(Icode);
							for(int l=0;l<10;l++)
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
							for(int l=0;l<10;l++)
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
				pstmt_outcome.setString(1,md_care_plan_id);
				pstmt_outcome.setString(2,care_plan_id);
				pstmt_outcome.setString(3,term_set_id);
				pstmt_outcome.setString(4,term_code);
				pstmt_outcome.setString(5,goal_code);
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
							for(int j=0;j<result.size();j=j+13)
							{
								tempStrings = (String)result.get(j+3);
								if(!tempStrings.equals(""))
								{
									k=k+13;
								}
								else
								{	
									break;
								}
							}
							if(k<result.size())
							{
								result.set(k+3,rs_outcome.getString("outcome_desc"));
								result.set(k+4,(rs_outcome.getString("outcome_prog_pct")==null)?"104":rs_outcome.getString("outcome_prog_pct"));	
								result.set(k+5,rs_outcome.getString("pract_id_outcome")==null?"":rs_outcome.getString("pract_id_outcome"));	
								result.set(k+6,rs_outcome.getString("term_set_id")==null?"":rs_outcome.getString("term_set_id"));	
								result.set(k+7,rs_outcome.getString("term_code")==null?"":rs_outcome.getString("term_code"));	
								result.set(k+8,rs_outcome.getString("term_code_srl_no")==null?"":rs_outcome.getString("term_code_srl_no"));	
								result.set(k+9,rs_outcome.getString("goal_code")==null?"":rs_outcome.getString("goal_code"));	
								result.set(k+10,rs_outcome.getString("goal_srl_no")==null?"":rs_outcome.getString("goal_srl_no"));	
								result.set(k+11,rs_outcome.getString("outcome_code")==null?"":rs_outcome.getString("outcome_code"));	
								result.set(k+12,rs_outcome.getString("outcome_srl_no")==null?"":rs_outcome.getString("outcome_srl_no"));	
							}
							else
							{
								result.add("");
								result.add("");
								result.add("");
								result.add(rs_outcome.getString("outcome_desc"));
								result.add((rs_outcome.getString("outcome_prog_pct")==null )?"104":rs_outcome.getString("outcome_prog_pct"));	
								result.add(rs_outcome.getString("pract_id_outcome")==null?"":rs_outcome.getString("pract_id_outcome"));	
								result.add(rs_outcome.getString("term_set_id")==null?"":rs_outcome.getString("term_set_id"));	
								result.add(rs_outcome.getString("term_code")==null?"":rs_outcome.getString("term_code"));	
								result.add(rs_outcome.getString("term_code_srl_no")==null?"":rs_outcome.getString("term_code_srl_no"));	
								result.add(rs_outcome.getString("goal_code")==null?"":rs_outcome.getString("goal_code"));	
								result.add(rs_outcome.getString("goal_srl_no")==null?"":rs_outcome.getString("goal_srl_no"));	
								result.add(rs_outcome.getString("outcome_code")==null?"":rs_outcome.getString("outcome_code"));	
								result.add(rs_outcome.getString("outcome_srl_no")==null?"":rs_outcome.getString("outcome_srl_no"));	
								
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

					for(int m=0;m<result.size();m+=13)
					{
						intvn_desc = (String)result.get(m)==null?"":(String)result.get(m);
						outcome_desc = (String)result.get(m+3)==null?"":(String)result.get(m+3);
						Icode_val = (String)result.get(m+2);
						out.println("<tr height='5px' style='display:"+disp_style+"' id='plan"+i+"'>");
						if(intvn_desc.equals(""))
							out.println("<td colspan='1' align='right' class='"+outcome_hyp+"'>&nbsp;</td>");
						else
							out.println("<td colspan='1' align='right' title='View Intervention Details' class='"+outcome_hyp+"' onclick=calltasklist(this,'"+care_plan_id+"','"+md_care_plan_id+"','"+p_patient_id+"','"+Icode_val+"','"+encounter_id+"')>+</td>");
						out.println("<td  colspan='5' class='"+classvalue+"'>&nbsp;"+result.get(m)+"</td>");
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
								out.println("<td  colspan='3' class='"+classvalue+"'><B>"+notachv_pct+"</B>"+outcome_percentage.toString()+"<B>"+achv_pct+"</B>");
							else if(achv_notachv_pct.equals("notachv_pct"))
								out.println("<td  colspan='3' class='"+classvalue+"'><Font color='red'><B>"+notachv_pct+"</B></font>"+outcome_percentage.toString()+"<B>"+achv_pct+"</B>");
							else if(achv_notachv_pct.equals("achv_pct"))
								out.println("<td  colspan='3' class='"+classvalue+"'><B>"+notachv_pct+"</B>"+outcome_percentage.toString()+"<Font color='green'><B>"+achv_pct+"</B></font>");
					pract_id_outcome = (String) result.get(m+5)==null?"":(String) result.get(m+5);
				if(!pract_id_outcome.equals(""))
					out.println("<a href='#' onclick='showOutcomeHistory(\"\",\""+(String) result.get(m+6)+"\",\""+(String) result.get(m+7)+"\",\""+(String) result.get(m+8)+"\",\""+(String) result.get(m+9)+"\",\""+(String) result.get(m+10)+"\",\""+(String) result.get(m+11)+"\",\""+(String) result.get(m+12)+"\",\""+outcome_desc+"\")'>H</a>");
					out.println("</td>");
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
catch(Exception e)
{
	System.err.println(" 11 Exception in ViewCarePlanDiagnosis.jsp="+e.toString());
		e.printStackTrace();
}
finally
{
	try
	{	
		if(rs_diag_goal!=null)rs_diag_goal.close();
		if(rs_intvn!=null) rs_intvn.close();
		if(pstmt_intvn!=null) pstmt_intvn.close();		
		if(pstmt_diag_goal!=null)pstmt_diag_goal.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		System.err.println("222 Exception in ViewCarePlanDiagnosis.jsp="+e.toString());
		e.printStackTrace();
	}
}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(care_mgr_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(care_plan_id));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(md_care_plan_id));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
