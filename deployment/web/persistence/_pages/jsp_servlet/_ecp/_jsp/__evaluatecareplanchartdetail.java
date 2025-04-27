package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;

public final class __evaluatecareplanchartdetail extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/EvaluateCarePlanChartDetail.jsp", 1709116580387L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\' type=\'text/css\'></link></head>\n\t<body>\n\t<script language=javascript>\n\tdocument.body.style.scrollbarBaseColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarArrowColor=\'#000080\';\n\tdocument.body.style.scrollbarDarkShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarFaceColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbarHighlightColor=\'white\';\n\tdocument.body.style.scrollbarShadowColor=\'#E2E3F0\';\n\tdocument.body.style.scrollbar3dlightColor=\'#E2E3F0\';\n\t</script>\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=0>\n\t\t<tr>\n\t\t\t<td class=\'label\'><B>";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="</B></td>\n\t\t</tr>\n\t</table>\n\t<applet code=\"barchartApplet\" archive=\"CPChartApplet.jar\" codebase=\".\" width=\"650\" height=\"500\">\n\t\t<param name=\'chart_data\' value=\'Bar|";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="| Evaluated Dates|1|11|0|0|100\'>\n\t\t<param name=font\t\tvalue=\"Arial,0,11\">\n\t\t<param name=fontL\t\tvalue=\"Arial,1,14\">\n\t\t<param name=fontT\t\tvalue=\"Dialog,3,15\">\n\t\t<param name=origine\t\tvalue=\"60,110\">\n\t\t<param name=bgcolor \tvalue=\"#D0F0FF\">\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n \t\t<param name=\'title\' value=\'title|";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>\n\t\t<param name=\'label\' value=\'label|Evaluated Dates|Score\'>\n \t\t<param name=\'series_count\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n\t\t<param name=\'data_count\' value=\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\'>\n \t\t<param name=\'series0\' value=\' col|";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="|20024080\'>\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t<param name=\'label";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\' value=\'";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<param name=\'series0data";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n \t<param name=\'complete_data\' value=\'";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\'>\n\t</applet>\n\t</body>\n\t<html>\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

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

