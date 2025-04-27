package jsp_servlet._ers._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eRS.*;
import eCommon.Common.*;
import java.util.*;
import com.ehis.util.*;

public final class __shiftpatternquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/ShiftPatternQueryCriteria.jsp", 1709117445337L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/Common.jsp", 1723025507010L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t:\n*\tCreated By\t\t:\tSubbulakshmy. K\n*\tCreated On\t\t:\t29 Oct 04\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 =" \n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\'\nhref=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link>\n</head>\n</html>\n";
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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);

	eCommon.Common.CommonMultipleHandler mh = null ;
	try {
		if(session.getAttribute("mh" ) == null  ) {
			mh = new  eCommon.Common.CommonMultipleHandler();
			session.setAttribute( "mh",mh ) ;
		}
        else {
            mh = ( eCommon.Common.CommonMultipleHandler )session.getAttribute("mh" ) ;
        }
    } catch(Exception e) {
		session.removeValue("mh") ;
		mh = new  eCommon.Common.CommonMultipleHandler();
		session.setAttribute( "mh",mh ) ;    
    }

            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block3Bytes, _wl_block3);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);
request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	String function_id = request.getParameter("function_id");

	Connection con=null ;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Locn_Data		= new ArrayList() ;

	String[] record				= null;
	//String sql_locn="select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";

	try {

		con = ConnectionManager.getConnection(request);




		ArrayList finAr = new ArrayList();

		pstmt = con.prepareStatement( sql_locn);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
	
String ShiftPatternID= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ShiftPatternID.label","rs_labels");

	ArrayList firstItem = new ArrayList();
	firstItem.add("Text");  		 //Type of item
	firstItem.add(ShiftPatternID);	  // label
	firstItem.add("shift_pattern_id");	//name of field
	firstItem.add("15"); //size
	firstItem.add("10"); //maxlength
	finAr.add(firstItem); //add to ArrayList obj finAr
	

String shortdescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.shortdescription.label","common_labels");


	ArrayList secondItem = new ArrayList();
	secondItem.add("Text");   //Type of item
	secondItem.add(shortdescription); //label
	secondItem.add("short_desc");//name
	secondItem.add("20"); //size
	secondItem.add("15");  //maxlength
	finAr.add(secondItem); //add to ArrayList obj finAr
	
String locationtype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
String all= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("List");   //Type of item
	thirdItem.add(locationtype);  // label
	thirdItem.add("locn_type");//name
	//String strList = " "+","+"----All----"+",";
	String strList = " "+","+all+",";
	for(int k=0;k<Locn_Data.size();k++)	{
		record=(String[])Locn_Data.get(k);
		strList = strList + (String)record[0] + ","+(String)record[1]+",";
	}
	thirdItem.add(strList);

	thirdItem.add("5"); //size
	finAr.add(thirdItem); //add to ArrayList obj finAr

		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");
		String list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disable_legend;

	ArrayList fourthItem = new ArrayList();
	fourthItem.add("List");   //Type of item
	fourthItem.add(Nature);// label
	fourthItem.add("eff_status");//name
	fourthItem.add(list_values);//static values that need to be displayed as option.
	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem = new ArrayList();
	fifthItem.add("Hidden");  //Type of item
	fifthItem.add("function_id");  // name of field
	fifthItem.add(function_id);   //value of field
	finAr.add(fifthItem); //add to ArrayList obj finAr


String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String FindShiftPattern=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindShiftPattern.label","RS_labels");





	String orderByCols[] = new String[3];
	String orderByColVals[] = new String[3];
	orderByCols[0] = ShiftPatternID;
	//orderByCols[1] = "Shift Pattern Description";
	orderByCols[1] = shortdescription;
	orderByCols[2] = locationtype;
	orderByColVals[0] = "shift_pattern_id";
	orderByColVals[1] = "short_desc";
	orderByColVals[2] = "a.locn_type";

	strbuff = qrypg.getQueryPage(con,finAr,FindShiftPattern,"../jsp/ShiftPatternQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
	out.println(strbuff.toString());

	} catch (Exception e) {
		out.println(e.toString());
	}	finally{
		if(resultSet!=null) resultSet.close() ;
		if(pstmt!=null) pstmt.close() ;
		ConnectionManager.returnConnection(con,request);
	}

            _bw.write(_wl_block1Bytes, _wl_block1);
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
