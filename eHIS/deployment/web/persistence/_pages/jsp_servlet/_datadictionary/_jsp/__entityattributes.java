package jsp_servlet._datadictionary._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;

public final class __entityattributes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/datadictionary/jsp/EntityAttributes.jsp", 1709113755145L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<link rel=\"stylesheet\" href=\"../css/moduleDetails.css\"/>\n</head>\n<body bgcolor=\"#F2F2F5\">\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" >\n<tr>\n     <td class=\"maintabletdstyle\"> <b>List of attributes for view :&nbsp;";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" </b>\n     </td>\n</tr>\n<tr>\n<td>\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<table width=\"100%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\">\n\t<tr>\t\n\t\t<th align=\"left\" class=\"datatablethstyle\">No</th>\n\t\t<th align=\"left\" class=\"datatablethstyle\">Name</th>\n\t\t<th align=\"left\" class=\"datatablethstyle\">Type</th>\n\t\t<th align=\"left\" class=\"datatablethstyle\">Descriptions</th>\n\t</tr>\t\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<tr>\n\t\t\t\t<td width=\"7%\" align=\"left\" class=\"datatabletdstyle\">";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td width=\"25%\" align=\"left\" class=\"datatabletdstyle\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\t\t\t\t</td>\n\t\t\t\t<td width=\"20%\" align=\"left\" class=\"datatabletdstyle\">";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\t\t\t\t\n\t\t\t\t</td>\n\t\t\t\t<td width=\"48%\" align=\"left\" class=\"datatabletdstyle\">";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</td>\n\t\t\t</tr>\t\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t</table>\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\n</td>\n</tr>\t\n</table>\n\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\n</body>\n</html>\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

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

String entityName = request.getParameter("entityName");
if(entityName == null){
	entityName = "";
}
Connection conn = null;

try {
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

String query = "SELECT ROWNUM NUMB, ATTRIBUTE_NAME, data_type||'('||data_length||')' data_type, DESCRIPTIONS FROM ( SELECT  A.column_name ATTRIBUTE_NAME, A.data_type, A.data_length, B.COMMENTS DESCRIPTIONS FROM all_tab_columns A, user_col_comments B WHERE A.table_name = '"+entityName+"' AND OWNER = 'IBAEHIS' AND A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME ORDER BY 1 )";
//query = " SELECT  A.column_name ATTRIBUTE_NAME, A.data_type, A.data_length, B.COMMENTS DESCRIPTIONS FROM all_tab_columns A, user_col_comments B WHERE A.table_name = '"+entityName+"' AND OWNER = 'IBAEHIS' AND A.TABLE_NAME = B.TABLE_NAME AND A.COLUMN_NAME = B.COLUMN_NAME ORDER BY 1 ";
PreparedStatement prepStmt = null;
ResultSet rs = null;


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(entityName ));
            _bw.write(_wl_block4Bytes, _wl_block4);

try{
	prepStmt = conn.prepareStatement(query);
	rs = prepStmt.executeQuery();
	if(rs != null){
	
            _bw.write(_wl_block5Bytes, _wl_block5);
	
		Object numbObj = null;
		while(rs.next()){
			String desc = rs.getString("DESCRIPTIONS");
			if(desc == null){
				desc = "&nbsp;";
			}
			
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(rs.getObject("NUMB") ));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rs.getString("ATTRIBUTE_NAME") ));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(rs.getObject("data_type") ));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(desc ));
            _bw.write(_wl_block10Bytes, _wl_block10);
		
		}
	
            _bw.write(_wl_block11Bytes, _wl_block11);

	}else{
		out.println("Could not obtain records for "+entityName);
		return;
	}

            _bw.write(_wl_block12Bytes, _wl_block12);
	
}catch(Exception ex){
	out.println("Could not obtain records for "+entityName);
	return;
}finally{
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



            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
