package jsp_servlet._emm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import eMM.*;
import eMM.Common.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __trnremarksquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emm/jsp/TrnRemarksQueryCriteria.jsp", 1709116972000L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\' type=\'text/css\' ></link>\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);

		request.setCharacterEncoding("UTF-8");
//		String locale			= (String)session.getAttribute("LOCALE");
		//locale ="en";
//		String primary_lang		= (String)session.getAttribute("PRIMARY_LANG");
		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
 ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String function_id = request.getParameter( "function_id" );
ArrayList finAr = new ArrayList();
 
/* For Enhancement  after 10/27/2004

ArrayList firstItem11 = new ArrayList();
firstItem11.add("Text");  		 //Type of item
firstItem11.add("Module ID");	  // label
firstItem11.add("module_id");	//name of field
firstItem11.add("5");	// SIZE
firstItem11.add("2");	//LENGTH
finAr.add(firstItem11);//add to ArrayList obj finAr

ArrayList firstItem12 = new ArrayList();
firstItem12.add("Text");  		 //Type of item
firstItem12.add("TRN Type");	  // label
firstItem12.add("trn_type");	//name of field
firstItem12.add("5");	// SIZE
firstItem12.add("3");	//LENGTH

finAr.add(firstItem12);//add to ArrayList obj finAr */

ArrayList firstItem = new ArrayList();
String Code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
firstItem.add("Text");  		 //Type of item
firstItem.add(Code);	  // label
firstItem.add("trn_remarks_code");	//name of field
firstItem.add("10");	// SIZE
firstItem.add("10");	//LENGTH

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
String Remarks = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.remarks.label","common_labels");
secondItem.add("Text");  //Type of item
secondItem.add(Remarks);  // label
secondItem.add("remarks_desc");   //name of field
secondItem.add("20");	// SIZE
secondItem.add("200");	//LENGTH

finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
String Nature = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
String Enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
String Disabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
String Nature_List="%,"+Both_legend+",E,"+Enabled_legend+",D,"+Disabled_legend;
thirdItem.add("List");  //Type of item
thirdItem.add(Nature);  // label
thirdItem.add("nature");   //name of field
thirdItem.add(Nature_List);//static values that need to be displayed as option.Send it along with the value that is inserted.
thirdItem.add("4");	//LENGTH

finAr.add(thirdItem); //add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
//Type of item
fourthItem.add("Hidden");  // label
fourthItem.add("function_id");   //name of field
fourthItem.add(function_id);//static values that need to be displayed as option.Send it along with the value that is inserted.
	//LENGTH

finAr.add(fourthItem); //add to ArrayList obj finAr

/*

	For Enhancement ie to include Module ID and TRN Type please uncomment all the comments labeled by For Enhancement after 10/27/2004
	and increase the array length to 4.. see the next statement. for array size..

*/

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];
String TransactionRemarksCode = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.TransactionRemarksCode.label","mm_labels");
String TransactionRemarksDesc =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMM.TRNRemarksDescription.label","mm_labels");
orderByCols[0] = TransactionRemarksCode;
orderByCols[1] = TransactionRemarksDesc;

/* For Enhancement after 10/27/2004
orderByCols[2] = "Module ID";
orderByCols[3] = "TRN Type"; */

orderByColVals[0] = "trn_remarks_code";
orderByColVals[1] = "remarks_desc";

String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
/*For Enhancement after 10/27/2004
orderByColVals[2] = "module_id";
orderByColVals[3] = "trn_type";*/

strbuff = qrypg.getQueryPage(null,finAr,TransactionRemarksCode,"TrnRemarksQueryResult.jsp",Sort_order,QueryCriteria,defaultSelect,orderBy,orderByCols, orderByColVals,ExecuteQuery);
out.println(strbuff.toString());

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
