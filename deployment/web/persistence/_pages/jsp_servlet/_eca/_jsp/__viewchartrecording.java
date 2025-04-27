package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.net.*;
import java.text.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __viewchartrecording extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ViewChartRecording.jsp", 1709115256827L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<script>\t\t\n\t\tfunction removeObjectsFromSession(){\n\t\t\t//alert(\'removeObjectsFromSession....\');\n\t\t\t\t//parent.ChartRecordingIntermediateFrame.location.href=\"../../eCA/jsp/ChartRecordingRemoveObjects.jsp?\"+\"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n\t\t}\n</script>\n<head>\n<title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n</title>\n<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'></SCRIPT>\n<script src=\"../../eCommon/js/ValidateControl.js\" language=\"javascript\"></script>\n</head>\n\t\t<frameset rows=\'9%,*%,4%\' id =\'chartRecordingFrameSet\' frameborder=1 onUnload=\'removeObjectsFromSession()\' >\n\t\t\t<frame name=\"ChartRecordingCriteriaFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/ViewChartRecordingCriteria.jsp?";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="&Chart_Id=";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\"></frame>\t\t\t\t\t\t\t\t\t\n\t\t\t\t\t\t\t\t\n\t\t\t<frameset rows=\'73%,27%\' id =\'chartRecordingFrameSetInner\'  frameborder=0 ><!-- IN069952 added id to avoid script error-->\n\t\t\t\t<frame name=\"ChartRecordingGraphFrame\" frameborder=\"0\" scrolling=\"auto\"  src=\"../../eCommon/html/blank.html\"></frame>\n\t\t\t\t<frame name=\"ChartRecordingListFrame\" frameborder=\"0\" scrolling=\"auto\"  src=\"../../eCommon/html/blank.html\"></frame>\n\t\t\t</frameset>\t\t\n\t\t\t\t\t\n\t\t\t<frame name=\"ChartRecordingColorFrame\" frameborder=\"0\" scrolling=\"no\" noresize src=\"../../eCA/jsp/ViewChartColorToolBar.jsp\" ></frame>\t\t\n\t\t\t\n\t\t</frameset>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name			Rev.Date		Rev.Name			Description
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
20/03/2019	  IN069952		Prakash C 		20/03/2019		Ramesh G			Chart View search is blank
------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	//String function_from = request.getParameter("function_from") == null ? "" :  request.getParameter("function_from");checkstyle
	String chart_id = request.getParameter("Chart_Id") == null ? "" :  request.getParameter("Chart_Id");
	String dateDefault = request.getParameter("p_start_date_time") == null ? "" :  request.getParameter("p_start_date_time");
	if(!dateDefault.equals(""))
	{	
		StringTokenizer dateToken = null;
		StringTokenizer secondsToken = null;

		dateToken = new StringTokenizer(dateDefault," ");
		String actualDate = dateToken.nextToken();
		String tempDate = dateToken.nextToken();
		secondsToken = new StringTokenizer(tempDate,":");
		String dateHrMin = actualDate + " " +secondsToken.nextToken() + ":" + secondsToken.nextToken();

		dateDefault = dateHrMin;
	}


	String encounter_id = request.getParameter("encounter_id") == null ? "0" : request.getParameter("encounter_id");
	if(encounter_id.equals("")) encounter_id = "0";
	/*String fac_id = (String) session.getAttribute("facility_id");
	String patient_class= request.getParameter("patient_class")==null ? "" : request.getParameter("patient_class");
	String location_code  =  request.getParameter("location_code")==null ? "" : request.getParameter("location_code");
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String qs = request.getQueryString(); commented for checkstyle */
	String title = "";
	title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Chart.label","common_labels") ;
	

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(title));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(request.getQueryString()));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(chart_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
