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

public final class __viewcareplanactiveplansresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanActivePlansResult.jsp", 1736421099590L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n-----------------------------------------------------------------------\nDate       Edit History   \t\tName        Description\n-----------------------------------------------------------------------\n?             100         \t\t?           created\n\n23/04/2012\t  ML-SD-SCF-3132\tMenakaV\t\tThere is an issue for care plans where once a nursing diagnosis is marked as ?Resolved ? , we are not able to\n\t\t\t\t\t\t\t\t\t\t\tview all the care plan details in the function of ?View Care Plan Details?.\n-----------------------------------------------------------------------\n-->\n<html>\n<head>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<!--<script src=\"../../eCP/js/common.js\" language=\"JavaScript\"></script>-->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCommon/js/CommonCalendar.js\" type=\"text/javascript\"></script>\n<script src=\"../../eCommon/js/CommonLookup.js\" language=\"JavaScript\"></script>\n<!--<script src=\"../../eCommon/js/MstCodeCommon.js\" language=\"javascript\"></script>-->\n<script src=\"../../eCP/js/ViewCarePlan.js\" language=\"JavaScript\"></script>\n<script src=\"../../eCP/js/CpMessages.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\'view_cp_result\' id=\'view_cp_result\'>\n<input type=hidden name=encounter_id value=\'";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\'>\n<input type=hidden name=facilty_id value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n<input type=hidden name=p_care_mgr_id value=\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\n\t<P>\n\t<table align=\'right\'>\n\t<tr>\n\t<td>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<a href=\'#\' onClick=\"callNextPrev(\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\')\" text-decoration=\'none\'>Prev</a>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t<a href=\'#\' onClick=\"callNextPrev(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\" text-decoration=\'none\'>Next</a>\n\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t</td>\n\t</tr>\n\t</table>\n\t<br><br>\n\t</p>\n\t<table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'center\'>\n\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t<tr height=\'5px\'>\n\t\t\t\t\t\t\t<td align=\'center\' class=CLASSHEAD width=\'7%\'>Plan No</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'24%\'>Care Manager</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'5%\'>#R&nbsp;</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD  width=\'14%\'>Last Revision</td>\n\t\t\t\t\t\t\t<td class=CLASSHEAD width=\"15%\">Revised By</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'5%\'>#E</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\"14%\">Last Evaluation</td>\n\t\t\t\t\t\t\t<td align=\'left\' class=CLASSHEAD width=\'15%\' colspan=\'2\'>Evaluated By</td>\n\t\t\t\t\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t<input type=\'hidden\' name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n\t\t\t<input type=\'hidden\' name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\n\t\t\t<input type=\'hidden\' name=\"maxRecord\" id=\"maxRecord\" value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t\t\t<script>\n\t\t\t\tif(parent.view_cp_result.view_cp_result!=null){\n\t\t\t\t\tcallDetailFrame(\'";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\');\t\t\t\n\t\t\t\t}\n\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n</table>\n\n</form>\n</body>\n\n</html>\n";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\n\n";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}


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
	PreparedStatement pstmt1 = null;
	PreparedStatement pstmt_cnt = null;	
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs_cnt = null;

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(facilty_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(p_care_mgr_id));
            _bw.write(_wl_block7Bytes, _wl_block7);

