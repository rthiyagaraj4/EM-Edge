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

public final class __staffforworkplacequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/StaffForWorkplaceQueryCriteria.jsp", 1709117446462L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\'\nhref=\'../../eCommon/html/";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\'></link>\n</head>\n</html>\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

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
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block1Bytes, _wl_block1);
 request.setCharacterEncoding("UTF-8");
String locale			= (String)session.getAttribute("LOCALE");
String sStyle =
checkForNull((String)session.getAttribute("PREFERRED_STYLE"),
"IeStyle.css"); 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
Connection con=null ;
	PreparedStatement pstmt 	= null;
	ResultSet resultSet 		= null;
	ArrayList Locn_Data		= new ArrayList() ;

	String[] record				= null;
	//String sql_locn="Select locn_type, short_desc from am_care_locn_type order by short_desc";
	String sql_locn="Select locn_type, short_desc from am_care_locn_type_lang_vw where language_id = ? order by short_desc";

	try {

		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement( sql_locn);
		pstmt.setString(1,locale);
		resultSet = pstmt.executeQuery() ;
		while (resultSet != null && resultSet.next()) {
			record = new String[2];				
			record[0] = resultSet.getString("locn_type");
			record[1] = resultSet.getString("short_desc");
			Locn_Data.add(record) ;
		}
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
 String locationtype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
 String al1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");

		ArrayList finAr = new ArrayList();

		ArrayList ZeroItem = new ArrayList();

		ZeroItem.add("List");  		 //Type of item
		ZeroItem.add(locationtype);	  // label
		ZeroItem.add("locn_type");	//name of field
		String strList = " "+","+"----"+al1+"----"+",";
		for(int k=0;k<Locn_Data.size();k++)	{
			record=(String[])Locn_Data.get(k);
			strList = strList + (String)record[0] + ","+(String)record[1]+",";
		} 
		

		ZeroItem.add(strList);
		ZeroItem.add("5");
		finAr.add(ZeroItem); //add to ArrayList obj finAr
String WorkplaceCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceCode.label","rs_labels");

		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(WorkplaceCode);	  // label
		firstItem.add("WORKPLACE_CODE");	//name of field
		firstItem.add("10"); //size
		firstItem.add("10"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

String WorkplaceDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.WorkplaceDescription.label","rs_labels");

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");   //Type of item
		secondItem.add(WorkplaceDescription); //label
		secondItem.add("workplace_desc");//name
		secondItem.add("20"); //size
		secondItem.add("30");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr

String Role= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Role.label","common_labels");

String practitioner= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
String OtherStaff= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaff.label","common_labels");
String all= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.all.label","common_labels");



		ArrayList thirdItem = new ArrayList();

		thirdItem.add("List");   //Type of item
		thirdItem.add(Role);  // label
		thirdItem.add("role_type");//name
		//String strList1 = "%"+","+"----all----"+",";
		String strList1 = "%"+","+all+",";
		strList1 = strList1+"P"+","+practitioner+",";
		strList1 = strList1+"O"+","+OtherStaff+",";
		thirdItem.add(strList1);
		finAr.add(thirdItem); //add to ArrayList obj finAr

String StaffId= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.StaffId.label","rs_labels");

		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");   //Type of item
		fourthItem.add(StaffId);  // label
		fourthItem.add("staff_id");//name
		fourthItem.add("15"); //size
		fourthItem.add("15");  //maxlength
		finAr.add(fourthItem); //add to ArrayList obj finAr
String StaffName= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.StaffName.label","rs_labels");


		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");   //Type of item
		fifthItem.add(StaffName);  // label
		fifthItem.add("staff_name");//name
		fifthItem.add("30"); //size
		fifthItem.add("30");  //maxlength
		finAr.add(fifthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[6];
		String orderByColVals[] = new String[6];

		orderByCols[0] = locationtype;
		orderByCols[1] = WorkplaceCode;
		orderByCols[2] = WorkplaceDescription;
		orderByCols[3] = Role;
		orderByCols[4] = StaffId;
		orderByCols[5] = StaffName;

		orderByColVals[0] = "locn_desc";
		orderByColVals[1] = "workplace_code";
		orderByColVals[2] = "workplace_desc";
		orderByColVals[3] = "role";
		orderByColVals[4] = "staff_id";
		orderByColVals[5] = "staff_name";


		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

		String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
		String FindSkillForPosition=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindSkillForPosition.label","RS_labels");





		
		strbuff = qrypg.getQueryPage(con,finAr,FindSkillForPosition,"../jsp/StaffForWorkplaceQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());

	} catch (Exception e) {
		e.printStackTrace() ;
		throw e ;
	}
	finally{
		if(pstmt != null)
			pstmt.close();
		if(resultSet != null)
			resultSet.close();
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
