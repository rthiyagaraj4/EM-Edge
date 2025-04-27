package jsp_servlet._eca._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCA.CAOpenChartServlet;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __showpatients extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eca/jsp/ShowPatients.jsp", 1709116309669L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<title>";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="</title>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n    <head>\n\t\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n        <script>\n            function switchWindow(winname)\n            {\n                window.returnValue = winname;\n                window.close()\t\t\t\t\n//\t\t\t\tdocument.showPatsForm.submit();\n            }\n        </script>\n\t\t<style>\n\t\t\tTD.SWITCHOPTIONS\n\t\t\t{\n\t\t\t\tcolor:white;\n\t\t\t\tFONT-SIZE: 10pt ;\n\t\t\t\tbackground-color:#637BBD ;\n\t\t\t\tFONT-FAMILY: VERDANA ;\n\t\t\t}\n\t\t</style>\n    </head>\n\t<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\t<table border=1 cellpadding=0 cellspacing=0 width=\'100%\' height=\"100%\" align=center valign=top BORDERCOLOR=BLACK>\n\t\t\t<tr><td valign=TOP>\n\t\t\t\t<table border=0 cellpadding=0 cellspacing=1 width=\'100%\' align=center valign=top >\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<form name=\'showPatsForm\' id=\'showPatsForm\' action=\'../../servlet/eCA.CAOpenChartServlet\' method=\'post\'>\n\t<input type=\'hidden\' name=\'queryStringForChart\' id=\'queryStringForChart\' value=\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\'>\n</form>\n</body>\n</html>\n\n";
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

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String childyn = request.getParameter("child_window")==null?"N":request.getParameter("child_window");

            _bw.write(_wl_block7Bytes, _wl_block7);

		String patientId = request.getParameter("patientID") == null ? "" : request.getParameter("patientID");
		String episodeId = request.getParameter("episodeID") == null ? "" : request.getParameter("episodeID");
		String visitId = request.getParameter("visitID") == null ? "" : request.getParameter("visitID");
		String queryStringForChart = request.getParameter("queryStringForChart") == null ? "" : request.getParameter("queryStringForChart");
		String windowName = patientId+episodeId+visitId;
   
		if(childyn.equals("Y"))
		{
			out.println("<tr><td class='SWITCHOPTIONS' onclick =\"javascript:switchWindow('CD')\">Clinician Desktop</td></tr>");
		}

		try
		{
		
			HashMap sessMap = (HashMap) session.getAttribute("sessionMainMap"+session.getId());
			ArrayList sessList = (ArrayList) session.getAttribute("sessionList"+session.getId());
			
			HashMap patMap = new HashMap();
			String patString = "";
			String patWindowString = "";
			String patPatIDString = "";
			String patEpisodeString = "";
			String patVisitString = "";
			String patWindowName = "";
			String episodeVisitId = "";
			String patOtherDetails = "";
			String className = "SWITCHOPTIONS";
			int i = 0;

//			Set sessSet = (Set) sessMap.keySet();

			//while(sessIter.hasNext())
			for(i=0;i<sessList.size();i++)
			{
				//patString = (String) sessIter.next();
				patString = (String) sessList.get(i);
				patMap = (HashMap) sessMap.get(patString) == null ? new HashMap() : (HashMap) sessMap.get(patString);
				patWindowString = (String) patMap.get("windowObject"+patString);
				patPatIDString = (String) patMap.get("patientId"+patString);
				patEpisodeString = (String) patMap.get("episodeId"+patString);
				patVisitString = (String) patMap.get("visitId"+patString);
				patOtherDetails = (String) patMap.get("patOtherDetails"+patString);
				
				patOtherDetails		= java.net.URLDecoder.decode(patOtherDetails);

				patWindowName = patPatIDString+patEpisodeString+patVisitString;
				episodeVisitId = ", "+patPatIDString + ", "+patEpisodeString;
				if(!patVisitString.equals(""))
					episodeVisitId = episodeVisitId + "/" + patVisitString;

				if(!patString.equals(windowName))
				{
					out.println("<tr><td class='"+className+"' onclick =\"javascript:switchWindow('"+patWindowName+"')\">"+patOtherDetails+episodeVisitId+"</td></tr>");
				}
			}
		}
		catch(Exception e)
		{
			//out.println("Exception in ShowPatients.jsp --"+e.toString());//COMMON-ICN-0181
			e.printStackTrace();
		}

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(queryStringForChart));
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }

    private boolean _jsp__tag0(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag0 = null ;
        int __result__tag0 = 0 ;

        if (__tag0 == null ){
            __tag0 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag0);
        }
        __tag0.setPageContext(pageContext);
        __tag0.setParent(null);
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eCA.SwitchOptions.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${ca_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag0;
        __result__tag0 = __tag0.doStartTag();

        if (__result__tag0!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag0== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag0.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag0);
            return true;
        }
        _activeTag=__tag0.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag0);
        __tag0.release();
        return false;
    }
}
