package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __levelofcarefordependencydynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/LevelOfCareForDependencyDynamicValues.jsp", 1709116594449L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n  <script language=\"javascript\" src=\"../js/CpMessages.js\"></script>  \n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n<html>\n<head>\n</head>\n<body CLASS=\'MESSAGE\'>\n\t<form name=Dynamic_form>\n\t\t<input type=hidden name=E value=\'";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'>\n\t\t<input type=hidden name=R value=\'\'>\n\t\t<input type=hidden name=S value=\'\'>\n\t\t<input type=hidden name=X value=\'\'>\n\t\t<input type=hidden name=Y value=\'\'>\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
PreparedStatement pstmt = null;//common-icn-0180
String clearAll="";
try
{
String level_of_care_code=request.getParameter("level_of_care_code");
if(level_of_care_code == null) level_of_care_code="";

 clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
RecordSet	LevelOfCareForDependency	=	null;
LevelOfCareForDependency	=	(webbeans.eCommon.RecordSet)	session.getAttribute("LevelOfCareForDependency");
if(clearAll.equals("clearAll"))
{
LevelOfCareForDependency.clearAll();
}
else if(clearAll.equals("notCleared"))
{
	LevelOfCareForDependency.clearAll();

con = ConnectionManager.getConnection(request);
//String   sql  ="select  dependency_code, 'I' db_action from cp_dependency where dependency_code not in(select dependency_code from cp_loc_for_dependency where level_of_care_code = '"+level_of_care_code+"') and eff_status = 'E' union all select  a.dependency_code,'U' db_action from cp_loc_for_dependency a, cp_dependency b where level_of_care_code = '"+level_of_care_code+"' and b.dependency_code = a.dependency_code order by 2";//common-icn-0180
String   sql  ="select  dependency_code, 'I' db_action from cp_dependency where dependency_code not in(select dependency_code from cp_loc_for_dependency where level_of_care_code = ?) and eff_status = 'E' union all select  a.dependency_code,'U' db_action from cp_loc_for_dependency a, cp_dependency b where level_of_care_code = ? and b.dependency_code = a.dependency_code order by 2";//common-icn-0180

//stmt=con.createStatement();//common-icn-0180
pstmt = con.prepareStatement(sql);//common-icn-0180
pstmt.setString(1, level_of_care_code);//common-icn-0180
pstmt.setString(2, level_of_care_code);//common-icn-0180

 //rs=stmt.executeQuery(sql);//common-icn-0180
 rs=pstmt.executeQuery();//common-icn-0180
while(rs.next())
{
LevelOfCareForDependency.putObject(rs.getString(1));

}

}

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block4Bytes, _wl_block4);
}
catch(Exception e){out.print(e);}
  finally
  {
	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
	
	  if(con != null)
			ConnectionManager.returnConnection(con,request);

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
