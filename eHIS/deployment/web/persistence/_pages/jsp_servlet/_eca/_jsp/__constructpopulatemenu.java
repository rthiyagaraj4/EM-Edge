package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __constructpopulatemenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ConstructPopulateMenu.jsp", 1709115778982L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head></head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<script>\n\t\tparent.frames[2].location.href=\'../../eCommon/jsp/error.jsp\';\n\t</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</html>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
	Connection con = null;
	
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	ResultSet rs1 = null;
	PreparedStatement pstmt1 = null;
	StringBuffer menuidsql =new StringBuffer();
	String funoptsql = "";
	String desktop_yn ="";
	String fun_opt_id="";
	String short_desc_fun_opt="";
	String str="#2#F";
	String menu_id = "";
	String short_desc = "";
	desktop_yn = (request.getParameter("desktop_hdn")==null)?"":request.getParameter("desktop_hdn");


	// this check is to ppulate the function options depending upon the desktop_yn

	if(desktop_yn.equals("Y"))
	{
		
		funoptsql = "select option_id, nvl(user_def_short_desc,short_desc) short_desc from ca_option where option_type='F'and NVL(DESKTOP_YN,'N') = 'Y' order by 2";

	}
	else
	{
		funoptsql = "select option_id, nvl(user_def_short_desc,short_desc)||'('||HIST_OR_RECORD||')' short_desc from ca_option where option_type='F'and (nvl(APPL_OP_YN,'N')= 'Y' OR nvl(APPL_IP_YN,'N')= 'Y' OR nvl(APPL_EM_YN,'N')= 'Y' OR nvl(APPL_DC_YN,'N')= 'Y') order by 2";
	}


	menuidsql.append("select menu_id, short_desc from ca_menu_header where root_menu_yn='Y' and eff_status='E' and NVL(SYSTEM_DEFINED_YN,'N')='N' ");

	if(desktop_yn.equals("Y"))
	{
		menuidsql.append(" and desktop_yn='Y'");
	}
	else 
	{
		menuidsql.append(" and patient_chart_yn='Y'");
	}

	menuidsql.append(" order by short_desc");

	try
	{
		con = ConnectionManager.getConnection(request);
		
		pstmt1 = con.prepareStatement(funoptsql);
		rs1 = pstmt1.executeQuery();

		
		out.println("<script>");

		while(rs1.next())
		{
			fun_opt_id=rs1.getString("option_id");
			short_desc_fun_opt=rs1.getString("short_desc");
			
			if(fun_opt_id == null)
				fun_opt_id="";
			if(short_desc_fun_opt == null)
				short_desc_fun_opt="";
			
			out.println("var opt = parent.frames[1].document.createElement('OPTION');");
			out.println("opt.text = '"+short_desc_fun_opt+"';");
			out.println("opt.value ='"+fun_opt_id+str+"';");
			out.println("parent.frames[1].document.forms[0].funcopt.add(opt);");	
		}
		out.println("</script>");
			
		pstmt = con.prepareStatement(menuidsql.toString());
		rs = pstmt.executeQuery();

		out.println("<script>");

	
		while(rs.next())
		{
			menu_id = rs.getString("menu_id");
			if(menu_id == null){
					menu_id = "";}

			short_desc = rs.getString("short_desc");
			if(short_desc == null)
				short_desc = "";

			out.println("var opt = parent.frames[1].document.createElement('OPTION');");
			out.println("opt.text = '"+short_desc+"';");
			out.println("opt.value ='"+menu_id+"';");
			out.println("parent.frames[1].document.forms[0].Menu.add(opt);");	
		}
	out.println("</script>");


            _bw.write(_wl_block6Bytes, _wl_block6);

		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null) rs1.close();
		if(pstmt1!=null) pstmt1.close();

}
catch(Exception ex)
{
	//out.println("Exception "+ex);//COMMON-ICN-0181
	ex.printStackTrace() ;
}
finally
{
		
		if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
