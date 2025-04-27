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
import java.text.*;
import java.lang.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __stduoheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StDuoHeader.jsp", 1709122204994L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonBean.jsp", 1710760607421L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\n\n\t<table border=0 cellpadding=2 cellspacing=0  width=\'100%\' height=20 align=\"center\">\n\t\t<tr>\n\t\t\t<td class=ITEMSELECT width=\"12%\"  >\n\t\t\t\t<span onClick=\"ModifyDocDetails(\'";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\',\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\',";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =",\'";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\',document.forms[0].store_code_disabled.value)\" style=\"cursor:pointer;color:#FFFF99\">\n\t\t\t\t\t<b>\n\t\t\t\t\t\t<u>\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 =" :\n\t\t\t\t\t\t</u>\n\t\t\t\t\t\t\n\t\t\t\t\t</b>\n\t\t\t\t</span>\n\t\t\t</td>\n\n\t\t\t<td class=ITEMSELECT width=\'20%\' nowrap>\n\t\t\t\t<span id=\"doc_type_desc\">\n\t\t\t\t\t<b>\n\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\t\t\t\t\t\t\n\n\t\t\t\t\t</b>\n\t\t\t\t</span>\n\t\t\t\t&nbsp;\n\t\t\t\t<span id=\"doc_no\">\n\t\t\t\t\t<b>\n\t\t\t\t\t\t";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\n\t\t\t\t\t</b>\n\t\t\t\t</span>\n\t\t\t</td>\n\t\t\t<td class=ITEMSELECT  width=\'12%\' >\n\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 =" :\n\t\t\t\t</b>\n\t\t\t</td>\n\t\t\t<td class=ITEMSELECT  width=\'20%\' id=\"td_doc_date\">\n\t\t\t\t\t\t\t\n\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =" \n\t\t\t\t</b>\n\t\t\t</td>\n\t\t\t<td class=ITEMSELECT  width=\'12%\'  >\n\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 =":\n\t\t\t\t</b>\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t\t<td class=ITEMSELECT  width=\'20%\' id=\"doc_ref_id\" nowrap>\n\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\n\t\t\t\t</b>\n\t\t\t</td>\n\t\t</tr>\n\t\t<tr>\n\t\t\t<td class=ITEMSELECT width=\"12%\" >\n\t\t\t\t<b>\n\t\t\t\t";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 =":\n\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 =" : -->\n\t\t\t\t</b>\n\t\t\t</td>\n\t\t\t<td class=ITEMSELECT width=\'20%\' id=\"td_from_store_code\">\n\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\n\t\t\t\t</b>\n\t\t\t</td>\n\t\t\t<td class=ITEMSELECT width=\'12%\' >\n\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\n\t\t\t\t\t";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 =":\n\t\t\t\t\t";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\n\t\t\t\t\t<!-- ";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="  -->\n\t\t\t\t</b>\n\t\t\t</td>\n\t\t\t";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\n\t\t\t<td class=ITEMSELECT width=\'20%\' id=\"td_to_store_code\"><b>";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="</b></td>\n\t\t\t";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );

    private final static java.lang.String  _wl_block27 ="\n\t\t\t<td class=ITEMSELECT width=\'20%\' id=\"td_to_store_code\"><b></b></td>\n\t\t\t";
    private final static byte[]  _wl_block27Bytes = _getBytes( _wl_block27 );

    private final static java.lang.String  _wl_block28 ="\n\t\t\t<td class=ITEMSELECT width=\'12%\' >\n\t\t\t\t<b>\n\t\t\t\t";
    private final static byte[]  _wl_block28Bytes = _getBytes( _wl_block28 );

    private final static java.lang.String  _wl_block29 =":\n\t\t\t\t</b>\n\t\t\t\t&nbsp;\n\t\t\t</td>\n\t\t\t<td class=ITEMSELECT width=\'20%\' id=\"item_class_legend\">\n\t\t\t\n\t\t\t\t<b>\n\t\t\t\t\t";
    private final static byte[]  _wl_block29Bytes = _getBytes( _wl_block29 );

    private final static java.lang.String  _wl_block30 ="\n\t\t\t\t        \t<!-- ";
    private final static byte[]  _wl_block30Bytes = _getBytes( _wl_block30 );

    private final static java.lang.String  _wl_block31 ="  -->\n\t\t\t\t\t\t\t";
    private final static byte[]  _wl_block31Bytes = _getBytes( _wl_block31 );

    private final static java.lang.String  _wl_block32 ="\n\n\t\t\t\t    ";
    private final static byte[]  _wl_block32Bytes = _getBytes( _wl_block32 );

    private final static java.lang.String  _wl_block33 =" \n\n\t\t\t\t          ";
    private final static byte[]  _wl_block33Bytes = _getBytes( _wl_block33 );

    private final static java.lang.String  _wl_block34 =" \n\n\t\t\t\t    ";
    private final static byte[]  _wl_block34Bytes = _getBytes( _wl_block34 );

    private final static java.lang.String  _wl_block35 =" \n\n\t\t\t\t</b>\n\t\t\t</td>\n\t\t</tr>\n\t</table> \n\t<input type=\"hidden\"\t name=\"doc_no\" id=\"doc_no\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block35Bytes = _getBytes( _wl_block35 );

    private final static java.lang.String  _wl_block36 ="\">\n\t<input type=\"hidden\"\t name=\"doc_ref\" id=\"doc_ref\"\t\t\t\t\t value=\"";
    private final static byte[]  _wl_block36Bytes = _getBytes( _wl_block36 );

    private final static java.lang.String  _wl_block37 ="\"> \n\t<input type=\"hidden\"\t name=\"doc_type_code\" id=\"doc_type_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block37Bytes = _getBytes( _wl_block37 );

    private final static java.lang.String  _wl_block38 ="\">\n\t<input type=\"hidden\"\t name=\"doc_date\" id=\"doc_date\"\t\t\t\t value=\"";
    private final static byte[]  _wl_block38Bytes = _getBytes( _wl_block38 );

    private final static java.lang.String  _wl_block39 ="\">\n\t<input type=\"hidden\"\t name=\"to_store_code\" id=\"to_store_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block39Bytes = _getBytes( _wl_block39 );

    private final static java.lang.String  _wl_block40 ="\">\n\t<input type=\"hidden\"\t name=\"from_store_code\" id=\"from_store_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block40Bytes = _getBytes( _wl_block40 );

    private final static java.lang.String  _wl_block41 ="\">\n\t<input type=\'hidden\'\t name=\"item_class_desc\" id=\"item_class_desc\"\t\t\t value=\"\">\n\t<input type=\'hidden\'\t name=\"item_class_code\" id=\"item_class_code\"\t\t\t value=\"";
    private final static byte[]  _wl_block41Bytes = _getBytes( _wl_block41 );

    private final static java.lang.String  _wl_block42 ="\">\n\t<input type=\'hidden\'\t name=\"finalize_yn\" id=\"finalize_yn\"\t\t\t\t value=\"No\">\n\t<input type=\'hidden\'\t name=\"authorize_yn\" id=\"authorize_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block42Bytes = _getBytes( _wl_block42 );

    private final static java.lang.String  _wl_block43 ="\">\n\t<input type=\'hidden\'\t name=\"autono_yn\" id=\"autono_yn\"\t\t\t\t value=\"No\">\n\t<input type=\"hidden\"\t name=\"to_store_code_disabled\" id=\"to_store_code_disabled\"   value=\"\">\n\t<input type=\"hidden\"\t name=\"from_store_code_disabled\" id=\"from_store_code_disabled\" value=\"\">\n\t<input type=\'hidden\'     name=\"item_class_code_disabled\" id=\"item_class_code_disabled\" value=\"\">\n\t<input type=\"hidden\"\t name=\"store_code_disabled\" id=\"store_code_disabled\"\t\t value=\"false\">\n\t<input type=\'hidden\'\t name=\"from_store_legend\" id=\"from_store_legend\"\t\t value=\"";
    private final static byte[]  _wl_block43Bytes = _getBytes( _wl_block43 );

    private final static java.lang.String  _wl_block44 ="\">\n\t<input type=\'hidden\'\t name=\"to_store_legend\" id=\"to_store_legend\"\t\t\t value=\"";
    private final static byte[]  _wl_block44Bytes = _getBytes( _wl_block44 );

    private final static java.lang.String  _wl_block45 ="\">\n\t<input type=\'hidden\'\t name=\"code_disabled\" id=\"code_disabled\"\t\t\t value=\"";
    private final static byte[]  _wl_block45Bytes = _getBytes( _wl_block45 );

    private final static java.lang.String  _wl_block46 ="\">\n\t<input type=\"hidden\"\tname=\"function_id\" id=\"function_id\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block46Bytes = _getBytes( _wl_block46 );

    private final static java.lang.String  _wl_block47 ="\">\n\t<input type=\"hidden\"\tname=\"sales_req_fm_store\" id=\"sales_req_fm_store\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block47Bytes = _getBytes( _wl_block47 );

    private final static java.lang.String  _wl_block48 ="\">\n\t \n\n\t";
    private final static byte[]  _wl_block48Bytes = _getBytes( _wl_block48 );

    private final static java.lang.String  _wl_block49 ="\n\t\t<script> \t\t\tModifyDocDetails(\"";
    private final static byte[]  _wl_block49Bytes = _getBytes( _wl_block49 );

    private final static java.lang.String  _wl_block50 ="\",\"";
    private final static byte[]  _wl_block50Bytes = _getBytes( _wl_block50 );

    private final static java.lang.String  _wl_block51 ="\",\'document.forms[0].store_code_disabled.value\');\n\t\t</script>\n\t";
    private final static byte[]  _wl_block51Bytes = _getBytes( _wl_block51 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            eCommon.Common.CommonBean CommonBean= null;{
                CommonBean=(eCommon.Common.CommonBean)pageContext.getAttribute("CommonBean");
                if(CommonBean==null){
                    CommonBean=new eCommon.Common.CommonBean();
                    pageContext.setAttribute("CommonBean",CommonBean);

                }
            }
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);

    CommonBean.setProperties( (Properties) session.getValue( "jdbc" ) ) ;
	CommonBean.setLoginById( (String) session.getValue( "login_user" ) ) ;
	CommonBean.setLoginAtWsNo( CommonBean.getProperties().getProperty( "client_ip_address" ) ) ;
	CommonBean.setLoginFacilityId( (String) session.getValue( "facility_id" ) ) ;

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	    request.setCharacterEncoding("UTF-8");
		String locale					=		(String)session.getAttribute("LOCALE");
		
