package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __gcpgeneratecareplanaddinterventionsheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/GCPGenerateCarePlanAddInterventionsHeader.jsp", 1709116586559L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\"JavaScript\" src=\"../../eCP/js/GCPGenerateCarePlan.js\"></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/CommonLookup.js\'></script>\n    <script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t<body>\n\t<form name=\'GCPAddinterventionHeader\' id=\'GCPAddinterventionHeader\'>\n\t<table border=0 cellspacing=\'0\' cellpadding=\'0\' width=\'100%\'><tr>\n\t\t<td class=\'label\' width=\'15%\' align=\'right\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</td>\n\t\t<td>&nbsp;&nbsp;<input type=\'text\' size=50 maxlength=\'60\' name=\'intvn_desc\' id=\'intvn_desc\' onblur=\'selectIntvn(\"T\",intvn_desc,\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\",\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\");\'><input class=\'button\' type=button name=\"intvn_btn\" id=\"intvn_btn\" value=\"?\"  onClick=\'selectIntvn(\"B\",intvn_desc,\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\");\'>\n\t<input type=\'hidden\' name=\'intvn_code\' id=\'intvn_code\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'intvn_type\' id=\'intvn_type\' value=\'\'>\n\t\t<input type=\'hidden\' name=\'intvn_groupID\' id=\'intvn_groupID\' value=\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'>\n\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t<td colspan=\'2\' align=\'right\'><input class=\'button\' type=button name=\"addIntvn_btn\" id=\"addIntvn_btn\" value=\"Add\"  onClick=\'addIntvn(\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\");\'>&nbsp;<input class=\'button\' type=button name=\"clearIntvn_btn\" id=\"clearIntvn_btn\" value=\"Clear\"  onClick=\'clearIntvns(\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\");\'>&nbsp;<input class=\'button\' type=button name=\"close_btn\" id=\"close_btn\" value=\"Close\"  onClick=\'Close();\'>\n\t\t</td>\n\t\t</tr>\n\t\t</table>\n\t\t<form>\n\t</body>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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
            eCP.GCPGeneratePlanBean GCPGenerateBean= null;synchronized(session){
                GCPGenerateBean=(eCP.GCPGeneratePlanBean)pageContext.getAttribute("GCPGenerateBean",javax.servlet.jsp.PageContext.SESSION_SCOPE);
                if(GCPGenerateBean==null){
                    GCPGenerateBean=new eCP.GCPGeneratePlanBean();
                    pageContext.setAttribute("GCPGenerateBean",GCPGenerateBean,javax.servlet.jsp.PageContext.SESSION_SCOPE);

                }
            }
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

//This file is saved on 18/10/2005.
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

//eCP.GCPGeneratePlanBean bean	= (eCP.GCPGeneratePlanBean)session.getAttribute("GCPGenerateBean");	
String goal_code = request.getParameter("goal_code")==null?"":request.getParameter("goal_code");
String library_id = request.getParameter("library_id")==null?"":request.getParameter("library_id");
String version_no = request.getParameter("version_no")==null?"":request.getParameter("version_no");
String term_set_id = request.getParameter("term_set_id")==null?"":request.getParameter("term_set_id");
String term_code = request.getParameter("term_code")==null?"":request.getParameter("term_code");
String target_date = request.getParameter("target_date")==null?"":request.getParameter("target_date");
String sel_lib_ids = request.getParameter("sel_lib_ids")==null?"":request.getParameter("sel_lib_ids");
//sel_lib_ids=sel_lib_ids.replace('~','\'');

String sql_group_id="select distinct group_id from cp_library_intervention a where a.library_id = ? and a.version_no = ? and a.term_set_id = ? and a.term_code = ? and a.goal_code = ?";
String group_id="";

Connection con = null;
PreparedStatement pstmt_groupid = null;
ResultSet rs_groupid = null;
try{
	con =ConnectionManager.getConnection(request);
	pstmt_groupid = con.prepareStatement(sql_group_id);

	pstmt_groupid.setString(1,library_id);
	pstmt_groupid.setString(2, version_no);
	pstmt_groupid.setString(3, term_set_id);
	pstmt_groupid.setString(4, term_code);
	pstmt_groupid.setString(5, goal_code);
	rs_groupid = pstmt_groupid.executeQuery();
	if(rs_groupid.next())
		group_id = rs_groupid.getString(1);

	if(pstmt_groupid !=null)
		pstmt_groupid.close();
	if(rs_groupid!=null)
		rs_groupid.close();
	//out.println("<script>alert('"+sel_lib_ids+"');</script>");

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sel_lib_ids));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(sel_lib_ids));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(group_id));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(library_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(goal_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(target_date));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(library_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(version_no));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_set_id));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(term_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(goal_code));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(target_date));
            _bw.write(_wl_block15Bytes, _wl_block15);

	}catch(Exception e){
		e.printStackTrace();
	}
	finally{
		if(pstmt_groupid !=null)
			pstmt_groupid.close();
		if(rs_groupid!=null)
			rs_groupid.close();
		if(con != null) 
			ConnectionManager.returnConnection(con);
	}

            _bw.write(_wl_block16Bytes, _wl_block16);
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
}
