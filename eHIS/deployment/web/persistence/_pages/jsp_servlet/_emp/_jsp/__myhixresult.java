package jsp_servlet._emp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eXH.*;
import webbeans.eCommon.ConnectionManager;
import eXH.*;

public final class __myhixresult extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/MyHixResult.jsp", 1742365108139L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

    private static byte[] _getBytes(java.lang.String block){
        try {
            return block.getBytes(_WL_ORIGINAL_ENCODING);
        } catch (java.io.UnsupportedEncodingException u){
            _WL_ENCODED_BYTES_OK = false;
        }
        return null;
    }

    private final static java.lang.String  _wl_block0 ="\t";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n\t";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\t\t\t<script language=\'javascript\' src=\'../../eMP/js/MyHixSearch.js\'></script>\n\t\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/common.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/dchk.js\' language=\'javascript\'> </script>\n\t\t\t<script src=\'../../eCommon/js/CommonLookup.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eCommon/js/DateUtils.js\' language=\'javascript\'></script>\n\t\t\t<script src=\'../../eXH/js/ExternalApplication.js\' language=\'javascript\'></script>\n\t\t\t<Script src=\"../../eCommon/js/jquery-3.6.3.js\" language=\"JavaScript\"></Script>\n\t\t\t<Script src=\'../../eCommon/js/CommonCalendar.js\' language=\"JavaScript\"></Script>\n\t\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t\t\t<script src=\"../../eCommon/js/common.js\" language=\'javascript\'></script>\n\t\t\t\t<script>\n\t\t\t\talert(getMessage(\'NO_RECORD_FOUND_FOR_CRITERIA\',\'Common\'));\n\t\t\t\t</script>\n\t\t";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\t\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );
	
		private String checkForNull(String inputString)
		{
			return (inputString==null)	?	""	:	inputString;
		}
		
		public static String checkForNull(String inputString, String defaultValue)
		{
			return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
		}
	

    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

		System.out.println(" ::: MyHixResult :::");

		boolean isDebugYN = false; 

		isDebugYN = (eXH.XHUtil.singleParamExeQry("SELECT DEBUG_YN FROM XH_PARAM").equals("Y")) ? true : false;

		System.out.println("MyHixResult isDebugYN--> "+isDebugYN);

		//String dataElements=request.getParameter("dataElements"); // Added by Sethu for MyHix changes required.

		String dataElements="";		

		//String data_details=checkForNull(request.getParameter("details")); // Commented by Sethu.
		StringBuffer htmlData = new StringBuffer(); // Variables added by Sethu.
		String data_details="";

		String action=checkForNull(request.getParameter("action"));
		String facilityid=checkForNull(request.getParameter("facilityid"));
		String pat_id=checkForNull(request.getParameter("pat_id"));
		String encounter_id=checkForNull(request.getParameter("encounter_id"));

		String my_hix_pat_id=java.net.URLDecoder.decode(request.getParameter("my_hix_pat_id"), "UTF-8");
		my_hix_pat_id=my_hix_pat_id.replaceAll("&", "&amp;");

		//String my_hix_pat_id=checkForNull(request.getParameter("my_hix_pat_id"));
		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: my_hix_pat_id ::: "+my_hix_pat_id);
		
		//System.out.println(" ::: MyHixResult ::: my_hix_pat_id After replace ::: "+my_hix_pat_id);
		String final_from_date=checkForNull(request.getParameter("final_from_date"));
		String final_to_date=checkForNull(request.getParameter("final_to_date"));
		String logged_user=checkForNull(request.getParameter("logged_user"));
		
		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: Logged User ::: "+logged_user);

		dataElements = "<REQ_ID>"+action+"$!^<FACILITY_ID>"+facilityid+"$!^<PATIENT_ID>"+pat_id+"$!^<ENCOUNTER_ID>"+encounter_id+"$!^<MYHIX_PAT_ID>"+my_hix_pat_id+"$!^<FROM_DATE>"+final_from_date+"$!^<TO_DATE>"+final_to_date+"$!^<MYHIX_DOC_ID> $!^<REQ_TYPE>QRYREQUEST$!^<LOGGED_USER>"+logged_user+"$!^";

		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: dataElements 123 ::: "+dataElements);

		InvokeMyHixRequest myHixRequest = new InvokeMyHixRequest(); 
		htmlData = myHixRequest.processRequest(dataElements); 

		data_details = htmlData.toString();
		
		if (isDebugYN)
			System.out.println(" ::: MyHixResult ::: data_details ::: "+data_details);
	
		if (!(data_details.equals("")))
		{
		
			out.println(data_details);
			out.println("<input type='hidden' name=action id=action value='"+action+"'>");
			out.println("<input type='hidden' name=facilityid id=facilityid value='"+facilityid+"'>");
			out.println("<input type='hidden' name=pat_id id=pat_id value='"+pat_id+"'>");
			out.println("<input type='hidden' name=encounter_id id=encounter_id value='"+encounter_id+"'>");
			out.println("<input type='hidden' size='80' name=my_hix_pat_id id=my_hix_pat_id value='"+my_hix_pat_id+"'>");
			out.println("<input type='hidden' name=final_from_date id=final_from_date value='"+final_from_date+"'>");
			out.println("<input type='hidden' name=final_to_date id=final_to_date value='"+final_to_date+"'>");
			out.println("<input type='hidden' name=logged_User id=logged_User value='"+logged_user+"'>");
			
            _bw.write(_wl_block2Bytes, _wl_block2);

		}else{
            _bw.write(_wl_block3Bytes, _wl_block3);
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
