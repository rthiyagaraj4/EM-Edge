package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eOR.*;
import eOR.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __ordersetquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/OrderSetQueryCriteria.jsp", 1716352398000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 =" \n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n";
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
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);

/*
---------------------------------------------------------------------------------------------------------------------------------
Date       	Edit History    Name        	Rev.Date		Rev.Name		Description
---------------------------------------------------------------------------------------------------------------------------------
08/01/2020	IN068314		Nijitha S     	08/01/2020		Ramesh G		ML-MMOH-CRF-1229
---------------------------------------------------------------------------------------------------------------------------------
*/

            _bw.write(_wl_block0Bytes, _wl_block0);

try
{
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block7Bytes, _wl_block7);

//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
//======================================================================//

	//String readOnly = "" ;
	
	/* Mandatory checks start */
	String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_CareSet" ;
	String bean_name = "eOR.CareSetBean";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	CareSetBean bean = (CareSetBean)getBeanObject( bean_id,  bean_name, 	request ) ;  

	bean.clearALL();
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;
	Boolean isFPPApplicableyn =false;//IN068314
	try {
	
		ArrayList finAr = new ArrayList();
		con = ConnectionManager.getConnection(request);//IN068314
		isFPPApplicableyn = eCommon.Common.CommonBean.isSiteSpecific(con, "OR","FPP_APPLICABLE_YN");//IN068314
		bean.setIsFPPApplicable(isFPPApplicableyn);//IN068314 
		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetCode.label","or_labels"));  // label
		secondItem.add("order_set_code");   //name of field
		secondItem.add("15");	// SIZE
		secondItem.add("15");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.longdescription.label","common_labels"));  // label
		thirdItem.add("long_desc");   //name of field
		thirdItem.add("60");	// SIZE
		thirdItem.add("60");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels"));  // label
		fourthItem.add("short_desc");   //name of field
		fourthItem.add("40");
		fourthItem.add("40");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();

		String comboString = bean.getComboString();

		firstItem.add("List");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		firstItem.add("order_category");	//name of field
		firstItem.add(" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---," + comboString);	// SIZE
		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr


		//=====================================================================

		//==================== populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));  // label
		fifthItem.add("order_type_code");   //name of field
		fifthItem.add("4");
		fifthItem.add("4");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 6th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("Text");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));  // label
		sixthItem.add("order_type_desc");   //name of field
		sixthItem.add("15");
		sixthItem.add("15");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr


		/****************/
		ArrayList seventhItem=new ArrayList();
		seventhItem.add("List");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		seventhItem.add("eff_status");   //name of field
		seventhItem.add("''B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		seventhItem.add("7");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr

		//IN068314 Starts
		if(isFPPApplicableyn)
		{
			ArrayList eighthItem=new ArrayList();			
			eighthItem.add("Check");  //Type of item
			eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.FilterByFPP.label","or_labels"));  // label
			eighthItem.add("fpp_yn");   //name of field
			
			finAr.add(eighthItem); //add to ArrayList obj finAr
		}
		//INO68314 Ends



		//==================== populating the 10th item in the firstitem object

		function_id = request.getParameter( "function_id" );

		ArrayList tenthItem = new ArrayList();
		tenthItem.add("Hidden");  //Type of item
		tenthItem.add("function_id");  // name of field
		tenthItem.add(function_id);   //value of field
		finAr.add(tenthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetCode.label","or_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetDesc.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
		
		

	
		orderByColVals[0] = "a.order_catalog_code";
		orderByColVals[1] = "a.short_desc";
		orderByColVals[2] = "a.order_category";
		orderByColVals[3] = "a.order_type_code";
		orderByColVals[4] = "b.short_desc";
		


	

		//===============yet to explore================================//

		strbuff = qrypg.getQueryPage(null, finAr, "EORCatalogBySection", "../../eOR/jsp/OrderSetQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//=========================================================================//

		out.println(strbuff.toString());
		strbuff.setLength(0);
		putObjectInBean(bean_id,bean,request);

	}
	catch (Exception e) {
		e.printStackTrace();
	}/*finally{
		try
		 {  
			ConnectionManager.returnConnection(con);
		 }catch(Exception e){
		 
		 }
	}*/
}
catch(Exception e)
{
e.printStackTrace();
}

            _bw.write(_wl_block7Bytes, _wl_block7);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
