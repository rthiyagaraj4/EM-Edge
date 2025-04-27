package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __custicdqueryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/CusticdQueryResult.jsp", 1742295677046L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n\t\t<script src=\'../../eCommon/js/rowcolor.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script src=\'../js/rowcolor.js\' language=\'javascript\'></script>\n\t\t\n\t\t<!-- <script src=\'../js/PatProblem.js\' language=\'javascript\'></SCRIPT> -->\n\t</head>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t<script>\n\t\tfunction closew(Diagcode){\n\t\t\t//window.parent.parent.parent.returnValue=Diagcode;\n\t\t\tif(parent.parent.parent.document.getElementById(\"dialog_tag\")){\n\t\t\t\twindow.parent.parent.returnValue=Diagcode;\n\t\t\t\tconst dialogTag = parent.parent.parent.document.getElementById(\"dialog_tag\");\n\t\t\t\t//const dialogTag = parent.parent.parent.parent.document.getElementById(\"dialog_tag\");\n\t\t\t\tdialogTag.close();    \n\t\t\t} else {\n\t\t\t\t//window.parent.parent.parent.returnValue=Diagcode;\n\t\t\t\twindow.parent.parent.parent.returnValue=Diagcode;\n\t\t\t\tconst dialogTag = parent.parent.parent.parent.document.getElementById(\"dialog_tag\");\n\t\t\t\t//const dialogTag = parent.parent.parent.parent.document.getElementById(\"dialog_tag\");\n\t\t\t\tdialogTag.close();  \n\t\t\t}\n\t\t\t\n\t\t}\n\t\tasync function showLongDescription(diagcode,term_set_id){\n\t\t\tvar dialogHeight= \"90vh\" ;\n\t\t\tvar dialogWidth = \"69vw\" ;\n\t\t\tvar features    = \"dialogHeight:\" + dialogHeight + \"; dialogWidth:\" + dialogWidth+\";status=no\" ;\n\t\t\tawait window.showModalDialog(\"../../eMR/jsp/PatProblemDialogLongDesc.jsp?term_code=\"+diagcode+\"&term_set_id=\"+term_set_id,\"\",features);\n\t\t}\n\t\t\n\t\tfunction longDescToolTip(term_code, long_desc) {\n\t\t    var tab_data = \"<td class=\'label\'>\" + term_code + \"</td>\";\n\t\t    var tab_data2 = \"<td class=\'label\'>\" + long_desc + \"</td>\";\n\t\t    var final_table = \"<table border=\'0\' cellpadding=\'0\' cellspacing=\'0\' align=\'center\'>\" + \n\t\t                      \"<tr>\" + \n\t\t                      tab_data + \n\t\t                      tab_data2 + \n\t\t                      \"</tr></table>\";\n\t\t    return final_table;\n\t\t}\t\n\t</script>\n\t</head>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<body class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown =\'lockKey()\'>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t\t\t\t\t<P>\n\t\t\t\t\t\t\t\t<table align=\'right\'>  <!--below Search_By value pass against ML-MMOH-SCF-0852 by mano-->\n\t\t\t\t\t\t\t\t\t<tr>\n\t\t\t\t\t\t\t\t\t\t<td>\n\t\t\t\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t\t\t\t\t\t\t\t</td>\n\t\t\t\t\t\t\t\t\t</tr>\n\t\t\t\t\t\t\t\t</table>\n\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t\t\t<br>\n\t\t\t\t\t\t\t</p>\n\t\t\t\t\t\t\t<table width=\'100%\' border=\'1\' cellspacing=\'0\' cellpadding=\'2\' id=\'tb1\'>\n\t\t\t\t\t\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</th>\n\t\t\t\t\t\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</th>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t\t\t\t\t\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t\t\t\t\t\t<th align=\'center\'>";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t\t\t\t\t\t\t\t<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script><script LANGUAGE=\"JavaScript\">\n\t\t\t\t\t\t\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\t\t\t\n\t\t\t\t\t\t\t\t\t</SCRIPT>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\t\t\tif (document.getElementById(\"next\")){\n\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.display=\'none\';\n\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t\t\t\t\t\t\t<script >\n\t\t\t\t\t\t\t\t\t\tif (document.getElementById(\"next\")){\n\t\t\t\t\t\t\t\t\t\t\tdocument.getElementById(\"next\").style.display=\'inline\';\n\t\t\t\t\t\t\t\t\t\t}\n\t\t\t\t\t\t\t\t\t</script>\n\t\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n\t\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t<script language=\'javascript\' src=\'../../eOT/js/wz_tooltip.js\'></script>\n\t</body>\n\t<SCRIPT LANGUAGE=\"JavaScript\">\n\t\tif(parent.searchframe != null)\n\t\tparent.searchframe.document.radio.Search.disabled = false;\n\t</SCRIPT>\n<Script src=\\\"../../eCommon/js/showModalDialog.js\\\" language=\\\"JavaScript\\\"></Script>\n\n\n\n</html>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

