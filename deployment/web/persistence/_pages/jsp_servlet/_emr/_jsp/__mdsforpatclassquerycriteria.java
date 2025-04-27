package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.ConnectionManager;
import java.sql.*;
import java.util.ArrayList;

public final class __mdsforpatclassquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/MDSForPatClassQueryCriteria.jsp", 1709118943501L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n   ";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\'></link>\n\t";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<!--Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013-->\n\t<script>\n\tdocument.forms[0].mds_code.remove(0);\n  \t</script>\n";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
String sStyle	=
   (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block7Bytes, _wl_block7);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block8Bytes, _wl_block8);

		try
		{
			request.setCharacterEncoding("UTF-8");
			Connection conn	= null;
			Statement stmt	= null;
			conn = ConnectionManager.getConnection(request);	
			stmt = conn.createStatement();
			
			ArrayList MDSforpat = new ArrayList();
   	        ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
			StringBuffer strbuff;

			ArrayList firstItem = new ArrayList();
			firstItem.add("List");//type of item 
			firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MDS.label","mr_labels")); //label
			firstItem.add("mds_code");//fields
			firstItem.add("select mds_code,short_desc from mr_mds where eff_status = 'E' order by short_desc");
			MDSforpat.add(firstItem);
			//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//Start
			ArrayList ThirdItem = new ArrayList();
			ThirdItem.add("Text");  		 //Type of item
			ThirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  // label
			ThirdItem.add("mds_sub_code");	//name of field
			ThirdItem.add("10");	// SIZE
			ThirdItem.add("10");	//LENGTH
			MDSforpat.add(ThirdItem);//add to ArrayList obj finAr
			
			ArrayList FifthItem = new ArrayList();
			FifthItem.add("Text");  		 //Type of item
			FifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
			FifthItem.add("mds_sub_desc");	//name of field
			FifthItem.add("20");	// SIZE
			FifthItem.add("20");	//LENGTH
			MDSforpat.add(FifthItem);//add to ArrayList obj finAr
			//End

		/*	ArrayList fourthItem = new ArrayList();
			fourthItem.add("List");//type of item 
			fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.TerminologySet.label","common_labels"));
			fourthItem.add("term_set_id");//fields
			fourthItem.add("select term_set_id,term_set_desc from mr_term_set where eff_status = 'E' and diag_spec_yn='Y'  order by term_set_id");
			MDSforpat.add(fourthItem);*/

			ArrayList secondItem = new ArrayList();
			secondItem.add("List");
			secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientclass.label","common_labels"));
			secondItem.add("patient_class");
			secondItem.add("ALL,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",IP,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.inpatient.label","common_labels")+",OP,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Outpatient.label","common_labels")+",EM,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.emergency.label","common_labels")+",DC,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.daycare.label","common_labels")+"");
			MDSforpat.add(secondItem);

			String orderByCols[] = new String[2];
			String orderByColVals[] = new String[2];
			orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");//+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");

			orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
			//Maheshwaran K added for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			orderByColVals[0] = "mds_sub_code";
			orderByColVals[1] = "mds_sub_desc";
			
			
			strbuff = qrypg.getQueryPage(conn,MDSforpat,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.MDSforPatClass.label","mr_labels"),"../jsp/MDSForPatClassQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

			out.println(strbuff.toString());

			if ( firstItem != null ) firstItem.clear(); 
			//Maheshwaran K modified for the CRF: JD-CRF-0145 [IN:030011] as on 05/12/2013
			//Start
			if ( ThirdItem != null ) ThirdItem.clear(); 
			if ( FifthItem != null ) FifthItem.clear(); 
			//End
			if ( secondItem != null ) secondItem.clear(); 
			//if ( fourthItem != null ) fourthItem.clear();
			if ( MDSforpat != null ) MDSforpat.clear(); 
			if(stmt != null) stmt.close();
			if(conn!=null) ConnectionManager.returnConnection(conn,request);

		}catch(Exception e)
		{
			//out.println(e.toString());
			e.printStackTrace();

		}
		finally
		{
			
		}
	
            _bw.write(_wl_block9Bytes, _wl_block9);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
