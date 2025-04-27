package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;
import eCommon.XSSRequestWrapper;

public final class __timetablequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/TimeTableQueryCriteria.jsp", 1709117112216L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n \n<!--\n\tDeveloped by \t:\tR.Nanda Kumar\n\tCreated on \t:\t26/02/2001\n\tModule\t\t:\tOA\n\tFunction\t:\n-->\n\n";
    private final static byte[]  _wl_block0Bytes = _getBytes( _wl_block0 );

    private final static java.lang.String  _wl_block1 ="\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link></head></html>\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

			request.setCharacterEncoding("UTF-8");
			request= new XSSRequestWrapper(request);
			response.addHeader("X-XSS-Protection", "1; mode=block");
			response.addHeader("X-Content-Type-Options", "nosniff");
			ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
			String fmode = request.getParameter("mode") ;
			StringBuffer strbuff;
			Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();
	ArrayList veryFirstItem =new ArrayList();
	veryFirstItem.add("List");
	veryFirstItem.add("Location");
	veryFirstItem.add("care_locn_type_ind");
	veryFirstItem.add("Select care_locn_type_ind, Short_Desc from am_care_locn_type where sys_user_def_ind = 'S' and locn_type in ('C','E','Y') order by 2");
	finAr.add(veryFirstItem);


	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add("Location Code");	  // label
	firstItem.add("clinic_code");	//name of field
	firstItem.add("4");	// SIZE
	firstItem.add("4");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add("Location Description");  // label
	secondItem.add("clinic_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList enhancedItem = new ArrayList();
	enhancedItem.add("List");
	enhancedItem.add("Resource Class");
	enhancedItem.add("resource_class");
	enhancedItem.add("0,  ---Select---  ,P,Practitioner,E,Equipment,R,Room,O,Other");
	finAr.add(enhancedItem);

	ArrayList thirdItem=new ArrayList();

	thirdItem.add("Text");  //Type of item
	thirdItem.add("Resource Id");  // label
	thirdItem.add("practitioner_id");   //name of field
	thirdItem.add("15");	// SIZE
	thirdItem.add("15");	//LENGTH

	finAr.add(thirdItem); //add to ArrayList obj finAr

	ArrayList fourthItem=new ArrayList();

	fourthItem.add("Text");  //Type of item
	fourthItem.add("Resource");  // label
	fourthItem.add("practitioner_name");   //name of field
	fourthItem.add("30");	// SIZE
	fourthItem.add("30");	//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();

	fifthItem.add("List");  //Type of item
	fifthItem.add("Day Code");  // label
	fifthItem.add("day_code");   //name of field
	fifthItem.add("select day_no,day_of_week from sm_day_of_week order by 1");



	finAr.add(fifthItem); //add to ArrayList obj finAr

	ArrayList sixthItem=new ArrayList();

	sixthItem.add("List");  //Type of item
	sixthItem.add("Time Table Type");  // label
	sixthItem.add("time_table_type");   //name of field
	sixthItem.add("0, --- Select --- ,1,Slot,2,Slab,3,Free Format");

	finAr.add(sixthItem); //add to ArrayList obj finAr

	ArrayList seventhItem=new ArrayList();

	seventhItem.add("List");  //Type of item
	seventhItem.add("Roster Required");  // label
	seventhItem.add("phys_roster_reqd_yn");   //name of field
	seventhItem.add("0, --- Select --- ,Y,Yes,N,No");

	finAr.add(seventhItem); //add to ArrayList obj finAr


	String orderByCols[] = new String[8];
	String orderByColVals[] = new String[8];
	orderByCols[0] = "Location";
	orderByCols[1] = "Resource Class";
	orderByCols[2] = "Location Code";
	orderByCols[3] = "Location Desc";
	orderByCols[4] = "ResourceId";
	orderByCols[5] = "ResourceName";
	orderByCols[6] = "Day Code";
	orderByCols[7] = "Time Table Type";
	orderByColVals[0] = "care_locn_type_ind";
	orderByColVals[1] = "resource_class";
	orderByColVals[2] = "clinic_code";
	orderByColVals[3] = "clinic_name";
	orderByColVals[4] = "practitioner_id";
	orderByColVals[5] = "practitioner_name";
	orderByColVals[6] = "day_no";
	orderByColVals[7] = "time_table_type";
	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"eCIS Testing","../../eOA/jsp/TimeTableQueryResult.jsp?mode="+fmode,"Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

	out.println(strbuff.toString());
	strbuff.setLength(0);
	finAr.clear();
	veryFirstItem.clear();
	firstItem.clear();
	secondItem.clear();
	enhancedItem.clear();
	thirdItem.clear();
	fourthItem.clear();
	fifthItem.clear();
	sixthItem.clear();
	seventhItem.clear();

} catch (Exception e) {
	//out.println(e);
	 e.printStackTrace();//Added by Kamatchi S for security issue against COMMON-ICN-0165
}finally{
	ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block4Bytes, _wl_block4);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
