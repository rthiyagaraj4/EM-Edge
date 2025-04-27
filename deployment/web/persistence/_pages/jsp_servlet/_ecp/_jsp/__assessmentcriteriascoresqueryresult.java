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

public final class __assessmentcriteriascoresqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AssessmentCriteriaScoresQueryResult.jsp", 1724909958208L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n*\tCopyright © MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teCP\n*\tPurpose \t\t:\t\n*\tCreated By\t\t:\tVinay\n*\tCreated On\t\t:\t11 Feb 05\n-->\n<html>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<!-- <script language=\"JavaScript\" src=\"../../eCP/js/common.js\"></script> -->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../js/AssessmentCriteriaScore.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\nfunction submitPrevNext(from, to,assess_note,assess_desc,catg_code,catg_desc)\n{\nparent.f_query_add_mod.location.href=\"../../eCP/jsp/AssessmentCriteriaScoresQueryResult.jsp?from=\"+from+\"&to=\"+to+\"&assess_note=\"+assess_note+\"&assess_desc=\"+assess_desc+\"&catg_code=\"+catg_code+\"&catg_desc=\"+catg_desc;\n}\n</script>\n</head>\n<body onKeyDown=\"lockKey()\" OnMouseDown=\'CodeArrest()\'> \n<form METHOD=POST target=\'messageFrame\' ACTION=\"\" name=\'assess_crit_score_result\' id=\'assess_crit_score_result\'>\n<table width=\'95%\'>\n<tr>\n<td align=\'right\'  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>\n<input type=hidden name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\">\n<input type=hidden name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\">\n<input type=hidden name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\">\n<input type=hidden name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =",";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =",\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\",\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\")\'>";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="</a>\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n</td>\n</tr>\n</table>\n<TABLE border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'right\'>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\t\n\t\t\t<TR>\n\t\t\t\t<TH>";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="</TH>\n\t\t\t\t<TH nowrap>";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="</TH>\n\t\t\t\t<TH>";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="</TH>\n\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t<script>alert(getMessage(\"NO_RECORD_FOUND_FOR_CRITERIA\",\"Common\"));history.go(-1);</script>\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n</TABLE>\n</form>\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

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

	 //This file is saved on 01/12/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con = null;
