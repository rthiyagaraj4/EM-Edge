package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import ePH.*;
import ePH.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __dispenserightsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispenseRightsQueryCriteria.jsp", 1742389181460L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 =" ";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'type=\'text/css\'></link>\n\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
	String locale			= (String)session.getAttribute("LOCALE");
	
	String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);


	String bean_id		= "DispenseRightsBean" ;
	String bean_name	= "ePH.DispenseRightsBean";
	DispenseRightsBean bean = (DispenseRightsBean)getBeanObject( bean_id, bean_name, request ) ;
	bean.setLanguageId(locale);
	Hashtable param_legends = bean.getLegendsFromParam();

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );

	try {
		ArrayList finAr = new ArrayList();

		//populate the first item
		String user_id = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.userid.label","common_labels");
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");						//	Type of item
		firstItem.add(user_id);					//	Label
		firstItem.add("APPL_USER_ID");				//	Name of field
		firstItem.add("15");						//	Size
		firstItem.add("30");						//	Length
		finAr.add(firstItem);						//	Add to ArrayList obj finAr

		//populate the second item
		String user_name= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.username.label","common_labels");
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");						//	Type of item
		secondItem.add(user_name);				//	Label
		secondItem.add("APPL_USER_NAME");			//	Name of field
		secondItem.add("20");						//	Size
		secondItem.add("60");						//	Length
		finAr.add(secondItem);						//	Add to ArrayList obj finAr

		//populate the third item
		String Disp_Locn_Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationCode.label","ph_labels");
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");						//	Type of item
		thirdItem.add(Disp_Locn_Code);	//	Label
		thirdItem.add("DISP_LOCN_CODE");			//	Name of field
		thirdItem.add("6");							//	Size
		thirdItem.add("6");							//	length
		finAr.add(thirdItem);						//	Add to ArrayList obj finAr

		//populate the fourth item
		String Dispense_Location_Description = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationDescription.label","ph_labels");
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("Text");								//	Type of item
		fourthItem.add(Dispense_Location_Description);	//	Label
		fourthItem.add("SHORT_DESC");						//	Name of field
		fourthItem.add("15");								//	Size
		fourthItem.add("15");								//	Length
		finAr.add(fourthItem);								//	Add to ArrayList obj finAr

		//populate the fifth item
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String yes_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
		String no_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		String Both_Yes_No="%,"+Both_legend+",Y,"+yes_legend+",N,"+no_legend;
		ArrayList fifthItem=new ArrayList();
		fifthItem.add("List");						//	Type of item
		fifthItem.add(param_legends.get("R"));				//	Label
		fifthItem.add("ACK_YN");					//	Name of field
		fifthItem.add(Both_Yes_No);			//	Static values for list box.
		fifthItem.add("7");							//	Length
		finAr.add(fifthItem);						//	Add to ArrayList obj finAr

		//populate the sixth item
		ArrayList sixthItem=new ArrayList();
		sixthItem.add("List");						//	Type of item
		sixthItem.add(param_legends.get("V"));					//	Label
		sixthItem.add("VERIFY_YN");					//	Name of field
		sixthItem.add(Both_Yes_No);			//	Static values for list box.
		sixthItem.add("7");							//	Length
		finAr.add(sixthItem);						//	Add to ArrayList obj finAr

		//populate the seventh item
		ArrayList seventhItem=new ArrayList();
		seventhItem.add("List");					//	Type of item
		seventhItem.add(param_legends.get("F"));					//	Label
		seventhItem.add("FILL_YN");					//	Name of field
		seventhItem.add(Both_Yes_No);		//	Static values for list box.
		seventhItem.add("7");						//	Length
		finAr.add(seventhItem);						//	Add to ArrayList obj finAr

		//populate the eighth item
		ArrayList eighthItem=new ArrayList();
		eighthItem.add("List");						//	Type of item
		eighthItem.add(param_legends.get("D"));					//	Label
		eighthItem.add("DELIVER_YN");				//	Name of field
		eighthItem.add(Both_Yes_No);		//	Static values for list box.
		eighthItem.add("7");						//	Length
		finAr.add(eighthItem);						//	Add to ArrayList obj finAr

		//populate the nineth item
		String Medication_Return = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.MedicationReturn.label","ph_labels");
		ArrayList ninthItem=new ArrayList();
		ninthItem.add("List");						//	Type of item
		ninthItem.add(Medication_Return);			//	Label
		ninthItem.add("ACCEPT_MEDN_RTN_YN");		//	Name of field
		ninthItem.add(Both_Yes_No);			//	Static values for list box.
		ninthItem.add("7");							//	Length
		finAr.add(ninthItem);						//	Add to ArrayList obj finAr

		/*//populate the tenth item
		ArrayList tenthItem=new ArrayList();
		tenthItem.add("List");						//	Type of item
		tenthItem.add(param_legends.get("B"));			//	Label
		tenthItem.add("BILL_RECEIPT_YN");			//	Name of field
		tenthItem.add(Both_Yes_No);			//	Static values that need to be displayed as	option.Send it along with the value that is inserted.
		tenthItem.add("7");							//	Length
		finAr.add(tenthItem);						//	Add to ArrayList obj finAr*/

		//populate the eleventh item
		ArrayList eleventhItem=new ArrayList();
		eleventhItem.add("List");					//	Type of item
		eleventhItem.add(param_legends.get("A"));				//	Label
		eleventhItem.add("ALLOCATE_YN");			//	Name of field
		eleventhItem.add(Both_Yes_No);		//	Static values for list box.
		eleventhItem.add("7");						//	Length
		finAr.add(eleventhItem);					//	Add to ArrayList obj finAr

		//populate the twelveth item
		ArrayList twelvethItem = new ArrayList();
		twelvethItem.add("Hidden");					//	Type of item
		twelvethItem.add("function_id");			//	Name of field
		twelvethItem.add(function_id);				//	Value of field
		finAr.add(twelvethItem);					//	Add to ArrayList obj finAr

		//=====================================================================
		String orderByCols[] = new String[2];
		String orderByColVals[] = new String[2];

		orderByCols[0] = user_id;
		orderByCols[1] = user_name;
		orderByColVals[0] = "APPL_USER_ID";
		orderByColVals[1] = "APPL_USER_NAME";

		String Drug_Category = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DrugCategory.label","ph_labels");
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
        String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
        String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
        String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
        String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		strbuff = qrypg.getMultiColumnQueryPage(null, finAr, Drug_Category , "DispenseRightsQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString().replace("nowrap", ""));
	}
	catch (Exception e) {
		out.println( "main " + e );
	}

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
