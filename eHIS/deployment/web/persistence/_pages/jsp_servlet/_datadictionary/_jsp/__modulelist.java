package jsp_servlet._datadictionary._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public final class __modulelist extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/datadictionary/jsp/ModuleList.jsp", 1709113755457L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n</head>\n<body BGCOLOR=#C0DCCD TEXT=#000000 LINK=#000000 VLINK=#000000 ALINK=#990000>\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<TABLE >\n\t<TR><TD ALIGN = LEFT>\n\t<B><FONT FACE=Arial SIZE=4 COLOR=#000000>EHIS Table Modules </FONT></B>\n\t</TD>\n\t</TR>\n\t<TR>\n\t<TD ALIGN = LEFT>\n\t\t<Table>\n\t\t\t<tr>\n\t\t\t\t<td>\n\t\t\t\t\t<FONT FACE=Arial SIZE=1 COLOR=#000000><B>* Click the below EHIS Table Modules links for detailed column information</B>\n\t\t\t\t\t</FONT>\t\t\t\n\t\t\t\t</td>\n\t\t\t</tr>\n\t\t</Table>\n\t</TD>\n\t\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\t\n\t\t\t<TR><TD ALIGN = LEFT>\n\t\t\t<A HREF = \"ModuleDetails.jsp?moduleName=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\" TARGET=REPWINDOW><FONT FACE=Arial SIZE=1 style=\"text-transform: uppercase;\">";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t</FONT></TD></TR>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\n\t</TABLE>\n\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

PreparedStatement prepStmt = null;
Connection conn = null;

/* try {
	Class.forName("oracle.jdbc.driver.OracleDriver");
} catch (ClassNotFoundException e) {
	out.println("Could not get connection. Error Message ="+e.getMessage());
	return;
} 
String userName = "IBAEHIS";
String password = "IBAEHIS";
*/
try {
	/* conn = DriverManager.getConnection(
			"jdbc:oracle:thin:@130.78.62.59:1521:srdv", userName,
			password); */
	conn = ConnectionManager.getConnection(request);
} catch (Exception e) {
	out.println("Could not get connection. Error Message ="+e.getMessage());
	return;
}

// safe approach
if(conn == null){
	out.println("Error in showing the details as connection to the database was not obtained");
	return;
}

String query = "Select * from SM_Module order by upper(Module_name)";
ResultSet rs = null;
try{
	prepStmt = conn.prepareStatement(query);	
	rs = prepStmt.executeQuery();
	if(rs != null){
	
            _bw.write(_wl_block3Bytes, _wl_block3);

		String moduleName = "";
		String moduleId = "";
		while(rs.next()){
			moduleId = rs.getString("MODULE_ID");
			moduleName = rs.getString("MODULE_NAME");
		
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(moduleId ));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(moduleName ));
            _bw.write(_wl_block6Bytes, _wl_block6);
	
		}
	
            _bw.write(_wl_block7Bytes, _wl_block7);
	
	}
}catch(Exception ex){
	out.println("Could not get the list of modules. Error Message ="+ex.getMessage());
	return;
}
finally{
	if(rs != null){
		try{
			rs.close();
		}catch(Exception ex){
			
		}
	}
	
	if(prepStmt != null){
		try{
			prepStmt.close();
		}catch(Exception ex){
			
		}
	}
	ConnectionManager.returnConnection(conn, request);
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
