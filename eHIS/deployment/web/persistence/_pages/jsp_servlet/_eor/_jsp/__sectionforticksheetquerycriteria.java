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
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;
import java.util.*;
import com.ehis.util.*;

public final class __sectionforticksheetquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/SectionForTickSheetQueryCriteria.jsp", 1709120014000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\t<script language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></script>\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n\n\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );
	
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block3Bytes, _wl_block3);
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
            _bw.write(_wl_block3Bytes, _wl_block3);

request.setCharacterEncoding("UTF-8"); 
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	//==========================yet to explore==============================//
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	//======================================================================//
	//String readOnly = "" ;

	/* Mandatory checks start */
	//String function_id = request.getParameter("function_id") ;
	String bean_id = "Or_SectionForTickSheet" ;
	String bean_name = "eOR.SectionForTickSheet";
	//String disabled = "" ;
	/* Mandatory checks end */
	
	/* Initialize Function specific start */
	SectionForTickSheet  bean =
	(SectionForTickSheet)getBeanObject( bean_id,bean_name, request );  
	 bean.clear() ;
	/* Initialize Function specific end */

	StringBuffer strbuff = new StringBuffer();
	ArrayList finAr = new ArrayList();
	String  comboString = "";
	//Connection con=null ;

	try {
	
		comboString=bean.getComboString();
	}catch(Exception e){System.out.println("exception in jsp::::::"+e);}	
		ArrayList firstItem = new ArrayList();
		firstItem.add("List");  		 //Type of item
		//System.out.println("======="+pageContext);	
		firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels"));	  // label
		firstItem.add("order_category");	//name of field
		firstItem.add("'',--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" --- ," + comboString);	// SIZE
		firstItem.add("6");	//LENGTH
		finAr.add(firstItem);//add to ArrayList obj finAr

		//================= populating the second item in the firstitem object

		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");  //Type of item
		secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetID.label","or_labels"));  // label
		secondItem.add("tick_sheet_id");   //name of field
		secondItem.add("6");	// SIZE
		secondItem.add("6");	//LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		//================= populating the 3rd item in the firstitem object

		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");  //Type of item
		thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetDescription.label","or_labels"));  // label
		thirdItem.add("tick_sheet_desc");   //name of field
		thirdItem.add("30");	//LENGTH
		thirdItem.add("30");	//LENGTH
		finAr.add(thirdItem); //add to ArrayList obj finAr


		//==================== populating the 4th item in the firstitem object
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");  //Type of item
		fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels"));  // label
		fourthItem.add("section_code");   //name of field
		fourthItem.add("6");	//size
		fourthItem.add("4");	//LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		
		//=====================================================================
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("Text");  //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SectionDesc.label","or_labels"));  // label
		fifthItem.add("section_desc");   //name of field
		fifthItem.add("30");	//LENGTH
		fifthItem.add("30");	//LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		//==================== populating the 5th item in the firstitem object

		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");  //Type of item
		sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		sixthItem.add("eff_status");   //name of field
		sixthItem.add("''B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
		sixthItem.add("7");	//LENGTH
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		
		
		orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OrderCategory.label","common_labels");
		orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetID.label","or_labels");
		orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TickSheetDescription.label","or_labels");
		orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SectionCode.label","common_labels");
		orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.SectionDesc.label","or_labels");

		
		
		
		orderByColVals[0] = "short_desc";
		orderByColVals[1] = "tick_sheet_id";
		orderByColVals[2]="tick_sheet_desc";
		orderByColVals[3]="section_code";
		orderByColVals[4] = "section_desc";
		
		


		strbuff =qrypg.getQueryPage(null,finAr, "Or_SectionForTickSheet", "../../eOR/jsp/SectionForTickSheetQueryResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"), com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"), orderByCols, orderByColVals, com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());
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
