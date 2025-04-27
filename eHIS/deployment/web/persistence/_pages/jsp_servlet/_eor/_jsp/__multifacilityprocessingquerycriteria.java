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

public final class __multifacilityprocessingquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/MultiFacilityProcessingQueryCriteria.jsp", 1725446428000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

	request.setCharacterEncoding("UTF-8"); 
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block2Bytes, _wl_block2);

	
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	
	/* Mandatory checks start */
	
	String bean_id = "multifacilityprocessingbean" ;
	String bean_name = "eOR.MultiFacilityProcessingBean";
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	MultiFacilityProcessingBean bean = (MultiFacilityProcessingBean)getBeanObject( bean_id,bean_name, request ) ;  
	bean.clear() ;
	bean.setLanguageId(localeName);
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	String comboBox = bean.getOrCatString();
	//out.println("comboBox :"+comboBox);

	ArrayList firstItem=new ArrayList();
	firstItem.add("Text");					// Type of item
	//firstItem.add(" Ordering Facility Id");
	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingFacilityID.label","common_labels"));	// label
	
	firstItem.add("ordering_facility_id");	// name of field
	firstItem.add("2");						// SIZE
	firstItem.add("2");						// LENGTH
	finAr.add(firstItem);					// add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");  					//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingFacilityName.label","common_labels"));	// label
	secondItem.add("order_facility_name");	    //name of field
	secondItem.add("25");						// SIZE
	secondItem.add("60");						//LENGTH
	finAr.add(secondItem);						//add to ArrayList obj finAr

	//======================

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("List");						//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));			// label
	thirdItem.add("order_category");			//name of field
	thirdItem.add(" ,---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---,"+comboBox);		//LENGTH
	thirdItem.add("30");						//LENGTH
	finAr.add(thirdItem);						//add to ArrayList obj finAr


	ArrayList forthItem=new ArrayList();
	forthItem.add("Hidden");						// Type of item
	forthItem.add("function_id");					// label
	forthItem.add(function_id);						// name of field
	finAr.add(forthItem);					//add to ArrayList obj finAr

	//================= populating the second item in the firstitem object
	//================= populating the 3rd item in the firstitem object
	//================= populating the 4th item in the firstitem object
	//================= populating the 5th item in the firstitem object
	
	ArrayList fivethItem=new ArrayList();
	fivethItem.add("Text");					// Type of item
	fivethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels"));		// label
	fivethItem.add("order_type_code");		// name of field
	fivethItem.add("4");					// LENGTH
	fivethItem.add("4");					//LENGTH
	finAr.add(fivethItem);					//add to ArrayList obj finAr

	//================= populating the 6th item in the firstitem object
	
	ArrayList sixthItem=new ArrayList();
	sixthItem.add("Text");						// Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels"));			// label
	sixthItem.add("order_type_desc");			// name of field
	sixthItem.add("15");						// size
	sixthItem.add("15");						//LENGTH
	finAr.add(sixthItem);						//add to ArrayList obj finAr

	//================= populating the 7th item in the firstitem object

	ArrayList seventhItem=new ArrayList();
	seventhItem.add("Text");					// Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityID.label","common_labels"));	// label
	seventhItem.add("performing_facility_id");	// name of field
	seventhItem.add("2");						// size
	seventhItem.add("2");						//LENGTH
	finAr.add(seventhItem);						//add to ArrayList obj finAr

	//================= populating the 8th item in the firstitem object

	ArrayList eightItem=new ArrayList();
	eightItem.add("Text");						// Type of item
	eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityName.label","common_labels"));  // label
	eightItem.add("performing_facility_name");  // name of field
	eightItem.add("25");						// size
	eightItem.add("60");						//LENGTH
	finAr.add(eightItem);						//add to ArrayList obj finAr

	//================= populating the 9th item in the firstitem object
	
	ArrayList ninthItem=new ArrayList();
	ninthItem.add("Text");						// Type of item
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels"));		// label
	ninthItem.add("order_catalog_code");		// name of field
	ninthItem.add("10");						// size
	ninthItem.add("10");						//LENGTH
	finAr.add(ninthItem);						//add to ArrayList obj finAr

	//================= populating the 10th item in the firstitem object
	
	ArrayList tenthItem=new ArrayList();
	tenthItem.add("Text");						// Type of item
	tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels"));		// label
	tenthItem.add("order_catalog_desc");		// name of field
	tenthItem.add("15");						// size
	tenthItem.add("40");						//LENGTH
	finAr.add(tenthItem);						//add to ArrayList obj finAr

	//================= populating the 11th item in the firstitem object
	
	String orderByCols[] = new String[9];
	String orderByColVals[] = new String[9];

	orderByCols[0]		= //com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderingFacilityId.label","or_labels");
	orderByCols[0]		= "Ordering Facility ID";
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderingFacilityName.label","common_labels");
	orderByCols[2]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
	orderByCols[3]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderTypeCode.label","common_labels");
	orderByCols[4]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderTypeDesc.label","or_labels");
	orderByCols[5]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityID.label","common_labels");
	orderByCols[6]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PerformingFacilityName.label","common_labels");
	orderByCols[7]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrdercatalogCode.label","common_labels");
	orderByCols[8]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCatalogDesc.label","common_labels");
	

	orderByColVals[0]	= "ordering_facility_id";    
	orderByColVals[1]	= "order_facility_name";  
	orderByColVals[2]	= "order_category";   
	orderByColVals[3]	= "order_type_code";      
	orderByColVals[4]	= "order_type_desc";       
	orderByColVals[5]	= "performing_facility_id";  
	orderByColVals[6]	= "performing_facility_name";
	orderByColVals[7]	= "order_catalog_code";     
	orderByColVals[8]	= "order_catalog_desc";     
	
	
	strbuff =qrypg.getMultiColumnQueryPage(null, finAr, "multifacilityprocessingbean", "../../eOR/jsp/MultiFacilityProcessingQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	//strbuff =qrypg.getQueryPage(null, finAr, "indexticksheet", "../../eOR/jsp/IndexTickSheetQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");

	out.println(strbuff.toString().replace("nowrap",""));
	strbuff.setLength(0);

	putObjectInBean(bean_id,bean,request);



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
