package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Types;
import java.sql.CallableStatement;
import java.sql.Connection;
import webbeans.eCommon.ConnectionManager;
import ecis.utils.OnlineReports;
import ecis.utils.OnlineReport;
import java.util.*;

public final class __blprtonlinereport extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPrtOnlineReport.jsp", 1709114111771L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eOH/jsp/StringUtil.jsp", 1724302706763L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n\t\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
 
// instead of using CommonBean.checkForNull use StringUtil.jsp  to filter null values
public String checkForNull(String str){
	return (str!=null && str.intern()!="null")?str:"";
}
public String checkForNull(String inputString,String defaultValue){
        return ( inputString == null || inputString.equals("") )    ?   defaultValue    :   inputString;
	}

public String format_decimal(Double gs_val, int no_of_decimal){
		 
		String gs_val_str = gs_val+"";
		String restrict_gs_val = gs_val_str;
		int index = gs_val_str.indexOf(".");
		int len = (gs_val_str.substring(index+1)).length();
		if(index != -1 && len>no_of_decimal){
			restrict_gs_val = gs_val_str.substring(0,index+no_of_decimal+1);
		}

		return restrict_gs_val;
	}


private String[] insertToSyprogParam(HttpServletRequest request,String reportId,String locale,String facility_id){
	Connection con = null;
	CallableStatement cstmt= null ;
	String retArr[] = new String[2];
	String session_id = "";
	String pgm_date = "";
	try{
		con = ConnectionManager.getConnection();
		con.setAutoCommit(false);
		String param1 = request.getParameter("param1");
		String param2 = request.getParameter("param2");
		String param3 = request.getParameter("param3");
		String param4 = request.getParameter("param4");
		String param5 = request.getParameter("param5");
		String param6 = request.getParameter("param6");
		String param7 = request.getParameter("param7");
		String param8 = request.getParameter("param8");
		String param9 = request.getParameter("param9");
		String param10 = request.getParameter("param10");
		String param11 = request.getParameter("param11");
		String param12 = request.getParameter("param12");
		String param13 = request.getParameter("param13");
		String param14 = request.getParameter("param14");
		String param15 = request.getParameter("param15");
		String param16 = request.getParameter("param16");
		String param17 = request.getParameter("param17");
		String param18 = request.getParameter("param18");
		String param19 = request.getParameter("param19");
		String param20 = request.getParameter("param20");
		String param21 = request.getParameter("param21");
		String param22 = request.getParameter("param22");			
		String param23 = request.getParameter("param23");
		String param24 = request.getParameter("param24");
		String param25 = request.getParameter("param25");
		String param26 = request.getParameter("param26");
		String param27 = request.getParameter("param27");
		String param28 = request.getParameter("param28");
		String param29 = request.getParameter("param29");
		String param30 = request.getParameter("param30");
		

		String insertSql = "{ call   BL_INSERT_TMP_SY_PROG_PARAM (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?) }";
		cstmt = con.prepareCall(insertSql);
		cstmt.setString(1, facility_id);
		cstmt.setString(2, reportId);
		cstmt.registerOutParameter(3, Types.INTEGER);
		cstmt.registerOutParameter(4, Types.VARCHAR);
		cstmt.setString(5, param1);
		cstmt.setString(6, param2);
		cstmt.setString(7, param3);
		cstmt.setString(8, param4);
		cstmt.setString(9, param5);
		cstmt.setString(10, param6);
		cstmt.setString(11, param7);
		cstmt.setString(12, param8);
		cstmt.setString(13, param9);
		cstmt.setString(14, param10);
		cstmt.setString(15, param11);
		cstmt.setString(16, param12);
		cstmt.setString(17, param13);
		cstmt.setString(18, param14);
		cstmt.setString(19, param15);
		cstmt.setString(20, param16);
		cstmt.setString(21, param17);
		cstmt.setString(22, param18);
		cstmt.setString(23, param19);
		cstmt.setString(24, param20);
		cstmt.setString(25, param21);
		cstmt.setString(26, param22);
		cstmt.setString(27, param23);
		cstmt.setString(28, param24);
		cstmt.setString(29, param25);
		cstmt.setString(30, param26);
		cstmt.setString(31, param27);
		cstmt.setString(32, param28);
		cstmt.setString(33, param29);
		cstmt.setString(34, param30);
		cstmt.execute();
		
		session_id = cstmt.getString(3);
		pgm_date = cstmt.getString(4);
		
		System.err.println("session_id->"+session_id);
		System.err.println("pgm_date->"+pgm_date);
		cstmt = null;
		con.commit();
	}
	catch(Exception e){
		System.err.println("Err Msg from BillingCommonValidation.jsp "+e);
		con.rollback();
	}
	finally{
			ConnectionManager.returnConnection(con,request);
			retArr[0] = session_id;
			retArr[1] = pgm_date;
			return retArr;
	}
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);

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

            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);



	String locale = (String)session.getAttribute("LOCALE"); 
	String facility_id = (String)session.getAttribute("facility_id"); 
	String func_mode = request.getParameter("func_mode") == null ? "" :request.getParameter("func_mode") ;

	try{

		if(func_mode.equalsIgnoreCase("PrintOnlineReport")){	
			OnlineReport onlinereportParam = null;
			OnlineReports onlinereports = null;
			String strResults = "";
			String param = request.getParameter("param");
			StringTokenizer strToken = new StringTokenizer(param,":::");
			String pgm_date = "";
			String session_id = "";
			while(strToken.hasMoreElements()){
				String reportId = strToken.nextElement().toString();
				String dateSession[] = insertToSyprogParam(request,reportId,locale,facility_id);
				onlinereportParam = new OnlineReport(facility_id,"BL",reportId);
				onlinereportParam.addParameter("p_facility_id",facility_id);
				onlinereportParam.addParameter("p_pgm_date",dateSession[1]);
				onlinereportParam.addParameter("p_pgm_id",reportId);
				onlinereportParam.addParameter("p_Session_id",dateSession[0]);
				onlinereports = new OnlineReports();
				onlinereports.add(onlinereportParam);
				strResults = onlinereports.execute(request,response);
				onlinereportParam = null;
				onlinereports = null;
			}

			
		}
			
	}catch(Exception e){
		System.err.println("Err Msg from BillingCommonValidation.jsp "+e);

	}


            _bw.write(_wl_block1Bytes, _wl_block1);
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
