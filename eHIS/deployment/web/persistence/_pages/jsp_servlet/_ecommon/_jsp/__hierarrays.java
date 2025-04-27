package jsp_servlet._ecommon._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;

public final class __hierarrays extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecommon/jsp/hierArrays.jsp", 1709116506560L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\nf";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\nfunction MainMenu() {\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n}\n</script>\n\n<script language=\'JavaScript\'>\n  \tif ( document.all ) MainMenu() ;\n\tif ( document.layers ) MainMenu() ;\n</script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

	Connection con ;
	PreparedStatement pstmt ;
	ResultSet rs ;


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/js;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/js;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

//	con = (Connection) session.getValue( "connection" ) ;
	try{con=ConnectionManager.getConnection(request);
	String responsibility_id	= (String) session.getValue( "responsibility_id" ) ;
	String root_menu_id = "";

	String menuIdSql		= "select menu_id from sm_resp where resp_id = ? " ;
	pstmt = con.prepareStatement( menuIdSql ) ;
	pstmt.setString( 1, responsibility_id ) ;
	rs = pstmt.executeQuery() ;
	if ( rs != null ) {
			rs.next() ;
			root_menu_id = rs.getString( "menu_id" ) ;
	}

	rs.close();
	pstmt.close();

	String menu_sql	= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type, "+
        		   "menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from "+
        		   "sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor "+
 			   "from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? "+       			   "order by rownum) menu_dtl,sm_module module,sm_function sm_function "+
  			   "where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and "+
  		           "sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and "+
			   "submenu_id is not null order by p_level desc";

	String submenu_sql	= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type, "+
        		   "menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from "+
        		   "sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor,OPTION_SEQUENCE_NO "+
 			   "from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? "+       			   "order by rownum) menu_dtl,sm_module module,sm_function sm_function "+
  			   "where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and "+
  		           "sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and "+
			   "submenu_id is not null order by OPTION_SEQUENCE_NO  ";

	String function_sql= "select menu_dtl.p_level, menu_dtl.menu_id menu_id, menu_dtl.submenu_id submenu_id, menu_dtl.option_type, "+
        		   "menu_dtl.option_descriptor option_descriptor, menu_dtl.function_id function_id, sm_function.executable_name from "+
        		   "sm_menu_hdr menu_hdr,( select level p_level,menu_id,submenu_id ,function_id,module_id, option_type, option_descriptor "+
 			   "from sm_menu_dtl connect by prior submenu_id=menu_id start with  menu_id=? "+
       			   "order by rownum) menu_dtl,sm_module module,sm_function sm_function "+
  			   "where  menu_dtl.menu_id=menu_hdr.menu_id and menu_dtl.module_id = module.module_id (+) and "+
  			   "sm_function.module_id (+) = menu_dtl.module_id   and sm_function.function_id  (+)= menu_dtl.function_id and "+
			   "submenu_id is null order by p_level ";

	//Class.forName( "oracle.jdbc.driver.OracleDriver" ) ;
	//con = DriverManager.getConnection( "jdbc:oracle:thin:@192.5.2.235:1521:csdv", "developer", "developer" ) ;

	pstmt = con.prepareStatement( menu_sql ) ;
	pstmt.setString( 1, root_menu_id ) ;
	rs = pstmt.executeQuery() ;

	while ( rs != null && rs.next() ) {
		//String menu_id = rs.getString( "menu_id" ) ;
		//String option_type = rs.getString( "option_type" ) ;
		String submenu_id = rs.getString( "submenu_id" ) ;
		String option_descriptor = rs.getString( "option_descriptor" ) ;
		//String executable_name = rs.getString( "executable_name" ) ;

		if ( submenu_id != null ) {
				out.println( "window." + submenu_id + " = new Menu('" + option_descriptor + "')") ;
		}
	}
	rs.close();
	pstmt.close();

	out.println( "window.mainMenu = new Menu() ;" ) ;

	pstmt = con.prepareStatement( function_sql ) ;
	pstmt.setString( 1, root_menu_id ) ;
	rs = pstmt.executeQuery() ;

	while ( rs != null && rs.next() ) {
		String menu_id = rs.getString( "menu_id" ) ;
		//String option_type = rs.getString( "option_type" ) ;
	//	String submenu_id = rs.getString( "submenu_id" ) ;
		String option_descriptor = rs.getString( "option_descriptor" ) ;
		String executable_name = rs.getString( "executable_name" ) ;

		out.println( menu_id + ".addMenuItem( '" + option_descriptor + "', 'location=\"" + executable_name + "\"' )" ) ;
	}


	pstmt = con.prepareStatement( submenu_sql ) ;
	pstmt.setString( 1, root_menu_id ) ;
	rs = pstmt.executeQuery() ;
	//boolean flag=true;

	while ( rs != null && rs.next() ) {
		String menu_id = rs.getString( "menu_id" ) ;
		//String option_type = rs.getString( "option_type" ) ;
		String submenu_id = rs.getString( "submenu_id" ) ;
		//String option_descriptor = rs.getString( "option_descriptor" ) ;
	//	String executable_name = rs.getString( "executable_name" ) ;

		if ( submenu_id != null ) {
			if ( !menu_id.equalsIgnoreCase( root_menu_id ) ) {
						out.println( menu_id + ".addMenuItem("+submenu_id+")" );
 				} else {
				out.println( "mainMenu.addMenuItem( " + submenu_id + " )" ) ;
			}
		}
	}
	rs.close();
	pstmt.close();
	out.println( "mainMenu.writeMenus() ;" ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);

	try {
		if ( rs != null ) rs.close() ;
		if ( pstmt != null ) pstmt.close() ;
	} catch ( Exception e ) {}

	}catch(Exception e){out.println(e);}
			finally { 
	if(con!=null)
	ConnectionManager.returnConnection(con,request);
}	

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