public static String checkForNull(String inputString){
	return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue){
	return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
}


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

		request.setCharacterEncoding("UTF-8");
		request= new XSSRequestWrapper(request);
		response.addHeader("X-XSS-Protection", "1; mode=block");
		response.addHeader("X-Content-Type-Options", "nosniff");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		String locale			= (String)session.getAttribute("LOCALE");
		
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
	String Diag_code="";
	String gender_spec_ind = "";
	String age_spec_ind = "";
	String select_yn	= "";
	
            _bw.write(_wl_block8Bytes, _wl_block8);
 
	String Diag_code="";
	String gender_spec_ind = "";
	String age_spec_ind = "";
	String select_yn	= "";
	
            _bw.write(_wl_block9Bytes, _wl_block9);

		Connection conn=null;
		Statement stmt=null;
		ResultSet rset=null;
		String Diag_desc			="";
		String diagcode				= checkForNull(request.getParameter("p_diag_code"));
		String diagdesc				= checkForNull(request.getParameter("p_diag_scheme_desc"));
		String authorize				= checkForNull(request.getParameter("p_auth_yn"));
		String DiagGcode			= checkForNull(request.getParameter("Diag_code"));
		String cause_indicator	= checkForNull(request.getParameter("cause_indicator"));
		String search_by			= checkForNull(request.getParameter("Search_By"));
		String notifiable_yn		= checkForNull(request.getParameter("opt_notifiable"));
		String search_criteria		= checkForNull(request.getParameter("Search_Criteria"));
		String sensitive_yn		= checkForNull(request.getParameter("sensitive_yn"));
		String search_text			= checkForNull(request.getParameter("Search_Text"));
		String term_set_id			= checkForNull(request.getParameter("term_set_id"));
		String sex						= checkForNull(request.getParameter("Sex"));
		String dob						= checkForNull(request.getParameter("Dob"));
		String p_code_indicator =checkForNull(request.getParameter("code_indicator"));
		String function_id			= checkForNull(request.getParameter("function_id"));
		String diagnosis_by_long_desc_yn =	checkForNull(request.getParameter("diagnosis_by_long_desc_yn"));//Maheshwaran added for the HSA-CRF-0234
		String long_description  ="";
		String searchcondition   ="";
		String notifiable_value	="";
		String sensitive_value	="";
		//out.println("<script>alert(\""+request.getQueryString()+"\")</script>");
		search_text = search_text.toUpperCase();
		if(cause_indicator==null)
		cause_indicator	 ="";
		searchcondition	 ="";
		//out.println("--------"+searchcondition);
		//out.println("----search_criteria----"+search_criteria);
		/*
		1.For below condition was added 1/18/2010 for IN018218;
		2.search_criteria is null because Other than this function CustomICDQueryFrames.jsp are used.
		3. In above Frames they are maintaining the Search Criteria.
		*/
		search_text=search_text.replaceAll("'","''");
		if(function_id.equals("ca_diagnosis")){
			if(search_by.equals("D")){
				if (search_criteria.equals("S")) {		
					if(diagnosis_by_long_desc_yn.equals("Y"))	
					searchcondition = searchcondition+ " and  upper(c.long_desc)  like upper('"+search_text+"%')";
					else
					searchcondition = searchcondition+ " and  upper(c.short_desc)  like upper('"+search_text+"%')";
				} else if (search_criteria.equals("E")) {
					if(diagnosis_by_long_desc_yn.equals("Y"))
					searchcondition = searchcondition+ " and  upper(c.long_desc)  like upper('%"+search_text+"')";
					else
					searchcondition = searchcondition+ " and  upper(c.short_desc)  like upper('%"+search_text+"')";
				} else if (search_criteria.equals("C"))	{
					if(diagnosis_by_long_desc_yn.equals("Y"))
					searchcondition = searchcondition+ " and  upper(c.long_desc)  like upper('%"+search_text+"%')";
					else
					searchcondition = searchcondition+ " and  upper(c.short_desc)  like upper('%"+search_text+"%')";
				}	
			}else{
				if (search_criteria.equals("S")) {			
					searchcondition = searchcondition+ " and  upper(a.term_code)  like upper('"+search_text+"%')";
				} else if (search_criteria.equals("E")) {
					searchcondition = searchcondition+ " and  upper(a.term_code)  like upper('%"+search_text+"')";
				} else if (search_criteria.equals("C"))	{
					searchcondition = searchcondition+ " and  upper(a.term_code)  like upper('%"+search_text+"%')";
				}	
			}
		}
		if(sensitive_yn.equals("Y")){
			searchcondition = searchcondition + " and  b.SENSITIVE_YN = 'Y' ";
		}else if(sensitive_yn.equals("N")){
			searchcondition = searchcondition + " and nvl(b.SENSITIVE_YN, 'N') = 'N'";
		}
		if (notifiable_yn.equals("Y")){
			searchcondition = searchcondition + " and b.notifiable_yn = 'Y'";
		}else if(notifiable_yn.equals("N")){
			searchcondition = searchcondition + " and nvl(b.notifiable_yn, 'N') = 'N'";
		}
		String from	= request.getParameter( "from" ) ;
		String to		= request.getParameter( "to" ) ;
		int start = 0 ;
		int end = 0 ;
		int i=1;
