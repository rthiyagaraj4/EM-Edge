package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import ePH.*;
import ePH.Common.*;
import eCommon.Common.*;
import java.text.*;
import java.lang.*;
import java.util.*;
import java.lang.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __presremarkquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PresRemarkQueryCriteria.jsp", 1742386145474L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\'></link>\n<script language=\"javascript\" src=\"../../eCommon/js/ValidateControl.js\"></script>\n<BODY style=\"overflow-y:hidden\" onMouseDown=\"\" onKeyDown=\"lockKey()\">\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

       request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//endss
	    String locale			= (String)session.getAttribute("LOCALE");
	  
	    String sStyle =(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute
		("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );

	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		ArrayList firstItem = new ArrayList();
		String RemarkCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RemarkCode.label","ph_labels");
		firstItem.add("Text");				//	Type of item
		firstItem.add(RemarkCode);		//	Label
		firstItem.add("REMARK_CODE");		//	Name of field
		firstItem.add("4");					//	SIZE
		firstItem.add("4");					//	LENGTH
		finAr.add(firstItem);				//	Add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		String RemarkDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RemarkDescription.label","ph_labels");
		secondItem.add("Text");				//	Type of item
		secondItem.add(RemarkDescription);		//	Label
		secondItem.add("REMARK_DESC");		//	Name of field
		secondItem.add("45");				//	SIZE
		secondItem.add("40");				//	LENGTH
		finAr.add(secondItem);				//	Add to ArrayList obj finAr

		//================= populating the third item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		String FormCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormCode.label","ph_labels");
		thirdItem.add("Text");				//	Type of item
		thirdItem.add(FormCode);			//	Label
		thirdItem.add("FORM_CODE");			//	Name of field
		thirdItem.add("4");					//	SIZE
		thirdItem.add("4");					//	LENGTH
		finAr.add(thirdItem);				//	Add to ArrayList obj finAr

		//================= populating the fourth item in the firstitem object
		ArrayList fourthItem=new ArrayList();
		String FormDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.FormDescription.label","ph_labels");
		fourthItem.add("Text");				//	Type of item
		fourthItem.add(FormDescription);	//	Label
		fourthItem.add("FORM_DESC");		//	Name of field
		fourthItem.add("45");				//	SIZE
		fourthItem.add("40");				//	LENGTH
		finAr.add(fourthItem);				//	Add to ArrayList obj finAr

		//================= populating the fifth item in the firstitem object
		ArrayList fifthItem=new ArrayList();
		String RouteCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteCode.label","ph_labels");
		fifthItem.add("Text");				//	Type of item
		fifthItem.add(RouteCode);		    //	Label
		fifthItem.add("ROUTE_CODE");		//	Name of field
		fifthItem.add("4");					//	SIZE
		fifthItem.add("4");					//	LENGTH
		finAr.add(fifthItem);				//	Add to ArrayList obj finAr

		//================= populating the sixth item in the firstitem object
		ArrayList sixthItem=new ArrayList();
		String RouteDescription = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.RouteDescription.label","ph_labels");
		sixthItem.add("Text");				//	Type of item
		sixthItem.add(RouteDescription);	//	Label
		sixthItem.add("ROUTE_DESC");		//	Name of field
		sixthItem.add("45");				//	SIZE
		sixthItem.add("40");				//	LENGTH
		finAr.add(sixthItem);				//	Add to ArrayList obj finAr

		ArrayList seventhItem=new ArrayList();
		String SlidingScaleRemarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.SlidingScaleRemarks.label","ph_labels");

		 String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Applicable = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Applicable.label","common_labels");
		String NotApplicable = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.notapplicable.label","common_labels");
		String tpn_item_list_values="%,"+Both_legend+",Y,"+Applicable+",N,"+NotApplicable;
 

		seventhItem.add("List");  //Type of item
		seventhItem.add(SlidingScaleRemarks);  // label
		seventhItem.add("APPL_SLIDING_SCALE_YN");   //name of field
		seventhItem.add(tpn_item_list_values);//static values that need to be displayed as
		seventhItem.add("7");	//LENGTH
		finAr.add(seventhItem); //add to ArrayList obj finAr

		ArrayList eighthItem = new ArrayList();
		eighthItem.add("Hidden");			//	Type of item
		eighthItem.add("function_id");		//	name of field
		eighthItem.add(function_id);		//	value of field
		finAr.add(eighthItem);				//	add to ArrayList obj finAr

		//=====================================================================
		String orderByCols[] = new String[7];
		String orderByColVals[] = new String[7];

		orderByCols[0] = RemarkCode;
		orderByCols[1] = RemarkDescription;
		orderByCols[2] = FormCode;
		orderByCols[3] = FormDescription;
		orderByCols[4] = RouteCode;
		orderByCols[5] = RouteDescription;
		orderByCols[6] = SlidingScaleRemarks;

		orderByColVals[0] = "A.REMARK_CODE";
		orderByColVals[1] = "A.REMARK_DESC";
		orderByColVals[2] = "A.FORM_CODE";
		orderByColVals[3] = "B.FORM_DESC";
		orderByColVals[4] = "A.ROUTE_CODE";
		orderByColVals[5] = "C.ROUTE_DESC ";
		orderByColVals[6] = "A.APPL_SLIDING_SCALE_YN ";


String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
String PrescriptionRemarks=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.PrescriptionRemarks.label","ph_labels");



		strbuff = qrypg.getQueryPage(null, finAr,PrescriptionRemarks,"PresRemarkQueryResult.jsp", Sort_order,QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}

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
