package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eOR.*;
import java.sql.*;
import webbeans.eCommon.*;
import eCommon.XSSRequestWrapper;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __specimenlblgenerationquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/SpecimenLblGenerationQueryCriteria.jsp", 1721727308000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 =" \n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

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

//	String readOnly = "" ;
	
	/* Mandatory checks start */
	String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_SpecimenLblGeneration" ;
	String bean_name = "eOR.SpecimenLblGenerationBean";
//	String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	SpecimenLblGenerationBean bean = (SpecimenLblGenerationBean)getBeanObject( bean_id,  bean_name, request ) ;  
	bean.setLanguageId(localeName);
	bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	Connection con=null ;

	try {
	
		con = ConnectionManager.getConnection(request);
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		
		
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels"));	  // label
		firstItem.add("ordering_facility_id");	//name of field
		firstItem.add("2");	// SIZE
		firstItem.add("2");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels"));  // label
		secondItem.add("facility_name");   //name of field
		secondItem.add("30");	// SIZE
		secondItem.add("30");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SourceType.label","common_labels"));  // label
		thirdItem.add("source_type");   //name of field
		thirdItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",C,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.referral.label","common_labels")+"");//static values that need to be
		/*
			4/5/2003 changed by kaushal to remove the department feilds from the source type list under the instruction of sunil
		*/
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object

		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels"));  // label
		fourthItem.add("source_code");   //name of field
		fourthItem.add("4");
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		//=====================================================================

		//==================== populating the 5th item in the firstitem object

		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecimenType.label","common_labels"));  // label
		fifthItem.add("specimen_type");   //name of field
		fifthItem.add("15");
		fifthItem.add("15");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 6th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.priority.label","common_labels"));  // label
		sixthItem.add("urgency_indicator");   //name of field
		sixthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.routine.label","common_labels")+",S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Stat.label","common_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.urgent.label","common_labels")+"");//static values that need to be
		sixthItem.add("30");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr



		//==================== populating the 7th item in the firstitem object

		ArrayList seventhItem=new ArrayList();
		seventhItem.add("List");  //Type of item
		seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NurseCollect.label","or_labels"));  // label
		seventhItem.add("nurse_collect_yn");   //name of field
		seventhItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels")+"");//static values that need to be
		seventhItem.add("30");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr


		//==================== populating the 8th item in the firstitem object

		function_id = request.getParameter( "function_id" );

		ArrayList eightItem = new ArrayList();
		eightItem.add("Hidden");  //Type of item
		eightItem.add("function_id");  // name of field
		eightItem.add(function_id);   //value of field
		finAr.add(eightItem); //add to ArrayList obj finAr


		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];

		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityID.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FacilityName.label","common_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SourceType.label","common_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SourceCode.label","or_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.Urgency.label","or_labels");
		orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SpecimenType.label","common_labels");
		orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NurseCollect.label","or_labels");

	
		orderByColVals[0] = "ORDERING_FACILITY_ID";
		orderByColVals[1] = "facility_name";
		orderByColVals[2] = "source_type";
		orderByColVals[3] = "source_code";
		orderByColVals[4] = "urgency_indicator";
		orderByColVals[5] = "specimen_type";
		orderByColVals[6] = "nurse_collect_yn";

	

		//===============yet to explore================================//

		strbuff = qrypg.getQueryPage(con, finAr, "EORTickSheet", "../../eOR/jsp/SpecimenLblGenerationQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

		//=========================================================================//

		out.println(strbuff.toString());
		 putObjectInBean(bean_id,bean,request);
	}
	catch (Exception e) {
		//out.println("main"+e);//COMMON-ICN-0181
		 e.printStackTrace();//COMMON-ICN-0181
	}finally{
		try
		 { 
			if(con!=null)
				ConnectionManager.returnConnection(con, request);
		 }catch(Exception e){
		 
		 }
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