//		String sStyle					=		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block1Bytes, _wl_block1);

	try {
	String authorize					=		"No";
	String mode;	
	String trn_type;
	String codeDisabled					=		"";
//	String doc_dateDisabled				=		"";
//	String item_classDisabled			=		"";
	String fromstorecode				=		"";
	String doctypecode					=		"";
//	String doctypecode					=		"";
		
	String bean_id						=		request.getParameter("bean_id");
	System.err.println("bean_idbean_id" +bean_id);
	if (bean_id == null)	{
		bean_id							=		"stDuoHeaderBean";
	}
	String bean_name					=		request.getParameter("bean_name");
	if (bean_name == null)	{
		bean_name						=		"eST.Common.StDuoHeaderBean";
	}
	System.err.println("bean_name" +bean_name);
	StDuoHeaderBean bean				=		(StDuoHeaderBean) getBeanObject(bean_id, bean_name,request );
	String doc_type_code				=		bean.checkForNull(request.getParameter("doc_type_code")) ;
	String doc_no						=		bean.checkForNull(request.getParameter("doc_no")) ;
	String doc_date						=		bean.checkForNull(request.getParameter("doc_date")) ;
	String doc_ref						=		bean.checkForNull(request.getParameter("doc_ref")) ;
	String from_store_code				=		bean.checkForNull(request.getParameter("from_store_code")) ;
	String to_store_code				=		bean.checkForNull(request.getParameter("to_store_code")) ;

	String sql_from_store				=		bean.checkForNull(request.getParameter("sql_from_store")) ;
	String sql_to_store					=		bean.checkForNull(request.getParameter("sql_to_store")) ;
	String item_class_code				=		bean.checkForNull(request.getParameter("item_class_code")) ;
	String	item_class_desc				=		(request.getParameter( "item_class_desc" )!=null ? (request.getParameter("item_class_desc").trim()):"" );
	String	function_id				=		(request.getParameter( "function_id" )!=null ? (request.getParameter("function_id").trim()):"" );
	String sales_req_yn				=		bean.checkForNull(request.getParameter("sales_req_yn"),"N") ;
	String site_alna 				=		bean.checkForNull(request.getParameter("site_alna"),"false") ;   //Added for NMC-JD-CRF-0174 
	
	bean.setFunctionId(function_id);

	
	if(item_class_desc==null)
		{	item_class_desc				=		"";
		}

	//String docNoDisabled				=		"";


	String Modal_Window_Open			=		bean.checkForNull(request.getParameter("Modal_Window_Open")) ;
	String issue_flag					=		bean.checkForNull(request.getParameter("issue_flag"));
	mode								=		request.getParameter("mode");
	trn_type							=		bean.checkForNull(request.getParameter("trn_type")) ;
	codeDisabled						=		bean.checkForNull(request.getParameter("code_disabled"));

	// Changed for the purpose of displaying different legends for store codes

	String from_store_legend			= 	request.getParameter("from_store_legend");
	String to_store_legend				= 	request.getParameter("to_store_legend");  

			
	if(from_store_legend == null) {
		 from_store_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FromStore.label","common_labels");
		//from_store_legend = "From Store   ";
	}
	if(to_store_legend == null) {
		to_store_legend=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ToStore.label","common_labels");
		//to_store_legend = "To Store   ";
	}
	if (bean_id.equals("stDuoHeaderBean")) {
	
		bean.clear();
		
	}
//System.out.println("beanbean.getStRepositoryValue(sql_from_store)eader===>"+bean.getStRepositoryValue(sql_from_store));
    bean.setSite_alna(site_alna);//Added for NMC-JD-CRF-0174 
	bean.setTrn_type(trn_type);
	bean.setSql_from_store(sql_from_store);
	bean.setLanguageId(locale);
	bean.setSql_to_store(sql_to_store);
	bean.setAcc_entity_id((String)session.getAttribute("ACC_ENTITY_ID"));

	String[] stParameters={bean.getLoginFacilityId(), bean.getLoginById(),bean.getLanguageId()};
	if (bean_id.equals("stDuoHeaderBean")) {
		if(sql_from_store.equals("SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS")){
	fromstorecode				=		(String)bean.fetchRecord("SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND (    st.iss_allowed_yn = 'Y' AND ststr.iss_allowed_yn = 'Y' ) AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1",stParameters).get("STORE_CODE");
		}else{
		fromstorecode				=		(String)bean.fetchRecord(bean.getStRepositoryValue(sql_from_store),stParameters).get("STORE_CODE");
		 
		if(sales_req_yn.equals("Y")){ //Added by Rabbani#AMS-CRF-0068(49822) on 11-AUG-2014 
		fromstorecode = from_store_code;
		}

		}
	bean.setFrom_store_code(fromstorecode);
	if((bean.getFunctionId().equals("ST_AUTH_AT_ISSUE_STORE"))||((bean.getFunctionId().equals("ST_ISSUE_REQ_URG")))){
		
			if(sql_from_store.equals("SQL_ST_REQUEST_FROM_STORE_SELECT_FOR_AUTH_AT_ISS")){
			bean.setFrom_store_code((String)bean.fetchRecord("SELECT   x.parent_store_code, y.short_desc FROM (SELECT DISTINCT stp.parent_store_code FROM st_store_parent_store stp, mm_store mm, st_user_access_for_store st, st_store ststr WHERE st.store_code = mm.store_code AND st.store_code = ststr.store_code AND (    st.iss_allowed_yn = 'Y' AND ststr.iss_allowed_yn = 'Y' ) AND mm.eff_status = 'E' AND stp.parent_store_code = mm.store_code AND mm.facility_id = ? AND st.user_id = ?) x, mm_store_lang_vw y WHERE x.parent_store_code = y.store_code AND language_id = ? ORDER BY 2, 1",stParameters).get("PARENT_STORE_CODE"));

			}else{
			bean.setFrom_store_code((String)bean.fetchRecord(bean.getStRepositoryValue(sql_from_store),stParameters).get("PARENT_STORE_CODE"));


			}
	}
		
	}

	bean.initDoc_type_code_List();
	ServletContext context		=		getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT"))) {
		bean.initialize(trn_type);		
		bean.setItem_class_code(item_class_code);
		bean.setItem_class_desc(item_class_desc);
		
	}
	else {
		bean.initialize(trn_type, doc_type_code, doc_no, doc_date,  doc_ref,from_store_code,to_store_code,item_class_code);
		
	}

	if (mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))) {
		codeDisabled = "disabled";

		
	}
	authorize="Y";
