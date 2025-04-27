package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import java.text.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __accessrightsmenu extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/AccessRightsMenu.jsp", 1713243227282L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\t\t<html>\n\t\t<head>\n\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\t<script language=\'javascript\' src=\'../../eSM/js/AccessRightsMenuFunc.js\'></script>\n\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n\t\t</head>\n\n\t\t<script>\n\t\t\n\t\t//if (parseInt(Medadmin) >0  || Role_id==\'MEDADMIN\') {\n\t\t//if (parseInt(Medadmin) >0) {\n\n\t\tdocument.write(\"<iframe name=\'f_query_add_mod1\' id=\'f_query_add_mod1\' src=\'../../eSM/jsp/AddModifyAccessRightsMenuFunc.jsp\' frameborder=0 scrolling=\'no\' noresize style=\'height:110%;width:100vw\'></iframe><iframe name=\'function_frame\' id=\'function_frame\'  src=\'../../eCommon/html/blank.html\' frameborder=0 noresize scrolling=\'auto\' style=\'height:100vh;width:100vw\'></iframe>\");\n\n\t\t/*}\n\t\telse\n\t\t\t{\n\t\t\t\tvar error=getMessage(\"MENU_ADMIN_ACCESS\",\"SM\");\n\t\t\t\talert(error);\n\t\t\t\tself.location.href=\'../../eCommon/html/blank.html\';\n\t\t\t}\n*/\n\t\t</script>\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n</html>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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

	//Connection con=null;
	//Statement stmt=null;
		try{
		/*	request.setCharacterEncoding("UTF-8");
			con = ConnectionManager.getConnection(request);
			ResultSet rset=null ;
			ResultSet rs=null;
			String Role_id ="";
			int Medadmin=0;
			String Log_user= (String) session.getValue("login_user");
			String responsibility_id= (String) session.getValue("responsibility_id");

			stmt=con.createStatement();*/
			//String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' 	and to_char(sysdate,'dd/mm/yyyy')>= nvl(to_char(eff_date_from,'dd/mm/yyyy'),sysdate-1) and to_char(sysdate,'dd/mm/yyyy')<=nvl(to_char(eff_date_to,'dd/mm/yyyy'),sysdate+1) ";	
			/*String sql="select count(*)  from sm_menu_admin where menu_admin_id='"+Log_user+"' and trunc (sysdate) >= nvl (trunc (eff_date_from), sysdate - 1) and trunc (sysdate) <= nvl (trunc (eff_date_to), sysdate + 1)";	
			rset=stmt.executeQuery(sql);
			if (rset !=null){
						while (rset.next()){
									Medadmin=Integer.parseInt(rset.getString(1));
						}
						if (rset !=null)rset.close();
					}*/

			/*String sqlRole ="select ora_role_id  from sm_resp  where resp_id='"+responsibility_id+"' ";
			rs=stmt.executeQuery(sqlRole);
			if (rs !=null){
				while (rs.next()){
								Role_id=rs.getString(1);
						}
					if(rs!=null)rs.close();
					if(stmt!=null) stmt.close();
				}	*/
		
            _bw.write(_wl_block2Bytes, _wl_block2);

        String sStyle	=
       (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

		}catch(Exception e){//out.println(e);
			e.printStackTrace();
		} 
			finally {
	
	//ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block5Bytes, _wl_block5);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
