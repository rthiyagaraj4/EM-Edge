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

public final class __assessmentcriteriascoresaddmodify extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AssessmentCriteriaScoresAddModify.jsp", 1726036446613L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<head>\n<!-- <link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/IeStyle.css\'> -->\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' type=\'text/css\'></link>\n<!-- <script language=\"JavaScript\" src=\"../../eCP/js/common.js\"></script> -->\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n<script language=\"JavaScript\" src=\"../js/AssessmentCriteriaScore.js\"></script>\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<script>\nfunction submitPrevNext(from, to)\n{\n\t\tdocument.assess_crit_score_addmod.from.value = from;\n\t    document.assess_crit_score_addmod.to.value = to; \n\t    var assess_note = document.assess_crit_score_addmod.assess_note.value; \n\t    var assess_catg = document.assess_crit_score_addmod.assess_catg.value; \n\t\tparent.assess_crit_score_addmod.location.href=\"../../eCP/jsp/AssessmentCriteriaScoresAddModify.jsp?assess_note=\"+assess_note+\"&assess_catg=\"+assess_catg+\"&from=\"+from+\"&to=\"+to+\"\";\n}\n</script>\n</head>\n<body onKeyDown=\"lockKey()\" OnMouseDown=\'CodeArrest()\'> \n<form METHOD=POST target=\'messageFrame\' ACTION=\"../../servlet/eCP.AssessmentCriteriaScoresServlet\" name=\'assess_crit_score_addmod\' id=\'assess_crit_score_addmod\'>\n<table width=\'95%\'>\n<tr>\n<td align=\'right\'  id=\'prevNext\'  class=\'BODYCOLORFILLED\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t<a href=\'javascript:submitPrevNext(";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =",";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =")\' text-decoration=\'none\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</a>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n</td>\n</tr>\n</table>\n<TABLE border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\'right\'>\n";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\t\n\t\t\t<TR>\n\t\t\t\t<TH>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</TH>\n\t\t\t\t<TH>";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</TH>\n\t\t\t</TR>\n\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t<script>\n\t\t\tparent.assess_crit_score_addmod.location.href=\"../../eCommon/html/blank.html\";\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</TABLE>\n<INPUT TYPE=\"hidden\" name=\"maxRecord\" id=\"maxRecord\" value=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n<INPUT TYPE=\"hidden\" name=\"assess_note\" id=\"assess_note\" value=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n<INPUT TYPE=\"hidden\" name=\"assess_catg\" id=\"assess_catg\" value=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n<INPUT type=hidden name=\"from\" id=\"from\" value=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n<INPUT type=hidden name=\"to\" id=\"to\" value=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n<INPUT type=hidden name=\"start\" id=\"start\" value=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n<INPUT type=hidden name=\"end\" id=\"end\" value=\"";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\">\n</form>\n";
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

	 //This file is saved on 16/12/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String locale=(String)session.getAttribute("LOCALE");
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

Connection con = null;
Statement stmt = null;
Statement Liststmt = null;
ResultSet rs = null;
ResultSet Listrs = null;
ResultSet rsVal = null;
Statement stmtVal = null;
PreparedStatement pstmt = null;//common-icn-0180
PreparedStatement pstmt1 = null;//common-icn-0180
String assess_note = request.getParameter("assess_note");
String assess_catg = request.getParameter("assess_catg");
if(assess_note==null) assess_note="";
if(assess_catg==null) assess_catg="";
String sec_hdg_code = "";
String child_sec_hdg_code = "";
String srl_no = "";
String comp_type = "";
String comp_type_desc = "";
String comp_id = "";
String short_desc = "";
String list_item_id = "";
String list_item_text = "";
String from = request.getParameter("from") ;
String to = request.getParameter("to") ;
try
{
	con = ConnectionManager.getConnection(request);
	from = request.getParameter("from") ;
	to = request.getParameter("to") ;
	int maxRecord = 0;
	int Listcnt = 0;
	int start = 0 ;
	int end = 0 ;
	int inc = 1;
	int list_inc = 1;
	if (from == null){ start = 1 ;  }   else {  start = Integer.parseInt( from ) ; }
	if (to == null){ end = 200 ; }   else {  end = Integer.parseInt( to ) ; }
	//stmt = con.createStatement();//common-icn-0180
	/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
	//String cntsql = "select count(*) from cp_assess_crit a, am_discr_msr b where a.assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and a.comp_id=b.discr_msr_id and b.result_type in ('L','C','N','I')";
	String cntsql = "select count(*) from cp_assess_crit a, am_discr_msr b where a.assess_note_id = ? and assess_catg_code = ? and a.comp_id=b.discr_msr_id and b.result_type in ('L','C','N','I')";
	pstmt=con.prepareStatement(cntsql);//common-icn-0180
	pstmt.setString(1, assess_note);//common-icn-0180
	pstmt.setString(2, assess_catg);//common-icn-0180
	rs = pstmt.executeQuery();//common-icn-0180
	//rs = stmt.executeQuery(cntsql);//common-icn-0180
	
	if(rs!=null)
	{
		if(rs.next())
		{
			maxRecord = rs.getInt(1);
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();//common-icn-0180
	}

            _bw.write(_wl_block9Bytes, _wl_block9);

	if ( !(start <= 1))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start-200)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end-200)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	}
	if ( !((start+200) > maxRecord ))
	{

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf((start+200)));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((end+200)));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);

	}

            _bw.write(_wl_block14Bytes, _wl_block14);

	if(maxRecord != 0 )
	{
		
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);

	}
	else
	{
	
            _bw.write(_wl_block18Bytes, _wl_block18);

	}
