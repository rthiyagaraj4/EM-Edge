package jsp_servlet._eae._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import oracle.jdbc.driver.*;
import webbeans.eCommon.ConnectionManager;
import java.util.*;
import com.ehis.util.*;

public final class __ambvechilequerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eae/jsp/AMBVechileQueryCriteria.jsp", 1709113871100L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/CommonInclude.jsp", 1727947024020L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block3 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\n<head>\n\t";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\' type=\'text/css\' />\n</head>\n\n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 ="\n<SCRIPT LANGUAGE=\"JavaScript\">\n//parent.commontoolbarFrame.document.getElementById(\"apply\").disabled = true;\n</SCRIPT>\n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

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

		String sStyle =
		(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
	
            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;
String amb_type=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eAE.AmbulanceType.label","ae_labels");
String id=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.identification.label","common_labels");
String des=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");
String reg_no=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.registrationno.label","common_labels");
Connection con=null ;

try
	{

		con  =  ConnectionManager.getConnection(request);


		ArrayList finAr = new ArrayList();

		ArrayList firstItem = new ArrayList();
		firstItem.add("List");           //Type of item
		firstItem.add(amb_type);     // label
		firstItem.add("amb_vehicle_type");   //name of field
		firstItem.add("'',ALL,A,Air Ambulance,M,Marine Ambulance,R,Road Ambulance"); // SIZE
		finAr.add(firstItem);//add to ArrayList obj finAr

		ArrayList secondItem = new ArrayList();

		secondItem.add("Text");          //Type of item
		secondItem.add(id);    // label
		secondItem.add("amb_veh_id");  //name of field
		secondItem.add("10");   // SIZE
		secondItem.add("10");   //LENGTH
		finAr.add(secondItem);    //add to ArrayList obj finAr

		ArrayList thirdItem = new ArrayList();

		thirdItem.add("Text");          //Type of item
		thirdItem.add(des);    // label
		thirdItem.add("amb_veh_desc");  //name of field
		thirdItem.add("30");   // SIZE
		thirdItem.add("30");   //LENGTH
		finAr.add(thirdItem);    //add to ArrayList obj finAr
		
		ArrayList forthItem = new ArrayList();

		forthItem.add("Text");          //Type of item
		forthItem.add(reg_no);    // label
		forthItem.add("amb_veh_regnno");  //name of field
		forthItem.add("20");   // SIZE
		forthItem.add("20");   //LENGTH
		finAr.add(forthItem);    //add to ArrayList obj finAr
		
		ArrayList fifthItem = new ArrayList();

		fifthItem.add("List");   //Type of item
		fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
		fifthItem.add("eff_status");//name
		fifthItem.add("B," +com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels"));
		finAr.add(fifthItem); //add to ArrayList obj finAr


			String[] orderByCols = null;
			String[] orderByColVals = null;


			orderByCols = new String[4];
			orderByColVals = new String[4];


			orderByCols[0] = amb_type;
			orderByCols[1] = id;
			orderByCols[2] = des;
			orderByCols[3] = reg_no;
	

			orderByColVals[0] = "amb_vehicle_type";
			orderByColVals[1] = "AMB_VEHICLE_ID";
			orderByColVals[2] = "AMB_VEHICLE_NAME";
			orderByColVals[3] = "AMB_REGN_NO";

			strbuff = qrypg.getQueryPage(con,finAr,"NoteGroup","../../eAE/jsp/AMBVehicleQueryResult.jsp","Sort Order","Query Criteria","Select" ,"Order By",orderByCols, orderByColVals,"Execute Query");

		out.println(strbuff.toString());
			finAr.clear();
		firstItem.clear();
		secondItem.clear();
		thirdItem.clear();
		forthItem.clear();
		fifthItem.clear();
	
} 

catch (Exception e) 
{
	//out.println("Exception@1: "+e.toString());
	e.printStackTrace();
}

finally
{
	if(con!=null) ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block8Bytes, _wl_block8);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
