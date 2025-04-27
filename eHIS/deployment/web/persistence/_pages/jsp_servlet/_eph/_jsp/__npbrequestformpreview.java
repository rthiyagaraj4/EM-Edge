package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __npbrequestformpreview extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/NPBRequestFormPreview.jsp", 1709120979134L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="   \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n \n<html>\n\t<head>\n\t\t<link rel=\"stylesheet\" type=\"text/css\" href=\"../../eCommon/html/CommonCalendar.css\"></link> <!-- To display the calendar --> \n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t\t<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script Language=\"vbscript\">\n\t\t\tDim WSHShell\n\t\t\tDim myHeader\n\t\t\tDim myFooter\n\t\t\tSet WSHShell = CreateObject(\"WScript.Shell\")\n\t\t\t\'myHeader = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\")\n\t\t\t\'myFooter = WSHShell.RegRead(\"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\")\n\n\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", \"&b&d\"\n\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", \"&bPage &p of &P\"\n\n\t\t\tSub ResetHeader()\n\t\t\t\tDim WSHShell\n\t\t\t\tSet WSHShell = CreateObject(\"WScript.Shell\")\n\t\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\header\", myHeader\n\t\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\footer\", myFooter\n\t\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_left\", \"19.05\"\n\t\t\t\tWSHShell.RegWrite \"HKCU\\Software\\Microsoft\\Internet Explorer\\PageSetup\\margin_right\", \"19.05\"\n\t\t\tEnd Sub\n\n\t\t</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t<style type=\'text/css\'>\n\t\t\tADDRESS{font-style: NORMAL;} \n\t\t\tINPUT.TEXT_DISPLAY\n\t\t\t{\n\t\t\t\tbackground:white;  \n\t\t\t\tcolor: RED ;\n\t\t\t\tborder-style: none;\n\t\t\t}\n\t\t</style>\n\t\t<title>";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="</title>\n    </head>\n\t<body onMouseDown=\"CodeArrest()\" onblur=\"\" onKeyDown=\"lockKey()\" >\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t\t<form name=\"editor_preview\" id=\"editor_preview\" method=\"post\" target=\"messageFrame\">\n\t\t\t<table cellpadding=3 cellspacing=0 border=0  style=\'table-layout: fixed;\' >\t\n\t\t\t\t<tr>\t\t\n\t\t\t\t\t<td style=\'text-align:left;\' id=\"NPBReqDetail\"><font size=\'2\'>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</font></td> \t\t\n\t\t\t\t</tr>\n\t\t\t</table>\n\t\t</form>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block8Bytes, _wl_block8);

		request.setCharacterEncoding("UTF-8");
		//String NPBReqFormText		= request.getParameter("NPBReqFormText");
		String NPBReqFormText="";
		String bean_id		= request.getParameter("bean_id");
		String bean_name		= request.getParameter("bean_name");
		String mode		= request.getParameter("mode")==null?"1":request.getParameter("mode");
		String calledFrom		= request.getParameter("calledFrom")==null?"":request.getParameter("calledFrom");
		String NPBReqNo		= request.getParameter("request_no")==null?"":request.getParameter("request_no");
		String NPBReqFormId		= request.getParameter("NPBReqFormId")==null?"":request.getParameter("NPBReqFormId");
		try{
			if ( bean_id == null || bean_id.equals( "" ) )
				return ;
			if(mode.equals("1") || calledFrom.equals("REQUEST")){
				NPBRequestBean bean = (NPBRequestBean)getBeanObject(bean_id,bean_name ,request) ;
				if(mode.equals("1"))
					NPBReqFormText = bean.getNPBReqFormText();
				else{
					NPBReqFormText = bean.getNPBRequestFormText(NPBReqNo);
				}
			}
			else if (mode.equals("2")){
				NPBRequestApproveRejectBean bean = (NPBRequestApproveRejectBean)getBeanObject(bean_id,bean_name ,request) ;
				HashMap NPBRequestDtlList=bean.getNPBRequestDtlList();
				HashMap NPBRequestDtl = (HashMap)NPBRequestDtlList.get(NPBReqNo);
				NPBReqFormText =(String) NPBRequestDtl.get("REQUEST_FORM_CONTENT");
			}
			if(NPBReqFormText==null || NPBReqFormText.equals("<ADDRESS>&nbsp;</ADDRESS>"))	
				NPBReqFormText ="";
			NPBReqFormText	= "<img src='../../eCommon/jsp/DisplayImages.jsp?param=clientlogo' width='40' height='40' align='center'></img>" +NPBReqFormText ;
		}
		catch(Exception e){
			e.printStackTrace();
		}

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(NPBReqFormText));
            _bw.write(_wl_block10Bytes, _wl_block10);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eOR.EditorPreview.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${or_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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
