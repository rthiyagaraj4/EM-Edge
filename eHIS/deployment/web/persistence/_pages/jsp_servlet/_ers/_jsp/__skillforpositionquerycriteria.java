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

public final class __skillforpositionquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/SkillForPositionQueryCriteria.jsp", 1709117445806L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block2 ="\n<html>\n<head>\n<link rel=\'stylesheet\' type=\'text/css\'\nhref=\'../../eCommon/html/";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\'></link>\n</head>\n</html>\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

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
 
request.setCharacterEncoding("UTF-8");
String sStyle =
checkForNull((String)session.getAttribute("PREFERRED_STYLE"),
"IeStyle.css"); 
            _bw.write(_wl_block2Bytes, _wl_block2);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block3Bytes, _wl_block3);

	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

	StringBuffer strbuff;
	String function_id = request.getParameter("function_id")==null?"":request.getParameter("function_id");
	Connection con=null ;

	try {
		con = ConnectionManager.getConnection(request);
		String PositionCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.PositionCode.label","rs_labels");
		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();

		firstItem.add("Text");  		 //Type of item
		firstItem.add(PositionCode);	  // label
		firstItem.add("position_code");	//name of field
		firstItem.add("10"); //size
		firstItem.add("10"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

		String PositionDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.PositionDescription.label","rs_labels");
		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");   //Type of item
		secondItem.add(PositionDescription); //label
		secondItem.add("position_desc");//name
		secondItem.add("20"); //size
		secondItem.add("30");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr



		String RoleType= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoleType.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String Practitioner_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels");
		String OtherStaff_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherStaffType.label","common_labels");
		String list_values="%,"+Both_legend+",P,"+Practitioner_legend+",O,"+OtherStaff_legend;
		ArrayList thirdItem = new ArrayList();

		thirdItem.add("List");   //Type of item
		thirdItem.add(RoleType);  // label
		thirdItem.add("role_type");//name
		thirdItem.add(list_values);
		finAr.add(thirdItem); //add to ArrayList obj finAr

		String SkillCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.SkillCode.label","rs_labels");
		
		ArrayList fourthItem = new ArrayList();

		fourthItem.add("Text");   //Type of item
		fourthItem.add(SkillCode);  // label
		fourthItem.add("skill_code");//name
		fourthItem.add("5"); //size
		fourthItem.add("4");  //maxlength
		finAr.add(fourthItem); //add to ArrayList obj finAr
		
		String SkillDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.SkillDescription.label","rs_labels");
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("Text");   //Type of item
		fifthItem.add(SkillDescription);  // label
		fifthItem.add("skill_desc");//name
		fifthItem.add("20"); //size
		fifthItem.add("30");  //maxlength
		finAr.add(fifthItem); //add to ArrayList obj finAr

		ArrayList sixthItem = new ArrayList();
		sixthItem.add("Hidden");  //Type of item
		sixthItem.add("function_id");  // name of field
		sixthItem.add(function_id);   //value of field
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[5];
		String orderByColVals[] = new String[5];

		orderByCols[0] = PositionCode;
		orderByCols[1] = PositionDescription;
		orderByCols[2] = RoleType;
		orderByCols[3] = SkillCode;
		orderByCols[4] = SkillDescription;

		orderByColVals[0] = "position_code";
		orderByColVals[1] = "position_desc";
		orderByColVals[2] = "role_type_desc";
		orderByColVals[3] = "skill_code";
		orderByColVals[4] = "skill_desc";


		String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
		String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
		String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
		String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");

		strbuff = qrypg.getQueryPage(con,finAr,"Find Skill For Position","../jsp/SkillForPositionQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect,orderBy,orderByCols, orderByColVals,ExecuteQuery);

		out.println(strbuff.toString());
	} catch (Exception e) {out.println(e.toString());}
	finally{
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
