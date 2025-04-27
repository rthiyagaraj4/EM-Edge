package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.net.*;
import java.text.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import eOT.*;
import eOT.Common.*;

public final class __diaryscheduledtls extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/DiaryScheduleDtls.jsp", 1709117258000L ,"10.3.6.0","Asia/Calcutta")) return true;
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
        response.setHeader("Content-Type", " text/html;charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType(" text/html;charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
	String locale = (String)session.getAttribute("LOCALE");
	Connection connection	= null;
	PreparedStatement pstmt = null;
	ResultSet resultset		= null;
	String surgeon_code = request.getParameter("surgeon_code");
	String theatre_code = request.getParameter("theatre_code");
	String facility_id =(String) session.getAttribute("facility_id"); 

	String[] days = new String[]{"N","N","N","N","N","N","N"};
	String maxdate = "";
	String curdate = "";
	String date1 = "";
	try{
		connection = ConnectionManager.getConnection(request);

		String timetablesql = "SELECT DECODE(A.day_code, 0, B.day_no, A.day_code) day_code FROM ot_diary_timetable A, sm_day_of_week B WHERE A.operating_facility_id = ?   AND A.resource_id = ? AND A.oper_room_code = ? AND A.day_code = DECODE(A.day_code, '0', A.day_code, B.day_no) ORDER BY 1";     
		
		String dtuptosql = "select to_char(max(booking_date), 'dd/mm/yyyy') from OT_DIARY_SCHEDULE WHERE team_doctor_code = ? and oper_room_code = ? ";
		
		pstmt = connection.prepareStatement(timetablesql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,surgeon_code);
		pstmt.setString(3,theatre_code);
		resultset = pstmt.executeQuery();

		while(resultset.next()){
			//days[resultset.getInt(1)-1]="Y";
			//Modified by rajesh on 04/02/09 fort passing the values to procedure as Blank instead of Y/N
			days[resultset.getInt(1)-1]="Y";
		}

		String str_days="";
		for(int i=0;i<days.length;i++){
			str_days=str_days+((i==0)?days[i]:"::"+days[i]);
	}
		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();

		pstmt = connection.prepareStatement(dtuptosql);
		pstmt.setString(1,surgeon_code);
		pstmt.setString(2,theatre_code);
		resultset = pstmt.executeQuery();
 		while(resultset.next()){
	      maxdate = resultset.getString(1);
		  maxdate=maxdate==null?"NOT_GENERATED":maxdate;
		  maxdate=maxdate.equals("null")?"NOT_GENERATED":maxdate;
		  if(!maxdate.equals("NOT_GENERATED"))
			maxdate = com.ehis.util.DateUtils.convertDate(maxdate,"DMY","en",locale);
		}

		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();

		pstmt = connection.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		resultset = pstmt.executeQuery();
		while(resultset.next()){
		   curdate = com.ehis.util.DateUtils.convertDate(resultset.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		
  		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		//added  by parul for IN009461 on 5/27/2009
		String sql = "select to_char(max(booking_date)+1, 'dd/mm/yyyy') newdate from OT_DIARY_SCHEDULE WHERE	team_doctor_code = ? and oper_room_code = ? ";
			
			pstmt=connection.prepareStatement(sql);
			pstmt.setString(1,surgeon_code);
			pstmt.setString(2,theatre_code);
			resultset = pstmt.executeQuery();
 			while(resultset.next()){
			date1 = resultset.getString(1);
			}
		if(resultset!=null)resultset.close();
		if(pstmt!=null)pstmt.close();
		out.println(str_days+"@@"+maxdate+"##"+curdate+"##"+date1);

	}

	catch(Exception e){
		System.err.println("Err Msg in DiaryScheduleDtls.jsp"+e.getMessage());
	} finally{
		try{
			if(resultset!=null)resultset.close();
			if(pstmt!=null)pstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
	

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
