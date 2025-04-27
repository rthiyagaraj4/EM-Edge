package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;

public final class __medboardtransactionsframes extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MedBoardTransactionsFrames.jsp", 1733977577794L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t<head>\n\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\t\t<title>";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</title>\n\t\t<iframe scrolling=\"no\" name=\'detail_frame\' id=\'detail_frame\' src=\'../../eMR/jsp/MedBoardRequestDetail.jsp?call_function=";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="&request_id=";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="&PatientId=";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="&called_from=";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' noresize frameborder=no scrolling=\"no\" style=\'height:11vh;width:99vw\'></iframe>\n\t\t<iframe name=\'detail_frame\' id=\'detail_frame\'  src=\'../jsp/MedBoardRequestDetailTabs.jsp?call_function=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' noresize  frameborder=no scrolling=no style=\'height:81vh;width:99vw\'></iframe>\n\t\t<iframe name=\'RecordButton_frame\' id=\'RecordButton_frame\'  src=\'../jsp/MedBoardRequestButtons.jsp?call_function=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' noresize frameborder=no scrolling=\'no\' style=\'height:4vh;width:99vw\'></iframe>\n\t\t<iframe name=\'ModalMessageFrame\' id=\'ModalMessageFrame\' src=\'../../eCommon/jsp/error.jsp\' frameborder=no noresize scrolling=\'no\' style=\'height:0vh;width:99vw\'></iframe>\n\t</head>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}
	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
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

/*
 ****************************************************************************************
* @Module		: Medical Records..[MR]
* @Author		: SRIDHAR R 
* @Created on	: 29 MARCH 2005
* @Function		: To define frames for the MEDICAL BOARD Transactions...
 ****************************************************************************************
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	request.setCharacterEncoding("UTF-8");
	String call_function= checkForNull(request.getParameter("call_function"));
	String PatientId	= checkForNull(request.getParameter("PatientId"));
	String request_id	= checkForNull(request.getParameter("request_id"));
	String called_from	= checkForNull(request.getParameter("called_from"));
	String Title = "";

	if(call_function.equals("MEDICAL_BOARD_REQUEST"))
		Title = "Request for Medical Board";
	else if(call_function.equals("MEDICAL_BOARD_STATUS"))
		Title = "Status of Medical Board Request";
	else if(call_function.equals("FORWARD_MEDICAL_BOARD"))
		Title = "Forward Medical Board Request";
	else if(call_function.equals("PREPARE_MEDICAL_BOARD"))
		Title = "Prepare Medical Report by Board";
	else if(call_function.equals("RECEIVE_MEDICAL_BOARD"))
		Title = "Receive Medical Report";
	else if(call_function.equals("DELIVER_MEDICAL_BOARD"))
		Title = "Deliver Medical Board";
	else if(call_function.equals("MEDICAL_BOARD_INT_APPT"))
		Title = "Intimate Appointment for Medical Board Request";
	else if(call_function.equals("MEDICAL_BOARD_APPT"))
		Title = "Appointment for Med Board request";
	else if(call_function.equals("MEDICAL_BOARD_COMPLETED"))
		Title = "Medical Board Completed";
	else if(call_function.equals("REVISE_MEDICAL_BOARD"))
		Title = "Revise Medical Board";


            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(Title));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(call_function));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request_id));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(PatientId));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(called_from));
            _bw.write(_wl_block10Bytes, _wl_block10);
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
