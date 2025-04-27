package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import eOR.Common.*;
import eOR.*;
import java.net.URLDecoder;
import java.io.UnsupportedEncodingException;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __duplicateorderremarksdialog extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/DuplicateOrderRemarksDialog.jsp", 1709119684000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<html>\n\t<head>\n\t\t";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\t\t<title> Duplicate Remarks - ";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="</title>\n\n\t\t";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' />\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/common.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eCommon/js/ValidateControl.js\'></script>\n\t\t<script language=\'javascript\' src=\'../../eOR/js/OrderEntry.js\' ></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\t\t\n\t</head>\n\t<BODY  class=\'CONTENT\' OnMouseDown=\'CodeArrest()\'  onKeyDown = \'lockKey()\'>\n\t\n\t\t<form name = \'DuplicateReamarksForm\'>\n\t\t\t<br>\n\t\t\t<table border=0 cellpadding=3 cellspacing=0 align=center>\n\t\t\t\t<tr>\n\t\t\t\t\t<td>\n\t\t\t\t\t\t<!-- <textarea name=\"indi_dup_override_remarks\"  value=\'<//%=l_dup_code_reason%>\' rows=\"5\" cols=\"60\" maxlength=\'2000\' onKeyPress=\'checkMaxLimit(this,2000);\'    onBlur=\"makeValidString(this)\" ></textarea></td> -->\n\t\t\t\t\t\t<textarea name=\"indi_dup_override_remarks\"  value = \'\' rows=\"5\" cols=\"60\" maxlength=\'2000\' onKeyPress=\'checkMaxLimit(this,2000);\'   ></textarea></td>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\n\t\t\t\t<tr>\n\t\t\t\t\t<td align=\'right\'>\n\t\t\t\t\t\t<input type=\'Button\' class=\'Button\' name=\'Ok\' id=\'Ok\' value=\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\' onclick=\"doRemarksClose(\'";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\',\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\')\"></center>\n\t\t\t\t\t</td>\n\t\t\t\t</tr>\t\n\t\t\t</table>\n\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\t\t\n\t\t</form>\n\t\t<script>\n\t\t\t//alert(\'line 59: ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\');\n\t\t\tdocument.DuplicateReamarksForm.indi_dup_override_remarks.value = unescape(\'";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\'); <!-- IN047605 -->\n\t\t\t//alert(\'line 61: \' + document.DuplicateReamarksForm.indi_dup_override_remarks.value);\n\t\t</script>\n\t</body>\n</html>\n\n";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );
	
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
        response.setHeader("Content-Type", "text/html;charset=ISO-8859-1");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html;charset=ISO-8859-1");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

/*
-----------------------------------------------------------------------------------------
Date		Edit History	Name		Rev.Date		Rev.Name			Description
-----------------------------------------------------------------------------------------
?             100            ?           	?				?				created
17/02/2014	  IN024984		Karthi		21/02/2014		 Ramesh			Conditional reordering by clinician
24/03/2014	  IN047605		Karthi		24/03/2014		 Ramesh 		Alignment format of Duplicate Override reason text is differed		
25/03/2014	  IN048076		Karthi		25/03/2014		 Ramesh 		-Description of Duplicate check remarks window legend is differed.
------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
	
			String l_catalog_desc =  (request.getParameter("p_catalog_desc")==null)?"":request.getParameter("p_catalog_desc");
			l_catalog_desc = java.net.URLDecoder.decode(l_catalog_desc,"UTF-8"); //IN048076
		
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf( l_catalog_desc));
            _bw.write(_wl_block4Bytes, _wl_block4);

			request.setCharacterEncoding("UTF-8");	
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
			String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE1")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

			String l_catalog_code =  (request.getParameter("p_catalog_code")==null)?"":request.getParameter("p_catalog_code");
			
			String l_bean_id 					= request.getParameter("bean_id"); 
			String l_bean_name 				= request.getParameter("bean_name");
			String l_dup_code_reason	=	"";
			HashMap l_hashMap			= null;
			
			try
			{
				OrderEntryBean beanObj 	= (OrderEntryBean)getBeanObject(l_bean_id, l_bean_name, request);
				l_hashMap				=  beanObj.getDupeReasonHashMap();
				
				if(l_hashMap != null) {
					if(l_hashMap.containsKey(l_catalog_code)){
						l_dup_code_reason = (String)l_hashMap.get(l_catalog_code);
					}	
				}	
		
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ok.label","common_labels")));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(l_catalog_code));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(l_bean_id));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(l_bean_name));
            _bw.write(_wl_block10Bytes, _wl_block10);
		
			}
			catch(Exception e)
			{
			//	out.println("Exception in try of DuplicateOrderRemarksDialog.jsp:"+e);//COMMON-ICN-0181
                                 e.printStackTrace();//COMMON-ICN-0181
			}
		
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(l_dup_code_reason));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(l_dup_code_reason));
            _bw.write(_wl_block13Bytes, _wl_block13);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
