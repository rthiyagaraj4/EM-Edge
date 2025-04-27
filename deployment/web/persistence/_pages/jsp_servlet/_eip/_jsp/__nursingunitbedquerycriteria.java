package jsp_servlet._eip._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;

public final class __nursingunitbedquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eip/jsp/NursingUnitBedQueryCriteria.jsp", 1720506740310L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 =" \n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\n\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

	// By Annadurai 2/23/2004 starts., to handle NullPointerException.
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
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block0Bytes, _wl_block0);
 String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con = null;
try
{
	con=ConnectionManager.getConnection(request);
	
	  boolean isCensusBedApplicable		= eCommon.Common.CommonBean.isSiteSpecific(con, "IP","CENSUS_BED");  //Added by Mano CRF-GHL-418
		
	
ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  					//Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels"));			// label
	firstItem.add("nursing_unit_code");			//name of field
	firstItem.add("4");							// SIZE
	firstItem.add("4");							//LENGTH
finAr.add(firstItem);							//add to ArrayList obj finAr

ArrayList secondItem=new ArrayList();
	secondItem.add("Text");						//Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels"));		// label
	secondItem.add("nursing_short_desc");		//name of field
	secondItem.add("15");						// SIZE
	secondItem.add("15");						//LENGTH
finAr.add(secondItem);							//add to ArrayList obj finAr

ArrayList thirdItem=new ArrayList();
	thirdItem.add("Text");						//Type of item
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedClassCode.label","ip_labels"));			// label
	thirdItem.add("bed_class_code");			//name of field
	thirdItem.add("2");							// SIZE
	thirdItem.add("2");							//LENGTH
finAr.add(thirdItem);							//add to ArrayList obj finAr

ArrayList fourthItem=new ArrayList();
	fourthItem.add("Text");						//Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));			// label
	fourthItem.add("bed_class_short_desc");		//name of field
	fourthItem.add("15");						// SIZE
	fourthItem.add("15");						//LENGTH
finAr.add(fourthItem);							//add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();
	fifthItem.add("Text");			//Type of item
	fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels"));  // label
	fifthItem.add("bed_type_code");   //name of field
	fifthItem.add("2");				// SIZE
	fifthItem.add("2");				//LENGTH
finAr.add(fifthItem);				//add to ArrayList obj finAr

ArrayList fifthItem1=new ArrayList();
	fifthItem1.add("Text");			//Type of item
	fifthItem1.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels"));  // label
	fifthItem1.add("bed_type_short_desc");   //name of field
	fifthItem1.add("15");			// SIZE
	fifthItem1.add("15");			//LENGTH
finAr.add(fifthItem1);				//add to ArrayList obj finAr

ArrayList sixthItem=new ArrayList();
	sixthItem.add("Text");			//Type of item
	sixthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels"));  // label
	sixthItem.add("room");			//name of field
	sixthItem.add("10");				// SIZE
	sixthItem.add("10");				//LENGTH
finAr.add(sixthItem);				//add to ArrayList obj finAr

ArrayList seventhItem=new ArrayList();
	seventhItem.add("Text");		//Type of item
	seventhItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels"));		// label
	seventhItem.add("bed_no");		//name of field
	seventhItem.add("8");			// SIZE
	seventhItem.add("8");			//LENGTH
finAr.add(seventhItem);				//add to ArrayList obj finAr

ArrayList eigthItem=new ArrayList();
	eigthItem.add("List");			//Type of item
	eigthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));		// label
	eigthItem.add("eff_status");	//name of field
	eigthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E, "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
finAr.add(eigthItem);				//add to ArrayList obj finAr

// Added by mano CRF-418

if(isCensusBedApplicable)
{
ArrayList ninthItem=new ArrayList();  //Added by Mano CRF-GHL-418
    ninthItem.add("List");     
	ninthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CensusBed.label","common_labels"));
	ninthItem.add("census_bed_yn");
	ninthItem.add("B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",Y,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels"));
finAr.add(ninthItem);           //add to ArrayList obj finAr
}
// End of CRF-418

	/*String orderByCols[] = new String[8];
	String orderByColVals[] = new String[8]; */
	int orderCount	= 8;
	if(isCensusBedApplicable){
		orderCount = 9;
	}

	String orderByCols[] = new String[orderCount];
	String orderByColVals[] = new String[orderCount];
	
	

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.NursingUnitCode.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.NursingUnitDescription.label","ip_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.BedClassCode.label","ip_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.BedClass.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
	orderByCols[5] =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedtype.label","common_labels")+" "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
	orderByCols[6] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.roomcubicleno.label","common_labels");
	orderByCols[7] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.bedno.label","common_labels");
	if(isCensusBedApplicable)
	{
	
	orderByCols[8] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.CensusBed.label","ip_labels");// Added by Mano CRF-GHL-418
	}
	orderByColVals[0] = "nursing_unit_code";
	orderByColVals[1] = "nursing_unit_short_desc";
	orderByColVals[2] = "bed_class_code";
	orderByColVals[3] = "bed_class_short_desc";
	orderByColVals[4] = "bed_type_code";
	orderByColVals[5] = "bed_type_short_desc";
	orderByColVals[6] = "room_no";
	orderByColVals[7] = "bed_no";
	if(isCensusBedApplicable)
	{
	orderByColVals[8] = "census_bed_yn";// Added By Mano CRF-GHL-418
	}

	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"Nursing Unit Bed","../jsp/NursingUnitBedQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString().replace("nowrap",""));
	}
	catch(Exception e)
	{
		out.println(e.toString());
	}
	finally 
	{
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block0Bytes, _wl_block0);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