try
{
con = ConnectionManager.getConnection(request);
String plan_id = "";
String tempString = "";	
String error_status = "";
String status_sql = "";
if(view_plans.equals("L"))
	status_sql = "(a.current_status in('O','F','C','D','9') or b.status in ('O','R','D','9'))";
else if(view_plans.equals("A"))
	status_sql = "(a.current_status = 'O' or b.status = 'O')";
// Queries
String view_count_sql = "select count(*) from cp_pat_care_plan_eval where md_care_plan_id = ? and care_plan_id = ?";
String rev_count_sql = "select count(*) from cp_pat_care_plan_revision where md_care_plan_id = ? and care_plan_id = ?";
//String sql_result = "select a.md_care_plan_id md_plan_id,a.care_plan_id plan_id, b.term_set_id term_set_id,b.term_code term_code, c.short_desc diag_desc,d.practitioner_name care_manager_name,	to_char(a.last_eval_datetime,'dd/mm/yyyy hh24:mi') last_eval_date_time,to_char(a.last_revision_date_time,'dd/mm/yyyy hh24:mi') last_revision_date_time,e.short_name eval_by_name,g.short_name rev_by_name, a.patient_id patient_id, f.patient_name pat_name, decode(f.sex,'F','Female','M','Male','U','Unknown') pat_sex,	get_age(f.date_of_birth) pat_age, to_char(a.CARE_PLAN_START_DATE,'dd/mm/yyyy hh24:mi') cp_start_date, to_char(a.CARE_PLAN_TARGET_DATE,'dd/mm/yyyy hh24:mi') cp_target_date,h.status error_status,h.eval_id,decode(sign(trunc(sysdate) - trunc(a.care_plan_start_date) ),0,1,1,(trunc(sysdate) - trunc(a.care_plan_start_date))+1) cp_day_no,a.current_status current_status FROM cp_pat_care_plan a, cp_pat_care_plan_term_code b,	mr_term_code c, am_practitioner d, am_practitioner e, mp_patient f, am_practitioner g,cp_pat_care_plan_eval h where a.patient_id = ? and a.current_facility_id = ? and (? is null or a.current_care_manager_id = ? ) and a.care_plan_start_date between nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date) and (nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date)+1)  and ( (? is null and ? is null) or ( exists (select 1 from cp_pat_care_plan_term_code  where md_care_plan_id = a.md_care_plan_id and care_plan_id = a.care_plan_id and (? is null or term_set_id = ?) and (? is null or term_code = ?) ) ) ) and b.md_care_plan_id = a.md_care_plan_id and h.md_care_plan_id(+) = a.md_care_plan_id and b.care_plan_id = a.care_plan_id and h.care_plan_id(+) = a.care_plan_id and	b.appl_yn = 'Y' and "+status_sql+" and	c.term_set_id = b.term_set_id and c.term_code = b.term_code  and	d.practitioner_id(+) = a.current_care_manager_id and e.practitioner_id(+) = a.last_eval_by and g.practitioner_id(+) = a.last_revision_pract_id and f.patient_id = a.patient_id order by patient_id, a.care_plan_id,b.term_code,h.eval_id desc";
String sql_result = "select a.md_care_plan_id md_plan_id,a.care_plan_id plan_id, b.term_set_id term_set_id,b.term_code term_code, c.short_desc diag_desc,d.practitioner_name care_manager_name,	to_char(a.last_eval_datetime,'dd/mm/yyyy hh24:mi') last_eval_date_time,to_char(a.last_revision_date_time,'dd/mm/yyyy hh24:mi') last_revision_date_time,e.short_name eval_by_name,g.short_name rev_by_name, a.patient_id patient_id, f.patient_name pat_name, decode(f.sex,'F','Female','M','Male','U','Unknown') pat_sex,	get_age(f.date_of_birth) pat_age, to_char(a.CARE_PLAN_START_DATE,'dd/mm/yyyy hh24:mi') cp_start_date, to_char(a.CARE_PLAN_TARGET_DATE,'dd/mm/yyyy hh24:mi') cp_target_date,h.status error_status,h.eval_id,decode(sign(trunc(sysdate) - trunc(a.care_plan_start_date) ),0,1,1,(trunc(sysdate) - trunc(a.care_plan_start_date))+1) cp_day_no,a.current_status current_status FROM cp_pat_care_plan a, cp_pat_care_plan_term_code b,	mr_term_code c, am_practitioner d, am_practitioner e, mp_patient f, am_practitioner g,cp_pat_care_plan_eval h where a.patient_id = ? and a.current_facility_id = ? and (? is null or a.current_care_manager_id = ? ) and a.care_plan_start_date between nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date) and (nvl(to_date(?,'dd/mm/yyyy hh24:mi'),a.care_plan_start_date)+1)  and ( (? is null and ? is null) or ( exists (select 1 from cp_pat_care_plan_term_code  where md_care_plan_id = a.md_care_plan_id and care_plan_id = a.care_plan_id and (? is null or term_set_id = ?) and (? is null or term_code = ?) ) ) ) and b.md_care_plan_id = a.md_care_plan_id and h.md_care_plan_id(+) = a.md_care_plan_id and b.care_plan_id = a.care_plan_id and h.care_plan_id(+) = a.care_plan_id and "+status_sql+" and	c.term_set_id = b.term_set_id and c.term_code = b.term_code  and	d.practitioner_id(+) = a.current_care_manager_id and e.practitioner_id(+) = a.last_eval_by and g.practitioner_id(+) = a.last_revision_pract_id and f.patient_id = a.patient_id order by patient_id, a.care_plan_id,b.term_code,h.eval_id desc";
/*****************************/
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	pstmt1=con.prepareStatement(sql_result);//,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);
	pstmt1.setString(1,p_patient_id);
	pstmt1.setString(2,facilty_id);
	pstmt1.setString(3,p_care_mgr_id);
	pstmt1.setString(4,p_care_mgr_id);
	pstmt1.setString(5,p_fr_date);
	pstmt1.setString(6,p_to_date);
	pstmt1.setString(7,p_t_set_id);
	pstmt1.setString(8,p_t_code);
	pstmt1.setString(9,p_t_set_id);
	pstmt1.setString(10,p_t_set_id);
	pstmt1.setString(11,p_t_code);
	pstmt1.setString(12,p_t_code);
	rs1=pstmt1.executeQuery();
	int start = 0 ;
    int end = 0 ;

	int maxRecord = 0;
	String cntPlan_id="";
	while(rs1!=null && rs1.next()){	
		if(!cntPlan_id.equals(rs1.getString("plan_id")))
		{
				cntPlan_id=rs1.getString("plan_id");
				if(cntPlan_id==null) cntPlan_id="";
				maxRecord++;
		}
	}
	String prevNextPlan_id="";
	if(maxRecord == 0){
		//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));parent.view_cp_tabs.location.href='../../eCommon/html/blank.html';parent.view_cp_detail.location.href='../../eCommon/html/blank.html';</script>");
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','common')); window.close()</script>");
	}else{
		
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if ( to == null )
			end = 4 ;
		else
			end = Integer.parseInt( to ) ;
	
            _bw.write(_wl_block8Bytes, _wl_block8);

	if ( !(start <= 1) ){
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilty_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_care_mgr_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_t_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_t_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_fr_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_to_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(view_plans));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(view_summary));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-4)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end-4)));
            _bw.write(_wl_block11Bytes, _wl_block11);
}
	if ( !( (start+4) > maxRecord ) ){
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(p_patient_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(facilty_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(encounter_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_care_mgr_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_t_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_t_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_fr_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(p_to_date));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(view_plans));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(view_summary));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start+4)));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((end+4)));
            _bw.write(_wl_block13Bytes, _wl_block13);
}
            _bw.write(_wl_block14Bytes, _wl_block14);

