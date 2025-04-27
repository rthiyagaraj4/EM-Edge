package jsp_servlet._ebl._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import java.text.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __blpatregblngdtlsquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ebl/jsp/BLPatRegBlngDtlsQueryCriteria.jsp", 1709114109771L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n    <html><head>\n   ";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n \n\t<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
request.setCharacterEncoding("UTF-8");


            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);
 
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con		= null ;
String pat_ser_grp_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels");
String pat_ser_grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels");

String blng_grp_id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BillingGroup.label","common_labels");
String blng_grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BLNG_GRP_DESC.label","bl_labels");

String payer_grp_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_CODE.label","bl_labels");
String payer_grp_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_DESC.label","bl_labels");

String payer_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_CODE.label","bl_labels");
String payer_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_DESC.label","bl_labels");

String serv_panel_ind =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BILLING_SERVICE_PANEL.label","bl_labels"); 
String serv_panel_code=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_CODE.label","bl_labels");
String serv_panel_desc=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_DESC.label","bl_labels");

try 
{ 
	con				= ConnectionManager.getConnection(request);
	ArrayList finAr 	= new ArrayList();

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		//Type of item
	firstItem.add(pat_ser_grp_code);		//label
	firstItem.add("pat_ser_grp_code");		//name of field
	firstItem.add("2");				// SIZE
	firstItem.add("2");			    //LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem	= new ArrayList();
	secondItem.add("Text");  //Type of item
	secondItem.add(pat_ser_grp_desc);  // label
	secondItem.add("pat_ser_grp_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList thirdItem	= new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BillingGroup.label","common_labels"));  // label
	thirdItem.add("blng_grp_id");   //name of field
	thirdItem.add("4");	// SIZE
	thirdItem.add("4");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList forthItem	= new ArrayList();

	forthItem.add("Text");  //Type of item
	forthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BLNG_GRP_DESC.label","bl_labels"));  // label
	forthItem.add("blng_grp_desc");   //name of field
	forthItem.add("40");	// SIZE
	forthItem.add("40");	//LENGTH

	finAr.add(forthItem); //add to ArrayList obj finAr

    ArrayList fifthItem	= new ArrayList();
	fifthItem.add("Text");  //Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_CODE.label","bl_labels"));  // label
	fifthItem.add("payer_grp_code");   //name of field
	fifthItem.add("2");	// SIZE
	fifthItem.add("2");	//LENGTH

	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem	 = new ArrayList();
	sixthItem.add("Text");  //Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_GROUP_DESC.label","bl_labels"));  // label
	sixthItem.add("payer_grp_desc");   //name of field
	sixthItem.add("15");	// SIZE
	sixthItem.add("15");	//LENGTH

	finAr.add(sixthItem); //add to ArrayList obj finAr

    ArrayList seventhItem	= new ArrayList();
	seventhItem.add("Text");  //Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_CODE.label","bl_labels"));  // label
	seventhItem.add("payer_code");   //name of field
	seventhItem.add("8");	// SIZE
	seventhItem.add("8");	//LENGTH

	finAr.add(seventhItem); //add to ArrayList obj finAr

	ArrayList eighthItem	 = new ArrayList();
	eighthItem.add("Text");  //Type of item
	eighthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.PAYER_DESC.label","bl_labels"));  // label
	eighthItem.add("payer_desc");   //name of field
	eighthItem.add("40");	// SIZE
	eighthItem.add("40");	//LENGTH

	finAr.add(eighthItem); //add to ArrayList obj finAr

	ArrayList ninthItem	 = new ArrayList();
	ninthItem.add("List");  //Type of item
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.BILLING_SERVICE_PANEL.label","ae_labels"));  // label
	ninthItem.add("serv_panel_ind"); //name  of field
	ninthItem.add("S,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.service.label","common_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Panel.label","common_labels"));//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(ninthItem); //add to ArrayList obj finAr

	ArrayList tenthItem	 = new ArrayList();
	tenthItem.add("Text");  //Type of item
	tenthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_CODE.label","bl_labels"));  // label
	tenthItem.add("serv_panel_code");   //name of field
	tenthItem.add("10");	// SIZE
	tenthItem.add("10");	//LENGTH

	finAr.add(tenthItem); //add to ArrayList obj finAr

	ArrayList eleventhItem	 = new ArrayList();
	eleventhItem.add("Text");  //Type of item
	eleventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eBL.SERV_PANEL_DESC.label","bl_labels"));  // label
	eleventhItem.add("serv_panel_desc");   //name of field
	eleventhItem.add("40");	// SIZE
	eleventhItem.add("40");	//LENGTH

	finAr.add(eleventhItem); //add to ArrayList obj finAr

	String orderByCols[] 	= new String[11];
	String orderByColVals[] = new String[11];

	orderByCols[0] 		 = pat_ser_grp_code;
	orderByCols[1]		 = pat_ser_grp_desc;
	orderByCols[2] 		 = blng_grp_id;
	orderByCols[3]		 = blng_grp_desc;
	orderByCols[4] 		 = payer_grp_code;
	orderByCols[5]		 = payer_grp_desc;
	orderByCols[6] 		 = payer_code;
	orderByCols[7]		 = payer_desc;
	orderByCols[8]		 = serv_panel_ind;
	orderByCols[9] 		 = serv_panel_code;
	orderByCols[10]		 = serv_panel_desc;
	orderByColVals[0] 	 = "pat_ser_grp_code";
	orderByColVals[1] 	 = "pat_ser_grp_desc";
	orderByColVals[2] 	 = "blng_grp_id";
	orderByColVals[3] 	 = "blng_grp_desc";
	orderByColVals[4] 	 = "payer_grp_code";
	orderByColVals[5] 	 = "payer_grp_desc";
	orderByColVals[6] 	 = "payer_code";
	orderByColVals[7] 	 = "payer_desc";
	orderByColVals[8] 	 = "serv_panel_ind";
	orderByColVals[9] 	 = "serv_panel_code";
	orderByColVals[10] 	 = "serv_panel_desc";

	strbuff = qrypg.getQueryPage(con,finAr,"Find Site" ,"../../eBL/jsp/BLPatRegBlngDtlsQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
	out.println(strbuff.toString());
	strbuff.setLength(0);
	if(finAr!=null)finAr.clear();
	if(firstItem!=null)firstItem.clear();
	if(secondItem!=null)secondItem.clear();
	if(thirdItem!=null)thirdItem.clear();
	if(forthItem!=null)forthItem.clear();
	if(fifthItem!=null)fifthItem.clear();
	if(sixthItem!=null)sixthItem.clear();
	if(seventhItem!=null)seventhItem.clear();
	if(eighthItem!=null)eighthItem.clear();
	if(ninthItem!=null)ninthItem.clear();
	if(tenthItem!=null)tenthItem.clear();
	if(eleventhItem!=null)eleventhItem.clear();
	
}catch (Exception e)  {
	//out.println("Error  :"+e.toString());
	e.printStackTrace();
}
finally
	{
		 if(con != null)
		 ConnectionManager.returnConnection(con,request);
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
