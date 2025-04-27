package jsp_servlet._eip._jsp;

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

public final class __nursunitspecialitydynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursUnitSpecialityDynamicValues.jsp", 1742446705197L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body CLASS=\'MESSAGE\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<form name=Dynamic_form id=Dynamic_form>\n\t\t<input type=hidden id=\'E\' name=E value=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\">\n\t\t<input type=hidden id=\'R\' name=R value=\'\'>\n\t\t<input type=hidden id=\'S\' name=S value=\'\'>\n\t\t<input type=hidden id=\'X\' name=X value=\'\'>\n\t\t<input type=hidden id=\'Y\' name=Y value=\'\'>\n\t</form>\n</body>\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

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

request.setCharacterEncoding("UTF-8");
Connection con = null;
Statement stmt = null;
ResultSet rs = null;
String clearAll="";
try
{
String facility_id=(String)session.getValue("facility_id");

String nursing_unit_code=request.getParameter("nursing_unit_code");
if(nursing_unit_code == null) nursing_unit_code = "";

String search_by		= checkForNull(request.getParameter("search_by"));
String search_txt		= checkForNull(request.getParameter("search_txt"));

clearAll = request.getParameter("clearAll");
if(clearAll == null) clearAll="";

String search_criteria	=  "";

if(search_by.equals("ID"))
	search_criteria  = " and upper(speciality_code) like UPPER('"+search_txt+"%') ";
else if(search_by.equals("DESC"))
	search_criteria  = " and upper(short_desc) like UPPER('"+search_txt+"%')  ";


RecordSet	NursUnitSpeciality	=	null;
NursUnitSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("NursUnitSpeciality");

if(clearAll.equals("clearAll"))
{
// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
	
	NursUnitSpeciality.clearAll();
}
else if(clearAll.equals("notCleared"))
{
//This loop will be executed if Select All checkbox is checked...
//The values are removed from RecordSet & all the values from database is added..

	NursUnitSpeciality.clearAll();

	con = ConnectionManager.getConnection(request);
	StringBuffer   sql  =new StringBuffer();
	sql.append(" SELECT A.specialty_code ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY A, AM_SPECIALITY B ");
	sql.append(" WHERE A.facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
	sql.append(" AND A.specialty_code=b.speciality_code AND B.eff_status='E' ");
	sql.append(search_criteria);
	sql.append(" UNION ");
	sql.append("SELECT speciality_code ");
	sql.append(" FROM AM_SPECIALITY ");
	sql.append(" WHERE speciality_code NOT IN ( SELECT specialty_code ");
	sql.append(" FROM IP_NURS_UNIT_FOR_SPECIALTY ");
	sql.append(" WHERE facility_id='"+facility_id+"' ");
	sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ) ");
	sql.append(" AND eff_status='E' ");
	sql.append(search_criteria);

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql.toString());
	while(rs.next())
	{
		NursUnitSpeciality.putObject(rs.getString(1));
	}
}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);

	if(stmt != null) stmt.close();
	if(rs != null) rs.close();	
}catch(Exception e){out.print(e);}
finally
{
ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
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
