package jsp_servlet._eor._jsp;

import java.io.*;
import java.util.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import javax.servlet.jsp.tagext.*;
import java.sql.*;
import java.util.*;
import webbeans.eCommon.*;
import eOR.*;
import eOR.Common.*;
import java.util.*;
import com.ehis.util.*;
import com.ehis.persist.*;
import eCommon.Common.*;
import java.lang.*;
import java.util.*;

public final class __performinglocationquerycriteria extends  weblogic.servlet.jsp.JspBase  implements weblogic.servlet.jsp.StaleIndicator {

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
        if (sci.isResourceStale("/eor/jsp/PerformingLocationQueryCriteria.jsp", 1709119924000L ,"10.3.6.0","Asia/Calcutta")) return true;
        if (sci.isResourceStale("/eCommon/jsp/GetPersistenceBean.jsp", 1717476031037L ,"10.3.6.0","Asia/Calcutta")) return true;
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

    private final static java.lang.String  _wl_block1 ="\n<!--\n--------------------------------------------------------------------------------------------------------------\nDate       Edit History      Name        Description\n--------------------------------------------------------------------------------------------------------------\n?             100            ?           created\n06/09/2011    IN31901        NijithaS    Incident No: IN31901 - Bru-HIMS-CRF-263\t\t \n-------------------------------------------------------------------------------------------------------------------------------------\n-->\n";
    private final static byte[]  _wl_block1Bytes = _getBytes( _wl_block1 );

    private final static java.lang.String  _wl_block2 ="\n";
    private final static byte[]  _wl_block2Bytes = _getBytes( _wl_block2 );

    private final static java.lang.String  _wl_block3 ="\n\n";
    private final static byte[]  _wl_block3Bytes = _getBytes( _wl_block3 );

    private final static java.lang.String  _wl_block4 ="\n<script>\n\t\tvar localeName = \"";
    private final static byte[]  _wl_block4Bytes = _getBytes( _wl_block4 );

    private final static java.lang.String  _wl_block5 ="\";\n</script>\n<script src=\'../../eCommon/js/showModalDialog.js\' language=\'JavaScript\'></script>\n\n";
    private final static byte[]  _wl_block5Bytes = _getBytes( _wl_block5 );

    private final static java.lang.String  _wl_block6 =" \n\n\n";
    private final static byte[]  _wl_block6Bytes = _getBytes( _wl_block6 );

    private final static java.lang.String  _wl_block7 =" \n";
    private final static byte[]  _wl_block7Bytes = _getBytes( _wl_block7 );

    private final static java.lang.String  _wl_block8 =" \n\n";
    private final static byte[]  _wl_block8Bytes = _getBytes( _wl_block8 );

    private final static java.lang.String  _wl_block9 ="\n\t<link rel=\'StyleSheet\' href=\'../../eCommon/html/";
    private final static byte[]  _wl_block9Bytes = _getBytes( _wl_block9 );

    private final static java.lang.String  _wl_block10 ="\' type=\'text/css\'/>\n\t<script src=\'../../eCommon/js/ValidateControl.js\' language=\'javascript\'></script>\n\t\n";
    private final static byte[]  _wl_block10Bytes = _getBytes( _wl_block10 );
	
	/** START FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	public Object getBean(String sessionid,String userid,String ws_no,java.sql.Timestamp session_creation_date,Properties jdbc_props){
		return PersistenceHelper.getBean(sessionid,userid,ws_no,session_creation_date,jdbc_props);
	}
	
	public Object getObjectFromBean(String id,String ClassName,javax.servlet.http.HttpSession session){
		return PersistenceHelper.getObjectFromBean( id,ClassName,session);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpSession session){
		PersistenceHelper.putObjectInBean(id,obj,session);
	}

	/** END FOR GENERIC OBJECTS CORE, CA, OLD ARCHITECTURE **/

