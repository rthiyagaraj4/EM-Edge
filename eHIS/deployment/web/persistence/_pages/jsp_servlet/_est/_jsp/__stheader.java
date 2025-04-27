package jsp_servlet._est._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eST.AdjustStockBean;
import eST.Common.StHeaderBean;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import eCommon.Common.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __stheader extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/est/jsp/StHeader.jsp", 1709122205494L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block6 ="\n<table border=0 cellpadding=1 cellspacing=0  width=\'100%\' height=20 align=\"center\">\n\t<td class=ITEMSELECT width=\"9%\" ><span onClick=\"ModifyDocDetails(";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'disabled\'";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="document.forms[0].store_code_disabled.value";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 =")\" style=\"cursor:pointer;color:#FFFF99\"><b><u>";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="</u></b></span></td>\n\t<td class=ITEMSELECT width=\'30%\' nowrap>:&nbsp;<b><span id=\"doc_type_desc\">";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );

    private final static java.lang.String  _wl_block11 ="</span><span id=\"doc_no\">";
    private final static byte[]  _wl_block11Bytes = _getBytes( _wl_block11 );

    private final static java.lang.String  _wl_block12 ="</span></b></td>\n\t<td class=ITEMSELECT width=\'6%\' ><b>";
    private final static byte[]  _wl_block12Bytes = _getBytes( _wl_block12 );

    private final static java.lang.String  _wl_block13 =":&nbsp;</b></td>\n\t<td class=ITEMSELECT width=\'15%\' nowrap><b><span id=\"store_desc\">";
    private final static byte[]  _wl_block13Bytes = _getBytes( _wl_block13 );

    private final static java.lang.String  _wl_block14 ="</span></b></td>\n\t<td class=ITEMSELECT width=\'10%\' ><b>";
    private final static byte[]  _wl_block14Bytes = _getBytes( _wl_block14 );

    private final static java.lang.String  _wl_block15 =":&nbsp;</b></td>\n\t<td class=ITEMSELECT width=\'8%\'><b><span id=\"doc_date\">";
    private final static byte[]  _wl_block15Bytes = _getBytes( _wl_block15 );

    private final static java.lang.String  _wl_block16 ="</span></b></td>\n<!--\t<td class=ITEMSELECT width=\'10%\' ><b id=\"doc_ref_legend\">";
    private final static byte[]  _wl_block16Bytes = _getBytes( _wl_block16 );

    private final static java.lang.String  _wl_block17 ="</b></td> Changed against ML-MMOH-CRF-0448-->\n\t<td class=ITEMSELECT width=\'10%\' ><b id=\"doc_ref_legend\">Doc Ref:&nbsp;</b></td>\n\t<td class=ITEMSELECT width=\'12%\'><b><span id=\"doc_ref\">";
    private final static byte[]  _wl_block17Bytes = _getBytes( _wl_block17 );

    private final static java.lang.String  _wl_block18 ="</span></b></td>\n</table>\n\t<input type=\"hidden\"\tname=\"doc_type_code\" id=\"doc_type_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block18Bytes = _getBytes( _wl_block18 );

    private final static java.lang.String  _wl_block19 ="\">\n\t<input type=\"hidden\"\tname=\"store_code\" id=\"store_code\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block19Bytes = _getBytes( _wl_block19 );

    private final static java.lang.String  _wl_block20 ="\">\n\t<input type=\"hidden\"\tname=\"store_code_disabled\" id=\"store_code_disabled\"\t\tvalue=\"false\">\n\t<input type=\"hidden\"\tname=\"bean_id\" id=\"bean_id\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block20Bytes = _getBytes( _wl_block20 );

    private final static java.lang.String  _wl_block21 ="\">\n\t<input type=\"hidden\"\tname=\"bean_name\" id=\"bean_name\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block21Bytes = _getBytes( _wl_block21 );

    private final static java.lang.String  _wl_block22 ="\">\n\t<input type=\"hidden\"\tname=\"param1\" id=\"param1\"\t\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block22Bytes = _getBytes( _wl_block22 );

    private final static java.lang.String  _wl_block23 ="\">\n\t<input type=\"hidden\"\tname=\"item_class_code\" id=\"item_class_code\"\t\t\tvalue=\"";
    private final static byte[]  _wl_block23Bytes = _getBytes( _wl_block23 );

    private final static java.lang.String  _wl_block24 ="\">\n\t<input type=\"hidden\"\tname=\"module_id\" id=\"module_id\"\t\t\t\tvalue=\"";
    private final static byte[]  _wl_block24Bytes = _getBytes( _wl_block24 );

    private final static java.lang.String  _wl_block25 ="\">\n\t \n\t\n\t";
    private final static byte[]  _wl_block25Bytes = _getBytes( _wl_block25 );

    private final static java.lang.String  _wl_block26 ="\n\t<script language=\"JavaScript\">\n\t\tModifyDocDetails();\n\t</script>\t\n";
    private final static byte[]  _wl_block26Bytes = _getBytes( _wl_block26 );
	
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
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);

	//System.out.println("in stheader....1...."+CommonBean.checkForNull(request.getQueryString()));
	
	String mode;
	String trn_type;
	String codeDisabled				=			"";
	request.setCharacterEncoding("UTF-8");
	String locale					=			(String)session.getAttribute("LOCALE");
	
	String bean_id					=			 CommonBean.checkForNull(request.getParameter( "bean_id" ),"stHeaderBean") ;
	String bean_name				=			 CommonBean.checkForNull(request.getParameter( "bean_name" ),"eST.Common.StHeaderBean") ;	
	
	//Added on 6/19/2005 by Sabari
	StHeaderBean bean				=			null;
	AdjustStockBean adjStBean		=			null;
	if(bean_id.equals("adjustStockBean")){
		adjStBean					=			(AdjustStockBean)getBeanObject( bean_id, bean_name,request);
		bean						=			(StHeaderBean) adjStBean.getStHeaderBean();
	}else
	{
		bean						=			(StHeaderBean)getBeanObject( bean_id, bean_name,request);
		
	}
	//System.out.println("in stheader....2....");
	//---
	String doc_type_code			=			bean.checkForNull(request.getParameter( "doc_type_code" )) ;
	String doc_no					=			bean.checkForNull(request.getParameter( "doc_no" )) ;
	String doc_date					=			bean.checkForNull(request.getParameter( "doc_date" )) ;
	String doc_ref					=			bean.checkForNull(request.getParameter( "doc_ref" )) ;
	String store_code				=			bean.checkForNull(request.getParameter( "store_code" )) ;
	String storeSQLID				=			bean.checkForNull(request.getParameter( "storeSQLID" )) ;
	String item_class_code			=			bean.checkForNull(request.getParameter("item_class_code"));	
	String module_id				=			bean.checkForNull(request.getParameter("module_id"));	
	String param1					=			request.getParameter( "param1" );
    String mfg_req_yn	= bean.checkForNull(request.getParameter( "mfg_req_yn" ), "N");//Added by suresh.r on 11-12-2014 against BRU-HIMS-CRF-080 beg
	//System.out.println("in stheader....3....");
	//if(doc_date.equals("")){
	//	doc_date = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
	//}
	
	//bean.setLanguageId(locale);
	//	bean.initDoc_type_code_List1(locale);
	//String docNoDisabled			=			"";
	
	mode							=			request.getParameter( "mode" ) ;
	trn_type						=			bean.checkForNull(request.getParameter( "trn_type" )) ;
	
	if ((bean_id.equals("stHeaderBean"))&&( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))) {
		bean.clear() ;
	}
	bean.setLanguageId(locale);
	//adjStBean.setLanguageId(locale);

	bean.setTrn_type(trn_type);
	bean.setDefault_doc(bean.checkForNull(request.getParameter("default_doc"),trn_type));
	bean.initDoc_type_code_List();
	//bean.initDoc_type_code_List1(locale);

	//Added By Sakti Sankar on 01/11/2012 against Inc#35941
	if(trn_type.equals("CON")){
		trn_type = "SAL";
	}
	//Added ends

	ServletContext context			=			getServletConfig().getServletContext();
	if ((context.getInitParameter("LOCAL_EJBS") !=null) && (context.getInitParameter("LOCAL_EJBS").equalsIgnoreCase("FALSE"))) 
		bean.setLocalEJB(false);
	bean.setMode(mode);
	bean.initStore_code_List(storeSQLID);

	//System.out.println("in stheader....5....");
	
	if ( mode.equals( eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT") )){
		bean.initialize(trn_type);
	}
	else{
		bean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code , item_class_code);
	}
	//	bean.initialize(trn_type, doc_type_code, doc_no, doc_date, doc_ref, store_code );
	if ( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_MODIFY") ) ) {
		codeDisabled	=	"disabled";
	}
	if(module_id.equals("OT")&&( mode.equals(eCommon.Common.CommonRepository.getCommonKeyValue("MODE_INSERT")))){
		String ot_doc_type =		bean.checkForNull((String)bean.fetchRecord("SELECT ST_DOC_TYPE_SLI FROM OT_PARAM_FOR_FACILITY WHERE OPERATING_FACILITY_ID = ?",bean.getLoginFacilityId()).get("ST_DOC_TYPE_SLI"),"");
		bean.setDoc_type_code(ot_doc_type);
	}
	
