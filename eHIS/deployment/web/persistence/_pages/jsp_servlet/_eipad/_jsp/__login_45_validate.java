package jsp_servlet._eipad._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.XMLStringParser;
import webbeans.eCommon.ConnectionManager;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.util.*;

public final class __login_45_validate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eipad/jsp/Login-Validate.jsp", 1709116953098L ,"10.3.6.0","Asia/Calcutta")) return true;
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

XMLStringParser parser = new XMLStringParser();
Hashtable hash = (Hashtable)parser.parseXMLString( request ) ;
hash = (Hashtable)hash.get("SEARCH") ;

String locale;
if(session.getAttribute("LOCALE")!=null && !session.getAttribute("LOCALE").equals(""))
	locale = (String)session.getAttribute("LOCALE");
else 
	locale = "en";
String responsibilityId = "";
responsibilityId = (String) hash.get("resp_ID")==null?"":(String) hash.get("resp_ID") ;
//final String MENUID = "CA";
//final String EFFSTATUS = "E";
//String query = "SELECT DISTINCT (COUNT (A.MENU_ID)) REC_COUNT FROM SM_RESP A, SM_MENU_HDR B, SM_MENU_DTL C WHERE A.MENU_ID = '"+MENUID+"' AND A.RESP_ID = '"+responsibilityId +"' AND A.EFF_STATUS = '"+EFFSTATUS+"'  AND NVL (A.EFF_DATE_TO, SYSDATE) >= SYSDATE  AND A.MENU_ID = B.MENU_ID  AND B.MENU_ID = C.MENU_ID  ORDER BY 1";
//String checkCAFuncAccess = "select count(*) from sm_menu_dtl where function_id='CLINICIAN_ACCESS' and menu_id not in (select menu_id from sm_menu_rstrn_resp where EXCL_RESTRICT_IND in ('R','E')) connect by menu_id = prior submenu_id start with menu_id in (select menu_id from sm_resp_lang_vw where resp_id='"+responsibilityId+"' and language_id = '"+locale+"')";
String checkCAFuncAccess = "select count(*) from sm_menu_dtl where function_id='CLINICIAN_ACCESS' connect by menu_id = prior submenu_id start with menu_id in (select menu_id from sm_resp_lang_vw where resp_id='"+responsibilityId+"' and language_id = '"+locale+"')";
ResultSet rs = null;
Statement stmt = null;
Connection conn = null;

int recordCount = 0;

try{ 
	conn = ConnectionManager.getConnection(request);
}catch(Exception ex){
	out.write(recordCount);
	return;
}

if(conn == null){
	out.write(recordCount);
	return;
}

try{
	
	stmt = conn.createStatement();	
	rs = stmt.executeQuery(checkCAFuncAccess);
	if(rs != null){
		Object countObj = null;
		while(rs.next()){
			countObj = rs.getObject(1);
		}
		if(countObj instanceof Number){
			recordCount = ((Number)countObj).intValue();
			out.write(""+recordCount);
		}
	}
	
	out.write(""+recordCount);
}catch(Exception ex){
	out.write(recordCount);
	return;
}finally{
	if(rs != null){
		try{
			rs.close();	
		}catch(Exception ex){
			// cannot do any thing
		}
	}
	if(stmt != null){
		try{
			stmt.close();	
		}catch(Exception ex){
			// cannot do any thing
		}
	}
	ConnectionManager.returnConnection(conn, request);
}


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
