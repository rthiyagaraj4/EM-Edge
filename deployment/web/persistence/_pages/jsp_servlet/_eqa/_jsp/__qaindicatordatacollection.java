package jsp_servlet._eqa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import webbeans.eCommon.*;

public final class __qaindicatordatacollection extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eqa/jsp/QAIndicatorDataCollection.jsp", 1742817543829L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\n\n</html>\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

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

String encounter_id=request.getParameter("encounter_id")==null?" ":request.getParameter("encounter_id");
//String clind_analysis_status=request.getParameter("clind_analysis_status").equals("")?"emty":request.getParameter("clind_analysis_status");
String qind_clind_id=request.getParameter("qind_clind_id")==null?" ":request.getParameter("qind_clind_id");
//String incl_diag_code=request.getParameter("incl_diag_code").equals("")?" ":request.getParameter("incl_diag_code");
//String incl_proc_code=request.getParameter("incl_proc_code").equals("")?" ":request.getParameter("incl_proc_code");
String incl_compl_code=request.getParameter("incl_compl_code").equals("")?" ":request.getParameter("incl_compl_code");
String incl_comments=request.getParameter("incl_comments").equals("")?" ":request.getParameter("incl_comments");
String patient_class=request.getParameter("patient_class")==null?" ":request.getParameter("patient_class");
String incl_yn=request.getParameter("incl_yn")==null?" ":request.getParameter("incl_yn");
String test=request.getParameter("test")==null?" ":request.getParameter("test");

String hashKey=encounter_id+"|"+qind_clind_id+"|"+patient_class;
String hashValue=encounter_id+"|"+qind_clind_id+"|"+incl_compl_code+"|"+incl_comments +"|"+incl_yn+"|"+patient_class;

System.out.println("hashKey "+hashKey);
System.out.println("hashValue "+hashValue);

HashMap collectData1;
ArrayList arr1;
if(session.getAttribute("collectData")!=null)
   {
        collectData1=(HashMap)session.getAttribute("collectData");
        arr1 =(ArrayList)session.getAttribute("arr");
   }
   else
	{
	  collectData1=new HashMap();
	 arr1=new ArrayList();
	 }


if(collectData1 != null)
	{   
		if(arr1!=null)
		{
		arr1.add(hashKey);
		}
		if(arr1.contains(hashKey))
		{
		collectData1.remove(hashKey);
		}
		collectData1.put(hashKey,hashValue);
  }
System.out.println("arrjsp"+arr1);
System.out.println("collectData"+collectData1);
/*session.putValue("arr",arr1);
session.putValue("collectData",collectData1); */


if(!test.equals("yes"))
{
session.setAttribute("arr",arr1);
session.setAttribute("collectData",collectData1); 
}
else
{
System.out.println("arrjsp"+session.getAttribute("arr"));
System.out.println("collectData"+session.getAttribute("collectData"));
}

//collectData.clear();
//arr.clear();

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
