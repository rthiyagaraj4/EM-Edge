package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import webbeans.eCommon.ConnectionManager;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.Map;

public final class __timeoverlapvalidation extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/TimeOverLapValidation.jsp", 1709117294000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOT/jsp/StringUtil.jsp", 1724302624000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.trim()!="" && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return (checkForNull(inputString).intern()!="") ? inputString:defaultValue;
	}

public HashMap CToHashMap( Hashtable table ) {
		if( table == null ) return null;
		return new HashMap(table);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
 
		String facility_id = request.getParameter("facility_id");
		String room_code = request.getParameter("room_code");
		String splty_code = request.getParameter("splty_code");
		String day_code = request.getParameter("day_code");
		String st_time = request.getParameter("start_time");
		String end_time = request.getParameter("end_time");
		String mode = request.getParameter("mode");
		String selected_weeks = request.getParameter("selected_weeks");
		//This flag checks whether days are All Days or specific days
	    boolean day_flag = ("0".equals(day_code))?true:false;
		String schedule_type =  request.getParameter("schdule_type");
		boolean schedule_flag = ("S".equals(schedule_type))?true:false;
		if(schedule_flag){
//			String[] weeks = new String[selected_weeks.length()];
		}
		String index = "";
		String wk1="";
		String wk2="";
		String wk3="";
		String wk4="";
		String wk5="";
		
		/*if("U".equals(mode)){
			out.println("Y");
			return;
		}*/
		String SQL_TIMESLOTS ="SELECT TO_CHAR(START_TIME_DATE,'HH24:MI'),TO_CHAR(END_TIME_DATE,'HH24:MI'),SCHEDULE_TYPE,FIRST_WEEK_YN,SECOND_WEEK_YN,THIRD_WEEK_YN,FOURTH_WEEK_YN,FIFTH_WEEK_YN FROM OT_SPECIALITY_TIME_TABLE  WHERE OPERATING_FACILITY_ID=?  AND OPER_ROOM_CODE =?  AND SPECIALITY_CODE= ?";
		
		String SQL_TIMESLOTS_1 ="SELECT TO_CHAR(START_TIME_DATE,'HH24:MI'),TO_CHAR(END_TIME_DATE,'HH24:MI'),SCHEDULE_TYPE,FIRST_WEEK_YN,SECOND_WEEK_YN,THIRD_WEEK_YN,FOURTH_WEEK_YN,FIFTH_WEEK_YN FROM OT_SPECIALITY_TIME_TABLE  WHERE OPERATING_FACILITY_ID=?  AND OPER_ROOM_CODE =?  AND SPECIALITY_CODE= ?  AND DAY_CODE=?";
		
		

		String SQL = (day_flag)?SQL_TIMESLOTS:SQL_TIMESLOTS_1;
		
		//1- checking start_time  2-Comparing St_time 3-Comparing EndTime
		//1- checking end_time  2-Comparing st_time 3-Comparing EndTime
		String SQL_OVERLAP ="SELECT 'X' FROM DUAL WHERE TO_DATE(?,'HH24:MI') BETWEEN TO_DATE(?,'HH24:MI') AND TO_DATE(?,'HH24:MI') UNION SELECT 'X' FROM DUAL WHERE TO_DATE(?,'HH24:MI') BETWEEN TO_DATE(?,'HH24:MI') AND TO_DATE(?,'HH24:MI')";
		
		Connection con = null;
		PreparedStatement pstmt = null;
		PreparedStatement pstmt1 = null;
		ResultSet rst = null;
		ResultSet rst1 = null;
		boolean result = false;
		String retVal="Y";
		try{
			con = ConnectionManager.getConnection(request);
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,room_code);
			pstmt.setString(3,splty_code);
			if(!day_flag) pstmt.setString(4,day_code);
			rst = pstmt.executeQuery();
			while(rst.next()){
				wk1 = rst.getString(4);
				wk2 = rst.getString(5);
				wk3 = rst.getString(6);
				wk4 = rst.getString(7);
				wk5 = rst.getString(8);
				pstmt1=con.prepareStatement(SQL_OVERLAP);
				pstmt1.setString(1,st_time);
				pstmt1.setString(2,rst.getString(1));
				pstmt1.setString(3,rst.getString(2));
				pstmt1.setString(4,end_time);
				pstmt1.setString(5,rst.getString(1));
				pstmt1.setString(6,rst.getString(2));
				rst1 = pstmt1.executeQuery();
				if(rst1.next()) {
					result=("X".equals(rst1.getString(1)))?true:false;
				}

				if(result){
					retVal="X";
					break;
				}
			}
			//checking week overlap
			if(schedule_flag){
				int size = selected_weeks.length();
				for(int i=0; i<size;i++){
					index = selected_weeks.substring(i,i+1);
					switch(index.charAt(0)){
						case '1': retVal = ("Y".equals(wk1))?"X":"N";break;
						case '2': retVal = ("Y".equals(wk2))?"X":"N";break;
						case '3': retVal = ("Y".equals(wk3))?"X":"N";break;
						case '4': retVal = ("Y".equals(wk4))?"X":"N";break;
						case '5': retVal = ("Y".equals(wk5))?"X":"N";break;
					}
					if("X".equals(retVal)) break;
				}
			}
			out.println(retVal);
		}catch(Exception e){
			System.err.println("Err Msg in TimeOverLapValidation.jsp"+e.getMessage());
		} finally{
			try{
				if(rst!=null) rst.close();
				if(rst1!=null) rst1.close();
				if(pstmt!=null) pstmt.close();
				if(pstmt1!=null) pstmt1.close();
				if(con!=null) ConnectionManager.returnConnection(con,request);
			}catch(Exception e){}
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
