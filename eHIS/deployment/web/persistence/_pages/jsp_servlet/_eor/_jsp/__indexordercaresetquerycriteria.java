package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import eOR.*;
import java.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __indexordercaresetquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/IndexOrderCareSetQueryCriteria.jsp", 1721823242000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );
	
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block4Bytes, _wl_block4);

		
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block1Bytes, _wl_block1);


	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	/* Mandatory checks start */
	String bean_id = "indexordercareset" ;
	String bean_name = "eOR.IndexOrderCareSetBean";
	String function_id = request.getParameter("function_id");
	/* Mandatory checks end */

	/* Initialize Function specific start */
	IndexOrderCareSetBean bean = (IndexOrderCareSetBean)getBeanObject( bean_id,  bean_name, request ) ;
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
/*
	String comboBox = bean.getComboOptionsOrdCategory();
	//out.println("comboBox :"+comboBox);
	ArrayList firstItem = new ArrayList();
	firstItem.add("List");  			//Type of item
	firstItem.add("Order Category");	// label
	firstItem.add("order_category");	//name of field
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;---Select---,");	// SIZE
	finAr.add(firstItem);				//add to ArrayList obj finAr
*/
	//================= populating the second item in the firstitem object

	ArrayList secondItem=new ArrayList();
	secondItem.add("Text");				//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetCode.label","or_labels"));	// label
	secondItem.add("order_set_code");	//name of field
	secondItem.add("10");				// SIZE
	secondItem.add("10");				//LENGTH
	finAr.add(secondItem);				//add to ArrayList obj finAr

	//================= populating the 3rd item in the firstitem object

	ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");				//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetDesc.label","or_labels"));  // label
	thirdItem.add("order_set_desc");   //name of field
	thirdItem.add("30");				//SIZE
	thirdItem.add("30");				//LENGTH
	finAr.add(thirdItem);				//add to ArrayList obj finAr

	//================= populating the 4th item in the firstitem object

	ArrayList forthItem=new ArrayList();
	forthItem.add("List");				// Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.IndexType.label","common_labels"));

	forthItem.add("index_type");
	forthItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+",F,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.BySource.label","or_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.diagnosis.label","common_labels")+"");
	//forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.IndexType.label","or_labels"));
	//forthItem.add("index_type");		// name of field
	//forthItem.add(" ,&nbsp;&nbsp;&nbsp;---Select---,F,By Source,P,Practitioner,S,Service,D,Diagnosis");// LENGTH

	//,A,Patient/Diagnosis

	finAr.add(forthItem);				//add to ArrayList obj finAr


	//================= populating the 5th item in the firstitem object

	ArrayList fivethItem=new ArrayList();
	fivethItem.add("List");				// Type of item
	fivethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SourceType.label","common_labels"));

	fivethItem.add("source_type");
	fivethItem.add(	" ,--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ,"+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+"");
	//fivethItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceType.label","or_labels"));
	//fivethItem.add("source_type");		// name of field
	//fivethItem.add(" ,&nbsp;&nbsp;&nbsp;---Select---,A,All,C,Clinic,N,Nursing Unit");// LENGTH
	finAr.add(fivethItem);				//add to ArrayList obj finAr

	//================= populating the 6th item in the firstitem object

	ArrayList sixthItem=new ArrayList();
	sixthItem.add("Text");				// Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels"));		// label
	sixthItem.add("source_code");		// name of field
	sixthItem.add("6");					// size
	sixthItem.add("6");					//LENGTH
	finAr.add(sixthItem);				//add to ArrayList obj finAr

	//================= populating the 7th item in the firstitem object

	ArrayList seventhItem=new ArrayList();
	seventhItem.add("Text");			// Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceDesc.label","or_labels"));		// label
	seventhItem.add("short_desc");		// name of field
	seventhItem.add("30");				// size
	seventhItem.add("30");				//LENGTH
	finAr.add(seventhItem);				//add to ArrayList obj finAr

	//================= populating the 15th item in the firstitem object

	ArrayList fifteenthItem=new ArrayList();
	fifteenthItem.add("Text");				// Type of item
	fifteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));   // label
	fifteenthItem.add("facility_id");   // name of field
	fifteenthItem.add("15");				// size
	fifteenthItem.add("15");				//LENGTH
	finAr.add(fifteenthItem);				//add to ArrayList obj finAr

	//================= populating the 16th item in the firstitem object

	ArrayList sixteenthItem=new ArrayList();
	sixteenthItem.add("Text");				// Type of item
	sixteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","st_labels")); // label
	sixteenthItem.add("facility_name"); // name of field
	sixteenthItem.add("30");				// size
	sixteenthItem.add("30");				//LENGTH
	finAr.add(sixteenthItem);				//add to ArrayList obj finAr

	//================= populating the 8th item in the firstitem object

	ArrayList eightItem=new ArrayList();
	eightItem.add("Text");				// Type of item
	eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels"));   // label
	eightItem.add("practitioner_id");   // name of field
	eightItem.add("15");				// size
	eightItem.add("15");				//LENGTH
	finAr.add(eightItem);				//add to ArrayList obj finAr

	//================= populating the 9th item in the firstitem object

	ArrayList ninthItem=new ArrayList();
	ninthItem.add("Text");				// Type of item
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels")); // label
	ninthItem.add("practitioner_name"); // name of field
	ninthItem.add("30");				// size
	ninthItem.add("30");				//LENGTH
	finAr.add(ninthItem);				//add to ArrayList obj finAr

	//================= populating the 10th item in the firstitem object

	ArrayList tenthItem=new ArrayList();
	tenthItem.add("Text");				// Type of item
	tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels"));		// label
	tenthItem.add("service_code");		// name of field
	tenthItem.add("4");					// size
	tenthItem.add("4");					//LENGTH
	finAr.add(tenthItem);				//add to ArrayList obj finAr

	//================= populating the 11th item in the firstitem object

	ArrayList eleventhItem=new ArrayList();
	eleventhItem.add("Text");			 // Type of item
	eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ServiceDesc.label","or_labels"));    // label
	eleventhItem.add("service_name");    // name of field
	eleventhItem.add("30");				 // size
	eleventhItem.add("30");				 //LENGTH
	finAr.add(eleventhItem);			 //add to ArrayList obj finAr

	//================= populating the 13th item in the firstitem object

	ArrayList thirteenth=new ArrayList();
	thirteenth.add("Text");				// Type of item
	thirteenth.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisCode.label","common_labels"));		// label
	thirteenth.add("diagnosis_code");		// name of field
	thirteenth.add("4");					// size
	thirteenth.add("4");					//LENGTH
	finAr.add(thirteenth);				//add to ArrayList obj finAr

	//================= populating the 14th item in the firstitem object

	ArrayList fourteenthItem=new ArrayList();
	fourteenthItem.add("Text");			 // Type of item
	fourteenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiagnosisDesc.label","or_labels"));    // label
	fourteenthItem.add("diagnosis_desc");    // name of field
	fourteenthItem.add("30");				 // size
	fourteenthItem.add("30");				 //LENGTH
	finAr.add(fourteenthItem);			 //add to ArrayList obj finAr

	//======================

	ArrayList twelthItem=new ArrayList();
	twelthItem.add("Hidden");			 // Type of item
	twelthItem.add("function_id");    // label
	twelthItem.add(function_id);    // name of field
	finAr.add(twelthItem);			 //add to ArrayList obj finAr



	String orderByCols[] = new String[12];
	String orderByColVals[] = new String[12];

	orderByCols[0]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetCode.label","or_labels");
	orderByCols[1]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.OrderSetDesc.label","or_labels");
	orderByCols[2]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels");
	orderByCols[3]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceDesc.label","or_labels");
	orderByCols[4]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
	orderByCols[5]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","st_labels");
	orderByCols[6]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionerid.label","common_labels");
	orderByCols[7]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitionername.label","common_labels");
	orderByCols[8]		= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ServiceCode.label","common_labels");
	orderByCols[9]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.ServiceDesc.label","or_labels");
	orderByCols[10]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DiagnosisCode.label","common_labels");
	orderByCols[11]	= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DiagnosisDesc.label","or_labels");

	orderByColVals[0]	= "order_set_code";
	orderByColVals[1]	= "order_catalog_desc";
	orderByColVals[2]	= "source_code";
	orderByColVals[3]	= "location_desc";
	orderByColVals[4]	= "facility_id";
	orderByColVals[5]	= "facility_name";
	orderByColVals[6]	= "practitioner_id";
	orderByColVals[7]	= "practitioner_name";
	orderByColVals[8]	= "service_code";
	orderByColVals[9]	= "service_desc";
	orderByColVals[10]	= "diagnosis_code";
	orderByColVals[11]	= "diag_desc";

	strbuff =qrypg.getMultiColumnQueryPage(null,finAr,"indexordercareset", "../../eOR/jsp/IndexOrderCareSetQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));


	//strbuff =qrypg.getQueryPage(null, finAr, "indexticksheet", "../../eOR/jsp/IndexTickSheetQueryResult.jsp", "Sort Order", "Query Criteria", "Select", "Order by", orderByCols, orderByColVals, "Execute Query");

	out.println(strbuff.toString());
strbuff.setLength(0);
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
