package jsp_servlet._eop._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __patcheckout extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eop/jsp/PatCheckout.jsp", 1709119461929L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<Script src=\"../../eCommon/js/ValidateControl.js\" language=\"JavaScript\"></Script>\n<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\n<body onKeyDown = \'lockKey();\'>\n<form name=\"dynamic_checkout_form\" id=\"dynamic_checkout_form\">\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t\t<script>\n\t\t\t\tvar error = getMessage(\"DATE1_LT_DATE2\",\"OP\");\n\t\t\t\terror = error.replace(\"$\",getLabel(\'eOP.DispDateTime.label\',\'OP\'));\n\t\t\t\terror = error.replace(\"#\",getLabel(\'Common.SystemDate.label\',\'Common\'));\n\t\t\t\talert(error);\t\t\t\t\t\t\t\n\t\t\t\tparent.window.close(); \n\t\t\t</script> \n\t\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t\t<script>\n\t\t\t\t\talert(getMessage(\'DISP_DATE_GREATER_TODAY\',\'OP\'));\n\t\t\t\t\tparent.window.close();\n\t\t\t\t</script> \n\t\t\t\t";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\t<script>\n\t\tparent.frames[1].document.forms[0].submit();\n\t</script> \n</form>\n</body>\t\n</html>\n\n \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

	request.setCharacterEncoding("UTF-8");
	String encounter = request.getParameter("encounterid");
	String practitioner = request.getParameter("practitionerid");
	String locncode = request.getParameter("locncode");
	String patient = request.getParameter("patientid");
	String locntype = request.getParameter("locntype");
	String dispdatetime = request.getParameter("dispdatetime");
	
	PreparedStatement stmt 	= null;
	ResultSet rs	= null;	
	ResultSet rs1	= null;

	String fac_id   = (String) session.getValue( "facility_id" ) ;
	StringBuffer sql		= new StringBuffer();
	int maxRecord =0;
	
	Connection conn	= null;	
	try
	{
		conn=ConnectionManager.getConnection(request);
		

		sql.append("Select 'X' from OP_PATIENT_QUEUE where greatest(nvl(CHECK_IN_DATE_TIME,SYSDATE), nvl(ARRIVE_DATE_TIME,SYSDATE), nvl(SUBS_ARRIVE_DATE_TIME,SYSDATE), nvl(VITAL_SIGNS_DATE_TIME,SYSDATE), nvl(CONS_SRVC_START_DATE_TIME,SYSDATE)) >=to_date( ?,'dd/mm/yyyy hh24:mi') ");
		sql.append(" and patient_id = ? and facility_id = ? and trunc(queue_date) = trunc(sysdate) and locn_type =? and locn_code = ? and practitionerd_id = nvl(?,'*ALL') and queue_status = '*ALL' and encounter_id = ?");

		stmt=conn.prepareStatement(sql.toString());
		stmt.setString(1,dispdatetime);
		stmt.setString(2,patient);
		stmt.setString(3,fac_id);
		stmt.setString(4,locntype);
		stmt.setString(5,locncode);
		stmt.setString(6,practitioner);
		stmt.setString(7,encounter);

		rs = stmt.executeQuery();
						
		if(rs.next())
		{
			
            _bw.write(_wl_block6Bytes, _wl_block6);

		}
		else
		{				
			sql.append("Select count(*) as COUNT from op_patient_queue where encounter_id ="+encounter+" and facility_id = '"+fac_id+"' and queue_date =to_date('"+dispdatetime+"','dd/mm/yyyy hh24:mi') ");

			stmt=conn.prepareStatement(sql.toString());
			rs1=stmt.executeQuery();
			if(rs1 != null && rs1.next())
			{
				maxRecord = rs1.getInt("COUNT");
			}
				
			if(maxRecord != 0)
			{
				
            _bw.write(_wl_block7Bytes, _wl_block7);

			}
			if(rs1 != null) rs1.close();				
		}				
		if(rs != null) rs.close();
		if(stmt != null) stmt.close();

		sql.setLength(0);
	}
	catch (Exception e) { out.print(e.toString()); out.print("x:--"+sql); }
	finally
	{
		try
		{
			if( rs != null) rs.close();					
			if(rs1 != null) rs1.close();
			if(stmt != null) stmt.close();
			if(conn!=null)
				ConnectionManager.returnConnection(conn,request);		

		}
		catch(Exception e){}				
		
	}
	
            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
