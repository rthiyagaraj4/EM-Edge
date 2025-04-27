package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eCommon.XSSRequestWrapper;
import java.sql.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __viewcareplanintvnandoutcomelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/ViewCarePlanIntvnAndOutcomeList.jsp", 1709116629027L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<head>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\' type=\'text/css\'></link>\n<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link>\n<script language=\"JavaScript\" src=\"../../eCP/js/common.js\" ></script>\n<script language=\"JavaScript\"src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\"src=\"../../eCommon/js/messages.js\" language=\"JavaScript\"></script>\n<script type=\"text/javascript\" src=\"../../eCommon/js/CommonCalendar.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/CommonLookup.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/MstCodeCommon.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../../eCP/js/ViewCarePlan.js\" language=\"JavaScript\"></script>\n<script language=\"JavaScript\" src=\"../../eCP/js/CpMessages.js\" language=\"JavaScript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n</head>\n<body OnMouseDown=\'CodeArrest()\'>\n<form name=\'view_cp_intvnandoutcomelist\' id=\'view_cp_intvnandoutcomelist\'>\n<table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\"100%\" align=\'center\' id=\"outcometable\" >\n\t<tr>\n\t\t<td class=\'ITRVNHDR\' width=\'39%\' align=\'left\'><B>Intervention</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'15%\' align=\'left\'><B>Status</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'30%\' align=\'left\'><B>&nbsp;&nbsp;Outcome</B></th>\n\t\t<td class=\'ITRVNHDR\' colspan=\'29\' nowrap align=\'left\'><B>Evaluation Score</B></th>\n\t\t<td class=\'ITRVNHDR\' width=\'*%\' colspan=\'2\' align=\'right\'><B>Reset</B></td>\n\t</tr>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<TR>\n\t\t\t\t<TD class=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</TD>\n\t\t\t\t<TD class=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</TD>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t</TR>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\n</table>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</table>\n<INPUT TYPE=\"hidden\" name=\"outcome_count\" id=\"outcome_count\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n<INPUT TYPE=\"hidden\" name=\"care_plan_id\" id=\"care_plan_id\" value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\">\n<INPUT TYPE=\"hidden\" name=\"md_plan_id\" id=\"md_plan_id\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\">\n</form>\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block5Bytes, _wl_block5);

Connection con = null;
PreparedStatement stmt_intvn = null;
ResultSet rs_intvn = null;
PreparedStatement stmt_outcome = null;
ResultSet  rs_outcome = null;
Statement stmt_outcome_msr_id = null;
ResultSet  rs_outcome_msr_id = null;

String care_plan_id = request.getParameter("planid")==null?"":request.getParameter("planid");
String md_plan_id = request.getParameter("md_plan_id")==null?"":request.getParameter("md_plan_id");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
String goal_code = request.getParameter("goal_code")==null?"":request.getParameter("goal_code");


String evaluation_allowed_yn = "";
String onclickwork_outcome = "";
String onclickchgcolorfr = "";
String onclickchgcolorbac = "";
int outcome_count = 1;
String classvalue="ROWODD";
String sql_outcome = "";
String eval_id = request.getParameter("eval_id")==null?"":request.getParameter("eval_id");
String msrlookupdisabled="";

