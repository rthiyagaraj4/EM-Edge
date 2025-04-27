package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;

public final class __equivalenttermcode3 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/EquivalentTermCode3.jsp", 1709118917813L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\"></link>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t<script>\n\t\t\tparent.f_query_result.document.getElementById(\"dynlevel\").innerText=\"Classification Levels  \"+\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\tparent.f_query_result.document.term_code_result_header.class_lvl.value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t\tparent.f_query_criteria.document.frm_terminology_code.dyanmic_level.value=\"";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\";\n\t\t\t//parent.f_term_add_modify.document.term_code_addmodify.term_code.maxLength=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t\t//parent.f_term_add_modify.document.getElementById(\"classificationlabel\").innerText=\" \"+\"";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\";\n\t\t\t//parent.f_term_add_modify.document.term_code_addmodify.term_code.size=\"";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\";\n\t\t\t//parent.f_term_add_modify.document.term_code_addmodify.codefldlength.value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\";\n\t\t\t</script>\n\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

Connection con = null;
ResultSet defnlevelRs = null;
PreparedStatement defnlevelStmt = null;
String defnlevelSql = "";
String defnlevel = "";
String codfldlen = "";
String lvldesc = "";
//String codefldlength = request.getParameter("codefldlength");
String termsetid = request.getParameter("termsetid");
String codelevel = request.getParameter("codelevel");
//String termcode = request.getParameter("termcode");
if(codelevel==null) codelevel="1";
try
{
	con = ConnectionManager.getConnection(request);
	if(codelevel.equals("1"))
	defnlevelSql = "select defn_levels,level_1_code_length,level_1_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("2"))
	defnlevelSql = "select defn_levels,level_2_code_length,level_2_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("3"))
	defnlevelSql = "select defn_levels,level_3_code_length,level_3_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("4"))
	defnlevelSql = "select defn_levels,level_4_code_length,level_4_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("5"))
	defnlevelSql = "select defn_levels,level_5_code_length,level_5_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("6"))
	defnlevelSql = "select defn_levels,level_6_code_length,level_6_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("7"))
	defnlevelSql = "select defn_levels,level_7_code_length,level_7_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("8"))
	defnlevelSql = "select defn_levels,level_8_code_length,level_8_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("9"))
	defnlevelSql = "select defn_levels,level_9_code_length,level_9_desc from mr_term_set where term_set_id=?";
	else if(codelevel.equals("10"))
	defnlevelSql = "select defn_levels,level_10_code_length,level_10_desc from mr_term_set where term_set_id=?";
	defnlevelStmt = con.prepareStatement(defnlevelSql);
	defnlevelStmt.setString(1,termsetid);
	defnlevelRs = defnlevelStmt.executeQuery();
	if(defnlevelRs!=null)
	{
		if(defnlevelRs.next())
		{
			defnlevel = defnlevelRs.getString("defn_levels");
			codfldlen = defnlevelRs.getString(2);
			int len = Integer.parseInt(codfldlen);
			lvldesc = defnlevelRs.getString(3);
			
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(defnlevel));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(defnlevel));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(defnlevel));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(len));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(lvldesc));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(len));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(len));
            _bw.write(_wl_block11Bytes, _wl_block11);

		}
	}
}
catch (Exception e)
{
	//out.println(e.toString());
	e.printStackTrace();
}
finally
{
	if(defnlevelRs!=null) defnlevelRs.close();
	if(defnlevelStmt!=null) defnlevelStmt.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
