package jsp_servlet._ecp._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import webbeans.eCommon.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;

public final class __staffrequirementquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/ecp/jsp/StaffRequirementQueryCriteria.jsp", 1709116532216L ,"10.3.6.0","Asia/Calcutta")) return true;
        return false;
    }

    private static boolean _WL_ENCODED_BYTES_OK = true;
    private static final java.lang.String _WL_ORIGINAL_ENCODING = "ISO-8859-1".intern();

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

    private final static java.lang.String  _wl_block3 ="\n<link rel=\'stylesheet\' type=\'text/css\'href=\'../../eCommon/html/";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\'></link>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

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
        response.setHeader("Content-Type", "text/html");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
 String sStyle =checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css"); 
            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block4Bytes, _wl_block4);

//This file is saved on 18/10/2005.
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;

Connection con=null ;
try {
con = ConnectionManager.getConnection(request);





ArrayList finAr = new ArrayList();

ArrayList firstItem = new ArrayList();

firstItem.add("List");  		//Type of item
firstItem.add("Dependency");	// label
firstItem.add("dependency_code");	//name of field
firstItem.add("Select dependency_code,long_desc from cp_dependency where eff_status='E' order by long_desc");	
finAr.add(firstItem);			//add to ArrayList obj finAr
//out.println(finAr);
ArrayList secondItem = new ArrayList();

secondItem.add("Text");  		 //Type of item
secondItem.add("Workplace Code");	 // label
secondItem.add("workplace_code");	 //name of field
secondItem.add("10");			 // SIZE
secondItem.add("10");			 //LENGTH
finAr.add(secondItem);			 //add to ArrayList obj finAr

ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   		 //Type of item
thirdItem.add("Workplace Description");        // label
thirdItem.add("workplace_desc");   	 	 //name
thirdItem.add("30");			 // SIZE
thirdItem.add("30");			 //LENGTH
finAr.add(thirdItem); 			 //add to ArrayList obj finAr


ArrayList fourthItem = new ArrayList();

fourthItem.add("List");  		//Type of item
fourthItem.add("Shift");	// label
fourthItem.add("shift_code");	//name of field
fourthItem.add("select  shift_code,long_desc from am_shift");
finAr.add(fourthItem);			 //add to ArrayList obj finAr

ArrayList fifthItem = new ArrayList();

fifthItem.add("Text");   		 //Type of item
fifthItem.add("Position Code");        // label
fifthItem.add("position_code");   	 	 //name
fifthItem.add("10");			 // SIZE
fifthItem.add("10");			 //LENGTH
finAr.add(fifthItem); 			 //add to ArrayList obj finAr

ArrayList sixthItem = new ArrayList();

sixthItem.add("Text");   		 //Type of item
sixthItem.add("Position Description");        // label
sixthItem.add("position_desc");   	 	 //name
sixthItem.add("30");			 // SIZE
sixthItem.add("30");			 //LENGTH
finAr.add(sixthItem); 			 //add to ArrayList obj finAr


String orderByCols[] 	= new String[6];
String orderByColVals[] = new String[6];


orderByCols[0] = "Dependency";
orderByCols[1] = "Workplace Code";
orderByCols[2] = "Workplace description";
orderByCols[3] = "Shift";
orderByCols[4] = "Position Code";
orderByCols[5] = "Position Description";

orderByColVals[0] = "dependency_code";
orderByColVals[1] = "workplace_code";
orderByColVals[2] = "worplplace_desc";
orderByColVals[3] = "shift_code";
orderByColVals[4] = "position_code";
orderByColVals[5] = "position_desc";



strbuff = qrypg.getQueryPage(con,finAr,"FindStaffRequirement","../jsp/StaffRequirementQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order by",orderByCols, orderByColVals,"Execute Query");

out.println(strbuff.toString());
	} catch ( Exception e )	{
		e.printStackTrace() ;
		throw e ;
	} finally {
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
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
