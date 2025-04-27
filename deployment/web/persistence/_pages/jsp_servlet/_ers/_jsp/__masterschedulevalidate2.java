package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import java.sql.*;
import eCommon.Common.*;
import webbeans.eCommon.*;

public final class __masterschedulevalidate2 extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/MasterScheduleValidate2.jsp", 1709117441306L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

/*
*	Copyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED
*	Application		:	eRS
*   File Name		:	MasterSheduleValidate2.jsp
*	Purpose 		:	To assign the shift to a particular staff according to the selected shift pattern
*	Created By		:	Subbulakshmy. K
*	Created On		:	25-11-2004
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            webbeans.eCommon.XMLStringParser XMLobj= null;{
                XMLobj=(webbeans.eCommon.XMLStringParser)pageContext.getAttribute("XMLobj");
                if(XMLobj==null){
                    XMLobj=new webbeans.eCommon.XMLStringParser();
                    pageContext.setAttribute("XMLobj",XMLobj);

                }
            }
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
  
	String mode= request.getParameter("mode")==null?"":request.getParameter("mode") ;		
	String facility_id= request.getParameter("facility_id")==null?"":request.getParameter("facility_id") ;
	String shift_pattern_id= request.getParameter("shift_pattern_id")==null?"":request.getParameter("shift_pattern_id") ;	
	String week_no= request.getParameter("week_no")==null?"":request.getParameter("week_no") ;
	String role_type= request.getParameter("role_type")==null?"":request.getParameter("role_type") ;	
	String staff_id= request.getParameter("staff_id")==null?"":request.getParameter("staff_id") ;
	String position_code= request.getParameter("position_code")==null?"":request.getParameter("position_code");

	Connection conn 				= null;
	PreparedStatement pstmt 	    = null;
	ResultSet resultSet 			= null;
	ArrayList Shift_Dtl	            = new ArrayList();
	String[] record					= null;
	try {
		 conn = ConnectionManager.getConnection(request);
		String sql_shift_dtl		="SELECT a.day_no, a.shift_code, a.shift_mnemonic, b.shift_indicator, b.productive_flag  FROM rs_shift_pattern_dtl a, am_shift b WHERE a.facility_id = ? and a.shift_pattern_id=? AND a.week_no = ? and a.shift_code=b.shift_code";

		//to get the date range
		pstmt = conn.prepareStatement( sql_shift_dtl);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,shift_pattern_id);
		pstmt.setString(3,week_no);
		resultSet = pstmt.executeQuery() ;
		System.err.println("shift_pattern_id-------|" +shift_pattern_id+ "|------week_no------|" +week_no+ "|---");
		while (resultSet != null && resultSet.next()) {
			record = new String[5];				
			record[0] = resultSet.getString("day_no");
			record[1] = resultSet.getString("shift_code");
			record[2] = resultSet.getString("shift_mnemonic");
			record[3] = resultSet.getString("shift_indicator");
			record[4] = resultSet.getString("productive_flag");
			Shift_Dtl.add(record) ;
		}
		
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
		//to add shifts
		if(mode.equals("all"))
			for(int i=0;i<Shift_Dtl.size();i++){
				record = (String[])Shift_Dtl.get(i);
				out.println( "assignallShift(\"" + record[0] + "\",\"" + record[1] + "\",\""+record[2]+ "\",\"" +record[3] + "\",\""+record[4]+"\") ; " ) ;		
			}
		else
			for(int i=0;i<Shift_Dtl.size();i++){
				record = (String[])Shift_Dtl.get(i);
				out.println( "assignShift(\"" + record[0] + "\",\"" + record[1] + "\",\""+record[2]+ "\",\"" + record[3] + "\",\""+record[4]+"\",\""+role_type+ "\",\"" + staff_id + "\",\"" + position_code+ "\");");		
			}
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		if(pstmt!= null)
			pstmt.close();
		if(resultSet!= null)
			resultSet.close();
		ConnectionManager.returnConnection(conn,request);
	}

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
