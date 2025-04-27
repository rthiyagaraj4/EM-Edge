package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCP.*;
import eCommon.Common.*;

public final class __frequencyforinterventionquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/FrequencyForInterventionQueryCriteria.jsp", 1709116521779L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\'href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n\n\n<body style=\"overflow-y:hidden\">\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

	public static String checkForNull(String inputString)
	{
		return((inputString == null) ? "" : inputString);
	}

	public static String checkForNull(String inputString, String defaultValue)
	{
		return((inputString == null) ? defaultValue : inputString);
	}


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
 String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

//This file is saved on 18/10/2005.
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff = new StringBuffer();
	String intvn_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionCode.label","cp_labels");
	String intvn_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.InterventionDescription.label","cp_labels");
	String FrequencyForIntervention=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eCP.FrequencyForIntervention.label","cp_labels");
	String freq_code = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyCode.label","common_labels");
	String freq_desc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.FrequencyDescription.label","common_labels");
	String Sort_order = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
	String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
	String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
	String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
	String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");
	try {
		ArrayList finAr = new ArrayList();

		//================= populating the second item in the firstitem object
		ArrayList firstItem=new ArrayList();
		firstItem.add("Text");								//	Type of item
		firstItem.add(freq_code);				    //	Label
		firstItem.add("frequency_code");				    //	Name of field
		firstItem.add("4");								    //	.SIZE
		firstItem.add("4");								    //   Length
		finAr.add(firstItem);							    //	Add to ArrayList obj finAr

		//================= populating the third item in the secondItem object
		ArrayList secondItem=new ArrayList();
		secondItem.add("Text");								       //	Type of item
		secondItem.add(freq_desc);		           //	Label
		secondItem.add("frequency_desc");						           //	Name of field
		secondItem.add("20");								               //	SIZE
		secondItem.add("20");												//	LENGTH
		finAr.add(secondItem);											//	Add to ArrayList obj finAr

		//================= populating the fourth item in the firstitem object
		ArrayList thirdItem=new ArrayList();
		thirdItem.add("Text");								       //	Type of item
		thirdItem.add(intvn_code);		           //	Label
		thirdItem.add("intervention_code");			//	Name of field
		thirdItem.add("10");
		thirdItem.add("10");								               //	SIZE
		finAr.add(thirdItem);											//	Add to ArrayList obj finAr


		//================= populating the fifth item in the firstitem object
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("Text");   //Type of item
		fourthItem.add(intvn_desc);  // Label
		fourthItem.add("short_desc");//Name
		fourthItem.add("60");
		fourthItem.add("60");
	
		finAr.add(fourthItem); //add to ArrayList obj finAr
        //=====================================================================
		
		String orderByCols[] = new String[4];
		String orderByColVals[] = new String[4];

		orderByCols[0] = freq_code;
		orderByCols[1] = freq_desc;
		orderByCols[2]	=intvn_code;
		orderByCols[3]	=intvn_desc;


		orderByColVals[0] = "freq_code";
		orderByColVals[1] = "freq_desc";
    	orderByColVals[2] = "intervention_code";
		orderByColVals[3] = "short_desc";

		strbuff = qrypg.getQueryPage(null, finAr, FrequencyForIntervention, "FrequencyForInterventionQueryResult.jsp", Sort_order, QueryCriteria, defaultSelect, orderBy, orderByCols, orderByColVals, ExecuteQuery);

		out.println(strbuff.toString());
	}
	catch (Exception e) {
	//	out.println( "main " + e );//COMMON-ICN-0181
                e.printStackTrace();//COMMON-ICN-0181
	}

            _bw.write(_wl_block4Bytes, _wl_block4);
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
