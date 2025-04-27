package jsp_servlet._emr._jsp;

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

public final class __terminologysetforfacilitydynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/TerminologySetForFacilityDynamicValues.jsp", 1709119117832L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n<html>\n<head>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n<body CLASS=\'MESSAGE\' onKeyDown=\'lockKey()\'>\n\t<form name=Dynamic_form>\n\t\t<input type=hidden name=E value=\'";
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

request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request);
response.addHeader("X-XSS-Protection", "1; mode=block");
response.addHeader("X-Content-Type-Options", "nosniff");
Connection con = null;
Statement stmt=null;
ResultSet rs=null;
String clearAll="";
try
{
String term_set_id=request.getParameter("term_set_id");
if(term_set_id == null) term_set_id="";
//Below code was modified by N Munisekhar on 18-Dec-2012 against SKR-SCF-0739 [IN:036606]
String facility_desc=request.getParameter("facility_desc_text");
if(facility_desc == null || facility_desc.equals("undefined")) facility_desc="";
String search_criteria=request.getParameter("search_criteria");
  if(search_criteria == null || search_criteria.equals("undefined")) search_criteria="";

 clearAll = request.getParameter("clearAll");

	if(clearAll == null) clearAll="";
RecordSet	TerminologyForFacility	=	null;
TerminologyForFacility	=	(webbeans.eCommon.RecordSet)	session.getAttribute("TerminologyForFacility");
if(clearAll.equals("clearAll"))
{

         StringBuffer sql= new StringBuffer();
         sql.append("select a.facility_id facility_id,'U' db_action from mr_term_set_for_facility a, sm_facility_param b where a.term_set_id ='"+term_set_id+"' and b.facility_id = a.facility_id");
		   if(facility_desc!=null){ 
				 if(search_criteria.equals("S")){
					sql.append(" and upper(b.facility_name) not like upper('"+facility_desc+"%') ");
				}else if(search_criteria.equals("C")){
					sql.append(" and upper(b.facility_name) not like upper('%"+facility_desc+"%') ");
				}else if(search_criteria.equals("E")){
					sql.append(" and upper(b.facility_name) not like upper('%"+facility_desc+"') ");
				 }
             }
             sql.append(" order by 2 ");
			 
			TerminologyForFacility.clearAll();
            con = ConnectionManager.getConnection(request);
           stmt=con.createStatement();
           rs=stmt.executeQuery(sql.toString());
            sql.setLength(0);
           while(rs.next())
            {
          TerminologyForFacility.putObject(rs.getString(1));
		  }


}
else if(clearAll.equals("notCleared"))
{
 StringBuffer sql= new StringBuffer("select facility_id,'I' db_action from sm_facility_param where facility_id not in (select facility_id from mr_term_set_for_facility where term_set_id = '"+term_set_id+"') and status='E' ");
     if(facility_desc!=null){
	if(clearAll.equals("notCleared")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(facility_name) like upper('"+facility_desc+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(facility_name) like upper('%"+facility_desc+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(facility_name) like upper('%"+facility_desc+"') ");
		}
	}else if(clearAll.equals("clearAll")){
		if(search_criteria.equals("S")){
			sql.append(" and upper(facility_name) not like upper('"+facility_desc+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(facility_name) not like upper('%"+facility_desc+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(facility_name) not like upper('%"+facility_desc+"') ");
		}
	}
}

    sql.append(" union all ");
    sql.append("select a.facility_id facility_id,'U' db_action from mr_term_set_for_facility a, sm_facility_param b where a.term_set_id ='"+term_set_id+"' and b.facility_id = a.facility_id");
	if(facility_desc!=null){
	if(search_criteria.equals("S")){
			sql.append(" and upper(facility_name) not like upper('"+facility_desc+"%') ");
		}else if(search_criteria.equals("C")){
			sql.append(" and upper(facility_name) not like upper('%"+facility_desc+"%') ");
		}else if(search_criteria.equals("E")){
			sql.append(" and upper(facility_name) not like upper('%"+facility_desc+"') ");
		} 
		}
         sql.append(" order by 2 ");
//TerminologyForFacility.clearAll();
con = ConnectionManager.getConnection(request);
//String sql="select facility_id,'I' db_action from sm_facility_param where facility_id not in (select facility_id from mr_term_set_for_facility where term_set_id = '"+term_set_id+"') and status='E' union all select a.facility_id facility_id,'U' db_action from mr_term_set_for_facility a, sm_facility_param b where a.term_set_id ='"+term_set_id+"' and b.facility_id = a.facility_id order by 2";

 stmt=con.createStatement();
 rs=stmt.executeQuery(sql.toString());
 sql.setLength(0);
 //end SKR-SCF-0739 [IN:036606]
 
while(rs.next())
{
TerminologyForFacility.putObject(rs.getString(1));

}

}

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);
}
catch(Exception e){/* out.print(e); */e.printStackTrace();}
  finally
  {
	  if(rs!=null) rs.close();
	  if(stmt!=null) stmt.close();
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
