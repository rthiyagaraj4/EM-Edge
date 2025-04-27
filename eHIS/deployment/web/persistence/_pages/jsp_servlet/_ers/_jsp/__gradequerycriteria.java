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

public final class __gradequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ers/jsp/GradeQueryCriteria.jsp", 1709117438041L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block0 ="<!DOCTYPE html>\n<!--GradeQueryCriteria.jsp\n*\tCopyright � MEDICOM Solutions (P) Ltd. ALL RIGHTS RESERVED\n*\tApplication\t\t:\teRS\n*\tPurpose \t\t\t:\n*\tCreated By\t\t:\tJanet George\n*\tCreated On\t\t:\t13 Jan 2005-->\n";
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
String sStyle	=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
            _bw.write(_wl_block5Bytes, _wl_block5);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block6Bytes, _wl_block6);
	ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
	StringBuffer strbuff;
	Connection con=null ;
	try {
    	con = ConnectionManager.getConnection(request);


		String GradeCode= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.GradeCode.label","rs_labels");

		ArrayList finAr = new ArrayList();
		ArrayList firstItem = new ArrayList();
		firstItem.add("Text");  		 //Type of item
		firstItem.add(GradeCode);	  // label
		firstItem.add("grade_code");	//name of field
		firstItem.add("4"); //size
		firstItem.add("4"); //maxlength
		finAr.add(firstItem); //add to ArrayList obj finAr

     String GradeDescription= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.GradeDescription.label","rs_labels");

		ArrayList secondItem = new ArrayList();
		secondItem.add("Text");   //Type of item
		secondItem.add(GradeDescription); //label
		secondItem.add("grade_desc");//name
		secondItem.add("30"); //size
		secondItem.add("30");  //maxlength
		finAr.add(secondItem); //add to ArrayList obj finAr

	String Level= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.Level.label","rs_labels");

        ArrayList thirdItem = new ArrayList();
		thirdItem.add("Text");   //Type of item
		thirdItem.add(Level); //label
		thirdItem.add("grade_level");//name
		thirdItem.add("3"); //size
		thirdItem.add("3");  //maxlength
		finAr.add(thirdItem); //add to ArrayList obj finAr

      String Yes= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.yes.label","common_labels");
	  String No = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.no.label","common_labels");
		

		String list_values="Y,"+Yes+",N,"+No;  



String ConsiderforScheduling= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.ConsiderforScheduling.label","RS_labels");
		ArrayList fourthItem = new ArrayList();
		fourthItem.add("List");  //Type of item
		fourthItem.add(ConsiderforScheduling);  // name of field
		fourthItem.add("allow_scheduling_yn");   //value of field
		fourthItem.add(list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(fourthItem); //add to ArrayList obj finAr

	String FTHours= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FTHours.label","rs_labels");
        ArrayList fifthItem = new ArrayList();
		fifthItem.add("Text");   //Type of item
		fifthItem.add(FTHours); //label
		fifthItem.add("ft_work_hours");//name
		fifthItem.add("4"); //size
		fifthItem.add("3");  //maxlength
		finAr.add(fifthItem); //add to ArrayList obj finAr


		String Nature= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels");
		String Both_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels");
		String enabled_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Enable.label","common_labels");
		String Disable_legend = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels");

		String ADR_list_values="%,"+Both_legend+",E,"+enabled_legend+",D,"+Disable_legend;




		ArrayList sixthItem = new ArrayList();
		sixthItem.add("List");   //Type of item
		sixthItem.add(Nature);  // label
		sixthItem.add("eff_status");//name
		sixthItem.add(ADR_list_values);//static values that need to be displayed as option.Send it along with the value that is inserted.
		finAr.add(sixthItem); //add to ArrayList obj finAr

		String orderByCols[] = new String[3];
		String orderByColVals[] = new String[3];
		orderByCols[0] = GradeCode;
		orderByCols[1] = GradeDescription;
		orderByCols[2] = Level;

		orderByColVals[0] = "grade_code";
		orderByColVals[1] = "grade_desc";
		orderByColVals[2] = "grade_level";

String SortOrder = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels");
String orderBy=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels");
String QueryCriteria=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels");
String ExecuteQuery=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels");

String defaultSelect = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels");
String FindGrade=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eRS.FindGrade.label","RS_labels");

  strbuff = qrypg.getQueryPage(con,finAr,FindGrade,"GradeQueryResult.jsp",SortOrder,QueryCriteria,defaultSelect ,orderBy,orderByCols, orderByColVals,ExecuteQuery);
		out.println(strbuff.toString());

	} catch (Exception e)
	{
		out.println(e.toString());
	}
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
