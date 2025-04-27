package jsp_servlet._emr._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eMR.*;
import eCommon.Common.*;
import com.ehis.eslp.*;

public final class __querydiagnosisclassification extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emr/jsp/QueryDiagnosisClassification.jsp", 1709117066530L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � iSoft Solutions (P) Ltd. \n*\tCreated By\t\t:\tS.V.Narayana \n*\tCreated On\t\t:\t12 aug 2008\n-->\n\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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

String sStyle	= (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);


try
{
	request.setCharacterEncoding("UTF-8");
	String locale=(String)session.getAttribute("LOCALE");
	Connection conn=null ;
	conn = ConnectionManager.getConnection(request);

	ArrayList Terminologyvalues = new ArrayList();
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  	
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));	  
	firstItem.add("DIAG_CLASS_CODE");	
	firstItem.add("10"); 
	firstItem.add("10"); 
	Terminologyvalues.add(firstItem); 

	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));
	secondItem.add("LONG_DESC");
	secondItem.add("30"); 
	secondItem.add("60");  
	Terminologyvalues.add(secondItem); 

	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");  
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.type.label","common_labels"));  
	thirdItem.add("DIAG_CLASS_TYPE");
	String term_set ="SELECT diag_class_type,description FROM   MR_DIAG_CLASS_TYPE_LANG_VW where LANGUAGE_ID = '"+locale+"' and  EFF_STATUS = 'E' ORDER BY 2";
	PreparedStatement stmt =conn.prepareStatement(term_set);
	ResultSet rset = stmt.executeQuery();
	StringBuffer  a = new StringBuffer("'',------- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" -------,");
	while(rset!=null  && rset.next())
	{
		a.append(rset.getString(1)+","+rset.getString(2)+",");	
	}
	thirdItem.add(a.toString());
	if ( rset != null) rset.close();
	if ( stmt != null) stmt.close();
	Terminologyvalues.add(thirdItem); 

/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
/*Start*/
ArrayList fourthItem = new ArrayList();
fourthItem.add("List"); 
fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DefaultPrincipalDiagClassification.label","mr_labels"));  
fourthItem.add("Default");   
fourthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
fourthItem.add("4");
Terminologyvalues.add(fourthItem);
/*End*/

ArrayList fifthItem = new ArrayList();
fifthItem.add("List"); 
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  
fifthItem.add("nature");   
fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
fifthItem.add("4");
Terminologyvalues.add(fifthItem);


	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];

	
	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	


	orderByColVals[0] = "DIAG_CLASS_CODE";
	orderByColVals[1] = "LONG_DESC";
	//orderByColVals[2] = "DIAG_CLASS_TYPE";
	//orderByColVals[3] = "nature";


	
	strbuff = qrypg.getQueryPage(conn,Terminologyvalues,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMR.DiagnosisClassification.label","mr_labels"),"../jsp/DiagnosisClassificationResult.jsp", com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols,orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	/*Added by Maheshwaran K for the SKR-CRF-0020 as on 07/05/2012*/
	/*Start*/
	fourthItem.clear();
	/*End*/
	fifthItem.clear();
	
	Terminologyvalues.clear();
	if ( conn != null ) ConnectionManager.returnConnection(conn,request);
}
catch (Exception e) 
{
	//out.println(e.toString());
	e.printStackTrace();
}

finally
{
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
