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

public final class __nursunitservicedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursUnitServiceDynamicValues.jsp", 1717136141697L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\t<html>\n\t<head>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n\t<body CLASS=\'MESSAGE\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t\t<form name=\'Dynamic_form\' id=\'Dynamic_form\'>\n\t\t\t<input type=hidden name=\'ServiceObj\' id=\'ServiceObj\' value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n\t\t</form>\n\t</body>\n\t</html>\n\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
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
RecordSet	NursUnitService	=	null;
RecordSet	NursUnitDeptService	=	null;

try
{
	String facility_id		= (String)session.getValue("facility_id");
	String nursing_unit_code= checkForNull(request.getParameter("nursing_unit_code"));
	String dept_code		= checkForNull(request.getParameter("dept_code"));
	String clearAll			= checkForNull(request.getParameter("clearAll"));
	String search_by		= checkForNull(request.getParameter("search_by"));
	String search_txt		= checkForNull(request.getParameter("search_txt"));
	String search_criteria2	=  "";
	String search_criteria3	=  "";

	NursUnitService	=	(webbeans.eCommon.RecordSet)session.getAttribute("NursUnitService");
	NursUnitDeptService	=	(webbeans.eCommon.RecordSet)session.getAttribute("NursUnitDeptService");

	if(clearAll.equals("clearAll"))
	{
		// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
		NursUnitService.clearAll();
		NursUnitDeptService.clearAll();
	}
	else if(clearAll.equals("notCleared"))
	{
		// This loop will be executed if Select All checkbox is checked...
		//The values are removed from RecordSet & all the values from database is added..
		NursUnitService.clearAll();
		NursUnitDeptService.clearAll();
		if(search_by.equals("")||(search_by == null)) search_by = "00";
		if(search_by != null && !search_by.equals("00"))
		{
			if(search_txt != null && !search_txt.equals(""))
			{
				if(search_by.equals("01"))
				{
					search_criteria2 = " and UPPER(c.SERVICE_CODE) like UPPER('"+search_txt+"%') ";
					search_criteria3 = " and UPPER(b.SERVICE_CODE) like UPPER('"+search_txt+"%') ";
				}
				else if(search_by.equals("02"))
				{	
					search_criteria2 = " and UPPER(c.SHORT_DESC) like UPPER('"+search_txt+"%') ";
					search_criteria3 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
				}
			}
		}

		con = ConnectionManager.getConnection(request);
		StringBuffer   sql  =new StringBuffer();
	/*	sql.append(" SELECT A.service_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE A, AM_FACILITY_SERVICE B, AM_SERVICE C ");
		sql.append(" WHERE A.facility_id= B.OPERATING_FACILITY_ID ");
		sql.append(" AND A.facility_id='"+facility_id+"' ");
		sql.append(" AND A.dept_code = B.dept_code ");
		sql.append(" AND B.dept_code = '"+dept_code+"'");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(" AND A.service_code=b.service_code AND B.eff_status='E' ");
		sql.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(search_criteria2);
		sql.append(" UNION ");
		sql.append(" SELECT A.service_code ");
		sql.append(" FROM AM_FACILITY_SERVICE A, AM_SERVICE B ");
		sql.append(" WHERE A.service_code = B.service_code and  A.operating_facility_id='"+facility_id+"' ");
		sql.append(" AND A.dept_code = '"+dept_code+"' ");
		sql.append(" AND A.service_code NOT IN ( SELECT service_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE ");
		sql.append(" WHERE facility_id='"+facility_id+"' ");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(" AND dept_code = '"+dept_code+"') ");
		sql.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(" AND A.eff_status='E' ");
		sql.append(search_criteria3);
		stmt=con.createStatement();*/

		sql.append(" SELECT A.service_code, a.dept_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE A, AM_FACILITY_SERVICE B, AM_SERVICE C ");
		sql.append(" WHERE A.facility_id= B.OPERATING_FACILITY_ID ");
		sql.append(" AND A.dept_code = B.dept_code ");
		sql.append(" AND A.facility_id='"+facility_id+"' ");			
		if(!dept_code.equals(""))
			sql.append(" AND B.dept_code = '"+dept_code+"'");
		sql.append(" AND B.service_code = C.service_code ");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"' ");
		sql.append(" AND A.service_code=b.service_code AND B.eff_status='E'");
		sql.append(" AND A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(search_criteria2);
		sql.append(" UNION ");
		sql.append(" SELECT A.service_code, a.dept_code");
		sql.append(" FROM AM_FACILITY_SERVICE A, AM_SERVICE B");
		sql.append(" WHERE A.service_code = B.service_code ");
		if(!dept_code.equals(""))
			sql.append(" AND A.dept_code = '"+dept_code+"'");
		sql.append(" AND A.operating_facility_id='"+facility_id+"' ");
		sql.append(" and A.service_code NOT IN ( SELECT service_code ");
		sql.append(" FROM IP_NURS_UNIT_FOR_SERVICE ");
		sql.append(" WHERE facility_id='"+facility_id+"' ");
		if(!dept_code.equals(""))
			sql.append(" AND dept_code = '"+dept_code+"'");
		sql.append(" AND nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(" and A.service_code not in (select service_code from ip_nursing_unit "); 
		sql.append(" Where nursing_unit_code='"+nursing_unit_code+"') ");
		sql.append(" AND A.eff_status='E' ");
		sql.append(search_criteria3);
		stmt=con.createStatement();
		rs=stmt.executeQuery(sql.toString());
		if(rs != null)
		{
			while(rs.next())
			{
				NursUnitService.putObject(checkForNull(rs.getString(1)));
				NursUnitDeptService.putObject(checkForNull(rs.getString(2)));
			}
		}
	}
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);

}catch(Exception e)
{
	e.printStackTrace();
}
finally
{
	if(stmt != null) stmt.close();
	if(rs != null) rs.close();
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
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
