package jsp_servlet._eam._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __dispositiontypequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eam/jsp/DispositionTypeQueryCriteria.jsp", 1709113997851L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\t<Script Language=\"JavaScript\" src=\"../../eCommon/js/common.js\"></Script><script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n</html></head>\n";
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

/*
*
*	Application		:	eAM
*   File Name       :	DispositionTypeQueryCriteria.jsp
*	
*
*	Created On		:	19-02-2005
*/

            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

	request.setCharacterEncoding("UTF-8");
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	Connection con=null ; 
	Connection conn=null ; //Added by Mano aganist ML-MMOH-CRF-0783
	Boolean isDidCallNotAroundDgnNotAppl; //Added by Mano aganist ML-MMOH-CRF-0783

	try 
	{
		con = (Connection) session.getValue( "connection" );
		conn = ConnectionManager.getConnection(request);
		isDidCallNotAroundDgnNotAppl = CommonBean.isSiteSpecific(conn, "AE", "DID_CALLNOTAROUND_NOT_REQ_DGN"); //Added by Mano aganist ML-MMOH-CRF-0783

	ArrayList finAr = new ArrayList();

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 // Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels"));	 // label
	firstItem.add("disp_type");	//name of field
	firstItem.add("2");	// SIZE
	firstItem.add("2");	// LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem = new ArrayList();

	secondItem.add("Text");  		 //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));	  // label
	secondItem.add("short_desc");	//name of field
	secondItem.add("30");	// SIZE
	secondItem.add("30");	// LENGTH

	finAr.add(secondItem);//add to ArrayList obj finAr

	ArrayList thirdItem = new ArrayList();

	thirdItem.add("List");  		 //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.DeceasedIndicator.label","am_labels"));	  // label
	thirdItem.add("deceased_yn");	//name of field
	thirdItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(thirdItem);//add to ArrayList obj finAr

	//Added by Sangeetha for ML-MMOH-CRF-0630
	ArrayList seventhItem = new ArrayList();

	seventhItem.add("List");  		 //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.AbscondedIndicator.label","am_labels"));	  // label
	seventhItem.add("absconded_indicator");	//name of field
	seventhItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(seventhItem);//add to ArrayList obj finAr
	
	//Added by Mano aganist ML-MMOH-CRF-0783
	
	if(isDidCallNotAroundDgnNotAppl)
	{
	ArrayList eightItem = new ArrayList();

	eightItem.add("List");  		 //Type of item
	eightItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.CallNotAroundIndicator.label","am_labels"));	  // label
	eightItem.add("callnotaround_yn");	//name of field
	eightItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(eightItem);//add to ArrayList obj finAr
    }
	ArrayList forthItem = new ArrayList();

	forthItem.add("List");  		 //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseatVisitConclusion.label","am_labels"));	  // label
	forthItem.add("use_at_concl_yn");	//name of field
	forthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.

	finAr.add(forthItem);//add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAM.UseforMaternalDeath.label","am_labels"));  // label
	fifthItem.add("use_at_disch_yn");//name
	fifthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	
	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem = new ArrayList();

	sixthItem.add("List");   //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
	sixthItem.add("eff_status");//name
	sixthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	
	finAr.add(sixthItem); //add to ArrayList obj finAr
	
	String orderByCols[] = new String[2];
	String orderByColVals[] = new String[2];


	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DispType.label","common_labels")+""+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");

	orderByColVals[0] = "disp_type";
	orderByColVals[1] = "long_desc";
	
	strbuff = qrypg.getQueryPage(con,finAr,"Find Disposition Type","../../eAM/jsp/DispositionTypeQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());

	firstItem.clear();
	secondItem.clear();
	thirdItem.clear();
	forthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();
	finAr.clear();
	} 
	catch (Exception e) {
		
	} finally{
		if(conn != null) 
		ConnectionManager.returnConnection(conn,request);
		if(con != null)  ConnectionManager.returnConnection(con,request);//Added for check style for COMMON-ICN-0056
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