request.setCharacterEncoding("UTF-8");
String locale=(String)session.getAttribute("LOCALE");
//This file is saved on 19/10/2005.
Connection con = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{
	con = ConnectionManager.getConnection(request);
	String comp	=	request.getParameter("comp")== null?"":request.getParameter("comp");
	String care_plan_id	=	request.getParameter("care_plan_id")== null?"":request.getParameter("care_plan_id");
	String md_plan_id	=	request.getParameter("md_plan_id")== null?"":request.getParameter("md_plan_id");
	String term_set_id	=	request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
	String term_code	=	request.getParameter("term_code")== null?"":request.getParameter("term_code");
	String term_code_srl_no	=	request.getParameter("term_code_srl_no")== null?"":request.getParameter("term_code_srl_no");
	String goal_code	=	request.getParameter("goal_code")== null?"":request.getParameter("goal_code");
	String goal_srl_no	=	request.getParameter("goal_srl_no")== null?"":request.getParameter("goal_srl_no");
	String outcome_code	=	request.getParameter("outcome_code")== null?"":request.getParameter("outcome_code");
	String outcome_srl_no	=	request.getParameter("outcome_srl_no")== null?"":request.getParameter("outcome_srl_no");
	ArrayList Date_List =new ArrayList();
	ArrayList Data_List =new ArrayList();

	String description = "";
	String desc = "";
	String event = "";
	//String progress_percent = "";
	//String last_eval_date = "";
	StringBuffer complete_data=new StringBuffer();
	int data_count = 0;
	int series_count=1;

	if(comp.equals("D"))
	{
		String sql_diag	 ="select b.short_desc description,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent from cp_pat_term_code_eval a,mr_term_code b where md_care_plan_id=? and care_plan_id=? and a.term_set_id = ? and a.term_code=? and term_code_srl_no=? and a.status='V' and a.term_code = b.term_code and a.term_set_id = b.term_set_id order by last_eval_datetime";
		pstmt = con.prepareStatement(sql_diag);
		pstmt.setString(1, md_plan_id);
		pstmt.setString(2, care_plan_id);
		pstmt.setString(3, term_set_id);
		pstmt.setString(4, term_code);
		pstmt.setString(5, term_code_srl_no);
		rs = pstmt.executeQuery();
	}
	else if(comp.equals("G"))
	{
//		String sql_goal ="select b.short_desc description,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent from cp_pat_goal_eval a,cp_outcome b where md_care_plan_id=? and care_plan_id=? and term_set_id = ?  and term_code=? and term_code_srl_no=? and goal_code=? and goal_srl_no=?  and a.status = 'V' and b.outcome_code = a.goal_code order by last_eval_datetime";
		String sql_goal ="SELECT b.short_desc description,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent FROM cp_pat_goal_eval a,cp_outcome_lang_vw b WHERE md_care_plan_id=? AND care_plan_id=? AND term_set_id = ?  AND term_code=? AND term_code_srl_no=? AND goal_code=? AND goal_srl_no=?  AND a.status = 'V' AND b.outcome_code = a.goal_code AND b.language_id = ? ORDER BY last_eval_datetime";
		pstmt = con.prepareStatement(sql_goal);
		pstmt.setString(1, md_plan_id);
		pstmt.setString(2, care_plan_id);
		pstmt.setString(3, term_set_id);
		pstmt.setString(4, term_code);
		pstmt.setString(5, term_code_srl_no);
		pstmt.setString(6, goal_code);
		pstmt.setString(7, goal_srl_no);
		pstmt.setString(8, locale);
		rs = pstmt.executeQuery();
	}
	else if(comp.equals("O"))
	{
//		String sql_outcome ="SELECT b.short_desc description,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent  FROM cp_pat_outcome_eval a ,cp_outcome b WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  and a.status = 'V' and a.outcome_code = b.outcome_code ORDER BY a.last_eval_datetime";
		String sql_outcome ="SELECT b.short_desc description,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date,progress_percent  FROM cp_pat_outcome_eval a ,cp_outcome_lang_vw b WHERE a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  AND a.status = 'V' AND a.outcome_code = b.outcome_code AND b.language_id = ? ORDER BY a.last_eval_datetime";
		pstmt = con.prepareStatement(sql_outcome);
		pstmt.setString(1, md_plan_id);
		pstmt.setString(2, care_plan_id);
		pstmt.setString(3, term_set_id);
		pstmt.setString(4, term_code);
		pstmt.setString(5, term_code_srl_no);
		pstmt.setString(6, goal_code);
		pstmt.setString(7, goal_srl_no);
		pstmt.setString(8, outcome_code);
		pstmt.setString(9, outcome_srl_no);
		pstmt.setString(10, locale);
		rs = pstmt.executeQuery();
	}

            _bw.write(_wl_block2Bytes, _wl_block2);

String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(series_count));
            _bw.write(_wl_block6Bytes, _wl_block6);

	if(rs!=null)
	{
		while(rs.next())
		{
			Data_List.add(rs.getString("progress_percent")==null?"":rs.getString("progress_percent"));
			Date_List.add(rs.getString("last_eval_date")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date"),"DMYHM","en",locale));
			description = rs.getString("description")==null?"":rs.getString("description");
		}
	}
	if(comp.equals("D"))
	{
		event = "Diagnosis";
		desc = "Diagnosis:  "+description;
	}
	else if(comp.equals("G"))
	{
		event = "Goal";
		desc = "Goal:  "+description;
	}
	else if(comp.equals("O"))
	{
		event = "Outcome";
		desc = "Outcome:  "+description;
	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	data_count=Data_List.size();

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(desc));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(series_count));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(data_count));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(event));
            _bw.write(_wl_block11Bytes, _wl_block11);

		complete_data.append("title|"+desc+"~label|Evaluated Dates|Score ~ col|"+event+"|20024080");
		for(int i=0;i<data_count;i++){
			complete_data.append("~"+Date_List.get(i)+"|"+Data_List.get(i));
		}
		for(int i=0;i<data_count ;i++){

            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Date_List.get(i)));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}
		for(int i=0;i<data_count ;i++){

            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(i));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(Data_List.get(i)));
            _bw.write(_wl_block14Bytes, _wl_block14);

		}

            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(complete_data));
            _bw.write(_wl_block17Bytes, _wl_block17);

}
catch(Exception e1)
{
	out.println("main "+e1);
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
		// out.println(e.toString());//COMMON-ICN-0181
                  e.printStackTrace();//COMMON-ICN-0181
	}
}

            _bw.write(_wl_block18Bytes, _wl_block18);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
