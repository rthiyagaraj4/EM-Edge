package jsp_servlet._emm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eMM.StoreBean;
import eMM.Common.*;
import eCommon.Common.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __storequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emm/jsp/StoreQueryCriteria.jsp", 1709116970000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' ></link>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

		request.setCharacterEncoding("UTF-8");
		response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
		response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
		String locale			= (String)session.getAttribute("LOCALE");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff = new StringBuffer();
String bean_id				=	"storeBean" ;
String bean_name			=	"eMM.StoreBean";
StoreBean bean = (StoreBean)getBeanObject( bean_id, bean_name, request );
bean.setLanguageId(locale);
//ArrayList	arrDept			=	null;

String function_id = request.getParameter( "function_id" );

//	arrDept		=	bean.getDepartment();
	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();
	
	String Store_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreCode.label","common_labels");

	firstItem.add("Text");  		    //Type of item
	firstItem.add(Store_Code);	   // label
	firstItem.add("store_code");	  //name of field
	firstItem.add("6");				 // SIZE
	firstItem.add("6");				//LENGTH

	finAr.add(firstItem);			//add to ArrayList obj finAr
	
	ArrayList secondItem=new ArrayList();

	String Store_Desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.StoreDescription.label","common_labels");

	secondItem.add("Text");			    //Type of item
	secondItem.add(Store_Desc);      // label
	secondItem.add("short_desc");     //name of field
	secondItem.add("15");			 // SIZE
	secondItem.add("15");			//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem=new ArrayList();

	String department = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels");
	thirdItem.add("List");		 //Type of item
	thirdItem.add(department);	// label
	thirdItem.add("dept_code");   //name of field
	thirdItem.add(eMM.Common.MmRepository.getMmKeyValue("SQL_MM_STORE_DEPT"));
//	thirdItem.add("SELECT empno,ename from emp where 'C1'=?");
	ArrayList alParameter	=	new ArrayList(1);
	alParameter.add((String)session.getAttribute("facility_id"));
	thirdItem .add(alParameter);
	finAr.add(thirdItem); //add to ArrayList obj finAr


	ArrayList itemStoreGroup=new ArrayList();

	String storeGroup = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.StoreGroup.label","mm_labels");
	itemStoreGroup.add("List");		 //Type of item
	itemStoreGroup.add(storeGroup);	// label
	itemStoreGroup.add("store_group");   //name of field
	itemStoreGroup.add("SELECT STORE_GROUP_CODE,SHORT_DESC FROM MM_STORE_GROUP_LANG_VW WHERE EFF_STATUS = 'E' AND LANGUAGE_ID = ? ORDER BY SHORT_DESC");
	alParameter	=	new ArrayList();
	alParameter.add(locale);
	itemStoreGroup .add(alParameter);
	finAr.add(itemStoreGroup); //add to ArrayList obj finAr
	
		
	
	

	ArrayList fourthItem=new ArrayList();
	
	String Store_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Store.label","common_labels");
	String All_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");
	String External_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels");
	String Internal_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Internal.label","common_labels");
	String Store_List="%,"+All_legend+",Y,"+External_legend+",N,"+Internal_legend;

	fourthItem.add("List");		 //Type of item
	fourthItem.add(Store_legend);	// label
	fourthItem.add("external_yn");   //name of field
	fourthItem.add(Store_List);//
	fourthItem.add("4");
	

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();
	
	String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
	String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
	String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
	String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
	String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
	fifthItem.add("List");		 //Type of item
	fifthItem.add(Nature);	// label
	fifthItem.add("nature");   //name of field
	fifthItem.add(Nature_List);//static values that need to be displayed as option.Send it along with the value that is inserted.
	fifthItem.add("4");		//LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem=new ArrayList();

	sixthItem.add("Hidden");	// label
	sixthItem.add("function_id");   //name of field
	sixthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.

	finAr.add(sixthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = Store_Code;
	orderByCols[1] = Store_Desc;

	orderByColVals[0] = "store_code";
	orderByColVals[1] = "short_desc";

	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


	strbuff = qrypg.getQueryPage((java.util.Properties)session.getAttribute("jdbc"),finAr,Store_Code,"StoreQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery,true);

	out.println(strbuff.toString());


            _bw.write(_wl_block1Bytes, _wl_block1);

putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block1Bytes, _wl_block1);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