//if (!((doc_type_code == null) ||(doc_type_code.equals(""))))
//	{ 
//	bean.setDoc_type_code(doc_type_code);
//	}

 doctypecode=bean.getDoc_type_code();

		


	try { 
	
		java.util.HashMap resultMap = bean.canAuthorize(bean.getFrom_store_code());

		
		if (trn_type.equals("REQ")) {
			authorize = (String)resultMap.get("REQ_AUTHORIZE_ALLOWED_YN");
		}
		else if (trn_type.equals("ISS")) {
			authorize = (String)resultMap.get("ISS_FINALIZE_ALLOWED_YN");
		}
		else if (trn_type.equals("URG")) {
			authorize = (String)resultMap.get("URG_FINALIZE_ALLOWED_YN");
		}
	
	}
	catch (Exception exception) {
		exception.printStackTrace();
	}
	if (authorize.equals("Y")) {
		authorize = "Yes";
	}
 if(!locale.equals("en")){
  doc_date=com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
  }
  else
	  {
  doc_date=doc_date;
	  }
	   
	  
	  
            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(issue_flag));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(from_store_legend));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(to_store_legend));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(fromstorecode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(doctypecode));
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(doc_date));
            _bw.write(_wl_block10Bytes, _wl_block10);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf(bean.checkForNull(bean.getDoc_type_desc())));
            _bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf((bean.getDoc_no().equals(""))?"":"/"+bean.getDoc_no()));
            _bw.write(_wl_block13Bytes, _wl_block13);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(doc_date));
            _bw.write(_wl_block15Bytes, _wl_block15);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(bean.getDoc_ref()));
            _bw.write(_wl_block17Bytes, _wl_block17);

            if (_jsp__tag3(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(from_store_legend));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getFrom_store_desc()));
            _bw.write(_wl_block20Bytes, _wl_block20);
