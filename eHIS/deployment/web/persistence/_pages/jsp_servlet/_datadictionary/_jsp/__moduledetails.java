package jsp_servlet._datadictionary._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.DatabaseMetaData;
import webbeans.eCommon.ConnectionManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;

public final class __moduledetails extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/datadictionary/jsp/ModuleDetails.jsp", 1709113757160L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n<html>\n<head>\n<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n<link rel=\"stylesheet\" href=\"../css/moduleDetails.css\"/> \n<script type=\"text/javascript\">\nfunction showAttr(entityName){\n\tvar url = \"EntityAttributes.jsp?entityName=\"+entityName;\n\t//parent.REPWINDOW.location.href = url;\n\tparent.showInBottomFrame(url);\n\t//window.location.href = url;\n\t\n}\nfunction showAssociatedEntities(entityName){\n\tvar url = \"EntityAssociates.jsp?entityName=\"+entityName;\n\t//parent.REPWINDOW.location.href = url;\n\tparent.showInBottomFrame(url);\n\t//window.location.href = url;\n}\n\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body bgcolor=\"#F2F2F5\">\n\n<form name=\"moduleForm\" id=\"moduleForm\">\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<table width=\"99%\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" class=\"maintablestyle\" style=\"border: 1px;\">\n<tr>\n<td class=\"maintabletdstyle\">\n<b>List of views for Module :&nbsp;";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</b>\n</td>\n</tr>\n\n<tr>\n<td>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t <table width=\"99%\" border=\"5\" cellpadding=\"0\" cellspacing=\"0\" class=\"datatablestyle\">\n\t ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\n\t\t<tr>\t<th align=\"left\" class=\"datatablethstyle\">View Name</th>\n\t\t\t<th align=\"left\" class=\"datatablethstyle\">Description</th>\n\t\t\t<th align=\"center\" class=\"datatablethstyle\">Attributes</th>\n\t\t\t<th align=\"center\" class=\"datatablethstyle\">Associated Entities</th>\n\t\t</tr>\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\t\n\t\t\t<tr>\n\t\t\t<td width=\"25%\" class=\"datatabletdstyle\">";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</td>\n\t\t\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t\t<td width=\"48%\" class=\"datatabletdstyle\">This is a test for description column this is a very long description in deed just to test how the GUI is showing this column</td>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t\t\t<td width=\"48%\" class=\"datatabletdstyle\">&nbsp;</td>\n\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t\t\t<td align=\"center\" width=\"10%\" class=\"datatabletdstyle\"><img src=\"List_Attr.gif\" onclick=\"showAttr(\'";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\')\" ></img>\n\t\t\t</td>\n\t\t\t<td align=\"center\" width=\"15%\" class=\"datatabletdstyle\"><img src=\"Linked_Entities.gif\" onclick=\"showAssociatedEntities(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\')\"></img></td>\n\t\t\t</tr>\n\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\n\t\t</table>\n\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t<span class=\"spanstyle\">No records obtained for the selected module</span>\n\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n</td>\n</tr>\n</table>\n\n<input type=\"hidden\" id=\"hdnModuleName\" value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\"/>\n</form>\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

String moduleId = request.getParameter("moduleId");
if(moduleId == null){
	moduleId = "";
}
String moduleName = request.getParameter("moduleName");
if(moduleName == null){
	moduleName = "";
}

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(moduleName ));
            _bw.write(_wl_block4Bytes, _wl_block4);


String completeModuleName = moduleId+"%";

String query = "";

PreparedStatement prepStmt = null;
Connection conn = null;

try {
	conn = ConnectionManager.getConnection(request);
} catch (Exception e) {
	out.println("<span class='spanstyle'>Could not get connection. Error Message ="+e.getMessage()+"</span>");
	return;
}

// safe approach
if(conn == null){
	out.println("<span class='spanstyle'>Error in showing details as connection to the database was not obtained</span>");
	return;
}

String userName = "";
DatabaseMetaData dbmd = null;
try{
	dbmd = conn.getMetaData();	
}catch(Exception ex){
	out.println("<span class='spanstyle'>Error in showing details</span>");
	return;
}

if(dbmd == null){
	out.println("<span class='spanstyle'>Error in showing details</span>");
	return;
}

userName = dbmd.getUserName();

query = "SELECT A.OWNER,A.VIEW_NAME,B.TABLE_TYPE,B.COMMENTS FROM ALL_VIEWS A, ALL_TAB_COMMENTS B WHERE A.OWNER = B.OWNER AND A.VIEW_NAME = B.TABLE_NAME and A.owner = '"+userName+"' AND A.VIEW_NAME LIKE ('"+completeModuleName+"') AND B.TABLE_TYPE = 'VIEW'";

String entityName = "";
ResultSet rs = null;
int rowCount = 0;
try{
	prepStmt = conn.prepareStatement(query);
	rs = prepStmt.executeQuery();
	if(rs != null){
	 
            _bw.write(_wl_block5Bytes, _wl_block5);
	
		while(rs.next()){
			if(rowCount == 0){
		
            _bw.write(_wl_block6Bytes, _wl_block6);
		rowCount++;
			}
			entityName = rs.getString("VIEW_NAME");
			if(entityName != null && !entityName.trim().equals("")){
			
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(entityName ));
            _bw.write(_wl_block8Bytes, _wl_block8);

			if(rowCount == 1){
			
            _bw.write(_wl_block9Bytes, _wl_block9);

			}else{
			
            _bw.write(_wl_block10Bytes, _wl_block10);

			}
			
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(entityName ));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(entityName ));
            _bw.write(_wl_block13Bytes, _wl_block13);
	
			}
			rowCount++;
		}
		
            _bw.write(_wl_block14Bytes, _wl_block14);

		// indicates no records were fetched
		if(rowCount == 0){
		
            _bw.write(_wl_block15Bytes, _wl_block15);
	
		}
	}
	
}catch(Exception ex){
	out.println("<span class='spanstyle'>Could not obtain records for the module "+moduleName+"</span>");
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


            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(moduleName ));
            _bw.write(_wl_block17Bytes, _wl_block17);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
