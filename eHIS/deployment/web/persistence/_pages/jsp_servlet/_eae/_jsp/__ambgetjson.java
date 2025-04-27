package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.io.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __ambgetjson extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AMBGetJSON.jsp", 1709113771363L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

/* Table name specifies the table to query */
	String table	= checkForNull(request.getParameter( "table" )) ;
	String amb_nature_Code	= checkForNull(request.getParameter( "amb_nature_Code" )) ;
	String escort_type_code	= checkForNull(request.getParameter( "escort_type_code" )) ;
	String short_desc	= checkForNull(request.getParameter( "short_desc" )) ;
	String res_town_code	= checkForNull(request.getParameter( "res_town_code" )) ;
	
	String facility_id	=(String) session.getAttribute("facility_id");
	StringBuffer listData= new StringBuffer("{\""+table+"\" : [");

	Connection con				=	null;
	Statement stmt				=	null;
	PreparedStatement pstmt=null;
	ResultSet rs 				=	null;
	ArrayList stores 			=	new ArrayList();
	try 
		{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();
		if (table.equals("ae_amb_nature"))
		{
			String sql_query= "select amb_nature_Code, short_desc  from ae_amb_nature  WHERE amb_nature_Code LIKE UPPER('"+amb_nature_Code+"%') AND UPPER(short_desc) LIKE UPPER('"+short_desc+"%') and eff_Status = 'E' order by 1";
			
			rs = stmt.executeQuery(sql_query);
			
			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					amb_nature_Code = rs.getString("amb_nature_Code");
					short_desc = rs.getString("short_desc");
					listData.append("{\"amb_nature_Code\":"+"\""+amb_nature_Code+"\",");
					listData.append("\"short_desc\":"+"\""+short_desc+"\"}");
				}
				listData.append("]}");
			}
		}
		else if (table.equals("ae_amb_service_type"))
		{
			String amb_service_type	= checkForNull(request.getParameter( "amb_service_type" )) ;
			String long_desc	= checkForNull(request.getParameter( "long_desc" )) ;

			String sql_query= "select  amb_service_type, long_desc  from ae_amb_service_type  WHERE amb_service_type LIKE UPPER('"+amb_service_type+"%') AND UPPER(long_desc) LIKE UPPER('"+long_desc+"%') and eff_Status = 'E' order by 1";
			rs = stmt.executeQuery(sql_query);
			
			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					amb_service_type = rs.getString("amb_service_type");
					long_desc = rs.getString("long_desc");
					listData.append("{\"amb_service_type\":"+"\""+amb_service_type+"\",");
					listData.append("\"long_desc\":"+"\""+long_desc+"\"}");
				}
				listData.append("]}");
			}
		}
		else if (table.equals("am_escort_type"))
		{
			String sql_query= "select escort_type_code, short_desc  from am_escort_type  WHERE escort_type_code LIKE UPPER('"+escort_type_code+"%') AND UPPER(short_desc) LIKE UPPER('"+short_desc+"%') and eff_Status = 'E' order by 1";
			rs = stmt.executeQuery(sql_query);

			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					escort_type_code = rs.getString("escort_type_code");
					short_desc = rs.getString("short_desc");
					listData.append("{\"escort_type_code\":"+"\""+escort_type_code+"\",");
					listData.append("\"short_desc\":"+"\""+short_desc+"\"}");
				}
				listData.append("]}");
			}
		}
		else if (table.equals("mp_res_town"))
		{
			String sql_query= "select short_desc,res_town_code from mp_res_town where   res_town_code LIKE UPPER('"+res_town_code+"%') AND UPPER(short_desc) LIKE UPPER('"+short_desc+"%') and eff_Status = 'E' order by 1";
			rs = stmt.executeQuery(sql_query);

			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					res_town_code = rs.getString("res_town_code");
					short_desc = rs.getString("short_desc");
					listData.append("{\"res_town_code\":"+"\""+res_town_code+"\",");
					listData.append("\"short_desc\":"+"\""+short_desc+"\"}");
				}
				listData.append("]}");
			}
		} 
		else if (table.equals("ae_amb_vehicle"))
		{
			String amb_vehicle_id	= checkForNull(request.getParameter( "amb_vehicle_id" )) ;
			String amb_vehicle_name	= checkForNull(request.getParameter( "amb_vehicle_name")) ;

			String sql_query= "SELECT amb_vehicle_id, amb_vehicle_name from ae_amb_vehicle where amb_vehicle_id LIKE UPPER('"+amb_vehicle_id+"%') AND UPPER(amb_vehicle_name) LIKE UPPER('"+amb_vehicle_name+"%') and suspend_maint_yn = 'N' and eff_Status = 'E' and facility_id = '"+facility_id+"' order by 1";
			
			rs = stmt.executeQuery(sql_query);

			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					amb_vehicle_id = rs.getString("amb_vehicle_id");
					amb_vehicle_name = rs.getString("amb_vehicle_name");
					listData.append("{\"amb_vehicle_id\":"+"\""+amb_vehicle_id+"\",");
					listData.append("\"amb_vehicle_name\":"+"\""+amb_vehicle_name+"\"}");
				}
				listData.append("]}");
			}
		}
		else if (table.equals("sm_appl_user"))
		{
			String appl_user_id	= checkForNull(request.getParameter( "appl_user_id" )) ;
			String appl_user_name	= checkForNull(request.getParameter( "appl_user_name")) ;

			String sql_query= "Select appl_user_name , appl_user_id from sm_appl_user where appl_user_id LIKE UPPER('"+appl_user_id+"%') AND UPPER(appl_user_name) LIKE UPPER('"+appl_user_name+"%') and eff_Status = 'E' order by 1";
			
			rs = stmt.executeQuery(sql_query);

			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					appl_user_id = rs.getString("appl_user_id");
					appl_user_name = rs.getString("appl_user_name");
					listData.append("{\"appl_user_id\":"+"\""+appl_user_id+"\",");
					listData.append("\"appl_user_name\":"+"\""+appl_user_name+"\"}");
				}
				listData.append("]}");
			}
		}
		else if (table.equals("am_resource"))
		{
			String resource_id		 = checkForNull(request.getParameter( "resource_id" )) ;
			String resource_desc	 = checkForNull(request.getParameter( "resource_desc")) ;
			String amb_resource_type = "" ;

			String sql_query= "select practitioner_id||'~'||(select position_desc from am_position where position_code =a.position_code)||'~P' resource_id, practitioner_name resource_desc from am_practitioner a where practitioner_id LIKE UPPER('"+resource_id+"%') AND UPPER(practitioner_name) LIKE UPPER('"+resource_desc+"%') and eff_Status = 'E'  union select practitioner_id||'~'||(select position_desc from am_position where position_code =a.position_code)||'~E' resource_id, practitioner_name resource_desc from am_ext_practitioner a where practitioner_id LIKE UPPER('"+resource_id+"%') AND UPPER(practitioner_name) LIKE UPPER('"+resource_desc+"%') and eff_Status = 'E' union SELECT other_staff_id||'~'||(select long_desc from AM_OTHER_STAFF_TYPE where OTHER_STAFF_TYPE =a.OTHER_STAFF_TYPE)||'~O' resource_id, other_staff_name resource_desc from AM_OTHER_STAFF A  where other_staff_id LIKE UPPER('"+resource_id+"%') AND UPPER(other_staff_name) LIKE UPPER('"+resource_desc+"%') and eff_Status = 'E' union select resource_id||'~Equipment~Q' resource_id, long_desc resource_desc from am_resource where resource_id LIKE UPPER('"+resource_id+"%') AND UPPER(long_desc) LIKE UPPER('"+resource_desc+"%') and eff_status = 'E' ";
			 
			
			rs = stmt.executeQuery(sql_query);

			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					resource_id = rs.getString("resource_id");
					resource_desc = rs.getString("resource_desc");
					listData.append("{\"resource_id\":"+"\""+resource_id+"\",");
					listData.append("\"resource_desc\":"+"\""+resource_desc+"\"}");
				}
				listData.append("]}");

				
			}
		}
		else if (table.equals("am_resource_equip"))
		{
			String resource_id	= checkForNull(request.getParameter( "resource_id" )) ;
			String long_desc	= checkForNull(request.getParameter( "long_desc")) ;

			String sql_query= "select resource_id, long_desc  from am_resource where resource_id LIKE UPPER('"+resource_id+"%') AND UPPER(long_desc) LIKE UPPER('"+long_desc+"%') and eff_status = 'E'";
		
			rs = stmt.executeQuery(sql_query);

			if( rs != null)
			{
				int cnt=0;
				while ( rs.next() )
				{
					if (cnt++ > 0)
						listData.append(",");
					resource_id = rs.getString("resource_id");
					long_desc = rs.getString("long_desc");
					listData.append("{\"resource_id\":"+"\""+resource_id+"\",");
					listData.append("\"long_desc\":"+"\""+long_desc+"\"}");
				}
				listData.append("]}");
			}
		}		

	out.println(listData);

	}
	catch (Exception e)
	{
		//out.println( " Error from New Store Validate : " +  e.getMessage());
		e.printStackTrace(System.err);
	}
	finally
	{
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();
		if(pstmt != null) pstmt.close();
		if(con!=null) ConnectionManager.returnConnection(con,request);
	}
            _bw.write(_wl_block1Bytes, _wl_block1);
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
