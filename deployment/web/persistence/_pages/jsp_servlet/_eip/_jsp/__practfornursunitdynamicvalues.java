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

public final class __practfornursunitdynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/PractforNursUnitDynamicValues.jsp", 1742451908012L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</head>\n<body CLASS=\'MESSAGE\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n\t<form name=Dynamic_form id=Dynamic_form>\n\t\t<input type=hidden name=E id=E value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n\t\t<input type=hidden name=R id=R value=\'\'>\n\t\t<input type=hidden name=S id=S value=\'\'>\n\t\t<input type=hidden name=X id=X value=\'\'>\n\t\t<input type=hidden name=Y id=Y value=\'\'>\n\t</form>\n</body>\n</html>\n";
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
 request.setCharacterEncoding("UTF-8");  
            _bw.write(_wl_block1Bytes, _wl_block1);


Connection con = null;
Statement stmt= null;
ResultSet rs= null;

String clearAll="";
try
{
String facility_id=(String)session.getValue("facility_id");
String function_code=request.getParameter("function_code");
if(function_code == null) function_code="";
String Function=request.getParameter("Function");
if(Function == null) Function="";

String search_by    = request.getParameter("search_by") ;
if(search_by == null || search_by.equals("null")) search_by="";

String search_txt   = request.getParameter("search_txt") ;
if(search_txt == null || search_txt.equals("null")) search_txt="";

 clearAll = request.getParameter("clearAll");
	if(clearAll == null) clearAll="";
RecordSet	PractNursRecordSet	=	null;
PractNursRecordSet	=	(webbeans.eCommon.RecordSet)	session.getAttribute("PractNursRecordSet");
if(clearAll.equals("clearAll"))
{
	// This loop will be executed if Select All checkbox is unchecked & all values are removed from RecordSet
	PractNursRecordSet.clearAll();
}
else if(clearAll.equals("notCleared"))
{
		String search_criteria = "";
		String search_criteria2 = "";
		String search_criteria3 = "";
// This loop will be executed if Select All checkbox is checked...
//The values are removed from RecordSet & all the values from database is added..

		if(search_by != null && !search_by.equals(""))
		{
		  if(search_txt != null && !search_txt.equals(""))
		  {
			if(Function.equals("pract"))
			{
				if(search_by.equals("01"))
				{
				  search_criteria = " and UPPER(NURSING_UNIT_CODE) like UPPER('"+search_txt+"%') ";
				  search_criteria2 = " and UPPER(NURSING_UNIT_CODE) like upper('"+search_txt+"%') ";
				  search_criteria3 = " and UPPER(b.NURSING_UNIT_CODE) like upper('"+search_txt+"%') ";
				}
				else if(search_by.equals("02"))
				{
				  search_criteria = " and UPPER(NURSING_UNIT_SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria2 = " and UPPER(SHORT_DESC) like UPPER('"+search_txt+"%') ";
				  search_criteria3 = " and UPPER(b.SHORT_DESC) like UPPER('"+search_txt+"%') ";
				}
			}
			else if(Function.equals("nurs"))
			{
				if(search_by.equals("01"))
				  search_criteria = " and UPPER(PRACTITIONER_ID) like UPPER('"+search_txt+"%') ";
				else if(search_by.equals("02"))
				  search_criteria = " and UPPER(PRACTITIONER_NAME) like UPPER('"+search_txt+"%') ";
			}
		  }
		}

	PractNursRecordSet.clearAll();

	con = ConnectionManager.getConnection(request);
	StringBuffer sql=new StringBuffer();

	/*if(Function.equals("nurs"))
	{
		sql.append(" select practitioner_id \"code\" from am_pract_for_facility_vw where operating_facility_id='"+facility_id+"' and practitioner_id in (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') UNION select practitioner_id \"code\" from am_pract_for_facility_vw where operating_facility_id='"+facility_id+"' and 	eff_status='E' and practitioner_id NOT IN (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') "); 
	}
	else if(Function.equals("pract"))
	{
		sql.append(" select nursing_unit_code \"code\" from ip_nursing_unit where facility_id='"+facility_id+"' AND eff_status='E' and nursing_unit_code not in (select nursing_unit_code from ip_nursing_unit_for_pract where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"') union select a.nursing_unit_code  from ip_nursing_unit_for_pract a, ip_nursing_unit b where a.facility_id='"+facility_id+"' AND a.practitioner_id='"+function_code+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.nursing_unit_code ");

	}*/

	if(Function.equals("nurs"))
	{

		sql.append("select a.practitioner_id \"code\", a.practitioner_name \"desc\",a.pract_type practype, 'Y',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and practitioner_id in (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"' )and a.pract_type = b.pract_type "+search_criteria+" UNION select practitioner_id \"code\", practitioner_name \"desc\",a.pract_type,'N',b.Desc_Userdef from am_pract_for_facility_vw a, am_pract_type b where operating_facility_id='"+facility_id+"' and 	a.eff_status='E' and practitioner_id NOT IN (select practitioner_id from ip_nursing_unit_for_pract where facility_id='"+facility_id+"' and nursing_unit_code='"+function_code+"') and a.pract_type = b.pract_type "+search_criteria+" order by 2"); 
	}
	else if(Function.equals("pract"))
	{
		sql.append("select nursing_unit_code \"code\", short_desc \"desc\", 'N' from ip_nursing_unit where facility_id='"+facility_id+"' AND eff_status='E' and locn_type = 'N' and nursing_unit_code not in (select nursing_unit_code from ip_nursing_unit_for_pract where practitioner_id='"+function_code+"' and facility_id='"+facility_id+"') "+search_criteria2+" union select a.nursing_unit_code, short_desc,'Y' from ip_nursing_unit_for_pract a, ip_nursing_unit b where a.facility_id='"+facility_id+"' AND a.practitioner_id='"+function_code+"' AND a.facility_id=b.facility_id AND a.nursing_unit_code=b.nursing_unit_code "+search_criteria3+" order by 2");
	}

	stmt=con.createStatement();
	rs=stmt.executeQuery(sql.toString());
	while(rs.next())
	{
		PractNursRecordSet.putObject(rs.getString(1));
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
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
