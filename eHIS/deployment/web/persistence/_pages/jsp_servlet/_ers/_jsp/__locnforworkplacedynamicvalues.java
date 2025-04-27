package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __locnforworkplacedynamicvalues extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/LocnForWorkplaceDynamicValues.jsp", 1709121635090L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n</head>\n<body CLASS=\'MESSAGE\'>\n<form name=\"Dynamic_form\" id=\"Dynamic_form\">\n<input type=\"hidden\" name=\"E\" id=\"E\" value=\'";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'>\n<input type=hidden name=R value=\'\'>\n<input type=hidden name=S value=\'\'>\n<input type=hidden name=X value=\'\'>\n<input type=hidden name=Y value=\'\'>\n</form>\n</body>\n</html>\n";
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

Connection con = null;
PreparedStatement pstmt=null;
ResultSet rs=null;

String workplace_code="";
String facility_id="";
String location_type="";
String clearAll="";

try{
	workplace_code=request.getParameter("workplace_code")==null?"":request.getParameter("workplace_code");
	facility_id=request.getParameter("facility_id")==null?"":request.getParameter("facility_id");
	location_type=request.getParameter("location_type")==null?"":request.getParameter("location_type");
	clearAll = request.getParameter("clearAll")==null?"":request.getParameter("clearAll");

	RecordSet	LocationWorkplace	=	null;
	LocationWorkplace	=	(webbeans.eCommon.RecordSet)	session.getAttribute("LocationWorkplace");

	if(clearAll.equals("clearAll")){
		LocationWorkplace.clearAll();
	}
	else if(clearAll.equals("notCleared")){

		con = ConnectionManager.getConnection(request);

		String sql="select locn_code, 'I' db_action  from rs_locn_vw  where facility_id = ? and locn_type =?  and (facility_id,locn_code,locn_type) not in   (select facility_id,locn_type,locn_code from rs_locn_for_workplace where facility_id = ?  and workplace_code = ? ) union all select a.locn_code, 'U' db_action   from rs_locn_for_workplace a, rs_locn_vw b  where a.facility_id = ?  and a.workplace_code = ?  and a.locn_type = ?   and b.facility_id = a.facility_id   and b.locn_type = a.locn_type  and b.locn_code = a.locn_code  order by 1"; 

		//LocationWorkplace.clearAll();
		 pstmt=con.prepareStatement(sql);
		 pstmt.setString(1,facility_id);
		 pstmt.setString(2,location_type);
		 pstmt.setString(3,facility_id);
		 pstmt.setString(4,workplace_code);
		 pstmt.setString(5,facility_id);
		 pstmt.setString(6,workplace_code);
		 pstmt.setString(7,location_type);
		 rs=pstmt.executeQuery();
    	 while(rs.next())
		 {
			LocationWorkplace.putObject(rs.getString(1));
			LocationWorkplace.clearAll();
		 }
	}
	//for(int i=0; i<LocationWorkplace.getSize();i++)
		

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(clearAll));
            _bw.write(_wl_block3Bytes, _wl_block3);

	}
	catch(Exception e){
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		  if(pstmt!=null) pstmt.close();
		  if(rs!=null) rs.close();
		  if(con !=null)
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