if(trn_type.equals("PRQ")){
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag4(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
}else{
            _bw.write(_wl_block21Bytes, _wl_block21);

            if (_jsp__tag5(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block22Bytes, _wl_block22);
	
					}
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(to_store_legend));
            _bw.write(_wl_block24Bytes, _wl_block24);

				if(!(to_store_code==null || to_store_code.equals("") || to_store_code=="")){
						

			
            _bw.write(_wl_block25Bytes, _wl_block25);
            out.print( String.valueOf(bean.checkForNull(bean.getTo_store_desc())));
            _bw.write(_wl_block26Bytes, _wl_block26);

				}else{
					

			
            _bw.write(_wl_block27Bytes, _wl_block27);

				}
			
            _bw.write(_wl_block28Bytes, _wl_block28);

            if (_jsp__tag6(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block29Bytes, _wl_block29);
  if (mode.equals("2")) { 
            _bw.write(_wl_block30Bytes, _wl_block30);
            out.print( String.valueOf(bean.checkForNull(bean.getItem_class_desc())));
            _bw.write(_wl_block31Bytes, _wl_block31);
            out.print( String.valueOf(item_class_desc));
            _bw.write(_wl_block32Bytes, _wl_block32);
  } else { 
            _bw.write(_wl_block33Bytes, _wl_block33);
            out.print( String.valueOf(bean.checkForNull(bean.getItem_class_code())));
            _bw.write(_wl_block34Bytes, _wl_block34);
  }  
            _bw.write(_wl_block35Bytes, _wl_block35);
            out.print( String.valueOf(bean.getDoc_no()));
            _bw.write(_wl_block36Bytes, _wl_block36);
            out.print( String.valueOf(bean.getDoc_ref()));
            _bw.write(_wl_block37Bytes, _wl_block37);
            out.print( String.valueOf(bean.getDoc_type_code()));
            _bw.write(_wl_block38Bytes, _wl_block38);
            out.print( String.valueOf(doc_date));
            _bw.write(_wl_block39Bytes, _wl_block39);
            out.print( String.valueOf(bean.checkForNull(bean.getTo_store_code())));
            _bw.write(_wl_block40Bytes, _wl_block40);
            out.print( String.valueOf(bean.getFrom_store_code()));
            _bw.write(_wl_block41Bytes, _wl_block41);
            out.print( String.valueOf(bean.checkForNull(bean.getItem_class_code())));
            _bw.write(_wl_block42Bytes, _wl_block42);
            out.print( String.valueOf(authorize));
            _bw.write(_wl_block43Bytes, _wl_block43);
            out.print( String.valueOf(from_store_legend));
            _bw.write(_wl_block44Bytes, _wl_block44);
            out.print( String.valueOf(to_store_legend));
            _bw.write(_wl_block45Bytes, _wl_block45);
            out.print( String.valueOf(codeDisabled));
            _bw.write(_wl_block46Bytes, _wl_block46);
            out.print( String.valueOf(bean.getFunctionId()));
            _bw.write(_wl_block47Bytes, _wl_block47);
            out.print( String.valueOf(sales_req_yn));
            _bw.write(_wl_block48Bytes, _wl_block48);

		if(Modal_Window_Open.equals("Yes")){
	
            _bw.write(_wl_block49Bytes, _wl_block49);
            out.print( String.valueOf(issue_flag));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(mode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(from_store_legend));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(to_store_legend));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(fromstorecode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(doctypecode));
            _bw.write(_wl_block50Bytes, _wl_block50);
            out.print( String.valueOf(bean.getDoc_date()));
            _bw.write(_wl_block51Bytes, _wl_block51);

		}
}
catch (Exception ex) {
	ex.printStackTrace();
}
	
            _bw.write(_wl_block3Bytes, _wl_block3);
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
        __tag0.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Document.label", java.lang.String .class,"key"));
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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocDate.label", java.lang.String .class,"key"));
        __tag1.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
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

    private boolean _jsp__tag2(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag2 = null ;
        int __result__tag2 = 0 ;

        if (__tag2 == null ){
            __tag2 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag2);
        }
        __tag2.setPageContext(pageContext);
        __tag2.setParent(null);
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.DocRef.label", java.lang.String .class,"key"));
        __tag2.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag2;
        __result__tag2 = __tag2.doStartTag();

        if (__result__tag2!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag2== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag2.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag2);
            return true;
        }
        _activeTag=__tag2.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag2);
        __tag2.release();
        return false;
    }

    private boolean _jsp__tag3(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag3 = null ;
        int __result__tag3 = 0 ;

        if (__tag3 == null ){
            __tag3 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag3);
        }
        __tag3.setPageContext(pageContext);
        __tag3.setParent(null);
        __tag3.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.FromStore.label", java.lang.String .class,"key"));
        __tag3.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag3;
        __result__tag3 = __tag3.doStartTag();

        if (__result__tag3!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag3== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag3.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag3);
            return true;
        }
        _activeTag=__tag3.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag3);
        __tag3.release();
        return false;
    }

    private boolean _jsp__tag4(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag4 = null ;
        int __result__tag4 = 0 ;

        if (__tag4 == null ){
            __tag4 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag4);
        }
        __tag4.setPageContext(pageContext);
        __tag4.setParent(null);
        __tag4.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("eST.ToDepartment.label", java.lang.String .class,"key"));
        __tag4.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${st_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag4;
        __result__tag4 = __tag4.doStartTag();

        if (__result__tag4!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag4== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag4.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag4);
            return true;
        }
        _activeTag=__tag4.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag4);
        __tag4.release();
        return false;
    }

    private boolean _jsp__tag5(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag5 = null ;
        int __result__tag5 = 0 ;

        if (__tag5 == null ){
            __tag5 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag5);
        }
        __tag5.setPageContext(pageContext);
        __tag5.setParent(null);
        __tag5.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ToStore.label", java.lang.String .class,"key"));
        __tag5.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag5;
        __result__tag5 = __tag5.doStartTag();

        if (__result__tag5!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag5== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag5.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag5);
            return true;
        }
        _activeTag=__tag5.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag5);
        __tag5.release();
        return false;
    }

    private boolean _jsp__tag6(javax.servlet.ServletRequest request, javax.servlet.ServletResponse response, javax.servlet.jsp.PageContext pageContext, javax.servlet.jsp.tagext.JspTag activeTag, javax.servlet.jsp.tagext.JspTag parent) throws java.lang.Throwable
    {
        javax.servlet.jsp.tagext.JspTag _activeTag = activeTag;
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter) out;
         org.apache.taglibs.standard.tag.rt.fmt.MessageTag __tag6 = null ;
        int __result__tag6 = 0 ;

        if (__tag6 == null ){
            __tag6 = new  org.apache.taglibs.standard.tag.rt.fmt.MessageTag ();
            weblogic.servlet.jsp.DependencyInjectionHelper.inject(pageContext, __tag6);
        }
        __tag6.setPageContext(pageContext);
        __tag6.setParent(null);
        __tag6.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.ItemClass.label", java.lang.String .class,"key"));
        __tag6.setBundle(( javax.servlet.jsp.jstl.fmt.LocalizationContext ) weblogic.servlet.jsp.ELHelper.evaluate("${common_labels}",javax.servlet.jsp.jstl.fmt.LocalizationContext.class,pageContext,_jspx_fnmap));
        _activeTag=__tag6;
        __result__tag6 = __tag6.doStartTag();

        if (__result__tag6!= javax.servlet.jsp.tagext.Tag.SKIP_BODY){
            if (__result__tag6== javax.servlet.jsp.tagext.BodyTag.EVAL_BODY_BUFFERED) {
            }
        }
        if (__tag6.doEndTag()== javax.servlet.jsp.tagext.Tag.SKIP_PAGE){
            _activeTag = null;
            _releaseTags(pageContext, __tag6);
            return true;
        }
        _activeTag=__tag6.getParent();
        weblogic.servlet.jsp.DependencyInjectionHelper.preDestroy(pageContext, __tag6);
        __tag6.release();
        return false;
    }
}
