package jsp_servlet._esm._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import java.util.*;
import com.ehis.util.*;

public final class __maintainacctperiodquery extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/esm/jsp/MaintainAcctPeriodQuery.jsp", 1709117458118L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n      <html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></head><html>";
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

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
request.setCharacterEncoding("UTF-8");
ArrayList finAr = new ArrayList();
String acc_per_year1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodYear.label","sm_labels");
	ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(acc_per_year1);
		firstItem.add("acc_per_year");	//name of field
		firstItem.add("5");	// SIZE
		firstItem.add("4");	//LENGTH
	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();
	String acc_per_month1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodMonth.label","sm_labels");
		secondItem.add("Text");  //Type of item
		secondItem.add(acc_per_month1); 
		secondItem.add("acc_per_month");   //name of field
		secondItem.add("5");	// SIZE
		secondItem.add("2");	//LENGTH
	finAr.add(secondItem); //add to ArrayList obj finAr

ArrayList third_item=new ArrayList();
String acc_per_start_date1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodSdate.label","sm_labels");
		third_item.add("Date");  //Type of item
		third_item.add(acc_per_start_date1); 
		third_item.add("acc_per_start_date");   //name of field
		third_item.add("10");	// SIZE
		third_item.add("10");	//LENGTH
	finAr.add(third_item); //add to ArrayList obj finAr

	ArrayList fourth_item=new ArrayList();
String acc_per_end_date1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.AccountPeriodEdate.label","sm_labels");
		fourth_item.add("Date");  //Type of item
		fourth_item.add(acc_per_end_date1);
		fourth_item.add("acc_per_end_date");   //name of field
		fourth_item.add("10");	// SIZE
		fourth_item.add("10");	//LENGTH
	finAr.add(fourth_item); //add to ArrayList obj finAr

ArrayList fifthItem=new ArrayList();
String acc_cal_year1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.CalenderYear.label","sm_labels");
		fifthItem.add("Text");  //Type of item
		fifthItem.add(acc_cal_year1); 
		fifthItem.add("acc_cal_year");   //name of field
		//fifthItem.add("CAL_PER_YEAR");
		fifthItem.add("6");	// SIZE
		fifthItem.add("4");	//LENGTH
	finAr.add(fifthItem); //add to ArrayList obj //finAr


ArrayList sixItem=new ArrayList();
String acc_cal_month1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eSM.CalenderMonth.label","sm_labels");
		sixItem.add("Text");  //Type of item
		sixItem.add(acc_cal_month1); 
		sixItem.add("acc_cal_month");   //name of field
		//sixItem.add("CAL_PER_MONTH");
		sixItem.add("4");	// SIZE
		sixItem.add("2");	//LENGTH
	finAr.add(sixItem); //add to ArrayList obj finAr



String orderByCols[] = new String[6];
String orderByColVals[] = new String[6];

orderByCols[0] =acc_per_year1;
orderByCols[1] =acc_per_month1;
orderByCols[2] =acc_per_start_date1;
orderByCols[3] =acc_per_end_date1;
orderByCols[4] =acc_cal_year1;
orderByCols[5] =acc_cal_month1;

orderByColVals[0] = "acc_per_year";
orderByColVals[1] = "acc_per_month";
orderByColVals[2] = "acc_per_start_date";
orderByColVals[3] = "acc_per_end_date";
orderByColVals[4] = "acc_cal_year";
orderByColVals[5] = "acc_cal_month";
//orderByColVals[4] = "cal_per_year";
//orderByColVals[5] = "cal_per_month";



strbuff = qrypg.getQueryPage(con,finAr,"Menu Admin","../../eSM/jsp/MaintainAcctPeriodResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,"Execute Query");
out.println(strbuff.toString());

        strbuff.setLength(0);
		finAr.clear();
		secondItem.clear();
		firstItem.clear();
		third_item.clear();
		fourth_item.clear();
		fifthItem.clear();
		sixItem.clear();

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