	/** START FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/
	public Object getBeanObject(String id,String ClassName,javax.servlet.http.HttpServletRequest request){
		return PersistenceHelper.getBeanObject(id,ClassName,request);
	}

	public void putObjectInBean(String id,Object obj,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.putObjectInBean(id,obj,request);
	}

	public void cleanBeanObject(String id,String className,javax.servlet.http.HttpServletRequest request){
		PersistenceHelper.	cleanBeanObject(id,className,request);
	} 
	/** END FOR GENERIC OBJECTS OR , PH, ST AND NEW ARCHITECTURE **/

	/** START TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/
	public void cleanAll(javax.servlet.http.HttpSession session){
		PersistenceHelper.cleanAll(session);
	}
	/** END TO CLEAN UP THE PERSISTENCE BEAN FOR A USER**/


    static private weblogic.jsp.internal.jsp.JspFunctionMapper _jspx_fnmap = weblogic.jsp.internal.jsp.JspFunctionMapper.getInstance();

    public void _jspService(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) 
    throws javax.servlet.ServletException, java.io.IOException {

        javax.servlet.ServletConfig config = getServletConfig();
        javax.servlet.ServletContext application = config.getServletContext();
        javax.servlet.jsp.tagext.JspTag _activeTag = null;
        java.lang.Object page = this;
        javax.servlet.jsp.PageContext pageContext = javax.servlet.jsp.JspFactory.getDefaultFactory().getPageContext(this, request, response, null, true , 8192 , true );
        response.setHeader("Content-Type", "text/html; charset=UTF-8");
        javax.servlet.jsp.JspWriter out = pageContext.getOut();
        weblogic.servlet.jsp.ByteWriter _bw = (weblogic.servlet.jsp.ByteWriter)out;
        _bw.setInitCharacterEncoding(_WL_ORIGINAL_ENCODING, _WL_ENCODED_BYTES_OK);
        javax.servlet.jsp.JspWriter _originalOut = out;
        javax.servlet.http.HttpSession session = request.getSession( true );
        try {;
            response.setContentType("text/html; charset=UTF-8");
            _bw.write(_wl_block0Bytes, _wl_block0);
            _bw.write(_wl_block1Bytes, _wl_block1);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block3Bytes, _wl_block3);

	String localeName=(String)session.getAttribute("LOCALE") ;
	localeName 		 = (localeName == null )?"en":localeName.toLowerCase();

            _bw.write(_wl_block4Bytes, _wl_block4);
            out.print( String.valueOf(localeName));
            _bw.write(_wl_block5Bytes, _wl_block5);
            _bw.write(_wl_block6Bytes, _wl_block6);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block2Bytes, _wl_block2);
            _bw.write(_wl_block7Bytes, _wl_block7);
            _bw.write(_wl_block8Bytes, _wl_block8);

	String sStyle	= ((session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!=""))?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

