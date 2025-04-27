package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import webbeans.eCommon.*;
import java.util.HashMap;
import java.sql.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __libraryforcasetypedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/LibraryForCaseTypeDynamicValues.jsp", 1709116595871L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n</head>\n<body CLASS=\'MESSAGE\'>\n\t<form name=Dynamic_form>\n\t\t<input type=hidden name=E value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n\t\t<input type=hidden name=R value=\'\'>\n\t\t<input type=hidden name=S value=\'\'>\n\t\t<input type=hidden name=X value=\'\'>\n\t\t<input type=hidden name=Y value=\'\'>\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.
Connection con = null;
//Statement stmt=null;
  PreparedStatement pstmt	= null;

ResultSet rs=null;
String clearAll="";
con = ConnectionManager.getConnection(request);
String case_type_code="";
String   sql  ="";
String library_id="";
String version_no="";
String two_vals="";

try
{
 case_type_code=request.getParameter("case_type_code");
if(case_type_code == null) case_type_code="";

 clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
RecordSet	CaseTypeNote	=	null;
CaseTypeNote	=	(webbeans.eCommon.RecordSet)	session.getAttribute("CaseTypeNote");

if(clearAll.equals("clearAll"))
{
CaseTypeNote.clearAll();
}
else if(clearAll.equals("notCleared"))
{
CaseTypeNote.clearAll();

  // sql  =" select library_id,version_no,long_desc, 'I' db_action from CP_LIBRARY  where library_basis = 'C'    and status = 'F' and eff_status = 'E' and (library_id,version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = '"+case_type_code+"') union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = '"+case_type_code+"' and b.library_id = a.library_id and b.version_no = a.version_no order by 3";
  //sql  =" select library_id,version_no,long_desc, 'I' db_action from CP_LIBRARY  where library_basis = 'C'    and status = 'F' and eff_status = 'E' and (library_id,version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = ?) union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = ? and b.library_id = a.library_id and b.version_no = a.version_no order by 3";

  //sql  =" SELECT distinct library_id, version_no, long_desc, db_action FROM (SELECT library_id, version_no, long_desc, db_action, status, first_value(status) OVER (PARTITION BY library_id) firstvalue FROM (SELECT DISTINCT ad.library_id,ad.term_code,ad.version_no,ad.term_Set_id, ad.long_desc, ad.db_action, DECODE(b.term_code,NULL,'N','Y') status FROM (SELECT   DISTINCT a.library_id, a.version_no, b.term_code,b.term_set_id,a.long_desc, 'U' db_action FROM cp_library a, cp_term_code_for_case_type b WHERE a.library_basis = 'C' AND a.status = 'F' AND a.eff_status = 'E' AND b.case_type_code= '"+case_type_code+"') ad,cp_library_intervention b WHERE ad.library_id = b.library_id(+) AND ad.term_code = b.term_code(+) AND ad.term_set_id = b.term_set_id(+) AND ad.version_no = b.version_no(+) ORDER BY status)) WHERE firstvalue = 'Y' AND (library_id, version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = ?) union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = ? and b.library_id = a.library_id and b.version_no = a.version_no order by 3"; //common-icn-0180
  sql  =" SELECT distinct library_id, version_no, long_desc, db_action FROM (SELECT library_id, version_no, long_desc, db_action, status, first_value(status) OVER (PARTITION BY library_id) firstvalue FROM (SELECT DISTINCT ad.library_id,ad.term_code,ad.version_no,ad.term_Set_id, ad.long_desc, ad.db_action, DECODE(b.term_code,NULL,'N','Y') status FROM (SELECT   DISTINCT a.library_id, a.version_no, b.term_code,b.term_set_id,a.long_desc, 'U' db_action FROM cp_library a, cp_term_code_for_case_type b WHERE a.library_basis = 'C' AND a.status = 'F' AND a.eff_status = 'E' AND b.case_type_code= ?) ad,cp_library_intervention b WHERE ad.library_id = b.library_id(+) AND ad.term_code = b.term_code(+) AND ad.term_set_id = b.term_set_id(+) AND ad.version_no = b.version_no(+) ORDER BY status)) WHERE firstvalue = 'Y' AND (library_id, version_no) not in (select library_id,version_no from cp_case_type_for_library where case_type_code = ?) union all select a.library_id,a.version_no,b.long_desc, 'I' db_action from cp_case_type_for_library a, cp_library b where a.case_type_code = ? and b.library_id = a.library_id and b.version_no = a.version_no order by 3"; //common-icn-0180

 //stmt=con.createStatement();
 pstmt = con.prepareStatement( sql);
 pstmt.setString(1,case_type_code);//common-icn-0181
 pstmt.setString(2,case_type_code);
 pstmt.setString(3,case_type_code);
 
	rs=pstmt.executeQuery();
 //rs=stmt.executeQuery(sql);
while(rs.next())
{
	 library_id=rs.getString("library_id");
	 version_no=rs.getString("version_no");
	 two_vals=library_id+"~"+version_no;
CaseTypeNote.putObject(two_vals);
}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);
}
catch(Exception e){
	//out.print(e);//COMMON-ICN-0181
       e.printStackTrace();//COMMON-ICN-0181
	}
  finally
  {
	  if(rs!=null) rs.close();
	  if(pstmt!=null) pstmt.close();
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
