package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.ArrayList;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __dispenselocationquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/DispenseLocationQueryCriteria.jsp", 1742389138968L ,"10.3.6.0","Asia/Calcutta")) return true;
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

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block2Bytes, _wl_block2);
 
request.setCharacterEncoding("UTF-8");
//Added by Himanshu for COMMON-ICN-0182 on 17-10-2023
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//ends
		String locale			= (String)session.getAttribute("LOCALE");
	
String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String function_id = request.getParameter( "function_id" );
	try {
		ArrayList finAr = new ArrayList();

		//=============== populating the first item in the firstitem object
		String disp_locn_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationCode.label","ph_labels");
		String disp_locn=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocation.label","ph_labels");
		String disp_locn_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseLocationDescription.label","ph_labels");
		String DispenseType=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.DispenseType.label","ph_labels");
		String defaultSelect=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String pharmacy_leg=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.pharmacy.label","common_labels");
		String nursingUnit=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels");
		String clinic=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels");
	//	"A,&nbsp;&nbsp;-- Select --&nbsp;&nbsp;,P,Pharmacy,N,Nursing Unit,C,Clinic"
		String disp_type_list="A,&nbsp;&nbsp;--"+defaultSelect+"--&nbsp;&nbsp;,P,"+pharmacy_leg+",N,"+nursingUnit+",C,"+clinic;
		String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String Nature_List="B,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
		
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");							//	Type of item
		firstItem.add(disp_locn_code);		//	Label
		firstItem.add("DISP_LOCN_CODE");				//	Name of field
		firstItem.add("6");								//	SIZE
		firstItem.add("6");								//	LENGTH
		finAr.add(firstItem);							//	Add to ArrayList obj finAr

		//================= populating the second item in the firstitem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");							//	Type of item
		secondItem.add(disp_locn_desc);		//	Label
		secondItem.add("DISP_LOCN_DESC");				//	Name of field
		secondItem.add("35");							//	SIZE
		secondItem.add("30");							//	LENGTH
		finAr.add(secondItem);							//	Add to ArrayList obj finAr

		//================= populating the third item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("List");									//	Type of item
		thirdItem.add(DispenseType);							//	Label
		thirdItem.add("DISP_TYPE");								//	Name of field
		thirdItem.add(disp_type_list);	//	static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(thirdItem);									//	Add to ArrayList obj finAr

		//================= populating the fourth item in the firstitem object
		ArrayList fourthItem=new ArrayList();
		fourthItem.add("List");									//	Type of item
		fourthItem.add(Nature);								//	Label
		fourthItem.add("EFF_STATUS");							//	Name of field
		fourthItem.add(Nature_List);		//	static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(fourthItem);									//	Add to ArrayList obj finAr

		//================= populating the fifth item in the firstitem object
		ArrayList fifthItem = new ArrayList();
		fifthItem.add("Hidden");		//	Type of item
		fifthItem.add("function_id");	//	name of field
		fifthItem.add(function_id);		//	value of field
		finAr.add(fifthItem);			//	Add to ArrayList obj finAr

		//=====================================================================
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = disp_locn_code;
		orderByCols[1] = disp_locn_desc;
		orderByCols[2] = DispenseType;
		orderByCols[3] = Nature;

		orderByColVals[0] = "DISP_LOCN_CODE";
		orderByColVals[1] = "SHORT_DESC";
		orderByColVals[2] = "DISP_LOCN_TYPE";
		orderByColVals[3] = "EFF_STATUS";
		
		String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ItemClassforStore=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.ItemClassforStore.label","mm_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");


		strbuff = qrypg.getQueryPage(null, finAr, disp_locn , "DispenseLocationQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
		out.println( "main " + e );
	}

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
