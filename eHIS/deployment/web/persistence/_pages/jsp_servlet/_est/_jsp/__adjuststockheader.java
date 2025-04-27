package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.*;
import eST.Common.*;
import java.util.*;
import java.lang.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __adjuststockheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/AdjustStockHeader.jsp", 1718270670159L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="  \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n<html>\n\t<head>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\t\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\' type=\'text/css\' ></link> \n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StCommon.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eST/js/StHeader.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n\t\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n\t</head>\n<body>\n<form name=\'formAdjustStockHeader\' id=\'formAdjustStockHeader\'>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 =" \n\t";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="\n\t";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="\n\n\t<input type=\"hidden\" name=\"item_class_check\" id=\"item_class_check\" value=\"";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 ="\">\n\t<input type=\"hidden\" name=\"trn_type\" id=\"trn_type\"\t\t value=\"";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="\">\n<!-- \t<input type=\"hidden\" name=\"doc_type_code\" id=\"doc_type_code\"\t value=\"";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 ="\" > \n -->\t<input type=\"hidden\" name=\"doc_no\" id=\"doc_no\"\t\t\t value=\"";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="\" >        \n \t<input type=\"hidden\" name=\"adj_delete_yn\" id=\"adj_delete_yn\"\t\t\t value=\"";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="\" >\n      <!-- Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 04-MAR-2013 -->\n\t<input type=\"hidden\" name=\"default_Expdate_condmn\" id=\"default_Expdate_condmn\"\tvalue=\"";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="\">\t\n</form>\n";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\n</body>\n</html>\n\n";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block4Bytes, _wl_block4);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

	request.setCharacterEncoding("UTF-8");
	String locale			=	(String)session.getAttribute("LOCALE");

	String sStyle			=	(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block8Bytes, _wl_block8);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block9Bytes, _wl_block9);

	AdjustStockBean bean			=		(AdjustStockBean) getBeanObject( "adjustStockBean","eST.AdjustStockBean",request );
	bean.setLanguageId(locale);

	String mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT");
	String trn_type					=		"ADJ";
	String sql_id					=		"SQL_ST_ADJ_STORE_SELECT";
	String item_class_based			=		bean.getAdjustStockItemClassBased(trn_type);

	String doc_type_code			=		bean.checkForNull(request.getParameter( "doc_type_code" ));
	String doc_no					=		bean.checkForNull(request.getParameter( "doc_no" ));
	String doc_date					=		bean.checkForNull(request.getParameter( "doc_date" ));
	String doc_ref					=		bean.checkForNull(request.getParameter( "doc_ref" ));
	String store_code				=		bean.checkForNull(request.getParameter( "store_code" ));
	String item_class_code			=		bean.checkForNull(request.getParameter( "item_class_code" ));

	if(request.getParameter( "doc_type_code" ) != null) {
		mode						=		eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY");	
	} 

	String adj_delete_yn =		bean.checkForNull((String)bean.fetchRecord("select  adj_delete_yn  from  ST_USER_ACCESS_FOR_STORE where store_code=? and user_id=?",new String[]{bean.checkForNull(store_code),(String) session.getValue( "login_user" )}).get("ADJ_DELETE_YN"),"N");
	 
	// Added by Rabbani #Inc no:29954(Bru-HIMS-CRF-088) on 01-MAR-2013
	if(mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY"))){
	 String disposable_yn = bean.checkForNull((String)bean.getDisposable_yn());
	if(disposable_yn.equals("Y")){
	String next_batch_id = bean.checkForNull((String)bean.fetchRecord("SELECT NEXT_BATCH_ID FROM	ST_STORE_DISPOSE_BATCH WHERE STORE_CODE =? and eff_status = 'E' and  AUTO_GEN_BATCH_YN = 'Y' ",store_code).get("NEXT_BATCH_ID"));
	      int dflt_btch_id    =  Integer.parseInt(next_batch_id);
				   dflt_btch_id           =   dflt_btch_id-1;
				   next_batch_id           =   ""+dflt_btch_id;
			       bean.setDflt_batch_id(next_batch_id);  
	 }
	}


            _bw.write(_wl_block2Bytes, _wl_block2);
            {java.lang.String __page ="../../eST/jsp/StHeader.jsp";
                java.lang.String[][] __queryParams = {{ weblogic.utils.StringUtils.valueOf("mode"), weblogic.utils.StringUtils.valueOf(mode
                        )},{ weblogic.utils.StringUtils.valueOf("trn_type"), weblogic.utils.StringUtils.valueOf(trn_type
                        )},{ weblogic.utils.StringUtils.valueOf("storeSQLID"), weblogic.utils.StringUtils.valueOf(sql_id
                        )},{ weblogic.utils.StringUtils.valueOf("doc_type_code"), weblogic.utils.StringUtils.valueOf(doc_type_code
                        )},{ weblogic.utils.StringUtils.valueOf("doc_no"), weblogic.utils.StringUtils.valueOf(doc_no
                        )},{ weblogic.utils.StringUtils.valueOf("doc_date"), weblogic.utils.StringUtils.valueOf(doc_date
                        )},{ weblogic.utils.StringUtils.valueOf("doc_ref"), weblogic.utils.StringUtils.valueOf(doc_ref
                        )},{ weblogic.utils.StringUtils.valueOf("store_code"), weblogic.utils.StringUtils.valueOf(store_code
                        )},{ weblogic.utils.StringUtils.valueOf("item_class_code"), weblogic.utils.StringUtils.valueOf(item_class_code
                        )},{ weblogic.utils.StringUtils.valueOf("bean_id"), weblogic.utils.StringUtils.valueOf("adjustStockBean")},{ weblogic.utils.StringUtils.valueOf("bean_name"), weblogic.utils.StringUtils.valueOf("eST.AdjustStockBean")},};
                java.lang.String __encoding = request.getCharacterEncoding();
                if (__encoding == null) __encoding ="ISO-8859-1";

                if (__queryParams.length == 0 ) pageContext.include(__page);
                 else pageContext.include(weblogic.utils.http.HttpParsing.makeURI(__page, __queryParams, __encoding));
            }_bw.write(_wl_block12Bytes, _wl_block12);
            out.print( String.valueOf(item_class_based));
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(trn_type));
            _bw.write(_wl_block14Bytes, _wl_block14);
            out.print( String.valueOf(doc_type_code));
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(doc_no));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf(adj_delete_yn));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.checkForNull((String)bean.getDisp_Expdate())));
            _bw.write(_wl_block18Bytes, _wl_block18);

//putObjectInBean("adjustStockBean",bean,request);

            _bw.write(_wl_block19Bytes, _wl_block19);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
