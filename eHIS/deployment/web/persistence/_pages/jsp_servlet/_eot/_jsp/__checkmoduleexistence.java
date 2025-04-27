package jsp_servlet._eot._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.CallableStatement;
import webbeans.eCommon.ConnectionManager;
import eCommon.XSSRequestWrapper;
import eCommon.Common.CommonBean;
import java.sql.Types;
import java.util.*;
import com.ehis.util.*;

public final class __checkmoduleexistence extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eot/jsp/CheckModuleExistence.jsp", 1709120192000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script>\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t\t<script>\n\t\t\talert(getMessage(\"CA_NOT_INSTALLED\",\"Common\"));\n\t\t\twindow.location.href = \"../../eCommon/jsp/dmenu.jsp\";\n\t\t</script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t<script>\n\t\t\tparent.frames[2].document.location.href = \"";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\";\n\t\t</script>\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 request.setCharacterEncoding("UTF-8");
   //Added Against MMS Vulnerability Issue - Starts
   request= new XSSRequestWrapper(request);
   response.addHeader("X-XSS-Protection", "1; mode=block");
   response.addHeader("X-Content-Type-Options", "nosniff");
   //Added Against MMS Vulnerability Issue - Ends

            _bw.write(_wl_block2Bytes, _wl_block2);
 String locale = (String)session.getAttribute("LOCALE"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
	
	String facility_id  = (String) session.getValue("facility_id");
	String params = request.getQueryString()+"&facility_id="+facility_id;
	String function_id  = request.getParameter("function_id");
    String url = "";
    String source = "";

	String modules_list = "";
	String ca_module_yn="";
	Connection connection = null;
	PreparedStatement pstmt = null;
	CallableStatement cstmt = null;
	try{
		connection = ConnectionManager.getConnection(request);
		//for checking whether the ca, or module is installed or not
		cstmt=connection.prepareCall("{call GET_OPERATIONAL_MODULES(?,?)}");
		cstmt.setString(1,facility_id);
		cstmt.registerOutParameter(2,Types.VARCHAR);
		cstmt.execute();
		modules_list=cstmt.getString(2);
		if(modules_list.indexOf("OR|")>=0)
			ca_module_yn="Y";	// When CA is  Operational
		else
			ca_module_yn="N";	// When CA is not Operational
 
	}catch(Exception e){
		 System.err.println("Err Msg in CheckModuleExistence: "+e.getMessage());
	}finally{
		try{
			if(cstmt!=null)cstmt.close();
			if(connection!=null)
			ConnectionManager.returnConnection(connection,request);
		}catch(Exception e){}
	}
// alert the user if CA doesnot exist or populate the respective function
	if(ca_module_yn.equals("N")){

            _bw.write(_wl_block6Bytes, _wl_block6);

		}else{			
			if(function_id.equals("OT_SLATE_JAVA"))     //Operations Menu
				url = "../../eOT/jsp/OTSlate.jsp?";
			else if(function_id.equals("OT_CHECK_OUT_FROM_WARD"))
				url = "../../eOT/jsp/OTCheckOutFromWard.jsp?";
			else if(function_id.equals("OT_CHECK_IN"))
				url = "../../eOT/jsp/OTCheckIn.jsp?";
			else if(function_id.equals("OT_CANCEL_CHECKED_IN_CASES"))
				url = "../../eOT/jsp/OTCancelCheckedInCases.jsp?";
			else if(function_id.equals("OT_RECORD_ANESTHESIA"))  // Anaesthesia Menu
				url = "../../eOT/jsp/AT_RecordAnesthesia.jsp?";
			else if(function_id.equals("OT_SURGERY_HISTORY"))   // Queries
				url = "../../eOT/jsp/SurgeryHistory.jsp?";
			else if(function_id.equals("OT_INTERACTIVE_OPER_REGISTER"))
				url = "../../eOT/jsp/InteractiveOperationRegister.jsp?";
			else if(function_id.equals("OT_ANAESTHESIA_HISTORY"))
				url = "../../eOT/jsp/AT_AnaesthesiaHistory.jsp?";			
			else if(function_id.equals("OT_PICK_LIST")) // Bookings Menu
				url = "../../eOT/jsp/OTPicklist.jsp?";
			else if(function_id.equals("OT_SLATE_VIEW_SETTINGS"))
				url = "../../eOT/jsp/OTSlateViewSettings.jsp?";
			else if(function_id.equals("OT_SLATE_VIEW_RESULTS"))
				url = "../../eOT/jsp/OTSlateViewResults.jsp?";
			//else if(function_id.equals("OT_NOTIF_LIST_BY_WARD"))
				//url = "../..//eOT/jsp/OtReportsMain.jsp?report_id=OTROTNWR&";				
			//else if(function_id.equals("OT_BOOKING"))
			//	url = "../..//eOT/jsp/OTBooking.jsp?";
			//else if(function_id.equals("OT_BOOKING_VERIFICATION"))
			//	url = "../..//eOT/jsp/OTBookingVerification.jsp?";
			//else if(function_id.equals("OT_TO_BE_RESCHD_CASES"))
			//	url = "../..//eOT/jsp/ToBeRescheduledCases.jsp?";
			//else if(function_id.equals("OT_BOOKING_CANCEL_TRANSFER"))
			//	url = "../..//eOT/jsp/OTBookingCancelTransfer.jsp?";
			//else if(function_id.equals("OT_PICK_LIST"))
			//	url = "../..//eOT/jsp/OTPicklist.jsp?";
			//else if(function_id.equals("OT_BOOKING_QUERY"))
			//	url = "../..//eOT/jsp/BookingQuery.jsp?";
			source = url + params ;


            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(source));
            _bw.write(_wl_block8Bytes, _wl_block8);

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
