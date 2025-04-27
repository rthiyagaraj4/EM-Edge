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

public final class __assessmentcriteriascoresdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AssessmentCriteriaScoresDynamicValues.jsp", 1709116564809L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t<script>\n\t\t\tvar select\t=\tparent.parent.f_query_add_mod.assess_crit_score_header.document.assess_crit_score_header.assess_catg;\n\t\t\tvar length\t=\tMath.abs(select.length); \n\t\t\tfor (i=0;i<length;i++)\n\t\t\t\tselect.remove(0);\n\n\t\t\tvar option\t=\tparent.parent.f_query_add_mod.assess_crit_score_header.document.createElement(\"OPTION\");\n\t\t\toption.text = \"------ \"+getLabel(\"Common.defaultSelect.label\",\"Common\")+\"------\";\n\t\t\toption.value = \"\";\t\n\t\t\tselect.add(option);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<script>\n\t\t\tvar option\t=\tparent.parent.f_query_add_mod.assess_crit_score_header.document.createElement(\"OPTION\");\n\t\t\toption.value = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\toption.text\t= \"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\tselect.add(option);\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</html>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            _bw.write(_wl_block3Bytes, _wl_block3);

	 //This file is saved on 18/10/2005.
	 request.setCharacterEncoding("UTF-8");
	 String locale=(String)session.getAttribute("LOCALE");
Connection con = null;
Statement stmt = null;
PreparedStatement pstmt = null;
ResultSet rs = null;
try
{
	con = ConnectionManager.getConnection(request);
	//stmt = con.createStatement(); //common-icn-0180
	String assess_note = request.getParameter("assess_note");
	String assess_catg_code = "";
	String long_desc = "";
	//String sql = "select assess_catg_code, long_desc from cp_assess_catg_lang_vw where assess_catg_code in (select assess_catg_code from cp_assess_note_assess_catg where assess_note_id ='"+assess_note+"') and language_id='"+locale+"' order by long_desc"; //common-icn-0180
	String sql = "select assess_catg_code, long_desc from cp_assess_catg_lang_vw where assess_catg_code in (select assess_catg_code from cp_assess_note_assess_catg where assess_note_id =?) and language_id=? order by long_desc"; //common-icn-0180
	 //common-icn-0180 starts
	pstmt=con.prepareStatement(sql);
	pstmt.setString(1, assess_note);
	pstmt.setString(2, locale);
	//rs = stmt.executeQuery(sql); //common-icn-0180
	rs = pstmt.executeQuery();
	 //common-icn-0180 ends
	if(rs!=null)
	{
		
            _bw.write(_wl_block4Bytes, _wl_block4);

		while(rs.next())
		{
			assess_catg_code = rs.getString("assess_catg_code");
			long_desc = rs.getString("long_desc");
			if ((assess_catg_code==null) || (assess_catg_code.equals("null")))
			assess_catg_code = "";
			if ((long_desc==null) || (long_desc.equals("null")))
			long_desc =	"";
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(assess_catg_code));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(long_desc));
            _bw.write(_wl_block7Bytes, _wl_block7);

		} 
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
		if(pstmt!=null) pstmt.close();//common-icn-0180
	}
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

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