//		int maxRecord=0;
		if ( from == null ){
			start = 1 ;
		}else{
			start = Integer.parseInt( from ) ;
		}
		if ( to == null ){
			end = 14 ;
		}else{
			end = Integer.parseInt( to ) ;
		}
		try{
			/*
				The following query was modified for IN023648 
				Modified On:10/5/2010
			*/
			conn = ConnectionManager.getConnection(request);
			//Added by Ajay Hatwate for ML-MMOH-CRF-1940
			boolean toolTip_diagnosis	=  eCommon.Common.CommonBean.isSiteSpecific(conn, "MR","TOOLTIP_FOR_DIAGNOSIS"); 
			
			StringBuffer sql = new StringBuffer("select a.term_code,c.short_desc,c.long_desc,b.notifiable_yn,b.sensitive_yn ,c.age_spec_ind, c.gender_spec_ind,c.code_indicator,c.select_yn from mr_term_group_dtl a , mr_term_Code b ,  mr_d_"+term_set_id+"_lang_vw c where a.term_group_id ='"+DiagGcode+"'  and  a.term_set_id='"+term_set_id+"'   and a.term_set_id = b.term_set_id and a.term_code = b.term_code  and a.term_set_id = c.term_set_id and a.term_Code = c.term_code and c.language_id='"+locale+"' ");
			if(p_code_indicator.equals("")){
				//sql.append(" and ( code_indicator in ('C','D') or code_indicator is null )");	
				sql.append(" and ( code_indicator in ('C','D','A','E') or code_indicator is null )");//Modified by Dharma on 23rd Oct 2017 against ML-MMOH-SCF-0833 [IN:065389]
			}else{
				sql.append(" and code_indicator = '"+p_code_indicator+"'");
			}
			if(!(sex.equals("Unknown")|| sex.equals("U") || sex.equals("u") || sex.equals(""))){
				sql.append(" and ( c.gender_spec_ind = '"+sex+"' OR c.gender_spec_ind IS NULL OR nvl(c.age_spec_ind,'O')='O' ) ");
			}
			sql.append(searchcondition);
			if(search_by.equals("D")){
				sql.append("  order by ORDER_SRL_NO");//Added by shanmukh on 12th-Jun-2018 for ARYU-SCF-0114
			}else{
				sql.append("  order by term_code");
			}
			stmt = conn.createStatement();
			rset=stmt.executeQuery(sql.toString());
			if ( start != 1 )
			for( int j=1; j<start; i++,j++ )
			rset.next() ;
			String rowclass="";
			int maxRecords=0;
			while (rset.next()&& i<=end ){
					if(maxRecords==0){
            _bw.write(_wl_block10Bytes, _wl_block10);

											if ( !(start <= 1) )
											out.println("<A HREF='../../eMR/jsp/CusticdQueryResult.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&code_indicator="+p_code_indicator+"&from="+(start-14)+"&to="+(end-14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator="+cause_indicator+"&Search_Criteria="+search_criteria+"&Search_By="+search_by+"&Sex="+sex+"&Dob="+dob+"&function_id="+function_id+"' text-decoration='none' id='previous'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
											out.println("<A HREF='../../eMR/jsp/CusticdQueryResult.jsp?diagnosis_by_long_desc_yn="+diagnosis_by_long_desc_yn+"&term_set_id="+term_set_id+"&code_indicator="+p_code_indicator+"&from="+(start+14)+"&to="+(end+14)+"&p_diag_code="+diagcode+"&p_diag_scheme_desc="+diagdesc+"&p_auth_yn="+authorize+"&Diag_code="+DiagGcode+"&cause_indicator=	"+cause_indicator+"&Search_Criteria="+search_criteria+"&Search_By="+search_by+"&Sex="+sex+"&Dob="+dob+"&function_id="+function_id+"'  text-decoration='none' id='next' style='display:none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
											
            _bw.write(_wl_block11Bytes, _wl_block11);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
if(!toolTip_diagnosis){ 
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
} 
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
}
								if (i%2==0){
									rowclass="QRYEVEN";
								}else{
									rowclass="QRYODD";
								}
								Diag_code			=rset.getString("term_code");
								Diag_desc			=rset.getString("short_desc");
								long_description	=rset.getString("long_desc");
								if(toolTip_diagnosis){
									long_desc_1 = long_description;
								}
								long_description	=java.net.URLEncoder.encode(long_description);
								notifiable_value	=rset.getString("notifiable_yn");
								sensitive_value		= rset.getString("sensitive_yn").trim();
								p_code_indicator	= rset.getString("code_indicator")==null?"":rset.getString("code_indicator");
								gender_spec_ind	= rset.getString("gender_spec_ind")==null?"":rset.getString("gender_spec_ind");
								age_spec_ind		= rset.getString("age_spec_ind")==null?"":rset.getString("age_spec_ind");
								select_yn				= rset.getString("select_yn")==null?"N":rset.getString("select_yn");
								p_code_indicator = (p_code_indicator.equals("D")?"Dagger(+)":(p_code_indicator.equals("C")?"Consequence(C)":(p_code_indicator.equals("E")?"External Cause Indicator(E)":(p_code_indicator.equals("A")?"*":"&nbsp;"))));
								out.println("<tr style='background-color:;' >");
								if(select_yn.equals("Y")){
									out.println("<td class='"+rowclass+"'><a href=javascript:closew('"+Diag_code+"')>" + Diag_code + "</a></td>");
								}else{
									out.println("<td class='"+rowclass+"'>" + Diag_code + "</td>");
								}
								
/* 								System.out.println(toolTip_diagnosis+" : toolTip_diagnosis " +Diag_code+" Diag_code "+long_desc_1+" long_desc_1 "); */
								//Added by Ajay Hatwate for ML-MMOH-CRF-1940
								if(toolTip_diagnosis){
								out.println("<td  class='"+rowclass+"' onMouseOver=\"Tip(longDescToolTip('"+Diag_code+"', '"+long_desc_1+"'))\" onMouseOut=\"UnTip()\" >");
								out.println(Diag_desc+"</td>");
								}else{
									out.println("<td  class='"+rowclass+"'>");
									out.println(Diag_desc+"</td>");									
								}
								if(!toolTip_diagnosis){
									if (!Diag_desc.equals(long_description)){
										//out.println("<td class='"+rowclass+"' align=center><a href= javascript:showLongDescription(\"" + long_description + "\"); ><b>!</b></a></td>");
										out.println("<td class='"+rowclass+"' align=center><a href= javascript:showLongDescription(\"" + Diag_code + "\",\"" + term_set_id + "\"); ><b>!</b></a></td>");
									}else{
										out.println("<td class="+rowclass+">&nbsp;</td>");
									}
								}
								out.println("<td class='"+rowclass+"'>");
								out.println(notifiable_value.equals("Y")?"Yes":"No"+"</td>");
								out.println("<td class='"+rowclass+"'>");
								out.println(sensitive_value.equals("Y")?"Yes":(sensitive_value.equals("N")?"No":"&nbsp;")+"</td>");
								out.println("<td class='"+rowclass+"' align = center>");
								out.println(p_code_indicator+"</td>");
								out.println("</tr>");
								i++;
								maxRecords++;
								}//End Of While
								if(maxRecords==0){
            _bw.write(_wl_block16Bytes, _wl_block16);
}
								if ( maxRecords<14 || (!rset.next()) ) {
            _bw.write(_wl_block17Bytes, _wl_block17);

								} else {
            _bw.write(_wl_block18Bytes, _wl_block18);
}
								if(rset != null) rset.close();
								if(stmt != null )stmt.close();
								
            _bw.write(_wl_block19Bytes, _wl_block19);

		}catch  (Exception e) {
				e.printStackTrace();
		} finally {
				if(conn!=null)ConnectionManager.returnConnection(conn,request);
		}
		
            _bw.write(_wl_block20Bytes, _wl_block20);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.code.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.description.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.details.label", java.lang.String .class,"key"));
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
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Notifiable.label", java.lang.String .class,"key"));
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
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Sensitive.label", java.lang.String .class,"key"));
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
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.CodeIndicator.label", java.lang.String .class,"key"));
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