try
{
	con = ConnectionManager.getConnection(request);
	//String sql_intvn = "select a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,decode(a.status,'O','Pending','D','Discontinued','9','Cancelled','P','Partially Completed','A','Achieved','N','Not Achieved') status from cp_pat_care_plan_intvn a, ca_intervention b where a.md_care_plan_id = ? and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code) and a.appl_yn = 'Y' and b.intervention_code = a.intervention_code order by a.term_set_id,a.term_code,a.group_id,a.intervention_code";//CRF-33
	String sql_intvn = "select a.term_set_id term_set_id,a.term_code term_code,a.goal_code goal_code,a.group_id group_id_intvn,a.intervention_code,b.short_desc intvn_desc,b.lmt_for_tsk_due_bf_st_tm,b.lmt_for_tsk_due_bf_st_tm_unit,       b.lmt_for_tsk_odue_af_st_tm,b.lmt_for_tsk_odue_af_st_tm_unit,       b.lmt_for_tsk_exp_af_end_tm,b.lmt_for_tsk_exp_af_end_tm_unit,decode(a.status,'O','Pending','D','Discontinued','9','Cancelled','P','Partially Completed','A','Achieved','N','Not Achieved','C','Completed') status from cp_pat_care_plan_intvn a, ca_intervention b where a.md_care_plan_id = ? and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code) and a.appl_yn = 'Y' and b.intervention_code = a.intervention_code order by a.term_set_id,a.term_code,a.group_id,a.intervention_code";//CRF-33
sql_outcome = "select a.LAST_EVAL_OUTCOME_MSR_ID,a.term_set_id term_set_id,a.term_code term_code,a.term_code_srl_no term_code_srl_no,a.goal_code goal_code,a.goal_srl_no goal_srl_no,a.group_id group_id_outcome,a.outcome_code outcome_code,a.outcome_srl_no outcome_srl_no,b.short_desc outcome_desc,e.progress_percent outcome_prog_pct,a.status outcome_status,c.status term_code_status, d.status goal_status,a.last_eval_by pract_id_outcome from cp_pat_care_plan_outcome a, cp_outcome b,cp_pat_care_plan_term_code c, cp_pat_care_plan_goal d,cp_pat_outcome_eval e,CP_OUTCOME_MSR f where a.md_care_plan_id = ?  and a.care_plan_id = ? and a.term_set_id = nvl(?,a.term_set_id) and a.term_code = nvl(?,a.term_code) and a.goal_code = nvl(?,a.goal_code)   and a.appl_yn = 'Y' and b.outcome_code = a.outcome_code and c.md_care_plan_id = a.md_care_plan_id and c.care_plan_id = a.care_plan_id and c.term_set_id = a.term_set_id   and c.term_code = a.term_code and b.outcome_code = e.outcome_code and d.md_care_plan_id = a.md_care_plan_id and d.care_plan_id = a.care_plan_id and d.term_set_id = a.term_set_id and d.term_code = a.term_code and d.goal_code = a.goal_code and e.md_care_plan_id = a.md_care_plan_id and e.care_plan_id = a.care_plan_id and e.OUTCOME_MSR_ID =f.OUTCOME_MSR_ID and e.eval_id = ? order by a.term_set_id,a.term_code,a.group_id,a.outcome_code";


		
	stmt_intvn = con.prepareStatement(sql_intvn);
	stmt_intvn.setString(1,md_plan_id);
	stmt_intvn.setString(2,care_plan_id);
	stmt_intvn.setString(3,term_set_id);
	stmt_intvn.setString(4,term_code);
	stmt_intvn.setString(5,goal_code);
	rs_intvn = stmt_intvn.executeQuery();

	stmt_outcome = con.prepareStatement(sql_outcome,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_UPDATABLE);

		stmt_outcome.setString(1,md_plan_id);
		stmt_outcome.setString(2,care_plan_id);
		stmt_outcome.setString(3,term_set_id);
		stmt_outcome.setString(4,term_code);
		stmt_outcome.setString(5,goal_code);
		stmt_outcome.setString(6,eval_id);

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
	record.clear();
	ArrayList result = new ArrayList();
	result.clear();

	if(rs_intvn!=null)
	{
		while(rs_intvn.next())
		{
			ItermSet=rs_intvn.getString("term_set_id");
			ItermCode=rs_intvn.getString("term_code");
			Igrpid=rs_intvn.getString("group_id_intvn");
			IDesc=rs_intvn.getString("intvn_desc");
			Istatus=rs_intvn.getString("status");
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

            _bw.write(_wl_block6Bytes, _wl_block6);

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
	 				result.set(k+13,"");					
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
					result.add("");
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
			outcome_desc = (String)	result.get(i+2);

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(result.get(i)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(result.get(i+1)));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(outcome_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);

			//outcome_desc = (String)	result.get(i+2);
			term_code_status = (String)result.get(i+3);
			goal_status = (String)result.get(i+4);
			outcome_status = (String)result.get(i+5);
			outcome_code = (String) result.get(i+9);
			outcomeMsrid=(String)result.get(i+16);

			if(!outcome_code.equals("")){
				if(!outcomeMsrid.equals("")){
					outcomeMsrsql="Select OUTCOME_MSR_DESC from CP_OUTCOME_MSR where OUTCOME_MSR_ID='"+outcomeMsrid+"' and OUTCOME_CODE='"+outcome_code+"'";
					//System.err.println("outcomeMsrsql "+outcomeMsrsql);
					stmt_outcome_msr_id	=	con.createStatement();
					rs_outcome_msr_id	=	stmt_outcome_msr_id.executeQuery(outcomeMsrsql);
					if(rs_outcome_msr_id!=null){
						rs_outcome_msr_id.next();
						outcomeMsrDesc=rs_outcome_msr_id.getString("OUTCOME_MSR_DESC");
					}

				}
			}
			if(stmt_outcome_msr_id!=null) stmt_outcome_msr_id.close();
			if(rs_outcome_msr_id!=null) rs_outcome_msr_id.close();
			
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
				 onclickwork_outcome = "";
				 onclickchgcolorfr = "";
				 onclickchgcolorbac = "";

			
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
					out.println("<td class='"+fontvals+"' width='1%' onclick='showOutcomeHistory(\"error_mode\"\""+termsetid+"\",\""+termcode+"\",\""+term_code_srl_no+"\",\""+goal_cde+"\",\""+goal_srl_no+"\",\""+outcome_code+"\",\""+outcome_srl_no+"\",\""+outcome_desc+"\")'>H</td>");
				}
				else{
					out.println("<td class='"+fontvals+"' width='1%'>&nbsp;</td>");
				}
					out.println("<td class='"+classvalue+"' colspan='2'>&nbsp;</td>");
				// Added on nov 8
			
					//End
				out.println("<td class='"+fontvals+"' width='10%'  colsapn='2' id='ids27"+outcome_count+"' onclick=resetval(this,"+outcome_pct+","+outcome_count+",'Outcome') align='center'><B>&nbsp;</B></td>");
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
				outcome_count++;
			}
			else
			{
				out.println("<td align='center' colspan='32' class='"+classvalue+"'>&nbsp;</td>");
			}
			msrlookupdisabled="";

            _bw.write(_wl_block12Bytes, _wl_block12);

		outcomeMsrDesc="";
		}
	}

            _bw.write(_wl_block13Bytes, _wl_block13);

}
catch(Exception e)
{
	e.printStackTrace(System.err);
	System.out.println("Exception in ViewCarePlanIntvnAndOutcomeList.jsp="+e.toString());
}
finally
{
	if(rs_intvn!=null) rs_intvn.close();
	if(rs_outcome!=null) rs_outcome.close();
	if(stmt_intvn!=null) stmt_intvn.close();
	if(stmt_outcome!=null) stmt_outcome.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(outcome_count));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(care_plan_id));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(md_plan_id));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
