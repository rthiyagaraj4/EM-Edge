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

public final class __positionformdcpdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/PositionForMDCPDynamicValues.jsp", 1709116607293L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n</head>\n<body CLASS=\'MESSAGE\'>\n\t<form name=Dynamic_form>\n\t\t<input type=hidden name=\'E\' id=\'E\' value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n\t\t<input type=hidden name=\'R\' id=\'R\' value=\'\'>\n\t\t<input type=hidden name=\'S\' id=\'S\' value=\'\'>\n\t\t<input type=hidden name=\'X\' id=\'X\' value=\'\'>\n\t\t<input type=hidden name=\'Y\' id=\'Y\' value=\'\'>\n\t</form>\n</body>\n</html>\n";
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

request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
Connection con = null;
Statement stmt=null;
PreparedStatement pstmt = null;//common-icn-0180
ResultSet rs=null;
String clearAll="";
String facility_id1="";
String pract_type="";
String   sql  ="";

try
{
	//This file is saved on 18/10/2005.
facility_id1=request.getParameter("facility_id1");
if(facility_id1 == null) facility_id1="";
	pract_type=request.getParameter("pract_type");
if(pract_type == null) pract_type="";

clearAll = request.getParameter("clearAll");

if(clearAll == null) clearAll="";

RecordSet	PositionForMDCP	=	null;
PositionForMDCP	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PositionForMDCP");


if(clearAll.equals("clearAll"))
{
PositionForMDCP.clearAll();
}
else if(clearAll.equals("notCleared"))
{
con = ConnectionManager.getConnection(request);
//sql  ="SELECT  position_code,position_desc,'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = '"+facility_id1+"') AND role_type = 'P' AND ('"+pract_type+"' IS NULL OR staff_type='"+pract_type+"') AND eff_status = 'E' UNION ALL SELECT  a.position_code, b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = '"+facility_id1+"' AND b.position_code = a.position_code AND b.role_type = 'P' AND  ('"+pract_type+"' IS NULL OR staff_type='"+pract_type+"')AND eff_status = 'E' ORDER BY 2";
sql  ="SELECT  position_code,position_desc,'N' db_action FROM am_position WHERE position_code NOT IN(SELECT position_code FROM cp_position_for_mdcp WHERE facility_id = ?) AND role_type = 'P' AND (? IS NULL OR staff_type=?) AND eff_status = 'E' UNION ALL SELECT  a.position_code, b.position_desc, 'Y' db_action FROM cp_position_for_mdcp a, am_position b WHERE a.facility_id = ? AND b.position_code = a.position_code AND b.role_type = 'P' AND  (? IS NULL OR staff_type=?)AND eff_status = 'E' ORDER BY 2";


//stmt=con.createStatement();//common-icn-0180
//common-icn-0180 starts
pstmt=con.prepareStatement(sql);
pstmt.setString(1, facility_id1);
pstmt.setString(2, pract_type);
pstmt.setString(3, pract_type);
pstmt.setString(4, facility_id1);
pstmt.setString(5, pract_type);
pstmt.setString(6, pract_type);
 //rs=stmt.executeQuery(sql);//common-icn-0180
 rs=pstmt.executeQuery();
//common-icn-0180 ends
while(rs.next())
{
PositionForMDCP.putObject(rs.getString(1));

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
	  if(stmt!=null) stmt.close();
	  if(pstmt!=null) pstmt.close();//common-icn-0180
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
