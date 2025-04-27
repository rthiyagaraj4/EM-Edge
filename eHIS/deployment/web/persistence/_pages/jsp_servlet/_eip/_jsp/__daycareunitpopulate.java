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

public final class __daycareunitpopulate extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/DayCareUnitPopulate.jsp", 1742377590785L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></SCRIPT>\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<script>\n\t\t\tvar chk1 = eval(\"parent.frames[1].document.forms[0].chk\"+";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =");\n\t\t\tchk1.checked = true\n\n\t\t\t\t// code append  for 20414 date:29/mar/10\n\n\t\t\t\teval(\"parent.frames[1].document.forms[0].removeCode\"+";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =").value=\"N\";\n\t\t\t</script>\n\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<html>\n\t<head>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t</head>\n\t<body CLASS=\'MESSAGE\' onMouseDown=\"CodeArrest()\" onKeyDown=\"lockKey()\">\n\t\t<form name=Dynamic_form id=Dynamic_form>\n\t\t\t<input type=hidden name=E id=E value=\'";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'>\n\t\t\t<input type=hidden name=R id=R value=\'\'>\n\t\t\t<input type=hidden name=S id=S value=\'\'>\n\t\t\t<input type=hidden name=X id=X value=\'\'>\n\t\t\t<input type=hidden name=Y id=Y value=\'\'>\n\t\t</form>\n\t</body>\n\t</html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
Statement stmt1 = null;
ResultSet rs = null;
ResultSet rs1 = null;
String clearAll="";
try
{

	String search_by		= (request.getParameter("search_by"));
	String search_txt		= (request.getParameter("search_txt"));
	String search_criteria2	=  "";
	String search_criteria3	=  "";

	String facility_id=(String)session.getValue("facility_id");
	String nursing_unit_code=request.getParameter("nursing_unit_code");
	String clinic=request.getParameter("clinic_code");
	String cc=request.getParameter("cc");
	if(nursing_unit_code == null) nursing_unit_code="";
	if(clinic == null) clinic="";
	clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
	RecordSet	DayCareUnitSpeciality	=	null;
	DayCareUnitSpeciality	=	(webbeans.eCommon.RecordSet)	session.getAttribute("DayCareUnitSpeciality");
	con = ConnectionManager.getConnection(request);

	if(!clinic.equals(""))
	{
		String sql1 = "SELECT COUNT(*) total FROM IP_NURSING_UNIT_BED WHERE facility_id = '"+facility_id+"' AND nursing_unit_code = '"+nursing_unit_code+"' AND room_no in (SELECT practitioner_id FROM op_pract_for_clinic WHERE facility_id = '"+facility_id+"' AND clinic_code = '"+clinic+"' AND resource_class = 'R')";
		stmt1 = con.createStatement();
		rs1 = stmt1.executeQuery(sql1);
		if(rs1.next())
		{
			String ss = "";
			ss = rs1.getString("total"); 
			 if(!ss.equals("0"))
			{
			 out.println("<script>alert(getMessage('BED_DEFINED_FOR_ROOM','IP'))</script>");
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(cc));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(cc));
            _bw.write(_wl_block4Bytes, _wl_block4);
		 
			} 
		if(rs1 != null) rs1.close();
		if(stmt1 != null) stmt1.close();
		}
	}  

	if(clearAll.equals("clearAll"))
	{
		// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
		DayCareUnitSpeciality.clearAll();
	}
	else if(clearAll.equals("notCleared"))
	{
		// This loop will be executed if Select All checkbox is checked...
		//The values are removed from RecordSet & all the values from database is added..

	if(search_by.equals("ID")) search_by = "01";
	if(search_by.equals("DESC")) search_by = "02";
	if(search_by.equals("")||(search_by == null)) search_by = "00";

	if(search_by != null && !search_by.equals("00"))
	{
	  if(search_txt != null && !search_txt.equals(""))
	  {
		if(search_by.equals("01"))
		  {
			  search_criteria2 = " and UPPER(b.CLINIC_CODE) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(CLINIC_CODE) like UPPER('"+search_txt+"%') ";
		  }
		 else if(search_by.equals("02"))
		  {	
			  search_criteria2 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
			  search_criteria3 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
		  }
	  }
	}

			DayCareUnitSpeciality.clearAll();
			StringBuffer sql = new StringBuffer();
			sql.append("select a.facility_id,a.nursing_unit_code,a.clinic_code,b.clinic_code, b.short_desc from ip_dc_unit_for_nurs_unit a, op_clinic b where a.facility_id  = '"+facility_id+"' and a.nursing_unit_code = '"+nursing_unit_code+"' and  a.facility_id (+) = b.facility_id  and a.clinic_code (+) = b.clinic_code and   b.eff_status = 'E' ");
			sql.append(search_criteria2);
			sql.append(" union select facility_id, null, null ,clinic_code ,  short_desc from op_clinic where facility_id = '"+facility_id+"' and care_locn_type_ind = 'D' and eff_status = 'E'  and clinic_code not in ( select clinic_code from ip_dc_unit_for_nurs_unit where facility_id = '"+facility_id+"' and nursing_unit_code = '"+nursing_unit_code+"') ");
			sql.append(search_criteria3);

			stmt=con.createStatement();
			rs=stmt.executeQuery(sql.toString());

			while(rs.next())
			{
				DayCareUnitSpeciality.putObject(rs.getString(4));
			}
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
	}
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block6Bytes, _wl_block6);

	}catch(Exception e){out.print(e);}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