Statement stmt = null;
ResultSet rs = null;
PreparedStatement pstmt = null;//common-icn-0180
String assess_note = request.getParameter("assess_note")==null?"":request.getParameter("assess_note");
String assess_desc = request.getParameter("assess_desc")==null?"":request.getParameter("assess_desc");
String catg_code = request.getParameter("catg_code")==null?"":request.getParameter("catg_code");
String catg_desc = request.getParameter("catg_desc")==null?"":request.getParameter("catg_desc");
assess_note = assess_note.toUpperCase();
assess_desc = assess_desc.toUpperCase();
catg_code = catg_code.toUpperCase();
catg_desc = catg_desc.toUpperCase();
String whereClause = "and a.assess_note_id like '"+assess_note+"%'and a.assess_catg_code like '"+catg_code+"%' and upper(c.assess_note_desc) like '"+assess_desc+"%' and upper(b.long_desc) like '"+catg_desc+"%'";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
try
{
	con = ConnectionManager.getConnection(request);
	from = request.getParameter("from") ;
	to = request.getParameter("to") ;
	int maxRecord = 0;
	int maxRecordnum = 0;
	int maxRecordlist = 0;
	int start = 0 ;
	int end = 0 ;
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 10 ; }   else {  end = Integer.parseInt( to ) ; }
	stmt = con.createStatement();
	/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
	String sql_cnt_num = "select count(*) from cp_assess_num_crit_score a,cp_assess_catg b,	cp_assess_note c,am_discr_msr d where 	a.assess_note_id = c.assess_note_id "+whereClause+" and a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id";
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/
	String sql_cnt_list = "select count(*) from cp_assess_list_crit_score a,cp_assess_catg b,cp_assess_note c,am_discr_msr d,am_discr_msr_ref_rng_list e where 	a.assess_note_id = c.assess_note_id "+whereClause+"  and a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id and a.comp_id = e.discr_msr_id(+) and a.list_item_id = e.result_value(+)";
	rs = stmt.executeQuery(sql_cnt_num);
	if(rs!=null)
	{
		if(rs.next())
		{
			maxRecordnum = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	stmt = con.createStatement();
	rs = stmt.executeQuery(sql_cnt_list);
	if(rs!=null)
	{
		if(rs.next())
		{
			maxRecordlist = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
    maxRecord = maxRecordnum + maxRecordlist;

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(start));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(end));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(start));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(end));
            _bw.write(_wl_block13Bytes, _wl_block13);

	if ( !(start <= 1))
	{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start-10)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((end-10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(assess_note));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(assess_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(catg_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(catg_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	}
	if ( !((start+10) > maxRecord ))
	{

            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf((start+10)));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf((end+10)));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(assess_note));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(assess_desc));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(catg_code));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(catg_desc));
            _bw.write(_wl_block18Bytes, _wl_block18);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block19Bytes, _wl_block19);

	}

            _bw.write(_wl_block20Bytes, _wl_block20);

	if(maxRecord != 0 )
	{
		
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag7(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag8(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block23Bytes, _wl_block23);

            if (_jsp__tag9(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block24Bytes, _wl_block24);

	}
		/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
//	String sql = "select a.assess_note_id assess_note_id,c.assess_note_desc assess_note_desc,a.assess_catg_code assess_catg_code,b.long_desc assess_catg_desc,a.comp_id,d.short_desc comp_desc,	a.normal_rng_low, a.normal_rng_high,a.normal_score,a.abnormal_rng_low, a.abnormal_rng_high,a.abnormal_score,a.critical_rng_low, a.critical_rng_high,a.critical_score,to_char(null) list_item_id, to_char(null) list_item_text ,to_number(null) score,d.result_type comp_type from cp_assess_num_crit_score a,cp_assess_catg b,cp_assess_note c,am_discr_msr d where a.assess_note_id = c.assess_note_id "+whereClause+" and a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id union all select	a.assess_note_id,c.assess_note_desc,a.assess_catg_code,b.long_desc,a.comp_id,d.short_desc comp_desc,to_number(null) normal_rng_low, to_number(null) normal_rng_high,to_number(null) normal_score,to_number(null) abnormal_rng_low, to_number(null) abnormal_rng_high,to_number(null) abnormal_score,	to_number(null) critical_rng_low, to_number(null) critical_rng_high,to_number(null) critical_score,a.list_item_id list_item_id,e.ref_rng_desc list_item_text, score,d.result_type comp_type from cp_assess_list_crit_score a,cp_assess_catg b,cp_assess_note c,am_discr_msr d,am_discr_msr_ref_rng_list e where 	a.assess_note_id = c.assess_note_id "+whereClause+" and	a.assess_catg_code = b.assess_catg_code and	a.comp_id = d.discr_msr_id and a.comp_id = e.discr_msr_id(+) and a.list_item_id = e.result_value(+) order by assess_catg_desc";
	//String sql = "SELECT a.assess_note_id assess_note_id,c.assess_note_desc assess_note_desc,a.assess_catg_code assess_catg_code,b.long_desc assess_catg_desc,a.comp_id,d.short_desc comp_desc,	a.normal_rng_low, a.normal_rng_high,a.normal_score,a.abnormal_rng_low, a.abnormal_rng_high,a.abnormal_score,a.critical_rng_low, a.critical_rng_high,a.critical_score,TO_CHAR(NULL) list_item_id, TO_CHAR(NULL) list_item_text ,TO_NUMBER(NULL) score,d.result_type comp_type FROM cp_assess_num_crit_score a,cp_assess_catg_lang_vw b,cp_assess_note_lang_vw c,am_discr_msr_lang_vw d WHERE a.assess_note_id = c.assess_note_id "+whereClause+" AND a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND B.LANGUAGE_ID = '"+locale+"' AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID UNION ALL SELECT	a.assess_note_id,c.assess_note_desc,a.assess_catg_code,b.long_desc,a.comp_id,d.short_desc comp_desc,TO_NUMBER(NULL) normal_rng_low, TO_NUMBER(NULL) normal_rng_high,TO_NUMBER(NULL) normal_score,TO_NUMBER(NULL) abnormal_rng_low, TO_NUMBER(NULL) abnormal_rng_high,TO_NUMBER(NULL) abnormal_score,	TO_NUMBER(NULL) critical_rng_low, TO_NUMBER(NULL) critical_rng_high,TO_NUMBER(NULL) critical_score,a.list_item_id list_item_id,e.ref_rng_desc list_item_text, score,d.result_type comp_type FROM cp_assess_list_crit_score a,cp_assess_catg_LANG_VW b,cp_assess_note_LANG_VW c,am_discr_msr_LANG_VW d,am_discr_msr_ref_rng_list e WHERE 	a.assess_note_id = c.assess_note_id "+whereClause+" AND	a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND a.comp_id = e.discr_msr_id(+) AND a.list_item_id = e.result_value(+) AND B.LANGUAGE_ID = '"+locale+"' AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY assess_catg_desc";//common-icn-0180
	String sql = "SELECT a.assess_note_id assess_note_id,c.assess_note_desc assess_note_desc,a.assess_catg_code assess_catg_code,b.long_desc assess_catg_desc,a.comp_id,d.short_desc comp_desc,	a.normal_rng_low, a.normal_rng_high,a.normal_score,a.abnormal_rng_low, a.abnormal_rng_high,a.abnormal_score,a.critical_rng_low, a.critical_rng_high,a.critical_score,TO_CHAR(NULL) list_item_id, TO_CHAR(NULL) list_item_text ,TO_NUMBER(NULL) score,d.result_type comp_type FROM cp_assess_num_crit_score a,cp_assess_catg_lang_vw b,cp_assess_note_lang_vw c,am_discr_msr_lang_vw d WHERE a.assess_note_id = c.assess_note_id "+whereClause+" AND a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID UNION ALL SELECT	a.assess_note_id,c.assess_note_desc,a.assess_catg_code,b.long_desc,a.comp_id,d.short_desc comp_desc,TO_NUMBER(NULL) normal_rng_low, TO_NUMBER(NULL) normal_rng_high,TO_NUMBER(NULL) normal_score,TO_NUMBER(NULL) abnormal_rng_low, TO_NUMBER(NULL) abnormal_rng_high,TO_NUMBER(NULL) abnormal_score,	TO_NUMBER(NULL) critical_rng_low, TO_NUMBER(NULL) critical_rng_high,TO_NUMBER(NULL) critical_score,a.list_item_id list_item_id,e.ref_rng_desc list_item_text, score,d.result_type comp_type FROM cp_assess_list_crit_score a,cp_assess_catg_LANG_VW b,cp_assess_note_LANG_VW c,am_discr_msr_LANG_VW d,am_discr_msr_ref_rng_list e WHERE 	a.assess_note_id = c.assess_note_id "+whereClause+" AND	a.assess_catg_code = b.assess_catg_code AND	a.comp_id = d.discr_msr_id AND a.comp_id = e.discr_msr_id(+) AND a.list_item_id = e.result_value(+) AND B.LANGUAGE_ID = ? AND C.LANGUAGE_ID = B.LANGUAGE_ID AND D.LANGUAGE_ID = B.LANGUAGE_ID ORDER BY assess_catg_desc";//common-icn-0180


	//stmt = con.createStatement();//common-icn-0180
	pstmt=con.prepareStatement(sql);//common-icn-0180
	pstmt.setString(1, locale);//common-icn-0180
	pstmt.setString(2, locale);//common-icn-0180
	//rs = stmt.executeQuery(sql);//common-icn-0180
	rs = pstmt.executeQuery();//common-icn-0180
	String className = "";
	String  assess_note_id = "";
	String  assess_note_desc = "";
	String  assess_catg_code = "";
	String  assess_catg_desc = "";
	String  comp_desc = "";
	String  comp_type = "";
	String comp_type_desc = "";
	String  resp = "";
	String  score = ""; 
	String  list_item_id = ""; 
	int i = 1;

	if(rs!=null)
	{
		if ( start != 0 )
		{
			for( int n=1; n<start; i++,n++ )
			{
				rs.next() ;
			}
		}
		while(rs.next() && i<=end )
		{
			if ( i % 2 == 0 )
				className = "QRYEVEN" ;
			else
				className = "QRYODD" ;
			assess_note_id = rs.getString("assess_note_id")==null?"&nbsp;":rs.getString("assess_note_id");
			assess_note_desc = rs.getString("assess_note_desc")==null?"&nbsp;":rs.getString("assess_note_desc");
			assess_catg_code = rs.getString("assess_catg_code")==null?"&nbsp;":rs.getString("assess_catg_code");
			assess_catg_desc = rs.getString("assess_catg_desc")==null?"&nbsp;":rs.getString("assess_catg_desc");
			comp_desc = rs.getString("comp_desc")==null?"&nbsp;":rs.getString("comp_desc");
			comp_type = rs.getString("comp_type")==null?"&nbsp;":rs.getString("comp_type");
			if(comp_type.equals("L"))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ListItem.label","common_labels");
			else if(comp_type.equals("C"))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckBox.label","common_labels");
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Numeric.label","common_labels");
			resp = rs.getString("list_item_text")==null?"&nbsp;":rs.getString("list_item_text");
			score = rs.getString("score")==null?"&nbsp;":rs.getString("score");
			if(comp_type.equals("C"))
			{
				list_item_id = rs.getString("list_item_id");
				if(list_item_id.equals("Y"))
					resp  = "Yes";
				else if(list_item_id.equals("N"))
					resp = "No";
			}
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
			{
				resp = "Normal (0-1) <BR> Abnormal (2-5) <BR> Critical (6-9)";
				score = ""+rs.getString("normal_score")+"<BR>"+rs.getString("abnormal_score")+"<BR>"+rs.getString("critical_score")+"";
			}
			  out.println("<tr>");
			  out.println("<td class='"+className+"'>"+assess_note_id+"</td>");
			  out.println("<td class='"+className+"'>"+assess_note_desc+"</td>");
			  out.println("<td class='"+className+"'>"+assess_catg_code+"</td>");
			  out.println("<td class='"+className+"'>"+assess_catg_desc+"</td>");
			  out.println("<td nowrap class='"+className+"'>"+comp_type_desc+"</td>");
			  out.println("<td nowrap class='"+className+"'>"+comp_desc+"</td>");
			  out.println("<td class='"+className+"'>"+resp+"</td>");
			  out.println("<td align='right' class='"+className+"'>"+score+"</td>");
			  out.println("</tr>");
			  i++;
		}
	}

    if(i==1)
    {
            _bw.write(_wl_block25Bytes, _wl_block25);

}

            _bw.write(_wl_block26Bytes, _wl_block26);

}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
	if(pstmt!=null) pstmt.close();//common-icn-0180
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block27Bytes, _wl_block27);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.previous.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.next.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.NoteID.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.NoteDescription.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.CategoryCode.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.CategoryDescription.label", java.lang.String .class,"key"));
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
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag7.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.criteria.label", java.lang.String .class,"key"));
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
        __tag8.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Response.label", java.lang.String .class,"key"));
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
        __tag9.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Score.label", java.lang.String .class,"key"));
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
}