/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by 
P.Anuradha on 03/08/2005 requested by Sheelvant*/
//	String sql = "select a.SEC_HDG_CODE sec_hdg_code,a.child_sec_hdg_code child_sec_hdg_code,a.comp_SRL_NO srl_no,b.result_type comp_type,a.comp_id comp_id,b.short_desc short_desc from cp_assess_crit a, am_discr_msr b where a.assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and a.COMP_ID=b.discr_msr_id and b.result_type in ('L','C','N','I')";
	//String sql = "SELECT a.SEC_HDG_CODE sec_hdg_code,a.child_sec_hdg_code child_sec_hdg_code,a.comp_SRL_NO srl_no,b.result_type comp_type,a.comp_id comp_id,b.short_desc short_desc FROM cp_assess_crit a, am_discr_msr_LANG_VW b WHERE a.assess_note_id = '"+assess_note+"' AND assess_catg_code = '"+assess_catg+"' AND a.COMP_ID=b.discr_msr_id AND b.result_type IN ('L','C','N','I') AND B.LANGUAGE_ID = '"+locale+"'";//common-icn-0180
	String sql = "SELECT a.SEC_HDG_CODE sec_hdg_code,a.child_sec_hdg_code child_sec_hdg_code,a.comp_SRL_NO srl_no,b.result_type comp_type,a.comp_id comp_id,b.short_desc short_desc FROM cp_assess_crit a, am_discr_msr_LANG_VW b WHERE a.assess_note_id = ? AND assess_catg_code = ? AND a.COMP_ID=b.discr_msr_id AND b.result_type IN ('L','C','N','I') AND B.LANGUAGE_ID = ?";//common-icn-0180
	
	//stmt = con.createStatement();//common-icn-0180
	pstmt1 = con.prepareStatement(sql);//common-icn-0180
	pstmt1.setString(1, assess_note);//common-icn-0180
	pstmt1.setString(2, assess_catg);//common-icn-0180
	pstmt1.setString(3, locale);//common-icn-0180
	rs = pstmt1.executeQuery();//common-icn-0180
	//rs = stmt.executeQuery(sql);//common-icn-0180
	String className = "";
	String sql_chk = "";
	String sql_list = "";
	String sql_num = "";
	//String selected = "";
	String normal_rng_low = "";
	String normal_rng_high = "";
	String abnormal_rng_low = "";
	String abnormal_rng_high = "";
	String critical_rng_low = "";
	String critical_rng_high = "";
	int chkValyes = 0;
	int chkValno = 0;
	int num_normal_score = 0;
	int num_abnormal_score = 0;
	int num_critical_score = 0;
	int b=0;
	int i = 1;
	int cnt = 0;
	int list_cnts = 1;
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
			short_desc = rs.getString("short_desc");
			sec_hdg_code = rs.getString("sec_hdg_code");
			child_sec_hdg_code = rs.getString("child_sec_hdg_code");
			srl_no = rs.getString("srl_no");
			comp_type = rs.getString("comp_type");
			if(comp_type.equals("L"))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ListItem.label","common_labels");
			else if(comp_type.equals("C"))
				comp_type_desc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.CheckBox.label","common_labels");
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
				comp_type_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Numeric.label","common_labels");
			comp_id = rs.getString("comp_id");
			out.println("<tr >");
			out.println("<input type='hidden' value='"+srl_no+"' name='srl_no"+i+"' id='srl_no"+i+"'>");
			out.println("<input type='hidden' value='"+comp_type+"' name='comp_type"+i+"' id='comp_type"+i+"'>");
			out.println("<input type='hidden' value='"+comp_id+"' name='comp_id"+i+"' id='comp_id"+i+"'>");
			out.println("<input type='hidden' value='"+sec_hdg_code+"' name='sec_hdg_code"+i+"' id='sec_hdg_code"+i+"'>");
			out.println("<input type='hidden' value='"+child_sec_hdg_code+"' name='child_sec_hdg_code"+i+"' id='child_sec_hdg_code"+i+"'>");
			out.println("<td class='"+className+"'align='left'>"+short_desc+"</td>");
			out.println("<td class='"+className+"' align='left' width='15%'>"+comp_type_desc+"</td>");
			if(comp_type.equals("C"))
			{
				out.println("<td class='"+className+"' align='right'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+"<BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"</td>");
				//sql_chk = "select list_item_id,score from cp_assess_list_crit_score where assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and comp_id='"+comp_id+"' order by list_item_id desc";//common-icn-0180
				sql_chk = "select list_item_id,score from cp_assess_list_crit_score where assess_note_id = ? and assess_catg_code = ? and comp_id=? order by list_item_id desc";//common-icn-0180
				pstmt1 = con.prepareStatement(sql_chk);//common-icn-0180
				pstmt1.setString(1, assess_note);//common-icn-0180
				pstmt1.setString(2, assess_catg);//common-icn-0180
				pstmt1.setString(3, comp_id);//common-icn-0180
				rsVal = pstmt1.executeQuery();//common-icn-0180
				//stmtVal = con.createStatement();//common-icn-0180
				//rsVal = stmtVal.executeQuery(sql_chk);//common-icn-0180
				out.println("<td class='"+className+"' align='center'><SELECT name='scorelistyes"+i+"' id='scorelistyes"+i+"'>");
				for(b=0;b<=9;b++)
				{
					if(rsVal!=null)
					{
						while(rsVal.next())
						{
							if(cnt==0)
								chkValyes = Integer.parseInt(rsVal.getString("score"));
							else
								chkValno = Integer.parseInt(rsVal.getString("score"));
							cnt++;
						}
					}
					if(chkValyes==b)
					{
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				cnt = 0;
				out.println("</select><BR><SELECT name='scorelistno"+i+"' id='scorelistno"+i+"'>");
				for(b=0;b<=9;b++)
				{
					if(chkValno==b)
					{
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				out.println("</select></td>");
				b = 0;
			}
			else if(comp_type.equals("L"))
			{
				//Liststmt = con.createStatement();//common-icn-0180
				StringBuffer list_items_id = new StringBuffer();
				/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
				//String Listcntsql = "select count(*) from am_discr_msr_ref_rng_list where discr_msr_id ='"+comp_id+"'";//common-icn-0180
				String Listcntsql = "select count(*) from am_discr_msr_ref_rng_list where discr_msr_id =?";//common-icn-0180
				pstmt1 = con.prepareStatement(Listcntsql);//common-icn-0180
				pstmt1.setString(1, comp_id);//common-icn-0180
				Listrs = pstmt1.executeQuery();//common-icn-0180
				//Listrs = Liststmt.executeQuery(Listcntsql);//common-icn-0180
				if(Listrs!=null)
				{
					if(Listrs.next())
					{
						Listcnt = Listrs.getInt(1);
					}
					if(Listrs!=null) Listrs.close();
					if(Liststmt!=null) Liststmt.close();
				}
				//Liststmt = con.createStatement();//common-icn-0180
				/*Change made in the query. ca_template_comp is replaced by am_discr_msr since ca_template_comp is not used.Modified by P.Anuradha on 03/08/2005 requested by Sheelvant*/
				//String Listsql = "select result_value,ref_rng_desc  from am_discr_msr_ref_rng_list where discr_msr_id ='"+comp_id+"' order by sort_order";//common-icn-0180
				String Listsql = "select result_value,ref_rng_desc  from am_discr_msr_ref_rng_list where discr_msr_id =? order by sort_order";//common-icn-0180
				
				pstmt1 = con.prepareStatement(Listsql);//common-icn-0180
				pstmt1.setString(1, comp_id);//common-icn-0180
				Listrs = pstmt1.executeQuery();//common-icn-0180
				//Listrs = Liststmt.executeQuery(Listsql);
				if(Listrs!=null)
				{	
					int k = 1;
					out.println("<td class='"+className+"' align='right'>");

					while(Listrs.next())
					{
						list_item_id = Listrs.getString("result_value");
						if(k==1)
							list_items_id.append("'"+list_item_id+"'");
						else
							list_items_id.append(","+"'"+list_item_id+"'");
						out.println("<input type='hidden' value='"+list_item_id+"' name='list_item_id"+list_inc+"' id='list_item_id"+list_inc+"'>");
						list_item_text = Listrs.getString("ref_rng_desc");
						out.println(list_item_text+"<BR>");
						k++;
						list_inc++;
					}
					out.println("</td>");
					if(Listrs!=null) Listrs.close();
					if(Liststmt!=null) Liststmt.close();
				}
				if(Listcnt!=0)
				{
					out.println("<td class='"+className+"' align='center'>");
					//sql_list = "select score from cp_assess_list_crit_score where assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and comp_id='"+comp_id+"' and list_item_id in ("+list_items_id.toString()+")";
					sql_list = "select score from cp_assess_list_crit_score where assess_note_id = ? and assess_catg_code = ? and comp_id= ? and list_item_id in ("+list_items_id.toString()+")";//common-icn-0180
					
					//stmtVal = con.createStatement();//common-icn-0180
					pstmt1 = con.prepareStatement(sql_list);//common-icn-0180
					pstmt1.setString(1, assess_note);//common-icn-0180
					pstmt1.setString(2, assess_catg);//common-icn-0180
					pstmt1.setString(3, comp_id);//common-icn-0180
					rsVal = pstmt1.executeQuery();//common-icn-0180
					//rsVal = stmtVal.executeQuery(sql_list);//common-icn-0180
					int j = 1;
					if(rsVal!=null)
					{
						while(rsVal.next())
						{
							out.println("<SELECT name='scorelist"+inc+"' id='scorelist"+inc+"'>");
							for(b=0;b<=9;b++)
							{
								if(b==Integer.parseInt(rsVal.getString("score")))
								{
									out.println("<option value='"+b+"' selected>"+b+"</option>");
								}
								else
								{
									out.println("<option value='"+b+"'>"+b+"</option>");
								}
							}
							out.println("</select><BR>");
							j++;
							inc++;
						}
					}
					if(b==0)
					{
						for(j=1;j<=Listcnt;j++)
						{
							out.println("<SELECT name='scorelist"+inc+"' id='scorelist"+inc+"'><option value='0'>0</option><option value='1'>1</option><option value='2'>2</option><option value='3'>3 </option><option value='4'>4</option><option value='5'>5</option><option value='6'>6</option><option value='7'>7</option><option value='8'>8</option><option value='9'>9</option></select><BR>");
							inc++;
						}
					}
					if(rsVal!=null) rsVal.close();
					if(stmtVal!=null) stmtVal.close();
					out.println("</td>");
					b = 0;
				}
				else
				{
					out.println("<td class='"+className+"' align='center'>&nbsp;</td>");
				}
				out.println("<INPUT TYPE='hidden' name='Listcnt"+list_cnts+"' id='Listcnt"+list_cnts+"' value='"+Listcnt+"'>");
				list_cnts++;
			}
			else if((comp_type.equals("N"))||(comp_type.equals("I")))
			{
				//sql_num = "select abnormal_rng_low,abnormal_rng_high,abnormal_score,normal_rng_low,normal_rng_high,normal_score,critical_rng_low,critical_rng_high,critical_score from cp_assess_num_crit_score  where assess_note_id = '"+assess_note+"' and assess_catg_code = '"+assess_catg+"' and comp_id='"+comp_id+"'";//common-icn-0180
				sql_num = "select abnormal_rng_low,abnormal_rng_high,abnormal_score,normal_rng_low,normal_rng_high,normal_score,critical_rng_low,critical_rng_high,critical_score from cp_assess_num_crit_score  where assess_note_id = ? and assess_catg_code = ? and comp_id=?";//common-icn-0180
				
				//stmtVal = con.createStatement();//common-icn-0180
				pstmt1 = con.prepareStatement(sql_num);//common-icn-0180
				pstmt1.setString(1, assess_note);//common-icn-0180
				pstmt1.setString(2, assess_catg);//common-icn-0180
				pstmt1.setString(3, comp_id);//common-icn-0180
				rsVal = pstmt1.executeQuery();//common-icn-0180
				//rsVal = stmtVal.executeQuery(sql_num);//common-icn-0180
				if(rsVal!=null)
				{
					if(rsVal.next())
					{
						num_normal_score = Integer.parseInt(rsVal.getString("normal_score"));
						num_abnormal_score = Integer.parseInt(rsVal.getString("abnormal_score"));
						num_critical_score = Integer.parseInt(rsVal.getString("critical_score"));
						normal_rng_low = rsVal.getString("normal_rng_low")==null?"":rsVal.getString("normal_rng_low");
						normal_rng_high = rsVal.getString("normal_rng_high")==null?"":rsVal.getString("normal_rng_high");
						abnormal_rng_low = rsVal.getString("abnormal_rng_low")==null?"":rsVal.getString("abnormal_rng_low");
						abnormal_rng_high = rsVal.getString("abnormal_rng_high")==null?"":rsVal.getString("abnormal_rng_high");
						critical_rng_low = rsVal.getString("critical_rng_low")==null?"":rsVal.getString("critical_rng_low");
						critical_rng_high = rsVal.getString("critical_rng_high")==null?"":rsVal.getString("critical_rng_high");
					}
				}
				out.println("<td  class='"+className+"' align='center'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Normal.label","common_labels")+" &nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE='text' size='2' name='txtnl"+i+"' id='txtnl"+i+"' value='"+normal_rng_low+"'>&nbsp;<INPUT TYPE='text' size='2' value='"+normal_rng_high+"' name='txtnh"+i+"' id='txtnh"+i+"'><BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Abnormal.label","common_labels")+"&nbsp;<INPUT TYPE='text' name='txtal"+i+"' id='txtal"+i+"' size='2' value='"+abnormal_rng_low+"'>&nbsp;<INPUT TYPE='text' name='txtah"+i+"' id='txtah"+i+"' size='2' value='"+abnormal_rng_high+"'><BR>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Critical.label","common_labels")+"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<INPUT TYPE='text' name='txtcl"+i+"' id='txtcl"+i+"' size='2' value='"+critical_rng_low+"'>&nbsp;<INPUT TYPE='text' name='txtch"+i+"' id='txtch"+i+"' size='2' value='"+critical_rng_high+"'></td>");
				out.println("</select></td>");
				out.println("<td class='"+className+"' align='center'><SELECT name='scorelistnor"+i+"' id='scorelistnor"+i+"'>");
				for(b=0;b<=1;b++)
				{
					if(num_normal_score==b)
					{
						//selected = "selected";
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				out.println("</select><BR><SELECT name='scorelistabnor"+i+"' id='scorelistabnor"+i+"'>");
				if(num_abnormal_score==0)
					out.println("<option value='0' selected>0</option>");
				else
					out.println("<option value='0'>0</option>");
				for(b=2;b<=5;b++)
				{
					if(num_abnormal_score==b)
					{
						//selected = "selected";
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				out.println("</select><BR><SELECT name='scorelistcrit"+i+"' id='scorelistcrit"+i+"'>");
				if(num_critical_score==0)
					out.println("<option value='0' selected>0</option>");
				else
					out.println("<option value='0'>0</option>");
				for(b=6;b<=9;b++)
				{
					if(num_critical_score==b)
					{
						//selected = "selected";
						out.println("<option value='"+b+"' selected>"+b+"</option>");
					}
					else
					{
						out.println("<option value='"+b+"'>"+b+"</option>");
					}
				}
				b = 0;
				if(rsVal!=null) rsVal.close();
				if(stmtVal!=null) stmtVal.close();
				out.println("</select></td>");
			}
			out.println("</tr>");
			i++;
		}
	}

            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(maxRecord));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(assess_note));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(assess_catg));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(start));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(end));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(start));
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(end));
            _bw.write(_wl_block26Bytes, _wl_block26);

}
catch (Exception e)
{
	out.println(e.toString());
}
finally
{
	if(rs!=null) rs.close();
	if(rsVal!=null) rsVal.close();
	if(stmt!=null) stmt.close();
	if(stmtVal!=null) stmtVal.close();
	if(pstmt1!=null) pstmt1.close();//common-icn-0180
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCP.CriteriaDescription.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.type.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Response.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Score.label", java.lang.String .class,"key"));
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
}
