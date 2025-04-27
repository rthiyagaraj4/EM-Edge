package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __parentstoreforstoreaddmodifyheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/ParentStoreForStoreAddModifyHeader.jsp", 1722860497922L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<html> \n<head>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t <link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'type=\'text/css\'></link>\n\t <script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t <script language=\"JavaScript\" SRC=\"../../eCommon/js/common.js\"></script>\n\t <script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t <script language=\"JavaScript\" src=\"../../eST/js/ParentStoreForStore.js\"></script>\n\t <script language=\"javascript\" src=\"../../eOR/js/OrCommonLookup.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t\t\n</head>\n\n\t\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<body onload=\'FocusFirstElement();\'>\n<form name=\"formParentAddModify\" id=\"formParentAddModify\" onreset=\"FocusFirstElement()\">\n\t <!-- <table border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\'100%\'  height=\'100%\' align=\"center\">\n\t<tr>\n\t<td width=\'100%\'  class=\"WHITE\">  -->\n\t<table border=\"0\" cellpadding=\"1\" cellspacing=\"0\" width=\'100%\'  align=\'center\'>\n\t\t<tr>\n\t\t\t<td width=\'20%\'>&nbsp;</td>\n\t\t\t<td width=\'45%\'>&nbsp;</td>\n\t\t\t<td width=\'15%\'>&nbsp;</td>\n\t\t</tr>\n\n\t\t<tr>\n\t\t\t<td  class=\"label\">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =" </td>\n\t\t\t";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\n\n\t\t\t<td><input type=\"text\"  name=\"store_desc\" id=\"store_desc\" size=\'40\' maxLength=\'40\'  value=\"";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\"   ";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 =" >\n\t\t\t<input class=\'Button\' type=\"button\" name=\"searchStore\" id=\"searchStore\" onClick=\"return searchStoreDetails(store_code,store_desc);\" value=\"?\"  ";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =" >\n\t\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value = \"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\" >\n\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\n\t\t\t<td><input type=\"text\"  name=\"store_desc\" id=\"store_desc\" size=\'40\' maxLength=\'40\'  value=\"\"   >\n\t\t\t<input class=\'Button\' type=\"button\" name=\"searchStore\" id=\"searchStore\" onClick=\"return searchStoreDetails(store_code,store_desc);\" value=\"?\"  >\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t<input type=\"hidden\" name=\"store_code\" id=\"store_code\" value = \"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\n\t\t</td>\n\t\t<td >&nbsp;</td>\n\t\t</tr>\n\t\t\n<!--\t\t<tr>\n\t\t\t<td  class=\"label\"> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; ";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</td>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\n\t\t\t<td><input type=\"text\"   name=\"parent_store_desc\" id=\"parent_store_desc\" size=\'40\'\' maxLength=\'40\'  value=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\"  ";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 =" >\n\t\t\t<input class=\'Button\' type=\"button\" name=\'searchParentStore\' id=\'searchParentStore\' onClick=\"return searchParentStoreDetails(parent_store_code,parent_store_desc);\" value=\"?\" ";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="  onBlur=\"return searchDetails();\">\n\t\t\t\t\t<input type=\"hidden\" name=\"parent_store_code\" id=\"parent_store_code\" value = \"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\" >\n\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t<td><input type=\"text\"   name=\"parent_store_desc\" id=\"parent_store_desc\" size=\'40\' maxLength=\'40\'  value=\"\" >\n\t\t\t<input class=\'Button\' type=\"button\" name=\'searchParentStore\' id=\'searchParentStore\' onClick=\"return searchParentStoreDetails(parent_store_code,parent_store_desc);\" value=\"?\"   >\n\t\t\t<img src=\"../../eCommon/images/mandatory.gif\" align=\"center\"></img>\n\t\t\t<input type=\"hidden\" name=\"parent_store_code\" id=\"parent_store_code\" value = \"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\n\t\t\t</td>\n\t\t\t<td >&nbsp;</td>\n\t\t</tr>\n\t-->\t\n\t\t<tr>\n\t\t\t \n\t\t\t<td colspan=\"3\" align=\"center\">&nbsp;</tr>\n\t\t\t<td align=\"right\" colspan=\"2\">\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<input type=\"button\" name=\'search\' id=\'search\' value=\"Search\" class=\'Button\' onBlur=\"return searchDetails();\" >\n\t\t\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t\t\t<input type=\"button\" name=\'search\' id=\'search\' value=\"Search\" class=\'Button\' onClick=\"checkStores();return searchDetails();\"  ";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 =">\n\t\t\t</td>\n\t\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t</tr>\n</table> \n\n\t<input type=\"hidden\"   name=\"SQL_ST_PARENT_STORE_STORE_LOOKUP\" id=\"SQL_ST_PARENT_STORE_STORE_LOOKUP\" \tvalue=\"";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 ="\">\n\t<input type=\"hidden\"   name=\"SQL_ST__PARENT_STORE_PARENT_STORE_LOOKUP\" id=\"SQL_ST__PARENT_STORE_PARENT_STORE_LOOKUP\" \tvalue=\"";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\">\n\t<input type=\"hidden\"   name=\"p_language_id\" id=\"p_language_id\" \t\t value=\"";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="\">\n\t<input type=\"hidden\"   name=\"store_desc1\" id=\"store_desc1\" \t\t     value=\"";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\">\n\t<input type=\"hidden\"   name=\"parent_store_desc1\" id=\"parent_store_desc1\"     value=\"";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 ="\">\n\t<input type=\"hidden\"   name=\"mode\" id=\"mode\" \t\t             value=\"";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 ="\">\n\t<input type=\"hidden\"   name=\"bean_id\" id=\"bean_id\" \t\t         value=\"";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 ="\">\n\t<input type=\"hidden\"   name=\"bean_name\" id=\"bean_name\" \t\t     value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\"   name=\"store_result\" id=\"store_result\" \t\t     value=\"\">\n\t</form>\n";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\n\t<script>searchDetails();</script> \n";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\n</html>\n\n";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
 
	request.setCharacterEncoding("UTF-8");
	String locale						=	(String)session.getAttribute("LOCALE");
	String sStyle						=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	
	String	mode							=	 (request.getParameter( "mode" ) !=null ? (request.getParameter("mode").trim()):"" );
	String	store_code						=	 (request.getParameter( "store_code" ) !=null ? (request.getParameter("store_code").trim()):"" );
	String	parent_store_code				=	 (request.getParameter( "parent_store_code" ) !=null ? (request.getParameter("parent_store_code").trim()):"" );
	String	parent_store_desc				=	 (request.getParameter( "parent_store_desc" ) !=null ? (request.getParameter("parent_store_desc").trim()):"" );
	String	store_desc						=	 (request.getParameter( "store_desc" ) !=null ? (request.getParameter("store_desc").trim()):"" );
	//String	item_class_code				=	 (request.getParameter( "item_class_code" ) !=null ? (request.getParameter("item_class_code").trim()):"" );
	//String	eff_status					=	 (request.getParameter( "eff_status" ) !=null ? (request.getParameter("eff_status").trim()):"D" );
	String	bean_id							=	  "ParentStoreForStoreBean" ;
	String	bean_name						=	  "eST.ParentStoreForStoreBean";
	String  codeDisabled					=	  "";
	ParentStoreForStoreBean bean			=     (ParentStoreForStoreBean)getBeanObject(bean_id,bean_name ,request);
	bean.setLanguageId(locale);
	bean.setMode(mode);

	

	if ( mode == null || mode.equals("") )
		return ;

	if ( !(mode.equals( CommonRepository.getCommonKeyValue( "MODE_MODIFY" ) ) || 
	       mode.equals( CommonRepository.getCommonKeyValue( "MODE_INSERT" ) ) ) )
		return ;
		if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) )
		{
			codeDisabled = "disabled";
						
		}
		else
		{
			codeDisabled="";
		}
	

            _bw.write(_wl_block8Bytes, _wl_block8);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block9Bytes, _wl_block9);
