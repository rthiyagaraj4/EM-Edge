package jsp_servlet._emp._jsp;

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

public final class __querypagepatientnumber extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/emp/jsp/queryPagePatientNumber.jsp", 1709117020657L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n\n<link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
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
 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
String accept_national_id_no_yn = "N";
Connection con=null ;
PreparedStatement pstmt=null;
ResultSet rs=null;
try
{
con = ConnectionManager.getConnection(request);
pstmt = con.prepareStatement("select accept_national_id_no_yn from mp_param");
		rs= pstmt.executeQuery();
		if(rs.next())
		{
		accept_national_id_no_yn=rs.getString("accept_national_id_no_yn");
		}
if(accept_national_id_no_yn==null)
	accept_national_id_no_yn="N";

//Added by Sangeetha for ML-MMOH-CRF-0732 
Boolean increase_leng_pat_series	= CommonBean.isSiteSpecific(con, "MP","INCREASE_LENGTH_PAT_SERIES");

ArrayList finAr = new ArrayList();
ArrayList firstItem = new ArrayList();

firstItem.add("Text");  		 //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels"));	  // label
firstItem.add("pat_ser_grp_code");	//name of field
firstItem.add("2");	// SIZE
if(increase_leng_pat_series)  //Added by Sangeetha for ML-MMOH-CRF-0732 
firstItem.add("3");	//LENGTH
else
firstItem.add("2");

finAr.add(firstItem);//add to ArrayList obj finAr

ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels"));	  // label
secondItem.add("long_desc");	//name of field
secondItem.add("30");	// SIZE
secondItem.add("30");	//LENGTH

finAr.add(secondItem);//add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("List");   		
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.SeriesType.label","mp_labels"));  	
thirdItem.add("id_type");	

if(accept_national_id_no_yn.equals("Y"))
{
thirdItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+",G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels")+",N,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NationalIDSeries.label","mp_labels"));
}
else if(accept_national_id_no_yn.equals("N"))
{
thirdItem.add("'',"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels")+",A,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.AlternateIDSeries.label","mp_labels")+",B,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.NewBornSeries.label","mp_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.EmergencySeries.label","mp_labels")+",G,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.GeneralSeries.label","mp_labels")+",U,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.UnrestrictedSeries.label","mp_labels")+",X,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalSourceSeries.label","mp_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.ExternalPatientDonorSeries.label","mp_labels"));
}

finAr.add(thirdItem); 	

String orderByCols[] = new String[2];
String orderByColVals[] = new String[2];


orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeriesCode.label","mp_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSerieDesc.label","mp_labels");

orderByColVals[0] = "pat_ser_grp_code";
orderByColVals[1] = "short_desc";

strbuff = qrypg.getQueryPage(con,finAr,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eMP.PatientSeries.label","mp_labels"),"../jsp/queryPatientNumber.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
}
catch (Exception e) {
	e.printStackTrace();
	//out.println(e.toString());
	}
finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block2Bytes, _wl_block2);
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
