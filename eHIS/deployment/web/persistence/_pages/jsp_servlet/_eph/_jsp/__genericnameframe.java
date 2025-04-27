package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __genericnameframe extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/GenericNameFrame.jsp", 1721632207061L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n  ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 =" \n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n<html>\n<head>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t<link rel=\'stylesheet\' type =\'text/css\' href=\'../../eCommon/html/IeStyle.css\'>\n\n\t<script language=\"JavaScript\" src=\"../js/PhCommon.js\"></script>\n\t<script language=\"JavaScript\" src=\"../js/GenericNameByATC.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n</head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<iframe name=\"genericname_top\" id=\"genericname_top\" frameborder=\"0\" scrolling=\"no\" noresize  src=\"../../eCommon/html/blank.html\" style=\"height:15vh;width:100vw\"></iframe><iframe name=\"genericname_bottom\" id=\"genericname_bottom\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../eCommon/html/blank.html\" style=\"height:85vh;width:100vw\"></iframe>\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n<iframe name=\"genericname_top\" id=\"genericname_top\" frameborder=\"0\" scrolling=\"no\" noresize  src=\"../../ePH/jsp/GenericNameAddModify.jsp?mode=";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\" style=\"height:15vh;width:100vw\"></iframe><iframe name=\"genericname_bottom\" id=\"genericname_bottom\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/GenericNameByATCAddModify.jsp?mode=";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\" style=\"height:85vh;width:100vw\"></iframe>\n\n";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n<iframe name=\"genericname_top\" id=\"genericname_top\" frameborder=\"0\" scrolling=\"no\" noresize  src=\"../../ePH/jsp/GenericNameByATCQueryCriteria.jsp\" style=\"height:15vh;width:100vw\"></iframe><iframe name=\"genericname_bottom\" id=\"genericname_bottom\" frameborder=\"0\" scrolling=\"auto\" noresize src=\"../../ePH/jsp/GenericNameByATCAddModify.jsp?queryCriteria=Y\" style=\"height:85vh;width:100vw\"></iframe>\n";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="&generic_id=";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="&drugclass=";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="&enabledisable=";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" style=\"height:85vh;width:100vw\"></iframe>\n";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t<iframe name=\"genericname_top\" id=\"genericname_top\" frameborder=\"0\" scrolling=\"no\" noresize  src=\"../../ePH/jsp/GenericNameAddModify.jsp?mode=";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="&atcclassification=";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="&resultByATC=Y\" style=\"height:15vh;width:100vw\"></iframe><iframe name=\"genericname_bottom\" id=\"genericname_bottom\" frameborder=\"0\" scrolling=\"auto\" src=\"../../ePH/jsp/GenericNameByATCAddModify.jsp?mode=";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="&resultByATC=Y\" style=\"height:85vh;width:100vw\"></iframe>\n";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t<iframe name=\"genericname_top\" id=\"genericname_top\" frameborder=\"0\" scrolling=\"no\" noresize  src=\"../../ePH/jsp/PharmacoClassAddModify.jsp?mode=";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="&resultByATC=M\" style=\"height:15vh;width:100vw\"></iframe><iframe name=\"genericname_bottom\" id=\"genericname_bottom\" frameborder=\"0\" scrolling=\"auto\" src=\"../../ePH/jsp/GenericNameByPharmacoAddModify.jsp?mode=";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="&resultByATC=M\" style=\"height:85vh;width:100vw\"></iframe>\n";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n</html>\n\n";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block6Bytes, _wl_block6);

    request.setCharacterEncoding("UTF-8");
	String locale			= (String)session.getAttribute("LOCALE");
	

            _bw.write(_wl_block7Bytes, _wl_block7);

	String param	=	request.getParameter("param");
	if (param==null)
		param="";
	if (param.equals("")){

            _bw.write(_wl_block8Bytes, _wl_block8);

	}
	else if (param.equals("createIfFrameIsNull")){

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_INSERT")));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_INSERT")));
            _bw.write(_wl_block11Bytes, _wl_block11);

	}
	else if(param.equals("queryIfFrameIsNull")){

            _bw.write(_wl_block12Bytes, _wl_block12);

	}
	else if (param.equals("ModifyIfFrameIsNull")){
		String generic_id=request.getParameter("generic_id");
		String drugclass=request.getParameter("drugclass");
		String enabledisable=request.getParameter("enabledisable");

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_MODIFY")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(generic_id ));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(drugclass));
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_MODIFY")));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(generic_id ));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(enabledisable));
            _bw.write(_wl_block16Bytes, _wl_block16);

	}
	else if (param.equals("ATCClassification")){
		String retVal =request.getParameter("atcclassification");

            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_MODIFY")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(retVal));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_MODIFY")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(retVal));
            _bw.write(_wl_block20Bytes, _wl_block20);

	}
	else if (param.equals("PHARMACOClassification")){
		String retVal =request.getParameter("atcclassification");

            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_MODIFY")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(retVal));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(CommonRepository.getCommonKeyValue("MODE_MODIFY")));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(retVal));
            _bw.write(_wl_block23Bytes, _wl_block23);

	}

            _bw.write(_wl_block24Bytes, _wl_block24);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
