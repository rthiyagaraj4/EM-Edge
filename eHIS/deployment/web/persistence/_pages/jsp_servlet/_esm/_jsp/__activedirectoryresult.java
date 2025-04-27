package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.text.*;
import webbeans.eCommon.*;
import org.json.simple.*;
import java.util.*;
import com.ehis.util.*;

public final class __activedirectoryresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/ActiveDirectoryResult.jsp", 1709121689495L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n<head>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n    <script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n    <script src=\"../../eCommon/js/common.js\" language=\"javascript\"></script>\n    <script src=\"../../eSM/js/ActiveDirectoryLoookup.js\" language=\"javascript\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n<table border=\"1\" cellpadding=\"0\" cellspacing=\"0\" width=\"100%\" align=\"center\" id=\"ResultTab\">\n\n<th>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</th>\n\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t<tr onClick=\"Modify(\'";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\');\">\n\n\t\t<td class=\"";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\" onmouseover=\"changeCursor(this);\" ><font class=\'HYPERLINK\'>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="</font></td>\n\n\t\t<input type=\"hidden\" name =\"hd_";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\">\n\n\t\t</tr>\n";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\n</table>\n\n\n\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

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

String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")? (String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);


Connection conn = null;
String classvalue = "gridData" ;
int recCount = 1;
int notlinkedcnt = 0;

String retvaljson = request.getParameter("retvaljson");
String retDataCnt = request.getParameter("retDataCnt");

int retCnt = Integer.parseInt(retDataCnt);

String[] arrOfStr = retvaljson.split("}",retCnt);

int indexval;
int indexval1;
String value = "";
String active_dir_id = "";
String id_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.ActiveDirectoryID.label","sm_labels");

try{

conn = ConnectionManager.getConnection(request);


            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(id_desc));
            _bw.write(_wl_block9Bytes, _wl_block9);

for(int g=0;g<arrOfStr.length;g++)
{
	indexval = arrOfStr[g].indexOf("sAMAccountName",1)+17; 
	indexval1 = arrOfStr[g].indexOf("displayName",1); 
	value = arrOfStr[g].substring(indexval,indexval1).trim();
	value = value.substring(0,value.length()-3).trim();

	String loginID			= value;
	PreparedStatement pstmt	= null;
	ResultSet  rs			= null;

	try{
		
		String sql = " SELECT active_dir_id, appl_user_id, app_password.decrypt (appl_user_password) AS appl_user_password, app_password.decrypt (pin_no) AS appl_user_pin FROM sm_appl_user WHERE upper(active_dir_id) = upper('"+loginID+"') ";
		
		pstmt = conn.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		if(rs != null && rs.next()){

			active_dir_id = rs.getString("active_dir_id")==null?"":rs.getString("active_dir_id");
			
		}else{
			active_dir_id = "";
		}
							
	}catch(Exception ex){
		ex.printStackTrace();
	}finally{
		try{
			if(pstmt !=null) pstmt.close();
			if(rs !=null) rs.close();
		}
		catch(Exception fe){
		}
	}

	if(active_dir_id.equals("")){

            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(classvalue));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(value));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(recCount));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(value));
            _bw.write(_wl_block15Bytes, _wl_block15);

		notlinkedcnt++;
	}

	recCount++;

}

if(notlinkedcnt == 0){
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.frames[1].location.href ='../../eCommon/html/blank.html';</script>");
}

}catch(Exception e){
	e.printStackTrace();
}finally { 
	ConnectionManager.returnConnection(conn,request);
}

            _bw.write(_wl_block16Bytes, _wl_block16);
            _bw.write(_wl_block2Bytes, _wl_block2);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
