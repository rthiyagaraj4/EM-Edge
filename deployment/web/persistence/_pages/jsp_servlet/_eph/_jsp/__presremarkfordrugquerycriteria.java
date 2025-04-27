package jsp_servlet._eph._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import eMM.*;
import eMM.Common.*;
import eCommon.Common.*;
import eCommon.XSSRequestWrapper;
import java.util.*;
import com.ehis.util.*;

public final class __presremarkfordrugquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eph/jsp/PresRemarkForDrugQueryCriteria.jsp", 1709117386163L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\'\n\thref=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n</head>\n</html>\n\n";
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

	//@ include file="../../eCommon/jsp/GetPersistenceBean.jsp"

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
//added By Himanshu for COMMON-ICN-0182 on 17/10/2023 Start.
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0080
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0086
//end.
	String locale = (String) session.getAttribute("LOCALE");
	//	
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE")
			: "IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	try {
		ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

		String function_id = request.getParameter("function_id");
		StringBuffer strbuff = new StringBuffer();
		ArrayList finAr = new ArrayList();

		ArrayList secondItem = new ArrayList();
		ArrayList thirdItem = new ArrayList();
		ArrayList fourthItem = new ArrayList();
		ArrayList fifthItem = new ArrayList();
		String RemarkCode = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext, "ePH.RemarkCode.label",
						"ph_labels");

		String RemarkDescription = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"ePH.RemarkDescription.label", "ph_labels");
		secondItem.add("Text"); //Type of item
		secondItem.add(RemarkDescription); // label
		//secondItem.add("remarks_desc"); //name of field
		secondItem.add(java.net.URLEncoder.encode("remarks_desc","UTF-8")); //name of field
		
		secondItem.add("20"); // SIZE
		secondItem.add("20"); //LENGTH
		finAr.add(secondItem); //add to ArrayList obj finAr

		String DrugCode = com.ehis.util.BundleMessage.getBundleMessage(
				pageContext, "Common.DrugCode.label", "common_labels");

		thirdItem.add("Text"); //Type of item
		thirdItem.add(DrugCode); // label
		thirdItem.add("drug_code"); //name of field
		thirdItem.add("20"); // SIZE
		thirdItem.add("20");
		finAr.add(thirdItem);

		String DrugDescription = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"ePH.DrugDescription.label", "ph_labels");
		fourthItem.add("Text"); //Type of item
		fourthItem.add(DrugDescription); // label
		fourthItem.add("drug_desc"); //name of field
		
		fourthItem.add("20"); // SIZE
		fourthItem.add("20"); //LENGTH
		finAr.add(fourthItem); //add to ArrayList obj finAr

		String Form = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"ePH.Form.label","ph_labels");
		fifthItem.add("Text"); //Type of item
		fifthItem.add(Form); // label
		fifthItem.add("form_desc"); //name of field
		fifthItem.add("20"); // SIZE
		fifthItem.add("20"); //LENGTH
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList items = new ArrayList();
		items.add("Hidden");
		items.add("function_id");
		items.add(function_id);
		finAr.add(items);

		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = Form;
		orderByCols[1] = DrugDescription;
		orderByCols[2] = RemarkDescription;
		orderByCols[3] = DrugCode;

		orderByColVals[0] = "form_desc";
		orderByColVals[1] = "DRUG_DESC";
		orderByColVals[2] = "REMARK_DESC";
		orderByColVals[3] = "DRUG_CODE";

		

		String Sort_order = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.SortOrder.label", "common_labels");

		String defaultSelect = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.defaultSelect.label", "common_labels");

		String orderBy = com.ehis.util.BundleMessage.getBundleMessage(
				pageContext, "Common.orderBy.label", "common_labels");

		String QueryCriteria = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.QueryCriteria.label", "common_labels");

		String ExecuteQuery = com.ehis.util.BundleMessage
				.getBundleMessage(pageContext,
						"Common.ExecuteQuery.label", "common_labels");

		strbuff = qrypg.getQueryPage(null, finAr, Form,
				"PresRemarkForDrugQueryResult.jsp", Sort_order,
				QueryCriteria, defaultSelect, orderBy, orderByCols,
				orderByColVals, ExecuteQuery, true);

		out.println(strbuff.toString());
	} catch (java.lang.Exception exception) {
		out.println(exception.toString());
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
