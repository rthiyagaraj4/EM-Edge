package jsp_servlet._eoa._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.util.*;
import com.ehis.util.*;
import java.sql.*;
import webbeans.eCommon.*;
import java.util.*;

public final class __practdutyrosterquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eoa/jsp/PractDutyRosterQueryCriteria.jsp", 1715321864272L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block5 =" \n \n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 ="\n\n\t<html><head><link rel=\'stylesheet\' type=\'text/css\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 ="\'></link></head></html>\n\n";
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
            _bw.write(_wl_block2Bytes, _wl_block2);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block3Bytes, _wl_block3);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block4Bytes, _wl_block4);
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block1Bytes, _wl_block1);

String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block6Bytes, _wl_block6);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block7Bytes, _wl_block7);

request.setCharacterEncoding("UTF-8");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();
StringBuffer strbuff;
Connection con=null ;
String locale=(String)session.getAttribute("LOCALE");


try {
	con = ConnectionManager.getConnection(request);

	ArrayList finAr = new ArrayList();

	ArrayList veryFirstItem =new ArrayList();
	veryFirstItem.add("List");
	veryFirstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels"));
	veryFirstItem.add("care_locn_type_ind");
	veryFirstItem.add("select care_locn_type_ind,short_desc from am_care_locn_type_lang_vw where language_id ='"+locale+"' and SYS_USER_DEF_IND='S' and locn_type in ('C','E','Y')  order by short_desc");
	finAr.add(veryFirstItem);

	ArrayList firstItem = new ArrayList();

	firstItem.add("Text");  		 //Type of item
	firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels"));	  // label
	firstItem.add("clinic_code1");	//name of field
	firstItem.add("15");	// SIZE
	firstItem.add("15");	//LENGTH

	finAr.add(firstItem);//add to ArrayList obj finAr

	ArrayList secondItem=new ArrayList();

	secondItem.add("Text");  //Type of item
	secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels"));  // label
	secondItem.add("clinic_desc");   //name of field
	secondItem.add("15");	// SIZE
	secondItem.add("15");	//LENGTH

	finAr.add(secondItem); //add to ArrayList obj finAr

	ArrayList enhancedItem = new ArrayList();
	enhancedItem.add("List");
	enhancedItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels"));
	enhancedItem.add("resource_class");
	enhancedItem.add("0,  ---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---  ,P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.equipment.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.room.label","common_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.other.label","common_labels")+" ");
	finAr.add(enhancedItem);


	ArrayList thirdItem = new ArrayList();
	thirdItem.add("Text");
	thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels"));
	thirdItem.add("practitioner_Id");
	thirdItem.add("15"); 
	thirdItem.add("15");
	finAr.add(thirdItem);

	ArrayList fourthItem = new ArrayList();

	fourthItem.add("Text");  //Type of item
	fourthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourcename.label","common_labels"));  // label
	fourthItem.add("practitioner_name");   //name of field
	fourthItem.add("15");	// SIZE
	fourthItem.add("15");	//LENGTH

	finAr.add(fourthItem); //add to ArrayList obj finAr

	ArrayList fifthItem=new ArrayList();

	fifthItem.add("List");   //Type of item
	fifthItem.add( com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dayofweek.label","common_labels"));  // label
	fifthItem.add("day_of_week");//name
	fifthItem.add("'',---"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"----,1,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sun.label","common_labels")+",2,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.mon.label","common_labels")+",3,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.tue.label","common_labels")+",4,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.wed.label","common_labels")+",5,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.thu.label","common_labels")+",6,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fri.label","common_labels")+",7,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.sat.label","common_labels")+"");//static values that need to be displayed as amtion.Send it along with the value that is inserted.
	finAr.add(fifthItem); //add to ArrayList obj finAr

	String orderByCols[] = new String[6];
	String orderByColVals[] = new String[6];

	orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Location.label","common_labels");
	orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationcode.label","common_labels");
	orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.LocationDescription.label","common_labels");
	orderByCols[3] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.dayofweek.label","common_labels");
	orderByCols[4] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceid.label","common_labels");
	orderByCols[5] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.resourceclass.label","common_labels");

	orderByColVals[0] = "CARE_LOCN_TYPE_IND";
	orderByColVals[1] = "CLINIC_CODE";
	orderByColVals[2] = "CLINIC_NAME";
	orderByColVals[3] = "ON_DUTY_DATE";
	orderByColVals[4] = "PRACTITIONER_ID";
	orderByColVals[5] = "RESOURCE_CLASS";

	strbuff = qrypg.getMultiColumnQueryPage(con,finAr,"PractDutyRoster","../../eOA/jsp/PractDutyRosterQueryResult.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

	out.println(strbuff.toString().replace("nowrap",""));
	strbuff.setLength(0);
	finAr.clear();
veryFirstItem.clear();
firstItem.clear();
secondItem.clear();
enhancedItem.clear();
thirdItem.clear();
fourthItem.clear();
fifthItem.clear();
} catch (Exception e){
	//out.println(e);
	e.printStackTrace();
}
finally { 
	if(con!=null) ConnectionManager.returnConnection(con,request);
}	


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
