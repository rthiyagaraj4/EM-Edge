package jsp_servlet._efm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import webbeans.eCommon.ConnectionManager;

public final class __fmfilevolumecomponent extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/efm/jsp/FMFileVolumeComponent.jsp", 1709116850110L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\t\t<select name=\"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\" id=\"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\" onChange=\"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\">\n\t\t<option value = \"\">---<fmt:message key=\"Common.defaultSelect.label\" bundle=\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\"/>---</option>\n\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\t<option value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'>";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="</option>\n\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\t</select>\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}



    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

request.setCharacterEncoding("UTF-8");
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facilityID 			=	"";
String patient_id 			=	"";
String file_no	 			=	"";
String file_type 			=	"";
String volume_name 			=	"";
String onChangeFunction		=	"";

StringBuffer volumeBuffer	=	new StringBuffer();

try
{
	connection			=	ConnectionManager.getConnection(request);
	
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	patient_id 			=	checkForNull(request.getParameter("patient_id"));
	file_no 			=	checkForNull(request.getParameter("file_no"));
	file_type 			=	checkForNull(request.getParameter("file_type"));
	volume_name			=	checkForNull(request.getParameter("volume_name"));
	onChangeFunction	=	checkForNull(request.getParameter("onChangeFunction"));

	if ((volumeBuffer != null) && (volumeBuffer.length() > 0))
		volumeBuffer.delete(0, volumeBuffer.length());
	volumeBuffer.append("SELECT DISTINCT volume_no FROM fm_curr_locn WHERE facility_id = '");
	volumeBuffer.append(facilityID);
	volumeBuffer.append("' and patient_id = '");
	volumeBuffer.append(patient_id);
	volumeBuffer.append("' ");

	if (!file_no.equals(""))
	{
		volumeBuffer.append(" AND file_no = '");
		volumeBuffer.append(file_no);
		volumeBuffer.append("' ");
	}
	if (!file_type.equals(""))
	{
		volumeBuffer.append(" AND file_type_code = '");
		volumeBuffer.append(file_type);
		volumeBuffer.append("' ");
	}
	
	if (volume_name.equals(""))
		volume_name	=	"file_volume";
	
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(volume_name));
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(volume_name));
            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(onChangeFunction));
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.write(( java.lang.String ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",java.lang.String.class,pageContext, null ));
            _bw.write(_wl_block6Bytes, _wl_block6);

	preStatement	=	connection.prepareStatement(volumeBuffer.toString());
	resultSet		=	preStatement.executeQuery();
	if (resultSet != null)
	{
		while (resultSet.next())
		{
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(resultSet.getInt("volume_no")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(resultSet.getInt("volume_no")));
            _bw.write(_wl_block9Bytes, _wl_block9);

		}
	}

            _bw.write(_wl_block10Bytes, _wl_block10);

if(preStatement!=null) preStatement.close();
if(resultSet!=null)	resultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{	
	ConnectionManager.returnConnection(connection,request);
}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