/*****************************/
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
	rs=pstmt.executeQuery();

	String last_view_date_time = "";
	String last_revision_date_time = "";
	String view_by_name = "";
	String rev_by_name = "";
	String patient_id = "";
	
	String care_mgr = "";
	String view_cnts = "";
	String rev_cnts = "";
	String markerror = "";
	String markerrortitle = "";
	String current_status = "";
	int i=1;
 	int view_cnt=0;
	int rev_cnt=0;
	//int count=0;
	
	if(rs!=null )
	{
            _bw.write(_wl_block15Bytes, _wl_block15);

			/*
			start=5
			end=8
			k=5
			*/
			if ( start != 1 ){
				for( int j=1; j<start; i++,j++ ){
					prevNextPlan_id=request.getParameter("prevNextPlan_id");
					if(prevNextPlan_id==null)  prevNextPlan_id="";
					
					while(j<(start-1) && rs.next() && prevNextPlan_id.equals(rs.getString("plan_id")) ){					
						prevNextPlan_id=rs.getString("plan_id");		
					}
					prevNextPlan_id=rs.getString("plan_id");		
					if(prevNextPlan_id==null)  prevNextPlan_id="";
					
				}
			}

		while ( rs.next() && i<=end  )
		{

			care_mgr = rs.getString("care_manager_name")==null?"&nbsp":rs.getString("care_manager_name");
			last_view_date_time = rs.getString("last_eval_date_time")==null?"&nbsp;":rs.getString("last_eval_date_time");
			last_revision_date_time = rs.getString("last_revision_date_time")==null?"&nbsp;":rs.getString("last_revision_date_time");
			view_by_name = rs.getString("eval_by_name")==null?"&nbsp;":rs.getString("eval_by_name");
			rev_by_name = rs.getString("rev_by_name")==null?"&nbsp;":rs.getString("rev_by_name");
			current_status = rs.getString("current_status");
			pstmt_cnt = con.prepareStatement(view_count_sql);
			pstmt_cnt.setString(1,rs.getString("md_plan_id"));
			pstmt_cnt.setString(2,rs.getString("plan_id"));
			rs_cnt = pstmt_cnt.executeQuery();
			if(rs_cnt!=null)
				if(rs_cnt.next())
					view_cnt = rs_cnt.getInt(1);
			if(rs_cnt!=null) rs_cnt.close(); 
			if(pstmt_cnt!=null) pstmt_cnt.close();
			if(view_cnt==0)
			{
				view_cnts = view_cnt+"";
				view_cnts = "&nbsp;";
				markerrortitle = "";
				markerror = "&nbsp;";
			}
			else
			{
				view_cnts = view_cnt+"";
				markerrortitle = "View Error Details";
				markerror = "X";
			}
			error_status = rs.getString("error_status")==null?"":rs.getString("error_status");
			if(current_status.equals("O"))
			{
				if(error_status.equals("E"))
				{
					markerrortitle = "";
					markerror = "&nbsp;";
				}
			}
			else 
			{				
				markerrortitle = "";			
				markerror = "&nbsp;";				
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

			if(p_patient_id.equals(""))
			{
				if(!patient_id.equals(rs.getString("patient_id")))
				{
					i =1;
					patient_id = rs.getString("patient_id");
					out.println("<tr height='5px'>");
						out.println("<td class='CLASSVAL' colspan='5' align='left'>"+rs.getString("patient_id")+","+rs.getString("pat_name")+","+rs.getString("pat_age")+","+rs.getString("pat_sex")+"</td>");
					out.println("</tr>");
				}
			}
			
			//out.println("<tr height='3px'>");
				if(!plan_id.equals(rs.getString("plan_id")))
				{		
				tempString = java.net.URLEncoder.encode(care_mgr);
				plan_id = rs.getString("plan_id");
				out.println("<tr height='5px' id='selectedRow"+i+"'  onClick='callDetailFrame(\""+i+"\")'>");
				out.println("<td align='center' class='FONTVALS' width='7%'>"+i+"</td>");
				out.println("<input type=hidden name='start"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' id='start"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' value='"+rs.getString("cp_start_date")+"'>");
				out.println("<input type=hidden name='target"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' id='target"+rs.getString("md_plan_id")+rs.getString("plan_id")+p_patient_id+"' value='"+rs.getString("cp_target_date")+"'>");
				out.println("<td width='23%' class='FONTVALS'>"+care_mgr+"</td>");
				out.println("<input type='hidden' name='care_plan_id"+i+"' id='care_plan_id"+i+"' value='"+checkForNull(rs.getString("plan_id"))+"'><input type='hidden' name='md_care_plan_id"+i+"' id='md_care_plan_id"+i+"' value='"+checkForNull(rs.getString("md_plan_id"))+"'><input type='hidden' name='patient_id' id='patient_id' value='"+p_patient_id+"'><input type='hidden' name='care_mgr_name"+i+"' id='care_mgr_name"+i+"' value=\""+tempString+"\"><input type='hidden' name='intvncode"+i+"' id='intvncode"+i+"' value=''><input type='hidden' name='curr_status"+i+"' id='curr_status"+i+"' value=\""+current_status+"\">");
		
				out.println("<td width='3%' align='left' class='FONTVALS'>"+rev_cnts+"&nbsp;</td>");
				out.println("<td width='15%' class='FONTVALS'>"+last_revision_date_time+"</td>");
				out.println("<td width='15%' class='FONTVALS'>"+rev_by_name+"</td>");
				out.println("<td width='3%' align='left' class='FONTVALS'>"+view_cnts+"&nbsp;&nbsp;</td>");
				out.println("<td class='FONTVALS' width='14%'>"+last_view_date_time+"</td>");
				out.println("<td class='FONTVALS' width='15%'>"+view_by_name+"</td>");
				out.println("<td class='FONTVALHYPERS' width='5%'  title='"+markerrortitle+"' onclick=viewCarePlanShowError(this,'"+rs.getString("plan_id")+"','"+rs.getString("md_plan_id")+"','"+rs.getString("current_status")+"','"+p_patient_id+"','"+tempString+"')><B>"+markerror+"</B></td><input type='hidden' name='prevNextPlan_id"+i+"' id='prevNextPlan_id"+i+"' value='"+plan_id+"'>");
				out.println("</tr>");
				i++;
			
			}
		}
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(start));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(end));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(start));
            _bw.write(_wl_block20Bytes, _wl_block20);


	}
}	
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		
}
catch(Exception e)
{
	System.out.println(" 111 Exception in ViewCarePlanActivePlansResult.jsp="+e.toString());
		e.printStackTrace();
}
finally
{
	try
	{
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	if(con!=null) ConnectionManager.returnConnection(con,request);
	}
	catch(Exception e)
	{
		System.out.println(" 2222 Exception in ViewCarePlanActivePlansResult.jsp="+e.toString());
		e.printStackTrace();
	}
}

            _bw.write(_wl_block21Bytes, _wl_block21);
            _bw.write(_wl_block22Bytes, _wl_block22);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