if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
		 else {
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(store_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block16Bytes, _wl_block16);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block17Bytes, _wl_block17);
if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(parent_store_desc));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(parent_store_code));
            _bw.write(_wl_block22Bytes, _wl_block22);
}
		 else {
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(parent_store_code));
            _bw.write(_wl_block14Bytes, _wl_block14);
}
            _bw.write(_wl_block24Bytes, _wl_block24);
if( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") )) {
            _bw.write(_wl_block25Bytes, _wl_block25);
}
		 else {
            _bw.write(_wl_block26Bytes, _wl_block26);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block27Bytes, _wl_block27);
}
            _bw.write(_wl_block28Bytes, _wl_block28);
            out.print( String.valueOf( eST.Common.StRepository.getStKeyValue("SQL_ST_PARENT_STORE_STORE_LOOKUP")));
            _bw.write(_wl_block29Bytes, _wl_block29);
            out.print( String.valueOf( eST.Common.StRepository.getStKeyValue("SQL_ST__PARENT_STORE_PARENT_STORE_LOOKUP")));
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(locale));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(store_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
            out.print( String.valueOf(parent_store_desc));
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block34Bytes, _wl_block34);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block36Bytes, _wl_block36);

	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ){

            _bw.write(_wl_block37Bytes, _wl_block37);
}
            _bw.write(_wl_block38Bytes, _wl_block38);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
        __tag0.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag1(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag1 = null ;
        int __result__tag1 = 0 ;

        if (__tag1 == null ){
            __tag1 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag1);
        }
        __tag1.setPageContext(pageContext);
        __tag1.setParent(null);
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ParentStore.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag1;
        __result__tag1 = __tag1.doStartTag();

        if (__result__tag1!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag1== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag1.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag1);
            return true;
        }
        _activeTag=__tag1.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag1);
        __tag1.release();
        return false;
    }
}