            _bw.write(_wl_block9Bytes, _wl_block9);
            out.print( String.valueOf(sStyle));
            _bw.write(_wl_block10Bytes, _wl_block10);

String bean_id		= "performing_location" ;
String bean_name	= "eOR.PerformingLocation";
//String lb_install	= "N";
String rd_install	= "N";

PerformingLocation bean = (PerformingLocation)getBeanObject( bean_id,  bean_name , request) ;
//lb_install = bean.getLbInstall("RL");
rd_install = bean.getLbInstall("RD");
ecis.utils.CommonQueryPage qrypg = new ecis.utils.CommonQueryPage();

StringBuffer strbuff;

Connection con=null ;

try {
	con = ConnectionManager.getConnection(request);

ArrayList finAr = new ArrayList();



ArrayList firstItem = new ArrayList();

firstItem.add("List");   //Type of item
firstItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingDepartmentLocationType.label","or_labels"));  // label
firstItem.add("locn_type");//name
//if (!lb_install.equalsIgnoreCase("Y") && !rd_install.equalsIgnoreCase("Y")) {changed on 7/19/2007 for lab_install chk by uma 
if ( !rd_install.equalsIgnoreCase("Y")) {
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,L,Laboratory Site,R,Radiology Wing,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LaboratorySite.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+"");
//} else  if (!lb_install.equalsIgnoreCase("N") && !rd_install.equalsIgnoreCase("Y")) {changed on 7/19/2007 for labinstall check by uma
} else  if ( !rd_install.equalsIgnoreCase("Y")) {  // lab installed
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,R,Radiology Wing,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",R,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RadiologyWing.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+"");
//} else  if (!lb_install.equalsIgnoreCase("Y") && !rd_install.equalsIgnoreCase("N")) { changed on 7/19/2007 for labinstall check by uma  // rd installed
} else  if ( !rd_install.equalsIgnoreCase("N")) {  // rd installed
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,L,Laboratory Site,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+" ---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",L,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.LaboratorySite.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+",O,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.NonOTRooms.label","or_labels")+"");//IN31901
} else {
	//firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- Select ---&nbsp;&nbsp;&nbsp;,I,Departmental Diagnostics,P,Patient Care,T,Treatment Location,M,Miscellaneous Service Location");
	firstItem.add(" ,&nbsp;&nbsp;&nbsp;--- "+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels")+"---&nbsp;&nbsp;&nbsp;,I,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.DepartmentalDiagnostics.label","or_labels")+",M,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.MiscellaneousService Location.label","or_labels")+",P,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientCare.label","common_labels")+",T,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.TreatmentLocation.label","or_labels")+"");
}
finAr.add(firstItem); //add to ArrayList obj finAr


ArrayList secondItem = new ArrayList();

secondItem.add("Text");   //Type of item
secondItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingDepartmentLocationCode.label","or_labels"));  // label
secondItem.add("code");//name
secondItem.add("4");
secondItem.add("4");
finAr.add(secondItem); //add to ArrayList obj finAr


ArrayList thirdItem = new ArrayList();

thirdItem.add("Text");   //Type of item
thirdItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOR.PerformingDepartmentLocationDesc.label","or_labels"));  // label
thirdItem.add("long_desc");//name
thirdItem.add("30");
thirdItem.add("30");
finAr.add(thirdItem); //add to ArrayList obj finAr


ArrayList fifthItem=new ArrayList();
fifthItem.add("List");  //Type of item
fifthItem.add(com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Nature.label","common_labels"));  // label
fifthItem.add("eff_status");   //name of field
fifthItem.add("%,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Both.label","common_labels")+",E,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.enabled.label","common_labels")+",D,"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Disabled.label","common_labels")+"");//static values that need to be displayed as option.Send it along with the value that is inserted.
fifthItem.add("7");	//LENGTH
finAr.add(fifthItem); //add to ArrayList obj finAr

String orderByCols[] = new String[3];
String orderByColVals[] = new String[3];

orderByCols[0] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.locationtype.label","common_labels");
orderByCols[1] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.code.label","common_labels");
orderByCols[2] = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.description.label","common_labels");


orderByColVals[0] = "performing_deptloc_type";
orderByColVals[1] = "performing_deptloc_code";
orderByColVals[2] = "performing_deptloc_short_desc";


strbuff = qrypg.getQueryPage(con,finAr,"Find Occupation","../jsp/PerformingLocationQueryResults.jsp",com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SortOrder.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.QueryCriteria.label","common_labels"),com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.defaultSelect.label","common_labels") ,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.orderBy.label","common_labels"),orderByCols, orderByColVals,com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ExecuteQuery.label","common_labels"));

out.println(strbuff.toString());
strbuff.setLength(0);

} catch (Exception e) {System.out.println(e.toString());}
finally{
	if(con!=null)
		ConnectionManager.returnConnection(con,request);
}

            _bw.write(_wl_block3Bytes, _wl_block3);

	putObjectInBean(bean_id,bean,request);

            _bw.write(_wl_block3Bytes, _wl_block3);
        } catch (java.lang.Throwable __ee){
            if(!(__ee instanceof javax.servlet.jsp.SkipPageException)) {
                while ((out != null) && (out != _originalOut)) out = pageContext.popBody(); 
                _releaseTags(pageContext, _activeTag);
                pageContext.handlePageException(__ee);
            }
        }
    }
}
