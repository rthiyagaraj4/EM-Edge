package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __evaluatecareplancomponenthistory extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/EvaluateCarePlanComponentHistory.jsp", 1709116520857L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n15/09/2012    IN033183        Chowminya G     Evaluation History In Care Plan - Duplicates\n---------------------------------------------------------------------------------------------------------------\n--> \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<title>";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="</title>\n\t\n<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\'></link></head>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n<body>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t<table width=\'100%\' cellspacing=\'0\' cellpadding=\'0\' border=0>\n\t<tr>\n\t\t<td colspan=\'28\' align=\'left\' class=\'Diag\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =":&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="<td>\n\t</tr>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="<td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'28\' align=\'left\' class=\'Goal\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =":&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="<td>\n\t</tr>\n\t<tr>\n\t\t<td colspan=\'28\' align=\'left\' class=\'Outcome\'>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 =":&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n</body>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</html>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

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
            _bw.write(_wl_block6Bytes, _wl_block6);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block7Bytes, _wl_block7);

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	String comp	=	request.getParameter("comp")== null?"":request.getParameter("comp");
	String care_plan_id	=	request.getParameter("care_plan_id")== null?"":request.getParameter("care_plan_id");
	String md_plan_id	=	request.getParameter("md_plan_id")== null?"":request.getParameter("md_plan_id");
	String term_set_id	=	request.getParameter("term_set_id")== null?"":request.getParameter("term_set_id");
	String term_code	=	request.getParameter("term_code")== null?"":request.getParameter("term_code");
	String term_code_srl_no	=	request.getParameter("term_code_srl_no")== null?"":request.getParameter("term_code_srl_no");
	String disp_text="-";
	String color="black";
	String goal_desc="";
	String diag_desc="";
	Connection con =	 null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	//System.err.println("comp="+comp+",Care Plan Id="+care_plan_id+", md plan id="+md_plan_id+",term set id ="+term_set_id+",term code="+term_code+",term code srl no="+term_code_srl_no);

            _bw.write(_wl_block10Bytes, _wl_block10);

	try{
		con = ConnectionManager.getConnection(request);
		if(comp.equals("D")){
			diag_desc	=	request.getParameter("diag_desc")== null?"":request.getParameter("diag_desc");//--[IN033183]
//			String sql_diag	 ="select b.short_desc diag_desc,to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, short_name last_eval_by, progress_percent from cp_pat_term_code_eval a,am_practitioner ,mr_term_code b where md_care_plan_id=? and care_plan_id=? and a.term_set_id = ? and a.term_code=? and term_code_srl_no=? and practitioner_id = last_eval_by and a.status='V' and a.term_code = b.term_code order by last_eval_datetime desc";
			//String sql_diag	 ="SELECT b.short_desc diag_desc,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, c.short_name last_eval_by, progress_percent FROM cp_pat_term_code_eval a,am_practitioner_lang_vw c ,mr_term_code b WHERE md_care_plan_id=? AND care_plan_id=? AND a.term_set_id = ? AND a.term_code=? AND term_code_srl_no=? AND c.practitioner_id = last_eval_by AND a.status='V' AND a.term_code = b.term_code AND c.language_id = ? ORDER BY last_eval_datetime DESC"; //Commentted --[IN033183]
			String sql_diag	 ="SELECT b.short_desc diag_desc,TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, c.short_name last_eval_by, progress_percent FROM cp_pat_term_code_eval a,am_practitioner_lang_vw c ,mr_term_code b WHERE md_care_plan_id=? AND care_plan_id=? AND a.term_set_id = ? AND a.term_code=? AND term_code_srl_no=? AND c.practitioner_id = last_eval_by AND a.status='V' AND a.term_code = b.term_code AND a.term_set_id = b.term_set_id AND c.language_id = ? ORDER BY last_eval_datetime DESC";//--[IN033183]
			
			pstmt = con.prepareStatement(sql_diag);
			pstmt.setString(1, md_plan_id);
			pstmt.setString(2, care_plan_id);
			pstmt.setString(3, term_set_id);
			pstmt.setString(4, term_code);
			pstmt.setString(5, term_code_srl_no);
			pstmt.setString(6, locale);
			rs = pstmt.executeQuery();
			/*if(rs.next())
			{
				diag_desc	=	rs.getString("diag_desc");
			}*/ //Commentted--[IN033183]

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
		}
		else if(comp.equals("G")){
			String goal_code	=	request.getParameter("goal_code")== null?"":request.getParameter("goal_code");
			String goal_srl_no	=	request.getParameter("goal_srl_no")== null?"":request.getParameter("goal_srl_no");
			goal_desc	=	request.getParameter("goal_desc")== null?"":request.getParameter("goal_desc");
			diag_desc	=	request.getParameter("diag_desc")== null?"":request.getParameter("diag_desc");
			//String sql_goal ="select to_char(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, short_name last_eval_by, progress_percent from cp_pat_goal_eval a, am_practitioner where md_care_plan_id=? and care_plan_id=? and term_set_id = ?  and term_code=? and term_code_srl_no=? and goal_code=? and goal_srl_no=? and practitioner_id = last_eval_by and a.status = 'V' order by last_eval_datetime desc";
			String sql_goal ="SELECT TO_CHAR(last_eval_datetime,'dd/mm/yyyy hh24:mi')last_eval_date, b.short_name last_eval_by, progress_percent FROM cp_pat_goal_eval a, am_practitioner_lang_vw b WHERE md_care_plan_id=? AND care_plan_id=? AND term_set_id = ?  AND term_code=? AND term_code_srl_no=? AND goal_code=? AND goal_srl_no=? AND b.practitioner_id = last_eval_by AND a.status = 'V' AND b.language_id = ? ORDER BY last_eval_datetime DESC";
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

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(goal_desc));
            _bw.write(_wl_block13Bytes, _wl_block13);
		}
		else if(comp.equals("O")){
			String goal_code	=	request.getParameter("goal_code")== null?"":request.getParameter("goal_code");
			String goal_srl_no	=	request.getParameter("goal_srl_no")== null?"":request.getParameter("goal_srl_no");
			String outcome_code	=	request.getParameter("outcome_code")== null?"":request.getParameter("outcome_code");
			String outcome_srl_no	=	request.getParameter("outcome_srl_no")== null?"":request.getParameter("outcome_srl_no");
			//System.err.println("goal code ="+goal_code+" ,goal srl no="+goal_srl_no+" ,outcome code ="+outcome_code+", outcome srl no="+outcome_srl_no);
			String sql_term_desc = "select short_desc||'('||term_code||')' diag_desc from mr_term_code where term_set_id = ? and term_code = ?";
			pstmt = con.prepareStatement(sql_term_desc);
			pstmt.setString(1, term_set_id);
			pstmt.setString(2, term_code);
			rs = pstmt.executeQuery();
			if(rs!=null)
				if(rs.next())
					diag_desc = rs.getString("diag_desc");
			//String sql_goal_desc = "select short_desc goal_desc from cp_outcome where outcome_code=?";
			String sql_goal_desc = "SELECT short_desc goal_desc FROM cp_outcome_lang_vw WHERE outcome_code=? AND language_id = ?";
			pstmt = con.prepareStatement(sql_goal_desc);
			pstmt.setString(1, goal_code);
			pstmt.setString(2, locale);
			rs = pstmt.executeQuery();
			if(rs!=null)
				if(rs.next())
					goal_desc = rs.getString("goal_desc");
//			String sql_outcome ="SELECT   b.short_desc outcome_desc,TO_CHAR (a.last_eval_datetime, 'dd/mm/yyyy hh24:mi') last_eval_date,short_name last_eval_by, a.progress_percent progress_percent FROM cp_pat_outcome_eval a, am_practitioner,cp_outcome b WHERE b.outcome_code=a.outcome_code and a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  and practitioner_id = a.last_eval_by and a.status = 'V' ORDER BY a.last_eval_datetime DESC";
			String sql_outcome ="SELECT   b.short_desc outcome_desc,TO_CHAR (a.last_eval_datetime, 'dd/mm/yyyy hh24:mi') last_eval_date,c.short_name last_eval_by, a.progress_percent progress_percent FROM cp_pat_outcome_eval a, am_practitioner_lang_vw c,cp_outcome_lang_vw b WHERE b.outcome_code=a.outcome_code AND a.md_care_plan_id = ? AND a.care_plan_id = ? AND a.term_set_id = ? AND a.term_code = ? AND a.term_code_srl_no = ? AND a.goal_code = ? AND a.goal_srl_no = ? AND a.outcome_code = ? AND a.outcome_srl_no = ?  AND c.practitioner_id = a.last_eval_by AND a.status = 'V' AND c.language_id = ? AND b.language_id = ? ORDER BY a.last_eval_datetime DESC";
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
			pstmt.setString(11, locale);
			rs = pstmt.executeQuery();
			if(rs!=null){
				if(rs.next())
				{

            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(diag_desc));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(goal_desc));
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(rs.getString("outcome_desc")));
            _bw.write(_wl_block13Bytes, _wl_block13);

				String last_eval_date = rs.getString("last_eval_date")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date"),"DMYHM","en",locale);
				String last_eval_by = rs.getString("last_eval_by")==null?"":rs.getString("last_eval_by");
				String progress_percent = rs.getString("progress_percent")==null?"0":rs.getString("progress_percent");
				int int_progress	= Integer.parseInt(progress_percent);
				out.println("<tr><td  width='20%' class='List'>"+last_eval_date +"</td>");
				out.println("<td width='50%' class='List'>"+last_eval_by +"</td>");
				for(int i=0;i<=100; i+=4){
					if(i==0){
						disp_text="<b>[</b>";
					}
					else 	if(i==100){
						disp_text="<b>]</b>";
					}
					else{
						disp_text="-";
					}
					color="black";

					if(i==int_progress){
						if(int_progress == 0){
							disp_text="<b>[</b>";
							color="red";
						}
						else if(int_progress == 100){
							disp_text="<b>]</b>";
							color="green";
						}
						else{
							disp_text ="|";
							color="black";
						}
					}
					out.println("<td width='8' class='List'><font color="+color+">"+disp_text+"</font></td>");
				}
			}
			}
		}
		while((rs != null)&&rs.next())
		{
				String last_eval_date = rs.getString("last_eval_date")==null?"":com.ehis.util.DateUtils.convertDate(rs.getString("last_eval_date"),"DMYHM","en",locale);
				String last_eval_by = rs.getString("last_eval_by")==null?"":rs.getString("last_eval_by");
				String progress_percent = rs.getString("progress_percent")==null?"0":rs.getString("progress_percent");
				int int_progress	= Integer.parseInt(progress_percent);
				out.println("<tr><td class='List' width='35%'>"+last_eval_date +"</td>");
				out.println("<td class='List' width='50%'>"+last_eval_by +"</td>");
				for(int i=0;i<=100; i+=4){
					if(i==0){
						disp_text="<b>[</b>";
					}
					else 	if(i==100){
						disp_text="<b>]</b>";
					}
					else{
						disp_text="-";
					}
					color="black";

					if(i==int_progress){
						if(int_progress == 0){
							disp_text="<b>[</b>";
							color="red";
						}
						else if(int_progress == 100){
							disp_text="<b>]</b>";
							color="green";
						}
						else{
							disp_text ="|";
							color="black";
						}
					}
					out.println("<td width='8' class='List'><font color="+color+">"+disp_text+"</font></td>");
				}
				out.println("</tr>");

            _bw.write(_wl_block18Bytes, _wl_block18);
	}
		if(pstmt !=null)
			pstmt.close();
}catch(Exception e){
	//out.println(e);//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally{
	if(rs!=null)rs.close();
	if(pstmt !=null)
		pstmt.close();
	if(con != null)
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block19Bytes, _wl_block19);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.EvaluationHistory.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Goal.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.diagnosis.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.Goal.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.outcome.label", java.lang.String .class,"key"));
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
}
