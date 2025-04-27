package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.text.*;

public final class __ipadvbedmgmtfetchroomsnursingunits extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/IPAdvBedMgmtFetchRoomsNursingUnits.jsp", 1720526258625L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\'></link>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n</head>\n\n<body class=\'message\' onMouseDown=\'CodeArrest()\' onKeyDown=\'lockKey()\'>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar obj = parent.blank.document.bedMgmtSetupForm.nursing_unit\n\t\t\t\t\tvar element=parent.blank.document.createElement(\"option\");\n\t\t\t\t\telement.text=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n\t\t\t\t\telement.value=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\t\t\t\t\n\t\t\t\t\tobj.add(element)\n\t\t\t\t\t</script>\n\t\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t\t<script>\n\t\t\t\t\tvar obj = parent.blank.document.bedMgmtSetupForm.room;\n\t\t\t\t\tvar element=parent.blank.document.createElement(\"option\");\n\t\t\t\t\telement.text=\"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n</body>\n</html>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );


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
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block1Bytes, _wl_block1);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block2Bytes, _wl_block2);


request.setCharacterEncoding("UTF-8"); 
Connection con	= null;
Statement stmt	= null;
ResultSet rs	= null;
String calling_object = ""; 
String facility_id		= (String)session.getValue("facility_id");
String calling_from	= request.getParameter("calling_from");
	if(calling_from==null) calling_from="";

calling_object	= request.getParameter("object_name");

String param_val		= request.getParameter("object_val");
String other_code		= request.getParameter("other_code");
	if(other_code==null)	other_code="";
String room_no	= request.getParameter("room_no");
	if(room_no==null) room_no="";
	
	String operation = request.getParameter("operation")==null?"":request.getParameter("operation");

            _bw.write(_wl_block3Bytes, _wl_block3);

	try{
		con = ConnectionManager.getConnection(request);
		String sqlNursingUnit=" Select ip_get_desc.ip_nursing_unit('"+facility_id+"',nursing_unit_code,'en',2)short_desc, nursing_unit_code from IP_NURSING_UNIT where facility_id='"+facility_id+"' and locn_type = 'N' and eff_status='E' order by short_desc ";
		if(operation.equals("fetchNursingUnit")){
			sqlNursingUnit=" Select ip_get_desc.ip_nursing_unit('"+facility_id+"',nursing_unit_code,'en',2)short_desc, nursing_unit_code from IP_NURSING_UNIT where facility_id='"+facility_id+"' and locn_type = 'N' and eff_status='E'  and floor_width is not null order by short_desc ";
		}
		if(operation.equals("fetchNursingUnit_floor") || operation.equals("fetchNursingUnit")){
			
			stmt=con.createStatement();
			rs=stmt.executeQuery(sqlNursingUnit);
			if(rs!=null){
				while(rs.next()){
				
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(rs.getString(1)));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rs.getString(2)));
            _bw.write(_wl_block6Bytes, _wl_block6);
}
			}
		}else{
			String sql_room	="select room_no,(select short_desc from am_facility_room where OPERATING_FACILITY_ID=facility_id and ROOM_NUM=room_no)room_name from ip_nursing_unit_room where facility_id='"+facility_id+"' and nursing_unit_code='"+param_val+"' and eff_status='E' and ROOM_HEIGHT is not null order by 1 ";
			stmt=con.createStatement();
			//System.out.println("sql_room 1:"+sql_room);
			rs=stmt.executeQuery(sql_room);
			if(rs!=null){
				while(rs.next()){
				
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(rs.getString("room_name")));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(rs.getString("room_no")));
            _bw.write(_wl_block6Bytes, _wl_block6);
}			
			}
		}
		if(rs!=null)rs.close();
		if(stmt!=null)stmt.close();
	}catch(Exception e){
		out.println("<script>alert('Error in intermediate page')</script>");
	}finally{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block8Bytes, _wl_block8);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