if (!((doc_date == null) ||(doc_date.equals(""))))
	{ 
//doc_date=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY",locale,"en");
	bean.setDoc_date(doc_date);
	}
 if (!((store_code == null) ||(store_code.equals(""))))
 {
	 bean.setStore_code(store_code);
 }
  if (!((item_class_code == null) ||(item_class_code.equals("")))){
	 bean.setItem_class_code(item_class_code);
  }
  if(!locale.equals("en")){
		doc_date	=	com.ehis.util.DateUtils.convertDate(doc_date,"DMY","en",locale);
  }
/*  Commented by Mahesh for PE
else{
		doc_date=doc_date;
  }*/
 System.out.println("in stheader....5...store_code...."+store_code+"..doc_date...."+doc_date+"....doc_type_code..."+doc_type_code+"....doc_no...."+doc_no);
 //System.out.println("in stheader....6...store_code...."+bean.getStore_code()+"..doc_date...."+doc_date+"....Doc_ref..."+bean.getDoc_ref()+"....doc_no...."+bean.getDoc_no()+"..param1..."+param1+"...doc type.."+bean.getDoc_type_code());
 
 
            _bw.write(_wl_block6Bytes, _wl_block6);
if(mfg_req_yn.equals("Y")){
            _bw.write(_wl_block7Bytes, _wl_block7);
}else{
            _bw.write(_wl_block8Bytes, _wl_block8);
}
            _bw.write(_wl_block9Bytes, _wl_block9);

            if (_jsp__tag0(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block10Bytes, _wl_block10);
            out.print( String.valueOf(bean.getDoc_type_desc()));
            _bw.write(_wl_block11Bytes, _wl_block11);
            out.print( String.valueOf((bean.getDoc_no().equals(""))?"":"/"+bean.getDoc_no()));
            _bw.write(_wl_block12Bytes, _wl_block12);

            if (_jsp__tag1(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block13Bytes, _wl_block13);
            out.print( String.valueOf(bean.getStore_desc()));
            _bw.write(_wl_block14Bytes, _wl_block14);

            if (_jsp__tag2(request, response, pageContext, _activeTag, null))
             return;
            _bw.write(_wl_block15Bytes, _wl_block15);
            out.print( String.valueOf(doc_date));
            _bw.write(_wl_block16Bytes, _wl_block16);
            out.print( String.valueOf((bean.getDoc_ref().equals(""))?"":"Doc Ref:&nbsp;"));
            _bw.write(_wl_block17Bytes, _wl_block17);
            out.print( String.valueOf(bean.getDoc_ref()));
            _bw.write(_wl_block18Bytes, _wl_block18);
            out.print( String.valueOf(bean.getDoc_type_code()));
            _bw.write(_wl_block19Bytes, _wl_block19);
            out.print( String.valueOf(bean.getStore_code()));
            _bw.write(_wl_block20Bytes, _wl_block20);
            out.print( String.valueOf(bean_id));
            _bw.write(_wl_block21Bytes, _wl_block21);
            out.print( String.valueOf(bean_name));
            _bw.write(_wl_block22Bytes, _wl_block22);
            out.print( String.valueOf(param1));
            _bw.write(_wl_block23Bytes, _wl_block23);
            out.print( String.valueOf(bean.getItem_class_code()));
            _bw.write(_wl_block24Bytes, _wl_block24);
            out.print( String.valueOf(module_id));
            _bw.write(_wl_block25Bytes, _wl_block25);

if (!bean.hasAllMandatoryValue()) {

            _bw.write(_wl_block26Bytes, _wl_block26);

}
//Added on 6/19/2005 by Sabari
if(bean_id.equals("adjustStockBean"))
  putObjectInBean(bean_id,adjStBean,request);
else
  putObjectInBean(bean_id,bean,request);


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
        __tag1.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.Store.label", java.lang.String .class,"key"));
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
        __tag2.setKey(( java.lang.String ) weblogic.jsp.internal.jsp.utils.JspRuntimeUtils.convertType("Common.date.label", java.lang.String .class,"key"));
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
}
