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

public final class __agegroupforassessnotedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/AgeGroupForAssessNoteDynamicValues.jsp", 1709116557216L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block4 ="\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
//This file is saved on 18/10/2005.

Connection con = null;
PreparedStatement pstmt=null;
ResultSet rs=null;
String clearAll="";
String assess_note_id = "";
String sql = ""; 
try
{
assess_note_id=request.getParameter("assess_note_id") == null ? "":request.getParameter("assess_note_id");
clearAll = request.getParameter("clearAll") == null ? "":request.getParameter("clearAll");
RecordSet	AgeGroupForAssessNote	=	null;
AgeGroupForAssessNote	=	(webbeans.eCommon.RecordSet)	session.getAttribute("AgeGroupForAssessNote");

if(clearAll.equals("clearAll"))
{
AgeGroupForAssessNote.clearAll();
}
else if(clearAll.equals("notCleared"))
{
AgeGroupForAssessNote.clearAll();

con = ConnectionManager.getConnection(request);
sql  =" select ?, a.age_group_code,a.long_desc, a.min_age, b.durn_desc min_age_durn_unit, a.max_age, c.durn_desc max_age_durn_unit, decode(a.gender,'M','Male','F','Female','U','Unknown') gender,'I' db_action from am_age_group a, am_duration_type b, am_duration_type c where age_group_code not in(select age_group_code from cp_assess_note_age_group where assess_note_id = ?) and eff_status = 'E' and b.durn_type = a.age_unit and c.durn_type = a.age_unit_max union all select ?,a.age_group_code, b.long_desc, b.min_age, c.durn_desc min_age_durn_unit, b.max_age, d.durn_desc max_age_durn_unit, decode(b.gender,'M','Male','F','Female','U','Unknown') gender,'U' db_action from cp_assess_note_age_group a, am_age_group b, am_duration_type c, am_duration_type d  where a.assess_note_id = ? and b.age_group_code = a.age_group_code and c.durn_type = b.age_unit and d.durn_type = b.age_unit_max order by 3 ";

pstmt=con.prepareStatement(sql);

pstmt.setString(1,assess_note_id);
pstmt.setString(2,assess_note_id);
pstmt.setString(3,assess_note_id);
pstmt.setString(4,assess_note_id);
rs=pstmt.executeQuery();
while(rs.next())
{
AgeGroupForAssessNote.putObject(rs.getString("age_group_code"));

}

}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);
}
catch(Exception e){out.print(e);}
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
